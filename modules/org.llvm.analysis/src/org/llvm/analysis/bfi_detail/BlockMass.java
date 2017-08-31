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

package org.llvm.analysis.bfi_detail;

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


/// \brief Mass of a block.
///
/// This class implements a sort of fixed-point fraction always between 0.0 and
/// 1.0.  getMass() == UINT64_MAX indicates a value of 1.0.
///
/// Masses can be added and subtracted.  Simple saturation arithmetic is used,
/// so arithmetic operations never overflow or underflow.
///
/// Masses can be multiplied.  Multiplication treats full mass as 1.0 and uses
/// an inexpensive floating-point algorithm that's off-by-one (almost, but not
/// quite, maximum precision).
///
/// Masses can be scaled by \a BranchProbability at maximum precision.
//<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 71,
 FQN="llvm::bfi_detail::BlockMass", NM="_ZN4llvm10bfi_detail9BlockMassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassE")
//</editor-fold>
public class BlockMass implements Native.NativeComparable<BlockMass>, NativeCloneable<BlockMass> {
  private long/*uint64_t*/ Mass;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::BlockMass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 75,
   FQN="llvm::bfi_detail::BlockMass::BlockMass", NM="_ZN4llvm10bfi_detail9BlockMassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassC1Ev")
  //</editor-fold>
  public BlockMass() {
    // : Mass(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::BlockMass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 76,
   FQN="llvm::bfi_detail::BlockMass::BlockMass", NM="_ZN4llvm10bfi_detail9BlockMassC1Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassC1Ey")
  //</editor-fold>
  public /*explicit*/ BlockMass(long/*uint64_t*/ Mass) {
    // : Mass(Mass) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::getEmpty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 78,
   FQN="llvm::bfi_detail::BlockMass::getEmpty", NM="_ZN4llvm10bfi_detail9BlockMass8getEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMass8getEmptyEv")
  //</editor-fold>
  public static BlockMass getEmpty() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::getFull">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 79,
   FQN="llvm::bfi_detail::BlockMass::getFull", NM="_ZN4llvm10bfi_detail9BlockMass7getFullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMass7getFullEv")
  //</editor-fold>
  public static BlockMass getFull() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::getMass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 81,
   FQN="llvm::bfi_detail::BlockMass::getMass", NM="_ZNK4llvm10bfi_detail9BlockMass7getMassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMass7getMassEv")
  //</editor-fold>
  public long/*uint64_t*/ getMass() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::isFull">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 83,
   FQN="llvm::bfi_detail::BlockMass::isFull", NM="_ZNK4llvm10bfi_detail9BlockMass6isFullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMass6isFullEv")
  //</editor-fold>
  public boolean isFull() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::isEmpty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 84,
   FQN="llvm::bfi_detail::BlockMass::isEmpty", NM="_ZNK4llvm10bfi_detail9BlockMass7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMass7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator!">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 86,
   FQN="llvm::bfi_detail::BlockMass::operator!", NM="_ZNK4llvm10bfi_detail9BlockMassntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMassntEv")
  //</editor-fold>
  public boolean $not() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Add another mass.
  ///
  /// Adds another mass, saturating at \a isFull() rather than overflowing.
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator+=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 91,
   FQN="llvm::bfi_detail::BlockMass::operator+=", NM="_ZN4llvm10bfi_detail9BlockMasspLES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMasspLES1_")
  //</editor-fold>
  public BlockMass /*&*/ $addassign(BlockMass X) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Subtract another mass.
  ///
  /// Subtracts another mass, saturating at \a isEmpty() rather than
  /// undeflowing.
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator-=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 101,
   FQN="llvm::bfi_detail::BlockMass::operator-=", NM="_ZN4llvm10bfi_detail9BlockMassmIES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassmIES1_")
  //</editor-fold>
  public BlockMass /*&*/ $minusassign(BlockMass X) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator*=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 107,
   FQN="llvm::bfi_detail::BlockMass::operator*=", NM="_ZN4llvm10bfi_detail9BlockMassmLENS_17BranchProbabilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassmLENS_17BranchProbabilityE")
  //</editor-fold>
  public BlockMass /*&*/ $starassign(BranchProbability P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 112,
   FQN="llvm::bfi_detail::BlockMass::operator==", NM="_ZNK4llvm10bfi_detail9BlockMasseqES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMasseqES1_")
  //</editor-fold>
  public boolean $eq(BlockMass X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 113,
   FQN="llvm::bfi_detail::BlockMass::operator!=", NM="_ZNK4llvm10bfi_detail9BlockMassneES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMassneES1_")
  //</editor-fold>
  public boolean $noteq(BlockMass X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator<=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 114,
   FQN="llvm::bfi_detail::BlockMass::operator<=", NM="_ZNK4llvm10bfi_detail9BlockMassleES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMassleES1_")
  //</editor-fold>
  public boolean $lesseq(BlockMass X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator>=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 115,
   FQN="llvm::bfi_detail::BlockMass::operator>=", NM="_ZNK4llvm10bfi_detail9BlockMassgeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMassgeES1_")
  //</editor-fold>
  public boolean $greatereq(BlockMass X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 116,
   FQN="llvm::bfi_detail::BlockMass::operator<", NM="_ZNK4llvm10bfi_detail9BlockMassltES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMassltES1_")
  //</editor-fold>
  public boolean $less(BlockMass X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 117,
   FQN="llvm::bfi_detail::BlockMass::operator>", NM="_ZNK4llvm10bfi_detail9BlockMassgtES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMassgtES1_")
  //</editor-fold>
  public boolean $greater(BlockMass X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Convert to scaled number.
  ///
  /// Convert to \a ScaledNumber.  \a isFull() gives 1.0, while \a isEmpty()
  /// gives slightly above 0.0.
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::toScaled">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 25,
   FQN="llvm::bfi_detail::BlockMass::toScaled", NM="_ZNK4llvm10bfi_detail9BlockMass8toScaledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMass8toScaledEv")
  //</editor-fold>
  public ScaledNumber<Long/*uint64_t*/> toScaled() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 31,
   FQN="llvm::bfi_detail::BlockMass::dump", NM="_ZNK4llvm10bfi_detail9BlockMass4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMass4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 40,
   FQN="llvm::bfi_detail::BlockMass::print", NM="_ZNK4llvm10bfi_detail9BlockMass5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm10bfi_detail9BlockMass5printERNS_11raw_ostreamE")
  //</editor-fold>
  public raw_ostream /*&*/ print(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::BlockMass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 71,
   FQN="llvm::bfi_detail::BlockMass::BlockMass", NM="_ZN4llvm10bfi_detail9BlockMassC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassC1ERKS1_")
  //</editor-fold>
  public /*inline*/ BlockMass(final /*const*/ BlockMass /*&*/ $Prm0) {
    // : Mass(.Mass) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::BlockMass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 71,
   FQN="llvm::bfi_detail::BlockMass::BlockMass", NM="_ZN4llvm10bfi_detail9BlockMassC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassC1EOS1_")
  //</editor-fold>
  public /*inline*/ BlockMass(JD$Move _dparam, final BlockMass /*&&*/$Prm0) {
    // : Mass(static_cast<BlockMass &&>().Mass) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 71,
   FQN="llvm::bfi_detail::BlockMass::operator=", NM="_ZN4llvm10bfi_detail9BlockMassaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassaSERKS1_")
  //</editor-fold>
  public /*inline*/ BlockMass /*&*/ $assign(final /*const*/ BlockMass /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::BlockMass::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 71,
   FQN="llvm::bfi_detail::BlockMass::operator=", NM="_ZN4llvm10bfi_detail9BlockMassaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail9BlockMassaSEOS1_")
  //</editor-fold>
  public /*inline*/ BlockMass /*&*/ $assignMove(final BlockMass /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  @Override
  public BlockMass clone() {
    return new BlockMass(this);
  }
  
  @Override public String toString() {
    return "" + "Mass=" + Mass; // NOI18N
  }
}
