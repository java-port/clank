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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativeMemory.*;
import static org.clank.support.Native.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;

/*template <typename boolean, typename Allocator = MallocAllocator> TEMPLATE*/

/// StringMapBool - This is an unconventional map that is specialized for handling
/// keys that are "strings", which are basically ranges of bytes. This does some
/// funky memory allocation and hashing things to make it extremely efficient,
/// storing the string data *after* the value in the map.
//<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 235,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool")
//</editor-fold>
public class StringMapBool  extends /*public*/ StringMapImpl 
            implements Destructors.ClassWithDestructor, Iterable<StringMapEntryBool>, NativeCloneable<StringMapBool> {
  private Allocator Allocator;
  private final boolean defaultValue;
  private final boolean isDataPointerLike;

/*public:*/
  /*typedef StringMapEntryBool MapEntryTy*/
//  public final class MapEntryTy extends StringMapEntryBool{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::StringMapBool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 241,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::StringMapBool")
  //</editor-fold>
  public StringMapBool(boolean defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(StringMapEntryBool.$sizeof_StringMapEntryBool());
    this.defaultValue = defaultValue;
    this.isDataPointerLike = false;
    assert true;
    //END JInit
    this.Allocator = (Allocator)new StringMapBumpPtrAllocator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::StringMapBool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 242,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::StringMapBool")
  //</editor-fold>
  public /*explicit*/ StringMapBool(/*uint*/int InitialSize, boolean defaultValue) {
    /* : StringMapImpl(InitialSize, static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(InitialSize, StringMapEntryBool.$sizeof_StringMapEntryBool());
    this.defaultValue = defaultValue;
    this.isDataPointerLike = false;
    assert true;
    //END JInit
    this.Allocator = (Allocator)new StringMapBumpPtrAllocator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::StringMapBool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 245,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::StringMapBool")
  //</editor-fold>
  public /*explicit*/ StringMapBool(Allocator A, boolean defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy))), Allocator(A)*/ 
    //START JInit
    super(StringMapEntryBool.$sizeof_StringMapEntryBool());
    assert A != null;
    this.Allocator = A;
    this.defaultValue = defaultValue;
    //END JInit
    this.isDataPointerLike = false;
    assert true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::StringMapBool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 248,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::StringMapBool")
  //</editor-fold>
  public StringMapBool(/*uint*/int InitialSize, Allocator A, boolean defaultValue) {
    /* : StringMapImpl(InitialSize, static_cast<unsigned int>(sizeof(MapEntryTy))), Allocator(A)*/ 
    //START JInit
    super(InitialSize, StringMapEntryBool.$sizeof_StringMapEntryBool());
    assert A != null;
    this.Allocator = A;
    this.defaultValue = defaultValue;
    //END JInit
    this.isDataPointerLike = false;
    assert true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::StringMapBool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 252,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::StringMapBool")
  //</editor-fold>
  public StringMapBool(/*const*/StringMapBool /*&*/ RHS, boolean defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(StringMapEntryBool.$sizeof_StringMapEntryBool());
    assert RHS.checkAlive();
    this.defaultValue = defaultValue;
    this.isDataPointerLike = false;
    assert true;
    if (!RHS.empty()) {
      throw new AssertionError("Copy ctor from non-empty stringmap not implemented yet!");
    }
    //END JInit
    this.Allocator = (Allocator)new StringMapBumpPtrAllocator();
//    ((RHS.empty() && "Copy ctor from non-empty stringmap not implemented yet!") ? (/*static_cast*/void)(0) : __assert_fail("RHS.empty() && \"Copy ctor from non-empty stringmap not implemented yet!\"", ${LLVM_SRC}/llvm/include/llvm/ADT/StringMapBool.h", 255, __PRETTY_FUNCTION__));
//    (void)RHS;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMap::StringMap<ValueTy, AllocatorTy>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 229,
   FQN="llvm::StringMap::StringMap<ValueTy, AllocatorTy>", NM="_ZN4llvm9StringMapC1EONS_9StringMapIT_T0_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm9StringMapC1EONS_9StringMapIT_T0_EE")
  //</editor-fold>
  public StringMapBool(JD$Move _dparam, StringMapBool /*&&*/RHS) {
    /* : StringMapImpl(std::move(RHS)), Allocator(std::move(RHS.Allocator))*/ 
    super(std.move(RHS));
    assert RHS.checkAlive();
    this.Allocator = RHS.Allocator;
    this.defaultValue = RHS.defaultValue;
    this.isDataPointerLike = false;
    assert true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMap::operator=">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 232,
   FQN="llvm::StringMap::operator=", NM="_ZN4llvm9StringMapaSENS_9StringMapIT_T0_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm9StringMapaSENS_9StringMapIT_T0_EE")
  //</editor-fold>
  public StringMapBool /*&*/ $assign(StringMapBool RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    super.swap(RHS);
    assert(RHS.isDataPointerLike == this.isDataPointerLike) : RHS.isDataPointerLike + " vs. " + this.isDataPointerLike;
    //std.swap(Allocator, RHS.Allocator);
    Allocator tmp = this.Allocator;
    this.Allocator = RHS.Allocator;
    RHS.Allocator = tmp;
    return /*Deref*/this;
  }

  /*typedef typename ReferenceAdder<Allocator>::result AllocatorRefTy*/
//  public final class AllocatorRefTy extends  ReferenceAdder<Allocator>.result{ };
  /*typedef typename ReferenceAdder<const Allocator>::result AllocatorCRefTy*/
//  public final class AllocatorCRefTy extends  ReferenceAdder</*const*/Allocator>.result{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::getAllocator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 267,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::getAllocator")
  //</editor-fold>
  public Allocator getAllocator() {
    assert checkAlive();
    return Allocator;
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::getAllocator">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 268,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::getAllocator")
//  //</editor-fold>
//  public AllocatorCRefTy getAllocator() /*const*/ {
//    return Allocator;
//  }

  /*typedef const char *key_type*/;
  /*typedef boolean mapped_type*/
//  public final class mapped_type extends boolean{ };
  /*typedef StringMapEntryBool value_type*/
//  public final class value_type extends StringMapEntryBool{ };
  /*typedef size_t size_type*/;
  /*typedef StringMapConstIterator<boolean> const_iterator*/
//  public final class const_iterator extends StringMapConstIterator<boolean>{ };
  /*typedef StringMapIteratorBool iterator*/
//  public final class iterator extends StringMapIteratorBool{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 278,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::begin")
  //</editor-fold>
  public StringMapIteratorBool begin() {
    assert checkAlive();
    return new StringMapIteratorBool(TheTable, 0, NumBuckets == 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 281,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::end")
  //</editor-fold>
  public StringMapIteratorBool end() {
    assert checkAlive();
    return new StringMapIteratorBool(TheTable, NumBuckets, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 284,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::begin")
  //</editor-fold>
  public StringMapIteratorBool begin$Const() /*const*/ {
    assert checkAlive();
    return begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 287,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::end")
  //</editor-fold>
  public StringMapIteratorBool end$Const() /*const*/ {
    assert checkAlive();
    return end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 291,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::find")
  //</editor-fold>
  public StringMapIteratorBool find(StringRef Key) {
    assert checkAlive();
    int Bucket = FindKey(Key);
    if (Bucket == INVALID_INDEX) {
      return end();
    }
    return new StringMapIteratorBool(TheTable, Bucket, true);
  }
  public StringMapIteratorBool find(String Key) {
    assert checkAlive();
    return find(new StringRef(Key));
  }
  public StringMapIteratorBool find(char$ptr Key) {
    assert checkAlive();
    int Bucket = FindKey(Key, strlen(Key));
    if (Bucket == INVALID_INDEX) {
      return end();
    }
    return new StringMapIteratorBool(TheTable, Bucket, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 297,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::find")
  //</editor-fold>
  public StringMapIteratorBool find$Const(StringRef Key) /*const*/ {
    assert checkAlive();
    return find(Key);
  }

  
  /// lookup - Return the entry for the specified key, or a default
  /// constructed value if no such entry exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::lookup">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 305,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::lookup")
  //</editor-fold>
  public boolean lookup(StringRef Key) /*const*/ {
    assert checkAlive();
    return lookup(Key.data(), Key.size());
  }
  public boolean lookup(char$ptr Key, int KeyLen) /*const*/ {
    assert checkAlive();
    int Bucket = FindKey(Key, KeyLen);  
    if (Bucket != INVALID_INDEX) {
      return ((StringMapEntryBool)TheTable[Bucket]).getValue();
    }
    return $tryClone(defaultValue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMap::operator[]">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 285,
   FQN="llvm::StringMap::operator[]", NM="_ZN4llvm9StringMapixENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm9StringMapixENS_9StringRefE")
  //</editor-fold>
  public boolean /*&*/ $at(String Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue();
  }
  public boolean /*&*/ $at(StringRef Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue();
  }
  public boolean /*&*/ $at(char$ptr Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue();
  }
  public bool$ref /*&*/ ref$at(String Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue$Ref();
  }
  public bool$ref /*&*/ ref$at(StringRef Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue$Ref();
  }  
  public bool$ref /*&*/ ref$at(char$ptr Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue$Ref();
  }

  public boolean $set(StringRef/*&*/ Key, boolean Val) {
    assert checkAlive();
    return (GetOrCreateValue(Key, false).second = Val);
  }
  public boolean $set(String/*&*/ Key, boolean Val) {
    assert checkAlive();
    return (GetOrCreateValue(Key, false).second = Val);
  }
  public boolean $set(char$ptr Key, boolean Val) {
    assert checkAlive();
    return (GetOrCreateValue(Key, strlen(Key), false).second = Val);
  }

  /// count - Return 1 if the element is in the map, 0 otherwise.  
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 316,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::count")
  //</editor-fold>
  public /*size_t*/int count(StringRef Key) /*const*/ {
    assert checkAlive();
    return FindKey(Key) == INVALID_INDEX ? 0 : 1;
  }

  /// insert - Inserts the specified key/value pair into the map if the key
  /// isn't already in the map. The bool component of the returned pair is true
  /// if and only if the insertion takes place, and the iterator component of
  /// the pair points to the element with key equivalent to the key of the pair.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMap::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 317,
   FQN="llvm::StringMap::insert", NM="_ZN4llvm9StringMap6insertESt4pairINS_9StringRefET_E",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm9StringMap6insertESt4pairINS_9StringRefET_E")
  //</editor-fold>
  public std.pairTypeBool<StringMapIteratorBool> insert(std.pairTypeBool<StringRef> KV) {
    assert checkAlive();
    char$ptr keyData = KV.first.data();
    int keyLength = KV.first.size();
    /*uint*/int FullHashValue = HashString(keyData, keyLength);
    /*uint*/int BucketNo = LookupBucketFor(keyData, keyLength, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return std.make_pair_T_bool(new StringMapIteratorBool(TheTable, BucketNo, false), 
          false); // Already exists in map.
    }
    if (Bucket == getTombstoneVal()) {
      --NumTombstones;
    }
    Bucket
       = StringMapEntryBool.Create(keyData, keyLength, FullHashValue, Allocator, std.move(KV.second));
    TheTable[BucketNo] = Bucket;
    ++NumItems;
    assert (NumItems + NumTombstones <= NumBuckets);

    BucketNo = RehashTable(BucketNo);
    return std.make_pair_T_bool(new StringMapIteratorBool(TheTable, BucketNo, false), true);
  }
  
  /// Emplace a new element for the specified key into the map if the key isn't
  /// already in the map. The bool component of the returned pair is true
  /// if and only if the insertion takes place, and the iterator component of
  /// the pair points to the element with key equivalent to the key of the pair.
  public std.pairTypeBool<StringMapIteratorBool> emplace_second(StringRef Key, boolean ValueToMove) {
    assert checkAlive();
    char$ptr keyData = Key.data();
    int keyLength = Key.size();
    /*uint*/int FullHashValue = HashString(keyData, keyLength);
    /*uint*/int BucketNo = LookupBucketFor(keyData, keyLength, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return std.make_pair_T_bool(new StringMapIteratorBool(TheTable, BucketNo, false), 
          false); // Already exists in map.
    }
    if (Bucket == getTombstoneVal()) {
      --NumTombstones;
    }
    Bucket
       = StringMapEntryBool.Create(keyData, keyLength, FullHashValue, Allocator, $tryMove(std.move(ValueToMove)));
    TheTable[BucketNo] = Bucket;
    ++NumItems;
    assert (NumItems + NumTombstones <= NumBuckets);

    BucketNo = RehashTable(BucketNo);
    return std.make_pair_T_bool(new StringMapIteratorBool(TheTable, BucketNo, false), true);
  }
    
  /// insert - Insert the specified key/value pair into the map.  If the key
  /// already exists in the map, return false and ignore the request, otherwise
  /// insert it and return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 323,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::insert")
  //</editor-fold>
  public boolean insert(StringMapEntryBool/*P*/ KeyValue) {
    assert checkAlive();
    char$ptr keyData = KeyValue.getKeyData();
    int keyLength = KeyValue.getKeyLength();
    /*uint*/int FullHashValue = HashString(keyData, keyLength);
    /*uint*/int BucketNo = LookupBucketFor(keyData, keyLength, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return false; // Already exists in map.
    }
    if (Bucket == getTombstoneVal()) {
      --NumTombstones;
    }
    Bucket = KeyValue;
    TheTable[BucketNo] = Bucket;
    ++NumItems;
    assert NumItems + NumTombstones <= NumBuckets;
    
    RehashTable();
    return true;
  }


  // clear - Empties out the StringMapBool
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 340,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::clear")
  //</editor-fold>
  public void clear() {
    assert checkAlive();
    if (empty()) {
      return;
    }
    
    // Zap all values, resetting the keys back to non-present (not tombstone),
    // which is safe because we're removing all elements.
    for (/*uint*/int I = 0, E = NumBuckets; I != E; ++I) {
      StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[I];
      if (false) {
        if ((Bucket != null) && Bucket != getTombstoneVal()) {
          ((/*static_cast*/StringMapEntryBool/*P*/ )Bucket).Destroy(Allocator);
        }
      }
      TheTable[I] = null;
    }
    
    NumItems = 0;
    NumTombstones = 0;
    Allocator.Reset();
  }

  
  /// GetOrCreateValue - Look up the specified key in the table.  If a value
  /// exists, return it.  Otherwise, default construct a value, insert it, and
  /// return.
  /*template <typename InitTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::GetOrCreateValue">
  @Converted(kind = Converted.Kind.DEPRECATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 361,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::GetOrCreateValue")
  //</editor-fold>
  public StringMapEntryBool/*&*/ GetOrCreateValue(StringRef Key, boolean Val) {
    assert checkAlive();
    return GetOrCreateValue(Key.data(), Key.size(), Val);
  }
  public StringMapEntryBool/*&*/ GetOrCreateValue(String Key, boolean Val) {
    assert checkAlive();
    return GetOrCreateValue(new StringRef(Key), Val);
  } 
  public StringMapEntryBool/*&*/ GetOrCreateValue(char$ptr Key, int Len, boolean Val) {
    assert checkAlive();
    /*uint*/int FullHashValue = HashString(Key, Len);
    /*uint*/int BucketNo = LookupBucketFor(Key, Len, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return /*Deref*/(StringMapEntryBool/*P*/ )(Bucket);
    }
    
    if (Val == defaultValue) {
        Val = $tryClone(Val);
    }
    StringMapEntryBool/*P*/ NewItem =  StringMapEntryBool.Create(Key, Len, FullHashValue, Allocator, Val);
    if (Bucket == getTombstoneVal()) {
      --NumTombstones;
    }
    ++NumItems;
    assert NumItems + NumTombstones <= NumBuckets;
    
    // Fill in the bucket for the hash table.  The FullHashValue was already
    // filled in by LookupBucketFor.
    Bucket = NewItem;
    TheTable[BucketNo] = Bucket;
    
    RehashTable();
    return /*Deref*/(StringMapEntryBool) Bucket;
  }
  private StringMapEntryBool/*&*/ GetOrCreateValue(byte[] Key, int KeyStIndex, int Len, boolean Val) {
    /*uint*/int FullHashValue = HashString(Key, KeyStIndex, Len);
    /*uint*/int BucketNo = LookupBucketFor(Key, KeyStIndex, Len, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return /*Deref*/(StringMapEntryBool/*P*/ )(Bucket);
    }
    
    if (Val == defaultValue) {
        Val = $tryClone(Val);
    }
    StringMapEntryBool/*P*/ NewItem =  StringMapEntryBool.Create(Key, KeyStIndex, Len, FullHashValue, Allocator, Val);
    if (Bucket == getTombstoneVal()) {
      --NumTombstones;
    }
    ++NumItems;
    assert NumItems + NumTombstones <= NumBuckets;
    
    // Fill in the bucket for the hash table.  The FullHashValue was already
    // filled in by LookupBucketFor.
    Bucket = NewItem;
    TheTable[BucketNo] = Bucket;
    
    RehashTable();
    return /*Deref*/(StringMapEntryBool) Bucket;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::GetOrCreateValue">
  @Converted(kind = Converted.Kind.DEPRECATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 383,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::GetOrCreateValue")
  //</editor-fold>
  public StringMapEntryBool/*&*/ GetOrCreateValue(StringRef Key) {
    assert checkAlive();
    return GetOrCreateValue(Key, defaultValue);
  }
  public StringMapEntryBool/*&*/ GetOrCreateValue(String Key) {
    assert checkAlive();
    return GetOrCreateValue(new StringRef(Key), defaultValue);
  }
  public StringMapEntryBool/*&*/ GetOrCreateValue(char$ptr Key) {
    assert checkAlive();
    return GetOrCreateValue(Key, strlen(Key), defaultValue);
  }
  public StringMapEntryBool/*&*/ GetOrCreateValue(char$ptr Key, int Len) {
    assert checkAlive();
    return GetOrCreateValue(Key, Len, defaultValue);
  }

  public StringMapEntryBool/*&*/ GetOrCreateValue(byte[] Key, int KeyStIndex, int Len) {
    assert checkAlive();
    return GetOrCreateValue(Key, KeyStIndex, Len, defaultValue);
  }
  
  /// remove - Remove the specified key/value pair from the map, but do not
  /// erase it.  This aborts if the key is not in the map.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::remove">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 389,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::remove")
  //</editor-fold>
  public void remove(StringMapEntryBool/*P*/ KeyValue) {
    assert checkAlive();
    RemoveKey(KeyValue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 393,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::erase")
  //</editor-fold>
  public void erase(StringMapIteratorBool I) {
    assert checkAlive();
    StringMapEntryBool/*&*/ V = /*Deref*/I.$star();
    remove(/*AddrOf*/V);
    V.Destroy(Allocator);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 399,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::erase")
  //</editor-fold>
  public boolean erase(StringRef Key) {
    assert checkAlive();
    StringMapIteratorBool I = find(Key);
    if ($eq_iter(I, end())) {
      return false;
    }
    erase(I);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapBool::~StringMapBool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 406,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringMapBool::~StringMapBool")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    clear();
    free(TheTable);
    Destructors.$destroy(Allocator);    
    super.set$destroyed();
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder(super.is$destroyed()?"DESTROYED\n":"");
    for (StringMapIteratorBool B = begin(), E = end(); B.$noteq(E); B.$preInc()) {
      out.append("{").append(B.$star().first()).append("=>").append(B.$star().getValue()).append("}\n");
    }
    return out.toString();
  }
  
  @Override
  public Iterator<StringMapEntryBool> iterator() {
    assert checkAlive();
    return new JavaIterator(begin(), end());
  }  
  
  @Override
  public StringMapBool clone() {
    assert checkAlive();
    StringMapBool out = new StringMapBool(this, this.defaultValue);
    assert this.getClass() == out.getClass() : "clone must be overridden in " + this.getClass();
    return out;
  }  
}
