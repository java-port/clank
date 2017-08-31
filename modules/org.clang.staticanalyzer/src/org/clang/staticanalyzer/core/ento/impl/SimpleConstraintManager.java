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

package org.clang.staticanalyzer.core.ento.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 24,
 FQN="clang::ento::SimpleConstraintManager", NM="_ZN5clang4ento23SimpleConstraintManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManagerE")
//</editor-fold>
public abstract class SimpleConstraintManager extends /*public*/ ConstraintManager implements Destructors.ClassWithDestructor {
  private SubEngine /*P*/ SU;
  private final SValBuilder /*&*/ SVB;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::SimpleConstraintManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 28,
   FQN="clang::ento::SimpleConstraintManager::SimpleConstraintManager", NM="_ZN5clang4ento23SimpleConstraintManagerC1EPNS0_9SubEngineERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManagerC1EPNS0_9SubEngineERNS0_11SValBuilderE")
  //</editor-fold>
  public SimpleConstraintManager(SubEngine /*P*/ subengine, final SValBuilder /*&*/ SB) {
    // : ConstraintManager(), SU(subengine), SVB(SB) 
    //START JInit
    super();
    this.SU = subengine;
    this./*&*/SVB=/*&*/SB;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::~SimpleConstraintManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 24,
   FQN="clang::ento::SimpleConstraintManager::~SimpleConstraintManager", NM="_ZN5clang4ento23SimpleConstraintManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManagerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  //===------------------------------------------------------------------===//
  // Common implementation for the interface provided by ConstraintManager.
  //===------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 68,
   FQN="clang::ento::SimpleConstraintManager::assume", NM="_ZN5clang4ento23SimpleConstraintManager6assumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_11DefinedSValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager6assumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_11DefinedSValEb")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assume(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
        DefinedSVal Cond, 
        boolean Assumption)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        // If we have a Loc value, cast it to a bool NonLoc first.
        Optional<Loc> LV = Cond.getAs(Loc.class);
        if (LV.$bool()) {
          final SValBuilder /*&*/ SVB = state.$arrow().getStateManager().getSValBuilder();
          QualType T/*J*/= new QualType();
          /*const*/ MemRegion /*P*/ MR = LV.$arrow().getAsRegion();
          {
            /*const*/ TypedRegion /*P*/ TR = dyn_cast_or_null_TypedRegion(MR);
            if ((TR != null)) {
              T.$assignMove(TR.getLocationType());
            } else {
              T.$assignMove(SVB.getContext().VoidPtrTy.$QualType());
            }
          }
          
          Cond.$assignMove(SVB.evalCast(new SVal(LV.$star()), SVB.getContext().BoolTy.$QualType(), new QualType(T)).castAs(DefinedSVal.class));
        }
      }
      
      return $c$.clean(assume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Cond.castAs(NonLoc.class), Assumption));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 87,
   FQN="clang::ento::SimpleConstraintManager::assume", NM="_ZN5clang4ento23SimpleConstraintManager6assumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager6assumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocEb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> assume(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
        NonLoc cond, 
        boolean assumption) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(state.$assign($c$.track(assumeAux($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new NonLoc(cond), assumption))));
      if (NotifyAssumeClients && (SU != null)) {
        return $c$.clean(SU.processAssume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(cond), assumption));
      }
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeWithinInclusiveRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 193,
   FQN="clang::ento::SimpleConstraintManager::assumeWithinInclusiveRange", NM="_ZN5clang4ento23SimpleConstraintManager26assumeWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocERKNS2_6APSIntESA_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager26assumeWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocERKNS2_6APSIntESA_b")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeWithinInclusiveRange(IntrusiveRefCntPtr</*const*/ ProgramState> State, NonLoc Value, final /*const*/ APSInt /*&*/ From, 
                            final /*const*/ APSInt /*&*/ To, boolean InRange)/* override*/ {
    assert (From.isUnsigned() == To.isUnsigned() && From.getBitWidth() == To.getBitWidth()) : "Values should have same types!";
    if (!canReasonAbout(new SVal(Value))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Just add the constraint to the expression without trying to simplify.
        /*const*/ SymExpr /*P*/ Sym = Value.getAsSymExpr();
        assert Native.$bool(Sym);
        return $c$.clean(assumeSymWithinInclusiveRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, From, To, InRange));
      } finally {
        $c$.$destroy();
      }
    }
    switch (NsNonloc.Kind.valueOf(Value.getSubKind())) {
     default:
      throw new llvm_unreachable("'assumeWithinInclusiveRange' is not implementedfor this NonLoc");
     case LocAsIntegerKind:
     case SymbolValKind:
      {
        {
          /*const*/ SymExpr /*P*/ Sym = Value.getAsSymbol();
          if ((Sym != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(assumeSymWithinInclusiveRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, From, To, InRange));
            } finally {
              $c$.$destroy();
            }
          }
        }
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      } // end switch
     case ConcreteIntKind:
      {
        final /*const*/ APSInt /*&*/ IntVal = Value.castAs(NsNonloc.ConcreteInt.class).getValue();
        boolean IsInRange = IntVal.$greatereq(From) && IntVal.$lesseq(To);
        boolean isFeasible = (IsInRange == InRange);
        return isFeasible ? new IntrusiveRefCntPtr</*const*/ ProgramState>(State) : new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
    } // end switch
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymRel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 246,
   FQN="clang::ento::SimpleConstraintManager::assumeSymRel", NM="_ZN5clang4ento23SimpleConstraintManager12assumeSymRelEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprENS_18BinaryOperatorKindERKNS2_6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager12assumeSymRelEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprENS_18BinaryOperatorKindERKNS2_6APSIntE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymRel(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
              /*const*/ SymExpr /*P*/ LHS, 
              BinaryOperatorKind op, 
              final /*const*/ APSInt /*&*/ Int) {
    assert (BinaryOperator.isComparisonOp(op)) : "Non-comparison ops should be rewritten as comparisons to zero.";
    
    // Get the type used for calculating wraparound.
    final BasicValueFactory /*&*/ BVF = getBasicVals();
    APSIntType WraparoundType = BVF.getAPSIntType(LHS.getType());
    
    // We only handle simple comparisons of the form "$sym == constant"
    // or "($sym+constant1) == constant2".
    // The adjustment is "constant1" in the above expression. It's used to
    // "slide" the solution range around for modular arithmetic. For example,
    // x < 4 has the solution [0, 3]. x+2 < 4 has the solution [0-2, 3-2], which
    // in modular arithmetic is [0, 1] U [UINT_MAX-1, UINT_MAX]. It's up to
    // the subclasses of SimpleConstraintManager to handle the adjustment.
    type$ref</*const*/ SymExpr /*P*/ > Sym = create_type$ref(LHS);
    APSInt Adjustment = WraparoundType.getZeroValue();
    EntoStatics.computeAdjustment(Sym, Adjustment);
    
    // Convert the right-hand side integer as necessary.
    APSIntType ComparisonType = new APSIntType(std.max(WraparoundType, new APSIntType(Int)));
    APSInt ConvertedInt = ComparisonType.convert(Int);
    
    // Prefer unsigned comparisons.
    if (ComparisonType.getBitWidth() == WraparoundType.getBitWidth()
       && ComparisonType.isUnsigned() && !WraparoundType.isUnsigned()) {
      Adjustment.setIsSigned(false);
    }
    switch (op) {
     default:
      throw new llvm_unreachable("invalid operation not caught by assertion above");
     case BO_EQ:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(assumeSymEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym.$deref(), ConvertedInt, Adjustment));
        } finally {
          $c$.$destroy();
        }
      }
     case BO_NE:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(assumeSymNE($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym.$deref(), ConvertedInt, Adjustment));
        } finally {
          $c$.$destroy();
        }
      }
     case BO_GT:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(assumeSymGT($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym.$deref(), ConvertedInt, Adjustment));
        } finally {
          $c$.$destroy();
        }
      }
     case BO_GE:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(assumeSymGE($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym.$deref(), ConvertedInt, Adjustment));
        } finally {
          $c$.$destroy();
        }
      }
     case BO_LT:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(assumeSymLT($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym.$deref(), ConvertedInt, Adjustment));
        } finally {
          $c$.$destroy();
        }
      }
     case BO_LE:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(assumeSymLE($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym.$deref(), ConvertedInt, Adjustment));
        } finally {
          $c$.$destroy();
        }
      }
    } // end switch
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymWithinInclusiveRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 301,
   FQN="clang::ento::SimpleConstraintManager::assumeSymWithinInclusiveRange", NM="_ZN5clang4ento23SimpleConstraintManager29assumeSymWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager29assumeSymWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_b")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymWithinInclusiveRange(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                               /*const*/ SymExpr /*P*/ Sym, 
                               final /*const*/ APSInt /*&*/ From, 
                               final /*const*/ APSInt /*&*/ To, 
                               boolean InRange) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Get the type used for calculating wraparound.
      final BasicValueFactory /*&*/ BVF = getBasicVals();
      APSIntType WraparoundType = BVF.getAPSIntType(Sym.getType());
      
      APSInt Adjustment = WraparoundType.getZeroValue();
      type$ref</*const*/ SymExpr /*P*/ > AdjustedSym = create_type$ref(Sym);
      EntoStatics.computeAdjustment(AdjustedSym, Adjustment);
      
      // Convert the right-hand side integer as necessary.
      APSIntType ComparisonType = new APSIntType(std.max(WraparoundType, new APSIntType(From)));
      APSInt ConvertedFrom = ComparisonType.convert(From);
      APSInt ConvertedTo = ComparisonType.convert(To);
      
      // Prefer unsigned comparisons.
      if (ComparisonType.getBitWidth() == WraparoundType.getBitWidth()
         && ComparisonType.isUnsigned() && !WraparoundType.isUnsigned()) {
        Adjustment.setIsSigned(false);
      }
      if (InRange) {
        return $c$.clean(assumeSymbolWithinInclusiveRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), AdjustedSym.$deref(), ConvertedFrom, 
            ConvertedTo, Adjustment));
      }
      return $c$.clean(assumeSymbolOutOfInclusiveRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), AdjustedSym.$deref(), ConvertedFrom, 
          ConvertedTo, Adjustment));
    } finally {
      $c$.$destroy();
    }
  }

/*protected:*/
  
  //===------------------------------------------------------------------===//
  // Interface that subclasses must implement.
  //===------------------------------------------------------------------===//
  
  // Each of these is of the form "$sym+Adj <> V", where "<>" is the comparison
  // operation for the method being invoked.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymNE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 67,
   FQN="clang::ento::SimpleConstraintManager::assumeSymNE", NM="_ZN5clang4ento23SimpleConstraintManager11assumeSymNEEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager11assumeSymNEEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_")
  //</editor-fold>
  protected abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymNE(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ sym, 
             final /*const*/ APSInt /*&*/ V, 
             final /*const*/ APSInt /*&*/ Adjustment)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymEQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 71,
   FQN="clang::ento::SimpleConstraintManager::assumeSymEQ", NM="_ZN5clang4ento23SimpleConstraintManager11assumeSymEQEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager11assumeSymEQEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_")
  //</editor-fold>
  protected abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymEQ(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ sym, 
             final /*const*/ APSInt /*&*/ V, 
             final /*const*/ APSInt /*&*/ Adjustment)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 75,
   FQN="clang::ento::SimpleConstraintManager::assumeSymLT", NM="_ZN5clang4ento23SimpleConstraintManager11assumeSymLTEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager11assumeSymLTEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_")
  //</editor-fold>
  protected abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymLT(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ sym, 
             final /*const*/ APSInt /*&*/ V, 
             final /*const*/ APSInt /*&*/ Adjustment)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymGT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 79,
   FQN="clang::ento::SimpleConstraintManager::assumeSymGT", NM="_ZN5clang4ento23SimpleConstraintManager11assumeSymGTEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager11assumeSymGTEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_")
  //</editor-fold>
  protected abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymGT(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ sym, 
             final /*const*/ APSInt /*&*/ V, 
             final /*const*/ APSInt /*&*/ Adjustment)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymLE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 83,
   FQN="clang::ento::SimpleConstraintManager::assumeSymLE", NM="_ZN5clang4ento23SimpleConstraintManager11assumeSymLEEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager11assumeSymLEEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_")
  //</editor-fold>
  protected abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymLE(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ sym, 
             final /*const*/ APSInt /*&*/ V, 
             final /*const*/ APSInt /*&*/ Adjustment)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymGE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 87,
   FQN="clang::ento::SimpleConstraintManager::assumeSymGE", NM="_ZN5clang4ento23SimpleConstraintManager11assumeSymGEEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager11assumeSymGEEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_")
  //</editor-fold>
  protected abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymGE(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ sym, 
             final /*const*/ APSInt /*&*/ V, 
             final /*const*/ APSInt /*&*/ Adjustment)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymbolWithinInclusiveRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 92,
   FQN="clang::ento::SimpleConstraintManager::assumeSymbolWithinInclusiveRange", NM="_ZN5clang4ento23SimpleConstraintManager32assumeSymbolWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_SC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager32assumeSymbolWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_SC_")
  //</editor-fold>
  protected abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymbolWithinInclusiveRange(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ SymExpr /*P*/ Sym, final /*const*/ APSInt /*&*/ From, 
                                  final /*const*/ APSInt /*&*/ To, final /*const*/ APSInt /*&*/ Adjustment)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeSymbolOutOfInclusiveRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 96,
   FQN="clang::ento::SimpleConstraintManager::assumeSymbolOutOfInclusiveRange", NM="_ZN5clang4ento23SimpleConstraintManager31assumeSymbolOutOfInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_SC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager31assumeSymbolOutOfInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprERKNS2_6APSIntESC_SC_")
  //</editor-fold>
  protected abstract /*virtual*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymbolOutOfInclusiveRange(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ Sym, final /*const*/ APSInt /*&*/ From, 
                                 final /*const*/ APSInt /*&*/ To, final /*const*/ APSInt /*&*/ Adjustment)/* = 0*/;

  //===------------------------------------------------------------------===//
  // Internal implementation.
  //===------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::getBasicVals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 103,
   FQN="clang::ento::SimpleConstraintManager::getBasicVals", NM="_ZNK5clang4ento23SimpleConstraintManager12getBasicValsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZNK5clang4ento23SimpleConstraintManager12getBasicValsEv")
  //</editor-fold>
  protected BasicValueFactory /*&*/ getBasicVals() /*const*/ {
    return SVB.getBasicValueFactory();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::getSymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.h", line = 104,
   FQN="clang::ento::SimpleConstraintManager::getSymbolManager", NM="_ZNK5clang4ento23SimpleConstraintManager16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZNK5clang4ento23SimpleConstraintManager16getSymbolManagerEv")
  //</editor-fold>
  protected SymbolManager /*&*/ getSymbolManager() /*const*/ {
    return SVB.getSymbolManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::canReasonAbout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 26,
   FQN="clang::ento::SimpleConstraintManager::canReasonAbout", NM="_ZNK5clang4ento23SimpleConstraintManager14canReasonAboutENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZNK5clang4ento23SimpleConstraintManager14canReasonAboutENS0_4SValE")
  //</editor-fold>
  @Override protected boolean canReasonAbout(SVal X) /*const*//* override*/ {
    Optional<NsNonloc.SymbolVal> SymVal = X.getAs(NsNonloc.SymbolVal.class);
    if (SymVal.$bool() && SymVal.$arrow().isExpression()) {
      /*const*/ SymExpr /*P*/ SE = SymVal.$arrow().getSymbol();
      {
        
        /*const*/ SymIntExpr /*P*/ SIE = dyn_cast_SymIntExpr(SE);
        if ((SIE != null)) {
          switch (SIE.getOpcode()) {
           case BO_And:
           case BO_Or:
           case BO_Xor:
            // We don't reason yet about bitwise-constraints on symbolic values.
            return false;
           case BO_Mul:
           case BO_Div:
           case BO_Rem:
           case BO_Shl:
           case BO_Shr:
            // We don't reason yet about these arithmetic constraints on
            // symbolic values.
            return false;
           default:
            // All other cases.
            return true;
          }
        }
      }
      {
        
        /*const*/ SymSymExpr /*P*/ SSE = dyn_cast_SymSymExpr(SE);
        if ((SSE != null)) {
          if (BinaryOperator.isComparisonOp(SSE.getOpcode())) {
            // We handle Loc <> Loc comparisons, but not (yet) NonLoc <> NonLoc.
            if (Loc.isLocType(SSE.getLHS().getType())) {
              assert (Loc.isLocType(SSE.getRHS().getType()));
              return true;
            }
          }
        }
      }
      
      return false;
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeAux">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 114,
   FQN="clang::ento::SimpleConstraintManager::assumeAux", NM="_ZN5clang4ento23SimpleConstraintManager9assumeAuxEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager9assumeAuxEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_6NonLocEb")
  //</editor-fold>
  protected IntrusiveRefCntPtr</*const*/ ProgramState> assumeAux(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
           NonLoc Cond, 
           boolean Assumption) {
    
    // We cannot reason about SymSymExprs, and can only reason about some
    // SymIntExprs.
    if (!canReasonAbout(new SVal(Cond))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Just add the constraint to the expression without trying to simplify.
        /*const*/ SymExpr /*P*/ sym = Cond.getAsSymExpr();
        return $c$.clean(assumeAuxForSymbol($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym, Assumption));
      } finally {
        $c$.$destroy();
      }
    }
    switch (NsNonloc.Kind.valueOf(Cond.getSubKind())) {
     default:
      throw new llvm_unreachable("'Assume' not implemented for this NonLoc");
     case SymbolValKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          NsNonloc.SymbolVal SV = Cond.castAs(NsNonloc.SymbolVal.class);
          /*const*/ SymExpr /*P*/ sym = SV.getSymbol();
          assert Native.$bool(sym);
          
          // Handle SymbolData.
          if (!SV.isExpression()) {
            return $c$.clean(assumeAuxForSymbol($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym, Assumption));
            // Handle symbolic expression.
          } else {
            /*const*/ SymIntExpr /*P*/ SE = dyn_cast_SymIntExpr(sym);
            if ((SE != null)) {
              // We can only simplify expressions whose RHS is an integer.
              BinaryOperatorKind op = SE.getOpcode();
              if (BinaryOperator.isComparisonOp(op)) {
                if (!Assumption) {
                  op = BinaryOperator.negateComparisonOp(op);
                }
                
                return $c$.clean(assumeSymRel($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), SE.getLHS(), op, SE.getRHS()));
              }
            } else {
              /*const*/ SymSymExpr /*P*/ SSE = dyn_cast_SymSymExpr(sym);
              if ((SSE != null)) {
                // Translate "a != b" to "(b - a) != 0".
                // We invert the order of the operands as a heuristic for how loop
                // conditions are usually written ("begin != end") as compared to length
                // calculations ("end - begin"). The more correct thing to do would be to
                // canonicalize "a - b" and "b - a", which would allow us to treat
                // "a != b" and "b != a" the same.
                final SymbolManager /*&*/ SymMgr = getSymbolManager();
                BinaryOperatorKind Op = SSE.getOpcode();
                assert (BinaryOperator.isComparisonOp(Op));
                
                // For now, we only support comparing pointers.
                assert (Loc.isLocType(SSE.getLHS().getType()));
                assert (Loc.isLocType(SSE.getRHS().getType()));
                QualType DiffTy = SymMgr.getContext().getPointerDiffType();
                /*const*/ SymExpr /*P*/ Subtraction = SymMgr.getSymSymExpr(SSE.getRHS(), BinaryOperatorKind.BO_Sub, 
                    SSE.getLHS(), new QualType(DiffTy));
                
                final /*const*/ APSInt /*&*/ Zero = getBasicVals().getValue($int2ulong(0), new QualType(DiffTy));
                Op = BinaryOperator.reverseComparisonOp(Op);
                if (!Assumption) {
                  Op = BinaryOperator.negateComparisonOp(Op);
                }
                return $c$.clean(assumeSymRel($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Subtraction, Op, Zero));
              }
            }
          }
          
          // If we get here, there's nothing else we can do but treat the symbol as
          // opaque.
          return $c$.clean(assumeAuxForSymbol($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym, Assumption));
        } finally {
          $c$.$destroy();
        }
      }
     case ConcreteIntKind:
      {
        boolean b = Cond.castAs(NsNonloc.ConcreteInt.class).getValue().$noteq(0);
        boolean isFeasible = b ? Assumption : !Assumption;
        return isFeasible ? new IntrusiveRefCntPtr</*const*/ ProgramState>(state) : new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
     case LocAsIntegerKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(assume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(JD$Move.INSTANCE, Cond.castAs(NsNonloc.LocAsInteger.class).getLoc()), 
              Assumption));
        } finally {
          $c$.$destroy();
        }
      }
    } // end switch
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SimpleConstraintManager::assumeAuxForSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 97,
   FQN="clang::ento::SimpleConstraintManager::assumeAuxForSymbol", NM="_ZN5clang4ento23SimpleConstraintManager18assumeAuxForSymbolEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento23SimpleConstraintManager18assumeAuxForSymbolEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprEb")
  //</editor-fold>
  protected IntrusiveRefCntPtr</*const*/ ProgramState> assumeAuxForSymbol(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    /*const*/ SymExpr /*P*/ Sym, boolean Assumption) {
    final BasicValueFactory /*&*/ BVF = getBasicVals();
    QualType T = Sym.getType();
    
    // None of the constraint solvers currently support non-integer types.
    if (!T.$arrow().isIntegralOrEnumerationType()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    }
    
    final /*const*/ APSInt /*&*/ zero = BVF.getValue($int2ulong(0), new QualType(T));
    if (Assumption) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(assumeSymNE($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, zero, zero));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(assumeSymEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, zero, zero));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  @Override public String toString() {
    return "" + "SU=" + "[SubEngine]" // NOI18N
              + ", SVB=" + "[SValBuilder]" // NOI18N
              + super.toString(); // NOI18N
  }
}
