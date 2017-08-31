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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;


/// Represents a single fixit, a replacement of one range of text with another.
//<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 200,
 FQN="llvm::SMFixIt", NM="_ZN4llvm7SMFixItE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm7SMFixItE")
//</editor-fold>
public class SMFixIt implements NativePOD<SMFixIt>, ComparableLower, Destructors.ClassWithDestructor {
  private SMRange Range;
  
  private std.string Text;
/*public:*/
  // FIXME: Twine.str() is not very efficient.
  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::SMFixIt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 207,
   FQN="llvm::SMFixIt::SMFixIt", NM="_ZN4llvm7SMFixItC1ENS_5SMLocERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm7SMFixItC1ENS_5SMLocERKNS_5TwineE")
  //</editor-fold>
  public SMFixIt(SMLoc Loc, final /*const*/ Twine /*&*/ Insertion) {
    // : Range(Loc, Loc), Text(Insertion.str()) 
    //START JInit
    this.Range = new SMRange(new SMLoc(Loc), new SMLoc(Loc));
    this.Text = Insertion.str();
    //END JInit
    assert (Loc.isValid());
  }

  
  // FIXME: Twine.str() is not very efficient.
  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::SMFixIt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 213,
   FQN="llvm::SMFixIt::SMFixIt", NM="_ZN4llvm7SMFixItC1ENS_7SMRangeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm7SMFixItC1ENS_7SMRangeERKNS_5TwineE")
  //</editor-fold>
  public SMFixIt(SMRange R, final /*const*/ Twine /*&*/ Replacement) {
    // : Range(R), Text(Replacement.str()) 
    //START JInit
    this.Range = new SMRange(R);
    this.Text = Replacement.str();
    //END JInit
    assert (R.isValid());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::getText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 218,
   FQN="llvm::SMFixIt::getText", NM="_ZNK4llvm7SMFixIt7getTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm7SMFixIt7getTextEv")
  //</editor-fold>
  public StringRef getText() /*const*/ {
    return new StringRef(Text);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::getRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 219,
   FQN="llvm::SMFixIt::getRange", NM="_ZNK4llvm7SMFixIt8getRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm7SMFixIt8getRangeEv")
  //</editor-fold>
  public SMRange getRange() /*const*/ {
    return new SMRange(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 221,
   FQN="llvm::SMFixIt::operator<", NM="_ZNK4llvm7SMFixItltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm7SMFixItltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ SMFixIt /*&*/ Other) /*const*/ {
    if ($noteq_ptr(Range.Start.getPointer(), Other.Range.Start.getPointer())) {
      return Range.Start.getPointer().$less(Other.Range.Start.getPointer());
    }
    if ($noteq_ptr(Range.End.getPointer(), Other.Range.End.getPointer())) {
      return Range.End.getPointer().$less(Other.Range.End.getPointer());
    }
    return $less_string$C(Text, Other.Text);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::SMFixIt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 200,
   FQN="llvm::SMFixIt::SMFixIt", NM="_ZN4llvm7SMFixItC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm7SMFixItC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SMFixIt(final /*const*/ SMFixIt /*&*/ $Prm0) {
    // : Range(.Range), Text(.Text) 
    //START JInit
    this.Range = new SMRange($Prm0.Range);
    this.Text = new std.string($Prm0.Text);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::SMFixIt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 200,
   FQN="llvm::SMFixIt::SMFixIt", NM="_ZN4llvm7SMFixItC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm7SMFixItC1EOS0_")
  //</editor-fold>
  public /*inline*/ SMFixIt(JD$Move _dparam, final SMFixIt /*&&*/$Prm0) {
    // : Range(static_cast<SMFixIt &&>().Range), Text(static_cast<SMFixIt &&>().Text) 
    //START JInit
    this.Range = new SMRange(JD$Move.INSTANCE, $Prm0.Range);
    this.Text = new std.string(JD$Move.INSTANCE, $Prm0.Text);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 200,
   FQN="llvm::SMFixIt::operator=", NM="_ZN4llvm7SMFixItaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm7SMFixItaSEOS0_")
  //</editor-fold>
  public /*inline*/ SMFixIt /*&*/ $assignMove(final SMFixIt /*&&*/$Prm0) {
    this.Range.$assignMove($Prm0.Range);
    this.Text.$assignMove($Prm0.Text);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMFixIt::~SMFixIt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 200,
   FQN="llvm::SMFixIt::~SMFixIt", NM="_ZN4llvm7SMFixItD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm7SMFixItD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Text.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public SMFixIt() {
    this.Range = new SMRange();
    this.Text = new string();
  }
  
  @Override
  public boolean $less(Object Other) {
    return this.$less((SMFixIt)Other);
  }
  
  @Override
  public SMFixIt $assign(SMFixIt value) {
    this.Range = value.Range;
    this.Text = value.Text;
    return this;
  }
  
  @Override
  public SMFixIt clone() {
    SMFixIt res = new SMFixIt();
    res.$assign(this);
    return res;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", Text=" + Text; // NOI18N
  }
}
