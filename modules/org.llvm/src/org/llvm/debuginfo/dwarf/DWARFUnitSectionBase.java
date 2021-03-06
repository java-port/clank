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


/// Base class for all DWARFUnitSection classes. This provides the
/// functionality common to all unit types.
//<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitSectionBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 36,
 FQN="llvm::DWARFUnitSectionBase", NM="_ZN4llvm20DWARFUnitSectionBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFUnitSectionBaseE")
//</editor-fold>
public abstract interface/*class*/ DWARFUnitSectionBase extends Destructors.ClassWithDestructor {
/*public:*/
  /// Returns the Unit that contains the given section offset in the
  /// same section this Unit originated from.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitSectionBase::getUnitForOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 40,
   FQN="llvm::DWARFUnitSectionBase::getUnitForOffset", NM="_ZNK4llvm20DWARFUnitSectionBase16getUnitForOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm20DWARFUnitSectionBase16getUnitForOffsetEj")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ DWARFUnit /*P*/ getUnitForOffset(/*uint32_t*/int Offset) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitSectionBase::parse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 42,
   FQN="llvm::DWARFUnitSectionBase::parse", NM="_ZN4llvm20DWARFUnitSectionBase5parseERNS_12DWARFContextERKNS_12DWARFSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFUnitSectionBase5parseERNS_12DWARFContextERKNS_12DWARFSectionE")
  //</editor-fold>
  public default/*interface*/ void parse(final DWARFContext /*&*/ C, final /*const*/ DWARFSection /*&*/ Section) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitSectionBase::parseDWO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 43,
   FQN="llvm::DWARFUnitSectionBase::parseDWO", NM="_ZN4llvm20DWARFUnitSectionBase8parseDWOERNS_12DWARFContextERKNS_12DWARFSectionEPNS_14DWARFUnitIndexE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFUnitSectionBase8parseDWOERNS_12DWARFContextERKNS_12DWARFSectionEPNS_14DWARFUnitIndexE")
  //</editor-fold>
  public default/*interface*/ void parseDWO(final DWARFContext /*&*/ C, final /*const*/ DWARFSection /*&*/ DWOSection) {
    parseDWO(C, DWOSection, 
          (DWARFUnitIndex /*P*/ )null);
  }
  public default/*interface*/ void parseDWO(final DWARFContext /*&*/ C, final /*const*/ DWARFSection /*&*/ DWOSection, 
          DWARFUnitIndex /*P*/ Index/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitSectionBase::parseImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 47,
   FQN="llvm::DWARFUnitSectionBase::parseImpl", NM="_ZN4llvm20DWARFUnitSectionBase9parseImplERNS_12DWARFContextERKNS_12DWARFSectionEPKNS_16DWARFDebugAbbrevENS_9StringRefES9_S9_S9_S9_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFUnitSectionBase9parseImplERNS_12DWARFContextERKNS_12DWARFSectionEPKNS_16DWARFDebugAbbrevENS_9StringRefES9_S9_S9_S9_bb")
  //</editor-fold>
  public /*protected*/ /*interface*/ abstract /*virtual*/ void parseImpl(final DWARFContext /*&*/ Context, final /*const*/ DWARFSection /*&*/ Section, 
           /*const*/ DWARFDebugAbbrev /*P*/ DA, StringRef RS, StringRef SS, 
           StringRef SOS, StringRef AOS, StringRef LS, 
           boolean isLittleEndian, boolean isDWO)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitSectionBase::~DWARFUnitSectionBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 52,
   FQN="llvm::DWARFUnitSectionBase::~DWARFUnitSectionBase", NM="_ZN4llvm20DWARFUnitSectionBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFUnitSectionBaseD0Ev")
  //</editor-fold>
  public/*protected*/ default/*interface*/ void $destroy$DWARFUnitSectionBase()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFUnitSectionBase::DWARFUnitSectionBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFUnit.h", line = 36,
   FQN="llvm::DWARFUnitSectionBase::DWARFUnitSectionBase", NM="_ZN4llvm20DWARFUnitSectionBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm20DWARFUnitSectionBaseC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $DWARFUnitSectionBase() {
    throw new UnsupportedOperationException("EmptyBody");
  }

}
