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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 43,
 FQN="clang::ento::SubEngine", NM="_ZN5clang4ento9SubEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngineE")
//</editor-fold>
public abstract class SubEngine implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SubEngine.cpp", line = 14,
   FQN="clang::ento::SubEngine::anchor", NM="_ZN5clang4ento9SubEngine6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SubEngine.cpp -nm=_ZN5clang4ento9SubEngine6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::~SubEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 46,
   FQN="clang::ento::SubEngine::~SubEngine", NM="_ZN5clang4ento9SubEngineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngineD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::getInitialState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 48,
   FQN="clang::ento::SubEngine::getInitialState", NM="_ZN5clang4ento9SubEngine15getInitialStateEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine15getInitialStateEPKNS_15LocationContextE")
  //</editor-fold>
  public abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> getInitialState(/*const*/ LocationContext /*P*/ InitLoc)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::getAnalysisManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 50,
   FQN="clang::ento::SubEngine::getAnalysisManager", NM="_ZN5clang4ento9SubEngine18getAnalysisManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine18getAnalysisManagerEv")
  //</editor-fold>
  public abstract /*virtual*/ AnalysisManager /*&*/ getAnalysisManager()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::getStateManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 52,
   FQN="clang::ento::SubEngine::getStateManager", NM="_ZN5clang4ento9SubEngine15getStateManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine15getStateManagerEv")
  //</editor-fold>
  public abstract /*virtual*/ ProgramStateManager /*&*/ getStateManager()/* = 0*/;

  
  /// Called by CoreEngine. Used to generate new successor
  /// nodes by processing the 'effects' of a block-level statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processCFGElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 56,
   FQN="clang::ento::SubEngine::processCFGElement", NM="_ZN5clang4ento9SubEngine17processCFGElementENS_10CFGElementEPNS0_12ExplodedNodeEjPNS0_18NodeBuilderContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine17processCFGElementENS_10CFGElementEPNS0_12ExplodedNodeEjPNS0_18NodeBuilderContextE")
  //</editor-fold>
  public abstract /*virtual*/ void processCFGElement(/*const*/ CFGElement E, ExplodedNode /*P*/ Pred, 
                   /*uint*/int StmtIdx, NodeBuilderContext /*P*/ Ctx)/* = 0*/;

  
  /// Called by CoreEngine when it starts processing a CFGBlock.  The
  /// SubEngine is expected to populate dstNodes with new nodes representing
  /// updated analysis state, or generate no nodes at all if it doesn't.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processCFGBlockEntrance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 62,
   FQN="clang::ento::SubEngine::processCFGBlockEntrance", NM="_ZN5clang4ento9SubEngine23processCFGBlockEntranceERKNS_9BlockEdgeERNS0_20NodeBuilderWithSinksEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine23processCFGBlockEntranceERKNS_9BlockEdgeERNS0_20NodeBuilderWithSinksEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public abstract /*virtual*/ void processCFGBlockEntrance(final /*const*/ BlockEdge /*&*/ L, 
                         final NodeBuilderWithSinks /*&*/ nodeBuilder, 
                         ExplodedNode /*P*/ Pred)/* = 0*/;

  
  /// Called by CoreEngine.  Used to generate successor
  ///  nodes by processing the 'effects' of a branch condition.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processBranch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 68,
   FQN="clang::ento::SubEngine::processBranch", NM="_ZN5clang4ento9SubEngine13processBranchEPKNS_4StmtES4_RNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine13processBranchEPKNS_4StmtES4_RNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_")
  //</editor-fold>
  public abstract /*virtual*/ void processBranch(/*const*/ Stmt /*P*/ Condition, /*const*/ Stmt /*P*/ Term, 
               final NodeBuilderContext /*&*/ BuilderCtx, 
               ExplodedNode /*P*/ Pred, 
               final ExplodedNodeSet /*&*/ Dst, 
               /*const*/ CFGBlock /*P*/ DstT, 
               /*const*/ CFGBlock /*P*/ DstF)/* = 0*/;

  
  /// Called by CoreEngine.
  /// Used to generate successor nodes for temporary destructors depending
  /// on whether the corresponding constructor was visited.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processCleanupTemporaryBranch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 78,
   FQN="clang::ento::SubEngine::processCleanupTemporaryBranch", NM="_ZN5clang4ento9SubEngine29processCleanupTemporaryBranchEPKNS_20CXXBindTemporaryExprERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine29processCleanupTemporaryBranchEPKNS_20CXXBindTemporaryExprERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_")
  //</editor-fold>
  public abstract /*virtual*/ void processCleanupTemporaryBranch(/*const*/ CXXBindTemporaryExpr /*P*/ BTE, 
                               final NodeBuilderContext /*&*/ BldCtx, 
                               ExplodedNode /*P*/ Pred, 
                               final ExplodedNodeSet /*&*/ Dst, 
                               /*const*/ CFGBlock /*P*/ DstT, 
                               /*const*/ CFGBlock /*P*/ DstF)/* = 0*/;

  
  /// Called by CoreEngine.  Used to processing branching behavior
  /// at static initalizers.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processStaticInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 87,
   FQN="clang::ento::SubEngine::processStaticInitializer", NM="_ZN5clang4ento9SubEngine24processStaticInitializerEPKNS_8DeclStmtERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine24processStaticInitializerEPKNS_8DeclStmtERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_")
  //</editor-fold>
  public abstract /*virtual*/ void processStaticInitializer(/*const*/ DeclStmt /*P*/ DS, 
                          final NodeBuilderContext /*&*/ BuilderCtx, 
                          ExplodedNode /*P*/ Pred, 
                          final ExplodedNodeSet /*&*/ Dst, 
                          /*const*/ CFGBlock /*P*/ DstT, 
                          /*const*/ CFGBlock /*P*/ DstF)/* = 0*/;

  
  /// Called by CoreEngine.  Used to generate successor
  /// nodes by processing the 'effects' of a computed goto jump.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processIndirectGoto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 96,
   FQN="clang::ento::SubEngine::processIndirectGoto", NM="_ZN5clang4ento9SubEngine19processIndirectGotoERNS0_23IndirectGotoNodeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine19processIndirectGotoERNS0_23IndirectGotoNodeBuilderE")
  //</editor-fold>
  public abstract /*virtual*/ void processIndirectGoto(final IndirectGotoNodeBuilder /*&*/ builder)/* = 0*/;

  
  /// Called by CoreEngine.  Used to generate successor
  /// nodes by processing the 'effects' of a switch statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processSwitch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 100,
   FQN="clang::ento::SubEngine::processSwitch", NM="_ZN5clang4ento9SubEngine13processSwitchERNS0_17SwitchNodeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine13processSwitchERNS0_17SwitchNodeBuilderE")
  //</editor-fold>
  public abstract /*virtual*/ void processSwitch(final SwitchNodeBuilder /*&*/ builder)/* = 0*/;

  
  /// Called by CoreEngine.  Used to notify checkers that processing a
  /// function has begun. Called for both inlined and and top-level functions.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processBeginOfFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 104,
   FQN="clang::ento::SubEngine::processBeginOfFunction", NM="_ZN5clang4ento9SubEngine22processBeginOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS_9BlockEdgeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine22processBeginOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS_9BlockEdgeE")
  //</editor-fold>
  public abstract /*virtual*/ void processBeginOfFunction(final NodeBuilderContext /*&*/ BC, 
                        ExplodedNode /*P*/ Pred, 
                        final ExplodedNodeSet /*&*/ Dst, 
                        final /*const*/ BlockEdge /*&*/ L)/* = 0*/;

  
  /// Called by CoreEngine.  Used to notify checkers that processing a
  /// function has ended. Called for both inlined and and top-level functions.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processEndOfFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 111,
   FQN="clang::ento::SubEngine::processEndOfFunction", NM="_ZN5clang4ento9SubEngine20processEndOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine20processEndOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public abstract /*virtual*/ void processEndOfFunction(final NodeBuilderContext /*&*/ BC, 
                      ExplodedNode /*P*/ Pred)/* = 0*/;

  
  // Generate the entry node of the callee.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processCallEnter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 115,
   FQN="clang::ento::SubEngine::processCallEnter", NM="_ZN5clang4ento9SubEngine16processCallEnterERNS0_18NodeBuilderContextENS_9CallEnterEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine16processCallEnterERNS0_18NodeBuilderContextENS_9CallEnterEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public abstract /*virtual*/ void processCallEnter(final NodeBuilderContext /*&*/ BC, CallEnter CE, 
                  ExplodedNode /*P*/ Pred)/* = 0*/;

  
  // Generate the first post callsite node.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processCallExit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 119,
   FQN="clang::ento::SubEngine::processCallExit", NM="_ZN5clang4ento9SubEngine15processCallExitEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine15processCallExitEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public abstract /*virtual*/ void processCallExit(ExplodedNode /*P*/ Pred)/* = 0*/;

  
  /// Called by ConstraintManager. Used to call checker-specific
  /// logic for handling assumptions on symbolic values.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processAssume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 123,
   FQN="clang::ento::SubEngine::processAssume", NM="_ZN5clang4ento9SubEngine13processAssumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine13processAssumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEb")
  //</editor-fold>
  public abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> processAssume(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
               SVal cond, boolean assumption)/* = 0*/;

  
  /// wantsRegionChangeUpdate - Called by ProgramStateManager to determine if a
  ///  region change should trigger a processRegionChanges update.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::wantsRegionChangeUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 128,
   FQN="clang::ento::SubEngine::wantsRegionChangeUpdate", NM="_ZN5clang4ento9SubEngine23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public abstract /*virtual*/ boolean wantsRegionChangeUpdate(IntrusiveRefCntPtr</*const*/ ProgramState> state)/* = 0*/;

  
  /// processRegionChanges - Called by ProgramStateManager whenever a change is
  /// made to the store. Used to update checkers that track region values.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processRegionChanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 132,
   FQN="clang::ento::SubEngine::processRegionChanges", NM="_ZN5clang4ento9SubEngine20processRegionChangesEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine20processRegionChangesEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventE")
  //</editor-fold>
  public abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> processRegionChanges(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                      /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ invalidated, 
                      ArrayRef</*const*/ MemRegion /*P*/ > ExplicitRegions, 
                      ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                      /*const*/ CallEvent /*P*/ Call)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processRegionChange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 140,
   FQN="clang::ento::SubEngine::processRegionChange", NM="_ZN5clang4ento9SubEngine19processRegionChangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine19processRegionChangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> processRegionChange(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                     /*const*/ MemRegion /*P*/ MR) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(processRegionChanges($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), (/*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null, new ArrayRef</*const*/ MemRegion /*P*/ >(MR, true), new ArrayRef</*const*/ MemRegion /*P*/ >(MR, true), (/*const*/ CallEvent /*P*/ )null));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processPointerEscapedOnBind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 146,
   FQN="clang::ento::SubEngine::processPointerEscapedOnBind", NM="_ZN5clang4ento9SubEngine27processPointerEscapedOnBindEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine27processPointerEscapedOnBindEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValES7_")
  //</editor-fold>
  public abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> processPointerEscapedOnBind(IntrusiveRefCntPtr</*const*/ ProgramState> State, SVal Loc, SVal Val)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::notifyCheckersOfPointerEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 149,
   FQN="clang::ento::SubEngine::notifyCheckersOfPointerEscape", NM="_ZN5clang4ento9SubEngine29notifyCheckersOfPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventERNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine29notifyCheckersOfPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventERNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  public abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> notifyCheckersOfPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                               /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ Invalidated, 
                               ArrayRef</*const*/ MemRegion /*P*/ > ExplicitRegions, 
                               ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                               /*const*/ CallEvent /*P*/ Call, 
                               final RegionAndSymbolInvalidationTraits /*&*/ HTraits)/* = 0*/;

  
  /// printState - Called by ProgramStateManager to print checker-specific data.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::printState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 158,
   FQN="clang::ento::SubEngine::printState", NM="_ZN5clang4ento9SubEngine10printStateERN4llvm11raw_ostreamENS2_18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKcSA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine10printStateERN4llvm11raw_ostreamENS2_18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKcSA_")
  //</editor-fold>
  public abstract /*virtual*/ void printState(final raw_ostream /*&*/ Out, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            /*const*/char$ptr/*char P*/ NL, /*const*/char$ptr/*char P*/ Sep)/* = 0*/;

  
  /// Called by CoreEngine when the analysis worklist is either empty or the
  //  maximum number of analysis steps have been reached.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::processEndWorklist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 163,
   FQN="clang::ento::SubEngine::processEndWorklist", NM="_ZN5clang4ento9SubEngine18processEndWorklistEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngine18processEndWorklistEb")
  //</editor-fold>
  public abstract /*virtual*/ void processEndWorklist(boolean hasWorkRemaining)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubEngine::SubEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SubEngine.h", line = 43,
   FQN="clang::ento::SubEngine::SubEngine", NM="_ZN5clang4ento9SubEngineC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento9SubEngineC1Ev")
  //</editor-fold>
  public /*inline*/ SubEngine() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
