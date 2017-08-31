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
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;


/// StringMapImpl - This is the base class of StringMap that is shared among
/// all of its instantiations.
//<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 42,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 41,
 FQN = "llvm::StringMapImpl", NM = "_ZN4llvm13StringMapImplE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImplE")
//</editor-fold>
public class StringMapImpl extends NativeTrace.CreateDestroy$Tracker {
/*protected:*/
  // Array of NumBuckets pointers to entries, null pointers are holes.
  // TheTable[NumBuckets] contains a sentinel value for easy iteration. Followed
  // by an array of the actual hash values as unsigned integers.
  protected StringMapEntryBase /*P*/ /*P*/ TheTable[];
  private int/*uint P*/ HashTable[];
  protected /*uint*/int NumBuckets;
  protected /*uint*/int NumItems;
  protected /*uint*/int NumTombstones;
  protected /*uint*/int ItemSize;
  
  private static final StringMapEntryBase LAST_ENTRY = new StringMapEntryBaseDummy(2);
  private static final StringMapEntryBase TOMBSTONE_ENTRY = new StringMapEntryBaseDummy(0);
  protected static final int INVALID_INDEX = -1;
  
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::StringMapImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 52,
   FQN = "llvm::StringMapImpl::StringMapImpl", NM = "_ZN4llvm13StringMapImplC1Ej",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImplC1Ej")
  //</editor-fold>
  protected /*explicit*/ StringMapImpl(/*uint*/int itemSize) {
    /* : TheTable(null), NumBuckets(0), NumItems(0), NumTombstones(0), ItemSize(itemSize)*/ 
    //START JInit
    this.TheTable = null;
    this.NumBuckets = 0;
    this.NumItems = 0;
    this.NumTombstones = 0;
    this.ItemSize = (int)itemSize;
    //END JInit
    this.HashTable = null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::StringMapImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringMap.cpp", line = 20,
   FQN = "llvm::StringMapImpl::StringMapImpl", NM = "_ZN4llvm13StringMapImplC1Ejj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImplC1Ejj")
  //</editor-fold>
  protected StringMapImpl(/*uint*/int InitSize, /*uint*/int itemSize) {
    ItemSize = (int)itemSize;
    
    // If a size is specified, initialize the table with that many buckets.
    if ((InitSize != 0)) {
      init((int)InitSize);
      return;
    }
    
    // Otherwise, initialize it with zero buckets to avoid the allocation.
    TheTable = null;
    NumBuckets = 0;
    NumItems = 0;
    NumTombstones = 0;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::StringMapImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 58,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 56,
   FQN = "llvm::StringMapImpl::StringMapImpl", NM = "_ZN4llvm13StringMapImplC1EOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImplC1EOS0_")
  //</editor-fold>
  protected StringMapImpl(StringMapImpl /*&&*/RHS) {
    assert RHS.checkAlive();
    /* : TheTable(RHS.TheTable), NumBuckets(RHS.NumBuckets), NumItems(RHS.NumItems), NumTombstones(RHS.NumTombstones), ItemSize(RHS.ItemSize)*/ 
    //START JInit
    this.TheTable = RHS.TheTable;
    this.NumBuckets = RHS.NumBuckets;
    this.NumItems = RHS.NumItems;
    this.NumTombstones = RHS.NumTombstones;
    this.ItemSize = RHS.ItemSize;
    //END JInit
    RHS.TheTable = null;
    RHS.NumBuckets = 0;
    RHS.NumItems = 0;
    RHS.NumTombstones = 0;
  }
  
  /// RehashTable - Grow the table, redistributing values into the buckets with
  /// the appropriate mod-of-hashtable-size.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::RehashTable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringMap.cpp", line = 184,
   FQN = "llvm::StringMapImpl::RehashTable", NM = "_ZN4llvm13StringMapImpl11RehashTableEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImpl11RehashTableEj")
  //</editor-fold>
  protected /*uint*/int RehashTable() {
    assert checkAlive();
    return RehashTable(0);
  }
  protected /*uint*/int RehashTable(/*uint*/int BucketNo/*= 0*/) {
    assert checkAlive();
    /*uint*/int NewSize;
//    uint$ptr/*uint P*/ HashTable = Casts.reinterpret_cast(uint$ptr.class/*uint P*/, (TheTable.$add(NumBuckets + 1)));
    
    // If the hash table is now more than 3/4 full, or if fewer than 1/8 of
    // the buckets are empty (meaning that many are filled with tombstones),
    // grow/rehash the table.
    if (NumItems * 4 > NumBuckets * 3) {
      NewSize = NumBuckets * 2;
    } else if (NumBuckets - (NumItems + NumTombstones) <= NumBuckets / 8) {
      NewSize = NumBuckets;
    } else {
      return BucketNo;
    }
    
    /*uint*/int NewBucketNo = BucketNo;
    // Allocate one extra bucket which will always be non-empty.  This allows the
    // iterators to stop at end.
//    StringMapEntryBase /*P*/ /*P*/ NewTableArray = (StringMapEntryBase /*P*/ /*P*/ )calloc(NewSize + 1, sizeof(StringMapEntryBase /*P*/ ) + sizeof(/*uint*/int));
//    type$ptr<type$ptr<StringMapEntryBase>> NewTableArray = (type$ptr<type$ptr<StringMapEntryBase>>)NativePointer.create_type$ptr(tableArr);    
    StringMapEntryBase NewTableArray [] = new StringMapEntryBase[(int)(NewSize + 1)];
        
//    uint$ptr/*uint P*/ NewHashArray = (uint$ptr/*uint P*/ )(NewTableArray + NewSize + 1);
//    int/*uint P*/ NewHashArray[] = new$int(NewSize + 1);
        
    NewTableArray[(int)NewSize] = LAST_ENTRY/*(StringMapEntryBase * )2*/;
    
    // Rehash all the items into their new buckets.  Luckily :) we already have
    // the hash values available, so we don't have to rehash any strings.
    for (/*uint*/int I = 0, E = (int)NumBuckets; I != E; ++I) {
      StringMapEntryBase /*P*/ Bucket = TheTable[I];
      if (Bucket != null && Bucket != getTombstoneVal()) {
        // Fast case, bucket available.
//        /*uint*/int FullHash = HashTable[I];
        /*uint*/int FullHash = Bucket.FullHashCode;
        /*uint*/int NewBucket = FullHash & (NewSize - 1);
        if (NewTableArray[(int)NewBucket] == null) {
          NewTableArray[(int)(FullHash & (NewSize - 1))] = Bucket;
//          NewHashArray[(int)(FullHash & (NewSize - 1))] = FullHash;
          if (I == BucketNo)
            NewBucketNo = NewBucket;
          continue;
        }
        
        // Otherwise probe for a spot.
        /*uint*/int ProbeSize = 1;
        do {
          NewBucket = (NewBucket + ProbeSize++) & (NewSize - 1);
        } while ((NewTableArray[(int)NewBucket] != null));
        
        // Finally found a slot.  Fill it in.
        NewTableArray[(int)NewBucket] = Bucket;
//        NewHashArray[(int)NewBucket] = FullHash;
        if (I == BucketNo)
          NewBucketNo = NewBucket;
      }
    }
    
    free(TheTable);
    
    TheTable = NewTableArray;
//    HashTable = NewHashArray;
    NumBuckets = NewSize;
    NumTombstones = 0;
    return NewBucketNo;
  }
  
  // JAVA: allow to reset StringMap for reuse
  protected final void resetForReuse() {
    assert checkAlive();
    if (empty()) {
      return;
    }
    
    // reset all to initial state
    for (/*uint*/int I = 0, E = NumBuckets; I != E; ++I) {
      StringMapEntryBase /*P*/ /*&*/ Bucket = TheTable[I];
      if ((Bucket != null) && Bucket != getTombstoneVal()) {
        (Bucket).resetStringMapEntryToInitialState();
      }
    }
  }
  
  public static void resetStringMapEntryToInitialState(StringMapEntryBase entry) {
    assert entry != null;
    entry.resetStringMapEntryToInitialState();
  }
  
  /// LookupBucketFor - Look up the bucket that the specified string should end
  /// up in.  If it already exists as a key in the map, the Item pointer for the
  /// specified bucket will be non-null.  Otherwise, it will be null.  In either
  /// case, the FullHashValue field of the bucket will be set to the hash value
  /// of the string.
  
  /// LookupBucketFor - Look up the bucket that the specified string should end
  /// up in.  If it already exists as a key in the map, the Item pointer for the
  /// specified bucket will be non-null.  Otherwise, it will be null.  In either
  /// case, the FullHashValue field of the bucket will be set to the hash value
  /// of the string.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::LookupBucketFor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringMap.cpp", line = 58,
   FQN = "llvm::StringMapImpl::LookupBucketFor", NM = "_ZN4llvm13StringMapImpl15LookupBucketForENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImpl15LookupBucketForENS_9StringRefE")
  //</editor-fold>
  protected /*uint*/int LookupBucketFor(StringRef _Name) {
    assert checkAlive();
    char$ptr Name = _Name.data();
    int NameLen = _Name.size();
    /*uint*/int FullHashValue = HashString(new StringRef(_Name));
    return LookupBucketFor(Name, NameLen, FullHashValue);
  }
  protected /*uint*/int LookupBucketFor(char$ptr Name, int NameLen, int FullHashValue) {
    assert checkAlive();
    if ($is_array_based(Name)) {
      return LookupBucketFor(Name.$array(), Name.$index(), NameLen, FullHashValue);
    }
    /*uint*/int HTSize = NumBuckets;
    if (HTSize == 0) { // Hash table unallocated so far?
      init(16);
      HTSize = NumBuckets;
    }
    /*uint*/int BucketNo = FullHashValue & (HTSize - 1);
//    uint$ptr/*uint P*/ HashTable = (uint$ptr/*uint P*/ )(TheTable + NumBuckets + 1);
    
    /*uint*/int ProbeAmt = 1;
    int FirstTombstone = INVALID_INDEX;
    while (true) {
      StringMapEntryBase /*P*/ BucketItem = TheTable[BucketNo];
      // If we found an empty bucket, this key isn't in the table yet, return it.
      if (BucketItem == null) {
        // If we found a tombstone, we want to reuse the tombstone instead of an
        // empty bucket.  This reduces probing.
        if (FirstTombstone != INVALID_INDEX) {
//          HashTable[(int)FirstTombstone] = FullHashValue;
          return FirstTombstone;
        }
        
//        HashTable[BucketNo] = FullHashValue;
        return BucketNo;
      }
      if (BucketItem == getTombstoneVal()) {
        // Skip over tombstones.  However, remember the first one we see.
        if (FirstTombstone == INVALID_INDEX) {
          FirstTombstone = BucketNo;
        }
//      } else if (HashTable[(int)BucketNo] == FullHashValue) {
      } else if (BucketItem.FullHashCode == FullHashValue) {
        
        // Do the comparison like this because Name isn't necessarily
        // null-terminated!
//        char$ptr/*char P*/ ItemStr = (char$ptr/*char P*/ )BucketItem.$add(ItemSize);
        byte[]/*char P*/ ItemStr = BucketItem.getKeyArray();
        int ItemStrIndex = BucketItem.getKeyArrayIndex();        
        if ($eq_RawStringRef_with_null_termed(Name, NameLen, ItemStr, ItemStrIndex)) {
          // We found a match!
          return BucketNo;
        }
      }
      
      // Okay, we didn't find the item.  Probe to the next bucket.
      BucketNo = (BucketNo + ProbeAmt) & (HTSize - 1);
      
      // Use quadratic probing, it has fewer clumping artifacts than linear
      // probing and has good cache behavior in the common case.
      ++ProbeAmt;
    }
  }
  protected /*uint*/int LookupBucketFor(byte[] Name, int NameStartIndex, int NameLen, int FullHashValue) {
    assert checkAlive();
    /*uint*/int HTSize = NumBuckets;
    if (HTSize == 0) { // Hash table unallocated so far?
      init(16);
      HTSize = NumBuckets;
    }
    /*uint*/int BucketNo = FullHashValue & (HTSize - 1);
//    uint$ptr/*uint P*/ HashTable = (uint$ptr/*uint P*/ )(TheTable + NumBuckets + 1);
    
    /*uint*/int ProbeAmt = 1;
    int FirstTombstone = INVALID_INDEX;
    while (true) {
      StringMapEntryBase /*P*/ BucketItem = TheTable[BucketNo];
      // If we found an empty bucket, this key isn't in the table yet, return it.
      if (BucketItem == null) {
        // If we found a tombstone, we want to reuse the tombstone instead of an
        // empty bucket.  This reduces probing.
        if (FirstTombstone != INVALID_INDEX) {
//          HashTable[(int)FirstTombstone] = FullHashValue;
          return FirstTombstone;
        }
        
//        HashTable[BucketNo] = FullHashValue;
        return BucketNo;
      }
      if (BucketItem == getTombstoneVal()) {
        // Skip over tombstones.  However, remember the first one we see.
        if (FirstTombstone == INVALID_INDEX) {
          FirstTombstone = BucketNo;
        }
//      } else if (HashTable[(int)BucketNo] == FullHashValue) {
      } else if (BucketItem.FullHashCode == FullHashValue) {
        
        // Do the comparison like this because Name isn't necessarily
        // null-terminated!
//        char$ptr/*char P*/ ItemStr = (char$ptr/*char P*/ )BucketItem.$add(ItemSize);
        byte[]/*char P*/ ItemStr = BucketItem.getKeyArray();
        int ItemStrIndex = BucketItem.getKeyArrayIndex();        
        if ($eq_RawStringRef_with_null_termed(Name, NameStartIndex, NameLen, ItemStr, ItemStrIndex)) {
          // We found a match!
          return BucketNo;
        }
      }
      
      // Okay, we didn't find the item.  Probe to the next bucket.
      BucketNo = (BucketNo + ProbeAmt) & (HTSize - 1);
      
      // Use quadratic probing, it has fewer clumping artifacts than linear
      // probing and has good cache behavior in the common case.
      ++ProbeAmt;
    }
  }

  
  /// FindKey - Look up the bucket that contains the specified key. If it exists
  /// in the map, return the bucket number of the key.  Otherwise return INVALID_INDEX.
  /// This does not modify the map.
  
  /// FindKey - Look up the bucket that contains the specified key. If it exists
  /// in the map, return the bucket number of the key.  Otherwise return INVALID_INDEX.
  /// This does not modify the map.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::FindKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringMap.cpp", line = 116,
   FQN = "llvm::StringMapImpl::FindKey", NM = "_ZNK4llvm13StringMapImpl7FindKeyENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZNK4llvm13StringMapImpl7FindKeyENS_9StringRefE")
  //</editor-fold>
  protected int FindKey(StringRef Key) /*const*/ {
    assert checkAlive();
    return FindKey(Key.data(), Key.size());
  }
  protected int FindKey(char$ptr Key, int KeyLen) /*const*/ {
    assert checkAlive();
    /*uint*/int HTSize = NumBuckets;
    if (HTSize == 0) {
      return INVALID_INDEX; // Really empty table?
    }
    /*uint*/int FullHashValue = HashString(Key, KeyLen);
    /*uint*/int BucketNo = FullHashValue & (HTSize - 1);
//    uint$ptr/*uint P*/ HashTable = (uint$ptr/*uint P*/ )(TheTable + NumBuckets + 1);
    
    /*uint*/int ProbeAmt = 1;
    while (true) {
      StringMapEntryBase /*P*/ BucketItem = TheTable[(int)BucketNo];
      // If we found an empty bucket, this key isn't in the table yet, return.
      if (BucketItem == null) {
        return INVALID_INDEX;
      }
      if (BucketItem == getTombstoneVal()) {
        // Ignore tombstones.
//      } else if (HashTable[(int)BucketNo] == FullHashValue) {
      } else if (BucketItem.FullHashCode == FullHashValue) {
        
        // Do the comparison like this because NameStart isn't necessarily
        // null-terminated!
//        char$ptr/*char P*/ ItemStr = (char$ptr/*char P*/ )BucketItem.$add(ItemSize);
        byte[]/*char P*/ ItemStr = BucketItem.getKeyArray();
        int ItemStrIndex = BucketItem.getKeyArrayIndex();
        if ($eq_RawStringRef_with_null_termed(Key, KeyLen, ItemStr, ItemStrIndex)) {
          // We found a match!
          return (int)BucketNo;
        }
      }
      
      // Okay, we didn't find the item.  Probe to the next bucket.
      BucketNo = (BucketNo + ProbeAmt) & (HTSize - 1);
      
      // Use quadratic probing, it has fewer clumping artifacts than linear
      // probing and has good cache behavior in the common case.
      ++ProbeAmt;
    }
  }

  
  /// RemoveKey - Remove the specified StringMapEntry from the table, but do not
  /// delete it.  This aborts if the value isn't in the table.
  
  /// RemoveKey - Remove the specified StringMapEntry from the table, but do not
  /// delete it.  This aborts if the value isn't in the table.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::RemoveKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringMap.cpp", line = 158,
   FQN = "llvm::StringMapImpl::RemoveKey", NM = "_ZN4llvm13StringMapImpl9RemoveKeyEPNS_18StringMapEntryBaseE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImpl9RemoveKeyEPNS_18StringMapEntryBaseE")
  //</editor-fold>
  protected void RemoveKey(StringMapEntryBase /*P*/ V) {
    assert checkAlive();
    /*const*/char$ptr/*char P*/ VStr = (char$ptr/*char P*/ )V.getKeyStr();
    StringMapEntryBase /*P*/ V2 = RemoveKey(VStr, V.getKeyLength());
//    (void)V2;
    assert (V == V2) : "Didn't find key?";
  }

  
  /// RemoveKey - Remove the StringMapEntry for the specified key from the
  /// table, returning it.  If the key is not in the table, this returns null.
  
  /// RemoveKey - Remove the StringMapEntry for the specified key from the
  /// table, returning it.  If the key is not in the table, this returns null.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::RemoveKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringMap.cpp", line = 167,
   FQN = "llvm::StringMapImpl::RemoveKey", NM = "_ZN4llvm13StringMapImpl9RemoveKeyENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImpl9RemoveKeyENS_9StringRefE")
  //</editor-fold>
  protected StringMapEntryBase /*P*/ RemoveKey(char$ptr Key, int KeyLen) {
    assert checkAlive();
    int Bucket = FindKey(Key, KeyLen);
    if (Bucket == INVALID_INDEX) {
      return null;
    }
    
    StringMapEntryBase /*P*/ Result = TheTable[(int)Bucket];
    TheTable[Bucket] = getTombstoneVal();
    --NumItems;
    ++NumTombstones;
    assert (NumItems + NumTombstones <= NumBuckets);
    
    return Result;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::init">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringMap.cpp", line = 36,
   FQN = "llvm::StringMapImpl::init", NM = "_ZN4llvm13StringMapImpl4initEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImpl4initEj")
  //</editor-fold>
  private void init(/*uint*/int InitSize) {
    assert checkAlive();
    assert ((InitSize & (InitSize - 1)) == 0) : "Init Size must be a power of 2 or zero!";
    NumBuckets = (InitSize != 0) ? InitSize : 16;
    NumItems = 0;
    NumTombstones = 0;
    
//    TheTable = (StringMapEntryBase /*P*/ /*P*/ )calloc(NumBuckets + 1, sizeof(StringMapEntryBase /*P*/ /*P*/ ) + sizeof(/*uint*/int));
    TheTable = new StringMapEntryBase[(int)(NumBuckets + 1)];
//    HashTable = new$int(NumBuckets + 1);
    
    // Allocate one extra bucket, set it to look filled so the iterators stop at
    // end.
    TheTable[(int)NumBuckets] = LAST_ENTRY/*(StringMapEntryBase * )2*/;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::getTombstoneVal">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 95,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 91,
   FQN = "llvm::StringMapImpl::getTombstoneVal", NM = "_ZN4llvm13StringMapImpl15getTombstoneValEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImpl15getTombstoneValEv")
  //</editor-fold>
  public static StringMapEntryBase /*P*/ getTombstoneVal() {
    return /*(StringMapEntryBase * )-1*/ TOMBSTONE_ENTRY;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::getNumBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 95,
   FQN = "llvm::StringMapImpl::getNumBuckets", NM = "_ZNK4llvm13StringMapImpl13getNumBucketsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZNK4llvm13StringMapImpl13getNumBucketsEv")
  //</editor-fold>
  public /*uint*/int getNumBuckets() /*const*/ {
    assert checkAlive();
    return NumBuckets;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::getNumItems">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 96,
   FQN = "llvm::StringMapImpl::getNumItems", NM = "_ZNK4llvm13StringMapImpl11getNumItemsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZNK4llvm13StringMapImpl11getNumItemsEv")
  //</editor-fold>
  public /*uint*/int getNumItems() /*const*/ {
    assert checkAlive();
    return NumItems;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::empty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 102,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 98,
   FQN = "llvm::StringMapImpl::empty", NM = "_ZNK4llvm13StringMapImpl5emptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZNK4llvm13StringMapImpl5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    assert checkAlive();
    return NumItems == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 103,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 99,
   FQN = "llvm::StringMapImpl::size", NM = "_ZNK4llvm13StringMapImpl4sizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZNK4llvm13StringMapImpl4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    assert checkAlive();
    return NumItems;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapImpl::swap">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 105,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 101,
   FQN = "llvm::StringMapImpl::swap", NM = "_ZN4llvm13StringMapImpl4swapERS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm13StringMapImpl4swapERS0_")
  //</editor-fold>
  public void swap(StringMapImpl /*&*/ Other) {
    assert Other.checkAlive();
    assert checkAlive();
    StringMapEntryBase[] TheTableOther = Other.TheTable;
    Other.TheTable = this.TheTable;
    this.TheTable = TheTableOther;
    int NumBucketsOther = Other.NumBuckets;
    Other.NumBuckets = this.NumBuckets;
    this.NumBuckets = NumBucketsOther;
    int NumItemsOther = Other.NumItems;
    Other.NumItems = this.NumItems;
    this.NumItems = NumItemsOther;
    int NumTombstonesOther = Other.NumTombstones;
    Other.NumTombstones = this.NumTombstones;
    this.NumTombstones = NumTombstonesOther;
  }

  private static final class StringMapEntryBaseDummy extends StringMapEntryBaseCharArray {

    public StringMapEntryBaseDummy(/*uint*/int Len) {
      super(Len);
    }
  }
  
  public final boolean checkAlive() {
    return check$Alive();
  }  
  
  public static String toStringBucket(final StringMapEntryBase[] /*P*/ /*P*/ Buckets, final int /*P*/ /*P*/ PtrIdx) {
    if (Buckets == null) {
      return "<no buckets for " + PtrIdx + ">";
    }
    if (PtrIdx < 0 || PtrIdx >= Buckets.length) {
      return "<bad index " + PtrIdx + " for " + Buckets.length + ">";
    }
    if (Buckets[PtrIdx] == LAST_ENTRY) {
      return "<LAST entry at " + PtrIdx + ">";
    }
    if (Buckets[PtrIdx] == TOMBSTONE_ENTRY) {
      return "<TOMBSTONE entry at " + PtrIdx + ">";
    }
    return "" + Buckets[PtrIdx];
  }
}
