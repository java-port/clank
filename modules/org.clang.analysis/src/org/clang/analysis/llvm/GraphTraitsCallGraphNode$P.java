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

package org.clang.analysis.llvm;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.llvm.adt.java.GraphTraits;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraphNode * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 173,
 FQN="llvm::GraphTraits<clang::CallGraphNode * >", NM="_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsCallGraphNode$P implements GraphTraits<CallGraphNode/*why not CallGrap?*/, CallGraphNode, CallGraphNode> {
  /*typedef clang::CallGraphNode NodeType*/
//  public final class NodeType extends CallGraphNode{ };
  /*typedef clang::CallGraphNode::CallRecord CallRecordTy*/
//  public final class CallRecordTy extends CallGraphNode /*P*/ { };
  /*typedef std::pointer_to_unary_function<CallRecordTy, clang::CallGraphNode *> CGNDerefFun*/
//  public final class CGNDerefFun extends std.pointer_to_unary_function<CallGraphNode /*P*/ , CallGraphNode /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraphNode * >::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 178,
   FQN="llvm::GraphTraits<clang::CallGraphNode * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE12getEntryNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE12getEntryNodeES3_")
  //</editor-fold>
  public CallGraphNode /*P*/ getEntryNode(CallGraphNode /*P*/ CGN) {
    return CGN;
  }

  /*typedef mapped_iterator<NodeType::iterator, CGNDerefFun> ChildIteratorType*/
//  public final class ChildIteratorType extends mapped_iterator<type$ptr<CallGraphNode/*P*/>, std.pointer_to_unary_function<CallGraphNode /*P*/ , CallGraphNode /*P*/ > >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraphNode * >::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 180,
   FQN="llvm::GraphTraits<clang::CallGraphNode * >::child_begin", NM="_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE11child_beginES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE11child_beginES3_")
  //</editor-fold>
  public /*inline*/ mapped_iterator<CallGraphNode/*P*/, CallGraphNode> child_begin(CallGraphNode /*P*/ N) {
    return map_iterator(N.begin(), /*FuncRef*/GraphTraitsCallGraphNode$P::CGNDeref);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraphNode * >::child_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 183,
   FQN="llvm::GraphTraits<clang::CallGraphNode * >::child_end", NM="_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE9child_endES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE9child_endES3_")
  //</editor-fold>
  public /*inline*/ mapped_iterator<CallGraphNode/*P*/, CallGraphNode> child_end(CallGraphNode /*P*/ N) {
    return map_iterator(N.end(), /*FuncRef*/GraphTraitsCallGraphNode$P::CGNDeref);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraphNode * >::CGNDeref">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 186,
   FQN="llvm::GraphTraits<clang::CallGraphNode * >::CGNDeref", NM="_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE8CGNDerefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE8CGNDerefES3_")
  //</editor-fold>
  public static CallGraphNode /*P*/ CGNDeref(CallGraphNode /*P*/ P) {
    return P;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsCallGraphNode$P INSTANCE = new GraphTraitsCallGraphNode$P();
  
  public static GraphTraitsCallGraphNode$P $GTraits() { return INSTANCE; }

  public @Override df_iterator<CallGraphNode, CallGraphNode, CallGraphNode> nodes_begin(CallGraphNode S) {
  
    return GraphTraits.df_begin(this, S);
  
  }

  
  
  public @Override df_iterator<CallGraphNode, CallGraphNode, CallGraphNode> nodes_end(CallGraphNode S) {
  
    return GraphTraits.df_end(this, S);
  
  }

  @Override
  public GraphTraits<CallGraphNode, CallGraphNode, CallGraphNode> getEntryNode$GTrait(CallGraphNode p) {
    return this;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
