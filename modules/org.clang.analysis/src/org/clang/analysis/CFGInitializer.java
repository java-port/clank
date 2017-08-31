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

package org.clang.analysis;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;


/// CFGInitializer - Represents C++ base or member initializer from
/// constructor's initialization list.
//<editor-fold defaultstate="collapsed" desc="clang::CFGInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 133,
 FQN="clang::CFGInitializer", NM="_ZN5clang14CFGInitializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang14CFGInitializerE")
//</editor-fold>
public class CFGInitializer extends /*public*/ CFGElement {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGInitializer::CFGInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 135,
   FQN="clang::CFGInitializer::CFGInitializer", NM="_ZN5clang14CFGInitializerC1EPNS_18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang14CFGInitializerC1EPNS_18CXXCtorInitializerE")
  //</editor-fold>
  public CFGInitializer(CXXCtorInitializer /*P*/ initializer) {
    // : CFGElement(Initializer, initializer) 
    //START JInit
    super(Kind.Initializer, initializer);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGInitializer::getInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 138,
   FQN="clang::CFGInitializer::getInitializer", NM="_ZNK5clang14CFGInitializer14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang14CFGInitializer14getInitializerEv")
  //</editor-fold>
  public CXXCtorInitializer /*P*/ getInitializer() /*const*/ {
    return ((/*static_cast*/CXXCtorInitializer /*P*/ )(Data1.getPointer()));
  }

/*private:*/
  /*friend  class CFGElement*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGInitializer::CFGInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 144,
   FQN="clang::CFGInitializer::CFGInitializer", NM="_ZN5clang14CFGInitializerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang14CFGInitializerC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ CFGInitializer() {
    // : CFGElement() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGInitializer::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 145,
   FQN="clang::CFGInitializer::isKind", NM="_ZN5clang14CFGInitializer6isKindERKNS_10CFGElementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang14CFGInitializer6isKindERKNS_10CFGElementE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ CFGElement /*&*/ E) {
    return E.getKind() == Kind.Initializer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGInitializer::CFGInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 133,
   FQN="clang::CFGInitializer::CFGInitializer", NM="_ZN5clang14CFGInitializerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang14CFGInitializerC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CFGInitializer(final /*const*/ CFGInitializer /*&*/ $Prm0) {
    // : CFGElement() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGInitializer::CFGInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 133,
   FQN="clang::CFGInitializer::CFGInitializer", NM="_ZN5clang14CFGInitializerC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang14CFGInitializerC1EOS0_")
  //</editor-fold>
  public /*inline*/ CFGInitializer(JD$Move _dparam, final CFGInitializer /*&&*/$Prm0) {
    // : CFGElement(static_cast<CFGInitializer &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public CFGInitializer clone() {
    assert this.getClass() == CFGInitializer.class : "must be overridden in " + this.getClass();
    return new CFGInitializer(this);
  }
  
  @Override public CFGInitializer move() {
    assert this.getClass() == CFGInitializer.class : "must be overridden in " + this.getClass();
    return new CFGInitializer(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  ////////////////////////////////////////////////////////////// 
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
