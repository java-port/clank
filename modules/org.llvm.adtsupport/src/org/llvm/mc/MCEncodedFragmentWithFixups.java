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
import org.llvm.adt.aliases.*;


/// Interface implemented by fragments that contain encoded instructions and/or
/// data and also have fixups registered.
///
/*template <unsigned int ContentsSize, unsigned int FixupsSize> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 186,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 184,
 FQN="llvm::MCEncodedFragmentWithFixups", NM="_ZN4llvm27MCEncodedFragmentWithFixupsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCEncodedFragmentWithFixupsE")
//</editor-fold>
public class MCEncodedFragmentWithFixups/*<uint int ContentsSize, uint int FixupsSize>*/  extends /*public*/ MCEncodedFragmentWithContents/*<ContentsSize>*/ {
  
  /// Fixups - The list of fixups in this fragment.
  private SmallVectorImpl<MCFixup/*, FixupsSize*/> Fixups;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups::MCEncodedFragmentWithFixups<ContentsSize, FixupsSize>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 194,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 192,
   FQN="llvm::MCEncodedFragmentWithFixups::MCEncodedFragmentWithFixups<ContentsSize, FixupsSize>", NM="_ZN4llvm27MCEncodedFragmentWithFixupsC1ENS_10MCFragment12FragmentTypeEbPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCEncodedFragmentWithFixupsC1ENS_10MCFragment12FragmentTypeEbPNS_9MCSectionE")
  //</editor-fold>
  protected MCEncodedFragmentWithFixups(/*uint*/ int ContentsSize, /*uint*/ int FixupsSize, MCFragment.FragmentType FType, 
      boolean HasInstructions, 
      MCSection /*P*/ Sec) {
    // : MCEncodedFragmentWithContents<ContentsSize>(FType, HasInstructions, Sec) 
    //START JInit
    /*ParenListExpr*/super(ContentsSize, FType, HasInstructions, Sec);
    //END JInit
  }

/*public:*/
  // JAVA: typedef SmallVectorImpl<MCFixup>::const_iterator const_fixup_iterator
//  public final class const_fixup_iterator extends type$ptr<MCFixup>{ };
  // JAVA: typedef SmallVectorImpl<MCFixup>::iterator fixup_iterator
//  public final class fixup_iterator extends type$ptr<MCFixup>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups::getFixups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 204,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 202,
   FQN="llvm::MCEncodedFragmentWithFixups::getFixups", NM="_ZN4llvm27MCEncodedFragmentWithFixups9getFixupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCEncodedFragmentWithFixups9getFixupsEv")
  //</editor-fold>
  public SmallVectorImpl<MCFixup> /*&*/ getFixups() {
    return Fixups;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups::getFixups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 205,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 203,
   FQN="llvm::MCEncodedFragmentWithFixups::getFixups", NM="_ZNK4llvm27MCEncodedFragmentWithFixups9getFixupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm27MCEncodedFragmentWithFixups9getFixupsEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<MCFixup> /*&*/ getFixups$Const() /*const*/ {
    return Fixups;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups::fixup_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 205,
   FQN="llvm::MCEncodedFragmentWithFixups::fixup_begin", NM="_ZN4llvm27MCEncodedFragmentWithFixups11fixup_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCEncodedFragmentWithFixups11fixup_beginEv")
  //</editor-fold>
  public type$ptr<MCFixup> fixup_begin() {
    return Fixups.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups::fixup_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 206,
   FQN="llvm::MCEncodedFragmentWithFixups::fixup_begin", NM="_ZNK4llvm27MCEncodedFragmentWithFixups11fixup_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm27MCEncodedFragmentWithFixups11fixup_beginEv")
  //</editor-fold>
  public type$ptr<MCFixup> fixup_begin$Const() /*const*/ {
    return Fixups.begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups::fixup_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 210,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 208,
   FQN="llvm::MCEncodedFragmentWithFixups::fixup_end", NM="_ZN4llvm27MCEncodedFragmentWithFixups9fixup_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCEncodedFragmentWithFixups9fixup_endEv")
  //</editor-fold>
  public type$ptr<MCFixup> fixup_end() {
    return Fixups.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups::fixup_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 211,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 209,
   FQN="llvm::MCEncodedFragmentWithFixups::fixup_end", NM="_ZNK4llvm27MCEncodedFragmentWithFixups9fixup_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm27MCEncodedFragmentWithFixups9fixup_endEv")
  //</editor-fold>
  public type$ptr<MCFixup> fixup_end$Const() /*const*/ {
    return Fixups.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCEncodedFragmentWithFixups::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 213,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 211,
   FQN="llvm::MCEncodedFragmentWithFixups::classof", NM="_ZN4llvm27MCEncodedFragmentWithFixups7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm27MCEncodedFragmentWithFixups7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static /*<uint int ContentsSize, uint int FixupsSize>*/ boolean classof(/*const*/ MCFragment /*P*/ F) {
    MCFragment.FragmentType Kind = F.getKind();
    return Kind == MCFragment.FragmentType.FT_Relaxable || Kind == MCFragment.FragmentType.FT_Data
       || Kind == MCFragment.FragmentType.FT_CVDefRange;
  }

  
  @Override public String toString() {
    return "" + "Fixups=" + Fixups // NOI18N
              + super.toString(); // NOI18N
  }
}
