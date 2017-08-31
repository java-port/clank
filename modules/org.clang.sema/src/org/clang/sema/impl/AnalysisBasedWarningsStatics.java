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
package org.clang.sema.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.analysis.AnalysisDeclContext;
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
;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import static org.clang.analysis.analyses.reachable_code.Reachable_codeGlobals.*;
import org.clang.analysis.*;
import org.clang.analysis.CFGBlock.*;
import org.clang.analysis.analyses.UninitUse;
import org.clang.analysis.analyses.UninitUse.Branch;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.sema.FunctionScopeInfo.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clank.support.CollectionUtils.Equalizer;


//<editor-fold defaultstate="collapsed" desc="static type AnalysisBasedWarningsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL13CreateIfFixitRN5clang4SemaEPKNS_4StmtES4_S4_bRNS_9FixItHintES6_;_ZL13DiagUninitUseRN5clang4SemaEPKNS_7VarDeclERKNS_9UninitUseEb;_ZL16CheckFallThroughRN5clang19AnalysisDeclContextE;_ZL16CheckUnreachableRN5clang4SemaERNS_19AnalysisDeclContextE;_ZL16flushDiagnosticsRN5clang4SemaEPKNS_4sema17FunctionScopeInfoE;_ZL22checkRecursiveFunctionRN5clang4SemaEPKNS_12FunctionDeclEPKNS_4StmtERNS_19AnalysisDeclContextE;_ZL22hasRecursiveCallInPathPKN5clang12FunctionDeclERNS_8CFGBlockE;_ZL23CheckFallThroughForBodyRN5clang4SemaEPKNS_4DeclEPKNS_4StmtEPKNS_9BlockExprERKN12_GLOBAL__N_127CheckFallThroughDiagnosticsERNS_19AnalysisDeclContextE;_ZL24DiagnoseUninitializedUseRN5clang4SemaEPKNS_7VarDeclERKNS_9UninitUseEb;_ZL25diagnoseRepeatedUseOfWeakRN5clang4SemaEPKNS_4sema17FunctionScopeInfoEPKNS_4DeclERKNS_9ParentMapE;_ZL26SuggestInitializationFixitRN5clang4SemaEPKNS_7VarDeclE;_ZL26getFallthroughAttrSpellingRN5clang12PreprocessorENS_14SourceLocationE;_ZL29checkForRecursiveFunctionCallPKN5clang12FunctionDeclEPNS_3CFGE;_ZL31DiagnoseSwitchLabelsFallthroughRN5clang4SemaERNS_19AnalysisDeclContextEb;_ZL8isInLoopRKN5clang10ASTContextERKNS_9ParentMapEPKNS_4StmtE;_ZL9isEnabledRN5clang17DiagnosticsEngineEj; -static-type=AnalysisBasedWarningsStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class AnalysisBasedWarningsStatics {

// anonymous namespace

/// CheckUnreachable - Check for unreachable code.
//<editor-fold defaultstate="collapsed" desc="CheckUnreachable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 104,
 FQN="CheckUnreachable", NM="_ZL16CheckUnreachableRN5clang4SemaERNS_19AnalysisDeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL16CheckUnreachableRN5clang4SemaERNS_19AnalysisDeclContextE")
//</editor-fold>
public static void CheckUnreachable(final Sema /*&*/ S, final AnalysisDeclContext /*&*/ AC) {
  UnreachableCodeHandler UC = null;
  try {
    // As a heuristic prune all diagnostics not in the main file.  Currently
    // the majority of warnings in headers are false positives.  These
    // are largely caused by configuration state, e.g. preprocessor
    // defined code, etc.
    //
    // Note that this is also a performance optimization.  Analyzing
    // headers many times can be expensive.
    if (!S.getSourceManager().isInMainFile(AC.getDecl().getLocStart())) {
      return;
    }
    
    UC/*J*/= new UnreachableCodeHandler(S);
    FindUnreachableCode(AC, S.getPreprocessor(), UC);
  } finally {
    if (UC != null) { UC.$destroy(); }
  }
}

// anonymous namespace

//===----------------------------------------------------------------------===//
// Check for infinite self-recursion in functions
//===----------------------------------------------------------------------===//

// Returns true if the function is called anywhere within the CFGBlock.
// For member functions, the additional condition of being call from the
// this pointer is required.
//<editor-fold defaultstate="collapsed" desc="hasRecursiveCallInPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 168,
 FQN="hasRecursiveCallInPath", NM="_ZL22hasRecursiveCallInPathPKN5clang12FunctionDeclERNS_8CFGBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL22hasRecursiveCallInPathPKN5clang12FunctionDeclERNS_8CFGBlockE")
//</editor-fold>
public static boolean hasRecursiveCallInPath(/*const*/ FunctionDecl /*P*/ FD, final CFGBlock /*&*/ Block) {
  // Process all the Stmt's in this block to find any calls to FD.
  for (final /*const*/ CFGElement /*&*/ B : Block) {
    if (B.getKind() != CFGElement.Kind.Statement) {
      continue;
    }
    
    /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(B.<CFGStmt>getAs(CFGStmt.class).$arrow().getStmt());
    if (!(CE != null) || !(CE.getCalleeDecl$Const() != null)
       || CE.getCalleeDecl$Const().getCanonicalDecl$Const() != FD) {
      continue;
    }
    {
      
      // Skip function calls which are qualified with a templated class.
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(CE.getCallee$Const().IgnoreParenImpCasts$Const());
      if ((DRE != null)) {
        {
          NestedNameSpecifier /*P*/ NNS = DRE.getQualifier();
          if ((NNS != null)) {
            if (NNS.getKind() == NestedNameSpecifier.SpecifierKind.TypeSpec
               && isa_TemplateSpecializationType(NNS.getAsType())) {
              continue;
            }
          }
        }
      }
    }
    
    /*const*/ CXXMemberCallExpr /*P*/ MCE = dyn_cast_CXXMemberCallExpr(CE);
    if (!(MCE != null) || isa_CXXThisExpr(MCE.getImplicitObjectArgument())
       || !MCE.getMethodDecl().isVirtual()) {
      return true;
    }
  }
  return false;
}


// Returns true if there exists a path to the exit block and every path
// to the exit block passes through a call to FD.
//<editor-fold defaultstate="collapsed" desc="checkForRecursiveFunctionCall">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*enum-default as null*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 208,
 FQN="checkForRecursiveFunctionCall", NM="_ZL29checkForRecursiveFunctionCallPKN5clang12FunctionDeclEPNS_3CFGE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL29checkForRecursiveFunctionCallPKN5clang12FunctionDeclEPNS_3CFGE")
//</editor-fold>
public static boolean checkForRecursiveFunctionCall(/*const*/ FunctionDecl /*P*/ FD, CFG /*P*/ cfg) {
  
  /*const*//*uint*/int ExitID = cfg.getExit().getBlockID();
  
  // Mark all nodes as FoundNoPath, then set the status of the entry block.
  SmallVector<RecursiveState> States/*J*/= new SmallVector<RecursiveState>(JD$UInt_T$C$R.INSTANCE, 16, cfg.getNumBlockIDs(), RecursiveState.FoundNoPath, /*JAVA ENUM RecursiveState.valueOf(0)*/(RecursiveState)null);
  States.$set(cfg.getEntry().getBlockID(), RecursiveState.FoundPathWithNoRecursiveCall);
  
  // Make the processing stack and seed it with the entry block.
  SmallVector<CFGBlock /*P*/ > Stack/*J*/= new SmallVector<CFGBlock /*P*/ >(16, (CFGBlock /*P*/ )null);
  Stack.push_back($AddrOf(cfg.getEntry()));
  while (!Stack.empty()) {
    CFGBlock /*P*/ CurBlock = Stack.back();
    Stack.pop_back();
    
    /*uint*/int ID = CurBlock.getBlockID();
    RecursiveState CurState = States.$at(ID);
    if (CurState == RecursiveState.FoundPathWithNoRecursiveCall) {
      // Found a path to the exit node without a recursive call.
      if (ExitID == ID) {
        return false;
      }
      
      // Only change state if the block has a recursive call.
      if (hasRecursiveCallInPath(FD, $Deref(CurBlock))) {
        CurState = RecursiveState.FoundPath;
      }
    }
    
    // Loop over successor blocks and add them to the Stack if their state
    // changes.
    for (type$ptr<AdjacentBlock /*P*/ > I = $tryClone(CurBlock.succ_begin()), /*P*/ E = $tryClone(CurBlock.succ_end()); $noteq_ptr(I, E); I.$preInc())  {
      if (((I.$star().$CFGBlock$P()) != null)) {
        /*uint*/int next_ID = (I.$star()).$arrow().getBlockID();
        if (States.$at(next_ID).getValue() < CurState.getValue()) {
          States.$set(next_ID, CurState);
          Stack.push_back(I.$star().$CFGBlock$P());
        }
      }
    }
  }
  
  // Return true if the exit node is reachable, and only reachable through
  // a recursive call.
  return States.$at(ExitID) == RecursiveState.FoundPath;
}

//<editor-fold defaultstate="collapsed" desc="checkRecursiveFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 254,
 FQN="checkRecursiveFunction", NM="_ZL22checkRecursiveFunctionRN5clang4SemaEPKNS_12FunctionDeclEPKNS_4StmtERNS_19AnalysisDeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL22checkRecursiveFunctionRN5clang4SemaEPKNS_12FunctionDeclEPKNS_4StmtERNS_19AnalysisDeclContextE")
//</editor-fold>
public static void checkRecursiveFunction(final Sema /*&*/ S, /*const*/ FunctionDecl /*P*/ FD, 
                      /*const*/ Stmt /*P*/ Body, final AnalysisDeclContext /*&*/ AC) {
  FD = FD.getCanonicalDecl$Const();
  
  // Only run on non-templated functions and non-templated members of
  // templated classes.
  if (FD.getTemplatedKind() != FunctionDecl.TemplatedKind.TK_NonTemplate
     && FD.getTemplatedKind() != FunctionDecl.TemplatedKind.TK_MemberSpecialization) {
    return;
  }
  
  CFG /*P*/ cfg = AC.getCFG();
  if (!(cfg != null)) {
    return;
  }
  
  // If the exit block is unreachable, skip processing the function.
  if (cfg.getExit().pred_empty()) {
    return;
  }
  
  // Emit diagnostic if a recursive function call is detected for all paths.
  if (checkForRecursiveFunctionCall(FD, cfg)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Body.getLocStart(), diag.warn_infinite_recursive_function)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// CheckFallThrough - Check that we don't fall off the end of a
/// Statement that should return a value.
///
/// \returns AlwaysFallThrough iff we always fall off the end of the statement,
/// MaybeFallThrough iff we might or might not fall off the end,
/// NeverFallThroughOrReturn iff we never fall off the end of the statement or
/// return.  We assume NeverFallThrough iff we never fall off the end of the
/// statement but we may return.  We assume that functions not marked noreturn
/// will return.
//<editor-fold defaultstate="collapsed" desc="CheckFallThrough">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 297,
 FQN="CheckFallThrough", NM="_ZL16CheckFallThroughRN5clang19AnalysisDeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL16CheckFallThroughRN5clang19AnalysisDeclContextE")
//</editor-fold>
public static ControlFlowKind CheckFallThrough(final AnalysisDeclContext /*&*/ AC) {
  CFG /*P*/ cfg = AC.getCFG();
  if (!(cfg != null)) {
    return ControlFlowKind.UnknownFallThrough;
  }

  // The CFG leaves in dead things, and we don't want the dead code paths to
  // confuse us, so we mark all live things first.
  BitVector live/*J*/= new BitVector(cfg.getNumBlockIDs());
  /*uint*/int count = ScanReachableFromBlock($AddrOf(cfg.getEntry()), 
      live);

  boolean AddEHEdges = AC.getAddEHEdges();
  if (!AddEHEdges && count != cfg.getNumBlockIDs()) {
    // When there are things remaining dead, and we didn't add EH edges
    // from CallExprs to the catch clauses, we have to go back and
    // mark them as live.
    for (/*const*/ CFGBlock /*P*/ B : $Deref(cfg)) {
      if (!live.$at(B.getBlockID()).$bool()) {
        if ($eq_ptr(B.pred_begin$Const(), B.pred_end$Const())) {
          if (B.getTerminator$Const().$bool() && isa_CXXTryStmt(B.getTerminator$Const().getStmt())) {
            // When not adding EH edges from calls, catch clauses
            // can otherwise seem dead.  Avoid noting them as dead.
            count += ScanReachableFromBlock(B, live);
          }
          continue;
        }
      }
    }
  }

  // Now we know what is live, we check the live precessors of the exit block
  // and look for fall through paths, being careful to ignore normal returns,
  // and exceptional paths.
  boolean HasLiveReturn = false;
  boolean HasFakeEdge = false;
  boolean HasPlainEdge = false;
  boolean HasAbnormalEdge = false;

  // Ignore default cases that aren't likely to be reachable because all
  // enums in a switch(X) have explicit case statements.
  CFGBlock.FilterOptions FO/*J*/= new CFGBlock.FilterOptions();
  FO.IgnoreDefaultsWithCoveredEnums = true;

  for (FilteredCFGBlockIterator<type$ptr</*const*/ AdjacentBlock /*P*/ >/*, true*/> I = cfg.getExit().filtered_pred_start_end(FO); I.hasMore(); I.$preInc()) {
    final /*const*/ CFGBlock /*&*/ B = $Deref(I.$star());
    if (!live.$at(B.getBlockID()).$bool()) {
      continue;
    }

    // Skip blocks which contain an element marked as no-return. They don't
    // represent actually viable edges into the exit block, so mark them as
    // abnormal.
    if (B.hasNoReturnElement()) {
      HasAbnormalEdge = true;
      continue;
    }

    // Destructors can appear after the 'return' in the CFG.  This is
    // normal.  We need to look pass the destructors for the return
    // statement (if it exists).
    type$ptr</*const*/ CFGElement /*P*/ > ri = $tryClone(B.rbegin$Const()), /*P*/ re = $tryClone(B.rend$Const());

    for (; $noteq_ptr(ri, re); ri.$preInc())  {
      if (ri.$star().getAs(CFGStmt.class).$bool()) {
        break;
      }
    }

    // No more CFGElements in the block?
    if ($eq_ptr(ri, re)) {
      if (B.getTerminator$Const().$bool() && isa_CXXTryStmt(B.getTerminator$Const().getStmt())) {
        HasAbnormalEdge = true;
        continue;
      }
      // A labeled empty statement, or the entry block...
      HasPlainEdge = true;
      continue;
    }

    CFGStmt CS = ri.$star().castAs(CFGStmt.class);
    /*const*/ Stmt /*P*/ S = CS.getStmt();
    if (isa_ReturnStmt(S)) {
      HasLiveReturn = true;
      continue;
    }
    if (isa_ObjCAtThrowStmt(S)) {
      HasFakeEdge = true;
      continue;
    }
    if (isa_CXXThrowExpr(S)) {
      HasFakeEdge = true;
      continue;
    }
    if (isa_MSAsmStmt(S)) {
      // TODO: Verify this is correct.
      HasFakeEdge = true;
      HasLiveReturn = true;
      continue;
    }
    if (isa_CXXTryStmt(S)) {
      HasAbnormalEdge = true;
      continue;
    }    
    // JAVA: added $equalizer to cast AdjacentBlock to CFGBlock
    Equalizer<AdjacentBlock, Object> $equalizer = (adjacentBlk, exitBlk)->adjacentBlk.$CFGBlock$P() == exitBlk;
    if (std.find(B.succ_begin$Const(), B.succ_end$Const(), $AddrOf(cfg.getExit()), $equalizer)
            .$eq(B.succ_end$Const())) {
      HasAbnormalEdge = true;
      continue;
    }

    HasPlainEdge = true;
  }
  if (!HasPlainEdge) {
    if (HasLiveReturn) {
      return ControlFlowKind.NeverFallThrough;
    }
    return ControlFlowKind.NeverFallThroughOrReturn;
  }
  if (HasAbnormalEdge || HasFakeEdge || HasLiveReturn) {
    return ControlFlowKind.MaybeFallThrough;
  }
  // This says AlwaysFallThrough for calls to functions that are not marked
  // noreturn, that don't return.  If people would like this warning to be more
  // accurate, such functions should be marked as noreturn.
  return ControlFlowKind.AlwaysFallThrough;
}

// anonymous namespace

/// CheckFallThroughForFunctionDef - Check that we don't fall off the end of a
/// function that should return a value.  Check that we don't fall off the end
/// of a noreturn function.  We assume that functions and blocks not marked
/// noreturn will return.
//<editor-fold defaultstate="collapsed" desc="CheckFallThroughForBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 514,
 FQN="CheckFallThroughForBody", NM="_ZL23CheckFallThroughForBodyRN5clang4SemaEPKNS_4DeclEPKNS_4StmtEPKNS_9BlockExprERKN12_GLOBAL__N_127CheckFallThroughDiagnosticsERNS_19AnalysisDeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL23CheckFallThroughForBodyRN5clang4SemaEPKNS_4DeclEPKNS_4StmtEPKNS_9BlockExprERKN12_GLOBAL__N_127CheckFallThroughDiagnosticsERNS_19AnalysisDeclContextE")
//</editor-fold>
public static void CheckFallThroughForBody(final Sema /*&*/ S, /*const*/ Decl /*P*/ D, /*const*/ Stmt /*P*/ Body, 
                       /*const*/ BlockExpr /*P*/ blkExpr, 
                       final /*const*/ CheckFallThroughDiagnostics /*&*/ CD, 
                       final AnalysisDeclContext /*&*/ AC) {
  
  boolean ReturnsVoid = false;
  boolean HasNoReturn = false;
  {
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      ReturnsVoid = FD.getReturnType().$arrow().isVoidType();
      HasNoReturn = FD.isNoReturn();
    } else {
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
      if ((MD != null)) {
        ReturnsVoid = MD.getReturnType().$arrow().isVoidType();
        HasNoReturn = MD.hasAttr(NoReturnAttr.class);
      } else if (isa_BlockDecl(D)) {
        QualType BlockTy = blkExpr.getType();
        {
          /*const*/ FunctionType /*P*/ FT = BlockTy.$arrow().getPointeeType().$arrow().getAs(FunctionType.class);
          if ((FT != null)) {
            if (FT.getReturnType().$arrow().isVoidType()) {
              ReturnsVoid = true;
            }
            if (FT.getNoReturnAttr()) {
              HasNoReturn = true;
            }
          }
        }
      }
    }
  }
  
  final DiagnosticsEngine /*&*/ Diags = S.getDiagnostics();
  
  // Short circuit for compilation speed.
  if (CD.checkDiagnostics(Diags, ReturnsVoid, HasNoReturn)) {
    return;
  }
  
  SourceLocation LBrace = Body.getLocStart(), RBrace = Body.getLocEnd();
  // Either in a function body compound statement, or a function-try-block.
  switch (CheckFallThrough(AC)) {
   case UnknownFallThrough:
    break;
   case MaybeFallThrough:
    if (HasNoReturn) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(RBrace), CD.diag_MaybeFallThrough_HasNoReturn)));
      } finally {
        $c$.$destroy();
      }
    } else if (!ReturnsVoid) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(RBrace), CD.diag_MaybeFallThrough_ReturnsNonVoid)));
      } finally {
        $c$.$destroy();
      }
    }
    break;
   case AlwaysFallThrough:
    if (HasNoReturn) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(RBrace), CD.diag_AlwaysFallThrough_HasNoReturn)));
      } finally {
        $c$.$destroy();
      }
    } else if (!ReturnsVoid) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(RBrace), CD.diag_AlwaysFallThrough_ReturnsNonVoid)));
      } finally {
        $c$.$destroy();
      }
    }
    break;
   case NeverFallThroughOrReturn:
    if (ReturnsVoid && !HasNoReturn && (CD.diag_NeverFallThroughOrReturn != 0)) {
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(LBrace), CD.diag_NeverFallThroughOrReturn)), 0), FD));
          } finally {
            $c$.$destroy();
          }
        } else {
          /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
          if ((MD != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(LBrace), CD.diag_NeverFallThroughOrReturn)), 1), MD));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(S.Diag(new SourceLocation(LBrace), CD.diag_NeverFallThroughOrReturn)));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    break;
   case NeverFallThrough:
    break;
  }
}

// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="SuggestInitializationFixit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 618,
 FQN="SuggestInitializationFixit", NM="_ZL26SuggestInitializationFixitRN5clang4SemaEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL26SuggestInitializationFixitRN5clang4SemaEPKNS_7VarDeclE")
//</editor-fold>
public static boolean SuggestInitializationFixit(final Sema /*&*/ S, /*const*/ VarDecl /*P*/ VD) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    QualType VariableTy = VD.getType().getCanonicalType();
    if (VariableTy.$arrow().isBlockPointerType()
       && !VD.hasAttr(BlocksAttr.class)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(VD.getLocation(), diag.note_block_var_fixit_add_initialization)), 
              VD.getDeclName()), 
          FixItHint.CreateInsertion(VD.getLocation(), new StringRef(/*KEEP_STR*/"__block "))));
      return true;
    }
    
    // Don't issue a fixit if there is already an initializer.
    if ((VD.getInit$Const() != null)) {
      return false;
    }
    
    // Don't suggest a fixit inside macros.
    if (VD.getLocEnd().isMacroID()) {
      return false;
    }
    
    SourceLocation Loc = S.getLocForEndOfToken(VD.getLocEnd());
    
    // Suggest possible initialization (if any).
    std.string Init = S.getFixItZeroInitializerForType(new QualType(VariableTy), new SourceLocation(Loc));
    if (Init.empty()) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_var_fixit_add_initialization)), VD.getDeclName()), 
        FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(Init))));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// Create a fixit to remove an if-like statement, on the assumption that its
/// condition is CondVal.
//<editor-fold defaultstate="collapsed" desc="CreateIfFixit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 650,
 FQN="CreateIfFixit", NM="_ZL13CreateIfFixitRN5clang4SemaEPKNS_4StmtES4_S4_bRNS_9FixItHintES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL13CreateIfFixitRN5clang4SemaEPKNS_4StmtES4_S4_bRNS_9FixItHintES6_")
//</editor-fold>
public static void CreateIfFixit(final Sema /*&*/ S, /*const*/ Stmt /*P*/ If, /*const*/ Stmt /*P*/ Then, 
             /*const*/ Stmt /*P*/ Else, boolean CondVal, 
             final FixItHint /*&*/ Fixit1, final FixItHint /*&*/ Fixit2) {
  if (CondVal) {
    // If condition is always true, remove all but the 'then'.
    Fixit1.$assignMove(FixItHint.CreateRemoval(CharSourceRange.getCharRange(If.getLocStart(), 
                Then.getLocStart())));
    if ((Else != null)) {
      SourceLocation ElseKwLoc = S.getLocForEndOfToken(Then.getLocEnd());
      Fixit2.$assignMove(FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/ElseKwLoc, Else.getLocEnd())));
    }
  } else {
    // If condition is always false, remove all but the 'else'.
    if ((Else != null)) {
      Fixit1.$assignMove(FixItHint.CreateRemoval(CharSourceRange.getCharRange(If.getLocStart(), 
                  Else.getLocStart())));
    } else {
      Fixit1.$assignMove(FixItHint.CreateRemoval(If.getSourceRange()));
    }
  }
}


/// DiagUninitUse -- Helper function to produce a diagnostic for an
/// uninitialized use of a variable.
//<editor-fold defaultstate="collapsed" desc="DiagUninitUse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 676,
 FQN="DiagUninitUse", NM="_ZL13DiagUninitUseRN5clang4SemaEPKNS_7VarDeclERKNS_9UninitUseEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL13DiagUninitUseRN5clang4SemaEPKNS_7VarDeclERKNS_9UninitUseEb")
//</editor-fold>
public static void DiagUninitUse(final Sema /*&*/ S, /*const*/ VarDecl /*P*/ VD, final /*const*/ UninitUse /*&*/ Use, 
             boolean IsCapturedByBlock) {
  boolean Diagnosed = false;
  switch (Use.getKind()) {
   case Always:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Use.getUser().getLocStart(), diag.warn_uninit_var)), 
                    VD.getDeclName()), IsCapturedByBlock), 
            Use.getUser().getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case AfterDecl:
   case AfterCall:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(VD.getLocation(), diag.warn_sometimes_uninit_var)), 
                            VD.getDeclName()), IsCapturedByBlock), 
                    (Use.getKind() == UninitUse.Kind.AfterDecl ? 4 : 5)), 
                ((/*const_cast*/DeclContext /*P*/ )(VD.getLexicalDeclContext$Const()))), 
            VD.getSourceRange()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Use.getUser().getLocStart(), diag.note_uninit_var_use)), 
                IsCapturedByBlock), Use.getUser().getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case Maybe:
   case Sometimes:
    // Carry on to report sometimes-uninitialized branches, if possible,
    // or a 'may be used uninitialized' diagnostic otherwise.
    break;
  }
  
  // Diagnose each branch which leads to a sometimes-uninitialized use.
  for (type$ptr<Branch> I = Use.branch_begin(), /*P*/ E = Use.branch_end();
       $noteq_iter(I, E); I.$preInc()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (Use.getKind() == UninitUse.Kind.Sometimes);
      
      /*const*/ Expr /*P*/ User = Use.getUser();
      /*const*/ Stmt /*P*/ Term = I./*->*/$star().Terminator;
      
      // Information used when building the diagnostic.
      /*uint*/int DiagKind;
      StringRef Str/*J*/= new StringRef();
      SourceRange Range/*J*/= new SourceRange();
      
      // FixIts to suppress the diagnostic by removing the dead condition.
      // For all binary terminators, branch 0 is taken if the condition is true,
      // and branch 1 is taken if the condition is false.
      int RemoveDiagKind = -1;
      /*const*/char$ptr/*char P*/ FixitStr = $tryClone(S.getLangOpts().CPlusPlus ? ((I./*->*/$star().Output != 0) ? $true : $false) : ((I./*->*/$star().Output != 0) ? $1 : $0));
      FixItHint Fixit1/*J*/= new FixItHint(), Fixit2/*J*/= new FixItHint();
      switch ((Term != null) ? Term.getStmtClass() : Stmt.StmtClass.DeclStmtClass) {
       default:
        // Don't know how to report this. Just fall back to 'may be used
        // uninitialized'. FIXME: Can this happen?
        continue;
       case IfStmtClass:
        {
          /*const*/ IfStmt /*P*/ IS = cast_IfStmt(Term);
          DiagKind = 0;
          Str.$assignMove(/*STRINGREF_STR*/$if);
          Range.$assignMove(IS.getCond$Const().getSourceRange());
          RemoveDiagKind = 0;
          CreateIfFixit(S, IS, IS.getThen$Const(), IS.getElse$Const(), 
              (I./*->*/$star().Output != 0), Fixit1, Fixit2);
          break;
        }
       case ConditionalOperatorClass:
        {
          /*const*/ ConditionalOperator /*P*/ CO = cast_ConditionalOperator(Term);
          DiagKind = 0;
          Str.$assignMove(/*STRINGREF_STR*/"?:");
          Range.$assignMove(CO.getCond().getSourceRange());
          RemoveDiagKind = 0;
          CreateIfFixit(S, CO, CO.getTrueExpr(), CO.getFalseExpr(), 
              (I./*->*/$star().Output != 0), Fixit1, Fixit2);
          break;
        }
       case BinaryOperatorClass:
        {
          /*const*/ BinaryOperator /*P*/ BO = cast_BinaryOperator(Term);
          if (!BO.isLogicalOp()) {
            continue;
          }
          DiagKind = 0;
          Str.$assignMove(BO.getOpcodeStr());
          Range.$assignMove(BO.getLHS().getSourceRange());
          RemoveDiagKind = 0;
          if ((BO.getOpcode() == BinaryOperatorKind.BO_LAnd && (I./*->*/$star().Output != 0))
             || (BO.getOpcode() == BinaryOperatorKind.BO_LOr && !(I./*->*/$star().Output != 0))) {
            // true && y -> y, false || y -> y.
            Fixit1.$assignMove(FixItHint.CreateRemoval(new SourceRange(BO.getLocStart(), 
                        BO.getOperatorLoc())));
          } else {
            // false && y -> false, true || y -> true.
            Fixit1.$assignMove(FixItHint.CreateReplacement(BO.getSourceRange(), new StringRef(FixitStr)));
          }
          break;
        }
       case WhileStmtClass:
        
        // "loop is entered / loop is exited".
        DiagKind = 1;
        Str.$assignMove(/*STRINGREF_STR*/$while);
        Range.$assignMove(cast_WhileStmt(Term).getCond$Const().getSourceRange());
        RemoveDiagKind = 1;
        Fixit1.$assignMove(FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef(FixitStr)));
        break;
       case ForStmtClass:
        DiagKind = 1;
        Str.$assignMove(/*STRINGREF_STR*/$for);
        Range.$assignMove(cast_ForStmt(Term).getCond$Const().getSourceRange());
        RemoveDiagKind = 1;
        if ((I./*->*/$star().Output != 0)) {
          Fixit1.$assignMove(FixItHint.CreateRemoval(/*NO_COPY*/Range));
        } else {
          Fixit1.$assignMove(FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef(FixitStr)));
        }
        break;
       case CXXForRangeStmtClass:
        if (I./*->*/$star().Output == 1) {
          // The use occurs if a range-based for loop's body never executes.
          // That may be impossible, and there's no syntactic fix for this,
          // so treat it as a 'may be uninitialized' case.
          continue;
        }
        DiagKind = 1;
        Str.$assignMove(/*STRINGREF_STR*/$for);
        Range.$assignMove(cast_CXXForRangeStmt(Term).getRangeInit$Const().getSourceRange());
        break;
       case DoStmtClass:
        
        // "condition is true / loop is exited".
        DiagKind = 2;
        Str.$assignMove(/*STRINGREF_STR*/$do);
        Range.$assignMove(cast_DoStmt(Term).getCond$Const().getSourceRange());
        RemoveDiagKind = 1;
        Fixit1.$assignMove(FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef(FixitStr)));
        break;
       case CaseStmtClass:
        
        // "switch case is taken".
        DiagKind = 3;
        Str.$assignMove(/*STRINGREF_STR*/$case);
        Range.$assignMove(cast_CaseStmt(Term).getLHS$Const().getSourceRange());
        break;
       case DefaultStmtClass:
        DiagKind = 3;
        Str.$assignMove(/*STRINGREF_STR*/$default);
        Range.$assignMove(new SourceRange(cast_DefaultStmt(Term).getDefaultLoc()));
        break;
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Range.getBegin(), diag.warn_sometimes_uninit_var)), 
                              VD.getDeclName()), IsCapturedByBlock), DiagKind), 
                  Str), I./*->*/$star().Output), Range));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(User.getLocStart(), diag.note_uninit_var_use)), 
              IsCapturedByBlock), User.getSourceRange()));
      if (RemoveDiagKind != -1) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fixit1.RemoveRange.getBegin(), diag.note_uninit_fixit_remove_cond)), 
                            RemoveDiagKind), Str), I./*->*/$star().Output), Fixit1), Fixit2));
      }
      
      Diagnosed = true;
    } finally {
      $c$.$destroy();
    }
  }
  if (!Diagnosed) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Use.getUser().getLocStart(), diag.warn_maybe_uninit_var)), 
                  VD.getDeclName()), IsCapturedByBlock), 
          Use.getUser().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
}


/// DiagnoseUninitializedUse -- Helper function for diagnosing uses of an
/// uninitialized variable. This manages the different forms of diagnostic
/// emitted for particular types of uses. Returns true if the use was diagnosed
/// as a warning. If a particular use is one we omit warnings for, returns
/// false.
//<editor-fold defaultstate="collapsed" desc="DiagnoseUninitializedUse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 848,
 FQN="DiagnoseUninitializedUse", NM="_ZL24DiagnoseUninitializedUseRN5clang4SemaEPKNS_7VarDeclERKNS_9UninitUseEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL24DiagnoseUninitializedUseRN5clang4SemaEPKNS_7VarDeclERKNS_9UninitUseEb")
//</editor-fold>
public static boolean DiagnoseUninitializedUse(final Sema /*&*/ S, /*const*/ VarDecl /*P*/ VD, 
                        final /*const*/ UninitUse /*&*/ Use) {
  return DiagnoseUninitializedUse(S, VD, 
                        Use, 
                        false);
}
public static boolean DiagnoseUninitializedUse(final Sema /*&*/ S, /*const*/ VarDecl /*P*/ VD, 
                        final /*const*/ UninitUse /*&*/ Use, 
                        boolean alwaysReportSelfInit/*= false*/) {
  {
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Use.getUser());
    if ((DRE != null)) {
      {
        // Inspect the initializer of the variable declaration which is
        // being referenced prior to its initialization. We emit
        // specialized diagnostics for self-initialization, and we
        // specifically avoid warning about self references which take the
        // form of:
        //
        //   int x = x;
        //
        // This is used to indicate to GCC that 'x' is intentionally left
        // uninitialized. Proven code paths which access 'x' in
        // an uninitialized state after this will still warn.
        /*const*/ Expr /*P*/ Initializer = VD.getInit$Const();
        if ((Initializer != null)) {
          if (!alwaysReportSelfInit && DRE == Initializer.IgnoreParenImpCasts$Const()) {
            return false;
          }
          
          ContainsReference CR/*J*/= new ContainsReference(S.Context, DRE);
          CR.Visit(Initializer);
          if (CR.doesContainReference()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DRE.getLocStart(), 
                              diag.warn_uninit_self_reference_in_init)), 
                          VD.getDeclName()), VD.getLocation()), DRE.getSourceRange()));
              return true;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      DiagUninitUse(S, VD, Use, false);
    } else {
      /*const*/ BlockExpr /*P*/ BE = cast_BlockExpr(Use.getUser());
      if (VD.getType().$arrow().isBlockPointerType() && !VD.hasAttr(BlocksAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(BE.getLocStart(), 
                  diag.warn_uninit_byref_blockvar_captured_by_block)), 
              VD.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      } else {
        DiagUninitUse(S, VD, Use, true);
      }
    }
  }
  
  // Report where the variable was declared when the use wasn't within
  // the initializer of that declaration & we didn't already suggest
  // an initialization fixit.
  if (!SuggestInitializationFixit(S, VD)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(VD.getLocStart(), diag.note_var_declared_here)), 
          VD.getDeclName()));
    } finally {
      $c$.$destroy();
    }
  }
  
  return true;
}

// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="getFallthroughAttrSpelling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1074,
 FQN="getFallthroughAttrSpelling", NM="_ZL26getFallthroughAttrSpellingRN5clang12PreprocessorENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL26getFallthroughAttrSpellingRN5clang12PreprocessorENS_14SourceLocationE")
//</editor-fold>
public static StringRef getFallthroughAttrSpelling(final Preprocessor /*&*/ PP, 
                          SourceLocation Loc) {
  TokenValue FallthroughTokens[/*5*/] = new TokenValue [/*5*/] {
    new TokenValue(tok.TokenKind.l_square), new TokenValue(tok.TokenKind.l_square), 
    new TokenValue(PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"fallthrough"))), 
    new TokenValue(tok.TokenKind.r_square), new TokenValue(tok.TokenKind.r_square)
  };
  
  TokenValue ClangFallthroughTokens[/*7*/] = new TokenValue [/*7*/] {
    new TokenValue(tok.TokenKind.l_square), new TokenValue(tok.TokenKind.l_square), new TokenValue(PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"clang"))), 
    new TokenValue(tok.TokenKind.coloncolon), new TokenValue(PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"fallthrough"))), 
    new TokenValue(tok.TokenKind.r_square), new TokenValue(tok.TokenKind.r_square)
  };
  
  boolean PreferClangAttr = !PP.getLangOpts().CPlusPlus1z;
  
  StringRef MacroName/*J*/= new StringRef();
  if (PreferClangAttr) {
    MacroName.$assignMove(PP.getLastMacroWithSpelling(new SourceLocation(Loc), new ArrayRef<TokenValue>(ClangFallthroughTokens, false)));
  }
  if (MacroName.empty()) {
    MacroName.$assignMove(PP.getLastMacroWithSpelling(new SourceLocation(Loc), new ArrayRef<TokenValue>(FallthroughTokens, false)));
  }
  if (MacroName.empty() && !PreferClangAttr) {
    MacroName.$assignMove(PP.getLastMacroWithSpelling(new SourceLocation(Loc), new ArrayRef<TokenValue>(ClangFallthroughTokens, false)));
  }
  if (MacroName.empty()) {
    MacroName.$assignMove(/*STRINGREF_STR*/PreferClangAttr ? $("[[clang::fallthrough]]") : $("[[fallthrough]]"));
  }
  return MacroName;
}

public static iterator_range<CFGBlock /*P*/> reverse$NotHasRBegin(CFG Components) {
  return new iterator_range(Components.rbegin(), Components.rend());
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseSwitchLabelsFallthrough">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1102,
 FQN="DiagnoseSwitchLabelsFallthrough", NM="_ZL31DiagnoseSwitchLabelsFallthroughRN5clang4SemaERNS_19AnalysisDeclContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL31DiagnoseSwitchLabelsFallthroughRN5clang4SemaERNS_19AnalysisDeclContextEb")
//</editor-fold>
public static void DiagnoseSwitchLabelsFallthrough(final Sema /*&*/ S, final AnalysisDeclContext /*&*/ AC, 
                               boolean PerFunction) {
  FallthroughMapper FM = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Only perform this analysis when using C++11.  There is no good workflow
    // for this warning when not using C++11.  There is no good way to silence
    // the warning (no attribute is available) unless we are using C++11's support
    // for generalized attributes.  Once could use pragmas to silence the warning,
    // but as a general solution that is gross and not in the spirit of this
    // warning.
    //
    // NOTE: This an intermediate solution.  There are on-going discussions on
    // how to properly support this warning outside of C++11 with an annotation.
    if (!AC.getASTContext().getLangOpts().CPlusPlus11) {
      return;
    }
    
    FM/*J*/= new FallthroughMapper(S);
    FM.TraverseStmt(AC.getBody());
    if (!FM.foundSwitchStatements()) {
      return;
    }
    if (PerFunction && FM.getFallthroughStmts().empty()) {
      return;
    }
    
    CFG /*P*/ Cfg = AC.getCFG();
    if (!(Cfg != null)) {
      return;
    }
    
    FM.fillReachableBlocks(Cfg);
    
    for (/*const*/ CFGBlock /*P*/ B : reverse$NotHasRBegin($Deref(Cfg))) {
      /*const*/ Stmt /*P*/ Label = B.getLabel$Const();
      if (!(Label != null) || !isa_SwitchCase(Label)) {
        continue;
      }
      
      int$ref AnnotatedCnt = create_int$ref();
      if (!FM.checkFallThroughIntoBlock($Deref(B), AnnotatedCnt)) {
        continue;
      }
      
      $c$.clean($c$.track(S.Diag(Label.getLocStart(), 
          PerFunction ? diag.warn_unannotated_fallthrough_per_function : diag.warn_unannotated_fallthrough)));
      if (!(AnnotatedCnt.$deref() != 0)) {
        SourceLocation L = Label.getLocStart();
        if (L.isMacroID()) {
          continue;
        }
        if (S.getLangOpts().CPlusPlus11) {
          /*const*/ Stmt /*P*/ Term = B.getTerminator$Const().$Stmt$C$P();
          // Skip empty cases.
          while (B.empty() && !(Term != null) && B.succ_size() == 1) {
            B = B.succ_begin$Const().$star().$CFGBlock$P();
            Term = B.getTerminator$Const().$Stmt$C$P();
          }
          if (!(B.empty() && (Term != null) && isa_BreakStmt(Term))) {
            final Preprocessor /*&*/ PP = S.getPreprocessor();
            StringRef AnnotationSpelling = getFallthroughAttrSpelling(PP, new SourceLocation(L));
            SmallString/*64*/ TextToInsert/*J*/= new SmallString/*64*/(new StringRef(AnnotationSpelling), 64);
            TextToInsert.$addassign(/*STRINGREF_STR*/"; ");
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(L), diag.note_insert_fallthrough_fixit)), 
                    AnnotationSpelling), 
                FixItHint.CreateInsertion(/*NO_COPY*/L, TextToInsert.$StringRef())));
          }
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(L), diag.note_insert_break_fixit)), 
            FixItHint.CreateInsertion(/*NO_COPY*/L, new StringRef(/*KEEP_STR*/"break; "))));
      }
    }
    
    for (/*const*/ AttributedStmt /*P*/ F : FM.getFallthroughStmts())  {
      $c$.clean($c$.track(S.Diag(F.getLocStart(), diag.err_fallthrough_attr_invalid_placement)));
    }
  } finally {
    if (FM != null) { FM.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="isInLoop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1177,
 FQN="isInLoop", NM="_ZL8isInLoopRKN5clang10ASTContextERKNS_9ParentMapEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL8isInLoopRKN5clang10ASTContextERKNS_9ParentMapEPKNS_4StmtE")
//</editor-fold>
public static boolean isInLoop(final /*const*/ ASTContext /*&*/ Ctx, final /*const*/ ParentMap /*&*/ PM, 
        /*const*/ Stmt /*P*/ S) {
  assert (Native.$bool(S));
  
  do {
    switch (S.getStmtClass()) {
     case ForStmtClass:
     case WhileStmtClass:
     case CXXForRangeStmtClass:
     case ObjCForCollectionStmtClass:
      return true;
     case DoStmtClass:
      {
        /*const*/ Expr /*P*/ Cond = cast_DoStmt(S).getCond$Const();
        APSInt Val/*J*/= new APSInt();
        if (!Cond.EvaluateAsInt(Val, Ctx)) {
          return true;
        }
        return Val.getBoolValue();
      }
     default:
      break;
    }
  } while (((S = PM.getParent_Stmt$C$P(S)) != null));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="diagnoseRepeatedUseOfWeak">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1203,
 FQN="diagnoseRepeatedUseOfWeak", NM="_ZL25diagnoseRepeatedUseOfWeakRN5clang4SemaEPKNS_4sema17FunctionScopeInfoEPKNS_4DeclERKNS_9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL25diagnoseRepeatedUseOfWeakRN5clang4SemaEPKNS_4sema17FunctionScopeInfoEPKNS_4DeclERKNS_9ParentMapE")
//</editor-fold>
public static void diagnoseRepeatedUseOfWeak(final Sema /*&*/ S, 
                         /*const*/ FunctionScopeInfo /*P*/ CurFn, 
                         /*const*/ Decl /*P*/ D, 
                         final /*const*/ ParentMap /*&*/ PM) {
  /*typedef sema::FunctionScopeInfo::WeakObjectProfileTy WeakObjectProfileTy*/
//  final class WeakObjectProfileTy extends FunctionScopeInfo.WeakObjectProfileTy{ };
  /*typedef sema::FunctionScopeInfo::WeakObjectUseMap WeakObjectUseMap*/
//  final class WeakObjectUseMap extends SmallDenseMap<WeakObjectProfileTy, SmallVector<WeakUseTy>>{ };
  /*typedef sema::FunctionScopeInfo::WeakUseVector WeakUseVector*/
//  final class WeakUseVector extends SmallVector<WeakUseTy>{ };
  /*typedef std::pair<const Stmt *, WeakObjectUseMap::const_iterator> StmtUsesPair*/
//  final class StmtUsesPair extends std.pair</*const*/ Stmt /*P*/ , DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>> >{ };
  
  final ASTContext /*&*/ Ctx = S.getASTContext();
  
  final /*const*/SmallDenseMap<WeakObjectProfileTy, SmallVector<WeakUseTy>> /*&*/ WeakMap = CurFn.getWeakObjectUses();
  
  // Extract all weak objects that are referenced more than once.
  SmallVector<std.pair</*const*/ Stmt /*P*/ , DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>> >> UsesByStmt/*J*/= new SmallVector<std.pair</*const*/ Stmt /*P*/ , DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>> >>(8, new std.pairPtrType</*const*/ Stmt /*P*/ , DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>> >(null, new DenseMapIterator()));
  for (DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>> I = WeakMap.begin$Const(), E = WeakMap.end$Const();
       I.$noteq(E); I.$preInc()) {
    final /*const*/SmallVector<WeakUseTy> /*&*/ Uses = I.$arrow().second;
    
    // Find the first read of the weak object.
    type$ptr<WeakUseTy> UI = $tryClone(Uses.begin$Const()), /*P*/ UE = $tryClone(Uses.end$Const());
    for (; $noteq_ptr(UI, UE); UI.$preInc()) {
      if (UI./*->*/$star().isUnsafe()) {
        break;
      }
    }
    
    // If there were only writes to this object, don't warn.
    if ($eq_ptr(UI, UE)) {
      continue;
    }
    
    // If there was only one read, followed by any number of writes, and the
    // read is not within a loop, don't warn. Additionally, don't warn in a
    // loop if the base object is a local variable -- local variables are often
    // changed in loops.
    if ($eq_ptr(UI, Uses.begin$Const())) {
      type$ptr<WeakUseTy> UI2 = $tryClone(UI);
      for (UI2.$preInc(); $noteq_ptr(UI2, UE); UI2.$preInc())  {
        if (UI2./*->*/$star().isUnsafe()) {
          break;
        }
      }
      if ($eq_ptr(UI2, UE)) {
        if (!isInLoop(Ctx, PM, UI./*->*/$star().getUseExpr())) {
          continue;
        }
        
        final /*const*/ FunctionScopeInfo.WeakObjectProfileTy /*&*/ Profile = I.$arrow().first;
        if (!Profile.isExactProfile()) {
          continue;
        }
        
        /*const*/ NamedDecl /*P*/ Base = Profile.getBase();
        if (!(Base != null)) {
          Base = Profile.getProperty();
        }
        assert ((Base != null)) : "A profile always has a base or property.";
        {
          
          /*const*/ VarDecl /*P*/ BaseVar = dyn_cast_VarDecl(Base);
          if ((BaseVar != null)) {
            if (BaseVar.hasLocalStorage() && !isa_ParmVarDecl(Base)) {
              continue;
            }
          }
        }
      }
    }
    
    UsesByStmt.push_back(new std.pairPtrType</*const*/ Stmt /*P*/ , DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>> >(JD$T$RR_T1$RR.INSTANCE, UI./*->*/$star().getUseExpr(), I));
  }
  if (UsesByStmt.empty()) {
    return;
  }
  
  // Sort by first use so that we emit the warnings in a deterministic order.
  final SourceManager /*&*/ SM = S.getSourceManager();
  std.sort(UsesByStmt.begin(), UsesByStmt.end(), 
       (LHS, RHS) -> 
        {
          return SM.isBeforeInTranslationUnit(LHS.first.getLocStart(), 
              RHS.first.getLocStart());
        }
);
  
  // Classify the current code body for better warning text.
  // This enum should stay in sync with the cases in
  // warn_arc_repeated_use_of_weak and warn_arc_possible_repeated_use_of_weak.
  // FIXME: Should we use a common classification enum and the same set of
  // possibilities all throughout Sema?
  //<editor-fold defaultstate="collapsed" desc="">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1282,
//   FQN="", NM="_ZL25diagnoseRepeatedUseOfWeakRN5clang4SemaEPKNS_4sema17FunctionScopeInfoEPKNS_4DeclERKNS_9ParentMapE_Unnamed_enum",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL25diagnoseRepeatedUseOfWeakRN5clang4SemaEPKNS_4sema17FunctionScopeInfoEPKNS_4DeclERKNS_9ParentMapE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    final /*uint*/int Function = 0;
    final /*uint*/int Method = Function + 1;
    final /*uint*/int Block = Method + 1;
    final /*uint*/int Lambda = Block + 1;
  /*}*/int FunctionKind;
  if (isa_BlockScopeInfo(CurFn)) {
    FunctionKind = Block;
  } else if (isa_LambdaScopeInfo(CurFn)) {
    FunctionKind = Lambda;
  } else if (isa_ObjCMethodDecl(D)) {
    FunctionKind = Method;
  } else {
    FunctionKind = Function;
  }
  
  // Iterate through the sorted problems and emit warnings for each.
  for (final /*const*/ pair</*const*/ Stmt /*P*/ , DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>> > /*&*/ P : UsesByStmt) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Stmt /*P*/ FirstRead = P.first;
      final /*const*/ FunctionScopeInfo.WeakObjectProfileTy /*&*/ Key = P.second.$arrow().first;
      final /*const*/SmallVector<WeakUseTy> /*&*/ Uses = P.second.$arrow().second;
      
      // For complicated expressions like 'a.b.c' and 'x.b.c', WeakObjectProfileTy
      // may not contain enough information to determine that these are different
      // properties. We can only be 100% sure of a repeated use in certain cases,
      // and we adjust the diagnostic kind accordingly so that the less certain
      // case can be turned off if it is too noisy.
      /*uint*/int DiagKind;
      if (Key.isExactProfile()) {
        DiagKind = diag.warn_arc_repeated_use_of_weak;
      } else {
        DiagKind = diag.warn_arc_possible_repeated_use_of_weak;
      }
      
      // Classify the weak object being accessed for better warning text.
      // This enum should stay in sync with the cases in
      // warn_arc_repeated_use_of_weak and warn_arc_possible_repeated_use_of_weak.
      //<editor-fold defaultstate="collapsed" desc="">
//      @Converted(kind = Converted.Kind.AUTO,
//       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1318,
//       FQN="", NM="_ZL25diagnoseRepeatedUseOfWeakRN5clang4SemaEPKNS_4sema17FunctionScopeInfoEPKNS_4DeclERKNS_9ParentMapE_Unnamed_enum1",
//       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL25diagnoseRepeatedUseOfWeakRN5clang4SemaEPKNS_4sema17FunctionScopeInfoEPKNS_4DeclERKNS_9ParentMapE_Unnamed_enum1")
      //</editor-fold>
      /*enum ANONYMOUS_INT_CONSTANTS {*/
        final /*uint*/int Variable = 0;
        final /*uint*/int Property = Variable + 1;
        final /*uint*/int ImplicitProperty = Property + 1;
        final /*uint*/int Ivar = ImplicitProperty + 1;
      /*}*/int ObjectKind;
      
      /*const*/ NamedDecl /*P*/ KeyProp = Key.getProperty();
      if (isa_VarDecl(KeyProp)) {
        ObjectKind = Variable;
      } else if (isa_ObjCPropertyDecl(KeyProp)) {
        ObjectKind = Property;
      } else if (isa_ObjCMethodDecl(KeyProp)) {
        ObjectKind = ImplicitProperty;
      } else if (isa_ObjCIvarDecl(KeyProp)) {
        ObjectKind = Ivar;
      } else {
        throw new llvm_unreachable("Unexpected weak object kind!");
      }
      {
        
        // Do not warn about IBOutlet weak property receivers being set to null
        // since they are typically only used from the main thread.
        /*const*/ ObjCPropertyDecl /*P*/ Prop = dyn_cast_ObjCPropertyDecl(KeyProp);
        if ((Prop != null)) {
          if (Prop.hasAttr(IBOutletAttr.class)) {
            continue;
          }
        }
      }
      
      // Show the first time the object was read.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FirstRead.getLocStart(), DiagKind)), 
                      ((int)(ObjectKind))), KeyProp), ((int)(FunctionKind))), 
          FirstRead.getSourceRange()));
      
      // Print all the other accesses as notes.
      for (final /*const*/ WeakUseTy /*&*/ Use : Uses) {
        if (Use.getUseExpr() == FirstRead) {
          continue;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Use.getUseExpr().getLocStart(), 
                diag.note_arc_weak_also_accessed_here)), 
            Use.getUseExpr().getSourceRange()));
      }
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="isEnabled">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1840,
 FQN="isEnabled", NM="_ZL9isEnabledRN5clang17DiagnosticsEngineEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL9isEnabledRN5clang17DiagnosticsEngineEj")
//</editor-fold>
public static /*uint*/int isEnabled(final DiagnosticsEngine /*&*/ D, /*uint*/int diag) {
  return (/*uint*/int)((!D.isIgnored(diag, new SourceLocation())) ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="flushDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1872,
 FQN="flushDiagnostics", NM="_ZL16flushDiagnosticsRN5clang4SemaEPKNS_4sema17FunctionScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZL16flushDiagnosticsRN5clang4SemaEPKNS_4sema17FunctionScopeInfoE")
//</editor-fold>
public static void flushDiagnostics(final Sema /*&*/ S, /*const*/ FunctionScopeInfo /*P*/ fscope) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    for (final /*const*/ PossiblyUnreachableDiag /*&*/ D : fscope.PossiblyUnreachableDiags)  {
      $c$.clean($c$.track(S.Diag(new SourceLocation(D.Loc), D.PD)));
    }
  } finally {
    $c$.$destroy();
  }
}

} // END OF class AnalysisBasedWarningsStatics
