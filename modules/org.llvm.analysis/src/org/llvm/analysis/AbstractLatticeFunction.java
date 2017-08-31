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

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.ir.*;


/// AbstractLatticeFunction - This class is implemented by the dataflow instance
/// to specify what the lattice values are and how they handle merges etc.
/// This gives the client the power to compute lattice values from instructions,
/// constants, etc.  The requirement is that lattice values must all fit into
/// a void*.  If a void* is not sufficient, the implementation should use this
/// pointer to be a pointer into a uniquing set or something.
///
//<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 45,
 FQN="llvm::AbstractLatticeFunction", NM="_ZN4llvm23AbstractLatticeFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunctionE")
//</editor-fold>
public class AbstractLatticeFunction implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef void *LatticeVal;
/*private:*/
  private Object/*void P*/ UndefVal;
  private Object/*void P*/ OverdefinedVal;
  private Object/*void P*/ UntrackedVal;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::AbstractLatticeFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 53,
   FQN="llvm::AbstractLatticeFunction::AbstractLatticeFunction", NM="_ZN4llvm23AbstractLatticeFunctionC1EPvS1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunctionC1EPvS1_S1_")
  //</editor-fold>
  public AbstractLatticeFunction(Object/*void P*/ undefVal, Object/*void P*/ overdefinedVal, 
      Object/*void P*/ untrackedVal) {
    UndefVal = undefVal;
    OverdefinedVal = overdefinedVal;
    UntrackedVal = untrackedVal;
  }

  
  //===----------------------------------------------------------------------===//
  //                  AbstractLatticeFunction Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::~AbstractLatticeFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 29,
   FQN="llvm::AbstractLatticeFunction::~AbstractLatticeFunction", NM="_ZN4llvm23AbstractLatticeFunctionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunctionD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::getUndefVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 61,
   FQN="llvm::AbstractLatticeFunction::getUndefVal", NM="_ZNK4llvm23AbstractLatticeFunction11getUndefValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZNK4llvm23AbstractLatticeFunction11getUndefValEv")
  //</editor-fold>
  public Object/*void P*/ getUndefVal() /*const*/ {
    return UndefVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::getOverdefinedVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 62,
   FQN="llvm::AbstractLatticeFunction::getOverdefinedVal", NM="_ZNK4llvm23AbstractLatticeFunction17getOverdefinedValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZNK4llvm23AbstractLatticeFunction17getOverdefinedValEv")
  //</editor-fold>
  public Object/*void P*/ getOverdefinedVal() /*const*/ {
    return OverdefinedVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::getUntrackedVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 63,
   FQN="llvm::AbstractLatticeFunction::getUntrackedVal", NM="_ZNK4llvm23AbstractLatticeFunction15getUntrackedValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZNK4llvm23AbstractLatticeFunction15getUntrackedValEv")
  //</editor-fold>
  public Object/*void P*/ getUntrackedVal() /*const*/ {
    return UntrackedVal;
  }

  
  /// IsUntrackedValue - If the specified Value is something that is obviously
  /// uninteresting to the analysis (and would always return UntrackedVal),
  /// this function can return true to avoid pointless work.
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::IsUntrackedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 68,
   FQN="llvm::AbstractLatticeFunction::IsUntrackedValue", NM="_ZN4llvm23AbstractLatticeFunction16IsUntrackedValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunction16IsUntrackedValueEPNS_5ValueE")
  //</editor-fold>
  public /*virtual*/ boolean IsUntrackedValue(Value /*P*/ V) {
    return false;
  }

  
  /// ComputeConstant - Given a constant value, compute and return a lattice
  /// value corresponding to the specified constant.
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::ComputeConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 72,
   FQN="llvm::AbstractLatticeFunction::ComputeConstant", NM="_ZN4llvm23AbstractLatticeFunction15ComputeConstantEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunction15ComputeConstantEPNS_8ConstantE")
  //</editor-fold>
  public /*virtual*/ Object/*void P*/ ComputeConstant(Constant /*P*/ C) {
    return getOverdefinedVal(); // always safe
  }

  
  /// IsSpecialCasedPHI - Given a PHI node, determine whether this PHI node is
  /// one that the we want to handle through ComputeInstructionState.
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::IsSpecialCasedPHI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 78,
   FQN="llvm::AbstractLatticeFunction::IsSpecialCasedPHI", NM="_ZN4llvm23AbstractLatticeFunction17IsSpecialCasedPHIEPNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunction17IsSpecialCasedPHIEPNS_7PHINodeE")
  //</editor-fold>
  public /*virtual*/ boolean IsSpecialCasedPHI(PHINode /*P*/ PN) {
    return false;
  }

  
  /// GetConstant - If the specified lattice value is representable as an LLVM
  /// constant value, return it.  Otherwise return null.  The returned value
  /// must be in the same LLVM type as Val.
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::GetConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 83,
   FQN="llvm::AbstractLatticeFunction::GetConstant", NM="_ZN4llvm23AbstractLatticeFunction11GetConstantEPvPNS_5ValueERNS_12SparseSolverE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunction11GetConstantEPvPNS_5ValueERNS_12SparseSolverE")
  //</editor-fold>
  public /*virtual*/ Constant /*P*/ GetConstant(Object/*void P*/ LV, Value /*P*/ Val, final SparseSolver /*&*/ SS) {
    return null;
  }

  
  /// ComputeArgument - Given a formal argument value, compute and return a
  /// lattice value corresponding to the specified argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::ComputeArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 89,
   FQN="llvm::AbstractLatticeFunction::ComputeArgument", NM="_ZN4llvm23AbstractLatticeFunction15ComputeArgumentEPNS_8ArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunction15ComputeArgumentEPNS_8ArgumentE")
  //</editor-fold>
  public /*virtual*/ Object/*void P*/ ComputeArgument(Argument /*P*/ I) {
    return getOverdefinedVal(); // always safe
  }

  
  /// MergeValues - Compute and return the merge of the two specified lattice
  /// values.  Merging should only move one direction down the lattice to
  /// guarantee convergence (toward overdefined).
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::MergeValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 96,
   FQN="llvm::AbstractLatticeFunction::MergeValues", NM="_ZN4llvm23AbstractLatticeFunction11MergeValuesEPvS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunction11MergeValuesEPvS1_")
  //</editor-fold>
  public /*virtual*/ Object/*void P*/ MergeValues(Object/*void P*/ X, Object/*void P*/ Y) {
    return getOverdefinedVal(); // always safe, never useful.
  }

  
  /// ComputeInstructionState - Given an instruction and a vector of its operand
  /// values, compute the result value of the instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::ComputeInstructionState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/SparsePropagation.h", line = 102,
   FQN="llvm::AbstractLatticeFunction::ComputeInstructionState", NM="_ZN4llvm23AbstractLatticeFunction23ComputeInstructionStateERNS_11InstructionERNS_12SparseSolverE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunction23ComputeInstructionStateERNS_11InstructionERNS_12SparseSolverE")
  //</editor-fold>
  public /*virtual*/ Object/*void P*/ ComputeInstructionState(final Instruction /*&*/ I, final SparseSolver /*&*/ SS) {
    return getOverdefinedVal(); // always safe, never useful.
  }

  
  /// PrintValue - Render the specified lattice value to the specified stream.
  
  /// PrintValue - Render the specified lattice value to the specified stream.
  //<editor-fold defaultstate="collapsed" desc="llvm::AbstractLatticeFunction::PrintValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp", line = 32,
   FQN="llvm::AbstractLatticeFunction::PrintValue", NM="_ZN4llvm23AbstractLatticeFunction10PrintValueEPvRNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/SparsePropagation.cpp -nm=_ZN4llvm23AbstractLatticeFunction10PrintValueEPvRNS_11raw_ostreamE")
  //</editor-fold>
  public void PrintValue(Object/*void P*/ V, final raw_ostream /*&*/ OS) {
    if (V == UndefVal) {
      OS.$out(/*KEEP_STR*/"undefined");
    } else if (V == OverdefinedVal) {
      OS.$out(/*KEEP_STR*/"overdefined");
    } else if (V == UntrackedVal) {
      OS.$out(/*KEEP_STR*/"untracked");
    } else {
      OS.$out(/*KEEP_STR*/"unknown lattice value");
    }
  }

  
  @Override public String toString() {
    return "" + "UndefVal=" + NativeTrace.getIdentityStr(UndefVal) // NOI18N
              + ", OverdefinedVal=" + NativeTrace.getIdentityStr(OverdefinedVal) // NOI18N
              + ", UntrackedVal=" + NativeTrace.getIdentityStr(UntrackedVal); // NOI18N
  }
}
