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


/// These values correspond to the CV_call_e enumeration, and are documented
/// at the following locations:
///   https://msdn.microsoft.com/en-us/library/b2fc64ek.aspx
///   https://msdn.microsoft.com/en-us/library/windows/desktop/ms680207(v=vs.85).aspx
///
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::CallingConvention">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 164,
 FQN="llvm::codeview::CallingConvention", NM="_ZN4llvm8codeview17CallingConventionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview17CallingConventionE")
//</editor-fold>
public final class/*enum*/ /*class */CallingConvention/* : uint8_t*/ {
  public static final byte/*uint8_t*/ NearC = $int2uchar(0x00); // near right to left push, caller pops stack
  public static final byte/*uint8_t*/ FarC = $int2uchar(0x01); // far right to left push, caller pops stack
  public static final byte/*uint8_t*/ NearPascal = $int2uchar(0x02); // near left to right push, callee pops stack
  public static final byte/*uint8_t*/ FarPascal = $int2uchar(0x03); // far left to right push, callee pops stack
  public static final byte/*uint8_t*/ NearFast = $int2uchar(0x04); // near left to right push with regs, callee pops stack
  public static final byte/*uint8_t*/ FarFast = $int2uchar(0x05); // far left to right push with regs, callee pops stack
  public static final byte/*uint8_t*/ NearStdCall = $int2uchar(0x07); // near standard call
  public static final byte/*uint8_t*/ FarStdCall = $int2uchar(0x08); // far standard call
  public static final byte/*uint8_t*/ NearSysCall = $int2uchar(0x09); // near sys call
  public static final byte/*uint8_t*/ FarSysCall = $int2uchar(0x0a); // far sys call
  public static final byte/*uint8_t*/ ThisCall = $int2uchar(0x0b); // this call (this passed in register)
  public static final byte/*uint8_t*/ MipsCall = $int2uchar(0x0c); // Mips call
  public static final byte/*uint8_t*/ Generic = $int2uchar(0x0d); // Generic call sequence
  public static final byte/*uint8_t*/ AlphaCall = $int2uchar(0x0e); // Alpha call
  public static final byte/*uint8_t*/ PpcCall = $int2uchar(0x0f); // PPC call
  public static final byte/*uint8_t*/ SHCall = $int2uchar(0x10); // Hitachi SuperH call
  public static final byte/*uint8_t*/ ArmCall = $int2uchar(0x11); // ARM call
  public static final byte/*uint8_t*/ AM33Call = $int2uchar(0x12); // AM33 call
  public static final byte/*uint8_t*/ TriCall = $int2uchar(0x13); // TriCore Call
  public static final byte/*uint8_t*/ SH5Call = $int2uchar(0x14); // Hitachi SuperH-5 call
  public static final byte/*uint8_t*/ M32RCall = $int2uchar(0x15); // M32R Call
  public static final byte/*uint8_t*/ ClrCall = $int2uchar(0x16); // clr call
  public static final byte/*uint8_t*/ Inline = $int2uchar(0x17); // Marker for routines always inlined and thus lacking a convention
  public static final byte/*uint8_t*/ NearVector = $int2uchar(0x18); // near left to right push with regs, callee pops stack
}
