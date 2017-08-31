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
package org.llvm.ir.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type CFGLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.CFGLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10pred_beginEPKNS_10BasicBlockE;_ZN4llvm10pred_beginEPNS_10BasicBlockE;_ZN4llvm10pred_emptyEPKNS_10BasicBlockE;_ZN4llvm10succ_beginEPKNS_10BasicBlockE;_ZN4llvm10succ_beginEPNS_10BasicBlockE;_ZN4llvm10succ_emptyEPKNS_10BasicBlockE;_ZN4llvm10successorsEPKNS_10BasicBlockE;_ZN4llvm10successorsEPNS_10BasicBlockE;_ZN4llvm12predecessorsEPKNS_10BasicBlockE;_ZN4llvm12predecessorsEPNS_10BasicBlockE;_ZN4llvm8pred_endEPKNS_10BasicBlockE;_ZN4llvm8pred_endEPNS_10BasicBlockE;_ZN4llvm8succ_endEPKNS_10BasicBlockE;_ZN4llvm8succ_endEPNS_10BasicBlockE; -static-type=CFGLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class CFGLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::pred_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 91,
 FQN="llvm::pred_begin", NM="_ZN4llvm10pred_beginEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10pred_beginEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ PredIterator<BasicBlock, Value.user_iterator_impl<User> > pred_begin_BasicBlock$P(BasicBlock /*P*/ BB) {
  return new PredIterator<BasicBlock, Value.user_iterator_impl<User> >(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 92,
 FQN="llvm::pred_begin", NM="_ZN4llvm10pred_beginEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10pred_beginEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > pred_begin_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return new PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> >(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 95,
 FQN="llvm::pred_end", NM="_ZN4llvm8pred_endEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm8pred_endEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ PredIterator<BasicBlock, Value.user_iterator_impl<User> > pred_end_BasicBlock$P(BasicBlock /*P*/ BB) {
  return new PredIterator<BasicBlock, Value.user_iterator_impl<User> >(BB, true);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 96,
 FQN="llvm::pred_end", NM="_ZN4llvm8pred_endEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm8pred_endEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > pred_end_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return new PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> >(BB, true);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_empty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 99,
 FQN="llvm::pred_empty", NM="_ZN4llvm10pred_emptyEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10pred_emptyEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ boolean pred_empty(/*const*/ BasicBlock /*P*/ BB) {
  return IrLlvmGlobals.pred_begin_BasicBlock$C$P(BB).$eq(IrLlvmGlobals.pred_end_BasicBlock$C$P(BB));
}

//<editor-fold defaultstate="collapsed" desc="llvm::predecessors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 102,
 FQN="llvm::predecessors", NM="_ZN4llvm12predecessorsEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12predecessorsEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ iterator_range<BasicBlock> predecessors_BasicBlock$P(BasicBlock /*P*/ BB) {
  return new iterator_range<BasicBlock>(IrLlvmGlobals.pred_begin_BasicBlock$P(BB), IrLlvmGlobals.pred_end_BasicBlock$P(BB));
}

//<editor-fold defaultstate="collapsed" desc="llvm::predecessors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 105,
 FQN="llvm::predecessors", NM="_ZN4llvm12predecessorsEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12predecessorsEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ iterator_range</*const*/ BasicBlock> predecessors_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return new iterator_range</*const*/ BasicBlock>(IrLlvmGlobals.pred_begin_BasicBlock$C$P(BB), IrLlvmGlobals.pred_end_BasicBlock$C$P(BB));
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 120,
 FQN="llvm::succ_begin", NM="_ZN4llvm10succ_beginEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10succ_beginEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> succ_begin_BasicBlock$P(BasicBlock /*P*/ BB) {
  return new TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock>(BB.getTerminator());
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 123,
 FQN="llvm::succ_begin", NM="_ZN4llvm10succ_beginEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10succ_beginEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ TerminatorInst.SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock> succ_begin_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return new TerminatorInst.SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock>(BB.getTerminator$Const());
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 126,
 FQN="llvm::succ_end", NM="_ZN4llvm8succ_endEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm8succ_endEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> succ_end_BasicBlock$P(BasicBlock /*P*/ BB) {
  return new TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock>(BB.getTerminator(), true);
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 129,
 FQN="llvm::succ_end", NM="_ZN4llvm8succ_endEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm8succ_endEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ TerminatorInst.SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock> succ_end_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return new TerminatorInst.SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock>(BB.getTerminator$Const(), true);
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_empty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 132,
 FQN="llvm::succ_empty", NM="_ZN4llvm10succ_emptyEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10succ_emptyEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ boolean succ_empty(/*const*/ BasicBlock /*P*/ BB) {
  return IrLlvmGlobals.succ_begin_BasicBlock$C$P(BB).$eq(IrLlvmGlobals.succ_end_BasicBlock$C$P(BB));
}

//<editor-fold defaultstate="collapsed" desc="llvm::successors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 135,
 FQN="llvm::successors", NM="_ZN4llvm10successorsEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10successorsEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ iterator_range<BasicBlock> successors_BasicBlock$P(BasicBlock /*P*/ BB) {
  return new iterator_range<BasicBlock>(IrLlvmGlobals.succ_begin_BasicBlock$P(BB), IrLlvmGlobals.succ_end_BasicBlock$P(BB));
}

//<editor-fold defaultstate="collapsed" desc="llvm::successors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 138,
 FQN="llvm::successors", NM="_ZN4llvm10successorsEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm10successorsEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ iterator_range</*const*/ BasicBlock> successors_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return new iterator_range</*const*/ BasicBlock>(IrLlvmGlobals.succ_begin_BasicBlock$C$P(BB), IrLlvmGlobals.succ_end_BasicBlock$C$P(BB));
}

} // END OF class CFGLlvmGlobals
