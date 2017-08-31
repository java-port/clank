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
package org.llvm.llvm_c.transforms;

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
import org.llvm.support.Error;
import org.llvm.object.*;
import org.llvm.llvmc.*;
import org.llvm.java.LlvmFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type ScalarGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.transforms.ScalarGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z14LLVMAddGVNPass;_Z15LLVMAddLICMPass;_Z15LLVMAddSCCPPass;_Z19LLVMAddEarlyCSEPass;_Z19LLVMAddVerifierPass;_Z20LLVMAddLoopIdiomPass;_Z20LLVMAddMemCpyOptPass;_Z21LLVMAddLoopRerollPass;_Z21LLVMAddLoopRotatePass;_Z21LLVMAddLoopUnrollPass;_Z21LLVMAddScalarizerPass;_Z22LLVMAddLowerSwitchPass;_Z22LLVMAddReassociatePass;_Z23LLVMAddLoopDeletionPass;_Z23LLVMAddLoopUnswitchPass;_Z24LLVMAddAggressiveDCEPass;_Z24LLVMAddJumpThreadingPass;_Z25LLVMAddBitTrackingDCEPass;_Z25LLVMAddIndVarSimplifyPass;_Z26LLVMAddScopedNoAliasAAPass;_Z27LLVMAddSimplifyLibCallsPass;_Z28LLVMAddCFGSimplificationPass;_Z29LLVMAddBasicAliasAnalysisPass;_Z30LLVMAddConstantPropagationPass;_Z30LLVMAddTailCallEliminationPass;_Z31LLVMAddDeadStoreEliminationPass;_Z31LLVMAddInstructionCombiningPass;_Z31LLVMAddLowerExpectIntrinsicPass;_Z31LLVMAddScalarReplAggregatesPass;_Z32LLVMAddMergedLoadStoreMotionPass;_Z33LLVMAddDemoteMemoryToRegisterPass;_Z33LLVMAddTypeBasedAliasAnalysisPass;_Z34LLVMAddPartiallyInlineLibCallsPass;_Z34LLVMAddPromoteMemoryToRegisterPass;_Z34LLVMAddScalarReplAggregatesPassSSA;_Z35LLVMAddAlignmentFromAssumptionsPass;_Z37LLVMAddCorrelatedValuePropagationPass;_Z44LLVMAddScalarReplAggregatesPassWithThreshold; -static-type=ScalarGlobals -package=org.llvm.llvm_c.transforms")
//</editor-fold>
public final class ScalarGlobals {


/**
* @defgroup LLVMCTransformsScalar Scalar transformations
* @ingroup LLVMCTransforms
*
* @{
*/

/** See llvm::createAggressiveDCEPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddAggressiveDCEPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 99,
 FQN="LLVMAddAggressiveDCEPass", NM="_Z24LLVMAddAggressiveDCEPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z24LLVMAddAggressiveDCEPass")
//</editor-fold>
public static void LLVMAddAggressiveDCEPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createBitTrackingDCEPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddBitTrackingDCEPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 103,
 FQN="LLVMAddBitTrackingDCEPass", NM="_Z25LLVMAddBitTrackingDCEPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z25LLVMAddBitTrackingDCEPass")
//</editor-fold>
public static void LLVMAddBitTrackingDCEPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createAlignmentFromAssumptionsPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddAlignmentFromAssumptionsPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 107,
 FQN="LLVMAddAlignmentFromAssumptionsPass", NM="_Z35LLVMAddAlignmentFromAssumptionsPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z35LLVMAddAlignmentFromAssumptionsPass")
//</editor-fold>
public static void LLVMAddAlignmentFromAssumptionsPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createCFGSimplificationPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddCFGSimplificationPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 111,
 FQN="LLVMAddCFGSimplificationPass", NM="_Z28LLVMAddCFGSimplificationPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z28LLVMAddCFGSimplificationPass")
//</editor-fold>
public static void LLVMAddCFGSimplificationPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createDeadStoreEliminationPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddDeadStoreEliminationPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 115,
 FQN="LLVMAddDeadStoreEliminationPass", NM="_Z31LLVMAddDeadStoreEliminationPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z31LLVMAddDeadStoreEliminationPass")
//</editor-fold>
public static void LLVMAddDeadStoreEliminationPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createScalarizerPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddScalarizerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 119,
 FQN="LLVMAddScalarizerPass", NM="_Z21LLVMAddScalarizerPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z21LLVMAddScalarizerPass")
//</editor-fold>
public static void LLVMAddScalarizerPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createMergedLoadStoreMotionPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddMergedLoadStoreMotionPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 127,
 FQN="LLVMAddMergedLoadStoreMotionPass", NM="_Z32LLVMAddMergedLoadStoreMotionPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z32LLVMAddMergedLoadStoreMotionPass")
//</editor-fold>
public static void LLVMAddMergedLoadStoreMotionPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createGVNPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddGVNPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 123,
 FQN="LLVMAddGVNPass", NM="_Z14LLVMAddGVNPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z14LLVMAddGVNPass")
//</editor-fold>
public static void LLVMAddGVNPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createIndVarSimplifyPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddIndVarSimplifyPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 131,
 FQN="LLVMAddIndVarSimplifyPass", NM="_Z25LLVMAddIndVarSimplifyPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z25LLVMAddIndVarSimplifyPass")
//</editor-fold>
public static void LLVMAddIndVarSimplifyPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createInstructionCombiningPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddInstructionCombiningPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 135,
 FQN="LLVMAddInstructionCombiningPass", NM="_Z31LLVMAddInstructionCombiningPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z31LLVMAddInstructionCombiningPass")
//</editor-fold>
public static void LLVMAddInstructionCombiningPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createJumpThreadingPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddJumpThreadingPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 139,
 FQN="LLVMAddJumpThreadingPass", NM="_Z24LLVMAddJumpThreadingPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z24LLVMAddJumpThreadingPass")
//</editor-fold>
public static void LLVMAddJumpThreadingPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLICMPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLICMPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 143,
 FQN="LLVMAddLICMPass", NM="_Z15LLVMAddLICMPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z15LLVMAddLICMPass")
//</editor-fold>
public static void LLVMAddLICMPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLoopDeletionPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLoopDeletionPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 147,
 FQN="LLVMAddLoopDeletionPass", NM="_Z23LLVMAddLoopDeletionPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z23LLVMAddLoopDeletionPass")
//</editor-fold>
public static void LLVMAddLoopDeletionPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLoopIdiomPass function */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLoopIdiomPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 151,
 FQN="LLVMAddLoopIdiomPass", NM="_Z20LLVMAddLoopIdiomPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z20LLVMAddLoopIdiomPass")
//</editor-fold>
public static void LLVMAddLoopIdiomPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLoopRotatePass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLoopRotatePass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 155,
 FQN="LLVMAddLoopRotatePass", NM="_Z21LLVMAddLoopRotatePass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z21LLVMAddLoopRotatePass")
//</editor-fold>
public static void LLVMAddLoopRotatePass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLoopRerollPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLoopRerollPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 159,
 FQN="LLVMAddLoopRerollPass", NM="_Z21LLVMAddLoopRerollPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z21LLVMAddLoopRerollPass")
//</editor-fold>
public static void LLVMAddLoopRerollPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLoopUnrollPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLoopUnrollPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 167,
 FQN="LLVMAddLoopUnrollPass", NM="_Z21LLVMAddLoopUnrollPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z21LLVMAddLoopUnrollPass")
//</editor-fold>
public static void LLVMAddLoopUnrollPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLoopUnswitchPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLoopUnswitchPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 171,
 FQN="LLVMAddLoopUnswitchPass", NM="_Z23LLVMAddLoopUnswitchPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z23LLVMAddLoopUnswitchPass")
//</editor-fold>
public static void LLVMAddLoopUnswitchPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createMemCpyOptPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddMemCpyOptPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 175,
 FQN="LLVMAddMemCpyOptPass", NM="_Z20LLVMAddMemCpyOptPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z20LLVMAddMemCpyOptPass")
//</editor-fold>
public static void LLVMAddMemCpyOptPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createPartiallyInlineLibCallsPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddPartiallyInlineLibCallsPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 179,
 FQN="LLVMAddPartiallyInlineLibCallsPass", NM="_Z34LLVMAddPartiallyInlineLibCallsPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z34LLVMAddPartiallyInlineLibCallsPass")
//</editor-fold>
public static void LLVMAddPartiallyInlineLibCallsPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLowerSwitchPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLowerSwitchPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 183,
 FQN="LLVMAddLowerSwitchPass", NM="_Z22LLVMAddLowerSwitchPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z22LLVMAddLowerSwitchPass")
//</editor-fold>
public static void LLVMAddLowerSwitchPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createPromoteMemoryToRegisterPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddPromoteMemoryToRegisterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 187,
 FQN="LLVMAddPromoteMemoryToRegisterPass", NM="_Z34LLVMAddPromoteMemoryToRegisterPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z34LLVMAddPromoteMemoryToRegisterPass")
//</editor-fold>
public static void LLVMAddPromoteMemoryToRegisterPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createReassociatePass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddReassociatePass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 191,
 FQN="LLVMAddReassociatePass", NM="_Z22LLVMAddReassociatePass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z22LLVMAddReassociatePass")
//</editor-fold>
public static void LLVMAddReassociatePass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createSCCPPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddSCCPPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 195,
 FQN="LLVMAddSCCPPass", NM="_Z15LLVMAddSCCPPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z15LLVMAddSCCPPass")
//</editor-fold>
public static void LLVMAddSCCPPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createSROAPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddScalarReplAggregatesPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 199,
 FQN="LLVMAddScalarReplAggregatesPass", NM="_Z31LLVMAddScalarReplAggregatesPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z31LLVMAddScalarReplAggregatesPass")
//</editor-fold>
public static void LLVMAddScalarReplAggregatesPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createSROAPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddScalarReplAggregatesPassSSA">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 203,
 FQN="LLVMAddScalarReplAggregatesPassSSA", NM="_Z34LLVMAddScalarReplAggregatesPassSSA",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z34LLVMAddScalarReplAggregatesPassSSA")
//</editor-fold>
public static void LLVMAddScalarReplAggregatesPassSSA( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createSROAPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddScalarReplAggregatesPassWithThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 207,
 FQN="LLVMAddScalarReplAggregatesPassWithThreshold", NM="_Z44LLVMAddScalarReplAggregatesPassWithThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z44LLVMAddScalarReplAggregatesPassWithThreshold")
//</editor-fold>
public static void LLVMAddScalarReplAggregatesPassWithThreshold( LLVMOpaquePassManager /*P*/ PM, 
                                            int Threshold) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createSimplifyLibCallsPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddSimplifyLibCallsPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 212,
 FQN="LLVMAddSimplifyLibCallsPass", NM="_Z27LLVMAddSimplifyLibCallsPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z27LLVMAddSimplifyLibCallsPass")
//</editor-fold>
public static void LLVMAddSimplifyLibCallsPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createTailCallEliminationPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddTailCallEliminationPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 216,
 FQN="LLVMAddTailCallEliminationPass", NM="_Z30LLVMAddTailCallEliminationPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z30LLVMAddTailCallEliminationPass")
//</editor-fold>
public static void LLVMAddTailCallEliminationPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createConstantPropagationPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddConstantPropagationPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 220,
 FQN="LLVMAddConstantPropagationPass", NM="_Z30LLVMAddConstantPropagationPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z30LLVMAddConstantPropagationPass")
//</editor-fold>
public static void LLVMAddConstantPropagationPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::demotePromoteMemoryToRegisterPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddDemoteMemoryToRegisterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 224,
 FQN="LLVMAddDemoteMemoryToRegisterPass", NM="_Z33LLVMAddDemoteMemoryToRegisterPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z33LLVMAddDemoteMemoryToRegisterPass")
//</editor-fold>
public static void LLVMAddDemoteMemoryToRegisterPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createVerifierPass function. */
//<editor-fold defaultstate="collapsed" desc="LLVMAddVerifierPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 228,
 FQN="LLVMAddVerifierPass", NM="_Z19LLVMAddVerifierPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z19LLVMAddVerifierPass")
//</editor-fold>
public static void LLVMAddVerifierPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createCorrelatedValuePropagationPass function */
//<editor-fold defaultstate="collapsed" desc="LLVMAddCorrelatedValuePropagationPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 232,
 FQN="LLVMAddCorrelatedValuePropagationPass", NM="_Z37LLVMAddCorrelatedValuePropagationPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z37LLVMAddCorrelatedValuePropagationPass")
//</editor-fold>
public static void LLVMAddCorrelatedValuePropagationPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createEarlyCSEPass function */
//<editor-fold defaultstate="collapsed" desc="LLVMAddEarlyCSEPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 236,
 FQN="LLVMAddEarlyCSEPass", NM="_Z19LLVMAddEarlyCSEPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z19LLVMAddEarlyCSEPass")
//</editor-fold>
public static void LLVMAddEarlyCSEPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createLowerExpectIntrinsicPass function */
//<editor-fold defaultstate="collapsed" desc="LLVMAddLowerExpectIntrinsicPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 256,
 FQN="LLVMAddLowerExpectIntrinsicPass", NM="_Z31LLVMAddLowerExpectIntrinsicPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z31LLVMAddLowerExpectIntrinsicPass")
//</editor-fold>
public static void LLVMAddLowerExpectIntrinsicPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createTypeBasedAliasAnalysisPass function */
//<editor-fold defaultstate="collapsed" desc="LLVMAddTypeBasedAliasAnalysisPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 244,
 FQN="LLVMAddTypeBasedAliasAnalysisPass", NM="_Z33LLVMAddTypeBasedAliasAnalysisPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z33LLVMAddTypeBasedAliasAnalysisPass")
//</editor-fold>
public static void LLVMAddTypeBasedAliasAnalysisPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createScopedNoAliasAAPass function */
//<editor-fold defaultstate="collapsed" desc="LLVMAddScopedNoAliasAAPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 248,
 FQN="LLVMAddScopedNoAliasAAPass", NM="_Z26LLVMAddScopedNoAliasAAPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z26LLVMAddScopedNoAliasAAPass")
//</editor-fold>
public static void LLVMAddScopedNoAliasAAPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** See llvm::createBasicAliasAnalysisPass function */
//<editor-fold defaultstate="collapsed" desc="LLVMAddBasicAliasAnalysisPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 252,
 FQN="LLVMAddBasicAliasAnalysisPass", NM="_Z29LLVMAddBasicAliasAnalysisPass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z29LLVMAddBasicAliasAnalysisPass")
//</editor-fold>
public static void LLVMAddBasicAliasAnalysisPass( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ScalarGlobals
