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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;
import org.clang.staticanalyzer.java.*;
import org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 58,
 FQN="(anonymous namespace)::ObjCSelfInitChecker", NM="_ZN12_GLOBAL__N_119ObjCSelfInitCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZN12_GLOBAL__N_119ObjCSelfInitCheckerE")
//</editor-fold>
public class ObjCSelfInitChecker extends /*public*/ Checker/*<PostObjCMessage, PostStmt<ObjCIvarRefExpr>, PreStmt<ReturnStmt>, PreCall, PostCall, Location, Bind>*/ 
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PostCallChecker, org.clang.staticanalyzer.java.LocationChecker, org.clang.staticanalyzer.java.BindChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::checkForInvalidSelf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 144,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::checkForInvalidSelf", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker19checkForInvalidSelfEPKN5clang4ExprERNS1_4ento14CheckerContextEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker19checkForInvalidSelfEPKN5clang4ExprERNS1_4ento14CheckerContextEPKc")
  //</editor-fold>
  private void checkForInvalidSelf(/*const*/ Expr /*P*/ E, final CheckerContext /*&*/ C, 
                     /*const*/char$ptr/*char P*/ errorStr) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!(E != null)) {
        return;
      }
      if (!C.getState().$arrow().get(ProgramStateTraitCalledInit.$Instance)) {
        return;
      }
      if (!ObjCSelfInitCheckerStatics.isInvalidSelf(E, C)) {
        return;
      }
      
      // Generate an error node.
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if (!(N != null)) {
        return;
      }
      if (!BT.$bool()) {
        BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Missing \"self = [(super or self) init...]\""), 
                new StringRef(categories.CoreFoundationObjectiveC)));
      }
      C.emitReport($c$.track(llvm.make_unique(new BugReport(BT.$star(), errorStr, N)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::ObjCSelfInitChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 71,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::ObjCSelfInitChecker", NM="_ZN12_GLOBAL__N_119ObjCSelfInitCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZN12_GLOBAL__N_119ObjCSelfInitCheckerC1Ev")
  //</editor-fold>
  public ObjCSelfInitChecker() {
    // : Checker<PostObjCMessage, PostStmt<ObjCIvarRefExpr>, PreStmt<ReturnStmt>, PreCall, PostCall, Location, Bind>(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 166,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ Msg, 
                      final CheckerContext /*&*/ C) /*const*/ {
    // When encountering a message that does initialization (init rule),
    // tag the return value so that we know later on that if self has this value
    // then it is properly initialized.
    
    // FIXME: A callback should disable checkers at the start of functions.
    if (!ObjCSelfInitCheckerStatics.shouldRunOnFunctionOrMethod(dyn_cast_NamedDecl(C.getCurrentAnalysisDeclContext().getDecl()))) {
      return;
    }
    if (ObjCSelfInitCheckerStatics.isInitMessage(Msg)) {
      IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Tag the return value as the result of an initializer.
        state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
        
        // FIXME this really should be context sensitive, where we record
        // the current stack frame (for IPA).  Also, we need to clean this
        // value out when we return from this method.
        $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitCalledInit.$Instance, true))));
        
        SVal V = state.$arrow().getSVal(Msg.getOriginExpr(), C.getLocationContext());
        ObjCSelfInitCheckerStatics.addSelfFlag($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(V), SelfFlagEnum.SelfFlag_InitRes, C); $c$.clean();
        return;
      } finally {
        if (state != null) { state.$destroy(); }
        $c$.$destroy();
      }
    }
    // We don't check for an invalid 'self' in an obj-c message expression to cut
    // down false positives where logging functions get information from self
    // (like its class) or doing "invalidation" on self when the initialization
    // fails.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 197,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker13checkPostStmtEPKN5clang15ObjCIvarRefExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker13checkPostStmtEPKN5clang15ObjCIvarRefExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCIvarRefExpr /*P*/ E, 
               final CheckerContext /*&*/ C) /*const*/ {
    // FIXME: A callback should disable checkers at the start of functions.
    if (!ObjCSelfInitCheckerStatics.shouldRunOnFunctionOrMethod(dyn_cast_NamedDecl(C.getCurrentAnalysisDeclContext().getDecl()))) {
      return;
    }
    
    checkForInvalidSelf(E.getBase$Const(), C, 
        $("Instance variable used while 'self' is not set to the result of '[(super or self) init...]'"));
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 210,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ S, 
              final CheckerContext /*&*/ C) /*const*/ {
    // FIXME: A callback should disable checkers at the start of functions.
    if (!ObjCSelfInitCheckerStatics.shouldRunOnFunctionOrMethod(dyn_cast_NamedDecl(C.getCurrentAnalysisDeclContext().getDecl()))) {
      return;
    }
    
    checkForInvalidSelf(S.getRetValue$Const(), C, 
        $("Returning 'self' while it is not set to the result of '[(super or self) init...]'"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::checkLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 301,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::checkLocation", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkLocation(SVal location, boolean isLoad, 
               /*const*/ Stmt /*P*/ S, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      if (!ObjCSelfInitCheckerStatics.shouldRunOnFunctionOrMethod(dyn_cast_NamedDecl(C.getCurrentAnalysisDeclContext().getDecl()))) {
        return;
      }

      // Tag the result of a load from 'self' so that we can easily know that the
      // value is the object that 'self' points to.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (ObjCSelfInitCheckerStatics.isSelfVar(new SVal(location), C)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ObjCSelfInitCheckerStatics.addSelfFlag($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), state.$arrow().getSVal(location.castAs(Loc.class)), SelfFlagEnum.SelfFlag_Self, 
              C); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
     if (state != null) { state.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::checkBind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 317,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::checkBind", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkBind(SVal loc, SVal val, /*const*/ Stmt /*P*/ S, 
           final CheckerContext /*&*/ C) /*const*/ {
    // Allow assignment of anything to self. Self is a local variable in the
    // initializer, so it is legal to assign anything to it, like results of
    // static functions/method calls. After self is assigned something we cannot
    // reason about, stop enforcing the rules.
    // (Only continue checking if the assigned value should be treated as self.)
    if ((ObjCSelfInitCheckerStatics.isSelfVar(new SVal(loc), C))
       && !ObjCSelfInitCheckerStatics.hasSelfFlag(new SVal(val), SelfFlagEnum.SelfFlag_InitRes, C)
       && !ObjCSelfInitCheckerStatics.hasSelfFlag(new SVal(val), SelfFlagEnum.SelfFlag_Self, C)
       && !ObjCSelfInitCheckerStatics.isSelfVar(new SVal(val), C)) {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        
        // Stop tracking the checker-specific state in the state.
        State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
        $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitCalledInit.$Instance))));
        {
          /*const*/ SymExpr /*P*/ sym = loc.getAsSymbol();
          if ((sym != null)) {
            $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitSelfFlag.$Instance, sym))));
          }
        }
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      } finally {
        if (State != null) { State.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  
  
  // When a call receives a reference to 'self', [Pre/Post]Call pass
  // the SelfFlags from the object 'self' points to before the call to the new
  // object after the call. This is to avoid invalidation of 'self' by logging
  // functions.
  // Another common pattern in classes with multiple initializers is to put the
  // subclass's common initialization bits into a static function that receives
  // the value of 'self', e.g:
  // @code
  //   if (!(self = [super init]))
  //     return nil;
  //   if (!(self = _commonInit(self)))
  //     return nil;
  // @endcode
  // Until we can use inter-procedural analysis, in such a call, transfer the
  // SelfFlags to the result of the call.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::checkPreCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 238,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      // FIXME: A callback should disable checkers at the start of functions.
      if (!ObjCSelfInitCheckerStatics.shouldRunOnFunctionOrMethod(dyn_cast_NamedDecl(C.getCurrentAnalysisDeclContext().getDecl()))) {
        return;
      }

      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*uint*/int NumArgs = CE.getNumArgs();
      // If we passed 'self' as and argument to the call, record it in the state
      // to be propagated after the call.
      // Note, we could have just given up, but try to be more optimistic here and
      // assume that the functions are going to continue initialization or will not
      // modify self.
      for (/*uint*/int i = 0; $less_uint(i, NumArgs); ++i) {
        SVal argV = CE.getArgSVal(i);
        if (ObjCSelfInitCheckerStatics.isSelfVar(new SVal(argV), C)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int selfFlags = ObjCSelfInitCheckerStatics.getSelfFlags(state.$arrow().getSVal(argV.castAs(Loc.class)), C);
            $c$.clean(C.addTransition($c$.track(state.$arrow().set(ProgramStateTraitPreCallSelfFlags.$Instance, selfFlags))));
            return;
          } finally {
            $c$.$destroy();
          }
        } else if (ObjCSelfInitCheckerStatics.hasSelfFlag(new SVal(argV), SelfFlagEnum.SelfFlag_Self, C)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int selfFlags = ObjCSelfInitCheckerStatics.getSelfFlags(new SVal(argV), C);
            $c$.clean(C.addTransition($c$.track(state.$arrow().set(ProgramStateTraitPreCallSelfFlags.$Instance, selfFlags))));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    } finally {
     if (state != null) { state.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::checkPostCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 266,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::checkPostCall", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: A callback should disable checkers at the start of functions.
      if (!ObjCSelfInitCheckerStatics.shouldRunOnFunctionOrMethod(dyn_cast_NamedDecl(C.getCurrentAnalysisDeclContext().getDecl()))) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*SelfFlagEnum*//*uint*/int prevFlags = (/*SelfFlagEnum*//*uint*/int)state.$arrow().get(ProgramStateTraitPreCallSelfFlags.$Instance);
      if (!(prevFlags != 0)) {
        return;
      }
      $c$.clean(state.$assign($c$.track(state.$arrow().remove(ProgramStateTraitPreCallSelfFlags.$Instance))));
      
      /*uint*/int NumArgs = CE.getNumArgs();
      for (/*uint*/int i = 0; $less_uint(i, NumArgs); ++i) {
        SVal argV = CE.getArgSVal(i);
        if (ObjCSelfInitCheckerStatics.isSelfVar(new SVal(argV), C)) {
          // If the address of 'self' is being passed to the call, assume that the
          // 'self' after the call will have the same flags.
          // EX: log(&self)
          ObjCSelfInitCheckerStatics.addSelfFlag($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), state.$arrow().getSVal(argV.castAs(Loc.class)), prevFlags, C); $c$.clean();
          return;
        } else if (ObjCSelfInitCheckerStatics.hasSelfFlag(new SVal(argV), SelfFlagEnum.SelfFlag_Self, C)) {
          // If 'self' is passed to the call by value, assume that the function
          // returns 'self'. So assign the flags, which were set on 'self' to the
          // return value.
          // EX: self = performMoreInitialization(self)
          ObjCSelfInitCheckerStatics.addSelfFlag($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), CE.getReturnValue(), prevFlags, C); $c$.clean();
          return;
        }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::printState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 338,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::printState", NM="_ZNK12_GLOBAL__N_119ObjCSelfInitChecker10printStateERN4llvm11raw_ostreamENS1_18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKcSB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZNK12_GLOBAL__N_119ObjCSelfInitChecker10printStateERN4llvm11raw_ostreamENS1_18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKcSB_")
  //</editor-fold>
  @Override public void printState(final raw_ostream /*&*/ Out, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            /*const*/char$ptr/*char P*/ NL, /*const*/char$ptr/*char P*/ Sep) /*const*//* override*/ {
    ImmutableMapPtrUInt</*const*/ SymExpr /*P*/ > FlagMap = null;
    try {
      FlagMap = State.$arrow().get(ProgramStateTraitSelfFlag.$Instance);
      boolean DidCallInit = State.$arrow().get(ProgramStateTraitCalledInit.$Instance);
      /*SelfFlagEnum*//*uint*/int PreCallFlags = (/*SelfFlagEnum*//*uint*/int)State.$arrow().get(ProgramStateTraitPreCallSelfFlags.$Instance);
      if (FlagMap.isEmpty() && !DidCallInit && !(PreCallFlags != 0)) {
        return;
      }
      
      EntoGlobals.$out_raw_ostream_CheckerBase$C(Out.$out(Sep).$out(NL), /*Deref*/this).$out(/*KEEP_STR*/" :").$out(NL);
      if (DidCallInit) {
        Out.$out(/*KEEP_STR*/"  An init method has been called.").$out(NL);
      }
      if (PreCallFlags != SelfFlagEnum.SelfFlag_None) {
        if (((PreCallFlags & SelfFlagEnum.SelfFlag_Self) != 0)) {
          Out.$out(/*KEEP_STR*/"  An argument of the current call came from the 'self' variable.").$out(
              NL
          );
        }
        if (((PreCallFlags & SelfFlagEnum.SelfFlag_InitRes) != 0)) {
          Out.$out(/*KEEP_STR*/"  An argument of the current call came from an init method.").$out(
              NL
          );
        }
      }
      
      Out.$out(NL);
      ImmutableMapPtrUInt.iterator</*const*/ SymExpr /*P*/ > I = null;
      ImmutableMapPtrUInt.iterator</*const*/ SymExpr /*P*/ > E = null;
      try {
        for (I = FlagMap.begin(), E = FlagMap.end();
             I.$noteq(E); I.$preInc()) {
          StaticanalyzerLlvmGlobals.$out_raw_ostream_SymExpr$C$P(Out, I.$arrow().first).$out(/*KEEP_STR*/" : ");
          if (I.$arrow().second == SelfFlagEnum.SelfFlag_None) {
            Out.$out(/*KEEP_STR*/"none");
          }
          if (((I.$arrow().second & SelfFlagEnum.SelfFlag_Self) != 0)) {
            Out.$out(/*KEEP_STR*/"self variable");
          }
          if (((I.$arrow().second & SelfFlagEnum.SelfFlag_InitRes) != 0)) {
            if (I.$arrow().second != SelfFlagEnum.SelfFlag_InitRes) {
              Out.$out(/*KEEP_STR*/" | ");
            }
            Out.$out(/*KEEP_STR*/"result of init method");
          }
          
          Out.$out(NL);
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
    } finally {
      if (FlagMap != null) { FlagMap.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSelfInitChecker::~ObjCSelfInitChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 58,
   FQN="(anonymous namespace)::ObjCSelfInitChecker::~ObjCSelfInitChecker", NM="_ZN12_GLOBAL__N_119ObjCSelfInitCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZN12_GLOBAL__N_119ObjCSelfInitCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
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

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ObjCIvarRefExpr) {
      checkPostStmt((ObjCIvarRefExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new PostObjCMessage(),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCIvarRefExpr>(ObjCIvarRefExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
    new PreCall(),
    new PostCall(),
    new Location(),
    new Bind()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
