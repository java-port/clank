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

package org.llvm.adt;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.java.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;

//===--------------------------------------------------------------------===//
// Reverse Post Order CFG iterator code
//===--------------------------------------------------------------------===//
//
// This is used to visit basic blocks in a method in reverse post order.  This
// class is awkward to use because I don't know a good incremental algorithm to
// computer RPO from a graph.  Because of this, the construction of the
// ReversePostOrderTraversal object is expensive (it must walk the entire graph
// with a postorder iterator to build the data structures).  The moral of this
// story is: Don't create more ReversePostOrderTraversal classes than necessary.
//
// This class should be used like this:
// {
//   ReversePostOrderTraversal<Function*> RPOT(FuncPtr); // Expensive to create
//   for (rpo_iterator I = RPOT.begin(); I != RPOT.end(); ++I) {
//      ...
//   }
//   for (rpo_iterator I = RPOT.begin(); I != RPOT.end(); ++I) {
//      ...
//   }
// }
//
/*template <class GraphT, class GT = GraphTraits<GraphT>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ReversePostOrderTraversal">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 281,
 FQN="llvm::ReversePostOrderTraversal", NM="_ZN4llvm25ReversePostOrderTraversalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm25ReversePostOrderTraversalE")
//</editor-fold>
public class ReversePostOrderTraversal</*class*/ GraphT, /*class*/ NodeType /* = GraphTraits<GraphT>*/>  implements Destructors.ClassWithDestructor {
  /*typedef typename GT::NodeType NodeType*/
//  public final class NodeType extends NodeType{ };
  private final std.vector<NodeType/*P*/ > Blocks = new std.vector<NodeType/*P*/>((NodeType/*P*/)null); // Block list in normal PO order
  //<editor-fold defaultstate="collapsed" desc="llvm::ReversePostOrderTraversal::Initialize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 285,
   FQN="llvm::ReversePostOrderTraversal::Initialize", NM="_ZN4llvm25ReversePostOrderTraversal10InitializeEPNT0_8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm25ReversePostOrderTraversal10InitializeEPNT0_8NodeTypeE")
  //</editor-fold>
  private void Initialize(GraphTraits GT_For_BB, NodeType/*P*/ BB) {
    std.copy(po_begin(GT_For_BB, BB), po_end(GT_For_BB, BB), std.back_inserter(Blocks));
  }

/*public:*/
  /*typedef typename std::vector<NodeType *>::reverse_iterator rpo_iterator*/
//  public final class rpo_iterator extends  std.vector.reverse_iterator<NodeType/*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ReversePostOrderTraversal::ReversePostOrderTraversal<GraphT, GT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 291,
   FQN="llvm::ReversePostOrderTraversal::ReversePostOrderTraversal<GraphT, GT>", NM="_ZN4llvm25ReversePostOrderTraversalC1ET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm25ReversePostOrderTraversalC1ET_")
  //</editor-fold>
  public ReversePostOrderTraversal(GraphTraits<GraphT, NodeType, ?> GT, GraphT G) {
    Initialize(GT.getEntryNode$GTrait(G), GT.getEntryNode(G));
  }

  
  // Because we want a reverse post order, use reverse iterators from the vector
  //<editor-fold defaultstate="collapsed" desc="llvm::ReversePostOrderTraversal::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 294,
   FQN="llvm::ReversePostOrderTraversal::begin", NM="_ZN4llvm25ReversePostOrderTraversal5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm25ReversePostOrderTraversal5beginEv")
  //</editor-fold>
  public  std.reverse_iterator<NodeType/*P*/ > begin() {
    return Blocks.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReversePostOrderTraversal::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 295,
   FQN="llvm::ReversePostOrderTraversal::end", NM="_ZN4llvm25ReversePostOrderTraversal3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm25ReversePostOrderTraversal3endEv")
  //</editor-fold>
  public  std.reverse_iterator<NodeType/*P*/ > end() {
    return Blocks.rend();
  }

  
  @Override public String toString() {
    return "" + "Blocks=" + Blocks; // NOI18N
  }

  @Override
  public void $destroy() {
  }
}
