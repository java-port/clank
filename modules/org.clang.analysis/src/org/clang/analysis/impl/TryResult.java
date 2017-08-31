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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.analysis.impl.*;


/// TryResult - a class representing a variant over the values
///  'true', 'false', or 'unknown'.  This is returned by tryEvaluateBool,
///  and is used by the CFGBuilder to decide if a branch condition
///  can be decided up front during CFG construction.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 294,
 FQN="(anonymous namespace)::TryResult", NM="_ZN12_GLOBAL__N_19TryResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_19TryResultE")
//</editor-fold>
public class TryResult implements NativePOD<TryResult> {
  private int X;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::TryResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 297,
   FQN="(anonymous namespace)::TryResult::TryResult", NM="_ZN12_GLOBAL__N_19TryResultC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_19TryResultC1Eb")
  //</editor-fold>
  public TryResult(boolean b) {
    // : X(b ? 1 : 0) 
    //START JInit
    this.X = b ? 1 : 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::TryResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 298,
   FQN="(anonymous namespace)::TryResult::TryResult", NM="_ZN12_GLOBAL__N_19TryResultC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_19TryResultC1Ev")
  //</editor-fold>
  public TryResult() {
    // : X(-1) 
    //START JInit
    this.X = -1;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::isTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 300,
   FQN="(anonymous namespace)::TryResult::isTrue", NM="_ZNK12_GLOBAL__N_19TryResult6isTrueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_19TryResult6isTrueEv")
  //</editor-fold>
  public boolean isTrue() /*const*/ {
    return X == 1;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::isFalse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 301,
   FQN="(anonymous namespace)::TryResult::isFalse", NM="_ZNK12_GLOBAL__N_19TryResult7isFalseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_19TryResult7isFalseEv")
  //</editor-fold>
  public boolean isFalse() /*const*/ {
    return X == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::isKnown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 302,
   FQN="(anonymous namespace)::TryResult::isKnown", NM="_ZNK12_GLOBAL__N_19TryResult7isKnownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_19TryResult7isKnownEv")
  //</editor-fold>
  public boolean isKnown() /*const*/ {
    return X >= 0;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::negate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 303,
   FQN="(anonymous namespace)::TryResult::negate", NM="_ZN12_GLOBAL__N_19TryResult6negateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_19TryResult6negateEv")
  //</editor-fold>
  public void negate() {
    assert (isKnown());
    X ^= 0x1;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::TryResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 294,
   FQN="(anonymous namespace)::TryResult::TryResult", NM="_ZN12_GLOBAL__N_19TryResultC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_19TryResultC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TryResult(final /*const*/ TryResult /*&*/ $Prm0) {
    // : X(.X) 
    //START JInit
    this.X = $Prm0.X;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::TryResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 294,
   FQN="(anonymous namespace)::TryResult::TryResult", NM="_ZN12_GLOBAL__N_19TryResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_19TryResultC1EOS0_")
  //</editor-fold>
  public /*inline*/ TryResult(JD$Move _dparam, final TryResult /*&&*/$Prm0) {
    // : X(static_cast<TryResult &&>().X) 
    //START JInit
    this.X = $Prm0.X;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 294,
   FQN="(anonymous namespace)::TryResult::operator=", NM="_ZN12_GLOBAL__N_19TryResultaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_19TryResultaSERKS0_")
  //</editor-fold>
  public /*inline*/ TryResult /*&*/ $assign(final /*const*/ TryResult /*&*/ $Prm0) {
    this.X = $Prm0.X;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 294,
   FQN="(anonymous namespace)::TryResult::operator=", NM="_ZN12_GLOBAL__N_19TryResultaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_19TryResultaSEOS0_")
  //</editor-fold>
  public /*inline*/ TryResult /*&*/ $assignMove(final TryResult /*&&*/$Prm0) {
    this.X = $Prm0.X;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public TryResult clone() { return new TryResult(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "X=" + X; // NOI18N
  }

}
