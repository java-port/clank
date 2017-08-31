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

import static org.clank.java.built_in.__builtin_assume_aligned;
import static org.clank.java.std.memcpy;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.NativePointer.create_char$ptr;
import static org.clank.support.NativePointer.create_uint$ptr;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.unaligned;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type EndianGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.endian.EndianGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian18readAtBitAlignmentEPKvy;Tpl__ZN4llvm7support6endian19writeAtBitAlignmentEPvT_y;Tpl__ZN4llvm7support6endian4readEPKv;Tpl__ZN4llvm7support6endian5writeEPvT_;Tpl__ZN4llvm7support6endian6read16EPKv;Tpl__ZN4llvm7support6endian6read32EPKv;Tpl__ZN4llvm7support6endian6read64EPKv;Tpl__ZN4llvm7support6endian7write16EPvt;Tpl__ZN4llvm7support6endian7write32EPvj;Tpl__ZN4llvm7support6endian7write64EPvy;Tpl__ZN4llvm7support6endian8readNextERPKT2_;Tpl__ZN4llvm7support6endian9byte_swapET_;_ZN4llvm7support6endian8read16beEPKv;_ZN4llvm7support6endian8read16leEPKv;_ZN4llvm7support6endian8read32beEPKv;_ZN4llvm7support6endian8read32leEPKv;_ZN4llvm7support6endian8read64beEPKv;_ZN4llvm7support6endian8read64leEPKv;_ZN4llvm7support6endian9write16beEPvt;_ZN4llvm7support6endian9write16leEPvt;_ZN4llvm7support6endian9write32beEPvj;_ZN4llvm7support6endian9write32leEPvj;_ZN4llvm7support6endian9write64beEPvy;_ZN4llvm7support6endian9write64leEPvy; -static-type=EndianGlobals -package=org.llvm.support.endian")
//</editor-fold>
public /*final*/ class EndianGlobals {

/// Swap the bytes of value to match the given endianness.
/*template <typename value_type, endianness endian> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::byte_swap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 39,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 38,
 FQN="llvm::support::endian::byte_swap", NM="Tpl__ZN4llvm7support6endian9byte_swapET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm7support6endian9byte_swapET_")
//</editor-fold>
public static /*inline*/ </*typename*/ value_type> value_type byte_swap(value_type value, endianness endian) {
  if (endian != endianness.__native && sys.IsBigEndianHost != (endian == endianness.big)) {
    throw new UnsupportedOperationException("Use specialization from sys to swap " + (value == null ? null : value.getClass()));
  }
  return value;
}
//template <typename value_type = unsigned short, endianness endian = llvm::support::endianness::big> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::byte_swap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 39,
 FQN="llvm::support::endian::byte_swap", NM="_ZN4llvm7support6endian9byte_swapItLNS0_10endiannessE0EEET_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm7support6endian9byte_swapItLNS0_10endiannessE0EEET_S4_")
//</editor-fold>
public static /*inline*/ /*ushort*/char byte_swap$UShort(endianness endian, /*ushort*/char value) {
  if (endian != endianness.__native && sys.IsBigEndianHost != (endian == endianness.big)) {
//    sys.swapByteOrder$UShort(value);
    throw new UnsupportedOperationException("Use specialization from sys to swap UShort");
  }
  return value;
}
//template <typename value_type = unsigned int, endianness endian = llvm::support::endianness::big> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::byte_swap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 39,
 FQN="llvm::support::endian::byte_swap", NM="_ZN4llvm7support6endian9byte_swapIjLNS0_10endiannessE0EEET_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm7support6endian9byte_swapIjLNS0_10endiannessE0EEET_S4_")
//</editor-fold>
public static /*inline*/ /*uint*/int byte_swap$UInt(endianness endian, /*uint*/int value) {
  if (endian != endianness.__native && sys.IsBigEndianHost != (endian == endianness.big)) {
//    sys.swapByteOrder$UInt(value);
    throw new UnsupportedOperationException("Use specialization from sys to swap UInt");
  }
  return value;
}
//template <typename value_type = unsigned long long, endianness endian = llvm::support::endianness::big> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::byte_swap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 39,
 FQN="llvm::support::endian::byte_swap", NM="_ZN4llvm7support6endian9byte_swapIyLNS0_10endiannessE0EEET_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm7support6endian9byte_swapIyLNS0_10endiannessE0EEET_S4_")
//</editor-fold>
public static /*inline*/ /*ullong*/long byte_swap$ULLong(endianness endian, /*ullong*/long value) {
  if (endian != endianness.__native && sys.IsBigEndianHost != (endian == endianness.big)) {
//    sys.swapByteOrder$ULLong(value);
    throw new UnsupportedOperationException("Use specialization from sys to swap ULLong");
  }
  return value;
}


/// Read a value of a particular endianness from memory.
/*template <typename value_type, endianness endian, std::size_t alignment> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 49,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 46,
 FQN="llvm::support::endian::read", NM="Tpl__ZN4llvm7support6endian4readEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian4readEPKv")
//</editor-fold>
public static /*inline*/ </*typename*/ value_type> value_type read(Class<value_type> Type, endianness endian, /*ulong*/int alignment, /*const*/char$ptr/*void P*/ memory) {
  throw new UnsupportedOperationException("Use specialization to read_* " + Type);
}
public static /*inline*/ long read_uint64(endianness endian, /*ulong*/int alignment, /*const*/byte[]/*void P*/ memory) {
  return read_uint64(endian, alignment, create_char$ptr(memory), 0);
}
public static /*inline*/ long read_uint64(endianness endian, /*ulong*/int alignment, /*const*/char$ptr/*void P*/ memory, int fromPos) {
  long ret = 0;
  // JAVA: read as 8 sequential bytes
  assert endian == endianness.little;
  try {
    ret = ((long)$char(memory.$at(fromPos+7)) << 54) | ((long)$char(memory.$at(fromPos+6)) << 48) | ((long)$char(memory.$at(fromPos+5)) << 40) | ((long)$char(memory.$at(fromPos+4)) << 32);
    ret |= ($char(memory.$at(fromPos+3)) << 24) | ($char(memory.$at(fromPos+2)) << 16) | ($char(memory.$at(fromPos+1)) << 8) | ($char(memory.$at(fromPos+0)));
  } catch (IndexOutOfBoundsException e) {
    llvm.errs().$out("reading out of boundary " + memory.toString() + "\n");
  }
  return (ret);
}
public static /*inline*/ int read_uint32(endianness endian, /*uint*/int alignment, /*const*/char$ptr/*void P*/ memory, int fromPos) {
  int ret = 0;
  // JAVA: read as 4 sequential bytes
  assert endian == endianness.little;
  try {
    ret = ($char(memory.$at(fromPos+3)) << 24) | ($char(memory.$at(fromPos+2)) << 16) | ($char(memory.$at(fromPos+1)) << 8) | ($char(memory.$at(fromPos+0)));
  } catch (IndexOutOfBoundsException e) {
    llvm.errs().$out("reading out of boundary " + memory.toString() + "\n");
  }
  return (ret);
}
public static /*inline*/ char read_uint16(endianness endian, /*ulong*/int alignment, /*const*/char$ptr/*void P*/ memory, int fromPos) {
  char ret = 0;
  // JAVA: read as 2 sequential bytes
  assert endian == endianness.little;
  try {
    ret = (char)(($char(memory.$at(fromPos+1)) << 8) | ($char(memory.$at(fromPos+0))));
  } catch (IndexOutOfBoundsException e) {
    llvm.errs().$out("reading out of boundary " + memory.toString() + "\n");
  }
  return (ret);
}
public static /*inline*/ /*uchar*/byte read_uchar(endianness endian, /*ulong*/int alignment, /*const*/char$ptr/*void P*/ memory, int fromPos) {
  byte ret = 0;
  // JAVA: read as 1 byte
  try {
    ret = memory.$at(fromPos+0);
  } catch (IndexOutOfBoundsException e) {
    llvm.errs().$out("reading out of boundary " + memory.toString() + "\n");
  }
  return (ret);
}


/// Read a value of a particular endianness from a buffer, and increment the
/// buffer past that value.
/*template <typename value_type, endianness endian, std::size_t alignment, typename CharT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::readNext">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 63,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 61,
 FQN="llvm::support::endian::readNext", NM="Tpl__ZN4llvm7support6endian8readNextERPKT2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian8readNextERPKT2_")
//</editor-fold>
public static /*inline*/ </*typename*/ value_type> value_type readNext(Class<value_type> Type, endianness endian, /*uint*/int alignment, char$ptr/*const uchar P&*/ memory) {
  throw new UnsupportedOperationException("Use specialization to readNext_* " + Type);
}
public static /*inline*/long readNext_uint64(endianness endian, /*ulong*/int alignment, char$ptr/*const uchar P&*/ memory) {
  long ret = read_uint64(endian, alignment, memory, 0);
  memory.$inc(sizeof(ret));
  return ret;
}
public static /*inline*/ int readNext_uint32(endianness endian, /*uint*/int alignment, char$ptr/*const uchar P&*/ memory) {
  int ret = read_uint32(endian, alignment, memory, 0);
  memory.$inc(sizeof(ret));
  return ret;
}
public static /*inline*/char readNext_uint16(endianness endian, /*uint*/int alignment, char$ptr/*const uchar P&*/ memory) {
  char ret = read_uint16(endian, alignment, memory, 0);
  memory.$inc(sizeof(ret));
  return ret;
}


/// Write a value to memory with a particular endianness.
/*template <typename value_type, endianness endian, std::size_t alignment> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 73,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 70,
 FQN="llvm::support::endian::write", NM="Tpl__ZN4llvm7support6endian5writeEPvT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian5writeEPvT_")
//</editor-fold>
public static /*inline*/ </*typename*/ value_type> void write(endianness endian, /*uint*/int alignment, Object/*void P*/ memory, value_type value) {
  throw new UnsupportedOperationException("EmptyBody");
//  value = byte_swap<value_type>/*<endian>*/(value);
//  memcpy(__builtin_assume_aligned(memory, (PickAlignment/*<alignment>*/.<value_type>value)), 
//      $AddrOf(value), 
//      $sizeof_T());
}
/*template <typename value_type, endianness endian, std::size_t alignment> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 72,
 FQN = "llvm::support::endian::write", NM = "_ZN4llvm7support6endian5writeEPvT_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm7support6endian5writeEPvT_")
//</editor-fold>
public static /*inline*/ </*typename*/ value_type> void write(char$ptr/*void P*/ memory, value_type value, Class<value_type> Type, endianness endian, /*ulong*/int alignment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Read a value of a particular endianness from memory, for a location
/// that starts at the given bit offset within the first byte.
/*template <typename value_type, endianness endian, std::size_t alignment> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::readAtBitAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 87,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 86,
 FQN="llvm::support::endian::readAtBitAlignment", NM="Tpl__ZN4llvm7support6endian18readAtBitAlignmentEPKvy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm7support6endian18readAtBitAlignmentEPKvy")
//</editor-fold>
public static /*inline*/ </*typename*/ value_type> value_type readAtBitAlignment(endianness endian, /*uint*/int alignment, /*const*/Object/*void P*/ memory, long/*uint64_t*/ startBit) {
  throw new UnsupportedOperationException("Use readAtBitAlignment$... specialization");
}
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::readAtBitAlignment">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 87,
 FQN="llvm::support::endian::readAtBitAlignment", NM="_ZN4llvm7support6endian18readAtBitAlignmentIjLNS0_10endiannessE1ELj1EEET_PKvy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm7support6endian18readAtBitAlignmentIjLNS0_10endiannessE1ELj1EEET_PKvy")
//</editor-fold>
public static /*inline*/ /*uint*/int readAtBitAlignment$UInt(endianness endian, /*uint*/int alignment, /*const*/char$ptr/*void P*/ memory, long/*uint64_t*/ startBit) {
  assert ($less_ulong_ullong(startBit, $int2ullong(8)));
  if (startBit == $int2ullong(0)) {
    return EndianGlobals./*<endian, alignment>*/read_uint32(endian, alignment/*U*/, memory, 0);
  } else {
    // Read two values and compose the result from them.
    /*uint*/int val[/*2*/] = new /*uint*/int [2];
    memcpy(reinterpret_cast(char$ptr.class, $AddrOf(create_uint$ptr(val, 0))), 
        __builtin_assume_aligned(memory, 1/*(PickAlignmentUInt<1U>.value)*/), 
        $sizeof_UInt() * 2);
    val[0] = EndianGlobals./*<endian>*/byte_swap$UInt(endian/*U*/, val[0]);
    val[1] = EndianGlobals./*<endian>*/byte_swap$UInt(endian/*U*/, val[1]);
    
    // Shift bits from the lower value into place.
    /*make_unsigned_t*//*uint*/int lowerVal = val[0] >>> startBit;
    // Mask off upper bits after right shift in case of signed type.
    /*make_unsigned_t*//*uint*/int numBitsFirstVal = $ullong2uint($uint2ullong(($sizeof_UInt() * 8)) - startBit);
    lowerVal &= ((/*make_unsigned_t*//*uint*/int)1 << numBitsFirstVal) - 1;
    
    // Get the bits from the upper value.
    /*make_unsigned_t*//*uint*/int upperVal = val[1] & (((/*make_unsigned_t*//*uint*/int)1 << startBit) - 1);
    // Shift them in to place.
    upperVal <<= numBitsFirstVal;
    
    return lowerVal | upperVal;
  }
}

/// Write a value to memory with a particular endianness, for a location
/// that starts at the given bit offset within the first byte.
/*template <typename value_type, endianness endian, std::size_t alignment> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::writeAtBitAlignment">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 121,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 120,
 FQN="llvm::support::endian::writeAtBitAlignment", NM="Tpl__ZN4llvm7support6endian19writeAtBitAlignmentEPvT_y",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm7support6endian19writeAtBitAlignmentEPvT_y")
//</editor-fold>
public static /*inline*/ </*typename*/ value_type> void writeAtBitAlignment(endianness endian, /*uint*/int alignment, Object/*void P*/ memory, value_type value, 
                   long/*uint64_t*/ startBit) {
  assert ($less_ulong_ullong(startBit, $int2ullong(8)));
  throw new UnsupportedOperationException("Use writeAtBitAlignment$... specialization");
}
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::writeAtBitAlignment">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 121,
 FQN="llvm::support::endian::writeAtBitAlignment", NM="_ZN4llvm7support6endian19writeAtBitAlignmentIjLNS0_10endiannessE1ELj1EEEvPvT_y",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm7support6endian19writeAtBitAlignmentIjLNS0_10endiannessE1ELj1EEEvPvT_y")
//</editor-fold>
public static /*inline*/ void writeAtBitAlignment$UInt(endianness endian, /*uint*/int alignment, char$ptr/*void P*/ memory, /*uint*/int value, 
                        long/*uint64_t*/ startBit) {
  assert ($less_ulong_ullong(startBit, $int2ullong(8)));
  if (startBit == $int2ullong(0)) {
    EndianGlobals./*<endian, alignment>*/write$UInt(endian, alignment/*U*/, memory, value);
  } else {
    // Read two values and shift the result into them.
    /*uint*/int val[/*2*/] = new /*uint*/int [2];
    memcpy(reinterpret_cast(char$ptr.class, $AddrOf(create_uint$ptr(val, 0))), 
        __builtin_assume_aligned(memory, 1/*(PickAlignmentUInt<1U>.value)*/), 
        $sizeof_UInt() * 2);
    val[0] = EndianGlobals./*<endian>*/byte_swap$UInt(endian, val[0]);
    val[1] = EndianGlobals./*<endian>*/byte_swap$UInt(endian, val[1]);
    
    // Mask off any existing bits in the upper part of the lower value that
    // we want to replace.
    val[0] &= ((/*make_unsigned_t*//*uint*/int)1 << startBit) - 1;
    /*make_unsigned_t*//*uint*/int numBitsFirstVal = $ullong2uint($uint2ullong(($sizeof_UInt() * 8)) - startBit);
    /*make_unsigned_t*//*uint*/int lowerVal = value;
    if ($greater_ulong_ullong(startBit, $int2ullong(0))) {
      // Mask off the upper bits in the new value that are not going to go into
      // the lower value. This avoids a left shift of a negative value, which
      // is undefined behavior.
      lowerVal &= (((/*make_unsigned_t*//*uint*/int)1 << numBitsFirstVal) - 1);
      // Now shift the new bits into place
      lowerVal <<= startBit;
    }
    val[0] |= lowerVal;
    
    // Mask off any existing bits in the lower part of the upper value that
    // we want to replace.
    val[1] &= ~(((/*make_unsigned_t*//*uint*/int)1 << startBit) - 1);
    // Next shift the bits that go into the upper value into position.
    /*make_unsigned_t*//*uint*/int upperVal = value >>> numBitsFirstVal;
    // Mask off upper bits after right shift in case of signed type.
    upperVal &= ((/*make_unsigned_t*//*uint*/int)1 << startBit) - 1;
    val[1] |= upperVal;
    
    // Finally, rewrite values.
    val[0] = EndianGlobals./*<endian>*/byte_swap$UInt(endian, val[0]);
    val[1] = EndianGlobals./*<endian>*/byte_swap$UInt(endian, val[1]);
    memcpy(__builtin_assume_aligned(memory, 1/*(PickAlignmentUInt<1U>.value)*/), 
        reinterpret_cast(char$ptr.class, $AddrOf(create_uint$ptr(val, 0))), $sizeof_UInt() * 2);
  }
}

/*template <typename T, endianness E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 304,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 46,
 FQN="llvm::support::endian::read", NM="Tpl__ZN4llvm7support6endian4readEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian4readEPKv")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T read(endianness E, /*const*/char$ptr/*void P*/ P) {
  throw new UnsupportedOperationException("use specialized read$... method");
//  return $Deref((/*const*/ packed_endian_specific_integral<T>/*<E, unaligned>*/ /*P*/ )P);
}
//template <typename T = unsigned short, endianness E = llvm::support::endianness::little> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 304,
 FQN="llvm::support::endian::read", NM="_ZN4llvm7support6endian4readItLNS0_10endiannessE1EEET_PKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian4readItLNS0_10endiannessE1EEET_PKv")
//</editor-fold>
public static /*inline*/ /*ushort*/char read$UShort(endianness E, /*const*/char$ptr/*void P*/ P) {
//  return $Deref((/*const*/ packed_endian_specific_integralUShort/*<endianness.valueOf(E/*U*/), unaligned>*/ /*P*/ )P).$T();
  return new llvm.support.detail.packed_endian_specific_integral<Character>((char$ptr)P, Character.class, E, unaligned).$value();
}
//template <typename T = unsigned int, endianness E = llvm::support::endianness::little> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 304,
 FQN="llvm::support::endian::read", NM="_ZN4llvm7support6endian4readIjLNS0_10endiannessE1EEET_PKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian4readIjLNS0_10endiannessE1EEET_PKv")
//</editor-fold>
public static /*inline*/ /*uint*/int read$UInt(endianness E, /*const*/char$ptr/*void P*/ P) {
//  return $Deref((/*const*/ packed_endian_specific_integralUInt/*<endianness.valueOf(E/*U*/), unaligned>*/ /*P*/ )P).$T();
  return new llvm.support.detail.packed_endian_specific_integral<Integer>((char$ptr)P, Integer.class, E, unaligned).$value();
}
//template <typename T = unsigned long long, endianness E = llvm::support::endianness::little> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 304,
 FQN="llvm::support::endian::read", NM="_ZN4llvm7support6endian4readIyLNS0_10endiannessE1EEET_PKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian4readIyLNS0_10endiannessE1EEET_PKv")
//</editor-fold>
public static /*inline*/ /*ullong*/long read$ULLong(endianness E, /*const*/char$ptr/*void P*/ P) {
//  return $Deref((/*const*/ packed_endian_specific_integralULLong/*<endianness.valueOf(E/*U*/), unaligned>*/ /*P*/ )P).$T();
  return new llvm.support.detail.packed_endian_specific_integral<Long>((char$ptr)P, Long.class, E, unaligned).$value();
}

/*template <endianness E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read16">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 308,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 304,
 FQN="llvm::support::endian::read16", NM="Tpl__ZN4llvm7support6endian6read16EPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian6read16EPKv")
//</editor-fold>
public static /*inline*/ /*uint16_t*/char read16(endianness E, /*const*/char$ptr/*void P*/ P) {
  return read$UShort/*<uint16_t, E>*/(E, P);
}

/*template <endianness E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read32">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 311,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 307,
 FQN="llvm::support::endian::read32", NM="Tpl__ZN4llvm7support6endian6read32EPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian6read32EPKv")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int read32(endianness E, /*const*/char$ptr/*void P*/ P) {
  return read$UInt/*<uint32_t, E>*/(E, P);
}

/*template <endianness E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read64">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 314,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 310,
 FQN="llvm::support::endian::read64", NM="Tpl__ZN4llvm7support6endian6read64EPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian6read64EPKv")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ read64(endianness E, /*const*/char$ptr/*void P*/ P) {
  return read$ULLong/*<uint64_t, E>*/(E, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read16le">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 318,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 314,
 FQN="llvm::support::endian::read16le", NM="_ZN4llvm7support6endian8read16leEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian8read16leEPKv")
//</editor-fold>
public static /*inline*/ /*uint16_t*/char read16le(/*const*/char$ptr/*void P*/ P) {
  return /*<endianness.little>*/read16(endianness.little, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read32le">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 319,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 315,
 FQN="llvm::support::endian::read32le", NM="_ZN4llvm7support6endian8read32leEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian8read32leEPKv")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int read32le(/*const*/char$ptr/*void P*/ P) {
  return /*<endianness.little>*/read32(endianness.little, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read64le">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 320,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 316,
 FQN="llvm::support::endian::read64le", NM="_ZN4llvm7support6endian8read64leEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian8read64leEPKv")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ read64le(/*const*/char$ptr/*void P*/ P) {
  return /*<endianness.little>*/read64(endianness.little, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read16be">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 321,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 317,
 FQN="llvm::support::endian::read16be", NM="_ZN4llvm7support6endian8read16beEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian8read16beEPKv")
//</editor-fold>
public static /*inline*/ /*uint16_t*/char read16be(/*const*/char$ptr/*void P*/ P) {
  return /*<endianness.big>*/read16(endianness.big, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read32be">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 322,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 318,
 FQN="llvm::support::endian::read32be", NM="_ZN4llvm7support6endian8read32beEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian8read32beEPKv")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int read32be(/*const*/char$ptr/*void P*/ P) {
  return /*<endianness.big>*/read32(endianness.big, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::read64be">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 323,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 319,
 FQN="llvm::support::endian::read64be", NM="_ZN4llvm7support6endian8read64beEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian8read64beEPKv")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ read64be(/*const*/char$ptr/*void P*/ P) {
  return /*<endianness.big>*/read64(endianness.big, P);
}
  
/*template <typename T, endianness E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 325,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 70,
 FQN="llvm::support::endian::write", NM="Tpl__ZN4llvm7support6endian5writeEPvT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian5writeEPvT_")
//</editor-fold>
public static /*inline*/ </*typename*/ T> void write(endianness E, char$ptr/*void P*/ P, T V) {
//  (packed_endian_specific_integral<T>/*<E, unaligned>*/ /*P*/ )P.$set(V);
  throw new UnsupportedOperationException("Use one of specialized write$... for " + NativeTrace.getIdentityStr(V));
}
//template <typename T = unsigned short, endianness E = llvm::support::endianness::little> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 325,
 FQN="llvm::support::endian::write", NM="_ZN4llvm7support6endian5writeItLNS0_10endiannessE1EEEvPvT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian5writeItLNS0_10endiannessE1EEEvPvT_")
//</editor-fold>
public static /*inline*/ void write$UShort(endianness E, char$ptr/*void P*/ P, /*ushort*/char V) {
  write$UShort(E, unaligned, P, V);
}
public static /*inline*/ void write$UShort(endianness E, int alignment, char$ptr/*void P*/ P, /*ushort*/char V) {
//  $Deref((packed_endian_specific_integralUShort/*<endianness.valueOf(E/*U*/), unaligned>*/ /*P*/ )P).$assign(V);
  new llvm.support.detail.packed_endian_specific_integral<Character>((char$ptr)P, Character.class, E, alignment).$assign(V);
}
//template <typename T = unsigned int, endianness E = llvm::support::endianness::little> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 325,
 FQN="llvm::support::endian::write", NM="_ZN4llvm7support6endian5writeIjLNS0_10endiannessE1EEEvPvT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian5writeIjLNS0_10endiannessE1EEEvPvT_")
//</editor-fold>
public static /*inline*/ void write$UInt(endianness E, char$ptr/*void P*/ P, /*uint*/int V) {
  write$UInt(E, unaligned, P, V);
}
public static /*inline*/ void write$UInt(endianness E, int alignment, char$ptr/*void P*/ P, /*uint*/int V) {
//  $Deref((packed_endian_specific_integralUInt/*<endianness.valueOf(E/*U*/), unaligned>*/ /*P*/ )P).$assign(V);
    // 4 bytes
    if (E == endianness.little && alignment == unaligned) {
      P.$set(0, (byte)V);
      V = V >>> 8;
      P.$set(1, (byte)V);
      V = V >>> 8;
      P.$set(2, (byte)V);
      V = V >>> 8;
      P.$set(3, (byte)V);
    } else {
      new llvm.support.detail.packed_endian_specific_integral<Integer>((char$ptr)P, Integer.class, E, alignment).$assign(V);
    }
}
//template <typename T = unsigned long long, endianness E = llvm::support::endianness::little> 
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 325,
 FQN="llvm::support::endian::write", NM="_ZN4llvm7support6endian5writeIyLNS0_10endiannessE1EEEvPvT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian5writeIyLNS0_10endiannessE1EEEvPvT_")
//</editor-fold>
public static /*inline*/ void write$ULLong(endianness E, char$ptr/*void P*/ P, /*ullong*/long V) {
  write$ULLong(E, unaligned, P, V);
}
public static /*inline*/ void write$ULLong(endianness E, int alignment, char$ptr/*void P*/ P, /*ullong*/long V) {
//  $Deref((packed_endian_specific_integralULLong/*<endianness.valueOf(E/*U*/), unaligned>*/ /*P*/ )P).$assign(V);
  new llvm.support.detail.packed_endian_specific_integral<Long>((char$ptr)P, Long.class, E, alignment).$assign(V);
}

/*template <endianness E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write16">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 329,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 325,
 FQN="llvm::support::endian::write16", NM="Tpl__ZN4llvm7support6endian7write16EPvt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian7write16EPvt")
//</editor-fold>
public static /*inline*/ void write16(endianness E, char$ptr/*void P*/ P, /*uint16_t*/char V) {
  write$UShort/*<uint16_t, E>*/(E, P, V);
}

/*template <endianness E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write32">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 332,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 328,
 FQN="llvm::support::endian::write32", NM="Tpl__ZN4llvm7support6endian7write32EPvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian7write32EPvj")
//</editor-fold>
public static /*inline*/ void write32(endianness E, char$ptr/*void P*/ P, /*uint32_t*/int V) {
  write$UInt/*<uint32_t, E>*/(E, P, V);
}

/*template <endianness E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write64">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 335,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 331,
 FQN="llvm::support::endian::write64", NM="Tpl__ZN4llvm7support6endian7write64EPvy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=Tpl__ZN4llvm7support6endian7write64EPvy")
//</editor-fold>
public static /*inline*/ void write64(endianness E, char$ptr/*void P*/ P, long/*uint64_t*/ V) {
  write$ULLong/*<uint64_t, E>*/(E, P, V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write16le">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 339,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 335,
 FQN="llvm::support::endian::write16le", NM="_ZN4llvm7support6endian9write16leEPvt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian9write16leEPvt")
//</editor-fold>
public static /*inline*/ void write16le(char$ptr/*void P*/ P, /*uint16_t*/char V) {
  /*<endianness.little>*/write16(endianness.little, P, V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write32le">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 340,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 336,
 FQN="llvm::support::endian::write32le", NM="_ZN4llvm7support6endian9write32leEPvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian9write32leEPvj")
//</editor-fold>
public static /*inline*/ void write32le(char$ptr/*void P*/ P, /*uint32_t*/int V) {
  /*<endianness.little>*/write32(endianness.little, P, V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write64le">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 341,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 337,
 FQN="llvm::support::endian::write64le", NM="_ZN4llvm7support6endian9write64leEPvy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian9write64leEPvy")
//</editor-fold>
public static /*inline*/ void write64le(char$ptr/*void P*/ P, long/*uint64_t*/ V) {
  /*<endianness.little>*/write64(endianness.little, P, V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write16be">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 342,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 338,
 FQN="llvm::support::endian::write16be", NM="_ZN4llvm7support6endian9write16beEPvt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian9write16beEPvt")
//</editor-fold>
public static /*inline*/ void write16be(char$ptr/*void P*/ P, /*uint16_t*/char V) {
  /*<endianness.big>*/write16(endianness.big, P, V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write32be">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 343,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 339,
 FQN="llvm::support::endian::write32be", NM="_ZN4llvm7support6endian9write32beEPvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian9write32beEPvj")
//</editor-fold>
public static /*inline*/ void write32be(char$ptr/*void P*/ P, /*uint32_t*/int V) {
  /*<endianness.big>*/write32(endianness.big, P, V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::support::endian::write64be">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", line = 344,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Endian.h", old_line = 340,
 FQN="llvm::support::endian::write64be", NM="_ZN4llvm7support6endian9write64beEPvy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm7support6endian9write64beEPvy")
//</editor-fold>
public static /*inline*/ void write64be(char$ptr/*void P*/ P, long/*uint64_t*/ V) {
  /*<endianness.big>*/write64(endianness.big, P, V);
}

} // END OF class EndianGlobals
