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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.java.GraphTraits;


//===-------------------------------------
// DominatorTree GraphTraits specializations so the DominatorTree can be
// iterable by generic graph iterators.
/*template <class Node, class ChildIterator> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DomTreeGraphTraitsBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 157,
 FQN="llvm::DomTreeGraphTraitsBase", NM="_ZN4llvm22DomTreeGraphTraitsBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm22DomTreeGraphTraitsBaseE")
//</editor-fold>
public abstract class/*struct*/ DomTreeGraphTraitsBase<GraphType, /*class*/ NodeType extends DomTreeNodeBase, /*class*/ ChildNodeType> implements GraphTraits<GraphType, NodeType, ChildNodeType>  {
  /*typedef Node NodeType*/
//  public final class NodeType extends Node{ };
  /*typedef ChildIterator ChildIteratorType*/
//  public final class ChildIteratorType extends ChildIterator{ };
  /*typedef df_iterator<Node *, SmallPtrSet<NodeType *, 8> > nodes_iterator*/
//  public final class nodes_iterator extends df_iterator<Node /*P*/ , SmallPtrSet<Node /*P*/ , 8> >{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeGraphTraitsBase::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 162,
   FQN="llvm::DomTreeGraphTraitsBase::getEntryNode", NM="_ZN4llvm22DomTreeGraphTraitsBase12getEntryNodeEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm22DomTreeGraphTraitsBase12getEntryNodeEPT_")
  //</editor-fold>
  @Override
  public NodeType /*P*/ getEntryNode(GraphType /*P*/ N) {
    return (NodeType)N;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeGraphTraitsBase::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 163,
   FQN="llvm::DomTreeGraphTraitsBase::child_begin", NM="_ZN4llvm22DomTreeGraphTraitsBase11child_beginEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm22DomTreeGraphTraitsBase11child_beginEPT_")
  //</editor-fold>
  @Override
  public type$iterator<?, ChildNodeType> child_begin(NodeType /*P*/ N) {
    return N.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeGraphTraitsBase::child_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 166,
   FQN="llvm::DomTreeGraphTraitsBase::child_end", NM="_ZN4llvm22DomTreeGraphTraitsBase9child_endEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm22DomTreeGraphTraitsBase9child_endEPT_")
  //</editor-fold>
  @Override
  public type$iterator<?, ChildNodeType> child_end(NodeType /*P*/ N) {
    return N.end();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeGraphTraitsBase::nodes_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 168,
   FQN="llvm::DomTreeGraphTraitsBase::nodes_begin", NM="_ZN4llvm22DomTreeGraphTraitsBase11nodes_beginEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm22DomTreeGraphTraitsBase11nodes_beginEPT_")
  //</editor-fold>
  @Override
  public df_iterator<?, NodeType /*P*/ , ChildNodeType> nodes_begin(GraphType /*P*/ N) {
    return GraphTraits.df_begin(this.getEntryNode$GTrait(N), getEntryNode(N));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeGraphTraitsBase::nodes_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 172,
   FQN="llvm::DomTreeGraphTraitsBase::nodes_end", NM="_ZN4llvm22DomTreeGraphTraitsBase9nodes_endEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm22DomTreeGraphTraitsBase9nodes_endEPT_")
  //</editor-fold>
  @Override
  public df_iterator<?, NodeType /*P*/ , ChildNodeType> nodes_end(GraphType /*P*/ N) {
    return GraphTraits.df_end(this.getEntryNode$GTrait(N), getEntryNode(N));
  }


  @Override public String toString() {
    return ""; // NOI18N
  }
}
