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

package org.llvm.mc;

import org.clank.support.*;


/// MCFixupKind - Extensible enumeration to represent the type of a fixup.
//<editor-fold defaultstate="collapsed" desc="llvm::MCFixupKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 23,
 FQN = "llvm::MCFixupKind", NM = "_ZN4llvm11MCFixupKindE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCELF.cpp -nm=_ZN4llvm11MCFixupKindE")
//</editor-fold>
public final class/*enum*/ MCFixupKind {
  public static final int FK_Data_1 = 0; ///< A one-byte fixup.
  public static final int FK_Data_2 = 0x1; ///< A two-byte fixup.
  public static final int FK_Data_4 = 0x2; ///< A four-byte fixup.
  public static final int FK_Data_8 = 0x3; ///< A eight-byte fixup.
  public static final int FK_PCRel_1 = 0x4; ///< A one-byte pc relative fixup.
  public static final int FK_PCRel_2 = 0x5; ///< A two-byte pc relative fixup.
  public static final int FK_PCRel_4 = 0x6; ///< A four-byte pc relative fixup.
  public static final int FK_PCRel_8 = 0x7; ///< A eight-byte pc relative fixup.
  public static final int FK_GPRel_1 = 0x8; ///< A one-byte gp relative fixup.
  public static final int FK_GPRel_2 = 0x9; ///< A two-byte gp relative fixup.
  public static final int FK_GPRel_4 = 0xA; ///< A four-byte gp relative fixup.
  public static final int FK_GPRel_8 = 0xB; ///< A eight-byte gp relative fixup.
  public static final int FK_SecRel_1 = 0xC; ///< A one-byte section relative fixup.
  public static final int FK_SecRel_2 = 0xD; ///< A two-byte section relative fixup.
  public static final int FK_SecRel_4 = 0xE; ///< A four-byte section relative fixup.
  public static final int FK_SecRel_8 = 0xF; ///< A eight-byte section relative fixup.
  
  public static final int FirstTargetFixupKind = 128;
  
  // Limit range of target fixups, in case we want to pack more efficiently
  // later.
  public static final int MaxTargetFixupKind = (1 << 8);
}
