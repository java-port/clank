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


/// Distinguishes individual records in .debug$T section or PDB type stream. The
/// documentation and headers talk about this as the "leaf" type.
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeRecordKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 21,
 FQN="llvm::codeview::TypeRecordKind", NM="_ZN4llvm8codeview14TypeRecordKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview14TypeRecordKindE")
//</editor-fold>
public final class/*enum*/ /*class */TypeRecordKind/* : uint16_t*/ {
  public static final /*uint16_t*/char Pointer = $int2ushort(0x1002);
  public static final /*uint16_t*/char Modifier = $int2ushort(0x1001);
  public static final /*uint16_t*/char Procedure = $int2ushort(0x1008);
  public static final /*uint16_t*/char MemberFunction = $int2ushort(0x1009);
  public static final /*uint16_t*/char ArgList = $int2ushort(0x1201);
  public static final /*uint16_t*/char Array = $int2ushort(0x1503);
  public static final /*uint16_t*/char Class = $int2ushort(0x1504);
  public static final /*uint16_t*/char Struct = $int2ushort(0x1505);
  public static final /*uint16_t*/char Interface = $int2ushort(0x1519);
  public static final /*uint16_t*/char Union = $int2ushort(0x1506);
  public static final /*uint16_t*/char Enum = $int2ushort(0x1507);
  public static final /*uint16_t*/char TypeServer2 = $int2ushort(0x1515);
  public static final /*uint16_t*/char VFTable = $int2ushort(0x151D);
  public static final /*uint16_t*/char VFTableShape = $int2ushort(0xA);
  public static final /*uint16_t*/char BitField = $int2ushort(0x1205);
  
  // Member type records. These are generally not length prefixed, and appear
  // inside of a field list record.
  public static final /*uint16_t*/char BaseClass = $int2ushort(0x1400);
  public static final /*uint16_t*/char BaseInterface = $int2ushort(0x151A);
  public static final /*uint16_t*/char VirtualBaseClass = $int2ushort(0x1401);
  public static final /*uint16_t*/char IndirectVirtualBaseClass = $int2ushort(0x1402);
  public static final /*uint16_t*/char VFPtr = $int2ushort(0x1409);
  public static final /*uint16_t*/char StaticDataMember = $int2ushort(0x150E);
  public static final /*uint16_t*/char OverloadedMethod = $int2ushort(0x150F);
  public static final /*uint16_t*/char DataMember = $int2ushort(0x150D);
  public static final /*uint16_t*/char NestedType = $int2ushort(0x1510);
  public static final /*uint16_t*/char OneMethod = $int2ushort(0x1511);
  public static final /*uint16_t*/char Enumerator = $int2ushort(0x1502);
  public static final /*uint16_t*/char ListContinuation = $int2ushort(0x1404);
  
  // ID leaf records. Subsequent leaf types may be referenced from .debug$S.
  public static final /*uint16_t*/char FuncId = $int2ushort(0x1601);
  public static final /*uint16_t*/char MemberFuncId = $int2ushort(0x1602);
  public static final /*uint16_t*/char BuildInfo = $int2ushort(0x1603);
  // FIXME: We reuse the structure of ArgListRecord for substring lists, but it
  // makes for confusing dumper output.
  public static final /*uint16_t*/char StringList = $int2ushort(0x1604);
  public static final /*uint16_t*/char StringId = $int2ushort(0x1605);
  public static final /*uint16_t*/char UdtSourceLine = $int2ushort(0x1606);
  public static final /*uint16_t*/char UdtModSourceLine = $int2ushort(0x1607);
  public static final /*uint16_t*/char MethodOverloadList = $int2ushort(0x1206);
  // FIXME: Add serialization support
  public static final /*uint16_t*/char FieldList = $int2ushort(0x1203);
}
