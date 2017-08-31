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
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.impl.ConstraintManagerStatics;

//<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 62,
 FQN="clang::ento::ConstraintManager", NM="_ZN5clang4ento17ConstraintManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManagerE")
//</editor-fold>
public abstract class ConstraintManager implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::ConstraintManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 64,
   FQN="clang::ento::ConstraintManager::ConstraintManager", NM="_ZN5clang4ento17ConstraintManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManagerC1Ev")
  //</editor-fold>
  public ConstraintManager() {
    // : NotifyAssumeClients(true) 
    //START JInit
    this.NotifyAssumeClients = true;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::~ConstraintManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp", line = 19,
   FQN="clang::ento::ConstraintManager::~ConstraintManager", NM="_ZN5clang4ento17ConstraintManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::assume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 67,
   FQN="clang::ento::ConstraintManager::assume", NM="_ZN5clang4ento17ConstraintManager6assumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_11DefinedSValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager6assumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_11DefinedSValEb")
  //</editor-fold>
  public abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assume(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
        DefinedSVal Cond, 
        boolean Assumption)/* = 0*/;

  
  // JAVA: typedef std::pair<ProgramStateRef, ProgramStateRef> ProgramStatePair
//  public final class ProgramStatePair extends std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>{ };
  
  /// Returns a pair of states (StTrue, StFalse) where the given condition is
  /// assumed to be true or false, respectively.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::assumeDual">
  @Converted(kind = Converted.Kind.MANUAL/*indent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 75,
   FQN="clang::ento::ConstraintManager::assumeDual", NM="_ZN5clang4ento17ConstraintManager10assumeDualEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_11DefinedSValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager10assumeDualEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_11DefinedSValE")
  //</editor-fold>
  public std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> assumeDual(IntrusiveRefCntPtr</*const*/ ProgramState> State, DefinedSVal Cond) {
    IntrusiveRefCntPtr</*const*/ ProgramState> StTrue = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StFalse = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      StTrue = $c$.clean(assume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedSVal(Cond), true));
      
      // If StTrue is infeasible, asserting the falseness of Cond is unnecessary
      // because the existing constraints already establish this.
      if (!StTrue.$bool()) {
        // This check is expensive and should be disabled even in Release+Asserts
        // builds.
        // FIXME: __OPTIMIZE__ is a GNU extension that Clang implements but MSVC
        // does not. Is there a good equivalent there?
        assert ($c$.track(assume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedSVal(Cond), false)).$bool()) : "System is over constrained."; $c$.clean();
        return $c$.clean(new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>(
                JD$T$RR_T1$RR.INSTANCE, 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, /*Fwd*/(IntrusiveRefCntPtr</*const*/ ProgramState>)$c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null))), 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd*/State))
        );
      }
      
      StFalse = $c$.clean(assume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedSVal(Cond), false));
      if (!StFalse.$bool()) {
        // We are careful to return the original state, /not/ StTrue,
        // because we want to avoid having callers generate a new node
        // in the ExplodedGraph.
        return $c$.clean(new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>(
                JD$T$RR_T1$RR.INSTANCE, 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd*/State), 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, /*Fwd*/(IntrusiveRefCntPtr</*const*/ ProgramState>)$c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null))))
        );
      }
      
      return new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>(
              JD$T$RR_T1$RR.INSTANCE, 
              new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd*/StTrue), 
              new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd*/StFalse)
      );
    } finally {
      if (StFalse != null) { StFalse.$destroy(); }
      if (StTrue != null) { StTrue.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::assumeWithinInclusiveRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 102,
   FQN="clang::ento::ConstraintManager::assumeWithinInclusiveRange", NM="_ZN5clang4ento17ConstraintManager26assumeWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocERKNS2_6APSIntESA_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager26assumeWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocERKNS2_6APSIntESA_b")
  //</editor-fold>
  public abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeWithinInclusiveRange(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                            NonLoc Value, 
                            final /*const*/ APSInt /*&*/ From, 
                            final /*const*/ APSInt /*&*/ To, 
                            boolean InBound)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::assumeWithinInclusiveRangeDual">
  @Converted(kind = Converted.Kind.MANUAL/*indent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 108,
   FQN="clang::ento::ConstraintManager::assumeWithinInclusiveRangeDual", NM="_ZN5clang4ento17ConstraintManager30assumeWithinInclusiveRangeDualEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocERKNS2_6APSIntESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager30assumeWithinInclusiveRangeDualEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocERKNS2_6APSIntESA_")
  //</editor-fold>
  public /*virtual*/ std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> assumeWithinInclusiveRangeDual(IntrusiveRefCntPtr</*const*/ ProgramState> State, NonLoc Value, final /*const*/ APSInt /*&*/ From, 
                                final /*const*/ APSInt /*&*/ To) {
    IntrusiveRefCntPtr</*const*/ ProgramState> StInRange = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StOutOfRange = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      StInRange = $c$.clean(assumeWithinInclusiveRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new NonLoc(Value), From, 
          To, true));
      
      // If StTrue is infeasible, asserting the falseness of Cond is unnecessary
      // because the existing constraints already establish this.
      if (!StInRange.$bool()) {
        return $c$.clean(new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>(
                JD$T$RR_T1$RR.INSTANCE, 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, /*Fwd*/(IntrusiveRefCntPtr</*const*/ ProgramState>)$c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null))), 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd*/State))
        );
      }
      
      StOutOfRange = $c$.clean(assumeWithinInclusiveRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new NonLoc(Value), 
          From, To, false));
      if (!StOutOfRange.$bool()) {
        // We are careful to return the original state, /not/ StTrue,
        // because we want to avoid having callers generate a new node
        // in the ExplodedGraph.
        return $c$.clean(new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>(
                JD$T$RR_T1$RR.INSTANCE, 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd*/State), 
                new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, /*Fwd*/(IntrusiveRefCntPtr</*const*/ ProgramState>)$c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null))))
        );
      }
      
      return new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>(JD$T$RR_T1$RR.INSTANCE, new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd*/StInRange), new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd*/StOutOfRange));
    } finally {
      if (StOutOfRange != null) { StOutOfRange.$destroy(); }
      if (StInRange != null) { StInRange.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief If a symbol is perfectly constrained to a constant, attempt
  /// to return the concrete value.
  ///
  /// Note that a ConstraintManager is not obligated to return a concretized
  /// value for a symbol, even if it is perfectly constrained.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::getSymVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 136,
   FQN="clang::ento::ConstraintManager::getSymVal", NM="_ZNK5clang4ento17ConstraintManager9getSymValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZNK5clang4ento17ConstraintManager9getSymValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprE")
  //</editor-fold>
  public /*virtual*/ /*const*/ APSInt /*P*/ getSymVal(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
           /*const*/ SymExpr /*P*/ sym) /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::removeDeadBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 141,
   FQN="clang::ento::ConstraintManager::removeDeadBindings", NM="_ZN5clang4ento17ConstraintManager18removeDeadBindingsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12SymbolReaperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager18removeDeadBindingsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12SymbolReaperE")
  //</editor-fold>
  public abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> removeDeadBindings(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                    final SymbolReaper /*&*/ SymReaper)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 144,
   FQN="clang::ento::ConstraintManager::print", NM="_ZN5clang4ento17ConstraintManager5printEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS2_11raw_ostreamEPKcSA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager5printEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS2_11raw_ostreamEPKcSA_")
  //</editor-fold>
  public abstract /*virtual*/ void print(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
       final raw_ostream /*&*/ Out, 
       /*const*/char$ptr/*char P*/ nl, 
       /*const*/char$ptr/*char P*/ sep)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::EndPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 149,
   FQN="clang::ento::ConstraintManager::EndPath", NM="_ZN5clang4ento17ConstraintManager7EndPathEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager7EndPathEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public /*virtual*/ void EndPath(IntrusiveRefCntPtr</*const*/ ProgramState> state) {
  }

  
  /// Convenience method to query the state to see if a symbol is null or
  /// not null, or if neither assumption can be made.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::isNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*save $Ref to field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 153,
   FQN="clang::ento::ConstraintManager::isNull", NM="_ZN5clang4ento17ConstraintManager6isNullEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager6isNullEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprE")
  //</editor-fold>
  public ConditionTruthVal isNull(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ SymExpr /*P*/ Sym) {
    SaveAndRestoreBool DisableNotify = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DisableNotify/*J*/= new SaveAndRestoreBool(NotifyAssumeClients$ref, false);
      
      return $c$.clean(checkNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym));
    } finally {
      if (DisableNotify != null) { DisableNotify.$destroy(); }
      $c$.$destroy();
    }
  }

/*protected:*/
  /// A flag to indicate that clients should be notified of assumptions.
  /// By default this is the case, but sometimes this needs to be restricted
  /// to avoid infinite recursions within the ConstraintManager.
  ///
  /// Note that this flag allows the ConstraintManager to be re-entrant,
  /// but not thread-safe.
  protected boolean NotifyAssumeClients; // JAVA: see NotifyAssumeClients$Ref
  
  /// canReasonAbout - Not all ConstraintManagers can accurately reason about
  ///  all SVal values.  This method returns true if the ConstraintManager can
  ///  reasonably handle a given SVal value.  This is typically queried by
  ///  ExprEngine to determine if the value should be replaced with a
  ///  conjured symbolic value in order to recover some precision.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::canReasonAbout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 173,
   FQN="clang::ento::ConstraintManager::canReasonAbout", NM="_ZNK5clang4ento17ConstraintManager14canReasonAboutENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZNK5clang4ento17ConstraintManager14canReasonAboutENS0_4SValE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean canReasonAbout(SVal X) /*const*//* = 0*/;

  
  /// Returns whether or not a symbol is known to be null ("true"), known to be
  /// non-null ("false"), or may be either ("underconstrained"). 
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConstraintManager::checkNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp", line = 28,
   FQN="clang::ento::ConstraintManager::checkNull", NM="_ZN5clang4ento17ConstraintManager9checkNullEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConstraintManager9checkNullEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprE")
  //</editor-fold>
  protected ConditionTruthVal checkNull(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
           /*const*/ SymExpr /*P*/ Sym) {
    /*const*/std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> /*&*/ P = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      QualType Ty = Sym.getType();
      DefinedSVal V = Loc.isLocType(new QualType(Ty)) ? ConstraintManagerStatics.getLocFromSymbol(State, Sym) : new DefinedSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(Sym));
      /*final */ P = $c$.clean(assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedSVal(V)));
      if (P.first.$bool() && !P.second.$bool()) {
        return new ConditionTruthVal(false);
      }
      if (!P.first.$bool() && P.second.$bool()) {
        return new ConditionTruthVal(true);
      }
      return new ConditionTruthVal();
    } finally {
      if (P != null) { P.$destroy(); }
      $c$.$destroy();
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private final bool$ref NotifyAssumeClients$ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return NotifyAssumeClients;
    }

    @Override
    public boolean $set(boolean value) {
      NotifyAssumeClients = value;
      return NotifyAssumeClients;
    }
  };
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  

  @Override public String toString() {
    return "" + "NotifyAssumeClients=" + NotifyAssumeClients; // NOI18N
  }
}
