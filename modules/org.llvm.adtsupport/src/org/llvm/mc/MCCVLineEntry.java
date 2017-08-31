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
/// the CodeView line table entries.  Which is created after a machine
/// instruction is assembled and uses an address from a temporary label
/// created at the current address in the current section and the info from
/// the last .cv_loc directive seen as stored in the context.
//<editor-fold defaultstate="collapsed" desc="llvm::MCCVLineEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 87,
 FQN="llvm::MCCVLineEntry", NM="_ZN4llvm13MCCVLineEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm13MCCVLineEntryE")
//</editor-fold>
public class MCCVLineEntry extends /*public*/ MCCVLoc {
  private /*const*/ MCSymbol /*P*/ Label;
/*private:*/
// Allow the default copy constructor and assignment operator to be used
  // for an MCCVLineEntry object.
  /*public:*/
  // Constructor to create an MCCVLineEntry given a symbol and the dwarf loc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLineEntry::MCCVLineEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 96,
   FQN="llvm::MCCVLineEntry::MCCVLineEntry", NM="_ZN4llvm13MCCVLineEntryC1EPKNS_8MCSymbolENS_7MCCVLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm13MCCVLineEntryC1EPKNS_8MCSymbolENS_7MCCVLocE")
  //</editor-fold>
  public MCCVLineEntry(/*const*/ MCSymbol /*P*/ Label, /*const*/ MCCVLoc loc) {
    // : MCCVLoc(loc), Label(Label) 
    //START JInit
    super(loc);
    this.Label = Label;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLineEntry::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 99,
   FQN="llvm::MCCVLineEntry::getLabel", NM="_ZNK4llvm13MCCVLineEntry8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm13MCCVLineEntry8getLabelEv")
  //</editor-fold>
  public /*const*/ MCSymbol /*P*/ getLabel() /*const*/ {
    return Label;
  }

  
  // This is called when an instruction is assembled into the specified
  // section and if there is information from the last .cv_loc directive that
  // has yet to have a line entry made for it is made.
  
  //
  // This is called when an instruction is assembled into the specified section
  // and if there is information from the last .cv_loc directive that has yet to have
  // a line entry made for it is made.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLineEntry::Make">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 444,
   FQN="llvm::MCCVLineEntry::Make", NM="_ZN4llvm13MCCVLineEntry4MakeEPNS_16MCObjectStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm13MCCVLineEntry4MakeEPNS_16MCObjectStreamerE")
  //</editor-fold>
  public static void Make(MCObjectStreamer /*P*/ MCOS) {
    if (!MCOS.getContext().getCVLocSeen()) {
      return;
    }
    
    // Create a symbol at in the current section for use in the line entry.
    MCSymbol /*P*/ LineSym = MCOS.getContext().createTempSymbol();
    // Set the value of the symbol to use for the MCCVLineEntry.
    MCOS.EmitLabel(LineSym);
    
    // Get the current .loc info saved in the context.
    final /*const*/ MCCVLoc /*&*/ CVLoc = MCOS.getContext().getCurrentCVLoc();
    
    // Create a (local) line entry with the symbol and the current .loc info.
    MCCVLineEntry LineEntry/*J*/= new MCCVLineEntry(LineSym, new MCCVLoc(CVLoc));
    
    // clear CVLocSeen saying the current .loc info is now used.
    MCOS.getContext().clearCVLocSeen();
    
    // Add the line entry to this section's entries.
    MCOS.getContext().getCVContext().addLineEntry(LineEntry);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLineEntry::MCCVLineEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 87,
   FQN="llvm::MCCVLineEntry::MCCVLineEntry", NM="_ZN4llvm13MCCVLineEntryC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm13MCCVLineEntryC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCCVLineEntry(final /*const*/ MCCVLineEntry /*&*/ $Prm0) {
    // : MCCVLoc(), Label(.Label) 
    //START JInit
    super($Prm0);
    this.Label = $Prm0.Label;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLineEntry::MCCVLineEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 87,
   FQN="llvm::MCCVLineEntry::MCCVLineEntry", NM="_ZN4llvm13MCCVLineEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm13MCCVLineEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCCVLineEntry(JD$Move _dparam, final MCCVLineEntry /*&&*/$Prm0) {
    // : MCCVLoc(static_cast<MCCVLineEntry &&>()), Label(static_cast<MCCVLineEntry &&>().Label) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.Label = $Prm0.Label;
    //END JInit
  }

  public MCCVLineEntry() {
    super(null);
  }

  @Override public String toString() {
    return "" + "Label=" + Label // NOI18N
              + super.toString(); // NOI18N
  }
}
