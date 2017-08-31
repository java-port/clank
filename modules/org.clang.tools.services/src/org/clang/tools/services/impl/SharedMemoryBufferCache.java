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

import java.util.concurrent.atomic.AtomicInteger;
import org.clank.java.std_errors;
import org.clank.java.std_ptr;
import org.clank.support.NativeTrace;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.SmallString;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.adt.aliases.StringMap;
import org.llvm.adt.aliases.StringMapEntry;
import org.llvm.support.ErrorOr;
import org.llvm.support.MemoryBuffer;

/**
 *
 * @author Vladimir Voskresensky
 */
final class SharedMemoryBufferCache {
  
  private final StringMap<MemoryBuffer/*, BumpPtrAllocator*/> MemoryBuffers;
  private final AtomicInteger cacheHits;
  private final AtomicInteger mainFileHits;
  private final AtomicInteger cacheMisses;
  private final SmallString buffer = new SmallString(1024);
  private static final MemoryBuffer DUMMY = MemoryBuffer.getNewUninitMemBuffer(0, Twine.T$EMPTY).release();
  private static final ErrorOr<std_ptr.unique_ptr<MemoryBuffer>> NO_MEMORY_BUFFER = new ErrorOr<>(std_errors.errc.no_such_file_or_directory.make_error_code());
  SharedMemoryBufferCache(StringMap<MemoryBuffer/*, BumpPtrAllocator*/> MemoryBuffers,
          AtomicInteger cacheHits, AtomicInteger mainFileHits, AtomicInteger cacheMisses) {
    this.MemoryBuffers = MemoryBuffers;
    this.cacheHits = cacheHits;
    this.mainFileHits = mainFileHits;
    this.cacheMisses = cacheMisses;
  }
  
  private StringRef skipMainFile = StringRef.R$EMPTY;
  void skipMainFile(StringRef mainFile) {
    this.skipMainFile = mainFile;
  }
  
  ErrorOr<std_ptr.unique_ptr<MemoryBuffer>> get(Twine Name) {
    if (PreprocessorSupport.REUSE_MEMORY_BUFFERS) {
      StringRef Key = Name.toStringRef(buffer);
      if (Key.$noteq(skipMainFile)) {
        MemoryBuffer value;
        char$ptr KeyData = Key.data();
        int KeySize = Key.size();
        synchronized (MemoryBuffers) {
          StringMapEntry<MemoryBuffer> Entry = MemoryBuffers.GetOrCreateValue(KeyData, KeySize);
          value = Entry.getValue();
        }
        if (value != null) {
          if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
            this.cacheHits.incrementAndGet();
          }
          // found in cache
          if (value == DUMMY) {
            return NO_MEMORY_BUFFER;
          } else {
            return new ErrorOr<>(new std_ptr.unique_ptr<MemoryBuffer>(new MemoryBufferWrapper(value)));
          }
        }
      }
    }
    return null;
  }

  void put(Twine Name, ErrorOr<std_ptr.unique_ptr<MemoryBuffer>> out) {
    if (PreprocessorSupport.REUSE_MEMORY_BUFFERS) {
      StringRef Key = Name.toStringRef(buffer);
      if (Key.$noteq(skipMainFile)) {
        char$ptr KeyData = Key.data();
        int KeySize = Key.size();        
        MemoryBuffer value;
        if (out.$bool()) {
          value = out.get().get();
        } else {
          value = DUMMY;
        }
        synchronized (MemoryBuffers) {
          StringMapEntry<MemoryBuffer> Entry = MemoryBuffers.GetOrCreateValue(KeyData, KeySize);
          if (Entry.getValue() == null) {
            if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
              this.cacheMisses.incrementAndGet();
            }
            Entry.setValue(value);
          }
        }
      } else {
        if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
          mainFileHits.incrementAndGet();
        }
      }
    }
  }

  private static final class MemoryBufferWrapper extends MemoryBuffer {
    private final MemoryBuffer delegate;

    @Override
    public boolean isInvalid() {
      return delegate.isInvalid();
    }

    @Override
    public void setInvalid() {
      delegate.setInvalid();
    }

    @Override
    public char$ptr getBufferStart() {
      return delegate.getBufferStart();
    }

    @Override
    public char$ptr getBufferEnd() {
      return delegate.getBufferEnd();
    }

    @Override
    public /*size_t*/int getBufferSize() {
      return delegate.getBufferSize();
    }

    @Override
    public StringRef getBuffer() {
      return delegate.getBuffer();
    }

    @Override
    public char$ptr getBufferIdentifier() {
      return delegate.getBufferIdentifier();
    }

    public MemoryBufferWrapper(MemoryBuffer delegate) {
      this.delegate = delegate;
    }

    @Override
    public BufferKind getBufferKind() {
      return delegate.getBufferKind();
    }

    @Override
    public void setSourceLineCache(int[] SourceLineCache, int NumLines) {
      delegate.setSourceLineCache(SourceLineCache, NumLines);
    }

    @Override
    public int[] getSourceLineCache() {
      return delegate.getSourceLineCache();
    }

    @Override
    public MemoryBuffer setTokenCacheBuffer(MemoryBuffer tokenFileBuffer) {
      return delegate.setTokenCacheBuffer(tokenFileBuffer);
    }

    @Override
    public MemoryBuffer getTokenCacheBuffer() {
      return delegate.getTokenCacheBuffer();
    }
    
    @Override
    public String toString() {
      return "MemoryBufferWrapper{" + "delegate=" + delegate + '}';
    }

    @Override
    public void $destroy() {
      // when wrapper is asked to be deleted we do not delete 
      if (false) super.$destroy();
    }
  }

  @Override
  public String toString() {
    return "SharedMemoryBufferCache{" + "MemoryBuffers=" + MemoryBuffers + 
            ", cacheHits=" + cacheHits + 
            ", mainFileHits=" + mainFileHits + 
            ", cacheMisses=" + cacheMisses + 
            ", skipMainFile=" + skipMainFile + '}';
  }
}
