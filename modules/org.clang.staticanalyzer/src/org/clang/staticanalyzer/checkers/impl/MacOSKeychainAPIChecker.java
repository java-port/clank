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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 29,
 FQN="(anonymous namespace)::MacOSKeychainAPIChecker", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPICheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPICheckerE")
//</editor-fold>
public class MacOSKeychainAPIChecker extends /*public*/ Checker/*<org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>, org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>, DeadSymbols>*/ 
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
/*public:*/
  /// AllocationState is a part of the checker specific state together with the
  /// MemRegion corresponding to the allocated data.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 37,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateE")
  //</editor-fold>
  public static class/*struct*/ AllocationState implements FoldingSetTrait.Profilable, NativeCloneable<AllocationState>, Native.NativeComparable<AllocationState> {
    /// The index of the allocator function.
    public /*uint*/int AllocatorIdx;
    public /*const*/ SymExpr /*P*/ Region;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::AllocationState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 42,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::AllocationState", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateC1EPKN5clang4ExprEjPKNS2_4ento7SymExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateC1EPKN5clang4ExprEjPKNS2_4ento7SymExprE")
    //</editor-fold>
    public AllocationState(/*const*/ Expr /*P*/ E, /*uint*/int Idx, /*const*/ SymExpr /*P*/ R) {
      // : AllocatorIdx(Idx), Region(R) 
      //START JInit
      this.AllocatorIdx = Idx;
      this.Region = R;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 46,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::operator==", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateeqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateeqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ AllocationState /*&*/ X) /*const*/ {
      return (AllocatorIdx == X.AllocatorIdx
         && Region == X.Region);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::Profile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 51,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::Profile", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationState7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationState7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    @Override public/*public*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
      ID.AddInteger_uint(AllocatorIdx);
      ID.AddPointer(Region);
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::AllocationState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 37,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::AllocationState", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateC1ERKS1_")
    //</editor-fold>
    public /*inline*/ AllocationState(final /*const*/ AllocationState /*&*/ $Prm0) {
      // : AllocatorIdx(.AllocatorIdx), Region(.Region) 
      //START JInit
      this.AllocatorIdx = $Prm0.AllocatorIdx;
      this.Region = $Prm0.Region;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::AllocationState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 37,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::AllocationState::AllocationState", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker15AllocationStateC1EOS1_")
    //</editor-fold>
    public /*inline*/ AllocationState(JD$Move _dparam, final AllocationState /*&&*/$Prm0) {
      // : AllocatorIdx(static_cast<AllocationState &&>().AllocatorIdx), Region(static_cast<AllocationState &&>().Region) 
      //START JInit
      this.AllocatorIdx = $Prm0.AllocatorIdx;
      this.Region = $Prm0.Region;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public AllocationState clone() { return new AllocationState(this); }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "AllocatorIdx=" + AllocatorIdx // NOI18N
                + ", Region=" + "[SymExpr]"; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 269,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int idx = InvalidIdx;
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
      if (!(FD != null) || FD.getKind() != Decl.Kind.Function) {
        return;
      }
      
      StringRef funName = C.getCalleeName(FD);
      if (funName.empty()) {
        return;
      }
      
      // If it is a call to an allocator function, it could be a double allocation.
      idx = getTrackedFunctionIndex(new StringRef(funName), true);
      if (idx != InvalidIdx) {
        /*uint*/int paramIdx = FunctionsToTrack[idx].Param;
        if ($lesseq_uint(CE.getNumArgs(), paramIdx)) {
          return;
        }
        
        /*const*/ Expr /*P*/ ArgExpr = CE.getArg$Const(paramIdx);
        {
          /*const*/ SymExpr /*P*/ V = MacOSKeychainAPICheckerStatics.getAsPointeeSymbol(ArgExpr, C);
          if ((V != null)) {
            {
              /*const*/ AllocationState /*P*/ AS = State.$arrow().get(ProgramStateTraitAllocatedData.$Instance, V);
              if ((AS != null)) {
                if ($c$.clean(!definitelyReturnedError(AS.Region, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C.getSValBuilder()))) {
                  raw_svector_ostream os = null;
                  unique_ptr<BugReport> Report = null;
                  try {
                    // Remove the value from the state. The new symbol will be added for
                    // tracking when the second allocator is processed in checkPostStmt().
                    $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitAllocatedData.$Instance, V))));
                    ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
                    if (!(N != null)) {
                      return;
                    }
                    initBugType();
                    SmallString/*<128>*/ sbuf/*J*/= new SmallString/*<128>*/(128);
                    os/*J*/= new raw_svector_ostream(sbuf);
                    /*uint*/int DIdx = FunctionsToTrack[AS.AllocatorIdx].DeallocatorIdx;
                    os.$out(/*KEEP_STR*/"Allocated data should be released before another call to ").$out(
                        /*KEEP_STR*/"the allocator: missing a call to '"
                    ).$out(
                        FunctionsToTrack[DIdx].Name
                    ).$out(
                        /*KEEP_STR*/"'."
                    );
                    Report = llvm.make_unique(new BugReport(BT.$star(), os.str(), N));
                    Report.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new SecKeychainBugVisitor(V)))))); $c$.clean();
                    Report.$arrow().addRange(ArgExpr.getSourceRange());
                    Report.$arrow().markInteresting(AS.Region);
                    C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
                  } finally {
                    if (Report != null) { Report.$destroy(); }
                    if (os != null) { os.$destroy(); }
                  }
                }
              }
            }
          }
        }
        return;
      }
      
      // Is it a call to one of deallocator functions?
      idx = getTrackedFunctionIndex(new StringRef(funName), false);
      if (idx == InvalidIdx) {
        return;
      }
      
      /*uint*/int paramIdx = FunctionsToTrack[idx].Param;
      if ($lesseq_uint(CE.getNumArgs(), paramIdx)) {
        return;
      }
      
      // Check the argument to the deallocator.
      /*const*/ Expr /*P*/ ArgExpr = CE.getArg$Const(paramIdx);
      SVal ArgSVal = State.$arrow().getSVal(ArgExpr, C.getLocationContext());
      
      // Undef is reported by another checker.
      if (ArgSVal.isUndef$SVal()) {
        return;
      }
      
      /*const*/ SymExpr /*P*/ ArgSM = ArgSVal.getAsLocSymbol();
      
      // If the argument is coming from the heap, globals, or unknown, do not
      // report it.
      boolean RegionArgIsBad = false;
      if (!(ArgSM != null)) {
        if (!MacOSKeychainAPICheckerStatics.isBadDeallocationArgument(ArgSVal.getAsRegion())) {
          return;
        }
        RegionArgIsBad = true;
      }
      
      // Is the argument to the call being tracked?
      /*const*/ AllocationState /*P*/ AS = State.$arrow().get(ProgramStateTraitAllocatedData.$Instance, ArgSM);
      if (!(AS != null) && FunctionsToTrack[idx].Kind != APIKind.ValidAPI) {
        return;
      }
      // If trying to free data which has not been allocated yet, report as a bug.
      // TODO: We might want a more precise diagnostic for double free
      // (that would involve tracking all the freed symbols in the checker state).
      if (!(AS != null) || RegionArgIsBad) {
        unique_ptr<BugReport> Report = null;
        try {
          // It is possible that this is a false positive - the argument might
          // have entered as an enclosing function parameter.
          if (MacOSKeychainAPICheckerStatics.isEnclosingFunctionParam(ArgExpr)) {
            return;
          }
          
          ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          if (!(N != null)) {
            return;
          }
          initBugType();
          Report = llvm.make_unique(new BugReport(BT.$star(), $("Trying to free data which has not been allocated."), N));
          Report.$arrow().addRange(ArgExpr.getSourceRange());
          if ((AS != null)) {
            Report.$arrow().markInteresting(AS.Region);
          }
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
          return;
        } finally {
          if (Report != null) { Report.$destroy(); }
        }
      }
      
      // Process functions which might deallocate.
      if (FunctionsToTrack[idx].Kind == APIKind.PossibleAPI) {
        if ($eq_StringRef(/*NO_COPY*/funName, /*STRINGREF_STR*/"CFStringCreateWithBytesNoCopy")) {
          /*const*/ Expr /*P*/ DeallocatorExpr = CE.getArg$Const(5).IgnoreParenCasts$Const();
          // NULL ~ default deallocator, so warn.
          if ((DeallocatorExpr.isNullPointerConstant(C.getASTContext(), 
              Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)) {
            /*const*/std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ > AP = std.make_pair_Ptr_Ptr(ArgSM, AS);
            generateDeallocatorMismatchReport(AP, ArgExpr, C);
            return;
          }
          {
            // One of the default allocators, so warn.
            /*const*/ DeclRefExpr /*P*/ DE = dyn_cast_DeclRefExpr(DeallocatorExpr);
            if ((DE != null)) {
              StringRef DeallocatorName = DE.getFoundDecl$Const().getName();
              if ($eq_StringRef(/*NO_COPY*/DeallocatorName, /*STRINGREF_STR*/"kCFAllocatorDefault")
                 || $eq_StringRef(/*NO_COPY*/DeallocatorName, /*STRINGREF_STR*/"kCFAllocatorSystemDefault")
                 || $eq_StringRef(/*NO_COPY*/DeallocatorName, /*STRINGREF_STR*/"kCFAllocatorMalloc")) {
                /*const*/std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ > AP = std.make_pair_Ptr_Ptr(ArgSM, AS);
                generateDeallocatorMismatchReport(AP, ArgExpr, C);
                return;
              }
              // If kCFAllocatorNull, which does not deallocate, we still have to
              // find the deallocator.
              if ($eq_StringRef(DE.getFoundDecl$Const().getName(), /*STRINGREF_STR*/"kCFAllocatorNull")) {
                return;
              }
            }
          }
          // In all other cases, assume the user supplied a correct deallocator
          // that will free memory so stop tracking.
          $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitAllocatedData.$Instance, ArgSM))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          return;
        }
        throw new llvm_unreachable("We know of no other possible APIs.");
      }
      
      // The call is deallocating a value we previously allocated, so remove it
      // from the next state.
      $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitAllocatedData.$Instance, ArgSM))));
      
      // Check if the proper deallocator is used.
      /*uint*/int PDeallocIdx = FunctionsToTrack[AS.AllocatorIdx].DeallocatorIdx;
      if (PDeallocIdx != idx || (FunctionsToTrack[idx].Kind == APIKind.ErrorAPI)) {
        /*const*/std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ > AP = std.make_pair_Ptr_Ptr(ArgSM, AS);
        generateDeallocatorMismatchReport(AP, ArgExpr, C);
        return;
      }
      
      // If the buffer can be null and the return status can be an error,
      // report a bad call to free.
      if ($c$.clean($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(JD$Move.INSTANCE, ArgSVal.castAs(DefinedSVal.class)), false)).$bool()
         && !definitelyDidnotReturnError(AS.Region, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C.getSValBuilder()))) {
        unique_ptr<BugReport> Report = null;
        try {
          ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          if (!(N != null)) {
            return;
          }
          initBugType();
          Report = llvm.make_unique(new BugReport(BT.$star(), $("Only call free if a valid (non-NULL) buffer was returned."), N));
          Report.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new SecKeychainBugVisitor(ArgSM)))))); $c$.clean();
          Report.$arrow().addRange(ArgExpr.getSourceRange());
          Report.$arrow().markInteresting(AS.Region);
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
          return;
        } finally {
          if (Report != null) { Report.$destroy(); }
        }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 441,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CallExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
      if (!(FD != null) || FD.getKind() != Decl.Kind.Function) {
        return;
      }
      
      StringRef funName = C.getCalleeName(FD);
      
      // If a value has been allocated, add it to the set for tracking.
      /*uint*/int idx = getTrackedFunctionIndex(new StringRef(funName), true);
      if (idx == InvalidIdx) {
        return;
      }
      
      /*const*/ Expr /*P*/ ArgExpr = CE.getArg$Const(FunctionsToTrack[idx].Param);
      // If the argument entered as an enclosing function parameter, skip it to
      // avoid false positives.
      if (MacOSKeychainAPICheckerStatics.isEnclosingFunctionParam(ArgExpr)
         && C.getLocationContext().getParent() == null) {
        return;
      }
      {
        
        /*const*/ SymExpr /*P*/ V = MacOSKeychainAPICheckerStatics.getAsPointeeSymbol(ArgExpr, C);
        if ((V != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If the argument points to something that's not a symbolic region, it
            // can be:
            //  - unknown (cannot reason about it)
            //  - undefined (already reported by other checker)
            //  - constant (null - should not be tracked,
            //              other constant will generate a compiler warning)
            //  - goto (should be reported by other checker)
            
            // The call return value symbol should stay alive for as long as the
            // allocated value symbol, since our diagnostics depend on the value
            // returned by the call. Ex: Data should only be freed if noErr was
            // returned during allocation.)
            /*const*/ SymExpr /*P*/ RetStatusSymbol = State.$arrow().getSVal(CE, C.getLocationContext()).getAsSymbol();
            C.getSymbolManager().addSymbolDependency(V, RetStatusSymbol);
            
            // Track the allocated value in the checker state.
            $c$.clean(State.$assign($c$.track(State.$arrow()./*<AllocatedData>*/set(ProgramStateTraitAllocatedData.$Instance, V, new AllocationState(ArgExpr, idx, 
                        RetStatusSymbol)))));
            assert ((State).$bool());
            $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Tag is context dependent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 548,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SR, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , MacOSKeychainAPIChecker.AllocationState> ASet = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      ASet = State.$arrow().get(ProgramStateTraitAllocatedData.$Instance);
      if (ASet.isEmpty()) {
        return;
      }
      
      boolean Changed = false;
      SmallVector<std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ >> Errors/*J*/= new SmallVector<std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ >>(2, new std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ >());
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , MacOSKeychainAPIChecker.AllocationState> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , MacOSKeychainAPIChecker.AllocationState> E = null;
      try {
        for (I = ASet.begin(), E = ASet.end(); I.$noteq(E); I.$preInc()) {
          ConditionTruthVal AllocFailed = null;
          try {
            if (SR.isLive(I.$arrow().first)) {
              continue;
            }
            
            Changed = true;
            $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitAllocatedData.$Instance, I.$arrow().first))));
            // If the allocated symbol is null or if the allocation call might have
            // returned an error, do not report.
            final ConstraintManager /*&*/ CMgr = State.$arrow().getConstraintManager();
            AllocFailed = $c$.clean(CMgr.isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), I.getKey()));
            if ($c$.clean(AllocFailed.isConstrainedTrue()
               || definitelyReturnedError(I.$arrow().second.Region, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C.getSValBuilder()))) {
              continue;
            }
            Errors.push_back(std.make_pair_Ptr_Ptr(I.$arrow().first, $AddrOf(I.$arrow().second)));
          } finally {
            if (AllocFailed != null) { AllocFailed.$destroy(); }
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      if (!Changed) {
        // Generate the new, cleaned up state.
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      // JAVA: need to use accessor
      final/*static*/ CheckerProgramPointTag Tag = checkDeadSymbols$$.Tag();
      ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), $AddrOf(Tag)));
      if (!(N != null)) {
        return;
      }
      
      // Generate the error reports.
      for (final /*const*/std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ > /*&*/ P : Errors)  {
        C.emitReport($c$.track(generateAllocatedDataNotReleasedReport(P, N, C))); $c$.clean();
      }
      
      // Generate the new, cleaned up state.
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), N));
    } finally {
      if (ASet != null) { ASet.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }
  // MANUAL: moved below in extra members
//  private static final class checkDeadSymbols$$ {
//    // JAVA: must not be static
//    static /*static*/ CheckerProgramPointTag Tag/*J*/ = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"DeadSymbolsLeak"));
//  }

/*private:*/
  // JAVA: typedef std::pair<SymbolRef, const AllocationState *> AllocationPair
//  public final class AllocationPair extends std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ >{ };
  // JAVA: typedef SmallVector<AllocationPair, 2> AllocationPairVec
//  public final class AllocationPairVec extends SmallVector<std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ >>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::APIKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 65,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::APIKind", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker7APIKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker7APIKindE")
  //</editor-fold>
  private enum APIKind implements Native.NativeUIntEnum {
    /// Denotes functions tracked by this checker.
    ValidAPI(0),
    /// The functions commonly/mistakenly used in place of the given API.
    ErrorAPI(1),
    /// The functions which may allocate the data. These are tracked to reduce
    /// the false alarm rate.
    PossibleAPI(2);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static APIKind valueOf(int val) {
      APIKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final APIKind[] VALUES;
      private static final APIKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (APIKind kind : APIKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new APIKind[min < 0 ? (1-min) : 0];
        VALUES = new APIKind[max >= 0 ? (1+max) : 0];
        for (APIKind kind : APIKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private APIKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  /// Stores the information about the allocator and deallocator functions -
  /// these are the functions the checker is tracking.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::ADFunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 76,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::ADFunctionInfo", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker14ADFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker14ADFunctionInfoE")
  //</editor-fold>
  private static class/*struct*/ ADFunctionInfo {
    public /*const*/char$ptr/*char P*/ Name;
    public /*uint*/int Param;
    public /*uint*/int DeallocatorIdx;
    public APIKind Kind;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::ADFunctionInfo::ADFunctionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 76,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::ADFunctionInfo::ADFunctionInfo", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker14ADFunctionInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker14ADFunctionInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ADFunctionInfo(final /*const*/ ADFunctionInfo /*&*/ $Prm0) {
      // : Name(.Name), Param(.Param), DeallocatorIdx(.DeallocatorIdx), Kind(.Kind) 
      //START JInit
      this.Name = $tryClone($Prm0.Name);
      this.Param = $Prm0.Param;
      this.DeallocatorIdx = $Prm0.DeallocatorIdx;
      this.Kind = $Prm0.Kind;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public ADFunctionInfo(char$ptr Name, int Param, int DeallocatorIdx, APIKind Kind) {
      this.Name = Name;
      this.Param = Param;
      this.DeallocatorIdx = DeallocatorIdx;
      this.Kind = Kind;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Name=" + Name // NOI18N
                + ", Param=" + Param // NOI18N
                + ", DeallocatorIdx=" + DeallocatorIdx // NOI18N
                + ", Kind=" + Kind; // NOI18N
    }
  };
  private static /*const*//*uint*/int InvalidIdx = 100000;
  private static /*const*//*uint*/int FunctionsToTrackSize = 8;
  private static /*const*/ ADFunctionInfo FunctionsToTrack[/*8*/] = new /*const*/ MacOSKeychainAPIChecker.ADFunctionInfo [/*8*/] {
    new MacOSKeychainAPIChecker.ADFunctionInfo($("SecKeychainItemCopyContent"), 4, 3, APIKind.ValidAPI),  // 0
    new MacOSKeychainAPIChecker.ADFunctionInfo($("SecKeychainFindGenericPassword"), 6, 3, APIKind.ValidAPI),  // 1
    new MacOSKeychainAPIChecker.ADFunctionInfo($("SecKeychainFindInternetPassword"), 13, 3, APIKind.ValidAPI),  // 2
    new MacOSKeychainAPIChecker.ADFunctionInfo($("SecKeychainItemFreeContent"), 1, InvalidIdx, APIKind.ValidAPI),  // 3
    new MacOSKeychainAPIChecker.ADFunctionInfo($("SecKeychainItemCopyAttributesAndData"), 5, 5, APIKind.ValidAPI),  // 4
    new MacOSKeychainAPIChecker.ADFunctionInfo($("SecKeychainItemFreeAttributesAndData"), 1, InvalidIdx, APIKind.ValidAPI),  // 5
    new MacOSKeychainAPIChecker.ADFunctionInfo($("free"), 0, InvalidIdx, APIKind.ErrorAPI),  // 6
    new MacOSKeychainAPIChecker.ADFunctionInfo($("CFStringCreateWithBytesNoCopy"), 1, InvalidIdx, APIKind.PossibleAPI) // 7
  };
  /// The value, which represents no error return value for allocator functions.
  private static /*const*//*uint*/int NoErr = 0;
  
  /// Given the function name, returns the index of the allocator/deallocator
  /// function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::getTrackedFunctionIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 183,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::getTrackedFunctionIndex", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker23getTrackedFunctionIndexEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker23getTrackedFunctionIndexEN4llvm9StringRefEb")
  //</editor-fold>
  private static /*uint*/int getTrackedFunctionIndex(StringRef Name, 
                         boolean IsAllocator) {
    for (/*uint*/int I = 0; $less_uint(I, FunctionsToTrackSize); ++I) {
      ADFunctionInfo FI = new ADFunctionInfo(FunctionsToTrack[I]);
      if ($noteq_StringRef(/*STRINGREF_STR*/FI.Name, /*NO_COPY*/Name)) {
        continue;
      }
      // Make sure the function is of the right type (allocator vs deallocator).
      if (IsAllocator && (FI.DeallocatorIdx == InvalidIdx)) {
        return InvalidIdx;
      }
      if (!IsAllocator && (FI.DeallocatorIdx != InvalidIdx)) {
        return InvalidIdx;
      }
      
      return I;
    }
    // The function is not tracked.
    return InvalidIdx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::initBugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 92,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::initBugType", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker11initBugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker11initBugTypeEv")
  //</editor-fold>
  private /*inline*/ void initBugType() /*const*/ {
    if (!BT.$bool()) {
      BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Improper use of SecKeychain API"), 
              new StringRef(/*KEEP_STR*/"API Misuse (Apple)")));
    }
  }

  
  
  // Report deallocator mismatch. Remove the region from tracking - reporting a
  // missing free error after this one is redundant.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::generateDeallocatorMismatchReport">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 244,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::generateDeallocatorMismatchReport", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker33generateDeallocatorMismatchReportERKSt4pairIPKN5clang4ento7SymExprEPKNS0_15AllocationStateEEPKNS2_4ExprERNS3_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker33generateDeallocatorMismatchReportERKSt4pairIPKN5clang4ento7SymExprEPKNS0_15AllocationStateEEPKNS2_4ExprERNS3_14CheckerContextE")
  //</editor-fold>
  private void generateDeallocatorMismatchReport(final /*const*/std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ > /*&*/ AP, 
                                   /*const*/ Expr /*P*/ ArgExpr, 
                                   final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    raw_svector_ostream os = null;
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitAllocatedData.$Instance, AP.first))));
      ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      if (!(N != null)) {
        return;
      }
      initBugType();
      SmallString/*<80>*/ sbuf/*J*/= new SmallString/*<80>*/(80);
      os/*J*/= new raw_svector_ostream(sbuf);
      /*uint*/int PDeallocIdx = FunctionsToTrack[AP.second.AllocatorIdx].DeallocatorIdx;
      
      os.$out(/*KEEP_STR*/"Deallocator doesn't match the allocator: '").$out(
          FunctionsToTrack[PDeallocIdx].Name
      ).$out(/*KEEP_STR*/"' should be used.");
      Report = llvm.make_unique(new BugReport(BT.$star(), os.str(), N));
      Report.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new SecKeychainBugVisitor(AP.first)))))); $c$.clean();
      Report.$arrow().addRange(ArgExpr.getSourceRange());
      markInteresting(Report.get(), AP);
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      if (os != null) { os.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Find the allocation site for Sym on the path leading to the node N.
  
  // TODO: This logic is the same as in Malloc checker.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::getAllocationNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 488,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::getAllocationNode", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker17getAllocationNodeEPKN5clang4ento12ExplodedNodeEPKNS2_7SymExprERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker17getAllocationNodeEPKN5clang4ento12ExplodedNodeEPKNS2_7SymExprERNS2_14CheckerContextE")
  //</editor-fold>
  private /*const*/ ExplodedNode /*P*/ getAllocationNode(/*const*/ ExplodedNode /*P*/ N, 
                   /*const*/ SymExpr /*P*/ Sym, 
                   final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ LocationContext /*P*/ LeakContext = N.getLocationContext();
    // Walk the ExplodedGraph backwards and find the first node that referred to
    // the tracked symbol.
    /*const*/ ExplodedNode /*P*/ AllocNode = N;
    while ((N != null)) {
      if (!(N.getState().$arrow().get(ProgramStateTraitAllocatedData.$Instance, Sym) != null)) {
        break;
      }
      // Allocation node, is the last node in the current or parent context in
      // which the symbol was tracked.
      /*const*/ LocationContext /*P*/ NContext = N.getLocationContext();
      if (NContext == LeakContext
         || NContext.isParentOf(LeakContext)) {
        AllocNode = N;
      }
      N = N.pred_empty() ? null : (N.pred_begin$Const()).$star();
    }
    
    return AllocNode;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::generateAllocatedDataNotReleasedReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 512,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::generateAllocatedDataNotReleasedReport", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker38generateAllocatedDataNotReleasedReportERKSt4pairIPKN5clang4ento7SymExprEPKNS0_15AllocationStateEEPNS3_12ExplodedNodeERNS3_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker38generateAllocatedDataNotReleasedReportERKSt4pairIPKN5clang4ento7SymExprEPKNS0_15AllocationStateEEPNS3_12ExplodedNodeERNS3_14CheckerContextE")
  //</editor-fold>
  private std.unique_ptr<BugReport> generateAllocatedDataNotReleasedReport(final /*const*/std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ > /*&*/ AP, ExplodedNode /*P*/ N, final CheckerContext /*&*/ C) /*const*/ {
    raw_svector_ostream os = null;
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final /*const*/ ADFunctionInfo /*&*/ FI = FunctionsToTrack[AP.second.AllocatorIdx];
      initBugType();
      SmallString/*<70>*/ sbuf/*J*/= new SmallString/*<70>*/(70);
      os/*J*/= new raw_svector_ostream(sbuf);
      os.$out(/*KEEP_STR*/"Allocated data is not released: missing a call to '").$out(
          FunctionsToTrack[FI.DeallocatorIdx].Name
      ).$out(/*KEEP_STR*/"'.");
      
      // Most bug reports are cached at the location where they occurred.
      // With leaks, we want to unique them by the location where they were
      // allocated, and only report a single path.
      PathDiagnosticLocation LocUsedForUniqueing/*J*/= new PathDiagnosticLocation();
      /*const*/ ExplodedNode /*P*/ AllocNode = getAllocationNode(N, AP.first, C);
      /*const*/ Stmt /*P*/ AllocStmt = null;
      ProgramPoint P = AllocNode.getLocation();
      {
        Optional<CallExitEnd> Exit = P.getAs(CallExitEnd.class);
        if (Exit.$bool()) {
          AllocStmt = Exit.$arrow().getCalleeContext().getCallSite();
        } else {
          Optional<org.clang.analysis.PostStmt> PS = P.getAs(org.clang.analysis.PostStmt.class);
          if (PS.$bool()) {
            AllocStmt = PS.$arrow().getStmt();
          }
        }
      }
      if ((AllocStmt != null)) {
        LocUsedForUniqueing.$assignMove(PathDiagnosticLocation.createBegin(AllocStmt, 
                C.getSourceManager(), 
                new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, AllocNode.getLocationContext())));
      }
      
      Report = llvm.make_unique(new BugReport(BT.$star(), os.str(), N, LocUsedForUniqueing, 
          AllocNode.getLocationContext().getDecl()));
      
      Report.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new SecKeychainBugVisitor(AP.first)))))); $c$.clean();
      markInteresting(Report.get(), AP);
      return new std.unique_ptr<BugReport>(JD$Move.INSTANCE, Report);
    } finally {
      if (Report != null) { Report.$destroy(); }
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Check if RetSym evaluates to an error value in the current state.
  
  // When checking for error code, we need to consider the following cases:
  // 1) noErr / [0]
  // 2) someErr / [1, inf]
  // 3) unknown
  // If noError, returns true iff (1).
  // If !noError, returns true iff (2).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::definitelyReturnedError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 230,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::definitelyReturnedError", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker23definitelyReturnedErrorEPKN5clang4ento7SymExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERNS2_11SValBuilderEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker23definitelyReturnedErrorEPKN5clang4ento7SymExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERNS2_11SValBuilderEb")
  //</editor-fold>
  private boolean definitelyReturnedError(/*const*/ SymExpr /*P*/ RetSym, 
                         IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                         final SValBuilder /*&*/ Builder) /*const*/ {
    return definitelyReturnedError(RetSym, 
                         State, 
                         Builder, 
                         false);
  }
  private boolean definitelyReturnedError(/*const*/ SymExpr /*P*/ RetSym, 
                         IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                         final SValBuilder /*&*/ Builder, 
                         boolean noError/*= false*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> ErrState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DefinedOrUnknownSVal NoErrVal = new DefinedOrUnknownSVal(JD$Move.INSTANCE, Builder.makeIntVal($uint2ulong(NoErr), 
              Builder.getSymbolManager().getType(RetSym)));
      DefinedOrUnknownSVal NoErr = $c$.clean(Builder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedOrUnknownSVal(NoErrVal), 
          new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(RetSym))));
      ErrState = State.$arrow().assume(new DefinedOrUnknownSVal(NoErr), noError);
      return $eq_IntrusiveRefCntPtr(ErrState, State);
    } finally {
      if (ErrState != null) { ErrState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Check if RetSym evaluates to a NoErr value in the current state.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::definitelyDidnotReturnError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 116,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::definitelyDidnotReturnError", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker27definitelyDidnotReturnErrorEPKN5clang4ento7SymExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERNS2_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker27definitelyDidnotReturnErrorEPKN5clang4ento7SymExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERNS2_11SValBuilderE")
  //</editor-fold>
  private boolean definitelyDidnotReturnError(/*const*/ SymExpr /*P*/ RetSym, 
                             IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                             final SValBuilder /*&*/ Builder) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(definitelyReturnedError(RetSym, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Builder, true));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Mark an AllocationPair interesting for diagnostic reporting.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::markInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 123,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::markInteresting", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker15markInterestingEPN5clang4ento9BugReportERKSt4pairIPKNS2_7SymExprEPKNS0_15AllocationStateEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker15markInterestingEPN5clang4ento9BugReportERKSt4pairIPKNS2_7SymExprEPKNS0_15AllocationStateEE")
  //</editor-fold>
  private void markInteresting(BugReport /*P*/ R, final /*const*/ std.pairPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ AllocationState /*P*/ > /*&*/ AP) /*const*/ {
    R.markInteresting(AP.first);
    R.markInteresting(AP.second.Region);
  }

  
  /// The bug visitor which allows us to print extra diagnostics along the
  /// BugReport path. For example, showing the allocation site of the leaked
  /// region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 131,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitorE")
  //</editor-fold>
  private static class SecKeychainBugVisitor extends /*public*/ BugReporterVisitorImpl<SecKeychainBugVisitor> implements Destructors.ClassWithDestructor {
  /*protected:*/
    // The allocated region symbol tracked by the main analysis.
    protected /*const*/ SymExpr /*P*/ Sym;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::SecKeychainBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 138,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::SecKeychainBugVisitor", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitorC1EPKN5clang4ento7SymExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitorC1EPKN5clang4ento7SymExprE")
    //</editor-fold>
    public SecKeychainBugVisitor(/*const*/ SymExpr /*P*/ S) {
      // : BugReporterVisitorImpl<SecKeychainBugVisitor>(), Sym(S) 
      //START JInit
      super();
      this.Sym = S;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::Profile">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 140,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::Profile", NM="_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
      final/*static*/ Object X = Profile$$.X;
      ID.AddPointer($AddrOf(X));
      ID.AddPointer(Sym);
    }
    private static final class Profile$$ {
      static final/*static*/ Object X = SecKeychainBugVisitor.class;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::VisitNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 592,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::VisitNode", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE")
    //</editor-fold>
    @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
             /*const*/ ExplodedNode /*P*/ PrevN, 
             final BugReporterContext /*&*/ BRC, 
             final BugReport /*&*/ BR)/* override*/ {
      /*const*/ AllocationState /*P*/ AS = N.getState().$arrow().get(ProgramStateTraitAllocatedData.$Instance, Sym);
      if (!(AS != null)) {
        return null;
      }
      /*const*/ AllocationState /*P*/ ASPrev = PrevN.getState().$arrow().get(ProgramStateTraitAllocatedData.$Instance, Sym);
      if ((ASPrev != null)) {
        return null;
      }
      
      // (!ASPrev && AS) ~ We started tracking symbol in node N, it must be the
      // allocation site.
      /*const*/ CallExpr /*P*/ CE = cast_CallExpr(N.getLocation().castAs(StmtPoint.class).getStmt());
      /*const*/ FunctionDecl /*P*/ funDecl = CE.getDirectCallee$Const();
      assert ((funDecl != null)) : "We do not support indirect function calls as of now.";
      StringRef funName = funDecl.getName();
      
      // Get the expression of the corresponding argument.
      /*uint*/int Idx = getTrackedFunctionIndex(new StringRef(funName), true);
      assert (Idx != InvalidIdx) : "This should be a call to an allocator.";
      /*const*/ Expr /*P*/ ArgExpr = CE.getArg$Const(FunctionsToTrack[Idx].Param);
      PathDiagnosticLocation Pos/*J*/= new PathDiagnosticLocation(ArgExpr, BRC.getSourceManager(), 
          new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, N.getLocationContext()));
      return new PathDiagnosticEventPiece(Pos, new StringRef(/*KEEP_STR*/"Data is allocated here."));
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::~SecKeychainBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 131,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::~SecKeychainBugVisitor", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitorD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::SecKeychainBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 131,
     FQN="(anonymous namespace)::MacOSKeychainAPIChecker::SecKeychainBugVisitor::SecKeychainBugVisitor", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPIChecker21SecKeychainBugVisitorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ SecKeychainBugVisitor(final /*const*/ SecKeychainBugVisitor /*&*/ $Prm0) {
      // : BugReporterVisitorImpl<SecKeychainBugVisitor>(), Sym(.Sym) 
      //START JInit
      super($Prm0);
      this.Sym = $Prm0.Sym;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public SecKeychainBugVisitor clone() {
      return new SecKeychainBugVisitor(this);
    }    
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Sym=" + "[SymExpr]" // NOI18N
                + super.toString(); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::~MacOSKeychainAPIChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 29,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::~MacOSKeychainAPIChecker", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPICheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPICheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSKeychainAPIChecker::MacOSKeychainAPIChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 29,
   FQN="(anonymous namespace)::MacOSKeychainAPIChecker::MacOSKeychainAPIChecker", NM="_ZN12_GLOBAL__N_123MacOSKeychainAPICheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN12_GLOBAL__N_123MacOSKeychainAPICheckerC1Ev")
  //</editor-fold>
  public /*inline*/ MacOSKeychainAPIChecker() {
    // : Checker<PreStmt<CallExpr>, PostStmt<CallExpr>, DeadSymbols>(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPreStmt((CallExpr) stmt, C);
    }
  }

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPostStmt((CallExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
    new DeadSymbols()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // MANUAL: we need to remove static but keep delay of initialization
  private final class checkDeadSymbols$$ {
    // JAVA: must not be static!
     /*static final*//*static*/ CheckerProgramPointTag $Tag/*J*/;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"DeadSymbolsLeak"));
     private final MacOSKeychainAPIChecker $this;
     private checkDeadSymbols$$(MacOSKeychainAPIChecker owner) {
       this.$this = owner;
     }
     CheckerProgramPointTag Tag() {
       if ($Tag == null) {
         $Tag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"DeadSymbolsLeak"));
       }
       return $Tag;
     }
  }
  private final checkDeadSymbols$$ checkDeadSymbols$$ = new checkDeadSymbols$$(this);
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
