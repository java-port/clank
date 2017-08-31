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

package org.clang.analysis.analyses.threadSafety;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.java.BaseVisitor;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


// Walks the clang CFG, and invokes methods on a given CFGVisitor.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGWalker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 128,
 FQN="clang::threadSafety::CFGWalker", NM="_ZN5clang12threadSafety9CFGWalkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety9CFGWalkerE")
//</editor-fold>
public class CFGWalker {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGWalker::CFGWalker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 130,
   FQN="clang::threadSafety::CFGWalker::CFGWalker", NM="_ZN5clang12threadSafety9CFGWalkerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety9CFGWalkerC1Ev")
  //</editor-fold>
  public CFGWalker() {
    // : CFGraph(null), ACtx(null), SortedGraph(null) 
    //START JInit
    this.CFGraph = null;
    this.ACtx = null;
    this.SortedGraph = null;
    //END JInit
  }

  
  // Initialize the CFGWalker.  This setup only needs to be done once, even
  // if there are multiple passes over the CFG.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGWalker::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 134,
   FQN="clang::threadSafety::CFGWalker::init", NM="_ZN5clang12threadSafety9CFGWalker4initERNS_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety9CFGWalker4initERNS_19AnalysisDeclContextE")
  //</editor-fold>
  public boolean init(final AnalysisDeclContext /*&*/ AC) {
    ACtx = $AddrOf(AC);
    CFGraph = AC.getCFG();
    if (!(CFGraph != null)) {
      return false;
    }
    
    // Ignore anonymous functions.
    if (!(dyn_cast_or_null_NamedDecl(AC.getDecl()) != null)) {
      return false;
    }
    
    SortedGraph = AC.<PostOrderCFGView>getAnalysis(PostOrderCFGView.class);
    if (!(SortedGraph != null)) {
      return false;
    }
    
    return true;
  }

  
  // Traverse the CFG, calling methods on V as appropriate.
  /*template <class Visitor> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGWalker::walk">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 153,
   FQN="clang::threadSafety::CFGWalker::walk", NM="Tpl__ZN5clang12threadSafety9CFGWalker4walkERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=Tpl__ZN5clang12threadSafety9CFGWalker4walkERT_")
  //</editor-fold>
  public </*class*/ Visitor extends BaseVisitor> void walk(final Visitor /*&*/ V) {
    PostOrderCFGView.CFGBlockSet VisitedBlocks = null;
    try {
      VisitedBlocks/*J*/= new PostOrderCFGView.CFGBlockSet(CFGraph);
      
      V.enterCFG(CFGraph, getDecl(), $AddrOf(CFGraph.getEntry()));
      
      for (/*const*/ CFGBlock /*P*/ CurrBlock : $Deref(SortedGraph)) {
        VisitedBlocks.insert(CurrBlock);
        
        V.enterCFGBlock(CurrBlock);
        
        // Process predecessors, handling back edges last
        if (V.visitPredecessors()) {
          SmallVector<CFGBlock /*P*/ > BackEdges/*J*/= new SmallVector<CFGBlock /*P*/ >(4, (CFGBlock /*P*/ )null);
          // Process successors
          for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > SI = $tryClone(CurrBlock.pred_begin$Const()), 
              /*P*/ SE = $tryClone(CurrBlock.pred_end$Const());
               $noteq_ptr(SI, SE); SI.$preInc()) {
            if (SI.$star().$CFGBlock$P() == null) {
              continue;
            }
            if (!VisitedBlocks.alreadySet(SI.$star().$CFGBlock$P())) {
              BackEdges.push_back(SI.$star().$CFGBlock$P());
              continue;
            }
            V.handlePredecessor(SI.$star().$star());
          }
          
          for (CFGBlock /*P*/ Blk : BackEdges)  {
            V.handlePredecessorBackEdge(Blk);
          }
        }
        
        V.enterCFGBlockBody(CurrBlock);
        
        // Process statements
        for (final /*const*/ CFGElement /*&*/ BI : $Deref(CurrBlock)) {
          switch (BI.getKind()) {
           case Statement:
            {
              V.handleStatement(BI.castAs(CFGStmt.class).getStmt());
              break;
            }
           case AutomaticObjectDtor:
            {
              CFGAutomaticObjDtor AD = BI.castAs(CFGAutomaticObjDtor.class);
              CXXDestructorDecl /*P*/ DD = ((/*const_cast*/CXXDestructorDecl /*P*/ )(AD.getDestructorDecl(ACtx.getASTContext())));
              VarDecl /*P*/ VD = ((/*const_cast*/VarDecl /*P*/ )(AD.getVarDecl()));
              V.handleDestructorCall(VD, DD);
              break;
            }
           default:
            break;
          }
        }
        
        V.exitCFGBlockBody(CurrBlock);
        
        // Process successors, handling back edges first.
        if (V.visitSuccessors()) {
          SmallVector<CFGBlock /*P*/ > ForwardEdges/*J*/= new SmallVector<CFGBlock /*P*/ >(8, (CFGBlock /*P*/ )null);
          
          // Process successors
          for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > SI = $tryClone(CurrBlock.succ_begin$Const()), 
              /*P*/ SE = $tryClone(CurrBlock.succ_end$Const());
               $noteq_ptr(SI, SE); SI.$preInc()) {
            if (SI.$star().$CFGBlock$P() == null) {
              continue;
            }
            if (!VisitedBlocks.alreadySet(SI.$star().$CFGBlock$P())) {
              ForwardEdges.push_back(SI.$star().$CFGBlock$P());
              continue;
            }
            V.handleSuccessorBackEdge(SI.$star().$star());
          }
          
          for (CFGBlock /*P*/ Blk : ForwardEdges)  {
            V.handleSuccessor(Blk);
          }
        }
        
        V.exitCFGBlock(CurrBlock);
      }
      V.exitCFG($AddrOf(CFGraph.getExit()));
    } finally {
      if (VisitedBlocks != null) { VisitedBlocks.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGWalker::getGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 235,
   FQN="clang::threadSafety::CFGWalker::getGraph", NM="_ZNK5clang12threadSafety9CFGWalker8getGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZNK5clang12threadSafety9CFGWalker8getGraphEv")
  //</editor-fold>
  public /*const*/ CFG /*P*/ getGraph$Const() /*const*/ {
    return CFGraph;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGWalker::getGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 236,
   FQN="clang::threadSafety::CFGWalker::getGraph", NM="_ZN5clang12threadSafety9CFGWalker8getGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety9CFGWalker8getGraphEv")
  //</editor-fold>
  public CFG /*P*/ getGraph() {
    return CFGraph;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGWalker::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 238,
   FQN="clang::threadSafety::CFGWalker::getDecl", NM="_ZNK5clang12threadSafety9CFGWalker7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZNK5clang12threadSafety9CFGWalker7getDeclEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getDecl() /*const*/ {
    return dyn_cast_NamedDecl(ACtx.getDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGWalker::getSortedGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 242,
   FQN="clang::threadSafety::CFGWalker::getSortedGraph", NM="_ZNK5clang12threadSafety9CFGWalker14getSortedGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZNK5clang12threadSafety9CFGWalker14getSortedGraphEv")
  //</editor-fold>
  public /*const*/ PostOrderCFGView /*P*/ getSortedGraph() /*const*/ {
    return SortedGraph;
  }

/*private:*/
  private CFG /*P*/ CFGraph;
  private AnalysisDeclContext /*P*/ ACtx;
  private PostOrderCFGView /*P*/ SortedGraph;
  
  @Override public String toString() {
    return "" + "CFGraph=" + CFGraph // NOI18N
              + ", ACtx=" + "[AnalysisDeclContext]" // NOI18N
              + ", SortedGraph=" + SortedGraph; // NOI18N
  }
}
