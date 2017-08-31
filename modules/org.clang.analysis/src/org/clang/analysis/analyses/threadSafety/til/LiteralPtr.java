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
import org.clang.ast.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// A Literal pointer to an object allocated in memory.
/// At compile time, pointer literals are represented by symbolic names.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::LiteralPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 627,
 FQN="clang::threadSafety::til::LiteralPtr", NM="_ZN5clang12threadSafety3til10LiteralPtrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10LiteralPtrE")
//</editor-fold>
public class LiteralPtr extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::LiteralPtr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 629,
   FQN="clang::threadSafety::til::LiteralPtr::classof", NM="_ZN5clang12threadSafety3til10LiteralPtr7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10LiteralPtr7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_LiteralPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::LiteralPtr::LiteralPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 631,
   FQN="clang::threadSafety::til::LiteralPtr::LiteralPtr", NM="_ZN5clang12threadSafety3til10LiteralPtrC1EPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10LiteralPtrC1EPKNS_9ValueDeclE")
  //</editor-fold>
  public LiteralPtr(/*const*/ ValueDecl /*P*/ D) {
    // : SExpr(COP_LiteralPtr), Cvdecl(D) 
    //START JInit
    super(TIL_Opcode.COP_LiteralPtr);
    this.Cvdecl = D;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::LiteralPtr::LiteralPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 632,
   FQN="clang::threadSafety::til::LiteralPtr::LiteralPtr", NM="_ZN5clang12threadSafety3til10LiteralPtrC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10LiteralPtrC1ERKS2_")
  //</editor-fold>
  public LiteralPtr(final /*const*/ LiteralPtr /*&*/ R) {
    // : SExpr(R), Cvdecl(R.Cvdecl) 
    //START JInit
    super(R);
    this.Cvdecl = R.Cvdecl;
    //END JInit
  }

  
  // The clang declaration for the value that this pointer points to.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::LiteralPtr::clangDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 635,
   FQN="clang::threadSafety::til::LiteralPtr::clangDecl", NM="_ZNK5clang12threadSafety3til10LiteralPtr9clangDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10LiteralPtr9clangDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ clangDecl() /*const*/ {
    return Cvdecl;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::LiteralPtr::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 638,
   FQN="clang::threadSafety::til::LiteralPtr::traverse", NM="Tpl__ZN5clang12threadSafety3til10LiteralPtr8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til10LiteralPtr8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    return Vs.reduceLiteralPtr(/*Deref*/this);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::LiteralPtr::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 643,
   FQN="clang::threadSafety::til::LiteralPtr::compare", NM="Tpl__ZNK5clang12threadSafety3til10LiteralPtr7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til10LiteralPtr7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ LiteralPtr /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    return Cmp.comparePointers(Cvdecl, E.Cvdecl);
  }

/*private:*/
  private /*const*/ ValueDecl /*P*/ Cvdecl;
  
  @Override public String toString() {
    return "" + "Cvdecl=" + Cvdecl // NOI18N
              + super.toString(); // NOI18N
  }
}
