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


/// SparseSolver - This class is a general purpose solver for Sparse Conditional
/// Propagation with a programmable lattice function.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 113,
 FQN="llvm::SparseSolver", NM="_ZN4llvm12SparseSolverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolverE")
//</editor-fold>
public class SparseSolver implements Destructors.ClassWithDestructor {
  // JAVA: typedef AbstractLatticeFunction::LatticeVal LatticeVal;
  
  /// LatticeFunc - This is the object that knows the lattice and how to do
  /// compute transfer functions.
  private AbstractLatticeFunction /*P*/ LatticeFunc;
  
  private DenseMap<Value /*P*/ , Object/*void P*/ > ValueState; // The state each value is in.
  private SmallPtrSet<BasicBlock /*P*/ > BBExecutable; // The bbs that are executable.
  
  private std.vector<Instruction /*P*/ > InstWorkList; // Worklist of insts to process.
  
  private std.vector<BasicBlock /*P*/ > BBWorkList; // The BasicBlock work list
  
  /// KnownFeasibleEdges - Entries in this set are edges which have already had
  /// PHI nodes retriggered.
  // JAVA: typedef std::pair<BasicBlock *, BasicBlock *> Edge
//  public final class Edge extends std.pair<BasicBlock /*P*/ , BasicBlock /*P*/ >{ };
  private std.setType<std.pairPtrPtr<BasicBlock /*P*/ , BasicBlock /*P*/ > > KnownFeasibleEdges;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::SparseSolver">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 132,
   FQN="llvm::SparseSolver::SparseSolver", NM="_ZN4llvm12SparseSolverC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolverC1ERKS0_")
  //</editor-fold>
  protected/*private*/ SparseSolver(final /*const*/ SparseSolver /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 133,
   FQN="llvm::SparseSolver::operator=", NM="_ZN4llvm12SparseSolveraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolveraSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ SparseSolver /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::SparseSolver">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 136,
   FQN="llvm::SparseSolver::SparseSolver", NM="_ZN4llvm12SparseSolverC1EPNS_23AbstractLatticeFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolverC1EPNS_23AbstractLatticeFunctionE")
  //</editor-fold>
  public /*explicit*/ SparseSolver(AbstractLatticeFunction /*P*/ Lattice) {
    // : LatticeFunc(Lattice), ValueState(), BBExecutable(), InstWorkList(), BBWorkList(), KnownFeasibleEdges() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::~SparseSolver">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 138,
   FQN="llvm::SparseSolver::~SparseSolver", NM="_ZN4llvm12SparseSolverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolverD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Solve - Solve for constants and executable blocks.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::Solve">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 293,
   FQN="llvm::SparseSolver::Solve", NM="_ZN4llvm12SparseSolver5SolveERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver5SolveERNS_8FunctionE")
  //</editor-fold>
  public void Solve(final Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::Print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 329,
   FQN="llvm::SparseSolver::Print", NM="_ZNK4llvm12SparseSolver5PrintERNS_8FunctionERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZNK4llvm12SparseSolver5PrintERNS_8FunctionERNS_11raw_ostreamE")
  //</editor-fold>
  public void Print(final Function /*&*/ F, final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getLatticeState - Return the LatticeVal object that corresponds to the
  /// value.  If an value is not in the map, it is returned as untracked,
  /// unlike the getOrInitValueState method.
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::getLatticeState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 149,
   FQN="llvm::SparseSolver::getLatticeState", NM="_ZNK4llvm12SparseSolver15getLatticeStateEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZNK4llvm12SparseSolver15getLatticeStateEPNS_5ValueE")
  //</editor-fold>
  public Object/*void P*/ getLatticeState(Value /*P*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getOrInitValueState - Return the LatticeVal object that corresponds to the
  /// value, initializing the value's state if it hasn't been entered into the
  /// map yet.   This function is necessary because not all values should start
  /// out in the underdefined state... Arguments should be overdefined, and
  /// constants should be marked as constants.
  ///
  
  //===----------------------------------------------------------------------===//
  //                          SparseSolver Implementation
  //===----------------------------------------------------------------------===//
  
  /// getOrInitValueState - Return the LatticeVal object that corresponds to the
  /// value, initializing the value's state if it hasn't been entered into the
  /// map yet.   This function is necessary because not all values should start
  /// out in the underdefined state... Arguments should be overdefined, and
  /// constants should be marked as constants.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::getOrInitValueState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 53,
   FQN="llvm::SparseSolver::getOrInitValueState", NM="_ZN4llvm12SparseSolver19getOrInitValueStateEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver19getOrInitValueStateEPNS_5ValueE")
  //</editor-fold>
  public Object/*void P*/ getOrInitValueState(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isEdgeFeasible - Return true if the control flow edge from the 'From'
  /// basic block to the 'To' basic block is currently feasible.  If
  /// AggressiveUndef is true, then this treats values with unknown lattice
  /// values as undefined.  This is generally only useful when solving the
  /// lattice, not when querying it.
  
  /// isEdgeFeasible - Return true if the control flow edge from the 'From'
  /// basic block to the 'To' basic block is currently feasible...
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::isEdgeFeasible">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 205,
   FQN="llvm::SparseSolver::isEdgeFeasible", NM="_ZN4llvm12SparseSolver14isEdgeFeasibleEPNS_10BasicBlockES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver14isEdgeFeasibleEPNS_10BasicBlockES2_b")
  //</editor-fold>
  public boolean isEdgeFeasible(BasicBlock /*P*/ From, BasicBlock /*P*/ To) {
    return isEdgeFeasible(From, To, 
                false);
  }
  public boolean isEdgeFeasible(BasicBlock /*P*/ From, BasicBlock /*P*/ To, 
                boolean AggressiveUndef/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isBlockExecutable - Return true if there are any known feasible
  /// edges into the basic block.  This is generally only useful when
  /// querying the lattice.
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::isBlockExecutable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 173,
   FQN="llvm::SparseSolver::isBlockExecutable", NM="_ZNK4llvm12SparseSolver17isBlockExecutableEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZNK4llvm12SparseSolver17isBlockExecutableEPNS_10BasicBlockE")
  //</editor-fold>
  public boolean isBlockExecutable(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// UpdateState - When the state for some instruction is potentially updated,
  /// this function notices and adds I to the worklist if needed.
  
  /// UpdateState - When the state for some instruction is potentially updated,
  /// this function notices and adds I to the worklist if needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::UpdateState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 79,
   FQN="llvm::SparseSolver::UpdateState", NM="_ZN4llvm12SparseSolver11UpdateStateERNS_11InstructionEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver11UpdateStateERNS_11InstructionEPv")
  //</editor-fold>
  private void UpdateState(final Instruction /*&*/ Inst, Object/*void P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// MarkBlockExecutable - This method can be used by clients to mark all of
  /// the blocks that are known to be intrinsically live in the processed unit.
  
  /// MarkBlockExecutable - This method can be used by clients to mark all of
  /// the blocks that are known to be intrinsically live in the processed unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::MarkBlockExecutable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 91,
   FQN="llvm::SparseSolver::MarkBlockExecutable", NM="_ZN4llvm12SparseSolver19MarkBlockExecutableEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver19MarkBlockExecutableEPNS_10BasicBlockE")
  //</editor-fold>
  private void MarkBlockExecutable(BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// markEdgeExecutable - Mark a basic block as executable, adding it to the BB
  /// work list if it is not already executable.
  
  /// markEdgeExecutable - Mark a basic block as executable, adding it to the BB
  /// work list if it is not already executable...
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::markEdgeExecutable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 99,
   FQN="llvm::SparseSolver::markEdgeExecutable", NM="_ZN4llvm12SparseSolver18markEdgeExecutableEPNS_10BasicBlockES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver18markEdgeExecutableEPNS_10BasicBlockES2_")
  //</editor-fold>
  private void markEdgeExecutable(BasicBlock /*P*/ Source, BasicBlock /*P*/ Dest) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getFeasibleSuccessors - Return a vector of booleans to indicate which
  /// successors are reachable from a given terminator instruction.
  
  /// getFeasibleSuccessors - Return a vector of booleans to indicate which
  /// successors are reachable from a given terminator instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::getFeasibleSuccessors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 121,
   FQN="llvm::SparseSolver::getFeasibleSuccessors", NM="_ZN4llvm12SparseSolver21getFeasibleSuccessorsERNS_14TerminatorInstERNS_15SmallVectorImplIbEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver21getFeasibleSuccessorsERNS_14TerminatorInstERNS_15SmallVectorImplIbEEb")
  //</editor-fold>
  private void getFeasibleSuccessors(final TerminatorInst /*&*/ TI, 
                       final SmallVectorImplBool /*&*/ Succs, 
                       boolean AggressiveUndef) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::visitInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 277,
   FQN="llvm::SparseSolver::visitInst", NM="_ZN4llvm12SparseSolver9visitInstERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver9visitInstERNS_11InstructionE")
  //</editor-fold>
  private void visitInst(final Instruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::visitPHINode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 230,
   FQN="llvm::SparseSolver::visitPHINode", NM="_ZN4llvm12SparseSolver12visitPHINodeERNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver12visitPHINodeERNS_7PHINodeE")
  //</editor-fold>
  private void visitPHINode(final PHINode /*&*/ PN) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SparseSolver::visitTerminatorInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 218,
   FQN="llvm::SparseSolver::visitTerminatorInst", NM="_ZN4llvm12SparseSolver19visitTerminatorInstERNS_14TerminatorInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm12SparseSolver19visitTerminatorInstERNS_14TerminatorInstE")
  //</editor-fold>
  private void visitTerminatorInst(final TerminatorInst /*&*/ TI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "LatticeFunc=" + LatticeFunc // NOI18N
              + ", ValueState=" + ValueState // NOI18N
              + ", BBExecutable=" + BBExecutable // NOI18N
              + ", InstWorkList=" + InstWorkList // NOI18N
              + ", BBWorkList=" + BBWorkList // NOI18N
              + ", KnownFeasibleEdges=" + KnownFeasibleEdges; // NOI18N
  }
}
