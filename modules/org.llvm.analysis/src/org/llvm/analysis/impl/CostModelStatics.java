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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.aliases.SmallVectorImplInt;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.target.*;
import org.llvm.cl.*;
import org.llvm.cl.aliases.optBool;


//<editor-fold defaultstate="collapsed" desc="static type CostModelStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.CostModelStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL14getOperandInfoPN4llvm5ValueE;_ZL15EnableReduxCost;_ZL19isReverseVectorMaskRN4llvm15SmallVectorImplIiEE;_ZL21isAlternateVectorMaskRN4llvm15SmallVectorImplIiEE;_ZL22getShuffleAndOtherOprdPN4llvm14BinaryOperatorE;_ZL22matchPairwiseReductionPKN4llvm18ExtractElementInstERjRPNS_4TypeE;_ZL24matchPairwiseShuffleMaskPN4llvm17ShuffleVectorInstEbj;_ZL29matchPairwiseReductionAtLevelPKN4llvm14BinaryOperatorEjj;_ZL29matchVectorSplittingReductionPKN4llvm18ExtractElementInstERjRPNS_4TypeE;_ZL35InitializeCostModelAnalysisPassFlag;_ZL35initializeCostModelAnalysisPassOnceRN4llvm12PassRegistryE;_ZL7cm_name; -static-type=CostModelStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class CostModelStatics {

//<editor-fold defaultstate="collapsed" desc="EnableReduxCost">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 36,
 FQN="EnableReduxCost", NM="_ZL15EnableReduxCost",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL15EnableReduxCost")
//</editor-fold>
public static optBool EnableReduxCost/*J*/= new optBool(opt.StorageKind.Internal, $("costmodel-reduxcost"), ClGlobals.init$Bool(false), 
    OptionHidden.Hidden, 
    new desc($("Recognize reduction patterns.")));
//<editor-fold defaultstate="collapsed" desc="cm_name">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 70,
 FQN="cm_name", NM="_ZL7cm_name",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL7cm_name")
//</editor-fold>
public static /*const*//*char*/byte cm_name[/*20*/] = new$char(20, "Cost Model Analysis");
//<editor-fold defaultstate="collapsed" desc="initializeCostModelAnalysisPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 71,
 FQN="initializeCostModelAnalysisPassOnce", NM="_ZL35initializeCostModelAnalysisPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL35initializeCostModelAnalysisPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeCostModelAnalysisPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeCostModelAnalysisPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 72,
 FQN="InitializeCostModelAnalysisPassFlag", NM="_ZL35InitializeCostModelAnalysisPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL35InitializeCostModelAnalysisPassFlag")
//</editor-fold>
public static std.once_flag InitializeCostModelAnalysisPassFlag/*J*/= new std.once_flag();
//<editor-fold defaultstate="collapsed" desc="isReverseVectorMask">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 92,
 FQN="isReverseVectorMask", NM="_ZL19isReverseVectorMaskRN4llvm15SmallVectorImplIiEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL19isReverseVectorMaskRN4llvm15SmallVectorImplIiEE")
//</editor-fold>
public static boolean isReverseVectorMask(final SmallVectorImplInt /*&*/ Mask) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isAlternateVectorMask">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 99,
 FQN="isAlternateVectorMask", NM="_ZL21isAlternateVectorMaskRN4llvm15SmallVectorImplIiEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL21isAlternateVectorMaskRN4llvm15SmallVectorImplIiEE")
//</editor-fold>
public static boolean isAlternateVectorMask(final SmallVectorImplInt /*&*/ Mask) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getOperandInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 124,
 FQN="getOperandInfo", NM="_ZL14getOperandInfoPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL14getOperandInfoPN4llvm5ValueE")
//</editor-fold>
public static TargetTransformInfo.OperandValueKind getOperandInfo(Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="matchPairwiseShuffleMask">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 138,
 FQN="matchPairwiseShuffleMask", NM="_ZL24matchPairwiseShuffleMaskPN4llvm17ShuffleVectorInstEbj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL24matchPairwiseShuffleMaskPN4llvm17ShuffleVectorInstEbj")
//</editor-fold>
public static boolean matchPairwiseShuffleMask(ShuffleVectorInst /*P*/ SI, boolean IsLeft, 
                        /*uint*/int Level) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="matchPairwiseReductionAtLevel">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 158,
 FQN="matchPairwiseReductionAtLevel", NM="_ZL29matchPairwiseReductionAtLevelPKN4llvm14BinaryOperatorEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL29matchPairwiseReductionAtLevelPKN4llvm14BinaryOperatorEjj")
//</editor-fold>
public static boolean matchPairwiseReductionAtLevel(/*const*/ BinaryOperator /*P*/ BinOp, 
                             /*uint*/int Level, /*uint*/int NumLevels) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="matchPairwiseReduction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 239,
 FQN="matchPairwiseReduction", NM="_ZL22matchPairwiseReductionPKN4llvm18ExtractElementInstERjRPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL22matchPairwiseReductionPKN4llvm18ExtractElementInstERjRPNS_4TypeE")
//</editor-fold>
public static boolean matchPairwiseReduction(/*const*/ ExtractElementInst /*P*/ ReduxRoot, 
                      final uint$ref/*uint &*/ Opcode, final type$ref<Type /*P*/ /*&*/> Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getShuffleAndOtherOprd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 288,
 FQN="getShuffleAndOtherOprd", NM="_ZL22getShuffleAndOtherOprdPN4llvm14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL22getShuffleAndOtherOprdPN4llvm14BinaryOperatorE")
//</editor-fold>
public static std.pairPtrPtr<Value /*P*/ , ShuffleVectorInst /*P*/ > getShuffleAndOtherOprd(BinaryOperator /*P*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="matchVectorSplittingReduction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 302,
 FQN="matchVectorSplittingReduction", NM="_ZL29matchVectorSplittingReductionPKN4llvm18ExtractElementInstERjRPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZL29matchVectorSplittingReductionPKN4llvm18ExtractElementInstERjRPNS_4TypeE")
//</editor-fold>
public static boolean matchVectorSplittingReduction(/*const*/ ExtractElementInst /*P*/ ReduxRoot, 
                             final uint$ref/*uint &*/ Opcode, final type$ref<Type /*P*/ /*&*/> Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class CostModelStatics
