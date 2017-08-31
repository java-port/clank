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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.mc.impl.MCSectionELFStatics;


/// This represents a section on linux, lots of unix variants and some bare
/// metal systems.
//<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 30,
 FQN="llvm::MCSectionELF", NM="_ZN4llvm12MCSectionELFE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZN4llvm12MCSectionELFE")
//</editor-fold>
public final class MCSectionELF extends /*public*/ MCSection implements Destructors.ClassWithDestructor {
  /// This is the name of the section.  The referenced memory is owned by
  /// TargetLoweringObjectFileELF's ELFUniqueMap.
  private StringRef SectionName;
  
  /// This is the sh_type field of a section, drawn from the enums below.
  private /*uint*/int Type;
  
  /// This is the sh_flags field of a section, drawn from the enums below.
  private /*uint*/int Flags;
  
  private /*uint*/int UniqueID;
  
  /// The size of each entry in this section. This size only makes sense for
  /// sections that contain fixed-sized entries. If a section does not contain
  /// fixed-sized entries 'EntrySize' will be 0.
  private /*uint*/int EntrySize;
  
  private /*const*/ MCSymbolELF /*P*/ Group;
  
  /// Depending on the type of the section this is sh_link or sh_info.
  private /*const*/ MCSectionELF /*P*/ Associated;
/*private:*/
  /*friend  class MCContext*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::MCSectionELF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 55,
   FQN="llvm::MCSectionELF::MCSectionELF", NM="_ZN4llvm12MCSectionELFC1ENS_9StringRefEjjNS_11SectionKindEjPKNS_11MCSymbolELFEjPNS_8MCSymbolEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZN4llvm12MCSectionELFC1ENS_9StringRefEjjNS_11SectionKindEjPKNS_11MCSymbolELFEjPNS_8MCSymbolEPKS0_")
  //</editor-fold>
  public MCSectionELF(StringRef Section, /*uint*/int type, /*uint*/int flags, SectionKind K, 
      /*uint*/int entrySize, /*const*/ MCSymbolELF /*P*/ group, /*uint*/int UniqueID, 
      MCSymbol /*P*/ Begin, /*const*/ MCSectionELF /*P*/ Associated) {
    // : MCSection(SV_ELF, K, Begin), SectionName(Section), Type(type), Flags(flags), UniqueID(UniqueID), EntrySize(entrySize), Group(group), Associated(Associated) 
    //START JInit
    super(SectionVariant.SV_ELF, new SectionKind(K), Begin);
    this.SectionName = new StringRef(Section);
    this.Type = type;
    this.Flags = flags;
    this.UniqueID = UniqueID;
    this.EntrySize = entrySize;
    this.Group = group;
    this.Associated = Associated;
    //END JInit
    if ((Group != null)) {
      Group.setIsSignature();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::setSectionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 65,
   FQN="llvm::MCSectionELF::setSectionName", NM="_ZN4llvm12MCSectionELF14setSectionNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZN4llvm12MCSectionELF14setSectionNameENS_9StringRefE")
  //</editor-fold>
  public void setSectionName(StringRef Name) {
    SectionName.$assign(Name);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::~MCSectionELF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp", line = 20,
   FQN="llvm::MCSectionELF::~MCSectionELF", NM="_ZN4llvm12MCSectionELFD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZN4llvm12MCSectionELFD0Ev")
  //</editor-fold>
  public void $destroy() {
    super.$destroy();
  }

  
  /// Decides whether a '.section' directive should be printed before the
  /// section name
  // anchor.
  
  // Decides whether a '.section' directive
  // should be printed before the section name.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::ShouldOmitSectionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp", line = 24,
   FQN="llvm::MCSectionELF::ShouldOmitSectionDirective", NM="_ZNK4llvm12MCSectionELF26ShouldOmitSectionDirectiveENS_9StringRefERKNS_9MCAsmInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF26ShouldOmitSectionDirectiveENS_9StringRefERKNS_9MCAsmInfoE")
  //</editor-fold>
  public boolean ShouldOmitSectionDirective(StringRef Name, 
                            final /*const*/ MCAsmInfo /*&*/ MAI) /*const*/ {
    if (isUnique()) {
      return false;
    }
    
    return MAI.shouldOmitSectionDirective(new StringRef(Name));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::getSectionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 74,
   FQN="llvm::MCSectionELF::getSectionName", NM="_ZNK4llvm12MCSectionELF14getSectionNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF14getSectionNameEv")
  //</editor-fold>
  public StringRef getSectionName() /*const*/ {
    return new StringRef(SectionName);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 75,
   FQN="llvm::MCSectionELF::getType", NM="_ZNK4llvm12MCSectionELF7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF7getTypeEv")
  //</editor-fold>
  public /*uint*/int getType() /*const*/ {
    return Type;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::getFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 76,
   FQN="llvm::MCSectionELF::getFlags", NM="_ZNK4llvm12MCSectionELF8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF8getFlagsEv")
  //</editor-fold>
  public /*uint*/int getFlags() /*const*/ {
    return Flags;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::getEntrySize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 77,
   FQN="llvm::MCSectionELF::getEntrySize", NM="_ZNK4llvm12MCSectionELF12getEntrySizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF12getEntrySizeEv")
  //</editor-fold>
  public /*uint*/int getEntrySize() /*const*/ {
    return EntrySize;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::setFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 78,
   FQN="llvm::MCSectionELF::setFlags", NM="_ZN4llvm12MCSectionELF8setFlagsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZN4llvm12MCSectionELF8setFlagsEj")
  //</editor-fold>
  public void setFlags(/*uint*/int F) {
    Flags = F;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::getGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 79,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", old_line = 78,
   FQN="llvm::MCSectionELF::getGroup", NM="_ZNK4llvm12MCSectionELF8getGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF8getGroupEv")
  //</editor-fold>
  public /*const*/ MCSymbolELF /*P*/ getGroup() /*const*/ {
    return Group;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::PrintSwitchToSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp", line = 56,
   FQN="llvm::MCSectionELF::PrintSwitchToSection", NM="_ZNK4llvm12MCSectionELF20PrintSwitchToSectionERKNS_9MCAsmInfoERNS_11raw_ostreamEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF20PrintSwitchToSectionERKNS_9MCAsmInfoERNS_11raw_ostreamEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void PrintSwitchToSection(final /*const*/ MCAsmInfo /*&*/ MAI, 
                      final raw_ostream /*&*/ OS, 
                      /*const*/ MCExpr /*P*/ Subsection) /*const*//* override*/ {
    if (ShouldOmitSectionDirective(new StringRef(SectionName), MAI)) {
      OS.$out_char($$TAB).$out(getSectionName());
      if ((Subsection != null)) {
        OS.$out_char($$TAB);
        Subsection.print(OS, $AddrOf(MAI));
      }
      OS.$out_char($$LF);
      return;
    }
    
    OS.$out(/*KEEP_STR*/"\t.section\t");
    MCSectionELFStatics.printName(OS, getSectionName());
    
    // Handle the weird solaris syntax if desired.
    if (MAI.usesSunStyleELFSectionSwitchSyntax()
       && !((Flags & ELF.SHF_MERGE) != 0)) {
      if (((Flags & ELF.SHF_ALLOC) != 0)) {
        OS.$out(/*KEEP_STR*/",#alloc");
      }
      if (((Flags & ELF.SHF_EXECINSTR) != 0)) {
        OS.$out(/*KEEP_STR*/",#execinstr");
      }
      if (((Flags & ELF.SHF_WRITE) != 0)) {
        OS.$out(/*KEEP_STR*/",#write");
      }
      if (((Flags & ELF.SHF_EXCLUDE) != 0)) {
        OS.$out(/*KEEP_STR*/",#exclude");
      }
      if (((Flags & ELF.SHF_TLS) != 0)) {
        OS.$out(/*KEEP_STR*/",#tls");
      }
      OS.$out_char($$LF);
      return;
    }
    
    OS.$out(/*KEEP_STR*/",\"");
    if (((Flags & ELF.SHF_ALLOC) != 0)) {
      OS.$out_char($$a);
    }
    if (((Flags & ELF.SHF_EXCLUDE) != 0)) {
      OS.$out_char($$e);
    }
    if (((Flags & ELF.SHF_EXECINSTR) != 0)) {
      OS.$out_char($$x);
    }
    if (((Flags & ELF.SHF_GROUP) != 0)) {
      OS.$out_char($$G);
    }
    if (((Flags & ELF.SHF_WRITE) != 0)) {
      OS.$out_char($$w);
    }
    if (((Flags & ELF.SHF_MERGE) != 0)) {
      OS.$out_char($$M);
    }
    if (((Flags & ELF.SHF_STRINGS) != 0)) {
      OS.$out_char($$S);
    }
    if (((Flags & ELF.SHF_TLS) != 0)) {
      OS.$out_char($$T);
    }
    
    // If there are target-specific flags, print them.
    if (((Flags & ELF.XCORE_SHF_CP_SECTION) != 0)) {
      OS.$out_char($$c);
    }
    if (((Flags & ELF.XCORE_SHF_DP_SECTION) != 0)) {
      OS.$out_char($$d);
    }
    
    OS.$out_char($$DBL_QUOTE);
    
    OS.$out_char($$COMMA);
    
    // If comment string is '@', e.g. as on ARM - use '%' instead
    if (MAI.getCommentString().$at(0) == $$AT) {
      OS.$out_char($$PERCENT);
    } else {
      OS.$out_char($$AT);
    }
    if (Type == ELF.SHT_INIT_ARRAY) {
      OS.$out(/*KEEP_STR*/"init_array");
    } else if (Type == ELF.SHT_FINI_ARRAY) {
      OS.$out(/*KEEP_STR*/"fini_array");
    } else if (Type == ELF.SHT_PREINIT_ARRAY) {
      OS.$out(/*KEEP_STR*/"preinit_array");
    } else if (Type == ELF.SHT_NOBITS) {
      OS.$out(/*KEEP_STR*/"nobits");
    } else if (Type == ELF.SHT_NOTE) {
      OS.$out(/*KEEP_STR*/"note");
    } else if (Type == ELF.SHT_PROGBITS) {
      OS.$out(/*KEEP_STR*/"progbits");
    } else if (Type == ELF.SHT_X86_64_UNWIND) {
      OS.$out(/*KEEP_STR*/"unwind");
    }
    if ((EntrySize != 0)) {
      assert Native.$bool(Flags & ELF.SHF_MERGE);
      OS.$out(/*KEEP_STR*/$COMMA).$out_uint(EntrySize);
    }
    if (((Flags & ELF.SHF_GROUP) != 0)) {
      OS.$out(/*KEEP_STR*/$COMMA);
      MCSectionELFStatics.printName(OS, Group.getName());
      OS.$out(/*KEEP_STR*/",comdat");
    }
    if (isUnique()) {
      OS.$out(/*KEEP_STR*/",unique,").$out_uint(UniqueID);
    }
    
    OS.$out_char($$LF);
    if ((Subsection != null)) {
      OS.$out(/*KEEP_STR*/"\t.subsection\t");
      Subsection.print(OS, $AddrOf(MAI));
      OS.$out_char($$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::UseCodeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp", line = 162,
   FQN="llvm::MCSectionELF::UseCodeAlign", NM="_ZNK4llvm12MCSectionELF12UseCodeAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF12UseCodeAlignEv")
  //</editor-fold>
  @Override public boolean UseCodeAlign() /*const*//* override*/ {
    return ((getFlags() & ELF.SHF_EXECINSTR) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::isVirtualSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp", line = 166,
   FQN="llvm::MCSectionELF::isVirtualSection", NM="_ZNK4llvm12MCSectionELF16isVirtualSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF16isVirtualSectionEv")
  //</editor-fold>
  @Override public boolean isVirtualSection() /*const*//* override*/ {
    return getType() == ELF.SHT_NOBITS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::isUnique">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", old_line = 85,
   FQN="llvm::MCSectionELF::isUnique", NM="_ZNK4llvm12MCSectionELF8isUniqueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF8isUniqueEv")
  //</editor-fold>
  public boolean isUnique() /*const*/ {
    return UniqueID != ~0/*U*/;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::getUniqueID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", old_line = 86,
   FQN="llvm::MCSectionELF::getUniqueID", NM="_ZNK4llvm12MCSectionELF11getUniqueIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF11getUniqueIDEv")
  //</editor-fold>
  public /*uint*/int getUniqueID() /*const*/ {
    return UniqueID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::getAssociatedSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", old_line = 88,
   FQN="llvm::MCSectionELF::getAssociatedSection", NM="_ZNK4llvm12MCSectionELF20getAssociatedSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZNK4llvm12MCSectionELF20getAssociatedSectionEv")
  //</editor-fold>
  public /*const*/ MCSectionELF /*P*/ getAssociatedSection() /*const*/ {
    return Associated;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionELF::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionELF.h", old_line = 90,
   FQN="llvm::MCSectionELF::classof", NM="_ZN4llvm12MCSectionELF7classofEPKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionELF.cpp -nm=_ZN4llvm12MCSectionELF7classofEPKNS_9MCSectionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCSection /*P*/ S) {
    return S.getVariant() == SectionVariant.SV_ELF;
  }

  
  @Override public String toString() {
    return "" + "SectionName=" + SectionName // NOI18N
              + ", Type=" + Type // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", UniqueID=" + UniqueID // NOI18N
              + ", EntrySize=" + EntrySize // NOI18N
              + ", Group=" + Group // NOI18N
              + ", Associated=" + Associated // NOI18N
              + super.toString(); // NOI18N
  }
}
