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

import static java.lang.Math.rint;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;


// This class represents Branch Probability as a non-negative fraction that is
// no greater than 1. It uses a fixed-point-like implementation, in which the
// denominator is always a constant value (here we use 1<<31 for maximum
// precision).
//<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 31,
 FQN="llvm::BranchProbability", NM="_ZN4llvm17BranchProbabilityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilityE")
//</editor-fold>
public class BranchProbability implements Native.NativeComparable<BranchProbability> {
  // Numerator
  private /*uint32_t*/int N;
  
  // Denominator, which is a constant value.
  private static /*const*//*uint32_t*/int D = 1/*U*/ << 31;
  private static /*const*//*uint32_t*/int UnknownN = UINT32_MAX;
  
  // Construct a BranchProbability with only numerator assuming the denominator
  // is 1<<31. For internal use only.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::BranchProbability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 41,
   FQN="llvm::BranchProbability::BranchProbability", NM="_ZN4llvm17BranchProbabilityC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilityC1Ej")
  //</editor-fold>
  private /*explicit*/ BranchProbability(/*uint32_t*/int n) {
    // : N(n) 
    //START JInit
    this.N = n;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::BranchProbability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 44,
   FQN="llvm::BranchProbability::BranchProbability", NM="_ZN4llvm17BranchProbabilityC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilityC1Ev")
  //</editor-fold>
  public BranchProbability() {
    // : N(UnknownN) 
    //START JInit
    this.N = UnknownN;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::BranchProbability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp", line = 37,
   FQN="llvm::BranchProbability::BranchProbability", NM="_ZN4llvm17BranchProbabilityC1Ejj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilityC1Ejj")
  //</editor-fold>
  public BranchProbability(/*uint32_t*/int Numerator, /*uint32_t*/int Denominator) {
    assert ($greater_uint(Denominator, 0)) : "Denominator cannot be 0!";
    assert ($lesseq_uint(Numerator, Denominator)) : "Probability cannot be bigger than 1!";
    if (Denominator == D) {
      N = Numerator;
    } else {
      long/*uint64_t*/ Prob64 = $div_ullong_uint(($uint2ullong(Numerator) * ((/*static_cast*/long/*uint64_t*/)($uint2ulong(D))) + $uint2ullong($div_uint(Denominator, 2))), Denominator);
      N = ((/*static_cast*//*uint32_t*/int)($ulong2uint(Prob64)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::isZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 47,
   FQN="llvm::BranchProbability::isZero", NM="_ZNK4llvm17BranchProbability6isZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbability6isZeroEv")
  //</editor-fold>
  public boolean isZero() /*const*/ {
    return N == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::isUnknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 48,
   FQN="llvm::BranchProbability::isUnknown", NM="_ZNK4llvm17BranchProbability9isUnknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbability9isUnknownEv")
  //</editor-fold>
  public boolean isUnknown() /*const*/ {
    return N == UnknownN;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::getZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 50,
   FQN="llvm::BranchProbability::getZero", NM="_ZN4llvm17BranchProbability7getZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbability7getZeroEv")
  //</editor-fold>
  public static BranchProbability getZero() {
    return new BranchProbability(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::getOne">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 51,
   FQN="llvm::BranchProbability::getOne", NM="_ZN4llvm17BranchProbability6getOneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbability6getOneEv")
  //</editor-fold>
  public static BranchProbability getOne() {
    return new BranchProbability(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::getUnknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 52,
   FQN="llvm::BranchProbability::getUnknown", NM="_ZN4llvm17BranchProbability10getUnknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbability10getUnknownEv")
  //</editor-fold>
  public static BranchProbability getUnknown() {
    return new BranchProbability(UnknownN);
  }

  // Create a BranchProbability object with the given numerator and 1<<31
  // as denominator.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::getRaw">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 55,
   FQN="llvm::BranchProbability::getRaw", NM="_ZN4llvm17BranchProbability6getRawEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbability6getRawEj")
  //</editor-fold>
  public static BranchProbability getRaw(/*uint32_t*/int N) {
    return new BranchProbability(N);
  }

  // Create a BranchProbability object from 64-bit integers.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::getBranchProbability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp", line = 49,
   FQN="llvm::BranchProbability::getBranchProbability", NM="_ZN4llvm17BranchProbability20getBranchProbabilityEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbability20getBranchProbabilityEyy")
  //</editor-fold>
  public static BranchProbability getBranchProbability(long/*uint64_t*/ Numerator, 
                      long/*uint64_t*/ Denominator) {
    assert ($lesseq_ulong(Numerator, Denominator)) : "Probability cannot be bigger than 1!";
    // Scale down Denominator to fit in a 32-bit integer.
    int Scale = 0;
    while ($greater_ulong_uint(Denominator, UINT32_MAX)) {
      Denominator >>>= 1;
      Scale++;
    }
    return new BranchProbability($ulong2uint(Numerator >>> Scale), $ulong2uint(Denominator));
  }

  
  // Normalize given probabilties so that the sum of them becomes approximate
  // one.
  /*template <class ProbabilityIter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::normalizeProbabilities">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", old_line = 175,
   FQN="llvm::BranchProbability::normalizeProbabilities", NM="Tpl__ZN4llvm17BranchProbability22normalizeProbabilitiesET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=Tpl__ZN4llvm17BranchProbability22normalizeProbabilitiesET_S1_")
  //</editor-fold>
  public static </*class*/ ProbabilityIter> void normalizeProbabilities(ProbabilityIter Begin, 
                        ProbabilityIter End) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::getNumerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 66,
   FQN="llvm::BranchProbability::getNumerator", NM="_ZNK4llvm17BranchProbability12getNumeratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbability12getNumeratorEv")
  //</editor-fold>
  public /*uint32_t*/int getNumerator() /*const*/ {
    return N;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::getDenominator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 67,
   FQN="llvm::BranchProbability::getDenominator", NM="_ZN4llvm17BranchProbability14getDenominatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbability14getDenominatorEv")
  //</editor-fold>
  public static /*uint32_t*/int getDenominator() {
    return D;
  }

  
  // Return (1 - Probability).
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::getCompl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 70,
   FQN="llvm::BranchProbability::getCompl", NM="_ZNK4llvm17BranchProbability8getComplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbability8getComplEv")
  //</editor-fold>
  public BranchProbability getCompl() /*const*/ {
    return new BranchProbability(D - N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp", line = 24,
   FQN="llvm::BranchProbability::print", NM="_ZNK4llvm17BranchProbability5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbability5printERNS_11raw_ostreamE")
  //</editor-fold>
  public raw_ostream /*&*/ print(final raw_ostream /*&*/ OS) /*const*/ {
    if (isUnknown()) {
      return OS.$out(/*KEEP_STR*/"?%");
    }
    
    // Get a percentage rounded to two decimal digits. This avoids
    // implementation-defined rounding inside printf.
    double Percent = rint(((double)N / D) * 100. * 100.) / 100.;
    return OS.$out(AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("0x%08x / 0x%08x = %.2f%%"), N, D, 
            Percent));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp", line = 35,
   FQN="llvm::BranchProbability::dump", NM="_ZNK4llvm17BranchProbability4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbability4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(AdtsupportLlvmGlobals.dbgs()).$out_char($$LF);
  }

  
  /// \brief Scale a large integer.
  ///
  /// Scales \c Num.  Guarantees full precision.  Returns the floor of the
  /// result.
  ///
  /// \return \c Num times \c this.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::scale">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp", line = 108,
   FQN="llvm::BranchProbability::scale", NM="_ZNK4llvm17BranchProbability5scaleEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbability5scaleEy")
  //</editor-fold>
  public long/*uint64_t*/ scale(long/*uint64_t*/ Num) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Scale a large integer by the inverse.
  ///
  /// Scales \c Num by the inverse of \c this.  Guarantees full precision.
  /// Returns the floor of the result.
  ///
  /// \return \c Num divided by \c this.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::scaleByInverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp", line = 112,
   FQN="llvm::BranchProbability::scaleByInverse", NM="_ZNK4llvm17BranchProbability14scaleByInverseEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbability14scaleByInverseEy")
  //</editor-fold>
  public long/*uint64_t*/ scaleByInverse(long/*uint64_t*/ Num) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator+=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 92,
   FQN="llvm::BranchProbability::operator+=", NM="_ZN4llvm17BranchProbabilitypLES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilitypLES0_")
  //</editor-fold>
  public BranchProbability /*&*/ $addassign(BranchProbability RHS) {
    assert (N != UnknownN && RHS.N != UnknownN) : "Unknown probability cannot participate in arithmetics.";
    // Saturate the result in case of overflow.
    N = ($greater_ulong_int$C(((long/*uint64_t*/)($uint2ulong(N))) + $uint2ullong(RHS.N), D)) ? D : N + RHS.N;
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator-=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 100,
   FQN="llvm::BranchProbability::operator-=", NM="_ZN4llvm17BranchProbabilitymIES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilitymIES0_")
  //</editor-fold>
  public BranchProbability /*&*/ $minusassign(BranchProbability RHS) {
    assert (N != UnknownN && RHS.N != UnknownN) : "Unknown probability cannot participate in arithmetics.";
    // Saturate the result in case of underflow.
    N = $less_uint(N, RHS.N) ? 0 : N - RHS.N;
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator*=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 108,
   FQN="llvm::BranchProbability::operator*=", NM="_ZN4llvm17BranchProbabilitymLES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilitymLES0_")
  //</editor-fold>
  public BranchProbability /*&*/ $starassign(BranchProbability RHS) {
    assert (N != UnknownN && RHS.N != UnknownN) : "Unknown probability cannot participate in arithmetics.";
    N = $ullong2uint($div_ullong_int/*$C*/((((/*static_cast*/long/*uint64_t*/)($uint2ulong(N))) * $uint2ullong(RHS.N) + $uint2ullong($div_uint(D, 2))), D));
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator/=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 115,
   FQN="llvm::BranchProbability::operator/=", NM="_ZN4llvm17BranchProbabilitydVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilitydVEj")
  //</editor-fold>
  public BranchProbability /*&*/ $slashassign(/*uint32_t*/int RHS) {
    assert (N != UnknownN) : "Unknown probability cannot participate in arithmetics.";
    assert ($greater_uint(RHS, 0)) : "The divider cannot be zero.";
    N = $div_uint(N, RHS);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator+">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 123,
   FQN="llvm::BranchProbability::operator+", NM="_ZNK4llvm17BranchProbabilityplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilityplES0_")
  //</editor-fold>
  public BranchProbability $add(BranchProbability RHS) /*const*/ {
    BranchProbability Prob/*J*/= new BranchProbability(/*Deref*/this);
    return new BranchProbability(Prob.$addassign(/*NO_COPY*/RHS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 128,
   FQN="llvm::BranchProbability::operator-", NM="_ZNK4llvm17BranchProbabilitymiES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilitymiES0_")
  //</editor-fold>
  public BranchProbability $sub(BranchProbability RHS) /*const*/ {
    BranchProbability Prob/*J*/= new BranchProbability(/*Deref*/this);
    return new BranchProbability(Prob.$minusassign(/*NO_COPY*/RHS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 133,
   FQN="llvm::BranchProbability::operator*", NM="_ZNK4llvm17BranchProbabilitymlES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilitymlES0_")
  //</editor-fold>
  public BranchProbability $star(BranchProbability RHS) /*const*/ {
    BranchProbability Prob/*J*/= new BranchProbability(/*Deref*/this);
    return new BranchProbability(Prob.$starassign(/*NO_COPY*/RHS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator/">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 138,
   FQN="llvm::BranchProbability::operator/", NM="_ZNK4llvm17BranchProbabilitydvEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilitydvEj")
  //</editor-fold>
  public BranchProbability $slash(/*uint32_t*/int RHS) /*const*/ {
    BranchProbability Prob/*J*/= new BranchProbability(/*Deref*/this);
    return new BranchProbability(Prob.$slashassign(RHS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 143,
   FQN="llvm::BranchProbability::operator==", NM="_ZNK4llvm17BranchProbabilityeqES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilityeqES0_")
  //</editor-fold>
  public boolean $eq(BranchProbability RHS) /*const*/ {
    return N == RHS.N;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 144,
   FQN="llvm::BranchProbability::operator!=", NM="_ZNK4llvm17BranchProbabilityneES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilityneES0_")
  //</editor-fold>
  public boolean $noteq(BranchProbability RHS) /*const*/ {
    return !(/*Deref*/this.$eq(/*NO_COPY*/RHS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 146,
   FQN="llvm::BranchProbability::operator<", NM="_ZNK4llvm17BranchProbabilityltES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilityltES0_")
  //</editor-fold>
  public boolean $less(BranchProbability RHS) /*const*/ {
    assert (N != UnknownN && RHS.N != UnknownN) : "Unknown probability cannot participate in comparisons.";
    return $less_uint(N, RHS.N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 152,
   FQN="llvm::BranchProbability::operator>", NM="_ZNK4llvm17BranchProbabilitygtES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilitygtES0_")
  //</editor-fold>
  public boolean $greater(BranchProbability RHS) /*const*/ {
    assert (N != UnknownN && RHS.N != UnknownN) : "Unknown probability cannot participate in comparisons.";
    return RHS.$less(/*NO_COPY*//*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 158,
   FQN="llvm::BranchProbability::operator<=", NM="_ZNK4llvm17BranchProbabilityleES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilityleES0_")
  //</editor-fold>
  public boolean $lesseq(BranchProbability RHS) /*const*/ {
    assert (N != UnknownN && RHS.N != UnknownN) : "Unknown probability cannot participate in comparisons.";
    return !(RHS.$less(/*NO_COPY*//*Deref*/this));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator>=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 164,
   FQN="llvm::BranchProbability::operator>=", NM="_ZNK4llvm17BranchProbabilitygeES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZNK4llvm17BranchProbabilitygeES0_")
  //</editor-fold>
  public boolean $greatereq(BranchProbability RHS) /*const*/ {
    assert (N != UnknownN && RHS.N != UnknownN) : "Unknown probability cannot participate in comparisons.";
    return !(/*Deref*/this.$less(/*NO_COPY*/RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::BranchProbability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 31,
   FQN="llvm::BranchProbability::BranchProbability", NM="_ZN4llvm17BranchProbabilityC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilityC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BranchProbability(final /*const*/ BranchProbability /*&*/ $Prm0) {
    // : N(.N) 
    //START JInit
    this.N = $Prm0.N;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::BranchProbability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 31,
   FQN="llvm::BranchProbability::BranchProbability", NM="_ZN4llvm17BranchProbabilityC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm17BranchProbabilityC1EOS0_")
  //</editor-fold>
  public /*inline*/ BranchProbability(JD$Move _dparam, final BranchProbability /*&&*/$Prm0) {
    // : N(static_cast<BranchProbability &&>().N) 
    //START JInit
    this.N = $Prm0.N;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 31,
   FQN="llvm::BranchProbability::operator=", NM="_ZN4llvm17BranchProbabilityaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm17BranchProbabilityaSERKS0_")
  //</editor-fold>
  public /*inline*/ BranchProbability /*&*/ $assign(final /*const*/ BranchProbability /*&*/ $Prm0) {
    this.N = $Prm0.N;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbability::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 31,
   FQN="llvm::BranchProbability::operator=", NM="_ZN4llvm17BranchProbabilityaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm17BranchProbabilityaSEOS0_")
  //</editor-fold>
  public /*inline*/ BranchProbability /*&*/ $assignMove(final BranchProbability /*&&*/$Prm0) {
    this.N = $Prm0.N;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "N=" + N; // NOI18N
  }
}
