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


//<editor-fold defaultstate="collapsed" desc="static type VectorUtilsLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.VectorUtilsLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm13getSplatValueEPKNS_5ValueE;_ZN4llvm16getUniqueCastUseEPNS_5ValueEPNS_4LoopEPNS_4TypeE;_ZN4llvm17findScalarElementEPNS_5ValueEj;_ZN4llvm17propagateMetadataEPNS_11InstructionENS_8ArrayRefIPNS_5ValueEEE;_ZN4llvm18stripGetElementPtrEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE;_ZN4llvm20getStrideFromPointerEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE;_ZN4llvm22getGEPInductionOperandEPKNS_17GetElementPtrInstE;_ZN4llvm23isTriviallyVectorizableENS_9Intrinsic2IDE;_ZN4llvm24computeMinimumValueSizesENS_8ArrayRefIPNS_10BasicBlockEEERNS_12DemandedBitsEPKNS_19TargetTransformInfoE;_ZN4llvm27getVectorIntrinsicIDForCallEPKNS_8CallInstEPKNS_17TargetLibraryInfoE;_ZN4llvm28hasVectorInstrinsicScalarOpdENS_9Intrinsic2IDEj; -static-type=VectorUtilsLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class VectorUtilsLlvmGlobals {


/// \brief Identify if the intrinsic is trivially vectorizable.
/// This method returns true if the intrinsic's argument types are all
/// scalars for the scalar form of the intrinsic and all vectors for
/// the vector form of the intrinsic.

/// \brief Identify if the intrinsic is trivially vectorizable.
/// This method returns true if the intrinsic's argument types are all
/// scalars for the scalar form of the intrinsic and all vectors for
/// the vector form of the intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::isTriviallyVectorizable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 34,
 FQN="llvm::isTriviallyVectorizable", NM="_ZN4llvm23isTriviallyVectorizableENS_9Intrinsic2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm23isTriviallyVectorizableENS_9Intrinsic2IDE")
//</editor-fold>
public static boolean isTriviallyVectorizable(/*Intrinsic.ID*/int ID) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Identifies if the intrinsic has a scalar operand. It checks for
/// ctlz,cttz and powi special intrinsics whose argument is scalar.

/// \brief Identifies if the intrinsic has a scalar operand. It check for
/// ctlz,cttz and powi special intrinsics whose argument is scalar.
//<editor-fold defaultstate="collapsed" desc="llvm::hasVectorInstrinsicScalarOpd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 71,
 FQN="llvm::hasVectorInstrinsicScalarOpd", NM="_ZN4llvm28hasVectorInstrinsicScalarOpdENS_9Intrinsic2IDEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm28hasVectorInstrinsicScalarOpdENS_9Intrinsic2IDEj")
//</editor-fold>
public static boolean hasVectorInstrinsicScalarOpd(/*Intrinsic.ID*/int ID, 
                            /*uint*/int ScalarOpdIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns intrinsic ID for call.
/// For the input call instruction it finds mapping intrinsic and returns
/// its intrinsic ID, in case it does not found it return not_intrinsic.

/// \brief Returns intrinsic ID for call.
/// For the input call instruction it finds mapping intrinsic and returns
/// its ID, in case it does not found it return not_intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::getVectorIntrinsicIDForCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 86,
 FQN="llvm::getVectorIntrinsicIDForCall", NM="_ZN4llvm27getVectorIntrinsicIDForCallEPKNS_8CallInstEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm27getVectorIntrinsicIDForCallEPKNS_8CallInstEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*Intrinsic.ID*/int getVectorIntrinsicIDForCall(/*const*/ CallInst /*P*/ CI, 
                           /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Find the operand of the GEP that should be checked for consecutive
/// stores. This ignores trailing indices that have no effect on the final
/// pointer.

/// \brief Find the operand of the GEP that should be checked for consecutive
/// stores. This ignores trailing indices that have no effect on the final
/// pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::getGEPInductionOperand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 101,
 FQN="llvm::getGEPInductionOperand", NM="_ZN4llvm22getGEPInductionOperandEPKNS_17GetElementPtrInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm22getGEPInductionOperandEPKNS_17GetElementPtrInstE")
//</editor-fold>
public static /*uint*/int getGEPInductionOperand(/*const*/ GetElementPtrInst /*P*/ Gep) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief If the argument is a GEP, then returns the operand identified by
/// getGEPInductionOperand. However, if there is some other non-loop-invariant
/// operand, it returns that instead.

/// \brief If the argument is a GEP, then returns the operand identified by
/// getGEPInductionOperand. However, if there is some other non-loop-invariant
/// operand, it returns that instead.
//<editor-fold defaultstate="collapsed" desc="llvm::stripGetElementPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 125,
 FQN="llvm::stripGetElementPtr", NM="_ZN4llvm18stripGetElementPtrEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm18stripGetElementPtrEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE")
//</editor-fold>
public static Value /*P*/ stripGetElementPtr(Value /*P*/ Ptr, ScalarEvolution /*P*/ SE, Loop /*P*/ Lp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief If a value has only one user that is a CastInst, return it.

/// \brief If a value has only one user that is a CastInst, return it.
//<editor-fold defaultstate="collapsed" desc="llvm::getUniqueCastUse">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 142,
 FQN="llvm::getUniqueCastUse", NM="_ZN4llvm16getUniqueCastUseEPNS_5ValueEPNS_4LoopEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm16getUniqueCastUseEPNS_5ValueEPNS_4LoopEPNS_4TypeE")
//</editor-fold>
public static Value /*P*/ getUniqueCastUse(Value /*P*/ Ptr, Loop /*P*/ Lp, Type /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Get the stride of a pointer access in a loop. Looks for symbolic
/// strides "a[i*stride]". Returns the symbolic stride, or null otherwise.

/// \brief Get the stride of a pointer access in a loop. Looks for symbolic
/// strides "a[i*stride]". Returns the symbolic stride, or null otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::getStrideFromPointer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 158,
 FQN="llvm::getStrideFromPointer", NM="_ZN4llvm20getStrideFromPointerEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm20getStrideFromPointerEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE")
//</editor-fold>
public static Value /*P*/ getStrideFromPointer(Value /*P*/ Ptr, ScalarEvolution /*P*/ SE, Loop /*P*/ Lp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Given a vector and an element number, see if the scalar value is
/// already around as a register, for example if it were inserted then extracted
/// from the vector.

/// \brief Given a vector and an element number, see if the scalar value is
/// already around as a register, for example if it were inserted then extracted
/// from the vector.
//<editor-fold defaultstate="collapsed" desc="llvm::findScalarElement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 234,
 FQN="llvm::findScalarElement", NM="_ZN4llvm17findScalarElementEPNS_5ValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm17findScalarElementEPNS_5ValueEj")
//</editor-fold>
public static Value /*P*/ findScalarElement(Value /*P*/ V, /*uint*/int EltNo) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Get splat value if the input is a splat vector or return nullptr.
/// The value may be extracted from a splat constants vector or from
/// a sequence of instructions that broadcast a single value into a vector.

/// \brief Get splat value if the input is a splat vector or return nullptr.
/// This function is not fully general. It checks only 2 cases:
/// the input value is (1) a splat constants vector or (2) a sequence
/// of instructions that broadcast a single value into a vector.
///
//<editor-fold defaultstate="collapsed" desc="llvm::getSplatValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 286,
 FQN="llvm::getSplatValue", NM="_ZN4llvm13getSplatValueEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm13getSplatValueEPKNS_5ValueE")
//</editor-fold>
public static /*const*/ Value /*P*/ getSplatValue(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Compute a map of integer instructions to their minimum legal type
/// size.
///
/// C semantics force sub-int-sized values (e.g. i8, i16) to be promoted to int
/// type (e.g. i32) whenever arithmetic is performed on them.
///
/// For targets with native i8 or i16 operations, usually InstCombine can shrink
/// the arithmetic type down again. However InstCombine refuses to create
/// illegal types, so for targets without i8 or i16 registers, the lengthening
/// and shrinking remains.
///
/// Most SIMD ISAs (e.g. NEON) however support vectors of i8 or i16 even when
/// their scalar equivalents do not, so during vectorization it is important to
/// remove these lengthens and truncates when deciding the profitability of
/// vectorization.
///
/// This function analyzes the given range of instructions and determines the
/// minimum type size each can be converted to. It attempts to remove or
/// minimize type size changes across each def-use chain, so for example in the
/// following code:
///
///   %1 = load i8, i8*
///   %2 = add i8 %1, 2
///   %3 = load i16, i16*
///   %4 = zext i8 %2 to i32
///   %5 = zext i16 %3 to i32
///   %6 = add i32 %4, %5
///   %7 = trunc i32 %6 to i16
///
/// Instruction %6 must be done at least in i16, so computeMinimumValueSizes
/// will return: {%1: 16, %2: 16, %3: 16, %4: 16, %5: 16, %6: 16, %7: 16}.
///
/// If the optional TargetTransformInfo is provided, this function tries harder
/// to do less work by only looking at illegal types.
//<editor-fold defaultstate="collapsed" desc="llvm::computeMinimumValueSizes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 309,
 FQN="llvm::computeMinimumValueSizes", NM="_ZN4llvm24computeMinimumValueSizesENS_8ArrayRefIPNS_10BasicBlockEEERNS_12DemandedBitsEPKNS_19TargetTransformInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm24computeMinimumValueSizesENS_8ArrayRefIPNS_10BasicBlockEEERNS_12DemandedBitsEPKNS_19TargetTransformInfoE")
//</editor-fold>
public static MapVectorPtrULong<Instruction /*P*/ > computeMinimumValueSizes(ArrayRef<BasicBlock /*P*/ > Blocks, final DemandedBits /*&*/ DB) {
  return computeMinimumValueSizes(Blocks, DB, 
                        (/*const*/ TargetTransformInfo /*P*/ )null);
}
public static MapVectorPtrULong<Instruction /*P*/ > computeMinimumValueSizes(ArrayRef<BasicBlock /*P*/ > Blocks, final DemandedBits /*&*/ DB, 
                        /*const*/ TargetTransformInfo /*P*/ TTI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Specifically, let Kinds = [MD_tbaa, MD_alias_scope, MD_noalias, MD_fpmath,
/// MD_nontemporal].  For K in Kinds, we get the MDNode for K from each of the
/// elements of VL, compute their "intersection" (i.e., the most generic
/// metadata value that covers all of the individual values), and set I's
/// metadata for M equal to the intersection value.
///
/// This function always sets a (possibly null) value for each K in Kinds.

/// \returns \p I after propagating metadata from \p VL.
//<editor-fold defaultstate="collapsed" desc="llvm::propagateMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp", line = 452,
 FQN="llvm::propagateMetadata", NM="_ZN4llvm17propagateMetadataEPNS_11InstructionENS_8ArrayRefIPNS_5ValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm17propagateMetadataEPNS_11InstructionENS_8ArrayRefIPNS_5ValueEEE")
//</editor-fold>
public static Instruction /*P*/ propagateMetadata(Instruction /*P*/ Inst, ArrayRef<Value /*P*/ > VL) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class VectorUtilsLlvmGlobals
