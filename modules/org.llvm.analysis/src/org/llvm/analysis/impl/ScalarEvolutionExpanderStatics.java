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


//<editor-fold defaultstate="collapsed" desc="static type ScalarEvolutionExpanderStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.ScalarEvolutionExpanderStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL12SplitAddRecsRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_4TypeERNS_15ScalarEvolutionE;_ZL14IsIncrementNSWRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprE;_ZL14IsIncrementNUWRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprE;_ZL17ExposePointerBaseRPKN4llvm4SCEVES3_RNS_15ScalarEvolutionE;_ZL17FactorOutConstantRPKN4llvm4SCEVES3_S2_RNS_15ScalarEvolutionERKNS_10DataLayoutE;_ZL19SimplifyAddOperandsRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_4TypeERNS_15ScalarEvolutionE;_ZL20PickMostRelevantLoopPKN4llvm4LoopES2_RNS_13DominatorTreeE;_ZL20findInsertPointAfterPN4llvm11InstructionEPNS_10BasicBlockE;_ZL23canBeCheaplyTransformedRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprES4_Rb; -static-type=ScalarEvolutionExpanderStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class ScalarEvolutionExpanderStatics {

//<editor-fold defaultstate="collapsed" desc="findInsertPointAfter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 89,
 FQN="findInsertPointAfter", NM="_ZL20findInsertPointAfterPN4llvm11InstructionEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL20findInsertPointAfterPN4llvm11InstructionEPNS_10BasicBlockE")
//</editor-fold>
public static ilist_iterator<Instruction> findInsertPointAfter(Instruction /*P*/ I, 
                    BasicBlock /*P*/ MustDominate) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// FactorOutConstant - Test if S is divisible by Factor, using signed
/// division. If so, update S with Factor divided out and return true.
/// S need not be evenly divisible if a reasonable remainder can be
/// computed.
/// TODO: When ScalarEvolution gets a SCEVSDivExpr, this can be made
/// unnecessary; in its place, just signed-divide Ops[i] by the scale and
/// check to see if the divide was folded.
//<editor-fold defaultstate="collapsed" desc="FactorOutConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 226,
 FQN="FactorOutConstant", NM="_ZL17FactorOutConstantRPKN4llvm4SCEVES3_S2_RNS_15ScalarEvolutionERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL17FactorOutConstantRPKN4llvm4SCEVES3_S2_RNS_15ScalarEvolutionERKNS_10DataLayoutE")
//</editor-fold>
public static boolean FactorOutConstant(final type$ref</*const*/ SCEV /*P*/ /*&*/> S, final type$ref</*const*/ SCEV /*P*/ /*&*/> Remainder, 
                 /*const*/ SCEV /*P*/ Factor, final ScalarEvolution /*&*/ SE, 
                 final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// SimplifyAddOperands - Sort and simplify a list of add operands. NumAddRecs
/// is the number of SCEVAddRecExprs present, which are kept at the end of
/// the list.
///
//<editor-fold defaultstate="collapsed" desc="SimplifyAddOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 299,
 FQN="SimplifyAddOperands", NM="_ZL19SimplifyAddOperandsRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_4TypeERNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL19SimplifyAddOperandsRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_4TypeERNS_15ScalarEvolutionE")
//</editor-fold>
public static void SimplifyAddOperands(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops, 
                   Type /*P*/ Ty, 
                   final ScalarEvolution /*&*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// SplitAddRecs - Flatten a list of add operands, moving addrec start values
/// out to the top level. For example, convert {a + b,+,c} to a, b, {0,+,d}.
/// This helps expose more opportunities for folding parts of the expressions
/// into GEP indices.
///
//<editor-fold defaultstate="collapsed" desc="SplitAddRecs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 328,
 FQN="SplitAddRecs", NM="_ZL12SplitAddRecsRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_4TypeERNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL12SplitAddRecsRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_4TypeERNS_15ScalarEvolutionE")
//</editor-fold>
public static void SplitAddRecs(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops, 
            Type /*P*/ Ty, 
            final ScalarEvolution /*&*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// PickMostRelevantLoop - Given two loops pick the one that's most relevant for
/// SCEV expansion. If they are nested, this is the most nested. If they are
/// neighboring, pick the later.
//<editor-fold defaultstate="collapsed" desc="PickMostRelevantLoop">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 583,
 FQN="PickMostRelevantLoop", NM="_ZL20PickMostRelevantLoopPKN4llvm4LoopES2_RNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL20PickMostRelevantLoopPKN4llvm4LoopES2_RNS_13DominatorTreeE")
//</editor-fold>
public static /*const*/ Loop /*P*/ PickMostRelevantLoop(/*const*/ Loop /*P*/ A, /*const*/ Loop /*P*/ B, 
                    final DominatorTree /*&*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Move parts of Base into Rest to leave Base with the minimal
/// expression that provides a pointer operand suitable for a
/// GEP expansion.
//<editor-fold defaultstate="collapsed" desc="ExposePointerBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 800,
 FQN="ExposePointerBase", NM="_ZL17ExposePointerBaseRPKN4llvm4SCEVES3_RNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL17ExposePointerBaseRPKN4llvm4SCEVES3_RNS_15ScalarEvolutionE")
//</editor-fold>
public static void ExposePointerBase(final type$ref</*const*/ SCEV /*P*/ /*&*/> Base, final type$ref</*const*/ SCEV /*P*/ /*&*/> Rest, 
                 final ScalarEvolution /*&*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Check whether we can cheaply express the requested SCEV in terms of
/// the available PHI SCEV by truncation and/or inversion of the step.
//<editor-fold defaultstate="collapsed" desc="canBeCheaplyTransformed">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1022,
 FQN="canBeCheaplyTransformed", NM="_ZL23canBeCheaplyTransformedRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprES4_Rb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL23canBeCheaplyTransformedRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprES4_Rb")
//</editor-fold>
public static boolean canBeCheaplyTransformed(final ScalarEvolution /*&*/ SE, 
                       /*const*/ SCEVAddRecExpr /*P*/ Phi, 
                       /*const*/ SCEVAddRecExpr /*P*/ Requested, 
                       final bool$ref/*bool &*/ InvertStep) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="IsIncrementNSW">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1053,
 FQN="IsIncrementNSW", NM="_ZL14IsIncrementNSWRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL14IsIncrementNSWRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprE")
//</editor-fold>
public static boolean IsIncrementNSW(final ScalarEvolution /*&*/ SE, /*const*/ SCEVAddRecExpr /*P*/ AR) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="IsIncrementNUW">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1067,
 FQN="IsIncrementNUW", NM="_ZL14IsIncrementNUWRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZL14IsIncrementNUWRN4llvm15ScalarEvolutionEPKNS_14SCEVAddRecExprE")
//</editor-fold>
public static boolean IsIncrementNUW(final ScalarEvolution /*&*/ SE, /*const*/ SCEVAddRecExpr /*P*/ AR) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ScalarEvolutionExpanderStatics
