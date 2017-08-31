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

package org.clang.lex;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.lex.*;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.aligned;
import static org.llvm.support.llvm.support.endianness.little;

//<editor-fold defaultstate="collapsed" desc="clang::HMapHeader">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cast*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMapTypes.h", line = 29,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", old_line = 44,
 FQN="clang::HMapHeader", NM="_ZN5clang10HMapHeaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang10HMapHeaderE")
//</editor-fold>
public class/*struct*/ HMapHeader {
  // JAVA: changed fields to be final for emulation of reinterpret_cast implementation
  public final /*uint32_t*/int Magic; // Magic word, also indicates byte order.
  public final /*uint16_t*/char Version; // Version number -- currently 1.
  public final /*uint16_t*/char Reserved; // Reserved for future use - zero for now.
  public final /*uint32_t*/int StringsOffset; // Offset to start of string pool.
  public final /*uint32_t*/int NumEntries; // Number of entries in the string table.
  public final /*uint32_t*/int NumBuckets; // Number of buckets (always a power of 2).
  public final /*uint32_t*/int MaxValueLength; // Length of longest result path (excluding nul).
  // An array of 'NumBuckets' HMapBucket objects follows this header.
  // Strings follow the buckets, at StringsOffset.
  
  public String toString() {
    return "" + "Magic=" + Magic // NOI18N
              + ", Version=" + Version // NOI18N
              + ", Reserved=" + Reserved // NOI18N
              + ", StringsOffset=" + StringsOffset // NOI18N
              + ", NumEntries=" + NumEntries // NOI18N
              + ", NumBuckets=" + NumBuckets // NOI18N
              + ", MaxValueLength=" + MaxValueLength; // NOI18N
  }
  
  // JAVA: introduce sizeof
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static /*size_t*/int $sizeof_HMapHeader() {
    return NativeType.sizeof$uint32() +
           NativeType.sizeof$uint16() +
           NativeType.sizeof$uint16() +
           NativeType.sizeof$uint32() + 
           NativeType.sizeof$uint32() + 
           NativeType.sizeof$uint32() + 
           NativeType.sizeof$uint32();
  }
  
  // JAVA: introduce reinterpret_cast
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static HMapHeader reinterpret_cast(/*const*/char$ptr/*char P*/ Buf) {
    // JAVA: partial impl by making all fields final
    // TODO: we need to hide fields and get directly from the buffer, but let's return instance for now
    NativeTrace.traceNotImplemented("HMapHeader.reinterpret_cast");
    return new HMapHeader(Buf);
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private HMapHeader(char$ptr Buf) {
    char$ptr ReadFrom = $tryClone(Buf);
    endianness endian = little;
    this.Magic = llvm.support.endian.readNext_uint32(endian, aligned, ReadFrom);
    this.Version = llvm.support.endian.readNext_uint16(endian, aligned, ReadFrom);
    this.Reserved = llvm.support.endian.readNext_uint16(endian, aligned, ReadFrom);
    this.StringsOffset = llvm.support.endian.readNext_uint32(endian, aligned, ReadFrom);
    this.NumEntries = llvm.support.endian.readNext_uint32(endian, aligned, ReadFrom);
    this.NumBuckets = llvm.support.endian.readNext_uint32(endian, aligned, ReadFrom);
    this.MaxValueLength = llvm.support.endian.readNext_uint32(endian, aligned, ReadFrom);
  }
}
