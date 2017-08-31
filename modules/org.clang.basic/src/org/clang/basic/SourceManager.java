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
import org.clang.basic.llvm.DenseMapInfoIntFileID;
import java.util.logging.Level;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.impl.SourceManagerStatics.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;


/// \brief This class handles loading and caching of source files into memory.
///
/// This object owns the MemoryBuffer objects for all of the loaded
/// files and assigns unique FileID's for each unique \#include chain.
///
/// The SourceManager can be queried for information about SourceLocation
/// objects, turning them into either spelling or expansion locations. Spelling
/// locations represent where the bytes corresponding to a token came from and
/// expansion locations represent where the location is in the user's view. In
/// the case of a macro expansion, for example, the spelling location indicates
/// where the expanded token came from and the expansion location specifies
/// where it was expanded.
//<editor-fold defaultstate="collapsed" desc="clang::SourceManager">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PERF*/,
 optimized = Converted.Optimization.COMPLEX,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 549,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 550,
 FQN="clang::SourceManager", NM="_ZN5clang13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManagerE")
//</editor-fold>
public final class SourceManager extends RefCountedBase<SourceManager> implements /*public*/ Destructors.ClassWithDestructor {
  /// \brief DiagnosticsEngine object.
  private DiagnosticsEngine /*&*/ Diag;
  
  private FileManager /*&*/ FileMgr;
  
  private /*mutable */BumpPtrAllocator ContentCacheAlloc;
  
  /// \brief Memoized information about all of the files tracked by this
  /// SourceManager.
  ///
  /// This map allows us to merge ContentCache entries based
  /// on their FileEntry*.  All ContentCache objects will thus have unique,
  /// non-null, FileEntry pointers.
  private DenseMap</*const*/FileEntry /*P*/ , SrcMgr.ContentCache /*P*/ > FileInfos;
  
  /// JAVA: keep all in one array to prevent reinterpret casts
  private SmallVector<SrcMgr.ContentCache /*P*/ > AllContentCaches;
  
  /// \brief True if the ContentCache for files that are overridden by other
  /// files, should report the original file name. Defaults to true.
  private boolean OverridenFilesKeepOriginalName;
  
  /// \brief True if non-system source files should be treated as volatile
  /// (likely to change while trying to use them). Defaults to false.
  private boolean UserFilesAreVolatile;
  
  /// \brief True if all files read during this compilation should be treated
  /// as transient (may not be present in later compilations using a module
  /// file created from this compilation). Defaults to false.
  private boolean FilesAreTransient;
  
  // JAVA: allow to repair volatile files
  boolean repairVolatileContentCache(SrcMgr.ContentCache ContentCache) {
    boolean repaired = false;
    if (AllContentCaches.$at(AllContentCaches.size()-1) == ContentCache) {
      // recently allocated content cache, it's safe to adjust NextLocalOffset
      if (LocalSLocEntryTable.$getContentCacheIndex(LocalSLocEntryTable.size()-1) == ContentCache.$index()) {
        assert ContentCache.getRawBuffer() != null : "No Buffer in " + ContentCache;
        assert ContentCache.ContentsEntry != null : "No File Entry in " + ContentCache;
        /*size_t*/int BufferSize = ContentCache.getRawBuffer().getBufferSize();
        long/*off_t*/ FileSize = ContentCache.ContentsEntry.getSize();
        FileManager.modifyFileEntry(ContentCache.ContentsEntry, BufferSize, 0);
        this.NextLocalOffset += (BufferSize-FileSize);
        repaired = true;
      } else {
        repaired = false;
      }
    } else {
      repaired = false;
    }
    
    NativeTrace.getLogger().log(repaired ? Level.FINE : Level.INFO, "SM {0}:{1} {7} repairVolatileContentCache {2}:\n\tBufSize={3} vs. FileEntry.Size={4} [{5}]:\n{6}", 
              new Object[]{System.identityHashCode(this), NextLocalOffset, Casts.toJavaString(ContentCache.ContentsEntry.Name), 
                ContentCache.getRawBuffer().getBufferSize(), ContentCache.ContentsEntry.getSize(),
                Thread.currentThread().getName(), ContentCache.ContentsEntry, repaired ? "DONE" : "FAILED"});
    return repaired;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::OverriddenFilesInfoTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 578,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 579,
   FQN="clang::SourceManager::OverriddenFilesInfoTy", NM="_ZN5clang13SourceManager21OverriddenFilesInfoTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager21OverriddenFilesInfoTyE")
  //</editor-fold>
  private static class/*struct*/ OverriddenFilesInfoTy implements Destructors.ClassWithDestructor {
    /// \brief Files that have been overridden with the contents from another
    /// file.
    public DenseMap</*const*/ FileEntry /*P*/ , /*const*/ FileEntry /*P*/ > OverriddenFiles;
    /// \brief Files that were overridden with a memory buffer.
    public DenseSet</*const*/ FileEntry /*P*/ > OverriddenFilesWithBuffer;
    //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::OverriddenFilesInfoTy::~OverriddenFilesInfoTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 578,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 579,
     FQN="clang::SourceManager::OverriddenFilesInfoTy::~OverriddenFilesInfoTy", NM="_ZN5clang13SourceManager21OverriddenFilesInfoTyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager21OverriddenFilesInfoTyD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      OverriddenFilesWithBuffer.$destroy();
      OverriddenFiles.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::OverriddenFilesInfoTy::OverriddenFilesInfoTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 578,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 579,
     FQN="clang::SourceManager::OverriddenFilesInfoTy::OverriddenFilesInfoTy", NM="_ZN5clang13SourceManager21OverriddenFilesInfoTyC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager21OverriddenFilesInfoTyC1Ev")
    //</editor-fold>
    public /*inline*/ OverriddenFilesInfoTy() {
      /* : OverriddenFiles(), OverriddenFilesWithBuffer()*/ 
      //START JInit
      this.OverriddenFiles = new DenseMap</*const*/ FileEntry /*P*/ , /*const*/ FileEntry /*P*/ >(FileEntry.DMI$FileEntryPtr, null/*pointer*/);
      this.OverriddenFilesWithBuffer = new DenseSet</*const*/ FileEntry /*P*/ >(FileEntry.DMI$FileEntryPtr);
      //END JInit
    }

    
    public String toString() {
      return "" + "OverriddenFiles=" + OverriddenFiles // NOI18N
                + ", OverriddenFilesWithBuffer=" + OverriddenFilesWithBuffer; // NOI18N
    }    
  };
  
  /// \brief Lazily create the object keeping overridden files info, since
  /// it is uncommonly used.
  private std.unique_ptr<OverriddenFilesInfoTy> OverriddenFilesInfo;
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getOverriddenFilesInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 590,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 591,
   FQN="clang::SourceManager::getOverriddenFilesInfo", NM="_ZN5clang13SourceManager22getOverriddenFilesInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager22getOverriddenFilesInfoEv")
  //</editor-fold>
  private OverriddenFilesInfoTy /*&*/ getOverriddenFilesInfo() {
    if (!OverriddenFilesInfo.$bool()) {
      OverriddenFilesInfo.reset(new OverriddenFilesInfoTy());
    }
    return OverriddenFilesInfo.$star();
  }

  
  /// \brief Information about various memory buffers that we have read in.
  ///
  /// All FileEntry* within the stored ContentCache objects are NULL,
  /// as they do not refer to a file.
  private std.vector<SrcMgr.ContentCache /*P*/ > MemBufferInfos;

  // JAVA PERF: optimize memory usage by SmallVectorSLocEntry Pool 
  public static final String SLOC_ENTY_VECTOR_REUSE_PROP = "clank.slocentry.vector.reuse";
  public static final boolean SLOC_ENTY_VECTOR_REUSE = Boolean.getBoolean(System.getProperty(SLOC_ENTY_VECTOR_REUSE_PROP, "false"));

  /// \brief The table of SLocEntries that are local to this module.
  ///
  /// Positive FileIDs are indexes into this table. Entry 0 indicates an invalid
  /// expansion.
//  private SmallVector<SrcMgr.SLocEntry> LocalSLocEntryTable;
  public static final int DEFAULT_LOCAL_SLOC_ENTRY_TABLE_CAPACITY = Integer.getInteger("clank.sm.local.size", 32/*K*/*1024);
  private SmallVectorSLocEntry LocalSLocEntryTable;
  
  /// \brief The table of SLocEntries that are loaded from other modules.
  ///
  /// Negative FileIDs are indexes into this table. To get from ID to an index,
  /// use (-ID - 2).
//  private /*mutable */SmallVector<SrcMgr.SLocEntry> LoadedSLocEntryTable;
  private static final int DEFAULT_LOADED_SLOC_ENTRY_TABLE_CAPACITY = 0;
  private /*mutable */SmallVectorSLocEntry LoadedSLocEntryTable;
  
  /// \brief The starting offset of the next local SLocEntry.
  ///
  /// This is LocalSLocEntryTable.back().Offset + the size of that entry.
  private /*uint*/int NextLocalOffset;
  
  /// \brief The starting offset of the latest batch of loaded SLocEntries.
  ///
  /// This is LoadedSLocEntryTable.back().Offset, except that that entry might
  /// not have been loaded, so that value would be unknown.
  private /*uint*/int CurrentLoadedOffset;
  
  /// \brief The highest possible offset is 2^31-1, so CurrentLoadedOffset
  /// starts at 2^31.
  /*friend*/public static final/*const*//*uint*/int MaxLoadedOffset = 1/*U*/ << 31/*U*/;
  
  /// \brief A bitmap that indicates whether the entries of LoadedSLocEntryTable
  /// have already been loaded from the external source.
  ///
  /// Same indexing as LoadedSLocEntryTable.
  private std.vectorBool SLocEntryLoaded; // JAVA: native is llvm::BitVector SLocEntryLoaded;
  
  /// \brief An external source for source location entries.
  private ExternalSLocEntrySource /*P*/ ExternalSLocEntries;
  
  /// \brief A one-entry cache to speed up getFileID.
  ///
  /// LastFileIDLookup records the last FileID looked up or created, because it
  /// is very common to look up many tokens from the same file.
  private /*mutable FileID*/int LastFileIDLookup;
  
  // used slice index of LastFileIDLookup and corresponding int[]
  private /*mutable*/int LastFileIDLookupLocalSlice;
  private /*mutable*/int[] LastFileIDLookupLocalSliceArray;
  // global and slice-local index of LastFileIDLookup from local SLocEntryTable
  private /*mutable*/int LastFileIDLookupLocalSLocEntryIndex;
  private /*mutable*/int LastFileIDLookupLocalIndexInSlice;
  // offset of last local FileID
  private /*mutable*/int LastFileIDLookupLocalOffset;

  // locals for macro IDs
  private static final boolean USE_LAST_MACRO_ID = Boolean.valueOf(System.getProperty("use.last.macro", "true"));
  /// \brief A one-entry cache to speed up getFileID.
  ///
  /// LastMacroIDLookup records the last FileID looked up or created, because it
  /// is very common to look up many tokens from the same macro.  
  private /*mutable FileID*/int LastMacroIDLookup;
  
  // used slice index of LastMacroIDLookup and corresponding int[]
  private /*mutable*/int LastMacroIDLookupLocalSlice;
  private /*mutable*/int[] LastMacroIDLookupLocalSliceArray;
  // global and slice-local index of LastMacroIDLookup from local SLocEntryTable
  private /*mutable*/int LastMacroIDLookupLocalSLocEntryIndex;
  private /*mutable*/int LastMacroIDLookupLocalIndexInSlice;
  // offset of last local MacroID
  private /*mutable*/int LastMacroIDLookupLocalOffset;
  
  // commont cache values for local table
  // when LastFileIDLookup is from LocalSLocEntryTable then the following
  // cache values are used for getFileIDLocal
  private /*mutable*/boolean LocalSLocTableIsSliced;
  // the mask for converting global index into slice-local index
  private /*mutable*/int LocalSliceMaskForIndex;
  // the slice Size
  private /*mutable*/int LocalSliceSize;
  // the Greatest upper index for FID 
  private /*mutable*/int MaxIndexInLastLocalSlice;
  // the max number of used slices
  private /*mutable*/int LocalMaxSliceIndex;
  // cached LocalSLocTable size
  private /*mutable*/int local_sloc_entry_size;
  
  // TODO: when LastFileIDLookup is from LoadedSLocEntryTable then the following
  // cache values should be used for getFileIDLoaded
  private /*mutable*/boolean LoadedSLocTableIsSliced;
  private /*mutable*/int LastFileIDLookupLoadedSlice;
  private /*mutable*/int LastMacroIDLookupLoadedSlice;
  
  /// \brief Holds information for \#line directives.
  ///
  /// This is referenced by indices from SLocEntryTable.
  private LineTableInfo /*P*/ LineTable;
  
  /// \brief These ivars serve as a cache used in the getLineNumber
  /// method which is used to speedup getLineNumber calls to nearby locations.
  private /*mutable *//*FileID*/int LastLineNoFileIDQuery;
  private /*mutable */SrcMgr.ContentCache /*P*/ LastLineNoContentCache;
  private /*mutable *//*uint*/int LastLineNoFilePos;
  private /*mutable *//*uint*/int LastLineNoResult;
  
  /// \brief The file ID for the main source file of the translation unit.
  private FileID MainFileID;
  
  /// \brief The file ID for the precompiled preamble there is one.
  private FileID PreambleFileID;
  
  // Statistics for -print-stats.  
  private /*mutable *//*uint*/int NumLinearMacroScans;
  private /*mutable *//*uint*/int NumBinaryMacroProbes;
  private /*mutable *//*uint*/int NumLinearScans;
  private /*mutable *//*uint*/int NumBinaryProbes;
  // statistics about slices lookup in getFileID
  private /*mutable *//*uint*/int NumLinearSliceScans;
  private /*mutable *//*uint*/int NumImmediateSliceScans;
  private /*mutable *//*uint*/int NumBinarySliceProbes;
  
  /// \brief Associates a FileID with its "included/expanded in" decomposed
  /// location.
  ///
  /// Used to cache results from and speed-up \c getDecomposedIncludedLoc
  /// function.
  private /*mutable */DenseMapIntLong/*FileID, std.pairIntUInt/*<FileID, uint>>*/ IncludedLocMap;
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private static final /*std.pair<FileID, uint>*/long $INCLUDED_LOC_MAP_NO_ENTRY_MARKER = wrap_FileID_Offset(FileID.getSentinelID(), 0xCDCDCDCD);
  private static final /*std.pair<FileID, uint>*/long $INVALID_FILEID_ZERO_OFFSET = wrap_FileID_Offset(FileID.getInvalidID(), 0);
  public static final /*SLocEntry*/int INVALID_SLOC_ENTRY_INDEX = 0;
  
  /// The key value into the IsBeforeInTUCache table.
  /*typedef std::pair<FileID, FileID> IsBeforeInTUCacheKey*/
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private static final class DenseMapInfoIsBeforeInTUCacheKey extends DenseMapInfoULong {
  
    private static final /*pair<FileID, FileID>*/long emptyKey = wrap_int_int_pair(FileID.getInvalidID(), FileID.getInvalidID());
    
    private static final /*pair<FileID, FileID>*/long tombstoneKey = wrap_int_int_pair(FileID.getSentinelID(), FileID.getSentinelID());

    public DenseMapInfoIsBeforeInTUCacheKey() {
      super(emptyKey, tombstoneKey);
    }

    @Override
    public int getHashValue(/*<FileID, FileID>*/long key) {
      assert key != emptyKey : "must not be called for emptyKey";
      assert key != tombstoneKey : "must not be called for tombstoneKey";
      key += ~(key << 32);
      key ^= (key >>> 22);
      key += ~(key << 13);
      key ^= (key >>> 8);
      key += (key << 3);
      key ^= (key >>> 15);
      key += ~(key << 27);
      key ^= (key >>> 31);
      return (/*uint*/int)key;
    }
  }
  
  /// The IsBeforeInTranslationUnitCache is a mapping from FileID pairs
  /// to cache results.
  /*typedef llvm::DenseMap<IsBeforeInTUCacheKey, InBeforeInTUCacheEntry> InBeforeInTUCache*/
  public final class InBeforeInTUCache extends DenseMapULongType</*IsBeforeInTUCacheKey = pair<FileID, FileID>, */InBeforeInTUCacheEntry>{

    public InBeforeInTUCache() {
      super(new DenseMapInfoIsBeforeInTUCacheKey(), new InBeforeInTUCacheEntry());
    }
 };
  
  /// Cache results for the isBeforeInTranslationUnit method.
  private /*mutable */InBeforeInTUCache IBTUCache;
  private /*mutable */InBeforeInTUCacheEntry IBTUCacheOverflow;

    // This is a magic number for limiting the cache size.  It was experimentally
    // derived from a small Objective-C project (where the cache filled
    // out to ~250 items).  We can make it larger if necessary.
    //<editor-fold defaultstate="collapsed" desc="">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 2005,
     FQN="", NM="_ZNK5clang13SourceManager20getInBeforeInTUCacheENS_6FileIDES1__Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager20getInBeforeInTUCacheENS_6FileIDES1__Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
    private static final /*uint*/int MagicCacheSize = 300;
    /*}*/;
    
  /// Return the cache entry for comparing the given file IDs
  /// for isBeforeInTranslationUnit.
  
  /// Return the cache entry for comparing the given file IDs
  /// for isBeforeInTranslationUnit.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getInBeforeInTUCache">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 2007,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 2000,
   FQN="clang::SourceManager::getInBeforeInTUCache", NM="_ZNK5clang13SourceManager20getInBeforeInTUCacheENS_6FileIDES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager20getInBeforeInTUCacheENS_6FileIDES1_")
  //</editor-fold>
  private InBeforeInTUCacheEntry /*&*/ getInBeforeInTUCache(/*FileID*/int LFID, /*FileID*/int RFID) /*const*/ {
    /*<FileID, FileID>*/long Key/*J*/= wrap_int_int_pair(LFID, RFID);
    
    // If the cache size isn't too large, do a lookup and if necessary default
    // construct an entry.  We can then return it to the caller for direct
    // use.  When they update the value, the cache will get automatically
    // updated as well.
    if ($less_uint(IBTUCache.size(), MagicCacheSize)) {
      return IBTUCache.$at(Key);
    }
    
    // Otherwise, do a lookup that will not construct a new value.
    DenseMapIteratorULongType<InBeforeInTUCacheEntry> I = IBTUCache.find(Key);
    if (I.$noteq(IBTUCache.end())) {
      return I.$arrow().second;
    }
    
    // Fall back to the overflow value.
    return IBTUCacheOverflow;
  }

  
  // Cache for the "fake" buffer used for error-recovery purposes.
  private static final char$ptr INVALID_BUFFER_CHAR_PTR = $("<<<<INVALID BUFFER>>>>");
  private static final StringRef INVALID_BUFFER_STRING_REF = new StringRef(INVALID_BUFFER_CHAR_PTR);
  private /*mutable */std.unique_ptr<MemoryBuffer> FakeBufferForRecovery;
  
  private /*mutable */std.unique_ptr<SrcMgr.ContentCache> FakeContentCacheForRecovery;
  private static final int FAKE_CONTENT_CACHE_INDEX = -1;
  
  /// \brief Lazily computed map of macro argument chunks to their expanded
  /// source location.
  /*typedef std::map<unsigned int, SourceLocation> MacroArgsMap*/
//  public final class MacroArgsMap extends std.mapUIntType<SourceLocation>{ };
  
  private /*mutable */DenseMapIntType</*FileID, */std.mapUIntType<SourceLocation> /*P*/ > MacroArgsCacheMap;
  
  /// \brief The stack of modules being built, which is used to detect
  /// cycles in the module dependency graph as modules are being built, as
  /// well as to describe why we're rebuilding a particular module.
  ///
  /// There is no way to set this value from the command line. If we ever need
  /// to do so (e.g., if on-demand module construction moves out-of-process),
  /// we can add a cc1-level option to do so.
  private SmallVector<std.pair<std.string, FullSourceLoc>> StoredModuleBuildStack;
  
  // SourceManager doesn't support copy construction.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::SourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 709,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 710,
   FQN="clang::SourceManager::SourceManager", NM="_ZN5clang13SourceManagerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManagerC1ERKS0_")
  //</editor-fold>
  private /*explicit*/ SourceManager(/*const*/ SourceManager /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 710,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 711,
   FQN="clang::SourceManager::operator=", NM="_ZN5clang13SourceManageraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManageraSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ SourceManager /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // Private 'Create' methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::SourceManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,    
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 361,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 366,
   FQN="clang::SourceManager::SourceManager", NM="_ZN5clang13SourceManagerC1ERNS_17DiagnosticsEngineERNS_11FileManagerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManagerC1ERNS_17DiagnosticsEngineERNS_11FileManagerEb")
  //</editor-fold>
  public SourceManager(DiagnosticsEngine /*&*/ Diag, FileManager /*&*/ FileMgr) {
    this(Diag, FileMgr, 
      false);
  }
  public SourceManager(DiagnosticsEngine /*&*/ Diag, FileManager /*&*/ FileMgr, 
      boolean UserFilesAreVolatile/*= false*/) {
    /* : RefCountedBase<SourceManager>(), Diag(Diag), FileMgr(FileMgr), ContentCacheAlloc(), FileInfos(), OverridenFilesKeepOriginalName(true), UserFilesAreVolatile(UserFilesAreVolatile), FilesAreTransient(false), OverriddenFilesInfo(), MemBufferInfos(), LocalSLocEntryTable(), LoadedSLocEntryTable(), SLocEntryLoaded(), ExternalSLocEntries(null), LastFileIDLookup(), LineTable(null), LastLineNoFileIDQuery(), MainFileID(), PreambleFileID(), NumLinearScans(0), NumBinaryProbes(0), IncludedLocMap(), IBTUCache(), IBTUCacheOverflow(), FakeBufferForRecovery(), FakeContentCacheForRecovery(), MacroArgsCacheMap(), StoredModuleBuildStack()*/ 
    //START JInit
    super();
    this./*&*/Diag=/*&*/Diag;
    this./*&*/FileMgr=/*&*/FileMgr;
    this.ContentCacheAlloc = new BumpPtrAllocator();
    this.FileInfos = new DenseMap</*const*/FileEntry /*P*/ , SrcMgr.ContentCache /*P*/ >(FileEntry.DMI$FileEntryPtr, null/*pointer*/);
    this.AllContentCaches = new SmallVector<>(1024, null);
    this.OverridenFilesKeepOriginalName = true;
    this.UserFilesAreVolatile = UserFilesAreVolatile;
    this.FilesAreTransient = false;    
    this.OverriddenFilesInfo = new std.unique_ptr<OverriddenFilesInfoTy>();
    this.MemBufferInfos = new std.vector<SrcMgr.ContentCache /*P*/ >((SrcMgr.ContentCache)null /*new SrcMgr.ContentCache()*/);
    this.SLocEntryLoaded = new std.vectorBool();
    this.ExternalSLocEntries = null;
    this.LastFileIDLookup = 0;   
    this.LastFileIDLookupLocalSLocEntryIndex = 0;
    this.LastFileIDLookupLocalOffset = 0;
    this.LastMacroIDLookup = 0;
    this.LastMacroIDLookupLocalSLocEntryIndex = 0;
    this.LastMacroIDLookupLocalOffset = 0;
    this.LineTable = null;
    this.LastLineNoFileIDQuery = FileID.getInvalidID();
    this.MainFileID = new FileID();
    this.PreambleFileID = new FileID();
    this.NumLinearScans = 0;
    this.NumBinaryProbes = 0;
    this.NumLinearSliceScans = 0;
    this.NumImmediateSliceScans = 0;
    this.NumBinarySliceProbes = 0;
    this.NumLinearMacroScans = 0;
    this.NumBinaryMacroProbes = 0;
    this.IncludedLocMap = new DenseMapIntLong/*<FileID, std.pairIntUInt<FileID, uint>>*/(new DenseMapInfoIntFileID(), $INCLUDED_LOC_MAP_NO_ENTRY_MARKER);
    this.IBTUCache = new InBeforeInTUCache();
    this.IBTUCacheOverflow = new InBeforeInTUCacheEntry();
    this.FakeBufferForRecovery = new std.unique_ptr<MemoryBuffer>();
    this.FakeContentCacheForRecovery = new std.unique_ptr<SrcMgr.ContentCache>();
    this.MacroArgsCacheMap = new DenseMapIntType</*FileID, */std.mapUIntType<SourceLocation> /*P*/ >(new DenseMapInfoIntFileID(), null/*pointer*/);
    this.StoredModuleBuildStack = new SmallVector<std.pair<std.string, FullSourceLoc>>(2, new std.pair<std.string, FullSourceLoc>(new std.string(), new FullSourceLoc()));
    //END JInit
    initSLocTables();
    clearIDTables();
    Diag.setSourceManager(this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::~SourceManager">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 371,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 376,
   FQN="clang::SourceManager::~SourceManager", NM="_ZN5clang13SourceManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (LineTable != null) { LineTable.$destroy();};

    // Delete FileEntry objects corresponding to content caches.  Since the actual
    // content cache objects are bump pointer allocated, we just have to run the
    // dtors, but we call the deallocate method for completeness.
    for (/*uint*/int i = 0, e = MemBufferInfos.size(); i != e; ++i) {
      if ((MemBufferInfos.$at(i) != null)) {
        MemBufferInfos.$at(i).$destroy();
        ContentCacheAlloc.Deallocate$NotSameRemoveCV(MemBufferInfos.$at(i));
      }
    }
    for (DenseMapIterator</*const*/ FileEntry /*P*/ , SrcMgr.ContentCache /*P*/ > I = FileInfos.begin(), E = FileInfos.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
      if ((I.$arrow().second != null)) {
        I.$arrow().second.$destroy();
        ContentCacheAlloc.Deallocate$NotSameRemoveCV(I.$arrow().second);
      }
    }
    AllContentCaches.clear();
    llvm.DeleteContainerSeconds(MacroArgsCacheMap);
    //START JDestroy
    StoredModuleBuildStack.$destroy();
    MacroArgsCacheMap.$destroy();
    FakeContentCacheForRecovery.$destroy();
    FakeBufferForRecovery.$destroy();
    IBTUCache.$destroy();
    IncludedLocMap.$destroy();
    SLocEntryLoaded.$destroy();
    SmallVectorSLocEntry.$release(LoadedSLocEntryTable); LoadedSLocEntryTable = null;
    SmallVectorSLocEntry.$release(LocalSLocEntryTable); LocalSLocEntryTable = null;
    MemBufferInfos.$destroy();
    OverriddenFilesInfo.$destroy();
    FileInfos.$destroy();
    ContentCacheAlloc.$destroy();
    super.$destroy();
    //END JDestroy
  }

  private static boolean tracedEntryTables = false;
  private void initSLocTables() {
    this.LocalSLocEntryTable = SmallVectorSLocEntry.$create(DEFAULT_LOCAL_SLOC_ENTRY_TABLE_CAPACITY);
    this.LoadedSLocEntryTable = SmallVectorSLocEntry.$create(DEFAULT_LOADED_SLOC_ENTRY_TABLE_CAPACITY);
    if (NativeTrace.VERBOSE_MODE || NativeTrace.STATISTICS) {
      if (!tracedEntryTables) {
        tracedEntryTables = true;
        if (NativeTrace.STAT_OUT_FOLDER == null) {
          llvm.errs().$out("Using LocalTable ").$out(LocalSLocEntryTable.getClass().getSimpleName())
                  .$out(" with initial capacity ").$out(NativeTrace.formatNumber((NativeType.BYTES_IN_INT * LocalSLocEntryTable.capacity())/1024)).$out("K\n");
          llvm.errs().$out("Using LoadedTable ").$out(LoadedSLocEntryTable.getClass().getSimpleName())
                  .$out(" with initial capacity ").$out(NativeTrace.formatNumber((NativeType.BYTES_IN_INT * LoadedSLocEntryTable.capacity())/1024)).$out("K\n");
        }
      }
    }    
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::clearIDTables">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 394,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 399,
   FQN="clang::SourceManager::clearIDTables", NM="_ZN5clang13SourceManager13clearIDTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager13clearIDTablesEv")
  //</editor-fold>
  public void clearIDTables() {
    MainFileID.$assignMove(FileID.getInvalidID());
    LocalSLocEntryTable.clear();
    LoadedSLocEntryTable.clear();
    SLocEntryLoaded.clear();
    LastLineNoFileIDQuery = FileID.getInvalidID();
    LastLineNoContentCache = null;
    
    LastFileIDLookup = 0;
    
    LastMacroIDLookup = 0;
    if ((LineTable != null)) {
      LineTable.clear();
    }
    
    // Use up FileID #0 as an invalid expansion.
    NextLocalOffset = 0;
    // update one-cache values
    LastFileIDLookupLocalOffset = 0;
    LastFileIDLookupLocalSLocEntryIndex = 0;
    LastMacroIDLookupLocalOffset = 0;
    LastMacroIDLookupLocalSLocEntryIndex = 0;
    updateLocalSLocConstants();
    // loaded
    CurrentLoadedOffset = MaxLoadedOffset;
    LoadedSLocTableIsSliced = LoadedSLocEntryTable.isSlicedByOffsets();
    LastFileIDLookupLoadedSlice = 0;
    LastMacroIDLookupLoadedSlice = 0;
    createExpansionLoc(SourceLocation.getInvalid(), SourceLocation.getInvalid(), SourceLocation.getInvalid(), 1);
  }

  private void updateLocalSLocConstants() {
    // update LocalSLocEntryTable related values
    local_sloc_entry_size = LocalSLocEntryTable.size();
    LocalSLocTableIsSliced = LocalSLocEntryTable.isSlicedByOffsets();
    LastFileIDLookupLocalSliceArray = null;
    LastMacroIDLookupLocalSliceArray = null;
    if (LocalSLocTableIsSliced) {
      LocalMaxSliceIndex = LocalSLocEntryTable.$OffsetsMaxSliceIndex();
      LocalSliceSize = LocalSLocEntryTable.$OffsetsSliceSize();
      assert (LocalSliceSize & (LocalSliceSize-1)) == 0 : 
              "must be power of 2 " + Integer.toBinaryString(LocalSliceSize);
      LocalSliceMaskForIndex = LocalSliceSize - 1;
      MaxIndexInLastLocalSlice = (local_sloc_entry_size == 0) ? 0 : ((local_sloc_entry_size - 1) & LocalSliceMaskForIndex) + 1;
      // update File-based values
      LastFileIDLookupLocalSlice = LastFileIDLookupLocalSLocEntryIndex / LocalSliceSize;

      LastFileIDLookupLocalIndexInSlice = LastFileIDLookupLocalSLocEntryIndex & LocalSliceMaskForIndex;
      LastFileIDLookupLocalSliceArray = LocalSLocEntryTable.$OffsetsSliceByIndex(LastFileIDLookupLocalSlice);
      assert LastFileIDLookupLocalSLocEntryIndex == ((LastFileIDLookupLocalSlice*LocalSliceSize) + LastFileIDLookupLocalIndexInSlice) :
              LastFileIDLookupLocalSLocEntryIndex + " vs. " + ((LastFileIDLookupLocalSlice*LocalSliceSize) + LastFileIDLookupLocalIndexInSlice);
      // update Macro-based values
      LastMacroIDLookupLocalSlice = LastMacroIDLookup / LocalSliceSize;
      LastMacroIDLookupLocalIndexInSlice = LastMacroIDLookupLocalSLocEntryIndex & LocalSliceMaskForIndex;
      LastMacroIDLookupLocalSliceArray = LocalSLocEntryTable.$OffsetsSliceByIndex(LastMacroIDLookupLocalSlice);
      assert LastMacroIDLookupLocalSLocEntryIndex == ((LastMacroIDLookupLocalSlice*LocalSliceSize) + LastMacroIDLookupLocalIndexInSlice) : 
              LastMacroIDLookupLocalSLocEntryIndex + " vs. " + ((LastMacroIDLookupLocalSlice*LocalSliceSize) + LastMacroIDLookupLocalIndexInSlice);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 718,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 719,
   FQN="clang::SourceManager::getDiagnostics", NM="_ZNK5clang13SourceManager14getDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager14getDiagnosticsEv")
  //</editor-fold>
  public DiagnosticsEngine /*&*/ getDiagnostics() /*const*/ {
    return Diag;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 720,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 721,
   FQN="clang::SourceManager::getFileManager", NM="_ZNK5clang13SourceManager14getFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager14getFileManagerEv")
  //</editor-fold>
  public FileManager /*&*/ getFileManager() /*const*/ {
    return FileMgr;
  }

  
  /// \brief Set true if the SourceManager should report the original file name
  /// for contents of files that were overridden by other files. Defaults to
  /// true.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::setOverridenFilesKeepOriginalName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 725,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 726,
   FQN="clang::SourceManager::setOverridenFilesKeepOriginalName", NM="_ZN5clang13SourceManager33setOverridenFilesKeepOriginalNameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager33setOverridenFilesKeepOriginalNameEb")
  //</editor-fold>
  public void setOverridenFilesKeepOriginalName(boolean value) {
    OverridenFilesKeepOriginalName = value;
  }

  
  /// \brief True if non-system source files should be treated as volatile
  /// (likely to change while trying to use them).
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::userFilesAreVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 731,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 732,
   FQN="clang::SourceManager::userFilesAreVolatile", NM="_ZNK5clang13SourceManager20userFilesAreVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager20userFilesAreVolatileEv")
  //</editor-fold>
  public boolean userFilesAreVolatile() /*const*/ {
    return UserFilesAreVolatile;
  }

  
  /// \brief Retrieve the module build stack.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getModuleBuildStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 734,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 735,
   FQN="clang::SourceManager::getModuleBuildStack", NM="_ZNK5clang13SourceManager19getModuleBuildStackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager19getModuleBuildStackEv")
  //</editor-fold>
  public ArrayRef<std.pair<std.string, FullSourceLoc> > getModuleBuildStack() /*const*/ {
    return new ArrayRef<std.pair<std.string, FullSourceLoc> >(StoredModuleBuildStack);
  }

  
  /// \brief Set the module build stack.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::setModuleBuildStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 739,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 740,
   FQN="clang::SourceManager::setModuleBuildStack", NM="_ZN5clang13SourceManager19setModuleBuildStackEN4llvm8ArrayRefISt4pairISsNS_13FullSourceLocEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager19setModuleBuildStackEN4llvm8ArrayRefISt4pairISsNS_13FullSourceLocEEEE")
  //</editor-fold>
  public void setModuleBuildStack(ArrayRef<std.pair<std.string, FullSourceLoc> > stack) {
    StoredModuleBuildStack.clear();
    StoredModuleBuildStack.append_T(stack.begin(), stack.end());
  }

  
  /// \brief Push an entry to the module build stack.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::pushModuleBuildStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 745,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 746,
   FQN="clang::SourceManager::pushModuleBuildStack", NM="_ZN5clang13SourceManager20pushModuleBuildStackEN4llvm9StringRefENS_13FullSourceLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager20pushModuleBuildStackEN4llvm9StringRefENS_13FullSourceLocE")
  //</editor-fold>
  public void pushModuleBuildStack(StringRef moduleName, FullSourceLoc importLoc) {
    StoredModuleBuildStack.push_back(std.make_pair(moduleName.str(), importLoc));
  }

  
  //===--------------------------------------------------------------------===//
  // MainFileID creation and querying methods.
  //===--------------------------------------------------------------------===//

  /// \brief Returns the FileID of the main source file.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getMainFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 754,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 755,
   FQN="clang::SourceManager::getMainFileID", NM="_ZNK5clang13SourceManager13getMainFileIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getMainFileIDEv")
  //</editor-fold>
  public FileID getMainFileID() /*const*/ {
    return MainFileID;
  }
  
  
  /// \brief Set the file ID for the main source file.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::setMainFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 757,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 758,
   FQN="clang::SourceManager::setMainFileID", NM="_ZN5clang13SourceManager13setMainFileIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager13setMainFileIDENS_6FileIDE")
  //</editor-fold>
  public void setMainFileID(FileID FID) {
    setMainFileID(FID.ID);
  }
  public void setMainFileID(/*FileID*/int FID) {
    MainFileID.$assign(FID);
  }

  
  /// \brief Set the file ID for the precompiled preamble.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::setPreambleFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 762,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 763,
   FQN="clang::SourceManager::setPreambleFileID", NM="_ZN5clang13SourceManager17setPreambleFileIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager17setPreambleFileIDENS_6FileIDE")
  //</editor-fold>
  public void setPreambleFileID(FileID Preamble) {
    assert (PreambleFileID.isInvalid()) : "PreambleFileID already set!";
    PreambleFileID.$assign(Preamble);
  }

  
  /// \brief Get the file ID for the precompiled preamble if there is one.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getPreambleFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 768,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 769,
   FQN="clang::SourceManager::getPreambleFileID", NM="_ZNK5clang13SourceManager17getPreambleFileIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager17getPreambleFileIDEv")
  //</editor-fold>
  public FileID getPreambleFileID() /*const*/ {
    return PreambleFileID;
  }

  
  //===--------------------------------------------------------------------===//
  // Methods to create new FileID's and macro expansions.
  //===--------------------------------------------------------------------===//  
  
  /// \brief Create a new FileID that represents the specified file
  /// being \#included from the specified IncludePosition.
  ///
  /// This translates NULL into standard input.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::createFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*unfold FileID/SourceLocation to int*/,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 778,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 779,
   FQN="clang::SourceManager::createFileID", NM="_ZN5clang13SourceManager12createFileIDEPKNS_9FileEntryENS_14SourceLocationENS_6SrcMgr18CharacteristicKindEij",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager12createFileIDEPKNS_9FileEntryENS_14SourceLocationENS_6SrcMgr18CharacteristicKindEij")
  //</editor-fold>
  public FileID createFileID(/*const*/ FileEntry /*P*/ SourceFile, SourceLocation IncludePos, 
          SrcMgr.CharacteristicKind FileCharacter) {
    return FileID.getFromRawEncoding(createFileID(SourceFile, IncludePos.getRawEncoding(), 
            FileCharacter, 
            0, 0));
  }
  public FileID createFileID(/*const*/ FileEntry /*P*/ SourceFile, SourceLocation IncludePos, 
          SrcMgr.CharacteristicKind FileCharacter, 
          int LoadedID/*= 0*/) {
    return FileID.getFromRawEncoding(createFileID(SourceFile, IncludePos.getRawEncoding(), 
            FileCharacter, 
            LoadedID, 0));
  }
  public FileID createFileID(/*const*/ FileEntry /*P*/ SourceFile, SourceLocation IncludePos, 
          SrcMgr.CharacteristicKind FileCharacter, 
          int LoadedID/*= 0*/, /*uint*/int LoadedOffset/*= 0*/) {
    return FileID.getFromRawEncoding(createFileID(SourceFile, IncludePos.getRawEncoding(), 
            FileCharacter, 
            LoadedID, LoadedOffset));
  }
  public /*FileID*/int createFileID(/*const*/ FileEntry /*P*/ SourceFile, /*SourceLocation*/int IncludePos, 
          SrcMgr.CharacteristicKind FileCharacter) {
    return createFileID(SourceFile, IncludePos, 
            FileCharacter, 
            0, 0);
  }
  public /*FileID*/int createFileID(/*const*/ FileEntry /*P*/ SourceFile, /*SourceLocation*/int IncludePos, 
          SrcMgr.CharacteristicKind FileCharacter, 
          int LoadedID/*= 0*/) {
    return createFileID(SourceFile, IncludePos, 
            FileCharacter, 
            LoadedID, 0);
  }
  public /*FileID*/int createFileID(/*const*/ FileEntry /*P*/ SourceFile, /*SourceLocation*/int IncludePos, 
          SrcMgr.CharacteristicKind FileCharacter, 
          int LoadedID/*= 0*/, /*uint*/int LoadedOffset/*= 0*/) {
    /*const*/SrcMgr.ContentCache /*P*/ IR = getOrCreateContentCache(SourceFile, 
         /*isSystemFile=*/ FileCharacter != SrcMgr.CharacteristicKind.C_User);
    assert ((IR != null)) : "getOrCreateContentCache() cannot return NULL";
    return createFileID(IR, /*NO_COPY*/IncludePos, FileCharacter, LoadedID, LoadedOffset);
  }

  
  /// \brief Create a new FileID that represents the specified memory buffer.
  ///
  /// This does no caching of the buffer and takes ownership of the
  /// MemoryBuffer, so only pass a MemoryBuffer to this once.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::createFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 792,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 793,
   FQN="clang::SourceManager::createFileID", NM="_ZN5clang13SourceManager12createFileIDESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EENS_6SrcMgr18CharacteristicKindEijNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager12createFileIDESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EENS_6SrcMgr18CharacteristicKindEijNS_14SourceLocationE")
  //</editor-fold>
  public /*FileID*/int createFileID(std.unique_ptr<MemoryBuffer> Buffer) {
    return createFileID(Buffer, 
            SrcMgr.CharacteristicKind.C_User, 
            0, 0, 
            SourceLocation.getInvalid());
  }
  public /*FileID*/int createFileID(std.unique_ptr<MemoryBuffer> Buffer, 
          SrcMgr.CharacteristicKind FileCharacter/*= SrcMgr::C_User*/) {
    return createFileID(Buffer, 
            FileCharacter, 
            0, 0, 
            SourceLocation.getInvalid());
  }
  public /*FileID*/int createFileID(std.unique_ptr<MemoryBuffer> Buffer, 
          SrcMgr.CharacteristicKind FileCharacter/*= SrcMgr::C_User*/, 
          int LoadedID/*= 0*/) {
    return createFileID(Buffer, 
            FileCharacter, 
            LoadedID, 0, 
            SourceLocation.getInvalid());
  }
  public /*FileID*/int createFileID(std.unique_ptr<MemoryBuffer> Buffer, 
          SrcMgr.CharacteristicKind FileCharacter/*= SrcMgr::C_User*/, 
          int LoadedID/*= 0*/, /*uint*/int LoadedOffset/*= 0*/) {
    return createFileID(Buffer, 
            FileCharacter, 
            LoadedID, LoadedOffset, 
            SourceLocation.getInvalid());
  }
  public /*FileID*/int createFileID(std.unique_ptr<MemoryBuffer> Buffer, 
          SrcMgr.CharacteristicKind FileCharacter/*= SrcMgr::C_User*/, 
          int LoadedID/*= 0*/, /*uint*/int LoadedOffset/*= 0*/, 
          /*SourceLocation*/int IncludeLoc/*= SourceLocation()*/) {
    // JAVA: reuse unique_ptr
    return createFileID(createMemBufferContentCache(Buffer), 
            /*NO_COPY*/IncludeLoc, FileCharacter, LoadedID, LoadedOffset);
  }
  public /*FileID*/int createFileID(unique_ptr<MemoryBuffer> Buffer,  
          SrcMgr.CharacteristicKind FileCharacter, 
          int LoadedID, int LoadedOffset, 
          SourceLocation IncludeLoc) {
    return createFileID(createMemBufferContentCache(Buffer), 
            /*NO_COPY*/IncludeLoc.getRawEncoding(), FileCharacter, LoadedID, LoadedOffset);
  }

  /// \brief Get the FileID for \p SourceFile if it exists. Otherwise, create a
  /// new FileID for the \p SourceFile.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getOrCreateFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 802,
   FQN="clang::SourceManager::getOrCreateFileID", NM="_ZN5clang13SourceManager17getOrCreateFileIDEPKNS_9FileEntryENS_6SrcMgr18CharacteristicKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager17getOrCreateFileIDEPKNS_9FileEntryENS_6SrcMgr18CharacteristicKindE")
  //</editor-fold>
  public FileID getOrCreateFileID(/*const*/ FileEntry /*P*/ SourceFile, 
                   SrcMgr.CharacteristicKind FileCharacter) {
    FileID ID = translateFile(SourceFile);
    return ID.isValid() ? ID : FileID.get(createFileID(SourceFile, SourceLocation.getInvalid(), 
        FileCharacter));
  }

  /// \brief Return a new SourceLocation that encodes the
  /// fact that a token from SpellingLoc should actually be referenced from
  /// ExpansionLoc, and that it represents the expansion of a macro argument
  /// into the function-like macro body.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::createMacroArgExpansionLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 590,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 592,
   FQN="clang::SourceManager::createMacroArgExpansionLoc", NM="_ZN5clang13SourceManager26createMacroArgExpansionLocENS_14SourceLocationES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager26createMacroArgExpansionLocENS_14SourceLocationES1_j")
  //</editor-fold>
  public /*SourceLocation*/int createMacroArgExpansionLoc(/*SourceLocation*/int SpellingLoc, 
                                  /*SourceLocation*/int ExpansionLoc, 
          /*uint*/int TokLength) {
//    SrcMgr.ExpansionInfo Info = SrcMgr.ExpansionInfo.createForMacroArg(SpellingLoc, ExpansionLoc);
    // JAVA: We store an intentionally invalid source location for the end of the
    // expansion range to mark that this is a macro argument rather than
    // a normal one. see SrcMgr.ExpansionInfo.createForMacroArg
    return createExpansionLocImpl(SpellingLoc, ExpansionLoc, 
            SourceLocation.getInvalid(), TokLength, 0, 0);
  }

  
  /// \brief Return a new SourceLocation that encodes the fact
  /// that a token from SpellingLoc should actually be referenced from
  /// ExpansionLoc.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::createExpansionLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 599,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 601,
   FQN="clang::SourceManager::createExpansionLoc", NM="_ZN5clang13SourceManager18createExpansionLocENS_14SourceLocationES1_S1_jij",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager18createExpansionLocENS_14SourceLocationES1_S1_jij")
  //</editor-fold>
  public /*SourceLocation*/int createExpansionLoc(SourceLocation SpellingLoc, 
                    SourceLocation ExpansionLocStart, 
                    SourceLocation ExpansionLocEnd, 
                    /*uint*/int TokLength) {
    return createExpansionLoc(SpellingLoc.getRawEncoding(), 
                    ExpansionLocStart.getRawEncoding(), 
                    ExpansionLocEnd.getRawEncoding(), 
                    TokLength, 
                    0, 
                    0);
  }
  public /*SourceLocation*/int createExpansionLoc(/*SourceLocation*/int SpellingLoc, 
                    /*SourceLocation*/int ExpansionLocStart, 
                    /*SourceLocation*/int ExpansionLocEnd, 
                    /*uint*/int TokLength) {
    return createExpansionLoc(SpellingLoc, 
                    ExpansionLocStart, 
                    ExpansionLocEnd, 
                    TokLength, 
                    0, 
                    0);
  }
  public /*SourceLocation*/int createExpansionLoc(/*SourceLocation*/int SpellingLoc, 
                    /*SourceLocation*/int ExpansionLocStart, 
                    /*SourceLocation*/int ExpansionLocEnd, 
                    /*uint*/int TokLength, 
                    int LoadedID/*= 0*/) {
    return createExpansionLoc(SpellingLoc, 
                    ExpansionLocStart, 
                    ExpansionLocEnd, 
                    TokLength, 
                    LoadedID, 
                    0);
  }
  public /*SourceLocation*/int createExpansionLoc(/*SourceLocation*/int SpellingLoc, 
                    /*SourceLocation*/int ExpansionLocStart, 
                    /*SourceLocation*/int ExpansionLocEnd, 
                    /*uint*/int TokLength, 
                    int LoadedID/*= 0*/, 
                    /*uint*/int LoadedOffset/*= 0*/) {
//    SrcMgr.ExpansionInfo Info = SrcMgr.ExpansionInfo.create(SpellingLoc, ExpansionLocStart, ExpansionLocEnd);
    return createExpansionLocImpl(SpellingLoc, ExpansionLocStart, 
            ExpansionLocEnd, TokLength, LoadedID, LoadedOffset);
  }
  public /*SourceLocation*/int createExpansionLoc(SourceLocation SpellingLoc, 
                    SourceLocation ExpansionLocStart, 
                    SourceLocation ExpansionLocEnd, 
                    /*uint*/int TokLength, 
                    int LoadedID/*= 0*/, 
                    /*uint*/int LoadedOffset/*= 0*/) {
    return createExpansionLocImpl(SpellingLoc.getRawEncoding(), ExpansionLocStart.getRawEncoding(), 
            ExpansionLocEnd.getRawEncoding(), TokLength, LoadedID, LoadedOffset);
  }

  
  /// \brief Retrieve the memory buffer associated with the given file.
  ///
  /// \param Invalid If non-NULL, will be set \c true if an error
  /// occurs while retrieving the memory buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getMemoryBufferForFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 634,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 636,
   FQN="clang::SourceManager::getMemoryBufferForFile", NM="_ZN5clang13SourceManager22getMemoryBufferForFileEPKNS_9FileEntryEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager22getMemoryBufferForFileEPKNS_9FileEntryEPb")
  //</editor-fold>
  public MemoryBuffer /*P*/ getMemoryBufferForFile(/*const*/ FileEntry /*P*/ File) {
    return getMemoryBufferForFile(File, 
                        (bool$ptr/*bool P*/ )null);
  }
  public MemoryBuffer /*P*/ getMemoryBufferForFile(/*const*/ FileEntry /*P*/ File, 
                        bool$ptr/*bool P*/ Invalid/*= null*/) {
    /*const*/SrcMgr.ContentCache /*P*/ IR = getOrCreateContentCache(File);
    assert ((IR != null)) : "getOrCreateContentCache() cannot return NULL";
    return IR.getBuffer(Diag, /*Deref*/this, SourceLocation.getInvalid(), Invalid);
  }

  
  /// \brief Override the contents of the given source file by providing an
  /// already-allocated buffer.
  ///
  /// \param SourceFile the source file whose contents will be overridden.
  ///
  /// \param Buffer the memory buffer whose contents will be used as the
  /// data in the given source file.
  ///
  /// \param DoNotFree If true, then the buffer will not be freed when the
  /// source manager is destroyed.   
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::overrideFileContents">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 641,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 643,
   FQN="clang::SourceManager::overrideFileContents", NM="_ZN5clang13SourceManager20overrideFileContentsEPKNS_9FileEntryEPN4llvm12MemoryBufferEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager20overrideFileContentsEPKNS_9FileEntryEPN4llvm12MemoryBufferEb")
  //</editor-fold>
  public void overrideFileContents(/*const*/FileEntry /*P*/ SourceFile, 
                      MemoryBuffer /*P*/ Buffer, 
                      boolean DoNotFree) {
    /*const*/SrcMgr.ContentCache /*P*/ IR = getOrCreateContentCache(SourceFile);
    assert ((IR != null)) : "getOrCreateContentCache() cannot return NULL";
    
    ((/*const_cast*/SrcMgr.ContentCache /*P*/ )(IR)).replaceBuffer(Buffer, DoNotFree);
    ((/*const_cast*/SrcMgr.ContentCache /*P*/ )(IR)).BufferOverridden = true;
    
    getOverriddenFilesInfo().OverriddenFilesWithBuffer.insert(SourceFile);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::overrideFileContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 846,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 838,
   FQN="clang::SourceManager::overrideFileContents", NM="_ZN5clang13SourceManager20overrideFileContentsEPKNS_9FileEntryESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager20overrideFileContentsEPKNS_9FileEntryESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS6_EE")
  //</editor-fold>
  public void overrideFileContents(/*const*/ FileEntry /*P*/ SourceFile, 
                      std.unique_ptr<MemoryBuffer> Buffer) {
    overrideFileContents(SourceFile, Buffer.release(),  /*DoNotFree*/ false);
  } 
  
  
  /// \brief Override the given source file with another one.
  ///
  /// \param SourceFile the source file which will be overridden.
  ///
  /// \param NewFile the file whose contents will be used as the
  /// data instead of the contents of the given source file.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::overrideFileContents">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 653,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 655,
   FQN="clang::SourceManager::overrideFileContents", NM="_ZN5clang13SourceManager20overrideFileContentsEPKNS_9FileEntryES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager20overrideFileContentsEPKNS_9FileEntryES3_")
  //</editor-fold>
  public void overrideFileContents(/*const*/FileEntry /*P*/ SourceFile, 
          /*const*/FileEntry /*P*/ NewFile) {
    assert (SourceFile.getSize() == NewFile.getSize()) : "Different sizes, use the FileManager to create a virtual file with the correct size";
    assert (FileInfos.count(SourceFile) == 0) : "This function should be called at the initialization stage, before any parsing occurs.";
    getOverriddenFilesInfo().OverriddenFiles.$set(SourceFile, NewFile);
  }

  
  /// \brief Returns true if the file contents have been overridden.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isFileOverridden">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 861,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 853,
   FQN="clang::SourceManager::isFileOverridden", NM="_ZN5clang13SourceManager16isFileOverriddenEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager16isFileOverriddenEPKNS_9FileEntryE")
  //</editor-fold>
  public boolean isFileOverridden(/*const*/FileEntry /*P*/ File) {
    if (OverriddenFilesInfo.$bool()) {
      if (OverriddenFilesInfo.$arrow().OverriddenFilesWithBuffer.count(File) != 0) {
        return true;
      }
      if (OverriddenFilesInfo.$arrow().OverriddenFiles.find(File).$noteq(/*NO_ITER_COPY*/OverriddenFilesInfo.$arrow().OverriddenFiles.end())) {
        return true;
      }
    }
    return false;
  }

  
  /// \brief Disable overridding the contents of a file, previously enabled
  /// with #overrideFileContents.
  ///
  /// This should be called before parsing has begun.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::disableFileContentsOverride">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 664,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 666,
   FQN="clang::SourceManager::disableFileContentsOverride", NM="_ZN5clang13SourceManager27disableFileContentsOverrideEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager27disableFileContentsOverrideEPKNS_9FileEntryE")
  //</editor-fold>
  public void disableFileContentsOverride(/*const*/FileEntry /*P*/ File) {
    if (!isFileOverridden(File)) {
      return;
    }
    
    /*const*/SrcMgr.ContentCache /*P*/ IR = getOrCreateContentCache(File);
    ((/*const_cast*/SrcMgr.ContentCache /*P*/ )(IR)).replaceBuffer(null);
    ((/*const_cast*/SrcMgr.ContentCache /*P*/ )(IR)).ContentsEntry = IR.OrigEntry;
    assert ((OverriddenFilesInfo).$bool());
    OverriddenFilesInfo.$arrow().OverriddenFiles.erase(File);
    OverriddenFilesInfo.$arrow().OverriddenFilesWithBuffer.erase(File);
  }

  
  /// \brief Specify that a file is transient.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::setFileIsTransient">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 677,
   FQN="clang::SourceManager::setFileIsTransient", NM="_ZN5clang13SourceManager18setFileIsTransientEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager18setFileIsTransientEPKNS_9FileEntryE")
  //</editor-fold>
  public void setFileIsTransient(/*const*/ FileEntry /*P*/ File) {
    /*const*/ SrcMgr.ContentCache /*P*/ CC = getOrCreateContentCache(File);
    ((/*const_cast*/SrcMgr.ContentCache /*P*/ )(CC)).IsTransient = true;
  }

  
  /// \brief Specify that all files that are read during this compilation are
  /// transient.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::setAllFilesAreTransient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 883,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 875,
   FQN="clang::SourceManager::setAllFilesAreTransient", NM="_ZN5clang13SourceManager23setAllFilesAreTransientEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager23setAllFilesAreTransientEb")
  //</editor-fold>
  public void setAllFilesAreTransient(boolean Transient) {
    FilesAreTransient = Transient;
  }

    
  //===--------------------------------------------------------------------===//
  // FileID manipulation methods.
  //===--------------------------------------------------------------------===//
  
  /// \brief Return the buffer for the specified FileID.
  ///
  /// If there is an error opening this buffer the first time, this
  /// manufactures a temporary buffer and returns a non-empty error string.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 895,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 887,
   FQN="clang::SourceManager::getBuffer", NM="_ZNK5clang13SourceManager9getBufferENS_6FileIDENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager9getBufferENS_6FileIDENS_14SourceLocationEPb")
  //</editor-fold>
  public MemoryBuffer /*P*/ getBuffer(FileID FID, SourceLocation Loc) /*const*/ {
    return getBuffer(FID.ID, Loc.getRawEncoding(), 
            (bool$ptr/*bool P*/ )null);
  }
  public MemoryBuffer /*P*/ getBuffer(FileID FID, SourceLocation Loc, 
          bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    return getBuffer(FID.ID, Loc.getRawEncoding(), Invalid);
  }
  public MemoryBuffer /*P*/ getBuffer(/*FileID*/int FID, /*SourceLocation*/int Loc) /*const*/ {
    return getBuffer(FID, Loc, 
            (bool$ptr/*bool P*/ )null);
  }
  public MemoryBuffer /*P*/ getBuffer(/*FileID*/int FID, /*SourceLocation*/int Loc, 
          bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    NativeTrace.assertTrue(Invalid == null, "check out value for MemoryBuffer.isInvalid instead of passing Invalid");
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent(FID);
    if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      
      return getFakeBufferForRecovery();
    }
    
    /*const*/MemoryBuffer /*P*/ Buf = $getContentCache(SLocEntryIndex).getBuffer(Diag, /*Deref*/this, Loc, /*AddrOf*/null);
    if ((Invalid != null)) {
      Invalid.$set(Buf.isInvalid());
    }
    
    return Buf;    
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getBuffer">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 910,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 902,
   FQN="clang::SourceManager::getBuffer", NM="_ZNK5clang13SourceManager9getBufferENS_6FileIDEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager9getBufferENS_6FileIDEPb")
  //</editor-fold>
  public /*const*/MemoryBuffer /*P*/ getBuffer(FileID FID) /*const*/ {
    return getBuffer(FID.ID, SourceLocation.getInvalid(), (bool$ptr/*bool P*/ )null);
  }
  public /*const*/MemoryBuffer /*P*/ getBuffer(FileID FID, bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    return getBuffer(FID.ID, SourceLocation.getInvalid(), Invalid);
  }
  public /*const*/MemoryBuffer /*P*/ getBuffer(/*FileID*/int FID) /*const*/ {
    return getBuffer(FID, SourceLocation.getInvalid(), (bool$ptr/*bool P*/ )null);
  }
  public /*const*/MemoryBuffer /*P*/ getBuffer(/*FileID*/int FID, bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    return getBuffer(FID, SourceLocation.getInvalid(), Invalid);
  }

  public SrcMgr.ContentCache getContentCache(SrcMgr.SLocEntry SLoc) {
    return getContentCacheByCacheIndex(SLoc.getFile_ContentCacheIndex());
  }
  
  private SrcMgr.ContentCache getContentCacheByCacheIndex(int index) {
    if (index == FAKE_CONTENT_CACHE_INDEX) {
      assert FakeContentCacheForRecovery != null : "getFakeContentCacheForRecovery was not yet called?";
      return FakeContentCacheForRecovery.get();
    } else {
      return AllContentCaches.$at(index);
    }
  }
  
  
  /// \brief Returns the FileEntry record for the provided FileID.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileEntryForID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 926,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 918,
   FQN="clang::SourceManager::getFileEntryForID", NM="_ZNK5clang13SourceManager17getFileEntryForIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager17getFileEntryForIDENS_6FileIDE")
  //</editor-fold>
  public /*const*/FileEntry /*P*/ getFileEntryForID(FileID FID) /*const*/ {
    return getFileEntryForID(FID.ID);
  }
  public /*const*/FileEntry /*P*/ getFileEntryForID(/*FileID*/int FID) /*const*/ {
    /*SrcMgr.SLocEntry&*/int Entry = getFileSLocEntryByID_LoadEntryIfAbsent(FID);
    if (Entry == INVALID_SLOC_ENTRY_INDEX) {
      return null;
    }
    
    /*const*/SrcMgr.ContentCache /*P*/ Content = $getContentCache(Entry);
    if (!(Content != null)) {
      return null;
    }
    return Content.OrigEntry;
  }

  
  /// \brief Returns the FileEntry record for the provided SLocEntry.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileEntryForSLocEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 939,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 931,
   FQN="clang::SourceManager::getFileEntryForSLocEntry", NM="_ZNK5clang13SourceManager24getFileEntryForSLocEntryERKNS_6SrcMgr9SLocEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager24getFileEntryForSLocEntryERKNS_6SrcMgr9SLocEntryE")
  //</editor-fold>
  public /*const*/FileEntry /*P*/ getFileEntryForSLocEntry(/*const*/SrcMgr.SLocEntry /*&*/ sloc) /*const*/ {
    /*const*/SrcMgr.ContentCache /*P*/ Content = getContentCache(sloc);
    if (!(Content != null)) {
      return null;
    }
    return Content.OrigEntry;
  }

  
  /// \brief Return a StringRef to the source buffer data for the
  /// specified FileID.
  ///
  /// \param FID The file ID whose contents will be returned.
  /// \param Invalid If non-NULL, will be set true if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getBufferData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 682,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 679,
   FQN="clang::SourceManager::getBufferData", NM="_ZNK5clang13SourceManager13getBufferDataENS_6FileIDEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getBufferDataENS_6FileIDEPb")
  //</editor-fold>
  public StringRef getBufferData(FileID FID) /*const*/ {
    return getBufferData(FID.ID, (bool$ptr/*bool P*/ )null);
  }
  public StringRef getBufferData(FileID FID, bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    return getBufferData(FID.ID, Invalid);
  }
  public StringRef getBufferData(/*FileID*/int FID) /*const*/ {
    return getBufferData(FID, (bool$ptr/*bool P*/ )null);
  }
  public StringRef getBufferData(/*FileID*/int FID, bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    NativeTrace.assertTrue(Invalid == null, "check out value for INVALID_BUFFER_DATA instead of passing Invalid");
    MemoryBuffer Buf = getBuffer(FID, SourceLocation.getInvalid(), Invalid);
    if ((Invalid != null)) {
      Invalid.$set(Buf.isInvalid());
    }
    return Buf.isInvalid() ? INVALID_BUFFER_DATA : Buf.getBuffer();
  }
  public static final StringRef INVALID_BUFFER_DATA = new StringRef("<<<<<INVALID SOURCE LOCATION>>>>>");
  
  /// \brief Get the number of FileIDs (files and macros) that were created
  /// during preprocessing of \p FID, including it.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getNumCreatedFIDsForFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 956,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 948,
   FQN="clang::SourceManager::getNumCreatedFIDsForFileID", NM="_ZNK5clang13SourceManager26getNumCreatedFIDsForFileIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager26getNumCreatedFIDsForFileIDENS_6FileIDE")
  //</editor-fold>
  public /*uint*/int getNumCreatedFIDsForFileID(FileID FID) /*const*/ {
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent(FID.ID);
    if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
      return 0;
    }
    
    return $getNumCreatedFIDs(SLocEntryIndex);
  }

  
  /// \brief Set the number of FileIDs (files and macros) that were created
  /// during preprocessing of \p FID, including it.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::setNumCreatedFIDsForFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 967,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 959,
   FQN="clang::SourceManager::setNumCreatedFIDsForFileID", NM="_ZNK5clang13SourceManager26setNumCreatedFIDsForFileIDENS_6FileIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager26setNumCreatedFIDsForFileIDENS_6FileIDEj")
  //</editor-fold>
  public void setNumCreatedFIDsForFileID(FileID FID, /*uint*/int NumFIDs) /*const*/ {
    setNumCreatedFIDsForFileID(FID.ID, NumFIDs);
  }
  public void setNumCreatedFIDsForFileID(/*FileID*/int FID, /*uint*/int NumFIDs) /*const*/ {
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent(FID);
    $setFileSLocEntry_NumCreatedFIDs(SLocEntryIndex, NumFIDs);
  }
  /* friend method for ASTReader only!*/
  public void $setFileSLocEntry_NumCreatedFIDs(int SLocEntryIndex, /*uint*/int NumFIDs) /*const*/ {
    assert INVALID_SLOC_ENTRY_INDEX == 0 : "We skip index 0 where fake data is stored only for loads, not stores";
    if (SLocEntryIndex > 0) {
      assert (LocalSLocEntryTable.isFile_$at(SLocEntryIndex));
      LocalSLocEntryTable.$setNumCreatedFIDs(SLocEntryIndex, NumFIDs);
    } else if (SLocEntryIndex < 0) {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      assert (LoadedSLocEntryTable.isFile_$at(SLocEntryIndex));
      LoadedSLocEntryTable.$setNumCreatedFIDs(SLocEntryIndex, NumFIDs);
    }
  }
  
  
  //===--------------------------------------------------------------------===//
  // SourceLocation manipulation methods.
  //===--------------------------------------------------------------------===//
  
  /// \brief Return the FileID for a SourceLocation.
  ///
  /// This is a very hot method that is used for all SourceManager queries
  /// that start with a SourceLocation object.  It is responsible for finding
  /// the entry in SLocEntryTable which contains the specified location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 987,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 979,
   FQN="clang::SourceManager::getFileID", NM="_ZNK5clang13SourceManager9getFileIDENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager9getFileIDENS_14SourceLocationE")
  //</editor-fold>
  public FileID getFileID(SourceLocation SpellingLoc) /*const*/ {
    return FileID.get(getFileID(SpellingLoc.getRawEncoding()));
  }
  public /*FileID*/int getFileID(/*SourceLocation*/int SpellingLoc) /*const*/ {
    /*uint*/int SLocOffset = SourceLocation.getOffset(SpellingLoc);
    
    // If our one-entry cache covers this offset, just return it.
    if (isOffsetInFileID(/*NO_COPY*/LastFileIDLookup, SLocOffset)) {
      return LastFileIDLookup;
    } else if (USE_LAST_MACRO_ID && isOffsetInFileID(/*NO_COPY*/LastMacroIDLookup, SLocOffset)) {
      return LastMacroIDLookup;
    }
    
    return getFileIDSlow(SLocOffset);
  }

  
  /// \brief Return the filename of the file containing a SourceLocation.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 998,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 990,
   FQN="clang::SourceManager::getFilename", NM="_ZNK5clang13SourceManager11getFilenameENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager11getFilenameENS_14SourceLocationE")
  //</editor-fold>
  public StringRef getFilename(SourceLocation SpellingLoc) /*const*/ {
    {
      /*const*/FileEntry /*P*/ F = getFileEntryForID(getFileID(/*NO_COPY*/SpellingLoc));
      if ((F != null)) {
        return new StringRef(F.getName());
      }
    }
    return new StringRef();
  }

  
  /// \brief Return the source location corresponding to the first byte of
  /// the specified file.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getLocForStartOfFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1006,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 998,
   FQN="clang::SourceManager::getLocForStartOfFile", NM="_ZNK5clang13SourceManager20getLocForStartOfFileENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager20getLocForStartOfFileENS_6FileIDE")
  //</editor-fold>
  public SourceLocation getLocForStartOfFile(FileID FID) /*const*/ {
    return SourceLocation.getFromRawEncoding(getLocForStartOfFile(FID.ID));
  }
  public /*SourceLocation*/int getLocForStartOfFile(/*FileID*/int FID) /*const*/ {
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent(FID);
    int FileOffset = SourceLocation.getInvalid();
    if (SLocEntryIndex != INVALID_SLOC_ENTRY_INDEX) {
      FileOffset = $getOffset(SLocEntryIndex);
    }      
    return SourceLocation.$getFileLoc(FileOffset);
  }

  
  /// \brief Return the source location corresponding to the last byte of the
  /// specified file.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getLocForEndOfFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1018,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1010,
   FQN="clang::SourceManager::getLocForEndOfFile", NM="_ZNK5clang13SourceManager18getLocForEndOfFileENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager18getLocForEndOfFileENS_6FileIDE")
  //</editor-fold>
  public SourceLocation getLocForEndOfFile(FileID FID) /*const*/ {
    return SourceLocation.getFromRawEncoding(getLocForEndOfFile(FID.ID));
  }
  public /*SourceLocation*/int getLocForEndOfFile(/*FileID*/int FID) /*const*/ {
    /*SrcMgr.SLocEntry&*/int Entry = getFileSLocEntryByID_LoadEntryIfAbsent(FID);
    if (Entry == INVALID_SLOC_ENTRY_INDEX) {
      return SourceLocation.getInvalid();
    }
    
    /*uint*/int FileOffset = $getOffset(Entry);
    return SourceLocation.$getFileLoc(FileOffset + getFileIDSize(FID));
  }

  
  /// \brief Returns the include location if \p FID is a \#include'd file
  /// otherwise it returns an invalid location.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getIncludeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1030,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1022,
   FQN="clang::SourceManager::getIncludeLoc", NM="_ZNK5clang13SourceManager13getIncludeLocENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getIncludeLocENS_6FileIDE")
  //</editor-fold>
  public SourceLocation getIncludeLoc(FileID FID) /*const*/ {
    return SourceLocation.getFromRawEncoding(getIncludeLoc(FID.ID));
  }
  public /*SourceLocation*/int getIncludeLoc(/*FileID*/int FID) /*const*/ {
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent(FID);
    if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
      return 0;
    }
    
    return $getIncludeLoc(SLocEntryIndex);
  }

  
  // \brief Returns the import location if the given source location is
  // located within a module, or an invalid location if the source location
  // is within the current translation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getModuleImportLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1042,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1034,
   FQN="clang::SourceManager::getModuleImportLoc", NM="_ZNK5clang13SourceManager18getModuleImportLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager18getModuleImportLocENS_14SourceLocationE")
  //</editor-fold>
  public std.pair<SourceLocation, StringRef> getModuleImportLoc(SourceLocation Loc) /*const*/ {
    FileID FID = getFileID(/*NO_COPY*/Loc);
    
    // Positive file IDs are in the current translation unit, and -1 is a
    // placeholder.
    if (FID.ID >= -1) {
      return std.make_pair(new SourceLocation(), StringRef.R$EMPTY);
    }
    
    return ExternalSLocEntries.getModuleImportLoc(FID.ID);
  }

  
  /// \brief Given a SourceLocation object \p Loc, return the expansion
  /// location referenced by the ID.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getExpansionLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1056,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1048,
   FQN="clang::SourceManager::getExpansionLoc", NM="_ZNK5clang13SourceManager15getExpansionLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager15getExpansionLocENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation getExpansionLoc(SourceLocation Loc) /*const*/ {
    return SourceLocation.getFromRawEncoding(getExpansionLoc(Loc.getRawEncoding()));
  }
  public /*SourceLocation*/int getExpansionLoc(/*SourceLocation*/int Loc) /*const*/ {
    // Handle the non-mapped case inline, defer to out of line code to handle
    // expansions.
    if (SourceLocation.isFileID(Loc)) {
      return Loc;
    }
    return getExpansionLocSlowCase(/*NO_COPY*/Loc);
  }

  
  /// \brief Given \p Loc, if it is a macro location return the expansion
  /// location or the spelling location, depending on if it comes from a
  /// macro argument or not.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1066,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1058,
   FQN="clang::SourceManager::getFileLoc", NM="_ZNK5clang13SourceManager10getFileLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager10getFileLocENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation getFileLoc(SourceLocation Loc) /*const*/ {
    return SourceLocation.getFromRawEncoding(getFileLoc(Loc.getRawEncoding()));
  }
  public /*SourceLocation*/int getFileLoc(/*SourceLocation*/int Loc) /*const*/ {
    if (SourceLocation.isFileID(Loc)) {
      return Loc;
    }
    return getFileLocSlowCase(Loc);
  }

  /// \brief Return the start/end of the expansion information for an
  /// expansion location.
  ///
  /// \pre \p Loc is required to be an expansion location.

  /// getImmediateExpansionRange - Loc is required to be an expansion location.
  /// Return the start/end of the expansion information.  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getImmediateExpansionRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 976,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 973,
   FQN="clang::SourceManager::getImmediateExpansionRange", NM="_ZNK5clang13SourceManager26getImmediateExpansionRangeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager26getImmediateExpansionRangeENS_14SourceLocationE")
  //</editor-fold>
  public std.pair<SourceLocation, SourceLocation> getImmediateExpansionRange(SourceLocation Loc) /*const*/ {
    /*<SourceLocation, SourceLocation>*/long pair = getImmediateExpansionRange(Loc.getRawEncoding());
    return std.make_pair(SourceLocation.getFromRawEncoding($first_int(pair)), SourceLocation.getFromRawEncoding($second_int(pair)));
  }

  public /*<SourceLocation, SourceLocation>*/long getImmediateExpansionRange(/*SourceLocation*/int Loc) /*const*/ {
    assert (SourceLocation.isMacroID(Loc)) : "Not a macro expansion loc!";
    int SLocEntryIndex = getSLocEntryByID_LoadEntryIfAbsent(getFileID(Loc));
    return $getExpansionLocRange(SLocEntryIndex);   
  }

  public /*<SourceLocation, SourceLocation>*/long $getExpansionLocRange(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      assert (LocalSLocEntryTable.isExpansion_$at(SLocEntryIndex));
      return LocalSLocEntryTable.$getRawExpansionLocRange(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      assert (LoadedSLocEntryTable.isExpansion_$at(SLocEntryIndex));
      return LoadedSLocEntryTable.$getRawExpansionLocRange(SLocEntryIndex);
    }    
  }
  
  public boolean $isExpansion(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      if (SLocEntryIndex == LastFileIDLookupLocalSLocEntryIndex) {
        assert LocalSLocEntryTable.isExpansion_$at(SLocEntryIndex) == false: LocalSLocEntryTable.isExpansion_$at(SLocEntryIndex) + " for " + SLocEntryIndex;
        return false;
      } else if (SLocEntryIndex == LastMacroIDLookupLocalSLocEntryIndex) {
        assert LocalSLocEntryTable.isExpansion_$at(SLocEntryIndex) == true: LocalSLocEntryTable.isExpansion_$at(SLocEntryIndex) + " for " + SLocEntryIndex;
        return true;
      }      
      return LocalSLocEntryTable.isExpansion_$at(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.isExpansion_$at(SLocEntryIndex);
    }    
  }

  public boolean $isFile(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      if (SLocEntryIndex == LastFileIDLookupLocalSLocEntryIndex) {
        assert LocalSLocEntryTable.isFile_$at(SLocEntryIndex) == true : LocalSLocEntryTable.isFile_$at(SLocEntryIndex) + " for " + SLocEntryIndex;
        return true;
      } else if (SLocEntryIndex == LastMacroIDLookupLocalSLocEntryIndex) {
        assert LocalSLocEntryTable.isFile_$at(SLocEntryIndex) == false : LocalSLocEntryTable.isFile_$at(SLocEntryIndex) + " for " + SLocEntryIndex;
        return false;
      }      
      return LocalSLocEntryTable.isFile_$at(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.isFile_$at(SLocEntryIndex);
    }    
  }

  public int $getOffset(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      if (SLocEntryIndex == LastFileIDLookupLocalSLocEntryIndex) {
        assert LastFileIDLookupLocalOffset == LocalSLocEntryTable.offset_$at(SLocEntryIndex) : LastFileIDLookupLocalOffset + " vs. " + LocalSLocEntryTable.offset_$at(SLocEntryIndex) + " for " + SLocEntryIndex;
        return LastFileIDLookupLocalOffset;
      } else if (SLocEntryIndex == LastMacroIDLookupLocalSLocEntryIndex) {
        assert LastMacroIDLookupLocalOffset == LocalSLocEntryTable.offset_$at(SLocEntryIndex) : LastMacroIDLookupLocalOffset + " vs. " + LocalSLocEntryTable.offset_$at(SLocEntryIndex) + " for " + SLocEntryIndex;
        return LastMacroIDLookupLocalOffset;
      }
      return LocalSLocEntryTable.offset_$at(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.offset_$at(SLocEntryIndex);
    }    
  }

  public /*SourceLocation*/int $getSpellingLoc(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$getRawSpellingLoc(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$getRawSpellingLoc(SLocEntryIndex);
    }    
  }

  public /*SourceLocation*/int $getExpansionLocStart(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$getRawExpansionLocStart(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$getRawExpansionLocStart(SLocEntryIndex);
    }    
  }

  public /*SourceLocation*/int $getExpansionLocEnd(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$getRawExpansionLocEnd(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$getRawExpansionLocEnd(SLocEntryIndex);
    }    
  }

  public boolean $isMacroArgExpansion(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$isMacroArgExpansion(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$isMacroArgExpansion(SLocEntryIndex);
    }    
  }
  
  public boolean $isMacroBodyExpansion(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$isMacroBodyExpansion(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$isMacroBodyExpansion(SLocEntryIndex);
    }    
  }
  
  public boolean $isFunctionMacroExpansion(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$isFunctionMacroExpansion(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$isFunctionMacroExpansion(SLocEntryIndex);
    }    
  }

  public int $getNumCreatedFIDs(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$getNumCreatedFIDs(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$getNumCreatedFIDs(SLocEntryIndex);
    }    
  }

  public /*SourceLocation*/int $getIncludeLoc(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$getRawIncludeLoc(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$getRawIncludeLoc(SLocEntryIndex);
    }    
  }

  public boolean $hasLineDirectives(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$hasLineDirectives(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$hasLineDirectives(SLocEntryIndex);
    }    
  }

  public SrcMgr.SLocEntry $getSLocEntry(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$at(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$at(SLocEntryIndex);
    }    
  }

  public SrcMgr.CharacteristicKind $getFileCharacteristic(int SLocEntryIndex) {
    if (SLocEntryIndex >= 0) {
      return LocalSLocEntryTable.$getFileCharacteristic(SLocEntryIndex);
    } else {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      return LoadedSLocEntryTable.$getFileCharacteristic(SLocEntryIndex);
    }    
  }

  public SrcMgr.ContentCache $getContentCache(int SLocEntryIndex) {
    int ContentCacheIndex = FAKE_CONTENT_CACHE_INDEX;
    if (SLocEntryIndex > 0) {
      ContentCacheIndex = LocalSLocEntryTable.$getContentCacheIndex(SLocEntryIndex);
    } else if (SLocEntryIndex < 0) {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      ContentCacheIndex = LoadedSLocEntryTable.$getContentCacheIndex(SLocEntryIndex);
    }    
    return getContentCacheByCacheIndex(ContentCacheIndex);
  }
  
  /// \brief Given a SourceLocation object, return the range of
  /// tokens covered by the expansion in the ultimate file.

  /// getExpansionRange - Given a SourceLocation object, return the range of
  /// tokens covered by the expansion in the ultimate file.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getExpansionRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 985,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 982,
   FQN="clang::SourceManager::getExpansionRange", NM="_ZNK5clang13SourceManager17getExpansionRangeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager17getExpansionRangeENS_14SourceLocationE")
  //</editor-fold>
  public std.pair<SourceLocation, SourceLocation> getExpansionRange(SourceLocation Loc) /*const*/ {
    /*<SourceLocation, SourceLocation>*/long rawExpansionRange = getExpansionRange(Loc.getRawEncoding());
    return new std.pair<>(SourceLocation.getFromRawEncoding($first_int(rawExpansionRange)), SourceLocation.getFromRawEncoding($second_int(rawExpansionRange)));
  }
  public /*<SourceLocation, SourceLocation>*/long getExpansionRange(/*SourceLocation*/int Loc) /*const*/ {
    
    if (SourceLocation.isFileID(Loc)) {
      return wrap_SourceLocation_SourceLocation(Loc, Loc);
    }
    
    /*<SourceLocation, SourceLocation>*/long Res = getImmediateExpansionRange(Loc);
    /*SourceLocation*/int First = $first_SourceLocation(Res);
    /*SourceLocation*/int Second = $second_SourceLocation(Res);
    // Fully resolve the start and end locations to their ultimate expansion
    // points.
    while (!SourceLocation.isFileID(First)) {
      First = $first_SourceLocation(getImmediateExpansionRange(First));
    }
    while (!SourceLocation.isFileID(Second)) {
      Second = $second_SourceLocation(getImmediateExpansionRange(Second));
    }
    return wrap_SourceLocation_SourceLocation(First, Second);
  }

  
  /// \brief Given a SourceRange object, return the range of
  /// tokens covered by the expansion in the ultimate file.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getExpansionRange">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1085,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1077,
   FQN="clang::SourceManager::getExpansionRange", NM="_ZNK5clang13SourceManager17getExpansionRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager17getExpansionRangeENS_11SourceRangeE")
  //</editor-fold>
  public SourceRange getExpansionRange(SourceRange Range) /*const*/ {
    return new SourceRange(/*NO_COPY*/$first_int(getExpansionRange(Range.$getBegin())), 
        /*NO_COPY*/$second_int(getExpansionRange(Range.$getEnd())));
  }

  
  /// \brief Given a SourceLocation object, return the spelling
  /// location referenced by the ID.
  ///
  /// This is the place where the characters that make up the lexed token
  /// can be found.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getSpellingLoc">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1095,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1087,
   FQN="clang::SourceManager::getSpellingLoc", NM="_ZNK5clang13SourceManager14getSpellingLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager14getSpellingLocENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation getSpellingLoc(SourceLocation Loc) /*const*/ {
    return SourceLocation.getFromRawEncoding(getSpellingLoc(Loc.getRawEncoding()));
  }
  public /*SourceLocation*/int getSpellingLoc(/*SourceLocation*/int Loc) /*const*/ {
    // Handle the non-mapped case inline, defer to out of line code to handle
    // expansions.
    if (SourceLocation.isFileID(Loc)) {
      return Loc;
    }
    return getSpellingLocSlowCase(/*NO_COPY*/Loc);
  }

  
  /// \brief Given a SourceLocation object, return the spelling location
  /// referenced by the ID.
  ///
  /// This is the first level down towards the place where the characters
  /// that make up the lexed token can be found.  This should not generally
  /// be used by clients.
  
  /// getImmediateSpellingLoc - Given a SourceLocation object, return the
  /// spelling location referenced by the ID.  This is the first level down
  /// towards the place where the characters that make up the lexed token can be
  /// found.  This should not generally be used by clients.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getImmediateSpellingLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 966,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 963,
   FQN="clang::SourceManager::getImmediateSpellingLoc", NM="_ZNK5clang13SourceManager23getImmediateSpellingLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager23getImmediateSpellingLocENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation getImmediateSpellingLoc(SourceLocation Loc) /*const*/ {
    return SourceLocation.getFromRawEncoding(getImmediateSpellingLoc(Loc.getRawEncoding()));
  }
  public /*SourceLocation*/int getImmediateSpellingLoc(/*SourceLocation*/int Loc) /*const*/ {
    if (SourceLocation.isFileID(Loc)) {
      return Loc;
    }
    long/*<FileID, uint>*/ LocInfo = getDecomposedLoc(Loc);
    int Expansion = getExpansionSLocEntryByID_LoadEntryIfAbsent($first_FileID(LocInfo));
    Loc = $getSpellingLoc(Expansion);
    return SourceLocation.$getLocWithOffset(Loc, $second_offset(LocInfo));
  }

  
  /// \brief Decompose the specified location into a raw FileID + Offset pair.
  ///
  /// The first element is the FileID, the second is the offset from the
  /// start of the buffer of the location.  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getDecomposedLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1114,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1106,
   FQN="clang::SourceManager::getDecomposedLoc", NM="_ZNK5clang13SourceManager16getDecomposedLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16getDecomposedLocENS_14SourceLocationE")
  //</editor-fold>
  public std.pairTypeUInt<FileID> getDecomposedLoc(SourceLocation Loc) /*const*/ {
    long/*<FileID, uint>*/ decomposedLoc = getDecomposedLoc(Loc.getRawEncoding());
    return new std.pairTypeUInt<>(FileID.get($first_FileID(decomposedLoc)), $second_offset(decomposedLoc));
  }
  
  public long/*<FileID, uint>*/ getDecomposedLoc(/*SourceLocation*/int Loc) /*const*/ {
    /*FileID*/int FID = getFileID(Loc);
    int SLocEntryIndex = getSLocEntryByID_LoadEntryIfAbsent(FID);
    if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
      return $INVALID_FILEID_ZERO_OFFSET;//(FileID.getInvalidID(), 0);
    }
    return wrap_FileID_Offset/*<FileID, uint>*/(FID, SourceLocation.getOffset(Loc) - $getOffset(SLocEntryIndex));
  }

  
  /// \brief Decompose the specified location into a raw FileID + Offset pair.
  ///
  /// If the location is an expansion record, walk through it until we find
  /// the final location expanded.  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getDecomposedExpansionLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1127,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1119,
   FQN="clang::SourceManager::getDecomposedExpansionLoc", NM="_ZNK5clang13SourceManager25getDecomposedExpansionLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager25getDecomposedExpansionLocENS_14SourceLocationE")
  //</editor-fold>
  public std.pairTypeUInt<FileID> getDecomposedExpansionLoc(SourceLocation Loc) /*const*/ {
    long/*<FileID, uint>*/ decomposedLoc = getDecomposedExpansionLoc(Loc.getRawEncoding());
    return new std.pairTypeUInt(FileID.get($first_FileID(decomposedLoc)), $second_offset(decomposedLoc));
  }
  
  public long/*<FileID, uint>*/ getDecomposedExpansionLoc(/*SourceLocation*/int Loc) /*const*/ {
    /*FileID*/int FID = getFileID(Loc);
    /*SrcMgr.SLocEntry*/int E = $AddrOf(getSLocEntryByID_LoadEntryIfAbsent(FID));
    if (E == INVALID_SLOC_ENTRY_INDEX) {
      return $INVALID_FILEID_ZERO_OFFSET; ///*<FileID, uint>*/(FileID.getInvalidID(), 0);
    }
    
    /*uint*/int Offset = SourceLocation.getOffset(Loc) - $getOffset(E);
    if (SourceLocation.isFileID(Loc)) {
      return wrap_FileID_Offset/*<FileID, uint>*/(FID, Offset);
    }
    
    return getDecomposedExpansionLocSlowCase(E);
  }

  
  /// \brief Decompose the specified location into a raw FileID + Offset pair.
  ///
  /// If the location is an expansion record, walk through it until we find
  /// its spelling record.  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getDecomposedSpellingLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1146,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1138,
   FQN="clang::SourceManager::getDecomposedSpellingLoc", NM="_ZNK5clang13SourceManager24getDecomposedSpellingLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager24getDecomposedSpellingLocENS_14SourceLocationE")
  //</editor-fold>
  public std.pairTypeUInt<FileID> getDecomposedSpellingLoc(SourceLocation Loc) /*const*/ {
    long/*<FileID, uint>*/ decomposedLoc = getDecomposedSpellingLoc(Loc.getRawEncoding());
    return new std.pairTypeUInt(FileID.get($first_FileID(decomposedLoc)), $second_offset(decomposedLoc));
  }
  
  public long/*<FileID, uint>*/ getDecomposedSpellingLoc(/*SourceLocation*/int Loc) /*const*/ {
    /*FileID*/int FID = getFileID(Loc);
    int SLocEntryIndex = getSLocEntryByID_LoadEntryIfAbsent(FID);
    if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
      return $INVALID_FILEID_ZERO_OFFSET; ///*<FileID, uint>*/(FileID.getInvalidID(), 0);
    }
    
    /*uint*/int Offset = SourceLocation.getOffset(Loc) - $getOffset(SLocEntryIndex);
    assert Offset >= 0;
    if (SourceLocation.isFileID(Loc)) {
      return wrap_FileID_Offset/*<FileID, uint>*/(FID, Offset);
    }
    return getDecomposedSpellingLocSlowCase(SLocEntryIndex, Offset);
  }

  
  /// \brief Returns the "included/expanded in" decomposed location of the given
  /// FileID.  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getDecomposedIncludedLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1960,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1953,
   FQN="clang::SourceManager::getDecomposedIncludedLoc", NM="_ZNK5clang13SourceManager24getDecomposedIncludedLocENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager24getDecomposedIncludedLocENS_6FileIDE")
  //</editor-fold>
  public std.pairTypeUInt<FileID> getDecomposedIncludedLoc(FileID FID) /*const*/ {
    long/*<FileID, uint>*/ decomposedLoc = getDecomposedIncludedLoc(FID.ID);
    return new std.pairTypeUInt(FileID.get($first_FileID(decomposedLoc)), $second_offset(decomposedLoc));
  }
  public long/*<FileID, uint>*/ getDecomposedIncludedLoc(/*FileID*/int FID) /*const*/ {
    if (FileID.isInvalid(FID)) {
      return $INVALID_FILEID_ZERO_OFFSET; // std.pair(FileID.getInvalidID(), 0);
    }
    
    // Uses IncludedLocMap to retrieve/cache the decomposed loc.
    /*typedef std::pair<FileID, unsigned int> DecompTy*/

    // JAVA PERF
    std.pairIntLong/*&*/ InsertOp = IncludedLocMap.FindAndConstruct(FID);
    /*pair<FileID, uint> &*/long DecompLoc = InsertOp.second;
    // Do we already have information about this file?
    if (DecompLoc != $INCLUDED_LOC_MAP_NO_ENTRY_MARKER) {
      return DecompLoc; // already in map.
    }
    
    /*SourceLocation*/int UpperLoc/*J*/= SourceLocation.getInvalid();
    int SLocEntryIndex = getSLocEntryByID_LoadEntryIfAbsent(FID);
    if (SLocEntryIndex != INVALID_SLOC_ENTRY_INDEX) {
      if ($isExpansion(SLocEntryIndex)) {
        UpperLoc = $getExpansionLocStart(SLocEntryIndex);
      } else {
        UpperLoc = $getIncludeLoc(SLocEntryIndex);
      }
    }
    if (SourceLocation.isValid(UpperLoc)) {
      DecompLoc = getDecomposedLoc(UpperLoc);
    } else {
      DecompLoc = $INVALID_FILEID_ZERO_OFFSET;
    }
    assert DecompLoc != $INCLUDED_LOC_MAP_NO_ENTRY_MARKER;
    // JAVA: insert into map's bucket
    InsertOp.second = DecompLoc;
    
    return DecompLoc;
  }

  
  /// \brief Returns the offset from the start of the file that the
  /// specified SourceLocation represents.
  ///
  /// This is not very meaningful for a macro ID.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileOffset">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1168,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1160,
   FQN="clang::SourceManager::getFileOffset", NM="_ZNK5clang13SourceManager13getFileOffsetENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getFileOffsetENS_14SourceLocationE")
  //</editor-fold>
  public /*uint*/int getFileOffset(SourceLocation SpellingLoc) /*const*/ {
    return getFileOffset(/*NO_COPY*/SpellingLoc.getRawEncoding());
  }
  public /*uint*/int getFileOffset(/*SourceLocation*/int SpellingLoc) /*const*/ {
    return $second_offset(getDecomposedLoc(SpellingLoc));
  }

  
  /// \brief Tests whether the given source location represents a macro
  /// argument's expansion into the function-like macro definition.
  ///
  /// \param StartLoc If non-null and function returns true, it is set to the
  /// start location of the macro argument expansion.
  ///
  /// Such source locations only appear inside of the expansion
  /// locations representing where a particular function-like macro was
  /// expanded.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isMacroArgExpansion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1001,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 998,
   FQN="clang::SourceManager::isMacroArgExpansion", NM="_ZNK5clang13SourceManager19isMacroArgExpansionENS_14SourceLocationEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager19isMacroArgExpansionENS_14SourceLocationEPS1_")
  //</editor-fold>
  public boolean isMacroArgExpansion(SourceLocation Loc) /*const*/ {
    return isMacroArgExpansion(Loc.getRawEncoding(),
            (SourceLocation /*P type$ptr!*/ )null);
  }
  public boolean isMacroArgExpansion(SourceLocation Loc,
                    SourceLocation /*P type$ptr!*/ StartLoc/*= null*/) /*const*/ {
    return isMacroArgExpansion(Loc.getRawEncoding(),
            StartLoc);
  }
  public boolean isMacroArgExpansion(/*SourceLocation*/int Loc) /*const*/ {
    return isMacroArgExpansion(Loc, null);
  }
  public boolean isMacroArgExpansion(/*SourceLocation*/int Loc,
                    SourceLocation /*P type$ptr!*/ StartLoc/*= null*/) /*const*/ {
    if (!SourceLocation.isMacroID(Loc)) {
      return false;
    }
    
    /*FileID*/int FID = getFileID(Loc);
    int Expansion = getExpansionSLocEntryByID_LoadEntryIfAbsent(FID);
    if (!$isMacroArgExpansion(Expansion)) {
      return false;
    }
    if ((StartLoc != null)) {
      StartLoc.$assignMove($getExpansionLocStart(Expansion));
    }    
    return true;
  }

  
  /// \brief Tests whether the given source location represents the expansion of
  /// a macro body.
  ///
  /// This is equivalent to testing whether the location is part of a macro
  /// expansion but not the expansion of an argument to a function-like macro.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isMacroBodyExpansion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1014,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1006,
   FQN="clang::SourceManager::isMacroBodyExpansion", NM="_ZNK5clang13SourceManager20isMacroBodyExpansionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager20isMacroBodyExpansionENS_14SourceLocationE")
  //</editor-fold>
  public boolean isMacroBodyExpansion(SourceLocation Loc) /*const*/ {
    return isMacroBodyExpansion(Loc.getRawEncoding());
  }
  public boolean isMacroBodyExpansion(/*SourceLocation*/int Loc) /*const*/ {
    if (!SourceLocation.isMacroID(Loc)) {
      return false;
    }
    
    /*FileID*/int FID = getFileID(Loc);
    int Expansion = getExpansionSLocEntryByID_LoadEntryIfAbsent(FID);
    return $isMacroBodyExpansion(Expansion);
  }

  
  /// \brief Returns true if the given MacroID location points at the beginning
  /// of the immediate macro expansion.
  ///
  /// \param MacroBegin If non-null and function returns true, it is set to the
  /// begin location of the immediate macro expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isAtStartOfImmediateMacroExpansion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1022,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1014,
   FQN="clang::SourceManager::isAtStartOfImmediateMacroExpansion", NM="_ZNK5clang13SourceManager34isAtStartOfImmediateMacroExpansionENS_14SourceLocationEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager34isAtStartOfImmediateMacroExpansionENS_14SourceLocationEPS1_")
  //</editor-fold>
  public boolean isAtStartOfImmediateMacroExpansion(SourceLocation Loc) /*const*/ {
    return isAtStartOfImmediateMacroExpansion(Loc, 
            (SourceLocation /*P type$ptr!*/ )null);
  }
  public boolean isAtStartOfImmediateMacroExpansion(SourceLocation Loc, 
          SourceLocation /*P type$ptr!*/ MacroBegin/*= null*/) /*const*/ {
    return isAtStartOfImmediateMacroExpansion(Loc.getRawEncoding(), MacroBegin);
  }
  public boolean isAtStartOfImmediateMacroExpansion(/*SourceLocation*/int Loc) /*const*/ {
    return isAtStartOfImmediateMacroExpansion(Loc, 
            (SourceLocation /*P type$ptr!*/ )null);
  }
  public boolean isAtStartOfImmediateMacroExpansion(/*SourceLocation*/int Loc, 
          SourceLocation /*P type$ptr!*/ MacroBegin/*= null*/) /*const*/ {
    assert (SourceLocation.isValid(Loc) && SourceLocation.isMacroID(Loc)) : "Expected a valid macro loc";
    
    long/*<FileID, uint>*/ DecompLoc = getDecomposedLoc(/*NO_COPY*/Loc);
    if ($greater_uint($second_offset(DecompLoc), 0)) {
      return false; // Does not point at the start of expansion range.
    }
    
    int ExpInfo = getExpansionSLocEntryByID_LoadEntryIfAbsent($first_FileID(DecompLoc));
    if (ExpInfo == INVALID_SLOC_ENTRY_INDEX) {
      return false;
    }
    /*SourceLocation*/int ExpLoc = $getExpansionLocStart(ExpInfo);
    if ($isMacroArgExpansion(ExpInfo)) {
      // For macro argument expansions, check if the previous FileID is part of
      // the same argument expansion, in which case this Loc is not at the
      // beginning of the expansion.
      /*FileID*/int PrevFID = getPreviousFileID($first_FileID(/*NO_COPY*/DecompLoc));
      if (!FileID.isInvalid(PrevFID)) {
        int PrevEntry = getSLocEntryByID_LoadEntryIfAbsent(/*NO_COPY*/PrevFID);
        if (PrevEntry == INVALID_SLOC_ENTRY_INDEX) {
          return false;
        }
        if ($isExpansion(PrevEntry) 
                && $eq_SourceLocation$C($getExpansionLocStart(PrevEntry), ExpLoc)) {
          return false;
        }
      }
    }
    if ((MacroBegin != null)) {
      MacroBegin.$assign(ExpLoc);
    }
    return true;
  }

  
  /// \brief Returns true if the given MacroID location points at the character
  /// end of the immediate macro expansion.
  ///
  /// \param MacroEnd If non-null and function returns true, it is set to the
  /// character end location of the immediate macro expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isAtEndOfImmediateMacroExpansion">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1057,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1049,
   FQN="clang::SourceManager::isAtEndOfImmediateMacroExpansion", NM="_ZNK5clang13SourceManager32isAtEndOfImmediateMacroExpansionENS_14SourceLocationEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager32isAtEndOfImmediateMacroExpansionENS_14SourceLocationEPS1_")
  //</editor-fold>
  public boolean isAtEndOfImmediateMacroExpansion(SourceLocation Loc) /*const*/ {
    return isAtEndOfImmediateMacroExpansion(Loc.getRawEncoding(), 
                                  (SourceLocation /*P type$ptr!*/ )null);
  }
  public boolean isAtEndOfImmediateMacroExpansion(SourceLocation Loc, 
                                  SourceLocation /*P type$ptr!*/ MacroEnd/*= 0*/) /*const*/ {
    return isAtEndOfImmediateMacroExpansion(Loc.getRawEncoding(), 
                                  MacroEnd);
  }
  public boolean isAtEndOfImmediateMacroExpansion(/*SourceLocation*/int Loc) /*const*/ {
    return isAtEndOfImmediateMacroExpansion(Loc, 
                                  (SourceLocation /*P type$ptr!*/ )null);
  }
  public boolean isAtEndOfImmediateMacroExpansion(/*SourceLocation*/int Loc, 
                                    SourceLocation /*P type$ptr!*/ MacroEnd/*= 0*/) /*const*/ {
    assert (SourceLocation.isValid(Loc) && SourceLocation.isMacroID(Loc)) : "Expected a valid macro loc";
    
    /*FileID*/int FID = getFileID(/*NO_COPY*/Loc);
    /*SourceLocation*/int NextLoc = SourceLocation.$getLocWithOffset(Loc, 1);
    if (isInFileID(/*NO_COPY*/NextLoc, /*NO_COPY*/FID)) {
      return false; // Does not point at the end of expansion range.
    }
    
    int ExpInfo = getExpansionSLocEntryByID_LoadEntryIfAbsent(/*NO_COPY*/FID);
    if (ExpInfo == INVALID_SLOC_ENTRY_INDEX) {
      return false;
    }
    if ($isMacroArgExpansion(ExpInfo)) {
      // For macro argument expansions, check if the next FileID is part of the
      // same argument expansion, in which case this Loc is not at the end of the
      // expansion.
      /*FileID*/int NextFID = getNextFileID(/*NO_COPY*/FID);
      if (!FileID.isInvalid(NextFID)) {
        int NextEntry = getSLocEntryByID_LoadEntryIfAbsent(/*NO_COPY*/NextFID);
        if (NextEntry == INVALID_SLOC_ENTRY_INDEX) {
          return false;
        }        
        if ($isExpansion(NextEntry) 
                && $eq_SourceLocation$C($getExpansionLocStart(NextEntry), 
                        $getExpansionLocStart(ExpInfo))) {
          return false;
        }
      }
    }
    if ((MacroEnd != null)) {
      MacroEnd.$assignMove($getExpansionLocEnd(ExpInfo));
    }
    return true;
  }

  
  /// \brief Returns true if \p Loc is inside the [\p Start, +\p Length)
  /// chunk of the source location address space.
  ///
  /// If it's true and \p RelativeOffset is non-null, it will be set to the
  /// relative offset of \p Loc inside the chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isInSLocAddrSpace">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1213,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1205,
   FQN="clang::SourceManager::isInSLocAddrSpace", NM="_ZNK5clang13SourceManager17isInSLocAddrSpaceENS_14SourceLocationES1_jPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager17isInSLocAddrSpaceENS_14SourceLocationES1_jPj")
  //</editor-fold>
  public boolean isInSLocAddrSpace(SourceLocation Loc, 
                   SourceLocation Start, /*uint*/int Length) /*const*/ {
    return isInSLocAddrSpace(Loc.getRawEncoding(), 
                   Start.getRawEncoding(), Length, 
                   (uint$ptr/*uint P*/ )null);
  }  
  public boolean isInSLocAddrSpace(SourceLocation Loc, 
                   SourceLocation Start, /*uint*/int Length,
                   uint$ptr/*uint P*/ RelativeOffset/*= null*/) /*const*/ {
    return isInSLocAddrSpace(Loc.getRawEncoding(), 
                   Start.getRawEncoding(), Length, 
                   RelativeOffset);
  }  
  public boolean isInSLocAddrSpace(/*SourceLocation*/int Loc, 
                  /*SourceLocation*/int Start, /*uint*/int Length, 
                  uint$ptr/*uint P*/ RelativeOffset/*= null*/) /*const*/ {
    assert RelativeOffset == null : "use pair wrapped in $second_int(long) instead of uint$ptr creation";
    /*<boolean, uint>*/long out = isInSLocAddrSpace(Loc, Start, Length);
    if (RelativeOffset != null) {
      RelativeOffset.$set($second_uint(out));
    }
    return $first_bool(out);
  }
  public /*<boolean, int-relative offset>*/long isInSLocAddrSpace(/*SourceLocation*/int Loc, 
          /*SourceLocation*/int Start, /*uint*/int Length) /*const*/ {
    assert ((($less_uint(SourceLocation.getOffset(Start), NextLocalOffset) 
                && 
              $lesseq_uint(SourceLocation.getOffset(Start) + Length, NextLocalOffset)) 
            || 
             ($greatereq_uint(SourceLocation.getOffset(Start), CurrentLoadedOffset) 
                && 
              $less_uint(SourceLocation.getOffset(Start) + Length, MaxLoadedOffset)))) 
            : "Chunk is not valid SLoc address space";
    int RelativeOffset = 0;
    /*uint*/int LocOffs = SourceLocation.getOffset(Loc);
    /*uint*/int BeginOffs = SourceLocation.getOffset(Start);
    /*uint*/int EndOffs = BeginOffs + Length;
    if ($greatereq_uint(LocOffs, BeginOffs) && $less_uint(LocOffs, EndOffs)) {
      RelativeOffset = LocOffs - BeginOffs;
      return wrap_bool_int_pair(true, RelativeOffset);
    }
    
    return wrap_bool_int_pair(false, RelativeOffset);
  }

  
  /// \brief Return true if both \p LHS and \p RHS are in the local source
  /// location address space or the loaded one.
  ///
  /// If it's true and \p RelativeOffset is non-null, it will be set to the
  /// offset of \p RHS relative to \p LHS.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isInSameSLocAddrSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1238,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1230,
   FQN="clang::SourceManager::isInSameSLocAddrSpace", NM="_ZNK5clang13SourceManager21isInSameSLocAddrSpaceENS_14SourceLocationES1_Pi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager21isInSameSLocAddrSpaceENS_14SourceLocationES1_Pi")
  //</editor-fold>
  public boolean isInSameSLocAddrSpace(/*SourceLocation*/int LHS, /*SourceLocation*/int RHS, 
          int$ptr/*int P*/ RelativeOffset) /*const*/ {
    /*uint*/int LHSOffs = SourceLocation.getOffset(LHS), RHSOffs = SourceLocation.getOffset(RHS);
    boolean LHSLoaded = $greatereq_uint(LHSOffs, CurrentLoadedOffset);
    boolean RHSLoaded = $greatereq_uint(RHSOffs, CurrentLoadedOffset);
    if (LHSLoaded == RHSLoaded) {
      if ((RelativeOffset != null)) {
        RelativeOffset.$set(RHSOffs - LHSOffs);
      }
      return true;
    }
    
    return false;
  }

  
  //===--------------------------------------------------------------------===//
  // Queries about the code at a SourceLocation.
  //===--------------------------------------------------------------------===//
  
  /// \brief Return a pointer to the start of the specified location
  /// in the appropriate spelling MemoryBuffer.
  ///
  /// \param Invalid If non-NULL, will be set \c true if an error occurs.
  
  //===----------------------------------------------------------------------===//
  // Queries about the code at a SourceLocation.
  //===----------------------------------------------------------------------===//
  
  /// getCharacterData - Return a pointer to the start of the specified location
  /// in the appropriate MemoryBuffer.
  // !!JAVA!!: consider use of getCharacterData_ValidOnly or getCharacterData_FirstChar  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getCharacterData">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1092,
   FQN="clang::SourceManager::getCharacterData", NM="_ZNK5clang13SourceManager16getCharacterDataENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16getCharacterDataENS_14SourceLocationEPb")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCharacterData(SourceLocation SL) /*const*/ {
    return getCharacterData(SL.getRawEncoding(), 
                  (bool$ptr/*bool P*/ )null);
  }
  public /*const*/char$ptr/*char P*/ getCharacterData(/*SourceLocation*/int SL) /*const*/ {
    return getCharacterData(SL, 
                    (bool$ptr/*bool P*/ )null);
  }
  public /*const*/char$ptr/*char P*/ getCharacterData(SourceLocation SL, 
                  bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    return getCharacterData(SL.getRawEncoding(), Invalid);
  }
  public /*const*/char$ptr/*char P*/ getCharacterData(/*SourceLocation*/int SL, 
                  bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ { 
    NativeTrace.assertTrueInConsole(false, "PERF: try to use faster getCharacterData_ValidOnly "
            + "or getCharacterData_FirstChar "
            + "or getCharacterDataStringRef_ValidOnly");
    long/*<FileID, uint>*/ LocInfo = getDecomposedSpellingLoc(/*NO_COPY*/SL);
    MemoryBuffer Buffer = getBuffer($first_FileID(LocInfo), SourceLocation.getInvalid());
    if ((Invalid != null)) {
      Invalid.$set(Buffer.isInvalid());
    }
    int Offs = $second_int(LocInfo);
    return (Buffer.isInvalid() || Offs == 0) ? Buffer.getBufferStart() : Buffer.getBufferStart().$add(Offs);
  }
  
  // This is shortcut for
  ///*const*/char$ptr/*char P*/ B = SourceMgr.getCharacterData(Range.getRawBegin());
  ///*const*/char$ptr/*char P*/ E = SourceMgr.getCharacterData(Range.getRawEnd());
  //return new StringRef(B, E.$sub(B));  
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED)
  public StringRef getCharacterDataStringRef_ValidOnly(/*SourceLocation*/int StLoc, /*SourceLocation*/int EndLoc) /*const*/ {
    // Note that this is a hot function in the getSpelling() path, which is
    // heavily used by -E mode.    
    long/*<FileID, uint>*/ StLocInfo = getDecomposedSpellingLoc(/*NO_COPY*/StLoc);
    // Note that calling 'getBuffer()' may lazily page in a source file.
    MemoryBuffer Buffer = getBuffer($first_FileID(StLocInfo), SourceLocation.getInvalid());
    if (Buffer.isInvalid()) {
      // special marker for invalid StringRef due to invalid buffer
      return StringRef.R$EMPTY;
    }
    int StOffs = $second_int(StLocInfo);
    long/*<FileID, uint>*/ EndLocInfo = getDecomposedSpellingLoc(/*NO_COPY*/EndLoc);
    assert $first_FileID(StLocInfo) == $first_FileID(EndLocInfo) : "Start and End should be from the same buffer";
    int EndOffs = $second_int(EndLocInfo);
    int Len = EndOffs - StOffs;
    return (StOffs == 0) ? 
            new StringRef(Buffer.getBufferStart(), Len) : 
            new StringRef(Buffer.getBufferStart().$add(StOffs), Len);
  }
  
  /// getCharacterData - Return a pointer to the start of the specified location
  /// in the appropriate MemoryBuffer.
  /// returns NativePointer.$EMPTY in case of invalid buffer
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getCharacterData">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1092,
   FQN = "clang::SourceManager::getCharacterData", NM = "_ZNK5clang13SourceManager16getCharacterDataENS_14SourceLocationEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16getCharacterDataENS_14SourceLocationEPb")
  //</editor-fold>  
  public /*const*/char$ptr/*char P*/ getCharacterData_ValidOnly(/*SourceLocation*/int SL, char$ptr DestPtr) /*const*/ {
    assert DestPtr != null : "forgot to call $DataPtr = SourceMgr.$CharacterDataPtr()? Don't forget to release then";
    // Note that this is a hot function in the getSpelling() path, which is
    // heavily used by -E mode.  
    long/*<FileID, uint>*/ LocInfo = getDecomposedSpellingLoc(SL);
    // Note that calling 'getBuffer()' may lazily page in a source file.
    MemoryBuffer Buffer = getBuffer($first_FileID(LocInfo), SourceLocation.getInvalid());
    int Offs = $second_int(LocInfo);
    assert Offs >= 0 : "\n" + Integer.toBinaryString(Offs) + " in\n" + Long.toBinaryString(LocInfo);
    if (Buffer.isInvalid()) {
      return NativePointer.$EMPTY;
    }
    char$ptr bufferStart = Buffer.getBufferStart();
    if (Offs == 0) {
      return bufferStart;
    }
    DestPtr.$assign(bufferStart);
    Native.$setIndex(DestPtr, bufferStart.$index() + Offs);
    return DestPtr;
  }

  /// Return character on the specified location in the appropriate MemoryBuffer.
  /// to be used instead of SourceMgr.getCharacterData(Tok.getRawLocation(), Invalid).$star()
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getCharacterData">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1092,
   FQN = "clang::SourceManager::getCharacterData", NM = "_ZNK5clang13SourceManager16getCharacterDataENS_14SourceLocationEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16getCharacterDataENS_14SourceLocationEPb")
  //</editor-fold>   
  public /*const*/byte/*char P*/ getCharacterData_FirstChar(/*SourceLocation*/int SL) /*const*/ {
    return getCharacterData_FirstChar(SL, null);
  }
  public /*const*/byte/*char P*/ getCharacterData_FirstChar(/*SourceLocation*/int SL, bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    // Note that this is a hot function in the getSpelling() path, which is
    // heavily used by -E mode.  
    long/*<FileID, uint>*/ LocInfo = getDecomposedSpellingLoc(/*NO_COPY*/SL);
    // Note that calling 'getBuffer()' may lazily page in a source file.
    MemoryBuffer Buffer = getBuffer($first_FileID(LocInfo), SourceLocation.getInvalid());
    if ((Invalid != null)) {
      Invalid.$set(Buffer.isInvalid());
    }    
    /*uint*/int Offs = $second_uint(LocInfo);
    return (Buffer.isInvalid()) ? std.string.TERM : Buffer.getBufferStart().$at(Offs);
  }    
  
  
  /// \brief Return the column # for the specified file position.
  ///
  /// This is significantly cheaper to compute than the line number.  This
  /// returns zero if the column number isn't known.  This may only be called
  /// on a file sloc, so you must choose a spelling or expansion location
  /// before calling this method.
  
  /// getColumnNumber - Return the column # for the specified file position.
  /// this is significantly cheaper to compute than the line number.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getColumnNumber">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1125,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1117,
   FQN="clang::SourceManager::getColumnNumber", NM="_ZNK5clang13SourceManager15getColumnNumberENS_6FileIDEjPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager15getColumnNumberENS_6FileIDEjPb")
  //</editor-fold>
  public /*uint*/int getColumnNumber(FileID FID, /*uint*/int FilePos) /*const*/ {
    return getColumnNumber(FID.ID, FilePos, 
                  (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getColumnNumber(FileID FID, /*uint*/int FilePos, 
                  bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    return getColumnNumber(FID.ID, FilePos, 
                  Invalid);
  }
  public /*uint*/int getColumnNumber(/*FileID*/int FID, /*uint*/int FilePos) /*const*/ {
    return getColumnNumber(FID, FilePos, 
                  (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getColumnNumber(/*FileID*/int FID, /*uint*/int FilePos, 
                  bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    bool$ptr MyInvalid = null;//new bool$ptr$single(false);
    MemoryBuffer /*P*/ MemBuf = getBuffer(/*NO_COPY*/FID, /*AddrOf*/MyInvalid);
    if ((Invalid != null)) {
      Invalid.$set(MemBuf.isInvalid());
    }
    if (MemBuf.isInvalid()) {
      return 1;
    }
    
    // It is okay to request a position just past the end of the buffer.
    if ($greater_uint(FilePos, MemBuf.getBufferSize())) {
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      return 1;
    }
    
    // See if we just calculated the line number for this FilePos and can use
    // that to lookup the start of the line instead of searching for it.
    if ((LastLineNoFileIDQuery == FID) 
       && (LastLineNoContentCache.SourceLineCache != null) 
       && $less_uint(LastLineNoResult, LastLineNoContentCache.NumLines)) {
      int[]/*uint P*/ SourceLineCache = LastLineNoContentCache.SourceLineCache;
      /*uint*/int LineStart = SourceLineCache[LastLineNoResult - 1];
      /*uint*/int LineEnd = SourceLineCache[LastLineNoResult];
      if ($greatereq_uint(FilePos, LineStart) && $less_uint(FilePos, LineEnd)) {
        return FilePos - LineStart + 1;
      }
    }
    
    /*const*/char$ptr/*char P*/ Buf = MemBuf.getBufferStart();
    /*uint*/int LineStart = FilePos;
    while ((LineStart != 0) && Buf.$at(LineStart - 1) != $$LF && Buf.$at(LineStart - 1) != $$CR) {
      --LineStart;
    }
    return FilePos - LineStart + 1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getSpellingColumnNumber">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1171,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1170,
   FQN="clang::SourceManager::getSpellingColumnNumber", NM="_ZNK5clang13SourceManager23getSpellingColumnNumberENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager23getSpellingColumnNumberENS_14SourceLocationEPb")
  //</editor-fold>
  public /*uint*/int getSpellingColumnNumber(SourceLocation Loc) /*const*/ {
    return getSpellingColumnNumber(Loc, 
                        (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getSpellingColumnNumber(SourceLocation Loc, 
                        bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    if (isInvalid(/*NO_COPY*/Loc, Invalid)) {
      return 0;
    }
    long/*<FileID, uint>*/ LocInfo = getDecomposedSpellingLoc(/*NO_COPY*/Loc.getRawEncoding());
    return getColumnNumber($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo), Invalid);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getExpansionColumnNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1178,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1177,
   FQN="clang::SourceManager::getExpansionColumnNumber", NM="_ZNK5clang13SourceManager24getExpansionColumnNumberENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager24getExpansionColumnNumberENS_14SourceLocationEPb")
  //</editor-fold>
  public /*uint*/int getExpansionColumnNumber(SourceLocation Loc) /*const*/ {
    return getExpansionColumnNumber(Loc, 
                          (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getExpansionColumnNumber(SourceLocation Loc, 
                          bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    if (isInvalid(/*NO_COPY*/Loc, Invalid)) {
      return 0;
    }
    long/*<FileID, uint>*/ LocInfo = getDecomposedExpansionLoc(/*NO_COPY*/Loc.getRawEncoding());
    return getColumnNumber($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo), Invalid);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getPresumedColumnNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1185,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1184,
   FQN="clang::SourceManager::getPresumedColumnNumber", NM="_ZNK5clang13SourceManager23getPresumedColumnNumberENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager23getPresumedColumnNumberENS_14SourceLocationEPb")
  //</editor-fold>
  public /*uint*/int getPresumedColumnNumber(SourceLocation Loc) /*const*/ {
    return getPresumedColumnNumber(Loc, 
                          (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getPresumedColumnNumber(SourceLocation Loc, 
                          bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    PresumedLoc PLoc = getPresumedLoc(/*NO_COPY*/Loc);
    if (isInvalid(/*NO_COPY*/PLoc, Invalid)) {
      return 0;
    }
    return PLoc.getColumn();
  }

  
  /// \brief Given a SourceLocation, return the spelling line number
  /// for the position indicated.
  ///
  /// This requires building and caching a table of line offsets for the
  /// MemoryBuffer, so this is not cheap: use only when about to emit a
  /// diagnostic.
  
  /// getLineNumber - Given a SourceLocation, return the spelling line number
  /// for the position indicated.  This requires building and caching a table of
  /// line offsets for the MemoryBuffer, so this is not cheap: use only when
  /// about to emit a diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getLineNumber">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1283,
   FQN="clang::SourceManager::getLineNumber", NM="_ZNK5clang13SourceManager13getLineNumberENS_6FileIDEjPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getLineNumberENS_6FileIDEjPb")
  //</editor-fold>
  public /*uint*/int getLineNumber(FileID FID, /*uint*/int FilePos) /*const*/ {
    return getLineNumber(FID.ID, FilePos, 
               (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getLineNumber(FileID FID, /*uint*/int FilePos, 
                  bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    return getLineNumber(FID.ID, FilePos, 
                  Invalid);
  }
  public /*uint*/int getLineNumber(/*FileID*/int FID, /*uint*/int FilePos) /*const*/ {
    return getLineNumber(FID, FilePos, 
                  (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getLineNumber(/*FileID*/int FID, /*uint*/int FilePos, 
                  bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    if (FileID.isInvalid(FID)) {
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      return 1;
    }
    
    SrcMgr.ContentCache/*P*/ Content;
    if ((LastLineNoFileIDQuery == FID)) {
      Content = LastLineNoContentCache;
    } else {
      /*SrcMgr.SLocEntry&*/int Entry = getFileSLocEntryByID_LoadEntryIfAbsent(FID);
      if (Entry == INVALID_SLOC_ENTRY_INDEX) {
        if ((Invalid != null)) {
          Invalid.$set(true);
        }
        return 1;
      }
      
      Content = $getContentCache(Entry);
    }
    
    // If this is the first use of line information for this buffer, compute the
    /// SourceLineCache for it on demand.
    if (Content.SourceLineCache == null) {
//      bool$ptr$single MyInvalid = new bool$ptr$single(false);
      boolean MyInvalid = ComputeLineNumbers(Diag, Content, ContentCacheAlloc, /*Deref*/this, null/*MyInvalid*/);
      if ((Invalid != null)) {
        Invalid.$set(MyInvalid);
      }
      if (MyInvalid) {
        return 1;
      }
    } else if ((Invalid != null)) {
      Invalid.$set(false);
    }
    
    // Okay, we know we have a line number table.  Do a binary search to find the
    // line number that this character position lands on.
    int[]/*uint P*/ $SourceLineCache = Content.SourceLineCache;
    int/*uint P*/ SourceLineCache = 0;
    int/*uint P*/ SourceLineCacheStart = SourceLineCache;
    int/*uint P*/ SourceLineCacheEnd = SourceLineCache + Content.NumLines;
    
    /*uint*/int QueriedFilePos = FilePos + 1;
    assert QueriedFilePos >= 0 : "must be unsigned " + QueriedFilePos;
    
    // FIXME: I would like to be convinced that this code is worth being as
    // complicated as it is, binary search isn't that slow.
    //
    // If it is worth being optimized, then in my opinion it could be more
    // performant, simpler, and more obviously correct by just "galloping" outward
    // from the queried file position. In fact, this could be incorporated into a
    // generic algorithm such as lower_bound_with_hint.
    //
    // If someone gives me a test case where this matters, and I will do it! - DWD
        
    // If the previous query was to the same file, we know both the file pos from
    // that query and the line number returned.  This allows us to narrow the
    // search space from the entire file to something near the match.
    if ((LastLineNoFileIDQuery == FID)) {
      if ($greatereq_uint(QueriedFilePos, LastLineNoFilePos)) {
        // FIXME: Potential overflow?
        SourceLineCache = SourceLineCache + (LastLineNoResult - 1);
        assert SourceLineCache >= 0 : "must be unsigned " + SourceLineCache;
        
        // The query is likely to be nearby the previous one.  Here we check to
        // see if it is within 5, 10 or 20 lines.  It can be far away in cases
        // where big comment blocks and vertical whitespace eat up lines but
        // contribute no tokens.
        if (SourceLineCache + 5 < SourceLineCacheEnd) {
          if ($SourceLineCache[SourceLineCache + 5] > QueriedFilePos) {
            SourceLineCacheEnd = SourceLineCache + 5;
          } else if (SourceLineCache + 10 < SourceLineCacheEnd) {
            if ($SourceLineCache[SourceLineCache + 10] > QueriedFilePos) {
              SourceLineCacheEnd = SourceLineCache + 10;
            } else if (SourceLineCache + 20 < SourceLineCacheEnd) {
              if ($SourceLineCache[SourceLineCache + 20] > QueriedFilePos) {
                SourceLineCacheEnd = SourceLineCache + 20;
              }
            }
          }
        }
      } else {
        if ($less_uint(LastLineNoResult, Content.NumLines)) {
          SourceLineCacheEnd = SourceLineCache + LastLineNoResult + 1;
        }
      }
    }   
    assert SourceLineCacheEnd >= 0 : "must be unsigned " + SourceLineCacheEnd;
    int/*uint P*/ Pos = std.lower_bound_int($SourceLineCache, SourceLineCache, SourceLineCacheEnd, QueriedFilePos);
    /*uint*/int LineNo = Pos - SourceLineCacheStart;
    
    LastLineNoFileIDQuery = FID;
    LastLineNoContentCache = Content;
    LastLineNoFilePos = QueriedFilePos;
    LastLineNoResult = LineNo;
    return LineNo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getSpellingLineNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1383,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1377,
   FQN="clang::SourceManager::getSpellingLineNumber", NM="_ZNK5clang13SourceManager21getSpellingLineNumberENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager21getSpellingLineNumberENS_14SourceLocationEPb")
  //</editor-fold>
  public /*uint*/int getSpellingLineNumber(SourceLocation Loc) /*const*/ {
    return getSpellingLineNumber(Loc, 
                      (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getSpellingLineNumber(SourceLocation Loc, 
                       bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    if (isInvalid(/*NO_COPY*/Loc, Invalid)) {
      return 0;
    }
    long/*<FileID, uint>*/ LocInfo = getDecomposedSpellingLoc(/*NO_COPY*/Loc.getRawEncoding());
    return getLineNumber($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getExpansionLineNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1389,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1383,
   FQN="clang::SourceManager::getExpansionLineNumber", NM="_ZNK5clang13SourceManager22getExpansionLineNumberENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager22getExpansionLineNumberENS_14SourceLocationEPb")
  //</editor-fold>
  public /*uint*/int getExpansionLineNumber(SourceLocation Loc) /*const*/ {
    return getExpansionLineNumber(Loc, 
                        (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getExpansionLineNumber(SourceLocation Loc, 
                        bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    if (isInvalid(/*NO_COPY*/Loc, Invalid)) {
      return 0;
    }
    long/*<FileID, uint>*/ LocInfo = getDecomposedExpansionLoc(/*NO_COPY*/Loc.getRawEncoding());
    return getLineNumber($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getPresumedLineNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1395,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1389,
   FQN="clang::SourceManager::getPresumedLineNumber", NM="_ZNK5clang13SourceManager21getPresumedLineNumberENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager21getPresumedLineNumberENS_14SourceLocationEPb")
  //</editor-fold>
  public /*uint*/int getPresumedLineNumber(SourceLocation Loc) /*const*/ {
    return getPresumedLineNumber(Loc, 
                       (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getPresumedLineNumber(SourceLocation Loc, 
                       bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    PresumedLoc PLoc = getPresumedLoc(/*NO_COPY*/Loc);
    if (isInvalid(/*NO_COPY*/PLoc, Invalid)) {
      return 0;
    }
    return PLoc.getLine();
  }

  
  /// \brief Return the filename or buffer identifier of the buffer the
  /// location is in.
  ///
  /// Note that this name does not respect \#line directives.  Use
  /// getPresumedLoc for normal clients.
  
  /// Return the filename or buffer identifier of the buffer the location is in.
  /// Note that this name does not respect \#line directives.  Use getPresumedLoc
  /// for normal clients.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getBufferName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1441,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1434,
   FQN="clang::SourceManager::getBufferName", NM="_ZNK5clang13SourceManager13getBufferNameENS_14SourceLocationEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getBufferNameENS_14SourceLocationEPb")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBufferName(SourceLocation Loc) /*const*/ {
    return getBufferName(Loc.getRawEncoding());
  }
  public /*const*/char$ptr/*char P*/ getBufferName(/*SourceLocation*/int Loc) /*const*/ {
    return getBufferName(Loc, 
                (bool$ptr/*bool P*/ )null);
  }
  public /*const*/char$ptr/*char P*/ getBufferName(SourceLocation Loc, 
                bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    return getBufferName(Loc.getRawEncoding(), Invalid);
  }
  public /*const*/char$ptr/*char P*/ getBufferName(/*SourceLocation*/int Loc, 
                bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    if (isInvalid(/*NO_COPY*/Loc, Invalid)) {
      return $("<invalid loc>");
    }
    
    return getBuffer(getFileID(/*NO_COPY*/Loc), Invalid).getBufferIdentifier();
  }

  
  /// \brief Return the file characteristic of the specified source
  /// location, indicating whether this is a normal file, a system
  /// header, or an "implicit extern C" system header.
  ///
  /// This state can be modified with flags on GNU linemarker directives like:
  /// \code
  ///   # 4 "foo.h" 3
  /// \endcode
  /// which changes all source locations in the current file after that to be
  /// considered to be from a system header.
  
  /// getFileCharacteristic - return the file characteristic of the specified
  /// source location, indicating whether this is a normal file, a system
  /// header, or an "implicit extern C" system header.
  ///
  /// This state can be modified with flags on GNU linemarker directives like:
  ///   # 4 "foo.h" 3
  /// which changes all source locations in the current file after that to be
  /// considered to be from a system header.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileCharacteristic">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1410,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1403,
   FQN="clang::SourceManager::getFileCharacteristic", NM="_ZNK5clang13SourceManager21getFileCharacteristicENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager21getFileCharacteristicENS_14SourceLocationE")
  //</editor-fold>
  public SrcMgr.CharacteristicKind getFileCharacteristic(SourceLocation Loc) /*const*/ {
    return getFileCharacteristic(Loc.getRawEncoding());
  }
  public SrcMgr.CharacteristicKind getFileCharacteristic(/*SourceLocation*/int Loc) /*const*/ {
    assert (SourceLocation.isValid(Loc)) : "Can't get file characteristic of invalid loc!";
    long/*<FileID, uint>*/ LocInfo = getDecomposedExpansionLoc(Loc);
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent($first_FileID(LocInfo));
    if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
      return SrcMgr.CharacteristicKind.C_User;
    }
    
    // If there are no #line directives in this file, just return the whole-file
    // state.
    if (!$hasLineDirectives(SLocEntryIndex)) {
      return $getFileCharacteristic(SLocEntryIndex);
    }
    assert ((LineTable != null)) : "Can't have linetable entries without a LineTable!";
    // See if there is a #line directive before the location.
    /*const*/LineEntry /*P*/ Entry = LineTable.FindNearestLineEntry($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo));
    
    // If this is before the first line marker, use the file characteristic.
    if (!(Entry != null)) {
      return $getFileCharacteristic(SLocEntryIndex);
    }
    
    return Entry.FileKind;
  }

  
  /// \brief Returns the "presumed" location of a SourceLocation specifies.
  ///
  /// A "presumed location" can be modified by \#line or GNU line marker
  /// directives.  This provides a view on the data that a user should see
  /// in diagnostics, for example.
  ///
  /// Note that a presumed location is always given as the expansion point of
  /// an expansion location, not at the spelling location.
  ///
  /// \returns The presumed location of the specified SourceLocation. If the
  /// presumed location cannot be calculated (e.g., because \p Loc is invalid
  /// or the file containing \p Loc has changed on disk), returns an invalid
  /// presumed location.
  
  /// getPresumedLoc - This method returns the "presumed" location of a
  /// SourceLocation specifies.  A "presumed location" can be modified by \#line
  /// or GNU line marker directives.  This provides a view on the data that a
  /// user should see in diagnostics, for example.
  ///
  /// Note that a presumed location is always given as the expansion point of an
  /// expansion location, not at the spelling location.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getPresumedLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1456,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1449,
   FQN="clang::SourceManager::getPresumedLoc", NM="_ZNK5clang13SourceManager14getPresumedLocENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager14getPresumedLocENS_14SourceLocationEb")
  //</editor-fold>
  public PresumedLoc getPresumedLoc(SourceLocation Loc) /*const*/ {
    return getPresumedLoc(Loc.getRawEncoding(), 
            true);
  }
  public PresumedLoc getPresumedLoc(SourceLocation Loc, 
          boolean UseLineDirectives/*= true*/) /*const*/ {
    return getPresumedLoc(Loc.getRawEncoding(), UseLineDirectives);
  }
  public PresumedLoc getPresumedLoc(/*SourceLocation*/int Loc) /*const*/ {
    return getPresumedLoc(Loc, 
            true);
  }
  public PresumedLoc getPresumedLoc(/*SourceLocation*/int Loc, 
          boolean UseLineDirectives/*= true*/) /*const*/ {
    if (SourceLocation.isInvalid(Loc)) {
      return new PresumedLoc();
    }
    
    // Presumed locations are always for expansion points.
    long/*<FileID, uint>*/ LocInfo = getDecomposedExpansionLoc(Loc);
    
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent($first_FileID(LocInfo));
    if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
      return new PresumedLoc();
    }    
    
    /*const*/SrcMgr.ContentCache /*P*/ C = $getContentCache(SLocEntryIndex);
    
    // To get the source name, first consult the FileEntry (if one exists)
    // before the MemBuffer as this will avoid unnecessarily paging in the
    // MemBuffer.
    /*const*/char$ptr/*char P*/ Filename;
    if ((C.OrigEntry != null)) {
      Filename = C.OrigEntry.getName();
    } else {
      Filename = C.getBuffer(Diag, /*Deref*/this).getBufferIdentifier();
    }
    
    bool$ptr Invalid = create_bool$ptr(false);
    /*uint*/int LineNo = getLineNumber($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo), $AddrOf(Invalid));
    if (Invalid.$star()) {
      return new PresumedLoc();
    }
    /*uint*/int ColNo = getColumnNumber($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo), $AddrOf(Invalid));
    if (Invalid.$star()) {
      return new PresumedLoc();
    }
    
    /*SourceLocation*/int IncludeLoc = $getIncludeLoc(SLocEntryIndex);
    
    // If we have #line directives in this file, update and overwrite the physical
    // location info if appropriate.
    if (UseLineDirectives && $hasLineDirectives(SLocEntryIndex)) {
      assert ((LineTable != null)) : "Can't have linetable entries without a LineTable!";
      {
        // See if there is a #line directive before this.  If so, get it.
        /*const*/LineEntry /*P*/ Entry = LineTable.FindNearestLineEntry($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo));
        if ((Entry != null)) {
          // If the LineEntry indicates a filename, use it.
          if (Entry.FilenameID != -1) {
            Filename = LineTable.getFilename(Entry.FilenameID);
          }
          
          // Use the line number specified by the LineEntry.  This line number may
          // be multiple lines down from the line entry.  Add the difference in
          // physical line numbers from the query point and the line marker to the
          // total.
          /*uint*/int MarkerLineNo = getLineNumber($first_FileID(/*NO_COPY*/LocInfo), Entry.FileOffset);
          LineNo = Entry.LineNo + (LineNo - MarkerLineNo - 1);
          
          // Note that column numbers are not molested by line markers.
          
          // Handle virtual #include manipulation.
          if ((Entry.IncludeOffset != 0)) {
            IncludeLoc = getLocForStartOfFile($first_FileID(/*NO_COPY*/LocInfo));
            IncludeLoc = SourceLocation.$getLocWithOffset(IncludeLoc, Entry.IncludeOffset);
          }
        }
      }
    }
    
    return new PresumedLoc(Filename, LineNo, ColNo, /*NO_COPY*/IncludeLoc);
  }

  
  /// \brief Returns whether the PresumedLoc for a given SourceLocation is 
  /// in the main file.
  ///
  /// This computes the "presumed" location for a SourceLocation, then checks
  /// whether it came from a file other than the main file. This is different
  /// from isWrittenInMainFile() because it takes line marker directives into
  /// account.
  
  /// \brief Returns whether the PresumedLoc for a given SourceLocation is
  /// in the main file.
  ///
  /// This computes the "presumed" location for a SourceLocation, then checks
  /// whether it came from a file other than the main file. This is different
  /// from isWrittenInMainFile() because it takes line marker directives into
  /// account.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isInMainFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1527,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1520,
   FQN="clang::SourceManager::isInMainFile", NM="_ZNK5clang13SourceManager12isInMainFileENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager12isInMainFileENS_14SourceLocationE")
  //</editor-fold>
  public boolean isInMainFile(SourceLocation Loc) /*const*/ {
    return isInMainFile(Loc.getRawEncoding());
  }
  public boolean isInMainFile(/*SourceLocation*/int Loc) /*const*/ {
    if (SourceLocation.isInvalid(Loc)) {
      return false;
    }
    
    // Presumed locations are always for expansion points.
    long/*<FileID, uint>*/ LocInfo = getDecomposedExpansionLoc(Loc);
    
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent($first_FileID(LocInfo));
    if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
      return false;
    }
    
    // Check if there is a line directive for this location.
    if ($hasLineDirectives(SLocEntryIndex)) {
      {
        /*const*/LineEntry /*P*/ Entry = LineTable.FindNearestLineEntry($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo));
        if ((Entry != null)) {
          if ((Entry.IncludeOffset != 0)) {
            return false;
          }
        }
      }
    }
    
    return SourceLocation.isInvalid($getIncludeLoc(SLocEntryIndex));
  }

  
  /// \brief Returns true if the spelling locations for both SourceLocations
  /// are part of the same file buffer.
  ///
  /// This check ignores line marker directives.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isWrittenInSameFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1338,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1330,
   FQN="clang::SourceManager::isWrittenInSameFile", NM="_ZNK5clang13SourceManager19isWrittenInSameFileENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager19isWrittenInSameFileENS_14SourceLocationES1_")
  //</editor-fold>
  public boolean isWrittenInSameFile(SourceLocation Loc1, SourceLocation Loc2) /*const*/ {
    return isWrittenInSameFile(Loc1.getRawEncoding(), Loc2.getRawEncoding());
  }
  public boolean isWrittenInSameFile(/*SourceLocation*/int Loc1, /*SourceLocation*/int Loc2) /*const*/ {
    return getFileID(/*NO_COPY*/Loc1) == getFileID(/*NO_COPY*/Loc2);
  }

  
  /// \brief Returns true if the spelling location for the given location
  /// is in the main file buffer.
  ///
  /// This check ignores line marker directives.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isWrittenInMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1346,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1338,
   FQN="clang::SourceManager::isWrittenInMainFile", NM="_ZNK5clang13SourceManager19isWrittenInMainFileENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager19isWrittenInMainFileENS_14SourceLocationE")
  //</editor-fold>
  public boolean isWrittenInMainFile(SourceLocation Loc) /*const*/ {
    return isWrittenInMainFile(Loc.getRawEncoding());
  }
  public boolean isWrittenInMainFile(/*SourceLocation*/int Loc) /*const*/ {
    return getFileID(/*NO_COPY*/Loc) == getMainFileID().$ID();
  }

  
  /// \brief Returns if a SourceLocation is in a system header.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isInSystemHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1351,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1343,
   FQN="clang::SourceManager::isInSystemHeader", NM="_ZNK5clang13SourceManager16isInSystemHeaderENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16isInSystemHeaderENS_14SourceLocationE")
  //</editor-fold>
  public boolean isInSystemHeader(SourceLocation Loc) /*const*/ {
    return isInSystemHeader(Loc.getRawEncoding());
  }
  public boolean isInSystemHeader(/*SourceLocation*/int Loc) /*const*/ {
    return getFileCharacteristic(/*NO_COPY*/Loc) != SrcMgr.CharacteristicKind.C_User;
  }

  
  /// \brief Returns if a SourceLocation is in an "extern C" system header.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isInExternCSystemHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1356,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1348,
   FQN="clang::SourceManager::isInExternCSystemHeader", NM="_ZNK5clang13SourceManager23isInExternCSystemHeaderENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager23isInExternCSystemHeaderENS_14SourceLocationE")
  //</editor-fold>
  public boolean isInExternCSystemHeader(SourceLocation Loc) /*const*/ {
    return isInExternCSystemHeader(Loc.getRawEncoding());
  }
  public boolean isInExternCSystemHeader(/*SourceLocation*/int Loc) /*const*/ {
    return getFileCharacteristic(/*NO_COPY*/Loc) == SrcMgr.CharacteristicKind.C_ExternCSystem;
  }

  
  /// \brief Returns whether \p Loc is expanded from a macro in a system header.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isInSystemMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1361,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1353,
   FQN="clang::SourceManager::isInSystemMacro", NM="_ZN5clang13SourceManager15isInSystemMacroENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager15isInSystemMacroENS_14SourceLocationE")
  //</editor-fold>
  public boolean isInSystemMacro(SourceLocation loc) {
    return isInSystemMacro(loc.getRawEncoding());
  }
  public boolean isInSystemMacro(/*SourceLocation*/int loc) {
    return SourceLocation.isMacroID(loc) && isInSystemHeader(getSpellingLoc(/*NO_COPY*/loc));
  }

  
  /// \brief The size of the SLocEntry that \p FID represents.
  
  /// \brief The size of the SLocEntry that \p FID represents.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileIDSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1551,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1544,
   FQN="clang::SourceManager::getFileIDSize", NM="_ZNK5clang13SourceManager13getFileIDSizeENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getFileIDSizeENS_6FileIDE")
  //</editor-fold>
  public /*uint*/int getFileIDSize(FileID FID) /*const*/ {
    return getFileIDSize(FID.ID);
  }
  public /*uint*/int getFileIDSize(/*FileID*/int FID) /*const*/ {
    /*SrcMgr.SLocEntry&*/int Entry = getSLocEntryByID_LoadEntryIfAbsent(FID);
    if (Entry == INVALID_SLOC_ENTRY_INDEX) {
      return 0;
    }
    
    int ID = FID;
    /*uint*/int NextOffset;
    if ((ID > 0 && ((/*uint*/int)(ID + 1)) == local_sloc_entry_size())) {
      NextOffset = getNextLocalOffset();
    } else if (ID + 1 == -1) {
      NextOffset = MaxLoadedOffset;
    } else {
      NextOffset = $getOffset(getSLocEntryByID_LoadEntryIfAbsent(ID + 1));
    }
    
    return NextOffset - $getOffset(Entry) - 1;
  }

  
  /// \brief Given a specific FileID, returns true if \p Loc is inside that
  /// FileID chunk and sets relative offset (offset of \p Loc from beginning
  /// of FileID) to \p relativeOffset.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isInFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1371,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1363,
   FQN="clang::SourceManager::isInFileID", NM="_ZNK5clang13SourceManager10isInFileIDENS_14SourceLocationENS_6FileIDEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager10isInFileIDENS_14SourceLocationENS_6FileIDEPj")
  //</editor-fold>
  public boolean isInFileID(SourceLocation Loc, FileID FID) /*const*/ {
    return isInFileID(Loc.getRawEncoding(), FID.ID, 
            (uint$ptr/*uint P*/ )null);
  }
  public boolean isInFileID(SourceLocation Loc, FileID FID, 
          uint$ptr/*uint P*/ RelativeOffset/*= null*/) /*const*/ {
    return isInFileID(Loc.getRawEncoding(), FID.ID, RelativeOffset);
  }
  public boolean isInFileID(/*SourceLocation*/int Loc, /*FileID*/int FID) /*const*/ {
    return isInFileID(Loc, FID, 
            (uint$ptr/*uint P*/ )null);
  }
  public boolean isInFileID(/*SourceLocation*/int Loc, /*FileID*/int FID, 
          uint$ptr/*uint P*/ RelativeOffset/*= null*/) /*const*/ {
    /*uint*/int Offs = SourceLocation.getOffset(Loc);
    if (isOffsetInFileID((int)FID, Offs)) {
      if ((RelativeOffset != null)) {
        RelativeOffset.$set(Offs - $getOffset(getSLocEntryByID_LoadEntryIfAbsent(/*NO_COPY*/FID)));
      }
      return true;
    }
    
    return false;
  }

  
  //===--------------------------------------------------------------------===//
  // Line Table Manipulation Routines
  //===--------------------------------------------------------------------===//
  
  /// \brief Return the uniqued ID for the specified filename.
  ///
  
  /// getLineTableFilenameID - Return the uniqued ID for the specified filename.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getLineTableFilenameID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 281,
   FQN="clang::SourceManager::getLineTableFilenameID", NM="_ZN5clang13SourceManager22getLineTableFilenameIDEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager22getLineTableFilenameIDEN4llvm9StringRefE")
  //</editor-fold>
  public /*uint*/int getLineTableFilenameID(StringRef Name) {
    return getLineTable().getLineTableFilenameID(/*NO_COPY*/Name);
  }

  
  /// \brief Add a line note to the line table for the FileID and offset
  /// specified by Loc.
  ///
  /// If FilenameID is -1, it is considered to be unspecified.
  
  /// AddLineNote - Add a line note to the line table for the FileID and offset
  /// specified by Loc.  If FilenameID is -1, it is considered to be
  /// unspecified.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::AddLineNote">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 291,
   FQN="clang::SourceManager::AddLineNote", NM="_ZN5clang13SourceManager11AddLineNoteENS_14SourceLocationEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager11AddLineNoteENS_14SourceLocationEji")
  //</editor-fold>
  public void AddLineNote(SourceLocation Loc, /*uint*/int LineNo, int FilenameID) {
    AddLineNote(Loc.getRawEncoding(), LineNo, FilenameID);
  }
  public void AddLineNote(/*SourceLocation*/int Loc, /*uint*/int LineNo, 
          int FilenameID) {
    long/*<FileID, uint>*/ LocInfo = getDecomposedExpansionLoc(/*NO_COPY*/Loc);

    // Remember that this file has #line directives now if it doesn't already.
    if (!$setFileHasLineDirective($first_FileID(LocInfo))) {
      return;
    }
    
    getLineTable().AddLineNote($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo), LineNo, FilenameID);
  }

  private boolean $setFileHasLineDirective(/*FileID*/int FID) {
    int SLocEntryIndex = getFileSLocEntryByID_LoadEntryIfAbsent(FID);
    return $setFileSLocEntry_HasLineDirective(SLocEntryIndex);
  }  

  /* friend method for ASTReader only!*/
  public boolean $setFileSLocEntry_HasLineDirective(int SLocEntryIndex) {
    assert INVALID_SLOC_ENTRY_INDEX == 0 : "We skip index 0 where fake data is stored only for loads, not stores";
    boolean out = false;
    // Remember that this file has #line directives now if it doesn't already.
    if (SLocEntryIndex > 0) {
      assert (LocalSLocEntryTable.isFile_$at(SLocEntryIndex));
      out = true;
      LocalSLocEntryTable.$setHasLineDirectives(SLocEntryIndex);
    } else if (SLocEntryIndex < 0) {
      SLocEntryIndex = unmaskLoadedIndex(SLocEntryIndex);
      assert (LoadedSLocEntryTable.isFile_$at(SLocEntryIndex));
      out = true;
      LoadedSLocEntryTable.$setHasLineDirectives(SLocEntryIndex);
    }
    return out;
  }  


  /// AddLineNote - Add a GNU line marker to the line table.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::AddLineNote">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 307,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 311,
   FQN="clang::SourceManager::AddLineNote", NM="_ZN5clang13SourceManager11AddLineNoteENS_14SourceLocationEjibbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager11AddLineNoteENS_14SourceLocationEjibbbb")
  //</editor-fold>
  public void AddLineNote(SourceLocation Loc, /*uint*/int LineNo, 
          int FilenameID, boolean IsFileEntry, 
          boolean IsFileExit, boolean IsSystemHeader, 
          boolean IsExternCHeader) {
    AddLineNote(Loc.getRawEncoding(), LineNo, FilenameID, IsFileEntry, 
            IsFileExit, IsSystemHeader, IsExternCHeader);
  }
  public void AddLineNote(/*SourceLocation*/int Loc, /*uint*/int LineNo, 
          int FilenameID, boolean IsFileEntry, 
          boolean IsFileExit, boolean IsSystemHeader, 
          boolean IsExternCHeader) {
    // If there is no filename and no flags, this is treated just like a #line,
    // which does not change the flags of the previous line marker.
    if (FilenameID == -1) {
      assert (!IsFileEntry && !IsFileExit && !IsSystemHeader && !IsExternCHeader) : "Can't set flags without setting the filename!";
      AddLineNote(/*NO_COPY*/Loc, LineNo, FilenameID);
      return;
    }
    
    long/*<FileID, uint>*/ LocInfo = getDecomposedExpansionLoc(/*NO_COPY*/Loc);
    
    // Remember that this file has #line directives now if it doesn't already.
    if (!$setFileHasLineDirective($first_FileID(LocInfo))) {
      return;
    }
    
    getLineTable();
    
    SrcMgr.CharacteristicKind FileKind;
    if (IsExternCHeader) {
      FileKind = SrcMgr.CharacteristicKind.C_ExternCSystem;
    } else if (IsSystemHeader) {
      FileKind = SrcMgr.CharacteristicKind.C_System;
    } else {
      FileKind = SrcMgr.CharacteristicKind.C_User;
    }
    
    /*uint*/int EntryExit = 0;
    if (IsFileEntry) {
      EntryExit = 1;
    } else if (IsFileExit) {
      EntryExit = 2;
    }
    
    LineTable.AddLineNote($first_FileID(/*NO_COPY*/LocInfo), $second_int(LocInfo), LineNo, FilenameID, 
            EntryExit, FileKind);
  }

  
  /// \brief Determine if the source manager has a line table.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::hasLineTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1401,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1393,
   FQN="clang::SourceManager::hasLineTable", NM="_ZNK5clang13SourceManager12hasLineTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager12hasLineTableEv")
  //</editor-fold>
  public boolean hasLineTable() /*const*/ {
    return LineTable != null;
  }

  
  /// \brief Retrieve the stored line table.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getLineTable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 351,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 356,
   FQN="clang::SourceManager::getLineTable", NM="_ZN5clang13SourceManager12getLineTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager12getLineTableEv")
  //</editor-fold>
  public LineTableInfo /*&*/ getLineTable() {
    if (LineTable == null) {
      LineTable = new LineTableInfo();
    }
    return $Deref(LineTable);
  }

  
  //===--------------------------------------------------------------------===//
  // Queries for performance analysis.
  //===--------------------------------------------------------------------===//
  
  /// \brief Return the total amount of physical memory allocated by the
  /// ContentCache allocator.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getContentCacheSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1412,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1404,
   FQN="clang::SourceManager::getContentCacheSize", NM="_ZNK5clang13SourceManager19getContentCacheSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager19getContentCacheSizeEv")
  //</editor-fold>
  public /*size_t*/long getContentCacheSize() /*const*/ {
    return ContentCacheAlloc.getTotalMemory();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::MemoryBufferSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1416,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1408,
   FQN="clang::SourceManager::MemoryBufferSizes", NM="_ZN5clang13SourceManager17MemoryBufferSizesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager17MemoryBufferSizesE")
  //</editor-fold>
  public static class/*struct*/ MemoryBufferSizes {
    public /*const*//*size_t*/int malloc_bytes;
    public /*const*//*size_t*/int mmap_bytes;
    
    //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::MemoryBufferSizes::MemoryBufferSizes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1420,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1412,
     FQN="clang::SourceManager::MemoryBufferSizes::MemoryBufferSizes", NM="_ZN5clang13SourceManager17MemoryBufferSizesC1Ejj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager17MemoryBufferSizesC1Ejj")
    //</editor-fold>
    public MemoryBufferSizes(/*size_t*/int malloc_bytes, /*size_t*/int mmap_bytes) {
      /* : malloc_bytes(malloc_bytes), mmap_bytes(mmap_bytes)*/ 
      //START JInit
      this.malloc_bytes = malloc_bytes;
      this.mmap_bytes = mmap_bytes;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::MemoryBufferSizes::MemoryBufferSizes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1416,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1408,
     FQN="clang::SourceManager::MemoryBufferSizes::MemoryBufferSizes", NM="_ZN5clang13SourceManager17MemoryBufferSizesC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager17MemoryBufferSizesC1EOS1_")
    //</editor-fold>
    public /*inline*/ MemoryBufferSizes(JD$Move _dparam, MemoryBufferSizes /*&&*/$Prm0) {
      /* : malloc_bytes(static_cast<MemoryBufferSizes &&>().malloc_bytes), mmap_bytes(static_cast<MemoryBufferSizes &&>().mmap_bytes)*/ 
      //START JInit
      this.malloc_bytes = $Prm0.malloc_bytes;
      this.mmap_bytes = $Prm0.mmap_bytes;
      //END JInit
    }

    
    public String toString() {
      return "" + "malloc_bytes=" + malloc_bytes // NOI18N
                + ", mmap_bytes=" + mmap_bytes; // NOI18N
    }
  };
  
  /// \brief Return the amount of memory used by memory buffers, breaking down
  /// by heap-backed versus mmap'ed memory.
  
  /// Return the amount of memory used by memory buffers, breaking down
  /// by heap-backed versus mmap'ed memory.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getMemoryBufferSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 2220,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 2205,
   FQN="clang::SourceManager::getMemoryBufferSizes", NM="_ZNK5clang13SourceManager20getMemoryBufferSizesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager20getMemoryBufferSizesEv")
  //</editor-fold>
  public SourceManager.MemoryBufferSizes getMemoryBufferSizes() /*const*/ {
    /*size_t*/int malloc_bytes = 0;
    /*size_t*/int mmap_bytes = 0;
    
    for (/*uint*/int i = 0, e = MemBufferInfos.size(); i != e; ++i)  {
      {
        /*size_t*/int sized_mapped = MemBufferInfos.$at(i).getSizeBytesMapped();
        if ((sized_mapped != 0)) {
          switch (MemBufferInfos.$at(i).getMemoryBufferKind()) {
           case MemoryBuffer_MMap:
            mmap_bytes += sized_mapped;
            break;
           case MemoryBuffer_Malloc:
            malloc_bytes += sized_mapped;
            break;
          }
        }
      }
    }
    
    return new MemoryBufferSizes(malloc_bytes, mmap_bytes);
  }

  
  /// \brief Return the amount of memory used for various side tables and
  /// data structures in the SourceManager.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getDataStructureSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 2238,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 2223,
   FQN="clang::SourceManager::getDataStructureSizes", NM="_ZNK5clang13SourceManager21getDataStructureSizesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager21getDataStructureSizesEv")
  //</editor-fold>
  public /*size_t*/int getDataStructureSizes() /*const*/ {
    /*size_t*/int size = llvm.capacity_in_bytes(MemBufferInfos)
            + llvm.capacity_in_bytes(LocalSLocEntryTable)
            + llvm.capacity_in_bytes(LoadedSLocEntryTable)
            + llvm.capacity_in_bytes(SLocEntryLoaded)
            + llvm.capacity_in_bytes(FileInfos);
    if (OverriddenFilesInfo.$bool()) {
      size += llvm.capacity_in_bytes(OverriddenFilesInfo.$arrow().OverriddenFiles);
    }
    
    return size;
  }

  
  //===--------------------------------------------------------------------===//
  // Other miscellaneous methods.
  //===--------------------------------------------------------------------===//
  
  /// \brief Get the source location for the given file:line:col triplet.
  ///
  /// If the source file is included multiple times, the source location will
  /// be based upon the first inclusion.
  
  /// \brief Get the source location for the given file:line:col triplet.
  ///
  /// If the source file is included multiple times, the source location will
  /// be based upon an arbitrary inclusion.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::translateFileLineCol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1593,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1586,
   FQN="clang::SourceManager::translateFileLineCol", NM="_ZNK5clang13SourceManager20translateFileLineColEPKNS_9FileEntryEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager20translateFileLineColEPKNS_9FileEntryEjj")
  //</editor-fold>
  public SourceLocation translateFileLineCol(/*const*/ FileEntry /*P*/ SourceFile, 
          /*uint*/int Line, 
          /*uint*/int Col) /*const*/ {
    assert ((SourceFile != null)) : "Null source file!";
    assert ((Line != 0) && (Col != 0)) : "Line and column should start from 1!";
    
    FileID FirstFID = translateFile(SourceFile);
    return translateLineCol(/*NO_COPY*/FirstFID, Line, Col);
  }

  
  /// \brief Get the FileID for the given file.
  ///
  /// If the source file is included multiple times, the FileID will be the
  /// first inclusion.
  
  /// \brief Get the FileID for the given file.
  ///
  /// If the source file is included multiple times, the FileID will be the
  /// first inclusion.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::translateFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1607,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1600,
   FQN="clang::SourceManager::translateFile", NM="_ZNK5clang13SourceManager13translateFileEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13translateFileEPKNS_9FileEntryE")
  //</editor-fold>
  public FileID translateFile(/*const*/ FileEntry /*P*/ SourceFile) /*const*/ {
    assert ((SourceFile != null)) : "Null source file!";

    // Find the first file ID that corresponds to the given file.
    FileID FirstFID/*J*/= new FileID();

    // First, check the main file ID, since it is common to look for a
    // location in the main file.
    Optional<fs.UniqueID> SourceFileUID/*J*/= new Optional<fs.UniqueID>();
    Optional<StringRef> SourceFileName/*J*/= new Optional<StringRef>();
    if (MainFileID.isValid()) {
      /*SLocEntry&*/int MainSLoc = getSLocEntryByID_LoadEntryIfAbsent(/*NO_COPY*/MainFileID.ID);
      if (MainSLoc == INVALID_SLOC_ENTRY_INDEX) {
        return new FileID();
      }
      if ($isFile(MainSLoc)) {
        /*const*/SrcMgr.ContentCache/*P*/ MainContentCache = $getContentCache(MainSLoc);
        if (!(MainContentCache != null)) {
          // Can't do anything
        } else if (MainContentCache.OrigEntry == SourceFile) {
          FirstFID.$assign(MainFileID);
        } else {
          // Fall back: check whether we have the same base name and inode
          // as the main file.
          /*const*/ FileEntry /*P*/ MainFile = MainContentCache.OrigEntry;
          SourceFileName.$assign(path.filename(new StringRef(SourceFile.getName())));
          if ($eq_StringRef(/*NO_COPY*/SourceFileName.$star(), path.filename(new StringRef(MainFile.getName())))) {
            SourceFileUID.$assignMove(getActualFileUID(SourceFile));
            if (SourceFileUID.$bool()) {
              {
                Optional<fs.UniqueID> MainFileUID = getActualFileUID(MainFile);
                if (MainFileUID.$bool()) {
                  if (SourceFileUID.$star().$eq(MainFileUID.$star())) {
                    FirstFID.$assign(MainFileID);
                    SourceFile = MainFile;
                  }
                }
              }
            }
          }
        }
      }
    }
    if (FirstFID.isInvalid()) {
      // The location we're looking for isn't in the main file; look
      // through all of the local source locations.
      
      // JAVA: eleminated use of Invalid here, so need to start from the index 1
      // because index 0 is a special marker-index with invalid SLocEntry content mapped to 0
      for (/*uint*/int I = 1/*JAVA: instead of 0*/, N = local_sloc_entry_size(); I != N; ++I) {
        /*SLocEntry &*/int SLoc = getLocalSLocEntry_performance(I);
        if (SLoc == 0) {
          return new FileID();
        }
        if ($isFile(SLoc) 
            && ($getContentCache(SLoc) != null) 
            && $getContentCache(SLoc).OrigEntry == SourceFile) {
          FirstFID.$assignMove(I);
          break;
        }
      }
      // If that still didn't help, try the modules.
      if (FirstFID.isInvalid()) {
        for (/*uint*/int I = 0, N = (int)loaded_sloc_entry_size(); I != N; ++I) {
          /*SLocEntry &*/int SLoc = getLoadedSLocEntry(I);
          if ($isFile(SLoc) 
             && ($getContentCache(SLoc) != null)
             && $getContentCache(SLoc).OrigEntry == SourceFile) {
            FirstFID.$assign((-((int)(I)) - 2));
            break;
          }
        }
      }
    }

    // If we haven't found what we want yet, try again, but this time stat()
    // each of the files in case the files have changed since we originally 
    // parsed the file.
    if (FirstFID.isInvalid() 
       && (SourceFileName.$bool() 
           || 
          (SourceFileName.$assign(path.filename(new StringRef(SourceFile.getName())))).$bool())
       && (SourceFileUID.$bool() || (SourceFileUID.$assignMove(getActualFileUID(SourceFile))).$bool())) {
      for (/*uint*/int I = 0, N = local_sloc_entry_size(); I != N; ++I) {
        int IFileID = I;
        /*SLocEntry &*/int SLoc = getSLocEntryByID_LoadEntryIfAbsent(IFileID);
        if (SLoc == INVALID_SLOC_ENTRY_INDEX) {
          return new FileID();
        }
        if ($isFile(SLoc)) {
          /*const*/SrcMgr.ContentCache/*P*/ FileContentCache = $getContentCache(SLoc);
          /*const*/FileEntry /*P*/ Entry = (FileContentCache != null) ? FileContentCache.OrigEntry : null;
          if ((Entry != null) 
              && $eq_StringRef(/*NO_COPY*/SourceFileName.$star(), path.filename(new StringRef(Entry.getName())))) {
            {
              Optional<fs.UniqueID> EntryUID = getActualFileUID(Entry);
              if (EntryUID.$bool()) {
                if (SourceFileUID.$star().$eq(EntryUID.$star())) {
                  FirstFID.$assignMove(I);
                  SourceFile = Entry;
                  break;
                }
              }
            }
          }
        }
      }
    }

//    (void)SourceFile;
    return FirstFID;
  }

  
  /// \brief Get the source location in \p FID for the given line:col.
  /// Returns null location if \p FID is not a file SLocEntry.
  
  /// \brief Get the source location in \arg FID for the given line:col.
  /// Returns null location if \arg FID is not a file SLocEntry.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::translateLineCol">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1722,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1715,
   FQN="clang::SourceManager::translateLineCol", NM="_ZNK5clang13SourceManager16translateLineColENS_6FileIDEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16translateLineColENS_6FileIDEjj")
  //</editor-fold>
  public SourceLocation translateLineCol(FileID FID, 
          /*uint*/int Line, 
          /*uint*/int Col) /*const*/ {
    return SourceLocation.getFromRawEncoding(translateLineCol(FID.ID, Line, Col));
  }
  public /*SourceLocation*/int translateLineCol(/*FileID*/int FID, 
          /*uint*/int Line, 
          /*uint*/int Col) /*const*/ {
    // Lines are used as a one-based index into a zero-based array. This assert
    // checks for possible buffer underruns.
    assert ((Line != 0) && (Col != 0)) : "Line and column should start from 1!";
    if (FileID.isInvalid(FID)) {
      return SourceLocation.getInvalid();
    }
    
    /*SLocEntry &*/int Entry = getSLocEntryByID_LoadEntryIfAbsent(FID);
    if (Entry == INVALID_SLOC_ENTRY_INDEX) {
      return SourceLocation.getInvalid();
    }
    if (!$isFile(Entry)) {
      return SourceLocation.getInvalid();
    }
    
    /*SourceLocation*/int FileLoc = SourceLocation.$getFileLoc($getOffset(Entry));
    if (Line == 1 && Col == 1) {
      return FileLoc;
    }
    
    SrcMgr.ContentCache/*P*/ Content = (/*const_cast*/SrcMgr.ContentCache/*P*/ )($getContentCache(Entry));
    if (!(Content != null)) {
      return SourceLocation.getInvalid();
    }
    
    // If this is the first use of line information for this buffer, compute the
    // SourceLineCache for it on demand.
    if (Content.SourceLineCache == null) {
      boolean MyInvalid = false;
      MyInvalid = ComputeLineNumbers(Diag, Content, ContentCacheAlloc, /*Deref*/this, null/*MyInvalid*/);
      if (MyInvalid) {
        return SourceLocation.getInvalid();
      }
    }
    if ($greater_uint(Line, Content.NumLines)) {
      /*uint*/int Size = Content.getBuffer(Diag, /*Deref*/this).getBufferSize();
      if ($greater_uint(Size, 0)) {
        --Size;
      }
      return SourceLocation.$getLocWithOffset(FileLoc, Size);
    }
    
    MemoryBuffer /*P*/ Buffer = Content.getBuffer(Diag, /*Deref*/this);
    /*uint*/int FilePos = Content.SourceLineCache[Line - 1];
    /*const*/char$ptr/*char P*/ Buf = Buffer.getBufferStart().$add(FilePos);
    /*uint*/int BufLength = Buffer.getBufferSize() - FilePos;
    if (BufLength == 0) {
      return SourceLocation.$getLocWithOffset(FileLoc, FilePos);
    }
    
    /*uint*/int i = 0;
    
    // Check that the given column is valid.
    while ($less_uint(i, BufLength - 1) && $less_uint(i, Col - 1) && Buf.$at(i) != $$LF && Buf.$at(i) != $$CR) {
      ++i;
    }
    return SourceLocation.$getLocWithOffset(FileLoc, FilePos + i);
  }

  
  /// \brief If \p Loc points inside a function macro argument, the returned
  /// location will be the macro location in which the argument was expanded.
  /// If a macro argument is used multiple times, the expanded location will
  /// be at the first expansion of the argument.
  /// e.g.
  ///   MY_MACRO(foo);
  ///             ^
  /// Passing a file location pointing at 'foo', will yield a macro location
  /// where 'foo' was expanded into.
  
  /// \brief If \arg Loc points inside a function macro argument, the returned
  /// location will be the macro location in which the argument was expanded.
  /// If a macro argument is used multiple times, the expanded location will
  /// be at the first expansion of the argument.
  /// e.g.
  ///   MY_MACRO(foo);
  ///             ^
  /// Passing a file location pointing at 'foo', will yield a macro location
  /// where 'foo' was expanded into.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getMacroArgExpandedLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1933,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1926,
   FQN="clang::SourceManager::getMacroArgExpandedLocation", NM="_ZNK5clang13SourceManager27getMacroArgExpandedLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager27getMacroArgExpandedLocationENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation getMacroArgExpandedLocation(SourceLocation Loc) /*const*/ {
    return SourceLocation.getFromRawEncoding(getMacroArgExpandedLocation(Loc.getRawEncoding()));
  }
  public /*SourceLocation*/int getMacroArgExpandedLocation(/*SourceLocation*/int Loc) /*const*/ {
    if (SourceLocation.isInvalid(Loc) || !SourceLocation.isFileID(Loc)) {
      return Loc;
    }
    
    long/*<FileID, uint>*/ decomposedLoc = getDecomposedLoc(Loc);
    /*FileID*/int FID/*J*/= $first_FileID(decomposedLoc);
    /*uint*/int Offset = $second_offset(decomposedLoc);
    if (FileID.isInvalid(FID)) {
      return Loc;
    }
    
    std.mapUIntType<SourceLocation> /*P*/ /*&*/ MacroArgsCache = MacroArgsCacheMap.$at(FID);
    if (!(MacroArgsCache != null)) {
      // JAVA: emulate pointer to the maps's entry
      MacroArgsCache = new std.mapUIntType<SourceLocation>(new SourceLocation());
      computeMacroArgsCache(MacroArgsCache, /*NO_COPY*/FID);
      MacroArgsCacheMap.$set(FID, MacroArgsCache);
    }
    assert (!MacroArgsCache.empty());
    std.mapUIntType.iterator<SourceLocation> I = MacroArgsCache.upper_bound(Offset);
    I.$preDec();
    
    /*uint*/int MacroArgBeginOffs = I.$arrow().first;
    SourceLocation MacroArgExpandedLoc = I.$arrow().second;
    if (MacroArgExpandedLoc.isValid()) {
      return MacroArgExpandedLoc.$getLocWithOffset(Offset - MacroArgBeginOffs);
    }
    
    return Loc;
  }

  
  /// \brief Determines the order of 2 source locations in the translation unit.
  ///
  /// \returns true if LHS source location comes before RHS, false otherwise.
  
  /// \brief Determines the order of 2 source locations in the translation unit.
  ///
  /// \returns true if LHS source location comes before RHS, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isBeforeInTranslationUnit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 2034,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 2027,
   FQN="clang::SourceManager::isBeforeInTranslationUnit", NM="_ZNK5clang13SourceManager25isBeforeInTranslationUnitENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager25isBeforeInTranslationUnitENS_14SourceLocationES1_")
  //</editor-fold>
  public boolean isBeforeInTranslationUnit(SourceLocation LHS, 
                           SourceLocation RHS) /*const*/ {
    return isBeforeInTranslationUnit(LHS.getRawEncoding(), RHS.getRawEncoding());
  }
  public boolean isBeforeInTranslationUnit(/*SourceLocation*/int LHS, /*SourceLocation*/int RHS) /*const*/ {
    assert (SourceLocation.isValid(LHS) && SourceLocation.isValid(RHS)) : "Passed invalid source location!";
    if ($eq_SourceLocation$C(LHS, RHS)) {
      return false;
    }

    std.pairIntUInt/*<FileID, uint>*/ LOffs = new std.pairIntUInt(/*NO_COPY*/getDecomposedLoc(LHS));
    std.pairIntUInt/*<FileID, uint>*/ ROffs = new std.pairIntUInt(/*NO_COPY*/getDecomposedLoc(RHS));

    // getDecomposedLoc may have failed to return a valid FileID because, e.g. it
    // is a serialized one referring to a file that was removed after we loaded
    // the PCH.
    if (FileID.isInvalid(LOffs.first) || FileID.isInvalid(ROffs.first)) {
      return FileID.isInvalid(LOffs.first) && !FileID.isInvalid(ROffs.first);
    }

    // If the source locations are in the same file, just compare offsets.
    if (LOffs.first == ROffs.first) {
      return $less_uint(LOffs.second, ROffs.second);
    }

    // If we are comparing a source location with multiple locations in the same
    // file, we get a big win by caching the result.
    InBeforeInTUCacheEntry /*&*/ IsBeforeInTUCache = getInBeforeInTUCache(/*NO_COPY*/LOffs.first, /*NO_COPY*/ROffs.first);

    // If we are comparing a source location with multiple locations in the same
    // file, we get a big win by caching the result.
    if (IsBeforeInTUCache.isCacheValid(/*NO_COPY*/LOffs.first, /*NO_COPY*/ROffs.first)) {
      return IsBeforeInTUCache.getCachedResult(LOffs.second, ROffs.second);
    }

    // Okay, we missed in the cache, start updating the cache for this query.
    IsBeforeInTUCache.setQueryFIDs(/*NO_COPY*/LOffs.first, /*NO_COPY*/ROffs.first, 
        /*isLFIDBeforeRFID=*/ LOffs.first < ROffs.first);

    // We need to find the common ancestor. The only way of doing this is to
    // build the complete include chain for one and then walking up the chain
    // of the other looking for a match.
    // We use a map from FileID to Offset to store the chain. Easier than writing
    // a custom set hash info that only depends on the first part of a pair.
    /*typedef llvm::SmallDenseMap<FileID, unsigned int, 16> LocSet*/
//    final class LocSet extends SmallDenseMapTypeUInt<FileID>{ };
    SmallDenseMapIntUInt/*<FileID, uint>*/ LChain /*J*/= new SmallDenseMapIntUInt/*<FileID, uint>*/(new DenseMapInfoIntFileID(), 16, 0);
    do {
      LChain.insert(LOffs);
      // We catch the case where LOffs is in a file included by ROffs and
      // quit early. The other way round unfortunately remains suboptimal.
    } while ((LOffs.first != ROffs.first) && !MoveUpIncludeHierarchy(LOffs, /*Deref*/this));
    DenseMapIteratorIntUInt/*<FileID, uint>*/ I/*J*/;
    while ((I = LChain.find(ROffs.first)).$eq(/*NO_ITER_COPY*/LChain.end())) {
      if (MoveUpIncludeHierarchy(ROffs, /*Deref*/this)) {
        break; // Met at topmost file.
      }
    }
    if (I.$noteq(/*NO_ITER_COPY*/LChain.end())) {
      LOffs.$assign(I.$star());
    }

    // If we exited because we found a nearest common ancestor, compare the
    // locations within the common file and cache them.
    if (LOffs.first == ROffs.first) {
      IsBeforeInTUCache.setCommonLoc(/*NO_ITER_COPY*/LOffs.first, LOffs.second, ROffs.second);
      return IsBeforeInTUCache.getCachedResult(LOffs.second, ROffs.second);
    }

    // If we arrived here, the location is either in a built-ins buffer or
    // associated with global inline asm. PR5662 and PR22576 are examples.
    
    // Clear the lookup cache, it depends on a common location.
    IsBeforeInTUCache.clear();
    char$ptr /*P*/ LB = getBuffer(/*NO_COPY*/LOffs.first).getBufferIdentifier();
    char$ptr /*P*/ RB = getBuffer(/*NO_COPY*/ROffs.first).getBufferIdentifier();
    boolean LIsBuiltins = strcmp($built_in_marker, LB) == 0;
    boolean RIsBuiltins = strcmp($built_in_marker, RB) == 0;
    // Sort built-in before non-built-in.
    if (LIsBuiltins || RIsBuiltins) {
      if (LIsBuiltins != RIsBuiltins) {
        return LIsBuiltins;
      }
      // Both are in built-in buffers, but from different files. We just claim that
      // lower IDs come first.
      return LOffs.first < ROffs.first;
    }
    boolean LIsAsm = strcmp(/*KEEP_STR*/"<inline asm>", LB) == 0;
    boolean RIsAsm = strcmp(/*KEEP_STR*/"<inline asm>", RB) == 0;
    // Sort assembler after built-ins, but before the rest.
    if (LIsAsm || RIsAsm) {
      if (LIsAsm != RIsAsm) {
        return RIsAsm;
      }
      assert (LOffs.first == ROffs.first);
      return false;
    }
    boolean LIsScratch = strcmp($scratch_space_marker, LB) == 0;
    boolean RIsScratch = strcmp($scratch_space_marker, RB) == 0;
    // Sort scratch after inline asm, but before the rest.
    if (LIsScratch || RIsScratch) {
      if (LIsScratch != RIsScratch) {
        return LIsScratch;
      }
      return $less_uint(LOffs.second, ROffs.second);
    }    
    throw new llvm_unreachable("Unsortable locations found");
  }
  
  
  /// \brief Determines the order of 2 source locations in the "source location
  /// address space".
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isBeforeInSLocAddrSpace">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1472,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1464,
   FQN="clang::SourceManager::isBeforeInSLocAddrSpace", NM="_ZNK5clang13SourceManager23isBeforeInSLocAddrSpaceENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager23isBeforeInSLocAddrSpaceENS_14SourceLocationES1_")
  //</editor-fold>
  public boolean isBeforeInSLocAddrSpace_SLoc_SLoc(SourceLocation LHS, SourceLocation RHS) /*const*/ {
    return isBeforeInSLocAddrSpace_SLoc_Offset(/*NO_COPY*/LHS.getRawEncoding(), RHS.getOffset());
  }
  public boolean isBeforeInSLocAddrSpace_SLoc_SLoc(/*SourceLocation*/int LHS, /*SourceLocation*/int RHS) /*const*/ {
    return isBeforeInSLocAddrSpace_SLoc_Offset(/*NO_COPY*/LHS, SourceLocation.getOffset(RHS));
  }

  
  /// \brief Determines the order of a source location and a source location
  /// offset in the "source location address space".
  ///
  /// Note that we always consider source locations loaded from
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isBeforeInSLocAddrSpace">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1480,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1472,
   FQN="clang::SourceManager::isBeforeInSLocAddrSpace", NM="_ZNK5clang13SourceManager23isBeforeInSLocAddrSpaceENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager23isBeforeInSLocAddrSpaceENS_14SourceLocationEj")
  //</editor-fold>
  public boolean isBeforeInSLocAddrSpace_SLoc_Offset(SourceLocation LHS, /*uint*/int RHSOffset) /*const*/ {
    return isBeforeInSLocAddrSpace_SLoc_Offset(LHS.getRawEncoding(), RHSOffset);
  }
  public boolean isBeforeInSLocAddrSpace_SLoc_Offset(/*SourceLocation*/int LHS, /*uint*/int RHSOffset) /*const*/ {
    /*uint*/int LHSOffset = SourceLocation.getOffset(LHS);
    boolean LHSLoaded = $greatereq_uint(LHSOffset, CurrentLoadedOffset);
    boolean RHSLoaded = $greatereq_uint(RHSOffset, CurrentLoadedOffset);
    if (LHSLoaded == RHSLoaded) {
      return $less_uint(LHSOffset, RHSOffset);
    }
    
    return LHSLoaded;
  }

  
  // Iterators over FileInfos.
  /*typedef llvm::DenseMap<const FileEntry *, SrcMgr::ContentCache *>::const_iterator fileinfo_iterator*/
//  public final class fileinfo_iterator extends DenseMapIterator</*const*/FileEntry /*P*/ , SrcMgr.ContentCache /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::fileinfo_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1493,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1485,
   FQN="clang::SourceManager::fileinfo_begin", NM="_ZNK5clang13SourceManager14fileinfo_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager14fileinfo_beginEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ FileEntry /*P*/ , SrcMgr.ContentCache /*P*/ > fileinfo_begin() /*const*/ {
    return FileInfos.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::fileinfo_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1494,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1486,
   FQN="clang::SourceManager::fileinfo_end", NM="_ZNK5clang13SourceManager12fileinfo_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager12fileinfo_endEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ FileEntry /*P*/ , SrcMgr.ContentCache /*P*/ > fileinfo_end() /*const*/ {
    return FileInfos.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::hasFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1495,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1487,
   FQN="clang::SourceManager::hasFileInfo", NM="_ZNK5clang13SourceManager11hasFileInfoEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager11hasFileInfoEPKNS_9FileEntryE")
  //</editor-fold>
  public boolean hasFileInfo(/*const*/ FileEntry /*P*/ File) /*const*/ {
    return FileInfos.find(File).$noteq(FileInfos.end());
  }

  
  /// \brief Print statistics to stderr.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::PrintStats">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 2131,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 2116,
   FQN="clang::SourceManager::PrintStats", NM="_ZNK5clang13SourceManager10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() /*const*/ {
      PrintStats(llvm.errs());
  }
  public void PrintStats(raw_ostream /*&*/ OS) /*const*/ {
    OS.$out(/*KEEP_STR*/"\n*** Source Manager Stats:\n");
    OS.$out(NativeTrace.formatNumber(FileInfos.size())).$out(" files mapped, ")
            .$out(NativeTrace.formatNumber(MemBufferInfos.size())).$out(" mem buffers mapped.\n");
    OS.$out(NativeTrace.formatNumber(local_sloc_entry_size())).$out(" local SLocEntry's allocated (")
            .$out(NativeTrace.formatNumber(llvm.capacity_in_bytes(LocalSLocEntryTable))).$out(" bytes of capacity), ")
            .$out(NativeTrace.formatNumber(NextLocalOffset)).$out("B of Sloc address space used.\n");
    OS.$out(NativeTrace.formatNumber(LoadedSLocEntryTable.size())).$out(" loaded SLocEntries allocated, ")
            .$out(NativeTrace.formatNumber($uint2ulong(MaxLoadedOffset - CurrentLoadedOffset))).$out("B of Sloc address space used.\n");
    
    /*uint*/int NumLineNumsComputed = 0;
    /*uint*/int NumFileBytesMapped = 0;
    for (DenseMapIterator</*const*/FileEntry /*P*/ , SrcMgr.ContentCache /*P*/ > I = fileinfo_begin(), E = fileinfo_end(); I.$noteq(E); I.$preInc()) {
      NumLineNumsComputed += (I.$arrow().second.SourceLineCache != null) ? 1 : 0;
      NumFileBytesMapped += I.$arrow().second.getSizeBytesMapped();
    }
    /*uint*/int NumMacroArgsComputed = MacroArgsCacheMap.size();
    
    OS.$out(NativeTrace.formatNumber(NumFileBytesMapped)).$out(" bytes of files mapped, ")
            .$out(NativeTrace.formatNumber(NumLineNumsComputed))
            .$out(" files with line #'s computed, ").$out(NativeTrace.formatNumber(NumMacroArgsComputed))
            .$out(" files with macro args computed.\n");
    OS.$out("FileID slow scans: ")
            .$out(NativeTrace.formatNumber(NumLinearScans+NumLinearMacroScans+NumBinaryProbes+NumBinaryMacroProbes)).$out(" total (")
            .$out(NativeTrace.formatNumber(NumLinearScans+NumLinearMacroScans)).$out(" linear, ")
            .$out(NativeTrace.formatNumber(NumBinaryProbes+NumBinaryMacroProbes)).$out(" binary).\n");
    OS.$out("FileID scans: ")
            .$out(NativeTrace.formatNumber(NumLinearScans)).$out(" linear, ")
            .$out(NativeTrace.formatNumber(NumBinaryProbes)).$out(" binary.\n");
    OS.$out("MacroID scans: ")
            .$out(NativeTrace.formatNumber(NumLinearMacroScans)).$out(" linear, ")
            .$out(NativeTrace.formatNumber(NumBinaryMacroProbes)).$out(" binary.\n");
    OS.$out("FileID Slice scans: ")
            .$out(NativeTrace.formatNumber(NumImmediateSliceScans)).$out(" immediate, ")
            .$out(NativeTrace.formatNumber(NumLinearSliceScans)).$out(" linear, ")
            .$out(NativeTrace.formatNumber(NumBinarySliceProbes)).$out(" binary.\n");
  }

  @FunctionalInterface
  private static interface DumpSLocEntry{
      void $call(int ID, SrcMgr.SLocEntry Entry, OptionalUInt NextStart);
  }
    
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::dump">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 2159,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 2144,
   FQN="clang::SourceManager::dump", NM="_ZNK5clang13SourceManager4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {

    
    raw_ostream /*&*/ out = llvm.errs();
    
    DumpSLocEntry DumpSLocEntry =  (ID, Entry, NextStart) -> 
      {
        out.$out(/*KEEP_STR*/"SLocEntry <FileID ").$out_int(ID).$out(/*KEEP_STR*/"> ").$out((Entry.isFile() ? /*KEEP_STR*/"file" : /*KEEP_STR*/"expansion")).$out(/*KEEP_STR*/" <SourceLocation ").$out_uint(Entry.getOffset()).$out(/*KEEP_STR*/$COLON);
        if (NextStart.$bool()) {
          out.$out_uint(NextStart.$star()).$out(/*KEEP_STR*/$GT_LF);
        } else {
          out.$out(/*KEEP_STR*/"????>\n");
        }
        if (Entry.isFile()) {
          /*const*/SrcMgr.FileInfo /*&*/ FI = Entry.getFile();
          if ((FI.getNumCreatedFIDs() != 0)) {
            out.$out(/*KEEP_STR*/"  covers <FileID ").$out_int(ID).$out(/*KEEP_STR*/$COLON).$out_int(((int)(ID + FI.getNumCreatedFIDs()))).$out(/*KEEP_STR*/$GT_LF);
          }
          if (FI.getIncludeLoc().isValid()) {
            out.$out(/*KEEP_STR*/"  included from ").$out_uint(FI.getIncludeLoc().getOffset()).$out(/*KEEP_STR*/$LF);
          }
          {
            /*const*/SrcMgr.ContentCache/*P*/ CC = getContentCache(FI);
            if ((CC != null)) {
              out.$out(/*KEEP_STR*/"  for ").$out(((CC.OrigEntry != null) ? CC.OrigEntry.getName() : $("<none>"))).$out(/*KEEP_STR*/$LF);
              if (CC.BufferOverridden) {
                out.$out(/*KEEP_STR*/"  contents overridden\n");
              }
              if (CC.ContentsEntry != CC.OrigEntry) {
                out.$out(/*KEEP_STR*/"  contents from ").$out(((CC.ContentsEntry != null) ? CC.ContentsEntry.getName() : $("<none>"))).$out(/*KEEP_STR*/$LF);
              }
            }
          }
        } else {
          /*const*/SrcMgr.ExpansionInfo/*&*/ EI = Entry.getExpansion();
          out.$out(/*KEEP_STR*/"  spelling from ").$out_uint(EI.getSpellingLoc().getOffset()).$out(/*KEEP_STR*/$LF);
          out.$out(/*KEEP_STR*/"  macro ").$out((EI.isMacroArgExpansion() ? $("arg") : $("body"))).$out(/*KEEP_STR*/" range <").$out_uint(EI.getExpansionLocStart().getOffset()).$out(/*KEEP_STR*/$COLON).$out_uint(EI.getExpansionLocEnd().getOffset()).$out(/*KEEP_STR*/$GT_LF);
        }
      }
;
    
    // Dump local SLocEntries.
    for (/*uint*/int ID = 0, NumIDs = LocalSLocEntryTable.size(); ID != NumIDs; ++ID) {
      DumpSLocEntry.$call(ID, LocalSLocEntryTable.$at(ID), 
          new OptionalUInt(ID == NumIDs - 1 ? NextLocalOffset : LocalSLocEntryTable.$at(ID + 1).getOffset()));
    }
    // Dump loaded SLocEntries.
    OptionalUInt NextStart/*J*/= new OptionalUInt();
    for (/*uint*/int Index = 0; Index != LoadedSLocEntryTable.size(); ++Index) {
      int ID = -(int)Index - 2;
      if (SLocEntryLoaded.$at(Index)) {
        DumpSLocEntry.$call(ID, LoadedSLocEntryTable.$at(Index), NextStart);
        NextStart = new OptionalUInt(LoadedSLocEntryTable.$at(Index).getOffset());
      } else {
        NextStart = new OptionalUInt(NoneType.None);
      }
    }
  }

  
  /// \brief Get the number of local SLocEntries we have.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::local_sloc_entry_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1506,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1498,
   FQN="clang::SourceManager::local_sloc_entry_size", NM="_ZNK5clang13SourceManager21local_sloc_entry_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager21local_sloc_entry_sizeEv")
  //</editor-fold>
  public /*uint*/int local_sloc_entry_size() /*const*/ {
    assert LocalSLocEntryTable.size() == local_sloc_entry_size;
    return local_sloc_entry_size;
  }

  
  // JAVVA: use output index for $get*(SLocEntryIndex) methods 
  /// \brief Get a local SLocEntry. This is exposed for indexing.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getLocalSLocEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1509,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1501,
   FQN="clang::SourceManager::getLocalSLocEntry", NM="_ZNK5clang13SourceManager17getLocalSLocEntryEjPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager17getLocalSLocEntryEjPb")
  //</editor-fold>
  public /*const SrcMgr.SLocEntry &*//*SLocEntryIndex*/int getLocalSLocEntry_performance(/*uint*/int Index) /*const*/ {
    assert ($less_uint(Index, local_sloc_entry_size)) : "Invalid index";
    return Index;
  }
  public /*const*/ SrcMgr.SLocEntry /*&*/ getLocalSLocEntry(/*uint*/int Index) /*const*/ {
    return getLocalSLocEntry(Index, 
                   (bool$ptr/*bool P*/ )null);
  }
  public /*const*/ SrcMgr.SLocEntry /*&*/ getLocalSLocEntry(/*uint*/int Index, 
                  bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
   assert ($less_uint(Index, LocalSLocEntryTable.size())) : "Invalid index";
   return LocalSLocEntryTable.$at(Index);
  }
  
  /// \brief Get the number of loaded SLocEntries we have.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::loaded_sloc_entry_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1516,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1508,
   FQN="clang::SourceManager::loaded_sloc_entry_size", NM="_ZNK5clang13SourceManager22loaded_sloc_entry_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager22loaded_sloc_entry_sizeEv")
  //</editor-fold>
  public /*uint*/int loaded_sloc_entry_size() /*const*/ {
    return LoadedSLocEntryTable.size();
  }

  // JAVA: use output index for $get*(SLocEntryIndex) methods; returned ERROR_LOAD_SLOC_ENTY is an error
  /// \brief Get a loaded SLocEntry. This is exposed for indexing.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getLoadedSLocEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1519,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1511,
   FQN="clang::SourceManager::getLoadedSLocEntry", NM="_ZNK5clang13SourceManager18getLoadedSLocEntryEjPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager18getLoadedSLocEntryEjPb")
  //</editor-fold>
  public /*const SrcMgr.SLocEntry &*//*SLocEntryIndex*/int getLoadedSLocEntry(/*uint*/int Index) /*const*/ {
    assert ($less_uint(Index,  LoadedSLocEntryTable.size())) : "Invalid index";
    if (!SLocEntryLoaded.$at(Index)) {
      if (loadSLocEntry(Index)) {
        // error
        return INVALID_SLOC_ENTRY_INDEX;
      }
    }
    return maskValidLoadedIndex(Index);
  }

  // JAVA: For performance and memory critical paths use
  // getFileSLocEntryByID_LoadEntryIfAbsent
  // getExpansionSLocEntryByID_LoadEntryIfAbsent
  // or general
  // getSLocEntryByID_LoadEntryIfAbsent 
  // then use output index for $get*(SLocEntryIndex) methods   
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getSLocEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1527,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1519,
   FQN="clang::SourceManager::getSLocEntry", NM="_ZNK5clang13SourceManager12getSLocEntryENS_6FileIDEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager12getSLocEntryENS_6FileIDEPb")
  //</editor-fold>
  public /*const*/SrcMgr.SLocEntry /*&*/ getSLocEntry(FileID FID) /*const*/ {
    return getSLocEntry(FID.ID, 
              (bool$ptr/*bool P*/ )null);
  }
  public /*const*/SrcMgr.SLocEntry /*&*/ getSLocEntry(FileID FID, 
              bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    return getSLocEntry(FID.ID, Invalid);
  }
  public /*const*/SrcMgr.SLocEntry /*&*/ getSLocEntry(/*FileID*/int FID) /*const*/ {
    return getSLocEntry(FID, 
              (bool$ptr/*bool P*/ )null);
  }
  public /*const*/SrcMgr.SLocEntry /*&*/ getSLocEntry(/*FileID*/int FID, 
              bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    if (FID == 0 || FID == -1) {
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      return LocalSLocEntryTable.$at(INVALID_SLOC_ENTRY_INDEX);
    }
    assert (FID != -1) : "Using FileID sentinel value";
    int SLocEntryIndex;
    if (FID < 0) {
      SLocEntryIndex = getLoadedSLocEntryByID(FID);
    } else {
      SLocEntryIndex = getLocalSLocEntry_performance(FID);
    }
    if (Invalid != null) {
      Invalid.$set(SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX);
    }
    return $getSLocEntry(SLocEntryIndex);
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getNextLocalOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1536,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1528,
   FQN="clang::SourceManager::getNextLocalOffset", NM="_ZNK5clang13SourceManager18getNextLocalOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager18getNextLocalOffsetEv")
  //</editor-fold>
  public /*uint*/int getNextLocalOffset() /*const*/ {
    if (false) NativeTrace.getLogger().log(Level.FINE, "SM {0}:{1} getNextLocalOffset [{2}]", new Object[]{System.identityHashCode(this), NextLocalOffset, Thread.currentThread().getName()});
    return NextLocalOffset;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::setExternalSLocEntrySource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1538,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1530,
   FQN="clang::SourceManager::setExternalSLocEntrySource", NM="_ZN5clang13SourceManager26setExternalSLocEntrySourceEPNS_23ExternalSLocEntrySourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager26setExternalSLocEntrySourceEPNS_23ExternalSLocEntrySourceE")
  //</editor-fold>
  public void setExternalSLocEntrySource(ExternalSLocEntrySource /*P*/ Source) {
    assert (LoadedSLocEntryTable.empty()) : "Invalidating existing loaded entries";
    ExternalSLocEntries = Source;
  }

  
  /// \brief Allocate a number of loaded SLocEntries, which will be actually
  /// loaded on demand from the external source.
  ///
  /// NumSLocEntries will be allocated, which occupy a total of TotalSize space
  /// in the global source view. The lowest ID and the base offset of the
  /// entries will be returned.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::AllocateLoadedSLocEntries">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 479,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 483,
   FQN="clang::SourceManager::AllocateLoadedSLocEntries", NM="_ZN5clang13SourceManager25AllocateLoadedSLocEntriesEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager25AllocateLoadedSLocEntriesEjj")
  //</editor-fold>
  public std.pairIntUInt AllocateLoadedSLocEntries(/*uint*/int NumSLocEntries, 
          /*uint*/int TotalSize) {
    assert ((ExternalSLocEntries != null)) : "Don't have an external sloc source";
    // Make sure we're not about to run out of source locations.
    if ($less_uint(CurrentLoadedOffset - TotalSize, NextLocalOffset)) {
      return std.make_pair_int_uint(0, 0);
    }    
//    LoadedSLocEntryTable.resize(LoadedSLocEntryTable.size() + NumSLocEntries, null /*new SrcMgr.SLocEntry()*/);
    LoadedSLocEntryTable = LoadedSLocEntryTable.resize(LoadedSLocEntryTable.size() + NumSLocEntries);
    LoadedSLocTableIsSliced = LoadedSLocEntryTable.isSlicedByOffsets();
    SLocEntryLoaded.resize(LoadedSLocEntryTable.size(), false);
    CurrentLoadedOffset -= TotalSize;
    int ID = LoadedSLocEntryTable.size();
    return std.make_pair_int_uint(-ID - 1, CurrentLoadedOffset);
  }

  
  /// \brief Returns true if \p Loc came from a PCH/Module.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isLoadedSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1554,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1546,
   FQN="clang::SourceManager::isLoadedSourceLocation", NM="_ZNK5clang13SourceManager22isLoadedSourceLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager22isLoadedSourceLocationENS_14SourceLocationE")
  //</editor-fold>
  public boolean isLoadedSourceLocation(SourceLocation Loc) /*const*/ {
    return $greatereq_uint(Loc.getOffset(), CurrentLoadedOffset);
  }

  
  /// \brief Returns true if \p Loc did not come from a PCH/Module.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isLocalSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1559,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1551,
   FQN="clang::SourceManager::isLocalSourceLocation", NM="_ZNK5clang13SourceManager21isLocalSourceLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager21isLocalSourceLocationENS_14SourceLocationE")
  //</editor-fold>
  public boolean isLocalSourceLocation(SourceLocation Loc) /*const*/ {
    return $less_uint(Loc.getOffset(), NextLocalOffset);
  }

  
  /// \brief Returns true if \p FID came from a PCH/Module.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isLoadedFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1564,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1556,
   FQN="clang::SourceManager::isLoadedFileID", NM="_ZNK5clang13SourceManager14isLoadedFileIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager14isLoadedFileIDENS_6FileIDE")
  //</editor-fold>
  public boolean isLoadedFileID(FileID FID) /*const*/ {
    assert (FID.ID != -1) : "Using FileID sentinel value";
    return FID.ID < 0;
  }

  
  /// \brief Returns true if \p FID did not come from a PCH/Module.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isLocalFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1570,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1562,
   FQN="clang::SourceManager::isLocalFileID", NM="_ZNK5clang13SourceManager13isLocalFileIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13isLocalFileIDENS_6FileIDE")
  //</editor-fold>
  public boolean isLocalFileID(FileID FID) /*const*/ {
    return !isLoadedFileID(/*NO_COPY*/FID);
  }

  
  /// Gets the location of the immediate macro caller, one level up the stack
  /// toward the initial macro typed into the source.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getImmediateMacroCallerLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1576,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1568,
   FQN="clang::SourceManager::getImmediateMacroCallerLoc", NM="_ZNK5clang13SourceManager26getImmediateMacroCallerLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager26getImmediateMacroCallerLocENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation getImmediateMacroCallerLoc(SourceLocation Loc) /*const*/ {
    return SourceLocation.getFromRawEncoding(getImmediateMacroCallerLoc(Loc.getRawEncoding()));
  }
  public /*SourceLocation*/int getImmediateMacroCallerLoc(/*SourceLocation*/int Loc) /*const*/ {
    if (!SourceLocation.isMacroID(Loc)) {
      return Loc;
    }
    
    // When we have the location of (part of) an expanded parameter, its
    // spelling location points to the argument as expanded in the macro call,
    // and therefore is used to locate the macro caller.
    if (isMacroArgExpansion(/*NO_COPY*/Loc)) {
      return getImmediateSpellingLoc(/*NO_COPY*/Loc);
    }
    
    // Otherwise, the caller of the macro is located where this macro is
    // expanded (while the spelling is part of the macro definition).
    return $first_int(getImmediateExpansionRange(/*NO_COPY*/Loc));
  }

/*private:*/
  
  /// \brief As part of recovering from missing or changed content, produce a
  /// fake, non-empty buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFakeBufferForRecovery">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 495,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 497,
   FQN="clang::SourceManager::getFakeBufferForRecovery", NM="_ZNK5clang13SourceManager24getFakeBufferForRecoveryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager24getFakeBufferForRecoveryEv")
  //</editor-fold>
  private MemoryBuffer /*P*/ getFakeBufferForRecovery() /*const*/ {
    if (!FakeBufferForRecovery.$bool()) {
      FakeBufferForRecovery.$assignMove(MemoryBuffer.getMemBuffer(INVALID_BUFFER_STRING_REF));
      FakeBufferForRecovery.get().setInvalid();
    }

    return FakeBufferForRecovery.get();
  }

  
  /// \brief As part of recovering from missing or changed content, produce a
  /// fake content cache.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFakeContentCacheForRecovery">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 505,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 507,
   FQN="clang::SourceManager::getFakeContentCacheForRecovery", NM="_ZNK5clang13SourceManager30getFakeContentCacheForRecoveryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager30getFakeContentCacheForRecoveryEv")
  //</editor-fold>
  private /*const*/ SrcMgr.ContentCache /*P*/ getFakeContentCacheForRecovery() /*const*/ {
    if (!FakeContentCacheForRecovery.$bool()) {
      FakeContentCacheForRecovery.$assignMove(llvm.make_unique(new SrcMgr.ContentCache(0)));
      FakeContentCacheForRecovery.$arrow().replaceBuffer(getFakeBufferForRecovery(), 
          /*DoNotFree=*/ true);
    }
    return FakeContentCacheForRecovery.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::loadSLocEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 460,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 464,
   FQN="clang::SourceManager::loadSLocEntry", NM="_ZNK5clang13SourceManager13loadSLocEntryEjPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13loadSLocEntryEjPb")
  //</editor-fold>
  private boolean loadSLocEntry(/*uint*/int Index) /*const*/ {
    assert (!SLocEntryLoaded.$at(Index));
    boolean Error = false;
    if (ExternalSLocEntries.ReadSLocEntry(-((/*static_cast*/int)(Index) + 2))) {
      Error = true;
      // If the file of the SLocEntry changed we could still have loaded it.
      if (!SLocEntryLoaded.$at(Index)) {
        // Try to recover; create a SLocEntry so the rest of clang can handle it.
        LoadedSLocEntryTable.$setFile(Index, 
                                    0, 
                                    SourceLocation.getInvalid(), 
                                    getFakeContentCacheForRecovery(), 
                                    SrcMgr.CharacteristicKind.C_User);
      }
    }
    return Error;
  }

  /// JAVA: use getSLocEntryByID_LoadEntryIfAbsent
  /// \brief Get the entry with the given unwrapped FileID.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getSLocEntryByID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1597,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1589,
   FQN="clang::SourceManager::getSLocEntryByID", NM="_ZNK5clang13SourceManager16getSLocEntryByIDEiPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16getSLocEntryByIDEiPb")
  //</editor-fold>
  private /*const*/ SrcMgr.SLocEntry /*&*/ getSLocEntryByID(int ID) /*const*/ {
    return getSLocEntryByID(ID, 
                  (bool$ptr/*bool P*/ )null);
  }
  private /*const*/ SrcMgr.SLocEntry /*&*/ getSLocEntryByID(int ID, 
                  bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("use getSLocEntryByID_LoadEntryIfAbsent");
//    assert (ID != -1) : "Using FileID sentinel value";
//    if (ID < 0) {
//      return getLoadedSLocEntryByID(ID, Invalid);
//    }
//    return getLocalSLocEntry(((/*static_cast*//*uint*/int)(ID)), Invalid);
  }
  
  
  // JAVA: we want negative index as marker of valid loaded index
  // but (-0) == 0 and positive 0 is used as INVALID_SLOC_ENTRY_INDEX, 
  // so it's important to mask zero input Index
  private static final int LOADED_ZERO_INDEX = 1 << 31;
  
  private static int unmaskLoadedIndex(int maskedIndex) {
    assert maskedIndex < 0;
    return maskedIndex == LOADED_ZERO_INDEX ? 0 : (-maskedIndex);
  }
  
  private static int maskValidLoadedIndex(int rawLoadedIndex) {
    int out = rawLoadedIndex == 0 ? LOADED_ZERO_INDEX : (-rawLoadedIndex);
    assert out < 0 : "we must return negative index " + out;
    return out;
  }
  
  /// returns 0 in case of error (btw, LocalSLocEntryTable[0] is invalid SLocEntry)
  /// positive index for LocalSLocEntryTable (use as LocalSLocEntryTable[Index])
  /// negative index for LoadedSLocEntryTable (use as LoadedSLocEntryTable[unmaskLoadedIndex(Index)])
  //    it also load non local entry if FID is for loaded FileID
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getSLocEntryByID">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1597,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1589,
   FQN="clang::SourceManager::getSLocEntryByID", NM="_ZNK5clang13SourceManager16getSLocEntryByIDEiPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16getSLocEntryByIDEiPb")
  //</editor-fold>
  public int getSLocEntryByID_LoadEntryIfAbsent(/*FileID*/int FID) {
    if (FID == 0 || FID == -1) {
      // invalid
      return INVALID_SLOC_ENTRY_INDEX;
    }

    assert (FID != -1) : "Using FileID sentinel value";
    if (FID > 0) {
      // work with local SLocEntry
      return FID;
    } else {
      // work with loaded SLocEntry
      int TableIdx = (/*static_cast*//*uint*/int)(-FID - 2);
      assert (TableIdx < LoadedSLocEntryTable.size()) : "Invalid index";
      if (!SLocEntryLoaded.$at(TableIdx)) {
        if (loadSLocEntry(TableIdx)) {
          // error
          return INVALID_SLOC_ENTRY_INDEX;
        }
      }
      return maskValidLoadedIndex(TableIdx);
    }
  }
  public int getFileSLocEntryByID_LoadEntryIfAbsent(/*FileID*/int FID) {
    if (FID == 0 || FID == -1) {
      // invalid
      return INVALID_SLOC_ENTRY_INDEX;
    }

    assert (FID != -1) : "Using FileID sentinel value";
    if (FID > 0) {
      // work with local SLocEntry
      return LocalSLocEntryTable.isFile_$at(FID) ? FID : INVALID_SLOC_ENTRY_INDEX;
    } else {
      // work with loaded SLocEntry
      int TableIdx = (/*static_cast*//*uint*/int)(-FID - 2);
      assert (TableIdx < LoadedSLocEntryTable.size()) : "Invalid index";
      if (!SLocEntryLoaded.$at(TableIdx)) {
        if (loadSLocEntry(TableIdx)) {
          return INVALID_SLOC_ENTRY_INDEX;
        }
      }
      return LoadedSLocEntryTable.isFile_$at(TableIdx) ? maskValidLoadedIndex(TableIdx) : INVALID_SLOC_ENTRY_INDEX;
    }
  }  
  public int/*SLocEntryIndex*/ getExpansionSLocEntryByID_LoadEntryIfAbsent(/*FileID*/int FID) {
    if (FID == 0 || FID == -1) {
      // invalid
      return INVALID_SLOC_ENTRY_INDEX;
    }

    assert (FID != -1) : "Using FileID sentinel value";
    if (FID > 0) {
      // work with local SLocEntry
      return LocalSLocEntryTable.isExpansion_$at(FID) ? FID : INVALID_SLOC_ENTRY_INDEX;
    } else {
      // work with loaded SLocEntry
      int TableIdx = (/*static_cast*//*uint*/int)(-FID - 2);
      assert (TableIdx < LoadedSLocEntryTable.size()) : "Invalid index";
      if (!SLocEntryLoaded.$at(TableIdx)) {
        if (loadSLocEntry(TableIdx)) {
          return INVALID_SLOC_ENTRY_INDEX;
        }
      }
      return LoadedSLocEntryTable.isExpansion_$at(TableIdx) ? maskValidLoadedIndex(TableIdx) : INVALID_SLOC_ENTRY_INDEX;
    }
  }  
  
  // 
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getLoadedSLocEntryByID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1605,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1597,
   FQN="clang::SourceManager::getLoadedSLocEntryByID", NM="_ZNK5clang13SourceManager22getLoadedSLocEntryByIDEiPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager22getLoadedSLocEntryByIDEiPb")
  //</editor-fold>
  /*friend*/public /*const SrcMgr.SLocEntry &*//*SLocEntryIndex*/int getLoadedSLocEntryByID(int ID) /*const*/ {
    // TODO: check negative and it's cast, must be correct unsigned!
    return getLoadedSLocEntry((/*static_cast*//*uint*/int)(-ID - 2));
  }  
  
  
  /// Implements the common elements of storing an expansion info struct into
  /// the SLocEntry table and producing a source location that refers to it.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::createExpansionLocImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 611,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 613,
   FQN="clang::SourceManager::createExpansionLocImpl", NM="_ZN5clang13SourceManager22createExpansionLocImplERKNS_6SrcMgr13ExpansionInfoEjij",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager22createExpansionLocImplERKNS_6SrcMgr13ExpansionInfoEjij")
  //</editor-fold>
  private /*SourceLocation*/int createExpansionLocImpl(/*SrcMgr.ExpansionInfo & Info,*/
          /*SourceLocation*/int SpellingLoc, /*SourceLocation*/int ExpansionLocStart, /*SourceLocation*/int ExpansionLocEnd,
          /*uint*/int TokLength, int LoadedID/*= 0*/, /*uint*/int LoadedOffset/*= 0*/) {
    if (LoadedID < 0) {
      assert (LoadedID != -1) : "Loading sentinel FileID";
      /*uint*/int Index = ((/*uint*/int)(-LoadedID)) - 2;
      assert ($less_uint(Index, LoadedSLocEntryTable.size())) : "FileID out of range";
      assert (!SLocEntryLoaded.$at(Index)) : "FileID already loaded";
      LoadedSLocEntryTable.$setExpansion(Index, LoadedOffset, SpellingLoc, ExpansionLocStart, ExpansionLocEnd);
      SLocEntryLoaded.$set(Index, true);
      return SourceLocation.$getMacroLoc(LoadedOffset);
    }
    LastMacroIDLookup = LastMacroIDLookupLocalSLocEntryIndex = LocalSLocEntryTable.size();
    LastMacroIDLookupLocalOffset = NextLocalOffset;
    LocalSLocEntryTable = LocalSLocEntryTable.push_back_Expansion(NextLocalOffset, SpellingLoc, ExpansionLocStart, ExpansionLocEnd);
    // update one-cache values
    updateLocalSLocConstants();
    
    assert ($greater_uint(NextLocalOffset + TokLength + 1, NextLocalOffset) && $lesseq_uint(NextLocalOffset + TokLength + 1, CurrentLoadedOffset)) : "Ran out of source locations!";
    // See createFileID for that +1.
    if (false) NativeTrace.getLogger().log(Level.FINE, "SM {0}:{1} pre-createExpansionLocImpl [{2}]", new Object[]{System.identityHashCode(this), NextLocalOffset, Thread.currentThread().getName()});
    NextLocalOffset += TokLength + 1;
    if (false) NativeTrace.getLogger().log(Level.FINE, "SM {0}:{1} post-createExpansionLocImpl [{2}]", new Object[]{System.identityHashCode(this), NextLocalOffset, Thread.currentThread().getName()});
    return SourceLocation.$getMacroLoc(NextLocalOffset - (TokLength + 1));
  }

  
  /// \brief Return true if the specified FileID contains the
  /// specified SourceLocation offset.  This is a very hot method.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::isOffsetInFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 1619,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 1611,
   FQN="clang::SourceManager::isOffsetInFileID", NM="_ZNK5clang13SourceManager16isOffsetInFileIDENS_6FileIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager16isOffsetInFileIDENS_6FileIDEj")
  //</editor-fold>
  private /*inline*/ boolean isOffsetInFileID(int ID, /*uint*/int SLocOffset) /*const*/ {  
    if (ID >= -1) {
      if (LocalSLocTableIsSliced) {
        return isOffsetInFileIDLocalFromSlicedOffsets(ID, SLocOffset);
      } else {
        return isOffsetInFileIDLocalFromRawOffsets(ID, SLocOffset);
      }
    } else {
      assert (ID < 0);
      int EntryOffset = $getOffset(getLoadedSLocEntryByID(ID));

      // If the entry is after the offset, it can't contain it.
      if ($less_uint(SLocOffset, EntryOffset)) {
        return false;
      }

      // If this is the very last entry then it does.
      if (ID == -2) {
        return true;
      }

      int NextID = ID + 1;
    
//    // If it is the last local entry, then it does if the location is local.
//    if (FID.ID + 1 == ((/*static_cast*/int)(LocalSLocEntryTable.size()))) {
//      return $less_uint(SLocOffset, NextLocalOffset);
//    }
    
      // Otherwise, the entry after it has to not include it. This works for both
      // local and loaded entries.
      assert NextID < 0;
      return $less_uint(SLocOffset, $getOffset(getLoadedSLocEntryByID(NextID)));
    }
  }  

  private boolean isOffsetInFileIDLocalFromRawOffsets(int ID, int SLocOffset) {
    assert (ID == -1) || (ID < local_sloc_entry_size()) : "Invalid index";
    int EntryOffset = (ID == -1) ? LocalSLocEntryTable.offset_$at(INVALID_SLOC_ENTRY_INDEX) : LocalSLocEntryTable.offset_$at(ID);
    // If the entry is after the offset, it can't contain it.
    if (SLocOffset < EntryOffset) {
      return false;
    }
    int NextID = ID + 1;
    assert (NextID <= local_sloc_entry_size()) : "Invalid index";
    // If it is the last local entry, then it does if the location is local.
    if (NextID == local_sloc_entry_size()) {
      return SLocOffset < NextLocalOffset;
    }
    // Otherwise, the entry after it has to not include it. This works for both
    // local and loaded entries.
    return SLocOffset < LocalSLocEntryTable.offset_$at(NextID);
  }
  
  private boolean isOffsetInFileIDLocalFromSlicedOffsets(int ID, int SLocOffset) {
    // JAVA: this is the version of the method isOffsetInFileIDLocal for sliced collection
    // which minimizes access to collection itself
    assert LocalSLocTableIsSliced;
    assert (ID == -1) || (ID < local_sloc_entry_size()) : "Invalid index";
    int[] offsets;
    int index;
    int slice;
    int EntryOffset;
    if (ID == LastFileIDLookupLocalSLocEntryIndex) {
      slice = LastFileIDLookupLocalSlice;
      offsets = LastFileIDLookupLocalSliceArray;
      index = LastFileIDLookupLocalIndexInSlice;
      EntryOffset = LastFileIDLookupLocalOffset;
      assert EntryOffset == offsets[index] : EntryOffset + " vs. " + offsets[index];
    } else if (ID == LastMacroIDLookupLocalSLocEntryIndex) {
      slice = LastMacroIDLookupLocalSlice;
      offsets = LastMacroIDLookupLocalSliceArray;
      index = LastMacroIDLookupLocalIndexInSlice;
      EntryOffset = LastMacroIDLookupLocalOffset;
      assert EntryOffset == SrcMgr.SLocEntry.toOffset(offsets[index]) : EntryOffset + " vs. " + SrcMgr.SLocEntry.toOffset(offsets[index]);
    } else if (ID == -1) {
      slice = 0;
      offsets = LocalSLocEntryTable.$OffsetsSliceByIndex(0);
      index = 0;
      EntryOffset = 0;
      assert EntryOffset == SrcMgr.SLocEntry.toOffset(offsets[index]);
    } else {
      slice = ID / LocalSliceSize;
      index = ID & LocalSliceMaskForIndex;
      if (slice == LastFileIDLookupLocalSlice) {
        offsets = LastFileIDLookupLocalSliceArray;
      } else if (slice == LastMacroIDLookupLocalSlice) {
        offsets = LastMacroIDLookupLocalSliceArray;
      } else {
        offsets = LocalSLocEntryTable.$OffsetsSliceByIndex(slice);
      }
      EntryOffset = SrcMgr.SLocEntry.toOffset(offsets[index]);
    }
    // If the entry is after the offset, it can't contain it.
    if (SLocOffset < EntryOffset) {
      return false;
    }
    int NextID = ID + 1;
    assert (NextID <= local_sloc_entry_size()) : "Invalid index";
    // If it is the last local entry, then it does if the location is local.
    if (NextID == local_sloc_entry_size()) {
      return SLocOffset < NextLocalOffset;
    }    
    int nextEntryOffset;
    if (++index < LocalSliceSize) {
      nextEntryOffset = offsets[index];
    } else {
      nextEntryOffset = LocalSLocEntryTable.$OffsetsSliceByIndex(slice+1)[0];
    }
    nextEntryOffset = SrcMgr.SLocEntry.toOffset(nextEntryOffset);
    
    // Otherwise, the entry after it has to not include it. This works for both
    // local and loaded entries.
    return SLocOffset < nextEntryOffset;
  }
  
  /// \brief Returns the previous in-order FileID or an invalid FileID if there
  /// is no previous one.
  
  /// \brief Returns the previous in-order FileID or an invalid FileID if there
  /// is no previous one.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getPreviousFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 517,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 519,
   FQN="clang::SourceManager::getPreviousFileID", NM="_ZNK5clang13SourceManager17getPreviousFileIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager17getPreviousFileIDENS_6FileIDE")
  //</editor-fold>
  private /*FileID*/int getPreviousFileID(/*FileID*/int FID) /*const*/ {
    if (FileID.isInvalid(FID)) {
      return FileID.getInvalidID();
    }
    
    int ID = FID;
    if (ID == -1) {
      return FileID.getInvalidID();
    }
    if (ID > 0) {
      if (ID - 1 == 0) {
        return FileID.getInvalidID();
      }
    } else if ($greatereq_uint(((/*uint*/int)(-(ID - 1) - 2)), LoadedSLocEntryTable.size())) {
      return FileID.getInvalidID();
    }
    
    return (ID - 1);
  }

  
  /// \brief Returns the next in-order FileID or an invalid FileID if there is
  /// no next one.
  
  /// \brief Returns the next in-order FileID or an invalid FileID if there is
  /// no next one.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getNextFileID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 537,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 539,
   FQN="clang::SourceManager::getNextFileID", NM="_ZNK5clang13SourceManager13getNextFileIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getNextFileIDENS_6FileIDE")
  //</editor-fold>
  private /*FileID*/int getNextFileID(/*FileID*/int FID) /*const*/ {
    if (FileID.isInvalid(FID)) {
      return FileID.getInvalidID();
    }
    
    int ID = FID;
    if (ID > 0) {
      if ($greatereq_uint(((/*uint*/int)(ID + 1)), local_sloc_entry_size())) {
        return FileID.getInvalidID();
      }
    } else if (ID + 1 >= -1) {
      return FileID.getInvalidID();
    }
    
    return (ID + 1);
  }

  
  /// \brief Create a new fileID for the specified ContentCache and
  /// include position.
  ///
  /// This works regardless of whether the ContentCache corresponds to a
  /// file or some other input source.
  
  //===----------------------------------------------------------------------===//
  // Methods to create new FileID's and macro expansions.
  //===----------------------------------------------------------------------===//
  
  /// createFileID - Create a new FileID for the specified ContentCache and
  /// include position.  This works regardless of whether the ContentCache
  /// corresponds to a file or some other input source.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::createFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 559,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 561,
   FQN="clang::SourceManager::createFileID", NM="_ZN5clang13SourceManager12createFileIDEPKNS_6SrcMgr12ContentCacheENS_14SourceLocationENS1_18CharacteristicKindEij",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager12createFileIDEPKNS_6SrcMgr12ContentCacheENS_14SourceLocationENS1_18CharacteristicKindEij")
  //</editor-fold>
  private /*FileID*/int createFileID(/*const*/SrcMgr.ContentCache/*P*/ File, 
          /*SourceLocation*/int IncludePos, 
          SrcMgr.CharacteristicKind FileCharacter, 
          int LoadedID, /*uint*/int LoadedOffset) {
    if (LoadedID < 0) {
      assert (LoadedID != -1) : "Loading sentinel FileID";
      /*uint*/int Index = ((/*uint*/int)(-LoadedID)) - 2;
      assert ($less_uint(Index, LoadedSLocEntryTable.size())) : "FileID out of range";
      assert (!SLocEntryLoaded.$at(Index)) : "FileID already loaded";
      LoadedSLocEntryTable.$setFile(Index, LoadedOffset, IncludePos, File, FileCharacter);
      SLocEntryLoaded.$set(Index, true);
      return LoadedID;
    }
    // Set LastFileIDLookup to the newly created file.  The next getFileID call is
    // almost guaranteed to be from that file.
    LastFileIDLookup = LastFileIDLookupLocalSLocEntryIndex = LocalSLocEntryTable.size();
    LastFileIDLookupLocalOffset = NextLocalOffset;
    LocalSLocEntryTable = LocalSLocEntryTable.push_back_File(NextLocalOffset, 
                                                        IncludePos, File, 
                                                        FileCharacter);    
    /*uint*/int FileSize = File.getSize();
    assert ($greater_uint(NextLocalOffset + FileSize + 1, NextLocalOffset) && $lesseq_uint(NextLocalOffset + FileSize + 1, CurrentLoadedOffset)) : "Ran out of source locations!";
    // We do a +1 here because we want a SourceLocation that means "the end of the
    // file", e.g. for the "no newline at the end of the file" diagnostic.
    if (false) NativeTrace.getLogger().log(Level.FINE, "SM {0}:{1} pre-createFileID [{2}]", new Object[]{System.identityHashCode(this), NextLocalOffset, Thread.currentThread().getName()});
    NextLocalOffset += FileSize + 1;
    if (false) NativeTrace.getLogger().log(Level.FINE, "SM {0}:{1} post-createFileID [{2}] {3}:\n{4}", new Object[]{System.identityHashCode(this), NextLocalOffset, Thread.currentThread().getName(), LastFileIDLookup, File.ContentsEntry});
        
    // update one-cache values
    updateLocalSLocConstants();
    
    // Set LastFileIDLookup to the newly created file.  The next getFileID call is
    // almost guaranteed to be from that file.    
    /*FileID*/int FID = LastFileIDLookup;
    return FID;
  }

  
  
  /// getOrCreateContentCache - Create or return a cached ContentCache for the
  /// specified file.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getOrCreateContentCache">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 414,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 419,
   FQN = "clang::SourceManager::getOrCreateContentCache", NM = "_ZN5clang13SourceManager23getOrCreateContentCacheEPKNS_9FileEntryEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager23getOrCreateContentCacheEPKNS_9FileEntryEb")
  //</editor-fold>
  /*friend*/public /*const*/SrcMgr.ContentCache/*P*/ getOrCreateContentCache(/*const*/FileEntry /*P*/ FileEnt) {
    return getOrCreateContentCache(FileEnt, false);
  }
  /*friend*/public /*const*/SrcMgr.ContentCache/*P*/ getOrCreateContentCache(/*const*/FileEntry /*P*/ FileEnt, boolean isSystemFile/*= false*/) {
    assert ((FileEnt != null)) : "Didn't specify a file entry to use?";
    assert (FileInfos.size() + MemBufferInfos.size()) == AllContentCaches.size() : FileInfos.size() + " + " + MemBufferInfos.size() + " vs. " + AllContentCaches.size();
    // Do we already have information about this file?
    pair<FileEntry,SrcMgr.ContentCache>/*P*/ /*&*/ Entry = FileInfos.FindAndConstruct(FileEnt);
    if ((Entry.second != null)) {
      assert getContentCacheByCacheIndex(Entry.second.$index()) == Entry.second;
      return Entry.second;
    }
    
    // Nope, create a new Cache entry.  Make sure it is at least 8-byte aligned
    // so that FileInfo can use the low 3 bits of the pointer for its own
    // nefarious purposes.
    if (false) {
      /*uint*/int EntryAlign = AlignOf.<SrcMgr.ContentCache>Unnamed_enum.Alignment$Native;
      EntryAlign = std.max(8/*U*/, EntryAlign);
      Entry.second = (ContentCacheAlloc.Allocate_T(SrcMgr.ContentCache.class, 1, EntryAlign).$star());
    }
    
    int NextContentCacheIndex = AllContentCaches.size();
    if (OverriddenFilesInfo.$bool()) {
      // If the file contents are overridden with contents from another file,
      // pass that file to ContentCache.
      DenseMapIterator</*const*/FileEntry /*P*/ , /*const*/FileEntry /*P*/ > overI = OverriddenFilesInfo.$arrow().OverriddenFiles.find(FileEnt);
      if (overI.$eq(/*NO_ITER_COPY*/OverriddenFilesInfo.$arrow().OverriddenFiles.end())) {
        Entry.second = (new /*(Entry)*/ SrcMgr.ContentCache(NextContentCacheIndex, FileEnt));
      } else {
        Entry.second = (new /*(Entry)*/ SrcMgr.ContentCache(NextContentCacheIndex, OverridenFilesKeepOriginalName ? FileEnt : overI.$star().second, overI.$star().second));
      }
    } else {
      Entry.second = (new /*(Entry)*/ SrcMgr.ContentCache(NextContentCacheIndex, FileEnt));
    }
    AllContentCaches.push_back(Entry.second);
    Entry.second.IsSystemFile = isSystemFile;
    Entry.second.IsTransient = FilesAreTransient;
    assert getContentCacheByCacheIndex(Entry.second.$index()) == Entry.second;
    assert (FileInfos.size() + MemBufferInfos.size()) == AllContentCaches.size() : FileInfos.size() + " + " + MemBufferInfos.size() + " vs. " + AllContentCaches.size();
    return Entry.second;
  }

  
  /// \brief Create a new ContentCache for the specified  memory buffer.
  
  /// createMemBufferContentCache - Create a new ContentCache for the specified
  ///  memory buffer.  This does no caching.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::createMemBufferContentCache">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 450,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 454,
   FQN="clang::SourceManager::createMemBufferContentCache", NM="_ZN5clang13SourceManager27createMemBufferContentCacheESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13SourceManager27createMemBufferContentCacheESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EE")
  //</editor-fold>
  private /*const*/SrcMgr.ContentCache/*P*/ createMemBufferContentCache(std.unique_ptr<MemoryBuffer> Buffer) {
    assert (FileInfos.size() + MemBufferInfos.size()) == AllContentCaches.size() : FileInfos.size() + " + " + MemBufferInfos.size() + " vs. " + AllContentCaches.size();
    /// use negatives for memory buffers starting from -1
    int NextMemoryBufferContextCacheIndex = this.AllContentCaches.size();
    // Add a new ContentCache to the MemBufferInfos list and return it.
    SrcMgr.ContentCache Entry = new /*(Entry)*/ SrcMgr.ContentCache(NextMemoryBufferContextCacheIndex);
    MemBufferInfos.push_back(Entry);
    AllContentCaches.push_back(Entry);
    Entry.setBuffer(Buffer);// JAVA: reuse unique_ptr
    assert getContentCacheByCacheIndex(Entry.$index()) == Entry;
    assert (FileInfos.size() + MemBufferInfos.size()) == AllContentCaches.size() : FileInfos.size() + " + " + MemBufferInfos.size() + " vs. " + AllContentCaches.size();
    return Entry;
  }

  
  
  //===----------------------------------------------------------------------===//
  // SourceLocation manipulation methods.
  //===----------------------------------------------------------------------===//
  
  /// \brief Return the FileID for a SourceLocation.
  ///
  /// This is the cache-miss path of getFileID. Not as hot as that function, but
  /// still very important. It is responsible for finding the entry in the
  /// SLocEntry tables that contains the specified location.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileIDSlow">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 711,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 708,
   FQN="clang::SourceManager::getFileIDSlow", NM="_ZNK5clang13SourceManager13getFileIDSlowEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager13getFileIDSlowEj")
  //</editor-fold>
  private /*FileID*/int getFileIDSlow(/*uint*/int SLocOffset) /*const*/ {
    if (SLocOffset == 0) {
      return FileID.getInvalidID();
    }
    
    // Now it is time to search for the correct file. See where the SLocOffset
    // sits in the global view and consult local or loaded buffers for it.
    if ($less_uint(SLocOffset, NextLocalOffset)) {
      return getFileIDLocal(SLocOffset);
    }
    return getFileIDLoaded(SLocOffset);
  }

  
  /// \brief Return the FileID for a SourceLocation with a low offset.
  ///
  /// This function knows that the SourceLocation is in a local buffer, not a
  /// loaded one.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileIDLocal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 726,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 723,
   FQN="clang::SourceManager::getFileIDLocal", NM="_ZNK5clang13SourceManager14getFileIDLocalEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager14getFileIDLocalEj")
  //</editor-fold>
  private /*FileID*/int getFileIDLocal(/*uint*/int SLocOffset) /*const*/ {
    if (LocalSLocTableIsSliced) {
      return getFileIDLocalFromSlicedOffsets(SLocOffset);
    } else {
      return getFileIDLocalFromRawOffsets(SLocOffset);
    }
  }
  
  private /*FileID*/int getFileIDLocalFromRawOffsets(/*uint*/int SLocOffset) /*const*/ {
    // JAVA: it was rewritten to faster performing version using raw data
    assert ($less_uint(SLocOffset, NextLocalOffset)) : "Bad function choice";
    assert (SLocOffset >= 0) : "Must be non negative";
    
    // After the first and second level caches, I see two common sorts of
    // behavior: 1) a lot of searched FileID's are "near" the cached file
    // location or are "near" the cached expansion location. 2) others are just
    // completely random and may be a very long way away.
    //
    // To handle this, we do a linear search for up to 8 steps to catch #1 quickly
    // then we fall back to a less cache efficient, but more scalable, binary
    // search to find the location.
        
    // See if this is near the file point - worst case we start scanning from the
    // most newly created FileID.
    int I;
    int SLocTableSize = local_sloc_entry_size();
    if (LastFileIDLookup < 0 || (LastFileIDLookupLocalOffset < SLocOffset)) {
      if (!USE_LAST_MACRO_ID || ((LastMacroIDLookup < 0) || (LastMacroIDLookupLocalOffset < SLocOffset))) {
        // Neither loc prunes our search.
        I = SLocTableSize;
      } else {
        assert LastMacroIDLookup == LastMacroIDLookupLocalSLocEntryIndex : LastMacroIDLookup + " vs. " + LastMacroIDLookupLocalSLocEntryIndex;
        assert LastMacroIDLookupLocalOffset == LocalSLocEntryTable.offset_$at(LastMacroIDLookupLocalSLocEntryIndex);
        // Perhaps it is near the file point.
        I = LastMacroIDLookupLocalSLocEntryIndex;
      }
    } else {
      assert LastFileIDLookup == LastFileIDLookupLocalSLocEntryIndex : LastFileIDLookup + " vs " + LastFileIDLookupLocalSLocEntryIndex;
      assert LastFileIDLookupLocalOffset == LocalSLocEntryTable.offset_$at(LastFileIDLookupLocalSLocEntryIndex);
      // choose the best from File or Macro
      if (USE_LAST_MACRO_ID && (LastMacroIDLookupLocalOffset < LastFileIDLookupLocalOffset) && (SLocOffset < LastMacroIDLookupLocalOffset)) {
        // macro is closer
        // Perhaps it is near the macro point.
        I = LastMacroIDLookupLocalSLocEntryIndex;
      } else {
        // Perhaps it is near the file point.
        I = LastFileIDLookupLocalSLocEntryIndex;
      }
    }
    // Find the FileID that contains this.  "I" is an iterator that points to a
    // FileID whose offset is known to be larger than SLocOffset.
    /*uint*/int NumProbes = 0;
    while (true) {
      --I;
      int Raw_Offset_at_I = LocalSLocEntryTable.rawOffset_$at(I);
      int Offset_at_I = SrcMgr.SLocEntry.toOffset(Raw_Offset_at_I);
      if (Offset_at_I <= SLocOffset) {
        /*FileID*/int Res = I;
        
        // If this isn't an expansion, remember it.  We have good locality across
        // FileID lookups.
        if (SrcMgr.SLocEntry.isNotExpansion(Raw_Offset_at_I)) {
          updateLastIDForFileLookup(true, Res, Offset_at_I, 0, null, I);
          NumLinearScans += NumProbes + 1;
        } else {
          updateLastIDForMacroLookup(true, Res, Offset_at_I, 0, null, I);
          NumLinearMacroScans += NumProbes + 1;
        }
        return Res;
      }
      if (++NumProbes == 8) {
        break;
      }
    }
    
    // Convert "I" back into an index.  We know that it is an entry whose index is
    // larger than the offset we are looking for.
    /*uint*/int GreaterIndex = I;
    // LessIndex - This is the lower bound of the range that we're searching.
    // We know that the offset corresponding to the FileID is is less than
    // SLocOffset.
    /*uint*/int LessIndex = 0;
    NumProbes = 0;
    while (true) {
      /*uint*/int MiddleIndex = (GreaterIndex - LessIndex) / 2 + LessIndex;
      /*uint*/int Raw_Offset_at_Mid = LocalSLocEntryTable.rawOffset_$at(MiddleIndex);
      /*uint*/int Offset_at_Mid = SrcMgr.SLocEntry.toOffset(Raw_Offset_at_Mid);

      ++NumProbes;
      
      // If the offset of the midpoint is too large, chop the high side of the
      // range to the midpoint.
      if (Offset_at_Mid > SLocOffset) {
        GreaterIndex = MiddleIndex;
      } else {
        // If the middle index contains the value, succeed and return.
        int FID = MiddleIndex+1;
        int nextOffset;
        if (FID == SLocTableSize) {
          nextOffset = (int)NextLocalOffset;
        } else {
          nextOffset = LocalSLocEntryTable.offset_$at(FID);
        }
        if (SLocOffset < nextOffset) {
          /*FileID*/int Res = MiddleIndex;

          // If this isn't a macro expansion, remember it.  We have good locality
          // across FileID lookups.
          if (SrcMgr.SLocEntry.isNotExpansion(Raw_Offset_at_Mid)) {
            updateLastIDForFileLookup(true, Res, Offset_at_Mid, 0, null, MiddleIndex);
            NumBinaryProbes += NumProbes;
          } else {           
            updateLastIDForMacroLookup(true, Res, Offset_at_Mid, 0, null, MiddleIndex);
            NumBinaryMacroProbes += NumProbes;
          }
          return Res;
        }

        // Otherwise, move the low-side up to the middle index.
        LessIndex = MiddleIndex;
      }
    }
  }
  
  private /*FileID*/int getFileIDLocal_UseZeroSlice(/*uint*/int SLocOffset) /*const*/ {
    // JAVA: it was rewritten to faster performing version using raw data
    assert (SLocOffset < NextLocalOffset) : "Bad function choice";
    assert (SLocOffset >= 0) : "Must be non negative";
    // See if this is near the file point - worst case we start scanning from the
    // most newly created FileID.
    int I;
    int SLocTableSize = local_sloc_entry_size();
    if (LastFileIDLookup < 0) {
      // Neither loc prunes our search.
      I = SLocTableSize;      
    } else {
      int offset_$at = LocalSLocEntryTable.offset_$at(LastFileIDLookup);
      assert (offset_$at != SLocOffset) : "they can not be equal, see getFileID impl";
      if (offset_$at < SLocOffset) {
        // Neither loc prunes our search.
        I = SLocTableSize;
      } else {
        // Perhaps it is near the file point.
        I = LastFileIDLookup;
      }
    }
    int[] offsets = LocalSLocEntryTable.$OffsetsSliceByIndex(0);
    return lookupIndexInOffsetsRangeArrayImpl(SLocOffset, offsets, I, 0, SLocTableSize, 0, true);
  }
  
  private /*FileID*/int getFileIDLocalFromSlicedOffsets(/*uint*/int SLocOffset) /*const*/ {
    assert LocalSLocTableIsSliced;
    // JAVA: it was rewritten to faster performing version using raw data
    assert (SLocOffset < NextLocalOffset) : "Bad function choice";
    assert (SLocOffset >= 0) : "Must be non negative";
    // See if this is near the file point - worst case we start scanning from the
    // most newly created FileID.
    int I;
    int Slice_for_I;
    int[] $OffsetsSlice;
    assert LastFileIDLookupLocalSliceArray == LocalSLocEntryTable.$OffsetsSliceByIndex(LastFileIDLookupLocalSlice);
    assert LastMacroIDLookupLocalSliceArray == LocalSLocEntryTable.$OffsetsSliceByIndex(LastMacroIDLookupLocalSlice);
    final int MaxSlicesIndex = LocalMaxSliceIndex;
    assert LocalSLocEntryTable.$OffsetsMaxSliceIndex() == MaxSlicesIndex;
    
    final int sliceSize = LocalSliceSize;
    final int IndexInSliceMask = LocalSliceMaskForIndex;
    assert LastFileIDLookupLocalSliceArray.length == sliceSize;
//    assert (sliceSize - 1) == IndexInSliceMask;
    
    // define masked FID index to stop based on slice index
    // the last allocated FID
    int MaxIndex = MaxIndexInLastLocalSlice;
    assert MaxIndex == (((local_sloc_entry_size - 1) & LocalSliceMaskForIndex) + 1);
    // is last ID was from Loaded
    if (LastFileIDLookup < 0) {
      // Neither loc prunes our search.
      // start from the end
      Slice_for_I = MaxSlicesIndex;
      I = MaxIndex;
      $OffsetsSlice = LocalSLocEntryTable.$OffsetsSliceByIndex(Slice_for_I);
    } else {
      assert LastFileIDLookupLocalOffset == LastFileIDLookupLocalSliceArray[LastFileIDLookupLocalIndexInSlice];
      assert LastFileIDLookupLocalOffset != SLocOffset : SLocOffset + " must be checked before getFileIDSlow ";
      assert LastMacroIDLookupLocalOffset != SLocOffset : SLocOffset + " must be checked before getFileIDSlow ";
      assert LastFileIDLookupLocalOffset == SrcMgr.SLocEntry.toOffset(LastFileIDLookupLocalOffset) : "FileID has te same offset as the raw value";
      if (LastFileIDLookupLocalOffset < SLocOffset) {
        if (!USE_LAST_MACRO_ID || ((LastMacroIDLookup < 0) || (LastMacroIDLookupLocalOffset < SLocOffset))) {
          // Neither loc prunes our search.
          I = MaxIndex;
          Slice_for_I = MaxSlicesIndex;
          $OffsetsSlice = LocalSLocEntryTable.$OffsetsSliceByIndex(Slice_for_I);
        } else {
          // Perhaps it is near the macro point.
          Slice_for_I = LastMacroIDLookupLocalSlice;
          I = LastMacroIDLookupLocalIndexInSlice;
          $OffsetsSlice = LastMacroIDLookupLocalSliceArray;
          if (Slice_for_I < MaxSlicesIndex) {
            MaxIndex = sliceSize;
          }
        }
      } else {
        // choose the best from File or Macro
        if (USE_LAST_MACRO_ID && (LastMacroIDLookupLocalOffset < LastFileIDLookupLocalOffset) && (SLocOffset < LastMacroIDLookupLocalOffset)) {
          // macro is closer
          // Perhaps it is near the macro point.
          Slice_for_I = LastMacroIDLookupLocalSlice;
          I = LastMacroIDLookupLocalIndexInSlice;
          $OffsetsSlice = LastMacroIDLookupLocalSliceArray;
        } else {
          $OffsetsSlice = LastFileIDLookupLocalSliceArray;
          // Perhaps it is near the file point.
          I = LastFileIDLookupLocalIndexInSlice;
          Slice_for_I = LastFileIDLookupLocalSlice;
        }
        if (Slice_for_I < MaxSlicesIndex) {
          MaxIndex = sliceSize;
        }
      }      
    }

    // get candidate slice array to start
    int SliceStartAbsoluteIndex = 0;
    // map index to slice
    assert (I & IndexInSliceMask) == I || (I == sliceSize) : I + " vs " + sliceSize;
    // Find the slice that contains this. Slice_at_I is an iterator that points to a
    // slice whose offsets are known to be larger than SLocOffset.
    if (Slice_for_I > 0) {
      // linear search of slice
      /*uint*/int NumProbes = 0;
      boolean found = false;
      while (true) {
        if (SrcMgr.SLocEntry.toOffset($OffsetsSlice[0]) <= SLocOffset) {
          SliceStartAbsoluteIndex = Slice_for_I*sliceSize;
          if (NumProbes == 0) {
            NumImmediateSliceScans++;
          } else {
            NumLinearSliceScans += NumProbes + 1;
          }
          found = true;
          break;
        }
        if (NumProbes++ == 8) {
          break;
        }
        // go to previous slice
        assert Slice_for_I > 0;
        assert Slice_for_I <= MaxSlicesIndex; 
        --Slice_for_I;
        $OffsetsSlice = LocalSLocEntryTable.$OffsetsSliceByIndex(Slice_for_I);
        // index will be the biggest one
        I = sliceSize;
        // stop at the last entry in slice
        MaxIndex = sliceSize;
      }
      if (!found) {
        // binary search
        // Convert "I" back into an index.  We know that it is an entry whose index is
        // larger than the offset we are looking for.
        /*uint*/int GreaterSliceIndex = Slice_for_I;
        // LessIndex - This is the lower bound of the range that we're searching.
        // We know that the offset corresponding to the FileID is is less than
        // SLocOffset.
        /*uint*/int LessSliceIndex = 0;
        NumProbes = 0;        
        while (true) {
          assert GreaterSliceIndex >= 0;
          assert LessSliceIndex >= 0;
          assert GreaterSliceIndex >= LessSliceIndex;
          assert GreaterSliceIndex < MaxSlicesIndex : GreaterSliceIndex + " vs. " + MaxSlicesIndex;
          Slice_for_I = (GreaterSliceIndex - LessSliceIndex) / 2 + LessSliceIndex;
          $OffsetsSlice = LocalSLocEntryTable.$OffsetsSliceByIndex(Slice_for_I);
          int FirstOffset_At_MidSlice = SrcMgr.SLocEntry.toOffset($OffsetsSlice[0]);
          ++NumProbes;
          
          if (FirstOffset_At_MidSlice > SLocOffset) {
            GreaterSliceIndex = Slice_for_I;
          } else {
            // If the middle index contains the value, succeed and return.
            int NextSlice = Slice_for_I+1;
            int nextOffset;
            if (NextSlice == MaxSlicesIndex) {
              nextOffset = (int)NextLocalOffset;
            } else {
              nextOffset = SrcMgr.SLocEntry.toOffset(LocalSLocEntryTable.$OffsetsSliceByIndex(NextSlice)[0]);
            }
            if (SLocOffset < nextOffset) {
              SliceStartAbsoluteIndex = Slice_for_I*sliceSize;
              NumBinarySliceProbes += NumProbes;
              break;
            }
            // Otherwise, move the low-side up to the middle index.
            LessSliceIndex = Slice_for_I;
          }
        }
        // index will be the biggest one
        assert I == sliceSize : I + " vs. " + sliceSize;
        assert MaxIndex == sliceSize : MaxIndex + " vs. " + sliceSize;
      }
    }
    return lookupIndexInOffsetsRangeArrayImpl(SLocOffset, $OffsetsSlice, I, Slice_for_I, MaxIndex, SliceStartAbsoluteIndex, true);
  }
  
  private int lookupIndexInOffsetsRangeArrayImpl(/*uint*/int SLocOffset, int[] offsets, 
          int I, int Slice_for_I, int MaxIndex,
          int SliceStartAbsoluteIndex, 
          boolean forLocalTable) {
    assert SrcMgr.SLocEntry.toOffset(offsets[0]) <= SLocOffset;
    assert MaxIndex <= offsets.length;
    // Find the FileID that contains this.  "I" is an iterator that points to a
    // FileID whose offset is known to be larger than SLocOffset.
    /*uint*/int NumProbes = 0;
    while (true) {
      assert I > 0;
      assert I <= MaxIndex;
      --I;
      int Raw_Offset_at_I = offsets[I];
      int Offset_at_I = SrcMgr.SLocEntry.toOffset(Raw_Offset_at_I);
      if (Offset_at_I <= SLocOffset) {
        /*FileID*/int Res = I + SliceStartAbsoluteIndex;

        // If this isn't an expansion, remember it.  We have good locality across
        // FileID lookups.
        if (SrcMgr.SLocEntry.isNotExpansion(Raw_Offset_at_I)) {
          updateLastIDForFileLookup(forLocalTable, Res, Offset_at_I, Slice_for_I, offsets, I);
          NumLinearScans += NumProbes + 1;
        } else {   
          updateLastIDForMacroLookup(forLocalTable, Res, Offset_at_I, Slice_for_I, offsets, I);
          NumLinearMacroScans += NumProbes + 1;
        }
        return Res;
      }
      if (++NumProbes == 8) {
        break;
      }
    }
    // Convert "I" back into an index.  We know that it is an entry whose index is
    // larger than the offset we are looking for.
    /*uint*/int GreaterIndex = I;
    // LessIndex - This is the lower bound of the range that we're searching.
    // We know that the offset corresponding to the FileID is is less than
    // SLocOffset.
    /*uint*/int LessIndex = 0;
    NumProbes = 0;
    while (true) {
      assert GreaterIndex >= 0;
      assert LessIndex >= 0;
      assert GreaterIndex >= LessIndex;
      assert GreaterIndex < MaxIndex : GreaterIndex + " vs. " + MaxIndex;
      /*uint*/int MiddleIndex = (GreaterIndex - LessIndex) / 2 + LessIndex;
      /*uint*/int Raw_Offset_at_Mid = offsets[MiddleIndex];
      /*uint*/int Offset_at_Mid = SrcMgr.SLocEntry.toOffset(Raw_Offset_at_Mid);
      ++NumProbes;
      
      // If the offset of the midpoint is too large, chop the high side of the
      // range to the midpoint.
      if (Offset_at_Mid > SLocOffset) {
        GreaterIndex = MiddleIndex;
      } else {
        // If the middle index contains the value, succeed and return.
        int FID = MiddleIndex+1;
        int nextOffset;
        if (FID == MaxIndex) {
          // we can use NextLocalOffset for any slice as the biggest value to stop
          nextOffset = (int)NextLocalOffset;
        } else {
          nextOffset = SrcMgr.SLocEntry.toOffset(offsets[FID]);
        }
        if (SLocOffset < nextOffset) {
          /*FileID*/int Res = MiddleIndex + SliceStartAbsoluteIndex;

          // If this isn't a macro expansion, remember it.  We have good locality
          // across FileID lookups.
          if (SrcMgr.SLocEntry.isNotExpansion(Raw_Offset_at_Mid)) {
            updateLastIDForFileLookup(forLocalTable, Res, Offset_at_Mid, Slice_for_I, offsets, MiddleIndex);
            NumBinaryProbes += NumProbes;
          } else {           
            updateLastIDForMacroLookup(forLocalTable, Res, Offset_at_Mid, Slice_for_I, offsets, MiddleIndex);
            NumBinaryMacroProbes += NumProbes;
          }
          return Res;
        }

        // Otherwise, move the low-side up to the middle index.
        LessIndex = MiddleIndex;
      }
    }    
  }

  private void updateLastIDForFileLookup(boolean LocalTable, int lastFileID, int lastFileIDOffset, int Slice, int[] sliceArray, int IndexInSlice) {
    LastFileIDLookup = lastFileID;
    if (LocalTable) {
      // update local cached values
      LastFileIDLookupLocalSLocEntryIndex = lastFileID; // the same as FileID
      LastFileIDLookupLocalOffset = lastFileIDOffset;
      LastFileIDLookupLocalSlice = Slice;
      LastFileIDLookupLocalSliceArray = sliceArray;
      LastFileIDLookupLocalIndexInSlice = IndexInSlice;
    } else {
//      LastFileIDLookupLoadedSLocEntryIndex = (lastFileID + 2); // FileID + 2
//      LastFileIDLookupLoadedOffset = lastFileIDOffset;
      LastFileIDLookupLoadedSlice = Slice;
//      LastFileIDLookupLoadedSliceArray = sliceArray;
//      LastFileIDLookupLoadedIndexInSlice = IndexInSlice;
    }
  }
  
  private void updateLastIDForMacroLookup(boolean LocalTable, int lastMacroID, int lastMacroIDOffset, int Slice, int[] sliceArray, int IndexInSlice) {
    LastMacroIDLookup = lastMacroID;
    if (LocalTable) {
      // update local cached values
      LastMacroIDLookupLocalSLocEntryIndex = lastMacroID; // the same as FileID
      LastMacroIDLookupLocalOffset = lastMacroIDOffset;
      LastMacroIDLookupLocalSlice = Slice;
      LastMacroIDLookupLocalSliceArray = sliceArray;
      LastMacroIDLookupLocalIndexInSlice = IndexInSlice;
    } else {
//      LastMacroIDLookupLoadedSLocEntryIndex = (lastMacroID + 2); // FileID + 2
//      LastMacroIDLookupLoadedOffset = lastMacroIDOffset;
      LastMacroIDLookupLoadedSlice = Slice;
//      LastMacroIDLookupLoadedSliceArray = sliceArray;
//      LastMacroIDLookupLoadedIndexInSlice = IndexInSlice;
    }
  }

  /// \brief Return the FileID for a SourceLocation with a high offset.
  ///
  /// This function knows that the SourceLocation is in a loaded buffer, not a
  /// local one.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileIDLoaded">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 817,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 814,
   FQN="clang::SourceManager::getFileIDLoaded", NM="_ZNK5clang13SourceManager15getFileIDLoadedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager15getFileIDLoadedEj")
  //</editor-fold>
  private /*FileID*/int getFileIDLoaded(/*uint*/int SLocOffset) /*const*/ {
    // Sanity checking, otherwise a bug may lead to hanging in release build.
    if ($less_uint(SLocOffset, CurrentLoadedOffset)) {
      NativeTrace.assertTrueInConsole(false, "Invalid SLocOffset or bad function choice ", SLocOffset);
      return FileID.getInvalidID();
    }
    
    // Essentially the same as the local case, but the loaded array is sorted
    // in the other direction.
    
    // First do a linear scan from the last lookup position, if possible.
    /*uint*/int I;
    int LastID = LastFileIDLookup;
    if (LastID >= 0 || $less_uint($getOffset(getLoadedSLocEntryByID(LastID)), SLocOffset)) {
      I = 0;
    } else {
      I = (-LastID - 2) + 1;
    }
    assert I >= 0;
    /*uint*/int NumProbes;
    for (NumProbes = 0; NumProbes < 8; ++NumProbes , ++I) {
      // Make sure the entry is loaded!
      /*const SrcMgr.SLocEntry &*//*SLocEntryIndex*/int E = getLoadedSLocEntry(I);
      assert E != INVALID_SLOC_ENTRY_INDEX;
      int Offset_at_I = $getOffset(E);
      if ($lesseq_uint(Offset_at_I, SLocOffset)) {
        /*FileID*/int Res = (-((int)(I)) - 2);
        if ($isFile(E)) {
          updateLastIDForFileLookup(false, Res, Offset_at_I, 0, null, I);
          NumLinearScans += NumProbes + 1;
        } else {
          updateLastIDForMacroLookup(false, Res, Offset_at_I, 0, null, I);
          NumLinearMacroScans += NumProbes + 1;
        }
        assert Res < 0 : "Expected negative FileID for loaded: " + Res;
        return Res;
      }
    }
    
    // Linear scan failed. Do the binary search. Note the reverse sorting of the
    // table: GreaterIndex is the one where the offset is greater, which is
    // actually a lower index!
    /*uint*/int GreaterIndex = I;
    /*uint*/int LessIndex = LoadedSLocEntryTable.size();
    NumProbes = 0;
    while (true) {
      ++NumProbes;
      /*uint*/int MiddleIndex = (LessIndex - GreaterIndex) / 2 + GreaterIndex;
      /*const SrcMgr.SLocEntry &*//*SLocEntryIndex*/int E = getLoadedSLocEntry(MiddleIndex);
      assert E != INVALID_SLOC_ENTRY_INDEX;
      int Offset_at_I = $getOffset(E);
      if (Offset_at_I == 0) {
        return FileID.getInvalidID(); // invalid entry.
      }
      
      ++NumProbes;
      if (Offset_at_I > SLocOffset) {
        // Sanity checking, otherwise a bug may lead to hanging in release build.
        if (GreaterIndex == MiddleIndex) {
          assert (false) : "binary search missed the entry";
          return FileID.getInvalidID();
        }
        GreaterIndex = MiddleIndex;
        continue;
      }
      int Index = -((int)(MiddleIndex)) - 2;
      if (isOffsetInFileID(Index, SLocOffset)) {
        /*FileID*/int Res = Index;
        if ($isFile(E)) {
          updateLastIDForFileLookup(false, Res,  Offset_at_I, 0, null, MiddleIndex);
          NumLinearScans += NumProbes + 1;
        } else {
          updateLastIDForMacroLookup(false, Res,  Offset_at_I, 0, null, MiddleIndex);
          NumLinearMacroScans += NumProbes + 1;
        }
        assert Res < 0 : "Expected negative FileID for loaded: " + Res;
        return Res;
      }
      
      // Sanity checking, otherwise a bug may lead to hanging in release build.
      if (LessIndex == MiddleIndex) {
        assert (false) : "binary search missed the entry";
        return FileID.getInvalidID();
      }
      LessIndex = MiddleIndex;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getExpansionLocSlowCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 891,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 888,
   FQN="clang::SourceManager::getExpansionLocSlowCase", NM="_ZNK5clang13SourceManager23getExpansionLocSlowCaseENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager23getExpansionLocSlowCaseENS_14SourceLocationE")
  //</editor-fold>
  private /*SourceLocation*/int getExpansionLocSlowCase(/*SourceLocation*/int Loc) /*const*/ {
    do {
      // Note: If Loc indicates an offset into a token that came from a macro
      // expansion (e.g. the 5th character of the token) we do not want to add
      // this offset when going to the expansion location.  The expansion
      // location is the macro invocation, which the offset has nothing to do
      // with.  This is unlike when we get the spelling loc, because the offset
      // directly correspond to the token whose spelling we're inspecting.
      int ExpInfo = getExpansionSLocEntryByID_LoadEntryIfAbsent(getFileID(Loc));
      Loc = $getExpansionLocStart(ExpInfo);
    } while (SourceLocation.isMacroID(Loc));
    
    return Loc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getSpellingLocSlowCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 906,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 903,
   FQN="clang::SourceManager::getSpellingLocSlowCase", NM="_ZNK5clang13SourceManager22getSpellingLocSlowCaseENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager22getSpellingLocSlowCaseENS_14SourceLocationE")
  //</editor-fold>
  private /*SourceLocation*/int getSpellingLocSlowCase(/*SourceLocation*/int Loc) /*const*/ {
    do {
      assert SourceLocation.isMacroID(Loc) : "Not a macro " + SourceLocation.getFromRawEncoding(Loc);
      // inline getDecomposedLoc and it's getFileID here
      //long/*<FileID, uint>*/ LocInfo = getDecomposedLoc(Loc);
      /*uint*/int SLocOffset = SourceLocation.getOffset(Loc);
      /*FileID*/int FID;
      // If our one-entry cache covers this offset, just return it.
      assert !isOffsetInFileID(LastFileIDLookup, SLocOffset) : "how macro Loc could it be in file? " + LastFileIDLookup + ": " + SourceLocation.getFromRawEncoding(Loc);
      if (isOffsetInFileID(LastMacroIDLookup, SLocOffset)) {
        FID = LastMacroIDLookup;
      } else {
        FID = getFileIDSlow(SLocOffset);
      }
      // end of inline 
      int Expansion = getSLocEntryByID_LoadEntryIfAbsent(FID);
      assert Expansion != INVALID_SLOC_ENTRY_INDEX;
      assert $isExpansion(Expansion);
      int Offs = SLocOffset - $getOffset(Expansion);
      Loc = $getSpellingLoc(Expansion);
      Loc = SourceLocation.$getLocWithOffset(Loc, Offs);
    } while (SourceLocation.isMacroID(Loc));
    return Loc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getFileLocSlowCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 915,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 912,
   FQN="clang::SourceManager::getFileLocSlowCase", NM="_ZNK5clang13SourceManager18getFileLocSlowCaseENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager18getFileLocSlowCaseENS_14SourceLocationE")
  //</editor-fold>
  private /*SourceLocation*/int getFileLocSlowCase(/*SourceLocation*/int Loc) /*const*/ {
    do {
      if (isMacroArgExpansion(/*NO_COPY*/Loc)) {
        Loc = getImmediateSpellingLoc(/*NO_COPY*/Loc);
      } else {
        Loc = $first_int(getImmediateExpansionRange(/*NO_COPY*/Loc));
      }
    } while (SourceLocation.isMacroID(Loc));
    return Loc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getDecomposedExpansionLocSlowCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 926,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 923,
   FQN="clang::SourceManager::getDecomposedExpansionLocSlowCase", NM="_ZNK5clang13SourceManager33getDecomposedExpansionLocSlowCaseEPKNS_6SrcMgr9SLocEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager33getDecomposedExpansionLocSlowCaseEPKNS_6SrcMgr9SLocEntryE")
  //</editor-fold>
  private long/*<FileID, uint>*/ getDecomposedExpansionLocSlowCase(/*SrcMgr.SLocEntry P*/int E) /*const*/ {
    // If this is an expansion record, walk through all the expansion points.
    /*FileID*/int FID/*J*/= FileID.getInvalidID();
    /*SourceLocation*/int Loc/*J*/= SourceLocation.getInvalid();
    /*uint*/int Offset;
    do {
      Loc = $getExpansionLocStart(E);
      
      FID = getFileID(Loc);
      E = $AddrOf(getSLocEntryByID_LoadEntryIfAbsent(FID));
      Offset = SourceLocation.getOffset(Loc) - $getOffset(E);
    } while (SourceLocation.isMacroID(Loc));
    
    return wrap_FileID_Offset/*<FileID, uint>*/(FID, Offset);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::getDecomposedSpellingLocSlowCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 944,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 941,
   FQN="clang::SourceManager::getDecomposedSpellingLocSlowCase", NM="_ZNK5clang13SourceManager32getDecomposedSpellingLocSlowCaseEPKNS_6SrcMgr9SLocEntryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager32getDecomposedSpellingLocSlowCaseEPKNS_6SrcMgr9SLocEntryEj")
  //</editor-fold>
  private long/*<FileID, uint>*/ getDecomposedSpellingLocSlowCase(/*const SrcMgr.SLocEntry P*/int SLocEntryIndex, 
          /*uint*/int Offset) /*const*/ {
    // If this is an expansion record, walk through all the expansion points.
    /*FileID*/int FID/*J*/= FileID.getInvalidID();
    /*SourceLocation*/int Loc/*J*/= SourceLocation.getInvalid();
    do {
      Loc = $getSpellingLoc(SLocEntryIndex);
      Loc = SourceLocation.$getLocWithOffset(Loc, Offset);
      
      FID = getFileID(Loc);
      SLocEntryIndex = $AddrOf(getSLocEntryByID_LoadEntryIfAbsent(FID));
      Offset = SourceLocation.getOffset(Loc) - $getOffset(SLocEntryIndex);
      assert Offset >= 0;
    } while (!SourceLocation.isFileID(Loc));
    return wrap_FileID_Offset(FID, Offset);
  }

  
  /// \brief Compute a map of macro argument chunks to their expanded source
  /// location. Chunks that are not part of a macro argument will map to an
  /// invalid source location. e.g. if a file contains one macro argument at
  /// offset 100 with length 10, this is how the map will be formed:
  ///     0   -> SourceLocation()
  ///     100 -> Expanded macro arg location
  ///     110 -> SourceLocation()
  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::computeMacroArgsCache">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1788,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1781,
   FQN="clang::SourceManager::computeMacroArgsCache", NM="_ZNK5clang13SourceManager21computeMacroArgsCacheERPSt3mapIjNS_14SourceLocationESt4lessIjESaISt4pairIKjS2_EEENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager21computeMacroArgsCacheERPSt3mapIjNS_14SourceLocationESt4lessIjESaISt4pairIKjS2_EEENS_6FileIDE")
  //</editor-fold>
  private void computeMacroArgsCache(mapUIntType<SourceLocation> /*P*/ /*&*/ CachePtr, 
          /*FileID*/int FID) /*const*/ {
    assert (FileID.isValid(FID));
    assert (CachePtr.empty());
    
//    CachePtr.$set(new std.mapUIntType<SourceLocation>(new SourceLocation()));
    std.mapUIntType<SourceLocation> /*&*/ MacroArgsCache = $Deref(CachePtr);
    // Initially no macro argument chunk is present.
    MacroArgsCache.insert(std.make_pair_uint_T(0, new SourceLocation()));
    
    int ID = FID;
    while (true) {
      ++ID;
      // Stop if there are no more FileIDs to check.
      if (ID > 0) {
        if ($greatereq_uint(((/*uint*/int)(ID)), local_sloc_entry_size())) {
          return;
        }
      } else if (ID == -1) {
        return;
      }
      
      int SLocEntryIndex = getSLocEntryByID_LoadEntryIfAbsent(ID);
      if (SLocEntryIndex == INVALID_SLOC_ENTRY_INDEX) {
        return;
      }
      if ($isFile(SLocEntryIndex)) {
        /*SourceLocation*/int IncludeLoc = $getIncludeLoc(SLocEntryIndex);
        if (SourceLocation.isInvalid(IncludeLoc)) {
          continue;
        }
        if (!isInFileID(/*NO_COPY*/IncludeLoc, /*NO_COPY*/FID)) {
          return; // No more files/macros that may be "contained" in this file.
        }
        
        // Skip the files/macros of the #include'd file, we only care about macros
        // that lexed macro arguments from our file.
        int NumCreatedFIDs = $getNumCreatedFIDs(SLocEntryIndex);
        if ((NumCreatedFIDs != 0)) {
          ID += NumCreatedFIDs - 1; /*because of next ++ID*/
        }
        continue;
      }
      
      /*SourceLocation*/int ExpansionLocStart = $getExpansionLocStart(SLocEntryIndex);      
      if (SourceLocation.isFileID(ExpansionLocStart)) {
        if (!isInFileID(ExpansionLocStart, /*NO_COPY*/FID)) {
          return; // No more files/macros that may be "contained" in this file.
        }
      }
      if (!$isMacroArgExpansion(SLocEntryIndex)) {
        continue;
      }
      
      associateFileChunkWithMacroArgExp(MacroArgsCache, /*NO_COPY*/FID, 
          $getSpellingLoc(SLocEntryIndex), 
          SourceLocation.$getMacroLoc($getOffset(SLocEntryIndex)), 
          getFileIDSize(ID));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceManager::associateFileChunkWithMacroArgExp">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1844,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1837,
   FQN="clang::SourceManager::associateFileChunkWithMacroArgExp", NM="_ZNK5clang13SourceManager33associateFileChunkWithMacroArgExpERSt3mapIjNS_14SourceLocationESt4lessIjESaISt4pairIKjS2_EEENS_6FileIDES2_S2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13SourceManager33associateFileChunkWithMacroArgExpERSt3mapIjNS_14SourceLocationESt4lessIjESaISt4pairIKjS2_EEENS_6FileIDES2_S2_j")
  //</editor-fold>
  private void associateFileChunkWithMacroArgExp(std.mapUIntType<SourceLocation> /*&*/ MacroArgsCache, 
                                    /*FileID*/int FID, 
                                    /*SourceLocation*/int SpellLoc, 
                                    /*SourceLocation*/int ExpansionLoc, 
                                    /*uint*/int ExpansionLength) /*const*/ {
    if (!SourceLocation.isFileID(SpellLoc)) {
      /*uint*/int SpellBeginOffs = SourceLocation.getOffset(SpellLoc);
      /*uint*/int SpellEndOffs = SpellBeginOffs + ExpansionLength;
      
      // The spelling range for this macro argument expansion can span multiple
      // consecutive FileID entries. Go through each entry contained in the
      // spelling range and if one is itself a macro argument expansion, recurse
      // and associate the file chunk that it represents.
      long/*<FileID, uint>*/ decomposedLoc = getDecomposedLoc(SpellLoc);
      /*FileID*/int SpellFID/*J*/= $first_FileID(decomposedLoc);// Current FileID in the spelling range.
      /*uint*/int SpellRelativeOffs = $second_offset(decomposedLoc);      
      while (true) {
        /*const SLocEntry &*/int Entry = getSLocEntryByID_LoadEntryIfAbsent(SpellFID);
        /*uint*/int SpellFIDBeginOffs = $getOffset(Entry);
        /*uint*/int SpellFIDSize = getFileIDSize(SpellFID);
        /*uint*/int SpellFIDEndOffs = SpellFIDBeginOffs + SpellFIDSize;
        /*const SrcMgr.ExpansionInfo &*/int Info = Entry;
        if ($isMacroArgExpansion(Info)) {
          /*uint*/int CurrSpellLength;
          if ($less_uint(SpellFIDEndOffs, SpellEndOffs)) {
            CurrSpellLength = SpellFIDSize - SpellRelativeOffs;
          } else {
            CurrSpellLength = ExpansionLength;
          }
          associateFileChunkWithMacroArgExp(MacroArgsCache, /*NO_COPY*/FID, 
                  SourceLocation.$getLocWithOffset($getSpellingLoc(Info), SpellRelativeOffs), 
                  /*NO_COPY*/ExpansionLoc, CurrSpellLength);
        }
        if ($greatereq_uint(SpellFIDEndOffs, SpellEndOffs)) {
          return; // we covered all FileID entries in the spelling range.
        }
        
        // Move to the next FileID entry in the spelling range.
        /*uint*/int advance = SpellFIDSize - SpellRelativeOffs + 1;
        ExpansionLoc = SourceLocation.$getLocWithOffset(ExpansionLoc, advance);
        ExpansionLength -= advance;
        ++SpellFID;
        SpellRelativeOffs = 0;
      }
    }
    assert (SourceLocation.isFileID(SpellLoc));
    
    /*uint*/uint$ptr BeginOffsRef = create_uint$ptr();
    if (!isInFileID(SpellLoc, FID, $AddrOf(BeginOffsRef))) {
      return;
    }
    /*uint*/int BeginOffs = BeginOffsRef.$star();
    
    /*uint*/int EndOffs = BeginOffs + ExpansionLength;
    
    // Add a new chunk for this macro argument. A previous macro argument chunk
    // may have been lexed again, so e.g. if the map is
    //     0   -> SourceLocation()
    //     100 -> Expanded loc #1
    //     110 -> SourceLocation()
    // and we found a new macro FileID that lexed from offet 105 with length 3,
    // the new map will be:
    //     0   -> SourceLocation()
    //     100 -> Expanded loc #1
    //     105 -> Expanded loc #2
    //     108 -> Expanded loc #1
    //     110 -> SourceLocation()
    //
    // Since re-lexed macro chunks will always be the same size or less of
    // previous chunks, we only need to find where the ending of the new macro
    // chunk is mapped to and update the map with new begin/end mappings.
    std.mapUIntType.iterator<SourceLocation> I = MacroArgsCache.upper_bound(EndOffs);
    I.$preDec();
    SourceLocation EndOffsMappedLoc = I.$arrow().second;
    MacroArgsCache.ref$at(BeginOffs).$deref().$assign(ExpansionLoc);
    MacroArgsCache.ref$at(EndOffs).$deref().$assign(EndOffsMappedLoc);
  }


  private final char$ptr$array $CharacterDataPtr = (char$ptr$array)create_reusable_char$ptr();
  private boolean $CharacterDataPtrInUse = false;
  public char$ptr$array $CharacterDataPtr() {
    assert !$CharacterDataPtrInUse;
    assert ($CharacterDataPtrInUse = true);
    return $CharacterDataPtr;
  }
  
  public void $releaseCharacterDataPtr(char$ptr$array Ptr) {
    assert Ptr == $CharacterDataPtr;
    assert $CharacterDataPtrInUse;
    assert ($CharacterDataPtrInUse = false) || true;
    clear_char$ptr$array(Ptr);
  }  

  private final int$ptr $OffsetPtr = create_int$ptr(0);
  private boolean $OffsetPtrInUse = false;
  public int$ptr $getOffsetPtr() {
    assert !$OffsetPtrInUse;
    assert ($OffsetPtrInUse = true);
    return $OffsetPtr;
  }
  
  public void $releaseOffsetPtr(int$ptr Ptr) {
    assert Ptr == $OffsetPtr;
    assert $OffsetPtrInUse;
    assert ($OffsetPtrInUse = false) || true;
  }  
  
  /*friend  class ASTReader*/;
  /*friend  class ASTWriter*/;
  
  public String toString() {
    return "" 
              /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diag=" + Diag // NOI18N*/
              /* STACKOVERFLOW: NEVER PRINT FileManager + ", FileMgr=" + FileMgr // NOI18N */
              + ", ContentCacheAlloc=" + ContentCacheAlloc // NOI18N
              + ", FileInfos=" + FileInfos // NOI18N
              + ", OverridenFilesKeepOriginalName=" + OverridenFilesKeepOriginalName // NOI18N
              + ", UserFilesAreVolatile=" + UserFilesAreVolatile // NOI18N
              + ", FilesAreTransient=" + FilesAreTransient // NOI18N
              + ", OverriddenFilesInfo=" + OverriddenFilesInfo // NOI18N
              + ", MemBufferInfos=" + MemBufferInfos // NOI18N
              + ", LocalSLocEntryTable=" + LocalSLocEntryTable // NOI18N
              + ", LoadedSLocEntryTable=" + LoadedSLocEntryTable // NOI18N
              + ", NextLocalOffset=" + NextLocalOffset // NOI18N
              + ", CurrentLoadedOffset=" + CurrentLoadedOffset // NOI18N
              + ", SLocEntryLoaded=" + SLocEntryLoaded // NOI18N
              + ", ExternalSLocEntries=" + ExternalSLocEntries // NOI18N
              + ", LastFileIDLookup=" + LastFileIDLookup // NOI18N
              + ", LineTable=" + LineTable // NOI18N
              + ", LastLineNoFileIDQuery=" + LastLineNoFileIDQuery // NOI18N
              + ", LastLineNoContentCache=" + LastLineNoContentCache // NOI18N
              + ", LastLineNoFilePos=" + LastLineNoFilePos // NOI18N
              + ", LastLineNoResult=" + LastLineNoResult // NOI18N
              + ", MainFileID=" + MainFileID // NOI18N
              + ", PreambleFileID=" + PreambleFileID // NOI18N
              + ", NumLinearScans=" + NumLinearScans // NOI18N
              + ", NumBinaryProbes=" + NumBinaryProbes // NOI18N
              + ", IncludedLocMap=" + IncludedLocMap // NOI18N
              + ", IBTUCache=" + IBTUCache // NOI18N
              + ", IBTUCacheOverflow=" + IBTUCacheOverflow // NOI18N
              + ", FakeBufferForRecovery=" + FakeBufferForRecovery // NOI18N
              + ", FakeContentCacheForRecovery=" + FakeContentCacheForRecovery // NOI18N
              + ", MacroArgsCacheMap=" + MacroArgsCacheMap // NOI18N
              + ", StoredModuleBuildStack=" + StoredModuleBuildStack // NOI18N
              + super.toString(); // NOI18N
  }  
}
