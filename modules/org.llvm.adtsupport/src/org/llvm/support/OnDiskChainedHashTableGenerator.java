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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.new$T;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.OnDiskChainedHashTable.InfoInterface;
import org.llvm.support.endian.Writer;
import static org.llvm.support.llvm.support.endianness.little;


/// \brief Generates an on disk hash table.
///
/// This needs an \c Info that handles storing values into the hash table's
/// payload and computes the hash for a given key. This should provide the
/// following interface:
///
/// \code
/// class ExampleInfo {
/// public:
///   typedef ExampleKey key_type;   // Must be copy constructible
///   typedef ExampleKey &key_type_ref;
///   typedef ExampleData data_type; // Must be copy constructible
///   typedef ExampleData &data_type_ref;
///   typedef uint32_t hash_value_type; // The type the hash function returns.
///   typedef uint32_t offset_type; // The type for offsets into the table.
///
///   /// Calculate the hash for Key
///   static hash_value_type ComputeHash(key_type_ref Key);
///   /// Return the lengths, in bytes, of the given Key/Data pair.
///   static std::pair<offset_type, offset_type>
///   EmitKeyDataLength(raw_ostream &Out, key_type_ref Key, data_type_ref Data);
///   /// Write Key to Out.  KeyLen is the length from EmitKeyDataLength.
///   static void EmitKey(raw_ostream &Out, key_type_ref Key,
///                       offset_type KeyLen);
///   /// Write Data to Out.  DataLen is the length from EmitKeyDataLength.
///   static void EmitData(raw_ostream &Out, key_type_ref Key,
///                        data_type_ref Data, offset_type DataLen);
///   /// Determine if two keys are equal. Optional, only needed by contains.
///   static bool EqualKey(key_type_ref Key1, key_type_ref Key2);
/// };
/// \endcode
/*template <typename Info> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 60,
 FQN="llvm::OnDiskChainedHashTableGenerator", NM="_ZN4llvm31OnDiskChainedHashTableGeneratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGeneratorE")
//</editor-fold>
public class OnDiskChainedHashTableGenerator<external_key_type/*unused*/, internal_key_type, data_type>  implements Destructors.ClassWithDestructor {
  /// \brief A single item in the hash table.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::Item">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 62,
   FQN="llvm::OnDiskChainedHashTableGenerator::Item", NM="_ZN4llvm31OnDiskChainedHashTableGenerator4ItemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator4ItemE")
  //</editor-fold>
  private static final class Item<internal_key_type, data_type> {
  /*public:*/
    public /*Info.key_type*/internal_key_type Key;
    public /*Info.*/data_type Data;
    public Item<internal_key_type, data_type> /*P*/ Next;
    public /*const*//*Info.hash_value_type uint32_t*/int Hash;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::Item::Item">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 69,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 67,
     FQN = "llvm::OnDiskChainedHashTableGenerator::Item::Item", NM = "_ZN4llvm31OnDiskChainedHashTableGenerator4ItemC1ENT_12key_type_refENS2_13data_type_refERS2_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator4ItemC1ENT_12key_type_refENS2_13data_type_refERS2_")
    //</editor-fold>
    public Item(internal_key_type /*&*/ Key, data_type /*&*/ Data, 
        InfoInterface<?/*unused*/, internal_key_type, data_type> /*&*/ InfoObj) {
      /* : Key(Key), Data(Data), Next(null), Hash(InfoObj.ComputeHash(Key))*/ 
      //START JInit
      this.Key = /*ParenListExpr*/Key;
      this.Data = /*ParenListExpr*/Data;
      this.Next = /*ParenListExpr*/null;
      this.Hash = /*ParenListExpr*/InfoObj.ComputeHash(Key);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Key=" + Key // NOI18N
                + ", Data=" + Data // NOI18N
                + ", Next=" + Next // NOI18N
                + ", Hash=" + Hash; // NOI18N
    }
  };
  
  // JAVA: typedef typename Info::offset_type offset_type
//  public final class offset_type extends  Info.offset_type{ };
  private /*Info.offset_type*/int NumBuckets;
  private /*Info.offset_type*/int NumEntries;
  private SpecificBumpPtrAllocator<Item> BA;
  private final EmitInfoInterface<internal_key_type, data_type, ?> InfoObj;
  
  /// \brief A linked list of values in a particular hash bucket.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::Bucket">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 80,
   FQN="llvm::OnDiskChainedHashTableGenerator::Bucket", NM="_ZN4llvm31OnDiskChainedHashTableGenerator6BucketE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator6BucketE")
  //</editor-fold>
  private static final class/*struct*/ Bucket<internal_key_type, data_type> {
    public /*Info.offset_type*/int Off;
    public /*uint*/int Length;
    public Item<internal_key_type, data_type> /*P*/ Head;

    @Override public String toString() {
      return "" + "Off=" + Off // NOI18N
                + ", Length=" + Length // NOI18N
                + ", Head=" + Head; // NOI18N
    }
  };
  
  private Bucket<internal_key_type, data_type>[]/*P*/ Buckets;
/*private:*/
  /// \brief Insert an item into the appropriate hash bucket.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 90,
   FQN="llvm::OnDiskChainedHashTableGenerator::insert", NM="_ZN4llvm31OnDiskChainedHashTableGenerator6insertEPNS0_6BucketEjPNS0_4ItemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator6insertEPNS0_6BucketEjPNS0_4ItemE")
  //</editor-fold>
  private void insert(Bucket<internal_key_type, data_type>[] /*P*/ Buckets, /*size_t*/int Size, Item<internal_key_type, data_type> /*P*/ E) {
    Bucket /*&*/ B = Buckets[E.Hash & (Size - 1)];
    E.Next = B.Head;
    ++B.Length;
    B.Head = E;
  }

  
  /// \brief Resize the hash table, moving the old entries into the new buckets.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::resize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 98,
   FQN="llvm::OnDiskChainedHashTableGenerator::resize", NM="_ZN4llvm31OnDiskChainedHashTableGenerator6resizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator6resizeEj")
  //</editor-fold>
  private void resize(/*size_t*/int NewSize) {
//    Bucket /*P*/ NewBuckets = (Bucket /*P*/ )std.calloc(NewSize, sizeof(Bucket));
    // JAVA: replace calloc by array and initialize elements
    Bucket<internal_key_type, data_type>/*P*/ NewBuckets[] = new$T(new Bucket[NewSize],Bucket::new);
    // Populate NewBuckets with the old entries.
    for (/*size_t*/int I = 0; I < NumBuckets; ++I)  {
      for (Item<internal_key_type, data_type> /*P*/ E = Buckets[I].Head; E != null;) {
        Item /*P*/ N = E.Next;
        E.Next = null;
        insert(NewBuckets, NewSize, E);
        E = N;
      }
    }
    
    free(Buckets);
    NumBuckets = NewSize;
    Buckets = NewBuckets;
  }

/*public:*/
  /// \brief Insert an entry into the table.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 116,
   FQN="llvm::OnDiskChainedHashTableGenerator::insert", NM="_ZN4llvm31OnDiskChainedHashTableGenerator6insertENT_12key_type_refENS1_13data_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator6insertENT_12key_type_refENS1_13data_type_refE")
  //</editor-fold>
  public void insert(/*Info.key_type_ref*/internal_key_type /*&*/ Key, 
        /*Info.data_type_ref*/data_type /*&*/ Data) {
    insert(Key, Data, this.InfoObj);
  }

  
  /// \brief Insert an entry into the table.
  ///
  /// Uses the provided Info instead of a stack allocated one.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 125,
   FQN="llvm::OnDiskChainedHashTableGenerator::insert", NM="_ZN4llvm31OnDiskChainedHashTableGenerator6insertENT_12key_type_refENS1_13data_type_refERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator6insertENT_12key_type_refENS1_13data_type_refERS1_")
  //</editor-fold>
  public void insert(/*Info.key_type_ref*/internal_key_type /*&*/ Key, 
        /*Info.data_type_ref*/data_type /*&*/ Data, final InfoInterface<?/*unused*/, internal_key_type, data_type> /*&*/ InfoObj) {
    // JAVA:
    assert InfoObj != null;
    assert InfoObj == this.InfoObj;
    
    ++NumEntries;
    if (4 * NumEntries >= 3 * NumBuckets) {
      resize(NumBuckets * 2);
    }
    insert(Buckets, NumBuckets, /*FIXME: NEW_EXPR [NoNewFun]*//*new (BA.Allocate())*/ new Item( Key, Data, InfoObj ));
  }

  
  /// \brief Determine whether an entry has been inserted.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::contains">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 134,
   FQN="llvm::OnDiskChainedHashTableGenerator::contains", NM="_ZN4llvm31OnDiskChainedHashTableGenerator8containsENT_12key_type_refERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator8containsENT_12key_type_refERS1_")
  //</editor-fold>
  public boolean contains( /*Info.key_type_ref*/internal_key_type /*&*/ Key, final InfoInterface<?/*unused*/, internal_key_type, data_type> /*&*/ InfoObj) {
    /*uint*/int Hash = InfoObj.ComputeHash(Key);
    for (Item<internal_key_type, data_type> /*P*/ I = Buckets[Hash & (NumBuckets - 1)].Head; I != null; I = I.Next)  {
      if ((I.Hash == Hash) && (InfoObj.EqualKey(I.Key, Key))) {
        return true;
      }
    }
    return false;
  }
  
  
  /// \brief Emit the table to Out, which must not be at offset 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::Emit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 143,
   FQN="llvm::OnDiskChainedHashTableGenerator::Emit", NM="_ZN4llvm31OnDiskChainedHashTableGenerator4EmitERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator4EmitERNS_11raw_ostreamE")
  //</editor-fold>
  public /*offset_type*/int Emit(raw_ostream /*&*/ Out) {
//    Info InfoObj;
    return Emit(Out, this.InfoObj);
  }

  
  /// \brief Emit the table to Out, which must not be at offset 0.
  ///
  /// Uses the provided Info instead of a stack allocated one.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::Emit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 151,
   FQN="llvm::OnDiskChainedHashTableGenerator::Emit", NM="_ZN4llvm31OnDiskChainedHashTableGenerator4EmitERNS_11raw_ostreamERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGenerator4EmitERNS_11raw_ostreamERT_")
  //</editor-fold>
  public /*Info.offset_type*/int Emit(final raw_ostream /*&*/ Out, 
          final EmitInfoInterface<internal_key_type, data_type, ?> /*&*/ InfoObj) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    
    // Now we're done adding entries, resize the bucket list if it's
    // significantly too large. (This only happens if the number of
    // entries is small and we're within our initial allocation of
    // 64 buckets.) We aim for an occupancy ratio in [3/8, 3/4).
    //
    // As a special case, if there are two or fewer entries, just
    // form a single bucket. A linear scan is fine in that case, and
    // this is very common in C++ class lookup tables. This also
    // guarantees we produce at least one bucket for an empty table.
    //
    // FIXME: Try computing a perfect hash function at this point.
    /*uint*/int TargetNumBuckets = (NumEntries <= 2) ? 1 : NextPowerOf2((NumEntries * 4) / 3);
    if (Native.$noteq(TargetNumBuckets, NumBuckets)) {
      resize(TargetNumBuckets);
    }
    
    // Emit the payload of the table.
    for (/*Info.offset_type*/int I = 0; I < NumBuckets; ++I) {
      final Bucket<internal_key_type, data_type> /*&*/ B = Buckets[I];
      if (B.Head == null) {
        continue;
      }
      
      // Store the offset for the data of this bucket.
      B.Off = $long2uint(Out.tell());
      assert Native.$bool(B.Off) : "Cannot write a bucket at offset 0. Please add padding.";
      
      // Write out the number of items in the bucket.
      LE.write_uint16(B.Length);
      assert Native.$bool(Native.$noteq(B.Length, 0)) : "Bucket has a head but zero length?";
      
      // Write out the entries in the bucket.
      for (Item<internal_key_type, data_type> /*P*/ I$1 = B.Head; I$1 != null; I$1 = I$1.Next) {
        LE./*< Info.offset_type>*/write_uint32(I$1.Hash);
        final /*const*/ /*std.pair<Info.offset_type, Info.offset_type>*/long /*&*/ Len = InfoObj.EmitKeyDataLength$WrapPair(Out, I$1.Key, I$1.Data);
if (NativeTrace.NDEBUG()) {
//#ifdef NDEBUG
        InfoObj.EmitKey(Out, I$1.Key, $first_uint(Len));
        InfoObj.EmitData(Out, I$1.Key, I$1.Data, $second_uint(Len));
} else {       
//#else  
        // In asserts mode, check that the users length matches the data they
        // wrote.
        long/*uint64_t*/ KeyStart = Out.tell();
        InfoObj.EmitKey(Out, I$1.Key, $first_uint(Len));
        long/*uint64_t*/ DataStart = Out.tell();
        InfoObj.EmitData(Out, I$1.Key, I$1.Data, $second_uint(Len));
        long/*uint64_t*/ End = Out.tell();
        assert Native.$bool(Native.$eq( /*Info.offset_type*/(DataStart - KeyStart), $first_uint(Len))) : "key length does not match bytes written";
        assert Native.$bool(Native.$eq( /*Info.offset_type*/(End - DataStart), $second_uint(Len))) : "data length does not match bytes written";
//#endif        
}
      }
    }
    
    // Pad with zeros so that we can start the hashtable at an aligned address.
    /*Info.offset_type*/int TableOff = $long2uint(Out.tell());
    long/*uint64_t*/ N = llvm.OffsetToAlignment(TableOff, alignOf(/*Info.offset_type uint32_t*/int.class));
    TableOff += N;
    while (((N--) != 0)) {
      LE.write_uint8(0);
    }
    
    // Emit the hashtable itself.
    LE./*< Info.offset_type>*/write_uint32(NumBuckets);
    LE./*< Info.offset_type>*/write_uint32(NumEntries);
    for (/*Info.offset_type uint32_t*/int I = 0; I < NumBuckets; ++I)  {
      LE./*< Info.offset_type>*/write_uint32(Buckets[I].Off);
    }
    
    return TableOff;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::OnDiskChainedHashTableGenerator<Info>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 209,
   FQN="llvm::OnDiskChainedHashTableGenerator::OnDiskChainedHashTableGenerator<Info>", NM="_ZN4llvm31OnDiskChainedHashTableGeneratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGeneratorC1Ev")
  //</editor-fold>
  public OnDiskChainedHashTableGenerator(EmitInfoInterface<internal_key_type, data_type, ?> InfoObj) {
    NumEntries = 0;
    NumBuckets = 64;
    // Note that we do not need to run the constructors of the individual
    // Bucket objects since 'calloc' returns bytes that are all 0.
//    Buckets = (Bucket /*P*/ )std.calloc(NumBuckets, sizeof(Bucket));
    // JAVA: replace calloc by array and initialize elements
    Buckets = new$T(new Bucket[NumBuckets],Bucket::new);
    this.InfoObj = InfoObj;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTableGenerator::~OnDiskChainedHashTableGenerator<Info>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 217,
   FQN="llvm::OnDiskChainedHashTableGenerator::~OnDiskChainedHashTableGenerator<Info>", NM="_ZN4llvm31OnDiskChainedHashTableGeneratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm31OnDiskChainedHashTableGeneratorD0Ev")
  //</editor-fold>
  public void $destroy() {
    std.free(Buckets);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  public static interface EmitInfoInterface<internal_key_type, data_type, file_type> extends InfoInterface<Void/*unused*/, internal_key_type, data_type> {

    /**
     * returns <Key-Length, Data-Length> information.
     * @param out
     * @param key
     * @param data
     * @return pair<key-length, data-length>
     */
    public default /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(raw_ostream out, internal_key_type key, data_type data) {
      NativeTrace.assertTrueInConsole(false, "Must be implemented in " + this.getClass() + " for faster writes and less memory allocations. Usually it's enough to change return type and wrap pair into long as here.");
      std.pairUIntUInt ret = EmitKeyDataLength(out, key, data);
      return wrap_uint_uint_pair(ret.first, ret.second);
    }
    public default std.pairUIntUInt EmitKeyDataLength(raw_ostream out, internal_key_type key, data_type data) {
      throw new UnsupportedOperationException("EmitKeyDataLength must be implemented:" + this.getClass() + ". Forgot to remove static?");
    }

    public default void EmitKey(raw_ostream out, internal_key_type key, int sizeof) {
      throw new UnsupportedOperationException("EmitKey must be implemented:" + this.getClass() + ". Forgot to remove static?");
    }

    public default void EmitData(raw_ostream out, internal_key_type key, data_type data, int sizeof) {
      throw new UnsupportedOperationException("EmitData must be implemented:" + this.getClass() + ". Forgot to remove static?");
    }
    
    public default void EmitFileRef(raw_ostream OutStream, file_type/*P*/ FileRef) {
      throw new UnsupportedOperationException("EmitFileRef must be implemented:" + this.getClass() + ". Forgot to remove static?");
    }
    
    @Override
    public default boolean EqualKey(internal_key_type a, internal_key_type b) {
      throw new UnsupportedOperationException("Should be implemented for EmitInfoInterface if 'contains' need to be supported " + this.getClass());
    }   
    
    public default /*const*/char$ptr/*char P*/ strings_begin() /*const*/ {
      throw new UnsupportedOperationException("Should be implemented for EmitInfoInterface in " + this.getClass());
    }   

    public default /*const*/char$ptr/*char P*/ strings_end() /*const*/ {
      throw new UnsupportedOperationException("Should be implemented for EmitInfoInterface in " + this.getClass());
    }   

    public default void $destroy() {
      throw new UnsupportedOperationException("Should be implemented for EmitInfoInterface in " + this.getClass());
    }
    
    // Read methods in fact are not provided by Emit interface
    @Override
    public default data_type ReadData(internal_key_type key, char$ptr data, int OffsetInBuf, int len) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }

    @Override
    public default data_type ReadData(internal_key_type key, char$ptr Buf, int DataLength) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }

    @Override
    public default internal_key_type GetInternalKey(Void eKey) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }

    @Override
    public default Void GetExternalKey(internal_key_type x) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }

    @Override
    public default /*std.pair<uint, uint>*/long ReadKeyDataLength(char$ptr d, int OffsetInBuf) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }
    @Override
    public default /*uint*/int getReadKeyDataLengthBytes() {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }

    @Override
    public default pairUIntUInt ReadKeyDataLength(char$ptr Buf) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }

    @Override
    public default internal_key_type ReadKey(char$ptr d, int OffsetInBuf, int var) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }

    @Override
    public default internal_key_type ReadKey(char$ptr Buf, int KeyLength) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }

    @Override
    public default <file_type> file_type ReadFileRef(char$ptr Buf) {
      throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
    }
  }  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumBuckets=" + NumBuckets // NOI18N
              + ", NumEntries=" + NumEntries // NOI18N
              + ", BA=" + BA // NOI18N
              + ", Buckets=" + Buckets; // NOI18N
  }  
}
