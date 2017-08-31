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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.analysis.*;


/// \class NodeBuilder
/// \brief This is the simplest builder which generates nodes in the
/// ExplodedGraph.
///
/// The main benefit of the builder is that it automatically tracks the
/// frontier nodes (or destination set). This is the set of nodes which should
/// be propagated to the next step / builder. They are the nodes which have been
/// added to the builder (either as the input node set or as the newly
/// constructed nodes) but did not have any outgoing transitions added.
//<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 210,
 FQN="clang::ento::NodeBuilder", NM="_ZN5clang4ento11NodeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilderE")
//</editor-fold>
public class NodeBuilder implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 640,
   FQN="clang::ento::NodeBuilder::anchor", NM="_ZN5clang4ento11NodeBuilder6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  protected final /*const*/ NodeBuilderContext /*&*/ C;
  
  /// Specifies if the builder results have been finalized. For example, if it
  /// is set to false, autotransitions are yet to be generated.
  protected boolean Finalized;
  protected boolean HasGeneratedNodes;
  /// \brief The frontier set - a set of nodes which need to be propagated after
  /// the builder dies.
  protected final ExplodedNodeSet /*&*/ Frontier;
  
  /// Checkes if the results are ready.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::checkResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 224,
   FQN="clang::ento::NodeBuilder::checkResults", NM="_ZN5clang4ento11NodeBuilder12checkResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder12checkResultsEv")
  //</editor-fold>
  protected /*virtual*/ boolean checkResults() {
    if (!Finalized) {
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::hasNoSinksInFrontier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 230,
   FQN="clang::ento::NodeBuilder::hasNoSinksInFrontier", NM="_ZN5clang4ento11NodeBuilder20hasNoSinksInFrontierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder20hasNoSinksInFrontierEv")
  //</editor-fold>
  protected boolean hasNoSinksInFrontier() {
    for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Frontier.begin(), E = Frontier.end(); I.$noteq(E); I.$preInc()) {
      if ((I.$star()).isSink()) {
        return false;
      }
    }
    return true;
  }

  
  /// Allow subclasses to finalize results before result_begin() is executed.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::finalizeResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 239,
   FQN="clang::ento::NodeBuilder::finalizeResults", NM="_ZN5clang4ento11NodeBuilder15finalizeResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder15finalizeResultsEv")
  //</editor-fold>
  protected /*virtual*/ void finalizeResults() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::generateNodeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 642,
   FQN="clang::ento::NodeBuilder::generateNodeImpl", NM="_ZN5clang4ento11NodeBuilder16generateNodeImplERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder16generateNodeImplERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeEb")
  //</editor-fold>
  protected ExplodedNode /*P*/ generateNodeImpl(final /*const*/ ProgramPoint /*&*/ Loc, 
                  IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  ExplodedNode /*P*/ FromN) {
    return generateNodeImpl(Loc, 
                  State, 
                  FromN, 
                  false);
  }
  protected ExplodedNode /*P*/ generateNodeImpl(final /*const*/ ProgramPoint /*&*/ Loc, 
                  IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  ExplodedNode /*P*/ FromN, 
                  boolean MarkAsSink/*= false*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      HasGeneratedNodes = true;
      bool$ptr IsNew = create_bool$ptr();
      ExplodedNode /*P*/ N = $c$.clean(C.Eng.G.getNode(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), MarkAsSink, $AddrOf(IsNew)));
      N.addPredecessor(FromN, C.Eng.G);
      Frontier.erase(FromN);
      if (!IsNew.$star()) {
        return null;
      }
      if (!MarkAsSink) {
        Frontier.Add(N);
      }
      
      return N;
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::NodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 247,
   FQN="clang::ento::NodeBuilder::NodeBuilder", NM="_ZN5clang4ento11NodeBuilderC1EPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS0_18NodeBuilderContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilderC1EPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS0_18NodeBuilderContextEb")
  //</editor-fold>
  public NodeBuilder(ExplodedNode /*P*/ SrcNode, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ Ctx) {
    this(SrcNode, DstSet, 
      Ctx, true);
  }
  public NodeBuilder(ExplodedNode /*P*/ SrcNode, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ Ctx, boolean F/*= true*/) {
    // : C(Ctx), Finalized(F), HasGeneratedNodes(false), Frontier(DstSet) 
    //START JInit
    this./*&*/C=/*&*/Ctx;
    this.Finalized = F;
    this.HasGeneratedNodes = false;
    this./*&*/Frontier=/*&*/DstSet;
    //END JInit
    Frontier.Add(SrcNode);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::NodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 253,
   FQN="clang::ento::NodeBuilder::NodeBuilder", NM="_ZN5clang4ento11NodeBuilderC1ERKNS0_15ExplodedNodeSetERS2_RKNS0_18NodeBuilderContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilderC1ERKNS0_15ExplodedNodeSetERS2_RKNS0_18NodeBuilderContextEb")
  //</editor-fold>
  public NodeBuilder(final /*const*/ ExplodedNodeSet /*&*/ SrcSet, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ Ctx) {
    this(SrcSet, DstSet, 
      Ctx, true);
  }
  public NodeBuilder(final /*const*/ ExplodedNodeSet /*&*/ SrcSet, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ Ctx, boolean F/*= true*/) {
    // : C(Ctx), Finalized(F), HasGeneratedNodes(false), Frontier(DstSet) 
    //START JInit
    this./*&*/C=/*&*/Ctx;
    this.Finalized = F;
    this.HasGeneratedNodes = false;
    this./*&*/Frontier=/*&*/DstSet;
    //END JInit
    Frontier.insert(SrcSet);
    assert (hasNoSinksInFrontier());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::~NodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 260,
   FQN="clang::ento::NodeBuilder::~NodeBuilder", NM="_ZN5clang4ento11NodeBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilderD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// \brief Generates a node in the ExplodedGraph.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::generateNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 263,
   FQN="clang::ento::NodeBuilder::generateNode", NM="_ZN5clang4ento11NodeBuilder12generateNodeERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder12generateNodeERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateNode(final /*const*/ ProgramPoint /*&*/ PP, 
              IntrusiveRefCntPtr</*const*/ ProgramState> State, 
              ExplodedNode /*P*/ Pred) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(generateNodeImpl(PP, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Pred, false));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Generates a sink in the ExplodedGraph.
  ///
  /// When a node is marked as sink, the exploration from the node is stopped -
  /// the node becomes the last node on the path and certain kinds of bugs are
  /// suppressed.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::generateSink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 274,
   FQN="clang::ento::NodeBuilder::generateSink", NM="_ZN5clang4ento11NodeBuilder12generateSinkERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder12generateSinkERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateSink(final /*const*/ ProgramPoint /*&*/ PP, 
              IntrusiveRefCntPtr</*const*/ ProgramState> State, 
              ExplodedNode /*P*/ Pred) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(generateNodeImpl(PP, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Pred, true));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::getResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 280,
   FQN="clang::ento::NodeBuilder::getResults", NM="_ZN5clang4ento11NodeBuilder10getResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder10getResultsEv")
  //</editor-fold>
  public /*const*/ ExplodedNodeSet /*&*/ getResults() {
    finalizeResults();
    assert (checkResults());
    return Frontier;
  }

  
  // JAVA: typedef ExplodedNodeSet::iterator iterator
//  public final class iterator extends SmallPtrSetIterator<ExplodedNode /*P*/ >{ };
  /// \brief Iterators through the results frontier.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 288,
   FQN="clang::ento::NodeBuilder::begin", NM="_ZN5clang4ento11NodeBuilder5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder5beginEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<ExplodedNode /*P*/ > begin() {
    finalizeResults();
    assert (checkResults());
    return Frontier.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 293,
   FQN="clang::ento::NodeBuilder::end", NM="_ZN5clang4ento11NodeBuilder3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder3endEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<ExplodedNode /*P*/ > end() {
    finalizeResults();
    return Frontier.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 298,
   FQN="clang::ento::NodeBuilder::getContext", NM="_ZN5clang4ento11NodeBuilder10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder10getContextEv")
  //</editor-fold>
  public /*const*/ NodeBuilderContext /*&*/ getContext() {
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::hasGeneratedNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 299,
   FQN="clang::ento::NodeBuilder::hasGeneratedNodes", NM="_ZN5clang4ento11NodeBuilder17hasGeneratedNodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder17hasGeneratedNodesEv")
  //</editor-fold>
  public boolean hasGeneratedNodes() {
    return HasGeneratedNodes;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::takeNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 301,
   FQN="clang::ento::NodeBuilder::takeNodes", NM="_ZN5clang4ento11NodeBuilder9takeNodesERKNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder9takeNodesERKNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void takeNodes(final /*const*/ ExplodedNodeSet /*&*/ S) {
    for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = S.begin$Const(), E = S.end$Const(); I.$noteq(E); I.$preInc())  {
      Frontier.erase(I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::takeNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 305,
   FQN="clang::ento::NodeBuilder::takeNodes", NM="_ZN5clang4ento11NodeBuilder9takeNodesEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder9takeNodesEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void takeNodes(ExplodedNode /*P*/ N) {
    Frontier.erase(N);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::addNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 306,
   FQN="clang::ento::NodeBuilder::addNodes", NM="_ZN5clang4ento11NodeBuilder8addNodesERKNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder8addNodesERKNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void addNodes(final /*const*/ ExplodedNodeSet /*&*/ S) {
    Frontier.insert(S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::NodeBuilder::addNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 307,
   FQN="clang::ento::NodeBuilder::addNodes", NM="_ZN5clang4ento11NodeBuilder8addNodesEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento11NodeBuilder8addNodesEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void addNodes(ExplodedNode /*P*/ N) {
    Frontier.Add(N);
  }

  
  @Override public String toString() {
    return "" + "C=" + "[NodeBuilderContext]" // NOI18N
              + ", Finalized=" + Finalized // NOI18N
              + ", HasGeneratedNodes=" + HasGeneratedNodes // NOI18N
              + ", Frontier=" + Frontier; // NOI18N
  }
}
