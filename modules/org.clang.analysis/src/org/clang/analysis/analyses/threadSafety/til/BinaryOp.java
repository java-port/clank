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


/// Simple arithmetic binary operations, e.g. +, -, etc.
/// These operations have no side effects.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1207,
 FQN="clang::threadSafety::til::BinaryOp", NM="_ZN5clang12threadSafety3til8BinaryOpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8BinaryOpE")
//</editor-fold>
public class BinaryOp extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1209,
   FQN="clang::threadSafety::til::BinaryOp::classof", NM="_ZN5clang12threadSafety3til8BinaryOp7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8BinaryOp7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_BinaryOp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::BinaryOp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1211,
   FQN="clang::threadSafety::til::BinaryOp::BinaryOp", NM="_ZN5clang12threadSafety3til8BinaryOpC1ENS1_16TIL_BinaryOpcodeEPNS1_5SExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8BinaryOpC1ENS1_16TIL_BinaryOpcodeEPNS1_5SExprES5_")
  //</editor-fold>
  public BinaryOp(TIL_BinaryOpcode Op, SExpr /*P*/ E0, SExpr /*P*/ E1) {
    // : SExpr(COP_BinaryOp), Expr0(E0), Expr1(E1) 
    //START JInit
    super(TIL_Opcode.COP_BinaryOp);
    this.Expr0 = E0;
    this.Expr1 = E1;
    //END JInit
    Flags = $uint2ushort(Op.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::BinaryOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1215,
   FQN="clang::threadSafety::til::BinaryOp::BinaryOp", NM="_ZN5clang12threadSafety3til8BinaryOpC1ERKS2_PNS1_5SExprES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8BinaryOpC1ERKS2_PNS1_5SExprES6_")
  //</editor-fold>
  public BinaryOp(final /*const*/ BinaryOp /*&*/ B, SExpr /*P*/ E0, SExpr /*P*/ E1) {
    // : SExpr(B), Expr0(E0), Expr1(E1) 
    //START JInit
    super(B);
    this.Expr0 = E0;
    this.Expr1 = E1;
    //END JInit
    Flags = B.Flags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::binaryOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1220,
   FQN="clang::threadSafety::til::BinaryOp::binaryOpcode", NM="_ZNK5clang12threadSafety3til8BinaryOp12binaryOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8BinaryOp12binaryOpcodeEv")
  //</editor-fold>
  public TIL_BinaryOpcode binaryOpcode() /*const*/ {
    return /*static_cast*/TIL_BinaryOpcode.valueOf(Flags);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::expr0">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1224,
   FQN="clang::threadSafety::til::BinaryOp::expr0", NM="_ZN5clang12threadSafety3til8BinaryOp5expr0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8BinaryOp5expr0Ev")
  //</editor-fold>
  public SExpr /*P*/ expr0() {
    return Expr0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::expr0">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1225,
   FQN="clang::threadSafety::til::BinaryOp::expr0", NM="_ZNK5clang12threadSafety3til8BinaryOp5expr0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8BinaryOp5expr0Ev")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ expr0$Const() /*const*/ {
    return Expr0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::expr1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1227,
   FQN="clang::threadSafety::til::BinaryOp::expr1", NM="_ZN5clang12threadSafety3til8BinaryOp5expr1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8BinaryOp5expr1Ev")
  //</editor-fold>
  public SExpr /*P*/ expr1() {
    return Expr1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::expr1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1228,
   FQN="clang::threadSafety::til::BinaryOp::expr1", NM="_ZNK5clang12threadSafety3til8BinaryOp5expr1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8BinaryOp5expr1Ev")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ expr1$Const() /*const*/ {
    return Expr1;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1231,
   FQN="clang::threadSafety::til::BinaryOp::traverse", NM="Tpl__ZN5clang12threadSafety3til8BinaryOp8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til8BinaryOp8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Ne0 = Vs.traverse(Expr0, Vs.subExprCtx(Ctx));
    /*<dependent type>*/boolean Ne1 = Vs.traverse(Expr1, Vs.subExprCtx(Ctx));
    return Vs.reduceBinaryOp(/*Deref*/this, Ne0, Ne1);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BinaryOp::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1238,
   FQN="clang::threadSafety::til::BinaryOp::compare", NM="Tpl__ZNK5clang12threadSafety3til8BinaryOp7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til8BinaryOp7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ BinaryOp /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    boolean/*C.CType*/ Ct = Cmp.compareIntegers(binaryOpcode().getValue(), E.binaryOpcode().getValue());
    if (Cmp.notTrue(Ct)) {
      return Ct;
    }
    Ct = Cmp.compare(expr0$Const(), E.expr0$Const());
    if (Cmp.notTrue(Ct)) {
      return Ct;
    }
    return Cmp.compare(expr1$Const(), E.expr1$Const());
  }

/*private:*/
  private SExpr /*P*/ Expr0;
  private SExpr /*P*/ Expr1;
  
  @Override public String toString() {
    return "" + "Expr0=" + Expr0 // NOI18N
              + ", Expr1=" + Expr1 // NOI18N
              + super.toString(); // NOI18N
  }
}
