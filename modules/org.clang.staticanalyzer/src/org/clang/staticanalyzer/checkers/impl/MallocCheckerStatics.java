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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type MallocCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.MallocCheckerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL18getDeepPointeeTypeN5clang8QualTypeE;_ZL18getFreeWhenDoneArgRKN5clang4ento14ObjCMethodCallE;_ZL19didPreviousFreeFailN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprERS8_;_ZL21treatUnusedNewEscapedPKN5clang10CXXNewExprE;_ZL23findFailedReallocSymbolN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEES5_;_ZL26checkIfNewOrNewArrayFamilyPKN12_GLOBAL__N_18RefStateE;_ZL28isKnownDeallocObjCMethodNameRKN5clang4ento14ObjCMethodCallE;_ZL7retTruePKN12_GLOBAL__N_18RefStateE;_ZN12_GLOBAL__N_111RegionStateE;_ZN12_GLOBAL__N_120StopTrackingCallbackE; -static-type=MallocCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class MallocCheckerStatics {

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 512,
 FQN="(anonymous namespace)::RegionState", NM="_ZN12_GLOBAL__N_111RegionStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_111RegionStateE")
//</editor-fold>
public static class RegionState {
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 521,
 FQN="(anonymous namespace)::StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackE")
//</editor-fold>
public static final class StopTrackingCallback extends /*public*/ SymbolVisitor implements Destructors.ClassWithDestructor {
  private IntrusiveRefCntPtr</*const*/ ProgramState> state;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 524,
   FQN="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE")
  //</editor-fold>
  public StopTrackingCallback(IntrusiveRefCntPtr</*const*/ ProgramState> st) {
    // : SymbolVisitor(), state(std::move(st)) 
    //START JInit
    super();
    this.state = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, std.move(st));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 525,
   FQN="(anonymous namespace)::StopTrackingCallback::getState", NM="_ZNK12_GLOBAL__N_120StopTrackingCallback8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_120StopTrackingCallback8getStateEv")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> getState() /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(state);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::VisitSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 527,
   FQN="(anonymous namespace)::StopTrackingCallback::VisitSymbol", NM="_ZN12_GLOBAL__N_120StopTrackingCallback11VisitSymbolEPKN5clang4ento7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallback11VisitSymbolEPKN5clang4ento7SymExprE")
  //</editor-fold>
  @Override public boolean VisitSymbol(/*const*/ SymExpr /*P*/ sym)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(state.$assign($c$.track(state.$arrow().remove(org.clang.staticanalyzer.checkers.ento.impl.MallocCheckerStatics.ProgramStateTraitRegionState.$Instance, sym))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 521,
   FQN="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackC1EOS0_")
  //</editor-fold>
  public /*inline*/ StopTrackingCallback(JD$Move _dparam, final StopTrackingCallback /*&&*/$Prm0) {
    // : SymbolVisitor(static_cast<StopTrackingCallback &&>()), state(static_cast<StopTrackingCallback &&>().state) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.state = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, $Prm0.state);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::~StopTrackingCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 521,
   FQN="(anonymous namespace)::StopTrackingCallback::~StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    state.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "state=" + state // NOI18N
              + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="getDeepPointeeType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 926,
 FQN="getDeepPointeeType", NM="_ZL18getDeepPointeeTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL18getDeepPointeeTypeN5clang8QualTypeE")
//</editor-fold>
public static QualType getDeepPointeeType(QualType T) {
  QualType Result = new QualType(T);
  QualType PointeeType = T.$arrow().getPointeeType();
  while (!PointeeType.isNull()) {
    Result.$assign(PointeeType);
    PointeeType.$assignMove(PointeeType.$arrow().getPointeeType());
  }
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="treatUnusedNewEscaped">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 935,
 FQN="treatUnusedNewEscaped", NM="_ZL21treatUnusedNewEscapedPKN5clang10CXXNewExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL21treatUnusedNewEscapedPKN5clang10CXXNewExprE")
//</editor-fold>
public static boolean treatUnusedNewEscaped(/*const*/ CXXNewExpr /*P*/ NE) {
  
  /*const*/ CXXConstructExpr /*P*/ ConstructE = NE.getConstructExpr();
  if (!(ConstructE != null)) {
    return false;
  }
  if (!(NE.getAllocatedType().$arrow().getAsCXXRecordDecl() != null)) {
    return false;
  }
  
  /*const*/ CXXConstructorDecl /*P*/ CtorD = ConstructE.getConstructor();
  
  // Iterate over the constructor parameters.
  for (/*const*/ ParmVarDecl /*P*/ CtorParam : CtorD.parameters$Const()) {
    
    QualType CtorParamPointeeT = CtorParam.getType().$arrow().getPointeeType();
    if (CtorParamPointeeT.isNull()) {
      continue;
    }
    
    CtorParamPointeeT.$assignMove(getDeepPointeeType(new QualType(CtorParamPointeeT)));
    if ((CtorParamPointeeT.$arrow().getAsCXXRecordDecl() != null)) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isKnownDeallocObjCMethodName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1007,
 FQN="isKnownDeallocObjCMethodName", NM="_ZL28isKnownDeallocObjCMethodNameRKN5clang4ento14ObjCMethodCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL28isKnownDeallocObjCMethodNameRKN5clang4ento14ObjCMethodCallE")
//</editor-fold>
public static boolean isKnownDeallocObjCMethodName(final /*const*/ ObjCMethodCall /*&*/ Call) {
  // If the first selector piece is one of the names below, assume that the
  // object takes ownership of the memory, promising to eventually deallocate it
  // with free().
  // Ex:  [NSData dataWithBytesNoCopy:bytes length:10];
  // (...unless a 'freeWhenDone' parameter is false, but that's checked later.)
  StringRef FirstSlot = Call.getSelector().getNameForSlot(0);
  return $eq_StringRef(/*NO_COPY*/FirstSlot, /*STRINGREF_STR*/"dataWithBytesNoCopy")
     || $eq_StringRef(/*NO_COPY*/FirstSlot, /*STRINGREF_STR*/"initWithBytesNoCopy")
     || $eq_StringRef(/*NO_COPY*/FirstSlot, /*STRINGREF_STR*/"initWithCharactersNoCopy");
}

//<editor-fold defaultstate="collapsed" desc="getFreeWhenDoneArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1019,
 FQN="getFreeWhenDoneArg", NM="_ZL18getFreeWhenDoneArgRKN5clang4ento14ObjCMethodCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL18getFreeWhenDoneArgRKN5clang4ento14ObjCMethodCallE")
//</editor-fold>
public static OptionalBool getFreeWhenDoneArg(final /*const*/ ObjCMethodCall /*&*/ Call) {
  Selector S = Call.getSelector();
  
  // FIXME: We should not rely on fully-constrained symbols being folded.
  for (/*uint*/int i = 1; $less_uint(i, S.getNumArgs()); ++i)  {
    if (S.getNameForSlot(i).equals(/*STRINGREF_STR*/"freeWhenDone")) {
      return new OptionalBool(JD$T$RR.INSTANCE, !Call.getArgSVal(i).isZeroConstant());
    }
  }
  
  return new OptionalBool(None);
}


/// Checks if the previous call to free on the given symbol failed - if free
/// failed, returns true. Also, returns the corresponding return value symbol.
//<editor-fold defaultstate="collapsed" desc="didPreviousFreeFail">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed to type$ref*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1186,
 FQN="didPreviousFreeFail", NM="_ZL19didPreviousFreeFailN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprERS8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL19didPreviousFreeFailN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprERS8_")
//</editor-fold>
public static boolean didPreviousFreeFail(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                   /*const*/ SymExpr /*P*/ Sym, final type$ref</*const*/SymExpr/*P*/> /*&*/ RetStatusSymbol) {
  type$ptr</*const*/ SymExpr /*P*/ /*const*/ /*P*/> Ret = State.$arrow()./*<FreeReturnValue>*/get(ProgramStateTraitFreeReturnValue.$Instance, Sym);
  if (/*JAVA*/(Ret != null)) {
    ConditionTruthVal FreeFailed = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((Ret.$star() != null)) : "We should not store the null return symbol";
      final ConstraintManager /*&*/ CMgr = State.$arrow().getConstraintManager();
      FreeFailed = $c$.clean(CMgr.isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Ret.$star()));
      RetStatusSymbol.$set(/*JAVA: if RetStatusSymbol is single ptr*/Ret.$star());
      return FreeFailed.isConstrainedTrue();
    } finally {
      if (FreeFailed != null) { FreeFailed.$destroy(); }
      $c$.$destroy();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="retTrue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2544,
 FQN="retTrue", NM="_ZL7retTruePKN12_GLOBAL__N_18RefStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL7retTruePKN12_GLOBAL__N_18RefStateE")
//</editor-fold>
public static boolean retTrue(/*const*/ RefState /*P*/ RS) {
  return true;
}

//<editor-fold defaultstate="collapsed" desc="checkIfNewOrNewArrayFamily">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2548,
 FQN="checkIfNewOrNewArrayFamily", NM="_ZL26checkIfNewOrNewArrayFamilyPKN12_GLOBAL__N_18RefStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL26checkIfNewOrNewArrayFamilyPKN12_GLOBAL__N_18RefStateE")
//</editor-fold>
public static boolean checkIfNewOrNewArrayFamily(/*const*/ RefState /*P*/ RS) {
  return (RS.getAllocationFamily() == AllocationFamily.AF_CXXNewArray
     || RS.getAllocationFamily() == AllocationFamily.AF_CXXNew);
}

//<editor-fold defaultstate="collapsed" desc="findFailedReallocSymbol">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2602,
 FQN="findFailedReallocSymbol", NM="_ZL23findFailedReallocSymbolN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZL23findFailedReallocSymbolN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEES5_")
//</editor-fold>
public static /*const*/ SymExpr /*P*/ findFailedReallocSymbol(IntrusiveRefCntPtr</*const*/ ProgramState> currState, 
                       IntrusiveRefCntPtr</*const*/ ProgramState> prevState) {
  ImmutableMapPtrType</*const*/ SymExpr /*P*/ , ReallocPair> currMap = null;
  ImmutableMapPtrType</*const*/ SymExpr /*P*/ , ReallocPair> prevMap = null;
  try {
    currMap = currState.$arrow()./*<ReallocPairs>*/get(ProgramStateTraitReallocPairs.$Instance);
    prevMap = prevState.$arrow()./*<ReallocPairs>*/get(ProgramStateTraitReallocPairs.$Instance);
    ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , ReallocPair> I = null;
    ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , ReallocPair> E = null;
    try {
      
      for (I = prevMap.begin(), E = prevMap.end();
           I.$noteq(E); I.$preInc()) {
        /*const*/ SymExpr /*P*/ sym = I.getKey();
        if (!(currMap.lookup(sym) != null)) {
          return sym;
        }
      }
    } finally {
      if (E != null) { E.$destroy(); }
      if (I != null) { I.$destroy(); }
    }
    
    return null;
  } finally {
    if (prevMap != null) { prevMap.$destroy(); }
    if (currMap != null) { currMap.$destroy(); }
  }
}

} // END OF class MallocCheckerStatics
