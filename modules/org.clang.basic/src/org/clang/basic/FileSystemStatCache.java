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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import static org.clang.basic.impl.FileSystemStatCacheStatics.*;
import org.clank.support.JavaDifferentiators.JD$Move;

/// \brief Abstract interface for introducing a FileManager cache for 'stat'
/// system calls, which is used by precompiled and pretokenized headers to
/// improve performance.
//<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 48,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 48,
 FQN = "clang::FileSystemStatCache", NM = "_ZN5clang19FileSystemStatCacheE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCacheE")
//</editor-fold>
public abstract class FileSystemStatCache implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp", line = 20,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp", old_line = 31,
   FQN = "clang::FileSystemStatCache::anchor", NM = "_ZN5clang19FileSystemStatCache6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCache6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  protected unique_ptr<FileSystemStatCache> NextStatCache = new unique_ptr<FileSystemStatCache>((FileSystemStatCache) null);
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::~FileSystemStatCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 54,
   FQN = "clang::FileSystemStatCache::~FileSystemStatCache", NM = "_ZN5clang19FileSystemStatCacheD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCacheD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    NextStatCache.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::LookupResult">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 56,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 56,
   FQN = "clang::FileSystemStatCache::LookupResult", NM = "_ZN5clang19FileSystemStatCache12LookupResultE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCache12LookupResultE")
  //</editor-fold>
  public enum LookupResult {
    CacheExists(0), ///< We know the file exists and its cached stat data.
    CacheMissing(CacheExists.getValue() + 1); ///< We know that the file doesn't exist.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LookupResult valueOf(int val) {
      LookupResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final LookupResult[] VALUES;
      private static final LookupResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LookupResult kind : LookupResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LookupResult[min < 0 ? (1-min) : 0];
        VALUES = new LookupResult[max >= 0 ? (1+max) : 0];
        for (LookupResult kind : LookupResult.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private LookupResult(/*uint*/int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
  
  /// \brief Get the 'stat' information for the specified path, using the cache
  /// to accelerate it if possible.
  ///
  /// \returns \c true if the path does not exist or \c false if it exists.
  ///
  /// If isFile is true, then this lookup should only return success for files
  /// (not directories).  If it is false this lookup should only return
  /// success for directories (not files).  On a successful file lookup, the
  /// implementation can optionally fill in \p F with a valid \p File object and
  /// the client guarantees that it will close it.
  
  /// FileSystemStatCache::get - Get the 'stat' information for the specified
  /// path, using the cache to accelerate it if possible.  This returns true if
  /// the path does not exist or false if it exists.
  ///
  /// If isFile is true, then this lookup should only return success for files
  /// (not directories).  If it is false this lookup should only return
  /// success for directories (not files).  On a successful file lookup, the
  /// implementation can optionally fill in FileDescriptor with a valid
  /// descriptor and the client guarantees that it will close it.
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::get">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp", line = 43,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp", old_line = 54,
   FQN = "clang::FileSystemStatCache::get", NM = "_ZN5clang19FileSystemStatCache3getEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EEPS0_RNS6_10FileSystemE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCache3getEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EEPS0_RNS6_10FileSystemE")
  //</editor-fold>
  public static boolean get(/*const*/char$ptr/*char P*/ Path, int PathLen, FileData /*&*/ Data, boolean isFile, 
     std.unique_ptr<File> /*P*/ F, 
     FileSystemStatCache /*P*/ Cache, FileSystem /*&*/ FS) {
    LookupResult R;
    boolean isForDir = !isFile;

    // If we have a cache, use it to resolve the stat query.
    if ((Cache != null)) {
      R = Cache.getStat(Path, PathLen, Data, isFile, F, FS);
    } else if (isForDir || !(F != null)) {
      // If this is a directory or a file descriptor is not needed and we have
      // no cache, just go to the file system.
      ErrorOr<Status> Status = FS.status(new Twine(Path));
      if (!Status.$bool()) {
        R = LookupResult.CacheMissing;
      } else {
        R = LookupResult.CacheExists;
        copyStatusToFileData(Status.$star(), Data);
      }
    } else {
      // Otherwise, we have to go to the filesystem.  We can always just use
      // 'stat' here, but (for files) the client is asking whether the file exists
      // because it wants to turn around and *open* it.  It is more efficient to
      // do "open+fstat" on success than it is to do "stat+open".
      //
      // Because of this, check to see if the file exists with 'open'.  If the
      // open succeeds, use fstat to get the stat info.
      ErrorOr<unique_ptr<File>> OwnedFile = FS.openFileForRead(new Twine(Path));
      if (!OwnedFile.$bool()) {
        // If the open fails, our "stat" fails.
        R = LookupResult.CacheMissing;
      } else {
        // Otherwise, the open succeeded.  Do an fstat to get the information
        // about the file.  We'll end up returning the open file descriptor to the
        // client to do what they please with it.
        ErrorOr<Status> Status = (OwnedFile.$star()).$arrow().status();
        if (Status.$bool()) {
          R = LookupResult.CacheExists;
          copyStatusToFileData(Status.$star(), Data);
          /*Deref*/F.$assignMove(std.move(OwnedFile.$star()));
        } else {
          // fstat rarely fails.  If it does, claim the initial open didn't
          // succeed.
          R = LookupResult.CacheMissing;
          /*Deref*/F.$assign_nullptr_t(null);
        }
      }
    }

    // If the path doesn't exist, return failure.
    if (R == LookupResult.CacheMissing) {
      return true;
    }

    // If the path exists, make sure that its "directoryness" matches the clients
    // demands.
    if (Data.IsDirectory != isForDir) {
      // If not, close the file if opened.
      if ((F != null)) {
        /*Deref*/F.$assign_nullptr_t(null);
      }

      return true;
    }

    return false;
  }

  
  /// \brief Sets the next stat call cache in the chain of stat caches.
  /// Takes ownership of the given stat cache.
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::setNextStatCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 77,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 77,
   FQN = "clang::FileSystemStatCache::setNextStatCache", NM = "_ZN5clang19FileSystemStatCache16setNextStatCacheESt10unique_ptrIS0_St14default_deleteIS0_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCache16setNextStatCacheESt10unique_ptrIS0_St14default_deleteIS0_EE")
  //</editor-fold>
  public void setNextStatCache(std.unique_ptr<FileSystemStatCache> Cache) {
    NextStatCache.$assignMove(std.move(Cache));
  }

  
  /// \brief Retrieve the next stat call cache in the chain.
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::getNextStatCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 82,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 82,
   FQN = "clang::FileSystemStatCache::getNextStatCache", NM = "_ZN5clang19FileSystemStatCache16getNextStatCacheEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCache16getNextStatCacheEv")
  //</editor-fold>
  public FileSystemStatCache /*P*/ getNextStatCache() {
    return NextStatCache.get();
  }

  
  /// \brief Retrieve the next stat call cache in the chain, transferring
  /// ownership of this cache (and, transitively, all of the remaining caches)
  /// to the caller.
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::takeNextStatCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 87,
   FQN="clang::FileSystemStatCache::takeNextStatCache", NM="_ZN5clang19FileSystemStatCache17takeNextStatCacheEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCache17takeNextStatCacheEv")
  //</editor-fold>
  public std.unique_ptr<FileSystemStatCache> takeNextStatCache() {
    return new std.unique_ptr<FileSystemStatCache>(JD$Move.INSTANCE, std.move(NextStatCache));
  }

/*protected:*/
  // FIXME: The pointer here is a non-owning/optional reference to the
  // unique_ptr. Optional<unique_ptr<vfs::File>&> might be nicer, but
  // Optional needs some work to support references so this isn't possible yet.
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::getStat">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 95,
   FQN="clang::FileSystemStatCache::getStat", NM="_ZN5clang19FileSystemStatCache7getStatEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EERNS6_10FileSystemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCache7getStatEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EERNS6_10FileSystemE")
  //</editor-fold>
  protected abstract /*virtual*/ LookupResult getStat(/*const*/char$ptr/*char P*/ Path, int PathLen/*MANUAL_SEMANTIC*/,
         FileData /*&*/ Data, boolean isFile, 
         std.unique_ptr<File> /*P*/ F, 
         FileSystem /*&*/ FS)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::statChained">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", old_line = 99,
   FQN = "clang::FileSystemStatCache::statChained", NM = "_ZN5clang19FileSystemStatCache11statChainedEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EERNS6_10FileSystemE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileSystemStatCache.cpp -nm=_ZN5clang19FileSystemStatCache11statChainedEPKcRNS_8FileDataEbPSt10unique_ptrINS_3vfs4FileESt14default_deleteIS7_EERNS6_10FileSystemE")
  //</editor-fold>
  protected LookupResult statChained(/*const*/char$ptr/*char P*/ Path, int PathLen, FileData /*&*/ Data, boolean isFile, 
             std.unique_ptr<File> /*P*/ F, FileSystem /*&*/ FS) {
    {
      FileSystemStatCache /*P*/ Next = getNextStatCache();
      if ((Next != null)) {
        return Next.getStat(Path, PathLen, Data, isFile, F, FS);
      }
    }

    // If we hit the end of the list of stat caches to try, just compute and
    // return it without a cache.
    return get(Path, PathLen, Data, isFile, F, null, FS) ? LookupResult.CacheMissing : LookupResult.CacheExists;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileSystemStatCache::FileSystemStatCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileSystemStatCache.h", line = 48,
   FQN="clang::FileSystemStatCache::FileSystemStatCache", NM="_ZN5clang19FileSystemStatCacheC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN5clang19FileSystemStatCacheC1Ev")
  //</editor-fold>
  public /*inline*/ FileSystemStatCache() {
    /* : NextStatCache()*/ 
    //START JInit
    this.NextStatCache = new std.unique_ptr<FileSystemStatCache>();
    //END JInit
  }  
  
  public String toString() {
    return "" + "NextStatCache=" + NextStatCache; // NOI18N
  }
}
