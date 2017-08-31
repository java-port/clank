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

package org.llvm.support.sys;

import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Casts.*;
import org.clank.support.Converted;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.uint$ptr;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.ArrayRef;
import static org.llvm.support.ConvertUTFGlobals.*;

//JAVA: namespace unicode {

public final class unicode {

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::unicode::ColumnWidthErrors">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Unicode.h", line = 24,
   FQN = "llvm::sys::unicode::ColumnWidthErrors", NM = "_ZN4llvm3sys7unicode17ColumnWidthErrorsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sys7unicode17ColumnWidthErrorsE")
  //</editor-fold>
  public enum ColumnWidthErrors {
    ErrorInvalidUTF8(-2),
    ErrorNonPrintableCharacter(-1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ColumnWidthErrors valueOf(int val) {
      ColumnWidthErrors out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final ColumnWidthErrors[] VALUES;
      private static final ColumnWidthErrors[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ColumnWidthErrors kind : ColumnWidthErrors.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ColumnWidthErrors[min < 0 ? (1-min) : 0];
        VALUES = new ColumnWidthErrors[max >= 0 ? (1+max) : 0];
        for (ColumnWidthErrors kind : ColumnWidthErrors.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private ColumnWidthErrors(/*uint*/int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  }

    // Sorted list of non-overlapping intervals of code points that are not
    // supposed to be printable.
    private static final /*const*/ UnicodeCharRange NonPrintableRanges[/*548*/] = new /*const*/ UnicodeCharRange [/*548*/] {
      new UnicodeCharRange(0x0000, 0x001F), new UnicodeCharRange(0x007F, 0x009F), new UnicodeCharRange(0x034F, 0x034F), 
      new UnicodeCharRange(0x0378, 0x0379), new UnicodeCharRange(0x037F, 0x0383), new UnicodeCharRange(0x038B, 0x038B), 
      new UnicodeCharRange(0x038D, 0x038D), new UnicodeCharRange(0x03A2, 0x03A2), new UnicodeCharRange(0x0528, 0x0530), 
      new UnicodeCharRange(0x0557, 0x0558), new UnicodeCharRange(0x0560, 0x0560), new UnicodeCharRange(0x0588, 0x0588), 
      new UnicodeCharRange(0x058B, 0x058E), new UnicodeCharRange(0x0590, 0x0590), new UnicodeCharRange(0x05C8, 0x05CF), 
      new UnicodeCharRange(0x05EB, 0x05EF), new UnicodeCharRange(0x05F5, 0x0605), new UnicodeCharRange(0x061C, 0x061D), 
      new UnicodeCharRange(0x06DD, 0x06DD), new UnicodeCharRange(0x070E, 0x070F), new UnicodeCharRange(0x074B, 0x074C), 
      new UnicodeCharRange(0x07B2, 0x07BF), new UnicodeCharRange(0x07FB, 0x07FF), new UnicodeCharRange(0x082E, 0x082F), 
      new UnicodeCharRange(0x083F, 0x083F), new UnicodeCharRange(0x085C, 0x085D), new UnicodeCharRange(0x085F, 0x089F), 
      new UnicodeCharRange(0x08A1, 0x08A1), new UnicodeCharRange(0x08AD, 0x08E3), new UnicodeCharRange(0x08FF, 0x08FF), 
      new UnicodeCharRange(0x0978, 0x0978), new UnicodeCharRange(0x0980, 0x0980), new UnicodeCharRange(0x0984, 0x0984), 
      new UnicodeCharRange(0x098D, 0x098E), new UnicodeCharRange(0x0991, 0x0992), new UnicodeCharRange(0x09A9, 0x09A9), 
      new UnicodeCharRange(0x09B1, 0x09B1), new UnicodeCharRange(0x09B3, 0x09B5), new UnicodeCharRange(0x09BA, 0x09BB), 
      new UnicodeCharRange(0x09C5, 0x09C6), new UnicodeCharRange(0x09C9, 0x09CA), new UnicodeCharRange(0x09CF, 0x09D6), 
      new UnicodeCharRange(0x09D8, 0x09DB), new UnicodeCharRange(0x09DE, 0x09DE), new UnicodeCharRange(0x09E4, 0x09E5), 
      new UnicodeCharRange(0x09FC, 0x0A00), new UnicodeCharRange(0x0A04, 0x0A04), new UnicodeCharRange(0x0A0B, 0x0A0E), 
      new UnicodeCharRange(0x0A11, 0x0A12), new UnicodeCharRange(0x0A29, 0x0A29), new UnicodeCharRange(0x0A31, 0x0A31), 
      new UnicodeCharRange(0x0A34, 0x0A34), new UnicodeCharRange(0x0A37, 0x0A37), new UnicodeCharRange(0x0A3A, 0x0A3B), 
      new UnicodeCharRange(0x0A3D, 0x0A3D), new UnicodeCharRange(0x0A43, 0x0A46), new UnicodeCharRange(0x0A49, 0x0A4A), 
      new UnicodeCharRange(0x0A4E, 0x0A50), new UnicodeCharRange(0x0A52, 0x0A58), new UnicodeCharRange(0x0A5D, 0x0A5D), 
      new UnicodeCharRange(0x0A5F, 0x0A65), new UnicodeCharRange(0x0A76, 0x0A80), new UnicodeCharRange(0x0A84, 0x0A84), 
      new UnicodeCharRange(0x0A8E, 0x0A8E), new UnicodeCharRange(0x0A92, 0x0A92), new UnicodeCharRange(0x0AA9, 0x0AA9), 
      new UnicodeCharRange(0x0AB1, 0x0AB1), new UnicodeCharRange(0x0AB4, 0x0AB4), new UnicodeCharRange(0x0ABA, 0x0ABB), 
      new UnicodeCharRange(0x0AC6, 0x0AC6), new UnicodeCharRange(0x0ACA, 0x0ACA), new UnicodeCharRange(0x0ACE, 0x0ACF), 
      new UnicodeCharRange(0x0AD1, 0x0ADF), new UnicodeCharRange(0x0AE4, 0x0AE5), new UnicodeCharRange(0x0AF2, 0x0B00), 
      new UnicodeCharRange(0x0B04, 0x0B04), new UnicodeCharRange(0x0B0D, 0x0B0E), new UnicodeCharRange(0x0B11, 0x0B12), 
      new UnicodeCharRange(0x0B29, 0x0B29), new UnicodeCharRange(0x0B31, 0x0B31), new UnicodeCharRange(0x0B34, 0x0B34), 
      new UnicodeCharRange(0x0B3A, 0x0B3B), new UnicodeCharRange(0x0B45, 0x0B46), new UnicodeCharRange(0x0B49, 0x0B4A), 
      new UnicodeCharRange(0x0B4E, 0x0B55), new UnicodeCharRange(0x0B58, 0x0B5B), new UnicodeCharRange(0x0B5E, 0x0B5E), 
      new UnicodeCharRange(0x0B64, 0x0B65), new UnicodeCharRange(0x0B78, 0x0B81), new UnicodeCharRange(0x0B84, 0x0B84), 
      new UnicodeCharRange(0x0B8B, 0x0B8D), new UnicodeCharRange(0x0B91, 0x0B91), new UnicodeCharRange(0x0B96, 0x0B98), 
      new UnicodeCharRange(0x0B9B, 0x0B9B), new UnicodeCharRange(0x0B9D, 0x0B9D), new UnicodeCharRange(0x0BA0, 0x0BA2), 
      new UnicodeCharRange(0x0BA5, 0x0BA7), new UnicodeCharRange(0x0BAB, 0x0BAD), new UnicodeCharRange(0x0BBA, 0x0BBD), 
      new UnicodeCharRange(0x0BC3, 0x0BC5), new UnicodeCharRange(0x0BC9, 0x0BC9), new UnicodeCharRange(0x0BCE, 0x0BCF), 
      new UnicodeCharRange(0x0BD1, 0x0BD6), new UnicodeCharRange(0x0BD8, 0x0BE5), new UnicodeCharRange(0x0BFB, 0x0C00), 
      new UnicodeCharRange(0x0C04, 0x0C04), new UnicodeCharRange(0x0C0D, 0x0C0D), new UnicodeCharRange(0x0C11, 0x0C11), 
      new UnicodeCharRange(0x0C29, 0x0C29), new UnicodeCharRange(0x0C34, 0x0C34), new UnicodeCharRange(0x0C3A, 0x0C3C), 
      new UnicodeCharRange(0x0C45, 0x0C45), new UnicodeCharRange(0x0C49, 0x0C49), new UnicodeCharRange(0x0C4E, 0x0C54), 
      new UnicodeCharRange(0x0C57, 0x0C57), new UnicodeCharRange(0x0C5A, 0x0C5F), new UnicodeCharRange(0x0C64, 0x0C65), 
      new UnicodeCharRange(0x0C70, 0x0C77), new UnicodeCharRange(0x0C80, 0x0C81), new UnicodeCharRange(0x0C84, 0x0C84), 
      new UnicodeCharRange(0x0C8D, 0x0C8D), new UnicodeCharRange(0x0C91, 0x0C91), new UnicodeCharRange(0x0CA9, 0x0CA9), 
      new UnicodeCharRange(0x0CB4, 0x0CB4), new UnicodeCharRange(0x0CBA, 0x0CBB), new UnicodeCharRange(0x0CC5, 0x0CC5), 
      new UnicodeCharRange(0x0CC9, 0x0CC9), new UnicodeCharRange(0x0CCE, 0x0CD4), new UnicodeCharRange(0x0CD7, 0x0CDD), 
      new UnicodeCharRange(0x0CDF, 0x0CDF), new UnicodeCharRange(0x0CE4, 0x0CE5), new UnicodeCharRange(0x0CF0, 0x0CF0), 
      new UnicodeCharRange(0x0CF3, 0x0D01), new UnicodeCharRange(0x0D04, 0x0D04), new UnicodeCharRange(0x0D0D, 0x0D0D), 
      new UnicodeCharRange(0x0D11, 0x0D11), new UnicodeCharRange(0x0D3B, 0x0D3C), new UnicodeCharRange(0x0D45, 0x0D45), 
      new UnicodeCharRange(0x0D49, 0x0D49), new UnicodeCharRange(0x0D4F, 0x0D56), new UnicodeCharRange(0x0D58, 0x0D5F), 
      new UnicodeCharRange(0x0D64, 0x0D65), new UnicodeCharRange(0x0D76, 0x0D78), new UnicodeCharRange(0x0D80, 0x0D81), 
      new UnicodeCharRange(0x0D84, 0x0D84), new UnicodeCharRange(0x0D97, 0x0D99), new UnicodeCharRange(0x0DB2, 0x0DB2), 
      new UnicodeCharRange(0x0DBC, 0x0DBC), new UnicodeCharRange(0x0DBE, 0x0DBF), new UnicodeCharRange(0x0DC7, 0x0DC9), 
      new UnicodeCharRange(0x0DCB, 0x0DCE), new UnicodeCharRange(0x0DD5, 0x0DD5), new UnicodeCharRange(0x0DD7, 0x0DD7), 
      new UnicodeCharRange(0x0DE0, 0x0DF1), new UnicodeCharRange(0x0DF5, 0x0E00), new UnicodeCharRange(0x0E3B, 0x0E3E), 
      new UnicodeCharRange(0x0E5C, 0x0E80), new UnicodeCharRange(0x0E83, 0x0E83), new UnicodeCharRange(0x0E85, 0x0E86), 
      new UnicodeCharRange(0x0E89, 0x0E89), new UnicodeCharRange(0x0E8B, 0x0E8C), new UnicodeCharRange(0x0E8E, 0x0E93), 
      new UnicodeCharRange(0x0E98, 0x0E98), new UnicodeCharRange(0x0EA0, 0x0EA0), new UnicodeCharRange(0x0EA4, 0x0EA4), 
      new UnicodeCharRange(0x0EA6, 0x0EA6), new UnicodeCharRange(0x0EA8, 0x0EA9), new UnicodeCharRange(0x0EAC, 0x0EAC), 
      new UnicodeCharRange(0x0EBA, 0x0EBA), new UnicodeCharRange(0x0EBE, 0x0EBF), new UnicodeCharRange(0x0EC5, 0x0EC5), 
      new UnicodeCharRange(0x0EC7, 0x0EC7), new UnicodeCharRange(0x0ECE, 0x0ECF), new UnicodeCharRange(0x0EDA, 0x0EDB), 
      new UnicodeCharRange(0x0EE0, 0x0EFF), new UnicodeCharRange(0x0F48, 0x0F48), new UnicodeCharRange(0x0F6D, 0x0F70), 
      new UnicodeCharRange(0x0F98, 0x0F98), new UnicodeCharRange(0x0FBD, 0x0FBD), new UnicodeCharRange(0x0FCD, 0x0FCD), 
      new UnicodeCharRange(0x0FDB, 0x0FFF), new UnicodeCharRange(0x10C6, 0x10C6), new UnicodeCharRange(0x10C8, 0x10CC), 
      new UnicodeCharRange(0x10CE, 0x10CF), new UnicodeCharRange(0x115F, 0x1160), new UnicodeCharRange(0x1249, 0x1249), 
      new UnicodeCharRange(0x124E, 0x124F), new UnicodeCharRange(0x1257, 0x1257), new UnicodeCharRange(0x1259, 0x1259), 
      new UnicodeCharRange(0x125E, 0x125F), new UnicodeCharRange(0x1289, 0x1289), new UnicodeCharRange(0x128E, 0x128F), 
      new UnicodeCharRange(0x12B1, 0x12B1), new UnicodeCharRange(0x12B6, 0x12B7), new UnicodeCharRange(0x12BF, 0x12BF), 
      new UnicodeCharRange(0x12C1, 0x12C1), new UnicodeCharRange(0x12C6, 0x12C7), new UnicodeCharRange(0x12D7, 0x12D7), 
      new UnicodeCharRange(0x1311, 0x1311), new UnicodeCharRange(0x1316, 0x1317), new UnicodeCharRange(0x135B, 0x135C), 
      new UnicodeCharRange(0x137D, 0x137F), new UnicodeCharRange(0x139A, 0x139F), new UnicodeCharRange(0x13F5, 0x13FF), 
      new UnicodeCharRange(0x169D, 0x169F), new UnicodeCharRange(0x16F1, 0x16FF), new UnicodeCharRange(0x170D, 0x170D), 
      new UnicodeCharRange(0x1715, 0x171F), new UnicodeCharRange(0x1737, 0x173F), new UnicodeCharRange(0x1754, 0x175F), 
      new UnicodeCharRange(0x176D, 0x176D), new UnicodeCharRange(0x1771, 0x1771), new UnicodeCharRange(0x1774, 0x177F), 
      new UnicodeCharRange(0x17B4, 0x17B5), new UnicodeCharRange(0x17DE, 0x17DF), new UnicodeCharRange(0x17EA, 0x17EF), 
      new UnicodeCharRange(0x17FA, 0x17FF), new UnicodeCharRange(0x180B, 0x180D), new UnicodeCharRange(0x180F, 0x180F), 
      new UnicodeCharRange(0x181A, 0x181F), new UnicodeCharRange(0x1878, 0x187F), new UnicodeCharRange(0x18AB, 0x18AF), 
      new UnicodeCharRange(0x18F6, 0x18FF), new UnicodeCharRange(0x191D, 0x191F), new UnicodeCharRange(0x192C, 0x192F), 
      new UnicodeCharRange(0x193C, 0x193F), new UnicodeCharRange(0x1941, 0x1943), new UnicodeCharRange(0x196E, 0x196F), 
      new UnicodeCharRange(0x1975, 0x197F), new UnicodeCharRange(0x19AC, 0x19AF), new UnicodeCharRange(0x19CA, 0x19CF), 
      new UnicodeCharRange(0x19DB, 0x19DD), new UnicodeCharRange(0x1A1C, 0x1A1D), new UnicodeCharRange(0x1A5F, 0x1A5F), 
      new UnicodeCharRange(0x1A7D, 0x1A7E), new UnicodeCharRange(0x1A8A, 0x1A8F), new UnicodeCharRange(0x1A9A, 0x1A9F), 
      new UnicodeCharRange(0x1AAE, 0x1AFF), new UnicodeCharRange(0x1B4C, 0x1B4F), new UnicodeCharRange(0x1B7D, 0x1B7F), 
      new UnicodeCharRange(0x1BF4, 0x1BFB), new UnicodeCharRange(0x1C38, 0x1C3A), new UnicodeCharRange(0x1C4A, 0x1C4C), 
      new UnicodeCharRange(0x1C80, 0x1CBF), new UnicodeCharRange(0x1CC8, 0x1CCF), new UnicodeCharRange(0x1CF7, 0x1CFF), 
      new UnicodeCharRange(0x1DE7, 0x1DFB), new UnicodeCharRange(0x1F16, 0x1F17), new UnicodeCharRange(0x1F1E, 0x1F1F), 
      new UnicodeCharRange(0x1F46, 0x1F47), new UnicodeCharRange(0x1F4E, 0x1F4F), new UnicodeCharRange(0x1F58, 0x1F58), 
      new UnicodeCharRange(0x1F5A, 0x1F5A), new UnicodeCharRange(0x1F5C, 0x1F5C), new UnicodeCharRange(0x1F5E, 0x1F5E), 
      new UnicodeCharRange(0x1F7E, 0x1F7F), new UnicodeCharRange(0x1FB5, 0x1FB5), new UnicodeCharRange(0x1FC5, 0x1FC5), 
      new UnicodeCharRange(0x1FD4, 0x1FD5), new UnicodeCharRange(0x1FDC, 0x1FDC), new UnicodeCharRange(0x1FF0, 0x1FF1), 
      new UnicodeCharRange(0x1FF5, 0x1FF5), new UnicodeCharRange(0x1FFF, 0x1FFF), new UnicodeCharRange(0x200B, 0x200F), 
      new UnicodeCharRange(0x202A, 0x202E), new UnicodeCharRange(0x2060, 0x206F), new UnicodeCharRange(0x2072, 0x2073), 
      new UnicodeCharRange(0x208F, 0x208F), new UnicodeCharRange(0x209D, 0x209F), new UnicodeCharRange(0x20BB, 0x20CF), 
      new UnicodeCharRange(0x20F1, 0x20FF), new UnicodeCharRange(0x218A, 0x218F), new UnicodeCharRange(0x23F4, 0x23FF), 
      new UnicodeCharRange(0x2427, 0x243F), new UnicodeCharRange(0x244B, 0x245F), new UnicodeCharRange(0x2700, 0x2700), 
      new UnicodeCharRange(0x2B4D, 0x2B4F), new UnicodeCharRange(0x2B5A, 0x2BFF), new UnicodeCharRange(0x2C2F, 0x2C2F), 
      new UnicodeCharRange(0x2C5F, 0x2C5F), new UnicodeCharRange(0x2CF4, 0x2CF8), new UnicodeCharRange(0x2D26, 0x2D26), 
      new UnicodeCharRange(0x2D28, 0x2D2C), new UnicodeCharRange(0x2D2E, 0x2D2F), new UnicodeCharRange(0x2D68, 0x2D6E), 
      new UnicodeCharRange(0x2D71, 0x2D7E), new UnicodeCharRange(0x2D97, 0x2D9F), new UnicodeCharRange(0x2DA7, 0x2DA7), 
      new UnicodeCharRange(0x2DAF, 0x2DAF), new UnicodeCharRange(0x2DB7, 0x2DB7), new UnicodeCharRange(0x2DBF, 0x2DBF), 
      new UnicodeCharRange(0x2DC7, 0x2DC7), new UnicodeCharRange(0x2DCF, 0x2DCF), new UnicodeCharRange(0x2DD7, 0x2DD7), 
      new UnicodeCharRange(0x2DDF, 0x2DDF), new UnicodeCharRange(0x2E3C, 0x2E7F), new UnicodeCharRange(0x2E9A, 0x2E9A), 
      new UnicodeCharRange(0x2EF4, 0x2EFF), new UnicodeCharRange(0x2FD6, 0x2FEF), new UnicodeCharRange(0x2FFC, 0x2FFF), 
      new UnicodeCharRange(0x3040, 0x3040), new UnicodeCharRange(0x3097, 0x3098), new UnicodeCharRange(0x3100, 0x3104), 
      new UnicodeCharRange(0x312E, 0x3130), new UnicodeCharRange(0x3164, 0x3164), new UnicodeCharRange(0x318F, 0x318F), 
      new UnicodeCharRange(0x31BB, 0x31BF), new UnicodeCharRange(0x31E4, 0x31EF), new UnicodeCharRange(0x321F, 0x321F), 
      new UnicodeCharRange(0x32FF, 0x32FF), new UnicodeCharRange(0x4DB6, 0x4DBF), new UnicodeCharRange(0x9FCD, 0x9FFF), 
      new UnicodeCharRange(0xA48D, 0xA48F), new UnicodeCharRange(0xA4C7, 0xA4CF), new UnicodeCharRange(0xA62C, 0xA63F), 
      new UnicodeCharRange(0xA698, 0xA69E), new UnicodeCharRange(0xA6F8, 0xA6FF), new UnicodeCharRange(0xA78F, 0xA78F), 
      new UnicodeCharRange(0xA794, 0xA79F), new UnicodeCharRange(0xA7AB, 0xA7F7), new UnicodeCharRange(0xA82C, 0xA82F), 
      new UnicodeCharRange(0xA83A, 0xA83F), new UnicodeCharRange(0xA878, 0xA87F), new UnicodeCharRange(0xA8C5, 0xA8CD), 
      new UnicodeCharRange(0xA8DA, 0xA8DF), new UnicodeCharRange(0xA8FC, 0xA8FF), new UnicodeCharRange(0xA954, 0xA95E), 
      new UnicodeCharRange(0xA97D, 0xA97F), new UnicodeCharRange(0xA9CE, 0xA9CE), new UnicodeCharRange(0xA9DA, 0xA9DD), 
      new UnicodeCharRange(0xA9E0, 0xA9FF), new UnicodeCharRange(0xAA37, 0xAA3F), new UnicodeCharRange(0xAA4E, 0xAA4F), 
      new UnicodeCharRange(0xAA5A, 0xAA5B), new UnicodeCharRange(0xAA7C, 0xAA7F), new UnicodeCharRange(0xAAC3, 0xAADA), 
      new UnicodeCharRange(0xAAF7, 0xAB00), new UnicodeCharRange(0xAB07, 0xAB08), new UnicodeCharRange(0xAB0F, 0xAB10), 
      new UnicodeCharRange(0xAB17, 0xAB1F), new UnicodeCharRange(0xAB27, 0xAB27), new UnicodeCharRange(0xAB2F, 0xABBF), 
      new UnicodeCharRange(0xABEE, 0xABEF), new UnicodeCharRange(0xABFA, 0xABFF), new UnicodeCharRange(0xD7A4, 0xD7AF), 
      new UnicodeCharRange(0xD7C7, 0xD7CA), new UnicodeCharRange(0xD7FC, 0xDFFF), new UnicodeCharRange(0xFA6E, 0xFA6F), 
      new UnicodeCharRange(0xFADA, 0xFAFF), new UnicodeCharRange(0xFB07, 0xFB12), new UnicodeCharRange(0xFB18, 0xFB1C), 
      new UnicodeCharRange(0xFB37, 0xFB37), new UnicodeCharRange(0xFB3D, 0xFB3D), new UnicodeCharRange(0xFB3F, 0xFB3F), 
      new UnicodeCharRange(0xFB42, 0xFB42), new UnicodeCharRange(0xFB45, 0xFB45), new UnicodeCharRange(0xFBC2, 0xFBD2), 
      new UnicodeCharRange(0xFD40, 0xFD4F), new UnicodeCharRange(0xFD90, 0xFD91), new UnicodeCharRange(0xFDC8, 0xFDEF), 
      new UnicodeCharRange(0xFDFE, 0xFE0F), new UnicodeCharRange(0xFE1A, 0xFE1F), new UnicodeCharRange(0xFE27, 0xFE2F), 
      new UnicodeCharRange(0xFE53, 0xFE53), new UnicodeCharRange(0xFE67, 0xFE67), new UnicodeCharRange(0xFE6C, 0xFE6F), 
      new UnicodeCharRange(0xFE75, 0xFE75), new UnicodeCharRange(0xFEFD, 0xFEFF), new UnicodeCharRange(0xFF00, 0xFF00), 
      new UnicodeCharRange(0xFFA0, 0xFFA0), new UnicodeCharRange(0xFFBF, 0xFFC1), new UnicodeCharRange(0xFFC8, 0xFFC9), 
      new UnicodeCharRange(0xFFD0, 0xFFD1), new UnicodeCharRange(0xFFD8, 0xFFD9), new UnicodeCharRange(0xFFDD, 0xFFDF), 
      new UnicodeCharRange(0xFFE7, 0xFFE7), new UnicodeCharRange(0xFFEF, 0xFFFB), new UnicodeCharRange(0xFFFE, 0xFFFF), 
      new UnicodeCharRange(0x1000C, 0x1000C), new UnicodeCharRange(0x10027, 0x10027), new UnicodeCharRange(0x1003B, 0x1003B), 
      new UnicodeCharRange(0x1003E, 0x1003E), new UnicodeCharRange(0x1004E, 0x1004F), new UnicodeCharRange(0x1005E, 0x1007F), 
      new UnicodeCharRange(0x100FB, 0x100FF), new UnicodeCharRange(0x10103, 0x10106), new UnicodeCharRange(0x10134, 0x10136), 
      new UnicodeCharRange(0x1018B, 0x1018F), new UnicodeCharRange(0x1019C, 0x101CF), new UnicodeCharRange(0x101FE, 0x1027F), 
      new UnicodeCharRange(0x1029D, 0x1029F), new UnicodeCharRange(0x102D1, 0x102FF), new UnicodeCharRange(0x1031F, 0x1031F), 
      new UnicodeCharRange(0x10324, 0x1032F), new UnicodeCharRange(0x1034B, 0x1037F), new UnicodeCharRange(0x1039E, 0x1039E), 
      new UnicodeCharRange(0x103C4, 0x103C7), new UnicodeCharRange(0x103D6, 0x103FF), new UnicodeCharRange(0x1049E, 0x1049F), 
      new UnicodeCharRange(0x104AA, 0x107FF), new UnicodeCharRange(0x10806, 0x10807), new UnicodeCharRange(0x10809, 0x10809), 
      new UnicodeCharRange(0x10836, 0x10836), new UnicodeCharRange(0x10839, 0x1083B), new UnicodeCharRange(0x1083D, 0x1083E), 
      new UnicodeCharRange(0x10856, 0x10856), new UnicodeCharRange(0x10860, 0x108FF), new UnicodeCharRange(0x1091C, 0x1091E), 
      new UnicodeCharRange(0x1093A, 0x1093E), new UnicodeCharRange(0x10940, 0x1097F), new UnicodeCharRange(0x109B8, 0x109BD), 
      new UnicodeCharRange(0x109C0, 0x109FF), new UnicodeCharRange(0x10A04, 0x10A04), new UnicodeCharRange(0x10A07, 0x10A0B), 
      new UnicodeCharRange(0x10A14, 0x10A14), new UnicodeCharRange(0x10A18, 0x10A18), new UnicodeCharRange(0x10A34, 0x10A37), 
      new UnicodeCharRange(0x10A3B, 0x10A3E), new UnicodeCharRange(0x10A48, 0x10A4F), new UnicodeCharRange(0x10A59, 0x10A5F), 
      new UnicodeCharRange(0x10A80, 0x10AFF), new UnicodeCharRange(0x10B36, 0x10B38), new UnicodeCharRange(0x10B56, 0x10B57), 
      new UnicodeCharRange(0x10B73, 0x10B77), new UnicodeCharRange(0x10B80, 0x10BFF), new UnicodeCharRange(0x10C49, 0x10E5F), 
      new UnicodeCharRange(0x10E7F, 0x10FFF), new UnicodeCharRange(0x1104E, 0x11051), new UnicodeCharRange(0x11070, 0x1107F), 
      new UnicodeCharRange(0x110BD, 0x110BD), new UnicodeCharRange(0x110C2, 0x110CF), new UnicodeCharRange(0x110E9, 0x110EF), 
      new UnicodeCharRange(0x110FA, 0x110FF), new UnicodeCharRange(0x11135, 0x11135), new UnicodeCharRange(0x11144, 0x1117F), 
      new UnicodeCharRange(0x111C9, 0x111CF), new UnicodeCharRange(0x111DA, 0x1167F), new UnicodeCharRange(0x116B8, 0x116BF), 
      new UnicodeCharRange(0x116CA, 0x11FFF), new UnicodeCharRange(0x1236F, 0x123FF), new UnicodeCharRange(0x12463, 0x1246F), 
      new UnicodeCharRange(0x12474, 0x12FFF), new UnicodeCharRange(0x1342F, 0x167FF), new UnicodeCharRange(0x16A39, 0x16EFF), 
      new UnicodeCharRange(0x16F45, 0x16F4F), new UnicodeCharRange(0x16F7F, 0x16F8E), new UnicodeCharRange(0x16FA0, 0x1AFFF), 
      new UnicodeCharRange(0x1B002, 0x1CFFF), new UnicodeCharRange(0x1D0F6, 0x1D0FF), new UnicodeCharRange(0x1D127, 0x1D128), 
      new UnicodeCharRange(0x1D173, 0x1D17A), new UnicodeCharRange(0x1D1DE, 0x1D1FF), new UnicodeCharRange(0x1D246, 0x1D2FF), 
      new UnicodeCharRange(0x1D357, 0x1D35F), new UnicodeCharRange(0x1D372, 0x1D3FF), new UnicodeCharRange(0x1D455, 0x1D455), 
      new UnicodeCharRange(0x1D49D, 0x1D49D), new UnicodeCharRange(0x1D4A0, 0x1D4A1), new UnicodeCharRange(0x1D4A3, 0x1D4A4), 
      new UnicodeCharRange(0x1D4A7, 0x1D4A8), new UnicodeCharRange(0x1D4AD, 0x1D4AD), new UnicodeCharRange(0x1D4BA, 0x1D4BA), 
      new UnicodeCharRange(0x1D4BC, 0x1D4BC), new UnicodeCharRange(0x1D4C4, 0x1D4C4), new UnicodeCharRange(0x1D506, 0x1D506), 
      new UnicodeCharRange(0x1D50B, 0x1D50C), new UnicodeCharRange(0x1D515, 0x1D515), new UnicodeCharRange(0x1D51D, 0x1D51D), 
      new UnicodeCharRange(0x1D53A, 0x1D53A), new UnicodeCharRange(0x1D53F, 0x1D53F), new UnicodeCharRange(0x1D545, 0x1D545), 
      new UnicodeCharRange(0x1D547, 0x1D549), new UnicodeCharRange(0x1D551, 0x1D551), new UnicodeCharRange(0x1D6A6, 0x1D6A7), 
      new UnicodeCharRange(0x1D7CC, 0x1D7CD), new UnicodeCharRange(0x1D800, 0x1EDFF), new UnicodeCharRange(0x1EE04, 0x1EE04), 
      new UnicodeCharRange(0x1EE20, 0x1EE20), new UnicodeCharRange(0x1EE23, 0x1EE23), new UnicodeCharRange(0x1EE25, 0x1EE26), 
      new UnicodeCharRange(0x1EE28, 0x1EE28), new UnicodeCharRange(0x1EE33, 0x1EE33), new UnicodeCharRange(0x1EE38, 0x1EE38), 
      new UnicodeCharRange(0x1EE3A, 0x1EE3A), new UnicodeCharRange(0x1EE3C, 0x1EE41), new UnicodeCharRange(0x1EE43, 0x1EE46), 
      new UnicodeCharRange(0x1EE48, 0x1EE48), new UnicodeCharRange(0x1EE4A, 0x1EE4A), new UnicodeCharRange(0x1EE4C, 0x1EE4C), 
      new UnicodeCharRange(0x1EE50, 0x1EE50), new UnicodeCharRange(0x1EE53, 0x1EE53), new UnicodeCharRange(0x1EE55, 0x1EE56), 
      new UnicodeCharRange(0x1EE58, 0x1EE58), new UnicodeCharRange(0x1EE5A, 0x1EE5A), new UnicodeCharRange(0x1EE5C, 0x1EE5C), 
      new UnicodeCharRange(0x1EE5E, 0x1EE5E), new UnicodeCharRange(0x1EE60, 0x1EE60), new UnicodeCharRange(0x1EE63, 0x1EE63), 
      new UnicodeCharRange(0x1EE65, 0x1EE66), new UnicodeCharRange(0x1EE6B, 0x1EE6B), new UnicodeCharRange(0x1EE73, 0x1EE73), 
      new UnicodeCharRange(0x1EE78, 0x1EE78), new UnicodeCharRange(0x1EE7D, 0x1EE7D), new UnicodeCharRange(0x1EE7F, 0x1EE7F), 
      new UnicodeCharRange(0x1EE8A, 0x1EE8A), new UnicodeCharRange(0x1EE9C, 0x1EEA0), new UnicodeCharRange(0x1EEA4, 0x1EEA4), 
      new UnicodeCharRange(0x1EEAA, 0x1EEAA), new UnicodeCharRange(0x1EEBC, 0x1EEEF), new UnicodeCharRange(0x1EEF2, 0x1EFFF), 
      new UnicodeCharRange(0x1F02C, 0x1F02F), new UnicodeCharRange(0x1F094, 0x1F09F), new UnicodeCharRange(0x1F0AF, 0x1F0B0), 
      new UnicodeCharRange(0x1F0BF, 0x1F0C0), new UnicodeCharRange(0x1F0D0, 0x1F0D0), new UnicodeCharRange(0x1F0E0, 0x1F0FF), 
      new UnicodeCharRange(0x1F10B, 0x1F10F), new UnicodeCharRange(0x1F12F, 0x1F12F), new UnicodeCharRange(0x1F16C, 0x1F16F), 
      new UnicodeCharRange(0x1F19B, 0x1F1E5), new UnicodeCharRange(0x1F203, 0x1F20F), new UnicodeCharRange(0x1F23B, 0x1F23F), 
      new UnicodeCharRange(0x1F249, 0x1F24F), new UnicodeCharRange(0x1F252, 0x1F2FF), new UnicodeCharRange(0x1F321, 0x1F32F), 
      new UnicodeCharRange(0x1F336, 0x1F336), new UnicodeCharRange(0x1F37D, 0x1F37F), new UnicodeCharRange(0x1F394, 0x1F39F), 
      new UnicodeCharRange(0x1F3C5, 0x1F3C5), new UnicodeCharRange(0x1F3CB, 0x1F3DF), new UnicodeCharRange(0x1F3F1, 0x1F3FF), 
      new UnicodeCharRange(0x1F43F, 0x1F43F), new UnicodeCharRange(0x1F441, 0x1F441), new UnicodeCharRange(0x1F4F8, 0x1F4F8), 
      new UnicodeCharRange(0x1F4FD, 0x1F4FF), new UnicodeCharRange(0x1F53E, 0x1F53F), new UnicodeCharRange(0x1F544, 0x1F54F), 
      new UnicodeCharRange(0x1F568, 0x1F5FA), new UnicodeCharRange(0x1F641, 0x1F644), new UnicodeCharRange(0x1F650, 0x1F67F), 
      new UnicodeCharRange(0x1F6C6, 0x1F6FF), new UnicodeCharRange(0x1F774, 0x1FFFF), new UnicodeCharRange(0x2A6D7, 0x2A6FF), 
      new UnicodeCharRange(0x2B735, 0x2B73F), new UnicodeCharRange(0x2B81E, 0x2F7FF), new UnicodeCharRange(0x2FA1E, 0xF0000), 
      new UnicodeCharRange(0xFFFFE, 0xFFFFF), new UnicodeCharRange(0x10FFFE, 0x10FFFF)
    };
    private static final /*const*/ UnicodeCharSet NonPrintables/*J*/= new UnicodeCharSet(new ArrayRef<UnicodeCharRange>(NonPrintableRanges));

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::unicode::isPrintable">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unicode.cpp", line = 23,
   FQN = "llvm::sys::unicode::isPrintable", NM = "_ZN4llvm3sys7unicode11isPrintableEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sys7unicode11isPrintableEi")
  //</editor-fold>
  public static boolean isPrintable(int UCS) {
    return UCS >= 0 && UCS <= 0x10FFFF && !NonPrintables.contains(UCS);
  }

  
    // Sorted list of non-spacing and enclosing combining mark intervals as
    // defined in "3.6 Combination" of
    // http://www.unicode.org/versions/Unicode6.2.0/UnicodeStandard-6.2.pdf
    private static final /*const*/ UnicodeCharRange CombiningCharacterRanges[/*218*/] = new /*const*/ UnicodeCharRange [/*218*/] {
      new UnicodeCharRange(0x0300, 0x036F), new UnicodeCharRange(0x0483, 0x0489), new UnicodeCharRange(0x0591, 0x05BD), 
      new UnicodeCharRange(0x05BF, 0x05BF), new UnicodeCharRange(0x05C1, 0x05C2), new UnicodeCharRange(0x05C4, 0x05C5), 
      new UnicodeCharRange(0x05C7, 0x05C7), new UnicodeCharRange(0x0610, 0x061A), new UnicodeCharRange(0x064B, 0x065F), 
      new UnicodeCharRange(0x0670, 0x0670), new UnicodeCharRange(0x06D6, 0x06DC), new UnicodeCharRange(0x06DF, 0x06E4), 
      new UnicodeCharRange(0x06E7, 0x06E8), new UnicodeCharRange(0x06EA, 0x06ED), new UnicodeCharRange(0x0711, 0x0711), 
      new UnicodeCharRange(0x0730, 0x074A), new UnicodeCharRange(0x07A6, 0x07B0), new UnicodeCharRange(0x07EB, 0x07F3), 
      new UnicodeCharRange(0x0816, 0x0819), new UnicodeCharRange(0x081B, 0x0823), new UnicodeCharRange(0x0825, 0x0827), 
      new UnicodeCharRange(0x0829, 0x082D), new UnicodeCharRange(0x0859, 0x085B), new UnicodeCharRange(0x08E4, 0x08FE), 
      new UnicodeCharRange(0x0900, 0x0902), new UnicodeCharRange(0x093A, 0x093A), new UnicodeCharRange(0x093C, 0x093C), 
      new UnicodeCharRange(0x0941, 0x0948), new UnicodeCharRange(0x094D, 0x094D), new UnicodeCharRange(0x0951, 0x0957), 
      new UnicodeCharRange(0x0962, 0x0963), new UnicodeCharRange(0x0981, 0x0981), new UnicodeCharRange(0x09BC, 0x09BC), 
      new UnicodeCharRange(0x09C1, 0x09C4), new UnicodeCharRange(0x09CD, 0x09CD), new UnicodeCharRange(0x09E2, 0x09E3), 
      new UnicodeCharRange(0x0A01, 0x0A02), new UnicodeCharRange(0x0A3C, 0x0A3C), new UnicodeCharRange(0x0A41, 0x0A42), 
      new UnicodeCharRange(0x0A47, 0x0A48), new UnicodeCharRange(0x0A4B, 0x0A4D), new UnicodeCharRange(0x0A51, 0x0A51), 
      new UnicodeCharRange(0x0A70, 0x0A71), new UnicodeCharRange(0x0A75, 0x0A75), new UnicodeCharRange(0x0A81, 0x0A82), 
      new UnicodeCharRange(0x0ABC, 0x0ABC), new UnicodeCharRange(0x0AC1, 0x0AC5), new UnicodeCharRange(0x0AC7, 0x0AC8), 
      new UnicodeCharRange(0x0ACD, 0x0ACD), new UnicodeCharRange(0x0AE2, 0x0AE3), new UnicodeCharRange(0x0B01, 0x0B01), 
      new UnicodeCharRange(0x0B3C, 0x0B3C), new UnicodeCharRange(0x0B3F, 0x0B3F), new UnicodeCharRange(0x0B41, 0x0B44), 
      new UnicodeCharRange(0x0B4D, 0x0B4D), new UnicodeCharRange(0x0B56, 0x0B56), new UnicodeCharRange(0x0B62, 0x0B63), 
      new UnicodeCharRange(0x0B82, 0x0B82), new UnicodeCharRange(0x0BC0, 0x0BC0), new UnicodeCharRange(0x0BCD, 0x0BCD), 
      new UnicodeCharRange(0x0C3E, 0x0C40), new UnicodeCharRange(0x0C46, 0x0C48), new UnicodeCharRange(0x0C4A, 0x0C4D), 
      new UnicodeCharRange(0x0C55, 0x0C56), new UnicodeCharRange(0x0C62, 0x0C63), new UnicodeCharRange(0x0CBC, 0x0CBC), 
      new UnicodeCharRange(0x0CBF, 0x0CBF), new UnicodeCharRange(0x0CC6, 0x0CC6), new UnicodeCharRange(0x0CCC, 0x0CCD), 
      new UnicodeCharRange(0x0CE2, 0x0CE3), new UnicodeCharRange(0x0D41, 0x0D44), new UnicodeCharRange(0x0D4D, 0x0D4D), 
      new UnicodeCharRange(0x0D62, 0x0D63), new UnicodeCharRange(0x0DCA, 0x0DCA), new UnicodeCharRange(0x0DD2, 0x0DD4), 
      new UnicodeCharRange(0x0DD6, 0x0DD6), new UnicodeCharRange(0x0E31, 0x0E31), new UnicodeCharRange(0x0E34, 0x0E3A), 
      new UnicodeCharRange(0x0E47, 0x0E4E), new UnicodeCharRange(0x0EB1, 0x0EB1), new UnicodeCharRange(0x0EB4, 0x0EB9), 
      new UnicodeCharRange(0x0EBB, 0x0EBC), new UnicodeCharRange(0x0EC8, 0x0ECD), new UnicodeCharRange(0x0F18, 0x0F19), 
      new UnicodeCharRange(0x0F35, 0x0F35), new UnicodeCharRange(0x0F37, 0x0F37), new UnicodeCharRange(0x0F39, 0x0F39), 
      new UnicodeCharRange(0x0F71, 0x0F7E), new UnicodeCharRange(0x0F80, 0x0F84), new UnicodeCharRange(0x0F86, 0x0F87), 
      new UnicodeCharRange(0x0F8D, 0x0F97), new UnicodeCharRange(0x0F99, 0x0FBC), new UnicodeCharRange(0x0FC6, 0x0FC6), 
      new UnicodeCharRange(0x102D, 0x1030), new UnicodeCharRange(0x1032, 0x1037), new UnicodeCharRange(0x1039, 0x103A), 
      new UnicodeCharRange(0x103D, 0x103E), new UnicodeCharRange(0x1058, 0x1059), new UnicodeCharRange(0x105E, 0x1060), 
      new UnicodeCharRange(0x1071, 0x1074), new UnicodeCharRange(0x1082, 0x1082), new UnicodeCharRange(0x1085, 0x1086), 
      new UnicodeCharRange(0x108D, 0x108D), new UnicodeCharRange(0x109D, 0x109D), new UnicodeCharRange(0x135D, 0x135F), 
      new UnicodeCharRange(0x1712, 0x1714), new UnicodeCharRange(0x1732, 0x1734), new UnicodeCharRange(0x1752, 0x1753), 
      new UnicodeCharRange(0x1772, 0x1773), new UnicodeCharRange(0x17B4, 0x17B5), new UnicodeCharRange(0x17B7, 0x17BD), 
      new UnicodeCharRange(0x17C6, 0x17C6), new UnicodeCharRange(0x17C9, 0x17D3), new UnicodeCharRange(0x17DD, 0x17DD), 
      new UnicodeCharRange(0x180B, 0x180D), new UnicodeCharRange(0x18A9, 0x18A9), new UnicodeCharRange(0x1920, 0x1922), 
      new UnicodeCharRange(0x1927, 0x1928), new UnicodeCharRange(0x1932, 0x1932), new UnicodeCharRange(0x1939, 0x193B), 
      new UnicodeCharRange(0x1A17, 0x1A18), new UnicodeCharRange(0x1A56, 0x1A56), new UnicodeCharRange(0x1A58, 0x1A5E), 
      new UnicodeCharRange(0x1A60, 0x1A60), new UnicodeCharRange(0x1A62, 0x1A62), new UnicodeCharRange(0x1A65, 0x1A6C), 
      new UnicodeCharRange(0x1A73, 0x1A7C), new UnicodeCharRange(0x1A7F, 0x1A7F), new UnicodeCharRange(0x1B00, 0x1B03), 
      new UnicodeCharRange(0x1B34, 0x1B34), new UnicodeCharRange(0x1B36, 0x1B3A), new UnicodeCharRange(0x1B3C, 0x1B3C), 
      new UnicodeCharRange(0x1B42, 0x1B42), new UnicodeCharRange(0x1B6B, 0x1B73), new UnicodeCharRange(0x1B80, 0x1B81), 
      new UnicodeCharRange(0x1BA2, 0x1BA5), new UnicodeCharRange(0x1BA8, 0x1BA9), new UnicodeCharRange(0x1BAB, 0x1BAB), 
      new UnicodeCharRange(0x1BE6, 0x1BE6), new UnicodeCharRange(0x1BE8, 0x1BE9), new UnicodeCharRange(0x1BED, 0x1BED), 
      new UnicodeCharRange(0x1BEF, 0x1BF1), new UnicodeCharRange(0x1C2C, 0x1C33), new UnicodeCharRange(0x1C36, 0x1C37), 
      new UnicodeCharRange(0x1CD0, 0x1CD2), new UnicodeCharRange(0x1CD4, 0x1CE0), new UnicodeCharRange(0x1CE2, 0x1CE8), 
      new UnicodeCharRange(0x1CED, 0x1CED), new UnicodeCharRange(0x1CF4, 0x1CF4), new UnicodeCharRange(0x1DC0, 0x1DE6), 
      new UnicodeCharRange(0x1DFC, 0x1DFF), new UnicodeCharRange(0x20D0, 0x20F0), new UnicodeCharRange(0x2CEF, 0x2CF1), 
      new UnicodeCharRange(0x2D7F, 0x2D7F), new UnicodeCharRange(0x2DE0, 0x2DFF), new UnicodeCharRange(0x302A, 0x302D), 
      new UnicodeCharRange(0x3099, 0x309A), new UnicodeCharRange(0xA66F, 0xA672), new UnicodeCharRange(0xA674, 0xA67D), 
      new UnicodeCharRange(0xA69F, 0xA69F), new UnicodeCharRange(0xA6F0, 0xA6F1), new UnicodeCharRange(0xA802, 0xA802), 
      new UnicodeCharRange(0xA806, 0xA806), new UnicodeCharRange(0xA80B, 0xA80B), new UnicodeCharRange(0xA825, 0xA826), 
      new UnicodeCharRange(0xA8C4, 0xA8C4), new UnicodeCharRange(0xA8E0, 0xA8F1), new UnicodeCharRange(0xA926, 0xA92D), 
      new UnicodeCharRange(0xA947, 0xA951), new UnicodeCharRange(0xA980, 0xA982), new UnicodeCharRange(0xA9B3, 0xA9B3), 
      new UnicodeCharRange(0xA9B6, 0xA9B9), new UnicodeCharRange(0xA9BC, 0xA9BC), new UnicodeCharRange(0xAA29, 0xAA2E), 
      new UnicodeCharRange(0xAA31, 0xAA32), new UnicodeCharRange(0xAA35, 0xAA36), new UnicodeCharRange(0xAA43, 0xAA43), 
      new UnicodeCharRange(0xAA4C, 0xAA4C), new UnicodeCharRange(0xAAB0, 0xAAB0), new UnicodeCharRange(0xAAB2, 0xAAB4), 
      new UnicodeCharRange(0xAAB7, 0xAAB8), new UnicodeCharRange(0xAABE, 0xAABF), new UnicodeCharRange(0xAAC1, 0xAAC1), 
      new UnicodeCharRange(0xAAEC, 0xAAED), new UnicodeCharRange(0xAAF6, 0xAAF6), new UnicodeCharRange(0xABE5, 0xABE5), 
      new UnicodeCharRange(0xABE8, 0xABE8), new UnicodeCharRange(0xABED, 0xABED), new UnicodeCharRange(0xFB1E, 0xFB1E), 
      new UnicodeCharRange(0xFE00, 0xFE0F), new UnicodeCharRange(0xFE20, 0xFE26), new UnicodeCharRange(0x101FD, 0x101FD), 
      new UnicodeCharRange(0x10A01, 0x10A03), new UnicodeCharRange(0x10A05, 0x10A06), new UnicodeCharRange(0x10A0C, 0x10A0F), 
      new UnicodeCharRange(0x10A38, 0x10A3A), new UnicodeCharRange(0x10A3F, 0x10A3F), new UnicodeCharRange(0x11001, 0x11001), 
      new UnicodeCharRange(0x11038, 0x11046), new UnicodeCharRange(0x11080, 0x11081), new UnicodeCharRange(0x110B3, 0x110B6), 
      new UnicodeCharRange(0x110B9, 0x110BA), new UnicodeCharRange(0x11100, 0x11102), new UnicodeCharRange(0x11127, 0x1112B), 
      new UnicodeCharRange(0x1112D, 0x11134), new UnicodeCharRange(0x11180, 0x11181), new UnicodeCharRange(0x111B6, 0x111BE), 
      new UnicodeCharRange(0x116AB, 0x116AB), new UnicodeCharRange(0x116AD, 0x116AD), new UnicodeCharRange(0x116B0, 0x116B5), 
      new UnicodeCharRange(0x116B7, 0x116B7), new UnicodeCharRange(0x16F8F, 0x16F92), new UnicodeCharRange(0x1D167, 0x1D169), 
      new UnicodeCharRange(0x1D17B, 0x1D182), new UnicodeCharRange(0x1D185, 0x1D18B), new UnicodeCharRange(0x1D1AA, 0x1D1AD), 
      new UnicodeCharRange(0x1D242, 0x1D244), new UnicodeCharRange(0xE0100, 0xE01EF)
    };
    private static final /*const*/ UnicodeCharSet CombiningCharacters/*J*/= new UnicodeCharSet(new ArrayRef<UnicodeCharRange>(CombiningCharacterRanges));
    
    private static final /*const*/ UnicodeCharRange DoubleWidthCharacterRanges[/*15*/] = new /*const*/ UnicodeCharRange [/*15*/] {
      // Hangul Jamo
      new UnicodeCharRange(0x1100, 0x11FF), // Deprecated fullwidth angle brackets
      new UnicodeCharRange(0x2329, 0x232A), // CJK Misc, CJK Unified Ideographs, Yijing Hexagrams, Yi
      // excluding U+303F (IDEOGRAPHIC HALF FILL SPACE)
      new UnicodeCharRange(0x2E80, 0x303E), new UnicodeCharRange(0x3040, 0xA4CF), // Hangul
      new UnicodeCharRange(0xAC00, 0xD7A3), new UnicodeCharRange(0xD7B0, 0xD7C6), new UnicodeCharRange(0xD7CB, 0xD7FB), // CJK Unified Ideographs
      new UnicodeCharRange(0xF900, 0xFAFF), // Vertical forms
      new UnicodeCharRange(0xFE10, 0xFE19), // CJK Compatibility Forms + Small Form Variants
      new UnicodeCharRange(0xFE30, 0xFE6F), // Fullwidth forms
      new UnicodeCharRange(0xFF01, 0xFF60), new UnicodeCharRange(0xFFE0, 0xFFE6), // CJK Unified Ideographs
      new UnicodeCharRange(0x20000, 0x2A6DF), new UnicodeCharRange(0x2A700, 0x2B81F), new UnicodeCharRange(0x2F800, 0x2FA1F)
    };
    private static final /*const*/ UnicodeCharSet DoubleWidthCharacters/*J*/= new UnicodeCharSet(new ArrayRef<UnicodeCharRange>(DoubleWidthCharacterRanges));

  /// Gets the number of positions a character is likely to occupy when output
  /// on a terminal ("character width"). This depends on the implementation of the
  /// terminal, and there's no standard definition of character width.
  /// The implementation defines it in a way that is expected to be compatible
  /// with a generic Unicode-capable terminal.
  /// \return Character width:
  ///   * ErrorNonPrintableCharacter (-1) for non-printable characters (as
  ///     identified by isPrintable);
  ///   * 0 for non-spacing and enclosing combining marks;
  ///   * 2 for CJK characters excluding halfwidth forms;
  ///   * 1 for all remaining characters.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::unicode::charWidth">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unicode.cpp", line = 227,
   FQN = "llvm::sys::unicode::charWidth", NM = "_ZN4llvm3sys7unicodeL9charWidthEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sys7unicodeL9charWidthEi")
  //</editor-fold>
  public static /*inline*/ int charWidth(int UCS) {
    if (!isPrintable(UCS)) {
      return ColumnWidthErrors.ErrorNonPrintableCharacter.getValue();
    }

    if (CombiningCharacters.contains(UCS)) {
      return 0;
    }

    if (DoubleWidthCharacters.contains(UCS)) {
      return 2;
    }
    return 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::unicode::columnWidthUTF8">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unicode.cpp", line = 343,
   FQN = "llvm::sys::unicode::columnWidthUTF8", NM = "_ZN4llvm3sys7unicode15columnWidthUTF8ENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Unicode.cpp -nm=_ZN4llvm3sys7unicode15columnWidthUTF8ENS_9StringRefE")
  //</editor-fold>
  public static int columnWidthUTF8(StringRef Text) {
    /*uint*/int ColumnWidth = 0;
    /*uint*/int Length;
    for (/*size_t*/int i = 0, e = Text.size(); i < e; i += Length) {
      Length = getNumBytesForUTF8(Text.$at(i));
      if (Length <= 0 || i + Length > Text.size()) {
        return ColumnWidthErrors.ErrorInvalidUTF8.getValue();
      }
      int/*UTF32*/ buf[/*1*/] = new$uint$elem(0);
      /*const*/char$ptr/*UTF8 P*/ Start = reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, Text.data().$add(i));
      uint$ptr/*UTF32 P*/ Target = create_uint$ptr($AddrOf(buf));
      if (ConversionResult.conversionOK != ConvertUTF8toUTF32(Start.$addr(), Start.$add(Length), Target.$addr(), 
          Target.$add(1), ConversionFlags.strictConversion)) {
        return ColumnWidthErrors.ErrorInvalidUTF8.getValue();
      }
      int Width = charWidth(buf[0]);
      if (Width < 0) {
        return ColumnWidthErrors.ErrorNonPrintableCharacter.getValue();
      }
      ColumnWidth += Width;
    }
    return (int)ColumnWidth;
  }  
}
//} JAVA: end of namespace unicode
