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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.lex.*;
import static org.llvm.support.llvm.support.aligned;
import static org.llvm.support.llvm.support.endianness.little;

//<editor-fold defaultstate="collapsed" desc="clang::HMapBucket">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*reinterpret_cast*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMapTypes.h", line = 23,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", old_line = 37,
 FQN="clang::HMapBucket", NM="_ZN5clang10HMapBucketE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang10HMapBucketE")
//</editor-fold>
public class/*struct*/ HMapBucket {
  public /*uint32_t*/int Key; // Offset (into strings) of key.
  public /*uint32_t*/int Prefix; // Offset (into strings) of value prefix.
  public /*uint32_t*/int Suffix; // Offset (into strings) of value suffix.
  //<editor-fold defaultstate="collapsed" desc="clang::HMapBucket::HMapBucket">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMapTypes.h", line = 23,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", old_line = 37,
   FQN="clang::HMapBucket::HMapBucket", NM="_ZN5clang10HMapBucketC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang10HMapBucketC1Ev")
  //</editor-fold>
  public /*inline*/ HMapBucket() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HMapBucket::HMapBucket">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMapTypes.h", line = 23,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", old_line = 37,
   FQN="clang::HMapBucket::HMapBucket", NM="_ZN5clang10HMapBucketC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang10HMapBucketC1EOS0_")
  //</editor-fold>
  public /*inline*/ HMapBucket(JD$Move _dparam, HMapBucket /*&&*/$Prm0) {
    /* : Key(static_cast<HMapBucket &&>().Key), Prefix(static_cast<HMapBucket &&>().Prefix), Suffix(static_cast<HMapBucket &&>().Suffix)*/ 
    //START JInit
    this.Key = $Prm0.Key;
    this.Prefix = $Prm0.Prefix;
    this.Suffix = $Prm0.Suffix;
    //END JInit
  }

  
  public String toString() {
    return "" + "Key=" + Key // NOI18N
              + ", Prefix=" + Prefix // NOI18N
              + ", Suffix=" + Suffix; // NOI18N
  }
  
  // JAVA: introduce sizeof
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static /*size_t*/int $sizeof_HMapBucket() {
    return NativeType.sizeof$uint32() +
           NativeType.sizeof$uint32() + 
           NativeType.sizeof$uint32();
  }
  
  // JAVA: introduce reinterpret_cast
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static HMapBucket reinterpret_cast(/*const*/char$ptr/*char P*/ Buf) {
    // JAVA: partial impl
    // TODO: we need to hide fields and get directly from the buffer, but let's return instance for now
    NativeTrace.traceNotImplemented("HMapBucket.reinterpret_cast");
    return new HMapBucket(Buf);
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private HMapBucket(char$ptr Buf) {
    char$ptr ReadFrom = $tryClone(Buf);
    llvm.support.endianness endian = little;
    this.Key = llvm.support.endian.readNext_uint32(endian, aligned, ReadFrom);
    this.Prefix = llvm.support.endian.readNext_uint32(endian, aligned, ReadFrom);
    this.Suffix = llvm.support.endian.readNext_uint32(endian, aligned, ReadFrom);
  }
}
