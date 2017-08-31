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
import org.llvm.object.*;
import org.llvm.llvmc.*;
import org.llvm.java.LlvmFunctionPointers.*;
import org.llvm.java.LlvmJavaDifferentiators.*;
import org.llvm.debuginfo.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;
import org.llvm.mc.*;
import org.llvm.support.sys.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 187,
 FQN="llvm::object::MachOObjectFile", NM="_ZN4llvm6object15MachOObjectFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFileE")
//</editor-fold>
public class MachOObjectFile extends /*public*/ ObjectFile implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::LoadCommandInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 189,
   FQN="llvm::object::MachOObjectFile::LoadCommandInfo", NM="_ZN4llvm6object15MachOObjectFile15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile15LoadCommandInfoE")
  //</editor-fold>
  public static class/*struct*/ LoadCommandInfo {
    public /*const*/char$ptr/*char P*/ Ptr; // Where in memory the load command is.
    public MachO.load_command C; // The command itself.
    
    @Override public String toString() {
      return "" + "Ptr=" + Ptr // NOI18N
                + ", C=" + C; // NOI18N
    }
  };
  // JAVA: typedef SmallVector<LoadCommandInfo, 4> LoadCommandList
//  public final class LoadCommandList extends SmallVector<LoadCommandInfo>{ };
  // JAVA: typedef LoadCommandList::const_iterator load_command_iterator
//  public final class load_command_iterator extends type$ptr</*const*/ LoadCommandInfo /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 196,
   FQN="llvm::object::MachOObjectFile::create", NM="_ZN4llvm6object15MachOObjectFile6createENS_15MemoryBufferRefEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile6createENS_15MemoryBufferRefEbb")
  //</editor-fold>
  public static Expected<std.unique_ptr<MachOObjectFile> > create(MemoryBufferRef Object, boolean IsLittleEndian, boolean Is64Bits) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::moveSymbolNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 199,
   FQN="llvm::object::MachOObjectFile::moveSymbolNext", NM="_ZNK4llvm6object15MachOObjectFile14moveSymbolNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile14moveSymbolNextERNS0_11DataRefImplE")
  //</editor-fold>
  @Override public void moveSymbolNext(final DataRefImpl /*&*/ Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getNValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 201,
   FQN="llvm::object::MachOObjectFile::getNValue", NM="_ZNK4llvm6object15MachOObjectFile9getNValueENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile9getNValueENS0_11DataRefImplE")
  //</editor-fold>
  public long/*uint64_t*/ getNValue(DataRefImpl Sym) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 202,
   FQN="llvm::object::MachOObjectFile::getSymbolName", NM="_ZNK4llvm6object15MachOObjectFile13getSymbolNameENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13getSymbolNameENS0_11DataRefImplE")
  //</editor-fold>
  @Override public Expected<StringRef> getSymbolName(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // MachO specific.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getIndirectName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 205,
   FQN="llvm::object::MachOObjectFile::getIndirectName", NM="_ZNK4llvm6object15MachOObjectFile15getIndirectNameENS0_11DataRefImplERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile15getIndirectNameENS0_11DataRefImplERNS_9StringRefE")
  //</editor-fold>
  public std.error_code getIndirectName(DataRefImpl Symb, final StringRef /*&*/ Res) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 206,
   FQN="llvm::object::MachOObjectFile::getSectionType", NM="_ZNK4llvm6object15MachOObjectFile14getSectionTypeENS0_10SectionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile14getSectionTypeENS0_10SectionRefE")
  //</editor-fold>
  public /*uint*/int getSectionType(SectionRef Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 208,
   FQN="llvm::object::MachOObjectFile::getSymbolAddress", NM="_ZNK4llvm6object15MachOObjectFile16getSymbolAddressENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile16getSymbolAddressENS0_11DataRefImplE")
  //</editor-fold>
  @Override public Expected<Long/*uint64_t*/> getSymbolAddress(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 209,
   FQN="llvm::object::MachOObjectFile::getSymbolAlignment", NM="_ZNK4llvm6object15MachOObjectFile18getSymbolAlignmentENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18getSymbolAlignmentENS0_11DataRefImplE")
  //</editor-fold>
  @Override public /*uint32_t*/int getSymbolAlignment(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getCommonSymbolSizeImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 210,
   FQN="llvm::object::MachOObjectFile::getCommonSymbolSizeImpl", NM="_ZNK4llvm6object15MachOObjectFile23getCommonSymbolSizeImplENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile23getCommonSymbolSizeImplENS0_11DataRefImplE")
  //</editor-fold>
  @Override public long/*uint64_t*/ getCommonSymbolSizeImpl(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 211,
   FQN="llvm::object::MachOObjectFile::getSymbolType", NM="_ZNK4llvm6object15MachOObjectFile13getSymbolTypeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13getSymbolTypeENS0_11DataRefImplE")
  //</editor-fold>
  @Override public Expected<SymbolRef.Type> getSymbolType(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 212,
   FQN="llvm::object::MachOObjectFile::getSymbolFlags", NM="_ZNK4llvm6object15MachOObjectFile14getSymbolFlagsENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile14getSymbolFlagsENS0_11DataRefImplE")
  //</editor-fold>
  @Override public /*uint32_t*/int getSymbolFlags(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 213,
   FQN="llvm::object::MachOObjectFile::getSymbolSection", NM="_ZNK4llvm6object15MachOObjectFile16getSymbolSectionENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile16getSymbolSectionENS0_11DataRefImplE")
  //</editor-fold>
  @Override public Expected<content_iterator<SectionRef> > getSymbolSection(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolSectionID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 214,
   FQN="llvm::object::MachOObjectFile::getSymbolSectionID", NM="_ZNK4llvm6object15MachOObjectFile18getSymbolSectionIDENS0_9SymbolRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18getSymbolSectionIDENS0_9SymbolRefE")
  //</editor-fold>
  public /*uint*/int getSymbolSectionID(SymbolRef Symb) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 215,
   FQN="llvm::object::MachOObjectFile::getSectionID", NM="_ZNK4llvm6object15MachOObjectFile12getSectionIDENS0_10SectionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile12getSectionIDENS0_10SectionRefE")
  //</editor-fold>
  public /*uint*/int getSectionID(SectionRef Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::moveSectionNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 217,
   FQN="llvm::object::MachOObjectFile::moveSectionNext", NM="_ZNK4llvm6object15MachOObjectFile15moveSectionNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile15moveSectionNextERNS0_11DataRefImplE")
  //</editor-fold>
  @Override public void moveSectionNext(final DataRefImpl /*&*/ Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 218,
   FQN="llvm::object::MachOObjectFile::getSectionName", NM="_ZNK4llvm6object15MachOObjectFile14getSectionNameENS0_11DataRefImplERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile14getSectionNameENS0_11DataRefImplERNS_9StringRefE")
  //</editor-fold>
  @Override public std.error_code getSectionName(DataRefImpl Sec, 
                final StringRef /*&*/ Res) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 220,
   FQN="llvm::object::MachOObjectFile::getSectionAddress", NM="_ZNK4llvm6object15MachOObjectFile17getSectionAddressENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17getSectionAddressENS0_11DataRefImplE")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSectionAddress(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 221,
   FQN="llvm::object::MachOObjectFile::getSectionSize", NM="_ZNK4llvm6object15MachOObjectFile14getSectionSizeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile14getSectionSizeENS0_11DataRefImplE")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSectionSize(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionContents">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 222,
   FQN="llvm::object::MachOObjectFile::getSectionContents", NM="_ZNK4llvm6object15MachOObjectFile18getSectionContentsENS0_11DataRefImplERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18getSectionContentsENS0_11DataRefImplERNS_9StringRefE")
  //</editor-fold>
  @Override public std.error_code getSectionContents(DataRefImpl Sec, 
                    final StringRef /*&*/ Res) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 224,
   FQN="llvm::object::MachOObjectFile::getSectionAlignment", NM="_ZNK4llvm6object15MachOObjectFile19getSectionAlignmentENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19getSectionAlignmentENS0_11DataRefImplE")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSectionAlignment(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isSectionCompressed">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 225,
   FQN="llvm::object::MachOObjectFile::isSectionCompressed", NM="_ZNK4llvm6object15MachOObjectFile19isSectionCompressedENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19isSectionCompressedENS0_11DataRefImplE")
  //</editor-fold>
  @Override public boolean isSectionCompressed(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isSectionText">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 226,
   FQN="llvm::object::MachOObjectFile::isSectionText", NM="_ZNK4llvm6object15MachOObjectFile13isSectionTextENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13isSectionTextENS0_11DataRefImplE")
  //</editor-fold>
  @Override public boolean isSectionText(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isSectionData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 227,
   FQN="llvm::object::MachOObjectFile::isSectionData", NM="_ZNK4llvm6object15MachOObjectFile13isSectionDataENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13isSectionDataENS0_11DataRefImplE")
  //</editor-fold>
  @Override public boolean isSectionData(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isSectionBSS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 228,
   FQN="llvm::object::MachOObjectFile::isSectionBSS", NM="_ZNK4llvm6object15MachOObjectFile12isSectionBSSENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile12isSectionBSSENS0_11DataRefImplE")
  //</editor-fold>
  @Override public boolean isSectionBSS(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isSectionVirtual">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 229,
   FQN="llvm::object::MachOObjectFile::isSectionVirtual", NM="_ZNK4llvm6object15MachOObjectFile16isSectionVirtualENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile16isSectionVirtualENS0_11DataRefImplE")
  //</editor-fold>
  @Override public boolean isSectionVirtual(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isSectionBitcode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 230,
   FQN="llvm::object::MachOObjectFile::isSectionBitcode", NM="_ZNK4llvm6object15MachOObjectFile16isSectionBitcodeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile16isSectionBitcodeENS0_11DataRefImplE")
  //</editor-fold>
  @Override public boolean isSectionBitcode(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::section_rel_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 231,
   FQN="llvm::object::MachOObjectFile::section_rel_begin", NM="_ZNK4llvm6object15MachOObjectFile17section_rel_beginENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17section_rel_beginENS0_11DataRefImplE")
  //</editor-fold>
  @Override public content_iterator<RelocationRef> section_rel_begin(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::section_rel_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 232,
   FQN="llvm::object::MachOObjectFile::section_rel_end", NM="_ZNK4llvm6object15MachOObjectFile15section_rel_endENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile15section_rel_endENS0_11DataRefImplE")
  //</editor-fold>
  @Override public content_iterator<RelocationRef> section_rel_end(DataRefImpl Sec) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::moveRelocationNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 234,
   FQN="llvm::object::MachOObjectFile::moveRelocationNext", NM="_ZNK4llvm6object15MachOObjectFile18moveRelocationNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18moveRelocationNextERNS0_11DataRefImplE")
  //</editor-fold>
  @Override public void moveRelocationNext(final DataRefImpl /*&*/ Rel) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRelocationOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 235,
   FQN="llvm::object::MachOObjectFile::getRelocationOffset", NM="_ZNK4llvm6object15MachOObjectFile19getRelocationOffsetENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19getRelocationOffsetENS0_11DataRefImplE")
  //</editor-fold>
  @Override public long/*uint64_t*/ getRelocationOffset(DataRefImpl Rel) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRelocationSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 236,
   FQN="llvm::object::MachOObjectFile::getRelocationSymbol", NM="_ZNK4llvm6object15MachOObjectFile19getRelocationSymbolENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19getRelocationSymbolENS0_11DataRefImplE")
  //</editor-fold>
  @Override public symbol_iterator getRelocationSymbol(DataRefImpl Rel) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRelocationSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 237,
   FQN="llvm::object::MachOObjectFile::getRelocationSection", NM="_ZNK4llvm6object15MachOObjectFile20getRelocationSectionENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile20getRelocationSectionENS0_11DataRefImplE")
  //</editor-fold>
  public content_iterator<SectionRef> getRelocationSection(DataRefImpl Rel) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRelocationType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 238,
   FQN="llvm::object::MachOObjectFile::getRelocationType", NM="_ZNK4llvm6object15MachOObjectFile17getRelocationTypeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17getRelocationTypeENS0_11DataRefImplE")
  //</editor-fold>
  @Override public long/*uint64_t*/ getRelocationType(DataRefImpl Rel) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRelocationTypeName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 239,
   FQN="llvm::object::MachOObjectFile::getRelocationTypeName", NM="_ZNK4llvm6object15MachOObjectFile21getRelocationTypeNameENS0_11DataRefImplERNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile21getRelocationTypeNameENS0_11DataRefImplERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  @Override public void getRelocationTypeName(DataRefImpl Rel, 
                       final SmallString/*&*/ Result) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRelocationLength">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 241,
   FQN="llvm::object::MachOObjectFile::getRelocationLength", NM="_ZNK4llvm6object15MachOObjectFile19getRelocationLengthENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19getRelocationLengthENS0_11DataRefImplE")
  //</editor-fold>
  public byte/*uint8_t*/ getRelocationLength(DataRefImpl Rel) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // MachO specific.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getLibraryShortNameByIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 244,
   FQN="llvm::object::MachOObjectFile::getLibraryShortNameByIndex", NM="_ZNK4llvm6object15MachOObjectFile26getLibraryShortNameByIndexEjRNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getLibraryShortNameByIndexEjRNS_9StringRefE")
  //</editor-fold>
  public std.error_code getLibraryShortNameByIndex(/*uint*/int Index, final StringRef /*&*/ $Prm1) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRelocationRelocatedSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 246,
   FQN="llvm::object::MachOObjectFile::getRelocationRelocatedSection", NM="_ZNK4llvm6object15MachOObjectFile29getRelocationRelocatedSectionENS0_16content_iteratorINS0_13RelocationRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile29getRelocationRelocatedSectionENS0_16content_iteratorINS0_13RelocationRefEEE")
  //</editor-fold>
  public content_iterator<SectionRef> getRelocationRelocatedSection(content_iterator<RelocationRef> Rel) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // TODO: Would be useful to have an iterator based version
  // of the load command interface too.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::symbol_begin_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 251,
   FQN="llvm::object::MachOObjectFile::symbol_begin_impl", NM="_ZNK4llvm6object15MachOObjectFile17symbol_begin_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17symbol_begin_implEv")
  //</editor-fold>
  @Override public content_iterator<BasicSymbolRef> symbol_begin_impl() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::symbol_end_impl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 252,
   FQN="llvm::object::MachOObjectFile::symbol_end_impl", NM="_ZNK4llvm6object15MachOObjectFile15symbol_end_implEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile15symbol_end_implEv")
  //</editor-fold>
  @Override public content_iterator<BasicSymbolRef> symbol_end_impl() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // MachO specific.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolByIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 255,
   FQN="llvm::object::MachOObjectFile::getSymbolByIndex", NM="_ZNK4llvm6object15MachOObjectFile16getSymbolByIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile16getSymbolByIndexEj")
  //</editor-fold>
  public content_iterator<BasicSymbolRef> getSymbolByIndex(/*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 256,
   FQN="llvm::object::MachOObjectFile::getSymbolIndex", NM="_ZNK4llvm6object15MachOObjectFile14getSymbolIndexENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile14getSymbolIndexENS0_11DataRefImplE")
  //</editor-fold>
  public long/*uint64_t*/ getSymbolIndex(DataRefImpl Symb) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::section_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 258,
   FQN="llvm::object::MachOObjectFile::section_begin", NM="_ZNK4llvm6object15MachOObjectFile13section_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13section_beginEv")
  //</editor-fold>
  @Override public content_iterator<SectionRef> section_begin() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::section_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 259,
   FQN="llvm::object::MachOObjectFile::section_end", NM="_ZNK4llvm6object15MachOObjectFile11section_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile11section_endEv")
  //</editor-fold>
  @Override public content_iterator<SectionRef> section_end() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getBytesInAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 261,
   FQN="llvm::object::MachOObjectFile::getBytesInAddress", NM="_ZNK4llvm6object15MachOObjectFile17getBytesInAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17getBytesInAddressEv")
  //</editor-fold>
  @Override public byte/*uint8_t*/ getBytesInAddress() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getFileFormatName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 263,
   FQN="llvm::object::MachOObjectFile::getFileFormatName", NM="_ZNK4llvm6object15MachOObjectFile17getFileFormatNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17getFileFormatNameEv")
  //</editor-fold>
  @Override public StringRef getFileFormatName() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getArch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 264,
   FQN="llvm::object::MachOObjectFile::getArch", NM="_ZNK4llvm6object15MachOObjectFile7getArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile7getArchEv")
  //</editor-fold>
  @Override public /*uint*/int getArch() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getFeatures">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 265,
   FQN="llvm::object::MachOObjectFile::getFeatures", NM="_ZNK4llvm6object15MachOObjectFile11getFeaturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile11getFeaturesEv")
  //</editor-fold>
  @Override public SubtargetFeatures getFeatures() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getArchTriple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 266,
   FQN="llvm::object::MachOObjectFile::getArchTriple", NM="_ZNK4llvm6object15MachOObjectFile13getArchTripleEPPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13getArchTripleEPPKc")
  //</editor-fold>
  public Triple getArchTriple() /*const*/ {
    return getArchTriple((/*const*/type$ptr<char$ptr>/*char PP*/ )null);
  }
  public Triple getArchTriple(/*const*/type$ptr<char$ptr>/*char PP*/ McpuDefault/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::section_rel_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 268,
   FQN="llvm::object::MachOObjectFile::section_rel_begin", NM="_ZNK4llvm6object15MachOObjectFile17section_rel_beginEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17section_rel_beginEj")
  //</editor-fold>
  public content_iterator<RelocationRef> section_rel_begin(/*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::section_rel_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 269,
   FQN="llvm::object::MachOObjectFile::section_rel_end", NM="_ZNK4llvm6object15MachOObjectFile15section_rel_endEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile15section_rel_endEj")
  //</editor-fold>
  public content_iterator<RelocationRef> section_rel_end(/*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::begin_dices">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 271,
   FQN="llvm::object::MachOObjectFile::begin_dices", NM="_ZNK4llvm6object15MachOObjectFile11begin_dicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile11begin_dicesEv")
  //</editor-fold>
  public content_iterator<DiceRef> begin_dices() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::end_dices">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 272,
   FQN="llvm::object::MachOObjectFile::end_dices", NM="_ZNK4llvm6object15MachOObjectFile9end_dicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile9end_dicesEv")
  //</editor-fold>
  public content_iterator<DiceRef> end_dices() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::begin_load_commands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 274,
   FQN="llvm::object::MachOObjectFile::begin_load_commands", NM="_ZNK4llvm6object15MachOObjectFile19begin_load_commandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19begin_load_commandsEv")
  //</editor-fold>
  public type$ptr</*const*/ LoadCommandInfo /*P*/ > begin_load_commands() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::end_load_commands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 275,
   FQN="llvm::object::MachOObjectFile::end_load_commands", NM="_ZNK4llvm6object15MachOObjectFile17end_load_commandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17end_load_commandsEv")
  //</editor-fold>
  public type$ptr</*const*/ LoadCommandInfo /*P*/ > end_load_commands() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::load_commands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 276,
   FQN="llvm::object::MachOObjectFile::load_commands", NM="_ZNK4llvm6object15MachOObjectFile13load_commandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13load_commandsEv")
  //</editor-fold>
  public iterator_range</*const*/ LoadCommandInfo> load_commands() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// For use iterating over all exported symbols.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::exports">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 279,
   FQN="llvm::object::MachOObjectFile::exports", NM="_ZNK4llvm6object15MachOObjectFile7exportsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile7exportsEv")
  //</editor-fold>
  public iterator_range<content_iterator<ExportEntry> > exports() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// For use examining a trie not in a MachOObjectFile.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::exports">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 282,
   FQN="llvm::object::MachOObjectFile::exports", NM="_ZN4llvm6object15MachOObjectFile7exportsENS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile7exportsENS_8ArrayRefIhEE")
  //</editor-fold>
  public static iterator_range<content_iterator<ExportEntry> > exports(ArrayRefUChar Trie) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// For use iterating over all rebase table entries.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::rebaseTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 285,
   FQN="llvm::object::MachOObjectFile::rebaseTable", NM="_ZNK4llvm6object15MachOObjectFile11rebaseTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile11rebaseTableEv")
  //</editor-fold>
  public iterator_range<content_iterator<MachORebaseEntry> > rebaseTable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// For use examining rebase opcodes not in a MachOObjectFile.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::rebaseTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 288,
   FQN="llvm::object::MachOObjectFile::rebaseTable", NM="_ZN4llvm6object15MachOObjectFile11rebaseTableENS_8ArrayRefIhEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile11rebaseTableENS_8ArrayRefIhEEb")
  //</editor-fold>
  public static iterator_range<content_iterator<MachORebaseEntry> > rebaseTable(ArrayRefUChar Opcodes, 
             boolean is64) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// For use iterating over all bind table entries.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::bindTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 292,
   FQN="llvm::object::MachOObjectFile::bindTable", NM="_ZNK4llvm6object15MachOObjectFile9bindTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile9bindTableEv")
  //</editor-fold>
  public iterator_range<content_iterator<MachOBindEntry> > bindTable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// For use iterating over all lazy bind table entries.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::lazyBindTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 295,
   FQN="llvm::object::MachOObjectFile::lazyBindTable", NM="_ZNK4llvm6object15MachOObjectFile13lazyBindTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13lazyBindTableEv")
  //</editor-fold>
  public iterator_range<content_iterator<MachOBindEntry> > lazyBindTable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// For use iterating over all lazy bind table entries.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::weakBindTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 298,
   FQN="llvm::object::MachOObjectFile::weakBindTable", NM="_ZNK4llvm6object15MachOObjectFile13weakBindTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13weakBindTableEv")
  //</editor-fold>
  public iterator_range<content_iterator<MachOBindEntry> > weakBindTable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// For use examining bind opcodes not in a MachOObjectFile.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::bindTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 301,
   FQN="llvm::object::MachOObjectFile::bindTable", NM="_ZN4llvm6object15MachOObjectFile9bindTableENS_8ArrayRefIhEEbNS0_14MachOBindEntry4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile9bindTableENS_8ArrayRefIhEEbNS0_14MachOBindEntry4KindE")
  //</editor-fold>
  public static iterator_range<content_iterator<MachOBindEntry> > bindTable(ArrayRefUChar Opcodes, 
           boolean is64, 
           MachOBindEntry.Kind $Prm2) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // In a MachO file, sections have a segment name. This is used in the .o
  // files. They have a single segment, but this field specifies which segment
  // a section should be put in in the final object.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionFinalSegmentName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 309,
   FQN="llvm::object::MachOObjectFile::getSectionFinalSegmentName", NM="_ZNK4llvm6object15MachOObjectFile26getSectionFinalSegmentNameENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getSectionFinalSegmentNameENS0_11DataRefImplE")
  //</editor-fold>
  public StringRef getSectionFinalSegmentName(DataRefImpl Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Names are stored as 16 bytes. These returns the raw 16 bytes without
  // interpreting them as a C string.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionRawName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 313,
   FQN="llvm::object::MachOObjectFile::getSectionRawName", NM="_ZNK4llvm6object15MachOObjectFile17getSectionRawNameENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile17getSectionRawNameENS0_11DataRefImplE")
  //</editor-fold>
  public ArrayRefChar getSectionRawName(DataRefImpl Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSectionRawFinalSegmentName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 314,
   FQN="llvm::object::MachOObjectFile::getSectionRawFinalSegmentName", NM="_ZNK4llvm6object15MachOObjectFile29getSectionRawFinalSegmentNameENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile29getSectionRawFinalSegmentNameENS0_11DataRefImplE")
  //</editor-fold>
  public ArrayRefChar getSectionRawFinalSegmentName(DataRefImpl Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // MachO specific Info about relocations.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isRelocationScattered">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 317,
   FQN="llvm::object::MachOObjectFile::isRelocationScattered", NM="_ZNK4llvm6object15MachOObjectFile21isRelocationScatteredERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile21isRelocationScatteredERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public boolean isRelocationScattered(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getPlainRelocationSymbolNum">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 318,
   FQN="llvm::object::MachOObjectFile::getPlainRelocationSymbolNum", NM="_ZNK4llvm6object15MachOObjectFile27getPlainRelocationSymbolNumERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile27getPlainRelocationSymbolNumERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public /*uint*/int getPlainRelocationSymbolNum(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getPlainRelocationExternal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 320,
   FQN="llvm::object::MachOObjectFile::getPlainRelocationExternal", NM="_ZNK4llvm6object15MachOObjectFile26getPlainRelocationExternalERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getPlainRelocationExternalERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public boolean getPlainRelocationExternal(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getScatteredRelocationScattered">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 321,
   FQN="llvm::object::MachOObjectFile::getScatteredRelocationScattered", NM="_ZNK4llvm6object15MachOObjectFile31getScatteredRelocationScatteredERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile31getScatteredRelocationScatteredERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public boolean getScatteredRelocationScattered(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getScatteredRelocationValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 323,
   FQN="llvm::object::MachOObjectFile::getScatteredRelocationValue", NM="_ZNK4llvm6object15MachOObjectFile27getScatteredRelocationValueERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile27getScatteredRelocationValueERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public /*uint32_t*/int getScatteredRelocationValue(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getScatteredRelocationType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 325,
   FQN="llvm::object::MachOObjectFile::getScatteredRelocationType", NM="_ZNK4llvm6object15MachOObjectFile26getScatteredRelocationTypeERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getScatteredRelocationTypeERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public /*uint32_t*/int getScatteredRelocationType(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getAnyRelocationAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 327,
   FQN="llvm::object::MachOObjectFile::getAnyRelocationAddress", NM="_ZNK4llvm6object15MachOObjectFile23getAnyRelocationAddressERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile23getAnyRelocationAddressERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public /*uint*/int getAnyRelocationAddress(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getAnyRelocationPCRel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 328,
   FQN="llvm::object::MachOObjectFile::getAnyRelocationPCRel", NM="_ZNK4llvm6object15MachOObjectFile21getAnyRelocationPCRelERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile21getAnyRelocationPCRelERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public /*uint*/int getAnyRelocationPCRel(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getAnyRelocationLength">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 329,
   FQN="llvm::object::MachOObjectFile::getAnyRelocationLength", NM="_ZNK4llvm6object15MachOObjectFile22getAnyRelocationLengthERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile22getAnyRelocationLengthERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public /*uint*/int getAnyRelocationLength(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getAnyRelocationType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 330,
   FQN="llvm::object::MachOObjectFile::getAnyRelocationType", NM="_ZNK4llvm6object15MachOObjectFile20getAnyRelocationTypeERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile20getAnyRelocationTypeERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public /*uint*/int getAnyRelocationType(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getAnyRelocationSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 331,
   FQN="llvm::object::MachOObjectFile::getAnyRelocationSection", NM="_ZNK4llvm6object15MachOObjectFile23getAnyRelocationSectionERKNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile23getAnyRelocationSectionERKNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public SectionRef getAnyRelocationSection(final /*const*/ MachO.any_relocation_info /*&*/ RE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // MachO specific structures.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 334,
   FQN="llvm::object::MachOObjectFile::getSection", NM="_ZNK4llvm6object15MachOObjectFile10getSectionENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile10getSectionENS0_11DataRefImplE")
  //</editor-fold>
  public MachO.section getSection(DataRefImpl DRI) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSection64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 335,
   FQN="llvm::object::MachOObjectFile::getSection64", NM="_ZNK4llvm6object15MachOObjectFile12getSection64ENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile12getSection64ENS0_11DataRefImplE")
  //</editor-fold>
  public MachO.section_64 getSection64(DataRefImpl DRI) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 336,
   FQN="llvm::object::MachOObjectFile::getSection", NM="_ZNK4llvm6object15MachOObjectFile10getSectionERKNS1_15LoadCommandInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile10getSectionERKNS1_15LoadCommandInfoEj")
  //</editor-fold>
  public MachO.section getSection(final /*const*/ LoadCommandInfo /*&*/ L, /*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSection64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 337,
   FQN="llvm::object::MachOObjectFile::getSection64", NM="_ZNK4llvm6object15MachOObjectFile12getSection64ERKNS1_15LoadCommandInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile12getSection64ERKNS1_15LoadCommandInfoEj")
  //</editor-fold>
  public MachO.section_64 getSection64(final /*const*/ LoadCommandInfo /*&*/ L, /*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolTableEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 338,
   FQN="llvm::object::MachOObjectFile::getSymbolTableEntry", NM="_ZNK4llvm6object15MachOObjectFile19getSymbolTableEntryENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19getSymbolTableEntryENS0_11DataRefImplE")
  //</editor-fold>
  public MachO.nlist getSymbolTableEntry(DataRefImpl DRI) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbol64TableEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 339,
   FQN="llvm::object::MachOObjectFile::getSymbol64TableEntry", NM="_ZNK4llvm6object15MachOObjectFile21getSymbol64TableEntryENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile21getSymbol64TableEntryENS0_11DataRefImplE")
  //</editor-fold>
  public MachO.nlist_64 getSymbol64TableEntry(DataRefImpl DRI) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getLinkeditDataLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 341,
   FQN="llvm::object::MachOObjectFile::getLinkeditDataLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile26getLinkeditDataLoadCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getLinkeditDataLoadCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.linkedit_data_command getLinkeditDataLoadCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSegmentLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 343,
   FQN="llvm::object::MachOObjectFile::getSegmentLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile21getSegmentLoadCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile21getSegmentLoadCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.segment_command getSegmentLoadCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSegment64LoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 345,
   FQN="llvm::object::MachOObjectFile::getSegment64LoadCommand", NM="_ZNK4llvm6object15MachOObjectFile23getSegment64LoadCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile23getSegment64LoadCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.segment_command_64 getSegment64LoadCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getLinkerOptionLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 347,
   FQN="llvm::object::MachOObjectFile::getLinkerOptionLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile26getLinkerOptionLoadCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getLinkerOptionLoadCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.linker_option_command getLinkerOptionLoadCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getVersionMinLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 349,
   FQN="llvm::object::MachOObjectFile::getVersionMinLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile24getVersionMinLoadCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile24getVersionMinLoadCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.version_min_command getVersionMinLoadCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDylibIDLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 351,
   FQN="llvm::object::MachOObjectFile::getDylibIDLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile21getDylibIDLoadCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile21getDylibIDLoadCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.dylib_command getDylibIDLoadCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDyldInfoLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 353,
   FQN="llvm::object::MachOObjectFile::getDyldInfoLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile22getDyldInfoLoadCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile22getDyldInfoLoadCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.dyld_info_command getDyldInfoLoadCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDylinkerCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 355,
   FQN="llvm::object::MachOObjectFile::getDylinkerCommand", NM="_ZNK4llvm6object15MachOObjectFile18getDylinkerCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18getDylinkerCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.dylinker_command getDylinkerCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getUuidCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 357,
   FQN="llvm::object::MachOObjectFile::getUuidCommand", NM="_ZNK4llvm6object15MachOObjectFile14getUuidCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile14getUuidCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.uuid_command getUuidCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRpathCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 359,
   FQN="llvm::object::MachOObjectFile::getRpathCommand", NM="_ZNK4llvm6object15MachOObjectFile15getRpathCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile15getRpathCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.rpath_command getRpathCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSourceVersionCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 361,
   FQN="llvm::object::MachOObjectFile::getSourceVersionCommand", NM="_ZNK4llvm6object15MachOObjectFile23getSourceVersionCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile23getSourceVersionCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.source_version_command getSourceVersionCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getEntryPointCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 363,
   FQN="llvm::object::MachOObjectFile::getEntryPointCommand", NM="_ZNK4llvm6object15MachOObjectFile20getEntryPointCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile20getEntryPointCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.entry_point_command getEntryPointCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getEncryptionInfoCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 365,
   FQN="llvm::object::MachOObjectFile::getEncryptionInfoCommand", NM="_ZNK4llvm6object15MachOObjectFile24getEncryptionInfoCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile24getEncryptionInfoCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.encryption_info_command getEncryptionInfoCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getEncryptionInfoCommand64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 367,
   FQN="llvm::object::MachOObjectFile::getEncryptionInfoCommand64", NM="_ZNK4llvm6object15MachOObjectFile26getEncryptionInfoCommand64ERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getEncryptionInfoCommand64ERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.encryption_info_command_64 getEncryptionInfoCommand64(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSubFrameworkCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 369,
   FQN="llvm::object::MachOObjectFile::getSubFrameworkCommand", NM="_ZNK4llvm6object15MachOObjectFile22getSubFrameworkCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile22getSubFrameworkCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.sub_framework_command getSubFrameworkCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSubUmbrellaCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 371,
   FQN="llvm::object::MachOObjectFile::getSubUmbrellaCommand", NM="_ZNK4llvm6object15MachOObjectFile21getSubUmbrellaCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile21getSubUmbrellaCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.sub_umbrella_command getSubUmbrellaCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSubLibraryCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 373,
   FQN="llvm::object::MachOObjectFile::getSubLibraryCommand", NM="_ZNK4llvm6object15MachOObjectFile20getSubLibraryCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile20getSubLibraryCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.sub_library_command getSubLibraryCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSubClientCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 375,
   FQN="llvm::object::MachOObjectFile::getSubClientCommand", NM="_ZNK4llvm6object15MachOObjectFile19getSubClientCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19getSubClientCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.sub_client_command getSubClientCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRoutinesCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 377,
   FQN="llvm::object::MachOObjectFile::getRoutinesCommand", NM="_ZNK4llvm6object15MachOObjectFile18getRoutinesCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18getRoutinesCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.routines_command getRoutinesCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRoutinesCommand64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 379,
   FQN="llvm::object::MachOObjectFile::getRoutinesCommand64", NM="_ZNK4llvm6object15MachOObjectFile20getRoutinesCommand64ERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile20getRoutinesCommand64ERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.routines_command_64 getRoutinesCommand64(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getThreadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 381,
   FQN="llvm::object::MachOObjectFile::getThreadCommand", NM="_ZNK4llvm6object15MachOObjectFile16getThreadCommandERKNS1_15LoadCommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile16getThreadCommandERKNS1_15LoadCommandInfoE")
  //</editor-fold>
  public MachO.thread_command getThreadCommand(final /*const*/ LoadCommandInfo /*&*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getRelocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 384,
   FQN="llvm::object::MachOObjectFile::getRelocation", NM="_ZNK4llvm6object15MachOObjectFile13getRelocationENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile13getRelocationENS0_11DataRefImplE")
  //</editor-fold>
  public MachO.any_relocation_info getRelocation(DataRefImpl Rel) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDice">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 385,
   FQN="llvm::object::MachOObjectFile::getDice", NM="_ZNK4llvm6object15MachOObjectFile7getDiceENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile7getDiceENS0_11DataRefImplE")
  //</editor-fold>
  public MachO.data_in_code_entry getDice(DataRefImpl Rel) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 386,
   FQN="llvm::object::MachOObjectFile::getHeader", NM="_ZNK4llvm6object15MachOObjectFile9getHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile9getHeaderEv")
  //</editor-fold>
  public /*const*/ MachO.mach_header /*&*/ getHeader() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getHeader64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 387,
   FQN="llvm::object::MachOObjectFile::getHeader64", NM="_ZNK4llvm6object15MachOObjectFile11getHeader64Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile11getHeader64Ev")
  //</editor-fold>
  public /*const*/ MachO.mach_header_64 /*&*/ getHeader64() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getIndirectSymbolTableEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 388,
   FQN="llvm::object::MachOObjectFile::getIndirectSymbolTableEntry", NM="_ZNK4llvm6object15MachOObjectFile27getIndirectSymbolTableEntryERKNS_5MachO16dysymtab_commandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile27getIndirectSymbolTableEntryERKNS_5MachO16dysymtab_commandEj")
  //</editor-fold>
  public /*uint32_t*/int getIndirectSymbolTableEntry(final /*const*/ MachO.dysymtab_command /*&*/ DLC, 
                             /*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDataInCodeTableEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 391,
   FQN="llvm::object::MachOObjectFile::getDataInCodeTableEntry", NM="_ZNK4llvm6object15MachOObjectFile23getDataInCodeTableEntryEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile23getDataInCodeTableEntryEjj")
  //</editor-fold>
  public MachO.data_in_code_entry getDataInCodeTableEntry(/*uint32_t*/int DataOffset, 
                         /*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymtabLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 393,
   FQN="llvm::object::MachOObjectFile::getSymtabLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile20getSymtabLoadCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile20getSymtabLoadCommandEv")
  //</editor-fold>
  public MachO.symtab_command getSymtabLoadCommand() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDysymtabLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 394,
   FQN="llvm::object::MachOObjectFile::getDysymtabLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile22getDysymtabLoadCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile22getDysymtabLoadCommandEv")
  //</editor-fold>
  public MachO.dysymtab_command getDysymtabLoadCommand() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDataInCodeLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 395,
   FQN="llvm::object::MachOObjectFile::getDataInCodeLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile24getDataInCodeLoadCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile24getDataInCodeLoadCommandEv")
  //</editor-fold>
  public MachO.linkedit_data_command getDataInCodeLoadCommand() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getLinkOptHintsLoadCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 396,
   FQN="llvm::object::MachOObjectFile::getLinkOptHintsLoadCommand", NM="_ZNK4llvm6object15MachOObjectFile26getLinkOptHintsLoadCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getLinkOptHintsLoadCommandEv")
  //</editor-fold>
  public MachO.linkedit_data_command getLinkOptHintsLoadCommand() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDyldInfoRebaseOpcodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 397,
   FQN="llvm::object::MachOObjectFile::getDyldInfoRebaseOpcodes", NM="_ZNK4llvm6object15MachOObjectFile24getDyldInfoRebaseOpcodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile24getDyldInfoRebaseOpcodesEv")
  //</editor-fold>
  public ArrayRefUChar getDyldInfoRebaseOpcodes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDyldInfoBindOpcodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 398,
   FQN="llvm::object::MachOObjectFile::getDyldInfoBindOpcodes", NM="_ZNK4llvm6object15MachOObjectFile22getDyldInfoBindOpcodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile22getDyldInfoBindOpcodesEv")
  //</editor-fold>
  public ArrayRefUChar getDyldInfoBindOpcodes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDyldInfoWeakBindOpcodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 399,
   FQN="llvm::object::MachOObjectFile::getDyldInfoWeakBindOpcodes", NM="_ZNK4llvm6object15MachOObjectFile26getDyldInfoWeakBindOpcodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getDyldInfoWeakBindOpcodesEv")
  //</editor-fold>
  public ArrayRefUChar getDyldInfoWeakBindOpcodes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDyldInfoLazyBindOpcodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 400,
   FQN="llvm::object::MachOObjectFile::getDyldInfoLazyBindOpcodes", NM="_ZNK4llvm6object15MachOObjectFile26getDyldInfoLazyBindOpcodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile26getDyldInfoLazyBindOpcodesEv")
  //</editor-fold>
  public ArrayRefUChar getDyldInfoLazyBindOpcodes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getDyldInfoExportsTrie">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 401,
   FQN="llvm::object::MachOObjectFile::getDyldInfoExportsTrie", NM="_ZNK4llvm6object15MachOObjectFile22getDyldInfoExportsTrieEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile22getDyldInfoExportsTrieEv")
  //</editor-fold>
  public ArrayRefUChar getDyldInfoExportsTrie() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getUuid">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 402,
   FQN="llvm::object::MachOObjectFile::getUuid", NM="_ZNK4llvm6object15MachOObjectFile7getUuidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile7getUuidEv")
  //</editor-fold>
  public ArrayRefUChar getUuid() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getStringTableData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 404,
   FQN="llvm::object::MachOObjectFile::getStringTableData", NM="_ZNK4llvm6object15MachOObjectFile18getStringTableDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18getStringTableDataEv")
  //</editor-fold>
  public StringRef getStringTableData() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::is64Bit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 405,
   FQN="llvm::object::MachOObjectFile::is64Bit", NM="_ZNK4llvm6object15MachOObjectFile7is64BitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile7is64BitEv")
  //</editor-fold>
  public boolean is64Bit() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::ReadULEB128s">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 406,
   FQN="llvm::object::MachOObjectFile::ReadULEB128s", NM="_ZNK4llvm6object15MachOObjectFile12ReadULEB128sEyRNS_15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile12ReadULEB128sEyRNS_15SmallVectorImplIyEE")
  //</editor-fold>
  public void ReadULEB128s(long/*uint64_t*/ Index, final SmallVectorImplULong /*&*/ Out) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::guessLibraryShortName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 408,
   FQN="llvm::object::MachOObjectFile::guessLibraryShortName", NM="_ZN4llvm6object15MachOObjectFile21guessLibraryShortNameENS_9StringRefERbRS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile21guessLibraryShortNameENS_9StringRefERbRS2_")
  //</editor-fold>
  public static StringRef guessLibraryShortName(StringRef Name, final bool$ref/*bool &*/ isFramework, 
                       final StringRef /*&*/ Suffix) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getArch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 411,
   FQN="llvm::object::MachOObjectFile::getArch", NM="_ZN4llvm6object15MachOObjectFile7getArchEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile7getArchEj")
  //</editor-fold>
  public static Triple.ArchType getArch(/*uint32_t*/int CPUType) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getArchTriple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 412,
   FQN="llvm::object::MachOObjectFile::getArchTriple", NM="_ZN4llvm6object15MachOObjectFile13getArchTripleEjjPPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile13getArchTripleEjjPPKc")
  //</editor-fold>
  public static Triple getArchTriple(/*uint32_t*/int CPUType, /*uint32_t*/int CPUSubType) {
    return getArchTriple(CPUType, CPUSubType, 
               (/*const*/type$ptr<char$ptr>/*char PP*/ )null);
  }
  public static Triple getArchTriple(/*uint32_t*/int CPUType, /*uint32_t*/int CPUSubType, 
               /*const*/type$ptr<char$ptr>/*char PP*/ McpuDefault/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isValidArch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 414,
   FQN="llvm::object::MachOObjectFile::isValidArch", NM="_ZN4llvm6object15MachOObjectFile11isValidArchENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile11isValidArchENS_9StringRefE")
  //</editor-fold>
  public static boolean isValidArch(StringRef ArchFlag) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getHostArch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 415,
   FQN="llvm::object::MachOObjectFile::getHostArch", NM="_ZN4llvm6object15MachOObjectFile11getHostArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile11getHostArchEv")
  //</editor-fold>
  public static Triple getHostArch() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::isRelocatableObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 417,
   FQN="llvm::object::MachOObjectFile::isRelocatableObject", NM="_ZNK4llvm6object15MachOObjectFile19isRelocatableObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile19isRelocatableObjectEv")
  //</editor-fold>
  @Override public boolean isRelocatableObject() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::hasPageZeroSegment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 419,
   FQN="llvm::object::MachOObjectFile::hasPageZeroSegment", NM="_ZNK4llvm6object15MachOObjectFile18hasPageZeroSegmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18hasPageZeroSegmentEv")
  //</editor-fold>
  public boolean hasPageZeroSegment() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 421,
   FQN="llvm::object::MachOObjectFile::classof", NM="_ZN4llvm6object15MachOObjectFile7classofEPKNS0_6BinaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile7classofEPKNS0_6BinaryE")
  //</editor-fold>
  public static boolean classof(/*const*/ Binary /*P*/ v) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getVersionMinMajor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 425,
   FQN="llvm::object::MachOObjectFile::getVersionMinMajor", NM="_ZN4llvm6object15MachOObjectFile18getVersionMinMajorERNS_5MachO19version_min_commandEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile18getVersionMinMajorERNS_5MachO19version_min_commandEb")
  //</editor-fold>
  public static /*uint32_t*/int getVersionMinMajor(final MachO.version_min_command /*&*/ C, boolean SDK) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getVersionMinMinor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 431,
   FQN="llvm::object::MachOObjectFile::getVersionMinMinor", NM="_ZN4llvm6object15MachOObjectFile18getVersionMinMinorERNS_5MachO19version_min_commandEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile18getVersionMinMinorERNS_5MachO19version_min_commandEb")
  //</editor-fold>
  public static /*uint32_t*/int getVersionMinMinor(final MachO.version_min_command /*&*/ C, boolean SDK) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getVersionMinUpdate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 437,
   FQN="llvm::object::MachOObjectFile::getVersionMinUpdate", NM="_ZN4llvm6object15MachOObjectFile19getVersionMinUpdateERNS_5MachO19version_min_commandEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFile19getVersionMinUpdateERNS_5MachO19version_min_commandEb")
  //</editor-fold>
  public static /*uint32_t*/int getVersionMinUpdate(final MachO.version_min_command /*&*/ C, boolean SDK) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::MachOObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 445,
   FQN="llvm::object::MachOObjectFile::MachOObjectFile", NM="_ZN4llvm6object15MachOObjectFileC1ENS_15MemoryBufferRefEbbRNS_5ErrorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFileC1ENS_15MemoryBufferRefEbbRNS_5ErrorE")
  //</editor-fold>
  private MachOObjectFile(MemoryBufferRef Object, boolean IsLittleEndian, boolean Is64Bits, 
      final Error /*&*/ Err) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::getSymbolValueImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 448,
   FQN="llvm::object::MachOObjectFile::getSymbolValueImpl", NM="_ZNK4llvm6object15MachOObjectFile18getSymbolValueImplENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object15MachOObjectFile18getSymbolValueImplENS0_11DataRefImplE")
  //</editor-fold>
  @Override protected/*private*/ long/*uint64_t*/ getSymbolValueImpl(DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 450,
   FQN="llvm::object::MachOObjectFile::(anonymous)", NM="_ZN4llvm6object15MachOObjectFileE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFileE_Unnamed_union2")
  //</editor-fold>
  private static class/*union*/ Unnamed_union2 {
    public MachO.mach_header_64 Header64;
    public MachO.mach_header Header;
    
    @Override public String toString() {
      return "" + "Header64=" + Header64 // NOI18N
                + ", Header=" + Header; // NOI18N
    }
  };
  private Unnamed_union2 Unnamed_field = new Unnamed_union2();
  // JAVA: typedef SmallVector<const char *, 1> SectionList
//  public final class SectionList extends SmallVector</*const*/char$ptr/*char P*//*,  1*/>{ };
  private SmallVector</*const*/char$ptr/*char P*//*,  1*/> Sections;
  // JAVA: typedef SmallVector<const char *, 1> LibraryList
//  public final class LibraryList extends SmallVector</*const*/char$ptr/*char P*//*,  1*/>{ };
  private SmallVector</*const*/char$ptr/*char P*//*,  1*/> Libraries;
  private SmallVector<LoadCommandInfo> LoadCommands;
  // JAVA: typedef SmallVector<StringRef, 1> LibraryShortName
//  public final class LibraryShortName extends SmallVector<StringRef>{ };
  private /*mutable */SmallVector<StringRef> LibrariesShortNames;
  private /*const*/char$ptr/*char P*/ SymtabLoadCmd;
  private /*const*/char$ptr/*char P*/ DysymtabLoadCmd;
  private /*const*/char$ptr/*char P*/ DataInCodeLoadCmd;
  private /*const*/char$ptr/*char P*/ LinkOptHintsLoadCmd;
  private /*const*/char$ptr/*char P*/ DyldInfoLoadCmd;
  private /*const*/char$ptr/*char P*/ UuidLoadCmd;
  private boolean HasPageZeroSegment;
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOObjectFile::~MachOObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 187,
   FQN="llvm::object::MachOObjectFile::~MachOObjectFile", NM="_ZN4llvm6object15MachOObjectFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object15MachOObjectFileD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field // NOI18N
              + ", Sections=" + Sections // NOI18N
              + ", Libraries=" + Libraries // NOI18N
              + ", LoadCommands=" + LoadCommands // NOI18N
              + ", LibrariesShortNames=" + LibrariesShortNames // NOI18N
              + ", SymtabLoadCmd=" + SymtabLoadCmd // NOI18N
              + ", DysymtabLoadCmd=" + DysymtabLoadCmd // NOI18N
              + ", DataInCodeLoadCmd=" + DataInCodeLoadCmd // NOI18N
              + ", LinkOptHintsLoadCmd=" + LinkOptHintsLoadCmd // NOI18N
              + ", DyldInfoLoadCmd=" + DyldInfoLoadCmd // NOI18N
              + ", UuidLoadCmd=" + UuidLoadCmd // NOI18N
              + ", HasPageZeroSegment=" + HasPageZeroSegment // NOI18N
              + super.toString(); // NOI18N
  }
}
