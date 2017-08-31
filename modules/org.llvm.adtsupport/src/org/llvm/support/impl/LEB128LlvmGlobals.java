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
package org.llvm.support.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type LEB128LlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.impl.LEB128LlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13decodeSLEB128EPKhPj;_ZN4llvm13decodeULEB128EPKhPj;_ZN4llvm13encodeSLEB128ExRNS_11raw_ostreamE;_ZN4llvm13encodeULEB128EyPhj;_ZN4llvm13encodeULEB128EyRNS_11raw_ostreamEj;_ZN4llvm14getSLEB128SizeEx;_ZN4llvm14getULEB128SizeEy; -static-type=LEB128LlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class LEB128LlvmGlobals {


/// Utility function to encode a SLEB128 value to an output stream.
//<editor-fold defaultstate="collapsed" desc="llvm::encodeSLEB128">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 23,
 FQN="llvm::encodeSLEB128", NM="_ZN4llvm13encodeSLEB128ExRNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeSLEB128ExRNS_11raw_ostreamE")
//</editor-fold>
public static /*inline*/ void encodeSLEB128(long/*int64_t*/ Value, final raw_ostream /*&*/ OS) {
  boolean More;
  do {
    byte/*uint8_t*/ Byte = $long2uchar(Value & 0x7f);
    // NOTE: this assumes that this signed shift is an arithmetic right shift.
    Value >>= 7;
    More = !((((Value == 0) && (($uchar2int(Byte) & 0x40) == 0))
       || ((Value == -1) && (($uchar2int(Byte) & 0x40) != 0))));
    if (More) {
      Byte |= 0x80; // Mark this byte to show that more bytes will follow.
    }
    OS.$out_char(((/*char*/byte)(Byte)));
  } while (More);
}


/// Utility function to encode a ULEB128 value to an output stream.
//<editor-fold defaultstate="collapsed" desc="llvm::encodeULEB128">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 38,
 FQN="llvm::encodeULEB128", NM="_ZN4llvm13encodeULEB128EyRNS_11raw_ostreamEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeULEB128EyRNS_11raw_ostreamEj")
//</editor-fold>
public static /*inline*/ void encodeULEB128(long/*uint64_t*/ Value, final raw_ostream /*&*/ OS) {
  encodeULEB128(Value, OS, 
             0);
}
public static /*inline*/ void encodeULEB128(long/*uint64_t*/ Value, final raw_ostream /*&*/ OS, 
             /*uint*/int Padding/*= 0*/) {
  do {
    byte/*uint8_t*/ Byte = $ullong2uchar(Value & $int2ullong(0x7f));
    Value >>>= 7;
    if (Value != $int2ullong(0) || Padding != 0) {
      Byte |= 0x80; // Mark this byte to show that more bytes will follow.
    }
    OS.$out_char(((/*char*/byte)(Byte)));
  } while (Value != $int2ullong(0));
  
  // Pad with 0x80 and emit a null byte at the end.
  if (Padding != 0) {
    for (; Padding != 1; --Padding)  {
      OS.$out_char($$EURO);
    }
    OS.$out_char($$TERM);
  }
}


/// Utility function to encode a ULEB128 value to a buffer. Returns
/// the length in bytes of the encoded value.
//<editor-fold defaultstate="collapsed" desc="llvm::encodeULEB128">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 58,
 FQN="llvm::encodeULEB128", NM="_ZN4llvm13encodeULEB128EyPhj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeULEB128EyPhj")
//</editor-fold>
public static /*inline*/ /*uint*/int encodeULEB128(long/*uint64_t*/ Value, char$ptr/*uint8_t*//*P*/ p) {
  return encodeULEB128(Value, p, 
             0);
}
public static /*inline*/ /*uint*/int encodeULEB128(long/*uint64_t*/ Value, char$ptr/*uint8_t*//*P*/ p, 
             /*uint*/int Padding/*= 0*/) {
  char$ptr/*uint8_t*//*P*/ orig_p = $tryClone(p);
  do {
    byte/*uint8_t*/ Byte = $ullong2uchar(Value & $int2ullong(0x7f));
    Value >>>= 7;
    if (Value != $int2ullong(0) || Padding != 0) {
      Byte |= 0x80; // Mark this byte to show that more bytes will follow.
    }
    p.$postInc().$set(Byte);
  } while (Value != $int2ullong(0));
  
  // Pad with 0x80 and emit a null byte at the end.
  if (Padding != 0) {
    for (; Padding != 1; --Padding)  {
      p.$postInc().$set($$EURO);
    }
    p.$postInc().$set($$TERM);
  }
  return (/*uint*/int)(p.$sub(orig_p));
}


/// Utility function to decode a ULEB128 value.
//<editor-fold defaultstate="collapsed" desc="llvm::decodeULEB128">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 80,
 FQN="llvm::decodeULEB128", NM="_ZN4llvm13decodeULEB128EPKhPj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13decodeULEB128EPKhPj")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ decodeULEB128(/*const*/char$ptr/*uint8_t*//*P*/ p) {
  return decodeULEB128(p, (uint$ptr/*uint P*/ )null);
}
public static /*inline*/ long/*uint64_t*/ decodeULEB128(/*const*/char$ptr/*uint8_t*//*P*/ p, uint$ptr/*uint P*/ n/*= null*/) {
  /*const*/char$ptr/*uint8_t*//*P*/ orig_p = $tryClone(p);
  long/*uint64_t*/ Value = $int2ulong(0);
  /*uint*/int Shift = 0;
  do {
    Value += ((long/*uint64_t*/)($int2ulong($uchar2int(p.$star()) & 0x7f))) << Shift;
    Shift += 7;
  } while ($uchar2int(p.$postInc().$star()) >= 128);
  if (Native.$bool(n)) {
    n.$set((/*uint*/int)(p.$sub(orig_p)));
  }
  return Value;
}


/// Utility function to decode a SLEB128 value.
//<editor-fold defaultstate="collapsed" desc="llvm::decodeSLEB128">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 94,
 FQN="llvm::decodeSLEB128", NM="_ZN4llvm13decodeSLEB128EPKhPj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13decodeSLEB128EPKhPj")
//</editor-fold>
public static /*inline*/ long/*int64_t*/ decodeSLEB128(/*const*/char$ptr/*uint8_t*//*P*/ p) {
  return decodeSLEB128(p, (uint$ptr/*uint P*/ )null);
}
public static /*inline*/ long/*int64_t*/ decodeSLEB128(/*const*/char$ptr/*uint8_t*//*P*/ p, uint$ptr/*uint P*/ n/*= null*/) {
  /*const*/char$ptr/*uint8_t*//*P*/ orig_p = $tryClone(p);
  long/*int64_t*/ Value = 0;
  /*uint*/int Shift = 0;
  byte/*uint8_t*/ Byte;
  do {
    Byte = p.$postInc().$star();
    Value |= (($uchar2int(Byte) & 0x7f) << Shift);
    Shift += 7;
  } while ($uchar2int(Byte) >= 128);
  // Sign extend negative numbers.
  if ((($uchar2int(Byte) & 0x40) != 0)) {
    Value |= (-1L/*ULL*/) << Shift;
  }
  if (Native.$bool(n)) {
    n.$set((/*uint*/int)(p.$sub(orig_p)));
  }
  return Value;
}


/// Utility function to get the size of the ULEB128-encoded value.

/// Utility function to get the size of the ULEB128-encoded value.
//<editor-fold defaultstate="collapsed" desc="llvm::getULEB128Size">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/LEB128.cpp", line = 20,
 FQN="llvm::getULEB128Size", NM="_ZN4llvm14getULEB128SizeEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm14getULEB128SizeEy")
//</editor-fold>
public static /*uint*/int getULEB128Size(long/*uint64_t*/ Value) {
  /*uint*/int Size = 0;
  do {
    Value >>>= 7;
    Size += 1;//$sizeof_Byte();
  } while ((Value != 0));
  return Size;
}


/// Utility function to get the size of the SLEB128-encoded value.

/// Utility function to get the size of the SLEB128-encoded value.
//<editor-fold defaultstate="collapsed" desc="llvm::getSLEB128Size">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/LEB128.cpp", line = 30,
 FQN="llvm::getSLEB128Size", NM="_ZN4llvm14getSLEB128SizeEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm14getSLEB128SizeEx")
//</editor-fold>
public static /*uint*/int getSLEB128Size(long/*int64_t*/ Value) {
  /*uint*/int Size = 0;
  int Sign = (int)(Value >> (8 * 8/*sizeof(Value)*/ - 1));
  boolean IsMore;
  
  do {
    /*uint*/int Byte = $llong2uint(Value & 0x7f);
    Value >>= 7;
    IsMore = Value != Sign || ((Byte ^ Sign) & 0x40) != 0;
    Size += 1;//$sizeof_Byte();
  } while (IsMore);
  return Size;
}

} // END OF class LEB128LlvmGlobals
