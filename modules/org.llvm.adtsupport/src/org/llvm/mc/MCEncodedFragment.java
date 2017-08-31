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
import static org.clank.support.Unsigned.*;


/// Interface implemented by fragments that contain encoded instructions and/or
/// data.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 145,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 143,
 FQN="llvm::MCEncodedFragment", NM="_ZN4llvm17MCEncodedFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm17MCEncodedFragmentE")
//</editor-fold>
public class MCEncodedFragment extends /*public*/ MCFragment implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragment::MCEncodedFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 145,
   FQN="llvm::MCEncodedFragment::MCEncodedFragment", NM="_ZN4llvm17MCEncodedFragmentC1ENS_10MCFragment12FragmentTypeEbPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm17MCEncodedFragmentC1ENS_10MCFragment12FragmentTypeEbPNS_9MCSectionE")
  //</editor-fold>
  protected MCEncodedFragment(MCFragment.FragmentType FType, boolean HasInstructions, 
      MCSection /*P*/ Sec) {
    // : MCFragment(FType, HasInstructions, 0, Sec) 
    //START JInit
    super(FType, HasInstructions, $int2uchar(0), Sec);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 152,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 150,
   FQN="llvm::MCEncodedFragment::classof", NM="_ZN4llvm17MCEncodedFragment7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm17MCEncodedFragment7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCFragment /*P*/ F) {
    MCFragment.FragmentType Kind = F.getKind();
    switch (Kind) {
     default:
      return false;
     case FT_Relaxable:
     case FT_CompactEncodedInst:
     case FT_Data:
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragment::~MCEncodedFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 143,
   FQN="llvm::MCEncodedFragment::~MCEncodedFragment", NM="_ZN4llvm17MCEncodedFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm17MCEncodedFragmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
