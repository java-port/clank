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

package org.clang.lex;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.lex.llvm.HeaderFileInfoVector;
import org.clang.basic.target.TargetInfo;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.directory_iterator;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;
import static org.clang.lex.impl.HeaderSearchStatics.*;
import org.clang.lex.llvm.SmallVectorPtrPairFileEntryDirectoryEntry;
import static org.clank.support.Native.$eq_ptr;
import org.llvm.adt.HashingGlobals.hash_code;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.HashingGlobals.hash_combine;


/// \brief Encapsulates the information needed to find the file referenced
/// by a \#include or \#include_next, (sub-)framework lookup, etc.
//<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 137,
 FQN="clang::HeaderSearch", NM="_ZN5clang12HeaderSearchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearchE")
//</editor-fold>
public class HeaderSearch implements Destructors.ClassWithDestructor {
  /// This structure is used to record entries in our framework cache.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::FrameworkCacheEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 139,
   FQN="clang::HeaderSearch::FrameworkCacheEntry", NM="_ZN5clang12HeaderSearch19FrameworkCacheEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19FrameworkCacheEntryE")
  //</editor-fold>
  /*friend*/ static class/*struct*/ FrameworkCacheEntry implements NativeCloneable<FrameworkCacheEntry> {
    /// The directory entry which should be used for the cached framework.
    public /*const*/DirectoryEntry /*P*/ Directory;
    
    // JAVA: default constructor
    public FrameworkCacheEntry() {
      this.Directory = null;
      this.IsUserSpecifiedSystemFramework = false;
    }
    
    /// Whether this framework has been "user-specified" to be treated as if it
    /// were a system framework (even if it was found outside a system framework
    /// directory).
    public boolean IsUserSpecifiedSystemFramework;
    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::FrameworkCacheEntry::FrameworkCacheEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 139,
     FQN="clang::HeaderSearch::FrameworkCacheEntry::FrameworkCacheEntry", NM="_ZN5clang12HeaderSearch19FrameworkCacheEntryC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19FrameworkCacheEntryC1ERKS1_")
    //</editor-fold>
    public /*inline*/ FrameworkCacheEntry(/*const*/ FrameworkCacheEntry /*&*/ $Prm0) {
      /* : Directory(.Directory), IsUserSpecifiedSystemFramework(.IsUserSpecifiedSystemFramework)*/ 
      //START JInit
      this.Directory = $Prm0.Directory;
      this.IsUserSpecifiedSystemFramework = $Prm0.IsUserSpecifiedSystemFramework;
      //END JInit
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::FrameworkCacheEntry::FrameworkCacheEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 139,
     FQN="clang::HeaderSearch::FrameworkCacheEntry::FrameworkCacheEntry", NM="_ZN5clang12HeaderSearch19FrameworkCacheEntryC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19FrameworkCacheEntryC1EOS1_")
    //</editor-fold>
    public /*inline*/ FrameworkCacheEntry(JD$Move _dparam, FrameworkCacheEntry /*&&*/$Prm0) {
      /* : Directory(static_cast<FrameworkCacheEntry &&>().Directory), IsUserSpecifiedSystemFramework(static_cast<FrameworkCacheEntry &&>().IsUserSpecifiedSystemFramework)*/ 
      //START JInit
      this.Directory = $Prm0.Directory;
      this.IsUserSpecifiedSystemFramework = $Prm0.IsUserSpecifiedSystemFramework;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::FrameworkCacheEntry::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 139,
     FQN = "clang::HeaderSearch::FrameworkCacheEntry::operator=", NM = "_ZN5clang12HeaderSearch19FrameworkCacheEntryaSERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19FrameworkCacheEntryaSERKS1_")
    //</editor-fold>
    public /*inline*/ FrameworkCacheEntry /*&*/ $assign(/*const*/FrameworkCacheEntry /*&*/ $Prm0)/* throw()*/ {
      this.Directory = $Prm0.Directory;
      this.IsUserSpecifiedSystemFramework = $Prm0.IsUserSpecifiedSystemFramework;
      return /*Deref*/this;
    }

    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public FrameworkCacheEntry clone() {
      return new FrameworkCacheEntry(this);
    }

    @Override
    public String toString() {
      return "" + "Directory=" + Directory // NOI18N
                + ", IsUserSpecifiedSystemFramework=" + IsUserSpecifiedSystemFramework; // NOI18N
    }
  };
  
  /// \brief Header-search options used to initialize this header search.
  private IntrusiveRefCntPtr<HeaderSearchOptions> HSOpts;
  
  private DiagnosticsEngine /*&*/ Diags;
  private FileManager /*&*/ FileMgr;
  /// \#include search path information.  Requests for \#include "x" search the
  /// directory of the \#including file first, then each directory in SearchDirs
  /// consecutively. Requests for <x> search the current dir first, then each
  /// directory in SearchDirs, starting at AngledDirIdx, consecutively.  If
  /// NoCurDirSearch is true, then the check for the file in the current
  /// directory is suppressed.
  private std.vector<DirectoryLookup> SearchDirs;
  private /*uint*/int AngledDirIdx;
  private /*uint*/int SystemDirIdx;
  private boolean NoCurDirSearch;
  
  /// \brief \#include prefixes for which the 'system header' property is
  /// overridden.
  ///
  /// For a \#include "x" or \#include \<x> directive, the last string in this
  /// list which is a prefix of 'x' determines whether the file is treated as
  /// a system header.
  private std.vector<std.pairTypeBool<std.string>> SystemHeaderPrefixes;
  
  /// \brief The path to the module cache.
  private std.string ModuleCachePath;
  
  /// \brief All of the preprocessor-specific data about files that are
  /// included, indexed by the FileEntry's UID.
  private /*mutable */HeaderFileInfoVector/*std.vector<HeaderFileInfo>*/ FileInfo;
  public static final String REUSE_HEADER_FILE_INFOS_PROP = "clang.header.file.infos.reuse";
  public static final boolean REUSE_HEADER_FILE_INFOS = Boolean.valueOf(System.getProperty(REUSE_HEADER_FILE_INFOS_PROP, "true"));
  
  /// Keeps track of each lookup performed by LookupFile.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LookupFileCacheInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 181,
   FQN="clang::HeaderSearch::LookupFileCacheInfo", NM="_ZN5clang12HeaderSearch19LookupFileCacheInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19LookupFileCacheInfoE")
  //</editor-fold>
  private static class/*struct*/ LookupFileCacheInfo implements NativeCloneable<LookupFileCacheInfo> {
    /// Starting index in SearchDirs that the cached search was performed from.
    /// If there is a hit and this value doesn't match the current query, the
    /// cache has to be ignored.
    public /*uint*/int StartIdx;
    /// The entry in SearchDirs that satisfied the query.
    public /*uint*/int HitIdx;
    /// This is non-null if the original filename was mapped to a framework
    /// include via a headermap.
    public /*const*/char$ptr/*char P*/ MappedName;

    /// Default constructor -- Initialize all members with zero.
    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LookupFileCacheInfo::LookupFileCacheInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 193,
     FQN="clang::HeaderSearch::LookupFileCacheInfo::LookupFileCacheInfo", NM="_ZN5clang12HeaderSearch19LookupFileCacheInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19LookupFileCacheInfoC1Ev")
    //</editor-fold>
    public LookupFileCacheInfo() {
      /* : StartIdx(0), HitIdx(0), MappedName(null)*/ 
      //START JInit
      this.StartIdx = 0;
      this.HitIdx = 0;
      this.MappedName = null;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LookupFileCacheInfo::reset">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 195,
     FQN="clang::HeaderSearch::LookupFileCacheInfo::reset", NM="_ZN5clang12HeaderSearch19LookupFileCacheInfo5resetEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19LookupFileCacheInfo5resetEj")
    //</editor-fold>
    public void reset(/*uint*/int StartIdx) {
      this.StartIdx = StartIdx;
      this.MappedName = null;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LookupFileCacheInfo::LookupFileCacheInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 181,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 193,
     FQN="clang::HeaderSearch::LookupFileCacheInfo::LookupFileCacheInfo", NM="_ZN5clang12HeaderSearch19LookupFileCacheInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19LookupFileCacheInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ LookupFileCacheInfo(/*const*/ LookupFileCacheInfo /*&*/ $Prm0) {
      /* : StartIdx(.StartIdx), HitIdx(.HitIdx), MappedName(.MappedName)*/ 
      //START JInit
      this.StartIdx = $Prm0.StartIdx;
      this.HitIdx = $Prm0.HitIdx;
      this.MappedName = $tryClone($Prm0.MappedName);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LookupFileCacheInfo::LookupFileCacheInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 181,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 193,
     FQN="clang::HeaderSearch::LookupFileCacheInfo::LookupFileCacheInfo", NM="_ZN5clang12HeaderSearch19LookupFileCacheInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19LookupFileCacheInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ LookupFileCacheInfo(JD$Move _dparam, LookupFileCacheInfo /*&&*/$Prm0) {
      /* : StartIdx(static_cast<LookupFileCacheInfo &&>().StartIdx), HitIdx(static_cast<LookupFileCacheInfo &&>().HitIdx), MappedName(static_cast<LookupFileCacheInfo &&>().MappedName)*/ 
      //START JInit
      this.StartIdx = $Prm0.StartIdx;
      this.HitIdx = $Prm0.HitIdx;
      this.MappedName = $tryClone($Prm0.MappedName);
      //END JInit
    }

    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public LookupFileCacheInfo clone() {
      return new LookupFileCacheInfo(this);
    }

    public String toString() {
      return "" + "StartIdx=" + StartIdx // NOI18N
                + ", HitIdx=" + HitIdx // NOI18N
                + ", MappedName=" + MappedName; // NOI18N
    }
  };
  private StringMap<LookupFileCacheInfo/*, BumpPtrAllocator*/> LookupFileCache;
  
  /// \brief Collection mapping a framework or subframework
  /// name like "Carbon" to the Carbon.framework directory.
  private StringMap<FrameworkCacheEntry/*, BumpPtrAllocator*/> FrameworkMap;
  
  /// IncludeAliases - maps include file names (including the quotes or
  /// angle brackets) to other include file names.  This is used to support the
  /// include_alias pragma for Microsoft compatibility.
  /*typedef llvm::StringMap<std::string, llvm::BumpPtrAllocator> IncludeAliasMap*/
//  public final class IncludeAliasMap extends StringMap<std.string, BumpPtrAllocatorImpl>{ };
  private std.unique_ptr<StringMap<std.string/*, BumpPtrAllocator*/> > IncludeAliases;
  
  /// HeaderMaps - This is a mapping from FileEntry -> HeaderMap, uniquing
  /// headermaps.  This vector owns the headermap.
  private std.vector<std.pair</*const*/ FileEntry /*P*/ , /*const*/ HeaderMap /*P*/ > > HeaderMaps;
  
  /// \brief The mapping between modules and headers.
  private /*mutable */ModuleMap ModMap;
  
  /// \brief Describes whether a given directory has a module map in it.
  private DenseMapTypeBool</*const*/ DirectoryEntry /*P*/> DirectoryHasModuleMap;
  
  /// \brief Set of module map files we've already loaded, and a flag indicating
  /// whether they were valid or not.
  private DenseMapTypeBool</*const*/ FileEntry /*P*/> LoadedModuleMaps;
  
  /// \brief Uniqued set of framework names, which is used to track which 
  /// headers were included as framework headers.
  private StringSet/*BumpPtrAllocatorImpl*/ FrameworkNames;
  
  /// \brief Entity used to resolve the identifier IDs of controlling
  /// macros into IdentifierInfo pointers, and keep the identifire up to date,
  /// as needed.
  private ExternalPreprocessorSource /*P*/ ExternalLookup;
  
  /// \brief Entity used to look up stored header file information.
  private ExternalHeaderFileInfoSource /*P*/ ExternalSource;
  
  // Various statistics we track for performance analysis.
  private /*uint*/int NumIncluded;
  private /*uint*/int NumMultiIncludeFileOptzn;
  private /*uint*/int NumFrameworkLookups;
  private /*uint*/int NumSubFrameworkLookups;
  
  // HeaderSearch doesn't support default or copy construction.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::HeaderSearch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 245,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 247,
   FQN="clang::HeaderSearch::HeaderSearch", NM="_ZN5clang12HeaderSearchC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearchC1ERKS0_")
  //</editor-fold>
  private HeaderSearch(/*const*/ HeaderSearch /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 246,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 248,
   FQN="clang::HeaderSearch::operator=", NM="_ZN5clang12HeaderSearchaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearchaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ HeaderSearch /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /*friend  class DirectoryLookup*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::HeaderSearch">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 55,
   FQN="clang::HeaderSearch::HeaderSearch", NM="_ZN5clang12HeaderSearchC1EN4llvm18IntrusiveRefCntPtrINS_19HeaderSearchOptionsEEERNS_13SourceManagerERNS_17DiagnosticsEngineERKNS_11LangOptionsEPKNS_10TargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearchC1EN4llvm18IntrusiveRefCntPtrINS_19HeaderSearchOptionsEEERNS_13SourceManagerERNS_17DiagnosticsEngineERKNS_11LangOptionsEPKNS_10TargetInfoE")
  //</editor-fold>
  public HeaderSearch(IntrusiveRefCntPtr<HeaderSearchOptions> HSOpts, 
      SourceManager /*&*/ SourceMgr, DiagnosticsEngine /*&*/ Diags, 
      /*const*/ LangOptions /*&*/ LangOpts, 
      /*const*/ TargetInfo /*P*/ Target) {
    /* : HSOpts(std::move(HSOpts)), Diags(Diags), FileMgr(SourceMgr.getFileManager()), SearchDirs(), SystemHeaderPrefixes(), ModuleCachePath(), FileInfo(), LookupFileCache(), FrameworkMap(64), IncludeAliases(), HeaderMaps(), ModMap(SourceMgr, Diags, LangOpts, Target, *this), DirectoryHasModuleMap(), LoadedModuleMaps(), FrameworkNames()*/ 
    //START JInit
    this.HSOpts = new IntrusiveRefCntPtr<HeaderSearchOptions>(JD$Move.INSTANCE, std.move(HSOpts));
    this./*&*/Diags=/*&*/Diags;
    this./*&*/FileMgr=/*&*/SourceMgr.getFileManager();
    this.SearchDirs = new std.vector<DirectoryLookup>(DirectoryLookup.DEFAULT);
    this.SystemHeaderPrefixes = new std.vector<std.pairTypeBool<std.string>>(new std.pairTypeBool<std.string>(new std.string(), false));
    this.ModuleCachePath = new std.string();
    this.FileInfo = HeaderFileInfoVector.$create();
    this.LookupFileCache = new StringMap<LookupFileCacheInfo/*, BumpPtrAllocator*/>(new LookupFileCacheInfo());
    this.FrameworkMap = new StringMap<FrameworkCacheEntry/*, BumpPtrAllocator*/>(64, new FrameworkCacheEntry());
    this.IncludeAliases = new std.unique_ptr<StringMap<std.string/*, BumpPtrAllocator*/> >();
    this.HeaderMaps = new std.vector<std.pair</*const*/ FileEntry /*P*/ , /*const*/ HeaderMap /*P*/ > >((std.pair</*const*/ FileEntry /*P*/ , /*const*/ HeaderMap /*P*/ >)null);
    this.ModMap = new ModuleMap(SourceMgr, Diags, LangOpts, Target, /*Deref*/this);
    this.DirectoryHasModuleMap = new DenseMapTypeBool</*const*/ DirectoryEntry /*P*/>(DenseMapInfo$LikePtr.$Info(), false);
    this.LoadedModuleMaps = new DenseMapTypeBool</*const*/ FileEntry /*P*/>(FileEntry.DMI$FileEntryPtr, false);
    this.FrameworkNames = new StringSet/*BumpPtrAllocatorImpl*/();
    //END JInit
    AngledDirIdx = 0;
    SystemDirIdx = 0;
    NoCurDirSearch = false;

    ExternalLookup = null;
    ExternalSource = null;
    NumIncluded = 0;
    NumMultiIncludeFileOptzn = 0;
    NumFrameworkLookups = NumSubFrameworkLookups = 0;
  }

//<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::~HeaderSearch">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 73,
   FQN="clang::HeaderSearch::~HeaderSearch", NM="_ZN5clang12HeaderSearchD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearchD0Ev")
//</editor-fold>
public void $destroy() {
  // Delete headermaps.
  for (/*uint*/int i = 0, e = HeaderMaps.size(); i != e; ++i)  {
    if (HeaderMaps.$at(i).second != null) { HeaderMaps.$at(i).second.$destroy();};
  }
  //START JDestroy
  FrameworkNames.$destroy();
  LoadedModuleMaps.$destroy();
  DirectoryHasModuleMap.$destroy();
  ModMap.$destroy();
  HeaderMaps.$destroy();
  IncludeAliases.$destroy();
  FrameworkMap.$destroy();
  LookupFileCache.$destroy();
  HeaderFileInfoVector.$release(FileInfo); FileInfo = null; // PERF: release and nullify  
  ModuleCachePath.$destroy();
  SystemHeaderPrefixes.$destroy();
  SearchDirs.$destroy();
  HSOpts.$destroy();
  //END JDestroy
}

  
  /// \brief Retrieve the header-search options with which this header search
  /// was initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getHeaderSearchOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 258,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 260,
   FQN="clang::HeaderSearch::getHeaderSearchOpts", NM="_ZNK5clang12HeaderSearch19getHeaderSearchOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch19getHeaderSearchOptsEv")
  //</editor-fold>
  public HeaderSearchOptions /*&*/ getHeaderSearchOpts() /*const*/ {
    return HSOpts.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getFileMgr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 260,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 262,
   FQN="clang::HeaderSearch::getFileMgr", NM="_ZNK5clang12HeaderSearch10getFileMgrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch10getFileMgrEv")
  //</editor-fold>
  public FileManager /*&*/ getFileMgr() /*const*/ {
    return FileMgr;
  }

  
  /// \brief Interface for setting the file search paths.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::SetSearchPaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 263,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 265,
   FQN="clang::HeaderSearch::SetSearchPaths", NM="_ZN5clang12HeaderSearch14SetSearchPathsERKSt6vectorINS_15DirectoryLookupESaIS2_EEjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch14SetSearchPathsERKSt6vectorINS_15DirectoryLookupESaIS2_EEjjb")
  //</editor-fold>
  public void SetSearchPaths(/*const*/std.vector<DirectoryLookup> /*&*/ dirs, 
          /*uint*/int angledDirIdx, /*uint*/int systemDirIdx, 
          boolean noCurDirSearch) {
    assert ($lesseq_uint(angledDirIdx, systemDirIdx) && $lesseq_uint(systemDirIdx, dirs.size())) : "Directory indicies are unordered";
    SearchDirs.$assign(dirs);
    AngledDirIdx = angledDirIdx;
    SystemDirIdx = systemDirIdx;
    NoCurDirSearch = noCurDirSearch;
    //LookupFileCache.clear();
  }

  
  /// \brief Add an additional search path.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::AddSearchPath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 276,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 278,
   FQN="clang::HeaderSearch::AddSearchPath", NM="_ZN5clang12HeaderSearch13AddSearchPathERKNS_15DirectoryLookupEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch13AddSearchPathERKNS_15DirectoryLookupEb")
  //</editor-fold>
  public void AddSearchPath(/*const*/DirectoryLookup /*&*/ dir, boolean isAngled) {
    /*uint*/int idx = isAngled ? SystemDirIdx : AngledDirIdx;
    SearchDirs.insert(SearchDirs.begin().$add(idx), dir);
    if (!isAngled) {
      AngledDirIdx++;
    }
    SystemDirIdx++;
  }

  
  /// \brief Set the list of system header prefixes.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::SetSystemHeaderPrefixes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 285,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 287,
   FQN="clang::HeaderSearch::SetSystemHeaderPrefixes", NM="_ZN5clang12HeaderSearch23SetSystemHeaderPrefixesEN4llvm8ArrayRefISt4pairISsbEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch23SetSystemHeaderPrefixesEN4llvm8ArrayRefISt4pairISsbEEE")
  //</editor-fold>
  public void SetSystemHeaderPrefixes(ArrayRef<std.pairTypeBool<std.string> > P) {
    SystemHeaderPrefixes.assign$T(P.begin(), P.end());
  }

  
/// \brief Checks whether the map exists or not.
//<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::HasIncludeAliasMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 290,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 292,
   FQN="clang::HeaderSearch::HasIncludeAliasMap", NM="_ZNK5clang12HeaderSearch18HasIncludeAliasMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch18HasIncludeAliasMapEv")
//</editor-fold>
public boolean HasIncludeAliasMap() /*const*/ {
  return (boolean)IncludeAliases.$bool();
}

  
  /// \brief Map the source include name to the dest include name.
  ///
  /// The Source should include the angle brackets or quotes, the dest 
  /// should not.  This allows for distinction between <> and "" headers.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::AddIncludeAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 296,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 298,
   FQN="clang::HeaderSearch::AddIncludeAlias", NM="_ZN5clang12HeaderSearch15AddIncludeAliasEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch15AddIncludeAliasEN4llvm9StringRefES2_")
  //</editor-fold>
  public void AddIncludeAlias(StringRef Source, StringRef Dest) {
    if (!IncludeAliases.$bool()) {
      IncludeAliases.reset(new StringMap<std.string/*, BumpPtrAllocator*/>(std.string.EMPTY));
    }
    (IncludeAliases.$star()).$at(/*NO_COPY*/Source).$assignMove(Dest.$string());
  }

  
  /// MapHeaderToIncludeAlias - Maps one header file name to a different header
  /// file name, for use with the include_alias pragma.  Note that the source
  /// file name should include the angle brackets or quotes.  Returns StringRef
  /// as null if the header cannot be mapped.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::MapHeaderToIncludeAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 306,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 308,
   FQN="clang::HeaderSearch::MapHeaderToIncludeAlias", NM="_ZN5clang12HeaderSearch23MapHeaderToIncludeAliasEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch23MapHeaderToIncludeAliasEN4llvm9StringRefE")
  //</editor-fold>
  public StringRef MapHeaderToIncludeAlias(StringRef Source) {
    assert (IncludeAliases.$bool()) : "Trying to map headers when there's no map";
    
    // Do any filename replacements before anything else
    StringMapIterator<std.string/*, BumpPtrAllocator*/> Iter = IncludeAliases.$arrow().find(/*NO_COPY*/Source);
    if (Iter.$noteq(IncludeAliases.$arrow().end())) {
      return new StringRef(Iter.$arrow().second);
    }
    return new StringRef();
  }

  
  /// \brief Set the path to the module cache.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::setModuleCachePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 319,
   FQN="clang::HeaderSearch::setModuleCachePath", NM="_ZN5clang12HeaderSearch18setModuleCachePathEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch18setModuleCachePathEN4llvm9StringRefE")
  //</editor-fold>
  public void setModuleCachePath(StringRef CachePath) {
    ModuleCachePath.$assignMove(CachePath.$string());
  }

  
  /// \brief Retrieve the path to the module cache.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getModuleCachePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 322,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 324,
   FQN="clang::HeaderSearch::getModuleCachePath", NM="_ZNK5clang12HeaderSearch18getModuleCachePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch18getModuleCachePathEv")
  //</editor-fold>
  public StringRef getModuleCachePath() /*const*/ {
    return new StringRef(ModuleCachePath);
  }

  
  /// \brief Consider modules when including files from this directory.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::setDirectoryHasModuleMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 325,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 327,
   FQN="clang::HeaderSearch::setDirectoryHasModuleMap", NM="_ZN5clang12HeaderSearch24setDirectoryHasModuleMapEPKNS_14DirectoryEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch24setDirectoryHasModuleMapEPKNS_14DirectoryEntryE")
  //</editor-fold>
  public void setDirectoryHasModuleMap(/*const*/ DirectoryEntry /*P*/ Dir) {
    DirectoryHasModuleMap.$set(Dir, true);
  }

  
  /// \brief Forget everything we know about headers so far.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::ClearFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 330,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 332,
   FQN="clang::HeaderSearch::ClearFileInfo", NM="_ZN5clang12HeaderSearch13ClearFileInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch13ClearFileInfoEv")
  //</editor-fold>
  public void ClearFileInfo() {
    FileInfo.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::SetExternalLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 334,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 336,
   FQN="clang::HeaderSearch::SetExternalLookup", NM="_ZN5clang12HeaderSearch17SetExternalLookupEPNS_26ExternalPreprocessorSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch17SetExternalLookupEPNS_26ExternalPreprocessorSourceE")
  //</editor-fold>
  public void SetExternalLookup(ExternalPreprocessorSource /*P*/ EPS) {
    ExternalLookup = EPS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getExternalLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 338,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 340,
   FQN="clang::HeaderSearch::getExternalLookup", NM="_ZNK5clang12HeaderSearch17getExternalLookupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch17getExternalLookupEv")
  //</editor-fold>
  public ExternalPreprocessorSource /*P*/ getExternalLookup() /*const*/ {
    return ExternalLookup;
  }

  
  /// \brief Set the external source of header information.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::SetExternalSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 345,
   FQN="clang::HeaderSearch::SetExternalSource", NM="_ZN5clang12HeaderSearch17SetExternalSourceEPNS_28ExternalHeaderFileInfoSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch17SetExternalSourceEPNS_28ExternalHeaderFileInfoSourceE")
  //</editor-fold>
  public void SetExternalSource(ExternalHeaderFileInfoSource /*P*/ ES) {
    ExternalSource = ES;
  }

  
  /// \brief Set the target information for the header search, if not
  /// already known.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::setTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 531,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 529,
   FQN="clang::HeaderSearch::setTarget", NM="_ZN5clang12HeaderSearch9setTargetERKNS_10TargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch9setTargetERKNS_10TargetInfoE")
  //</editor-fold>
  public void setTarget(/*const*/ TargetInfo /*&*/ Target) {
    ModMap.setTarget(Target);
  }

  
  /// \brief Given a "foo" or \<foo> reference, look up the indicated file,
  /// return null on failure.
  ///
  /// \returns If successful, this returns 'UsedDir', the DirectoryLookup member
  /// the file was found in, or null if not applicable.
  ///
  /// \param IncludeLoc Used for diagnostics if valid.
  ///
  /// \param isAngled indicates whether the file reference is a <> reference.
  ///
  /// \param CurDir If non-null, the file was found in the specified directory
  /// search location.  This is used to implement \#include_next.
  ///
  /// \param Includers Indicates where the \#including file(s) are, in case
  /// relative searches are needed. In reverse order of inclusion.
  ///
  /// \param SearchPath If non-null, will be set to the search path relative
  /// to which the file was found. If the include path is absolute, SearchPath
  /// will be set to an empty string.
  ///
  /// \param RelativePath If non-null, will be set to the path relative to
  /// SearchPath at which the file was found. This only differs from the
  /// Filename for framework includes.
  ///
  /// \param SuggestedModule If non-null, and the file found is semantically
  /// part of a known module, this will be set to the module that should
  /// be imported instead of preprocessing/parsing the file found.

  /// LookupFile - Given a "foo" or \<foo> reference, look up the indicated file,
  /// return null on failure.  isAngled indicates whether the file reference is
  /// for system \#include's or not (i.e. using <> instead of ""). Includers, if
  /// non-empty, indicates where the \#including file(s) are, in case a relative
  /// search is needed. Microsoft mode will pass all \#including files.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LookupFile">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 566,
   FQN="clang::HeaderSearch::LookupFile", NM="_ZN5clang12HeaderSearch10LookupFileEN4llvm9StringRefENS_14SourceLocationEbPKNS_15DirectoryLookupERS6_NS1_8ArrayRefISt4pairIPKNS_9FileEntryEPKNS_14DirectoryEntryEEEEPNS1_15SmallVectorImplIcEESK_PNS_6ModuleEPNS_9ModuleMap11KnownHeaderEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch10LookupFileEN4llvm9StringRefENS_14SourceLocationEbPKNS_15DirectoryLookupERS6_NS1_8ArrayRefISt4pairIPKNS_9FileEntryEPKNS_14DirectoryEntryEEEEPNS1_15SmallVectorImplIcEESK_PNS_6ModuleEPNS_9ModuleMap11KnownHeaderEbb")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ LookupFile(StringRef Filename, SourceLocation IncludeLoc, boolean isAngled, 
            /*const*/type$ptr<DirectoryLookup> /*P*/ FromDir, /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ /*&*/ CurDir, 
            SmallVectorPtrPairFileEntryDirectoryEntry Includers, 
            SmallString/*P*/ SearchPath, SmallString/*P*/ RelativePath, 
            Module /*P*/ RequestingModule, ModuleMap.KnownHeader /*P*/ SuggestedModule) {
    return LookupFile(Filename, IncludeLoc, isAngled, 
            FromDir, CurDir, 
            Includers, 
            SearchPath, RelativePath, 
            RequestingModule, SuggestedModule, 
            false, false);
  }
  public /*const*/ FileEntry /*P*/ LookupFile(StringRef Filename, SourceLocation IncludeLoc, boolean isAngled, 
            /*const*/type$ptr<DirectoryLookup> /*P*/ FromDir, /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ /*&*/ CurDir, 
            SmallVectorPtrPairFileEntryDirectoryEntry Includers, 
            SmallString/*P*/ SearchPath, SmallString/*P*/ RelativePath, 
            Module /*P*/ RequestingModule, ModuleMap.KnownHeader /*P*/ SuggestedModule,
            boolean SkipCache/*= false*/) {
    return LookupFile(Filename, IncludeLoc, isAngled, 
            FromDir, CurDir, 
            Includers, 
            SearchPath, RelativePath, 
            RequestingModule, SuggestedModule, 
            SkipCache, false);
  }
  public /*const*/ FileEntry /*P*/ LookupFile(StringRef Filename, SourceLocation IncludeLoc, boolean isAngled, 
            /*const*/type$ptr<DirectoryLookup> /*P*/ FromDir, /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ /*&*/ CurDir, 
            SmallVectorPtrPairFileEntryDirectoryEntry Includers, 
            SmallString/*P*/ SearchPath, SmallString/*P*/ RelativePath, 
            Module /*P*/ RequestingModule, ModuleMap.KnownHeader /*P*/ SuggestedModule, 
            boolean SkipCache/*= false*/, boolean BuildSystemModule/*= false*/) {
    SmallString/*64*/ MappedName = null; // JAVA PERF
    try {
      if ((SuggestedModule != null)) {
        /*Deref*/SuggestedModule.$assignMove(new ModuleMap.KnownHeader());
      }

      // If 'Filename' is absolute, check to see if it exists and no searching.
      if (path.is_absolute(Filename)) {
        // JAVA: URL support
        if (path.get_path_offset_in_url(Filename) == 0) {
          std.string prefix = HSOpts.$arrow().AbsPathLookupPrefix;
          if (!prefix.empty()) {
            SmallString pathBuf = new SmallString(Filename.size() + prefix.size() + 1);
            pathBuf.$assign(prefix.c_str(), prefix.size());
            pathBuf.push_back($('/'));
            pathBuf.append(Filename);
            Filename = pathBuf.$StringRef();
          }
        }
        CurDir.$set(NativePointer.<DirectoryLookup>create_type$ptr((DirectoryLookup[])null));

        // If this was an #include_next "/absolute/file", fail.
        if ((FromDir != null)) {
          return null;
        }
        if ((SearchPath != null)) {
          SearchPath.clear();
        }
        if ((RelativePath != null)) {
          RelativePath.clear();
          RelativePath.append(Filename);
        }
        // Otherwise, just return the file.
        return getFileAndSuggestModule(Filename, IncludeLoc, (/*const*/ DirectoryEntry /*P*/ )null, 
          /*IsSystemHeaderDir*/ false, 
          RequestingModule, SuggestedModule);
      }

      // This is the header that MSVC's header search would have found.
      /*const*/ FileEntry /*P*/ MSFE = null;
      ModuleMap.KnownHeader MSSuggestedModule/*J*/= null; // JAVA PERF: postpone new ModuleMap.KnownHeader();

      // Unless disabled, check to see if the file is in the #includer's
      // directory.  This cannot be based on CurDir, because each includer could be
      // a #include of a subdirectory (#include "foo/bar.h") and a subsequent
      // include of "baz.h" should resolve to "whatever/foo/baz.h".
      // This search is not done for <> headers.
      if (!Includers.empty() && !isAngled && !NoCurDirSearch) {
        SmallString/*1024*/ TmpDir = null; // JAVA PERF
        try {
          TmpDir/*J*/= $getLookupFileTmpDir();
          boolean First = true;
          // JAVA PERF: decompose pair
          // for (/*const*/ pair</*const*/ FileEntry /*P*/ , /*const*/ DirectoryEntry /*P*/ > /*&*/ IncluderAndDir : Includers) {
          for (int i = 0; i < Includers.size(); i++) {
            /*const*/ FileEntry /*P*/ Includer = Includers.first$at(i);
            DirectoryEntry Dir = Includers.second$at(i);

            // Concatenate the requested file onto the directory.
            // FIXME: Portability.  Filename concatenation should be in sys::Path.
            TmpDir.$assign(/*STRINGREF_STR*/Dir.getName(), Dir.getNameLen());
            TmpDir.push_back($$SLASH);
            TmpDir.append(Filename);

            // FIXME: We don't cache the result of getFileInfo across the call to
            // getFileAndSuggestModule, because it's a reference to an element of
            // a container that could be reallocated across this call.
            //
            // If we have no includer, that means we're processing a #include
            // from a module build. We should treat this as a system header if we're
            // building a [system] module.
            boolean IncluderIsSystemHeader = (Includer != null) ? (getFileInfo(Includer).DirInfo != SrcMgr.CharacteristicKind.C_User_Raw) : BuildSystemModule;
            {
              /*const*/ FileEntry /*P*/ FE = getFileAndSuggestModule(TmpDir.$StringRef(), IncludeLoc, Dir, IncluderIsSystemHeader, 
                      RequestingModule, SuggestedModule);
              if ((FE != null)) {
                if (!(Includer != null)) {
                  assert (First) : "only first includer can have no file";
                  return FE;
                }

                // Leave CurDir unset.
                // This file is a system header or C++ unfriendly if the old file is.
                //
                // Note that we only use one of FromHFI/ToHFI at once, due to potential
                // reallocation of the underlying vector potentially making the first
                // reference binding dangling.
                HeaderFileInfo /*&*/ FromHFI = getFileInfo(Includer);
                /*uint*/byte DirInfo = FromHFI.DirInfo;
                boolean IndexHeaderMapHeader = FromHFI.IndexHeaderMapHeader;
                StringRef Framework = FromHFI.Framework;

                HeaderFileInfo /*&*/ ToHFI = getFileInfo(FE);
                ToHFI.DirInfo = DirInfo;
                ToHFI.IndexHeaderMapHeader = IndexHeaderMapHeader;
                ToHFI.Framework = Framework;
                if ((SearchPath != null)) {
                  char$ptr SearchPathRef/*J*/= Dir.getName();
                  SearchPath.clear();
                  SearchPath.append(SearchPathRef, Dir.getNameLen());
                }
                if ((RelativePath != null)) {
                  RelativePath.clear();
                  RelativePath.append(Filename);
                }
                if (First) {
                  return FE;
                }

                // Otherwise, we found the path via MSVC header search rules.  If
                // -Wmsvc-include is enabled, we have to keep searching to see if we
                // would've found this header in -I or -isystem directories.
                if (Diags.isIgnored(diag.ext_pp_include_search_ms, /*NO_COPY*/IncludeLoc)) {
                  return FE;
                } else {
                  MSFE = FE;
                  if ((SuggestedModule != null)) {
                    // JAVA PERF: init MSSuggestedModule here if reached
                    if (MSSuggestedModule == null) {
                      MSSuggestedModule = new ModuleMap.KnownHeader();
                    }
                    MSSuggestedModule.$assign($Deref(SuggestedModule));
                    /*Deref*/SuggestedModule.$assignMove(new ModuleMap.KnownHeader());
                  }
                  break;
                }
              }
            }
            First = false;
          }
        } finally {
          $releaseLookupFileTmpDir(TmpDir);
        }
      }

      CurDir.$set(NativePointer.<DirectoryLookup>create_type$ptr((DirectoryLookup[])null));

      // If this is a system #include, ignore the user #include locs.
      /*uint*/int i = isAngled ? AngledDirIdx : 0;

      // If this is a #include_next request, start searching after the directory the
      // file was found in.
      if ((FromDir != null)) {
        i = FromDir.$index() - /*AddrOfSearchDirs.ptr$at(0)*/0;
      }

      // Cache all of the lookups performed by this method.  Many headers are
      // multiply included, and the "pragma once" optimization prevents them from
      // being relex/pp'd, but they would still have to search through a
      // (potentially huge) series of SearchDirs to find it.
      LookupFileCacheInfo /*&*/ CacheLookup = LookupFileCache.$at(/*NO_COPY*/Filename);

      // If the entry has been previously looked up, the first value will be
      // non-zero.  If the value is equal to i (the start point of our search), then
      // this is a matching hit.
      if (!SkipCache && CacheLookup.StartIdx == i + 1) {
        // Skip querying potentially lots of directories for this lookup.
        i = CacheLookup.HitIdx;
        if ((CacheLookup.MappedName != null)) {
          Filename.$assignMove(/*STRINGREF_STR*/CacheLookup.MappedName);
        }
      } else {
        // Otherwise, this is the first query, or the previous query didn't match
        // our search start.  We will fill in our found location below, so prime the
        // start point value.
        CacheLookup.reset(/*StartIdx=*/ i + 1);
      }

      MappedName/*J*/= $getLookupFileMappedName(); // JAVA PERF

      // Check each directory in sequence to see if it contains this file.
      for (; i /*JAVA: was !=*/< SearchDirs.size(); ++i) {
        bool$ref $InUserSpecifiedSystemFramework = $getInUserSpecifiedSystemFramework(false);
        bool$ref $HasBeenMapped = $getHasBeenMapped(false);
        /*const*/ FileEntry /*P*/ FE = SearchDirs.$at(i).LookupFile(Filename, /*Deref*/this, IncludeLoc, SearchPath, RelativePath, RequestingModule, 
            SuggestedModule, $InUserSpecifiedSystemFramework, $HasBeenMapped, 
            MappedName);
        boolean InUserSpecifiedSystemFramework = $releaseInUserSpecifiedSystemFramework($InUserSpecifiedSystemFramework);
        boolean HasBeenMapped = $releaseHasBeenMapped($HasBeenMapped);
        if (HasBeenMapped) {
          CacheLookup.MappedName = $tryClone(copyString(/*NO_COPY*/Filename, (BumpPtrAllocatorImpl)LookupFileCache.getAllocator()));
        }
        if (!(FE != null)) {
          continue;
        }

        CurDir.$set($AddrOf(SearchDirs.ptr$at(i)));

        // This file is a system header or C++ unfriendly if the dir is.
        HeaderFileInfo /*&*/ HFI = getFileInfo(FE);
        HFI.DirInfo = CurDir.$deref().$star().$getDirCharacteristic();

        // If the directory characteristic is User but this framework was
        // user-specified to be treated as a system framework, promote the
        // characteristic.
        if (HFI.DirInfo == SrcMgr.CharacteristicKind.C_User_Raw && InUserSpecifiedSystemFramework) {
          HFI.DirInfo = SrcMgr.CharacteristicKind.C_System_Raw;
        }

        // If the filename matches a known system header prefix, override
        // whether the file is a system header.
        for (/*uint*/int j = SystemHeaderPrefixes.size(); (j != 0); --j) {
          if (Filename.startswith(SystemHeaderPrefixes.$at(j - 1).first)) {
            HFI.DirInfo = (SystemHeaderPrefixes.$at(j - 1).second ? SrcMgr.CharacteristicKind.C_System_Raw : SrcMgr.CharacteristicKind.C_User_Raw);
            break;
          }
        }

        // If this file is found in a header map and uses the framework style of
        // includes, then this header is part of a framework we're building.
        if (CurDir.$deref().$star().isIndexHeaderMap()) {
          /*size_t*/int SlashPos = Filename.find($$SLASH);
          if (SlashPos != StringRef.npos) {
            HFI.IndexHeaderMapHeader = true;
            HFI.Framework = getUniqueFrameworkName(new StringRef(Filename.begin(), 
                    SlashPos));
          }
        }
        if (checkMSVCHeaderSearch(Diags, MSFE, FE, /*NO_COPY*/IncludeLoc)) {
          if ((SuggestedModule != null)) {
            // JAVA PERF: init MSSuggestedModule here if reached
            if (MSSuggestedModule == null) {
              MSSuggestedModule = new ModuleMap.KnownHeader();
            }
            /*Deref*/SuggestedModule.$assign(MSSuggestedModule);
          }
          return MSFE;
        }

        // Remember this location for the next lookup we do.
        CacheLookup.HitIdx = i;
        return FE;
      }

      // If we are including a file with a quoted include "foo.h" from inside
      // a header in a framework that is currently being built, and we couldn't
      // resolve "foo.h" any other way, change the include to <Foo/foo.h>, where
      // "Foo" is the name of the framework in which the including header was found.
      if (!Includers.empty() && (Includers.first$front() != null) && !isAngled
         && Filename.find($$SLASH) == StringRef.npos) {
        HeaderFileInfo /*&*/ IncludingHFI = getFileInfo(Includers.first$front());
        if (IncludingHFI.IndexHeaderMapHeader) {
          SmallString/*128*/ ScratchFilename/*J*/= new SmallString/*128*/(128);
          ScratchFilename.$addassign(/*NO_COPY*/IncludingHFI.Framework);
          ScratchFilename.$addassign($$SLASH);
          ScratchFilename.$addassign(/*NO_COPY*/Filename);

          /*const*/ FileEntry /*P*/ FE = LookupFile(ScratchFilename.$StringRef(), /*NO_COPY*/IncludeLoc, /*isAngled=*/ true, FromDir,
                 CurDir, Includers, SearchPath, RelativePath, 
                 RequestingModule, SuggestedModule);
          if (checkMSVCHeaderSearch(Diags, MSFE, FE, /*NO_COPY*/IncludeLoc)) {
            if ((SuggestedModule != null)) {
              // JAVA PERF: init MSSuggestedModule here if reached
              if (MSSuggestedModule == null) {
                MSSuggestedModule = new ModuleMap.KnownHeader();
              }
              /*Deref*/SuggestedModule.$assign(MSSuggestedModule);
            }
            return MSFE;
          }

          LookupFileCacheInfo /*&*/ CacheLookup2 = LookupFileCache.$at(/*NO_COPY*/Filename);
          CacheLookup2.HitIdx = LookupFileCache.$at(ScratchFilename.$StringRef()).HitIdx;
          // FIXME: SuggestedModule.
          return FE;
        }
      }
      if (checkMSVCHeaderSearch(Diags, MSFE, (/*const*/ FileEntry /*P*/ )null, /*NO_COPY*/IncludeLoc)) {
        if ((SuggestedModule != null)) {
          // JAVA PERF: init MSSuggestedModule here if reached
          if (MSSuggestedModule == null) {
            MSSuggestedModule = new ModuleMap.KnownHeader();
          }
          /*Deref*/SuggestedModule.$assign(MSSuggestedModule);
        }
        return MSFE;
      }

      // Otherwise, didn't find it. Remember we didn't find this.
      CacheLookup.HitIdx = SearchDirs.size();
      return null;
    } finally {
      if (MappedName != null) { $releaseLookupFileMappedName(MappedName); }
    }
  }

  
  /// \brief Look up a subframework for the specified \#include file.
  ///
  /// For example, if \#include'ing <HIToolbox/HIToolbox.h> from
  /// within ".../Carbon.framework/Headers/Carbon.h", check to see if
  /// HIToolbox is a subframework within Carbon.framework.  If so, return
  /// the FileEntry for the designated file, otherwise return null.

  /// LookupSubframeworkHeader - Look up a subframework for the specified
  /// \#include file.  For example, if \#include'ing <HIToolbox/HIToolbox.h> from
  /// within ".../Carbon.framework/Headers/Carbon.h", check to see if HIToolbox
  /// is a subframework within Carbon.framework.  If so, return the FileEntry
  /// for the designated file, otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LookupSubframeworkHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 818,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 815,
   FQN="clang::HeaderSearch::LookupSubframeworkHeader", NM="_ZN5clang12HeaderSearch24LookupSubframeworkHeaderEN4llvm9StringRefEPKNS_9FileEntryEPNS1_15SmallVectorImplIcEES8_PNS_6ModuleEPNS_9ModuleMap11KnownHeaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch24LookupSubframeworkHeaderEN4llvm9StringRefEPKNS_9FileEntryEPNS1_15SmallVectorImplIcEES8_PNS_6ModuleEPNS_9ModuleMap11KnownHeaderE")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ LookupSubframeworkHeader(StringRef Filename, 
                          /*const*/ FileEntry /*P*/ ContextFileEnt, 
                          SmallString/*P*/ SearchPath, 
                          SmallString/*P*/ RelativePath, 
                          Module /*P*/ RequestingModule, 
                          ModuleMap.KnownHeader /*P*/ SuggestedModule) {
    assert ((ContextFileEnt != null)) : "No context file?";

    // Framework names must have a '/' in the filename.  Find it.
    // FIXME: Should we permit '\' on Windows?
    /*size_t*/int SlashPos = Filename.find($$SLASH);
    if (SlashPos == StringRef.npos) {
      return null;
    }

    // Look up the base framework name of the ContextFileEnt.
    /*const*/char$ptr/*char P*/ ContextName = $tryClone(ContextFileEnt.getName());

    // If the context info wasn't a framework, couldn't be a subframework.
    /*const*//*uint*/int DotFrameworkLen = 10;
    /*const*/char$ptr/*char P*/ FrameworkPos = $tryClone(strstr(ContextName, $(".framework")));
    if ($eq_ptr(FrameworkPos, null)
     || (FrameworkPos.$at(DotFrameworkLen) != $$SLASH
     && FrameworkPos.$at(DotFrameworkLen) != $$BACK_SLASH)) {
      return null;
    }

    SmallString/*1024*/ FrameworkName/*J*/= new SmallString/*1024*/(ContextName, FrameworkPos.$add(DotFrameworkLen).$add(1), 1024);

    // Append Frameworks/HIToolbox.framework/
    FrameworkName.$addassign(/*STRINGREF_STR*/"Frameworks/");
    FrameworkName.append(Filename, 0, SlashPos);
    FrameworkName.$addassign(/*STRINGREF_STR*/".framework/");

    StringMapEntry<FrameworkCacheEntry> /*&*/ CacheLookup = FrameworkMap.GetOrCreateValue(Filename.substr(0, SlashPos), 
            new FrameworkCacheEntry());

    // Some other location?
    if ((CacheLookup.second.Directory != null)
       && CacheLookup.getKeyLength() == FrameworkName.size()
       && memcmp(CacheLookup.getKeyStr(), $AddrOf(FrameworkName.data()), 
        CacheLookup.getKeyLength()) != 0) {
      return null;
    }

    // Cache subframework.
    if (!(CacheLookup.second.Directory != null)) {
      ++NumSubFrameworkLookups;

      // If the framework dir doesn't exist, we fail.
      /*const*/ DirectoryEntry /*P*/ Dir = FileMgr.getDirectory(FrameworkName.$StringRef());
      if (!(Dir != null)) {
        return null;
      }

      // Otherwise, if it does, remember that this is the right direntry for this
      // framework.
      CacheLookup.second.Directory = Dir;
    }

    /*const*/ FileEntry /*P*/ FE = null;
    if ((RelativePath != null)) {
      RelativePath.clear();
      RelativePath.append(Filename, SlashPos + 1, Filename.size());
    }

    // Check ".../Frameworks/HIToolbox.framework/Headers/HIToolbox.h"
    SmallString/*1024*/ HeadersFilename/*J*/= new SmallString/*1024*/(FrameworkName);
    HeadersFilename.$addassign(/*STRINGREF_STR*/"Headers/");
    if ((SearchPath != null)) {
      SearchPath.clear();
      // Without trailing '/'.
      SearchPath.append(HeadersFilename, 0, HeadersFilename.size() - 1);
    }

    HeadersFilename.append(Filename, SlashPos + 1, Filename.size());
    if (!((FE = FileMgr.getFile(HeadersFilename.$StringRef(), /*openFile=*/ true)) != null)) {

      // Check ".../Frameworks/HIToolbox.framework/PrivateHeaders/HIToolbox.h"
      HeadersFilename.$assign(FrameworkName);
      HeadersFilename.$addassign(/*STRINGREF_STR*/"PrivateHeaders/");
      if ((SearchPath != null)) {
        SearchPath.clear();
        // Without trailing '/'.
        SearchPath.append(HeadersFilename, 0, HeadersFilename.size() - 1);
      }

      HeadersFilename.append(Filename, SlashPos + 1, Filename.size());
      if (!((FE = FileMgr.getFile(HeadersFilename.$StringRef(), /*openFile=*/ true)) != null)) {
        return null;
      }
    }

    // This file is a system header or C++ unfriendly if the old file is.
    //
    // Note that the temporary 'DirInfo' is required here, as either call to
    // getFileInfo could resize the vector and we don't want to rely on order
    // of evaluation.
    /*uint*/byte DirInfo = getFileInfo(ContextFileEnt).DirInfo;
    getFileInfo(FE).DirInfo = DirInfo;

    FrameworkName.pop_back(); // remove the trailing '/'
    if (!findUsableModuleForFrameworkHeader(FE, FrameworkName.$StringRef(), RequestingModule, 
        SuggestedModule, /*IsSystem*/ false)) {
      return null;
    }

    return FE;
  }

  
  /// \brief Look up the specified framework name in our framework cache.
  /// \returns The DirectoryEntry it is in if we know, null otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LookupFrameworkCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 399,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 401,
   FQN="clang::HeaderSearch::LookupFrameworkCache", NM="_ZN5clang12HeaderSearch20LookupFrameworkCacheEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch20LookupFrameworkCacheEN4llvm9StringRefE")
  //</editor-fold>
  public FrameworkCacheEntry /*&*/ LookupFrameworkCache(StringRef FWName) {
    return FrameworkMap.$at(/*NO_COPY*/FWName);
  }

  
  /// \brief Mark the specified file as a target of of a \#include,
  /// \#include_next, or \#import directive.
  ///
  /// \return false if \#including the file will have no effect or true
  /// if we should include it.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::ShouldEnterIncludeFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1039,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1036,
   FQN="clang::HeaderSearch::ShouldEnterIncludeFile", NM="_ZN5clang12HeaderSearch22ShouldEnterIncludeFileERNS_12PreprocessorEPKNS_9FileEntryEbPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch22ShouldEnterIncludeFileERNS_12PreprocessorEPKNS_9FileEntryEbPNS_6ModuleE")
  //</editor-fold>
  public boolean ShouldEnterIncludeFile(Preprocessor /*&*/ PP, 
                        /*const*/ FileEntry /*P*/ File, 
                        boolean isImport, Module /*P*/ M) {
    ++NumIncluded; // Count # of attempted #includes.
    
    // Get information about this file.
    HeaderFileInfo /*&*/ FileInfo = getFileInfo(File);
    
    // If this is a #import directive, check that we have not already imported
    // this header.
    if (isImport) {
      // If this has already been imported, don't import it again.
      FileInfo.isImport = true;
      
      // Has this already been #import'ed or #include'd?
      if ((FileInfo.NumIncludes != 0)) {
        return false;
      }
    } else {
      // Otherwise, if this is a #include of a file that was previously #import'd
      // or if this is the second #include of a #pragma once file, ignore it.
      if (FileInfo.isImport) {
        return false;
      }
    }
    {
      
      // Next, check to see if the file is wrapped with #ifndef guards.  If so, and
      // if the macro that guards it is defined, we know the #include has no effect.
      /*const*/ IdentifierInfo /*P*/ ControllingMacro = FileInfo.getControllingMacro(ExternalLookup);
      if ((ControllingMacro != null)) {
        // If the header corresponds to a module, check whether the macro is already
        // defined in that module rather than checking in the current set of visible
        // modules.
        if ((M != null) ? PP.isMacroDefinedInLocalModule(ControllingMacro, M) : PP.isMacroDefined(ControllingMacro)) {
          ++NumMultiIncludeFileOptzn;
          return false;
        }
      }
    }
    
    // Increment the number of times this file has been included.
    ++FileInfo.NumIncludes;
    
    return true;
  }

  
  /// \brief Return whether the specified file is a normal header,
  /// a system header, or a C++ friendly system header.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getFileDirFlavor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 413,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 415,
   FQN="clang::HeaderSearch::getFileDirFlavor", NM="_ZN5clang12HeaderSearch16getFileDirFlavorEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch16getFileDirFlavorEPKNS_9FileEntryE")
  //</editor-fold>
  public SrcMgr.CharacteristicKind getFileDirFlavor(/*const*/ FileEntry /*P*/ File) {
    return SrcMgr.CharacteristicKind.valueOf(getFileInfo(File).DirInfo);
  }
  public /*SrcMgr.CharacteristicKind*/byte $getFileDirFlavor(/*const*/FileEntry /*P*/ File) {
    return getFileInfo(File).DirInfo;
  }

  
  /// \brief Mark the specified file as a "once only" file, e.g. due to
  /// \#pragma once.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::MarkFileIncludeOnce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 419,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 421,
   FQN="clang::HeaderSearch::MarkFileIncludeOnce", NM="_ZN5clang12HeaderSearch19MarkFileIncludeOnceEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19MarkFileIncludeOnceEPKNS_9FileEntryE")
  //</editor-fold>
  public void MarkFileIncludeOnce(/*const*/ FileEntry /*P*/ File) {
    HeaderFileInfo /*&*/ FI = getFileInfo(File);
    FI.isImport = true;
    FI.isPragmaOnce = true;
  }

  
  /// \brief Mark the specified file as a system header, e.g. due to
  /// \#pragma GCC system_header.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::MarkFileSystemHeader">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 427,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 429,
   FQN="clang::HeaderSearch::MarkFileSystemHeader", NM="_ZN5clang12HeaderSearch20MarkFileSystemHeaderEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch20MarkFileSystemHeaderEPKNS_9FileEntryE")
  //</editor-fold>
  public void MarkFileSystemHeader(/*const*/ FileEntry /*P*/ File) {
    getFileInfo(File).DirInfo = SrcMgr.CharacteristicKind.C_System_Raw;
  }

  
  /// \brief Mark the specified file as part of a module.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::MarkFileModuleHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1020,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1017,
   FQN="clang::HeaderSearch::MarkFileModuleHeader", NM="_ZN5clang12HeaderSearch20MarkFileModuleHeaderEPKNS_9FileEntryENS_9ModuleMap16ModuleHeaderRoleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch20MarkFileModuleHeaderEPKNS_9FileEntryENS_9ModuleMap16ModuleHeaderRoleEb")
  //</editor-fold>
  public void MarkFileModuleHeader(/*const*/ FileEntry /*P*/ FE, 
          /*ModuleMap::ModuleHeaderRole*//*uint*/int Role,
          boolean isCompilingModuleHeader) {
    boolean isModularHeader = !((Role & ModuleMap.ModuleHeaderRole.TextualHeader) != 0);
    
    // Don't mark the file info as non-external if there's nothing to change.
    if (!isCompilingModuleHeader) {
      if (!isModularHeader) {
        return;
    }
      /*const*/ HeaderFileInfo /*P*/ HFI = getExistingFileInfo(FE);
      if ((HFI != null) && HFI.isModuleHeader) {
        return;
      }
    }
    
    HeaderFileInfo /*&*/ HFI = getFileInfo(FE);
    HFI.isModuleHeader |= isModularHeader;
    HFI.isCompilingModuleHeader |= isCompilingModuleHeader;
  }

  
  /// \brief Increment the count for the number of times the specified
  /// FileEntry has been entered.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::IncrementIncludeCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 438,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 440,
   FQN="clang::HeaderSearch::IncrementIncludeCount", NM="_ZN5clang12HeaderSearch21IncrementIncludeCountEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch21IncrementIncludeCountEPKNS_9FileEntryE")
  //</editor-fold>
  public void IncrementIncludeCount(/*const*/ FileEntry /*P*/ File) {
    ++getFileInfo(File).NumIncludes;
  }

  
  /// \brief Mark the specified file as having a controlling macro.
  ///
  /// This is used by the multiple-include optimization to eliminate
  /// no-op \#includes.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::SetFileControllingMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 446,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 448,
   FQN="clang::HeaderSearch::SetFileControllingMacro", NM="_ZN5clang12HeaderSearch23SetFileControllingMacroEPKNS_9FileEntryEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch23SetFileControllingMacroEPKNS_9FileEntryEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public void SetFileControllingMacro(/*const*/ FileEntry /*P*/ File, 
                         /*const*/ IdentifierInfo /*P*/ ControllingMacro) {
    getFileInfo(File).ControllingMacro = ControllingMacro;
  }

  
  /// \brief Return true if this is the first time encountering this header.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::FirstTimeLexingFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 452,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 454,
   FQN="clang::HeaderSearch::FirstTimeLexingFile", NM="_ZN5clang12HeaderSearch19FirstTimeLexingFileEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19FirstTimeLexingFileEPKNS_9FileEntryE")
  //</editor-fold>
  public boolean FirstTimeLexingFile(/*const*/ FileEntry /*P*/ File) {
    return $ushort2int(getFileInfo(File).NumIncludes) == 1;
  }

  
  /// \brief Determine whether this file is intended to be safe from
  /// multiple inclusions, e.g., it has \#pragma once or a controlling
  /// macro.
  ///
  /// This routine does not consider the effect of \#import
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::isFileMultipleIncludeGuarded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1012,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1009,
   FQN="clang::HeaderSearch::isFileMultipleIncludeGuarded", NM="_ZN5clang12HeaderSearch28isFileMultipleIncludeGuardedEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch28isFileMultipleIncludeGuardedEPKNS_9FileEntryE")
  //</editor-fold>
  public boolean isFileMultipleIncludeGuarded(/*const*/ FileEntry /*P*/ File) {
    {
    // Check if we've ever seen this file as a header.
      /*const*/ HeaderFileInfo /*P*/ HFI = getExistingFileInfo(File);
      if ((HFI != null)) {
        return HFI.isPragmaOnce || HFI.isImport || (HFI.ControllingMacro != null)
           || (HFI.ControllingMacroID != 0);
      }
    }
    return false;
  }

  
  /// CreateHeaderMap - This method returns a HeaderMap for the specified
  /// FileEntry, uniquing them through the 'HeaderMaps' datastructure.
  
  /// CreateHeaderMap - This method returns a HeaderMap for the specified
  /// FileEntry, uniquing them through the 'HeaderMaps' datastructure.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::CreateHeaderMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 103,
   FQN="clang::HeaderSearch::CreateHeaderMap", NM="_ZN5clang12HeaderSearch15CreateHeaderMapEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch15CreateHeaderMapEPKNS_9FileEntryE")
  //</editor-fold>
  public /*const*/ HeaderMap /*P*/ CreateHeaderMap(/*const*/ FileEntry /*P*/ FE) {
    // We expect the number of headermaps to be small, and almost always empty.
    // If it ever grows, use of a linear search should be re-evaluated.
    if (!HeaderMaps.empty()) {
      for (/*uint*/int i = 0, e = HeaderMaps.size(); i != e; ++i)  {
        // Pointer equality comparison of FileEntries works because they are
        // already uniqued by inode.
        if (HeaderMaps.$at(i).first == FE) {
          return HeaderMaps.$at(i).second;
        }
      }
    }
    {
      
      /*const*/ HeaderMap /*P*/ HM = HeaderMap.Create(FE, FileMgr);
      if ((HM != null)) {
        HeaderMaps.push_back(std.make_pair_Ptr_Ptr(FE, HM));
        return HM;
      }
    }
    
    return null;
  }
  
  
  /// \brief Retrieve the name of the module file that should be used to 
  /// load the given module.
  ///
  /// \param Module The module whose module file name will be returned.
  ///
  /// \returns The name of the module file that corresponds to this module,
  /// or an empty string if this module does not correspond to any module file.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getModuleFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 122,
   FQN="clang::HeaderSearch::getModuleFileName", NM="_ZN5clang12HeaderSearch17getModuleFileNameEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch17getModuleFileNameEPNS_6ModuleE")
  //</editor-fold>
  public std.string getModuleFileName(Module /*P*/ Module) {
    /*const*/ FileEntry /*P*/ ModuleMap = getModuleMap().getModuleMapFileForUniquing(Module);
    return getModuleFileName(new StringRef(Module.Name), new StringRef(ModuleMap.getName()));
  }

  
  /// \brief Retrieve the name of the module file that should be used to 
  /// load a module with the given name.
  ///
  /// \param ModuleName The module whose module file name will be returned.
  ///
  /// \param ModuleMapPath A path that when combined with \c ModuleName
  /// uniquely identifies this module. See Module::ModuleMap.
  ///
  /// \returns The name of the module file that corresponds to this module,
  /// or an empty string if this module does not correspond to any module file.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getModuleFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 128,
   FQN="clang::HeaderSearch::getModuleFileName", NM="_ZN5clang12HeaderSearch17getModuleFileNameEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch17getModuleFileNameEN4llvm9StringRefES2_")
  //</editor-fold>
  public std.string getModuleFileName(StringRef ModuleName, 
                   StringRef ModuleMapPath) {
    // If we don't have a module cache path or aren't supposed to use one, we
    // can't do anything.
    if (getModuleCachePath().empty()) {
      return new std.string();
    }
    
    SmallString/*256*/ Result/*J*/= new SmallString/*256*/(getModuleCachePath(), 256);
    fs.make_absolute(Result);
    if (HSOpts.$arrow().DisableModuleHash) {
      path.append(Result, $add_StringRef_char$ptr$C(ModuleName, /*KEEP_STR*/".pcm"));
    } else {
      // Construct the name <ModuleName>-<hash of ModuleMapPath>.pcm which should
      // ideally be globally unique to this particular module. Name collisions
      // in the hash are safe (because any translation unit can only import one
      // module with each name), but result in a loss of caching.
      //
      // To avoid false-negatives, we form as canonical a path as we can, and map
      // to lower-case in case we're on a case-insensitive file system.
      /*const*/ DirectoryEntry /*P*/ Dir = FileMgr.getDirectory(path.parent_path(/*NO_COPY*/ModuleMapPath));
      if (!(Dir != null)) {
        return new std.string();
      }
      StringRef DirName = FileMgr.getCanonicalName(Dir);
      StringRef FileName = path.filename(/*NO_COPY*/ModuleMapPath);
      
      hash_code Hash = hash_combine(DirName.lower(), FileName.lower());
      
      SmallString/*128*/ HashStr/*J*/= new SmallString/*128*/(128);
      new APInt(JD$UInt_ULong.INSTANCE, 64, $uint2ulong(((/*size_t*/int)(Hash.$uint())))).toStringUnsigned(HashStr, /*Radix*/ 36);
      path.append(Result, $add_Twine($add_Twine($add_StringRef_char$ptr$C(ModuleName, /*KEEP_STR*/$MINUS), new Twine(HashStr)), new Twine(/*KEEP_STR*/".pcm")));
    }
    return Result.str().str();
  }

  
  /// \brief Lookup a module Search for a module with the given name.
  ///
  /// \param ModuleName The name of the module we're looking for.
  ///
  /// \param AllowSearch Whether we are allowed to search in the various
  /// search directories to produce a module definition. If not, this lookup
  /// will only return an already-known module.
  ///
  /// \returns The module with the given name.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::lookupModule">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 165,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 157,
   FQN="clang::HeaderSearch::lookupModule", NM="_ZN5clang12HeaderSearch12lookupModuleEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch12lookupModuleEN4llvm9StringRefEb")
  //</editor-fold>
  public Module /*P*/ lookupModule(StringRef ModuleName) {
    return lookupModule(ModuleName, true);
  }
  public Module /*P*/ lookupModule(StringRef ModuleName, boolean AllowSearch/*= true*/) {
    // Look in the module map to determine if there is a module by this name.
    Module /*P*/ Module = ModMap.findModule(/*NO_COPY*/ModuleName);
    if ((Module != null) || !AllowSearch || !HSOpts.$arrow().ImplicitModuleMaps) {
      return Module;
    }
    
    // Look through the various header search paths to load any available module
    // maps, searching for a module map that describes this module.
    for (/*uint*/int Idx = 0, N = SearchDirs.size(); Idx != N; ++Idx) {
      if (SearchDirs.$at(Idx).isFramework()) {
        // Search for or infer a module map for a framework.
        SmallString/*128*/ FrameworkDirName/*J*/= new SmallString/*128*/(128);
        FrameworkDirName.$addassign(/*STRINGREF_STR*/SearchDirs.$at(Idx).getFrameworkDir().getName());
        path.append(FrameworkDirName, $add_StringRef_char$ptr$C(ModuleName, /*KEEP_STR*/".framework"));
        {
          /*const*/ DirectoryEntry /*P*/ FrameworkDir = FileMgr.getDirectory(FrameworkDirName.$StringRef());
          if ((FrameworkDir != null)) {
            boolean IsSystem = SearchDirs.$at(Idx).getDirCharacteristic() != SrcMgr.CharacteristicKind.C_User;
            Module = loadFrameworkModule(/*NO_COPY*/ModuleName, FrameworkDir, IsSystem);
            if ((Module != null)) {
              break;
            }
          }
        }
      }
      
      // FIXME: Figure out how header maps and module maps will work together.
      
      // Only deal with normal search directories.
      if (!SearchDirs.$at(Idx).isNormalDir()) {
        continue;
      }
      
      boolean IsSystem = SearchDirs.$at(Idx).isSystemHeaderDirectory();
      DirectoryEntry dir = SearchDirs.$at(Idx).getDir(); // PERF: keep to query once
      // Search for a module map file in this directory.
      if (loadModuleMapFile(dir, IsSystem, 
          /*IsFramework*/ false) == LoadModuleMapResult.LMM_NewlyLoaded) {
        // We just loaded a module map file; check whether the module is
        // available now.
        Module = ModMap.findModule(/*NO_COPY*/ModuleName);
        if ((Module != null)) {
          break;
        }
      }
      
      // Search for a module map in a subdirectory with the same name as the
      // module.
      SmallString/*128*/ NestedModuleMapDirName/*J*/= new SmallString/*128*/(128);
      NestedModuleMapDirName.$assign(/*STRINGREF_STR*/dir.getName(), dir.getNameLen());
      path.append(NestedModuleMapDirName, ModuleName);
      if (loadModuleMapFile(NestedModuleMapDirName.$StringRef(), IsSystem, 
          /*IsFramework*/ false) == LoadModuleMapResult.LMM_NewlyLoaded) {
        // If we just loaded a module map file, look for the module again.
        Module = ModMap.findModule(/*NO_COPY*/ModuleName);
        if ((Module != null)) {
          break;
        }
      }
      
      // If we've already performed the exhaustive search for module maps in this
      // search directory, don't do it again.
      if (SearchDirs.$at(Idx).haveSearchedAllModuleMaps()) {
        continue;
      }
      
      // Load all module maps in the immediate subdirectories of this search
      // directory.
      loadSubdirectoryModuleMaps(SearchDirs.$at(Idx));
      
      // Look again for the module.
      Module = ModMap.findModule(/*NO_COPY*/ModuleName);
      if ((Module != null)) {
        break;
      }
    }
    
    return Module;
  }

  
  /// \brief Try to find a module map file in the given directory, returning
  /// \c nullptr if none is found.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::lookupModuleMapFile">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1259,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1256,
   FQN="clang::HeaderSearch::lookupModuleMapFile", NM="_ZN5clang12HeaderSearch19lookupModuleMapFileEPKNS_14DirectoryEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19lookupModuleMapFileEPKNS_14DirectoryEntryEb")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ lookupModuleMapFile(/*const*/ DirectoryEntry /*P*/ Dir, boolean IsFramework) {
    if (!HSOpts.$arrow().ImplicitModuleMaps) {
      return null;
    }
    // For frameworks, the preferred spelling is Modules/module.modulemap, but
    // module.map at the framework root is also accepted.
    SmallString/*128*/ ModuleMapFileName/*J*/= new SmallString/*128*/(new StringRef(Dir.getName(), Dir.getNameLen()), 128);
    if (IsFramework) {
      path.append(ModuleMapFileName, new Twine(/*KEEP_STR*/"Modules"));
    }
    path.append(ModuleMapFileName, new Twine(/*KEEP_STR*/"module.modulemap"));
    {
      /*const*/ FileEntry /*P*/ F = FileMgr.getFile(ModuleMapFileName.$StringRef());
      if ((F != null)) {
        return F;
      }
    }

    // Continue to allow module.map
    ModuleMapFileName.$assign(/*STRINGREF_STR*/Dir.getName(), Dir.getNameLen());
    path.append(ModuleMapFileName, new Twine(/*KEEP_STR*/"module.map"));
    return FileMgr.getFile(ModuleMapFileName.$StringRef());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::IncrementFrameworkLookupCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 504,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 506,
   FQN="clang::HeaderSearch::IncrementFrameworkLookupCount", NM="_ZN5clang12HeaderSearch29IncrementFrameworkLookupCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch29IncrementFrameworkLookupCountEv")
  //</editor-fold>
  public void IncrementFrameworkLookupCount() {
    ++NumFrameworkLookups;
  }

  
  /// \brief Determine whether there is a module map that may map the header
  /// with the given file name to a (sub)module.
  /// Always returns false if modules are disabled.
  ///
  /// \param Filename The name of the file.
  ///
  /// \param Root The "root" directory, at which we should stop looking for
  /// module maps.
  ///
  /// \param IsSystem Whether the directories we're looking at are system
  /// header directories.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::hasModuleMap">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1094,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1091,
   FQN="clang::HeaderSearch::hasModuleMap", NM="_ZN5clang12HeaderSearch12hasModuleMapEN4llvm9StringRefEPKNS_14DirectoryEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch12hasModuleMapEN4llvm9StringRefEPKNS_14DirectoryEntryEb")
  //</editor-fold>
  public boolean hasModuleMap(StringRef FileName, 
              /*const*/ DirectoryEntry /*P*/ Root, 
              boolean IsSystem) {
    if (!HSOpts.$arrow().ImplicitModuleMaps) {
      return false;
    }

    SmallVector</*const*/ DirectoryEntry /*P*/> FixUpDirectories/*J*/= new SmallVector</*const*/ DirectoryEntry /*P*/>(2, (DirectoryEntry /*P*/)null);

    StringRef DirName = new StringRef(FileName); // JAVA: need to copy here, because changed below
    do {
      // Get the parent directory name.
      DirName.$assignMove(path.parent_path(/*NO_COPY*/DirName));
      if (DirName.empty()) {
        return false;
      }

      // Determine whether this directory exists.
      /*const*/ DirectoryEntry /*P*/ Dir = FileMgr.getDirectory(/*NO_COPY*/DirName);
      if (!(Dir != null)) {
        return false;
      }

      // Try to load the module map file in this directory.
      switch (loadModuleMapFile(Dir, IsSystem, 
          $eq_StringRef(path.extension(new StringRef(Dir.getName(), Dir.getNameLen())), 
              /*STRINGREF_STR*/".framework"))) {
       case LMM_NewlyLoaded:
       case LMM_AlreadyLoaded:
        // Success. All of the directories we stepped through inherit this module
        // map file.
        for (/*uint*/int I = 0, N = FixUpDirectories.size(); I != N; ++I)  {
          DirectoryHasModuleMap.$set(FixUpDirectories.$at(I), true);
        }
        return true;
       case LMM_NoDirectory:
       case LMM_InvalidModuleMap:
        break;
      }

      // If we hit the top of our search, we're done.
      if (Dir == Root) {
        return false;
      }

      // Keep track of all of the directories we checked, so we can mark them as
      // having module maps if we eventually do find a module map.
      FixUpDirectories.push_back(Dir);
    } while (true);
  }

  
  /// \brief Retrieve the module that corresponds to the given file, if any.
  ///
  /// \param File The header that we wish to map to a module.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::findModuleForHeader">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1141,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1138,
   FQN="clang::HeaderSearch::findModuleForHeader", NM="_ZNK5clang12HeaderSearch19findModuleForHeaderEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch19findModuleForHeaderEPKNS_9FileEntryE")
  //</editor-fold>
  public ModuleMap.KnownHeader findModuleForHeader(/*const*/ FileEntry /*P*/ File) /*const*/ {
    if ((ExternalSource != null)) {
      // Make sure the external source has handled header info about this file,
      // which includes whether the file is part of a module.
      /*(void)*/getExistingFileInfo(File);
    }
    return ModMap.findModuleForHeader(File);
  }

  
  /// \brief Read the contents of the given module map file.
  ///
  /// \param File The module map file.
  /// \param IsSystem Whether this file is in a system header directory.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::loadModuleMapFile">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1201,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1198,
   FQN="clang::HeaderSearch::loadModuleMapFile", NM="_ZN5clang12HeaderSearch17loadModuleMapFileEPKNS_9FileEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch17loadModuleMapFileEPKNS_9FileEntryEb")
  //</editor-fold>
  public boolean loadModuleMapFile(/*const*/ FileEntry /*P*/ File, boolean IsSystem) {
    // Find the directory for the module. For frameworks, that may require going
    // up from the 'Modules' directory.
    /*const*/ DirectoryEntry /*P*/ Dir = null;
    if (getHeaderSearchOpts().ModuleMapFileHomeIsCwd) {
      Dir = FileMgr.getDirectory(StringRef.R$DOT);
    } else {
      Dir = File.getDir();
      StringRef DirName/*J*/= new StringRef(Dir.getName(), Dir.getNameLen());
      if ($eq_StringRef(path.filename(/*NO_COPY*/DirName), /*STRINGREF_STR*/"Modules")) {
        DirName.$assignMove(path.parent_path(/*NO_COPY*/DirName));
        if (DirName.endswith(/*STRINGREF_STR*/".framework")) {
          Dir = FileMgr.getDirectory(/*NO_COPY*/DirName);
        }
        // FIXME: This assert can fail if there's a race between the above check
        // and the removal of the directory.
        assert ((Dir != null)) : "parent must exist";
      }
    }
    switch (loadModuleMapFileImpl(File, IsSystem, Dir)) {
     case LMM_AlreadyLoaded:
     case LMM_NewlyLoaded:
      return false;
     case LMM_NoDirectory:
     case LMM_InvalidModuleMap:
      return true;
    }
    throw new llvm_unreachable("Unknown load module map result");
  }

  
  /// \brief Collect the set of all known, top-level modules.
  ///
  /// \param Modules Will be filled with the set of known, top-level modules.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::collectAllModules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1335,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1332,
   FQN="clang::HeaderSearch::collectAllModules", NM="_ZN5clang12HeaderSearch17collectAllModulesERN4llvm15SmallVectorImplIPNS_6ModuleEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch17collectAllModulesERN4llvm15SmallVectorImplIPNS_6ModuleEEE")
  //</editor-fold>
  public void collectAllModules(SmallVectorImpl<Module /*P*/ > /*&*/ Modules) {
    Modules.clear();
    if (HSOpts.$arrow().ImplicitModuleMaps) {
      // Load module maps for each of the header search directories.
      for (/*uint*/int Idx = 0, N = SearchDirs.size(); Idx != N; ++Idx) {
        boolean IsSystem = SearchDirs.$at(Idx).isSystemHeaderDirectory();
        if (SearchDirs.$at(Idx).isFramework()) {
          std.error_code EC/*J*/= new std.error_code();
          SmallString/*128*/ DirNative/*J*/= new SmallString/*128*/(128);
          path.__native(new Twine(SearchDirs.$at(Idx).getFrameworkDir().getName()), 
              DirNative);
          
          // Search each of the ".framework" directories to load them as modules.
          FileSystem /*&*/ FS = FileMgr.$getVirtualFileSystem();
          for (directory_iterator Dir = FS.dir_begin(new Twine(DirNative), EC), DirEnd/*J*/= new directory_iterator();
               Dir.$noteq(DirEnd) && !EC.$bool(); Dir.increment(EC)) {
            if ($noteq_StringRef(path.extension(Dir.$arrow().getName()), /*STRINGREF_STR*/".framework")) {
              continue;
            }

            /*const*/ DirectoryEntry /*P*/ FrameworkDir = FileMgr.getDirectory(Dir.$arrow().getName());
            if (!(FrameworkDir != null)) {
              continue;
            }

            // Load this framework module.
            loadFrameworkModule(path.stem(Dir.$arrow().getName()), 
                FrameworkDir, IsSystem);
          }
          continue;
        }

        // FIXME: Deal with header maps.
        if (SearchDirs.$at(Idx).isHeaderMap()) {
          continue;
        }

        // Try to load a module map file for the search directory.
        loadModuleMapFile(SearchDirs.$at(Idx).getDir(), IsSystem, 
            /*IsFramework*/ false);

        // Try to load module map files for immediate subdirectories of this
        // search directory.
        loadSubdirectoryModuleMaps(SearchDirs.$at(Idx));
      }
    }
    
    // Populate the list of modules.
    for (StringMapIterator<Module /*P*//*, MallocAllocator*/> M = ModMap.module_begin(), 
            MEnd = ModMap.module_end(); 
            M.$noteq(MEnd); M.$preInc()) {
      Modules.push_back(M.$arrow().getValue());
    }
  }

  
  /// \brief Load all known, top-level system modules.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::loadTopLevelSystemModules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1389,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1385,
   FQN="clang::HeaderSearch::loadTopLevelSystemModules", NM="_ZN5clang12HeaderSearch25loadTopLevelSystemModulesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch25loadTopLevelSystemModulesEv")
  //</editor-fold>
  public void loadTopLevelSystemModules() {
    if (!HSOpts.$arrow().ImplicitModuleMaps) {
      return;
    }

    // Load module maps for each of the header search directories.
    for (/*uint*/int Idx = 0, N = SearchDirs.size(); Idx != N; ++Idx) {
      // We only care about normal header directories.
      if (!SearchDirs.$at(Idx).isNormalDir()) {
        continue;
      }

      // Try to load a module map file for the search directory.
      loadModuleMapFile(SearchDirs.$at(Idx).getDir(), 
          SearchDirs.$at(Idx).isSystemHeaderDirectory(), 
          SearchDirs.$at(Idx).isFramework());
    }
  }

/*private:*/
  /// \brief Retrieve a module with the given name, which may be part of the
  /// given framework.
  ///
  /// \param Name The name of the module to retrieve.
  ///
  /// \param Dir The framework directory (e.g., ModuleName.framework).
  ///
  /// \param IsSystem Whether the framework directory is part of the system
  /// frameworks.
  ///
  /// \returns The module, if found; otherwise, null.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::loadFrameworkModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1278,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1275,
   FQN="clang::HeaderSearch::loadFrameworkModule", NM="_ZN5clang12HeaderSearch19loadFrameworkModuleEN4llvm9StringRefEPKNS_14DirectoryEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19loadFrameworkModuleEN4llvm9StringRefEPKNS_14DirectoryEntryEb")
  //</editor-fold>
  /*friend*//*private*/ Module /*P*/ loadFrameworkModule(StringRef Name, 
                     /*const*/ DirectoryEntry /*P*/ Dir, 
                     boolean IsSystem) {
    {
      Module /*P*/ Module = ModMap.findModule(/*NO_COPY*/Name);
      if ((Module != null)) {
        return Module;
      }
    }

    // Try to load a module map file.
    switch (loadModuleMapFile(Dir, IsSystem, /*IsFramework*/ true)) {
     case LMM_InvalidModuleMap:
      // Try to infer a module map from the framework directory.
      if (HSOpts.$arrow().ImplicitModuleMaps) {
        ModMap.inferFrameworkModule(Dir, IsSystem, /*Parent=*/ (Module /*P*/ )null);
      }
      break;
     case LMM_AlreadyLoaded:
     case LMM_NoDirectory:
      return null;
     case LMM_NewlyLoaded:
      break;
    }

    return ModMap.findModule(/*NO_COPY*/Name);
  }
  
  
  /// \brief Load all of the module maps within the immediate subdirectories
  /// of the given search directory.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::loadSubdirectoryModuleMaps">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1407,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1403,
   FQN="clang::HeaderSearch::loadSubdirectoryModuleMaps", NM="_ZN5clang12HeaderSearch26loadSubdirectoryModuleMapsERNS_15DirectoryLookupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch26loadSubdirectoryModuleMapsERNS_15DirectoryLookupE")
  //</editor-fold>
  private void loadSubdirectoryModuleMaps(DirectoryLookup /*&*/ SearchDir) {
    assert (HSOpts.$arrow().ImplicitModuleMaps) : "Should not be loading subdirectory module maps";
    if (SearchDir.haveSearchedAllModuleMaps()) {
      return;
    }
    
    std.error_code EC/*J*/= new std.error_code();
    SmallString/*128*/ DirNative/*J*/= new SmallString/*128*/(128);
    path.__native(new Twine(SearchDir.getDir().getName()), DirNative);
    FileSystem /*&*/ FS = FileMgr.$getVirtualFileSystem();
    for (directory_iterator Dir = FS.dir_begin(new Twine(DirNative), EC), DirEnd/*J*/= new directory_iterator();
         Dir.$noteq(DirEnd) && !EC.$bool(); Dir.increment(EC)) {
      boolean IsFramework = $eq_StringRef(path.extension(Dir.$arrow().getName()), /*STRINGREF_STR*/".framework");
      if (IsFramework == SearchDir.isFramework()) {
        loadModuleMapFile(Dir.$arrow().getName(), SearchDir.isSystemHeaderDirectory(), 
            SearchDir.isFramework());
      }
    }
    
    SearchDir.setSearchedAllModuleMaps(true);
  }


  /// \brief Find and suggest a usable module for the given file.
  ///
  /// \return \c true if the file can be used, \c false if we are not permitted to
  ///         find this file due to requirements from \p RequestingModule.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::findUsableModuleForHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1151,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1148,
   FQN="clang::HeaderSearch::findUsableModuleForHeader", NM="_ZN5clang12HeaderSearch25findUsableModuleForHeaderEPKNS_9FileEntryEPKNS_14DirectoryEntryEPNS_6ModuleEPNS_9ModuleMap11KnownHeaderEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch25findUsableModuleForHeaderEPKNS_9FileEntryEPKNS_14DirectoryEntryEPNS_6ModuleEPNS_9ModuleMap11KnownHeaderEb")
  //</editor-fold>
  /*friend*//*private*/ boolean findUsableModuleForHeader(/*const*/ FileEntry /*P*/ File, /*const*/ DirectoryEntry /*P*/ Root, Module /*P*/ RequestingModule, 
                           ModuleMap.KnownHeader /*P*/ SuggestedModule, boolean IsSystemHeaderDir) {
    if ((File != null) && (SuggestedModule != null)) {
      // If there is a module that corresponds to this header, suggest it.
      hasModuleMap(new StringRef(File.getName()), Root, IsSystemHeaderDir);
      /*Deref*/SuggestedModule.$assignMove(findModuleForHeader(File));
    }
    return true;
  }

  
  /// \brief Find and suggest a usable module for the given file, which is part of
  /// the specified framework.
  ///
  /// \return \c true if the file can be used, \c false if we are not permitted to
  ///         find this file due to requirements from \p RequestingModule.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::findUsableModuleForFrameworkHeader">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1159,
   FQN="clang::HeaderSearch::findUsableModuleForFrameworkHeader", NM="_ZN5clang12HeaderSearch34findUsableModuleForFrameworkHeaderEPKNS_9FileEntryEN4llvm9StringRefEPNS_6ModuleEPNS_9ModuleMap11KnownHeaderEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch34findUsableModuleForFrameworkHeaderEPKNS_9FileEntryEN4llvm9StringRefEPNS_6ModuleEPNS_9ModuleMap11KnownHeaderEb")
  //</editor-fold>
  /*friend*//*private*/ boolean findUsableModuleForFrameworkHeader(/*const*/ FileEntry /*P*/ File, StringRef FrameworkName, Module /*P*/ RequestingModule, 
                                    ModuleMap.KnownHeader /*P*/ SuggestedModule, boolean IsSystemFramework) {
    // If we're supposed to suggest a module, look for one now.
    if ((SuggestedModule != null)) {
      // Find the top-level framework based on this framework.
      SmallVector<std.string> SubmodulePath/*J*/= new SmallVector<std.string>(4, new std.string());
      /*const*/ DirectoryEntry /*P*/ TopFrameworkDir = /*::*/getTopFrameworkDir(FileMgr, /*MUST COPY*/new StringRef(FrameworkName), SubmodulePath);
      
      // Determine the name of the top-level framework.
      StringRef ModuleName = path.stem(new StringRef(TopFrameworkDir.getName()));
      
      // Load this framework module. If that succeeds, find the suggested module
      // for this header, if any.
      loadFrameworkModule(/*NO_COPY*/ModuleName, TopFrameworkDir, IsSystemFramework);
      
      // FIXME: This can find a module not part of ModuleName, which is
      // important so that we're consistent about whether this header
      // corresponds to a module. Possibly we should lock down framework modules
      // so that this is not possible.
      /*Deref*/SuggestedModule.$assignMove(findModuleForHeader(File));
    }
    return true;
  }

  
  /// \brief Look up the file with the specified name and determine its owning
  /// module.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getFileAndSuggestModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 252,
   FQN="clang::HeaderSearch::getFileAndSuggestModule", NM="_ZN5clang12HeaderSearch23getFileAndSuggestModuleEN4llvm9StringRefENS_14SourceLocationEPKNS_14DirectoryEntryEbPNS_6ModuleEPNS_9ModuleMap11KnownHeaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch23getFileAndSuggestModuleEN4llvm9StringRefENS_14SourceLocationEPKNS_14DirectoryEntryEbPNS_6ModuleEPNS_9ModuleMap11KnownHeaderE")
  //</editor-fold>
  /*friend*//*private*/ /*const*/ FileEntry /*P*/ getFileAndSuggestModule(StringRef FileName, SourceLocation IncludeLoc, /*const*/ DirectoryEntry /*P*/ Dir, 
                         boolean IsSystemHeaderDir, Module /*P*/ RequestingModule, 
                         ModuleMap.KnownHeader /*P*/ SuggestedModule) {
    // If we have a module map that might map this header, load it and
    // check whether we'll have a suggestion for a module.
    /*const*/ FileEntry /*P*/ File = getFileMgr().getFile(new StringRef(FileName), /*OpenFile=*/ true);
    if (!(File != null)) {
      return null;
    }
    
    // If there is a module that corresponds to this header, suggest it.
    if (!findUsableModuleForHeader(File, (Dir != null) ? Dir : File.getDir(), 
        RequestingModule, SuggestedModule, 
        IsSystemHeaderDir)) {
      return null;
    }
    
    return File;
  }

/*public:*/
  /// \brief Retrieve the module map.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getModuleMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 590,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 591,
   FQN="clang::HeaderSearch::getModuleMap", NM="_ZN5clang12HeaderSearch12getModuleMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch12getModuleMapEv")
  //</editor-fold>
  public ModuleMap /*&*/ getModuleMap() {
    return ModMap;
  }

  
  /// \brief Retrieve the module map.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getModuleMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 593,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 594,
   FQN="clang::HeaderSearch::getModuleMap", NM="_ZNK5clang12HeaderSearch12getModuleMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch12getModuleMapEv")
  //</editor-fold>
  public /*const*/ ModuleMap /*&*/ getModuleMap$Const() /*const*/ {
    return ModMap;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::header_file_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 595,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 596,
   FQN="clang::HeaderSearch::header_file_size", NM="_ZNK5clang12HeaderSearch16header_file_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch16header_file_sizeEv")
  //</editor-fold>
  public /*uint*/int header_file_size() /*const*/ {
    return FileInfo.size();
  }

  
  /// \brief Return the HeaderFileInfo structure for the specified FileEntry,
  /// in preparation for updating it in some way.
  
  /// getFileInfo - Return the HeaderFileInfo structure for the specified
  /// FileEntry.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 954,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 951,
   FQN="clang::HeaderSearch::getFileInfo", NM="_ZN5clang12HeaderSearch11getFileInfoEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch11getFileInfoEPKNS_9FileEntryE")
  //</editor-fold>
  public HeaderFileInfo /*&*/ getFileInfo(/*const*/ FileEntry /*P*/ FE) {
    if ($greatereq_uint(FE.getUID(), FileInfo.size())) {
      FileInfo.resize(FE.getUID() + 1);
    }
    
    HeaderFileInfo /*P*/ HFI = $AddrOf(FileInfo.$at(FE.getUID()));
    // FIXME: Use a generation count to check whether this is really up to date.
    if ((ExternalSource != null) && !HFI.Resolved) {
      HFI.Resolved = true;
      HeaderFileInfo ExternalHFI = ExternalSource.GetHeaderFileInfo(FE);
      
      HFI = $AddrOf(FileInfo.$at(FE.getUID()));
      if (ExternalHFI.External) {
        mergeHeaderFileInfo($Deref(HFI), ExternalHFI);
      }
    }

    HFI.IsValid = true;
    // We have local information about this header file, so it's no longer
    // strictly external.
    HFI.External = false;
    return $Deref(HFI);
  }

  
  /// \brief Return the HeaderFileInfo structure for the specified FileEntry,
  /// if it has ever been filled in.
  /// \param WantExternal Whether the caller wants purely-external header file
  ///        info (where \p External is true).
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getExistingFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 976,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 973,
   FQN="clang::HeaderSearch::getExistingFileInfo", NM="_ZNK5clang12HeaderSearch19getExistingFileInfoEPKNS_9FileEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch19getExistingFileInfoEPKNS_9FileEntryEb")
  //</editor-fold>
  public /*const*/ HeaderFileInfo /*P*/ getExistingFileInfo(/*const*/ FileEntry /*P*/ FE) /*const*/ {
    return getExistingFileInfo(FE, 
                     true);
  }
  public /*const*/ HeaderFileInfo /*P*/ getExistingFileInfo(/*const*/ FileEntry /*P*/ FE, 
                     boolean WantExternal/*= true*/) /*const*/ {
    // If we have an external source, ensure we have the latest information.
    // FIXME: Use a generation count to check whether this is really up to date.
    HeaderFileInfo /*P*/ HFI;
    if ((ExternalSource != null)) {
      if ($greatereq_uint(FE.getUID(), FileInfo.size())) {
        if (!WantExternal) {
          return null;
        }
        FileInfo.resize(FE.getUID() + 1);
      }
      
      HFI = $AddrOf(FileInfo.$at(FE.getUID()));
      if (!WantExternal && (!HFI.IsValid || HFI.External)) {
        return null;
      }
      if (!HFI.Resolved) {
        HFI.Resolved = true;
        HeaderFileInfo ExternalHFI = ExternalSource.GetHeaderFileInfo(FE);
        
        HFI = $AddrOf(FileInfo.$at(FE.getUID()));
        if (ExternalHFI.External) {
          mergeHeaderFileInfo($Deref(HFI), ExternalHFI);
        }
      }
    } else if ($greatereq_uint(FE.getUID(), FileInfo.size())) {
      return null;
    } else {
      HFI = $AddrOf(FileInfo.$at(FE.getUID()));
    }
    if (!HFI.IsValid || (HFI.External && !WantExternal)) {
      return null;
    }
    
    return HFI;
  }

  
  // Used by external tools
  /*typedef std::vector<DirectoryLookup>::const_iterator search_dir_iterator*/
//  public final class search_dir_iterator extends std.vector.iterator<DirectoryLookup>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::search_dir_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 610,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 611,
   FQN="clang::HeaderSearch::search_dir_begin", NM="_ZNK5clang12HeaderSearch16search_dir_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch16search_dir_beginEv")
  //</editor-fold>
  public std.vector.iterator<DirectoryLookup> search_dir_begin() /*const*/ {
    return SearchDirs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::search_dir_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 611,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 612,
   FQN="clang::HeaderSearch::search_dir_end", NM="_ZNK5clang12HeaderSearch14search_dir_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch14search_dir_endEv")
  //</editor-fold>
  public std.vector.iterator<DirectoryLookup> search_dir_end() /*const*/ {
    return SearchDirs.end();
  }

  /*package*/vector<DirectoryLookup> $SearchDirs() {
    return SearchDirs;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::search_dir_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 612,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 613,
   FQN="clang::HeaderSearch::search_dir_size", NM="_ZNK5clang12HeaderSearch15search_dir_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch15search_dir_sizeEv")
  //</editor-fold>
  public /*uint*/int search_dir_size() /*const*/ {
    return SearchDirs.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::quoted_dir_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 614,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 615,
   FQN="clang::HeaderSearch::quoted_dir_begin", NM="_ZNK5clang12HeaderSearch16quoted_dir_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch16quoted_dir_beginEv")
  //</editor-fold>
  public std.vector.iterator<DirectoryLookup> quoted_dir_begin() /*const*/ {
    return SearchDirs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::quoted_dir_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 617,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 618,
   FQN="clang::HeaderSearch::quoted_dir_end", NM="_ZNK5clang12HeaderSearch14quoted_dir_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch14quoted_dir_endEv")
  //</editor-fold>
  public std.vector.iterator<DirectoryLookup> quoted_dir_end() /*const*/ {
    return SearchDirs.begin().$add(AngledDirIdx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::angled_dir_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 621,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 622,
   FQN="clang::HeaderSearch::angled_dir_begin", NM="_ZNK5clang12HeaderSearch16angled_dir_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch16angled_dir_beginEv")
  //</editor-fold>
  public std.vector.iterator<DirectoryLookup> angled_dir_begin() /*const*/ {
    return SearchDirs.begin().$add(AngledDirIdx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::angled_dir_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 624,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 625,
   FQN="clang::HeaderSearch::angled_dir_end", NM="_ZNK5clang12HeaderSearch14angled_dir_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch14angled_dir_endEv")
  //</editor-fold>
  public std.vector.iterator<DirectoryLookup> angled_dir_end() /*const*/ {
    return SearchDirs.begin().$add(SystemDirIdx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::system_dir_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 628,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 629,
   FQN="clang::HeaderSearch::system_dir_begin", NM="_ZNK5clang12HeaderSearch16system_dir_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch16system_dir_beginEv")
  //</editor-fold>
  public std.vector.iterator<DirectoryLookup> system_dir_begin() /*const*/ {
    return SearchDirs.begin().$add(SystemDirIdx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::system_dir_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 631,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 632,
   FQN="clang::HeaderSearch::system_dir_end", NM="_ZNK5clang12HeaderSearch14system_dir_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch14system_dir_endEv")
  //</editor-fold>
  public std.vector.iterator<DirectoryLookup> system_dir_end() /*const*/ {
    return SearchDirs.end();
  }

  
  /// \brief Retrieve a uniqued framework name.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getUniqueFrameworkName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1090,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1087,
   FQN="clang::HeaderSearch::getUniqueFrameworkName", NM="_ZN5clang12HeaderSearch22getUniqueFrameworkNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch22getUniqueFrameworkNameEN4llvm9StringRefE")
  //</editor-fold>
  public StringRef getUniqueFrameworkName(StringRef Framework) {
    return FrameworkNames.insert(/*NO_COPY*/Framework).first.$arrow().first();
  }

  /// \brief Suggest a path by which the specified file could be found, for
  /// use in diagnostics to suggest a #include.
  ///
  /// \param IsSystem If non-null, filled in to indicate whether the suggested
  ///        path is relative to a system header directory.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::suggestPathToFileForDiagnostics">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1430,
   FQN="clang::HeaderSearch::suggestPathToFileForDiagnostics", NM="_ZN5clang12HeaderSearch31suggestPathToFileForDiagnosticsEPKNS_9FileEntryEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch31suggestPathToFileForDiagnosticsEPKNS_9FileEntryEPb")
  //</editor-fold>
  public std.string suggestPathToFileForDiagnostics(/*const*/ FileEntry /*P*/ File) {
    return suggestPathToFileForDiagnostics(File, 
                                 (bool$ptr/*bool P*/ )null);
  }
  public std.string suggestPathToFileForDiagnostics(/*const*/ FileEntry /*P*/ File, 
                                 bool$ptr/*bool P*/ IsSystem/*= null*/) {
    // FIXME: We assume that the path name currently cached in the FileEntry is
    // the most appropriate one for this analysis (and that it's spelled the same
    // way as the corresponding header search path).
    /*const*/char$ptr/*char P*/ Name = $tryClone(File.getName());
    
    /*uint*/int BestPrefixLength = 0;
    /*uint*/int BestSearchDir = 0; // JAVA: initilized to zero
    
    for (/*uint*/int I = 0; I != SearchDirs.size(); ++I) {
      // FIXME: Support this search within frameworks and header maps.
      if (!SearchDirs.$at(I).isNormalDir()) {
        continue;
      }
      
      /*const*/char$ptr/*char P*/ Dir = $tryClone(SearchDirs.$at(I).getDir().getName());
      for (path.const_iterator NI = path.begin(new StringRef(Name)), 
          NE = path.end(new StringRef(Name)), 
          DI = path.begin(new StringRef(Dir)), 
          DE = path.end(new StringRef(Dir));; NI.$preInc() , DI.$preInc()) {
        // '.' components in Name are ignored.
        while (NI.$noteq(NE) && $eq_StringRef(/*NO_COPY*/NI.$star(), /*STRINGREF_STR*/".")) {
          NI.$preInc();
        }
        if (NI.$eq(NE)) {
          break;
        }
        
        // '.' components in Dir are ignored.
        while (DI.$noteq(DE) && $eq_StringRef(/*NO_COPY*/DI.$star(), /*STRINGREF_STR*/".")) {
          DI.$preInc();
        }
        if (DI.$eq(DE)) {
          // Dir is a prefix of Name, up to '.' components and choice of path
          // separators.
          /*uint*/int PrefixLength = NI.$sub(path.begin(new StringRef(Name)));
          if ($greater_uint(PrefixLength, BestPrefixLength)) {
            BestPrefixLength = PrefixLength;
            BestSearchDir = I;
          }
          break;
        }
        if ($noteq_StringRef(/*NO_COPY*/NI.$star(), /*NO_COPY*/DI.$star())) {
          break;
        }
      }
    }
    if ((IsSystem != null)) {
      IsSystem.$set((BestPrefixLength != 0) ? $greatereq_uint(BestSearchDir, SystemDirIdx) : false);
    }
    return new std.string(Name.$add(BestPrefixLength));
  }

    
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::PrintStats">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 79,
   FQN="clang::HeaderSearch::PrintStats", NM="_ZN5clang12HeaderSearch10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() {
      PrintStats(llvm.errs()); // MANUAL_SEMANTIC
  }
  public void PrintStats(raw_ostream /*&*/ OS) {
    OS.$out(String.format("\n*** HeaderSearch Stats:\n"));
    OS.$out(String.format("%d files tracked.\n", (int)FileInfo.size()));
    /*uint*/int NumOnceOnlyFiles = 0, MaxNumIncludes = 0, NumSingleIncludedFiles = 0;
    for (/*uint*/int i = 0, e = FileInfo.size(); i != e; ++i) {
      NumOnceOnlyFiles += (FileInfo.$at(i).isImport ? 1 : 0);
      if ($less_uint_ushort(MaxNumIncludes, FileInfo.$at(i).NumIncludes)) {
        MaxNumIncludes = $ushort2uint(FileInfo.$at(i).NumIncludes);
      }
      NumSingleIncludedFiles += (($ushort2int(FileInfo.$at(i).NumIncludes) == 1) ? 1 : 0);
    }
    OS.$out(String.format("  %d #import/#pragma once files.\n", NumOnceOnlyFiles));
    OS.$out(String.format("  %d included exactly once.\n", NumSingleIncludedFiles));
    OS.$out(String.format("  %d max times a file is included.\n", MaxNumIncludes));
    
    OS.$out(String.format("  %d #include/#include_next/#import.\n", NumIncluded));
    OS.$out(String.format("    %d #includes skipped due to the multi-include optimization.\n", NumMultiIncludeFileOptzn));
    
    OS.$out(String.format("%d framework lookups.\n", NumFrameworkLookups));
    OS.$out(String.format("%d subframework lookups.\n", NumSubFrameworkLookups));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::getTotalMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1082,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1079,
   FQN="clang::HeaderSearch::getTotalMemory", NM="_ZNK5clang12HeaderSearch14getTotalMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang12HeaderSearch14getTotalMemoryEv")
  //</editor-fold>
  public /*size_t*/int getTotalMemory() /*const*/ {
    return SearchDirs.capacity()
       + llvm.capacity_in_bytes(FileInfo)
       + llvm.capacity_in_bytes(HeaderMaps)
       + $ulong2uint(LookupFileCache.getAllocator().getTotalMemory())
       + $ulong2uint(FrameworkMap.getAllocator().getTotalMemory());
  }

/*private:*/
  /// \brief Describes what happened when we tried to load a module map file.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::LoadModuleMapResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", line = 650,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearch.h", old_line = 646,
   FQN="clang::HeaderSearch::LoadModuleMapResult", NM="_ZN5clang12HeaderSearch19LoadModuleMapResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch19LoadModuleMapResultE")
  //</editor-fold>
  private enum LoadModuleMapResult implements Native.ComparableLower {
    /// \brief The module map file had already been loaded.
    LMM_AlreadyLoaded(0),
    /// \brief The module map file was loaded by this invocation.
    LMM_NewlyLoaded(LMM_AlreadyLoaded.getValue() + 1),
    /// \brief There is was directory with the given name.
    LMM_NoDirectory(LMM_NewlyLoaded.getValue() + 1),
    /// \brief There was either no module map file or the module map file was
    /// invalid.
    LMM_InvalidModuleMap(LMM_NoDirectory.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LoadModuleMapResult valueOf(int val) {
      LoadModuleMapResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LoadModuleMapResult[] VALUES;
      private static final LoadModuleMapResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LoadModuleMapResult kind : LoadModuleMapResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LoadModuleMapResult[min < 0 ? (1-min) : 0];
        VALUES = new LoadModuleMapResult[max >= 0 ? (1+max) : 0];
        for (LoadModuleMapResult kind : LoadModuleMapResult.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private LoadModuleMapResult(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LoadModuleMapResult)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LoadModuleMapResult)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::loadModuleMapFileImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1231,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1228,
   FQN="clang::HeaderSearch::loadModuleMapFileImpl", NM="_ZN5clang12HeaderSearch21loadModuleMapFileImplEPKNS_9FileEntryEbPKNS_14DirectoryEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch21loadModuleMapFileImplEPKNS_9FileEntryEbPKNS_14DirectoryEntryE")
  //</editor-fold>
  private HeaderSearch.LoadModuleMapResult loadModuleMapFileImpl(/*const*/ FileEntry /*P*/ File, boolean IsSystem, 
                       /*const*/ DirectoryEntry /*P*/ Dir) {
    assert ((File != null)) : "expected FileEntry";

    // Check whether we've already loaded this module map, and mark it as being
    // loaded in case we recursively try to load it from itself.
    pairTypeBool<DenseMapIteratorTypeBool</*const*/ FileEntry /*P*/>> AddResult = LoadedModuleMaps.insert(std.make_pair_Ptr_bool(File, true));
    if (!AddResult.second) {
      return AddResult.first.$arrow().second ? LoadModuleMapResult.LMM_AlreadyLoaded : LoadModuleMapResult.LMM_InvalidModuleMap;
    }
    if (ModMap.parseModuleMapFile(File, IsSystem, Dir)) {
      LoadedModuleMaps.$set(File, false);
      return LoadModuleMapResult.LMM_InvalidModuleMap;
    }
    {

      // Try to load a corresponding private module map.
      /*const*/ FileEntry /*P*/ PMMFile = getPrivateModuleMap(File, FileMgr);
      if ((PMMFile != null)) {
        if (ModMap.parseModuleMapFile(PMMFile, IsSystem, Dir)) {
          LoadedModuleMaps.$set(File, false);
          return LoadModuleMapResult.LMM_InvalidModuleMap;
        }
      }
    }

    // This directory has a module map.
    return LoadModuleMapResult.LMM_NewlyLoaded;
  }
  
  
  /// \brief Try to load the module map file in the given directory.
  ///
  /// \param DirName The name of the directory where we will look for a module
  /// map file.
  /// \param IsSystem Whether this is a system header directory.
  /// \param IsFramework Whether this is a framework directory.
  ///
  /// \returns The result of attempting to load the module map file from the
  /// named directory.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::loadModuleMapFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1304,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1301,
   FQN="clang::HeaderSearch::loadModuleMapFile", NM="_ZN5clang12HeaderSearch17loadModuleMapFileEN4llvm9StringRefEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch17loadModuleMapFileEN4llvm9StringRefEbb")
  //</editor-fold>
  private HeaderSearch.LoadModuleMapResult loadModuleMapFile(StringRef DirName, boolean IsSystem, 
                   boolean IsFramework) {
    {
      /*const*/ DirectoryEntry /*P*/ Dir = FileMgr.getDirectory(/*NO_COPY*/DirName);
      if ((Dir != null)) {
        return loadModuleMapFile(Dir, IsSystem, IsFramework);
      }
    }
    
    return LoadModuleMapResult.LMM_NoDirectory;
  }

  
  /// \brief Try to load the module map file in the given directory.
  ///
  /// \param Dir The directory where we will look for a module map file.
  /// \param IsSystem Whether this is a system header directory.
  /// \param IsFramework Whether this is a framework directory.
  ///
  /// \returns The result of attempting to load the module map file from the
  /// named directory.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearch::loadModuleMapFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 1313,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 1310,
   FQN="clang::HeaderSearch::loadModuleMapFile", NM="_ZN5clang12HeaderSearch17loadModuleMapFileEPKNS_14DirectoryEntryEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang12HeaderSearch17loadModuleMapFileEPKNS_14DirectoryEntryEbb")
  //</editor-fold>
  private HeaderSearch.LoadModuleMapResult loadModuleMapFile(/*const*/ DirectoryEntry /*P*/ Dir, boolean IsSystem, 
                   boolean IsFramework) {
    DenseMapIteratorTypeBool</*const*/ DirectoryEntry /*P*/> KnownDir = DirectoryHasModuleMap.find(Dir);
    if (KnownDir.$noteq(/*NO_ITER_COPY*/DirectoryHasModuleMap.end())) {
      return KnownDir.$arrow().second ? LoadModuleMapResult.LMM_AlreadyLoaded : LoadModuleMapResult.LMM_InvalidModuleMap;
    }
    {

      /*const*/ FileEntry /*P*/ ModuleMapFile = lookupModuleMapFile(Dir, IsFramework);
      if ((ModuleMapFile != null)) {
        LoadModuleMapResult Result = loadModuleMapFileImpl(ModuleMapFile, IsSystem, Dir);
        // Add Dir explicitly in case ModuleMapFile is in a subdirectory.
        // E.g. Foo.framework/Modules/module.modulemap
        //      ^Dir                  ^ModuleMapFile
        if (Result == LoadModuleMapResult.LMM_NewlyLoaded) {
          DirectoryHasModuleMap.$set(Dir, true);
        } else if (Result == LoadModuleMapResult.LMM_InvalidModuleMap) {
          DirectoryHasModuleMap.$set(Dir, false);
        }
        return Result;
      }
    }
    return LoadModuleMapResult.LMM_InvalidModuleMap;
  }

  
  public String toString() {
    return "" + "HSOpts=" + HSOpts // NOI18N
             /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diags=" + Diags // NOI18N*/
             /* STACKOVERFLOW: NEVER PRINT FileManager + ", FileMgr=" + FileMgr // NOI18N*/
              + ", SearchDirs=" + SearchDirs // NOI18N
              + ", AngledDirIdx=" + AngledDirIdx // NOI18N
              + ", SystemDirIdx=" + SystemDirIdx // NOI18N
              + ", NoCurDirSearch=" + NoCurDirSearch // NOI18N
              + ", SystemHeaderPrefixes=" + SystemHeaderPrefixes // NOI18N
              + ", ModuleCachePath=" + ModuleCachePath // NOI18N
              + ", FileInfo=" + FileInfo // NOI18N
              + ", LookupFileCache=" + LookupFileCache // NOI18N
              + ", FrameworkMap=" + FrameworkMap // NOI18N
              + ", IncludeAliases=" + IncludeAliases // NOI18N
              + ", HeaderMaps=" + HeaderMaps // NOI18N
              + ", ModMap=" + ModMap // NOI18N
              + ", DirectoryHasModuleMap=" + DirectoryHasModuleMap // NOI18N
              + ", LoadedModuleMaps=" + LoadedModuleMaps // NOI18N
              + ", FrameworkNames=" + FrameworkNames // NOI18N
              + ", ExternalLookup=" + ExternalLookup // NOI18N
              + ", ExternalSource=" + ExternalSource // NOI18N
              + ", NumIncluded=" + NumIncluded // NOI18N
              + ", NumMultiIncludeFileOptzn=" + NumMultiIncludeFileOptzn // NOI18N
              + ", NumFrameworkLookups=" + NumFrameworkLookups // NOI18N
              + ", NumSubFrameworkLookups=" + NumSubFrameworkLookups; // NOI18N
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // JAVA PERF: Caches
  private final SmallString $LookupFileTmpDir = new SmallString(1024);
  private boolean $LookupFileTmpDirInUse = false;
  private SmallString $getLookupFileTmpDir() {
    assert (!$LookupFileTmpDirInUse) && ($LookupFileTmpDirInUse = true);
    return $LookupFileTmpDir;
  }
  private void $releaseLookupFileTmpDir(SmallString buf) {
    assert $LookupFileTmpDirInUse;
    assert ($LookupFileTmpDirInUse = false) || true;
    assert buf == $LookupFileTmpDir;
    $LookupFileTmpDir.clear();
  }    

  private final SmallString $LookupFileMappedName = new SmallString/*64*/(64);
  private boolean $LookupFileMappedNameInUse = false;
  private SmallString $getLookupFileMappedName() {
    assert (!$LookupFileMappedNameInUse) && ($LookupFileMappedNameInUse = true);
    return $LookupFileMappedName;
  }
  private void $releaseLookupFileMappedName(SmallString buf) {
    assert $LookupFileMappedNameInUse;
    assert ($LookupFileMappedNameInUse = false) || true;
    assert buf == $LookupFileMappedName;
    $LookupFileMappedName.clear();
  }
  
  private final bool$ref $InUserSpecifiedSystemFramework = create_bool$ref(false);
  private boolean $InUserSpecifiedSystemFrameworkInUse = false;
  private bool$ref $getInUserSpecifiedSystemFramework(boolean val) {
    assert (!$InUserSpecifiedSystemFrameworkInUse) && ($InUserSpecifiedSystemFrameworkInUse = true);
    $InUserSpecifiedSystemFramework.$set(val);
    return $InUserSpecifiedSystemFramework;
  }
  private boolean $releaseInUserSpecifiedSystemFramework(bool$ref buf) {
    assert $InUserSpecifiedSystemFrameworkInUse;
    assert ($InUserSpecifiedSystemFrameworkInUse = false) || true;
    assert buf == $InUserSpecifiedSystemFramework;
    return $InUserSpecifiedSystemFramework.$deref();
  }  
  
  private final bool$ref $HasBeenMapped = create_bool$ref(false);
  private boolean $HasBeenMappedInUse = false;
  private bool$ref $getHasBeenMapped(boolean val) {
    assert (!$HasBeenMappedInUse) && ($HasBeenMappedInUse = true);
    $HasBeenMapped.$set(val);
    return $HasBeenMapped;
  }
  private boolean $releaseHasBeenMapped(bool$ref buf) {
    assert $HasBeenMappedInUse;
    assert ($HasBeenMappedInUse = false) || true;
    assert buf == $HasBeenMapped;
    return $HasBeenMapped.$deref();
  }  
}
