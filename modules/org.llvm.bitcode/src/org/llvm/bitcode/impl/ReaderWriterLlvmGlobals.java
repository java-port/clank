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
package org.llvm.bitcode.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.bitcode.*;
import org.llvm.support.llvm.support.endian;


//<editor-fold defaultstate="collapsed" desc="static type ReaderWriterLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.bitcode.impl.ReaderWriterLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_ZN4llvm12isRawBitcodeEPKhS1_;_ZN4llvm15make_error_codeENS_12BitcodeErrorE;_ZN4llvm16isBitcodeWrapperEPKhS1_;_ZN4llvm24SkipBitcodeWrapperHeaderERPKhS2_b;_ZN4llvm9isBitcodeEPKhS1_; -static-type=ReaderWriterLlvmGlobals -package=org.llvm.bitcode.impl")
//</editor-fold>
public final class ReaderWriterLlvmGlobals {


/// isBitcodeWrapper - Return true if the given bytes are the magic bytes
/// for an LLVM IR bitcode wrapper.
///
//<editor-fold defaultstate="collapsed" desc="llvm::isBitcodeWrapper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 116,
 FQN="llvm::isBitcodeWrapper", NM="_ZN4llvm16isBitcodeWrapperEPKhS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_ZN4llvm16isBitcodeWrapperEPKhS1_")
//</editor-fold>
public static /*inline*/ boolean isBitcodeWrapper(/*const*/char$ptr/*uchar P*/ BufPtr, 
                /*const*/char$ptr/*uchar P*/ BufEnd) {
  // See if you can find the hidden message in the magic bytes :-).
  // (Hint: it's a little-endian encoding.)
  return $noteq_ptr(BufPtr, BufEnd)
     && $uchar2int(BufPtr.$at(0)) == 0xDE
     && $uchar2int(BufPtr.$at(1)) == 0xC0
     && $uchar2int(BufPtr.$at(2)) == 0x17
     && $uchar2int(BufPtr.$at(3)) == 0x0B;
}


/// isRawBitcode - Return true if the given bytes are the magic bytes for
/// raw LLVM IR bitcode (without a wrapper).
///
//<editor-fold defaultstate="collapsed" desc="llvm::isRawBitcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 130,
 FQN="llvm::isRawBitcode", NM="_ZN4llvm12isRawBitcodeEPKhS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_ZN4llvm12isRawBitcodeEPKhS1_")
//</editor-fold>
public static /*inline*/ boolean isRawBitcode(/*const*/char$ptr/*uchar P*/ BufPtr, 
            /*const*/char$ptr/*uchar P*/ BufEnd) {
  // These bytes sort of have a hidden message, but it's not in
  // little-endian this time, and it's a little redundant.
  return $noteq_ptr(BufPtr, BufEnd)
     && $uchar2int(BufPtr.$at(0)) == $$B
     && $uchar2int(BufPtr.$at(1)) == $$C
     && $uchar2int(BufPtr.$at(2)) == 0xc0
     && $uchar2int(BufPtr.$at(3)) == 0xde;
}


/// isBitcode - Return true if the given bytes are the magic bytes for
/// LLVM IR bitcode, either with or without a wrapper.
///
//<editor-fold defaultstate="collapsed" desc="llvm::isBitcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 144,
 FQN="llvm::isBitcode", NM="_ZN4llvm9isBitcodeEPKhS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_ZN4llvm9isBitcodeEPKhS1_")
//</editor-fold>
public static /*inline*/ boolean isBitcode(/*const*/char$ptr/*uchar P*/ BufPtr, 
         /*const*/char$ptr/*uchar P*/ BufEnd) {
  return ReaderWriterLlvmGlobals.isBitcodeWrapper(BufPtr, BufEnd)
     || ReaderWriterLlvmGlobals.isRawBitcode(BufPtr, BufEnd);
}


/// SkipBitcodeWrapperHeader - Some systems wrap bc files with a special
/// header for padding or other reasons.  The format of this header is:
///
/// struct bc_header {
///   uint32_t Magic;         // 0x0B17C0DE
///   uint32_t Version;       // Version, currently always 0.
///   uint32_t BitcodeOffset; // Offset to traditional bitcode file.
///   uint32_t BitcodeSize;   // Size of traditional bitcode file.
///   ... potentially other gunk ...
/// };
///
/// This function is called when we find a file with a matching magic number.
/// In this case, skip down to the subsection of the file that is actually a
/// BC file.
/// If 'VerifyBufferSize' is true, check that the buffer is large enough to
/// contain the whole bitcode file.
//<editor-fold defaultstate="collapsed" desc="llvm::SkipBitcodeWrapperHeader">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 166,
 FQN="llvm::SkipBitcodeWrapperHeader", NM="_ZN4llvm24SkipBitcodeWrapperHeaderERPKhS2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_ZN4llvm24SkipBitcodeWrapperHeaderERPKhS2_b")
//</editor-fold>
public static /*inline*/ boolean SkipBitcodeWrapperHeader(final char$ptr/*const uchar P&*/ BufPtr, 
                        final char$ptr/*const uchar P&*/ BufEnd, 
                        boolean VerifyBufferSize) {
  // Must contain the offset and size field!
  if ($less_uint(((/*uint*/int)(BufEnd.$sub(BufPtr))), BitcodeLlvmGlobals.BWH_SizeField + 4)) {
    return true;
  }
  
  /*uint*/int Offset = endian.read32le(BufPtr.$add(BitcodeLlvmGlobals.BWH_OffsetField));
  /*uint*/int Size = endian.read32le(BufPtr.$add(BitcodeLlvmGlobals.BWH_SizeField));
  long/*uint64_t*/ BitcodeOffsetEnd = Offset + Size;
  
  // Verify that Offset+Size fits in the file.
  if (VerifyBufferSize && $greater_ulong(BitcodeOffsetEnd, ((long/*uint64_t*/)($int2ulong(BufEnd.$sub(BufPtr)))))) {
    return true;
  }
  BufPtr.$inc(Offset);
  BufEnd.$assign(BufPtr.$add(Size));
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::make_error_code">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 187,
 FQN="llvm::make_error_code", NM="_ZN4llvm15make_error_codeENS_12BitcodeErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_ZN4llvm15make_error_codeENS_12BitcodeErrorE")
//</editor-fold>
public static /*inline*/ std.error_code make_error_code(BitcodeError E) {
  return new std.error_code(((/*static_cast*/int)E.getValue()), BitcodeReaderLlvmGlobals.BitcodeErrorCategory());
}

} // END OF class ReaderWriterLlvmGlobals
