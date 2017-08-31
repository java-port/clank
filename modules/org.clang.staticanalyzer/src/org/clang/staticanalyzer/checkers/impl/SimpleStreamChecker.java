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

package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;
import org.clang.staticanalyzer.checkers.ento.impl.SimpleStreamCheckerStatics.ProgramStateTraitStreamMap;
import org.clang.staticanalyzer.checkers.impl.SimpleStreamCheckerStatics.StreamState;
import static org.clang.staticanalyzer.checkers.impl.SimpleStreamCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 51,
 FQN="(anonymous namespace)::SimpleStreamChecker", NM="_ZN12_GLOBAL__N_119SimpleStreamCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_119SimpleStreamCheckerE")
//</editor-fold>
public class SimpleStreamChecker extends /*public*/ Checker/*<PostCall, PreCall, DeadSymbols, PointerEscape>*/ 
        implements org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostCallChecker, org.clang.staticanalyzer.java.PointerEscapeChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor {
  private CallDescription OpenFn;
  private CallDescription CloseFn;
  
  private std.unique_ptr<BugType> DoubleCloseBugType;
  private std.unique_ptr<BugType> LeakBugType;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::reportDoubleClose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 200,
   FQN="(anonymous namespace)::SimpleStreamChecker::reportDoubleClose", NM="_ZNK12_GLOBAL__N_119SimpleStreamChecker17reportDoubleCloseEPKN5clang4ento7SymExprERKNS2_9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_119SimpleStreamChecker17reportDoubleCloseEPKN5clang4ento7SymExprERKNS2_9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  private void reportDoubleClose(/*const*/ SymExpr /*P*/ FileDescSym, 
                   final /*const*/ CallEvent /*&*/ Call, 
                   final CheckerContext /*&*/ C) /*const*/ {
    unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We reached a bug, stop exploring the path here by generating a sink.
      ExplodedNode /*P*/ ErrNode = C.generateErrorNode();
      // If we've already reached this node on another path, return.
      if (!(ErrNode != null)) {
        return;
      }
      
      // Generate the report.
      R = llvm.make_unique(new BugReport(DoubleCloseBugType.$star(), 
          $("Closing a previously closed file stream"), ErrNode));
      R.$arrow().addRange(Call.getSourceRange());
      R.$arrow().markInteresting(FileDescSym);
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::reportLeaks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 217,
   FQN="(anonymous namespace)::SimpleStreamChecker::reportLeaks", NM="_ZNK12_GLOBAL__N_119SimpleStreamChecker11reportLeaksEN4llvm8ArrayRefIPKN5clang4ento7SymExprEEERNS4_14CheckerContextEPNS4_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_119SimpleStreamChecker11reportLeaksEN4llvm8ArrayRefIPKN5clang4ento7SymExprEEERNS4_14CheckerContextEPNS4_12ExplodedNodeE")
  //</editor-fold>
  private void reportLeaks(ArrayRef</*const*/ SymExpr /*P*/ > LeakedStreams, 
             final CheckerContext /*&*/ C, 
             ExplodedNode /*P*/ ErrNode) /*const*/ {
    // Attach bug reports to the leak node.
    // TODO: Identify the leaked file descriptor.
    for (/*const*/ SymExpr /*P*/ LeakedStream : LeakedStreams) {
      unique_ptr<BugReport> R = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        R = llvm.make_unique(new BugReport(LeakBugType.$star(), 
            $("Opened file is never closed; potential resource leak"), ErrNode));
        R.$arrow().markInteresting(LeakedStream);
        C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
      } finally {
        if (R != null) { R.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::guaranteedNotToCloseFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 230,
   FQN="(anonymous namespace)::SimpleStreamChecker::guaranteedNotToCloseFile", NM="_ZNK12_GLOBAL__N_119SimpleStreamChecker24guaranteedNotToCloseFileERKN5clang4ento9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_119SimpleStreamChecker24guaranteedNotToCloseFileERKN5clang4ento9CallEventE")
  //</editor-fold>
  private boolean guaranteedNotToCloseFile(final /*const*/ CallEvent /*&*/ Call) /*const*/ {
    // If it's not in a system header, assume it might close a file.
    if (!Call.isInSystemHeader()) {
      return false;
    }
    
    // Handle cases where we know a buffer's /address/ can escape.
    if (Call.argumentsMayEscape()) {
      return false;
    }
    
    // Note, even though fclose closes the file, we do not list it here
    // since the checker is modeling the call.
    return true;
  }

/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::SimpleStreamChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 106,
   FQN="(anonymous namespace)::SimpleStreamChecker::SimpleStreamChecker", NM="_ZN12_GLOBAL__N_119SimpleStreamCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_119SimpleStreamCheckerC1Ev")
  //</editor-fold>
  public SimpleStreamChecker() {
    // : Checker<PostCall, PreCall, DeadSymbols, PointerEscape>(), OpenFn("fopen"), CloseFn("fclose", 1), DoubleCloseBugType(), LeakBugType() 
    //START JInit
    super();
    this.OpenFn = new CallDescription(new StringRef(/*KEEP_STR*/"fopen"));
    this.CloseFn = new CallDescription(new StringRef(/*KEEP_STR*/"fclose"), 1);
    this.DoubleCloseBugType = new std.unique_ptr<BugType>();
    this.LeakBugType = new std.unique_ptr<BugType>();
    //END JInit
    // Initialize the bug types.
    DoubleCloseBugType.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Double fclose"), new StringRef(/*KEEP_STR*/"Unix Stream API Error")));
    
    LeakBugType.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Resource Leak"), new StringRef(/*KEEP_STR*/"Unix Stream API Error")));
    // Sinks are higher importance bugs as well as calls to assert() or exit(0).
    LeakBugType.$arrow().setSuppressOnSink(true);
  }

  
  /// Process fopen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::checkPostCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 118,
   FQN="(anonymous namespace)::SimpleStreamChecker::checkPostCall", NM="_ZNK12_GLOBAL__N_119SimpleStreamChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_119SimpleStreamChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ Call, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Call.isGlobalCFunction()) {
        return;
      }
      if (!Call.isCalled(OpenFn)) {
        return;
      }
      
      // Get the symbolic value corresponding to the file handle.
      /*const*/ SymExpr /*P*/ FileDesc = Call.getReturnValue().getAsSymbol();
      if (!(FileDesc != null)) {
        return;
      }
      
      // Generate the next transition (an edge in the exploded graph).
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitStreamMap.$Instance, FileDesc, StreamState.getOpened()))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  /// Process fclose.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::checkPreCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 137,
   FQN="(anonymous namespace)::SimpleStreamChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_119SimpleStreamChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_119SimpleStreamChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Call.isGlobalCFunction()) {
        return;
      }
      if (!Call.isCalled(CloseFn)) {
        return;
      }
      
      // Get the symbolic value corresponding to the file handle.
      /*const*/ SymExpr /*P*/ FileDesc = Call.getArgSVal(0).getAsSymbol();
      if (!(FileDesc != null)) {
        return;
      }
      
      // Check if the stream has already been closed.
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ StreamState /*P*/ SS = State.$arrow().get(ProgramStateTraitStreamMap.$Instance, FileDesc);
      if ((SS != null) && SS.isClosed()) {
        reportDoubleClose(FileDesc, Call, C);
        return;
      }
      
      // Generate the next transition, in which the stream is closed.
      $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitStreamMap.$Instance, FileDesc, StreamState.getClosed()))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 175,
   FQN="(anonymous namespace)::SimpleStreamChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_119SimpleStreamChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_119SimpleStreamChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SymReaper, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , StreamState> TrackedStreams = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SmallVector</*const*/ SymExpr /*P*/ > LeakedStreams/*J*/= new SmallVector</*const*/ SymExpr /*P*/ >(2, (/*const*/ SymExpr /*P*/ )null);
      TrackedStreams = State.$arrow().get(ProgramStateTraitStreamMap.$Instance);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , StreamState> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , StreamState> E = null;
      try {
        for (I = TrackedStreams.begin(), 
            E = TrackedStreams.end(); I.$noteq(E); I.$preInc()) {
          /*const*/ SymExpr /*P*/ Sym = I.$arrow().first;
          boolean IsSymDead = SymReaper.isDead(Sym);
          
          // Collect leaked symbols.
          if ($c$.clean(SimpleStreamCheckerStatics.isLeaked(Sym, I.$arrow().second, IsSymDead, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))) {
            LeakedStreams.push_back(Sym);
          }
          
          // Remove the dead symbol from the streams map.
          if (IsSymDead) {
            $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitStreamMap.$Instance, Sym))));
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      if (!(N != null)) {
        return;
      }
      reportLeaks(new ArrayRef</*const*/ SymExpr /*P*/ >(LeakedStreams, true), C, N);
    } finally {
      if (TrackedStreams != null) { TrackedStreams.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Stop tracking addresses which escape.
  
  // If the pointer we are tracking escaped, do not track the symbol as
  // we cannot reason about it anymore.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::checkPointerEscape">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 247,
   FQN="(anonymous namespace)::SimpleStreamChecker::checkPointerEscape", NM="_ZNK12_GLOBAL__N_119SimpleStreamChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_119SimpleStreamChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                    /*const*/ CallEvent /*P*/ Call, 
                    PointerEscapeKind Kind) /*const*/ {
    // If we know that the call cannot close a file, there is nothing to do.
    if (Kind == PointerEscapeKind.PSK_DirectEscapeOnCall && guaranteedNotToCloseFile($Deref(Call))) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    }
    
    for (DenseSet.iterator<SymExpr> I = Escaped.begin$Const(), 
        E = Escaped.end$Const();
         I.$noteq(E); I.$preInc()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ SymExpr /*P*/ Sym = I.$star();
        
        // The symbol escaped. Optimistically, assume that the corresponding file
        // handle will be closed somewhere else.
        $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitStreamMap.$Instance, Sym))));
      } finally {
        $c$.$destroy();
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleStreamChecker::~SimpleStreamChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 51,
   FQN="(anonymous namespace)::SimpleStreamChecker::~SimpleStreamChecker", NM="_ZN12_GLOBAL__N_119SimpleStreamCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_119SimpleStreamCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    LeakBugType.$destroy();
    DoubleCloseBugType.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new PostCall(),
    new PreCall(),
    new DeadSymbols(),
    new PointerEscape()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "OpenFn=" + OpenFn // NOI18N
              + ", CloseFn=" + CloseFn // NOI18N
              + ", DoubleCloseBugType=" + DoubleCloseBugType // NOI18N
              + ", LeakBugType=" + LeakBugType // NOI18N
              + super.toString(); // NOI18N
  }
}
