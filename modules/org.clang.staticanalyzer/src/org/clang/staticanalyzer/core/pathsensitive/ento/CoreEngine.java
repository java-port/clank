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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//===----------------------------------------------------------------------===//
/// CoreEngine - Implements the core logic of the graph-reachability
///   analysis. It traverses the CFG and generates the ExplodedGraph.
///   Program "states" are treated as opaque void pointers.
///   The template class CoreEngine (which subclasses CoreEngine)
///   provides the matching component to the engine that knows the actual types
///   for states.  Note that this engine only dispatches to transfer functions
///   at the statement and block-level.  The analyses themselves must implement
///   any transfer function logic and the sub-expression level (if any).
//<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 43,
 FQN="clang::ento::CoreEngine", NM="_ZN5clang4ento10CoreEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngineE")
//</editor-fold>
public class CoreEngine implements Destructors.ClassWithDestructor {
  /*friend  struct NodeBuilderContext*/
  /*friend  class NodeBuilder*/
  /*friend  class ExprEngine*/
  /*friend  class CommonNodeBuilder*/
  /*friend  class IndirectGotoNodeBuilder*/
  /*friend  class SwitchNodeBuilder*/
  /*friend  class EndOfFunctionNodeBuilder*/
/*public:*/
  // JAVA: typedef std::vector<std::pair<BlockEdge, const ExplodedNode *> > BlocksExhausted
//  public final class BlocksExhausted extends std.vector<std.pairTypePtr<BlockEdge, /*const*/ ExplodedNode /*P*/ >>{ };
  
  // JAVA: typedef std::vector<std::pair<const CFGBlock *, const ExplodedNode *> > BlocksAborted
//  public final class BlocksAborted extends std.vector<std.pairPtrPtr</*const*/ CFGBlock /*P*/ , /*const*/ ExplodedNode /*P*/ >>{ };
/*private:*/
  
  private final SubEngine /*&*/ SubEng;
  
  /// G - The simulation graph.  Each node is a (location,state) pair.
  /*friend*/public/*private*/ /*mutable */ExplodedGraph G;
  
  /// WList - A set of queued nodes that need to be processed by the
  ///  worklist algorithm.  It is up to the implementation of WList to decide
  ///  the order that nodes are processed.
  /*friend*/public/*private*/ std.unique_ptr<WorkList> WList;
  
  /// BCounterFactory - A factory object for created BlockCounter objects.
  ///   These are used to record for key nodes in the ExplodedGraph the
  ///   number of times different CFGBlocks have been visited along a path.
  private BlockCounter.Factory BCounterFactory;
  
  /// The locations where we stopped doing work because we visited a location
  ///  too many times.
  /*friend*/public/*private*/ std.vector<std.pairTypePtr<BlockEdge, /*const*/ ExplodedNode /*P*/ >> blocksExhausted;
  
  /// The locations where we stopped because the engine aborted analysis,
  /// usually because it could not reason about something.
  private std.vector<std.pairPtrPtr</*const*/ CFGBlock /*P*/ , /*const*/ ExplodedNode /*P*/ >> blocksAborted;
  
  /// The information about functions shared by the whole translation unit.
  /// (This data is owned by AnalysisConsumer.)
  /*friend*/public/*private*/ FunctionSummariesTy /*P*/ FunctionSummaries;
  
  
  /// generateNode - Utility method to generate nodes, hook up successors,
  ///  and add nodes to the worklist.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::generateNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 526,
   FQN="clang::ento::CoreEngine::generateNode", NM="_ZN5clang4ento10CoreEngine12generateNodeERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine12generateNodeERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void generateNode(final /*const*/ ProgramPoint /*&*/ Loc, 
              IntrusiveRefCntPtr</*const*/ ProgramState> State, 
              ExplodedNode /*P*/ Pred) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      bool$ptr IsNew = create_bool$ptr();
      ExplodedNode /*P*/ Node = $c$.clean(G.getNode(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), false, $AddrOf(IsNew)));
      if ((Pred != null)) {
        Node.addPredecessor(Pred, G); // Link 'Node' with its predecessor.
      } else {
        assert (IsNew.$star());
        G.addRoot(Node); // 'Node' has no predecessor.  Make it a root.
      }
      
      // Only add 'Node' to the worklist if it was freshly generated.
      if (IsNew.$star()) {
        WList.$arrow().enqueue(Node);
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::HandleBlockEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 296,
   FQN="clang::ento::CoreEngine::HandleBlockEdge", NM="_ZN5clang4ento10CoreEngine15HandleBlockEdgeERKNS_9BlockEdgeEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine15HandleBlockEdgeERKNS_9BlockEdgeEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void HandleBlockEdge(final /*const*/ BlockEdge /*&*/ L, ExplodedNode /*P*/ Pred) {
    ExplodedNodeSet dstNodes = null;
    NodeBuilderWithSinks nodeBuilder = null;
    try {
      
      /*const*/ CFGBlock /*P*/ Blk = L.getDst();
      NodeBuilderContext BuilderCtx/*J*/= new NodeBuilderContext(/*Deref*/this, Blk, Pred);
      
      // Mark this block as visited.
      /*const*/ LocationContext /*P*/ LC = Pred.getLocationContext();
      FunctionSummaries.markVisitedBasicBlock(Blk.getBlockID(), 
          LC.getDecl(), 
          LC.getCFG().getNumBlockIDs());
      
      // Check if we are entering the EXIT block.
      if (Blk == $AddrOf((L.getLocationContext().getCFG().getExit()))) {
        assert (L.getLocationContext().getCFG().getExit().size() == 0) : "EXIT block cannot contain Stmts.";
        
        // Process the final state transition.
        SubEng.processEndOfFunction(BuilderCtx, Pred);
        
        // This path is done. Don't enqueue any more nodes.
        return;
      }
      
      // Call into the SubEngine to process entering the CFGBlock.
      dstNodes/*J*/= new ExplodedNodeSet();
      BlockEntrance BE/*J*/= new BlockEntrance(Blk, Pred.getLocationContext());
      nodeBuilder/*J*/= new NodeBuilderWithSinks(Pred, dstNodes, BuilderCtx, BE);
      SubEng.processCFGBlockEntrance(L, nodeBuilder, Pred);
      
      // Auto-generate a node.
      if (!nodeBuilder.hasGeneratedNodes()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(nodeBuilder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.State)), Pred));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Enqueue nodes onto the worklist.
      enqueue(dstNodes);
    } finally {
      if (nodeBuilder != null) { nodeBuilder.$destroy(); }
      if (dstNodes != null) { dstNodes.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::HandleBlockEntrance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 335,
   FQN="clang::ento::CoreEngine::HandleBlockEntrance", NM="_ZN5clang4ento10CoreEngine19HandleBlockEntranceERKNS_13BlockEntranceEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine19HandleBlockEntranceERKNS_13BlockEntranceEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void HandleBlockEntrance(final /*const*/ BlockEntrance /*&*/ L, 
                     ExplodedNode /*P*/ Pred) {
    
    // Increment the block counter.
    /*const*/ LocationContext /*P*/ LC = Pred.getLocationContext();
    /*uint*/int BlockId = L.getBlock().getBlockID();
    BlockCounter Counter = WList.$arrow().getBlockCounter();
    Counter.$assignMove(BCounterFactory.IncrementCount(new BlockCounter(Counter), LC.getCurrentStackFrame(), 
            BlockId));
    WList.$arrow().setBlockCounter(new BlockCounter(Counter));
    {
      
      // Process the entrance of the block.
      Optional<CFGElement> E = L.getFirstElement();
      if (E.$bool()) {
        NodeBuilderContext Ctx/*J*/= new NodeBuilderContext(/*Deref*/this, L.getBlock(), Pred);
        SubEng.processCFGElement(new CFGElement(E.$star()), Pred, 0, $AddrOf(Ctx));
      } else {
        HandleBlockExit(L.getBlock(), Pred);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::HandleBlockExit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 355,
   FQN="clang::ento::CoreEngine::HandleBlockExit", NM="_ZN5clang4ento10CoreEngine15HandleBlockExitEPKNS_8CFGBlockEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine15HandleBlockExitEPKNS_8CFGBlockEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void HandleBlockExit(/*const*/ CFGBlock /*P*/ B, ExplodedNode /*P*/ Pred) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        
        /*const*/ Stmt /*P*/ Term = B.getTerminator$Const().$Stmt$C$P();
        if ((Term != null)) {
          switch (Term.getStmtClass()) {
           default:
            throw new llvm_unreachable("Analysis for this terminator not implemented.");
           case CXXBindTemporaryExprClass:
            HandleCleanupTemporaryBranch(cast_CXXBindTemporaryExpr(B.getTerminator$Const().getStmt$Const()), B, Pred);
            return;
           case DeclStmtClass:
            
            // Model static initializers.
            HandleStaticInit(cast_DeclStmt(Term), B, Pred);
            return;
           case BinaryOperatorClass: // '&&' and '||'
            HandleBranch(cast_BinaryOperator(Term).getLHS(), Term, B, Pred);
            return;
           case BinaryConditionalOperatorClass:
           case ConditionalOperatorClass:
            HandleBranch(cast_AbstractConditionalOperator(Term).getCond(), 
                Term, B, Pred);
            return;
           case ChooseExprClass:
            
            // FIXME: Use constant-folding in CFG construction to simplify this
            // case.
            HandleBranch(cast_ChooseExpr(Term).getCond(), Term, B, Pred);
            return;
           case CXXTryStmtClass:
            {
              // Generate a node for each of the successors.
              // Our logic for EH analysis can certainly be improved.
              for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > it = $tryClone(B.succ_begin$Const()), 
                  /*P*/ et = $tryClone(B.succ_end$Const()); $noteq_ptr(it, et); it.$preInc()) {
                {
                  /*const*/ CFGBlock /*P*/ succ = it.$star().$CFGBlock$P();
                  if ((succ != null)) {
                    generateNode(new BlockEdge(B, succ, Pred.getLocationContext()), 
                        $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.State)), Pred); $c$.clean();
                  }
                }
              }
              return;
            }
           case DoStmtClass:
            HandleBranch(cast_DoStmt(Term).getCond$Const(), Term, B, Pred);
            return;
           case CXXForRangeStmtClass:
            HandleBranch(cast_CXXForRangeStmt(Term).getCond$Const(), Term, B, Pred);
            return;
           case ForStmtClass:
            HandleBranch(cast_ForStmt(Term).getCond$Const(), Term, B, Pred);
            return;
           case ContinueStmtClass:
           case BreakStmtClass:
           case GotoStmtClass:
            break;
           case IfStmtClass:
            HandleBranch(cast_IfStmt(Term).getCond$Const(), Term, B, Pred);
            return;
           case IndirectGotoStmtClass:
            {
              // Only 1 successor: the indirect goto dispatch block.
              assert (B.succ_size() == 1);
              
              IndirectGotoNodeBuilder builder/*J*/= new IndirectGotoNodeBuilder(Pred, B, cast_IndirectGotoStmt(Term).getTarget$Const(), 
                  (B.succ_begin$Const()).$star().$CFGBlock$P(), this);
              
              SubEng.processIndirectGoto(builder);
              return;
            }
           case ObjCForCollectionStmtClass:
            {
              // In the case of ObjCForCollectionStmt, it appears twice in a CFG:
              //
              //  (1) inside a basic block, which represents the binding of the
              //      'element' variable to a value.
              //  (2) in a terminator, which represents the branch.
              //
              // For (1), subengines will bind a value (i.e., 0 or 1) indicating
              // whether or not collection contains any more elements.  We cannot
              // just test to see if the element is nil because a container can
              // contain nil elements.
              HandleBranch(Term, Term, B, Pred);
              return;
            }
           case SwitchStmtClass:
            {
              SwitchNodeBuilder builder/*J*/= new SwitchNodeBuilder(Pred, B, cast_SwitchStmt(Term).getCond$Const(), 
                  this);
              
              SubEng.processSwitch(builder);
              return;
            }
           case WhileStmtClass:
            HandleBranch(cast_WhileStmt(Term).getCond$Const(), Term, B, Pred);
            return;
          }
        }
      }
      assert (B.succ_size() == 1) : "Blocks with no terminator should have at most 1 successor.";
      
      generateNode(new BlockEdge(B, (B.succ_begin$Const()).$star().$CFGBlock$P(), Pred.getLocationContext()), 
          $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.State)), Pred); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::HandleCallEnter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 471,
   FQN="clang::ento::CoreEngine::HandleCallEnter", NM="_ZN5clang4ento10CoreEngine15HandleCallEnterERKNS_9CallEnterEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine15HandleCallEnterERKNS_9CallEnterEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void HandleCallEnter(final /*const*/ CallEnter /*&*/ CE, ExplodedNode /*P*/ Pred) {
    NodeBuilderContext BuilderCtx/*J*/= new NodeBuilderContext(/*Deref*/this, CE.getEntry(), Pred);
    SubEng.processCallEnter(BuilderCtx, new CallEnter(CE), Pred);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::HandlePostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 511,
   FQN="clang::ento::CoreEngine::HandlePostStmt", NM="_ZN5clang4ento10CoreEngine14HandlePostStmtEPKNS_8CFGBlockEjPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine14HandlePostStmtEPKNS_8CFGBlockEjPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void HandlePostStmt(/*const*/ CFGBlock /*P*/ B, /*uint*/int StmtIdx, 
                ExplodedNode /*P*/ Pred) {
    assert Native.$bool(B);
    assert (!B.empty());
    if (StmtIdx == B.size()) {
      HandleBlockExit(B, Pred);
    } else {
      NodeBuilderContext Ctx/*J*/= new NodeBuilderContext(/*Deref*/this, B, Pred);
      SubEng.processCFGElement(($Deref(B)).$at(StmtIdx), Pred, StmtIdx, $AddrOf(Ctx));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::HandleBranch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 476,
   FQN="clang::ento::CoreEngine::HandleBranch", NM="_ZN5clang4ento10CoreEngine12HandleBranchEPKNS_4StmtES4_PKNS_8CFGBlockEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine12HandleBranchEPKNS_4StmtES4_PKNS_8CFGBlockEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void HandleBranch(/*const*/ Stmt /*P*/ Cond, /*const*/ Stmt /*P*/ Term, 
              /*const*/ CFGBlock /*P*/ B, ExplodedNode /*P*/ Pred) {
    ExplodedNodeSet Dst = null;
    try {
      assert (B.succ_size() == 2);
      NodeBuilderContext Ctx/*J*/= new NodeBuilderContext(/*Deref*/this, B, Pred);
      Dst/*J*/= new ExplodedNodeSet();
      SubEng.processBranch(Cond, Term, Ctx, Pred, Dst, 
          (B.succ_begin$Const()).$star().$CFGBlock$P(), (B.succ_begin$Const().$add(1)).$star().$CFGBlock$P());
      // Enqueue the new frontier onto the worklist.
      enqueue(Dst);
    } finally {
      if (Dst != null) { Dst.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::HandleCleanupTemporaryBranch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 487,
   FQN="clang::ento::CoreEngine::HandleCleanupTemporaryBranch", NM="_ZN5clang4ento10CoreEngine28HandleCleanupTemporaryBranchEPKNS_20CXXBindTemporaryExprEPKNS_8CFGBlockEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine28HandleCleanupTemporaryBranchEPKNS_20CXXBindTemporaryExprEPKNS_8CFGBlockEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void HandleCleanupTemporaryBranch(/*const*/ CXXBindTemporaryExpr /*P*/ BTE, 
                              /*const*/ CFGBlock /*P*/ B, 
                              ExplodedNode /*P*/ Pred) {
    ExplodedNodeSet Dst = null;
    try {
      assert (B.succ_size() == 2);
      NodeBuilderContext Ctx/*J*/= new NodeBuilderContext(/*Deref*/this, B, Pred);
      Dst/*J*/= new ExplodedNodeSet();
      SubEng.processCleanupTemporaryBranch(BTE, Ctx, Pred, Dst, (B.succ_begin$Const()).$star().$CFGBlock$P(), 
          (B.succ_begin$Const().$add(1)).$star().$CFGBlock$P());
      // Enqueue the new frontier onto the worklist.
      enqueue(Dst);
    } finally {
      if (Dst != null) { Dst.$destroy(); }
    }
  }

  
  /// Handle conditional logic for running static initializers.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::HandleStaticInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 499,
   FQN="clang::ento::CoreEngine::HandleStaticInit", NM="_ZN5clang4ento10CoreEngine16HandleStaticInitEPKNS_8DeclStmtEPKNS_8CFGBlockEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine16HandleStaticInitEPKNS_8DeclStmtEPKNS_8CFGBlockEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void HandleStaticInit(/*const*/ DeclStmt /*P*/ DS, /*const*/ CFGBlock /*P*/ B, 
                  ExplodedNode /*P*/ Pred) {
    ExplodedNodeSet Dst = null;
    try {
      assert (B.succ_size() == 2);
      NodeBuilderContext Ctx/*J*/= new NodeBuilderContext(/*Deref*/this, B, Pred);
      Dst/*J*/= new ExplodedNodeSet();
      SubEng.processStaticInitializer(DS, Ctx, Pred, Dst, 
          (B.succ_begin$Const()).$star().$CFGBlock$P(), (B.succ_begin$Const().$add(1)).$star().$CFGBlock$P());
      // Enqueue the new frontier onto the worklist.
      enqueue(Dst);
    } finally {
      if (Dst != null) { Dst.$destroy(); }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::CoreEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 109,
   FQN="clang::ento::CoreEngine::CoreEngine", NM="_ZN5clang4ento10CoreEngineC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngineC1ERKS1_")
  //</editor-fold>
  protected/*private*/ CoreEngine(final /*const*/ CoreEngine /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 110,
   FQN="clang::ento::CoreEngine::operator=", NM="_ZN5clang4ento10CoreEngineaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngineaSERKS1_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ CoreEngine /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::generateCallExitBeginNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 593,
   FQN="clang::ento::CoreEngine::generateCallExitBeginNode", NM="_ZN5clang4ento10CoreEngine25generateCallExitBeginNodeEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine25generateCallExitBeginNodeEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private ExplodedNode /*P*/ generateCallExitBeginNode(ExplodedNode /*P*/ N) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Create a CallExitBegin node and enqueue it.
      /*const*/ StackFrameContext /*P*/ LocCtx = cast_StackFrameContext(N.getLocationContext());
      
      // Use the callee location context.
      CallExitBegin Loc/*J*/= new CallExitBegin(LocCtx);
      
      bool$ptr isNew = create_bool$ptr();
      ExplodedNode /*P*/ Node = $c$.clean(G.getNode(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState())), false, $AddrOf(isNew)));
      Node.addPredecessor(N, G);
      return isNew.$star() ? Node : null;
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  /// Construct a CoreEngine object to analyze the provided CFG.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::CoreEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 116,
   FQN="clang::ento::CoreEngine::CoreEngine", NM="_ZN5clang4ento10CoreEngineC1ERNS0_9SubEngineEPNS0_19FunctionSummariesTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngineC1ERNS0_9SubEngineEPNS0_19FunctionSummariesTyE")
  //</editor-fold>
  public CoreEngine(final SubEngine /*&*/ subengine, FunctionSummariesTy /*P*/ FS) {
    // : SubEng(subengine), G(), WList(WorkList::makeDFS()), BCounterFactory(G.getAllocator()), blocksExhausted(), blocksAborted(), FunctionSummaries(FS) 
    //START JInit
    this./*&*/SubEng=/*&*/subengine;
    this.G = new ExplodedGraph();
    this.WList = new std.unique_ptr<WorkList>(WorkList.makeDFS());
    this.BCounterFactory = new BlockCounter.Factory(G.getAllocator());
    this.blocksExhausted = new std.vector<std.pairTypePtr<BlockEdge, /*const*/ ExplodedNode /*P*/ >>(new std.pairTypePtr<BlockEdge, /*const*/ ExplodedNode /*P*/ >(new BlockEdge(), null));
    this.blocksAborted = new std.vector<std.pairPtrPtr</*const*/ CFGBlock /*P*/ , /*const*/ ExplodedNode /*P*/ >>(new std.pairPtrPtr</*const*/ CFGBlock /*P*/ , /*const*/ ExplodedNode /*P*/ >());
    this.FunctionSummaries = FS;
    //END JInit
  }

  
  /// getGraph - Returns the exploded graph.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::getGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 121,
   FQN="clang::ento::CoreEngine::getGraph", NM="_ZN5clang4ento10CoreEngine8getGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine8getGraphEv")
  //</editor-fold>
  public ExplodedGraph /*&*/ getGraph() {
    return G;
  }

  
  /// ExecuteWorkList - Run the worklist algorithm for a maximum number of
  ///  steps.  Returns true if there is still simulation state on the worklist.
  
  //===----------------------------------------------------------------------===//
  // Core analysis engine.
  //===----------------------------------------------------------------------===//
  
  /// ExecuteWorkList - Run the worklist algorithm for a maximum number of steps.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::ExecuteWorkList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 165,
   FQN="clang::ento::CoreEngine::ExecuteWorkList", NM="_ZN5clang4ento10CoreEngine15ExecuteWorkListEPKNS_15LocationContextEjN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine15ExecuteWorkListEPKNS_15LocationContextEjN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public boolean ExecuteWorkList(/*const*/ LocationContext /*P*/ L, /*uint*/int Steps, 
                 IntrusiveRefCntPtr</*const*/ ProgramState> InitState) {
    if (G.num_roots() == 0) { // Initialize the analysis by constructing
      ExplodedNodeSet DstBegin = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // the root if none exists.
        /*const*/ CFGBlock /*P*/ Entry = $AddrOf((L.getCFG().getEntry()));
        assert (Entry.empty()) : "Entry block must be empty.";
        assert (Entry.succ_size() == 1) : "Entry block must have 1 successor.";
        
        // Mark the entry block as visited.
        FunctionSummaries.markVisitedBasicBlock(Entry.getBlockID(), 
            L.getDecl(), 
            L.getCFG().getNumBlockIDs());
        
        // Get the solitary successor.
        /*const*/ CFGBlock /*P*/ Succ = (Entry.succ_begin$Const()).$star().$CFGBlock$P();
        
        // Construct an edge representing the
        // starting location in the function.
        BlockEdge StartLoc/*J*/= new BlockEdge(Entry, Succ, L);
        
        // Set the current block counter to being empty.
        WList.$arrow().setBlockCounter(BCounterFactory.GetEmptyCounter());
        if (!InitState.$bool()) {
          $c$.clean(InitState.$assign($c$.track(SubEng.getInitialState(L))));
        }
        
        bool$ptr IsNew = create_bool$ptr();
        ExplodedNode /*P*/ Node = $c$.clean(G.getNode(StartLoc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(InitState)), false, $AddrOf(IsNew)));
        assert (IsNew.$star());
        G.addRoot(Node);
        
        NodeBuilderContext BuilderCtx/*J*/= new NodeBuilderContext(/*Deref*/this, StartLoc.getDst(), Node);
        DstBegin/*J*/= new ExplodedNodeSet();
        SubEng.processBeginOfFunction(BuilderCtx, Node, DstBegin, StartLoc);
        
        enqueue(DstBegin);
      } finally {
        if (DstBegin != null) { DstBegin.$destroy(); }
        $c$.$destroy();
      }
    }
    
    // Check if we have a steps limit
    boolean UnlimitedSteps = Steps == 0;
    // Cap our pre-reservation in the event that the user specifies
    // a very large number of maximum steps.
    /*const*//*uint*/int PreReservationCap = 4000000;
    if (!UnlimitedSteps) {
      G.reserve(std.min_uint(Steps, PreReservationCap));
    }
    while (WList.$arrow().hasWork()) {
      if (!UnlimitedSteps) {
        if (Steps == 0) {
          CoreEngineStatics.NumReachedMaxSteps.$postInc(0);
          break;
        }
        --Steps;
      }
      
      CoreEngineStatics.NumSteps.$postInc(0);
      
      final /*const*/ WorkListUnit /*&*/ WU = WList.$arrow().dequeue();
      
      // Set the current block counter.
      WList.$arrow().setBlockCounter(WU.getBlockCounter());
      
      // Retrieve the node.
      ExplodedNode /*P*/ Node = WU.getNode();
      
      dispatchWorkItem(Node, Node.getLocation(), WU);
    }
    SubEng.processEndWorklist(hasWorkRemaining());
    return WList.$arrow().hasWork();
  }

  /// Returns true if there is still simulation state on the worklist.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::ExecuteWorkListWithInitialState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 284,
   FQN="clang::ento::CoreEngine::ExecuteWorkListWithInitialState", NM="_ZN5clang4ento10CoreEngine31ExecuteWorkListWithInitialStateEPKNS_15LocationContextEjN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine31ExecuteWorkListWithInitialStateEPKNS_15LocationContextEjN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public boolean ExecuteWorkListWithInitialState(/*const*/ LocationContext /*P*/ L, 
                                 /*uint*/int Steps, 
                                 IntrusiveRefCntPtr</*const*/ ProgramState> InitState, 
                                 final ExplodedNodeSet /*&*/ Dst) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean DidNotFinish = $c$.clean(ExecuteWorkList(L, Steps, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(InitState))));
      for (std.vector.iterator<ExplodedNode /*P*/ > I = G.eop_begin(), E = G.eop_end(); $noteq___normal_iterator$C(I, E);
           I.$preInc()) {
        Dst.Add(I.$star());
      }
      return DidNotFinish;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Dispatch the work list item based on the given location information.
  /// Use Pred parameter as the predecessor state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::dispatchWorkItem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 242,
   FQN="clang::ento::CoreEngine::dispatchWorkItem", NM="_ZN5clang4ento10CoreEngine16dispatchWorkItemEPNS0_12ExplodedNodeENS_12ProgramPointERKNS0_12WorkListUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine16dispatchWorkItemEPNS0_12ExplodedNodeENS_12ProgramPointERKNS0_12WorkListUnitE")
  //</editor-fold>
  public void dispatchWorkItem(ExplodedNode /*P*/ Pred, ProgramPoint Loc, 
                  final /*const*/ WorkListUnit /*&*/ WU) {
    // Dispatch on the location type.
    switch (Loc.getKind()) {
     case BlockEdgeKind:
      HandleBlockEdge(Loc.castAs(BlockEdge.class), Pred);
      break;
     case BlockEntranceKind:
      HandleBlockEntrance(Loc.castAs(BlockEntrance.class), Pred);
      break;
     case BlockExitKind:
      assert (false) : "BlockExit location never occur in forward analysis.";
      break;
     case CallEnterKind:
      {
        HandleCallEnter(Loc.castAs(CallEnter.class), Pred);
        break;
      }
     case CallExitBeginKind:
      SubEng.processCallExit(Pred);
      break;
     case EpsilonKind:
      {
        assert (Pred.hasSinglePred()) : "Assume epsilon has exactly one predecessor by construction";
        ExplodedNode /*P*/ PNode = Pred.getFirstPred();
        dispatchWorkItem(Pred, PNode.getLocation(), WU);
        break;
      }
     default:
      assert (Loc.getAs(org.clang.analysis.PostStmt.class).$bool() || 
              Loc.getAs(PostInitializer.class).$bool() || 
              Loc.getAs(PostImplicitCall.class).$bool() || 
              Loc.getAs(CallExitEnd.class).$bool());
      HandlePostStmt(WU.getBlock(), WU.getIndex(), Pred);
      break;
    }
  }

  
  // Functions for external checking of whether we have unfinished work
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::wasBlockAborted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 139,
   FQN="clang::ento::CoreEngine::wasBlockAborted", NM="_ZNK5clang4ento10CoreEngine15wasBlockAbortedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento10CoreEngine15wasBlockAbortedEv")
  //</editor-fold>
  public boolean wasBlockAborted() /*const*/ {
    return !blocksAborted.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::wasBlocksExhausted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 140,
   FQN="clang::ento::CoreEngine::wasBlocksExhausted", NM="_ZNK5clang4ento10CoreEngine18wasBlocksExhaustedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento10CoreEngine18wasBlocksExhaustedEv")
  //</editor-fold>
  public boolean wasBlocksExhausted() /*const*/ {
    return !blocksExhausted.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::hasWorkRemaining">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 141,
   FQN="clang::ento::CoreEngine::hasWorkRemaining", NM="_ZNK5clang4ento10CoreEngine16hasWorkRemainingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento10CoreEngine16hasWorkRemainingEv")
  //</editor-fold>
  public boolean hasWorkRemaining() /*const*/ {
    return wasBlocksExhausted()
       || WList.$arrow().hasWork()
       || wasBlockAborted();
  }

  
  /// Inform the CoreEngine that a basic block was aborted because
  /// it could not be completely analyzed.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::addAbortedBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 147,
   FQN="clang::ento::CoreEngine::addAbortedBlock", NM="_ZN5clang4ento10CoreEngine15addAbortedBlockEPKNS0_12ExplodedNodeEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine15addAbortedBlockEPKNS0_12ExplodedNodeEPKNS_8CFGBlockE")
  //</editor-fold>
  public void addAbortedBlock(/*const*/ ExplodedNode /*P*/ node, /*const*/ CFGBlock /*P*/ block) {
    blocksAborted.push_back_T$RR(std.make_pair_Ptr_Ptr(block, node));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::getWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 151,
   FQN="clang::ento::CoreEngine::getWorkList", NM="_ZNK5clang4ento10CoreEngine11getWorkListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento10CoreEngine11getWorkListEv")
  //</editor-fold>
  public WorkList /*P*/ getWorkList() /*const*/ {
    return WList.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::blocks_exhausted_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 153,
   FQN="clang::ento::CoreEngine::blocks_exhausted_begin", NM="_ZNK5clang4ento10CoreEngine22blocks_exhausted_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento10CoreEngine22blocks_exhausted_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/std.pairTypePtr<BlockEdge, /*const*/ ExplodedNode /*P*/ > /*P*/> blocks_exhausted_begin() /*const*/ {
    return blocksExhausted.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::blocks_exhausted_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 156,
   FQN="clang::ento::CoreEngine::blocks_exhausted_end", NM="_ZNK5clang4ento10CoreEngine20blocks_exhausted_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento10CoreEngine20blocks_exhausted_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/std.pairTypePtr<BlockEdge, /*const*/ ExplodedNode /*P*/ > /*P*/> blocks_exhausted_end() /*const*/ {
    return blocksExhausted.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::blocks_aborted_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 159,
   FQN="clang::ento::CoreEngine::blocks_aborted_begin", NM="_ZNK5clang4ento10CoreEngine20blocks_aborted_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento10CoreEngine20blocks_aborted_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/std.pairPtrPtr</*const*/ CFGBlock /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/> blocks_aborted_begin() /*const*/ {
    return blocksAborted.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::blocks_aborted_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 162,
   FQN="clang::ento::CoreEngine::blocks_aborted_end", NM="_ZNK5clang4ento10CoreEngine18blocks_aborted_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento10CoreEngine18blocks_aborted_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/std.pairPtrPtr</*const*/ CFGBlock /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/> blocks_aborted_end() /*const*/ {
    return blocksAborted.end$Const();
  }

  
  /// \brief Enqueue the given set of nodes onto the work list.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 608,
   FQN="clang::ento::CoreEngine::enqueue", NM="_ZN5clang4ento10CoreEngine7enqueueERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine7enqueueERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void enqueue(final ExplodedNodeSet /*&*/ Set) {
    for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Set.begin(), 
        E = Set.end(); I.$noteq(E); I.$preInc()) {
      WList.$arrow().enqueue(I.$star());
    }
  }

  
  /// \brief Enqueue nodes that were created as a result of processing
  /// a statement onto the work list.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 615,
   FQN="clang::ento::CoreEngine::enqueue", NM="_ZN5clang4ento10CoreEngine7enqueueERNS0_15ExplodedNodeSetEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine7enqueueERNS0_15ExplodedNodeSetEPKNS_8CFGBlockEj")
  //</editor-fold>
  public void enqueue(final ExplodedNodeSet /*&*/ Set, 
         /*const*/ CFGBlock /*P*/ Block, /*uint*/int Idx) {
    for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Set.begin(), 
        E = Set.end(); I.$noteq(E); I.$preInc()) {
      enqueueStmtNode(I.$star(), Block, Idx);
    }
  }

  
  /// \brief enqueue the nodes corresponding to the end of function onto the
  /// end of path / work list.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::enqueueEndOfFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 623,
   FQN="clang::ento::CoreEngine::enqueueEndOfFunction", NM="_ZN5clang4ento10CoreEngine20enqueueEndOfFunctionERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine20enqueueEndOfFunctionERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void enqueueEndOfFunction(final ExplodedNodeSet /*&*/ Set) {
    for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Set.begin(), E = Set.end(); I.$noteq(E); I.$preInc()) {
      ExplodedNode /*P*/ N = I.$star();
      // If we are in an inlined call, generate CallExitBegin node.
      if ((N.getLocationContext().getParent() != null)) {
        N = generateCallExitBeginNode(N);
        if ((N != null)) {
          WList.$arrow().enqueue(N);
        }
      } else {
        // TODO: We should run remove dead bindings here.
        G.addEndOfPath(N);
        CoreEngineStatics.NumPathsExplored.$postInc(0);
      }
    }
  }

  
  /// \brief Enqueue a single node created as a result of statement processing.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::enqueueStmtNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 544,
   FQN="clang::ento::CoreEngine::enqueueStmtNode", NM="_ZN5clang4ento10CoreEngine15enqueueStmtNodeEPNS0_12ExplodedNodeEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento10CoreEngine15enqueueStmtNodeEPNS0_12ExplodedNodeEPKNS_8CFGBlockEj")
  //</editor-fold>
  public void enqueueStmtNode(ExplodedNode /*P*/ N, 
                 /*const*/ CFGBlock /*P*/ Block, /*uint*/int Idx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert Native.$bool(Block);
      assert (!N.isSink());
      
      // Check if this node entered a callee.
      if (N.getLocation().getAs(CallEnter.class).$bool()) {
        // Still use the index of the CallExpr. It's needed to create the callee
        // StackFrameContext.
        WList.$arrow().enqueue(N, Block, Idx);
        return;
      }
      
      // Do not create extra nodes. Move to the next CFG element.
      if (N.getLocation().getAs(PostInitializer.class).$bool()
         || N.getLocation().getAs(PostImplicitCall.class).$bool()) {
        WList.$arrow().enqueue(N, Block, Idx + 1);
        return;
      }
      if (N.getLocation().getAs(EpsilonPoint.class).$bool()) {
        WList.$arrow().enqueue(N, Block, Idx);
        return;
      }
      if (($Deref(Block)).$at(Idx).getKind() == CFGElement.Kind.NewAllocator) {
        WList.$arrow().enqueue(N, Block, Idx + 1);
        return;
      }
      
      // At this point, we know we're processing a normal statement.
      CFGStmt CS = ($Deref(Block)).$at(Idx).castAs(CFGStmt.class);
      org.clang.analysis.PostStmt Loc/*J*/= new org.clang.analysis.PostStmt(CS.getStmt(), N.getLocationContext());
      if (Loc.$eq(N.getLocation().withTag((/*const*/ ProgramPointTag /*P*/ )null))) {
        // Note: 'N' should be a fresh node because otherwise it shouldn't be
        // a member of Deferred.
        WList.$arrow().enqueue(N, Block, Idx + 1);
        return;
      }
      
      bool$ptr IsNew = create_bool$ptr();
      ExplodedNode /*P*/ Succ = $c$.clean(G.getNode(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState())), false, $AddrOf(IsNew)));
      Succ.addPredecessor(N, G);
      if (IsNew.$star()) {
        WList.$arrow().enqueue(Succ, Block, Idx + 1);
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CoreEngine::~CoreEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 43,
   FQN="clang::ento::CoreEngine::~CoreEngine", NM="_ZN5clang4ento10CoreEngineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10CoreEngineD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    blocksAborted.$destroy();
    blocksExhausted.$destroy();
    BCounterFactory.$destroy();
    WList.$destroy();
    G.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "SubEng=" + "[SubEngine]" // NOI18N
              + ", G=" + G // NOI18N
              + ", WList=" + WList // NOI18N
              + ", BCounterFactory=" + "[Factory]" // NOI18N
              + ", blocksExhausted=" + blocksExhausted // NOI18N
              + ", blocksAborted=" + blocksAborted // NOI18N
              + ", FunctionSummaries=" + FunctionSummaries; // NOI18N
  }
}
