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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.impl.FormattedStreamStatics;


/// formatted_raw_ostream - A raw_ostream that wraps another one and keeps track
/// of line and column position, allowing padding out to specific column
/// boundaries and querying the number of lines written to the stream.
///
//<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 27,
 FQN="llvm::formatted_raw_ostream", NM="_ZN4llvm21formatted_raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostreamE")
//</editor-fold>
public class formatted_raw_ostream extends /*public*/ raw_ostream implements Destructors.ClassWithDestructor {
  /// TheStream - The real stream we output to. We set it to be
  /// unbuffered, since we're already doing our own buffering.
  ///
  private raw_ostream /*P*/ TheStream;
  
  /// Position - The current output column and line of the data that's
  /// been flushed and the portion of the buffer that's been
  /// scanned.  The line and column scheme is zero-based.
  ///
  private std.pairUIntUInt Position;
  
  /// Scanned - This points to one past the last character in the
  /// buffer we've scanned.
  ///
  private /*const*/char$ptr/*char P*/ Scanned;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::write_impl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 76,
   FQN="llvm::formatted_raw_ostream::write_impl", NM="_ZN4llvm21formatted_raw_ostream10write_implEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream10write_implEPKcj")
  //</editor-fold>
  @Override protected/*private*/ void write_impl(/*const*/char$ptr/*char P*/ Ptr, int PtrIdx, /*size_t*/int Size)/* override*/ {
    // JAVA: TODO: optimize
    Ptr = Ptr.$add(PtrIdx);
    
    // Figure out what's in the buffer and add it to the column count.
    ComputePosition(Ptr, Size);
    
    // Write the data to the underlying stream (which is unbuffered, so
    // the data will be immediately written out).
    TheStream.write(Ptr, Size);
    
    // Reset the scanning pointer.
    Scanned = null;
  }

  
  /// current_pos - Return the current position within the stream,
  /// not counting the bytes currently in the buffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::current_pos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 48,
   FQN="llvm::formatted_raw_ostream::current_pos", NM="_ZNK4llvm21formatted_raw_ostream11current_posEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZNK4llvm21formatted_raw_ostream11current_posEv")
  //</editor-fold>
  @Override protected/*private*/ long/*uint64_t*/ current_pos() /*const*//* override*/ {
    // Our current position in the stream is all the contents which have been
    // written to the underlying stream (*not* the current position of the
    // underlying stream).
    return TheStream.tell();
  }

  
  /// ComputePosition - Examine the given output buffer and figure out the new
  /// position after output.
  ///
  
  /// ComputePosition - Examine the current output and update line and column
  /// counts.
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::ComputePosition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 48,
   FQN="llvm::formatted_raw_ostream::ComputePosition", NM="_ZN4llvm21formatted_raw_ostream15ComputePositionEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream15ComputePositionEPKcj")
  //</editor-fold>
  private void ComputePosition(/*const*/char$ptr/*char P*/ Ptr, /*size_t*/int Size) {
    // If our previous scan pointer is inside the buffer, assume we already
    // scanned those bytes. This depends on raw_ostream to not change our buffer
    // in unexpected ways.
    if ((Scanned != null) && Ptr.$lesseq(Scanned) && Scanned.$lesseq(Ptr.$add(Size))) {
      // Scan all characters added since our last scan to determine the new
      // column.
      FormattedStreamStatics.UpdatePosition(Position, Scanned, Size - (Scanned.$sub(Ptr)));
    } else {
      FormattedStreamStatics.UpdatePosition(Position, Ptr, Size);
    }
    
    // Update the scanning pointer.
    Scanned = $tryClone(Ptr.$add(Size));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::setStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 60,
   FQN="llvm::formatted_raw_ostream::setStream", NM="_ZN4llvm21formatted_raw_ostream9setStreamERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream9setStreamERNS_11raw_ostreamE")
  //</editor-fold>
  private void setStream(final raw_ostream /*&*/ Stream) {
    releaseStream();
    
    TheStream = $AddrOf(Stream);
    {
      
      // This formatted_raw_ostream inherits from raw_ostream, so it'll do its
      // own buffering, and it doesn't need or want TheStream to do another
      // layer of buffering underneath. Resize the buffer to what TheStream
      // had been using, and tell TheStream not to do its own buffering.
      /*size_t*/int BufferSize = TheStream.GetBufferSize();
      if ((BufferSize != 0)) {
        SetBufferSize(BufferSize);
      } else {
        SetUnbuffered();
      }
    }
    TheStream.SetUnbuffered();
    
    Scanned = null;
  }

/*public:*/
  /// formatted_raw_ostream - Open the specified file for
  /// writing. If an error occurs, information about the error is
  /// put into ErrorInfo, and the stream should be immediately
  /// destroyed; the string will be empty if no error occurred.
  ///
  /// As a side effect, the given Stream is set to be Unbuffered.
  /// This is because formatted_raw_ostream does its own buffering,
  /// so it doesn't want another layer of buffering to be happening
  /// underneath it.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::formatted_raw_ostream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 89,
   FQN="llvm::formatted_raw_ostream::formatted_raw_ostream", NM="_ZN4llvm21formatted_raw_ostreamC1ERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostreamC1ERNS_11raw_ostreamE")
  //</editor-fold>
  public formatted_raw_ostream(final raw_ostream /*&*/ Stream) {
    // : raw_ostream(), TheStream(null), Position(0, 0) 
    //START JInit
    super();
    this.TheStream = null;
    this.Position = new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, 0, 0);
    //END JInit
    setStream(Stream);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::formatted_raw_ostream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 93,
   FQN="llvm::formatted_raw_ostream::formatted_raw_ostream", NM="_ZN4llvm21formatted_raw_ostreamC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostreamC1Ev")
  //</editor-fold>
  public /*explicit*/ formatted_raw_ostream() {
    // : raw_ostream(), TheStream(null), Position(0, 0) 
    //START JInit
    super();
    this.TheStream = null;
    this.Position = new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, 0, 0);
    //END JInit
    Scanned = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::~formatted_raw_ostream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 97,
   FQN="llvm::formatted_raw_ostream::~formatted_raw_ostream", NM="_ZN4llvm21formatted_raw_ostreamD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostreamD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    flush();
    releaseStream();
    super.$destroy();
  }

  
  /// PadToColumn - Align the output to some column number.  If the current
  /// column is already equal to or more than NewCol, PadToColumn inserts one
  /// space.
  ///
  /// \param NewCol - The column to move to.
  
  /// PadToColumn - Align the output to some column number.
  ///
  /// \param NewCol - The column to move to.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::PadToColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 67,
   FQN="llvm::formatted_raw_ostream::PadToColumn", NM="_ZN4llvm21formatted_raw_ostream11PadToColumnEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream11PadToColumnEj")
  //</editor-fold>
  public formatted_raw_ostream /*&*/ PadToColumn(/*uint*/int NewCol) {
    // Figure out what's in the buffer and add it to the column count.
    ComputePosition(getBufferStart(), GetNumBytesInBuffer());
    
    // Output spaces until we reach the desired column.
    indent(std.max(((int)(NewCol - getColumn())), 1));
    return /*Deref*/this;
  }

  
  /// getColumn - Return the column number
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::getColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 110,
   FQN="llvm::formatted_raw_ostream::getColumn", NM="_ZN4llvm21formatted_raw_ostream9getColumnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream9getColumnEv")
  //</editor-fold>
  public /*uint*/int getColumn() {
    return Position.first;
  }

  
  /// getLine - Return the line number
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 113,
   FQN="llvm::formatted_raw_ostream::getLine", NM="_ZN4llvm21formatted_raw_ostream7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() {
    return Position.second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::resetColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 115,
   FQN="llvm::formatted_raw_ostream::resetColor", NM="_ZN4llvm21formatted_raw_ostream10resetColorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream10resetColorEv")
  //</editor-fold>
  @Override public raw_ostream /*&*/ resetColor()/* override*/ {
    TheStream.resetColor();
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::reverseColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 120,
   FQN="llvm::formatted_raw_ostream::reverseColor", NM="_ZN4llvm21formatted_raw_ostream12reverseColorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream12reverseColorEv")
  //</editor-fold>
  @Override public raw_ostream /*&*/ reverseColor()/* override*/ {
    TheStream.reverseColor();
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::changeColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 125,
   FQN="llvm::formatted_raw_ostream::changeColor", NM="_ZN4llvm21formatted_raw_ostream11changeColorENS_11raw_ostream6ColorsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream11changeColorENS_11raw_ostream6ColorsEbb")
  //</editor-fold>
  @Override public raw_ostream /*&*/ changeColor( Colors Color, boolean Bold, boolean BG)/* override*/ {
    TheStream.changeColor(Color, Bold, BG);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::is_displayed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 130,
   FQN="llvm::formatted_raw_ostream::is_displayed", NM="_ZNK4llvm21formatted_raw_ostream12is_displayedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZNK4llvm21formatted_raw_ostream12is_displayedEv")
  //</editor-fold>
  @Override public boolean is_displayed() /*const*//* override*/ {
    return TheStream.is_displayed();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::formatted_raw_ostream::releaseStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/FormattedStream.h", line = 135,
   FQN="llvm::formatted_raw_ostream::releaseStream", NM="_ZN4llvm21formatted_raw_ostream13releaseStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm21formatted_raw_ostream13releaseStreamEv")
  //</editor-fold>
  private void releaseStream() {
    // Transfer the buffer settings from this raw_ostream back to the underlying
    // stream.
    if (!(TheStream != null)) {
      return;
    }
    {
      /*size_t*/int BufferSize = GetBufferSize();
      if ((BufferSize != 0)) {
        TheStream.SetBufferSize(BufferSize);
      } else {
        TheStream.SetUnbuffered();
      }
    }
  }

  
  @Override public String toString() {
    return "" + "TheStream=" + TheStream // NOI18N
              + ", Position=" + Position // NOI18N
              + ", Scanned=" + Scanned // NOI18N
              + super.toString(); // NOI18N
  }
}
