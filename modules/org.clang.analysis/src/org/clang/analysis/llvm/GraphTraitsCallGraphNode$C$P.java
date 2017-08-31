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
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.llvm.adt.java.GraphTraits;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::CallGraphNode * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 191,
 FQN="llvm::GraphTraits<const clang::CallGraphNode * >", NM="_ZN4llvm11GraphTraitsIPKN5clang13CallGraphNodeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang13CallGraphNodeEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsCallGraphNode$C$P implements GraphTraits<CallGraphNode, CallGraphNode, CallGraphNode> {
  /*typedef const clang::CallGraphNode NodeType*/
//  public final class NodeType extends /*const*/ CallGraphNode{ };
  /*typedef NodeType::const_iterator ChildIteratorType*/
//  public final class ChildIteratorType extends type$ptr<CallGraphNode/*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::CallGraphNode * >::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 194,
   FQN="llvm::GraphTraits<const clang::CallGraphNode * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPKN5clang13CallGraphNodeEE12getEntryNodeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang13CallGraphNodeEE12getEntryNodeES4_")
  //</editor-fold>
  public /*const*/ CallGraphNode /*P*/ getEntryNode(/*const*/ CallGraphNode /*P*/ CGN) {
    return CGN;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::CallGraphNode * >::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 195,
   FQN="llvm::GraphTraits<const clang::CallGraphNode * >::child_begin", NM="_ZN4llvm11GraphTraitsIPKN5clang13CallGraphNodeEE11child_beginES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang13CallGraphNodeEE11child_beginES4_")
  //</editor-fold>
  public /*inline*/ type$ptr<CallGraphNode/*P*/> child_begin(/*const*/ CallGraphNode /*P*/ N) {
    return N.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::CallGraphNode * >::child_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 196,
   FQN="llvm::GraphTraits<const clang::CallGraphNode * >::child_end", NM="_ZN4llvm11GraphTraitsIPKN5clang13CallGraphNodeEE9child_endES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang13CallGraphNodeEE9child_endES4_")
  //</editor-fold>
  public /*inline*/ type$ptr<CallGraphNode/*P*/> child_end(/*const*/ CallGraphNode /*P*/ N) {
    return N.end$Const();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsCallGraphNode$C$P INSTANCE = new GraphTraitsCallGraphNode$C$P();
  
  private static GraphTraitsCallGraphNode$C$P $GTraits() {
  
    return INSTANCE;
  
  }
  
  public @Override df_iterator<CallGraphNode, CallGraphNode, CallGraphNode> nodes_begin(CallGraphNode S) {
  
    return GraphTraits.df_begin(this, S);
  
  }

  
  
  public @Override df_iterator<CallGraphNode, CallGraphNode,CallGraphNode> nodes_end(CallGraphNode S) {
  
    return GraphTraits.df_end(this, S);
  
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
