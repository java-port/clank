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
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.create_type$ref;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.mc.impl.CIEKey;
import org.llvm.mc.impl.DenseMapInfoCIEKey;
import org.llvm.mc.impl.FrameEmitterImpl;
import org.llvm.mc.impl.MCDwarfStatics;
import org.llvm.support.dwarf.CallFrameInfo;
import org.llvm.support.endian.Writer;

//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameEmitter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 509,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 511,
 FQN="llvm::MCDwarfFrameEmitter", NM="_ZN4llvm19MCDwarfFrameEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm19MCDwarfFrameEmitterE")
//</editor-fold>
public class MCDwarfFrameEmitter {
/*public:*/
  //
  // This emits the frame info section.
  //
  // namespace llvm
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameEmitter::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1486,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1484,
   FQN="llvm::MCDwarfFrameEmitter::Emit", NM="_ZN4llvm19MCDwarfFrameEmitter4EmitERNS_16MCObjectStreamerEPNS_12MCAsmBackendEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm19MCDwarfFrameEmitter4EmitERNS_16MCObjectStreamerEPNS_12MCAsmBackendEb")
  //</editor-fold>
  public static void Emit(final MCObjectStreamer /*&*/ Streamer, MCAsmBackend /*P*/ MAB, 
      boolean IsEH) {
    Streamer.generateCompactUnwindEncodings(MAB);
    
    final MCContext /*&*/ Context = Streamer.getContext();
    /*const*/ MCObjectFileInfo /*P*/ MOFI = Context.getObjectFileInfo();
    FrameEmitterImpl Emitter/*J*/= new FrameEmitterImpl(IsEH, Streamer);
    ArrayRef<MCDwarfFrameInfo> FrameArray = Streamer.getDwarfFrameInfos();
    
    // Emit the compact unwind info if available.
    boolean NeedsEHFrameSection = !MOFI.getSupportsCompactUnwindWithoutEHFrame();
    if (IsEH && (MOFI.getCompactUnwindSection() != null)) {
      boolean SectionEmitted = false;
      for (final /*const*/ MCDwarfFrameInfo /*&*/ Frame : FrameArray) {
        if (Frame.CompactUnwindEncoding == 0) {
          continue;
        }
        if (!SectionEmitted) {
          Streamer.SwitchSection(MOFI.getCompactUnwindSection());
          Streamer.EmitValueToAlignment(Context.getAsmInfo().getPointerSize());
          SectionEmitted = true;
        }
        NeedsEHFrameSection |= Frame.CompactUnwindEncoding
           == MOFI.getCompactUnwindDwarfEHFrameOnly();
        Emitter.EmitCompactUnwind(Frame);
      }
    }
    if (!NeedsEHFrameSection) {
      return;
    }
    
    final MCSection /*&*/ Section = IsEH ? $Deref(((/*const_cast*/MCObjectFileInfo /*P*/ )(MOFI)).getEHFrameSection()) : $Deref(MOFI.getDwarfFrameSection());
    
    Streamer.SwitchSection($AddrOf(Section));
    MCSymbol /*P*/ SectionStart = Context.createTempSymbol();
    Streamer.EmitLabel(SectionStart);
    
    DenseMap<CIEKey, /*const*/ MCSymbol /*P*/ > CIEStarts/*J*/= new DenseMap<CIEKey, /*const*/ MCSymbol /*P*/ >(DenseMapInfoCIEKey.$Info(), (/*const*/ MCSymbol /*P*/ )null);
    
    /*const*/ MCSymbol /*P*/ DummyDebugKey = null;
    boolean CanOmitDwarf = MOFI.getOmitDwarfIfHaveCompactUnwind();
    for (type$ptr</*const*/ MCDwarfFrameInfo /*P*/ > I = $tryClone(FrameArray.begin()), /*P*/ E = $tryClone(FrameArray.end()); $noteq_ptr(I, E);) {
      final /*const*/ MCDwarfFrameInfo /*&*/ Frame = I.$star();
      I.$preInc();
      if (CanOmitDwarf && Frame.CompactUnwindEncoding
         != MOFI.getCompactUnwindDwarfEHFrameOnly()) {
        // Don't generate an EH frame if we don't need one. I.e., it's taken care
        // of by the compact unwind encoding.
        continue;
      }
      
      CIEKey Key/*J*/= new CIEKey(Frame.Personality, Frame.PersonalityEncoding, 
          Frame.LsdaEncoding, Frame.IsSignalFrame, Frame.IsSimple);
      final type$ref</*const*/ MCSymbol /*P*/ /*&*/> CIEStart = IsEH ? CIEStarts.ref$at_T1$C$R(Key) : create_type$ref(DummyDebugKey);
      if (!(CIEStart.$deref() != null)) {
        CIEStart.$set($AddrOf(Emitter.EmitCIE(Frame.Personality, Frame.PersonalityEncoding, 
            Frame.Lsda, Frame.IsSignalFrame, 
            Frame.LsdaEncoding, Frame.IsSimple)));
      }
      
      Emitter.EmitFDE($Deref(CIEStart.$deref()), Frame, $eq_ptr(I, E), $Deref(SectionStart));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameEmitter::EmitAdvanceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1548,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1547,
   FQN="llvm::MCDwarfFrameEmitter::EmitAdvanceLoc", NM="_ZN4llvm19MCDwarfFrameEmitter14EmitAdvanceLocERNS_16MCObjectStreamerEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm19MCDwarfFrameEmitter14EmitAdvanceLocERNS_16MCObjectStreamerEy")
  //</editor-fold>
  public static void EmitAdvanceLoc(final MCObjectStreamer /*&*/ Streamer, 
                long/*uint64_t*/ AddrDelta) {
    raw_svector_ostream OS = null;
    try {
      final MCContext /*&*/ Context = Streamer.getContext();
      SmallString/*256*/ Tmp/*J*/= new SmallString/*256*/(256);
      OS/*J*/= new raw_svector_ostream(Tmp);
      MCDwarfFrameEmitter.EncodeAdvanceLoc(Context, AddrDelta, OS);
      Streamer.EmitBytes(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameEmitter::EncodeAdvanceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1557,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1556,
   FQN="llvm::MCDwarfFrameEmitter::EncodeAdvanceLoc", NM="_ZN4llvm19MCDwarfFrameEmitter16EncodeAdvanceLocERNS_9MCContextEyRNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm19MCDwarfFrameEmitter16EncodeAdvanceLocERNS_9MCContextEyRNS_11raw_ostreamE")
  //</editor-fold>
  public static void EncodeAdvanceLoc(final MCContext /*&*/ Context, 
                  long/*uint64_t*/ AddrDelta, 
                  final raw_ostream /*&*/ OS) {
    // Scale the address delta by the minimum instruction length.
    AddrDelta = MCDwarfStatics.ScaleAddrDelta(Context, AddrDelta);
    if (AddrDelta == $int2ullong(0)) {
    } else if (isUIntN(6, AddrDelta)) {
      byte/*uint8_t*/ Opcode = $ullong2uchar($uint2ullong(CallFrameInfo.DW_CFA_advance_loc) | AddrDelta);
      OS.$out_uchar(Opcode);
    } else if (isUInt8(AddrDelta)) {
      OS.$out_uchar(((byte/*uint8_t*/)($uint2uchar(CallFrameInfo.DW_CFA_advance_loc1))));
      OS.$out_uchar(((byte/*uint8_t*/)($ulong2uchar(AddrDelta))));
    } else if (isUInt16(AddrDelta)) {
      OS.$out_uchar(((byte/*uint8_t*/)($uint2uchar(CallFrameInfo.DW_CFA_advance_loc2))));
      if (Context.getAsmInfo().isLittleEndian()) {
        new Writer(support.endianness.little, OS).write_uint16($ulong2ushort(AddrDelta));
      } else {
        new Writer(support.endianness.big, OS).write($ulong2ushort(AddrDelta));
      }
    } else {
      assert (isUInt32(AddrDelta));
      OS.$out_uchar(((byte/*uint8_t*/)($uint2uchar(CallFrameInfo.DW_CFA_advance_loc4))));
      if (Context.getAsmInfo().isLittleEndian()) {
        new Writer(support.endianness.little, OS).write_uint32($ulong2uint(AddrDelta));
      } else {
        new Writer(support.endianness.big, OS).write($ulong2uint(AddrDelta));
      }
    }
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
