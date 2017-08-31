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
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.NullabilityCheckerStatics.*;
import org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals;
import org.clang.staticanalyzer.java.*;
import org.llvm.support.sys.path;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 95,
 FQN="(anonymous namespace)::NullabilityChecker", NM="_ZN12_GLOBAL__N_118NullabilityCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityCheckerE")
//</editor-fold>
public class NullabilityChecker extends /*public*/ Checker/*<Bind, PreCall, PreStmt<ReturnStmt>, PostCall, PostStmt<ExplicitCastExpr>, PostObjCMessage, DeadSymbols, Event<ImplicitNullDerefEvent> >*/ 
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PostCallChecker, org.clang.staticanalyzer.java.EventChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, org.clang.staticanalyzer.java.BindChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
/*public:*/
  // If true, the checker will not diagnose nullabilility issues for calls
  // to system headers. This option is motivated by the observation that large
  // projects may have many nullability warnings. These projects may
  // find warnings about nullability annotations that they have explicitly
  // added themselves higher priority to fix than warnings on calls to system
  // libraries.
  public DefaultBool NoDiagnoseCallsToSystemHeaders;
  
  
  /// Propagate the nullability information through binds and warn when nullable
  /// pointer or null symbol is assigned to a pointer with a nonnull type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::checkBind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*resolve context-dependent static locals*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1080,
   FQN="(anonymous namespace)::NullabilityChecker::checkBind", NM="_ZNK12_GLOBAL__N_118NullabilityChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkBind(SVal L, SVal V, /*const*/ Stmt /*P*/ S, 
           final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ TypedValueRegion /*P*/ TVR = dyn_cast_or_null_TypedValueRegion(L.getAsRegion());
      if (!(TVR != null)) {
        return;
      }
      
      QualType LocType = TVR.getValueType();
      if (!LocType.$arrow().isAnyPointerType()) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (State.$arrow().get(ProgramStateTraitInvariantViolated.$Instance)) {
        return;
      }
      
      Optional<DefinedOrUnknownSVal> ValDefOrUnknown = V.getAs(DefinedOrUnknownSVal.class);
      if (!ValDefOrUnknown.$bool()) {
        return;
      }
      
      NullConstraint RhsNullness = $c$.clean(NullabilityCheckerStatics.getNullConstraint(new DefinedOrUnknownSVal(ValDefOrUnknown.$star()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      
      Nullability ValNullability = Nullability.Unspecified;
      {
        /*const*/ SymExpr /*P*/ Sym = ValDefOrUnknown.$arrow().getAsSymbol();
        if ((Sym != null)) {
          ValNullability = NullabilityCheckerStatics.getNullabilityAnnotation(Sym.getType());
        }
      }
      
      Nullability LocNullability = NullabilityCheckerStatics.getNullabilityAnnotation(new QualType(LocType));
      
      // If the type of the RHS expression is nonnull, don't warn. This
      // enables explicit suppression with a cast to nonnull.
      Nullability ValueExprTypeLevelNullability = Nullability.Unspecified;
      /*const*/ Expr /*P*/ ValueExpr = NullabilityCheckerStatics.matchValueExprForBind(S);
      if ((ValueExpr != null)) {
        ValueExprTypeLevelNullability
           = NullabilityCheckerStatics.getNullabilityAnnotation(NullabilityCheckerStatics.lookThroughImplicitCasts(ValueExpr).getType());
      }
      
      boolean NullAssignedToNonNull = (LocNullability == Nullability.Nonnull
         && RhsNullness == NullConstraint.IsNull);
      if (Filter.CheckNullPassedToNonnull.$ConstBoolRef()
         && NullAssignedToNonNull
         && ValNullability != Nullability.Nonnull
         && ValueExprTypeLevelNullability != Nullability.Nonnull
         && !NullabilityCheckerStatics.isARCNilInitializedLocal(C, S)) {
        // JAVA: need to use accessor
        final/*static*/ CheckerProgramPointTag Tag = checkBind$$.TagNullPassedToNonnull();
        ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), $AddrOf(Tag)));
        if (!(N != null)) {
          return;
        }
        
        /*const*/ Stmt /*P*/ ValueStmt = S;
        if ((ValueExpr != null)) {
          ValueStmt = ValueExpr;
        }
        
        reportBugIfInvariantHolds(new StringRef(/*KEEP_STR*/"Null is assigned to a pointer which is expected to have non-null value"), 
            ErrorKind.NilAssignedToNonnull, N, (/*const*/ MemRegion /*P*/ )null, C, 
            ValueStmt);
        return;
      }
      
      // If null was returned from a non-null function, mark the nullability
      // invariant as violated even if the diagnostic was suppressed.
      if (NullAssignedToNonNull) {
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitInvariantViolated.$Instance, true))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      
      // Intentionally missing case: '0' is bound to a reference. It is handled by
      // the DereferenceChecker.
      /*const*/ MemRegion /*P*/ ValueRegion = getTrackRegion(new SVal(ValDefOrUnknown.$star()));
      if (!(ValueRegion != null)) {
        return;
      }
      
      /*const*/ NullabilityState /*P*/ TrackedNullability = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, ValueRegion);
      if ((TrackedNullability != null)) {
        if (RhsNullness == NullConstraint.IsNotNull
           || TrackedNullability.getValue() != Nullability.Nullable) {
          return;
        }
        if (Filter.CheckNullablePassedToNonnull.$ConstBoolRef()
           && LocNullability == Nullability.Nonnull) {
          // JAVA: need to use accessor
          final/*static*/ CheckerProgramPointTag Tag = checkBind$$.TagNullablePassedToNonnull();
          ExplodedNode /*P*/ N = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C.getPredecessor(), $AddrOf(Tag)));
          reportBugIfInvariantHolds(new StringRef(/*KEEP_STR*/"Nullable pointer is assigned to a pointer which is expected to have non-null value"), 
              ErrorKind.NullableAssignedToNonnull, N, 
              ValueRegion, C);
        }
        return;
      }
      
      /*const*/ BinaryOperator /*P*/ BinOp = dyn_cast_BinaryOperator(S);
      if (ValNullability == Nullability.Nullable) {
        // Trust the static information of the value more than the static
        // information on the location.
        /*const*/ Stmt /*P*/ NullabilitySource = (BinOp != null) ? BinOp.getRHS() : S;
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, ValueRegion, new NullabilityState(ValNullability, NullabilitySource)))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      if (LocNullability == Nullability.Nullable) {
        /*const*/ Stmt /*P*/ NullabilitySource = (BinOp != null) ? BinOp.getLHS() : S;
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, ValueRegion, new NullabilityState(LocNullability, NullabilitySource)))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      }
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }
  // MANUAL: moved below in extra members
//  private static final class checkBind$$ {
//    // JAVA: must not be static
//    // JAVA: can't initialize statically as "this" is used in init expr
//    final static /*static*/ CheckerProgramPointTag TagNullPassedToNonnull = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullPassedToNonnull"));
//    final static /*static*/ CheckerProgramPointTag TagNullablePassedToNonnull = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullablePassedToNonnull"));
//  }

  
  /// Explicit casts are trusted. If there is a disagreement in the nullability
  /// annotations in the destination and the source or '0' is casted to nonnull
  /// track the value as having contraditory nullability. This will allow users to
  /// suppress warnings.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 957,
   FQN="(anonymous namespace)::NullabilityChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118NullabilityChecker13checkPostStmtEPKN5clang16ExplicitCastExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker13checkPostStmtEPKN5clang16ExplicitCastExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ExplicitCastExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      QualType OriginType = CE.getSubExpr$Const().getType();
      QualType DestType = CE.getType();
      if (!OriginType.$arrow().isAnyPointerType()) {
        return;
      }
      if (!DestType.$arrow().isAnyPointerType()) {
        return;
      }

      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (State.$arrow().get(ProgramStateTraitInvariantViolated.$Instance)) {
        return;
      }

      Nullability DestNullability = NullabilityCheckerStatics.getNullabilityAnnotation(new QualType(DestType));

      // No explicit nullability in the destination type, so this cast does not
      // change the nullability.
      if (DestNullability == Nullability.Unspecified) {
        return;
      }

      Optional<DefinedOrUnknownSVal> RegionSVal = State.$arrow().getSVal(CE, C.getLocationContext()).getAs(DefinedOrUnknownSVal.class);
      /*const*/ MemRegion /*P*/ Region = getTrackRegion(new SVal(RegionSVal.$star()));
      if (!(Region != null)) {
        return;
      }

      // When 0 is converted to nonnull mark it as contradicted.
      if (DestNullability == Nullability.Nonnull) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          NullConstraint Nullness = $c$.clean(NullabilityCheckerStatics.getNullConstraint(new DefinedOrUnknownSVal(RegionSVal.$star()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          if (Nullness == NullConstraint.IsNull) {
            $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, Region, new NullabilityState(Nullability.Contradicted)))));
            $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
            return;
          }
        } finally {
          $c$.$destroy();
        }
      }

      /*const*/ NullabilityState /*P*/ TrackedNullability = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, Region);
      if (!(TrackedNullability != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (DestNullability != Nullability.Nullable) {
            return;
          }
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, Region, 
                  new NullabilityState(DestNullability, CE)))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      if (TrackedNullability.getValue() != DestNullability
         && TrackedNullability.getValue() != Nullability.Contradicted) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, Region, new NullabilityState(Nullability.Contradicted)))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

    
  /// This method check when nullable pointer or null value is returned from a
  /// function that has nonnull return type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*resolve context-dependent static locals*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 550,
   FQN="(anonymous namespace)::NullabilityChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_118NullabilityChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ S, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Expr /*P*/ RetExpr = S.getRetValue$Const();
      if (!(RetExpr != null)) {
        return;
      }
      if (!RetExpr.getType().$arrow().isAnyPointerType()) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (State.$arrow().get(ProgramStateTraitInvariantViolated.$Instance)) {
        return;
      }
      
      Optional<DefinedOrUnknownSVal> RetSVal = State.$arrow().getSVal(S, C.getLocationContext()).getAs(DefinedOrUnknownSVal.class);
      if (!RetSVal.$bool()) {
        return;
      }
      
      boolean InSuppressedMethodFamily = false;
      
      QualType RequiredRetType/*J*/= new QualType();
      AnalysisDeclContext /*P*/ DeclCtxt = C.getLocationContext().getAnalysisDeclContext();
      /*const*/ Decl /*P*/ D = DeclCtxt.getDecl();
      {
        /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
        if ((MD != null)) {
          // HACK: This is a big hammer to avoid warning when there are defensive
          // nil checks in -init and -copy methods. We should add more sophisticated
          // logic here to suppress on common defensive idioms but still
          // warn when there is a likely problem.
          ObjCMethodFamily Family = MD.getMethodFamily();
          if (ObjCMethodFamily.OMF_init == Family || ObjCMethodFamily.OMF_copy == Family || ObjCMethodFamily.OMF_mutableCopy == Family) {
            InSuppressedMethodFamily = true;
          }
          
          RequiredRetType.$assignMove(MD.getReturnType());
        } else {
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
          if ((FD != null)) {
            RequiredRetType.$assignMove(FD.getReturnType());
          } else {
            return;
          }
        }
      }
      
      NullConstraint Nullness = $c$.clean(NullabilityCheckerStatics.getNullConstraint(new DefinedOrUnknownSVal(RetSVal.$star()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      
      Nullability RequiredNullability = NullabilityCheckerStatics.getNullabilityAnnotation(new QualType(RequiredRetType));
      
      // If the returned value is null but the type of the expression
      // generating it is nonnull then we will suppress the diagnostic.
      // This enables explicit suppression when returning a nil literal in a
      // function with a _Nonnull return type:
      //    return (NSString * _Nonnull)0;
      Nullability RetExprTypeLevelNullability = NullabilityCheckerStatics.getNullabilityAnnotation(NullabilityCheckerStatics.lookThroughImplicitCasts(RetExpr).getType());
      
      boolean NullReturnedFromNonNull = (RequiredNullability == Nullability.Nonnull
         && Nullness == NullConstraint.IsNull);
      if (Filter.CheckNullReturnedFromNonnull.$ConstBoolRef()
         && NullReturnedFromNonNull
         && RetExprTypeLevelNullability != Nullability.Nonnull
         && !InSuppressedMethodFamily
         && C.getLocationContext().inTopFrame()) {
        raw_svector_ostream OS = null;
        try {
          // JAVA: need to use accessor
          final/*static*/ CheckerProgramPointTag Tag = checkPreStmt$$.TagNullReturnedFromNonnull();
          ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), $AddrOf(Tag)));
          if (!(N != null)) {
            return;
          }
          
          SmallString/*<256>*/ SBuf/*J*/= new SmallString/*<256>*/(256);
          OS/*J*/= new raw_svector_ostream(SBuf);
          OS.$out(/*KEEP_STR*/"Null is returned from a ").$out(C.getDeclDescription(D)).$out(
              /*KEEP_STR*/" that is expected to return a non-null value"
          );
          
          reportBugIfInvariantHolds(OS.str(), 
              ErrorKind.NilReturnedToNonnull, N, (/*const*/ MemRegion /*P*/ )null, C, 
              RetExpr);
          return;
        } finally {
          if (OS != null) { OS.$destroy(); }
        }
      }
      
      // If null was returned from a non-null function, mark the nullability
      // invariant as violated even if the diagnostic was suppressed.
      if (NullReturnedFromNonNull) {
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitInvariantViolated.$Instance, true))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      
      /*const*/ MemRegion /*P*/ Region = getTrackRegion(new SVal(RetSVal.$star()));
      if (!(Region != null)) {
        return;
      }
      
      /*const*/ NullabilityState /*P*/ TrackedNullability = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, Region);
      if ((TrackedNullability != null)) {
        Nullability TrackedNullabValue = TrackedNullability.getValue();
        if (Filter.CheckNullableReturnedFromNonnull.$ConstBoolRef()
           && Nullness != NullConstraint.IsNotNull
           && TrackedNullabValue == Nullability.Nullable
           && RequiredNullability == Nullability.Nonnull) {
          raw_svector_ostream OS = null;
          try {
            // JAVA: need to use accessor
            final/*static*/ CheckerProgramPointTag Tag = checkPreStmt$$.TagNullableReturnedFromNonnull();
            ExplodedNode /*P*/ N = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C.getPredecessor(), $AddrOf(Tag)));
            
            SmallString/*<256>*/ SBuf/*J*/= new SmallString/*<256>*/(256);
            OS/*J*/= new raw_svector_ostream(SBuf);
            OS.$out(/*KEEP_STR*/"Nullable pointer is returned from a ").$out(C.getDeclDescription(D)).$out(
                /*KEEP_STR*/" that is expected to return a non-null value"
            );
            
            reportBugIfInvariantHolds(OS.str(), 
                ErrorKind.NullableReturnedToNonnull, N, 
                Region, C);
          } finally {
            if (OS != null) { OS.$destroy(); }
          }
        }
        return;
      }
      if (RequiredNullability == Nullability.Nullable) {
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, Region, 
                new NullabilityState(RequiredNullability, 
                    S)))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      }
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }
  // MANUAL: moved below in extra members
//  private static final class checkPreStmt$$ {
//    // JAVA: must not be static
//    final static /*static*/ CheckerProgramPointTag TagNullReturnedFromNonnull = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullReturnedFromNonnull"));
//    final static /*static*/ CheckerProgramPointTag TagNullableReturnedFromNonnull = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullableReturnedFromNonnull"));
//  }

  
  /// Calculate the nullability of the result of a message expr based on the
  /// nullability of the receiver, the nullability of the return value, and the
  /// constraints.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 842,
   FQN="(anonymous namespace)::NullabilityChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_118NullabilityChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, 
                      final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ ObjCMethodDecl /*P*/ Decl = M.getDecl();
      if (!(Decl != null)) {
        return;
      }
      QualType RetType = Decl.getReturnType();
      if (!RetType.$arrow().isAnyPointerType()) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (State.$arrow().get(ProgramStateTraitInvariantViolated.$Instance)) {
        return;
      }
      
      /*const*/ MemRegion /*P*/ ReturnRegion = getTrackRegion(M.getReturnValue());
      if (!(ReturnRegion != null)) {
        return;
      }
      
      /*const*/ ObjCInterfaceDecl /*P*/ Interface = Decl.getClassInterface$Const();
      StringRef Name = (Interface != null) ? Interface.getName() : new StringRef(/*KEEP_STR*/$EMPTY);
      // In order to reduce the noise in the diagnostics generated by this checker,
      // some framework and programming style based heuristics are used. These
      // heuristics are for Cocoa APIs which have NS prefix.
      if (Name.startswith(/*STRINGREF_STR*/"NS")) {
        // Developers rely on dynamic invariants such as an item should be available
        // in a collection, or a collection is not empty often. Those invariants can
        // not be inferred by any static analysis tool. To not to bother the users
        // with too many false positives, every item retrieval function should be
        // ignored for collections. The instance methods of dictionaries in Cocoa
        // are either item retrieval related or not interesting nullability wise.
        // Using this fact, to keep the code easier to read just ignore the return
        // value of every instance method of dictionaries.
        if (M.isInstanceMessage() && Name.find(/*STRINGREF_STR*/"Dictionary") != StringRef.npos) {
          $c$.clean(State.$assign(
              $c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, ReturnRegion, new NullabilityState(Nullability.Contradicted)))
          ));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          return;
        }
        // For similar reasons ignore some methods of Cocoa arrays.
        StringRef FirstSelectorSlot = M.getSelector().getNameForSlot(0);
        if (Name.find(/*STRINGREF_STR*/"Array") != StringRef.npos
           && ($eq_StringRef(/*NO_COPY*/FirstSelectorSlot, /*STRINGREF_STR*/"firstObject")
           || $eq_StringRef(/*NO_COPY*/FirstSelectorSlot, /*STRINGREF_STR*/"lastObject"))) {
          $c$.clean(State.$assign(
              $c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, ReturnRegion, new NullabilityState(Nullability.Contradicted)))
          ));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          return;
        }
        
        // Encoding related methods of string should not fail when lossless
        // encodings are used. Using lossless encodings is so frequent that ignoring
        // this class of methods reduced the emitted diagnostics by about 30% on
        // some projects (and all of that was false positives).
        if (Name.find(/*STRINGREF_STR*/"String") != StringRef.npos) {
          for (ParmVarDecl /*P*/ Param : M.parameters()) {
            if ($eq_StringRef(Param.getName(), /*STRINGREF_STR*/"encoding")) {
              $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, ReturnRegion, 
                      new NullabilityState(Nullability.Contradicted)))));
              $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
              return;
            }
          }
        }
      }
      
      /*const*/ ObjCMessageExpr /*P*/ Message = M.getOriginExpr();
      Nullability SelfNullability = $c$.clean(NullabilityCheckerStatics.getReceiverNullability(M, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      
      /*const*/ NullabilityState /*P*/ NullabilityOfReturn = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, ReturnRegion);
      if ((NullabilityOfReturn != null)) {
        // When we have a nullability tracked for the return value, the nullability
        // of the expression will be the most nullable of the receiver and the
        // return value.
        Nullability RetValTracked = NullabilityOfReturn.getValue();
        Nullability ComputedNullab = NullabilityCheckerStatics.getMostNullable(RetValTracked, SelfNullability);
        if (ComputedNullab != RetValTracked
           && ComputedNullab != Nullability.Unspecified) {
          /*const*/ Stmt /*P*/ NullabilitySource = ComputedNullab == RetValTracked ? NullabilityOfReturn.getNullabilitySource() : Message.getInstanceReceiver$Const();
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, ReturnRegion, new NullabilityState(ComputedNullab, NullabilitySource)))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        }
        return;
      }
      
      // No tracked information. Use static type information for return value.
      Nullability RetNullability = NullabilityCheckerStatics.getNullabilityAnnotation(new QualType(RetType));
      
      // Properties might be computed. For this reason the static analyzer creates a
      // new symbol each time an unknown property  is read. To avoid false pozitives
      // do not treat unknown properties as nullable, even when they explicitly
      // marked nullable.
      if (M.getMessageKind() == ObjCMessageKind.OCM_PropertyAccess && !C.wasInlined) {
        RetNullability = Nullability.Nonnull;
      }
      
      Nullability ComputedNullab = NullabilityCheckerStatics.getMostNullable(RetNullability, SelfNullability);
      if (ComputedNullab == Nullability.Nullable) {
        /*const*/ Stmt /*P*/ NullabilitySource = ComputedNullab == RetNullability ? Message : Message.getInstanceReceiver$Const();
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, ReturnRegion, new NullabilityState(ComputedNullab, NullabilitySource)))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      }
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Suppress the nullability warnings for some functions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::checkPostCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 768,
   FQN="(anonymous namespace)::NullabilityChecker::checkPostCall", NM="_ZNK12_GLOBAL__N_118NullabilityChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ Call, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      /*const*/ Decl /*P*/ $Decl = Call.getDecl();
      if (!($Decl != null)) {
        return;
      }
      // ObjC Messages handles in a different callback.
      if (Call.getKind() == CallEventKind.CE_ObjCMessage) {
        return;
      }
      /*const*/ FunctionType /*P*/ FuncType = $Decl.getFunctionType();
      if (!(FuncType != null)) {
        return;
      }
      QualType ReturnType = FuncType.getReturnType();
      if (!ReturnType.$arrow().isAnyPointerType()) {
        return;
      }
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (State.$arrow().get(ProgramStateTraitInvariantViolated.$Instance)) {
        return;
      }

      /*const*/ MemRegion /*P*/ Region = getTrackRegion(Call.getReturnValue());
      if (!(Region != null)) {
        return;
      }

      // CG headers are misannotated. Do not warn for symbols that are the results
      // of CG calls.
      final /*const*/ SourceManager /*&*/ SM = C.getSourceManager();
      StringRef FilePath = SM.getFilename(SM.getSpellingLoc($Decl.getLocStart()));
      if (path.filename(/*NO_COPY*/FilePath).startswith(/*STRINGREF_STR*/"CG")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, Region, new NullabilityState(Nullability.Contradicted)))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          return;
        } finally {
          $c$.$destroy();
        }
      }

      /*const*/ NullabilityState /*P*/ TrackedNullability = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, Region);
      if (!(TrackedNullability != null)
         && NullabilityCheckerStatics.getNullabilityAnnotation(new QualType(ReturnType)) == Nullability.Nullable) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, Region, new NullabilityState(Nullability.Nullable)))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }


  /// This callback warns when a nullable pointer or a null value is passed to a
  /// function that expects its argument to be nonnull.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::checkPreCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 669,
   FQN="(anonymous namespace)::NullabilityChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_118NullabilityChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> OrigState = null;
    try {
      if (!(Call.getDecl() != null)) {
        return;
      }

      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (State.$arrow().get(ProgramStateTraitInvariantViolated.$Instance)) {
        return;
      }

      OrigState = new IntrusiveRefCntPtr</*const*/ ProgramState>(State);

      /*uint*/int Idx = 0;
      for (/*const*/ ParmVarDecl /*P*/ Param : Call.parameters()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (Param.isParameterPack()) {
            break;
          }

          /*const*/ Expr /*P*/ ArgExpr = null;
          if ($less_uint(Idx, Call.getNumArgs())) {
            ArgExpr = Call.getArgExpr(Idx);
          }
          Optional<DefinedOrUnknownSVal> ArgSVal = Call.getArgSVal(Idx++).getAs(DefinedOrUnknownSVal.class);
          if (!ArgSVal.$bool()) {
            continue;
          }
          if (!Param.getType().$arrow().isAnyPointerType()
             && !Param.getType().$arrow().isReferenceType()) {
            continue;
          }

          NullConstraint Nullness = $c$.clean(NullabilityCheckerStatics.getNullConstraint(new DefinedOrUnknownSVal(ArgSVal.$star()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));

          Nullability RequiredNullability = NullabilityCheckerStatics.getNullabilityAnnotation(Param.getType());
          Nullability ArgExprTypeLevelNullability = NullabilityCheckerStatics.getNullabilityAnnotation(ArgExpr.getType());

          /*uint*/int ParamIdx = Param.getFunctionScopeIndex() + 1;
          if (Filter.CheckNullPassedToNonnull.$ConstBoolRef() && Nullness == NullConstraint.IsNull
             && ArgExprTypeLevelNullability != Nullability.Nonnull
             && RequiredNullability == Nullability.Nonnull
             && isDiagnosableCall(Call)) {
            raw_svector_ostream OS = null;
            try {
              ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
              if (!(N != null)) {
                return;
              }
              SmallString/*<256>*/ SBuf/*J*/= new SmallString/*<256>*/(256);
              OS/*J*/= new raw_svector_ostream(SBuf);
              OS.$out(/*KEEP_STR*/"Null passed to a callee that requires a non-null ").$out_uint(ParamIdx).$out(
                  llvm.getOrdinalSuffix(ParamIdx)
              ).$out(/*KEEP_STR*/" parameter");
              reportBugIfInvariantHolds(OS.str(), ErrorKind.NilPassedToNonnull, N, 
                  (/*const*/ MemRegion /*P*/ )null, C, 
                  ArgExpr, /*SuppressPath=*/ false);
              return;
            } finally {
              if (OS != null) { OS.$destroy(); }
            }
          }

          /*const*/ MemRegion /*P*/ Region = getTrackRegion(new SVal(ArgSVal.$star()));
          if (!(Region != null)) {
            continue;
          }

          /*const*/ NullabilityState /*P*/ TrackedNullability = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, Region);
          if ((TrackedNullability != null)) {
            if (Nullness == NullConstraint.IsNotNull
               || TrackedNullability.getValue() != Nullability.Nullable) {
              continue;
            }
            if (Filter.CheckNullablePassedToNonnull.$ConstBoolRef()
               && RequiredNullability == Nullability.Nonnull
               && isDiagnosableCall(Call)) {
              raw_svector_ostream OS = null;
              try {
                ExplodedNode /*P*/ N = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
                SmallString/*<256>*/ SBuf/*J*/= new SmallString/*<256>*/(256);
                OS/*J*/= new raw_svector_ostream(SBuf);
                OS.$out(/*KEEP_STR*/"Nullable pointer is passed to a callee that requires a non-null ").$out_uint(
                    ParamIdx
                ).$out(llvm.getOrdinalSuffix(ParamIdx)).$out(/*KEEP_STR*/" parameter");
                reportBugIfInvariantHolds(OS.str(), 
                    ErrorKind.NullablePassedToNonnull, N, 
                    Region, C, ArgExpr, /*SuppressPath=*/ true);
                return;
              } finally {
                if (OS != null) { OS.$destroy(); }
              }
            }
            if (Filter.CheckNullableDereferenced.$ConstBoolRef()
               && Param.getType().$arrow().isReferenceType()) {
              ExplodedNode /*P*/ N = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
              reportBugIfInvariantHolds(new StringRef(/*KEEP_STR*/"Nullable pointer is dereferenced"), 
                  ErrorKind.NullableDereferenced, N, Region, 
                  C, ArgExpr, /*SuppressPath=*/ true);
              return;
            }
            continue;
          }
          // No tracked nullability yet.
          if (ArgExprTypeLevelNullability != Nullability.Nullable) {
            continue;
          }
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitNullabilityMap.$Instance, Region, new NullabilityState(ArgExprTypeLevelNullability, ArgExpr)))));
        } finally {
          $c$.$destroy();
        }
      }
      if ($noteq_IntrusiveRefCntPtr(State, OrigState)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
     if (OrigState != null) { OrigState.$destroy(); }
     if (State != null) { State.$destroy(); }
    } 
  }

  
  /// Cleaning up the program state.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 474,
   FQN="(anonymous namespace)::NullabilityChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_118NullabilityChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SR, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableMapPtrType</*const*/ MemRegion /*P*/ , NullabilityState> Nullabilities = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!SR.hasDeadSymbols()) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      Nullabilities = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance);
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , NullabilityState> I = null;
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , NullabilityState> E = null;
      try {
        for (I = Nullabilities.begin(), 
            E = Nullabilities.end();
             I.$noteq(E); I.$preInc()) {
          /*const*/ SymbolicRegion /*P*/ Region = I.$arrow().first.getAs(SymbolicRegion.class);
          assert ((Region != null)) : "Non-symbolic region is tracked.";
          if (SR.isDead(Region.getSymbol())) {
            $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitNullabilityMap.$Instance, I.$arrow().first))));
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      // When one of the nonnull arguments are constrained to be null, nullability
      // preconditions are violated. It is not enough to check this only when we
      // actually report an error, because at that time interesting symbols might be
      // reaped.
      if ($c$.clean(NullabilityCheckerStatics.checkInvariantViolation($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C.getPredecessor(), C))) {
        return;
      }
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (Nullabilities != null) { Nullabilities.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// This callback triggers when a pointer is dereferenced and the analyzer does
  /// not know anything about the value of that pointer. When that pointer is
  /// nullable, this code emits a warning.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::checkEvent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 502,
   FQN="(anonymous namespace)::NullabilityChecker::checkEvent", NM="_ZNK12_GLOBAL__N_118NullabilityChecker10checkEventEN5clang4ento22ImplicitNullDerefEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker10checkEventEN5clang4ento22ImplicitNullDerefEventE")
  //</editor-fold>
  public void checkEvent(ImplicitNullDerefEvent Event) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      if (Event.SinkNode.getState().$arrow().get(ProgramStateTraitInvariantViolated.$Instance)) {
        return;
      }

      /*const*/ MemRegion /*P*/ Region = getTrackRegion(new SVal(Event.Location), /*CheckSuperregion=*/ true);
      if (!(Region != null)) {
        return;
      }

      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Event.SinkNode.getState());
      /*const*/ NullabilityState /*P*/ TrackedNullability = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, Region);
      if (!(TrackedNullability != null)) {
        return;
      }
      if (Filter.CheckNullableDereferenced.$ConstBoolRef()
         && TrackedNullability.getValue() == Nullability.Nullable) {
        final BugReporter /*&*/ BR = $Deref(Event.BR);
        // Do not suppress errors on defensive code paths, because dereferencing
        // a nullable pointer is always an error.
        if (Event.IsDirectDereference) {
          reportBug(new StringRef(/*KEEP_STR*/"Nullable pointer is dereferenced"), 
              ErrorKind.NullableDereferenced, Event.SinkNode, Region, BR);
        } else {
          reportBug(new StringRef(/*KEEP_STR*/"Nullable pointer is passed to a callee that requires a non-null"), ErrorKind.NullablePassedToNonnull, 
              Event.SinkNode, Region, BR);
        }
      }
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::printState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1194,
   FQN="(anonymous namespace)::NullabilityChecker::printState", NM="_ZNK12_GLOBAL__N_118NullabilityChecker10printStateERN4llvm11raw_ostreamENS1_18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKcSB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker10printStateERN4llvm11raw_ostreamENS1_18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKcSB_")
  //</editor-fold>
  @Override public void printState(final raw_ostream /*&*/ Out, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            /*const*/char$ptr/*char P*/ NL, /*const*/char$ptr/*char P*/ Sep) /*const*//* override*/ {
    ImmutableMapPtrType</*const*/ MemRegion /*P*/ , NullabilityState> B = null;
    try {
      
      B = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance);
      if (B.isEmpty()) {
        return;
      }
      
      Out.$out(Sep).$out(NL);
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , NullabilityState> I = null;
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , NullabilityState> E = null;
      try {
        
        for (I = B.begin(), E = B.end(); I.$noteq(E); I.$preInc()) {
          StaticanalyzerLlvmGlobals.$out_raw_ostream_MemRegion$C$P(Out, I.$arrow().first).$out(/*KEEP_STR*/" : ");
          I.$arrow().second.print(Out);
          Out.$out(NL);
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityChecksFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 123,
   FQN="(anonymous namespace)::NullabilityChecker::NullabilityChecksFilter", NM="_ZN12_GLOBAL__N_118NullabilityChecker23NullabilityChecksFilterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityChecker23NullabilityChecksFilterE")
  //</editor-fold>
  public static class/*struct*/ NullabilityChecksFilter {
    public DefaultBool CheckNullPassedToNonnull;
    public DefaultBool CheckNullReturnedFromNonnull;
    public DefaultBool CheckNullableDereferenced;
    public DefaultBool CheckNullablePassedToNonnull;
    public DefaultBool CheckNullableReturnedFromNonnull;
    
    public CheckName CheckNameNullPassedToNonnull;
    public CheckName CheckNameNullReturnedFromNonnull;
    public CheckName CheckNameNullableDereferenced;
    public CheckName CheckNameNullablePassedToNonnull;
    public CheckName CheckNameNullableReturnedFromNonnull;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityChecksFilter::NullabilityChecksFilter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 123,
     FQN="(anonymous namespace)::NullabilityChecker::NullabilityChecksFilter::NullabilityChecksFilter", NM="_ZN12_GLOBAL__N_118NullabilityChecker23NullabilityChecksFilterC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityChecker23NullabilityChecksFilterC1Ev")
    //</editor-fold>
    public /*inline*/ NullabilityChecksFilter() {
      // : CheckNullPassedToNonnull(), CheckNullReturnedFromNonnull(), CheckNullableDereferenced(), CheckNullablePassedToNonnull(), CheckNullableReturnedFromNonnull(), CheckNameNullPassedToNonnull(), CheckNameNullReturnedFromNonnull(), CheckNameNullableDereferenced(), CheckNameNullablePassedToNonnull(), CheckNameNullableReturnedFromNonnull() 
      //START JInit
      this.CheckNullPassedToNonnull = new DefaultBool();
      this.CheckNullReturnedFromNonnull = new DefaultBool();
      this.CheckNullableDereferenced = new DefaultBool();
      this.CheckNullablePassedToNonnull = new DefaultBool();
      this.CheckNullableReturnedFromNonnull = new DefaultBool();
      this.CheckNameNullPassedToNonnull = new CheckName();
      this.CheckNameNullReturnedFromNonnull = new CheckName();
      this.CheckNameNullableDereferenced = new CheckName();
      this.CheckNameNullablePassedToNonnull = new CheckName();
      this.CheckNameNullableReturnedFromNonnull = new CheckName();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "CheckNullPassedToNonnull=" + CheckNullPassedToNonnull // NOI18N
                + ", CheckNullReturnedFromNonnull=" + CheckNullReturnedFromNonnull // NOI18N
                + ", CheckNullableDereferenced=" + CheckNullableDereferenced // NOI18N
                + ", CheckNullablePassedToNonnull=" + CheckNullablePassedToNonnull // NOI18N
                + ", CheckNullableReturnedFromNonnull=" + CheckNullableReturnedFromNonnull // NOI18N
                + ", CheckNameNullPassedToNonnull=" + CheckNameNullPassedToNonnull // NOI18N
                + ", CheckNameNullReturnedFromNonnull=" + CheckNameNullReturnedFromNonnull // NOI18N
                + ", CheckNameNullableDereferenced=" + CheckNameNullableDereferenced // NOI18N
                + ", CheckNameNullablePassedToNonnull=" + CheckNameNullablePassedToNonnull // NOI18N
                + ", CheckNameNullableReturnedFromNonnull=" + CheckNameNullableReturnedFromNonnull; // NOI18N
    }
  };
  
  public NullabilityChecksFilter Filter;
  // When set to false no nullability information will be tracked in
  // NullabilityMap. It is possible to catch errors like passing a null pointer
  // to a callee that expects nonnull argument without the information that is
  // stroed in the NullabilityMap. This is an optimization.
  public DefaultBool NeedTracking;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 145,
   FQN="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor", NM="_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitorE")
  //</editor-fold>
  private static class NullabilityBugVisitor extends /*public*/ BugReporterVisitorImpl<NullabilityBugVisitor> implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::NullabilityBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 148,
     FQN="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::NullabilityBugVisitor", NM="_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitorC1EPKN5clang4ento9MemRegionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitorC1EPKN5clang4ento9MemRegionE")
    //</editor-fold>
    public NullabilityBugVisitor(/*const*/ MemRegion /*P*/ M) {
      // : BugReporterVisitorImpl<NullabilityBugVisitor>(), Region(M) 
      //START JInit
      super();
      this.Region = M;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::Profile">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 150,
     FQN="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::Profile", NM="_ZNK12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
      final/*static*/ Object X = Profile$$.X;
      ID.AddPointer($AddrOf(X));
      ID.AddPointer(Region);
    }
    private static final class Profile$$ {
      static final/*static*/ Object X = NullabilityBugVisitor.class;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::VisitNode">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 309,
     FQN="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::VisitNode", NM="_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE")
    //</editor-fold>
    @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, /*const*/ ExplodedNode /*P*/ PrevN, final BugReporterContext /*&*/ BRC, 
             final BugReport /*&*/ BR)/* override*/ {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      IntrusiveRefCntPtr</*const*/ ProgramState> StatePrev = null;
      try {
        State = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
        StatePrev = new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevN.getState());

        /*const*/ NullabilityState /*P*/ TrackedNullab = State.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, Region);
        /*const*/ NullabilityState /*P*/ TrackedNullabPrev = StatePrev.$arrow().get(ProgramStateTraitNullabilityMap.$Instance, Region);
        if (!(TrackedNullab != null)) {
          return null;
        }
        if ((TrackedNullabPrev != null)
           && TrackedNullabPrev.getValue() == TrackedNullab.getValue()) {
          return null;
        }

        // Retrieve the associated statement.
        /*const*/ Stmt /*P*/ S = TrackedNullab.getNullabilitySource();
        if (!(S != null)) {
          ProgramPoint ProgLoc = N.getLocation();
          {
            Optional<StmtPoint> SP = ProgLoc.getAs(StmtPoint.class);
            if (SP.$bool()) {
              S = SP.$arrow().getStmt();
            }
          }
        }
        if (!(S != null)) {
          return null;
        }

        std.string InfoText = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"Nullability '"), 
                new Twine(NullabilityCheckerStatics.getNullabilityString(TrackedNullab.getValue()))), new Twine(/*KEEP_STR*/"' is infered"))).
            str();

        // Generate the extra diagnostic.
        PathDiagnosticLocation Pos/*J*/= new PathDiagnosticLocation(S, BRC.getSourceManager(), 
            new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, N.getLocationContext()));
        return new PathDiagnosticEventPiece(Pos, new StringRef(InfoText), true, (StackHintGenerator /*P*/ )null);
      } finally {
       if (StatePrev != null) { StatePrev.$destroy(); }
       if (State != null) { State.$destroy(); }
      } 
    }

  /*private:*/
    // The tracked region.
    private /*const*/ MemRegion /*P*/ Region;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::~NullabilityBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 145,
     FQN="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::~NullabilityBugVisitor", NM="_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitorD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::NullabilityBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 145,
     FQN="(anonymous namespace)::NullabilityChecker::NullabilityBugVisitor::NullabilityBugVisitor", NM="_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityChecker21NullabilityBugVisitorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ NullabilityBugVisitor(final /*const*/ NullabilityBugVisitor /*&*/ $Prm0) {
      // : BugReporterVisitorImpl<NullabilityBugVisitor>(), Region(.Region) 
      //START JInit
      super($Prm0);
      this.Region = $Prm0.Region;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public NullabilityBugVisitor clone() {
      return new NullabilityBugVisitor(this);
    }
  

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Region=" + Region // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// When any of the nonnull arguments of the analyzed function is null, do not
  /// report anything and turn off the check.
  ///
  /// When \p SuppressPath is set to true, no more bugs will be reported on this
  /// path by this checker.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::reportBugIfInvariantHolds">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 458,
   FQN="(anonymous namespace)::NullabilityChecker::reportBugIfInvariantHolds", NM="_ZNK12_GLOBAL__N_118NullabilityChecker25reportBugIfInvariantHoldsEN4llvm9StringRefENS_9ErrorKindEPN5clang4ento12ExplodedNodeEPKNS5_9MemRegionERNS5_14CheckerContextEPKNS4_4StmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker25reportBugIfInvariantHoldsEN4llvm9StringRefENS_9ErrorKindEPN5clang4ento12ExplodedNodeEPKNS5_9MemRegionERNS5_14CheckerContextEPKNS4_4StmtEb")
  //</editor-fold>
  private void reportBugIfInvariantHolds(StringRef Msg, 
                           ErrorKind Error, ExplodedNode /*P*/ N, /*const*/ MemRegion /*P*/ Region, 
                           final CheckerContext /*&*/ C) /*const*/ {
    reportBugIfInvariantHolds(Msg, 
                           Error, N, Region, 
                           C, (/*const*/ Stmt /*P*/ )null, false);
  }
  private void reportBugIfInvariantHolds(StringRef Msg, 
                           ErrorKind Error, ExplodedNode /*P*/ N, /*const*/ MemRegion /*P*/ Region, 
                           final CheckerContext /*&*/ C, /*const*/ Stmt /*P*/ ValueExpr/*= null*/) /*const*/ {
    reportBugIfInvariantHolds(Msg, 
                           Error, N, Region, 
                           C, ValueExpr, false);
  }
  private void reportBugIfInvariantHolds(StringRef Msg, 
                           ErrorKind Error, ExplodedNode /*P*/ N, /*const*/ MemRegion /*P*/ Region, 
                           final CheckerContext /*&*/ C, /*const*/ Stmt /*P*/ ValueExpr/*= null*/, boolean SuppressPath/*= false*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> OriginalState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      OriginalState = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      if ($c$.clean(NullabilityCheckerStatics.checkInvariantViolation($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(OriginalState)), N, C))) {
        return;
      }
      if (SuppressPath) {
        $c$.clean(OriginalState.$assign($c$.track(OriginalState.$arrow().set(ProgramStateTraitInvariantViolated.$Instance, true))));
        $c$.clean(N = C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(OriginalState)), N));
      }
      
      reportBug(new StringRef(Msg), Error, N, Region, C.getBugReporter(), ValueExpr);
    } finally {
      if (OriginalState != null) { OriginalState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::reportBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 177,
   FQN="(anonymous namespace)::NullabilityChecker::reportBug", NM="_ZNK12_GLOBAL__N_118NullabilityChecker9reportBugEN4llvm9StringRefENS_9ErrorKindEPN5clang4ento12ExplodedNodeEPKNS5_9MemRegionERNS5_11BugReporterEPKNS4_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker9reportBugEN4llvm9StringRefENS_9ErrorKindEPN5clang4ento12ExplodedNodeEPKNS5_9MemRegionERNS5_11BugReporterEPKNS4_4StmtE")
  //</editor-fold>
  private void reportBug(StringRef Msg, ErrorKind Error, ExplodedNode /*P*/ N, 
           /*const*/ MemRegion /*P*/ Region, final BugReporter /*&*/ BR) /*const*/ {
    reportBug(Msg, Error, N, 
           Region, BR, 
           (/*const*/ Stmt /*P*/ )null);
  }
  private void reportBug(StringRef Msg, ErrorKind Error, ExplodedNode /*P*/ N, 
           /*const*/ MemRegion /*P*/ Region, final BugReporter /*&*/ BR, 
           /*const*/ Stmt /*P*/ ValueExpr/*= null*/) /*const*/ {
    unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!BT.$bool()) {
        BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Nullability"), new StringRef(/*KEEP_STR*/"Memory error")));
      }
      
      R = llvm.make_unique(new BugReport(BT.$star(), Msg, N));
      if ((Region != null)) {
        R.$arrow().markInteresting(Region);
        R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new NullabilityBugVisitor(Region)))))); $c$.clean();
      }
      if ((ValueExpr != null)) {
        R.$arrow().addRange(ValueExpr.getSourceRange());
        if (Error == ErrorKind.NilAssignedToNonnull
           || Error == ErrorKind.NilPassedToNonnull
           || Error == ErrorKind.NilReturnedToNonnull) {
          NsBugreporter.trackNullOrUndefValue(N, ValueExpr, R.$star());
        }
      }
      BR.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// If an SVal wraps a region that should be tracked, it will return a pointer
  /// to the wrapped region. Otherwise it will return a nullptr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::getTrackRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 288,
   FQN="(anonymous namespace)::NullabilityChecker::getTrackRegion", NM="_ZNK12_GLOBAL__N_118NullabilityChecker14getTrackRegionEN5clang4ento4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker14getTrackRegionEN5clang4ento4SValEb")
  //</editor-fold>
  private /*const*/ SymbolicRegion /*P*/ getTrackRegion(SVal Val) /*const*/ {
    return getTrackRegion(Val, false);
  }
  private /*const*/ SymbolicRegion /*P*/ getTrackRegion(SVal Val, boolean CheckSuperRegion/*= false*/) /*const*/ {
    if (!NeedTracking.$ConstBoolRef()) {
      return null;
    }
    
    Optional<NsLoc.MemRegionVal> RegionSVal = Val.getAs(NsLoc.MemRegionVal.class);
    if (!RegionSVal.$bool()) {
      return null;
    }
    
    /*const*/ MemRegion /*P*/ Region = RegionSVal.$arrow().getRegion();
    if (CheckSuperRegion) {
      {
        /*const*/ FieldRegion /*P*/ FieldReg = Region.getAs(FieldRegion.class);
        if ((FieldReg != null)) {
          return dyn_cast_SymbolicRegion(FieldReg.getSuperRegion());
        }
      }
      {
        /*const*/ ElementRegion /*P*/ ElementReg = Region.getAs(ElementRegion.class);
        if ((ElementReg != null)) {
          return dyn_cast_SymbolicRegion(ElementReg.getSuperRegion());
        }
      }
    }
    
    return dyn_cast_SymbolicRegion(Region);
  }

  
  /// Returns true if the call is diagnosable in the currrent analyzer
  /// configuration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::isDiagnosableCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 205,
   FQN="(anonymous namespace)::NullabilityChecker::isDiagnosableCall", NM="_ZNK12_GLOBAL__N_118NullabilityChecker17isDiagnosableCallERKN5clang4ento9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_118NullabilityChecker17isDiagnosableCallERKN5clang4ento9CallEventE")
  //</editor-fold>
  private boolean isDiagnosableCall(final /*const*/ CallEvent /*&*/ Call) /*const*/ {
    if (NoDiagnoseCallsToSystemHeaders.$ConstBoolRef() && Call.isInSystemHeader()) {
      return false;
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::~NullabilityChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 95,
   FQN="(anonymous namespace)::NullabilityChecker::~NullabilityChecker", NM="_ZN12_GLOBAL__N_118NullabilityCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityChecker::NullabilityChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 95,
   FQN="(anonymous namespace)::NullabilityChecker::NullabilityChecker", NM="_ZN12_GLOBAL__N_118NullabilityCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_118NullabilityCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ NullabilityChecker() {
    // : Checker<Bind, PreCall, PreStmt<ReturnStmt>, PostCall, PostStmt<ExplicitCastExpr>, PostObjCMessage, DeadSymbols, Event<ImplicitNullDerefEvent> >(), BT(), NoDiagnoseCallsToSystemHeaders(), Filter(), NeedTracking() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    this.NoDiagnoseCallsToSystemHeaders = new DefaultBool();
    this.Filter = new NullabilityChecksFilter();
    this.NeedTracking = new DefaultBool();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ReturnStmt) {
      checkPreStmt((ReturnStmt) stmt, C);
    }
  }

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ExplicitCastExpr) {
      checkPostStmt((ExplicitCastExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new Bind(),
    new PreCall(),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
    new PostCall(),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ExplicitCastExpr>(ExplicitCastExpr.class),
    new PostObjCMessage(),
    new DeadSymbols(),
    new Event<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // MANUAL: we need to remove static but keep delay of initialization
  private static final class checkBind$$ {
    // JAVA: must not be static!
    // JAVA: can't initialize statically as "this" is used in init expr
    private final NullabilityChecker $this;

    private checkBind$$(NullabilityChecker owner) {
      this.$this = owner;
    }
    CheckerProgramPointTag $TagNullPassedToNonnull;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullPassedToNonnull"));
    CheckerProgramPointTag $TagNullablePassedToNonnull;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullablePassedToNonnull"));

    CheckerProgramPointTag TagNullPassedToNonnull() {
      if ($TagNullPassedToNonnull == null) {
        $TagNullPassedToNonnull/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NullPassedToNonnull"));
      }
      return $TagNullPassedToNonnull;
    }

    CheckerProgramPointTag TagNullablePassedToNonnull() {
      if ($TagNullablePassedToNonnull == null) {
        $TagNullablePassedToNonnull/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NullablePassedToNonnull"));
      }
      return $TagNullablePassedToNonnull;
    }
  }
  private final checkBind$$ checkBind$$ = new checkBind$$(this);
  
  // MANUAL: we need to remove static but keep delay of initialization
  private static final class checkPreStmt$$ {
    // JAVA: must not be static!
     private final NullabilityChecker $this;
     private checkPreStmt$$(NullabilityChecker owner) {
       this.$this = owner;
     }    
    CheckerProgramPointTag $TagNullReturnedFromNonnull;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullReturnedFromNonnull"));
    CheckerProgramPointTag $TagNullableReturnedFromNonnull;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullableReturnedFromNonnull"));
    
    CheckerProgramPointTag TagNullReturnedFromNonnull() {
      if ($TagNullReturnedFromNonnull == null) {
        $TagNullReturnedFromNonnull/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NullReturnedFromNonnull"));
      }
      return $TagNullReturnedFromNonnull;
    }

    CheckerProgramPointTag TagNullableReturnedFromNonnull() {
      if ($TagNullableReturnedFromNonnull == null) {
        $TagNullableReturnedFromNonnull/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NullableReturnedFromNonnull"));
      }
      return $TagNullableReturnedFromNonnull;
    }    
  }
  private final checkPreStmt$$ checkPreStmt$$ = new checkPreStmt$$(this);
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + ", NoDiagnoseCallsToSystemHeaders=" + NoDiagnoseCallsToSystemHeaders // NOI18N
              + ", Filter=" + Filter // NOI18N
              + ", NeedTracking=" + NeedTracking // NOI18N
              + super.toString(); // NOI18N
  }
}
