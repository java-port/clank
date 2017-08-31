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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.llvm.support.*;

//<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 420,
 FQN="llvm::ScaledNumberBase", NM="_ZN4llvm16ScaledNumberBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBaseE")
//</editor-fold>
public class ScaledNumberBase {
/*public:*/
  public static /*const*/int DefaultPrecision = 10;
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp", line = 321,
   old_source = "${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp", old_line = 320,
   FQN="llvm::ScaledNumberBase::dump", NM="_ZN4llvm16ScaledNumberBase4dumpEysi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm16ScaledNumberBase4dumpEysi")
  //</editor-fold>
  public static void dump(long/*uint64_t*/ D, short/*int16_t*/ E, int Width) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp", line = 316,
   old_source = "${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp", old_line = 315,
   FQN="llvm::ScaledNumberBase::print", NM="_ZN4llvm16ScaledNumberBase5printERNS_11raw_ostreamEysij",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm16ScaledNumberBase5printERNS_11raw_ostreamEysij")
  //</editor-fold>
  public static raw_ostream /*&*/ print(final raw_ostream /*&*/ OS, long/*uint64_t*/ D, short/*int16_t*/ E, 
       int Width, /*uint*/int Precision) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::toString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp", line = 202,
   old_source = "${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp", old_line = 201,
   FQN="llvm::ScaledNumberBase::toString", NM="_ZN4llvm16ScaledNumberBase8toStringEysij",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm16ScaledNumberBase8toStringEysij")
  //</editor-fold>
  public static std.string __toString(long/*uint64_t*/ D, short/*int16_t*/ E, int Width, 
            /*uint*/int Precision) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::countLeadingZeros32">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 429,
   FQN="llvm::ScaledNumberBase::countLeadingZeros32", NM="_ZN4llvm16ScaledNumberBase19countLeadingZeros32Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBase19countLeadingZeros32Ej")
  //</editor-fold>
  public static int countLeadingZeros32(/*uint32_t*/int N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::countLeadingZeros64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 430,
   FQN="llvm::ScaledNumberBase::countLeadingZeros64", NM="_ZN4llvm16ScaledNumberBase19countLeadingZeros64Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBase19countLeadingZeros64Ey")
  //</editor-fold>
  public static int countLeadingZeros64(long/*uint64_t*/ N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::getHalf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 431,
   FQN="llvm::ScaledNumberBase::getHalf", NM="_ZN4llvm16ScaledNumberBase7getHalfEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBase7getHalfEy")
  //</editor-fold>
  public static long/*uint64_t*/ getHalf(long/*uint64_t*/ N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::splitSigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 433,
   FQN="llvm::ScaledNumberBase::splitSigned", NM="_ZN4llvm16ScaledNumberBase11splitSignedEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBase11splitSignedEx")
  //</editor-fold>
  public static pairULongBool splitSigned(long/*int64_t*/ N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::joinSigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 439,
   FQN="llvm::ScaledNumberBase::joinSigned", NM="_ZN4llvm16ScaledNumberBase10joinSignedEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBase10joinSignedEyb")
  //</editor-fold>
  public static long/*int64_t*/ joinSigned(long/*uint64_t*/ U, boolean IsNeg) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::ScaledNumberBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 420,
   FQN="llvm::ScaledNumberBase::ScaledNumberBase", NM="_ZN4llvm16ScaledNumberBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBaseC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ScaledNumberBase(final /*const*/ ScaledNumberBase /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::ScaledNumberBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 420,
   FQN="llvm::ScaledNumberBase::ScaledNumberBase", NM="_ZN4llvm16ScaledNumberBaseC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBaseC1EOS0_")
  //</editor-fold>
  public /*inline*/ ScaledNumberBase(JD$Move _dparam, final ScaledNumberBase /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 420,
   FQN="llvm::ScaledNumberBase::operator=", NM="_ZN4llvm16ScaledNumberBaseaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBaseaSERKS0_")
  //</editor-fold>
  public /*inline*/ ScaledNumberBase /*&*/ $assign(final /*const*/ ScaledNumberBase /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 420,
   FQN="llvm::ScaledNumberBase::operator=", NM="_ZN4llvm16ScaledNumberBaseaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBaseaSEOS0_")
  //</editor-fold>
  public /*inline*/ ScaledNumberBase /*&*/ $assignMove(final ScaledNumberBase /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumberBase::ScaledNumberBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 420,
   FQN="llvm::ScaledNumberBase::ScaledNumberBase", NM="_ZN4llvm16ScaledNumberBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm16ScaledNumberBaseC1Ev")
  //</editor-fold>
  public /*inline*/ ScaledNumberBase() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
