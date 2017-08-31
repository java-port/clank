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

package org.clang.ast;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;


/// CharUnits - This is an opaque type for sizes expressed in character units.
/// Instances of this type represent a quantity as a multiple of the size
/// of the standard C type, char, on the target architecture. As an opaque
/// type, CharUnits protects you from accidentally combining operations on
/// quantities in bit units and character units.
///
/// In both C and C++, an object of type 'char', 'signed char', or 'unsigned
/// char' occupies exactly one byte, so 'character unit' and 'byte' refer to
/// the same quantity of storage. However, we use the term 'character unit'
/// rather than 'byte' to avoid an implication that a character unit is
/// exactly 8 bits.
///
/// For portability, never assume that a target character is 8 bits wide. Use
/// CharUnit values wherever you calculate sizes, offsets, or alignments
/// in character units.
//<editor-fold defaultstate="collapsed" desc="clang::CharUnits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 38,
 FQN="clang::CharUnits", NM="_ZN5clang9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsE")
//</editor-fold>
public class CharUnits implements ComparableLowerGreater, Native.NativeComparable<CharUnits>, NativePOD<CharUnits>, NativeMoveable<CharUnits> {
/*public:*/
  /*typedef int64_t QuantityType*/;
/*private:*/
  private long/*int64_t*/ Quantity;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::CharUnits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 45,
   FQN="clang::CharUnits::CharUnits", NM="_ZN5clang9CharUnitsC1Ex",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsC1Ex")
  //</editor-fold>
  private /*explicit*/ CharUnits(long/*int64_t*/ C) {
    // : Quantity(C) 
    //START JInit
    this.Quantity = C;
    //END JInit
  }

/*public:*/
  
  /// CharUnits - A default constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::CharUnits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 50,
   FQN="clang::CharUnits::CharUnits", NM="_ZN5clang9CharUnitsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsC1Ev")
  //</editor-fold>
  public CharUnits() {
    // : Quantity(0) 
    //START JInit
    this.Quantity = 0;
    //END JInit
  }

  
  /// Zero - Construct a CharUnits quantity of zero.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::Zero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 53,
   FQN="clang::CharUnits::Zero", NM="_ZN5clang9CharUnits4ZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnits4ZeroEv")
  //</editor-fold>
  public static CharUnits Zero() {
    return new CharUnits(0);
  }

  
  /// One - Construct a CharUnits quantity of one.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::One">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 58,
   FQN="clang::CharUnits::One", NM="_ZN5clang9CharUnits3OneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnits3OneEv")
  //</editor-fold>
  public static CharUnits One() {
    return new CharUnits(1);
  }

  
  /// fromQuantity - Construct a CharUnits quantity from a raw integer type.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::fromQuantity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 63,
   FQN="clang::CharUnits::fromQuantity", NM="_ZN5clang9CharUnits12fromQuantityEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnits12fromQuantityEx")
  //</editor-fold>
  public static CharUnits fromQuantity(long/*int64_t*/ Quantity) {
    return new CharUnits(Quantity);
  }

  
  // Compound assignment.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator+=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 68,
   FQN="clang::CharUnits::operator+=", NM="_ZN5clang9CharUnitspLERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitspLERKS0_")
  //</editor-fold>
  public CharUnits /*&*/ $addassign(final /*const*/ CharUnits /*&*/ Other) {
    Quantity += Other.Quantity;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 72,
   FQN="clang::CharUnits::operator++", NM="_ZN5clang9CharUnitsppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsppEv")
  //</editor-fold>
  public CharUnits /*&*/ $preInc() {
    ++Quantity;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 76,
   FQN="clang::CharUnits::operator++", NM="_ZN5clang9CharUnitsppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsppEi")
  //</editor-fold>
  public CharUnits $postInc(int $Prm0) {
    return new CharUnits(Quantity++);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator-=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 79,
   FQN="clang::CharUnits::operator-=", NM="_ZN5clang9CharUnitsmIERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsmIERKS0_")
  //</editor-fold>
  public CharUnits /*&*/ $minusassign(final /*const*/ CharUnits /*&*/ Other) {
    Quantity -= Other.Quantity;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 83,
   FQN="clang::CharUnits::operator--", NM="_ZN5clang9CharUnitsmmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsmmEv")
  //</editor-fold>
  public CharUnits /*&*/ $preDec() {
    --Quantity;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 87,
   FQN="clang::CharUnits::operator--", NM="_ZN5clang9CharUnitsmmEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsmmEi")
  //</editor-fold>
  public CharUnits $postDec(int $Prm0) {
    return new CharUnits(Quantity--);
  }

  
  // Comparison operators.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 92,
   FQN="clang::CharUnits::operator==", NM="_ZNK5clang9CharUnitseqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitseqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return Quantity == Other.Quantity;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 95,
   FQN="clang::CharUnits::operator!=", NM="_ZNK5clang9CharUnitsneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return Quantity != Other.Quantity;
  }

  
  // Relational operators.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 100,
   FQN="clang::CharUnits::operator<", NM="_ZNK5clang9CharUnitsltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return Quantity < Other.Quantity;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 103,
   FQN="clang::CharUnits::operator<=", NM="_ZNK5clang9CharUnitsleERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsleERKS0_")
  //</editor-fold>
  public boolean $lesseq(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return Quantity <= Other.Quantity;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 106,
   FQN="clang::CharUnits::operator>", NM="_ZNK5clang9CharUnitsgtERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsgtERKS0_")
  //</editor-fold>
  public boolean $greater(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return Quantity > Other.Quantity;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator>=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 109,
   FQN="clang::CharUnits::operator>=", NM="_ZNK5clang9CharUnitsgeERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsgeERKS0_")
  //</editor-fold>
  public boolean $greatereq(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return Quantity >= Other.Quantity;
  }

  
  // Other predicates.
  
  /// isZero - Test whether the quantity equals zero.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::isZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 116,
   FQN="clang::CharUnits::isZero", NM="_ZNK5clang9CharUnits6isZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits6isZeroEv")
  //</editor-fold>
  public boolean isZero() /*const*/ {
    return Quantity == 0;
  }

  
  /// isOne - Test whether the quantity equals one.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::isOne">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 119,
   FQN="clang::CharUnits::isOne", NM="_ZNK5clang9CharUnits5isOneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits5isOneEv")
  //</editor-fold>
  public boolean isOne() /*const*/ {
    return Quantity == 1;
  }

  
  /// isPositive - Test whether the quantity is greater than zero.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::isPositive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 122,
   FQN="clang::CharUnits::isPositive", NM="_ZNK5clang9CharUnits10isPositiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits10isPositiveEv")
  //</editor-fold>
  public boolean isPositive() /*const*/ {
    return Quantity > 0;
  }

  
  /// isNegative - Test whether the quantity is less than zero.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::isNegative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 125,
   FQN="clang::CharUnits::isNegative", NM="_ZNK5clang9CharUnits10isNegativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits10isNegativeEv")
  //</editor-fold>
  public boolean isNegative() /*const*/ {
    return Quantity < 0;
  }

  
  /// isPowerOfTwo - Test whether the quantity is a power of two.
  /// Zero is not a power of two.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::isPowerOfTwo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 129,
   FQN="clang::CharUnits::isPowerOfTwo", NM="_ZNK5clang9CharUnits12isPowerOfTwoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits12isPowerOfTwoEv")
  //</editor-fold>
  public boolean isPowerOfTwo() /*const*/ {
    return (Quantity & -Quantity) == Quantity;
  }

  
  /// Test whether this is a multiple of the other value.
  ///
  /// Among other things, this promises that
  /// self.alignTo(N) will just return self.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::isMultipleOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 137,
   FQN="clang::CharUnits::isMultipleOf", NM="_ZNK5clang9CharUnits12isMultipleOfES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits12isMultipleOfES0_")
  //</editor-fold>
  public boolean isMultipleOf(CharUnits N) /*const*/ {
    return ($Deref(this.$mod(N))) == 0;
  }

  
  // Arithmetic operators.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 142,
   FQN="clang::CharUnits::operator*", NM="_ZNK5clang9CharUnitsmlEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsmlEx")
  //</editor-fold>
  public CharUnits $star(long/*int64_t*/ N) /*const*/ {
    return new CharUnits(Quantity * N);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator*=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 145,
   FQN="clang::CharUnits::operator*=", NM="_ZN5clang9CharUnitsmLEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsmLEx")
  //</editor-fold>
  public CharUnits /*&*/ $starassign(long/*int64_t*/ N) {
    Quantity *= N;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator/">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 149,
   FQN="clang::CharUnits::operator/", NM="_ZNK5clang9CharUnitsdvEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsdvEx")
  //</editor-fold>
  public CharUnits $slash(long/*int64_t*/ N) /*const*/ {
    return new CharUnits(Quantity / N);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator/=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 152,
   FQN="clang::CharUnits::operator/=", NM="_ZN5clang9CharUnitsdVEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsdVEx")
  //</editor-fold>
  public CharUnits /*&*/ $slashassign(long/*int64_t*/ N) {
    Quantity /= N;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator/">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 156,
   FQN="clang::CharUnits::operator/", NM="_ZNK5clang9CharUnitsdvERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsdvERKS0_")
  //</editor-fold>
  public long/*int64_t*/ $slash(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return Quantity / Other.Quantity;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator%">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 159,
   FQN="clang::CharUnits::operator%", NM="_ZNK5clang9CharUnitsrmEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsrmEx")
  //</editor-fold>
  public CharUnits $mod(long/*int64_t*/ N) /*const*/ {
    return new CharUnits(Quantity % N);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator%">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 162,
   FQN="clang::CharUnits::operator%", NM="_ZNK5clang9CharUnitsrmERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsrmERKS0_")
  //</editor-fold>
  public long/*int64_t*/ $mod(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return Quantity % Other.Quantity;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator+">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 165,
   FQN="clang::CharUnits::operator+", NM="_ZNK5clang9CharUnitsplERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsplERKS0_")
  //</editor-fold>
  public CharUnits $add(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return new CharUnits(Quantity + Other.Quantity);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 168,
   FQN="clang::CharUnits::operator-", NM="_ZNK5clang9CharUnitsmiERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsmiERKS0_")
  //</editor-fold>
  public CharUnits $sub(final /*const*/ CharUnits /*&*/ Other) /*const*/ {
    return new CharUnits(Quantity - Other.Quantity);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 171,
   FQN="clang::CharUnits::operator-", NM="_ZNK5clang9CharUnitsngEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnitsngEv")
  //</editor-fold>
  public CharUnits $sub() /*const*/ {
    return new CharUnits(-Quantity);
  }

  
  // Conversions.
  
  /// getQuantity - Get the raw integer representation of this quantity.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::getQuantity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 179,
   FQN="clang::CharUnits::getQuantity", NM="_ZNK5clang9CharUnits11getQuantityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits11getQuantityEv")
  //</editor-fold>
  public long/*int64_t*/ getQuantity() /*const*/ {
    return Quantity;
  }

  
  /// alignTo - Returns the next integer (mod 2**64) that is
  /// greater than or equal to this quantity and is a multiple of \p Align.
  /// Align must be non-zero.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::alignTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 184,
   FQN="clang::CharUnits::alignTo", NM="_ZNK5clang9CharUnits7alignToERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits7alignToERKS0_")
  //</editor-fold>
  public CharUnits alignTo(final /*const*/ CharUnits /*&*/ Align) /*const*/ {
    return new CharUnits(llvm.alignTo(Quantity, Align.Quantity));
  }

  
  /// Given that this is a non-zero alignment value, what is the
  /// alignment at the given offset?
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::alignmentAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 190,
   FQN="clang::CharUnits::alignmentAtOffset", NM="_ZNK5clang9CharUnits17alignmentAtOffsetES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits17alignmentAtOffsetES0_")
  //</editor-fold>
  public CharUnits alignmentAtOffset(CharUnits offset) /*const*/ {
    assert (Quantity != 0) : "offsetting from unknown alignment?";
    return new CharUnits(llvm.MinAlign(Quantity, offset.Quantity));
  }

  
  /// Given that this is the alignment of the first element of an
  /// array, return the minimum alignment of any element in the array.
  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::alignmentOfArrayElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 197,
   FQN="clang::CharUnits::alignmentOfArrayElement", NM="_ZNK5clang9CharUnits23alignmentOfArrayElementES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang9CharUnits23alignmentOfArrayElementES0_")
  //</editor-fold>
  public CharUnits alignmentOfArrayElement(CharUnits elementSize) /*const*/ {
    // Since we don't track offsetted alignments, the alignment of
    // the second element (or any odd element) will be minimally
    // aligned.
    return alignmentAtOffset(new CharUnits(elementSize));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::CharUnits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 38,
   FQN="clang::CharUnits::CharUnits", NM="_ZN5clang9CharUnitsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CharUnits(final /*const*/ CharUnits /*&*/ $Prm0) {
    // : Quantity(.Quantity) 
    //START JInit
    this.Quantity = $Prm0.Quantity;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::CharUnits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 38,
   FQN="clang::CharUnits::CharUnits", NM="_ZN5clang9CharUnitsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsC1EOS0_")
  //</editor-fold>
  public /*inline*/ CharUnits(JD$Move _dparam, final CharUnits /*&&*/$Prm0) {
    // : Quantity(static_cast<CharUnits &&>().Quantity) 
    //START JInit
    this.Quantity = $Prm0.Quantity;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 38,
   FQN="clang::CharUnits::operator=", NM="_ZN5clang9CharUnitsaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsaSERKS0_")
  //</editor-fold>
  public /*inline*/ CharUnits /*&*/ $assign(final /*const*/ CharUnits /*&*/ $Prm0) {
    this.Quantity = $Prm0.Quantity;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharUnits::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 38,
   FQN="clang::CharUnits::operator=", NM="_ZN5clang9CharUnitsaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang9CharUnitsaSEOS0_")
  //</editor-fold>
  public /*inline*/ CharUnits /*&*/ $assignMove(final CharUnits /*&&*/$Prm0) {
    this.Quantity = $Prm0.Quantity;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public boolean $less(Object obj) {
    return $less((CharUnits) obj);
  }

  @Override
  public boolean $greater(Object obj) {
    return $greater((CharUnits) obj);
  }

  @Override
  public CharUnits clone() {
    return new CharUnits(this);
  }

  @Override
  public CharUnits move() {
    return new CharUnits().$assignMove(this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Quantity=" + Quantity; // NOI18N
  }
}
