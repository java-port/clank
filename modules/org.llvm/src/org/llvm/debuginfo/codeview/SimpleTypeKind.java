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

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::SimpleTypeKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 20,
 FQN="llvm::codeview::SimpleTypeKind", NM="_ZN4llvm8codeview14SimpleTypeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview14SimpleTypeKindE")
//</editor-fold>
public final class/*enum*/ /*class */SimpleTypeKind/* : uint32_t*/ {
  public static final /*uint32_t*/int None = 0x0000; // uncharacterized type (no type)
  public static final /*uint32_t*/int Void = 0x0003; // void
  public static final /*uint32_t*/int NotTranslated = 0x0007; // type not translated by cvpack
  public static final /*uint32_t*/int HResult = 0x0008; // OLE/COM HRESULT
  
  public static final /*uint32_t*/int SignedCharacter = 0x0010; // 8 bit signed
  public static final /*uint32_t*/int UnsignedCharacter = 0x0020; // 8 bit unsigned
  public static final /*uint32_t*/int NarrowCharacter = 0x0070; // really a char
  public static final /*uint32_t*/int WideCharacter = 0x0071; // wide char
  public static final /*uint32_t*/int Character16 = 0x007a; // char16_t
  public static final /*uint32_t*/int Character32 = 0x007b; // char32_t
  
  public static final /*uint32_t*/int SByte = 0x0068; // 8 bit signed int
  public static final /*uint32_t*/int Byte = 0x0069; // 8 bit unsigned int
  public static final /*uint32_t*/int Int16Short = 0x0011; // 16 bit signed
  public static final /*uint32_t*/int UInt16Short = 0x0021; // 16 bit unsigned
  public static final /*uint32_t*/int Int16 = 0x0072; // 16 bit signed int
  public static final /*uint32_t*/int UInt16 = 0x0073; // 16 bit unsigned int
  public static final /*uint32_t*/int Int32Long = 0x0012; // 32 bit signed
  public static final /*uint32_t*/int UInt32Long = 0x0022; // 32 bit unsigned
  public static final /*uint32_t*/int Int32 = 0x0074; // 32 bit signed int
  public static final /*uint32_t*/int UInt32 = 0x0075; // 32 bit unsigned int
  public static final /*uint32_t*/int Int64Quad = 0x0013; // 64 bit signed
  public static final /*uint32_t*/int UInt64Quad = 0x0023; // 64 bit unsigned
  public static final /*uint32_t*/int Int64 = 0x0076; // 64 bit signed int
  public static final /*uint32_t*/int UInt64 = 0x0077; // 64 bit unsigned int
  public static final /*uint32_t*/int Int128Oct = 0x0014; // 128 bit signed int
  public static final /*uint32_t*/int UInt128Oct = 0x0024; // 128 bit unsigned int
  public static final /*uint32_t*/int Int128 = 0x0078; // 128 bit signed int
  public static final /*uint32_t*/int UInt128 = 0x0079; // 128 bit unsigned int
  
  public static final /*uint32_t*/int Float16 = 0x0046; // 16 bit real
  public static final /*uint32_t*/int Float32 = 0x0040; // 32 bit real
  public static final /*uint32_t*/int Float32PartialPrecision = 0x0045; // 32 bit PP real
  public static final /*uint32_t*/int Float48 = 0x0044; // 48 bit real
  public static final /*uint32_t*/int Float64 = 0x0041; // 64 bit real
  public static final /*uint32_t*/int Float80 = 0x0042; // 80 bit real
  public static final /*uint32_t*/int Float128 = 0x0043; // 128 bit real
  
  public static final /*uint32_t*/int Complex16 = 0x0056; // 16 bit complex
  public static final /*uint32_t*/int Complex32 = 0x0050; // 32 bit complex
  public static final /*uint32_t*/int Complex32PartialPrecision = 0x0055; // 32 bit PP complex
  public static final /*uint32_t*/int Complex48 = 0x0054; // 48 bit complex
  public static final /*uint32_t*/int Complex64 = 0x0051; // 64 bit complex
  public static final /*uint32_t*/int Complex80 = 0x0052; // 80 bit complex
  public static final /*uint32_t*/int Complex128 = 0x0053; // 128 bit complex
  
  public static final /*uint32_t*/int Boolean8 = 0x0030; // 8 bit boolean
  public static final /*uint32_t*/int Boolean16 = 0x0031; // 16 bit boolean
  public static final /*uint32_t*/int Boolean32 = 0x0032; // 32 bit boolean
  public static final /*uint32_t*/int Boolean64 = 0x0033; // 64 bit boolean
  public static final /*uint32_t*/int Boolean128 = 0x0034; // 128 bit boolean
}
