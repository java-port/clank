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
import org.llvm.support.*;
import org.llvm.adt.*;


// When generating dwarf for assembly source files this is the info that is
// needed to be gathered for each symbol that will have a dwarf label.
//<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 297,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 299,
 FQN="llvm::MCGenDwarfLabelEntry", NM="_ZN4llvm20MCGenDwarfLabelEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm20MCGenDwarfLabelEntryE")
//</editor-fold>
public class MCGenDwarfLabelEntry {
/*private:*/
  // Name of the symbol without a leading underbar, if any.
  private StringRef Name;
  // The dwarf file number this symbol is in.
  private /*uint*/int FileNumber;
  // The line number this symbol is at.
  private /*uint*/int LineNumber;
  // The low_pc for the dwarf label is taken from this symbol.
  private MCSymbol /*P*/ Label;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry::MCGenDwarfLabelEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 311,
   FQN="llvm::MCGenDwarfLabelEntry::MCGenDwarfLabelEntry", NM="_ZN4llvm20MCGenDwarfLabelEntryC1ENS_9StringRefEjjPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm20MCGenDwarfLabelEntryC1ENS_9StringRefEjjPNS_8MCSymbolE")
  //</editor-fold>
  public MCGenDwarfLabelEntry(StringRef name, /*uint*/int fileNumber, /*uint*/int lineNumber, 
      MCSymbol /*P*/ label) {
    // : Name(name), FileNumber(fileNumber), LineNumber(lineNumber), Label(label) 
    //START JInit
    this.Name = new StringRef(name);
    this.FileNumber = fileNumber;
    this.LineNumber = lineNumber;
    this.Label = label;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 314,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 316,
   FQN="llvm::MCGenDwarfLabelEntry::getName", NM="_ZNK4llvm20MCGenDwarfLabelEntry7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm20MCGenDwarfLabelEntry7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry::getFileNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 315,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 317,
   FQN="llvm::MCGenDwarfLabelEntry::getFileNumber", NM="_ZNK4llvm20MCGenDwarfLabelEntry13getFileNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm20MCGenDwarfLabelEntry13getFileNumberEv")
  //</editor-fold>
  public /*uint*/int getFileNumber() /*const*/ {
    return FileNumber;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry::getLineNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 316,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 318,
   FQN="llvm::MCGenDwarfLabelEntry::getLineNumber", NM="_ZNK4llvm20MCGenDwarfLabelEntry13getLineNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm20MCGenDwarfLabelEntry13getLineNumberEv")
  //</editor-fold>
  public /*uint*/int getLineNumber() /*const*/ {
    return LineNumber;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 319,
   FQN="llvm::MCGenDwarfLabelEntry::getLabel", NM="_ZNK4llvm20MCGenDwarfLabelEntry8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm20MCGenDwarfLabelEntry8getLabelEv")
  //</editor-fold>
  public MCSymbol /*P*/ getLabel() /*const*/ {
    return Label;
  }

  
  // This is called when label is created when we are generating dwarf for
  // assembly source files.
  
  //
  // When generating dwarf for assembly source files this is called when symbol
  // for a label is created.  If this symbol is not a temporary and is in the
  // section that dwarf is being generated for, save the needed info to create
  // a dwarf label.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry::Make">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 911,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 908,
   FQN="llvm::MCGenDwarfLabelEntry::Make", NM="_ZN4llvm20MCGenDwarfLabelEntry4MakeEPNS_8MCSymbolEPNS_10MCStreamerERNS_9SourceMgrERNS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm20MCGenDwarfLabelEntry4MakeEPNS_8MCSymbolEPNS_10MCStreamerERNS_9SourceMgrERNS_5SMLocE")
  //</editor-fold>
  public static void Make(MCSymbol /*P*/ Symbol, MCStreamer /*P*/ MCOS, 
      final SourceMgr /*&*/ SrcMgr, final SMLoc /*&*/ Loc) {
    // We won't create dwarf labels for temporary symbols.
    if (Symbol.isTemporary()) {
      return;
    }
    final MCContext /*&*/ context = MCOS.getContext();
    // We won't create dwarf labels for symbols in sections that we are not
    // generating debug info for.
    if (!(context.getGenDwarfSectionSyms().count(MCOS.getCurrentSection().first) != 0)) {
      return;
    }
    
    // The dwarf label's name does not have the symbol name's leading
    // underbar if any.
    StringRef Name = Symbol.getName();
    if (Name.startswith(/*STRINGREF_STR*/"_")) {
      Name.$assignMove(Name.substr(1, Name.size() - 1));
    }
    
    // Get the dwarf file number to be used for the dwarf label.
    /*uint*/int FileNumber = context.getGenDwarfFileNumber();
    
    // Finding the line number is the expensive part which is why we just don't
    // pass it in as for some symbols we won't create a dwarf label.
    /*uint*/int CurBuffer = SrcMgr.FindBufferContainingLoc(new SMLoc(Loc));
    /*uint*/int LineNumber = SrcMgr.FindLineNumber(new SMLoc(Loc), CurBuffer);
    
    // We create a temporary symbol for use for the AT_high_pc and AT_low_pc
    // values so that they don't have things like an ARM thumb bit from the
    // original symbol. So when used they won't get a low bit set after
    // relocation.
    MCSymbol /*P*/ Label = context.createTempSymbol();
    MCOS.EmitLabel(Label);
    
    // Create and entry for the info and add it to the other entries.
    MCOS.getContext().addMCGenDwarfLabelEntry(new MCGenDwarfLabelEntry(new StringRef(Name), FileNumber, LineNumber, Label));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry::MCGenDwarfLabelEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 297,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 299,
   FQN="llvm::MCGenDwarfLabelEntry::MCGenDwarfLabelEntry", NM="_ZN4llvm20MCGenDwarfLabelEntryC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm20MCGenDwarfLabelEntryC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCGenDwarfLabelEntry(final /*const*/ MCGenDwarfLabelEntry /*&*/ $Prm0) {
    // : Name(.Name), FileNumber(.FileNumber), LineNumber(.LineNumber), Label(.Label) 
    //START JInit
    this.Name = new StringRef($Prm0.Name);
    this.FileNumber = $Prm0.FileNumber;
    this.LineNumber = $Prm0.LineNumber;
    this.Label = $Prm0.Label;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCGenDwarfLabelEntry::MCGenDwarfLabelEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 297,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 299,
   FQN="llvm::MCGenDwarfLabelEntry::MCGenDwarfLabelEntry", NM="_ZN4llvm20MCGenDwarfLabelEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm20MCGenDwarfLabelEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCGenDwarfLabelEntry(JD$Move _dparam, final MCGenDwarfLabelEntry /*&&*/$Prm0) {
    // : Name(static_cast<MCGenDwarfLabelEntry &&>().Name), FileNumber(static_cast<MCGenDwarfLabelEntry &&>().FileNumber), LineNumber(static_cast<MCGenDwarfLabelEntry &&>().LineNumber), Label(static_cast<MCGenDwarfLabelEntry &&>().Label) 
    //START JInit
    this.Name = new StringRef(JD$Move.INSTANCE, $Prm0.Name);
    this.FileNumber = $Prm0.FileNumber;
    this.LineNumber = $Prm0.LineNumber;
    this.Label = $Prm0.Label;
    //END JInit
  }

  public MCGenDwarfLabelEntry() {
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", FileNumber=" + FileNumber // NOI18N
              + ", LineNumber=" + LineNumber // NOI18N
              + ", Label=" + Label; // NOI18N
  }
}
