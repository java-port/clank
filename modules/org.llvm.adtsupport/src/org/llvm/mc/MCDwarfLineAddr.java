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
import static org.clank.java.io.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.mc.impl.MCDwarfStatics;
import static org.llvm.support.AdtsupportLlvmGlobals.encodeSLEB128;
import static org.llvm.support.AdtsupportLlvmGlobals.encodeULEB128;
import org.llvm.support.dwarf.LineNumberExtendedOps;
import org.llvm.support.dwarf.LineNumberOps;

//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 275,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 277,
 FQN="llvm::MCDwarfLineAddr", NM="_ZN4llvm15MCDwarfLineAddrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm15MCDwarfLineAddrE")
//</editor-fold>
public class MCDwarfLineAddr {
/*public:*/
  /// Utility function to encode a Dwarf pair of LineDelta and AddrDeltas.
  
  /// Utility function to encode a Dwarf pair of LineDelta and AddrDeltas.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddr::Encode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 422,
   FQN="llvm::MCDwarfLineAddr::Encode", NM="_ZN4llvm15MCDwarfLineAddr6EncodeERNS_9MCContextENS_22MCDwarfLineTableParamsExyRNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm15MCDwarfLineAddr6EncodeERNS_9MCContextENS_22MCDwarfLineTableParamsExyRNS_11raw_ostreamE")
  //</editor-fold>
  public static void Encode(final MCContext /*&*/ Context, MCDwarfLineTableParams Params, 
        long/*int64_t*/ LineDelta, long/*uint64_t*/ AddrDelta, 
        final raw_ostream /*&*/ OS) {
    long/*uint64_t*/ Temp;
    long/*uint64_t*/ Opcode;
    boolean NeedCopy = false;
    
    // The maximum address skip amount that can be encoded with a special op.
    long/*uint64_t*/ MaxSpecialAddrDelta = MCDwarfStatics.SpecialAddr(new MCDwarfLineTableParams(Params), $int2ulong(255));
    
    // Scale the address delta by the minimum instruction length.
    AddrDelta = MCDwarfStatics.ScaleAddrDelta(Context, AddrDelta);
    
    // A LineDelta of INT64_MAX is a signal that this is actually a
    // DW_LNE_end_sequence. We cannot use special opcodes here, since we want the
    // end_sequence to emit the matrix entry.
    if (LineDelta == INT64_MAX) {
      if (AddrDelta == MaxSpecialAddrDelta) {
        OS.$out_char(((/*char*/byte)($uint2char(LineNumberOps.DW_LNS_const_add_pc))));
      } else if ((AddrDelta != 0)) {
        OS.$out_char(((/*char*/byte)($uint2char(LineNumberOps.DW_LNS_advance_pc))));
        encodeULEB128(AddrDelta, OS);
      }
      OS.$out_char(((/*char*/byte)($uint2char(LineNumberOps.DW_LNS_extended_op))));
      OS.$out_char(((/*char*/byte)(1)));
      OS.$out_char(((/*char*/byte)($uint2char(LineNumberExtendedOps.DW_LNE_end_sequence))));
      return;
    }
    
    // Bias the line delta by the base.
    Temp = LineDelta - Params.DWARF2LineBase;
    
    // If the line increment is out of range of a special opcode, we must encode
    // it with DW_LNS_advance_line.
    if (Unsigned.$greatereq_ulong_uchar(Temp, Params.DWARF2LineRange)
       || $greater_ullong(Temp + $uchar2ullong(Params.DWARF2LineOpcodeBase), $int2ullong(255))) {
      OS.$out_char(((/*char*/byte)($uint2char(LineNumberOps.DW_LNS_advance_line))));
      encodeSLEB128(LineDelta, OS);
      
      LineDelta = 0;
      Temp = $int2ulong(0 - Params.DWARF2LineBase);
      NeedCopy = true;
    }
    
    // Use DW_LNS_copy instead of a "line +0, addr +0" special opcode.
    if (LineDelta == 0 && AddrDelta == $int2ullong(0)) {
      OS.$out_char(((/*char*/byte)($uint2char(LineNumberOps.DW_LNS_copy))));
      return;
    }
    
    // Bias the opcode by the special opcode base.
    Temp += $uchar2ullong(Params.DWARF2LineOpcodeBase);
    
    // Avoid overflow when addr_delta is large.
    if ($less_ulong_ullong(AddrDelta, $int2ullong(256) + MaxSpecialAddrDelta)) {
      // Try using a special opcode.
      Opcode = Temp + AddrDelta * $uchar2ullong(Params.DWARF2LineRange);
      if ($lesseq_ulong_ullong(Opcode, $int2ullong(255))) {
        OS.$out_char(((/*char*/byte)($ulong2char(Opcode))));
        return;
      }
      
      // Try using DW_LNS_const_add_pc followed by special op.
      Opcode = Temp + (AddrDelta - MaxSpecialAddrDelta) * $uchar2ullong(Params.DWARF2LineRange);
      if ($lesseq_ulong_ullong(Opcode, $int2ullong(255))) {
        OS.$out_char(((/*char*/byte)($uint2char(LineNumberOps.DW_LNS_const_add_pc))));
        OS.$out_char(((/*char*/byte)($ulong2char(Opcode))));
        return;
      }
    }
    
    // Otherwise use DW_LNS_advance_pc.
    OS.$out_char(((/*char*/byte)($uint2char(LineNumberOps.DW_LNS_advance_pc))));
    encodeULEB128(AddrDelta, OS);
    if (NeedCopy) {
      OS.$out_char(((/*char*/byte)($uint2char(LineNumberOps.DW_LNS_copy))));
    } else {
      assert ($lesseq_ulong_ullong(Temp, $int2ullong(255))) : "Buggy special opcode encoding.";
      OS.$out_char(((/*char*/byte)($ulong2char(Temp))));
    }
  }

  
  /// Utility function to emit the encoding to a streamer.
  
  /// Utility function to emit the encoding to a streamer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddr::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 406,
   FQN="llvm::MCDwarfLineAddr::Emit", NM="_ZN4llvm15MCDwarfLineAddr4EmitEPNS_10MCStreamerENS_22MCDwarfLineTableParamsExy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm15MCDwarfLineAddr4EmitEPNS_10MCStreamerENS_22MCDwarfLineTableParamsExy")
  //</editor-fold>
  public static void Emit(MCStreamer /*P*/ MCOS, MCDwarfLineTableParams Params, 
      long/*int64_t*/ LineDelta, long/*uint64_t*/ AddrDelta) {
    raw_svector_ostream OS = null;
    try {
      final MCContext /*&*/ Context = MCOS.getContext();
      SmallString/*256*/ Tmp/*J*/= new SmallString/*256*/(256);
      OS/*J*/= new raw_svector_ostream(Tmp);
      MCDwarfLineAddr.Encode(Context, new MCDwarfLineTableParams(Params), LineDelta, AddrDelta, OS);
      MCOS.EmitBytes(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
