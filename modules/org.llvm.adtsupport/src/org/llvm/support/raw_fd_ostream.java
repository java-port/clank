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

package org.llvm.support;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.raw_ostreamStatics.getFD;
import org.llvm.support.sys.Process;

//===----------------------------------------------------------------------===//
// File Output Streams
//===----------------------------------------------------------------------===//

/// A raw_ostream that writes to a file descriptor.
///
//<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 344,
 FQN="llvm::raw_fd_ostream", NM="_ZN4llvm14raw_fd_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostreamE")
//</editor-fold>
public class raw_fd_ostream extends /*public*/ raw_pwrite_stream implements Destructors.ClassWithDestructor {
  private int FD;
  private boolean ShouldClose;
  
  /// Error This flag is true if an error of any kind has been detected.
  ///
  private boolean Error;
  
  private long/*uint64_t*/ pos;
  
  private boolean SupportsSeeking;
  
  /// See raw_ostream::write_impl.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::write_impl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extra arg*/,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 567,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 570,
   FQN="llvm::raw_fd_ostream::write_impl", NM="_ZN4llvm14raw_fd_ostream10write_implEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream10write_implEPKcj")
  //</editor-fold>
  @Override protected/*private*/ void write_impl(/*const*/char$ptr/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size)/* override*/ {
    assert (FD >= 0) : "File already closed.";
    pos += $uint2ullong(Size);
    boolean ShouldWriteInChunks = false;
    int Ptr$Index = Ptr.$index() + PtrIdx;
    do {
      /*size_t*/int ChunkSize = Size;
      if ($greater_uint(ChunkSize, 32767) && ShouldWriteInChunks) {
        ChunkSize = 32767;
      }
      
      long ret = /*::*/io.write(FD, Ptr, Ptr$Index, ChunkSize);
      if (ret < 0) {
        // If it's a recoverable error, swallow it and retry the write.
        //
        // Ideally we wouldn't ever see EAGAIN or EWOULDBLOCK here, since
        // raw_ostream isn't designed to do non-blocking I/O. However, some
        // programs, such as old versions of bjam, have mistakenly used
        // O_NONBLOCK. For compatibility, emulate blocking semantics by
        // spinning until the write succeeds. If you don't want spinning,
        // don't use O_NONBLOCK file descriptors with raw_ostream.
        if (errno() == EINTR || errno() == EAGAIN
           || errno() == EWOULDBLOCK) {
          continue;
        }
        
        // Otherwise it's a non-recoverable error. Note it and quit.
        error_detected();
        break;
      }
      
      // The write may have written some or all of the data. Update the
      // size and buffer pointer to reflect the remainder that needs
      // to be written. If there are no bytes left, we're done.
      Ptr$Index += $ulong2uint(ret);
      Size -= ret;
    } while (Size > 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::pwrite_impl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 634,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 636,
   FQN="llvm::raw_fd_ostream::pwrite_impl", NM="_ZN4llvm14raw_fd_ostream11pwrite_implEPKcjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream11pwrite_implEPKcjy")
  //</editor-fold>
  @Override protected/*private*/ void pwrite_impl(/*const*/char$ptr/*char P*/ Ptr, /*size_t*/int Size, 
             long/*uint64_t*/ Offset)/* override*/ {
    long/*uint64_t*/ Pos = tell();
    seek(Offset);
    write(Ptr, Size);
    seek(Pos);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::write_impl">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 567,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 570,
   FQN="llvm::raw_fd_ostream::write_impl", NM="_ZN4llvm14raw_fd_ostream10write_implEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream10write_implEPKcj")
  //</editor-fold>
  @Override protected/*private*/ void write_impl(/*const*/byte[]/*char P*/ Ptr, int PtrIndex, /*size_t*/int Size)/* override*/ {
    assert (FD >= 0) : "File already closed.";
    pos += Size;
    boolean ShouldWriteInChunks = false;

    do {
      /*size_t*/int ChunkSize = Size;
      if ($greater_uint(ChunkSize, 32767) && ShouldWriteInChunks) {
        ChunkSize = 32767;
      }
      
      long ret = /*::*/io.write(FD, Ptr, PtrIndex, ChunkSize);
      if (ret < 0) {
        // If it's a recoverable error, swallow it and retry the write.
        //
        // Ideally we wouldn't ever see EAGAIN or EWOULDBLOCK here, since
        // raw_ostream isn't designed to do non-blocking I/O. However, some
        // programs, such as old versions of bjam, have mistakenly used
        // O_NONBLOCK. For compatibility, emulate blocking semantics by
        // spinning until the write succeeds. If you don't want spinning,
        // don't use O_NONBLOCK file descriptors with raw_ostream.
        if (errno() == EINTR || errno() == EAGAIN
           || errno() == EWOULDBLOCK) {
          continue;
        }
        
        // Otherwise it's a non-recoverable error. Note it and quit.
        error_detected();
        break;
      }
      
      // The write may have written some or all of the data. Update the
      // size and buffer pointer to reflect the remainder that needs
      // to be written. If there are no bytes left, we're done.
      PtrIndex += ret;
      Size -= ret;
    } while (Size > 0);
  }
  
  /// Return the current position within the stream, not counting the bytes
  /// currently in the buffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::current_pos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 363,
   FQN="llvm::raw_fd_ostream::current_pos", NM="_ZNK4llvm14raw_fd_ostream11current_posEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm14raw_fd_ostream11current_posEv")
  //</editor-fold>
  @Override protected/*private*/ long/*uint64_t*/ current_pos() /*const*//* override*/ {
    return pos;
  }

  
  /// Determine an efficient buffer size.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::preferred_buffer_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 642,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 644,
   FQN="llvm::raw_fd_ostream::preferred_buffer_size", NM="_ZNK4llvm14raw_fd_ostream21preferred_buffer_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm14raw_fd_ostream21preferred_buffer_sizeEv")
  //</editor-fold>
  @Override protected/*private*/ /*size_t*/int preferred_buffer_size() /*const*//* override*/ {
    // Windows and Minix have no st_blksize.
    assert (FD >= 0) : "File not yet open!";
     stat statbuf/*J*/= new  stat();
    if (fstat(FD, $AddrOf(statbuf)) != 0) {
      return 0;
    }
    
    // If this is a terminal, don't use buffering. Line buffering
    // would be a more traditional thing to do, but it's not worth
    // the complexity.
    if (S_ISCHR(statbuf.st_mode) && (isatty(FD) != 0)) {
      return 0;
    }
    // Return the preferred block size.
    return statbuf.st_blksize;
  }

  
  /// Set the flag indicating that an output error has been encountered.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::error_detected">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 369,
   FQN="llvm::raw_fd_ostream::error_detected", NM="_ZN4llvm14raw_fd_ostream14error_detectedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream14error_detectedEv")
  //</editor-fold>
  private void error_detected() {
    Error = true;
  }

/*public:*/
  /// Open the specified file for writing. If an error occurs, information
  /// about the error is put into EC, and the stream should be immediately
  /// destroyed;
  /// \p Flags allows optional flags to control how the file will be opened.
  ///
  /// As a special case, if Filename is "-", then the stream will use
  /// STDOUT_FILENO instead of opening a file. Note that it will still consider
  /// itself to own the file descriptor. In particular, it will close the
  /// file descriptor when it is done (this is necessary to detect
  /// output errors).
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::raw_fd_ostream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 513,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 516,
   FQN="llvm::raw_fd_ostream::raw_fd_ostream", NM="_ZN4llvm14raw_fd_ostreamC1ENS_9StringRefERSt10error_codeNS_3sys2fs9OpenFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostreamC1ENS_9StringRefERSt10error_codeNS_3sys2fs9OpenFlagsE")
  //</editor-fold>
  public raw_fd_ostream(std.string Filename, std.error_code /*&*/ EC, /*fs.OpenFlags*/int Flags) {
    this(new StringRef(Filename), EC, Flags);
  }  
  public raw_fd_ostream(char$ptr Filename, std.error_code /*&*/ EC, /*fs.OpenFlags*/int Flags) {
    this(new StringRef(Filename), EC, Flags);
  }  
  public raw_fd_ostream(StringRef Filename, std.error_code /*&*/ EC, 
      /*fs.OpenFlags*/int Flags) {
    // : raw_fd_ostream(getFD(Filename, EC, Flags), true) 
    //START JInit
    this(getFD(Filename, EC, Flags), true);
    //END JInit
  }

  
  /// FD is the file descriptor that this writes to.  If ShouldClose is true,
  /// this closes the file when the stream is destroyed.
  
  /// FD is the file descriptor that this writes to.  If ShouldClose is true, this
  /// closes the file when the stream is destroyed.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::raw_fd_ostream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 519,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 522,
   FQN="llvm::raw_fd_ostream::raw_fd_ostream", NM="_ZN4llvm14raw_fd_ostreamC1Eibb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostreamC1Eibb")
  //</editor-fold>
  public raw_fd_ostream(int$ref fd, boolean shouldClose) {
    this(fd.$deref(), shouldClose);
  }
  public raw_fd_ostream(int fd, boolean shouldClose) {
    this(fd, shouldClose, false);
  }
  public raw_fd_ostream(int$ref fd, boolean shouldClose, boolean unbuffered/*= false*/) {
    this(fd.$deref(), shouldClose, unbuffered);
  }
  public raw_fd_ostream(int fd, boolean shouldClose, boolean unbuffered/*= false*/) {
    // : raw_pwrite_stream(unbuffered), FD(fd), ShouldClose(shouldClose), Error(false) 
    //START JInit
    super(unbuffered);
    this.FD = fd;
    this.ShouldClose = shouldClose;
    this.Error = false;
    //END JInit
    if (FD < 0) {
      ShouldClose = false;
      return;
    }
    
    // Get the starting position.
    long/*off_t*/ loc = /*::*/lseek(FD, 0, SEEK_CUR);
    SupportsSeeking = loc != (long/*off_t*/)-1;
    if (!SupportsSeeking) {
      pos = 0;
    } else {
      pos = ((/*static_cast*/long/*uint64_t*/)($long2ulong(loc)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::~raw_fd_ostream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 543,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 546,
   FQN="llvm::raw_fd_ostream::~raw_fd_ostream", NM="_ZN4llvm14raw_fd_ostreamD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostreamD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if (FD >= 0) {
      flush();
      if (ShouldClose && Process.SafelyCloseFileDescriptor(FD).$bool()) {
        error_detected();
      }
    }
    
    // If there are any pending errors, report them now. Clients wishing
    // to avoid report_fatal_error calls should check for errors with
    // has_error() and clear the error flag with clear_error() before
    // destructing raw_ostream objects which may have errors.
    if (has_error()) {
      report_fatal_error($("IO failure on output stream."), /*GenCrashDiag=*/ false);
    }
    super.$destroy();
  }

  
  /// Manually flush the stream and close the file. Note that this does not call
  /// fsync.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::close">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 616,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 619,
   FQN="llvm::raw_fd_ostream::close", NM="_ZN4llvm14raw_fd_ostream5closeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream5closeEv")
  //</editor-fold>
  public void close() {
    assert (ShouldClose);
    ShouldClose = false;
    flush();
    if (Process.SafelyCloseFileDescriptor(FD).$bool()) {
      error_detected();
    }
    FD = -1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::supportsSeeking">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 395,
   FQN="llvm::raw_fd_ostream::supportsSeeking", NM="_ZN4llvm14raw_fd_ostream15supportsSeekingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream15supportsSeekingEv")
  //</editor-fold>
  public boolean supportsSeeking() {
    return SupportsSeeking;
  }

  
  /// Flushes the stream and repositions the underlying file descriptor position
  /// to the offset specified from the beginning of the file.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::seek">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 625,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 628,
   FQN="llvm::raw_fd_ostream::seek", NM="_ZN4llvm14raw_fd_ostream4seekEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream4seekEy")
  //</editor-fold>
  public long/*uint64_t*/ seek(long/*uint64_t*/ off) {
    assert (SupportsSeeking) : "Stream does not support seeking!";
    flush();
    pos = $long2ulong(/*::*/lseek(FD, $ulong2long(off), SEEK_SET));
    if (pos == (long/*uint64_t*/)$int2ulong(-1)) {
      error_detected();
    }
    return pos;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::changeColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 662,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 664,
   FQN="llvm::raw_fd_ostream::changeColor", NM="_ZN4llvm14raw_fd_ostream11changeColorENS_11raw_ostream6ColorsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream11changeColorENS_11raw_ostream6ColorsEbb")
  //</editor-fold>
  @Override public raw_ostream /*&*/ changeColor( Colors colors)/* override*/ {
    return changeColor(colors, false, 
             false);
  }
  @Override public raw_ostream /*&*/ changeColor( Colors colors, boolean bold/*= false*/)/* override*/ {
    return changeColor(colors, bold, 
             false);
  }
  @Override public raw_ostream /*&*/ changeColor( Colors colors, boolean bold/*= false*/, 
             boolean bg/*= false*/)/* override*/ {
    if (Process.ColorNeedsFlush()) {
      flush();
    }
    /*const*/char$ptr/*char P*/ colorcode = (colors == Colors.SAVEDCOLOR) ? Process.OutputBold(bg) : Process.OutputColor(colors.getValue(), bold, bg);
    if ((colorcode != null)) {
      /*size_t*/int len = strlen(colorcode);
      write(colorcode, 0, len);
      // don't account colors towards output characters
      pos -= $uint2ullong(len);
    }
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::resetColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 678,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 680,
   FQN="llvm::raw_fd_ostream::resetColor", NM="_ZN4llvm14raw_fd_ostream10resetColorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream10resetColorEv")
  //</editor-fold>
  @Override public raw_ostream /*&*/ resetColor()/* override*/ {
    if (Process.ColorNeedsFlush()) {
      flush();
    }
    /*const*/char$ptr/*char P*/ colorcode = Process.ResetColor();
    if ((colorcode != null)) {
      /*size_t*/int len = strlen(colorcode);
      write(colorcode, 0, len);
      // don't account colors towards output characters
      pos -= $uint2ullong(len);
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::reverseColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 691,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 693,
   FQN="llvm::raw_fd_ostream::reverseColor", NM="_ZN4llvm14raw_fd_ostream12reverseColorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream12reverseColorEv")
  //</editor-fold>
  @Override public raw_ostream /*&*/ reverseColor()/* override*/ {
    if (Process.ColorNeedsFlush()) {
      flush();
    }
    /*const*/char$ptr/*char P*/ colorcode = Process.OutputReverse();
    if ((colorcode != null)) {
      /*size_t*/int len = strlen(colorcode);
      write(colorcode, 0, len);
      // don't account colors towards output characters
      pos -= $uint2ullong(len);
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::is_displayed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 704,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 706,
   FQN="llvm::raw_fd_ostream::is_displayed", NM="_ZNK4llvm14raw_fd_ostream12is_displayedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm14raw_fd_ostream12is_displayedEv")
  //</editor-fold>
  @Override public boolean is_displayed() /*const*//* override*/ {
    return Process.FileDescriptorIsDisplayed(FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::has_colors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 708,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 710,
   FQN="llvm::raw_fd_ostream::has_colors", NM="_ZNK4llvm14raw_fd_ostream10has_colorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm14raw_fd_ostream10has_colorsEv")
  //</editor-fold>
  @Override public boolean has_colors() /*const*//* override*/ {
    return Process.FileDescriptorHasColors(FD);
  }

  
  /// Return the value of the flag in this raw_fd_ostream indicating whether an
  /// output error has been encountered.
  /// This doesn't implicitly flush any pending output.  Also, it doesn't
  /// guarantee to detect all errors unless the stream has been closed.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::has_error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 415,
   FQN="llvm::raw_fd_ostream::has_error", NM="_ZNK4llvm14raw_fd_ostream9has_errorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm14raw_fd_ostream9has_errorEv")
  //</editor-fold>
  public boolean has_error() /*const*/ {
    return Error;
  }

  
  /// Set the flag read by has_error() to false. If the error flag is set at the
  /// time when this raw_ostream's destructor is called, report_fatal_error is
  /// called to report the error. Use clear_error() after handling the error to
  /// avoid this behavior.
  ///
  ///   "Errors should never pass silently.
  ///    Unless explicitly silenced."
  ///      - from The Zen of Python, by Tim Peters
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_fd_ostream::clear_error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 428,
   FQN="llvm::raw_fd_ostream::clear_error", NM="_ZN4llvm14raw_fd_ostream11clear_errorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm14raw_fd_ostream11clear_errorEv")
  //</editor-fold>
  public void clear_error() {
    Error = false;
  }

  
  @Override public String toString() {
    return "" + "FD=" + FD // NOI18N
              + ", ShouldClose=" + ShouldClose // NOI18N
              + ", Error=" + Error // NOI18N
              + ", pos=" + pos // NOI18N
              + ", SupportsSeeking=" + SupportsSeeking // NOI18N
              + super.toString(); // NOI18N
  }
}
