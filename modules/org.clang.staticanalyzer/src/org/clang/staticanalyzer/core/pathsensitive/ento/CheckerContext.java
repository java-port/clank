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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.lex.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 70,
 FQN="clang::ento::CheckerContext", NM="_ZN5clang4ento14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContextE")
//</editor-fold>
public class CheckerContext {
  private final ExprEngine /*&*/ Eng;
  /// The current exploded(symbolic execution) graph node.
  private ExplodedNode /*P*/ Pred;
  /// The flag is true if the (state of the execution) has been modified
  /// by the checker using this context. For example, a new transition has been
  /// added or a bug report issued.
  private boolean Changed;
  /// The tagged location, which is used to generate all new nodes.
  private /*const*/ ProgramPoint Location;
  private final NodeBuilder /*&*/ NB;
/*public:*/
  /// If we are post visiting a call, this flag will be set if the
  /// call was inlined.  In all other cases it will be false.
  public /*const*/boolean wasInlined;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::CheckerContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 87,
   FQN="clang::ento::CheckerContext::CheckerContext", NM="_ZN5clang4ento14CheckerContextC1ERNS0_11NodeBuilderERNS0_10ExprEngineEPNS0_12ExplodedNodeERKNS_12ProgramPointEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContextC1ERNS0_11NodeBuilderERNS0_10ExprEngineEPNS0_12ExplodedNodeERKNS_12ProgramPointEb")
  //</editor-fold>
  public CheckerContext(final NodeBuilder /*&*/ builder, 
      final ExprEngine /*&*/ eng, 
      ExplodedNode /*P*/ pred, 
      final /*const*/ ProgramPoint /*&*/ loc) {
    this(builder, 
      eng, 
      pred, 
      loc, 
      false);
  }
  public CheckerContext(final NodeBuilder /*&*/ builder, 
      final ExprEngine /*&*/ eng, 
      ExplodedNode /*P*/ pred, 
      final /*const*/ ProgramPoint /*&*/ loc, 
      boolean wasInlined/*= false*/) {
    // : Eng(eng), Pred(pred), Changed(false), Location(loc), NB(builder), wasInlined(wasInlined) 
    //START JInit
    this./*&*/Eng=/*&*/eng;
    this.Pred = pred;
    this.Changed = false;
    this.Location = new ProgramPoint(loc);
    this./*&*/NB=/*&*/builder;
    this.wasInlined = wasInlined;
    //END JInit
    assert (Pred.getState().$bool()) : "We should not call the checkers on an empty state.";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getAnalysisManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 102,
   FQN="clang::ento::CheckerContext::getAnalysisManager", NM="_ZN5clang4ento14CheckerContext18getAnalysisManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext18getAnalysisManagerEv")
  //</editor-fold>
  public AnalysisManager /*&*/ getAnalysisManager() {
    return Eng.getAnalysisManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getConstraintManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 106,
   FQN="clang::ento::CheckerContext::getConstraintManager", NM="_ZN5clang4ento14CheckerContext20getConstraintManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext20getConstraintManagerEv")
  //</editor-fold>
  public ConstraintManager /*&*/ getConstraintManager() {
    return Eng.getConstraintManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getStoreManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 110,
   FQN="clang::ento::CheckerContext::getStoreManager", NM="_ZN5clang4ento14CheckerContext15getStoreManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext15getStoreManagerEv")
  //</editor-fold>
  public StoreManager /*&*/ getStoreManager() {
    return Eng.getStoreManager();
  }

  
  /// \brief Returns the previous node in the exploded graph, which includes
  /// the state of the program before the checker ran. Note, checkers should
  /// not retain the node in their state since the nodes might get invalidated.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getPredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 117,
   FQN="clang::ento::CheckerContext::getPredecessor", NM="_ZN5clang4ento14CheckerContext14getPredecessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext14getPredecessorEv")
  //</editor-fold>
  public ExplodedNode /*P*/ getPredecessor() {
    return Pred;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 118,
   FQN="clang::ento::CheckerContext::getState", NM="_ZNK5clang4ento14CheckerContext8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext8getStateEv")
  //</editor-fold>
  public /*const*/ IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ getState() /*const*/ {
    return Pred.getState();
  }

  
  /// \brief Check if the checker changed the state of the execution; ex: added
  /// a new transition or a bug report.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::isDifferent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 122,
   FQN="clang::ento::CheckerContext::isDifferent", NM="_ZN5clang4ento14CheckerContext11isDifferentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext11isDifferentEv")
  //</editor-fold>
  public boolean isDifferent() {
    return Changed;
  }

  
  /// \brief Returns the number of times the current block has been visited
  /// along the analyzed path.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::blockCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 126,
   FQN="clang::ento::CheckerContext::blockCount", NM="_ZNK5clang4ento14CheckerContext10blockCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext10blockCountEv")
  //</editor-fold>
  public /*uint*/int blockCount() /*const*/ {
    return NB.getContext().blockCount();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 130,
   FQN="clang::ento::CheckerContext::getASTContext", NM="_ZN5clang4ento14CheckerContext13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() {
    return Eng.getContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 134,
   FQN="clang::ento::CheckerContext::getLangOpts", NM="_ZNK5clang4ento14CheckerContext11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return Eng.getContext().getLangOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 138,
   FQN="clang::ento::CheckerContext::getLocationContext", NM="_ZNK5clang4ento14CheckerContext18getLocationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext18getLocationContextEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getLocationContext() /*const*/ {
    return Pred.getLocationContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getStackFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 142,
   FQN="clang::ento::CheckerContext::getStackFrame", NM="_ZNK5clang4ento14CheckerContext13getStackFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext13getStackFrameEv")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getStackFrame() /*const*/ {
    return Pred.getStackFrame();
  }

  
  /// Return true if the current LocationContext has no caller context.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::inTopFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 147,
   FQN="clang::ento::CheckerContext::inTopFrame", NM="_ZNK5clang4ento14CheckerContext10inTopFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext10inTopFrameEv")
  //</editor-fold>
  public boolean inTopFrame() /*const*/ {
    return getLocationContext().inTopFrame();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getBugReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 149,
   FQN="clang::ento::CheckerContext::getBugReporter", NM="_ZN5clang4ento14CheckerContext14getBugReporterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext14getBugReporterEv")
  //</editor-fold>
  public BugReporter /*&*/ getBugReporter() {
    return Eng.getBugReporter();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 153,
   FQN="clang::ento::CheckerContext::getSourceManager", NM="_ZN5clang4ento14CheckerContext16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() {
    return getBugReporter().getSourceManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getSValBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 157,
   FQN="clang::ento::CheckerContext::getSValBuilder", NM="_ZN5clang4ento14CheckerContext14getSValBuilderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext14getSValBuilderEv")
  //</editor-fold>
  public SValBuilder /*&*/ getSValBuilder() {
    return Eng.getSValBuilder();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getSymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 161,
   FQN="clang::ento::CheckerContext::getSymbolManager", NM="_ZN5clang4ento14CheckerContext16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext16getSymbolManagerEv")
  //</editor-fold>
  public SymbolManager /*&*/ getSymbolManager() {
    return getSValBuilder().getSymbolManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::isObjCGCEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 165,
   FQN="clang::ento::CheckerContext::isObjCGCEnabled", NM="_ZNK5clang4ento14CheckerContext15isObjCGCEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext15isObjCGCEnabledEv")
  //</editor-fold>
  public boolean isObjCGCEnabled() /*const*/ {
    return Eng.isObjCGCEnabled();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getStateManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 169,
   FQN="clang::ento::CheckerContext::getStateManager", NM="_ZN5clang4ento14CheckerContext15getStateManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext15getStateManagerEv")
  //</editor-fold>
  public ProgramStateManager /*&*/ getStateManager() {
    return Eng.getStateManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getCurrentAnalysisDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 173,
   FQN="clang::ento::CheckerContext::getCurrentAnalysisDeclContext", NM="_ZNK5clang4ento14CheckerContext29getCurrentAnalysisDeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext29getCurrentAnalysisDeclContextEv")
  //</editor-fold>
  public AnalysisDeclContext /*P*/ getCurrentAnalysisDeclContext() /*const*/ {
    return Pred.getLocationContext().getAnalysisDeclContext();
  }

  
  /// \brief Get the blockID.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getBlockID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 178,
   FQN="clang::ento::CheckerContext::getBlockID", NM="_ZNK5clang4ento14CheckerContext10getBlockIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext10getBlockIDEv")
  //</editor-fold>
  public /*uint*/int getBlockID() /*const*/ {
    return NB.getContext().getBlock().getBlockID();
  }

  
  /// \brief If the given node corresponds to a PostStore program point,
  /// retrieve the location region as it was uttered in the code.
  ///
  /// This utility can be useful for generating extensive diagnostics, for
  /// example, for finding variables that the given symbol was assigned to.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getLocationRegionIfPostStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 187,
   FQN="clang::ento::CheckerContext::getLocationRegionIfPostStore", NM="_ZN5clang4ento14CheckerContext28getLocationRegionIfPostStoreEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext28getLocationRegionIfPostStoreEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public static /*const*/ MemRegion /*P*/ getLocationRegionIfPostStore(/*const*/ ExplodedNode /*P*/ N) {
    ProgramPoint L = N.getLocation();
    {
      Optional<PostStore> PSL = L.getAs(PostStore.class);
      if (PSL.$bool()) {
        return reinterpret_cast(/*const*/ MemRegion /*P*/ .class, PSL.$arrow().getLocationValue());
      }
    }
    return null;
  }

  
  /// \brief Get the value of arbitrary expressions at this point in the path.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 195,
   FQN="clang::ento::CheckerContext::getSVal", NM="_ZNK5clang4ento14CheckerContext7getSValEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext7getSValEPKNS_4StmtE")
  //</editor-fold>
  public SVal getSVal(/*const*/ Stmt /*P*/ S) /*const*/ {
    return getState().$arrow().getSVal(S, getLocationContext());
  }

  
  /// \brief Generates a new transition in the program state graph
  /// (ExplodedGraph). Uses the default CheckerContext predecessor node.
  ///
  /// @param State The state of the generated node. If not specified, the state
  ///        will not be changed, but the new node will have the checker's tag.
  /// @param Tag The tag is used to uniquely identify the creation site. If no
  ///        tag is specified, a default tag, unique to the given checker,
  ///        will be used. Tags are used to prevent states generated at
  ///        different sites from caching out.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::addTransition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 208,
   FQN="clang::ento::CheckerContext::addTransition", NM="_ZN5clang4ento14CheckerContext13addTransitionEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext13addTransitionEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public ExplodedNode /*P*/ addTransition() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null)), 
               (/*const*/ ProgramPointTag /*P*/ )null));
    } finally {
      $c$.$destroy();
    }
  }
  public ExplodedNode /*P*/ addTransition(IntrusiveRefCntPtr</*const*/ ProgramState> State/*= $c$.track(null)*/) {
    return addTransition(State, 
               (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public ExplodedNode /*P*/ addTransition(IntrusiveRefCntPtr</*const*/ ProgramState> State/*= $c$.track(null)*/, 
               /*const*/ ProgramPointTag /*P*/ Tag/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(addTransitionImpl($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State.$bool() ? State : getState())), false, (ExplodedNode /*P*/ )null, Tag));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Generates a new transition with the given predecessor.
  /// Allows checkers to generate a chain of nodes.
  ///
  /// @param State The state of the generated node.
  /// @param Pred The transition will be generated from the specified Pred node
  ///             to the newly generated node.
  /// @param Tag The tag to uniquely identify the creation site.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::addTransition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 220,
   FQN="clang::ento::CheckerContext::addTransition", NM="_ZN5clang4ento14CheckerContext13addTransitionEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext13addTransitionEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public ExplodedNode /*P*/ addTransition(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
               ExplodedNode /*P*/ Pred) {
    return addTransition(State, 
               Pred, 
               (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public ExplodedNode /*P*/ addTransition(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
               ExplodedNode /*P*/ Pred, 
               /*const*/ ProgramPointTag /*P*/ Tag/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(addTransitionImpl($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), false, Pred, Tag));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Generate a sink node. Generating a sink stops exploration of the
  /// given path. To create a sink node for the purpose of reporting an error,
  /// checkers should use generateErrorNode() instead.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::generateSink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 229,
   FQN="clang::ento::CheckerContext::generateSink", NM="_ZN5clang4ento14CheckerContext12generateSinkEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext12generateSinkEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPNS0_12ExplodedNodeEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateSink(IntrusiveRefCntPtr</*const*/ ProgramState> State, ExplodedNode /*P*/ Pred) {
    return generateSink(State, Pred, 
              (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public ExplodedNode /*P*/ generateSink(IntrusiveRefCntPtr</*const*/ ProgramState> State, ExplodedNode /*P*/ Pred, 
              /*const*/ ProgramPointTag /*P*/ Tag/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(addTransitionImpl($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State.$bool() ? State : getState())), true, Pred, Tag));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Generate a transition to a node that will be used to report
  /// an error. This node will be a sink. That is, it will stop exploration of
  /// the given path.
  ///
  /// @param State The state of the generated node.
  /// @param Tag The tag to uniquely identify the creation site. If null,
  ///        the default tag for the checker will be used.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::generateErrorNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 241,
   FQN="clang::ento::CheckerContext::generateErrorNode", NM="_ZN5clang4ento14CheckerContext17generateErrorNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext17generateErrorNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateErrorNode() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null)), 
                   (/*const*/ ProgramPointTag /*P*/ )null));
    } finally {
      $c$.$destroy();
    }
  }
  public ExplodedNode /*P*/ generateErrorNode(IntrusiveRefCntPtr</*const*/ ProgramState> State/*= $c$.track(null)*/) {
    return generateErrorNode(State, 
                   (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public ExplodedNode /*P*/ generateErrorNode(IntrusiveRefCntPtr</*const*/ ProgramState> State/*= $c$.track(null)*/, 
                   /*const*/ ProgramPointTag /*P*/ Tag/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Pred, 
          ((Tag != null) ? Tag : Location.getTag())));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Generate a transition to a node that will be used to report
  /// an error. This node will not be a sink. That is, exploration will
  /// continue along this path.
  ///
  /// @param State The state of the generated node.
  /// @param Tag The tag to uniquely identify the creation site. If null,
  ///        the default tag for the checker will be used.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::generateNonFatalErrorNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 254,
   FQN="clang::ento::CheckerContext::generateNonFatalErrorNode", NM="_ZN5clang4ento14CheckerContext25generateNonFatalErrorNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext25generateNonFatalErrorNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateNonFatalErrorNode() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null)), 
                           (/*const*/ ProgramPointTag /*P*/ )null));
    } finally {
      $c$.$destroy();
    }
  }
  public ExplodedNode /*P*/ generateNonFatalErrorNode(IntrusiveRefCntPtr</*const*/ ProgramState> State/*= $c$.track(null)*/) {
    return generateNonFatalErrorNode(State, 
                           (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public ExplodedNode /*P*/ generateNonFatalErrorNode(IntrusiveRefCntPtr</*const*/ ProgramState> State/*= $c$.track(null)*/, 
                           /*const*/ ProgramPointTag /*P*/ Tag/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), ((Tag != null) ? Tag : Location.getTag())));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Emit the diagnostics report.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::emitReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 261,
   FQN="clang::ento::CheckerContext::emitReport", NM="_ZN5clang4ento14CheckerContext10emitReportESt10unique_ptrINS0_9BugReportESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext10emitReportESt10unique_ptrINS0_9BugReportESt14default_deleteIS3_EE")
  //</editor-fold>
  public void emitReport(std.unique_ptr<BugReport> R) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Changed = true;
      Eng.getBugReporter().emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Returns the word that should be used to refer to the declaration
  /// in the report.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getDeclDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp", line = 38,
   FQN="clang::ento::CheckerContext::getDeclDescription", NM="_ZN5clang4ento14CheckerContext18getDeclDescriptionEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext18getDeclDescriptionEPKNS_4DeclE")
  //</editor-fold>
  public StringRef getDeclDescription(/*const*/ Decl /*P*/ D) {
    if (isa_ObjCMethodDecl(D) || isa_CXXMethodDecl(D)) {
      return new StringRef(/*KEEP_STR*/"method");
    }
    if (isa_BlockDecl(D)) {
      return new StringRef(/*KEEP_STR*/"anonymous block");
    }
    return new StringRef(/*KEEP_STR*/"function");
  }

  
  /// \brief Get the declaration of the called function (path-sensitive).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getCalleeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp", line = 22,
   FQN="clang::ento::CheckerContext::getCalleeDecl", NM="_ZNK5clang4ento14CheckerContext13getCalleeDeclEPKNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext13getCalleeDeclEPKNS_8CallExprE")
  //</editor-fold>
  public /*const*/ FunctionDecl /*P*/ getCalleeDecl(/*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(getState());
      /*const*/ Expr /*P*/ Callee = CE.getCallee$Const();
      SVal L = State.$arrow().getSVal(Callee, Pred.getLocationContext());
      return L.getAsFunctionDecl();
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  
  /// \brief Get the name of the called function (path-sensitive).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getCalleeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp", line = 29,
   FQN="clang::ento::CheckerContext::getCalleeName", NM="_ZNK5clang4ento14CheckerContext13getCalleeNameEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext13getCalleeNameEPKNS_12FunctionDeclE")
  //</editor-fold>
  public StringRef getCalleeName(/*const*/ FunctionDecl /*P*/ FunDecl) /*const*/ {
    if (!(FunDecl != null)) {
      return new StringRef();
    }
    IdentifierInfo /*P*/ funI = FunDecl.getIdentifier();
    if (!(funI != null)) {
      return new StringRef();
    }
    return funI.getName();
  }

  
  /// \brief Get the identifier of the called function (path-sensitive).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getCalleeIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 277,
   FQN="clang::ento::CheckerContext::getCalleeIdentifier", NM="_ZNK5clang4ento14CheckerContext19getCalleeIdentifierEPKNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext19getCalleeIdentifierEPKNS_8CallExprE")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getCalleeIdentifier(/*const*/ CallExpr /*P*/ CE) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FunDecl = getCalleeDecl(CE);
    if ((FunDecl != null)) {
      return FunDecl.getIdentifier();
    } else {
      return null;
    }
  }

  
  /// \brief Get the name of the called function (path-sensitive).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getCalleeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 286,
   FQN="clang::ento::CheckerContext::getCalleeName", NM="_ZNK5clang4ento14CheckerContext13getCalleeNameEPKNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZNK5clang4ento14CheckerContext13getCalleeNameEPKNS_8CallExprE")
  //</editor-fold>
  public StringRef getCalleeName(/*const*/ CallExpr /*P*/ CE) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FunDecl = getCalleeDecl(CE);
    return getCalleeName(FunDecl);
  }

  
  /// \brief Returns true if the callee is an externally-visible function in the
  /// top-level namespace, such as \c malloc.
  ///
  /// If a name is provided, the function must additionally match the given
  /// name.
  ///
  /// Note that this deliberately excludes C++ library functions in the \c std
  /// namespace, but will include C library functions accessed through the
  /// \c std namespace. This also does not check if the function is declared
  /// as 'extern "C"', or if it uses C++ name mangling.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::isCLibraryFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp", line = 46,
   FQN="clang::ento::CheckerContext::isCLibraryFunction", NM="_ZN5clang4ento14CheckerContext18isCLibraryFunctionEPKNS_12FunctionDeclEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext18isCLibraryFunctionEPKNS_12FunctionDeclEN4llvm9StringRefE")
  //</editor-fold>
  public static boolean isCLibraryFunction(/*const*/ FunctionDecl /*P*/ FD) {
    return isCLibraryFunction(FD, 
                    new StringRef());
  }
  public static boolean isCLibraryFunction(/*const*/ FunctionDecl /*P*/ FD, 
                    StringRef Name/*= StringRef()*/) {
    // To avoid false positives (Ex: finding user defined functions with
    // similar names), only perform fuzzy name matching when it's a builtin.
    // Using a string compare is slow, we might want to switch on BuiltinID here.
    /*uint*/int BId = FD.getBuiltinID();
    if (BId != 0) {
      if (Name.empty()) {
        return true;
      }
      StringRef BName = new StringRef(FD.getASTContext().BuiltinInfo.getName(BId));
      if (BName.find(/*NO_COPY*/Name) != StringRef.npos) {
        return true;
      }
    }
    
    /*const*/ IdentifierInfo /*P*/ II = FD.getIdentifier();
    // If this is a special C++ name without IdentifierInfo, it can't be a
    // C library function.
    if (!(II != null)) {
      return false;
    }
    
    // Look through 'extern "C"' and anything similar invented in the future.
    // If this function is not in TU directly, it is not a C library function.
    if (!FD.getDeclContext$Const().getRedeclContext$Const().isTranslationUnit()) {
      return false;
    }
    
    // If this function is not externally visible, it is not a C library function.
    // Note that we make an exception for inline functions, which may be
    // declared in header files without external linkage.
    if (!FD.isInlined() && !FD.isExternallyVisible()) {
      return false;
    }
    if (Name.empty()) {
      return true;
    }
    
    StringRef FName = II.getName();
    if (FName.equals(/*NO_COPY*/Name)) {
      return true;
    }
    if (FName.startswith(/*STRINGREF_STR*/"__inline") && (FName.find(/*NO_COPY*/Name) != StringRef.npos)) {
      return true;
    }
    if (FName.startswith(/*STRINGREF_STR*/"__") && FName.endswith(/*STRINGREF_STR*/"_chk")
       && FName.find(/*NO_COPY*/Name) != StringRef.npos) {
      return true;
    }
    
    return false;
  }

  
  /// \brief Depending on wither the location corresponds to a macro, return 
  /// either the macro name or the token spelling.
  ///
  /// This could be useful when checkers' logic depends on whether a function
  /// is called with a given macro argument. For example:
  ///   s = socket(AF_INET,..)
  /// If AF_INET is a macro, the result should be treated as a source of taint.
  ///
  /// \sa clang::Lexer::getSpelling(), clang::Lexer::getImmediateMacroName().
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::getMacroNameOrSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp", line = 94,
   FQN="clang::ento::CheckerContext::getMacroNameOrSpelling", NM="_ZN5clang4ento14CheckerContext22getMacroNameOrSpellingERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext22getMacroNameOrSpellingERNS_14SourceLocationE")
  //</editor-fold>
  public StringRef getMacroNameOrSpelling(final SourceLocation /*&*/ Loc) {
    if (Loc.isMacroID()) {
      return Lexer.getImmediateMacroName(/*NO_COPY*/Loc, getSourceManager(), 
          getLangOpts());
    }
    SmallString buf/*J*/= new SmallString(16);
    return Lexer.getSpelling(/*NO_COPY*/Loc, buf, getSourceManager(), getLangOpts());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerContext::addTransitionImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerContext.h", line = 316,
   FQN="clang::ento::CheckerContext::addTransitionImpl", NM="_ZN5clang4ento14CheckerContext17addTransitionImplEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEbPNS0_12ExplodedNodeEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerContext.cpp -nm=_ZN5clang4ento14CheckerContext17addTransitionImplEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEbPNS0_12ExplodedNodeEPKNS_15ProgramPointTagE")
  //</editor-fold>
  private ExplodedNode /*P*/ addTransitionImpl(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                   boolean MarkAsSink) {
    return addTransitionImpl(State, 
                   MarkAsSink, 
                   (ExplodedNode /*P*/ )null, 
                   (/*const*/ ProgramPointTag /*P*/ )null);
  }
  private ExplodedNode /*P*/ addTransitionImpl(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                   boolean MarkAsSink, 
                   ExplodedNode /*P*/ P/*= null*/) {
    return addTransitionImpl(State, 
                   MarkAsSink, 
                   P, 
                   (/*const*/ ProgramPointTag /*P*/ )null);
  }
  private ExplodedNode /*P*/ addTransitionImpl(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                   boolean MarkAsSink, 
                   ExplodedNode /*P*/ P/*= null*/, 
                   /*const*/ ProgramPointTag /*P*/ Tag/*= null*/) {
    // The analyzer may stop exploring if it sees a state it has previously
    // visited ("cache out"). The early return here is a defensive check to
    // prevent accidental caching out by checker API clients. Unless there is a
    // tag or the client checker has requested that the generated node be
    // marked as a sink, we assume that a client requesting a transition to a
    // state that is the same as the predecessor state has made a mistake. We
    // return the predecessor rather than cache out.
    //
    // TODO: We could potentially change the return to an assertion to alert
    // clients to their mistake, but several checkers (including
    // DereferenceChecker, CallAndMessageChecker, and DynamicTypePropagation)
    // rely upon the defensive behavior and would need to be updated.
    if (!State.$bool() || ($eq_IntrusiveRefCntPtr(State, Pred.getState()) && !(Tag != null) && !MarkAsSink)) {
      return Pred;
    }
    
    Changed = true;
    final /*const*/ ProgramPoint /*&*/ LocalLoc = ((Tag != null) ? Location.withTag(Tag) : new ProgramPoint(Location));
    if (!(P != null)) {
      P = Pred;
    }
    
    ExplodedNode /*P*/ node;
    if (MarkAsSink) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(node = NB.generateSink(LocalLoc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), P));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(node = NB.generateNode(LocalLoc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), P));
      } finally {
        $c$.$destroy();
      }
    }
    return node;
  }

  
  @Override public String toString() {
    return "" + "Eng=" + "[ExprEngine]" // NOI18N
              + ", Pred=" + Pred // NOI18N
              + ", Changed=" + Changed // NOI18N
              + ", Location=" + Location // NOI18N
              + ", NB=" + "[NodeBuilder]" // NOI18N
              + ", wasInlined=" + wasInlined; // NOI18N
  }
}
