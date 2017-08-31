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

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFTypeUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFTypeUnit.h", line = 17,
 FQN="llvm::DWARFTypeUnit", NM="_ZN4llvm13DWARFTypeUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFTypeUnitE")
//</editor-fold>
public class DWARFTypeUnit extends /*public*/ DWARFUnit implements Destructors.ClassWithDestructor {
/*private:*/
  private long/*uint64_t*/ TypeHash;
  private /*uint32_t*/int TypeOffset;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFTypeUnit::DWARFTypeUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFTypeUnit.h", line = 22,
   FQN="llvm::DWARFTypeUnit::DWARFTypeUnit", NM="_ZN4llvm13DWARFTypeUnitC1ERNS_12DWARFContextERKNS_12DWARFSectionEPKNS_16DWARFDebugAbbrevENS_9StringRefES9_S9_S9_S9_bbRKNS_20DWARFUnitSectionBaseEPKNS_14DWARFUnitIndex5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFTypeUnitC1ERNS_12DWARFContextERKNS_12DWARFSectionEPKNS_16DWARFDebugAbbrevENS_9StringRefES9_S9_S9_S9_bbRKNS_20DWARFUnitSectionBaseEPKNS_14DWARFUnitIndex5EntryE")
  //</editor-fold>
  public DWARFTypeUnit(final DWARFContext /*&*/ Context, final /*const*/ DWARFSection /*&*/ Section, 
      /*const*/ DWARFDebugAbbrev /*P*/ DA, StringRef RS, StringRef SS, 
      StringRef SOS, StringRef AOS, StringRef LS, boolean LE, boolean IsDWO, 
      final /*const*/ DWARFUnitSectionBase /*&*/ UnitSection, 
      /*const*/ DWARFUnitIndex.Entry /*P*/ Entry) {
    // : DWARFUnit(Context, Section, DA, RS, SS, SOS, AOS, LS, LE, IsDWO, UnitSection, Entry) 
    super(Context, Section, DA, new StringRef(RS), new StringRef(SS), new StringRef(SOS), new StringRef(AOS), new StringRef(LS), LE, IsDWO, 
        UnitSection, Entry);
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFTypeUnit::getHeaderSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFTypeUnit.h", line = 29,
   FQN="llvm::DWARFTypeUnit::getHeaderSize", NM="_ZNK4llvm13DWARFTypeUnit13getHeaderSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm13DWARFTypeUnit13getHeaderSizeEv")
  //</editor-fold>
  @Override public /*uint32_t*/int getHeaderSize() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFTypeUnit::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFTypeUnit.h", line = 32,
   FQN="llvm::DWARFTypeUnit::dump", NM="_ZN4llvm13DWARFTypeUnit4dumpERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFTypeUnit4dumpERNS_11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  public static /*const*/ DWARFSectionKind Section = DWARFSectionKind.DW_SECT_TYPES;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFTypeUnit::extractImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFTypeUnit.h", line = 36,
   FQN="llvm::DWARFTypeUnit::extractImpl", NM="_ZN4llvm13DWARFTypeUnit11extractImplENS_13DataExtractorEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFTypeUnit11extractImplENS_13DataExtractorEPj")
  //</editor-fold>
  @Override protected boolean extractImpl(DataExtractor debug_info, /*uint32_t P*/uint$ptr offset_ptr)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFTypeUnit::~DWARFTypeUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFTypeUnit.h", line = 17,
   FQN="llvm::DWARFTypeUnit::~DWARFTypeUnit", NM="_ZN4llvm13DWARFTypeUnitD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DWARFTypeUnitD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "TypeHash=" + TypeHash // NOI18N
              + ", TypeOffset=" + TypeOffset // NOI18N
              + super.toString(); // NOI18N
  }
}
