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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// A function -- a.k.a. lambda abstraction.
/// Functions with multiple arguments are created by currying,
/// e.g. (Function (x: Int) (Function (y: Int) (Code { return x + y })))
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 655,
 FQN="clang::threadSafety::til::Function", NM="_ZN5clang12threadSafety3til8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8FunctionE")
//</editor-fold>
public class Function extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 657,
   FQN="clang::threadSafety::til::Function::classof", NM="_ZN5clang12threadSafety3til8Function7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Function7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Function;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::Function">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 659,
   FQN="clang::threadSafety::til::Function::Function", NM="_ZN5clang12threadSafety3til8FunctionC1EPNS1_8VariableEPNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8FunctionC1EPNS1_8VariableEPNS1_5SExprE")
  //</editor-fold>
  public Function(Variable /*P*/ Vd, SExpr /*P*/ Bd) {
    // : SExpr(COP_Function), VarDecl(Vd), Body(Bd) 
    //START JInit
    super(TIL_Opcode.COP_Function);
    this.VarDecl = Vd;
    this.Body = Bd;
    //END JInit
    Vd.setKind(Variable.VariableKind.VK_Fun);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::Function">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 663,
   FQN="clang::threadSafety::til::Function::Function", NM="_ZN5clang12threadSafety3til8FunctionC1ERKS2_PNS1_8VariableEPNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8FunctionC1ERKS2_PNS1_8VariableEPNS1_5SExprE")
  //</editor-fold>
  public Function(final /*const*/ Function /*&*/ F, Variable /*P*/ Vd, SExpr /*P*/ Bd) {
    // : SExpr(F), VarDecl(Vd), Body(Bd) 
    //START JInit
    // rewrite constructor
    super(F);
    this.VarDecl = Vd;
    this.Body = Bd;
    //END JInit
    Vd.setKind(Variable.VariableKind.VK_Fun);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::variableDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 668,
   FQN="clang::threadSafety::til::Function::variableDecl", NM="_ZN5clang12threadSafety3til8Function12variableDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Function12variableDeclEv")
  //</editor-fold>
  public Variable /*P*/ variableDecl() {
    return VarDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::variableDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 669,
   FQN="clang::threadSafety::til::Function::variableDecl", NM="_ZNK5clang12threadSafety3til8Function12variableDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8Function12variableDeclEv")
  //</editor-fold>
  public /*const*/ Variable /*P*/ variableDecl$Const() /*const*/ {
    return VarDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::body">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 671,
   FQN="clang::threadSafety::til::Function::body", NM="_ZN5clang12threadSafety3til8Function4bodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Function4bodyEv")
  //</editor-fold>
  public SExpr /*P*/ body() {
    return Body;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::body">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 672,
   FQN="clang::threadSafety::til::Function::body", NM="_ZNK5clang12threadSafety3til8Function4bodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8Function4bodyEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ body$Const() /*const*/ {
    return Body;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 675,
   FQN="clang::threadSafety::til::Function::traverse", NM="Tpl__ZN5clang12threadSafety3til8Function8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til8Function8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    // This is a variable declaration, so traverse the definition.
    /*<dependent type>*/boolean E0 = Vs.traverse(VarDecl.Definition, Vs.typeCtx(Ctx));
    // Tell the rewriter to enter the scope of the function.
    Variable /*P*/ Nvd = Vs.enterScope($Deref(VarDecl), E0);
    /*<dependent type>*/boolean E1 = Vs.traverse(Body, Vs.declCtx(Ctx));
    Vs.exitScope($Deref(VarDecl));
    return Vs.reduceFunction(/*Deref*/this, Nvd, E1);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Function::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 686,
   FQN="clang::threadSafety::til::Function::compare", NM="Tpl__ZNK5clang12threadSafety3til8Function7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til8Function7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Function /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    boolean/*C.CType*/ Ct = Cmp.compare(VarDecl.definition(), E.VarDecl.definition());
    if (Cmp.notTrue(Ct)) {
      return Ct;
    }
    Cmp.enterScope(variableDecl$Const(), E.variableDecl$Const());
    Ct = Cmp.compare(body$Const(), E.body$Const());
    Cmp.leaveScope();
    return Ct;
  }

/*private:*/
  private Variable /*P*/ VarDecl;
  private SExpr /*P*/ Body;
  
  @Override public String toString() {
    return "" + "VarDecl=" + VarDecl // NOI18N
              + ", Body=" + Body // NOI18N
              + super.toString(); // NOI18N
  }
}
