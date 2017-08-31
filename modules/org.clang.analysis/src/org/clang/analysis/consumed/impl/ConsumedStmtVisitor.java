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

package org.clang.analysis.consumed.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.consumed.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.impl.ConsumedStatics.*;
import static org.clang.analysis.consumed.impl.ConsumedStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 456,
 FQN="clang::consumed::ConsumedStmtVisitor", NM="_ZN5clang8consumed19ConsumedStmtVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitorE")
//</editor-fold>
public class ConsumedStmtVisitor implements /*public*/ ConstStmtVisitorVoid<ConsumedStmtVisitor>, Destructors.ClassWithDestructor {
  
  /*typedef llvm::DenseMap<const Stmt *, PropagationInfo> MapType*/
//  public final class MapType extends DenseMap</*const*/ Stmt /*P*/ , PropagationInfo>{ };
  /*typedef std::pair<const Stmt *, PropagationInfo> PairType*/
//  public final class PairType extends std.pair</*const*/ Stmt /*P*/ , PropagationInfo>{ };
  /*typedef MapType::iterator InfoEntry*/
//  public final class InfoEntry extends DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo>{ };
  /*typedef MapType::const_iterator ConstInfoEntry*/
//  public final class ConstInfoEntry extends DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo>{ };
  
  private final AnalysisDeclContext /*&*/ AC;
  private final ConsumedAnalyzer /*&*/ Analyzer;
  private ConsumedStateMap /*P*/ StateMap;
  private DenseMap</*const*/ Stmt /*P*/ , PropagationInfo> PropagationMap;
  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::findInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 468,
   FQN="clang::consumed::ConsumedStmtVisitor::findInfo", NM="_ZN5clang8consumed19ConsumedStmtVisitor8findInfoEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor8findInfoEPKNS_4ExprE")
  //</editor-fold>
  private DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> findInfo(/*const*/ Expr /*P*/ E) {
    {
      /*const*/ ExprWithCleanups /*P*/ Cleanups = dyn_cast_ExprWithCleanups(E);
      if ((Cleanups != null)) {
        if (!Cleanups.cleanupsHaveSideEffects()) {
          E = Cleanups.getSubExpr$Const();
        }
      }
    }
    return PropagationMap.find(E.IgnoreParens$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::findInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 474,
   FQN="clang::consumed::ConsumedStmtVisitor::findInfo", NM="_ZNK5clang8consumed19ConsumedStmtVisitor8findInfoEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed19ConsumedStmtVisitor8findInfoEPKNS_4ExprE")
  //</editor-fold>
  private DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> findInfo$Const(/*const*/ Expr /*P*/ E) /*const*/ {
    {
      /*const*/ ExprWithCleanups /*P*/ Cleanups = dyn_cast_ExprWithCleanups(E);
      if ((Cleanups != null)) {
        if (!Cleanups.cleanupsHaveSideEffects()) {
          E = Cleanups.getSubExpr$Const();
        }
      }
    }
    return PropagationMap.find$Const(E.IgnoreParens$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::insertInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 480,
   FQN="clang::consumed::ConsumedStmtVisitor::insertInfo", NM="_ZN5clang8consumed19ConsumedStmtVisitor10insertInfoEPKNS_4ExprERKNS0_15PropagationInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor10insertInfoEPKNS_4ExprERKNS0_15PropagationInfoE")
  //</editor-fold>
  private void insertInfo(/*const*/ Expr /*P*/ E, final /*const*/ PropagationInfo /*&*/ PI) {
    PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$C$R.INSTANCE, E.IgnoreParens$Const(), PI));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::forwardInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 532,
   FQN="clang::consumed::ConsumedStmtVisitor::forwardInfo", NM="_ZN5clang8consumed19ConsumedStmtVisitor11forwardInfoEPKNS_4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor11forwardInfoEPKNS_4ExprES4_")
  //</editor-fold>
  private void forwardInfo(/*const*/ Expr /*P*/ From, /*const*/ Expr /*P*/ To) {
    DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(From);
    if (Entry.$noteq(/*NO_ITER_COPY*/PropagationMap.end())) {
      insertInfo(To, Entry.$arrow().second);
    }
  }

  
  // Create a new state for To, which is initialized to the state of From.
  // If NS is not CS_None, sets the state of From to NS.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::copyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 541,
   FQN="clang::consumed::ConsumedStmtVisitor::copyInfo", NM="_ZN5clang8consumed19ConsumedStmtVisitor8copyInfoEPKNS_4ExprES4_NS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor8copyInfoEPKNS_4ExprES4_NS0_13ConsumedStateE")
  //</editor-fold>
  private void copyInfo(/*const*/ Expr /*P*/ From, /*const*/ Expr /*P*/ To, 
          ConsumedState NS) {
    DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(From);
    if (Entry.$noteq(/*NO_ITER_COPY*/PropagationMap.end())) {
      final PropagationInfo /*&*/ PInfo = Entry.$arrow().second;
      ConsumedState CS = PInfo.getAsState(StateMap);
      if (CS != ConsumedState.CS_None) {
        insertInfo(To, new PropagationInfo(CS));
      }
      if (NS != ConsumedState.CS_None && PInfo.isPointerToValue()) {
        setStateForVarOrTmp(StateMap, PInfo, NS);
      }
    }
  }

  
  // Get the ConsumedState for From
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::getInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 556,
   FQN="clang::consumed::ConsumedStmtVisitor::getInfo", NM="_ZN5clang8consumed19ConsumedStmtVisitor7getInfoEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor7getInfoEPKNS_4ExprE")
  //</editor-fold>
  private ConsumedState getInfo(/*const*/ Expr /*P*/ From) {
    DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(From);
    if (Entry.$noteq(/*NO_ITER_COPY*/PropagationMap.end())) {
      final PropagationInfo /*&*/ PInfo = Entry.$arrow().second;
      return PInfo.getAsState(StateMap);
    }
    return ConsumedState.CS_None;
  }

  
  // If we already have info for To then update it, otherwise create a new entry.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::setInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 567,
   FQN="clang::consumed::ConsumedStmtVisitor::setInfo", NM="_ZN5clang8consumed19ConsumedStmtVisitor7setInfoEPKNS_4ExprENS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor7setInfoEPKNS_4ExprENS0_13ConsumedStateE")
  //</editor-fold>
  private void setInfo(/*const*/ Expr /*P*/ To, ConsumedState NS) {
    DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(To);
    if (Entry.$noteq(/*NO_ITER_COPY*/PropagationMap.end())) {
      final PropagationInfo /*&*/ PInfo = Entry.$arrow().second;
      if (PInfo.isPointerToValue()) {
        setStateForVarOrTmp(StateMap, PInfo, NS);
      }
    } else if (NS != ConsumedState.CS_None) {
      insertInfo(To, new PropagationInfo(NS));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::propagateReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 688,
   FQN="clang::consumed::ConsumedStmtVisitor::propagateReturnType", NM="_ZN5clang8consumed19ConsumedStmtVisitor19propagateReturnTypeEPKNS_4ExprEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor19propagateReturnTypeEPKNS_4ExprEPKNS_12FunctionDeclE")
  //</editor-fold>
  private void propagateReturnType(/*const*/ Expr /*P*/ Call, 
                     /*const*/ FunctionDecl /*P*/ Fun) {
    QualType RetType = Fun.getCallResultType();
    if (RetType.$arrow().isReferenceType()) {
      RetType.$assignMove(RetType.$arrow().getPointeeType());
    }
    if (isConsumableType(RetType)) {
      ConsumedState ReturnState;
      {
        ReturnTypestateAttr /*P*/ RTA = Fun.getAttr(ReturnTypestateAttr.class);
        if ((RTA != null)) {
          ReturnState = mapReturnTypestateAttrState(RTA);
        } else {
          ReturnState = mapConsumableAttrState(new QualType(RetType));
        }
      }
      
      PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, Call, new PropagationInfo(ReturnState)));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::checkCallability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 580,
   FQN="clang::consumed::ConsumedStmtVisitor::checkCallability", NM="_ZN5clang8consumed19ConsumedStmtVisitor16checkCallabilityERKNS0_15PropagationInfoEPKNS_12FunctionDeclENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor16checkCallabilityERKNS0_15PropagationInfoEPKNS_12FunctionDeclENS_14SourceLocationE")
  //</editor-fold>
  public void checkCallability(final /*const*/ PropagationInfo /*&*/ PInfo, 
                  /*const*/ FunctionDecl /*P*/ FunDecl, 
                  SourceLocation BlameLoc) {
    assert (!PInfo.isTest());
    
    /*const*/ CallableWhenAttr /*P*/ CWAttr = FunDecl.getAttr(CallableWhenAttr.class);
    if (!(CWAttr != null)) {
      return;
    }
    if (PInfo.isVar()) {
      ConsumedState VarState = StateMap.getState(PInfo.getVar());
      if (VarState == ConsumedState.CS_None || isCallableInState(CWAttr, VarState)) {
        return;
      }
      
      Analyzer.WarningsHandler.warnUseInInvalidState(new StringRef(FunDecl.getNameAsString()), new StringRef(PInfo.getVar().getNameAsString()), 
          stateToString(VarState), new SourceLocation(BlameLoc));
    } else {
      ConsumedState TmpState = PInfo.getAsState(StateMap);
      if (TmpState == ConsumedState.CS_None || isCallableInState(CWAttr, TmpState)) {
        return;
      }
      
      Analyzer.WarningsHandler.warnUseOfTempInInvalidState(new StringRef(FunDecl.getNameAsString()), stateToString(TmpState), new SourceLocation(BlameLoc));
    }
  }

  
  // Factors out common behavior for function, method, and operator calls.
  // Check parameters and set parameter state if necessary.
  // Returns true if the state of ObjArg is set, or false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::handleCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 614,
   FQN="clang::consumed::ConsumedStmtVisitor::handleCall", NM="_ZN5clang8consumed19ConsumedStmtVisitor10handleCallEPKNS_8CallExprEPKNS_4ExprEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor10handleCallEPKNS_8CallExprEPKNS_4ExprEPKNS_12FunctionDeclE")
  //</editor-fold>
  public boolean handleCall(/*const*/ CallExpr /*P*/ Call, /*const*/ Expr /*P*/ ObjArg, 
            /*const*/ FunctionDecl /*P*/ FunD) {
    /*uint*/int Offset = 0;
    if (isa_CXXOperatorCallExpr(Call) && isa_CXXMethodDecl(FunD)) {
      Offset = 1; // first argument is 'this'
    }
    
    // check explicit parameters
    for (/*uint*/int Index = Offset; $less_uint(Index, Call.getNumArgs()); ++Index) {
      // Skip variable argument lists.
      if ($greatereq_uint(Index - Offset, FunD.getNumParams())) {
        break;
      }
      
      /*const*/ ParmVarDecl /*P*/ Param = FunD.getParamDecl$Const(Index - Offset);
      QualType ParamType = Param.getType();
      
      DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(Call.getArg$Const(Index));
      if (Entry.$eq(/*NO_ITER_COPY*/PropagationMap.end()) || Entry.$arrow().second.isTest()) {
        continue;
      }
      PropagationInfo PInfo = new PropagationInfo(Entry.$arrow().second);
      {
        
        // Check that the parameter is in the correct state.
        ParamTypestateAttr /*P*/ PTA = Param.getAttr(ParamTypestateAttr.class);
        if ((PTA != null)) {
          ConsumedState ParamState = PInfo.getAsState(StateMap);
          ConsumedState ExpectedState = mapParamTypestateAttrState(PTA);
          if (ParamState != ExpectedState) {
            Analyzer.WarningsHandler.warnParamTypestateMismatch(Call.getArg$Const(Index).getExprLoc(), 
                stateToString(ExpectedState), stateToString(ParamState));
          }
        }
      }
      if (!(Entry.$arrow().second.isVar() || Entry.$arrow().second.isTmp())) {
        continue;
      }
      
      // Adjust state on the caller side.
      if (isRValueRef(new QualType(ParamType))) {
        setStateForVarOrTmp(StateMap, PInfo, ConsumedState.CS_Consumed);
      } else {
        ReturnTypestateAttr /*P*/ RT = Param.getAttr(ReturnTypestateAttr.class);
        if ((RT != null)) {
          setStateForVarOrTmp(StateMap, PInfo, mapReturnTypestateAttrState(RT));
        } else if (isPointerOrRef(new QualType(ParamType))
           && (!ParamType.$arrow().getPointeeType().isConstQualified()
           || isSetOnReadPtrType(ParamType))) {
          setStateForVarOrTmp(StateMap, PInfo, ConsumedState.CS_Unknown);
        }
      }
    }
    if (!(ObjArg != null)) {
      return false;
    }
    
    // check implicit 'self' parameter, if present
    DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(ObjArg);
    if (Entry.$noteq(/*NO_ITER_COPY*/PropagationMap.end())) {
      PropagationInfo PInfo = new PropagationInfo(Entry.$arrow().second);
      checkCallability(PInfo, FunD, Call.getExprLoc());
      {
        
        SetTypestateAttr /*P*/ STA = FunD.getAttr(SetTypestateAttr.class);
        if ((STA != null)) {
          if (PInfo.isVar()) {
            StateMap.setState(PInfo.getVar(), mapSetTypestateAttrState(STA));
            return true;
          } else if (PInfo.isTmp()) {
            StateMap.setState(PInfo.getTmp(), mapSetTypestateAttrState(STA));
            return true;
          }
        } else if (isTestingFunction(FunD) && PInfo.isVar()) {
          PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, Call, 
                  new PropagationInfo(PInfo.getVar(), testsFor(FunD))));
        }
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 706,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitBinaryOperator", NM="_ZN5clang8consumed19ConsumedStmtVisitor19VisitBinaryOperatorEPKNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor19VisitBinaryOperatorEPKNS_14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ BinOp) {
    switch (BinOp.getOpcode()) {
     case BO_LAnd:
     case BO_LOr:
      {
        DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> LEntry = findInfo(BinOp.getLHS());
        DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> REntry = findInfo(BinOp.getRHS());
        
        VarTestResult LTest/*J*/= new VarTestResult();
        VarTestResult RTest/*J*/= new VarTestResult();
        if (LEntry.$noteq(/*NO_ITER_COPY*/PropagationMap.end()) && LEntry.$arrow().second.isVarTest()) {
          LTest.$assign(LEntry.$arrow().second.getVarTest());
        } else {
          LTest.Var = null;
          LTest.TestsFor = ConsumedState.CS_None;
        }
        if (REntry.$noteq(/*NO_ITER_COPY*/PropagationMap.end()) && REntry.$arrow().second.isVarTest()) {
          RTest.$assign(REntry.$arrow().second.getVarTest());
        } else {
          RTest.Var = null;
          RTest.TestsFor = ConsumedState.CS_None;
        }
        if (!(LTest.Var == null && RTest.Var == null)) {
          PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, BinOp, new PropagationInfo(BinOp, 
                      /*static_cast*/EffectiveOp.valueOf(BinOp.getOpcode() == BinaryOperatorKind.BO_LOr?1:0), LTest, RTest)));
        }
        
        break;
      }
     case BO_PtrMemD:
     case BO_PtrMemI:
      forwardInfo(BinOp.getLHS(), BinOp);
      break;
     default:
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 748,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitCallExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor13VisitCallExprEPKNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor13VisitCallExprEPKNS_8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(/*const*/ CallExpr /*P*/ Call) {
    /*const*/ FunctionDecl /*P*/ FunDecl = Call.getDirectCallee$Const();
    if (!(FunDecl != null)) {
      return;
    }
    
    // Special case for the std::move function.
    // TODO: Make this more specific. (Deferred)
    if (Call.getNumArgs() == 1 && $eq_string$C_T$C$P(FunDecl.getNameAsString(), /*KEEP_STR*/"move")
       && FunDecl.isInStdNamespace()) {
      copyInfo(Call.getArg$Const(0), Call, ConsumedState.CS_Consumed);
      return;
    }
    
    handleCall(Call, (/*const*/ Expr /*P*/ )null, FunDecl);
    propagateReturnType(Call, FunDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 765,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitCastExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor13VisitCastExprEPKNS_8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor13VisitCastExprEPKNS_8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(/*const*/ CastExpr /*P*/ Cast) {
    forwardInfo(Cast.getSubExpr$Const(), Cast);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 769,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitCXXBindTemporaryExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor25VisitCXXBindTemporaryExprEPKNS_20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor25VisitCXXBindTemporaryExprEPKNS_20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(/*const*/ CXXBindTemporaryExpr /*P*/ Temp) {
    
    DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(Temp.getSubExpr$Const());
    if (Entry.$noteq(/*NO_ITER_COPY*/PropagationMap.end()) && !Entry.$arrow().second.isTest()) {
      StateMap.setState(Temp, Entry.$arrow().second.getAsState(StateMap));
      PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, Temp, new PropagationInfo(Temp)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 780,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitCXXConstructExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor21VisitCXXConstructExprEPKNS_16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor21VisitCXXConstructExprEPKNS_16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ Call) {
    CXXConstructorDecl /*P*/ Constructor = Call.getConstructor();
    
    final ASTContext /*&*/ CurrContext = AC.getASTContext();
    QualType ThisType = Constructor.getThisType(CurrContext).$arrow().getPointeeType();
    if (!isConsumableType(ThisType)) {
      return;
    }
    {
      
      // FIXME: What should happen if someone annotates the move constructor?
      ReturnTypestateAttr /*P*/ RTA = Constructor.getAttr(ReturnTypestateAttr.class);
      if ((RTA != null)) {
        // TODO: Adjust state of args appropriately.    
        ConsumedState RetState = mapReturnTypestateAttrState(RTA);
        PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, Call, new PropagationInfo(RetState)));
      } else if (Constructor.isDefaultConstructor()) {
        PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, Call, 
                new PropagationInfo(ConsumedState.CS_Consumed)));
      } else if (Constructor.isMoveConstructor()) {
        copyInfo(Call.getArg$Const(0), Call, ConsumedState.CS_Consumed);
      } else if (Constructor.isCopyConstructor()) {
        // Copy state from arg.  If setStateOnRead then set arg to CS_Unknown.
        ConsumedState NS = isSetOnReadPtrType(Constructor.getThisType(CurrContext)) ? ConsumedState.CS_Unknown : ConsumedState.CS_None;
        copyInfo(Call.getArg$Const(0), Call, NS);
      } else {
        // TODO: Adjust state of args appropriately.
        ConsumedState RetState = mapConsumableAttrState(new QualType(ThisType));
        PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, Call, new PropagationInfo(RetState)));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 813,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitCXXMemberCallExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor22VisitCXXMemberCallExprEPKNS_17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor22VisitCXXMemberCallExprEPKNS_17CXXMemberCallExprE")
  //</editor-fold>
  public void VisitCXXMemberCallExpr(/*const*/ CXXMemberCallExpr /*P*/ Call) {
    CXXMethodDecl /*P*/ MD = Call.getMethodDecl();
    if (!(MD != null)) {
      return;
    }
    
    handleCall(Call, Call.getImplicitObjectArgument(), MD);
    propagateReturnType(Call, MD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 824,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitCXXOperatorCallExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor24VisitCXXOperatorCallExprEPKNS_19CXXOperatorCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor24VisitCXXOperatorCallExprEPKNS_19CXXOperatorCallExprE")
  //</editor-fold>
  public void VisitCXXOperatorCallExpr(/*const*/ CXXOperatorCallExpr /*P*/ Call) {
    
    /*const*/ FunctionDecl /*P*/ FunDecl = dyn_cast_or_null_FunctionDecl(Call.getDirectCallee$Const());
    if (!(FunDecl != null)) {
      return;
    }
    if (Call.getOperator() == OverloadedOperatorKind.OO_Equal) {
      ConsumedState CS = getInfo(Call.getArg$Const(1));
      if (!handleCall(Call, Call.getArg$Const(0), FunDecl)) {
        setInfo(Call.getArg$Const(0), CS);
      }
      return;
    }
    {
      
      /*const*/ CXXMemberCallExpr /*P*/ MCall = dyn_cast_CXXMemberCallExpr(Call);
      if ((MCall != null)) {
        handleCall(MCall, MCall.getImplicitObjectArgument(), FunDecl);
      } else {
        handleCall(Call, Call.getArg$Const(0), FunDecl);
      }
    }
    
    propagateReturnType(Call, FunDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 846,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitDeclRefExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor16VisitDeclRefExprEPKNS_11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor16VisitDeclRefExprEPKNS_11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(/*const*/ DeclRefExpr /*P*/ DeclRef) {
    {
      /*const*/ VarDecl /*P*/ Var = dyn_cast_or_null_VarDecl(DeclRef.getDecl$Const());
      if ((Var != null)) {
        if (StateMap.getState(Var) != ConsumedState.CS_None) {
          PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, DeclRef, new PropagationInfo(Var)));
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 852,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitDeclStmt", NM="_ZN5clang8consumed19ConsumedStmtVisitor13VisitDeclStmtEPKNS_8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor13VisitDeclStmtEPKNS_8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(/*const*/ DeclStmt /*P*/ DeclS) {
    for (/*const*/ Decl /*P*/ DI : DeclS.decls$Const())  {
      if (isa_VarDecl(DI)) {
        VisitVarDecl(cast_VarDecl(DI));
      }
    }
    if (DeclS.isSingleDecl()) {
      {
        /*const*/ VarDecl /*P*/ Var = dyn_cast_or_null_VarDecl(DeclS.getSingleDecl$Const());
        if ((Var != null)) {
          PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, DeclS, new PropagationInfo(Var)));
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 862,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitMaterializeTemporaryExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor29VisitMaterializeTemporaryExprEPKNS_24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor29VisitMaterializeTemporaryExprEPKNS_24MaterializeTemporaryExprE")
  //</editor-fold>
  public void VisitMaterializeTemporaryExpr(/*const*/ MaterializeTemporaryExpr /*P*/ Temp) {
    
    forwardInfo(Temp.GetTemporaryExpr(), Temp);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 868,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitMemberExpr", NM="_ZN5clang8consumed19ConsumedStmtVisitor15VisitMemberExprEPKNS_10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor15VisitMemberExprEPKNS_10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(/*const*/ MemberExpr /*P*/ MExpr) {
    forwardInfo(MExpr.getBase(), MExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitParmVarDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 873,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitParmVarDecl", NM="_ZN5clang8consumed19ConsumedStmtVisitor16VisitParmVarDeclEPKNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor16VisitParmVarDeclEPKNS_11ParmVarDeclE")
  //</editor-fold>
  public void VisitParmVarDecl(/*const*/ ParmVarDecl /*P*/ Param) {
    QualType ParamType = Param.getType();
    ConsumedState ParamState = ConsumedState.CS_None;
    {
      
      /*const*/ ParamTypestateAttr /*P*/ PTA = Param.getAttr(ParamTypestateAttr.class);
      if ((PTA != null)) {
        ParamState = mapParamTypestateAttrState(PTA);
      } else if (isConsumableType(ParamType)) {
        ParamState = mapConsumableAttrState(new QualType(ParamType));
      } else if (isRValueRef(new QualType(ParamType))
         && isConsumableType(ParamType.$arrow().getPointeeType())) {
        ParamState = mapConsumableAttrState(ParamType.$arrow().getPointeeType());
      } else if (ParamType.$arrow().isReferenceType()
         && isConsumableType(ParamType.$arrow().getPointeeType())) {
        ParamState = ConsumedState.CS_Unknown;
      }
    }
    if (ParamState != ConsumedState.CS_None) {
      StateMap.setState(Param, ParamState);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 892,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitReturnStmt", NM="_ZN5clang8consumed19ConsumedStmtVisitor15VisitReturnStmtEPKNS_10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor15VisitReturnStmtEPKNS_10ReturnStmtE")
  //</editor-fold>
  public void VisitReturnStmt(/*const*/ ReturnStmt /*P*/ Ret) {
    ConsumedState ExpectedState = Analyzer.getExpectedReturnState();
    if (ExpectedState != ConsumedState.CS_None) {
      DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(Ret.getRetValue$Const());
      if (Entry.$noteq(/*NO_ITER_COPY*/PropagationMap.end())) {
        ConsumedState RetState = Entry.$arrow().second.getAsState(StateMap);
        if (RetState != ExpectedState) {
          Analyzer.WarningsHandler.warnReturnTypestateMismatch(Ret.getReturnLoc(), stateToString(ExpectedState), 
              stateToString(RetState));
        }
      }
    }
    
    StateMap.checkParamsForReturnTypestate(Ret.getLocStart(), 
        Analyzer.WarningsHandler);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 912,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitUnaryOperator", NM="_ZN5clang8consumed19ConsumedStmtVisitor18VisitUnaryOperatorEPKNS_13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor18VisitUnaryOperatorEPKNS_13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(/*const*/ UnaryOperator /*P*/ UOp) {
    DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo(UOp.getSubExpr());
    if (Entry.$eq(/*NO_ITER_COPY*/PropagationMap.end())) {
      return;
    }
    switch (UOp.getOpcode()) {
     case UO_AddrOf:
      PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, UOp, Entry.$arrow().second));
      break;
     case UO_LNot:
      if (Entry.$arrow().second.isTest()) {
        PropagationMap.insert_pair$KeyT$ValueT(new std.pairPtrType</*const*/ Stmt /*P*/ , PropagationInfo>(JD$T$RR_T1$RR.INSTANCE, UOp, Entry.$arrow().second.invertTest()));
      }
      break;
     default:
      break;
    }
  }

  
  // TODO: See if I need to check for reference types here.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::VisitVarDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 932,
   FQN="clang::consumed::ConsumedStmtVisitor::VisitVarDecl", NM="_ZN5clang8consumed19ConsumedStmtVisitor12VisitVarDeclEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor12VisitVarDeclEPKNS_7VarDeclE")
  //</editor-fold>
  public void VisitVarDecl(/*const*/ VarDecl /*P*/ Var) {
    if (isConsumableType(Var.getType())) {
      if (Var.hasInit()) {
        DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> VIT = findInfo(Var.getInit$Const().IgnoreImplicit$Const());
        if (VIT.$noteq(/*NO_ITER_COPY*/PropagationMap.end())) {
          PropagationInfo PInfo = new PropagationInfo(VIT.$arrow().second);
          ConsumedState St = PInfo.getAsState(StateMap);
          if (St != ConsumedState.CS_None) {
            StateMap.setState(Var, St);
            return;
          }
        }
      }
      // Otherwise
      StateMap.setState(Var, ConsumedState.CS_Unknown);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::ConsumedStmtVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 513,
   FQN="clang::consumed::ConsumedStmtVisitor::ConsumedStmtVisitor", NM="_ZN5clang8consumed19ConsumedStmtVisitorC1ERNS_19AnalysisDeclContextERNS0_16ConsumedAnalyzerEPNS0_16ConsumedStateMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitorC1ERNS_19AnalysisDeclContextERNS0_16ConsumedAnalyzerEPNS0_16ConsumedStateMapE")
  //</editor-fold>
  public ConsumedStmtVisitor(final AnalysisDeclContext /*&*/ AC, final ConsumedAnalyzer /*&*/ Analyzer, 
      ConsumedStateMap /*P*/ StateMap) {
    // : ConstStmtVisitor<ConsumedStmtVisitor>(), AC(AC), Analyzer(Analyzer), StateMap(StateMap), PropagationMap() 
    //START JInit
    $ConstStmtVisitor();
    this./*&*/AC=/*&*/AC;
    this./*&*/Analyzer=/*&*/Analyzer;
    this.StateMap = StateMap;
    this.PropagationMap = new DenseMap</*const*/ Stmt /*P*/ , PropagationInfo>(DenseMapInfo$LikePtr.$Info(), new PropagationInfo());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::getInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 517,
   FQN="clang::consumed::ConsumedStmtVisitor::getInfo", NM="_ZNK5clang8consumed19ConsumedStmtVisitor7getInfoEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed19ConsumedStmtVisitor7getInfoEPKNS_4ExprE")
  //</editor-fold>
  public PropagationInfo getInfo$Const(/*const*/ Expr /*P*/ StmtNode) /*const*/ {
    DenseMapIterator</*const*/ Stmt /*P*/ , PropagationInfo> Entry = findInfo$Const(StmtNode);
    if (Entry.$noteq(PropagationMap.end$Const())) {
      return new PropagationInfo(Entry.$arrow().second);
    } else {
      return new PropagationInfo();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 526,
   FQN="clang::consumed::ConsumedStmtVisitor::reset", NM="_ZN5clang8consumed19ConsumedStmtVisitor5resetEPNS0_16ConsumedStateMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitor5resetEPNS0_16ConsumedStateMapE")
  //</editor-fold>
  public void reset(ConsumedStateMap /*P*/ NewStateMap) {
    StateMap = NewStateMap;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedStmtVisitor::~ConsumedStmtVisitor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 456,
   FQN="clang::consumed::ConsumedStmtVisitor::~ConsumedStmtVisitor", NM="_ZN5clang8consumed19ConsumedStmtVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed19ConsumedStmtVisitorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PropagationMap.$destroy();
    ConstStmtVisitorVoid.super.$destroy$ConstStmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "AC=" + "[AnalysisDeclContext]" // NOI18N
              + ", Analyzer=" + Analyzer // NOI18N
              + ", StateMap=" + StateMap // NOI18N
              + ", PropagationMap=" + PropagationMap // NOI18N
              + super.toString(); // NOI18N
  }
}
