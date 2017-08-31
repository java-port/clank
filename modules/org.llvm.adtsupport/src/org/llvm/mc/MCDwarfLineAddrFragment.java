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

//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddrFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 404,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 418,
 FQN="llvm::MCDwarfLineAddrFragment", NM="_ZN4llvm23MCDwarfLineAddrFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm23MCDwarfLineAddrFragmentE")
//</editor-fold>
public class MCDwarfLineAddrFragment extends /*public*/ MCFragment implements Destructors.ClassWithDestructor {
  
  /// LineDelta - the value of the difference between the two line numbers
  /// between two .loc dwarf directives.
  private long/*int64_t*/ LineDelta;
  
  /// AddrDelta - The expression for the difference of the two symbols that
  /// make up the address delta between two .loc dwarf directives.
  private /*const*/ MCExpr /*P*/ AddrDelta;
  
  private SmallString/*8*/ Contents;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddrFragment::MCDwarfLineAddrFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 417,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 431,
   FQN="llvm::MCDwarfLineAddrFragment::MCDwarfLineAddrFragment", NM="_ZN4llvm23MCDwarfLineAddrFragmentC1ExRKNS_6MCExprEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm23MCDwarfLineAddrFragmentC1ExRKNS_6MCExprEPNS_9MCSectionE")
  //</editor-fold>
  public MCDwarfLineAddrFragment(long/*int64_t*/ LineDelta, final /*const*/ MCExpr /*&*/ AddrDelta) {
    this(LineDelta, AddrDelta, 
      (MCSection /*P*/ )null);
  }
  public MCDwarfLineAddrFragment(long/*int64_t*/ LineDelta, final /*const*/ MCExpr /*&*/ AddrDelta, 
      MCSection /*P*/ Sec/*= null*/) {
    // : MCFragment(FT_Dwarf, false, 0, Sec), LineDelta(LineDelta), AddrDelta(&AddrDelta), Contents() 
    //START JInit
    super(FragmentType.FT_Dwarf, false, $int2uchar(0), Sec);
    this.LineDelta = LineDelta;
    this.AddrDelta = $AddrOf(AddrDelta);
    this.Contents = new SmallString/*8*/(8);
    //END JInit
    Contents.push_back($$TERM);
  }

  
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddrFragment::getLineDelta">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 427,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 441,
   FQN="llvm::MCDwarfLineAddrFragment::getLineDelta", NM="_ZNK4llvm23MCDwarfLineAddrFragment12getLineDeltaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm23MCDwarfLineAddrFragment12getLineDeltaEv")
  //</editor-fold>
  public long/*int64_t*/ getLineDelta() /*const*/ {
    return LineDelta;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddrFragment::getAddrDelta">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 429,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 443,
   FQN="llvm::MCDwarfLineAddrFragment::getAddrDelta", NM="_ZNK4llvm23MCDwarfLineAddrFragment12getAddrDeltaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm23MCDwarfLineAddrFragment12getAddrDeltaEv")
  //</editor-fold>
  public /*const*/ MCExpr /*&*/ getAddrDelta() /*const*/ {
    return $Deref(AddrDelta);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddrFragment::getContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 431,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 445,
   FQN="llvm::MCDwarfLineAddrFragment::getContents", NM="_ZN4llvm23MCDwarfLineAddrFragment11getContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm23MCDwarfLineAddrFragment11getContentsEv")
  //</editor-fold>
  public SmallString/*8*/ /*&*/ getContents() {
    return Contents;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddrFragment::getContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 432,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 446,
   FQN="llvm::MCDwarfLineAddrFragment::getContents", NM="_ZNK4llvm23MCDwarfLineAddrFragment11getContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm23MCDwarfLineAddrFragment11getContentsEv")
  //</editor-fold>
  public /*const*/SmallString/*8*/ /*&*/ getContents$Const() /*const*/ {
    return Contents;
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddrFragment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 450,
   FQN="llvm::MCDwarfLineAddrFragment::classof", NM="_ZN4llvm23MCDwarfLineAddrFragment7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm23MCDwarfLineAddrFragment7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCFragment /*P*/ F) {
    return F.getKind() == MCFragment.FragmentType.FT_Dwarf;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineAddrFragment::~MCDwarfLineAddrFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 404,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 418,
   FQN="llvm::MCDwarfLineAddrFragment::~MCDwarfLineAddrFragment", NM="_ZN4llvm23MCDwarfLineAddrFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm23MCDwarfLineAddrFragmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Contents.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "LineDelta=" + LineDelta // NOI18N
              + ", AddrDelta=" + "[MCExpr]" // NOI18N
              + ", Contents=" + Contents // NOI18N
              + super.toString(); // NOI18N
  }
}
