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
import org.clang.analysis.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type BasicObjCFoundationChecksStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.BasicObjCFoundationChecksStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL14findKnownClassPKN5clang17ObjCInterfaceDeclEb;_ZL15GetCFNumberSizeRN5clang10ASTContextEy;_ZL18checkElementNonNilRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtE;_ZL21checkCollectionNonNilRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtE;_ZL24GetReceiverInterfaceNameRKN5clang4ento14ObjCMethodCallE;_ZL24assumeCollectionNonEmptyRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprEb;_ZL24assumeCollectionNonEmptyRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtEb;_ZL27isKnownNonNilCollectionTypeN5clang8QualTypeE;_ZL33getMethodReceiverIfKnownImmutablePKN5clang4ento9CallEventE;_ZL38alreadyExecutedAtLeastOneLoopIterationPKN5clang4ento12ExplodedNodeEPKNS_21ObjCForCollectionStmtE; -static-type=BasicObjCFoundationChecksStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class BasicObjCFoundationChecksStatics {

// end anonymous namespace

//===----------------------------------------------------------------------===//
// Utility functions.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="GetReceiverInterfaceName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 52,
 FQN="GetReceiverInterfaceName", NM="_ZL24GetReceiverInterfaceNameRKN5clang4ento14ObjCMethodCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL24GetReceiverInterfaceNameRKN5clang4ento14ObjCMethodCallE")
//</editor-fold>
public static StringRef GetReceiverInterfaceName(final /*const*/ ObjCMethodCall /*&*/ msg) {
  {
    /*const*/ ObjCInterfaceDecl /*P*/ ID = msg.getReceiverInterface();
    if ((ID != null)) {
      return ID.getIdentifier().getName();
    }
  }
  return new StringRef();
}

//<editor-fold defaultstate="collapsed" desc="findKnownClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 69,
 FQN="findKnownClass", NM="_ZL14findKnownClassPKN5clang17ObjCInterfaceDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL14findKnownClassPKN5clang17ObjCInterfaceDeclEb")
//</editor-fold>
public static FoundationClass findKnownClass(/*const*/ ObjCInterfaceDecl /*P*/ ID) {
  return findKnownClass(ID, 
              true);
}
public static FoundationClass findKnownClass(/*const*/ ObjCInterfaceDecl /*P*/ ID, 
              boolean IncludeSuperclasses/*= true*/) {
  final/*static*/ StringMap<FoundationClass> Classes = findKnownClass$$.Classes;
  if (Classes.empty()) {
    Classes.$set(/*STRINGREF_STR*/"NSArray", FoundationClass.FC_NSArray);
    Classes.$set(/*STRINGREF_STR*/"NSDictionary", FoundationClass.FC_NSDictionary);
    Classes.$set(/*STRINGREF_STR*/"NSEnumerator", FoundationClass.FC_NSEnumerator);
    Classes.$set(/*STRINGREF_STR*/"NSNull", FoundationClass.FC_NSNull);
    Classes.$set(/*STRINGREF_STR*/"NSOrderedSet", FoundationClass.FC_NSOrderedSet);
    Classes.$set(/*STRINGREF_STR*/"NSSet", FoundationClass.FC_NSSet);
    Classes.$set(/*STRINGREF_STR*/"NSString", FoundationClass.FC_NSString);
  }
  
  // FIXME: Should we cache this at all?
  FoundationClass result = Classes.lookup(ID.getIdentifier().getName());
  if (result == FoundationClass.FC_None && IncludeSuperclasses) {
    {
      /*const*/ ObjCInterfaceDecl /*P*/ Super = ID.getSuperClass();
      if ((Super != null)) {
        return findKnownClass(Super);
      }
    }
  }
  
  return result;
}
private static final class findKnownClass$$ {
  static final/*static*/ StringMap<FoundationClass> Classes/*J*/= new StringMap<FoundationClass>(FoundationClass.FC_None);
}

//<editor-fold defaultstate="collapsed" desc="GetCFNumberSize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 376,
 FQN="GetCFNumberSize", NM="_ZL15GetCFNumberSizeRN5clang10ASTContextEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL15GetCFNumberSizeRN5clang10ASTContextEy")
//</editor-fold>
public static OptionalULong GetCFNumberSize(final ASTContext /*&*/ Ctx, long/*uint64_t*/ i) {
  final/*static*/ /*const*//*uchar*/byte FixedSize[/*6*/] = GetCFNumberSize$$.FixedSize;
  if ($less_ulong_uint(i, CFNumberType.kCFNumberCharType.getValue())) {
    return new OptionalULong(JD$T$RR.INSTANCE, $uchar2ullong(FixedSize[(int)(i - $int2ullong(1))]));
  }
  
  QualType T/*J*/= new QualType();
  switch (CFNumberType.valueOf((int)i)) {
   case kCFNumberCharType:
    T.$assignMove(Ctx.CharTy.$QualType());
    break;
   case kCFNumberShortType:
    T.$assignMove(Ctx.ShortTy.$QualType());
    break;
   case kCFNumberIntType:
    T.$assignMove(Ctx.IntTy.$QualType());
    break;
   case kCFNumberLongType:
    T.$assignMove(Ctx.LongTy.$QualType());
    break;
   case kCFNumberLongLongType:
    T.$assignMove(Ctx.LongLongTy.$QualType());
    break;
   case kCFNumberFloatType:
    T.$assignMove(Ctx.FloatTy.$QualType());
    break;
   case kCFNumberDoubleType:
    T.$assignMove(Ctx.DoubleTy.$QualType());
    break;
   case kCFNumberCFIndexType:
   case kCFNumberNSIntegerType:
   case kCFNumberCGFloatType:
   default:
    // FIXME: We need a way to map from names to Type*.
    return new OptionalULong(None);
  }
  
  return new OptionalULong(JD$T$RR.INSTANCE, Ctx.getTypeSize(new QualType(T)));
}
private static final class GetCFNumberSize$$ {
  static final/*static*/ /*const*//*uchar*/byte FixedSize[/*6*/] = new /*const*//*uchar*/byte [/*6*/] {8, 16, 32, 64, 32, 64};
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="isKnownNonNilCollectionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 858,
 FQN="isKnownNonNilCollectionType", NM="_ZL27isKnownNonNilCollectionTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL27isKnownNonNilCollectionTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isKnownNonNilCollectionType(QualType T) {
  /*const*/ ObjCObjectPointerType /*P*/ PT = T.$arrow().getAs(ObjCObjectPointerType.class);
  if (!(PT != null)) {
    return false;
  }
  
  /*const*/ ObjCInterfaceDecl /*P*/ ID = PT.getInterfaceDecl();
  if (!(ID != null)) {
    return false;
  }
  switch (findKnownClass(ID)) {
   case FC_NSArray:
   case FC_NSDictionary:
   case FC_NSEnumerator:
   case FC_NSOrderedSet:
   case FC_NSSet:
    return true;
   default:
    return false;
  }
}


/// Assumes that the collection is non-nil.
///
/// If the collection is known to be nil, returns NULL to indicate an infeasible
/// path.
//<editor-fold defaultstate="collapsed" desc="checkCollectionNonNil">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 883,
 FQN="checkCollectionNonNil", NM="_ZL21checkCollectionNonNilRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL21checkCollectionNonNilRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> checkCollectionNonNil(final CheckerContext /*&*/ C, 
                     IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                     /*const*/ ObjCForCollectionStmt /*P*/ FCS) {
  IntrusiveRefCntPtr</*const*/ ProgramState> StNonNil = null;
  IntrusiveRefCntPtr</*const*/ ProgramState> StNil = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!State.$bool()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    
    SVal CollectionVal = C.getSVal(FCS.getCollection$Const());
    Optional<DefinedSVal> KnownCollection = CollectionVal.getAs(DefinedSVal.class);
    if (!KnownCollection.$bool()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    }
    
    StNonNil/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
    StNil/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//    $c$.clean(std.tie(StNonNil, StNil).$assign($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(KnownCollection.$star())))));
    // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
    std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
            $c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(KnownCollection.$star())));
    StNonNil.$assign($assume.first);
    StNil.$assign($assume.second);
    assert !$assume.first.$bool();
    assert !$assume.second.$bool();
    $c$.clean();

    if (StNil.$bool() && !StNonNil.$bool()) {
      // The collection is nil. This path is infeasible.
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, StNonNil);
  } finally {
    if (StNil != null) { StNil.$destroy(); }
    if (StNonNil != null) { StNonNil.$destroy(); }
    $c$.$destroy();
  }
}


/// Assumes that the collection elements are non-nil.
///
/// This only applies if the collection is one of those known not to contain
/// nil values.
//<editor-fold defaultstate="collapsed" desc="checkElementNonNil">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 908,
 FQN="checkElementNonNil", NM="_ZL18checkElementNonNilRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL18checkElementNonNilRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> checkElementNonNil(final CheckerContext /*&*/ C, 
                  IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  /*const*/ ObjCForCollectionStmt /*P*/ FCS) {
  if (!State.$bool()) {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
  }
  
  // See if the collection is one where we /know/ the elements are non-nil.
  if (!isKnownNonNilCollectionType(FCS.getCollection$Const().getType())) {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }
  
  /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
  /*const*/ Stmt /*P*/ Element = FCS.getElement$Const();
  
  // FIXME: Copied from ExprEngineObjC.
  Optional<Loc> ElementLoc/*J*/= new Optional<Loc>();
  {
    /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(Element);
    if ((DS != null)) {
      /*const*/ VarDecl /*P*/ ElemDecl = cast_VarDecl(DS.getSingleDecl$Const());
      assert (ElemDecl.getInit$Const() == null);
      ElementLoc.$assign_T$RR(State.$arrow().getLValue(ElemDecl, LCtx));
    } else {
      ElementLoc.$assignMove(State.$arrow().getSVal(Element, LCtx).getAs(Loc.class));
    }
  }
  if (!ElementLoc.$bool()) {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }
  
  // Go ahead and assume the value is non-nil.
  SVal Val = State.$arrow().getSVal(new Loc(ElementLoc.$star()));
  return State.$arrow().assume(Val.castAs(DefinedOrUnknownSVal.class), true);
}


/// Returns NULL state if the collection is known to contain elements
/// (or is known not to contain elements if the Assumption parameter is false.)
//<editor-fold defaultstate="collapsed" desc="assumeCollectionNonEmpty">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 941,
 FQN="assumeCollectionNonEmpty", NM="_ZL24assumeCollectionNonEmptyRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL24assumeCollectionNonEmptyRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_7SymExprEb")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> assumeCollectionNonEmpty(final CheckerContext /*&*/ C, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                        /*const*/ SymExpr /*P*/ CollectionS, boolean Assumption) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {  
    if (!State.$bool() || !(CollectionS != null)) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    }

    type$ptr</*const*/ SymExpr /*P*/ /*const*/ /*P*/> CountS = State.$arrow()./*<ContainerCountMap>*/get(ProgramStateTraitContainerCountMap.$Instance, CollectionS);
    if (!/*JAVA*/(CountS != null)) {
      /*const*/bool$ptr/*bool P*/ KnownNonEmpty = State.$arrow().get(ProgramStateTraitContainerNonEmptyMap.$Instance, CollectionS);
      if (!/*JAVA*/(KnownNonEmpty != null)) {
        return State.$arrow().set(ProgramStateTraitContainerNonEmptyMap.$Instance, CollectionS, Assumption);
      }
      return (Assumption == KnownNonEmpty.$star()) ? new IntrusiveRefCntPtr</*const*/ ProgramState>(State) : new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }

    final SValBuilder /*&*/ SvalBuilder = C.getSValBuilder();
    SVal CountGreaterThanZeroVal = $c$.clean(SvalBuilder.evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), BinaryOperatorKind.BO_GT, 
        new SVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(CountS.$star())), 
        new SVal(JD$Move.INSTANCE, SvalBuilder.makeIntVal($int2ulong(0), (CountS.$star()).getType())), 
        SvalBuilder.getConditionType()));
    Optional<DefinedSVal> CountGreaterThanZero = CountGreaterThanZeroVal.getAs(DefinedSVal.class);
    if (!CountGreaterThanZero.$bool()) {
      // The SValBuilder cannot construct a valid SVal for this condition.
      // This means we cannot properly reason about it.
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    }

    return State.$arrow().assume(new DefinedOrUnknownSVal(CountGreaterThanZero.$star()), Assumption);
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="assumeCollectionNonEmpty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 972,
 FQN="assumeCollectionNonEmpty", NM="_ZL24assumeCollectionNonEmptyRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL24assumeCollectionNonEmptyRN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_21ObjCForCollectionStmtEb")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> assumeCollectionNonEmpty(final CheckerContext /*&*/ C, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                        /*const*/ ObjCForCollectionStmt /*P*/ FCS, 
                        boolean Assumption) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!State.$bool()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    
    /*const*/ SymExpr /*P*/ CollectionS = State.$arrow().getSVal(FCS.getCollection$Const(), C.getLocationContext()).getAsSymbol();
    return $c$.clean(assumeCollectionNonEmpty(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), CollectionS, Assumption));
  } finally {
    $c$.$destroy();
  }
}


/// If the fist block edge is a back edge, we are reentering the loop.
//<editor-fold defaultstate="collapsed" desc="alreadyExecutedAtLeastOneLoopIteration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 985,
 FQN="alreadyExecutedAtLeastOneLoopIteration", NM="_ZL38alreadyExecutedAtLeastOneLoopIterationPKN5clang4ento12ExplodedNodeEPKNS_21ObjCForCollectionStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL38alreadyExecutedAtLeastOneLoopIterationPKN5clang4ento12ExplodedNodeEPKNS_21ObjCForCollectionStmtE")
//</editor-fold>
public static boolean alreadyExecutedAtLeastOneLoopIteration(/*const*/ ExplodedNode /*P*/ N, 
                                      /*const*/ ObjCForCollectionStmt /*P*/ FCS) {
  if (!(N != null)) {
    return false;
  }
  
  ProgramPoint P = N.getLocation();
  {
    Optional<BlockEdge> BE = P.getAs(BlockEdge.class);
    if (BE.$bool()) {
      return BE.$arrow().getSrc().getLoopTarget() == FCS;
    }
  }
  
  // Keep looking for a block edge.
  for (type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/> I = $tryClone(N.pred_begin$Const()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(N.pred_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
    if (alreadyExecutedAtLeastOneLoopIteration(I.$star(), FCS)) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getMethodReceiverIfKnownImmutable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1082,
 FQN="getMethodReceiverIfKnownImmutable", NM="_ZL33getMethodReceiverIfKnownImmutablePKN5clang4ento9CallEventE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZL33getMethodReceiverIfKnownImmutablePKN5clang4ento9CallEventE")
//</editor-fold>
public static /*const*/ SymExpr /*P*/ getMethodReceiverIfKnownImmutable(/*const*/ CallEvent /*P*/ Call) {
  /*const*/ ObjCMethodCall /*P*/ Message = dyn_cast_or_null_ObjCMethodCall(Call);
  if (!(Message != null)) {
    return null;
  }
  
  /*const*/ ObjCMethodDecl /*P*/ MD = Message.getDecl();
  if (!(MD != null)) {
    return null;
  }
  
  /*const*/ ObjCInterfaceDecl /*P*/ StaticClass;
  if (isa_ObjCProtocolDecl(MD.getDeclContext$Const())) {
    // We can't find out where the method was declared without doing more work.
    // Instead, see if the receiver is statically typed as a known immutable
    // collection.
    StaticClass = Message.getOriginExpr().getReceiverInterface();
  } else {
    StaticClass = MD.getClassInterface$Const();
  }
  if (!(StaticClass != null)) {
    return null;
  }
  switch (findKnownClass(StaticClass, /*IncludeSuper=*/ false)) {
   case FC_None:
    return null;
   case FC_NSArray:
   case FC_NSDictionary:
   case FC_NSEnumerator:
   case FC_NSNull:
   case FC_NSOrderedSet:
   case FC_NSSet:
   case FC_NSString:
    break;
  }
  
  return Message.getReceiverSVal().getAsSymbol();
}

} // END OF class BasicObjCFoundationChecksStatics
