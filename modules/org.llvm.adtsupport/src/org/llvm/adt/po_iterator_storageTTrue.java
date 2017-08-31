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
import org.llvm.adt.*;
import org.llvm.adt.java.Insertable;


/// Specialization of po_iterator_storage that references an external set.
/*template <class SetType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<type-parameter-0-0, true>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 70,
 FQN="llvm::po_iterator_storage<type-parameter-0-0, true>", NM="_ZN4llvm19po_iterator_storageIT_Lb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm19po_iterator_storageIT_Lb1EEE")
//</editor-fold>
public class po_iterator_storageTTrue<NodeType>  extends po_iterator_storage<NodeType> {
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<type-parameter-0-0, true>::po_iterator_storage<type-parameter-0-0, true>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 74,
   FQN="llvm::po_iterator_storage<type-parameter-0-0, true>::po_iterator_storage<type-parameter-0-0, true>", NM="_ZN4llvm19po_iterator_storageIT_Lb1EEC1ERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm19po_iterator_storageIT_Lb1EEC1ERS1_")
  //</editor-fold>
  public po_iterator_storageTTrue(final Insertable<?, NodeType> /*&*/ VSet) {
    // : Visited(VSet) 
    //START JInit
    super(true, VSet);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<type-parameter-0-0, true>::po_iterator_storage<type-parameter-0-0, true>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 75,
   FQN="llvm::po_iterator_storage<type-parameter-0-0, true>::po_iterator_storage<type-parameter-0-0, true>", NM="_ZN4llvm19po_iterator_storageIT_Lb1EEC1ERKNS0_IS1_Lb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm19po_iterator_storageIT_Lb1EEC1ERKNS0_IS1_Lb1EEE")
  //</editor-fold>
  public po_iterator_storageTTrue(final /*const*/ po_iterator_storageTTrue<NodeType> S) {
    // : Visited(S.Visited) 
    //START JInit
    super(S);
    //END JInit
  }

  
  // Return true if edge destination should be visited, called with From = 0 for
  // the root node.
  // Graph edges can be pruned by specializing this function.
  /*template <class NodeType> TEMPLATE*/
  // Return true if edge destination should be visited, called with From = 0 for
  // the root node.
  // Graph edges can be pruned by specializing this function.
  /*template <class NodeType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<type-parameter-0-0, true>::insertEdge">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 80,
   FQN="llvm::po_iterator_storage<type-parameter-0-0, true>::insertEdge", NM="Tpl__ZN4llvm19po_iterator_storageIT_Lb1EE10insertEdgeEPT_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm19po_iterator_storageIT_Lb1EE10insertEdgeEPT_S4_")
  //</editor-fold>
  public boolean insertEdge(NodeType /*P*/ From, NodeType /*P*/ To) {
    return super.insertEdge(From, To);
  }

  
  // Called after all children of BB have been visited.
  /*template <class NodeType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<type-parameter-0-0, true>::finishPostorder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 85,
   FQN="llvm::po_iterator_storage<type-parameter-0-0, true>::finishPostorder", NM="Tpl__ZN4llvm19po_iterator_storageIT_Lb1EE15finishPostorderEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=Tpl__ZN4llvm19po_iterator_storageIT_Lb1EE15finishPostorderEPT_")
  //</editor-fold>
  public </*class*/ NodeType> void finishPostorder(NodeType /*P*/ BB) {
  }
}
