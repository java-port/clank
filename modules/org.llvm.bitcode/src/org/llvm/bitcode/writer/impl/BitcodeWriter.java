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

package org.llvm.bitcode.writer.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.bitcode.*;


/// Abstract class to manage the bitcode writing, subclassed for each bitcode
/// file type. Owns the BitstreamWriter, and includes the main entry point for
/// writing.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeWriter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 70,
 FQN="(anonymous namespace)::BitcodeWriter", NM="_ZN12_GLOBAL__N_113BitcodeWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_113BitcodeWriterE")
//</editor-fold>
public abstract class BitcodeWriter implements Destructors.ClassWithDestructor {
/*protected:*/
  /// Pointer to the buffer allocated by caller for bitcode writing.
  protected /*const*/SmallString/*&*/ Buffer;
  
  /// The stream created and owned by the BitodeWriter.
  protected BitstreamWriter Stream;
  
  /// Saves the offset of the VSTOffset record that must eventually be
  /// backpatched with the offset of the actual VST.
  protected long/*uint64_t*/ VSTOffsetPlaceholder/* = 0*/;
/*public:*/
  /// Constructs a BitcodeWriter object, and initializes a BitstreamRecord,
  /// writing to the provided \p Buffer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeWriter::BitcodeWriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 85,
   FQN="(anonymous namespace)::BitcodeWriter::BitcodeWriter", NM="_ZN12_GLOBAL__N_113BitcodeWriterC1ERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_113BitcodeWriterC1ERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  public BitcodeWriter(SmallString/*&*/ Buffer) {
    // : Buffer(Buffer), Stream(Buffer), VSTOffsetPlaceholder(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeWriter::~BitcodeWriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 88,
   FQN="(anonymous namespace)::BitcodeWriter::~BitcodeWriter", NM="_ZN12_GLOBAL__N_113BitcodeWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_113BitcodeWriterD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Main entry point to write the bitcode file, which writes the bitcode
  /// header and will then invoke the virtual writeBlocks() method.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeWriter::write">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3626,
   FQN="(anonymous namespace)::BitcodeWriter::write", NM="_ZN12_GLOBAL__N_113BitcodeWriter5writeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_113BitcodeWriter5writeEv")
  //</editor-fold>
  public void write() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Derived classes must implement this to write the corresponding blocks for
  /// that bitcode file type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeWriter::writeBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 97,
   FQN="(anonymous namespace)::BitcodeWriter::writeBlocks", NM="_ZN12_GLOBAL__N_113BitcodeWriter11writeBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_113BitcodeWriter11writeBlocksEv")
  //</editor-fold>
  protected/*private*/ abstract /*virtual*/ void writeBlocks()/* = 0*/;

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeWriter::hasVSTOffsetPlaceholder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 100,
   FQN="(anonymous namespace)::BitcodeWriter::hasVSTOffsetPlaceholder", NM="_ZN12_GLOBAL__N_113BitcodeWriter23hasVSTOffsetPlaceholderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_113BitcodeWriter23hasVSTOffsetPlaceholderEv")
  //</editor-fold>
  protected boolean hasVSTOffsetPlaceholder() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Write a record that will eventually hold the word offset of the
  /// module-level VST. For now the offset is 0, which will be backpatched
  /// after the real VST is written. Saves the bit offset to backpatch.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeWriter::writeValueSymbolTableForwardDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1071,
   FQN="(anonymous namespace)::BitcodeWriter::writeValueSymbolTableForwardDecl", NM="_ZN12_GLOBAL__N_113BitcodeWriter32writeValueSymbolTableForwardDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_113BitcodeWriter32writeValueSymbolTableForwardDeclEv")
  //</editor-fold>
  protected void writeValueSymbolTableForwardDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Helper to write the header common to all bitcode files.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeWriter::writeBitcodeHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3772,
   FQN="(anonymous namespace)::BitcodeWriter::writeBitcodeHeader", NM="_ZN12_GLOBAL__N_113BitcodeWriter18writeBitcodeHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_113BitcodeWriter18writeBitcodeHeaderEv")
  //</editor-fold>
  protected void writeBitcodeHeader() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Buffer=" + Buffer // NOI18N
              + ", Stream=" + Stream // NOI18N
              + ", VSTOffsetPlaceholder=" + VSTOffsetPlaceholder; // NOI18N
  }
}
