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

package org.llvm.support.endian;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.support.llvm.support.endianness;

/*template <endianness endian> TEMPLATE*/
/// Adapter to write values to a stream in a particular byte order.
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::Writer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/EndianStream.h", line = 26,
 FQN = "llvm::support::endian::Writer", NM = "_ZN4llvm7support6endian6WriterE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN4llvm7support6endian6WriterE")
//</editor-fold>
public class/*struct*/ Writer  {
  public final raw_ostream /*&*/ OS;
  public final endianness /*&*/ endian;
  //<editor-fold defaultstate="collapsed" desc="llvm::support::endian::Writer::Writer<endian>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/EndianStream.h", line = 28,
   FQN = "llvm::support::endian::Writer::Writer<endian>", NM = "_ZN4llvm7support6endian6WriterC1ERNS_11raw_ostreamE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN4llvm7support6endian6WriterC1ERNS_11raw_ostreamE")
  //</editor-fold>
  public Writer(endianness endian, raw_ostream /*&*/ OS) {
    /* : OS(OS)*/ 
    //START JInit
    this.OS = OS;
    //END JInit
     assert endian == endianness.little : "only little is supported " + endian;
    this.endian = endian;
  }

  /*template <typename value_type> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::support::endian::Writer::write">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/EndianStream.h", line = 29,
   FQN = "llvm::support::endian::Writer::write", NM = "Tpl__ZN4llvm7support6endian6Writer5writeET_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=Tpl__ZN4llvm7support6endian6Writer5writeET_")
  //</editor-fold>
  public </*typename*/ value_type> void write(value_type Val) {
    throw new UnsupportedOperationException("use specialization " + Val.getClass());
  }
  public void write_uint8(int Val) {
    assert Val <= 0xFF : "bigger that one byte " + Val;
    // 1 byte
    OS.$out_uchar((byte)Val);
  }
  public void write_uint16(int Val) {
    assert Val <= 0xFFFF : "bigger that two bytes " + Val;
    // 2 bytes
    OS.$out_uchar((byte)Val);
    OS.$out_uchar((byte)(Val>>>8));
  }
  public void write_uint16(char Val) {
    // 2 bytes
    OS.$out_uchar((byte)Val);
    OS.$out_uchar((byte)(Val>>>8));
  }
  public void write_uint32(/*uint*/int Val) {
    // 4 bytes
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
  }
  public void write_uint64(/*uint64*/long Val) {
    // 8 bytes
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
    Val = Val >>> 8;
    OS.$out_uchar((byte)Val);
  }
  
  public String toString() {
    return "" + "OS=" + OS; // NOI18N
  }
}
