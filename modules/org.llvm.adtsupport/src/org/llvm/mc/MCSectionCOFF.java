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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// This represents a section on Windows
//<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", line = 24,
 FQN="llvm::MCSectionCOFF", NM="_ZN4llvm13MCSectionCOFFE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZN4llvm13MCSectionCOFFE")
//</editor-fold>
public final class MCSectionCOFF extends /*public*/ MCSection implements Destructors.ClassWithDestructor {
  // The memory for this string is stored in the same MCContext as *this.
  private StringRef SectionName;
  
  // FIXME: The following fields should not be mutable, but are for now so the
  // asm parser can honor the .linkonce directive.
  
  /// This is the Characteristics field of a section, drawn from the enums
  /// below.
  private /*mutable *//*uint*/int Characteristics;
  
  /// The unique IDs used with the .pdata and .xdata sections created internally
  /// by the assembler. This ID is used to ensure that for every .text section,
  /// there is exactly one .pdata and one .xdata section, which is required by
  /// the Microsoft incremental linker. This data is mutable because this ID is
  /// not notionally part of the section.
  private /*mutable *//*uint*/int WinCFISectionID/* = ~0UU*/;
  
  /// The COMDAT symbol of this section. Only valid if this is a COMDAT section.
  /// Two COMDAT sections are merged if they have the same COMDAT symbol.
  private MCSymbol /*P*/ COMDATSymbol;
  
  /// This is the Selection field for the section symbol, if it is a COMDAT
  /// section (Characteristics & IMAGE_SCN_LNK_COMDAT) != 0
  private /*mutable */int Selection;
/*private:*/
  /*friend  class MCContext*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::MCSectionCOFF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", old_line = 45,
   FQN="llvm::MCSectionCOFF::MCSectionCOFF", NM="_ZN4llvm13MCSectionCOFFC1ENS_9StringRefEjPNS_8MCSymbolEiNS_11SectionKindES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZN4llvm13MCSectionCOFFC1ENS_9StringRefEjPNS_8MCSymbolEiNS_11SectionKindES3_")
  //</editor-fold>
  public MCSectionCOFF(StringRef Section, /*uint*/int Characteristics, 
      MCSymbol /*P*/ COMDATSymbol, int Selection, SectionKind K, 
      MCSymbol /*P*/ Begin) {
    // : MCSection(SV_COFF, K, Begin), SectionName(Section), Characteristics(Characteristics), WinCFISectionID(~0UU), COMDATSymbol(COMDATSymbol), Selection(Selection) 
    //START JInit
    super(SectionVariant.SV_COFF, new SectionKind(K), Begin);
    this.SectionName = new StringRef(Section);
    this.Characteristics = Characteristics;
    /*InClass*/this.WinCFISectionID = ~0/*U*/;
    this.COMDATSymbol = COMDATSymbol;
    this.Selection = Selection;
    //END JInit
    assert ((Characteristics & 0xF00000) == 0) : "alignment must not be set upon section creation";
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::~MCSectionCOFF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp", line = 18,
   FQN="llvm::MCSectionCOFF::~MCSectionCOFF", NM="_ZN4llvm13MCSectionCOFFD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZN4llvm13MCSectionCOFFD0Ev")
  //</editor-fold>
  public void $destroy() {
    super.$destroy();
  }

  
  /// Decides whether a '.section' directive should be printed before the
  /// section name
  // anchor.
  
  // ShouldOmitSectionDirective - Decides whether a '.section' directive
  // should be printed before the section name
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::ShouldOmitSectionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp", line = 22,
   FQN="llvm::MCSectionCOFF::ShouldOmitSectionDirective", NM="_ZNK4llvm13MCSectionCOFF26ShouldOmitSectionDirectiveENS_9StringRefERKNS_9MCAsmInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF26ShouldOmitSectionDirectiveENS_9StringRefERKNS_9MCAsmInfoE")
  //</editor-fold>
  public boolean ShouldOmitSectionDirective(StringRef Name, 
                            final /*const*/ MCAsmInfo /*&*/ MAI) /*const*/ {
    if ((COMDATSymbol != null)) {
      return false;
    }
    
    // FIXME: Does .section .bss/.data/.text work everywhere??
    if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/".text") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/".data") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/".bss")) {
      return true;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::getSectionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", old_line = 62,
   FQN="llvm::MCSectionCOFF::getSectionName", NM="_ZNK4llvm13MCSectionCOFF14getSectionNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF14getSectionNameEv")
  //</editor-fold>
  public StringRef getSectionName() /*const*/ {
    return new StringRef(SectionName);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::getCharacteristics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", line = 70,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", old_line = 63,
   FQN="llvm::MCSectionCOFF::getCharacteristics", NM="_ZNK4llvm13MCSectionCOFF18getCharacteristicsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF18getCharacteristicsEv")
  //</editor-fold>
  public /*uint*/int getCharacteristics() /*const*/ {
    return Characteristics;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::getCOMDATSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", line = 71,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", old_line = 64,
   FQN="llvm::MCSectionCOFF::getCOMDATSymbol", NM="_ZNK4llvm13MCSectionCOFF15getCOMDATSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF15getCOMDATSymbolEv")
  //</editor-fold>
  public MCSymbol /*P*/ getCOMDATSymbol() /*const*/ {
    return COMDATSymbol;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::getSelection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", line = 72,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", old_line = 65,
   FQN="llvm::MCSectionCOFF::getSelection", NM="_ZNK4llvm13MCSectionCOFF12getSelectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF12getSelectionEv")
  //</editor-fold>
  public int getSelection() /*const*/ {
    return Selection;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::setSelection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp", line = 34,
   FQN="llvm::MCSectionCOFF::setSelection", NM="_ZNK4llvm13MCSectionCOFF12setSelectionEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF12setSelectionEi")
  //</editor-fold>
  public void setSelection(int Selection) /*const*/ {
    assert (Selection != 0) : "invalid COMDAT selection type";
    this.Selection = Selection;
    Characteristics |= COFF.SectionCharacteristics.IMAGE_SCN_LNK_COMDAT;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::PrintSwitchToSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp", line = 40,
   FQN="llvm::MCSectionCOFF::PrintSwitchToSection", NM="_ZNK4llvm13MCSectionCOFF20PrintSwitchToSectionERKNS_9MCAsmInfoERNS_11raw_ostreamEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF20PrintSwitchToSectionERKNS_9MCAsmInfoERNS_11raw_ostreamEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void PrintSwitchToSection(final /*const*/ MCAsmInfo /*&*/ MAI, 
                      final raw_ostream /*&*/ OS, 
                      /*const*/ MCExpr /*P*/ Subsection) /*const*//* override*/ {
    
    // standard sections don't require the '.section'
    if (ShouldOmitSectionDirective(new StringRef(SectionName), MAI)) {
      OS.$out_char($$TAB).$out(getSectionName()).$out_char($$LF);
      return;
    }
    
    OS.$out(/*KEEP_STR*/"\t.section\t").$out(getSectionName()).$out(/*KEEP_STR*/",\"");
    if (((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA) != 0)) {
      OS.$out_char($$d);
    }
    if (((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_CNT_UNINITIALIZED_DATA) != 0)) {
      OS.$out_char($$b);
    }
    if (((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_MEM_EXECUTE) != 0)) {
      OS.$out_char($$x);
    }
    if (((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_MEM_WRITE) != 0)) {
      OS.$out_char($$w);
    } else if (((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ) != 0)) {
      OS.$out_char($$r);
    } else {
      OS.$out_char($$y);
    }
    if (((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_LNK_REMOVE) != 0)) {
      OS.$out_char($$n);
    }
    if (((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_MEM_SHARED) != 0)) {
      OS.$out_char($$s);
    }
    OS.$out_char($$DBL_QUOTE);
    if (((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_LNK_COMDAT) != 0)) {
      OS.$out(/*KEEP_STR*/$COMMA);
      switch (COFF.COMDATType.valueOf(Selection)) {
       case IMAGE_COMDAT_SELECT_NODUPLICATES:
        OS.$out(/*KEEP_STR*/"one_only,");
        break;
       case IMAGE_COMDAT_SELECT_ANY:
        OS.$out(/*KEEP_STR*/"discard,");
        break;
       case IMAGE_COMDAT_SELECT_SAME_SIZE:
        OS.$out(/*KEEP_STR*/"same_size,");
        break;
       case IMAGE_COMDAT_SELECT_EXACT_MATCH:
        OS.$out(/*KEEP_STR*/"same_contents,");
        break;
       case IMAGE_COMDAT_SELECT_ASSOCIATIVE:
        OS.$out(/*KEEP_STR*/"associative,");
        break;
       case IMAGE_COMDAT_SELECT_LARGEST:
        OS.$out(/*KEEP_STR*/"largest,");
        break;
       case IMAGE_COMDAT_SELECT_NEWEST:
        OS.$out(/*KEEP_STR*/"newest,");
        break;
       default:
        assert (false) : "unsupported COFF selection type";
        break;
      }
      assert Native.$bool(COMDATSymbol);
      COMDATSymbol.print(OS, $AddrOf(MAI));
    }
    OS.$out_char($$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::UseCodeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp", line = 103,
   FQN="llvm::MCSectionCOFF::UseCodeAlign", NM="_ZNK4llvm13MCSectionCOFF12UseCodeAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF12UseCodeAlignEv")
  //</editor-fold>
  @Override public boolean UseCodeAlign() /*const*//* override*/ {
    return getKind().isText();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::isVirtualSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp", line = 107,
   FQN="llvm::MCSectionCOFF::isVirtualSection", NM="_ZNK4llvm13MCSectionCOFF16isVirtualSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF16isVirtualSectionEv")
  //</editor-fold>
  @Override public boolean isVirtualSection() /*const*//* override*/ {
    return ((getCharacteristics() & COFF.SectionCharacteristics.IMAGE_SCN_CNT_UNINITIALIZED_DATA) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::getOrAssignWinCFISectionID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", line = 81,
   FQN="llvm::MCSectionCOFF::getOrAssignWinCFISectionID", NM="_ZNK4llvm13MCSectionCOFF26getOrAssignWinCFISectionIDEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZNK4llvm13MCSectionCOFF26getOrAssignWinCFISectionIDEPj")
  //</editor-fold>
  public /*uint*/int getOrAssignWinCFISectionID(uint$ptr/*uint P*/ NextID) /*const*/ {
    if (WinCFISectionID == ~0/*U*/) {
      WinCFISectionID = NextID.$set$postInc(0);
    }
    return WinCFISectionID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionCOFF::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionCOFF.h", old_line = 74,
   FQN="llvm::MCSectionCOFF::classof", NM="_ZN4llvm13MCSectionCOFF7classofEPKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionCOFF.cpp -nm=_ZN4llvm13MCSectionCOFF7classofEPKNS_9MCSectionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCSection /*P*/ S) {
    return S.getVariant() == SectionVariant.SV_COFF;
  }

  
  @Override public String toString() {
    return "" + "SectionName=" + SectionName // NOI18N
              + ", Characteristics=" + Characteristics // NOI18N
              + ", WinCFISectionID=" + WinCFISectionID // NOI18N
              + ", COMDATSymbol=" + COMDATSymbol // NOI18N
              + ", Selection=" + Selection // NOI18N
              + super.toString(); // NOI18N
  }
}
