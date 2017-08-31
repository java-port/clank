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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.support.llvm.support.endian;
import static org.llvm.support.llvm.support.endianness.*;
import static org.llvm.support.llvm.support.*;

// JAVA: see comment about Info template param in OnDiskChainedHashTable

/// \brief Provides lookup and iteration over an on disk hash table.
///
/// \copydetails llvm::OnDiskChainedHashTable
/*template <typename Info> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 430,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 414,
 FQN="llvm::OnDiskIterableChainedHashTable", NM="_ZN4llvm30OnDiskIterableChainedHashTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTableE")
//</editor-fold>
public class OnDiskIterableChainedHashTable<external_key_type, internal_key_type, data_type>
        extends /*public*/ OnDiskChainedHashTable<external_key_type, internal_key_type, data_type> {
  private final/*const*/char$ptr/*uchar P*/ Payload;
/*public:*/
  // JAVA: typedef OnDiskChainedHashTable<Info> base_type
//  public final class base_type extends OnDiskChainedHashTable<Info>{ };
  // JAVA: typedef typename base_type::internal_key_type internal_key_type
//  public final class internal_key_type extends  OnDiskChainedHashTable.internal_key_type<Info>{ };
  // JAVA: typedef typename base_type::external_key_type external_key_type
//  public final class external_key_type extends  OnDiskChainedHashTable.external_key_type<Info>{ };
  // JAVA: typedef typename base_type::data_type data_type
//  public final class data_type extends  OnDiskChainedHashTable.data_type<Info>{ };
  // JAVA: typedef typename base_type::hash_value_type hash_value_type
//  public final class hash_value_type extends  OnDiskChainedHashTable.hash_value_type<Info>{ };
  // JAVA: typedef typename base_type::offset_type offset_type
//  public final class offset_type extends  OnDiskChainedHashTable.offset_type<Info>{ };
/*private:*/
  /// \brief Iterates over all of the keys in the table.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::iterator_base">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 444,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 428,
   FQN="llvm::OnDiskIterableChainedHashTable::iterator_base", NM="_ZN4llvm30OnDiskIterableChainedHashTable13iterator_baseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13iterator_baseE")
  //</editor-fold>
  public static class iterator_base {
    protected final /*const*/char$ptr/*uchar P*/ $Ptr; // JAVA: base for pointer, we don't move it, but Ptr index instead
    private /*const*/int/*uchar P*/ Ptr;
    private /*OnDiskChainedHashTable.offset_type<Info>*/int NumItemsInBucketLeft;
    private /*OnDiskChainedHashTable.offset_type<Info>*/int NumEntriesLeft;
    
  /*public:*/
    // JAVA: typedef external_key_type value_type
//    public final class value_type extends  OnDiskChainedHashTable.external_key_type<Info>{ };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::iterator_base::iterator_base">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 452,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 436,
     FQN="llvm::OnDiskIterableChainedHashTable::iterator_base::iterator_base", NM="_ZN4llvm30OnDiskIterableChainedHashTable13iterator_baseC1EPKhNS_22OnDiskChainedHashTableIT_E11offset_typeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13iterator_baseC1EPKhNS_22OnDiskChainedHashTableIT_E11offset_typeE")
    //</editor-fold>
    public iterator_base(/*const*/char$ptr/*uchar P*//*const*/ Ptr, /*uint*/int $PtrOffset, /*OnDiskChainedHashTable.offset_type<Info>*/int NumEntries) {
      // : Ptr(Ptr), NumItemsInBucketLeft(0), NumEntriesLeft(NumEntries) 
      this.$Ptr = $toConst(Ptr);
      //START JInit
      this.Ptr = $PtrOffset;
      this.NumItemsInBucketLeft = /*ParenListExpr OnDiskChainedHashTable.offset_type<Info>*/ 0;
      this.NumEntriesLeft = /*ParenListExpr OnDiskChainedHashTable.offset_type<Info>*/ NumEntries;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::iterator_base::iterator_base">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 454,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 438,
     FQN="llvm::OnDiskIterableChainedHashTable::iterator_base::iterator_base", NM="_ZN4llvm30OnDiskIterableChainedHashTable13iterator_baseC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13iterator_baseC1Ev")
    //</editor-fold>
    public iterator_base() {
      // : Ptr(null), NumItemsInBucketLeft(0), NumEntriesLeft(0) 
      this.$Ptr = null;
      //START JInit
      this.Ptr = 0;
      this.NumItemsInBucketLeft = /*ParenListExpr OnDiskChainedHashTable.offset_type<Info>*/ 0;
      this.NumEntriesLeft = /*ParenListExpr OnDiskChainedHashTable.offset_type<Info>*/ 0;
      //END JInit
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 457,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 441,
     FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_30OnDiskIterableChainedHashTable13iterator_baseES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvmeqERKNS_30OnDiskIterableChainedHashTable13iterator_baseES3_")
    //</editor-fold>
    public static boolean $eq_iterator_base$C(final /*const*/ OnDiskIterableChainedHashTable.iterator_base /*&*/ X, final /*const*/ OnDiskIterableChainedHashTable.iterator_base /*&*/ Y) {
      return Native.$eq(X.NumEntriesLeft, Y.NumEntriesLeft);
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 460,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 444,
     FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_30OnDiskIterableChainedHashTable13iterator_baseES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvmneERKNS_30OnDiskIterableChainedHashTable13iterator_baseES3_")
    //</editor-fold>
    public static boolean $noteq_iterator_base$C(final /*const*/ OnDiskIterableChainedHashTable.iterator_base /*&*/ X, final /*const*/ OnDiskIterableChainedHashTable.iterator_base /*&*/ Y) {
      return Native.$noteq(X.NumEntriesLeft, Y.NumEntriesLeft);
    }

    
    /// Move to the next item.
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::iterator_base::advance">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 465,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 449,
     FQN="llvm::OnDiskIterableChainedHashTable::iterator_base::advance", NM="_ZN4llvm30OnDiskIterableChainedHashTable13iterator_base7advanceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13iterator_base7advanceEv")
    //</editor-fold>
    protected void advance(InfoInterface<?, ?, ?> InfoObj) {
      // Preincrement
      //JAVA: using namespace llvm::support;
      if (Native.$not(NumItemsInBucketLeft)) {
        // 'Items' starts with a 16-bit unsigned integer representing the
        // number of items in this bucket.
        // JAVA: use read, not readNext, but shift Ptr index 
        NumItemsInBucketLeft = endian.read_uint16(little, unaligned, $Ptr, Ptr);
                    Ptr  += /*$inc*/sizeof$uint16(); // shift index
      }
      Ptr += /*$inc*/($sizeof_Hash_value_type$Info()); // Skip the hash.
      // Determine the length of the key and the data.
      /*const*//*std.pair<uint, uint>*/long /*&*/ L = InfoObj.ReadKeyDataLength($Ptr, Ptr);
      Ptr += /*$inc*/(InfoObj.getReadKeyDataLengthBytes()); // shift index after ReadKeyDataLength
      
      Ptr += /*$inc*/($first_uint(L) + $second_uint(L));
      assert Native.$bool(NumItemsInBucketLeft);
      --NumItemsInBucketLeft;
      assert Native.$bool(NumEntriesLeft);
      --NumEntriesLeft;
    }

    
    /// Get the start of the item as written by the trait (after the hash and
    /// immediately before the key and value length).
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::iterator_base::getItem">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 486,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 470,
     FQN="llvm::OnDiskIterableChainedHashTable::iterator_base::getItem", NM="_ZNK4llvm30OnDiskIterableChainedHashTable13iterator_base7getItemEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm30OnDiskIterableChainedHashTable13iterator_base7getItemEv")
    //</editor-fold>
    public /*const*/char$ptr/*uchar P*/ getItem() /*const*/ {
      return $Ptr.$add($getItem());
    }
    public /*const*/int/*uchar P*/ $getItem() /*const*/ {
//      return Native.$add(Native.$add(Ptr, (NumItemsInBucketLeft ? 0 : 2)), $sizeof_Hash_value_type$Info());
      /*const*/int/*uchar P*/ ItemPtr = Ptr;
      if (!(NumItemsInBucketLeft != 0)) {
        ItemPtr += /*$inc*/(2); // number of items in bucket
      }
      ItemPtr += /*$inc*/$sizeof_Hash_value_type$Info(); // Skip the hash.
      return ItemPtr;
    }

    public final char$ptr $PtrBase() {
      return $Ptr;
    }
    
    protected iterator_base(iterator_base $Prm0) {
      this.$Ptr = $Prm0.$Ptr;
      this.Ptr = $Prm0.Ptr;
      this.NumItemsInBucketLeft = $Prm0.NumItemsInBucketLeft;
      this.NumEntriesLeft = $Prm0.NumEntriesLeft;
    }

    protected iterator_base $assignMove(iterator_base $Prm0) {
      this.$Ptr.$assignMove($Prm0.$Ptr);
      this.Ptr = $Prm0.Ptr;
      this.NumItemsInBucketLeft = $Prm0.NumItemsInBucketLeft;
      this.NumEntriesLeft = $Prm0.NumEntriesLeft;
      return this;
    }
    
    @Override public String toString() {
      if ($Ptr == null) {
        return "<END>";
      }
      return "" + "Ptr=" + $Ptr.$add(Ptr) // NOI18N
                + ", NumItemsInBucketLeft=" + NumItemsInBucketLeft // NOI18N
                + ", NumEntriesLeft=" + NumEntriesLeft; // NOI18N
    }
  };  
/*public:*/  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::OnDiskIterableChainedHashTable<Info>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 492,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 476,
   FQN="llvm::OnDiskIterableChainedHashTable::OnDiskIterableChainedHashTable<Info>", NM="_ZN4llvm30OnDiskIterableChainedHashTableC1ENS_22OnDiskChainedHashTableIT_E11offset_typeES4_PKhS6_S6_RKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTableC1ENS_22OnDiskChainedHashTableIT_E11offset_typeES4_PKhS6_S6_RKS2_")
  //</editor-fold>
//  public OnDiskIterableChainedHashTable(/*uint*/int NumBuckets, /*uint*/int NumEntries, 
//      /*const*/char$ptr/*uchar P*/ Buckets, 
//      /*const*/char$ptr/*uchar P*/ Payload, 
//      /*const*/char$ptr/*uchar P*/ Base) {
//    this(NumBuckets, NumEntries, 
//      Buckets, 
//      Payload, 
//      Base, 
//      Info());
//  }
  public OnDiskIterableChainedHashTable(/*uint*/int NumBuckets, /*uint*/int NumEntries, 
      /*const*/char$ptr/*uchar P*/ Buckets, 
      /*const*/char$ptr/*uchar P*/ Payload, 
      /*const*/char$ptr/*uchar P*/ Base, 
      /*const*/ InfoInterface<external_key_type, internal_key_type, data_type> /*&*/ InfoObj/*= Info()*/) {
    /* : base_type(NumBuckets, NumEntries, Buckets, Base, InfoObj), Payload(Payload)*/ 
    //START JInit
    super(NumBuckets, NumEntries, Buckets, Base, InfoObj);
    this.Payload = $toConst(Payload);
    //END JInit
  }

  
  /// \brief Iterates over all of the keys in the table.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 501,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 485,
   FQN="llvm::OnDiskIterableChainedHashTable::key_iterator", NM="_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorE")
  //</editor-fold>
  public static final class key_iterator<external_key_type, internal_key_type> extends iterator_base implements type$iterator<key_iterator<external_key_type, internal_key_type>, external_key_type> {
    private final InfoInterface<external_key_type, internal_key_type, ?> InfoObj;
  /*public:*/
    /*typedef external_key_type value_type*/
//    public final class value_type extends external_key_type{ };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_iterator::key_iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 507,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 491,
     FQN="llvm::OnDiskIterableChainedHashTable::key_iterator::key_iterator", NM="_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorC1EPKhNS_22OnDiskChainedHashTableIT_E11offset_typeEPS5_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorC1EPKhNS_22OnDiskChainedHashTableIT_E11offset_typeEPS5_")
    //</editor-fold>
    public key_iterator(/*const*/char$ptr/*uchar P*//*const*/ Ptr, /*uint*/int $PtrOffset, /*OnDiskChainedHashTable.offset_type<Info>*/int NumEntries, 
        InfoInterface<external_key_type, internal_key_type, ?> InfoObj) {
      // : iterator_base(Ptr, NumEntries), InfoObj(InfoObj) 
      //START JInit
      /*ParenListExpr*/super(Ptr, $PtrOffset, NumEntries);
      this.InfoObj = /*ParenListExpr*/InfoObj;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_iterator::key_iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 510,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 494,
     FQN="llvm::OnDiskIterableChainedHashTable::key_iterator::key_iterator", NM="_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorC1Ev")
    //</editor-fold>
    public key_iterator() {
      // : iterator_base(), InfoObj() 
      //START JInit
      /*ParenListExpr*/super();
      this.InfoObj = /*ParenListExpr*/null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 512,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 496,
     FQN="llvm::OnDiskIterableChainedHashTable::key_iterator::operator++", NM="_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorppEv")
    //</editor-fold>
    public key_iterator /*&*/ $preInc() {
      this.advance(this.InfoObj);
      return this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 516,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 500,
     FQN="llvm::OnDiskIterableChainedHashTable::key_iterator::operator++", NM="_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable12key_iteratorppEi")
    //</editor-fold>
    public key_iterator $postInc(int $Prm0) {
      // Postincrement
      key_iterator tmp = $Clone(this);
      this.$preInc();
      return tmp;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_iterator::getInternalKey">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 522,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 506,
     FQN="llvm::OnDiskIterableChainedHashTable::key_iterator::getInternalKey", NM="_ZNK4llvm30OnDiskIterableChainedHashTable12key_iterator14getInternalKeyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm30OnDiskIterableChainedHashTable12key_iterator14getInternalKeyEv")
    //</editor-fold>
    public  /*OnDiskChainedHashTable.*/internal_key_type/*<Info>*/ getInternalKey() /*const*/ {
      /*const*/int/*uchar P*/ /*P*/ LocalPtr = this.$getItem();
      
      // Determine the length of the key and the data.
      /*const*//*std.pair<uint, uint>*/long /*&*/ L = InfoObj.ReadKeyDataLength($Ptr, LocalPtr);
      LocalPtr += /*$inc*/(InfoObj.getReadKeyDataLengthBytes()); // shift by ReadKeyDataLength
      
      // Read the key.
      return InfoObj.ReadKey($Ptr, LocalPtr, $first_uint(L));
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 532,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 516,
     FQN="llvm::OnDiskIterableChainedHashTable::key_iterator::operator*", NM="_ZNK4llvm30OnDiskIterableChainedHashTable12key_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm30OnDiskIterableChainedHashTable12key_iteratordeEv")
    //</editor-fold>
    public /*OnDiskChainedHashTable.*/external_key_type/*<Info>*/ $star() /*const*/ {
      return InfoObj.GetExternalKey(getInternalKey());
    }
    
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    private key_iterator(key_iterator<external_key_type, internal_key_type> other) {
      super(other);
      this.InfoObj = other.InfoObj;
    }
    
    @Override public key_iterator<external_key_type, internal_key_type> clone() {
      return new key_iterator(this);
    }    

    @Override
    public boolean $eq(Object other) {
      return iterator_base.$eq_iterator_base$C(this, (key_iterator) other);
    }
    
    public key_iterator<external_key_type, internal_key_type> $assignMove(key_iterator<external_key_type, internal_key_type> other) {
      super.$assignMove(other);
      assert this.InfoObj == other.InfoObj;
      return this;
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "InfoObj=" + NativeTrace.getIdentityStr(InfoObj) // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 537,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 521,
   FQN="llvm::OnDiskIterableChainedHashTable::key_begin", NM="_ZN4llvm30OnDiskIterableChainedHashTable9key_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable9key_beginEv")
  //</editor-fold>
  public key_iterator<external_key_type, internal_key_type> key_begin() {
    return new key_iterator(Payload, 0, this.getNumEntries(), $AddrOf(this.getInfoObj()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::key_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 540,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 524,
   FQN="llvm::OnDiskIterableChainedHashTable::key_end", NM="_ZN4llvm30OnDiskIterableChainedHashTable7key_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable7key_endEv")
  //</editor-fold>
  public key_iterator<external_key_type, internal_key_type> key_end() {
    return KEY_END;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::keys">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 542,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 526,
   FQN="llvm::OnDiskIterableChainedHashTable::keys", NM="_ZN4llvm30OnDiskIterableChainedHashTable4keysEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable4keysEv")
  //</editor-fold>
  public iterator_range</* OnDiskChainedHashTable.*/external_key_type/*<Info>*/ > keys() {
    return llvm.make_range(key_begin(), key_end());
  }

  
  /// \brief Iterates over all the entries in the table, returning the data.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 547,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 531,
   FQN="llvm::OnDiskIterableChainedHashTable::data_iterator", NM="_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorE")
  //</editor-fold>
  public static final class data_iterator<internal_key_type, data_type> extends iterator_base implements type$iterator<data_iterator<internal_key_type, data_type>, data_type> {
    private final InfoInterface<?, internal_key_type, data_type> InfoObj;
    
  /*public:*/
    // JAVA: typedef data_type value_type
//    public final class value_type extends  OnDiskChainedHashTable.data_type<Info>{ };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data_iterator::data_iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 553,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 537,
     FQN="llvm::OnDiskIterableChainedHashTable::data_iterator::data_iterator", NM="_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorC1EPKhNS_22OnDiskChainedHashTableIT_E11offset_typeEPS5_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorC1EPKhNS_22OnDiskChainedHashTableIT_E11offset_typeEPS5_")
    //</editor-fold>
    public data_iterator(/*const*/char$ptr/*uchar P*//*const*/ Ptr, int $PtrOffset, /*OnDiskChainedHashTable.offset_type<Info>*/int NumEntries, 
        InfoInterface<?, internal_key_type, data_type>/*P*/ InfoObj) {
      // : iterator_base(Ptr, NumEntries), InfoObj(InfoObj) 
      //START JInit
      /*ParenListExpr*/super(Ptr, $PtrOffset, NumEntries);
      this.InfoObj = /*ParenListExpr*/InfoObj;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data_iterator::data_iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 556,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 540,
     FQN="llvm::OnDiskIterableChainedHashTable::data_iterator::data_iterator", NM="_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorC1Ev")
    //</editor-fold>
    public data_iterator() {
      // : iterator_base(), InfoObj() 
      //START JInit
      /*ParenListExpr*/super();
      this.InfoObj = /*ParenListExpr*/null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 558,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 542,
     FQN="llvm::OnDiskIterableChainedHashTable::data_iterator::operator++", NM="_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorppEv")
    //</editor-fold>
    public data_iterator<internal_key_type, data_type> /*&*/ $preInc() {
      // Preincrement
      this.advance(this.InfoObj);
      return this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 562,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 546,
     FQN="llvm::OnDiskIterableChainedHashTable::data_iterator::operator++", NM="_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable13data_iteratorppEi")
    //</editor-fold>
    public data_iterator<internal_key_type, data_type> $postInc(int $Prm0) {
      // Postincrement
      data_iterator tmp = $Clone(this);
      this.$preInc();
      return tmp;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data_iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 568,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 552,
     FQN="llvm::OnDiskIterableChainedHashTable::data_iterator::operator*", NM="_ZNK4llvm30OnDiskIterableChainedHashTable13data_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK4llvm30OnDiskIterableChainedHashTable13data_iteratordeEv")
    //</editor-fold>
    public /*OnDiskChainedHashTable.*/data_type/*<Info>*/ $star() /*const*/ {
      /*const*/int/*uchar P*/ LocalPtr = this.$getItem();
      
      // Determine the length of the key and the data.
      /*const*//*std.pair<uint, uint>*/long /*&*/ L = InfoObj.ReadKeyDataLength($Ptr, LocalPtr);
      LocalPtr+=/*.$inc*/(InfoObj.getReadKeyDataLengthBytes()); // shift by ReadKeyDataLength bytes
      
      // Read the key.
      /*const*//*OnDiskChainedHashTable.*/internal_key_type/*<Info>*/ /*&*/ Key = InfoObj.ReadKey($Ptr, LocalPtr, $first_uint(L));
      return InfoObj.ReadData(Key, $Ptr, LocalPtr + $first_uint(L), $second_uint(L));
    }    

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private data_iterator(data_iterator<internal_key_type, data_type> other) {
      super(other);
      this.InfoObj = other.InfoObj;
    }
    
    @Override public data_iterator<internal_key_type, data_type> clone() {
      return new data_iterator(this);
    }    

    @Override
    public boolean $eq(Object other) {
      return iterator_base.$eq_iterator_base$C(this, (data_iterator) other);
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "InfoObj=" + NativeTrace.getIdentityStr(InfoObj) // NOI18N
                + super.toString(); // NOI18N
    }    
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 580,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 564,
   FQN="llvm::OnDiskIterableChainedHashTable::data_begin", NM="_ZN4llvm30OnDiskIterableChainedHashTable10data_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable10data_beginEv")
  //</editor-fold>
  public data_iterator<internal_key_type, data_type> data_begin() {
    return new data_iterator(Payload, 0, this.getNumEntries(), $AddrOf(this.getInfoObj()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 583,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 567,
   FQN="llvm::OnDiskIterableChainedHashTable::data_end", NM="_ZN4llvm30OnDiskIterableChainedHashTable8data_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable8data_endEv")
  //</editor-fold>
  public data_iterator<internal_key_type, data_type> data_end() {
    return DATA_END;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::data">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 585,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 569,
   FQN="llvm::OnDiskIterableChainedHashTable::data", NM="_ZN4llvm30OnDiskIterableChainedHashTable4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable4dataEv")
  //</editor-fold>
  public iterator_range< /*OnDiskChainedHashTable.*/data_type/*<Info>*/ > data() {
    return llvm.make_range(data_begin(), data_end());
  }

  
  /// \brief Create the hash table.
  ///
  /// \param Buckets is the beginning of the hash table itself, which follows
  /// the payload of entire structure. This is the value returned by
  /// OnDiskHashTableGenerator::Emit.
  ///
  /// \param Payload is the beginning of the data contained in the table.  This
  /// is Base plus any padding or header data that was stored, ie, the offset
  /// that the stream was at when calling Emit.
  ///
  /// \param Base is the point from which all offsets into the structure are
  /// based. This is offset 0 in the stream that was used when Emitting the
  /// table.
  //<editor-fold defaultstate="collapsed" desc="llvm::OnDiskIterableChainedHashTable::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", line = 602,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/OnDiskHashTable.h", old_line = 586,
   FQN="llvm::OnDiskIterableChainedHashTable::Create", NM="_ZN4llvm30OnDiskIterableChainedHashTable6CreateEPKhS2_S2_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN4llvm30OnDiskIterableChainedHashTable6CreateEPKhS2_S2_RKT_")
  //</editor-fold>
//  public static OnDiskIterableChainedHashTable<Info> /*P*/ Create(/*const*/char$ptr/*uchar P*/ Buckets, /*const*/char$ptr/*uchar P*//*const*/ Payload, 
//        /*const*/char$ptr/*uchar P*//*const*/ Base) {
//    return Create(Buckets, Payload, 
//        Base, Info());
//  }
  public static <Info extends InfoInterface<external_key_type, internal_key_type, data_type>, 
                 external_key_type, internal_key_type, data_type> 
                  OnDiskIterableChainedHashTable<external_key_type, internal_key_type, data_type> /*P*/
         Create(/*const*/char$ptr/*uchar P*/ Buckets, /*const*/char$ptr/*uchar P*//*const*/ Payload, 
        /*const*/char$ptr/*uchar P*//*const*/ Base, /*const*/ Info /*&*/ InfoObj/*= Info()*/) {
    assert InfoObj != null;
    //JAVA: using namespace llvm::support;
    assert (Buckets.$greater(Base)) : Buckets.$index() + " vs. " + Base.$index() + ":" + Base;    
    long/*std.pair< Info.offset_type,  Info.offset_type>*/ NumBucketsAndEntries = OnDiskIterableChainedHashTable.readNumBucketsAndEntries(Buckets);
    return new OnDiskIterableChainedHashTable($first_uint(NumBucketsAndEntries), $second_uint(NumBucketsAndEntries), $noClone(Buckets), $noClone(Payload), $noClone(Base), InfoObj);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final key_iterator KEY_END = new key_iterator();
  private static final data_iterator DATA_END = new data_iterator();
  
  private static int $sizeof_Hash_value_type$Info() {
    return OnDiskChainedHashTable.$sizeof_Hash_Value_type();
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Payload=[" + NativeTrace.getIdentityStr(Payload) +"]" // NOI18N
              + super.toString(); // NOI18N
  }
}
