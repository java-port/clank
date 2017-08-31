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

/*template <typename ValueType, typename Extractor = VarStreamArrayExtractor<ValueType>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 75,
 FQN="llvm::codeview::VarStreamArray", NM="_ZN4llvm8codeview14VarStreamArrayE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview14VarStreamArrayE")
//</editor-fold>
public class VarStreamArray</*typename*/ ValueType, /*typename*/ Extractor/* = VarStreamArrayExtractor<ValueType>*/>  {
  /*friend  class VarStreamArrayIterator<ValueType, Extractor>*/
/*public:*/
  // JAVA: typedef VarStreamArrayIterator<ValueType, Extractor> Iterator
//  public final class Iterator extends VarStreamArrayIterator<ValueType, Extractor>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 83,
   FQN="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>", NM="_ZN4llvm8codeview14VarStreamArrayC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview14VarStreamArrayC1Ev")
  //</editor-fold>
  public VarStreamArray() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 84,
   FQN="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>", NM="_ZN4llvm8codeview14VarStreamArrayC1ERKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview14VarStreamArrayC1ERKT0_")
  //</editor-fold>
  public /*explicit*/ VarStreamArray(final /*const*/ Extractor /*&*/ E) {
    // : E(E) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 86,
   FQN="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>", NM="_ZN4llvm8codeview14VarStreamArrayC1ENS0_9StreamRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview14VarStreamArrayC1ENS0_9StreamRefE")
  //</editor-fold>
  public /*explicit*/ VarStreamArray(StreamRef Stream) {
    // : Stream(Stream) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 87,
   FQN="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>", NM="_ZN4llvm8codeview14VarStreamArrayC1ENS0_9StreamRefERKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview14VarStreamArrayC1ENS0_9StreamRefERKT0_")
  //</editor-fold>
  public VarStreamArray(StreamRef Stream, final /*const*/ Extractor /*&*/ E) {
    // : Stream(Stream), E(E) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 89,
   FQN="llvm::codeview::VarStreamArray::VarStreamArray<ValueType, Extractor>", NM="_ZN4llvm8codeview14VarStreamArrayC1ERKNS0_14VarStreamArrayIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview14VarStreamArrayC1ERKNS0_14VarStreamArrayIT_T0_EE")
  //</editor-fold>
  public VarStreamArray(final /*const*/ VarStreamArray<ValueType, Extractor> /*&*/ Other) {
    // : Stream(Other.Stream), E(Other.E) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 92,
   FQN="llvm::codeview::VarStreamArray::begin", NM="_ZNK4llvm8codeview14VarStreamArray5beginEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview14VarStreamArray5beginEPb")
  //</editor-fold>
  public VarStreamArrayIterator<ValueType, Extractor> begin() /*const*/ {
    return begin((bool$ptr/*bool P*/ )null);
  }
  public VarStreamArrayIterator<ValueType, Extractor> begin(bool$ptr/*bool P*/ HadError/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 96,
   FQN="llvm::codeview::VarStreamArray::end", NM="_ZNK4llvm8codeview14VarStreamArray3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview14VarStreamArray3endEv")
  //</editor-fold>
  public VarStreamArrayIterator<ValueType, Extractor> end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::getExtractor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 98,
   FQN="llvm::codeview::VarStreamArray::getExtractor", NM="_ZNK4llvm8codeview14VarStreamArray12getExtractorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview14VarStreamArray12getExtractorEv")
  //</editor-fold>
  public /*const*/ Extractor /*&*/ getExtractor() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArray::getUnderlyingStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 100,
   FQN="llvm::codeview::VarStreamArray::getUnderlyingStream", NM="_ZNK4llvm8codeview14VarStreamArray19getUnderlyingStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview14VarStreamArray19getUnderlyingStreamEv")
  //</editor-fold>
  public StreamRef getUnderlyingStream() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private StreamRef Stream;
  private Extractor E;
  
  @Override public String toString() {
    return "" + "Stream=" + Stream // NOI18N
              + ", E=" + E; // NOI18N
  }
}
