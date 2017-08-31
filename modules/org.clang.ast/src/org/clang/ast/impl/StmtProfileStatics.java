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
package org.clang.ast.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type StmtProfileStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZL18DecodeOperatorCallPKN5clang19CXXOperatorCallExprERNS_17UnaryOperatorKindERNS_18BinaryOperatorKindE; -static-type=StmtProfileStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class StmtProfileStatics {

//<editor-fold defaultstate="collapsed" desc="DecodeOperatorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 998,
 FQN="DecodeOperatorCall", NM="_ZL18DecodeOperatorCallPKN5clang19CXXOperatorCallExprERNS_17UnaryOperatorKindERNS_18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZL18DecodeOperatorCallPKN5clang19CXXOperatorCallExprERNS_17UnaryOperatorKindERNS_18BinaryOperatorKindE")
//</editor-fold>
public static Stmt.StmtClass DecodeOperatorCall(/*const*/ CXXOperatorCallExpr /*P*/ S, 
                  final type$ref<UnaryOperatorKind /*&*/> UnaryOp, 
                  final type$ref<BinaryOperatorKind /*&*/> BinaryOp) {
  switch (S.getOperator()) {
   case OO_None:
   case OO_New:
   case OO_Delete:
   case OO_Array_New:
   case OO_Array_Delete:
   case OO_Arrow:
   case OO_Call:
   case OO_Conditional:
   case OO_Coawait:
   case NUM_OVERLOADED_OPERATORS:
    throw new llvm_unreachable("Invalid operator call kind");
   case OO_Plus:
    if (S.getNumArgs() == 1) {
      UnaryOp.$set(UnaryOperatorKind.UO_Plus);
      return Stmt.StmtClass.UnaryOperatorClass;
    }
    
    BinaryOp.$set(BinaryOperatorKind.BO_Add);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Minus:
    if (S.getNumArgs() == 1) {
      UnaryOp.$set(UnaryOperatorKind.UO_Minus);
      return Stmt.StmtClass.UnaryOperatorClass;
    }
    
    BinaryOp.$set(BinaryOperatorKind.BO_Sub);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Star:
    if (S.getNumArgs() == 1) {
      UnaryOp.$set(UnaryOperatorKind.UO_Deref);
      return Stmt.StmtClass.UnaryOperatorClass;
    }
    
    BinaryOp.$set(BinaryOperatorKind.BO_Mul);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Slash:
    BinaryOp.$set(BinaryOperatorKind.BO_Div);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Percent:
    BinaryOp.$set(BinaryOperatorKind.BO_Rem);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Caret:
    BinaryOp.$set(BinaryOperatorKind.BO_Xor);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Amp:
    if (S.getNumArgs() == 1) {
      UnaryOp.$set(UnaryOperatorKind.UO_AddrOf);
      return Stmt.StmtClass.UnaryOperatorClass;
    }
    
    BinaryOp.$set(BinaryOperatorKind.BO_And);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Pipe:
    BinaryOp.$set(BinaryOperatorKind.BO_Or);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Tilde:
    UnaryOp.$set(UnaryOperatorKind.UO_Not);
    return Stmt.StmtClass.UnaryOperatorClass;
   case OO_Exclaim:
    UnaryOp.$set(UnaryOperatorKind.UO_LNot);
    return Stmt.StmtClass.UnaryOperatorClass;
   case OO_Equal:
    BinaryOp.$set(BinaryOperatorKind.BO_Assign);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Less:
    BinaryOp.$set(BinaryOperatorKind.BO_LT);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Greater:
    BinaryOp.$set(BinaryOperatorKind.BO_GT);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_PlusEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_AddAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_MinusEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_SubAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_StarEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_MulAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_SlashEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_DivAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_PercentEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_RemAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_CaretEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_XorAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_AmpEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_AndAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_PipeEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_OrAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_LessLess:
    BinaryOp.$set(BinaryOperatorKind.BO_Shl);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_GreaterGreater:
    BinaryOp.$set(BinaryOperatorKind.BO_Shr);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_LessLessEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_ShlAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_GreaterGreaterEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_ShrAssign);
    return Stmt.StmtClass.CompoundAssignOperatorClass;
   case OO_EqualEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_EQ);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_ExclaimEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_NE);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_LessEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_LE);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_GreaterEqual:
    BinaryOp.$set(BinaryOperatorKind.BO_GE);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_AmpAmp:
    BinaryOp.$set(BinaryOperatorKind.BO_LAnd);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_PipePipe:
    BinaryOp.$set(BinaryOperatorKind.BO_LOr);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_PlusPlus:
    UnaryOp.$set(S.getNumArgs() == 1 ? UnaryOperatorKind.UO_PreInc : UnaryOperatorKind.UO_PostInc);
    return Stmt.StmtClass.UnaryOperatorClass;
   case OO_MinusMinus:
    UnaryOp.$set(S.getNumArgs() == 1 ? UnaryOperatorKind.UO_PreDec : UnaryOperatorKind.UO_PostDec);
    return Stmt.StmtClass.UnaryOperatorClass;
   case OO_Comma:
    BinaryOp.$set(BinaryOperatorKind.BO_Comma);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_ArrowStar:
    BinaryOp.$set(BinaryOperatorKind.BO_PtrMemI);
    return Stmt.StmtClass.BinaryOperatorClass;
   case OO_Subscript:
    return Stmt.StmtClass.ArraySubscriptExprClass;
  }
  throw new llvm_unreachable("Invalid overloaded operator expression");
}

} // END OF class StmtProfileStatics
