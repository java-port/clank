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
import static org.llvm.support.llvm.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// Return from the enclosing function, passing the return value to the caller.
/// Only the exit block should end with a return statement.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1473,
 FQN="clang::threadSafety::til::Return", NM="_ZN5clang12threadSafety3til6ReturnE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6ReturnE")
//</editor-fold>
public class Return extends /*public*/ Terminator {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1475,
   FQN="clang::threadSafety::til::Return::classof", NM="_ZN5clang12threadSafety3til6Return7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Return7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return::Return">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1477,
   FQN="clang::threadSafety::til::Return::Return", NM="_ZN5clang12threadSafety3til6ReturnC1EPNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6ReturnC1EPNS1_5SExprE")
  //</editor-fold>
  public Return(SExpr /*P*/ Rval) {
    // : Terminator(COP_Return), Retval(Rval) 
    //START JInit
    super(TIL_Opcode.COP_Return);
    this.Retval = Rval;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return::Return">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1478,
   FQN="clang::threadSafety::til::Return::Return", NM="_ZN5clang12threadSafety3til6ReturnC1ERKS2_PNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6ReturnC1ERKS2_PNS1_5SExprE")
  //</editor-fold>
  public Return(final /*const*/ Return /*&*/ R, SExpr /*P*/ Rval) {
    // : Terminator(R), Retval(Rval) 
    //START JInit
    super(R);
    this.Retval = Rval;
    //END JInit
  }

  
  /// Return an empty list.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return::successors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1481,
   FQN="clang::threadSafety::til::Return::successors", NM="_ZN5clang12threadSafety3til6Return10successorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Return10successorsEv")
  //</editor-fold>
  public ArrayRef<BasicBlock /*P*/ > successors() {
    return new ArrayRef<BasicBlock /*P*/ >(None, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return::returnValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1485,
   FQN="clang::threadSafety::til::Return::returnValue", NM="_ZN5clang12threadSafety3til6Return11returnValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Return11returnValueEv")
  //</editor-fold>
  public SExpr /*P*/ returnValue() {
    return Retval;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return::returnValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1486,
   FQN="clang::threadSafety::til::Return::returnValue", NM="_ZNK5clang12threadSafety3til6Return11returnValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til6Return11returnValueEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ returnValue$Const() /*const*/ {
    return Retval;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1489,
   FQN="clang::threadSafety::til::Return::traverse", NM="Tpl__ZN5clang12threadSafety3til6Return8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til6Return8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Ne = Vs.traverse(Retval, Vs.subExprCtx(Ctx));
    return Vs.reduceReturn(/*Deref*/this, Ne);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Return::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1495,
   FQN="clang::threadSafety::til::Return::compare", NM="Tpl__ZNK5clang12threadSafety3til6Return7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til6Return7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Return /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    return Cmp.compare(Retval, E.Retval);
  }

/*private:*/
  private SExpr /*P*/ Retval;
  
  @Override public String toString() {
    return "" + "Retval=" + Retval // NOI18N
              + super.toString(); // NOI18N
  }
}
