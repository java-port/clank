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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.checkers.ento.impl.EntoStatics;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NoReturnFunctionChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp", line = 30,
 FQN="(anonymous namespace)::NoReturnFunctionChecker", NM="_ZN12_GLOBAL__N_123NoReturnFunctionCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp -nm=_ZN12_GLOBAL__N_123NoReturnFunctionCheckerE")
//</editor-fold>
public class NoReturnFunctionChecker extends /*public*/ Checker/*<PostCall, PostObjCMessage> */
        implements org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PostCallChecker, Destructors.ClassWithDestructor {
  private /*mutable */Selector HandleFailureInFunctionSel;
  private /*mutable */Selector HandleFailureInMethodSel;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NoReturnFunctionChecker::checkPostCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp", line = 41,
   FQN="(anonymous namespace)::NoReturnFunctionChecker::checkPostCall", NM="_ZNK12_GLOBAL__N_123NoReturnFunctionChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp -nm=_ZNK12_GLOBAL__N_123NoReturnFunctionChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    boolean BuildSinks = false;
    {
      
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(CE.getDecl());
      if ((FD != null)) {
        BuildSinks = FD.hasAttr(AnalyzerNoReturnAttr.class) || FD.isNoReturn();
      }
    }
    
    /*const*/ Expr /*P*/ Callee = CE.getOriginExpr();
    if (!BuildSinks && (Callee != null)) {
      BuildSinks = getFunctionExtInfo(Callee.getType()).getNoReturn();
    }
    if (!BuildSinks && CE.isGlobalCFunction()) {
      {
        /*const*/ IdentifierInfo /*P*/ II = CE.getCalleeIdentifier();
        if ((II != null)) {
          // HACK: Some functions are not marked noreturn, and don't return.
          //  Here are a few hardwired ones.  If this takes too long, we can
          //  potentially cache these results.
          BuildSinks
             = new StringSwitchBool(II.getName()).
              Case(/*KEEP_STR*/"exit", true).
              Case(/*KEEP_STR*/"panic", true).
              Case(/*KEEP_STR*/"error", true).
              Case(/*KEEP_STR*/"Assert", true).
              // FIXME: This is just a wrapper around throwing an exception.
              //  Eventually inter-procedural analysis should handle this easily.
              Case(/*KEEP_STR*/"ziperr", true).
              Case(/*KEEP_STR*/"assfail", true).
              Case(/*KEEP_STR*/"db_error", true).
              Case(/*KEEP_STR*/"__assert", true).
              Case(/*KEEP_STR*/"__assert2", true).
              // For the purpose of static analysis, we do not care that
              //  this MSVC function will return if the user decides to continue.
              Case(/*KEEP_STR*/"_wassert", true).
              Case(/*KEEP_STR*/"__assert_rtn", true).
              Case(/*KEEP_STR*/"__assert_fail", true).
              Case(/*KEEP_STR*/"dtrace_assfail", true).
              Case(/*KEEP_STR*/"yy_fatal_error", true).
              Case(/*KEEP_STR*/"_XCAssertionFailureHandler", true).
              Case(/*KEEP_STR*/"_DTAssertionFailureHandler", true).
              Case(/*KEEP_STR*/"_TSAssertionFailureHandler", true).
              Default(false);
        }
      }
    }
    if (BuildSinks) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(C.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), C.getPredecessor()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NoReturnFunctionChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp", line = 88,
   FQN="(anonymous namespace)::NoReturnFunctionChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_123NoReturnFunctionChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp -nm=_ZNK12_GLOBAL__N_123NoReturnFunctionChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ Msg, 
                      final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        // Check if the method is annotated with analyzer_noreturn.
        /*const*/ ObjCMethodDecl /*P*/ MD = Msg.getDecl();
        if ((MD != null)) {
          MD = MD.getCanonicalDecl$Const();
          if (MD.hasAttr(AnalyzerNoReturnAttr.class)) {
            $c$.clean(C.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), C.getPredecessor()));
            return;
          }
        }
      }
      
      // HACK: This entire check is to handle two messages in the Cocoa frameworks:
      // -[NSAssertionHandler
      //    handleFailureInMethod:object:file:lineNumber:description:]
      // -[NSAssertionHandler
      //    handleFailureInFunction:file:lineNumber:description:]
      // Eventually these should be annotated with __attribute__((noreturn)).
      // Because ObjC messages use dynamic dispatch, it is not generally safe to
      // assume certain methods can't return. In cases where it is definitely valid,
      // see if you can mark the methods noreturn or analyzer_noreturn instead of
      // adding more explicit checks to this method.
      if (!Msg.isInstanceMessage()) {
        return;
      }
      
      /*const*/ ObjCInterfaceDecl /*P*/ Receiver = Msg.getReceiverInterface();
      if (!(Receiver != null)) {
        return;
      }
      if (!Receiver.getIdentifier().isStr(/*KEEP_STR*/"NSAssertionHandler")) {
        return;
      }
      
      Selector Sel = Msg.getSelector();
      switch (Sel.getNumArgs()) {
       default:
        return;
       case 4:
        EntoStatics.lazyInitKeywordSelector(HandleFailureInFunctionSel, C.getASTContext(), 
            $("handleFailureInFunction"), $("file"), $("lineNumber"), 
            $("description"), null);
        if (Sel.$noteq(/*NO_COPY*/HandleFailureInFunctionSel)) {
          return;
        }
        break;
       case 5:
        EntoStatics.lazyInitKeywordSelector(HandleFailureInMethodSel, C.getASTContext(), 
            $("handleFailureInMethod"), $("object"), $("file"), 
            $("lineNumber"), $("description"), null);
        if (Sel.$noteq(/*NO_COPY*/HandleFailureInMethodSel)) {
          return;
        }
        break;
      }
      
      // If we got here, it's one of the messages we care about.
      $c$.clean(C.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), C.getPredecessor()));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NoReturnFunctionChecker::~NoReturnFunctionChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp", line = 30,
   FQN="(anonymous namespace)::NoReturnFunctionChecker::~NoReturnFunctionChecker", NM="_ZN12_GLOBAL__N_123NoReturnFunctionCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp -nm=_ZN12_GLOBAL__N_123NoReturnFunctionCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NoReturnFunctionChecker::NoReturnFunctionChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp", line = 30,
   FQN="(anonymous namespace)::NoReturnFunctionChecker::NoReturnFunctionChecker", NM="_ZN12_GLOBAL__N_123NoReturnFunctionCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp -nm=_ZN12_GLOBAL__N_123NoReturnFunctionCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ NoReturnFunctionChecker() {
    // : Checker<PostCall, PostObjCMessage>(), HandleFailureInFunctionSel(), HandleFailureInMethodSel() 
    //START JInit
    super();
    this.HandleFailureInFunctionSel = new Selector();
    this.HandleFailureInMethodSel = new Selector();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new PostCall(),
    new PostObjCMessage()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "HandleFailureInFunctionSel=" + HandleFailureInFunctionSel // NOI18N
              + ", HandleFailureInMethodSel=" + HandleFailureInMethodSel // NOI18N
              + super.toString(); // NOI18N
  }
}
