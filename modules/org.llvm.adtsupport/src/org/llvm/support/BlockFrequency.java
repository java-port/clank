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

package org.llvm.support;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


// This class represents Block Frequency as a 64-bit value.
//<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 25,
 FQN="llvm::BlockFrequency", NM="_ZN4llvm14BlockFrequencyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencyE")
//</editor-fold>
public class BlockFrequency {
  private long/*uint64_t*/ Frequency;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::BlockFrequency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 29,
   FQN="llvm::BlockFrequency::BlockFrequency", NM="_ZN4llvm14BlockFrequencyC1Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencyC1Ey")
  //</editor-fold>
  public BlockFrequency() {
    this($int2ulong(0));
  }
  public BlockFrequency(long/*uint64_t*/ Freq/*= 0*/) {
    // : Frequency(Freq) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the maximum possible frequency, the saturation value.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::getMaxFrequency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 32,
   FQN="llvm::BlockFrequency::getMaxFrequency", NM="_ZN4llvm14BlockFrequency15getMaxFrequencyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequency15getMaxFrequencyEv")
  //</editor-fold>
  public static long/*uint64_t*/ getMaxFrequency() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the frequency as a fixpoint number scaled by the entry
  /// frequency.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::getFrequency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 36,
   FQN="llvm::BlockFrequency::getFrequency", NM="_ZNK4llvm14BlockFrequency12getFrequencyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequency12getFrequencyEv")
  //</editor-fold>
  public long/*uint64_t*/ getFrequency() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Multiplies with a branch probability. The computation will never
  /// overflow.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator*=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 20,
   FQN="llvm::BlockFrequency::operator*=", NM="_ZN4llvm14BlockFrequencymLENS_17BranchProbabilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencymLENS_17BranchProbabilityE")
  //</editor-fold>
  public BlockFrequency /*&*/ $starassign(BranchProbability Prob) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 25,
   FQN="llvm::BlockFrequency::operator*", NM="_ZNK4llvm14BlockFrequencymlENS_17BranchProbabilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequencymlENS_17BranchProbabilityE")
  //</editor-fold>
  public BlockFrequency $star(BranchProbability Prob) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Divide by a non-zero branch probability using saturating
  /// arithmetic.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator/=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 31,
   FQN="llvm::BlockFrequency::operator/=", NM="_ZN4llvm14BlockFrequencydVENS_17BranchProbabilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencydVENS_17BranchProbabilityE")
  //</editor-fold>
  public BlockFrequency /*&*/ $slashassign(BranchProbability Prob) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator/">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 36,
   FQN="llvm::BlockFrequency::operator/", NM="_ZNK4llvm14BlockFrequencydvENS_17BranchProbabilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequencydvENS_17BranchProbabilityE")
  //</editor-fold>
  public BlockFrequency $slash(BranchProbability Prob) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Adds another block frequency using saturating arithmetic.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator+=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 42,
   FQN="llvm::BlockFrequency::operator+=", NM="_ZN4llvm14BlockFrequencypLES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencypLES0_")
  //</editor-fold>
  public BlockFrequency /*&*/ $addassign(BlockFrequency Freq) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator+">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 53,
   FQN="llvm::BlockFrequency::operator+", NM="_ZNK4llvm14BlockFrequencyplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequencyplES0_")
  //</editor-fold>
  public BlockFrequency $add(BlockFrequency Freq) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Subtracts another block frequency using saturating arithmetic.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator-=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 59,
   FQN="llvm::BlockFrequency::operator-=", NM="_ZN4llvm14BlockFrequencymIES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencymIES0_")
  //</editor-fold>
  public BlockFrequency /*&*/ $minusassign(BlockFrequency Freq) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator-">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 68,
   FQN="llvm::BlockFrequency::operator-", NM="_ZNK4llvm14BlockFrequencymiES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequencymiES0_")
  //</editor-fold>
  public BlockFrequency $sub(BlockFrequency Freq) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Shift block frequency to the right by count digits saturating to 1.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator>>=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp", line = 74,
   FQN="llvm::BlockFrequency::operator>>=", NM="_ZN4llvm14BlockFrequencyrSEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencyrSEj")
  //</editor-fold>
  public BlockFrequency /*&*/ $rshiftassign(/*const*//*uint*/int count) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 59,
   FQN="llvm::BlockFrequency::operator<", NM="_ZNK4llvm14BlockFrequencyltES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequencyltES0_")
  //</editor-fold>
  public boolean $less(BlockFrequency RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator<=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 63,
   FQN="llvm::BlockFrequency::operator<=", NM="_ZNK4llvm14BlockFrequencyleES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequencyleES0_")
  //</editor-fold>
  public boolean $lesseq(BlockFrequency RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 67,
   FQN="llvm::BlockFrequency::operator>", NM="_ZNK4llvm14BlockFrequencygtES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequencygtES0_")
  //</editor-fold>
  public boolean $greater(BlockFrequency RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator>=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 71,
   FQN="llvm::BlockFrequency::operator>=", NM="_ZNK4llvm14BlockFrequencygeES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZNK4llvm14BlockFrequencygeES0_")
  //</editor-fold>
  public boolean $greatereq(BlockFrequency RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::BlockFrequency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 25,
   FQN="llvm::BlockFrequency::BlockFrequency", NM="_ZN4llvm14BlockFrequencyC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencyC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BlockFrequency(final /*const*/ BlockFrequency /*&*/ $Prm0) {
    // : Frequency(.Frequency) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::BlockFrequency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 25,
   FQN="llvm::BlockFrequency::BlockFrequency", NM="_ZN4llvm14BlockFrequencyC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BlockFrequency.cpp -nm=_ZN4llvm14BlockFrequencyC1EOS0_")
  //</editor-fold>
  public /*inline*/ BlockFrequency(JD$Move _dparam, final BlockFrequency /*&&*/$Prm0) {
    // : Frequency(static_cast<BlockFrequency &&>().Frequency) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequency::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BlockFrequency.h", line = 25,
   FQN="llvm::BlockFrequency::operator=", NM="_ZN4llvm14BlockFrequencyaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp -nm=_ZN4llvm14BlockFrequencyaSEOS0_")
  //</editor-fold>
  public /*inline*/ BlockFrequency /*&*/ $assignMove(final BlockFrequency /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Frequency=" + Frequency; // NOI18N
  }
}
