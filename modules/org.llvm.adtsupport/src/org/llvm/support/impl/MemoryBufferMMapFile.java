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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.support.sys.fs;

/// \brief Memory maps a file descriptor using sys::fs::mapped_file_region.
///
/// This handles converting the offset into a legal offset on the platform.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemoryBufferMMapFile">
@Converted(kind = Converted.Kind.MANUAL_NON_JAVA, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 190,
 old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 189,
 FQN = "(anonymous namespace)::MemoryBufferMMapFile", NM = "_ZN12_GLOBAL__N_120MemoryBufferMMapFileE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN12_GLOBAL__N_120MemoryBufferMMapFileE")
//</editor-fold>
public class MemoryBufferMMapFile extends /*public*/ MemoryBuffer implements Destructors.ClassWithDestructor {
  private fs.mapped_file_region MFR;
  // JAVA: introduced field to replace (this+1)
  private final char$ptr bufferIdentifier;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemoryBufferMMapFile::getLegalMapOffset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 193,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 192,
   FQN = "(anonymous namespace)::MemoryBufferMMapFile::getLegalMapOffset", NM = "_ZN12_GLOBAL__N_120MemoryBufferMMapFile17getLegalMapOffsetEy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN12_GLOBAL__N_120MemoryBufferMMapFile17getLegalMapOffsetEy")
  //</editor-fold>
  private static long/*uint64_t*/ getLegalMapOffset(long/*uint64_t*/ Offset) {
    return Offset & ~(fs.mapped_file_region.alignment() - 1);
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemoryBufferMMapFile::getLegalMapSize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 197,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 196,
   FQN = "(anonymous namespace)::MemoryBufferMMapFile::getLegalMapSize", NM = "_ZN12_GLOBAL__N_120MemoryBufferMMapFile15getLegalMapSizeEyy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN12_GLOBAL__N_120MemoryBufferMMapFile15getLegalMapSizeEyy")
  //</editor-fold>
  private static long/*uint64_t*/ getLegalMapSize(long/*uint64_t*/ Len, long/*uint64_t*/ Offset) {
    return Len + (Offset - getLegalMapOffset(Offset));
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemoryBufferMMapFile::getStart">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 201,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 200,
   FQN = "(anonymous namespace)::MemoryBufferMMapFile::getStart", NM = "_ZN12_GLOBAL__N_120MemoryBufferMMapFile8getStartEyy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN12_GLOBAL__N_120MemoryBufferMMapFile8getStartEyy")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ getStart(long/*uint64_t*/ Len, long/*uint64_t*/ Offset) {
    return MFR.const_data().$add($long2uint(Offset - getLegalMapOffset(Offset)));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemoryBufferMMapFile::MemoryBufferMMapFile">
  @Converted(kind = Converted.Kind.MANUAL_NON_JAVA, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 206,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 205,
   FQN = "(anonymous namespace)::MemoryBufferMMapFile::MemoryBufferMMapFile", NM = "_ZN12_GLOBAL__N_120MemoryBufferMMapFileC1EbiyyRSt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN12_GLOBAL__N_120MemoryBufferMMapFileC1EbiyyRSt10error_code")
  //</editor-fold>
  public MemoryBufferMMapFile(/*const*/ char$ptr /*&*/ Filename, boolean RequiresNullTerminator, int FD, long/*uint64_t*/ Len,
      long/*uint64_t*/ Offset, std.error_code /*&*/ EC) {
    /* : MemoryBuffer(), MFR(FD, fs::mapped_file_region::readonly, getLegalMapSize(Len, Offset), getLegalMapOffset(Offset), EC)*/
    //START JInit
    super();
    this.MFR = new fs.mapped_file_region(FD, fs.mapped_file_region.mapmode.readonly, getLegalMapSize(Len, Offset), getLegalMapOffset(Offset), EC);
    //END JInit
    if (!EC.$bool()) {
      /*const*/char$ptr/*char P*/ Start = getStart(Len, Offset);
      init(Start, Start.$add($long2uint(Len)), RequiresNullTerminator);
      // JAVA: we close mapped file here to not keep opened file descriptors
      MFR.$destroy();
    }
    // JAVA: introduced field to replace (this+1)
    this.bufferIdentifier = $toConst(Filename);
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemoryBufferMMapFile::getBufferIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_NON_JAVA, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 216,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 215,
   FQN = "(anonymous namespace)::MemoryBufferMMapFile::getBufferIdentifier", NM = "_ZNK12_GLOBAL__N_120MemoryBufferMMapFile19getBufferIdentifierEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK12_GLOBAL__N_120MemoryBufferMMapFile19getBufferIdentifierEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getBufferIdentifier() /*const*//* override*/ {
    // The name is stored after the class itself.
    return bufferIdentifier;
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemoryBufferMMapFile::getBufferKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 221,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 220,
   FQN = "(anonymous namespace)::MemoryBufferMMapFile::getBufferKind", NM = "_ZNK12_GLOBAL__N_120MemoryBufferMMapFile13getBufferKindEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNK12_GLOBAL__N_120MemoryBufferMMapFile13getBufferKindEv")
  //</editor-fold>
  @Override public BufferKind getBufferKind() /*const*//* override*/ {
    return BufferKind.MemoryBuffer_MMap;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemoryBufferMMapFile::~MemoryBufferMMapFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", line = 190,
   old_source = "${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp", old_line = 189,
   FQN = "(anonymous namespace)::MemoryBufferMMapFile::~MemoryBufferMMapFile", NM = "_ZN12_GLOBAL__N_120MemoryBufferMMapFileD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZN12_GLOBAL__N_120MemoryBufferMMapFileD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    // MFR.$destroy(); JAVA: we closed it already in constructor not to keep extra opened file handlers
    super.$destroy();
    //END JDestroy
  }


  public String toString() {
    return super.toString() + ", MFR=" + MFR; // NOI18N
  }
}
