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
package org.clang.analysis.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.analysis.domainspecific.ObjCNoReturn;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type UninitializedValuesStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZL10runOnBlockPKN5clang8CFGBlockERKNS_3CFGERNS_19AnalysisDeclContextERN12_GLOBAL__N_114CFGBlockValuesERKNS8_12ClassifyRefsERN4llvm9BitVectorERNS_22UninitVariablesHandlerE;_ZL12isTrackedVarPKN5clang7VarDeclEPKNS_11DeclContextE;_ZL14isAlwaysUninit5Value;_ZL15getSelfInitExprPN5clang7VarDeclE;_ZL15isUninitialized5Value;_ZL16isPointerToConstRKN5clang8QualTypeE;_ZN12_GLOBAL__N_116DataflowWorklistE;_ZN12_GLOBAL__N_117TransferFunctionsE;_ZN12_GLOBAL__N_1L10stripCastsERN5clang10ASTContextEPKNS0_4ExprE;_ZN12_GLOBAL__N_1L7findVarEPKN5clang4ExprEPKNS0_11DeclContextE; -static-type=UninitializedValuesStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class UninitializedValuesStatics {

//<editor-fold defaultstate="collapsed" desc="isTrackedVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 36,
 FQN="isTrackedVar", NM="_ZL12isTrackedVarPKN5clang7VarDeclEPKNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZL12isTrackedVarPKN5clang7VarDeclEPKNS_11DeclContextE")
//</editor-fold>
public static boolean isTrackedVar(/*const*/ VarDecl /*P*/ vd, /*const*/ DeclContext /*P*/ dc) {
  if (vd.isLocalVarDecl() && !vd.hasGlobalStorage()
     && !vd.isExceptionVariable() && !vd.isInitCapture()
     && !vd.isImplicit() && vd.getDeclContext$Const() == dc) {
    QualType ty = vd.getType();
    return ty.$arrow().isScalarType() || ty.$arrow().isVectorType() || ty.$arrow().isRecordType();
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isUninitialized">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 96,
 FQN="isUninitialized", NM="_ZL15isUninitialized5Value",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZL15isUninitialized5Value")
//</editor-fold>
public static boolean isUninitialized(/*const Value*//*uint*/int v) {
  return v >= Value.Uninitialized;
}

//<editor-fold defaultstate="collapsed" desc="isAlwaysUninit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 99,
 FQN="isAlwaysUninit", NM="_ZL14isAlwaysUninit5Value",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZL14isAlwaysUninit5Value")
//</editor-fold>
public static boolean isAlwaysUninit(/*const Value*//*uint*/int v) {
  return v == Value.Uninitialized;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 207,
 FQN="(anonymous namespace)::DataflowWorklist", NM="_ZN12_GLOBAL__N_116DataflowWorklistE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklistE")
//</editor-fold>
public static class DataflowWorklist implements Destructors.ClassWithDestructor {
  private std.reverse_iterator</*const*/ CFGBlock /*&*/ > PO_I;
  private std.reverse_iterator</*const*/ CFGBlock /*&*/ > PO_E;
  private SmallVector</*const*/ CFGBlock /*P*/ > worklist;
  private BitVector enqueuedBlocks;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::DataflowWorklist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 212,
   FQN="(anonymous namespace)::DataflowWorklist::DataflowWorklist", NM="_ZN12_GLOBAL__N_116DataflowWorklistC1ERKN5clang3CFGERNS1_16PostOrderCFGViewE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklistC1ERKN5clang3CFGERNS1_16PostOrderCFGViewE")
  //</editor-fold>
  public DataflowWorklist(final /*const*/ CFG /*&*/ cfg, final PostOrderCFGView /*&*/ view) {
    // : PO_I(view.begin()), PO_E(view.end()), worklist(), enqueuedBlocks(cfg.getNumBlockIDs(), true) 
    //START JInit
    this.PO_I = view.begin();
    this.PO_E = view.end();
    this.worklist = new SmallVector</*const*/ CFGBlock /*P*/ >(20, (/*const*/ CFGBlock /*P*/ )null);
    this.enqueuedBlocks = new BitVector(cfg.getNumBlockIDs(), true);
    //END JInit
    // Treat the first block as already analyzed.
    if ($noteq_reverse_iterator$C(PO_I, PO_E)) {
      assert (PO_I.$star() == $AddrOf(cfg.getEntry$Const()));
      enqueuedBlocks.$at((PO_I.$star()).getBlockID()).$assign(/*KEEP_BOOL*/false);
      PO_I.$preInc();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::enqueueSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 228,
   FQN="(anonymous namespace)::DataflowWorklist::enqueueSuccessors", NM="_ZN12_GLOBAL__N_116DataflowWorklist17enqueueSuccessorsEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklist17enqueueSuccessorsEPKN5clang8CFGBlockE")
  //</editor-fold>
  public void enqueueSuccessors(/*const*/ CFGBlock /*P*/ block) {
    for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(block.succ_begin$Const()), 
        /*P*/ E = $tryClone(block.succ_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      /*const*/ CFGBlock /*P*/ Successor = I.$star().$CFGBlock$P();
      if (!(Successor != null) || enqueuedBlocks.$at(Successor.getBlockID()).$bool()) {
        continue;
      }
      worklist.push_back(Successor);
      enqueuedBlocks.$at(Successor.getBlockID()).$assign(/*KEEP_BOOL*/true);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::dequeue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 239,
   FQN="(anonymous namespace)::DataflowWorklist::dequeue", NM="_ZN12_GLOBAL__N_116DataflowWorklist7dequeueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklist7dequeueEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ dequeue() {
    /*const*/ CFGBlock /*P*/ B = null;
    
    // First dequeue from the worklist.  This can represent
    // updates along backedges that we want propagated as quickly as possible.
    if (!worklist.empty()) {
      B = worklist.pop_back_val();
    } else 
    // Next dequeue from the initial reverse post order.  This is the
    // theoretical ideal in the presence of no back edges.
    if ($noteq_reverse_iterator$C(PO_I, PO_E)) {
      B = PO_I.$star();
      PO_I.$preInc();
    } else {
      return null;
    }
    assert (enqueuedBlocks.$at(B.getBlockID()).$bool() == true);
    enqueuedBlocks.$at(B.getBlockID()).$assign(/*KEEP_BOOL*/false);
    return B;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::~DataflowWorklist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 207,
   FQN="(anonymous namespace)::DataflowWorklist::~DataflowWorklist", NM="_ZN12_GLOBAL__N_116DataflowWorklistD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklistD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    enqueuedBlocks.$destroy();
    worklist.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "PO_I=" + PO_I // NOI18N
              + ", PO_E=" + PO_E // NOI18N
              + ", worklist=" + worklist // NOI18N
              + ", enqueuedBlocks=" + enqueuedBlocks; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stripCasts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 277,
 FQN="(anonymous namespace)::stripCasts", NM="_ZN12_GLOBAL__N_1L10stripCastsERN5clang10ASTContextEPKNS0_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_1L10stripCastsERN5clang10ASTContextEPKNS0_4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ stripCasts(final ASTContext /*&*/ C, /*const*/ Expr /*P*/ Ex) {
  while ((Ex != null)) {
    Ex = Ex.IgnoreParenNoopCasts$Const(C);
    {
      /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(Ex);
      if ((CE != null)) {
        if (CE.getCastKind() == CastKind.CK_LValueBitCast) {
          Ex = CE.getSubExpr$Const();
          continue;
        }
      }
    }
    break;
  }
  return Ex;
}


/// If E is an expression comprising a reference to a single variable, find that
/// variable.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::findVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 293,
 FQN="(anonymous namespace)::findVar", NM="_ZN12_GLOBAL__N_1L7findVarEPKN5clang4ExprEPKNS0_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_1L7findVarEPKN5clang4ExprEPKNS0_11DeclContextE")
//</editor-fold>
public static FindVarResult findVar(/*const*/ Expr /*P*/ E, /*const*/ DeclContext /*P*/ DC) {
  {
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(stripCasts(DC.getParentASTContext(), E));
    if ((DRE != null)) {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const());
        if ((VD != null)) {
          if (isTrackedVar(VD, DC)) {
            return new FindVarResult(VD, DRE);
          }
        }
      }
    }
  }
  return new FindVarResult((/*const*/ VarDecl /*P*/ )null, (/*const*/ DeclRefExpr /*P*/ )null);
}

//<editor-fold defaultstate="collapsed" desc="getSelfInitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 350,
 FQN="getSelfInitExpr", NM="_ZL15getSelfInitExprPN5clang7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZL15getSelfInitExprPN5clang7VarDeclE")
//</editor-fold>
public static /*const*/ DeclRefExpr /*P*/ getSelfInitExpr(VarDecl /*P*/ VD) {
  if (VD.getType().$arrow().isRecordType()) {
    return null;
  }
  {
    Expr /*P*/ Init = VD.getInit();
    if ((Init != null)) {
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(stripCasts(VD.getASTContext(), Init));
      if ((DRE != null) && DRE.getDecl$Const() == VD) {
        return DRE;
      }
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="isPointerToConst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 436,
 FQN="isPointerToConst", NM="_ZL16isPointerToConstRKN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZL16isPointerToConstRKN5clang8QualTypeE")
//</editor-fold>
public static boolean isPointerToConst(final /*const*/ QualType /*&*/ QT) {
  return QT.$arrow().isAnyPointerType() && QT.$arrow().getPointeeType().isConstQualified();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 490,
 FQN="(anonymous namespace)::TransferFunctions", NM="_ZN12_GLOBAL__N_117TransferFunctionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctionsE")
//</editor-fold>
public static class TransferFunctions implements /*public*/ StmtVisitorVoid<TransferFunctions> {
  private final CFGBlockValues /*&*/ vals;
  private final /*const*/ CFG /*&*/ cfg;
  private /*const*/ CFGBlock /*P*/ block;
  private final AnalysisDeclContext /*&*/ ac;
  private final /*const*/ ClassifyRefs /*&*/ classification;
  private ObjCNoReturn objCNoRet;
  private final UninitVariablesHandler /*&*/ handler;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::TransferFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 500,
   FQN="(anonymous namespace)::TransferFunctions::TransferFunctions", NM="_ZN12_GLOBAL__N_117TransferFunctionsC1ERNS_14CFGBlockValuesERKN5clang3CFGEPKNS3_8CFGBlockERNS3_19AnalysisDeclContextERKNS_12ClassifyRefsERNS3_22UninitVariablesHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctionsC1ERNS_14CFGBlockValuesERKN5clang3CFGEPKNS3_8CFGBlockERNS3_19AnalysisDeclContextERKNS_12ClassifyRefsERNS3_22UninitVariablesHandlerE")
  //</editor-fold>
  public TransferFunctions(final CFGBlockValues /*&*/ vals, final /*const*/ CFG /*&*/ cfg, 
      /*const*/ CFGBlock /*P*/ block, final AnalysisDeclContext /*&*/ ac, 
      final /*const*/ ClassifyRefs /*&*/ classification, 
      final UninitVariablesHandler /*&*/ handler) {
    // : StmtVisitor<TransferFunctions>(), vals(vals), cfg(cfg), block(block), ac(ac), classification(classification), objCNoRet(ac.getASTContext()), handler(handler) 
    //START JInit
    $StmtVisitor();
    this./*&*/vals=/*&*/vals;
    this./*&*/cfg=/*&*/cfg;
    this.block = block;
    this./*&*/ac=/*&*/ac;
    this./*&*/classification=/*&*/classification;
    this.objCNoRet = new ObjCNoReturn(ac.getASTContext());
    this./*&*/handler=/*&*/handler;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::reportUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 677,
   FQN="(anonymous namespace)::TransferFunctions::reportUse", NM="_ZN12_GLOBAL__N_117TransferFunctions9reportUseEPKN5clang4ExprEPKNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions9reportUseEPKN5clang4ExprEPKNS1_7VarDeclE")
  //</editor-fold>
  public void reportUse(/*const*/ Expr /*P*/ ex, /*const*/ VarDecl /*P*/ vd) {
    /*Value*//*uint*/int v = vals.$at(vd).$T();
    if (isUninitialized(v)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        handler.handleUseOfUninitVariable(vd, $c$.track(getUninitUse(ex, vd, v))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 745,
   FQN="(anonymous namespace)::TransferFunctions::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_117TransferFunctions19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ BO) {
    if (BO.getOpcode() == BinaryOperatorKind.BO_Assign) {
      FindVarResult Var = findVar(BO.getLHS());
      {
        /*const*/ VarDecl /*P*/ VD = Var.getDecl();
        if ((VD != null)) {
          vals.$at(VD).$assign(/*KEEP_ENUM*/Value.Initialized);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 692,
   FQN="(anonymous namespace)::TransferFunctions::VisitBlockExpr", NM="_ZN12_GLOBAL__N_117TransferFunctions14VisitBlockExprEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions14VisitBlockExprEPN5clang9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(BlockExpr /*P*/ be) {
    /*const*/ BlockDecl /*P*/ bd = be.getBlockDecl();
    for (final /*const*/ BlockDecl.Capture /*&*/ I : bd.captures()) {
      /*const*/ VarDecl /*P*/ vd = I.getVariable();
      if (!isTrackedVar(vd)) {
        continue;
      }
      if (I.isByRef()) {
        vals.$at(vd).$assign(/*KEEP_ENUM*/Value.Initialized);
        continue;
      }
      reportUse(be, vd);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 706,
   FQN="(anonymous namespace)::TransferFunctions::VisitCallExpr", NM="_ZN12_GLOBAL__N_117TransferFunctions13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ ce) {
    {
      Decl /*P*/ Callee = ce.getCalleeDecl();
      if ((Callee != null)) {
        if (Callee.hasAttr(ReturnsTwiceAttr.class)) {
          // After a call to a function like setjmp or vfork, any variable which is
          // initialized anywhere within this function may now be initialized. For
          // now, just assume such a call initializes all variables.  FIXME: Only
          // mark variables as initialized if they have an initializer which is
          // reachable from here.
          vals.setAllScratchValues(Value.Initialized);
        } else if (Callee.hasAttr(AnalyzerNoReturnAttr.class)) {
          // Functions labeled like "analyzer_noreturn" are often used to denote
          // "panic" functions that in special debug situations can still return,
          // but for the most part should not be treated as returning.  This is a
          // useful annotation borrowed from the static analyzer that is useful for
          // suppressing branch-specific false positives when we call one of these
          // functions but keep pretending the path continues (when in reality the
          // user doesn't care).
          vals.setAllScratchValues(Value.Unknown);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 729,
   FQN="(anonymous namespace)::TransferFunctions::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_117TransferFunctions16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ dr) {
    switch (classification.get(dr)) {
     case Ignore:
      break;
     case Use:
      reportUse(dr, cast_VarDecl(dr.getDecl()));
      break;
     case Init:
      vals.$at(cast_VarDecl(dr.getDecl())).$assign(/*KEEP_ENUM*/Value.Initialized);
      break;
     case SelfInit:
      handler.handleSelfInit(cast_VarDecl(dr.getDecl()));
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 753,
   FQN="(anonymous namespace)::TransferFunctions::VisitDeclStmt", NM="_ZN12_GLOBAL__N_117TransferFunctions13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ DS) {
    for (Decl /*P*/ DI : DS.decls()) {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(DI);
      if ((VD != null) && isTrackedVar(VD)) {
        if ((getSelfInitExpr(VD) != null)) {
          // If the initializer consists solely of a reference to itself, we
          // explicitly mark the variable as uninitialized. This allows code
          // like the following:
          //
          //   int x = x;
          //
          // to deliberately leave a variable uninitialized. Different analysis
          // clients can detect this pattern and adjust their reporting
          // appropriately, but we need to continue to analyze subsequent uses
          // of the variable.
          vals.$at(VD).$assign(/*KEEP_ENUM*/Value.Uninitialized);
        } else if ((VD.getInit() != null)) {
          // Treat the new variable as initialized.
          vals.$at(VD).$assign(/*KEEP_ENUM*/Value.Initialized);
        } else {
          // No initializer: the variable is now uninitialized. This matters
          // for cases like:
          //   while (...) {
          //     int n;
          //     use(n);
          //     n = 0;
          //   }
          // FIXME: Mark the variable as uninitialized whenever its scope is
          // left, since its scope could be re-entered by a jump over the
          // declaration.
          vals.$at(VD).$assign(/*KEEP_ENUM*/Value.Uninitialized);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 683,
   FQN="(anonymous namespace)::TransferFunctions::VisitObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_117TransferFunctions26VisitObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions26VisitObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ FS) {
    {
      // This represents an initialization of the 'element' value.
      DeclStmt /*P*/ DS = dyn_cast_DeclStmt(FS.getElement());
      if ((DS != null)) {
        /*const*/ VarDecl /*P*/ VD = cast_VarDecl(DS.getSingleDecl());
        if (isTrackedVar(VD)) {
          vals.$at(VD).$assign(/*KEEP_ENUM*/Value.Initialized);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 789,
   FQN="(anonymous namespace)::TransferFunctions::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_117TransferFunctions20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(ObjCMessageExpr /*P*/ ME) {
    // If the Objective-C message expression is an implicit no-return that
    // is not modeled in the CFG, set the tracked dataflow values to Unknown.
    if (objCNoRet.isImplicitNoReturn(ME)) {
      vals.setAllScratchValues(Value.Unknown);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::isTrackedVar">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 518,
   FQN="(anonymous namespace)::TransferFunctions::isTrackedVar", NM="_ZN12_GLOBAL__N_117TransferFunctions12isTrackedVarEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions12isTrackedVarEPKN5clang7VarDeclE")
  //</editor-fold>
  public boolean isTrackedVar(/*const*/ VarDecl /*P*/ vd) {
    return /*::*/UninitializedValuesStatics.isTrackedVar(vd, cast_DeclContext(ac.getDecl()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::findVar">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 522,
   FQN="(anonymous namespace)::TransferFunctions::findVar", NM="_ZN12_GLOBAL__N_117TransferFunctions7findVarEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions7findVarEPKN5clang4ExprE")
  //</editor-fold>
  public FindVarResult findVar(/*const*/ Expr /*P*/ ex) {
    return /*::*/UninitializedValuesStatics.findVar(ex, cast_DeclContext(ac.getDecl()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::getUninitUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 526,
   FQN="(anonymous namespace)::TransferFunctions::getUninitUse", NM="_ZN12_GLOBAL__N_117TransferFunctions12getUninitUseEPKN5clang4ExprEPKNS1_7VarDeclE5Value",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions12getUninitUseEPKN5clang4ExprEPKNS1_7VarDeclE5Value")
  //</editor-fold>
  public UninitUse getUninitUse(/*const*/ Expr /*P*/ ex, /*const*/ VarDecl /*P*/ vd, /*Value*//*uint*/int v) {
    UninitUse Use = null;
    try {
      Use/*J*/= new UninitUse(ex, isAlwaysUninit(v));
      assert (isUninitialized(v));
      if (Use.getKind() == UninitUse.Kind.Always) {
        return new UninitUse(JD$Move.INSTANCE, Use);
      }
      
      // If an edge which leads unconditionally to this use did not initialize
      // the variable, we can say something stronger than 'may be uninitialized':
      // we can say 'either it's used uninitialized or you have dead code'.
      //
      // We track the number of successors of a node which have been visited, and
      // visit a node once we have visited all of its successors. Only edges where
      // the variable might still be uninitialized are followed. Since a variable
      // can't transfer from being initialized to being uninitialized, this will
      // trace out the subgraph which inevitably leads to the use and does not
      // initialize the variable. We do not want to skip past loops, since their
      // non-termination might be correlated with the initialization condition.
      //
      // For example:
      //
      //         void f(bool a, bool b) {
      // block1:   int n;
      //           if (a) {
      // block2:     if (b)
      // block3:       n = 1;
      // block4:   } else if (b) {
      // block5:     while (!a) {
      // block6:       do_work(&a);
      //               n = 2;
      //             }
      //           }
      // block7:   if (a)
      // block8:     g();
      // block9:   return n;
      //         }
      //
      // Starting from the maybe-uninitialized use in block 9:
      //  * Block 7 is not visited because we have only visited one of its two
      //    successors.
      //  * Block 8 is visited because we've visited its only successor.
      // From block 8:
      //  * Block 7 is visited because we've now visited both of its successors.
      // From block 7:
      //  * Blocks 1, 2, 4, 5, and 6 are not visited because we didn't visit all
      //    of their successors (we didn't visit 4, 3, 5, 6, and 5, respectively).
      //  * Block 3 is not visited because it initializes 'n'.
      // Now the algorithm terminates, having visited blocks 7 and 8, and having
      // found the frontier is blocks 2, 4, and 5.
      //
      // 'n' is definitely uninitialized for two edges into block 7 (from blocks 2
      // and 4), so we report that any time either of those edges is taken (in
      // each case when 'b == false'), 'n' is used uninitialized.
      SmallVector</*const*/ CFGBlock /*P*/ > Queue/*J*/= new SmallVector</*const*/ CFGBlock /*P*/ >(32, (/*const*/ CFGBlock /*P*/ )null);
      SmallVectorUInt SuccsVisited/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 32, cfg.getNumBlockIDs(), 0, 0);
      Queue.push_back(block);
      // Specify that we've already visited all successors of the starting block.
      // This has the dual purpose of ensuring we never add it to the queue, and
      // of marking it as not being a candidate element of the frontier.
      SuccsVisited.$set(block.getBlockID(), block.succ_size());
      while (!Queue.empty()) {
        /*const*/ CFGBlock /*P*/ B = Queue.pop_back_val();
        
        // If the use is always reached from the entry block, make a note of that.
        if (B == $AddrOf(cfg.getEntry$Const())) {
          Use.setUninitAfterCall();
        }
        
        for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(B.pred_begin$Const()), /*P*/ E = $tryClone(B.pred_end$Const());
             $noteq_ptr(I, E); I.$preInc()) {
          /*const*/ CFGBlock /*P*/ Pred = I.$star().$CFGBlock$P();
          if (!(Pred != null)) {
            continue;
          }
          
          /*Value*//*uint*/int AtPredExit = vals.getValue(Pred, B, vd);
          if (AtPredExit == Value.Initialized) {
            // This block initializes the variable.
            continue;
          }
          if (AtPredExit == Value.MayUninitialized
             && vals.getValue(B, (/*const*/ CFGBlock /*P*/ )null, vd) == Value.Uninitialized) {
            // This block declares the variable (uninitialized), and is reachable
            // from a block that initializes the variable. We can't guarantee to
            // give an earlier location for the diagnostic (and it appears that
            // this code is intended to be reachable) so give a diagnostic here
            // and go no further down this path.
            Use.setUninitAfterDecl();
            continue;
          }
          
          final uint$ref/*uint &*/ SV = SuccsVisited.ref$at(Pred.getBlockID());
          if (!(SV.$deref() != 0)) {
            // When visiting the first successor of a block, mark all NULL
            // successors as having been visited.
            for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > SI = $tryClone(Pred.succ_begin$Const()), 
                /*P*/ SE = $tryClone(Pred.succ_end$Const());
                 $noteq_ptr(SI, SE); SI.$preInc())  {
              if (!((SI.$star().$CFGBlock$P()) != null)) {
                SV.$set$preInc();
              }
            }
          }
          if (SV.$set$preInc() == Pred.succ_size()) {
            // All paths from this block lead to the use and don't initialize the
            // variable.
            Queue.push_back(Pred);
          }
        }
      }
      
      // Scan the frontier, looking for blocks where the variable was
      // uninitialized.
      for (type$ptr<CFGBlock> BI = $tryClone(cfg.begin$Const()), /*P*/ BE = $tryClone(cfg.end$Const()); $noteq_ptr(BI, BE); BI.$preInc()) {
        /*const*/ CFGBlock /*P*/ Block = BI.$star();
        /*uint*/int BlockID = Block.getBlockID();
        /*const*/ Stmt /*P*/ Term = Block.getTerminator$Const().$Stmt$C$P();
        if ((SuccsVisited.$at(BlockID) != 0) && $less_uint(SuccsVisited.$at(BlockID), Block.succ_size())
           && (Term != null)) {
          // This block inevitably leads to the use. If we have an edge from here
          // to a post-dominator block, and the variable is uninitialized on that
          // edge, we have found a bug.
          for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(Block.succ_begin$Const()), 
              /*P*/ E = $tryClone(Block.succ_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
            /*const*/ CFGBlock /*P*/ Succ = I.$star().$CFGBlock$P();
            if ((Succ != null) && $greatereq_uint(SuccsVisited.$at(Succ.getBlockID()), Succ.succ_size())
               && vals.getValue(Block, Succ, vd) == Value.Uninitialized) {
              // Switch cases are a special case: report the label to the caller
              // as the 'terminator', not the switch statement itself. Suppress
              // situations where no label matched: we can't be sure that's
              // possible.
              if (isa_SwitchStmt(Term)) {
                /*const*/ Stmt /*P*/ Label = Succ.getLabel$Const();
                if (!(Label != null) || !isa_SwitchCase(Label)) {
                  // Might not be possible.
                  continue;
                }
                UninitUse.Branch Branch/*J*/= new UninitUse.Branch();
                Branch.Terminator = Label;
                Branch.Output = 0; // Ignored.
                Use.addUninitBranch(new UninitUse.Branch(Branch));
              } else {
                UninitUse.Branch Branch/*J*/= new UninitUse.Branch();
                Branch.Terminator = Term;
                Branch.Output = I.$sub(Block.succ_begin$Const());
                Use.addUninitBranch(new UninitUse.Branch(Branch));
              }
            }
          }
        }
      }
      
      return new UninitUse(JD$Move.INSTANCE, Use);
    } finally {
      if (Use != null) { Use.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "vals=" + vals // NOI18N
              + ", cfg=" + cfg // NOI18N
              + ", block=" + block // NOI18N
              + ", ac=" + "[AnalysisDeclContext]" // NOI18N
              + ", classification=" + classification // NOI18N
              + ", objCNoRet=" + objCNoRet // NOI18N
              + ", handler=" + "[UninitVariablesHandler]" // NOI18N
              + super.toString(); // NOI18N
  }
}

//------------------------------------------------------------------------====//
// High-level "driver" logic for uninitialized values analysis.
//====------------------------------------------------------------------------//
//<editor-fold defaultstate="collapsed" desc="runOnBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 801,
 FQN="runOnBlock", NM="_ZL10runOnBlockPKN5clang8CFGBlockERKNS_3CFGERNS_19AnalysisDeclContextERN12_GLOBAL__N_114CFGBlockValuesERKNS8_12ClassifyRefsERN4llvm9BitVectorERNS_22UninitVariablesHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZL10runOnBlockPKN5clang8CFGBlockERKNS_3CFGERNS_19AnalysisDeclContextERN12_GLOBAL__N_114CFGBlockValuesERKNS8_12ClassifyRefsERN4llvm9BitVectorERNS_22UninitVariablesHandlerE")
//</editor-fold>
public static boolean runOnBlock(/*const*/ CFGBlock /*P*/ block, final /*const*/ CFG /*&*/ cfg, 
          final AnalysisDeclContext /*&*/ ac, final CFGBlockValues /*&*/ vals, 
          final /*const*/ ClassifyRefs /*&*/ classification, 
          final BitVector /*&*/ wasAnalyzed, 
          final UninitVariablesHandler /*&*/ handler) {
  wasAnalyzed.$at(block.getBlockID()).$assign(/*KEEP_BOOL*/true);
  vals.resetScratch();
  // Merge in values of predecessor blocks.
  boolean isFirst = true;
  for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(block.pred_begin$Const()), 
      /*P*/ E = $tryClone(block.pred_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
    /*const*/ CFGBlock /*P*/ pred = I.$star().$CFGBlock$P();
    if (!(pred != null)) {
      continue;
    }
    if (wasAnalyzed.$at(pred.getBlockID()).$bool()) {
      vals.mergeIntoScratch(vals.getValueVector(pred), isFirst);
      isFirst = false;
    }
  }
  // Apply the transfer function.
  TransferFunctions tf/*J*/= new TransferFunctions(vals, cfg, block, ac, classification, handler);
  for (std.reverse_iterator</*const*/ CFGElement> I = block.begin$Const(), E = block.end$Const();
       $noteq_reverse_iterator$C(I, E); I.$preInc()) {
    {
      Optional<CFGStmt> cs = I.$arrow().getAs(CFGStmt.class);
      if (cs.$bool()) {
        tf.Visit(((/*const_cast*/Stmt /*P*/ )(cs.$arrow().getStmt())));
      }
    }
  }
  return vals.updateValueVectorWithScratch(block);
}

} // END OF class UninitializedValuesStatics
