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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.staticanalyzer.checkers.ento.EntoGlobals.*;
import org.clang.staticanalyzer.java.StaticAnalyzerFunctionPointers.*;
import org.llvm.adt.java.ADTFunctionPointers.BumpPtrAllocator2VoidPtr;


//===----------------------------------------------------------------------===//
// ProgramStateManager - Factory object for ProgramStates.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 445,
 FQN="clang::ento::ProgramStateManager", NM="_ZN5clang4ento19ProgramStateManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManagerE")
//</editor-fold>
public class ProgramStateManager implements Destructors.ClassWithDestructor {
  /*friend  class ProgramState*/
  /*friend void ProgramStateRelease(const ProgramState *state)*/
/*private:*/
  /// Eng - The SubEngine that owns this state manager.
  private SubEngine /*P*/ Eng; /* Can be null. */
  
  /*friend*/public/*private*/ EnvironmentManager EnvMgr;
  /*friend*/public/*private*/ std.unique_ptr<StoreManager> StoreMgr;
  /*friend*/public/*private*/ std.unique_ptr<ConstraintManager> ConstraintMgr;
  
  private ImmutableMapPtrPtr.Factory<Object/*void P*/ , Object/*void P*/ > GDMFactory;
  
  // JAVA: typedef llvm::DenseMap<void *, std::pair<void *, void (*)(void *)> > GDMContextsTy
//  public final class GDMContextsTy extends DenseMap<Object/*void P*/ , std.pairPtrPtr<Object/*void P*/ , VoidPtr2Void>>{ };
  private DenseMap<Object/*void P*/ , std.pairPtrPtr<Object/*void P*/ , VoidPtr2Void>> GDMContexts;
  
  /// StateSet - FoldingSet containing all the states created for analyzing
  ///  a particular function.  This is used to unique states.
  /*friend*/public/*private*/ FoldingSet<ProgramState> StateSet;
  
  /// Object that manages the data for all created SVals.
  /*friend*/public/*private*/ std.unique_ptr<SValBuilder> svalBuilder;
  
  /// Manages memory for created CallEvents.
  private std.unique_ptr<CallEventManager> CallEventMgr;
  
  /// A BumpPtrAllocator to allocate states.
  private final BumpPtrAllocatorImpl /*&*/ Alloc;
  
  /// A vector of ProgramStates that we can reuse.
 /*friend*/public/*private*/ std.vector<ProgramState /*P*/ > freeStates;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::ProgramStateManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 70,
   FQN="clang::ento::ProgramStateManager::ProgramStateManager", NM="_ZN5clang4ento19ProgramStateManagerC1ERNS_10ASTContextEPFSt10unique_ptrINS0_12StoreManagerESt14default_deleteIS5_EERS1_EPFS4_INS0_17ConstraintManagerES6_ISC_EES9_PNS0_9SubEngineEERN4llvm20BumpPtrAllocatorImplINSJ_15MallocAllocatorELj4096ELj4096EEESG_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManagerC1ERNS_10ASTContextEPFSt10unique_ptrINS0_12StoreManagerESt14default_deleteIS5_EERS1_EPFS4_INS0_17ConstraintManagerES6_ISC_EES9_PNS0_9SubEngineEERN4llvm20BumpPtrAllocatorImplINSJ_15MallocAllocatorELj4096ELj4096EEESG_")
  //</editor-fold>
  public ProgramStateManager(final ASTContext /*&*/ Ctx, 
      StoreManagerCreator CreateSMgr, 
      ConstraintManagerCreator CreateCMgr,
      final BumpPtrAllocatorImpl /*&*/ alloc, 
      SubEngine /*P*/ SubEng) {
    // : Eng(SubEng), EnvMgr(alloc), StoreMgr(), ConstraintMgr(), GDMFactory(alloc), GDMContexts(), StateSet(), svalBuilder(createSimpleSValBuilder(alloc, Ctx, *this)), CallEventMgr(new CallEventManager(alloc)), Alloc(alloc), freeStates() 
    //START JInit
    this.Eng = SubEng;
    this.EnvMgr = new EnvironmentManager(alloc);
    this.StoreMgr = new std.unique_ptr<StoreManager>();
    this.ConstraintMgr = new std.unique_ptr<ConstraintManager>();
    this.GDMFactory = new ImmutableMapPtrPtr.Factory<Object/*void P*/ , Object/*void P*/ >(
            new ImutKeyValueInfo$TP$SP(
                    new ImutContainerInfoT$P<>(null), 
                    new ImutContainerInfoT$P<>(null)),
            alloc);
    this.GDMContexts = new DenseMap<Object/*void P*/ , std.pairPtrPtr<Object/*void P*/ , VoidPtr2Void>>(DenseMapInfo$LikePtr.$Info(), new std.pairPtrPtr<Object/*void P*/ , VoidPtr2Void>(null, NativeCallback.VoidPtr2Void$Default));
    this.StateSet = new FoldingSet<ProgramState>(ProgramState.$Trait());
    this.svalBuilder = new std.unique_ptr<SValBuilder>(createSimpleSValBuilder(alloc, Ctx, /*Deref*/this));
    this.CallEventMgr = new std.unique_ptr<CallEventManager>(new CallEventManager(alloc));
    this./*&*/Alloc=/*&*/alloc;
    this.freeStates = new std.vector<ProgramState /*P*/ >((ProgramState /*P*/ )null);
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(StoreMgr.$assignMove($c$.track(($Deref(CreateSMgr)).$call(/*Deref*/this))));
      $c$.clean(ConstraintMgr.$assignMove($c$.track(($Deref(CreateCMgr)).$call(/*Deref*/this, SubEng))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::~ProgramStateManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 83,
   FQN="clang::ento::ProgramStateManager::~ProgramStateManager", NM="_ZN5clang4ento19ProgramStateManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (DenseMapIterator<Object/*void P*/ , std.pairPtrPtr<Object/*void P*/ , VoidPtr2Void>> I = GDMContexts.begin(), E = GDMContexts.end();
         I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
      I.$arrow().second.second.$call(I.$arrow().second.first);
    }
    //START JDestroy
    freeStates.$destroy();
    CallEventMgr.$destroy();
    svalBuilder.$destroy();
    StateSet.$destroy();
    GDMContexts.$destroy();
    GDMFactory.$destroy();
    ConstraintMgr.$destroy();
    StoreMgr.$destroy();
    EnvMgr.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getInitialState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 364,
   FQN="clang::ento::ProgramStateManager::getInitialState", NM="_ZN5clang4ento19ProgramStateManager15getInitialStateEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager15getInitialStateEPKNS_15LocationContextE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> getInitialState(/*const*/ LocationContext /*P*/ InitLoc) {
    ProgramState State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State/*J*/= $c$.clean(new ProgramState(this, 
          $c$.track(EnvMgr.getInitialEnvironment()), 
          $c$.track(StoreMgr.$arrow().getInitialStore(InitLoc)), 
          $c$.track(GDMFactory.getEmptyMap())));
      
      return getPersistentState(State);
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 488,
   FQN="clang::ento::ProgramStateManager::getContext", NM="_ZN5clang4ento19ProgramStateManager10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() {
    return svalBuilder.$arrow().getContext();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 489,
   FQN="clang::ento::ProgramStateManager::getContext", NM="_ZNK5clang4ento19ProgramStateManager10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento19ProgramStateManager10getContextEv")
  //</editor-fold>
  public /*const*/ ASTContext /*&*/ getContext$Const() /*const*/ {
    return svalBuilder.$arrow().getContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getBasicVals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 491,
   FQN="clang::ento::ProgramStateManager::getBasicVals", NM="_ZN5clang4ento19ProgramStateManager12getBasicValsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager12getBasicValsEv")
  //</editor-fold>
  public BasicValueFactory /*&*/ getBasicVals() {
    return svalBuilder.$arrow().getBasicValueFactory();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getSValBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 495,
   FQN="clang::ento::ProgramStateManager::getSValBuilder", NM="_ZN5clang4ento19ProgramStateManager14getSValBuilderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager14getSValBuilderEv")
  //</editor-fold>
  public SValBuilder /*&*/ getSValBuilder() {
    return svalBuilder.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getSymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 499,
   FQN="clang::ento::ProgramStateManager::getSymbolManager", NM="_ZN5clang4ento19ProgramStateManager16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager16getSymbolManagerEv")
  //</editor-fold>
  public SymbolManager /*&*/ getSymbolManager() {
    return svalBuilder.$arrow().getSymbolManager();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getSymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 502,
   FQN="clang::ento::ProgramStateManager::getSymbolManager", NM="_ZNK5clang4ento19ProgramStateManager16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento19ProgramStateManager16getSymbolManagerEv")
  //</editor-fold>
  public /*const*/ SymbolManager /*&*/ getSymbolManager$Const() /*const*/ {
    return svalBuilder.$arrow().getSymbolManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 506,
   FQN="clang::ento::ProgramStateManager::getAllocator", NM="_ZN5clang4ento19ProgramStateManager12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager12getAllocatorEv")
  //</editor-fold>
  public BumpPtrAllocatorImpl /*&*/ getAllocator() {
    return Alloc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 508,
   FQN="clang::ento::ProgramStateManager::getRegionManager", NM="_ZN5clang4ento19ProgramStateManager16getRegionManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager16getRegionManagerEv")
  //</editor-fold>
  public MemRegionManager /*&*/ getRegionManager() {
    return svalBuilder.$arrow().getRegionManager();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 511,
   FQN="clang::ento::ProgramStateManager::getRegionManager", NM="_ZNK5clang4ento19ProgramStateManager16getRegionManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento19ProgramStateManager16getRegionManagerEv")
  //</editor-fold>
  public /*const*/ MemRegionManager /*&*/ getRegionManager$Const() /*const*/ {
    return svalBuilder.$arrow().getRegionManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getCallEventManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 515,
   FQN="clang::ento::ProgramStateManager::getCallEventManager", NM="_ZN5clang4ento19ProgramStateManager19getCallEventManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager19getCallEventManagerEv")
  //</editor-fold>
  public CallEventManager /*&*/ getCallEventManager() {
    return CallEventMgr.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getStoreManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 517,
   FQN="clang::ento::ProgramStateManager::getStoreManager", NM="_ZN5clang4ento19ProgramStateManager15getStoreManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager15getStoreManagerEv")
  //</editor-fold>
  public StoreManager /*&*/ getStoreManager() {
    return StoreMgr.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getConstraintManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 518,
   FQN="clang::ento::ProgramStateManager::getConstraintManager", NM="_ZN5clang4ento19ProgramStateManager20getConstraintManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager20getConstraintManagerEv")
  //</editor-fold>
  public ConstraintManager /*&*/ getConstraintManager() {
    return ConstraintMgr.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getOwningEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 519,
   FQN="clang::ento::ProgramStateManager::getOwningEngine", NM="_ZN5clang4ento19ProgramStateManager15getOwningEngineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager15getOwningEngineEv")
  //</editor-fold>
  public SubEngine /*P*/ getOwningEngine() {
    return Eng;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::removeDeadBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 89,
   FQN="clang::ento::ProgramStateManager::removeDeadBindings", NM="_ZN5clang4ento19ProgramStateManager18removeDeadBindingsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_17StackFrameContextERNS0_12SymbolReaperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager18removeDeadBindingsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_17StackFrameContextERNS0_12SymbolReaperE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> removeDeadBindings(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                    /*const*/ StackFrameContext /*P*/ LCtx, 
                    final SymbolReaper /*&*/ SymReaper) {
    ProgramState NewState = null;
    StoreRef newStore = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> Result = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // This code essentially performs a "mark-and-sweep" of the VariableBindings.
      // The roots are any Block-level exprs and Decls that our liveness algorithm
      // tells us are live.  We then see what Decls they may reference, and keep
      // those around.  This code more than likely can be made faster, and the
      // frequency of which this method is called should be experimented with
      // for optimum performance.
      NewState = new ProgramState(state.$star());
      
      $c$.clean(NewState.Env.$assignMove($c$.track(EnvMgr.removeDeadBindings($c$.track(new Environment(NewState.Env)), SymReaper, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))))));
      
      // Clean up the store.
      newStore = StoreMgr.$arrow().removeDeadBindings(NewState.getStore(), LCtx, 
          SymReaper);
      NewState.setStore(newStore);
      SymReaper.setReapedStore($c$.track(new StoreRef(newStore))); $c$.clean();
      
      Result = getPersistentState(NewState);
      return $c$.clean(ConstraintMgr.$arrow().removeDeadBindings($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Result)), SymReaper));
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (newStore != null) { newStore.$destroy(); }
      if (NewState != null) { NewState.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::ArrayToPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 527,
   FQN="clang::ento::ProgramStateManager::ArrayToPointer", NM="_ZN5clang4ento19ProgramStateManager14ArrayToPointerENS0_3LocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager14ArrayToPointerENS0_3LocENS_8QualTypeE")
  //</editor-fold>
  public SVal ArrayToPointer(Loc Array, QualType ElementTy) {
    return StoreMgr.$arrow().ArrayToPointer(new Loc(Array), new QualType(ElementTy));
  }

  
  // Methods that manipulate the GDM.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::addGDM">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 484,
   FQN="clang::ento::ProgramStateManager::addGDM", NM="_ZN5clang4ento19ProgramStateManager6addGDMEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPvS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager6addGDMEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPvS7_")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> addGDM(IntrusiveRefCntPtr</*const*/ ProgramState> St, Object/*void P*/ Key, Object/*void P*/ Data) {
    ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ > M1 = null;
    ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ > M2 = null;
    ProgramState NewSt = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      M1 = St.$arrow().getGDM();
      M2 = $c$.clean(GDMFactory.add($c$.track(new ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/>(M1)), Key, Data));
      if (M1.$eq(M2)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, St);
      }

      NewSt = new ProgramState(St.$star());
      NewSt.GDM.$assign(M2);
      return getPersistentState(NewSt);
    } finally {
      if (NewSt != null) { NewSt.$destroy(); }
      if (M2 != null) { M2.$destroy(); }
      if (M1 != null) { M1.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::removeGDM">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 496,
   FQN="clang::ento::ProgramStateManager::removeGDM", NM="_ZN5clang4ento19ProgramStateManager9removeGDMEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager9removeGDMEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPv")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> removeGDM(IntrusiveRefCntPtr</*const*/ ProgramState> state, Object/*void P*/ Key) {
    ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ > OldM = null;
    ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ > NewM = null;
    ProgramState NewState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      OldM = state.$arrow().getGDM();
      NewM = $c$.clean(GDMFactory.remove($c$.track(new ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/>(OldM)), Key));
      if (NewM.$eq(OldM)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    }

      NewState = new ProgramState(state.$star());
      NewState.GDM.$assign(NewM);
      return getPersistentState(NewState);
    } finally {
      if (NewState != null) { NewState.$destroy(); }
      if (NewM != null) { NewM.$destroy(); }
      if (OldM != null) { OldM.$destroy(); }
      $c$.$destroy();
    }
  }
  
  
  // Methods that query & manipulate the Store.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::iterBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 537,
   FQN="clang::ento::ProgramStateManager::iterBindings", NM="_ZN5clang4ento19ProgramStateManager12iterBindingsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12StoreManager15BindingsHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager12iterBindingsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12StoreManager15BindingsHandlerE")
  //</editor-fold>
  public void iterBindings(IntrusiveRefCntPtr</*const*/ ProgramState> state, final StoreManager.BindingsHandler /*&*/ F) {
    StoreMgr.$arrow().iterBindings(state.$arrow().getStore(), F);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getPersistentState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 381,
   FQN="clang::ento::ProgramStateManager::getPersistentState", NM="_ZN5clang4ento19ProgramStateManager18getPersistentStateERNS0_12ProgramStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager18getPersistentStateERNS0_12ProgramStateE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> getPersistentState(final ProgramState /*&*/ State) {
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    State.Profile(ID);
    final type$ref<type$ptr<ProgramState /*P*/>/*void P*/ > InsertPos = create_type$ref();
    {
      
      ProgramState /*P*/ I = StateSet.FindNodeOrInsertPos(ID, InsertPos);
      if ((I != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(I);
      }
    }

    ProgramState /*P*/ newState = null;
    if (!freeStates.empty()) {
      newState = freeStates.back();
      freeStates.pop_back();
      // JAVA: MEMORY
      /*not reused memory yet*/newState = null;
    } else {
      newState = (ProgramState /*P*/ )Alloc.<ProgramState>Allocate$T(ProgramState.class);
    }
    /*NEW_EXPR [System]*/newState = /*new (newState)*/ $new_uint_voidPtr(newState, (type$ptr<?> New$Mem)->{
        return new ProgramState(State);
     });
    StateSet.InsertNode(newState, InsertPos.$deref());
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(newState);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::getPersistentStateWithGDM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 373,
   FQN="clang::ento::ProgramStateManager::getPersistentStateWithGDM", NM="_ZN5clang4ento19ProgramStateManager25getPersistentStateWithGDMEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager25getPersistentStateWithGDMEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES6_")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> getPersistentStateWithGDM(IntrusiveRefCntPtr</*const*/ ProgramState> FromState, 
                           IntrusiveRefCntPtr</*const*/ ProgramState> GDMState) {
    ProgramState NewState = null;
    try {
      NewState/*J*/= new ProgramState(FromState.$star());
      NewState.GDM.$assign(GDMState.$arrow().GDM);
      return getPersistentState(NewState);
    } finally {
      if (NewState != null) { NewState.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::haveEqualEnvironments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 545,
   FQN="clang::ento::ProgramStateManager::haveEqualEnvironments", NM="_ZN5clang4ento19ProgramStateManager21haveEqualEnvironmentsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager21haveEqualEnvironmentsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES6_")
  //</editor-fold>
  public boolean haveEqualEnvironments(IntrusiveRefCntPtr</*const*/ ProgramState> S1, IntrusiveRefCntPtr</*const*/ ProgramState> S2) {
    return S1.$arrow().Env.$eq(S2.$arrow().Env);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::haveEqualStores">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 549,
   FQN="clang::ento::ProgramStateManager::haveEqualStores", NM="_ZN5clang4ento19ProgramStateManager15haveEqualStoresEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager15haveEqualStoresEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES6_")
  //</editor-fold>
  public boolean haveEqualStores(IntrusiveRefCntPtr</*const*/ ProgramState> S1, IntrusiveRefCntPtr</*const*/ ProgramState> S2) {
    return $eq_ptr(S1.$arrow().store, S2.$arrow().store);
  }

  
  //==---------------------------------------------------------------------==//
  // Generic Data Map methods.
  //==---------------------------------------------------------------------==//
  //
  // ProgramStateManager and ProgramState support a "generic data map" that allows
  // different clients of ProgramState objects to embed arbitrary data within a
  // ProgramState object.  The generic data map is essentially an immutable map
  // from a "tag" (that acts as the "key" for a client) and opaque values.
  // Tags/keys and values are simply void* values.  The typical way that clients
  // generate unique tags are by taking the address of a static variable.
  // Clients are responsible for ensuring that data values referred to by a
  // the data pointer are immutable (and thus are essentially purely functional
  // data).
  //
  // The templated methods below use the ProgramStateTrait<T> class
  // to resolve keys into the GDM and to return data values to clients.
  //
  
  // Trait based GDM dispatch.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::set">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 573,
   FQN="clang::ento::ProgramStateManager::set", NM="Tpl__ZN5clang4ento19ProgramStateManager3setEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_17ProgramStateTraitIT_E9data_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZN5clang4ento19ProgramStateManager3setEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_17ProgramStateTraitIT_E9data_typeE")
  //</editor-fold>
  public </*typename*/ data_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStateTrait<data_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st,  /*ProgramStateTrait<T>.*/data_type D) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.$tryCloneData($c$, D))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 579,
   FQN="clang::ento::ProgramStateManager::set", NM="Tpl__ZN5clang4ento19ProgramStateManager3setEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_17ProgramStateTraitIT_E8key_typeENS9_10value_typeENS9_12context_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZN5clang4ento19ProgramStateManager3setEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_17ProgramStateTraitIT_E8key_typeENS9_10value_typeENS9_12context_typeE")
  //</editor-fold>
  public </*typename*/ key_type, value_type extends FoldingSetTrait.Profilable> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStatePartialTraitImmutableMapPtrType<key_type, value_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
      /*ProgramStateTrait<T>.*/key_type K, 
      /*ProgramStateTrait<T>.*/value_type V, 
      /*ProgramStateTrait<T>.*/ImmutableMapPtrType.Factory<key_type, value_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Set(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), $Trait.$tryCloneValue($c$, V), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type, value_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStatePartialTraitImmutableMapPtrPtr<key_type, value_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
      /*ProgramStateTrait<T>.*/key_type K, 
      /*ProgramStateTrait<T>.*/value_type V, 
      /*ProgramStateTrait<T>.*/ImmutableMapPtrPtr.Factory<key_type, value_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Set(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), $Trait.$tryCloneValue(V), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStatePartialTraitImmutableMapPtrUInt<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
      /*ProgramStateTrait<T>.*/key_type K, 
      /*ProgramStateTrait<T>.*//*uint*/int V, 
      /*ProgramStateTrait<T>.*/ImmutableMapPtrUInt.Factory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Set(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), $Trait.$tryCloneValue(V), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStatePartialTraitImmutableMapPtrBool<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
      /*ProgramStateTrait<T>.*/key_type K, 
      /*ProgramStateTrait<T>.*/boolean V, 
      /*ProgramStateTrait<T>.*/ImmutableMapPtrBool.Factory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Set(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), $Trait.$tryCloneValue(V), C))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::add">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 589,
   FQN="clang::ento::ProgramStateManager::add", NM="Tpl__ZN5clang4ento19ProgramStateManager3addEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_17ProgramStateTraitIT_E8key_typeENS9_12context_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZN5clang4ento19ProgramStateManager3addEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_17ProgramStateTraitIT_E8key_typeENS9_12context_typeE")
  //</editor-fold>
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> add(ProgramStatePartialTraitImmutableSet$T<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
      /*ProgramStateTrait<T>.*/key_type K, 
      /*ProgramStateTrait<T>.*/ImmutableSet.Factory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Add(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> add(ProgramStatePartialTraitImmutableSetUInt $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
      /*ProgramStateTrait<T>. uint*/int K, 
      /*ProgramStateTrait<T>.*/ImmutableSetUInt.Factory C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Add(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> add(ProgramStatePartialTraitImmutableSet$TP<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
      /*ProgramStateTrait<T>.*/key_type K, 
      /*ProgramStateTrait<T>.*/ImmutableSetPtr.Factory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Add(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> add(ProgramStatePartialTraitImmutableList$T<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
      /*ProgramStateTrait<T>.*/key_type K, 
      /*ProgramStateTrait<T>.*/ImmutableListFactory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Add(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::remove">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 597,
   FQN="clang::ento::ProgramStateManager::remove", NM="Tpl__ZN5clang4ento19ProgramStateManager6removeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_17ProgramStateTraitIT_E8key_typeENS9_12context_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZN5clang4ento19ProgramStateManager6removeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_17ProgramStateTraitIT_E8key_typeENS9_12context_typeE")
  //</editor-fold>
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableSet$T<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
         /*ProgramStateTrait<T>.*/key_type K, 
         /*ProgramStateTrait<T>.*/ImmutableSet.Factory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Remove(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableSet$TP<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
         /*ProgramStateTrait<T>.*/key_type K, 
         /*ProgramStateTrait<T>.*/ImmutableSetPtr.Factory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Remove(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableMapPtrUInt<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
         /*ProgramStateTrait<T>.*/key_type K, 
         /*ProgramStateTrait<T>.*/ImmutableMapPtrUInt.Factory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Remove(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableMapPtrBool<key_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
         /*ProgramStateTrait<T>.*/key_type K, 
         /*ProgramStateTrait<T>.*/ImmutableMapPtrBool.Factory<key_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Remove(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type, value_type extends FoldingSetTrait.Profilable> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableMapPtrType<key_type, value_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
         /*ProgramStateTrait<T>.*/key_type K, 
         /*ProgramStateTrait<T>.*/ImmutableMapPtrType.Factory<key_type, value_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Remove(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type, value_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableMapPtrPtr<key_type, value_type> $Trait, IntrusiveRefCntPtr</*const*/ ProgramState> st, 
         /*ProgramStateTrait<T>.*/key_type K, 
         /*ProgramStateTrait<T>.*/ImmutableMapPtrPtr.Factory<key_type, value_type> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(addGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex(), 
        $Trait.MakeVoidPtr($Trait.Remove(st.$arrow().get($Trait), $Trait.$tryCloneKey(K), C))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::remove">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 606,
   FQN="clang::ento::ProgramStateManager::remove", NM="Tpl__ZN5clang4ento19ProgramStateManager6removeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZN5clang4ento19ProgramStateManager6removeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public </*typename*/ T> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStateTrait<T> $Trait,  IntrusiveRefCntPtr</*const*/ ProgramState> st) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(removeGDM($c$.track(new IntrusiveRefCntPtr<ProgramState>(st)), $Trait.GDMIndex()));
    } finally {
      $c$.$destroy();
    }
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::FindGDMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 470,
   FQN="clang::ento::ProgramStateManager::FindGDMContext", NM="_ZN5clang4ento19ProgramStateManager14FindGDMContextEPvPFS2_RN4llvm20BumpPtrAllocatorImplINS3_15MallocAllocatorELj4096ELj4096EEEEPFvS2_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager14FindGDMContextEPvPFS2_RN4llvm20BumpPtrAllocatorImplINS3_15MallocAllocatorELj4096ELj4096EEEEPFvS2_E")
  //</editor-fold>
  public Object/*void P*/ FindGDMContext(Object/*void P*/ K, 
                BumpPtrAllocator2VoidPtr CreateContext, 
                VoidPtr2Void DeleteContext) {
    
    final std.pairPtrPtr<Object/*void P*/ , VoidPtr2Void> /*&*/ p = GDMContexts.$at_T1$C$R(K);
    if (!(p.first != null)) {
      p.first = CreateContext.$call(Alloc);
      p.second = $tryClone(DeleteContext);
    }

    return p.first;
  }
  
  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::get_context">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 615,
   FQN="clang::ento::ProgramStateManager::get_context", NM="Tpl__ZN5clang4ento19ProgramStateManager11get_contextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZN5clang4ento19ProgramStateManager11get_contextEv")
  //</editor-fold>
  public  ImmutableSetUInt.Factory get_context(final ProgramStatePartialTraitImmutableSetUInt $Trait) {
    Object/*void P*/ p = FindGDMContext($Trait.GDMIndex(), 
        (BumpPtrAllocatorImpl Alloc) -> { return $Trait.CreateContext(Alloc); }, 
        (Object /*void P*/ Ctx) -> { $Trait.DeleteContext(Ctx); });
    
    return $Trait.MakeContext(p);
  }
  public </*typename*/ T>  ImmutableSet.Factory<T> get_context(final ProgramStatePartialTraitImmutableSet$T $Trait) {
    Object/*void P*/ p = FindGDMContext($Trait.GDMIndex(), 
        (BumpPtrAllocatorImpl Alloc) -> { return $Trait.CreateContext(Alloc); }, 
        (Object /*void P*/ Ctx) -> { $Trait.DeleteContext(Ctx); });
    
    return $Trait.MakeContext(p);
  }
  public </*typename*/ T>  ImmutableSetPtr.Factory<T> get_context(final ProgramStatePartialTraitImmutableSet$TP $Trait) {
    Object/*void P*/ p = FindGDMContext($Trait.GDMIndex(), 
        (BumpPtrAllocatorImpl Alloc) -> { return $Trait.CreateContext(Alloc); }, 
        (Object /*void P*/ Ctx) -> { $Trait.DeleteContext(Ctx); });
    
    return $Trait.MakeContext(p);
  }
  public </*typename*/ T>  ImmutableListFactory<T> get_context(final ProgramStatePartialTraitImmutableList$T $Trait) {
    Object/*void P*/ p = FindGDMContext($Trait.GDMIndex(), 
        (BumpPtrAllocatorImpl Alloc) -> { return $Trait.CreateContext(Alloc); }, 
        (Object /*void P*/ Ctx) -> { $Trait.DeleteContext(Ctx); });
    
    return $Trait.MakeContext(p);
  }
  public </*typename*/ K, V extends FoldingSetTrait.Profilable>  ImmutableMapPtrType.Factory<K, V> get_context(final ProgramStatePartialTraitImmutableMapPtrType<K, V> $Trait) {
    Object/*void P*/ p = FindGDMContext($Trait.GDMIndex(), 
        (BumpPtrAllocatorImpl Alloc) -> { return $Trait.CreateContext(Alloc); }, 
        (Object /*void P*/ Ctx) -> { $Trait.DeleteContext(Ctx); });
    
    return $Trait.MakeContext(p);
  }
  public </*typename*/ K, V>  ImmutableMapPtrPtr.Factory<K, V> get_context(final ProgramStatePartialTraitImmutableMapPtrPtr<K, V> $Trait) {
    Object/*void P*/ p = FindGDMContext($Trait.GDMIndex(), 
        (BumpPtrAllocatorImpl Alloc) -> { return $Trait.CreateContext(Alloc); }, 
        (Object /*void P*/ Ctx) -> { $Trait.DeleteContext(Ctx); });
    
    return $Trait.MakeContext(p);
  }
  public </*typename*/ K>  ImmutableMapPtrUInt.Factory<K> get_context(final ProgramStatePartialTraitImmutableMapPtrUInt<K> $Trait) {
    Object/*void P*/ p = FindGDMContext($Trait.GDMIndex(), 
        (BumpPtrAllocatorImpl Alloc) -> { return $Trait.CreateContext(Alloc); }, 
        (Object /*void P*/ Ctx) -> { $Trait.DeleteContext(Ctx); });
    
    return $Trait.MakeContext(p);
  }
  public </*typename*/ K>  ImmutableMapPtrBool.Factory<K> get_context(final ProgramStatePartialTraitImmutableMapPtrBool<K> $Trait) {
    Object/*void P*/ p = FindGDMContext($Trait.GDMIndex(), 
        (BumpPtrAllocatorImpl Alloc) -> { return $Trait.CreateContext(Alloc); }, 
        (Object /*void P*/ Ctx) -> { $Trait.DeleteContext(Ctx); });
    
    return $Trait.MakeContext(p);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateManager::EndPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 623,
   FQN="clang::ento::ProgramStateManager::EndPath", NM="_ZN5clang4ento19ProgramStateManager7EndPathEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateManager7EndPathEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public void EndPath(IntrusiveRefCntPtr</*const*/ ProgramState> St) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ConstraintMgr.$arrow().EndPath($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "Eng=" + "[SubEngine]" // NOI18N
              + ", EnvMgr=" + "[EnvironmentManager]" // NOI18N
              + ", StoreMgr=" + "[Unique_ptr$StoreManager]" // NOI18N
              + ", ConstraintMgr=" + "[Unique_ptr$ConstraintManager]" // NOI18N
              + ", GDMFactory=" + GDMFactory // NOI18N
              + ", GDMContexts=" + GDMContexts // NOI18N
              + ", StateSet=" + StateSet // NOI18N
              + ", svalBuilder=" + "[Unique_ptr$SValBuilder]" // NOI18N
              + ", CallEventMgr=" + "[Unique_ptr$CallEventManager]" // NOI18N
              + ", Alloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", freeStates=" + freeStates; // NOI18N
  }
}
