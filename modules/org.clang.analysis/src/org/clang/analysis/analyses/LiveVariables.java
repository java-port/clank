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

package org.clang.analysis.analyses;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.impl.LiveVariablesStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::LiveVariables">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 30,
 FQN="clang::LiveVariables", NM="_ZN5clang13LiveVariablesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariablesE")
//</editor-fold>
public class LiveVariables extends /*public*/ ManagedAnalysis implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 32,
   FQN="clang::LiveVariables::LivenessValues", NM="_ZN5clang13LiveVariables14LivenessValuesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables14LivenessValuesE")
  //</editor-fold>
  public static class LivenessValues implements Destructors.ClassWithDestructor, NativeCloneable<LivenessValues> {
  /*public:*/
    
    public ImmutableSetPtr</*const*/ Stmt /*P*/ > liveStmts;
    public ImmutableSetPtr</*const*/ VarDecl /*P*/ > liveDecls;
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::equals">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 165,
     FQN="clang::LiveVariables::LivenessValues::equals", NM="_ZNK5clang13LiveVariables14LivenessValues6equalsERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZNK5clang13LiveVariables14LivenessValues6equalsERKS1_")
    //</editor-fold>
    public boolean equals(final /*const*/ LivenessValues /*&*/ V) /*const*/ {
      return liveStmts.$eq(V.liveStmts) && liveDecls.$eq(V.liveDecls);
    }


    
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::LivenessValues">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 40,
     FQN="clang::LiveVariables::LivenessValues::LivenessValues", NM="_ZN5clang13LiveVariables14LivenessValuesC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables14LivenessValuesC1Ev")
    //</editor-fold>
    public LivenessValues() {
      // : liveStmts(null), liveDecls(null) 
      //START JInit
      this.liveStmts = new ImmutableSetPtr</*const*/ Stmt /*P*/ >((ImutAVLTreePtrBoolPtr</*const*/ Stmt, Stmt> /*P*/ )null);
      this.liveDecls = new ImmutableSetPtr</*const*/ VarDecl /*P*/ >((ImutAVLTreePtrBoolPtr</*const*/ VarDecl, VarDecl> /*P*/ ) null);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::LivenessValues">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 43,
     FQN="clang::LiveVariables::LivenessValues::LivenessValues", NM="_ZN5clang13LiveVariables14LivenessValuesC1EN4llvm12ImmutableSetIPKNS_4StmtENS2_17ImutContainerInfoIS6_EEEENS3_IPKNS_7VarDeclENS7_ISC_EEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables14LivenessValuesC1EN4llvm12ImmutableSetIPKNS_4StmtENS2_17ImutContainerInfoIS6_EEEENS3_IPKNS_7VarDeclENS7_ISC_EEEE")
    //</editor-fold>
    public LivenessValues(ImmutableSetPtr</*const*/ Stmt /*P*/ > LiveStmts, 
        ImmutableSetPtr</*const*/ VarDecl /*P*/ > LiveDecls) {
      // : liveStmts(LiveStmts), liveDecls(LiveDecls) 
      //START JInit
      this.liveStmts = new ImmutableSetPtr</*const*/ Stmt /*P*/ >(LiveStmts);
      this.liveDecls = new ImmutableSetPtr</*const*/ VarDecl /*P*/ >(LiveDecls);
      //END JInit
    }

    
    //===----------------------------------------------------------------------===//
    // Operations and queries on LivenessValues.
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::isLive">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 119,
     FQN="clang::LiveVariables::LivenessValues::isLive", NM="_ZNK5clang13LiveVariables14LivenessValues6isLiveEPKNS_4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZNK5clang13LiveVariables14LivenessValues6isLiveEPKNS_4StmtE")
    //</editor-fold>
    public boolean isLive(/*const*/ Stmt /*P*/ S) /*const*/ {
      return liveStmts.contains(S);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::isLive">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 123,
     FQN="clang::LiveVariables::LivenessValues::isLive", NM="_ZNK5clang13LiveVariables14LivenessValues6isLiveEPKNS_7VarDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZNK5clang13LiveVariables14LivenessValues6isLiveEPKNS_7VarDeclE")
    //</editor-fold>
    public boolean isLive(/*const*/ VarDecl /*P*/ D) /*const*/ {
      return liveDecls.contains(D);
    }


    
    /*friend  class LiveVariables*/
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::~LivenessValues">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 32,
     FQN="clang::LiveVariables::LivenessValues::~LivenessValues", NM="_ZN5clang13LiveVariables14LivenessValuesD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables14LivenessValuesD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      liveDecls.$destroy();
      liveStmts.$destroy();
      //END JDestroy
    }



    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::LivenessValues">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 32,
     FQN="clang::LiveVariables::LivenessValues::LivenessValues", NM="_ZN5clang13LiveVariables14LivenessValuesC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables14LivenessValuesC1EOS1_")
    //</editor-fold>
    public /*inline*/ LivenessValues(JD$Move _dparam, final LivenessValues /*&&*/$Prm0) {
      // : liveStmts(static_cast<LivenessValues &&>().liveStmts), liveDecls(static_cast<LivenessValues &&>().liveDecls) 
      //START JInit
      this.liveStmts = new ImmutableSetPtr</*const*/ Stmt /*P*/ >($Prm0.liveStmts);
      this.liveDecls = new ImmutableSetPtr</*const*/ VarDecl /*P*/ >($Prm0.liveDecls);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 32,
     FQN="clang::LiveVariables::LivenessValues::operator=", NM="_ZN5clang13LiveVariables14LivenessValuesaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables14LivenessValuesaSEOS1_")
    //</editor-fold>
    public /*inline*/ LivenessValues /*&*/ $assignMove(final LivenessValues /*&&*/$Prm0) {
      this.liveStmts.$assign($Prm0.liveStmts);
      this.liveDecls.$assign($Prm0.liveDecls);
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::LivenessValues">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 32,
     FQN="clang::LiveVariables::LivenessValues::LivenessValues", NM="_ZN5clang13LiveVariables14LivenessValuesC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables14LivenessValuesC1ERKS1_")
    //</editor-fold>
    public /*inline*/ LivenessValues(final /*const*/ LivenessValues /*&*/ $Prm0) {
      // : liveStmts(.liveStmts), liveDecls(.liveDecls) 
      //START JInit
      this.liveStmts = new ImmutableSetPtr</*const*/ Stmt /*P*/ >($Prm0.liveStmts);
      this.liveDecls = new ImmutableSetPtr</*const*/ VarDecl /*P*/ >($Prm0.liveDecls);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LivenessValues::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 32,
     FQN="clang::LiveVariables::LivenessValues::operator=", NM="_ZN5clang13LiveVariables14LivenessValuesaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables14LivenessValuesaSERKS1_")
    //</editor-fold>
    public /*inline*/ LivenessValues /*&*/ $assign(final /*const*/ LivenessValues /*&*/ $Prm0) {
      this.liveStmts.$assign($Prm0.liveStmts);
      this.liveDecls.$assign($Prm0.liveDecls);
      return /*Deref*/this;
    }

    @Override public LivenessValues clone() { return new LivenessValues(this); }
    
    @Override public String toString() {
      return "" + "liveStmts=" + liveStmts // NOI18N
                + ", liveDecls=" + liveDecls; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::Observer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 53,
   FQN="clang::LiveVariables::Observer", NM="_ZN5clang13LiveVariables8ObserverE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables8ObserverE")
  //</editor-fold>
  public static class Observer implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::Observer::anchor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 140,
     FQN="clang::LiveVariables::Observer::anchor", NM="_ZN5clang13LiveVariables8Observer6anchorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables8Observer6anchorEv")
    //</editor-fold>
    protected/*private*/ void anchor() {
    }


  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::Observer::~Observer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 56,
     FQN="clang::LiveVariables::Observer::~Observer", NM="_ZN5clang13LiveVariables8ObserverD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables8ObserverD0Ev")
    //</editor-fold>
    public /*virtual*/ void $destroy() {
    }

    
    /// A callback invoked right before invoking the
    ///  liveness transfer function on the given statement.
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::Observer::observeStmt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 60,
     FQN="clang::LiveVariables::Observer::observeStmt", NM="_ZN5clang13LiveVariables8Observer11observeStmtEPKNS_4StmtEPKNS_8CFGBlockERKNS0_14LivenessValuesE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables8Observer11observeStmtEPKNS_4StmtEPKNS_8CFGBlockERKNS0_14LivenessValuesE")
    //</editor-fold>
    public /*virtual*/ void observeStmt(/*const*/ Stmt /*P*/ S, 
               /*const*/ CFGBlock /*P*/ currentBlock, 
               final /*const*/ LivenessValues /*&*/ V) {
    }

    
    /// Called when the live variables analysis registers
    /// that a variable is killed.
    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::Observer::observerKill">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 66,
     FQN="clang::LiveVariables::Observer::observerKill", NM="_ZN5clang13LiveVariables8Observer12observerKillEPKNS_11DeclRefExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables8Observer12observerKillEPKNS_11DeclRefExprE")
    //</editor-fold>
    public /*virtual*/ void observerKill(/*const*/ DeclRefExpr /*P*/ DR) {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::Observer::Observer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 53,
     FQN="clang::LiveVariables::Observer::Observer", NM="_ZN5clang13LiveVariables8ObserverC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables8ObserverC1Ev")
    //</editor-fold>
    public /*inline*/ Observer() {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::~LiveVariables">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 480,
   FQN="clang::LiveVariables::~LiveVariables", NM="_ZN5clang13LiveVariablesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariablesD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if ((LiveVariablesImpl /*P*/ )impl != null) { ((LiveVariablesImpl /*P*/ )impl).$destroy();};
    super.$destroy();
  }


  
  /// Compute the liveness information for a given CFG.
  
  /// Compute the liveness information for a given CFG.
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::computeLiveness">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 484,
   FQN="clang::LiveVariables::computeLiveness", NM="_ZN5clang13LiveVariables15computeLivenessERNS_19AnalysisDeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables15computeLivenessERNS_19AnalysisDeclContextEb")
  //</editor-fold>
  public static LiveVariables /*P*/ computeLiveness(final AnalysisDeclContext /*&*/ AC, 
                 boolean killAtAssign) {
    DataflowWorklist worklist = null;
    BitVector everAnalyzedBlock = null;
    try {
      
      // No CFG?  Bail out.
      CFG /*P*/ cfg = AC.getCFG();
      if (!(cfg != null)) {
        return null;
      }
      
      // The analysis currently has scalability issues for very large CFGs.
      // Bail out if it looks too large.
      if ($greater_uint(cfg.getNumBlockIDs(), 300000)) {
        return null;
      }
      
      LiveVariablesImpl /*P*/ LV = new LiveVariablesImpl(AC, killAtAssign);
      
      // Construct the dataflow worklist.  Enqueue the exit block as the
      // start of the analysis.
      worklist/*J*/= new DataflowWorklist($Deref(cfg), AC);
      everAnalyzedBlock/*J*/= new BitVector(cfg.getNumBlockIDs());
      
      // FIXME: we should enqueue using post order.
      for (type$ptr<CFGBlock> it = $tryClone(cfg.begin()), /*P*/ ei = $tryClone(cfg.end()); $noteq_ptr(it, ei); it.$preInc()) {
        /*const*/ CFGBlock /*P*/ block = it.$star();
        worklist.enqueueBlock(block);
        
        // FIXME: Scan for DeclRefExprs using in the LHS of an assignment.
        // We need to do this because we lack context in the reverse analysis
        // to determine if a DeclRefExpr appears in such a context, and thus
        // doesn't constitute a "use".
        if (killAtAssign) {
          for (std.reverse_iterator</*const*/ CFGElement> bi = block.begin$Const(), be = block.end$Const();
               $noteq_reverse_iterator$C(bi, be); bi.$preInc()) {
            {
              Optional<CFGStmt> cs = bi.$arrow().getAs(CFGStmt.class);
              if (cs.$bool()) {
                {
                  /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(cs.$arrow().getStmt());
                  if ((BO != null)) {
                    if (BO.getOpcode() == BinaryOperatorKind.BO_Assign) {
                      {
                        /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(BO.getLHS().IgnoreParens());
                        if ((DR != null)) {
                          LV.inAssignment.$set(DR, 1);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      worklist.sortWorklist();
      {
        
        /*const*/ CFGBlock /*P*/ block;
        while (((/*P*/ block = worklist.dequeue()) != null)) {
          LivenessValues val = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Determine if the block's end value has changed.  If not, we
            // have nothing left to do for this block.
            final LivenessValues /*&*/ prevVal = LV.blocksEndToLiveness.$at_T1$C$R(block);
            
            // Merge the values of all successor blocks.
            val/*J*/= new LivenessValues();
            for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > it = $tryClone(block.succ_begin$Const()), 
                /*P*/ ei = $tryClone(block.succ_end$Const()); $noteq_ptr(it, ei); it.$preInc()) {
              {
                /*const*/ CFGBlock /*P*/ succ = it.$star().$CFGBlock$P();
                if ((succ != null)) {
                  $c$.clean(val.$assignMove($c$.track(LV.merge($c$.track(new LiveVariables.LivenessValues(val)), $c$.track(new LiveVariables.LivenessValues(LV.blocksBeginToLiveness.$at_T1$C$R(succ)))))));
                }
              }
            }
            if (!everAnalyzedBlock.$at(block.getBlockID()).$bool()) {
              everAnalyzedBlock.$at(block.getBlockID()).$assign(/*KEEP_BOOL*/true);
            } else if (prevVal.equals(val)) {
              continue;
            }
            
            prevVal.$assign(val);
            
            // Update the dataflow value for the start of this block.
            $c$.clean(LV.blocksBeginToLiveness.$at_T1$C$R(block).$assignMove($c$.track(LV.runOnBlock(block, $c$.track(new LiveVariables.LivenessValues(val))))));
            
            // Enqueue the value to the predecessors.
            worklist.enqueuePredecessors(block);
          } finally {
            if (val != null) { val.$destroy(); }
            $c$.$destroy();
          }
        }
      }
      
      return killAtAssign ? new LiveVariables(LV) : new RelaxedLiveVariables(LV);
    } finally {
      if (everAnalyzedBlock != null) { everAnalyzedBlock.$destroy(); }
      if (worklist != null) { worklist.$destroy(); }
    }
  }


  
  /// Return true if a variable is live at the end of a
  /// specified block.
  
  /// Return true if a variable is live at the end of a
  /// specified block.
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::isLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 177,
   FQN="clang::LiveVariables::isLive", NM="_ZN5clang13LiveVariables6isLiveEPKNS_8CFGBlockEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables6isLiveEPKNS_8CFGBlockEPKNS_7VarDeclE")
  //</editor-fold>
  public boolean isLive(/*const*/ CFGBlock /*P*/ B, /*const*/ VarDecl /*P*/ D) {
    return isAlwaysAlive(D) || getImpl(impl).blocksEndToLiveness.$at_T1$C$R(B).isLive(D);
  }


  
  /// Returns true if a variable is live at the beginning of the
  ///  the statement.  This query only works if liveness information
  ///  has been recorded at the statement level (see runOnAllBlocks), and
  ///  only returns liveness information for block-level expressions.
  
  /// Returns true if a variable is live at the beginning of the
  ///  the statement.  This query only works if liveness information
  ///  has been recorded at the statement level (see runOnAllBlocks), and
  ///  only returns liveness information for block-level expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::isLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 181,
   FQN="clang::LiveVariables::isLive", NM="_ZN5clang13LiveVariables6isLiveEPKNS_4StmtEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables6isLiveEPKNS_4StmtEPKNS_7VarDeclE")
  //</editor-fold>
  public boolean isLive(/*const*/ Stmt /*P*/ S, /*const*/ VarDecl /*P*/ D) {
    return isAlwaysAlive(D) || getImpl(impl).stmtsToLiveness.$at_T1$C$R(S).isLive(D);
  }


  
  /// Returns true the block-level expression "value" is live
  ///  before the given block-level expression (see runOnAllBlocks).
  
  /// Returns true the block-level expression "value" is live
  ///  before the given block-level expression (see runOnAllBlocks).
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::isLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 185,
   FQN="clang::LiveVariables::isLive", NM="_ZN5clang13LiveVariables6isLiveEPKNS_4StmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables6isLiveEPKNS_4StmtES3_")
  //</editor-fold>
  public boolean isLive(/*const*/ Stmt /*P*/ Loc, /*const*/ Stmt /*P*/ S) {
    return getImpl(impl).stmtsToLiveness.$at_T1$C$R(Loc).isLive(S);
  }


  
  /// Print to stderr the liveness information associated with
  /// each basic block.
  
  /// Print to stderr the liveness information associated with
  /// each basic block.
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::dumpBlockLiveness">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 564,
   FQN="clang::LiveVariables::dumpBlockLiveness", NM="_ZN5clang13LiveVariables17dumpBlockLivenessERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables17dumpBlockLivenessERKNS_13SourceManagerE")
  //</editor-fold>
  public void dumpBlockLiveness(final /*const*/ SourceManager /*&*/ M) {
    getImpl(impl).dumpBlockLiveness(M);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::runOnAllBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 472,
   FQN="clang::LiveVariables::runOnAllBlocks", NM="_ZN5clang13LiveVariables14runOnAllBlocksERNS0_8ObserverE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables14runOnAllBlocksERNS0_8ObserverE")
  //</editor-fold>
  public void runOnAllBlocks(final LiveVariables.Observer /*&*/ obs) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ CFG /*P*/ cfg = getImpl(impl).analysisContext.getCFG();
      for (type$ptr<CFGBlock> it = $tryClone(cfg.begin$Const()), /*P*/ ei = $tryClone(cfg.end$Const()); $noteq_ptr(it, ei); it.$preInc())  {
        $c$.clean($c$.track(getImpl(impl).runOnBlock(it.$star(), $c$.track(new LiveVariables.LivenessValues(getImpl(impl).blocksEndToLiveness.$at_T1$RR(it.$star()))), $AddrOf(obs))));
      }
    } finally {
      $c$.$destroy();
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/LiveVariables.h", line = 95,
   FQN="clang::LiveVariables::create", NM="_ZN5clang13LiveVariables6createERNS_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang13LiveVariables6createERNS_19AnalysisDeclContextE")
  //</editor-fold>
  public static LiveVariables /*P*/ create(final AnalysisDeclContext /*&*/ analysisContext) {
    return computeLiveness(analysisContext, true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 610,
   FQN="clang::LiveVariables::getTag", NM="_ZN5clang13LiveVariables6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariables6getTagEv")
  //</editor-fold>
  public static /*const*/Object/*void P*/ getTag() {
    final/*static*/ Object x = getTag$$.x;
    return $AddrOf(x);
  }
  private static final class getTag$$ {
    static final/*static*/ Object x = LiveVariables.class;
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LiveVariables::LiveVariables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 478,
   FQN="clang::LiveVariables::LiveVariables", NM="_ZN5clang13LiveVariablesC1EPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang13LiveVariablesC1EPv")
  //</editor-fold>
  protected LiveVariables(Object/*void P*/ im) {
    // : ManagedAnalysis(), impl(im) 
    //START JInit
    super();
    this.impl = im;
    //END JInit
  }

  
  private Object/*void P*/ impl;
  
  @Override public String toString() {
    return "" + "impl=" + impl // NOI18N
              + super.toString(); // NOI18N
  }
}
