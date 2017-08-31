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

package org.llvm.debuginfo.codeview;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 27,
 FQN="llvm::codeview::StreamReader", NM="_ZN4llvm8codeview12StreamReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReaderE")
//</editor-fold>
public class StreamReader {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::StreamReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 29,
   FQN="llvm::codeview::StreamReader::StreamReader", NM="_ZN4llvm8codeview12StreamReaderC1ENS0_9StreamRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReaderC1ENS0_9StreamRefE")
  //</editor-fold>
  public StreamReader(StreamRef Stream) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readLongestContiguousChunk">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 31,
   FQN="llvm::codeview::StreamReader::readLongestContiguousChunk", NM="_ZN4llvm8codeview12StreamReader26readLongestContiguousChunkERNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader26readLongestContiguousChunkERNS_8ArrayRefIhEE")
  //</editor-fold>
  public Error readLongestContiguousChunk(final ArrayRefUChar/*&*/ Buffer) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 32,
   FQN="llvm::codeview::StreamReader::readBytes", NM="_ZN4llvm8codeview12StreamReader9readBytesERNS_8ArrayRefIhEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader9readBytesERNS_8ArrayRefIhEEj")
  //</editor-fold>
  public Error readBytes(final ArrayRefUChar/*&*/ Buffer, /*uint32_t*/int Size) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readInteger">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 33,
   FQN="llvm::codeview::StreamReader::readInteger", NM="_ZN4llvm8codeview12StreamReader11readIntegerERt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader11readIntegerERt")
  //</editor-fold>
  public Error readInteger_char(final /*uint16_t*/char/*&*/ Dest) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readInteger">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 34,
   FQN="llvm::codeview::StreamReader::readInteger", NM="_ZN4llvm8codeview12StreamReader11readIntegerERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader11readIntegerERj")
  //</editor-fold>
  public Error readInteger_uint$ref(final /*uint32_t &*/uint$ref Dest) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readZeroString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 35,
   FQN="llvm::codeview::StreamReader::readZeroString", NM="_ZN4llvm8codeview12StreamReader14readZeroStringERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader14readZeroStringERNS_9StringRefE")
  //</editor-fold>
  public Error readZeroString(final StringRef /*&*/ Dest) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readFixedString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 36,
   FQN="llvm::codeview::StreamReader::readFixedString", NM="_ZN4llvm8codeview12StreamReader15readFixedStringERNS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader15readFixedStringERNS_9StringRefEj")
  //</editor-fold>
  public Error readFixedString(final StringRef /*&*/ Dest, /*uint32_t*/int Length) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readStreamRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 37,
   FQN="llvm::codeview::StreamReader::readStreamRef", NM="_ZN4llvm8codeview12StreamReader13readStreamRefERNS0_9StreamRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader13readStreamRefERNS0_9StreamRefE")
  //</editor-fold>
  public Error readStreamRef(final StreamRef /*&*/ Ref) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readStreamRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 38,
   FQN="llvm::codeview::StreamReader::readStreamRef", NM="_ZN4llvm8codeview12StreamReader13readStreamRefERNS0_9StreamRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader13readStreamRefERNS0_9StreamRefEj")
  //</editor-fold>
  public Error readStreamRef(final StreamRef /*&*/ Ref, /*uint32_t*/int Length) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readEnum">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 40,
   FQN="llvm::codeview::StreamReader::readEnum", NM="Tpl__ZN4llvm8codeview12StreamReader8readEnumERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview12StreamReader8readEnumERT_")
  //</editor-fold>
  public </*typename*/ T> Error readEnum(final T /*&*/ Dest) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 48,
   FQN="llvm::codeview::StreamReader::readObject", NM="Tpl__ZN4llvm8codeview12StreamReader10readObjectERPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview12StreamReader10readObjectERPKT_")
  //</editor-fold>
  public </*typename*/ T> Error readObject(final /*const*/ T /*P*/ /*&*/ Dest) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readArray">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 57,
   FQN="llvm::codeview::StreamReader::readArray", NM="Tpl__ZN4llvm8codeview12StreamReader9readArrayERNS_8ArrayRefIT_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview12StreamReader9readArrayERNS_8ArrayRefIT_EEj")
  //</editor-fold>
  public </*typename*/ T> Error readArray(final ArrayRef<T> /*&*/ Array, /*uint32_t*/int NumElements) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T, typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readArray">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 74,
   FQN="llvm::codeview::StreamReader::readArray", NM="Tpl__ZN4llvm8codeview12StreamReader9readArrayERNS0_14VarStreamArrayIT_T0_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview12StreamReader9readArrayERNS0_14VarStreamArrayIT_T0_EEj")
  //</editor-fold>
  public </*typename*/ T, /*typename*/ U> Error readArray(final VarStreamArray<T, U> /*&*/ Array, /*uint32_t*/int Size) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::readArray">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 83,
   FQN="llvm::codeview::StreamReader::readArray", NM="Tpl__ZN4llvm8codeview12StreamReader9readArrayERNS0_16FixedStreamArrayIT_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview12StreamReader9readArrayERNS0_16FixedStreamArrayIT_EEj")
  //</editor-fold>
  public </*typename*/ T> Error readArray(final FixedStreamArray<T> /*&*/ Array, /*uint32_t*/int NumItems) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::setOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 99,
   FQN="llvm::codeview::StreamReader::setOffset", NM="_ZN4llvm8codeview12StreamReader9setOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12StreamReader9setOffsetEj")
  //</editor-fold>
  public void setOffset(/*uint32_t*/int Off) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::getOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 100,
   FQN="llvm::codeview::StreamReader::getOffset", NM="_ZNK4llvm8codeview12StreamReader9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview12StreamReader9getOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::getLength">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 101,
   FQN="llvm::codeview::StreamReader::getLength", NM="_ZNK4llvm8codeview12StreamReader9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview12StreamReader9getLengthEv")
  //</editor-fold>
  public /*uint32_t*/int getLength() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamReader::bytesRemaining">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamReader.h", line = 102,
   FQN="llvm::codeview::StreamReader::bytesRemaining", NM="_ZNK4llvm8codeview12StreamReader14bytesRemainingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview12StreamReader14bytesRemainingEv")
  //</editor-fold>
  public /*uint32_t*/int bytesRemaining() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private StreamRef Stream;
  private /*uint32_t*/int Offset;
  
  @Override public String toString() {
    return "" + "Stream=" + Stream // NOI18N
              + ", Offset=" + Offset; // NOI18N
  }
}
