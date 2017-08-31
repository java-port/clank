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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;

/*template <typename PointerTy, unsigned int IntBits, typename IntType = unsigned int, typename PtrTraits = PointerLikeTypeTraits<PointerTy>> TEMPLATE*/

/// PointerIntPair - This class implements a pair of a pointer and small
/// integer.  It is designed to represent this in the space required by one
/// pointer by bitmangling the integer into the low part of the pointer.  This
/// can only be done for small integers: typically up to 3 bits, but it depends
/// on the number of bits available according to PointerLikeTypeTraits for the
/// type.
///
/// Note that PointerIntPair always puts the IntVal part in the highest bits
/// possible.  For example, PointerIntPair<void*, 1, bool> will put the bit for
/// the bool into bit #2, not bit #0, which allows the low two bits to be used
/// for something else.  For example, this allows:
///   PointerIntPair<PointerIntPair<void*, 1, bool>, 1, bool>
/// ... and the two bools will land in different bits.
///
//<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 43,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 41,
 FQN = "llvm::PointerIntPair", NM = "_ZN4llvm14PointerIntPairE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZN4llvm14PointerIntPairE")
//</editor-fold>
public class PointerIntPair</*typename*/ PointerTy>  implements Native.NativeComparable<PointerIntPair<PointerTy>>, NativeHashable, NativePOD<PointerIntPair<PointerTy>>, NativePointerLike {
  private PointerTy PtrVal;
  private int IntVal;
//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::<anonymous>">
//  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 44,
//   cmd="jclank.sh -java-imports=${SPUTNIK}/modules/org.llvm.adtsupport/JavaImports ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::<anonymous>")
//  //</editor-fold>
//  private enum Unnamed_enum {
//    /// PointerBitMask - The bits that come from the pointer.
//    PointerBitMask(~(long/*uintptr_t*/)(((long/*intptr_t*/)1 << PtrTraits.NumLowBitsAvailable) - 1)),
//    
//    /// IntShift - The number of low bits that we reserve for other uses, and
//    /// keep zero.
//    IntShift((long/*uintptr_t*/)PtrTraits.NumLowBitsAvailable - IntBits),
//    
//    /// IntMask - This is the unshifted mask for valid bits of the int type.
//    IntMask((long/*uintptr_t*/)(((long/*intptr_t*/)1 << IntBits) - 1)),
//    
//    // ShiftedIntMask - This is the bits for the integer shifted in place.
//    ShiftedIntMask((long/*uintptr_t*/)(Unnamed_enum.IntMask << Unnamed_enum.IntShift));
//
//    //<editor-fold defaultstate="collapsed" desc="hidden">
//    public static Unnamed_enum valueOf(int val) {
//      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
//      assert out != null : "no value for " + val;
//      return out;
//    }
//
//    private static final class Values {
//      private static final Unnamed_enum[] VALUES;
//      private static final Unnamed_enum[] _VALUES; // [0] not used
//      static {
//        int max = 0;
//        int min = 0;
//        for (Unnamed_enum kind : Unnamed_enum.values()) {
//          if (kind.value > max) { max = kind.value; }
//          if (kind.value < min) { min = kind.value; }
//        }
//        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
//        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
//        for (Unnamed_enum kind : Unnamed_enum.values()) {
//          if (kind.value < 0) {
//            _VALUES[-kind.value] = kind;
//          } else {
//            VALUES[kind.value] = kind;
//          }
//        }
//      }
//    }
//
//    private final int value;
//    private Unnamed_enum(/*uint*/int val) { this.value = (int)val;}
//    public int getValue() { return (int)value;}
//    //</editor-fold>
//  };
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 66,
   FQN = "llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>", NM = "_ZN4llvm14PointerIntPairC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>")
  //</editor-fold>
  public PointerIntPair() {
    /* : Value(0)*/ 
    this.IntVal = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 67,
   FQN = "llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>", NM = "_ZN4llvm14PointerIntPairC1ET_T1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>")
  //</editor-fold>
  public PointerIntPair(PointerTy PtrVal, int IntVal) {
    setPointerAndInt(PtrVal, IntVal);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 70,
   FQN = "llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>", NM = "_ZN4llvm14PointerIntPairC1ET_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::PointerIntPair<PointerTy, IntBits, IntType, PtrTraits>")
  //</editor-fold>
  public /*explicit*/ PointerIntPair(PointerTy PtrVal) {
    initWithPointer(PtrVal);
  }

  public PointerIntPair(PointerIntPair<PointerTy> $Prm0) {
    this.IntVal = $Prm0.IntVal;
    this.PtrVal = $tryAssign(null, $Prm0.PtrVal, isDataPointerLike());
  }

  public PointerIntPair(JD$Move _dparam, PointerIntPair<PointerTy> $Prm0) {
    this.IntVal = $Prm0.IntVal;
    this.PtrVal = $tryAssign(null, $Prm0.PtrVal, isDataPointerLike());
    $Prm0.PtrVal = null;
  }

  public PointerIntPair $assign(PointerIntPair<PointerTy> $Prm0) {
    this.IntVal = $Prm0.IntVal;
    this.PtrVal = $tryAssign(this.PtrVal, $Prm0.PtrVal, isDataPointerLike());
    return this;
  }

  public PointerIntPair $assignMove(PointerIntPair<PointerTy> $Prm0) {
    assert this != $Prm0;
    this.IntVal = $Prm0.IntVal;
    this.PtrVal = $tryMove(this.PtrVal, $Prm0.PtrVal, isDataPointerLike());
    $Prm0.PtrVal = null;
    return this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::getPointer">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 56,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 74,
   FQN = "llvm::PointerIntPair::getPointer", NM = "_ZNK4llvm14PointerIntPair10getPointerEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZNK4llvm14PointerIntPair10getPointerEv")
  //</editor-fold>
  public PointerTy getPointer() /*const*/ {
    return PtrVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::getInt">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 58,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 79,
   FQN = "llvm::PointerIntPair::getInt", NM = "_ZNK4llvm14PointerIntPair6getIntEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZNK4llvm14PointerIntPair6getIntEv")
  //</editor-fold>
  public int getInt() /*const*/ {
    return IntVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::setPointer">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 62,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 83,
   FQN = "llvm::PointerIntPair::setPointer", NM = "_ZN4llvm14PointerIntPair10setPointerET_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZN4llvm14PointerIntPair10setPointerET_")
  //</editor-fold>
  public void setPointer(PointerTy PtrVal) {
    this.PtrVal = PtrVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::setInt">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 66,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 92,
   FQN = "llvm::PointerIntPair::setInt", NM = "_ZN4llvm14PointerIntPair6setIntET1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZN4llvm14PointerIntPair6setIntET1_")
  //</editor-fold>
  public void setInt(int IntVal) {
    this.IntVal = IntVal;
  }
  public void setInt(boolean BoolVal) {
    this.IntVal = BoolVal ? 1 : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::initWithPointer">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 70,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 101,
   FQN = "llvm::PointerIntPair::initWithPointer", NM = "_ZN4llvm14PointerIntPair15initWithPointerET_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZN4llvm14PointerIntPair15initWithPointerET_")
  //</editor-fold>
  public void initWithPointer(PointerTy PtrVal) {
    this.PtrVal = PtrVal;
    this.IntVal = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::setPointerAndInt">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 109,
   FQN = "llvm::PointerIntPair::setPointerAndInt", NM = "_ZN4llvm14PointerIntPair16setPointerAndIntET_T1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZN4llvm14PointerIntPair16setPointerAndIntET_T1_")
  //</editor-fold>
  public void setPointerAndInt(PointerTy PtrVal, int IntVal) {
    this.PtrVal = $tryAssign(this.PtrVal, PtrVal, isDataPointerLike());
    this.IntVal = IntVal;    
  }

  
  ////<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::getAddrOfPointer">
//  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 116,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::getAddrOfPointer")
//  //</editor-fold>
//  public /*const*/ PointerTy /*P*/ getAddrOfPointer() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::getAddrOfPointer">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 83,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 124,
   FQN = "llvm::PointerIntPair::getAddrOfPointer", NM = "_ZN4llvm14PointerIntPair16getAddrOfPointerEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZN4llvm14PointerIntPair16getAddrOfPointerEv")
  //</editor-fold>
  public PointerTy /*P*/ getAddrOfPointer() {
    assert IntVal == 0 : "Can only return the address if IntBits is cleared and PtrTraits doesn't change the pointer";
    return PtrVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::getOpaqueValue">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 90,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 131,
   FQN = "llvm::PointerIntPair::getOpaqueValue", NM = "_ZNK4llvm14PointerIntPair14getOpaqueValueEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZNK4llvm14PointerIntPair14getOpaqueValueEv")
  //</editor-fold>
  public Object/*void P*/ getOpaqueValue() /*const*/ {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::setFromOpaqueValue">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 132,
   FQN = "llvm::PointerIntPair::setFromOpaqueValue", NM = "_ZN4llvm14PointerIntPair18setFromOpaqueValueEPv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZN4llvm14PointerIntPair18setFromOpaqueValueEPv")
  //</editor-fold>
  public void setFromOpaqueValue(Object/*void P*/ Val) {
    this.PtrVal = ((PointerIntPair<PointerTy>) Val).getPointer();
    this.IntVal = ((PointerIntPair<PointerTy>) Val).getInt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::getFromOpaqueValue">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 95,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", old_line = 134,
   FQN = "llvm::PointerIntPair::getFromOpaqueValue", NM = "_ZN4llvm14PointerIntPair18getFromOpaqueValueEPv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -nm=_ZN4llvm14PointerIntPair18getFromOpaqueValueEPv")
  //</editor-fold>
  public static <PointerTy> PointerIntPair<PointerTy> getFromOpaqueValue(Object/*void P*/ V) {
    PointerIntPair<PointerTy> P = new PointerIntPair<>(); 
    P.setFromOpaqueValue(V); 
    return P; 
  }
  public static <PointerTy> PointerIntPair<PointerTy> getFromOpaqueValue_ConstVoidPtr(Object/*void P*/ V) {
    return getFromOpaqueValue(V);
  }


//  // Allow PointerIntPairs to be created from const void * if and only if the
//  // pointer type could be created from a const void *.
//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::getFromOpaqueValue">
//  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 136,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::getFromOpaqueValue")
//  //</editor-fold>
//  public static <PointerTy> PointerIntPair<PointerTy> getFromOpaqueValue(/*const*/void$ptr/*void P*/ V) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::operator==">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 145,
   FQN = "llvm::PointerIntPair::operator==", NM = "_ZNK4llvm14PointerIntPaireqERKNS_14PointerIntPairIT_XT0_ET1_T2_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::operator==")
  //</editor-fold>
  public boolean $eq(/*const*/ PointerIntPair<PointerTy> /*&*/ RHS) /*const*/ {
    return this == RHS || (IntVal == RHS.IntVal && (isDataPointerLike() ? PtrVal == RHS.PtrVal : Native.$eq(PtrVal, RHS.PtrVal)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::operator!=">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 146,
   FQN = "llvm::PointerIntPair::operator!=", NM = "_ZNK4llvm14PointerIntPairneERKNS_14PointerIntPairIT_XT0_ET1_T2_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::operator!=")
  //</editor-fold>
  public boolean $noteq(/*const*/ PointerIntPair<PointerTy> /*&*/ RHS) /*const*/ {
    return !$eq(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 114,
   FQN = "llvm::PointerIntPair::operator<", NM = "_ZNK4llvm14PointerIntPairltERKNS_14PointerIntPairIT_XT0_ET1_T2_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::operator<")
  //</editor-fold>
  public boolean $less(/*const*/ PointerIntPair<PointerTy> /*&*/ RHS) /*const*/ {
    if (this.$eq(RHS)) return false;
    int this$hashcode = this.$hashcode();
    int RHS$hashcode = RHS.$hashcode();
    assert this$hashcode != RHS$hashcode: "not supported yet to be with equal hashcodes\n" + this + "\n vs. \n" + RHS;
    return this$hashcode < RHS$hashcode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::operator>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 115,
   FQN = "llvm::PointerIntPair::operator>", NM = "_ZNK4llvm14PointerIntPairgtERKNS_14PointerIntPairIT_XT0_ET1_T2_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::operator>")
  //</editor-fold>
  public boolean $greater(/*const*/ PointerIntPair<PointerTy> /*&*/ RHS) /*const*/ {
    if (this.$eq(RHS)) return false;
    int this$hashcode = this.$hashcode();
    int RHS$hashcode = RHS.$hashcode();
    assert this$hashcode != RHS$hashcode: "not supported yet to be with equal hashcodes\n" + this + "\n vs. \n" + RHS;
    return this$hashcode > RHS$hashcode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::operator<=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 116,
   FQN = "llvm::PointerIntPair::operator<=", NM = "_ZNK4llvm14PointerIntPairleERKNS_14PointerIntPairIT_XT0_ET1_T2_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::operator<=")
  //</editor-fold>
  public boolean $lesseq(/*const*/ PointerIntPair<PointerTy> /*&*/ RHS) /*const*/ {
    if (this.$eq(RHS)) return true;
    int this$hashcode = this.$hashcode();
    int RHS$hashcode = RHS.$hashcode();
    assert this$hashcode != RHS$hashcode: "not supported yet to be with equal hashcodes\n" + this + "\n vs. \n" + RHS;
    return this$hashcode < RHS$hashcode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerIntPair::operator>=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerIntPair.h", line = 119,
   FQN = "llvm::PointerIntPair::operator>=", NM = "_ZNK4llvm14PointerIntPairgeERKNS_14PointerIntPairIT_XT0_ET1_T2_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntervalMap.cpp -filter=llvm::PointerIntPair::operator>=")
  //</editor-fold>
  public boolean $greatereq(/*const*/ PointerIntPair<PointerTy> /*&*/ RHS) /*const*/ {
    if (this.$eq(RHS)) return true;
    int this$hashcode = this.$hashcode();
    int RHS$hashcode = RHS.$hashcode();
    assert this$hashcode != RHS$hashcode: "not supported yet to be with equal hashcodes\n" + this + "\n vs. \n" + RHS;
    return this$hashcode > RHS$hashcode;
  }
    
  private boolean isDataPointerLike() {
    return !(PtrVal instanceof void$ptr) && !(PtrVal instanceof PointerUnion);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public int $hashcode() {
  return DenseMapInfoPair.combineTwoHashes(
          (this.PtrVal instanceof NativeHashable) ? ((NativeHashable)this.PtrVal).$hashcode() : System.identityHashCode(this.PtrVal),
          this.IntVal);
  }
  
  public final void ProfilePointerIntPair(final FoldingSetNodeID /*&*/ ID) {
    ID.AddPointer(this.PtrVal);
    ID.AddInteger_int(this.IntVal);
  }

  @Override public PointerIntPair<PointerTy> clone() {
    return new PointerIntPair<PointerTy>(this);
  }
  
  @Override
  public boolean $eqPointerLike(Object other) {
    if (this == other) {
      return true;
    }
    if (this.PtrVal == other && this.IntVal == 0) {
      return true;
    }
    if (other instanceof PointerIntPair) {
      return this.IntVal == ((PointerIntPair) other).IntVal
              && Native.$eq_ptr(this.PtrVal, ((PointerIntPair) other).PtrVal);
    }
    assert !(other instanceof NativePointerLike) 
            : "Pointer like comparizon of " + getClass().getCanonicalName() + " with " + other.getClass().getCanonicalName() 
            + " is not implemented!";
    return false;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "PtrIntPair{" + IntVal + "|" + System.identityHashCode(PtrVal) + '}';
  }
}
