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
import org.llvm.adt.aliases.SmallVector;
import org.llvm.support.*;
import org.llvm.analysis.*;
import org.llvm.analysis.bfi_detail.*;


//<editor-fold defaultstate="collapsed" desc="static type BlockFrequencyInfoImplStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.BlockFrequencyInfoImplStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL10unwrapLoopRN4llvm26BlockFrequencyInfoImplBaseERNS0_8LoopDataE;_ZL11debugAssignRKN4llvm26BlockFrequencyInfoImplBaseERKN12_GLOBAL__N_120DitheringDistributerERKNS0_9BlockNodeERKNS_10bfi_detail9BlockMassEPKc;_ZL11getHexDigiti;_ZL13combineWeightRN4llvm26BlockFrequencyInfoImplBase6WeightERKS1_;_ZL14combineWeightsRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE;_ZL18shiftRightAndRoundyi;_ZL21createIrreducibleLoopRN4llvm26BlockFrequencyInfoImplBaseERKNS_10bfi_detail16IrreducibleGraphEPNS0_8LoopDataESt14_List_iteratorIS6_ERKSt6vectorIPKNS3_7IrrNodeESaISD_EE;_ZL22findIrreducibleHeadersRKN4llvm26BlockFrequencyInfoImplBaseERKNS_10bfi_detail16IrreducibleGraphERKSt6vectorIPKNS4_7IrrNodeESaISA_EERNS_11SmallVectorINS0_9BlockNodeELj4EEESI_;_ZL23combineWeightsByHashingRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE;_ZL23combineWeightsBySortingRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE;_ZL24convertFloatingToIntegerRN4llvm26BlockFrequencyInfoImplBaseERKNS_12ScaledNumberIyEES5_;_ZL7cleanupRN4llvm26BlockFrequencyInfoImplBaseE; -static-type=BlockFrequencyInfoImplStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class BlockFrequencyInfoImplStatics {

//<editor-fold defaultstate="collapsed" desc="getHexDigit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 33,
 FQN="getHexDigit", NM="_ZL11getHexDigiti",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL11getHexDigiti")
//</editor-fold>
public static /*char*/byte getHexDigit(int N) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="combineWeight">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 120,
 FQN="combineWeight", NM="_ZL13combineWeightRN4llvm26BlockFrequencyInfoImplBase6WeightERKS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL13combineWeightRN4llvm26BlockFrequencyInfoImplBase6WeightERKS1_")
//</editor-fold>
public static void combineWeight(final BlockFrequencyInfoImplBase.Weight /*&*/ W, final /*const*/ BlockFrequencyInfoImplBase.Weight /*&*/ OtherW) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="combineWeightsBySorting">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 136,
 FQN="combineWeightsBySorting", NM="_ZL23combineWeightsBySortingRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL23combineWeightsBySortingRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE")
//</editor-fold>
public static void combineWeightsBySorting(final SmallVector<BlockFrequencyInfoImplBase.Weight> /*&*/ Weights) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="combineWeightsByHashing">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 157,
 FQN="combineWeightsByHashing", NM="_ZL23combineWeightsByHashingRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL23combineWeightsByHashingRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE")
//</editor-fold>
public static void combineWeightsByHashing(final SmallVector<BlockFrequencyInfoImplBase.Weight> /*&*/ Weights) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="combineWeights">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 175,
 FQN="combineWeights", NM="_ZL14combineWeightsRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL14combineWeightsRN4llvm11SmallVectorINS_26BlockFrequencyInfoImplBase6WeightELj4EEE")
//</editor-fold>
public static void combineWeights(final SmallVector<BlockFrequencyInfoImplBase.Weight> /*&*/ Weights) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="shiftRightAndRound">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 185,
 FQN="shiftRightAndRound", NM="_ZL18shiftRightAndRoundyi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL18shiftRightAndRoundyi")
//</editor-fold>
public static long/*uint64_t*/ shiftRightAndRound(long/*uint64_t*/ N, int Shift) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Clear all memory not needed downstream.
///
/// Releases all memory not used downstream.  In particular, saves Freqs.
//<editor-fold defaultstate="collapsed" desc="cleanup">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 260,
 FQN="cleanup", NM="_ZL7cleanupRN4llvm26BlockFrequencyInfoImplBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL7cleanupRN4llvm26BlockFrequencyInfoImplBaseE")
//</editor-fold>
public static void cleanup(final BlockFrequencyInfoImplBase /*&*/ BFI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="debugAssign">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 388,
 FQN="debugAssign", NM="_ZL11debugAssignRKN4llvm26BlockFrequencyInfoImplBaseERKN12_GLOBAL__N_120DitheringDistributerERKNS0_9BlockNodeERKNS_10bfi_detail9BlockMassEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL11debugAssignRKN4llvm26BlockFrequencyInfoImplBaseERKN12_GLOBAL__N_120DitheringDistributerERKNS0_9BlockNodeERKNS_10bfi_detail9BlockMassEPKc")
//</editor-fold>
public static void debugAssign(final /*const*/ BlockFrequencyInfoImplBase /*&*/ BFI, 
           final /*const*/ DitheringDistributer /*&*/ D, final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ T, 
           final /*const*/ BlockMass /*&*/ M, /*const*/char$ptr/*char P*/ Desc) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="convertFloatingToInteger">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 435,
 FQN="convertFloatingToInteger", NM="_ZL24convertFloatingToIntegerRN4llvm26BlockFrequencyInfoImplBaseERKNS_12ScaledNumberIyEES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL24convertFloatingToIntegerRN4llvm26BlockFrequencyInfoImplBaseERKNS_12ScaledNumberIyEES5_")
//</editor-fold>
public static void convertFloatingToInteger(final BlockFrequencyInfoImplBase /*&*/ BFI, 
                        final /*const*/ ScaledNumberULLong /*&*/ Min, final /*const*/ ScaledNumberULLong /*&*/ Max) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Unwrap a loop package.
///
/// Visits all the members of a loop, adjusting their BlockData according to
/// the loop's pseudo-node.
//<editor-fold defaultstate="collapsed" desc="unwrapLoop">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 474,
 FQN="unwrapLoop", NM="_ZL10unwrapLoopRN4llvm26BlockFrequencyInfoImplBaseERNS0_8LoopDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL10unwrapLoopRN4llvm26BlockFrequencyInfoImplBaseERNS0_8LoopDataE")
//</editor-fold>
public static void unwrapLoop(final BlockFrequencyInfoImplBase /*&*/ BFI, final BlockFrequencyInfoImplBase.LoopData /*&*/ Loop) {
  throw new UnsupportedOperationException("EmptyBody");
}

// end namespace llvm

/// \brief Find extra irreducible headers.
///
/// Find entry blocks and other blocks with backedges, which exist when \c G
/// contains irreducible sub-SCCs.
//<editor-fold defaultstate="collapsed" desc="findIrreducibleHeaders">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 641,
 FQN="findIrreducibleHeaders", NM="_ZL22findIrreducibleHeadersRKN4llvm26BlockFrequencyInfoImplBaseERKNS_10bfi_detail16IrreducibleGraphERKSt6vectorIPKNS4_7IrrNodeESaISA_EERNS_11SmallVectorINS0_9BlockNodeELj4EEESI_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL22findIrreducibleHeadersRKN4llvm26BlockFrequencyInfoImplBaseERKNS_10bfi_detail16IrreducibleGraphERKSt6vectorIPKNS4_7IrrNodeESaISA_EERNS_11SmallVectorINS0_9BlockNodeELj4EEESI_")
//</editor-fold>
public static void findIrreducibleHeaders(final /*const*/ BlockFrequencyInfoImplBase /*&*/ BFI, 
                      final /*const*/ IrreducibleGraph /*&*/ G, 
                      final /*const*/std.vector</*const*/ IrreducibleGraph.IrrNode /*P*/ > /*&*/ SCC, 
                      final SmallVector<BlockFrequencyInfoImplBase.BlockNode> /*&*/ Headers, final SmallVector<BlockFrequencyInfoImplBase.BlockNode> /*&*/ Others) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="createIrreducibleLoop">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 708,
 FQN="createIrreducibleLoop", NM="_ZL21createIrreducibleLoopRN4llvm26BlockFrequencyInfoImplBaseERKNS_10bfi_detail16IrreducibleGraphEPNS0_8LoopDataESt14_List_iteratorIS6_ERKSt6vectorIPKNS3_7IrrNodeESaISD_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZL21createIrreducibleLoopRN4llvm26BlockFrequencyInfoImplBaseERKNS_10bfi_detail16IrreducibleGraphEPNS0_8LoopDataESt14_List_iteratorIS6_ERKSt6vectorIPKNS3_7IrrNodeESaISD_EE")
//</editor-fold>
public static void createIrreducibleLoop(final BlockFrequencyInfoImplBase /*&*/ BFI, final /*const*/ IrreducibleGraph /*&*/ G, 
                     BlockFrequencyInfoImplBase.LoopData /*P*/ OuterLoop, std.list.iterator<BlockFrequencyInfoImplBase.LoopData> Insert, 
                     final /*const*/std.vector</*const*/ IrreducibleGraph.IrrNode /*P*/ > /*&*/ SCC) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class BlockFrequencyInfoImplStatics
