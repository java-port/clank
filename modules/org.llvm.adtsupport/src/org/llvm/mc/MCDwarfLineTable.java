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

package org.llvm.mc;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.mc.impl.MCDwarfStatics;

//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 225,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 227,
 FQN="llvm::MCDwarfLineTable", NM="_ZN4llvm16MCDwarfLineTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTableE")
//</editor-fold>
public class MCDwarfLineTable implements Destructors.ClassWithDestructor {
  private MCDwarfLineTableHeader Header;
  private MCLineSection MCLineSections;
/*public:*/
  // This emits the Dwarf file and the line tables for all Compile Units.
  
  // This emits the Dwarf file and the line tables for all Compile Units.

  // This emits the Dwarf file and the line tables for all Compile Units.

  //
  // This emits the Dwarf file and the line tables.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 182,
   FQN="llvm::MCDwarfLineTable::Emit", NM="_ZN4llvm16MCDwarfLineTable4EmitEPNS_16MCObjectStreamerENS_22MCDwarfLineTableParamsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTable4EmitEPNS_16MCObjectStreamerENS_22MCDwarfLineTableParamsE")
  //</editor-fold>
  public static void Emit(MCObjectStreamer /*P*/ MCOS, 
      MCDwarfLineTableParams Params) {
    final MCContext /*&*/ context = MCOS.getContext();
    
    final /*constconst*/std.mapUIntType<MCDwarfLineTable> /*&*/ LineTables = context.getMCDwarfLineTables();
    
    // Bail out early so we don't switch to the debug_line section needlessly and
    // in doing so create an unnecessary (if empty) section.
    if (LineTables.empty()) {
      return;
    }
    
    // Switch to the section where the table will be emitted into.
    MCOS.SwitchSection(context.getObjectFileInfo().getDwarfLineSection());
    
    // Handle the rest of the Compile Units.
    for (final /*const*/std.pairUIntType<MCDwarfLineTable> /*&*/ CUIDTablePair : LineTables)  {
      CUIDTablePair.second.EmitCU(MCOS, new MCDwarfLineTableParams(Params));
    }
  }

  
  // This emits the Dwarf file and the line tables for a given Compile Unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::EmitCU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 318,
   FQN="llvm::MCDwarfLineTable::EmitCU", NM="_ZNK4llvm16MCDwarfLineTable6EmitCUEPNS_16MCObjectStreamerENS_22MCDwarfLineTableParamsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCDwarfLineTable6EmitCUEPNS_16MCObjectStreamerENS_22MCDwarfLineTableParamsE")
  //</editor-fold>
  public void EmitCU(MCObjectStreamer /*P*/ MCOS, 
        MCDwarfLineTableParams Params) /*const*/ {
    MCSymbol /*P*/ LineEndSym = Header.Emit(MCOS, new MCDwarfLineTableParams(Params)).second;
    
    // Put out the line tables.
    for (final /*const*/std.pair<MCSection /*P*/ , std.vector<MCDwarfLineEntry/*,default_cls_allocator*/>> /*&*/ LineSec : MCLineSections.getMCLineEntries())  {
      MCDwarfStatics.EmitDwarfLineTable(MCOS, LineSec.first, LineSec.second);
    }
    
    // This is the end of the section, so set the value of the symbol at the end
    // of this section (that was used in a previous expression).
    MCOS.EmitLabel(LineEndSym);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 331,
   FQN="llvm::MCDwarfLineTable::getFile", NM="_ZN4llvm16MCDwarfLineTable7getFileERNS_9StringRefES2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTable7getFileERNS_9StringRefES2_j")
  //</editor-fold>
  public /*uint*/int getFile(final StringRef /*&*/ Directory, final StringRef /*&*/ FileName) {
    return getFile(Directory, FileName, 
         0);
  }
  public /*uint*/int getFile(final StringRef /*&*/ Directory, final StringRef /*&*/ FileName, 
         /*uint*/int FileNumber/*= 0*/) {
    return Header.getFile(Directory, FileName, FileNumber);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 239,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 241,
   FQN="llvm::MCDwarfLineTable::getLabel", NM="_ZNK4llvm16MCDwarfLineTable8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCDwarfLineTable8getLabelEv")
  //</editor-fold>
  public MCSymbol /*P*/ getLabel() /*const*/ {
    return Header.Label;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::setLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 243,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 245,
   FQN="llvm::MCDwarfLineTable::setLabel", NM="_ZN4llvm16MCDwarfLineTable8setLabelEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTable8setLabelEPNS_8MCSymbolE")
  //</editor-fold>
  public void setLabel(MCSymbol /*P*/ Label) {
    Header.Label = Label;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::setCompilationDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 249,
   FQN="llvm::MCDwarfLineTable::setCompilationDir", NM="_ZN4llvm16MCDwarfLineTable17setCompilationDirENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTable17setCompilationDirENS_9StringRefE")
  //</editor-fold>
  public void setCompilationDir(StringRef CompilationDir) {
    Header.CompilationDir.$assign(CompilationDir);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::getMCDwarfDirs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 253,
   FQN="llvm::MCDwarfLineTable::getMCDwarfDirs", NM="_ZNK4llvm16MCDwarfLineTable14getMCDwarfDirsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCDwarfLineTable14getMCDwarfDirsEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<std.string> /*&*/ getMCDwarfDirs$Const() /*const*/ {
    return Header.MCDwarfDirs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::getMCDwarfDirs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 255,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 257,
   FQN="llvm::MCDwarfLineTable::getMCDwarfDirs", NM="_ZN4llvm16MCDwarfLineTable14getMCDwarfDirsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTable14getMCDwarfDirsEv")
  //</editor-fold>
  public SmallVectorImpl<std.string> /*&*/ getMCDwarfDirs() {
    return Header.MCDwarfDirs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::getMCDwarfFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 259,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 261,
   FQN="llvm::MCDwarfLineTable::getMCDwarfFiles", NM="_ZNK4llvm16MCDwarfLineTable15getMCDwarfFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCDwarfLineTable15getMCDwarfFilesEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<MCDwarfFile> /*&*/ getMCDwarfFiles$Const() /*const*/ {
    return Header.MCDwarfFiles;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::getMCDwarfFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 263,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 265,
   FQN="llvm::MCDwarfLineTable::getMCDwarfFiles", NM="_ZN4llvm16MCDwarfLineTable15getMCDwarfFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTable15getMCDwarfFilesEv")
  //</editor-fold>
  public SmallVectorImpl<MCDwarfFile> /*&*/ getMCDwarfFiles() {
    return Header.MCDwarfFiles;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::getMCLineSections">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 269,
   FQN="llvm::MCDwarfLineTable::getMCLineSections", NM="_ZNK4llvm16MCDwarfLineTable17getMCLineSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCDwarfLineTable17getMCLineSectionsEv")
  //</editor-fold>
  public /*const*/ MCLineSection /*&*/ getMCLineSections$Const() /*const*/ {
    return MCLineSections;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::getMCLineSections">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 270,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 272,
   FQN="llvm::MCDwarfLineTable::getMCLineSections", NM="_ZN4llvm16MCDwarfLineTable17getMCLineSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTable17getMCLineSectionsEv")
  //</editor-fold>
  public MCLineSection /*&*/ getMCLineSections() {
    return MCLineSections;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::~MCDwarfLineTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 227,
   FQN="llvm::MCDwarfLineTable::~MCDwarfLineTable", NM="_ZN4llvm16MCDwarfLineTableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTableD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    MCLineSections.$destroy();
    Header.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTable::MCDwarfLineTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 227,
   FQN="llvm::MCDwarfLineTable::MCDwarfLineTable", NM="_ZN4llvm16MCDwarfLineTableC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineTableC1Ev")
  //</editor-fold>
  public /*inline*/ MCDwarfLineTable() {
    // : Header(), MCLineSections() 
    //START JInit
    this.Header = new MCDwarfLineTableHeader();
    this.MCLineSections = new MCLineSection();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Header=" + Header // NOI18N
              + ", MCLineSections=" + MCLineSections; // NOI18N
  }
}
