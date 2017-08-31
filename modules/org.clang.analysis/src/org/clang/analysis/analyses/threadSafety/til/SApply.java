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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// Apply a self-argument to a self-applicable function.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 869,
 FQN="clang::threadSafety::til::SApply", NM="_ZN5clang12threadSafety3til6SApplyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6SApplyE")
//</editor-fold>
public class SApply extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 871,
   FQN="clang::threadSafety::til::SApply::classof", NM="_ZN5clang12threadSafety3til6SApply7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6SApply7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_SApply;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::SApply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 873,
   FQN="clang::threadSafety::til::SApply::SApply", NM="_ZN5clang12threadSafety3til6SApplyC1EPNS1_5SExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6SApplyC1EPNS1_5SExprES4_")
  //</editor-fold>
  public SApply(SExpr /*P*/ Sf) {
    this(Sf, (SExpr /*P*/ )null);
  }
  public SApply(SExpr /*P*/ Sf, SExpr /*P*/ A/*= null*/) {
    // : SExpr(COP_SApply), Sfun(Sf), Arg(A) 
    //START JInit
    super(TIL_Opcode.COP_SApply);
    this.Sfun = Sf;
    this.Arg = A;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::SApply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 874,
   FQN="clang::threadSafety::til::SApply::SApply", NM="_ZN5clang12threadSafety3til6SApplyC1ERS2_PNS1_5SExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6SApplyC1ERS2_PNS1_5SExprES5_")
  //</editor-fold>
  public SApply(final SApply /*&*/ A, SExpr /*P*/ Sf) {
    this(A, Sf, (SExpr /*P*/ )null);
  }
  public SApply(final SApply /*&*/ A, SExpr /*P*/ Sf, SExpr /*P*/ Ar/*= null*/) {
    // : SExpr(A), Sfun(Sf), Arg(Ar) 
    //START JInit
    // rewrite constructor
    super(A);
    this.Sfun = Sf;
    this.Arg = Ar;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::sfun">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 877,
   FQN="clang::threadSafety::til::SApply::sfun", NM="_ZN5clang12threadSafety3til6SApply4sfunEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6SApply4sfunEv")
  //</editor-fold>
  public SExpr /*P*/ sfun() {
    return Sfun;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::sfun">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 878,
   FQN="clang::threadSafety::til::SApply::sfun", NM="_ZNK5clang12threadSafety3til6SApply4sfunEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til6SApply4sfunEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ sfun$Const() /*const*/ {
    return Sfun;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::arg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 880,
   FQN="clang::threadSafety::til::SApply::arg", NM="_ZN5clang12threadSafety3til6SApply3argEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6SApply3argEv")
  //</editor-fold>
  public SExpr /*P*/ arg() {
    return (Arg != null) ? Arg : Sfun;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::arg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 881,
   FQN="clang::threadSafety::til::SApply::arg", NM="_ZNK5clang12threadSafety3til6SApply3argEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til6SApply3argEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ arg$Const() /*const*/ {
    return (Arg != null) ? Arg : Sfun;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::isDelegation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 883,
   FQN="clang::threadSafety::til::SApply::isDelegation", NM="_ZNK5clang12threadSafety3til6SApply12isDelegationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til6SApply12isDelegationEv")
  //</editor-fold>
  public boolean isDelegation() /*const*/ {
    return Arg != null;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 886,
   FQN="clang::threadSafety::til::SApply::traverse", NM="Tpl__ZN5clang12threadSafety3til6SApply8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til6SApply8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Nf = Vs.traverse(Sfun, Vs.subExprCtx(Ctx));
    boolean/*V.R_SExpr*/ Na = (Arg != null) ? Vs.traverse(Arg, Vs.subExprCtx(Ctx)) : null;
    return Vs.reduceSApply(/*Deref*/this, Nf, Na);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SApply::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 894,
   FQN="clang::threadSafety::til::SApply::compare", NM="Tpl__ZNK5clang12threadSafety3til6SApply7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til6SApply7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ SApply /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    boolean/*C.CType*/ Ct = Cmp.compare(sfun$Const(), E.sfun$Const());
    if (Native.$bool(Cmp.notTrue(Ct)) || (!(arg$Const() != null) && !(E.arg$Const() != null))) {
      return Ct;
    }
    return Cmp.compare(arg$Const(), E.arg$Const());
  }

/*private:*/
  private SExpr /*P*/ Sfun;
  private SExpr /*P*/ Arg;
  
  @Override public String toString() {
    return "" + "Sfun=" + Sfun // NOI18N
              + ", Arg=" + Arg // NOI18N
              + super.toString(); // NOI18N
  }
}
