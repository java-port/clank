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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 494,
 FQN="clang::ento::SwitchNodeBuilder", NM="_ZN5clang4ento17SwitchNodeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilderE")
//</editor-fold>
public class SwitchNodeBuilder {
  private final CoreEngine /*&*/ Eng;
  private /*const*/ CFGBlock /*P*/ Src;
  private /*const*/ Expr /*P*/ Condition;
  private ExplodedNode /*P*/ Pred;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::SwitchNodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 501,
   FQN="clang::ento::SwitchNodeBuilder::SwitchNodeBuilder", NM="_ZN5clang4ento17SwitchNodeBuilderC1EPNS0_12ExplodedNodeEPKNS_8CFGBlockEPKNS_4ExprEPNS0_10CoreEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilderC1EPNS0_12ExplodedNodeEPKNS_8CFGBlockEPKNS_4ExprEPNS0_10CoreEngineE")
  //</editor-fold>
  public SwitchNodeBuilder(ExplodedNode /*P*/ pred, /*const*/ CFGBlock /*P*/ src, 
      /*const*/ Expr /*P*/ condition, CoreEngine /*P*/ eng) {
    // : Eng(*eng), Src(src), Condition(condition), Pred(pred) 
    //START JInit
    this./*&*/Eng=/*&*/$Deref(eng);
    this.Src = src;
    this.Condition = condition;
    this.Pred = pred;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 505,
   FQN="clang::ento::SwitchNodeBuilder::iterator", NM="_ZN5clang4ento17SwitchNodeBuilder8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilder8iteratorE")
  //</editor-fold>
  public static class iterator implements Native.NativeComparable<iterator> {
    private std.reverse_iterator</*const*/ CFGBlock.AdjacentBlock> I;
    
    /*friend  class SwitchNodeBuilder*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 509,
     FQN="clang::ento::SwitchNodeBuilder::iterator::iterator", NM="_ZN5clang4ento17SwitchNodeBuilder8iteratorC1ESt16reverse_iteratorIPKNS_8CFGBlock13AdjacentBlockEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilder8iteratorC1ESt16reverse_iteratorIPKNS_8CFGBlock13AdjacentBlockEE")
    //</editor-fold>
    private iterator(std.reverse_iterator</*const*/ CFGBlock.AdjacentBlock> i) {
      // : I(i) 
      //START JInit
      this.I = new std.reverse_iterator</*const*/ CFGBlock.AdjacentBlock>(i);
      //END JInit
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 512,
     FQN="clang::ento::SwitchNodeBuilder::iterator::operator++", NM="_ZN5clang4ento17SwitchNodeBuilder8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilder8iteratorppEv")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      I.$preInc();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 513,
     FQN="clang::ento::SwitchNodeBuilder::iterator::operator!=", NM="_ZNK5clang4ento17SwitchNodeBuilder8iteratorneERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17SwitchNodeBuilder8iteratorneERKS2_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ iterator /*&*/ X) /*const*/ {
      return $noteq_reverse_iterator$C(I, X.I);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 514,
     FQN="clang::ento::SwitchNodeBuilder::iterator::operator==", NM="_ZNK5clang4ento17SwitchNodeBuilder8iteratoreqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17SwitchNodeBuilder8iteratoreqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ iterator /*&*/ X) /*const*/ {
      return $eq_reverse_iterator$C(I, X.I);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::iterator::getCase">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 516,
     FQN="clang::ento::SwitchNodeBuilder::iterator::getCase", NM="_ZNK5clang4ento17SwitchNodeBuilder8iterator7getCaseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17SwitchNodeBuilder8iterator7getCaseEv")
    //</editor-fold>
    public /*const*/ CaseStmt /*P*/ getCase() /*const*/ {
      return cast_CaseStmt((I.$star()).$arrow().getLabel());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::iterator::getBlock">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 520,
     FQN="clang::ento::SwitchNodeBuilder::iterator::getBlock", NM="_ZNK5clang4ento17SwitchNodeBuilder8iterator8getBlockEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17SwitchNodeBuilder8iterator8getBlockEv")
    //</editor-fold>
    public /*const*/ CFGBlock /*P*/ getBlock() /*const*/ {
      return I.$star().$CFGBlock$P();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 505,
     FQN="clang::ento::SwitchNodeBuilder::iterator::iterator", NM="_ZN5clang4ento17SwitchNodeBuilder8iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilder8iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : I(static_cast<iterator &&>().I) 
      //START JInit
      this.I = new std.reverse_iterator</*const*/ CFGBlock.AdjacentBlock>($Prm0.I);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "I=" + I; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 525,
   FQN="clang::ento::SwitchNodeBuilder::begin", NM="_ZN5clang4ento17SwitchNodeBuilder5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilder5beginEv")
  //</editor-fold>
  public iterator begin() {
    return new iterator(Src.succ_rbegin$Const().$add(1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 526,
   FQN="clang::ento::SwitchNodeBuilder::end", NM="_ZN5clang4ento17SwitchNodeBuilder3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilder3endEv")
  //</editor-fold>
  public iterator end() {
    return new iterator(Src.succ_rend$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::getSwitch">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 528,
   FQN="clang::ento::SwitchNodeBuilder::getSwitch", NM="_ZNK5clang4ento17SwitchNodeBuilder9getSwitchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17SwitchNodeBuilder9getSwitchEv")
  //</editor-fold>
  public /*const*/ SwitchStmt /*P*/ getSwitch() /*const*/ {
    return cast_SwitchStmt(Src.getTerminator$Const().getStmt());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::generateCaseStmtNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 705,
   FQN="clang::ento::SwitchNodeBuilder::generateCaseStmtNode", NM="_ZN5clang4ento17SwitchNodeBuilder20generateCaseStmtNodeERKNS1_8iteratorEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilder20generateCaseStmtNodeERKNS1_8iteratorEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateCaseStmtNode(final /*const*/ iterator /*&*/ I, 
                      IntrusiveRefCntPtr</*const*/ ProgramState> St) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      bool$ptr IsNew = create_bool$ptr();
      ExplodedNode /*P*/ Succ = $c$.clean(Eng.G.getNode(new BlockEdge(Src, I.getBlock(), Pred.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), false, $AddrOf(IsNew)));
      Succ.addPredecessor(Pred, Eng.G);
      if (!IsNew.$star()) {
        return null;
      }
      
      Eng.WList.$arrow().enqueue(Succ);
      return Succ;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::generateDefaultCaseNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 722,
   FQN="clang::ento::SwitchNodeBuilder::generateDefaultCaseNode", NM="_ZN5clang4ento17SwitchNodeBuilder23generateDefaultCaseNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17SwitchNodeBuilder23generateDefaultCaseNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb")
  //</editor-fold>
  public ExplodedNode /*P*/ generateDefaultCaseNode(IntrusiveRefCntPtr</*const*/ ProgramState> St) {
    return generateDefaultCaseNode(St, 
                         false);
  }
  public ExplodedNode /*P*/ generateDefaultCaseNode(IntrusiveRefCntPtr</*const*/ ProgramState> St, 
                         boolean IsSink/*= false*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Get the block for the default case.
      assert ($noteq_reverse_iterator$C(Src.succ_rbegin$Const(), Src.succ_rend$Const()));
      CFGBlock /*P*/ DefaultBlock = Src.succ_rbegin$Const().$star().$CFGBlock$P();
      
      // Sanity check for default blocks that are unreachable and not caught
      // by earlier stages.
      if (!(DefaultBlock != null)) {
        return null;
      }
      
      bool$ptr IsNew = create_bool$ptr();
      ExplodedNode /*P*/ Succ = $c$.clean(Eng.G.getNode(new BlockEdge(Src, DefaultBlock, Pred.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), IsSink, $AddrOf(IsNew)));
      Succ.addPredecessor(Pred, Eng.G);
      if (!IsNew.$star()) {
        return null;
      }
      if (!IsSink) {
        Eng.WList.$arrow().enqueue(Succ);
      }
      
      return Succ;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::getCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 538,
   FQN="clang::ento::SwitchNodeBuilder::getCondition", NM="_ZNK5clang4ento17SwitchNodeBuilder12getConditionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17SwitchNodeBuilder12getConditionEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCondition() /*const*/ {
    return Condition;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 540,
   FQN="clang::ento::SwitchNodeBuilder::getState", NM="_ZNK5clang4ento17SwitchNodeBuilder8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17SwitchNodeBuilder8getStateEv")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> getState() /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.State);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SwitchNodeBuilder::getLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 542,
   FQN="clang::ento::SwitchNodeBuilder::getLocationContext", NM="_ZNK5clang4ento17SwitchNodeBuilder18getLocationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17SwitchNodeBuilder18getLocationContextEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getLocationContext() /*const*/ {
    return Pred.getLocationContext();
  }

  
  @Override public String toString() {
    return "" + "Eng=" + "[CoreEngine]" // NOI18N
              + ", Src=" + Src // NOI18N
              + ", Condition=" + "[Expr]" // NOI18N
              + ", Pred=" + Pred; // NOI18N
  }
}
