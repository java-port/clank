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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.DereferenceCheckerStatics.*;

//
// JAVA: I repleaced EventDispatcher<ImplicitNullDerefEvent> inheritance with delegation.
//

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DereferenceChecker">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC /*delegate to EventDispatcher<ImplicitNullDerefEvent> instead of exnending it*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp", line = 30,
 FQN="(anonymous namespace)::DereferenceChecker", NM="_ZN12_GLOBAL__N_118DereferenceCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp -nm=_ZN12_GLOBAL__N_118DereferenceCheckerE")
//</editor-fold>
public class DereferenceChecker extends /*public*/ Checker/*<Location, Bind, EventDispatcher<ImplicitNullDerefEvent>> */
        implements org.clang.staticanalyzer.java.LocationChecker, org.clang.staticanalyzer.java.BindChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT_null;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_undef;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DereferenceChecker::reportBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp", line = 114,
   FQN="(anonymous namespace)::DereferenceChecker::reportBug", NM="_ZNK12_GLOBAL__N_118DereferenceChecker9reportBugEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS3_4StmtERNS4_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp -nm=_ZNK12_GLOBAL__N_118DereferenceChecker9reportBugEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS3_4StmtERNS4_14CheckerContextE")
  //</editor-fold>
  private void reportBug(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ Stmt /*P*/ S, 
           final CheckerContext /*&*/ C) /*const*/ {
    raw_svector_ostream os = null;
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Generate an error node.
      ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      if (!(N != null)) {
        return;
      }
      
      // We know that 'location' cannot be non-null.  This is what
      // we call an "explicit" null dereference.
      if (!BT_null.$bool()) {
        BT_null.reset(new BuiltinBug(this, $("Dereference of null pointer")));
      }
      
      SmallString/*<100>*/ buf/*J*/= new SmallString/*<100>*/(100);
      os/*J*/= new raw_svector_ostream(buf);
      
      SmallVector<SourceRange> Ranges/*J*/= new SmallVector<SourceRange>(2, SourceRange.EMPTY);
      switch (S.getStmtClass()) {
       case ArraySubscriptExprClass:
        {
          os.$out(/*KEEP_STR*/"Array access");
          /*const*/ ArraySubscriptExpr /*P*/ AE = cast_ArraySubscriptExpr(S);
          AddDerefSource(os, Ranges, AE.getBase$Const().IgnoreParenCasts$Const(), 
              State.get(), N.getLocationContext());
          os.$out(/*KEEP_STR*/" results in a null pointer dereference");
          break;
        }
       case OMPArraySectionExprClass:
        {
          os.$out(/*KEEP_STR*/"Array access");
          /*const*/ OMPArraySectionExpr /*P*/ AE = cast_OMPArraySectionExpr(S);
          AddDerefSource(os, Ranges, AE.getBase$Const().IgnoreParenCasts$Const(), 
              State.get(), N.getLocationContext());
          os.$out(/*KEEP_STR*/" results in a null pointer dereference");
          break;
        }
       case UnaryOperatorClass:
        {
          os.$out(/*KEEP_STR*/"Dereference of null pointer");
          /*const*/ UnaryOperator /*P*/ U = cast_UnaryOperator(S);
          AddDerefSource(os, Ranges, U.getSubExpr().IgnoreParens(), 
              State.get(), N.getLocationContext(), true);
          break;
        }
       case MemberExprClass:
        {
          /*const*/ MemberExpr /*P*/ M = cast_MemberExpr(S);
          if (M.isArrow() || NsBugreporter.isDeclRefExprToReference(M.getBase())) {
            $out_raw_ostream_DeclarationNameInfo(os.$out(/*KEEP_STR*/"Access to field '"), M.getMemberNameInfo()).$out(
                /*KEEP_STR*/"' results in a dereference of a null pointer"
            );
            AddDerefSource(os, Ranges, M.getBase().IgnoreParenCasts(), 
                State.get(), N.getLocationContext(), true);
          }
          break;
        }
       case ObjCIvarRefExprClass:
        {
          /*const*/ ObjCIvarRefExpr /*P*/ IV = cast_ObjCIvarRefExpr(S);
          $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"Access to instance variable '"), $Deref(IV.getDecl$Const())).$out(
              /*KEEP_STR*/"' results in a dereference of a null pointer"
          );
          AddDerefSource(os, Ranges, IV.getBase$Const().IgnoreParenCasts$Const(), 
              State.get(), N.getLocationContext(), true);
          break;
        }
       default:
        break;
      }
      
      report = llvm.make_unique(new BugReport(BT_null.$star(), buf.empty() ? BT_null.$arrow().getDescription() : buf.$StringRef(), N));
      
      NsBugreporter.trackNullOrUndefValue(N, NsBugreporter.getDerefExpr(S), report.$star());
      
      for (type$ptr<SourceRange> I = $tryClone(Ranges.begin()), /*P*/ E = $tryClone(Ranges.end()); $noteq_ptr(I, E); I.$preInc())  {
        report.$arrow().addRange(new SourceRange(I.$star()));
      }
      
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
    } finally {
      if (report != null) { report.$destroy(); }
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DereferenceChecker::checkLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp", line = 189,
   FQN="(anonymous namespace)::DereferenceChecker::checkLocation", NM="_ZNK12_GLOBAL__N_118DereferenceChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp -nm=_ZNK12_GLOBAL__N_118DereferenceChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkLocation(SVal l, boolean isLoad, /*const*/ Stmt /*P*/ S, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> notNullState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> nullState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Check for dereference of an undefined value.
      if (l.isUndef$SVal()) {
        {
          ExplodedNode /*P*/ N = C.generateErrorNode();
          if ((N != null)) {
            unique_ptr<BugReport> report = null;
            try {
              if (!BT_undef.$bool()) {
                BT_undef.reset(new BuiltinBug(this, $("Dereference of undefined pointer value")));
              }
              
              report = llvm.make_unique(new BugReport(BT_undef.$star(), BT_undef.$arrow().getDescription(), N));
              NsBugreporter.trackNullOrUndefValue(N, NsBugreporter.getDerefExpr(S), 
                  report.$star());
              C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
            } finally {
              if (report != null) { report.$destroy(); }
            }
          }
        }
        return;
      }
      
      DefinedOrUnknownSVal location = l.castAs(DefinedOrUnknownSVal.class);
      
      // Check for null dereferences.
      if (!location.getAs(Loc.class).$bool()) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      notNullState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      nullState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(notNullState, nullState).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(location)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramStates were moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(location)));
      notNullState.$assign($assume.first);
      nullState.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      // The explicit NULL case.
      if (nullState.$bool()) {
        if (!notNullState.$bool()) {
          /*const*/ Expr /*P*/ expr = DereferenceCheckerStatics.getDereferenceExpr(S);
          if (!DereferenceCheckerStatics.suppressReport(expr)) {
            reportBug($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(nullState)), expr, C); $c$.clean();
            return;
          }
        }
        {
          
          // Otherwise, we have the case where the location could either be
          // null or not-null.  Record the error node as an "implicit" null
          // dereference.
          ExplodedNode /*P*/ N = $c$.clean(C.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(nullState)), C.getPredecessor()));
          if ((N != null)) {
            ImplicitNullDerefEvent event = new ImplicitNullDerefEvent(
              l, isLoad, N, $AddrOf(C.getBugReporter()), 
              /*IsDirectDereference=*/ true);
            $Dispatcher.dispatchEvent(event);
          }
        }
      }
      
      // From this point forward, we know that the location is not null.
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(notNullState))));
    } finally {
      if (nullState != null) { nullState.$destroy(); }
      if (notNullState != null) { notNullState.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DereferenceChecker::checkBind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp", line = 242,
   FQN="(anonymous namespace)::DereferenceChecker::checkBind", NM="_ZNK12_GLOBAL__N_118DereferenceChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp -nm=_ZNK12_GLOBAL__N_118DereferenceChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkBind(SVal L, SVal V, /*const*/ Stmt /*P*/ S, 
           final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StNonNull = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StNull = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If we're binding to a reference, check if the value is known to be null.
      if (V.isUndef$SVal()) {
        return;
      }
      
      /*const*/ MemRegion /*P*/ MR = L.getAsRegion();
      /*const*/ TypedValueRegion /*P*/ TVR = dyn_cast_or_null_TypedValueRegion(MR);
      if (!(TVR != null)) {
        return;
      }
      if (!TVR.getValueType().$arrow().isReferenceType()) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      StNonNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      StNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(StNonNull, StNull).$assign($c$.track(State.$arrow().assume(V.castAs(DefinedOrUnknownSVal.class)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(State.$arrow().assume(V.castAs(DefinedOrUnknownSVal.class)));
      StNonNull.$assign($assume.first);
      StNull.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();    
      
      if (StNull.$bool()) {
        if (!StNonNull.$bool()) {
          /*const*/ Expr /*P*/ expr = DereferenceCheckerStatics.getDereferenceExpr(S, /*IsBind=*/ true);
          if (!DereferenceCheckerStatics.suppressReport(expr)) {
            reportBug($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StNull)), expr, C); $c$.clean();
            return;
          }
        }
        {
          
          // At this point the value could be either null or non-null.
          // Record this as an "implicit" null dereference.
          ExplodedNode /*P*/ N = $c$.clean(C.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StNull)), C.getPredecessor()));
          if ((N != null)) {
            ImplicitNullDerefEvent event = new ImplicitNullDerefEvent(
              V, /*isLoad=*/ true, N, 
              $AddrOf(C.getBugReporter()), 
              /*IsDirectDereference=*/ true);
            $Dispatcher.dispatchEvent(event);
          }
        }
      }
      
      // Unlike a regular null dereference, initializing a reference with a
      // dereferenced null pointer does not actually cause a runtime exception in
      // Clang's implementation of references.
      //
      //   int &r = *p; // safe??
      //   if (p != NULL) return; // uh-oh
      //   r = 5; // trap here
      //
      // The standard says this is invalid as soon as we try to create a "null
      // reference" (there is no such thing), but turning this into an assumption
      // that 'p' is never null will not match our actual runtime behavior.
      // So we do not record this assumption, allowing us to warn on the last line
      // of this example.
      //
      // We do need to add a transition because we may have generated a sink for
      // the "implicit" null dereference.
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), this));
    } finally {
      if (StNull != null) { StNull.$destroy(); }
      if (StNonNull != null) { StNonNull.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DereferenceChecker::AddDerefSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp", line = 52,
   FQN="(anonymous namespace)::DereferenceChecker::AddDerefSource", NM="_ZN12_GLOBAL__N_118DereferenceChecker14AddDerefSourceERN4llvm11raw_ostreamERNS1_15SmallVectorImplIN5clang11SourceRangeEEEPKNS5_4ExprEPKNS5_4ento12ProgramStateEPKNS5_15LocationContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp -nm=_ZN12_GLOBAL__N_118DereferenceChecker14AddDerefSourceERN4llvm11raw_ostreamERNS1_15SmallVectorImplIN5clang11SourceRangeEEEPKNS5_4ExprEPKNS5_4ento12ProgramStateEPKNS5_15LocationContextEb")
  //</editor-fold>
  public static void AddDerefSource(final raw_ostream /*&*/ os, 
                final SmallVectorImpl<SourceRange> /*&*/ Ranges, 
                /*const*/ Expr /*P*/ Ex, 
                /*const*/ ProgramState /*P*/ state, 
                /*const*/ LocationContext /*P*/ LCtx) {
    AddDerefSource(os, 
                Ranges, 
                Ex, 
                state, 
                LCtx, 
                false);
  }
  public static void AddDerefSource(final raw_ostream /*&*/ os, 
                final SmallVectorImpl<SourceRange> /*&*/ Ranges, 
                /*const*/ Expr /*P*/ Ex, 
                /*const*/ ProgramState /*P*/ state, 
                /*const*/ LocationContext /*P*/ LCtx, 
                boolean loadedFrom/*= false*/) {
    Ex = Ex.IgnoreParenLValueCasts$Const();
    switch (Ex.getStmtClass()) {
     default:
      break;
     case DeclRefExprClass:
      {
        /*const*/ DeclRefExpr /*P*/ DR = cast_DeclRefExpr(Ex);
        {
          /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
          if ((VD != null)) {
            os.$out(/*KEEP_STR*/" (").$out((loadedFrom ? $("loaded from") : $("from"))).$out(
                /*KEEP_STR*/" variable '"
            ).$out(VD.getName()).$out(/*KEEP_STR*/"')");
            Ranges.push_back(DR.getSourceRange());
          }
        }
        break;
      }
     case MemberExprClass:
      {
        /*const*/ MemberExpr /*P*/ ME = cast_MemberExpr(Ex);
        $out_raw_ostream_DeclarationNameInfo(os.$out(/*KEEP_STR*/" (").$out((loadedFrom ? $("loaded from") : $("via"))).$out(
                /*KEEP_STR*/" field '"
            ), ME.getMemberNameInfo()).$out(/*KEEP_STR*/"')");
        SourceLocation L = ME.getMemberLoc();
        Ranges.push_back(new SourceRange(/*NO_COPY*/L, /*NO_COPY*/L));
        break;
      }
     case ObjCIvarRefExprClass:
      {
        /*const*/ ObjCIvarRefExpr /*P*/ IV = cast_ObjCIvarRefExpr(Ex);
        os.$out(/*KEEP_STR*/" (").$out((loadedFrom ? $("loaded from") : $("via"))).$out(
            /*KEEP_STR*/" ivar '"
        ).$out(IV.getDecl$Const().getName()).$out(/*KEEP_STR*/"')");
        SourceLocation L = IV.getLocation();
        Ranges.push_back(new SourceRange(/*NO_COPY*/L, /*NO_COPY*/L));
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DereferenceChecker::~DereferenceChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp", line = 30,
   FQN="(anonymous namespace)::DereferenceChecker::~DereferenceChecker", NM="_ZN12_GLOBAL__N_118DereferenceCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp -nm=_ZN12_GLOBAL__N_118DereferenceCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_undef.$destroy();
    BT_null.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DereferenceChecker::DereferenceChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp", line = 30,
   FQN="(anonymous namespace)::DereferenceChecker::DereferenceChecker", NM="_ZN12_GLOBAL__N_118DereferenceCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp -nm=_ZN12_GLOBAL__N_118DereferenceCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ DereferenceChecker() {
    // : Checker<Location, Bind, EventDispatcher<ImplicitNullDerefEvent> >(), BT_null(), BT_undef() 
    //START JInit
    super();
    this.BT_null = new std.unique_ptr<BuiltinBug>();
    this.BT_undef = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  EventDispatcher<ImplicitNullDerefEvent> $Dispatcher = new EventDispatcher<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class);

  private final CheckBase $CHECKS[] = {
    new Location(),
    new Bind(),
    $Dispatcher
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_null=" + BT_null // NOI18N
              + ", BT_undef=" + BT_undef // NOI18N
              + super.toString(); // NOI18N
  }
}
