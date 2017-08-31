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
import org.llvm.mc.MCFragment.FragmentType;


/// A relaxable fragment holds on to its MCInst, since it may need to be
/// relaxed during the assembler layout and relaxation stage.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MCRelaxableFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 253,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 250,
 FQN="llvm::MCRelaxableFragment", NM="_ZN4llvm19MCRelaxableFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm19MCRelaxableFragmentE")
//</editor-fold>
public class MCRelaxableFragment extends /*public*/ MCEncodedFragmentWithFixups/*<8, 1>*/ implements Destructors.ClassWithDestructor {
  
  /// Inst - The instruction this is a fragment for.
  private MCInst Inst;
  
  /// STI - The MCSubtargetInfo in effect when the instruction was encoded.
  private final /*const*/ MCSubtargetInfo /*&*/ STI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRelaxableFragment::MCRelaxableFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 262,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 259,
   FQN="llvm::MCRelaxableFragment::MCRelaxableFragment", NM="_ZN4llvm19MCRelaxableFragmentC1ERKNS_6MCInstERKNS_15MCSubtargetInfoEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm19MCRelaxableFragmentC1ERKNS_6MCInstERKNS_15MCSubtargetInfoEPNS_9MCSectionE")
  //</editor-fold>
  public MCRelaxableFragment(final /*const*/ MCInst /*&*/ Inst, final /*const*/ MCSubtargetInfo /*&*/ STI) {
    this(Inst, STI, 
      (MCSection /*P*/ )null);
  }
  public MCRelaxableFragment(final /*const*/ MCInst /*&*/ Inst, final /*const*/ MCSubtargetInfo /*&*/ STI, 
      MCSection /*P*/ Sec/*= null*/) {
    // : MCEncodedFragmentWithFixups<8, 1>(FT_Relaxable, true, Sec), Inst(Inst), STI(STI) 
    //START JInit
    super(8,1,FragmentType.FT_Relaxable, true, Sec);
    this.Inst = new MCInst(Inst);
    this./*&*/STI=/*&*/STI;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRelaxableFragment::getInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 264,
   FQN="llvm::MCRelaxableFragment::getInst", NM="_ZNK4llvm19MCRelaxableFragment7getInstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm19MCRelaxableFragment7getInstEv")
  //</editor-fold>
  public /*const*/ MCInst /*&*/ getInst() /*const*/ {
    return Inst;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCRelaxableFragment::setInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 268,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 265,
   FQN="llvm::MCRelaxableFragment::setInst", NM="_ZN4llvm19MCRelaxableFragment7setInstERKNS_6MCInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm19MCRelaxableFragment7setInstERKNS_6MCInstE")
  //</editor-fold>
  public void setInst(final /*const*/ MCInst /*&*/ Value) {
    Inst.$assign(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRelaxableFragment::getSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 270,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 267,
   FQN="llvm::MCRelaxableFragment::getSubtargetInfo", NM="_ZN4llvm19MCRelaxableFragment16getSubtargetInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm19MCRelaxableFragment16getSubtargetInfoEv")
  //</editor-fold>
  public /*const*/ MCSubtargetInfo /*&*/ getSubtargetInfo() {
    return STI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCRelaxableFragment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 272,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 269,
   FQN="llvm::MCRelaxableFragment::classof", NM="_ZN4llvm19MCRelaxableFragment7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm19MCRelaxableFragment7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCFragment /*P*/ F) {
    return F.getKind() == MCFragment.FragmentType.FT_Relaxable;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCRelaxableFragment::~MCRelaxableFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 253,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 250,
   FQN="llvm::MCRelaxableFragment::~MCRelaxableFragment", NM="_ZN4llvm19MCRelaxableFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm19MCRelaxableFragmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Inst.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Inst=" + Inst // NOI18N
              + ", STI=" + STI // NOI18N
              + super.toString(); // NOI18N
  }
}
