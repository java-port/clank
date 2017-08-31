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
import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.impl.IdentifierTableStatics.*;


/// \brief Implements an efficient mapping from strings to IdentifierInfo nodes.
///
/// This has no other purpose, but this is an extremely performance-critical
/// piece of the code, as each occurrence of every identifier goes through
/// here when lexed.
//<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 446,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 431,
 FQN="clang::IdentifierTable", NM="_ZN5clang15IdentifierTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTableE")
//</editor-fold>
public class IdentifierTable implements java.lang.Iterable<IdentifierInfoStringMapEntry>, Destructors.ClassWithDestructor {
  // Shark shows that using MallocAllocator is *much* slower than using this
  // BumpPtrAllocator!
  /*typedef llvm::StringMap<IdentifierInfo *, llvm::BumpPtrAllocator> HashTableTy*/
  private final static class HashTableTy extends StringMapIdentifierInfo {

    private HashTableTy(int size) {
      super(size, new StringMapBumpPtrAllocator(), null/*pointer*/);
    }

    private void $release() {
      super.resetForReuse();
    }
  };
  private static final int IDENT_TABLE_SIZE = Integer.getInteger("clank.identifiers.size", 8192);
  
  // JAVA PERF: use pool of hash tables, because in different TUs IDs are almost always the same
  public static final String REUSE_LEXER_IDENTIFIERS_PROP = "clank.identifiers.reuse";
  public static final boolean REUSE_LEXER_IDENTIFIERS = Boolean.valueOf(System.getProperty(REUSE_LEXER_IDENTIFIERS_PROP, "false"));
  private static final SmallVector<HashTableTy> POOL = new SmallVector<HashTableTy>(2*Native.availableProcessors(), null);
  private static HashTableTy $getHashTable(IdentifierInfoLookup ExternalLookup) {
    if (REUSE_LEXER_IDENTIFIERS && ExternalLookup == null) {
      // get from Pool
      synchronized (POOL) {
        if (!POOL.empty()) {
          return POOL.pop_back_val();
        }      
      }
      return new HashTableTy(IDENT_TABLE_SIZE);
    } else {
      // have to create new one, because it's Entry could later be used with IdentifierInfo from External Lookup
      return new HashTableTy(IDENT_TABLE_SIZE);
    }
  }
  private static void $releaseHashTable(HashTableTy Table, IdentifierInfoLookup ExternalLookup) {
    if (REUSE_LEXER_IDENTIFIERS && ExternalLookup == null) {
      // can reuse, because table doesn't have external references in Entries
      Table.$release();
      synchronized (POOL) {
        POOL.push_back(Table);
      }
    } else {
      // have to clean
      Table.$destroy();
    }
  }
  private HashTableTy HashTable;
  private IdentifierInfoLookup /*P*/ ExternalLookup;
/*public:*/
  /// \brief Create the identifier table, populating it with info about the
  /// language keywords for the language specified by \p LangOpts.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::IdentifierTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 75,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 74,
   FQN="clang::IdentifierTable::IdentifierTable", NM="_ZN5clang15IdentifierTableC1ERKNS_11LangOptionsEPNS_20IdentifierInfoLookupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTableC1ERKNS_11LangOptionsEPNS_20IdentifierInfoLookupE")
  //</editor-fold>
  public IdentifierTable(/*const*/LangOptions /*&*/ LangOpts) {
    this(LangOpts, (IdentifierInfoLookup /*P*/ )null);
  }
  public IdentifierTable(/*const*/LangOptions /*&*/ LangOpts, IdentifierInfoLookup /*P*/ externalLookup/*= 0*/) {
    /* : HashTable(8192), ExternalLookup(externalLookup)*/ 
    //START JInit
    this.HashTable = $getHashTable(externalLookup);
    this.ExternalLookup = externalLookup;
    //END JInit
    
    // Populate the identifier table with info about keywords for the current
    // language.
    AddKeywords(LangOpts);
    
    // Add the '_experimental_modules_import' contextual keyword.
    get(NativePointer.$import.$array(), NativePointer.$import.$index(), StringRef.R$import.size()).setModulesImport(true);
  }

  
  /// \brief Set the external identifier lookup mechanism.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::setExternalIdentifierLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 446,
   FQN="clang::IdentifierTable::setExternalIdentifierLookup", NM="_ZN5clang15IdentifierTable27setExternalIdentifierLookupEPNS_20IdentifierInfoLookupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTable27setExternalIdentifierLookupEPNS_20IdentifierInfoLookupE")
  //</editor-fold>
  public void setExternalIdentifierLookup(IdentifierInfoLookup /*P*/ IILookup) {
    ExternalLookup = IILookup;
  }

  
  /// \brief Retrieve the external identifier lookup object, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::getExternalIdentifierLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 466,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 451,
   FQN="clang::IdentifierTable::getExternalIdentifierLookup", NM="_ZNK5clang15IdentifierTable27getExternalIdentifierLookupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang15IdentifierTable27getExternalIdentifierLookupEv")
  //</editor-fold>
  public IdentifierInfoLookup /*P*/ getExternalIdentifierLookup() /*const*/ {
    return ExternalLookup;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 470,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 455,
   FQN="clang::IdentifierTable::getAllocator", NM="_ZN5clang15IdentifierTable12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTable12getAllocatorEv")
  //</editor-fold>
  public BumpPtrAllocator /*&*/ getAllocator() {
    return HashTable.getAllocator();
  }

  
  /// \brief Return the identifier token info for the specified named
  /// identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 476,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 461,
   FQN="clang::IdentifierTable::get", NM="_ZN5clang15IdentifierTable3getEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTable3getEN4llvm9StringRefE")
  //</editor-fold>
  public IdentifierInfo /*&*/ get(StringRef Name) {
    return get(Name.data(), Name.size());
  }
  public IdentifierInfo /*&*/ get(char$ptr Name, int Len) {
    if (NativeTrace.isDebugMode()) {
      NativeTrace.assertTrueInConsole(!Native.$is_array_based(Name), "use get(byte[],...)/get(SmallString)/get(std.string) version directly if possible");
    }
    IdentifierInfoStringMapEntry /*&*/ Entry = HashTable.GetOrCreateValue(Name, Len);

    IdentifierInfo /*P*/ II = Entry.getValue();
    if ((II != null)) {
      assert Entry.getValue() == II;
      assert II.getEntryImpl() == Entry;
      return $Deref(II);
    }

    // No entry; if we have an external lookup, look there first.
    if ((ExternalLookup != null)) {
      II = ExternalLookup.get(Name, Len);
      if ((II != null)) {
        return $Deref(II);
      }
    }

    // Lookups failed, make a new IdentifierInfo.
    //void$ptr/*void P*/ Mem = getAllocator().Allocate<IdentifierInfo>();
    //II = /*FIXME:*//*new (Mem)*/ new IdentifierInfo();
    Entry.setValue(IdentifierInfo.SET_VALUE_PLACEHOLDER);
    II = Entry.getValue();

    // Make sure getName() knows how to find the IdentifierInfo
    // contents.
    II.setEntry(Entry);
    assert Entry.getValue() == II;
    assert II.getEntryImpl() == Entry;

    return $Deref(II);
  }
  public IdentifierInfo /*&*/ get(SmallString Name) {
    return get(Name.$array(), 0, Name.size());
  }
  public IdentifierInfo /*&*/ get(std.string Name) {
    return get(Name.$array(), 0, Name.size());
  }
  public IdentifierInfo /*&*/ get(byte[] Name, int NameStIndex, int Len) {
    IdentifierInfoStringMapEntry /*&*/ Entry = HashTable.GetOrCreateValue(Name, NameStIndex, Len);
    
    IdentifierInfo /*P*/ II = Entry.getValue();
    if ((II != null)) {
      assert Entry.getValue() == II;
      assert II.getEntryImpl() == Entry;
      return $Deref(II);
    }
    
    // No entry; if we have an external lookup, look there first.
    if ((ExternalLookup != null)) {
      II = ExternalLookup.get(Name, NameStIndex, Len);
      if ((II != null)) {
        return $Deref(II);
      }
    }
    
    // Lookups failed, make a new IdentifierInfo.
//    void$ptr/*void P*/ Mem = getAllocator().Allocate(IdentifierInfo.class);
    Entry.setValue(IdentifierInfo.SET_VALUE_PLACEHOLDER);
    II = Entry.getValue();
    
    // Make sure getName() knows how to find the IdentifierInfo
    // contents.
    II.setEntry($AddrOf(Entry));
    assert Entry.getValue() == II;
    assert II.getEntryImpl() == Entry;
    return $Deref(II);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 500,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 485,
   FQN="clang::IdentifierTable::get", NM="_ZN5clang15IdentifierTable3getEN4llvm9StringRefENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTable3getEN4llvm9StringRefENS_3tok9TokenKindE")
  //</editor-fold>
  public IdentifierInfo /*&*/ get(StringRef Name, /*tok.TokenKind*/char TokenCode) {
    IdentifierInfo /*&*/ II = get(Name);
    II.setTokenID(TokenCode);
    assert (II.$TokenID() == TokenCode) : "TokenCode too large";
    return II;
  }

  
  /// \brief Gets an IdentifierInfo for the given name without consulting
  ///        external sources.
  ///
  /// This is a version of get() meant for external sources that want to
  /// introduce or modify an identifier. If they called get(), they would
  /// likely end up in a recursion.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::getOwn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 513,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 498,
   FQN="clang::IdentifierTable::getOwn", NM="_ZN5clang15IdentifierTable6getOwnEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTable6getOwnEN4llvm9StringRefE")
  //</editor-fold>
  public IdentifierInfo /*&*/ getOwn(StringRef Name) {
    IdentifierInfoStringMapEntry /*P*/ /*&*/ Entry = HashTable.GetOrCreateValue(Name);
    
    IdentifierInfo /*P*/ II = Entry.getValue();
    if ((II == null)) {
      // Lookups failed, make a new IdentifierInfo.
      if (false) {
        void$ptr/*void P*/ Mem = getAllocator().Allocate(IdentifierInfo.class);
      }
      Entry.setValue(IdentifierInfo.SET_VALUE_PLACEHOLDER);
      II = Entry.getValue();
      
      // Make sure getName() knows how to find the IdentifierInfo
      // contents.
      II.setEntry($AddrOf(Entry));
      
      // If this is the 'import' contextual keyword, mark it as such.
      if (Name.equals(StringRef.R$import)) {
        II.setModulesImport(true);
      }
    }    

    assert Entry.getValue() == II;
    assert II.getEntryImpl() == Entry;
    return $Deref(II);
  }

  /*typedef HashTableTy::const_iterator iterator*/
//  public final class iterator extends HashTableTy.const_iterator{ };
  /*typedef HashTableTy::const_iterator const_iterator*/
  //public final class const_iterator extends HashTableTy.const_iterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 538,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 523,
   FQN="clang::IdentifierTable::begin", NM="_ZNK5clang15IdentifierTable5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang15IdentifierTable5beginEv")
  //</editor-fold>
  public StringMapIteratorIdentifierInfo begin() /*const*/ {
    return HashTable.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 539,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 524,
   FQN="clang::IdentifierTable::end", NM="_ZNK5clang15IdentifierTable3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang15IdentifierTable3endEv")
  //</editor-fold>
  public StringMapIteratorIdentifierInfo end() /*const*/ {
    return HashTable.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 540,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 525,
   FQN="clang::IdentifierTable::size", NM="_ZNK5clang15IdentifierTable4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang15IdentifierTable4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return (int)HashTable.size();
  }

  
  /// \brief Print some statistics to stderr that indicate how well the
  /// hashing is doing.
  
  /// PrintStats - Print statistics about how well the identifier table is doing
  /// at hashing identifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::PrintStats">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 312,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 311,
   FQN="clang::IdentifierTable::PrintStats", NM="_ZNK5clang15IdentifierTable10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang15IdentifierTable10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() /*const*/ {
      PrintStats(llvm.errs());
  }
  // JAVA: pass OS and return some integral value
  public long PrintStats(raw_ostream /*&*/ OS) /*const*/ {
    /*uint*/int NumBuckets = (int)HashTable.getNumBuckets();
    /*uint*/int NumIdentifiers = (int)HashTable.getNumItems();
    /*uint*/int NumEmptyBuckets = NumBuckets - NumIdentifiers;
    /*uint*/int AverageIdentifierSize = 0;
    /*uint*/int MaxIdentifierLength = 0;
    
    // TODO: Figure out maximum times an identifier had to probe for -stats.
    for (StringMapIteratorIdentifierInfo /*P*//* , BumpPtrAllocator*/ I = HashTable.begin(), E = HashTable.end(); I.$noteq(E); I.$preInc()) {
      /*uint*/int IdLen = (int)I.$arrow().getKeyLength();
      AverageIdentifierSize += IdLen;
      if (MaxIdentifierLength < IdLen) {
        MaxIdentifierLength = IdLen;
      }
    }
    
    OS.$out(String.format("\n*** Identifier Table Stats:\n"));
    OS.$out(String.format("# Identifiers:   %s\n", NativeTrace.formatNumber(NumIdentifiers)));
    NativeTrace.dumpStatisticValue("NumIdentifiers", NumIdentifiers);
    OS.$out(String.format("# Empty Buckets: %s\n", NativeTrace.formatNumber(NumEmptyBuckets)));
    OS.$out(String.format("Hash density (#identifiers per bucket): %f\n", NumIdentifiers / (double)NumBuckets));
    OS.$out(String.format("Ave identifier length: %f\n", (AverageIdentifierSize / (double)NumIdentifiers)));
    OS.$out(String.format("Max identifier length: %d\n", MaxIdentifierLength));
    
    // Compute statistics about the memory allocated for identifiers.
    HashTable.getAllocator().PrintStats("IdentifierTableAllocatedBytes", OS);
    
    return NumIdentifiers;
  }

  
  /// AddKeywords - Add all keywords to the symbol table.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::AddKeywords">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 202,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 201,
   FQN="clang::IdentifierTable::AddKeywords", NM="_ZN5clang15IdentifierTable11AddKeywordsERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTable11AddKeywordsERKNS_11LangOptionsE")
  //</editor-fold>
  public void AddKeywords(/*const*/ LangOptions /*&*/ LangOpts) {
    
    // C99 6.4.1: Keywords.  These turn into kw_* tokens.
    // Flags allowed:
    //   KEYALL   - This is a keyword in all variants of C and C++, or it
    //              is a keyword in the implementation namespace that should
    //              always be treated as a keyword
    //   KEYC99   - This is a keyword introduced to C in C99
    //   KEYC11   - This is a keyword introduced to C in C11
    //   KEYCXX   - This is a C++ keyword, or a C++-specific keyword in the
    //              implementation namespace
    //   KEYNOCXX - This is a keyword in every non-C++ dialect.
    //   KEYCXX11 - This is a C++ keyword introduced to C++ in C++11
    //   KEYCONCEPTS - This is a keyword if the C++ extensions for concepts
    //                 are enabled.
    //   KEYGNU   - This is a keyword if GNU extensions are enabled
    //   KEYMS    - This is a keyword if Microsoft extensions are enabled
    //   KEYNOMS18 - This is a keyword that must never be enabled under
    //               MSVC <= v18.
    //   KEYOPENCL  - This is a keyword in OpenCL
    //   KEYNOOPENCL  - This is a keyword that is not supported in OpenCL
    //   KEYALTIVEC - This is a keyword in AltiVec
    //   KEYZVECTOR - This is a keyword for the System z vector extensions,
    //                which are heavily based on AltiVec
    //   KEYBORLAND - This is a keyword if Borland extensions are enabled
    //   KEYCOROUTINES - This is a keyword if support for the C++ coroutines
    //                   TS is enabled
    //   BOOLSUPPORT - This is a keyword if 'bool' is a built-in type
    //   HALFSUPPORT - This is a keyword if 'half' is a built-in type
    //   WCHARSUPPORT - This is a keyword if 'wchar_t' is a built-in type
    //
    AddKeyword(/*STRINGREF_STR*/"auto", tok.TokenKind.kw_auto, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"break", tok.TokenKind.kw_break, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"case", tok.TokenKind.kw_case, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"char", tok.TokenKind.kw_char, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"const", tok.TokenKind.kw_const, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"continue", tok.TokenKind.kw_continue, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"default", tok.TokenKind.kw_default, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"do", tok.TokenKind.kw_do, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"double", tok.TokenKind.kw_double, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"else", tok.TokenKind.kw_else, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"enum", tok.TokenKind.kw_enum, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"extern", tok.TokenKind.kw_extern, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"float", tok.TokenKind.kw_float, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"for", tok.TokenKind.kw_for, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"goto", tok.TokenKind.kw_goto, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"if", tok.TokenKind.kw_if, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"inline", tok.TokenKind.kw_inline, KEYC99 | KEYCXX | KEYGNU, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"int", tok.TokenKind.kw_int, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"long", tok.TokenKind.kw_long, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"register", tok.TokenKind.kw_register, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"restrict", tok.TokenKind.kw_restrict, KEYC99, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"return", tok.TokenKind.kw_return, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"short", tok.TokenKind.kw_short, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"signed", tok.TokenKind.kw_signed, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"sizeof", tok.TokenKind.kw_sizeof, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"static", tok.TokenKind.kw_static, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"struct", tok.TokenKind.kw_struct, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"switch", tok.TokenKind.kw_switch, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"typedef", tok.TokenKind.kw_typedef, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"union", tok.TokenKind.kw_union, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"unsigned", tok.TokenKind.kw_unsigned, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"void", tok.TokenKind.kw_void, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"volatile", tok.TokenKind.kw_volatile, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"while", tok.TokenKind.kw_while, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Alignas", tok.TokenKind.kw__Alignas, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Alignof", tok.TokenKind.kw__Alignof, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Atomic", tok.TokenKind.kw__Atomic, KEYALL | KEYNOOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Bool", tok.TokenKind.kw__Bool, KEYNOCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Complex", tok.TokenKind.kw__Complex, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Generic", tok.TokenKind.kw__Generic, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Imaginary", tok.TokenKind.kw__Imaginary, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Noreturn", tok.TokenKind.kw__Noreturn, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Static_assert", tok.TokenKind.kw__Static_assert, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Thread_local", tok.TokenKind.kw__Thread_local, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__func__", tok.TokenKind.kw___func__, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__objc_yes", tok.TokenKind.kw___objc_yes, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__objc_no", tok.TokenKind.kw___objc_no, KEYALL, LangOpts, /*Deref*/this);
    
    // C++ 2.11p1: Keywords.
    AddKeyword(/*STRINGREF_STR*/"asm", tok.TokenKind.kw_asm, KEYCXX | KEYGNU, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"bool", tok.TokenKind.kw_bool, BOOLSUPPORT, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"catch", tok.TokenKind.kw_catch, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"class", tok.TokenKind.kw_class, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"const_cast", tok.TokenKind.kw_const_cast, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"delete", tok.TokenKind.kw_delete, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"dynamic_cast", tok.TokenKind.kw_dynamic_cast, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"explicit", tok.TokenKind.kw_explicit, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"export", tok.TokenKind.kw_export, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"false", tok.TokenKind.kw_false, BOOLSUPPORT, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"friend", tok.TokenKind.kw_friend, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"mutable", tok.TokenKind.kw_mutable, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"namespace", tok.TokenKind.kw_namespace, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"new", tok.TokenKind.kw_new, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"operator", tok.TokenKind.kw_operator, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"private", tok.TokenKind.kw_private, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"protected", tok.TokenKind.kw_protected, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"public", tok.TokenKind.kw_public, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"reinterpret_cast", tok.TokenKind.kw_reinterpret_cast, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"static_cast", tok.TokenKind.kw_static_cast, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"template", tok.TokenKind.kw_template, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"this", tok.TokenKind.kw_this, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"throw", tok.TokenKind.kw_throw, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"true", tok.TokenKind.kw_true, BOOLSUPPORT, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"try", tok.TokenKind.kw_try, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"typename", tok.TokenKind.kw_typename, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"typeid", tok.TokenKind.kw_typeid, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"using", tok.TokenKind.kw_using, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"virtual", tok.TokenKind.kw_virtual, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"wchar_t", tok.TokenKind.kw_wchar_t, WCHARSUPPORT, LangOpts, /*Deref*/this);
    
    // C++ 2.5p2: Alternative Representations.
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"and", tok.TokenKind.ampamp, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"and_eq", tok.TokenKind.ampequal, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"bitand", tok.TokenKind.amp, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"bitor", tok.TokenKind.pipe, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"compl", tok.TokenKind.tilde, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"not", tok.TokenKind.exclaim, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"not_eq", tok.TokenKind.exclaimequal, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"or", tok.TokenKind.pipepipe, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"or_eq", tok.TokenKind.pipeequal, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"xor", tok.TokenKind.caret, /*Deref*/this);
    }
    if (LangOpts.CXXOperatorNames) {
      AddCXXOperatorKeyword(/*STRINGREF_STR*/"xor_eq", tok.TokenKind.caretequal, /*Deref*/this);
    }
    
    // C++11 keywords
    AddKeyword(/*STRINGREF_STR*/"alignas", tok.TokenKind.kw_alignas, KEYCXX11 | (0), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"alignof", tok.TokenKind.kw_alignof, KEYCXX11 | (0), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"char16_t", tok.TokenKind.kw_char16_t, KEYCXX11 | (KEYNOMS18), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"char32_t", tok.TokenKind.kw_char32_t, KEYCXX11 | (KEYNOMS18), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"constexpr", tok.TokenKind.kw_constexpr, KEYCXX11 | (0), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"decltype", tok.TokenKind.kw_decltype, KEYCXX11 | (0), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"noexcept", tok.TokenKind.kw_noexcept, KEYCXX11 | (0), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"nullptr", tok.TokenKind.kw_nullptr, KEYCXX11 | (0), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"static_assert", tok.TokenKind.kw_static_assert, KEYCXX11 | (0), LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"thread_local", tok.TokenKind.kw_thread_local, KEYCXX11 | (0), LangOpts, /*Deref*/this);
    
    // C++ concepts TS keywords
    AddKeyword(/*STRINGREF_STR*/"concept", tok.TokenKind.kw_concept, KEYCONCEPTS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"requires", tok.TokenKind.kw_requires, KEYCONCEPTS, LangOpts, /*Deref*/this);
    
    // C++ coroutines TS keywords
    AddKeyword(/*STRINGREF_STR*/"co_await", tok.TokenKind.kw_co_await, KEYCOROUTINES, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"co_return", tok.TokenKind.kw_co_return, KEYCOROUTINES, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"co_yield", tok.TokenKind.kw_co_yield, KEYCOROUTINES, LangOpts, /*Deref*/this);
    
    // GNU Extensions (in impl-reserved namespace)
    AddKeyword(/*STRINGREF_STR*/"_Decimal32", tok.TokenKind.kw__Decimal32, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Decimal64", tok.TokenKind.kw__Decimal64, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Decimal128", tok.TokenKind.kw__Decimal128, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__null", tok.TokenKind.kw___null, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__alignof", tok.TokenKind.kw___alignof, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__attribute", tok.TokenKind.kw___attribute, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__builtin_choose_expr", tok.TokenKind.kw___builtin_choose_expr, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__builtin_offsetof", tok.TokenKind.kw___builtin_offsetof, KEYALL, LangOpts, /*Deref*/this);
    // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
    // type trait.
    AddKeyword(/*STRINGREF_STR*/"__builtin_types_compatible_p", tok.TokenKind.kw___builtin_types_compatible_p, KEYNOCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__builtin_va_arg", tok.TokenKind.kw___builtin_va_arg, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__extension__", tok.TokenKind.kw___extension__, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__float128", tok.TokenKind.kw___float128, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__imag", tok.TokenKind.kw___imag, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__int128", tok.TokenKind.kw___int128, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__label__", tok.TokenKind.kw___label__, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__real", tok.TokenKind.kw___real, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__thread", tok.TokenKind.kw___thread, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__FUNCTION__", tok.TokenKind.kw___FUNCTION__, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__PRETTY_FUNCTION__", tok.TokenKind.kw___PRETTY_FUNCTION__, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__auto_type", tok.TokenKind.kw___auto_type, KEYALL, LangOpts, /*Deref*/this);
    
    // GNU Extensions (outside impl-reserved namespace)
    AddKeyword(/*STRINGREF_STR*/"typeof", tok.TokenKind.kw_typeof, KEYGNU, LangOpts, /*Deref*/this);
    
    // MS Extensions
    AddKeyword(/*STRINGREF_STR*/"__FUNCDNAME__", tok.TokenKind.kw___FUNCDNAME__, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__FUNCSIG__", tok.TokenKind.kw___FUNCSIG__, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"L__FUNCTION__", tok.TokenKind.kw_L__FUNCTION__, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_interface_class", tok.TokenKind.kw___is_interface_class, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_sealed", tok.TokenKind.kw___is_sealed, KEYMS, LangOpts, /*Deref*/this);
    
    // MSVC12.0 / VS2013 Type Traits
    AddKeyword(/*STRINGREF_STR*/"__is_destructible", tok.TokenKind.kw___is_destructible, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_nothrow_destructible", tok.TokenKind.kw___is_nothrow_destructible, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_nothrow_assignable", tok.TokenKind.kw___is_nothrow_assignable, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_constructible", tok.TokenKind.kw___is_constructible, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_nothrow_constructible", tok.TokenKind.kw___is_nothrow_constructible, KEYCXX, LangOpts, /*Deref*/this);
    
    // MSVC14.0 / VS2015 Type Traits
    AddKeyword(/*STRINGREF_STR*/"__is_assignable", tok.TokenKind.kw___is_assignable, KEYCXX, LangOpts, /*Deref*/this);
    
    // GNU and MS Type Traits
    AddKeyword(/*STRINGREF_STR*/"__has_nothrow_assign", tok.TokenKind.kw___has_nothrow_assign, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_nothrow_move_assign", tok.TokenKind.kw___has_nothrow_move_assign, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_nothrow_copy", tok.TokenKind.kw___has_nothrow_copy, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_nothrow_constructor", tok.TokenKind.kw___has_nothrow_constructor, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_trivial_assign", tok.TokenKind.kw___has_trivial_assign, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_trivial_move_assign", tok.TokenKind.kw___has_trivial_move_assign, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_trivial_copy", tok.TokenKind.kw___has_trivial_copy, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_trivial_constructor", tok.TokenKind.kw___has_trivial_constructor, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_trivial_move_constructor", tok.TokenKind.kw___has_trivial_move_constructor, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_trivial_destructor", tok.TokenKind.kw___has_trivial_destructor, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__has_virtual_destructor", tok.TokenKind.kw___has_virtual_destructor, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_abstract", tok.TokenKind.kw___is_abstract, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_base_of", tok.TokenKind.kw___is_base_of, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_class", tok.TokenKind.kw___is_class, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_convertible_to", tok.TokenKind.kw___is_convertible_to, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_empty", tok.TokenKind.kw___is_empty, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_enum", tok.TokenKind.kw___is_enum, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_final", tok.TokenKind.kw___is_final, KEYCXX, LangOpts, /*Deref*/this);
    // Tentative name - there's no implementation of std::is_literal_type yet.
    AddKeyword(/*STRINGREF_STR*/"__is_literal", tok.TokenKind.kw___is_literal, KEYCXX, LangOpts, /*Deref*/this);
    // Name for GCC 4.6 compatibility - people have already written libraries using
    // this name unfortunately.
    AddKeyword(/*STRINGREF_STR*/"__is_literal_type", tok.TokenKind.kw___is_literal, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_pod", tok.TokenKind.kw___is_pod, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_polymorphic", tok.TokenKind.kw___is_polymorphic, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_trivial", tok.TokenKind.kw___is_trivial, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_union", tok.TokenKind.kw___is_union, KEYCXX, LangOpts, /*Deref*/this);
    
    // Clang-only C++ Type Traits
    AddKeyword(/*STRINGREF_STR*/"__is_trivially_constructible", tok.TokenKind.kw___is_trivially_constructible, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_trivially_copyable", tok.TokenKind.kw___is_trivially_copyable, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_trivially_assignable", tok.TokenKind.kw___is_trivially_assignable, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__underlying_type", tok.TokenKind.kw___underlying_type, KEYCXX, LangOpts, /*Deref*/this);
    
    // Embarcadero Expression Traits
    AddKeyword(/*STRINGREF_STR*/"__is_lvalue_expr", tok.TokenKind.kw___is_lvalue_expr, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_rvalue_expr", tok.TokenKind.kw___is_rvalue_expr, KEYCXX, LangOpts, /*Deref*/this);
    
    // Embarcadero Unary Type Traits
    AddKeyword(/*STRINGREF_STR*/"__is_arithmetic", tok.TokenKind.kw___is_arithmetic, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_floating_point", tok.TokenKind.kw___is_floating_point, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_integral", tok.TokenKind.kw___is_integral, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_complete_type", tok.TokenKind.kw___is_complete_type, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_void", tok.TokenKind.kw___is_void, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_array", tok.TokenKind.kw___is_array, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_function", tok.TokenKind.kw___is_function, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_reference", tok.TokenKind.kw___is_reference, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_lvalue_reference", tok.TokenKind.kw___is_lvalue_reference, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_rvalue_reference", tok.TokenKind.kw___is_rvalue_reference, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_fundamental", tok.TokenKind.kw___is_fundamental, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_object", tok.TokenKind.kw___is_object, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_scalar", tok.TokenKind.kw___is_scalar, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_compound", tok.TokenKind.kw___is_compound, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_pointer", tok.TokenKind.kw___is_pointer, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_member_object_pointer", tok.TokenKind.kw___is_member_object_pointer, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_member_function_pointer", tok.TokenKind.kw___is_member_function_pointer, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_member_pointer", tok.TokenKind.kw___is_member_pointer, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_const", tok.TokenKind.kw___is_const, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_volatile", tok.TokenKind.kw___is_volatile, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_standard_layout", tok.TokenKind.kw___is_standard_layout, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_signed", tok.TokenKind.kw___is_signed, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_unsigned", tok.TokenKind.kw___is_unsigned, KEYCXX, LangOpts, /*Deref*/this);
    
    // Embarcadero Binary Type Traits
    AddKeyword(/*STRINGREF_STR*/"__is_same", tok.TokenKind.kw___is_same, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__is_convertible", tok.TokenKind.kw___is_convertible, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__array_rank", tok.TokenKind.kw___array_rank, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__array_extent", tok.TokenKind.kw___array_extent, KEYCXX, LangOpts, /*Deref*/this);
    
    // Apple Extension.
    AddKeyword(/*STRINGREF_STR*/"__private_extern__", tok.TokenKind.kw___private_extern__, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__module_private__", tok.TokenKind.kw___module_private__, KEYALL, LangOpts, /*Deref*/this);
    
    // Extension that will be enabled for Microsoft, Borland and PS4, but can be
    // disabled via '-fno-declspec'.
    AddKeyword(/*STRINGREF_STR*/"__declspec", tok.TokenKind.kw___declspec, 0, LangOpts, /*Deref*/this);
    
    // Microsoft Extension.
    AddKeyword(/*STRINGREF_STR*/"__cdecl", tok.TokenKind.kw___cdecl, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__stdcall", tok.TokenKind.kw___stdcall, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__fastcall", tok.TokenKind.kw___fastcall, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__thiscall", tok.TokenKind.kw___thiscall, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__vectorcall", tok.TokenKind.kw___vectorcall, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__forceinline", tok.TokenKind.kw___forceinline, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__unaligned", tok.TokenKind.kw___unaligned, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__super", tok.TokenKind.kw___super, KEYMS, LangOpts, /*Deref*/this);
    
    // OpenCL address space qualifiers
    AddKeyword(/*STRINGREF_STR*/"__global", tok.TokenKind.kw___global, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__local", tok.TokenKind.kw___local, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__constant", tok.TokenKind.kw___constant, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__private", tok.TokenKind.kw___private, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__generic", tok.TokenKind.kw___generic, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"global", tok.TokenKind.kw___global, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"local", tok.TokenKind.kw___local, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"constant", tok.TokenKind.kw___constant, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"private", tok.TokenKind.kw___private, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"generic", tok.TokenKind.kw___generic, KEYOPENCL, LangOpts, /*Deref*/this);
    // OpenCL function qualifiers
    AddKeyword(/*STRINGREF_STR*/"__kernel", tok.TokenKind.kw___kernel, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"kernel", tok.TokenKind.kw___kernel, KEYOPENCL, LangOpts, /*Deref*/this);
    // OpenCL access qualifiers
    AddKeyword(/*STRINGREF_STR*/"__read_only", tok.TokenKind.kw___read_only, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__write_only", tok.TokenKind.kw___write_only, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__read_write", tok.TokenKind.kw___read_write, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"read_only", tok.TokenKind.kw___read_only, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"write_only", tok.TokenKind.kw___write_only, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"read_write", tok.TokenKind.kw___read_write, KEYOPENCL, LangOpts, /*Deref*/this);
    // OpenCL builtins
    AddKeyword(/*STRINGREF_STR*/"__builtin_astype", tok.TokenKind.kw___builtin_astype, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"vec_step", tok.TokenKind.kw_vec_step, KEYOPENCL | KEYALTIVEC | KEYZVECTOR, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image1d_t", tok.TokenKind.kw_image1d_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image1d_array_t", tok.TokenKind.kw_image1d_array_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image1d_buffer_t", tok.TokenKind.kw_image1d_buffer_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image2d_t", tok.TokenKind.kw_image2d_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image2d_array_t", tok.TokenKind.kw_image2d_array_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image2d_depth_t", tok.TokenKind.kw_image2d_depth_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image2d_array_depth_t", tok.TokenKind.kw_image2d_array_depth_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image2d_msaa_t", tok.TokenKind.kw_image2d_msaa_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image2d_array_msaa_t", tok.TokenKind.kw_image2d_array_msaa_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image2d_msaa_depth_t", tok.TokenKind.kw_image2d_msaa_depth_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image2d_array_msaa_depth_t", tok.TokenKind.kw_image2d_array_msaa_depth_t, KEYOPENCL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"image3d_t", tok.TokenKind.kw_image3d_t, KEYOPENCL, LangOpts, /*Deref*/this);
    
    // OpenMP Type Traits
    AddKeyword(/*STRINGREF_STR*/"__builtin_omp_required_simd_align", tok.TokenKind.kw___builtin_omp_required_simd_align, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"pipe", tok.TokenKind.kw_pipe, KEYOPENCL, LangOpts, /*Deref*/this);
    
    // Borland Extensions.
    AddKeyword(/*STRINGREF_STR*/"__pascal", tok.TokenKind.kw___pascal, KEYALL, LangOpts, /*Deref*/this);
    
    // Altivec Extension.
    AddKeyword(/*STRINGREF_STR*/"__vector", tok.TokenKind.kw___vector, KEYALTIVEC | KEYZVECTOR, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__pixel", tok.TokenKind.kw___pixel, KEYALTIVEC, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__bool", tok.TokenKind.kw___bool, KEYALTIVEC | KEYZVECTOR, LangOpts, /*Deref*/this);
    
    // ARM NEON extensions.
    AddKeyword(/*STRINGREF_STR*/"__fp16", tok.TokenKind.kw_half, KEYALL, LangOpts, /*Deref*/this);
    
    // OpenCL Extension.
    AddKeyword(/*STRINGREF_STR*/"half", tok.TokenKind.kw_half, HALFSUPPORT, LangOpts, /*Deref*/this);
    
    // Objective-C ARC keywords.
    AddKeyword(/*STRINGREF_STR*/"__bridge", tok.TokenKind.kw___bridge, KEYARC, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__bridge_transfer", tok.TokenKind.kw___bridge_transfer, KEYARC, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__bridge_retained", tok.TokenKind.kw___bridge_retained, KEYARC, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__bridge_retain", tok.TokenKind.kw___bridge_retain, KEYARC, LangOpts, /*Deref*/this);
    
    // Objective-C keywords.
    AddKeyword(/*STRINGREF_STR*/"__covariant", tok.TokenKind.kw___covariant, KEYOBJC2, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__contravariant", tok.TokenKind.kw___contravariant, KEYOBJC2, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__kindof", tok.TokenKind.kw___kindof, KEYOBJC2, LangOpts, /*Deref*/this);
    
    // Alternate spelling for various tokens.  There are GCC extensions in all
    // languages, but should not be disabled in strict conformance mode.
    AddKeyword(/*STRINGREF_STR*/"__alignof__", tok.TokenKind.kw___alignof, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__asm", tok.TokenKind.kw_asm, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__asm__", tok.TokenKind.kw_asm, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__attribute__", tok.TokenKind.kw___attribute, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__complex", tok.TokenKind.kw__Complex, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__complex__", tok.TokenKind.kw__Complex, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__const", tok.TokenKind.kw_const, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__const__", tok.TokenKind.kw_const, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__decltype", tok.TokenKind.kw_decltype, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__imag__", tok.TokenKind.kw___imag, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__inline", tok.TokenKind.kw_inline, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__inline__", tok.TokenKind.kw_inline, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__nullptr", tok.TokenKind.kw_nullptr, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__real__", tok.TokenKind.kw___real, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__restrict", tok.TokenKind.kw_restrict, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__restrict__", tok.TokenKind.kw_restrict, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__signed", tok.TokenKind.kw_signed, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__signed__", tok.TokenKind.kw_signed, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__typeof", tok.TokenKind.kw_typeof, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__typeof__", tok.TokenKind.kw_typeof, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__volatile", tok.TokenKind.kw_volatile, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__volatile__", tok.TokenKind.kw_volatile, KEYALL, LangOpts, /*Deref*/this);
    
    // Type nullability.
    AddKeyword(/*STRINGREF_STR*/"_Nonnull", tok.TokenKind.kw__Nonnull, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Nullable", tok.TokenKind.kw__Nullable, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_Null_unspecified", tok.TokenKind.kw__Null_unspecified, KEYALL, LangOpts, /*Deref*/this);
    
    // Microsoft extensions which should be disabled in strict conformance mode
    AddKeyword(/*STRINGREF_STR*/"__ptr64", tok.TokenKind.kw___ptr64, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__ptr32", tok.TokenKind.kw___ptr32, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__sptr", tok.TokenKind.kw___sptr, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__uptr", tok.TokenKind.kw___uptr, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__w64", tok.TokenKind.kw___w64, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__uuidof", tok.TokenKind.kw___uuidof, KEYMS | KEYBORLAND, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__try", tok.TokenKind.kw___try, KEYMS | KEYBORLAND, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__finally", tok.TokenKind.kw___finally, KEYMS | KEYBORLAND, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__leave", tok.TokenKind.kw___leave, KEYMS | KEYBORLAND, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__int64", tok.TokenKind.kw___int64, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__if_exists", tok.TokenKind.kw___if_exists, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__if_not_exists", tok.TokenKind.kw___if_not_exists, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__single_inheritance", tok.TokenKind.kw___single_inheritance, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__multiple_inheritance", tok.TokenKind.kw___multiple_inheritance, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__virtual_inheritance", tok.TokenKind.kw___virtual_inheritance, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__interface", tok.TokenKind.kw___interface, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__int8", tok.TokenKind.kw_char, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_int8", tok.TokenKind.kw_char, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__int16", tok.TokenKind.kw_short, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_int16", tok.TokenKind.kw_short, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__int32", tok.TokenKind.kw_int, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_int32", tok.TokenKind.kw_int, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_int64", tok.TokenKind.kw___int64, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__wchar_t", tok.TokenKind.kw_wchar_t, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_asm", tok.TokenKind.kw_asm, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_alignof", tok.TokenKind.kw___alignof, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__builtin_alignof", tok.TokenKind.kw___alignof, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_cdecl", tok.TokenKind.kw___cdecl, KEYMS | KEYBORLAND, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_fastcall", tok.TokenKind.kw___fastcall, KEYMS | KEYBORLAND, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_stdcall", tok.TokenKind.kw___stdcall, KEYMS | KEYBORLAND, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_thiscall", tok.TokenKind.kw___thiscall, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_vectorcall", tok.TokenKind.kw___vectorcall, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_uuidof", tok.TokenKind.kw___uuidof, KEYMS | KEYBORLAND, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_inline", tok.TokenKind.kw_inline, KEYMS, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"_declspec", tok.TokenKind.kw___declspec, KEYMS, LangOpts, /*Deref*/this);
    
    // Borland Extensions which should be disabled in strict conformance mode.
    AddKeyword(/*STRINGREF_STR*/"_pascal", tok.TokenKind.kw___pascal, KEYBORLAND, LangOpts, /*Deref*/this);
    
    // Clang Extensions.
    AddKeyword(/*STRINGREF_STR*/"__builtin_convertvector", tok.TokenKind.kw___builtin_convertvector, KEYALL, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__char16_t", tok.TokenKind.kw_char16_t, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__char32_t", tok.TokenKind.kw_char32_t, KEYCXX, LangOpts, /*Deref*/this);
    AddKeyword(/*STRINGREF_STR*/"__builtin_available", tok.TokenKind.kw___builtin_available, KEYALL, LangOpts, /*Deref*/this);
    
    //===----------------------------------------------------------------------===//
    // Objective-C @-preceded keywords.
    //===----------------------------------------------------------------------===//
    
    // These have meaning after an '@' in Objective-C mode. These define enums in
    // the tok::objc_* namespace.
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"not_keyword", tok.ObjCKeywordKind.objc_not_keyword, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"class", tok.ObjCKeywordKind.objc_class, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"compatibility_alias", tok.ObjCKeywordKind.objc_compatibility_alias, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"defs", tok.ObjCKeywordKind.objc_defs, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"encode", tok.ObjCKeywordKind.objc_encode, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"end", tok.ObjCKeywordKind.objc_end, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"implementation", tok.ObjCKeywordKind.objc_implementation, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"interface", tok.ObjCKeywordKind.objc_interface, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"private", tok.ObjCKeywordKind.objc_private, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"protected", tok.ObjCKeywordKind.objc_protected, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"protocol", tok.ObjCKeywordKind.objc_protocol, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"public", tok.ObjCKeywordKind.objc_public, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"selector", tok.ObjCKeywordKind.objc_selector, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"throw", tok.ObjCKeywordKind.objc_throw, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"try", tok.ObjCKeywordKind.objc_try, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"catch", tok.ObjCKeywordKind.objc_catch, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"finally", tok.ObjCKeywordKind.objc_finally, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"synchronized", tok.ObjCKeywordKind.objc_synchronized, /*Deref*/this);
    }
    if (LangOpts.ObjC1) {
      AddObjCKeyword(/*STRINGREF_STR*/"autoreleasepool", tok.ObjCKeywordKind.objc_autoreleasepool, /*Deref*/this);
    }
    if (LangOpts.ObjC2) {
      AddObjCKeyword(/*STRINGREF_STR*/"property", tok.ObjCKeywordKind.objc_property, /*Deref*/this);
    }
    if (LangOpts.ObjC2) {
      AddObjCKeyword(/*STRINGREF_STR*/"package", tok.ObjCKeywordKind.objc_package, /*Deref*/this);
    }
    if (LangOpts.ObjC2) {
      AddObjCKeyword(/*STRINGREF_STR*/"required", tok.ObjCKeywordKind.objc_required, /*Deref*/this);
    }
    if (LangOpts.ObjC2) {
      AddObjCKeyword(/*STRINGREF_STR*/"optional", tok.ObjCKeywordKind.objc_optional, /*Deref*/this);
    }
    if (LangOpts.ObjC2) {
      AddObjCKeyword(/*STRINGREF_STR*/"synthesize", tok.ObjCKeywordKind.objc_synthesize, /*Deref*/this);
    }
    if (LangOpts.ObjC2) {
      AddObjCKeyword(/*STRINGREF_STR*/"dynamic", tok.ObjCKeywordKind.objc_dynamic, /*Deref*/this);
    }
    if (LangOpts.ObjC2) {
      AddObjCKeyword(/*STRINGREF_STR*/"import", tok.ObjCKeywordKind.objc_import, /*Deref*/this);
    }
    if (LangOpts.ObjC2) {
      AddObjCKeyword(/*STRINGREF_STR*/"available", tok.ObjCKeywordKind.objc_available, /*Deref*/this);
    }
    if (LangOpts.ParseUnknownAnytype) {
      AddKeyword(/*STRINGREF_STR*/"__unknown_anytype", tok.TokenKind.kw___unknown_anytype, KEYALL, 
          LangOpts, /*Deref*/this);
    }
    if (LangOpts.DeclSpecKeyword) {
      AddKeyword(/*STRINGREF_STR*/"__declspec", tok.TokenKind.kw___declspec, KEYALL, LangOpts, /*Deref*/this);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierTable::~IdentifierTable">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 446,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 431,
   FQN="clang::IdentifierTable::~IdentifierTable", NM="_ZN5clang15IdentifierTableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang15IdentifierTableD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor>>>*/
    $releaseHashTable(HashTable, ExternalLookup); HashTable = null;
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public Iterator<IdentifierInfoStringMapEntry> iterator() { return new JavaIterator<>(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

}
