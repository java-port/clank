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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.VoidPtr2Bool;
import static org.clank.support.Unsigned.$greater_uint;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.unaligned;

// JAVA: Info template argument was unfolded

/// \brief A collection of on-disk hash tables, merged when relevant for performance.
/*template <typename Info> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 31,
 FQN="clang::serialization::MultiOnDiskHashTable", NM="_ZN5clang13serialization20MultiOnDiskHashTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTableE")
//</editor-fold>
public class MultiOnDiskHashTable<external_key_type, internal_key_type, data_type, data_type_builder extends MultiOnDiskHashTable.MultiInfoInterface.DataTypeBuilder<data_type>, file_type>  implements Destructors.ClassWithDestructor {
/*public:*/
  /// A handle to a file, used when overriding tables.
  // JAVA: typedef typename Info::file_type file_type
//  public final class file_type extends  /*Info.*/file_type{ };
  /// A pointer to an on-disk representation of the hash table.
  // JAVA: typedef const unsigned char *storage_type;
  
  // JAVA: typedef typename Info::external_key_type external_key_type
//  public final class external_key_type extends  Info.external_key_type{ };
  // JAVA: typedef typename Info::internal_key_type internal_key_type
//  public final class internal_key_type extends  Info.internal_key_type{ };
  // JAVA: typedef typename Info::data_type data_type
//  public final class data_type extends  Info.data_type{ };
  // JAVA: typedef typename Info::data_type_builder data_type_builder
//  public final class data_type_builder extends  Info.data_type_builder{ };
  // JAVA: typedef unsigned int hash_value_type;
/*private:*/
  /// \brief A hash table stored on disk.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::OnDiskTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 46,
   FQN="clang::serialization::MultiOnDiskHashTable::OnDiskTable", NM="_ZN5clang13serialization20MultiOnDiskHashTable11OnDiskTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable11OnDiskTableE")
  //</editor-fold>
  private static class/*struct*/ OnDiskTable<external_key_type, internal_key_type, data_type, file_type> {
    // JAVA: typedef llvm::OnDiskIterableChainedHashTable<Info> HashTable
//    public final class HashTable extends OnDiskIterableChainedHashTable<Info>{ };
    
    public  /*Info.*/file_type File;
    public OnDiskIterableChainedHashTable/*<Info>*/<external_key_type, internal_key_type, data_type> Table;
    
    //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::OnDiskTable::OnDiskTable">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 52,
     FQN="clang::serialization::MultiOnDiskHashTable::OnDiskTable::OnDiskTable", NM="_ZN5clang13serialization20MultiOnDiskHashTable11OnDiskTableC1ENT_9file_typeEjjPKhS6_S6_RKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable11OnDiskTableC1ENT_9file_typeEjjPKhS6_S6_RKS3_")
    //</editor-fold>
    public OnDiskTable( /*Info.*/file_type File, /*uint*/int NumBuckets, /*uint*/int NumEntries, 
        /*const*/char$ptr/*uchar P*/ Buckets, /*const*/char$ptr/*uchar P*/ Payload, /*const*/char$ptr/*uchar P*/ Base, 
        final /*const*/ /*Info*/OnDiskChainedHashTable.InfoInterface<external_key_type, internal_key_type, data_type> /*&*/ InfoObj) {
      // : File(File), Table(NumBuckets, NumEntries, Buckets, Payload, Base, InfoObj) 
      //START JInit
      this.File = /*ParenListExpr*//*new Info.file_type*/(File);
      this.Table = /*ParenListExpr*/new OnDiskIterableChainedHashTable/*<Info>*/<external_key_type, internal_key_type, data_type>(NumBuckets, NumEntries, Buckets, Payload, Base, InfoObj);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "File=" + File // NOI18N
                + ", Table=" + Table; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::MergedTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 59,
   FQN="clang::serialization::MultiOnDiskHashTable::MergedTable", NM="_ZN5clang13serialization20MultiOnDiskHashTable11MergedTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable11MergedTableE")
  //</editor-fold>
  /*friend*//*private*/ static class/*struct*/ MergedTable<external_key_type, internal_key_type, data_type, file_type> {
    public std.vector< /*Info.*/file_type> Files;
    public DenseMap< /*Info.*/internal_key_type,  /*Info.*/data_type> Data;
    
    @Override public String toString() {
      return "" + "Files=" + Files // NOI18N
                + ", Data=" + Data; // NOI18N
    }
  };
  
  // JAVA: typedef llvm::PointerUnion<OnDiskTable *, MergedTable *> Table
//  public final class Table extends PointerUnion<OnDiskTable /*P*/ , MergedTable /*P*/ >{ };
  // JAVA: typedef llvm::TinyPtrVector<void *> TableVector
//  public final class TableVector extends TinyPtrVector<Object/*void P*/ >{ };
  
  /// \brief The current set of on-disk and merged tables.
  /// We manually store the opaque value of the Table because TinyPtrVector
  /// can't cope with holding a PointerUnion directly.
  /// There can be at most one MergedTable in this vector, and if present,
  /// it is the first table.
   private final TinyPtrVector<Object/*void P*/ > Tables;
  
  /// \brief Files corresponding to overridden tables that we've not yet
  /// discarded.
  private final TinyPtrVector< /*Info.*/file_type> PendingOverrides;
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::AsOnDiskTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 78,
   FQN="clang::serialization::MultiOnDiskHashTable::AsOnDiskTable", NM="_ZN5clang13serialization20MultiOnDiskHashTable13AsOnDiskTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable13AsOnDiskTableE")
  //</editor-fold>
  private static class/*struct*/ AsOnDiskTable<external_key_type, internal_key_type, data_type, file_type> implements NativeCallback.Converter<Object/*void P*/, OnDiskTable<external_key_type, internal_key_type, data_type, file_type> /*P*/> {
    // JAVA: typedef OnDiskTable *result_type
//    public final class result_type extends OnDiskTable /*P*/ { };
    //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::AsOnDiskTable::operator()">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 80,
     FQN="clang::serialization::MultiOnDiskHashTable::AsOnDiskTable::operator()", NM="_ZNK5clang13serialization20MultiOnDiskHashTable13AsOnDiskTableclEPv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZNK5clang13serialization20MultiOnDiskHashTable13AsOnDiskTableclEPv")
    //</editor-fold>
    @Override public OnDiskTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ $call(Object/*void P*/ P) /*const*/ {
      return PointerUnion.<OnDiskTable /*P*/ , MergedTable /*P*/ >getFromOpaqueValue(P)./*template */<OnDiskTable /*P*/ >get(OnDiskTable /*P*/.class);
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  // JAVA: typedef llvm::mapped_iterator<TableVector::iterator, AsOnDiskTable> table_iterator
//  public final class table_iterator extends mapped_iterator<type$ptr<Object>/*void PP*/ , AsOnDiskTable>{ };
  // JAVA: typedef llvm::iterator_range<table_iterator> table_range
//  public final class table_range extends iterator_range<mapped_iterator<type$ptr<Object>/*void PP*/ , AsOnDiskTable> >{ };
  
  /// \brief The current set of on-disk tables.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::tables">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 89,
   FQN="clang::serialization::MultiOnDiskHashTable::tables", NM="_ZN5clang13serialization20MultiOnDiskHashTable6tablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable6tablesEv")
  //</editor-fold>
  private iterator_range<OnDiskTable<external_key_type, internal_key_type, data_type, file_type> /*P*/> tables() {
    /*<dependent type>*/type$ptr<Object/*void PP*/> Begin = Tables.begin();
    /*<dependent type>*/type$ptr<Object/*void PP*/> End = Tables.end();
    if (getMergedTable() != null) {
      Begin.$preInc();
    }
    return llvm.make_range(llvm.map_iterator(Begin, new AsOnDiskTable()), 
        llvm.map_iterator(End, new AsOnDiskTable()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::getMergedTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 97,
   FQN="clang::serialization::MultiOnDiskHashTable::getMergedTable", NM="_ZNK5clang13serialization20MultiOnDiskHashTable14getMergedTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZNK5clang13serialization20MultiOnDiskHashTable14getMergedTableEv")
  //</editor-fold>
  /*friend*//*private*/ MergedTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ getMergedTable() /*const*/ {
    // If we already have a merged table, it's the first one.
    return Tables.empty() ? null : PointerUnion.<OnDiskTable /*P*/ , MergedTable /*P*/ >getFromOpaqueValue($Deref(Tables.begin()))./*template */<MergedTable /*P*/ >dyn_cast(MergedTable /*P*/.class);
  }

  
  /// \brief Delete all our current on-disk tables.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::clear">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 104,
   FQN="clang::serialization::MultiOnDiskHashTable::clear", NM="_ZN5clang13serialization20MultiOnDiskHashTable5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable5clearEv")
  //</editor-fold>
  private void clear() {
    for (OnDiskTable /*P*/ T : tables())  {
      /*delete*/Destructors.$destroy(T);
    }
    {
      MergedTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ M = getMergedTable();
      if (M != null) {
        /*delete*/Destructors.$destroy(M);
      }
    }
    Tables.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::removeOverriddenTables">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 112,
   FQN="clang::serialization::MultiOnDiskHashTable::removeOverriddenTables", NM="_ZN5clang13serialization20MultiOnDiskHashTable22removeOverriddenTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable22removeOverriddenTablesEv")
  //</editor-fold>
  private void removeOverriddenTables() {
    DenseSet< /*Info.*/file_type> Files = new DenseSet<>(DenseMapInfo$LikePtr.<file_type>$Info());
    Files.insert(PendingOverrides.begin(), PendingOverrides.end());
    // Explicitly capture Files to work around an MSVC 2015 rejects-valid bug.
    VoidPtr2Bool ShouldRemove = /*[&Files]*/ (Object/*void P*/ T) -> {
          OnDiskTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ ODT = PointerUnion.<OnDiskTable /*P*/ , MergedTable /*P*/ >getFromOpaqueValue(T)./*template */<OnDiskTable /*P*/ >get(OnDiskTable /*P*/.class);
          int Remove = Files.count(ODT.File);
          if (Native.$bool(Remove)) {
            /*delete*/Destructors.$destroy(ODT);
          }
          return Native.$bool(Remove);
        };
    mapped_iterator<Object/*void P*/, OnDiskTable<external_key_type, internal_key_type, data_type, file_type>> begin 
            = (mapped_iterator) tables().begin(); 
    type$ptr<Object/*void P*/> current = (type$ptr<Object/*void P*/>) begin.getCurrent();
    Tables.erase(std.remove_if(current, Tables.end(), 
            ShouldRemove), 
        Tables.end());
    PendingOverrides.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::condense">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 129,
   FQN="clang::serialization::MultiOnDiskHashTable::condense", NM="_ZN5clang13serialization20MultiOnDiskHashTable8condenseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable8condenseEv")
  //</editor-fold>
  private void condense() {
    MergedTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ Merged = getMergedTable();
    if (Native.$not(Merged)) {
      Merged = /*FIXME: NEW_EXPR [NoNewFun]*/new MergedTable();
    }
    
    // Read in all the tables and merge them together.
    // FIXME: Be smarter about which tables we merge.
    for (OnDiskTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ ODT : tables()) {
      final OnDiskIterableChainedHashTable/*<Info>*/<external_key_type, internal_key_type, data_type> /*&*/ HT = ODT.Table;
      final MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder> /*&*/ InfoObj 
                = (MultiInfoInterface)HT.getInfoObj();
      
      for (/*<dependent type>*/OnDiskIterableChainedHashTable.data_iterator<internal_key_type, data_type>
              I = HT.data_begin(), E = HT.data_end(); Native.$noteq_ptr(I, E); I.$preInc()) {
        final char$ptr /*P*/ LocalPtr$Base = I.$PtrBase();
        /*char$ptr*/int /*P*/ LocalPtr = I.$getItem();
        
        // FIXME: Don't rely on the OnDiskHashTable format here.
        /*<dependent type>*//*std.pair<uint, uint>*/long L = InfoObj.ReadKeyDataLength(LocalPtr$Base, LocalPtr);
                                                            LocalPtr += InfoObj.getReadKeyDataLengthBytes();
        final int keyLen = $first_uint(L);
        final int dataLen = $second_uint(L);
        final /*const*/  /*Info.*/internal_key_type /*&*/ Key = InfoObj.ReadKey(LocalPtr$Base, LocalPtr, keyLen);
                                 // it looks ReadKey doesn't move input pointer! LocalPtr += keyLen;
        /*Info.*/data_type_builder ValueBuilder/*J*/= /*ParenList*/Info().new$data_type_builder(Merged.Data.$at(Key));
        InfoObj.ReadDataInto(Key, LocalPtr$Base, (LocalPtr + keyLen), dataLen, 
            ValueBuilder);
      }
      
      Merged.Files.push_back(ODT.File);
      /*delete*/Destructors.$destroy(ODT);
    }
    
    Tables.clear();
    Tables.push_back(new PointerUnion<OnDiskTable /*P*/ , MergedTable /*P*/ >(JD$T1.INSTANCE, MergedTable/*P*/.class, Merged).getOpaqueValue());
  }

  
  /// The generator is permitted to read our merged table.
  /*friend template <typename ReaderInfo, typename WriterInfo> class MultiOnDiskHashTableGenerator*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::MultiOnDiskHashTable<Info>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 164,
   FQN="clang::serialization::MultiOnDiskHashTable::MultiOnDiskHashTable<Info>", NM="_ZN5clang13serialization20MultiOnDiskHashTableC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTableC1Ev")
  //</editor-fold>
  public MultiOnDiskHashTable(MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder> Info) {
    this.$Info = Info;
    this.Tables = new TinyPtrVector<Object/*void P*/ >();
    this.PendingOverrides = new TinyPtrVector</*Info.*/file_type >();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::MultiOnDiskHashTable<Info>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 165,
   FQN="clang::serialization::MultiOnDiskHashTable::MultiOnDiskHashTable<Info>", NM="_ZN5clang13serialization20MultiOnDiskHashTableC1EONS0_20MultiOnDiskHashTableIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTableC1EONS0_20MultiOnDiskHashTableIT_EE")
  //</editor-fold>
  public MultiOnDiskHashTable(JD$Move _dparam, final MultiOnDiskHashTable/*<Info>*/<external_key_type, internal_key_type, data_type, data_type_builder, file_type> /*&&*/O) {
    // : Tables(std::move(O.Tables)), PendingOverrides(std::move(O.PendingOverrides)) 
    this.$Info = O.$Info;
    //START JInit
    this.Tables = /*ParenListExpr*/new TinyPtrVector<Object/*void P*/ >(JD$Move.INSTANCE, std.move(O.Tables));
    this.PendingOverrides = /*ParenListExpr*/new TinyPtrVector< /*Info.*/file_type>(JD$Move.INSTANCE, std.move(O.PendingOverrides));
    //END JInit
    O.Tables.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 170,
   FQN="clang::serialization::MultiOnDiskHashTable::operator=", NM="_ZN5clang13serialization20MultiOnDiskHashTableaSEONS0_20MultiOnDiskHashTableIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTableaSEONS0_20MultiOnDiskHashTableIT_EE")
  //</editor-fold>
  public MultiOnDiskHashTable/*<Info>*/<external_key_type, internal_key_type, data_type, data_type_builder, file_type> /*&*/ $assignMove(final MultiOnDiskHashTable/*<Info>*/<external_key_type, internal_key_type, data_type, data_type_builder, file_type> /*&&*/O) {
    if (O == this) {
      return /*Deref*/this;
    }
    assert this.$Info == O.$Info;
    clear();
    Tables.$assignMove(std.move(O.Tables));
    O.Tables.clear();
    PendingOverrides.$assignMove(std.move(O.PendingOverrides));
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::~MultiOnDiskHashTable<Info>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 179,
   FQN="clang::serialization::MultiOnDiskHashTable::~MultiOnDiskHashTable<Info>", NM="_ZN5clang13serialization20MultiOnDiskHashTableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTableD0Ev")
  //</editor-fold>
  @Override public void $destroy() {
    clear();
    //START JDestroy
    Tables.$destroy();
    //END JDestroy
  }

  
  /// \brief Add the table \p Data loaded from file \p File.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::add">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 182,
   FQN="clang::serialization::MultiOnDiskHashTable::add", NM="_ZN5clang13serialization20MultiOnDiskHashTable3addENT_9file_typeEPKhS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable3addENT_9file_typeEPKhS2_")
  //</editor-fold>
  public void add( /*Info.*/file_type File, /*const*/char$ptr/*uchar P*/ Data) {
    add(File, Data, Info());
  }
  public void add( /*Info.*/file_type File, /*const*/char$ptr/*uchar P*/ Data, OnDiskChainedHashTable.InfoInterface/*<Info>*/<external_key_type, internal_key_type, data_type> InfoObj/*= Info()*/) {
    //JAVA: using namespace llvm::support;
    /*const*/char$ptr/*uchar P*/ Ptr = $tryClone(Data);
    
    /*uint32_t*/int BucketOffset = endian./*<uint32_t, endianness.little, unaligned>*/readNext_uint32(endianness.little, unaligned, Ptr);
    
    // Read the list of overridden files.
    /*uint32_t*/int NumFiles = endian./*<uint32_t, endianness.little, unaligned>*/readNext_uint32(endianness.little, unaligned, Ptr);
    // FIXME: Add a reserve() to TinyPtrVector so that we don't need to make
    // an additional copy.
    SmallVector< /*Info.*/file_type>/*<16>*/ OverriddenFiles = new SmallVector<file_type/*P*/>(16, (file_type/*P*/)null);
    OverriddenFiles.reserve(NumFiles);
    for (; NumFiles != 0; --NumFiles)  {
      OverriddenFiles.push_back((file_type)InfoObj.ReadFileRef(Ptr));
    }
    PendingOverrides.insert(PendingOverrides.end(), OverriddenFiles.begin(), 
        OverriddenFiles.end());
    
    // Read the OnDiskChainedHashTable header.
    /*const*/char$ptr/*uchar P*/ Buckets = Data.$add(BucketOffset);
    /*<dependent type>*/long/*std.pair< Info.offset_type,  Info.offset_type>*/ NumBucketsAndEntries = OnDiskIterableChainedHashTable.readNumBucketsAndEntries(Buckets);
    
    // Register the table.
    OnDiskTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ $NewTable = /*FIXME: NEW_EXPR [NoNewFun]*/new OnDiskTable( File, $first_uint(NumBucketsAndEntries), $second_uint(NumBucketsAndEntries), Buckets, Ptr, Data, std.move(InfoObj) );
    PointerUnion<OnDiskTable /*P*/ , MergedTable /*P*/ > NewTable = new PointerUnion(JD$T.INSTANCE, OnDiskTable/*P*/.class, $NewTable);
    Tables.push_back(NewTable.getOpaqueValue());
  }

  
  /// \brief Find and read the lookup results for \p EKey.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::find">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 212,
   FQN="clang::serialization::MultiOnDiskHashTable::find", NM="_ZN5clang13serialization20MultiOnDiskHashTable4findERKNT_17external_key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable4findERKNT_17external_key_typeE")
  //</editor-fold>
  public  /*Info.*/data_type find(final /*const*/  /*Info.*/external_key_type /*&*/ EKey) {
     /*Info.*/data_type Result = Info().new$data_type();
    if (Native.$not(PendingOverrides.empty())) {
      removeOverriddenTables();
    }
    if ($greater_uint(Tables.size(), ((/*static_cast*//*uint*/int)(Info().$MaxTables())))) {
      condense();
    }
    
     /*Info.*/internal_key_type Key = Info().GetInternalKey(EKey);
    /*<dependent type>*//*uint32_t*/int KeyHash = Info().ComputeHash(Key);
    {
      
      MergedTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ M = getMergedTable();
      if (M != null) {
        /*<dependent type>*/DenseMapIterator<internal_key_type, data_type> It = M.Data.find(Key);
        if (Native.$noteq_iter(It, M.Data.end())) {
          Result = It.$arrow().second;
        }
      }
    }
    
     /*Info.*/data_type_builder ResultBuilder/*J*/= /*ParenList*/Info().new$data_type_builder(Result);
    
    for (OnDiskTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ ODT : tables()) {
      final OnDiskIterableChainedHashTable/*<Info>*/<external_key_type, internal_key_type, data_type> /*&*/ HT = ODT.Table;
      /*<dependent type>*/OnDiskChainedHashTable.iterator<external_key_type, internal_key_type, data_type> It = HT.find_hashed(Key, KeyHash);
      if (Native.$noteq(It, HT.end())) {
        final MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder> infoObj 
                = (MultiInfoInterface) HT.getInfoObj(); 
        infoObj.ReadDataInto(Key, It.getDataPtr$Base(), It.getDataPtr$Offset(), It.getDataLen(), 
            ResultBuilder);
      }
    }
    
    return Result;
  }

  
  /// \brief Read all the lookup results into a single value. This only makes
  /// sense if merging values across keys is meaningful.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTable::findAll">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 245,
   FQN="clang::serialization::MultiOnDiskHashTable::findAll", NM="_ZN5clang13serialization20MultiOnDiskHashTable7findAllEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization20MultiOnDiskHashTable7findAllEv")
  //</editor-fold>
  public  /*Info.*/data_type findAll() {
     /*Info.*/data_type Result = Info().new$data_type();
//     Info.data_type_builder ResultBuilder/*J*/= /*ParenList*/new  Info.data_type_builder(Result);
     /*Info.*/data_type_builder ResultBuilder/*J*/= /*ParenList*/Info().new$data_type_builder(Result);
    if (Native.$not(PendingOverrides.empty())) {
      removeOverriddenTables();
    }
    {
      
      MergedTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ M = getMergedTable();
      if (M != null) {
        for (final std.pair< /*Info.*/internal_key_type,  /*Info.*/data_type> /*&*/ KV : M.Data)  {
          Info().MergeDataInto(KV.second, ResultBuilder);
        }
      }
    }
    
    for (OnDiskTable<external_key_type, internal_key_type, data_type, file_type> /*P*/ ODT : tables()) {
      final OnDiskIterableChainedHashTable/*<Info>*/<external_key_type, internal_key_type, data_type> /*&*/ HT = ODT.Table;
//      final Info /*&*/ InfoObj = HT.getInfoObj();
      final MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder> InfoObj 
                      = (MultiInfoInterface) HT.getInfoObj(); 
      for (/*<dependent type>*/OnDiskIterableChainedHashTable.data_iterator<internal_key_type, data_type>
              I = HT.data_begin(), E = HT.data_end(); Native.$noteq_ptr(I, E); I.$preInc()) {
        final char$ptr /*P*/ LocalPtr$Base = I.$PtrBase();
        /*char$ptr*/int /*P*/ LocalPtr = I.$getItem();
        
        // FIXME: Don't rely on the OnDiskHashTable format here.
        /*<dependent type>*//*std.pair<uint, uint>*/long L = InfoObj.ReadKeyDataLength(LocalPtr$Base, LocalPtr);
                                                            LocalPtr += InfoObj.getReadKeyDataLengthBytes();
        final int keyLen = $first_uint(L);
        final int dataLen = $second_uint(L);
        final /*const*/  /*Info.*/internal_key_type /*&*/ Key = InfoObj.ReadKey(LocalPtr$Base, LocalPtr, keyLen);
                                          // it looks ReadKey doesn't move input pointer! LocalPtr += keyLen;
        InfoObj.ReadDataInto(Key, LocalPtr$Base, (LocalPtr + keyLen), dataLen, 
            ResultBuilder);
      }
    }
    
    return Result;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  private final MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder> $Info;
  private MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder> Info() {
    return this.$Info;
  }
  
  public static interface MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder extends MultiInfoInterface.DataTypeBuilder<data_type>> 
    extends OnDiskChainedHashTable.InfoInterface<external_key_type, internal_key_type, data_type> {
    default data_type new$data_type() {
      throw new UnsupportedOperationException("This methods must be implemented to return 'new data_type()' from :" + this.getClass());
    }
    default data_type_builder new$data_type_builder(data_type data) {
      throw new UnsupportedOperationException("This methods must be implemented to return 'new data_type_builder(data)' from :" + this.getClass());
    }
    
    // Maximum number of lookup tables we allow before condensing the tables.
    public default /*const*/int $MaxTables() {
      throw new UnsupportedOperationException("This methods must be implemented to return 'MaxTables' field from :" + this.getClass());
    }
        
    // this method usually is implemented by default as static 
    public default void MergeDataInto(final /*const*/data_type /*&*/ From, final data_type_builder /*&*/ To) {
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
    }
    
    public static interface DataTypeBuilder<data_type> {
      
    }
    
    public default void ReadDataInto(internal_key_type $Prm0, 
                  /*const*/char$ptr/*uchar P*/ Buf, int DataOffsetInBuf,
                  /*uint*/int DataLen, 
                  final data_type_builder /*&*/ Val) {
      throw new UnsupportedOperationException("This methods must be implemented in :" + this.getClass() + ". Forgot to remove static?");
    }
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return NativeTrace.getIdentityStr($Info) + ":Tables=" + Tables.size() // NOI18N
              + ", PendingOverrides=" + PendingOverrides.size(); // NOI18N
  }
}
