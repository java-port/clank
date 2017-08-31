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

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 32,
 FQN="llvm::DWARFUnitIndex", NM="_ZN4llvm14DWARFUnitIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndexE")
//</editor-fold>
public class DWARFUnitIndex implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Header">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 33,
   FQN="llvm::DWARFUnitIndex::Header", NM="_ZN4llvm14DWARFUnitIndex6HeaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex6HeaderE")
  //</editor-fold>
  private static class/*struct*/ Header {
    public /*uint32_t*/int Version;
    public /*uint32_t*/int NumColumns;
    public /*uint32_t*/int NumUnits;
    public /*uint32_t*/int NumBuckets/* = 0*/;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Header::parse">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 39,
     FQN="llvm::DWARFUnitIndex::Header::parse", NM="_ZN4llvm14DWARFUnitIndex6Header5parseENS_13DataExtractorEPj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex6Header5parseENS_13DataExtractorEPj")
    //</editor-fold>
    public boolean parse(DataExtractor IndexData, /*uint32_t P*/uint$ptr OffsetPtr) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Header::dump">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 40,
     FQN="llvm::DWARFUnitIndex::Header::dump", NM="_ZNK4llvm14DWARFUnitIndex6Header4dumpERNS_11raw_ostreamE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex6Header4dumpERNS_11raw_ostreamE")
    //</editor-fold>
    public void dump(final raw_ostream /*&*/ OS) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Header::Header">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 33,
     FQN="llvm::DWARFUnitIndex::Header::Header", NM="_ZN4llvm14DWARFUnitIndex6HeaderC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex6HeaderC1Ev")
    //</editor-fold>
    public /*inline*/ Header() {
      // : NumBuckets(0) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Version=" + Version // NOI18N
                + ", NumColumns=" + NumColumns // NOI18N
                + ", NumUnits=" + NumUnits // NOI18N
                + ", NumBuckets=" + NumBuckets; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Entry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 44,
   FQN="llvm::DWARFUnitIndex::Entry", NM="_ZN4llvm14DWARFUnitIndex5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex5EntryE")
  //</editor-fold>
  public static class Entry implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Entry::SectionContribution">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 46,
     FQN="llvm::DWARFUnitIndex::Entry::SectionContribution", NM="_ZN4llvm14DWARFUnitIndex5Entry19SectionContributionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex5Entry19SectionContributionE")
    //</editor-fold>
    public static class/*struct*/ SectionContribution {
      public /*uint32_t*/int Offset;
      public /*uint32_t*/int Length;
      
      @Override public String toString() {
        return "" + "Offset=" + Offset // NOI18N
                  + ", Length=" + Length; // NOI18N
      }
    };
  /*private:*/
    private /*const*/ DWARFUnitIndex /*P*/ Index;
    private long/*uint64_t*/ Signature;
    private unique_ptr_array<SectionContribution []> Contributions;
    /*friend  class DWARFUnitIndex*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Entry::getOffset">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 58,
     FQN="llvm::DWARFUnitIndex::Entry::getOffset", NM="_ZNK4llvm14DWARFUnitIndex5Entry9getOffsetENS_16DWARFSectionKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex5Entry9getOffsetENS_16DWARFSectionKindE")
    //</editor-fold>
    public /*const*/ SectionContribution /*P*/ getOffset(DWARFSectionKind Sec) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Entry::getOffset">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 59,
     FQN="llvm::DWARFUnitIndex::Entry::getOffset", NM="_ZNK4llvm14DWARFUnitIndex5Entry9getOffsetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex5Entry9getOffsetEv")
    //</editor-fold>
    public /*const*/ SectionContribution /*P*/ getOffset() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Entry::getOffsets">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 60,
     FQN="llvm::DWARFUnitIndex::Entry::getOffsets", NM="_ZNK4llvm14DWARFUnitIndex5Entry10getOffsetsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex5Entry10getOffsetsEv")
    //</editor-fold>
    public /*const*/ SectionContribution /*P*/ getOffsets() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Entry::getSignature">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 63,
     FQN="llvm::DWARFUnitIndex::Entry::getSignature", NM="_ZNK4llvm14DWARFUnitIndex5Entry12getSignatureEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex5Entry12getSignatureEv")
    //</editor-fold>
    public long/*uint64_t*/ getSignature() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::Entry::~Entry">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 44,
     FQN="llvm::DWARFUnitIndex::Entry::~Entry", NM="_ZN4llvm14DWARFUnitIndex5EntryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex5EntryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Index=" + Index // NOI18N
                + ", Signature=" + Signature // NOI18N
                + ", Contributions=" + Contributions; // NOI18N
    }
  };
/*private:*/
  private  Header Header;
  
  private DWARFSectionKind InfoColumnKind;
  private int InfoColumn/* = -1*/;
  private std.unique_ptrT$ArrayT1<DWARFSectionKind, std.default_deleteT$Array<DWARFSectionKind> > ColumnKinds;
  private unique_ptr_array<Entry []> Rows;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::getColumnHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 74,
   FQN="llvm::DWARFUnitIndex::getColumnHeader", NM="_ZN4llvm14DWARFUnitIndex15getColumnHeaderENS_16DWARFSectionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex15getColumnHeaderENS_16DWARFSectionKindE")
  //</editor-fold>
  private static StringRef getColumnHeader(DWARFSectionKind DS) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::parseImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 75,
   FQN="llvm::DWARFUnitIndex::parseImpl", NM="_ZN4llvm14DWARFUnitIndex9parseImplENS_13DataExtractorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex9parseImplENS_13DataExtractorE")
  //</editor-fold>
  private boolean parseImpl(DataExtractor IndexData) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::parse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 78,
   FQN="llvm::DWARFUnitIndex::parse", NM="_ZN4llvm14DWARFUnitIndex5parseENS_13DataExtractorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndex5parseENS_13DataExtractorE")
  //</editor-fold>
  public boolean parse(DataExtractor IndexData) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::DWARFUnitIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 79,
   FQN="llvm::DWARFUnitIndex::DWARFUnitIndex", NM="_ZN4llvm14DWARFUnitIndexC1ENS_16DWARFSectionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndexC1ENS_16DWARFSectionKindE")
  //</editor-fold>
  public DWARFUnitIndex(DWARFSectionKind InfoColumnKind) {
    // : Header(), InfoColumnKind(InfoColumnKind), InfoColumn(-1), ColumnKinds(), Rows() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 81,
   FQN="llvm::DWARFUnitIndex::dump", NM="_ZNK4llvm14DWARFUnitIndex4dumpERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex4dumpERNS_11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::getFromOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 82,
   FQN="llvm::DWARFUnitIndex::getFromOffset", NM="_ZNK4llvm14DWARFUnitIndex13getFromOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex13getFromOffsetEj")
  //</editor-fold>
  public /*const*/ Entry /*P*/ getFromOffset(/*uint32_t*/int Offset) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::getColumnKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 83,
   FQN="llvm::DWARFUnitIndex::getColumnKinds", NM="_ZNK4llvm14DWARFUnitIndex14getColumnKindsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex14getColumnKindsEv")
  //</editor-fold>
  public ArrayRef<DWARFSectionKind> getColumnKinds() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::getRows">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 86,
   FQN="llvm::DWARFUnitIndex::getRows", NM="_ZNK4llvm14DWARFUnitIndex7getRowsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm14DWARFUnitIndex7getRowsEv")
  //</editor-fold>
  public ArrayRef<Entry> getRows() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitIndex::~DWARFUnitIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnitIndex.h", line = 32,
   FQN="llvm::DWARFUnitIndex::~DWARFUnitIndex", NM="_ZN4llvm14DWARFUnitIndexD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm14DWARFUnitIndexD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Header=" + Header // NOI18N
              + ", InfoColumnKind=" + InfoColumnKind // NOI18N
              + ", InfoColumn=" + InfoColumn // NOI18N
              + ", ColumnKinds=" + ColumnKinds // NOI18N
              + ", Rows=" + Rows; // NOI18N
  }
}
