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

package org.llvm.debuginfo.codeview;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// Duplicate copy of the above enum, but using the official CV names. Useful
/// for reference purposes and when dealing with unknown record types.
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::SymbolKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 44,
 FQN="llvm::codeview::SymbolKind", NM="_ZN4llvm8codeview10SymbolKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview10SymbolKindE")
//</editor-fold>
public final class/*enum*/ SymbolKind/* : uint16_t*/ {
  
  // 16 bit symbol types. Not very useful, provided only for reference.
  public static final /*uint16_t*/char S_COMPILE = $int2ushort(0x1);
  public static final /*uint16_t*/char S_REGISTER_16t = $int2ushort(0x2);
  public static final /*uint16_t*/char S_CONSTANT_16t = $int2ushort(0x3);
  public static final /*uint16_t*/char S_UDT_16t = $int2ushort(0x4);
  public static final /*uint16_t*/char S_SSEARCH = $int2ushort(0x5);
  public static final /*uint16_t*/char S_SKIP = $int2ushort(0x7);
  public static final /*uint16_t*/char S_CVRESERVE = $int2ushort(0x8);
  public static final /*uint16_t*/char S_OBJNAME_ST = $int2ushort(0x9);
  public static final /*uint16_t*/char S_ENDARG = $int2ushort(0xA);
  public static final /*uint16_t*/char S_COBOLUDT_16t = $int2ushort(0xB);
  public static final /*uint16_t*/char S_MANYREG_16t = $int2ushort(0xC);
  public static final /*uint16_t*/char S_RETURN = $int2ushort(0xD);
  public static final /*uint16_t*/char S_ENTRYTHIS = $int2ushort(0xE);
  public static final /*uint16_t*/char S_BPREL16 = $int2ushort(0x100);
  public static final /*uint16_t*/char S_LDATA16 = $int2ushort(0x101);
  public static final /*uint16_t*/char S_GDATA16 = $int2ushort(0x102);
  public static final /*uint16_t*/char S_PUB16 = $int2ushort(0x103);
  public static final /*uint16_t*/char S_LPROC16 = $int2ushort(0x104);
  public static final /*uint16_t*/char S_GPROC16 = $int2ushort(0x105);
  public static final /*uint16_t*/char S_THUNK16 = $int2ushort(0x106);
  public static final /*uint16_t*/char S_BLOCK16 = $int2ushort(0x107);
  public static final /*uint16_t*/char S_WITH16 = $int2ushort(0x108);
  public static final /*uint16_t*/char S_LABEL16 = $int2ushort(0x109);
  public static final /*uint16_t*/char S_CEXMODEL16 = $int2ushort(0x10A);
  public static final /*uint16_t*/char S_VFTABLE16 = $int2ushort(0x10B);
  public static final /*uint16_t*/char S_REGREL16 = $int2ushort(0x10C);
  public static final /*uint16_t*/char S_BPREL32_16t = $int2ushort(0x200);
  public static final /*uint16_t*/char S_LDATA32_16t = $int2ushort(0x201);
  public static final /*uint16_t*/char S_GDATA32_16t = $int2ushort(0x202);
  public static final /*uint16_t*/char S_PUB32_16t = $int2ushort(0x203);
  public static final /*uint16_t*/char S_LPROC32_16t = $int2ushort(0x204);
  public static final /*uint16_t*/char S_GPROC32_16t = $int2ushort(0x205);
  public static final /*uint16_t*/char S_THUNK32_ST = $int2ushort(0x206);
  public static final /*uint16_t*/char S_BLOCK32_ST = $int2ushort(0x207);
  public static final /*uint16_t*/char S_WITH32_ST = $int2ushort(0x208);
  public static final /*uint16_t*/char S_LABEL32_ST = $int2ushort(0x209);
  public static final /*uint16_t*/char S_CEXMODEL32 = $int2ushort(0x20A);
  public static final /*uint16_t*/char S_VFTABLE32_16t = $int2ushort(0x20B);
  public static final /*uint16_t*/char S_REGREL32_16t = $int2ushort(0x20C);
  public static final /*uint16_t*/char S_LTHREAD32_16t = $int2ushort(0x20D);
  public static final /*uint16_t*/char S_GTHREAD32_16t = $int2ushort(0x20E);
  public static final /*uint16_t*/char S_SLINK32 = $int2ushort(0x20F);
  public static final /*uint16_t*/char S_LPROCMIPS_16t = $int2ushort(0x300);
  public static final /*uint16_t*/char S_GPROCMIPS_16t = $int2ushort(0x301);
  public static final /*uint16_t*/char S_PROCREF_ST = $int2ushort(0x400);
  public static final /*uint16_t*/char S_DATAREF_ST = $int2ushort(0x401);
  public static final /*uint16_t*/char S_ALIGN = $int2ushort(0x402);
  public static final /*uint16_t*/char S_LPROCREF_ST = $int2ushort(0x403);
  public static final /*uint16_t*/char S_OEM = $int2ushort(0x404);
  
  // All post 16 bit symbol types have the 0x1000 bit set.
  public static final /*uint16_t*/char S_TI16_MAX = $int2ushort(0x1000);
  
  // Mostly unused "start" symbol types.
  public static final /*uint16_t*/char S_REGISTER_ST = $int2ushort(0x1001);
  public static final /*uint16_t*/char S_CONSTANT_ST = $int2ushort(0x1002);
  public static final /*uint16_t*/char S_UDT_ST = $int2ushort(0x1003);
  public static final /*uint16_t*/char S_COBOLUDT_ST = $int2ushort(0x1004);
  public static final /*uint16_t*/char S_MANYREG_ST = $int2ushort(0x1005);
  public static final /*uint16_t*/char S_BPREL32_ST = $int2ushort(0x1006);
  public static final /*uint16_t*/char S_LDATA32_ST = $int2ushort(0x1007);
  public static final /*uint16_t*/char S_GDATA32_ST = $int2ushort(0x1008);
  public static final /*uint16_t*/char S_PUB32_ST = $int2ushort(0x1009);
  public static final /*uint16_t*/char S_LPROC32_ST = $int2ushort(0x100A);
  public static final /*uint16_t*/char S_GPROC32_ST = $int2ushort(0x100B);
  public static final /*uint16_t*/char S_VFTABLE32 = $int2ushort(0x100C);
  public static final /*uint16_t*/char S_REGREL32_ST = $int2ushort(0x100D);
  public static final /*uint16_t*/char S_LTHREAD32_ST = $int2ushort(0x100E);
  public static final /*uint16_t*/char S_GTHREAD32_ST = $int2ushort(0x100F);
  public static final /*uint16_t*/char S_LPROCMIPS_ST = $int2ushort(0x1010);
  public static final /*uint16_t*/char S_GPROCMIPS_ST = $int2ushort(0x1011);
  public static final /*uint16_t*/char S_COMPILE2_ST = $int2ushort(0x1013);
  public static final /*uint16_t*/char S_MANYREG2_ST = $int2ushort(0x1014);
  public static final /*uint16_t*/char S_LPROCIA64_ST = $int2ushort(0x1015);
  public static final /*uint16_t*/char S_GPROCIA64_ST = $int2ushort(0x1016);
  public static final /*uint16_t*/char S_LOCALSLOT_ST = $int2ushort(0x1017);
  public static final /*uint16_t*/char S_PARAMSLOT_ST = $int2ushort(0x1018);
  public static final /*uint16_t*/char S_ANNOTATION = $int2ushort(0x1019);
  public static final /*uint16_t*/char S_GMANPROC_ST = $int2ushort(0x101A);
  public static final /*uint16_t*/char S_LMANPROC_ST = $int2ushort(0x101B);
  public static final /*uint16_t*/char S_RESERVED1 = $int2ushort(0x101C);
  public static final /*uint16_t*/char S_RESERVED2 = $int2ushort(0x101D);
  public static final /*uint16_t*/char S_RESERVED3 = $int2ushort(0x101E);
  public static final /*uint16_t*/char S_RESERVED4 = $int2ushort(0x101F);
  public static final /*uint16_t*/char S_LMANDATA_ST = $int2ushort(0x1020);
  public static final /*uint16_t*/char S_GMANDATA_ST = $int2ushort(0x1021);
  public static final /*uint16_t*/char S_MANFRAMEREL_ST = $int2ushort(0x1022);
  public static final /*uint16_t*/char S_MANREGISTER_ST = $int2ushort(0x1023);
  public static final /*uint16_t*/char S_MANSLOT_ST = $int2ushort(0x1024);
  public static final /*uint16_t*/char S_MANMANYREG_ST = $int2ushort(0x1025);
  public static final /*uint16_t*/char S_MANREGREL_ST = $int2ushort(0x1026);
  public static final /*uint16_t*/char S_MANMANYREG2_ST = $int2ushort(0x1027);
  public static final /*uint16_t*/char S_MANTYPREF = $int2ushort(0x1028);
  public static final /*uint16_t*/char S_UNAMESPACE_ST = $int2ushort(0x1029);
  
  // End of S_*_ST symbols, which do not appear to be generated by modern
  // compilers.
  public static final /*uint16_t*/char S_ST_MAX = $int2ushort(0x1100);
  public static final /*uint16_t*/char S_WITH32 = $int2ushort(0x1104);
  public static final /*uint16_t*/char S_MANYREG = $int2ushort(0x110A);
  public static final /*uint16_t*/char S_LPROCMIPS = $int2ushort(0x1114);
  public static final /*uint16_t*/char S_GPROCMIPS = $int2ushort(0x1115);
  public static final /*uint16_t*/char S_MANYREG2 = $int2ushort(0x1117);
  public static final /*uint16_t*/char S_LPROCIA64 = $int2ushort(0x1118);
  public static final /*uint16_t*/char S_GPROCIA64 = $int2ushort(0x1119);
  public static final /*uint16_t*/char S_LOCALSLOT = $int2ushort(0x111A);
  public static final /*uint16_t*/char S_PARAMSLOT = $int2ushort(0x111B);
  
  // Managed code symbols.
  public static final /*uint16_t*/char S_MANFRAMEREL = $int2ushort(0x111E);
  public static final /*uint16_t*/char S_MANREGISTER = $int2ushort(0x111F);
  public static final /*uint16_t*/char S_MANSLOT = $int2ushort(0x1120);
  public static final /*uint16_t*/char S_MANMANYREG = $int2ushort(0x1121);
  public static final /*uint16_t*/char S_MANREGREL = $int2ushort(0x1122);
  public static final /*uint16_t*/char S_MANMANYREG2 = $int2ushort(0x1123);
  public static final /*uint16_t*/char S_UNAMESPACE = $int2ushort(0x1124);
  public static final /*uint16_t*/char S_DATAREF = $int2ushort(0x1126);
  public static final /*uint16_t*/char S_ANNOTATIONREF = $int2ushort(0x1128);
  public static final /*uint16_t*/char S_TOKENREF = $int2ushort(0x1129);
  public static final /*uint16_t*/char S_GMANPROC = $int2ushort(0x112A);
  public static final /*uint16_t*/char S_LMANPROC = $int2ushort(0x112B);
  public static final /*uint16_t*/char S_ATTR_FRAMEREL = $int2ushort(0x112E);
  public static final /*uint16_t*/char S_ATTR_REGISTER = $int2ushort(0x112F);
  public static final /*uint16_t*/char S_ATTR_REGREL = $int2ushort(0x1130);
  public static final /*uint16_t*/char S_ATTR_MANYREG = $int2ushort(0x1131);
  public static final /*uint16_t*/char S_SEPCODE = $int2ushort(0x1132);
  public static final /*uint16_t*/char S_LOCAL_2005 = $int2ushort(0x1133);
  public static final /*uint16_t*/char S_DEFRANGE_2005 = $int2ushort(0x1134);
  public static final /*uint16_t*/char S_DEFRANGE2_2005 = $int2ushort(0x1135);
  public static final /*uint16_t*/char S_DISCARDED = $int2ushort(0x113B);
  
  // Current symbol types for most procedures as of this writing.
  public static final /*uint16_t*/char S_LPROCMIPS_ID = $int2ushort(0x1148);
  public static final /*uint16_t*/char S_GPROCMIPS_ID = $int2ushort(0x1149);
  public static final /*uint16_t*/char S_LPROCIA64_ID = $int2ushort(0x114A);
  public static final /*uint16_t*/char S_GPROCIA64_ID = $int2ushort(0x114B);
  public static final /*uint16_t*/char S_DEFRANGE_HLSL = $int2ushort(0x1150);
  public static final /*uint16_t*/char S_GDATA_HLSL = $int2ushort(0x1151);
  public static final /*uint16_t*/char S_LDATA_HLSL = $int2ushort(0x1152);
  public static final /*uint16_t*/char S_LOCAL_DPC_GROUPSHARED = $int2ushort(0x1154);
  public static final /*uint16_t*/char S_DEFRANGE_DPC_PTR_TAG = $int2ushort(0x1157);
  public static final /*uint16_t*/char S_DPC_SYM_TAG_MAP = $int2ushort(0x1158);
  public static final /*uint16_t*/char S_ARMSWITCHTABLE = $int2ushort(0x1159);
  public static final /*uint16_t*/char S_POGODATA = $int2ushort(0x115C);
  public static final /*uint16_t*/char S_INLINESITE2 = $int2ushort(0x115D);
  public static final /*uint16_t*/char S_MOD_TYPEREF = $int2ushort(0x115F);
  public static final /*uint16_t*/char S_REF_MINIPDB = $int2ushort(0x1160);
  public static final /*uint16_t*/char S_PDBMAP = $int2ushort(0x1161);
  public static final /*uint16_t*/char S_GDATA_HLSL32 = $int2ushort(0x1162);
  public static final /*uint16_t*/char S_LDATA_HLSL32 = $int2ushort(0x1163);
  public static final /*uint16_t*/char S_GDATA_HLSL32_EX = $int2ushort(0x1164);
  public static final /*uint16_t*/char S_LDATA_HLSL32_EX = $int2ushort(0x1165);
  
  // Known symbol types
  public static final /*uint16_t*/char S_END = $int2ushort(0x6);
  public static final /*uint16_t*/char S_INLINESITE_END = $int2ushort(0x114E);
  public static final /*uint16_t*/char S_PROC_ID_END = $int2ushort(0x114F);
  public static final /*uint16_t*/char S_THUNK32 = $int2ushort(0x1102);
  public static final /*uint16_t*/char S_TRAMPOLINE = $int2ushort(0x112C);
  public static final /*uint16_t*/char S_SECTION = $int2ushort(0x1136);
  public static final /*uint16_t*/char S_COFFGROUP = $int2ushort(0x1137);
  public static final /*uint16_t*/char S_EXPORT = $int2ushort(0x1138);
  public static final /*uint16_t*/char S_LPROC32 = $int2ushort(0x110F);
  public static final /*uint16_t*/char S_GPROC32 = $int2ushort(0x1110);
  public static final /*uint16_t*/char S_LPROC32_ID = $int2ushort(0x1146);
  public static final /*uint16_t*/char S_GPROC32_ID = $int2ushort(0x1147);
  public static final /*uint16_t*/char S_LPROC32_DPC = $int2ushort(0x1155);
  public static final /*uint16_t*/char S_LPROC32_DPC_ID = $int2ushort(0x1156);
  public static final /*uint16_t*/char S_REGISTER = $int2ushort(0x1106);
  public static final /*uint16_t*/char S_PUB32 = $int2ushort(0x110E);
  public static final /*uint16_t*/char S_PROCREF = $int2ushort(0x1125);
  public static final /*uint16_t*/char S_LPROCREF = $int2ushort(0x1127);
  public static final /*uint16_t*/char S_ENVBLOCK = $int2ushort(0x113D);
  public static final /*uint16_t*/char S_INLINESITE = $int2ushort(0x114D);
  public static final /*uint16_t*/char S_LOCAL = $int2ushort(0x113E);
  public static final /*uint16_t*/char S_DEFRANGE = $int2ushort(0x113F);
  public static final /*uint16_t*/char S_DEFRANGE_SUBFIELD = $int2ushort(0x1140);
  public static final /*uint16_t*/char S_DEFRANGE_REGISTER = $int2ushort(0x1141);
  public static final /*uint16_t*/char S_DEFRANGE_FRAMEPOINTER_REL = $int2ushort(0x1142);
  public static final /*uint16_t*/char S_DEFRANGE_SUBFIELD_REGISTER = $int2ushort(0x1143);
  public static final /*uint16_t*/char S_DEFRANGE_FRAMEPOINTER_REL_FULL_SCOPE = $int2ushort(0x1144);
  public static final /*uint16_t*/char S_DEFRANGE_REGISTER_REL = $int2ushort(0x1145);
  public static final /*uint16_t*/char S_BLOCK32 = $int2ushort(0x1103);
  public static final /*uint16_t*/char S_LABEL32 = $int2ushort(0x1105);
  public static final /*uint16_t*/char S_OBJNAME = $int2ushort(0x1101);
  public static final /*uint16_t*/char S_COMPILE2 = $int2ushort(0x1116);
  public static final /*uint16_t*/char S_COMPILE3 = $int2ushort(0x113C);
  public static final /*uint16_t*/char S_FRAMEPROC = $int2ushort(0x1012);
  public static final /*uint16_t*/char S_CALLSITEINFO = $int2ushort(0x1139);
  public static final /*uint16_t*/char S_FILESTATIC = $int2ushort(0x1153);
  public static final /*uint16_t*/char S_HEAPALLOCSITE = $int2ushort(0x115E);
  public static final /*uint16_t*/char S_FRAMECOOKIE = $int2ushort(0x113A);
  public static final /*uint16_t*/char S_CALLEES = $int2ushort(0x115A);
  public static final /*uint16_t*/char S_CALLERS = $int2ushort(0x115B);
  public static final /*uint16_t*/char S_UDT = $int2ushort(0x1108);
  public static final /*uint16_t*/char S_COBOLUDT = $int2ushort(0x1109);
  public static final /*uint16_t*/char S_BUILDINFO = $int2ushort(0x114C);
  public static final /*uint16_t*/char S_BPREL32 = $int2ushort(0x110B);
  public static final /*uint16_t*/char S_REGREL32 = $int2ushort(0x1111);
  public static final /*uint16_t*/char S_CONSTANT = $int2ushort(0x1107);
  public static final /*uint16_t*/char S_MANCONSTANT = $int2ushort(0x112D);
  public static final /*uint16_t*/char S_LDATA32 = $int2ushort(0x110C);
  public static final /*uint16_t*/char S_GDATA32 = $int2ushort(0x110D);
  public static final /*uint16_t*/char S_LMANDATA = $int2ushort(0x111C);
  public static final /*uint16_t*/char S_GMANDATA = $int2ushort(0x111D);
  public static final /*uint16_t*/char S_LTHREAD32 = $int2ushort(0x1112);
  public static final /*uint16_t*/char S_GTHREAD32 = $int2ushort(0x1113);
}
