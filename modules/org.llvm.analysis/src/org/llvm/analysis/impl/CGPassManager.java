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

package org.llvm.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIterator;
import org.llvm.adt.java.ADTJavaDifferentiators.JD$Timer$P;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import org.llvm.ir.intrinsic.IntrinsicGlobals;
import org.llvm.ir.java.CallGraphNodeBase;
import static org.llvm.pass.IrLlvmGlobals.getPassTimer;
import static org.llvm.adt.scc_iterator.scc_begin;
import static org.llvm.adt.scc_iterator.scc_end;
import static org.llvm.analysis.impl.CallGraphSCCPassStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 47,
 FQN="(anonymous namespace)::CGPassManager", NM="_ZN12_GLOBAL__N_113CGPassManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManagerE")
//</editor-fold>
public class CGPassManager extends /*public*/ ModulePass implements /*public*/ PMDataManager, Destructors.ClassWithDestructor {
/*public:*/
  // end anonymous namespace.
  // JAVA: moved to extra members/*public*/ static /*char*/byte ID = $int2char(0);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::CGPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 50,
   FQN="(anonymous namespace)::CGPassManager::CGPassManager", NM="_ZN12_GLOBAL__N_113CGPassManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManagerC1Ev")
  //</editor-fold>
  public /*explicit*/ CGPassManager() {
    // : ModulePass(ID), PMDataManager()
    //START JInit
    super(ID);
    this.PMDataManager$Flds = $PMDataManager();
    //END JInit
  }


  /// Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the module, and if so, return true.

  /// Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the module, and if so, return true.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::runOnModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 441,
   FQN="(anonymous namespace)::CGPassManager::runOnModule", NM="_ZN12_GLOBAL__N_113CGPassManager11runOnModuleERN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager11runOnModuleERN4llvm6ModuleE")
  //</editor-fold>
  @Override public boolean runOnModule(final Module /*&*/ M)/* override*/ {
    scc_iterator<CallGraph /*P*/, CallGraphNode, CallGraphNode> CGI = null;
    CallGraphSCC CurSCC = null;
    try {
      final CallGraph /*&*/ CG = this.<CallGraphWrapperPass>getAnalysis(CallGraphWrapperPass.class).getCallGraph();
      boolean Changed = doInitialization(CG);

      // Walk the callgraph in bottom-up SCC order.
      CGI = scc_begin(GraphTraitsCallGraph$C$P.$GTraits(), $AddrOf(CG));

      CurSCC/*J*/= new CallGraphSCC(CG, $AddrOf(CGI));
      while (!CGI.isAtEnd()) {
        // Copy the current SCC and increment past it so that the pass can hack
        // on the SCC if it wants to without invalidating our iterator.
        final /*const*/std.vector<CallGraphNode /*P*/ > /*&*/ NodeVec = CGI.$star();
        CurSCC.initialize(NodeVec.data$Const(), NodeVec.data$Const().$add(NodeVec.size()));
        CGI.$preInc();

        // At the top level, we run all the passes in this pass manager on the
        // functions in this SCC.  However, we support iterative compilation in the
        // case where a function pass devirtualizes a call to a function.  For
        // example, it is very common for a function pass (often GVN or instcombine)
        // to eliminate the addressing that feeds into a call.  With that improved
        // information, we would like the call to be an inline candidate, infer
        // mod-ref information etc.
        //
        // Because of this, we allow iteration up to a specified iteration count.
        // This only happens in the case of a devirtualized call, so we only burn
        // compile time in the case that we're making progress.  We also have a hard
        // iteration count limit in case there is crazy code.
        /*uint*/int Iteration = 0;
        bool$ref DevirtualizedCall = create_bool$ref(false);
        do {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"cgscc-passmgr")) {
              if ((Iteration != 0)) {
                dbgs().$out(/*KEEP_STR*/"  SCCPASSMGR: Re-visiting SCC, iteration #").$out_uint(Iteration).$out_char($$LF);
              }
            }
          } while (false);
          DevirtualizedCall.$set(false);
          Changed |= RunAllPassesOnSCC(CurSCC, CG, DevirtualizedCall);
        } while ($less_uint(Iteration++, MaxIterations.$T()) && DevirtualizedCall.$deref());
        if (DevirtualizedCall.$deref()) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"cgscc-passmgr")) {
              dbgs().$out(/*KEEP_STR*/"  CGSCCPASSMGR: Stopped iteration after ").$out_uint(Iteration).$out(/*KEEP_STR*/" times, due to -max-cg-scc-iterations\n");
            }
          } while (false);
        }
        if ($greater_uint(Iteration, MaxSCCIterations.$uint())) {
          MaxSCCIterations.$assign(Iteration);
        }
      }
      Changed |= doFinalization(CG);
      return Changed;
    } finally {
      if (CurSCC != null) { CurSCC.$destroy(); }
      if (CGI != null) { CGI.$destroy(); }
    }
  }


  //JAVA: using ModulePass::doInitialization;
  //JAVA: using ModulePass::doFinalization;


  /// Initialize CG
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 492,
   FQN="(anonymous namespace)::CGPassManager::doInitialization", NM="_ZN12_GLOBAL__N_113CGPassManager16doInitializationERN4llvm9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager16doInitializationERN4llvm9CallGraphE")
  //</editor-fold>
  public boolean doInitialization(final CallGraph /*&*/ CG) {
    boolean Changed = false;
    for (/*uint*/int i = 0, e = getNumContainedPasses(); i != e; ++i) {
      {
        PMDataManager /*P*/ PM = getContainedPass(i).getAsPMDataManager();
        if ((PM != null)) {
          assert (PM.getPassManagerType() == PassManagerType.PMT_FunctionPassManager) : "Invalid CGPassManager member";
          Changed |= ((FPPassManager /*P*/ )PM).doInitialization(CG.getModule());
        } else {
          Changed |= ((CallGraphSCCPass /*P*/ )getContainedPass(i)).doInitialization(CG);
        }
      }
    }
    return Changed;
  }


  /// Finalize CG
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 507,
   FQN="(anonymous namespace)::CGPassManager::doFinalization", NM="_ZN12_GLOBAL__N_113CGPassManager14doFinalizationERN4llvm9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager14doFinalizationERN4llvm9CallGraphE")
  //</editor-fold>
  public boolean doFinalization(final CallGraph /*&*/ CG) {
    boolean Changed = false;
    for (/*uint*/int i = 0, e = getNumContainedPasses(); i != e; ++i) {
      {
        PMDataManager /*P*/ PM = getContainedPass(i).getAsPMDataManager();
        if ((PM != null)) {
          assert (PM.getPassManagerType() == PassManagerType.PMT_FunctionPassManager) : "Invalid CGPassManager member";
          Changed |= ((FPPassManager /*P*/ )PM).doFinalization(CG.getModule());
        } else {
          Changed |= ((CallGraphSCCPass /*P*/ )getContainedPass(i)).doFinalization(CG);
        }
      }
    }
    return Changed;
  }


  /// Pass Manager itself does not invalidate any analysis info.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 64,
   FQN="(anonymous namespace)::CGPassManager::getAnalysisUsage", NM="_ZNK12_GLOBAL__N_113CGPassManager16getAnalysisUsageERN4llvm13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK12_GLOBAL__N_113CGPassManager16getAnalysisUsageERN4llvm13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ Info) /*const*//* override*/ {
    // CGPassManager walks SCC and it needs CallGraph.
    Info.<CallGraphWrapperPass>addRequired(CallGraphWrapperPass.class);
    Info.setPreservesAll();
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::getPassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 70,
   FQN="(anonymous namespace)::CGPassManager::getPassName", NM="_ZNK12_GLOBAL__N_113CGPassManager11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK12_GLOBAL__N_113CGPassManager11getPassNameEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getPassName() /*const*//* override*/ {
    return $("CallGraph Pass Manager");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 74,
   FQN="(anonymous namespace)::CGPassManager::getAsPMDataManager", NM="_ZN12_GLOBAL__N_113CGPassManager18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager18getAsPMDataManagerEv")
  //</editor-fold>
  @Override public PMDataManager /*P*/ getAsPMDataManager()/* override*/ {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::getAsPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 75,
   FQN="(anonymous namespace)::CGPassManager::getAsPass", NM="_ZN12_GLOBAL__N_113CGPassManager9getAsPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager9getAsPassEv")
  //</editor-fold>
  @Override public Pass /*P*/ getAsPass()/* override*/ {
    return this;
  }


  // Print passes managed by this manager
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::dumpPassStructure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 78,
   FQN="(anonymous namespace)::CGPassManager::dumpPassStructure", NM="_ZN12_GLOBAL__N_113CGPassManager17dumpPassStructureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager17dumpPassStructureEj")
  //</editor-fold>
  @Override public void dumpPassStructure(/*uint*/int Offset)/* override*/ {
    errs().indent(Offset * 2).$out(/*KEEP_STR*/"Call Graph SCC Pass Manager\n");
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      Pass /*P*/ P = getContainedPass(Index);
      P.dumpPassStructure(Offset + 1);
      dumpLastUses(P, Offset + 1);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::getContainedPass">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 87,
   FQN="(anonymous namespace)::CGPassManager::getContainedPass", NM="_ZN12_GLOBAL__N_113CGPassManager16getContainedPassEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager16getContainedPassEj")
  //</editor-fold>
  public Pass /*P*/ getContainedPass(/*uint*/int N) {
    assert ($less_uint(N, /*J:ToBase*/$PMDataManager$Fields().PassVector.size())) : "Pass number out of range!";
    return ((/*static_cast*/Pass /*P*/ )(/*J:ToBase*/$PMDataManager$Fields().PassVector.$at(N)));
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::getPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 92,
   FQN="(anonymous namespace)::CGPassManager::getPassManagerType", NM="_ZNK12_GLOBAL__N_113CGPassManager18getPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK12_GLOBAL__N_113CGPassManager18getPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPassManagerType() /*const*//* override*/ {
    return PassManagerType.PMT_CallGraphPassManager;
  }

/*private:*/

  /// Execute the body of the entire pass manager on the specified SCC.
  /// This keeps track of whether a function pass devirtualizes
  /// any calls and returns it in DevirtualizedCall.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::RunAllPassesOnSCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 381,
   FQN="(anonymous namespace)::CGPassManager::RunAllPassesOnSCC", NM="_ZN12_GLOBAL__N_113CGPassManager17RunAllPassesOnSCCERN4llvm12CallGraphSCCERNS1_9CallGraphERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager17RunAllPassesOnSCCERN4llvm12CallGraphSCCERNS1_9CallGraphERb")
  //</editor-fold>
  private boolean RunAllPassesOnSCC(final CallGraphSCC /*&*/ CurSCC, final CallGraph /*&*/ CG,
                   final bool$ref/*bool &*/ DevirtualizedCall) {
    boolean Changed = false;

    // Keep track of whether the callgraph is known to be up-to-date or not.
    // The CGSSC pass manager runs two types of passes:
    // CallGraphSCC Passes and other random function passes.  Because other
    // random function passes are not CallGraph aware, they may clobber the
    // call graph by introducing new calls or deleting other ones.  This flag
    // is set to false when we run a function pass so that we know to clean up
    // the callgraph when we need to run a CGSCCPass again.
    bool$ref CallGraphUpToDate = create_bool$ref(true);

    // Run all passes on current SCC.
    for (/*uint*/int PassNo = 0, e = getNumContainedPasses();
         PassNo != e; ++PassNo) {
      Pass /*P*/ P = getContainedPass(PassNo);

      // If we're in -debug-pass=Executions mode, construct the SCC node list,
      // otherwise avoid constructing this string as it is expensive.
      if (isPassDebuggingExecutionsOrMore()) {
        raw_string_ostream OS = null;
        try {
          std.string Functions/*J*/= new std.string();
          OS/*J*/= new raw_string_ostream(Functions);
          for (std.vector.iterator</*const*/ CallGraphNode /*P*/ > I = CurSCC.begin(), E = CurSCC.end();
               $noteq___normal_iterator$C(I, E); I.$preInc()) {
            if ($noteq___normal_iterator$C(I, CurSCC.begin())) {
              OS.$out(/*KEEP_STR*/$COMMA_SPACE);
            }
            (I.$star()).print(OS);
          }
          OS.flush();
          dumpPassInfo(P, PassDebuggingString.EXECUTION_MSG, PassDebuggingString.ON_CG_MSG, new StringRef(Functions));
        } finally {
          if (OS != null) { OS.$destroy(); }
        }
      }
      dumpRequiredSet(P);

      initializeAnalysisImpl(P);

      // Actually run this pass on the current SCC.
      Changed |= RunPassOnSCC(P, CurSCC, CG,
          CallGraphUpToDate, DevirtualizedCall);
      if (Changed) {
        dumpPassInfo(P, PassDebuggingString.MODIFICATION_MSG, PassDebuggingString.ON_CG_MSG, new StringRef(/*KEEP_STR*/$EMPTY));
      }
      dumpPreservedSet(P);

      verifyPreservedAnalysis(P);
      removeNotPreservedAnalysis(P);
      recordAvailableAnalysis(P);
      removeDeadPasses(P, new StringRef(/*KEEP_STR*/$EMPTY), PassDebuggingString.ON_CG_MSG);
    }

    // If the callgraph was left out of date (because the last pass run was a
    // functionpass), refresh it before we move on to the next SCC.
    if (!CallGraphUpToDate.$deref()) {
      DevirtualizedCall.$set$orassign(RefreshCallGraph(CurSCC, CG, false));
    }
    return Changed;
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::RunPassOnSCC">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 112,
   FQN="(anonymous namespace)::CGPassManager::RunPassOnSCC", NM="_ZN12_GLOBAL__N_113CGPassManager12RunPassOnSCCEPN4llvm4PassERNS1_12CallGraphSCCERNS1_9CallGraphERbS8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager12RunPassOnSCCEPN4llvm4PassERNS1_12CallGraphSCCERNS1_9CallGraphERbS8_")
  //</editor-fold>
  private boolean RunPassOnSCC(Pass /*P*/ P, final CallGraphSCC /*&*/ CurSCC,
              final CallGraph /*&*/ CG, final bool$ref/*bool &*/ CallGraphUpToDate,
              final bool$ref/*bool &*/ DevirtualizedCall) {
    boolean Changed = false;
    PMDataManager /*P*/ PM = P.getAsPMDataManager();
    if (!(PM != null)) {
      CallGraphSCCPass /*P*/ CGSP = (CallGraphSCCPass /*P*/ )P;
      if (!CallGraphUpToDate.$deref()) {
        DevirtualizedCall.$set$orassign(RefreshCallGraph(CurSCC, CG, false));
        CallGraphUpToDate.$set(true);
      }
      {
        TimeRegion PassTimer = null;
        try {
          PassTimer/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, getPassTimer(CGSP));
          Changed = CGSP.runOnSCC(CurSCC);
        } finally {
          if (PassTimer != null) { PassTimer.$destroy(); }
        }
      }
      if (Changed) {
        RefreshCallGraph(CurSCC, CG, true);
      }

      return Changed;
    }
    assert (PM.getPassManagerType() == PassManagerType.PMT_FunctionPassManager) : "Invalid CGPassManager member";
    FPPassManager /*P*/ FPP = (FPPassManager /*P*/ )P;

    // Run pass P on all functions in the current SCC.
    for (CallGraphNodeBase /*P*/ CGN : CurSCC) {
      {
        Function /*P*/ F = CGN.getFunction();
        if ((F != null)) {
          dumpPassInfo(P, PassDebuggingString.EXECUTION_MSG, PassDebuggingString.ON_FUNCTION_MSG, F.getName());
          {
            TimeRegion PassTimer = null;
            try {
              PassTimer/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, getPassTimer(FPP));
              Changed |= FPP.runOnFunction($Deref(F));
            } finally {
              if (PassTimer != null) { PassTimer.$destroy(); }
            }
          }
          F.getContext().yield();
        }
      }
    }

    // The function pass(es) modified the IR, they may have clobbered the
    // callgraph.
    if (Changed && CallGraphUpToDate.$deref()) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"cgscc-passmgr")) {
          dbgs().$out(/*KEEP_STR*/"CGSCCPASSMGR: Pass Dirtied SCC: ").$out(P.getPassName()).$out_char($$LF);
        }
      } while (false);
      CallGraphUpToDate.$set(false);
    }
    return Changed;
  }


  /// Scan the functions in the specified CFG and resync the
  /// callgraph with the call sites found in it.  This is used after
  /// FunctionPasses have potentially munged the callgraph, and can be used after
  /// CallGraphSCC passes to verify that they correctly updated the callgraph.
  ///
  /// This function returns true if it devirtualized an existing function call,
  /// meaning it turned an indirect call into a direct call.  This happens when
  /// a function pass like GVN optimizes away stuff feeding the indirect call.
  /// This never happens in checking mode.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::RefreshCallGraph">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 178,
   FQN="(anonymous namespace)::CGPassManager::RefreshCallGraph", NM="_ZN12_GLOBAL__N_113CGPassManager16RefreshCallGraphERN4llvm12CallGraphSCCERNS1_9CallGraphEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManager16RefreshCallGraphERN4llvm12CallGraphSCCERNS1_9CallGraphEb")
  //</editor-fold>
  private boolean RefreshCallGraph(final CallGraphSCC /*&*/ CurSCC,
                  final CallGraph /*&*/ CG, boolean CheckingMode) {
    DenseMap<Value /*P*/ , CallGraphNode /*P*/ > CallSites/*J*/= new DenseMap<Value /*P*/ , CallGraphNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CallGraphNode /*P*/ )null);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"cgscc-passmgr")) {
        dbgs().$out(/*KEEP_STR*/"CGSCCPASSMGR: Refreshing SCC with ").$out_uint(CurSCC.size()).$out(/*KEEP_STR*/" nodes:\n");
        for (CallGraphNodeBase /*P*/ CGN : CurSCC)  {
          ((CallGraphNode)CGN).dump();
        }
        ;
      }
    } while (false);

    boolean MadeChange = false;
    boolean DevirtualizedCall = false;

    // Scan all functions in the SCC.
    /*uint*/int FunctionNo = 0;
    for (std.vector.iterator</*const*/ CallGraphNode /*P*/ > SCCIdx = CurSCC.begin(), E = CurSCC.end();
         $noteq___normal_iterator$C(SCCIdx, E); SCCIdx.$preInc() , ++FunctionNo) {
      CallGraphNode /*P*/ CGN = SCCIdx.$star();
      Function /*P*/ F = CGN.getFunction();
      if (!(F != null) || F.isDeclaration()) {
        continue;
      }

      // Walk the function body looking for call sites.  Sync up the call sites in
      // CGN with those actually in the function.

      // Keep track of the number of direct and indirect calls that were
      // invalidated and removed.
      /*uint*/int NumDirectRemoved = 0;
      /*uint*/int NumIndirectRemoved = 0;

      // Get the set of call sites currently in the function.
      for (std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> I = CGN.begin(), E$1 = CGN.end(); $noteq___normal_iterator$C(I, E$1);) {
        // If this call site is null, then the function pass deleted the call
        // entirely and the WeakVH nulled it out.
        if (!((I.$arrow().first.$Value$P()) != null)
          // If we've already seen this call site, then the FunctionPass RAUW'd
          // one call with another, which resulted in two "uses" in the edge
          // list of the same call.
           || (CallSites.count(I.$arrow().first.$Value$P()) != 0)

          // If the call edge is not from a call or invoke, or it is a
          // instrinsic call, then the function pass RAUW'd a call with
          // another value. This can happen when constant folding happens
          // of well known functions etc.
           || !new CallSite(I.$arrow().first.$Value$P()).$bool()
           || ((new CallSite(I.$arrow().first.$Value$P()).getCalledFunction() != null)
           && new CallSite(I.$arrow().first.$Value$P()).getCalledFunction().isIntrinsic()
           && IntrinsicGlobals.isLeaf(new CallSite(I.$arrow().first.$Value$P()).getCalledFunction().getIntrinsicID()))) {
          assert (!CheckingMode) : "CallGraphSCCPass did not update the CallGraph correctly!";

          // If this was an indirect call site, count it.
          if (!(I.$arrow().second.getFunction() != null)) {
            ++NumIndirectRemoved;
          } else {
            ++NumDirectRemoved;
          }

          // Just remove the edge from the set of callees, keep track of whether
          // I points to the last element of the vector.
          boolean WasLast = $eq___normal_iterator$C(I.$add(1), E$1);
          CGN.removeCallEdge(new std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/>(I));

          // If I pointed to the last element of the vector, we have to bail out:
          // iterator checking rejects comparisons of the resultant pointer with
          // end.
          if (WasLast) {
            break;
          }
          E$1.$assignMove(CGN.end());
          continue;
        }
        assert (!(CallSites.count(I.$arrow().first.$Value$P()) != 0)) : "Call site occurs in node multiple times";

        CallSite CS/*J*/= new CallSite(I.$arrow().first.$Value$P());
        if (CS.$bool()) {
          Function /*P*/ Callee = CS.getCalledFunction();
          // Ignore intrinsics because they're not really function calls.
          if (!(Callee != null) || !(Callee.isIntrinsic())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(CallSites.insert_pair$KeyT$ValueT(new std.pairPtrPtr<Value /*P*/ , CallGraphNode /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd*/$c$.track(new WeakVH(/*Fwd2*/I.$arrow().first)).$Value$P(), /*Fwd2*//*Fwd*/I.$arrow().second)));
            } finally {
              $c$.$destroy();
            }
          }
        }
        I.$preInc();
      }

      // Loop over all of the instructions in the function, getting the callsites.
      // Keep track of the number of direct/indirect calls added.
      /*uint*/int NumDirectAdded = 0;
      /*uint*/int NumIndirectAdded = 0;

      for (final BasicBlock /*&*/ BB : $Deref(F))  {
        for (final Instruction /*&*/ I : BB) {
          CallSite CS/*J*/= new CallSite($AddrOf(I));
          if (!CS.$bool()) {
            continue;
          }
          Function /*P*/ Callee = CS.getCalledFunction();
          if ((Callee != null) && Callee.isIntrinsic()) {
            continue;
          }

          // If this call site already existed in the callgraph, just verify it
          // matches up to expectations and remove it from CallSites.
          DenseMapIterator<Value /*P*/ , CallGraphNode /*P*/ > ExistingIt = CallSites.find(CS.getInstruction());
          if (ExistingIt.$noteq(/*NO_ITER_COPY*/CallSites.end())) {
            CallGraphNode /*P*/ ExistingNode = ExistingIt.$arrow().second;

            // Remove from CallSites since we have now seen it.
            CallSites.erase(new DenseMapIterator<Value /*P*/ , CallGraphNode /*P*/ >(ExistingIt));

            // Verify that the callee is right.
            if (ExistingNode.getFunction() == CS.getCalledFunction()) {
              continue;
            }

            // If we are in checking mode, we are not allowed to actually mutate
            // the callgraph.  If this is a case where we can infer that the
            // callgraph is less precise than it could be (e.g. an indirect call
            // site could be turned direct), don't reject it in checking mode, and
            // don't tweak it to be more precise.
            if (CheckingMode && (CS.getCalledFunction() != null)
               && ExistingNode.getFunction() == null) {
              continue;
            }
            assert (!CheckingMode) : "CallGraphSCCPass did not update the CallGraph correctly!";

            // If not, we either went from a direct call to indirect, indirect to
            // direct, or direct to different direct.
            CallGraphNode /*P*/ CalleeNode;
            {
              Function /*P*/ Callee$1 = CS.getCalledFunction();
              if ((Callee$1 != null)) {
                CalleeNode = CG.getOrInsertFunction(Callee$1);
                // Keep track of whether we turned an indirect call into a direct
                // one.
                if (!(ExistingNode.getFunction() != null)) {
                  DevirtualizedCall = true;
                  do {
                    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"cgscc-passmgr")) {
                      dbgs().$out(/*KEEP_STR*/"  CGSCCPASSMGR: Devirtualized call to '").$out(Callee$1.getName()).$out(/*KEEP_STR*/"'\n");
                    }
                  } while (false);
                }
              } else {
                CalleeNode = CG.getCallsExternalNode();
              }
            }

            // Update the edge target in CGN.
            CGN.replaceCallEdge(new CallSite(CS), new CallSite(CS), CalleeNode);
            MadeChange = true;
            continue;
          }
          assert (!CheckingMode) : "CallGraphSCCPass did not update the CallGraph correctly!";

          // If the call site didn't exist in the CGN yet, add it.
          CallGraphNode /*P*/ CalleeNode;
          {
            Function /*P*/ Callee$1 = CS.getCalledFunction();
            if ((Callee$1 != null)) {
              CalleeNode = CG.getOrInsertFunction(Callee$1);
              ++NumDirectAdded;
            } else {
              CalleeNode = CG.getCallsExternalNode();
              ++NumIndirectAdded;
            }
          }

          CGN.addCalledFunction(new CallSite(CS), CalleeNode);
          MadeChange = true;
        }
      }

      // We scanned the old callgraph node, removing invalidated call sites and
      // then added back newly found call sites.  One thing that can happen is
      // that an old indirect call site was deleted and replaced with a new direct
      // call.  In this case, we have devirtualized a call, and CGSCCPM would like
      // to iteratively optimize the new code.  Unfortunately, we don't really
      // have a great way to detect when this happens.  As an approximation, we
      // just look at whether the number of indirect calls is reduced and the
      // number of direct calls is increased.  There are tons of ways to fool this
      // (e.g. DCE'ing an indirect call and duplicating an unrelated block with a
      // direct call) but this is close enough.
      if ($greater_uint(NumIndirectRemoved, NumIndirectAdded)
         && $less_uint(NumDirectRemoved, NumDirectAdded)) {
        DevirtualizedCall = true;
      }

      // After scanning this function, if we still have entries in callsites, then
      // they are dangling pointers.  WeakVH should save us for this, so abort if
      // this happens.
      assert (CallSites.empty()) : "Dangling pointers found in call sites map";

      // Periodically do an explicit clear to remove tombstones when processing
      // large scc's.
      if ((FunctionNo & 15) == 15) {
        CallSites.clear();
      }
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"cgscc-passmgr")) {
        if (MadeChange) {
          dbgs().$out(/*KEEP_STR*/"CGSCCPASSMGR: Refreshed SCC is now:\n");
          for (CallGraphNodeBase /*P*/ CGN : CurSCC)  {
            ((CallGraphNode)CGN).dump();
          }
          if (DevirtualizedCall) {
            dbgs().$out(/*KEEP_STR*/"CGSCCPASSMGR: Refresh devirtualized a call!\n");
          }
        } else {
          dbgs().$out(/*KEEP_STR*/"CGSCCPASSMGR: SCC Refresh didn't change call graph.\n");
        }
        ;
      }
    } while (false);
    ///*J:(void)*/MadeChange;

    return DevirtualizedCall;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGPassManager::~CGPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 47,
   FQN="(anonymous namespace)::CGPassManager::~CGPassManager", NM="_ZN12_GLOBAL__N_113CGPassManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN12_GLOBAL__N_113CGPassManagerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    PMDataManager.super.$destroy$PMDataManager();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<CGPassManager> ID = CGPassManager.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  private final PMDataManager$Fields PMDataManager$Flds;// use return value of $PMDataManager();
  @Override public final PMDataManager$Fields $PMDataManager$Fields() { return PMDataManager$Flds; }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
