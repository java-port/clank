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

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.java.Insertable;


// The po_iterator_storage template provides access to the set of already
// visited nodes during the po_iterator's depth-first traversal.
//
// The default implementation simply contains a set of visited nodes, while
// the External=true version uses a reference to an external set.
//
// It is possible to prune the depth-first traversal in several ways:
//
// - When providing an external set that already contains some graph nodes,
//   those nodes won't be visited again. This is useful for restarting a
//   post-order traversal on a graph with nodes that aren't dominated by a
//   single node.
//
// - By providing a custom SetType class, unwanted graph nodes can be excluded
//   by having the insert() function return false. This could for example
//   confine a CFG traversal to blocks in a specific loop.
//
// - Finally, by specializing the po_iterator_storage template itself, graph
//   edges can be pruned by returning false in the insertEdge() function. This
//   could be used to remove loop back-edges from the CFG seen by po_iterator.
//
// A specialized po_iterator_storage class can observe both the pre-order and
// the post-order. The insertEdge() function is called in a pre-order, while
// the finishPostorder() function is called just before the po_iterator moves
// on to the next node.

/// Default po_iterator_storage implementation with an internal set object.
/*template <class SetType, bool External> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 54,
 FQN="llvm::po_iterator_storage", NM="_ZN4llvm19po_iterator_storageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm19po_iterator_storageE")
//</editor-fold>
public class po_iterator_storage<NodeType>  {
  private Insertable<?, NodeType> Visited;
/*public:*/
  // Return true if edge destination should be visited.
  /*template <typename NodeType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage::insertEdge">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 60,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 59,
   FQN="llvm::po_iterator_storage::insertEdge", NM="Tpl__ZN4llvm19po_iterator_storage10insertEdgeEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm19po_iterator_storage10insertEdgeEPT_S2_")
  //</editor-fold>
  public boolean insertEdge(NodeType /*P*/ From, NodeType /*P*/ To) {
    return Visited.insert(To).second;
  }

  
  // Called after all children of BB have been visited.
  /*template <typename NodeType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage::finishPostorder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 66,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 65,
   FQN="llvm::po_iterator_storage::finishPostorder", NM="Tpl__ZN4llvm19po_iterator_storage15finishPostorderEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm19po_iterator_storage15finishPostorderEPT_")
  //</editor-fold>
  public </*typename*/ NodeType> void finishPostorder(NodeType /*P*/ BB) {
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final boolean External;

  public po_iterator_storage(final po_iterator_storage<NodeType> other) {
    this.External = other.External;
    this.Visited = $tryClone(other.Visited);
  }

  public po_iterator_storage(boolean External, final Insertable<?, NodeType> /*&*/ VSet) {
    // : Visited(VSet) 
    this.External = External;
    this.Visited = VSet;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Visited=" + Visited; // NOI18N
  }
}
