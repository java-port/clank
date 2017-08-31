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

package org.llvm.object;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;;


/// The 32-bit PE header that follows the COFF header.
//<editor-fold defaultstate="collapsed" desc="llvm::object::pe32_header">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 91,
 FQN="llvm::object::pe32_header", NM="_ZN4llvm6object11pe32_headerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object11pe32_headerE")
//</editor-fold>
public class/*struct*/ pe32_header {
  public llvm.support.ulittle16_t Magic;
  public byte/*uint8_t*/ MajorLinkerVersion;
  public byte/*uint8_t*/ MinorLinkerVersion;
  public llvm.support.ulittle32_t SizeOfCode;
  public llvm.support.ulittle32_t SizeOfInitializedData;
  public llvm.support.ulittle32_t SizeOfUninitializedData;
  public llvm.support.ulittle32_t AddressOfEntryPoint;
  public llvm.support.ulittle32_t BaseOfCode;
  public llvm.support.ulittle32_t BaseOfData;
  public llvm.support.ulittle32_t ImageBase;
  public llvm.support.ulittle32_t SectionAlignment;
  public llvm.support.ulittle32_t FileAlignment;
  public llvm.support.ulittle16_t MajorOperatingSystemVersion;
  public llvm.support.ulittle16_t MinorOperatingSystemVersion;
  public llvm.support.ulittle16_t MajorImageVersion;
  public llvm.support.ulittle16_t MinorImageVersion;
  public llvm.support.ulittle16_t MajorSubsystemVersion;
  public llvm.support.ulittle16_t MinorSubsystemVersion;
  public llvm.support.ulittle32_t Win32VersionValue;
  public llvm.support.ulittle32_t SizeOfImage;
  public llvm.support.ulittle32_t SizeOfHeaders;
  public llvm.support.ulittle32_t CheckSum;
  public llvm.support.ulittle16_t Subsystem;
  // FIXME: This should be DllCharacteristics.
  public llvm.support.ulittle16_t DLLCharacteristics;
  public llvm.support.ulittle32_t SizeOfStackReserve;
  public llvm.support.ulittle32_t SizeOfStackCommit;
  public llvm.support.ulittle32_t SizeOfHeapReserve;
  public llvm.support.ulittle32_t SizeOfHeapCommit;
  public llvm.support.ulittle32_t LoaderFlags;
  // FIXME: This should be NumberOfRvaAndSizes.
  public llvm.support.ulittle32_t NumberOfRvaAndSize;
  
  @Override public String toString() {
    return "" + "Magic=" + Magic // NOI18N
              + ", MajorLinkerVersion=" + $uchar2uint(MajorLinkerVersion) // NOI18N
              + ", MinorLinkerVersion=" + $uchar2uint(MinorLinkerVersion) // NOI18N
              + ", SizeOfCode=" + SizeOfCode // NOI18N
              + ", SizeOfInitializedData=" + SizeOfInitializedData // NOI18N
              + ", SizeOfUninitializedData=" + SizeOfUninitializedData // NOI18N
              + ", AddressOfEntryPoint=" + AddressOfEntryPoint // NOI18N
              + ", BaseOfCode=" + BaseOfCode // NOI18N
              + ", BaseOfData=" + BaseOfData // NOI18N
              + ", ImageBase=" + ImageBase // NOI18N
              + ", SectionAlignment=" + SectionAlignment // NOI18N
              + ", FileAlignment=" + FileAlignment // NOI18N
              + ", MajorOperatingSystemVersion=" + MajorOperatingSystemVersion // NOI18N
              + ", MinorOperatingSystemVersion=" + MinorOperatingSystemVersion // NOI18N
              + ", MajorImageVersion=" + MajorImageVersion // NOI18N
              + ", MinorImageVersion=" + MinorImageVersion // NOI18N
              + ", MajorSubsystemVersion=" + MajorSubsystemVersion // NOI18N
              + ", MinorSubsystemVersion=" + MinorSubsystemVersion // NOI18N
              + ", Win32VersionValue=" + Win32VersionValue // NOI18N
              + ", SizeOfImage=" + SizeOfImage // NOI18N
              + ", SizeOfHeaders=" + SizeOfHeaders // NOI18N
              + ", CheckSum=" + CheckSum // NOI18N
              + ", Subsystem=" + Subsystem // NOI18N
              + ", DLLCharacteristics=" + DLLCharacteristics // NOI18N
              + ", SizeOfStackReserve=" + SizeOfStackReserve // NOI18N
              + ", SizeOfStackCommit=" + SizeOfStackCommit // NOI18N
              + ", SizeOfHeapReserve=" + SizeOfHeapReserve // NOI18N
              + ", SizeOfHeapCommit=" + SizeOfHeapCommit // NOI18N
              + ", LoaderFlags=" + LoaderFlags // NOI18N
              + ", NumberOfRvaAndSize=" + NumberOfRvaAndSize; // NOI18N
  }
}
