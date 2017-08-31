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

package org.clang.analysis.analyses.llvm;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.llvm.adt.java.GraphTraits;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 169,
 FQN="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >", NM="_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsDomTreeNodeBase$CFGBlock$P implements GraphTraits<DomTreeNodeBase<CFGBlock>, DomTreeNodeBase<CFGBlock>, DomTreeNodeBase<CFGBlock>> {
  /*typedef ::clang::DomTreeNode NodeType*/
//  public final class NodeType extends DomTreeNodeBase<CFGBlock>{ };
  /*typedef ::clang::DomTreeNode *NodeRef*/
//  public final class NodeRef extends DomTreeNodeBase<CFGBlock> /*P*/ { };
  /*typedef NodeType::iterator ChildIteratorType*/
//  public final class ChildIteratorType extends type$iterator<?, DomTreeNodeBase<CFGBlock>>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 174,
   FQN="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE12getEntryNodeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE12getEntryNodeES5_")
  //</editor-fold>
  public DomTreeNodeBase<CFGBlock> /*P*/ getEntryNode(DomTreeNodeBase<CFGBlock> /*P*/ N) {
    return N;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 177,
   FQN="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::child_begin", NM="_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE11child_beginES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE11child_beginES5_")
  //</editor-fold>
  public /*inline*/ type$iterator<?, DomTreeNodeBase<CFGBlock>> child_begin(DomTreeNodeBase<CFGBlock> /*P*/ N) {
    return N.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::child_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 180,
   FQN="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::child_end", NM="_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE9child_endES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE9child_endES5_")
  //</editor-fold>
  public /*inline*/ type$iterator<?, DomTreeNodeBase<CFGBlock>> child_end(DomTreeNodeBase<CFGBlock> /*P*/ N) {
    return N.end();
  }

  
  /*typedef df_iterator< ::clang::DomTreeNode *> nodes_iterator*/
//  public final class nodes_iterator extends df_iterator<DomTreeNodeBase<CFGBlock> /*P*/ , DomTreeNodeBase<CFGBlock> /*P*/ , DomTreeNodeBase<CFGBlock> /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::nodes_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 186,
   FQN="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::nodes_begin", NM="_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE11nodes_beginES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE11nodes_beginES5_")
  //</editor-fold>
  public df_iterator<DomTreeNodeBase<CFGBlock> /*P*/ , DomTreeNodeBase<CFGBlock> /*P*/ , DomTreeNodeBase<CFGBlock> /*P*/ > nodes_begin(DomTreeNodeBase<CFGBlock> /*P*/ N) {
    final DomTreeNodeBase<CFGBlock> entryNode = getEntryNode(N);
    return GraphTraits.<DomTreeNodeBase<CFGBlock>, DomTreeNodeBase<CFGBlock>, DomTreeNodeBase<CFGBlock>>df_begin(this, entryNode);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::nodes_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 190,
   FQN="llvm::GraphTraits<llvm::DomTreeNodeBase<clang::CFGBlock> * >::nodes_end", NM="_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE9nodes_endES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN4llvm11GraphTraitsIPNS_15DomTreeNodeBaseIN5clang8CFGBlockEEEE9nodes_endES5_")
  //</editor-fold>
  public df_iterator<DomTreeNodeBase<CFGBlock> /*P*/ , DomTreeNodeBase<CFGBlock> /*P*/ , DomTreeNodeBase<CFGBlock> /*P*/ > nodes_end(DomTreeNodeBase<CFGBlock> /*P*/ N) {
    return GraphTraits.<DomTreeNodeBase<CFGBlock>, DomTreeNodeBase<CFGBlock>, DomTreeNodeBase<CFGBlock>>df_end(this, getEntryNode(N));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsDomTreeNodeBase$CFGBlock$P INSTANCE = new GraphTraitsDomTreeNodeBase$CFGBlock$P();
  
  public static GraphTraitsDomTreeNodeBase$CFGBlock$P $GTraits() { return INSTANCE; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
