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
import static org.clank.support.Unsigned.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// Simple arithmetic unary operations, e.g. negate and not.
/// These operations have no side-effects.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1169,
 FQN="clang::threadSafety::til::UnaryOp", NM="_ZN5clang12threadSafety3til7UnaryOpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7UnaryOpE")
//</editor-fold>
public class UnaryOp extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1171,
   FQN="clang::threadSafety::til::UnaryOp::classof", NM="_ZN5clang12threadSafety3til7UnaryOp7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7UnaryOp7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_UnaryOp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp::UnaryOp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1173,
   FQN="clang::threadSafety::til::UnaryOp::UnaryOp", NM="_ZN5clang12threadSafety3til7UnaryOpC1ENS1_15TIL_UnaryOpcodeEPNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7UnaryOpC1ENS1_15TIL_UnaryOpcodeEPNS1_5SExprE")
  //</editor-fold>
  public UnaryOp(TIL_UnaryOpcode Op, SExpr /*P*/ E) {
    // : SExpr(COP_UnaryOp), Expr0(E) 
    //START JInit
    super(TIL_Opcode.COP_UnaryOp);
    this.Expr0 = E;
    //END JInit
    Flags = $uint2ushort(Op.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp::UnaryOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1176,
   FQN="clang::threadSafety::til::UnaryOp::UnaryOp", NM="_ZN5clang12threadSafety3til7UnaryOpC1ERKS2_PNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7UnaryOpC1ERKS2_PNS1_5SExprE")
  //</editor-fold>
  public UnaryOp(final /*const*/ UnaryOp /*&*/ U, SExpr /*P*/ E) {
    // : SExpr(U), Expr0(E) 
    //START JInit
    super(U);
    this.Expr0 = E;
    //END JInit
    Flags = U.Flags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp::unaryOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1178,
   FQN="clang::threadSafety::til::UnaryOp::unaryOpcode", NM="_ZNK5clang12threadSafety3til7UnaryOp11unaryOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til7UnaryOp11unaryOpcodeEv")
  //</editor-fold>
  public TIL_UnaryOpcode unaryOpcode() /*const*/ {
    return /*static_cast*/TIL_UnaryOpcode.valueOf(Flags);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp::expr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1182,
   FQN="clang::threadSafety::til::UnaryOp::expr", NM="_ZN5clang12threadSafety3til7UnaryOp4exprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7UnaryOp4exprEv")
  //</editor-fold>
  public SExpr /*P*/ expr() {
    return Expr0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp::expr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1183,
   FQN="clang::threadSafety::til::UnaryOp::expr", NM="_ZNK5clang12threadSafety3til7UnaryOp4exprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til7UnaryOp4exprEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ expr$Const() /*const*/ {
    return Expr0;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1186,
   FQN="clang::threadSafety::til::UnaryOp::traverse", NM="Tpl__ZN5clang12threadSafety3til7UnaryOp8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til7UnaryOp8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Ne = Vs.traverse(Expr0, Vs.subExprCtx(Ctx));
    return Vs.reduceUnaryOp(/*Deref*/this, Ne);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UnaryOp::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1192,
   FQN="clang::threadSafety::til::UnaryOp::compare", NM="Tpl__ZNK5clang12threadSafety3til7UnaryOp7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til7UnaryOp7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ UnaryOp /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    boolean/*C.CType*/ Ct = Cmp.compareIntegers(unaryOpcode().getValue(), E.unaryOpcode().getValue());
    if (Cmp.notTrue(Ct)) {
      return Ct;
    }
    return Cmp.compare(expr$Const(), E.expr$Const());
  }

/*private:*/
  private SExpr /*P*/ Expr0;
  
  @Override public String toString() {
    return "" + "Expr0=" + Expr0 // NOI18N
              + super.toString(); // NOI18N
  }
}
