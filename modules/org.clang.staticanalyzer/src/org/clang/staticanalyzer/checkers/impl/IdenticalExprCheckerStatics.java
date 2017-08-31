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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.IdenticalExprCheckerStatics.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type IdenticalExprCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZL15isIdenticalStmtRKN5clang10ASTContextEPKNS_4StmtES5_b; -static-type=IdenticalExprCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class IdenticalExprCheckerStatics {


/// \brief Determines whether two statement trees are identical regarding
/// operators and symbols.
///
/// Exceptions: expressions containing macros or functions with possible side
/// effects are never considered identical.
/// Limitations: (t + u) and (u + t) are not considered identical.
/// t*(u + t) and t*u + t*t are not considered identical.
///
//<editor-fold defaultstate="collapsed" desc="isIdenticalStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 304,
 FQN="isIdenticalStmt", NM="_ZL15isIdenticalStmtRKN5clang10ASTContextEPKNS_4StmtES5_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZL15isIdenticalStmtRKN5clang10ASTContextEPKNS_4StmtES5_b")
//</editor-fold>
public static boolean isIdenticalStmt(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ Stmt /*P*/ Stmt1, 
               /*const*/ Stmt /*P*/ Stmt2) {
  return isIdenticalStmt(Ctx, Stmt1, 
               Stmt2, false);
}
public static boolean isIdenticalStmt(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ Stmt /*P*/ Stmt1, 
               /*const*/ Stmt /*P*/ Stmt2, boolean IgnoreSideEffects/*= false*/) {
  if (!(Stmt1 != null) || !(Stmt2 != null)) {
    return !(Stmt1 != null) && !(Stmt2 != null);
  }
  
  // If Stmt1 & Stmt2 are of different class then they are not
  // identical statements.
  if (Stmt1.getStmtClass() != Stmt2.getStmtClass()) {
    return false;
  }
  
  /*const*/ Expr /*P*/ Expr1 = dyn_cast_Expr(Stmt1);
  /*const*/ Expr /*P*/ Expr2 = dyn_cast_Expr(Stmt2);
  if ((Expr1 != null) && (Expr2 != null)) {
    // If Stmt1 has side effects then don't warn even if expressions
    // are identical.
    if (!IgnoreSideEffects && Expr1.HasSideEffects(Ctx)) {
      return false;
    }
    // If either expression comes from a macro then don't warn even if
    // the expressions are identical.
    if ((Expr1.getExprLoc().isMacroID()) || (Expr2.getExprLoc().isMacroID())) {
      return false;
    }
    
    // If all children of two expressions are identical, return true.
    ConstStmtIterator I1 = Expr1.child_begin$Const();
    ConstStmtIterator I2 = Expr2.child_begin$Const();
    while (I1.$noteq(Expr1.child_end$Const()) && I2.$noteq(Expr2.child_end$Const())) {
      if (!(I1.$star() != null) || !(I2.$star() != null) || !isIdenticalStmt(Ctx, I1.$star(), I2.$star(), IgnoreSideEffects)) {
        return false;
      }
      I1.$preInc();
      I2.$preInc();
    }
    // If there are different number of children in the statements, return
    // false.
    if (I1.$noteq(Expr1.child_end$Const())) {
      return false;
    }
    if (I2.$noteq(Expr2.child_end$Const())) {
      return false;
    }
  }
  switch (Stmt1.getStmtClass()) {
   default:
    return false;
   case CallExprClass:
   case ArraySubscriptExprClass:
   case OMPArraySectionExprClass:
   case ImplicitCastExprClass:
   case ParenExprClass:
   case BreakStmtClass:
   case ContinueStmtClass:
   case NullStmtClass:
    return true;
   case CStyleCastExprClass:
    {
      /*const*/ CStyleCastExpr /*P*/ CastExpr1 = cast_CStyleCastExpr(Stmt1);
      /*const*/ CStyleCastExpr /*P*/ CastExpr2 = cast_CStyleCastExpr(Stmt2);
      
      return $eq_QualType$C(CastExpr1.getTypeAsWritten(), CastExpr2.getTypeAsWritten());
    }
   case ReturnStmtClass:
    {
      /*const*/ ReturnStmt /*P*/ ReturnStmt1 = cast_ReturnStmt(Stmt1);
      /*const*/ ReturnStmt /*P*/ ReturnStmt2 = cast_ReturnStmt(Stmt2);
      
      return isIdenticalStmt(Ctx, ReturnStmt1.getRetValue$Const(), 
          ReturnStmt2.getRetValue$Const(), IgnoreSideEffects);
    }
   case ForStmtClass:
    {
      /*const*/ ForStmt /*P*/ ForStmt1 = cast_ForStmt(Stmt1);
      /*const*/ ForStmt /*P*/ ForStmt2 = cast_ForStmt(Stmt2);
      if (!isIdenticalStmt(Ctx, ForStmt1.getInit$Const(), ForStmt2.getInit$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      if (!isIdenticalStmt(Ctx, ForStmt1.getCond$Const(), ForStmt2.getCond$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      if (!isIdenticalStmt(Ctx, ForStmt1.getInc$Const(), ForStmt2.getInc$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      if (!isIdenticalStmt(Ctx, ForStmt1.getBody$Const(), ForStmt2.getBody$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      return true;
    }
   case DoStmtClass:
    {
      /*const*/ DoStmt /*P*/ DStmt1 = cast_DoStmt(Stmt1);
      /*const*/ DoStmt /*P*/ DStmt2 = cast_DoStmt(Stmt2);
      if (!isIdenticalStmt(Ctx, DStmt1.getCond$Const(), DStmt2.getCond$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      if (!isIdenticalStmt(Ctx, DStmt1.getBody$Const(), DStmt2.getBody$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      return true;
    }
   case WhileStmtClass:
    {
      /*const*/ WhileStmt /*P*/ WStmt1 = cast_WhileStmt(Stmt1);
      /*const*/ WhileStmt /*P*/ WStmt2 = cast_WhileStmt(Stmt2);
      if (!isIdenticalStmt(Ctx, WStmt1.getCond$Const(), WStmt2.getCond$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      if (!isIdenticalStmt(Ctx, WStmt1.getBody$Const(), WStmt2.getBody$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      return true;
    }
   case IfStmtClass:
    {
      /*const*/ IfStmt /*P*/ IStmt1 = cast_IfStmt(Stmt1);
      /*const*/ IfStmt /*P*/ IStmt2 = cast_IfStmt(Stmt2);
      if (!isIdenticalStmt(Ctx, IStmt1.getCond$Const(), IStmt2.getCond$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      if (!isIdenticalStmt(Ctx, IStmt1.getThen$Const(), IStmt2.getThen$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      if (!isIdenticalStmt(Ctx, IStmt1.getElse$Const(), IStmt2.getElse$Const(), 
          IgnoreSideEffects)) {
        return false;
      }
      return true;
    }
   case CompoundStmtClass:
    {
      /*const*/ CompoundStmt /*P*/ CompStmt1 = cast_CompoundStmt(Stmt1);
      /*const*/ CompoundStmt /*P*/ CompStmt2 = cast_CompoundStmt(Stmt2);
      if (CompStmt1.size() != CompStmt2.size()) {
        return false;
      }
      
      type$ptr<Stmt /*P*/ /*const*/ /*P*/> I1 = $tryClone(CompStmt1.body_begin$Const());
      type$ptr<Stmt /*P*/ /*const*/ /*P*/> I2 = $tryClone(CompStmt2.body_begin$Const());
      while ($noteq_ptr(I1, CompStmt1.body_end$Const()) && $noteq_ptr(I2, CompStmt2.body_end$Const())) {
        if (!isIdenticalStmt(Ctx, I1.$star(), I2.$star(), IgnoreSideEffects)) {
          return false;
        }
        I1.$preInc();
        I2.$preInc();
      }
      
      return true;
    }
   case CompoundAssignOperatorClass:
   case BinaryOperatorClass:
    {
      /*const*/ BinaryOperator /*P*/ BinOp1 = cast_BinaryOperator(Stmt1);
      /*const*/ BinaryOperator /*P*/ BinOp2 = cast_BinaryOperator(Stmt2);
      return BinOp1.getOpcode() == BinOp2.getOpcode();
    }
   case CharacterLiteralClass:
    {
      /*const*/ CharacterLiteral /*P*/ CharLit1 = cast_CharacterLiteral(Stmt1);
      /*const*/ CharacterLiteral /*P*/ CharLit2 = cast_CharacterLiteral(Stmt2);
      return CharLit1.getValue() == CharLit2.getValue();
    }
   case DeclRefExprClass:
    {
      /*const*/ DeclRefExpr /*P*/ DeclRef1 = cast_DeclRefExpr(Stmt1);
      /*const*/ DeclRefExpr /*P*/ DeclRef2 = cast_DeclRefExpr(Stmt2);
      return DeclRef1.getDecl$Const() == DeclRef2.getDecl$Const();
    }
   case IntegerLiteralClass:
    {
      /*const*/ IntegerLiteral /*P*/ IntLit1 = cast_IntegerLiteral(Stmt1);
      /*const*/ IntegerLiteral /*P*/ IntLit2 = cast_IntegerLiteral(Stmt2);
      
      APInt I1 = IntLit1.getValue();
      APInt I2 = IntLit2.getValue();
      if (I1.getBitWidth() != I2.getBitWidth()) {
        return false;
      }
      return I1.$eq(I2);
    }
   case FloatingLiteralClass:
    {
      /*const*/ FloatingLiteral /*P*/ FloatLit1 = cast_FloatingLiteral(Stmt1);
      /*const*/ FloatingLiteral /*P*/ FloatLit2 = cast_FloatingLiteral(Stmt2);
      return FloatLit1.getValue().bitwiseIsEqual(FloatLit2.getValue());
    }
   case StringLiteralClass:
    {
      /*const*/ StringLiteral /*P*/ StringLit1 = cast_StringLiteral(Stmt1);
      /*const*/ StringLiteral /*P*/ StringLit2 = cast_StringLiteral(Stmt2);
      return $eq_StringRef(StringLit1.getBytes(), StringLit2.getBytes());
    }
   case MemberExprClass:
    {
      /*const*/ MemberExpr /*P*/ MemberStmt1 = cast_MemberExpr(Stmt1);
      /*const*/ MemberExpr /*P*/ MemberStmt2 = cast_MemberExpr(Stmt2);
      return MemberStmt1.getMemberDecl() == MemberStmt2.getMemberDecl();
    }
   case UnaryOperatorClass:
    {
      /*const*/ UnaryOperator /*P*/ UnaryOp1 = cast_UnaryOperator(Stmt1);
      /*const*/ UnaryOperator /*P*/ UnaryOp2 = cast_UnaryOperator(Stmt2);
      return UnaryOp1.getOpcode() == UnaryOp2.getOpcode();
    }
  }
}

} // END OF class IdenticalExprCheckerStatics
