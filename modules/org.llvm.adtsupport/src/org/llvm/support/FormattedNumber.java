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

package org.llvm.support;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


/// This is a helper class used for format_hex() and format_decimal().
//<editor-fold defaultstate="collapsed" desc="llvm::FormattedNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 142,
 FQN="llvm::FormattedNumber", NM="_ZN4llvm15FormattedNumberE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm15FormattedNumberE")
//</editor-fold>
public class FormattedNumber {
  /*friend*/public/*private*/ long/*uint64_t*/ HexValue;
  /*friend*/public/*private*/ long/*int64_t*/ DecValue;
  /*friend*/public/*private*/ /*uint*/int Width;
  /*friend*/public/*private*/ boolean Hex;
  /*friend*/public/*private*/ boolean Upper;
  /*friend*/public/*private*/ boolean HexPrefix;
  /*friend  class raw_ostream*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FormattedNumber::FormattedNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 152,
   FQN="llvm::FormattedNumber::FormattedNumber", NM="_ZN4llvm15FormattedNumberC1Eyxjbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm15FormattedNumberC1Eyxjbbb")
  //</editor-fold>
  public FormattedNumber(long/*uint64_t*/ HV, long/*int64_t*/ DV, /*uint*/int W, boolean H, boolean U, 
      boolean Prefix) {
    // : HexValue(HV), DecValue(DV), Width(W), Hex(H), Upper(U), HexPrefix(Prefix) 
    //START JInit
    this.HexValue = HV;
    this.DecValue = DV;
    this.Width = W;
    this.Hex = H;
    this.Upper = U;
    this.HexPrefix = Prefix;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FormattedNumber::FormattedNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 142,
   FQN="llvm::FormattedNumber::FormattedNumber", NM="_ZN4llvm15FormattedNumberC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm15FormattedNumberC1EOS0_")
  //</editor-fold>
  public /*inline*/ FormattedNumber(JD$Move _dparam, final FormattedNumber /*&&*/$Prm0) {
    // : HexValue(static_cast<FormattedNumber &&>().HexValue), DecValue(static_cast<FormattedNumber &&>().DecValue), Width(static_cast<FormattedNumber &&>().Width), Hex(static_cast<FormattedNumber &&>().Hex), Upper(static_cast<FormattedNumber &&>().Upper), HexPrefix(static_cast<FormattedNumber &&>().HexPrefix) 
    //START JInit
    this.HexValue = $Prm0.HexValue;
    this.DecValue = $Prm0.DecValue;
    this.Width = $Prm0.Width;
    this.Hex = $Prm0.Hex;
    this.Upper = $Prm0.Upper;
    this.HexPrefix = $Prm0.HexPrefix;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "HexValue=" + HexValue // NOI18N
              + ", DecValue=" + DecValue // NOI18N
              + ", Width=" + Width // NOI18N
              + ", Hex=" + Hex // NOI18N
              + ", Upper=" + Upper // NOI18N
              + ", HexPrefix=" + HexPrefix; // NOI18N
  }
}
