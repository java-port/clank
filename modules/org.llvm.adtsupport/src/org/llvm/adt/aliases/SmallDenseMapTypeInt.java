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

import org.clank.java.std;
import org.clank.support.aliases.*;
import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.clank.support.JavaDifferentiators;
import org.clank.support.Native.assignable;
import org.clank.support.NativeMoveable;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.DenseMapInfo;
import static org.llvm.support.llvm.Log2_32_Ceil;
import static org.llvm.support.llvm.NextPowerOf2;

/**
 *  Note! This is a copy of a DenseMap because optimization made in C++ makes no sense in Java.
 */
//<editor-fold defaultstate="collapsed" desc="llvm::DenseMap">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 687,
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::SmallDenseMap")
//</editor-fold>
public class SmallDenseMapTypeInt<KeyT>  extends /*public*/ DenseMapBaseTypeInt<SmallDenseMapTypeInt<KeyT>, KeyT> implements assignable<SmallDenseMapTypeInt<KeyT>>, NativeMoveable<SmallDenseMapTypeInt<KeyT>>, Iterable<std.pairTypeInt<KeyT>>, Destructors.ClassWithDestructor {
  // Lift some types from the dependent base class into this class for
  // simplicity of referring to them.
  /*typedef DenseMapBase<SmallDenseMapTypeInt<KeyT>, KeyT, ValueT, KeyInfoT> BaseT*/
  //public final class BaseT extends DenseMapBase<SmallDenseMapTypeInt<KeyT>, KeyT, ValueT, KeyInfoT>{ };
  /*typedef typename BaseT::BucketT BucketT*/
  //public final class BucketT extends  BaseT.BucketT{ };
  /*friend  class DenseMapBase<SmallDenseMapTypeInt<KeyT>, KeyT, ValueT, KeyInfoT>*/;
  private std.pairTypeInt<KeyT>[] /*P*/ Buckets;
  private /*uint*/int NumEntries;
  private /*uint*/int NumTombstones;
  private /*uint*/int NumBuckets;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::SmallDenseMapTypeInt<KeyT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 549,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::SmallDenseMapTypeInt<KeyT>")
  //</editor-fold>
  public /*explicit*/ SmallDenseMapTypeInt(DenseMapInfo<KeyT> keyInfo, int defaultValue) {
    this(keyInfo, 0, defaultValue);
  }
  public /*explicit*/ SmallDenseMapTypeInt(DenseMapInfo<KeyT> keyInfo, /*uint*/int NumInitBuckets/*= 0*/, int defaultValue) {
    super(keyInfo, defaultValue);
    init(NumInitBuckets);
  }
  public SmallDenseMapTypeInt(JavaDifferentiators.JD$Move INSTANCE, /*const*/SmallDenseMapTypeInt<KeyT> other) {
    super(other.keyInfoT, other.defaultValue);
    assert other.checkAlive();
    init(0);
    swap(other);
  }  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::SmallDenseMapTypeInt<KeyT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 553,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::SmallDenseMapTypeInt<KeyT>")
  //</editor-fold>
  public SmallDenseMapTypeInt(/*const*/SmallDenseMapTypeInt<KeyT> /*&*/ other) {
    /* : BaseT()*/ 
    //START JInit
    super(other.keyInfoT, other.defaultValue);
    assert other.checkAlive();
    //END JInit
    init(0);
    copyFrom(other);
  }

  /*template <typename InputIt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::SmallDenseMapTypeInt<KeyT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 566,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::SmallDenseMapTypeInt<KeyT>")
  //</editor-fold>
  public SmallDenseMapTypeInt(DenseMapInfo<KeyT> keyInfo, /*const*/type$iterator<?, std.pairTypeInt<KeyT>> /*&*/ I, /*const*/type$iterator<?, std.pairTypeInt<KeyT>> /*&*/ E, int defaultValue) {
    super(keyInfo, defaultValue);
    init(NextPowerOf2(std.distance(I, E)));
    this.insert(I, E);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::~SmallDenseMapTypeInt<KeyT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 571,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::~SmallDenseMapTypeInt<KeyT>")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    //super.$destroy();
    this.destroyAll();
    set$destroyed();
    //operator delete(Buckets);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::swap">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 576,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::swap")
  //</editor-fold>
  public void swap(SmallDenseMapTypeInt<KeyT> /*&*/ RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    std.pairTypeInt<KeyT>[] aBuckets = this.Buckets;
    this.Buckets = RHS.Buckets;
    RHS.Buckets = aBuckets;
    int aNumEntries = this.NumEntries;
    this.NumEntries = RHS.NumEntries;
    RHS.NumEntries = aNumEntries;
    int aNumTombstones = this.NumTombstones;
    this.NumTombstones = RHS.NumTombstones;
    RHS.NumTombstones = aNumTombstones;
    int aNumBuckets = this.NumBuckets;
    this.NumBuckets = RHS.NumBuckets;
    RHS.NumBuckets = aNumBuckets;
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 583,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::operator=")
  //</editor-fold>
  public SmallDenseMapTypeInt<KeyT> /*&*/ $assign(/*const*/SmallDenseMapTypeInt<KeyT> /*&*/ other) {
    assert other.checkAlive();
    assert checkAlive();
    copyFrom(other);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::copyFrom">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 598,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::copyFrom")
  //</editor-fold>
  public void copyFrom(/*const*/SmallDenseMapTypeInt<KeyT> /*&*/ other) {
    assert other.checkAlive();
    assert checkAlive();
    this.destroyAll();
    //operator delete(Buckets);
    if (allocateBuckets(other.NumBuckets)) {
      super.copyFrom(other);
    } else {
      NumEntries = 0;
      NumTombstones = 0;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::init">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 609,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::init")
  //</editor-fold>
  public void init(/*uint*/int InitBuckets) {
    assert checkAlive();
    if (allocateBuckets(InitBuckets)) {
      super.initEmpty();
    } else {
      NumEntries = 0;
      NumTombstones = 0;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::grow">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 618,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::grow")
  //</editor-fold>
  public void grow(/*uint*/int AtLeast) {
    assert checkAlive();
    /*uint*/int OldNumBuckets = NumBuckets;
    std.pairTypeInt<KeyT>[] /*P*/ OldBuckets = Buckets;
    
    allocateBuckets(std.max(64, (/*static_cast*//*uint*/int)(NextPowerOf2(AtLeast - 1))));
    //((Buckets) ? (/*static_cast*/void)(0) : __assert_fail("Buckets", ${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", 623, __PRETTY_FUNCTION__));
    if (OldBuckets == null) {
      super.initEmpty();
      return;
    }
    
    this.moveFromOldBuckets(OldBuckets, OldNumBuckets);
    
    // Free the old table.
    //operator delete(OldBuckets);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::shrink_and_clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 635,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::shrink_and_clear")
  //</editor-fold>
  public void shrink_and_clear() {
    assert checkAlive();
    /*uint*/int OldNumEntries = NumEntries;
    this.destroyAll();
    
    // Reduce the number of buckets.
    /*uint*/int NewNumBuckets = 0;
    if ((OldNumEntries != 0)) {
      NewNumBuckets = std.max(64, 1 << (Log2_32_Ceil(OldNumEntries) + 1));
    }
    if (NewNumBuckets == NumBuckets) {
      super.initEmpty();
      return;
    }
    
    //operator delete(Buckets);
    init(NewNumBuckets);
  }

/*private:*/
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::getNumEntries">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 653,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::getNumEntries")
  //</editor-fold>
  protected /*uint*/int getNumEntries() /*const*/ {
    assert checkAlive();
    return NumEntries;
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::setNumEntries">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 656,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::setNumEntries")
  //</editor-fold>
  protected void setNumEntries(/*uint*/int Num) {
    assert checkAlive();
    NumEntries = Num;
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::getNumTombstones">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 660,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::getNumTombstones")
  //</editor-fold>
  protected /*uint*/int getNumTombstones() /*const*/ {
    assert checkAlive();
    return NumTombstones;
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::setNumTombstones">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 663,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::setNumTombstones")
  //</editor-fold>
  protected void setNumTombstones(/*uint*/int Num) {
    assert checkAlive();
    NumTombstones = Num;
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::getBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 667,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::getBuckets")
  //</editor-fold>
  protected type$ptr<std.pairTypeInt<KeyT>> /*P*/ getBuckets() /*const*/ {
    assert checkAlive();
    return create_type$ptr(Buckets);
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::getBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 667,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::getBuckets")
  //</editor-fold>
  protected std.pairTypeInt<KeyT>[] /*P*/ $Buckets() /*const*/ {
    assert checkAlive();
    return Buckets;
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::getNumBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 671,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::getNumBuckets")
  //</editor-fold>
  protected /*uint*/int getNumBuckets() /*const*/ {
    assert checkAlive();
    return NumBuckets;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMap::allocateBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 675,
   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMap::allocateBuckets")
  //</editor-fold>
  private boolean allocateBuckets(/*uint*/int Num) {
    assert checkAlive();
    NumBuckets = (int)Num;
    if (NumBuckets == 0) {
      Buckets = ((std.pairTypeInt<KeyT>[])null);
      return false;
    }
    
    //    Buckets = (/*static_cast*/BucketT /*P*/ )(operator new(sizeof(BucketT) * NumBuckets));
    std.pairTypeInt<KeyT> bucketsArray[] = new std.pairTypeInt[(int)NumBuckets];
    for (int i = 0; i < (int)NumBuckets; i++) {
      bucketsArray[i] = new std.pairTypeInt<KeyT>();
    }
    Buckets = bucketsArray;
    
    return true;
  }

  @Override
  public String toString() {
    return "DenseMap{" + NumEntries + ", NumTombstones=" + NumTombstones + ", NumBuckets=" + NumBuckets + ", Buckets=[\n" + BucketsToString(Buckets) + "\n]}";
  }
  
  @Override
  public java.util.Iterator<std.pairTypeInt<KeyT>> iterator() {
    assert checkAlive();
    return new JavaIterator<>(super.begin(), super.end());
  }
  
  @Override public SmallDenseMapTypeInt<KeyT> move() {
    assert this.getClass() == SmallDenseMapTypeInt.class : "must be overridden in derived " + this.getClass();
    return new SmallDenseMapTypeInt<KeyT>(JavaDifferentiators.JD$Move.INSTANCE, this);
  }
}
