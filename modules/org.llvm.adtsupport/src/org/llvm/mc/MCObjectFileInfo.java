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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.mc.impl.MCObjectFileInfoStatics;
import org.llvm.support.dwarf.Constants;

//<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 24,
 FQN="llvm::MCObjectFileInfo", NM="_ZN4llvm16MCObjectFileInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZN4llvm16MCObjectFileInfoE")
//</editor-fold>
public class MCObjectFileInfo implements Destructors.ClassWithDestructor {
/*protected:*/
  /// True if .comm supports alignment.  This is a hack for as long as we
  /// support 10.4 Tiger, whose assembler doesn't support alignment on comm.
  protected boolean CommDirectiveSupportsAlignment;
  
  /// True if target object file supports a weak_definition of constant 0 for an
  /// omitted EH frame.
  protected boolean SupportsWeakOmittedEHFrame;
  
  /// True if the target object file supports emitting a compact unwind section
  /// without an associated EH frame section.
  protected boolean SupportsCompactUnwindWithoutEHFrame;
  
  /// OmitDwarfIfHaveCompactUnwind - True if the target object file
  /// supports having some functions with compact unwind and other with
  /// dwarf unwind.
  protected boolean OmitDwarfIfHaveCompactUnwind;
  
  /// PersonalityEncoding, LSDAEncoding, TTypeEncoding - Some encoding values
  /// for EH.
  protected /*uint*/int PersonalityEncoding;
  protected /*uint*/int LSDAEncoding;
  protected /*uint*/int FDECFIEncoding;
  protected /*uint*/int TTypeEncoding;
  
  /// Compact unwind encoding indicating that we should emit only an EH frame.
  protected /*uint*/int CompactUnwindDwarfEHFrameOnly;
  
  /// Section directive for standard text.
  protected MCSection /*P*/ TextSection;
  
  /// Section directive for standard data.
  protected MCSection /*P*/ DataSection;
  
  /// Section that is default initialized to zero.
  protected MCSection /*P*/ BSSSection;
  
  /// Section that is readonly and can contain arbitrary initialized data.
  /// Targets are not required to have a readonly section. If they don't,
  /// various bits of code will fall back to using the data section for
  /// constants.
  protected MCSection /*P*/ ReadOnlySection;
  
  /// This section contains the static constructor pointer list.
  protected MCSection /*P*/ StaticCtorSection;
  
  /// This section contains the static destructor pointer list.
  protected MCSection /*P*/ StaticDtorSection;
  
  /// If exception handling is supported by the target, this is the section the
  /// Language Specific Data Area information is emitted to.
  protected MCSection /*P*/ LSDASection;
  
  /// If exception handling is supported by the target and the target can
  /// support a compact representation of the CIE and FDE, this is the section
  /// to emit them into.
  protected MCSection /*P*/ CompactUnwindSection;
  
  // Dwarf sections for debug info.  If a target supports debug info, these must
  // be set.
  protected MCSection /*P*/ DwarfAbbrevSection;
  protected MCSection /*P*/ DwarfInfoSection;
  protected MCSection /*P*/ DwarfLineSection;
  protected MCSection /*P*/ DwarfFrameSection;
  protected MCSection /*P*/ DwarfPubTypesSection;
  protected /*const*/ MCSection /*P*/ DwarfDebugInlineSection;
  protected MCSection /*P*/ DwarfStrSection;
  protected MCSection /*P*/ DwarfLocSection;
  protected MCSection /*P*/ DwarfARangesSection;
  protected MCSection /*P*/ DwarfRangesSection;
  protected MCSection /*P*/ DwarfMacinfoSection;
  // The pubnames section is no longer generated by default.  The generation
  // can be enabled by a compiler flag.
  protected MCSection /*P*/ DwarfPubNamesSection;
  
  /// DWARF5 Experimental Debug Info Sections
  /// DwarfAccelNamesSection, DwarfAccelObjCSection,
  /// DwarfAccelNamespaceSection, DwarfAccelTypesSection -
  /// If we use the DWARF accelerated hash tables then we want to emit these
  /// sections.
  protected MCSection /*P*/ DwarfAccelNamesSection;
  protected MCSection /*P*/ DwarfAccelObjCSection;
  protected MCSection /*P*/ DwarfAccelNamespaceSection;
  protected MCSection /*P*/ DwarfAccelTypesSection;
  
  // These are used for the Fission separate debug information files.
  protected MCSection /*P*/ DwarfInfoDWOSection;
  protected MCSection /*P*/ DwarfTypesDWOSection;
  protected MCSection /*P*/ DwarfAbbrevDWOSection;
  protected MCSection /*P*/ DwarfStrDWOSection;
  protected MCSection /*P*/ DwarfLineDWOSection;
  protected MCSection /*P*/ DwarfLocDWOSection;
  protected MCSection /*P*/ DwarfStrOffDWOSection;
  protected MCSection /*P*/ DwarfAddrSection;
  
  // These are for Fission DWP files.
  protected MCSection /*P*/ DwarfCUIndexSection;
  protected MCSection /*P*/ DwarfTUIndexSection;
  
  /// Section for newer gnu pubnames.
  protected MCSection /*P*/ DwarfGnuPubNamesSection;
  /// Section for newer gnu pubtypes.
  protected MCSection /*P*/ DwarfGnuPubTypesSection;
  
  protected MCSection /*P*/ COFFDebugSymbolsSection;
  protected MCSection /*P*/ COFFDebugTypesSection;
  
  /// Extra TLS Variable Data section.
  ///
  /// If the target needs to put additional information for a TLS variable,
  /// it'll go here.
  protected MCSection /*P*/ TLSExtraDataSection;
  
  /// Section directive for Thread Local data. ELF, MachO and COFF.
  protected MCSection /*P*/ TLSDataSection; // Defaults to ".tdata".
  
  /// Section directive for Thread Local uninitialized data.
  ///
  /// Null if this target doesn't support a BSS section. ELF and MachO only.
  protected MCSection /*P*/ TLSBSSSection; // Defaults to ".tbss".
  
  /// StackMap section.
  protected MCSection /*P*/ StackMapSection;
  
  /// FaultMap section.
  protected MCSection /*P*/ FaultMapSection;
  
  /// EH frame section.
  ///
  /// It is initialized on demand so it can be overwritten (with uniquing).
  protected MCSection /*P*/ EHFrameSection;
  
  // ELF specific sections.
  protected MCSection /*P*/ DataRelROSection;
  protected MCSection /*P*/ MergeableConst4Section;
  protected MCSection /*P*/ MergeableConst8Section;
  protected MCSection /*P*/ MergeableConst16Section;
  protected MCSection /*P*/ MergeableConst32Section;
  
  // MachO specific sections.
  
  /// Section for thread local structure information.
  ///
  /// Contains the source code name of the variable, visibility and a pointer to
  /// the initial value (.tdata or .tbss).
  protected MCSection /*P*/ TLSTLVSection; // Defaults to ".tlv".
  
  /// Section for thread local data initialization functions.
  protected /*const*/ MCSection /*P*/ TLSThreadInitSection; // Defaults to ".thread_init_func".
  
  protected MCSection /*P*/ CStringSection;
  protected MCSection /*P*/ UStringSection;
  protected MCSection /*P*/ TextCoalSection;
  protected MCSection /*P*/ ConstTextCoalSection;
  protected MCSection /*P*/ ConstDataSection;
  protected MCSection /*P*/ DataCoalSection;
  protected MCSection /*P*/ DataCommonSection;
  protected MCSection /*P*/ DataBSSSection;
  protected MCSection /*P*/ FourByteConstantSection;
  protected MCSection /*P*/ EightByteConstantSection;
  protected MCSection /*P*/ SixteenByteConstantSection;
  protected MCSection /*P*/ LazySymbolPointerSection;
  protected MCSection /*P*/ NonLazySymbolPointerSection;
  protected MCSection /*P*/ ThreadLocalPointerSection;
  
  /// COFF specific sections.
  protected MCSection /*P*/ DrectveSection;
  protected MCSection /*P*/ PDataSection;
  protected MCSection /*P*/ XDataSection;
  protected MCSection /*P*/ SXDataSection;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::InitMCObjectFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp", line = 833,
   FQN="llvm::MCObjectFileInfo::InitMCObjectFileInfo", NM="_ZN4llvm16MCObjectFileInfo20InitMCObjectFileInfoERKNS_6TripleEbNS_9CodeModel5ModelERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZN4llvm16MCObjectFileInfo20InitMCObjectFileInfoERKNS_6TripleEbNS_9CodeModel5ModelERNS_9MCContextE")
  //</editor-fold>
  public void InitMCObjectFileInfo(final /*const*/ Triple /*&*/ TheTriple, boolean PIC, 
                      CodeModel.Model cm, 
                      final MCContext /*&*/ ctx) {
    PositionIndependent = PIC;
    CMModel = cm;
    Ctx = $AddrOf(ctx);
    
    // Common.
    CommDirectiveSupportsAlignment = true;
    SupportsWeakOmittedEHFrame = true;
    SupportsCompactUnwindWithoutEHFrame = false;
    OmitDwarfIfHaveCompactUnwind = false;
    
    PersonalityEncoding = LSDAEncoding = FDECFIEncoding = TTypeEncoding
       = Constants.DW_EH_PE_absptr;
    
    CompactUnwindDwarfEHFrameOnly = 0;
    
    EHFrameSection = null; // Created on demand.
    CompactUnwindSection = null; // Used only by selected targets.
    DwarfAccelNamesSection = null; // Used only by selected targets.
    DwarfAccelObjCSection = null; // Used only by selected targets.
    DwarfAccelNamespaceSection = null; // Used only by selected targets.
    DwarfAccelTypesSection = null; // Used only by selected targets.
    
    TT.$assign(TheTriple);
    switch (TT.getObjectFormat()) {
     case MachO:
      Env = Environment.IsMachO;
      initMachOMCObjectFileInfo(TT);
      break;
     case COFF:
      if (!TT.isOSWindows()) {
        report_fatal_error($("Cannot initialize MC for non-Windows COFF object files."));
      }
      
      Env = Environment.IsCOFF;
      initCOFFMCObjectFileInfo(TT);
      break;
     case ELF:
      Env = Environment.IsELF;
      initELFMCObjectFileInfo(TT);
      break;
     case UnknownObjectFormat:
      report_fatal_error($("Cannot initialize MC for unknown object file format."));
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getSupportsWeakOmittedEHFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 200,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 201,
   FQN="llvm::MCObjectFileInfo::getSupportsWeakOmittedEHFrame", NM="_ZNK4llvm16MCObjectFileInfo29getSupportsWeakOmittedEHFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo29getSupportsWeakOmittedEHFrameEv")
  //</editor-fold>
  public boolean getSupportsWeakOmittedEHFrame() /*const*/ {
    return SupportsWeakOmittedEHFrame;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getSupportsCompactUnwindWithoutEHFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 203,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 204,
   FQN="llvm::MCObjectFileInfo::getSupportsCompactUnwindWithoutEHFrame", NM="_ZNK4llvm16MCObjectFileInfo38getSupportsCompactUnwindWithoutEHFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo38getSupportsCompactUnwindWithoutEHFrameEv")
  //</editor-fold>
  public boolean getSupportsCompactUnwindWithoutEHFrame() /*const*/ {
    return SupportsCompactUnwindWithoutEHFrame;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getOmitDwarfIfHaveCompactUnwind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 206,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 207,
   FQN="llvm::MCObjectFileInfo::getOmitDwarfIfHaveCompactUnwind", NM="_ZNK4llvm16MCObjectFileInfo31getOmitDwarfIfHaveCompactUnwindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo31getOmitDwarfIfHaveCompactUnwindEv")
  //</editor-fold>
  public boolean getOmitDwarfIfHaveCompactUnwind() /*const*/ {
    return OmitDwarfIfHaveCompactUnwind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getCommDirectiveSupportsAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 210,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 211,
   FQN="llvm::MCObjectFileInfo::getCommDirectiveSupportsAlignment", NM="_ZNK4llvm16MCObjectFileInfo33getCommDirectiveSupportsAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo33getCommDirectiveSupportsAlignmentEv")
  //</editor-fold>
  public boolean getCommDirectiveSupportsAlignment() /*const*/ {
    return CommDirectiveSupportsAlignment;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getPersonalityEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 215,
   FQN="llvm::MCObjectFileInfo::getPersonalityEncoding", NM="_ZNK4llvm16MCObjectFileInfo22getPersonalityEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo22getPersonalityEncodingEv")
  //</editor-fold>
  public /*uint*/int getPersonalityEncoding() /*const*/ {
    return PersonalityEncoding;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getLSDAEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 215,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 216,
   FQN="llvm::MCObjectFileInfo::getLSDAEncoding", NM="_ZNK4llvm16MCObjectFileInfo15getLSDAEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo15getLSDAEncodingEv")
  //</editor-fold>
  public /*uint*/int getLSDAEncoding() /*const*/ {
    return LSDAEncoding;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getFDEEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 216,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 217,
   FQN="llvm::MCObjectFileInfo::getFDEEncoding", NM="_ZNK4llvm16MCObjectFileInfo14getFDEEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo14getFDEEncodingEv")
  //</editor-fold>
  public /*uint*/int getFDEEncoding() /*const*/ {
    return FDECFIEncoding;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTTypeEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 217,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 218,
   FQN="llvm::MCObjectFileInfo::getTTypeEncoding", NM="_ZNK4llvm16MCObjectFileInfo16getTTypeEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo16getTTypeEncodingEv")
  //</editor-fold>
  public /*uint*/int getTTypeEncoding() /*const*/ {
    return TTypeEncoding;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getCompactUnwindDwarfEHFrameOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 219,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 220,
   FQN="llvm::MCObjectFileInfo::getCompactUnwindDwarfEHFrameOnly", NM="_ZNK4llvm16MCObjectFileInfo32getCompactUnwindDwarfEHFrameOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo32getCompactUnwindDwarfEHFrameOnlyEv")
  //</editor-fold>
  public /*uint*/int getCompactUnwindDwarfEHFrameOnly() /*const*/ {
    return CompactUnwindDwarfEHFrameOnly;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTextSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 223,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 224,
   FQN="llvm::MCObjectFileInfo::getTextSection", NM="_ZNK4llvm16MCObjectFileInfo14getTextSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo14getTextSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getTextSection() /*const*/ {
    return TextSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 224,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 225,
   FQN="llvm::MCObjectFileInfo::getDataSection", NM="_ZNK4llvm16MCObjectFileInfo14getDataSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo14getDataSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDataSection() /*const*/ {
    return DataSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getBSSSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 226,
   FQN="llvm::MCObjectFileInfo::getBSSSection", NM="_ZNK4llvm16MCObjectFileInfo13getBSSSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo13getBSSSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getBSSSection() /*const*/ {
    return BSSSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getReadOnlySection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 227,
   FQN="llvm::MCObjectFileInfo::getReadOnlySection", NM="_ZNK4llvm16MCObjectFileInfo18getReadOnlySectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo18getReadOnlySectionEv")
  //</editor-fold>
  public MCSection /*P*/ getReadOnlySection() /*const*/ {
    return ReadOnlySection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getLSDASection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 227,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 228,
   FQN="llvm::MCObjectFileInfo::getLSDASection", NM="_ZNK4llvm16MCObjectFileInfo14getLSDASectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo14getLSDASectionEv")
  //</editor-fold>
  public MCSection /*P*/ getLSDASection() /*const*/ {
    return LSDASection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getCompactUnwindSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 228,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 229,
   FQN="llvm::MCObjectFileInfo::getCompactUnwindSection", NM="_ZNK4llvm16MCObjectFileInfo23getCompactUnwindSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo23getCompactUnwindSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getCompactUnwindSection() /*const*/ {
    return CompactUnwindSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfAbbrevSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 229,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 230,
   FQN="llvm::MCObjectFileInfo::getDwarfAbbrevSection", NM="_ZNK4llvm16MCObjectFileInfo21getDwarfAbbrevSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo21getDwarfAbbrevSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfAbbrevSection() /*const*/ {
    return DwarfAbbrevSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfInfoSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 230,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 231,
   FQN="llvm::MCObjectFileInfo::getDwarfInfoSection", NM="_ZNK4llvm16MCObjectFileInfo19getDwarfInfoSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo19getDwarfInfoSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfInfoSection() /*const*/ {
    return DwarfInfoSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfLineSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 231,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 232,
   FQN="llvm::MCObjectFileInfo::getDwarfLineSection", NM="_ZNK4llvm16MCObjectFileInfo19getDwarfLineSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo19getDwarfLineSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfLineSection() /*const*/ {
    return DwarfLineSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfFrameSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 232,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 233,
   FQN="llvm::MCObjectFileInfo::getDwarfFrameSection", NM="_ZNK4llvm16MCObjectFileInfo20getDwarfFrameSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo20getDwarfFrameSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfFrameSection() /*const*/ {
    return DwarfFrameSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfPubNamesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 234,
   FQN="llvm::MCObjectFileInfo::getDwarfPubNamesSection", NM="_ZNK4llvm16MCObjectFileInfo23getDwarfPubNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo23getDwarfPubNamesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfPubNamesSection() /*const*/ {
    return DwarfPubNamesSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfPubTypesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 234,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 235,
   FQN="llvm::MCObjectFileInfo::getDwarfPubTypesSection", NM="_ZNK4llvm16MCObjectFileInfo23getDwarfPubTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo23getDwarfPubTypesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfPubTypesSection() /*const*/ {
    return DwarfPubTypesSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfGnuPubNamesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 235,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 236,
   FQN="llvm::MCObjectFileInfo::getDwarfGnuPubNamesSection", NM="_ZNK4llvm16MCObjectFileInfo26getDwarfGnuPubNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo26getDwarfGnuPubNamesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfGnuPubNamesSection() /*const*/ {
    return DwarfGnuPubNamesSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfGnuPubTypesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 238,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 239,
   FQN="llvm::MCObjectFileInfo::getDwarfGnuPubTypesSection", NM="_ZNK4llvm16MCObjectFileInfo26getDwarfGnuPubTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo26getDwarfGnuPubTypesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfGnuPubTypesSection() /*const*/ {
    return DwarfGnuPubTypesSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfDebugInlineSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 241,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 242,
   FQN="llvm::MCObjectFileInfo::getDwarfDebugInlineSection", NM="_ZNK4llvm16MCObjectFileInfo26getDwarfDebugInlineSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo26getDwarfDebugInlineSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getDwarfDebugInlineSection() /*const*/ {
    return DwarfDebugInlineSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfStrSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 244,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 245,
   FQN="llvm::MCObjectFileInfo::getDwarfStrSection", NM="_ZNK4llvm16MCObjectFileInfo18getDwarfStrSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo18getDwarfStrSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfStrSection() /*const*/ {
    return DwarfStrSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfLocSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 245,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 246,
   FQN="llvm::MCObjectFileInfo::getDwarfLocSection", NM="_ZNK4llvm16MCObjectFileInfo18getDwarfLocSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo18getDwarfLocSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfLocSection() /*const*/ {
    return DwarfLocSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfARangesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 246,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 247,
   FQN="llvm::MCObjectFileInfo::getDwarfARangesSection", NM="_ZNK4llvm16MCObjectFileInfo22getDwarfARangesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo22getDwarfARangesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfARangesSection() /*const*/ {
    return DwarfARangesSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfRangesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 248,
   FQN="llvm::MCObjectFileInfo::getDwarfRangesSection", NM="_ZNK4llvm16MCObjectFileInfo21getDwarfRangesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo21getDwarfRangesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfRangesSection() /*const*/ {
    return DwarfRangesSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfMacinfoSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 248,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 249,
   FQN="llvm::MCObjectFileInfo::getDwarfMacinfoSection", NM="_ZNK4llvm16MCObjectFileInfo22getDwarfMacinfoSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo22getDwarfMacinfoSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfMacinfoSection() /*const*/ {
    return DwarfMacinfoSection;
  }

  
  // DWARF5 Experimental Debug Info Sections
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfAccelNamesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 252,
   FQN="llvm::MCObjectFileInfo::getDwarfAccelNamesSection", NM="_ZNK4llvm16MCObjectFileInfo25getDwarfAccelNamesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo25getDwarfAccelNamesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfAccelNamesSection() /*const*/ {
    return DwarfAccelNamesSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfAccelObjCSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 255,
   FQN="llvm::MCObjectFileInfo::getDwarfAccelObjCSection", NM="_ZNK4llvm16MCObjectFileInfo24getDwarfAccelObjCSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo24getDwarfAccelObjCSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfAccelObjCSection() /*const*/ {
    return DwarfAccelObjCSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfAccelNamespaceSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 255,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 256,
   FQN="llvm::MCObjectFileInfo::getDwarfAccelNamespaceSection", NM="_ZNK4llvm16MCObjectFileInfo29getDwarfAccelNamespaceSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo29getDwarfAccelNamespaceSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfAccelNamespaceSection() /*const*/ {
    return DwarfAccelNamespaceSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfAccelTypesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 258,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 259,
   FQN="llvm::MCObjectFileInfo::getDwarfAccelTypesSection", NM="_ZNK4llvm16MCObjectFileInfo25getDwarfAccelTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo25getDwarfAccelTypesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfAccelTypesSection() /*const*/ {
    return DwarfAccelTypesSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfInfoDWOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 261,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 262,
   FQN="llvm::MCObjectFileInfo::getDwarfInfoDWOSection", NM="_ZNK4llvm16MCObjectFileInfo22getDwarfInfoDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo22getDwarfInfoDWOSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfInfoDWOSection() /*const*/ {
    return DwarfInfoDWOSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfTypesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp", line = 883,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp", old_line = 851,
   FQN="llvm::MCObjectFileInfo::getDwarfTypesSection", NM="_ZNK4llvm16MCObjectFileInfo20getDwarfTypesSectionEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo20getDwarfTypesSectionEy")
  //</editor-fold>
  public MCSection /*P*/ getDwarfTypesSection(long/*uint64_t*/ Hash) /*const*/ {
    return Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_types"), ELF.SHT_PROGBITS, ELF.SHF_GROUP, 
        0, new Twine(utostr(Hash)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfTypesDWOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 263,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 264,
   FQN="llvm::MCObjectFileInfo::getDwarfTypesDWOSection", NM="_ZNK4llvm16MCObjectFileInfo23getDwarfTypesDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo23getDwarfTypesDWOSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfTypesDWOSection() /*const*/ {
    return DwarfTypesDWOSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfAbbrevDWOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 264,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 265,
   FQN="llvm::MCObjectFileInfo::getDwarfAbbrevDWOSection", NM="_ZNK4llvm16MCObjectFileInfo24getDwarfAbbrevDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo24getDwarfAbbrevDWOSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfAbbrevDWOSection() /*const*/ {
    return DwarfAbbrevDWOSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfStrDWOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 265,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 266,
   FQN="llvm::MCObjectFileInfo::getDwarfStrDWOSection", NM="_ZNK4llvm16MCObjectFileInfo21getDwarfStrDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo21getDwarfStrDWOSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfStrDWOSection() /*const*/ {
    return DwarfStrDWOSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfLineDWOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 266,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 267,
   FQN="llvm::MCObjectFileInfo::getDwarfLineDWOSection", NM="_ZNK4llvm16MCObjectFileInfo22getDwarfLineDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo22getDwarfLineDWOSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfLineDWOSection() /*const*/ {
    return DwarfLineDWOSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfLocDWOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 268,
   FQN="llvm::MCObjectFileInfo::getDwarfLocDWOSection", NM="_ZNK4llvm16MCObjectFileInfo21getDwarfLocDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo21getDwarfLocDWOSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfLocDWOSection() /*const*/ {
    return DwarfLocDWOSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfStrOffDWOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 268,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 269,
   FQN="llvm::MCObjectFileInfo::getDwarfStrOffDWOSection", NM="_ZNK4llvm16MCObjectFileInfo24getDwarfStrOffDWOSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo24getDwarfStrOffDWOSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfStrOffDWOSection() /*const*/ {
    return DwarfStrOffDWOSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfAddrSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 269,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 270,
   FQN="llvm::MCObjectFileInfo::getDwarfAddrSection", NM="_ZNK4llvm16MCObjectFileInfo19getDwarfAddrSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo19getDwarfAddrSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfAddrSection() /*const*/ {
    return DwarfAddrSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfCUIndexSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 270,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 271,
   FQN="llvm::MCObjectFileInfo::getDwarfCUIndexSection", NM="_ZNK4llvm16MCObjectFileInfo22getDwarfCUIndexSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo22getDwarfCUIndexSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfCUIndexSection() /*const*/ {
    return DwarfCUIndexSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDwarfTUIndexSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 271,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 272,
   FQN="llvm::MCObjectFileInfo::getDwarfTUIndexSection", NM="_ZNK4llvm16MCObjectFileInfo22getDwarfTUIndexSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo22getDwarfTUIndexSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDwarfTUIndexSection() /*const*/ {
    return DwarfTUIndexSection;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getCOFFDebugSymbolsSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 273,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 274,
   FQN="llvm::MCObjectFileInfo::getCOFFDebugSymbolsSection", NM="_ZNK4llvm16MCObjectFileInfo26getCOFFDebugSymbolsSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo26getCOFFDebugSymbolsSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getCOFFDebugSymbolsSection() /*const*/ {
    return COFFDebugSymbolsSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getCOFFDebugTypesSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 276,
   FQN="llvm::MCObjectFileInfo::getCOFFDebugTypesSection", NM="_ZNK4llvm16MCObjectFileInfo24getCOFFDebugTypesSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo24getCOFFDebugTypesSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getCOFFDebugTypesSection() /*const*/ {
    return COFFDebugTypesSection;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTLSExtraDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 281,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 278,
   FQN="llvm::MCObjectFileInfo::getTLSExtraDataSection", NM="_ZNK4llvm16MCObjectFileInfo22getTLSExtraDataSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo22getTLSExtraDataSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getTLSExtraDataSection() /*const*/ {
    return TLSExtraDataSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTLSDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 282,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 279,
   FQN="llvm::MCObjectFileInfo::getTLSDataSection", NM="_ZNK4llvm16MCObjectFileInfo17getTLSDataSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo17getTLSDataSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getTLSDataSection() /*const*/ {
    return TLSDataSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTLSBSSSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 283,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 280,
   FQN="llvm::MCObjectFileInfo::getTLSBSSSection", NM="_ZNK4llvm16MCObjectFileInfo16getTLSBSSSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo16getTLSBSSSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getTLSBSSSection() /*const*/ {
    return TLSBSSSection;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getStackMapSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 285,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 282,
   FQN="llvm::MCObjectFileInfo::getStackMapSection", NM="_ZNK4llvm16MCObjectFileInfo18getStackMapSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo18getStackMapSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getStackMapSection() /*const*/ {
    return StackMapSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getFaultMapSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 286,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 283,
   FQN="llvm::MCObjectFileInfo::getFaultMapSection", NM="_ZNK4llvm16MCObjectFileInfo18getFaultMapSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo18getFaultMapSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getFaultMapSection() /*const*/ {
    return FaultMapSection;
  }

  
  // ELF specific sections.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDataRelROSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 289,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 286,
   FQN="llvm::MCObjectFileInfo::getDataRelROSection", NM="_ZNK4llvm16MCObjectFileInfo19getDataRelROSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo19getDataRelROSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDataRelROSection() /*const*/ {
    return DataRelROSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getMergeableConst4Section">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 290,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 287,
   FQN="llvm::MCObjectFileInfo::getMergeableConst4Section", NM="_ZNK4llvm16MCObjectFileInfo25getMergeableConst4SectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo25getMergeableConst4SectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getMergeableConst4Section() /*const*/ {
    return MergeableConst4Section;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getMergeableConst8Section">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 293,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 290,
   FQN="llvm::MCObjectFileInfo::getMergeableConst8Section", NM="_ZNK4llvm16MCObjectFileInfo25getMergeableConst8SectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo25getMergeableConst8SectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getMergeableConst8Section() /*const*/ {
    return MergeableConst8Section;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getMergeableConst16Section">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 296,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 293,
   FQN="llvm::MCObjectFileInfo::getMergeableConst16Section", NM="_ZNK4llvm16MCObjectFileInfo26getMergeableConst16SectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo26getMergeableConst16SectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getMergeableConst16Section() /*const*/ {
    return MergeableConst16Section;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getMergeableConst32Section">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 299,
   FQN="llvm::MCObjectFileInfo::getMergeableConst32Section", NM="_ZNK4llvm16MCObjectFileInfo26getMergeableConst32SectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo26getMergeableConst32SectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getMergeableConst32Section() /*const*/ {
    return MergeableConst32Section;
  }

  
  // MachO specific sections.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTLSTLVSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 304,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 298,
   FQN="llvm::MCObjectFileInfo::getTLSTLVSection", NM="_ZNK4llvm16MCObjectFileInfo16getTLSTLVSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo16getTLSTLVSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getTLSTLVSection() /*const*/ {
    return TLSTLVSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTLSThreadInitSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 299,
   FQN="llvm::MCObjectFileInfo::getTLSThreadInitSection", NM="_ZNK4llvm16MCObjectFileInfo23getTLSThreadInitSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo23getTLSThreadInitSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getTLSThreadInitSection() /*const*/ {
    return TLSThreadInitSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getCStringSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 308,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 302,
   FQN="llvm::MCObjectFileInfo::getCStringSection", NM="_ZNK4llvm16MCObjectFileInfo17getCStringSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo17getCStringSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getCStringSection() /*const*/ {
    return CStringSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getUStringSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 303,
   FQN="llvm::MCObjectFileInfo::getUStringSection", NM="_ZNK4llvm16MCObjectFileInfo17getUStringSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo17getUStringSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getUStringSection() /*const*/ {
    return UStringSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTextCoalSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 310,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 304,
   FQN="llvm::MCObjectFileInfo::getTextCoalSection", NM="_ZNK4llvm16MCObjectFileInfo18getTextCoalSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo18getTextCoalSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getTextCoalSection() /*const*/ {
    return TextCoalSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getConstTextCoalSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 311,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 305,
   FQN="llvm::MCObjectFileInfo::getConstTextCoalSection", NM="_ZNK4llvm16MCObjectFileInfo23getConstTextCoalSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo23getConstTextCoalSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getConstTextCoalSection() /*const*/ {
    return ConstTextCoalSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getConstDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 314,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 308,
   FQN="llvm::MCObjectFileInfo::getConstDataSection", NM="_ZNK4llvm16MCObjectFileInfo19getConstDataSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo19getConstDataSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getConstDataSection() /*const*/ {
    return ConstDataSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDataCoalSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 315,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 309,
   FQN="llvm::MCObjectFileInfo::getDataCoalSection", NM="_ZNK4llvm16MCObjectFileInfo18getDataCoalSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo18getDataCoalSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getDataCoalSection() /*const*/ {
    return DataCoalSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDataCommonSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 316,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 310,
   FQN="llvm::MCObjectFileInfo::getDataCommonSection", NM="_ZNK4llvm16MCObjectFileInfo20getDataCommonSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo20getDataCommonSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getDataCommonSection() /*const*/ {
    return DataCommonSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDataBSSSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 311,
   FQN="llvm::MCObjectFileInfo::getDataBSSSection", NM="_ZNK4llvm16MCObjectFileInfo17getDataBSSSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo17getDataBSSSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDataBSSSection() /*const*/ {
    return DataBSSSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getFourByteConstantSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 318,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 312,
   FQN="llvm::MCObjectFileInfo::getFourByteConstantSection", NM="_ZNK4llvm16MCObjectFileInfo26getFourByteConstantSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo26getFourByteConstantSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getFourByteConstantSection() /*const*/ {
    return FourByteConstantSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getEightByteConstantSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 321,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 315,
   FQN="llvm::MCObjectFileInfo::getEightByteConstantSection", NM="_ZNK4llvm16MCObjectFileInfo27getEightByteConstantSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo27getEightByteConstantSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getEightByteConstantSection() /*const*/ {
    return EightByteConstantSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getSixteenByteConstantSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 324,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 318,
   FQN="llvm::MCObjectFileInfo::getSixteenByteConstantSection", NM="_ZNK4llvm16MCObjectFileInfo29getSixteenByteConstantSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo29getSixteenByteConstantSectionEv")
  //</editor-fold>
  public /*const*/ MCSection /*P*/ getSixteenByteConstantSection() /*const*/ {
    return SixteenByteConstantSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getLazySymbolPointerSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 327,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 321,
   FQN="llvm::MCObjectFileInfo::getLazySymbolPointerSection", NM="_ZNK4llvm16MCObjectFileInfo27getLazySymbolPointerSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo27getLazySymbolPointerSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getLazySymbolPointerSection() /*const*/ {
    return LazySymbolPointerSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getNonLazySymbolPointerSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 330,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 324,
   FQN="llvm::MCObjectFileInfo::getNonLazySymbolPointerSection", NM="_ZNK4llvm16MCObjectFileInfo30getNonLazySymbolPointerSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo30getNonLazySymbolPointerSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getNonLazySymbolPointerSection() /*const*/ {
    return NonLazySymbolPointerSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getThreadLocalPointerSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 333,
   FQN="llvm::MCObjectFileInfo::getThreadLocalPointerSection", NM="_ZNK4llvm16MCObjectFileInfo28getThreadLocalPointerSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo28getThreadLocalPointerSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getThreadLocalPointerSection() /*const*/ {
    return ThreadLocalPointerSection;
  }

  
  // COFF specific sections.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getDrectveSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 338,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 329,
   FQN="llvm::MCObjectFileInfo::getDrectveSection", NM="_ZNK4llvm16MCObjectFileInfo17getDrectveSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo17getDrectveSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getDrectveSection() /*const*/ {
    return DrectveSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getPDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 339,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 330,
   FQN="llvm::MCObjectFileInfo::getPDataSection", NM="_ZNK4llvm16MCObjectFileInfo15getPDataSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo15getPDataSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getPDataSection() /*const*/ {
    return PDataSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getXDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 340,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 331,
   FQN="llvm::MCObjectFileInfo::getXDataSection", NM="_ZNK4llvm16MCObjectFileInfo15getXDataSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo15getXDataSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getXDataSection() /*const*/ {
    return XDataSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getSXDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 341,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 332,
   FQN="llvm::MCObjectFileInfo::getSXDataSection", NM="_ZNK4llvm16MCObjectFileInfo16getSXDataSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo16getSXDataSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getSXDataSection() /*const*/ {
    return SXDataSection;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getEHFrameSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 334,
   FQN="llvm::MCObjectFileInfo::getEHFrameSection", NM="_ZN4llvm16MCObjectFileInfo17getEHFrameSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZN4llvm16MCObjectFileInfo17getEHFrameSectionEv")
  //</editor-fold>
  public MCSection /*P*/ getEHFrameSection() {
    return EHFrameSection;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::Environment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 347,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 338,
   FQN="llvm::MCObjectFileInfo::Environment", NM="_ZN4llvm16MCObjectFileInfo11EnvironmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZN4llvm16MCObjectFileInfo11EnvironmentE")
  //</editor-fold>
  public enum Environment implements Native.NativeUIntEnum {
    IsMachO(0),
    IsELF(IsMachO.getValue() + 1),
    IsCOFF(IsELF.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Environment valueOf(int val) {
      Environment out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Environment[] VALUES;
      private static final Environment[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Environment kind : Environment.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Environment[min < 0 ? (1-min) : 0];
        VALUES = new Environment[max >= 0 ? (1+max) : 0];
        for (Environment kind : Environment.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Environment(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getObjectFileType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 348,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 339,
   FQN="llvm::MCObjectFileInfo::getObjectFileType", NM="_ZNK4llvm16MCObjectFileInfo17getObjectFileTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo17getObjectFileTypeEv")
  //</editor-fold>
  public Environment getObjectFileType() /*const*/ {
    return Env;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::isPositionIndependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 350,
   FQN="llvm::MCObjectFileInfo::isPositionIndependent", NM="_ZNK4llvm16MCObjectFileInfo21isPositionIndependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo21isPositionIndependentEv")
  //</editor-fold>
  public boolean isPositionIndependent() /*const*/ {
    return PositionIndependent;
  }

/*private:*/
  private Environment Env;
  private boolean PositionIndependent;
  private CodeModel.Model CMModel;
  private MCContext /*P*/ Ctx;
  private Triple TT;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::initMachOMCObjectFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp", line = 48,
   FQN="llvm::MCObjectFileInfo::initMachOMCObjectFileInfo", NM="_ZN4llvm16MCObjectFileInfo25initMachOMCObjectFileInfoERKNS_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZN4llvm16MCObjectFileInfo25initMachOMCObjectFileInfoERKNS_6TripleE")
  //</editor-fold>
  private void initMachOMCObjectFileInfo(final /*const*/ Triple /*&*/ T) {
    // MachO
    SupportsWeakOmittedEHFrame = false;
    
    EHFrameSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__eh_frame"), 
        MachO.SectionType.S_COALESCED | MachO.S_ATTR_NO_TOC
           | MachO.S_ATTR_STRIP_STATIC_SYMS | MachO.S_ATTR_LIVE_SUPPORT, 
        SectionKind.getReadOnly());
    if (T.isOSDarwin() && T.getArch() == Triple.ArchType.aarch64) {
      SupportsCompactUnwindWithoutEHFrame = true;
    }
    if (T.isWatchABI()) {
      OmitDwarfIfHaveCompactUnwind = true;
    }
    
    PersonalityEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
       | Constants.DW_EH_PE_sdata4;
    LSDAEncoding = FDECFIEncoding = Constants.DW_EH_PE_pcrel;
    TTypeEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
       | Constants.DW_EH_PE_sdata4;
    
    // .comm doesn't support alignment before Leopard.
    if (T.isMacOSX() && T.isMacOSXVersionLT(10, 5)) {
      CommDirectiveSupportsAlignment = false;
    }
    
    TextSection // .text
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__text"), 
        MachO.S_ATTR_PURE_INSTRUCTIONS, 
        SectionKind.getText());
    DataSection // .data
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__data"), 0, SectionKind.getData());
    
    // BSSSection might not be expected initialized on msvc.
    BSSSection = null;
    
    TLSDataSection // .tdata
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__thread_data"), 
        MachO.SectionType.S_THREAD_LOCAL_REGULAR, 
        SectionKind.getData());
    TLSBSSSection // .tbss
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__thread_bss"), 
        MachO.SectionType.S_THREAD_LOCAL_ZEROFILL, 
        SectionKind.getThreadBSS());
    
    // TODO: Verify datarel below.
    TLSTLVSection // .tlv
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__thread_vars"), 
        MachO.SectionType.S_THREAD_LOCAL_VARIABLES, 
        SectionKind.getData());
    
    TLSThreadInitSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__thread_init"), MachO.SectionType.S_THREAD_LOCAL_INIT_FUNCTION_POINTERS, 
        SectionKind.getData());
    
    CStringSection // .cstring
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__cstring"), 
        MachO.SectionType.S_CSTRING_LITERALS, 
        SectionKind.getMergeable1ByteCString());
    UStringSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__ustring"), 0, 
        SectionKind.getMergeable2ByteCString());
    FourByteConstantSection // .literal4
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__literal4"), 
        MachO.SectionType.S_4BYTE_LITERALS, 
        SectionKind.getMergeableConst4());
    EightByteConstantSection // .literal8
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__literal8"), 
        MachO.SectionType.S_8BYTE_LITERALS, 
        SectionKind.getMergeableConst8());
    
    SixteenByteConstantSection // .literal16
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__literal16"), 
        MachO.SectionType.S_16BYTE_LITERALS, 
        SectionKind.getMergeableConst16());
    
    ReadOnlySection // .const
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/$__const), 0, 
        SectionKind.getReadOnly());
    
    // If the target is not powerpc, map the coal sections to the non-coal
    // sections.
    //
    // "__TEXT/__textcoal_nt" => section "__TEXT/__text"
    // "__TEXT/__const_coal"  => section "__TEXT/__const"
    // "__DATA/__datacoal_nt" => section "__DATA/__data"
    Triple.ArchType ArchTy = T.getArch();
    if (ArchTy == Triple.ArchType.ppc || ArchTy == Triple.ArchType.ppc64) {
      TextCoalSection
         = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__textcoal_nt"), 
          MachO.SectionType.S_COALESCED
             | MachO.S_ATTR_PURE_INSTRUCTIONS, 
          SectionKind.getText());
      ConstTextCoalSection
         = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__const_coal"), 
          MachO.SectionType.S_COALESCED, 
          SectionKind.getReadOnly());
      DataCoalSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__datacoal_nt"), MachO.SectionType.S_COALESCED, SectionKind.getData());
    } else {
      TextCoalSection = TextSection;
      ConstTextCoalSection = ReadOnlySection;
      DataCoalSection = DataSection;
    }
    
    ConstDataSection // .const_data
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/$__const), 0, 
        SectionKind.getReadOnlyWithRel());
    DataCommonSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__common"), 
        MachO.SectionType.S_ZEROFILL, 
        SectionKind.getBSS());
    DataBSSSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__bss"), MachO.SectionType.S_ZEROFILL, 
        SectionKind.getBSS());
    
    LazySymbolPointerSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__la_symbol_ptr"), 
        MachO.SectionType.S_LAZY_SYMBOL_POINTERS, 
        SectionKind.getMetadata());
    NonLazySymbolPointerSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__nl_symbol_ptr"), 
        MachO.SectionType.S_NON_LAZY_SYMBOL_POINTERS, 
        SectionKind.getMetadata());
    
    ThreadLocalPointerSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__thread_ptr"), 
        MachO.SectionType.S_THREAD_LOCAL_VARIABLE_POINTERS, 
        SectionKind.getMetadata());
    if (!PositionIndependent) {
      StaticCtorSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__constructor"), 0, 
          SectionKind.getData());
      StaticDtorSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__destructor"), 0, 
          SectionKind.getData());
    } else {
      StaticCtorSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__mod_init_func"), 
          MachO.SectionType.S_MOD_INIT_FUNC_POINTERS, 
          SectionKind.getData());
      StaticDtorSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DATA"), new StringRef(/*KEEP_STR*/"__mod_term_func"), 
          MachO.SectionType.S_MOD_TERM_FUNC_POINTERS, 
          SectionKind.getData());
    }
    
    // Exception Handling.
    LSDASection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__TEXT"), new StringRef(/*KEEP_STR*/"__gcc_except_tab"), 0, 
        SectionKind.getReadOnlyWithRel());
    
    COFFDebugSymbolsSection = null;
    COFFDebugTypesSection = null;
    if (MCObjectFileInfoStatics.useCompactUnwind(T)) {
      CompactUnwindSection
         = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__LD"), new StringRef(/*KEEP_STR*/"__compact_unwind"), MachO.S_ATTR_DEBUG, 
          SectionKind.getReadOnly());
      if (T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.x86) {
        CompactUnwindDwarfEHFrameOnly = 0x04000000; // UNWIND_X86_64_MODE_DWARF
      } else if (T.getArch() == Triple.ArchType.aarch64) {
        CompactUnwindDwarfEHFrameOnly = 0x03000000; // UNWIND_ARM64_MODE_DWARF
      } else if (T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) {
        CompactUnwindDwarfEHFrameOnly = 0x04000000; // UNWIND_ARM_MODE_DWARF
      }
    }
    
    // Debug Information.
    DwarfAccelNamesSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__apple_names"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("names_begin"));
    DwarfAccelObjCSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__apple_objc"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("objc_begin"));
    // 16 character section limit...
    DwarfAccelNamespaceSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__apple_namespac"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("namespac_begin"));
    DwarfAccelTypesSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__apple_types"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("types_begin"));
    
    DwarfAbbrevSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_abbrev"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("section_abbrev"));
    DwarfInfoSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_info"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("section_info"));
    DwarfLineSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_line"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("section_line"));
    DwarfFrameSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_frame"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    DwarfPubNamesSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_pubnames"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    DwarfPubTypesSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_pubtypes"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    DwarfGnuPubNamesSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_gnu_pubn"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    DwarfGnuPubTypesSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_gnu_pubt"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    DwarfStrSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_str"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("info_string"));
    DwarfLocSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_loc"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("section_debug_loc"));
    DwarfARangesSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_aranges"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    DwarfRangesSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_ranges"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("debug_range"));
    DwarfMacinfoSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_macinfo"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata(), $("debug_macinfo"));
    DwarfDebugInlineSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_inlined"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    DwarfCUIndexSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_cu_index"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    DwarfTUIndexSection
       = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__DWARF"), new StringRef(/*KEEP_STR*/"__debug_tu_index"), MachO.S_ATTR_DEBUG, 
        SectionKind.getMetadata());
    StackMapSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__LLVM_STACKMAPS"), new StringRef(/*KEEP_STR*/"__llvm_stackmaps"), 
        0, SectionKind.getMetadata());
    
    FaultMapSection = Ctx.getMachOSection(new StringRef(/*KEEP_STR*/"__LLVM_FAULTMAPS"), new StringRef(/*KEEP_STR*/"__llvm_faultmaps"), 
        0, SectionKind.getMetadata());
    
    TLSExtraDataSection = TLSTLVSection;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::initELFMCObjectFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp", line = 286,
   FQN="llvm::MCObjectFileInfo::initELFMCObjectFileInfo", NM="_ZN4llvm16MCObjectFileInfo23initELFMCObjectFileInfoERKNS_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZN4llvm16MCObjectFileInfo23initELFMCObjectFileInfoERKNS_6TripleE")
  //</editor-fold>
  private void initELFMCObjectFileInfo(final /*const*/ Triple /*&*/ T) {
    switch (T.getArch()) {
     case mips:
     case mipsel:
      FDECFIEncoding = Constants.DW_EH_PE_sdata4;
      break;
     case mips64:
     case mips64el:
      FDECFIEncoding = Constants.DW_EH_PE_sdata8;
      break;
     case x86_64:
      FDECFIEncoding = Constants.DW_EH_PE_pcrel
         | ((CMModel == CodeModel.Model.Large) ? Constants.DW_EH_PE_sdata8 : Constants.DW_EH_PE_sdata4);
      break;
     default:
      FDECFIEncoding = Constants.DW_EH_PE_pcrel | Constants.DW_EH_PE_sdata4;
      break;
    }
    switch (T.getArch()) {
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      if (Ctx.getAsmInfo().getExceptionHandlingType() == ExceptionHandling.ARM) {
        break;
      }
     case ppc:
     case x86:
      // Fallthrough if not using EHABI
      PersonalityEncoding = PositionIndependent ? Constants.DW_EH_PE_indirect
         | Constants.DW_EH_PE_pcrel
         | Constants.DW_EH_PE_sdata4 : Constants.DW_EH_PE_absptr;
      LSDAEncoding = PositionIndependent ? Constants.DW_EH_PE_pcrel | Constants.DW_EH_PE_sdata4 : Constants.DW_EH_PE_absptr;
      TTypeEncoding = PositionIndependent ? Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
         | Constants.DW_EH_PE_sdata4 : Constants.DW_EH_PE_absptr;
      break;
     case x86_64:
      if (PositionIndependent) {
        PersonalityEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | ((CMModel == CodeModel.Model.Small || CMModel == CodeModel.Model.Medium) ? Constants.DW_EH_PE_sdata4 : Constants.DW_EH_PE_sdata8);
        LSDAEncoding = Constants.DW_EH_PE_pcrel
           | (CMModel == CodeModel.Model.Small ? Constants.DW_EH_PE_sdata4 : Constants.DW_EH_PE_sdata8);
        TTypeEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | ((CMModel == CodeModel.Model.Small || CMModel == CodeModel.Model.Medium) ? Constants.DW_EH_PE_sdata4 : Constants.DW_EH_PE_sdata8);
      } else {
        PersonalityEncoding
           = (CMModel == CodeModel.Model.Small || CMModel == CodeModel.Model.Medium) ? Constants.DW_EH_PE_udata4 : Constants.DW_EH_PE_absptr;
        LSDAEncoding = (CMModel == CodeModel.Model.Small) ? Constants.DW_EH_PE_udata4 : Constants.DW_EH_PE_absptr;
        TTypeEncoding = (CMModel == CodeModel.Model.Small) ? Constants.DW_EH_PE_udata4 : Constants.DW_EH_PE_absptr;
      }
      break;
     case hexagon:
      PersonalityEncoding = Constants.DW_EH_PE_absptr;
      LSDAEncoding = Constants.DW_EH_PE_absptr;
      FDECFIEncoding = Constants.DW_EH_PE_absptr;
      TTypeEncoding = Constants.DW_EH_PE_absptr;
      if (PositionIndependent) {
        PersonalityEncoding |= Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel;
        LSDAEncoding |= Constants.DW_EH_PE_pcrel;
        FDECFIEncoding |= Constants.DW_EH_PE_pcrel;
        TTypeEncoding |= Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel;
      }
      break;
     case aarch64:
     case aarch64_be:
      // The small model guarantees static code/data size < 4GB, but not where it
      // will be in memory. Most of these could end up >2GB away so even a signed
      // pc-relative 32-bit address is insufficient, theoretically.
      if (PositionIndependent) {
        PersonalityEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | Constants.DW_EH_PE_sdata8;
        LSDAEncoding = Constants.DW_EH_PE_pcrel | Constants.DW_EH_PE_sdata8;
        TTypeEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | Constants.DW_EH_PE_sdata8;
      } else {
        PersonalityEncoding = Constants.DW_EH_PE_absptr;
        LSDAEncoding = Constants.DW_EH_PE_absptr;
        TTypeEncoding = Constants.DW_EH_PE_absptr;
      }
      break;
     case lanai:
      LSDAEncoding = Constants.DW_EH_PE_absptr;
      PersonalityEncoding = Constants.DW_EH_PE_absptr;
      TTypeEncoding = Constants.DW_EH_PE_absptr;
      break;
     case mips:
     case mipsel:
     case mips64:
     case mips64el:
      // MIPS uses indirect pointer to refer personality functions and types, so
      // that the eh_frame section can be read-only. DW.ref.personality will be
      // generated for relocation.
      PersonalityEncoding = Constants.DW_EH_PE_indirect;
      // FIXME: The N64 ABI probably ought to use DW_EH_PE_sdata8 but we can't
      //        identify N64 from just a triple.
      TTypeEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
         | Constants.DW_EH_PE_sdata4;
      // We don't support PC-relative LSDA references in GAS so we use the default
      // DW_EH_PE_absptr for those.
      break;
     case ppc64:
     case ppc64le:
      PersonalityEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
         | Constants.DW_EH_PE_udata8;
      LSDAEncoding = Constants.DW_EH_PE_pcrel | Constants.DW_EH_PE_udata8;
      TTypeEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
         | Constants.DW_EH_PE_udata8;
      break;
     case sparcel:
     case sparc:
      if (PositionIndependent) {
        LSDAEncoding = Constants.DW_EH_PE_pcrel | Constants.DW_EH_PE_sdata4;
        PersonalityEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | Constants.DW_EH_PE_sdata4;
        TTypeEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | Constants.DW_EH_PE_sdata4;
      } else {
        LSDAEncoding = Constants.DW_EH_PE_absptr;
        PersonalityEncoding = Constants.DW_EH_PE_absptr;
        TTypeEncoding = Constants.DW_EH_PE_absptr;
      }
      break;
     case sparcv9:
      LSDAEncoding = Constants.DW_EH_PE_pcrel | Constants.DW_EH_PE_sdata4;
      if (PositionIndependent) {
        PersonalityEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | Constants.DW_EH_PE_sdata4;
        TTypeEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | Constants.DW_EH_PE_sdata4;
      } else {
        PersonalityEncoding = Constants.DW_EH_PE_absptr;
        TTypeEncoding = Constants.DW_EH_PE_absptr;
      }
      break;
     case systemz:
      // All currently-defined code models guarantee that 4-byte PC-relative
      // values will be in range.
      if (PositionIndependent) {
        PersonalityEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | Constants.DW_EH_PE_sdata4;
        LSDAEncoding = Constants.DW_EH_PE_pcrel | Constants.DW_EH_PE_sdata4;
        TTypeEncoding = Constants.DW_EH_PE_indirect | Constants.DW_EH_PE_pcrel
           | Constants.DW_EH_PE_sdata4;
      } else {
        PersonalityEncoding = Constants.DW_EH_PE_absptr;
        LSDAEncoding = Constants.DW_EH_PE_absptr;
        TTypeEncoding = Constants.DW_EH_PE_absptr;
      }
      break;
     default:
      break;
    }
    
    /*uint*/int EHSectionType = T.getArch() == Triple.ArchType.x86_64 ? ELF.SHT_X86_64_UNWIND : ELF.SHT_PROGBITS;
    
    // Solaris requires different flags for .eh_frame to seemingly every other
    // platform.
    /*uint*/int EHSectionFlags = ELF.SHF_ALLOC;
    if (T.isOSSolaris() && T.getArch() != Triple.ArchType.x86_64) {
      EHSectionFlags |= ELF.SHF_WRITE;
    }
    
    // ELF
    BSSSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".bss"), ELF.SHT_NOBITS, 
        ELF.SHF_WRITE | ELF.SHF_ALLOC);
    
    TextSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".text"), ELF.SHT_PROGBITS, 
        ELF.SHF_EXECINSTR | ELF.SHF_ALLOC);
    
    DataSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".data"), ELF.SHT_PROGBITS, 
        ELF.SHF_WRITE | ELF.SHF_ALLOC);
    
    ReadOnlySection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".rodata"), ELF.SHT_PROGBITS, ELF.SHF_ALLOC);
    
    TLSDataSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".tdata"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC | ELF.SHF_TLS | ELF.SHF_WRITE);
    
    TLSBSSSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".tbss"), ELF.SHT_NOBITS, ELF.SHF_ALLOC | ELF.SHF_TLS | ELF.SHF_WRITE);
    
    DataRelROSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".data.rel.ro"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC | ELF.SHF_WRITE);
    
    MergeableConst4Section
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".rodata.cst4"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC | ELF.SHF_MERGE, 4, new Twine(/*KEEP_STR*/$EMPTY));
    
    MergeableConst8Section
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".rodata.cst8"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC | ELF.SHF_MERGE, 8, new Twine(/*KEEP_STR*/$EMPTY));
    
    MergeableConst16Section
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".rodata.cst16"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC | ELF.SHF_MERGE, 16, new Twine(/*KEEP_STR*/$EMPTY));
    
    MergeableConst32Section
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".rodata.cst32"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC | ELF.SHF_MERGE, 32, new Twine(/*KEEP_STR*/$EMPTY));
    
    StaticCtorSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".ctors"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC | ELF.SHF_WRITE);
    
    StaticDtorSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".dtors"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC | ELF.SHF_WRITE);
    
    // Exception Handling Sections.
    
    // FIXME: We're emitting LSDA info into a readonly section on ELF, even though
    // it contains relocatable pointers.  In PIC mode, this is probably a big
    // runtime hit for C++ apps.  Either the contents of the LSDA need to be
    // adjusted or this should be a data section.
    LSDASection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".gcc_except_table"), ELF.SHT_PROGBITS, 
        ELF.SHF_ALLOC);
    
    COFFDebugSymbolsSection = null;
    COFFDebugTypesSection = null;
    
    // Debug Info Sections.
    DwarfAbbrevSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_abbrev"), ELF.SHT_PROGBITS, 0, 
        $("section_abbrev"));
    DwarfInfoSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_info"), ELF.SHT_PROGBITS, 0, $("section_info"));
    DwarfLineSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_line"), ELF.SHT_PROGBITS, 0);
    DwarfFrameSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_frame"), ELF.SHT_PROGBITS, 0);
    DwarfPubNamesSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_pubnames"), ELF.SHT_PROGBITS, 0);
    DwarfPubTypesSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_pubtypes"), ELF.SHT_PROGBITS, 0);
    DwarfGnuPubNamesSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_gnu_pubnames"), ELF.SHT_PROGBITS, 0);
    DwarfGnuPubTypesSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_gnu_pubtypes"), ELF.SHT_PROGBITS, 0);
    DwarfStrSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_str"), ELF.SHT_PROGBITS, 
        ELF.SHF_MERGE | ELF.SHF_STRINGS, 1, new Twine(/*KEEP_STR*/$EMPTY));
    DwarfLocSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_loc"), ELF.SHT_PROGBITS, 0);
    DwarfARangesSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_aranges"), ELF.SHT_PROGBITS, 0);
    DwarfRangesSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_ranges"), ELF.SHT_PROGBITS, 0, $("debug_range"));
    DwarfMacinfoSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_macinfo"), ELF.SHT_PROGBITS, 
        0, $("debug_macinfo"));
    
    // DWARF5 Experimental Debug Info
    
    // Accelerator Tables
    DwarfAccelNamesSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".apple_names"), ELF.SHT_PROGBITS, 0, $("names_begin"));
    DwarfAccelObjCSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".apple_objc"), ELF.SHT_PROGBITS, 0, $("objc_begin"));
    DwarfAccelNamespaceSection = Ctx.getELFSection(new Twine(/*KEEP_STR*/".apple_namespaces"), ELF.SHT_PROGBITS, 0, $("namespac_begin"));
    DwarfAccelTypesSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".apple_types"), ELF.SHT_PROGBITS, 0, $("types_begin"));
    
    // Fission Sections
    DwarfInfoDWOSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_info.dwo"), ELF.SHT_PROGBITS, 0);
    DwarfTypesDWOSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_types.dwo"), ELF.SHT_PROGBITS, 0);
    DwarfAbbrevDWOSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_abbrev.dwo"), ELF.SHT_PROGBITS, 0);
    DwarfStrDWOSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_str.dwo"), ELF.SHT_PROGBITS, 
        ELF.SHF_MERGE | ELF.SHF_STRINGS, 1, new Twine(/*KEEP_STR*/$EMPTY));
    DwarfLineDWOSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_line.dwo"), ELF.SHT_PROGBITS, 0);
    DwarfLocDWOSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_loc.dwo"), ELF.SHT_PROGBITS, 0, $("skel_loc"));
    DwarfStrOffDWOSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_str_offsets.dwo"), ELF.SHT_PROGBITS, 0);
    DwarfAddrSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_addr"), ELF.SHT_PROGBITS, 0, $("addr_sec"));
    
    // DWP Sections
    DwarfCUIndexSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_cu_index"), ELF.SHT_PROGBITS, 0);
    DwarfTUIndexSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".debug_tu_index"), ELF.SHT_PROGBITS, 0);
    
    StackMapSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".llvm_stackmaps"), ELF.SHT_PROGBITS, ELF.SHF_ALLOC);
    
    FaultMapSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".llvm_faultmaps"), ELF.SHT_PROGBITS, ELF.SHF_ALLOC);
    
    EHFrameSection
       = Ctx.getELFSection(new Twine(/*KEEP_STR*/".eh_frame"), EHSectionType, EHSectionFlags);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::initCOFFMCObjectFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp", line = 592,
   FQN="llvm::MCObjectFileInfo::initCOFFMCObjectFileInfo", NM="_ZN4llvm16MCObjectFileInfo24initCOFFMCObjectFileInfoERKNS_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZN4llvm16MCObjectFileInfo24initCOFFMCObjectFileInfoERKNS_6TripleE")
  //</editor-fold>
  private void initCOFFMCObjectFileInfo(final /*const*/ Triple /*&*/ T) {
    EHFrameSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".eh_frame"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ | COFF.SectionCharacteristics.IMAGE_SCN_MEM_WRITE, 
        SectionKind.getData());
    
    // Set the `IMAGE_SCN_MEM_16BIT` flag when compiling for thumb mode.  This is
    // used to indicate to the linker that the text segment contains thumb instructions
    // and to set the ISA selection bit for calls accordingly.
    /*const*/boolean IsThumb = T.getArch() == Triple.ArchType.thumb;
    
    CommDirectiveSupportsAlignment = true;
    
    // COFF
    BSSSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".bss"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_UNINITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ | COFF.SectionCharacteristics.IMAGE_SCN_MEM_WRITE, 
        SectionKind.getBSS());
    TextSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".text"), 
        (IsThumb ? COFF.SectionCharacteristics.IMAGE_SCN_MEM_16BIT : (/*COFF::SectionCharacteristics*//*uint32_t*/int)0)
           | COFF.SectionCharacteristics.IMAGE_SCN_CNT_CODE | COFF.SectionCharacteristics.IMAGE_SCN_MEM_EXECUTE
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getText());
    DataSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".data"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_WRITE, 
        SectionKind.getData());
    ReadOnlySection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".rdata"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getReadOnly());
    if (T.isKnownWindowsMSVCEnvironment() || T.isWindowsItaniumEnvironment()) {
      StaticCtorSection
         = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".CRT$XCU"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
             | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
          SectionKind.getReadOnly());
      StaticDtorSection
         = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".CRT$XTX"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
             | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
          SectionKind.getReadOnly());
    } else {
      StaticCtorSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".ctors"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
             | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ | COFF.SectionCharacteristics.IMAGE_SCN_MEM_WRITE, 
          SectionKind.getData());
      StaticDtorSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".dtors"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
             | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ | COFF.SectionCharacteristics.IMAGE_SCN_MEM_WRITE, 
          SectionKind.getData());
    }
    
    // FIXME: We're emitting LSDA info into a readonly section on COFF, even
    // though it contains relocatable pointers.  In PIC mode, this is probably a
    // big runtime hit for C++ apps.  Either the contents of the LSDA need to be
    // adjusted or this should be a data section.
    if (T.getArch() == Triple.ArchType.x86_64) {
      // On Windows 64 with SEH, the LSDA is emitted into the .xdata section
      LSDASection = null;
    } else {
      LSDASection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".gcc_except_table"), 
          COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
             | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
          SectionKind.getReadOnly());
    }
    
    // Debug info.
    COFFDebugSymbolsSection
       = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug$S"), (COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE
           | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ), 
        SectionKind.getMetadata());
    COFFDebugTypesSection
       = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug$T"), (COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE
           | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ), 
        SectionKind.getMetadata());
    
    DwarfAbbrevSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_abbrev"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("section_abbrev"));
    DwarfInfoSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_info"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("section_info"));
    DwarfLineSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_line"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("section_line"));
    
    DwarfFrameSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_frame"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfPubNamesSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_pubnames"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfPubTypesSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_pubtypes"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfGnuPubNamesSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_gnu_pubnames"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfGnuPubTypesSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_gnu_pubtypes"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfStrSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_str"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("info_string"));
    DwarfLocSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_loc"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("section_debug_loc"));
    DwarfARangesSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_aranges"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfRangesSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_ranges"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("debug_range"));
    DwarfMacinfoSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_macinfo"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("debug_macinfo"));
    DwarfInfoDWOSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_info.dwo"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("section_info_dwo"));
    DwarfTypesDWOSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_types.dwo"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("section_types_dwo"));
    DwarfAbbrevDWOSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_abbrev.dwo"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("section_abbrev_dwo"));
    DwarfStrDWOSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_str.dwo"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("skel_string"));
    DwarfLineDWOSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_line.dwo"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfLocDWOSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_loc.dwo"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("skel_loc"));
    DwarfStrOffDWOSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_str_offsets.dwo"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfAddrSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_addr"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("addr_sec"));
    DwarfCUIndexSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_cu_index"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfTUIndexSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".debug_tu_index"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata());
    DwarfAccelNamesSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".apple_names"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("names_begin"));
    DwarfAccelNamespaceSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".apple_namespaces"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("namespac_begin"));
    DwarfAccelTypesSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".apple_types"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("types_begin"));
    DwarfAccelObjCSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".apple_objc"), 
        COFF.SectionCharacteristics.IMAGE_SCN_MEM_DISCARDABLE | COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getMetadata(), $("objc_begin"));
    
    DrectveSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".drectve"), COFF.SectionCharacteristics.IMAGE_SCN_LNK_INFO | COFF.SectionCharacteristics.IMAGE_SCN_LNK_REMOVE, 
        SectionKind.getMetadata());
    
    PDataSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".pdata"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getData());
    
    XDataSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".xdata"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getData());
    
    SXDataSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".sxdata"), COFF.SectionCharacteristics.IMAGE_SCN_LNK_INFO, 
        SectionKind.getMetadata());
    
    TLSDataSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".tls$"), COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_WRITE, 
        SectionKind.getData());
    
    StackMapSection = Ctx.getCOFFSection(new StringRef(/*KEEP_STR*/".llvm_stackmaps"), 
        COFF.SectionCharacteristics.IMAGE_SCN_CNT_INITIALIZED_DATA
           | COFF.SectionCharacteristics.IMAGE_SCN_MEM_READ, 
        SectionKind.getReadOnly());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::getTargetTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 364,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", old_line = 355,
   FQN="llvm::MCObjectFileInfo::getTargetTriple", NM="_ZNK4llvm16MCObjectFileInfo15getTargetTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectFileInfo.cpp -nm=_ZNK4llvm16MCObjectFileInfo15getTargetTripleEv")
  //</editor-fold>
  public /*const*/ Triple /*&*/ getTargetTriple() /*const*/ {
    return TT;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::MCObjectFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 24,
   FQN="llvm::MCObjectFileInfo::MCObjectFileInfo", NM="_ZN4llvm16MCObjectFileInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm16MCObjectFileInfoC1Ev")
  //</editor-fold>
  public /*inline*/ MCObjectFileInfo() {
    // : TT() 
    //START JInit
    this.TT = new Triple();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectFileInfo::~MCObjectFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectFileInfo.h", line = 24,
   FQN="llvm::MCObjectFileInfo::~MCObjectFileInfo", NM="_ZN4llvm16MCObjectFileInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm16MCObjectFileInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    TT.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CommDirectiveSupportsAlignment=" + CommDirectiveSupportsAlignment // NOI18N
              + ", SupportsWeakOmittedEHFrame=" + SupportsWeakOmittedEHFrame // NOI18N
              + ", SupportsCompactUnwindWithoutEHFrame=" + SupportsCompactUnwindWithoutEHFrame // NOI18N
              + ", OmitDwarfIfHaveCompactUnwind=" + OmitDwarfIfHaveCompactUnwind // NOI18N
              + ", PersonalityEncoding=" + PersonalityEncoding // NOI18N
              + ", LSDAEncoding=" + LSDAEncoding // NOI18N
              + ", FDECFIEncoding=" + FDECFIEncoding // NOI18N
              + ", TTypeEncoding=" + TTypeEncoding // NOI18N
              + ", CompactUnwindDwarfEHFrameOnly=" + CompactUnwindDwarfEHFrameOnly // NOI18N
              + ", TextSection=" + TextSection // NOI18N
              + ", DataSection=" + DataSection // NOI18N
              + ", BSSSection=" + BSSSection // NOI18N
              + ", ReadOnlySection=" + ReadOnlySection // NOI18N
              + ", StaticCtorSection=" + StaticCtorSection // NOI18N
              + ", StaticDtorSection=" + StaticDtorSection // NOI18N
              + ", LSDASection=" + LSDASection // NOI18N
              + ", CompactUnwindSection=" + CompactUnwindSection // NOI18N
              + ", DwarfAbbrevSection=" + DwarfAbbrevSection // NOI18N
              + ", DwarfInfoSection=" + DwarfInfoSection // NOI18N
              + ", DwarfLineSection=" + DwarfLineSection // NOI18N
              + ", DwarfFrameSection=" + DwarfFrameSection // NOI18N
              + ", DwarfPubTypesSection=" + DwarfPubTypesSection // NOI18N
              + ", DwarfDebugInlineSection=" + DwarfDebugInlineSection // NOI18N
              + ", DwarfStrSection=" + DwarfStrSection // NOI18N
              + ", DwarfLocSection=" + DwarfLocSection // NOI18N
              + ", DwarfARangesSection=" + DwarfARangesSection // NOI18N
              + ", DwarfRangesSection=" + DwarfRangesSection // NOI18N
              + ", DwarfMacinfoSection=" + DwarfMacinfoSection // NOI18N
              + ", DwarfPubNamesSection=" + DwarfPubNamesSection // NOI18N
              + ", DwarfAccelNamesSection=" + DwarfAccelNamesSection // NOI18N
              + ", DwarfAccelObjCSection=" + DwarfAccelObjCSection // NOI18N
              + ", DwarfAccelNamespaceSection=" + DwarfAccelNamespaceSection // NOI18N
              + ", DwarfAccelTypesSection=" + DwarfAccelTypesSection // NOI18N
              + ", DwarfInfoDWOSection=" + DwarfInfoDWOSection // NOI18N
              + ", DwarfTypesDWOSection=" + DwarfTypesDWOSection // NOI18N
              + ", DwarfAbbrevDWOSection=" + DwarfAbbrevDWOSection // NOI18N
              + ", DwarfStrDWOSection=" + DwarfStrDWOSection // NOI18N
              + ", DwarfLineDWOSection=" + DwarfLineDWOSection // NOI18N
              + ", DwarfLocDWOSection=" + DwarfLocDWOSection // NOI18N
              + ", DwarfStrOffDWOSection=" + DwarfStrOffDWOSection // NOI18N
              + ", DwarfAddrSection=" + DwarfAddrSection // NOI18N
              + ", DwarfCUIndexSection=" + DwarfCUIndexSection // NOI18N
              + ", DwarfTUIndexSection=" + DwarfTUIndexSection // NOI18N
              + ", DwarfGnuPubNamesSection=" + DwarfGnuPubNamesSection // NOI18N
              + ", DwarfGnuPubTypesSection=" + DwarfGnuPubTypesSection // NOI18N
              + ", COFFDebugSymbolsSection=" + COFFDebugSymbolsSection // NOI18N
              + ", COFFDebugTypesSection=" + COFFDebugTypesSection // NOI18N
              + ", TLSExtraDataSection=" + TLSExtraDataSection // NOI18N
              + ", TLSDataSection=" + TLSDataSection // NOI18N
              + ", TLSBSSSection=" + TLSBSSSection // NOI18N
              + ", StackMapSection=" + StackMapSection // NOI18N
              + ", FaultMapSection=" + FaultMapSection // NOI18N
              + ", EHFrameSection=" + EHFrameSection // NOI18N
              + ", DataRelROSection=" + DataRelROSection // NOI18N
              + ", MergeableConst4Section=" + MergeableConst4Section // NOI18N
              + ", MergeableConst8Section=" + MergeableConst8Section // NOI18N
              + ", MergeableConst16Section=" + MergeableConst16Section // NOI18N
              + ", MergeableConst32Section=" + MergeableConst32Section // NOI18N
              + ", TLSTLVSection=" + TLSTLVSection // NOI18N
              + ", TLSThreadInitSection=" + TLSThreadInitSection // NOI18N
              + ", CStringSection=" + CStringSection // NOI18N
              + ", UStringSection=" + UStringSection // NOI18N
              + ", TextCoalSection=" + TextCoalSection // NOI18N
              + ", ConstTextCoalSection=" + ConstTextCoalSection // NOI18N
              + ", ConstDataSection=" + ConstDataSection // NOI18N
              + ", DataCoalSection=" + DataCoalSection // NOI18N
              + ", DataCommonSection=" + DataCommonSection // NOI18N
              + ", DataBSSSection=" + DataBSSSection // NOI18N
              + ", FourByteConstantSection=" + FourByteConstantSection // NOI18N
              + ", EightByteConstantSection=" + EightByteConstantSection // NOI18N
              + ", SixteenByteConstantSection=" + SixteenByteConstantSection // NOI18N
              + ", LazySymbolPointerSection=" + LazySymbolPointerSection // NOI18N
              + ", NonLazySymbolPointerSection=" + NonLazySymbolPointerSection // NOI18N
              + ", ThreadLocalPointerSection=" + ThreadLocalPointerSection // NOI18N
              + ", DrectveSection=" + DrectveSection // NOI18N
              + ", PDataSection=" + PDataSection // NOI18N
              + ", XDataSection=" + XDataSection // NOI18N
              + ", SXDataSection=" + SXDataSection // NOI18N
              + ", Env=" + Env // NOI18N
              + ", PositionIndependent=" + PositionIndependent // NOI18N
              + ", CMModel=" + CMModel // NOI18N
              + ", Ctx=" + "[MCContext]" // NOI18N
              + ", TT=" + TT; // NOI18N
  }
}
