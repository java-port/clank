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

package org.clang.analysis.analyses.consumed;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.consumed.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.impl.ConsumedStatics.*;
import static org.clang.analysis.consumed.impl.ConsumedStatics.*;
import org.clang.analysis.consumed.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// A class that handles the analysis of uniqueness violations.
//<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedAnalyzer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 238,
 FQN="clang::consumed::ConsumedAnalyzer", NM="_ZN5clang8consumed16ConsumedAnalyzerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed16ConsumedAnalyzerE")
//</editor-fold>
public class ConsumedAnalyzer implements Destructors.ClassWithDestructor {
  
  private ConsumedBlockInfo BlockInfo;
  private std.unique_ptr<ConsumedStateMap> CurrStates;
  
  private ConsumedState ExpectedReturnState;
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedAnalyzer::determineExpectedReturnState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1230,
   FQN="clang::consumed::ConsumedAnalyzer::determineExpectedReturnState", NM="_ZN5clang8consumed16ConsumedAnalyzer28determineExpectedReturnStateERNS_19AnalysisDeclContextEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedAnalyzer28determineExpectedReturnStateERNS_19AnalysisDeclContextEPKNS_12FunctionDeclE")
  //</editor-fold>
  private void determineExpectedReturnState(final AnalysisDeclContext /*&*/ AC, 
                              /*const*/ FunctionDecl /*P*/ D) {
    QualType ReturnType/*J*/= new QualType();
    {
      /*const*/ CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(D);
      if ((Constructor != null)) {
        final ASTContext /*&*/ CurrContext = AC.getASTContext();
        ReturnType.$assignMove(Constructor.getThisType(CurrContext).$arrow().getPointeeType());
      } else {
        ReturnType.$assignMove(D.getCallResultType());
      }
    }
    {
      
      /*const*/ ReturnTypestateAttr /*P*/ RTSAttr = D.getAttr(ReturnTypestateAttr.class);
      if ((RTSAttr != null)) {
        /*const*/ CXXRecordDecl /*P*/ RD = ReturnType.$arrow().getAsCXXRecordDecl();
        if (!(RD != null) || !RD.hasAttr(ConsumableAttr.class)) {
          // FIXME: This should be removed when template instantiation propagates
          //        attributes at template specialization definition, not
          //        declaration. When it is removed the test needs to be enabled
          //        in SemaDeclAttr.cpp.
          WarningsHandler.warnReturnTypestateForUnconsumableType(RTSAttr.getLocation(), new StringRef(ReturnType.getAsString()));
          ExpectedReturnState = ConsumedState.CS_None;
        } else {
          ExpectedReturnState = mapReturnTypestateAttrState(RTSAttr);
        }
      } else if (isConsumableType(ReturnType)) {
        if (isAutoCastType(ReturnType)) { // We can auto-cast the state to the
          ExpectedReturnState = ConsumedState.CS_None; // expected state.
        } else {
          ExpectedReturnState = mapConsumableAttrState(new QualType(ReturnType));
        }
      } else {
        ExpectedReturnState = ConsumedState.CS_None;
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedAnalyzer::splitState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1261,
   FQN="clang::consumed::ConsumedAnalyzer::splitState", NM="_ZN5clang8consumed16ConsumedAnalyzer10splitStateEPKNS_8CFGBlockERKNS0_19ConsumedStmtVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedAnalyzer10splitStateEPKNS_8CFGBlockERKNS0_19ConsumedStmtVisitorE")
  //</editor-fold>
  private boolean splitState(/*const*/ CFGBlock /*P*/ CurrBlock, 
            final /*const*/ ConsumedStmtVisitor /*&*/ Visitor) {
    std.unique_ptr<ConsumedStateMap> FalseStates = null;
    try {
      
      FalseStates/*J*/= new std.unique_ptr<ConsumedStateMap>(new ConsumedStateMap(CurrStates.$star()));
      PropagationInfo PInfo/*J*/= new PropagationInfo();
      {
        
        /*const*/ IfStmt /*P*/ IfNode = dyn_cast_or_null_IfStmt(CurrBlock.getTerminator$Const().getStmt$Const());
        if ((IfNode != null)) {
          
          /*const*/ Expr /*P*/ Cond = IfNode.getCond$Const();
          
          PInfo.$assignMove(Visitor.getInfo$Const(Cond));
          if (!PInfo.isValid() && isa_BinaryOperator(Cond)) {
            PInfo.$assignMove(Visitor.getInfo$Const(cast_BinaryOperator(Cond).getRHS()));
          }
          if (PInfo.isVarTest()) {
            CurrStates.$arrow().setSource(Cond);
            FalseStates.$arrow().setSource(Cond);
            splitVarStateForIf(IfNode, PInfo.getVarTest(), CurrStates.get(), 
                FalseStates.get());
          } else if (PInfo.isBinTest()) {
            CurrStates.$arrow().setSource(PInfo.testSourceNode());
            FalseStates.$arrow().setSource(PInfo.testSourceNode());
            splitVarStateForIfBinOp(PInfo, CurrStates.get(), FalseStates.get());
          } else {
            return false;
          }
        } else {
          /*const*/ BinaryOperator /*P*/ BinOp = dyn_cast_or_null_BinaryOperator(CurrBlock.getTerminator$Const().getStmt$Const());
          if ((BinOp != null)) {
            
            PInfo.$assignMove(Visitor.getInfo$Const(BinOp.getLHS()));
            if (!PInfo.isVarTest()) {
              if (((BinOp = dyn_cast_or_null_BinaryOperator(BinOp.getLHS())) != null)) {
                PInfo.$assignMove(Visitor.getInfo$Const(BinOp.getRHS()));
                if (!PInfo.isVarTest()) {
                  return false;
                }
              } else {
                return false;
              }
            }
            
            CurrStates.$arrow().setSource(BinOp);
            FalseStates.$arrow().setSource(BinOp);
            
            final /*const*/ VarTestResult /*&*/ Test = PInfo.getVarTest();
            ConsumedState VarState = CurrStates.$arrow().getState(Test.Var);
            if (BinOp.getOpcode() == BinaryOperatorKind.BO_LAnd) {
              if (VarState == ConsumedState.CS_Unknown) {
                CurrStates.$arrow().setState(Test.Var, Test.TestsFor);
              } else if (VarState == invertConsumedUnconsumed(Test.TestsFor)) {
                CurrStates.$arrow().markUnreachable();
              }
            } else if (BinOp.getOpcode() == BinaryOperatorKind.BO_LOr) {
              if (VarState == ConsumedState.CS_Unknown) {
                FalseStates.$arrow().setState(Test.Var, 
                    invertConsumedUnconsumed(Test.TestsFor));
              } else if (VarState == Test.TestsFor) {
                FalseStates.$arrow().markUnreachable();
              }
            }
          } else {
            return false;
          }
        }
      }
      
      type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > SI = $tryClone(CurrBlock.succ_begin$Const());
      if (((SI.$star().$CFGBlock$P()) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          BlockInfo.addInfo(SI.$star().$CFGBlock$P(), $c$.track(new std.unique_ptr<ConsumedStateMap>(JD$Move.INSTANCE, std.move(CurrStates)))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      } else {
        CurrStates.$assign_nullptr_t(null);
      }
      if (((SI.$preInc().$star().$CFGBlock$P()) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          BlockInfo.addInfo(SI.$star().$CFGBlock$P(), $c$.track(new std.unique_ptr<ConsumedStateMap>(JD$Move.INSTANCE, std.move(FalseStates)))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      
      return true;
    } finally {
      if (FalseStates != null) { FalseStates.$destroy(); }
    }
  }


/*public:*/
  
  public final ConsumedWarningsHandlerBase /*&*/ WarningsHandler;
  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedAnalyzer::ConsumedAnalyzer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 254,
   FQN="clang::consumed::ConsumedAnalyzer::ConsumedAnalyzer", NM="_ZN5clang8consumed16ConsumedAnalyzerC1ERNS0_27ConsumedWarningsHandlerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed16ConsumedAnalyzerC1ERNS0_27ConsumedWarningsHandlerBaseE")
  //</editor-fold>
  public ConsumedAnalyzer(final ConsumedWarningsHandlerBase /*&*/ WarningsHandler) {
    // : BlockInfo(), CurrStates(), WarningsHandler(WarningsHandler) 
    //START JInit
    this.BlockInfo = new ConsumedBlockInfo();
    this.CurrStates = new std.unique_ptr<ConsumedStateMap>();
    this./*&*/WarningsHandler=/*&*/WarningsHandler;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedAnalyzer::getExpectedReturnState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 257,
   FQN="clang::consumed::ConsumedAnalyzer::getExpectedReturnState", NM="_ZNK5clang8consumed16ConsumedAnalyzer22getExpectedReturnStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang8consumed16ConsumedAnalyzer22getExpectedReturnStateEv")
  //</editor-fold>
  public ConsumedState getExpectedReturnState() /*const*/ {
    return ExpectedReturnState;
  }

  
  /// \brief Check a function's CFG for consumed violations.
  ///
  /// We traverse the blocks in the CFG, keeping track of the state of each
  /// value who's type has uniquness annotations.  If methods are invoked in
  /// the wrong state a warning is issued.  Each block in the CFG is traversed
  /// exactly once.
  
  /// \brief Check a function's CFG for consumed violations.
  ///
  /// We traverse the blocks in the CFG, keeping track of the state of each
  /// value who's type has uniquness annotations.  If methods are invoked in
  /// the wrong state a warning is issued.  Each block in the CFG is traversed
  /// exactly once.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedAnalyzer::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1345,
   FQN="clang::consumed::ConsumedAnalyzer::run", NM="_ZN5clang8consumed16ConsumedAnalyzer3runERNS_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed16ConsumedAnalyzer3runERNS_19AnalysisDeclContextE")
  //</editor-fold>
  public void run(final AnalysisDeclContext /*&*/ AC) {
    ConsumedStmtVisitor Visitor = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ FunctionDecl /*P*/ D = dyn_cast_or_null_FunctionDecl(AC.getDecl());
      if (!(D != null)) {
        return;
      }
      
      CFG /*P*/ CFGraph = AC.getCFG();
      if (!(CFGraph != null)) {
        return;
      }
      
      determineExpectedReturnState(AC, D);
      
      PostOrderCFGView /*P*/ SortedGraph = AC.<PostOrderCFGView>getAnalysis(PostOrderCFGView.class);
      // AC.getCFG()->viewCFG(LangOptions());
      $c$.clean(BlockInfo.$assignMove($c$.track(new ConsumedBlockInfo(CFGraph.getNumBlockIDs(), SortedGraph))));
      
      $c$.clean(CurrStates.$assignMove($c$.track(llvm.make_unique(new ConsumedStateMap()))));
      Visitor/*J*/= new ConsumedStmtVisitor(AC, /*Deref*/this, CurrStates.get());
      
      // Add all trackable parameters to the state map.
      for (/*const*/ ParmVarDecl /*P*/ PI : D.parameters$Const())  {
        Visitor.VisitParmVarDecl(PI);
      }
      
      // Visit all of the function's basic blocks.
      for (/*const*/ CFGBlock /*P*/ CurrBlock : $Deref(SortedGraph)) {
        if (!CurrStates.$bool()) {
          $c$.clean(CurrStates.$assignMove($c$.track(BlockInfo.getInfo(CurrBlock))));
        }
        if (!CurrStates.$bool()) {
          continue;
        } else if (!CurrStates.$arrow().isReachable()) {
          CurrStates.$assign_nullptr_t(null);
          continue;
        }
        
        Visitor.reset(CurrStates.get());
        
        // Visit all of the basic block's statements.
        for (final /*const*/ CFGElement /*&*/ B : $Deref(CurrBlock)) {
          switch (B.getKind()) {
           case Statement:
            Visitor.Visit(B.castAs(CFGStmt.class).getStmt());
            break;
           case TemporaryDtor:
            {
              final /*const*/ CFGTemporaryDtor /*&*/ DTor = B.castAs(CFGTemporaryDtor.class);
              /*const*/ CXXBindTemporaryExpr /*P*/ BTE = DTor.getBindTemporaryExpr();
              
              Visitor.checkCallability(new PropagationInfo(BTE), 
                  DTor.getDestructorDecl(AC.getASTContext()), 
                  BTE.getExprLoc());
              CurrStates.$arrow().remove(BTE);
              break;
            }
           case AutomaticObjectDtor:
            {
              final /*const*/ CFGAutomaticObjDtor /*&*/ DTor = B.castAs(CFGAutomaticObjDtor.class);
              SourceLocation Loc = DTor.getTriggerStmt().getLocEnd();
              /*const*/ VarDecl /*P*/ Var = DTor.getVarDecl();
              
              Visitor.checkCallability(new PropagationInfo(Var), 
                  DTor.getDestructorDecl(AC.getASTContext()), 
                  new SourceLocation(Loc));
              break;
            }
           default:
            break;
          }
        }
        
        // TODO: Handle other forms of branching with precision, including while-
        //       and for-loops. (Deferred)
        if (!splitState(CurrBlock, Visitor)) {
          CurrStates.$arrow().setSource((/*const*/ Stmt /*P*/ )null);
          if ($greater_uint(CurrBlock.succ_size(), 1)
             || (CurrBlock.succ_size() == 1
             && $greater_uint((CurrBlock.succ_begin$Const().$star()).$arrow().pred_size(), 1))) {
            
            ConsumedStateMap /*P*/ RawState = CurrStates.get();
            
            for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > SI = $tryClone(CurrBlock.succ_begin$Const()), 
                /*P*/ SE = $tryClone(CurrBlock.succ_end$Const()); $noteq_ptr(SI, SE); SI.$preInc()) {
              if (SI.$star().$CFGBlock$P() == null) {
                continue;
              }
              if (BlockInfo.isBackEdge(CurrBlock, SI.$star().$CFGBlock$P())) {
                BlockInfo.borrowInfo(SI.$star().$CFGBlock$P()).intersectAtLoopHead(SI.$star().$CFGBlock$P(), CurrBlock, RawState, WarningsHandler);
                if (BlockInfo.allBackEdgesVisited(CurrBlock, SI.$star().$CFGBlock$P())) {
                  BlockInfo.discardInfo(SI.$star().$CFGBlock$P());
                }
              } else {
                BlockInfo.addInfo(SI.$star().$CFGBlock$P(), RawState, CurrStates);
              }
            }
            
            CurrStates.$assign_nullptr_t(null);
          }
        }
        if (CurrBlock == $AddrOf(AC.getCFG().getExit())
           && D.getCallResultType().$arrow().isVoidType()) {
          CurrStates.$arrow().checkParamsForReturnTypestate(D.getLocation(), 
              WarningsHandler);
        }
      } // End of block iterator.
      
      // Delete the last existing state map.
      CurrStates.$assign_nullptr_t(null);
      
      WarningsHandler.emitDiagnostics();
    } finally {
      if (Visitor != null) { Visitor.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedAnalyzer::~ConsumedAnalyzer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 238,
   FQN="clang::consumed::ConsumedAnalyzer::~ConsumedAnalyzer", NM="_ZN5clang8consumed16ConsumedAnalyzerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed16ConsumedAnalyzerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CurrStates.$destroy();
    BlockInfo.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "BlockInfo=" + BlockInfo // NOI18N
              + ", CurrStates=" + CurrStates // NOI18N
              + ", ExpectedReturnState=" + ExpectedReturnState // NOI18N
              + ", WarningsHandler=" + WarningsHandler; // NOI18N
  }
}
