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

package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 294,
 FQN="(anonymous namespace)::RangeConstraintManager", NM="_ZN12_GLOBAL__N_122RangeConstraintManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManagerE")
//</editor-fold>
public class RangeConstraintManager extends /*public*/ SimpleConstraintManager implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::GetRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 415,
   FQN="(anonymous namespace)::RangeConstraintManager::GetRange", NM="_ZN12_GLOBAL__N_122RangeConstraintManager8GetRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager8GetRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprE")
  //</editor-fold>
  private RangeSet GetRange(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ sym) {
    RangeSet Result = null;
    try {
      {
        /*const*/ RangeSet /*P*/ V = state.$arrow().get(ProgramStateTraitConstraintRange.$Instance, sym);
        if ((V != null)) {
          return new RangeSet($Deref(V));
        }
      }
      
      // Lazily generate a new RangeSet representing all possible values for the
      // given symbol type.
      final BasicValueFactory /*&*/ BV = getBasicVals();
      QualType T = sym.getType();
      
      Result/*J*/= new RangeSet(F, BV.getMinValue(new QualType(T)), BV.getMaxValue(new QualType(T)));
      
      // Special case: references are known to be non-zero.
      if (T.$arrow().isReferenceType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          APSIntType IntType = BV.getAPSIntType(new QualType(T));
          $c$.clean(Result.$assignMove($c$.track(Result.Intersect(BV, F, new APSInt(IntType.getZeroValue().$preInc()), 
                  new APSInt(IntType.getZeroValue().$preDec())))));
        } finally {
          $c$.$destroy();
        }
      }
      
      return new RangeSet(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::RangeConstraintManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 297,
   FQN="(anonymous namespace)::RangeConstraintManager::RangeConstraintManager", NM="_ZN12_GLOBAL__N_122RangeConstraintManagerC1EPN5clang4ento9SubEngineERNS2_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManagerC1EPN5clang4ento9SubEngineERNS2_11SValBuilderE")
  //</editor-fold>
  public RangeConstraintManager(SubEngine /*P*/ subengine, final SValBuilder /*&*/ SVB) {
    // : SimpleConstraintManager(subengine, SVB), F() 
    //START JInit
    super(subengine, SVB);
    this.F = new ImmutableSet.Factory<Range>(RangeTrait.INSTANCE);
    //END JInit
  }

  
  
  //===------------------------------------------------------------------------===
  // assumeSymX methods: public interface for RangeConstraintManager.
  //===------------------------------------------------------------------------===/
  
  // The syntax for ranges below is mathematical, using [x, y] for closed ranges
  // and (x, y) for open ranges. These ranges are modular, corresponding with
  // a common treatment of C integer overflow. This means that these methods
  // do not have to worry about overflow; RangeSet::Intersect can handle such a
  // "wraparound" range.
  // As an example, the range [UINT_MAX-1, 3) contains five values: UINT_MAX-1,
  // UINT_MAX, 0, 1, and 2.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::assumeSymNE">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 449,
   FQN="(anonymous namespace)::RangeConstraintManager::assumeSymNE", NM="_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymNEEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymNEEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymNE(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
             final /*const*/ APSInt /*&*/ Int, 
             final /*const*/ APSInt /*&*/ Adjustment)/* override*/ {
    RangeSet New = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Before we do any real work, see if the value can even show up.
      APSIntType AdjustmentType/*J*/= new APSIntType(Adjustment);
      if (AdjustmentType.testInRange(Int, true) != APSIntType.RangeTestResultKind.RTR_Within) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, St);
      }
      
      APSInt Lower = AdjustmentType.convert(Int).$sub(Adjustment);
      APSInt Upper = new APSInt(Lower);
      Lower.$preDec();
      Upper.$preInc();
      
      // [Int-Adjustment+1, Int-Adjustment-1]
      // Notice that the lower bound is greater than the upper bound.
      New = $c$.clean($c$.track(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym)).Intersect(getBasicVals(), F, new APSInt(Upper), new APSInt(Lower)));
      return $c$.clean(New.isEmpty() ? new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null) : St.$arrow().set(ProgramStateTraitConstraintRange.$Instance, Sym, $c$.track(new RangeSet(New))));
    } finally {
      if (New != null) { New.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::assumeSymEQ">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 469,
   FQN="(anonymous namespace)::RangeConstraintManager::assumeSymEQ", NM="_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymEQEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymEQEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymEQ(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
             final /*const*/ APSInt /*&*/ Int, 
             final /*const*/ APSInt /*&*/ Adjustment)/* override*/ {
    RangeSet New = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Before we do any real work, see if the value can even show up.
      APSIntType AdjustmentType/*J*/= new APSIntType(Adjustment);
      if (AdjustmentType.testInRange(Int, true) != APSIntType.RangeTestResultKind.RTR_Within) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // [Int-Adjustment, Int-Adjustment]
      APSInt AdjInt = AdjustmentType.convert(Int).$sub(Adjustment);
      New = $c$.clean($c$.track(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym)).Intersect(getBasicVals(), F, new APSInt(AdjInt), new APSInt(AdjInt)));
      return $c$.clean(New.isEmpty() ? new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null) : St.$arrow().set(ProgramStateTraitConstraintRange.$Instance, Sym, $c$.track(new RangeSet(New))));
    } finally {
      if (New != null) { New.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::assumeSymLT">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 512,
   FQN="(anonymous namespace)::RangeConstraintManager::assumeSymLT", NM="_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymLTEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymLTEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymLT(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
             final /*const*/ APSInt /*&*/ Int, 
             final /*const*/ APSInt /*&*/ Adjustment)/* override*/ {
    RangeSet New = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      New = $c$.clean(getSymLTRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym, Int, Adjustment));
      return $c$.clean(New.isEmpty() ? new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null) : St.$arrow().set(ProgramStateTraitConstraintRange.$Instance, Sym, $c$.track(new RangeSet(New))));
    } finally {
      if (New != null) { New.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::assumeSymGT">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 548,
   FQN="(anonymous namespace)::RangeConstraintManager::assumeSymGT", NM="_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymGTEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymGTEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymGT(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
             final /*const*/ APSInt /*&*/ Int, 
             final /*const*/ APSInt /*&*/ Adjustment)/* override*/ {
    RangeSet New = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      New = $c$.clean(getSymGTRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym, Int, Adjustment));
      return $c$.clean(New.isEmpty() ? new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null) : St.$arrow().set(ProgramStateTraitConstraintRange.$Instance, Sym, $c$.track(new RangeSet(New))));
    } finally {
      if (New != null) { New.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::assumeSymGE">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 584,
   FQN="(anonymous namespace)::RangeConstraintManager::assumeSymGE", NM="_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymGEEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymGEEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymGE(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
             final /*const*/ APSInt /*&*/ Int, 
             final /*const*/ APSInt /*&*/ Adjustment)/* override*/ {
    RangeSet New = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      New = $c$.clean(getSymGERange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym, Int, Adjustment));
      return $c$.clean(New.isEmpty() ? new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null) : St.$arrow().set(ProgramStateTraitConstraintRange.$Instance, Sym, $c$.track(new RangeSet(New))));
    } finally {
      if (New != null) { New.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::assumeSymLE">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 648,
   FQN="(anonymous namespace)::RangeConstraintManager::assumeSymLE", NM="_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymLEEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager11assumeSymLEEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymLE(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
             final /*const*/ APSInt /*&*/ Int, 
             final /*const*/ APSInt /*&*/ Adjustment)/* override*/ {
    RangeSet New = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      New = $c$.clean(getSymLERange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym, Int, Adjustment));
      return $c$.clean(New.isEmpty() ? new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null) : St.$arrow().set(ProgramStateTraitConstraintRange.$Instance, Sym, $c$.track(new RangeSet(New))));
    } finally {
      if (New != null) { New.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::assumeSymbolWithinInclusiveRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 656,
   FQN="(anonymous namespace)::RangeConstraintManager::assumeSymbolWithinInclusiveRange", NM="_ZN12_GLOBAL__N_122RangeConstraintManager32assumeSymbolWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_SD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager32assumeSymbolWithinInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_SD_")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymbolWithinInclusiveRange(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ SymExpr /*P*/ Sym, final /*const*/ APSInt /*&*/ From, 
                                  final /*const*/ APSInt /*&*/ To, final /*const*/ APSInt /*&*/ Adjustment)/* override*/ {
    RangeSet New = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      New = $c$.clean(getSymGERange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, From, Adjustment));
      if (New.isEmpty()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      $c$.clean(New.$assignMove($c$.track(getSymLERange(New, To, Adjustment))));
      return $c$.clean(New.isEmpty() ? new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null) : State.$arrow().set(ProgramStateTraitConstraintRange.$Instance, Sym, $c$.track(new RangeSet(New))));
    } finally {
      if (New != null) { New.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::assumeSymbolOutOfInclusiveRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 667,
   FQN="(anonymous namespace)::RangeConstraintManager::assumeSymbolOutOfInclusiveRange", NM="_ZN12_GLOBAL__N_122RangeConstraintManager31assumeSymbolOutOfInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_SD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager31assumeSymbolOutOfInclusiveRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_SD_")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> assumeSymbolOutOfInclusiveRange(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ SymExpr /*P*/ Sym, final /*const*/ APSInt /*&*/ From, 
                                 final /*const*/ APSInt /*&*/ To, final /*const*/ APSInt /*&*/ Adjustment)/* override*/ {
    RangeSet RangeLT = null;
    RangeSet RangeGT = null;
    RangeSet New = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      RangeLT = $c$.clean(getSymLTRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, From, Adjustment));
      RangeGT = $c$.clean(getSymGTRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, To, Adjustment));
      New/*J*/= RangeLT.addRange(F, RangeGT);
      return $c$.clean(New.isEmpty() ? new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null) : State.$arrow().set(ProgramStateTraitConstraintRange.$Instance, Sym, $c$.track(new RangeSet(New))));
    } finally {
      if (New != null) { New.$destroy(); }
      if (RangeGT != null) { RangeGT.$destroy(); }
      if (RangeLT != null) { RangeLT.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::getSymVal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 367,
   FQN="(anonymous namespace)::RangeConstraintManager::getSymVal", NM="_ZNK12_GLOBAL__N_122RangeConstraintManager9getSymValEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_122RangeConstraintManager9getSymValEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprE")
  //</editor-fold>
  @Override public /*const*/ APSInt /*P*/ getSymVal(IntrusiveRefCntPtr</*const*/ ProgramState> St, 
           /*const*/ SymExpr /*P*/ sym) /*const*//* override*/ {
    /*const*/ RangeSet /*P*/ T = St.$arrow().get(ProgramStateTraitConstraintRange.$Instance, sym);
    return (T != null) ? T.getConcreteValue() : null;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::checkNull">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 373,
   FQN="(anonymous namespace)::RangeConstraintManager::checkNull", NM="_ZN12_GLOBAL__N_122RangeConstraintManager9checkNullEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager9checkNullEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprE")
  //</editor-fold>
  @Override public ConditionTruthVal checkNull(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
           /*const*/ SymExpr /*P*/ Sym)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ RangeSet /*P*/ Ranges = State.$arrow().get(ProgramStateTraitConstraintRange.$Instance, Sym);
      
      // If we don't have any information about this symbol, it's underconstrained.
      if (!(Ranges != null)) {
        return new ConditionTruthVal();
      }
      {
        
        // If we have a concrete value, see if it's zero.
        /*const*/ APSInt /*P*/ Value = Ranges.getConcreteValue();
        if ((Value != null)) {
          return new ConditionTruthVal($Deref(Value).$eq(0));
        }
      }
      
      final BasicValueFactory /*&*/ BV = getBasicVals();
      APSIntType IntType = BV.getAPSIntType(Sym.getType());
      APSInt Zero = IntType.getZeroValue();
      
      // Check if zero is in the set of possible values.
      if ($c$.clean($c$.track(Ranges.Intersect(BV, F, new APSInt(Zero), new APSInt(Zero))).isEmpty())) {
        return new ConditionTruthVal(false);
      }
      
      // Zero is a possible value, but it is not the /only/ possible value.
      return new ConditionTruthVal();
    } finally {
      $c$.$destroy();
    }
  }

  
  
  /// Scan all symbols referenced by the constraints. If the symbol is not alive
  /// as marked in LSymbols, mark it as dead in DSymbols.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::removeDeadBindings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 399,
   FQN="(anonymous namespace)::RangeConstraintManager::removeDeadBindings", NM="_ZN12_GLOBAL__N_122RangeConstraintManager18removeDeadBindingsEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS4_12SymbolReaperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager18removeDeadBindingsEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS4_12SymbolReaperE")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> removeDeadBindings(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                    final SymbolReaper /*&*/ SymReaper)/* override*/ {
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RangeSet> CR = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      CR = state.$arrow().get(ProgramStateTraitConstraintRange.$Instance);
      final ImmutableMapPtrType.Factory</*const*/ SymExpr /*P*/ , RangeSet> /*&*/ CRFactory = state.$arrow().get_context(ProgramStateTraitConstraintRange.$Instance);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RangeSet> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RangeSet> E = null;
      try {
        
        for (I = CR.begin(), E = CR.end(); I.$noteq(E); I.$preInc()) {
          /*const*/ SymExpr /*P*/ sym = I.getKey();
          if (SymReaper.maybeDead(sym)) {
            $c$.clean(CR.$assign($c$.track(CRFactory.remove($c$.track(new ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RangeSet>(CR)), sym))));
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      return $c$.clean(state.$arrow().set(ProgramStateTraitConstraintRange.$Instance, $c$.track(new ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RangeSet>(CR))));
    } finally {
      if (CR != null) { CR.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  //===------------------------------------------------------------------------===
  // Pretty-printing.
  //===------------------------------------------------------------------------===/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 681,
   FQN="(anonymous namespace)::RangeConstraintManager::print", NM="_ZN12_GLOBAL__N_122RangeConstraintManager5printEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS1_11raw_ostreamEPKcSB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager5printEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS1_11raw_ostreamEPKcSB_")
  //</editor-fold>
  @Override public void print(IntrusiveRefCntPtr</*const*/ ProgramState> St, final raw_ostream /*&*/ Out, 
       /*const*/char$ptr/*char P*/ nl, /*const*/char$ptr/*char P*/ sep)/* override*/ {
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RangeSet> Ranges = null;
    try {
      
      Ranges = St.$arrow().get(ProgramStateTraitConstraintRange.$Instance);
      if (Ranges.isEmpty()) {
        Out.$out(nl).$out(sep).$out(/*KEEP_STR*/"Ranges are empty.").$out(nl);
        return;
      }
      
      Out.$out(nl).$out(sep).$out(/*KEEP_STR*/"Ranges of symbol values:");
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RangeSet> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RangeSet> E = null;
      try {
        for (I = Ranges.begin(), E = Ranges.end(); I.$noteq(E); I.$preInc()) {
          StaticanalyzerLlvmGlobals.$out_raw_ostream_SymExpr$C$P(Out.$out(nl).$out_char($$SPACE), I.getKey()).$out(/*KEEP_STR*/" : ");
          I.getData().print(Out);
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      Out.$out(nl);
    } finally {
      if (Ranges != null) { Ranges.$destroy(); }
    }
  }

/*private:*/
  private ImmutableSet.Factory<Range> F;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::getSymLTRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 484,
   FQN="(anonymous namespace)::RangeConstraintManager::getSymLTRange", NM="_ZN12_GLOBAL__N_122RangeConstraintManager13getSymLTRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager13getSymLTRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  private RangeSet getSymLTRange(IntrusiveRefCntPtr</*const*/ ProgramState> St, 
               /*const*/ SymExpr /*P*/ Sym, 
               final /*const*/ APSInt /*&*/ Int, 
               final /*const*/ APSInt /*&*/ Adjustment) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Before we do any real work, see if the value can even show up.
      APSIntType AdjustmentType/*J*/= new APSIntType(Adjustment);
      switch (AdjustmentType.testInRange(Int, true)) {
       case RTR_Below:
        return $c$.clean(new RangeSet($c$.track(F.getEmptySet())));
       case RTR_Within:
        break;
       case RTR_Above:
        return $c$.clean(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym));
      }
      
      // Special case for Int == Min. This is always false.
      APSInt ComparisonVal = AdjustmentType.convert(Int);
      APSInt Min = AdjustmentType.getMinValue();
      if (ComparisonVal.$eq(Min)) {
        return $c$.clean(new RangeSet($c$.track(F.getEmptySet())));
      }
      
      APSInt Lower = Min.$sub(Adjustment);
      APSInt Upper = ComparisonVal.$sub(Adjustment);
      Upper.$preDec();
      
      return $c$.clean($c$.track(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym)).Intersect(getBasicVals(), F, new APSInt(Lower), new APSInt(Upper)));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::getSymGTRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 520,
   FQN="(anonymous namespace)::RangeConstraintManager::getSymGTRange", NM="_ZN12_GLOBAL__N_122RangeConstraintManager13getSymGTRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager13getSymGTRangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  private RangeSet getSymGTRange(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
               final /*const*/ APSInt /*&*/ Int, 
               final /*const*/ APSInt /*&*/ Adjustment) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Before we do any real work, see if the value can even show up.
      APSIntType AdjustmentType/*J*/= new APSIntType(Adjustment);
      switch (AdjustmentType.testInRange(Int, true)) {
       case RTR_Below:
        return $c$.clean(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym));
       case RTR_Within:
        break;
       case RTR_Above:
        return $c$.clean(new RangeSet($c$.track(F.getEmptySet())));
      }
      
      // Special case for Int == Max. This is always false.
      APSInt ComparisonVal = AdjustmentType.convert(Int);
      APSInt Max = AdjustmentType.getMaxValue();
      if (ComparisonVal.$eq(Max)) {
        return $c$.clean(new RangeSet($c$.track(F.getEmptySet())));
      }
      
      APSInt Lower = ComparisonVal.$sub(Adjustment);
      APSInt Upper = Max.$sub(Adjustment);
      Lower.$preInc();
      
      return $c$.clean($c$.track(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym)).Intersect(getBasicVals(), F, new APSInt(Lower), new APSInt(Upper)));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::getSymLERange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 620,
   FQN="(anonymous namespace)::RangeConstraintManager::getSymLERange", NM="_ZN12_GLOBAL__N_122RangeConstraintManager13getSymLERangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager13getSymLERangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  private RangeSet getSymLERange(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
               final /*const*/ APSInt /*&*/ Int, 
               final /*const*/ APSInt /*&*/ Adjustment) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Before we do any real work, see if the value can even show up.
      APSIntType AdjustmentType/*J*/= new APSIntType(Adjustment);
      switch (AdjustmentType.testInRange(Int, true)) {
       case RTR_Below:
        return $c$.clean(new RangeSet($c$.track(F.getEmptySet())));
       case RTR_Within:
        break;
       case RTR_Above:
        return $c$.clean(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym));
      }
      
      // Special case for Int == Max. This is always feasible.
      APSInt ComparisonVal = AdjustmentType.convert(Int);
      APSInt Max = AdjustmentType.getMaxValue();
      if (ComparisonVal.$eq(Max)) {
        return $c$.clean(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym));
      }
      
      APSInt Min = AdjustmentType.getMinValue();
      APSInt Lower = Min.$sub(Adjustment);
      APSInt Upper = ComparisonVal.$sub(Adjustment);
      
      return $c$.clean($c$.track(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym)).Intersect(getBasicVals(), F, new APSInt(Lower), new APSInt(Upper)));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::getSymLERange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 592,
   FQN="(anonymous namespace)::RangeConstraintManager::getSymLERange", NM="_ZN12_GLOBAL__N_122RangeConstraintManager13getSymLERangeERKNS_8RangeSetERKN4llvm6APSIntES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager13getSymLERangeERKNS_8RangeSetERKN4llvm6APSIntES7_")
  //</editor-fold>
  private RangeSet getSymLERange(final /*const*/ RangeSet /*&*/ RS, 
               final /*const*/ APSInt /*&*/ Int, 
               final /*const*/ APSInt /*&*/ Adjustment) {
    // Before we do any real work, see if the value can even show up.
    APSIntType AdjustmentType/*J*/= new APSIntType(Adjustment);
    switch (AdjustmentType.testInRange(Int, true)) {
     case RTR_Below:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new RangeSet($c$.track(F.getEmptySet())));
        } finally {
          $c$.$destroy();
        }
      }
     case RTR_Within:
      break;
     case RTR_Above:
      return new RangeSet(RS);
    }
    
    // Special case for Int == Max. This is always feasible.
    APSInt ComparisonVal = AdjustmentType.convert(Int);
    APSInt Max = AdjustmentType.getMaxValue();
    if (ComparisonVal.$eq(Max)) {
      return new RangeSet(RS);
    }
    
    APSInt Min = AdjustmentType.getMinValue();
    APSInt Lower = Min.$sub(Adjustment);
    APSInt Upper = ComparisonVal.$sub(Adjustment);
    
    return RS.Intersect(getBasicVals(), F, new APSInt(Lower), new APSInt(Upper));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::getSymGERange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 556,
   FQN="(anonymous namespace)::RangeConstraintManager::getSymGERange", NM="_ZN12_GLOBAL__N_122RangeConstraintManager13getSymGERangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManager13getSymGERangeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprERKNS1_6APSIntESD_")
  //</editor-fold>
  private RangeSet getSymGERange(IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ SymExpr /*P*/ Sym, 
               final /*const*/ APSInt /*&*/ Int, 
               final /*const*/ APSInt /*&*/ Adjustment) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Before we do any real work, see if the value can even show up.
      APSIntType AdjustmentType/*J*/= new APSIntType(Adjustment);
      switch (AdjustmentType.testInRange(Int, true)) {
       case RTR_Below:
        return $c$.clean(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym));
       case RTR_Within:
        break;
       case RTR_Above:
        return $c$.clean(new RangeSet($c$.track(F.getEmptySet())));
      }
      
      // Special case for Int == Min. This is always feasible.
      APSInt ComparisonVal = AdjustmentType.convert(Int);
      APSInt Min = AdjustmentType.getMinValue();
      if (ComparisonVal.$eq(Min)) {
        return $c$.clean(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym));
      }
      
      APSInt Max = AdjustmentType.getMaxValue();
      APSInt Lower = ComparisonVal.$sub(Adjustment);
      APSInt Upper = Max.$sub(Adjustment);
      
      return $c$.clean($c$.track(GetRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym)).Intersect(getBasicVals(), F, new APSInt(Lower), new APSInt(Upper)));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeConstraintManager::~RangeConstraintManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 294,
   FQN="(anonymous namespace)::RangeConstraintManager::~RangeConstraintManager", NM="_ZN12_GLOBAL__N_122RangeConstraintManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_122RangeConstraintManagerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    F.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + super.toString(); // NOI18N
  }
}
