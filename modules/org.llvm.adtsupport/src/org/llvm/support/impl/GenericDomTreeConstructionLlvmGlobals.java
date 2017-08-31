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
package org.llvm.support.impl;

import org.clank.java.std;
import org.clank.support.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.Unsigned.$greater_uint;
import static org.clank.support.Unsigned.$greatereq_uint;
import static org.clank.support.Unsigned.$less_uint;
import static org.clank.support.Unsigned.$lesseq_uint;
import org.clank.support.aliases.type$iterator;
import org.clank.support.aliases.type$ref;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.aliases.SmallVectorUInt;
import org.llvm.adt.java.GraphTraits;
import org.llvm.support.AdtsupportLlvmGlobals;
import org.llvm.support.DomTreeNodeBase;
import org.llvm.support.DominatorTreeBase;
import org.llvm.support.llvm;


//<editor-fold defaultstate="collapsed" desc="static type GenericDomTreeConstructionLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.support.impl.GenericDomTreeConstructionLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm4EvalERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j;Tpl__ZN4llvm7DFSPassERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j;Tpl__ZN4llvm9CalculateERNS_17DominatorTreeBaseINS_11GraphTraitsIT0_E8NodeTypeEEERT_; -static-type=GenericDomTreeConstructionLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class GenericDomTreeConstructionLlvmGlobals {


// The calculate routine is provided in a separate header but referenced here.
/*template <class FuncT, class N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::Calculate">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", line = 150,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", old_line = 149,
 FQN="llvm::Calculate", NM="Tpl__ZN4llvm9CalculateERNS_17DominatorTreeBaseINS_11GraphTraitsIT0_E8NodeTypeEEERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm9CalculateINS_8FunctionEPNS_10BasicBlockEEEvRNS_17DominatorTreeBaseINS_11GraphTraitsIT0_E8NodeTypeEEERT_")
//</editor-fold>
public static </*class*/ FuncT, /*class*/ NodeT> void Calculate(GraphTraits<FuncT, ?, ?> GTraits$FuncT, GraphTraits GraphTraits_NodeT, GraphTraits GraphTraits_InverseNodeT,
        final DominatorTreeBase< NodeT > /*&*/ DT, 
         final FuncT /*&*/ F) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // JAVA: typedef GraphTraits<BasicBlock *> GraphT
//    final class GraphT extends GraphTraitsBasicBlock$P{ };
    
    /*uint*/int N = 0;
    boolean MultipleRoots = ($greater_uint(DT.Roots.size(), 1));
    if (MultipleRoots) {
      final  DominatorTreeBase.InfoRec<NodeT> /*&*/ BBInfo = DT.Info.$at_T1$RR((NodeT /*P*/ )null);
      BBInfo.DFSNum = BBInfo.Semi = ++N;
      BBInfo.Label = null;
      
      DT.Vertex.push_back_T$RR((NodeT)null); // Vertex[n] = V;
    }
    
    // Step #1: Number blocks in depth-first order and initialize variables used
    // in later stages of the algorithm.
    for (/*uint*/int i = 0, e = ((/*static_cast*//*uint*/int)(DT.Roots.size()));
         i != e; ++i)  {
      N = AdtsupportLlvmGlobals.DFSPass(GraphTraits_NodeT, DT, DT.Roots.$at(i), N);
    }
    
    // it might be that some blocks did not get a DFS number (e.g., blocks of
    // infinite loops). In these cases an artificial exit node is required.
    MultipleRoots |= (DT.isPostDominator() && N != GTraits$FuncT.size($AddrOf(F)));
    
    // When naively implemented, the Lengauer-Tarjan algorithm requires a separate
    // bucket for each vertex. However, this is unnecessary, because each vertex
    // is only placed into a single bucket (that of its semidominator), and each
    // vertex's bucket is processed before it is added to any bucket itself.
    //
    // Instead of using a bucket per vertex, we use a single array Buckets that
    // has two purposes. Before the vertex V with preorder number i is processed,
    // Buckets[i] stores the index of the first element in V's bucket. After V's
    // bucket is processed, Buckets[i] stores the index of the next element in the
    // bucket containing V, if any.
    SmallVectorUInt Buckets/*J*/= new SmallVectorUInt(32, 0);
    Buckets.resize(N + 1);
    for (/*uint*/int i = 1; $lesseq_uint(i, N); ++i)  {
      Buckets.$set(i, i);
    }
    
    for (/*uint*/int i = N; $greatereq_uint(i, 2); --i) {
      NodeT /*P*/ W = DT.Vertex.$at(i);
      final  DominatorTreeBase.InfoRec<NodeT> /*&*/ WInfo = DT.Info.$at_T1$C$R(W);
      
      // Step #2: Implicitly define the immediate dominator of vertices
      for (/*uint*/int j = i; Buckets.$at(j) != i; j = Buckets.$at(j)) {
        NodeT /*P*/ V = DT.Vertex.$at(Buckets.$at(j));
        NodeT /*P*/ U = AdtsupportLlvmGlobals.Eval(GraphTraits_NodeT, DT, V, i + 1);
        DT.IDoms.$set(V, $less_uint(DT.Info.$at_T1$C$R(U).Semi, i) ? U : W);
      }
      
      // Step #3: Calculate the semidominators of all vertices
      
      // initialize the semi dominator to point to the parent node
      WInfo.Semi = WInfo.Parent;
      // JAVA: typedef GraphTraits<Inverse<BasicBlock *> > InvTraits
//      final class InvTraits extends GraphTraitsInverse$BasicBlock$P{ };
      for (type$iterator CI = GraphTraits_InverseNodeT.child_begin(W), 
          E = GraphTraits_InverseNodeT.child_end(W); CI.$noteq(E); CI.$preInc()) {
        NodeT /*P*/ N$1 = (NodeT)CI.$star();
        if ((DT.Info.count(N$1) != 0)) { // Only if this predecessor is reachable!
          /*uint*/int SemiU = DT.Info.$at_T1$RR(AdtsupportLlvmGlobals.Eval(GraphTraits_NodeT, DT, N$1, i + 1)).Semi;
          if ($less_uint(SemiU, WInfo.Semi)) {
            WInfo.Semi = SemiU;
          }
        }
      }
      
      // If V is a non-root vertex and sdom(V) = parent(V), then idom(V) is
      // necessarily parent(V). In this case, set idom(V) here and avoid placing
      // V into a bucket.
      if (WInfo.Semi == WInfo.Parent) {
        DT.IDoms.$set(W, DT.Vertex.$at(WInfo.Parent));
      } else {
        Buckets.$set(i, Buckets.$at(WInfo.Semi));
        Buckets.$set(WInfo.Semi, i);
      }
    }
    if ($greatereq_uint(N, 1)) {
      NodeT /*P*/ Root = DT.Vertex.$at(1);
      for (/*uint*/int j = 1; Buckets.$at(j) != 1; j = Buckets.$at(j)) {
        NodeT /*P*/ V = DT.Vertex.$at(Buckets.$at(j));
        DT.IDoms.$set(V, Root);
      }
    }
    
    // Step #4: Explicitly define the immediate dominator of each vertex
    for (/*uint*/int i = 2; $lesseq_uint(i, N); ++i) {
      NodeT /*P*/ W = DT.Vertex.$at(i);
      final type$ref<NodeT /*P*/ /*&*/> WIDom = DT.IDoms.ref$at(W);
      if (WIDom.$deref() != DT.Vertex.$at(DT.Info.$at_T1$C$R(W).Semi)) {
        WIDom.$set(DT.IDoms.$at_T1$C$R(WIDom.$deref()));
      }
    }
    if (DT.Roots.empty()) {
      return;
    }
    
    // Add a node for the root.  This node might be the actual root, if there is
    // one exit block, or it may be the virtual exit (denoted by (BasicBlock *)0)
    // which postdominates all real exits if there are multiple exit blocks, or
    // an infinite loop.
    NodeT /*P*/ Root = !MultipleRoots ? DT.Roots.$at(0) : null;
    
    $c$.clean(DT.RootNode
       = (DT.DomTreeNodes.$at_T1$C$R(Root).$assignMove(
        $c$.track(llvm.make_unique(new DomTreeNodeBase<NodeT>(Root, null)))
    )).get());
    
    // Loop over all of the reachable blocks in the function...
    for (/*uint*/int i = 2; $lesseq_uint(i, N); ++i) {
      NodeT /*P*/ W = DT.Vertex.$at(i);
      
      // Don't replace this with 'count', the insertion side effect is important
      if (DT.DomTreeNodes.$at_T1$C$R(W).$bool()) {
        continue; // Haven't calculated this node yet?
      }
      
      NodeT /*P*/ ImmDom = DT.getIDom(W);
      assert ((ImmDom != null) || DT.DomTreeNodes.$at_T1$RR((NodeT /*P*/ )null).$bool());
      
      // Get or calculate the node for the immediate dominator
      DomTreeNodeBase<NodeT> /*P*/ IDomNode = DT.getNodeForBlock(ImmDom);
      
      // Add a new tree node for this BasicBlock, and link it as a child of
      // IDomNode
      $c$.clean(DT.DomTreeNodes.$at_T1$C$R(W).$assignMove($c$.track(IDomNode.addChild($c$.track(llvm.make_unique(new DomTreeNodeBase<NodeT>(W, IDomNode)))))));
    }
    
    // Free temporary memory used to construct idom's
    DT.IDoms.clear();
    DT.Info.clear();
    DT.Vertex.clear();
    DT.Vertex.shrink_to_fit();
    
    DT.updateDFSNumbers();
  } finally {
    $c$.$destroy();
  }
}

/*template <class GraphT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::Eval">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 630,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", old_line = 105,
 FQN="llvm::Eval", NM="Tpl__ZN4llvm4EvalERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm4EvalERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeT>  NodeT /*P*/ Eval(GraphTraits GraphTraits_NodeT, final DominatorTreeBase< NodeT> /*&*/ DT, 
     NodeT /*P*/ V, /*uint*/int LastLinked) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class GraphT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DFSPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", line = 33,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", old_line = 32,
 FQN="llvm::DFSPass", NM="Tpl__ZN4llvm7DFSPassERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm7DFSPassERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeT> /*uint*/int DFSPass(GraphTraits<?, NodeT, ? extends NodeT> GraphTraits_NodeT, final DominatorTreeBase< NodeT> /*&*/ DT, 
        NodeT /*P*/ V, /*uint*/int N) {
  boolean IsChildOfArtificialExit = (N != 0);
  
  SmallVector<std.pairPtrType< NodeT /*P*/ ,  type$iterator<?, ? extends NodeT>> >/*<32>*/ Worklist = new SmallVector<>(32, new std.pairPtrType<>());
  Worklist.push_back(std.make_pair_Ptr_T(V, GraphTraits_NodeT.child_begin(V)));
  while (Native.$not(Worklist.empty())) {
     NodeT /*P*/ BB = Worklist.back().first;
     type$iterator<?, ? extends NodeT> NextSucc = Worklist.back().second;
    
    final  DominatorTreeBase.InfoRec< NodeT> /*&*/ BBInfo = DT.Info.$at(BB);
    
    // First time we visited this BB?
    if (Native.$eq_iter(NextSucc, GraphTraits_NodeT.child_begin(BB))) {
      BBInfo.DFSNum = BBInfo.Semi = ++N;
      BBInfo.Label = BB;
      
      DT.Vertex.push_back(BB); // Vertex[n] = V;
      if (IsChildOfArtificialExit) {
        BBInfo.Parent = 1;
      }
      
      IsChildOfArtificialExit = false;
    }
    
    // store the DFS number of the current BB - the reference to BBInfo might
    // get invalidated when processing the successors.
    /*uint*/int BBDFSNum = BBInfo.DFSNum;
    
    // If we are done with this block, remove it from the worklist.
    if (Native.$eq_iter(NextSucc, GraphTraits_NodeT.child_end(BB))) {
      Worklist.pop_back();
      continue;
    }
    
    // Increment the successor number for the next time we get to it.
    Worklist.back().second.$preInc();
    
    // Visit the successor next, if it isn't already visited.
     NodeT /*P*/ Succ = NextSucc.$star();
    
    final  DominatorTreeBase.InfoRec< NodeT> /*&*/ SuccVInfo = DT.Info.$at(Succ);
    if (Native.$eq(SuccVInfo.Semi, 0)) {
      SuccVInfo.Parent = BBDFSNum;
      Worklist.push_back(std.make_pair_Ptr_T(Succ, GraphTraits_NodeT.child_begin(Succ)));
    }
  }
  return N;
}

/*template <class FuncT, class N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::Calculate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 639,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", old_line = 149,
 FQN="llvm::Calculate", NM="Tpl__ZN4llvm9CalculateERNS_17DominatorTreeBaseINS_11GraphTraitsIT0_E8NodeTypeEEERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm9CalculateERNS_17DominatorTreeBaseINS_11GraphTraitsIT0_E8NodeTypeEEERT_")
//</editor-fold>
public static </*class*/ FuncT, /*class*/ NodeT> void Calculate_DominatorTreeBase$NodeType_T$R(final DominatorTreeBase< NodeT > /*&*/ DT, final FuncT /*&*/ F) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class GenericDomTreeConstructionLlvmGlobals
