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
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinFunctionChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp", line = 25,
 FQN="(anonymous namespace)::BuiltinFunctionChecker", NM="_ZN12_GLOBAL__N_122BuiltinFunctionCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp -nm=_ZN12_GLOBAL__N_122BuiltinFunctionCheckerE")
//</editor-fold>
public class BuiltinFunctionChecker extends /*public*/ Checker/*T<eval.Call>*/
        implements org.clang.staticanalyzer.java.EvalCallChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinFunctionChecker::evalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp", line = 32,
   FQN="(anonymous namespace)::BuiltinFunctionChecker::evalCall", NM="_ZNK12_GLOBAL__N_122BuiltinFunctionChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp -nm=_ZNK12_GLOBAL__N_122BuiltinFunctionChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public boolean evalCall(/*const*/ CallExpr /*P*/ CE, 
          final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
     state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
     /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
     /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
     if (!(FD != null)) {
       return false;
     }
     switch (Builtin.ID.valueOf(FD.getBuiltinID())) {
      default:
       return false;
      case BI__builtin_unpredictable:
      case BI__builtin_expect:
      case BI__builtin_assume_aligned:
      case BI__builtin_addressof:
       {
         JavaCleaner $c$ = $createJavaCleaner();
         try {
           // For __builtin_unpredictable, __builtin_expect, and
           // __builtin_assume_aligned, just return the value of the subexpression.
           // __builtin_addressof is going from a reference to a pointer, but those
           // are represented the same way in the analyzer.
           assert (CE.arg_begin$Const().$noteq(CE.arg_end$Const()));
           SVal X = state.$arrow().getSVal((CE.arg_begin$Const()).$star(), LCtx);
           $c$.clean(C.addTransition($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(X)))));
           return true;
         } finally {
           $c$.$destroy();
         }
       }
      case BI__builtin_alloca:
       {
         JavaCleaner $c$ = $createJavaCleaner();
         try {
           // FIXME: Refactor into StoreManager itself?
           final MemRegionManager /*&*/ RM = C.getStoreManager().getRegionManager();
           /*const*/ AllocaRegion /*P*/ R = RM.getAllocaRegion(CE, C.blockCount(), C.getLocationContext());

           // Set the extent of the region in bytes. This enables us to use the
           // SVal of the argument directly. If we save the extent in bits, we
           // cannot represent values like symbol*8.
           DefinedOrUnknownSVal Size = state.$arrow().getSVal((CE.arg_begin$Const()).$star(), LCtx).castAs(DefinedOrUnknownSVal.class);

           final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
           DefinedOrUnknownSVal Extent = R.getExtent(svalBuilder);
           DefinedOrUnknownSVal extentMatchesSizeArg = $c$.clean(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(Extent), new DefinedOrUnknownSVal(Size)));
           $c$.clean(state.$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(extentMatchesSizeArg), true))));
           assert (state.$bool()) : "The region should not have any previous constraints";

           $c$.clean(C.addTransition($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R))))));
           return true;
         } finally {
           $c$.$destroy();
         }
       }
      case BI__builtin_object_size:
       {
         JavaCleaner $c$ = $createJavaCleaner();
         try {
           // This must be resolvable at compile time, so we defer to the constant
           // evaluator for a value.
           SVal V = new SVal(JD$Move.INSTANCE, new UnknownVal());
           APSInt Result/*J*/= new APSInt();
           if (CE.EvaluateAsInt(Result, C.getASTContext(), Expr.SideEffectsKind.SE_NoSideEffects)) {
             // Make sure the result has the correct type.
             final SValBuilder /*&*/ SVB = C.getSValBuilder();
             final BasicValueFactory /*&*/ BVF = SVB.getBasicValueFactory();
             BVF.getAPSIntType(CE.getType()).apply(Result);
             V.$assignMove(SVB.makeIntVal(Result));
           }

           $c$.clean(C.addTransition($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(V)))));
           return true;
         } finally {
           $c$.$destroy();
         }
       }
     }
    } finally {
     if (state != null) { state.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinFunctionChecker::~BuiltinFunctionChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp", line = 25,
   FQN="(anonymous namespace)::BuiltinFunctionChecker::~BuiltinFunctionChecker", NM="_ZN12_GLOBAL__N_122BuiltinFunctionCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp -nm=_ZN12_GLOBAL__N_122BuiltinFunctionCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinFunctionChecker::BuiltinFunctionChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp", line = 25,
   FQN="(anonymous namespace)::BuiltinFunctionChecker::BuiltinFunctionChecker", NM="_ZN12_GLOBAL__N_122BuiltinFunctionCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp -nm=_ZN12_GLOBAL__N_122BuiltinFunctionCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ BuiltinFunctionChecker() {
    // : Checker<eval::Call>() 
    //START JInit
    super();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new eval.Call()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
