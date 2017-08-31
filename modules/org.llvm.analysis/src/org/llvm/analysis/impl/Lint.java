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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 69,
 FQN="(anonymous namespace)::Lint", NM="_ZN12_GLOBAL__N_14LintE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14LintE")
//</editor-fold>
public class Lint extends /*public*/ FunctionPass implements /*public*/ InstVisitorVoid<Lint>, Destructors.ClassWithDestructor {
  /*friend  class InstVisitor<Lint>*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 194,
   FQN="(anonymous namespace)::Lint::visitFunction", NM="_ZN12_GLOBAL__N_14Lint13visitFunctionERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint13visitFunctionERN4llvm8FunctionE")
  //</editor-fold>
  public/*private*/ void visitFunction(final Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitCallSite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 203,
   FQN="(anonymous namespace)::Lint::visitCallSite", NM="_ZN12_GLOBAL__N_14Lint13visitCallSiteEN4llvm8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint13visitCallSiteEN4llvm8CallSiteE")
  //</editor-fold>
  public/*private*/ void visitCallSite(CallSite CS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // TODO: Check that the reference is in bounds.
  // TODO: Check readnone/readonly function attributes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitMemoryReference">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 372,
   FQN="(anonymous namespace)::Lint::visitMemoryReference", NM="_ZN12_GLOBAL__N_14Lint20visitMemoryReferenceERN4llvm11InstructionEPNS1_5ValueEyjPNS1_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint20visitMemoryReferenceERN4llvm11InstructionEPNS1_5ValueEyjPNS1_4TypeEj")
  //</editor-fold>
  private void visitMemoryReference(final Instruction /*&*/ I, 
                      Value /*P*/ Ptr, long/*uint64_t*/ Size, /*uint*/int Align, 
                      Type /*P*/ Ty, /*uint*/int Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitEHBeginCatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 78,
   FQN="(anonymous namespace)::Lint::visitEHBeginCatch", NM="_ZN12_GLOBAL__N_14Lint17visitEHBeginCatchEPN4llvm13IntrinsicInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint17visitEHBeginCatchEPN4llvm13IntrinsicInstE")
  //</editor-fold>
  private void visitEHBeginCatch(IntrinsicInst /*P*/ II) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitEHEndCatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 79,
   FQN="(anonymous namespace)::Lint::visitEHEndCatch", NM="_ZN12_GLOBAL__N_14Lint15visitEHEndCatchEPN4llvm13IntrinsicInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint15visitEHEndCatchEPN4llvm13IntrinsicInstE")
  //</editor-fold>
  private void visitEHEndCatch(IntrinsicInst /*P*/ II) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitCallInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 351,
   FQN="(anonymous namespace)::Lint::visitCallInst", NM="_ZN12_GLOBAL__N_14Lint13visitCallInstERN4llvm8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint13visitCallInstERN4llvm8CallInstE")
  //</editor-fold>
  public/*private*/ void visitCallInst(final CallInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitInvokeInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 355,
   FQN="(anonymous namespace)::Lint::visitInvokeInst", NM="_ZN12_GLOBAL__N_14Lint15visitInvokeInstERN4llvm10InvokeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint15visitInvokeInstERN4llvm10InvokeInstE")
  //</editor-fold>
  public/*private*/ void visitInvokeInst(final InvokeInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitReturnInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 359,
   FQN="(anonymous namespace)::Lint::visitReturnInst", NM="_ZN12_GLOBAL__N_14Lint15visitReturnInstERN4llvm10ReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint15visitReturnInstERN4llvm10ReturnInstE")
  //</editor-fold>
  public/*private*/ void visitReturnInst(final ReturnInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitLoadInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 463,
   FQN="(anonymous namespace)::Lint::visitLoadInst", NM="_ZN12_GLOBAL__N_14Lint13visitLoadInstERN4llvm8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint13visitLoadInstERN4llvm8LoadInstE")
  //</editor-fold>
  public/*private*/ void visitLoadInst(final LoadInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitStoreInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 469,
   FQN="(anonymous namespace)::Lint::visitStoreInst", NM="_ZN12_GLOBAL__N_14Lint14visitStoreInstERN4llvm9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint14visitStoreInstERN4llvm9StoreInstE")
  //</editor-fold>
  public/*private*/ void visitStoreInst(final StoreInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitXor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 476,
   FQN="(anonymous namespace)::Lint::visitXor", NM="_ZN12_GLOBAL__N_14Lint8visitXorERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint8visitXorERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitXor(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitSub">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 481,
   FQN="(anonymous namespace)::Lint::visitSub", NM="_ZN12_GLOBAL__N_14Lint8visitSubERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint8visitSubERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitSub(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitLShr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 486,
   FQN="(anonymous namespace)::Lint::visitLShr", NM="_ZN12_GLOBAL__N_14Lint9visitLShrERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint9visitLShrERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitLShr(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitAShr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 493,
   FQN="(anonymous namespace)::Lint::visitAShr", NM="_ZN12_GLOBAL__N_14Lint9visitAShrERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint9visitAShrERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitAShr(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitShl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 500,
   FQN="(anonymous namespace)::Lint::visitShl", NM="_ZN12_GLOBAL__N_14Lint8visitShlERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint8visitShlERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitShl(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitSDiv">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 547,
   FQN="(anonymous namespace)::Lint::visitSDiv", NM="_ZN12_GLOBAL__N_14Lint9visitSDivERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint9visitSDivERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitSDiv(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitUDiv">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 552,
   FQN="(anonymous namespace)::Lint::visitUDiv", NM="_ZN12_GLOBAL__N_14Lint9visitUDivERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint9visitUDivERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitUDiv(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitSRem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 557,
   FQN="(anonymous namespace)::Lint::visitSRem", NM="_ZN12_GLOBAL__N_14Lint9visitSRemERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint9visitSRemERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitSRem(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitURem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 562,
   FQN="(anonymous namespace)::Lint::visitURem", NM="_ZN12_GLOBAL__N_14Lint9visitURemERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint9visitURemERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ void visitURem(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitAllocaInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 567,
   FQN="(anonymous namespace)::Lint::visitAllocaInst", NM="_ZN12_GLOBAL__N_14Lint15visitAllocaInstERN4llvm10AllocaInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint15visitAllocaInstERN4llvm10AllocaInstE")
  //</editor-fold>
  public/*private*/ void visitAllocaInst(final AllocaInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitVAArgInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 576,
   FQN="(anonymous namespace)::Lint::visitVAArgInst", NM="_ZN12_GLOBAL__N_14Lint14visitVAArgInstERN4llvm9VAArgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint14visitVAArgInstERN4llvm9VAArgInstE")
  //</editor-fold>
  public/*private*/ void visitVAArgInst(final VAArgInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitIndirectBrInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 581,
   FQN="(anonymous namespace)::Lint::visitIndirectBrInst", NM="_ZN12_GLOBAL__N_14Lint19visitIndirectBrInstERN4llvm14IndirectBrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint19visitIndirectBrInstERN4llvm14IndirectBrInstE")
  //</editor-fold>
  public/*private*/ void visitIndirectBrInst(final IndirectBrInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitExtractElementInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 589,
   FQN="(anonymous namespace)::Lint::visitExtractElementInst", NM="_ZN12_GLOBAL__N_14Lint23visitExtractElementInstERN4llvm18ExtractElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint23visitExtractElementInstERN4llvm18ExtractElementInstE")
  //</editor-fold>
  public/*private*/ void visitExtractElementInst(final ExtractElementInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitInsertElementInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 596,
   FQN="(anonymous namespace)::Lint::visitInsertElementInst", NM="_ZN12_GLOBAL__N_14Lint22visitInsertElementInstERN4llvm17InsertElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint22visitInsertElementInstERN4llvm17InsertElementInstE")
  //</editor-fold>
  public/*private*/ void visitInsertElementInst(final InsertElementInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::visitUnreachableInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 603,
   FQN="(anonymous namespace)::Lint::visitUnreachableInst", NM="_ZN12_GLOBAL__N_14Lint20visitUnreachableInstERN4llvm15UnreachableInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint20visitUnreachableInstERN4llvm15UnreachableInstE")
  //</editor-fold>
  public/*private*/ void visitUnreachableInst(final UnreachableInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// findValue - Look through bitcasts and simple memory reference patterns
  /// to identify an equivalent, but more informative, value.  If OffsetOk
  /// is true, look through getelementptrs with non-zero offsets too.
  ///
  /// Most analysis passes don't require this logic, because instcombine
  /// will simplify most of these kinds of things away. But it's a goal of
  /// this Lint pass to be useful even on non-optimized IR.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::findValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 619,
   FQN="(anonymous namespace)::Lint::findValue", NM="_ZNK12_GLOBAL__N_14Lint9findValueEPN4llvm5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZNK12_GLOBAL__N_14Lint9findValueEPN4llvm5ValueEb")
  //</editor-fold>
  private Value /*P*/ findValue(Value /*P*/ V, boolean OffsetOk) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// findValueImpl - Implementation helper for findValue.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::findValueImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 625,
   FQN="(anonymous namespace)::Lint::findValueImpl", NM="_ZNK12_GLOBAL__N_14Lint13findValueImplEPN4llvm5ValueEbRNS1_15SmallPtrSetImplIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZNK12_GLOBAL__N_14Lint13findValueImplEPN4llvm5ValueEbRNS1_15SmallPtrSetImplIS3_EE")
  //</editor-fold>
  private Value /*P*/ findValueImpl(Value /*P*/ V, boolean OffsetOk, 
               final SmallPtrSetImpl<Value /*P*/ > /*&*/ Visited) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  public Module /*P*/ Mod;
  public /*const*/ DataLayout /*P*/ DL;
  public AAResults /*P*/ AA;
  public AssumptionCache /*P*/ AC;
  public DominatorTree /*P*/ DT;
  public TargetLibraryInfo /*P*/ TLI;
  
  public std.string Messages;
  public raw_string_ostream MessagesStr;
  
  public static final/*char*/Class<Lint> ID = Lint.class; // Pass identification, replacement for typeid
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::Lint">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 118,
   FQN="(anonymous namespace)::Lint::Lint", NM="_ZN12_GLOBAL__N_14LintC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14LintC1Ev")
  //</editor-fold>
  public Lint() {
    // : FunctionPass(ID), InstVisitor<Lint>(), Messages(), MessagesStr(Messages) 
    super(ID);
    $InstVisitor();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  // Lint::run - This is the main Analysis entry point for a
  // function.
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 181,
   FQN="(anonymous namespace)::Lint::runOnFunction", NM="_ZN12_GLOBAL__N_14Lint13runOnFunctionERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint13runOnFunctionERN4llvm8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 124,
   FQN="(anonymous namespace)::Lint::getAnalysisUsage", NM="_ZNK12_GLOBAL__N_14Lint16getAnalysisUsageERN4llvm13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZNK12_GLOBAL__N_14Lint16getAnalysisUsageERN4llvm13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 131,
   FQN="(anonymous namespace)::Lint::print", NM="_ZNK12_GLOBAL__N_14Lint5printERN4llvm11raw_ostreamEPKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZNK12_GLOBAL__N_14Lint5printERN4llvm11raw_ostreamEPKNS1_6ModuleE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ O, /*const*/ Module /*P*/ M) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::WriteValues">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 133,
   FQN="(anonymous namespace)::Lint::WriteValues", NM="_ZN12_GLOBAL__N_14Lint11WriteValuesEN4llvm8ArrayRefIPKNS1_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint11WriteValuesEN4llvm8ArrayRefIPKNS1_5ValueEEE")
  //</editor-fold>
  public void WriteValues(ArrayRef</*const*/ Value /*P*/ > Vs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief A check failed, so printout out the condition and the message.
  ///
  /// This provides a nice place to put a breakpoint if you want to see why
  /// something is not correct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::CheckFailed">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 150,
   FQN="(anonymous namespace)::Lint::CheckFailed", NM="_ZN12_GLOBAL__N_14Lint11CheckFailedERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14Lint11CheckFailedERKN4llvm5TwineE")
  //</editor-fold>
  public void CheckFailed(final /*const*/ Twine /*&*/ Message) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief A check failed (with values to print).
  ///
  /// This calls the Message-only version so that the above is easier to set
  /// a breakpoint on.
  /*template <typename T1, typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::CheckFailed">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 157,
   FQN="(anonymous namespace)::Lint::CheckFailed", NM="Tpl__ZN12_GLOBAL__N_14Lint11CheckFailedERKN4llvm5TwineERKT_DpRKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=Tpl__ZN12_GLOBAL__N_14Lint11CheckFailedERKN4llvm5TwineERKT_DpRKT0_")
  //</editor-fold>
  public </*typename*/ T1, /*typename*/ /*...*/ Ts> void CheckFailed$T(final /*const*/ Twine /*&*/ Message, final /*const*/ T1 /*&*/ V1, /*const*/ Ts /*&*/ ...Vs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Lint::~Lint">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 69,
   FQN="(anonymous namespace)::Lint::~Lint", NM="_ZN12_GLOBAL__N_14LintD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN12_GLOBAL__N_14LintD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Mod=" + Mod // NOI18N
              + ", DL=" + DL // NOI18N
              + ", AA=" + AA // NOI18N
              + ", AC=" + AC // NOI18N
              + ", DT=" + DT // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", Messages=" + Messages // NOI18N
              + ", MessagesStr=" + MessagesStr // NOI18N
              + super.toString(); // NOI18N
  }
}
