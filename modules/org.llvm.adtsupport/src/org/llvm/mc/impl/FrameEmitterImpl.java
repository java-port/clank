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

package org.llvm.mc.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.mc.*;
import org.llvm.support.dwarf.CallFrameInfo;
import org.llvm.support.dwarf.Constants;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FrameEmitterImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1005,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1002,
 FQN="(anonymous namespace)::FrameEmitterImpl", NM="_ZN12_GLOBAL__N_116FrameEmitterImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_116FrameEmitterImplE")
//</editor-fold>
public class FrameEmitterImpl {
  private int CFAOffset/* = 0*/;
  private int InitialCFAOffset/* = 0*/;
  private boolean IsEH;
  private final MCObjectStreamer /*&*/ Streamer;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FrameEmitterImpl::FrameEmitterImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1012,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1009,
   FQN="(anonymous namespace)::FrameEmitterImpl::FrameEmitterImpl", NM="_ZN12_GLOBAL__N_116FrameEmitterImplC1EbRN4llvm16MCObjectStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_116FrameEmitterImplC1EbRN4llvm16MCObjectStreamerE")
  //</editor-fold>
  public FrameEmitterImpl(boolean IsEH, final MCObjectStreamer /*&*/ Streamer) {
    // : CFAOffset(0), InitialCFAOffset(0), IsEH(IsEH), Streamer(Streamer) 
    //START JInit
    /*InClass*/this.CFAOffset = 0;
    /*InClass*/this.InitialCFAOffset = 0;
    this.IsEH = IsEH;
    this./*&*/Streamer=/*&*/Streamer;
    //END JInit
  }

  
  /// Emit the unwind information in a compact way.
  
  /// Emit the unwind information in a compact way.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FrameEmitterImpl::EmitCompactUnwind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1181,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1179,
   FQN="(anonymous namespace)::FrameEmitterImpl::EmitCompactUnwind", NM="_ZN12_GLOBAL__N_116FrameEmitterImpl17EmitCompactUnwindERKN4llvm16MCDwarfFrameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_116FrameEmitterImpl17EmitCompactUnwindERKN4llvm16MCDwarfFrameInfoE")
  //</editor-fold>
  public void EmitCompactUnwind(final /*const*/ MCDwarfFrameInfo /*&*/ Frame) {
    final MCContext /*&*/ Context = Streamer.getContext();
    /*const*/ MCObjectFileInfo /*P*/ MOFI = Context.getObjectFileInfo();
    
    // range-start range-length  compact-unwind-enc personality-func   lsda
    //  _foo       LfooEnd-_foo  0x00000023          0                 0
    //  _bar       LbarEnd-_bar  0x00000025         __gxx_personality  except_tab1
    //
    //   .section __LD,__compact_unwind,regular,debug
    //
    //   # compact unwind for _foo
    //   .quad _foo
    //   .set L1,LfooEnd-_foo
    //   .long L1
    //   .long 0x01010001
    //   .quad 0
    //   .quad 0
    //
    //   # compact unwind for _bar
    //   .quad _bar
    //   .set L2,LbarEnd-_bar
    //   .long L2
    //   .long 0x01020011
    //   .quad __gxx_personality
    //   .quad except_tab1
    /*uint32_t*/int Encoding = Frame.CompactUnwindEncoding;
    if (!(Encoding != 0)) {
      return;
    }
    boolean DwarfEHFrameOnly = (Encoding == MOFI.getCompactUnwindDwarfEHFrameOnly());
    
    // The encoding needs to know we have an LSDA.
    if (!DwarfEHFrameOnly && (Frame.Lsda != null)) {
      Encoding |= 0x40000000;
    }
    
    // Range Start
    /*uint*/int FDEEncoding = MOFI.getFDEEncoding();
    /*uint*/int Size = MCDwarfStatics.getSizeForEncoding(Streamer, FDEEncoding);
    Streamer.EmitSymbolValue(Frame.Begin, Size);
    
    // Range Length
    /*const*/ MCExpr /*P*/ Range = MCDwarfStatics.MakeStartMinusEndExpr(Streamer, $Deref(Frame.Begin), 
        $Deref(Frame.End), 0);
    MCDwarfStatics.emitAbsValue(Streamer, Range, 4);
    
    // Compact Encoding
    Size = MCDwarfStatics.getSizeForEncoding(Streamer, Constants.DW_EH_PE_udata4);
    Streamer.EmitIntValue($uint2ulong(Encoding), Size);
    
    // Personality Function
    Size = MCDwarfStatics.getSizeForEncoding(Streamer, Constants.DW_EH_PE_absptr);
    if (!DwarfEHFrameOnly && (Frame.Personality != null)) {
      Streamer.EmitSymbolValue(Frame.Personality, Size);
    } else {
      Streamer.EmitIntValue($int2ulong(0), Size); // No personality fn
    }
    
    // LSDA
    Size = MCDwarfStatics.getSizeForEncoding(Streamer, Frame.LsdaEncoding);
    if (!DwarfEHFrameOnly && (Frame.Lsda != null)) {
      Streamer.EmitSymbolValue(Frame.Lsda, Size);
    } else {
      Streamer.EmitIntValue($int2ulong(0), Size); // No LSDA
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FrameEmitterImpl::EmitCIE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1259,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1257,
   FQN="(anonymous namespace)::FrameEmitterImpl::EmitCIE", NM="_ZN12_GLOBAL__N_116FrameEmitterImpl7EmitCIEEPKN4llvm8MCSymbolEjS4_bjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_116FrameEmitterImpl7EmitCIEEPKN4llvm8MCSymbolEjS4_bjb")
  //</editor-fold>
  public /*const*/ MCSymbol /*&*/ EmitCIE(/*const*/ MCSymbol /*P*/ personality, 
         /*uint*/int personalityEncoding, 
         /*const*/ MCSymbol /*P*/ lsda, 
         boolean IsSignalFrame, 
         /*uint*/int lsdaEncoding, 
         boolean IsSimple) {
    final MCContext /*&*/ context = Streamer.getContext();
    /*const*/ MCRegisterInfo /*P*/ MRI = context.getRegisterInfo();
    /*const*/ MCObjectFileInfo /*P*/ MOFI = context.getObjectFileInfo();
    
    MCSymbol /*P*/ sectionStart = context.createTempSymbol();
    Streamer.EmitLabel(sectionStart);
    
    MCSymbol /*P*/ sectionEnd = context.createTempSymbol();
    
    // Length
    /*const*/ MCExpr /*P*/ Length = MCDwarfStatics.MakeStartMinusEndExpr(Streamer, $Deref(sectionStart), $Deref(sectionEnd), 4);
    MCDwarfStatics.emitAbsValue(Streamer, Length, 4);
    
    // CIE ID
    /*uint*/int CIE_ID = IsEH ? 0 : -1;
    Streamer.EmitIntValue($uint2ulong(CIE_ID), 4);
    
    // Version
    byte/*uint8_t*/ CIEVersion = $uint2uchar(MCDwarfStatics.getCIEVersion(IsEH, $ushort2uint(context.getDwarfVersion())));
    Streamer.EmitIntValue($uchar2ulong(CIEVersion), 1);
    
    // Augmentation String
    SmallString/*8*/ Augmentation/*J*/= new SmallString/*8*/(8);
    if (IsEH) {
      Augmentation.$addassign(/*STRINGREF_STR*/"z");
      if ((personality != null)) {
        Augmentation.$addassign(/*STRINGREF_STR*/"P");
      }
      if ((lsda != null)) {
        Augmentation.$addassign(/*STRINGREF_STR*/"L");
      }
      Augmentation.$addassign(/*STRINGREF_STR*/"R");
      if (IsSignalFrame) {
        Augmentation.$addassign(/*STRINGREF_STR*/"S");
      }
      Streamer.EmitBytes(Augmentation.$StringRef());
    }
    Streamer.EmitIntValue($int2ulong(0), 1);
    if ($uchar2int(CIEVersion) >= 4) {
      // Address Size
      Streamer.EmitIntValue($uint2ulong(context.getAsmInfo().getPointerSize()), 1);
      
      // Segment Descriptor Size
      Streamer.EmitIntValue($int2ulong(0), 1);
    }
    
    // Code Alignment Factor
    Streamer.EmitULEB128IntValue($uint2ulong(context.getAsmInfo().getMinInstAlignment()));
    
    // Data Alignment Factor
    Streamer.EmitSLEB128IntValue(MCDwarfStatics.getDataAlignmentFactor(Streamer));
    
    // Return Address Register
    if ($uchar2int(CIEVersion) == 1) {
      assert ($lesseq_uint(MRI.getRARegister(), 255)) : "DWARF 2 encodes return_address_register in one byte";
      Streamer.EmitIntValue($int2ulong(MRI.getDwarfRegNum(MRI.getRARegister(), IsEH)), 1);
    } else {
      Streamer.EmitULEB128IntValue($int2ulong(MRI.getDwarfRegNum(MRI.getRARegister(), IsEH)));
    }
    
    // Augmentation Data Length (optional)
    /*uint*/int augmentationLength = 0;
    if (IsEH) {
      if ((personality != null)) {
        // Personality Encoding
        augmentationLength += 1;
        // Personality
        augmentationLength += MCDwarfStatics.getSizeForEncoding(Streamer, personalityEncoding);
      }
      if ((lsda != null)) {
        augmentationLength += 1;
      }
      // Encoding of the FDE pointers
      augmentationLength += 1;
      
      Streamer.EmitULEB128IntValue($uint2ulong(augmentationLength));
      
      // Augmentation Data (optional)
      if ((personality != null)) {
        // Personality Encoding
        MCDwarfStatics.emitEncodingByte(Streamer, personalityEncoding);
        // Personality
        MCDwarfStatics.EmitPersonality(Streamer, $Deref(personality), personalityEncoding);
      }
      if ((lsda != null)) {
        MCDwarfStatics.emitEncodingByte(Streamer, lsdaEncoding);
      }
      
      // Encoding of the FDE pointers
      MCDwarfStatics.emitEncodingByte(Streamer, MOFI.getFDEEncoding());
    }
    
    // Initial Instructions
    /*const*/ MCAsmInfo /*P*/ MAI = context.getAsmInfo();
    if (!IsSimple) {
      final /*const*/std.vector<MCCFIInstruction> /*&*/ Instructions = MAI.getInitialFrameState();
      EmitCFIInstructions(new ArrayRef<MCCFIInstruction>(Instructions, false), (MCSymbol /*P*/ )null);
    }
    
    InitialCFAOffset = CFAOffset;
    
    // Padding
    Streamer.EmitValueToAlignment(IsEH ? 4 : MAI.getPointerSize());
    
    Streamer.EmitLabel(sectionEnd);
    return $Deref(sectionStart);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FrameEmitterImpl::EmitFDE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1376,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1374,
   FQN="(anonymous namespace)::FrameEmitterImpl::EmitFDE", NM="_ZN12_GLOBAL__N_116FrameEmitterImpl7EmitFDEERKN4llvm8MCSymbolERKNS1_16MCDwarfFrameInfoEbS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_116FrameEmitterImpl7EmitFDEERKN4llvm8MCSymbolERKNS1_16MCDwarfFrameInfoEbS4_")
  //</editor-fold>
  public void EmitFDE(final /*const*/ MCSymbol /*&*/ cieStart, 
         final /*const*/ MCDwarfFrameInfo /*&*/ frame, 
         boolean LastInSection, 
         final /*const*/ MCSymbol /*&*/ SectionStart) {
    final MCContext /*&*/ context = Streamer.getContext();
    MCSymbol /*P*/ fdeStart = context.createTempSymbol();
    MCSymbol /*P*/ fdeEnd = context.createTempSymbol();
    /*const*/ MCObjectFileInfo /*P*/ MOFI = context.getObjectFileInfo();
    
    CFAOffset = InitialCFAOffset;
    
    // Length
    /*const*/ MCExpr /*P*/ Length = MCDwarfStatics.MakeStartMinusEndExpr(Streamer, $Deref(fdeStart), $Deref(fdeEnd), 0);
    MCDwarfStatics.emitAbsValue(Streamer, Length, 4);
    
    Streamer.EmitLabel(fdeStart);
    
    // CIE Pointer
    /*const*/ MCAsmInfo /*P*/ asmInfo = context.getAsmInfo();
    if (IsEH) {
      /*const*/ MCExpr /*P*/ offset = MCDwarfStatics.MakeStartMinusEndExpr(Streamer, cieStart, $Deref(fdeStart), 0);
      MCDwarfStatics.emitAbsValue(Streamer, offset, 4);
    } else if (!asmInfo.doesDwarfUseRelocationsAcrossSections()) {
      /*const*/ MCExpr /*P*/ offset = MCDwarfStatics.MakeStartMinusEndExpr(Streamer, SectionStart, cieStart, 0);
      MCDwarfStatics.emitAbsValue(Streamer, offset, 4);
    } else {
      Streamer.EmitSymbolValue($AddrOf(cieStart), 4);
    }
    
    // PC Begin
    /*uint*/int PCEncoding = IsEH ? MOFI.getFDEEncoding() : (/*uint*/int)Constants.DW_EH_PE_absptr;
    /*uint*/int PCSize = MCDwarfStatics.getSizeForEncoding(Streamer, PCEncoding);
    MCDwarfStatics.emitFDESymbol(Streamer, $Deref(frame.Begin), PCEncoding, IsEH);
    
    // PC Range
    /*const*/ MCExpr /*P*/ Range = MCDwarfStatics.MakeStartMinusEndExpr(Streamer, $Deref(frame.Begin), $Deref(frame.End), 0);
    MCDwarfStatics.emitAbsValue(Streamer, Range, PCSize);
    if (IsEH) {
      // Augmentation Data Length
      /*uint*/int augmentationLength = 0;
      if ((frame.Lsda != null)) {
        augmentationLength += MCDwarfStatics.getSizeForEncoding(Streamer, frame.LsdaEncoding);
      }
      
      Streamer.EmitULEB128IntValue($uint2ulong(augmentationLength));
      
      // Augmentation Data
      if ((frame.Lsda != null)) {
        MCDwarfStatics.emitFDESymbol(Streamer, $Deref(frame.Lsda), frame.LsdaEncoding, true);
      }
    }
    
    // Call Frame Instructions
    EmitCFIInstructions(new ArrayRef<MCCFIInstruction>(frame.Instructions, false), frame.Begin);
    
    // Padding
    // The size of a .eh_frame section has to be a multiple of the alignment
    // since a null CIE is interpreted as the end. Old systems overaligned
    // .eh_frame, so we do too and account for it in the last FDE.
    /*uint*/int Align = LastInSection ? asmInfo.getPointerSize() : PCSize;
    Streamer.EmitValueToAlignment(Align);
    
    Streamer.EmitLabel(fdeEnd);
  }

  
  /// Emit frame instructions to describe the layout of the frame.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FrameEmitterImpl::EmitCFIInstructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1160,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1157,
   FQN="(anonymous namespace)::FrameEmitterImpl::EmitCFIInstructions", NM="_ZN12_GLOBAL__N_116FrameEmitterImpl19EmitCFIInstructionsEN4llvm8ArrayRefINS1_16MCCFIInstructionEEEPNS1_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_116FrameEmitterImpl19EmitCFIInstructionsEN4llvm8ArrayRefINS1_16MCCFIInstructionEEEPNS1_8MCSymbolE")
  //</editor-fold>
  public void EmitCFIInstructions(ArrayRef<MCCFIInstruction> Instrs, 
                     MCSymbol /*P*/ BaseLabel) {
    for (final /*const*/ MCCFIInstruction /*&*/ Instr : Instrs) {
      MCSymbol /*P*/ Label = Instr.getLabel();
      // Throw out move if the label is invalid.
      if ((Label != null) && !Label.isDefined()) {
        continue; // Not emitted, in dead code.
      }
      
      // Advance row if new location.
      if ((BaseLabel != null) && (Label != null)) {
        MCSymbol /*P*/ ThisSym = Label;
        if (ThisSym != BaseLabel) {
          Streamer.EmitDwarfAdvanceFrameAddr(BaseLabel, ThisSym);
          BaseLabel = ThisSym;
        }
      }
      
      EmitCFIInstruction(Instr);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FrameEmitterImpl::EmitCFIInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1035,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1032,
   FQN="(anonymous namespace)::FrameEmitterImpl::EmitCFIInstruction", NM="_ZN12_GLOBAL__N_116FrameEmitterImpl18EmitCFIInstructionERKN4llvm16MCCFIInstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_116FrameEmitterImpl18EmitCFIInstructionERKN4llvm16MCCFIInstructionE")
  //</editor-fold>
  public void EmitCFIInstruction(final /*const*/ MCCFIInstruction /*&*/ Instr) {
    int dataAlignmentFactor = MCDwarfStatics.getDataAlignmentFactor(Streamer);
    /*const*/ MCRegisterInfo /*P*/ MRI = Streamer.getContext().getRegisterInfo();
    switch (Instr.getOperation()) {
     case OpRegister:
      {
        /*uint*/int Reg1 = Instr.getRegister();
        /*uint*/int Reg2 = Instr.getRegister2();
        if (!IsEH) {
          Reg1 = MRI.getDwarfRegNum(MRI.getLLVMRegNum(Reg1, true), false);
          Reg2 = MRI.getDwarfRegNum(MRI.getLLVMRegNum(Reg2, true), false);
        }
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_register), 1);
        Streamer.EmitULEB128IntValue($uint2ulong(Reg1));
        Streamer.EmitULEB128IntValue($uint2ulong(Reg2));
        return;
      }
     case OpWindowSave:
      {
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_GNU_window_save), 1);
        return;
      }
     case OpUndefined:
      {
        /*uint*/int Reg = Instr.getRegister();
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_undefined), 1);
        Streamer.EmitULEB128IntValue($uint2ulong(Reg));
        return;
      }
     case OpAdjustCfaOffset:
     case OpDefCfaOffset:
      {
        /*const*/boolean IsRelative = Instr.getOperation() == MCCFIInstruction.OpType.OpAdjustCfaOffset;
        
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_def_cfa_offset), 1);
        if (IsRelative) {
          CFAOffset += Instr.getOffset();
        } else {
          CFAOffset = -Instr.getOffset();
        }
        
        Streamer.EmitULEB128IntValue($int2ulong(CFAOffset));
        
        return;
      }
     case OpDefCfa:
      {
        /*uint*/int Reg = Instr.getRegister();
        if (!IsEH) {
          Reg = MRI.getDwarfRegNum(MRI.getLLVMRegNum(Reg, true), false);
        }
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_def_cfa), 1);
        Streamer.EmitULEB128IntValue($uint2ulong(Reg));
        CFAOffset = -Instr.getOffset();
        Streamer.EmitULEB128IntValue($int2ulong(CFAOffset));
        
        return;
      }
     case OpDefCfaRegister:
      {
        /*uint*/int Reg = Instr.getRegister();
        if (!IsEH) {
          Reg = MRI.getDwarfRegNum(MRI.getLLVMRegNum(Reg, true), false);
        }
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_def_cfa_register), 1);
        Streamer.EmitULEB128IntValue($uint2ulong(Reg));
        
        return;
      }
     case OpOffset:
     case OpRelOffset:
      {
        /*const*/boolean IsRelative = Instr.getOperation() == MCCFIInstruction.OpType.OpRelOffset;
        
        /*uint*/int Reg = Instr.getRegister();
        if (!IsEH) {
          Reg = MRI.getDwarfRegNum(MRI.getLLVMRegNum(Reg, true), false);
        }
        
        int Offset = Instr.getOffset();
        if (IsRelative) {
          Offset -= CFAOffset;
        }
        Offset = Offset / dataAlignmentFactor;
        if (Offset < 0) {
          Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_offset_extended_sf), 1);
          Streamer.EmitULEB128IntValue($uint2ulong(Reg));
          Streamer.EmitSLEB128IntValue(Offset);
        } else if ($less_uint(Reg, 64)) {
          Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_offset + Reg), 1);
          Streamer.EmitULEB128IntValue($int2ulong(Offset));
        } else {
          Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_offset_extended), 1);
          Streamer.EmitULEB128IntValue($uint2ulong(Reg));
          Streamer.EmitULEB128IntValue($int2ulong(Offset));
        }
        return;
      }
     case OpRememberState:
      Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_remember_state), 1);
      return;
     case OpRestoreState:
      Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_restore_state), 1);
      return;
     case OpSameValue:
      {
        /*uint*/int Reg = Instr.getRegister();
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_same_value), 1);
        Streamer.EmitULEB128IntValue($uint2ulong(Reg));
        return;
      }
     case OpRestore:
      {
        /*uint*/int Reg = Instr.getRegister();
        if (!IsEH) {
          Reg = MRI.getDwarfRegNum(MRI.getLLVMRegNum(Reg, true), false);
        }
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_restore | Reg), 1);
        return;
      }
     case OpGnuArgsSize:
      {
        Streamer.EmitIntValue($uint2ulong(CallFrameInfo.DW_CFA_GNU_args_size), 1);
        Streamer.EmitULEB128IntValue($int2ulong(Instr.getOffset()));
        return;
      }
     case OpEscape:
      Streamer.EmitBytes(Instr.getValues());
      return;
    }
    throw new llvm_unreachable("Unhandled case in switch");
  }

  
  @Override public String toString() {
    return "" + "CFAOffset=" + CFAOffset // NOI18N
              + ", InitialCFAOffset=" + InitialCFAOffset // NOI18N
              + ", IsEH=" + IsEH // NOI18N
              + ", Streamer=" + Streamer; // NOI18N
  }
}
