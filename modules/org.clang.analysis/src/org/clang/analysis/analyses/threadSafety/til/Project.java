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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// Project a named slot from a C++ struct or class.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 908,
 FQN="clang::threadSafety::til::Project", NM="_ZN5clang12threadSafety3til7ProjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7ProjectE")
//</editor-fold>
public class Project extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 910,
   FQN="clang::threadSafety::til::Project::classof", NM="_ZN5clang12threadSafety3til7Project7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7Project7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Project;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::Project">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 912,
   FQN="clang::threadSafety::til::Project::Project", NM="_ZN5clang12threadSafety3til7ProjectC1EPNS1_5SExprEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7ProjectC1EPNS1_5SExprEN4llvm9StringRefE")
  //</editor-fold>
  public Project(SExpr /*P*/ R, StringRef SName) {
    // : SExpr(COP_Project), Rec(R), SlotName(SName), Cvdecl(null) 
    //START JInit
    super(TIL_Opcode.COP_Project);
    this.Rec = R;
    this.SlotName = new StringRef(SName);
    this.Cvdecl = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::Project">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 915,
   FQN="clang::threadSafety::til::Project::Project", NM="_ZN5clang12threadSafety3til7ProjectC1EPNS1_5SExprEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7ProjectC1EPNS1_5SExprEPKNS_9ValueDeclE")
  //</editor-fold>
  public Project(SExpr /*P*/ R, /*const*/ ValueDecl /*P*/ Cvd) {
    // : SExpr(COP_Project), Rec(R), SlotName(Cvd->getName()), Cvdecl(Cvd) 
    //START JInit
    super(TIL_Opcode.COP_Project);
    this.Rec = R;
    this.SlotName = Cvd.getName();
    this.Cvdecl = Cvd;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::Project">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 918,
   FQN="clang::threadSafety::til::Project::Project", NM="_ZN5clang12threadSafety3til7ProjectC1ERKS2_PNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7ProjectC1ERKS2_PNS1_5SExprE")
  //</editor-fold>
  public Project(final /*const*/ Project /*&*/ P, SExpr /*P*/ R) {
    // : SExpr(P), Rec(R), SlotName(P.SlotName), Cvdecl(P.Cvdecl) 
    //START JInit
    super(P);
    this.Rec = R;
    this.SlotName = new StringRef(P.SlotName);
    this.Cvdecl = P.Cvdecl;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::record">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 922,
   FQN="clang::threadSafety::til::Project::record", NM="_ZN5clang12threadSafety3til7Project6recordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7Project6recordEv")
  //</editor-fold>
  public SExpr /*P*/ record() {
    return Rec;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::record">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 923,
   FQN="clang::threadSafety::til::Project::record", NM="_ZNK5clang12threadSafety3til7Project6recordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til7Project6recordEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ record$Const() /*const*/ {
    return Rec;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::clangDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 925,
   FQN="clang::threadSafety::til::Project::clangDecl", NM="_ZNK5clang12threadSafety3til7Project9clangDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til7Project9clangDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ clangDecl() /*const*/ {
    return Cvdecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::isArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 927,
   FQN="clang::threadSafety::til::Project::isArrow", NM="_ZNK5clang12threadSafety3til7Project7isArrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til7Project7isArrowEv")
  //</editor-fold>
  public boolean isArrow() /*const*/ {
    return ($ushort2int(Flags) & 0x01) != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::setArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 928,
   FQN="clang::threadSafety::til::Project::setArrow", NM="_ZN5clang12threadSafety3til7Project8setArrowEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7Project8setArrowEb")
  //</editor-fold>
  public void setArrow(boolean b) {
    if (b) {
      Flags |= 0x01;
    } else {
      Flags &= 0xFFFE;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::slotName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 933,
   FQN="clang::threadSafety::til::Project::slotName", NM="_ZNK5clang12threadSafety3til7Project8slotNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til7Project8slotNameEv")
  //</editor-fold>
  public StringRef slotName() /*const*/ {
    if ((Cvdecl != null)) {
      return Cvdecl.getName();
    } else {
      return new StringRef(SlotName);
    }
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 941,
   FQN="clang::threadSafety::til::Project::traverse", NM="Tpl__ZN5clang12threadSafety3til7Project8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til7Project8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Nr = Vs.traverse(Rec, Vs.subExprCtx(Ctx));
    return Vs.reduceProject(/*Deref*/this, Nr);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Project::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 947,
   FQN="clang::threadSafety::til::Project::compare", NM="Tpl__ZNK5clang12threadSafety3til7Project7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til7Project7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Project /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    boolean/*C.CType*/ Ct = Cmp.compare(record$Const(), E.record$Const());
    if (Cmp.notTrue(Ct)) {
      return Ct;
    }
    return Cmp.comparePointers(Cvdecl, E.Cvdecl);
  }

/*private:*/
  private SExpr /*P*/ Rec;
  private StringRef SlotName;
  private /*const*/ ValueDecl /*P*/ Cvdecl;
  
  @Override public String toString() {
    return "" + "Rec=" + Rec // NOI18N
              + ", SlotName=" + SlotName // NOI18N
              + ", Cvdecl=" + Cvdecl // NOI18N
              + super.toString(); // NOI18N
  }
}
