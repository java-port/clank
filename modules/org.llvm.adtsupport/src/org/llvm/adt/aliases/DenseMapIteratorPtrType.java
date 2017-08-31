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

package org.llvm.adt.aliases;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$FAKE;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.DenseMapInfo;

/*template <typename KeyT, typename ValueT, typename KeyInfoT = DenseMapInfo<KeyT>, bool IsConst = false> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 985,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType")
//</editor-fold>
public class DenseMapIteratorPtrType<KeyT, ValueT>  implements type$iterator<DenseMapIteratorPtrType<KeyT, ValueT>, std.pairPtrType<KeyT, ValueT>> {
  /*typedef std::std.pairPtrType<KeyT, ValueT> Bucket*/
//  public final class Bucket extends std.pairPtrType<KeyT, ValueT>{ };
  /*typedef DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, true> ConstIterator*/
//  public final class ConstIterator extends DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, true>{ };
  /*friend  class DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, true>*/;
/*public:*/
  /*typedef ptrdiff_t difference_type*/;
  /*typedef typename conditional<IsConst, const Bucket, Bucket>::type value_type*/
//  public final class value_type extends  conditional<IsConst, /*const*/Bucket, Bucket>.type{ };
  /*typedef value_type *pointer*/
//  public final class pointer extends value_type /*P*/ { };
  /*typedef value_type &reference*/
//  public final class reference extends value_type /*&*/ { };
  /*typedef std::forward_iterator_tag iterator_category*/
//  public final class iterator_category extends std.forward_iterator_tag{ };
/*private:*/
  private final DenseMapInfo<KeyT> keyInfoT;
  private std.pairPtrType<KeyT, ValueT>[] Buckets;
  private int Ptr;
  private int End;
  private static final int INVALID_INDEX = DenseMap.INVALID_INDEX;
  
  public DenseMapIteratorPtrType() {
    /* : Ptr(0), End(0)*/ 
    //START JInit
    this.keyInfoT = null;
    this.Ptr = INVALID_INDEX;
    this.End = INVALID_INDEX;
    this.Buckets = null;
    //END JInit
  }
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, IsConst>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1001,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, IsConst>")
  //</editor-fold>
  public DenseMapIteratorPtrType(DenseMapInfo<KeyT> keyInfoT) {
    /* : Ptr(0), End(0)*/ 
    //START JInit
    this.keyInfoT = keyInfoT;
    this.Ptr = INVALID_INDEX;
    this.End = INVALID_INDEX;
    this.Buckets = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, IsConst>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1003,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, IsConst>")
  //</editor-fold>
  public DenseMapIteratorPtrType(DenseMapInfo<KeyT> keyInfoT, std.pairPtrType<KeyT, ValueT>[] Buckets, int Pos, int E) {
    this(keyInfoT, Buckets, Pos, E, false);
  }
  public DenseMapIteratorPtrType(DenseMapInfo<KeyT> keyInfoT, std.pairPtrType<KeyT, ValueT>[] Buckets, int Pos, int E, boolean NoAdvance/*= false*/) {
    /* : Ptr(Pos), End(E)*/ 
    //START JInit
    this.keyInfoT = keyInfoT;
    this.Ptr = Pos;
    this.End = E;
    //END JInit
    this.Buckets = Buckets;
    if (!NoAdvance) {
      AdvancePastEmptyBuckets();
    }    
  }

  public DenseMapIteratorPtrType<KeyT, ValueT> $assignMove(DenseMapIteratorPtrType<KeyT, ValueT> other) {
    this.End = other.End;
    this.Buckets = other.Buckets;
    this.Ptr = other.Ptr;
    return this;
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, IsConst>">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1003,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, IsConst>")
//  //</editor-fold>
//  public DenseMapIteratorPtrType(DenseMapInfo<KeyT> keyInfoT, type$ptr<std.pairPtrType<KeyT, ValueT>> Pos, type$ptr<std.pairPtrType<KeyT, ValueT>> E) {
//    this(keyInfoT, Pos, E, false);
//  }
//  public DenseMapIteratorPtrType(DenseMapInfo<KeyT> keyInfoT, type$ptr<std.pairPtrType<KeyT, ValueT>> Pos, type$ptr<std.pairPtrType<KeyT, ValueT>> E, boolean NoAdvance/*= false*/) {
//    /* : Ptr(Pos), End(E)*/ 
//    //START JInit
//    assert (Pos == null && E == null) || (Pos.$array() == E.$array());
//    this.keyInfoT = keyInfoT;
//    this.Ptr = Pos != null ? Pos.$index() : INVALID_INDEX;
//    this.End = E != null ? E.$index() : INVALID_INDEX;
//    //END JInit
//    this.Buckets = Pos == null ? null : Pos.$array();
//    if (!NoAdvance) {
//      AdvancePastEmptyBuckets();
//    }
//  }

  
  // If IsConst is true this is a converting constructor from iterator to
  // const_iterator and the default copy constructor is used.
  // Otherwise this is a copy constructor for iterator.
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, IsConst>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1011,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::DenseMapIteratorPtrType<KeyT, ValueT, KeyInfoT, IsConst>")
  //</editor-fold>
  public DenseMapIteratorPtrType(/*const*/DenseMapIteratorPtrType<KeyT, ValueT> /*&*/ I) {
    /* : Ptr(I.Ptr), End(I.End)*/ 
    //START JInit
    this.keyInfoT = I.keyInfoT;
    this.Ptr = I.Ptr;
    this.End = I.End;
    this.Buckets = I.Buckets;
    //END JInit
  }

  public DenseMapIteratorPtrType(JavaDifferentiators.JD$Move INSTANCE, /*const*/DenseMapIteratorPtrType<KeyT, ValueT> $Prm0) {
    this.keyInfoT = $Prm0.keyInfoT;
    this.End = $Prm0.End;
    this.Buckets = $Prm0.Buckets;
    this.Ptr = $Prm0.Ptr;
    $Prm0.End = INVALID_INDEX;
    $Prm0.Ptr = INVALID_INDEX;
    $Prm0.Buckets = null;
  }
  
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1015,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::operator*")
  //</editor-fold>
  public std.pairPtrType<KeyT, ValueT> $star() /*const*/ {
    return /*Deref*/Buckets[Ptr];
  }

  @Override
  public type$ref<std.pairPtrType<KeyT, ValueT>> star$ref() {
    return new type$ref<std.pairPtrType<KeyT, ValueT>>() {
        
        int localPtr = Ptr;

        @Override
        public std.pairPtrType<KeyT, ValueT> $deref() {
            return Buckets[localPtr];
        }

        @Override
        public std.pairPtrType<KeyT, ValueT> $set(std.pairPtrType<KeyT, ValueT> value) {
            return Buckets[localPtr] = value;
        }

        @Override
        public type$ptr<std.pairPtrType<KeyT, ValueT>> deref$ptr() {
            return create_type$ptr(Buckets, localPtr);
        }
    };
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1018,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::operator->")
  //</editor-fold>
  public std.pairPtrType<KeyT, ValueT> $arrow() /*const*/ {
    return $star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1022,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::operator==")
  //</editor-fold>
  public boolean $eq(/*const*/DenseMapIteratorPtrType<KeyT, ValueT> /*&*/ RHS) /*const*/ {
    assert Buckets == RHS.Buckets;
    return Ptr == RHS.Ptr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1025,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::operator!=")
  //</editor-fold>
  public boolean $noteq(/*const*/DenseMapIteratorPtrType<KeyT, ValueT> /*&*/ RHS) /*const*/ {
    assert Buckets == RHS.Buckets;
    return Ptr != RHS.Ptr;
  }

  // Preincrement
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::operator++">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1029,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::operator++")
  //</editor-fold>
  public /*inline*/ DenseMapIteratorPtrType<KeyT, ValueT> /*&*/ $preInc() {
    ++Ptr;
    AdvancePastEmptyBuckets();
    return /*Deref*/this;
  }

  // Postincrement
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::operator++">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1034,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::operator++")
  //</editor-fold>
  public DenseMapIteratorPtrType<KeyT, ValueT> $postInc() {
    DenseMapIteratorPtrType<KeyT, ValueT> tmp = /*Deref*/new DenseMapIteratorPtrType(keyInfoT, Buckets, Ptr, End, true);
    $preInc();
    return tmp;
  }
  public final DenseMapIteratorPtrType<KeyT, ValueT> $postInc(int I) {
    assert I == 0 : "" + I;
    return $postInc();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapIteratorPtrType::AdvancePastEmptyBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1039,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapIteratorPtrType::AdvancePastEmptyBuckets")
  //</editor-fold>
  private void AdvancePastEmptyBuckets() {
    /*const*/Object Empty = keyInfoT.getEmptyKey();
    /*const*/Object Tombstone = keyInfoT.getTombstoneKey();
    while ((Ptr != End) && ((Buckets[Ptr].first == Empty) || (Buckets[Ptr].first == Tombstone))) {
      ++Ptr;
    }
  }
  
  @Override
  public int $sub(DenseMapIteratorPtrType<KeyT, ValueT> iter) {
    return std.distance(iter, this, JD$FAKE.TRAILING);
  }
  
  @Override
  public DenseMapIteratorPtrType<KeyT, ValueT> clone() {
    return new DenseMapIteratorPtrType(keyInfoT, Buckets, Ptr, End, true);
  }

  @Override
  public DenseMapIteratorPtrType<KeyT, ValueT> const_clone() {
    // TODO: pass constness
    return new DenseMapIteratorPtrType(keyInfoT, Buckets, Ptr, End, true);
  }

  @Override
  public boolean $eq(Object other) {
    if (other instanceof DenseMapIteratorPtrType) {
      return Native.$eq(Ptr, ((DenseMapIteratorPtrType) other).Ptr);
    }
    return false;
  }

  @Override
  public boolean $noteq(Object other) {
    if (other instanceof DenseMapIteratorPtrType) {
      return Native.$noteq(Ptr, ((DenseMapIteratorPtrType) other).Ptr);
    }
    return true;
  }

  @Override
  public String toString() {
    String msg = NativeTrace.getIdentityStr(this.keyInfoT);
    if (Ptr == End) {
      msg = "<" + (Ptr == INVALID_INDEX ? "INVALID:" : "END:") + msg + ">";
    } else {
      StringBuilder out = new StringBuilder(msg);
      DenseMap.BucketToString(out, Ptr, Buckets[Ptr], keyInfoT.isKeyPointerLike(), false);
      msg = out.toString();
    }
    return msg;
  }  
}
