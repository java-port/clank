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


/// Distinguishes individual records in the Symbols subsection of a .debug$S
/// section. Equivalent to SYM_ENUM_e in cvinfo.h.
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::SymbolRecordKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 37,
 FQN="llvm::codeview::SymbolRecordKind", NM="_ZN4llvm8codeview16SymbolRecordKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview16SymbolRecordKindE")
//</editor-fold>
public final class/*enum*/ /*class */SymbolRecordKind/* : uint16_t*/ {
  
  // Known symbol types
  public static final /*uint16_t*/char ScopeEndSym = $int2ushort(0x6);
  public static final /*uint16_t*/char InlineSiteEnd = $int2ushort(0x114E);
  public static final /*uint16_t*/char ProcEnd = $int2ushort(0x114F);
  public static final /*uint16_t*/char Thunk32Sym = $int2ushort(0x1102);
  public static final /*uint16_t*/char TrampolineSym = $int2ushort(0x112C);
  public static final /*uint16_t*/char SectionSym = $int2ushort(0x1136);
  public static final /*uint16_t*/char CoffGroupSym = $int2ushort(0x1137);
  public static final /*uint16_t*/char ExportSym = $int2ushort(0x1138);
  public static final /*uint16_t*/char ProcSym = $int2ushort(0x110F);
  public static final /*uint16_t*/char GlobalProcSym = $int2ushort(0x1110);
  public static final /*uint16_t*/char ProcIdSym = $int2ushort(0x1146);
  public static final /*uint16_t*/char GlobalProcIdSym = $int2ushort(0x1147);
  public static final /*uint16_t*/char DPCProcSym = $int2ushort(0x1155);
  public static final /*uint16_t*/char DPCProcIdSym = $int2ushort(0x1156);
  public static final /*uint16_t*/char RegisterSym = $int2ushort(0x1106);
  public static final /*uint16_t*/char PublicSym32 = $int2ushort(0x110E);
  public static final /*uint16_t*/char ProcRefSym = $int2ushort(0x1125);
  public static final /*uint16_t*/char LocalProcRef = $int2ushort(0x1127);
  public static final /*uint16_t*/char EnvBlockSym = $int2ushort(0x113D);
  public static final /*uint16_t*/char InlineSiteSym = $int2ushort(0x114D);
  public static final /*uint16_t*/char LocalSym = $int2ushort(0x113E);
  public static final /*uint16_t*/char DefRangeSym = $int2ushort(0x113F);
  public static final /*uint16_t*/char DefRangeSubfieldSym = $int2ushort(0x1140);
  public static final /*uint16_t*/char DefRangeRegisterSym = $int2ushort(0x1141);
  public static final /*uint16_t*/char DefRangeFramePointerRelSym = $int2ushort(0x1142);
  public static final /*uint16_t*/char DefRangeSubfieldRegisterSym = $int2ushort(0x1143);
  public static final /*uint16_t*/char DefRangeFramePointerRelFullScopeSym = $int2ushort(0x1144);
  public static final /*uint16_t*/char DefRangeRegisterRelSym = $int2ushort(0x1145);
  public static final /*uint16_t*/char BlockSym = $int2ushort(0x1103);
  public static final /*uint16_t*/char LabelSym = $int2ushort(0x1105);
  public static final /*uint16_t*/char ObjNameSym = $int2ushort(0x1101);
  public static final /*uint16_t*/char Compile2Sym = $int2ushort(0x1116);
  public static final /*uint16_t*/char Compile3Sym = $int2ushort(0x113C);
  public static final /*uint16_t*/char FrameProcSym = $int2ushort(0x1012);
  public static final /*uint16_t*/char CallSiteInfoSym = $int2ushort(0x1139);
  public static final /*uint16_t*/char FileStaticSym = $int2ushort(0x1153);
  public static final /*uint16_t*/char HeapAllocationSiteSym = $int2ushort(0x115E);
  public static final /*uint16_t*/char FrameCookieSym = $int2ushort(0x113A);
  public static final /*uint16_t*/char CallerSym = $int2ushort(0x115A);
  public static final /*uint16_t*/char CalleeSym = $int2ushort(0x115B);
  public static final /*uint16_t*/char UDTSym = $int2ushort(0x1108);
  public static final /*uint16_t*/char CobolUDT = $int2ushort(0x1109);
  public static final /*uint16_t*/char BuildInfoSym = $int2ushort(0x114C);
  public static final /*uint16_t*/char BPRelativeSym = $int2ushort(0x110B);
  public static final /*uint16_t*/char RegRelativeSym = $int2ushort(0x1111);
  public static final /*uint16_t*/char ConstantSym = $int2ushort(0x1107);
  public static final /*uint16_t*/char ManagedConstant = $int2ushort(0x112D);
  public static final /*uint16_t*/char DataSym = $int2ushort(0x110C);
  public static final /*uint16_t*/char GlobalData = $int2ushort(0x110D);
  public static final /*uint16_t*/char ManagedLocalData = $int2ushort(0x111C);
  public static final /*uint16_t*/char ManagedGlobalData = $int2ushort(0x111D);
  public static final /*uint16_t*/char ThreadLocalDataSym = $int2ushort(0x1112);
  public static final /*uint16_t*/char GlobalTLS = $int2ushort(0x1113);
}
