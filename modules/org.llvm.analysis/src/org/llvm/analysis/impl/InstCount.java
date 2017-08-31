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
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 38,
 FQN="(anonymous namespace)::InstCount", NM="_ZN12_GLOBAL__N_19InstCountE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCountE")
//</editor-fold>
public class InstCount extends /*public*/ FunctionPass implements /*public*/ InstVisitorVoid<InstCount>, Destructors.ClassWithDestructor {
  /*friend  class InstVisitor<InstCount>*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 41,
   FQN="(anonymous namespace)::InstCount::visitFunction", NM="_ZN12_GLOBAL__N_19InstCount13visitFunctionERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount13visitFunctionERN4llvm8FunctionE")
  //</editor-fold>
  public/*private*/ void visitFunction(final Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitBasicBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 42,
   FQN="(anonymous namespace)::InstCount::visitBasicBlock", NM="_ZN12_GLOBAL__N_19InstCount15visitBasicBlockERN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount15visitBasicBlockERN4llvm10BasicBlockE")
  //</editor-fold>
  public/*private*/ void visitBasicBlock(final BasicBlock /*&*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitRet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 110,
   FQN="(anonymous namespace)::InstCount::visitRet", NM="_ZN12_GLOBAL__N_19InstCount8visitRetERN4llvm10ReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount8visitRetERN4llvm10ReturnInstE")
  //</editor-fold>
  public/*private*/ void visitRet(final ReturnInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitBr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 111,
   FQN="(anonymous namespace)::InstCount::visitBr", NM="_ZN12_GLOBAL__N_19InstCount7visitBrERN4llvm10BranchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount7visitBrERN4llvm10BranchInstE")
  //</editor-fold>
  public/*private*/ void visitBr(final BranchInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitSwitch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 112,
   FQN="(anonymous namespace)::InstCount::visitSwitch", NM="_ZN12_GLOBAL__N_19InstCount11visitSwitchERN4llvm10SwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitSwitchERN4llvm10SwitchInstE")
  //</editor-fold>
  public/*private*/ void visitSwitch(final SwitchInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitIndirectBr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 113,
   FQN="(anonymous namespace)::InstCount::visitIndirectBr", NM="_ZN12_GLOBAL__N_19InstCount15visitIndirectBrERN4llvm14IndirectBrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount15visitIndirectBrERN4llvm14IndirectBrInstE")
  //</editor-fold>
  public/*private*/ void visitIndirectBr(final IndirectBrInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitInvoke">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 114,
   FQN="(anonymous namespace)::InstCount::visitInvoke", NM="_ZN12_GLOBAL__N_19InstCount11visitInvokeERN4llvm10InvokeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitInvokeERN4llvm10InvokeInstE")
  //</editor-fold>
  public/*private*/ void visitInvoke(final InvokeInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitResume">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 115,
   FQN="(anonymous namespace)::InstCount::visitResume", NM="_ZN12_GLOBAL__N_19InstCount11visitResumeERN4llvm10ResumeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitResumeERN4llvm10ResumeInstE")
  //</editor-fold>
  public/*private*/ void visitResume(final ResumeInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitUnreachable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 116,
   FQN="(anonymous namespace)::InstCount::visitUnreachable", NM="_ZN12_GLOBAL__N_19InstCount16visitUnreachableERN4llvm15UnreachableInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount16visitUnreachableERN4llvm15UnreachableInstE")
  //</editor-fold>
  public/*private*/ void visitUnreachable(final UnreachableInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitCleanupRet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 117,
   FQN="(anonymous namespace)::InstCount::visitCleanupRet", NM="_ZN12_GLOBAL__N_19InstCount15visitCleanupRetERN4llvm17CleanupReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount15visitCleanupRetERN4llvm17CleanupReturnInstE")
  //</editor-fold>
  public/*private*/ void visitCleanupRet(final CleanupReturnInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitCatchRet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 118,
   FQN="(anonymous namespace)::InstCount::visitCatchRet", NM="_ZN12_GLOBAL__N_19InstCount13visitCatchRetERN4llvm15CatchReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount13visitCatchRetERN4llvm15CatchReturnInstE")
  //</editor-fold>
  public/*private*/ void visitCatchRet(final CatchReturnInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitCatchSwitch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 119,
   FQN="(anonymous namespace)::InstCount::visitCatchSwitch", NM="_ZN12_GLOBAL__N_19InstCount16visitCatchSwitchERN4llvm15CatchSwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount16visitCatchSwitchERN4llvm15CatchSwitchInstE")
  //</editor-fold>
  public/*private*/ void visitCatchSwitch(final CatchSwitchInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitAdd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 124,
   FQN="(anonymous namespace)::InstCount::visitAdd", NM="_ZN12_GLOBAL__N_19InstCount8visitAddERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount8visitAddERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitAdd(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFAdd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 125,
   FQN="(anonymous namespace)::InstCount::visitFAdd", NM="_ZN12_GLOBAL__N_19InstCount9visitFAddERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitFAddERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitFAdd(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitSub">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 126,
   FQN="(anonymous namespace)::InstCount::visitSub", NM="_ZN12_GLOBAL__N_19InstCount8visitSubERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount8visitSubERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitSub(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFSub">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 127,
   FQN="(anonymous namespace)::InstCount::visitFSub", NM="_ZN12_GLOBAL__N_19InstCount9visitFSubERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitFSubERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitFSub(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitMul">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 128,
   FQN="(anonymous namespace)::InstCount::visitMul", NM="_ZN12_GLOBAL__N_19InstCount8visitMulERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount8visitMulERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitMul(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFMul">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 129,
   FQN="(anonymous namespace)::InstCount::visitFMul", NM="_ZN12_GLOBAL__N_19InstCount9visitFMulERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitFMulERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitFMul(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitUDiv">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 130,
   FQN="(anonymous namespace)::InstCount::visitUDiv", NM="_ZN12_GLOBAL__N_19InstCount9visitUDivERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitUDivERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitUDiv(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitSDiv">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 131,
   FQN="(anonymous namespace)::InstCount::visitSDiv", NM="_ZN12_GLOBAL__N_19InstCount9visitSDivERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitSDivERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitSDiv(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFDiv">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 132,
   FQN="(anonymous namespace)::InstCount::visitFDiv", NM="_ZN12_GLOBAL__N_19InstCount9visitFDivERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitFDivERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitFDiv(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitURem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 133,
   FQN="(anonymous namespace)::InstCount::visitURem", NM="_ZN12_GLOBAL__N_19InstCount9visitURemERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitURemERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitURem(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitSRem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 134,
   FQN="(anonymous namespace)::InstCount::visitSRem", NM="_ZN12_GLOBAL__N_19InstCount9visitSRemERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitSRemERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitSRem(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFRem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 135,
   FQN="(anonymous namespace)::InstCount::visitFRem", NM="_ZN12_GLOBAL__N_19InstCount9visitFRemERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitFRemERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitFRem(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Logical operators (integer operands)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitShl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 138,
   FQN="(anonymous namespace)::InstCount::visitShl", NM="_ZN12_GLOBAL__N_19InstCount8visitShlERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount8visitShlERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitShl(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Shift left  (logical)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitLShr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 139,
   FQN="(anonymous namespace)::InstCount::visitLShr", NM="_ZN12_GLOBAL__N_19InstCount9visitLShrERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitLShrERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitLShr(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Shift right (logical)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitAShr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 140,
   FQN="(anonymous namespace)::InstCount::visitAShr", NM="_ZN12_GLOBAL__N_19InstCount9visitAShrERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitAShrERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitAShr(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Shift right (arithmetic)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitAnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 141,
   FQN="(anonymous namespace)::InstCount::visitAnd", NM="_ZN12_GLOBAL__N_19InstCount8visitAndERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount8visitAndERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitAnd(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitOr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 142,
   FQN="(anonymous namespace)::InstCount::visitOr", NM="_ZN12_GLOBAL__N_19InstCount7visitOrERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount7visitOrERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitOr(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitXor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 143,
   FQN="(anonymous namespace)::InstCount::visitXor", NM="_ZN12_GLOBAL__N_19InstCount8visitXorERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount8visitXorERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitXor(final BinaryOperator /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitAlloca">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 148,
   FQN="(anonymous namespace)::InstCount::visitAlloca", NM="_ZN12_GLOBAL__N_19InstCount11visitAllocaERN4llvm10AllocaInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitAllocaERN4llvm10AllocaInstE")
  //</editor-fold>
  public/*private*/ void visitAlloca(final AllocaInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Stack management
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitLoad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 149,
   FQN="(anonymous namespace)::InstCount::visitLoad", NM="_ZN12_GLOBAL__N_19InstCount9visitLoadERN4llvm8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitLoadERN4llvm8LoadInstE")
  //</editor-fold>
  public/*private*/ void visitLoad(final LoadInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Memory manipulation instrs
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitStore">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 150,
   FQN="(anonymous namespace)::InstCount::visitStore", NM="_ZN12_GLOBAL__N_19InstCount10visitStoreERN4llvm9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount10visitStoreERN4llvm9StoreInstE")
  //</editor-fold>
  public/*private*/ void visitStore(final StoreInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 151,
   FQN="(anonymous namespace)::InstCount::visitGetElementPtr", NM="_ZN12_GLOBAL__N_19InstCount18visitGetElementPtrERN4llvm17GetElementPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount18visitGetElementPtrERN4llvm17GetElementPtrInstE")
  //</editor-fold>
  public/*private*/ void visitGetElementPtr(final GetElementPtrInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 152,
   FQN="(anonymous namespace)::InstCount::visitFence", NM="_ZN12_GLOBAL__N_19InstCount10visitFenceERN4llvm9FenceInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount10visitFenceERN4llvm9FenceInstE")
  //</editor-fold>
  public/*private*/ void visitFence(final FenceInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitAtomicCmpXchg">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 153,
   FQN="(anonymous namespace)::InstCount::visitAtomicCmpXchg", NM="_ZN12_GLOBAL__N_19InstCount18visitAtomicCmpXchgERN4llvm17AtomicCmpXchgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount18visitAtomicCmpXchgERN4llvm17AtomicCmpXchgInstE")
  //</editor-fold>
  public/*private*/ void visitAtomicCmpXchg(final AtomicCmpXchgInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitAtomicRMW">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 154,
   FQN="(anonymous namespace)::InstCount::visitAtomicRMW", NM="_ZN12_GLOBAL__N_19InstCount14visitAtomicRMWERN4llvm13AtomicRMWInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount14visitAtomicRMWERN4llvm13AtomicRMWInstE")
  //</editor-fold>
  public/*private*/ void visitAtomicRMW(final AtomicRMWInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitTrunc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 161,
   FQN="(anonymous namespace)::InstCount::visitTrunc", NM="_ZN12_GLOBAL__N_19InstCount10visitTruncERN4llvm9TruncInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount10visitTruncERN4llvm9TruncInstE")
  //</editor-fold>
  public/*private*/ void visitTrunc(final TruncInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Truncate integers
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitZExt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 162,
   FQN="(anonymous namespace)::InstCount::visitZExt", NM="_ZN12_GLOBAL__N_19InstCount9visitZExtERN4llvm8ZExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitZExtERN4llvm8ZExtInstE")
  //</editor-fold>
  public/*private*/ void visitZExt(final ZExtInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Zero extend integers
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitSExt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 163,
   FQN="(anonymous namespace)::InstCount::visitSExt", NM="_ZN12_GLOBAL__N_19InstCount9visitSExtERN4llvm8SExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitSExtERN4llvm8SExtInstE")
  //</editor-fold>
  public/*private*/ void visitSExt(final SExtInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Sign extend integers
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFPToUI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 164,
   FQN="(anonymous namespace)::InstCount::visitFPToUI", NM="_ZN12_GLOBAL__N_19InstCount11visitFPToUIERN4llvm10FPToUIInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitFPToUIERN4llvm10FPToUIInstE")
  //</editor-fold>
  public/*private*/ void visitFPToUI(final FPToUIInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // floating point -> UInt
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFPToSI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 165,
   FQN="(anonymous namespace)::InstCount::visitFPToSI", NM="_ZN12_GLOBAL__N_19InstCount11visitFPToSIERN4llvm10FPToSIInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitFPToSIERN4llvm10FPToSIInstE")
  //</editor-fold>
  public/*private*/ void visitFPToSI(final FPToSIInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // floating point -> SInt
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitUIToFP">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 166,
   FQN="(anonymous namespace)::InstCount::visitUIToFP", NM="_ZN12_GLOBAL__N_19InstCount11visitUIToFPERN4llvm10UIToFPInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitUIToFPERN4llvm10UIToFPInstE")
  //</editor-fold>
  public/*private*/ void visitUIToFP(final UIToFPInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // UInt -> floating point
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitSIToFP">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 167,
   FQN="(anonymous namespace)::InstCount::visitSIToFP", NM="_ZN12_GLOBAL__N_19InstCount11visitSIToFPERN4llvm10SIToFPInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitSIToFPERN4llvm10SIToFPInstE")
  //</editor-fold>
  public/*private*/ void visitSIToFP(final SIToFPInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // SInt -> floating point
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFPTrunc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 168,
   FQN="(anonymous namespace)::InstCount::visitFPTrunc", NM="_ZN12_GLOBAL__N_19InstCount12visitFPTruncERN4llvm11FPTruncInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount12visitFPTruncERN4llvm11FPTruncInstE")
  //</editor-fold>
  public/*private*/ void visitFPTrunc(final FPTruncInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Truncate floating point
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFPExt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 169,
   FQN="(anonymous namespace)::InstCount::visitFPExt", NM="_ZN12_GLOBAL__N_19InstCount10visitFPExtERN4llvm9FPExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount10visitFPExtERN4llvm9FPExtInstE")
  //</editor-fold>
  public/*private*/ void visitFPExt(final FPExtInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Extend floating point
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitPtrToInt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 170,
   FQN="(anonymous namespace)::InstCount::visitPtrToInt", NM="_ZN12_GLOBAL__N_19InstCount13visitPtrToIntERN4llvm12PtrToIntInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount13visitPtrToIntERN4llvm12PtrToIntInstE")
  //</editor-fold>
  public/*private*/ void visitPtrToInt(final PtrToIntInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Pointer -> Integer
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitIntToPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 171,
   FQN="(anonymous namespace)::InstCount::visitIntToPtr", NM="_ZN12_GLOBAL__N_19InstCount13visitIntToPtrERN4llvm12IntToPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount13visitIntToPtrERN4llvm12IntToPtrInstE")
  //</editor-fold>
  public/*private*/ void visitIntToPtr(final IntToPtrInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Integer -> Pointer
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitBitCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 172,
   FQN="(anonymous namespace)::InstCount::visitBitCast", NM="_ZN12_GLOBAL__N_19InstCount12visitBitCastERN4llvm11BitCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount12visitBitCastERN4llvm11BitCastInstE")
  //</editor-fold>
  public/*private*/ void visitBitCast(final BitCastInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Type cast
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 173,
   FQN="(anonymous namespace)::InstCount::visitAddrSpaceCast", NM="_ZN12_GLOBAL__N_19InstCount18visitAddrSpaceCastERN4llvm17AddrSpaceCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount18visitAddrSpaceCastERN4llvm17AddrSpaceCastInstE")
  //</editor-fold>
  public/*private*/ void visitAddrSpaceCast(final AddrSpaceCastInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitCleanupPad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 177,
   FQN="(anonymous namespace)::InstCount::visitCleanupPad", NM="_ZN12_GLOBAL__N_19InstCount15visitCleanupPadERN4llvm14CleanupPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount15visitCleanupPadERN4llvm14CleanupPadInstE")
  //</editor-fold>
  public/*private*/ void visitCleanupPad(final CleanupPadInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitCatchPad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 178,
   FQN="(anonymous namespace)::InstCount::visitCatchPad", NM="_ZN12_GLOBAL__N_19InstCount13visitCatchPadERN4llvm12CatchPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount13visitCatchPadERN4llvm12CatchPadInstE")
  //</editor-fold>
  public/*private*/ void visitCatchPad(final CatchPadInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitICmp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 183,
   FQN="(anonymous namespace)::InstCount::visitICmp", NM="_ZN12_GLOBAL__N_19InstCount9visitICmpERN4llvm8ICmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitICmpERN4llvm8ICmpInstE")
  //</editor-fold>
  public/*private*/ void visitICmp(final ICmpInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Integer comparison instruction
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitFCmp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 184,
   FQN="(anonymous namespace)::InstCount::visitFCmp", NM="_ZN12_GLOBAL__N_19InstCount9visitFCmpERN4llvm8FCmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitFCmpERN4llvm8FCmpInstE")
  //</editor-fold>
  public/*private*/ void visitFCmp(final FCmpInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Floating point comparison instr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitPHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 185,
   FQN="(anonymous namespace)::InstCount::visitPHI", NM="_ZN12_GLOBAL__N_19InstCount8visitPHIERN4llvm7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount8visitPHIERN4llvm7PHINodeE")
  //</editor-fold>
  public/*private*/ void visitPHI(final PHINode /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // PHI node instruction
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 186,
   FQN="(anonymous namespace)::InstCount::visitCall", NM="_ZN12_GLOBAL__N_19InstCount9visitCallERN4llvm8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount9visitCallERN4llvm8CallInstE")
  //</editor-fold>
  public/*private*/ void visitCall(final CallInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Call a function
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitSelect">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 187,
   FQN="(anonymous namespace)::InstCount::visitSelect", NM="_ZN12_GLOBAL__N_19InstCount11visitSelectERN4llvm10SelectInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount11visitSelectERN4llvm10SelectInstE")
  //</editor-fold>
  public/*private*/ void visitSelect(final SelectInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // select instruction
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitUserOp1">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 188,
   FQN="(anonymous namespace)::InstCount::visitUserOp1", NM="_ZN12_GLOBAL__N_19InstCount12visitUserOp1ERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount12visitUserOp1ERN4llvm11InstructionE")
  //</editor-fold>
  public/*private*/ void visitUserOp1(final Instruction /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // May be used internally in a pass
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitUserOp2">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 189,
   FQN="(anonymous namespace)::InstCount::visitUserOp2", NM="_ZN12_GLOBAL__N_19InstCount12visitUserOp2ERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount12visitUserOp2ERN4llvm11InstructionE")
  //</editor-fold>
  public/*private*/ void visitUserOp2(final Instruction /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Internal to passes only
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitVAArg">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 190,
   FQN="(anonymous namespace)::InstCount::visitVAArg", NM="_ZN12_GLOBAL__N_19InstCount10visitVAArgERN4llvm9VAArgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount10visitVAArgERN4llvm9VAArgInstE")
  //</editor-fold>
  public/*private*/ void visitVAArg(final VAArgInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // vaarg instruction
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitExtractElement">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 191,
   FQN="(anonymous namespace)::InstCount::visitExtractElement", NM="_ZN12_GLOBAL__N_19InstCount19visitExtractElementERN4llvm18ExtractElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount19visitExtractElementERN4llvm18ExtractElementInstE")
  //</editor-fold>
  public/*private*/ void visitExtractElement(final ExtractElementInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // extract from vector
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitInsertElement">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 192,
   FQN="(anonymous namespace)::InstCount::visitInsertElement", NM="_ZN12_GLOBAL__N_19InstCount18visitInsertElementERN4llvm17InsertElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount18visitInsertElementERN4llvm17InsertElementInstE")
  //</editor-fold>
  public/*private*/ void visitInsertElement(final InsertElementInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // insert into vector
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitShuffleVector">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 193,
   FQN="(anonymous namespace)::InstCount::visitShuffleVector", NM="_ZN12_GLOBAL__N_19InstCount18visitShuffleVectorERN4llvm17ShuffleVectorInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount18visitShuffleVectorERN4llvm17ShuffleVectorInstE")
  //</editor-fold>
  public/*private*/ void visitShuffleVector(final ShuffleVectorInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // shuffle two vectors.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitExtractValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 194,
   FQN="(anonymous namespace)::InstCount::visitExtractValue", NM="_ZN12_GLOBAL__N_19InstCount17visitExtractValueERN4llvm16ExtractValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount17visitExtractValueERN4llvm16ExtractValueInstE")
  //</editor-fold>
  public/*private*/ void visitExtractValue(final ExtractValueInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // extract from aggregate
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitInsertValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 195,
   FQN="(anonymous namespace)::InstCount::visitInsertValue", NM="_ZN12_GLOBAL__N_19InstCount16visitInsertValueERN4llvm15InsertValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount16visitInsertValueERN4llvm15InsertValueInstE")
  //</editor-fold>
  public/*private*/ void visitInsertValue(final InsertValueInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // insert into aggregate
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitLandingPad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 196,
   FQN="(anonymous namespace)::InstCount::visitLandingPad", NM="_ZN12_GLOBAL__N_19InstCount15visitLandingPadERN4llvm14LandingPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount15visitLandingPadERN4llvm14LandingPadInstE")
  //</editor-fold>
  public/*private*/ void visitLandingPad(final LandingPadInst /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::visitInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 49,
   FQN="(anonymous namespace)::InstCount::visitInstruction", NM="_ZN12_GLOBAL__N_19InstCount16visitInstructionERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount16visitInstructionERN4llvm11InstructionE")
  //</editor-fold>
  public/*private*/ void visitInstruction(final Instruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  public static final/*char*/Class<InstCount> ID = InstCount.class; // Pass identification, replacement for typeid
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::InstCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 55,
   FQN="(anonymous namespace)::InstCount::InstCount", NM="_ZN12_GLOBAL__N_19InstCountC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCountC1Ev")
  //</editor-fold>
  public InstCount() {
    // : FunctionPass(ID), InstVisitor<InstCount>() 
    super(ID);
    $InstVisitor();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  // InstCount::run - This is the main Analysis entry point for a
  // function.
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 78,
   FQN="(anonymous namespace)::InstCount::runOnFunction", NM="_ZN12_GLOBAL__N_19InstCount13runOnFunctionERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCount13runOnFunctionERN4llvm8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 61,
   FQN="(anonymous namespace)::InstCount::getAnalysisUsage", NM="_ZNK12_GLOBAL__N_19InstCount16getAnalysisUsageERN4llvm13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK12_GLOBAL__N_19InstCount16getAnalysisUsageERN4llvm13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 64,
   FQN="(anonymous namespace)::InstCount::print", NM="_ZNK12_GLOBAL__N_19InstCount5printERN4llvm11raw_ostreamEPKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK12_GLOBAL__N_19InstCount5printERN4llvm11raw_ostreamEPKNS1_6ModuleE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ O, /*const*/ Module /*P*/ M) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InstCount::~InstCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 38,
   FQN="(anonymous namespace)::InstCount::~InstCount", NM="_ZN12_GLOBAL__N_19InstCountD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN12_GLOBAL__N_19InstCountD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
