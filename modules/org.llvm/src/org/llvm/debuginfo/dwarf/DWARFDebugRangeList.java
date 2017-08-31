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

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 23,
 FQN="llvm::DWARFDebugRangeList", NM="_ZN4llvm19DWARFDebugRangeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm19DWARFDebugRangeListE")
//</editor-fold>
public class DWARFDebugRangeList implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::RangeListEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 25,
   FQN="llvm::DWARFDebugRangeList::RangeListEntry", NM="_ZN4llvm19DWARFDebugRangeList14RangeListEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm19DWARFDebugRangeList14RangeListEntryE")
  //</editor-fold>
  public static class/*struct*/ RangeListEntry {
    // A beginning address offset. This address offset has the size of an
    // address and is relative to the applicable base address of the
    // compilation unit referencing this range list. It marks the beginning
    // of an address range.
    public long/*uint64_t*/ StartAddress;
    // An ending address offset. This address offset again has the size of
    // an address and is relative to the applicable base address of the
    // compilation unit referencing this range list. It marks the first
    // address past the end of the address range. The ending address must
    // be greater than or equal to the beginning address.
    public long/*uint64_t*/ EndAddress;
    // The end of any given range list is marked by an end of list entry,
    // which consists of a 0 for the beginning address offset
    // and a 0 for the ending address offset.
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::RangeListEntry::isEndOfListEntry">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 40,
     FQN="llvm::DWARFDebugRangeList::RangeListEntry::isEndOfListEntry", NM="_ZNK4llvm19DWARFDebugRangeList14RangeListEntry16isEndOfListEntryEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm19DWARFDebugRangeList14RangeListEntry16isEndOfListEntryEv")
    //</editor-fold>
    public boolean isEndOfListEntry() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    // A base address selection entry consists of:
    // 1. The value of the largest representable address offset
    // (for example, 0xffffffff when the size of an address is 32 bits).
    // 2. An address, which defines the appropriate base address for
    // use in interpreting the beginning and ending address offsets of
    // subsequent entries of the location list.
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::RangeListEntry::isBaseAddressSelectionEntry">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 49,
     FQN="llvm::DWARFDebugRangeList::RangeListEntry::isBaseAddressSelectionEntry", NM="_ZNK4llvm19DWARFDebugRangeList14RangeListEntry27isBaseAddressSelectionEntryEh",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm19DWARFDebugRangeList14RangeListEntry27isBaseAddressSelectionEntryEh")
    //</editor-fold>
    public boolean isBaseAddressSelectionEntry(byte/*uint8_t*/ AddressSize) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "StartAddress=" + StartAddress // NOI18N
                + ", EndAddress=" + EndAddress; // NOI18N
    }
  };
/*private:*/
  // Offset in .debug_ranges section.
  private /*uint32_t*/int Offset;
  private byte/*uint8_t*/ AddressSize;
  private std.vector<RangeListEntry> Entries;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::DWARFDebugRangeList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 65,
   FQN="llvm::DWARFDebugRangeList::DWARFDebugRangeList", NM="_ZN4llvm19DWARFDebugRangeListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm19DWARFDebugRangeListC1Ev")
  //</editor-fold>
  public DWARFDebugRangeList() {
    // : Entries() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 66,
   FQN="llvm::DWARFDebugRangeList::clear", NM="_ZN4llvm19DWARFDebugRangeList5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm19DWARFDebugRangeList5clearEv")
  //</editor-fold>
  public void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 67,
   FQN="llvm::DWARFDebugRangeList::dump", NM="_ZNK4llvm19DWARFDebugRangeList4dumpERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm19DWARFDebugRangeList4dumpERNS_11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::extract">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 68,
   FQN="llvm::DWARFDebugRangeList::extract", NM="_ZN4llvm19DWARFDebugRangeList7extractENS_13DataExtractorEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm19DWARFDebugRangeList7extractENS_13DataExtractorEPj")
  //</editor-fold>
  public boolean extract(DataExtractor data, /*uint32_t P*/uint$ptr offset_ptr) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::getEntries">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 69,
   FQN="llvm::DWARFDebugRangeList::getEntries", NM="_ZN4llvm19DWARFDebugRangeList10getEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm19DWARFDebugRangeList10getEntriesEv")
  //</editor-fold>
  public /*const*/std.vector<RangeListEntry> /*&*/ getEntries() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getAbsoluteRanges - Returns absolute address ranges defined by this range
  /// list. Has to be passed base address of the compile unit referencing this
  /// range list.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::getAbsoluteRanges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 74,
   FQN="llvm::DWARFDebugRangeList::getAbsoluteRanges", NM="_ZNK4llvm19DWARFDebugRangeList17getAbsoluteRangesEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm19DWARFDebugRangeList17getAbsoluteRangesEy")
  //</editor-fold>
  public std.vector<std.pairULongULong> getAbsoluteRanges(long/*uint64_t*/ BaseAddress) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugRangeList::~DWARFDebugRangeList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugRangeList.h", line = 23,
   FQN="llvm::DWARFDebugRangeList::~DWARFDebugRangeList", NM="_ZN4llvm19DWARFDebugRangeListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm19DWARFDebugRangeListD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "Offset=" + Offset // NOI18N
              + ", AddressSize=" + $uchar2uint(AddressSize) // NOI18N
              + ", Entries=" + Entries; // NOI18N
  }
}
