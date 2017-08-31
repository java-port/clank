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


/// StreamInterface abstracts the notion of a data stream.  This way, an
/// implementation could implement trivial reading from a contiguous memory
/// buffer or, as in the case of PDB files, reading from a set of possibly
/// discontiguous blocks.  The implementation is required to return references
/// to stable memory, so if this is not possible (for example in the case of
/// a PDB file with discontiguous blocks, it must keep its own pool of temp
/// storage.
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamInterface">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamInterface.h", line = 27,
 FQN="llvm::codeview::StreamInterface", NM="_ZN4llvm8codeview15StreamInterfaceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview15StreamInterfaceE")
//</editor-fold>
public abstract class StreamInterface implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamInterface::~StreamInterface">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamInterface.h", line = 29,
   FQN="llvm::codeview::StreamInterface::~StreamInterface", NM="_ZN4llvm8codeview15StreamInterfaceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview15StreamInterfaceD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Given an offset into the stream and a number of bytes, attempt to read
  // the bytes and set the output ArrayRef to point to a reference into the
  // stream, without copying any data.
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamInterface::readBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamInterface.h", line = 34,
   FQN="llvm::codeview::StreamInterface::readBytes", NM="_ZNK4llvm8codeview15StreamInterface9readBytesEjjRNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview15StreamInterface9readBytesEjjRNS_8ArrayRefIhEE")
  //</editor-fold>
  public abstract /*virtual*/ Error readBytes(/*uint32_t*/int Offset, /*uint32_t*/int Size, 
           final ArrayRefUChar/*&*/ Buffer) /*const*//* = 0*/;

  
  // Given an offset into the stream, read as much as possible without copying
  // any data.
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamInterface::readLongestContiguousChunk">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamInterface.h", line = 39,
   FQN="llvm::codeview::StreamInterface::readLongestContiguousChunk", NM="_ZNK4llvm8codeview15StreamInterface26readLongestContiguousChunkEjRNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview15StreamInterface26readLongestContiguousChunkEjRNS_8ArrayRefIhEE")
  //</editor-fold>
  public abstract /*virtual*/ Error readLongestContiguousChunk(/*uint32_t*/int Offset, 
                            final ArrayRefUChar/*&*/ Buffer) /*const*//* = 0*/;

  
  // Attempt to write the given bytes into the stream at the desired offset.
  // This will always necessitate a copy.  Cannot shrink or grow the stream,
  // only writes into existing allocated space.
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamInterface::writeBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamInterface.h", line = 45,
   FQN="llvm::codeview::StreamInterface::writeBytes", NM="_ZNK4llvm8codeview15StreamInterface10writeBytesEjNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview15StreamInterface10writeBytesEjNS_8ArrayRefIhEE")
  //</editor-fold>
  public abstract /*virtual*/ Error writeBytes(/*uint32_t*/int Offset, ArrayRefUChar Data) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamInterface::getLength">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamInterface.h", line = 47,
   FQN="llvm::codeview::StreamInterface::getLength", NM="_ZNK4llvm8codeview15StreamInterface9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview15StreamInterface9getLengthEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint32_t*/int getLength() /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::StreamInterface::commit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamInterface.h", line = 49,
   FQN="llvm::codeview::StreamInterface::commit", NM="_ZNK4llvm8codeview15StreamInterface6commitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview15StreamInterface6commitEv")
  //</editor-fold>
  public abstract /*virtual*/ Error commit() /*const*//* = 0*/;

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
