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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 52,
 FQN="(anonymous namespace)::PthreadLockChecker", NM="_ZN12_GLOBAL__N_118PthreadLockCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_118PthreadLockCheckerE")
//</editor-fold>
public class PthreadLockChecker extends /*public*/ Checker/*T<PostStmt<CallExpr> > */
        implements org.clang.staticanalyzer.java.PostStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT_doublelock;
  private /*mutable */std.unique_ptr<BugType> BT_doubleunlock;
  private /*mutable */std.unique_ptr<BugType> BT_destroylock;
  private /*mutable */std.unique_ptr<BugType> BT_initlock;
  private /*mutable */std.unique_ptr<BugType> BT_lor;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::LockingSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 58,
   FQN="(anonymous namespace)::PthreadLockChecker::LockingSemantics", NM="_ZN12_GLOBAL__N_118PthreadLockChecker16LockingSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_118PthreadLockChecker16LockingSemanticsE")
  //</editor-fold>
  private enum LockingSemantics implements Native.NativeUIntEnum {
    NotApplicable(0),
    PthreadSemantics(NotApplicable.getValue() + 1),
    XNUSemantics(PthreadSemantics.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LockingSemantics valueOf(int val) {
      LockingSemantics out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LockingSemantics[] VALUES;
      private static final LockingSemantics[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LockingSemantics kind : LockingSemantics.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LockingSemantics[min < 0 ? (1-min) : 0];
        VALUES = new LockingSemantics[max >= 0 ? (1+max) : 0];
        for (LockingSemantics kind : LockingSemantics.values()) {
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
    private LockingSemantics(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 81,
   FQN="(anonymous namespace)::PthreadLockChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118PthreadLockChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_118PthreadLockChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CallExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
   IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
   try {
    state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
    /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
    StringRef FName = C.getCalleeName(CE);
    if (FName.empty()) {
      return;
    }
    if (CE.getNumArgs() != 1 && CE.getNumArgs() != 2) {
      return;
    }
    if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_mutex_lock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_rwlock_rdlock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_rwlock_wrlock")) {
      AcquireLock(C, CE, state.$arrow().getSVal(CE.getArg$Const(0), LCtx), 
          false, LockingSemantics.PthreadSemantics);
    } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_mtx_lock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_rw_lock_exclusive")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_rw_lock_shared")) {
      AcquireLock(C, CE, state.$arrow().getSVal(CE.getArg$Const(0), LCtx), 
          false, LockingSemantics.XNUSemantics);
    } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_mutex_trylock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_rwlock_tryrdlock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_rwlock_trywrlock")) {
      AcquireLock(C, CE, state.$arrow().getSVal(CE.getArg$Const(0), LCtx), 
          true, LockingSemantics.PthreadSemantics);
    } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_mtx_try_lock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_rw_try_lock_exclusive")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_rw_try_lock_shared")) {
      AcquireLock(C, CE, state.$arrow().getSVal(CE.getArg$Const(0), LCtx), 
          true, LockingSemantics.XNUSemantics);
    } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_mutex_unlock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_rwlock_unlock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_mtx_unlock")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_rw_done")) {
      ReleaseLock(C, CE, state.$arrow().getSVal(CE.getArg$Const(0), LCtx));
    } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_mutex_destroy")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"lck_mtx_destroy")) {
      DestroyLock(C, CE, state.$arrow().getSVal(CE.getArg$Const(0), LCtx));
    } else if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"pthread_mutex_init")) {
      InitLock(C, CE, state.$arrow().getSVal(CE.getArg$Const(0), LCtx));
    }
   } finally {
    if (state != null) { state.$destroy(); }
   } 
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::AcquireLock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 124,
   FQN="(anonymous namespace)::PthreadLockChecker::AcquireLock", NM="_ZNK12_GLOBAL__N_118PthreadLockChecker11AcquireLockERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValEbNS0_16LockingSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_118PthreadLockChecker11AcquireLockERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValEbNS0_16LockingSemanticsE")
  //</editor-fold>
  public void AcquireLock(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
             SVal lock, boolean isTryLock, 
              LockingSemantics semantics) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> lockSucc = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ MemRegion /*P*/ lockR = lock.getAsRegion();
      if (!(lockR != null)) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      SVal X = state.$arrow().getSVal(CE, C.getLocationContext());
      if (X.isUnknownOrUndef$SVal()) {
        return;
      }
      
      DefinedSVal retVal = X.castAs(DefinedSVal.class);
      {
        
        /*const*/ LockState /*P*/ LState = state.$arrow().get(ProgramStateTraitLockMap.$Instance, lockR);
        if ((LState != null)) {
          if (LState.isLocked()) {
            unique_ptr<BugReport> report = null;
            try {
              if (!BT_doublelock.$bool()) {
                BT_doublelock.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Double locking"), 
                        new StringRef(/*KEEP_STR*/"Lock checker")));
              }
              ExplodedNode /*P*/ N = C.generateErrorNode();
              if (!(N != null)) {
                return;
              }
              report = llvm.make_unique(new BugReport(BT_doublelock.$star(), $("This lock has already been acquired"), N));
              report.$arrow().addRange(CE.getArg$Const(0).getSourceRange());
              C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
              return;
            } finally {
              if (report != null) { report.$destroy(); }
            }
          } else if (LState.isDestroyed()) {
            reportUseDestroyedBug(C, CE);
            return;
          }
        }
      }
      
      lockSucc = new IntrusiveRefCntPtr</*const*/ ProgramState>(state);
      if (isTryLock) {
        IntrusiveRefCntPtr</*const*/ ProgramState> lockFail = null;
        try {
          // Bifurcate the state, and allow a mode where the lock acquisition fails.
          lockFail/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          switch (semantics) {
           case PthreadSemantics:
//            $c$.clean(std.tie(lockFail, lockSucc).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(retVal)))));
            // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
            std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume$1 = 
                    $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(retVal)));
            lockFail.$assign($assume$1.first);
            lockSucc.$assign($assume$1.second);
            assert !$assume$1.first.$bool();
            assert !$assume$1.second.$bool();
            $c$.clean();
            break;
           case XNUSemantics:
//            $c$.clean(std.tie(lockSucc, lockFail).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(retVal)))));
            // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
            std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume$2 = 
                    $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(retVal)));
            lockSucc.$assign($assume$2.first);
            lockFail.$assign($assume$2.second);
            assert !$assume$2.first.$bool();
            assert !$assume$2.second.$bool();
            $c$.clean();

            break;
           default:
            throw new llvm_unreachable("Unknown tryLock locking semantics");
          }
          assert (lockFail.$bool() && lockSucc.$bool());
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(lockFail))));
        } finally {
          if (lockFail != null) { lockFail.$destroy(); }
        }
      } else if (semantics == LockingSemantics.PthreadSemantics) {
        // Assume that the return value was 0.
        $c$.clean(lockSucc.$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(retVal), false))));
        assert ((lockSucc).$bool());
      } else {
        // XNU locking semantics return void on non-try locks
        assert ((semantics == LockingSemantics.XNUSemantics)) : "Unknown locking semantics";
        $c$.clean(lockSucc.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      }
      
      // Record that the lock was acquired.
      $c$.clean(lockSucc.$assign($c$.track(lockSucc.$arrow().add(ProgramStateTraitLockSet.$Instance, lockR))));
      $c$.clean(lockSucc.$assign($c$.track(lockSucc.$arrow().set(ProgramStateTraitLockMap.$Instance, lockR, LockState.getLocked()))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(lockSucc))));
    } finally {
      if (lockSucc != null) { lockSucc.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::ReleaseLock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 193,
   FQN="(anonymous namespace)::PthreadLockChecker::ReleaseLock", NM="_ZNK12_GLOBAL__N_118PthreadLockChecker11ReleaseLockERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_118PthreadLockChecker11ReleaseLockERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValE")
  //</editor-fold>
  public void ReleaseLock(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
             SVal lock) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ MemRegion /*P*/ lockR = lock.getAsRegion();
      if (!(lockR != null)) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      {
        
        /*const*/ LockState /*P*/ LState = state.$arrow().get(ProgramStateTraitLockMap.$Instance, lockR);
        if ((LState != null)) {
          if (LState.isUnlocked()) {
            unique_ptr<BugReport> Report = null;
            try {
              if (!BT_doubleunlock.$bool()) {
                BT_doubleunlock.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Double unlocking"), 
                        new StringRef(/*KEEP_STR*/"Lock checker")));
              }
              ExplodedNode /*P*/ N = C.generateErrorNode();
              if (!(N != null)) {
                return;
              }
              Report = llvm.make_unique(new BugReport(BT_doubleunlock.$star(), $("This lock has already been unlocked"), N));
              Report.$arrow().addRange(CE.getArg$Const(0).getSourceRange());
              C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
              return;
            } finally {
              if (Report != null) { Report.$destroy(); }
            }
          } else if (LState.isDestroyed()) {
            reportUseDestroyedBug(C, CE);
            return;
          }
        }
      }
      
      ImmutableList</*const*/ MemRegion /*P*/ > LS = state.$arrow().get(ProgramStateTraitLockSet.$Instance);
      
      // FIXME: Better analysis requires IPA for wrappers.
      if (!LS.isEmpty()) {
        /*const*/ MemRegion /*P*/ firstLockR = LS.getHead();
        if (firstLockR != lockR) {
          unique_ptr<BugReport> report = null;
          try {
            if (!BT_lor.$bool()) {
              BT_lor.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Lock order reversal"), new StringRef(/*KEEP_STR*/"Lock checker")));
            }
            ExplodedNode /*P*/ N = C.generateErrorNode();
            if (!(N != null)) {
              return;
            }
            report = llvm.make_unique(new BugReport(BT_lor.$star(), $("This was not the most recently acquired lock. Possible lock order reversal"), N));
            report.$arrow().addRange(CE.getArg$Const(0).getSourceRange());
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
            return;
          } finally {
            if (report != null) { report.$destroy(); }
          }
        }
        // Record that the lock was released.
        $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitLockSet.$Instance, LS.getTail()))));
      }
      
      $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitLockMap.$Instance, lockR, LockState.getUnlocked()))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::DestroyLock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 248,
   FQN="(anonymous namespace)::PthreadLockChecker::DestroyLock", NM="_ZNK12_GLOBAL__N_118PthreadLockChecker11DestroyLockERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_118PthreadLockChecker11DestroyLockERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValE")
  //</editor-fold>
  public void DestroyLock(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
             SVal Lock) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ MemRegion /*P*/ LockR = Lock.getAsRegion();
      if (!(LockR != null)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      /*const*/ LockState /*P*/ LState = State.$arrow().get(ProgramStateTraitLockMap.$Instance, LockR);
      if (!(LState != null) || LState.isUnlocked()) {
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitLockMap.$Instance, LockR, LockState.getDestroyed()))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      
      StringRef Message/*J*/= new StringRef();
      if (LState.isLocked()) {
        Message.$assignMove(/*STRINGREF_STR*/"This lock is still locked");
      } else {
        Message.$assignMove(/*STRINGREF_STR*/"This lock has already been destroyed");
      }
      if (!BT_destroylock.$bool()) {
        BT_destroylock.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Destroy invalid lock"), 
                new StringRef(/*KEEP_STR*/"Lock checker")));
      }
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if (!(N != null)) {
        return;
      }
      Report = llvm.make_unique(new BugReport(BT_destroylock.$star(), Message, N));
      Report.$arrow().addRange(CE.getArg$Const(0).getSourceRange());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::InitLock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 283,
   FQN="(anonymous namespace)::PthreadLockChecker::InitLock", NM="_ZNK12_GLOBAL__N_118PthreadLockChecker8InitLockERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_118PthreadLockChecker8InitLockERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValE")
  //</editor-fold>
  public void InitLock(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
          SVal Lock) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ MemRegion /*P*/ LockR = Lock.getAsRegion();
      if (!(LockR != null)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      /*const*/  LockState /*P*/ LState = State.$arrow().get(ProgramStateTraitLockMap.$Instance, LockR);
      if (!(LState != null) || LState.isDestroyed()) {
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitLockMap.$Instance, LockR, LockState.getUnlocked()))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      
      StringRef Message/*J*/= new StringRef();
      if (LState.isLocked()) {
        Message.$assignMove(/*STRINGREF_STR*/"This lock is still being held");
      } else {
        Message.$assignMove(/*STRINGREF_STR*/"This lock has already been initialized");
      }
      if (!BT_initlock.$bool()) {
        BT_initlock.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Init invalid lock"), 
                new StringRef(/*KEEP_STR*/"Lock checker")));
      }
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if (!(N != null)) {
        return;
      }
      Report = llvm.make_unique(new BugReport(BT_initlock.$star(), Message, N));
      Report.$arrow().addRange(CE.getArg$Const(0).getSourceRange());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::reportUseDestroyedBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 318,
   FQN="(anonymous namespace)::PthreadLockChecker::reportUseDestroyedBug", NM="_ZNK12_GLOBAL__N_118PthreadLockChecker21reportUseDestroyedBugERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_118PthreadLockChecker21reportUseDestroyedBugERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void reportUseDestroyedBug(final CheckerContext /*&*/ C, 
                       /*const*/ CallExpr /*P*/ CE) /*const*/ {
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!BT_destroylock.$bool()) {
        BT_destroylock.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Use destroyed lock"), 
                new StringRef(/*KEEP_STR*/"Lock checker")));
      }
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if (!(N != null)) {
        return;
      }
      Report = llvm.make_unique(new BugReport(BT_destroylock.$star(), $("This lock has already been destroyed"), N));
      Report.$arrow().addRange(CE.getArg$Const(0).getSourceRange());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::~PthreadLockChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 52,
   FQN="(anonymous namespace)::PthreadLockChecker::~PthreadLockChecker", NM="_ZN12_GLOBAL__N_118PthreadLockCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_118PthreadLockCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_lor.$destroy();
    BT_initlock.$destroy();
    BT_destroylock.$destroy();
    BT_doubleunlock.$destroy();
    BT_doublelock.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PthreadLockChecker::PthreadLockChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 52,
   FQN="(anonymous namespace)::PthreadLockChecker::PthreadLockChecker", NM="_ZN12_GLOBAL__N_118PthreadLockCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_118PthreadLockCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ PthreadLockChecker() {
    // : Checker<PostStmt<CallExpr> >(), BT_doublelock(), BT_doubleunlock(), BT_destroylock(), BT_initlock(), BT_lor() 
    //START JInit
    super();
    this.BT_doublelock = new std.unique_ptr<BugType>();
    this.BT_doubleunlock = new std.unique_ptr<BugType>();
    this.BT_destroylock = new std.unique_ptr<BugType>();
    this.BT_initlock = new std.unique_ptr<BugType>();
    this.BT_lor = new std.unique_ptr<BugType>();
    //END JInit
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPostStmt((CallExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_doublelock=" + BT_doublelock // NOI18N
              + ", BT_doubleunlock=" + BT_doubleunlock // NOI18N
              + ", BT_destroylock=" + BT_destroylock // NOI18N
              + ", BT_initlock=" + BT_initlock // NOI18N
              + ", BT_lor=" + BT_lor // NOI18N
              + super.toString(); // NOI18N
  }
}
