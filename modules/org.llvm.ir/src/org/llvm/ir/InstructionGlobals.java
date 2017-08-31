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
package org.llvm.ir;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type InstructionGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.InstructionGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumAddInst;_ZL10NumAndInst;_ZL10NumMulInst;_ZL10NumPHIInst;_ZL10NumRetInst;_ZL10NumShlInst;_ZL10NumSubInst;_ZL10NumXorInst;_ZL11NumAShrInst;_ZL11NumCallInst;_ZL11NumFAddInst;_ZL11NumFCmpInst;_ZL11NumFDivInst;_ZL11NumFMulInst;_ZL11NumFRemInst;_ZL11NumFSubInst;_ZL11NumICmpInst;_ZL11NumLShrInst;_ZL11NumLoadInst;_ZL11NumSDivInst;_ZL11NumSExtInst;_ZL11NumSRemInst;_ZL11NumUDivInst;_ZL11NumURemInst;_ZL11NumZExtInst;_ZL12NumFPExtInst;_ZL12NumFenceInst;_ZL12NumStoreInst;_ZL12NumTruncInst;_ZL12NumVAArgInst;_ZL13NumAllocaInst;_ZL13NumFPToSIInst;_ZL13NumFPToUIInst;_ZL13NumInvokeInst;_ZL13NumResumeInst;_ZL13NumSIToFPInst;_ZL13NumSelectInst;_ZL13NumSwitchInst;_ZL13NumUIToFPInst;_ZL14NumBitCastInst;_ZL14NumFPTruncInst;_ZL14NumUserOp1Inst;_ZL14NumUserOp2Inst;_ZL15NumCatchPadInst;_ZL15NumCatchRetInst;_ZL15NumIntToPtrInst;_ZL15NumPtrToIntInst;_ZL16NumAtomicRMWInst;_ZL17NumCleanupPadInst;_ZL17NumCleanupRetInst;_ZL17NumIndirectBrInst;_ZL17NumLandingPadInst;_ZL18NumCatchSwitchInst;_ZL18NumInsertValueInst;_ZL18NumUnreachableInst;_ZL19NumExtractValueInst;_ZL20NumAddrSpaceCastInst;_ZL20NumAtomicCmpXchgInst;_ZL20NumGetElementPtrInst;_ZL20NumInsertElementInst;_ZL20NumShuffleVectorInst;_ZL21NumExtractElementInst;_ZL9NumBrInst;_ZL9NumOrInst; -static-type=InstructionGlobals -package=org.llvm.ir")
//</editor-fold>
public final class InstructionGlobals {

//<editor-fold defaultstate="collapsed" desc="NumRetInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 110,
 FQN="NumRetInst", NM="_ZL10NumRetInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumRetInst")
//</editor-fold>
public static Statistic NumRetInst = new Statistic($("instcount"), $("NumRetInst"), $("Number of Ret insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumBrInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 111,
 FQN="NumBrInst", NM="_ZL9NumBrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL9NumBrInst")
//</editor-fold>
public static Statistic NumBrInst = new Statistic($("instcount"), $("NumBrInst"), $("Number of Br insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumSwitchInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 112,
 FQN="NumSwitchInst", NM="_ZL13NumSwitchInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumSwitchInst")
//</editor-fold>
public static Statistic NumSwitchInst = new Statistic($("instcount"), $("NumSwitchInst"), $("Number of Switch insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumIndirectBrInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 113,
 FQN="NumIndirectBrInst", NM="_ZL17NumIndirectBrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL17NumIndirectBrInst")
//</editor-fold>
public static Statistic NumIndirectBrInst = new Statistic($("instcount"), $("NumIndirectBrInst"), $("Number of IndirectBr insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumInvokeInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 114,
 FQN="NumInvokeInst", NM="_ZL13NumInvokeInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumInvokeInst")
//</editor-fold>
public static Statistic NumInvokeInst = new Statistic($("instcount"), $("NumInvokeInst"), $("Number of Invoke insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumResumeInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 115,
 FQN="NumResumeInst", NM="_ZL13NumResumeInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumResumeInst")
//</editor-fold>
public static Statistic NumResumeInst = new Statistic($("instcount"), $("NumResumeInst"), $("Number of Resume insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumUnreachableInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 116,
 FQN="NumUnreachableInst", NM="_ZL18NumUnreachableInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL18NumUnreachableInst")
//</editor-fold>
public static Statistic NumUnreachableInst = new Statistic($("instcount"), $("NumUnreachableInst"), $("Number of Unreachable insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCleanupRetInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 117,
 FQN="NumCleanupRetInst", NM="_ZL17NumCleanupRetInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL17NumCleanupRetInst")
//</editor-fold>
public static Statistic NumCleanupRetInst = new Statistic($("instcount"), $("NumCleanupRetInst"), $("Number of CleanupRet insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCatchRetInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 118,
 FQN="NumCatchRetInst", NM="_ZL15NumCatchRetInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL15NumCatchRetInst")
//</editor-fold>
public static Statistic NumCatchRetInst = new Statistic($("instcount"), $("NumCatchRetInst"), $("Number of CatchRet insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCatchSwitchInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 119,
 FQN="NumCatchSwitchInst", NM="_ZL18NumCatchSwitchInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL18NumCatchSwitchInst")
//</editor-fold>
public static Statistic NumCatchSwitchInst = new Statistic($("instcount"), $("NumCatchSwitchInst"), $("Number of CatchSwitch insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumAddInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 124,
 FQN="NumAddInst", NM="_ZL10NumAddInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumAddInst")
//</editor-fold>
public static Statistic NumAddInst = new Statistic($("instcount"), $("NumAddInst"), $("Number of Add insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFAddInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 125,
 FQN="NumFAddInst", NM="_ZL11NumFAddInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumFAddInst")
//</editor-fold>
public static Statistic NumFAddInst = new Statistic($("instcount"), $("NumFAddInst"), $("Number of FAdd insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumSubInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 126,
 FQN="NumSubInst", NM="_ZL10NumSubInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumSubInst")
//</editor-fold>
public static Statistic NumSubInst = new Statistic($("instcount"), $("NumSubInst"), $("Number of Sub insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFSubInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 127,
 FQN="NumFSubInst", NM="_ZL11NumFSubInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumFSubInst")
//</editor-fold>
public static Statistic NumFSubInst = new Statistic($("instcount"), $("NumFSubInst"), $("Number of FSub insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumMulInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 128,
 FQN="NumMulInst", NM="_ZL10NumMulInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumMulInst")
//</editor-fold>
public static Statistic NumMulInst = new Statistic($("instcount"), $("NumMulInst"), $("Number of Mul insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFMulInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 129,
 FQN="NumFMulInst", NM="_ZL11NumFMulInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumFMulInst")
//</editor-fold>
public static Statistic NumFMulInst = new Statistic($("instcount"), $("NumFMulInst"), $("Number of FMul insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumUDivInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 130,
 FQN="NumUDivInst", NM="_ZL11NumUDivInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumUDivInst")
//</editor-fold>
public static Statistic NumUDivInst = new Statistic($("instcount"), $("NumUDivInst"), $("Number of UDiv insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumSDivInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 131,
 FQN="NumSDivInst", NM="_ZL11NumSDivInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumSDivInst")
//</editor-fold>
public static Statistic NumSDivInst = new Statistic($("instcount"), $("NumSDivInst"), $("Number of SDiv insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFDivInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 132,
 FQN="NumFDivInst", NM="_ZL11NumFDivInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumFDivInst")
//</editor-fold>
public static Statistic NumFDivInst = new Statistic($("instcount"), $("NumFDivInst"), $("Number of FDiv insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumURemInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 133,
 FQN="NumURemInst", NM="_ZL11NumURemInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumURemInst")
//</editor-fold>
public static Statistic NumURemInst = new Statistic($("instcount"), $("NumURemInst"), $("Number of URem insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumSRemInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 134,
 FQN="NumSRemInst", NM="_ZL11NumSRemInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumSRemInst")
//</editor-fold>
public static Statistic NumSRemInst = new Statistic($("instcount"), $("NumSRemInst"), $("Number of SRem insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFRemInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 135,
 FQN="NumFRemInst", NM="_ZL11NumFRemInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumFRemInst")
//</editor-fold>
public static Statistic NumFRemInst = new Statistic($("instcount"), $("NumFRemInst"), $("Number of FRem insts"), 0, false);

// Logical operators (integer operands)
//<editor-fold defaultstate="collapsed" desc="NumShlInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 138,
 FQN="NumShlInst", NM="_ZL10NumShlInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumShlInst")
//</editor-fold>
public static Statistic NumShlInst = new Statistic($("instcount"), $("NumShlInst"), $("Number of Shl insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumLShrInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 139,
 FQN="NumLShrInst", NM="_ZL11NumLShrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumLShrInst")
//</editor-fold>
public static Statistic NumLShrInst = new Statistic($("instcount"), $("NumLShrInst"), $("Number of LShr insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumAShrInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 140,
 FQN="NumAShrInst", NM="_ZL11NumAShrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumAShrInst")
//</editor-fold>
public static Statistic NumAShrInst = new Statistic($("instcount"), $("NumAShrInst"), $("Number of AShr insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumAndInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 141,
 FQN="NumAndInst", NM="_ZL10NumAndInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumAndInst")
//</editor-fold>
public static Statistic NumAndInst = new Statistic($("instcount"), $("NumAndInst"), $("Number of And insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumOrInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 142,
 FQN="NumOrInst", NM="_ZL9NumOrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL9NumOrInst")
//</editor-fold>
public static Statistic NumOrInst = new Statistic($("instcount"), $("NumOrInst"), $("Number of Or insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumXorInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 143,
 FQN="NumXorInst", NM="_ZL10NumXorInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumXorInst")
//</editor-fold>
public static Statistic NumXorInst = new Statistic($("instcount"), $("NumXorInst"), $("Number of Xor insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumAllocaInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 148,
 FQN="NumAllocaInst", NM="_ZL13NumAllocaInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumAllocaInst")
//</editor-fold>
public static Statistic NumAllocaInst = new Statistic($("instcount"), $("NumAllocaInst"), $("Number of Alloca insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumLoadInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 149,
 FQN="NumLoadInst", NM="_ZL11NumLoadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumLoadInst")
//</editor-fold>
public static Statistic NumLoadInst = new Statistic($("instcount"), $("NumLoadInst"), $("Number of Load insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumStoreInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 150,
 FQN="NumStoreInst", NM="_ZL12NumStoreInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL12NumStoreInst")
//</editor-fold>
public static Statistic NumStoreInst = new Statistic($("instcount"), $("NumStoreInst"), $("Number of Store insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumGetElementPtrInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 151,
 FQN="NumGetElementPtrInst", NM="_ZL20NumGetElementPtrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL20NumGetElementPtrInst")
//</editor-fold>
public static Statistic NumGetElementPtrInst = new Statistic($("instcount"), $("NumGetElementPtrInst"), $("Number of GetElementPtr insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFenceInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 152,
 FQN="NumFenceInst", NM="_ZL12NumFenceInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL12NumFenceInst")
//</editor-fold>
public static Statistic NumFenceInst = new Statistic($("instcount"), $("NumFenceInst"), $("Number of Fence insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumAtomicCmpXchgInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 153,
 FQN="NumAtomicCmpXchgInst", NM="_ZL20NumAtomicCmpXchgInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL20NumAtomicCmpXchgInst")
//</editor-fold>
public static Statistic NumAtomicCmpXchgInst = new Statistic($("instcount"), $("NumAtomicCmpXchgInst"), $("Number of AtomicCmpXchg insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumAtomicRMWInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 154,
 FQN="NumAtomicRMWInst", NM="_ZL16NumAtomicRMWInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL16NumAtomicRMWInst")
//</editor-fold>
public static Statistic NumAtomicRMWInst = new Statistic($("instcount"), $("NumAtomicRMWInst"), $("Number of AtomicRMW insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumTruncInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 161,
 FQN="NumTruncInst", NM="_ZL12NumTruncInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL12NumTruncInst")
//</editor-fold>
public static Statistic NumTruncInst = new Statistic($("instcount"), $("NumTruncInst"), $("Number of Trunc insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumZExtInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 162,
 FQN="NumZExtInst", NM="_ZL11NumZExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumZExtInst")
//</editor-fold>
public static Statistic NumZExtInst = new Statistic($("instcount"), $("NumZExtInst"), $("Number of ZExt insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumSExtInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 163,
 FQN="NumSExtInst", NM="_ZL11NumSExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumSExtInst")
//</editor-fold>
public static Statistic NumSExtInst = new Statistic($("instcount"), $("NumSExtInst"), $("Number of SExt insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFPToUIInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 164,
 FQN="NumFPToUIInst", NM="_ZL13NumFPToUIInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumFPToUIInst")
//</editor-fold>
public static Statistic NumFPToUIInst = new Statistic($("instcount"), $("NumFPToUIInst"), $("Number of FPToUI insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFPToSIInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 165,
 FQN="NumFPToSIInst", NM="_ZL13NumFPToSIInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumFPToSIInst")
//</editor-fold>
public static Statistic NumFPToSIInst = new Statistic($("instcount"), $("NumFPToSIInst"), $("Number of FPToSI insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumUIToFPInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 166,
 FQN="NumUIToFPInst", NM="_ZL13NumUIToFPInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumUIToFPInst")
//</editor-fold>
public static Statistic NumUIToFPInst = new Statistic($("instcount"), $("NumUIToFPInst"), $("Number of UIToFP insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumSIToFPInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 167,
 FQN="NumSIToFPInst", NM="_ZL13NumSIToFPInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumSIToFPInst")
//</editor-fold>
public static Statistic NumSIToFPInst = new Statistic($("instcount"), $("NumSIToFPInst"), $("Number of SIToFP insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFPTruncInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 168,
 FQN="NumFPTruncInst", NM="_ZL14NumFPTruncInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL14NumFPTruncInst")
//</editor-fold>
public static Statistic NumFPTruncInst = new Statistic($("instcount"), $("NumFPTruncInst"), $("Number of FPTrunc insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFPExtInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 169,
 FQN="NumFPExtInst", NM="_ZL12NumFPExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL12NumFPExtInst")
//</editor-fold>
public static Statistic NumFPExtInst = new Statistic($("instcount"), $("NumFPExtInst"), $("Number of FPExt insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumPtrToIntInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 170,
 FQN="NumPtrToIntInst", NM="_ZL15NumPtrToIntInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL15NumPtrToIntInst")
//</editor-fold>
public static Statistic NumPtrToIntInst = new Statistic($("instcount"), $("NumPtrToIntInst"), $("Number of PtrToInt insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumIntToPtrInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 171,
 FQN="NumIntToPtrInst", NM="_ZL15NumIntToPtrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL15NumIntToPtrInst")
//</editor-fold>
public static Statistic NumIntToPtrInst = new Statistic($("instcount"), $("NumIntToPtrInst"), $("Number of IntToPtr insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumBitCastInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 172,
 FQN="NumBitCastInst", NM="_ZL14NumBitCastInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL14NumBitCastInst")
//</editor-fold>
public static Statistic NumBitCastInst = new Statistic($("instcount"), $("NumBitCastInst"), $("Number of BitCast insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumAddrSpaceCastInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 173,
 FQN="NumAddrSpaceCastInst", NM="_ZL20NumAddrSpaceCastInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL20NumAddrSpaceCastInst")
//</editor-fold>
public static Statistic NumAddrSpaceCastInst = new Statistic($("instcount"), $("NumAddrSpaceCastInst"), $("Number of AddrSpaceCast insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCleanupPadInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 177,
 FQN="NumCleanupPadInst", NM="_ZL17NumCleanupPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL17NumCleanupPadInst")
//</editor-fold>
public static Statistic NumCleanupPadInst = new Statistic($("instcount"), $("NumCleanupPadInst"), $("Number of CleanupPad insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCatchPadInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 178,
 FQN="NumCatchPadInst", NM="_ZL15NumCatchPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL15NumCatchPadInst")
//</editor-fold>
public static Statistic NumCatchPadInst = new Statistic($("instcount"), $("NumCatchPadInst"), $("Number of CatchPad insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumICmpInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 183,
 FQN="NumICmpInst", NM="_ZL11NumICmpInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumICmpInst")
//</editor-fold>
public static Statistic NumICmpInst = new Statistic($("instcount"), $("NumICmpInst"), $("Number of ICmp insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumFCmpInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 184,
 FQN="NumFCmpInst", NM="_ZL11NumFCmpInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumFCmpInst")
//</editor-fold>
public static Statistic NumFCmpInst = new Statistic($("instcount"), $("NumFCmpInst"), $("Number of FCmp insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumPHIInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 185,
 FQN="NumPHIInst", NM="_ZL10NumPHIInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL10NumPHIInst")
//</editor-fold>
public static Statistic NumPHIInst = new Statistic($("instcount"), $("NumPHIInst"), $("Number of PHI insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCallInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 186,
 FQN="NumCallInst", NM="_ZL11NumCallInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL11NumCallInst")
//</editor-fold>
public static Statistic NumCallInst = new Statistic($("instcount"), $("NumCallInst"), $("Number of Call insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumSelectInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 187,
 FQN="NumSelectInst", NM="_ZL13NumSelectInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL13NumSelectInst")
//</editor-fold>
public static Statistic NumSelectInst = new Statistic($("instcount"), $("NumSelectInst"), $("Number of Select insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumUserOp1Inst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 188,
 FQN="NumUserOp1Inst", NM="_ZL14NumUserOp1Inst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL14NumUserOp1Inst")
//</editor-fold>
public static Statistic NumUserOp1Inst = new Statistic($("instcount"), $("NumUserOp1Inst"), $("Number of UserOp1 insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumUserOp2Inst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 189,
 FQN="NumUserOp2Inst", NM="_ZL14NumUserOp2Inst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL14NumUserOp2Inst")
//</editor-fold>
public static Statistic NumUserOp2Inst = new Statistic($("instcount"), $("NumUserOp2Inst"), $("Number of UserOp2 insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumVAArgInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 190,
 FQN="NumVAArgInst", NM="_ZL12NumVAArgInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL12NumVAArgInst")
//</editor-fold>
public static Statistic NumVAArgInst = new Statistic($("instcount"), $("NumVAArgInst"), $("Number of VAArg insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumExtractElementInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 191,
 FQN="NumExtractElementInst", NM="_ZL21NumExtractElementInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL21NumExtractElementInst")
//</editor-fold>
public static Statistic NumExtractElementInst = new Statistic($("instcount"), $("NumExtractElementInst"), $("Number of ExtractElement insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumInsertElementInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 192,
 FQN="NumInsertElementInst", NM="_ZL20NumInsertElementInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL20NumInsertElementInst")
//</editor-fold>
public static Statistic NumInsertElementInst = new Statistic($("instcount"), $("NumInsertElementInst"), $("Number of InsertElement insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumShuffleVectorInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 193,
 FQN="NumShuffleVectorInst", NM="_ZL20NumShuffleVectorInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL20NumShuffleVectorInst")
//</editor-fold>
public static Statistic NumShuffleVectorInst = new Statistic($("instcount"), $("NumShuffleVectorInst"), $("Number of ShuffleVector insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumExtractValueInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 194,
 FQN="NumExtractValueInst", NM="_ZL19NumExtractValueInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL19NumExtractValueInst")
//</editor-fold>
public static Statistic NumExtractValueInst = new Statistic($("instcount"), $("NumExtractValueInst"), $("Number of ExtractValue insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumInsertValueInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 195,
 FQN="NumInsertValueInst", NM="_ZL18NumInsertValueInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL18NumInsertValueInst")
//</editor-fold>
public static Statistic NumInsertValueInst = new Statistic($("instcount"), $("NumInsertValueInst"), $("Number of InsertValue insts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumLandingPadInst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 196,
 FQN="NumLandingPadInst", NM="_ZL17NumLandingPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZL17NumLandingPadInst")
//</editor-fold>
public static Statistic NumLandingPadInst = new Statistic($("instcount"), $("NumLandingPadInst"), $("Number of LandingPad insts"), 0, false);
} // END OF class InstructionGlobals
