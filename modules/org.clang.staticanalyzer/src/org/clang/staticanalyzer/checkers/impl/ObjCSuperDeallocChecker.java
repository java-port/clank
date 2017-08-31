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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 27,
 FQN="(anonymous namespace)::ObjCSuperDeallocChecker", NM="_ZN12_GLOBAL__N_123ObjCSuperDeallocCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZN12_GLOBAL__N_123ObjCSuperDeallocCheckerE")
//</editor-fold>
public class ObjCSuperDeallocChecker extends /*public*/ Checker/*<PostObjCMessage, PreObjCMessage, PreCall, Location>*/ 
        implements org.clang.staticanalyzer.java.PreObjCMessageChecker, org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.LocationChecker, Destructors.ClassWithDestructor {

  private /*mutable */IdentifierInfo /*P*/ IIdealloc;
  
  private /*mutable */IdentifierInfo /*P*/ IINSObject;
  private /*mutable */Selector SELdealloc;
  
  private std.unique_ptr<BugType> DoubleSuperDeallocBugType;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::initIdentifierInfoAndSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 230,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::initIdentifierInfoAndSelectors", NM="_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker30initIdentifierInfoAndSelectorsERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker30initIdentifierInfoAndSelectorsERN5clang10ASTContextE")
  //</editor-fold>
  private void initIdentifierInfoAndSelectors(final ASTContext /*&*/ Ctx) /*const*/ {
    if ((IIdealloc != null)) {
      return;
    }
    
    IIdealloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dealloc")));
    IINSObject = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSObject")));
    
    SELdealloc.$assignMove(Ctx.Selectors.getSelector(0, $AddrOf(create_type$ptr2ConstT(IIdealloc))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::isSuperDeallocMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 241,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::isSuperDeallocMessage", NM="_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker21isSuperDeallocMessageERKN5clang4ento14ObjCMethodCallE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker21isSuperDeallocMessageERKN5clang4ento14ObjCMethodCallE")
  //</editor-fold>
  private boolean isSuperDeallocMessage(final /*const*/ ObjCMethodCall /*&*/ M) /*const*/ {
    if (M.getOriginExpr().getReceiverKind() != ObjCMessageExpr.ReceiverKind.SuperInstance) {
      return false;
    }
    
    final ASTContext /*&*/ Ctx = M.getState().$arrow().getStateManager().getContext();
    initIdentifierInfoAndSelectors(Ctx);
    
    return M.getSelector().$eq(/*NO_COPY*/SELdealloc);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::ObjCSuperDeallocChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 222,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::ObjCSuperDeallocChecker", NM="_ZN12_GLOBAL__N_123ObjCSuperDeallocCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZN12_GLOBAL__N_123ObjCSuperDeallocCheckerC1Ev")
  //</editor-fold>
  public ObjCSuperDeallocChecker() {
    // : Checker<PostObjCMessage, PreObjCMessage, PreCall, Location>(), IIdealloc(null), IINSObject(null), SELdealloc(), DoubleSuperDeallocBugType() 
    //START JInit
    super();
    this.IIdealloc = null;
    this.IINSObject = null;
    this.SELdealloc = new Selector();
    this.DoubleSuperDeallocBugType = new std.unique_ptr<BugType>();
    //END JInit
    
    DoubleSuperDeallocBugType.reset(new BugType(this, new StringRef(/*KEEP_STR*/"[super dealloc] should not be called more than once"), 
            new StringRef(categories.CoreFoundationObjectiveC)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 119,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, 
                      final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Check for [super dealloc] method call.
      if (!isSuperDeallocMessage(M)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ SymExpr /*P*/ ReceiverSymbol = M.getSelfSVal().getAsSymbol();
      assert ((ReceiverSymbol != null)) : "No receiver symbol at call to [super dealloc]?";
      
      // We add this transition in checkPostObjCMessage to avoid warning when
      // we inline a call to [super dealloc] where the inlined call itself
      // calls [super dealloc].
      $c$.clean(State.$assign($c$.track(State.$arrow().add(ProgramStateTraitCalledSuperDealloc.$Instance, ReceiverSymbol))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  // End anonymous namespace.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 87,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, 
                     final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ SymExpr /*P*/ ReceiverSymbol = M.getReceiverSVal().getAsSymbol();
      if (!(ReceiverSymbol != null)) {
        diagnoseCallArguments(M, C);
        return;
      }

      boolean AlreadyCalled = State.$arrow().contains(ProgramStateTraitCalledSuperDealloc.$Instance, ReceiverSymbol);
      if (!AlreadyCalled) {
        return;
      }

      StringRef Desc/*J*/= new StringRef();
      if (isSuperDeallocMessage(M)) {
        Desc.$assignMove(/*STRINGREF_STR*/"[super dealloc] should not be called multiple times");
      } else {
        Desc.$assignMove(new StringRef());
      }

      reportUseAfterDealloc(ReceiverSymbol, new StringRef(Desc), M.getOriginExpr(), C);

      return;
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::checkPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 114,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    diagnoseCallArguments(Call, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::checkLocation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 136,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::checkLocation", NM="_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkLocation(SVal L, boolean IsLoad, /*const*/ Stmt /*P*/ S, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    raw_string_ostream OS = null;
    try {
      /*const*/ SymExpr /*P*/ BaseSym = L.getLocSymbolInBase();
      if (!(BaseSym != null)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (!State.$arrow().contains(ProgramStateTraitCalledSuperDealloc.$Instance, BaseSym)) {
        return;
      }
      
      /*const*/ MemRegion /*P*/ R = L.getAsRegion();
      if (!(R != null)) {
        return;
      }
      
      // Climb the super regions to find the base symbol while recording
      // the second-to-last region for error reporting.
      /*const*/ MemRegion /*P*/ PriorSubRegion = null;
      {
        /*const*/ SubRegion /*P*/ SR;
        while (((/*P*/ SR = dyn_cast_SubRegion(R)) != null)) {
          {
            /*const*/ SymbolicRegion /*P*/ SymR = dyn_cast_SymbolicRegion(SR);
            if ((SymR != null)) {
              BaseSym = SymR.getSymbol();
              break;
            } else {
              R = SR.getSuperRegion();
              PriorSubRegion = SR;
            }
          }
        }
      }
      
      StringRef Desc = new StringRef();
      /*const*/ ObjCIvarRegion /*P*/ IvarRegion = dyn_cast_or_null_ObjCIvarRegion(PriorSubRegion);
      
      std.string Buf/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Buf);
      if ((IvarRegion != null)) {
        $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/"Use of instance variable '"), $Deref(IvarRegion.getDecl())).$out(
            /*KEEP_STR*/"' after 'self' has been deallocated"
        );
        Desc.$assignMove(new StringRef(OS.str()));
      }
      
      reportUseAfterDealloc(BaseSym, new StringRef(Desc), S, C);
    } finally {
      if (OS != null) { OS.$destroy(); }
      if (State != null) { State.$destroy(); }
    }
  }

/*private:*/
  
  
  /// Diagnose if any of the arguments to CE have already been
  /// dealloc'd.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::diagnoseCallArguments">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 206,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::diagnoseCallArguments", NM="_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker21diagnoseCallArgumentsERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker21diagnoseCallArgumentsERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  private void diagnoseCallArguments(final /*const*/ CallEvent /*&*/ CE, 
                       final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*uint*/int ArgCount = CE.getNumArgs();
      for (/*uint*/int I = 0; $less_uint(I, ArgCount); I++) {
        /*const*/ SymExpr /*P*/ Sym = CE.getArgSVal(I).getAsSymbol();
        if (!(Sym != null)) {
          continue;
        }
        if (State.$arrow().contains(ProgramStateTraitCalledSuperDealloc.$Instance, Sym)) {
          reportUseAfterDealloc(Sym, new StringRef(), CE.getArgExpr(I), C);
          return;
        }
      }
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  
  
  /// Report a use-after-dealloc on Sym. If not empty,
  /// Desc will be used to describe the error; otherwise,
  /// a default warning will be used.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::reportUseAfterDealloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 181,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::reportUseAfterDealloc", NM="_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker21reportUseAfterDeallocEPKN5clang4ento7SymExprEN4llvm9StringRefEPKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZNK12_GLOBAL__N_123ObjCSuperDeallocChecker21reportUseAfterDeallocEPKN5clang4ento7SymExprEN4llvm9StringRefEPKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  private void reportUseAfterDealloc(/*const*/ SymExpr /*P*/ Sym, 
                       StringRef Desc, 
                       /*const*/ Stmt /*P*/ S, 
                       final CheckerContext /*&*/ C) /*const*/ {
    std.unique_ptr<BugReport> BR = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We have a use of self after free.
      // This likely causes a crash, so stop exploring the
      // path by generating a sink.
      ExplodedNode /*P*/ ErrNode = C.generateErrorNode();
      // If we've already reached this node on another path, return.
      if (!(ErrNode != null)) {
        return;
      }
      if (Desc.empty()) {
        Desc.$assignMove(/*STRINGREF_STR*/"use of 'self' after it has been deallocated");
      }
      
      // Generate the report.
      BR/*J*/= new std.unique_ptr<BugReport>(new BugReport(DoubleSuperDeallocBugType.$star(), new StringRef(Desc), ErrNode));
      BR.$arrow().addRange(S.getSourceRange());
      BR.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new SuperDeallocBRVisitor(Sym)))))); $c$.clean();
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(BR)))); $c$.clean();
    } finally {
      if (BR != null) { BR.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperDeallocChecker::~ObjCSuperDeallocChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 27,
   FQN="(anonymous namespace)::ObjCSuperDeallocChecker::~ObjCSuperDeallocChecker", NM="_ZN12_GLOBAL__N_123ObjCSuperDeallocCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZN12_GLOBAL__N_123ObjCSuperDeallocCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DoubleSuperDeallocBugType.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new PostObjCMessage(),
    new PreObjCMessage(),
    new PreCall(),
    new Location()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "IIdealloc=" + IIdealloc // NOI18N
              + ", IINSObject=" + IINSObject // NOI18N
              + ", SELdealloc=" + SELdealloc // NOI18N
              + ", DoubleSuperDeallocBugType=" + DoubleSuperDeallocBugType // NOI18N
              + super.toString(); // NOI18N
  }
}
