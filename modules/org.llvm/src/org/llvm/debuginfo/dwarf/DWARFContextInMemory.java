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

package org.llvm.debuginfo.dwarf;

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
import org.llvm.debuginfo.*;


/// DWARFContextInMemory is the simplest possible implementation of a
/// DWARFContext. It assumes all content is available in memory and stores
/// pointers to it.
//<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 240,
 FQN="llvm::DWARFContextInMemory", NM="_ZN4llvm20DWARFContextInMemoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemoryE")
//</editor-fold>
public class DWARFContextInMemory extends /*public*/ DWARFContext implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::anchor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 241,
   FQN="llvm::DWARFContextInMemory::anchor", NM="_ZN4llvm20DWARFContextInMemory6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory6anchorEv")
  //</editor-fold>
  protected/*private*/ /*virtual*/ void anchor() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  private boolean IsLittleEndian;
  private byte/*uint8_t*/ AddressSize;
  private DWARFSection InfoSection;
  private MapVectorTypeType<SectionRef, DWARFSection> TypesSections;
  private StringRef AbbrevSection;
  private DWARFSection LocSection;
  private StringRef ARangeSection;
  private StringRef DebugFrameSection;
  private StringRef EHFrameSection;
  private DWARFSection LineSection;
  private StringRef StringSection;
  private StringRef RangeSection;
  private StringRef MacinfoSection;
  private StringRef PubNamesSection;
  private StringRef PubTypesSection;
  private StringRef GnuPubNamesSection;
  private StringRef GnuPubTypesSection;
  
  // Sections for DWARF5 split dwarf proposal.
  private DWARFSection InfoDWOSection;
  private MapVectorTypeType<SectionRef, DWARFSection> TypesDWOSections;
  private StringRef AbbrevDWOSection;
  private DWARFSection LineDWOSection;
  private DWARFSection LocDWOSection;
  private StringRef StringDWOSection;
  private StringRef StringOffsetDWOSection;
  private StringRef RangeDWOSection;
  private StringRef AddrSection;
  private DWARFSection AppleNamesSection;
  private DWARFSection AppleTypesSection;
  private DWARFSection AppleNamespacesSection;
  private DWARFSection AppleObjCSection;
  private StringRef CUIndexSection;
  private StringRef TUIndexSection;
  
  private SmallVector<SmallString/*32*/> UncompressedSections;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::DWARFContextInMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 280,
   FQN="llvm::DWARFContextInMemory::DWARFContextInMemory", NM="_ZN4llvm20DWARFContextInMemoryC1ERKNS_6object10ObjectFileEPKNS_16LoadedObjectInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemoryC1ERKNS_6object10ObjectFileEPKNS_16LoadedObjectInfoE")
  //</editor-fold>
  public DWARFContextInMemory(final /*const*/ ObjectFile /*&*/ Obj) {
    this(Obj, 
      (/*const*/ LoadedObjectInfo /*P*/ )null);
  }
  public DWARFContextInMemory(final /*const*/ ObjectFile /*&*/ Obj, 
      /*const*/ LoadedObjectInfo /*P*/ L/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::isLittleEndian">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 282,
   FQN="llvm::DWARFContextInMemory::isLittleEndian", NM="_ZNK4llvm20DWARFContextInMemory14isLittleEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm20DWARFContextInMemory14isLittleEndianEv")
  //</editor-fold>
  @Override public boolean isLittleEndian() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getAddressSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 283,
   FQN="llvm::DWARFContextInMemory::getAddressSize", NM="_ZNK4llvm20DWARFContextInMemory14getAddressSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm20DWARFContextInMemory14getAddressSizeEv")
  //</editor-fold>
  @Override public byte/*uint8_t*/ getAddressSize() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getInfoSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 284,
   FQN="llvm::DWARFContextInMemory::getInfoSection", NM="_ZN4llvm20DWARFContextInMemory14getInfoSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory14getInfoSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getInfoSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getTypesSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 285,
   FQN="llvm::DWARFContextInMemory::getTypesSections", NM="_ZN4llvm20DWARFContextInMemory16getTypesSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory16getTypesSectionsEv")
  //</editor-fold>
  @Override public /*const*/MapVectorTypeType<SectionRef, DWARFSection> /*&*/ getTypesSections()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getAbbrevSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 286,
   FQN="llvm::DWARFContextInMemory::getAbbrevSection", NM="_ZN4llvm20DWARFContextInMemory16getAbbrevSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory16getAbbrevSectionEv")
  //</editor-fold>
  @Override public StringRef getAbbrevSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getLocSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 287,
   FQN="llvm::DWARFContextInMemory::getLocSection", NM="_ZN4llvm20DWARFContextInMemory13getLocSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory13getLocSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getLocSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getARangeSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 288,
   FQN="llvm::DWARFContextInMemory::getARangeSection", NM="_ZN4llvm20DWARFContextInMemory16getARangeSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory16getARangeSectionEv")
  //</editor-fold>
  @Override public StringRef getARangeSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getDebugFrameSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 289,
   FQN="llvm::DWARFContextInMemory::getDebugFrameSection", NM="_ZN4llvm20DWARFContextInMemory20getDebugFrameSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory20getDebugFrameSectionEv")
  //</editor-fold>
  @Override public StringRef getDebugFrameSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getEHFrameSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 290,
   FQN="llvm::DWARFContextInMemory::getEHFrameSection", NM="_ZN4llvm20DWARFContextInMemory17getEHFrameSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory17getEHFrameSectionEv")
  //</editor-fold>
  @Override public StringRef getEHFrameSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getLineSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 291,
   FQN="llvm::DWARFContextInMemory::getLineSection", NM="_ZN4llvm20DWARFContextInMemory14getLineSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory14getLineSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getLineSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getStringSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 292,
   FQN="llvm::DWARFContextInMemory::getStringSection", NM="_ZN4llvm20DWARFContextInMemory16getStringSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory16getStringSectionEv")
  //</editor-fold>
  @Override public StringRef getStringSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getRangeSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 293,
   FQN="llvm::DWARFContextInMemory::getRangeSection", NM="_ZN4llvm20DWARFContextInMemory15getRangeSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory15getRangeSectionEv")
  //</editor-fold>
  @Override public StringRef getRangeSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getMacinfoSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 294,
   FQN="llvm::DWARFContextInMemory::getMacinfoSection", NM="_ZN4llvm20DWARFContextInMemory17getMacinfoSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory17getMacinfoSectionEv")
  //</editor-fold>
  @Override public StringRef getMacinfoSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getPubNamesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 295,
   FQN="llvm::DWARFContextInMemory::getPubNamesSection", NM="_ZN4llvm20DWARFContextInMemory18getPubNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory18getPubNamesSectionEv")
  //</editor-fold>
  @Override public StringRef getPubNamesSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getPubTypesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 296,
   FQN="llvm::DWARFContextInMemory::getPubTypesSection", NM="_ZN4llvm20DWARFContextInMemory18getPubTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory18getPubTypesSectionEv")
  //</editor-fold>
  @Override public StringRef getPubTypesSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getGnuPubNamesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 297,
   FQN="llvm::DWARFContextInMemory::getGnuPubNamesSection", NM="_ZN4llvm20DWARFContextInMemory21getGnuPubNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory21getGnuPubNamesSectionEv")
  //</editor-fold>
  @Override public StringRef getGnuPubNamesSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getGnuPubTypesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 298,
   FQN="llvm::DWARFContextInMemory::getGnuPubTypesSection", NM="_ZN4llvm20DWARFContextInMemory21getGnuPubTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory21getGnuPubTypesSectionEv")
  //</editor-fold>
  @Override public StringRef getGnuPubTypesSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getAppleNamesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 299,
   FQN="llvm::DWARFContextInMemory::getAppleNamesSection", NM="_ZN4llvm20DWARFContextInMemory20getAppleNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory20getAppleNamesSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getAppleNamesSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getAppleTypesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 300,
   FQN="llvm::DWARFContextInMemory::getAppleTypesSection", NM="_ZN4llvm20DWARFContextInMemory20getAppleTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory20getAppleTypesSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getAppleTypesSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getAppleNamespacesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 301,
   FQN="llvm::DWARFContextInMemory::getAppleNamespacesSection", NM="_ZN4llvm20DWARFContextInMemory25getAppleNamespacesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory25getAppleNamespacesSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getAppleNamespacesSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getAppleObjCSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 302,
   FQN="llvm::DWARFContextInMemory::getAppleObjCSection", NM="_ZN4llvm20DWARFContextInMemory19getAppleObjCSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory19getAppleObjCSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getAppleObjCSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Sections for DWARF5 split dwarf proposal.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getInfoDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 305,
   FQN="llvm::DWARFContextInMemory::getInfoDWOSection", NM="_ZN4llvm20DWARFContextInMemory17getInfoDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory17getInfoDWOSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getInfoDWOSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getTypesDWOSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 306,
   FQN="llvm::DWARFContextInMemory::getTypesDWOSections", NM="_ZN4llvm20DWARFContextInMemory19getTypesDWOSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory19getTypesDWOSectionsEv")
  //</editor-fold>
  @Override public /*const*/MapVectorTypeType<SectionRef, DWARFSection> /*&*/ getTypesDWOSections()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getAbbrevDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 309,
   FQN="llvm::DWARFContextInMemory::getAbbrevDWOSection", NM="_ZN4llvm20DWARFContextInMemory19getAbbrevDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory19getAbbrevDWOSectionEv")
  //</editor-fold>
  @Override public StringRef getAbbrevDWOSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getLineDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 310,
   FQN="llvm::DWARFContextInMemory::getLineDWOSection", NM="_ZN4llvm20DWARFContextInMemory17getLineDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory17getLineDWOSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getLineDWOSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getLocDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 311,
   FQN="llvm::DWARFContextInMemory::getLocDWOSection", NM="_ZN4llvm20DWARFContextInMemory16getLocDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory16getLocDWOSectionEv")
  //</editor-fold>
  @Override public /*const*/ DWARFSection /*&*/ getLocDWOSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getStringDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 312,
   FQN="llvm::DWARFContextInMemory::getStringDWOSection", NM="_ZN4llvm20DWARFContextInMemory19getStringDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory19getStringDWOSectionEv")
  //</editor-fold>
  @Override public StringRef getStringDWOSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getStringOffsetDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 313,
   FQN="llvm::DWARFContextInMemory::getStringOffsetDWOSection", NM="_ZN4llvm20DWARFContextInMemory25getStringOffsetDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory25getStringOffsetDWOSectionEv")
  //</editor-fold>
  @Override public StringRef getStringOffsetDWOSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getRangeDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 316,
   FQN="llvm::DWARFContextInMemory::getRangeDWOSection", NM="_ZN4llvm20DWARFContextInMemory18getRangeDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory18getRangeDWOSectionEv")
  //</editor-fold>
  @Override public StringRef getRangeDWOSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getAddrSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 317,
   FQN="llvm::DWARFContextInMemory::getAddrSection", NM="_ZN4llvm20DWARFContextInMemory14getAddrSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory14getAddrSectionEv")
  //</editor-fold>
  @Override public StringRef getAddrSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getCUIndexSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 320,
   FQN="llvm::DWARFContextInMemory::getCUIndexSection", NM="_ZN4llvm20DWARFContextInMemory17getCUIndexSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory17getCUIndexSectionEv")
  //</editor-fold>
  @Override public StringRef getCUIndexSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::getTUIndexSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 321,
   FQN="llvm::DWARFContextInMemory::getTUIndexSection", NM="_ZN4llvm20DWARFContextInMemory17getTUIndexSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemory17getTUIndexSectionEv")
  //</editor-fold>
  @Override public StringRef getTUIndexSection()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContextInMemory::~DWARFContextInMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 240,
   FQN="llvm::DWARFContextInMemory::~DWARFContextInMemory", NM="_ZN4llvm20DWARFContextInMemoryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFContextInMemoryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "IsLittleEndian=" + IsLittleEndian // NOI18N
              + ", AddressSize=" + $uchar2uint(AddressSize) // NOI18N
              + ", InfoSection=" + InfoSection // NOI18N
              + ", TypesSections=" + TypesSections // NOI18N
              + ", AbbrevSection=" + AbbrevSection // NOI18N
              + ", LocSection=" + LocSection // NOI18N
              + ", ARangeSection=" + ARangeSection // NOI18N
              + ", DebugFrameSection=" + DebugFrameSection // NOI18N
              + ", EHFrameSection=" + EHFrameSection // NOI18N
              + ", LineSection=" + LineSection // NOI18N
              + ", StringSection=" + StringSection // NOI18N
              + ", RangeSection=" + RangeSection // NOI18N
              + ", MacinfoSection=" + MacinfoSection // NOI18N
              + ", PubNamesSection=" + PubNamesSection // NOI18N
              + ", PubTypesSection=" + PubTypesSection // NOI18N
              + ", GnuPubNamesSection=" + GnuPubNamesSection // NOI18N
              + ", GnuPubTypesSection=" + GnuPubTypesSection // NOI18N
              + ", InfoDWOSection=" + InfoDWOSection // NOI18N
              + ", TypesDWOSections=" + TypesDWOSections // NOI18N
              + ", AbbrevDWOSection=" + AbbrevDWOSection // NOI18N
              + ", LineDWOSection=" + LineDWOSection // NOI18N
              + ", LocDWOSection=" + LocDWOSection // NOI18N
              + ", StringDWOSection=" + StringDWOSection // NOI18N
              + ", StringOffsetDWOSection=" + StringOffsetDWOSection // NOI18N
              + ", RangeDWOSection=" + RangeDWOSection // NOI18N
              + ", AddrSection=" + AddrSection // NOI18N
              + ", AppleNamesSection=" + AppleNamesSection // NOI18N
              + ", AppleTypesSection=" + AppleTypesSection // NOI18N
              + ", AppleNamespacesSection=" + AppleNamespacesSection // NOI18N
              + ", AppleObjCSection=" + AppleObjCSection // NOI18N
              + ", CUIndexSection=" + CUIndexSection // NOI18N
              + ", TUIndexSection=" + TUIndexSection // NOI18N
              + ", UncompressedSections=" + UncompressedSections // NOI18N
              + super.toString(); // NOI18N
  }
}
