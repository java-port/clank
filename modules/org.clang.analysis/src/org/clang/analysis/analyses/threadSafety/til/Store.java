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


/// Store a value to memory.
/// The destination is a pointer to a field, the source is the value to store.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1058,
 FQN="clang::threadSafety::til::Store", NM="_ZN5clang12threadSafety3til5StoreE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5StoreE")
//</editor-fold>
public class Store extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1060,
   FQN="clang::threadSafety::til::Store::classof", NM="_ZN5clang12threadSafety3til5Store7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5Store7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Store;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::Store">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1062,
   FQN="clang::threadSafety::til::Store::Store", NM="_ZN5clang12threadSafety3til5StoreC1EPNS1_5SExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5StoreC1EPNS1_5SExprES4_")
  //</editor-fold>
  public Store(SExpr /*P*/ P, SExpr /*P*/ V) {
    // : SExpr(COP_Store), Dest(P), Source(V) 
    //START JInit
    super(TIL_Opcode.COP_Store);
    this.Dest = P;
    this.Source = V;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::Store">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1063,
   FQN="clang::threadSafety::til::Store::Store", NM="_ZN5clang12threadSafety3til5StoreC1ERKS2_PNS1_5SExprES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5StoreC1ERKS2_PNS1_5SExprES6_")
  //</editor-fold>
  public Store(final /*const*/ Store /*&*/ S, SExpr /*P*/ P, SExpr /*P*/ V) {
    // : SExpr(S), Dest(P), Source(V) 
    //START JInit
    super(S);
    this.Dest = P;
    this.Source = V;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::destination">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1065,
   FQN="clang::threadSafety::til::Store::destination", NM="_ZN5clang12threadSafety3til5Store11destinationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5Store11destinationEv")
  //</editor-fold>
  public SExpr /*P*/ destination() {
    return Dest;
  } // Address to store to

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::destination">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1066,
   FQN="clang::threadSafety::til::Store::destination", NM="_ZNK5clang12threadSafety3til5Store11destinationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til5Store11destinationEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ destination$Const() /*const*/ {
    return Dest;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::source">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1068,
   FQN="clang::threadSafety::til::Store::source", NM="_ZN5clang12threadSafety3til5Store6sourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5Store6sourceEv")
  //</editor-fold>
  public SExpr /*P*/ source() {
    return Source;
  } // Value to store

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::source">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1069,
   FQN="clang::threadSafety::til::Store::source", NM="_ZNK5clang12threadSafety3til5Store6sourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til5Store6sourceEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ source$Const() /*const*/ {
    return Source;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1072,
   FQN="clang::threadSafety::til::Store::traverse", NM="Tpl__ZN5clang12threadSafety3til5Store8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til5Store8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Np = Vs.traverse(Dest, Vs.subExprCtx(Ctx));
    /*<dependent type>*/boolean Nv = Vs.traverse(Source, Vs.subExprCtx(Ctx));
    return Vs.reduceStore(/*Deref*/this, Np, Nv);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Store::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1079,
   FQN="clang::threadSafety::til::Store::compare", NM="Tpl__ZNK5clang12threadSafety3til5Store7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til5Store7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Store /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    boolean/*C.CType*/ Ct = Cmp.compare(destination$Const(), E.destination$Const());
    if (Cmp.notTrue(Ct)) {
      return Ct;
    }
    return Cmp.compare(source$Const(), E.source$Const());
  }

/*private:*/
  private SExpr /*P*/ Dest;
  private SExpr /*P*/ Source;
  
  @Override public String toString() {
    return "" + "Dest=" + Dest // NOI18N
              + ", Source=" + Source // NOI18N
              + super.toString(); // NOI18N
  }
}
