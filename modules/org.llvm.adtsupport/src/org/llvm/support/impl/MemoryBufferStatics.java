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

package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type MemoryBufferStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -file-filter=${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp#60;${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp#72;${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp#100;${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp#226;${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp#253;${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp#273; -static-type=MemoryBufferStatics")
//</editor-fold>
public final class MemoryBufferStatics {


/// CopyStringRef - Copies contents of a StringRef into a block of memory and
/// null-terminates it.
//<editor-fold defaultstate="collapsed" desc="CopyStringRef">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 59,
 old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 60,
 FQN = "CopyStringRef", NM = "_ZL13CopyStringRefPcN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZL13CopyStringRefPcN4llvm9StringRefE")
//</editor-fold>
public static void CopyStringRef(char$ptr/*char P*/ Memory, StringRef Data) {
  memcpy(Memory, Data.data(), Data.size());
  Memory.$set(Data.size(), (byte) 0); // Null terminate string.
  assert std.strlen(Memory) == Data.size() : Memory + " vs. " + Data;
}

//<editor-fold defaultstate="collapsed" desc="operator new">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 72,
 FQN = "operator new", NM = "_ZnwjRKN12_GLOBAL__N_116NamedBufferAllocE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZnwjRKN12_GLOBAL__N_116NamedBufferAllocE")
//</editor-fold>
public static char$ptr/*void P*/ $new_uint_NamedBufferAlloc(/*size_t*/int N, /*const*/ NamedBufferAlloc /*&*/ Alloc) {
  SmallString/*256*/ NameBuf = null;
  try {
    NameBuf/*J*/= new SmallString/*256*/(256);
    StringRef NameRef = Alloc.Name.toStringRef(NameBuf);
    
    char$ptr/*char P*/ Mem = $tryClone(((/*static_cast*/char$ptr/*char P*/ )($new_uint(N + NameRef.size() + 1))));
    CopyStringRef(Mem.$add(N), new StringRef(NameRef));
    return Mem;
  } finally {
    if (NameBuf != null) { NameBuf.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getFileAux">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 259,
 old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 258,
 FQN = "getFileAux", NM = "_ZL10getFileAuxRKN4llvm5TwineExyybb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZL10getFileAuxRKN4llvm5TwineExyybb")
//</editor-fold>
public static ErrorOr<std.unique_ptr<MemoryBuffer> > getFileAux(/*const*/ Twine /*&*/ Filename, long/*int64_t*/ FileSize, long/*uint64_t*/ MapSize, 
          long/*uint64_t*/ Offset, boolean RequiresNullTerminator, boolean IsVolatileSize) {
  int$ref FD = create_int$ref();
  std.error_code EC = fs.openFileForRead(Filename, FD);
  if (EC.$bool()) {
    return new ErrorOr<std.unique_ptr<MemoryBuffer> >(new std.error_code(EC));
  }
  
  ErrorOr<std.unique_ptr<MemoryBuffer> > Ret = getOpenFileImpl(FD.$deref(), Filename, FileSize, MapSize, Offset, 
      RequiresNullTerminator, IsVolatileSize);
  close(FD.$deref());
  return Ret;
}

//<editor-fold defaultstate="collapsed" desc="getMemoryBufferForStream">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 227,
 old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 226,
 FQN = "getMemoryBufferForStream", NM = "_ZL24getMemoryBufferForStreamiRKN4llvm5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZL24getMemoryBufferForStreamiRKN4llvm5TwineE")
//</editor-fold>
public static ErrorOr<std.unique_ptr<MemoryBuffer> > getMemoryBufferForStream(int FD, /*const*/ Twine /*&*/ BufferName) {
  SmallString/*<ChunkSize>*/ Buffer = null;
  try {
    /*const*//*size_t*/int ChunkSize = 4096 * 4;
    Buffer/*J*/= new SmallString/*<ChunkSize>*/(ChunkSize);
    long ReadBytes;
    // Read into Buffer until we hit EOF.
    do {
      Buffer.reserve(Buffer.size() + ChunkSize);
      ReadBytes = read(FD, Buffer.end(), ChunkSize);
      if (ReadBytes == -1) {
        if (errno() == EINTR) {
          continue;
        }
        return new ErrorOr<std.unique_ptr<MemoryBuffer> >(new std.error_code(errno(), std.generic_category()));
      }
      Buffer.set_size($long2uint(Buffer.size() + ReadBytes));
    } while (ReadBytes != 0);
    
    return new ErrorOr<std.unique_ptr<MemoryBuffer> >(MemoryBuffer.getMemBufferCopy(Buffer.$StringRef(), BufferName));
  } finally {
    if (Buffer != null) { Buffer.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getOpenFileImpl">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 330,
 old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 329,
 FQN = "getOpenFileImpl", NM = "_ZL15getOpenFileImpliRKN4llvm5TwineEyyxbb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZL15getOpenFileImpliRKN4llvm5TwineEyyxbb")
//</editor-fold>
public static ErrorOr<std.unique_ptr<MemoryBuffer> > getOpenFileImpl(int FD, /*const*/ Twine /*&*/ Filename, long/*uint64_t*/ FileSize, 
               long/*uint64_t*/ MapSize, long/*int64_t*/ Offset, boolean RequiresNullTerminator, 
               boolean IsVolatileSize) {
  final/*static*/ int PageSize = (int) org.llvm.support.sys.Process.getPageSize();
  
  // Default is to map the full file.
  if (MapSize == ((long/*uint64_t*/)(-1))) {
    // If we don't know the file size, use fstat to find out.  fstat on an open
    // file descriptor is cheaper than stat on a random path.
    if (FileSize == ((long/*uint64_t*/)(-1))) {
      fs.file_status Status/*J*/= new fs.file_status();
      std.error_code EC = fs.status(FD, Status);
      if (EC.$bool()) {
        return new ErrorOr<std.unique_ptr<MemoryBuffer> >(new std.error_code(EC));
      }
      
      // If this not a file or a block device (e.g. it's a named pipe
      // or character device), we can't trust the size. Create the memory
      // buffer by copying off the stream.
      fs.file_type Type = Status.type();
      if (Type != fs.file_type.regular_file
         && Type != fs.file_type.block_file) {
        return getMemoryBufferForStream(FD, Filename);
      }
      
      FileSize = Status.getSize();
    }
    MapSize = FileSize;
  }
  if (shouldUseMmap(FD, $long2uint(FileSize), $long2uint(MapSize), Offset, RequiresNullTerminator, 
      PageSize, IsVolatileSize)) {
    std.unique_ptr<MemoryBuffer> Result = null;
    try {
      std.error_code EC/*J*/= new std.error_code();
      char$ptr FilenameCopy = $new_uint_NamedBufferAlloc(0, new NamedBufferAlloc(Filename));
      Result/*J*/= new std.unique_ptr<MemoryBuffer>(/*FIXME:*//*new (NamedBufferAlloc(Filename))*/ new MemoryBufferMMapFile(FilenameCopy, RequiresNullTerminator, FD, MapSize, Offset, EC));
      if (!EC.$bool()) {
        return new ErrorOr<std.unique_ptr<MemoryBuffer> >(new unique_ptr<MemoryBuffer>(std.move(Result)));
      }
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }
  
  std.unique_ptr<MemoryBuffer> Buf = MemoryBuffer.getNewUninitMemBuffer($long2uint(MapSize), Filename);
  if (!Buf.$bool()) {
    // Failed to create a buffer. The only way it can fail is if
    // new(std::nothrow) returns 0.
    return new ErrorOr<std.unique_ptr<MemoryBuffer> >(make_error_code(errc.not_enough_memory));
  }
  
  char$ptr/*char P*/ BufPtr = $tryClone(((/*const_cast*/char$ptr/*char P*/ )(Buf.$arrow().getBufferStart())));
  
  /*size_t*/int BytesLeft = $long2uint(MapSize);
  while ((BytesLeft != 0)) {
    long NumRead = /*::*/pread(FD, BufPtr, BytesLeft, MapSize - BytesLeft + Offset);
    if (NumRead == -1) {
      if (errno() == EINTR) {
        continue;
      }
      // Error while reading.
      return new ErrorOr<std.unique_ptr<MemoryBuffer> >(new std.error_code(errno(), std.generic_category()));
    }
    if (NumRead == 0) {
      memset(BufPtr, $$TERM, BytesLeft); // zero-initialize rest of the buffer.
      break;
    }
    BytesLeft -= $long2uint(NumRead);
    BufPtr.$inc($long2uint(NumRead));
  }
  
  return new ErrorOr<std.unique_ptr<MemoryBuffer> >(new unique_ptr<MemoryBuffer>(std.move(Buf)));
}

//<editor-fold defaultstate="collapsed" desc="shouldUseMmap">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 274,
 old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 273,
 FQN = "shouldUseMmap", NM = "_ZL13shouldUseMmapijjlbib",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZL13shouldUseMmapijjlbib")
//</editor-fold>
public static boolean shouldUseMmap(int FD, 
             /*size_t*/int FileSize, 
             /*size_t*/int MapSize, 
             long/*off_t*/ Offset, 
             boolean RequiresNullTerminator, 
             int PageSize, 
             boolean IsVolatileSize) {
  // mmap may leave the buffer without null terminator if the file size changed
  // by the time the last page is mapped in, so avoid it if the file size is
  // likely to change.
  if (IsVolatileSize) {
    return false;
  }
  
  // We don't use mmap for small files because this can severely fragment our
  // address space.
  if (MapSize < 4 * 4096 || MapSize < (/*uint*/int)PageSize) {
    return false;
  }
  if (!RequiresNullTerminator) {
    return true;
  }
  
  // If we don't know the file size, use fstat to find out.  fstat on an open
  // file descriptor is cheaper than stat on a random path.
  // FIXME: this chunk of code is duplicated, but it avoids a fstat when
  // RequiresNullTerminator = false and MapSize != -1.
  if (FileSize == ((/*size_t*/int)(-1))) {
    fs.file_status Status/*J*/= new fs.file_status();
    if (fs.status(FD, Status).$bool()) {
      return false;
    }
    FileSize = $long2uint(Status.getSize());
  }
  
  // If we need a null terminator and the end of the map is inside the file,
  // we cannot use mmap.
  /*size_t*/int End = $long2uint(Offset + MapSize);
  assert (End <= FileSize);
  if (End != FileSize) {
    return false;
  }
  
  // Don't try to map files that are exactly a multiple of the system page size
  // if we need a null terminator.
  if ((FileSize & (PageSize - 1)) == 0) {
    return false;
  }
  
  return true;
}

} // END OF class MemoryBufferStatics
