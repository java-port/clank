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

import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.$ushort2uint;
import static org.llvm.support.llvm.support.*;
import static org.llvm.support.llvm.support.endianness.*;

// JAVA: Info template param was decomposed into "external_key_type, internal_key_type, data_type" triple
// because we can not access types like Info.offset_type in Java
// Info.offset_type itself is considered to be uint32, so replaced everywhere
// Info.hash_value_type is considered to be uint32_t as well

/// \brief Provides lookup on an on disk hash table.
///
/// This needs an \c Info that handles reading values from the hash table's
/// payload and computes the hash for a given key. This should provide the
/// following interface:
///
/// \code
/// class ExampleLookupInfo {
/// public:
///   typedef ExampleData data_type;
///   typedef ExampleInternalKey internal_key_type; // The stored key type.
///   typedef ExampleKey external_key_type; // The type to pass to find().
///   typedef uint32_t hash_value_type; // The type the hash function returns.
///   typedef uint32_t offset_type; // The type for offsets into the table.
///
///   /// Compare two keys for equality.
///   static bool EqualKey(internal_key_type &Key1, internal_key_type &Key2);
///   /// Calculate the hash for the given key.
///   static hash_value_type ComputeHash(internal_key_type &IKey);
///   /// Translate from the semantic type of a key in the hash table to the
///   /// type that is actually stored and used for hashing and comparisons.
///   /// The internal and external types are often the same, in which case this
///   /// can simply return the passed in value.
///   static const internal_key_type &GetInternalKey(external_key_type &EKey);
///   /// Read the key and data length from Buffer, leaving it pointing at the
///   /// following byte.
///   static std::pair<offset_type, offset_type>
///   ReadKeyDataLength(const unsigned char *&Buffer);
///   /// Read the key from Buffer, given the KeyLen as reported from
///   /// ReadKeyDataLength.
///   const internal_key_type &ReadKey(const unsigned char *Buffer,
///                                    offset_type KeyLen);
///   /// Read the data for Key from Buffer, given the DataLen as reported from
///   /// ReadKeyDataLength.
///   data_type ReadData(StringRef Key, const unsigned char *Buffer,
///                      offset_type DataLen);
/// };
/// \endcode
/*template <typename Info> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 274,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 258,
 FQN="llvm::OnDiskChainedHashTable", NM="_ZN4llvm22OnDiskChainedHashTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTableE")
//</editor-fold>
public class OnDiskChainedHashTable<external_key_type, internal_key_type, data_type>  {
  protected final/*const*//*uint*/int NumBuckets;
  protected final/*const*//*uint*/int NumEntries;
  protected final/*const*/char$ptr/*uchar P*//*const*/ Buckets;
  protected final/*const*/char$ptr/*uchar P*//*const*/ Base;
  protected final InfoInterface<external_key_type, internal_key_type, data_type> InfoObj;
/*public:*/
  // JAVA: typedef Info InfoType
//  public final class InfoType extends Info{ };
  // JAVA: typedef typename Info::internal_key_type internal_key_type
//  public final class internal_key_type extends  Info.internal_key_type{ };
  // JAVA: typedef typename Info::external_key_type external_key_type
//  public final class external_key_type extends  Info.external_key_type{ };
  // JAVA: typedef typename Info::data_type data_type
//  public final class data_type extends  Info.data_type{ };
  // JAVA: typedef typename Info::hash_value_type hash_value_type
//  public final class hash_value_type extends  Info.hash_value_type{ };
  // JAVA: typedef typename Info::offset_type offset_type
//  public final class offset_type extends  Info.offset_type{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::OnDiskChainedHashTable<Info>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 289,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 273,
   FQN="llvm::OnDiskChainedHashTable::OnDiskChainedHashTable<Info>", NM="_ZN4llvm22OnDiskChainedHashTableC1ENT_11offset_typeES2_PKhS4_RKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTableC1ENT_11offset_typeES2_PKhS4_RKS1_")
  //</editor-fold>
//  public OnDiskChainedHashTable( Info.offset_type NumBuckets,  Info.offset_type NumEntries, 
//      /*const*/char$ptr/*uchar P*/ Buckets, 
//      /*const*/char$ptr/*uchar P*/ Base) {
//    this(NumBuckets, NumEntries, 
//      Buckets, 
//      Base, 
//      Info());
//  }  
  public OnDiskChainedHashTable(/*uint*/int NumBuckets, /*uint*/int NumEntries, 
      /*const*/char$ptr/*uchar P*/ Buckets, 
      /*const*/char$ptr/*uchar P*/ Base, 
      /*const*/InfoInterface<external_key_type, internal_key_type, data_type> /*&*/ InfoObj/*= Info()*/) {
    /* : NumBuckets(NumBuckets), NumEntries(NumEntries), Buckets(Buckets), Base(Base), InfoObj(InfoObj)*/ 
    //START JInit
    this.NumBuckets = NumBuckets;
    this.NumEntries = NumEntries;
    this.Buckets = $toConst(Buckets);
    this.Base = $toConst(Base);
    this.InfoObj = InfoObj;
    //END JInit
    assert InfoObj != null;
    assert ((Buckets.$index() & 0x3) == 0) : "'buckets' must have a 4-byte alignment";
  }

  
  /// Read the number of buckets and the number of entries from a hash table
  /// produced by OnDiskHashTableGenerator::Emit, and advance the Buckets
  /// pointer past them.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::readNumBucketsAndEntries">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 302,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 286,
   FQN="llvm::OnDiskChainedHashTable::readNumBucketsAndEntries", NM="_ZN4llvm22OnDiskChainedHashTable24readNumBucketsAndEntriesERPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTable24readNumBucketsAndEntriesERPKh")
  //</editor-fold>
  public static /*<typename Info>*/ long/*std.pair< Info.offset_type,  Info.offset_type>*/readNumBucketsAndEntries(final char$ptr/*const uchar P&*/ Buckets) {
//    assert ((reinterpret_cast_Object/*uintptr_t*/(Buckets) & 0x3) == 0) : "buckets should be 4-byte aligned.";
      assert ((Buckets.$index() & 0x3) == 0) : "'buckets' must have a 4-byte alignment";
    //JAVA: using namespace llvm::support;
    // JAVA: hopefully Info.offset_type is uint32, otherwise move this method into InfoInterface and implement it there
     /*Info.offset_type*/int NumBuckets = endian./*<Info.offset_type, endianness.little, aligned>*/readNext_uint32(endianness.little, aligned, Buckets);
     /*Info.offset_type*/int NumEntries = endian./*<Info.offset_type, endianness.little, aligned>*/readNext_uint32(endianness.little, aligned, Buckets);
    return wrap_uint_uint_pair(NumBuckets, NumEntries);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::getNumBuckets">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 314,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 298,
   FQN="llvm::OnDiskChainedHashTable::getNumBuckets", NM="_ZNK4llvm22OnDiskChainedHashTable13getNumBucketsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable13getNumBucketsEv")
  //</editor-fold>
  public /*Info.offset_type*/ /*uint*/int getNumBuckets() /*const*/ {
    return NumBuckets;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::getNumEntries">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 315,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 299,
   FQN="llvm::OnDiskChainedHashTable::getNumEntries", NM="_ZNK4llvm22OnDiskChainedHashTable13getNumEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable13getNumEntriesEv")
  //</editor-fold>
  public /*Info.offset_type*/ /*uint*/int getNumEntries() /*const*/ {
    return NumEntries;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 316,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 300,
   FQN="llvm::OnDiskChainedHashTable::getBase", NM="_ZNK4llvm22OnDiskChainedHashTable7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable7getBaseEv")
  //</editor-fold>
  public /*const*/char$ptr/*uchar P*/ getBase() /*const*/ {
    return Base;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::getBuckets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 301,
   FQN="llvm::OnDiskChainedHashTable::getBuckets", NM="_ZNK4llvm22OnDiskChainedHashTable10getBucketsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable10getBucketsEv")
  //</editor-fold>
  public /*const*/char$ptr/*uchar P*/ getBuckets() /*const*/ {
    return Buckets;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::isEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 303,
   FQN="llvm::OnDiskChainedHashTable::isEmpty", NM="_ZNK4llvm22OnDiskChainedHashTable7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return NumEntries == 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 321,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 305,
   FQN="llvm::OnDiskChainedHashTable::iterator", NM="_ZN4llvm22OnDiskChainedHashTable8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTable8iteratorE")
  //</editor-fold>
  public static final class iterator<external_key_type, internal_key_type, data_type> implements Native.NativeComparable<iterator> {
    private final internal_key_type Key;
    private final/*const*/char$ptr/*uchar P*//*const*/ Data$Base;
    private final/*const*/int Data$StartOffset;
    private final /*const*/ /*Info.offset_type*/ /*uint*/int Len;
    private final InfoInterface<external_key_type, internal_key_type, data_type> /*P*/ InfoObj;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::iterator::iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 328,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 312,
     FQN="llvm::OnDiskChainedHashTable::iterator::iterator", NM="_ZN4llvm22OnDiskChainedHashTable8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTable8iteratorC1Ev")
    //</editor-fold>
    private iterator() {
      /* : Data(null), Len(0)*/ 
      //START JInit
      this.Key = null;
      this.Data$Base = null;
      this.Data$StartOffset = 0;
      this.Len = 0;
      this.InfoObj = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::iterator::iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 329,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 313,
     FQN="llvm::OnDiskChainedHashTable::iterator::iterator", NM="_ZN4llvm22OnDiskChainedHashTable8iteratorC1ENT_17internal_key_typeEPKhNS2_11offset_typeEPS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTable8iteratorC1ENT_17internal_key_typeEPKhNS2_11offset_typeEPS2_")
    //</editor-fold>
    public iterator(/*const*/internal_key_type K, /*const*/char$ptr/*uchar P*/ D, int DOffset, /*Info.offset_type*//*uint*/int L, 
        InfoInterface<external_key_type, internal_key_type, data_type> /*P*/ InfoObj) {
      /* : Key(K), Data(D), Len(L), InfoObj(InfoObj)*/ 
      //START JInit
      this.Key = K;
      this.Data$Base = $toConst(D);
      this.Data$StartOffset = DOffset;
      this.Len = L;
      this.InfoObj = InfoObj;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 333,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 317,
     FQN="llvm::OnDiskChainedHashTable::iterator::operator*", NM="_ZNK4llvm22OnDiskChainedHashTable8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable8iteratordeEv")
    //</editor-fold>
    public data_type $star() /*const*/ {
      return InfoObj.ReadData(Key, Data$Base, Data$StartOffset, Len);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::iterator::getDataPtr">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 335,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 319,
     FQN="llvm::OnDiskChainedHashTable::iterator::getDataPtr", NM="_ZNK4llvm22OnDiskChainedHashTable8iterator10getDataPtrEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable8iterator10getDataPtrEv")
    //</editor-fold>
    public /*const*/char$ptr/*uchar P*/ getDataPtr() /*const*/ {
      NativeTrace.assertTrueInConsole(false, "Try to use faster getDataPtr*Base and getDataPtr$Offset");
      return Data$StartOffset == 0 ? Data$Base : Data$Base.$add(Data$StartOffset);
    }
    public /*const*/char$ptr/*uchar P*/ getDataPtr$Base() /*const*/ {
      return Data$Base;
    }
    public /*const*/int/*uchar P*/ getDataPtr$Offset() /*const*/ {
      return Data$StartOffset;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::iterator::getDataLen">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 336,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 320,
     FQN="llvm::OnDiskChainedHashTable::iterator::getDataLen", NM="_ZNK4llvm22OnDiskChainedHashTable8iterator10getDataLenEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable8iterator10getDataLenEv")
    //</editor-fold>
    public  /*Info.offset_type*//*uint*/int getDataLen() /*const*/ {
      return Len;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::iterator::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 338,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 322,
     FQN="llvm::OnDiskChainedHashTable::iterator::operator==", NM="_ZNK4llvm22OnDiskChainedHashTable8iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable8iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ iterator /*&*/ X) /*const*/ {
      return Native.$eq_ptr(X.Data$Base, Data$Base);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::iterator::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 339,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 323,
     FQN="llvm::OnDiskChainedHashTable::iterator::operator!=", NM="_ZNK4llvm22OnDiskChainedHashTable8iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable8iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ iterator /*&*/ X) /*const*/ {
      return Native.$noteq_ptr(X.Data$Base, Data$Base);
    }

    
    @Override public String toString() {
      if (Key == null && Data$Base == null && Len == 0 && InfoObj == null) {
        return "<End>";// NOI18N
      }
      return "" + "Key=" + Key // NOI18N
                + ", Data=" + Data$Base.$add(Data$StartOffset) // NOI18N
                + ", Len=" + Len // NOI18N
                + ", InfoObj=" + InfoObj; // NOI18N
    }
  };
  
  /// \brief Look up the stored data for a particular key.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::find">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 327,
   FQN="llvm::OnDiskChainedHashTable::find", NM="_ZN4llvm22OnDiskChainedHashTable4findERKNT_17external_key_typeEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTable4findERKNT_17external_key_typeEPS1_")
  //</editor-fold>
  public iterator find(final /*const*/external_key_type /*&*/ EKey) {
    return find(EKey, InfoObj);
  }
  public iterator find(final /*const*/external_key_type /*&*/ EKey, InfoInterface<external_key_type, internal_key_type, data_type> /*P*/ InfoPtr/*= null*/) {
    NativeTrace.assertTrueInConsole(false, "Not Optimized version. Could $get(...) be used instead?", this.getClass());
    assert InfoPtr != null;
    
    //JAVA: using namespace llvm::support;
    final /*const*/ /*Info.*/internal_key_type /*&*/ IKey = InfoObj.GetInternalKey(EKey);
    /*Info.hash_value_type*/int KeyHash = InfoObj.ComputeHash(IKey);
    return find_hashed(IKey, KeyHash, InfoPtr);
  }
  
  
  /// \brief Look up the stored data for a particular key with a known hash.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::find_hashed">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 350,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 334,
   FQN="llvm::OnDiskChainedHashTable::find_hashed", NM="_ZN4llvm22OnDiskChainedHashTable11find_hashedERKNT_17internal_key_typeENS1_15hash_value_typeEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTable11find_hashedERKNT_17internal_key_typeENS1_15hash_value_typeEPS1_")
  //</editor-fold>
  public iterator find_hashed(final /*const*/  /*Info.*/internal_key_type /*&*/ IKey,  /*Info.hash_value_type*//*uint32_t*/int KeyHash) {
    return find_hashed(IKey, KeyHash, 
             InfoObj);
  }
  public iterator find_hashed(final /*const*/  /*Info.*/internal_key_type /*&*/ IKey,  /*Info.hash_value_type*//*uint32_t*/int KeyHash, 
             InfoInterface<external_key_type, internal_key_type, data_type> /*P*/ InfoPtr/*= null*/) {
    // JAVA:
//    if (InfoPtr.Native.$not(())) {
//      InfoPtr = $AddrOf(InfoObj);
//    } 
    assert InfoPtr != null;
    
    // Each bucket is just an offset into the hash table file.
    /*Info.offset_type*/int Idx = KeyHash & (NumBuckets - 1);
    assert Idx >= 0 : "negative " + Idx + " for " + KeyHash + " with " + NumBuckets;
    ///*const*/char$ptr/*uchar P*/ Bucket = Native.$add(Buckets, Native.$star($sizeof_Offset_type(), Idx));
    /*const*/int/*uchar P*/ Bucket = /*Buckets.$add*/($sizeof_Offset_type() * Idx);
    
    /*uint*/int Offset = endian.read_uint32(little, aligned, Buckets, Bucket);
                                //Bucket += $sizeof_Offset_type();//shift index
    if (Offset == 0) {
      return end(); // Empty bucket.
    }
    /*const*/int/*uchar P*/ Items = /*Base.$add*/(Offset);
    
    // 'Items' starts with a 16-bit unsigned integer representing the
    // number of items in this bucket.
    /*uint*/int Len = $ushort2uint(endian.read_uint16(little, unaligned, Base, Items));
                              Items+=sizeof$uint16();//shift index
    for (/*uint*/int i = 0; i < Len; ++i) {
      // Read the hash.
      /*Info.hash_value_type*/int ItemHash = endian.read_uint32(little, unaligned, Base, Items);
                                        Items+=$sizeof_Hash_Value_type();//shift index
      // Determine the length of the key and the data.
      final /*const*//*std.pair<uint, uint>*/long/*&*/ L = InfoPtr.ReadKeyDataLength(Base, Items);
      Items += /*$inc*/(InfoPtr.getReadKeyDataLengthBytes());//shift index
      int KeyLen = $first_uint(L);
      int DataLen = $second_uint(L);
      /*uint*/int ItemLen = KeyLen + DataLen;
      
      // Compare the hashes.  If they are not the same, skip the entry entirely.
      if (ItemHash != KeyHash) {
        Items += /*$inc*/(ItemLen);
        continue;
      }
      
      // Read the key.
      final /*const*/ /*Info.*/internal_key_type /*&*/ X = InfoPtr.ReadKey(Base, Items, KeyLen);
      
      // If the key doesn't match just skip reading the value.
      if (!InfoPtr.EqualKey(X, IKey)) {
        Items += /*$inc*/(ItemLen);//shift index
        continue;
      }
      
      // The key matches!
      // return iterator(X, Native.$add(Items, L.first), L.second, InfoPtr);
      return new iterator(X, Base, Items + KeyLen, DataLen, InfoPtr);
    }
    
    return end();
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 403,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 387,
   FQN="llvm::OnDiskChainedHashTable::end", NM="_ZNK4llvm22OnDiskChainedHashTable3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm22OnDiskChainedHashTable3endEv")
  //</editor-fold>
  public iterator end() /*const*/ {
    return END_ITERATOR;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::getInfoObj">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 405,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 389,
   FQN="llvm::OnDiskChainedHashTable::getInfoObj", NM="_ZN4llvm22OnDiskChainedHashTable10getInfoObjEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTable10getInfoObjEv")
  //</editor-fold>
  public final InfoInterface<external_key_type, internal_key_type, data_type>/*&*/ getInfoObj() {
    return InfoObj;
  }

  
  /// \brief Create the hash table.
  ///
  /// \param Buckets is the beginning of the hash table itself, which follows
  /// the payload of entire structure. This is the value returned by
  /// OnDiskHashTableGenerator::Emit.
  ///
  /// \param Base is the point from which all offsets into the structure are
  /// based. This is offset 0 in the stream that was used when Emitting the
  /// table.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskChainedHashTable::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 416,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 400,
   FQN="llvm::OnDiskChainedHashTable::Create", NM="_ZN4llvm22OnDiskChainedHashTable6CreateEPKhS2_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm22OnDiskChainedHashTable6CreateEPKhS2_RKT_")
  //</editor-fold>
//  public static OnDiskChainedHashTable<Info> /*P*/ Create(/*const*/char$ptr/*uchar P*/ Buckets, 
//        /*const*/char$ptr/*uchar P*//*const*/ Base) {
//    return Create(Buckets, 
//        Base, 
//        Info());
//  }
  public static <Info extends InfoInterface<external_key_type, internal_key_type, data_type>, 
                 external_key_type, internal_key_type, data_type> 
                  OnDiskChainedHashTable<external_key_type, internal_key_type, data_type> /*P*/ 
        Create(/*const*/char$ptr/*uchar P*/ Buckets, 
        /*const*/char$ptr/*uchar P*//*const*/ Base, 
        final /*const*/ Info /*&*/ InfoObj/*= Info()*/) {
    // JAVA:
    assert InfoObj != null;
    //JAVA: using namespace llvm::support;
    assert (Buckets.$greater(Base)) : Buckets.$index() + " vs. " + Base.$index() + ":" + Base;
    
    long/*std.pair< Info.offset_type,  Info.offset_type>*/ NumBucketsAndEntries = OnDiskChainedHashTable.readNumBucketsAndEntries(Buckets);
    return new OnDiskChainedHashTable($first_uint(NumBucketsAndEntries), $second_uint(NumBucketsAndEntries), $noClone(Buckets), $noClone(Base), InfoObj);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
        
  private final static iterator END_ITERATOR = new iterator();
  
  public static int $sizeof_Offset_type() { 
    return sizeof$uint32();
  }
  public static int $sizeof_Hash_Value_type() {
    return sizeof$uint32();
  }
  
  public static interface InfoInterface<external_key_type, internal_key_type, data_type> {
    // returns <Key-Length, Data-Length> information
    // Buf is const and must NOT be shifted;
    // Use getReadKeyDataLengthBytes when interested how many bytes were read!
    default /*std.pair<uint, uint>*/long ReadKeyDataLength(/*const uchar P&*/char$ptr Buf, int OffsetInBuf) {
      NativeTrace.assertTrueInConsole(false, "Must be implemented for faster reads:", this.getClass());
      Buf = Buf.$add(OffsetInBuf);
      std.pairUIntUInt out = ReadKeyDataLength(Buf);
      assert Buf.$index() - OffsetInBuf == getReadKeyDataLengthBytes() : "expected to read " + getReadKeyDataLengthBytes() + ", but in reality shifted by " + (Buf.$index() - OffsetInBuf) + " from " + OffsetInBuf;
      return wrap_uint_uint_pair(out.first, out.second);
    }
    default /*uint*/int getReadKeyDataLengthBytes() {
      throw new UnsupportedOperationException("This methods must be implemented together with ReadKeyDataLength(Buf, OffsetInBuf) to return how many bytes were read without shifting:" + this.getClass());
    }
    
    // this method usually is implemented by default as static (shifts Buf pointer by using readNext)
    default std.pairUIntUInt ReadKeyDataLength(/*const uchar P&*/char$ptr Buf) {
      throw new UnsupportedOperationException("ReadKeyDataLength(Buf, OffsetInBuf) or ReadKeyDataLength(Buf) must be implemented:" + this.getClass() + ". Forgot to remove static?");
    }
    
    // reads Key from Buf stream; KeyLength specifies number of bytes used by Key in stream
    // Buf is const and must NOT be shifted, usually readNext is replaced by read method
    default internal_key_type ReadKey(char$ptr Buf, int OffsetInBuf, int KeyLength) {
      NativeTrace.assertTrueInConsole(false, "Must be implemented for faster reads:", this.getClass());
      Buf = Buf.$add(OffsetInBuf);
      internal_key_type out = ReadKey(Buf, KeyLength);
      assert Buf.$index() - OffsetInBuf == getReadKeyDataLengthBytes() : "expected to read " + getReadKeyDataLengthBytes() + ", but in reality shifted by " + (Buf.$index() - OffsetInBuf) + " from " + OffsetInBuf;
      return out;
    }
    // this method usually is implemented by default as static (Buf pointer is not shifted after call)
    default internal_key_type ReadKey(char$ptr Buf, int KeyLength) {
      throw new UnsupportedOperationException("ReadKey(Buf, OffsetInBuf, KeyLength) or ReadKey(Buf, KeyLength) must be implemented:" + this.getClass() + ". Forgot to remove static?");
    }
    
    // reads Data from Buf stream; DataLength specifies number of bytes used by Data in stream
    // Buf is const and must NOT be shifted
    default data_type ReadData(internal_key_type key, char$ptr Buf, int OffsetInBuf, int DataLength) {
      NativeTrace.assertTrueInConsole(false, "Must be implemented for faster reads:", this.getClass());
      Buf = Buf.$add(OffsetInBuf);
      data_type out = ReadData(key, Buf, DataLength);
      assert Buf.$index() - OffsetInBuf == DataLength : "expected to read " + DataLength + ", but in reality shifted by " + (Buf.$index() - OffsetInBuf) + " from " + OffsetInBuf;
      return out;
    }
    // this method usually is implemented by default as static (shifts Buf pointer by using readNext)
    default data_type ReadData(internal_key_type key, char$ptr Buf, int DataLength) {
      throw new UnsupportedOperationException("ReadData(key, Buf, OffsetInBuf, DataLength) or ReadData(key, Buf, OffsetInBuf, DataLength) must be implemented:" + this.getClass() + ". Forgot to remove static?");
    }
    
    // this method usually is implemented by default as static
    default <file_type> file_type ReadFileRef(final char$ptr/*const uchar P&*/ Buf) {
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
    }
    
    // this method usually is implemented by default as static 
    default internal_key_type GetInternalKey(external_key_type eKey) {
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
    }
    
    // this method usually is implemented by default as static 
    default external_key_type GetExternalKey(internal_key_type x) {
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
    }
    
    // this method usually is implemented by default as static 
    default /*uint32_t*/int ComputeHash(internal_key_type iKey) {
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
    }
    
    // this method usually is implemented by default as static 
    default boolean EqualKey(internal_key_type a, internal_key_type b) {
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
    }
  }
  
  // PERF: method to directly read data by key vs access through interator. This is the copy of find with inlined find_hashed
  public final data_type $get(/*const*/external_key_type /*&*/ EKey) {
    return $get(EKey, InfoObj);
  }
  public final data_type $get(/*const*/external_key_type /*&*/ EKey, InfoInterface<external_key_type, internal_key_type, data_type> /*P*/ InfoPtr/*= 0*/) {
    assert InfoPtr != null;
    
    //JAVA: using namespace llvm::support;
    /*const*/internal_key_type /*&*/ IKey = InfoPtr.GetInternalKey(EKey);
    /*uint32_t*/int KeyHash = InfoPtr.ComputeHash(IKey);
    
    // Each bucket is just an offset into the hash table file.
    /*uint*/int Idx = KeyHash & (NumBuckets - 1);
    assert Idx >= 0 : "negative " + Idx + " for " + KeyHash + " with " + NumBuckets;
    /*const*/int/*uchar P*/ Bucket = /*Buckets.$add*/($sizeof_Offset_type() * Idx);
    
    /*uint*/int Offset = endian.read_uint32(little, aligned, Buckets, Bucket);
                                // Bucket+=$sizeof_Offset_type();
    if (Offset == 0) {
      return null; // Empty bucket.
    }
    /*const*/int/*uchar P*/ Items = /*Base.$add*/(Offset);
    
    // 'Items' starts with a 16-bit unsigned integer representing the
    // number of items in this bucket.
    /*uint*/int Len = endian.read_uint16(little, unaligned, Base, Items);
                             Items+=sizeof$uint16();//shift index
                             
    for (/*uint*/int i = 0; i < Len; ++i) {
      // Read the hash.
      /*uint32_t*/int ItemHash = endian.read_uint32(little, unaligned, Base, Items);
                                        Items += $sizeof_Hash_Value_type();//shift index
      // Determine the length of the key and the data.
      /*const*//*std.pair<uint, uint>*/long/*&*/ L = InfoPtr.ReadKeyDataLength(Base, Items);
      Items += /*$inc*/(InfoPtr.getReadKeyDataLengthBytes());
      int KeyLen = $first_int(L);
      int DataLen = $second_int(L);
      /*uint*/int ItemLen = KeyLen + DataLen;
      
      // Compare the hashes.  If they are not the same, skip the entry entirely.
      if (ItemHash != KeyHash) {
        Items += /*$inc*/(ItemLen); // shift index
        continue;
      }
      
      // Read the key.
      /*const*/internal_key_type /*&*/ X = InfoPtr.ReadKey(Base, Items, KeyLen);
      
      // If the key doesn't match just skip reading the value.
      if (!InfoPtr.EqualKey(X, IKey)) {
        Items += /*$inc*/(ItemLen); // shift index
        continue;
      }
      
      // The key matches!
      return InfoPtr.ReadData(X, Base, Items += /*$inc*/KeyLen, DataLen);
    }
    
    return null;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumBuckets=" + NumBuckets // NOI18N
              + ", NumEntries=" + NumEntries // NOI18N
              + ", Buckets=[" + NativeTrace.getIdentityStr(Buckets) // NOI18N
              + "], Base=[" + NativeTrace.getIdentityStr(Base) // NOI18N
              + "], InfoObj=" + NativeTrace.getIdentityStr(InfoObj); // NOI18N
  }
}
