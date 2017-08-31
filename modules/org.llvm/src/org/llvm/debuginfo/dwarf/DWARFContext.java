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


/// DWARFContext
/// This data structure is the top level entity that deals with dwarf debug
/// information parsing. The actual data is supplied through pure virtual
/// methods that a concrete implementation provides.
//<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 39,
 FQN="llvm::DWARFContext", NM="_ZN4llvm12DWARFContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContextE")
//</editor-fold>
public abstract class DWARFContext extends /*public*/ DIContext implements Destructors.ClassWithDestructor {
  
  private DWARFUnitSection<DWARFCompileUnit> CUs;
  private std.deque<DWARFUnitSection<DWARFTypeUnit> > TUs;
  private std.unique_ptr<DWARFUnitIndex> CUIndex;
  private std.unique_ptr<DWARFUnitIndex> TUIndex;
  private std.unique_ptr<DWARFDebugAbbrev> Abbrev;
  private std.unique_ptr<DWARFDebugLoc> Loc;
  private std.unique_ptr<DWARFDebugAranges> Aranges;
  private std.unique_ptr<DWARFDebugLine> Line;
  private std.unique_ptr<DWARFDebugFrame> DebugFrame;
  private std.unique_ptr<DWARFDebugFrame> EHFrame;
  private std.unique_ptr<DWARFDebugMacro> Macro;
  
  private DWARFUnitSection<DWARFCompileUnit> DWOCUs;
  private std.deque<DWARFUnitSection<DWARFTypeUnit> > DWOTUs;
  private std.unique_ptr<DWARFDebugAbbrev> AbbrevDWO;
  private std.unique_ptr<DWARFDebugLocDWO> LocDWO;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::DWARFContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 58,
   FQN="llvm::DWARFContext::DWARFContext", NM="_ZN4llvm12DWARFContextC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContextC1ERS0_")
  //</editor-fold>
  protected/*private*/ DWARFContext(final DWARFContext /*&*/ $Prm0) {  super(null); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 59,
   FQN="llvm::DWARFContext::operator=", NM="_ZN4llvm12DWARFContextaSERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContextaSERS0_")
  //</editor-fold>
  protected/*private*/ DWARFContext /*&*/ $assign(final DWARFContext /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// Read compile units from the debug_info section (if necessary)
  /// and store them in CUs.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::parseCompileUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 63,
   FQN="llvm::DWARFContext::parseCompileUnits", NM="_ZN4llvm12DWARFContext17parseCompileUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17parseCompileUnitsEv")
  //</editor-fold>
  private void parseCompileUnits() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Read type units from the debug_types sections (if necessary)
  /// and store them in TUs.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::parseTypeUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 67,
   FQN="llvm::DWARFContext::parseTypeUnits", NM="_ZN4llvm12DWARFContext14parseTypeUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext14parseTypeUnitsEv")
  //</editor-fold>
  private void parseTypeUnits() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Read compile units from the debug_info.dwo section (if necessary)
  /// and store them in DWOCUs.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::parseDWOCompileUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 71,
   FQN="llvm::DWARFContext::parseDWOCompileUnits", NM="_ZN4llvm12DWARFContext20parseDWOCompileUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext20parseDWOCompileUnitsEv")
  //</editor-fold>
  private void parseDWOCompileUnits() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Read type units from the debug_types.dwo section (if necessary)
  /// and store them in DWOTUs.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::parseDWOTypeUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 75,
   FQN="llvm::DWARFContext::parseDWOTypeUnits", NM="_ZN4llvm12DWARFContext17parseDWOTypeUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17parseDWOTypeUnitsEv")
  //</editor-fold>
  private void parseDWOTypeUnits() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::DWARFContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 78,
   FQN="llvm::DWARFContext::DWARFContext", NM="_ZN4llvm12DWARFContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContextC1Ev")
  //</editor-fold>
  public DWARFContext() {
    // : DIContext(CK_DWARF), CUs(), TUs(), CUIndex(), TUIndex(), Abbrev(), Loc(), Aranges(), Line(), DebugFrame(), EHFrame(), Macro(), DWOCUs(), DWOTUs(), AbbrevDWO(), LocDWO() 
    super(DIContextKind.CK_DWARF);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 80,
   FQN="llvm::DWARFContext::classof", NM="_ZN4llvm12DWARFContext7classofEPKNS_9DIContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext7classofEPKNS_9DIContextE")
  //</editor-fold>
  public static boolean classof(/*const*/ DIContext /*P*/ DICtx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 84,
   FQN="llvm::DWARFContext::dump", NM="_ZN4llvm12DWARFContext4dumpERNS_11raw_ostreamENS_10DIDumpTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext4dumpERNS_11raw_ostreamENS_10DIDumpTypeEb")
  //</editor-fold>
  @Override public void dump(final raw_ostream /*&*/ OS)/* override*/ {
    dump(OS, DIDumpType.DIDT_All, 
      false);
  }
  @Override public void dump(final raw_ostream /*&*/ OS, DIDumpType DumpType/*= DIDT_All*/)/* override*/ {
    dump(OS, DumpType, 
      false);
  }
  @Override public void dump(final raw_ostream /*&*/ OS, DIDumpType DumpType/*= DIDT_All*/, 
      boolean DumpEH/*= false*/)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // JAVA: typedef DWARFUnitSection<DWARFCompileUnit>::iterator_range cu_iterator_range
//  public final class cu_iterator_range extends iterator_range<unique_ptr<DWARFCompileUnit> >{ };
  // JAVA: typedef DWARFUnitSection<DWARFTypeUnit>::iterator_range tu_iterator_range
//  public final class tu_iterator_range extends iterator_range<unique_ptr<DWARFTypeUnit> >{ };
  // JAVA: typedef iterator_range<decltype(TUs)::iterator> tu_section_iterator_range
//  public final class tu_section_iterator_range extends iterator_range<DWARFUnitSection<DWARFTypeUnit> >{ };
  
  /// Get compile units in this context.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::compile_units">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 92,
   FQN="llvm::DWARFContext::compile_units", NM="_ZN4llvm12DWARFContext13compile_unitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext13compile_unitsEv")
  //</editor-fold>
  public iterator_range<unique_ptr<DWARFCompileUnit> > compile_units() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get type units in this context.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::type_unit_sections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 98,
   FQN="llvm::DWARFContext::type_unit_sections", NM="_ZN4llvm12DWARFContext18type_unit_sectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext18type_unit_sectionsEv")
  //</editor-fold>
  public iterator_range<DWARFUnitSection<DWARFTypeUnit> > type_unit_sections() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get compile units in the DWO context.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::dwo_compile_units">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 104,
   FQN="llvm::DWARFContext::dwo_compile_units", NM="_ZN4llvm12DWARFContext17dwo_compile_unitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17dwo_compile_unitsEv")
  //</editor-fold>
  public iterator_range<unique_ptr<DWARFCompileUnit> > dwo_compile_units() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get type units in the DWO context.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::dwo_type_unit_sections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 110,
   FQN="llvm::DWARFContext::dwo_type_unit_sections", NM="_ZN4llvm12DWARFContext22dwo_type_unit_sectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext22dwo_type_unit_sectionsEv")
  //</editor-fold>
  public iterator_range<DWARFUnitSection<DWARFTypeUnit> > dwo_type_unit_sections() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of compile units in this context.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getNumCompileUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 116,
   FQN="llvm::DWARFContext::getNumCompileUnits", NM="_ZN4llvm12DWARFContext18getNumCompileUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext18getNumCompileUnitsEv")
  //</editor-fold>
  public /*uint*/int getNumCompileUnits() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of compile units in this context.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getNumTypeUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 122,
   FQN="llvm::DWARFContext::getNumTypeUnits", NM="_ZN4llvm12DWARFContext15getNumTypeUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext15getNumTypeUnitsEv")
  //</editor-fold>
  public /*uint*/int getNumTypeUnits() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of compile units in the DWO context.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getNumDWOCompileUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 128,
   FQN="llvm::DWARFContext::getNumDWOCompileUnits", NM="_ZN4llvm12DWARFContext21getNumDWOCompileUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext21getNumDWOCompileUnitsEv")
  //</editor-fold>
  public /*uint*/int getNumDWOCompileUnits() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of compile units in the DWO context.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getNumDWOTypeUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 134,
   FQN="llvm::DWARFContext::getNumDWOTypeUnits", NM="_ZN4llvm12DWARFContext18getNumDWOTypeUnitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext18getNumDWOTypeUnitsEv")
  //</editor-fold>
  public /*uint*/int getNumDWOTypeUnits() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the compile unit at the specified index for this compile unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getCompileUnitAtIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 140,
   FQN="llvm::DWARFContext::getCompileUnitAtIndex", NM="_ZN4llvm12DWARFContext21getCompileUnitAtIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext21getCompileUnitAtIndexEj")
  //</editor-fold>
  public DWARFCompileUnit /*P*/ getCompileUnitAtIndex(/*uint*/int index) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the compile unit at the specified index for the DWO compile units.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDWOCompileUnitAtIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 146,
   FQN="llvm::DWARFContext::getDWOCompileUnitAtIndex", NM="_ZN4llvm12DWARFContext24getDWOCompileUnitAtIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext24getDWOCompileUnitAtIndexEj")
  //</editor-fold>
  public DWARFCompileUnit /*P*/ getDWOCompileUnitAtIndex(/*uint*/int index) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getCUIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 151,
   FQN="llvm::DWARFContext::getCUIndex", NM="_ZN4llvm12DWARFContext10getCUIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext10getCUIndexEv")
  //</editor-fold>
  public /*const*/ DWARFUnitIndex /*&*/ getCUIndex() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getTUIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 152,
   FQN="llvm::DWARFContext::getTUIndex", NM="_ZN4llvm12DWARFContext10getTUIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext10getTUIndexEv")
  //</editor-fold>
  public /*const*/ DWARFUnitIndex /*&*/ getTUIndex() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to the parsed DebugAbbrev object.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDebugAbbrev">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 155,
   FQN="llvm::DWARFContext::getDebugAbbrev", NM="_ZN4llvm12DWARFContext14getDebugAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext14getDebugAbbrevEv")
  //</editor-fold>
  public /*const*/ DWARFDebugAbbrev /*P*/ getDebugAbbrev() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to the parsed DebugLoc object.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDebugLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 158,
   FQN="llvm::DWARFContext::getDebugLoc", NM="_ZN4llvm12DWARFContext11getDebugLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext11getDebugLocEv")
  //</editor-fold>
  public /*const*/ DWARFDebugLoc /*P*/ getDebugLoc() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to the parsed dwo abbreviations object.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDebugAbbrevDWO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 161,
   FQN="llvm::DWARFContext::getDebugAbbrevDWO", NM="_ZN4llvm12DWARFContext17getDebugAbbrevDWOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17getDebugAbbrevDWOEv")
  //</editor-fold>
  public /*const*/ DWARFDebugAbbrev /*P*/ getDebugAbbrevDWO() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to the parsed DebugLoc object.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDebugLocDWO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 164,
   FQN="llvm::DWARFContext::getDebugLocDWO", NM="_ZN4llvm12DWARFContext14getDebugLocDWOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext14getDebugLocDWOEv")
  //</editor-fold>
  public /*const*/ DWARFDebugLocDWO /*P*/ getDebugLocDWO() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to the parsed DebugAranges object.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDebugAranges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 167,
   FQN="llvm::DWARFContext::getDebugAranges", NM="_ZN4llvm12DWARFContext15getDebugArangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext15getDebugArangesEv")
  //</editor-fold>
  public /*const*/ DWARFDebugAranges /*P*/ getDebugAranges() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to the parsed frame information object.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDebugFrame">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 170,
   FQN="llvm::DWARFContext::getDebugFrame", NM="_ZN4llvm12DWARFContext13getDebugFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext13getDebugFrameEv")
  //</editor-fold>
  public /*const*/ DWARFDebugFrame /*P*/ getDebugFrame() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to the parsed eh frame information object.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getEHFrame">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 173,
   FQN="llvm::DWARFContext::getEHFrame", NM="_ZN4llvm12DWARFContext10getEHFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext10getEHFrameEv")
  //</editor-fold>
  public /*const*/ DWARFDebugFrame /*P*/ getEHFrame() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to the parsed DebugMacro object.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDebugMacro">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 176,
   FQN="llvm::DWARFContext::getDebugMacro", NM="_ZN4llvm12DWARFContext13getDebugMacroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext13getDebugMacroEv")
  //</editor-fold>
  public /*const*/ DWARFDebugMacro /*P*/ getDebugMacro() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get a pointer to a parsed line table corresponding to a compile unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getLineTableForUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 179,
   FQN="llvm::DWARFContext::getLineTableForUnit", NM="_ZN4llvm12DWARFContext19getLineTableForUnitEPNS_9DWARFUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext19getLineTableForUnitEPNS_9DWARFUnitE")
  //</editor-fold>
  public /*const*/ DWARFDebugLine.LineTable /*P*/ getLineTableForUnit(DWARFUnit /*P*/ cu) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getLineInfoForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 181,
   FQN="llvm::DWARFContext::getLineInfoForAddress", NM="_ZN4llvm12DWARFContext21getLineInfoForAddressEyNS_19DILineInfoSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext21getLineInfoForAddressEyNS_19DILineInfoSpecifierE")
  //</editor-fold>
  @Override public DILineInfo getLineInfoForAddress(long/*uint64_t*/ Address)/* override*/ {
    return getLineInfoForAddress(Address, 
                       new DILineInfoSpecifier());
  }
  @Override public DILineInfo getLineInfoForAddress(long/*uint64_t*/ Address, 
                       DILineInfoSpecifier Specifier/*= DILineInfoSpecifier()*/)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getLineInfoForAddressRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 183,
   FQN="llvm::DWARFContext::getLineInfoForAddressRange", NM="_ZN4llvm12DWARFContext26getLineInfoForAddressRangeEyyNS_19DILineInfoSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext26getLineInfoForAddressRangeEyyNS_19DILineInfoSpecifierE")
  //</editor-fold>
  @Override public SmallVector<std.pairULongType<DILineInfo>> getLineInfoForAddressRange(long/*uint64_t*/ Address, long/*uint64_t*/ Size)/* override*/ {
    return getLineInfoForAddressRange(Address, Size, 
                            new DILineInfoSpecifier());
  }
  @Override public SmallVector<std.pairULongType<DILineInfo>> getLineInfoForAddressRange(long/*uint64_t*/ Address, long/*uint64_t*/ Size, 
                            DILineInfoSpecifier Specifier/*= DILineInfoSpecifier()*/)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getInliningInfoForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 185,
   FQN="llvm::DWARFContext::getInliningInfoForAddress", NM="_ZN4llvm12DWARFContext25getInliningInfoForAddressEyNS_19DILineInfoSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext25getInliningInfoForAddressEyNS_19DILineInfoSpecifierE")
  //</editor-fold>
  @Override public DIInliningInfo getInliningInfoForAddress(long/*uint64_t*/ Address)/* override*/ {
    return getInliningInfoForAddress(Address, 
                           new DILineInfoSpecifier());
  }
  @Override public DIInliningInfo getInliningInfoForAddress(long/*uint64_t*/ Address, 
                           DILineInfoSpecifier Specifier/*= DILineInfoSpecifier()*/)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::isLittleEndian">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 188,
   FQN="llvm::DWARFContext::isLittleEndian", NM="_ZNK4llvm12DWARFContext14isLittleEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm12DWARFContext14isLittleEndianEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isLittleEndian() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getAddressSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 189,
   FQN="llvm::DWARFContext::getAddressSize", NM="_ZNK4llvm12DWARFContext14getAddressSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm12DWARFContext14getAddressSizeEv")
  //</editor-fold>
  public abstract /*virtual*/ byte/*uint8_t*/ getAddressSize() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getInfoSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 190,
   FQN="llvm::DWARFContext::getInfoSection", NM="_ZN4llvm12DWARFContext14getInfoSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext14getInfoSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getInfoSection()/* = 0*/;

  // JAVA: typedef MapVector<object::SectionRef, DWARFSection, std::map<object::SectionRef, unsigned int> > TypeSectionMap
//  public final class TypeSectionMap extends MapVector<SectionRef, DWARFSection, std.mapTypeUInt<SectionRef/*, uint*/> >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getTypesSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 193,
   FQN="llvm::DWARFContext::getTypesSections", NM="_ZN4llvm12DWARFContext16getTypesSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext16getTypesSectionsEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/MapVectorTypeType<SectionRef, DWARFSection> /*&*/ getTypesSections()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getAbbrevSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 194,
   FQN="llvm::DWARFContext::getAbbrevSection", NM="_ZN4llvm12DWARFContext16getAbbrevSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext16getAbbrevSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getAbbrevSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getLocSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 195,
   FQN="llvm::DWARFContext::getLocSection", NM="_ZN4llvm12DWARFContext13getLocSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext13getLocSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getLocSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getARangeSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 196,
   FQN="llvm::DWARFContext::getARangeSection", NM="_ZN4llvm12DWARFContext16getARangeSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext16getARangeSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getARangeSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getDebugFrameSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 197,
   FQN="llvm::DWARFContext::getDebugFrameSection", NM="_ZN4llvm12DWARFContext20getDebugFrameSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext20getDebugFrameSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getDebugFrameSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getEHFrameSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 198,
   FQN="llvm::DWARFContext::getEHFrameSection", NM="_ZN4llvm12DWARFContext17getEHFrameSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17getEHFrameSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getEHFrameSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getLineSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 199,
   FQN="llvm::DWARFContext::getLineSection", NM="_ZN4llvm12DWARFContext14getLineSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext14getLineSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getLineSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getStringSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 200,
   FQN="llvm::DWARFContext::getStringSection", NM="_ZN4llvm12DWARFContext16getStringSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext16getStringSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getStringSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getRangeSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 201,
   FQN="llvm::DWARFContext::getRangeSection", NM="_ZN4llvm12DWARFContext15getRangeSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext15getRangeSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getRangeSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getMacinfoSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 202,
   FQN="llvm::DWARFContext::getMacinfoSection", NM="_ZN4llvm12DWARFContext17getMacinfoSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17getMacinfoSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getMacinfoSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getPubNamesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 203,
   FQN="llvm::DWARFContext::getPubNamesSection", NM="_ZN4llvm12DWARFContext18getPubNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext18getPubNamesSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getPubNamesSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getPubTypesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 204,
   FQN="llvm::DWARFContext::getPubTypesSection", NM="_ZN4llvm12DWARFContext18getPubTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext18getPubTypesSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getPubTypesSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getGnuPubNamesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 205,
   FQN="llvm::DWARFContext::getGnuPubNamesSection", NM="_ZN4llvm12DWARFContext21getGnuPubNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext21getGnuPubNamesSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getGnuPubNamesSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getGnuPubTypesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 206,
   FQN="llvm::DWARFContext::getGnuPubTypesSection", NM="_ZN4llvm12DWARFContext21getGnuPubTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext21getGnuPubTypesSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getGnuPubTypesSection()/* = 0*/;

  
  // Sections for DWARF5 split dwarf proposal.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getInfoDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 209,
   FQN="llvm::DWARFContext::getInfoDWOSection", NM="_ZN4llvm12DWARFContext17getInfoDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17getInfoDWOSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getInfoDWOSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getTypesDWOSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 210,
   FQN="llvm::DWARFContext::getTypesDWOSections", NM="_ZN4llvm12DWARFContext19getTypesDWOSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext19getTypesDWOSectionsEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/MapVectorTypeType<SectionRef, DWARFSection> /*&*/ getTypesDWOSections()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getAbbrevDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 211,
   FQN="llvm::DWARFContext::getAbbrevDWOSection", NM="_ZN4llvm12DWARFContext19getAbbrevDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext19getAbbrevDWOSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getAbbrevDWOSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getLineDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 212,
   FQN="llvm::DWARFContext::getLineDWOSection", NM="_ZN4llvm12DWARFContext17getLineDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17getLineDWOSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getLineDWOSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getLocDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 213,
   FQN="llvm::DWARFContext::getLocDWOSection", NM="_ZN4llvm12DWARFContext16getLocDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext16getLocDWOSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getLocDWOSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getStringDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 214,
   FQN="llvm::DWARFContext::getStringDWOSection", NM="_ZN4llvm12DWARFContext19getStringDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext19getStringDWOSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getStringDWOSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getStringOffsetDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 215,
   FQN="llvm::DWARFContext::getStringOffsetDWOSection", NM="_ZN4llvm12DWARFContext25getStringOffsetDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext25getStringOffsetDWOSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getStringOffsetDWOSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getRangeDWOSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 216,
   FQN="llvm::DWARFContext::getRangeDWOSection", NM="_ZN4llvm12DWARFContext18getRangeDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext18getRangeDWOSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getRangeDWOSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getAddrSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 217,
   FQN="llvm::DWARFContext::getAddrSection", NM="_ZN4llvm12DWARFContext14getAddrSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext14getAddrSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getAddrSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getAppleNamesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 218,
   FQN="llvm::DWARFContext::getAppleNamesSection", NM="_ZN4llvm12DWARFContext20getAppleNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext20getAppleNamesSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getAppleNamesSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getAppleTypesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 219,
   FQN="llvm::DWARFContext::getAppleTypesSection", NM="_ZN4llvm12DWARFContext20getAppleTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext20getAppleTypesSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getAppleTypesSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getAppleNamespacesSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 220,
   FQN="llvm::DWARFContext::getAppleNamespacesSection", NM="_ZN4llvm12DWARFContext25getAppleNamespacesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext25getAppleNamespacesSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getAppleNamespacesSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getAppleObjCSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 221,
   FQN="llvm::DWARFContext::getAppleObjCSection", NM="_ZN4llvm12DWARFContext19getAppleObjCSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext19getAppleObjCSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ DWARFSection /*&*/ getAppleObjCSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getCUIndexSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 222,
   FQN="llvm::DWARFContext::getCUIndexSection", NM="_ZN4llvm12DWARFContext17getCUIndexSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17getCUIndexSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getCUIndexSection()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getTUIndexSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 223,
   FQN="llvm::DWARFContext::getTUIndexSection", NM="_ZN4llvm12DWARFContext17getTUIndexSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext17getTUIndexSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getTUIndexSection()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::isSupportedVersion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 225,
   FQN="llvm::DWARFContext::isSupportedVersion", NM="_ZN4llvm12DWARFContext18isSupportedVersionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext18isSupportedVersionEj")
  //</editor-fold>
  public static boolean isSupportedVersion(/*uint*/int version) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Return the compile unit that includes an offset (relative to .debug_info).
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getCompileUnitForOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 230,
   FQN="llvm::DWARFContext::getCompileUnitForOffset", NM="_ZN4llvm12DWARFContext23getCompileUnitForOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext23getCompileUnitForOffsetEj")
  //</editor-fold>
  private DWARFCompileUnit /*P*/ getCompileUnitForOffset(/*uint32_t*/int Offset) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Return the compile unit which contains instruction with provided
  /// address.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::getCompileUnitForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 234,
   FQN="llvm::DWARFContext::getCompileUnitForAddress", NM="_ZN4llvm12DWARFContext24getCompileUnitForAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContext24getCompileUnitForAddressEy")
  //</editor-fold>
  private DWARFCompileUnit /*P*/ getCompileUnitForAddress(long/*uint64_t*/ Address) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFContext::~DWARFContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFContext.h", line = 39,
   FQN="llvm::DWARFContext::~DWARFContext", NM="_ZN4llvm12DWARFContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm12DWARFContextD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "CUs=" + CUs // NOI18N
              + ", TUs=" + TUs // NOI18N
              + ", CUIndex=" + CUIndex // NOI18N
              + ", TUIndex=" + TUIndex // NOI18N
              + ", Abbrev=" + Abbrev // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Aranges=" + Aranges // NOI18N
              + ", Line=" + Line // NOI18N
              + ", DebugFrame=" + DebugFrame // NOI18N
              + ", EHFrame=" + EHFrame // NOI18N
              + ", Macro=" + Macro // NOI18N
              + ", DWOCUs=" + DWOCUs // NOI18N
              + ", DWOTUs=" + DWOTUs // NOI18N
              + ", AbbrevDWO=" + AbbrevDWO // NOI18N
              + ", LocDWO=" + LocDWO // NOI18N
              + super.toString(); // NOI18N
  }
}
