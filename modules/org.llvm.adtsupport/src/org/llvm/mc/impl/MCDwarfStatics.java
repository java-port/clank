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
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clank.java.stdimpl.aliases.*;
import org.llvm.support.sys.*;
import static org.llvm.adt.java.ADTRTTI.*;
import org.llvm.mc.*;
import static org.llvm.mc.MCDwarfLoc.*;
import org.llvm.support.dwarf.Attribute;
import org.llvm.support.dwarf.LineNumberExtendedOps;
import org.llvm.support.dwarf.LineNumberOps;
import org.llvm.support.dwarf.Constants;
import org.llvm.support.dwarf.Form;
import org.llvm.support.dwarf.SourceLanguage;
import org.llvm.support.dwarf.Tag;


//<editor-fold defaultstate="collapsed" desc="static type MCDwarfStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCDwarfStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL10EmitAbbrevPN4llvm10MCStreamerEyy;_ZL11SpecialAddrN4llvm22MCDwarfLineTableParamsEy;_ZL11forceExpAbsRN4llvm10MCStreamerEPKNS_6MCExprE;_ZL12emitAbsValueRN4llvm10MCStreamerEPKNS_6MCExprEj;_ZL13emitFDESymbolRN4llvm16MCObjectStreamerERKNS_8MCSymbolEjb;_ZL13getCIEVersionbj;_ZL14ScaleAddrDeltaRN4llvm9MCContextEy;_ZL15EmitPersonalityRN4llvm10MCStreamerERKNS_8MCSymbolEj;_ZL16EmitGenDwarfInfoPN4llvm10MCStreamerEPKNS_8MCSymbolES4_S4_;_ZL16emitEncodingByteRN4llvm16MCObjectStreamerEj;_ZL18EmitDwarfLineTablePN4llvm16MCObjectStreamerEPNS_9MCSectionERKSt6vectorINS_16MCDwarfLineEntryESaIS5_EE;_ZL18EmitGenDwarfAbbrevPN4llvm10MCStreamerE;_ZL18EmitGenDwarfRangesPN4llvm10MCStreamerE;_ZL18getSizeForEncodingRN4llvm10MCStreamerEj;_ZL19EmitGenDwarfArangesPN4llvm10MCStreamerEPKNS_8MCSymbolE;_ZL21MakeStartMinusEndExprRKN4llvm10MCStreamerERKNS_8MCSymbolES5_i;_ZL22getDataAlignmentFactorRN4llvm10MCStreamerE; -static-type=MCDwarfStatics -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCDwarfStatics {

//<editor-fold defaultstate="collapsed" desc="ScaleAddrDelta">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 34,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 33,
 FQN="ScaleAddrDelta", NM="_ZL14ScaleAddrDeltaRN4llvm9MCContextEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL14ScaleAddrDeltaRN4llvm9MCContextEy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ ScaleAddrDelta(final MCContext /*&*/ Context, long/*uint64_t*/ AddrDelta) {
  /*uint*/int MinInsnLength = Context.getAsmInfo().getMinInstAlignment();
  if (MinInsnLength == 1) {
    return AddrDelta;
  }
  if ($rem_ulong_uint(AddrDelta, MinInsnLength) != $int2ullong(0)) {
    // TODO: report this error, but really only once.
    ;
  }
  return $div_ulong_uint(AddrDelta, MinInsnLength);
}


//
// This helper routine returns an expression of End - Start + IntVal .
//
//<editor-fold defaultstate="collapsed" desc="MakeStartMinusEndExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 78,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 77,
 FQN="MakeStartMinusEndExpr", NM="_ZL21MakeStartMinusEndExprRKN4llvm10MCStreamerERKNS_8MCSymbolES5_i",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL21MakeStartMinusEndExprRKN4llvm10MCStreamerERKNS_8MCSymbolES5_i")
//</editor-fold>
public static /*inline*/ /*const*/ MCExpr /*P*/ MakeStartMinusEndExpr(final /*const*/ MCStreamer /*&*/ MCOS, 
                     final /*const*/ MCSymbol /*&*/ Start, 
                     final /*const*/ MCSymbol /*&*/ End, 
                     int IntVal) {
  MCSymbolRefExpr.VariantKind Variant = MCSymbolRefExpr.VariantKind.VK_None;
  /*const*/ MCExpr /*P*/ Res = MCSymbolRefExpr.create($AddrOf(End), Variant, MCOS.getContext());
  /*const*/ MCExpr /*P*/ RHS = MCSymbolRefExpr.create($AddrOf(Start), Variant, MCOS.getContext());
  /*const*/ MCExpr /*P*/ Res1 = MCBinaryExpr.create(MCBinaryExpr.Opcode.Sub, Res, RHS, MCOS.getContext());
  /*const*/ MCExpr /*P*/ Res2 = MCConstantExpr.create(IntVal, MCOS.getContext());
  /*const*/ MCExpr /*P*/ Res3 = MCBinaryExpr.create(MCBinaryExpr.Opcode.Sub, Res1, Res2, MCOS.getContext());
  return Res3;
}


//
// This emits the Dwarf line table for the specified section from the entries
// in the LineSection.
//
//<editor-fold defaultstate="collapsed" desc="EmitDwarfLineTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 100,
 FQN="EmitDwarfLineTable", NM="_ZL18EmitDwarfLineTablePN4llvm16MCObjectStreamerEPNS_9MCSectionERKSt6vectorINS_16MCDwarfLineEntryESaIS5_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL18EmitDwarfLineTablePN4llvm16MCObjectStreamerEPNS_9MCSectionERKSt6vectorINS_16MCDwarfLineEntryESaIS5_EE")
//</editor-fold>
public static /*inline*/ void EmitDwarfLineTable(MCObjectStreamer /*P*/ MCOS, MCSection /*P*/ Section, 
                  final /*const*/std.vector<MCDwarfLineEntry> /*&*/ LineEntries) {
  /*uint*/int FileNum = 1;
  /*uint*/int LastLine = 1;
  /*uint*/int Column = 0;
  /*uint*/int Flags = DWARF2_LINE_DEFAULT_IS_STMT == 1 ? DWARF2_FLAG_IS_STMT : 0;
  /*uint*/int Isa = 0;
  /*uint*/int Discriminator = 0;
  MCSymbol /*P*/ LastLabel = null;
  
  // Loop through each MCDwarfLineEntry and encode the dwarf line number table.
  for (final /*const*/ MCDwarfLineEntry /*&*/ LineEntry : LineEntries) {
    long/*int64_t*/ LineDelta = ((/*static_cast*/long/*int64_t*/)($uint2long(LineEntry.getLine()))) - $uint2llong(LastLine);
    if (FileNum != LineEntry.getFileNum()) {
      FileNum = LineEntry.getFileNum();
      MCOS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_set_file), 1);
      MCOS.EmitULEB128IntValue($uint2ulong(FileNum));
    }
    if (Column != LineEntry.getColumn()) {
      Column = LineEntry.getColumn();
      MCOS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_set_column), 1);
      MCOS.EmitULEB128IntValue($uint2ulong(Column));
    }
    if (Discriminator != LineEntry.getDiscriminator()) {
      Discriminator = LineEntry.getDiscriminator();
      /*uint*/int Size = AdtsupportLlvmGlobals.getULEB128Size($uint2ulong(Discriminator));
      MCOS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_extended_op), 1);
      MCOS.EmitULEB128IntValue($uint2ulong(Size + 1));
      MCOS.EmitIntValue($uint2ulong(LineNumberExtendedOps.DW_LNE_set_discriminator), 1);
      MCOS.EmitULEB128IntValue($uint2ulong(Discriminator));
    }
    if (Isa != LineEntry.getIsa()) {
      Isa = LineEntry.getIsa();
      MCOS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_set_isa), 1);
      MCOS.EmitULEB128IntValue($uint2ulong(Isa));
    }
    if ((((LineEntry.getFlags() ^ Flags) & DWARF2_FLAG_IS_STMT) != 0)) {
      Flags = LineEntry.getFlags();
      MCOS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_negate_stmt), 1);
    }
    if (((LineEntry.getFlags() & DWARF2_FLAG_BASIC_BLOCK) != 0)) {
      MCOS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_set_basic_block), 1);
    }
    if (((LineEntry.getFlags() & DWARF2_FLAG_PROLOGUE_END) != 0)) {
      MCOS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_set_prologue_end), 1);
    }
    if (((LineEntry.getFlags() & DWARF2_FLAG_EPILOGUE_BEGIN) != 0)) {
      MCOS.EmitIntValue($uint2ulong(LineNumberOps.DW_LNS_set_epilogue_begin), 1);
    }
    
    MCSymbol /*P*/ Label = LineEntry.getLabel();
    
    // At this point we want to emit/create the sequence to encode the delta in
    // line numbers and the increment of the address from the previous Label
    // and the current Label.
    /*const*/ MCAsmInfo /*P*/ asmInfo = MCOS.getContext().getAsmInfo();
    MCOS.EmitDwarfAdvanceLineAddr(LineDelta, LastLabel, Label, 
        asmInfo.getPointerSize());
    
    Discriminator = 0;
    LastLine = LineEntry.getLine();
    LastLabel = Label;
  }
  
  // Emit a DW_LNE_end_sequence for the end of the section.
  // Use the section end label to compute the address delta and use INT64_MAX
  // as the line delta which is the signal that this is actually a
  // DW_LNE_end_sequence.
  MCSymbol /*P*/ SectionEnd = MCOS.endSection(Section);
  
  // Switch back the dwarf line section, in case endSection had to switch the
  // section.
  final MCContext /*&*/ Ctx = MCOS.getContext();
  MCOS.SwitchSection(Ctx.getObjectFileInfo().getDwarfLineSection());
  
  /*const*/ MCAsmInfo /*P*/ AsmInfo = Ctx.getAsmInfo();
  MCOS.EmitDwarfAdvanceLineAddr(INT64_MAX, LastLabel, SectionEnd, 
      AsmInfo.getPointerSize());
}

//<editor-fold defaultstate="collapsed" desc="forceExpAbs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 229,
 FQN="forceExpAbs", NM="_ZL11forceExpAbsRN4llvm10MCStreamerEPKNS_6MCExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL11forceExpAbsRN4llvm10MCStreamerEPKNS_6MCExprE")
//</editor-fold>
public static /*const*/ MCExpr /*P*/ forceExpAbs(final MCStreamer /*&*/ OS, /*const*/ MCExpr /*P*/ Expr) {
  final MCContext /*&*/ Context = OS.getContext();
  assert (!isa_MCSymbolRefExpr(Expr));
  if (Context.getAsmInfo().hasAggressiveSymbolFolding()) {
    return Expr;
  }
  
  MCSymbol /*P*/ ABS = Context.createTempSymbol();
  OS.EmitAssignment(ABS, Expr);
  return MCSymbolRefExpr.create(ABS, Context);
}

//<editor-fold defaultstate="collapsed" desc="emitAbsValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 240,
 FQN="emitAbsValue", NM="_ZL12emitAbsValueRN4llvm10MCStreamerEPKNS_6MCExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL12emitAbsValueRN4llvm10MCStreamerEPKNS_6MCExprEj")
//</editor-fold>
public static void emitAbsValue(final MCStreamer /*&*/ OS, /*const*/ MCExpr /*P*/ Value, /*uint*/int Size) {
  /*const*/ MCExpr /*P*/ ABS = forceExpAbs(OS, Value);
  OS.EmitValue(ABS, Size);
}


/// Given a special op, return the address skip amount (in units of
/// DWARF2_LINE_MIN_INSN_LENGTH).
//<editor-fold defaultstate="collapsed" desc="SpecialAddr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 417,
 FQN="SpecialAddr", NM="_ZL11SpecialAddrN4llvm22MCDwarfLineTableParamsEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL11SpecialAddrN4llvm22MCDwarfLineTableParamsEy")
//</editor-fold>
public static long/*uint64_t*/ SpecialAddr(MCDwarfLineTableParams Params, long/*uint64_t*/ op) {
  return Unsigned.$div_ullong_uchar((op - $uchar2ullong(Params.DWARF2LineOpcodeBase)), Params.DWARF2LineRange);
}


// Utility function to write a tuple for .debug_abbrev.
//<editor-fold defaultstate="collapsed" desc="EmitAbbrev">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 505,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 502,
 FQN="EmitAbbrev", NM="_ZL10EmitAbbrevPN4llvm10MCStreamerEyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL10EmitAbbrevPN4llvm10MCStreamerEyy")
//</editor-fold>
public static void EmitAbbrev(MCStreamer /*P*/ MCOS, long/*uint64_t*/ Name, long/*uint64_t*/ Form) {
  MCOS.EmitULEB128IntValue(Name);
  MCOS.EmitULEB128IntValue(Form);
}


// When generating dwarf for assembly source files this emits
// the data for .debug_abbrev section which contains three DIEs.
//<editor-fold defaultstate="collapsed" desc="EmitGenDwarfAbbrev">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 512,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 509,
 FQN="EmitGenDwarfAbbrev", NM="_ZL18EmitGenDwarfAbbrevPN4llvm10MCStreamerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL18EmitGenDwarfAbbrevPN4llvm10MCStreamerE")
//</editor-fold>
public static void EmitGenDwarfAbbrev(MCStreamer /*P*/ MCOS) {
  final MCContext /*&*/ context = MCOS.getContext();
  MCOS.SwitchSection(context.getObjectFileInfo().getDwarfAbbrevSection());
  
  // DW_TAG_compile_unit DIE abbrev (1).
  MCOS.EmitULEB128IntValue($int2ulong(1));
  MCOS.EmitULEB128IntValue($ushort2ulong(Tag.DW_TAG_compile_unit));
  MCOS.EmitIntValue($uint2ulong(Constants.DW_CHILDREN_yes), 1);
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_stmt_list), $ushort2ulong($ushort2int(context.getDwarfVersion()) >= 4 ? Form.DW_FORM_sec_offset : Form.DW_FORM_data4));
  if ($greater_uint(context.getGenDwarfSectionSyms().size(), 1)
     && $ushort2int(context.getDwarfVersion()) >= 3) {
    EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_ranges), $ushort2ulong($ushort2int(context.getDwarfVersion()) >= 4 ? Form.DW_FORM_sec_offset : Form.DW_FORM_data4));
  } else {
    EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_low_pc), $ushort2ulong(Form.DW_FORM_addr));
    EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_high_pc), $ushort2ulong(Form.DW_FORM_addr));
  }
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_name), $ushort2ulong(Form.DW_FORM_string));
  if (!context.getCompilationDir().empty()) {
    EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_comp_dir), $ushort2ulong(Form.DW_FORM_string));
  }
  StringRef DwarfDebugFlags = context.getDwarfDebugFlags();
  if (!DwarfDebugFlags.empty()) {
    EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_APPLE_flags), $ushort2ulong(Form.DW_FORM_string));
  }
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_producer), $ushort2ulong(Form.DW_FORM_string));
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_language), $ushort2ulong(Form.DW_FORM_data2));
  EmitAbbrev(MCOS, $int2ulong(0), $int2ulong(0));
  
  // DW_TAG_label DIE abbrev (2).
  MCOS.EmitULEB128IntValue($int2ulong(2));
  MCOS.EmitULEB128IntValue($ushort2ulong(Tag.DW_TAG_label));
  MCOS.EmitIntValue($uint2ulong(Constants.DW_CHILDREN_yes), 1);
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_name), $ushort2ulong(Form.DW_FORM_string));
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_decl_file), $ushort2ulong(Form.DW_FORM_data4));
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_decl_line), $ushort2ulong(Form.DW_FORM_data4));
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_low_pc), $ushort2ulong(Form.DW_FORM_addr));
  EmitAbbrev(MCOS, $ushort2ulong(Attribute.DW_AT_prototyped), $ushort2ulong(Form.DW_FORM_flag));
  EmitAbbrev(MCOS, $int2ulong(0), $int2ulong(0));
  
  // DW_TAG_unspecified_parameters DIE abbrev (3).
  MCOS.EmitULEB128IntValue($int2ulong(3));
  MCOS.EmitULEB128IntValue($ushort2ulong(Tag.DW_TAG_unspecified_parameters));
  MCOS.EmitIntValue($uint2ulong(Constants.DW_CHILDREN_no), 1);
  EmitAbbrev(MCOS, $int2ulong(0), $int2ulong(0));
  
  // Terminate the abbreviations for this compilation unit.
  MCOS.EmitIntValue($int2ulong(0), 1);
}


// When generating dwarf for assembly source files this emits the data for
// .debug_aranges section. This section contains a header and a table of pairs
// of PointerSize'ed values for the address and size of section(s) with line
// table entries.
//<editor-fold defaultstate="collapsed" desc="EmitGenDwarfAranges">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 567,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 564,
 FQN="EmitGenDwarfAranges", NM="_ZL19EmitGenDwarfArangesPN4llvm10MCStreamerEPKNS_8MCSymbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL19EmitGenDwarfArangesPN4llvm10MCStreamerEPKNS_8MCSymbolE")
//</editor-fold>
public static void EmitGenDwarfAranges(MCStreamer /*P*/ MCOS, 
                   /*const*/ MCSymbol /*P*/ InfoSectionSymbol) {
  final MCContext /*&*/ context = MCOS.getContext();

  final /*const*/ SetVector<MCSection> /*&*/ Sections = context.getGenDwarfSectionSyms();
  
  MCOS.SwitchSection(context.getObjectFileInfo().getDwarfARangesSection());
  
  // This will be the length of the .debug_aranges section, first account for
  // the size of each item in the header (see below where we emit these items).
  int Length = 4 + 2 + 4 + 1 + 1;
  
  // Figure the padding after the header before the table of address and size
  // pairs who's values are PointerSize'ed.
  /*const*/ MCAsmInfo /*P*/ asmInfo = context.getAsmInfo();
  int AddrSize = asmInfo.getPointerSize();
  int Pad = 2 * AddrSize - (Length & (2 * AddrSize - 1));
  if (Pad == 2 * AddrSize) {
    Pad = 0;
  }
  Length += Pad;
  
  // Add the size of the pair of PointerSize'ed values for the address and size
  // of each section we have in the table.
  Length += 2 * AddrSize * Sections.size();
  // And the pair of terminating zeros.
  Length += 2 * AddrSize;
  
  // Emit the header for this section.
  // The 4 byte length not including the 4 byte value for the length.
  MCOS.EmitIntValue($int2ulong(Length - 4), 4);
  // The 2 byte version, which is 2.
  MCOS.EmitIntValue($int2ulong(2), 2);
  // The 4 byte offset to the compile unit in the .debug_info from the start
  // of the .debug_info.
  if ((InfoSectionSymbol != null)) {
    MCOS.EmitSymbolValue(InfoSectionSymbol, 4, 
        asmInfo.needsDwarfSectionOffsetDirective());
  } else {
    MCOS.EmitIntValue($int2ulong(0), 4);
  }
  // The 1 byte size of an address.
  MCOS.EmitIntValue($int2ulong(AddrSize), 1);
  // The 1 byte size of a segment descriptor, we use a value of zero.
  MCOS.EmitIntValue($int2ulong(0), 1);
  // Align the header with the padding if needed, before we put out the table.
  for (int i = 0; i < Pad; i++)  {
    MCOS.EmitIntValue($int2ulong(0), 1);
  }
  
  // Now emit the table of pairs of PointerSize'ed values for the section
  // addresses and sizes.
  for (MCSection /*P*/ Sec : Sections) {
    /*const*/ MCSymbol /*P*/ StartSymbol = Sec.getBeginSymbol();
    MCSymbol /*P*/ EndSymbol = Sec.getEndSymbol(context);
    assert ((StartSymbol != null)) : "StartSymbol must not be NULL";
    assert ((EndSymbol != null)) : "EndSymbol must not be NULL";
    
    /*const*/ MCExpr /*P*/ Addr = MCSymbolRefExpr.create(StartSymbol, MCSymbolRefExpr.VariantKind.VK_None, context);
    /*const*/ MCExpr /*P*/ Size = MakeStartMinusEndExpr($Deref(MCOS), 
        $Deref(StartSymbol), $Deref(EndSymbol), 0);
    MCOS.EmitValue(Addr, AddrSize);
    emitAbsValue($Deref(MCOS), Size, AddrSize);
  }
  
  // And finally the pair of terminating zeros.
  MCOS.EmitIntValue($int2ulong(0), AddrSize);
  MCOS.EmitIntValue($int2ulong(0), AddrSize);
}


// When generating dwarf for assembly source files this emits the data for
// .debug_info section which contains three parts.  The header, the compile_unit
// DIE and a list of label DIEs.
//<editor-fold defaultstate="collapsed" desc="EmitGenDwarfInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 639,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 636,
 FQN="EmitGenDwarfInfo", NM="_ZL16EmitGenDwarfInfoPN4llvm10MCStreamerEPKNS_8MCSymbolES4_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL16EmitGenDwarfInfoPN4llvm10MCStreamerEPKNS_8MCSymbolES4_S4_")
//</editor-fold>
public static void EmitGenDwarfInfo(MCStreamer /*P*/ MCOS, 
                /*const*/ MCSymbol /*P*/ AbbrevSectionSymbol, 
                /*const*/ MCSymbol /*P*/ LineSectionSymbol, 
                /*const*/ MCSymbol /*P*/ RangesSectionSymbol) {
  final MCContext /*&*/ context = MCOS.getContext();
  
  MCOS.SwitchSection(context.getObjectFileInfo().getDwarfInfoSection());
  
  // Create a symbol at the start and end of this section used in here for the
  // expression to calculate the length in the header.
  MCSymbol /*P*/ InfoStart = context.createTempSymbol();
  MCOS.EmitLabel(InfoStart);
  MCSymbol /*P*/ InfoEnd = context.createTempSymbol();
  
  // First part: the header.
  
  // The 4 byte total length of the information for this compilation unit, not
  // including these 4 bytes.
  /*const*/ MCExpr /*P*/ Length = MakeStartMinusEndExpr($Deref(MCOS), $Deref(InfoStart), $Deref(InfoEnd), 4);
  emitAbsValue($Deref(MCOS), Length, 4);
  
  // The 2 byte DWARF version.
  MCOS.EmitIntValue($ushort2ulong(context.getDwarfVersion()), 2);
  
  final /*const*/ MCAsmInfo /*&*/ AsmInfo = $Deref(context.getAsmInfo());
  // The 4 byte offset to the debug abbrevs from the start of the .debug_abbrev,
  // it is at the start of that section so this is zero.
  if (AbbrevSectionSymbol == null) {
    MCOS.EmitIntValue($int2ulong(0), 4);
  } else {
    MCOS.EmitSymbolValue(AbbrevSectionSymbol, 4, 
        AsmInfo.needsDwarfSectionOffsetDirective());
  }
  
  /*const*/ MCAsmInfo /*P*/ asmInfo = context.getAsmInfo();
  int AddrSize = asmInfo.getPointerSize();
  // The 1 byte size of an address.
  MCOS.EmitIntValue($int2ulong(AddrSize), 1);
  
  // Second part: the compile_unit DIE.
  
  // The DW_TAG_compile_unit DIE abbrev (1).
  MCOS.EmitULEB128IntValue($int2ulong(1));
  
  // DW_AT_stmt_list, a 4 byte offset from the start of the .debug_line section,
  // which is at the start of that section so this is zero.
  if ((LineSectionSymbol != null)) {
    MCOS.EmitSymbolValue(LineSectionSymbol, 4, 
        AsmInfo.needsDwarfSectionOffsetDirective());
  } else {
    MCOS.EmitIntValue($int2ulong(0), 4);
  }
  if ((RangesSectionSymbol != null)) {
    // There are multiple sections containing code, so we must use the
    // .debug_ranges sections.
    
    // AT_ranges, the 4 byte offset from the start of the .debug_ranges section
    // to the address range list for this compilation unit.
    MCOS.EmitSymbolValue(RangesSectionSymbol, 4);
  } else {
    // If we only have one non-empty code section, we can use the simpler
    // AT_low_pc and AT_high_pc attributes.
    // Find the first (and only) non-empty text section
    final /*const*/ SetVector<MCSection> /*&*/ Sections = context.getGenDwarfSectionSyms();
    /*const*/StdVector.iterator<MCSection> TextSection = Sections.begin$Const();
    assert ($noteq___normal_iterator$C(TextSection, Sections.end$Const())) : "No text section found";
    
    MCSymbol /*P*/ StartSymbol = (TextSection.$star()).getBeginSymbol();
    MCSymbol /*P*/ EndSymbol = (TextSection.$star()).getEndSymbol(context);
    assert ((StartSymbol != null)) : "StartSymbol must not be NULL";
    assert ((EndSymbol != null)) : "EndSymbol must not be NULL";
    
    // AT_low_pc, the first address of the default .text section.
    /*const*/ MCExpr /*P*/ Start = MCSymbolRefExpr.create(StartSymbol, MCSymbolRefExpr.VariantKind.VK_None, context);
    MCOS.EmitValue(Start, AddrSize);
    
    // AT_high_pc, the last address of the default .text section.
    /*const*/ MCExpr /*P*/ End = MCSymbolRefExpr.create(EndSymbol, MCSymbolRefExpr.VariantKind.VK_None, context);
    MCOS.EmitValue(End, AddrSize);
  }
  
  // AT_name, the name of the source file.  Reconstruct from the first directory
  // and file table entries.
  final /*const*/ SmallVectorImpl<std.string> /*&*/ MCDwarfDirs = context.getMCDwarfDirs();
  if ($greater_uint(MCDwarfDirs.size(), 0)) {
    MCOS.EmitBytes(new StringRef(MCDwarfDirs.$at$Const(0)));
    MCOS.EmitBytes(path.get_separator());
  }
  final /*const*/ SmallVectorImpl<MCDwarfFile> /*&*/ MCDwarfFiles = MCOS.getContext().getMCDwarfFiles();
  MCOS.EmitBytes(new StringRef(MCDwarfFiles.$at$Const(1).Name));
  MCOS.EmitIntValue($int2ulong(0), 1); // NULL byte to terminate the string.
  
  // AT_comp_dir, the working directory the assembly was done in.
  if (!context.getCompilationDir().empty()) {
    MCOS.EmitBytes(context.getCompilationDir());
    MCOS.EmitIntValue($int2ulong(0), 1); // NULL byte to terminate the string.
  }
  
  // AT_APPLE_flags, the command line arguments of the assembler tool.
  StringRef DwarfDebugFlags = context.getDwarfDebugFlags();
  if (!DwarfDebugFlags.empty()) {
    MCOS.EmitBytes(new StringRef(DwarfDebugFlags));
    MCOS.EmitIntValue($int2ulong(0), 1); // NULL byte to terminate the string.
  }
  
  // AT_producer, the version of the assembler tool.
  StringRef DwarfDebugProducer = context.getDwarfDebugProducer();
  if (!DwarfDebugProducer.empty()) {
    MCOS.EmitBytes(new StringRef(DwarfDebugProducer));
  } else {
    MCOS.EmitBytes(new StringRef(/*KEEP_STR*/"llvm-mc (based on LLVM 3.9.0)"));
  }
  MCOS.EmitIntValue($int2ulong(0), 1); // NULL byte to terminate the string.
  
  // AT_language, a 4 byte value.  We use DW_LANG_Mips_Assembler as the dwarf2
  // draft has no standard code for assembler.
  MCOS.EmitIntValue($uint2ulong(SourceLanguage.DW_LANG_Mips_Assembler), 2);
  
  // Third part: the list of label DIEs.
  
  // Loop on saved info for dwarf labels and create the DIEs for them.
  final /*const*/std.vector<MCGenDwarfLabelEntry> /*&*/ Entries = MCOS.getContext().getMCGenDwarfLabelEntries();
  for (final /*const*/ MCGenDwarfLabelEntry /*&*/ Entry : Entries) {
    // The DW_TAG_label DIE abbrev (2).
    MCOS.EmitULEB128IntValue($int2ulong(2));
    
    // AT_name, of the label without any leading underbar.
    MCOS.EmitBytes(Entry.getName());
    MCOS.EmitIntValue($int2ulong(0), 1); // NULL byte to terminate the string.
    
    // AT_decl_file, index into the file table.
    MCOS.EmitIntValue($uint2ulong(Entry.getFileNumber()), 4);
    
    // AT_decl_line, source line number.
    MCOS.EmitIntValue($uint2ulong(Entry.getLineNumber()), 4);
    
    // AT_low_pc, start address of the label.
    /*const*/ MCExpr /*P*/ AT_low_pc = MCSymbolRefExpr.create(Entry.getLabel(), 
        MCSymbolRefExpr.VariantKind.VK_None, context);
    MCOS.EmitValue(AT_low_pc, AddrSize);
    
    // DW_AT_prototyped, a one byte flag value of 0 saying we have no prototype.
    MCOS.EmitIntValue($int2ulong(0), 1);
    
    // The DW_TAG_unspecified_parameters DIE abbrev (3).
    MCOS.EmitULEB128IntValue($int2ulong(3));
    
    // Add the NULL DIE terminating the DW_TAG_unspecified_parameters DIE's.
    MCOS.EmitIntValue($int2ulong(0), 1);
  }
  
  // Add the NULL DIE terminating the Compile Unit DIE's.
  MCOS.EmitIntValue($int2ulong(0), 1);
  
  // Now set the value of the symbol at the end of the info section.
  MCOS.EmitLabel(InfoEnd);
}


// When generating dwarf for assembly source files this emits the data for
// .debug_ranges section. We only emit one range list, which spans all of the
// executable sections of this file.
//<editor-fold defaultstate="collapsed" desc="EmitGenDwarfRanges">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 803,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 800,
 FQN="EmitGenDwarfRanges", NM="_ZL18EmitGenDwarfRangesPN4llvm10MCStreamerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL18EmitGenDwarfRangesPN4llvm10MCStreamerE")
//</editor-fold>
public static void EmitGenDwarfRanges(MCStreamer /*P*/ MCOS) {
  final MCContext /*&*/ context = MCOS.getContext();
  final /*const*/ SetVector<MCSection> /*&*/ Sections = context.getGenDwarfSectionSyms();
  
  /*const*/ MCAsmInfo /*P*/ AsmInfo = context.getAsmInfo();
  int AddrSize = AsmInfo.getPointerSize();
  
  MCOS.SwitchSection(context.getObjectFileInfo().getDwarfRangesSection());
  
  for (MCSection /*P*/ Sec : Sections) {
    /*const*/ MCSymbol /*P*/ StartSymbol = Sec.getBeginSymbol();
    MCSymbol /*P*/ EndSymbol = Sec.getEndSymbol(context);
    assert ((StartSymbol != null)) : "StartSymbol must not be NULL";
    assert ((EndSymbol != null)) : "EndSymbol must not be NULL";
    
    // Emit a base address selection entry for the start of this section
    /*const*/ MCExpr /*P*/ SectionStartAddr = MCSymbolRefExpr.create(StartSymbol, MCSymbolRefExpr.VariantKind.VK_None, context);
    MCOS.emitFill($int2ulong(AddrSize), $int2uchar(0xFF));
    MCOS.EmitValue(SectionStartAddr, AddrSize);
    
    // Emit a range list entry spanning this section
    /*const*/ MCExpr /*P*/ SectionSize = MakeStartMinusEndExpr($Deref(MCOS), 
        $Deref(StartSymbol), $Deref(EndSymbol), 0);
    MCOS.EmitIntValue($int2ulong(0), AddrSize);
    emitAbsValue($Deref(MCOS), SectionSize, AddrSize);
  }
  
  // Emit end of list entry
  MCOS.EmitIntValue($int2ulong(0), AddrSize);
  MCOS.EmitIntValue($int2ulong(0), AddrSize);
}

//<editor-fold defaultstate="collapsed" desc="getDataAlignmentFactor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 948,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 945,
 FQN="getDataAlignmentFactor", NM="_ZL22getDataAlignmentFactorRN4llvm10MCStreamerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL22getDataAlignmentFactorRN4llvm10MCStreamerE")
//</editor-fold>
public static int getDataAlignmentFactor(final MCStreamer /*&*/ streamer) {
  final MCContext /*&*/ context = streamer.getContext();
  /*const*/ MCAsmInfo /*P*/ asmInfo = context.getAsmInfo();
  int size = asmInfo.getCalleeSaveStackSlotSize();
  if (asmInfo.isStackGrowthDirectionUp()) {
    return size;
  } else {
    return -size;
  }
}

//<editor-fold defaultstate="collapsed" desc="getSizeForEncoding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 958,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 955,
 FQN="getSizeForEncoding", NM="_ZL18getSizeForEncodingRN4llvm10MCStreamerEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL18getSizeForEncodingRN4llvm10MCStreamerEj")
//</editor-fold>
public static /*uint*/int getSizeForEncoding(final MCStreamer /*&*/ streamer, 
                  /*uint*/int symbolEncoding) {
  final MCContext /*&*/ context = streamer.getContext();
  /*uint*/int format = symbolEncoding & 0x0f;
  switch (format) {
   default:
    throw new llvm_unreachable("Unknown Encoding");
   case Constants.DW_EH_PE_absptr:
   case Constants.DW_EH_PE_signed:
    return context.getAsmInfo().getPointerSize();
   case Constants.DW_EH_PE_udata2:
   case Constants.DW_EH_PE_sdata2:
    return 2;
   case Constants.DW_EH_PE_udata4:
   case Constants.DW_EH_PE_sdata4:
    return 4;
   case Constants.DW_EH_PE_udata8:
   case Constants.DW_EH_PE_sdata8:
    return 8;
  }
}

//<editor-fold defaultstate="collapsed" desc="emitFDESymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 979,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 976,
 FQN="emitFDESymbol", NM="_ZL13emitFDESymbolRN4llvm16MCObjectStreamerERKNS_8MCSymbolEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL13emitFDESymbolRN4llvm16MCObjectStreamerERKNS_8MCSymbolEjb")
//</editor-fold>
public static void emitFDESymbol(final MCObjectStreamer /*&*/ streamer, final /*const*/ MCSymbol /*&*/ symbol, 
             /*uint*/int symbolEncoding, boolean isEH) {
  final MCContext /*&*/ context = streamer.getContext();
  /*const*/ MCAsmInfo /*P*/ asmInfo = context.getAsmInfo();
  /*const*/ MCExpr /*P*/ v = asmInfo.getExprForFDESymbol($AddrOf(symbol), 
      symbolEncoding, 
      streamer);
  /*uint*/int size = getSizeForEncoding(streamer, symbolEncoding);
  if (asmInfo.doDwarfFDESymbolsUseAbsDiff() && isEH) {
    emitAbsValue(streamer, v, size);
  } else {
    streamer.EmitValue(v, size);
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitPersonality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 993,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 990,
 FQN="EmitPersonality", NM="_ZL15EmitPersonalityRN4llvm10MCStreamerERKNS_8MCSymbolEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL15EmitPersonalityRN4llvm10MCStreamerERKNS_8MCSymbolEj")
//</editor-fold>
public static void EmitPersonality(final MCStreamer /*&*/ streamer, final /*const*/ MCSymbol /*&*/ symbol, 
               /*uint*/int symbolEncoding) {
  final MCContext /*&*/ context = streamer.getContext();
  /*const*/ MCAsmInfo /*P*/ asmInfo = context.getAsmInfo();
  /*const*/ MCExpr /*P*/ v = asmInfo.getExprForPersonalitySymbol($AddrOf(symbol), 
      symbolEncoding, 
      streamer);
  /*uint*/int size = getSizeForEncoding(streamer, symbolEncoding);
  streamer.EmitValue(v, size);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="emitEncodingByte">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1031,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1028,
 FQN="emitEncodingByte", NM="_ZL16emitEncodingByteRN4llvm16MCObjectStreamerEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL16emitEncodingByteRN4llvm16MCObjectStreamerEj")
//</editor-fold>
public static void emitEncodingByte(final MCObjectStreamer /*&*/ Streamer, /*uint*/int Encoding) {
  Streamer.EmitIntValue($uint2ulong(Encoding), 1);
}

//<editor-fold defaultstate="collapsed" desc="getCIEVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1244,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1242,
 FQN="getCIEVersion", NM="_ZL13getCIEVersionbj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZL13getCIEVersionbj")
//</editor-fold>
public static /*uint*/int getCIEVersion(boolean IsEH, /*uint*/int DwarfVersion) {
  if (IsEH) {
    return 1;
  }
  switch (DwarfVersion) {
   case 2:
    return 1;
   case 3:
    return 3;
   case 4:
   case 5:
    return 4;
  }
  throw new llvm_unreachable("Unknown version");
}

} // END OF class MCDwarfStatics
