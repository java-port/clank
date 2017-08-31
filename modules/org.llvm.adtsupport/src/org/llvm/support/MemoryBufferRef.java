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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 148,
 FQN="llvm::MemoryBufferRef", NM="_ZN4llvm15MemoryBufferRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm15MemoryBufferRefE")
//</editor-fold>
public class MemoryBufferRef {
  private StringRef Buffer;
  private StringRef Identifier;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::MemoryBufferRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 153,
   FQN="llvm::MemoryBufferRef::MemoryBufferRef", NM="_ZN4llvm15MemoryBufferRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm15MemoryBufferRefC1Ev")
  //</editor-fold>
  public MemoryBufferRef() {
    // : Buffer(), Identifier() 
    //START JInit
    this.Buffer = new StringRef();
    this.Identifier = new StringRef();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::MemoryBufferRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 154,
   FQN="llvm::MemoryBufferRef::MemoryBufferRef", NM="_ZN4llvm15MemoryBufferRefC1ERNS_12MemoryBufferE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm15MemoryBufferRefC1ERNS_12MemoryBufferE")
  //</editor-fold>
  public MemoryBufferRef(final MemoryBuffer /*&*/ Buffer) {
    // : Buffer(Buffer.getBuffer()), Identifier(Buffer.getBufferIdentifier()) 
    //START JInit
    this.Buffer = Buffer.getBuffer();
    this.Identifier = new StringRef(Buffer.getBufferIdentifier());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::MemoryBufferRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 156,
   FQN="llvm::MemoryBufferRef::MemoryBufferRef", NM="_ZN4llvm15MemoryBufferRefC1ENS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm15MemoryBufferRefC1ENS_9StringRefES1_")
  //</editor-fold>
  public MemoryBufferRef(StringRef Buffer, StringRef Identifier) {
    // : Buffer(Buffer), Identifier(Identifier) 
    //START JInit
    this.Buffer = new StringRef(Buffer);
    this.Identifier = new StringRef(Identifier);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::getBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 159,
   FQN="llvm::MemoryBufferRef::getBuffer", NM="_ZNK4llvm15MemoryBufferRef9getBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm15MemoryBufferRef9getBufferEv")
  //</editor-fold>
  public StringRef getBuffer() /*const*/ {
    return new StringRef(Buffer);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::getBufferIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 161,
   FQN="llvm::MemoryBufferRef::getBufferIdentifier", NM="_ZNK4llvm15MemoryBufferRef19getBufferIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm15MemoryBufferRef19getBufferIdentifierEv")
  //</editor-fold>
  public StringRef getBufferIdentifier() /*const*/ {
    return new StringRef(Identifier);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::getBufferStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 163,
   FQN="llvm::MemoryBufferRef::getBufferStart", NM="_ZNK4llvm15MemoryBufferRef14getBufferStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm15MemoryBufferRef14getBufferStartEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBufferStart() /*const*/ {
    return Buffer.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::getBufferEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 164,
   FQN="llvm::MemoryBufferRef::getBufferEnd", NM="_ZNK4llvm15MemoryBufferRef12getBufferEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm15MemoryBufferRef12getBufferEndEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBufferEnd() /*const*/ {
    return Buffer.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::getBufferSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 165,
   FQN="llvm::MemoryBufferRef::getBufferSize", NM="_ZNK4llvm15MemoryBufferRef13getBufferSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm15MemoryBufferRef13getBufferSizeEv")
  //</editor-fold>
  public /*size_t*/int getBufferSize() /*const*/ {
    return Buffer.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::MemoryBufferRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 148,
   FQN="llvm::MemoryBufferRef::MemoryBufferRef", NM="_ZN4llvm15MemoryBufferRefC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm15MemoryBufferRefC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MemoryBufferRef(final /*const*/ MemoryBufferRef /*&*/ $Prm0) {
    // : Buffer(.Buffer), Identifier(.Identifier) 
    //START JInit
    this.Buffer = new StringRef($Prm0.Buffer);
    this.Identifier = new StringRef($Prm0.Identifier);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::MemoryBufferRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 148,
   FQN="llvm::MemoryBufferRef::MemoryBufferRef", NM="_ZN4llvm15MemoryBufferRefC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm15MemoryBufferRefC1EOS0_")
  //</editor-fold>
  public /*inline*/ MemoryBufferRef(JD$Move _dparam, final MemoryBufferRef /*&&*/$Prm0) {
    // : Buffer(static_cast<MemoryBufferRef &&>().Buffer), Identifier(static_cast<MemoryBufferRef &&>().Identifier) 
    //START JInit
    this.Buffer = new StringRef(JD$Move.INSTANCE, $Prm0.Buffer);
    this.Identifier = new StringRef(JD$Move.INSTANCE, $Prm0.Identifier);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryBufferRef::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 148,
   FQN="llvm::MemoryBufferRef::operator=", NM="_ZN4llvm15MemoryBufferRefaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm15MemoryBufferRefaSERKS0_")
  //</editor-fold>
  public /*inline*/ MemoryBufferRef /*&*/ $assign(final /*const*/ MemoryBufferRef /*&*/ $Prm0) {
    this.Buffer.$assign($Prm0.Buffer);
    this.Identifier.$assign($Prm0.Identifier);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Buffer=" + Buffer // NOI18N
              + ", Identifier=" + Identifier; // NOI18N
  }
}
