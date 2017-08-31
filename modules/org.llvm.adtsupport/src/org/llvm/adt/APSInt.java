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

package org.llvm.adt;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::APSInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 22,
 FQN="llvm::APSInt", NM="_ZN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntE")
//</editor-fold>
public class APSInt extends /*public*/ APInt<APSInt> implements Destructors.ClassWithDestructor, Native.NativeComparable<APSInt>,
        FoldingSetTrait.Profilable {
  private boolean IsUnsigned;
/*public:*/
  /// Default constructor that creates an uninitialized APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::APSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 27,
   FQN="llvm::APSInt::APSInt", NM="_ZN4llvm6APSIntC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntC1Ev")
  //</editor-fold>
  public /*explicit*/ APSInt() {
    // : APInt(), IsUnsigned(false) 
    //START JInit
    super();
    this.IsUnsigned = false;
    //END JInit
  }

  
  /// APSInt ctor - Create an APSInt with the specified width, default to
  /// unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::APSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 31,
   FQN="llvm::APSInt::APSInt", NM="_ZN4llvm6APSIntC1Ejb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntC1Ejb")
  //</editor-fold>
  public /*explicit*/ APSInt(/*uint32_t*/int BitWidth) {
    this(BitWidth, true);
  }
  public /*explicit*/ APSInt(/*uint32_t*/int BitWidth, boolean isUnsigned/*= true*/) {
    // : APInt(BitWidth, 0), IsUnsigned(isUnsigned) 
    //START JInit
    super(BitWidth, 0);
    this.IsUnsigned = isUnsigned;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::APSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 34,
   FQN="llvm::APSInt::APSInt", NM="_ZN4llvm6APSIntC1ENS_5APIntEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntC1ENS_5APIntEb")
  //</editor-fold>
  public /*explicit*/ APSInt(APInt I) {
    this(I, true);
  }
  public /*explicit*/ APSInt(APInt I, boolean isUnsigned/*= true*/) {
    // : APInt(std::move(I)), IsUnsigned(isUnsigned) 
    //START JInit
    super(JD$Move.INSTANCE, std.move(I));
    this.IsUnsigned = isUnsigned;
    //END JInit
  }

  
  /// Construct an APSInt from a string representation.
  ///
  /// This constructor interprets the string \p Str using the radix of 10.
  /// The interpretation stops at the end of the string. The bit width of the
  /// constructed APSInt is determined automatically.
  ///
  /// \param Str the string to be interpreted.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::APSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APSInt.cpp", line = 21,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APSInt.cpp", old_line = 20,
   FQN="llvm::APSInt::APSInt", NM="_ZN4llvm6APSIntC1ENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntC1ENS_9StringRefE")
  //</editor-fold>
  public APSInt(StringRef Str) {
    // : APInt() 
    //START JInit
    super();
    //END JInit
    assert (!Str.empty()) : "Invalid string length";
    
    // (Over-)estimate the required number of bits.
    /*uint*/int NumBits = ($div_uint((Str.size() * 64), 19)) + 2;
    APInt Tmp/*J*/= new APInt(NumBits, new StringRef(Str), /*Radix=*/ 10);
    if (Str.$at(0) == $$MINUS) {
      /*uint*/int MinBits = Tmp.getMinSignedBits();
      if ($greater_uint(MinBits, 0) && $less_uint(MinBits, NumBits)) {
        Tmp.$assignMove(Tmp.trunc(MinBits));
      }
      /*Deref*/this.$assignMove(new APSInt(new APInt(Tmp), /*IsUnsigned=*/ false));
      return;
    }
    /*uint*/int ActiveBits = Tmp.getActiveBits();
    if ($greater_uint(ActiveBits, 0) && $less_uint(ActiveBits, NumBits)) {
      Tmp.$assignMove(Tmp.trunc(ActiveBits));
    }
    /*Deref*/this.$assignMove(new APSInt(new APInt(Tmp), /*IsUnsigned=*/ true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 46,
   FQN="llvm::APSInt::operator=", NM="_ZN4llvm6APSIntaSENS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntaSENS_5APIntE")
  //</editor-fold>
  public APSInt /*&*/ $assign(APInt RHS) {
    // Retain our current sign.
    super.$assign(RHS);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 52,
   FQN="llvm::APSInt::operator=", NM="_ZN4llvm6APSIntaSEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntaSEy")
  //</editor-fold>
  public APSInt /*&*/ $assign(long/*uint64_t*/ RHS) {
    // Retain our current sign.
    super.$assign(RHS);
    return /*Deref*/this;
  }
  public APSInt /*&*/ $assign(boolean RHS) {
    super.$assign(RHS);
    return /*Deref*/this;
  }

  // Query sign information.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::isSigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 59,
   FQN="llvm::APSInt::isSigned", NM="_ZNK4llvm6APSInt8isSignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt8isSignedEv")
  //</editor-fold>
  public boolean isSigned() /*const*/ {
    return !IsUnsigned;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::isUnsigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 60,
   FQN="llvm::APSInt::isUnsigned", NM="_ZNK4llvm6APSInt10isUnsignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt10isUnsignedEv")
  //</editor-fold>
  public boolean isUnsigned() /*const*/ {
    return IsUnsigned;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::setIsUnsigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 61,
   FQN="llvm::APSInt::setIsUnsigned", NM="_ZN4llvm6APSInt13setIsUnsignedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInt13setIsUnsignedEb")
  //</editor-fold>
  public void setIsUnsigned(boolean Val) {
    IsUnsigned = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::setIsSigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 62,
   FQN="llvm::APSInt::setIsSigned", NM="_ZN4llvm6APSInt11setIsSignedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInt11setIsSignedEb")
  //</editor-fold>
  public void setIsSigned(boolean Val) {
    IsUnsigned = !Val;
  }

  
  /// toString - Append this APSInt to the specified SmallString.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 65,
   FQN="llvm::APSInt::toString", NM="_ZNK4llvm6APSInt8toStringERNS_15SmallVectorImplIcEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt8toStringERNS_15SmallVectorImplIcEEj")
  //</editor-fold>
  public void __toString(final SmallString/*&*/ Str) /*const*/ {
    __toString(Str, 10);
  }
  public void __toString(final SmallString/*&*/ Str, /*uint*/int Radix/*= 10*/) /*const*/ {
    super.__toString(Str, Radix, isSigned());
  }

  /// toString - Converts an APInt to a std::string.  This is an inefficient
  /// method; you should prefer passing in a SmallString instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 70,
   FQN="llvm::APSInt::toString", NM="_ZNK4llvm6APSInt8toStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt8toStringEj")
  //</editor-fold>
  public std.string __toString(/*uint*/int Radix) /*const*/ {
    return super.__toString(Radix, isSigned());
  }

  //JAVA: using APInt::toString;
  
  /// \brief Get the correctly-extended \c int64_t value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::getExtValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 76,
   FQN="llvm::APSInt::getExtValue", NM="_ZNK4llvm6APSInt11getExtValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt11getExtValueEv")
  //</editor-fold>
  public long/*int64_t*/ getExtValue() /*const*/ {
    assert ($lesseq_uint(getMinSignedBits(), 64)) : "Too many bits for int64_t";
    return isSigned() ? getSExtValue() : getZExtValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::trunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 81,
   FQN="llvm::APSInt::trunc", NM="_ZNK4llvm6APSInt5truncEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt5truncEj")
  //</editor-fold>
  public APSInt trunc(/*uint32_t*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    return new APSInt(super.trunc(width), IsUnsigned);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::extend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 85,
   FQN="llvm::APSInt::extend", NM="_ZNK4llvm6APSInt6extendEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt6extendEj")
  //</editor-fold>
  public APSInt extend(/*uint32_t*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    if (IsUnsigned) {
      return new APSInt(zext(width), IsUnsigned);
    } else {
      return new APSInt(sext(width), IsUnsigned);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::extOrTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 92,
   FQN="llvm::APSInt::extOrTrunc", NM="_ZNK4llvm6APSInt10extOrTruncEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt10extOrTruncEj")
  //</editor-fold>
  public APSInt extOrTrunc(/*uint32_t*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    if (IsUnsigned) {
      return new APSInt(zextOrTrunc(width), IsUnsigned);
    } else {
      return new APSInt(sextOrTrunc(width), IsUnsigned);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator%=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 99,
   FQN="llvm::APSInt::operator%=", NM="_ZN4llvm6APSIntrMERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntrMERKS0_")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ $modassign(final /*const*/ APSInt /*&*/ RHS) {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    if (IsUnsigned) {
      /*Deref*/this.$assign(urem(RHS));
    } else {
      /*Deref*/this.$assign(srem(RHS));
    }
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator/=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 107,
   FQN="llvm::APSInt::operator/=", NM="_ZN4llvm6APSIntdVERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntdVERKS0_")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ $slashassign(final /*const*/ APSInt /*&*/ RHS) {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    if (IsUnsigned) {
      /*Deref*/this.$assign(udiv(RHS));
    } else {
      /*Deref*/this.$assign(sdiv(RHS));
    }
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator%">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 115,
   FQN="llvm::APSInt::operator%", NM="_ZNK4llvm6APSIntrmERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntrmERKS0_")
  //</editor-fold>
  public APSInt $mod(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return IsUnsigned ? new APSInt(urem(RHS), true) : new APSInt(srem(RHS), false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator/">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 119,
   FQN="llvm::APSInt::operator/", NM="_ZNK4llvm6APSIntdvERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntdvERKS0_")
  //</editor-fold>
  public APSInt $slash(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return IsUnsigned ? new APSInt(udiv(RHS), true) : new APSInt(sdiv(RHS), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator>>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 124,
   FQN="llvm::APSInt::operator>>", NM="_ZNK4llvm6APSIntrsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntrsEj")
  //</editor-fold>
  public APSInt $in(/*uint*/int Amt) /*const*/ {
    return IsUnsigned ? new APSInt(lshr(Amt), true) : new APSInt(ashr(Amt), false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator>>=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 127,
   FQN="llvm::APSInt::operator>>=", NM="_ZN4llvm6APSIntrSEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntrSEj")
  //</editor-fold>
  public APSInt /*&*/ $rshiftassign(/*uint*/int Amt) {
    /*Deref*/this.$assignMove($Deref(this.$in(Amt)));
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 132,
   FQN="llvm::APSInt::operator<", NM="_ZNK4llvm6APSIntltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntltERKS0_")
  //</editor-fold>
  public /*inline*/ boolean $less(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return IsUnsigned ? ult(RHS) : slt(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 136,
   FQN="llvm::APSInt::operator>", NM="_ZNK4llvm6APSIntgtERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntgtERKS0_")
  //</editor-fold>
  public /*inline*/ boolean $greater(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return IsUnsigned ? ugt(RHS) : sgt(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 140,
   FQN="llvm::APSInt::operator<=", NM="_ZNK4llvm6APSIntleERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntleERKS0_")
  //</editor-fold>
  public /*inline*/ boolean $lesseq(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return IsUnsigned ? ule(RHS) : sle(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator>=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 144,
   FQN="llvm::APSInt::operator>=", NM="_ZNK4llvm6APSIntgeERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntgeERKS0_")
  //</editor-fold>
  public /*inline*/ boolean $greatereq(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return IsUnsigned ? uge(RHS) : sge(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 148,
   FQN="llvm::APSInt::operator==", NM="_ZNK4llvm6APSInteqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInteqERKS0_")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return eq(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 152,
   FQN="llvm::APSInt::operator!=", NM="_ZNK4llvm6APSIntneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntneERKS0_")
  //</editor-fold>
  public /*inline*/ boolean $noteq(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    return !((/*Deref*/this).$eq(RHS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 156,
   FQN="llvm::APSInt::operator==", NM="_ZNK4llvm6APSInteqEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInteqEx")
  //</editor-fold>
  public boolean $eq(long/*int64_t*/ RHS) /*const*/ {
    return compareValues(/*Deref*/this, get(RHS)) == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 159,
   FQN="llvm::APSInt::operator!=", NM="_ZNK4llvm6APSIntneEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntneEx")
  //</editor-fold>
  public boolean $noteq(long/*int64_t*/ RHS) /*const*/ {
    return compareValues(/*Deref*/this, get(RHS)) != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 162,
   FQN="llvm::APSInt::operator<=", NM="_ZNK4llvm6APSIntleEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntleEx")
  //</editor-fold>
  public boolean $lesseq(long/*int64_t*/ RHS) /*const*/ {
    return compareValues(/*Deref*/this, get(RHS)) <= 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator>=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 165,
   FQN="llvm::APSInt::operator>=", NM="_ZNK4llvm6APSIntgeEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntgeEx")
  //</editor-fold>
  public boolean $greatereq(long/*int64_t*/ RHS) /*const*/ {
    return compareValues(/*Deref*/this, get(RHS)) >= 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 168,
   FQN="llvm::APSInt::operator<", NM="_ZNK4llvm6APSIntltEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntltEx")
  //</editor-fold>
  public boolean $less(long/*int64_t*/ RHS) /*const*/ {
    return compareValues(/*Deref*/this, get(RHS)) < 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 171,
   FQN="llvm::APSInt::operator>", NM="_ZNK4llvm6APSIntgtEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntgtEx")
  //</editor-fold>
  public boolean $greater(long/*int64_t*/ RHS) /*const*/ {
    return compareValues(/*Deref*/this, get(RHS)) > 0;
  }

  
  // The remaining operators just wrap the logic of APInt, but retain the
  // signedness information.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 178,
   FQN="llvm::APSInt::operator<<", NM="_ZNK4llvm6APSIntlsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntlsEj")
  //</editor-fold>
  public APSInt $out(/*uint*/int Bits) /*const*/ {
    return new APSInt(super.$out(Bits), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator<<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 181,
   FQN="llvm::APSInt::operator<<=", NM="_ZN4llvm6APSIntlSEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntlSEj")
  //</editor-fold>
  public APSInt /*&*/ $lshiftassign(/*uint*/int Amt) {
    /*Deref*/this.$assignMove($Deref(this.$out(Amt)));
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 186,
   FQN="llvm::APSInt::operator++", NM="_ZN4llvm6APSIntppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntppEv")
  //</editor-fold>
  public APSInt /*&*/ $preInc() {
    super.$preInc();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 190,
   FQN="llvm::APSInt::operator--", NM="_ZN4llvm6APSIntmmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntmmEv")
  //</editor-fold>
  public APSInt /*&*/ $preDec() {
    super.$preDec();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 194,
   FQN="llvm::APSInt::operator++", NM="_ZN4llvm6APSIntppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntppEi")
  //</editor-fold>
  public APSInt $postInc(int $Prm0) {
    return new APSInt(super.$preInc(), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 197,
   FQN="llvm::APSInt::operator--", NM="_ZN4llvm6APSIntmmEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntmmEi")
  //</editor-fold>
  public APSInt $postDec(int $Prm0) {
    return new APSInt(super.$preDec(), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 200,
   FQN="llvm::APSInt::operator-", NM="_ZNK4llvm6APSIntngEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntngEv")
  //</editor-fold>
  public APSInt $sub() /*const*/ {
    return new APSInt(super.$sub(), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator+=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 203,
   FQN="llvm::APSInt::operator+=", NM="_ZN4llvm6APSIntpLERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntpLERKS0_")
  //</editor-fold>
  public APSInt /*&*/ $addassign(final /*const*/ APSInt /*&*/ RHS) {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    super.$addassign(RHS);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator-=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 208,
   FQN="llvm::APSInt::operator-=", NM="_ZN4llvm6APSIntmIERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntmIERKS0_")
  //</editor-fold>
  public APSInt /*&*/ $minusassign(final /*const*/ APSInt /*&*/ RHS) {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    super.$minusassign(RHS);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator*=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 213,
   FQN="llvm::APSInt::operator*=", NM="_ZN4llvm6APSIntmLERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntmLERKS0_")
  //</editor-fold>
  public APSInt /*&*/ $starassign(final /*const*/ APSInt /*&*/ RHS) {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    super.$starassign(RHS);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator&=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 218,
   FQN="llvm::APSInt::operator&=", NM="_ZN4llvm6APSIntaNERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntaNERKS0_")
  //</editor-fold>
  public APSInt /*&*/ $andassign(final /*const*/ APSInt /*&*/ RHS) {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    super.$andassign(RHS);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator|=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 223,
   FQN="llvm::APSInt::operator|=", NM="_ZN4llvm6APSIntoRERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntoRERKS0_")
  //</editor-fold>
  public APSInt /*&*/ $orassign(final /*const*/ APSInt /*&*/ RHS) {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    super.$orassign(RHS);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator^=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 228,
   FQN="llvm::APSInt::operator^=", NM="_ZN4llvm6APSInteOERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInteOERKS0_")
  //</editor-fold>
  public APSInt /*&*/ $xorassign(final /*const*/ APSInt /*&*/ RHS) {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    super.$xorassign(RHS);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator&">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 234,
   FQN="llvm::APSInt::operator&", NM="_ZNK4llvm6APSIntanERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntanERKS0_")
  //</editor-fold>
  public APSInt $bitand(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return new APSInt(super.$bitand(RHS), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::And">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 238,
   FQN="llvm::APSInt::And", NM="_ZNK4llvm6APSInt3AndERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt3AndERKS0_")
  //</editor-fold>
  public APSInt And(final /*const*/ APSInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    return this.$bitand(RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator|">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 242,
   FQN="llvm::APSInt::operator|", NM="_ZNK4llvm6APSIntorERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntorERKS0_")
  //</editor-fold>
  public APSInt $bitor(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return new APSInt(super.$bitor(RHS), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::Or">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 246,
   FQN="llvm::APSInt::Or", NM="_ZNK4llvm6APSInt2OrERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt2OrERKS0_")
  //</editor-fold>
  public APSInt Or(final /*const*/ APSInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    return this.$bitor(RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator^">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 250,
   FQN="llvm::APSInt::operator^", NM="_ZNK4llvm6APSInteoERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInteoERKS0_")
  //</editor-fold>
  public APSInt $bitxor(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return new APSInt(super.$bitxor(RHS), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::Xor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 254,
   FQN="llvm::APSInt::Xor", NM="_ZNK4llvm6APSInt3XorERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt3XorERKS0_")
  //</editor-fold>
  public APSInt Xor(final /*const*/ APSInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    return this.$bitxor(RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 258,
   FQN="llvm::APSInt::operator*", NM="_ZNK4llvm6APSIntmlERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntmlERKS0_")
  //</editor-fold>
  public APSInt $star(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return new APSInt(super.$star(RHS), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator+">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 262,
   FQN="llvm::APSInt::operator+", NM="_ZNK4llvm6APSIntplERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntplERKS0_")
  //</editor-fold>
  public APSInt $add(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return new APSInt(super.$add(RHS), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 266,
   FQN="llvm::APSInt::operator-", NM="_ZNK4llvm6APSIntmiERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntmiERKS0_")
  //</editor-fold>
  public APSInt $sub(final /*const*/ APSInt /*&*/ RHS) /*const*/ {
    assert (IsUnsigned == RHS.IsUnsigned) : "Signedness mismatch!";
    return new APSInt(super.$sub(RHS), IsUnsigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator~">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 270,
   FQN="llvm::APSInt::operator~", NM="_ZNK4llvm6APSIntcoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSIntcoEv")
  //</editor-fold>
  public APSInt $bitnot() /*const*/ {
    return new APSInt(super.$bitnot(), IsUnsigned);
  }

  
  /// getMaxValue - Return the APSInt representing the maximum integer value
  ///  with the given bit width and signedness.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::getMaxValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 276,
   FQN="llvm::APSInt::getMaxValue", NM="_ZN4llvm6APSInt11getMaxValueEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInt11getMaxValueEjb")
  //</editor-fold>
  public static APSInt getMaxValue(/*uint32_t*/int numBits, boolean Unsigned) {
    return new APSInt(Unsigned ? APInt.getMaxValue(numBits) : APInt.getSignedMaxValue(numBits), Unsigned);
  }

  
  /// getMinValue - Return the APSInt representing the minimum integer value
  ///  with the given bit width and signedness.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::getMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 283,
   FQN="llvm::APSInt::getMinValue", NM="_ZN4llvm6APSInt11getMinValueEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInt11getMinValueEjb")
  //</editor-fold>
  public static APSInt getMinValue(/*uint32_t*/int numBits, boolean Unsigned) {
    return new APSInt(Unsigned ? APInt.getMinValue(numBits) : APInt.getSignedMinValue(numBits), Unsigned);
  }

  
  /// \brief Determine if two APSInts have the same value, zero- or
  /// sign-extending as needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::isSameValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 290,
   FQN="llvm::APSInt::isSameValue", NM="_ZN4llvm6APSInt11isSameValueERKS0_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInt11isSameValueERKS0_S2_")
  //</editor-fold>
  public static boolean isSameValue(final /*const*/ APSInt /*&*/ I1, final /*const*/ APSInt /*&*/ I2) {
    return !(compareValues(I1, I2) != 0);
  }

  
  /// \brief Compare underlying values of two numbers.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::compareValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 295,
   FQN="llvm::APSInt::compareValues", NM="_ZN4llvm6APSInt13compareValuesERKS0_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInt13compareValuesERKS0_S2_")
  //</editor-fold>
  public static int compareValues(final /*const*/ APSInt /*&*/ I1, final /*const*/ APSInt /*&*/ I2) {
    if (I1.getBitWidth() == I2.getBitWidth() && I1.isSigned() == I2.isSigned()) {
      return I1.$eq(I2) ? 0 : I1.$greater(I2) ? 1 : -1;
    }
    
    // Check for a bit-width mismatch.
    if ($greater_uint(I1.getBitWidth(), I2.getBitWidth())) {
      return compareValues(I1, I2.extend(I1.getBitWidth()));
    } else if ($greater_uint(I2.getBitWidth(), I1.getBitWidth())) {
      return compareValues(I1.extend(I2.getBitWidth()), I2);
    }
    
    // We have a signedness mismatch. Check for negative values and do an
    // unsigned compare if both are positive.
    if (I1.isSigned()) {
      assert (!I2.isSigned()) : "Expected signed mismatch";
      if (I1.isNegative()) {
        return -1;
      }
    } else {
      assert (I2.isSigned()) : "Expected signed mismatch";
      if (I2.isNegative()) {
        return 1;
      }
    }
    
    return I1.eq(I2) ? 0 : I1.ugt(I2) ? 1 : -1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 320,
   FQN="llvm::APSInt::get", NM="_ZN4llvm6APSInt3getEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInt3getEx")
  //</editor-fold>
  public static APSInt get(long/*int64_t*/ X) {
    return new APSInt(new APInt(64, X), false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::getUnsigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 321,
   FQN="llvm::APSInt::getUnsigned", NM="_ZN4llvm6APSInt11getUnsignedEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSInt11getUnsignedEy")
  //</editor-fold>
  public static APSInt getUnsigned(long/*uint64_t*/ X) {
    return new APSInt(new APInt(64, X), true);
  }

  
  /// Profile - Used to insert APSInt objects, or objects that contain APSInt
  ///  objects, into FoldingSets.
  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APSInt.cpp", line = 40,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APSInt.cpp", old_line = 39,
   FQN="llvm::APSInt::Profile", NM="_ZNK4llvm6APSInt7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZNK4llvm6APSInt7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint((/*uint*/int)(IsUnsigned ? 1 : 0));
    super.Profile(ID);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::APSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 22,
   FQN="llvm::APSInt::APSInt", NM="_ZN4llvm6APSIntC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntC1EOS0_")
  //</editor-fold>
  public /*inline*/ APSInt(JD$Move _dparam, final APSInt /*&&*/$Prm0) {
    // : APInt(static_cast<APSInt &&>()), IsUnsigned(static_cast<APSInt &&>().IsUnsigned) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.IsUnsigned = $Prm0.IsUnsigned;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 22,
   FQN="llvm::APSInt::operator=", NM="_ZN4llvm6APSIntaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntaSEOS0_")
  //</editor-fold>
  public /*inline*/ APSInt /*&*/ $assignMove(final APSInt /*&&*/$Prm0) {
    /*Deref*/super.$assignMove($Prm0);
    this.IsUnsigned = $Prm0.IsUnsigned;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::~APSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 22,
   FQN="llvm::APSInt::~APSInt", NM="_ZN4llvm6APSIntD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp -nm=_ZN4llvm6APSIntD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::APSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 22,
   FQN="llvm::APSInt::APSInt", NM="_ZN4llvm6APSIntC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6APSIntC1ERKS0_")
  //</editor-fold>
  public /*inline*/ APSInt(final /*const*/ APSInt /*&*/ $Prm0) {
    // : APInt(), IsUnsigned(.IsUnsigned) 
    //START JInit
    super($Prm0);
    this.IsUnsigned = $Prm0.IsUnsigned;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::APSInt::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 22,
   FQN="llvm::APSInt::operator=", NM="_ZN4llvm6APSIntaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6APSIntaSERKS0_")
  //</editor-fold>
  public /*inline*/ APSInt /*&*/ $assign(final /*const*/ APSInt /*&*/ $Prm0) {
    /*Deref*/super.$assign((APInt)$Prm0);
    this.IsUnsigned = $Prm0.IsUnsigned;
    return /*Deref*/this;
  }


  @Override
  public APSInt clone() {
    return new APSInt(this);
  }  


  @Override
  public APSInt move() {
    return new APSInt(JD$Move.INSTANCE, this);
  }  
  
  @Override public String toString() {
    return "" + "IsUnsigned=" + IsUnsigned // NOI18N
              + super.toString(); // NOI18N
  }
}
