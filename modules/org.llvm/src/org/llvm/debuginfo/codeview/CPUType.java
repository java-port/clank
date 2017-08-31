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


/// These values correspond to the CV_CPU_TYPE_e enumeration, and are documented
/// here: https://msdn.microsoft.com/en-us/library/b2fc64ek.aspx
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::CPUType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 75,
 FQN="llvm::codeview::CPUType", NM="_ZN4llvm8codeview7CPUTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview7CPUTypeE")
//</editor-fold>
public final class/*enum*/ /*class */CPUType/* : uint16_t*/ {
  public static final /*uint16_t*/char Intel8080 = $int2ushort(0x0);
  public static final /*uint16_t*/char Intel8086 = $int2ushort(0x1);
  public static final /*uint16_t*/char Intel80286 = $int2ushort(0x2);
  public static final /*uint16_t*/char Intel80386 = $int2ushort(0x3);
  public static final /*uint16_t*/char Intel80486 = $int2ushort(0x4);
  public static final /*uint16_t*/char Pentium = $int2ushort(0x5);
  public static final /*uint16_t*/char PentiumPro = $int2ushort(0x6);
  public static final /*uint16_t*/char Pentium3 = $int2ushort(0x7);
  public static final /*uint16_t*/char MIPS = $int2ushort(0x10);
  public static final /*uint16_t*/char MIPS16 = $int2ushort(0x11);
  public static final /*uint16_t*/char MIPS32 = $int2ushort(0x12);
  public static final /*uint16_t*/char MIPS64 = $int2ushort(0x13);
  public static final /*uint16_t*/char MIPSI = $int2ushort(0x14);
  public static final /*uint16_t*/char MIPSII = $int2ushort(0x15);
  public static final /*uint16_t*/char MIPSIII = $int2ushort(0x16);
  public static final /*uint16_t*/char MIPSIV = $int2ushort(0x17);
  public static final /*uint16_t*/char MIPSV = $int2ushort(0x18);
  public static final /*uint16_t*/char M68000 = $int2ushort(0x20);
  public static final /*uint16_t*/char M68010 = $int2ushort(0x21);
  public static final /*uint16_t*/char M68020 = $int2ushort(0x22);
  public static final /*uint16_t*/char M68030 = $int2ushort(0x23);
  public static final /*uint16_t*/char M68040 = $int2ushort(0x24);
  public static final /*uint16_t*/char Alpha = $int2ushort(0x30);
  public static final /*uint16_t*/char Alpha21164 = $int2ushort(0x31);
  public static final /*uint16_t*/char Alpha21164A = $int2ushort(0x32);
  public static final /*uint16_t*/char Alpha21264 = $int2ushort(0x33);
  public static final /*uint16_t*/char Alpha21364 = $int2ushort(0x34);
  public static final /*uint16_t*/char PPC601 = $int2ushort(0x40);
  public static final /*uint16_t*/char PPC603 = $int2ushort(0x41);
  public static final /*uint16_t*/char PPC604 = $int2ushort(0x42);
  public static final /*uint16_t*/char PPC620 = $int2ushort(0x43);
  public static final /*uint16_t*/char PPCFP = $int2ushort(0x44);
  public static final /*uint16_t*/char PPCBE = $int2ushort(0x45);
  public static final /*uint16_t*/char SH3 = $int2ushort(0x50);
  public static final /*uint16_t*/char SH3E = $int2ushort(0x51);
  public static final /*uint16_t*/char SH3DSP = $int2ushort(0x52);
  public static final /*uint16_t*/char SH4 = $int2ushort(0x53);
  public static final /*uint16_t*/char SHMedia = $int2ushort(0x54);
  public static final /*uint16_t*/char ARM3 = $int2ushort(0x60);
  public static final /*uint16_t*/char ARM4 = $int2ushort(0x61);
  public static final /*uint16_t*/char ARM4T = $int2ushort(0x62);
  public static final /*uint16_t*/char ARM5 = $int2ushort(0x63);
  public static final /*uint16_t*/char ARM5T = $int2ushort(0x64);
  public static final /*uint16_t*/char ARM6 = $int2ushort(0x65);
  public static final /*uint16_t*/char ARM_XMAC = $int2ushort(0x66);
  public static final /*uint16_t*/char ARM_WMMX = $int2ushort(0x67);
  public static final /*uint16_t*/char ARM7 = $int2ushort(0x68);
  public static final /*uint16_t*/char Omni = $int2ushort(0x70);
  public static final /*uint16_t*/char Ia64 = $int2ushort(0x80);
  public static final /*uint16_t*/char Ia64_2 = $int2ushort(0x81);
  public static final /*uint16_t*/char CEE = $int2ushort(0x90);
  public static final /*uint16_t*/char AM33 = $int2ushort(0xa0);
  public static final /*uint16_t*/char M32R = $int2ushort(0xb0);
  public static final /*uint16_t*/char TriCore = $int2ushort(0xc0);
  public static final /*uint16_t*/char X64 = $int2ushort(0xd0);
  public static final /*uint16_t*/char EBC = $int2ushort(0xe0);
  public static final /*uint16_t*/char Thumb = $int2ushort(0xf0);
  public static final /*uint16_t*/char ARMNT = $int2ushort(0xf4);
  public static final /*uint16_t*/char D3D11_Shader = $int2ushort(0x100);
}
