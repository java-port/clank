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
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.CheckObjCDeallocStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 92,
 FQN="(anonymous namespace)::ObjCDeallocChecker", NM="_ZN12_GLOBAL__N_118ObjCDeallocCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZN12_GLOBAL__N_118ObjCDeallocCheckerE")
//</editor-fold>
public class ObjCDeallocChecker extends /*public*/ Checker/*<ASTDecl<ObjCImplementationDecl>, PreObjCMessage, PostObjCMessage, PreCall, BeginFunction, EndFunction, eval.Assume, PointerEscape, PreStmt<ReturnStmt> >*/ 
        implements org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.EvalAssumeChecker, org.clang.staticanalyzer.java.PreObjCMessageChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PointerEscapeChecker, org.clang.staticanalyzer.java.BeginFunctionChecker, org.clang.staticanalyzer.java.EndFunctionChecker, org.clang.staticanalyzer.java.ASTDeclChecker<ObjCImplementationDecl>, Destructors.ClassWithDestructor {
  
  private /*mutable */IdentifierInfo /*P*/ NSObjectII;
  
  private /*mutable */IdentifierInfo /*P*/ SenTestCaseII;
  
  private /*mutable */IdentifierInfo /*P*/ XCTestCaseII;
  
  private /*mutable */IdentifierInfo /*P*/ Block_releaseII;
  
  private /*mutable */IdentifierInfo /*P*/ CIFilterII;
  
  private /*mutable */Selector DeallocSel;
  
  private /*mutable */Selector ReleaseSel;
  
  private std.unique_ptr<BugType> MissingReleaseBugType;
  private std.unique_ptr<BugType> ExtraReleaseBugType;
  private std.unique_ptr<BugType> MistakenDeallocBugType;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::ObjCDeallocChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 756,
   FQN="(anonymous namespace)::ObjCDeallocChecker::ObjCDeallocChecker", NM="_ZN12_GLOBAL__N_118ObjCDeallocCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZN12_GLOBAL__N_118ObjCDeallocCheckerC1Ev")
  //</editor-fold>
  public ObjCDeallocChecker() {
    // : Checker<ASTDecl<ObjCImplementationDecl>, PreObjCMessage, PostObjCMessage, PreCall, BeginFunction, EndFunction, eval::Assume, PointerEscape, PreStmt<ReturnStmt> >(), NSObjectII(null), SenTestCaseII(null), XCTestCaseII(null), CIFilterII(null), DeallocSel(), ReleaseSel(), MissingReleaseBugType(), ExtraReleaseBugType(), MistakenDeallocBugType() 
    //START JInit
    super();
    this.NSObjectII = null;
    this.SenTestCaseII = null;
    this.XCTestCaseII = null;
    this.CIFilterII = null;
    this.DeallocSel = new Selector();
    this.ReleaseSel = new Selector();
    this.MissingReleaseBugType = new std.unique_ptr<BugType>();
    this.ExtraReleaseBugType = new std.unique_ptr<BugType>();
    this.MistakenDeallocBugType = new std.unique_ptr<BugType>();
    //END JInit
    
    MissingReleaseBugType.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Missing ivar release (leak)"), 
            new StringRef(categories.MemoryCoreFoundationObjectiveC)));
    
    ExtraReleaseBugType.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Extra ivar release"), 
            new StringRef(categories.MemoryCoreFoundationObjectiveC)));
    
    MistakenDeallocBugType.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Mistaken dealloc"), 
            new StringRef(categories.MemoryCoreFoundationObjectiveC)));
  }

  
  
  /// An AST check that diagnose when the class requires a -dealloc method and
  /// is missing one.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::checkASTDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 196,
   FQN="(anonymous namespace)::ObjCDeallocChecker::checkASTDecl", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker12checkASTDeclEPKN5clang22ObjCImplementationDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker12checkASTDeclEPKN5clang22ObjCImplementationDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTDecl(/*const*/ ObjCImplementationDecl /*P*/ D, 
              final AnalysisManager /*&*/ Mgr, 
              final BugReporter /*&*/ BR) /*const*/ {
    assert (Mgr.getLangOpts().getGC() != LangOptions.GCMode.GCOnly);
    assert (!Mgr.getLangOpts().ObjCAutoRefCount);
    initIdentifierInfoAndSelectors(Mgr.getASTContext());
    
    /*const*/ ObjCInterfaceDecl /*P*/ ID = D.getClassInterface$Const();
    // If the class is known to have a lifecycle with a separate teardown method
    // then it may not require a -dealloc method.
    if (classHasSeparateTeardown(ID)) {
      return;
    }
    
    // Does the class contain any synthesized properties that are retainable?
    // If not, skip the check entirely.
    /*const*/ ObjCPropertyImplDecl /*P*/ PropImplRequiringRelease = null;
    boolean HasOthers = false;
    for (/*const*/ ObjCPropertyImplDecl /*P*/ I : D.property_impls()) {
      if (getDeallocReleaseRequirement(I) == ReleaseRequirement.MustRelease) {
        if (!(PropImplRequiringRelease != null)) {
          PropImplRequiringRelease = I;
        } else {
          HasOthers = true;
          break;
        }
      }
    }
    if (!(PropImplRequiringRelease != null)) {
      return;
    }
    
    /*const*/ ObjCMethodDecl /*P*/ MD = null;
    
    // Scan the instance methods for "dealloc".
    for (/*const*/ ObjCMethodDecl /*P*/ I : D.instance_methods()) {
      if (I.getSelector().$eq(/*NO_COPY*/DeallocSel)) {
        MD = I;
        break;
      }
    }
    if (!(MD != null)) { // No dealloc found.
      raw_string_ostream OS = null;
      try {
        /*const*/char$ptr/*char P*/ Name = $("Missing -dealloc");
        
        std.string Buf/*J*/= new std.string();
        OS/*J*/= new raw_string_ostream(Buf);
        $out_raw_ostream_NamedDecl$C($out_raw_ostream_ObjCImplementationDecl$C(OS.$out(/*KEEP_STR*/$SGL_QUOTE), $Deref(D)).$out(/*KEEP_STR*/"' lacks a 'dealloc' instance method but ").$out(
                /*KEEP_STR*/"must release '"
            ), $Deref(PropImplRequiringRelease.getPropertyIvarDecl())).$out(
            /*KEEP_STR*/$SGL_QUOTE
        );
        if (HasOthers) {
          OS.$out(/*KEEP_STR*/" and others");
        }
        PathDiagnosticLocation DLoc = PathDiagnosticLocation.createBegin(D, BR.getSourceManager());
        
        BR.EmitBasicReport(D, this, new StringRef(Name), new StringRef(categories.CoreFoundationObjectiveC), 
            new StringRef(OS.str()), new PathDiagnosticLocation(DLoc));
        return;
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
  }

  
  /// If this is the beginning of -dealloc, mark the values initially stored in
  /// instance variables that must be released by the end of -dealloc
  /// as unreleased in the state.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::checkBeginFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 260,
   FQN="(anonymous namespace)::ObjCDeallocChecker::checkBeginFunction", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker18checkBeginFunctionERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker18checkBeginFunctionERN5clang4ento14CheckerContextE")
  //</editor-fold>
  public void checkBeginFunction(final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> InitialState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableSetPtr</*const*/ SymExpr /*P*/ > RequiredReleases = null;
    try {
      initIdentifierInfoAndSelectors(C.getASTContext());
      
      // Only do this if the current method is -dealloc.
      SVal SelfVal/*J*/= new SVal();
      if (!isInInstanceDealloc(C, SelfVal)) {
        return;
      }
      
      /*const*/ SymExpr /*P*/ SelfSymbol = SelfVal.getAsSymbol();
      
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      InitialState = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(InitialState);
                  
      final ImmutableSetPtr.Factory</*const*/ SymExpr /*P*/ > /*&*/ F = State.$arrow().getStateManager().get_context(ProgramStateTraitImmutableSet$SymExpr$C$P.$Instance);

      // Symbols that must be released by the end of the -dealloc;
      RequiredReleases = F.getEmptySet();
      {
        
        // If we're an inlined -dealloc, we should add our symbols to the existing
        // set from our subclass.
        /*const*/ImmutableSetPtr</*const*/ SymExpr /*P*/ > /*P*/ CurrSet = State.$arrow().get(ProgramStateTraitUnreleasedIvarMap.$Instance, SelfSymbol);
        if ((CurrSet != null)) {
          RequiredReleases.$assign($Deref(CurrSet));
        }
      }
      
      for (ObjCPropertyImplDecl /*P*/ PropImpl : getContainingObjCImpl(LCtx).property_impls()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ReleaseRequirement Requirement = getDeallocReleaseRequirement(PropImpl);
          if (Requirement != ReleaseRequirement.MustRelease) {
            continue;
          }
          
          SVal LVal = State.$arrow().getLValue(PropImpl.getPropertyIvarDecl(), new SVal(SelfVal));
          Optional<Loc> LValLoc = LVal.getAs(Loc.class);
          if (!LValLoc.$bool()) {
            continue;
          }
          
          SVal InitialVal = State.$arrow().getSVal(new Loc(LValLoc.getValue()));
          /*const*/ SymExpr /*P*/ Symbol = InitialVal.getAsSymbol();
          if (!(Symbol != null) || !isa_SymbolRegionValue(Symbol)) {
            continue;
          }
          
          // Mark the value as requiring a release.
          $c$.clean(RequiredReleases.$assign($c$.track(F.add($c$.track(new ImmutableSetPtr</*const*/ SymExpr /*P*/ >(RequiredReleases)), Symbol))));
        } finally {
          $c$.$destroy();
        }
      }
      if (!RequiredReleases.isEmpty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitUnreleasedIvarMap.$Instance, SelfSymbol, $c$.track(new ImmutableSetPtr</*const*/ SymExpr /*P*/ >(RequiredReleases))))));
        } finally {
          $c$.$destroy();
        }
      }
      if ($noteq_IntrusiveRefCntPtr(State, InitialState)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (RequiredReleases != null) { RequiredReleases.$destroy(); }
      if (State != null) { State.$destroy(); }
      if (InitialState != null) { InitialState.$destroy(); }
    }
  }

  
  /// If we are in -dealloc or -dealloc is on the stack, handle the call if it is
  /// a release or a nilling-out property setter.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 335,
   FQN="(anonymous namespace)::ObjCDeallocChecker::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, final CheckerContext /*&*/ C) /*const*/ {
    // Only run if -dealloc is on the stack.
    SVal DeallocedInstance/*J*/= new SVal();
    if (!instanceDeallocIsOnStack(C, DeallocedInstance)) {
      return;
    }
    
    /*const*/ SymExpr /*P*/ ReleasedValue = null;
    if (M.getSelector().$eq(/*NO_COPY*/ReleaseSel)) {
      ReleasedValue = M.getReceiverSVal().getAsSymbol();
    } else if (M.getSelector().$eq(/*NO_COPY*/DeallocSel) && !M.isReceiverSelfOrSuper()) {
      if (diagnoseMistakenDealloc(M.getReceiverSVal().getAsSymbol(), M, C)) {
        return;
      }
    }
    if ((ReleasedValue != null)) {
      // An instance variable symbol was released with -release:
      //    [_property release];
      if (diagnoseExtraRelease(ReleasedValue, M, C)) {
        return;
      }
    } else {
      // An instance variable symbol was released nilling out its property:
      //    self.property = nil;
      ReleasedValue = getValueReleasedByNillingOut(M, C);
    }
    if (!(ReleasedValue != null)) {
      return;
    }
    
    transitionToReleaseValue(C, ReleasedValue);
  }

  
  /// If we are in -dealloc or -dealloc is on the stack, handle the call if it is
  /// call to Block_release().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::checkPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 370,
   FQN="(anonymous namespace)::ObjCDeallocChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ IdentifierInfo /*P*/ II = Call.getCalleeIdentifier();
    if (II != Block_releaseII) {
      return;
    }
    if (Call.getNumArgs() != 1) {
      return;
    }
    
    /*const*/ SymExpr /*P*/ ReleasedValue = Call.getArgSVal(0).getAsSymbol();
    if (!(ReleasedValue != null)) {
      return;
    }
    
    transitionToReleaseValue(C, ReleasedValue);
  }

  /// If the message was a call to '[super dealloc]', diagnose any missing
  /// releases.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 387,
   FQN="(anonymous namespace)::ObjCDeallocChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, final CheckerContext /*&*/ C) /*const*/ {
    // We perform this check post-message so that if the super -dealloc
    // calls a helper method and that this class overrides, any ivars released in
    // the helper method will be recorded before checking.
    if (isSuperDeallocMessage(M)) {
      diagnoseMissingReleases(C);
    }
  }

  
  
  /// When a symbol is assumed to be nil, remove it from the set of symbols
  /// require to be nil.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::evalAssume">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 411,
   FQN="(anonymous namespace)::ObjCDeallocChecker::evalAssume", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker10evalAssumeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS4_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker10evalAssumeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS4_4SValEb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> evalAssume(IntrusiveRefCntPtr</*const*/ ProgramState> State, SVal Cond, 
            boolean Assumption) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($c$.clean($c$.track(State.$arrow().get(ProgramStateTraitUnreleasedIvarMap.$Instance)).isEmpty())) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      /*const*/ BinarySymExpr /*P*/ CondBSE = dyn_cast_or_null_BinarySymExpr(Cond.getAsSymExpr());
      if (!(CondBSE != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      BinaryOperatorKind OpCode = CondBSE.getOpcode();
      if (Assumption) {
        if (OpCode != BinaryOperatorKind.BO_EQ) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
        }
      } else {
        if (OpCode != BinaryOperatorKind.BO_NE) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
        }
      }
      
      /*const*/ SymExpr /*P*/ NullSymbol = null;
      {
        /*const*/ SymIntExpr /*P*/ SIE = dyn_cast_SymIntExpr(CondBSE);
        if ((SIE != null)) {
          final /*const*/ APInt /*&*/ RHS = SIE.getRHS();
          if (RHS.$noteq($int2ulong(0))) {
            return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
          }
          NullSymbol = SIE.getLHS();
        } else {
          /*const*/ IntSymExpr /*P*/ SIE$1 = dyn_cast_IntSymExpr(CondBSE);
          if ((SIE$1 != null)) {
            final /*const*/ APInt /*&*/ LHS = SIE$1.getLHS();
            if (LHS.$noteq($int2ulong(0))) {
              return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
            }
            NullSymbol = SIE$1.getRHS();
          } else {
            return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
          }
        }
      }
      
      /*const*/ SymExpr /*P*/ InstanceSymbol = getInstanceSymbolFromIvarSymbol(NullSymbol);
      if (!(InstanceSymbol != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      $c$.clean(State.$assign($c$.track(removeValueRequiringRelease($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), InstanceSymbol, NullSymbol))));
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    } finally {
      $c$.$destroy();
    }
  }

  
  
  /// If a symbol escapes conservatively assume unseen code released it.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::checkPointerEscape">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 454,
   FQN="(anonymous namespace)::ObjCDeallocChecker::checkPointerEscape", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                    /*const*/ CallEvent /*P*/ Call, PointerEscapeKind Kind) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($c$.clean($c$.track(State.$arrow().get(ProgramStateTraitUnreleasedIvarMap.$Instance)).isEmpty())) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      // Don't treat calls to '[super dealloc]' as escaping for the purposes
      // of this checker. Because the checker diagnoses missing releases in the
      // post-message handler for '[super dealloc], escaping here would cause
      // the checker to never warn.
      /*const*/ ObjCMethodCall /*P*/ OMC = dyn_cast_or_null_ObjCMethodCall(Call);
      if ((OMC != null) && isSuperDeallocMessage($Deref(OMC))) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      for (final /*const*/ SymExpr /*P*/ /*const*/ /*&*/ Sym : Escaped) {
        if (!(Call != null) || ((Call != null) && !Call.isInSystemHeader())) {
          // If Sym is a symbol for an object with instance variables that
          // must be released, remove these obligations when the object escapes
          // unless via a call to a system function. System functions are
          // very unlikely to release instance variables on objects passed to them,
          // and are frequently called on 'self' in -dealloc (e.g., to remove
          // observers) -- we want to avoid false negatives from escaping on
          // them.
          $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitUnreleasedIvarMap.$Instance, Sym))));
        }
        
        /*const*/ SymExpr /*P*/ InstanceSymbol = getInstanceSymbolFromIvarSymbol(Sym);
        if (!(InstanceSymbol != null)) {
          continue;
        }
        
        $c$.clean(State.$assign($c$.track(removeValueRequiringRelease($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), InstanceSymbol, Sym))));
      }
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    } finally {
      $c$.$destroy();
    }
  }


  /// Check for missing releases on early return.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 404,
   FQN="(anonymous namespace)::ObjCDeallocChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ RS, final CheckerContext /*&*/ C) /*const*/ {
    diagnoseMissingReleases(C);
  }

  
  /// Check for missing releases even when -dealloc does not call
  /// '[super dealloc]'.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::checkEndFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 398,
   FQN="(anonymous namespace)::ObjCDeallocChecker::checkEndFunction", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker16checkEndFunctionERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker16checkEndFunctionERN5clang4ento14CheckerContextE")
  //</editor-fold>
  public void checkEndFunction(final CheckerContext /*&*/ C) /*const*/ {
    diagnoseMissingReleases(C);
  }

/*private:*/
  
  /// Report any unreleased instance variables for the current instance being
  /// dealloced.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::diagnoseMissingReleases">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 494,
   FQN="(anonymous namespace)::ObjCDeallocChecker::diagnoseMissingReleases", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker23diagnoseMissingReleasesERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker23diagnoseMissingReleasesERN5clang4ento14CheckerContextE")
  //</editor-fold>
  private void diagnoseMissingReleases(final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableSetPtr</*const*/ SymExpr /*P*/ > NewUnreleased = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> InitialState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      SVal SelfVal/*J*/= new SVal();
      if (!isInInstanceDealloc(C, SelfVal)) {
        return;
      }
      
      /*const*/ MemRegion /*P*/ SelfRegion = SelfVal.castAs(NsLoc.MemRegionVal.class).getRegion();
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      
      ExplodedNode /*P*/ ErrNode = null;
      
      /*const*/ SymExpr /*P*/ SelfSym = SelfVal.getAsSymbol();
      if (!(SelfSym != null)) {
        return;
      }
      
      /*const*/ImmutableSetPtr</*const*/ SymExpr /*P*/ > /*P*/ OldUnreleased = State.$arrow().get(ProgramStateTraitUnreleasedIvarMap.$Instance, SelfSym);
      if (!(OldUnreleased != null)) {
        return;
      }
      
      NewUnreleased = new ImmutableSetPtr</*const*/ SymExpr /*P*/ >($Deref(OldUnreleased));
      final ImmutableSetPtr.Factory</*const*/ SymExpr /*P*/ > /*&*/ F = State.$arrow().getStateManager().get_context(ProgramStateTraitImmutableSet$SymExpr$C$P.$Instance);
      
      InitialState = new IntrusiveRefCntPtr</*const*/ ProgramState>(State);
      
      for (/*const*/ SymExpr /*P*/ IvarSymbol : $Deref(OldUnreleased)) {
        raw_string_ostream OS = null;
        std.unique_ptr<BugReport> BR = null;
        try {
          /*const*/ TypedValueRegion /*P*/ TVR = cast_SymbolRegionValue(IvarSymbol).getRegion();
          /*const*/ ObjCIvarRegion /*P*/ IvarRegion = cast_ObjCIvarRegion(TVR);
          
          // Don't warn if the ivar is not for this instance.
          if (SelfRegion != IvarRegion.getSuperRegion()) {
            continue;
          }
          
          /*const*/ ObjCIvarDecl /*P*/ IvarDecl = IvarRegion.getDecl();
          // Prevent an inlined call to -dealloc in a super class from warning
          // about the values the subclass's -dealloc should release.
          if (IvarDecl.getContainingInterface()
             != cast_ObjCMethodDecl(LCtx.getDecl()).getClassInterface$Const()) {
            continue;
          }
          
          // Prevents diagnosing multiple times for the same instance variable
          // at, for example, both a return and at the end of of the function.
          $c$.clean(NewUnreleased.$assign($c$.track(F.remove($c$.track(new ImmutableSetPtr</*const*/ SymExpr /*P*/ >(NewUnreleased)), IvarSymbol))));
          if ($c$.clean($c$.track(State.$arrow().getStateManager().
              getConstraintManager().
              isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), IvarSymbol)).
              isConstrainedTrue())) {
            continue;
          }
          
          // A missing release manifests as a leak, so treat as a non-fatal error.
          if (!(ErrNode != null)) {
            ErrNode = C.generateNonFatalErrorNode();
          }
          // If we've already reached this node on another path, return without
          // diagnosing.
          if (!(ErrNode != null)) {
            return;
          }
          
          std.string Buf/*J*/= new std.string();
          OS/*J*/= new raw_string_ostream(Buf);
          
          /*const*/ ObjCInterfaceDecl /*P*/ Interface = IvarDecl.getContainingInterface();
          // If the class is known to have a lifecycle with teardown that is
          // separate from -dealloc, do not warn about missing releases. We
          // suppress here (rather than not tracking for instance variables in
          // such classes) because these classes are rare.
          if (classHasSeparateTeardown(Interface)) {
            return;
          }
          
          ObjCImplDecl /*P*/ ImplDecl = Interface.getImplementation();
          
          /*const*/ ObjCPropertyImplDecl /*P*/ PropImpl = ImplDecl.FindPropertyImplIvarDecl(IvarDecl.getIdentifier());
          
          /*const*/ ObjCPropertyDecl /*P*/ PropDecl = PropImpl.getPropertyDecl();
          assert (PropDecl.getSetterKind() == ObjCPropertyDecl.SetterKind.Copy || PropDecl.getSetterKind() == ObjCPropertyDecl.SetterKind.Retain);
          
          $out_raw_ostream_NamedDecl$C($out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/"The '"), $Deref(IvarDecl)).$out(/*KEEP_STR*/"' ivar in '"), $Deref(ImplDecl)).$out(
              /*KEEP_STR*/"' was "
          );
          if (PropDecl.getSetterKind() == ObjCPropertyDecl.SetterKind.Retain) {
            OS.$out(/*KEEP_STR*/"retained");
          } else {
            OS.$out(/*KEEP_STR*/"copied");
          }
          
          OS.$out(/*KEEP_STR*/" by a synthesized property but not released before '[super dealloc]'");
          
          BR/*J*/= new std.unique_ptr<BugReport>(new BugReport(MissingReleaseBugType.$star(), new StringRef(OS.str()), ErrNode));
          
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(BR)))); $c$.clean();
        } finally {
          if (BR != null) { BR.$destroy(); }
          if (OS != null) { OS.$destroy(); }
        }
      }
      if (NewUnreleased.isEmpty()) {
        $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitUnreleasedIvarMap.$Instance, SelfSym))));
      } else {
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitUnreleasedIvarMap.$Instance, SelfSym, $c$.track(new ImmutableSetPtr</*const*/ SymExpr /*P*/ >(NewUnreleased))))));
      }
      if ((ErrNode != null)) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), ErrNode));
      } else if ($noteq_IntrusiveRefCntPtr(State, InitialState)) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      }
      
      // Make sure that after checking in the top-most frame the list of
      // tracked ivars is empty. This is intended to detect accidental leaks in
      // the UnreleasedIvarMap program state.
      assert (!LCtx.inTopFrame() || $c$.track(State.$arrow().get(ProgramStateTraitUnreleasedIvarMap.$Instance)).isEmpty()); $c$.clean();
    } finally {
      if (InitialState != null) { InitialState.$destroy(); }
      if (NewUnreleased != null) { NewUnreleased.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  /// Emits a warning if the current context is -dealloc and ReleasedValue
  /// must not be directly released in a -dealloc. Returns true if a diagnostic
  /// was emitted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::diagnoseExtraRelease">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 643,
   FQN="(anonymous namespace)::ObjCDeallocChecker::diagnoseExtraRelease", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker20diagnoseExtraReleaseEPKN5clang4ento7SymExprERKNS2_14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker20diagnoseExtraReleaseEPKN5clang4ento7SymExprERKNS2_14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  private boolean diagnoseExtraRelease(/*const*/ SymExpr /*P*/ ReleasedValue, 
                      final /*const*/ ObjCMethodCall /*&*/ M, 
                      final CheckerContext /*&*/ C) /*const*/ {
    raw_string_ostream OS = null;
    std.unique_ptr<BugReport> BR = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Try to get the region from which the the released value was loaded.
      // Note that, unlike diagnosing for missing releases, here we don't track
      // values that must not be released in the state. This is because even if
      // these values escape, it is still an error under the rules of MRR to
      // release them in -dealloc.
      /*const*/ ObjCPropertyImplDecl /*P*/ PropImpl = findPropertyOnDeallocatingInstance(ReleasedValue, C);
      if (!(PropImpl != null)) {
        return false;
      }
      
      // If the ivar belongs to a property that must not be released directly
      // in dealloc, emit a warning.
      if (getDeallocReleaseRequirement(PropImpl)
         != ReleaseRequirement.MustNotReleaseDirectly) {
        return false;
      }
      
      // If the property is readwrite but it shadows a read-only property in its
      // external interface, treat the property a read-only. If the outside
      // world cannot write to a property then the internal implementation is free
      // to make its own convention about whether the value is stored retained
      // or not. We look up the shadow here rather than in
      // getDeallocReleaseRequirement() because doing so can be expensive.
      /*const*/ ObjCPropertyDecl /*P*/ PropDecl = findShadowedPropertyDecl(PropImpl);
      if ((PropDecl != null)) {
        if (PropDecl.isReadOnly()) {
          return false;
        }
      } else {
        PropDecl = PropImpl.getPropertyDecl();
      }
      
      ExplodedNode /*P*/ ErrNode = C.generateNonFatalErrorNode();
      if (!(ErrNode != null)) {
        return false;
      }
      
      std.string Buf/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Buf);
      assert (PropDecl.getSetterKind() == ObjCPropertyDecl.SetterKind.Weak || (PropDecl.getSetterKind() == ObjCPropertyDecl.SetterKind.Assign && !PropDecl.isReadOnly()) || isReleasedByCIFilterDealloc(PropImpl));
      
      /*const*/ ObjCImplDecl /*P*/ Container = getContainingObjCImpl(C.getLocationContext());
      $out_raw_ostream_NamedDecl$C($out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/"The '"), $Deref(PropImpl.getPropertyIvarDecl())).$out(
              /*KEEP_STR*/"' ivar in '"
          ), $Deref(Container));
      if (isReleasedByCIFilterDealloc(PropImpl)) {
        OS.$out(/*KEEP_STR*/"' will be released by '-[CIFilter dealloc]' but also released here");
      } else {
        OS.$out(/*KEEP_STR*/"' was synthesized for ");
        if (PropDecl.getSetterKind() == ObjCPropertyDecl.SetterKind.Weak) {
          OS.$out(/*KEEP_STR*/"a weak");
        } else {
          OS.$out(/*KEEP_STR*/"an assign, readwrite");
        }
        
        OS.$out(/*KEEP_STR*/" property but was released in 'dealloc'");
      }
      
      BR/*J*/= new std.unique_ptr<BugReport>(new BugReport(ExtraReleaseBugType.$star(), new StringRef(OS.str()), ErrNode));
      BR.$arrow().addRange(M.getOriginExpr().getSourceRange());
      
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(BR)))); $c$.clean();
      
      return true;
    } finally {
      if (BR != null) { BR.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  /// Emits a warning if the current context is -dealloc and DeallocedValue
  /// must not be directly dealloced in a -dealloc. Returns true if a diagnostic
  /// was emitted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::diagnoseMistakenDealloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 721,
   FQN="(anonymous namespace)::ObjCDeallocChecker::diagnoseMistakenDealloc", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker23diagnoseMistakenDeallocEPKN5clang4ento7SymExprERKNS2_14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker23diagnoseMistakenDeallocEPKN5clang4ento7SymExprERKNS2_14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  private boolean diagnoseMistakenDealloc(/*const*/ SymExpr /*P*/ DeallocedValue, 
                         final /*const*/ ObjCMethodCall /*&*/ M, 
                         final CheckerContext /*&*/ C) /*const*/ {
    raw_string_ostream OS = null;
    std.unique_ptr<BugReport> BR = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Find the property backing the instance variable that M
      // is dealloc'ing.
      /*const*/ ObjCPropertyImplDecl /*P*/ PropImpl = findPropertyOnDeallocatingInstance(DeallocedValue, C);
      if (!(PropImpl != null)) {
        return false;
      }
      if (getDeallocReleaseRequirement(PropImpl)
         != ReleaseRequirement.MustRelease) {
        return false;
      }
      
      ExplodedNode /*P*/ ErrNode = C.generateErrorNode();
      if (!(ErrNode != null)) {
        return false;
      }
      
      std.string Buf/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Buf);
      
      $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/$SGL_QUOTE), $Deref(PropImpl.getPropertyIvarDecl())).$out(
          /*KEEP_STR*/"' should be released rather than deallocated"
      );
      
      BR/*J*/= new std.unique_ptr<BugReport>(new BugReport(MistakenDeallocBugType.$star(), new StringRef(OS.str()), ErrNode));
      BR.$arrow().addRange(M.getOriginExpr().getSourceRange());
      
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(BR)))); $c$.clean();
      
      return true;
    } finally {
      if (BR != null) { BR.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  /// Returns the released value if M is a call a setter that releases
  /// and nils out its underlying instance variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::getValueReleasedByNillingOut">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 925,
   FQN="(anonymous namespace)::ObjCDeallocChecker::getValueReleasedByNillingOut", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker28getValueReleasedByNillingOutERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker28getValueReleasedByNillingOutERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  private /*const*/ SymExpr /*P*/ getValueReleasedByNillingOut(final /*const*/ ObjCMethodCall /*&*/ M, 
                              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> notNilState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> nilState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SVal ReceiverVal = M.getReceiverSVal();
      if (!ReceiverVal.isValid$SVal()) {
        return null;
      }
      if (M.getNumArgs() == 0) {
        return null;
      }
      if (!M.getArgExpr(0).getType().$arrow().isObjCRetainableType()) {
        return null;
      }
      
      // Is the first argument nil?
      SVal Arg = M.getArgSVal(0);
      notNilState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      nilState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(notNilState, nilState).$assign(
//          $c$.track(M.getState().$arrow().assume(Arg.castAs(DefinedOrUnknownSVal.class)))
//      ));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(M.getState().$arrow().assume(Arg.castAs(DefinedOrUnknownSVal.class)));
      notNilState.$assign($assume.first);
      nilState.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      if (!(nilState.$bool() && !notNilState.$bool())) {
        return null;
      }
      
      /*const*/ ObjCPropertyDecl /*P*/ Prop = M.getAccessedProperty();
      if (!(Prop != null)) {
        return null;
      }
      
      ObjCIvarDecl /*P*/ PropIvarDecl = Prop.getPropertyIvarDecl();
      if (!(PropIvarDecl != null)) {
        return null;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      SVal LVal = State.$arrow().getLValue(PropIvarDecl, new SVal(ReceiverVal));
      Optional<Loc> LValLoc = LVal.getAs(Loc.class);
      if (!LValLoc.$bool()) {
        return null;
      }
      
      SVal CurrentValInIvar = State.$arrow().getSVal(new Loc(LValLoc.getValue()));
      return CurrentValInIvar.getAsSymbol();
    } finally {
      if (State != null) { State.$destroy(); }
      if (nilState != null) { nilState.$destroy(); }
      if (notNilState != null) { notNilState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  /// Given a symbol for an ivar, return the ivar region it was loaded from.
  /// Returns nullptr if the instance symbol cannot be found.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::getIvarRegionForIvarSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 316,
   FQN="(anonymous namespace)::ObjCDeallocChecker::getIvarRegionForIvarSymbol", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker26getIvarRegionForIvarSymbolEPKN5clang4ento7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker26getIvarRegionForIvarSymbolEPKN5clang4ento7SymExprE")
  //</editor-fold>
  private /*const*/ ObjCIvarRegion /*P*/ getIvarRegionForIvarSymbol(/*const*/ SymExpr /*P*/ IvarSym) /*const*/ {
    return dyn_cast_or_null_ObjCIvarRegion(IvarSym.getOriginRegion());
  }

  
  /// Given a symbol for an ivar, return a symbol for the instance containing
  /// the ivar. Returns nullptr if the instance symbol cannot be found.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::getInstanceSymbolFromIvarSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 323,
   FQN="(anonymous namespace)::ObjCDeallocChecker::getInstanceSymbolFromIvarSymbol", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker31getInstanceSymbolFromIvarSymbolEPKN5clang4ento7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker31getInstanceSymbolFromIvarSymbolEPKN5clang4ento7SymExprE")
  //</editor-fold>
  private /*const*/ SymExpr /*P*/ getInstanceSymbolFromIvarSymbol(/*const*/ SymExpr /*P*/ IvarSym) /*const*/ {
    
    /*const*/ ObjCIvarRegion /*P*/ IvarRegion = getIvarRegionForIvarSymbol(IvarSym);
    if (!(IvarRegion != null)) {
      return null;
    }
    
    return IvarRegion.getSymbolicBase().getSymbol();
  }

  
  
  /// Given a symbol, determine whether the symbol refers to an ivar on
  /// the top-most deallocating instance. If so, find the property for that
  /// ivar, if one exists. Otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::findPropertyOnDeallocatingInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 613,
   FQN="(anonymous namespace)::ObjCDeallocChecker::findPropertyOnDeallocatingInstance", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker34findPropertyOnDeallocatingInstanceEPKN5clang4ento7SymExprERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker34findPropertyOnDeallocatingInstanceEPKN5clang4ento7SymExprERNS2_14CheckerContextE")
  //</editor-fold>
  private /*const*/ ObjCPropertyImplDecl /*P*/ findPropertyOnDeallocatingInstance(/*const*/ SymExpr /*P*/ IvarSym, final CheckerContext /*&*/ C) /*const*/ {
    SVal DeallocedInstance/*J*/= new SVal();
    if (!isInInstanceDealloc(C, DeallocedInstance)) {
      return null;
    }
    
    // Try to get the region from which the ivar value was loaded.
    /*const*/ ObjCIvarRegion /*P*/ IvarRegion = getIvarRegionForIvarSymbol(IvarSym);
    if (!(IvarRegion != null)) {
      return null;
    }
    
    // Don't try to find the property if the ivar was not loaded from the
    // given instance.
    if (DeallocedInstance.castAs(NsLoc.MemRegionVal.class).getRegion()
       != IvarRegion.getSuperRegion()) {
      return null;
    }
    
    /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
    /*const*/ ObjCIvarDecl /*P*/ IvarDecl = IvarRegion.getDecl();
    
    /*const*/ ObjCImplDecl /*P*/ Container = getContainingObjCImpl(LCtx);
    /*const*/ ObjCPropertyImplDecl /*P*/ PropImpl = Container.FindPropertyImplIvarDecl(IvarDecl.getIdentifier());
    return PropImpl;
  }

  
  
  /// Determines whether the instance variable for \p PropImpl must or must not be
  /// released in -dealloc or whether it cannot be determined.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::getDeallocReleaseRequirement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 889,
   FQN="(anonymous namespace)::ObjCDeallocChecker::getDeallocReleaseRequirement", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker28getDeallocReleaseRequirementEPKN5clang20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker28getDeallocReleaseRequirementEPKN5clang20ObjCPropertyImplDeclE")
  //</editor-fold>
  private ReleaseRequirement getDeallocReleaseRequirement(/*const*/ ObjCPropertyImplDecl /*P*/ PropImpl) /*const*/ {
    type$ptr</*const*/ ObjCIvarDecl /*P*/ > IvarDecl = create_type$null$ptr();
    type$ptr</*const*/ ObjCPropertyDecl /*P*/ > PropDecl = create_type$null$ptr();
    if (!CheckObjCDeallocStatics.isSynthesizedRetainableProperty(PropImpl, $AddrOf(IvarDecl), $AddrOf(PropDecl))) {
      return ReleaseRequirement.Unknown;
    }
    
    ObjCPropertyDecl.SetterKind SK = PropDecl.$star().getSetterKind();
    switch (SK) {
     case Retain:
     case Copy:
      // Retain and copy setters retain/copy their values before storing and so
      // the value in their instance variables must be released in -dealloc.
      if (isReleasedByCIFilterDealloc(PropImpl)) {
        return ReleaseRequirement.MustNotReleaseDirectly;
      }
      
      return ReleaseRequirement.MustRelease;
     case Weak:
      return ReleaseRequirement.MustNotReleaseDirectly;
     case Assign:
      // It is common for the ivars for read-only assign properties to
      // always be stored retained, so their release requirement cannot be
      // be determined.
      if (PropDecl.$star().isReadOnly()) {
        return ReleaseRequirement.Unknown;
      }
      
      return ReleaseRequirement.MustNotReleaseDirectly;
    }
    throw new llvm_unreachable("Unrecognized setter kind");
  }

  
  
  /// Returns true if the current context is a call to -dealloc and false
  /// otherwise. If true, it also sets SelfValOut to the value of
  /// 'self'.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::isInInstanceDealloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 968,
   FQN="(anonymous namespace)::ObjCDeallocChecker::isInInstanceDealloc", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker19isInInstanceDeallocERKN5clang4ento14CheckerContextERNS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker19isInInstanceDeallocERKN5clang4ento14CheckerContextERNS2_4SValE")
  //</editor-fold>
  private boolean isInInstanceDealloc(final /*const*/ CheckerContext /*&*/ C, 
                     final SVal /*&*/ SelfValOut) /*const*/ {
    return isInInstanceDealloc(C, C.getLocationContext(), SelfValOut);
  }

  
  /// Returns true if LCtx is a call to -dealloc and false
  /// otherwise. If true, it also sets SelfValOut to the value of
  /// 'self'.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::isInInstanceDealloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 976,
   FQN="(anonymous namespace)::ObjCDeallocChecker::isInInstanceDealloc", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker19isInInstanceDeallocERKN5clang4ento14CheckerContextEPKNS1_15LocationContextERNS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker19isInInstanceDeallocERKN5clang4ento14CheckerContextEPKNS1_15LocationContextERNS2_4SValE")
  //</editor-fold>
  private boolean isInInstanceDealloc(final /*const*/ CheckerContext /*&*/ C, 
                     /*const*/ LocationContext /*P*/ LCtx, 
                     final SVal /*&*/ SelfValOut) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(LCtx.getDecl());
      if (!(MD != null) || !MD.isInstanceMethod() || MD.getSelector().$noteq(/*NO_COPY*/DeallocSel)) {
        return false;
      }

      /*const*/ ImplicitParamDecl /*P*/ SelfDecl = LCtx.getSelfDecl();
      assert ((SelfDecl != null)) : "No self in -dealloc?";

      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SelfValOut.$assignMove(State.$arrow().getSVal(State.$arrow().getRegion(SelfDecl, LCtx)));
      return true;
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  
  /// Returns true if there is a call to -dealloc anywhere on the stack and false
  /// otherwise. If true, it also sets InstanceValOut to the value of
  /// 'self' in the frame for -dealloc.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::instanceDeallocIsOnStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 994,
   FQN="(anonymous namespace)::ObjCDeallocChecker::instanceDeallocIsOnStack", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker24instanceDeallocIsOnStackERKN5clang4ento14CheckerContextERNS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker24instanceDeallocIsOnStackERKN5clang4ento14CheckerContextERNS2_4SValE")
  //</editor-fold>
  private boolean instanceDeallocIsOnStack(final /*const*/ CheckerContext /*&*/ C, 
                          final SVal /*&*/ InstanceValOut) /*const*/ {
    /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
    while ((LCtx != null)) {
      if (isInInstanceDealloc(C, LCtx, InstanceValOut)) {
        return true;
      }
      
      LCtx = LCtx.getParent();
    }
    
    return false;
  }

  
  
  /// Returns true if M is a call to '[super dealloc]'.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::isSuperDeallocMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 791,
   FQN="(anonymous namespace)::ObjCDeallocChecker::isSuperDeallocMessage", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker21isSuperDeallocMessageERKN5clang4ento14ObjCMethodCallE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker21isSuperDeallocMessageERKN5clang4ento14ObjCMethodCallE")
  //</editor-fold>
  private boolean isSuperDeallocMessage(final /*const*/ ObjCMethodCall /*&*/ M) /*const*/ {
    if (M.getOriginExpr().getReceiverKind() != ObjCMessageExpr.ReceiverKind.SuperInstance) {
      return false;
    }
    
    return M.getSelector().$eq(/*NO_COPY*/DeallocSel);
  }

  
  
  /// Returns the ObjCImplDecl containing the method declaration in LCtx.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::getContainingObjCImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 800,
   FQN="(anonymous namespace)::ObjCDeallocChecker::getContainingObjCImpl", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker21getContainingObjCImplEPKN5clang15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker21getContainingObjCImplEPKN5clang15LocationContextE")
  //</editor-fold>
  private /*const*/ ObjCImplDecl /*P*/ getContainingObjCImpl(/*const*/ LocationContext /*P*/ LCtx) /*const*/ {
    /*const*/ ObjCMethodDecl /*P*/ MD = cast_ObjCMethodDecl(LCtx.getDecl());
    return cast_ObjCImplDecl(MD.getDeclContext$Const());
  }

  
  
  /// Returns the property that shadowed by PropImpl if one exists and
  /// nullptr otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::findShadowedPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 808,
   FQN="(anonymous namespace)::ObjCDeallocChecker::findShadowedPropertyDecl", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker24findShadowedPropertyDeclEPKN5clang20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker24findShadowedPropertyDeclEPKN5clang20ObjCPropertyImplDeclE")
  //</editor-fold>
  private /*const*/ ObjCPropertyDecl /*P*/ findShadowedPropertyDecl(/*const*/ ObjCPropertyImplDecl /*P*/ PropImpl) /*const*/ {
    /*const*/ ObjCPropertyDecl /*P*/ PropDecl = PropImpl.getPropertyDecl();
    
    // Only readwrite properties can shadow.
    if (PropDecl.isReadOnly()) {
      return null;
    }
    
    /*const*/ ObjCCategoryDecl /*P*/ CatDecl = dyn_cast_ObjCCategoryDecl(PropDecl.getDeclContext$Const());
    
    // Only class extensions can contain shadowing properties.
    if (!(CatDecl != null) || !CatDecl.IsClassExtension()) {
      return null;
    }
    
    IdentifierInfo /*P*/ ID = PropDecl.getIdentifier();
    DeclContextLookupResult R = CatDecl.getClassInterface$Const().lookup(new DeclarationName(ID));
    for (DeclContextLookupResult.iterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc()) {
      ObjCPropertyDecl /*P*/ ShadowedPropDecl = dyn_cast_ObjCPropertyDecl(I.$star());
      if (!(ShadowedPropDecl != null)) {
        continue;
      }
      if (ShadowedPropDecl.isInstanceProperty()) {
        assert (ShadowedPropDecl.isReadOnly());
        return ShadowedPropDecl;
      }
    }
    
    return null;
  }

  
  
  /// Add a transition noting the release of the given value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::transitionToReleaseValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 839,
   FQN="(anonymous namespace)::ObjCDeallocChecker::transitionToReleaseValue", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker24transitionToReleaseValueERN5clang4ento14CheckerContextEPKNS2_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker24transitionToReleaseValueERN5clang4ento14CheckerContextEPKNS2_7SymExprE")
  //</editor-fold>
  private void transitionToReleaseValue(final CheckerContext /*&*/ C, 
                          /*const*/ SymExpr /*P*/ Value) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> InitialState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> ReleasedState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert Native.$bool(Value);
      /*const*/ SymExpr /*P*/ InstanceSym = getInstanceSymbolFromIvarSymbol(Value);
      if (!(InstanceSym != null)) {
        return;
      }
      InitialState = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      ReleasedState = $c$.clean(removeValueRequiringRelease($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(InitialState)), InstanceSym, Value));
      if ($noteq_IntrusiveRefCntPtr(ReleasedState, InitialState)) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(ReleasedState))));
      }
    } finally {
      if (ReleasedState != null) { ReleasedState.$destroy(); }
      if (InitialState != null) { InitialState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Remove the Value requiring a release from the tracked set for
  /// Instance and return the resultant state.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::removeValueRequiringRelease">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 857,
   FQN="(anonymous namespace)::ObjCDeallocChecker::removeValueRequiringRelease", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker27removeValueRequiringReleaseEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker27removeValueRequiringReleaseEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprESA_")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> removeValueRequiringRelease(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ SymExpr /*P*/ Instance, /*const*/ SymExpr /*P*/ Value) /*const*/ {
    ImmutableSetPtr</*const*/ SymExpr /*P*/ > NewUnreleased = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert Native.$bool(Instance);
      assert Native.$bool(Value);
      /*const*/ ObjCIvarRegion /*P*/ RemovedRegion = getIvarRegionForIvarSymbol(Value);
      if (!(RemovedRegion != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      /*const*/ImmutableSetPtr</*const*/ SymExpr /*P*/ > /*P*/ Unreleased = State.$arrow().get(ProgramStateTraitUnreleasedIvarMap.$Instance, Instance);
      if (!(Unreleased != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      // Mark the value as no longer requiring a release.
      final ImmutableSetPtr.Factory</*const*/ SymExpr /*P*/ > /*&*/ F = State.$arrow().getStateManager().get_context(ProgramStateTraitImmutableSet$SymExpr$C$P.$Instance);
      NewUnreleased = new ImmutableSetPtr</*const*/ SymExpr /*P*/ >($Deref(Unreleased));
      for (final /*const*/ SymExpr /*P*/ /*const*/ /*&*/ Sym : $Deref(Unreleased)) {
        /*const*/ ObjCIvarRegion /*P*/ UnreleasedRegion = getIvarRegionForIvarSymbol(Sym);
        assert Native.$bool(UnreleasedRegion);
        if (RemovedRegion.getDecl() == UnreleasedRegion.getDecl()) {
          $c$.clean(NewUnreleased.$assign($c$.track(F.remove($c$.track(new ImmutableSetPtr</*const*/ SymExpr /*P*/ >(NewUnreleased)), Sym))));
        }
      }
      if (NewUnreleased.isEmpty()) {
        return State.$arrow().remove(ProgramStateTraitUnreleasedIvarMap.$Instance, Instance);
      }
      
      return $c$.clean(State.$arrow().set(ProgramStateTraitUnreleasedIvarMap.$Instance, Instance, $c$.track(new ImmutableSetPtr</*const*/ SymExpr /*P*/ >(NewUnreleased))));
    } finally {
      if (NewUnreleased != null) { NewUnreleased.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::initIdentifierInfoAndSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 773,
   FQN="(anonymous namespace)::ObjCDeallocChecker::initIdentifierInfoAndSelectors", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker30initIdentifierInfoAndSelectorsERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker30initIdentifierInfoAndSelectorsERN5clang10ASTContextE")
  //</editor-fold>
  private void initIdentifierInfoAndSelectors(final ASTContext /*&*/ Ctx) /*const*/ {
    if ((NSObjectII != null)) {
      return;
    }
    
    NSObjectII = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSObject")));
    SenTestCaseII = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"SenTestCase")));
    XCTestCaseII = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"XCTestCase")));
    Block_releaseII = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"_Block_release")));
    CIFilterII = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CIFilter")));
    
    type$ptr<IdentifierInfo /*P*/ > DeallocII = create_type$ptr($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dealloc"))));
    type$ptr<IdentifierInfo /*P*/ > ReleaseII = create_type$ptr($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"release"))));
    DeallocSel.$assignMove(Ctx.Selectors.getSelector(0, $AddrOf(DeallocII)));
    ReleaseSel.$assignMove(Ctx.Selectors.getSelector(0, $AddrOf(ReleaseII)));
  }

  
  
  /// Returns true if the ID is a class in which which is known to have
  /// a separate teardown lifecycle. In this case, -dealloc warnings
  /// about missing releases should be suppressed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::classHasSeparateTeardown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 1011,
   FQN="(anonymous namespace)::ObjCDeallocChecker::classHasSeparateTeardown", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker24classHasSeparateTeardownEPKN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker24classHasSeparateTeardownEPKN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  private boolean classHasSeparateTeardown(/*const*/ ObjCInterfaceDecl /*P*/ ID) /*const*/ {
    // Suppress if the class is not a subclass of NSObject.
    for (; (ID != null); ID = ID.getSuperClass()) {
      IdentifierInfo /*P*/ II = ID.getIdentifier();
      if (II == NSObjectII) {
        return false;
      }
      
      // FIXME: For now, ignore classes that subclass SenTestCase and XCTestCase,
      // as these don't need to implement -dealloc.  They implement tear down in
      // another way, which we should try and catch later.
      //  http://llvm.org/bugs/show_bug.cgi?id=3187
      if (II == XCTestCaseII || II == SenTestCaseII) {
        return true;
      }
    }
    
    return true;
  }

  
  
  /// The -dealloc method in CIFilter highly unusual in that is will release
  /// instance variables belonging to its *subclasses* if the variable name
  /// starts with "input" or backs a property whose name starts with "input".
  /// Subclasses should not release these ivars in their own -dealloc method --
  /// doing so could result in an over release.
  ///
  /// This method returns true if the property will be released by
  /// -[CIFilter dealloc].
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::isReleasedByCIFilterDealloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 1039,
   FQN="(anonymous namespace)::ObjCDeallocChecker::isReleasedByCIFilterDealloc", NM="_ZNK12_GLOBAL__N_118ObjCDeallocChecker27isReleasedByCIFilterDeallocEPKN5clang20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZNK12_GLOBAL__N_118ObjCDeallocChecker27isReleasedByCIFilterDeallocEPKN5clang20ObjCPropertyImplDeclE")
  //</editor-fold>
  private boolean isReleasedByCIFilterDealloc(/*const*/ ObjCPropertyImplDecl /*P*/ PropImpl) /*const*/ {
    assert Native.$bool(PropImpl.getPropertyIvarDecl());
    StringRef PropName = PropImpl.getPropertyDecl().getName();
    StringRef IvarName = PropImpl.getPropertyIvarDecl().getName();
    
    /*const*/char$ptr/*char P*/ ReleasePrefix = $("input");
    if (!(PropName.startswith(/*STRINGREF_STR*/ReleasePrefix)
       || IvarName.startswith(/*STRINGREF_STR*/ReleasePrefix))) {
      return false;
    }
    
    /*const*/ ObjCInterfaceDecl /*P*/ ID = PropImpl.getPropertyIvarDecl().getContainingInterface();
    for (; (ID != null); ID = ID.getSuperClass()) {
      IdentifierInfo /*P*/ II = ID.getIdentifier();
      if (II == CIFilterII) {
        return true;
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCDeallocChecker::~ObjCDeallocChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 92,
   FQN="(anonymous namespace)::ObjCDeallocChecker::~ObjCDeallocChecker", NM="_ZN12_GLOBAL__N_118ObjCDeallocCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZN12_GLOBAL__N_118ObjCDeallocCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    MistakenDeallocBugType.$destroy();
    ExtraReleaseBugType.$destroy();
    MissingReleaseBugType.$destroy();
    super.$destroy();
    //END JDestroy
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ReturnStmt) {
      checkPreStmt((ReturnStmt) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new ASTDecl<ObjCImplementationDecl>(ObjCImplementationDecl.class),
    new PreObjCMessage(),
    new PostObjCMessage(),
    new PreCall(),
    new BeginFunction(),
    new EndFunction(),
    new eval.Assume(),
    new PointerEscape(),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NSObjectII=" + NSObjectII // NOI18N
              + ", SenTestCaseII=" + SenTestCaseII // NOI18N
              + ", XCTestCaseII=" + XCTestCaseII // NOI18N
              + ", Block_releaseII=" + Block_releaseII // NOI18N
              + ", CIFilterII=" + CIFilterII // NOI18N
              + ", DeallocSel=" + DeallocSel // NOI18N
              + ", ReleaseSel=" + ReleaseSel // NOI18N
              + ", MissingReleaseBugType=" + MissingReleaseBugType // NOI18N
              + ", ExtraReleaseBugType=" + ExtraReleaseBugType // NOI18N
              + ", MistakenDeallocBugType=" + MistakenDeallocBugType // NOI18N
              + super.toString(); // NOI18N
  }
}
