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

package org.clang.tools.services.impl;

import org.clang.frontend.java.PTHCachedTokensProducer;
import java.util.Iterator;
import java.util.LinkedList;
import static org.clang.basic.BasicClangGlobals.$out_DiagnosticBuilder$C_StringRef;
import org.clang.basic.DiagnosticsEngine;
import org.clang.basic.FileData;
import org.clang.basic.FileManager;
import org.clang.basic.FileSystemOptions;
import org.clang.basic.FileSystemStatCache;
import org.clang.basic.diag;
import org.clang.basic.vfs.FileSystem;
import org.clang.lex.PTHManager;
import org.clang.lex.java.PTHManagerDriver;
import org.clank.java.std;
import org.clank.support.NativeTrace;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.StringMap;
import org.llvm.support.ErrorOr;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.llvm;
/**
 * pool of reusable LLVM objects.
 * 
 * @author Vladimir Voskresensky
 */
final class PreprocessorInitializerHelper {

  private PreprocessorInitializerHelper() {
  }
  
  private static final PTHCachedTokensProducer $CachedTokensProducer = new PTHCachedTokensProducer();
  private static final boolean SHARED_FILE_MANAGER = false; // FileManger is not thread safe, see i.e. UFE.UID = NextFileUID++ in getFile
  private static final FileSystemOptions FileMgrOpts = new FileSystemOptions();  
  private static FileManager $FileMgr = null;

  // information associated with token-cache file path and it's PTHManager/MemoryBuffer
  private static final LinkedList<std.pair<std.string, std.pair<PTHManager, MemoryBuffer>>> $ManagedPTH = new LinkedList<>();
  
  static FileManager $getFileManager(
          SharedMemoryBufferCache sharedMemoryBufferCache, 
          StringMap<FileData/*, BumpPtrAllocator*/> FileStatCache,
          StringMap<FileData/*, BumpPtrAllocator*/> DirectoryStatCache,
          IntrusiveRefCntPtr<FileSystem> FS) {
    FileManager FileMgr = $FileMgr;
    if (FileMgr == null) {
      FileMgr = new FileManager(FileMgrOpts, FS);
      FileSystemStatCache sharedStatCache;
      if (PreprocessorSupport.KEEP_STAT_MISSES) {
        sharedStatCache = new SharedStatCache(FileStatCache, DirectoryStatCache);
      } else {
        sharedStatCache = new SharedNoStatMissingCache(FileStatCache, DirectoryStatCache);
      }
      FileMgr.addStatCache(llvm.<FileSystemStatCache>make_unique(sharedStatCache));
    } else {
      // release
      $FileMgr = null;
    }
    return FileMgr;
  }
  
  static void $releaseFileManager(FileManager FileMgr) {
    assert FileMgr != null;
    if (SHARED_FILE_MANAGER) {
      assert $FileMgr == null;
      $FileMgr = FileMgr;
    } else {
      FileMgr.$destroy();
    }
  }

  static PTHManager $getPTHManager(std.string TokenCacheFilePath, DiagnosticsEngine Diags) {
    if (TokenCacheFilePath.empty()) {
      // either PTH driver or token-cache file must be active to create PTHManager
      if (PreprocessorSupport.USE_PTH_DRIVER) {
        if (!PreprocessorSupport.SHARED_PTH_MANAGER) {
          // create directly, no need to go into sync block
          return PTHManagerDriver.Create($CachedTokensProducer, null, Diags);
        }
      } else {
        // no any PTHManager related info
        return null;
      }
    }
    synchronized ($ManagedPTH) {
      std.pair<PTHManager, MemoryBuffer> PTHMgrPair = null;
      Iterator<std.pair<std.string, std.pair<PTHManager, MemoryBuffer>>> it = $ManagedPTH.iterator();
      while (it.hasNext()) {
        std.pair<std.string, std.pair<PTHManager, MemoryBuffer>> pair = it.next();
        if (TokenCacheFilePath.$eq(pair.first)) {
          PTHMgrPair = pair.second;
          PTHManager mgr = pair.second.first;
          if (mgr != null) {
            // found Manager released in $releasePTHManager, 
            // hide it for others and return for use
            pair.second.first = null;
            return mgr;
          }
        }
      }
      // not found manager for reuse
      // but may be found MemoryBuffer associated with token-cache
      MemoryBuffer tokenCacheMemBuffer = null;
      if (PTHMgrPair == null) {
        // create under common synchronized to load only one TokenCache memory buffer
        if (!TokenCacheFilePath.empty()) {
          ErrorOr<std.unique_ptr<MemoryBuffer> > FileOrErr = PTHManager.CreateMemoryBuffer(TokenCacheFilePath);
          if (FileOrErr.$bool()) {
            // was able to load token-cache
            tokenCacheMemBuffer = FileOrErr.get().release();
          }
        }
        // keep as new mapping between token-cache path and it's memory buffer
        PTHMgrPair = std.make_pair((PTHManager)null, (MemoryBuffer)tokenCacheMemBuffer);
        // remember new pair associated with file path and shared memory buffer
        // it will be used to release PTHManager
        $ManagedPTH.addFirst(std.make_pair(TokenCacheFilePath, PTHMgrPair));
      }
      assert PTHMgrPair.first == null : "should not have PTHManager at this phase; see while check above";
      assert PTHMgrPair.second != null || (TokenCacheFilePath.empty() && PreprocessorSupport.USE_PTH_DRIVER);
      if (PTHMgrPair.second == null && !TokenCacheFilePath.empty()) {
        // failed to create memory buffer for passed token cache file?
        $out_DiagnosticBuilder$C_StringRef(Diags.Report(diag.err_invalid_pth_file), new StringRef(TokenCacheFilePath));
      }
      tokenCacheMemBuffer = PTHMgrPair.second;
      // ready to create PTHManager for token-cache MemoryBuffer
      PTHManager PTHMgr = null;
      if (PreprocessorSupport.USE_PTH_DRIVER) {
        // Note: tokenCacheMemBuffer can be null if token-cache file was not passed
        PTHMgr = PTHManagerDriver.Create($CachedTokensProducer, tokenCacheMemBuffer, Diags);
      } else if (tokenCacheMemBuffer != null) {
        PTHMgr = PTHManager.Create(tokenCacheMemBuffer, Diags);
      }
      if (PTHMgr != null) {
        // set up sharing state of manager
        MemoryBuffer sharedMemBuffer = PTHMgr.$markShared(PreprocessorSupport.SHARED_PTH_MANAGER);
        assert sharedMemBuffer == tokenCacheMemBuffer;
      }
      return PTHMgr;
    }   
  }

  static void $releasePTHManager(std.string TokenCache, PTHManager PTHMgr) {
    if ((PTHMgr != null) && PreprocessorSupport.SHARED_PTH_MANAGER) {
      synchronized ($ManagedPTH) {
        if (NativeTrace.isDebugMode()) {
          for (std.pair<std.string, std.pair<PTHManager, MemoryBuffer>> pair : $ManagedPTH) {
            assert pair.second.first != PTHMgr : "can not release twice ";
          }
        }
        for (std.pair<std.string, std.pair<PTHManager, MemoryBuffer>> pair : $ManagedPTH) {
          if (TokenCache.$eq(pair.first)) {
            assert pair.second.second != null || (TokenCache.empty() && PreprocessorSupport.USE_PTH_DRIVER);
            if (pair.second.first == null) {
              // release for reuse
              pair.second.first = PTHMgr;
              return;
            }
          }          
        }
        assert PreprocessorSupport.USE_PTH_DRIVER : "empty pair must be found as added by $getPTHManager(TokenCache)";
        std.pair<PTHManager, MemoryBuffer> PTHMgrPair = std.make_pair(PTHMgr, PTHMgr.$getTokenCache());
        $ManagedPTH.addFirst(std.make_pair(TokenCache, PTHMgrPair));
      }
    }
  }

}
