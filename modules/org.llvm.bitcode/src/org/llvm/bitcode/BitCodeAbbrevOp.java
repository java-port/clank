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

package org.llvm.bitcode;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;

// End bitc namespace

/// BitCodeAbbrevOp - This describes one or more operands in an abbreviation.
/// This is actually a union of two different things:
///   1. It could be a literal integer value ("the operand is always 17").
///   2. It could be an encoding specification ("this operand encoded like so").
///
//<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 87,
 FQN="llvm::BitCodeAbbrevOp", NM="_ZN4llvm15BitCodeAbbrevOpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOpE")
//</editor-fold>
public class BitCodeAbbrevOp implements NativeCloneable<BitCodeAbbrevOp> {
  private long/*uint64_t*/ Val; // A literal value or data for an encoding.
  private /*JBIT bool*/ boolean IsLiteral /*: 1*/; // Indicate whether this is a literal value or not.
  private /*JBYTE unsigned int*/ byte Enc /*: 3*/; // The encoding to use.

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::Encoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 92,
   FQN="llvm::BitCodeAbbrevOp::Encoding", NM="_ZN4llvm15BitCodeAbbrevOp8EncodingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOp8EncodingE")
  //</editor-fold>
  public enum Encoding implements Native.NativeUIntEnum {
    Fixed(1), // A fixed width field, Val specifies number of bits.
    VBR(2), // A VBR field where Val specifies the width of each chunk.
    Array(3), // A sequence of fields, next field species elt encoding.
    Char6(4), // A 6-bit fixed field which maps to [a-zA-Z0-9._].
    Blob(5); // 32-bit aligned array of 8-bit characters.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Encoding valueOf(int val) {
      Encoding out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Encoding[] VALUES;
      private static final Encoding[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Encoding kind : Encoding.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Encoding[min < 0 ? (1-min) : 0];
        VALUES = new Encoding[max >= 0 ? (1+max) : 0];
        for (Encoding kind : Encoding.values()) {
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

    private final /*uint*/int value;
    private Encoding(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::BitCodeAbbrevOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 100,
   FQN="llvm::BitCodeAbbrevOp::BitCodeAbbrevOp", NM="_ZN4llvm15BitCodeAbbrevOpC1Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOpC1Ey")
  //</editor-fold>
  public /*explicit*/ BitCodeAbbrevOp(long/*uint64_t*/ V) {
    // : Val(V), IsLiteral(true) 
    //START JInit
    this.Val = V;
    this.IsLiteral = true;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::BitCodeAbbrevOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 101,
   FQN="llvm::BitCodeAbbrevOp::BitCodeAbbrevOp", NM="_ZN4llvm15BitCodeAbbrevOpC1ENS0_8EncodingEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOpC1ENS0_8EncodingEy")
  //</editor-fold>
  public /*explicit*/ BitCodeAbbrevOp(Encoding E) {
    this(E, $int2ulong(0));
  }
  public /*explicit*/ BitCodeAbbrevOp(Encoding E, long/*uint64_t*/ Data/*= 0*/) {
    // : Val(Data), IsLiteral(false), Enc(E) 
    //START JInit
    this.Val = Data;
    this.IsLiteral = false;
    this.Enc = $uint2uint_3bits(E.getValue());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::isLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 104,
   FQN="llvm::BitCodeAbbrevOp::isLiteral", NM="_ZNK4llvm15BitCodeAbbrevOp9isLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitCodeAbbrevOp9isLiteralEv")
  //</editor-fold>
  public boolean isLiteral() /*const*/ {
    return IsLiteral;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::isEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 105,
   FQN="llvm::BitCodeAbbrevOp::isEncoding", NM="_ZNK4llvm15BitCodeAbbrevOp10isEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitCodeAbbrevOp10isEncodingEv")
  //</editor-fold>
  public boolean isEncoding() /*const*/ {
    return !IsLiteral;
  }

  
  // Accessors for literals.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::getLiteralValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 108,
   FQN="llvm::BitCodeAbbrevOp::getLiteralValue", NM="_ZNK4llvm15BitCodeAbbrevOp15getLiteralValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitCodeAbbrevOp15getLiteralValueEv")
  //</editor-fold>
  public long/*uint64_t*/ getLiteralValue() /*const*/ {
    assert (isLiteral());
    return Val;
  }

  
  // Accessors for encoding info.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::getEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 111,
   FQN="llvm::BitCodeAbbrevOp::getEncoding", NM="_ZNK4llvm15BitCodeAbbrevOp11getEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitCodeAbbrevOp11getEncodingEv")
  //</editor-fold>
  public Encoding getEncoding() /*const*/ {
    assert (isEncoding());
    return Encoding.valueOf($3bits_uint2uint(Enc));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::getEncodingData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 112,
   FQN="llvm::BitCodeAbbrevOp::getEncodingData", NM="_ZNK4llvm15BitCodeAbbrevOp15getEncodingDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitCodeAbbrevOp15getEncodingDataEv")
  //</editor-fold>
  public long/*uint64_t*/ getEncodingData() /*const*/ {
    assert (isEncoding() && hasEncodingData());
    return Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::hasEncodingData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 117,
   FQN="llvm::BitCodeAbbrevOp::hasEncodingData", NM="_ZNK4llvm15BitCodeAbbrevOp15hasEncodingDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitCodeAbbrevOp15hasEncodingDataEv")
  //</editor-fold>
  public boolean hasEncodingData() /*const*/ {
    return BitCodeAbbrevOp.hasEncodingData(getEncoding());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::hasEncodingData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 118,
   FQN="llvm::BitCodeAbbrevOp::hasEncodingData", NM="_ZN4llvm15BitCodeAbbrevOp15hasEncodingDataENS0_8EncodingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOp15hasEncodingDataENS0_8EncodingE")
  //</editor-fold>
  public static boolean hasEncodingData(Encoding E) {
    switch (E) {
     case Fixed:
     case VBR:
      return true;
     case Array:
     case Char6:
     case Blob:
      return false;
    }
    report_fatal_error($("Invalid encoding"));
    return false;
  }

  
  /// isChar6 - Return true if this character is legal in the Char6 encoding.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::isChar6">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 132,
   FQN="llvm::BitCodeAbbrevOp::isChar6", NM="_ZN4llvm15BitCodeAbbrevOp7isChar6Ec",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOp7isChar6Ec")
  //</editor-fold>
  public static boolean isChar6(/*char*/byte C) {
    if (C >= $$a && C <= $$z) {
      return true;
    }
    if (C >= $$A && C <= $$Z) {
      return true;
    }
    if (C >= $$0 && C <= $$9) {
      return true;
    }
    if (C == $$DOT || C == $$UNDERSCORE) {
      return true;
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::EncodeChar6">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 139,
   FQN="llvm::BitCodeAbbrevOp::EncodeChar6", NM="_ZN4llvm15BitCodeAbbrevOp11EncodeChar6Ec",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOp11EncodeChar6Ec")
  //</editor-fold>
  public static /*uint*/int EncodeChar6(/*char*/byte C) {
    if (C >= $$a && C <= $$z) {
      return C - $$a;
    }
    if (C >= $$A && C <= $$Z) {
      return C - $$A + 26;
    }
    if (C >= $$0 && C <= $$9) {
      return C - $$0 + 26 + 26;
    }
    if (C == $$DOT) {
      return 62;
    }
    if (C == $$UNDERSCORE) {
      return 63;
    }
    throw new llvm_unreachable("Not a value Char6 character!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::DecodeChar6">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 148,
   FQN="llvm::BitCodeAbbrevOp::DecodeChar6", NM="_ZN4llvm15BitCodeAbbrevOp11DecodeChar6Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOp11DecodeChar6Ej")
  //</editor-fold>
  public static /*char*/byte DecodeChar6(/*uint*/int V) {
    assert ((V & ~63) == 0) : "Not a Char6 encoded character!";
    return $("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789._").$at(V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::BitCodeAbbrevOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 87,
   FQN="llvm::BitCodeAbbrevOp::BitCodeAbbrevOp", NM="_ZN4llvm15BitCodeAbbrevOpC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOpC1EOS0_")
  //</editor-fold>
  public /*inline*/ BitCodeAbbrevOp(JD$Move _dparam, final BitCodeAbbrevOp /*&&*/$Prm0) {
    // : Val(static_cast<BitCodeAbbrevOp &&>().Val), IsLiteral(static_cast<BitCodeAbbrevOp &&>().IsLiteral), Enc(static_cast<BitCodeAbbrevOp &&>().Enc) 
    //START JInit
    this.Val = $Prm0.Val;
    this.IsLiteral = $Prm0.IsLiteral;
    this.Enc = $uint2uint_3bits($3bits_uint2uint($Prm0.Enc));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitCodeAbbrevOp::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitCodes.h", line = 87,
   FQN="llvm::BitCodeAbbrevOp::operator=", NM="_ZN4llvm15BitCodeAbbrevOpaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitCodeAbbrevOpaSEOS0_")
  //</editor-fold>
  public /*inline*/ BitCodeAbbrevOp /*&*/ $assignMove(final BitCodeAbbrevOp /*&&*/$Prm0) {
    this.Val = $Prm0.Val;
    this.IsLiteral = $Prm0.IsLiteral;
    this.Enc = $uint2uint_3bits($3bits_uint2uint($Prm0.Enc));
    return /*Deref*/this;
  }

  public BitCodeAbbrevOp() {
  }

  public BitCodeAbbrevOp(BitCodeAbbrevOp other) {
    this.Val = other.Val;
    this.IsLiteral = other.IsLiteral;
    this.Enc = $uint2uint_3bits($3bits_uint2uint(other.Enc));
  }

  @Override
  public BitCodeAbbrevOp clone() {
    return new BitCodeAbbrevOp(this);
  }
  
  @Override public String toString() {
    return "" + "Val=" + Val // NOI18N
              + ", IsLiteral=" + IsLiteral // NOI18N
              + ", Enc=" + $uchar2uint(Enc); // NOI18N
  }
}
