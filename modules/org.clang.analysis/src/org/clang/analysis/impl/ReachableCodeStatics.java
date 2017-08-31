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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import static org.clang.analysis.impl.ReachableCodeStatics.*;
import org.clang.lex.Preprocessor;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ReachableCodeStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL12isDeadReturnPKN5clang8CFGBlockEPKNS_4StmtE;_ZL13scanFromBlockPKN5clang8CFGBlockERN4llvm9BitVectorEPNS_12PreprocessorEb;_ZL14isEnumConstantPKN5clang4ExprE;_ZL15getTopMostMacroN5clang14SourceLocationERNS_13SourceManagerE;_ZL15isValidDeadStmtPKN5clang4StmtE;_ZL16isTrivialDoWhilePKN5clang8CFGBlockEPKNS_4StmtE;_ZL17GetUnreachableLocPKN5clang4StmtERNS_11SourceRangeES4_;_ZL19isTrivialExpressionPKN5clang4ExprE;_ZL20isConfigurationValuePKN5clang4StmtERNS_12PreprocessorEPNS_11SourceRangeEbb;_ZL20isConfigurationValuePKN5clang9ValueDeclERNS_12PreprocessorE;_ZL27scanMaybeReachableFromBlockPKN5clang8CFGBlockERNS_12PreprocessorERN4llvm9BitVectorE;_ZL32isExpandedFromConfigurationMacroPKN5clang4StmtERNS_12PreprocessorEb;_ZL32shouldTreatSuccessorsAsReachablePKN5clang8CFGBlockERNS_12PreprocessorE;_ZL6SrcCmpPKSt4pairIPKN5clang8CFGBlockEPKNS0_4StmtEES9_; -static-type=ReachableCodeStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class ReachableCodeStatics {


//===----------------------------------------------------------------------===//
// Core Reachability Analysis routines.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="isEnumConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 34,
 FQN="isEnumConstant", NM="_ZL14isEnumConstantPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL14isEnumConstantPKN5clang4ExprE")
//</editor-fold>
public static boolean isEnumConstant(/*const*/ Expr /*P*/ Ex) {
  /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(Ex);
  if (!(DR != null)) {
    return false;
  }
  return isa_EnumConstantDecl(DR.getDecl$Const());
}

//<editor-fold defaultstate="collapsed" desc="isTrivialExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 41,
 FQN="isTrivialExpression", NM="_ZL19isTrivialExpressionPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL19isTrivialExpressionPKN5clang4ExprE")
//</editor-fold>
public static boolean isTrivialExpression(/*const*/ Expr /*P*/ Ex) {
  Ex = Ex.IgnoreParenCasts$Const();
  return isa_IntegerLiteral(Ex) || isa_StringLiteral(Ex)
     || isa_CXXBoolLiteralExpr(Ex) || isa_ObjCBoolLiteralExpr(Ex)
     || isa_CharacterLiteral(Ex)
     || isEnumConstant(Ex);
}

//<editor-fold defaultstate="collapsed" desc="isTrivialDoWhile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 49,
 FQN="isTrivialDoWhile", NM="_ZL16isTrivialDoWhilePKN5clang8CFGBlockEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL16isTrivialDoWhilePKN5clang8CFGBlockEPKNS_4StmtE")
//</editor-fold>
public static boolean isTrivialDoWhile(/*const*/ CFGBlock /*P*/ B, /*const*/ Stmt /*P*/ S) {
  {
    // Check if the block ends with a do...while() and see if 'S' is the
    // condition.
    /*const*/ Stmt /*P*/ Term = B.getTerminator$Const().$Stmt$C$P();
    if ((Term != null)) {
      {
        /*const*/ DoStmt /*P*/ DS = dyn_cast_DoStmt(Term);
        if ((DS != null)) {
          /*const*/ Expr /*P*/ Cond = DS.getCond$Const().IgnoreParenCasts$Const();
          return Cond == S && isTrivialExpression(Cond);
        }
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isDeadReturn">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 61,
 FQN="isDeadReturn", NM="_ZL12isDeadReturnPKN5clang8CFGBlockEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL12isDeadReturnPKN5clang8CFGBlockEPKNS_4StmtE")
//</editor-fold>
public static boolean isDeadReturn(/*const*/ CFGBlock /*P*/ B, /*const*/ Stmt /*P*/ S) {
  // Look to see if the current control flow ends with a 'return', and see if
  // 'S' is a substatement. The 'return' may not be the last element in the
  // block, or may be in a subsequent block because of destructors.
  /*const*/ CFGBlock /*P*/ Current = B;
  while (true) {
    for (type$ptr</*const*/ CFGElement /*P*/ > I = $tryClone(Current.rbegin$Const()), 
        /*P*/ E = $tryClone(Current.rend$Const());
         $noteq_ptr(I, E); I.$preInc()) {
      {
        Optional<CFGStmt> CS = I.$star().getAs(CFGStmt.class);
        if (CS.$bool()) {
          {
            /*const*/ ReturnStmt /*P*/ RS = dyn_cast_ReturnStmt(CS.$arrow().getStmt());
            if ((RS != null)) {
              if (RS == S) {
                return true;
              }
              {
                /*const*/ Expr /*P*/ RE = RS.getRetValue$Const();
                if ((RE != null)) {
                  ParentMap PM = null;
                  try {
                    RE = RE.IgnoreParenCasts$Const();
                    if (RE == S) {
                      return true;
                    }
                    PM/*J*/= new ParentMap(((/*const_cast*/Expr /*P*/ )(RE)));
                    // If 'S' is in the ParentMap, it is a subexpression of
                    // the return statement.
                    return (PM.getParent_Stmt$C$P(S) != null);
                  } finally {
                    if (PM != null) { PM.$destroy(); }
                  }
                }
              }
            }
          }
          break;
        }
      }
    }
    // Note also that we are restricting the search for the return statement
    // to stop at control-flow; only part of a return statement may be dead,
    // without the whole return statement being dead.
    if (Current.getTerminator$Const().isTemporaryDtorsBranch()) {
      // Temporary destructors have a predictable control flow, thus we want to
      // look into the next block for the return statement.
      // We look into the false branch, as we know the true branch only contains
      // the call to the destructor.
      assert (Current.succ_size() == 2);
      Current = (Current.succ_begin$Const().$add(1)).$star().$CFGBlock$P();
    } else if (!Current.getTerminator$Const().$bool() && Current.succ_size() == 1) {
      // If there is only one successor, we're not dealing with outgoing control
      // flow. Thus, look into the next block.
      Current = Current.succ_begin$Const().$star().$CFGBlock$P();
      if ($greater_uint(Current.pred_size(), 1)) {
        // If there is more than one predecessor, we're dealing with incoming
        // control flow - if the return statement is in that block, it might
        // well be reachable via a different control flow, thus it's not dead.
        return false;
      }
    } else {
      // We hit control flow or a dead end. Stop searching.
      return false;
    }
  }
  //throw new llvm_unreachable("Broke out of infinite loop.");
}

//<editor-fold defaultstate="collapsed" desc="getTopMostMacro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 115,
 FQN="getTopMostMacro", NM="_ZL15getTopMostMacroN5clang14SourceLocationERNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL15getTopMostMacroN5clang14SourceLocationERNS_13SourceManagerE")
//</editor-fold>
public static SourceLocation getTopMostMacro(SourceLocation Loc, final SourceManager /*&*/ SM) {
  assert (Loc.isMacroID());
  SourceLocation Last/*J*/= new SourceLocation();
  while (Loc.isMacroID()) {
    Last.$assign(Loc);
    Loc.$assignMove(SM.getImmediateMacroCallerLoc(/*NO_COPY*/Loc));
  }
  return Last;
}


/// Returns true if the statement is expanded from a configuration macro.
//<editor-fold defaultstate="collapsed" desc="isExpandedFromConfigurationMacro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 126,
 FQN="isExpandedFromConfigurationMacro", NM="_ZL32isExpandedFromConfigurationMacroPKN5clang4StmtERNS_12PreprocessorEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL32isExpandedFromConfigurationMacroPKN5clang4StmtERNS_12PreprocessorEb")
//</editor-fold>
public static boolean isExpandedFromConfigurationMacro(/*const*/ Stmt /*P*/ S, 
                                final Preprocessor /*&*/ PP) {
  return isExpandedFromConfigurationMacro(S, 
                                PP, 
                                false);
}
public static boolean isExpandedFromConfigurationMacro(/*const*/ Stmt /*P*/ S, 
                                final Preprocessor /*&*/ PP, 
                                boolean IgnoreYES_NO/*= false*/) {
  // FIXME: This is not very precise.  Here we just check to see if the
  // value comes from a macro, but we can do much better.  This is likely
  // to be over conservative.  This logic is factored into a separate function
  // so that we can refine it later.
  SourceLocation L = S.getLocStart();
  if (L.isMacroID()) {
    if (IgnoreYES_NO) {
      // The Objective-C constant 'YES' and 'NO'
      // are defined as macros.  Do not treat them
      // as configuration values.
      final SourceManager /*&*/ SM = PP.getSourceManager();
      SourceLocation TopL = getTopMostMacro(new SourceLocation(L), SM);
      StringRef MacroName = PP.getImmediateMacroName(new SourceLocation(TopL));
      if ($eq_StringRef(/*NO_COPY*/MacroName, /*STRINGREF_STR*/"YES") || $eq_StringRef(/*NO_COPY*/MacroName, /*STRINGREF_STR*/"NO")) {
        return false;
      }
    }
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isConfigurationValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 230,
 FQN="isConfigurationValue", NM="_ZL20isConfigurationValuePKN5clang9ValueDeclERNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL20isConfigurationValuePKN5clang9ValueDeclERNS_12PreprocessorE")
//</editor-fold>
public static boolean isConfigurationValue(/*const*/ ValueDecl /*P*/ D, final Preprocessor /*&*/ PP) {
  {
    /*const*/ EnumConstantDecl /*P*/ ED = dyn_cast_EnumConstantDecl(D);
    if ((ED != null)) {
      return isConfigurationValue(ED.getInitExpr$Const(), PP);
    }
  }
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      // As a heuristic, treat globals as configuration values.  Note
      // that we only will get here if Sema evaluated this
      // condition to a constant expression, which means the global
      // had to be declared in a way to be a truly constant value.
      // We could generalize this to local variables, but it isn't
      // clear if those truly represent configuration values that
      // gate unreachable code.
      if (!VD.hasLocalStorage()) {
        return true;
      }
      
      // As a heuristic, locals that have been marked 'const' explicitly
      // can be treated as configuration values as well.
      return VD.getType().isLocalConstQualified();
    }
  }
  return false;
}


/// Returns true if the statement represents a configuration value.
///
/// A configuration value is something usually determined at compile-time
/// to conditionally always execute some branch.  Such guards are for
/// "sometimes unreachable" code.  Such code is usually not interesting
/// to report as unreachable, and may mask truly unreachable code within
/// those blocks.
//<editor-fold defaultstate="collapsed" desc="isConfigurationValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 159,
 FQN="isConfigurationValue", NM="_ZL20isConfigurationValuePKN5clang4StmtERNS_12PreprocessorEPNS_11SourceRangeEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL20isConfigurationValuePKN5clang4StmtERNS_12PreprocessorEPNS_11SourceRangeEbb")
//</editor-fold>
public static boolean isConfigurationValue(/*const*/ Stmt /*P*/ S, 
                    final Preprocessor /*&*/ PP) {
  return isConfigurationValue(S, 
                    PP, 
                    (SourceRange /*P*/ )null, 
                    true, 
                    false);
}
public static boolean isConfigurationValue(/*const*/ Stmt /*P*/ S, 
                    final Preprocessor /*&*/ PP, 
                    SourceRange /*P*/ SilenceableCondVal/*= null*/) {
  return isConfigurationValue(S, 
                    PP, 
                    SilenceableCondVal, 
                    true, 
                    false);
}
public static boolean isConfigurationValue(/*const*/ Stmt /*P*/ S, 
                    final Preprocessor /*&*/ PP, 
                    SourceRange /*P*/ SilenceableCondVal/*= null*/, 
                    boolean IncludeIntegers/*= true*/) {
  return isConfigurationValue(S, 
                    PP, 
                    SilenceableCondVal, 
                    IncludeIntegers, 
                    false);
}
public static boolean isConfigurationValue(/*const*/ Stmt /*P*/ S, 
                    final Preprocessor /*&*/ PP, 
                    SourceRange /*P*/ SilenceableCondVal/*= null*/, 
                    boolean IncludeIntegers/*= true*/, 
                    boolean WrappedInParens/*= false*/) {
  if (!(S != null)) {
    return false;
  }
  {
    
    /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(S);
    if ((Ex != null)) {
      S = Ex.IgnoreCasts$Const();
    }
  }
  {
    
    // Special case looking for the sigil '()' around an integer literal.
    /*const*/ ParenExpr /*P*/ PE = dyn_cast_ParenExpr(S);
    if ((PE != null)) {
      if (!PE.getLocStart().isMacroID()) {
        return isConfigurationValue(PE.getSubExpr$Const(), PP, SilenceableCondVal, 
            IncludeIntegers, true);
      }
    }
  }
  {
    
    /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(S);
    if ((Ex != null)) {
      S = Ex.IgnoreCasts$Const();
    }
  }
  
  boolean IgnoreYES_NO = false;
  switch (S.getStmtClass()) {
   case CallExprClass:
    {
      /*const*/ FunctionDecl /*P*/ Callee = dyn_cast_or_null_FunctionDecl(cast_CallExpr(S).getCalleeDecl$Const());
      return (Callee != null) ? Callee.isConstexpr() : false;
    }
   case DeclRefExprClass:
    return isConfigurationValue(cast_DeclRefExpr(S).getDecl$Const(), PP);
   case ObjCBoolLiteralExprClass:
    IgnoreYES_NO = true;
   case CXXBoolLiteralExprClass:
   case IntegerLiteralClass:
    {
      /*const*/ Expr /*P*/ E = cast_Expr(S);
      if (IncludeIntegers) {
        if ((SilenceableCondVal != null) && !SilenceableCondVal.getBegin().isValid()) {
          /*Deref*/SilenceableCondVal.$assignMove(E.getSourceRange());
        }
        return WrappedInParens || isExpandedFromConfigurationMacro(E, PP, IgnoreYES_NO);
      }
      return false;
    }
   case MemberExprClass:
    return isConfigurationValue(cast_MemberExpr(S).getMemberDecl(), PP);
   case UnaryExprOrTypeTraitExprClass:
    return true;
   case BinaryOperatorClass:
    {
      /*const*/ BinaryOperator /*P*/ B = cast_BinaryOperator(S);
      // Only include raw integers (not enums) as configuration
      // values if they are used in a logical or comparison operator
      // (not arithmetic).
      IncludeIntegers &= (B.isLogicalOp() || B.isComparisonOp());
      return isConfigurationValue(B.getLHS(), PP, SilenceableCondVal, 
          IncludeIntegers)
         || isConfigurationValue(B.getRHS(), PP, SilenceableCondVal, 
          IncludeIntegers);
    }
   case UnaryOperatorClass:
    {
      /*const*/ UnaryOperator /*P*/ UO = cast_UnaryOperator(S);
      if ((SilenceableCondVal != null)) {
        /*Deref*/SilenceableCondVal.$assignMove(UO.getSourceRange());
      }
      return UO.getOpcode() == UnaryOperatorKind.UO_LNot
         && isConfigurationValue(UO.getSubExpr(), PP, SilenceableCondVal, 
          IncludeIntegers, WrappedInParens);
    }
   default:
    return false;
  }
}


/// Returns true if we should always explore all successors of a block.
//<editor-fold defaultstate="collapsed" desc="shouldTreatSuccessorsAsReachable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 252,
 FQN="shouldTreatSuccessorsAsReachable", NM="_ZL32shouldTreatSuccessorsAsReachablePKN5clang8CFGBlockERNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL32shouldTreatSuccessorsAsReachablePKN5clang8CFGBlockERNS_12PreprocessorE")
//</editor-fold>
public static boolean shouldTreatSuccessorsAsReachable(/*const*/ CFGBlock /*P*/ B, 
                                final Preprocessor /*&*/ PP) {
  {
    /*const*/ Stmt /*P*/ Term = B.getTerminator$Const().$Stmt$C$P();
    if ((Term != null)) {
      if (isa_SwitchStmt(Term)) {
        return true;
      }
      // Specially handle '||' and '&&'.
      if (isa_BinaryOperator(Term)) {
        return isConfigurationValue(Term, PP);
      }
    }
  }
  
  /*const*/ Stmt /*P*/ Cond = B.getTerminatorCondition$Const(/* stripParens */ false);
  return isConfigurationValue(Cond, PP);
}

//<editor-fold defaultstate="collapsed" desc="scanFromBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 267,
 FQN="scanFromBlock", NM="_ZL13scanFromBlockPKN5clang8CFGBlockERN4llvm9BitVectorEPNS_12PreprocessorEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL13scanFromBlockPKN5clang8CFGBlockERN4llvm9BitVectorEPNS_12PreprocessorEb")
//</editor-fold>
public static /*uint*/int scanFromBlock(/*const*/ CFGBlock /*P*/ Start, 
             final BitVector /*&*/ Reachable, 
             Preprocessor /*P*/ PP, 
             boolean IncludeSometimesUnreachableEdges) {
  /*uint*/int count = 0;
  
  // Prep work queue
  SmallVector</*const*/ CFGBlock /*P*/ > WL/*J*/= new SmallVector</*const*/ CFGBlock /*P*/ >(32, (/*const*/ CFGBlock /*P*/ )null);
  
  // The entry block may have already been marked reachable
  // by the caller.
  if (!Reachable.$at(Start.getBlockID()).$bool()) {
    ++count;
    Reachable.$at(Start.getBlockID()).$assign(/*KEEP_BOOL*/true);
  }
  
  WL.push_back(Start);
  
  // Find the reachable blocks from 'Start'.
  while (!WL.empty()) {
    /*const*/ CFGBlock /*P*/ item = WL.pop_back_val();
    
    // There are cases where we want to treat all successors as reachable.
    // The idea is that some "sometimes unreachable" code is not interesting,
    // and that we should forge ahead and explore those branches anyway.
    // This allows us to potentially uncover some "always unreachable" code
    // within the "sometimes unreachable" code.
    // Look at the successors and mark then reachable.
    OptionalBool TreatAllSuccessorsAsReachable/*J*/= new OptionalBool();
    if (!IncludeSometimesUnreachableEdges) {
      TreatAllSuccessorsAsReachable.$assign_T$RR(/*KEEP_BOOL*/false);
    }
    
    for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(item.succ_begin$Const()), 
        /*P*/ E = $tryClone(item.succ_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      /*const*/ CFGBlock /*P*/ B = I.$star().$CFGBlock$P();
      if (!(B != null)) {
        do {
          /*const*/ CFGBlock /*P*/ UB = I./*->*/$star().getPossiblyUnreachableBlock();
          if (!(UB != null)) {
            break;
          }
          if (!TreatAllSuccessorsAsReachable.hasValue()) {
            assert Native.$bool(PP);
            TreatAllSuccessorsAsReachable.$assign_T$RR(
                /*KEEP_BOOL*/shouldTreatSuccessorsAsReachable(item, $Deref(PP))
            );
          }
          if (TreatAllSuccessorsAsReachable.getValue()) {
            B = UB;
            break;
          }
        } while (false);
      }
      if ((B != null)) {
        /*uint*/int blockID = B.getBlockID();
        if (!Reachable.$at(blockID).$bool()) {
          Reachable.set(blockID);
          WL.push_back(B);
          ++count;
        }
      }
    }
  }
  return count;
}

//<editor-fold defaultstate="collapsed" desc="scanMaybeReachableFromBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 333,
 FQN="scanMaybeReachableFromBlock", NM="_ZL27scanMaybeReachableFromBlockPKN5clang8CFGBlockERNS_12PreprocessorERN4llvm9BitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL27scanMaybeReachableFromBlockPKN5clang8CFGBlockERNS_12PreprocessorERN4llvm9BitVectorE")
//</editor-fold>
public static /*uint*/int scanMaybeReachableFromBlock(/*const*/ CFGBlock /*P*/ Start, 
                           final Preprocessor /*&*/ PP, 
                           final BitVector /*&*/ Reachable) {
  return scanFromBlock(Start, Reachable, $AddrOf(PP), true);
}

//<editor-fold defaultstate="collapsed" desc="isValidDeadStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 406,
 FQN="isValidDeadStmt", NM="_ZL15isValidDeadStmtPKN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL15isValidDeadStmtPKN5clang4StmtE")
//</editor-fold>
public static boolean isValidDeadStmt(/*const*/ Stmt /*P*/ S) {
  if (S.getLocStart().isInvalid()) {
    return false;
  }
  {
    /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(S);
    if ((BO != null)) {
      return BO.getOpcode() != BinaryOperatorKind.BO_Comma;
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="SrcCmp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 433,
 FQN="SrcCmp", NM="_ZL6SrcCmpPKSt4pairIPKN5clang8CFGBlockEPKNS0_4StmtEES9_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL6SrcCmpPKSt4pairIPKN5clang8CFGBlockEPKNS0_4StmtEES9_")
//</editor-fold>
public static int SrcCmp(/*const*/ std.pair</*const*/ CFGBlock /*P*/ , /*const*/ Stmt /*P*/ > /*P*/ p1, 
      /*const*/ std.pair</*const*/ CFGBlock /*P*/ , /*const*/ Stmt /*P*/ > /*P*/ p2) {
  if ($less_SourceLocation$C(p1.second.getLocStart(), p2.second.getLocStart())) {
    return -1;
  }
  if ($less_SourceLocation$C(p2.second.getLocStart(), p1.second.getLocStart())) {
    return 1;
  }
  return 0;
}

//<editor-fold defaultstate="collapsed" desc="GetUnreachableLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 504,
 FQN="GetUnreachableLoc", NM="_ZL17GetUnreachableLocPKN5clang4StmtERNS_11SourceRangeES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZL17GetUnreachableLocPKN5clang4StmtERNS_11SourceRangeES4_")
//</editor-fold>
public static SourceLocation GetUnreachableLoc(/*const*/ Stmt /*P*/ S, 
                 final SourceRange /*&*/ R1, 
                 final SourceRange /*&*/ R2) {
  R1.$assign(R2.$assignMove(new SourceRange()));
  {
    
    /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(S);
    if ((Ex != null)) {
      S = Ex.IgnoreParenImpCasts$Const();
    }
  }
  switch (S.getStmtClass()) {
   case BinaryOperatorClass:
    {
      /*const*/ BinaryOperator /*P*/ BO = cast_BinaryOperator(S);
      return BO.getOperatorLoc();
    }
   case UnaryOperatorClass:
    {
      /*const*/ UnaryOperator /*P*/ UO = cast_UnaryOperator(S);
      R1.$assignMove(UO.getSubExpr().getSourceRange());
      return UO.getOperatorLoc();
    }
   case CompoundAssignOperatorClass:
    {
      /*const*/ CompoundAssignOperator /*P*/ CAO = cast_CompoundAssignOperator(S);
      R1.$assignMove(CAO.getLHS().getSourceRange());
      R2.$assignMove(CAO.getRHS().getSourceRange());
      return CAO.getOperatorLoc();
    }
   case BinaryConditionalOperatorClass:
   case ConditionalOperatorClass:
    {
      /*const*/ AbstractConditionalOperator /*P*/ CO = cast_AbstractConditionalOperator(S);
      return CO.getQuestionLoc();
    }
   case MemberExprClass:
    {
      /*const*/ MemberExpr /*P*/ ME = cast_MemberExpr(S);
      R1.$assignMove(ME.getSourceRange());
      return ME.getMemberLoc();
    }
   case ArraySubscriptExprClass:
    {
      /*const*/ ArraySubscriptExpr /*P*/ ASE = cast_ArraySubscriptExpr(S);
      R1.$assignMove(ASE.getLHS$Const().getSourceRange());
      R2.$assignMove(ASE.getRHS$Const().getSourceRange());
      return ASE.getRBracketLoc();
    }
   case CStyleCastExprClass:
    {
      /*const*/ CStyleCastExpr /*P*/ CSC = cast_CStyleCastExpr(S);
      R1.$assignMove(CSC.getSubExpr$Const().getSourceRange());
      return CSC.getLParenLoc();
    }
   case CXXFunctionalCastExprClass:
    {
      /*const*/ CXXFunctionalCastExpr /*P*/ CE = cast_CXXFunctionalCastExpr(S);
      R1.$assignMove(CE.getSubExpr$Const().getSourceRange());
      return CE.getLocStart();
    }
   case CXXTryStmtClass:
    {
      return cast_CXXTryStmt(S).getHandler$Const(0).getCatchLoc();
    }
   case ObjCBridgedCastExprClass:
    {
      /*const*/ ObjCBridgedCastExpr /*P*/ CSC = cast_ObjCBridgedCastExpr(S);
      R1.$assignMove(CSC.getSubExpr$Const().getSourceRange());
      return CSC.getLParenLoc();
    }
   default:
    ;
  }
  R1.$assignMove(S.getSourceRange());
  return S.getLocStart();
}

} // END OF class ReachableCodeStatics
