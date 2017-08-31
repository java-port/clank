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


/// Represents a range in source code.
///
/// SMRange is implemented using a half-open range, as is the convention in C++.
/// In the string "abc", the range (1,3] represents the substring "bc", and the
/// range (2,2] represents an empty range between the characters "b" and "c".
//<editor-fold defaultstate="collapsed" desc="llvm::SMRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 48,
 FQN="llvm::SMRange", NM="_ZN4llvm7SMRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm7SMRangeE")
//</editor-fold>
public class SMRange {
/*public:*/
  public SMLoc Start;
  public SMLoc End;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMRange::SMRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 52,
   FQN="llvm::SMRange::SMRange", NM="_ZN4llvm7SMRangeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm7SMRangeC1Ev")
  //</editor-fold>
  public SMRange() {
    // : Start(), End() 
    //START JInit
    this.Start = new SMLoc();
    this.End = new SMLoc();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMRange::SMRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 53,
   FQN="llvm::SMRange::SMRange", NM="_ZN4llvm7SMRangeC1ENS_5SMLocES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm7SMRangeC1ENS_5SMLocES1_")
  //</editor-fold>
  public SMRange(SMLoc St, SMLoc En) {
    // : Start(St), End(En) 
    //START JInit
    this.Start = new SMLoc(St);
    this.End = new SMLoc(En);
    //END JInit
    assert (Start.isValid() == End.isValid()) : "Start and end should either both be valid or both be invalid!";
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMRange::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 58,
   FQN="llvm::SMRange::isValid", NM="_ZNK4llvm7SMRange7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK4llvm7SMRange7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return Start.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMRange::SMRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 48,
   FQN="llvm::SMRange::SMRange", NM="_ZN4llvm7SMRangeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm7SMRangeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SMRange(final /*const*/ SMRange /*&*/ $Prm0) {
    // : Start(.Start), End(.End) 
    //START JInit
    this.Start = new SMLoc($Prm0.Start);
    this.End = new SMLoc($Prm0.End);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMRange::SMRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 48,
   FQN="llvm::SMRange::SMRange", NM="_ZN4llvm7SMRangeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm7SMRangeC1EOS0_")
  //</editor-fold>
  public /*inline*/ SMRange(JD$Move _dparam, final SMRange /*&&*/$Prm0) {
    // : Start(static_cast<SMRange &&>().Start), End(static_cast<SMRange &&>().End) 
    //START JInit
    this.Start = new SMLoc(JD$Move.INSTANCE, $Prm0.Start);
    this.End = new SMLoc(JD$Move.INSTANCE, $Prm0.End);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMRange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 48,
   FQN="llvm::SMRange::operator=", NM="_ZN4llvm7SMRangeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm7SMRangeaSERKS0_")
  //</editor-fold>
  public /*inline*/ SMRange /*&*/ $assign(final /*const*/ SMRange /*&*/ $Prm0) {
    this.Start.$assign($Prm0.Start);
    this.End.$assign($Prm0.End);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMRange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 48,
   FQN="llvm::SMRange::operator=", NM="_ZN4llvm7SMRangeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm7SMRangeaSEOS0_")
  //</editor-fold>
  public /*inline*/ SMRange /*&*/ $assignMove(final SMRange /*&&*/$Prm0) {
    this.Start.$assignMove($Prm0.Start);
    this.End.$assignMove($Prm0.End);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Start=" + Start // NOI18N
              + ", End=" + End; // NOI18N
  }
}
