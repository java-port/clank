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

package org.llvm.support.dwarf;

import org.clank.support.*;

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::SourceLanguage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 375,
 FQN="llvm::dwarf::SourceLanguage", NM="_ZN4llvm5dwarf14SourceLanguageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf14SourceLanguageE")
//</editor-fold>
public final class/*enum*/ SourceLanguage {
  
  // DWARF languages.
  public static final /*uint*/int DW_LANG_C89 = 0x1;
  public static final /*uint*/int DW_LANG_C = 0x2;
  public static final /*uint*/int DW_LANG_Ada83 = 0x3;
  public static final /*uint*/int DW_LANG_C_plus_plus = 0x4;
  public static final /*uint*/int DW_LANG_Cobol74 = 0x5;
  public static final /*uint*/int DW_LANG_Cobol85 = 0x6;
  public static final /*uint*/int DW_LANG_Fortran77 = 0x7;
  public static final /*uint*/int DW_LANG_Fortran90 = 0x8;
  public static final /*uint*/int DW_LANG_Pascal83 = 0x9;
  public static final /*uint*/int DW_LANG_Modula2 = 0xA;
  public static final /*uint*/int DW_LANG_Java = 0xB;
  public static final /*uint*/int DW_LANG_C99 = 0xC;
  public static final /*uint*/int DW_LANG_Ada95 = 0xD;
  public static final /*uint*/int DW_LANG_Fortran95 = 0xE;
  public static final /*uint*/int DW_LANG_PLI = 0xF;
  public static final /*uint*/int DW_LANG_ObjC = 0x10;
  public static final /*uint*/int DW_LANG_ObjC_plus_plus = 0x11;
  public static final /*uint*/int DW_LANG_UPC = 0x12;
  public static final /*uint*/int DW_LANG_D = 0x13;
  
  // New in DWARF 5:
  public static final /*uint*/int DW_LANG_Python = 0x14;
  public static final /*uint*/int DW_LANG_OpenCL = 0x15;
  public static final /*uint*/int DW_LANG_Go = 0x16;
  public static final /*uint*/int DW_LANG_Modula3 = 0x17;
  public static final /*uint*/int DW_LANG_Haskell = 0x18;
  public static final /*uint*/int DW_LANG_C_plus_plus_03 = 0x19;
  public static final /*uint*/int DW_LANG_C_plus_plus_11 = 0x1A;
  public static final /*uint*/int DW_LANG_OCaml = 0x1B;
  public static final /*uint*/int DW_LANG_Rust = 0x1C;
  public static final /*uint*/int DW_LANG_C11 = 0x1D;
  public static final /*uint*/int DW_LANG_Swift = 0x1E;
  public static final /*uint*/int DW_LANG_Julia = 0x1F;
  public static final /*uint*/int DW_LANG_Dylan = 0x20;
  public static final /*uint*/int DW_LANG_C_plus_plus_14 = 0x21;
  public static final /*uint*/int DW_LANG_Fortran03 = 0x22;
  public static final /*uint*/int DW_LANG_Fortran08 = 0x23;
  public static final /*uint*/int DW_LANG_Mips_Assembler = 0x8001;
  public static final /*uint*/int DW_LANG_GOOGLE_RenderScript = 0x8E57;
  public static final /*uint*/int DW_LANG_BORLAND_Delphi = 0xB000;
  public static final /*uint*/int DW_LANG_lo_user = 0x8000;
  public static final /*uint*/int DW_LANG_hi_user = 0xffff;
}
