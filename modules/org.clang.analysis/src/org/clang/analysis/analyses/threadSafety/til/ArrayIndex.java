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


/// If p is a reference to an array, then p[i] is a reference to the i'th
/// element of the array.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1094,
 FQN="clang::threadSafety::til::ArrayIndex", NM="_ZN5clang12threadSafety3til10ArrayIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10ArrayIndexE")
//</editor-fold>
public class ArrayIndex extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1096,
   FQN="clang::threadSafety::til::ArrayIndex::classof", NM="_ZN5clang12threadSafety3til10ArrayIndex7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10ArrayIndex7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_ArrayIndex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::ArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1098,
   FQN="clang::threadSafety::til::ArrayIndex::ArrayIndex", NM="_ZN5clang12threadSafety3til10ArrayIndexC1EPNS1_5SExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10ArrayIndexC1EPNS1_5SExprES4_")
  //</editor-fold>
  public ArrayIndex(SExpr /*P*/ A, SExpr /*P*/ N) {
    // : SExpr(COP_ArrayIndex), Array(A), Index(N) 
    //START JInit
    super(TIL_Opcode.COP_ArrayIndex);
    this.Array = A;
    this.Index = N;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::ArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1099,
   FQN="clang::threadSafety::til::ArrayIndex::ArrayIndex", NM="_ZN5clang12threadSafety3til10ArrayIndexC1ERKS2_PNS1_5SExprES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10ArrayIndexC1ERKS2_PNS1_5SExprES6_")
  //</editor-fold>
  public ArrayIndex(final /*const*/ ArrayIndex /*&*/ E, SExpr /*P*/ A, SExpr /*P*/ N) {
    // : SExpr(E), Array(A), Index(N) 
    //START JInit
    super(E);
    this.Array = A;
    this.Index = N;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::array">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1102,
   FQN="clang::threadSafety::til::ArrayIndex::array", NM="_ZN5clang12threadSafety3til10ArrayIndex5arrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10ArrayIndex5arrayEv")
  //</editor-fold>
  public SExpr /*P*/ array() {
    return Array;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::array">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1103,
   FQN="clang::threadSafety::til::ArrayIndex::array", NM="_ZNK5clang12threadSafety3til10ArrayIndex5arrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10ArrayIndex5arrayEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ array$Const() /*const*/ {
    return Array;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::index">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1105,
   FQN="clang::threadSafety::til::ArrayIndex::index", NM="_ZN5clang12threadSafety3til10ArrayIndex5indexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10ArrayIndex5indexEv")
  //</editor-fold>
  public SExpr /*P*/ index() {
    return Index;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::index">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1106,
   FQN="clang::threadSafety::til::ArrayIndex::index", NM="_ZNK5clang12threadSafety3til10ArrayIndex5indexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10ArrayIndex5indexEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ index$Const() /*const*/ {
    return Index;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1109,
   FQN="clang::threadSafety::til::ArrayIndex::traverse", NM="Tpl__ZN5clang12threadSafety3til10ArrayIndex8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til10ArrayIndex8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Na = Vs.traverse(Array, Vs.subExprCtx(Ctx));
    /*<dependent type>*/boolean Ni = Vs.traverse(Index, Vs.subExprCtx(Ctx));
    return Vs.reduceArrayIndex(/*Deref*/this, Na, Ni);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::ArrayIndex::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1116,
   FQN="clang::threadSafety::til::ArrayIndex::compare", NM="Tpl__ZNK5clang12threadSafety3til10ArrayIndex7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til10ArrayIndex7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ ArrayIndex /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    boolean/*C.CType*/ Ct = Cmp.compare(array$Const(), E.array$Const());
    if (Cmp.notTrue(Ct)) {
      return Ct;
    }
    return Cmp.compare(index$Const(), E.index$Const());
  }

/*private:*/
  private SExpr /*P*/ Array;
  private SExpr /*P*/ Index;
  
  @Override public String toString() {
    return "" + "Array=" + Array // NOI18N
              + ", Index=" + Index // NOI18N
              + super.toString(); // NOI18N
  }
}
