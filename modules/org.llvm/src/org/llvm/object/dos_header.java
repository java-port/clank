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


/// The DOS compatible header at the front of all PE/COFF executables.
//<editor-fold defaultstate="collapsed" desc="llvm::object::dos_header">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 40,
 FQN="llvm::object::dos_header", NM="_ZN4llvm6object10dos_headerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object10dos_headerE")
//</editor-fold>
public class/*struct*/ dos_header {
  public /*char*/byte Magic[/*2*/] = new$char(2);
  public llvm.support.ulittle16_t UsedBytesInTheLastPage;
  public llvm.support.ulittle16_t FileSizeInPages;
  public llvm.support.ulittle16_t NumberOfRelocationItems;
  public llvm.support.ulittle16_t HeaderSizeInParagraphs;
  public llvm.support.ulittle16_t MinimumExtraParagraphs;
  public llvm.support.ulittle16_t MaximumExtraParagraphs;
  public llvm.support.ulittle16_t InitialRelativeSS;
  public llvm.support.ulittle16_t InitialSP;
  public llvm.support.ulittle16_t Checksum;
  public llvm.support.ulittle16_t InitialIP;
  public llvm.support.ulittle16_t InitialRelativeCS;
  public llvm.support.ulittle16_t AddressOfRelocationTable;
  public llvm.support.ulittle16_t OverlayNumber;
  public llvm.support.ulittle16_t Reserved[/*4*/] = new llvm.support.ulittle16_t [4];
  public llvm.support.ulittle16_t OEMid;
  public llvm.support.ulittle16_t OEMinfo;
  public llvm.support.ulittle16_t Reserved2[/*10*/] = new llvm.support.ulittle16_t [10];
  public llvm.support.ulittle32_t AddressOfNewExeHeader;
  
  @Override public String toString() {
    return "" + "Magic=" + Magic // NOI18N
              + ", UsedBytesInTheLastPage=" + UsedBytesInTheLastPage // NOI18N
              + ", FileSizeInPages=" + FileSizeInPages // NOI18N
              + ", NumberOfRelocationItems=" + NumberOfRelocationItems // NOI18N
              + ", HeaderSizeInParagraphs=" + HeaderSizeInParagraphs // NOI18N
              + ", MinimumExtraParagraphs=" + MinimumExtraParagraphs // NOI18N
              + ", MaximumExtraParagraphs=" + MaximumExtraParagraphs // NOI18N
              + ", InitialRelativeSS=" + InitialRelativeSS // NOI18N
              + ", InitialSP=" + InitialSP // NOI18N
              + ", Checksum=" + Checksum // NOI18N
              + ", InitialIP=" + InitialIP // NOI18N
              + ", InitialRelativeCS=" + InitialRelativeCS // NOI18N
              + ", AddressOfRelocationTable=" + AddressOfRelocationTable // NOI18N
              + ", OverlayNumber=" + OverlayNumber // NOI18N
              + ", Reserved=" + Reserved // NOI18N
              + ", OEMid=" + OEMid // NOI18N
              + ", OEMinfo=" + OEMinfo // NOI18N
              + ", Reserved2=" + Reserved2 // NOI18N
              + ", AddressOfNewExeHeader=" + AddressOfNewExeHeader; // NOI18N
  }
}
