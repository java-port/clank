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

import java.util.concurrent.atomic.AtomicLong;
import org.clang.basic.vfs.File;
import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.Status;
import org.clang.basic.vfs.directory_iterator;
import org.clank.java.std;
import org.clank.java.std_errors;
import org.clank.java.std_ptr;
import org.clank.support.Native;
import static org.clank.support.NativePointer.$;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.Twine;
import org.llvm.support.ErrorOr;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.llvm;

/**
 *
 * @author vkvashin
 */
public class DelegatingFileSystem extends FileSystem {

    public static IntrusiveRefCntPtr<FileSystem> create(SharedMemoryBufferCache sharedMemoryBufferCache, IntrusiveRefCntPtr<FileSystem> toDelegate) {
        return new IntrusiveRefCntPtr<FileSystem>(new DelegatingFileSystem(sharedMemoryBufferCache, toDelegate));
    }
    
    private static final boolean TRACE_TIME = Boolean.getBoolean("clank.fs.trace.time"); //NOI18N
    private static final AtomicLong totalReadTime  = TRACE_TIME ? new AtomicLong() : null;
    private static final AtomicLong totalReadCount = TRACE_TIME ? new AtomicLong() : null;
    private static final AtomicLong totalStatTime  = TRACE_TIME ? new AtomicLong() : null;
    private static final AtomicLong totalStatCount = TRACE_TIME ? new AtomicLong() : null;

    private final FileSystem delegateFS;
    private final IntrusiveRefCntPtr<FileSystem> delegatePtr;
    private final SharedMemoryBufferCache sharedMemoryBufferCache;
    private DelegatingFileSystem(SharedMemoryBufferCache sharedMemoryBufferCache, IntrusiveRefCntPtr<FileSystem> toDelegate) {
        assert toDelegate != null;
        this.sharedMemoryBufferCache = sharedMemoryBufferCache;
        this.delegatePtr = toDelegate;
        this.delegateFS = toDelegate.get();
    }

    private static void printStatistics(std.string Name, long readTime) {
        assert TRACE_TIME;
        StringBuilder sb = new StringBuilder();
        sb.append("Reading ").append(Name).append(" took ").append(readTime).append(" ms") //NOI18N
                .append("\nTotal reads: count=").append(totalReadCount.get()).append(" time=").append(totalReadTime.get()).append(" ms") //NOI18N
                .append("\nTotal stats: count=").append(totalStatCount.get()).append(" time=").append(totalStatTime.get()).append(" ms") //NOI18N
                .append("\n"); //NOI18N
        llvm.errs().$out(sb.toString());
    }

    @Override
    public void $destroy() {
        super.$destroy();
        delegatePtr.$destroy();
    }

    @Override
    public ErrorOr<Status> status(Twine Path) {
        long time = TRACE_TIME ? System.currentTimeMillis() : 0;
        ErrorOr<Status> stat = delegateFS.status(Path);
        if (TRACE_TIME) {
            totalStatTime.addAndGet(System.currentTimeMillis() - time);
            totalStatCount.incrementAndGet();
        }
        return stat;
    }

    @Override
    public ErrorOr<std_ptr.unique_ptr<MemoryBuffer>> getBufferForFile(Twine Name, long FileSize, boolean RequiresNullTerminator, boolean IsVolatile) {
      ErrorOr<std_ptr.unique_ptr<MemoryBuffer>> out = sharedMemoryBufferCache.get(Name);
      if (out == null) {
        out = super.getBufferForFile(Name, FileSize, RequiresNullTerminator, IsVolatile);
        sharedMemoryBufferCache.put(Name, out);
      }
      return out;
    }

    @Override
    public ErrorOr<std_ptr.unique_ptr<File>> openFileForRead(Twine Path) {
        long time = TRACE_TIME ? System.currentTimeMillis() : 0;
        ErrorOr<std_ptr.unique_ptr<File>> result = delegateFS.openFileForRead(Path);
        if (result.$bool()) {
            DelegatingFile delegatingWrapper = new DelegatingFile(result.get().get());
            std_ptr.unique_ptr<File> upf = llvm.<File>make_unique(delegatingWrapper);
            result = new ErrorOr<>(upf);
        }
        if (TRACE_TIME) {
            totalReadTime.addAndGet(System.currentTimeMillis() - time);
            totalReadCount.incrementAndGet();
        }
        return result;
    }

    @Override
    public directory_iterator dir_begin(Twine Dir, std_errors.error_code EC) {
        return delegateFS.dir_begin(Dir, EC);
    }

    @Override
    public std_errors.error_code setCurrentWorkingDirectory(Twine Path) {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErrorOr<std.string> getCurrentWorkingDirectory() {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    private class DelegatingFile extends File {

        private final File delegate;

        public DelegatingFile(File delegate) {
            this.delegate = delegate;
        }

        @Override
        public void $destroy() {
            super.$destroy();
            delegate.$destroy();
        }

        @Override
        public ErrorOr<Status> status() {
            long time = TRACE_TIME ? System.currentTimeMillis() : 0;
            ErrorOr<Status> stat = delegate.status();
            if (TRACE_TIME) {
                time = System.currentTimeMillis() - time;
                totalStatCount.incrementAndGet();
                totalStatTime.addAndGet(time);
            }
            return stat;
        }

        @Override
        public ErrorOr<std_ptr.unique_ptr<MemoryBuffer>> getBuffer(Twine Name, long FileSize, boolean RequiresNullTerminator, boolean IsVolatile) {
            ErrorOr<std_ptr.unique_ptr<MemoryBuffer>> buf = sharedMemoryBufferCache.get(Name);
            if (buf == null) {
              long time = TRACE_TIME ? System.currentTimeMillis() : 0;
              buf = delegate.getBuffer(Name, FileSize, RequiresNullTerminator, IsVolatile);
              if (TRACE_TIME) {
                  time = System.currentTimeMillis() - time;
                  totalReadCount.incrementAndGet();
                  totalReadTime.addAndGet(time);
                  printStatistics(Name.str(), time);
              }
              // process non-ascii and CR-LF ("\r\n") pairs
              if (buf.$bool()) {
                  MemoryBuffer mb = buf.$arrow().$arrow();
                  convertMemoryBufferForJava(mb);
              }
              sharedMemoryBufferCache.put(Name, buf);
            }          
            return buf;
        }

        @Override
        public std_errors.error_code close() {
            return delegate.close();
        }

        @Override
        public String toString() {
          return "{delegate="+delegate+"}"; //NOI18N
        }
    }
    
    private static void convertMemoryBufferForJava(MemoryBuffer mb) {
        char$ptr bufferStart = mb.getBufferStart();
        // fast check
        if (Native.$is_array_based(bufferStart)) {
          char$ptr bufferEnd = mb.getBufferEnd();
          byte[] array = bufferStart.$array();
          assert array == bufferEnd.$array();
          int bufferStart$Index = bufferStart.$index();
          int bufferEnd$Index = bufferEnd.$index();
          // fast path
          // nothing to do for ascii and non \r symbols
          byte CR = $('\r');
          while (bufferStart$Index < bufferEnd$Index) {
            byte cur = array[bufferStart$Index++];
            // the below cur < 0 || cur > 127  is funny, cur < 0 is quite enough;
            // leaving it just as a reminder in case type will be changed
            if (cur < 0 || cur > 127 || cur == CR) {
              // slow case
              convertMemoryBufferForJavaSlow(mb);
              break;
            }
          }
        } else {
          convertMemoryBufferForJavaSlow(mb);
        }      
    }
    
    private static void convertMemoryBufferForJavaSlow(MemoryBuffer mb) {
      char$ptr bufferStart = mb.getBufferStart();
      char$ptr bufferEnd = mb.getBufferEnd();
      char$ptr from = bufferStart.clone();
      char$ptr to = from.clone();
      boolean prevWasCR = false;
      boolean changed = false;
      while (from.$noteq(bufferEnd)) {
        byte c = from.$star();
        if (c == (byte) '\r') {
          to.$set((byte) '\n');
          to.$preInc();
          prevWasCR = true;
          changed = true;
        } else {
          if (c == (byte) '\n' && prevWasCR) {
            // ignore
            changed = true;
          } else {
            if (!changed) {
              changed = (c & 0x80) != 0;
            }
            if (changed) {
                      // UTF8
              // TODO: use correct encoding!
              if ((c & 0x80) == 0) {
                to.$set(c);
                to.$preInc();
              } else if ((c & 0xC0) != 0x80) {
                // first byte of multybyte symbol: replace with ' '
                to.$set((byte) ' ');
                to.$preInc();
              } // else non-first byte of multybyte symbol: skip
            } else {
              to.$preInc();
            }
          }
          prevWasCR = false;
        }
        from.$preInc();
      }
      while (to.$noteq(bufferEnd)) {
        to.$set((byte) ' '); // to.$set((byte) 0);
        to.$preInc();
      } 
    }
}
