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
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.consumed.*;
import static org.clang.analysis.impl.ConsumedStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ConsumedStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL11isRValueRefN5clang8QualTypeE;_ZL12isKnownStateN5clang8consumed13ConsumedStateE;_ZL13stateToStringN5clang8consumed13ConsumedStateE;_ZL14getLastStmtLocPKN5clang8CFGBlockE;_ZL14isAutoCastTypeRKN5clang8QualTypeE;_ZL14isPointerOrRefN5clang8QualTypeE;_ZL15getFirstStmtLocPKN5clang8CFGBlockE;_ZL16isConsumableTypeRKN5clang8QualTypeE;_ZL17isCallableInStatePKN5clang16CallableWhenAttrENS_8consumed13ConsumedStateE;_ZL17isTestingFunctionPKN5clang12FunctionDeclE;_ZL18isSetOnReadPtrTypeRKN5clang8QualTypeE;_ZL22mapConsumableAttrStateN5clang8QualTypeE;_ZL24invertConsumedUnconsumedN5clang8consumed13ConsumedStateE;_ZL24mapSetTypestateAttrStatePKN5clang16SetTypestateAttrE;_ZL26mapParamTypestateAttrStatePKN5clang18ParamTypestateAttrE;_ZL27mapReturnTypestateAttrStatePKN5clang19ReturnTypestateAttrE;_ZL8testsForPKN5clang12FunctionDeclE; -static-type=ConsumedStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class ConsumedStatics {

//<editor-fold defaultstate="collapsed" desc="getFirstStmtLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 57,
 FQN="getFirstStmtLoc", NM="_ZL15getFirstStmtLocPKN5clang8CFGBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL15getFirstStmtLocPKN5clang8CFGBlockE")
//</editor-fold>
public static SourceLocation getFirstStmtLoc(/*const*/ CFGBlock /*P*/ Block) {
  // Find the source location of the first statement in the block, if the block
  // is not empty.
  for (final /*const*/ CFGElement /*&*/ B : $Deref(Block))  {
    {
      Optional<CFGStmt> CS = B.getAs(CFGStmt.class);
      if (CS.$bool()) {
        return CS.$arrow().getStmt().getLocStart();
      }
    }
  }
  
  // Block is empty.
  // If we have one successor, return the first statement in that block
  if (Block.succ_size() == 1 && ((Block.succ_begin$Const().$star().$CFGBlock$P()) != null)) {
    return getFirstStmtLoc(Block.succ_begin$Const().$star().$CFGBlock$P());
  }
  
  return new SourceLocation();
}

//<editor-fold defaultstate="collapsed" desc="getLastStmtLoc">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 72,
 FQN="getLastStmtLoc", NM="_ZL14getLastStmtLocPKN5clang8CFGBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL14getLastStmtLocPKN5clang8CFGBlockE")
//</editor-fold>
public static SourceLocation getLastStmtLoc(/*const*/ CFGBlock /*P*/ Block) {
  {
    // Find the source location of the last statement in the block, if the block
    // is not empty.
    /*const*/ Stmt /*P*/ StmtNode = Block.getTerminator$Const().$Stmt$C$P();
    if ((StmtNode != null)) {
      return StmtNode.getLocStart();
    } else {
      for (type$ptr</*const*/ CFGElement /*P*/ > BI = $tryClone(Block.rbegin$Const()), 
          /*P*/ BE = $tryClone(Block.rend$Const()); $noteq_ptr(BI, BE); BI.$preInc()) {
        {
          Optional<CFGStmt> CS = BI.$star().getAs(CFGStmt.class);
          if (CS.$bool()) {
            return CS.$arrow().getStmt().getLocStart();
          }
        }
      }
    }
  }
  
  // If we have one successor, return the first statement in that block
  SourceLocation Loc/*J*/= new SourceLocation();
  if (Block.succ_size() == 1 && ((Block.succ_begin$Const().$star().$CFGBlock$P()) != null)) {
    Loc.$assignMove(getFirstStmtLoc(Block.succ_begin$Const().$star().$CFGBlock$P()));
  }
  if (Loc.isValid()) {
    return Loc;
  }
  
  // If we have one predecessor, return the last statement in that block
  if (Block.pred_size() == 1 && ((Block.pred_begin$Const().$star().$CFGBlock$P()) != null)) {
    return getLastStmtLoc(Block.pred_begin$Const().$star().$CFGBlock$P());
  }
  
  return Loc;
}

//<editor-fold defaultstate="collapsed" desc="invertConsumedUnconsumed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 99,
 FQN="invertConsumedUnconsumed", NM="_ZL24invertConsumedUnconsumedN5clang8consumed13ConsumedStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL24invertConsumedUnconsumedN5clang8consumed13ConsumedStateE")
//</editor-fold>
public static ConsumedState invertConsumedUnconsumed(ConsumedState State) {
  switch (State) {
   case CS_Unconsumed:
    return ConsumedState.CS_Consumed;
   case CS_Consumed:
    return ConsumedState.CS_Unconsumed;
   case CS_None:
    return ConsumedState.CS_None;
   case CS_Unknown:
    return ConsumedState.CS_Unknown;
  }
  throw new llvm_unreachable("invalid enum");
}

//<editor-fold defaultstate="collapsed" desc="isCallableInState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 113,
 FQN="isCallableInState", NM="_ZL17isCallableInStatePKN5clang16CallableWhenAttrENS_8consumed13ConsumedStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL17isCallableInStatePKN5clang16CallableWhenAttrENS_8consumed13ConsumedStateE")
//</editor-fold>
public static boolean isCallableInState(/*const*/ CallableWhenAttr /*P*/ CWAttr, 
                 ConsumedState State) {
  
  for (final /*const*/ CallableWhenAttr.ConsumedState /*&*/ S : CWAttr.callableStates()) {
    ConsumedState MappedAttrState = ConsumedState.CS_None;
    switch (S) {
     case Unknown:
      MappedAttrState = ConsumedState.CS_Unknown;
      break;
     case Unconsumed:
      MappedAttrState = ConsumedState.CS_Unconsumed;
      break;
     case Consumed:
      MappedAttrState = ConsumedState.CS_Consumed;
      break;
    }
    if (MappedAttrState == State) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isConsumableType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 141,
 FQN="isConsumableType", NM="_ZL16isConsumableTypeRKN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL16isConsumableTypeRKN5clang8QualTypeE")
//</editor-fold>
public static boolean isConsumableType(final /*const*/ QualType /*&*/ QT) {
  if (QT.$arrow().isPointerType() || QT.$arrow().isReferenceType()) {
    return false;
  }
  {
    
    /*const*/ CXXRecordDecl /*P*/ RD = QT.$arrow().getAsCXXRecordDecl();
    if ((RD != null)) {
      return RD.hasAttr(ConsumableAttr.class);
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isAutoCastType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 151,
 FQN="isAutoCastType", NM="_ZL14isAutoCastTypeRKN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL14isAutoCastTypeRKN5clang8QualTypeE")
//</editor-fold>
public static boolean isAutoCastType(final /*const*/ QualType /*&*/ QT) {
  if (QT.$arrow().isPointerType() || QT.$arrow().isReferenceType()) {
    return false;
  }
  {
    
    /*const*/ CXXRecordDecl /*P*/ RD = QT.$arrow().getAsCXXRecordDecl();
    if ((RD != null)) {
      return RD.hasAttr(ConsumableAutoCastAttr.class);
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isSetOnReadPtrType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 161,
 FQN="isSetOnReadPtrType", NM="_ZL18isSetOnReadPtrTypeRKN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL18isSetOnReadPtrTypeRKN5clang8QualTypeE")
//</editor-fold>
public static boolean isSetOnReadPtrType(final /*const*/ QualType /*&*/ QT) {
  {
    /*const*/ CXXRecordDecl /*P*/ RD = QT.$arrow().getPointeeCXXRecordDecl();
    if ((RD != null)) {
      return RD.hasAttr(ConsumableSetOnReadAttr.class);
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isKnownState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 168,
 FQN="isKnownState", NM="_ZL12isKnownStateN5clang8consumed13ConsumedStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL12isKnownStateN5clang8consumed13ConsumedStateE")
//</editor-fold>
public static boolean isKnownState(ConsumedState State) {
  switch (State) {
   case CS_Unconsumed:
   case CS_Consumed:
    return true;
   case CS_None:
   case CS_Unknown:
    return false;
  }
  throw new llvm_unreachable("invalid enum");
}

//<editor-fold defaultstate="collapsed" desc="isRValueRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 180,
 FQN="isRValueRef", NM="_ZL11isRValueRefN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL11isRValueRefN5clang8QualTypeE")
//</editor-fold>
public static boolean isRValueRef(QualType ParamType) {
  return ParamType.$arrow().isRValueReferenceType();
}

//<editor-fold defaultstate="collapsed" desc="isTestingFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 184,
 FQN="isTestingFunction", NM="_ZL17isTestingFunctionPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL17isTestingFunctionPKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean isTestingFunction(/*const*/ FunctionDecl /*P*/ FunDecl) {
  return FunDecl.hasAttr(TestTypestateAttr.class);
}

//<editor-fold defaultstate="collapsed" desc="isPointerOrRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 188,
 FQN="isPointerOrRef", NM="_ZL14isPointerOrRefN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL14isPointerOrRefN5clang8QualTypeE")
//</editor-fold>
public static boolean isPointerOrRef(QualType ParamType) {
  return ParamType.$arrow().isPointerType() || ParamType.$arrow().isReferenceType();
}

//<editor-fold defaultstate="collapsed" desc="mapConsumableAttrState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 192,
 FQN="mapConsumableAttrState", NM="_ZL22mapConsumableAttrStateN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL22mapConsumableAttrStateN5clang8QualTypeE")
//</editor-fold>
public static ConsumedState mapConsumableAttrState(/*const*/ QualType QT) {
  assert (isConsumableType(QT));
  
  /*const*/ ConsumableAttr /*P*/ CAttr = QT.$arrow().getAsCXXRecordDecl().getAttr(ConsumableAttr.class);
  switch (CAttr.getDefaultState()) {
   case Unknown:
    return ConsumedState.CS_Unknown;
   case Unconsumed:
    return ConsumedState.CS_Unconsumed;
   case Consumed:
    return ConsumedState.CS_Consumed;
  }
  throw new llvm_unreachable("invalid enum");
}

//<editor-fold defaultstate="collapsed" desc="mapParamTypestateAttrState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 209,
 FQN="mapParamTypestateAttrState", NM="_ZL26mapParamTypestateAttrStatePKN5clang18ParamTypestateAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL26mapParamTypestateAttrStatePKN5clang18ParamTypestateAttrE")
//</editor-fold>
public static ConsumedState mapParamTypestateAttrState(/*const*/ ParamTypestateAttr /*P*/ PTAttr) {
  switch (PTAttr.getParamState()) {
   case Unknown:
    return ConsumedState.CS_Unknown;
   case Unconsumed:
    return ConsumedState.CS_Unconsumed;
   case Consumed:
    return ConsumedState.CS_Consumed;
  }
  throw new llvm_unreachable("invalid_enum");
}

//<editor-fold defaultstate="collapsed" desc="mapReturnTypestateAttrState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 222,
 FQN="mapReturnTypestateAttrState", NM="_ZL27mapReturnTypestateAttrStatePKN5clang19ReturnTypestateAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL27mapReturnTypestateAttrStatePKN5clang19ReturnTypestateAttrE")
//</editor-fold>
public static ConsumedState mapReturnTypestateAttrState(/*const*/ ReturnTypestateAttr /*P*/ RTSAttr) {
  switch (RTSAttr.getState()) {
   case Unknown:
    return ConsumedState.CS_Unknown;
   case Unconsumed:
    return ConsumedState.CS_Unconsumed;
   case Consumed:
    return ConsumedState.CS_Consumed;
  }
  throw new llvm_unreachable("invalid enum");
}

//<editor-fold defaultstate="collapsed" desc="mapSetTypestateAttrState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 235,
 FQN="mapSetTypestateAttrState", NM="_ZL24mapSetTypestateAttrStatePKN5clang16SetTypestateAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL24mapSetTypestateAttrStatePKN5clang16SetTypestateAttrE")
//</editor-fold>
public static ConsumedState mapSetTypestateAttrState(/*const*/ SetTypestateAttr /*P*/ STAttr) {
  switch (STAttr.getNewState()) {
   case Unknown:
    return ConsumedState.CS_Unknown;
   case Unconsumed:
    return ConsumedState.CS_Unconsumed;
   case Consumed:
    return ConsumedState.CS_Consumed;
  }
  throw new llvm_unreachable("invalid_enum");
}

//<editor-fold defaultstate="collapsed" desc="stateToString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 247,
 FQN="stateToString", NM="_ZL13stateToStringN5clang8consumed13ConsumedStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL13stateToStringN5clang8consumed13ConsumedStateE")
//</editor-fold>
public static StringRef stateToString(ConsumedState State) {
  switch (State) {
   case CS_None:
    return new StringRef(/*KEEP_STR*/"none");
   case CS_Unknown:
    return new StringRef(/*KEEP_STR*/$unknown);
   case CS_Unconsumed:
    return new StringRef(/*KEEP_STR*/"unconsumed");
   case CS_Consumed:
    return new StringRef(/*KEEP_STR*/"consumed");
  }
  throw new llvm_unreachable("invalid enum");
}

//<editor-fold defaultstate="collapsed" desc="testsFor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 264,
 FQN="testsFor", NM="_ZL8testsForPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZL8testsForPKN5clang12FunctionDeclE")
//</editor-fold>
public static ConsumedState testsFor(/*const*/ FunctionDecl /*P*/ FunDecl) {
  assert (isTestingFunction(FunDecl));
  switch (FunDecl.getAttr(TestTypestateAttr.class).getTestState()) {
   case Unconsumed:
    return ConsumedState.CS_Unconsumed;
   case Consumed:
    return ConsumedState.CS_Consumed;
  }
  throw new llvm_unreachable("invalid enum");
}

} // END OF class ConsumedStatics
