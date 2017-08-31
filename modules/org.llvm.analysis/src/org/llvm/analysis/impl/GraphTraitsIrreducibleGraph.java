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

package org.llvm.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.java.GraphTraits;
import org.llvm.analysis.bfi_detail.*;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<IrreducibleGraph>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 622,
 FQN="llvm::GraphTraits<IrreducibleGraph>", NM="_ZN4llvm11GraphTraitsINS_10bfi_detail16IrreducibleGraphEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm11GraphTraitsINS_10bfi_detail16IrreducibleGraphEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsIrreducibleGraph implements GraphTraits<IrreducibleGraph, IrreducibleGraph.IrrNode, IrreducibleGraph.IrrNode> {
  // JAVA: typedef bfi_detail::IrreducibleGraph GraphT
//  public final class GraphT extends IrreducibleGraph{ };
  
  // JAVA: typedef const GraphT::IrrNode NodeType
//  public final class NodeType extends /*const*/ IrreducibleGraph.IrrNode{ };
  // JAVA: typedef const GraphT::IrrNode *NodeRef
//  public final class NodeRef extends /*const*/ IrreducibleGraph.IrrNode /*P*/ { };
  // JAVA: typedef GraphT::IrrNode::iterator ChildIteratorType
//  public final class ChildIteratorType extends std._Deque_iterator</*const*/ IrreducibleGraph.IrrNode /*P*/ , /*const*/ IrreducibleGraph.IrrNode /*P*/ /*const*/ /*&*/ , type$ptr</*const*/ IrreducibleGraph.IrrNode /*P*/ /*const*/ /*P*/> >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<IrreducibleGraph>::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 629,
   FQN="llvm::GraphTraits<IrreducibleGraph>::getEntryNode", NM="_ZN4llvm11GraphTraitsINS_10bfi_detail16IrreducibleGraphEE12getEntryNodeERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm11GraphTraitsINS_10bfi_detail16IrreducibleGraphEE12getEntryNodeERKS2_")
  //</editor-fold>
  public /*const*/ IrreducibleGraph.IrrNode /*P*/ getEntryNode(final /*const*/ IrreducibleGraph /*&*/ G) {
    return G.StartIrr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<IrreducibleGraph>::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 632,
   FQN="llvm::GraphTraits<IrreducibleGraph>::child_begin", NM="_ZN4llvm11GraphTraitsINS_10bfi_detail16IrreducibleGraphEE11child_beginEPKNS2_7IrrNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm11GraphTraitsINS_10bfi_detail16IrreducibleGraphEE11child_beginEPKNS2_7IrrNodeE")
  //</editor-fold>
  public std.deque.iterator</*const*/ IrreducibleGraph.IrrNode> child_begin(/*const*/ IrreducibleGraph.IrrNode /*P*/ N) {
    return N.succ_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<IrreducibleGraph>::child_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 633,
   FQN="llvm::GraphTraits<IrreducibleGraph>::child_end", NM="_ZN4llvm11GraphTraitsINS_10bfi_detail16IrreducibleGraphEE9child_endEPKNS2_7IrrNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm11GraphTraitsINS_10bfi_detail16IrreducibleGraphEE9child_endEPKNS2_7IrrNodeE")
  //</editor-fold>
  public std.deque.iterator</*const*/ IrreducibleGraph.IrrNode> child_end(/*const*/ IrreducibleGraph.IrrNode /*P*/ N) {
    return N.succ_end();
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
