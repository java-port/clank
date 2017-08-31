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
import static org.clank.support.Native.*;
import org.llvm.adt.*;


/// \brief Store a vector of values using a specific number of bits for each
/// value. Both signed and unsigned types can be used, e.g
/// @code
///   PackedVector<signed, 2> vec;
/// @endcode
/// will create a vector accepting values -2, -1, 0, 1. Any other value will hit
/// an assertion.
/*template <typename T, unsigned int BitNum, typename BitVectorTy = BitVector> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PackedVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 74,
 FQN="llvm::PackedVector", NM="_ZN4llvm12PackedVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVectorE")
//</editor-fold>
public class PackedVector implements Native.NativeComparable<PackedVector>, NativePOD<PackedVector> {
  
  // PackedVectorBase<T, BitNum, std.numeric_limits<T>.is_signed>
  private final PackedVectorBase base;
  
  private final /*uint*/int BitNum;
  
  private BitVectorTy Bits;

  public void $destroy() {
  }

  /*typedef PackedVectorBase<T, BitNum, BitVectorTy, std::numeric_limits<T>::is_signed> base*/
//  public final class base extends PackedVectorBase<T, BitNum, BitVectorTy, std.numeric_limits<T>.is_signed>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::reference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 82,
   FQN="llvm::PackedVector::reference", NM="_ZN4llvm12PackedVector9referenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector9referenceE")
  //</editor-fold>
  public static class reference<T> {
    private PackedVector /*&*/ Vec;
    private /*const*//*uint*/int Idx;
    
    // Undefined
    //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::reference::reference">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 86,
     FQN="llvm::PackedVector::reference::reference", NM="_ZN4llvm12PackedVector9referenceC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector9referenceC1Ev")
    //</editor-fold>
    private reference() {
      throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::reference::reference">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 88,
     FQN="llvm::PackedVector::reference::reference", NM="_ZN4llvm12PackedVector9referenceC1ERNS_12PackedVectorIT_XT0_ET1_EEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector9referenceC1ERNS_12PackedVectorIT_XT0_ET1_EEj")
    //</editor-fold>
    public reference(PackedVector /*&*/ vec, /*uint*/int idx) {
      // : Vec(vec), Idx(idx) 
      //START JInit
      this./*&*/Vec=/*&*//*ParenListExpr*/vec;
      this.Idx = idx;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::reference::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 90,
     FQN="llvm::PackedVector::reference::operator=", NM="_ZN4llvm12PackedVector9referenceaSET_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector9referenceaSET_")
    //</editor-fold>
    public reference<T> /*&*/ $assign(int val) {
      Vec.base.setValue(Vec.Bits, Idx, val);
      return Native.$star(this);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::reference::operator type-parameter-0-0">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 94,
     FQN="llvm::PackedVector::reference::operator type-parameter-0-0", NM="_ZNK4llvm12PackedVector9referencecvT_Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK4llvm12PackedVector9referencecvT_Ev")
    //</editor-fold>
    public int $T() /*const*/ {
      return Vec.base.getValue(Vec.Bits, Idx);
    }

    
    @Override public String toString() {
      return "" + "Vec=" + Vec // NOI18N
                + ", Idx=" + Idx; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::PackedVector<T, BitNum, BitVectorTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 99,
   FQN="llvm::PackedVector::PackedVector<T, BitNum, BitVectorTy>", NM="_ZN4llvm12PackedVectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVectorC1Ev")
  //</editor-fold>
  public PackedVector(/*uint*/int BitNum, boolean is_signed, BitVectorTy Bits)/* = default*/ {
    this.base = is_signed ? new PackedVectorBaseTTTrue(BitNum) : new PackedVectorBaseTTFalse(BitNum);
    this.BitNum = BitNum;
    this.Bits = Bits;
    Bits.resize(0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::PackedVector<T, BitNum, BitVectorTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 100,
   FQN="llvm::PackedVector::PackedVector<T, BitNum, BitVectorTy>", NM="_ZN4llvm12PackedVectorC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVectorC1Ej")
  //</editor-fold>
  public /*explicit*/ PackedVector(/*uint*/int BitNum, boolean is_signed, BitVectorTy Bits, /*uint*/int size) {
    // : Bits(size << (BitNum - 1)) 
    //START JInit
    this.base = is_signed ? new PackedVectorBaseTTTrue(BitNum) : new PackedVectorBaseTTFalse(BitNum);
    this.BitNum = BitNum;
    this.Bits = Bits;
    Bits.resize(size << (BitNum - 1));
    //END JInit
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public PackedVector $assign(PackedVector other) {
    assert base.$eq(other.base);
    assert BitNum == other.BitNum;
    assert this.Bits.getClass() == other.Bits.getClass();
    this.Bits.$assign(other.Bits);
    return this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 102,
   FQN="llvm::PackedVector::empty", NM="_ZNK4llvm12PackedVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK4llvm12PackedVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Bits.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 104,
   FQN="llvm::PackedVector::size", NM="_ZNK4llvm12PackedVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK4llvm12PackedVector4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Bits.size() >>> (BitNum - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 106,
   FQN="llvm::PackedVector::clear", NM="_ZN4llvm12PackedVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector5clearEv")
  //</editor-fold>
  public void clear() {
    Bits.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::resize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 108,
   FQN="llvm::PackedVector::resize", NM="_ZN4llvm12PackedVector6resizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector6resizeEj")
  //</editor-fold>
  public void resize(/*uint*/int N) {
    Bits.resize(N << (BitNum - 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::reserve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 110,
   FQN="llvm::PackedVector::reserve", NM="_ZN4llvm12PackedVector7reserveEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector7reserveEj")
  //</editor-fold>
  public void reserve(/*uint*/int N) {
    Bits.reserve(N << (BitNum - 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 112,
   FQN="llvm::PackedVector::reset", NM="_ZN4llvm12PackedVector5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector5resetEv")
  //</editor-fold>
  public PackedVector /*&*/ reset() {
    Bits.reset();
    return Native.$star(this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::push_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 117,
   FQN="llvm::PackedVector::push_back", NM="_ZN4llvm12PackedVector9push_backET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVector9push_backET_")
  //</editor-fold>
  public void push_back(int val) {
    resize(size() + 1);
    Native.$star(this).$at(size() - 1).$assign(val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 122,
   FQN="llvm::PackedVector::operator[]", NM="_ZN4llvm12PackedVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVectorixEj")
  //</editor-fold>
  public reference $at(/*uint*/int Idx) {
    return new reference(Native.$star(this), Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 126,
   FQN="llvm::PackedVector::operator[]", NM="_ZNK4llvm12PackedVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK4llvm12PackedVectorixEj")
  //</editor-fold>
  public int $at$Const(/*uint*/int Idx) /*const*/ {
    return base.getValue(Bits, Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 130,
   FQN="llvm::PackedVector::operator==", NM="_ZNK4llvm12PackedVectoreqERKNS_12PackedVectorIT_XT0_ET1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK4llvm12PackedVectoreqERKNS_12PackedVectorIT_XT0_ET1_EE")
  //</editor-fold>
  public boolean $eq(/*const*/ PackedVector /*&*/ RHS) /*const*/ {
    return Native.$eq(Bits, RHS.Bits);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 134,
   FQN="llvm::PackedVector::operator!=", NM="_ZNK4llvm12PackedVectorneERKNS_12PackedVectorIT_XT0_ET1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK4llvm12PackedVectorneERKNS_12PackedVectorIT_XT0_ET1_EE")
  //</editor-fold>
  public boolean $noteq(/*const*/ PackedVector /*&*/ RHS) /*const*/ {
    return Native.$noteq(Bits, RHS.Bits);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVector::operator|=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 138,
   FQN="llvm::PackedVector::operator|=", NM="_ZN4llvm12PackedVectoroRERKNS_12PackedVectorIT_XT0_ET1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm12PackedVectoroRERKNS_12PackedVectorIT_XT0_ET1_EE")
  //</editor-fold>
  public PackedVector /*&*/ $orassign(/*const*/ PackedVector /*&*/ RHS) {
    Bits.$orassign(RHS.Bits);
    return Native.$star(this);
  }

  public PackedVector() {
    this.base = null;
    this.BitNum = 0;
  }
  

  private PackedVector(PackedVector $Prm0) {
    this.base = $tryClone($Prm0.base);
    this.BitNum = $Prm0.BitNum;
    this.Bits = $tryClone($Prm0.Bits);
  }
  
  @Override public PackedVector clone() { return new PackedVector(this); }
  
  @Override public String toString() {
    return "" + "Bits=" + Bits // NOI18N
              + super.toString(); // NOI18N
  }
}
