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

import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.mc.impl.MCDwarfStatics;

//<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 286,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 288,
 FQN="llvm::MCGenDwarfInfo", NM="_ZN4llvm14MCGenDwarfInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm14MCGenDwarfInfoE")
//</editor-fold>
public class MCGenDwarfInfo {
/*public:*/
  //
  // When generating dwarf for assembly source files this emits the Dwarf
  // sections.
  //
  
  //
  // When generating dwarf for assembly source files this emits the Dwarf
  // sections.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfInfo::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 840,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 837,
   FQN="llvm::MCGenDwarfInfo::Emit", NM="_ZN4llvm14MCGenDwarfInfo4EmitEPNS_10MCStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm14MCGenDwarfInfo4EmitEPNS_10MCStreamerE")
  //</editor-fold>
  public static void Emit(MCStreamer /*P*/ MCOS) {
    final MCContext /*&*/ context = MCOS.getContext();
    
    // Create the dwarf sections in this order (.debug_line already created).
    /*const*/ MCAsmInfo /*P*/ AsmInfo = context.getAsmInfo();
    boolean CreateDwarfSectionSymbols = AsmInfo.doesDwarfUseRelocationsAcrossSections();
    MCSymbol /*P*/ LineSectionSymbol = null;
    if (CreateDwarfSectionSymbols) {
      LineSectionSymbol = MCOS.getDwarfLineTableSymbol(0);
    }
    MCSymbol /*P*/ AbbrevSectionSymbol = null;
    MCSymbol /*P*/ InfoSectionSymbol = null;
    MCSymbol /*P*/ RangesSectionSymbol = null;
    
    // Create end symbols for each section, and remove empty sections
    MCOS.getContext().finalizeDwarfSections($Deref(MCOS));
    
    // If there are no sections to generate debug info for, we don't need
    // to do anything
    if (MCOS.getContext().getGenDwarfSectionSyms().empty()) {
      return;
    }
    
    // We only use the .debug_ranges section if we have multiple code sections,
    // and we are emitting a DWARF version which supports it.
    /*const*/boolean UseRangesSection = $greater_uint(MCOS.getContext().getGenDwarfSectionSyms().size(), 1)
       && $ushort2int(MCOS.getContext().getDwarfVersion()) >= 3;
    CreateDwarfSectionSymbols |= UseRangesSection;
    
    MCOS.SwitchSection(context.getObjectFileInfo().getDwarfInfoSection());
    if (CreateDwarfSectionSymbols) {
      InfoSectionSymbol = context.createTempSymbol();
      MCOS.EmitLabel(InfoSectionSymbol);
    }
    MCOS.SwitchSection(context.getObjectFileInfo().getDwarfAbbrevSection());
    if (CreateDwarfSectionSymbols) {
      AbbrevSectionSymbol = context.createTempSymbol();
      MCOS.EmitLabel(AbbrevSectionSymbol);
    }
    if (UseRangesSection) {
      MCOS.SwitchSection(context.getObjectFileInfo().getDwarfRangesSection());
      if (CreateDwarfSectionSymbols) {
        RangesSectionSymbol = context.createTempSymbol();
        MCOS.EmitLabel(RangesSectionSymbol);
      }
    }
    assert ((RangesSectionSymbol != null) || !UseRangesSection);
    
    MCOS.SwitchSection(context.getObjectFileInfo().getDwarfARangesSection());
    
    // Output the data for .debug_aranges section.
    MCDwarfStatics.EmitGenDwarfAranges(MCOS, InfoSectionSymbol);
    if (UseRangesSection) {
      MCDwarfStatics.EmitGenDwarfRanges(MCOS);
    }
    
    // Output the data for .debug_abbrev section.
    MCDwarfStatics.EmitGenDwarfAbbrev(MCOS);
    
    // Output the data for .debug_info section.
    MCDwarfStatics.EmitGenDwarfInfo(MCOS, AbbrevSectionSymbol, LineSectionSymbol, 
        RangesSectionSymbol);
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
