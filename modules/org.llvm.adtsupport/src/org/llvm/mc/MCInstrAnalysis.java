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

package org.llvm.mc;

import org.clank.support.*;
import org.llvm.mc.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 24,
 FQN = "llvm::MCInstrAnalysis", NM = "_ZN4llvm15MCInstrAnalysisE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZN4llvm15MCInstrAnalysisE")
//</editor-fold>
public class MCInstrAnalysis implements Destructors.ClassWithDestructor {
/*protected:*/
  /*friend  class Target*/;
  protected /*const*/MCInstrInfo /*P*/ Info;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::MCInstrAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 30,
   FQN = "llvm::MCInstrAnalysis::MCInstrAnalysis", NM = "_ZN4llvm15MCInstrAnalysisC1EPKNS_11MCInstrInfoE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZN4llvm15MCInstrAnalysisC1EPKNS_11MCInstrInfoE")
  //</editor-fold>
  public MCInstrAnalysis(/*const*/MCInstrInfo /*P*/ Info) {
    /* : Info(Info)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::~MCInstrAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 32,
   FQN = "llvm::MCInstrAnalysis::~MCInstrAnalysis", NM = "_ZN4llvm15MCInstrAnalysisD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZN4llvm15MCInstrAnalysisD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::isBranch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 34,
   FQN = "llvm::MCInstrAnalysis::isBranch", NM = "_ZNK4llvm15MCInstrAnalysis8isBranchERKNS_6MCInstE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZNK4llvm15MCInstrAnalysis8isBranchERKNS_6MCInstE")
  //</editor-fold>
  public /*virtual*/ boolean isBranch(/*const*/MCInst /*&*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::isConditionalBranch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 38,
   FQN = "llvm::MCInstrAnalysis::isConditionalBranch", NM = "_ZNK4llvm15MCInstrAnalysis19isConditionalBranchERKNS_6MCInstE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZNK4llvm15MCInstrAnalysis19isConditionalBranchERKNS_6MCInstE")
  //</editor-fold>
  public /*virtual*/ boolean isConditionalBranch(/*const*/MCInst /*&*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::isUnconditionalBranch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 42,
   FQN = "llvm::MCInstrAnalysis::isUnconditionalBranch", NM = "_ZNK4llvm15MCInstrAnalysis21isUnconditionalBranchERKNS_6MCInstE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZNK4llvm15MCInstrAnalysis21isUnconditionalBranchERKNS_6MCInstE")
  //</editor-fold>
  public /*virtual*/ boolean isUnconditionalBranch(/*const*/MCInst /*&*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::isIndirectBranch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 46,
   FQN = "llvm::MCInstrAnalysis::isIndirectBranch", NM = "_ZNK4llvm15MCInstrAnalysis16isIndirectBranchERKNS_6MCInstE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZNK4llvm15MCInstrAnalysis16isIndirectBranchERKNS_6MCInstE")
  //</editor-fold>
  public /*virtual*/ boolean isIndirectBranch(/*const*/MCInst /*&*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::isCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 50,
   FQN = "llvm::MCInstrAnalysis::isCall", NM = "_ZNK4llvm15MCInstrAnalysis6isCallERKNS_6MCInstE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZNK4llvm15MCInstrAnalysis6isCallERKNS_6MCInstE")
  //</editor-fold>
  public /*virtual*/ boolean isCall(/*const*/MCInst /*&*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::isReturn">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 54,
   FQN = "llvm::MCInstrAnalysis::isReturn", NM = "_ZNK4llvm15MCInstrAnalysis8isReturnERKNS_6MCInstE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZNK4llvm15MCInstrAnalysis8isReturnERKNS_6MCInstE")
  //</editor-fold>
  public /*virtual*/ boolean isReturn(/*const*/MCInst /*&*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::isTerminator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrAnalysis.h", line = 58,
   FQN = "llvm::MCInstrAnalysis::isTerminator", NM = "_ZNK4llvm15MCInstrAnalysis12isTerminatorERKNS_6MCInstE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZNK4llvm15MCInstrAnalysis12isTerminatorERKNS_6MCInstE")
  //</editor-fold>
  public /*virtual*/ boolean isTerminator(/*const*/MCInst /*&*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// evaluateBranch - Given a branch instruction try to get the address the
  /// branch targets. Return true on success, and the address in Target.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrAnalysis::evaluateBranch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp", line = 13,
   FQN = "llvm::MCInstrAnalysis::evaluateBranch", NM = "_ZNK4llvm15MCInstrAnalysis14evaluateBranchERKNS_6MCInstEyyRy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstrAnalysis.cpp -nm=_ZNK4llvm15MCInstrAnalysis14evaluateBranchERKNS_6MCInstEyyRy")
  //</editor-fold>
  public boolean evaluateBranch(/*const*/MCInst /*&*/ Inst, long/*uint64_t*/ Addr, long/*uint64_t*/ Size, long/*uint64_t*//*&*/ Target) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

}
