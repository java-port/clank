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
import org.clank.support.aliases.*;


/// \brief Target independent information on a fixup kind.
//<editor-fold defaultstate="collapsed" desc="llvm::MCFixupKindInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixupKindInfo.h", line = 16,
 FQN="llvm::MCFixupKindInfo", NM="_ZN4llvm15MCFixupKindInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm15MCFixupKindInfoE")
//</editor-fold>
public class/*struct*/ MCFixupKindInfo {
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixupKindInfo::FixupKindFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixupKindInfo.h", line = 17,
   FQN="llvm::MCFixupKindInfo::FixupKindFlags", NM="_ZN4llvm15MCFixupKindInfo14FixupKindFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm15MCFixupKindInfo14FixupKindFlagsE")
  //</editor-fold>
  public static final class/*enum*/ FixupKindFlags {
    /// Is this fixup kind PCrelative? This is used by the assembler backend to
    /// evaluate fixup values in a target independent manner when possible.
    public static final /*uint*/int FKF_IsPCRel = (1 << 0);
    
    /// Should this fixup kind force a 4-byte aligned effective PC value?
    public static final /*uint*/int FKF_IsAlignedDownTo32Bits = (1 << 1);
  };
  
  /// A target specific name for the fixup kind. The names will be unique for
  /// distinct kinds on any given target.
  public /*const*/char$ptr/*char P*/ Name;
  
  /// The bit offset to write the relocation into.
  public /*uint*/int TargetOffset;
  
  /// The number of bits written by this fixup. The bits are assumed to be
  /// contiguous.
  public /*uint*/int TargetSize;
  
  /// Flags describing additional information on this fixup kind.
  public /*uint*/int Flags;

  public MCFixupKindInfo(char$ptr Name, int TargetOffset, int TargetSize, int Flags) {
    this.Name = Name;
    this.TargetOffset = TargetOffset;
    this.TargetSize = TargetSize;
    this.Flags = Flags;
  }
  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", TargetOffset=" + TargetOffset // NOI18N
              + ", TargetSize=" + TargetSize // NOI18N
              + ", Flags=" + Flags; // NOI18N
  }
}
