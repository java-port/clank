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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;


//<editor-fold defaultstate="collapsed" desc="static type DynamicTypePropagationStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.DynamicTypePropagationStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL14findMethodDeclPKN5clang15ObjCMessageExprEPKNS_21ObjCObjectPointerTypeERNS_10ASTContextE;_ZL15recordFixedTypePKN5clang4ento9MemRegionEPKNS_13CXXMethodDeclERNS0_14CheckerContextE;_ZL18stripCastsAndSugarPKN5clang4ExprE;_ZL22getReturnTypeForMethodPKN5clang14ObjCMethodDeclEN4llvm8ArrayRefINS_8QualTypeEEEPKNS_21ObjCObjectPointerTypeERNS_10ASTContextE;_ZL24isObjCTypeParamDependentN5clang8QualTypeE;_ZL24storeWhenMoreInformativeRN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprEPKPKNS1_21ObjCObjectPointerTypeESC_SC_RNS1_10ASTContextE;_ZL30getMostInformativeDerivedClassPKN5clang21ObjCObjectPointerTypeES2_RNS_10ASTContextE;_ZL34getMostInformativeDerivedClassImplPKN5clang21ObjCObjectPointerTypeES2_S2_RNS_10ASTContextE; -static-type=DynamicTypePropagationStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class DynamicTypePropagationStatics {

//<editor-fold defaultstate="collapsed" desc="recordFixedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 144,
 FQN="recordFixedType", NM="_ZL15recordFixedTypePKN5clang4ento9MemRegionEPKNS_13CXXMethodDeclERNS0_14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL15recordFixedTypePKN5clang4ento9MemRegionEPKNS_13CXXMethodDeclERNS0_14CheckerContextE")
//</editor-fold>
public static void recordFixedType(/*const*/ MemRegion /*P*/ Region, /*const*/ CXXMethodDecl /*P*/ MD, 
               final CheckerContext /*&*/ C) {
  IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert Native.$bool(Region);
    assert Native.$bool(MD);
    
    final ASTContext /*&*/ Ctx = C.getASTContext();
    QualType Ty = Ctx.getPointerType(Ctx.getRecordType(MD.getParent$Const()));
    
    State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
    $c$.clean(State.$assign($c$.track(EntoGlobals.setDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Region, new QualType(Ty), /*CanBeSubclass=*/ false))));
    $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
  } finally {
    if (State != null) { State.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="getMostInformativeDerivedClassImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 378,
 FQN="getMostInformativeDerivedClassImpl", NM="_ZL34getMostInformativeDerivedClassImplPKN5clang21ObjCObjectPointerTypeES2_S2_RNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL34getMostInformativeDerivedClassImplPKN5clang21ObjCObjectPointerTypeES2_S2_RNS_10ASTContextE")
//</editor-fold>
public static /*const*/ ObjCObjectPointerType /*P*/ getMostInformativeDerivedClassImpl(/*const*/ ObjCObjectPointerType /*P*/ From, /*const*/ ObjCObjectPointerType /*P*/ To, 
                                  /*const*/ ObjCObjectPointerType /*P*/ MostInformativeCandidate, final ASTContext /*&*/ C) {
  // Checking if from and to are the same classes modulo specialization.
  if (From.getInterfaceDecl().getCanonicalDecl()
     == To.getInterfaceDecl().getCanonicalDecl()) {
    if (To.isSpecialized()) {
      assert (MostInformativeCandidate.isSpecialized());
      return MostInformativeCandidate;
    }
    return From;
  }
  if (To.getObjectType().getSuperClassType().isNull()) {
    // If To has no super class and From and To aren't the same then
    // To was not actually a descendent of From. In this case the best we can
    // do is 'From'.
    return From;
  }
  
  /*const*/ ObjCObjectType /*P*/ SuperOfTo = To.getObjectType().getSuperClassType().$arrow().getAs(ObjCObjectType.class);
  assert Native.$bool(SuperOfTo);
  QualType SuperPtrOfToQual = C.getObjCObjectPointerType(new QualType(SuperOfTo, 0));
  /*const*/ ObjCObjectPointerType /*P*/ SuperPtrOfTo = SuperPtrOfToQual.$arrow().getAs(ObjCObjectPointerType.class);
  if (To.isUnspecialized()) {
    return getMostInformativeDerivedClassImpl(From, SuperPtrOfTo, SuperPtrOfTo, 
        C);
  } else {
    return getMostInformativeDerivedClassImpl(From, SuperPtrOfTo, 
        MostInformativeCandidate, C);
  }
}


/// A downcast may loose specialization information. E. g.:
///   MutableMap<T, U> : Map
/// The downcast to MutableMap looses the information about the types of the
/// Map (due to the type parameters are not being forwarded to Map), and in
/// general there is no way to recover that information from the
/// declaration. In order to have to most information, lets find the most
/// derived type that has all the type parameters forwarded.
///
/// Get the a subclass of \p From (which has a lower bound \p To) that do not
/// loose information about type parameters. \p To has to be a subclass of
/// \p From. From has to be specialized.
//<editor-fold defaultstate="collapsed" desc="getMostInformativeDerivedClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 423,
 FQN="getMostInformativeDerivedClass", NM="_ZL30getMostInformativeDerivedClassPKN5clang21ObjCObjectPointerTypeES2_RNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL30getMostInformativeDerivedClassPKN5clang21ObjCObjectPointerTypeES2_RNS_10ASTContextE")
//</editor-fold>
public static /*const*/ ObjCObjectPointerType /*P*/ getMostInformativeDerivedClass(/*const*/ ObjCObjectPointerType /*P*/ From, 
                              /*const*/ ObjCObjectPointerType /*P*/ To, final ASTContext /*&*/ C) {
  return getMostInformativeDerivedClassImpl(From, To, To, C);
}


/// Inputs:
///   \param StaticLowerBound Static lower bound for a symbol. The dynamic lower
///   bound might be the subclass of this type.
///   \param StaticUpperBound A static upper bound for a symbol.
///   \p StaticLowerBound expected to be the subclass of \p StaticUpperBound.
///   \param Current The type that was inferred for a symbol in a previous
///   context. Might be null when this is the first time that inference happens.
/// Precondition:
///   \p StaticLowerBound or \p StaticUpperBound is specialized. If \p Current
///   is not null, it is specialized.
/// Possible cases:
///   (1) The \p Current is null and \p StaticLowerBound <: \p StaticUpperBound
///   (2) \p StaticLowerBound <: \p Current <: \p StaticUpperBound
///   (3) \p Current <: \p StaticLowerBound <: \p StaticUpperBound
///   (4) \p StaticLowerBound <: \p StaticUpperBound <: \p Current
/// Effect:
///   Use getMostInformativeDerivedClass with the upper and lower bound of the
///   set {\p StaticLowerBound, \p Current, \p StaticUpperBound}. The computed
///   lower bound must be specialized. If the result differs from \p Current or
///   \p Current is null, store the result.
//<editor-fold defaultstate="collapsed" desc="storeWhenMoreInformative">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*work with Current*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 449,
 FQN="storeWhenMoreInformative", NM="_ZL24storeWhenMoreInformativeRN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprEPKPKNS1_21ObjCObjectPointerTypeESC_SC_RNS1_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL24storeWhenMoreInformativeRN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprEPKPKNS1_21ObjCObjectPointerTypeESC_SC_RNS1_10ASTContextE")
//</editor-fold>
public static boolean storeWhenMoreInformative(final IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ State, /*const*/ SymExpr /*P*/ Sym, 
                        type$ptr</*const*/ ObjCObjectPointerType /*P*/ /*const*/ /*P*/> Current, 
                        /*const*/ ObjCObjectPointerType /*P*/ StaticLowerBound, 
                        /*const*/ ObjCObjectPointerType /*P*/ StaticUpperBound, 
                        final ASTContext /*&*/ C) {
  // TODO: The above 4 cases are not exhaustive. In particular, it is possible
  // for Current to be incomparable with StaticLowerBound, StaticUpperBound,
  // or both.
  //
  // For example, suppose Foo<T> and Bar<T> are unrelated types.
  //
  //  Foo<T> *f = ...
  //  Bar<T> *b = ...
  //
  //  id t1 = b;
  //  f = t1;
  //  id t2 = f; // StaticLowerBound is Foo<T>, Current is Bar<T>
  //
  // We should either constrain the callers of this function so that the stated
  // preconditions hold (and assert it) or rewrite the function to expicitly
  // handle the additional cases.
  
  // Precondition
  assert (StaticUpperBound.isSpecialized() || StaticLowerBound.isSpecialized());
  assert (!/*JAVA*/(Current != null) || (Current.$star()).isSpecialized());
  
  // Case (1)
  if (!/*JAVA*/(Current != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (StaticUpperBound.isUnspecialized()) {
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym, StaticLowerBound))));
        return true;
      }
      // Upper bound is specialized.
      /*const*/ ObjCObjectPointerType /*P*/ WithMostInfo = getMostInformativeDerivedClass(StaticUpperBound, StaticLowerBound, C);
      $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym, WithMostInfo))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Case (3)
  if (C.canAssignObjCInterfaces(StaticLowerBound, Current.$star())) {
    return false;
  }
  
  // Case (4)
  if (C.canAssignObjCInterfaces(Current.$star(), StaticUpperBound)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The type arguments might not be forwarded at any point of inheritance.
      /*const*/ ObjCObjectPointerType /*P*/ WithMostInfo = getMostInformativeDerivedClass(Current.$star(), StaticUpperBound, C);
      WithMostInfo
         = getMostInformativeDerivedClass(WithMostInfo, StaticLowerBound, C);
      if (WithMostInfo == Current.$star()) {
        return false;
      }
      $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym, WithMostInfo))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Case (2)
  /*const*/ ObjCObjectPointerType /*P*/ WithMostInfo = getMostInformativeDerivedClass(Current.$star(), StaticLowerBound, C);
  if (WithMostInfo != Current.$star()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym, WithMostInfo))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="stripCastsAndSugar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 612,
 FQN="stripCastsAndSugar", NM="_ZL18stripCastsAndSugarPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL18stripCastsAndSugarPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ stripCastsAndSugar(/*const*/ Expr /*P*/ E) {
  E = E.IgnoreParenImpCasts$Const();
  {
    /*const*/ PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(E);
    if ((POE != null)) {
      E = POE.getSyntacticForm$Const().IgnoreParenImpCasts$Const();
    }
  }
  {
    /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(E);
    if ((OVE != null)) {
      E = OVE.getSourceExpr().IgnoreParenImpCasts();
    }
  }
  return E;
}

//<editor-fold defaultstate="collapsed" desc="isObjCTypeParamDependent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 621,
 FQN="isObjCTypeParamDependent", NM="_ZL24isObjCTypeParamDependentN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL24isObjCTypeParamDependentN5clang8QualTypeE")
//</editor-fold>
public static boolean isObjCTypeParamDependent(QualType Type) {
  // It is illegal to typedef parameterized types inside an interface. Therfore
  // an Objective-C type can only be dependent on a type parameter when the type
  // parameter structurally present in the type itself.
  //<editor-fold defaultstate="collapsed" desc="IsObjCTypeParamDependentTypeVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 625,
   FQN="IsObjCTypeParamDependentTypeVisitor", NM="_ZZL24isObjCTypeParamDependentN5clang8QualTypeEE35IsObjCTypeParamDependentTypeVisitor",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZZL24isObjCTypeParamDependentN5clang8QualTypeEE35IsObjCTypeParamDependentTypeVisitor")
  //</editor-fold>
   class IsObjCTypeParamDependentTypeVisitor implements /*public*/ RecursiveASTVisitor<IsObjCTypeParamDependentTypeVisitor> {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="isObjCTypeParamDependent(QualType)::IsObjCTypeParamDependentTypeVisitor::IsObjCTypeParamDependentTypeVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 628,
     FQN="isObjCTypeParamDependent(QualType)::IsObjCTypeParamDependentTypeVisitor::IsObjCTypeParamDependentTypeVisitor", NM="_ZZL24isObjCTypeParamDependentN5clang8QualTypeEEN35IsObjCTypeParamDependentTypeVisitorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZZL24isObjCTypeParamDependentN5clang8QualTypeEEN35IsObjCTypeParamDependentTypeVisitorC1Ev")
    //</editor-fold>
    public IsObjCTypeParamDependentTypeVisitor() {
      // : RecursiveASTVisitor<IsObjCTypeParamDependentTypeVisitor>(), Result(false) 
      //START JInit
      $RecursiveASTVisitor();
      this.Result = false;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="isObjCTypeParamDependent(QualType)::IsObjCTypeParamDependentTypeVisitor::VisitTypedefType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 629,
     FQN="isObjCTypeParamDependent(QualType)::IsObjCTypeParamDependentTypeVisitor::VisitTypedefType", NM="_ZZL24isObjCTypeParamDependentN5clang8QualTypeEEN35IsObjCTypeParamDependentTypeVisitor16VisitTypedefTypeEPKNS_11TypedefTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZZL24isObjCTypeParamDependentN5clang8QualTypeEEN35IsObjCTypeParamDependentTypeVisitor16VisitTypedefTypeEPKNS_11TypedefTypeE")
    //</editor-fold>
    public boolean VisitTypedefType(/*const*/ TypedefType /*P*/ Type) {
      if (isa_ObjCTypeParamDecl(Type.getDecl())) {
        Result = true;
        return false;
      }
      return true;
    }

    
    public boolean Result;
    
    @Override public String toString() {
      return "" + "Result=" + Result // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  IsObjCTypeParamDependentTypeVisitor Visitor/*J*/= new IsObjCTypeParamDependentTypeVisitor();
  Visitor.TraverseType(new QualType(Type));
  return Visitor.Result;
}


/// A method might not be available in the interface indicated by the static
/// type. However it might be available in the tracked type. In order to
/// properly substitute the type parameters we need the declaration context of
/// the method. The more specialized the enclosing class of the method is, the
/// more likely that the parameter substitution will be successful.
//<editor-fold defaultstate="collapsed" desc="findMethodDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 650,
 FQN="findMethodDecl", NM="_ZL14findMethodDeclPKN5clang15ObjCMessageExprEPKNS_21ObjCObjectPointerTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL14findMethodDeclPKN5clang15ObjCMessageExprEPKNS_21ObjCObjectPointerTypeERNS_10ASTContextE")
//</editor-fold>
public static /*const*/ ObjCMethodDecl /*P*/ findMethodDecl(/*const*/ ObjCMessageExpr /*P*/ MessageExpr, 
              /*const*/ ObjCObjectPointerType /*P*/ TrackedType, final ASTContext /*&*/ ASTCtxt) {
  /*const*/ ObjCMethodDecl /*P*/ Method = null;
  
  QualType ReceiverType = MessageExpr.getReceiverType();
  /*const*/ ObjCObjectPointerType /*P*/ ReceiverObjectPtrType = ReceiverType.$arrow().getAs(ObjCObjectPointerType.class);
  
  // Do this "devirtualization" on instance and class methods only. Trust the
  // static type on super and super class calls.
  if (MessageExpr.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Instance
     || MessageExpr.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Class) {
    // When the receiver type is id, Class, or some super class of the tracked
    // type, look up the method in the tracked type, not in the receiver type.
    // This way we preserve more information.
    if (ReceiverType.$arrow().isObjCIdType() || ReceiverType.$arrow().isObjCClassType()
       || ASTCtxt.canAssignObjCInterfaces(ReceiverObjectPtrType, TrackedType)) {
      /*const*/ ObjCInterfaceDecl /*P*/ InterfaceDecl = TrackedType.getInterfaceDecl();
      // The method might not be found.
      Selector Sel = MessageExpr.getSelector();
      Method = InterfaceDecl.lookupInstanceMethod(new Selector(Sel));
      if (!(Method != null)) {
        Method = InterfaceDecl.lookupClassMethod(new Selector(Sel));
      }
    }
  }
  
  // Fallback to statick method lookup when the one based on the tracked type
  // failed.
  return (Method != null) ? Method : MessageExpr.getMethodDecl$Const();
}


/// Get the returned ObjCObjectPointerType by a method based on the tracked type
/// information, or null pointer when the returned type is not an
/// ObjCObjectPointerType.
//<editor-fold defaultstate="collapsed" desc="getReturnTypeForMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 685,
 FQN="getReturnTypeForMethod", NM="_ZL22getReturnTypeForMethodPKN5clang14ObjCMethodDeclEN4llvm8ArrayRefINS_8QualTypeEEEPKNS_21ObjCObjectPointerTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZL22getReturnTypeForMethodPKN5clang14ObjCMethodDeclEN4llvm8ArrayRefINS_8QualTypeEEEPKNS_21ObjCObjectPointerTypeERNS_10ASTContextE")
//</editor-fold>
public static QualType getReturnTypeForMethod(/*const*/ ObjCMethodDecl /*P*/ Method, ArrayRef<QualType> TypeArgs, 
                      /*const*/ ObjCObjectPointerType /*P*/ SelfType, final ASTContext /*&*/ C) {
  QualType StaticResultType = Method.getReturnType();
  
  // Is the return type declared as instance type?
  if (QualType.$eq_QualType$C(StaticResultType, C.getObjCInstanceType())) {
    return new QualType(SelfType, 0);
  }
  
  // Check whether the result type depends on a type parameter.
  if (!isObjCTypeParamDependent(new QualType(StaticResultType))) {
    return new QualType();
  }
  
  QualType ResultType = StaticResultType.substObjCTypeArgs(C, new ArrayRef<QualType>(TypeArgs), ObjCSubstitutionContext.Result);
  
  return ResultType;
}

} // END OF class DynamicTypePropagationStatics
