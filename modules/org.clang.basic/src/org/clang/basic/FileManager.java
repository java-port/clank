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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;

import static org.clang.basic.impl.FileManagerStatics.*;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;


/// \brief Implements support for file system lookup, file system caching,
/// and directory search management.
///
/// This also handles more advanced properties, such as uniquing files based
/// on "inode", so that a file with two names (e.g. symlinked) will be treated
/// as a single file.
///
//<editor-fold defaultstate="collapsed" desc="clang::FileManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 117,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 115,
 FQN="clang::FileManager", NM="_ZN5clang11FileManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManagerE")
//</editor-fold>
public class FileManager extends /*public*/ RefCountedBase<FileManager> implements Destructors.ClassWithDestructor {
  
  private static final DirectoryEntry NON_EXISTENT_DIR = new DirectoryEntry();
  
  private static final FileEntry NON_EXISTENT_FILE = new FileEntry(fs.INVALID_UNIQUE_ID);
  
  private IntrusiveRefCntPtr<FileSystem> FS;
  private FileSystemOptions FileSystemOpts;
  
  // state where file manager keeps only one canonical path by UniqueID
  // but in Java mode we use normalized, not canonical paths, so we keep all normalized
  // as different entries
  public static final String NORMALIZED_UID_PROP = "clank.normalized.file.uid";
  public static final boolean NORMALIZED_UID = Boolean.valueOf(System.getProperty(NORMALIZED_UID_PROP, NativeTrace.isStandalone() ? "false" : "true"));
  
  /// \brief Cache for existing real directories.
  private std.mapTypeType<fs.UniqueID, DirectoryEntry> UniqueRealDirs;
  
  /// \brief Cache for existing real files.
  private std.mapTypeType<fs.UniqueID, FileEntry> UniqueRealFiles;
  
  /// \brief The virtual directories that we have allocated.
  ///
  /// For each virtual file (e.g. foo/bar/baz.cpp), we add all of its parent
  /// directories (foo/ and foo/bar/) here.
  private SmallVector<std.unique_ptr<DirectoryEntry>> VirtualDirectoryEntries;
  /// \brief The virtual files that we have allocated.
  private SmallVector<std.unique_ptr<FileEntry>> VirtualFileEntries;
  
  /// \brief A cache that maps paths to directory entries (either real or
  /// virtual) we have looked up
  ///
  /// The actual Entries for real directories/files are
  /// owned by UniqueRealDirs/UniqueRealFiles above, while the Entries
  /// for virtual directories/files are owned by
  /// VirtualDirectoryEntries/VirtualFileEntries above.
  ///
  private StringMap<DirectoryEntry /*P*//*, BumpPtrAllocator*/> SeenDirEntries;
  
  /// \brief A cache that maps paths to file entries (either real or
  /// virtual) we have looked up.
  ///
  /// \see SeenDirEntries
  private StringMap<FileEntry /*P*//*, BumpPtrAllocator*/> SeenFileEntries;
  
  /// \brief The canonical names of directories.
  private DenseMap</*const*/ DirectoryEntry /*P*/ , StringRef> CanonicalDirNames;
  
  /// \brief Storage for canonical names that we have computed.
  private BumpPtrAllocatorImpl CanonicalNameStorage;
  
  /// \brief Each FileEntry we create is assigned a unique ID #.
  ///
  private /*uint*/int NextFileUID;
  static final/*uint*/int INVALID_UID = Integer.MIN_VALUE;
  
  // Statistics.
  private /*uint*/int NumDirLookups;
  private /*uint*/int NumFileLookups;
  private /*uint*/int NumDirCacheMisses;
  private /*uint*/int NumFileCacheMisses;
  
  // Caching.
  private std.unique_ptr<FileSystemStatCache> StatCache;
  
  
  /// getStatValue - Get the 'stat' information for the specified path,
  /// using the cache to accelerate it if possible.  This returns true
  /// if the path points to a virtual file or does not exist, or returns
  /// false if it's an existent real file.  If FileDescriptor is NULL,
  /// do directory look-up instead of file look-up.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getStatValue">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 463,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 461,
   FQN="clang::FileManager::getStatValue", NM="_ZN5clang11FileManager12getStatValueEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager12getStatValueEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EE")
  //</editor-fold>
  private boolean getStatValue(/*const*/char$ptr/*char P*/ Path, int PathLen, FileData /*&*/ Data, boolean isFile, 
              std.unique_ptr<File> /*P*/ F) {
    SmallString/*128*/ FilePath = null;
    try {
      // FIXME: FileSystemOpts shouldn't be passed in here, all paths should be
      // absolute!
      if (FileSystemOpts.WorkingDir.empty()) {
        return FileSystemStatCache.get(Path, PathLen, Data, isFile, F, StatCache.get(), FS.$star());
      }
      
      FilePath/*J*/= new SmallString/*128*/(128, new StringRef(Path, PathLen));
      FixupRelativePath(FilePath);
      
      return FileSystemStatCache.get(FilePath.c_str(), FilePath.size(), Data, isFile, F, 
          StatCache.get(), FS.$star());
    } finally {
      if (FilePath != null) { FilePath.$destroy(); }
    }
  }

  
  /// Add all ancestors of the given path (pointing to either a file
  /// or a directory) as virtual directories.
  
  /// Add all ancestors of the given path (pointing to either a file or
  /// a directory) as virtual directories.
  // JAVA: this method is upgraded to the new version carefully - to keep performance at decent level.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::addAncestorsAsVirtualDirs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 124,
   FQN="clang::FileManager::addAncestorsAsVirtualDirs", NM="_ZN5clang11FileManager25addAncestorsAsVirtualDirsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager25addAncestorsAsVirtualDirsEN4llvm9StringRefE")
  //</editor-fold>
  private void addAncestorsAsVirtualDirs(StringRef Path) {
    StringRef DirName = path.parent_path(/*NO_COPY*/Path);
    // JAVA: use path.is_empty
    if (path.is_empty(DirName)) {
      // JAVA: is DOT correct here for remote?
      DirName = StringRef.R$DOT;
    }
    
    StringMapEntry<DirectoryEntry /*P*/ > /*&*/ NamedDirEnt = SeenDirEntries.GetOrCreateValue(DirName, (DirectoryEntry) null);
    
    // When caching a virtual directory, we always cache its ancestors
    // at the same time.  Therefore, if DirName is already in the cache,
    // we don't need to recurse as its ancestors must also already be in
    // the cache.
    if ((NamedDirEnt.second != null) && NamedDirEnt.second != NON_EXISTENT_DIR) {
      return;
    }
    
    // Add the virtual directory to the cache.
    unique_ptr<DirectoryEntry> /*P*/ UDE = llvm.make_unique(new DirectoryEntry()); 
    UDE.$arrow().Name = $noClone(NamedDirEnt.getKeyStr());
    UDE.$arrow().NameLen = NamedDirEnt.getKeyLength();
    NamedDirEnt.second = UDE.get();
    VirtualDirectoryEntries.push_back_T$RR(std.move(UDE));
    
    // Recursively add the other ancestors.
    addAncestorsAsVirtualDirs(DirName);
    
    // JAVA PERF: no need to destroy UDE
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // Common logic.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::FileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 48,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 49,
   FQN="clang::FileManager::FileManager", NM="_ZN5clang11FileManagerC1ERKNS_17FileSystemOptionsEN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManagerC1ERKNS_17FileSystemOptionsEN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE")
  //</editor-fold>
  public FileManager(/*const*/ FileSystemOptions /*&*/ FSO) {
    this(FSO, 
      new IntrusiveRefCntPtr<FileSystem>((FileSystem) null));
  }
  public FileManager(/*const*/ FileSystemOptions /*&*/ FSO, 
      IntrusiveRefCntPtr<FileSystem> FS/*= null*/) {
    /* : RefCountedBase<FileManager>(), FS(FS), FileSystemOpts(FSO), UniqueRealDirs(), UniqueRealFiles(), VirtualDirectoryEntries(), VirtualFileEntries(), SeenDirEntries(64), SeenFileEntries(64), CanonicalDirNames(), CanonicalNameStorage(), NextFileUID(0), StatCache()*/ 
    //START JInit
    super();
    this.FS = new IntrusiveRefCntPtr<FileSystem>(FS);
    this.FileSystemOpts = new FileSystemOptions(FSO);
    this.UniqueRealDirs = new std.mapTypeType<fs.UniqueID, DirectoryEntry>(fs.UniqueID.COMPARATOR, new DirectoryEntry());
    this.UniqueRealFiles = new std.mapTypeType<fs.UniqueID, FileEntry>(fs.UniqueID.COMPARATOR, new FileEntry());
    this.VirtualDirectoryEntries = new SmallVector<std.unique_ptr<DirectoryEntry>>(4, new std.unique_ptr<DirectoryEntry>());
    this.VirtualFileEntries = new SmallVector<std.unique_ptr<FileEntry>>(4, new std.unique_ptr<FileEntry>());
    this.SeenDirEntries = new StringMap<DirectoryEntry /*P*//*, BumpPtrAllocator*/>(64, null);
    this.SeenFileEntries = new StringMap<FileEntry /*P*//*, BumpPtrAllocator*/>(64, null);
    this.CanonicalDirNames = new DenseMap</*const*/ DirectoryEntry /*P*/ , StringRef>(DenseMapInfo$LikePtr.$Info(), new StringRef());
    this.CanonicalNameStorage = new BumpPtrAllocatorImpl();
    this.NextFileUID = 0;
    this.StatCache = new std.unique_ptr<FileSystemStatCache>();
    //END JInit
    assert this.NextFileUID != FileManager.INVALID_UID : this.NextFileUID + "vs. " + FileManager.INVALID_UID;
    NumDirLookups = NumFileLookups = 0;
    NumDirCacheMisses = NumFileCacheMisses = 0;
    
    // If the caller doesn't provide a virtual file system, just grab the real
    // file system.
    if (!FS.$bool()) {
      this.FS.$assign(VfsGlobals.getRealFileSystem());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::~FileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 61,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 62,
   FQN="clang::FileManager::~FileManager", NM="_ZN5clang11FileManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManagerD0Ev")
  //</editor-fold>
  public void $destroy()/* = default*/ {
    //START JDestroy
    StatCache.$destroy();
    CanonicalNameStorage.$destroy();
    CanonicalDirNames.$destroy();
    SeenFileEntries.$destroy();
    SeenDirEntries.$destroy();
    VirtualFileEntries.$destroy();
    VirtualDirectoryEntries.$destroy();
    UniqueRealFiles.$destroy();
    UniqueRealDirs.$destroy();
    FileSystemOpts.$destroy();
    FS.$destroy();
    //~RefCountedBase<FileManager>;
    //END JDestroy
  }

  
  /// \brief Installs the provided FileSystemStatCache object within
  /// the FileManager.
  ///
  /// Ownership of this object is transferred to the FileManager.
  ///
  /// \param statCache the new stat cache to install. Ownership of this
  /// object is transferred to the FileManager.
  ///
  /// \param AtBeginning whether this new stat cache must be installed at the
  /// beginning of the chain of stat caches. Otherwise, it will be added to
  /// the end of the chain.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::addStatCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 63,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 64,
   FQN="clang::FileManager::addStatCache", NM="_ZN5clang11FileManager12addStatCacheESt10unique_ptrINS_19FileSystemStatCacheESt14default_deleteIS2_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager12addStatCacheESt10unique_ptrINS_19FileSystemStatCacheESt14default_deleteIS2_EEb")
  //</editor-fold>
  public void addStatCache(std.unique_ptr<FileSystemStatCache> statCache) {
    addStatCache(statCache, 
              false);
  }
  public void addStatCache(std.unique_ptr<FileSystemStatCache> statCache, 
              boolean AtBeginning/*= false*/) {
    assert (statCache.$bool()) : "No stat cache provided?";
    if (AtBeginning || !(StatCache.get() != null)) {
      statCache.$arrow().setNextStatCache(new std.unique_ptr<FileSystemStatCache>(std.move(StatCache)));
      StatCache.$assignMove(std.move(statCache));
      return;
    }
    
    FileSystemStatCache /*P*/ LastCache = StatCache.get();
    while ((LastCache.getNextStatCache() != null)) {
      LastCache = LastCache.getNextStatCache();
    }
    
    LastCache.setNextStatCache(new std.unique_ptr<FileSystemStatCache>(std.move(statCache)));
  }

  
  /// \brief Removes the specified FileSystemStatCache object from the manager.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::removeStatCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 79,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 80,
   FQN="clang::FileManager::removeStatCache", NM="_ZN5clang11FileManager15removeStatCacheEPNS_19FileSystemStatCacheE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager15removeStatCacheEPNS_19FileSystemStatCacheE")
  //</editor-fold>
  public void removeStatCache(FileSystemStatCache /*P*/ statCache) {
    if (!(statCache != null)) {
      return;
    }
    if (StatCache.get() == statCache) {
      // This is the first stat cache.
      StatCache.$assignMove(StatCache.$arrow().takeNextStatCache());
      return;
    }
    
    // Find the stat cache in the list.
    FileSystemStatCache /*P*/ PrevCache = StatCache.get();
    while ((PrevCache != null) && PrevCache.getNextStatCache() != statCache) {
      PrevCache = PrevCache.getNextStatCache();
    }
    assert ((PrevCache != null)) : "Stat cache not found for removal";
    PrevCache.setNextStatCache(statCache.takeNextStatCache());
  }

  
  /// \brief Removes all FileSystemStatCache objects from the manager.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::clearStatCaches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 99,
   FQN="clang::FileManager::clearStatCaches", NM="_ZN5clang11FileManager15clearStatCachesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager15clearStatCachesEv")
  //</editor-fold>
  public void clearStatCaches() {
    StatCache.reset();
  }

  
  /// \brief Lookup, cache, and verify the specified directory (real or
  /// virtual).
  ///
  /// This returns NULL if the directory doesn't exist.
  ///
  /// \param CacheFailure If true and the file does not exist, we'll cache
  /// the failure to find this file.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 148,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 149,
   FQN="clang::FileManager::getDirectory", NM="_ZN5clang11FileManager12getDirectoryEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager12getDirectoryEN4llvm9StringRefEb")
  //</editor-fold>
  public /*const*/ DirectoryEntry /*P*/ getDirectory(StringRef DirName) {
    return getDirectory(DirName, 
              true);
  }
  public /*const*/ DirectoryEntry /*P*/ getDirectory(StringRef DirName, 
              boolean CacheFailure/*= true*/) {
    FileData Data = null;
    try {
      // stat doesn't like trailing separators except for root directory.
      // At least, on Win32 MSVCRT, stat() cannot strip trailing '/'.
      // (though it can strip '\\')
      if (DirName.size() > 1
         && $noteq_StringRef(DirName, path.root_path(DirName))
         && path.is_separator(DirName.back())) {
        DirName.$assign$substr(0, DirName.size() - 1);
      }
      
      ++NumDirLookups;
      StringMapEntry<DirectoryEntry /*P*/ > /*&*/ NamedDirEnt = SeenDirEntries.GetOrCreateValue(DirName, (DirectoryEntry) null);
      
      // See if there was already an entry in the map.  Note that the map
      // contains both virtual and real directories.
      if ((NamedDirEnt.second != null)) {
        return NamedDirEnt.second == NON_EXISTENT_DIR ? null : NamedDirEnt.second;
      }
      
      ++NumDirCacheMisses;
      
      // By default, initialize it to invalid.
      NamedDirEnt.second = NON_EXISTENT_DIR;
      
      // Get the null-terminated directory name as stored as the key of the
      // SeenDirEntries map.
      /*const*/char$ptr/*char P*/ InterndDirName = $noClone(NamedDirEnt.getKeyStr());
      int InterndDirNameLen = NamedDirEnt.getKeyLength();
      assert InterndDirNameLen == strlen(InterndDirName) : "Invalid " + InterndDirNameLen + " for " + InterndDirName;
      assert $eq_StringRef(DirName, new StringRef(InterndDirName, InterndDirNameLen)) : "must be equal " + DirName + " vs. " + InterndDirName;
      // Check to see if the directory exists.
      Data/*J*/= new FileData();
      if (getStatValue(InterndDirName, InterndDirNameLen, Data, false, null)) {
        // There's no real directory at the given path.
        if (!CacheFailure) {
          SeenDirEntries.erase(DirName);
        }
        return null;
      }
      
      // It exists.  See if we have already opened a directory with the
      // same inode (this occurs on Unix-like systems when one dir is
      // symlinked to another, for example) or the same path (on
      // Windows).
      DirectoryEntry /*&*/ UDE = UniqueRealDirs.$at(Data.UniqueID);
      
      // Normalized Directory Data.Name which might be different from remembered UDE.Name
      // let's hope they are the same
      if (UDE.Name != null) {//is initialized before?
        if (!NORMALIZED_UID || $eq_RawStringRef(UDE.Name, UDE.NameLen, Data.Name.$array(), 0, Data.Name.size())) {
          // fast path: the same as current normalized path or merge by canonical UIDs mode
          NamedDirEnt.second = $AddrOf(UDE);
          return UDE;
        } else {
          // were were asked for normalization, not canonical;
          // we need another Normalized Directory Entry, forget the one found in UniqueRealDirs
          UDE = null;
        }
      } else {
        // keep UDE for later initialization
      }
      // slow path: find or prepare normalized dir
      StringMapEntry<DirectoryEntry /*P*/ > /*&*/ NormalizedDirEnt = NamedDirEnt;
      if (!$eq_RawStringRef(InterndDirName, InterndDirNameLen, Data.Name.$array(), 0, Data.Name.size())) {      
        // stat'ed and named in input parameter are different; query normalized candidate
        NormalizedDirEnt = SeenDirEntries.GetOrCreateValue(Data.Name.$array(), 0, Data.Name.size());
        if (NormalizedDirEnt.second != null) {
          // was already initialized before; can assign and return
          if (UDE == null) {
            // was cleared above, it's OK
          } else {
            // this normalized was added without stat from addAncestorsAsVirtualDirs
            // i.e. we were parsing /some/path/file.cc which provides overridden buffer,
            // which #include "../path/header.h" from already seen directory
            
            // init UDE got from UniqueRealDirs using normalized one added by addAncestorsAsVirtualDirs
            assert (UDE.Name == null) : "expected uninitialized:" + UDE + " for " + UniqueRealDirs.find(Data.UniqueID).$star();
            // use the one from normalized dir
          }
          // always use normalized one
          UDE = NormalizedDirEnt.second;
          assert NormalizedDirEnt.second != UniqueRealDirs.$at(Data.UniqueID) : "must be different:\n" + NormalizedDirEnt + "\nvs.\n" + UniqueRealDirs.$at(Data.UniqueID) + "\n when query for " + DirName;
          // replace value by reference to have recently queried instance of UDE in UniqueRealDirs
          UniqueRealDirs.replaceValueReference(Data.UniqueID, UDE);
          assert UniqueRealDirs.$at(Data.UniqueID) == NormalizedDirEnt.second : "incorrect reference replacement " + UniqueRealDirs.find(Data.UniqueID).$star() + "\nvs.\n" + NormalizedDirEnt;
          assert UDE.Name != null : "must be initialized " + NormalizedDirEnt;
          NamedDirEnt.second = $AddrOf(UDE);
          return UDE;
        }
        // use normalized key as dir name
        InterndDirName = $noClone(NormalizedDirEnt.getKeyData());
        InterndDirNameLen = NormalizedDirEnt.getKeyLength();
      }
      // prepare normalized entry
      assert NormalizedDirEnt.second == null || (NormalizedDirEnt == NamedDirEnt);
      if (UDE == null) {
        // it was query for new normalized path not seen before
        UDE = new DirectoryEntry();
      }
      // keep UDE in Named Entry as well as in Normalized Entry
      NormalizedDirEnt.second = UDE;
      NamedDirEnt.second = UDE;

      // We don't have this directory yet, add it.  We use the string
      // key from the SeenDirEntries map as the string or normalized one
      assert (UDE.Name == null) : "expected uninitialized:" + UDE + " for " + NormalizedDirEnt;
      UDE.Name = $noClone(InterndDirName);
      UDE.NameLen = InterndDirNameLen;
      
      assert $eq_StringRef(Data.Name, new StringRef(UDE.Name)) : "want to use normalized dir path " + Data.Name + " vs. " + UDE.Name + " for " + UDE;        
      return $AddrOf(UDE);
    } finally {
      if (Data != null) { Data.$destroy(); }
    }
  }

  
  /// \brief Lookup, cache, and verify the specified file (real or
  /// virtual).
  ///
  /// This returns NULL if the file doesn't exist.
  ///
  /// \param OpenFile if true and the file exists, it will be opened.
  ///
  /// \param CacheFailure If true and the file does not exist, we'll cache
  /// the failure to find this file.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 212,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 213,
   FQN="clang::FileManager::getFile", NM="_ZN5clang11FileManager7getFileEN4llvm9StringRefEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager7getFileEN4llvm9StringRefEbb")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getFile(StringRef Filename) {
    return getFile(Filename, false, 
         true);
  }
  public /*const*/ FileEntry /*P*/ getFile(StringRef Filename, boolean openFile/*= false*/) {
    return getFile(Filename, openFile, 
         true);
  }
  public /*const*/ FileEntry /*P*/ getFile(StringRef Filename, boolean openFile/*= false*/, 
         boolean CacheFailure/*= true*/) {
    std.unique_ptr<File> F = null;
    FileData Data = null;
    try {
      ++NumFileLookups;
      
      // See if there is already an entry in the map.
      StringMapEntry<FileEntry /*P*/ > /*&*/ NamedFileEnt = SeenFileEntries.GetOrCreateValue(Filename, (FileEntry) null);
      
      // See if there is already an entry in the map.
      if ((NamedFileEnt.second != null)) {
        return NamedFileEnt.second == NON_EXISTENT_FILE ? null : NamedFileEnt.second;
      }
      
      ++NumFileCacheMisses;
      
      // By default, initialize it to invalid.
      NamedFileEnt.second = NON_EXISTENT_FILE;
      
      // Get the null-terminated file name as stored as the key of the
      // SeenFileEntries map.
      /*const*/char$ptr/*char P*/ InterndFileName = $noClone(NamedFileEnt.getKeyStr());
      /*JAVA PERF:*/int InterndFileNameLen = NamedFileEnt.getKeyLength();
      assert InterndFileNameLen == strlen(InterndFileName) : "Invalid " + InterndFileNameLen + " for " + InterndFileName;
      assert $eq_StringRef(Filename, new StringRef(InterndFileName, InterndFileNameLen)) : "must be equal " + Filename + " vs. " + InterndFileNameLen;
      
      // Look up the directory for the file.  When looking up something like
      // sys/foo.h we'll discover all of the search directories that have a 'sys'
      // subdirectory.  This will let us avoid having to waste time on known-to-fail
      // searches when we go to find sys/bar.h, because all the search directories
      // without a 'sys' subdir will get a cached failure result.
      /*const*/ DirectoryEntry /*P*/ DirInfo = getDirectoryFromFile(/*Deref*/this, Filename, 
          CacheFailure);
      if (DirInfo == null) { // Directory doesn't exist, file can't exist.
        if (!CacheFailure) {
          SeenFileEntries.erase(Filename);
        }
        
        return null;
      }
      
      // FIXME: Use the directory info to prune this, before doing the stat syscall.
      // FIXME: This will reduce the # syscalls.
      
      // Nope, there isn't.  Check to see if the file exists.
      F/*J*/= new std.unique_ptr<File>();
      Data/*J*/= new FileData();
      if (getStatValue(InterndFileName, InterndFileNameLen, Data, true, openFile ? $AddrOf(F) : null)) {
        // There's no real file at the given path.
        if (!CacheFailure) {
          SeenFileEntries.erase(Filename);
        }
        
        return null;
      }
      assert ((openFile || !F.$bool())) : "undesired open file";
      
      // It exists.  See if we have already opened a file with the same inode.
      // This occurs when one dir is symlinked to another, for example.
      FileEntry /*&*/ UFE = UniqueRealFiles.$at(Data.UniqueID);
      
      // Normalized Data.Name might be different from remembered UFE.Name
      // let's hope they are the same
      if (UFE.isValid()) {//is initialized before?
        if (!NORMALIZED_UID || $eq_RawStringRef(UFE.Name, UFE.NameLen, Data.Name.$array(), 0, Data.Name.size())) {
          // fast path: the same as current normalized path or merge by canonical UIDs mode
          NamedFileEnt.second = $AddrOf(UFE);
          return UFE;
        } else {
          // were were asked for normalization, not canonical;
          // we need another Normalized Entry, forget the one found in UniqueRealFiles
          UFE = null;
        }
      } else {
        // keep UFE for later initialization
      }
      // slow path: find or prepare normalized 
      StringMapEntry<FileEntry /*P*/ > /*&*/ NormalizedFileEnt = NamedFileEnt;
      if (!$eq_RawStringRef(InterndFileName, InterndFileNameLen, Data.Name.$array(), 0, Data.Name.size())) {
        // stat'ed and named in input parameter are different; query normalized candidate
        NormalizedFileEnt = SeenFileEntries.GetOrCreateValue(Data.Name.$array(), 0, Data.Name.size());
        if (NormalizedFileEnt.second != null) {
          // was already initialized before; can assign and return
          assert UFE == null : "must be cleared in the check above";
          UFE = NormalizedFileEnt.second;
          assert UFE != UniqueRealFiles.$at(Data.UniqueID) : "must be different:\n" + NormalizedFileEnt + "\nvs.\n" + UniqueRealFiles.$at(Data.UniqueID) + "\n when query for " + Filename;
          assert UFE.Name != null : "must be initialized " + NormalizedFileEnt;
          NamedFileEnt.second = $AddrOf(UFE);
          return UFE;
        }
        // use normalized key as file name
        InterndFileName = $noClone(NormalizedFileEnt.getKeyData());
        InterndFileNameLen = NormalizedFileEnt.getKeyLength();
      }
      // prepare normalized entry
      assert NormalizedFileEnt.second == null || (NormalizedFileEnt == NamedFileEnt);
      if (UFE == null) {
        // it was query for new normalized path not seen before
        UFE = new FileEntry();
      }
      // keep UFE in Named Entry as well as in Normalized Entry
      NormalizedFileEnt.second = UFE;
      NamedFileEnt.second = UFE;

      // We don't have this file yet, add it.  We use the string
      // key from the SeenFileEntries map as the string or normalized one
      assert !UFE.isValid() : "expected uninitialized:" + UFE + " for " + NormalizedFileEnt;

      /*JAVA*/assert UFE.UID == INVALID_UID : "UID must be assigned only once " + UFE;
      // Otherwise, we don't have this file yet, add it.
      UFE.Name = $noClone(InterndFileName);
      UFE.NameLen = InterndFileNameLen;
      UFE.Size = Data.Size;
      UFE.ModTime = Data.ModTime;
      UFE.Dir = DirInfo;
      UFE.UID = NextFileUID++;
      UFE.UniqueID.$assign(Data.UniqueID);
      UFE.IsNamedPipe = Data.IsNamedPipe;
      UFE.InPCH = Data.InPCH;
      UFE.File.$assignMove(std.move(F));
      UFE.IsValid = true;
      if (UFE.File.$bool()) {
        {
          ErrorOr<std.string> RealPathName = UFE.File.$arrow().getName();
          if (RealPathName.$bool()) {
            UFE.RealPathName.$assign(RealPathName.$star());
          }
        }
      }
      assert $eq_StringRef(Data.Name, new StringRef(UFE.Name)) : "want to use normalized file path " + Data.Name + " vs. " + UFE.Name + " for " + UFE;
      return $AddrOf(UFE);
    } finally {
      if (Data != null) { Data.$destroy(); }
      if (F != null) { F.$destroy(); }
    }
  }

  
  /// \brief Returns the current file system options
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getFileSystemOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 223,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 221,
   FQN="clang::FileManager::getFileSystemOpts", NM="_ZN5clang11FileManager17getFileSystemOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager17getFileSystemOptsEv")
  //</editor-fold>
  public FileSystemOptions /*&*/ getFileSystemOpts() {
    return FileSystemOpts;
  }
  
    ////<editor-fold defaultstate="collapsed" desc="clang::FileManager::getFileSystemOpts">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 222,
//   FQN="clang::FileManager::getFileSystemOpts", NM="_ZNK5clang11FileManager17getFileSystemOptsEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang11FileManager17getFileSystemOptsEv")
//  //</editor-fold>
//  public /*const*/ FileSystemOptions /*&*/ getFileSystemOpts() /*const*/ {
//    return FileSystemOpts;
//  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getVirtualFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 224,
   FQN="clang::FileManager::getVirtualFileSystem", NM="_ZNK5clang11FileManager20getVirtualFileSystemEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang11FileManager20getVirtualFileSystemEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<FileSystem> getVirtualFileSystem() /*const*/ {
    return new IntrusiveRefCntPtr<FileSystem>(FS);
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public final FileSystem $getVirtualFileSystem() /*const*/ {
    return FS.$star();
  }

  
  /// \brief Retrieve a file entry for a "virtual" file that acts as
  /// if there were a file with the given name on disk.
  ///
  /// The file itself is not accessed.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getVirtualFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 321,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 319,
   FQN="clang::FileManager::getVirtualFile", NM="_ZN5clang11FileManager14getVirtualFileEN4llvm9StringRefEll",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager14getVirtualFileEN4llvm9StringRefEll")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getVirtualFile(StringRef Filename, long/*off_t*/ Size, 
                long/*time_t*/ ModificationTime) {
    FileData Data = null;
    try {
      ++NumFileLookups;
      
      // See if there is already an entry in the map.
      StringMapEntry<FileEntry /*P*/ > /*&*/ NamedFileEnt = SeenFileEntries.GetOrCreateValue(Filename, (FileEntry) null);
      
      // See if there is already an entry in the map.
      if ((NamedFileEnt.second != null) && NamedFileEnt.second != NON_EXISTENT_FILE) {
        return NamedFileEnt.second;
      }
      
      ++NumFileCacheMisses;
      
      // By default, initialize it to invalid.
      NamedFileEnt.second = NON_EXISTENT_FILE;
      
      addAncestorsAsVirtualDirs(Filename);
      FileEntry /*P*/ UFE = null;
      
      // Now that all ancestors of Filename are in the cache, the
      // following call is guaranteed to find the DirectoryEntry from the
      // cache.
      /*const*/ DirectoryEntry /*P*/ DirInfo = getDirectoryFromFile(/*Deref*/this, Filename, 
          /*CacheFailure=*/ true);
      assert ((DirInfo != null)) : "The directory of a virtual file should already be in the cache.";
      
      // Check to see if the file exists. If so, drop the virtual file
      Data/*J*/= new FileData();
      /*const*/char$ptr/*char P*/ InterndFileName = $noClone(NamedFileEnt.getKeyStr());
      /*JAVA PERF:*/int InterndFileNameLen = NamedFileEnt.getKeyLength();
      if (getStatValue(InterndFileName, InterndFileNameLen, Data, true, null) == false) {
        assert $eq_StringRef(Data.Name, new StringRef(InterndFileName, InterndFileNameLen)) : "virtual file path must be normalized " + Filename + " vs. " + Data;
        Data.Size = Size;
        Data.ModTime = ModificationTime;
        UFE = $AddrOf(UniqueRealFiles.$at(Data.UniqueID));
        
        NamedFileEnt.second = UFE;
        
        // If we had already opened this file, close it now so we don't
        // leak the descriptor. We're not going to use the file
        // descriptor anyway, since this is a virtual file.
        if (UFE.File.$bool()) {
          UFE.closeFile();
        }
        
        // If we already have an entry with this inode, return it.
        if (UFE.isValid()) {
          return UFE;
        }
        
        UFE.UniqueID.$assign(Data.UniqueID);
        UFE.IsNamedPipe = Data.IsNamedPipe;
        UFE.InPCH = Data.InPCH;
      }
      if (!(UFE != null)) {
        VirtualFileEntries.push_back_T$RR(llvm.make_unique(new FileEntry()));
        UFE = VirtualFileEntries.back().get();
        NamedFileEnt.second = UFE;
      }
      
      /*JAVA*/assert UFE.UID == INVALID_UID : "UID must be assigned only once " + UFE;
      UFE.Name = $noClone(InterndFileName);
      UFE.NameLen = InterndFileNameLen;
      UFE.Size = Size;
      UFE.ModTime = ModificationTime;
      UFE.Dir = DirInfo;
      UFE.UID = NextFileUID++;
      UFE.File.reset();
      // JAVA FIX: freeze UID, mark as Valid      
      UFE.IsValid = true;
      return UFE;
    } finally {
      if (Data != null) { Data.$destroy(); }
    }
  }

  
  /// \brief Open the specified file as a MemoryBuffer, returning a new
  /// MemoryBuffer if successful, otherwise returning null.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getBufferForFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 414,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 412,
   FQN="clang::FileManager::getBufferForFile", NM="_ZN5clang11FileManager16getBufferForFileEPKNS_9FileEntryEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager16getBufferForFileEPKNS_9FileEntryEbb")
  //</editor-fold>
  public ErrorOr<std.unique_ptr<MemoryBuffer> > getBufferForFile(/*const*/ FileEntry /*P*/ Entry) {
    return getBufferForFile(Entry, false, 
                  true);
  }
  public ErrorOr<std.unique_ptr<MemoryBuffer> > getBufferForFile(/*const*/ FileEntry /*P*/ Entry, boolean isVolatile/*= false*/) {
    return getBufferForFile(Entry, isVolatile, 
                  true);
  }
  public ErrorOr<std.unique_ptr<MemoryBuffer> > getBufferForFile(/*const*/ FileEntry /*P*/ Entry, boolean isVolatile/*= false*/, 
                  boolean ShouldCloseOpenFile/*= true*/) {
    SmallString/*128*/ FilePath = null;
    try {
      long/*uint64_t*/ FileSize = Entry.getSize();
      // If there's a high enough chance that the file have changed since we
      // got its size, force a stat before opening it.
      if (isVolatile) {
        FileSize = -1;
      }
      
      /*const*/char$ptr/*char P*/ Filename = $noClone(Entry.getName());
      // If the file is already open, use the open file descriptor.
      if (Entry.File.$bool()) {
        ErrorOr<unique_ptr<MemoryBuffer>> Result = Entry.File.$arrow().getBuffer(new Twine(Filename), FileSize, 
            /*RequiresNullTerminator=*/ true, isVolatile);
        // FIXME: we need a set of APIs that can make guarantees about whether a
        // FileEntry is open or not.
        if (ShouldCloseOpenFile) {
          Entry.closeFile();
        }
        return Result;
      }
      
      // Otherwise, open the file.
      if (FileSystemOpts.WorkingDir.empty()) {
        return FS.$arrow().getBufferForFile(new Twine(Filename), FileSize, 
            /*RequiresNullTerminator=*/ true, isVolatile);
      }
      
      FilePath/*J*/= new SmallString/*128*/(128, new StringRef(Entry.getName()));
      FixupRelativePath(FilePath);
      return FS.$arrow().getBufferForFile(new Twine(FilePath), FileSize, 
          /*RequiresNullTerminator=*/ true, isVolatile);
    } finally {
      if (FilePath != null) { FilePath.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getBufferForFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 448,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 446,
   FQN="clang::FileManager::getBufferForFile", NM="_ZN5clang11FileManager16getBufferForFileEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager16getBufferForFileEN4llvm9StringRefE")
  //</editor-fold>
  public ErrorOr<std.unique_ptr<MemoryBuffer> > getBufferForFile(StringRef Filename) {
    SmallString/*128*/ FilePath = null;
    try {
      if (FileSystemOpts.WorkingDir.empty()) {
        return FS.$arrow().getBufferForFile(new Twine(Filename));
      }
      
      FilePath/*J*/= new SmallString/*128*/(128, Filename);
      FixupRelativePath(FilePath);
      return FS.$arrow().getBufferForFile(new Twine(FilePath.c_str()));
    } finally {
      if (FilePath != null) { FilePath.$destroy(); }
    }
  }

  
  /// \brief Get the 'stat' information for the given \p Path.
  ///
  /// If the path is relative, it will be resolved against the WorkingDir of the
  /// FileManager's FileSystemOptions.
  ///
  /// \returns false on success, true on error.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getNoncachedStatValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 477,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 475,
   FQN="clang::FileManager::getNoncachedStatValue", NM="_ZN5clang11FileManager21getNoncachedStatValueEN4llvm9StringRefERNS_3vfs6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager21getNoncachedStatValueEN4llvm9StringRefERNS_3vfs6StatusE")
  //</editor-fold>
  public boolean getNoncachedStatValue(StringRef Path, 
                       Status /*&*/ Result) {
    SmallString/*128*/ FilePath = null;
    try {
      FilePath/*J*/= new SmallString/*128*/(128, Path);
      FixupRelativePath(FilePath);
      
      ErrorOr<Status> S = FS.$arrow().status(new Twine(FilePath.c_str()));
      if (!S.$bool()) {
        return true;
      }
      Result.$assign(S.$star());
      return false;
    } finally {
      if (FilePath != null) { FilePath.$destroy(); }
    }
  }

  
  /// \brief Remove the real file \p Entry from the cache.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::invalidateCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 489,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 487,
   FQN="clang::FileManager::invalidateCache", NM="_ZN5clang11FileManager15invalidateCacheEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager15invalidateCacheEPKNS_9FileEntryE")
  //</editor-fold>
  public void invalidateCache(/*const*/ FileEntry /*P*/ Entry) {
    assert ((Entry != null)) : "Cannot invalidate a NULL FileEntry";
    
    SeenFileEntries.erase(new StringRef(Entry.getName()));
    
    // FileEntry invalidation should not block future optimizations in the file
    // caches. Possible alternatives are cache truncation (invalidate last N) or
    // invalidation of the whole cache.
    UniqueRealFiles.erase(Entry.getUniqueID());
  }

  
  /// \brief If path is not absolute and FileSystemOptions set the working
  /// directory, the path is modified to be relative to the given
  /// working directory.
  /// \returns true if \c path changed.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::FixupRelativePath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 390,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 388,
   FQN="clang::FileManager::FixupRelativePath", NM="_ZNK5clang11FileManager17FixupRelativePathERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang11FileManager17FixupRelativePathERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  public boolean FixupRelativePath(SmallVectorImplChar/*&*/ path) /*const*/ {
    StringRef pathRef/*J*/= new StringRef(path.data(), path.size());
    if (FileSystemOpts.WorkingDir.empty()
       || org.llvm.support.sys.path.is_absolute(pathRef)) {
      return false;
    }
    
    SmallString/*128*/ NewPath/*J*/= new SmallString/*128*/(128, new StringRef(FileSystemOpts.WorkingDir));
    org.llvm.support.sys.path.append(NewPath, pathRef);
    path.$assign(NewPath);
    return true;
  }

  /// Makes \c Path absolute taking into account FileSystemOptions and the
  /// working directory option.
  /// \returns true if \c Path changed to absolute.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::makeAbsolutePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 403,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 401,
   FQN="clang::FileManager::makeAbsolutePath", NM="_ZNK5clang11FileManager16makeAbsolutePathERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang11FileManager16makeAbsolutePathERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  public boolean makeAbsolutePath(SmallString/*&*/ Path) /*const*/ {
    boolean Changed = FixupRelativePath(Path);
    if (!path.is_absolute(new Twine(new StringRef(Path.data(), Path.size())))) {
      fs.make_absolute(Path);
      Changed = true;
    }

    return Changed;
  }
  
  /// \brief Produce an array mapping from the unique IDs assigned to each
  /// file to the corresponding FileEntry pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::GetUniqueIDMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 501,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 499,
   FQN="clang::FileManager::GetUniqueIDMapping", NM="_ZNK5clang11FileManager18GetUniqueIDMappingERN4llvm15SmallVectorImplIPKNS_9FileEntryEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang11FileManager18GetUniqueIDMappingERN4llvm15SmallVectorImplIPKNS_9FileEntryEEE")
  //</editor-fold>
  public void GetUniqueIDMapping(SmallVectorImpl</*const*/ FileEntry /*P*/ > /*&*/ UIDToFiles) /*const*/ {
    UIDToFiles.clear();
    UIDToFiles.resize(NextFileUID);
    
    // Map file entries
    for (StringMapIterator<FileEntry /*P*//* , BumpPtrAllocator*/> FE = SeenFileEntries.begin(), FEEnd = SeenFileEntries.end();
         FE.$noteq(FEEnd); FE.$preInc())  {
      if ((FE.$arrow().getValue() != null) && FE.$arrow().getValue() != NON_EXISTENT_FILE) {
        UIDToFiles.$set(FE.$arrow().getValue().getUID(), FE.$arrow().getValue());
      }
    }
    
    // Map virtual file entries
    for (/*const*/unique_ptr<FileEntry>/*&*/ VFE : VirtualFileEntries)  {
      if (VFE.$bool() && VFE.get() != NON_EXISTENT_FILE) {
        UIDToFiles.$set(VFE.$arrow().getUID(), VFE.get());
      }
    }
  }

  
  /// \brief Modifies the size and modification time of a previously created
  /// FileEntry. Use with caution.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::modifyFileEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 519,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 517,
   FQN="clang::FileManager::modifyFileEntry", NM="_ZN5clang11FileManager15modifyFileEntryEPNS_9FileEntryEll",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager15modifyFileEntryEPNS_9FileEntryEll")
  //</editor-fold>
  public static void modifyFileEntry(FileEntry /*P*/ File, 
                 long/*off_t*/ Size, long/*time_t*/ ModificationTime) {
    File.Size = Size;
    File.ModTime = ModificationTime;
  }

  
  /// \brief Retrieve the canonical name for a given directory.
  ///
  /// This is a very expensive operation, despite its results being cached,
  /// and should only be used when the physical layout of the file system is
  /// required, which is (almost) never.
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::getCanonicalName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 525,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 523,
   FQN="clang::FileManager::getCanonicalName", NM="_ZN5clang11FileManager16getCanonicalNameEPKNS_14DirectoryEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang11FileManager16getCanonicalNameEPKNS_14DirectoryEntryE")
  //</editor-fold>
  public StringRef getCanonicalName(/*const*/ DirectoryEntry /*P*/ Dir) {
    // FIXME: use llvm::sys::fs::canonical() when it gets implemented
    DenseMapIterator</*const*/ DirectoryEntry /*P*/ , StringRef> Known = CanonicalDirNames.find(Dir);
    if (Known.$noteq(CanonicalDirNames.end())) {
      return Known.$star().second;
    }

    StringRef CanonicalName/*J*/= new StringRef(Dir.getName(), Dir.getNameLen());
    /*char*/byte CanonicalNameBuf[/*4096*/] = new$char(4096);
    if ((realpath(Dir.getName(), CanonicalNameBuf) != null)) {
      CanonicalName.$assignMove(new StringRef(CanonicalNameBuf).copy(CanonicalNameStorage));
    }

    CanonicalDirNames.insert(std.make_pair(Dir, CanonicalName));
    return CanonicalName;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileManager::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", line = 556,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp", old_line = 554,
   FQN="clang::FileManager::PrintStats", NM="_ZNK5clang11FileManager10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang11FileManager10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() /*const*/ {
    llvm.errs().$out($("\n*** File Manager Stats:\n"));
    llvm.errs().$out_ulong(UniqueRealFiles.size()).$out($(" real files found, ")).$out_ulong(UniqueRealDirs.size()).$out($(" real dirs found.\n"));
    llvm.errs().$out_ulong(VirtualFileEntries.size()).$out($(" virtual files found, ")).$out_ulong(VirtualDirectoryEntries.size()).$out($(" virtual dirs found.\n"));
    llvm.errs().$out_uint(NumDirLookups).$out($(" dir lookups, ")).$out_uint(NumDirCacheMisses).$out($(" dir cache misses.\n"));
    llvm.errs().$out_uint(NumFileLookups).$out($(" file lookups, ")).$out_uint(NumFileCacheMisses).$out($(" file cache misses.\n"));
    //llvm::errs() << PagesMapped << BytesOfPagesMapped << FSLookups;
  }

  
  public String toString() {
    return "" + "FS=" + FS // NOI18N
              + ", FileSystemOpts=" + FileSystemOpts // NOI18N
              + ", UniqueRealDirs=" + UniqueRealDirs // NOI18N
              + ", UniqueRealFiles=" + UniqueRealFiles // NOI18N
              + ", VirtualDirectoryEntries=" + VirtualDirectoryEntries // NOI18N
              + ", VirtualFileEntries=" + VirtualFileEntries // NOI18N
              + ", SeenDirEntries=" + SeenDirEntries // NOI18N
              + ", SeenFileEntries=" + SeenFileEntries // NOI18N
              + ", CanonicalDirNames=" + CanonicalDirNames // NOI18N
              + ", CanonicalNameStorage=" + CanonicalNameStorage // NOI18N
              + ", NextFileUID=" + NextFileUID // NOI18N
              + ", NumDirLookups=" + NumDirLookups // NOI18N
              + ", NumFileLookups=" + NumFileLookups // NOI18N
              + ", NumDirCacheMisses=" + NumDirCacheMisses // NOI18N
              + ", NumFileCacheMisses=" + NumFileCacheMisses // NOI18N
              + ", StatCache=" + StatCache // NOI18N
              + super.toString(); // NOI18N
  }
}
