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

package org.llvm.analysis;

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
import org.llvm.analysis.LoopInfoGlobals.LoopBase;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// Represents a single loop in the control flow graph.  Note that not all SCCs
/// in the CFG are neccessarily loops.
//<editor-fold defaultstate="collapsed" desc="llvm::Loop">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 354,
 FQN="llvm::Loop", NM="_ZN4llvm4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm4LoopE")
//</editor-fold>
public class Loop extends /*public*/ LoopBase<BasicBlock, Loop> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::Loop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 356,
   FQN="llvm::Loop::Loop", NM="_ZN4llvm4LoopC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm4LoopC1Ev")
  //</editor-fold>
  public Loop() {
    // : LoopBase<BasicBlock, Loop>() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the specified value is loop invariant.
  
  //===----------------------------------------------------------------------===//
  // Loop implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::isLoopInvariant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 55,
   FQN="llvm::Loop::isLoopInvariant", NM="_ZNK4llvm4Loop15isLoopInvariantEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop15isLoopInvariantEPKNS_5ValueE")
  //</editor-fold>
  public boolean isLoopInvariant(/*const*/ Value /*P*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if all the operands of the specified instruction are loop
  /// invariant.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::hasLoopInvariantOperands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 61,
   FQN="llvm::Loop::hasLoopInvariantOperands", NM="_ZNK4llvm4Loop24hasLoopInvariantOperandsEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop24hasLoopInvariantOperandsEPKNS_11InstructionE")
  //</editor-fold>
  public boolean hasLoopInvariantOperands(/*const*/ Instruction /*P*/ I) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If the given value is an instruction inside of the loop and it can be
  /// hoisted, do so to make it trivially loop-invariant.
  /// Return true if the value after any hoisting is loop invariant. This
  /// function can be used as a slightly more aggressive replacement for
  /// isLoopInvariant.
  ///
  /// If InsertPt is specified, it is the point to hoist instructions to.
  /// If null, the terminator of the loop preheader is used.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::makeLoopInvariant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 65,
   FQN="llvm::Loop::makeLoopInvariant", NM="_ZNK4llvm4Loop17makeLoopInvariantEPNS_5ValueERbPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop17makeLoopInvariantEPNS_5ValueERbPNS_11InstructionE")
  //</editor-fold>
  public boolean makeLoopInvariant(Value /*P*/ V, final bool$ref/*bool &*/ Changed) /*const*/ {
    return makeLoopInvariant(V, Changed, 
                   (Instruction /*P*/ )null);
  }
  public boolean makeLoopInvariant(Value /*P*/ V, final bool$ref/*bool &*/ Changed, 
                   Instruction /*P*/ InsertPt/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If the given instruction is inside of the loop and it can be hoisted, do
  /// so to make it trivially loop-invariant.
  /// Return true if the instruction after any hoisting is loop invariant. This
  /// function can be used as a slightly more aggressive replacement for
  /// isLoopInvariant.
  ///
  /// If InsertPt is specified, it is the point to hoist instructions to.
  /// If null, the terminator of the loop preheader is used.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::makeLoopInvariant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 72,
   FQN="llvm::Loop::makeLoopInvariant", NM="_ZNK4llvm4Loop17makeLoopInvariantEPNS_11InstructionERbS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop17makeLoopInvariantEPNS_11InstructionERbS2_")
  //</editor-fold>
  public boolean makeLoopInvariant(Instruction /*P*/ I, final bool$ref/*bool &*/ Changed) /*const*/ {
    return makeLoopInvariant(I, Changed, 
                   (Instruction /*P*/ )null);
  }
  public boolean makeLoopInvariant(Instruction /*P*/ I, final bool$ref/*bool &*/ Changed, 
                   Instruction /*P*/ InsertPt/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Check to see if the loop has a canonical induction variable: an integer
  /// recurrence that starts at 0 and increments by one each time through the
  /// loop. If so, return the phi node that corresponds to it.
  ///
  /// The IndVarSimplify pass transforms loops to have a canonical induction
  /// variable.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::getCanonicalInductionVariable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 110,
   FQN="llvm::Loop::getCanonicalInductionVariable", NM="_ZNK4llvm4Loop29getCanonicalInductionVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop29getCanonicalInductionVariableEv")
  //</editor-fold>
  public PHINode /*P*/ getCanonicalInductionVariable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the Loop is in LCSSA form.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::isLCSSAForm">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 146,
   FQN="llvm::Loop::isLCSSAForm", NM="_ZNK4llvm4Loop11isLCSSAFormERNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop11isLCSSAFormERNS_13DominatorTreeE")
  //</editor-fold>
  public boolean isLCSSAForm(final DominatorTree /*&*/ DT) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this Loop and all inner subloops are in LCSSA form.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::isRecursivelyLCSSAForm">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 176,
   FQN="llvm::Loop::isRecursivelyLCSSAForm", NM="_ZNK4llvm4Loop22isRecursivelyLCSSAFormERNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop22isRecursivelyLCSSAFormERNS_13DominatorTreeE")
  //</editor-fold>
  public boolean isRecursivelyLCSSAForm(final DominatorTree /*&*/ DT) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the Loop is in the form that the LoopSimplify form
  /// transforms loops to, which is sometimes called normal form.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::isLoopSimplifyForm">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 185,
   FQN="llvm::Loop::isLoopSimplifyForm", NM="_ZNK4llvm4Loop18isLoopSimplifyFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop18isLoopSimplifyFormEv")
  //</editor-fold>
  public boolean isLoopSimplifyForm() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the loop body is safe to clone in practice.
  
  // Routines that reform the loop CFG and split edges often fail on indirectbr.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::isSafeToClone">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 192,
   FQN="llvm::Loop::isSafeToClone", NM="_ZNK4llvm4Loop13isSafeToCloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop13isSafeToCloneEv")
  //</editor-fold>
  public boolean isSafeToClone() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns true if the loop is annotated parallel.
  ///
  /// A parallel loop can be assumed to not contain any dependencies between
  /// iterations by the compiler. That is, any loop-carried dependency checking
  /// can be skipped completely when parallelizing the loop on the target
  /// machine. Thus, if the parallel loop information originates from the
  /// programmer, e.g. via the OpenMP parallel for pragma, it is the
  /// programmer's responsibility to ensure there are no loop-carried
  /// dependencies. The final execution order of the instructions across
  /// iterations is not guaranteed, thus, the end result might or might not
  /// implement actual concurrent execution of instructions across multiple
  /// iterations.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::isAnnotatedParallel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 261,
   FQN="llvm::Loop::isAnnotatedParallel", NM="_ZNK4llvm4Loop19isAnnotatedParallelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop19isAnnotatedParallelEv")
  //</editor-fold>
  public boolean isAnnotatedParallel() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the llvm.loop loop id metadata node for this loop if it is present.
  ///
  /// If this loop contains the same llvm.loop metadata on each branch to the
  /// header then the node is returned. If any latch instruction does not
  /// contain llvm.loop or or if multiple latches contain different nodes then
  /// 0 is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::getLoopID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 207,
   FQN="llvm::Loop::getLoopID", NM="_ZNK4llvm4Loop9getLoopIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop9getLoopIDEv")
  //</editor-fold>
  public MDNode /*P*/ getLoopID() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Set the llvm.loop loop id metadata for this loop.
  ///
  /// The LoopID metadata node will be added to each terminator instruction in
  /// the loop that branches to the loop header.
  ///
  /// The LoopID metadata node should have one or more operands and the first
  /// operand should should be the node itself.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::setLoopID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 241,
   FQN="llvm::Loop::setLoopID", NM="_ZNK4llvm4Loop9setLoopIDEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop9setLoopIDEPNS_6MDNodeE")
  //</editor-fold>
  public void setLoopID(MDNode /*P*/ LoopID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if no exit block for the loop has a predecessor that is
  /// outside the loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::hasDedicatedExits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 322,
   FQN="llvm::Loop::hasDedicatedExits", NM="_ZNK4llvm4Loop17hasDedicatedExitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop17hasDedicatedExitsEv")
  //</editor-fold>
  public boolean hasDedicatedExits() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return all unique successor blocks of this loop.
  /// These are the blocks _outside of the current loop_ which are branched to.
  /// This assumes that loop exits are in canonical form.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::getUniqueExitBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 335,
   FQN="llvm::Loop::getUniqueExitBlocks", NM="_ZNK4llvm4Loop19getUniqueExitBlocksERNS_15SmallVectorImplIPNS_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop19getUniqueExitBlocksERNS_15SmallVectorImplIPNS_10BasicBlockEEE")
  //</editor-fold>
  public void getUniqueExitBlocks(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ ExitBlocks) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If getUniqueExitBlocks would return exactly one block, return that block.
  /// Otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::getUniqueExitBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 378,
   FQN="llvm::Loop::getUniqueExitBlock", NM="_ZNK4llvm4Loop18getUniqueExitBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop18getUniqueExitBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ getUniqueExitBlock() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 387,
   FQN="llvm::Loop::dump", NM="_ZNK4llvm4Loop4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the debug location of the start of this loop.
  /// This looks for a BB terminating instruction with a known debug
  /// location by looking at the preheader and header blocks. If it
  /// cannot find a terminating instruction with location information,
  /// it returns an unknown location.
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::getStartLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 302,
   FQN="llvm::Loop::getStartLoc", NM="_ZNK4llvm4Loop11getStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop11getStartLocEv")
  //</editor-fold>
  public DebugLoc getStartLoc() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 462,
   FQN="llvm::Loop::getName", NM="_ZNK4llvm4Loop7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm4Loop7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /*friend  class LoopInfoBase<BasicBlock, Loop>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::Loop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 471,
   FQN="llvm::Loop::Loop", NM="_ZN4llvm4LoopC1EPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm4LoopC1EPNS_10BasicBlockE")
  //</editor-fold>
  private /*explicit*/ Loop(BasicBlock /*P*/ BB) {
    // : LoopBase<BasicBlock, Loop>(BB) 
    //super(BB);
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Loop::~Loop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 354,
   FQN="llvm::Loop::~Loop", NM="_ZN4llvm4LoopD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm4LoopD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
