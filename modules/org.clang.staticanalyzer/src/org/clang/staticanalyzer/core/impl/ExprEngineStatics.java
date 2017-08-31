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
package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ExprEngineStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.impl.ExprEngineStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL15TagProviderName;_ZL16ResolveConditionPKN5clang4StmtEPKNS_8CFGBlockE;_ZL16getRightmostLeafPKN5clang4StmtE;_ZL19RecoverCastedSymbolRN5clang4ento19ProgramStateManagerEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_4StmtEPKNS_15LocationContextERNS_10ASTContextE;_ZL21NumRemoveDeadBindings;_ZL22GraphPrintCheckerState;_ZL23GraphPrintSourceManager;_ZL23NumMaxBlockCountReached;_ZL24shouldRemoveDeadBindingsRN5clang4ento15AnalysisManagerENS_7CFGStmtEPKNS0_12ExplodedNodeEPKNS_15LocationContextE;_ZL30NumTimesRetriedWithoutInlining;_ZL32NumMaxBlockCountReachedInInlined; -static-type=ExprEngineStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class ExprEngineStatics {

//<editor-fold defaultstate="collapsed" desc="NumRemoveDeadBindings">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 45,
 FQN="NumRemoveDeadBindings", NM="_ZL21NumRemoveDeadBindings",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL21NumRemoveDeadBindings")
//</editor-fold>
public static Statistic NumRemoveDeadBindings = new Statistic($("ExprEngine"), $("NumRemoveDeadBindings"), $("The # of times RemoveDeadBindings is called"), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="NumMaxBlockCountReached">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 47,
 FQN="NumMaxBlockCountReached", NM="_ZL23NumMaxBlockCountReached",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL23NumMaxBlockCountReached")
//</editor-fold>
public static Statistic NumMaxBlockCountReached = new Statistic($("ExprEngine"), $("NumMaxBlockCountReached"), $("The # of aborted paths due to reaching the maximum block count in a top level function"), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="NumMaxBlockCountReachedInInlined">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 50,
 FQN="NumMaxBlockCountReachedInInlined", NM="_ZL32NumMaxBlockCountReachedInInlined",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL32NumMaxBlockCountReachedInInlined")
//</editor-fold>
public static Statistic NumMaxBlockCountReachedInInlined = new Statistic($("ExprEngine"), $("NumMaxBlockCountReachedInInlined"), $("The # of aborted paths due to reaching the maximum block count in an inlined function"), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="NumTimesRetriedWithoutInlining">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 53,
 FQN="NumTimesRetriedWithoutInlining", NM="_ZL30NumTimesRetriedWithoutInlining",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL30NumTimesRetriedWithoutInlining")
//</editor-fold>
public static Statistic NumTimesRetriedWithoutInlining = new Statistic($("ExprEngine"), $("NumTimesRetriedWithoutInlining"), $("The # of times we re-evaluated a call without inlining"), (/*(void)*/0), false);

//===----------------------------------------------------------------------===//
// Engine construction and deletion.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="TagProviderName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 69,
 FQN="TagProviderName", NM="_ZL15TagProviderName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL15TagProviderName")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ TagProviderName = $("ExprEngine");
//<editor-fold defaultstate="collapsed" desc="shouldRemoveDeadBindings">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 316,
 FQN="shouldRemoveDeadBindings", NM="_ZL24shouldRemoveDeadBindingsRN5clang4ento15AnalysisManagerENS_7CFGStmtEPKNS0_12ExplodedNodeEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL24shouldRemoveDeadBindingsRN5clang4ento15AnalysisManagerENS_7CFGStmtEPKNS0_12ExplodedNodeEPKNS_15LocationContextE")
//</editor-fold>
public static boolean shouldRemoveDeadBindings(final AnalysisManager /*&*/ AMgr, 
                        /*const*/ CFGStmt S, 
                        /*const*/ ExplodedNode /*P*/ Pred, 
                        /*const*/ LocationContext /*P*/ LC) {
  
  // Are we never purging state values?
  if (AMgr.options.AnalysisPurgeOpt == AnalysisPurgeMode.PurgeNone) {
    return false;
  }
  
  // Is this the beginning of a basic block?
  if (Pred.getLocation().getAs(BlockEntrance.class).$bool()) {
    return true;
  }
  
  // Is this on a non-expression?
  if (!isa_Expr(S.getStmt())) {
    return true;
  }
  
  // Run before processing a call.
  if (CallEvent.isCallStmt(S.getStmt())) {
    return true;
  }
  
  // Is this an expression that is consumed by another expression?  If so,
  // postpone cleaning out the state.
  final ParentMap /*&*/ PM = LC.getAnalysisDeclContext().getParentMap();
  return !PM.isConsumedExpr_Expr$C$P(cast_Expr(S.getStmt()));
}


//===----------------------------------------------------------------------===//
// Branch processing.
//===----------------------------------------------------------------------===//

/// RecoverCastedSymbol - A helper function for ProcessBranch that is used
/// to try to recover some path-sensitivity for casts of symbolic
/// integers that promote their values (which are currently not tracked well).
/// This function returns the SVal bound to Condition->IgnoreCasts if all the
//  cast(s) did was sign-extend the original value.
//<editor-fold defaultstate="collapsed" desc="RecoverCastedSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1481,
 FQN="RecoverCastedSymbol", NM="_ZL19RecoverCastedSymbolRN5clang4ento19ProgramStateManagerEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_4StmtEPKNS_15LocationContextERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL19RecoverCastedSymbolRN5clang4ento19ProgramStateManagerEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_4StmtEPKNS_15LocationContextERNS_10ASTContextE")
//</editor-fold>
public static SVal RecoverCastedSymbol(final ProgramStateManager /*&*/ StateMgr, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ Stmt /*P*/ Condition, 
                   /*const*/ LocationContext /*P*/ LCtx, 
                   final ASTContext /*&*/ Ctx) {
  
  /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(Condition);
  if (!(Ex != null)) {
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }
  
  long/*uint64_t*/ bits = $int2ulong(0);
  boolean bitsInit = false;
  {
    
    /*const*/ CastExpr /*P*/ CE;
    while (((/*P*/ CE = dyn_cast_CastExpr(Ex)) != null)) {
      QualType T = CE.getType();
      if (!T.$arrow().isIntegralOrEnumerationType()) {
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
      
      long/*uint64_t*/ newBits = Ctx.getTypeSize(new QualType(T));
      if (!bitsInit || $less_ulong(newBits, bits)) {
        bitsInit = true;
        bits = newBits;
      }
      
      Ex = CE.getSubExpr$Const();
    }
  }
  
  // We reached a non-cast.  Is it a symbolic value?
  QualType T = Ex.getType();
  if (!bitsInit || !T.$arrow().isIntegralOrEnumerationType()
     || $greater_ulong(Ctx.getTypeSize(new QualType(T)), bits)) {
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }
  
  return state.$arrow().getSVal(Ex, LCtx);
}

//<editor-fold defaultstate="collapsed" desc="getRightmostLeaf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1520,
 FQN="getRightmostLeaf", NM="_ZL16getRightmostLeafPKN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL16getRightmostLeafPKN5clang4StmtE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ getRightmostLeaf(/*const*/ Stmt /*P*/ Condition) {
  while ((Condition != null)) {
    /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(Condition);
    if (!(BO != null) || !BO.isLogicalOp()) {
      return Condition;
    }
    Condition = BO.getRHS().IgnoreParens();
  }
  return null;
}


// Returns the condition the branch at the end of 'B' depends on and whose value
// has been evaluated within 'B'.
// In most cases, the terminator condition of 'B' will be evaluated fully in
// the last statement of 'B'; in those cases, the resolved condition is the
// given 'Condition'.
// If the condition of the branch is a logical binary operator tree, the CFG is
// optimized: in that case, we know that the expression formed by all but the
// rightmost leaf of the logical binary operator tree must be true, and thus
// the branch condition is at this point equivalent to the truth value of that
// rightmost leaf; the CFG block thus only evaluates this rightmost leaf
// expression in its final statement. As the full condition in that case was
// not evaluated, and is thus not in the SVal cache, we need to use that leaf
// expression to evaluate the truth value of the condition in the current state
// space.
//<editor-fold defaultstate="collapsed" desc="ResolveCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1546,
 FQN="ResolveCondition", NM="_ZL16ResolveConditionPKN5clang4StmtEPKNS_8CFGBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL16ResolveConditionPKN5clang4StmtEPKNS_8CFGBlockE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ ResolveCondition(/*const*/ Stmt /*P*/ Condition, 
                /*const*/ CFGBlock /*P*/ B) {
  {
    /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(Condition);
    if ((Ex != null)) {
      Condition = Ex.IgnoreParens$Const();
    }
  }
  
  /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(Condition);
  if (!(BO != null) || !BO.isLogicalOp()) {
    return Condition;
  }
  assert (!B.getTerminator$Const().isTemporaryDtorsBranch()) : "Temporary destructor branches handled by processBindTemporary.";
  
  // For logical operations, we still have the case where some branches
  // use the traditional "merge" approach and others sink the branch
  // directly into the basic blocks representing the logical operation.
  // We need to distinguish between those two cases here.
  
  // The invariants are still shifting, but it is possible that the
  // last element in a CFGBlock is not a CFGStmt.  Look for the last
  // CFGStmt as the value of the condition.
  type$ptr</*const*/ CFGElement /*P*/ > I = $tryClone(B.rbegin$Const());
  type$ptr</*const*/ CFGElement /*P*/ > E = $tryClone(B.rend$Const());
  for (; $noteq_ptr(I, E); I.$preInc()) {
    CFGElement Elem = new CFGElement(I.$star());
    Optional<CFGStmt> CS = Elem.getAs(CFGStmt.class);
    if (!CS.$bool()) {
      continue;
    }
    /*const*/ Stmt /*P*/ LastStmt = CS.$arrow().getStmt();
    assert (LastStmt == Condition || LastStmt == getRightmostLeaf(Condition));
    return LastStmt;
  }
  throw new llvm_unreachable("could not resolve condition");
}

//<editor-fold defaultstate="collapsed" desc="GraphPrintCheckerState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2511,
 FQN="GraphPrintCheckerState", NM="_ZL22GraphPrintCheckerState",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL22GraphPrintCheckerState")
//</editor-fold>
public static ExprEngine /*P*/ GraphPrintCheckerState;
//<editor-fold defaultstate="collapsed" desc="GraphPrintSourceManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2512,
 FQN="GraphPrintSourceManager", NM="_ZL23GraphPrintSourceManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZL23GraphPrintSourceManager")
//</editor-fold>
public static SourceManager /*P*/ GraphPrintSourceManager;
} // END OF class ExprEngineStatics
