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
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// A conditional branch to two other blocks.
/// Note that unlike Goto, Branch does not have an index.  The target blocks
/// must be child-blocks, and cannot have Phi nodes.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1422,
 FQN="clang::threadSafety::til::Branch", NM="_ZN5clang12threadSafety3til6BranchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6BranchE")
//</editor-fold>
public class Branch extends /*public*/ Terminator {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1424,
   FQN="clang::threadSafety::til::Branch::classof", NM="_ZN5clang12threadSafety3til6Branch7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Branch7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Branch;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::Branch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1426,
   FQN="clang::threadSafety::til::Branch::Branch", NM="_ZN5clang12threadSafety3til6BranchC1EPNS1_5SExprEPNS1_10BasicBlockES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6BranchC1EPNS1_5SExprEPNS1_10BasicBlockES6_")
  //</editor-fold>
  public Branch(SExpr /*P*/ C, BasicBlock /*P*/ T, BasicBlock /*P*/ E) {
    // : Terminator(COP_Branch), Condition(C) 
    //START JInit
    super(TIL_Opcode.COP_Branch);
    this.Condition = C;
    //END JInit
    Branches[0] = T;
    Branches[1] = E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::Branch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1431,
   FQN="clang::threadSafety::til::Branch::Branch", NM="_ZN5clang12threadSafety3til6BranchC1ERKS2_PNS1_5SExprEPNS1_10BasicBlockES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6BranchC1ERKS2_PNS1_5SExprEPNS1_10BasicBlockES8_")
  //</editor-fold>
  public Branch(final /*const*/ Branch /*&*/ Br, SExpr /*P*/ C, BasicBlock /*P*/ T, BasicBlock /*P*/ E) {
    // : Terminator(Br), Condition(C) 
    //START JInit
    super(Br);
    this.Condition = C;
    //END JInit
    Branches[0] = T;
    Branches[1] = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::condition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1437,
   FQN="clang::threadSafety::til::Branch::condition", NM="_ZNK5clang12threadSafety3til6Branch9conditionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til6Branch9conditionEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ condition$Const() /*const*/ {
    return Condition;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::condition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1438,
   FQN="clang::threadSafety::til::Branch::condition", NM="_ZN5clang12threadSafety3til6Branch9conditionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Branch9conditionEv")
  //</editor-fold>
  public SExpr /*P*/ condition() {
    return Condition;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::thenBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1440,
   FQN="clang::threadSafety::til::Branch::thenBlock", NM="_ZNK5clang12threadSafety3til6Branch9thenBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til6Branch9thenBlockEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ thenBlock$Const() /*const*/ {
    return Branches[0];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::thenBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1441,
   FQN="clang::threadSafety::til::Branch::thenBlock", NM="_ZN5clang12threadSafety3til6Branch9thenBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Branch9thenBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ thenBlock() {
    return Branches[0];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::elseBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1443,
   FQN="clang::threadSafety::til::Branch::elseBlock", NM="_ZNK5clang12threadSafety3til6Branch9elseBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til6Branch9elseBlockEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ elseBlock$Const() /*const*/ {
    return Branches[1];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::elseBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1444,
   FQN="clang::threadSafety::til::Branch::elseBlock", NM="_ZN5clang12threadSafety3til6Branch9elseBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Branch9elseBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ elseBlock() {
    return Branches[1];
  }

  
  /// Return the list of basic blocks that this terminator can branch to.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::successors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1447,
   FQN="clang::threadSafety::til::Branch::successors", NM="_ZN5clang12threadSafety3til6Branch10successorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Branch10successorsEv")
  //</editor-fold>
  public ArrayRef<BasicBlock /*P*/ > successors() {
    return llvm.makeArrayRef(Branches);
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1452,
   FQN="clang::threadSafety::til::Branch::traverse", NM="Tpl__ZN5clang12threadSafety3til6Branch8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til6Branch8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Nc = Vs.traverse(Condition, Vs.subExprCtx(Ctx));
    BasicBlock /*P*/ Ntb = Vs.reduceBasicBlockRef(Branches[0]);
    BasicBlock /*P*/ Nte = Vs.reduceBasicBlockRef(Branches[1]);
    return Vs.reduceBranch(/*Deref*/this, Nc, Ntb, Nte);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Branch::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1460,
   FQN="clang::threadSafety::til::Branch::compare", NM="Tpl__ZNK5clang12threadSafety3til6Branch7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til6Branch7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Branch /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    // TODO: implement CFG comparisons
    return Cmp.comparePointers(this, E);
  }

/*private:*/
  private SExpr /*P*/ Condition;
  private BasicBlock /*P*/ Branches[/*2*/] = new BasicBlock /*P*/  [2];
  
  @Override public String toString() {
    return "" + "Condition=" + Condition // NOI18N
              + ", Branches=" + Branches // NOI18N
              + super.toString(); // NOI18N
  }
}
