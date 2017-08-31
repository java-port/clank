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

//<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 39,
 FQN="llvm::DemandedBits", NM="_ZN4llvm12DemandedBitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBitsE")
//</editor-fold>
public class DemandedBits implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::DemandedBits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 41,
   FQN="llvm::DemandedBits::DemandedBits", NM="_ZN4llvm12DemandedBitsC1ERNS_8FunctionERNS_15AssumptionCacheERNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBitsC1ERNS_8FunctionERNS_15AssumptionCacheERNS_13DominatorTreeE")
  //</editor-fold>
  public DemandedBits(final Function /*&*/ F, final AssumptionCache /*&*/ AC, final DominatorTree /*&*/ DT) {
    // : F(F), AC(AC), DT(DT), Analyzed(false), Visited(), AliveBits() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the bits demanded from instruction I.
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::getDemandedBits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 362,
   FQN="llvm::DemandedBits::getDemandedBits", NM="_ZN4llvm12DemandedBits15getDemandedBitsEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits15getDemandedBitsEPNS_11InstructionE")
  //</editor-fold>
  public APInt getDemandedBits(Instruction /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if, during analysis, I could not be reached.
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::isInstructionDead">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 371,
   FQN="llvm::DemandedBits::isInstructionDead", NM="_ZN4llvm12DemandedBits17isInstructionDeadEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits17isInstructionDeadEPNS_11InstructionE")
  //</editor-fold>
  public boolean isInstructionDead(Instruction /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 378,
   FQN="llvm::DemandedBits::print", NM="_ZN4llvm12DemandedBits5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private final Function /*&*/ F;
  private final AssumptionCache /*&*/ AC;
  private final DominatorTree /*&*/ DT;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::performAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 261,
   FQN="llvm::DemandedBits::performAnalysis", NM="_ZN4llvm12DemandedBits15performAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits15performAnalysisEv")
  //</editor-fold>
  private void performAnalysis() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::determineLiveOperandBits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 73,
   FQN="llvm::DemandedBits::determineLiveOperandBits", NM="_ZN4llvm12DemandedBits24determineLiveOperandBitsEPKNS_11InstructionES3_jRKNS_5APIntERS4_S7_S7_S7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBits24determineLiveOperandBitsEPKNS_11InstructionES3_jRKNS_5APIntERS4_S7_S7_S7_S7_")
  //</editor-fold>
  private void determineLiveOperandBits(/*const*/ Instruction /*P*/ UserI, /*const*/ Instruction /*P*/ I, /*uint*/int OperandNo, 
                          final /*const*/ APInt /*&*/ AOut, final APInt /*&*/ AB, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                          final APInt /*&*/ KnownZero2, final APInt /*&*/ KnownOne2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private boolean Analyzed;
  
  // The set of visited instructions (non-integer-typed only).
  private SmallPtrSet<Instruction /*P*/ > Visited;
  private DenseMap<Instruction /*P*/ , APInt> AliveBits;
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::DemandedBits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 39,
   FQN="llvm::DemandedBits::DemandedBits", NM="_ZN4llvm12DemandedBitsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBitsC1EOS0_")
  //</editor-fold>
  public /*inline*/ DemandedBits(JD$Move _dparam, final DemandedBits /*&&*/$Prm0) {
    // : F(static_cast<DemandedBits &&>().F), AC(static_cast<DemandedBits &&>().AC), DT(static_cast<DemandedBits &&>().DT), Analyzed(static_cast<DemandedBits &&>().Analyzed), Visited(static_cast<DemandedBits &&>().Visited), AliveBits(static_cast<DemandedBits &&>().AliveBits) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBits::~DemandedBits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 39,
   FQN="llvm::DemandedBits::~DemandedBits", NM="_ZN4llvm12DemandedBitsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm12DemandedBitsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", AC=" + AC // NOI18N
              + ", DT=" + DT // NOI18N
              + ", Analyzed=" + Analyzed // NOI18N
              + ", Visited=" + Visited // NOI18N
              + ", AliveBits=" + AliveBits; // NOI18N
  }
}
