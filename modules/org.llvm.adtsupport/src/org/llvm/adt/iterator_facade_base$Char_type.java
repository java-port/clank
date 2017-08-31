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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;


/// \brief CRTP base class which implements the entire standard iterator facade
/// in terms of a minimal subset of the interface.
///
/// Use this when it is reasonable to implement most of the iterator
/// functionality in terms of a core subset. If you need special behavior or
/// there are performance implications for this, you may want to override the
/// relevant members instead.
///
/// Note, one abstraction that this does *not* provide is implementing
/// subtraction in terms of addition by negating the difference. Negation isn't
/// always information preserving, and I can see very reasonable iterator
/// designs where this doesn't work well. It doesn't really force much added
/// boilerplate anyways.
///
/// Another abstraction that this doesn't provide is implementing increment in
/// terms of addition of one. These aren't equivalent for all iterator
/// categories, and respecting that adds a lot of complexity for little gain.
/*template <typename DerivedT, typename IteratorCategoryT, typename T, typename DifferenceTypeT = std::ptrdiff_t, typename PointerT = T *, typename ReferenceT = T &> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base">
@Converted(kind = Converted.Kind.DUMMY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 35,
 FQN="llvm::iterator_facade_base", NM="_ZN4llvm20iterator_facade_baseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm20iterator_facade_baseE")
//</editor-fold>
public abstract class iterator_facade_base$Char_type</*typename*/ DerivedT extends iterator_facade_base$Char_type, /*typename*/ IteratorCategoryT>
        implements /*public*/ std.iterator<IteratorCategoryT, Character/*, DifferenceTypeT, PointerT, ReferenceT*/>, 
        char$iterator/*<we skip T here to override "ReferenceT $star"/"PointerT $arrow" with different types>*/ {
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY)
  protected /*explicit*/ iterator_facade_base$Char_type() {
  }
  
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY)
  protected /*explicit*/ iterator_facade_base$Char_type(JD$Move _dparam, DerivedT /*&&*/u) {
  }
  
  @Override
  public char$ref star$ref() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override public abstract byte $star();

  @Override public byte $arrow() {
    return $star();
  }

  @Override
  public abstract DerivedT clone();

  @Override
  public abstract boolean $eq(Object other);
///*protected:*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::(anonymous)">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 42,
//   FQN="llvm::iterator_facade_base::(anonymous)", NM="_ZN4llvm20iterator_facade_baseE_Unnamed_enum",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm20iterator_facade_baseE_Unnamed_enum")
//  //</editor-fold>
//  protected enum Unnamed_enum implements Native.ComparableLower {
//    IsRandomAccess(std.is_base_of<std.random_access_iterator_tag, IteratorCategoryT>.value),
//    IsBidirectional(std.is_base_of<std.bidirectional_iterator_tag, IteratorCategoryT>.value);
//
//    //<editor-fold defaultstate="collapsed" desc="hidden">
//    public static Unnamed_enum valueOf(/*<dependent type>*/void val) {
//      Unnamed_enum out = valueOf((int)val);
//      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
//      return out;
//    }
//    public static Unnamed_enum valueOf(int val) {
//      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
//      assert out != null : "no value for " + val;
//      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
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
//    private final /*<dependent type>*/void value;
//    private Unnamed_enum(int val) { this.value = (/*<dependent type>*/void)val;}
//    public /*<dependent type>*/void getValue() { return value;}
//    @Override public boolean $less(Object obj) { return Unsigned.$less_/*<dependent type>*/void(value, ((Unnamed_enum)obj).value);}
//    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_/*<dependent type>*/void(value, ((Unnamed_enum)obj).value);}
//    //</editor-fold>
//  };
///*public:*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator+">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 50,
//   FQN="llvm::iterator_facade_base::operator+", NM="_ZNK4llvm20iterator_facade_baseplET2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm20iterator_facade_baseplET2_")
//  //</editor-fold>
//  public DerivedT $add(DifferenceTypeT n) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 58,
//   FQN="llvm::operator+", NM="_ZN4llvmplET2_RKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvmplET2_RKT_")
//  //</editor-fold>
//  public static DerivedT $add_T(DifferenceTypeT n, /*const*/ DerivedT /*&*/ i) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator-">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 64,
//   FQN="llvm::iterator_facade_base::operator-", NM="_ZNK4llvm20iterator_facade_basemiET2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm20iterator_facade_basemiET2_")
//  //</editor-fold>
//  public DerivedT $sub(DifferenceTypeT n) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator++">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 73,
//   FQN="llvm::iterator_facade_base::operator++", NM="_ZN4llvm20iterator_facade_baseppEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm20iterator_facade_baseppEv")
//  //</editor-fold>
//  public DerivedT /*&*/ $preInc() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator++">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 76,
//   FQN="llvm::iterator_facade_base::operator++", NM="_ZN4llvm20iterator_facade_baseppEi",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm20iterator_facade_baseppEi")
//  //</editor-fold>
//  public DerivedT $postInc(int $Prm0) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator--">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 81,
//   FQN="llvm::iterator_facade_base::operator--", NM="_ZN4llvm20iterator_facade_basemmEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm20iterator_facade_basemmEv")
//  //</editor-fold>
//  public DerivedT /*&*/ $preDec() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator--">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 87,
//   FQN="llvm::iterator_facade_base::operator--", NM="_ZN4llvm20iterator_facade_basemmEi",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm20iterator_facade_basemmEi")
//  //</editor-fold>
//  public DerivedT $postDec(int $Prm0) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator!=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 96,
//   FQN="llvm::iterator_facade_base::operator!=", NM="_ZNK4llvm20iterator_facade_baseneERKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm20iterator_facade_baseneERKT_")
//  //</editor-fold>
//  public boolean $noteq(/*const*/ DerivedT /*&*/ RHS) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator>">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 100,
//   FQN="llvm::iterator_facade_base::operator>", NM="_ZNK4llvm20iterator_facade_basegtERKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm20iterator_facade_basegtERKT_")
//  //</editor-fold>
//  public boolean $greater(/*const*/ DerivedT /*&*/ RHS) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator<=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 107,
//   FQN="llvm::iterator_facade_base::operator<=", NM="_ZNK4llvm20iterator_facade_baseleERKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm20iterator_facade_baseleERKT_")
//  //</editor-fold>
//  public boolean $lesseq(/*const*/ DerivedT /*&*/ RHS) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator>=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 113,
//   FQN="llvm::iterator_facade_base::operator>=", NM="_ZNK4llvm20iterator_facade_basegeERKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm20iterator_facade_basegeERKT_")
//  //</editor-fold>
//  public boolean $greatereq(/*const*/ DerivedT /*&*/ RHS) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator->">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 120,
//   FQN="llvm::iterator_facade_base::operator->", NM="_ZNK4llvm20iterator_facade_baseptEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm20iterator_facade_baseptEv")
//  //</editor-fold>
//  public PointerT $arrow() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_facade_base::operator[]">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 123,
//   FQN="llvm::iterator_facade_base::operator[]", NM="_ZNK4llvm20iterator_facade_baseixET2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm20iterator_facade_baseixET2_")
//  //</editor-fold>
//  public ReferenceT $at(DifferenceTypeT n) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  public String toString() {
//    return "" + super.toString(); // NOI18N
//  }
}
