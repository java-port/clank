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

package org.clang.staticanalyzer.core.pathsensitive.llvm;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.llvm.*;
import org.llvm.adt.java.GraphTraits;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::ento::ExplodedNode * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 480,
 FQN="llvm::GraphTraits<const clang::ento::ExplodedNode * >", NM="_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsExplodedNode$C$P implements GraphTraits<ExplodedNode, ExplodedNode, ExplodedNode> {
  /*typedef const clang::ento::ExplodedNode NodeType*/
//  public final class NodeType extends /*const*/ ExplodedNode{ };
  /*typedef const clang::ento::ExplodedNode *NodeRef*/
//  public final class NodeRef extends /*const*/ ExplodedNode /*P*/ { };
  /*typedef NodeType::const_succ_iterator ChildIteratorType*/
//  public final class ChildIteratorType extends type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::df_iterator<NodeType *> nodes_iterator*/
//  public final class nodes_iterator extends df_iterator</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::ento::ExplodedNode * >::getEntryNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 486,
   FQN="llvm::GraphTraits<const clang::ento::ExplodedNode * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE12getEntryNodeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE12getEntryNodeES5_")
  //</editor-fold>
  public /*inline*/ /*const*/ ExplodedNode /*P*/ getEntryNode(/*const*/ ExplodedNode /*P*/ N) {
    return N;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::ento::ExplodedNode * >::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 490,
   FQN="llvm::GraphTraits<const clang::ento::ExplodedNode * >::child_begin", NM="_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE11child_beginES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE11child_beginES5_")
  //</editor-fold>
  public /*inline*/ type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/> child_begin(/*const*/ ExplodedNode /*P*/ N) {
    return N.succ_begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::ento::ExplodedNode * >::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 494,
   FQN="llvm::GraphTraits<const clang::ento::ExplodedNode * >::child_end", NM="_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE9child_endES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE9child_endES5_")
  //</editor-fold>
  public /*inline*/ type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/> child_end(/*const*/ ExplodedNode /*P*/ N) {
    return N.succ_end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::ento::ExplodedNode * >::nodes_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 498,
   FQN="llvm::GraphTraits<const clang::ento::ExplodedNode * >::nodes_begin", NM="_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE11nodes_beginES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE11nodes_beginES5_")
  //</editor-fold>
  public /*inline*/ df_iterator</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > nodes_begin(/*const*/ ExplodedNode /*P*/ N) {
    return GraphTraits.df_begin(this, N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::ento::ExplodedNode * >::nodes_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 502,
   FQN="llvm::GraphTraits<const clang::ento::ExplodedNode * >::nodes_end", NM="_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE9nodes_endES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4ento12ExplodedNodeEE9nodes_endES5_")
  //</editor-fold>
  public /*inline*/ df_iterator</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > nodes_end(/*const*/ ExplodedNode /*P*/ N) {
    return GraphTraits.df_end(this, N);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsExplodedNode$C$P INSTANCE = new GraphTraitsExplodedNode$C$P();
  
  public static GraphTraitsExplodedNode$C$P $GTraits() {
  
    return INSTANCE;
  
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
