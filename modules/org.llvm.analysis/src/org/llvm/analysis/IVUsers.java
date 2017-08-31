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

//<editor-fold defaultstate="collapsed" desc="llvm::IVUsers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 120,
 FQN="llvm::IVUsers", NM="_ZN4llvm7IVUsersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsersE")
//</editor-fold>
public class IVUsers implements Destructors.ClassWithDestructor {
  /*friend  class IVStrideUse*/
  private Loop /*P*/ L;
  private AssumptionCache /*P*/ AC;
  private LoopInfo /*P*/ LI;
  private DominatorTree /*P*/ DT;
  private ScalarEvolution /*P*/ SE;
  private SmallPtrSet<Instruction /*P*/ > Processed;
  
  /// IVUses - A list of all tracked IV uses of induction variable expressions
  /// we are interested in.
  private ilist<IVStrideUse> IVUses;
  
  // Ephemeral values used by @llvm.assume in this function.
  private SmallPtrSet</*const*/ Value /*P*/ > EphValues;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::IVUsers">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 266,
   FQN="llvm::IVUsers::IVUsers", NM="_ZN4llvm7IVUsersC1EPNS_4LoopEPNS_15AssumptionCacheEPNS_8LoopInfoEPNS_13DominatorTreeEPNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsersC1EPNS_4LoopEPNS_15AssumptionCacheEPNS_8LoopInfoEPNS_13DominatorTreeEPNS_15ScalarEvolutionE")
  //</editor-fold>
  public IVUsers(Loop /*P*/ L, AssumptionCache /*P*/ AC, LoopInfo /*P*/ LI, DominatorTree /*P*/ DT, 
      ScalarEvolution /*P*/ SE) {
    // : L(L), AC(AC), LI(LI), DT(DT), SE(SE), Processed(), IVUses(), EphValues() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::getLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 140,
   FQN="llvm::IVUsers::getLoop", NM="_ZNK4llvm7IVUsers7getLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers7getLoopEv")
  //</editor-fold>
  public Loop /*P*/ getLoop() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// AddUsersIfInteresting - Inspect the specified Instruction.  If it is a
  /// reducible SCEV, recursively add its users to the IVUsesByStride set and
  /// return true.  Otherwise, return false.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::AddUsersIfInteresting">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 252,
   FQN="llvm::IVUsers::AddUsersIfInteresting", NM="_ZN4llvm7IVUsers21AddUsersIfInterestingEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsers21AddUsersIfInterestingEPNS_11InstructionE")
  //</editor-fold>
  public boolean AddUsersIfInteresting(Instruction /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::AddUser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 261,
   FQN="llvm::IVUsers::AddUser", NM="_ZN4llvm7IVUsers7AddUserEPNS_11InstructionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsers7AddUserEPNS_11InstructionEPNS_5ValueE")
  //</editor-fold>
  public IVStrideUse /*&*/ AddUser(Instruction /*P*/ User, Value /*P*/ Operand) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getReplacementExpr - Return a SCEV expression which computes the
  /// value of the OperandValToReplace of the given IVStrideUse.
  
  /// getReplacementExpr - Return a SCEV expression which computes the
  /// value of the OperandValToReplace.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::getReplacementExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 346,
   FQN="llvm::IVUsers::getReplacementExpr", NM="_ZNK4llvm7IVUsers18getReplacementExprERKNS_11IVStrideUseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers18getReplacementExprERKNS_11IVStrideUseE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getReplacementExpr(final /*const*/ IVStrideUse /*&*/ IU) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getExpr - Return the expression for the use.
  
  /// getExpr - Return the expression for the use.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::getExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 351,
   FQN="llvm::IVUsers::getExpr", NM="_ZNK4llvm7IVUsers7getExprERKNS_11IVStrideUseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers7getExprERKNS_11IVStrideUseE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getExpr(final /*const*/ IVStrideUse /*&*/ IU) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::getStride">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 377,
   FQN="llvm::IVUsers::getStride", NM="_ZNK4llvm7IVUsers9getStrideERKNS_11IVStrideUseEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers9getStrideERKNS_11IVStrideUseEPKNS_4LoopE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getStride(final /*const*/ IVStrideUse /*&*/ IU, /*const*/ Loop /*P*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // JAVA: typedef ilist<IVStrideUse>::iterator iterator
//  public final class iterator extends ilist_iterator<IVStrideUse>{ };
  // JAVA: typedef ilist<IVStrideUse>::const_iterator const_iterator
//  public final class const_iterator extends ilist_iterator</*const*/ IVStrideUse>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 160,
   FQN="llvm::IVUsers::begin", NM="_ZN4llvm7IVUsers5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsers5beginEv")
  //</editor-fold>
  public ilist_iterator<IVStrideUse> begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 161,
   FQN="llvm::IVUsers::end", NM="_ZN4llvm7IVUsers3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsers3endEv")
  //</editor-fold>
  public ilist_iterator<IVStrideUse> end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 162,
   FQN="llvm::IVUsers::begin", NM="_ZNK4llvm7IVUsers5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers5beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ IVStrideUse> begin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 163,
   FQN="llvm::IVUsers::end", NM="_ZNK4llvm7IVUsers3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers3endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ IVStrideUse> end$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 164,
   FQN="llvm::IVUsers::empty", NM="_ZNK4llvm7IVUsers5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::isIVUserOrOperand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 166,
   FQN="llvm::IVUsers::isIVUserOrOperand", NM="_ZNK4llvm7IVUsers17isIVUserOrOperandEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers17isIVUserOrOperandEPNS_11InstructionE")
  //</editor-fold>
  public boolean isIVUserOrOperand(Instruction /*P*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 310,
   FQN="llvm::IVUsers::releaseMemory", NM="_ZN4llvm7IVUsers13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsers13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 280,
   FQN="llvm::IVUsers::print", NM="_ZNK4llvm7IVUsers5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    print(OS, (/*const*/ Module /*P*/ )null);
  }
  public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ M/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// dump - This method is used for debugging.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 307,
   FQN="llvm::IVUsers::dump", NM="_ZNK4llvm7IVUsers4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm7IVUsers4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*protected:*/
  
  /// AddUsersImpl - Inspect the specified instruction.  If it is a
  /// reducible SCEV, recursively add its users to the IVUsesByStride set and
  /// return true.  Otherwise, return false.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::AddUsersImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 135,
   FQN="llvm::IVUsers::AddUsersImpl", NM="_ZN4llvm7IVUsers12AddUsersImplEPNS_11InstructionERNS_15SmallPtrSetImplIPNS_4LoopEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsers12AddUsersImplEPNS_11InstructionERNS_15SmallPtrSetImplIPNS_4LoopEEE")
  //</editor-fold>
  protected boolean AddUsersImpl(Instruction /*P*/ I, 
              final SmallPtrSetImpl<Loop /*P*/ > /*&*/ SimpleLoopNests) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::IVUsers">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 120,
   FQN="llvm::IVUsers::IVUsers", NM="_ZN4llvm7IVUsersC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsersC1EOS0_")
  //</editor-fold>
  public /*inline*/ IVUsers(JD$Move _dparam, final IVUsers /*&&*/$Prm0) {
    // : L(static_cast<IVUsers &&>().L), AC(static_cast<IVUsers &&>().AC), LI(static_cast<IVUsers &&>().LI), DT(static_cast<IVUsers &&>().DT), SE(static_cast<IVUsers &&>().SE), Processed(static_cast<IVUsers &&>().Processed), IVUses(static_cast<IVUsers &&>().IVUses), EphValues(static_cast<IVUsers &&>().EphValues) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IVUsers::~IVUsers">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 120,
   FQN="llvm::IVUsers::~IVUsers", NM="_ZN4llvm7IVUsersD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm7IVUsersD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "L=" + L // NOI18N
              + ", AC=" + AC // NOI18N
              + ", LI=" + LI // NOI18N
              + ", DT=" + DT // NOI18N
              + ", SE=" + SE // NOI18N
              + ", Processed=" + Processed // NOI18N
              + ", IVUses=" + IVUses // NOI18N
              + ", EphValues=" + EphValues; // NOI18N
  }
}
