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

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 19,
 FQN="llvm::codeview::StreamRef", NM="_ZN4llvm8codeview9StreamRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9StreamRefE")
//</editor-fold>
public class StreamRef implements Native.NativeComparable<StreamRef> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::StreamRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 21,
   FQN="llvm::codeview::StreamRef::StreamRef", NM="_ZN4llvm8codeview9StreamRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9StreamRefC1Ev")
  //</editor-fold>
  public StreamRef() {
    // : Stream(null), ViewOffset(0), Length(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::StreamRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 22,
   FQN="llvm::codeview::StreamRef::StreamRef", NM="_ZN4llvm8codeview9StreamRefC1ERKNS0_15StreamInterfaceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9StreamRefC1ERKNS0_15StreamInterfaceE")
  //</editor-fold>
  public StreamRef(final /*const*/ StreamInterface /*&*/ Stream) {
    // : Stream(&Stream), ViewOffset(0), Length(Stream.getLength()) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::StreamRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 24,
   FQN="llvm::codeview::StreamRef::StreamRef", NM="_ZN4llvm8codeview9StreamRefC1ERKNS0_15StreamInterfaceEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9StreamRefC1ERKNS0_15StreamInterfaceEjj")
  //</editor-fold>
  public StreamRef(final /*const*/ StreamInterface /*&*/ Stream, /*uint32_t*/int Offset, /*uint32_t*/int Length) {
    // : Stream(&Stream), ViewOffset(Offset), Length(Length) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Use StreamRef.slice() instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::StreamRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 28,
   FQN="llvm::codeview::StreamRef::StreamRef", NM="_ZN4llvm8codeview9StreamRefC1ERKS1_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9StreamRefC1ERKS1_jj")
  //</editor-fold>
  public StreamRef(final /*const*/ StreamRef /*&*/ S, /*uint32_t*/int Offset, /*uint32_t*/int Length) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::readBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 30,
   FQN="llvm::codeview::StreamRef::readBytes", NM="_ZNK4llvm8codeview9StreamRef9readBytesEjjRNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRef9readBytesEjjRNS_8ArrayRefIhEE")
  //</editor-fold>
  public Error readBytes(/*uint32_t*/int Offset, /*uint32_t*/int Size, 
           final ArrayRefUChar/*&*/ Buffer) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Given an offset into the stream, read as much as possible without copying
  // any data.
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::readLongestContiguousChunk">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 41,
   FQN="llvm::codeview::StreamRef::readLongestContiguousChunk", NM="_ZNK4llvm8codeview9StreamRef26readLongestContiguousChunkEjRNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRef26readLongestContiguousChunkEjRNS_8ArrayRefIhEE")
  //</editor-fold>
  public Error readLongestContiguousChunk(/*uint32_t*/int Offset, 
                            final ArrayRefUChar/*&*/ Buffer) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::writeBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 57,
   FQN="llvm::codeview::StreamRef::writeBytes", NM="_ZNK4llvm8codeview9StreamRef10writeBytesEjNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRef10writeBytesEjNS_8ArrayRefIhEE")
  //</editor-fold>
  public Error writeBytes(/*uint32_t*/int Offset, ArrayRefUChar Data) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::getLength">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 63,
   FQN="llvm::codeview::StreamRef::getLength", NM="_ZNK4llvm8codeview9StreamRef9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRef9getLengthEv")
  //</editor-fold>
  public /*uint32_t*/int getLength() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::commit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 65,
   FQN="llvm::codeview::StreamRef::commit", NM="_ZNK4llvm8codeview9StreamRef6commitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRef6commitEv")
  //</editor-fold>
  public Error commit() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::drop_front">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 67,
   FQN="llvm::codeview::StreamRef::drop_front", NM="_ZNK4llvm8codeview9StreamRef10drop_frontEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRef10drop_frontEj")
  //</editor-fold>
  public StreamRef drop_front(/*uint32_t*/int N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::keep_front">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 75,
   FQN="llvm::codeview::StreamRef::keep_front", NM="_ZNK4llvm8codeview9StreamRef10keep_frontEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRef10keep_frontEj")
  //</editor-fold>
  public StreamRef keep_front(/*uint32_t*/int N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::slice">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 82,
   FQN="llvm::codeview::StreamRef::slice", NM="_ZNK4llvm8codeview9StreamRef5sliceEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRef5sliceEjj")
  //</editor-fold>
  public StreamRef slice(/*uint32_t*/int Offset, /*uint32_t*/int Len) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 86,
   FQN="llvm::codeview::StreamRef::operator==", NM="_ZNK4llvm8codeview9StreamRefeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9StreamRefeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ StreamRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private /*const*/ StreamInterface /*P*/ Stream;
  private /*uint32_t*/int ViewOffset;
  private /*uint32_t*/int Length;
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::StreamRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 19,
   FQN="llvm::codeview::StreamRef::StreamRef", NM="_ZN4llvm8codeview9StreamRefC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9StreamRefC1ERKS1_")
  //</editor-fold>
  public /*inline*/ StreamRef(final /*const*/ StreamRef /*&*/ $Prm0) {
    // : Stream(.Stream), ViewOffset(.ViewOffset), Length(.Length) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamRef::StreamRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamRef.h", line = 19,
   FQN="llvm::codeview::StreamRef::StreamRef", NM="_ZN4llvm8codeview9StreamRefC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9StreamRefC1EOS1_")
  //</editor-fold>
  public /*inline*/ StreamRef(JD$Move _dparam, final StreamRef /*&&*/$Prm0) {
    // : Stream(static_cast<StreamRef &&>().Stream), ViewOffset(static_cast<StreamRef &&>().ViewOffset), Length(static_cast<StreamRef &&>().Length) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Stream=" + Stream // NOI18N
              + ", ViewOffset=" + ViewOffset // NOI18N
              + ", Length=" + Length; // NOI18N
  }
}
