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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import static org.clang.analysis.java.AnalysisRTTI.*;


/// A basic block is part of an SCFG.  It can be treated as a function in
/// continuation passing style.  A block consists of a sequence of phi nodes,
/// which are "arguments" to the function, followed by a sequence of
/// instructions.  It ends with a Terminator, which is a Branch or Goto to
/// another basic block in the same SCFG.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1520,
 FQN="clang::threadSafety::til::BasicBlock", NM="_ZN5clang12threadSafety3til10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlockE")
//</editor-fold>
public class BasicBlock extends /*public*/ SExpr {
/*public:*/
  /*typedef SimpleArray<SExpr *> InstrArray*/
//  public final class InstrArray extends SimpleArray<SExpr /*P*/ >{ };
  /*typedef SimpleArray<BasicBlock *> BlockArray*/
//  public final class BlockArray extends SimpleArray<BasicBlock /*P*/ >{ };
  
  // TopologyNodes are used to overlay tree structures on top of the CFG,
  // such as dominator and postdominator trees.  Each block is assigned an
  // ID in the tree according to a depth-first search.  Tree traversals are
  // always up, towards the parents.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::TopologyNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1529,
   FQN="clang::threadSafety::til::BasicBlock::TopologyNode", NM="_ZN5clang12threadSafety3til10BasicBlock12TopologyNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock12TopologyNodeE")
  //</editor-fold>
  public static class/*struct*/ TopologyNode {
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::TopologyNode::TopologyNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1530,
     FQN="clang::threadSafety::til::BasicBlock::TopologyNode::TopologyNode", NM="_ZN5clang12threadSafety3til10BasicBlock12TopologyNodeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock12TopologyNodeC1Ev")
    //</editor-fold>
    public TopologyNode() {
      // : NodeID(0), SizeOfSubTree(0), Parent(null) 
      //START JInit
      this.NodeID = 0;
      this.SizeOfSubTree = 0;
      this.Parent = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::TopologyNode::isParentOf">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1532,
     FQN="clang::threadSafety::til::BasicBlock::TopologyNode::isParentOf", NM="_ZN5clang12threadSafety3til10BasicBlock12TopologyNode10isParentOfERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock12TopologyNode10isParentOfERKS3_")
    //</editor-fold>
    public boolean isParentOf(final /*const*/ TopologyNode /*&*/ OtherNode) {
      return OtherNode.NodeID > NodeID
         && OtherNode.NodeID < NodeID + SizeOfSubTree;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::TopologyNode::isParentOfOrEqual">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1537,
     FQN="clang::threadSafety::til::BasicBlock::TopologyNode::isParentOfOrEqual", NM="_ZN5clang12threadSafety3til10BasicBlock12TopologyNode17isParentOfOrEqualERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock12TopologyNode17isParentOfOrEqualERKS3_")
    //</editor-fold>
    public boolean isParentOfOrEqual(final /*const*/ TopologyNode /*&*/ OtherNode) {
      return OtherNode.NodeID >= NodeID
         && OtherNode.NodeID < NodeID + SizeOfSubTree;
    }

    
    public int NodeID;
    public int SizeOfSubTree; // Includes this node, so must be > 1.
    public BasicBlock /*P*/ Parent; // Pointer to parent.
    
    @Override public String toString() {
      return "" + "NodeID=" + NodeID // NOI18N
                + ", SizeOfSubTree=" + SizeOfSubTree // NOI18N
                + ", Parent=" + Parent; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1547,
   FQN="clang::threadSafety::til::BasicBlock::classof", NM="_ZN5clang12threadSafety3til10BasicBlock7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_BasicBlock;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::BasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1549,
   FQN="clang::threadSafety::til::BasicBlock::BasicBlock", NM="_ZN5clang12threadSafety3til10BasicBlockC1ENS1_12MemRegionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlockC1ENS1_12MemRegionRefE")
  //</editor-fold>
  public /*explicit*/ BasicBlock(MemRegionRef A) {
    // : SExpr(COP_BasicBlock), Arena(A), CFGPtr(null), BlockID(0), Visited(0), Predecessors(), Args(), Instrs(), TermInstr(null), DominatorNode(), PostDominatorNode() 
    //START JInit
    super(TIL_Opcode.COP_BasicBlock);
    this.Arena = new MemRegionRef(A);
    this.CFGPtr = null;
    this.BlockID = 0;
    this.Visited = false;
    this.Predecessors = new SimpleArray<BasicBlock /*P*/ >();
    this.Args = new SimpleArray<SExpr /*P*/ >();
    this.Instrs = new SimpleArray<SExpr /*P*/ >();
    this.TermInstr = null;
    this.DominatorNode = new TopologyNode();
    this.PostDominatorNode = new TopologyNode();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::BasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1552,
   FQN="clang::threadSafety::til::BasicBlock::BasicBlock", NM="_ZN5clang12threadSafety3til10BasicBlockC1ERS2_NS1_12MemRegionRefEONS1_11SimpleArrayIPNS1_5SExprEEES9_PNS1_10TerminatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlockC1ERS2_NS1_12MemRegionRefEONS1_11SimpleArrayIPNS1_5SExprEEES9_PNS1_10TerminatorE")
  //</editor-fold>
  public BasicBlock(final BasicBlock /*&*/ B, MemRegionRef A, final SimpleArray<SExpr /*P*/ > /*&&*/As, final SimpleArray<SExpr /*P*/ > /*&&*/Is, 
      Terminator /*P*/ T) {
    // : SExpr(COP_BasicBlock), Arena(A), CFGPtr(null), BlockID(0), Visited(0), Predecessors(), Args(std::move(As)), Instrs(std::move(Is)), TermInstr(T), DominatorNode(), PostDominatorNode() 
    //START JInit
    super(TIL_Opcode.COP_BasicBlock);
    this.Arena = new MemRegionRef(A);
    this.CFGPtr = null;
    this.BlockID = 0;
    this.Visited = false;
    this.Predecessors = new SimpleArray<BasicBlock /*P*/ >();
    this.Args = new SimpleArray<SExpr /*P*/ >(JD$Move.INSTANCE, std.move(As));
    this.Instrs = new SimpleArray<SExpr /*P*/ >(JD$Move.INSTANCE, std.move(Is));
    this.TermInstr = T;
    this.DominatorNode = new TopologyNode();
    this.PostDominatorNode = new TopologyNode();
    //END JInit
  }

  
  /// Returns the block ID.  Every block has a unique ID in the CFG.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::blockID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1558,
   FQN="clang::threadSafety::til::BasicBlock::blockID", NM="_ZNK5clang12threadSafety3til10BasicBlock7blockIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock7blockIDEv")
  //</editor-fold>
  public int blockID() /*const*/ {
    return BlockID;
  }

  
  /// Returns the number of predecessors.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::numPredecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1561,
   FQN="clang::threadSafety::til::BasicBlock::numPredecessors", NM="_ZNK5clang12threadSafety3til10BasicBlock15numPredecessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock15numPredecessorsEv")
  //</editor-fold>
  public /*size_t*/int numPredecessors() /*const*/ {
    return Predecessors.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::numSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1562,
   FQN="clang::threadSafety::til::BasicBlock::numSuccessors", NM="_ZNK5clang12threadSafety3til10BasicBlock13numSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock13numSuccessorsEv")
  //</editor-fold>
  public /*size_t*/int numSuccessors() /*const*/ {
    return successors$Const().size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::cfg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1564,
   FQN="clang::threadSafety::til::BasicBlock::cfg", NM="_ZNK5clang12threadSafety3til10BasicBlock3cfgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock3cfgEv")
  //</editor-fold>
  public /*const*/ SCFG /*P*/ cfg$Const() /*const*/ {
    return CFGPtr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::cfg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1565,
   FQN="clang::threadSafety::til::BasicBlock::cfg", NM="_ZN5clang12threadSafety3til10BasicBlock3cfgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock3cfgEv")
  //</editor-fold>
  public SCFG /*P*/ cfg() {
    return CFGPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::parent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1567,
   FQN="clang::threadSafety::til::BasicBlock::parent", NM="_ZNK5clang12threadSafety3til10BasicBlock6parentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock6parentEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ parent$Const() /*const*/ {
    return DominatorNode.Parent;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::parent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1568,
   FQN="clang::threadSafety::til::BasicBlock::parent", NM="_ZN5clang12threadSafety3til10BasicBlock6parentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock6parentEv")
  //</editor-fold>
  public BasicBlock /*P*/ parent() {
    return DominatorNode.Parent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1570,
   FQN="clang::threadSafety::til::BasicBlock::arguments", NM="_ZNK5clang12threadSafety3til10BasicBlock9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock9argumentsEv")
  //</editor-fold>
  public /*const*/ SimpleArray<SExpr /*P*/ > /*&*/ arguments$Const() /*const*/ {
    return Args;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1571,
   FQN="clang::threadSafety::til::BasicBlock::arguments", NM="_ZN5clang12threadSafety3til10BasicBlock9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock9argumentsEv")
  //</editor-fold>
  public SimpleArray<SExpr /*P*/ > /*&*/ arguments() {
    return Args;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::instructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1573,
   FQN="clang::threadSafety::til::BasicBlock::instructions", NM="_ZN5clang12threadSafety3til10BasicBlock12instructionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock12instructionsEv")
  //</editor-fold>
  public SimpleArray<SExpr /*P*/ > /*&*/ instructions() {
    return Instrs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::instructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1574,
   FQN="clang::threadSafety::til::BasicBlock::instructions", NM="_ZNK5clang12threadSafety3til10BasicBlock12instructionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock12instructionsEv")
  //</editor-fold>
  public /*const*/ SimpleArray<SExpr /*P*/ > /*&*/ instructions$Const() /*const*/ {
    return Instrs;
  }

  
  /// Returns a list of predecessors.
  /// The order of predecessors in the list is important; each phi node has
  /// exactly one argument for each precessor, in the same order.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::predecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1579,
   FQN="clang::threadSafety::til::BasicBlock::predecessors", NM="_ZN5clang12threadSafety3til10BasicBlock12predecessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock12predecessorsEv")
  //</editor-fold>
  public SimpleArray<BasicBlock /*P*/ > /*&*/ predecessors() {
    return Predecessors;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::predecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1580,
   FQN="clang::threadSafety::til::BasicBlock::predecessors", NM="_ZNK5clang12threadSafety3til10BasicBlock12predecessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock12predecessorsEv")
  //</editor-fold>
  public /*const*/ SimpleArray<BasicBlock /*P*/ > /*&*/ predecessors$Const() /*const*/ {
    return Predecessors;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::successors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1582,
   FQN="clang::threadSafety::til::BasicBlock::successors", NM="_ZN5clang12threadSafety3til10BasicBlock10successorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock10successorsEv")
  //</editor-fold>
  public ArrayRef<BasicBlock /*P*/ > successors() {
    return TermInstr.successors();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::successors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1583,
   FQN="clang::threadSafety::til::BasicBlock::successors", NM="_ZNK5clang12threadSafety3til10BasicBlock10successorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock10successorsEv")
  //</editor-fold>
  public ArrayRef<BasicBlock /*P*/ > successors$Const() /*const*/ {
    return TermInstr.successors();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::terminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1585,
   FQN="clang::threadSafety::til::BasicBlock::terminator", NM="_ZNK5clang12threadSafety3til10BasicBlock10terminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock10terminatorEv")
  //</editor-fold>
  public /*const*/ Terminator /*P*/ terminator$Const() /*const*/ {
    return TermInstr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::terminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1586,
   FQN="clang::threadSafety::til::BasicBlock::terminator", NM="_ZN5clang12threadSafety3til10BasicBlock10terminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock10terminatorEv")
  //</editor-fold>
  public Terminator /*P*/ terminator() {
    return TermInstr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::setTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1588,
   FQN="clang::threadSafety::til::BasicBlock::setTerminator", NM="_ZN5clang12threadSafety3til10BasicBlock13setTerminatorEPNS1_10TerminatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock13setTerminatorEPNS1_10TerminatorE")
  //</editor-fold>
  public void setTerminator(Terminator /*P*/ E) {
    TermInstr = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::Dominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1590,
   FQN="clang::threadSafety::til::BasicBlock::Dominates", NM="_ZN5clang12threadSafety3til10BasicBlock9DominatesERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock9DominatesERKS2_")
  //</editor-fold>
  public boolean Dominates(final /*const*/ BasicBlock /*&*/ Other) {
    return DominatorNode.isParentOfOrEqual(Other.DominatorNode);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::PostDominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1594,
   FQN="clang::threadSafety::til::BasicBlock::PostDominates", NM="_ZN5clang12threadSafety3til10BasicBlock13PostDominatesERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock13PostDominatesERKS2_")
  //</editor-fold>
  public boolean PostDominates(final /*const*/ BasicBlock /*&*/ Other) {
    return PostDominatorNode.isParentOfOrEqual(Other.PostDominatorNode);
  }

  
  /// Add a new argument.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::addArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1599,
   FQN="clang::threadSafety::til::BasicBlock::addArgument", NM="_ZN5clang12threadSafety3til10BasicBlock11addArgumentEPNS1_3PhiE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock11addArgumentEPNS1_3PhiE")
  //</editor-fold>
  public void addArgument(Phi /*P*/ V) {
    Args.reserveCheck(1, new MemRegionRef(Arena));
    Args.push_back(V);
  }

  /// Add a new instruction.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::addInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1604,
   FQN="clang::threadSafety::til::BasicBlock::addInstruction", NM="_ZN5clang12threadSafety3til10BasicBlock14addInstructionEPNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock14addInstructionEPNS1_5SExprE")
  //</editor-fold>
  public void addInstruction(SExpr /*P*/ V) {
    Instrs.reserveCheck(1, new MemRegionRef(Arena));
    Instrs.push_back(V);
  }

  // Add a new predecessor, and return the phi-node index for it.
  // Will add an argument to all phi-nodes, initialized to nullptr.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::addPredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 56,
   FQN="clang::threadSafety::til::BasicBlock::addPredecessor", NM="_ZN5clang12threadSafety3til10BasicBlock14addPredecessorEPS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock14addPredecessorEPS2_")
  //</editor-fold>
  public /*uint*/int addPredecessor(BasicBlock /*P*/ Pred) {
    /*uint*/int Idx = Predecessors.size();
    Predecessors.reserveCheck(1, new MemRegionRef(Arena));
    Predecessors.push_back(Pred);
    for (SExpr /*P*/ E : Args) {
      {
        Phi /*P*/ Ph = dyn_cast_Phi(E);
        if ((Ph != null)) {
          Ph.values().reserveCheck(1, new MemRegionRef(Arena));
          Ph.values().push_back((SExpr /*P*/ /*const*/)null);
        }
      }
    }
    return Idx;
  }

  
  // Reserve space for Nargs arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::reserveArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1613,
   FQN="clang::threadSafety::til::BasicBlock::reserveArguments", NM="_ZN5clang12threadSafety3til10BasicBlock16reserveArgumentsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock16reserveArgumentsEj")
  //</editor-fold>
  public void reserveArguments(/*uint*/int Nargs) {
    Args.reserve(Nargs, new MemRegionRef(Arena));
  }

  
  // Reserve space for Nins instructions.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::reserveInstructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1616,
   FQN="clang::threadSafety::til::BasicBlock::reserveInstructions", NM="_ZN5clang12threadSafety3til10BasicBlock19reserveInstructionsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock19reserveInstructionsEj")
  //</editor-fold>
  public void reserveInstructions(/*uint*/int Nins) {
    Instrs.reserve(Nins, new MemRegionRef(Arena));
  }

  
  // Reserve space for NumPreds predecessors, including space in phi nodes.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::reservePredecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 70,
   FQN="clang::threadSafety::til::BasicBlock::reservePredecessors", NM="_ZN5clang12threadSafety3til10BasicBlock19reservePredecessorsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock19reservePredecessorsEj")
  //</editor-fold>
  public void reservePredecessors(/*uint*/int NumPreds) {
    Predecessors.reserve(NumPreds, new MemRegionRef(Arena));
    for (SExpr /*P*/ E : Args) {
      {
        Phi /*P*/ Ph = dyn_cast_Phi(E);
        if ((Ph != null)) {
          Ph.values().reserve(NumPreds, new MemRegionRef(Arena));
        }
      }
    }
  }

  
  /// Return the index of BB, or Predecessors.size if BB is not a predecessor.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::findPredecessorIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1622,
   FQN="clang::threadSafety::til::BasicBlock::findPredecessorIndex", NM="_ZNK5clang12threadSafety3til10BasicBlock20findPredecessorIndexEPKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til10BasicBlock20findPredecessorIndexEPKS2_")
  //</editor-fold>
  public /*uint*/int findPredecessorIndex(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    type$ptr<BasicBlock /*P*/ /*const*/ /*P*/> I = $tryClone(std.find(Predecessors.cbegin(), Predecessors.cend(), BB, true));
    return std.distance(Predecessors.cbegin(), I);
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1628,
   FQN="clang::threadSafety::til::BasicBlock::traverse", NM="Tpl__ZN5clang12threadSafety3til10BasicBlock8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til10BasicBlock8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_BasicBlock*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
     VisitReducer.Container<Boolean /*P*/ > Nas/*J*/= /*ParenList*/new  VisitReducer.Container<Boolean /*P*/ >(Vs, Args.size());
     VisitReducer.Container<Boolean /*P*/ > Nis/*J*/= /*ParenList*/new  VisitReducer.Container<Boolean /*P*/ >(Vs, Instrs.size());
    
    // Entering the basic block should do any scope initialization.
    Vs.enterBasicBlock(/*Deref*/this);
    
    for (SExpr /*P*/ E : Args) {
      /*<dependent type>*/boolean Ne = Vs.traverse(E, Vs.subExprCtx(Ctx));
      Nas.push_back(Ne);
    }
    for (SExpr /*P*/ E : Instrs) {
      /*<dependent type>*/boolean Ne = Vs.traverse(E, Vs.subExprCtx(Ctx));
      Nis.push_back(Ne);
    }
    /*<dependent type>*/boolean Nt = Vs.traverse(TermInstr, Ctx);
    
    // Exiting the basic block should handle any scope cleanup.
    Vs.exitBasicBlock(/*Deref*/this);
    
    return Vs.reduceBasicBlock(/*Deref*/this, Nas, Nis, Nt);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1652,
   FQN="clang::threadSafety::til::BasicBlock::compare", NM="Tpl__ZNK5clang12threadSafety3til10BasicBlock7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til10BasicBlock7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ BasicBlock /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    // TODO: implement CFG comparisons
    return Cmp.comparePointers(this, E);
  }

/*private:*/
  /*friend  class SCFG*/
  
  
  // Renumbers the arguments and instructions to have unique, sequential IDs.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::renumberInstrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 155,
   FQN="clang::threadSafety::til::BasicBlock::renumberInstrs", NM="_ZN5clang12threadSafety3til10BasicBlock14renumberInstrsEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock14renumberInstrsEi")
  //</editor-fold>
  /*friend*/protected/*private*/ int renumberInstrs(int ID) {
    for (SExpr /*P*/ Arg : Args)  {
      Arg.setID(this, ID++);
    }
    for (SExpr /*P*/ Instr : Instrs)  {
      Instr.setID(this, ID++);
    }
    TermInstr.setID(this, ID++);
    return ID;
  }
 // assign unique ids to all instructions
  
  // Sorts the CFGs blocks using a reverse post-order depth-first traversal.
  // Each block will be written into the Blocks array in order, and its BlockID
  // will be set to the index in the array.  Sorting should start from the entry
  // block, and ID should be the total number of blocks.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::topologicalSort">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 168,
   FQN="clang::threadSafety::til::BasicBlock::topologicalSort", NM="_ZN5clang12threadSafety3til10BasicBlock15topologicalSortERNS1_11SimpleArrayIPS2_EEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock15topologicalSortERNS1_11SimpleArrayIPS2_EEi")
  //</editor-fold>
  /*friend*/protected/*private*/ int topologicalSort(final SimpleArray<BasicBlock /*P*/ > /*&*/ Blocks, int ID) {
    if (Visited) {
      return ID;
    }
    Visited = true;
    for (BasicBlock /*P*/ Block : successors())  {
      ID = Block.topologicalSort(Blocks, ID);
    }
    // set ID and update block array in place.
    // We may lose pointers to unreachable blocks.
    assert (ID > 0);
    BlockID = --ID;
    Blocks.$set(BlockID, this);
    return ID;
  }

  
  // Performs a reverse topological traversal, starting from the exit block and
  // following back-edges.  The dominator is serialized before any predecessors,
  // which guarantees that all blocks are serialized after their dominator and
  // before their post-dominator (because it's a reverse topological traversal).
  // ID should be initially set to 0.
  //
  // This sort assumes that (1) dominators have been computed, (2) there are no
  // critical edges, and (3) the entry block is reachable from the exit block
  // and no blocks are accessable via traversal of back-edges from the exit that
  // weren't accessable via forward edges from the entry.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::topologicalFinalSort">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 191,
   FQN="clang::threadSafety::til::BasicBlock::topologicalFinalSort", NM="_ZN5clang12threadSafety3til10BasicBlock20topologicalFinalSortERNS1_11SimpleArrayIPS2_EEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock20topologicalFinalSortERNS1_11SimpleArrayIPS2_EEi")
  //</editor-fold>
  /*friend*/protected/*private*/ int topologicalFinalSort(final SimpleArray<BasicBlock /*P*/ > /*&*/ Blocks, int ID) {
    // Visited is assumed to have been set by the topologicalSort.  This pass
    // assumes !Visited means that we've visited this node before.
    if (!Visited) {
      return ID;
    }
    Visited = false;
    if ((DominatorNode.Parent != null)) {
      ID = DominatorNode.Parent.topologicalFinalSort(Blocks, ID);
    }
    for (BasicBlock /*P*/ Pred : Predecessors)  {
      ID = Pred.topologicalFinalSort(Blocks, ID);
    }
    assert ($less_uint(((/*static_cast*//*size_t*/int)(ID)), Blocks.size()));
    BlockID = ID++;
    Blocks.$set(BlockID, this);
    return ID;
  }

  
  // Computes the immediate dominator of the current block.  Assumes that all of
  // its predecessors have already computed their dominators.  This is achieved
  // by visiting the nodes in topological order.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::computeDominator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 209,
   FQN="clang::threadSafety::til::BasicBlock::computeDominator", NM="_ZN5clang12threadSafety3til10BasicBlock16computeDominatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock16computeDominatorEv")
  //</editor-fold>
  /*friend*/protected/*private*/ void computeDominator() {
    BasicBlock /*P*/ Candidate = null;
    // Walk backwards from each predecessor to find the common dominator node.
    for (BasicBlock /*P*/ Pred : Predecessors) {
      // Skip back-edges
      if (Pred.BlockID >= BlockID) {
        continue;
      }
      // If we don't yet have a candidate for dominator yet, take this one.
      if (Candidate == null) {
        Candidate = Pred;
        continue;
      }
      // Walk the alternate and current candidate back to find a common ancestor.
      BasicBlock /*P*/ Alternate = Pred;
      while (Alternate != Candidate) {
        if (Candidate.BlockID > Alternate.BlockID) {
          Candidate = Candidate.DominatorNode.Parent;
        } else {
          Alternate = Alternate.DominatorNode.Parent;
        }
      }
    }
    DominatorNode.Parent = Candidate;
    DominatorNode.SizeOfSubTree = 1;
  }

  
  // Computes the immediate post-dominator of the current block.  Assumes that all
  // of its successors have already computed their post-dominators.  This is
  // achieved visiting the nodes in reverse topological order.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BasicBlock::computePostDominator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 236,
   FQN="clang::threadSafety::til::BasicBlock::computePostDominator", NM="_ZN5clang12threadSafety3til10BasicBlock20computePostDominatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til10BasicBlock20computePostDominatorEv")
  //</editor-fold>
  /*friend*/protected/*private*/ void computePostDominator() {
    BasicBlock /*P*/ Candidate = null;
    // Walk back from each predecessor to find the common post-dominator node.
    for (BasicBlock /*P*/ Succ : successors()) {
      // Skip back-edges
      if (Succ.BlockID <= BlockID) {
        continue;
      }
      // If we don't yet have a candidate for post-dominator yet, take this one.
      if (Candidate == null) {
        Candidate = Succ;
        continue;
      }
      // Walk the alternate and current candidate back to find a common ancestor.
      BasicBlock /*P*/ Alternate = Succ;
      while (Alternate != Candidate) {
        if (Candidate.BlockID < Alternate.BlockID) {
          Candidate = Candidate.PostDominatorNode.Parent;
        } else {
          Alternate = Alternate.PostDominatorNode.Parent;
        }
      }
    }
    PostDominatorNode.Parent = Candidate;
    PostDominatorNode.SizeOfSubTree = 1;
  }

/*private:*/
  private MemRegionRef Arena; // The arena used to allocate this block.
  /*friend*/protected/*private*/ SCFG /*P*/ CFGPtr; // The CFG that contains this block.
  /*friend*/protected/*private*/ int BlockID /*: 31*/; // unique id for this BB in the containing CFG.
  // IDs are in topological order.
  private /*JBIT bool*/ boolean Visited /*: 1*/; // Bit to determine if a block has been visited
  // during a traversal.
  private SimpleArray<BasicBlock /*P*/ > Predecessors; // Predecessor blocks in the CFG.
  private SimpleArray<SExpr /*P*/ > Args; // Phi nodes.  One argument per predecessor.
  private SimpleArray<SExpr /*P*/ > Instrs; // Instructions.
  private Terminator /*P*/ TermInstr; // Terminating instruction
  
  /*friend*/protected/*private*/ TopologyNode DominatorNode; // The dominator tree
  /*friend*/protected/*private*/ TopologyNode PostDominatorNode; // The post-dominator tree
  
  @Override public String toString() {
    return "" + "Arena=" + Arena // NOI18N
              + ", CFGPtr=" + CFGPtr // NOI18N
              + ", BlockID=" + BlockID // NOI18N
              + ", Visited=" + Visited // NOI18N
              + ", Predecessors=" + Predecessors // NOI18N
              + ", Args=" + Args // NOI18N
              + ", Instrs=" + Instrs // NOI18N
              + ", TermInstr=" + TermInstr // NOI18N
              + ", DominatorNode=" + DominatorNode // NOI18N
              + ", PostDominatorNode=" + PostDominatorNode // NOI18N
              + super.toString(); // NOI18N
  }
}
