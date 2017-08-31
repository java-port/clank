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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.mc.*;
import org.llvm.support.dwarf.LineNumberExtendedOps;
import org.llvm.support.dwarf.LineNumberOps;


//<editor-fold defaultstate="collapsed" desc="static type MCObjectStreamerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCObjectStreamerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZL15buildSymbolDiffRN4llvm16MCObjectStreamerEPKNS_8MCSymbolES4_;_ZL20emitDwarfSetLineAddrRN4llvm16MCObjectStreamerENS_22MCDwarfLineTableParamsExPKNS_8MCSymbolEi;_ZL25BundlingNotImplementedMsg; -static-type=MCObjectStreamerStatics -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCObjectStreamerStatics {

//<editor-fold defaultstate="collapsed" desc="BundlingNotImplementedMsg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 284,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 281,
 FQN="BundlingNotImplementedMsg", NM="_ZL25BundlingNotImplementedMsg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZL25BundlingNotImplementedMsg")
//</editor-fold>
public static /*const*/char$ptr/*char P*//*const*/ BundlingNotImplementedMsg = $("Aligned bundling is not implemented for this object format");
//<editor-fold defaultstate="collapsed" desc="buildSymbolDiff">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 313,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 310,
 FQN="buildSymbolDiff", NM="_ZL15buildSymbolDiffRN4llvm16MCObjectStreamerEPKNS_8MCSymbolES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZL15buildSymbolDiffRN4llvm16MCObjectStreamerEPKNS_8MCSymbolES4_")
//</editor-fold>
public static /*const*/ MCExpr /*P*/ buildSymbolDiff(final MCObjectStreamer /*&*/ OS, /*const*/ MCSymbol /*P*/ A, 
               /*const*/ MCSymbol /*P*/ B) {
  final MCContext /*&*/ Context = OS.getContext();
  MCSymbolRefExpr.VariantKind Variant = MCSymbolRefExpr.VariantKind.VK_None;
  /*const*/ MCExpr /*P*/ ARef = MCSymbolRefExpr.create(A, Variant, Context);
  /*const*/ MCExpr /*P*/ BRef = MCSymbolRefExpr.create(B, Variant, Context);
  /*const*/ MCExpr /*P*/ AddrDelta = MCBinaryExpr.create(MCBinaryExpr.Opcode.Sub, ARef, BRef, Context);
  return AddrDelta;
}

//<editor-fold defaultstate="collapsed" desc="emitDwarfSetLineAddr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 324,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 321,
 FQN="emitDwarfSetLineAddr", NM="_ZL20emitDwarfSetLineAddrRN4llvm16MCObjectStreamerENS_22MCDwarfLineTableParamsExPKNS_8MCSymbolEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZL20emitDwarfSetLineAddrRN4llvm16MCObjectStreamerENS_22MCDwarfLineTableParamsExPKNS_8MCSymbolEi")
//</editor-fold>
public static void emitDwarfSetLineAddr(final MCObjectStreamer /*&*/ OS, 
                    MCDwarfLineTableParams Params, 
                    long/*int64_t*/ LineDelta, /*const*/ MCSymbol /*P*/ Label, 
                    int PointerSize) {
  // emit the sequence to set the address
  OS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_extended_op), 1);
  OS.EmitULEB128IntValue($int2ulong(PointerSize + 1));
  OS.EmitIntValue($uint2ulong(LineNumberExtendedOps.DW_LNE_set_address), 1);
  OS.EmitSymbolValue(Label, PointerSize);
  
  // emit the sequence for the LineDelta (from 1) and a zero address delta.
  MCDwarfLineAddr.Emit($AddrOf(OS), new MCDwarfLineTableParams(Params), LineDelta, $int2ulong(0));
}

} // END OF class MCObjectStreamerStatics
