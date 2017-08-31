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


//<editor-fold defaultstate="collapsed" desc="static type CFGLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.CFGLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm14isCriticalEdgeEPKNS_14TerminatorInstEjb;_ZN4llvm18GetSuccessorNumberEPKNS_10BasicBlockES2_;_ZN4llvm21FindFunctionBackedgesERKNS_8FunctionERNS_15SmallVectorImplISt4pairIPKNS_10BasicBlockES7_EEE;_ZN4llvm22isPotentiallyReachableEPKNS_10BasicBlockES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE;_ZN4llvm22isPotentiallyReachableEPKNS_11InstructionES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE;_ZN4llvm30isPotentiallyReachableFromManyERNS_15SmallVectorImplIPNS_10BasicBlockEEES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE; -static-type=CFGLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class CFGLlvmGlobals {


/// Analyze the specified function to find all of the loop backedges in the
/// function and return them.  This is a relatively cheap (compared to
/// computing dominators and loop info) analysis.
///
/// The output is added to Result, as pairs of <from,to> edge info.

/// FindFunctionBackedges - Analyze the specified function to find all of the
/// loop backedges in the function and return them.  This is a relatively cheap
/// (compared to computing dominators and loop info) analysis.
///
/// The output is added to Result, as pairs of <from,to> edge info.
//<editor-fold defaultstate="collapsed" desc="llvm::FindFunctionBackedges">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp", line = 27,
 FQN="llvm::FindFunctionBackedges", NM="_ZN4llvm21FindFunctionBackedgesERKNS_8FunctionERNS_15SmallVectorImplISt4pairIPKNS_10BasicBlockES7_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm21FindFunctionBackedgesERKNS_8FunctionERNS_15SmallVectorImplISt4pairIPKNS_10BasicBlockES7_EEE")
//</editor-fold>
public static void FindFunctionBackedges(final /*const*/ Function /*&*/ F,
                     final SmallVectorImpl<std.pairPtrPtr</*const*/ BasicBlock /*P*/ , /*const*/ BasicBlock /*P*/ > > /*&*/ Result) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Search for the specified successor of basic block BB and return its position
/// in the terminator instruction's list of successors.  It is an error to call
/// this with a block that is not a successor.

/// GetSuccessorNumber - Search for the specified successor of basic block BB
/// and return its position in the terminator instruction's list of
/// successors.  It is an error to call this with a block that is not a
/// successor.
//<editor-fold defaultstate="collapsed" desc="llvm::GetSuccessorNumber">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp", line = 72,
 FQN="llvm::GetSuccessorNumber", NM="_ZN4llvm18GetSuccessorNumberEPKNS_10BasicBlockES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm18GetSuccessorNumberEPKNS_10BasicBlockES2_")
//</editor-fold>
public static /*uint*/int GetSuccessorNumber(/*const*/ BasicBlock /*P*/ BB, 
                  /*const*/ BasicBlock /*P*/ Succ) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the specified edge is a critical edge. Critical edges are
/// edges from a block with multiple successors to a block with multiple
/// predecessors.
///

/// isCriticalEdge - Return true if the specified edge is a critical edge.
/// Critical edges are edges from a block with multiple successors to a block
/// with multiple predecessors.
//<editor-fold defaultstate="collapsed" desc="llvm::isCriticalEdge">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp", line = 88,
 FQN="llvm::isCriticalEdge", NM="_ZN4llvm14isCriticalEdgeEPKNS_14TerminatorInstEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm14isCriticalEdgeEPKNS_14TerminatorInstEjb")
//</editor-fold>
public static boolean isCriticalEdge(/*const*/ TerminatorInst /*P*/ TI, /*uint*/int SuccNum) {
  return isCriticalEdge(TI, SuccNum, 
              false);
}
public static boolean isCriticalEdge(/*const*/ TerminatorInst /*P*/ TI, /*uint*/int SuccNum, 
              boolean AllowIdenticalEdges/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Determine whether instruction 'To' is reachable from 'From',
/// returning true if uncertain.
///
/// Determine whether there is a path from From to To within a single function.
/// Returns false only if we can prove that once 'From' has been executed then
/// 'To' can not be executed. Conservatively returns true.
///
/// This function is linear with respect to the number of blocks in the CFG,
/// walking down successors from From to reach To, with a fixed threshold.
/// Using DT or LI allows us to answer more quickly. LI reduces the cost of
/// an entire loop of any number of blocsk to be the same as the cost of a
/// single block. DT reduces the cost by allowing the search to terminate when
/// we find a block that dominates the block containing 'To'. DT is most useful
/// on branchy code but not loops, and LI is most useful on code with loops but
/// does not help on branchy code outside loops.
//<editor-fold defaultstate="collapsed" desc="llvm::isPotentiallyReachable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp", line = 186,
 FQN="llvm::isPotentiallyReachable", NM="_ZN4llvm22isPotentiallyReachableEPKNS_11InstructionES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm22isPotentiallyReachableEPKNS_11InstructionES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE")
//</editor-fold>
public static boolean isPotentiallyReachable(/*const*/ Instruction /*P*/ A, /*const*/ Instruction /*P*/ B) {
  return isPotentiallyReachable(A, B, 
                      (/*const*/ DominatorTree /*P*/ )null, (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachable(/*const*/ Instruction /*P*/ A, /*const*/ Instruction /*P*/ B, 
                      /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return isPotentiallyReachable(A, B, 
                      DT, (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachable(/*const*/ Instruction /*P*/ A, /*const*/ Instruction /*P*/ B, 
                      /*const*/ DominatorTree /*P*/ DT/*= null*/, /*const*/ LoopInfo /*P*/ LI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Determine whether block 'To' is reachable from 'From', returning
/// true if uncertain.
///
/// Determine whether there is a path from From to To within a single function.
/// Returns false only if we can prove that once 'From' has been reached then
/// 'To' can not be executed. Conservatively returns true.
//<editor-fold defaultstate="collapsed" desc="llvm::isPotentiallyReachable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp", line = 174,
 FQN="llvm::isPotentiallyReachable", NM="_ZN4llvm22isPotentiallyReachableEPKNS_10BasicBlockES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm22isPotentiallyReachableEPKNS_10BasicBlockES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE")
//</editor-fold>
public static boolean isPotentiallyReachable(/*const*/ BasicBlock /*P*/ A, /*const*/ BasicBlock /*P*/ B) {
  return isPotentiallyReachable(A, B, 
                      (/*const*/ DominatorTree /*P*/ )null, (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachable(/*const*/ BasicBlock /*P*/ A, /*const*/ BasicBlock /*P*/ B, 
                      /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return isPotentiallyReachable(A, B, 
                      DT, (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachable(/*const*/ BasicBlock /*P*/ A, /*const*/ BasicBlock /*P*/ B, 
                      /*const*/ DominatorTree /*P*/ DT/*= null*/, /*const*/ LoopInfo /*P*/ LI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Determine whether there is at least one path from a block in
/// 'Worklist' to 'StopBB', returning true if uncertain.
///
/// Determine whether there is a path from at least one block in Worklist to
/// StopBB within a single function. Returns false only if we can prove that
/// once any block in 'Worklist' has been reached then 'StopBB' can not be
/// executed. Conservatively returns true.
//<editor-fold defaultstate="collapsed" desc="llvm::isPotentiallyReachableFromMany">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp", line = 130,
 FQN="llvm::isPotentiallyReachableFromMany", NM="_ZN4llvm30isPotentiallyReachableFromManyERNS_15SmallVectorImplIPNS_10BasicBlockEEES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm30isPotentiallyReachableFromManyERNS_15SmallVectorImplIPNS_10BasicBlockEEES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE")
//</editor-fold>
public static boolean isPotentiallyReachableFromMany(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ Worklist, BasicBlock /*P*/ StopBB) {
  return isPotentiallyReachableFromMany(Worklist, StopBB, 
                              (/*const*/ DominatorTree /*P*/ )null, (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachableFromMany(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ Worklist, BasicBlock /*P*/ StopBB, 
                              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return isPotentiallyReachableFromMany(Worklist, StopBB, 
                              DT, (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachableFromMany(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ Worklist, BasicBlock /*P*/ StopBB, 
                              /*const*/ DominatorTree /*P*/ DT/*= null*/, /*const*/ LoopInfo /*P*/ LI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class CFGLlvmGlobals
