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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;


/// CFGTerminator - Represents CFGBlock terminator statement.
///
/// TemporaryDtorsBranch bit is set to true if the terminator marks a branch
/// in control flow of destructors of temporaries. In this case terminator
/// statement is the same statement that branches control flow in evaluation
/// of matching full expression.
//<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 303,
 FQN="clang::CFGTerminator", NM="_ZN5clang13CFGTerminatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatorE")
//</editor-fold>
public class CFGTerminator implements Native.Native$Bool {
  private PointerIntPair<Stmt /*P*/ > Data;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::CFGTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 306,
   FQN="clang::CFGTerminator::CFGTerminator", NM="_ZN5clang13CFGTerminatorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatorC1Ev")
  //</editor-fold>
  public CFGTerminator() {
    // : Data() 
    //START JInit
    this.Data = new PointerIntPair<Stmt /*P*/ >();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::CFGTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 307,
   FQN="clang::CFGTerminator::CFGTerminator", NM="_ZN5clang13CFGTerminatorC1EPNS_4StmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatorC1EPNS_4StmtEb")
  //</editor-fold>
  public CFGTerminator(Stmt /*P*/ S) {
    this(S, false);
  }
  public CFGTerminator(Stmt /*P*/ S, boolean TemporaryDtorsBranch/*= false*/) {
    // : Data(S, TemporaryDtorsBranch) 
    //START JInit
    this.Data = new PointerIntPair<Stmt /*P*/ >(S, (TemporaryDtorsBranch ? 1 : 0));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 310,
   FQN="clang::CFGTerminator::getStmt", NM="_ZN5clang13CFGTerminator7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminator7getStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getStmt() {
    return Data.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 311,
   FQN="clang::CFGTerminator::getStmt", NM="_ZNK5clang13CFGTerminator7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang13CFGTerminator7getStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getStmt$Const() /*const*/ {
    return Data.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::isTemporaryDtorsBranch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 313,
   FQN="clang::CFGTerminator::isTemporaryDtorsBranch", NM="_ZNK5clang13CFGTerminator22isTemporaryDtorsBranchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang13CFGTerminator22isTemporaryDtorsBranchEv")
  //</editor-fold>
  public boolean isTemporaryDtorsBranch() /*const*/ {
    return (Data.getInt() != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::operator Stmt * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 315,
   FQN="clang::CFGTerminator::operator Stmt * ", NM="_ZN5clang13CFGTerminatorcvPNS_4StmtEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatorcvPNS_4StmtEEv")
  //</editor-fold>
  public Stmt /*P*/ $Stmt$P() {
    return getStmt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::operator const Stmt * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 316,
   FQN="clang::CFGTerminator::operator const Stmt * ", NM="_ZNK5clang13CFGTerminatorcvPKNS_4StmtEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang13CFGTerminatorcvPKNS_4StmtEEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ $Stmt$C$P() /*const*/ {
    return getStmt$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 318,
   FQN="clang::CFGTerminator::operator->", NM="_ZN5clang13CFGTerminatorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatorptEv")
  //</editor-fold>
  public Stmt /*P*/ $arrow() {
    return getStmt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 319,
   FQN="clang::CFGTerminator::operator->", NM="_ZNK5clang13CFGTerminatorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang13CFGTerminatorptEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ $arrow$Const() /*const*/ {
    return getStmt$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 321,
   FQN="clang::CFGTerminator::operator*", NM="_ZN5clang13CFGTerminatordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatordeEv")
  //</editor-fold>
  public Stmt /*&*/ $star() {
    return $Deref(getStmt());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 322,
   FQN="clang::CFGTerminator::operator*", NM="_ZNK5clang13CFGTerminatordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang13CFGTerminatordeEv")
  //</editor-fold>
  public /*const*/ Stmt /*&*/ $star$Const() /*const*/ {
    return $Deref(getStmt$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 324,
   FQN="clang::CFGTerminator::operator bool", NM="_ZNK5clang13CFGTerminatorcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang13CFGTerminatorcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (getStmt$Const() != null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::CFGTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 303,
   FQN="clang::CFGTerminator::CFGTerminator", NM="_ZN5clang13CFGTerminatorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CFGTerminator(final /*const*/ CFGTerminator /*&*/ $Prm0) {
    // : Data(.Data) 
    //START JInit
    this.Data = new PointerIntPair<Stmt /*P*/ >($Prm0.Data);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::CFGTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 303,
   FQN="clang::CFGTerminator::CFGTerminator", NM="_ZN5clang13CFGTerminatorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatorC1EOS0_")
  //</editor-fold>
  public /*inline*/ CFGTerminator(JD$Move _dparam, final CFGTerminator /*&&*/$Prm0) {
    // : Data(static_cast<CFGTerminator &&>().Data) 
    //START JInit
    this.Data = new PointerIntPair<Stmt /*P*/ >(JD$Move.INSTANCE, $Prm0.Data);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGTerminator::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 303,
   FQN="clang::CFGTerminator::operator=", NM="_ZN5clang13CFGTerminatoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGTerminatoraSERKS0_")
  //</editor-fold>
  public /*inline*/ CFGTerminator /*&*/ $assign(final /*const*/ CFGTerminator /*&*/ $Prm0) {
    this.Data.$assign($Prm0.Data);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Data=" + Data; // NOI18N
  }
}
