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
import static org.clank.support.Native.$tryClone;
import org.llvm.adt.*;


/// ilist_node_traits - A fragment for template traits for intrusive list
/// that provides default node related operations.
///
/*template <typename NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_traits">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 157,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 110,
 FQN="llvm::ilist_node_traits", NM="_ZN4llvm17ilist_node_traitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm17ilist_node_traitsE")
//</editor-fold>
public interface/*struct*/ ilist_node_traits</*typename*/ NodeTy extends ilist_node<NodeTy>>  {
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_traits::createNode">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 159,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 112,
   FQN="llvm::ilist_node_traits::createNode", NM="_ZN4llvm17ilist_node_traits10createNodeERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm17ilist_node_traits10createNodeERKT_")
  //</editor-fold>
  public default NodeTy /*P*/ createNode(/*const*/ NodeTy /*&*/ V) {
    NodeTy result = $tryClone(V);
    if (result == V) {
      throw new UnsupportedOperationException("createNode() should be overridden in descendant " + getClass().getName());
    }
    return result;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_traits::deleteNode">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 113,
   FQN="llvm::ilist_node_traits::deleteNode", NM="_ZN4llvm17ilist_node_traits10deleteNodeEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm17ilist_node_traits10deleteNodeEPT_")
  //</editor-fold>
  public default void deleteNode(iplist</*typename*/ NodeTy> list, NodeTy /*P*/ V) {
    /*delete*/Destructors.$destroy(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_traits::addNodeToList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 115,
   FQN="llvm::ilist_node_traits::addNodeToList", NM="_ZN4llvm17ilist_node_traits13addNodeToListEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm17ilist_node_traits13addNodeToListEPT_")
  //</editor-fold>
  default public void addNodeToList(iplist</*typename*/ NodeTy> list, NodeTy /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_traits::removeNodeFromList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 116,
   FQN="llvm::ilist_node_traits::removeNodeFromList", NM="_ZN4llvm17ilist_node_traits18removeNodeFromListEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm17ilist_node_traits18removeNodeFromListEPT_")
  //</editor-fold>
  default public void removeNodeFromList(iplist</*typename*/ NodeTy> list, NodeTy /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_traits::transferNodesFromList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 164,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 117,
   FQN="llvm::ilist_node_traits::transferNodesFromList", NM="_ZN4llvm17ilist_node_traits21transferNodesFromListERNS_17ilist_node_traitsIT_EENS_14ilist_iteratorIS2_EES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm17ilist_node_traits21transferNodesFromListERNS_17ilist_node_traitsIT_EENS_14ilist_iteratorIS2_EES7_")
  //</editor-fold>
  default public void transferNodesFromList(ilist_node_traits<NodeTy> /*&*/ $Prm0/*SrcTraits*/, 
                       ilist_iterator<NodeTy> $Prm1/*first*/, 
                       ilist_iterator<NodeTy> $Prm2/*last*/) {
  }
}
