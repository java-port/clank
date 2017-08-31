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
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// PHITransAddr - An address value which tracks and handles phi translation.
/// As we walk "up" the CFG through predecessors, we need to ensure that the
/// address we're tracking is kept up to date.  For example, if we're analyzing
/// an address of "&A[i]" and walk through the definition of 'i' which is a PHI
/// node, we *must* phi translate i to get "&A[j]" or else we will analyze an
/// incorrect pointer in the predecessor block.
///
/// This is designed to be a relatively small object that lives on the stack and
/// is copyable.
///
//<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PHITransAddr.h", line = 36,
 FQN="llvm::PHITransAddr", NM="_ZN4llvm12PHITransAddrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12PHITransAddrE")
//</editor-fold>
public class PHITransAddr implements Destructors.ClassWithDestructor {
  /// Addr - The actual address we're analyzing.
  private Value /*P*/ Addr;
  
  /// The DataLayout we are playing with.
  private final /*const*/ DataLayout /*&*/ DL;
  
  /// TLI - The target library info if known, otherwise null.
  private /*const*/ TargetLibraryInfo /*P*/ TLI;
  
  /// A cache of @llvm.assume calls used by SimplifyInstruction.
  private AssumptionCache /*P*/ AC;
  
  /// InstInputs - The inputs for our symbolic address.
  private SmallVector<Instruction /*P*/ > InstInputs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::PHITransAddr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PHITransAddr.h", line = 53,
   FQN="llvm::PHITransAddr::PHITransAddr", NM="_ZN4llvm12PHITransAddrC1EPNS_5ValueERKNS_10DataLayoutEPNS_15AssumptionCacheE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12PHITransAddrC1EPNS_5ValueERKNS_10DataLayoutEPNS_15AssumptionCacheE")
  //</editor-fold>
  public PHITransAddr(Value /*P*/ addr, final /*const*/ DataLayout /*&*/ DL, AssumptionCache /*P*/ AC) {
    // : Addr(addr), DL(DL), TLI(null), AC(AC), InstInputs() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::getAddr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PHITransAddr.h", line = 60,
   FQN="llvm::PHITransAddr::getAddr", NM="_ZNK4llvm12PHITransAddr7getAddrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12PHITransAddr7getAddrEv")
  //</editor-fold>
  public Value /*P*/ getAddr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// NeedsPHITranslationFromBlock - Return true if moving from the specified
  /// BasicBlock to its predecessors requires PHI translation.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::NeedsPHITranslationFromBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PHITransAddr.h", line = 64,
   FQN="llvm::PHITransAddr::NeedsPHITranslationFromBlock", NM="_ZNK4llvm12PHITransAddr28NeedsPHITranslationFromBlockEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12PHITransAddr28NeedsPHITranslationFromBlockEPNS_10BasicBlockE")
  //</editor-fold>
  public boolean NeedsPHITranslationFromBlock(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// IsPotentiallyPHITranslatable - If this needs PHI translation, return true
  /// if we have some hope of doing it.  This should be used as a filter to
  /// avoid calling PHITranslateValue in hopeless situations.
  
  /// IsPotentiallyPHITranslatable - If this needs PHI translation, return true
  /// if we have some hope of doing it.  This should be used as a filter to
  /// avoid calling PHITranslateValue in hopeless situations.
  
  /// IsPotentiallyPHITranslatable - If this needs PHI translation, return true
  /// if we have some hope of doing it.  This should be used as a filter to
  /// avoid calling PHITranslateValue in hopeless situations.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::IsPotentiallyPHITranslatable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp", line = 115,
   FQN="llvm::PHITransAddr::IsPotentiallyPHITranslatable", NM="_ZNK4llvm12PHITransAddr28IsPotentiallyPHITranslatableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp -nm=_ZNK4llvm12PHITransAddr28IsPotentiallyPHITranslatableEv")
  //</editor-fold>
  public boolean IsPotentiallyPHITranslatable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// PHITranslateValue - PHI translate the current address up the CFG from
  /// CurBB to Pred, updating our state to reflect any needed changes.  If
  /// 'MustDominate' is true, the translated value must dominate
  /// PredBB.  This returns true on failure and sets Addr to null.
  
  /// PHITranslateValue - PHI translate the current address up the CFG from
  /// CurBB to Pred, updating our state to reflect any needed changes.  If
  /// 'MustDominate' is true, the translated value must dominate
  /// PredBB.  This returns true on failure and sets Addr to null.
  
  /// PHITranslateValue - PHI translate the current address up the CFG from
  /// CurBB to Pred, updating our state to reflect any needed changes.  If
  /// 'MustDominate' is true, the translated value must dominate
  /// PredBB.  This returns true on failure and sets Addr to null.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::PHITranslateValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp", line = 316,
   FQN="llvm::PHITransAddr::PHITranslateValue", NM="_ZN4llvm12PHITransAddr17PHITranslateValueEPNS_10BasicBlockES2_PKNS_13DominatorTreeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp -nm=_ZN4llvm12PHITransAddr17PHITranslateValueEPNS_10BasicBlockES2_PKNS_13DominatorTreeEb")
  //</editor-fold>
  public boolean PHITranslateValue(BasicBlock /*P*/ CurBB, BasicBlock /*P*/ PredBB, 
                   /*const*/ DominatorTree /*P*/ DT, 
                   boolean MustDominate) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// PHITranslateWithInsertion - PHI translate this value into the specified
  /// predecessor block, inserting a computation of the value if it is
  /// unavailable.
  ///
  /// All newly created instructions are added to the NewInsts list.  This
  /// returns null on failure.
  ///
  
  /// PHITranslateWithInsertion - PHI translate this value into the specified
  /// predecessor block, inserting a computation of the value if it is
  /// unavailable.
  ///
  /// All newly created instructions are added to the NewInsts list.  This
  /// returns null on failure.
  ///
  
  /// PHITranslateWithInsertion - PHI translate this value into the specified
  /// predecessor block, inserting a computation of the value if it is
  /// unavailable.
  ///
  /// All newly created instructions are added to the NewInsts list.  This
  /// returns null on failure.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::PHITranslateWithInsertion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp", line = 344,
   FQN="llvm::PHITransAddr::PHITranslateWithInsertion", NM="_ZN4llvm12PHITransAddr25PHITranslateWithInsertionEPNS_10BasicBlockES2_RKNS_13DominatorTreeERNS_15SmallVectorImplIPNS_11InstructionEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp -nm=_ZN4llvm12PHITransAddr25PHITranslateWithInsertionEPNS_10BasicBlockES2_RKNS_13DominatorTreeERNS_15SmallVectorImplIPNS_11InstructionEEE")
  //</editor-fold>
  public Value /*P*/ PHITranslateWithInsertion(BasicBlock /*P*/ CurBB, BasicBlock /*P*/ PredBB, 
                           final /*const*/ DominatorTree /*&*/ DT, 
                           final SmallVectorImpl<Instruction /*P*/ > /*&*/ NewInsts) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp", line = 45,
   FQN="llvm::PHITransAddr::dump", NM="_ZNK4llvm12PHITransAddr4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp -nm=_ZNK4llvm12PHITransAddr4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Verify - Check internal consistency of this data structure.  If the
  /// structure is valid, it returns true.  If invalid, it prints errors and
  /// returns false.
  
  /// Verify - Check internal consistency of this data structure.  If the
  /// structure is valid, it returns true.  If invalid, it prints errors and
  /// returns false.
  
  /// Verify - Check internal consistency of this data structure.  If the
  /// structure is valid, it returns true.  If invalid, it prints errors and
  /// returns false.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::Verify">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp", line = 92,
   FQN="llvm::PHITransAddr::Verify", NM="_ZNK4llvm12PHITransAddr6VerifyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp -nm=_ZNK4llvm12PHITransAddr6VerifyEv")
  //</editor-fold>
  public boolean Verify() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::PHITranslateSubExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp", line = 145,
   FQN="llvm::PHITransAddr::PHITranslateSubExpr", NM="_ZN4llvm12PHITransAddr19PHITranslateSubExprEPNS_5ValueEPNS_10BasicBlockES4_PKNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp -nm=_ZN4llvm12PHITransAddr19PHITranslateSubExprEPNS_5ValueEPNS_10BasicBlockES4_PKNS_13DominatorTreeE")
  //</editor-fold>
  private Value /*P*/ PHITranslateSubExpr(Value /*P*/ V, BasicBlock /*P*/ CurBB, 
                     BasicBlock /*P*/ PredBB, 
                     /*const*/ DominatorTree /*P*/ DT) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// InsertPHITranslatedSubExpr - Insert a computation of the PHI translated
  /// version of 'V' for the edge PredBB->CurBB into the end of the PredBB
  /// block.  All newly created instructions are added to the NewInsts list.
  /// This returns null on failure.
  ///
  
  /// InsertPHITranslatedSubExpr - Insert a computation of the PHI translated
  /// version of 'V' for the edge PredBB->CurBB into the end of the PredBB
  /// block.  All newly created instructions are added to the NewInsts list.
  /// This returns null on failure.
  ///
  
  /// InsertPHITranslatedPointer - Insert a computation of the PHI translated
  /// version of 'V' for the edge PredBB->CurBB into the end of the PredBB
  /// block.  All newly created instructions are added to the NewInsts list.
  /// This returns null on failure.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::InsertPHITranslatedSubExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp", line = 368,
   FQN="llvm::PHITransAddr::InsertPHITranslatedSubExpr", NM="_ZN4llvm12PHITransAddr26InsertPHITranslatedSubExprEPNS_5ValueEPNS_10BasicBlockES4_RKNS_13DominatorTreeERNS_15SmallVectorImplIPNS_11InstructionEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PHITransAddr.cpp -nm=_ZN4llvm12PHITransAddr26InsertPHITranslatedSubExprEPNS_5ValueEPNS_10BasicBlockES4_RKNS_13DominatorTreeERNS_15SmallVectorImplIPNS_11InstructionEEE")
  //</editor-fold>
  private Value /*P*/ InsertPHITranslatedSubExpr(Value /*P*/ InVal, BasicBlock /*P*/ CurBB, 
                            BasicBlock /*P*/ PredBB, final /*const*/ DominatorTree /*&*/ DT, 
                            final SmallVectorImpl<Instruction /*P*/ > /*&*/ NewInsts) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// AddAsInput - If the specified value is an instruction, add it as an input.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::AddAsInput">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PHITransAddr.h", line = 117,
   FQN="llvm::PHITransAddr::AddAsInput", NM="_ZN4llvm12PHITransAddr10AddAsInputEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12PHITransAddr10AddAsInputEPNS_5ValueE")
  //</editor-fold>
  private Value /*P*/ AddAsInput(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::PHITransAddr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PHITransAddr.h", line = 36,
   FQN="llvm::PHITransAddr::PHITransAddr", NM="_ZN4llvm12PHITransAddrC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12PHITransAddrC1EOS0_")
  //</editor-fold>
  public /*inline*/ PHITransAddr(JD$Move _dparam, final PHITransAddr /*&&*/$Prm0) {
    // : Addr(static_cast<PHITransAddr &&>().Addr), DL(static_cast<PHITransAddr &&>().DL), TLI(static_cast<PHITransAddr &&>().TLI), AC(static_cast<PHITransAddr &&>().AC), InstInputs(static_cast<PHITransAddr &&>().InstInputs) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::PHITransAddr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PHITransAddr.h", line = 36,
   FQN="llvm::PHITransAddr::PHITransAddr", NM="_ZN4llvm12PHITransAddrC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12PHITransAddrC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PHITransAddr(final /*const*/ PHITransAddr /*&*/ $Prm0) {
    // : Addr(.Addr), DL(.DL), TLI(.TLI), AC(.AC), InstInputs(.InstInputs) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHITransAddr::~PHITransAddr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PHITransAddr.h", line = 36,
   FQN="llvm::PHITransAddr::~PHITransAddr", NM="_ZN4llvm12PHITransAddrD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12PHITransAddrD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Addr=" + Addr // NOI18N
              + ", DL=" + DL // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", AC=" + AC // NOI18N
              + ", InstInputs=" + InstInputs; // NOI18N
  }
}
