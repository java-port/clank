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
import static org.clank.support.Unsigned.*;
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
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;
import org.clang.ast.aliases.CanProxyType;
import static org.clang.staticanalyzer.checkers.impl.CallAndMessageCheckerStatics.*;
import org.clang.staticanalyzer.checkers.impl.CallAndMessageCheckerStatics.ChecksFilter;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 39,
 FQN="(anonymous namespace)::CallAndMessageChecker", NM="_ZN12_GLOBAL__N_121CallAndMessageCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZN12_GLOBAL__N_121CallAndMessageCheckerE")
//</editor-fold>
public class CallAndMessageChecker extends /*public*/ Checker/*<PreStmt<CallExpr>, PreStmt<CXXDeleteExpr>, PreObjCMessage, ObjCMessageNil, PreCall>*/ 
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PreObjCMessageChecker, org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.ObjCMessageNilChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT_call_null;
  private /*mutable */std.unique_ptr<BugType> BT_call_undef;
  private /*mutable */std.unique_ptr<BugType> BT_cxx_call_null;
  private /*mutable */std.unique_ptr<BugType> BT_cxx_call_undef;
  private /*mutable */std.unique_ptr<BugType> BT_call_arg;
  private /*mutable */std.unique_ptr<BugType> BT_cxx_delete_undef;
  private /*mutable */std.unique_ptr<BugType> BT_msg_undef;
  private /*mutable */std.unique_ptr<BugType> BT_objc_prop_undef;
  private /*mutable */std.unique_ptr<BugType> BT_objc_subscript_undef;
  private /*mutable */std.unique_ptr<BugType> BT_msg_arg;
  private /*mutable */std.unique_ptr<BugType> BT_msg_ret;
  private /*mutable */std.unique_ptr<BugType> BT_call_few_args;
/*public:*/
  public ChecksFilter Filter;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 305,
   FQN="(anonymous namespace)::CallAndMessageChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StNonNull = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StNull = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ Expr /*P*/ Callee = CE.getCallee$Const().IgnoreParens$Const();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      SVal L = State.$arrow().getSVal(Callee, LCtx);
      if (L.isUndef$SVal()) {
        if (!BT_call_undef.$bool()) {
          BT_call_undef.reset(new BuiltinBug(this, $("Called function pointer is an uninitialized pointer value")));
        }
        emitBadCall(BT_call_undef.get(), C, Callee);
        return;
      }
      
      StNonNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      StNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();      
//      $c$.clean(std.tie(StNonNull, StNull).$assign($c$.track($assume)));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(State.$arrow().assume(L.castAs(DefinedOrUnknownSVal.class)));
      StNonNull.$assign($assume.first);
      StNull.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();      
      $c$.clean();
      
      if (StNull.$bool() && !StNonNull.$bool()) {
        if (!BT_call_null.$bool()) {
          BT_call_null.reset(new BuiltinBug(this, $("Called function pointer is null (null dereference)")));
        }
        emitBadCall(BT_call_null.get(), C, Callee);
        return;
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StNonNull))));
    } finally {
      if (StNull != null) { StNull.$destroy(); }
      if (StNonNull != null) { StNonNull.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 335,
   FQN="(anonymous namespace)::CallAndMessageChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker12checkPreStmtEPKN5clang13CXXDeleteExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker12checkPreStmtEPKN5clang13CXXDeleteExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CXXDeleteExpr /*P*/ DE, 
              final CheckerContext /*&*/ C) /*const*/ {
    
    SVal Arg = C.getSVal(DE.getArgument$Const());
    if (Arg.isUndef$SVal()) {
      unique_ptr<BugReport> R = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        StringRef Desc/*J*/= new StringRef();
        ExplodedNode /*P*/ N = C.generateErrorNode();
        if (!(N != null)) {
          return;
        }
        if (!BT_cxx_delete_undef.$bool()) {
          BT_cxx_delete_undef.reset(new BuiltinBug(this, $("Uninitialized argument value")));
        }
        if (DE.isArrayFormAsWritten()) {
          Desc.$assignMove(/*STRINGREF_STR*/"Argument to 'delete[]' is uninitialized");
        } else {
          Desc.$assignMove(/*STRINGREF_STR*/"Argument to 'delete' is uninitialized");
        }
        BugType /*P*/ BT = BT_cxx_delete_undef.get();
        R = llvm.make_unique(new BugReport($Deref(BT), Desc, N));
        NsBugreporter.trackNullOrUndefValue(N, DE, R.$star());
        C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        return;
      } finally {
        if (R != null) { R.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 442,
   FQN="(anonymous namespace)::CallAndMessageChecker::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ msg, 
                     final CheckerContext /*&*/ C) /*const*/ {
    SVal recVal = msg.getReceiverSVal();
    if (recVal.isUndef$SVal()) {
      {
        ExplodedNode /*P*/ N = C.generateErrorNode();
        if ((N != null)) {
          unique_ptr<BugReport> R = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            BugType /*P*/ BT = null;
            switch (msg.getMessageKind()) {
             case OCM_Message:
              if (!BT_msg_undef.$bool()) {
                BT_msg_undef.reset(new BuiltinBug(this, 
                        $("Receiver in message expression is an uninitialized value")));
              }
              BT = BT_msg_undef.get();
              break;
             case OCM_PropertyAccess:
              if (!BT_objc_prop_undef.$bool()) {
                BT_objc_prop_undef.reset(new BuiltinBug(this, $("Property access on an uninitialized object pointer")));
              }
              BT = BT_objc_prop_undef.get();
              break;
             case OCM_Subscript:
              if (!BT_objc_subscript_undef.$bool()) {
                BT_objc_subscript_undef.reset(new BuiltinBug(this, $("Subscript access on an uninitialized object pointer")));
              }
              BT = BT_objc_subscript_undef.get();
              break;
            }
            assert ((BT != null)) : "Unknown message kind.";
            
            R = llvm.make_unique(new BugReport($Deref(BT), BT.getName(), N));
            /*const*/ ObjCMessageExpr /*P*/ ME = msg.getOriginExpr();
            R.$arrow().addRange(ME.getReceiverRange());
            {
              
              // FIXME: getTrackNullOrUndefValueVisitor can't handle "super" yet.
              /*const*/ Expr /*P*/ ReceiverE = ME.getInstanceReceiver$Const();
              if ((ReceiverE != null)) {
                NsBugreporter.trackNullOrUndefValue(N, ReceiverE, R.$star());
              }
            }
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
          } finally {
            if (R != null) { R.$destroy(); }
            $c$.$destroy();
          }
        }
      }
      return;
    }
  }

  
  /// Fill in the return value that results from messaging nil based on the
  /// return type and architecture and diagnose if the return value will be
  /// garbage.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::checkObjCMessageNil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 484,
   FQN="(anonymous namespace)::CallAndMessageChecker::checkObjCMessageNil", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker19checkObjCMessageNilERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker19checkObjCMessageNilERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkObjCMessageNil(final /*const*/ ObjCMethodCall /*&*/ msg, 
                     final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      HandleNilReceiver(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), msg); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::checkPreCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 360,
   FQN="(anonymous namespace)::CallAndMessageChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      {
        
        // If this is a call to a C++ method, check if the callee is null or
        // undefined.
        /*const*/ CXXInstanceCall /*P*/ CC = dyn_cast_CXXInstanceCall($AddrOf(Call));
        if ((CC != null)) {
          IntrusiveRefCntPtr</*const*/ ProgramState> StNonNull = null;
          IntrusiveRefCntPtr</*const*/ ProgramState> StNull = null;
          try {
            SVal V = CC.getCXXThisVal();
            if (V.isUndef$SVal()) {
              if (!BT_cxx_call_undef.$bool()) {
                BT_cxx_call_undef.reset(new BuiltinBug(this, $("Called C++ object pointer is uninitialized")));
              }
              emitBadCall(BT_cxx_call_undef.get(), C, CC.getCXXThisExpr());
              return;
            }
            
            StNonNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            StNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//            $c$.clean(std.tie(StNonNull, StNull).$assign(
//                $c$.track(State.$arrow().assume(V.castAs(DefinedOrUnknownSVal.class)))
//            ));
            // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
            std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                    $c$.track(State.$arrow().assume(V.castAs(DefinedOrUnknownSVal.class)));
            StNonNull.$assign($assume.first);
            StNull.$assign($assume.second);
            assert !$assume.first.$bool();
            assert !$assume.second.$bool();
            $c$.clean();

            if (StNull.$bool() && !StNonNull.$bool()) {
              if (!BT_cxx_call_null.$bool()) {
                BT_cxx_call_null.reset(new BuiltinBug(this, $("Called C++ object pointer is null")));
              }
              emitBadCall(BT_cxx_call_null.get(), C, CC.getCXXThisExpr());
              return;
            }
            
            $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StNonNull))));
          } finally {
            if (StNull != null) { StNull.$destroy(); }
            if (StNonNull != null) { StNonNull.$destroy(); }
          }
        }
      }
      
      /*const*/ Decl /*P*/ D = Call.getDecl();
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
      if ((FD != null)) {
        // If we have a declaration, we can make sure we pass enough parameters to
        // the function.
        /*uint*/int Params = FD.getNumParams();
        if ($less_uint(Call.getNumArgs(), Params)) {
          raw_svector_ostream os = null;
          try {
            ExplodedNode /*P*/ N = C.generateErrorNode();
            if (!(N != null)) {
              return;
            }
            
            LazyInit_BT($("Function call with too few arguments"), BT_call_few_args);
            
            SmallString/*<512>*/ Str/*J*/= new SmallString/*<512>*/(512);
            os/*J*/= new raw_svector_ostream(Str);
            os.$out(/*KEEP_STR*/"Function taking ").$out_uint(Params).$out(/*KEEP_STR*/" argument").$out(
                (Params == 1 ? $EMPTY : $s)
            ).$out(/*KEEP_STR*/" is called with less (").$out_uint(
                Call.getNumArgs()
            ).$out(/*KEEP_STR*/$RPAREN);
            
            C.emitReport($c$.track(llvm.make_unique(new BugReport(BT_call_few_args.$star(), os.str(), N)))); $c$.clean();
          } finally {
            if (os != null) { os.$destroy(); }
          }
        }
      }
      
      // Don't check for uninitialized field values in arguments if the
      // caller has a body that is available and we have the chance to inline it.
      // This is a hack, but is a reasonable compromise betweens sometimes warning
      // and sometimes not depending on if we decide to inline a function.
      /*const*/boolean checkUninitFields = !(C.getAnalysisManager().shouldInlineCall() && ((D != null) && (D.getBody() != null)));
      
      std.unique_ptr<BugType> /*P*/ BT;
      if (isa_ObjCMethodCall(Call)) {
        BT = $AddrOf(BT_msg_arg);
      } else {
        BT = $AddrOf(BT_call_arg);
      }
      
      for (/*uint*/int i = 0, e = Call.getNumArgs(); i != e; ++i) {
        /*const*/ ParmVarDecl /*P*/ ParamDecl = null;
        if ((FD != null) && $less_uint(i, FD.getNumParams())) {
          ParamDecl = FD.getParamDecl$Const(i);
        }
        if (PreVisitProcessArg(C, Call.getArgSVal(i), Call.getArgSourceRange(i), 
            Call.getArgExpr(i), /*IsFirstArgument=*/ i == 0, 
            checkUninitFields, Call, $Deref(BT), ParamDecl)) {
          return;
        }
      }
      
      // If we make it here, record our assumptions about the callee.
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::PreVisitProcessArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 187,
   FQN="(anonymous namespace)::CallAndMessageChecker::PreVisitProcessArg", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclE")
  //</editor-fold>
  private boolean PreVisitProcessArg(final CheckerContext /*&*/ C, 
                    SVal V, 
                    SourceRange ArgRange, 
                    /*const*/ Expr /*P*/ ArgEx, 
                    boolean IsFirstArgument, 
                    boolean CheckUninitFields, 
                    final /*const*/ CallEvent /*&*/ Call, 
                    final std.unique_ptr<BugType> /*&*/ BT, 
                    /*const*/ ParmVarDecl /*P*/ ParamDecl) /*const*/ {
    /*const*/char$ptr/*char P*/ BD = $("Uninitialized argument value");
    if (uninitRefOrPointer(C, V, new SourceRange(ArgRange), ArgEx, BT, ParamDecl, BD)) {
      return true;
    }
    if (V.isUndef$SVal()) {
      {
        ExplodedNode /*P*/ N = C.generateErrorNode();
        if ((N != null)) {
          unique_ptr<BugReport> R = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            LazyInit_BT(BD, BT);
            
            // Generate a report for this bug.
            StringRef Desc = CallAndMessageCheckerStatics.describeUninitializedArgumentInCall(Call, IsFirstArgument);
            R = llvm.make_unique(new BugReport(BT.$star(), Desc, N));
            R.$arrow().addRange(new SourceRange(ArgRange));
            if ((ArgEx != null)) {
              NsBugreporter.trackNullOrUndefValue(N, ArgEx, R.$star());
            }
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
          } finally {
            if (R != null) { R.$destroy(); }
            $c$.$destroy();
          }
        }
      }
      return true;
    }
    if (!CheckUninitFields) {
      return false;
    }
    {
      
      Optional<NsNonloc.LazyCompoundVal> LV = V.getAs(NsNonloc.LazyCompoundVal.class);
      if (LV.$bool()) {
        PreVisitProcessArg$$.FindUninitializedField F = null;
        try {
          
          ;
          
          /*const*/ LazyCompoundValData /*P*/ D = LV.$arrow().getCVData();
          F/*J*/= new PreVisitProcessArg$$.FindUninitializedField(C.getState().$arrow().getStateManager().getStoreManager(), 
              C.getSValBuilder().getRegionManager(), 
              D.getStore());
          if (F.Find(D.getRegion())) {
            {
              ExplodedNode /*P*/ N = C.generateErrorNode();
              if ((N != null)) {
                raw_svector_ostream os = null;
                unique_ptr<BugReport> R = null;
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  LazyInit_BT(BD, BT);
                  SmallString/*<512>*/ Str/*J*/= new SmallString/*<512>*/(512);
                  os/*J*/= new raw_svector_ostream(Str);
                  os.$out(/*KEEP_STR*/"Passed-by-value struct argument contains uninitialized data");
                  if (F.FieldChain.size() == 1) {
                    $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/" (e.g., field: '"), $Deref(F.FieldChain.$at(0))).$out(/*KEEP_STR*/"')");
                  } else {
                    os.$out(/*KEEP_STR*/" (e.g., via the field chain: '");
                    boolean first = true;
                    for (type$ptr</*const*/ FieldDecl /*P*/ /*P*/> DI = $tryClone(F.FieldChain.begin()), /*P*/ DE = $tryClone(F.FieldChain.end()); $noteq_ptr(DI, DE); DI.$preInc()) {
                      if (first) {
                        first = false;
                      } else {
                        os.$out_char($$DOT);
                      }
                      $out_raw_ostream_NamedDecl$C(os, $Deref(DI.$star()));
                    }
                    os.$out(/*KEEP_STR*/"')");
                  }
                  
                  // Generate a report for this bug.
                  R = llvm.make_unique(new BugReport(BT.$star(), os.str(), N));
                  R.$arrow().addRange(new SourceRange(ArgRange));
                  
                  // FIXME: enhance track back for uninitialized value for arbitrary
                  // memregions
                  C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
                } finally {
                  if (R != null) { R.$destroy(); }
                  if (os != null) { os.$destroy(); }
                  $c$.$destroy();
                }
              }
            }
            return true;
          }
        } finally {
          if (F != null) { F.$destroy(); }
        }
      }
    }
    
    return false;
  }
  private static final class PreVisitProcessArg$$ {
    static //<editor-fold defaultstate="collapsed" desc="FindUninitializedField">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 224,
     FQN="FindUninitializedField", NM="_ZZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclEE22FindUninitializedField",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclEE22FindUninitializedField")
    //</editor-fold>
     class FindUninitializedField implements Destructors.ClassWithDestructor {
    /*public:*/
      public SmallVector</*const*/ FieldDecl /*P*/ > FieldChain;
    /*private:*/
      private final StoreManager /*&*/ StoreMgr;
      private final MemRegionManager /*&*/ MrMgr;
      private /*const*/Object/*void P*/ store;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::PreVisitProcessArg(CheckerContext & , SVal, SourceRange, const Expr * , bool, bool, const CallEvent & , std::unique_ptr<BugType> & , const ParmVarDecl * )::FindUninitializedField::FindUninitializedField">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 232,
       FQN="(anonymous namespace)::CallAndMessageChecker::PreVisitProcessArg(CheckerContext & , SVal, SourceRange, const Expr * , bool, bool, const CallEvent & , std::unique_ptr<BugType> & , const ParmVarDecl * )::FindUninitializedField::FindUninitializedField", NM="_ZZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclEEN22FindUninitializedFieldC1ERNS2_12StoreManagerERNS2_16MemRegionManagerEPKv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclEEN22FindUninitializedFieldC1ERNS2_12StoreManagerERNS2_16MemRegionManagerEPKv")
      //</editor-fold>
      public FindUninitializedField(final StoreManager /*&*/ storeMgr, 
          final MemRegionManager /*&*/ mrMgr, /*const*/Object/*void P*/ s) {
        // : FieldChain(), StoreMgr(storeMgr), MrMgr(mrMgr), store(s) 
        //START JInit
        this.FieldChain = new SmallVector</*const*/ FieldDecl /*P*/ >(10, (/*const*/ FieldDecl /*P*/ )null);
        this./*&*/StoreMgr=/*&*/storeMgr;
        this./*&*/MrMgr=/*&*/mrMgr;
        this.store = s;
        //END JInit
      }
    
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::PreVisitProcessArg(CheckerContext & , SVal, SourceRange, const Expr * , bool, bool, const CallEvent & , std::unique_ptr<BugType> & , const ParmVarDecl * )::FindUninitializedField::Find">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 236,
       FQN="(anonymous namespace)::CallAndMessageChecker::PreVisitProcessArg(CheckerContext & , SVal, SourceRange, const Expr * , bool, bool, const CallEvent & , std::unique_ptr<BugType> & , const ParmVarDecl * )::FindUninitializedField::Find", NM="_ZZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclEEN22FindUninitializedField4FindEPKNS2_16TypedValueRegionE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclEEN22FindUninitializedField4FindEPKNS2_16TypedValueRegionE")
      //</editor-fold>
      public boolean Find(/*const*/ TypedValueRegion /*P*/ R) {
        QualType T = R.getValueType();
        {
          /*const*/ RecordType /*P*/ RT = T.$arrow().getAsStructureType();
          if ((RT != null)) {
            /*const*/ RecordDecl /*P*/ RD = RT.getDecl().getDefinition();
            assert ((RD != null)) : "Referred record has no definition";
            for (/*const*/ FieldDecl /*P*/ I : RD.fields()) {
              /*const*/ FieldRegion /*P*/ FR = MrMgr.getFieldRegion(I, R);
              FieldChain.push_back(I);
              T.$assignMove(I.getType());
              if ((T.$arrow().getAsStructureType() != null)) {
                if (Find(FR)) {
                  return true;
                }
              } else {
                final /*const*/ SVal /*&*/ V = StoreMgr.getBinding(store, new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(FR)));
                if (V.isUndef$SVal()) {
                  return true;
                }
              }
              FieldChain.pop_back();
            }
          }
        }
        
        return false;
      }
    
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::PreVisitProcessArg(CheckerContext & , SVal, SourceRange, const Expr * , bool, bool, const CallEvent & , std::unique_ptr<BugType> & , const ParmVarDecl * )::FindUninitializedField::~FindUninitializedField">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 224,
       FQN="(anonymous namespace)::CallAndMessageChecker::PreVisitProcessArg(CheckerContext & , SVal, SourceRange, const Expr * , bool, bool, const CallEvent & , std::unique_ptr<BugType> & , const ParmVarDecl * )::FindUninitializedField::~FindUninitializedField", NM="_ZZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclEEN22FindUninitializedFieldD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZZNK12_GLOBAL__N_121CallAndMessageChecker18PreVisitProcessArgERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprEbbRKNS2_9CallEventERSt10unique_ptrINS2_7BugTypeESt14default_deleteISE_EEPKNS1_11ParmVarDeclEEN22FindUninitializedFieldD0Ev")
      //</editor-fold>
      public /*inline*/ void $destroy() {
        //START JDestroy
        FieldChain.$destroy();
        //END JDestroy
      }
    
      
      @Override public String toString() {
        return "" + "FieldChain=" + "[SmallVector$FieldDecl]" // NOI18N
                  + ", StoreMgr=" + "[StoreManager]" // NOI18N
                  + ", MrMgr=" + "[MemRegionManager]" // NOI18N
                  + ", store=" + NativeTrace.getIdentityStr(store); // NOI18N
      }
    };
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::emitBadCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 98,
   FQN="(anonymous namespace)::CallAndMessageChecker::emitBadCall", NM="_ZN12_GLOBAL__N_121CallAndMessageChecker11emitBadCallEPN5clang4ento7BugTypeERNS2_14CheckerContextEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZN12_GLOBAL__N_121CallAndMessageChecker11emitBadCallEPN5clang4ento7BugTypeERNS2_14CheckerContextEPKNS1_4ExprE")
  //</editor-fold>
  private static void emitBadCall(BugType /*P*/ BT, final CheckerContext /*&*/ C, 
             /*const*/ Expr /*P*/ BadE) {
    unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if (!(N != null)) {
        return;
      }
      
      R = llvm.make_unique(new BugReport($Deref(BT), BT.getName(), N));
      if ((BadE != null)) {
        R.$arrow().addRange(BadE.getSourceRange());
        if (BadE.isGLValue()) {
          BadE = NsBugreporter.getDerefExpr(BadE);
        }
        NsBugreporter.trackNullOrUndefValue(N, BadE, R.$star());
      }
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::emitNilReceiverBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 489,
   FQN="(anonymous namespace)::CallAndMessageChecker::emitNilReceiverBug", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker18emitNilReceiverBugERN5clang4ento14CheckerContextERKNS2_14ObjCMethodCallEPNS2_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker18emitNilReceiverBugERN5clang4ento14CheckerContextERKNS2_14ObjCMethodCallEPNS2_12ExplodedNodeE")
  //</editor-fold>
  private void emitNilReceiverBug(final CheckerContext /*&*/ C, 
                    final /*const*/ ObjCMethodCall /*&*/ msg, 
                    ExplodedNode /*P*/ N) /*const*/ {
    raw_svector_ostream os = null;
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!BT_msg_ret.$bool()) {
        BT_msg_ret.reset(new BuiltinBug(this, $("Receiver in message expression is 'nil'")));
      }
      
      /*const*/ ObjCMessageExpr /*P*/ ME = msg.getOriginExpr();
      
      QualType ResTy = msg.getResultType();
      
      SmallString/*<200>*/ buf/*J*/= new SmallString/*<200>*/(200);
      os/*J*/= new raw_svector_ostream(buf);
      os.$out(/*KEEP_STR*/"The receiver of message '");
      ME.getSelector().print(os);
      os.$out(/*KEEP_STR*/"' is nil");
      if (ResTy.$arrow().isReferenceType()) {
        os.$out(/*KEEP_STR*/", which results in forming a null reference");
      } else {
        os.$out(/*KEEP_STR*/" and returns a value of type '");
        msg.getResultType().print(os, new PrintingPolicy(C.getLangOpts()));
        os.$out(/*KEEP_STR*/"' that will be garbage");
      }
      
      report = llvm.make_unique(new BugReport(BT_msg_ret.$star(), os.str(), N));
      report.$arrow().addRange(ME.getReceiverRange());
      {
        // FIXME: This won't track "self" in messages to super.
        /*const*/ Expr /*P*/ receiver = ME.getInstanceReceiver$Const();
        if ((receiver != null)) {
          NsBugreporter.trackNullOrUndefValue(N, receiver, report.$star());
        }
      }
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
    } finally {
      if (report != null) { report.$destroy(); }
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::HandleNilReceiver">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Tag is context dependent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 529,
   FQN="(anonymous namespace)::CallAndMessageChecker::HandleNilReceiver", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker17HandleNilReceiverERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERKNS2_14ObjCMethodCallE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker17HandleNilReceiverERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERKNS2_14ObjCMethodCallE")
  //</editor-fold>
  private void HandleNilReceiver(final CheckerContext /*&*/ C, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   final /*const*/ ObjCMethodCall /*&*/ Msg) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final ASTContext /*&*/ Ctx = C.getASTContext();
      // JAVA: need to use accessor
      final/*static*/ CheckerProgramPointTag Tag = HandleNilReceiver$$.Tag();
      
      // Check the return type of the message expression.  A message to nil will
      // return different values depending on the return type and the architecture.
      QualType RetTy = Msg.getResultType();
      CanQual<Type> CanRetTy = Ctx.getCanonicalType(/*NO_COPY*/RetTy);
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      if (((CanProxyType)CanRetTy.$arrow(Type.class)).$arrow().isStructureOrClassType()) {
        // Structure returns are safe since the compiler zeroes them out.
        SVal V = new SVal(JD$Move.INSTANCE, C.getSValBuilder().makeZeroVal(new QualType(RetTy)));
        $c$.clean(C.addTransition($c$.track(state.$arrow().BindExpr(Msg.getOriginExpr(), LCtx, new SVal(V))), $AddrOf(Tag)));
        return;
      }
      
      // Other cases: check if sizeof(return type) > sizeof(void*)
      if ($noteq_CanQual$T_CanQual$U(/*NO_COPY*/CanRetTy, /*NO_COPY*/Ctx.VoidTy) && C.getLocationContext().getParentMap().
          isConsumedExpr_Expr$C$P(Msg.getOriginExpr())) {
        // Compute: sizeof(void *) and sizeof(return type)
        /*const*/long/*uint64_t*/ voidPtrSize = Ctx.getTypeSize(Ctx.VoidPtrTy.$QualType());
        /*const*/long/*uint64_t*/ returnTypeSize = Ctx.getTypeSize(CanRetTy.$QualType());
        if (CanRetTy.getTypePtr().isReferenceType()
           || ($less_ulong(voidPtrSize, returnTypeSize)
           && !(CallAndMessageCheckerStatics.supportsNilWithFloatRet(Ctx.getTargetInfo().getTriple())
           && ($eq_CanQual$T_CanQual$U(/*NO_COPY*/Ctx.FloatTy, /*NO_COPY*/CanRetTy)
           || $eq_CanQual$T_CanQual$U(/*NO_COPY*/Ctx.DoubleTy, /*NO_COPY*/CanRetTy)
           || $eq_CanQual$T_CanQual$U(/*NO_COPY*/Ctx.LongDoubleTy, /*NO_COPY*/CanRetTy)
           || $eq_CanQual$T_CanQual$U(/*NO_COPY*/Ctx.LongLongTy, /*NO_COPY*/CanRetTy)
           || $eq_CanQual$T_CanQual$U(/*NO_COPY*/Ctx.UnsignedLongLongTy, /*NO_COPY*/CanRetTy))))) {
          {
            ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), $AddrOf(Tag)));
            if ((N != null)) {
              emitNilReceiverBug(C, Msg, N);
            }
          }
          return;
        }
        
        // Handle the safe cases where the return value is 0 if the
        // receiver is nil.
        //
        // FIXME: For now take the conservative approach that we only
        // return null values if we *know* that the receiver is nil.
        // This is because we can have surprises like:
        //
        //   ... = [[NSScreens screens] objectAtIndex:0];
        //
        // What can happen is that [... screens] could return nil, but
        // it most likely isn't nil.  We should assume the semantics
        // of this case unless we have *a lot* more knowledge.
        //
        SVal V = new SVal(JD$Move.INSTANCE, C.getSValBuilder().makeZeroVal(new QualType(RetTy)));
        $c$.clean(C.addTransition($c$.track(state.$arrow().BindExpr(Msg.getOriginExpr(), LCtx, new SVal(V))), $AddrOf(Tag)));
        return;
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      $c$.$destroy();
    }
  }
  // MANUAL: moved below in extra members
//  private static final class HandleNilReceiver$$ {
//    static final/*static*/ CheckerProgramPointTag Tag/*J*/= new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NilReceiver"));
//  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::LazyInit_BT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 87,
   FQN="(anonymous namespace)::CallAndMessageChecker::LazyInit_BT", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker11LazyInit_BTEPKcRSt10unique_ptrIN5clang4ento7BugTypeESt14default_deleteIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker11LazyInit_BTEPKcRSt10unique_ptrIN5clang4ento7BugTypeESt14default_deleteIS6_EE")
  //</editor-fold>
  private void LazyInit_BT(/*const*/char$ptr/*char P*/ desc, final std.unique_ptr<BugType> /*&*/ BT) /*const*/ {
    if (!BT.$bool()) {
      BT.reset(new BuiltinBug(this, desc));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::uninitRefOrPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 139,
   FQN="(anonymous namespace)::CallAndMessageChecker::uninitRefOrPointer", NM="_ZNK12_GLOBAL__N_121CallAndMessageChecker18uninitRefOrPointerERN5clang4ento14CheckerContextERKNS2_4SValENS1_11SourceRangeEPKNS1_4ExprERSt10unique_ptrINS2_7BugTypeESt14default_deleteISD_EEPKNS1_11ParmVarDeclEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZNK12_GLOBAL__N_121CallAndMessageChecker18uninitRefOrPointerERN5clang4ento14CheckerContextERKNS2_4SValENS1_11SourceRangeEPKNS1_4ExprERSt10unique_ptrINS2_7BugTypeESt14default_deleteISD_EEPKNS1_11ParmVarDeclEPKc")
  //</editor-fold>
  private boolean uninitRefOrPointer(final CheckerContext /*&*/ C, 
                    final /*const*/ SVal /*&*/ V, 
                    SourceRange ArgRange, 
                    /*const*/ Expr /*P*/ ArgEx, 
                    final std.unique_ptr<BugType> /*&*/ BT, 
                    /*const*/ ParmVarDecl /*P*/ ParamDecl, 
                    /*const*/char$ptr/*char P*/ BD) /*const*/ {
    if (!Filter.Check_CallAndMessageUnInitRefArg.$ConstBoolRef()) {
      return false;
    }
    
    // No parameter declaration available, i.e. variadic function argument.
    if (!(ParamDecl != null)) {
      return false;
    }
    
    // If parameter is declared as pointer to const in function declaration,
    // then check if corresponding argument in function call is
    // pointing to undefined symbol value (uninitialized memory).
    StringRef Message/*J*/= new StringRef();
    if (ParamDecl.getType().$arrow().isPointerType()) {
      Message.$assignMove(/*STRINGREF_STR*/"Function call argument is a pointer to uninitialized value");
    } else if (ParamDecl.getType().$arrow().isReferenceType()) {
      Message.$assignMove(/*STRINGREF_STR*/"Function call argument is an uninitialized value");
    } else {
      return false;
    }
    if (!ParamDecl.getType().$arrow().getPointeeType().isConstQualified()) {
      return false;
    }
    {
      
      /*const*/ MemRegion /*P*/ SValMemRegion = V.getAsRegion();
      if ((SValMemRegion != null)) {
        /*const*/ IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
        try {
          State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
          /*const*/ SVal PSV = State.$arrow().getSVal(SValMemRegion);
          if (PSV.isUndef$SVal()) {
            {
              ExplodedNode /*P*/ N = C.generateErrorNode();
              if ((N != null)) {
                unique_ptr<BugReport> R = null;
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  LazyInit_BT(BD, BT);
                  R = llvm.make_unique(new BugReport(BT.$star(), Message, N));
                  R.$arrow().addRange(new SourceRange(ArgRange));
                  if ((ArgEx != null)) {
                    NsBugreporter.trackNullOrUndefValue(N, ArgEx, R.$star());
                  }
                  C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
                } finally {
                  if (R != null) { R.$destroy(); }
                  $c$.$destroy();
                }
              }
            }
            return true;
          }
        } finally {
          if (State != null) { State.$destroy(); }
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::~CallAndMessageChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 39,
   FQN="(anonymous namespace)::CallAndMessageChecker::~CallAndMessageChecker", NM="_ZN12_GLOBAL__N_121CallAndMessageCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZN12_GLOBAL__N_121CallAndMessageCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_call_few_args.$destroy();
    BT_msg_ret.$destroy();
    BT_msg_arg.$destroy();
    BT_objc_subscript_undef.$destroy();
    BT_objc_prop_undef.$destroy();
    BT_msg_undef.$destroy();
    BT_cxx_delete_undef.$destroy();
    BT_call_arg.$destroy();
    BT_cxx_call_undef.$destroy();
    BT_cxx_call_null.$destroy();
    BT_call_undef.$destroy();
    BT_call_null.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAndMessageChecker::CallAndMessageChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 39,
   FQN="(anonymous namespace)::CallAndMessageChecker::CallAndMessageChecker", NM="_ZN12_GLOBAL__N_121CallAndMessageCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZN12_GLOBAL__N_121CallAndMessageCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ CallAndMessageChecker() {
    // : Checker<PreStmt<CallExpr>, PreStmt<CXXDeleteExpr>, PreObjCMessage, ObjCMessageNil, PreCall>(), BT_call_null(), BT_call_undef(), BT_cxx_call_null(), BT_cxx_call_undef(), BT_call_arg(), BT_cxx_delete_undef(), BT_msg_undef(), BT_objc_prop_undef(), BT_objc_subscript_undef(), BT_msg_arg(), BT_msg_ret(), BT_call_few_args(), Filter() 
    //START JInit
    super();
    this.BT_call_null = new std.unique_ptr<BugType>();
    this.BT_call_undef = new std.unique_ptr<BugType>();
    this.BT_cxx_call_null = new std.unique_ptr<BugType>();
    this.BT_cxx_call_undef = new std.unique_ptr<BugType>();
    this.BT_call_arg = new std.unique_ptr<BugType>();
    this.BT_cxx_delete_undef = new std.unique_ptr<BugType>();
    this.BT_msg_undef = new std.unique_ptr<BugType>();
    this.BT_objc_prop_undef = new std.unique_ptr<BugType>();
    this.BT_objc_subscript_undef = new std.unique_ptr<BugType>();
    this.BT_msg_arg = new std.unique_ptr<BugType>();
    this.BT_msg_ret = new std.unique_ptr<BugType>();
    this.BT_call_few_args = new std.unique_ptr<BugType>();
    this.Filter = new ChecksFilter();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CXXDeleteExpr>(CXXDeleteExpr.class),
    new PreObjCMessage(),
    new ObjCMessageNil(),
    new PreCall()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPreStmt((CallExpr) stmt, C);
    } else if (stmt instanceof CXXDeleteExpr) {
      checkPreStmt((CXXDeleteExpr) stmt, C);
    }
  }
  
  // MANUAL: we need to remove static but keep delay of initialization
  private final class HandleNilReceiver$$ {
    // JAVA: must not be static!
     /*static final*//*static*/ CheckerProgramPointTag $Tag/*J*/;// = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NilReceiver"));
     private final CallAndMessageChecker $this;
     private HandleNilReceiver$$(CallAndMessageChecker owner) {
       this.$this = owner;
     }
     CheckerProgramPointTag Tag() {
       if ($Tag == null) {
         $Tag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NilReceiver"));
       }
       return $Tag;
     }
  }
  private final HandleNilReceiver$$ HandleNilReceiver$$ = new HandleNilReceiver$$(this);
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_call_null=" + BT_call_null // NOI18N
              + ", BT_call_undef=" + BT_call_undef // NOI18N
              + ", BT_cxx_call_null=" + BT_cxx_call_null // NOI18N
              + ", BT_cxx_call_undef=" + BT_cxx_call_undef // NOI18N
              + ", BT_call_arg=" + BT_call_arg // NOI18N
              + ", BT_cxx_delete_undef=" + BT_cxx_delete_undef // NOI18N
              + ", BT_msg_undef=" + BT_msg_undef // NOI18N
              + ", BT_objc_prop_undef=" + BT_objc_prop_undef // NOI18N
              + ", BT_objc_subscript_undef=" + BT_objc_subscript_undef // NOI18N
              + ", BT_msg_arg=" + BT_msg_arg // NOI18N
              + ", BT_msg_ret=" + BT_msg_ret // NOI18N
              + ", BT_call_few_args=" + BT_call_few_args // NOI18N
              + ", Filter=" + Filter // NOI18N
              + super.toString(); // NOI18N
  }
}
