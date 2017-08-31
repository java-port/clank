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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// \brief A record of the "type" of an APSInt, used for conversions.
//<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 20,
 FQN="clang::ento::APSIntType", NM="_ZN5clang4ento10APSIntTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZN5clang4ento10APSIntTypeE")
//</editor-fold>
public class APSIntType implements ComparableLowerGreater, Native.NativeComparable<APSIntType> {
  private /*uint32_t*/int BitWidth;
  private boolean IsUnsigned;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::APSIntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 25,
   FQN="clang::ento::APSIntType::APSIntType", NM="_ZN5clang4ento10APSIntTypeC1Ejb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZN5clang4ento10APSIntTypeC1Ejb")
  //</editor-fold>
  public APSIntType(/*uint32_t*/int Width, boolean Unsigned) {
    // : BitWidth(Width), IsUnsigned(Unsigned) 
    //START JInit
    this.BitWidth = Width;
    this.IsUnsigned = Unsigned;
    //END JInit
  }

  
  /* implicit */
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::APSIntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 28,
   FQN="clang::ento::APSIntType::APSIntType", NM="_ZN5clang4ento10APSIntTypeC1ERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZN5clang4ento10APSIntTypeC1ERKN4llvm6APSIntE")
  //</editor-fold>
  public APSIntType(final /*const*/ APSInt /*&*/ Value) {
    // : BitWidth(Value.getBitWidth()), IsUnsigned(Value.isUnsigned()) 
    //START JInit
    this.BitWidth = Value.getBitWidth();
    this.IsUnsigned = Value.isUnsigned();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::getBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 31,
   FQN="clang::ento::APSIntType::getBitWidth", NM="_ZNK5clang4ento10APSIntType11getBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType11getBitWidthEv")
  //</editor-fold>
  public /*uint32_t*/int getBitWidth() /*const*/ {
    return BitWidth;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::isUnsigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 32,
   FQN="clang::ento::APSIntType::isUnsigned", NM="_ZNK5clang4ento10APSIntType10isUnsignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType10isUnsignedEv")
  //</editor-fold>
  public boolean isUnsigned() /*const*/ {
    return IsUnsigned;
  }

  
  /// \brief Convert a given APSInt, in place, to match this type.
  ///
  /// This behaves like a C cast: converting 255u8 (0xFF) to s16 gives
  /// 255 (0x00FF), and converting -1s8 (0xFF) to u16 gives 65535 (0xFFFF).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::apply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 38,
   FQN="clang::ento::APSIntType::apply", NM="_ZNK5clang4ento10APSIntType5applyERN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType5applyERN4llvm6APSIntE")
  //</editor-fold>
  public void apply(final APSInt /*&*/ Value) /*const*/ {
    // Note the order here. We extend first to preserve the sign, if this value
    // is signed, /then/ match the signedness of the result type.
    Value.$assignMove(Value.extOrTrunc(BitWidth));
    Value.setIsUnsigned(IsUnsigned);
  }

  
  /// Convert and return a new APSInt with the given value, but this
  /// type's bit width and signedness.
  ///
  /// \see apply
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::convert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 49,
   FQN="clang::ento::APSIntType::convert", NM="_ZNK5clang4ento10APSIntType7convertERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType7convertERKN4llvm6APSIntE")
  //</editor-fold>
  public APSInt convert(final /*const*/ APSInt /*&*/ Value) /*const*//* __attribute__((pure))*/ {
    APSInt Result/*J*/= new APSInt(new APInt(Value), Value.isUnsigned());
    apply(Result);
    return Result;
  }

  
  /// Returns an all-zero value for this type.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::getZeroValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 56,
   FQN="clang::ento::APSIntType::getZeroValue", NM="_ZNK5clang4ento10APSIntType12getZeroValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType12getZeroValueEv")
  //</editor-fold>
  public APSInt getZeroValue() /*const*//* __attribute__((pure))*/ {
    return new APSInt(BitWidth, IsUnsigned);
  }

  
  /// Returns the minimum value for this type.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::getMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 61,
   FQN="clang::ento::APSIntType::getMinValue", NM="_ZNK5clang4ento10APSIntType11getMinValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType11getMinValueEv")
  //</editor-fold>
  public APSInt getMinValue() /*const*//* __attribute__((pure))*/ {
    return APSInt.getMinValue(BitWidth, IsUnsigned);
  }

  
  /// Returns the maximum value for this type.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::getMaxValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 66,
   FQN="clang::ento::APSIntType::getMaxValue", NM="_ZNK5clang4ento10APSIntType11getMaxValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType11getMaxValueEv")
  //</editor-fold>
  public APSInt getMaxValue() /*const*//* __attribute__((pure))*/ {
    return APSInt.getMaxValue(BitWidth, IsUnsigned);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 70,
   FQN="clang::ento::APSIntType::getValue", NM="_ZNK5clang4ento10APSIntType8getValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType8getValueEy")
  //</editor-fold>
  public APSInt getValue(long/*uint64_t*/ RawValue) /*const*//* __attribute__((pure))*/ {
    return new APSInt((new APSInt(BitWidth, IsUnsigned).$assign(RawValue)));
  }

  
  /// Used to classify whether a value is representable using this type.
  ///
  /// \see testInRange
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::RangeTestResultKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 77,
   FQN="clang::ento::APSIntType::RangeTestResultKind", NM="_ZN5clang4ento10APSIntType19RangeTestResultKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZN5clang4ento10APSIntType19RangeTestResultKindE")
  //</editor-fold>
  public enum RangeTestResultKind implements Native.NativeIntEnum {
    RTR_Below(-1), ///< Value is less than the minimum representable value.
    RTR_Within(0), ///< Value is representable using this type.
    RTR_Above(1); ///< Value is greater than the maximum representable value.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RangeTestResultKind valueOf(int val) {
      RangeTestResultKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RangeTestResultKind[] VALUES;
      private static final RangeTestResultKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RangeTestResultKind kind : RangeTestResultKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RangeTestResultKind[min < 0 ? (1-min) : 0];
        VALUES = new RangeTestResultKind[max >= 0 ? (1+max) : 0];
        for (RangeTestResultKind kind : RangeTestResultKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final int value;
    private RangeTestResultKind(int val) { this.value = (int)val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Tests whether a given value is losslessly representable using this type.
  ///
  /// \param Val The value to test.
  /// \param AllowMixedSign Whether or not to allow signedness conversions.
  ///                       This determines whether -1s8 is considered in range
  ///                       for 'unsigned char' (u8).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::testInRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp", line = 15,
   FQN="clang::ento::APSIntType::testInRange", NM="_ZNK5clang4ento10APSIntType11testInRangeERKN4llvm6APSIntEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntType11testInRangeERKN4llvm6APSIntEb")
  //</editor-fold>
  public APSIntType.RangeTestResultKind testInRange(final /*const*/ APSInt /*&*/ Value, 
             boolean AllowSignConversions) /*const*//* __attribute__((pure))*/ {
    
    // Negative numbers cannot be losslessly converted to unsigned type.
    if (IsUnsigned && !AllowSignConversions
       && Value.isSigned() && Value.isNegative()) {
      return RangeTestResultKind.RTR_Below;
    }
    
    /*uint*/int MinBits;
    if (AllowSignConversions) {
      if (Value.isSigned() && !IsUnsigned) {
        MinBits = Value.getMinSignedBits();
      } else {
        MinBits = Value.getActiveBits();
      }
    } else {
      // Signed integers can be converted to signed integers of the same width
      // or (if positive) unsigned integers with one fewer bit.
      // Unsigned integers can be converted to unsigned integers of the same width
      // or signed integers with one more bit.
      if (Value.isSigned()) {
        MinBits = Value.getMinSignedBits() - (IsUnsigned ? 1 : 0);
      } else {
        MinBits = Value.getActiveBits() + ((!IsUnsigned) ? 1 : 0);
      }
    }
    if ($lesseq_uint(MinBits, BitWidth)) {
      return RangeTestResultKind.RTR_Within;
    }
    if (Value.isSigned() && Value.isNegative()) {
      return RangeTestResultKind.RTR_Below;
    } else {
      return RangeTestResultKind.RTR_Above;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 92,
   FQN="clang::ento::APSIntType::operator==", NM="_ZNK5clang4ento10APSIntTypeeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntTypeeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ APSIntType /*&*/ Other) /*const*/ {
    return BitWidth == Other.BitWidth && IsUnsigned == Other.IsUnsigned;
  }

  
  /// \brief Provide an ordering for finding a common conversion type.
  ///
  /// Unsigned integers are considered to be better conversion types than
  /// signed integers of the same width.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 100,
   FQN="clang::ento::APSIntType::operator<", NM="_ZNK5clang4ento10APSIntTypeltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/APSIntType.cpp -nm=_ZNK5clang4ento10APSIntTypeltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ APSIntType /*&*/ Other) /*const*/ {
    // JAVA: unfold tie
    return std.$less_tuple$C(/*std.tie_int_boolean(*/BitWidth, IsUnsigned/*)*/, 
        /*std.tie_int_boolean(*/Other.BitWidth, Other.IsUnsigned/*)*/);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::APSIntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 20,
   FQN="clang::ento::APSIntType::APSIntType", NM="_ZN5clang4ento10APSIntTypeC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN5clang4ento10APSIntTypeC1ERKS1_")
  //</editor-fold>
  public /*inline*/ APSIntType(final /*const*/ APSIntType /*&*/ $Prm0) {
    // : BitWidth(.BitWidth), IsUnsigned(.IsUnsigned) 
    //START JInit
    this.BitWidth = $Prm0.BitWidth;
    this.IsUnsigned = $Prm0.IsUnsigned;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::APSIntType::APSIntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/APSIntType.h", line = 20,
   FQN="clang::ento::APSIntType::APSIntType", NM="_ZN5clang4ento10APSIntTypeC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN5clang4ento10APSIntTypeC1EOS1_")
  //</editor-fold>
  public /*inline*/ APSIntType(JD$Move _dparam, final APSIntType /*&&*/$Prm0) {
    // : BitWidth(static_cast<APSIntType &&>().BitWidth), IsUnsigned(static_cast<APSIntType &&>().IsUnsigned) 
    //START JInit
    this.BitWidth = $Prm0.BitWidth;
    this.IsUnsigned = $Prm0.IsUnsigned;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public boolean $greater(Object o) {APSIntType /*&*/ Other = (APSIntType) o; return Other.$less(this); }
  @Override public boolean $less(Object o) {APSIntType /*&*/ Other = (APSIntType) o; return this.$less(Other); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BitWidth=" + BitWidth // NOI18N
              + ", IsUnsigned=" + IsUnsigned; // NOI18N
  }
}
