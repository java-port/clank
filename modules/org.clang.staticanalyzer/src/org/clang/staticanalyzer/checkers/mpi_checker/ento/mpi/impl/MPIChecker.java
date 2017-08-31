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

package org.clang.staticanalyzer.checkers.mpi_checker.ento.mpi.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.checkers.mpi_checker.ento.impl.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.CheckBase;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.h", line = 31,
 FQN="clang::ento::mpi::MPIChecker", NM="_ZN5clang4ento3mpi10MPICheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento3mpi10MPICheckerE")
//</editor-fold>
public class MPIChecker extends /*public*/ Checker/*<PreCall, DeadSymbols>*/ 
        implements org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::MPIChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.h", line = 33,
   FQN="clang::ento::mpi::MPIChecker::MPIChecker", NM="_ZN5clang4ento3mpi10MPICheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento3mpi10MPICheckerC1Ev")
  //</editor-fold>
  public MPIChecker() {
    // : Checker<PreCall, DeadSymbols>(), FuncClassifier(), BReporter(*this) 
    //START JInit
    super();
    this.FuncClassifier = new std.unique_ptr<MPIFunctionClassifier>();
    this.BReporter = new MPIBugReporter(/*Deref*/this);
    //END JInit
  }

  
  // path-sensitive callbacks
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::checkPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.h", line = 36,
   FQN="clang::ento::mpi::MPIChecker::checkPreCall", NM="_ZNK5clang4ento3mpi10MPIChecker12checkPreCallERKNS0_9CallEventERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi10MPIChecker12checkPreCallERKNS0_9CallEventERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ CE, final CheckerContext /*&*/ Ctx) /*const*/ {
    dynamicInit(Ctx);
    checkUnmatchedWaits(CE, Ctx);
    checkDoubleNonblocking(CE, Ctx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.h", line = 42,
   FQN="clang::ento::mpi::MPIChecker::checkDeadSymbols", NM="_ZNK5clang4ento3mpi10MPIChecker16checkDeadSymbolsERNS0_12SymbolReaperERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi10MPIChecker16checkDeadSymbolsERNS0_12SymbolReaperERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SymReaper, final CheckerContext /*&*/ Ctx) /*const*/ {
    dynamicInit(Ctx);
    checkMissingWaits(SymReaper, Ctx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::dynamicInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.h", line = 47,
   FQN="clang::ento::mpi::MPIChecker::dynamicInit", NM="_ZNK5clang4ento3mpi10MPIChecker11dynamicInitERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi10MPIChecker11dynamicInitERNS0_14CheckerContextE")
  //</editor-fold>
  public void dynamicInit(final CheckerContext /*&*/ Ctx) /*const*/ {
    if (FuncClassifier.$bool()) {
      return;
    }
    ((/*const_cast*/std.unique_ptr<MPIFunctionClassifier> /*&*/ )(FuncClassifier)).
        reset(/*{ */new MPIFunctionClassifier(Ctx.getASTContext())/* }*/);
  }

  
  /// Checks if a request is used by nonblocking calls multiple times
  /// in sequence without intermediate wait. The check contains a guard,
  /// in order to only inspect nonblocking functions.
  ///
  /// \param PreCallEvent MPI call to verify
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::checkDoubleNonblocking">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp", line = 25,
   FQN="clang::ento::mpi::MPIChecker::checkDoubleNonblocking", NM="_ZNK5clang4ento3mpi10MPIChecker22checkDoubleNonblockingERKNS0_9CallEventERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi10MPIChecker22checkDoubleNonblockingERKNS0_9CallEventERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkDoubleNonblocking(final /*const*/ CallEvent /*&*/ PreCallEvent, 
                        final CheckerContext /*&*/ Ctx) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      if (!FuncClassifier.$arrow().isNonBlockingType(PreCallEvent.getCalleeIdentifier())) {
        return;
      }
      /*const*/ MemRegion /*P*/ /*const*/ MR = PreCallEvent.getArgSVal(PreCallEvent.getNumArgs() - 1).getAsRegion();
      if (!(MR != null)) {
        return;
      }
      /*const*/ ElementRegion /*P*/ /*const*/ ER = dyn_cast_ElementRegion(MR);

      // The region must be typed, in order to reason about it.
      if (!isa_TypedRegion(MR) || ((ER != null) && !isa_TypedRegion(ER.getSuperRegion()))) {
        return;
      }

      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Ctx.getState());
      /*const*/ Request /*P*/ /*const*/ Req = State.$arrow().get(ProgramStateTraitRequestMap.$Instance, MR);

      // double nonblocking detected
      if ((Req != null) && Req.CurrentState == Request.State.Nonblocking) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ExplodedNode /*P*/ ErrorNode = Ctx.generateNonFatalErrorNode();
          BReporter.reportDoubleNonblocking(PreCallEvent, $Deref(Req), MR, ErrorNode, Ctx.getBugReporter());
          $c$.clean(Ctx.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(ErrorNode.getState())), ErrorNode));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitRequestMap.$Instance, MR, new Request(Request.State.Nonblocking)))));
          $c$.clean(Ctx.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  
  /// Checks if a request is used by a wait multiple times in sequence without
  /// intermediate nonblocking call or if the request used by the wait
  /// function was not used at all before. The check contains a guard,
  /// in order to only inspect wait functions.
  ///
  /// \param PreCallEvent MPI call to verify
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::checkUnmatchedWaits">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp", line = 56,
   FQN="clang::ento::mpi::MPIChecker::checkUnmatchedWaits", NM="_ZNK5clang4ento3mpi10MPIChecker19checkUnmatchedWaitsERKNS0_9CallEventERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi10MPIChecker19checkUnmatchedWaitsERKNS0_9CallEventERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkUnmatchedWaits(final /*const*/ CallEvent /*&*/ PreCallEvent, 
                     final CheckerContext /*&*/ Ctx) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      if (!FuncClassifier.$arrow().isWaitType(PreCallEvent.getCalleeIdentifier())) {
        return;
      }
      /*const*/ MemRegion /*P*/ /*const*/ MR = topRegionUsedByWait(PreCallEvent);
      if (!(MR != null)) {
        return;
      }
      /*const*/ ElementRegion /*P*/ /*const*/ ER = dyn_cast_ElementRegion(MR);

      // The region must be typed, in order to reason about it.
      if (!isa_TypedRegion(MR) || ((ER != null) && !isa_TypedRegion(ER.getSuperRegion()))) {
        return;
      }

      SmallVector</*const*/ MemRegion /*P*/ > ReqRegions/*J*/= new SmallVector</*const*/ MemRegion /*P*/ >(2, (/*const*/ MemRegion /*P*/ )null);
      allRegionsUsedByWait(ReqRegions, MR, PreCallEvent, Ctx);
      if (ReqRegions.empty()) {
        return;
      }

      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Ctx.getState());
      final/*static*/ CheckerProgramPointTag Tag = checkUnmatchedWaits$$.Tag;
      ExplodedNode /*P*/ ErrorNode/*J*/= (ExplodedNode /*P*/ )null;

      // Check all request regions used by the wait function.
      for (final /*const*/ MemRegion /*P*/ /*const*/ /*&*/ ReqRegion : ReqRegions) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*const*/ Request /*P*/ /*const*/ Req = State.$arrow().get(ProgramStateTraitRequestMap.$Instance, ReqRegion);
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitRequestMap.$Instance, ReqRegion, new Request(Request.State.Wait)))));
          if (!(Req != null)) {
            if (!(ErrorNode != null)) {
              $c$.clean(ErrorNode = Ctx.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), $AddrOf(Tag)));
              $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(ErrorNode.getState()))));
            }
            // A wait has no matching nonblocking call.
            BReporter.reportUnmatchedWait(PreCallEvent, ReqRegion, ErrorNode, Ctx.getBugReporter());
          }
        } finally {
          $c$.$destroy();
        }
      }
      if (!(ErrorNode != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Ctx.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Ctx.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), ErrorNode));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }
  private static final class checkUnmatchedWaits$$ {
    static final/*static*/ CheckerProgramPointTag Tag/*J*/= new CheckerProgramPointTag(new StringRef(/*KEEP_STR*/"MPI-Checker"), new StringRef(/*KEEP_STR*/"UnmatchedWait"));
  }

  
  /// Check if a nonblocking call is not matched by a wait.
  /// If a memory region is not alive and the last function using the
  /// request was a nonblocking call, this is rated as a missing wait.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::checkMissingWaits">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp", line = 99,
   FQN="clang::ento::mpi::MPIChecker::checkMissingWaits", NM="_ZNK5clang4ento3mpi10MPIChecker17checkMissingWaitsERNS0_12SymbolReaperERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi10MPIChecker17checkMissingWaitsERNS0_12SymbolReaperERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkMissingWaits(final SymbolReaper /*&*/ SymReaper, 
                   final CheckerContext /*&*/ Ctx) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    /*const*/ImmutableMapPtrType</*const*/ MemRegion /*P*/ , Request> /*&*/ Requests = null;
    ImmutableMapPtrType</*const*/ MemRegion /*P*/ , Request> ReqMap = null;
    try {
      if (!SymReaper.hasDeadSymbols()) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Ctx.getState());
      /*final */ Requests = State.$arrow()./*<RequestMap>*/get(ProgramStateTraitRequestMap.$Instance);
      if (Requests.isEmpty()) {
        return;
      }
      
      final/*static*/ CheckerProgramPointTag Tag = checkMissingWaits$$.Tag;
      ExplodedNode /*P*/ ErrorNode/*J*/= (ExplodedNode /*P*/ )null;
      
      ReqMap = State.$arrow()./*<RequestMap>*/get(ProgramStateTraitRequestMap.$Instance);
      for (final /*const*/ std.pairPtrType</*const*/ MemRegion /*P*/ , Request> /*&*/ Req : ReqMap) {
        if (!SymReaper.isLiveRegion(Req.first)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (Req.second.CurrentState == Request.State.Nonblocking) {
              if (!(ErrorNode != null)) {
                $c$.clean(ErrorNode = Ctx.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), $AddrOf(Tag)));
                $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(ErrorNode.getState()))));
              }
              BReporter.reportMissingWait(Req.second, Req.first, ErrorNode, Ctx.getBugReporter());
            }
            $c$.clean(State.$assign($c$.track(State.$arrow()./*<RequestMap>*/remove(ProgramStateTraitRequestMap.$Instance, Req.first))));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Transition to update the state regarding removed requests.
      if (!(ErrorNode != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Ctx.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Ctx.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), ErrorNode));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (ReqMap != null) { ReqMap.$destroy(); }
      if (Requests != null) { Requests.$destroy(); }
      if (State != null) { State.$destroy(); }
    }
  }
  private static final class checkMissingWaits$$ {
    static final/*static*/ CheckerProgramPointTag Tag/*J*/= new CheckerProgramPointTag(new StringRef(/*KEEP_STR*/"MPI-Checker"), new StringRef(/*KEEP_STR*/"MissingWait"));
  }

/*private:*/
  /// Collects all memory regions of a request(array) used by a wait
  /// function. If the wait function uses a single request, this is a single
  /// region. For wait functions using multiple requests, multiple regions
  /// representing elements in the array are collected.
  ///
  /// \param ReqRegions vector the regions get pushed into
  /// \param MR top most region to iterate
  /// \param CE MPI wait call using the request(s)
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::allRegionsUsedByWait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp", line = 146,
   FQN="clang::ento::mpi::MPIChecker::allRegionsUsedByWait", NM="_ZNK5clang4ento3mpi10MPIChecker20allRegionsUsedByWaitERN4llvm11SmallVectorIPKNS0_9MemRegionELj2EEES7_RKNS0_9CallEventERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi10MPIChecker20allRegionsUsedByWaitERN4llvm11SmallVectorIPKNS0_9MemRegionELj2EEES7_RKNS0_9CallEventERNS0_14CheckerContextE")
  //</editor-fold>
  private void allRegionsUsedByWait(final SmallVector</*const*/ MemRegion /*P*/ > /*&*/ ReqRegions, 
                      /*const*/ MemRegion /*P*/ /*const*/ MR, final /*const*/ CallEvent /*&*/ CE, final CheckerContext /*&*/ Ctx) /*const*/ {
    
    MemRegionManager /*P*/ /*const*/ RegionManager = MR.getMemRegionManager();
    if (FuncClassifier.$arrow().isMPI_Waitall(CE.getCalleeIdentifier())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ MemRegion /*P*/ SuperRegion/*J*/= (/*const*/ MemRegion /*P*/ )null;
        {
          /*const*/ ElementRegion /*P*/ /*const*/ ER = MR.getAs(ElementRegion.class);
          if ((ER != null)) {
            SuperRegion = ER.getSuperRegion();
          }
        }
        
        // A single request is passed to MPI_Waitall.
        if (!(SuperRegion != null)) {
          ReqRegions.push_back(MR);
          return;
        }
        
        final /*const*/ DefinedOrUnknownSVal /*&*/ Size = $c$.clean(Ctx.getStoreManager().getSizeInElements($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Ctx.getState())), SuperRegion, 
            CE.getArgExpr(1).getType().$arrow().getPointeeType()));
        final /*const*/ APSInt /*&*/ ArrSize = Size.getAs(NsNonloc.ConcreteInt.class).$arrow().getValue();
        
        for (/*size_t*/int i = 0; $less_long_APSInt$C($uint2long(i), ArrSize); ++i) {
          /*const*/ NonLoc Idx = Ctx.getSValBuilder().makeArrayIndex($uint2ulong(i));
          
          /*const*/ ElementRegion /*P*/ /*const*/ ER = RegionManager.getElementRegion(CE.getArgExpr(1).getType().$arrow().getPointeeType(), new NonLoc(Idx), SuperRegion, 
              Ctx.getASTContext());
          
          ReqRegions.push_back(ER.getAs(MemRegion.class));
        }
      } finally {
        $c$.$destroy();
      }
    } else if (FuncClassifier.$arrow().isMPI_Wait(CE.getCalleeIdentifier())) {
      ReqRegions.push_back(MR);
    }
  }
  
  
  /// Returns the memory region used by a wait function.
  /// Distinguishes between MPI_Wait and MPI_Waitall.
  ///
  /// \param CE MPI wait call
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::topRegionUsedByWait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp", line = 135,
   FQN="clang::ento::mpi::MPIChecker::topRegionUsedByWait", NM="_ZNK5clang4ento3mpi10MPIChecker19topRegionUsedByWaitERKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi10MPIChecker19topRegionUsedByWaitERKNS0_9CallEventE")
  //</editor-fold>
  private /*const*/ MemRegion /*P*/ topRegionUsedByWait(final /*const*/ CallEvent /*&*/ CE) /*const*/ {
    if (FuncClassifier.$arrow().isMPI_Wait(CE.getCalleeIdentifier())) {
      return CE.getArgSVal(0).getAsRegion();
    } else if (FuncClassifier.$arrow().isMPI_Waitall(CE.getCalleeIdentifier())) {
      return CE.getArgSVal(1).getAsRegion();
    } else {
      return (/*const*/ MemRegion /*P*/ )null;
    }
  }

  
  private /*const*/ std.unique_ptr<MPIFunctionClassifier> FuncClassifier;
  private MPIBugReporter BReporter;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIChecker::~MPIChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.h", line = 31,
   FQN="clang::ento::mpi::MPIChecker::~MPIChecker", NM="_ZN5clang4ento3mpi10MPICheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento3mpi10MPICheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BReporter.$destroy();
    FuncClassifier.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new PreCall(),
    new DeadSymbols()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "FuncClassifier=" + FuncClassifier // NOI18N
              + ", BReporter=" + BReporter // NOI18N
              + super.toString(); // NOI18N
  }
}
