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
import org.clank.support.JavaDifferentiators.*;


/// \brief Instances of this class represent the line information for
/// the dwarf line table entries.  Which is created after a machine
/// instruction is assembled and uses an address from a temporary label
/// created at the current address in the current section and the info from
/// the last .loc directive seen as stored in the context.
//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 136,
 FQN="llvm::MCDwarfLineEntry", NM="_ZN4llvm16MCDwarfLineEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineEntryE")
//</editor-fold>
public class MCDwarfLineEntry extends /*public*/ MCDwarfLoc {
  private MCSymbol /*P*/ Label;
/*private:*/
// Allow the default copy constructor and assignment operator to be used
  // for an MCDwarfLineEntry object.
  /*public:*/
  // Constructor to create an MCDwarfLineEntry given a symbol and the dwarf loc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineEntry::MCDwarfLineEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 145,
   FQN="llvm::MCDwarfLineEntry::MCDwarfLineEntry", NM="_ZN4llvm16MCDwarfLineEntryC1EPNS_8MCSymbolENS_10MCDwarfLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineEntryC1EPNS_8MCSymbolENS_10MCDwarfLocE")
  //</editor-fold>
  public MCDwarfLineEntry(MCSymbol /*P*/ label, /*const*/ MCDwarfLoc loc) {
    // : MCDwarfLoc(loc), Label(label) 
    //START JInit
    super(loc);
    this.Label = label;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineEntry::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 148,
   FQN="llvm::MCDwarfLineEntry::getLabel", NM="_ZNK4llvm16MCDwarfLineEntry8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCDwarfLineEntry8getLabelEv")
  //</editor-fold>
  public MCSymbol /*P*/ getLabel() /*const*/ {
    return Label;
  }

  
  // This is called when an instruction is assembled into the specified
  // section and if there is information from the last .loc directive that
  // has yet to have a line entry made for it is made.
  
  //
  // This is called when an instruction is assembled into the specified section
  // and if there is information from the last .loc directive that has yet to have
  // a line entry made for it is made.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineEntry::Make">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 50,
   FQN="llvm::MCDwarfLineEntry::Make", NM="_ZN4llvm16MCDwarfLineEntry4MakeEPNS_16MCObjectStreamerEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineEntry4MakeEPNS_16MCObjectStreamerEPNS_9MCSectionE")
  //</editor-fold>
  public static void Make(MCObjectStreamer /*P*/ MCOS, MCSection /*P*/ Section) {
    if (!MCOS.getContext().getDwarfLocSeen()) {
      return;
    }
    
    // Create a symbol at in the current section for use in the line entry.
    MCSymbol /*P*/ LineSym = MCOS.getContext().createTempSymbol();
    // Set the value of the symbol to use for the MCDwarfLineEntry.
    MCOS.EmitLabel(LineSym);
    
    // Get the current .loc info saved in the context.
    final /*const*/ MCDwarfLoc /*&*/ DwarfLoc = MCOS.getContext().getCurrentDwarfLoc();
    
    // Create a (local) line entry with the symbol and the current .loc info.
    MCDwarfLineEntry LineEntry/*J*/= new MCDwarfLineEntry(LineSym, new MCDwarfLoc(DwarfLoc));
    
    // clear DwarfLocSeen saying the current .loc info is now used.
    MCOS.getContext().clearDwarfLocSeen();
    
    // Add the line entry to this section's entries.
    MCOS.getContext().
        getMCDwarfLineTable(MCOS.getContext().getDwarfCompileUnitID()).
        getMCLineSections().
        addLineEntry(LineEntry, Section);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineEntry::MCDwarfLineEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 136,
   FQN="llvm::MCDwarfLineEntry::MCDwarfLineEntry", NM="_ZN4llvm16MCDwarfLineEntryC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineEntryC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfLineEntry(final /*const*/ MCDwarfLineEntry /*&*/ $Prm0) {
    // : MCDwarfLoc(), Label(.Label) 
    //START JInit
    super($Prm0);
    this.Label = $Prm0.Label;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineEntry::MCDwarfLineEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 136,
   FQN="llvm::MCDwarfLineEntry::MCDwarfLineEntry", NM="_ZN4llvm16MCDwarfLineEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCDwarfLineEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfLineEntry(JD$Move _dparam, final MCDwarfLineEntry /*&&*/$Prm0) {
    // : MCDwarfLoc(static_cast<MCDwarfLineEntry &&>()), Label(static_cast<MCDwarfLineEntry &&>().Label) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.Label = $Prm0.Label;
    //END JInit
  }

  /*friend*/ MCDwarfLineEntry() {
    super();
    this.Label = null;
  }
  
  @Override
  public MCDwarfLoc clone() {
    assert this.getClass() == MCDwarfLineEntry.class : "Must be overridden in " + this.getClass();
    return new MCDwarfLineEntry(this);
  }

  @Override
  public MCDwarfLoc move() {
    assert this.getClass() == MCDwarfLineEntry.class : "Must be overridden in " + this.getClass();
    return new MCDwarfLineEntry(JD$Move.INSTANCE, this);
  }
  
  @Override public String toString() {
    return "" + "Label=" + Label // NOI18N
              + super.toString(); // NOI18N
  }
}
