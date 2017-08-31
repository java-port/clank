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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 447,
 FQN="clang::ento::IndirectGotoNodeBuilder", NM="_ZN5clang4ento23IndirectGotoNodeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilderE")
//</editor-fold>
public class IndirectGotoNodeBuilder {
  private final CoreEngine /*&*/ Eng;
  private /*const*/ CFGBlock /*P*/ Src;
  private final /*const*/ CFGBlock /*&*/ DispatchBlock;
  private /*const*/ Expr /*P*/ E;
  private ExplodedNode /*P*/ Pred;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::IndirectGotoNodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 455,
   FQN="clang::ento::IndirectGotoNodeBuilder::IndirectGotoNodeBuilder", NM="_ZN5clang4ento23IndirectGotoNodeBuilderC1EPNS0_12ExplodedNodeEPKNS_8CFGBlockEPKNS_4ExprES6_PNS0_10CoreEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilderC1EPNS0_12ExplodedNodeEPKNS_8CFGBlockEPKNS_4ExprES6_PNS0_10CoreEngineE")
  //</editor-fold>
  public IndirectGotoNodeBuilder(ExplodedNode /*P*/ pred, /*const*/ CFGBlock /*P*/ src, 
      /*const*/ Expr /*P*/ e, /*const*/ CFGBlock /*P*/ dispatch, CoreEngine /*P*/ eng) {
    // : Eng(*eng), Src(src), DispatchBlock(*dispatch), E(e), Pred(pred) 
    //START JInit
    this./*&*/Eng=/*&*/$Deref(eng);
    this.Src = src;
    this./*&*/DispatchBlock=/*&*/$Deref(dispatch);
    this.E = e;
    this.Pred = pred;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 459,
   FQN="clang::ento::IndirectGotoNodeBuilder::iterator", NM="_ZN5clang4ento23IndirectGotoNodeBuilder8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilder8iteratorE")
  //</editor-fold>
  public static class iterator {
    private type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I;
    
    /*friend  class IndirectGotoNodeBuilder*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 463,
     FQN="clang::ento::IndirectGotoNodeBuilder::iterator::iterator", NM="_ZN5clang4ento23IndirectGotoNodeBuilder8iteratorC1EPKNS_8CFGBlock13AdjacentBlockE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilder8iteratorC1EPKNS_8CFGBlock13AdjacentBlockE")
    //</editor-fold>
    private iterator(type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > i) {
      // : I(i) 
      //START JInit
      this.I = $tryClone(i);
      //END JInit
    }

  /*public:*/
    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 466,
     FQN="clang::ento::IndirectGotoNodeBuilder::iterator::operator++", NM="_ZN5clang4ento23IndirectGotoNodeBuilder8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilder8iteratorppEv")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      I.$preInc();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 467,
     FQN="clang::ento::IndirectGotoNodeBuilder::iterator::operator!=", NM="_ZNK5clang4ento23IndirectGotoNodeBuilder8iteratorneERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento23IndirectGotoNodeBuilder8iteratorneERKS2_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ iterator /*&*/ X) /*const*/ {
      return $noteq_ptr(I, X.I);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::iterator::getLabel">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 469,
     FQN="clang::ento::IndirectGotoNodeBuilder::iterator::getLabel", NM="_ZNK5clang4ento23IndirectGotoNodeBuilder8iterator8getLabelEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento23IndirectGotoNodeBuilder8iterator8getLabelEv")
    //</editor-fold>
    public /*const*/ LabelDecl /*P*/ getLabel() /*const*/ {
      return cast_LabelStmt((I.$star()).$arrow().getLabel()).getDecl();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::iterator::getBlock">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 473,
     FQN="clang::ento::IndirectGotoNodeBuilder::iterator::getBlock", NM="_ZNK5clang4ento23IndirectGotoNodeBuilder8iterator8getBlockEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento23IndirectGotoNodeBuilder8iterator8getBlockEv")
    //</editor-fold>
    public /*const*/ CFGBlock /*P*/ getBlock() /*const*/ {
      return I.$star().$CFGBlock$P();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 459,
     FQN="clang::ento::IndirectGotoNodeBuilder::iterator::iterator", NM="_ZN5clang4ento23IndirectGotoNodeBuilder8iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilder8iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : I(static_cast<iterator &&>().I) 
      //START JInit
      this.I = $tryClone($Prm0.I);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "I=" + I; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 478,
   FQN="clang::ento::IndirectGotoNodeBuilder::begin", NM="_ZN5clang4ento23IndirectGotoNodeBuilder5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilder5beginEv")
  //</editor-fold>
  public iterator begin() {
    return new iterator(DispatchBlock.succ_begin$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 479,
   FQN="clang::ento::IndirectGotoNodeBuilder::end", NM="_ZN5clang4ento23IndirectGotoNodeBuilder3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilder3endEv")
  //</editor-fold>
  public iterator end() {
    return new iterator(DispatchBlock.succ_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::generateNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 685,
   FQN="clang::ento::IndirectGotoNodeBuilder::generateNode", NM="_ZN5clang4ento23IndirectGotoNodeBuilder12generateNodeERKNS1_8iteratorEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento23IndirectGotoNodeBuilder12generateNodeERKNS1_8iteratorEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb")
  //</editor-fold>
  public ExplodedNode /*P*/ generateNode(final /*const*/ iterator /*&*/ I, 
              IntrusiveRefCntPtr</*const*/ ProgramState> St) {
    return generateNode(I, 
              St, 
              false);
  }
  public ExplodedNode /*P*/ generateNode(final /*const*/ iterator /*&*/ I, 
              IntrusiveRefCntPtr</*const*/ ProgramState> St, 
              boolean IsSink/*= false*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      bool$ptr IsNew = create_bool$ptr();
      ExplodedNode /*P*/ Succ = $c$.clean(Eng.G.getNode(new BlockEdge(Src, I.getBlock(), Pred.getLocationContext()), 
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::getTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 485,
   FQN="clang::ento::IndirectGotoNodeBuilder::getTarget", NM="_ZNK5clang4ento23IndirectGotoNodeBuilder9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento23IndirectGotoNodeBuilder9getTargetEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getTarget() /*const*/ {
    return E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 487,
   FQN="clang::ento::IndirectGotoNodeBuilder::getState", NM="_ZNK5clang4ento23IndirectGotoNodeBuilder8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento23IndirectGotoNodeBuilder8getStateEv")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> getState() /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.State);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::IndirectGotoNodeBuilder::getLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 489,
   FQN="clang::ento::IndirectGotoNodeBuilder::getLocationContext", NM="_ZNK5clang4ento23IndirectGotoNodeBuilder18getLocationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento23IndirectGotoNodeBuilder18getLocationContextEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getLocationContext() /*const*/ {
    return Pred.getLocationContext();
  }

  
  @Override public String toString() {
    return "" + "Eng=" + "[CoreEngine]" // NOI18N
              + ", Src=" + Src // NOI18N
              + ", DispatchBlock=" + DispatchBlock // NOI18N
              + ", E=" + "[Expr]" // NOI18N
              + ", Pred=" + Pred; // NOI18N
  }
}
