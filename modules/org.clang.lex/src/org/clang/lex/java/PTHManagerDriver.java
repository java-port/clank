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

package org.clang.lex.java;

import java.util.concurrent.atomic.AtomicLong;
import org.clang.basic.*;
import org.clang.basic.vfs.File;
import org.clang.basic.vfs.FileSystem;
import org.clang.lex.PTHLexer;
import org.clang.lex.PTHManager;
import org.clang.lex.Preprocessor;
import org.clank.java.*;
import org.clank.support.NativeTrace;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.*;
import org.llvm.adt.*;
import org.llvm.support.*;
import org.openide.util.Lookup;

/**
 * JAVA:
 * Surrogate of PTHManager which provides the same interface for PP, but can
 * load on demand multiple PTH token cache files and delegate them as
 * multiple PTHManagers.
 * 
 * @author Vladimir Voskresensky
 */
public final class PTHManagerDriver extends PTHManager {

  private final PTHProducer OnDemandPTHProducer;
  private final PTHManager ExistingTokenCache;
  private final boolean tokenizeAllFiles;
  private final boolean cacheTokensWithComments;
  private final boolean cacheIncompelteTokenFlag;
  public interface PTHProducer {
    MemoryBuffer CreateCachedTokens(/*FileID*/int FID, std.string LexedFileName,
            Preprocessor PP, boolean needComments, boolean needIncompleteTokenState);
  }

  private PTHManagerDriver(PTHManager ExistingTokenCacheManager, PTHProducer PTHProducer, 
          boolean allFiles, boolean keepComments, boolean keepIncompleteTokenState) {
    super();
    this.ExistingTokenCache = ExistingTokenCacheManager;
    this.OnDemandPTHProducer = PTHProducer;
    this.tokenizeAllFiles = allFiles;
    this.cacheTokensWithComments = keepComments;
    this.cacheIncompelteTokenFlag = keepIncompleteTokenState;
  }

  public static void PreparePTHForPreprocessor(Preprocessor P) {
    PTHProducer PTHProducer = Lookup.getDefault().lookup(PTHProducer.class);
    if (PTHProducer == null) {
      throw new IllegalStateException("Forgot to add org.clang.frontend to unit tests dependency?");
    }
    PTHManagerDriver pm = new PTHManagerDriver(null, PTHProducer, true, true, true);
    assert P.getIdentifierTable().getExternalIdentifierLookup() == null;
    if (false) {
      P.getIdentifierTable().setExternalIdentifierLookup(pm);
    }
    P.setPTHManager(pm);
    pm.setPreprocessor(P);
  }
  
  public static PTHManager Create(PTHProducer PTHProducer, /*const*/MemoryBuffer/*&*/ tokenCacheMemBuffer, DiagnosticsEngine Diags) {    
    // this manager can wrap existing token-cache file and create on demand new token caches
    PTHManager ExistingTokenCacheManager = null;
    if (tokenCacheMemBuffer != null) {
      ExistingTokenCacheManager = PTHManager.Create(tokenCacheMemBuffer, Diags);
    }
    return new PTHManagerDriver(ExistingTokenCacheManager, PTHProducer, PREPARE_ALL_FILES_PTH, KEEP_PTH_COMMENTS, KEEP_INCOMPLETE_TOKEN_STATE);
  }

  @Override
  public void setPreprocessor(Preprocessor pp) {
    if (ExistingTokenCache != null) {
      ExistingTokenCache.setPreprocessor(pp);
    }
    super.setPreprocessor(pp);
  }

  @Override
  public PTHLexer CreateLexer(int FID) {
    if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
      TotalRequestedLexers.incrementAndGet();
    }
    assert PP != null : "Forgot to set Preprocessor for this manager?";
    if (FID == PP.getPredefinesFileID().$ID()) {
      // no need to create lexer for built-in or compile-flags buffers
      return null;
    }
    if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
      TotalNonBuiltinRequestedLexers.incrementAndGet();
    }
    if (ExistingTokenCache != null) {
      PTHLexer CachedLexer = ExistingTokenCache.CreateLexer(FID);
      if (CachedLexer != null) {
        if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
          cachedExternalTokensHit.incrementAndGet();
        }
        return CachedLexer;
      } else {
        if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
          cachedExternalTokensMisses.incrementAndGet();
        }
      }
    }    
    /*const*/ FileEntry /*P*/ FE = PP.getSourceManager().getFileEntryForID(FID);
    if (!(FE != null)) {
      return null;
    }    
    MemoryBuffer sourceFile = PP.getSourceManager().getBuffer(FID);
    assert sourceFile != null : "No Buffer for " + FE;
    if (sourceFile.isInvalid()) {
      // this is real situation when we resolved #include, but file disapeared
      return null;
    }
    assert !sourceFile.isInvalid() : "Invalid Buffer for " + FE;
    MemoryBuffer tokenCacheBuf = sourceFile.getTokenCacheBuffer();
    if (tokenCacheBuf == null) {
      if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
        cachedTokensMisses.incrementAndGet();
      }
      if (OnDemandPTHProducer != null) {
        // token cache is absent, let's create it for header files
        if (tokenizeAllFiles || FID != PP.getSourceManager().getMainFileID().$ID()) {
          std.string LexedFileName/*J*/= new StringRef(FE.getName()).str();
          tokenCacheBuf = OnDemandPTHProducer.CreateCachedTokens(FID, LexedFileName, 
                  PP, cacheTokensWithComments, cacheIncompelteTokenFlag);
          if (tokenCacheBuf != null) {
            tokenCacheBuf = sourceFile.setTokenCacheBuffer(tokenCacheBuf);
            if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
              cachedTokensCreated.incrementAndGet();
              cachedTokensCreatedSize.addAndGet(tokenCacheBuf.getBufferSize());
            }
          }
        }
      }
    } else {
      if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
        cachedTokensHit.incrementAndGet();
      }
    }
    if (tokenCacheBuf == null) {
      if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
        cachedTokensSkipped.incrementAndGet();
      }
      return null;
    }
    // TODO: should we cache FE => PTHManager to minimize PersistentID => IdentifierInfo conversion?
    PTHManager SingleFilePTHManager = PTHManager.CreatePTHManagerImpl(tokenCacheBuf, PP.getDiagnostics(), this);
    assert SingleFilePTHManager != null : "can not create manager for " + FE + " from " + tokenCacheBuf.getBufferIdentifier();
    MemoryBuffer pthBuf = SingleFilePTHManager.$markShared(super.$isShared());
    assert pthBuf == tokenCacheBuf;
    SingleFilePTHManager.setPreprocessor(PP);
    PTHLexer Out = SingleFilePTHManager.CreateLexer(FID);
    assert Out != null : "can not create lexer for " + FE + " from " + tokenCacheBuf.getBufferIdentifier();
    return Out;
  }

  @Override
  public IdentifierInfo GetIdentifierInfo(int PersistentID) {
    if (ExistingTokenCache != null) {
      return ExistingTokenCache.GetIdentifierInfo(PersistentID);
    }
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public std.unique_ptr<FileSystemStatCache> createStatCache() {
    return new std.unique_ptr<FileSystemStatCache>(new EmptyStatCache());
  }

  @Override
  public IdentifierInfo get(char$ptr Name, int Len) {
    if (ExistingTokenCache != null) {
      return ExistingTokenCache.get(Name, Len);
    }
    // don't have own identifiers
    return null;
  }

  @Override
  public IdentifierInfo get(byte[] Name, int NameStIndex, int Len) {
    if (ExistingTokenCache != null) {
      return ExistingTokenCache.get(Name, NameStIndex, Len);
    }
    // don't have own identifiers
    return null;
  }

  @Override
  public char$ptr getOriginalSourceFile() {
    if (ExistingTokenCache != null) {
      return ExistingTokenCache.getOriginalSourceFile();
    }    
    // don't have own
    return null;
  }

  @Override
  public IdentifierIterator getIdentifiers() {
    if (ExistingTokenCache != null) {
      return ExistingTokenCache.getIdentifiers();
    }    
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public boolean equals(Object obj) {
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public String toString() {
    return "PTHManagerDriver{" + ExistingTokenCache + '}';
  }

  // JAVA
  @Override
  public MemoryBuffer $markShared(boolean shared) {
    MemoryBuffer buf = null;
    if (ExistingTokenCache != null) {
      buf = ExistingTokenCache.$markShared(shared);
    }    
    MemoryBuffer OwnBuf = super.$markShared(shared);
    // don't have own
    assert OwnBuf == null;
    return buf;
  }

  // JAVA
  @Override
  public MemoryBuffer $getTokenCache() {
    MemoryBuffer buf = null;
    if (ExistingTokenCache != null) {
      buf = ExistingTokenCache.$getTokenCache();
    }      
    MemoryBuffer OwnBuf = super.$getTokenCache();
    assert OwnBuf == null;
    return buf;
  }
  

  @Override
  public void $destroy() {
    if (ExistingTokenCache != null) {
      ExistingTokenCache.$destroy();
    }
    super.$destroy();
  }

  public IdentifierInfo getPPIdentifierInfo(byte[] SpellingBuf, int IdxInBuf, int Len) {
    assert PP.getIdentifierTable() != null;
    assert PP.getIdentifierTable().getExternalIdentifierLookup() == this || ExistingTokenCache == null : "this PTHManager must be passed to PP constructor as external IdentifierInfoLookup";
    // we don't query ExistingTokenCache here, it will be called through Preprocessor
    IdentifierInfo out = PP.getIdentifierInfo(SpellingBuf, IdxInBuf, Len);
    assert out != null : "no II for internal II: " + new StringRef(SpellingBuf, IdxInBuf);
    return out;
  }    
  
  // does nothing, only delegates
  private static final class EmptyStatCache extends FileSystemStatCache {
    @Override
    protected LookupResult getStat(char$ptr Path, int PathLen, FileData Data, boolean isFile, std_ptr.unique_ptr<File> F, FileSystem FS) {
      return super.statChained(Path, PathLen, Data, isFile, F, FS);
    }
  }
  
  
  private static final AtomicLong TotalRequestedLexers = new AtomicLong(0);
  private static final AtomicLong TotalNonBuiltinRequestedLexers = new AtomicLong(0);
  private static final AtomicLong cachedTokensCreatedSize = new AtomicLong(0);
  private static final AtomicLong cachedTokensCreated = new AtomicLong(0);
  private static final AtomicLong cachedTokensMisses = new AtomicLong(0);
  private static final AtomicLong cachedTokensHit = new AtomicLong(0);
  private static final AtomicLong cachedTokensSkipped = new AtomicLong(0);
  private static final AtomicLong cachedExternalTokensMisses = new AtomicLong(0);
  private static final AtomicLong cachedExternalTokensHit = new AtomicLong(0);
  public static final String   PREPARE_ALL_FILES_PTH_PROP = "clank.pth.cache.all";
  public static final boolean  PREPARE_ALL_FILES_PTH = Boolean.valueOf(System.getProperty(PREPARE_ALL_FILES_PTH_PROP, ""+NativeTrace.USE_PTH_DRIVER_IN_TEST));
  public static final String KEEP_PTH_COMMENTS_PROP = "clank.pth.keep.comments";
  public static final boolean  KEEP_PTH_COMMENTS = Boolean.valueOf(System.getProperty(KEEP_PTH_COMMENTS_PROP, ""+!NativeTrace.CLANG_MODE));
  public static final String KEEP_INCOMPLETE_TOKEN_STATE_PROP = "clank.pth.keep.incomplete.token.state";
  public static final boolean  KEEP_INCOMPLETE_TOKEN_STATE = Boolean.valueOf(System.getProperty(KEEP_INCOMPLETE_TOKEN_STATE_PROP, ""+ !NativeTrace.CLANG_MODE));

  public static void clearStatistics() {
    TotalRequestedLexers.set(0);
    TotalNonBuiltinRequestedLexers.set(0);
    cachedTokensCreatedSize.set(0);
    cachedTokensCreated.set(0);
    cachedTokensMisses.set(0);
    cachedTokensHit.set(0);
    cachedTokensSkipped.set(0);
    cachedExternalTokensMisses.set(0);
    cachedExternalTokensHit.set(0);
  }

  
  public static void printStats() {
    llvm.errs().$out("PTHManagerDriver statistics:").
                $out("\n\tTotal Requested Lexers: ").$out(NativeTrace.formatNumber(TotalRequestedLexers.longValue())).
                $out("\n\tTotal Non Builtin Files Requested Lexers: ").$out(NativeTrace.formatNumber(TotalNonBuiltinRequestedLexers.longValue())).
                $out("\n\tCreated Token Caches TotalSize: ").$out(NativeTrace.formatNumber(cachedTokensCreatedSize.longValue())).
                $out("\n\tCreated Token Caches: ").$out(NativeTrace.formatNumber(cachedTokensCreated.longValue())).
                $out("\n\tToken Caches Miss: ").$out(NativeTrace.formatNumber(cachedTokensMisses.longValue())).
                $out("\n\tToken Caches Hit: ").$out(NativeTrace.formatNumber(cachedTokensHit.longValue())).
                $out("\n\tToken Caches Skipped: ").$out(NativeTrace.formatNumber(cachedTokensSkipped.longValue())).
                $out("\n\tExternal Token Caches Miss: ").$out(NativeTrace.formatNumber(cachedExternalTokensMisses.longValue())).
                $out("\n\tExternal Token Caches Hit: ").$out(NativeTrace.formatNumber(cachedExternalTokensHit.longValue())).
                $out($LF).flush();    
  }
  
}
