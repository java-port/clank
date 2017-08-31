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

package org.llvm.mc;

import org.clank.support.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DebugCompressionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 56,
 FQN="llvm::DebugCompressionType", NM="_ZN4llvm20DebugCompressionTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm20DebugCompressionTypeE")
//</editor-fold>
public enum /*class */DebugCompressionType/* : int*/ implements Native.ComparableLower {
  DCT_None(0), // no compression
  DCT_Zlib(DCT_None.getValue() + 1), // zlib style complession
  DCT_ZlibGnu(DCT_Zlib.getValue() + 1); // zlib-gnu style compression

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static DebugCompressionType valueOf(int val) {
    DebugCompressionType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final DebugCompressionType[] VALUES;
    private static final DebugCompressionType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (DebugCompressionType kind : DebugCompressionType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new DebugCompressionType[min < 0 ? (1-min) : 0];
      VALUES = new DebugCompressionType[max >= 0 ? (1+max) : 0];
      for (DebugCompressionType kind : DebugCompressionType.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private DebugCompressionType(int val) { this.value = (int)val;}
  public int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((DebugCompressionType)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((DebugCompressionType)obj).value);}
  //</editor-fold>
}
