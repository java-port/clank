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

//<editor-fold defaultstate="collapsed" desc="llvm::MCLEBFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 371,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 385,
 FQN="llvm::MCLEBFragment", NM="_ZN4llvm13MCLEBFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCLEBFragmentE")
//</editor-fold>
public class MCLEBFragment extends /*public*/ MCFragment implements Destructors.ClassWithDestructor {
  
  /// Value - The value this fragment should contain.
  private /*const*/ MCExpr /*P*/ Value;
  
  /// IsSigned - True if this is a sleb128, false if uleb128.
  private boolean IsSigned;
  
  private SmallString/*8*/ Contents;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLEBFragment::MCLEBFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 382,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 396,
   FQN="llvm::MCLEBFragment::MCLEBFragment", NM="_ZN4llvm13MCLEBFragmentC1ERKNS_6MCExprEbPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCLEBFragmentC1ERKNS_6MCExprEbPNS_9MCSectionE")
  //</editor-fold>
  public MCLEBFragment(final /*const*/ MCExpr /*&*/ Value_, boolean IsSigned_) {
    this(Value_, IsSigned_, (MCSection /*P*/ )null);
  }
  public MCLEBFragment(final /*const*/ MCExpr /*&*/ Value_, boolean IsSigned_, MCSection /*P*/ Sec/*= null*/) {
    // : MCFragment(FT_LEB, false, 0, Sec), Value(&Value_), IsSigned(IsSigned_), Contents() 
    //START JInit
    super(FragmentType.FT_LEB, false, $int2uchar(0), Sec);
    this.Value = $AddrOf(Value_);
    this.IsSigned = IsSigned_;
    this.Contents = new SmallString/*8*/(8);
    //END JInit
    Contents.push_back($$TERM);
  }

  
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLEBFragment::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 390,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 404,
   FQN="llvm::MCLEBFragment::getValue", NM="_ZNK4llvm13MCLEBFragment8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm13MCLEBFragment8getValueEv")
  //</editor-fold>
  public /*const*/ MCExpr /*&*/ getValue() /*const*/ {
    return $Deref(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLEBFragment::isSigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 392,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 406,
   FQN="llvm::MCLEBFragment::isSigned", NM="_ZNK4llvm13MCLEBFragment8isSignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm13MCLEBFragment8isSignedEv")
  //</editor-fold>
  public boolean isSigned() /*const*/ {
    return IsSigned;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLEBFragment::getContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 394,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 408,
   FQN="llvm::MCLEBFragment::getContents", NM="_ZN4llvm13MCLEBFragment11getContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCLEBFragment11getContentsEv")
  //</editor-fold>
  public SmallString/*8*/ /*&*/ getContents() {
    return Contents;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCLEBFragment::getContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 409,
   FQN="llvm::MCLEBFragment::getContents", NM="_ZNK4llvm13MCLEBFragment11getContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm13MCLEBFragment11getContentsEv")
  //</editor-fold>
  public /*const*/SmallString/*8*/ /*&*/ getContents$Const() /*const*/ {
    return Contents;
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLEBFragment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 399,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 413,
   FQN="llvm::MCLEBFragment::classof", NM="_ZN4llvm13MCLEBFragment7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCLEBFragment7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCFragment /*P*/ F) {
    return F.getKind() == MCFragment.FragmentType.FT_LEB;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCLEBFragment::~MCLEBFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 371,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 385,
   FQN="llvm::MCLEBFragment::~MCLEBFragment", NM="_ZN4llvm13MCLEBFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm13MCLEBFragmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Contents.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Value=" + "[MCExpr]" // NOI18N
              + ", IsSigned=" + IsSigned // NOI18N
              + ", Contents=" + Contents // NOI18N
              + super.toString(); // NOI18N
  }
}
