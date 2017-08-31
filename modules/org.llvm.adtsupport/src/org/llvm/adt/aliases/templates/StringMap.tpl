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

/*template <typename ${VALUE_TYPE}, typename ${ALLOCATOR_TYPE} = MallocAllocator> TEMPLATE*/

/// ${FILE_NAME} - This is an unconventional map that is specialized for handling
/// keys that are "strings", which are basically ranges of bytes. This does some
/// funky memory allocation and hashing things to make it extremely efficient,
/// storing the string data *after* the value in the map.
//<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 235,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}")
//</editor-fold>
public class ${FILE_NAME}${CLASS_SUFFIX}  extends /*public*/ StringMapImpl 
            implements Destructors.ClassWithDestructor, Iterable<${ENTRY}>, NativeCloneable<${FILE_NAME}${CLASS_SUFFIX}> {
  private ${ALLOCATOR_TYPE} Allocator;
  private final ${VALUE_TYPE} defaultValue;
  private final boolean isDataPointerLike;

/*public:*/
  /*typedef ${ENTRY} MapEntryTy*/
//  public final class MapEntryTy extends ${ENTRY}{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${CLASS_NAME}">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 241,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${CLASS_NAME}")
  //</editor-fold>
  public ${FILE_NAME}(${VALUE_TYPE} defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(${ENTRY_CLASS}.$sizeof_${ENTRY_CLASS}());
    this.defaultValue = defaultValue;
    this.isDataPointerLike = ${IS_DATA_POINTER_LIKE};
    assert ${ASSERT_DEFAULT_VALUE};
    //END JInit
    this.Allocator = (${ALLOCATOR_TYPE})new StringMapBumpPtrAllocator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${CLASS_NAME}">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 242,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${CLASS_NAME}")
  //</editor-fold>
  public /*explicit*/ ${FILE_NAME}(/*uint*/int InitialSize, ${VALUE_TYPE} defaultValue) {
    /* : StringMapImpl(InitialSize, static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(InitialSize, ${ENTRY_CLASS}.$sizeof_${ENTRY_CLASS}());
    this.defaultValue = defaultValue;
    this.isDataPointerLike = ${IS_DATA_POINTER_LIKE};
    assert ${ASSERT_DEFAULT_VALUE};
    //END JInit
    this.Allocator = (${ALLOCATOR_TYPE})new StringMapBumpPtrAllocator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${CLASS_NAME}">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 245,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${CLASS_NAME}")
  //</editor-fold>
  public /*explicit*/ ${FILE_NAME}(${ALLOCATOR_TYPE} A, ${VALUE_TYPE} defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy))), Allocator(A)*/ 
    //START JInit
    super(${ENTRY_CLASS}.$sizeof_${ENTRY_CLASS}());
    assert A != null;
    this.Allocator = A;
    this.defaultValue = defaultValue;
    //END JInit
    this.isDataPointerLike = ${IS_DATA_POINTER_LIKE};
    assert ${ASSERT_DEFAULT_VALUE};
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${CLASS_NAME}">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 248,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${CLASS_NAME}")
  //</editor-fold>
  public ${FILE_NAME}(/*uint*/int InitialSize, ${ALLOCATOR_TYPE} A, ${VALUE_TYPE} defaultValue) {
    /* : StringMapImpl(InitialSize, static_cast<unsigned int>(sizeof(MapEntryTy))), Allocator(A)*/ 
    //START JInit
    super(InitialSize, ${ENTRY_CLASS}.$sizeof_${ENTRY_CLASS}());
    assert A != null;
    this.Allocator = A;
    this.defaultValue = defaultValue;
    //END JInit
    this.isDataPointerLike = ${IS_DATA_POINTER_LIKE};
    assert ${ASSERT_DEFAULT_VALUE};
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${CLASS_NAME}">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 252,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${CLASS_NAME}")
  //</editor-fold>
  public ${FILE_NAME}(/*const*/${CLASS_NAME} /*&*/ RHS, ${VALUE_TYPE} defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(${ENTRY_CLASS}.$sizeof_${ENTRY_CLASS}());
    assert RHS.checkAlive();
    this.defaultValue = defaultValue;
    this.isDataPointerLike = ${IS_DATA_POINTER_LIKE};
    assert ${ASSERT_DEFAULT_VALUE};
    if (!RHS.empty()) {
      throw new AssertionError("Copy ctor from non-empty stringmap not implemented yet!");
    }
    //END JInit
    this.Allocator = (${ALLOCATOR_TYPE})new StringMapBumpPtrAllocator();
//    ((RHS.empty() && "Copy ctor from non-empty stringmap not implemented yet!") ? (/*static_cast*/void)(0) : __assert_fail("RHS.empty() && \"Copy ctor from non-empty stringmap not implemented yet!\"", ${LLVM_SRC}/llvm/include/llvm/ADT/${FILE_NAME}.h", 255, __PRETTY_FUNCTION__));
//    (void)RHS;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMap::StringMap<ValueTy, AllocatorTy>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 229,
   FQN="llvm::StringMap::StringMap<ValueTy, AllocatorTy>", NM="_ZN4llvm9StringMapC1EONS_9StringMapIT_T0_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm9StringMapC1EONS_9StringMapIT_T0_EE")
  //</editor-fold>
  public ${FILE_NAME}(JD$Move _dparam, ${CLASS_NAME} /*&&*/RHS) {
    /* : StringMapImpl(std::move(RHS)), Allocator(std::move(RHS.Allocator))*/ 
    super(std.move(RHS));
    assert RHS.checkAlive();
    this.Allocator = RHS.Allocator;
    this.defaultValue = RHS.defaultValue;
    this.isDataPointerLike = ${IS_DATA_POINTER_LIKE};
    assert ${ASSERT_DEFAULT_VALUE};
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMap::operator=">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 232,
   FQN="llvm::StringMap::operator=", NM="_ZN4llvm9StringMapaSENS_9StringMapIT_T0_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm9StringMapaSENS_9StringMapIT_T0_EE")
  //</editor-fold>
  public ${CLASS_NAME} /*&*/ $assign(${CLASS_NAME} RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    super.swap(RHS);
    assert(RHS.isDataPointerLike == this.isDataPointerLike) : RHS.isDataPointerLike + " vs. " + this.isDataPointerLike;
    //std.swap(Allocator, RHS.Allocator);
    ${ALLOCATOR_TYPE} tmp = this.Allocator;
    this.Allocator = RHS.Allocator;
    RHS.Allocator = tmp;
    return /*Deref*/this;
  }

  /*typedef typename ReferenceAdder<${ALLOCATOR_TYPE}>::result AllocatorRefTy*/
//  public final class AllocatorRefTy extends  ReferenceAdder<${ALLOCATOR_TYPE}>.result{ };
  /*typedef typename ReferenceAdder<const ${ALLOCATOR_TYPE}>::result AllocatorCRefTy*/
//  public final class AllocatorCRefTy extends  ReferenceAdder</*const*/${ALLOCATOR_TYPE}>.result{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::getAllocator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 267,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::getAllocator")
  //</editor-fold>
  public ${ALLOCATOR_TYPE} getAllocator() {
    assert checkAlive();
    return Allocator;
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::getAllocator">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 268,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::getAllocator")
//  //</editor-fold>
//  public AllocatorCRefTy getAllocator() /*const*/ {
//    return Allocator;
//  }

  /*typedef const char *key_type*/;
  /*typedef ${VALUE_TYPE} mapped_type*/
//  public final class mapped_type extends ${VALUE_TYPE}{ };
  /*typedef ${ENTRY} value_type*/
//  public final class value_type extends ${ENTRY}{ };
  /*typedef size_t size_type*/;
  /*typedef StringMapConstIterator<${VALUE_TYPE}> const_iterator*/
//  public final class const_iterator extends StringMapConstIterator<${VALUE_TYPE}>{ };
  /*typedef ${ITERATOR} iterator*/
//  public final class iterator extends ${ITERATOR}{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 278,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::begin")
  //</editor-fold>
  public ${ITERATOR} begin() {
    assert checkAlive();
    return new ${ITERATOR}(TheTable, 0, NumBuckets == 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 281,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::end")
  //</editor-fold>
  public ${ITERATOR} end() {
    assert checkAlive();
    return new ${ITERATOR}(TheTable, NumBuckets, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 284,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::begin")
  //</editor-fold>
  public ${ITERATOR} begin$Const() /*const*/ {
    assert checkAlive();
    return begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 287,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::end")
  //</editor-fold>
  public ${ITERATOR} end$Const() /*const*/ {
    assert checkAlive();
    return end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 291,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::find")
  //</editor-fold>
  public ${ITERATOR} find(StringRef Key) {
    assert checkAlive();
    int Bucket = FindKey(Key);
    if (Bucket == INVALID_INDEX) {
      return end();
    }
    return new ${ITERATOR}(TheTable, Bucket, true);
  }
  public ${ITERATOR} find(String Key) {
    assert checkAlive();
    return find(new StringRef(Key));
  }
  public ${ITERATOR} find(char$ptr Key) {
    assert checkAlive();
    int Bucket = FindKey(Key, strlen(Key));
    if (Bucket == INVALID_INDEX) {
      return end();
    }
    return new ${ITERATOR}(TheTable, Bucket, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 297,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::find")
  //</editor-fold>
  public ${ITERATOR} find$Const(StringRef Key) /*const*/ {
    assert checkAlive();
    return find(Key);
  }

  
  /// lookup - Return the entry for the specified key, or a default
  /// constructed value if no such entry exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::lookup">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 305,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::lookup")
  //</editor-fold>
  public ${VALUE_TYPE} lookup(StringRef Key) /*const*/ {
    assert checkAlive();
    return lookup(Key.data(), Key.size());
  }
  public ${VALUE_TYPE} lookup(char$ptr Key, int KeyLen) /*const*/ {
    assert checkAlive();
    int Bucket = FindKey(Key, KeyLen);  
    if (Bucket != INVALID_INDEX) {
      return ((${ENTRY})TheTable[Bucket]).getValue();
    }
    return $tryClone(defaultValue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMap::operator[]">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 285,
   FQN="llvm::StringMap::operator[]", NM="_ZN4llvm9StringMapixENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm9StringMapixENS_9StringRefE")
  //</editor-fold>
  public ${VALUE_TYPE} /*&*/ $at(String Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue();
  }
  public ${VALUE_TYPE} /*&*/ $at(StringRef Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue();
  }
  public ${VALUE_TYPE} /*&*/ $at(char$ptr Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue();
  }
  public ${VALUE_REFERENCE} /*&*/ ref$at(String Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue$Ref();
  }
  public ${VALUE_REFERENCE} /*&*/ ref$at(StringRef Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue$Ref();
  }  
  public ${VALUE_REFERENCE} /*&*/ ref$at(char$ptr Key) {
    assert checkAlive();
    return GetOrCreateValue(Key).getValue$Ref();
  }

  public ${VALUE_TYPE} $set(StringRef/*&*/ Key, ${VALUE_TYPE} Val) {
    assert checkAlive();
    ${SET_IMPL}
  }
  public ${VALUE_TYPE} $set(String/*&*/ Key, ${VALUE_TYPE} Val) {
    assert checkAlive();
    ${SET_IMPL}
  }
  public ${VALUE_TYPE} $set(char$ptr Key, ${VALUE_TYPE} Val) {
    assert checkAlive();
    ${SET_IMPL_KEY_LEN}
  }

  /// count - Return 1 if the element is in the map, 0 otherwise.  
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 316,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::count")
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
  public std.pairTypeBool<${ITERATOR}> insert(${PAIR_TYPE} KV) {
    assert checkAlive();
    char$ptr keyData = KV.first.data();
    int keyLength = KV.first.size();
    /*uint*/int FullHashValue = HashString(keyData, keyLength);
    /*uint*/int BucketNo = LookupBucketFor(keyData, keyLength, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return std.make_pair_T_bool(new ${ITERATOR}(TheTable, BucketNo, false), 
          false); // Already exists in map.
    }
    if (Bucket == getTombstoneVal()) {
      --NumTombstones;
    }
    Bucket
       = ${CREATE_ENTRY_STRING}(keyData, keyLength, FullHashValue, Allocator, std.move(KV.second));
    TheTable[BucketNo] = Bucket;
    ++NumItems;
    assert (NumItems + NumTombstones <= NumBuckets);

    BucketNo = RehashTable(BucketNo);
    return std.make_pair_T_bool(new ${ITERATOR}(TheTable, BucketNo, false), true);
  }
  
  /// Emplace a new element for the specified key into the map if the key isn't
  /// already in the map. The bool component of the returned pair is true
  /// if and only if the insertion takes place, and the iterator component of
  /// the pair points to the element with key equivalent to the key of the pair.
  public std.pairTypeBool<${ITERATOR}> emplace_second(StringRef Key, ${VALUE_TYPE} ValueToMove) {
    assert checkAlive();
    char$ptr keyData = Key.data();
    int keyLength = Key.size();
    /*uint*/int FullHashValue = HashString(keyData, keyLength);
    /*uint*/int BucketNo = LookupBucketFor(keyData, keyLength, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return std.make_pair_T_bool(new ${ITERATOR}(TheTable, BucketNo, false), 
          false); // Already exists in map.
    }
    if (Bucket == getTombstoneVal()) {
      --NumTombstones;
    }
    Bucket
       = ${CREATE_ENTRY_STRING}(keyData, keyLength, FullHashValue, Allocator, $tryMove(std.move(ValueToMove)));
    TheTable[BucketNo] = Bucket;
    ++NumItems;
    assert (NumItems + NumTombstones <= NumBuckets);

    BucketNo = RehashTable(BucketNo);
    return std.make_pair_T_bool(new ${ITERATOR}(TheTable, BucketNo, false), true);
  }
    
  /// insert - Insert the specified key/value pair into the map.  If the key
  /// already exists in the map, return false and ignore the request, otherwise
  /// insert it and return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 323,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::insert")
  //</editor-fold>
  public boolean insert(${ENTRY}/*P*/ KeyValue) {
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


  // clear - Empties out the ${FILE_NAME}
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 340,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::clear")
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
          ((/*static_cast*/${ENTRY}/*P*/ )Bucket).Destroy(Allocator);
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
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::GetOrCreateValue">
  @Converted(kind = Converted.Kind.DEPRECATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 361,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::GetOrCreateValue")
  //</editor-fold>
  public ${ENTRY}/*&*/ GetOrCreateValue(StringRef Key, ${VALUE_TYPE} Val) {
    assert checkAlive();
    return GetOrCreateValue(Key.data(), Key.size(), Val);
  }
  public ${ENTRY}/*&*/ GetOrCreateValue(String Key, ${VALUE_TYPE} Val) {
    assert checkAlive();
    return GetOrCreateValue(new StringRef(Key), Val);
  } 
  public ${ENTRY}/*&*/ GetOrCreateValue(char$ptr Key, int Len, ${VALUE_TYPE} Val) {
    assert checkAlive();
    /*uint*/int FullHashValue = HashString(Key, Len);
    /*uint*/int BucketNo = LookupBucketFor(Key, Len, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return /*Deref*/(${ENTRY}/*P*/ )(Bucket);
    }
    
    if (Val == defaultValue) {
        Val = $tryClone(Val);
    }
    ${ENTRY}/*P*/ NewItem =  ${CREATE_ENTRY_STRING}(Key, Len, FullHashValue, Allocator, Val);
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
    return /*Deref*/(${ENTRY}) Bucket;
  }
  private ${ENTRY}/*&*/ GetOrCreateValue(byte[] Key, int KeyStIndex, int Len, ${VALUE_TYPE} Val) {
    /*uint*/int FullHashValue = HashString(Key, KeyStIndex, Len);
    /*uint*/int BucketNo = LookupBucketFor(Key, KeyStIndex, Len, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return /*Deref*/(${ENTRY}/*P*/ )(Bucket);
    }
    
    if (Val == defaultValue) {
        Val = $tryClone(Val);
    }
    ${ENTRY}/*P*/ NewItem =  ${CREATE_ENTRY_STRING}(Key, KeyStIndex, Len, FullHashValue, Allocator, Val);
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
    return /*Deref*/(${ENTRY}) Bucket;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::GetOrCreateValue">
  @Converted(kind = Converted.Kind.DEPRECATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 383,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::GetOrCreateValue")
  //</editor-fold>
  public ${ENTRY}/*&*/ GetOrCreateValue(StringRef Key) {
    assert checkAlive();
    return GetOrCreateValue(Key, defaultValue);
  }
  public ${ENTRY}/*&*/ GetOrCreateValue(String Key) {
    assert checkAlive();
    return GetOrCreateValue(new StringRef(Key), defaultValue);
  }
  public ${ENTRY}/*&*/ GetOrCreateValue(char$ptr Key) {
    assert checkAlive();
    return GetOrCreateValue(Key, strlen(Key), defaultValue);
  }
  public ${ENTRY}/*&*/ GetOrCreateValue(char$ptr Key, int Len) {
    assert checkAlive();
    return GetOrCreateValue(Key, Len, defaultValue);
  }

  public ${ENTRY}/*&*/ GetOrCreateValue(byte[] Key, int KeyStIndex, int Len) {
    assert checkAlive();
    return GetOrCreateValue(Key, KeyStIndex, Len, defaultValue);
  }
  
  /// remove - Remove the specified key/value pair from the map, but do not
  /// erase it.  This aborts if the key is not in the map.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::remove">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 389,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::remove")
  //</editor-fold>
  public void remove(${ENTRY}/*P*/ KeyValue) {
    assert checkAlive();
    RemoveKey(KeyValue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 393,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::erase")
  //</editor-fold>
  public void erase(${ITERATOR} I) {
    assert checkAlive();
    ${ENTRY}/*&*/ V = /*Deref*/I.$star();
    remove(/*AddrOf*/V);
    V.Destroy(Allocator);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 399,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::erase")
  //</editor-fold>
  public boolean erase(StringRef Key) {
    assert checkAlive();
    ${ITERATOR} I = find(Key);
    if ($eq_iter(I, end())) {
      return false;
    }
    erase(I);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::~${CLASS_NAME}">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 406,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::~${CLASS_NAME}")
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
    for (${ITERATOR} B = begin(), E = end(); B.$noteq(E); B.$preInc()) {
      out.append("{").append(B.$star().first()).append("=>").append(B.$star().getValue()).append("}\n");
    }
    return out.toString();
  }
  
  @Override
  public Iterator<${ENTRY}> iterator() {
    assert checkAlive();
    return new JavaIterator(begin(), end());
  }  
  
  @Override
  public ${FILE_NAME}${CLASS_SUFFIX} clone() {
    assert checkAlive();
    ${FILE_NAME}${CLASS_SUFFIX} out = new ${FILE_NAME}${CLASS_SUFFIX}(this, this.defaultValue);
    assert this.getClass() == out.getClass() : "clone must be overridden in " + this.getClass();
    return out;
  }  
}
