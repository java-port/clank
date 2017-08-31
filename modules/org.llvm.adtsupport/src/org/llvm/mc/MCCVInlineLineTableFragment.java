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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// Fragment representing the binary annotations produced by the
/// .cv_inline_linetable directive.
//<editor-fold defaultstate="collapsed" desc="llvm::MCCVInlineLineTableFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 492,
 FQN="llvm::MCCVInlineLineTableFragment", NM="_ZN4llvm27MCCVInlineLineTableFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCCVInlineLineTableFragmentE")
//</editor-fold>
public class MCCVInlineLineTableFragment extends /*public*/ MCFragment implements Destructors.ClassWithDestructor {
  private /*uint*/int SiteFuncId;
  private /*uint*/int StartFileId;
  private /*uint*/int StartLineNum;
  private /*const*/ MCSymbol /*P*/ FnStartSym;
  private /*const*/ MCSymbol /*P*/ FnEndSym;
  private SmallVectorUInt SecondaryFuncs;
  private SmallString/*8*/ Contents;
  
  /// CodeViewContext has the real knowledge about this format, so let it access
  /// our members.
  /*friend  class CodeViewContext*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVInlineLineTableFragment::MCCVInlineLineTableFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 506,
   FQN="llvm::MCCVInlineLineTableFragment::MCCVInlineLineTableFragment", NM="_ZN4llvm27MCCVInlineLineTableFragmentC1EjjjPKNS_8MCSymbolES3_NS_8ArrayRefIjEEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCCVInlineLineTableFragmentC1EjjjPKNS_8MCSymbolES3_NS_8ArrayRefIjEEPNS_9MCSectionE")
  //</editor-fold>
  public MCCVInlineLineTableFragment(/*uint*/int SiteFuncId, /*uint*/int StartFileId, 
      /*uint*/int StartLineNum, /*const*/ MCSymbol /*P*/ FnStartSym, 
      /*const*/ MCSymbol /*P*/ FnEndSym, 
      ArrayRefUInt SecondaryFuncs) {
    this(SiteFuncId, StartFileId, 
      StartLineNum, FnStartSym, 
      FnEndSym, 
      SecondaryFuncs, 
      (MCSection /*P*/ )null);
  }
  public MCCVInlineLineTableFragment(/*uint*/int SiteFuncId, /*uint*/int StartFileId, 
      /*uint*/int StartLineNum, /*const*/ MCSymbol /*P*/ FnStartSym, 
      /*const*/ MCSymbol /*P*/ FnEndSym, 
      ArrayRefUInt SecondaryFuncs, 
      MCSection /*P*/ Sec/*= null*/) {
    // : MCFragment(FT_CVInlineLines, false, 0, Sec), SiteFuncId(SiteFuncId), StartFileId(StartFileId), StartLineNum(StartLineNum), FnStartSym(FnStartSym), FnEndSym(FnEndSym), SecondaryFuncs(SecondaryFuncs.begin(), SecondaryFuncs.end()), Contents() 
    //START JInit
    super(FragmentType.FT_CVInlineLines, false, $int2uchar(0), Sec);
    this.SiteFuncId = SiteFuncId;
    this.StartFileId = StartFileId;
    this.StartLineNum = StartLineNum;
    this.FnStartSym = FnStartSym;
    this.FnEndSym = FnEndSym;
    this.SecondaryFuncs = new SmallVectorUInt(JD$T.INSTANCE, 3, SecondaryFuncs.begin(), SecondaryFuncs.end(), 0);
    this.Contents = new SmallString/*8*/(8);
    //END JInit
  }

  
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVInlineLineTableFragment::getFnStartSym">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 519,
   FQN="llvm::MCCVInlineLineTableFragment::getFnStartSym", NM="_ZNK4llvm27MCCVInlineLineTableFragment13getFnStartSymEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm27MCCVInlineLineTableFragment13getFnStartSymEv")
  //</editor-fold>
  public /*const*/ MCSymbol /*P*/ getFnStartSym() /*const*/ {
    return FnStartSym;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVInlineLineTableFragment::getFnEndSym">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 520,
   FQN="llvm::MCCVInlineLineTableFragment::getFnEndSym", NM="_ZNK4llvm27MCCVInlineLineTableFragment11getFnEndSymEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm27MCCVInlineLineTableFragment11getFnEndSymEv")
  //</editor-fold>
  public /*const*/ MCSymbol /*P*/ getFnEndSym() /*const*/ {
    return FnEndSym;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVInlineLineTableFragment::getContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 522,
   FQN="llvm::MCCVInlineLineTableFragment::getContents", NM="_ZN4llvm27MCCVInlineLineTableFragment11getContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCCVInlineLineTableFragment11getContentsEv")
  //</editor-fold>
  public SmallString/*8*/ /*&*/ getContents() {
    return Contents;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVInlineLineTableFragment::getContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 523,
   FQN="llvm::MCCVInlineLineTableFragment::getContents", NM="_ZNK4llvm27MCCVInlineLineTableFragment11getContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm27MCCVInlineLineTableFragment11getContentsEv")
  //</editor-fold>
  public /*const*/SmallString/*8*/ /*&*/ getContents$Const() /*const*/ {
    return Contents;
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVInlineLineTableFragment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 527,
   FQN="llvm::MCCVInlineLineTableFragment::classof", NM="_ZN4llvm27MCCVInlineLineTableFragment7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCCVInlineLineTableFragment7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCFragment /*P*/ F) {
    return F.getKind() == MCFragment.FragmentType.FT_CVInlineLines;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVInlineLineTableFragment::~MCCVInlineLineTableFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 492,
   FQN="llvm::MCCVInlineLineTableFragment::~MCCVInlineLineTableFragment", NM="_ZN4llvm27MCCVInlineLineTableFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCCVInlineLineTableFragmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Contents.$destroy();
    SecondaryFuncs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SiteFuncId=" + SiteFuncId // NOI18N
              + ", StartFileId=" + StartFileId // NOI18N
              + ", StartLineNum=" + StartLineNum // NOI18N
              + ", FnStartSym=" + FnStartSym // NOI18N
              + ", FnEndSym=" + FnEndSym // NOI18N
              + ", SecondaryFuncs=" + SecondaryFuncs // NOI18N
              + ", Contents=" + Contents // NOI18N
              + super.toString(); // NOI18N
  }
}
