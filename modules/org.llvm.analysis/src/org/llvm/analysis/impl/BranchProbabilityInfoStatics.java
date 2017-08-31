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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;


//<editor-fold defaultstate="collapsed" desc="static type BranchProbabilityInfoStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.analysis.impl.BranchProbabilityInfoStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL15CC_TAKEN_WEIGHT;_ZL15IH_TAKEN_WEIGHT;_ZL15PH_TAKEN_WEIGHT;_ZL15UR_TAKEN_WEIGHT;_ZL15ZH_TAKEN_WEIGHT;_ZL16FPH_TAKEN_WEIGHT;_ZL16LBH_TAKEN_WEIGHT;_ZL18CC_NONTAKEN_WEIGHT;_ZL18IH_NONTAKEN_WEIGHT;_ZL18PH_NONTAKEN_WEIGHT;_ZL18UR_NONTAKEN_WEIGHT;_ZL18ZH_NONTAKEN_WEIGHT;_ZL19FPH_NONTAKEN_WEIGHT;_ZL19LBH_NONTAKEN_WEIGHT;_ZL50InitializeBranchProbabilityInfoWrapperPassPassFlag;_ZL50initializeBranchProbabilityInfoWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=BranchProbabilityInfoStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class BranchProbabilityInfoStatics {

//<editor-fold defaultstate="collapsed" desc="initializeBranchProbabilityInfoWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 30,
 FQN="initializeBranchProbabilityInfoWrapperPassPassOnce", NM="_ZL50initializeBranchProbabilityInfoWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL50initializeBranchProbabilityInfoWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeBranchProbabilityInfoWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  LoopInfoLlvmStatics.initializeLoopInfoWrapperPassPass(Registry);
  PassInfo /*P*/ PI = new PassInfo($("Branch Probability Analysis"), $("branch-prob"), $AddrOf(BranchProbabilityInfoWrapperPass.ID),
          ()->new BranchProbabilityInfoWrapperPass(),
          //((NormalCtor_t)(/*FuncRef*/<BranchProbabilityInfoWrapperPass>callDefaultCtor)),
          false, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeBranchProbabilityInfoWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 33,
 FQN="InitializeBranchProbabilityInfoWrapperPassPassFlag", NM="_ZL50InitializeBranchProbabilityInfoWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL50InitializeBranchProbabilityInfoWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeBranchProbabilityInfoWrapperPassPassFlag/*J*/= new std.once_flag();

// Weights are for internal use only. They are used by heuristics to help to
// estimate edges' probability. Example:
//
// Using "Loop Branch Heuristics" we predict weights of edges for the
// block BB2.
//         ...
//          |
//          V
//         BB1<-+
//          |   |
//          |   | (Weight = 124)
//          V   |
//         BB2--+
//          |
//          | (Weight = 4)
//          V
//         BB3
//
// Probability of the edge BB2->BB1 = 124 / (124 + 4) = 0.96875
// Probability of the edge BB2->BB3 = 4 / (124 + 4) = 0.03125
//<editor-fold defaultstate="collapsed" desc="LBH_TAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 58,
 FQN="LBH_TAKEN_WEIGHT", NM="_ZL16LBH_TAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL16LBH_TAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int LBH_TAKEN_WEIGHT = 124;
//<editor-fold defaultstate="collapsed" desc="LBH_NONTAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 59,
 FQN="LBH_NONTAKEN_WEIGHT", NM="_ZL19LBH_NONTAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL19LBH_NONTAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int LBH_NONTAKEN_WEIGHT = 4;

/// \brief Unreachable-terminating branch taken weight.
///
/// This is the weight for a branch being taken to a block that terminates
/// (eventually) in unreachable. These are predicted as unlikely as possible.
//<editor-fold defaultstate="collapsed" desc="UR_TAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 65,
 FQN="UR_TAKEN_WEIGHT", NM="_ZL15UR_TAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL15UR_TAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int UR_TAKEN_WEIGHT = 1;

/// \brief Unreachable-terminating branch not-taken weight.
///
/// This is the weight for a branch not being taken toward a block that
/// terminates (eventually) in unreachable. Such a branch is essentially never
/// taken. Set the weight to an absurdly high value so that nested loops don't
/// easily subsume it.
//<editor-fold defaultstate="collapsed" desc="UR_NONTAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 73,
 FQN="UR_NONTAKEN_WEIGHT", NM="_ZL18UR_NONTAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL18UR_NONTAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int UR_NONTAKEN_WEIGHT = 1024 * 1024 - 1;

/// \brief Weight for a branch taken going into a cold block.
///
/// This is the weight for a branch taken toward a block marked
/// cold.  A block is marked cold if it's postdominated by a
/// block containing a call to a cold function.  Cold functions
/// are those marked with attribute 'cold'.
//<editor-fold defaultstate="collapsed" desc="CC_TAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 81,
 FQN="CC_TAKEN_WEIGHT", NM="_ZL15CC_TAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL15CC_TAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int CC_TAKEN_WEIGHT = 4;

/// \brief Weight for a branch not-taken into a cold block.
///
/// This is the weight for a branch not taken toward a block marked
/// cold.
//<editor-fold defaultstate="collapsed" desc="CC_NONTAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 87,
 FQN="CC_NONTAKEN_WEIGHT", NM="_ZL18CC_NONTAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL18CC_NONTAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int CC_NONTAKEN_WEIGHT = 64;
//<editor-fold defaultstate="collapsed" desc="PH_TAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 89,
 FQN="PH_TAKEN_WEIGHT", NM="_ZL15PH_TAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL15PH_TAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int PH_TAKEN_WEIGHT = 20;
//<editor-fold defaultstate="collapsed" desc="PH_NONTAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 90,
 FQN="PH_NONTAKEN_WEIGHT", NM="_ZL18PH_NONTAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL18PH_NONTAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int PH_NONTAKEN_WEIGHT = 12;
//<editor-fold defaultstate="collapsed" desc="ZH_TAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 92,
 FQN="ZH_TAKEN_WEIGHT", NM="_ZL15ZH_TAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL15ZH_TAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int ZH_TAKEN_WEIGHT = 20;
//<editor-fold defaultstate="collapsed" desc="ZH_NONTAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 93,
 FQN="ZH_NONTAKEN_WEIGHT", NM="_ZL18ZH_NONTAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL18ZH_NONTAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int ZH_NONTAKEN_WEIGHT = 12;
//<editor-fold defaultstate="collapsed" desc="FPH_TAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 95,
 FQN="FPH_TAKEN_WEIGHT", NM="_ZL16FPH_TAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL16FPH_TAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int FPH_TAKEN_WEIGHT = 20;
//<editor-fold defaultstate="collapsed" desc="FPH_NONTAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 96,
 FQN="FPH_NONTAKEN_WEIGHT", NM="_ZL19FPH_NONTAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL19FPH_NONTAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int FPH_NONTAKEN_WEIGHT = 12;

/// \brief Invoke-terminating normal branch taken weight
///
/// This is the weight for branching to the normal destination of an invoke
/// instruction. We expect this to happen most of the time. Set the weight to an
/// absurdly high value so that nested loops subsume it.
//<editor-fold defaultstate="collapsed" desc="IH_TAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 103,
 FQN="IH_TAKEN_WEIGHT", NM="_ZL15IH_TAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL15IH_TAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int IH_TAKEN_WEIGHT = 1024 * 1024 - 1;

/// \brief Invoke-terminating normal branch not-taken weight.
///
/// This is the weight for branching to the unwind destination of an invoke
/// instruction. This is essentially never taken.
//<editor-fold defaultstate="collapsed" desc="IH_NONTAKEN_WEIGHT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 109,
 FQN="IH_NONTAKEN_WEIGHT", NM="_ZL18IH_NONTAKEN_WEIGHT",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZL18IH_NONTAKEN_WEIGHT")
//</editor-fold>
public static /*const*//*uint32_t*/int IH_NONTAKEN_WEIGHT = 1;
} // END OF class BranchProbabilityInfoStatics
