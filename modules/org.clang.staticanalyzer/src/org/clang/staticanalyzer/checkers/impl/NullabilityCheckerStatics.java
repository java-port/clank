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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.NullabilityCheckerStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type NullabilityCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.NullabilityCheckerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL17getNullConstraintN5clang4ento20DefinedOrUnknownSValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE;_ZL21matchValueExprForBindPKN5clang4StmtE;_ZL22getReceiverNullabilityRKN5clang4ento14ObjCMethodCallEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE;_ZL23checkInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPNS2_12ExplodedNodeERNS2_14CheckerContextE;_ZL24getNullabilityAnnotationN5clang8QualTypeE;_ZL24isARCNilInitializedLocalRN5clang4ento14CheckerContextEPKNS_4StmtE;_ZL24lookThroughImplicitCastsPKN5clang4ExprE;_ZL35checkParamsForPreconditionViolationN4llvm8ArrayRefIPN5clang11ParmVarDeclEEENS_18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEEPKNS1_15LocationContextE;_ZL35checkSelfIvarsForInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_15LocationContextE;_ZL37checkValueAtLValForInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValENS1_8QualTypeE;_ZN12_GLOBAL__N_115getMostNullableENS_11NullabilityES0_;_ZN12_GLOBAL__N_120getNullabilityStringENS_11NullabilityE;_ZN12_GLOBAL__N_1eqENS_16NullabilityStateES0_; -static-type=NullabilityCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class NullabilityCheckerStatics {


/// Returns the most nullable nullability. This is used for message expressions
/// like [reciever method], where the nullability of this expression is either
/// the nullability of the receiver or the nullability of the return type of the
/// method, depending on which is more nullable. Contradicted is considered to
/// be the most nullable, to avoid false positive results.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getMostNullable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 64,
 FQN="(anonymous namespace)::getMostNullable", NM="_ZN12_GLOBAL__N_115getMostNullableENS_11NullabilityES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_115getMostNullableENS_11NullabilityES0_")
//</editor-fold>
public static Nullability getMostNullable(Nullability Lhs, Nullability Rhs) {
  return /*static_cast*/Nullability.valueOf(std.min(((/*static_cast*//*char*/byte)Lhs.getValue()), ((/*static_cast*//*char*/byte)Rhs.getValue())));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getNullabilityString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 69,
 FQN="(anonymous namespace)::getNullabilityString", NM="_ZN12_GLOBAL__N_120getNullabilityStringENS_11NullabilityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_120getNullabilityStringENS_11NullabilityE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getNullabilityString(Nullability Nullab) {
  switch (Nullab) {
   case Contradicted:
    return $("contradicted");
   case Nullable:
    return $nullable;
   case Unspecified:
    return $("unspecified");
   case Nonnull:
    return $nonnull;
  }
  throw new llvm_unreachable("Unexpected enumeration.");
//  return $EMPTY;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator==">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 240,
 FQN="(anonymous namespace)::operator==", NM="_ZN12_GLOBAL__N_1eqENS_16NullabilityStateES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_1eqENS_16NullabilityStateES0_")
//</editor-fold>
public static boolean $eq_NullabilityState(NullabilityState Lhs, NullabilityState Rhs) {
  return Lhs.getValue() == Rhs.getValue()
     && Lhs.getNullabilitySource() == Rhs.getNullabilitySource();
}

//<editor-fold defaultstate="collapsed" desc="getNullConstraint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 278,
 FQN="getNullConstraint", NM="_ZL17getNullConstraintN5clang4ento20DefinedOrUnknownSValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL17getNullConstraintN5clang4ento20DefinedOrUnknownSValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
//</editor-fold>
public static NullConstraint getNullConstraint(DefinedOrUnknownSVal Val, 
                 IntrusiveRefCntPtr</*const*/ ProgramState> State) {
  ConditionTruthVal Nullness = null;
  try {
    Nullness = State.$arrow().isNull(new SVal(Val));
    if (Nullness.isConstrainedFalse()) {
      return NullConstraint.IsNotNull;
    }
    if (Nullness.isConstrainedTrue()) {
      return NullConstraint.IsNull;
    }
    return NullConstraint.Unknown;
  } finally {
    if (Nullness != null) { Nullness.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getNullabilityAnnotation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 348,
 FQN="getNullabilityAnnotation", NM="_ZL24getNullabilityAnnotationN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL24getNullabilityAnnotationN5clang8QualTypeE")
//</editor-fold>
public static Nullability getNullabilityAnnotation(QualType Type) {
  /*const*/ AttributedType /*P*/ AttrType = Type.$arrow().getAs$AttributedType();
  if (!(AttrType != null)) {
    return Nullability.Unspecified;
  }
  if (AttrType.getAttrKind() == AttributedType.Kind.attr_nullable) {
    return Nullability.Nullable;
  } else if (AttrType.getAttrKind() == AttributedType.Kind.attr_nonnull) {
    return Nullability.Nonnull;
  }
  return Nullability.Unspecified;
}


/// Returns true when the value stored at the given location is null
/// and the passed in type is nonnnull.
//<editor-fold defaultstate="collapsed" desc="checkValueAtLValForInvariantViolation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 361,
 FQN="checkValueAtLValForInvariantViolation", NM="_ZL37checkValueAtLValForInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValENS1_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL37checkValueAtLValForInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValENS1_8QualTypeE")
//</editor-fold>
public static boolean checkValueAtLValForInvariantViolation(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                                     SVal LV, QualType T) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (getNullabilityAnnotation(new QualType(T)) != Nullability.Nonnull) {
      return false;
    }
    
    Optional<NsLoc.MemRegionVal> RegionVal = LV.getAs(NsLoc.MemRegionVal.class);
    if (!RegionVal.$bool()) {
      return false;
    }
    
    Optional<DefinedOrUnknownSVal> StoredVal = State.$arrow().getSVal(RegionVal.$arrow().getRegion()).getAs(DefinedOrUnknownSVal.class);
    if (!StoredVal.$bool()) {
      return false;
    }
    if ($c$.clean(getNullConstraint(new DefinedOrUnknownSVal(StoredVal.$star()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))) == NullConstraint.IsNull)) {
      return true;
    }
    
    return false;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="checkParamsForPreconditionViolation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 381,
 FQN="checkParamsForPreconditionViolation", NM="_ZL35checkParamsForPreconditionViolationN4llvm8ArrayRefIPN5clang11ParmVarDeclEEENS_18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEEPKNS1_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL35checkParamsForPreconditionViolationN4llvm8ArrayRefIPN5clang11ParmVarDeclEEENS_18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEEPKNS1_15LocationContextE")
//</editor-fold>
public static boolean checkParamsForPreconditionViolation(ArrayRef<ParmVarDecl /*P*/ > Params, 
                                   IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                                   /*const*/ LocationContext /*P*/ LocCtxt) {
  for (/*const*/ ParmVarDecl /*P*/ ParamDecl : Params) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (ParamDecl.isParameterPack()) {
        break;
      }
      
      SVal LV = new SVal(JD$Move.INSTANCE, State.$arrow().getLValue(ParamDecl, LocCtxt));
      if ($c$.clean(checkValueAtLValForInvariantViolation($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new SVal(LV), 
          ParamDecl.getType()))) {
        return true;
      }
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="checkSelfIvarsForInvariantViolation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 398,
 FQN="checkSelfIvarsForInvariantViolation", NM="_ZL35checkSelfIvarsForInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL35checkSelfIvarsForInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_15LocationContextE")
//</editor-fold>
public static boolean checkSelfIvarsForInvariantViolation(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                                   /*const*/ LocationContext /*P*/ LocCtxt) {
  /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(LocCtxt.getDecl());
  if (!(MD != null) || !MD.isInstanceMethod()) {
    return false;
  }
  
  /*const*/ ImplicitParamDecl /*P*/ SelfDecl = LocCtxt.getSelfDecl();
  if (!(SelfDecl != null)) {
    return false;
  }
  
  SVal SelfVal = State.$arrow().getSVal(State.$arrow().getRegion(SelfDecl, LocCtxt));
  
  /*const*/ ObjCObjectPointerType /*P*/ SelfType = dyn_cast_ObjCObjectPointerType(SelfDecl.getType());
  if (!(SelfType != null)) {
    return false;
  }
  
  /*const*/ ObjCInterfaceDecl /*P*/ ID = SelfType.getInterfaceDecl();
  if (!(ID != null)) {
    return false;
  }
  
  for (/*const*/ ObjCIvarDecl /*P*/ IvarDecl : ID.ivars()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SVal LV = State.$arrow().getLValue(IvarDecl, new SVal(SelfVal));
      if ($c$.clean(checkValueAtLValForInvariantViolation($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new SVal(LV), IvarDecl.getType()))) {
        return true;
      }
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="checkInvariantViolation">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 429,
 FQN="checkInvariantViolation", NM="_ZL23checkInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPNS2_12ExplodedNodeERNS2_14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL23checkInvariantViolationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPNS2_12ExplodedNodeERNS2_14CheckerContextE")
//</editor-fold>
public static boolean checkInvariantViolation(IntrusiveRefCntPtr</*const*/ ProgramState> State, ExplodedNode /*P*/ N, 
                       final CheckerContext /*&*/ C) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (State.$arrow().get(ProgramStateTraitInvariantViolated.$Instance)) {
      return true;
    }
    
    /*const*/ LocationContext /*P*/ LocCtxt = C.getLocationContext();
    /*const*/ Decl /*P*/ D = LocCtxt.getDecl();
    if (!(D != null)) {
      return false;
    }
    
    ArrayRef<ParmVarDecl /*P*/ > Params/*J*/= new ArrayRef<ParmVarDecl /*P*/ >(true);
    {
      /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
      if ((BD != null)) {
        Params.$assignMove(BD.parameters$Const());
      } else {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          Params.$assignMove(FD.parameters$Const());
        } else {
          /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
          if ((MD != null)) {
            Params.$assignMove(MD.parameters());
          } else {
            return false;
          }
        }
      }
    }
    if ($c$.clean(checkParamsForPreconditionViolation(new ArrayRef<ParmVarDecl /*P*/ >(Params), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LocCtxt)
       || checkSelfIvarsForInvariantViolation($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LocCtxt))) {
      if (!N.isSink()) {
        $c$.clean(C.addTransition($c$.track(State.$arrow().set(ProgramStateTraitInvariantViolated.$Instance, true)), N));
      }
      return true;
    }
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// Find the outermost subexpression of E that is not an implicit cast.
/// This looks through the implicit casts to _Nonnull that ARC adds to
/// return expressions of ObjC types when the return type of the function or
/// method is non-null but the express is not.
//<editor-fold defaultstate="collapsed" desc="lookThroughImplicitCasts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 538,
 FQN="lookThroughImplicitCasts", NM="_ZL24lookThroughImplicitCastsPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL24lookThroughImplicitCastsPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ lookThroughImplicitCasts(/*const*/ Expr /*P*/ E) {
  assert Native.$bool(E);
  {
    
    /*const*/ ImplicitCastExpr /*P*/ ICE;
    while (((/*P*/ ICE = dyn_cast_ImplicitCastExpr(E)) != null)) {
      E = ICE.getSubExpr$Const();
    }
  }
  
  return E;
}

//<editor-fold defaultstate="collapsed" desc="getReceiverNullability">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 810,
 FQN="getReceiverNullability", NM="_ZL22getReceiverNullabilityRKN5clang4ento14ObjCMethodCallEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL22getReceiverNullabilityRKN5clang4ento14ObjCMethodCallEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
//</editor-fold>
public static Nullability getReceiverNullability(final /*const*/ ObjCMethodCall /*&*/ M, 
                      IntrusiveRefCntPtr</*const*/ ProgramState> State) {
  if (M.isReceiverSelfOrSuper()) {
    // For super and super class receivers we assume that the receiver is
    // nonnull.
    return Nullability.Nonnull;
  }
  // Otherwise look up nullability in the state.
  SVal Receiver = M.getReceiverSVal();
  {
    Optional<DefinedOrUnknownSVal> DefOrUnknown = Receiver.getAs(DefinedOrUnknownSVal.class);
    if (DefOrUnknown.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If the receiver is constrained to be nonnull, assume that it is nonnull
        // regardless of its type.
        NullConstraint Nullness = $c$.clean(getNullConstraint(new DefinedOrUnknownSVal(DefOrUnknown.$star()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        if (Nullness == NullConstraint.IsNotNull) {
          return Nullability.Nonnull;
        }
      } finally {
        $c$.$destroy();
      }
    }
  }
  Optional<NsLoc.MemRegionVal> ValueRegionSVal = Receiver.getAs(NsLoc.MemRegionVal.class);
  if (ValueRegionSVal.$bool()) {
    /*const*/ MemRegion /*P*/ SelfRegion = ValueRegionSVal.$arrow().getRegion();
    assert Native.$bool(SelfRegion);
    
    /*const*/ NullabilityState /*P*/ TrackedSelfNullability = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, SelfRegion);
    if ((TrackedSelfNullability != null)) {
      return TrackedSelfNullability.getValue();
    }
  }
  return Nullability.Unspecified;
}


/// For a given statement performing a bind, attempt to syntactically
/// match the expression resulting in the bound value.
//<editor-fold defaultstate="collapsed" desc="matchValueExprForBind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1014,
 FQN="matchValueExprForBind", NM="_ZL21matchValueExprForBindPKN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL21matchValueExprForBindPKN5clang4StmtE")
//</editor-fold>
public static /*const*/ Expr /*P*/ matchValueExprForBind(/*const*/ Stmt /*P*/ S) {
  {
    // For `x = e` the value expression is the right-hand side.
    /*const*/ BinaryOperator /*P*/ BinOp = dyn_cast_BinaryOperator(S);
    if ((BinOp != null)) {
      if (BinOp.getOpcode() == BinaryOperatorKind.BO_Assign) {
        return BinOp.getRHS();
      }
    }
  }
  {
    
    // For `int x = e` the value expression is the initializer.
    /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(S);
    if ((DS != null)) {
      if (DS.isSingleDecl()) {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DS.getSingleDecl$Const());
        if (!(VD != null)) {
          return null;
        }
        {
          
          /*const*/ Expr /*P*/ Init = VD.getInit$Const();
          if ((Init != null)) {
            return Init;
          }
        }
      }
    }
  }
  
  return null;
}


/// Returns true if \param S is a DeclStmt for a local variable that
/// ObjC automated reference counting initialized with zero.
//<editor-fold defaultstate="collapsed" desc="isARCNilInitializedLocal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1038,
 FQN="isARCNilInitializedLocal", NM="_ZL24isARCNilInitializedLocalRN5clang4ento14CheckerContextEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZL24isARCNilInitializedLocalRN5clang4ento14CheckerContextEPKNS_4StmtE")
//</editor-fold>
public static boolean isARCNilInitializedLocal(final CheckerContext /*&*/ C, /*const*/ Stmt /*P*/ S) {
  // We suppress diagnostics for ARC zero-initialized _Nonnull locals. This
  // prevents false positives when a _Nonnull local variable cannot be
  // initialized with an initialization expression:
  //    NSString * _Nonnull s; // no-warning
  //    @autoreleasepool {
  //      s = ...
  //    }
  //
  // FIXME: We should treat implicitly zero-initialized _Nonnull locals as
  // uninitialized in Sema's UninitializedValues analysis to warn when a use of
  // the zero-initialized definition will unexpectedly yield nil.
  
  // Locals are only zero-initialized when automated reference counting
  // is turned on.
  if (!C.getASTContext().getLangOpts().ObjCAutoRefCount) {
    return false;
  }
  
  /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(S);
  if (!(DS != null) || !DS.isSingleDecl()) {
    return false;
  }
  
  /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DS.getSingleDecl$Const());
  if (!(VD != null)) {
    return false;
  }
  
  // Sema only zero-initializes locals with ObjCLifetimes.
  if (!VD.getType().getQualifiers().hasObjCLifetime()) {
    return false;
  }
  
  /*const*/ Expr /*P*/ Init = VD.getInit$Const();
  assert ((Init != null)) : "ObjC local under ARC without initializer";
  
  // Return false if the local is explicitly initialized (e.g., with '= nil').
  if (!isa_ImplicitValueInitExpr(Init)) {
    return false;
  }
  
  return true;
}

} // END OF class NullabilityCheckerStatics
