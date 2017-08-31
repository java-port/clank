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


/// This is a value type class that represents a single section in the list of
/// sections in the object file.
//<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 69,
 FQN="llvm::object::SectionRef", NM="_ZN4llvm6object10SectionRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object10SectionRefE")
//</editor-fold>
public class SectionRef implements Native.NativeComparable<SectionRef> {
  /*friend  class SymbolRef*/
  private DataRefImpl SectionPimpl;
  private /*const*/ ObjectFile /*P*/ OwningObject;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::SectionRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 75,
   FQN="llvm::object::SectionRef::SectionRef", NM="_ZN4llvm6object10SectionRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object10SectionRefC1Ev")
  //</editor-fold>
  public SectionRef() {
    // : SectionPimpl(), OwningObject(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// SectionRef
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::SectionRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 346,
   FQN="llvm::object::SectionRef::SectionRef", NM="_ZN4llvm6object10SectionRefC1ENS0_11DataRefImplEPKNS0_10ObjectFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object10SectionRefC1ENS0_11DataRefImplEPKNS0_10ObjectFileE")
  //</editor-fold>
  public /*inline*/ SectionRef(DataRefImpl SectionP, 
      /*const*/ ObjectFile /*P*/ Owner) {
    // : SectionPimpl(SectionP), OwningObject(Owner) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 351,
   FQN="llvm::object::SectionRef::operator==", NM="_ZNK4llvm6object10SectionRefeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRefeqERKS1_")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ SectionRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 355,
   FQN="llvm::object::SectionRef::operator!=", NM="_ZNK4llvm6object10SectionRefneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRefneERKS1_")
  //</editor-fold>
  public /*inline*/ boolean $noteq(final /*const*/ SectionRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 359,
   FQN="llvm::object::SectionRef::operator<", NM="_ZNK4llvm6object10SectionRefltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRefltERKS1_")
  //</editor-fold>
  public /*inline*/ boolean $less(final /*const*/ SectionRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::moveNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 363,
   FQN="llvm::object::SectionRef::moveNext", NM="_ZN4llvm6object10SectionRef8moveNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object10SectionRef8moveNextEv")
  //</editor-fold>
  public /*inline*/ void moveNext() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 367,
   FQN="llvm::object::SectionRef::getName", NM="_ZNK4llvm6object10SectionRef7getNameERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef7getNameERNS_9StringRefE")
  //</editor-fold>
  public /*inline*/ std.error_code getName(final StringRef /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::getAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 371,
   FQN="llvm::object::SectionRef::getAddress", NM="_ZNK4llvm6object10SectionRef10getAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef10getAddressEv")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getAddress() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::getSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 375,
   FQN="llvm::object::SectionRef::getSize", NM="_ZNK4llvm6object10SectionRef7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef7getSizeEv")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::getContents">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 379,
   FQN="llvm::object::SectionRef::getContents", NM="_ZNK4llvm6object10SectionRef11getContentsERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef11getContentsERNS_9StringRefE")
  //</editor-fold>
  public /*inline*/ std.error_code getContents(final StringRef /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Get the alignment of this section as the actual value (not log 2).
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::getAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 383,
   FQN="llvm::object::SectionRef::getAlignment", NM="_ZNK4llvm6object10SectionRef12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef12getAlignmentEv")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getAlignment() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::isCompressed">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 387,
   FQN="llvm::object::SectionRef::isCompressed", NM="_ZNK4llvm6object10SectionRef12isCompressedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef12isCompressedEv")
  //</editor-fold>
  public /*inline*/ boolean isCompressed() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::isText">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 391,
   FQN="llvm::object::SectionRef::isText", NM="_ZNK4llvm6object10SectionRef6isTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef6isTextEv")
  //</editor-fold>
  public /*inline*/ boolean isText() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::isData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 395,
   FQN="llvm::object::SectionRef::isData", NM="_ZNK4llvm6object10SectionRef6isDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef6isDataEv")
  //</editor-fold>
  public /*inline*/ boolean isData() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::isBSS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 399,
   FQN="llvm::object::SectionRef::isBSS", NM="_ZNK4llvm6object10SectionRef5isBSSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef5isBSSEv")
  //</editor-fold>
  public /*inline*/ boolean isBSS() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::isVirtual">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 403,
   FQN="llvm::object::SectionRef::isVirtual", NM="_ZNK4llvm6object10SectionRef9isVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef9isVirtualEv")
  //</editor-fold>
  public /*inline*/ boolean isVirtual() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::isBitcode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 407,
   FQN="llvm::object::SectionRef::isBitcode", NM="_ZNK4llvm6object10SectionRef9isBitcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef9isBitcodeEv")
  //</editor-fold>
  public /*inline*/ boolean isBitcode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::containsSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 100,
   FQN="llvm::object::SectionRef::containsSymbol", NM="_ZNK4llvm6object10SectionRef14containsSymbolENS0_9SymbolRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef14containsSymbolENS0_9SymbolRefE")
  //</editor-fold>
  public boolean containsSymbol(SymbolRef S) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::relocation_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 411,
   FQN="llvm::object::SectionRef::relocation_begin", NM="_ZNK4llvm6object10SectionRef16relocation_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef16relocation_beginEv")
  //</editor-fold>
  public /*inline*/ content_iterator<RelocationRef> relocation_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::relocation_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 415,
   FQN="llvm::object::SectionRef::relocation_end", NM="_ZNK4llvm6object10SectionRef14relocation_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef14relocation_endEv")
  //</editor-fold>
  public /*inline*/ content_iterator<RelocationRef> relocation_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::relocations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 104,
   FQN="llvm::object::SectionRef::relocations", NM="_ZNK4llvm6object10SectionRef11relocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef11relocationsEv")
  //</editor-fold>
  public iterator_range</*const*/ RelocationRef /*&*/ > relocations() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::getRelocatedSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 419,
   FQN="llvm::object::SectionRef::getRelocatedSection", NM="_ZNK4llvm6object10SectionRef19getRelocatedSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef19getRelocatedSectionEv")
  //</editor-fold>
  public /*inline*/ content_iterator<SectionRef> getRelocatedSection() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::getRawDataRefImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 423,
   FQN="llvm::object::SectionRef::getRawDataRefImpl", NM="_ZNK4llvm6object10SectionRef17getRawDataRefImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef17getRawDataRefImplEv")
  //</editor-fold>
  public /*inline*/ DataRefImpl getRawDataRefImpl() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::getObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 427,
   FQN="llvm::object::SectionRef::getObject", NM="_ZNK4llvm6object10SectionRef9getObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object10SectionRef9getObjectEv")
  //</editor-fold>
  public /*inline*/ /*const*/ ObjectFile /*P*/ getObject() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::SectionRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 69,
   FQN="llvm::object::SectionRef::SectionRef", NM="_ZN4llvm6object10SectionRefC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object10SectionRefC1ERKS1_")
  //</editor-fold>
  public /*inline*/ SectionRef(final /*const*/ SectionRef /*&*/ $Prm0) {
    // : SectionPimpl(.SectionPimpl), OwningObject(.OwningObject) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SectionRef::SectionRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 69,
   FQN="llvm::object::SectionRef::SectionRef", NM="_ZN4llvm6object10SectionRefC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object10SectionRefC1EOS1_")
  //</editor-fold>
  public /*inline*/ SectionRef(JD$Move _dparam, final SectionRef /*&&*/$Prm0) {
    // : SectionPimpl(static_cast<SectionRef &&>().SectionPimpl), OwningObject(static_cast<SectionRef &&>().OwningObject) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "SectionPimpl=" + SectionPimpl // NOI18N
              + ", OwningObject=" + OwningObject; // NOI18N
  }
}
