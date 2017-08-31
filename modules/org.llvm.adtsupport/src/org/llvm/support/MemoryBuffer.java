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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.NativeMemory.Allocator;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.impl.MemoryBufferStatics.*;
import org.llvm.support.*;
import org.llvm.support.impl.*;
import org.llvm.adt.*;
import org.llvm.support.sys.*;


/// This interface provides simple read-only access to a block of memory, and
/// provides simple methods for reading files and standard input into a memory
/// buffer.  In addition to basic access to the characters in the file, this
/// interface guarantees you can read one character past the end of the file,
/// and that this character will read as '\0'.
///
/// The '\0' guarantee is needed to support an optimization -- it's intended to
/// be more efficient for clients which are reading all the data to stop
/// reading when they encounter a '\0' than to continually check the file
/// position to see if it has reached the end of the file.
//<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 36,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 39,
 FQN = "llvm::MemoryBuffer", NM = "_ZN4llvm12MemoryBufferE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBufferE")
//</editor-fold>
public abstract class MemoryBuffer implements Destructors.ClassWithDestructor {
  private /*const*/StringRef/*char P*/ $StringRef; // PERF: StringRef of the buffer.
  private /*const*/char$ptr/*char P*/ BufferStart; // Start of the buffer.
  private /*const*/char$ptr/*char P*/ BufferEnd; // End of the buffer.
  private boolean InvalidBufferFlag = false; // TODO: get rid of InvalidBufferFlag
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::MemoryBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 40,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 43,
   FQN = "llvm::MemoryBuffer::MemoryBuffer", NM = "_ZN4llvm12MemoryBufferC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBufferC1ERKS0_")
  //</editor-fold>
  private MemoryBuffer(/*const*/ MemoryBuffer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 44,
   FQN = "llvm::MemoryBuffer::operator=", NM = "_ZN4llvm12MemoryBufferaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBufferaSERKS0_")
  //</editor-fold>
  private MemoryBuffer /*&*/ $assign(/*const*/ MemoryBuffer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::MemoryBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 46,
   FQN = "llvm::MemoryBuffer::MemoryBuffer", NM = "_ZN4llvm12MemoryBufferC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBufferC1Ev")
  //</editor-fold>
  protected MemoryBuffer() {
  }

  
  /// init - Initialize this MemoryBuffer as a reference to externally allocated
  /// memory, memory that we know is already null terminated.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::init">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 45,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 46,
   FQN = "llvm::MemoryBuffer::init", NM = "_ZN4llvm12MemoryBuffer4initEPKcS2_b",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer4initEPKcS2_b")
  //</editor-fold>
  protected void init(/*const*/char$ptr/*char P*/ BufStart, /*const*/char$ptr/*char P*/ BufEnd, 
      boolean RequiresNullTerminator) {
    assert ((!RequiresNullTerminator || BufEnd.$at(0) == 0)) : "Buffer is not null terminated!";
    BufferStart = $toConst(BufStart);
    BufferEnd = $toConst(BufEnd);
    $StringRef = new StringRef(BufStart, BufferEnd.$sub(BufferStart));
  }

/*public:*/
  @Converted(kind = Converted.Kind.DEPRECATED)
  public boolean isInvalid() {
    return InvalidBufferFlag;
  }
  
  @Converted(kind = Converted.Kind.DEPRECATED)
  public void setInvalid() {
    InvalidBufferFlag = true;
  }
  
  //===----------------------------------------------------------------------===//
  // MemoryBuffer implementation itself.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::~MemoryBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 41,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 42,
   FQN = "llvm::MemoryBuffer::~MemoryBuffer", NM = "_ZN4llvm12MemoryBufferD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBufferD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getBufferStart">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 52,
   FQN = "llvm::MemoryBuffer::getBufferStart", NM = "_ZNK4llvm12MemoryBuffer14getBufferStartEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK4llvm12MemoryBuffer14getBufferStartEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBufferStart() /*const*/ {
    return BufferStart;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getBufferEnd">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 53,
   FQN = "llvm::MemoryBuffer::getBufferEnd", NM = "_ZNK4llvm12MemoryBuffer12getBufferEndEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK4llvm12MemoryBuffer12getBufferEndEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBufferEnd() /*const*/ {
    return BufferEnd;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getBufferSize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 51,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 54,
   FQN = "llvm::MemoryBuffer::getBufferSize", NM = "_ZNK4llvm12MemoryBuffer13getBufferSizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK4llvm12MemoryBuffer13getBufferSizeEv")
  //</editor-fold>
  public /*size_t*/int getBufferSize() /*const*/ {
    return BufferEnd.$sub(BufferStart);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 56,
   FQN = "llvm::MemoryBuffer::getBuffer", NM = "_ZNK4llvm12MemoryBuffer9getBufferEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK4llvm12MemoryBuffer9getBufferEv")
  //</editor-fold>
  public StringRef getBuffer() /*const*/ {
    return $StringRef;
  }

  
  /// Return an identifier for this buffer, typically the filename it was read
  /// from.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getBufferIdentifier">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 59,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 62,
   FQN = "llvm::MemoryBuffer::getBufferIdentifier", NM = "_ZNK4llvm12MemoryBuffer19getBufferIdentifierEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK4llvm12MemoryBuffer19getBufferIdentifierEv")
  //</editor-fold>
  public /*virtual*/ /*const*/char$ptr/*char P*/ getBufferIdentifier() /*const*/ {
    return $("Unknown buffer");
  }

  
  /// Open the specified file as a MemoryBuffer, returning a new MemoryBuffer
  /// if successful, otherwise returning null. If FileSize is specified, this
  /// means that the client knows that the file exists and that it has the
  /// specified size.
  ///
  /// \param IsVolatileSize Set to true to indicate that the file size may be
  /// changing, e.g. when libclang tries to parse while the user is
  /// editing/updating the file.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 247,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 246,
   FQN = "llvm::MemoryBuffer::getFile", NM = "_ZN4llvm12MemoryBuffer7getFileERKNS_5TwineExbb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer7getFileERKNS_5TwineExbb")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getFile(/*const*/ Twine /*&*/ Filename) {
    return getFile(Filename, -1, 
         true, false);
  }
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getFile(/*const*/ Twine /*&*/ Filename, long/*int64_t*/ FileSize/*= -1*/) {
    return getFile(Filename, FileSize, 
         true, false);
  }
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getFile(/*const*/ Twine /*&*/ Filename, long/*int64_t*/ FileSize/*= -1*/, 
         boolean RequiresNullTerminator/*= true*/) {
    return getFile(Filename, FileSize, 
         RequiresNullTerminator, false);
  }
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getFile(/*const*/ Twine /*&*/ Filename, long/*int64_t*/ FileSize/*= -1*/, 
         boolean RequiresNullTerminator/*= true*/, boolean IsVolatileSize/*= false*/) {
    return getFileAux(Filename, FileSize, FileSize, 0, 
        RequiresNullTerminator, IsVolatileSize);
  }

  
  /// Given an already-open file descriptor, map some slice of it into a
  /// MemoryBuffer. The slice is specified by an \p Offset and \p MapSize.
  /// Since this is in the middle of a file, the buffer is not null terminated.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getOpenFileSlice">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 415,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 414,
   FQN = "llvm::MemoryBuffer::getOpenFileSlice", NM = "_ZN4llvm12MemoryBuffer16getOpenFileSliceEiRKNS_5TwineEyx",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer16getOpenFileSliceEiRKNS_5TwineEyx")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getOpenFileSlice(int FD, /*const*/ Twine /*&*/ Filename, long/*uint64_t*/ MapSize, 
                  long/*int64_t*/ Offset) {
    assert (MapSize != ((long/*uint64_t*/)(-1)));
    return getOpenFileImpl(FD, Filename, -1, MapSize, Offset, false, 
        /*IsVolatileSize*/ false);
  }

  
  /// Given an already-open file descriptor, read the file and return a
  /// MemoryBuffer.
  ///
  /// \param IsVolatileSize Set to true to indicate that the file size may be
  /// changing, e.g. when libclang tries to parse while the user is
  /// editing/updating the file.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getOpenFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 408,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 407,
   FQN = "llvm::MemoryBuffer::getOpenFile", NM = "_ZN4llvm12MemoryBuffer11getOpenFileEiRKNS_5TwineEybb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer11getOpenFileEiRKNS_5TwineEybb")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getOpenFile(int FD, /*const*/ Twine /*&*/ Filename, long/*uint64_t*/ FileSize) {
    return getOpenFile(FD, Filename, FileSize, 
             true, false);
  }
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getOpenFile(int FD, /*const*/ Twine /*&*/ Filename, long/*uint64_t*/ FileSize, 
             boolean RequiresNullTerminator/*= true*/) {
    return getOpenFile(FD, Filename, FileSize, 
             RequiresNullTerminator, false);
  }
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getOpenFile(int FD, /*const*/ Twine /*&*/ Filename, long/*uint64_t*/ FileSize, 
             boolean RequiresNullTerminator/*= true*/, boolean IsVolatileSize/*= false*/) {
    return getOpenFileImpl(FD, Filename, FileSize, FileSize, 0, 
        RequiresNullTerminator, IsVolatileSize);
  }

  
  /// Open the specified memory range as a MemoryBuffer. Note that InputData
  /// must be null terminated if RequiresNullTerminator is true.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getMemBuffer">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 104,
   FQN = "llvm::MemoryBuffer::getMemBuffer", NM = "_ZN4llvm12MemoryBuffer12getMemBufferENS_9StringRefES1_b",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer12getMemBufferENS_9StringRefES1_b")
  //</editor-fold>
  public static std.unique_ptr<MemoryBuffer> getMemBuffer(StringRef InputData) {
    return getMemBuffer(InputData, StringRef.R$EMPTY, 
              true);
  }
  public static std.unique_ptr<MemoryBuffer> getMemBuffer(StringRef InputData, StringRef BufferName/*= ""*/) {
    return getMemBuffer(InputData, BufferName, 
              true);
  }
  public static std.unique_ptr<MemoryBuffer> getMemBuffer(StringRef InputData, StringRef BufferName/*= ""*/, 
              boolean RequiresNullTerminator/*= true*/) {
    char$ptr copyOfName = create_char$ptr(new$char(BufferName.size() + 1));
    CopyStringRef(copyOfName, BufferName);
    MemoryBufferMem /*P*/ Ret = /*FIXME:*//*new (NamedBufferAlloc(BufferName))*/ new MemoryBufferMem(new StringRef(InputData), RequiresNullTerminator, copyOfName);
    return new std.unique_ptr<MemoryBuffer>(Ret);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getMemBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 112,
   FQN = "llvm::MemoryBuffer::getMemBuffer", NM = "_ZN4llvm12MemoryBuffer12getMemBufferENS_15MemoryBufferRefEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer12getMemBufferENS_15MemoryBufferRefEb")
  //</editor-fold>
  public static std.unique_ptr<MemoryBuffer> getMemBuffer(MemoryBufferRef Ref) {
    return getMemBuffer(Ref, true);
  }
  public static std.unique_ptr<MemoryBuffer> getMemBuffer(MemoryBufferRef Ref, boolean RequiresNullTerminator/*= true*/) {
    return getMemBuffer(Ref.getBuffer(), Ref.getBufferIdentifier(), RequiresNullTerminator);
  }

  
  /// Open the specified memory range as a MemoryBuffer, copying the contents
  /// and taking ownership of it. InputData does not have to be null terminated.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getMemBufferCopy">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 118,
   FQN = "llvm::MemoryBuffer::getMemBufferCopy", NM = "_ZN4llvm12MemoryBuffer16getMemBufferCopyENS_9StringRefERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer16getMemBufferCopyENS_9StringRefERKNS_5TwineE")
  //</editor-fold>
  public static std.unique_ptr<MemoryBuffer> getMemBufferCopy(StringRef InputData) {
    return getMemBufferCopy(InputData, Twine.T$EMPTY);
  }
  public static std.unique_ptr<MemoryBuffer> getMemBufferCopy(StringRef InputData, /*const*/ Twine /*&*/ BufferName/*= ""*/) {
    std.unique_ptr<MemoryBuffer> Buf = getNewUninitMemBuffer(null, InputData.size(), BufferName);
    if (!Buf.$bool()) {
      return new std.unique_ptr<MemoryBuffer>((MemoryBuffer) null);
    }
    memcpy(((/*const_cast*/char$ptr/*char P*/ )(Buf.$arrow().getBufferStart())), InputData.data(), 
        InputData.size());
    return Buf;
  }

  
  /// Allocate a new zero-initialized MemoryBuffer of the specified size. Note
  /// that the caller need not initialize the memory allocated by this method.
  /// The memory is owned by the MemoryBuffer object.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getNewMemBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 155,
   FQN = "llvm::MemoryBuffer::getNewMemBuffer", NM = "_ZN4llvm12MemoryBuffer15getNewMemBufferEjNS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer15getNewMemBufferEjNS_9StringRefE")
  //</editor-fold>
  public static std.unique_ptr<MemoryBuffer> getNewMemBuffer(/*size_t*/int Size) {
    return getNewMemBuffer(null, Size, StringRef.R$EMPTY);
  }
  public static std.unique_ptr<MemoryBuffer> getNewMemBuffer(/*size_t*/int Size, StringRef BufferName/*= ""*/) {
    return getNewMemBuffer(null, Size, BufferName);
  }
  public static std.unique_ptr<MemoryBuffer> getNewMemBuffer(Allocator Alloc, /*size_t*/int Size, StringRef BufferName/*= ""*/) {
    std.unique_ptr<MemoryBuffer> SB = getNewUninitMemBuffer(Alloc, Size, $getMemBufferName(BufferName));
    if (!SB.$bool()) {
      return new std.unique_ptr<MemoryBuffer>((MemoryBuffer) null);
    }
    memset(((/*const_cast*/char$ptr/*char P*/ )(SB.$arrow().getBufferStart())), $$TERM, Size);
    return SB;
  }

  private static Twine $getMemBufferName(StringRef name) {
    if (StringRef.R$EMPTY.equals(name)) {
      return Twine.T$EMPTY;
    } else if (StringRef.R$scratch_space_marker.equals(name)) {
      return Twine.T$scratch_space_marker;
    } else {
      return new Twine(name);
    }
  }
  
  /// Allocate a new MemoryBuffer of the specified size that is not initialized.
  /// Note that the caller should initialize the memory allocated by this
  /// method. The memory is owned by the MemoryBuffer object.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getNewUninitMemBuffer">
  @Converted(kind = Converted.Kind.MANUAL_NON_JAVA, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 129,
   FQN = "llvm::MemoryBuffer::getNewUninitMemBuffer", NM = "_ZN4llvm12MemoryBuffer21getNewUninitMemBufferEjRKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer21getNewUninitMemBufferEjRKNS_5TwineE")
  //</editor-fold>
  public static std.unique_ptr<MemoryBuffer> getNewUninitMemBuffer(/*size_t*/int Size) {
    return getNewUninitMemBuffer(null, Size, Twine.T$EMPTY);
  }
  public static std.unique_ptr<MemoryBuffer> getNewUninitMemBuffer(/*size_t*/int Size, /*const*/ Twine /*&*/ BufferName/*= ""*/) {
    return getNewUninitMemBuffer(null, Size, BufferName);
  }
  public static std.unique_ptr<MemoryBuffer> getNewUninitMemBuffer(Allocator Alloc, /*size_t*/int Size, /*const*/ Twine /*&*/ BufferName/*= ""*/) {
    SmallString/*256*/ NameBuf = null;
    try {
      // Allocate space for the MemoryBuffer, the data and the name. It is important
      // that MemoryBuffer and data are aligned so PointerIntPair works with them.
      // TODO: Is 16-byte alignment enough?  We copy small object files with large
      // alignment expectations into this buffer.
      char$ptr copyOfName;
      if (BufferName.$eq(Twine.T$EMPTY)) {
        copyOfName = NativePointer.$EMPTY;
      } else if (BufferName.$eq(Twine.T$scratch_space_marker)) {
        copyOfName = NativePointer.$scratch_space_marker;  
      } else if (BufferName.$eq(Twine.T$invalid_marker)) {
        copyOfName = NativePointer.$invalid_marker;
      } else {
        NameBuf/*J*/= new SmallString/*256*/(256);
        StringRef NameRef = BufferName.toStringRef(NameBuf);
  //      /*size_t*/int AlignedStringLen = RoundUpToAlignment(sizeof(MemoryBufferMem.class) + NameRef.size() + 1, 16);
  //      /*size_t*/int RealLen = AlignedStringLen + Size + 1;
  //      char$ptr/*char P*/ Mem = $tryClone(((/*static_cast*/char$ptr/*char P*/ )($new_std.size_t_nothrow_t(RealLen, std.nothrow))));
  //      if (!(Mem != null)) {
  //        return new std.unique_ptr<MemoryBuffer>(null);
  //      }
        assert (Alloc == null) : "must not be any allocators here to prevent destroy of cached buffers";
        copyOfName = create_char$ptr(new$char(NameRef.size() + 1));
        CopyStringRef(copyOfName, NameRef);
      }
      // The buffer begins after the name and must be aligned.
      char$ptr/*char P*/ Buf = (Alloc == null) ? create_char$ptr(new$char(Size + 1)) : Alloc.Allocate(Size+1);
      Buf.$set(Size, (byte) 0); // Null terminate buffer.
      
      MemoryBufferMem /*P*/ Ret = /*FIXME:*//*new (Mem)*/ new MemoryBufferMem(new StringRef(Buf, Size), true, copyOfName);
      return new std.unique_ptr<MemoryBuffer>(Ret);
    } finally {
      if (NameBuf != null) { NameBuf.$destroy(); }
    }
  }

  
  /// Read all of stdin into a file buffer, and return it.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getSTDIN">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 423,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 422,
   FQN = "llvm::MemoryBuffer::getSTDIN", NM = "_ZN4llvm12MemoryBuffer8getSTDINEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer8getSTDINEv")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getSTDIN() {
    // Read in all of the data from stdin, we cannot mmap stdin.
    //
    // FIXME: That isn't necessarily true, we should try to mmap stdin and
    // fallback if it fails.
    sys.ChangeStdinToBinary();
    
    return getMemoryBufferForStream(0, new Twine($("<stdin>")));
  }

  
  /// Open the specified file as a MemoryBuffer, or open stdin if the Filename
  /// is "-".
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getFileOrSTDIN">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 164,
   FQN = "llvm::MemoryBuffer::getFileOrSTDIN", NM = "_ZN4llvm12MemoryBuffer14getFileOrSTDINERKNS_5TwineEx",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer14getFileOrSTDINERKNS_5TwineEl")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getFileOrSTDIN(/*const*/ Twine /*&*/ Filename) {
    return getFileOrSTDIN(Filename, -1);
  }
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getFileOrSTDIN(/*const*/ Twine /*&*/ Filename, long/*int64_t*/ FileSize/*= -1*/) {
    SmallString/*256*/ NameBuf = null;
    try {
      NameBuf/*J*/= new SmallString/*256*/(256);
      StringRef NameRef = Filename.toStringRef(NameBuf);
      if ($eq_StringRef(new StringRef(NameRef), StringRef.R$MINUS)) {
        return getSTDIN();
      }
      return getFile(Filename, FileSize);
    } finally {
      if (NameBuf != null) { NameBuf.$destroy(); }
    }
  }

  
  /// Map a subrange of the the specified file as a MemoryBuffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getFileSlice">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 175,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 174,
   FQN = "llvm::MemoryBuffer::getFileSlice", NM = "_ZN4llvm12MemoryBuffer12getFileSliceERKNS_5TwineEyy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer12getFileSliceERKNS_5TwineEyy")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<MemoryBuffer> > getFileSlice(/*const*/ Twine /*&*/ FilePath, long/*uint64_t*/ MapSize, 
              long/*uint64_t*/ Offset) {
    return getFileAux(FilePath, -1, MapSize, Offset, false, false);
  }

  // JAVA PERF: as soon as we shared buffers, let's keep here some other cashes as well
  // IMPORTANT: when add cached update and delegate from MemoryBufferWrapper
  
  // cache for SrcMgr.ContentCache.SourceLineCache
  private int[] $SourceLineCache = null;
  public void setSourceLineCache(int[] SourceLineCache, int NumLines) {
    assert SourceLineCache.length == NumLines : NumLines + " vs. " + SourceLineCache.length;
    synchronized (this) {
      this.$SourceLineCache = SourceLineCache;
    }
  }

  public int[] getSourceLineCache() {
    synchronized (this) {
      return $SourceLineCache;
    }
  }

  // JAVA PERF: MemoryBuffer created for token-cache file;
  // Token cache file has PTH tokens associated with the content of this source buffer;
  // one token-cache memory buffer can be shared between different source memory buffers
  // (i.e. the PTH was created for multiple files to share common data like Identifiers)
  private MemoryBuffer $TokenCacheFileMemoryBuffer = null;
  
  // JAVA PERF: sets cache if not yet initialized by another thread and returns shared one
  public MemoryBuffer setTokenCacheBuffer(MemoryBuffer tokenFileBuffer) {
    assert tokenFileBuffer != null;
    synchronized (this) {
      // assign only if not yet assign from other thread
      if (this.$TokenCacheFileMemoryBuffer == null) {
        this.$TokenCacheFileMemoryBuffer = tokenFileBuffer;
      }
      return this.$TokenCacheFileMemoryBuffer;
    }
  }
  
  public MemoryBuffer getTokenCacheBuffer() {
    synchronized (this) {
      return $TokenCacheFileMemoryBuffer;
    }
  }
  
  //===--------------------------------------------------------------------===//
  // Provided for performance analysis.
  //===--------------------------------------------------------------------===//
  
  /// The kind of memory backing used to support the MemoryBuffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::BufferKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 138,
   FQN = "llvm::MemoryBuffer::BufferKind", NM = "_ZN4llvm12MemoryBuffer10BufferKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN4llvm12MemoryBuffer10BufferKindE")
  //</editor-fold>
  public enum BufferKind {
    MemoryBuffer_Malloc(0),
    MemoryBuffer_MMap(MemoryBuffer_Malloc.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BufferKind valueOf(int val) {
      BufferKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final BufferKind[] VALUES;
      private static final BufferKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BufferKind kind : BufferKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BufferKind[min < 0 ? (1-min) : 0];
        VALUES = new BufferKind[max >= 0 ? (1+max) : 0];
        for (BufferKind kind : BufferKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private BufferKind(/*uint*/int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
  
  /// Return information on the memory mechanism used to support the
  /// MemoryBuffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getBufferKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", old_line = 145,
   FQN = "llvm::MemoryBuffer::getBufferKind", NM = "_ZNK4llvm12MemoryBuffer13getBufferKindEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK4llvm12MemoryBuffer13getBufferKindEv")
  //</editor-fold>
  public abstract /*virtual*/ BufferKind getBufferKind() /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBuffer::getMemBufferRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 441,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 433,
   FQN="llvm::MemoryBuffer::getMemBufferRef", NM="_ZNK4llvm12MemoryBuffer15getMemBufferRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK4llvm12MemoryBuffer15getMemBufferRefEv")
  //</editor-fold>
  public MemoryBufferRef getMemBufferRef() /*const*/ {
    StringRef Data = getBuffer();
    StringRef Identifier = new StringRef(getBufferIdentifier());
    return new MemoryBufferRef(new StringRef(Data), new StringRef(Identifier));
  }

  
  @Override
  public String toString() {
    return (InvalidBufferFlag?"INVALID;":"") + // NOI18N
            "Name="+toJavaString(getBufferIdentifier()) + ";Size=" + getBufferSize() + // NOI18N
            ";Content={\n" + getBuffer().toJavaString() // NOI18N
              + "}"; // NOI18N
  }
}
