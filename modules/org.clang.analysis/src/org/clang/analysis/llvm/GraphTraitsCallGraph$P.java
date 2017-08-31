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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.llvm.adt.java.GraphTraits;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraph * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 199,
 FQN="llvm::GraphTraits<clang::CallGraph * >", NM="_ZN4llvm11GraphTraitsIPN5clang9CallGraphEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang9CallGraphEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsCallGraph$P implements GraphTraits<CallGraph, CallGraphNode, CallGraphNode> {
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraph * >::getEntryNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 202,
   FQN="llvm::GraphTraits<clang::CallGraph * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE12getEntryNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE12getEntryNodeES3_")
  //</editor-fold>
  @Override
  public CallGraphNode /*P*/ getEntryNode(CallGraph /*P*/ CGN) {
    return CGN.getRoot(); // Start at the external node!
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraphNode * >::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 180,
   FQN="llvm::GraphTraits<clang::CallGraphNode * >::child_begin", NM="_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE11child_beginES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE11child_beginES3_")
  //</editor-fold>
  @Override
  public /*inline*/ mapped_iterator<CallGraphNode/*P*/, CallGraphNode> child_begin(CallGraphNode /*P*/ N) {
    return llvm.map_iterator(N.begin(), /*FuncRef*/GraphTraitsCallGraphNode$P::CGNDeref);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraphNode * >::child_end">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 183,
   FQN="llvm::GraphTraits<clang::CallGraphNode * >::child_end", NM="_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE9child_endES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang13CallGraphNodeEE9child_endES3_")
  //</editor-fold>
  @Override
  public /*inline*/ mapped_iterator<CallGraphNode/*P*/, CallGraphNode> child_end(CallGraphNode /*P*/ N) {
    return llvm.map_iterator(N.end(), /*FuncRef*/GraphTraitsCallGraphNode$P::CGNDeref);
  }
  
  /*typedef std::pair<const clang::Decl *, clang::CallGraphNode *> PairTy*/
//  public final class PairTy extends std.pair</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >{ };
  /*typedef std::pointer_to_unary_function<PairTy, clang::CallGraphNode &> DerefFun*/
//  public final class DerefFun extends std.pointer_to_unary_function<std.pair</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >, CallGraphNode /*&*/ >{ };
  // nodes_iterator/begin/end - Allow iteration over all nodes in the graph
  /*typedef mapped_iterator<clang::CallGraph::iterator, DerefFun> nodes_iterator*/
//  public final class nodes_iterator extends mapped_iterator<DenseMapIterator</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >, std.pointer_to_unary_function<std.pair</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >, CallGraphNode /*&*/ > >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraph * >::nodes_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 210,
   FQN="llvm::GraphTraits<clang::CallGraph * >::nodes_begin", NM="_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE11nodes_beginES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE11nodes_beginES3_")
  //</editor-fold>
  @Override
  public mapped_iterator<std.pair</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >, CallGraphNode /*&*/ > nodes_begin(CallGraph /*P*/ CG) {
    return llvm.map_iterator(CG.begin(), /*FuncRef*/GraphTraitsCallGraph$P::CGdereference);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraph * >::nodes_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 213,
   FQN="llvm::GraphTraits<clang::CallGraph * >::nodes_end", NM="_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE9nodes_endES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE9nodes_endES3_")
  //</editor-fold>
  @Override
  public mapped_iterator<std.pair</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >, CallGraphNode /*&*/ > nodes_end(CallGraph /*P*/ CG) {
    return llvm.map_iterator(CG.end(), /*FuncRef*/GraphTraitsCallGraph$P::CGdereference);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraph * >::CGdereference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 216,
   FQN="llvm::GraphTraits<clang::CallGraph * >::CGdereference", NM="_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE13CGdereferenceESt4pairIPKNS1_4DeclEPNS1_13CallGraphNodeEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE13CGdereferenceESt4pairIPKNS1_4DeclEPNS1_13CallGraphNodeEE")
  //</editor-fold>
  public static CallGraphNode /*&*/ CGdereference(std.pair</*const*/ Decl /*P*/ , CallGraphNode /*P*/ > P) {
    return $Deref((P.second));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CallGraph * >::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 220,
   FQN="llvm::GraphTraits<clang::CallGraph * >::size", NM="_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE4sizeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang9CallGraphEE4sizeES3_")
  //</editor-fold>
  @Override
  public /*uint*/int size(CallGraph /*P*/ CG) {
    return CG.size();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsCallGraph$P INSTANCE = new GraphTraitsCallGraph$P();
  
  public static GraphTraitsCallGraph$P $GTraits() { return INSTANCE; }

  @Override
  public GraphTraits<CallGraph, CallGraphNode, CallGraphNode> getEntryNode$GTrait(CallGraph p) {
    return (GraphTraits)GraphTraitsCallGraphNode$P.$GTraits();
  }
    
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
