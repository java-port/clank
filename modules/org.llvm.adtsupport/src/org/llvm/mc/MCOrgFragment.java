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

//<editor-fold defaultstate="collapsed" desc="llvm::MCOrgFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 345,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 359,
 FQN="llvm::MCOrgFragment", NM="_ZN4llvm13MCOrgFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCOrgFragmentE")
//</editor-fold>
public class MCOrgFragment extends /*public*/ MCFragment implements Destructors.ClassWithDestructor {
  
  /// Offset - The offset this fragment should start at.
  private /*const*/ MCExpr /*P*/ Offset;
  
  /// Value - Value to use for filling bytes.
  private byte/*int8_t*/ Value;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOrgFragment::MCOrgFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 354,
   FQN="llvm::MCOrgFragment::MCOrgFragment", NM="_ZN4llvm13MCOrgFragmentC1ERKNS_6MCExprEcPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCOrgFragmentC1ERKNS_6MCExprEcPNS_9MCSectionE")
  //</editor-fold>
  public MCOrgFragment(final /*const*/ MCExpr /*&*/ Offset, byte/*int8_t*/ Value) {
    this(Offset, Value, (MCSection /*P*/ )null);
  }
  public MCOrgFragment(final /*const*/ MCExpr /*&*/ Offset, byte/*int8_t*/ Value, MCSection /*P*/ Sec/*= null*/) {
    // : MCFragment(FT_Org, false, 0, Sec), Offset(&Offset), Value(Value) 
    //START JInit
    super(FragmentType.FT_Org, false, $int2uchar(0), Sec);
    this.Offset = $AddrOf(Offset);
    this.Value = Value;
    //END JInit
  }

  
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOrgFragment::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 360,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 374,
   FQN="llvm::MCOrgFragment::getOffset", NM="_ZNK4llvm13MCOrgFragment9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm13MCOrgFragment9getOffsetEv")
  //</editor-fold>
  public /*const*/ MCExpr /*&*/ getOffset() /*const*/ {
    return $Deref(Offset);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOrgFragment::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 362,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 376,
   FQN="llvm::MCOrgFragment::getValue", NM="_ZNK4llvm13MCOrgFragment8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm13MCOrgFragment8getValueEv")
  //</editor-fold>
  public byte/*uint8_t*/ getValue() /*const*/ {
    return Value;
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOrgFragment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 366,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 380,
   FQN="llvm::MCOrgFragment::classof", NM="_ZN4llvm13MCOrgFragment7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCOrgFragment7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCFragment /*P*/ F) {
    return F.getKind() == MCFragment.FragmentType.FT_Org;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOrgFragment::~MCOrgFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 345,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 359,
   FQN="llvm::MCOrgFragment::~MCOrgFragment", NM="_ZN4llvm13MCOrgFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCOrgFragmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Offset=" + "[MCExpr]" // NOI18N
              + ", Value=" + Value // NOI18N
              + super.toString(); // NOI18N
  }
}
