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
package org.llvm.support.zlib;

import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.clank.support.*;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.*;
import static org.llvm.support.impl.CompressionStatics.encodeZlibCompressionLevel;


//<editor-fold defaultstate="collapsed" desc="static type ZlibGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.zlib.ZlibGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Compression.cpp -nm=_ZN4llvm4zlib10uncompressENS_9StringRefERNS_15SmallVectorImplIcEEj;_ZN4llvm4zlib11isAvailableEv;_ZN4llvm4zlib5crc32ENS_9StringRefE;_ZN4llvm4zlib8compressENS_9StringRefERNS_15SmallVectorImplIcEENS0_16CompressionLevelE; -static-type=ZlibGlobals -package=org.llvm.support.zlib")
//</editor-fold>
public final class ZlibGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::zlib::isAvailable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Compression.cpp", line = 48,
 FQN="llvm::zlib::isAvailable", NM="_ZN4llvm4zlib11isAvailableEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Compression.cpp -nm=_ZN4llvm4zlib11isAvailableEv")
//</editor-fold>
public static boolean isAvailable() {
  return true;
}

//<editor-fold defaultstate="collapsed" desc="llvm::zlib::compress">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/Compression.cpp", line = 49,
 FQN="llvm::zlib::compress", NM="_ZN4llvm4zlib8compressENS_9StringRefERNS_15SmallVectorImplIcEENS0_16CompressionLevelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Compression.cpp -nm=_ZN4llvm4zlib8compressENS_9StringRefERNS_15SmallVectorImplIcEENS0_16CompressionLevelE")
//</editor-fold>
public static Status compress(StringRef InputBuffer, 
        final SmallString/*&*/ CompressedBuffer) {
  return compress(InputBuffer, 
        CompressedBuffer, 
        CompressionLevel.DefaultCompression);
}
  public static Status compress(StringRef InputBuffer,
          final SmallString/*&*/ CompressedBuffer,
          CompressionLevel aLevel/*= DefaultCompression*/) {
    java.util.zip.Deflater compresser = new java.util.zip.Deflater(encodeZlibCompressionLevel(aLevel));
    final char$ptr data = InputBuffer.data();
    compresser.setInput(data.$array(), data.$index(), InputBuffer.size());
    compresser.finish();
    byte[] buffer = new byte[1024];
    while (!compresser.finished()) {
      int count = compresser.deflate(buffer);
      CompressedBuffer.append(buffer, 0, count);
    }
    compresser.end();
    return Status.StatusOK;
//  ulong$ptr CompressedSize = create_ulong$ptr(/*::*/compressBound(InputBuffer.size()));
//  CompressedBuffer.resize(CompressedSize.$star());
//  int CLevel = encodeZlibCompressionLevel(Level);
//  Status Res = encodeZlibReturnValue(/*::*/compress2(reinterpret_cast(char$ptr/*uchar P*/ .class, CompressedBuffer.data()), $AddrOf(CompressedSize), 
//          reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, InputBuffer.data()), InputBuffer.size(), CLevel));
//  CompressedBuffer.resize(CompressedSize.$star());
//  return Res;
}

//<editor-fold defaultstate="collapsed" desc="llvm::zlib::uncompress">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/Compression.cpp", line = 65,
 FQN="llvm::zlib::uncompress", NM="_ZN4llvm4zlib10uncompressENS_9StringRefERNS_15SmallVectorImplIcEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Compression.cpp -nm=_ZN4llvm4zlib10uncompressENS_9StringRefERNS_15SmallVectorImplIcEEj")
//</editor-fold>
public static Status uncompress(StringRef InputBuffer,
          final SmallString/*&*/ UncompressedBuffer,
          /*size_t*/ int UncompressedSize) {
    UncompressedBuffer.resize(UncompressedSize);
    java.util.zip.Inflater decompresser = new Inflater();
    final char$ptr data = InputBuffer.data();
    decompresser.setInput(data.$array(), data.$index(), InputBuffer.size());

    // use buffer from passed UncompressedBuffer 
    byte[] buffer = UncompressedBuffer.$array();
    int off = 0;
    int len = UncompressedSize;
    while (!decompresser.finished()) {
      try {
        int count = decompresser.inflate(buffer, off, len);
        off += count;
        len -= count;
      } catch (DataFormatException ex) {
        Logger.getLogger(ZlibGlobals.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    decompresser.end();
    return Status.StatusOK;
//  UncompressedBuffer.resize(UncompressedSize.$star());
//  Status Res = encodeZlibReturnValue(/*::*/uncompress(reinterpret_cast(char$ptr/*uchar P*/ .class, UncompressedBuffer.data()), reinterpret_cast(/*ulong*/long/*P*/ .class, $AddrOf(UncompressedSize)), 
//          reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, InputBuffer.data()), InputBuffer.size()));
//  UncompressedBuffer.resize(UncompressedSize.$star());
//  return Res;
}

//<editor-fold defaultstate="collapsed" desc="llvm::zlib::crc32">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/Compression.cpp", line = 79,
 FQN="llvm::zlib::crc32", NM="_ZN4llvm4zlib5crc32ENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Compression.cpp -nm=_ZN4llvm4zlib5crc32ENS_9StringRefE")
//</editor-fold>
public static /*uint32_t*/int crc32(StringRef Buffer) {
  java.util.zip.CRC32 crc = new CRC32();
  crc.update(Buffer.data().$array());
  return (int)crc.getValue();
  //return /*::*/crc32(0, reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buffer.data()), Buffer.size());
}

} // END OF class ZlibGlobals
