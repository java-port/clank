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
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeLeafKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 30,
 FQN="llvm::codeview::TypeLeafKind", NM="_ZN4llvm8codeview12TypeLeafKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview12TypeLeafKindE")
//</editor-fold>
public final class/*enum*/ TypeLeafKind/* : uint16_t*/ {
  public static final /*uint16_t*/char LF_POINTER = $int2ushort(0x1002);
  public static final /*uint16_t*/char LF_MODIFIER = $int2ushort(0x1001);
  public static final /*uint16_t*/char LF_PROCEDURE = $int2ushort(0x1008);
  public static final /*uint16_t*/char LF_MFUNCTION = $int2ushort(0x1009);
  public static final /*uint16_t*/char LF_ARGLIST = $int2ushort(0x1201);
  public static final /*uint16_t*/char LF_ARRAY = $int2ushort(0x1503);
  public static final /*uint16_t*/char LF_CLASS = $int2ushort(0x1504);
  public static final /*uint16_t*/char LF_STRUCTURE = $int2ushort(0x1505);
  public static final /*uint16_t*/char LF_INTERFACE = $int2ushort(0x1519);
  public static final /*uint16_t*/char LF_UNION = $int2ushort(0x1506);
  public static final /*uint16_t*/char LF_ENUM = $int2ushort(0x1507);
  public static final /*uint16_t*/char LF_TYPESERVER2 = $int2ushort(0x1515);
  public static final /*uint16_t*/char LF_VFTABLE = $int2ushort(0x151D);
  public static final /*uint16_t*/char LF_VTSHAPE = $int2ushort(0xA);
  public static final /*uint16_t*/char LF_BITFIELD = $int2ushort(0x1205);
  
  // Member type records. These are generally not length prefixed, and appear
  // inside of a field list record.
  public static final /*uint16_t*/char LF_BCLASS = $int2ushort(0x1400);
  public static final /*uint16_t*/char LF_BINTERFACE = $int2ushort(0x151A);
  public static final /*uint16_t*/char LF_VBCLASS = $int2ushort(0x1401);
  public static final /*uint16_t*/char LF_IVBCLASS = $int2ushort(0x1402);
  public static final /*uint16_t*/char LF_VFUNCTAB = $int2ushort(0x1409);
  public static final /*uint16_t*/char LF_STMEMBER = $int2ushort(0x150E);
  public static final /*uint16_t*/char LF_METHOD = $int2ushort(0x150F);
  public static final /*uint16_t*/char LF_MEMBER = $int2ushort(0x150D);
  public static final /*uint16_t*/char LF_NESTTYPE = $int2ushort(0x1510);
  public static final /*uint16_t*/char LF_ONEMETHOD = $int2ushort(0x1511);
  public static final /*uint16_t*/char LF_ENUMERATE = $int2ushort(0x1502);
  public static final /*uint16_t*/char LF_INDEX = $int2ushort(0x1404);
  
  // ID leaf records. Subsequent leaf types may be referenced from .debug$S.
  public static final /*uint16_t*/char LF_FUNC_ID = $int2ushort(0x1601);
  public static final /*uint16_t*/char LF_MFUNC_ID = $int2ushort(0x1602);
  public static final /*uint16_t*/char LF_BUILDINFO = $int2ushort(0x1603);
  // FIXME: We reuse the structure of ArgListRecord for substring lists, but it
  // makes for confusing dumper output.
  public static final /*uint16_t*/char LF_SUBSTR_LIST = $int2ushort(0x1604);
  public static final /*uint16_t*/char LF_STRING_ID = $int2ushort(0x1605);
  public static final /*uint16_t*/char LF_UDT_SRC_LINE = $int2ushort(0x1606);
  public static final /*uint16_t*/char LF_UDT_MOD_SRC_LINE = $int2ushort(0x1607);
  public static final /*uint16_t*/char LF_METHODLIST = $int2ushort(0x1206);
  
  // 16 bit type records.
  public static final /*uint16_t*/char LF_MODIFIER_16t = $int2ushort(0x1);
  public static final /*uint16_t*/char LF_POINTER_16t = $int2ushort(0x2);
  public static final /*uint16_t*/char LF_ARRAY_16t = $int2ushort(0x3);
  public static final /*uint16_t*/char LF_CLASS_16t = $int2ushort(0x4);
  public static final /*uint16_t*/char LF_STRUCTURE_16t = $int2ushort(0x5);
  public static final /*uint16_t*/char LF_UNION_16t = $int2ushort(0x6);
  public static final /*uint16_t*/char LF_ENUM_16t = $int2ushort(0x7);
  public static final /*uint16_t*/char LF_PROCEDURE_16t = $int2ushort(0x8);
  public static final /*uint16_t*/char LF_MFUNCTION_16t = $int2ushort(0x9);
  public static final /*uint16_t*/char LF_COBOL0_16t = $int2ushort(0xB);
  public static final /*uint16_t*/char LF_COBOL1 = $int2ushort(0xC);
  public static final /*uint16_t*/char LF_BARRAY_16t = $int2ushort(0xD);
  public static final /*uint16_t*/char LF_LABEL = $int2ushort(0xE);
  public static final /*uint16_t*/char LF_NULLLEAF = $int2ushort(0xF);
  // LF_NULL
  public static final /*uint16_t*/char LF_NOTTRAN = $int2ushort(0x10);
  public static final /*uint16_t*/char LF_DIMARRAY_16t = $int2ushort(0x11);
  public static final /*uint16_t*/char LF_VFTPATH_16t = $int2ushort(0x12);
  public static final /*uint16_t*/char LF_PRECOMP_16t = $int2ushort(0x13);
  public static final /*uint16_t*/char LF_ENDPRECOMP = $int2ushort(0x14);
  public static final /*uint16_t*/char LF_OEM_16t = $int2ushort(0x15);
  public static final /*uint16_t*/char LF_TYPESERVER_ST = $int2ushort(0x16);
  public static final /*uint16_t*/char LF_SKIP_16t = $int2ushort(0x200);
  public static final /*uint16_t*/char LF_ARGLIST_16t = $int2ushort(0x201);
  public static final /*uint16_t*/char LF_DEFARG_16t = $int2ushort(0x202);
  public static final /*uint16_t*/char LF_LIST = $int2ushort(0x203);
  public static final /*uint16_t*/char LF_FIELDLIST_16t = $int2ushort(0x204);
  public static final /*uint16_t*/char LF_DERIVED_16t = $int2ushort(0x205);
  public static final /*uint16_t*/char LF_BITFIELD_16t = $int2ushort(0x206);
  public static final /*uint16_t*/char LF_METHODLIST_16t = $int2ushort(0x207);
  public static final /*uint16_t*/char LF_DIMCONU_16t = $int2ushort(0x208);
  public static final /*uint16_t*/char LF_DIMCONLU_16t = $int2ushort(0x209);
  public static final /*uint16_t*/char LF_DIMVARU_16t = $int2ushort(0x20A);
  public static final /*uint16_t*/char LF_DIMVARLU_16t = $int2ushort(0x20B);
  public static final /*uint16_t*/char LF_REFSYM = $int2ushort(0x20C);
  
  // 16 bit member types. Generally not length prefixed.
  public static final /*uint16_t*/char LF_BCLASS_16t = $int2ushort(0x400);
  public static final /*uint16_t*/char LF_VBCLASS_16t = $int2ushort(0x401);
  public static final /*uint16_t*/char LF_IVBCLASS_16t = $int2ushort(0x402);
  public static final /*uint16_t*/char LF_ENUMERATE_ST = $int2ushort(0x403);
  public static final /*uint16_t*/char LF_FRIENDFCN_16t = $int2ushort(0x404);
  public static final /*uint16_t*/char LF_INDEX_16t = $int2ushort(0x405);
  public static final /*uint16_t*/char LF_MEMBER_16t = $int2ushort(0x406);
  public static final /*uint16_t*/char LF_STMEMBER_16t = $int2ushort(0x407);
  public static final /*uint16_t*/char LF_METHOD_16t = $int2ushort(0x408);
  public static final /*uint16_t*/char LF_NESTTYPE_16t = $int2ushort(0x409);
  public static final /*uint16_t*/char LF_VFUNCTAB_16t = $int2ushort(0x40A);
  public static final /*uint16_t*/char LF_FRIENDCLS_16t = $int2ushort(0x40B);
  public static final /*uint16_t*/char LF_ONEMETHOD_16t = $int2ushort(0x40C);
  public static final /*uint16_t*/char LF_VFUNCOFF_16t = $int2ushort(0x40D);
  public static final /*uint16_t*/char LF_TI16_MAX = $int2ushort(0x1000);
  public static final /*uint16_t*/char LF_ARRAY_ST = $int2ushort(0x1003);
  public static final /*uint16_t*/char LF_CLASS_ST = $int2ushort(0x1004);
  public static final /*uint16_t*/char LF_STRUCTURE_ST = $int2ushort(0x1005);
  public static final /*uint16_t*/char LF_UNION_ST = $int2ushort(0x1006);
  public static final /*uint16_t*/char LF_ENUM_ST = $int2ushort(0x1007);
  public static final /*uint16_t*/char LF_COBOL0 = $int2ushort(0x100A);
  public static final /*uint16_t*/char LF_BARRAY = $int2ushort(0x100B);
  public static final /*uint16_t*/char LF_DIMARRAY_ST = $int2ushort(0x100C);
  public static final /*uint16_t*/char LF_VFTPATH = $int2ushort(0x100D);
  public static final /*uint16_t*/char LF_PRECOMP_ST = $int2ushort(0x100E);
  public static final /*uint16_t*/char LF_OEM = $int2ushort(0x100F);
  public static final /*uint16_t*/char LF_ALIAS_ST = $int2ushort(0x1010);
  public static final /*uint16_t*/char LF_OEM2 = $int2ushort(0x1011);
  public static final /*uint16_t*/char LF_SKIP = $int2ushort(0x1200);
  public static final /*uint16_t*/char LF_DEFARG_ST = $int2ushort(0x1202);
  public static final /*uint16_t*/char LF_FIELDLIST = $int2ushort(0x1203);
  public static final /*uint16_t*/char LF_DERIVED = $int2ushort(0x1204);
  public static final /*uint16_t*/char LF_DIMCONU = $int2ushort(0x1207);
  public static final /*uint16_t*/char LF_DIMCONLU = $int2ushort(0x1208);
  public static final /*uint16_t*/char LF_DIMVARU = $int2ushort(0x1209);
  public static final /*uint16_t*/char LF_DIMVARLU = $int2ushort(0x120A);
  
  // Member type records. These are generally not length prefixed, and appear
  // inside of a field list record.
  public static final /*uint16_t*/char LF_FRIENDFCN_ST = $int2ushort(0x1403);
  public static final /*uint16_t*/char LF_MEMBER_ST = $int2ushort(0x1405);
  public static final /*uint16_t*/char LF_STMEMBER_ST = $int2ushort(0x1406);
  public static final /*uint16_t*/char LF_METHOD_ST = $int2ushort(0x1407);
  public static final /*uint16_t*/char LF_NESTTYPE_ST = $int2ushort(0x1408);
  public static final /*uint16_t*/char LF_FRIENDCLS = $int2ushort(0x140A);
  public static final /*uint16_t*/char LF_ONEMETHOD_ST = $int2ushort(0x140B);
  public static final /*uint16_t*/char LF_VFUNCOFF = $int2ushort(0x140C);
  public static final /*uint16_t*/char LF_NESTTYPEEX_ST = $int2ushort(0x140D);
  public static final /*uint16_t*/char LF_MEMBERMODIFY_ST = $int2ushort(0x140E);
  public static final /*uint16_t*/char LF_MANAGED_ST = $int2ushort(0x140F);
  public static final /*uint16_t*/char LF_ST_MAX = $int2ushort(0x1500);
  public static final /*uint16_t*/char LF_TYPESERVER = $int2ushort(0x1501);
  public static final /*uint16_t*/char LF_DIMARRAY = $int2ushort(0x1508);
  public static final /*uint16_t*/char LF_PRECOMP = $int2ushort(0x1509);
  public static final /*uint16_t*/char LF_ALIAS = $int2ushort(0x150A);
  public static final /*uint16_t*/char LF_DEFARG = $int2ushort(0x150B);
  public static final /*uint16_t*/char LF_FRIENDFCN = $int2ushort(0x150C);
  public static final /*uint16_t*/char LF_NESTTYPEEX = $int2ushort(0x1512);
  public static final /*uint16_t*/char LF_MEMBERMODIFY = $int2ushort(0x1513);
  public static final /*uint16_t*/char LF_MANAGED = $int2ushort(0x1514);
  public static final /*uint16_t*/char LF_STRIDED_ARRAY = $int2ushort(0x1516);
  public static final /*uint16_t*/char LF_HLSL = $int2ushort(0x1517);
  public static final /*uint16_t*/char LF_MODIFIER_EX = $int2ushort(0x1518);
  public static final /*uint16_t*/char LF_VECTOR = $int2ushort(0x151B);
  public static final /*uint16_t*/char LF_MATRIX = $int2ushort(0x151C);
  
  // ID leaf records. Subsequent leaf types may be referenced from .debug$S.
  
  // Numeric leaf types. These are generally contained in other records, and not
  // encountered in the main type stream.
  public static final /*uint16_t*/char LF_NUMERIC = $int2ushort(0x8000);
  public static final /*uint16_t*/char LF_CHAR = $int2ushort(0x8000);
  public static final /*uint16_t*/char LF_SHORT = $int2ushort(0x8001);
  public static final /*uint16_t*/char LF_USHORT = $int2ushort(0x8002);
  public static final /*uint16_t*/char LF_LONG = $int2ushort(0x8003);
  public static final /*uint16_t*/char LF_ULONG = $int2ushort(0x8004);
  public static final /*uint16_t*/char LF_REAL32 = $int2ushort(0x8005);
  public static final /*uint16_t*/char LF_REAL64 = $int2ushort(0x8006);
  public static final /*uint16_t*/char LF_REAL80 = $int2ushort(0x8007);
  public static final /*uint16_t*/char LF_REAL128 = $int2ushort(0x8008);
  public static final /*uint16_t*/char LF_QUADWORD = $int2ushort(0x8009);
  public static final /*uint16_t*/char LF_UQUADWORD = $int2ushort(0x800A);
  public static final /*uint16_t*/char LF_REAL48 = $int2ushort(0x800B);
  public static final /*uint16_t*/char LF_COMPLEX32 = $int2ushort(0x800C);
  public static final /*uint16_t*/char LF_COMPLEX64 = $int2ushort(0x800D);
  public static final /*uint16_t*/char LF_COMPLEX80 = $int2ushort(0x800E);
  public static final /*uint16_t*/char LF_COMPLEX128 = $int2ushort(0x800F);
  public static final /*uint16_t*/char LF_VARSTRING = $int2ushort(0x8010);
  public static final /*uint16_t*/char LF_OCTWORD = $int2ushort(0x8017);
  public static final /*uint16_t*/char LF_UOCTWORD = $int2ushort(0x8018);
  public static final /*uint16_t*/char LF_DECIMAL = $int2ushort(0x8019);
  public static final /*uint16_t*/char LF_DATE = $int2ushort(0x801A);
  public static final /*uint16_t*/char LF_UTF8STRING = $int2ushort(0x801B);
  public static final /*uint16_t*/char LF_REAL16 = $int2ushort(0x801C);
  
  // Padding bytes. These are emitted into alignment bytes in the type stream.
  public static final /*uint16_t*/char LF_PAD0 = $int2ushort(0xF0);
  public static final /*uint16_t*/char LF_PAD1 = $int2ushort(0xF1);
  public static final /*uint16_t*/char LF_PAD2 = $int2ushort(0xF2);
  public static final /*uint16_t*/char LF_PAD3 = $int2ushort(0xF3);
  public static final /*uint16_t*/char LF_PAD4 = $int2ushort(0xF4);
  public static final /*uint16_t*/char LF_PAD5 = $int2ushort(0xF5);
  public static final /*uint16_t*/char LF_PAD6 = $int2ushort(0xF6);
  public static final /*uint16_t*/char LF_PAD7 = $int2ushort(0xF7);
  public static final /*uint16_t*/char LF_PAD8 = $int2ushort(0xF8);
  public static final /*uint16_t*/char LF_PAD9 = $int2ushort(0xF9);
  public static final /*uint16_t*/char LF_PAD10 = $int2ushort(0xFA);
  public static final /*uint16_t*/char LF_PAD11 = $int2ushort(0xFB);
  public static final /*uint16_t*/char LF_PAD12 = $int2ushort(0xFC);
  public static final /*uint16_t*/char LF_PAD13 = $int2ushort(0xFD);
  public static final /*uint16_t*/char LF_PAD14 = $int2ushort(0xFE);
  public static final /*uint16_t*/char LF_PAD15 = $int2ushort(0xFF);
}
