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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.adt.DenseMapInfo;

/*template <typename DerivedT, typename int, typename byte, typename KeyInfoT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 39,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase")
//</editor-fold>
public abstract class DenseMapBaseUIntChar<DerivedT> extends NativeTrace.CreateDestroy$Tracker implements NativeType.SizeofCapable {
  
  protected final byte defaultValue;
  
  protected final DenseMapInfoUInt keyInfoT;

  protected final int emptyKey;
  protected final int tombstoneKey;

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::DenseMapBase<DerivedT, int, byte, KeyInfoT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 248,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::DenseMapBase<DerivedT, int, byte, KeyInfoT>")
  //</editor-fold>  
  protected DenseMapBaseUIntChar(DenseMapInfoUInt keyInfo, byte defaultValue) {
    this.keyInfoT = keyInfo;
    this.defaultValue = defaultValue;
    this.emptyKey = keyInfoT.getEmptyKey();
    this.tombstoneKey = keyInfo.getTombstoneKey();
    assert true : "empty/tombstoneKey key marker must be non null " + keyInfoT;
    assert keyInfoT.getEmptyKey() == this.emptyKey : "empty key must be persistent between calls" + keyInfoT;
    assert keyInfoT.getTombstoneKey() == this.tombstoneKey : "tombstone key must be persistent between calls" + keyInfoT;
    assert (emptyKey != tombstoneKey) : "EmptyKey must be different from TombstoneKey:" + keyInfo;
    assert true;
  }
  
/*protected:*/
  /*typedef std::pair<int, byte> BucketT*/
//  public final class BucketT extends std.pairUIntChar{ };
/*public:*/
  /*typedef int key_type*/
//  public final class key_type extends int{ };
  /*typedef byte mapped_type*/
//  public final class mapped_type extends byte{ };
  /*typedef BucketT value_type*/
//  public final class value_type extends BucketT{ };
  /*typedef DenseMapIteratorUIntChar iterator*/
//  public final class iterator extends DenseMapIteratorUIntChar{ };
  /*typedef DenseMapIteratorUIntChar<int, byte, KeyInfoT, true> const_iterator*/
//  public final class const_iterator extends DenseMapIteratorUIntChar<int, byte, KeyInfoT, true>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 53,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::begin")
  //</editor-fold>
  public /*inline*/ DenseMapIteratorUIntChar begin() {
    assert checkAlive();
    // When the map is empty, avoid the overhead of AdvancePastEmptyBuckets().
    return empty() ? end() : new DenseMapIteratorUIntChar(keyInfoT, $Buckets(), 0, getNumBuckets());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 57,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::end")
  //</editor-fold>
  public /*inline*/ DenseMapIteratorUIntChar end() {
    assert checkAlive();
    return new DenseMapIteratorUIntChar(keyInfoT, $Buckets(), getNumBuckets(), getNumBuckets(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 60,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::begin")
  //</editor-fold>
  public final /*inline*/ DenseMapIteratorUIntChar begin$Const() /*const*/ {
    assert checkAlive();
    return begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 63,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::end")
  //</editor-fold>
  public final /*inline*/ DenseMapIteratorUIntChar end$Const() /*const*/ {
    assert checkAlive();
    return end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::empty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 67,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::empty")
  //</editor-fold>
  public boolean empty() /*const*//* __attribute__((warn_unused_result))*/ {
    assert checkAlive();
    return getNumEntries() == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 70,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::size")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    assert checkAlive();
    return getNumEntries();
  }

  
  /// Grow the densemap so that it has at least Size buckets. Does not shrink
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::resize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 73,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::resize")
  //</editor-fold>
  public void resize(/*size_t*/int Size) {
    assert checkAlive();
    if (Size >= getNumBuckets()) {
      grow(Size);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 78,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::clear")
  //</editor-fold>
  public void clear() {
    if (getNumEntries() == 0 && getNumTombstones() == 0) {
      assert checkAlive();
      return;
    }
    
    // If the capacity of the array is huge, and the # elements used is small,
    // shrink the array.
    if ((getNumEntries() * 4 < getNumBuckets()) && (getNumBuckets() > 64)) {
      shrink_and_clear();
      return;
    }
    
    /*const*/int EmptyKey = getEmptyKey(), TombstoneKey = getTombstoneKey();
    std.pairUIntChar[] Buckets = $Buckets();
    for (int /*P*/ P = 0, /*P*/ E = getNumBuckets(); $noteq(P, E); ++P) {
      if (Buckets[P].first != EmptyKey) {
        if (Buckets[P].first != TombstoneKey) {
          if (!isDataPointerLike()) {
            Native.destroy(Buckets[P].second);
          }
          decrementNumEntries();
        }
        Buckets[P].first = EmptyKey;
      }
    }
    //(($eq(getNumEntries(), 0) && "Node count imbalance!") ? (/*static_cast*/void)(0) : __assert_fail("getNumEntries() == 0 && \"Node count imbalance!\"", ${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", 98, __PRETTY_FUNCTION__));
    setNumTombstones(0);
  }

  
  /// count - Returns non-zero if the specified key is in the map, 0 otherwise
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 103,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::count")
  //</editor-fold>
  public int count(/*const*/int /*&*/ Val) /*const*/ {
    assert checkAlive();
    return LookupBucketFor(Val, true) == INVALID_INDEX ? 0 : 1;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 108,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::find")
  //</editor-fold>
  public DenseMapIteratorUIntChar find(/*const*/int /*&*/ Val) {
    assert checkAlive();
    int TheBucket = LookupBucketFor(Val, true);
    if (TheBucket != INVALID_INDEX) {
      return new DenseMapIteratorUIntChar(keyInfoT, $Buckets(), TheBucket, getNumBuckets(), true);
    }
    return end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 114,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::find")
  //</editor-fold>
  public final DenseMapIteratorUIntChar find$Const(/*const*/int /*&*/ Val) /*const*/ {
    assert checkAlive();
    return find(Val);
  }

  
  /// Alternate version of find() which allows a different, and possibly
  /// less expensive, key type.
  /// The DenseMapInfo is responsible for supplying methods
  /// getHashValue(Lookupint) and isEqual(Lookupint, int) for each key
  /// type used.
  /*template <class Lookupint> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::find_as">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 127,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::find_as")
  //</editor-fold>
  public </*class*/ Lookupint> DenseMapIteratorUIntChar find_as(/*const*/Lookupint /*&*/ Val) {
    assert checkAlive();
    int TheBucket = LookupBucketForAltKey(Val, true);
    if (TheBucket != INVALID_INDEX) {
      return new DenseMapIteratorUIntChar(keyInfoT, $Buckets(), TheBucket, getNumBuckets(), true);
    }
    return end();
  }

  /*template <class Lookupint> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::find_as">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 134,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::find_as")
  //</editor-fold>
  public final </*class*/ Lookupint> DenseMapIteratorUIntChar find_as$Const(/*const*/Lookupint /*&*/ AltKey) /*const*/ {
    assert checkAlive();
    return find_as(AltKey);
  }
  public final </*class*/ Lookupint> DenseMapIteratorUIntChar find_as_T$C$R(/*const*/Lookupint /*&*/ AltKey) /*const*/ {
    assert checkAlive();
    return find_as(AltKey);
  }

  
  /// lookup - Return the entry for the specified key, or a default
  /// constructed value if no such entry exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::lookup">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 143,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::lookup")
  //</editor-fold>
  public byte lookup(/*const*/int /*&*/ Val) /*const*/ {
    assert checkAlive();
    int TheBucket = LookupBucketFor(Val, true);
    if (TheBucket != INVALID_INDEX) {
      return $Buckets()[TheBucket].second;
    }
    return $tryClone(defaultValue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 153,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::insert")
  //</editor-fold>
  public final std.pairTypeBool<DenseMapIteratorUIntChar> insert_pair$KeyT$ValueT(/*const*/std.pairUIntChar /*&*/ KV) {
    assert checkAlive();
    return insert(KV);
  }
  public std.pairTypeBool<DenseMapIteratorUIntChar> insert(/*const*/std.pairUIntChar /*&*/ KV) {
    assert checkAlive();
    int TheBucket = LookupBucketFor(KV.first, false);
    assert TheBucket != INVALID_INDEX;
    if (TheBucket < 0) {
      // Otherwise, insert the new element.
      TheBucket = InsertIntoBucket(KV.first, KV.second, TheBucket & CANDIDATE_INDEX_MASK);
      return std.make_pair_T_bool(new DenseMapIteratorUIntChar(keyInfoT, $Buckets(), TheBucket, getNumBuckets(), true), true);
    }
    return std.make_pair_T_bool(new DenseMapIteratorUIntChar(keyInfoT, $Buckets(), TheBucket, getNumBuckets(), true), false); // Already in map.
  }

  /// Alternate version of insert() which allows a different, and possibly
  /// less expensive, key type.
  /// The DenseMapInfo is responsible for supplying methods
  /// getHashValueAlt(LookupKeyT) and isEqualAlt(LookupKeyT, KeyT) for each key
  /// type used.  
  public </*class*/ Lookupint> std.pairTypeBool<DenseMapIteratorUIntChar> insert_as(/*const*/std.pairUIntChar /*&*/ KV, /*const*/Lookupint /*&*/ AltKey) {
    assert checkAlive();
    int TheBucket = LookupBucketForAltKey(AltKey, false);
    assert TheBucket != INVALID_INDEX;
    if (TheBucket < 0) {
      // Otherwise, insert the new element.
      TheBucket = InsertIntoBucketAltKey(KV.first, KV.second, AltKey, TheBucket & CANDIDATE_INDEX_MASK);
      return std.make_pair_T_bool(new DenseMapIteratorUIntChar(keyInfoT, $Buckets(), TheBucket, getNumBuckets(), true), true);
    }
    return std.make_pair_T_bool(new DenseMapIteratorUIntChar(keyInfoT, $Buckets(), TheBucket, getNumBuckets(), true), false); // Already in map.
  }
  
  /// insert - Range insertion of pairs.
  /*template <typename InputIt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 184,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::insert")
  //</editor-fold>
  public void insert(type$iterator<?, std.pairUIntChar> I, type$iterator<?, std.pairUIntChar> E) {
    assert checkAlive();
    for (; $noteq_iter(I, E); I.$preInc())  {
      insert(/*Deref*/I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 190,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::erase")
  //</editor-fold>
  public boolean erase(/*const*/int /*&*/ Val) {
    assert checkAlive();
    int TheBucketIdx = LookupBucketFor(Val, true);
    if (TheBucketIdx == INVALID_INDEX) {
      return false; // not in map.
    }
    std.pairUIntChar TheBucket = $Buckets()[TheBucketIdx];
    if (!isDataPointerLike()) {
      Native.destroy(TheBucket.second);
    }
    TheBucket.first = getTombstoneKey();
    decrementNumEntries();
    incrementNumTombstones();
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 201,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::erase")
  //</editor-fold>
  public void erase(DenseMapIteratorUIntChar I) {
    assert checkAlive();
    std.pairUIntChar /*P*/ TheBucket = /*AddrOf*//*Deref*/I.$arrow();
    if (!isDataPointerLike()) {
      Native.destroy(TheBucket.second);
    }
    TheBucket.first = getTombstoneKey();
    decrementNumEntries();
    incrementNumTombstones();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::FindAndConstruct">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 209,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::FindAndConstruct")
  //</editor-fold>
  public std.pairUIntChar /*&*/ FindAndConstruct(/*const*/int /*&*/ Key) {
    assert checkAlive();
    int TheBucket = LookupBucketFor(Key, false);
    if (TheBucket < 0) {
      TheBucket = /*Deref*/InsertIntoBucket(Key, defaultValue, TheBucket & CANDIDATE_INDEX_MASK);
    }
    return /*Deref*/$Buckets()[TheBucket];
  }
  
//  public type$ref<std.pairUIntChar> /*&*/ FindAndConstruct$Ref(/*const*/int /*&*/ Key) {
//    assert checkAlive();
//    type$ref<type$ptr<std.pairUIntChar>> TheBucketRef = NativePointer.create_type$ref((type$ptr<std.pairUIntChar>)null);
//    if (LookupBucketFor(Key, TheBucketRef)) {
//      return /*Deref*/TheBucketRef.$deref().star$ref();
//    }
//    
//    return /*Deref*/InsertIntoBucket(Key, $tryClone(defaultValue), TheBucketRef.$deref()).star$ref();
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::operator[]">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 217,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::operator[]")
  //</editor-fold>
  public byte /*&*/ $at(/*const*/int /*&*/ Key) {
    assert checkAlive();
    return FindAndConstruct(Key).second;
  }

  public byte /*&*/ $at_T1$C$R(/*const*/int /*&*/ Key) {
    assert checkAlive();
    return FindAndConstruct(Key).second;
  }

  public byte /*&*/ $at_T1$RR(/*const*/int /*&&*/ Key) {
    assert checkAlive();
    return FindAndConstruct(Key).second;
  }

  public byte $set(/*const*/int /*&*/ Key, byte Val) {
    assert checkAlive();
    return FindAndConstruct(Key).second = Val;
  }

  public char$ref /*&*/ ref$at_T1$C$R(final /*const*/int /*&*/ Key) {
    return ref$at(Key);
  }
  
  public char$ref /*&*/ ref$at(final /*const*/int /*&*/ Key) {
    assert checkAlive();
    return new char$ref_IMPL(Key, this);
  }  
  
  private static class char$ref_IMPL<DerivedT> implements char$ref {

    private final DenseMapBaseUIntChar<DerivedT> map;
    private final int Key;
    private final std.pairUIntChar pair;
    
    public char$ref_IMPL(int Key, DenseMapBaseUIntChar<DerivedT> owner) {
      this.map = owner;
      this.Key = Key;
      this.pair = map.FindAndConstruct(Key);
    }

    @Override
    public byte $deref() {
      assert map.checkAlive();
      assert map.keyInfoT.isEqual(pair.first, Key);
      return pair.second;
    }

    @Override
    public byte $set(byte value) {
      assert map.checkAlive();
      assert map.keyInfoT.isEqual(pair.first, Key);
      pair.second = (map.isDataPointerLike() ? value : $tryClone(value));
      return value;
    }

    @Override
    public String toString() {
      return "$(" + Key + ")\n => [" + pair.second + "]";
    }
  }
    
  /// isPointerIntoBucketsArray - Return true if the specified pointer points
  /// somewhere into the DenseMap's array of buckets (i.e. either to a key or
  /// value in the DenseMap).
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::isPointerIntoBucketsArray">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 238,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::isPointerIntoBucketsArray")
  //</editor-fold>
  public boolean isPointerIntoBucketsArray(/*const*/Object/*void P*/ Ptr) /*const*/ {
    assert checkAlive();
    if (Ptr != null && getBuckets() != null && getBucketsEnd() != null) {
      //return Ptr.$greatereq(getBuckets()) && Ptr.$less(getBucketsEnd());
      if (Ptr instanceof char$ref_IMPL) {
        return ((char$ref_IMPL)Ptr).map == this;
      } else if (Ptr instanceof type$ptr) {
        final type$ptr Check = (type$ptr)Ptr;
        return Native.$is_array_based(Check) && Check.$array() == this.$Buckets();
      }      
    }
    return false;
  }

  
  /// getPointerIntoBucketsArray() - Return an opaque pointer into the buckets
  /// array.  In conjunction with the previous method, this can be used to
  /// determine whether an insertion caused the DenseMap to reallocate.
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getPointerIntoBucketsArray">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 245,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getPointerIntoBucketsArray")
  //</editor-fold>
  public /*const*/void$ptr/*void P*/ getPointerIntoBucketsArray() /*const*/ {
    assert checkAlive();
    return getBuckets();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::destroyAll">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 250,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::destroyAll")
  //</editor-fold>
  protected void destroyAll() {
    assert checkAlive();
    if (getNumBuckets() == 0) {
      // Nothing to do.
      return;
    }
    
    /*const*/int EmptyKey = getEmptyKey(), TombstoneKey = getTombstoneKey();
    std.pairUIntChar[] Buckets = $Buckets();
    for (int /*P*/ P = 0, /*P*/ E = getNumBuckets(); $noteq(P, E); ++P) {
      // do not destroy buckets associated with empty and tombstone keys
      if ((Buckets[P].first != EmptyKey) && (Buckets[P].first != TombstoneKey)) {
        if (!isDataPointerLike()) {
          Native.destroy(Buckets[P].second);
        }
        if (!isKeyPointerLike()) {
          Native.destroy(Buckets[P].first);
        }
      }
    }
    // Only in DEBUG mode!
    //memset((void$ptr/*void P*/ )getBuckets(), 0x5a, sizeof(BucketT) * getNumBuckets());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::initEmpty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 267,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::initEmpty")
  //</editor-fold>
  protected void initEmpty() {
    assert checkAlive();
    setNumEntries(0);
    setNumTombstones(0);
    //(($eq((getNumBuckets() & (getNumBuckets() - 1)), 0) && "# initial buckets must be a power of two!") ? (/*static_cast*/void)(0) : __assert_fail("(getNumBuckets() & (getNumBuckets()-1)) == 0 && \"# initial buckets must be a power of two!\"", ${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", 272, __PRETTY_FUNCTION__));
    /*const*/int EmptyKey = getEmptyKey();
    std.pairUIntChar[] Buckets = $Buckets();
    for (int B = 0, /*P*/ E = (int)getNumBuckets(); B != E; ++B)  {
      Buckets[B].first = EmptyKey; // do not clone here
      //new (/*AddrOf*/B.first) int(( EmptyKey ));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::moveFromOldBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 278,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::moveFromOldBuckets")
  //</editor-fold>
  protected void moveFromOldBuckets(std.pairUIntChar[] /*P*/ OldBucketsBegin, int Num) {
    assert checkAlive();
    initEmpty();
    
    // Insert all the old elements.
    /*const*/int EmptyKey = getEmptyKey();
    /*const*/int TombstoneKey = getTombstoneKey();
    final std.pairUIntChar[] Buckets = $Buckets();
    for (int B = 0, E = Num; B != Num; ++B) {
      final std.pairUIntChar oldPair = OldBucketsBegin[B];
      final int OldKey = oldPair.first;
      if ((OldKey != EmptyKey) && (OldKey != TombstoneKey)) {
        // Insert the key/value into the new table.
        int /*P*/ DestBucketIdx = LookupBucketFor(OldKey, false);
        assert DestBucketIdx != INVALID_INDEX : "Key already in new map?";
        assert DestBucketIdx < 0 : "Key " + System.identityHashCode(OldKey) + " already in new map?" + System.identityHashCode(Buckets[DestBucketIdx]) + 
              ":\nWhen Inserting Key=" + OldKey + "\nFound In Map=" + Buckets[DestBucketIdx];

        DestBucketIdx &= CANDIDATE_INDEX_MASK;
        assert DestBucketIdx >= 0;
        assert DestBucketIdx != INVALID_INDEX;
        std.pairUIntChar /*P*/ DestBucket = Buckets[DestBucketIdx];
        //(void)FoundVal; // silence warning.
        //((!FoundVal && (("Key already in new map?") != null)) ? (/*static_cast*/void)(0) : __assert_fail("!FoundVal && \"Key already in new map?\"", ${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", 291, __PRETTY_FUNCTION__));
        DestBucket.first = (OldKey);
        DestBucket.second = (oldPair.second);
        //new (/*AddrOf*/DestBucket.second) byte(( (B.second) ));
        incrementNumEntries();
        
        // Free the value.
        //B.second.~byte();
      }
      //B.first.~int();
    }
    // Debug mode only!
//    if ($noteq(OldBucketsBegin, OldBucketsEnd)) {
//      memset((void$ptr/*void P*/ )OldBucketsBegin, 0x5a, sizeof(BucketT) * (OldBucketsEnd - OldBucketsBegin));
//    }
  }

  /*template <typename OtherBaseT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::copyFrom">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 310,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::copyFrom")
  //</editor-fold>
  protected </*typename*/ OtherBaseT> void copyFrom(/*const*/DenseMapBaseUIntChar<OtherBaseT> /*&*/ other) {
    assert checkAlive();
    assert other.checkAlive();
    //(($eq(getNumBuckets(), other.getNumBuckets())) ? (/*static_cast*/void)(0) : __assert_fail("getNumBuckets() == other.getNumBuckets()", ${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", 311, __PRETTY_FUNCTION__));
    
    setNumEntries(other.getNumEntries());
    setNumTombstones(other.getNumTombstones());
    std.pairUIntChar[] ourBuckets = $Buckets();
    std.pairUIntChar[] otherBuckets = other.$Buckets();
    for (/*size_t*/int i = 0; i < getNumBuckets(); ++i) {
      // 1: assign as is
      //new (/*AddrOf*/getBuckets()[i].first) int(( other.getBuckets()[i].first ));
      ourBuckets[i].first = otherBuckets[i].first;
      if ((ourBuckets[i].first != getEmptyKey()) && (ourBuckets[i].first != getTombstoneKey())) {
        // 2: for not dummy keys clone when needed
        if (!isKeyPointerLike()) {
          ourBuckets[i].first = $tryClone(otherBuckets[i].first);
        }
        // 3: copy non-pointer data
        //new (/*AddrOf*/getBuckets()[i].second) byte(( other.getBuckets()[i].second ));
        if (isDataPointerLike()) {
          ourBuckets[i].second = otherBuckets[i].second;
        } else {
          ourBuckets[i].second = $tryClone(otherBuckets[i].second);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::swap">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 328,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::swap")
  //</editor-fold>
  protected void swap(DenseMapBaseUIntChar<DerivedT> /*&*/ RHS) {
    assert checkAlive();
    assert RHS.checkAlive();
    // std.swap(getNumEntries(), RHS.getNumEntries());
    int tmp = RHS.getNumEntries();
    RHS.setNumEntries(getNumEntries());
    setNumEntries(tmp);
    
    //std.swap(getNumTombstones(), RHS.getNumTombstones());
    tmp = RHS.getNumTombstones();
    RHS.setNumTombstones(getNumTombstones());
    setNumTombstones(tmp);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getHashValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 333,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getHashValue")
  //</editor-fold>
  protected /*uint*/int getHashValue(/*const*/int /*&*/ Val) {
    assert checkAlive();
    return keyInfoT.getHashValue(Val);
  }

  /*template <typename Lookupint> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getHashValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 337,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getHashValue")
  //</editor-fold>
  protected </*typename*/ Lookupint> /*uint*/int getHashValueAlt(/*const*/Lookupint /*&*/ Val) {
    assert checkAlive();
    return keyInfoT.getHashValueAlt(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getEmptyKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 340,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getEmptyKey")
  //</editor-fold>
  protected final /*const*/int getEmptyKey() {
    assert checkAlive();
    return emptyKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getTombstoneKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 343,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getTombstoneKey")
  //</editor-fold>
  protected final /*const*/int getTombstoneKey() {
    assert checkAlive();
    return tombstoneKey;
  }  

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getNumEntries">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 348,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getNumEntries")
  //</editor-fold>
  protected abstract /*uint*/int getNumEntries();

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::setNumEntries">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 351,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::setNumEntries")
  //</editor-fold>
  protected abstract void setNumEntries(/*uint*/int Num);

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::incrementNumEntries">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 354,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::incrementNumEntries")
  //</editor-fold>
  private void incrementNumEntries() {
    setNumEntries(getNumEntries() + 1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::decrementNumEntries">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 357,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::decrementNumEntries")
  //</editor-fold>
  private void decrementNumEntries() {
    setNumEntries(getNumEntries() - 1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getNumTombstones">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 360,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getNumTombstones")
  //</editor-fold>
  protected abstract /*uint*/int getNumTombstones();

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::setNumTombstones">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 363,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::setNumTombstones")
  //</editor-fold>
  protected abstract void setNumTombstones(/*uint*/int Num);

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::incrementNumTombstones">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 366,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::incrementNumTombstones")
  //</editor-fold>
  private void incrementNumTombstones() {
    setNumTombstones(getNumTombstones() + 1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::decrementNumTombstones">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 369,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::decrementNumTombstones")
  //</editor-fold>
  private void decrementNumTombstones() {
    setNumTombstones(getNumTombstones() - 1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 375,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getBuckets")
  //</editor-fold>
  protected abstract type$ptr<std.pairUIntChar> /*P*/ getBuckets();
  protected abstract std.pairUIntChar[] /*P*/ $Buckets();

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getNumBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 378,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getNumBuckets")
  //</editor-fold>
  protected abstract /*uint*/int getNumBuckets();

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getBucketsEnd">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 381,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getBucketsEnd")
  //</editor-fold>
  private type$ptr<std.pairUIntChar> /*P*/ getBucketsEnd() {
    return create_type$ptr($Buckets(), getNumBuckets());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::grow">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 388,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::grow")
  //</editor-fold>
  protected abstract void grow(/*uint*/int AtLeast);

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::shrink_and_clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 392,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::shrink_and_clear")
  //</editor-fold>
  protected abstract void shrink_and_clear();

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::InsertIntoBucket">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 397,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::InsertIntoBucket")
  //</editor-fold>
  private int InsertIntoBucket(/*const*/int /*&*/ Key, /*const*/byte /*&*/ Value, int TheBucketIndex) {
    TheBucketIndex = InsertIntoBucketImpl(Key, TheBucketIndex);
    final std.pairUIntChar TheBucket = $Buckets()[TheBucketIndex];

    assert Key != this.emptyKey;
    assert Key != this.tombstoneKey;
    TheBucket.first = Key;
    //    new (/*AddrOf*/TheBucket.second) byte(( Value ));
    TheBucket.second = Value;
    
    return TheBucketIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::InsertIntoBucketImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 425,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::InsertIntoBucketImpl")
  //</editor-fold>
  private int /*P*/ InsertIntoBucketImpl(/*const*/int /*&*/ Key, int TheBucket) {
    // If the load of the hash table is more than 3/4, or if fewer than 1/8 of
    // the buckets are empty (meaning that many are filled with tombstones),
    // grow the table.
    //
    // The later case is tricky.  For example, if we had one empty bucket with
    // tons of tombstones, failing lookups (e.g. for insertion) would have to
    // probe almost the entire table until it found the empty bucket.  If the
    // table completely filled with tombstones, no lookup would ever succeed,
    // causing infinite loops in lookup.
    /*uint*/int NewNumEntries = getNumEntries() + 1;
    /*uint*/int NumBuckets = getNumBuckets();
    if (NewNumEntries * 4 >= NumBuckets * 3) {
      this.grow(NumBuckets * 2);
      TheBucket = LookupBucketFor(Key, false) & CANDIDATE_INDEX_MASK;
      NumBuckets = getNumBuckets();
    } else if ($lesseq(NumBuckets - (NewNumEntries + getNumTombstones()), NumBuckets / 8)) {
      this.grow(NumBuckets);
      TheBucket = LookupBucketFor(Key, false) & CANDIDATE_INDEX_MASK;
    }
    assert TheBucket != INVALID_INDEX;
    // Only update the state after we've grown our bucket space appropriately
    // so that when growing buckets we have self-consistent entry count.
    incrementNumEntries();
    
    // If we are writing over a tombstone, remember this.
    /*const*/int EmptyKey = getEmptyKey();    
    if ($Buckets()[TheBucket].first != EmptyKey) {
      decrementNumTombstones();
    }
    
    return TheBucket;
  }
  
  private </*typename*/ Lookupint> int InsertIntoBucketAltKey(/*const*/int /*&*/ Key, /*const*/byte /*&*/ Value, 
                                        /*const*/Lookupint /*&*/ AltKey, int TheBucketIndex) {
    TheBucketIndex = InsertIntoBucketAltKeyImpl(AltKey, TheBucketIndex);
    final std.pairUIntChar TheBucket = $Buckets()[TheBucketIndex];

    assert Key != this.emptyKey;
    assert Key != this.tombstoneKey;
    TheBucket.first = Key;
    //    new (/*AddrOf*/TheBucket.second) byte(( Value ));
    TheBucket.second = Value;
    
    return TheBucketIndex;
  }
  
  private </*typename*/ Lookupint> int /*P*/ InsertIntoBucketAltKeyImpl(/*const*/Lookupint /*&*/ AltKey, int TheBucket) {
    // If the load of the hash table is more than 3/4, or if fewer than 1/8 of
    // the buckets are empty (meaning that many are filled with tombstones),
    // grow the table.
    //
    // The later case is tricky.  For example, if we had one empty bucket with
    // tons of tombstones, failing lookups (e.g. for insertion) would have to
    // probe almost the entire table until it found the empty bucket.  If the
    // table completely filled with tombstones, no lookup would ever succeed,
    // causing infinite loops in lookup.
    /*uint*/int NewNumEntries = getNumEntries() + 1;
    /*uint*/int NumBuckets = getNumBuckets();
    if (NewNumEntries * 4 >= NumBuckets * 3) {
      this.grow(NumBuckets * 2);
      TheBucket = LookupBucketForAltKey(AltKey, false) & CANDIDATE_INDEX_MASK;
      NumBuckets = getNumBuckets();
    } else if ($lesseq(NumBuckets - (NewNumEntries + getNumTombstones()), NumBuckets / 8)) {
      this.grow(NumBuckets);
      TheBucket = LookupBucketForAltKey(AltKey, false) & CANDIDATE_INDEX_MASK;
    }
    assert TheBucket != INVALID_INDEX;
    // Only update the state after we've grown our bucket space appropriately
    // so that when growing buckets we have self-consistent entry count.
    incrementNumEntries();
    
    // If we are writing over a tombstone, remember this.
    /*const*/int EmptyKey = getEmptyKey();    
    if ($Buckets()[TheBucket].first != EmptyKey) {
      decrementNumTombstones();
    }
    
    return TheBucket;
  }

  static final int INVALID_INDEX = Integer.MAX_VALUE;
  private static final int CANDIDATE_INDEX_MASK = 0x7fffffff;
  private static final int CANDIDATE_INDEX_FLAG = 0x80000000;
  
  /// Java version:
  /// returns INVALID_INDEX if can not find bucket for Key in this map,
  ///         positive Bucket index if found existing Key in Map
  ///         negative Bucket index if found bucket appropriate for inserting Key (only if onlyExisting is false)
  ///
  /// LookupBucketFor - Lookup the appropriate bucket for Val, returning it in
  /// FoundBucket.  If the bucket contains the key and a value, this returns
  /// true, otherwise it returns a bucket with an empty marker or tombstone and
  /// returns false.
  /*template <typename Lookupint> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::LookupBucketFor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 464,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::LookupBucketFor")
  //</editor-fold>
  private int LookupBucketFor(/*const*/int /*&*/ Key, boolean onlyExisting) /*const*/ {
    /*const*//*uint*/int NumBuckets = (int) getNumBuckets();
    if (NumBuckets == 0) {
      if (onlyExisting) {
        return INVALID_INDEX;
      } else {
        return 0 | CANDIDATE_INDEX_FLAG;
      }
    }
    /*const*/std.pairUIntChar[] /*P*/ Buckets = $Buckets();
    
    // FoundTombstone - Keep track of whether we find a tombstone while probing.
    /*const*/int /*P*/ FoundTombstone = INVALID_INDEX;
    /*const*/int EmptyKey = getEmptyKey();
    /*const*/int TombstoneKey = getTombstoneKey();
    assert Key != EmptyKey : "Empty/Tombstone value shouldn't be inserted into map!";
    assert Key != TombstoneKey : "Empty/Tombstone value shouldn't be inserted into map!";
    
    /*uint*/int BucketNo = (int)(getHashValue(Key) & (NumBuckets - 1));
    /*uint*/int ProbeAmt = 1;
    while (true) {
      /*const*/std.pairUIntChar /*P*/ ThisBucket = Buckets[BucketNo];
      // Found Key's bucket?  If so, return it.
      
      // If we found an empty bucket, the key doesn't exist in the set.
      // Insert it and return the default value.
      if (ThisBucket.first == EmptyKey) {
        // If we've already seen a tombstone while probing, fill it in instead
        // of the empty bucket we eventually probed to.
        if (onlyExisting) {
          // In Java we distinguish search for existing and insert candidate
          return INVALID_INDEX;
        } else {
          int Bucket = FoundTombstone != INVALID_INDEX ? FoundTombstone : BucketNo;
          assert Bucket >= 0 && Bucket != Integer.MAX_VALUE;
          return Bucket | CANDIDATE_INDEX_FLAG;
        }
      }
      
      // If this is a tombstone, remember it.  If Val ends up not in the map, we
      // prefer to return it than something that would require more probing.
      if (ThisBucket.first == TombstoneKey) {
        if (FoundTombstone == INVALID_INDEX) {
          FoundTombstone = BucketNo; // Remember the first tombstone found.
        }
      } else {
        // Found Key's bucket?  If so, return it.
        if (keyInfoT.isEqual(Key, ThisBucket.first)) {
          return BucketNo;
        }
      }
      
      // Otherwise, it's a hash collision or a tombstone, continue quadratic
      // probing.
      BucketNo += ProbeAmt++;
      BucketNo &= (NumBuckets - 1);
    }
  }

  /* semantic as method LookupBucketFor, but allows different key type to be passed */
  private </*typename*/ Lookupint> int LookupBucketForAltKey(/*const*/Lookupint /*&*/ AltKey, boolean onlyExisting) /*const*/ {
    /*const*//*uint*/int NumBuckets = (int) getNumBuckets();
    if (NumBuckets == 0) {
      if (onlyExisting) {
        return INVALID_INDEX;
      } else {
        return 0 | CANDIDATE_INDEX_FLAG;
      }
    }
    /*const*/std.pairUIntChar[] /*P*/ Buckets = $Buckets();
    
    // FoundTombstone - Keep track of whether we find a tombstone while probing.
    /*const*/int /*P*/ FoundTombstone = INVALID_INDEX;
    /*const*/int EmptyKey = getEmptyKey();
    /*const*/int TombstoneKey = getTombstoneKey();
//    assert AltKey != EmptyKey : "Empty/Tombstone value shouldn't be inserted into map!";
//    assert AltKey != TombstoneKey : "Empty/Tombstone value shouldn't be inserted into map!";
    
    /*uint*/int BucketNo = (int)(getHashValueAlt(AltKey) & (NumBuckets - 1));
    /*uint*/int ProbeAmt = 1;
    while (true) {
      /*const*/std.pairUIntChar /*P*/ ThisBucket = Buckets[BucketNo];
      
      // If we found an empty bucket, the key doesn't exist in the set.
      // Insert it and return the default value.
      if (ThisBucket.first == EmptyKey) {
        // If we've already seen a tombstone while probing, fill it in instead
        // of the empty bucket we eventually probed to.
        if (onlyExisting) {
          // In Java we distinguish search for existing and insert candidate
          return INVALID_INDEX;
        } else {
          int Bucket = FoundTombstone != INVALID_INDEX ? FoundTombstone : BucketNo;
          assert Bucket >= 0 && Bucket != Integer.MAX_VALUE;
          return Bucket | CANDIDATE_INDEX_FLAG;
        }
      }
      
      // If this is a tombstone, remember it.  If Val ends up not in the map, we
      // prefer to return it than something that would require more probing.
      if (ThisBucket.first == TombstoneKey) {
        if (FoundTombstone == INVALID_INDEX) {
          FoundTombstone = BucketNo; // Remember the first tombstone found.
        }
      } else {
        // Found Key's bucket?  If so, return it.
        if (keyInfoT.isEqualAlt(AltKey, ThisBucket.first)) {
          return BucketNo;
        }
      }
      
      // Otherwise, it's a hash collision or a tombstone, continue quadratic
      // probing.
      BucketNo += ProbeAmt++;
      BucketNo &= (NumBuckets - 1);
    }
  }

//  /*template <typename Lookupint> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::LookupBucketFor">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 514,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::LookupBucketFor")
//  //</editor-fold>
//  private </*typename*/ Lookupint> boolean LookupBucketFor(/*const*/Lookupint /*&*/ Val, type$ref<type$ptr<std.pairUIntChar>> /*P*/ /*&*/ FoundBucket) {
//    /*const*/BucketT /*P*/ ConstFoundBucket;
//    boolean Result = (/*const_cast*//*const*/DenseMapBase<DerivedT, int, byte, KeyInfoT> /*P*/ )(this).LookupBucketFor(Val, ConstFoundBucket);
//    FoundBucket = (/*const_cast*/BucketT /*P*/ )(ConstFoundBucket);
//    return Result;
//  }

/*public:*/
  /// Return the approximate size (in bytes) of the actual map.
  /// This is just the raw memory used by DenseMap.
  /// If entries are pointers to objects, the size of the referenced objects
  /// are not included.
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapBase::getMemorySize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 527,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -filter=llvm::DenseMapBase::getMemorySize")
  //</editor-fold>
  public /*size_t*/int getMemorySize() /*const*/ {
    assert checkAlive();
    return getNumBuckets() * sizeof(type$ptr.class);
  }

  @Override public /*size_t*/int $sizeof() {
    assert checkAlive();
    return getMemorySize();
  }

  protected final boolean isDataPointerLike() {
    return false;
  }

  protected final boolean isKeyPointerLike() {
    return this.keyInfoT.isKeyPointerLike();
  }
  
  protected String BucketsToString(std.pairUIntChar[] Buckets) {
    String destroyed = (is$destroyed() ? "DESTROYED":"");
    if (Buckets == null) {
      return destroyed + "<null>";
    }
    int idx = 0;
    StringBuilder out = new StringBuilder(destroyed);
    for (std.pairUIntChar Bucket : Buckets) {
      if (Bucket.first != this.getTombstoneKey() && Bucket.first != this.getEmptyKey()) {
        BucketToString(out, idx, Bucket, isKeyPointerLike(), isDataPointerLike());
      }
    }
    return out.toString();
  }  
  
  protected static void BucketToString(StringBuilder out, int idx, std.pairUIntChar Bucket, boolean isKeyPointerLike, boolean isDataPointerLike) {
    out.append("\n[").append(NativeTrace.formatNumber(idx++, 2)).append("]");
    out.append("{").append(isKeyPointerLike ? NativeTrace.getIdentityStr(Bucket.first) : ("" + Bucket.first));
    out.append("}=>{").append(isDataPointerLike ? NativeTrace.getIdentityStr(Bucket.second) : ("" + Bucket.second));
    out.append("}");
  }
  
  protected final boolean checkAlive() {
    return check$Alive();
  }  
}
