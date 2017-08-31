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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.impl.LiveVariablesStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type LiveVariablesStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=Tpl__ZN12_GLOBAL__N_19mergeSetsET_S0_;_ZL11AddLiveStmtRN4llvm12ImmutableSetIPKN5clang4StmtENS_17ImutContainerInfoIS4_EEEERNS7_7FactoryES4_;_ZL13isAlwaysAlivePKN5clang7VarDeclE;_ZL15LookThroughStmtPKN5clang4StmtE;_ZL6FindVAN5clang8QualTypeE;_ZL7getImplPv;_ZN12_GLOBAL__N_116DataflowWorklistE;_ZN12_GLOBAL__N_117TransferFunctionsE; -static-type=LiveVariablesStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class LiveVariablesStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 30,
 FQN="(anonymous namespace)::DataflowWorklist", NM="_ZN12_GLOBAL__N_116DataflowWorklistE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklistE")
//</editor-fold>
public static class DataflowWorklist implements Destructors.ClassWithDestructor {
  private SmallVector</*const*/ CFGBlock /*P*/ > worklist;
  private BitVector enqueuedBlocks;
  private PostOrderCFGView /*P*/ POV;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::DataflowWorklist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 35,
   FQN="(anonymous namespace)::DataflowWorklist::DataflowWorklist", NM="_ZN12_GLOBAL__N_116DataflowWorklistC1ERKN5clang3CFGERNS1_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklistC1ERKN5clang3CFGERNS1_19AnalysisDeclContextE")
  //</editor-fold>
  public DataflowWorklist(final /*const*/ CFG /*&*/ cfg, final AnalysisDeclContext /*&*/ Ctx) {
    // : worklist(), enqueuedBlocks(cfg.getNumBlockIDs()), POV(Ctx.getAnalysis<PostOrderCFGView>()) 
    //START JInit
    this.worklist = new SmallVector</*const*/ CFGBlock /*P*/ >(20, (/*const*/ CFGBlock /*P*/ )null);
    this.enqueuedBlocks = new BitVector(cfg.getNumBlockIDs());
    this.POV = Ctx.<PostOrderCFGView>getAnalysis(PostOrderCFGView.class);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::enqueueBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 49,
   FQN="(anonymous namespace)::DataflowWorklist::enqueueBlock", NM="_ZN12_GLOBAL__N_116DataflowWorklist12enqueueBlockEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklist12enqueueBlockEPKN5clang8CFGBlockE")
  //</editor-fold>
  public void enqueueBlock(/*const*/ CFGBlock /*P*/ block) {
    if ((block != null) && !enqueuedBlocks.$at(block.getBlockID()).$bool()) {
      enqueuedBlocks.$at(block.getBlockID()).$assign(/*KEEP_BOOL*/true);
      worklist.push_back(block);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::enqueuePredecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 56,
   FQN="(anonymous namespace)::DataflowWorklist::enqueuePredecessors", NM="_ZN12_GLOBAL__N_116DataflowWorklist19enqueuePredecessorsEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklist19enqueuePredecessorsEPKN5clang8CFGBlockE")
  //</editor-fold>
  public void enqueuePredecessors(/*const*/ CFGBlock /*P*/ block) {
    /*const*//*uint*/int OldWorklistSize = worklist.size();
    for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(block.pred_begin$Const()), 
        /*P*/ E = $tryClone(block.pred_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      enqueueBlock(I.$star().$CFGBlock$P());
    }
    if (OldWorklistSize == 0 || OldWorklistSize == worklist.size()) {
      return;
    }
    
    sortWorklist();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::dequeue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 73,
   FQN="(anonymous namespace)::DataflowWorklist::dequeue", NM="_ZN12_GLOBAL__N_116DataflowWorklist7dequeueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklist7dequeueEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ dequeue() {
    if (worklist.empty()) {
      return null;
    }
    /*const*/ CFGBlock /*P*/ b = worklist.pop_back_val();
    enqueuedBlocks.$at(b.getBlockID()).$assign(/*KEEP_BOOL*/false);
    return b;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::sortWorklist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 69,
   FQN="(anonymous namespace)::DataflowWorklist::sortWorklist", NM="_ZN12_GLOBAL__N_116DataflowWorklist12sortWorklistEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklist12sortWorklistEv")
  //</editor-fold>
  public void sortWorklist() {
    std.sort(worklist.begin(), worklist.end(), POV.getComparator());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::~DataflowWorklist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 30,
   FQN="(anonymous namespace)::DataflowWorklist::~DataflowWorklist", NM="_ZN12_GLOBAL__N_116DataflowWorklistD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklistD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    enqueuedBlocks.$destroy();
    worklist.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataflowWorklist::DataflowWorklist">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 212,
   FQN="(anonymous namespace)::DataflowWorklist::DataflowWorklist", NM="_ZN12_GLOBAL__N_116DataflowWorklistC1ERKN5clang3CFGERNS1_16PostOrderCFGViewE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_116DataflowWorklistC1ERKN5clang3CFGERNS1_16PostOrderCFGViewE")
  //</editor-fold>
  public DataflowWorklist(final /*const*/ CFG /*&*/ cfg, final PostOrderCFGView /*&*/ view) {
    // : PO_I(view.begin()), PO_E(view.end()), worklist(), enqueuedBlocks(cfg.getNumBlockIDs(), true) 
    //START JInit
    std.reverse_iterator</*const*/ CFGBlock /*&*/ > PO_I = view.begin();
    std.reverse_iterator</*const*/ CFGBlock /*&*/ > PO_E = view.end();
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
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
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

  
  @Override public String toString() {
    return "" + "worklist=" + worklist // NOI18N
              + ", enqueuedBlocks=" + enqueuedBlocks // NOI18N
              + ", POV=" + POV; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="getImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 111,
 FQN="getImpl", NM="_ZL7getImplPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZL7getImplPv")
//</editor-fold>
public static LiveVariablesImpl /*&*/ getImpl(Object/*void P*/ x) {
  return $Deref(((LiveVariablesImpl /*P*/ )x));
}

/*template <typename SET> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::mergeSets">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 129,
 FQN="(anonymous namespace)::mergeSets", NM="Tpl__ZN12_GLOBAL__N_19mergeSetsET_S0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=Tpl__ZN12_GLOBAL__N_19mergeSetsET_S0_")
//</editor-fold>
public static <T> ImmutableSetRef<T> mergeSets(ImmutableSetRef<T> A, ImmutableSetRef<T> B) {
  if (A.isEmpty()) {
    return new ImmutableSetRef</*const*/ T /*P*/>(B);
  }
  ImutAVLValueIteratorTypeBoolType<T> it = null;
  ImutAVLValueIteratorTypeBoolType<T> ei = null;
  try {
    
    for (it = B.begin(), ei = B.end(); it.$noteq(ei); it.$preInc()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(A.$assign($c$.track(A.add(it.$star()))));
      } finally {
        $c$.$destroy();
      }
    }
  } finally {
    if (ei != null) { ei.$destroy(); }
    if (it != null) { it.$destroy(); }
  }
  return new ImmutableSetRef</*const*/ T /*P*/>(A);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static <T> ImmutableSetRefPtr<T> mergeSets(ImmutableSetRefPtr<T> A, ImmutableSetRefPtr<T> B) {
  if (A.isEmpty()) {
    return new ImmutableSetRefPtr</*const*/ T /*P*/>(B);
  }
  ImutAVLValueIteratorPtrBoolPtr<T> it = null;
  ImutAVLValueIteratorPtrBoolPtr<T> ei = null;
  try {
    
    for (it = B.begin(), ei = B.end(); it.$noteq(ei); it.$preInc()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(A.$assign($c$.track(A.add(it.$star()))));
      } finally {
        $c$.$destroy();
      }
    }
  } finally {
    if (ei != null) { ei.$destroy(); }
    if (it != null) { it.$destroy(); }
  }
  return new ImmutableSetRefPtr</*const*/ T /*P*/>(A);
}

//===----------------------------------------------------------------------===//
// Query methods.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="isAlwaysAlive">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 173,
 FQN="isAlwaysAlive", NM="_ZL13isAlwaysAlivePKN5clang7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZL13isAlwaysAlivePKN5clang7VarDeclE")
//</editor-fold>
public static boolean isAlwaysAlive(/*const*/ VarDecl /*P*/ D) {
  return D.hasGlobalStorage();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 194,
 FQN="(anonymous namespace)::TransferFunctions", NM="_ZN12_GLOBAL__N_117TransferFunctionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctionsE")
//</editor-fold>
public static class TransferFunctions implements /*public*/ StmtVisitorVoid<TransferFunctions> {
  private final LiveVariablesImpl /*&*/ LV;
  private final LiveVariables.LivenessValues /*&*/ val;
  private LiveVariables.Observer /*P*/ observer;
  private /*const*/ CFGBlock /*P*/ currentBlock;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::TransferFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 200,
   FQN="(anonymous namespace)::TransferFunctions::TransferFunctions", NM="_ZN12_GLOBAL__N_117TransferFunctionsC1ERNS_17LiveVariablesImplERN5clang13LiveVariables14LivenessValuesEPNS4_8ObserverEPKNS3_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctionsC1ERNS_17LiveVariablesImplERN5clang13LiveVariables14LivenessValuesEPNS4_8ObserverEPKNS3_8CFGBlockE")
  //</editor-fold>
  public TransferFunctions(final LiveVariablesImpl /*&*/ im, 
      final LiveVariables.LivenessValues /*&*/ Val, 
      LiveVariables.Observer /*P*/ Observer, 
      /*const*/ CFGBlock /*P*/ CurrentBlock) {
    // : StmtVisitor<TransferFunctions>(), LV(im), val(Val), observer(Observer), currentBlock(CurrentBlock) 
    //START JInit
    $StmtVisitor();
    this./*&*/LV=/*&*/im;
    this./*&*/val=/*&*/Val;
    this.observer = Observer;
    this.currentBlock = CurrentBlock;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 332,
   FQN="(anonymous namespace)::TransferFunctions::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_117TransferFunctions19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ B) {
    if (B.isAssignmentOp()) {
      if (!LV.killAtAssign) {
        return;
      }
      
      // Assigning to a variable?
      Expr /*P*/ LHS = B.getLHS().IgnoreParens();
      {
        
        DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(LHS);
        if ((DR != null)) {
          {
            /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl());
            if ((VD != null)) {
              // Assignments to references don't kill the ref's address
              if (VD.getType().$arrow().isReferenceType()) {
                return;
              }
              if (!isAlwaysAlive(VD)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // The variable is now dead.
                  $c$.clean(val.liveDecls.$assign($c$.track(LV.DSetFact.remove($c$.track(new ImmutableSetPtr</*const*/ VarDecl /*P*/ >(val.liveDecls)), VD))));
                } finally {
                  $c$.$destroy();
                }
              }
              if ((observer != null)) {
                observer.observerKill(DR);
              }
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 357,
   FQN="(anonymous namespace)::TransferFunctions::VisitBlockExpr", NM="_ZN12_GLOBAL__N_117TransferFunctions14VisitBlockExprEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions14VisitBlockExprEPN5clang9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(BlockExpr /*P*/ BE) {
    for (/*const*/ VarDecl /*P*/ VD : LV.analysisContext.getReferencedBlockVars(BE.getBlockDecl())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (isAlwaysAlive(VD)) {
          continue;
        }
        $c$.clean(val.liveDecls.$assign($c$.track(LV.DSetFact.add($c$.track(new ImmutableSetPtr</*const*/ VarDecl /*P*/ >(val.liveDecls)), VD))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 366,
   FQN="(anonymous namespace)::TransferFunctions::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_117TransferFunctions16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ DR) {
    {
      /*const*/ VarDecl /*P*/ D = dyn_cast_VarDecl(DR.getDecl());
      if ((D != null)) {
        if (!isAlwaysAlive(D) && LV.inAssignment.find(DR).$eq(/*NO_ITER_COPY*/LV.inAssignment.end())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(val.liveDecls.$assign($c$.track(LV.DSetFact.add($c$.track(new ImmutableSetPtr</*const*/ VarDecl /*P*/ >(val.liveDecls)), D))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 372,
   FQN="(anonymous namespace)::TransferFunctions::VisitDeclStmt", NM="_ZN12_GLOBAL__N_117TransferFunctions13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ DS) {
    for (/*const*/ Decl /*P*/ DI : DS.decls())  {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DI);
        if ((VD != null)) {
          if (!isAlwaysAlive(VD)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(val.liveDecls.$assign($c$.track(LV.DSetFact.remove($c$.track(new ImmutableSetPtr</*const*/ VarDecl /*P*/ >(val.liveDecls)), VD))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 380,
   FQN="(anonymous namespace)::TransferFunctions::VisitObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_117TransferFunctions26VisitObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions26VisitObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ OS) {
    // Kill the iteration variable.
    DeclRefExpr /*P*/ DR = null;
    /*const*/ VarDecl /*P*/ VD = null;
    
    Stmt /*P*/ element = OS.getElement();
    {
      DeclStmt /*P*/ DS = dyn_cast_DeclStmt(element);
      if ((DS != null)) {
        VD = cast_VarDecl(DS.getSingleDecl());
      } else if (((DR = dyn_cast_DeclRefExpr(cast_Expr(element).IgnoreParens())) != null)) {
        VD = cast_VarDecl(DR.getDecl());
      }
    }
    if ((VD != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(val.liveDecls.$assign($c$.track(LV.DSetFact.remove($c$.track(new ImmutableSetPtr</*const*/ VarDecl /*P*/ >(val.liveDecls)), VD))));
        if ((observer != null) && (DR != null)) {
          observer.observerKill(DR);
        }
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 400,
   FQN="(anonymous namespace)::TransferFunctions::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_117TransferFunctions29VisitUnaryExprOrTypeTraitExprEPN5clang24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions29VisitUnaryExprOrTypeTraitExprEPN5clang24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr /*P*/ UE) {
    // While sizeof(var) doesn't technically extend the liveness of 'var', it
    // does extent the liveness of metadata if 'var' is a VariableArrayType.
    // We handle that special case here.
    if (UE.getKind() != UnaryExprOrTypeTrait.UETT_SizeOf || UE.isArgumentType()) {
      return;
    }
    
    /*const*/ Expr /*P*/ subEx = UE.getArgumentExpr();
    if (subEx.getType().$arrow().isVariableArrayType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert (subEx.isLValue());
        $c$.clean(val.liveStmts.$assign($c$.track(LV.SSetFact.add($c$.track(new ImmutableSetPtr</*const*/ Stmt /*P*/ >(val.liveStmts)), subEx.IgnoreParens$Const()))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 416,
   FQN="(anonymous namespace)::TransferFunctions::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_117TransferFunctions18VisitUnaryOperatorEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions18VisitUnaryOperatorEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ UO) {
    // Treat ++/-- as a kill.
    // Note we don't actually have to do anything if we don't have an observer,
    // since a ++/-- acts as both a kill and a "use".
    if (!(observer != null)) {
      return;
    }
    switch (UO.getOpcode()) {
     default:
      return;
     case UO_PostInc:
     case UO_PostDec:
     case UO_PreInc:
     case UO_PreDec:
      break;
    }
    {
      
      DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(UO.getSubExpr().IgnoreParens());
      if ((DR != null)) {
        if (isa_VarDecl(DR.getDecl())) {
          // Treat ++/-- as a kill.
          observer.observerKill(DR);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransferFunctions::Visit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 253,
   FQN="(anonymous namespace)::TransferFunctions::Visit", NM="_ZN12_GLOBAL__N_117TransferFunctions5VisitEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117TransferFunctions5VisitEPN5clang4StmtE")
  //</editor-fold>
  public void Visit(Stmt /*P*/ S) {
    if ((observer != null)) {
      observer.observeStmt(S, currentBlock, val);
    }
    
    StmtVisitorVoid.super.Visit(S);
    if (isa_Expr(S)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(val.liveStmts.$assign($c$.track(LV.SSetFact.remove($c$.track(new ImmutableSetPtr</*const*/ Stmt /*P*/ >(val.liveStmts)), S))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Mark all children expressions live.
    switch (S.getStmtClass()) {
     default:
      break;
     case StmtExprClass:
      {
        // For statement expressions, look through the compound statement.
        S = cast_StmtExpr(S).getSubStmt();
        break;
      }
     case CXXMemberCallExprClass:
      {
        // Include the implicit "this" pointer as being live.
        CXXMemberCallExpr /*P*/ CE = cast_CXXMemberCallExpr(S);
        {
          Expr /*P*/ ImplicitObj = CE.getImplicitObjectArgument();
          if ((ImplicitObj != null)) {
            AddLiveStmt(val.liveStmts, LV.SSetFact, ImplicitObj);
          }
        }
        break;
      }
     case ObjCMessageExprClass:
      {
        // In calls to super, include the implicit "self" pointer as being live.
        ObjCMessageExpr /*P*/ CE = cast_ObjCMessageExpr(S);
        if (CE.getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperInstance) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(val.liveDecls.$assign($c$.track(LV.DSetFact.add($c$.track(new ImmutableSetPtr</*const*/ VarDecl /*P*/ >(val.liveDecls)), 
                    LV.analysisContext.getSelfDecl()))));
          } finally {
            $c$.$destroy();
          }
        }
        break;
      }
     case DeclStmtClass:
      {
        /*const*/ DeclStmt /*P*/ DS = cast_DeclStmt(S);
        {
          /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DS.getSingleDecl$Const());
          if ((VD != null)) {
            for (/*const*/ VariableArrayType /*P*/ VA = FindVA(VD.getType());
                 VA != null; VA = FindVA(VA.getElementType())) {
              AddLiveStmt(val.liveStmts, LV.SSetFact, VA.getSizeExpr());
            }
          }
        }
        break;
      }
     case PseudoObjectExprClass:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // A pseudo-object operation only directly consumes its result
          // expression.
          Expr /*P*/ child = cast_PseudoObjectExpr(S).getResultExpr();
          if (!(child != null)) {
            return;
          }
          {
            OpaqueValueExpr /*P*/ OV = dyn_cast_OpaqueValueExpr(child);
            if ((OV != null)) {
              child = OV.getSourceExpr();
            }
          }
          child = child.IgnoreParens();
          $c$.clean(val.liveStmts.$assign($c$.track(LV.SSetFact.add($c$.track(new ImmutableSetPtr</*const*/ Stmt /*P*/ >(val.liveStmts)), child))));
          return;
        } finally {
          $c$.$destroy();
        }
      }
     case ExprWithCleanupsClass:
      {
        S = cast_ExprWithCleanups(S).getSubExpr();
        break;
      }
     case CXXBindTemporaryExprClass:
      {
        S = cast_CXXBindTemporaryExpr(S).getSubExpr();
        break;
      }
     case UnaryExprOrTypeTraitExprClass:
      {
        // No need to unconditionally visit subexpressions.
        return;
      }
    }
    
    for (Stmt /*P*/ Child : S.children()) {
      if ((Child != null)) {
        AddLiveStmt(val.liveStmts, LV.SSetFact, Child);
      }
    }
  }

  
  @Override public String toString() {
    return "" + "LV=" + LV // NOI18N
              + ", val=" + val // NOI18N
              + ", observer=" + observer // NOI18N
              + ", currentBlock=" + currentBlock // NOI18N
              + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="FindVA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 217,
 FQN="FindVA", NM="_ZL6FindVAN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZL6FindVAN5clang8QualTypeE")
//</editor-fold>
public static /*const*/ VariableArrayType /*P*/ FindVA(QualType Ty) {
  /*const*/ Type /*P*/ ty = Ty.getTypePtr();
  {
    /*const*/ ArrayType /*P*/ VT;
    while (((/*P*/ VT = dyn_cast_ArrayType(ty)) != null)) {
      {
        /*const*/ VariableArrayType /*P*/ VAT = dyn_cast_VariableArrayType(VT);
        if ((VAT != null)) {
          if ((VAT.getSizeExpr() != null)) {
            return VAT;
          }
        }
      }
      
      ty = VT.getElementType().getTypePtr();
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="LookThroughStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 230,
 FQN="LookThroughStmt", NM="_ZL15LookThroughStmtPKN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZL15LookThroughStmtPKN5clang4StmtE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ LookThroughStmt(/*const*/ Stmt /*P*/ S) {
  while ((S != null)) {
    {
      /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(S);
      if ((Ex != null)) {
        S = Ex.IgnoreParens$Const();
      }
    }
    {
      /*const*/ ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(S);
      if ((EWC != null)) {
        S = EWC.getSubExpr$Const();
        continue;
      }
    }
    {
      /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(S);
      if ((OVE != null)) {
        S = OVE.getSourceExpr();
        continue;
      }
    }
    break;
  }
  return S;
}

//<editor-fold defaultstate="collapsed" desc="AddLiveStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 247,
 FQN="AddLiveStmt", NM="_ZL11AddLiveStmtRN4llvm12ImmutableSetIPKN5clang4StmtENS_17ImutContainerInfoIS4_EEEERNS7_7FactoryES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZL11AddLiveStmtRN4llvm12ImmutableSetIPKN5clang4StmtENS_17ImutContainerInfoIS4_EEEERNS7_7FactoryES4_")
//</editor-fold>
public static void AddLiveStmt(final ImmutableSetPtr</*const*/ Stmt /*P*/ > /*&*/ Set, 
           final ImmutableSetPtr.Factory</*const*/ Stmt /*P*/> F, 
           /*const*/ Stmt /*P*/ S) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean(Set.$assign($c$.track(F.add($c$.track(new ImmutableSetPtr</*const*/ Stmt /*P*/ >(Set)), LookThroughStmt(S)))));
  } finally {
    $c$.$destroy();
  }
}

} // END OF class LiveVariablesStatics
