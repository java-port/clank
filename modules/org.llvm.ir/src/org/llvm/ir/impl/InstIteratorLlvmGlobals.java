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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type InstIteratorLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.InstIteratorLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm10inst_beginEPKNS_8FunctionE;_ZN4llvm10inst_beginEPNS_8FunctionE;_ZN4llvm10inst_beginERKNS_8FunctionE;_ZN4llvm10inst_beginERNS_8FunctionE;_ZN4llvm12instructionsEPKNS_8FunctionE;_ZN4llvm12instructionsEPNS_8FunctionE;_ZN4llvm12instructionsERKNS_8FunctionE;_ZN4llvm12instructionsERNS_8FunctionE;_ZN4llvm8inst_endEPKNS_8FunctionE;_ZN4llvm8inst_endEPNS_8FunctionE;_ZN4llvm8inst_endERKNS_8FunctionE;_ZN4llvm8inst_endERNS_8FunctionE; -static-type=InstIteratorLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class InstIteratorLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::inst_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 126,
 FQN="llvm::inst_begin", NM="_ZN4llvm10inst_beginEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm10inst_beginEPNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> inst_begin_Function$P(Function /*P*/ F) {
  return new InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction>($Deref(F));
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 127,
 FQN="llvm::inst_end", NM="_ZN4llvm8inst_endEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm8inst_endEPNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> inst_end_Function$P(Function /*P*/ F) {
  return new InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction>($Deref(F), true);
}

//<editor-fold defaultstate="collapsed" desc="llvm::instructions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 128,
 FQN="llvm::instructions", NM="_ZN4llvm12instructionsEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12instructionsEPNS_8FunctionE")
//</editor-fold>
public static /*inline*/ iterator_range<Instruction /*&*/ > instructions_Function$P(Function /*P*/ F) {
  return new iterator_range<Instruction /*&*/ >(IrLlvmGlobals.inst_begin_Function$P(F), IrLlvmGlobals.inst_end_Function$P(F));
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 131,
 FQN="llvm::inst_begin", NM="_ZN4llvm10inst_beginEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm10inst_beginEPKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> inst_begin_Function$C$P(/*const*/ Function /*P*/ F) {
  return new InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction>($Deref(F));
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 134,
 FQN="llvm::inst_end", NM="_ZN4llvm8inst_endEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm8inst_endEPKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> inst_end_Function$C$P(/*const*/ Function /*P*/ F) {
  return new InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction>($Deref(F), true);
}

//<editor-fold defaultstate="collapsed" desc="llvm::instructions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 137,
 FQN="llvm::instructions", NM="_ZN4llvm12instructionsEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12instructionsEPKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ iterator_range</*const*/ Instruction /*&*/ > instructions_Function$C$P(/*const*/ Function /*P*/ F) {
  return new iterator_range</*const*/ Instruction /*&*/ >(IrLlvmGlobals.inst_begin_Function$C$P(F), IrLlvmGlobals.inst_end_Function$C$P(F));
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 140,
 FQN="llvm::inst_begin", NM="_ZN4llvm10inst_beginERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm10inst_beginERNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> inst_begin_Function(final Function /*&*/ F) {
  return new InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction>(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 141,
 FQN="llvm::inst_end", NM="_ZN4llvm8inst_endERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm8inst_endERNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> inst_end_Function(final Function /*&*/ F) {
  return new InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction>(F, true);
}

//<editor-fold defaultstate="collapsed" desc="llvm::instructions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 142,
 FQN="llvm::instructions", NM="_ZN4llvm12instructionsERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12instructionsERNS_8FunctionE")
//</editor-fold>
public static /*inline*/ iterator_range<Instruction /*&*/ > instructions_Function(final Function /*&*/ F) {
  return new iterator_range<Instruction /*&*/ >(IrLlvmGlobals.inst_begin_Function(F), IrLlvmGlobals.inst_end_Function(F));
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 145,
 FQN="llvm::inst_begin", NM="_ZN4llvm10inst_beginERKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm10inst_beginERKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> inst_begin_Function$C(final /*const*/ Function /*&*/ F) {
  return new InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction>(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 148,
 FQN="llvm::inst_end", NM="_ZN4llvm8inst_endERKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm8inst_endERKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> inst_end_Function$C(final /*const*/ Function /*&*/ F) {
  return new InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction>(F, true);
}

//<editor-fold defaultstate="collapsed" desc="llvm::instructions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 151,
 FQN="llvm::instructions", NM="_ZN4llvm12instructionsERKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm12instructionsERKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ iterator_range</*const*/ Instruction /*&*/ > instructions_Function$C(final /*const*/ Function /*&*/ F) {
  return new iterator_range</*const*/ Instruction /*&*/ >(IrLlvmGlobals.inst_begin_Function$C(F), IrLlvmGlobals.inst_end_Function$C(F));
}

} // END OF class InstIteratorLlvmGlobals
