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
import org.llvm.ir.java.IRFunctionPointers.*;


/// This class is the base class for all object file types. Concrete instances
/// of this object are created by createObjectFile, which figures out which type
/// to create.
//<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 177,
 FQN="llvm::object::ObjectFile", NM="_ZN4llvm6object10ObjectFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFileE")
//</editor-fold>
public abstract class ObjectFile extends /*public*/ SymbolicFile implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::anchor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 178,
   FQN="llvm::object::ObjectFile::anchor", NM="_ZN4llvm6object10ObjectFile6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFile6anchorEv")
  //</editor-fold>
  protected/*private*/ /*virtual*/ void anchor() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::ObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 179,
   FQN="llvm::object::ObjectFile::ObjectFile", NM="_ZN4llvm6object10ObjectFileC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFileC1Ev")
  //</editor-fold>
  protected/*private*/ ObjectFile() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::ObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 180,
   FQN="llvm::object::ObjectFile::ObjectFile", NM="_ZN4llvm6object10ObjectFileC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFileC1ERKS1_")
  //</editor-fold>
  protected/*private*/ ObjectFile(final /*const*/ ObjectFile /*&*/ other) {throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::ObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 183,
   FQN="llvm::object::ObjectFile::ObjectFile", NM="_ZN4llvm6object10ObjectFileC1EjNS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFileC1EjNS_15MemoryBufferRefE")
  //</editor-fold>
  protected ObjectFile(/*uint*/int Type, MemoryBufferRef Source) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::base">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 185,
   FQN="llvm::object::ObjectFile::base", NM="_ZNK4llvm6object10ObjectFile4baseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile4baseEv")
  //</editor-fold>
  protected /*const*/byte/*uint8_t*//*P*/ base() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // These functions are for SymbolRef to call internally. The main goal of
  // this is to allow SymbolRef::SymbolPimpl to point directly to the symbol
  // entry in the memory mapped object file. SymbolPimpl cannot contain any
  // virtual functions because then it could not point into the memory mapped
  // file.
  //
  // Implementations assume that the DataRefImpl is valid and has not been
  // modified externally. It's UB otherwise.
  /*friend  class SymbolRef*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 198,
   FQN="llvm::object::ObjectFile::getSymbolName", NM="_ZNK4llvm6object10ObjectFile13getSymbolNameENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile13getSymbolNameENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ Expected<StringRef> getSymbolName(DataRefImpl Symb) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::printSymbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 199,
   FQN="llvm::object::ObjectFile::printSymbolName", NM="_ZNK4llvm6object10ObjectFile15printSymbolNameERNS_11raw_ostreamENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile15printSymbolNameERNS_11raw_ostreamENS0_11DataRefImplE")
  //</editor-fold>
  @Override public/*protected*/ std.error_code printSymbolName(final raw_ostream /*&*/ OS, 
                 DataRefImpl Symb) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSymbolAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 201,
   FQN="llvm::object::ObjectFile::getSymbolAddress", NM="_ZNK4llvm6object10ObjectFile16getSymbolAddressENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile16getSymbolAddressENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ Expected<Long/*uint64_t*/> getSymbolAddress(DataRefImpl Symb) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSymbolValueImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 202,
   FQN="llvm::object::ObjectFile::getSymbolValueImpl", NM="_ZNK4llvm6object10ObjectFile18getSymbolValueImplENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile18getSymbolValueImplENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ long/*uint64_t*/ getSymbolValueImpl(DataRefImpl Symb) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSymbolAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 203,
   FQN="llvm::object::ObjectFile::getSymbolAlignment", NM="_ZNK4llvm6object10ObjectFile18getSymbolAlignmentENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile18getSymbolAlignmentENS0_11DataRefImplE")
  //</editor-fold>
  protected /*virtual*/ /*uint32_t*/int getSymbolAlignment(DataRefImpl Symb) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getCommonSymbolSizeImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 204,
   FQN="llvm::object::ObjectFile::getCommonSymbolSizeImpl", NM="_ZNK4llvm6object10ObjectFile23getCommonSymbolSizeImplENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile23getCommonSymbolSizeImplENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ long/*uint64_t*/ getCommonSymbolSizeImpl(DataRefImpl Symb) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSymbolType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 205,
   FQN="llvm::object::ObjectFile::getSymbolType", NM="_ZNK4llvm6object10ObjectFile13getSymbolTypeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile13getSymbolTypeENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ Expected<SymbolRef.Type> getSymbolType(DataRefImpl Symb) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSymbolSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 206,
   FQN="llvm::object::ObjectFile::getSymbolSection", NM="_ZNK4llvm6object10ObjectFile16getSymbolSectionENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile16getSymbolSectionENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ Expected<content_iterator<SectionRef> > getSymbolSection(DataRefImpl Symb) /*const*//* = 0*/;

  
  // Same as above for SectionRef.
  /*friend  class SectionRef*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::moveSectionNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 211,
   FQN="llvm::object::ObjectFile::moveSectionNext", NM="_ZNK4llvm6object10ObjectFile15moveSectionNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile15moveSectionNextERNS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ void moveSectionNext(final DataRefImpl /*&*/ Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSectionName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 212,
   FQN="llvm::object::ObjectFile::getSectionName", NM="_ZNK4llvm6object10ObjectFile14getSectionNameENS0_11DataRefImplERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile14getSectionNameENS0_11DataRefImplERNS_9StringRefE")
  //</editor-fold>
  protected abstract /*virtual*/ std.error_code getSectionName(DataRefImpl Sec, 
                final StringRef /*&*/ Res) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSectionAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 214,
   FQN="llvm::object::ObjectFile::getSectionAddress", NM="_ZNK4llvm6object10ObjectFile17getSectionAddressENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile17getSectionAddressENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ long/*uint64_t*/ getSectionAddress(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSectionSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 215,
   FQN="llvm::object::ObjectFile::getSectionSize", NM="_ZNK4llvm6object10ObjectFile14getSectionSizeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile14getSectionSizeENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ long/*uint64_t*/ getSectionSize(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSectionContents">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 216,
   FQN="llvm::object::ObjectFile::getSectionContents", NM="_ZNK4llvm6object10ObjectFile18getSectionContentsENS0_11DataRefImplERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile18getSectionContentsENS0_11DataRefImplERNS_9StringRefE")
  //</editor-fold>
  protected abstract /*virtual*/ std.error_code getSectionContents(DataRefImpl Sec, 
                    final StringRef /*&*/ Res) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSectionAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 218,
   FQN="llvm::object::ObjectFile::getSectionAlignment", NM="_ZNK4llvm6object10ObjectFile19getSectionAlignmentENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile19getSectionAlignmentENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ long/*uint64_t*/ getSectionAlignment(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::isSectionCompressed">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 219,
   FQN="llvm::object::ObjectFile::isSectionCompressed", NM="_ZNK4llvm6object10ObjectFile19isSectionCompressedENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile19isSectionCompressedENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean isSectionCompressed(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::isSectionText">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 220,
   FQN="llvm::object::ObjectFile::isSectionText", NM="_ZNK4llvm6object10ObjectFile13isSectionTextENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile13isSectionTextENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean isSectionText(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::isSectionData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 221,
   FQN="llvm::object::ObjectFile::isSectionData", NM="_ZNK4llvm6object10ObjectFile13isSectionDataENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile13isSectionDataENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean isSectionData(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::isSectionBSS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 222,
   FQN="llvm::object::ObjectFile::isSectionBSS", NM="_ZNK4llvm6object10ObjectFile12isSectionBSSENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile12isSectionBSSENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean isSectionBSS(DataRefImpl Sec) /*const*//* = 0*/;

  // A section is 'virtual' if its contents aren't present in the object image.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::isSectionVirtual">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 224,
   FQN="llvm::object::ObjectFile::isSectionVirtual", NM="_ZNK4llvm6object10ObjectFile16isSectionVirtualENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile16isSectionVirtualENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean isSectionVirtual(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::isSectionBitcode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 225,
   FQN="llvm::object::ObjectFile::isSectionBitcode", NM="_ZNK4llvm6object10ObjectFile16isSectionBitcodeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile16isSectionBitcodeENS0_11DataRefImplE")
  //</editor-fold>
  protected /*virtual*/ boolean isSectionBitcode(DataRefImpl Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::section_rel_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 226,
   FQN="llvm::object::ObjectFile::section_rel_begin", NM="_ZNK4llvm6object10ObjectFile17section_rel_beginENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile17section_rel_beginENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ content_iterator<RelocationRef> section_rel_begin(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::section_rel_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 227,
   FQN="llvm::object::ObjectFile::section_rel_end", NM="_ZNK4llvm6object10ObjectFile15section_rel_endENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile15section_rel_endENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ content_iterator<RelocationRef> section_rel_end(DataRefImpl Sec) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getRelocatedSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 228,
   FQN="llvm::object::ObjectFile::getRelocatedSection", NM="_ZNK4llvm6object10ObjectFile19getRelocatedSectionENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile19getRelocatedSectionENS0_11DataRefImplE")
  //</editor-fold>
  protected /*virtual*/ content_iterator<SectionRef> getRelocatedSection(DataRefImpl Sec) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Same as above for RelocationRef.
  /*friend  class RelocationRef*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::moveRelocationNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 232,
   FQN="llvm::object::ObjectFile::moveRelocationNext", NM="_ZNK4llvm6object10ObjectFile18moveRelocationNextERNS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile18moveRelocationNextERNS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ void moveRelocationNext(final DataRefImpl /*&*/ Rel) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getRelocationOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 233,
   FQN="llvm::object::ObjectFile::getRelocationOffset", NM="_ZNK4llvm6object10ObjectFile19getRelocationOffsetENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile19getRelocationOffsetENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ long/*uint64_t*/ getRelocationOffset(DataRefImpl Rel) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getRelocationSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 234,
   FQN="llvm::object::ObjectFile::getRelocationSymbol", NM="_ZNK4llvm6object10ObjectFile19getRelocationSymbolENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile19getRelocationSymbolENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ symbol_iterator getRelocationSymbol(DataRefImpl Rel) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getRelocationType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 235,
   FQN="llvm::object::ObjectFile::getRelocationType", NM="_ZNK4llvm6object10ObjectFile17getRelocationTypeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile17getRelocationTypeENS0_11DataRefImplE")
  //</editor-fold>
  protected abstract /*virtual*/ long/*uint64_t*/ getRelocationType(DataRefImpl Rel) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getRelocationTypeName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 236,
   FQN="llvm::object::ObjectFile::getRelocationTypeName", NM="_ZNK4llvm6object10ObjectFile21getRelocationTypeNameENS0_11DataRefImplERNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile21getRelocationTypeNameENS0_11DataRefImplERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  protected abstract /*virtual*/ void getRelocationTypeName(DataRefImpl Rel, 
                       final SmallString/*&*/ Result) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getSymbolValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 239,
   FQN="llvm::object::ObjectFile::getSymbolValue", NM="_ZNK4llvm6object10ObjectFile14getSymbolValueENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile14getSymbolValueENS0_11DataRefImplE")
  //</editor-fold>
  protected long/*uint64_t*/ getSymbolValue(DataRefImpl Symb) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getCommonSymbolSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 242,
   FQN="llvm::object::ObjectFile::getCommonSymbolSize", NM="_ZNK4llvm6object10ObjectFile19getCommonSymbolSizeENS0_11DataRefImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile19getCommonSymbolSizeENS0_11DataRefImplE")
  //</editor-fold>
  public long/*uint64_t*/ getCommonSymbolSize(DataRefImpl Symb) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // JAVA: typedef iterator_range<symbol_iterator> symbol_iterator_range
//  public final class symbol_iterator_range extends iterator_range</*const*/ SymbolRef /*&*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::symbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 248,
   FQN="llvm::object::ObjectFile::symbols", NM="_ZNK4llvm6object10ObjectFile7symbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile7symbolsEv")
  //</editor-fold>
  public iterator_range</*const*/ SymbolRef /*&*/ > symbols_ObjectFile() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::section_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 252,
   FQN="llvm::object::ObjectFile::section_begin", NM="_ZNK4llvm6object10ObjectFile13section_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile13section_beginEv")
  //</editor-fold>
  public abstract /*virtual*/ content_iterator<SectionRef> section_begin() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::section_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 253,
   FQN="llvm::object::ObjectFile::section_end", NM="_ZNK4llvm6object10ObjectFile11section_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile11section_endEv")
  //</editor-fold>
  public abstract /*virtual*/ content_iterator<SectionRef> section_end() /*const*//* = 0*/;

  
  // JAVA: typedef iterator_range<section_iterator> section_iterator_range
//  public final class section_iterator_range extends iterator_range</*const*/ SectionRef /*&*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::sections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 256,
   FQN="llvm::object::ObjectFile::sections", NM="_ZNK4llvm6object10ObjectFile8sectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile8sectionsEv")
  //</editor-fold>
  public iterator_range</*const*/ SectionRef /*&*/ > sections() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief The number of bytes used to represent an address in this object
  ///        file format.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getBytesInAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 262,
   FQN="llvm::object::ObjectFile::getBytesInAddress", NM="_ZNK4llvm6object10ObjectFile17getBytesInAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile17getBytesInAddressEv")
  //</editor-fold>
  public abstract /*virtual*/ byte/*uint8_t*/ getBytesInAddress() /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getFileFormatName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 264,
   FQN="llvm::object::ObjectFile::getFileFormatName", NM="_ZNK4llvm6object10ObjectFile17getFileFormatNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile17getFileFormatNameEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getFileFormatName() /*const*//* = 0*/;

  /* Triple::ArchType */
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getArch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 265,
   FQN="llvm::object::ObjectFile::getArch", NM="_ZNK4llvm6object10ObjectFile7getArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile7getArchEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getArch() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getFeatures">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 266,
   FQN="llvm::object::ObjectFile::getFeatures", NM="_ZNK4llvm6object10ObjectFile11getFeaturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile11getFeaturesEv")
  //</editor-fold>
  public abstract /*virtual*/ SubtargetFeatures getFeatures() /*const*//* = 0*/;

  
  /// Returns platform-specific object flags, if any.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::getPlatformFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 269,
   FQN="llvm::object::ObjectFile::getPlatformFlags", NM="_ZNK4llvm6object10ObjectFile16getPlatformFlagsERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile16getPlatformFlagsERj")
  //</editor-fold>
  public /*virtual*/ std.error_code getPlatformFlags(final uint$ref/*uint &*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// True if this is a relocatable object (.o/.obj).
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::isRelocatableObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 275,
   FQN="llvm::object::ObjectFile::isRelocatableObject", NM="_ZNK4llvm6object10ObjectFile19isRelocatableObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object10ObjectFile19isRelocatableObjectEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isRelocatableObject() /*const*//* = 0*/;

  
  /// @returns Pointer to ObjectFile subclass to handle this type of object.
  /// @param ObjectPath The path to the object file. ObjectPath.isObject must
  ///        return true.
  /// @brief Create ObjectFile from path.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::createObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 281,
   FQN="llvm::object::ObjectFile::createObjectFile", NM="_ZN4llvm6object10ObjectFile16createObjectFileENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFile16createObjectFileENS_9StringRefE")
  //</editor-fold>
  public static Expected<OwningBinary<ObjectFile> > createObjectFile(StringRef ObjectPath) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::createObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 284,
   FQN="llvm::object::ObjectFile::createObjectFile", NM="_ZN4llvm6object10ObjectFile16createObjectFileENS_15MemoryBufferRefENS_3sys2fs10file_magicE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFile16createObjectFileENS_15MemoryBufferRefENS_3sys2fs10file_magicE")
  //</editor-fold>
  public static Expected<std.unique_ptr<ObjectFile> > createObjectFile(MemoryBufferRef Object, fs.file_magic Type) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::createObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 286,
   FQN="llvm::object::ObjectFile::createObjectFile", NM="_ZN4llvm6object10ObjectFile16createObjectFileENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFile16createObjectFileENS_15MemoryBufferRefE")
  //</editor-fold>
  public static Expected<std.unique_ptr<ObjectFile> > createObjectFile(MemoryBufferRef Object) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 292,
   FQN="llvm::object::ObjectFile::classof", NM="_ZN4llvm6object10ObjectFile7classofEPKNS0_6BinaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFile7classofEPKNS0_6BinaryE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Binary /*P*/ v) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::createCOFFObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 296,
   FQN="llvm::object::ObjectFile::createCOFFObjectFile", NM="_ZN4llvm6object10ObjectFile20createCOFFObjectFileENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFile20createCOFFObjectFileENS_15MemoryBufferRefE")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<COFFObjectFile> > createCOFFObjectFile(MemoryBufferRef Object) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::createELFObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 299,
   FQN="llvm::object::ObjectFile::createELFObjectFile", NM="_ZN4llvm6object10ObjectFile19createELFObjectFileENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFile19createELFObjectFileENS_15MemoryBufferRefE")
  //</editor-fold>
  public static ErrorOr<std.unique_ptr<ObjectFile> > createELFObjectFile(MemoryBufferRef Object) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::createMachOObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 302,
   FQN="llvm::object::ObjectFile::createMachOObjectFile", NM="_ZN4llvm6object10ObjectFile21createMachOObjectFileENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFile21createMachOObjectFileENS_15MemoryBufferRefE")
  //</editor-fold>
  public static Expected<std.unique_ptr<MachOObjectFile> > createMachOObjectFile(MemoryBufferRef Object) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::ObjectFile::~ObjectFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 177,
   FQN="llvm::object::ObjectFile::~ObjectFile", NM="_ZN4llvm6object10ObjectFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object10ObjectFileD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
