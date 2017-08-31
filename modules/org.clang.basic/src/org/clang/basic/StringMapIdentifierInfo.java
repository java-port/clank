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

package org.clang.basic;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.basic.IdentifierInfoStringMapEntry;
import org.clang.basic.IdentifierInfo;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.StringMapEntry;

/*template <typename IdentifierInfo, typename BumpPtrAllocator = MallocAllocator> TEMPLATE*/

/// StringMapIdentifierInfo - This is an unconventional map that is specialized for handling
/// keys that are "strings", which are basically ranges of bytes. This does some
/// funky memory allocation and hashing things to make it extremely efficient,
/// storing the string data *after* the value in the map.
//<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 235,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo")
//</editor-fold>
public class StringMapIdentifierInfo  extends /*public*/ StringMapImpl implements Destructors.ClassWithDestructor {
  private final BumpPtrAllocator Allocator;
  private final IdentifierInfo defaultValue;
/*public:*/
  /*typedef StringMapEntryIdentifierInfo MapEntryTy*/
//  public final class MapEntryTy extends StringMapEntryIdentifierInfo{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::StringMapIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 241,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::StringMapIdentifierInfo")
  //</editor-fold>
  public StringMapIdentifierInfo(IdentifierInfo defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(StringMapEntry.$sizeof_StringMapEntry());
    this.defaultValue = defaultValue;
    //END JInit
    this.Allocator = (BumpPtrAllocator)new StringMapBumpPtrAllocator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::StringMapIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 242,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::StringMapIdentifierInfo")
  //</editor-fold>
  public /*explicit*/ StringMapIdentifierInfo(/*uint*/int InitialSize, IdentifierInfo defaultValue) {
    /* : StringMapImpl(InitialSize, static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(InitialSize, StringMapEntry.$sizeof_StringMapEntry());
    this.defaultValue = defaultValue;
    //END JInit
    this.Allocator = (BumpPtrAllocator)new StringMapBumpPtrAllocator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::StringMapIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 245,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::StringMapIdentifierInfo")
  //</editor-fold>
  public /*explicit*/ StringMapIdentifierInfo(BumpPtrAllocator A, IdentifierInfo defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy))), Allocator(A)*/ 
    //START JInit
    super(StringMapEntry.$sizeof_StringMapEntry());
    assert A != null;
    this.Allocator = A;
    this.defaultValue = defaultValue;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::StringMapIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 248,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::StringMapIdentifierInfo")
  //</editor-fold>
  public StringMapIdentifierInfo(/*uint*/int InitialSize, StringMapBumpPtrAllocator A, IdentifierInfo defaultValue) {
    /* : StringMapImpl(InitialSize, static_cast<unsigned int>(sizeof(MapEntryTy))), Allocator(A)*/ 
    //START JInit
    super(InitialSize, StringMapEntry.$sizeof_StringMapEntry());
    assert A != null;
    this.Allocator = A;
    this.defaultValue = defaultValue;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::StringMapIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 252,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::StringMapIdentifierInfo")
  //</editor-fold>
  public StringMapIdentifierInfo(/*const*/StringMapIdentifierInfo /*&*/ RHS, IdentifierInfo defaultValue) {
    /* : StringMapImpl(static_cast<unsigned int>(sizeof(MapEntryTy)))*/ 
    //START JInit
    super(StringMapEntry.$sizeof_StringMapEntry());
    this.defaultValue = defaultValue;
    if (!RHS.empty()) {
      throw new AssertionError("Copy ctor from non-empty stringmap not implemented yet!");
    }
    //END JInit
    this.Allocator = (BumpPtrAllocator)new StringMapBumpPtrAllocator();
//    ((RHS.empty() && "Copy ctor from non-empty stringmap not implemented yet!") ? (/*static_cast*/void)(0) : __assert_fail("RHS.empty() && \"Copy ctor from non-empty stringmap not implemented yet!\"", ${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", 255, __PRETTY_FUNCTION__));
//    (void)RHS;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 258,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::operator=")
  //</editor-fold>
  public void $assign(/*const*/StringMapIdentifierInfo /*&*/ RHS) {
//    ((RHS.empty() && "assignment from non-empty stringmap not implemented yet!") ? (/*static_cast*/void)(0) : __assert_fail("RHS.empty() && \"assignment from non-empty stringmap not implemented yet!\"", ${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", 260, __PRETTY_FUNCTION__));
//    (void)RHS;
    if (!RHS.empty()) {
      throw new AssertionError("assignment from non-empty stringmap not implemented yet!");
    }
    clear();
  }

  /*typedef typename ReferenceAdder<BumpPtrAllocator>::result AllocatorRefTy*/
//  public final class AllocatorRefTy extends  ReferenceAdder<BumpPtrAllocator>.result{ };
  /*typedef typename ReferenceAdder<const BumpPtrAllocator>::result AllocatorCRefTy*/
//  public final class AllocatorCRefTy extends  ReferenceAdder</*const*/BumpPtrAllocator>.result{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::getAllocator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 267,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::getAllocator")
  //</editor-fold>
  public BumpPtrAllocator getAllocator() {
    return Allocator;
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::getAllocator">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 268,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::getAllocator")
//  //</editor-fold>
//  public AllocatorCRefTy getAllocator() /*const*/ {
//    return Allocator;
//  }

  /*typedef const char *key_type*/;
  /*typedef IdentifierInfo mapped_type*/
//  public final class mapped_type extends IdentifierInfo{ };
  /*typedef StringMapEntryIdentifierInfo value_type*/
//  public final class value_type extends StringMapEntryIdentifierInfo{ };
  /*typedef size_t size_type*/;
  /*typedef StringMapConstIterator<IdentifierInfo> const_iterator*/
//  public final class const_iterator extends StringMapConstIterator<IdentifierInfo>{ };
  /*typedef StringMapIteratorIdentifierInfo iterator*/
//  public final class iterator extends StringMapIteratorIdentifierInfo{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 278,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::begin")
  //</editor-fold>
  public StringMapIteratorIdentifierInfo begin() {
    return new StringMapIteratorIdentifierInfo(TheTable, 0, NumBuckets == 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 281,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::end")
  //</editor-fold>
  public StringMapIteratorIdentifierInfo end() {
    return new StringMapIteratorIdentifierInfo(TheTable, NumBuckets, true);
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::begin">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 284,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::begin")
//  //</editor-fold>
//  public StringMapIteratorIdentifierInfo begin() /*const*/ {
//    return StringMapIteratorIdentifierInfo(TheTable, NumBuckets == 0);
//  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::end">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 287,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::end")
//  //</editor-fold>
//  public StringMapIteratorIdentifierInfo end() /*const*/ {
//    return StringMapIteratorIdentifierInfo(TheTable + NumBuckets, true);
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 291,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::find")
  //</editor-fold>
  public StringMapIteratorIdentifierInfo find(StringRef Key) {
    int Bucket = FindKey(Key);
    if (Bucket == INVALID_INDEX) {
      return end();
    }
    return new StringMapIteratorIdentifierInfo(TheTable, Bucket, true);
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::find">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 297,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::find")
//  //</editor-fold>
//  public StringMapIteratorIdentifierInfo find(StringRef Key) /*const*/ {
//    int Bucket = FindKey(Key);
//    if (Bucket == -1) {
//      return end();
//    }
//    return new StringMapIteratorIdentifierInfo(NativePointer.create_type$ptr(TheTable, Bucket), true);
//  }

  
  /// lookup - Return the entry for the specified key, or a default
  /// constructed value if no such entry exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::lookup">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 305,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::lookup")
  //</editor-fold>
  public IdentifierInfo lookup(StringRef Key) /*const*/ {
    int Bucket = FindKey(Key);
    if (Bucket != INVALID_INDEX) {
      return ((IdentifierInfoStringMapEntry)TheTable[Bucket]).getValue();
    }
    return $tryClone(defaultValue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::operator[]">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 312,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::operator[]")
  //</editor-fold>
  public IdentifierInfo /*&*/ $at(StringRef Key) {
    return GetOrCreateValue(Key).getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 316,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::count")
  //</editor-fold>
  public /*size_t*/int count(StringRef Key) /*const*/ {
    return FindKey(Key) == INVALID_INDEX ? 0 : 1;
  }

  
  /// insert - Insert the specified key/value pair into the map.  If the key
  /// already exists in the map, return false and ignore the request, otherwise
  /// insert it and return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 323,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::insert")
  //</editor-fold>
  public boolean insert(IdentifierInfoStringMapEntry/*P*/ KeyValue) {
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

  
  // clear - Empties out the StringMapIdentifierInfo
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 340,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::clear")
  //</editor-fold>
  public void clear() {
    if (empty()) {
      return;
    }
    
    // Zap all values, resetting the keys back to non-present (not tombstone),
    // which is safe because we're removing all elements.
    for (/*uint*/int I = 0, E = NumBuckets; I != E; ++I) {
      StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[I];
      if (false) {
        if ((Bucket != null) && Bucket != getTombstoneVal()) {
          ((/*static_cast*/IdentifierInfoStringMapEntry/*P*/ )Bucket).Destroy(Allocator);
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
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::GetOrCreateValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 361,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::GetOrCreateValue")
  //</editor-fold>
  public IdentifierInfoStringMapEntry/*&*/ GetOrCreateValue(StringRef Key, IdentifierInfo Val) {
    return GetOrCreateValue(Key.data(), Key.size(), Val);
  }
  public IdentifierInfoStringMapEntry/*&*/ GetOrCreateValue(char$ptr Key, int Len, IdentifierInfo Val) {
    /*uint*/int FullHashValue = HashString(Key, Len);
    /*uint*/int BucketNo = LookupBucketFor(Key, Len, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return /*Deref*/(IdentifierInfoStringMapEntry/*P*/ )(Bucket);
    }
    
    IdentifierInfoStringMapEntry/*P*/ NewItem =  IdentifierInfoStringMapEntry.<BumpPtrAllocator, IdentifierInfo>Create(Key, Len, FullHashValue, Allocator, Val);
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
    return /*Deref*/(IdentifierInfoStringMapEntry) Bucket;
  }
  private IdentifierInfoStringMapEntry/*&*/ GetOrCreateValue(byte[] Key, int KeyStIndex, int Len, IdentifierInfo Val) {
    /*uint*/int FullHashValue = HashString(Key, KeyStIndex, Len);
    /*uint*/int BucketNo = LookupBucketFor(Key, KeyStIndex, Len, FullHashValue);
    StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[BucketNo];
    if ((Bucket != null) && Bucket != getTombstoneVal()) {
      return /*Deref*/(IdentifierInfoStringMapEntry/*P*/ )(Bucket);
    }
    
    IdentifierInfoStringMapEntry/*P*/ NewItem =  IdentifierInfoStringMapEntry.<BumpPtrAllocator, IdentifierInfo>Create(Key, KeyStIndex, Len, FullHashValue, Allocator, Val);
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
    return /*Deref*/(IdentifierInfoStringMapEntry) Bucket;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::GetOrCreateValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 383,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::GetOrCreateValue")
  //</editor-fold>
  public IdentifierInfoStringMapEntry/*&*/ GetOrCreateValue(StringRef Key) {
    return GetOrCreateValue(Key, defaultValue);
  }

  public IdentifierInfoStringMapEntry/*&*/ GetOrCreateValue(char$ptr Key, int Len) {
    return GetOrCreateValue(Key, Len, defaultValue);
  }

  public IdentifierInfoStringMapEntry/*&*/ GetOrCreateValue(byte[] Key, int KeyStIndex, int Len) {
    return GetOrCreateValue(Key, KeyStIndex, Len, defaultValue);
  }
  
  /// remove - Remove the specified key/value pair from the map, but do not
  /// erase it.  This aborts if the key is not in the map.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::remove">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 389,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::remove")
  //</editor-fold>
  public void remove(IdentifierInfoStringMapEntry/*P*/ KeyValue) {
    RemoveKey(KeyValue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 393,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::erase")
  //</editor-fold>
  public void erase(StringMapIteratorIdentifierInfo I) {
    IdentifierInfoStringMapEntry/*&*/ V = $Deref(I.$star());
    remove($AddrOf(V));
    V.Destroy(Allocator);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 399,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::erase")
  //</editor-fold>
  public boolean erase(StringRef Key) {
    StringMapIteratorIdentifierInfo I = find(Key);
    if ($eq_iter(I, end())) {
      return false;
    }
    erase(I);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapIdentifierInfo::~StringMapIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMapIdentifierInfo.h", line = 406,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMapIdentifierInfo.cpp -filter=llvm::StringMapIdentifierInfo::~StringMapIdentifierInfo")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
//    super.$destroy();
    clear();
    free(TheTable);
    Allocator.$destroy();
    super.set$destroyed();
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    for (StringMapIteratorIdentifierInfo B = begin(), E = end(); B.$noteq(E); B.$preInc()) {
      out.append("{").append(B.$star().first()).append("=>").append(B.$star().getValue()).append("}\n");
    }
    return out.toString();
  }
}
