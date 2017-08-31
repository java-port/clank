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

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 21,
 FQN="llvm::DWARFDebugLoc", NM="_ZN4llvm13DWARFDebugLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFDebugLocE")
//</editor-fold>
public class DWARFDebugLoc implements Destructors.ClassWithDestructor {
  /// A single location within a location list.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc::Entry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 23,
   FQN="llvm::DWARFDebugLoc::Entry", NM="_ZN4llvm13DWARFDebugLoc5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFDebugLoc5EntryE")
  //</editor-fold>
  private static class/*struct*/ Entry implements Destructors.ClassWithDestructor {
    /// The beginning address of the instruction range.
    public long/*uint64_t*/ Begin;
    /// The ending address of the instruction range.
    public long/*uint64_t*/ End;
    /// The location of the variable within the specified range.
    public SmallVectorUChar Loc;
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc::Entry::~Entry">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 23,
     FQN="llvm::DWARFDebugLoc::Entry::~Entry", NM="_ZN4llvm13DWARFDebugLoc5EntryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFDebugLoc5EntryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Begin=" + Begin // NOI18N
                + ", End=" + End // NOI18N
                + ", Loc=" + Loc; // NOI18N
    }
  };
  
  /// A list of locations that contain one variable.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc::LocationList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 33,
   FQN="llvm::DWARFDebugLoc::LocationList", NM="_ZN4llvm13DWARFDebugLoc12LocationListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFDebugLoc12LocationListE")
  //</editor-fold>
  private static class/*struct*/ LocationList implements Destructors.ClassWithDestructor {
    /// The beginning offset where this location list is stored in the debug_loc
    /// section.
    public /*uint*/int Offset;
    /// All the locations in which the variable is stored.
    public SmallVector<Entry> Entries;
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc::LocationList::~LocationList">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 33,
     FQN="llvm::DWARFDebugLoc::LocationList::~LocationList", NM="_ZN4llvm13DWARFDebugLoc12LocationListD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFDebugLoc12LocationListD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Offset=" + Offset // NOI18N
                + ", Entries=" + Entries; // NOI18N
    }
  };
  
  // JAVA: typedef SmallVector<LocationList, 4> LocationLists
//  public final class LocationLists extends SmallVector<LocationList>{ };
  
  /// A list of all the variables in the debug_loc section, each one describing
  /// the locations in which the variable is stored.
  private SmallVector<LocationList> Locations;
  
  /// A map used to resolve binary relocations.
  private final /*const*/DenseMapULongType<std.pairUCharLong> /*&*/ RelocMap;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc::DWARFDebugLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 51,
   FQN="llvm::DWARFDebugLoc::DWARFDebugLoc", NM="_ZN4llvm13DWARFDebugLocC1ERKNS_8DenseMapIySt4pairIhxENS_12DenseMapInfoIyEENS_6detail12DenseMapPairIyS3_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFDebugLocC1ERKNS_8DenseMapIySt4pairIhxENS_12DenseMapInfoIyEENS_6detail12DenseMapPairIyS3_EEEE")
  //</editor-fold>
  public DWARFDebugLoc(final /*const*/DenseMapULongType<std.pairUCharLong> /*&*/ LocRelocMap) {
    // : Locations(), RelocMap(LocRelocMap) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Print the location lists found within the debug_loc section.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 53,
   FQN="llvm::DWARFDebugLoc::dump", NM="_ZNK4llvm13DWARFDebugLoc4dumpERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm13DWARFDebugLoc4dumpERNS_11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// Parse the debug_loc section accessible via the 'data' parameter using the
  /// specified address size to interpret the address ranges.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc::parse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 56,
   FQN="llvm::DWARFDebugLoc::parse", NM="_ZN4llvm13DWARFDebugLoc5parseENS_13DataExtractorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFDebugLoc5parseENS_13DataExtractorEj")
  //</editor-fold>
  public void parse(DataExtractor data, /*uint*/int AddressSize) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugLoc::~DWARFDebugLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugLoc.h", line = 21,
   FQN="llvm::DWARFDebugLoc::~DWARFDebugLoc", NM="_ZN4llvm13DWARFDebugLocD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFDebugLocD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Locations=" + Locations // NOI18N
              + ", RelocMap=" + RelocMap; // NOI18N
  }
}
