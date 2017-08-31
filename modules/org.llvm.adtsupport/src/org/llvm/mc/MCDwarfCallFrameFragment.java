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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.literal_constants.$$TERM;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfCallFrameFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 441,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 455,
 FQN="llvm::MCDwarfCallFrameFragment", NM="_ZN4llvm24MCDwarfCallFrameFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm24MCDwarfCallFrameFragmentE")
//</editor-fold>
public class MCDwarfCallFrameFragment extends /*public*/ MCFragment implements Destructors.ClassWithDestructor {
  
  /// AddrDelta - The expression for the difference of the two symbols that
  /// make up the address delta between two .cfi_* dwarf directives.
  private /*const*/ MCExpr /*P*/ AddrDelta;
  
  private SmallString/*8*/ Contents;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfCallFrameFragment::MCDwarfCallFrameFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 450,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 464,
   FQN="llvm::MCDwarfCallFrameFragment::MCDwarfCallFrameFragment", NM="_ZN4llvm24MCDwarfCallFrameFragmentC1ERKNS_6MCExprEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm24MCDwarfCallFrameFragmentC1ERKNS_6MCExprEPNS_9MCSectionE")
  //</editor-fold>
  public MCDwarfCallFrameFragment(final /*const*/ MCExpr /*&*/ AddrDelta) {
    this(AddrDelta, (MCSection /*P*/ )null);
  }
  public MCDwarfCallFrameFragment(final /*const*/ MCExpr /*&*/ AddrDelta, MCSection /*P*/ Sec/*= null*/) {
    // : MCFragment(FT_DwarfFrame, false, 0, Sec), AddrDelta(&AddrDelta), Contents() 
    //START JInit
    super(FragmentType.FT_DwarfFrame, false, $int2uchar(0), Sec);
    this.AddrDelta = $AddrOf(AddrDelta);
    this.Contents = new SmallString/*8*/(8);
    //END JInit
    Contents.push_back($$TERM);
  }

  
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfCallFrameFragment::getAddrDelta">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 458,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 472,
   FQN="llvm::MCDwarfCallFrameFragment::getAddrDelta", NM="_ZNK4llvm24MCDwarfCallFrameFragment12getAddrDeltaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm24MCDwarfCallFrameFragment12getAddrDeltaEv")
  //</editor-fold>
  public /*const*/ MCExpr /*&*/ getAddrDelta() /*const*/ {
    return $Deref(AddrDelta);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfCallFrameFragment::getContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 460,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 474,
   FQN="llvm::MCDwarfCallFrameFragment::getContents", NM="_ZN4llvm24MCDwarfCallFrameFragment11getContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm24MCDwarfCallFrameFragment11getContentsEv")
  //</editor-fold>
  public SmallString/*8*/ /*&*/ getContents() {
    return Contents;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfCallFrameFragment::getContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 475,
   FQN="llvm::MCDwarfCallFrameFragment::getContents", NM="_ZNK4llvm24MCDwarfCallFrameFragment11getContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm24MCDwarfCallFrameFragment11getContentsEv")
  //</editor-fold>
  public /*const*/SmallString/*8*/ /*&*/ getContents$Const() /*const*/ {
    return Contents;
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfCallFrameFragment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 465,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 479,
   FQN="llvm::MCDwarfCallFrameFragment::classof", NM="_ZN4llvm24MCDwarfCallFrameFragment7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm24MCDwarfCallFrameFragment7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCFragment /*P*/ F) {
    return F.getKind() == MCFragment.FragmentType.FT_DwarfFrame;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfCallFrameFragment::~MCDwarfCallFrameFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 441,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 455,
   FQN="llvm::MCDwarfCallFrameFragment::~MCDwarfCallFrameFragment", NM="_ZN4llvm24MCDwarfCallFrameFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm24MCDwarfCallFrameFragmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Contents.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "AddrDelta=" + "[MCExpr]" // NOI18N
              + ", Contents=" + Contents // NOI18N
              + super.toString(); // NOI18N
  }
}
