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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.BasicObjCFoundationChecksStatics.*;

/// \class ObjCNonNilReturnValueChecker
/// \brief The checker restricts the return values of APIs known to
/// never (or almost never) return 'nil'.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1170,
 FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker", NM="_ZN12_GLOBAL__N_128ObjCNonNilReturnValueCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonNilReturnValueCheckerE")
//</editor-fold>
public class ObjCNonNilReturnValueChecker extends /*public*/ Checker/*<PostObjCMessage, PostStmt<ObjCArrayLiteral>, PostStmt<ObjCDictionaryLiteral>, PostStmt<ObjCBoxedExpr> >*/ 
        implements org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, Destructors.ClassWithDestructor {
  private /*mutable */boolean Initialized;
  private /*mutable */Selector ObjectAtIndex;
  private /*mutable */Selector ObjectAtIndexedSubscript;
  private /*mutable */Selector NullSelector;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker::ObjCNonNilReturnValueChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1181,
   FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker::ObjCNonNilReturnValueChecker", NM="_ZN12_GLOBAL__N_128ObjCNonNilReturnValueCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonNilReturnValueCheckerC1Ev")
  //</editor-fold>
  public ObjCNonNilReturnValueChecker() {
    // : Checker<PostObjCMessage, PostStmt<ObjCArrayLiteral>, PostStmt<ObjCDictionaryLiteral>, PostStmt<ObjCBoxedExpr> >(), Initialized(false), ObjectAtIndex(), ObjectAtIndexedSubscript(), NullSelector() 
    //START JInit
    super();
    this.Initialized = false;
    this.ObjectAtIndex = new Selector();
    this.ObjectAtIndexedSubscript = new Selector();
    this.NullSelector = new Selector();
    //END JInit
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker::assumeExprIsNonNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1204,
   FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker::assumeExprIsNonNull", NM="_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker19assumeExprIsNonNullEPKN5clang4ExprEN4llvm18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEERNS7_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker19assumeExprIsNonNullEPKN5clang4ExprEN4llvm18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEERNS7_14CheckerContextE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> assumeExprIsNonNull(/*const*/ Expr /*P*/ NonNullExpr, 
                     IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                     final CheckerContext /*&*/ C) /*const*/ {
    SVal Val = State.$arrow().getSVal(NonNullExpr, C.getLocationContext());
    {
      Optional<DefinedOrUnknownSVal> DV = Val.getAs(DefinedOrUnknownSVal.class);
      if (DV.$bool()) {
        return State.$arrow().assume(new DefinedOrUnknownSVal(DV.$star()), true);
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker::assumeExprIsNonNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1186,
   FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker::assumeExprIsNonNull", NM="_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker19assumeExprIsNonNullEPKN5clang4ExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker19assumeExprIsNonNullEPKN5clang4ExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void assumeExprIsNonNull(/*const*/ Expr /*P*/ E, final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(C.addTransition($c$.track(assumeExprIsNonNull(E, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), C))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1190,
   FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker13checkPostStmtEPKN5clang16ObjCArrayLiteralERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker13checkPostStmtEPKN5clang16ObjCArrayLiteralERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCArrayLiteral /*P*/ E, final CheckerContext /*&*/ C) /*const*/ {
    assumeExprIsNonNull(E, C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1193,
   FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker13checkPostStmtEPKN5clang21ObjCDictionaryLiteralERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker13checkPostStmtEPKN5clang21ObjCDictionaryLiteralERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCDictionaryLiteral /*P*/ E, final CheckerContext /*&*/ C) /*const*/ {
    assumeExprIsNonNull(E, C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1196,
   FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker13checkPostStmtEPKN5clang13ObjCBoxedExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker13checkPostStmtEPKN5clang13ObjCBoxedExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCBoxedExpr /*P*/ E, final CheckerContext /*&*/ C) /*const*/ {
    assumeExprIsNonNull(E, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1214,
   FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_128ObjCNonNilReturnValueChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, 
                      final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (!Initialized) {
        final ASTContext /*&*/ Ctx = C.getASTContext();
        ObjectAtIndex.$assignMove(GetUnarySelector(new StringRef(/*KEEP_STR*/"objectAtIndex"), Ctx));
        ObjectAtIndexedSubscript.$assignMove(GetUnarySelector(new StringRef(/*KEEP_STR*/"objectAtIndexedSubscript"), Ctx));
        NullSelector.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"null"), Ctx));
      }
      {
        
        // Check the receiver type.
        /*const*/ ObjCInterfaceDecl /*P*/ Interface = M.getReceiverInterface();
        if ((Interface != null)) {
          
          // Assume that object returned from '[self init]' or '[super init]' is not
          // 'nil' if we are processing an inlined function/method.
          //
          // A defensive callee will (and should) check if the object returned by
          // '[super init]' is 'nil' before doing it's own initialization. However,
          // since 'nil' is rarely returned in practice, we should not warn when the
          // caller to the defensive constructor uses the object in contexts where
          // 'nil' is not accepted.
          if (!C.inTopFrame() && (M.getDecl() != null)
             && M.getDecl().getMethodFamily() == ObjCMethodFamily.OMF_init
             && M.isReceiverSelfOrSuper()) {
            $c$.clean(State.$assign($c$.track(assumeExprIsNonNull(M.getOriginExpr(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C))));
          }
          
          FoundationClass Cl = BasicObjCFoundationChecksStatics.findKnownClass(Interface);
          
          // Objects returned from
          // [NSArray|NSOrderedSet]::[ObjectAtIndex|ObjectAtIndexedSubscript]
          // are never 'nil'.
          if (Cl == FoundationClass.FC_NSArray || Cl == FoundationClass.FC_NSOrderedSet) {
            Selector Sel = M.getSelector();
            if (Sel.$eq(/*NO_COPY*/ObjectAtIndex) || Sel.$eq(/*NO_COPY*/ObjectAtIndexedSubscript)) {
              // Go ahead and assume the value is non-nil.
              $c$.clean(State.$assign($c$.track(assumeExprIsNonNull(M.getOriginExpr(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C))));
            }
          }
          
          // Objects returned from [NSNull null] are not nil.
          if (Cl == FoundationClass.FC_NSNull) {
            if (M.getSelector().$eq(/*NO_COPY*/NullSelector)) {
              // Go ahead and assume the value is non-nil.
              $c$.clean(State.$assign($c$.track(assumeExprIsNonNull(M.getOriginExpr(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C))));
            }
          }
        }
      }
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonNilReturnValueChecker::~ObjCNonNilReturnValueChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1170,
   FQN="(anonymous namespace)::ObjCNonNilReturnValueChecker::~ObjCNonNilReturnValueChecker", NM="_ZN12_GLOBAL__N_128ObjCNonNilReturnValueCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonNilReturnValueCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ObjCArrayLiteral) {
      checkPostStmt((ObjCArrayLiteral) stmt, C);
    } else if (stmt instanceof ObjCDictionaryLiteral) {
      checkPostStmt((ObjCDictionaryLiteral) stmt, C);
    } else if (stmt instanceof ObjCBoxedExpr) {
      checkPostStmt((ObjCBoxedExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new PostObjCMessage(),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCArrayLiteral>(ObjCArrayLiteral.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCDictionaryLiteral>(ObjCDictionaryLiteral.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCBoxedExpr>(ObjCBoxedExpr.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Initialized=" + Initialized // NOI18N
              + ", ObjectAtIndex=" + ObjectAtIndex // NOI18N
              + ", ObjectAtIndexedSubscript=" + ObjectAtIndexedSubscript // NOI18N
              + ", NullSelector=" + NullSelector // NOI18N
              + super.toString(); // NOI18N
  }
}
