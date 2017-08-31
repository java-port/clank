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
import org.llvm.java.LlvmJavaDifferentiators.*;
import org.llvm.debuginfo.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;
import org.llvm.mc.*;
import org.llvm.support.sys.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IRFunctionPointers.*;
import org.llvm.support.dwarf.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 103,
 FQN="llvm::DWARFUnit", NM="_ZN4llvm9DWARFUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnitE")
//</editor-fold>
public class DWARFUnit implements Destructors.ClassWithDestructor {
  private final DWARFContext /*&*/ Context;
  // Section containing this DWARFUnit.
  private final /*const*/ DWARFSection /*&*/ InfoSection;
  
  private /*const*/ DWARFDebugAbbrev /*P*/ Abbrev;
  private StringRef RangeSection;
  private /*uint32_t*/int RangeSectionBase;
  private StringRef LineSection;
  private StringRef StringSection;
  private StringRef StringOffsetSection;
  private StringRef AddrOffsetSection;
  private /*uint32_t*/int AddrOffsetSectionBase;
  private boolean isLittleEndian;
  private boolean isDWO;
  private final /*const*/ DWARFUnitSectionBase /*&*/ UnitSection;
  
  private /*uint32_t*/int Offset;
  private /*uint32_t*/int Length;
  private /*uint16_t*/char Version;
  private /*const*/ DWARFAbbreviationDeclarationSet /*P*/ Abbrevs;
  private byte/*uint8_t*/ AddrSize;
  private long/*uint64_t*/ BaseAddr;
  // The compile unit debug information entry items.
  private std.vector<DWARFDebugInfoEntryMinimal> DieArray;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::DWOHolder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 129,
   FQN="llvm::DWARFUnit::DWOHolder", NM="_ZN4llvm9DWARFUnit9DWOHolderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit9DWOHolderE")
  //</editor-fold>
  private static class DWOHolder implements Destructors.ClassWithDestructor {
    private OwningBinary<ObjectFile> DWOFile;
    private std.unique_ptr<DWARFContext> DWOContext;
    private DWARFUnit /*P*/ DWOU;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::DWOHolder::DWOHolder">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 134,
     FQN="llvm::DWARFUnit::DWOHolder::DWOHolder", NM="_ZN4llvm9DWARFUnit9DWOHolderC1ENS_9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit9DWOHolderC1ENS_9StringRefE")
    //</editor-fold>
    public DWOHolder(StringRef DWOPath) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::DWOHolder::getUnit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 135,
     FQN="llvm::DWARFUnit::DWOHolder::getUnit", NM="_ZNK4llvm9DWARFUnit9DWOHolder7getUnitEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit9DWOHolder7getUnitEv")
    //</editor-fold>
    public DWARFUnit /*P*/ getUnit() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::DWOHolder::~DWOHolder">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 129,
     FQN="llvm::DWARFUnit::DWOHolder::~DWOHolder", NM="_ZN4llvm9DWARFUnit9DWOHolderD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit9DWOHolderD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }


    
    @Override public String toString() {
      return "" + "DWOFile=" + DWOFile // NOI18N
                + ", DWOContext=" + "[Unique_ptr$DWARFContext]" // NOI18N
                + ", DWOU=" + DWOU; // NOI18N
    }
  };
  private std.unique_ptr<DWOHolder> DWO;
  
  private /*const*/ DWARFUnitIndex.Entry /*P*/ IndexEntry;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::extractImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 142,
   FQN="llvm::DWARFUnit::extractImpl", NM="_ZN4llvm9DWARFUnit11extractImplENS_13DataExtractorEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit11extractImplENS_13DataExtractorEPj")
  //</editor-fold>
  protected /*virtual*/ boolean extractImpl(DataExtractor debug_info, /*uint32_t P*/uint$ptr offset_ptr) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// Size in bytes of the unit header.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getHeaderSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 144,
   FQN="llvm::DWARFUnit::getHeaderSize", NM="_ZNK4llvm9DWARFUnit13getHeaderSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit13getHeaderSizeEv")
  //</editor-fold>
  protected /*virtual*/ /*uint32_t*/int getHeaderSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::DWARFUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 147,
   FQN="llvm::DWARFUnit::DWARFUnit", NM="_ZN4llvm9DWARFUnitC1ERNS_12DWARFContextERKNS_12DWARFSectionEPKNS_16DWARFDebugAbbrevENS_9StringRefES9_S9_S9_S9_bbRKNS_20DWARFUnitSectionBaseEPKNS_14DWARFUnitIndex5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnitC1ERNS_12DWARFContextERKNS_12DWARFSectionEPKNS_16DWARFDebugAbbrevENS_9StringRefES9_S9_S9_S9_bbRKNS_20DWARFUnitSectionBaseEPKNS_14DWARFUnitIndex5EntryE")
  //</editor-fold>
  public DWARFUnit(final DWARFContext /*&*/ Context, final /*const*/ DWARFSection /*&*/ Section, 
      /*const*/ DWARFDebugAbbrev /*P*/ DA, StringRef RS, StringRef SS, 
      StringRef SOS, StringRef AOS, StringRef LS, boolean LE, boolean IsDWO, 
      final /*const*/ DWARFUnitSectionBase /*&*/ UnitSection) {
    this(Context, Section, 
      DA, RS, SS, 
      SOS, AOS, LS, LE, IsDWO, 
      UnitSection, 
      (/*const*/ DWARFUnitIndex.Entry /*P*/ )null);
  }
  public DWARFUnit(final DWARFContext /*&*/ Context, final /*const*/ DWARFSection /*&*/ Section, 
      /*const*/ DWARFDebugAbbrev /*P*/ DA, StringRef RS, StringRef SS, 
      StringRef SOS, StringRef AOS, StringRef LS, boolean LE, boolean IsDWO, 
      final /*const*/ DWARFUnitSectionBase /*&*/ UnitSection, 
      /*const*/ DWARFUnitIndex.Entry /*P*/ IndexEntry/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::~DWARFUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 153,
   FQN="llvm::DWARFUnit::~DWARFUnit", NM="_ZN4llvm9DWARFUnitD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnitD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 155,
   FQN="llvm::DWARFUnit::getContext", NM="_ZNK4llvm9DWARFUnit10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit10getContextEv")
  //</editor-fold>
  public DWARFContext /*&*/ getContext() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getLineSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 157,
   FQN="llvm::DWARFUnit::getLineSection", NM="_ZNK4llvm9DWARFUnit14getLineSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit14getLineSectionEv")
  //</editor-fold>
  public StringRef getLineSection() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getStringSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 158,
   FQN="llvm::DWARFUnit::getStringSection", NM="_ZNK4llvm9DWARFUnit16getStringSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit16getStringSectionEv")
  //</editor-fold>
  public StringRef getStringSection() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getStringOffsetSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 159,
   FQN="llvm::DWARFUnit::getStringOffsetSection", NM="_ZNK4llvm9DWARFUnit22getStringOffsetSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit22getStringOffsetSectionEv")
  //</editor-fold>
  public StringRef getStringOffsetSection() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::setAddrOffsetSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 160,
   FQN="llvm::DWARFUnit::setAddrOffsetSection", NM="_ZN4llvm9DWARFUnit20setAddrOffsetSectionENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit20setAddrOffsetSectionENS_9StringRefEj")
  //</editor-fold>
  public void setAddrOffsetSection(StringRef AOS, /*uint32_t*/int Base) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::setRangesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 164,
   FQN="llvm::DWARFUnit::setRangesSection", NM="_ZN4llvm9DWARFUnit16setRangesSectionENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit16setRangesSectionENS_9StringRefEj")
  //</editor-fold>
  public void setRangesSection(StringRef RS, /*uint32_t*/int Base) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getAddrOffsetSectionItem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 169,
   FQN="llvm::DWARFUnit::getAddrOffsetSectionItem", NM="_ZNK4llvm9DWARFUnit24getAddrOffsetSectionItemEjRy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit24getAddrOffsetSectionItemEjRy")
  //</editor-fold>
  public boolean getAddrOffsetSectionItem(/*uint32_t*/int Index, final ulong$ref/*uint64_t &*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  // FIXME: Result should be uint64_t in DWARF64.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getStringOffsetSectionItem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 171,
   FQN="llvm::DWARFUnit::getStringOffsetSectionItem", NM="_ZNK4llvm9DWARFUnit26getStringOffsetSectionItemEjRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit26getStringOffsetSectionItemEjRj")
  //</editor-fold>
  public boolean getStringOffsetSectionItem(/*uint32_t*/int Index, final /*uint32_t &*/uint$ref Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getDebugInfoExtractor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 173,
   FQN="llvm::DWARFUnit::getDebugInfoExtractor", NM="_ZNK4llvm9DWARFUnit21getDebugInfoExtractorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit21getDebugInfoExtractorEv")
  //</editor-fold>
  public DataExtractor getDebugInfoExtractor() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getStringExtractor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 176,
   FQN="llvm::DWARFUnit::getStringExtractor", NM="_ZNK4llvm9DWARFUnit18getStringExtractorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit18getStringExtractorEv")
  //</editor-fold>
  public DataExtractor getStringExtractor() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getRelocMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 180,
   FQN="llvm::DWARFUnit::getRelocMap", NM="_ZNK4llvm9DWARFUnit11getRelocMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit11getRelocMapEv")
  //</editor-fold>
  public /*const*/DenseMapULongType<std.pairUCharLong> /*P*/ getRelocMap() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::extract">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 182,
   FQN="llvm::DWARFUnit::extract", NM="_ZN4llvm9DWARFUnit7extractENS_13DataExtractorEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit7extractENS_13DataExtractorEPj")
  //</editor-fold>
  public boolean extract(DataExtractor debug_info, /*uint32_t P*/uint$ptr offset_ptr) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// extractRangeList - extracts the range list referenced by this compile
  /// unit from .debug_ranges section. Returns true on success.
  /// Requires that compile unit is already extracted.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::extractRangeList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 187,
   FQN="llvm::DWARFUnit::extractRangeList", NM="_ZNK4llvm9DWARFUnit16extractRangeListEjRNS_19DWARFDebugRangeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit16extractRangeListEjRNS_19DWARFDebugRangeListE")
  //</editor-fold>
  public boolean extractRangeList(/*uint32_t*/int RangeListOffset, 
                  final DWARFDebugRangeList /*&*/ RangeList) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 189,
   FQN="llvm::DWARFUnit::clear", NM="_ZN4llvm9DWARFUnit5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit5clearEv")
  //</editor-fold>
  public void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 190,
   FQN="llvm::DWARFUnit::getOffset", NM="_ZNK4llvm9DWARFUnit9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit9getOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getNextUnitOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 191,
   FQN="llvm::DWARFUnit::getNextUnitOffset", NM="_ZNK4llvm9DWARFUnit17getNextUnitOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit17getNextUnitOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getNextUnitOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getLength">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 192,
   FQN="llvm::DWARFUnit::getLength", NM="_ZNK4llvm9DWARFUnit9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit9getLengthEv")
  //</editor-fold>
  public /*uint32_t*/int getLength() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getVersion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 193,
   FQN="llvm::DWARFUnit::getVersion", NM="_ZNK4llvm9DWARFUnit10getVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit10getVersionEv")
  //</editor-fold>
  public /*uint16_t*/char getVersion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getAbbreviations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 194,
   FQN="llvm::DWARFUnit::getAbbreviations", NM="_ZNK4llvm9DWARFUnit16getAbbreviationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit16getAbbreviationsEv")
  //</editor-fold>
  public /*const*/ DWARFAbbreviationDeclarationSet /*P*/ getAbbreviations() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getAddressByteSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 197,
   FQN="llvm::DWARFUnit::getAddressByteSize", NM="_ZNK4llvm9DWARFUnit18getAddressByteSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit18getAddressByteSizeEv")
  //</editor-fold>
  public byte/*uint8_t*/ getAddressByteSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getBaseAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 198,
   FQN="llvm::DWARFUnit::getBaseAddress", NM="_ZNK4llvm9DWARFUnit14getBaseAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit14getBaseAddressEv")
  //</editor-fold>
  public long/*uint64_t*/ getBaseAddress() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::setBaseAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 200,
   FQN="llvm::DWARFUnit::setBaseAddress", NM="_ZN4llvm9DWARFUnit14setBaseAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit14setBaseAddressEy")
  //</editor-fold>
  public void setBaseAddress(long/*uint64_t*/ base_addr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getUnitDIE">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 204,
   FQN="llvm::DWARFUnit::getUnitDIE", NM="_ZN4llvm9DWARFUnit10getUnitDIEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit10getUnitDIEEb")
  //</editor-fold>
  public /*const*/ DWARFDebugInfoEntryMinimal /*P*/ getUnitDIE() {
    return getUnitDIE(true);
  }
  public /*const*/ DWARFDebugInfoEntryMinimal /*P*/ getUnitDIE(boolean ExtractUnitDIEOnly/*= true*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getCompilationDir">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 209,
   FQN="llvm::DWARFUnit::getCompilationDir", NM="_ZN4llvm9DWARFUnit17getCompilationDirEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit17getCompilationDirEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCompilationDir() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getDWOId">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 210,
   FQN="llvm::DWARFUnit::getDWOId", NM="_ZN4llvm9DWARFUnit8getDWOIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit8getDWOIdEv")
  //</editor-fold>
  public long/*uint64_t*/ getDWOId() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::collectAddressRanges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 212,
   FQN="llvm::DWARFUnit::collectAddressRanges", NM="_ZN4llvm9DWARFUnit20collectAddressRangesERSt6vectorISt4pairIyyESaIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit20collectAddressRangesERSt6vectorISt4pairIyyESaIS3_EE")
  //</editor-fold>
  public void collectAddressRanges(final std.vector<std.pairULongULong> /*&*/ CURanges) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// getInlinedChainForAddress - fetches inlined chain for a given address.
  /// Returns empty chain if there is no subprogram containing address. The
  /// chain is valid as long as parsed compile unit DIEs are not cleared.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getInlinedChainForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 217,
   FQN="llvm::DWARFUnit::getInlinedChainForAddress", NM="_ZN4llvm9DWARFUnit25getInlinedChainForAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit25getInlinedChainForAddressEy")
  //</editor-fold>
  public DWARFDebugInfoEntryInlinedChain getInlinedChainForAddress(long/*uint64_t*/ Address) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// getUnitSection - Return the DWARFUnitSection containing this unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getUnitSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 220,
   FQN="llvm::DWARFUnit::getUnitSection", NM="_ZNK4llvm9DWARFUnit14getUnitSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit14getUnitSectionEv")
  //</editor-fold>
  public /*const*/ DWARFUnitSectionBase /*&*/ getUnitSection() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the number of DIEs in the unit. Parses the unit
  /// if necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getNumDIEs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 224,
   FQN="llvm::DWARFUnit::getNumDIEs", NM="_ZN4llvm9DWARFUnit10getNumDIEsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit10getNumDIEsEv")
  //</editor-fold>
  public /*uint*/int getNumDIEs() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the index of a DIE inside the unit's DIE vector.
  ///
  /// It is illegal to call this method with a DIE that hasn't be
  /// created by this unit. In other word, it's illegal to call this
  /// method on a DIE that isn't accessible by following
  /// children/sibling links starting from this unit's getUnitDIE().
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getDIEIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 235,
   FQN="llvm::DWARFUnit::getDIEIndex", NM="_ZN4llvm9DWARFUnit11getDIEIndexEPKNS_26DWARFDebugInfoEntryMinimalE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit11getDIEIndexEPKNS_26DWARFDebugInfoEntryMinimalE")
  //</editor-fold>
  public /*uint32_t*/int getDIEIndex(/*const*/ DWARFDebugInfoEntryMinimal /*P*/ DIE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the DIE object at the given index.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getDIEAtIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 242,
   FQN="llvm::DWARFUnit::getDIEAtIndex", NM="_ZNK4llvm9DWARFUnit13getDIEAtIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit13getDIEAtIndexEj")
  //</editor-fold>
  public /*const*/ DWARFDebugInfoEntryMinimal /*P*/ getDIEAtIndex(/*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the DIE object for a given offset inside the
  /// unit's DIE vector.
  ///
  /// The unit needs to have its DIEs extracted for this method to work.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getDIEForOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 251,
   FQN="llvm::DWARFUnit::getDIEForOffset", NM="_ZNK4llvm9DWARFUnit15getDIEForOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit15getDIEForOffsetEj")
  //</editor-fold>
  public /*const*/ DWARFDebugInfoEntryMinimal /*P*/ getDIEForOffset(/*uint32_t*/int Offset) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getLineTableOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 261,
   FQN="llvm::DWARFUnit::getLineTableOffset", NM="_ZNK4llvm9DWARFUnit18getLineTableOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit18getLineTableOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getLineTableOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Size in bytes of the .debug_info data associated with this compile unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getDebugInfoSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 270,
   FQN="llvm::DWARFUnit::getDebugInfoSize", NM="_ZNK4llvm9DWARFUnit16getDebugInfoSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit16getDebugInfoSizeEv")
  //</editor-fold>
  private /*size_t*/int getDebugInfoSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// extractDIEsIfNeeded - Parses a compile unit and indexes its DIEs if it
  /// hasn't already been done. Returns the number of DIEs parsed at this call.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::extractDIEsIfNeeded">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 274,
   FQN="llvm::DWARFUnit::extractDIEsIfNeeded", NM="_ZN4llvm9DWARFUnit19extractDIEsIfNeededEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit19extractDIEsIfNeededEb")
  //</editor-fold>
  private /*size_t*/int extractDIEsIfNeeded(boolean CUDieOnly) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// extractDIEsToVector - Appends all parsed DIEs to a vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::extractDIEsToVector">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 276,
   FQN="llvm::DWARFUnit::extractDIEsToVector", NM="_ZNK4llvm9DWARFUnit19extractDIEsToVectorEbbRSt6vectorINS_26DWARFDebugInfoEntryMinimalESaIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DWARFUnit19extractDIEsToVectorEbbRSt6vectorINS_26DWARFDebugInfoEntryMinimalESaIS2_EE")
  //</editor-fold>
  private void extractDIEsToVector(boolean AppendCUDie, boolean AppendNonCUDIEs, 
                     final std.vector<DWARFDebugInfoEntryMinimal> /*&*/ DIEs) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// setDIERelations - We read in all of the DIE entries into our flat list
  /// of DIE entries and now we need to go back through all of them and set the
  /// parent, sibling and child pointers for quick DIE navigation.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::setDIERelations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 281,
   FQN="llvm::DWARFUnit::setDIERelations", NM="_ZN4llvm9DWARFUnit15setDIERelationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit15setDIERelationsEv")
  //</editor-fold>
  private void setDIERelations() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// clearDIEs - Clear parsed DIEs to keep memory usage low.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::clearDIEs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 283,
   FQN="llvm::DWARFUnit::clearDIEs", NM="_ZN4llvm9DWARFUnit9clearDIEsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit9clearDIEsEb")
  //</editor-fold>
  private void clearDIEs(boolean KeepCUDie) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// parseDWO - Parses .dwo file for current compile unit. Returns true if
  /// it was actually constructed.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::parseDWO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 287,
   FQN="llvm::DWARFUnit::parseDWO", NM="_ZN4llvm9DWARFUnit8parseDWOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit8parseDWOEv")
  //</editor-fold>
  private boolean parseDWO() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// getSubprogramForAddress - Returns subprogram DIE with address range
  /// encompassing the provided address. The pointer is alive as long as parsed
  /// compile unit DIEs are not cleared.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnit::getSubprogramForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 292,
   FQN="llvm::DWARFUnit::getSubprogramForAddress", NM="_ZN4llvm9DWARFUnit23getSubprogramForAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DWARFUnit23getSubprogramForAddressEy")
  //</editor-fold>
  private /*const*/ DWARFDebugInfoEntryMinimal /*P*/ getSubprogramForAddress(long/*uint64_t*/ Address) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "Context=" + "[DWARFContext]" // NOI18N
              + ", InfoSection=" + InfoSection // NOI18N
              + ", Abbrev=" + Abbrev // NOI18N
              + ", RangeSection=" + RangeSection // NOI18N
              + ", RangeSectionBase=" + RangeSectionBase // NOI18N
              + ", LineSection=" + LineSection // NOI18N
              + ", StringSection=" + StringSection // NOI18N
              + ", StringOffsetSection=" + StringOffsetSection // NOI18N
              + ", AddrOffsetSection=" + AddrOffsetSection // NOI18N
              + ", AddrOffsetSectionBase=" + AddrOffsetSectionBase // NOI18N
              + ", isLittleEndian=" + isLittleEndian // NOI18N
              + ", isDWO=" + isDWO // NOI18N
              + ", UnitSection=" + UnitSection // NOI18N
              + ", Offset=" + Offset // NOI18N
              + ", Length=" + Length // NOI18N
              + ", Version=" + $ushort2uint(Version) // NOI18N
              + ", Abbrevs=" + Abbrevs // NOI18N
              + ", AddrSize=" + $uchar2uint(AddrSize) // NOI18N
              + ", BaseAddr=" + BaseAddr // NOI18N
              + ", DieArray=" + DieArray // NOI18N
              + ", DWO=" + DWO // NOI18N
              + ", IndexEntry=" + IndexEntry; // NOI18N
  }
}
