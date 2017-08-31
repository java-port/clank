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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import static org.clank.java.built_in.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std.memcpy;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


/// raw_ostream - This class implements an extremely fast bulk output stream
/// that can *only* output to a stream.  It does not support seeking, reopening,
/// rewinding, line buffered disciplines etc. It is a simple buffer that outputs
/// a chunk at a time.
//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 38,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 39,
 FQN = "llvm::raw_ostream", NM = "_ZN4llvm11raw_ostreamE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamE")
//</editor-fold>
public abstract class raw_ostream implements basic_ostream, Destructors.ClassWithDestructor {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 40,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 41,
   FQN = "llvm::raw_ostream::operator=", NM = "_ZN4llvm11raw_ostreamaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/raw_ostream /*&*/ $Prm0) {
    throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::raw_ostream">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 42,
   FQN = "llvm::raw_ostream::raw_ostream", NM = "_ZN4llvm11raw_ostreamC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamC1ERKS0_")
  //</editor-fold>
  private raw_ostream(/*const*/raw_ostream /*&*/ $Prm0) {
    throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
  }

  
  
  /// The buffer is handled in such a way that the buffer is
  /// uninitialized, unbuffered, or out of space when OutBufCur >=
  /// OutBufEnd. Thus a single comparison suffices to determine if we
  /// need to take the slow path to write a single character.
  ///
  /// The buffer is in one of three states:
  ///  1. Unbuffered (BufferMode == Unbuffered)
  ///  1. Uninitialized (BufferMode != Unbuffered && OutBufStart == NULL_BUF).
  ///  2. Buffered (BufferMode != Unbuffered && OutBufStart != NULL_BUF &&
  ///               OutBufEnd - OutBufStart >= 1).
  ///
  /// If buffered, then the raw_ostream owns the buffer if (BufferMode ==
  /// InternalBuffer); otherwise the buffer has been set via SetBuffer and is
  /// managed by the subclass.
  ///
  /// If a subclass installs an external buffer using SetBuffer then it can wait
  /// for a \see write_impl() call to handle the data which has been put into
  /// this buffer.
  private byte[]/*char P*/ OutBufStart$Array;
  private char$ptr/*char P*/ OutBufStart$CharPtr;
  private int/*char P*/ OutBufStart$Index;
  private int/*char P*/ OutBufEnd$Index;
  private int/*char P*/ OutBufCur$Index;

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::BufferKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 63,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 64,
   FQN = "llvm::raw_ostream::BufferKind", NM = "_ZN4llvm11raw_ostream10BufferKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream10BufferKindE")
  //</editor-fold>
  private enum BufferKind {
    Unbuffered(0),
    InternalBuffer(1),
    ExternalBuffer(2);

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
  private  BufferKind BufferMode;
/*public:*/
  // color order matches ANSI escape sequence, don't change
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::Colors">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 71,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 72,
   FQN = "llvm::raw_ostream::Colors", NM = "_ZN4llvm11raw_ostream6ColorsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream6ColorsE")
  //</editor-fold>
  public enum Colors {
    BLACK(0),
    RED(1),
    GREEN(2),
    YELLOW(3),
    BLUE(4),
    MAGENTA(5),
    CYAN(6),
    WHITE(7),
    SAVEDCOLOR(8);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Colors valueOf(int val) {
      Colors out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final Colors[] VALUES;
      private static final Colors[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Colors kind : Colors.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Colors[min < 0 ? (1-min) : 0];
        VALUES = new Colors[max >= 0 ? (1+max) : 0];
        for (Colors kind : Colors.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private Colors(/*uint*/int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::raw_ostream">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 83,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 84,
   FQN = "llvm::raw_ostream::raw_ostream", NM = "_ZN4llvm11raw_ostreamC1Eb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamC1Eb")
  //</editor-fold>
  public /*explicit*/ raw_ostream() {
    this(false);
  }
  public /*explicit*/ raw_ostream(boolean unbuffered/*= false*/) {
    /* : BufferMode(unbuffered ? Unbuffered : InternalBuffer)*/ 
    //START JInit
    this.BufferMode = unbuffered ? BufferKind.Unbuffered : BufferKind.InternalBuffer;
    //END JInit
    // Start out ready to flush.
    OutBufStart$CharPtr = NULL_BUF;
    OutBufStart$Array = OutBufStart$CharPtr.$array();
    OutBufEnd$Index = OutBufCur$Index = OutBufStart$Index = OutBufStart$CharPtr.$index();
  }
  private static final byte[] NULL_ARRAY = new$char(0);
  private static final char$ptr NULL_BUF = create_char$ptr(NULL_ARRAY);

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::~raw_ostream">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 66,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 62,
   FQN = "llvm::raw_ostream::~raw_ostream", NM = "_ZN4llvm11raw_ostreamD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert (OutBufCur$Index == OutBufStart$Index) : "raw_ostream destructor called with non-empty buffer!";
    if (BufferMode == BufferKind.InternalBuffer) {
      /*delete[]*/Destructors.$destroyArray(OutBufStart$Array);
      OutBufStart$CharPtr = NULL_BUF;
      OutBufStart$Array = OutBufStart$CharPtr.$array();
      OutBufEnd$Index = OutBufCur$Index = OutBufStart$Index = OutBufStart$CharPtr.$index();
    }
  }

  
  /// tell - Return the current offset with the file.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::tell">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 92,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 93,
   FQN = "llvm::raw_ostream::tell", NM = "_ZNK4llvm11raw_ostream4tellEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm11raw_ostream4tellEv")
  //</editor-fold>
  public long/*uint64_t*/ tell() /*const*/ {
    return current_pos() + $uint2ullong(GetNumBytesInBuffer());
  }

  
  /// SetBuffered - Set the stream to be buffered, with an automatically
  /// determined buffer size.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::SetBuffered">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 84,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 80,
   FQN = "llvm::raw_ostream::SetBuffered", NM = "_ZN4llvm11raw_ostream11SetBufferedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream11SetBufferedEv")
  //</editor-fold>
  public void SetBuffered() {
    {
      // Ask the subclass to determine an appropriate buffer size.
      /*size_t*/int Size = preferred_buffer_size();
      if ((Size != 0)) {
        SetBufferSize(Size);
      } else {
        // It may return 0, meaning this stream should be unbuffered.
        SetUnbuffered();
      }
    }
  }

  
  /// SetBufferSize - Set the stream to be buffered, using the
  /// specified buffer size.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::SetBufferSize">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 103,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 105,
   FQN = "llvm::raw_ostream::SetBufferSize", NM = "_ZN4llvm11raw_ostream13SetBufferSizeEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream13SetBufferSizeEj")
  //</editor-fold>
  public void SetBufferSize(/*size_t*/int Size) {
    assert Size >= 0 : "forgot about unsigned conversion?";
    flush();
    SetBufferAndMode(create_char$ptr(new$char(Size)), Size, BufferKind.InternalBuffer);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::GetBufferSize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 110,
   FQN = "llvm::raw_ostream::GetBufferSize", NM = "_ZNK4llvm11raw_ostream13GetBufferSizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm11raw_ostream13GetBufferSizeEv")
  //</editor-fold>
  public /*size_t*/int GetBufferSize() /*const*/ {
    // If we're supposed to be buffered but haven't actually gotten around
    // to allocating the buffer yet, return the value that would be used.
    if (BufferMode != BufferKind.Unbuffered && OutBufStart$Array == NULL_ARRAY) {
      return preferred_buffer_size();
    }
    
    // Otherwise just return the size of the allocated buffer.
    return OutBufEnd$Index - OutBufStart$Index;
  }

  
  /// SetUnbuffered - Set the stream to be unbuffered. When
  /// unbuffered, the stream will flush after every write. This routine
  /// will also flush the buffer immediately when the stream is being
  /// set to unbuffered.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::SetUnbuffered">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 121,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 124,
   FQN = "llvm::raw_ostream::SetUnbuffered", NM = "_ZN4llvm11raw_ostream13SetUnbufferedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream13SetUnbufferedEv")
  //</editor-fold>
  public final void SetUnbuffered() {
    flush();
    SetBufferAndMode(null, 0, BufferKind.Unbuffered);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::GetNumBytesInBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 129,
   FQN = "llvm::raw_ostream::GetNumBytesInBuffer", NM = "_ZNK4llvm11raw_ostream19GetNumBytesInBufferEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm11raw_ostream19GetNumBytesInBufferEv")
  //</editor-fold>
  public /*size_t*/int GetNumBytesInBuffer() /*const*/ {
    return OutBufCur$Index - OutBufStart$Index;
  }

  
  //===--------------------------------------------------------------------===//
  // Data Output Interface
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::flush">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 137,
   FQN = "llvm::raw_ostream::flush", NM = "_ZN4llvm11raw_ostream5flushEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream5flushEv")
  //</editor-fold>
  public void flush() {
    if (OutBufCur$Index != OutBufStart$Index) {
      flush_nonempty();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 139,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 142,
   FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEc")
  //</editor-fold>
  public final raw_ostream /*&*/ $out(boolean b) {
    return $out_char((b ? $$1 : $$0));
  }

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 139,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 142,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEc")
//</editor-fold>
public final raw_ostream /*&*/ $out_char(/*char*/byte C) {
  if (OutBufCur$Index >= OutBufEnd$Index) {
    return write(C);
  }
  OutBufStart$Array[OutBufCur$Index++] = C;
  return /*Deref*/this;
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 146,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 149,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEh",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEh")
//</editor-fold>
public final raw_ostream /*&*/ $out_uchar(/*uchar*/byte C) {
  if (OutBufCur$Index >= OutBufEnd$Index) {
    return write((byte) C);
  }
  OutBufStart$Array[OutBufCur$Index++] = (byte) C;
  return /*Deref*/this;
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 153,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 156,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEa",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEa")
//</editor-fold>
public final raw_ostream /*&*/ $out_schar(/*schar*/byte C) {
  if (OutBufCur$Index >= OutBufEnd$Index) {
    return write(C);
  }
  OutBufStart$Array[OutBufCur$Index++] = C;
  return /*Deref*/this;
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 160,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 163,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsENS_9StringRefE")
//</editor-fold>
public final raw_ostream /*&*/ $out(StringRef Str) {
  // Inline fast path, particularly for strings with a known length.
  /*size_t*/int Size = Str.size();
  
  // Make sure we can use the fast path.
  if (Size > (/*size_t*/int)(OutBufEnd$Index - OutBufCur$Index)) {
    return write(Str.data(), Size);
  }
  
  memcpy(OutBufStart$Array, OutBufCur$Index, Str.data(), 0, Size);
  OutBufCur$Index += Size;
  return /*Deref*/this;
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 175,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 176,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEPKc")
//</editor-fold>
public final raw_ostream /*&*/ $out(/*const*/char$ptr/*char P*/ Str) {
  // Inline fast path, particularly for constant strings where a sufficiently
  // smart compiler will simplify strlen.
  return this.$out(Str, strlen(Str));
}
//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 175,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 176,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEPKc")
//</editor-fold>
public final raw_ostream /*&*/ $out(/*const*/char$ptr/*char P*/ Str, /*uint*/int Len) {
  // Inline fast path, particularly for constant strings where a sufficiently
  // smart compiler will simplify strlen.
  return this.$out(new StringRef(Str, Len));
}
//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 175,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 176,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEPKc")
//</editor-fold>  
public final raw_ostream /*&*/ $out(/*const*/String/*char P*/ Str) {
  return $out(new StringRef(Str));
}
  
//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 182,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 183,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsERKSs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsERKSs")
//</editor-fold>
public final raw_ostream /*&*/ $out(/*const*/std.string/*&*/ Str) {
  // Avoid the fast path, it would only increase code size for a marginal win.
  return write(Str.data(), Str.length());
}
  
//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 182,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 183,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsERKSs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsERKSs")
//</editor-fold>
public final raw_ostream /*&*/ $out(/*const*/SmallString/*&*/ Str) {
  return write(Str.$array(), 0, Str.size());
}

  @Override
  public raw_ostream $out(NativeCallback.Void2String o) {
    return $out(o.$call());
  }

  @Override
  public raw_ostream $out(byte o) {
    return $out_schar(o);
  }

  @Override
  public raw_ostream $out(char o) {
    return $out_uint(o);
  }

  @Override
  public raw_ostream $out(int o) {
    return $out_int(o);
  }

  @Override
  public raw_ostream $out(long o) {
    return $out_long(o);
  }

  @Override
  public raw_ostream $out(double o) {
    return $out_double(o);
  }

  @Override
  public raw_ostream $out(String format, Object... args) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public raw_ostream $out_os_str(string str) {
    return $out(str);
  }

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 112,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 108,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEm",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEm")
//</editor-fold>
public final raw_ostream /*&*/ $out_ulong(/*ulong*/long N) {
  // Zero is a special case.
  if (N == 0) {
    return $Deref(this.$out_char($$0));
  }
  
  int/*char P*/ CurPtr = NUMBER_BUFFER_LENGTH;
  while ((N != 0)) {
    number_buffer.$set(--CurPtr, (byte) ($$0 + ((/*char*/byte)(Unsigned.$rem_ulong(N, 10)))));
    N = Unsigned.$div_ulong(N, 10);
  }
  return write(number_buffer, CurPtr, NUMBER_BUFFER_LENGTH - CurPtr);
}
public final raw_ostream /*&*/ $out_ulong$formatted(/*ulong*/long N) {
  return this.$out(NativeTrace.formatNumber(N));
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 128,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 124,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEl",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEl")
//</editor-fold>
public final raw_ostream /*&*/ $out_long(long N) {
  if (N < 0) {
    $Deref(this.$out_char($$MINUS));
    // Avoid undefined behavior on LONG_MIN with a cast.
    N = -(/*ulong*/long)N;
  }
  
  return this.$out_ulong(((/*static_cast*//*ulong*/long)(N)));
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 138,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 134,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEy")
//</editor-fold>
public raw_ostream /*&*/ $out_ullong(/*ullong*/long N) {
  // Output using 32-bit div/mod when possible.
  if (N >= 0) {
    return this.$out_ulong(((/*static_cast*//*ulong*/long)(N)));
  }
  assert false : "JAVA: implement it using BigInteger (was fixing SA_LOCAL_SELF_COMPARISON)";
  int/*char P*/ CurPtr = NUMBER_BUFFER_LENGTH;
  while ((N != 0)) {
    number_buffer.$set(--CurPtr, (byte) ($$0 + ((/*char*/byte)(Unsigned.$rem_ullong(N, 10)))));
    N = Unsigned.$div_ullong(N, 10);
  }
  return write(number_buffer, CurPtr, NUMBER_BUFFER_LENGTH - CurPtr);
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 154,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 150,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEx",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEx")
//</editor-fold>
public final raw_ostream /*&*/ $out_llong(/*llong*/long N) {
  if (N < 0) {
    $Deref(this.$out_char($$MINUS));
    // Avoid undefined behavior on INT64_MIN with a cast.
    N = -(/*ullong*/long)N;
  }
  
  return this.$out_ullong(((/*static_cast*//*ullong*/long)(N)));
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 224,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 220,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEPKv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEPKv")
//</editor-fold>
public final raw_ostream /*&*/ $out_hex(long/*uint64_t*/ P) {
  $Deref(this.$out_char($$0).$out_char($$x));
  return write_hex_impl(P, 0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 224,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 220,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEPKv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEPKv")
//</editor-fold>
public final raw_ostream /*&*/ $out(/*const*/Object/*void P*/ P) {
  $Deref(this.$out_char($$0).$out_char($$x));
  // JAVA: just print hash code
  return write_hex_impl(System.identityHashCode(P), 8);
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 196,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 193,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEj")
//</editor-fold>
public final raw_ostream /*&*/ $out_uint(/*uint*/int N) {
  return this.$out_ulong(((/*static_cast*//*ulong*/long)$uint2long(N)));
}
public final raw_ostream /*&*/ $out_uint(/*uint*/uint$ref N) {
  return this.$out_uint(N.$deref());
}
public final raw_ostream /*&*/ $out_uint$formatted(/*uint*/int N) {
  return this.$out_ulong$formatted(((/*static_cast*//*ulong*/long)$uint2long(N)));
}
public final raw_ostream /*&*/ $out_uint(/*uint*/boolean b) { // some bitfields are 'unsigned' with len 1 => we have boolean storage, but want unsigned int as value
  return this.$out_ulong(b ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 200,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 197,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEi",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEi")
//</editor-fold>
public final raw_ostream /*&*/ $out_int(int N) {
  return this.$out_long(((/*static_cast*/long)(N)));
}

//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 230,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 226,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsEd",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsEd")
//</editor-fold>
public final raw_ostream /*&*/ $out_double(double N) {
  return this.$out(String.format("%e", N));
}


// Formatted output, see the format() function in Support/Format.h.

// Formatted output.
//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 363,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 359,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsERKNS_18format_object_baseE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsERKNS_18format_object_baseE")
//</editor-fold>
public final raw_ostream /*&*/ $out(/*const*/ format_object_base /*&*/ Fmt) {
  SmallVectorChar V = null;
  try {
    // If we have more than a few bytes left in our output buffer, try
    // formatting directly onto its end.
    /*size_t*/int NextBufferSize = 127;
    /*size_t*/int BufferBytesLeft = OutBufEnd$Index - OutBufCur$Index;
    if (BufferBytesLeft > 3) {
      /*size_t*/int BytesUsed = Fmt.print(OutBufStart$CharPtr.$add(OutBufCur$Index), (int) BufferBytesLeft);
      
      // Common case is that we have plenty of space.
      if (BytesUsed <= BufferBytesLeft) {
        OutBufCur$Index += BytesUsed;
        return /*Deref*/this;
      }
      
      // Otherwise, we overflowed and the return value tells us the size to try
      // again with.
      NextBufferSize = BytesUsed;
    }
    
    // If we got here, we didn't have enough space in the output buffer for the
    // string.  Try printing into a SmallVector that is resized to have enough
    // space.  Iterate until we win.
    V/*J*/= new SmallVectorChar(128);
    while (true) {
      V.resize(NextBufferSize);
      
      // Try formatting into the SmallVector.
      /*size_t*/int BytesUsed = Fmt.print(V.data(), (int) NextBufferSize);
      
      // If BytesUsed fit into the vector, we win.
      if (BytesUsed <= NextBufferSize) {
        return write(V.data(), BytesUsed);
      }
      
      // Otherwise, try again with a new size.
      assert (BytesUsed > NextBufferSize) : "Didn't grow buffer!?";
      NextBufferSize = BytesUsed;
    }
  } finally {
    if (V != null) { V.$destroy(); }
  }
}

// Formatted output, see the leftJustify() function in Support/Format.h.
//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 403,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 399,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsERKNS_15FormattedStringE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsERKNS_15FormattedStringE")
//</editor-fold>
public final raw_ostream /*&*/ $out(/*const*/ FormattedString /*&*/ FS) {
  /*uint*/int Len = FS.Str.size();
  int PadAmount = FS.Width - Len;
  if (FS.RightJustify && (PadAmount > 0)) {
    this.indent(PadAmount);
  }
  this.$out(new StringRef(FS.Str));
  if (!FS.RightJustify && (PadAmount > 0)) {
    this.indent(PadAmount);
  }
  return /*Deref*/this;
}

// Formatted output, see the formatHex() function in Support/Format.h.
//<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::operator<<">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 414,
 old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 410,
 FQN = "llvm::raw_ostream::operator<<", NM = "_ZN4llvm11raw_ostreamlsERKNS_15FormattedNumberE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostreamlsERKNS_15FormattedNumberE")
//</editor-fold>
public final raw_ostream /*&*/ $out(/*const*/ FormattedNumber /*&*/ FN) {
  if (FN.Hex) {
    /*uint*/int Nibbles = (64 - countLeadingZeros_uint64_t_ZeroBehavior(FN.HexValue) + 3) / 4;
    assert Nibbles >= 0 : "Nibbles must not be negatove: " + Nibbles;
    /*uint*/int Width = (FN.Width > Nibbles + 2) ? FN.Width : Nibbles + 2;
    assert Width >= 0 : "Width must not be negatove: " + Width;
            
    /*char*/byte NumberBuffer[/*20*/] = new$char(20, $$0, $$x, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0, $$0);
    char$ptr/*char P*/ EndPtr = create_char$ptr(NumberBuffer, Width);
    char$ptr/*char P*/ CurPtr = $tryClone(EndPtr);
    /*const*//*char*/byte A = FN.Upper ? $$A : $$a;
    /*ullong*/long N = FN.HexValue;
    while ((N != 0L)) {
      long/*uintptr_t*/ x = Unsigned.$rem_ullong(N, 16);
      CurPtr.$preDec().$set((x < 10L ? (byte)($$0 + x) : (byte)(A + x - 10L)));
      N = Unsigned.$div_ullong(N, 16);
    }
    
    return write(NumberBuffer, 0, Width);
  } else {
    // Zero is a special case.
    if (FN.DecValue == 0) {
      this.indent(FN.Width - 1);
      return $Deref(this.$out_char($$0));
    }
    /*char*/byte NumberBuffer[/*32*/] = new$char(32);
    char$ptr/*char P*/ EndPtr = create_char$ptr(NumberBuffer, 32);
    char$ptr/*char P*/ CurPtr = $tryClone(EndPtr);
    boolean Neg = (FN.DecValue < 0);
    long/*uint64_t*/ N = Neg ? -((/*static_cast*/long/*uint64_t*/)(FN.DecValue)) : FN.DecValue;
    while ((N != 0)) {
      CurPtr.$preDec().$set((byte)($$0 + ((/*char*/byte)(Unsigned.$rem_ulong(N, 10)))));
      N = Unsigned.$div_ulong(N, 10);
    }
    int Len = EndPtr.$sub(CurPtr);
    int Pad = FN.Width - Len;
    if (Neg) {
      --Pad;
    }
    if (Pad > 0) {
      this.indent(Pad);
    }
    if (Neg) {
      $Deref(this.$out_char($$MINUS));
    }
    return write(CurPtr, Len);
  }
}
  
  /// write_hex - Output \p N in hexadecimal, without any prefix or padding.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::write_hex">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 164,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 160,
   FQN = "llvm::raw_ostream::write_hex", NM = "_ZN4llvm11raw_ostream9write_hexEy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream9write_hexEy")
  //</editor-fold>
  public final raw_ostream /*&*/ write_hex(/*ullong*/long N) {
    return write_hex_impl(N, 0);
  }
  private final raw_ostream /*&*/ write_hex_impl(/*ullong*/long N, int printAtLeastDigitsAmount) {
    // Zero is a special case.
    if (N == 0) {
      return $Deref(this.$out_char($$0));
    }
    
    int/*char P*/ CurPtr = NUMBER_BUFFER_LENGTH;
    while ((N != 0)) {
      long/*uintptr_t*/ x = Unsigned.$rem_ullong(N, 16);
      number_buffer.$set(--CurPtr, (byte)(x < 10 ? '0' + x : 'a' + x - 10));
      N = Unsigned.$div_ullong(N, 16);
      printAtLeastDigitsAmount--;
    }
    while (printAtLeastDigitsAmount-- > 0) {
      number_buffer.$set(--CurPtr, $$0);
    }
    return write(number_buffer, CurPtr, NUMBER_BUFFER_LENGTH - CurPtr);    
  }

  
  /// write_escaped - Output \p Str, turning '\\', '\t', '\n', '"', and
  /// anything that doesn't satisfy std::isprint into an escape sequence.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::write_escaped">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 182,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 178,
   FQN = "llvm::raw_ostream::write_escaped", NM = "_ZN4llvm11raw_ostream13write_escapedENS_9StringRefEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream13write_escapedENS_9StringRefEb")
  //</editor-fold>
  public final raw_ostream /*&*/ write_escaped(StringRef Str) {
    return write_escaped(Str, false);
  }
  public final raw_ostream /*&*/ write_escaped(StringRef Str, boolean UseHexEscapes/*= false*/) {
    for (/*uint*/int i = 0, e = Str.size(); i != e; ++i) {
      /*uchar*/byte c = Str.$at(i);
      switch (c) {
       case $$BACK_SLASH:
        $Deref(this.$out_char($$BACK_SLASH).$out_char($$BACK_SLASH));
        break;
       case $$TAB:
        $Deref(this.$out_char($$BACK_SLASH).$out_char($$t));
        break;
       case $$LF:
        $Deref(this.$out_char($$BACK_SLASH).$out_char($$n));
        break;
       case $$DBL_QUOTE:
        $Deref(this.$out_char($$BACK_SLASH).$out_char($$DBL_QUOTE));
        break;
       default:
        if ((std.isprint(c) != 0)) {
          $Deref(this.$out_uchar(c));
          break;
        }
        
        // Write out the escaped representation.
        if (UseHexEscapes) {
          $Deref(this.$out_char($$BACK_SLASH).$out_char($$x));
          $Deref(this.$out_char(hexdigit((c >>> 4 & 0xF))));
          $Deref(this.$out_char(hexdigit((c >>> 0) & 0xF)));
        } else {
          // Always use a full 3-character octal escape.
          $Deref(this.$out_char($$BACK_SLASH));
          $Deref(this.$out_char(((/*char*/byte)($$0 + ((c >>> 6) & 7)))));
          $Deref(this.$out_char(((/*char*/byte)($$0 + ((c >>> 3) & 7)))));
          $Deref(this.$out_char(((/*char*/byte)($$0 + ((c >>> 0) & 7)))));
        }
      }
    }
    
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::write">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 280,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 276,
   FQN = "llvm::raw_ostream::write", NM = "_ZN4llvm11raw_ostream5writeEh",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream5writeEh")
  //</editor-fold>
  public final raw_ostream /*&*/ write(/*uchar*/byte C) {
    // Group exceptional cases into a single branch.
    if ((__builtin_expect((boolean)(OutBufCur$Index >= OutBufEnd$Index), false) != 0)) {
      if ((__builtin_expect((boolean)(!(OutBufStart$Array != NULL_ARRAY)), false) != 0)) {
        if (BufferMode == BufferKind.Unbuffered) {
          single_char.$set(0, ((byte)$AddrOf(C)));
          write_impl(single_char, 0, 1);
          return /*Deref*/this;
        }
        // Set up a buffer and start over.
        SetBuffered();
        return write(C);
      }
      
      flush_nonempty();
    }
    
    OutBufStart$Array[OutBufCur$Index++] = (byte) C;
    return /*Deref*/this;
  }
  private final char$ptr single_char = create_char$ptr(new$char$elem((byte)/*AddrOf*/0));
  private static final int NUMBER_BUFFER_LENGTH = 20;
  private final char$ptr number_buffer = create_char$ptr(new$char(NUMBER_BUFFER_LENGTH));

  public final raw_ostream /*&*/ write(/*const*/String/*char P*/ Str, /*size_t*/int Size) {
    return write(create_char$ptr(Str), 0, Size);
  }
  
  public final raw_ostream /*&*/ write(/*const*/byte[]/*char P*/ Ptr, /*uint*/int PtrIdx, /*size_t*/int Size) {
    return writeBytes(Ptr, PtrIdx, (int)Size);
  }
  private raw_ostream /*&*/ writeBytes(/*const*/byte[]/*char P*/ Ptr, /*uint*/int PtrIdx, /*size_t*/int Size) {
    assert Size >= 0 : "forgot about unsigned conversion?";
    // Group exceptional cases into a single branch.
    if ((__builtin_expect((boolean)(((/*size_t*/int)(OutBufEnd$Index - OutBufCur$Index)) < Size), false) != 0)) {
      if ((__builtin_expect((boolean)(!(OutBufStart$Array != NULL_ARRAY)), false) != 0)) {
        if (BufferMode == BufferKind.Unbuffered) {
          write_impl(Ptr, PtrIdx, Size);
          return /*Deref*/this;
        }
        // Set up a buffer and start over.
        SetBuffered();
        return writeBytes(Ptr, PtrIdx, Size);
      }
      
      /*size_t*/int NumBytes = OutBufEnd$Index - OutBufCur$Index;
      
      // If the buffer is empty at this point we have a string that is larger
      // than the buffer. Directly write the chunk that is a multiple of the
      // preferred buffer size and put the remainder in the buffer.
      if ((__builtin_expect((boolean)(OutBufCur$Index == OutBufStart$Index), false) != 0)) {
        assert (NumBytes != 0) : "undefined behavior";
        /*size_t*/int BytesToWrite = Size - (Size % NumBytes);
        write_impl(Ptr, PtrIdx, BytesToWrite);
        /*size_t*/int BytesRemaining = Size - BytesToWrite;
        if (BytesRemaining > ((/*size_t*/int)(OutBufEnd$Index - OutBufCur$Index))) {
          // Too much left over to copy into our buffer.
          return writeBytes(Ptr, PtrIdx+BytesToWrite, BytesRemaining);
        }
        copy_to_buffer(Ptr, PtrIdx+BytesToWrite, BytesRemaining);
        return /*Deref*/this;
      }
      
      // We don't have enough space in the buffer to fit the string in. Insert as
      // much as possible, flush and start over with the remainder.
      copy_to_buffer(Ptr, PtrIdx, NumBytes);
      flush_nonempty();
      return writeBytes(Ptr, PtrIdx+NumBytes, Size - NumBytes);
    }
    
    copy_to_buffer(Ptr, PtrIdx, Size);
    
    return /*Deref*/this;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public final raw_ostream /*&*/ write(/*const*/char$iterator/*char P*/ Ptr, /*size_t*/int Size) {
    byte[] buf = new byte[Size];
    for (int i = 0; i < buf.length; i++) {
      buf[i] = Ptr.$star();
      Ptr.$postInc();
    }
    return write(buf, 0, Size);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::write">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 300,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 296,
   FQN = "llvm::raw_ostream::write", NM = "_ZN4llvm11raw_ostream5writeEPKcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream5writeEPKcj")
  //</editor-fold>
  public final raw_ostream /*&*/ write(/*const*/char$ptr/*char P*/ Ptr, /*size_t*/int Size) {
    return write(Ptr, 0, (int)Size);
  }
  
  public final raw_ostream /*&*/ write(/*const*/char$ptr/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size) {
    if ($is_array_based(Ptr)) {
      return writeBytes(Ptr.$array(), Ptr.$index() + PtrIdx, Size);
    } else {
      return writeCharPtr(Ptr, PtrIdx, Size);
    }
  }
  
  private raw_ostream /*&*/ writeCharPtr(/*const*/char$ptr/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size) {
    assert Size >= 0 : "forgot about unsigned conversion?";
    // Group exceptional cases into a single branch.
    if ((__builtin_expect((boolean)(((/*size_t*/int)(OutBufEnd$Index - OutBufCur$Index)) < Size), false) != 0)) {
      if ((__builtin_expect((boolean)(!(OutBufStart$Array != NULL_ARRAY)), false) != 0)) {
        if (BufferMode == BufferKind.Unbuffered) {
          write_impl(Ptr, PtrIdx, Size);
          return /*Deref*/this;
        }
        // Set up a buffer and start over.
        SetBuffered();
        return write(Ptr, PtrIdx, Size);
      }
      
      /*size_t*/int NumBytes = OutBufEnd$Index - OutBufCur$Index;
      
      // If the buffer is empty at this point we have a string that is larger
      // than the buffer. Directly write the chunk that is a multiple of the
      // preferred buffer size and put the remainder in the buffer.
      if ((__builtin_expect((boolean)(OutBufCur$Index == OutBufStart$Index), false) != 0)) {
        assert (NumBytes != 0) : "undefined behavior";
        /*size_t*/int BytesToWrite = Size - (Size % NumBytes);
        write_impl(Ptr, PtrIdx, BytesToWrite);
        /*size_t*/int BytesRemaining = Size - BytesToWrite;
        if (BytesRemaining > ((/*size_t*/int)(OutBufEnd$Index - OutBufCur$Index))) {
          // Too much left over to copy into our buffer.
          return write(Ptr, PtrIdx+BytesToWrite, BytesRemaining);
        }
        copy_to_buffer(Ptr, PtrIdx+BytesToWrite, BytesRemaining);
        return /*Deref*/this;
      }
      
      // We don't have enough space in the buffer to fit the string in. Insert as
      // much as possible, flush and start over with the remainder.
      copy_to_buffer(Ptr, PtrIdx, NumBytes);
      flush_nonempty();
      return write(Ptr, PtrIdx+NumBytes, Size - NumBytes);
    }
    
    copy_to_buffer(Ptr, PtrIdx, Size);
    
    return /*Deref*/this;
  }
  
  /// indent - Insert 'NumSpaces' spaces.
  private static final String SPACES = "                                                                                ";
  private final static byte[] Spaces/*[81]*/ = SPACES.getBytes();
  
  /// indent - Insert 'NumSpaces' spaces.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::indent">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 463,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 456,
   FQN = "llvm::raw_ostream::indent", NM = "_ZN4llvm11raw_ostream6indentEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream6indentEj")
  //</editor-fold>
  public final raw_ostream /*&*/ indent(/*uint*/int NumSpaces) {
    assert NumSpaces >= 0 : "forgot about unsigned conversion?";
    // Usually the indentation is small, handle it with a fastpath.
    if (NumSpaces < array_lengthof(SPACES)) {
      return writeBytes(Spaces, 0, (int)NumSpaces);
    }
    while ((NumSpaces != 0)) {
      /*uint*/int NumToWrite = std.min((int)NumSpaces, array_lengthof(SPACES) - 1);
      writeBytes(Spaces, 0, NumToWrite);
      NumSpaces -= NumToWrite;
    }
    return /*Deref*/this;
  }

  
  /// Changes the foreground color of text that will be output from this point
  /// forward.
  /// @param Color ANSI color to use, the special SAVEDCOLOR can be used to
  /// change only the bold attribute, and keep colors untouched
  /// @param Bold bold/brighter text, default false
  /// @param BG if true change the background, default: change foreground
  /// @returns itself so it can be used within << invocations
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::changeColor">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 235,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 233,
   FQN = "llvm::raw_ostream::changeColor", NM = "_ZN4llvm11raw_ostream11changeColorENS0_6ColorsEbb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream11changeColorENS0_6ColorsEbb")
  //</editor-fold>
  public /*virtual*/ raw_ostream /*&*/ changeColor( Colors Color) {
    return changeColor(Color, false, false);
  }
  public /*virtual*/ raw_ostream /*&*/ changeColor( Colors Color, boolean Bold/*= false*/) {
    return changeColor(Color, Bold, false);
  }
  public /*virtual*/ raw_ostream /*&*/ changeColor( Colors Color, boolean Bold/*= false*/, boolean BG/*= false*/) {
    /*
    (void)Color;
    (void)Bold;
    (void)BG;
    */
    return /*Deref*/this;
  }

  
  /// Resets the colors to terminal defaults. Call this when you are done
  /// outputting colored text, or before program exit.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::resetColor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 246,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 244,
   FQN = "llvm::raw_ostream::resetColor", NM = "_ZN4llvm11raw_ostream10resetColorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream10resetColorEv")
  //</editor-fold>
  public /*virtual*/ raw_ostream /*&*/ resetColor() {
    return /*Deref*/this;
  }

  
  /// Reverses the forground and background colors.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::reverseColor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 249,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 247,
   FQN = "llvm::raw_ostream::reverseColor", NM = "_ZN4llvm11raw_ostream12reverseColorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream12reverseColorEv")
  //</editor-fold>
  public /*virtual*/ raw_ostream /*&*/ reverseColor() {
    return /*Deref*/this;
  }

  
  /// This function determines if this stream is connected to a "tty" or
  /// "console" window. That is, the output would be displayed to the user
  /// rather than being put on a pipe or stored in a file.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::is_displayed">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 252,
   FQN = "llvm::raw_ostream::is_displayed", NM = "_ZNK4llvm11raw_ostream12is_displayedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm11raw_ostream12is_displayedEv")
  //</editor-fold>
  public /*virtual*/ boolean is_displayed() /*const*/ {
    return false;
  }

  
  /// This function determines if this stream is displayed and supports colors.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::has_colors">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 255,
   FQN = "llvm::raw_ostream::has_colors", NM = "_ZNK4llvm11raw_ostream10has_colorsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm11raw_ostream10has_colorsEv")
  //</editor-fold>
  public /*virtual*/ boolean has_colors() /*const*/ {
    return is_displayed();
  }

/*private:*/
  /// write_impl - The is the piece of the class that is implemented
  /// by subclasses.  This writes the \p Size bytes starting at
  /// \p Ptr to the underlying stream.
  ///
  /// This function is guaranteed to only be called at a point at which it is
  /// safe for the subclass to install a new buffer via SetBuffer.
  ///
  /// \param Ptr The start of the data to be written. For buffered streams this
  /// is guaranteed to be the start of the buffer.
  ///
  /// \param Size The number of bytes to be written.
  ///
  /// \invariant { Size > 0 }
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::write_impl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 277,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 275,
   FQN = "llvm::raw_ostream::write_impl", NM = "_ZN4llvm11raw_ostream10write_implEPKcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream10write_implEPKcj")
  //</editor-fold>
  protected/*private*/ abstract /*virtual*/ void write_impl(/*const*/char$ptr/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size)/* = 0*/;
  
  protected/*private*/ /*virtual*/ void write_impl(/*const*/byte[]/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size) {
    trackNonOptimizedWriteBytes(Size);
    write_impl(create_char$ptr(Ptr), PtrIdx, Size);
  }

  
  // An out of line virtual method to provide a home for the class vtable.
  
  // An out of line virtual method to provide a home for the class vtable.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::handle">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 77,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 73,
   FQN = "llvm::raw_ostream::handle", NM = "_ZN4llvm11raw_ostream6handleEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream6handleEv")
  //</editor-fold>
  protected/*private*/ void handle() {
  }

  
  /// current_pos - Return the current position within the stream, not
  /// counting the bytes currently in the buffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::current_pos">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 284,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 282,
   FQN = "llvm::raw_ostream::current_pos", NM = "_ZNK4llvm11raw_ostream11current_posEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm11raw_ostream11current_posEv")
  //</editor-fold>
  protected/*private*/ abstract /*virtual*/ long/*uint64_t*/ current_pos() /*const*//* = 0*/;

/*protected:*/
  /// SetBuffer - Use the provided buffer as the raw_ostream buffer. This is
  /// intended for use only by subclasses which can arrange for the output to go
  /// directly into the desired output buffer, instead of being copied on each
  /// flush.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::SetBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 290,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", old_line = 289,
   FQN = "llvm::raw_ostream::SetBuffer", NM = "_ZN4llvm11raw_ostream9SetBufferEPcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream9SetBufferEPcj")
  //</editor-fold>
  protected void SetBuffer(char$ptr/*char P*/ BufferStart, /*size_t*/int Size) {
    SetBufferAndMode(BufferStart, Size, BufferKind.ExternalBuffer);
  }

  
  /// preferred_buffer_size - Return an efficient buffer size for the
  /// underlying output mechanism.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::preferred_buffer_size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 79,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 75,
   FQN = "llvm::raw_ostream::preferred_buffer_size", NM = "_ZNK4llvm11raw_ostream21preferred_buffer_sizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm11raw_ostream21preferred_buffer_sizeEv")
  //</editor-fold>
  protected /*size_t*/int preferred_buffer_size() /*const*/ {
    // BUFSIZ is intended to be a reasonable default.
    return 1024;
  }

  
  /// getBufferStart - Return the beginning of the current stream buffer, or 0
  /// if the stream is unbuffered.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::getBufferStart">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/raw_ostream.h", line = 299,
   FQN = "llvm::raw_ostream::getBufferStart", NM = "_ZNK4llvm11raw_ostream14getBufferStartEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZNK4llvm11raw_ostream14getBufferStartEv")
  //</editor-fold>
  protected final /*const*/char$ptr/*char P*/ getBufferStart() /*const*/ {
    return OutBufStart$CharPtr == NULL_BUF ? null : OutBufStart$CharPtr;
  }

/*private:*/
  /// SetBufferAndMode - Install the given buffer and mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::SetBufferAndMode">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 93,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 89,
   FQN = "llvm::raw_ostream::SetBufferAndMode", NM = "_ZN4llvm11raw_ostream16SetBufferAndModeEPcjNS0_10BufferKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream16SetBufferAndModeEPcjNS0_10BufferKindE")
  //</editor-fold>
  private void SetBufferAndMode(char$ptr/*char P*/ BufferStart, /*size_t*/int Size, BufferKind Mode) {
    assert Size >= 0 : "forgot about unsigned conversion?";
    assert (((Mode == BufferKind.Unbuffered && !(BufferStart != null) && Size == 0) || (Mode != BufferKind.Unbuffered && (BufferStart != null) && Size != 0))) : "stream must be unbuffered or have at least one byte";
    // Make sure the current buffer is free of content (we can't flush here; the
    // child buffer management logic will be in write_impl).
    assert (GetNumBytesInBuffer() == 0) : "Current buffer is non-empty!";
    if (BufferMode == BufferKind.InternalBuffer) {
      // clean up old buffer
      /*delete[]*/Destructors.$destroyArray(OutBufStart$Array);
      OutBufStart$CharPtr = NULL_BUF;
      OutBufStart$Array = NULL_ARRAY;
    }
    OutBufStart$CharPtr = (BufferStart == null) ? NULL_BUF : BufferStart;
    assert OutBufStart$CharPtr.$array() != null;
    OutBufStart$Array = OutBufStart$CharPtr.$array();
    OutBufStart$Index = OutBufStart$CharPtr.$index();
    OutBufCur$Index = OutBufStart$Index;
    OutBufEnd$Index = OutBufStart$Index + (int)Size;
    BufferMode = Mode;
    assert (OutBufStart$Index <= OutBufEnd$Index) : "Invalid size!";
  }

  
  /// flush_nonempty - Flush the current buffer, which is known to be
  /// non-empty. This outputs the currently buffered data and resets
  /// the buffer to empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::flush_nonempty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 273,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 269,
   FQN = "llvm::raw_ostream::flush_nonempty", NM = "_ZN4llvm11raw_ostream14flush_nonemptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream14flush_nonemptyEv")
  //</editor-fold>
  private void flush_nonempty() {
    assert (OutBufCur$Index > OutBufStart$Index) : "Invalid call to flush_nonempty.";
    /*size_t*/int Length = OutBufCur$Index - OutBufStart$Index;
    OutBufCur$Index = OutBufStart$Index;
    write_impl(OutBufStart$Array, OutBufCur$Index, Length);
  }

  
  /// copy_to_buffer - Copy data into the buffer. Size must not be
  /// greater than the number of unused bytes in the buffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::raw_ostream::copy_to_buffer">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 343,
   old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 339,
   FQN = "llvm::raw_ostream::copy_to_buffer", NM = "_ZN4llvm11raw_ostream14copy_to_bufferEPKcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm11raw_ostream14copy_to_bufferEPKcj")
  //</editor-fold>
  private void copy_to_buffer(/*const*/char$ptr/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size) {
    assert Size >= 0 : "forgot about unsigned conversion?";
    assert (Size <= (OutBufEnd$Index - OutBufCur$Index)) : "Buffer overrun!";
    
    // Handle short strings specially, memcpy isn't very good at very short
    // strings.
//    switch ((int)Size) {
//     case 4: // FALL THROUGH
//      OutBufStart[OutBufCur+3] = Ptr.$at(PtrIdx+3);
//     case 3: // FALL THROUGH
//      OutBufStart[OutBufCur+2] = Ptr.$at(PtrIdx+2);
//     case 2: // FALL THROUGH
//      OutBufStart[OutBufCur+1] = Ptr.$at(PtrIdx+1);
//     case 1: // FALL THROUGH
//      OutBufStart[OutBufCur] = Ptr.$at(PtrIdx);
//     case 0:
//      break;
//     default:
      memcpy(OutBufStart$Array, OutBufCur$Index, Ptr, PtrIdx, Size);
//      break;
//    }
    
    OutBufCur$Index += Size;
  }

  private void copy_to_buffer(/*const*/byte[]/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size) {
    assert Size >= 0 : "forgot about unsigned conversion?";
    assert (Size <= (OutBufEnd$Index - OutBufCur$Index)) : "Buffer overrun!";
    
    // Handle short strings specially, memcpy isn't very good at very short
    // strings.
//    switch (Size) {
//     case 4: // FALL THROUGH
//      OutBufStart[OutBufCur+3] = Ptr[PtrIdx+3];
//     case 3: // FALL THROUGH
//      OutBufStart[OutBufCur+2] = Ptr[PtrIdx+2];
//     case 2: // FALL THROUGH
//      OutBufStart[OutBufCur+1] = Ptr[PtrIdx+1];
//     case 1: // FALL THROUGH
//      OutBufStart[OutBufCur] = Ptr[PtrIdx];
//     case 0:
//      break;
//     default:
      memcpy(OutBufStart$Array, OutBufCur$Index, Ptr, PtrIdx, Size);
//      break;
//    }
    
    OutBufCur$Index += Size;
  }

  @Override
  public String toString() {
    return "raw_ostream{" + "BufferMode=" + BufferMode + "\nStart=" + create_char$ptr(OutBufStart$Array) + "\nCur=" + OutBufCur$Index + "End=" + OutBufEnd$Index + '}';
  }

  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long NonOptimizedWriteBytesCalls = 0;
  private static long NonOptimizedWriteBytesSize = 0;
  private static void trackNonOptimizedWriteBytes(int Size) {
    if (NativeTrace.STATISTICS) {
      NonOptimizedWriteBytesCalls++;
      NonOptimizedWriteBytesSize += Size;
    }
  }
  
  public static void clearStatistics() {
    NonOptimizedWriteBytesCalls = 0;
    NonOptimizedWriteBytesSize = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s called:\t", "slow write_impl(byte[])")).$out(NativeTrace.formatNumber(NonOptimizedWriteBytesCalls)).$out(".\n");
    out.$out(String.format("%22s  Bytes:\t", "slow write_impl(byte[])")).$out(NativeTrace.formatNumber(NonOptimizedWriteBytesSize)).$out(".\n");
    NativeTrace.dumpStatisticValue("RawOStreamNonOptimalWrites", NonOptimizedWriteBytesCalls);
    NativeTrace.dumpStatisticValue("RawOStreamNonOptimalWrittenBytes", NonOptimizedWriteBytesSize);
    return NonOptimizedWriteBytesCalls + NonOptimizedWriteBytesSize;
  }  
  
}
