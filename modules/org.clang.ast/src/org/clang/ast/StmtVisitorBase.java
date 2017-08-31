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

package org.clang.ast;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;


/// StmtVisitorBase - This class implements a simple visitor for Stmt
/// subclasses. Since Expr derives from Stmt, this also includes support for
/// visiting Exprs.
/*template <template <typename > class Ptr, typename ImplClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*has specializations*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 32,
 FQN="clang::StmtVisitorBase", NM="_ZN5clang15StmtVisitorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBaseE")
//</editor-fold>
public interface/*class*/ StmtVisitorBase</*template <typename > TEMPLATE*/
/*class*/ Ptr, /*typename*/ ImplClass extends StmtVisitorBase<?, ?, RetTy>, /*typename*/ RetTy/* = void*/>  {
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::Visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 40,
   FQN="clang::StmtVisitorBase::Visit", NM="_ZN5clang15StmtVisitorBase5VisitENT_INS_4StmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase5VisitENT_INS_4StmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy Visit(Stmt/*P*/ S) {
    {
      
      // If we have a binary expr, dispatch to the subcode of the binop.  A smart
      // optimizer (e.g. LLVM) will fold this comparison into the switch stmt
      // below.
      BinaryOperator/*P*/ BinOp = dyn_cast(BinaryOperator.class, S);
      if (BinOp != null) {
        switch (BinOp.getOpcode()) {
         case BO_PtrMemD:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinPtrMemD(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_PtrMemI:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinPtrMemI(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Mul:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinMul(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Div:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinDiv(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Rem:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinRem(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Add:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinAdd(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Sub:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinSub(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Shl:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinShl(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Shr:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinShr(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_LT:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinLT(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_GT:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinGT(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_LE:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinLE(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_GE:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinGE(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_EQ:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinEQ(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_NE:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinNE(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_And:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinAnd(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Xor:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinXor(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Or:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinOr(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_LAnd:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinLAnd(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_LOr:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinLOr(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_Assign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinAssign(((/*static_cast*/BinaryOperator/*P*/)(S)));
         case BO_MulAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinMulAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_DivAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinDivAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_RemAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinRemAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_AddAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinAddAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_SubAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinSubAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_ShlAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinShlAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_ShrAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinShrAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_AndAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinAndAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_OrAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinOrAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_XorAssign:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinXorAssign(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
         case BO_Comma:
          return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinComma(((/*static_cast*/BinaryOperator/*P*/)(S)));
        }
      } else {
        UnaryOperator/*P*/ UnOp = dyn_cast(UnaryOperator.class, S);
        if (UnOp != null) {
          switch (UnOp.getOpcode()) {
           case UO_PostInc:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryPostInc(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_PostDec:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryPostDec(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_PreInc:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryPreInc(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_PreDec:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryPreDec(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_AddrOf:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryAddrOf(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_Deref:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryDeref(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_Plus:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryPlus(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_Minus:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryMinus(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_Not:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryNot(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_LNot:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryLNot(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_Real:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryReal(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_Imag:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryImag(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_Extension:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryExtension(((/*static_cast*/UnaryOperator/*P*/)(S)));
           case UO_Coawait:
            return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryCoawait(((/*static_cast*/UnaryOperator/*P*/)(S)));
          }
        }
      }
    }
    
    // Top switch stmt: dispatch to VisitFooStmt for each FooStmt.
    switch (S.getStmtClass()) {
     default:
      throw new llvm_unreachable("Unknown stmt kind!");
     case GCCAsmStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitGCCAsmStmt(((/*static_cast*/GCCAsmStmt/*P*/)(S)));
     case MSAsmStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMSAsmStmt(((/*static_cast*/MSAsmStmt/*P*/)(S)));
     case AttributedStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAttributedStmt(((/*static_cast*/AttributedStmt/*P*/)(S)));
     case BreakStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBreakStmt(((/*static_cast*/BreakStmt/*P*/)(S)));
     case CXXCatchStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXCatchStmt(((/*static_cast*/CXXCatchStmt/*P*/)(S)));
     case CXXForRangeStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXForRangeStmt(((/*static_cast*/CXXForRangeStmt/*P*/)(S)));
     case CXXTryStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXTryStmt(((/*static_cast*/CXXTryStmt/*P*/)(S)));
     case CapturedStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCapturedStmt(((/*static_cast*/CapturedStmt/*P*/)(S)));
     case CompoundStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundStmt(((/*static_cast*/CompoundStmt/*P*/)(S)));
     case ContinueStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitContinueStmt(((/*static_cast*/ContinueStmt/*P*/)(S)));
     case CoreturnStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCoreturnStmt(((/*static_cast*/CoreturnStmt/*P*/)(S)));
     case CoroutineBodyStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCoroutineBodyStmt(((/*static_cast*/CoroutineBodyStmt/*P*/)(S)));
     case DeclStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclStmt(((/*static_cast*/DeclStmt/*P*/)(S)));
     case DoStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDoStmt(((/*static_cast*/DoStmt/*P*/)(S)));
     case BinaryConditionalOperatorClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryConditionalOperator(((/*static_cast*/BinaryConditionalOperator/*P*/)(S)));
     case ConditionalOperatorClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitConditionalOperator(((/*static_cast*/ConditionalOperator/*P*/)(S)));
     case AddrLabelExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAddrLabelExpr(((/*static_cast*/AddrLabelExpr/*P*/)(S)));
     case ArraySubscriptExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArraySubscriptExpr(((/*static_cast*/ArraySubscriptExpr/*P*/)(S)));
     case ArrayTypeTraitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeTraitExpr(((/*static_cast*/ArrayTypeTraitExpr/*P*/)(S)));
     case AsTypeExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAsTypeExpr(((/*static_cast*/AsTypeExpr/*P*/)(S)));
     case AtomicExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAtomicExpr(((/*static_cast*/AtomicExpr/*P*/)(S)));
     case BinaryOperatorClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
     case CompoundAssignOperatorClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
     case BlockExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockExpr(((/*static_cast*/BlockExpr/*P*/)(S)));
     case CXXBindTemporaryExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXBindTemporaryExpr(((/*static_cast*/CXXBindTemporaryExpr/*P*/)(S)));
     case CXXBoolLiteralExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXBoolLiteralExpr(((/*static_cast*/CXXBoolLiteralExpr/*P*/)(S)));
     case CXXConstructExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXConstructExpr(((/*static_cast*/CXXConstructExpr/*P*/)(S)));
     case CXXTemporaryObjectExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXTemporaryObjectExpr(((/*static_cast*/CXXTemporaryObjectExpr/*P*/)(S)));
     case CXXDefaultArgExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXDefaultArgExpr(((/*static_cast*/CXXDefaultArgExpr/*P*/)(S)));
     case CXXDefaultInitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXDefaultInitExpr(((/*static_cast*/CXXDefaultInitExpr/*P*/)(S)));
     case CXXDeleteExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXDeleteExpr(((/*static_cast*/CXXDeleteExpr/*P*/)(S)));
     case CXXDependentScopeMemberExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXDependentScopeMemberExpr(((/*static_cast*/CXXDependentScopeMemberExpr/*P*/)(S)));
     case CXXFoldExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXFoldExpr(((/*static_cast*/CXXFoldExpr/*P*/)(S)));
     case CXXInheritedCtorInitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXInheritedCtorInitExpr(((/*static_cast*/CXXInheritedCtorInitExpr/*P*/)(S)));
     case CXXNewExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXNewExpr(((/*static_cast*/CXXNewExpr/*P*/)(S)));
     case CXXNoexceptExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXNoexceptExpr(((/*static_cast*/CXXNoexceptExpr/*P*/)(S)));
     case CXXNullPtrLiteralExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXNullPtrLiteralExpr(((/*static_cast*/CXXNullPtrLiteralExpr/*P*/)(S)));
     case CXXPseudoDestructorExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXPseudoDestructorExpr(((/*static_cast*/CXXPseudoDestructorExpr/*P*/)(S)));
     case CXXScalarValueInitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXScalarValueInitExpr(((/*static_cast*/CXXScalarValueInitExpr/*P*/)(S)));
     case CXXStdInitializerListExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXStdInitializerListExpr(((/*static_cast*/CXXStdInitializerListExpr/*P*/)(S)));
     case CXXThisExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXThisExpr(((/*static_cast*/CXXThisExpr/*P*/)(S)));
     case CXXThrowExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXThrowExpr(((/*static_cast*/CXXThrowExpr/*P*/)(S)));
     case CXXTypeidExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXTypeidExpr(((/*static_cast*/CXXTypeidExpr/*P*/)(S)));
     case CXXUnresolvedConstructExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXUnresolvedConstructExpr(((/*static_cast*/CXXUnresolvedConstructExpr/*P*/)(S)));
     case CXXUuidofExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXUuidofExpr(((/*static_cast*/CXXUuidofExpr/*P*/)(S)));
     case CallExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCallExpr(((/*static_cast*/CallExpr/*P*/)(S)));
     case CUDAKernelCallExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCUDAKernelCallExpr(((/*static_cast*/CUDAKernelCallExpr/*P*/)(S)));
     case CXXMemberCallExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXMemberCallExpr(((/*static_cast*/CXXMemberCallExpr/*P*/)(S)));
     case CXXOperatorCallExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXOperatorCallExpr(((/*static_cast*/CXXOperatorCallExpr/*P*/)(S)));
     case UserDefinedLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUserDefinedLiteral(((/*static_cast*/UserDefinedLiteral/*P*/)(S)));
     case CStyleCastExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCStyleCastExpr(((/*static_cast*/CStyleCastExpr/*P*/)(S)));
     case CXXFunctionalCastExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXFunctionalCastExpr(((/*static_cast*/CXXFunctionalCastExpr/*P*/)(S)));
     case CXXConstCastExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXConstCastExpr(((/*static_cast*/CXXConstCastExpr/*P*/)(S)));
     case CXXDynamicCastExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXDynamicCastExpr(((/*static_cast*/CXXDynamicCastExpr/*P*/)(S)));
     case CXXReinterpretCastExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXReinterpretCastExpr(((/*static_cast*/CXXReinterpretCastExpr/*P*/)(S)));
     case CXXStaticCastExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXStaticCastExpr(((/*static_cast*/CXXStaticCastExpr/*P*/)(S)));
     case ObjCBridgedCastExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCBridgedCastExpr(((/*static_cast*/ObjCBridgedCastExpr/*P*/)(S)));
     case ImplicitCastExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitImplicitCastExpr(((/*static_cast*/ImplicitCastExpr/*P*/)(S)));
     case CharacterLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCharacterLiteral(((/*static_cast*/CharacterLiteral/*P*/)(S)));
     case ChooseExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitChooseExpr(((/*static_cast*/ChooseExpr/*P*/)(S)));
     case CompoundLiteralExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundLiteralExpr(((/*static_cast*/CompoundLiteralExpr/*P*/)(S)));
     case ConvertVectorExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitConvertVectorExpr(((/*static_cast*/ConvertVectorExpr/*P*/)(S)));
     case CoawaitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCoawaitExpr(((/*static_cast*/CoawaitExpr/*P*/)(S)));
     case CoyieldExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCoyieldExpr(((/*static_cast*/CoyieldExpr/*P*/)(S)));
     case DeclRefExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclRefExpr(((/*static_cast*/DeclRefExpr/*P*/)(S)));
     case DependentScopeDeclRefExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentScopeDeclRefExpr(((/*static_cast*/DependentScopeDeclRefExpr/*P*/)(S)));
     case DesignatedInitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDesignatedInitExpr(((/*static_cast*/DesignatedInitExpr/*P*/)(S)));
     case DesignatedInitUpdateExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDesignatedInitUpdateExpr(((/*static_cast*/DesignatedInitUpdateExpr/*P*/)(S)));
     case ExprWithCleanupsClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExprWithCleanups(((/*static_cast*/ExprWithCleanups/*P*/)(S)));
     case ExpressionTraitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpressionTraitExpr(((/*static_cast*/ExpressionTraitExpr/*P*/)(S)));
     case ExtVectorElementExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExtVectorElementExpr(((/*static_cast*/ExtVectorElementExpr/*P*/)(S)));
     case FloatingLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFloatingLiteral(((/*static_cast*/FloatingLiteral/*P*/)(S)));
     case FunctionParmPackExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionParmPackExpr(((/*static_cast*/FunctionParmPackExpr/*P*/)(S)));
     case GNUNullExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitGNUNullExpr(((/*static_cast*/GNUNullExpr/*P*/)(S)));
     case GenericSelectionExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitGenericSelectionExpr(((/*static_cast*/GenericSelectionExpr/*P*/)(S)));
     case ImaginaryLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitImaginaryLiteral(((/*static_cast*/ImaginaryLiteral/*P*/)(S)));
     case ImplicitValueInitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitImplicitValueInitExpr(((/*static_cast*/ImplicitValueInitExpr/*P*/)(S)));
     case InitListExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitInitListExpr(((/*static_cast*/InitListExpr/*P*/)(S)));
     case IntegerLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIntegerLiteral(((/*static_cast*/IntegerLiteral/*P*/)(S)));
     case LambdaExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLambdaExpr(((/*static_cast*/LambdaExpr/*P*/)(S)));
     case MSPropertyRefExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMSPropertyRefExpr(((/*static_cast*/MSPropertyRefExpr/*P*/)(S)));
     case MSPropertySubscriptExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMSPropertySubscriptExpr(((/*static_cast*/MSPropertySubscriptExpr/*P*/)(S)));
     case MaterializeTemporaryExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMaterializeTemporaryExpr(((/*static_cast*/MaterializeTemporaryExpr/*P*/)(S)));
     case MemberExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemberExpr(((/*static_cast*/MemberExpr/*P*/)(S)));
     case NoInitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNoInitExpr(((/*static_cast*/NoInitExpr/*P*/)(S)));
     case OMPArraySectionExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPArraySectionExpr(((/*static_cast*/OMPArraySectionExpr/*P*/)(S)));
     case ObjCArrayLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCArrayLiteral(((/*static_cast*/ObjCArrayLiteral/*P*/)(S)));
     case ObjCAvailabilityCheckExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCAvailabilityCheckExpr(((/*static_cast*/ObjCAvailabilityCheckExpr/*P*/)(S)));
     case ObjCBoolLiteralExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCBoolLiteralExpr(((/*static_cast*/ObjCBoolLiteralExpr/*P*/)(S)));
     case ObjCBoxedExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCBoxedExpr(((/*static_cast*/ObjCBoxedExpr/*P*/)(S)));
     case ObjCDictionaryLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCDictionaryLiteral(((/*static_cast*/ObjCDictionaryLiteral/*P*/)(S)));
     case ObjCEncodeExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCEncodeExpr(((/*static_cast*/ObjCEncodeExpr/*P*/)(S)));
     case ObjCIndirectCopyRestoreExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCIndirectCopyRestoreExpr(((/*static_cast*/ObjCIndirectCopyRestoreExpr/*P*/)(S)));
     case ObjCIsaExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCIsaExpr(((/*static_cast*/ObjCIsaExpr/*P*/)(S)));
     case ObjCIvarRefExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCIvarRefExpr(((/*static_cast*/ObjCIvarRefExpr/*P*/)(S)));
     case ObjCMessageExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCMessageExpr(((/*static_cast*/ObjCMessageExpr/*P*/)(S)));
     case ObjCPropertyRefExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCPropertyRefExpr(((/*static_cast*/ObjCPropertyRefExpr/*P*/)(S)));
     case ObjCProtocolExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCProtocolExpr(((/*static_cast*/ObjCProtocolExpr/*P*/)(S)));
     case ObjCSelectorExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCSelectorExpr(((/*static_cast*/ObjCSelectorExpr/*P*/)(S)));
     case ObjCStringLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCStringLiteral(((/*static_cast*/ObjCStringLiteral/*P*/)(S)));
     case ObjCSubscriptRefExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCSubscriptRefExpr(((/*static_cast*/ObjCSubscriptRefExpr/*P*/)(S)));
     case OffsetOfExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOffsetOfExpr(((/*static_cast*/OffsetOfExpr/*P*/)(S)));
     case OpaqueValueExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOpaqueValueExpr(((/*static_cast*/OpaqueValueExpr/*P*/)(S)));
     case UnresolvedLookupExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedLookupExpr(((/*static_cast*/UnresolvedLookupExpr/*P*/)(S)));
     case UnresolvedMemberExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedMemberExpr(((/*static_cast*/UnresolvedMemberExpr/*P*/)(S)));
     case PackExpansionExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPackExpansionExpr(((/*static_cast*/PackExpansionExpr/*P*/)(S)));
     case ParenExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitParenExpr(((/*static_cast*/ParenExpr/*P*/)(S)));
     case ParenListExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitParenListExpr(((/*static_cast*/ParenListExpr/*P*/)(S)));
     case PredefinedExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPredefinedExpr(((/*static_cast*/PredefinedExpr/*P*/)(S)));
     case PseudoObjectExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPseudoObjectExpr(((/*static_cast*/PseudoObjectExpr/*P*/)(S)));
     case ShuffleVectorExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitShuffleVectorExpr(((/*static_cast*/ShuffleVectorExpr/*P*/)(S)));
     case SizeOfPackExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSizeOfPackExpr(((/*static_cast*/SizeOfPackExpr/*P*/)(S)));
     case StmtExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmtExpr(((/*static_cast*/StmtExpr/*P*/)(S)));
     case StringLiteralClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStringLiteral(((/*static_cast*/StringLiteral/*P*/)(S)));
     case SubstNonTypeTemplateParmExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstNonTypeTemplateParmExpr(((/*static_cast*/SubstNonTypeTemplateParmExpr/*P*/)(S)));
     case SubstNonTypeTemplateParmPackExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstNonTypeTemplateParmPackExpr(((/*static_cast*/SubstNonTypeTemplateParmPackExpr/*P*/)(S)));
     case TypeTraitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeTraitExpr(((/*static_cast*/TypeTraitExpr/*P*/)(S)));
     case TypoExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypoExpr(((/*static_cast*/TypoExpr/*P*/)(S)));
     case UnaryExprOrTypeTraitExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryExprOrTypeTraitExpr(((/*static_cast*/UnaryExprOrTypeTraitExpr/*P*/)(S)));
     case UnaryOperatorClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
     case VAArgExprClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVAArgExpr(((/*static_cast*/VAArgExpr/*P*/)(S)));
     case ForStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitForStmt(((/*static_cast*/ForStmt/*P*/)(S)));
     case GotoStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitGotoStmt(((/*static_cast*/GotoStmt/*P*/)(S)));
     case IfStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIfStmt(((/*static_cast*/IfStmt/*P*/)(S)));
     case IndirectGotoStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIndirectGotoStmt(((/*static_cast*/IndirectGotoStmt/*P*/)(S)));
     case LabelStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLabelStmt(((/*static_cast*/LabelStmt/*P*/)(S)));
     case MSDependentExistsStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMSDependentExistsStmt(((/*static_cast*/MSDependentExistsStmt/*P*/)(S)));
     case NullStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNullStmt(((/*static_cast*/NullStmt/*P*/)(S)));
     case OMPAtomicDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPAtomicDirective(((/*static_cast*/OMPAtomicDirective/*P*/)(S)));
     case OMPBarrierDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPBarrierDirective(((/*static_cast*/OMPBarrierDirective/*P*/)(S)));
     case OMPCancelDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPCancelDirective(((/*static_cast*/OMPCancelDirective/*P*/)(S)));
     case OMPCancellationPointDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPCancellationPointDirective(((/*static_cast*/OMPCancellationPointDirective/*P*/)(S)));
     case OMPCriticalDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPCriticalDirective(((/*static_cast*/OMPCriticalDirective/*P*/)(S)));
     case OMPFlushDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPFlushDirective(((/*static_cast*/OMPFlushDirective/*P*/)(S)));
     case OMPDistributeDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDistributeDirective(((/*static_cast*/OMPDistributeDirective/*P*/)(S)));
     case OMPDistributeParallelForDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDistributeParallelForDirective(((/*static_cast*/OMPDistributeParallelForDirective/*P*/)(S)));
     case OMPDistributeParallelForSimdDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDistributeParallelForSimdDirective(((/*static_cast*/OMPDistributeParallelForSimdDirective/*P*/)(S)));
     case OMPDistributeSimdDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDistributeSimdDirective(((/*static_cast*/OMPDistributeSimdDirective/*P*/)(S)));
     case OMPForDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPForDirective(((/*static_cast*/OMPForDirective/*P*/)(S)));
     case OMPForSimdDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPForSimdDirective(((/*static_cast*/OMPForSimdDirective/*P*/)(S)));
     case OMPParallelForDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPParallelForDirective(((/*static_cast*/OMPParallelForDirective/*P*/)(S)));
     case OMPParallelForSimdDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPParallelForSimdDirective(((/*static_cast*/OMPParallelForSimdDirective/*P*/)(S)));
     case OMPSimdDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSimdDirective(((/*static_cast*/OMPSimdDirective/*P*/)(S)));
     case OMPTargetParallelForSimdDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTargetParallelForSimdDirective(((/*static_cast*/OMPTargetParallelForSimdDirective/*P*/)(S)));
     case OMPTaskLoopDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTaskLoopDirective(((/*static_cast*/OMPTaskLoopDirective/*P*/)(S)));
     case OMPTaskLoopSimdDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTaskLoopSimdDirective(((/*static_cast*/OMPTaskLoopSimdDirective/*P*/)(S)));
     case OMPMasterDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPMasterDirective(((/*static_cast*/OMPMasterDirective/*P*/)(S)));
     case OMPOrderedDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPOrderedDirective(((/*static_cast*/OMPOrderedDirective/*P*/)(S)));
     case OMPParallelDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPParallelDirective(((/*static_cast*/OMPParallelDirective/*P*/)(S)));
     case OMPParallelSectionsDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPParallelSectionsDirective(((/*static_cast*/OMPParallelSectionsDirective/*P*/)(S)));
     case OMPSectionDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSectionDirective(((/*static_cast*/OMPSectionDirective/*P*/)(S)));
     case OMPSectionsDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSectionsDirective(((/*static_cast*/OMPSectionsDirective/*P*/)(S)));
     case OMPSingleDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSingleDirective(((/*static_cast*/OMPSingleDirective/*P*/)(S)));
     case OMPTargetDataDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTargetDataDirective(((/*static_cast*/OMPTargetDataDirective/*P*/)(S)));
     case OMPTargetDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTargetDirective(((/*static_cast*/OMPTargetDirective/*P*/)(S)));
     case OMPTargetEnterDataDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTargetEnterDataDirective(((/*static_cast*/OMPTargetEnterDataDirective/*P*/)(S)));
     case OMPTargetExitDataDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTargetExitDataDirective(((/*static_cast*/OMPTargetExitDataDirective/*P*/)(S)));
     case OMPTargetParallelDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTargetParallelDirective(((/*static_cast*/OMPTargetParallelDirective/*P*/)(S)));
     case OMPTargetParallelForDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTargetParallelForDirective(((/*static_cast*/OMPTargetParallelForDirective/*P*/)(S)));
     case OMPTargetUpdateDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTargetUpdateDirective(((/*static_cast*/OMPTargetUpdateDirective/*P*/)(S)));
     case OMPTaskDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTaskDirective(((/*static_cast*/OMPTaskDirective/*P*/)(S)));
     case OMPTaskgroupDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTaskgroupDirective(((/*static_cast*/OMPTaskgroupDirective/*P*/)(S)));
     case OMPTaskwaitDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTaskwaitDirective(((/*static_cast*/OMPTaskwaitDirective/*P*/)(S)));
     case OMPTaskyieldDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTaskyieldDirective(((/*static_cast*/OMPTaskyieldDirective/*P*/)(S)));
     case OMPTeamsDirectiveClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPTeamsDirective(((/*static_cast*/OMPTeamsDirective/*P*/)(S)));
     case ObjCAtCatchStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCAtCatchStmt(((/*static_cast*/ObjCAtCatchStmt/*P*/)(S)));
     case ObjCAtFinallyStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCAtFinallyStmt(((/*static_cast*/ObjCAtFinallyStmt/*P*/)(S)));
     case ObjCAtSynchronizedStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCAtSynchronizedStmt(((/*static_cast*/ObjCAtSynchronizedStmt/*P*/)(S)));
     case ObjCAtThrowStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCAtThrowStmt(((/*static_cast*/ObjCAtThrowStmt/*P*/)(S)));
     case ObjCAtTryStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCAtTryStmt(((/*static_cast*/ObjCAtTryStmt/*P*/)(S)));
     case ObjCAutoreleasePoolStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCAutoreleasePoolStmt(((/*static_cast*/ObjCAutoreleasePoolStmt/*P*/)(S)));
     case ObjCForCollectionStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCForCollectionStmt(((/*static_cast*/ObjCForCollectionStmt/*P*/)(S)));
     case ReturnStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitReturnStmt(((/*static_cast*/ReturnStmt/*P*/)(S)));
     case SEHExceptStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSEHExceptStmt(((/*static_cast*/SEHExceptStmt/*P*/)(S)));
     case SEHFinallyStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSEHFinallyStmt(((/*static_cast*/SEHFinallyStmt/*P*/)(S)));
     case SEHLeaveStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSEHLeaveStmt(((/*static_cast*/SEHLeaveStmt/*P*/)(S)));
     case SEHTryStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSEHTryStmt(((/*static_cast*/SEHTryStmt/*P*/)(S)));
     case CaseStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCaseStmt(((/*static_cast*/CaseStmt/*P*/)(S)));
     case DefaultStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDefaultStmt(((/*static_cast*/DefaultStmt/*P*/)(S)));
     case SwitchStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSwitchStmt(((/*static_cast*/SwitchStmt/*P*/)(S)));
     case WhileStmtClass:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitWhileStmt(((/*static_cast*/WhileStmt/*P*/)(S)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 23,
   FQN="clang::StmtVisitorBase::VisitAsmStmt", NM="_ZN5clang15StmtVisitorBase12VisitAsmStmtENT_INS_7AsmStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase12VisitAsmStmtENT_INS_7AsmStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitAsmStmt(AsmStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitGCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 27,
   FQN="clang::StmtVisitorBase::VisitGCCAsmStmt", NM="_ZN5clang15StmtVisitorBase15VisitGCCAsmStmtENT_INS_10GCCAsmStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitGCCAsmStmtENT_INS_10GCCAsmStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitGCCAsmStmt(GCCAsmStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAsmStmt(((/*static_cast*/AsmStmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitMSAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 33,
   FQN="clang::StmtVisitorBase::VisitMSAsmStmt", NM="_ZN5clang15StmtVisitorBase14VisitMSAsmStmtENT_INS_9MSAsmStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitMSAsmStmtENT_INS_9MSAsmStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitMSAsmStmt(MSAsmStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAsmStmt(((/*static_cast*/AsmStmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 43,
   FQN="clang::StmtVisitorBase::VisitAttributedStmt", NM="_ZN5clang15StmtVisitorBase19VisitAttributedStmtENT_INS_14AttributedStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitAttributedStmtENT_INS_14AttributedStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitAttributedStmt(AttributedStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 49,
   FQN="clang::StmtVisitorBase::VisitBreakStmt", NM="_ZN5clang15StmtVisitorBase14VisitBreakStmtENT_INS_9BreakStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitBreakStmtENT_INS_9BreakStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBreakStmt(BreakStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 55,
   FQN="clang::StmtVisitorBase::VisitCXXCatchStmt", NM="_ZN5clang15StmtVisitorBase17VisitCXXCatchStmtENT_INS_12CXXCatchStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitCXXCatchStmtENT_INS_12CXXCatchStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXCatchStmt(CXXCatchStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 61,
   FQN="clang::StmtVisitorBase::VisitCXXForRangeStmt", NM="_ZN5clang15StmtVisitorBase20VisitCXXForRangeStmtENT_INS_15CXXForRangeStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitCXXForRangeStmtENT_INS_15CXXForRangeStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXForRangeStmt(CXXForRangeStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 67,
   FQN="clang::StmtVisitorBase::VisitCXXTryStmt", NM="_ZN5clang15StmtVisitorBase15VisitCXXTryStmtENT_INS_10CXXTryStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitCXXTryStmtENT_INS_10CXXTryStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXTryStmt(CXXTryStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 73,
   FQN="clang::StmtVisitorBase::VisitCapturedStmt", NM="_ZN5clang15StmtVisitorBase17VisitCapturedStmtENT_INS_12CapturedStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitCapturedStmtENT_INS_12CapturedStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCapturedStmt(CapturedStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 79,
   FQN="clang::StmtVisitorBase::VisitCompoundStmt", NM="_ZN5clang15StmtVisitorBase17VisitCompoundStmtENT_INS_12CompoundStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitCompoundStmtENT_INS_12CompoundStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCompoundStmt(CompoundStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 85,
   FQN="clang::StmtVisitorBase::VisitContinueStmt", NM="_ZN5clang15StmtVisitorBase17VisitContinueStmtENT_INS_12ContinueStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitContinueStmtENT_INS_12ContinueStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitContinueStmt(ContinueStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCoreturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 91,
   FQN="clang::StmtVisitorBase::VisitCoreturnStmt", NM="_ZN5clang15StmtVisitorBase17VisitCoreturnStmtENT_INS_12CoreturnStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitCoreturnStmtENT_INS_12CoreturnStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCoreturnStmt(CoreturnStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCoroutineBodyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 97,
   FQN="clang::StmtVisitorBase::VisitCoroutineBodyStmt", NM="_ZN5clang15StmtVisitorBase22VisitCoroutineBodyStmtENT_INS_17CoroutineBodyStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitCoroutineBodyStmtENT_INS_17CoroutineBodyStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCoroutineBodyStmt(CoroutineBodyStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 103,
   FQN="clang::StmtVisitorBase::VisitDeclStmt", NM="_ZN5clang15StmtVisitorBase13VisitDeclStmtENT_INS_8DeclStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitDeclStmtENT_INS_8DeclStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDeclStmt(DeclStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 109,
   FQN="clang::StmtVisitorBase::VisitDoStmt", NM="_ZN5clang15StmtVisitorBase11VisitDoStmtENT_INS_6DoStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitDoStmtENT_INS_6DoStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDoStmt(DoStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 115,
   FQN="clang::StmtVisitorBase::VisitExpr", NM="_ZN5clang15StmtVisitorBase9VisitExprENT_INS_4ExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase9VisitExprENT_INS_4ExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitExpr(Expr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 119,
   FQN="clang::StmtVisitorBase::VisitAbstractConditionalOperator", NM="_ZN5clang15StmtVisitorBase32VisitAbstractConditionalOperatorENT_INS_27AbstractConditionalOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase32VisitAbstractConditionalOperatorENT_INS_27AbstractConditionalOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitAbstractConditionalOperator(AbstractConditionalOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 123,
   FQN="clang::StmtVisitorBase::VisitBinaryConditionalOperator", NM="_ZN5clang15StmtVisitorBase30VisitBinaryConditionalOperatorENT_INS_25BinaryConditionalOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase30VisitBinaryConditionalOperatorENT_INS_25BinaryConditionalOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinaryConditionalOperator(BinaryConditionalOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAbstractConditionalOperator(((/*static_cast*/AbstractConditionalOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 129,
   FQN="clang::StmtVisitorBase::VisitConditionalOperator", NM="_ZN5clang15StmtVisitorBase24VisitConditionalOperatorENT_INS_19ConditionalOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitConditionalOperatorENT_INS_19ConditionalOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitConditionalOperator(ConditionalOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAbstractConditionalOperator(((/*static_cast*/AbstractConditionalOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 139,
   FQN="clang::StmtVisitorBase::VisitAddrLabelExpr", NM="_ZN5clang15StmtVisitorBase18VisitAddrLabelExprENT_INS_13AddrLabelExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitAddrLabelExprENT_INS_13AddrLabelExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitAddrLabelExpr(AddrLabelExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 145,
   FQN="clang::StmtVisitorBase::VisitArraySubscriptExpr", NM="_ZN5clang15StmtVisitorBase23VisitArraySubscriptExprENT_INS_18ArraySubscriptExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitArraySubscriptExprENT_INS_18ArraySubscriptExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitArraySubscriptExpr(ArraySubscriptExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 151,
   FQN="clang::StmtVisitorBase::VisitArrayTypeTraitExpr", NM="_ZN5clang15StmtVisitorBase23VisitArrayTypeTraitExprENT_INS_18ArrayTypeTraitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitArrayTypeTraitExprENT_INS_18ArrayTypeTraitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitArrayTypeTraitExpr(ArrayTypeTraitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitAsTypeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 157,
   FQN="clang::StmtVisitorBase::VisitAsTypeExpr", NM="_ZN5clang15StmtVisitorBase15VisitAsTypeExprENT_INS_10AsTypeExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitAsTypeExprENT_INS_10AsTypeExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitAsTypeExpr(AsTypeExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 163,
   FQN="clang::StmtVisitorBase::VisitAtomicExpr", NM="_ZN5clang15StmtVisitorBase15VisitAtomicExprENT_INS_10AtomicExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitAtomicExprENT_INS_10AtomicExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitAtomicExpr(AtomicExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 169,
   FQN="clang::StmtVisitorBase::VisitBinaryOperator", NM="_ZN5clang15StmtVisitorBase19VisitBinaryOperatorENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitBinaryOperatorENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinaryOperator(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 173,
   FQN="clang::StmtVisitorBase::VisitCompoundAssignOperator", NM="_ZN5clang15StmtVisitorBase27VisitCompoundAssignOperatorENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase27VisitCompoundAssignOperatorENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCompoundAssignOperator(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 183,
   FQN="clang::StmtVisitorBase::VisitBlockExpr", NM="_ZN5clang15StmtVisitorBase14VisitBlockExprENT_INS_9BlockExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitBlockExprENT_INS_9BlockExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBlockExpr(BlockExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 189,
   FQN="clang::StmtVisitorBase::VisitCXXBindTemporaryExpr", NM="_ZN5clang15StmtVisitorBase25VisitCXXBindTemporaryExprENT_INS_20CXXBindTemporaryExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitCXXBindTemporaryExprENT_INS_20CXXBindTemporaryExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXBindTemporaryExpr(CXXBindTemporaryExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 195,
   FQN="clang::StmtVisitorBase::VisitCXXBoolLiteralExpr", NM="_ZN5clang15StmtVisitorBase23VisitCXXBoolLiteralExprENT_INS_18CXXBoolLiteralExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitCXXBoolLiteralExprENT_INS_18CXXBoolLiteralExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXBoolLiteralExpr(CXXBoolLiteralExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 201,
   FQN="clang::StmtVisitorBase::VisitCXXConstructExpr", NM="_ZN5clang15StmtVisitorBase21VisitCXXConstructExprENT_INS_16CXXConstructExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitCXXConstructExprENT_INS_16CXXConstructExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXConstructExpr(CXXConstructExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 205,
   FQN="clang::StmtVisitorBase::VisitCXXTemporaryObjectExpr", NM="_ZN5clang15StmtVisitorBase27VisitCXXTemporaryObjectExprENT_INS_22CXXTemporaryObjectExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase27VisitCXXTemporaryObjectExprENT_INS_22CXXTemporaryObjectExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXTemporaryObjectExpr(CXXTemporaryObjectExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXConstructExpr(((/*static_cast*/CXXConstructExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 215,
   FQN="clang::StmtVisitorBase::VisitCXXDefaultArgExpr", NM="_ZN5clang15StmtVisitorBase22VisitCXXDefaultArgExprENT_INS_17CXXDefaultArgExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitCXXDefaultArgExprENT_INS_17CXXDefaultArgExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXDefaultArgExpr(CXXDefaultArgExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 221,
   FQN="clang::StmtVisitorBase::VisitCXXDefaultInitExpr", NM="_ZN5clang15StmtVisitorBase23VisitCXXDefaultInitExprENT_INS_18CXXDefaultInitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitCXXDefaultInitExprENT_INS_18CXXDefaultInitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXDefaultInitExpr(CXXDefaultInitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 227,
   FQN="clang::StmtVisitorBase::VisitCXXDeleteExpr", NM="_ZN5clang15StmtVisitorBase18VisitCXXDeleteExprENT_INS_13CXXDeleteExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitCXXDeleteExprENT_INS_13CXXDeleteExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXDeleteExpr(CXXDeleteExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 233,
   FQN="clang::StmtVisitorBase::VisitCXXDependentScopeMemberExpr", NM="_ZN5clang15StmtVisitorBase32VisitCXXDependentScopeMemberExprENT_INS_27CXXDependentScopeMemberExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase32VisitCXXDependentScopeMemberExprENT_INS_27CXXDependentScopeMemberExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXDependentScopeMemberExpr(CXXDependentScopeMemberExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXFoldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 239,
   FQN="clang::StmtVisitorBase::VisitCXXFoldExpr", NM="_ZN5clang15StmtVisitorBase16VisitCXXFoldExprENT_INS_11CXXFoldExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitCXXFoldExprENT_INS_11CXXFoldExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXFoldExpr(CXXFoldExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 245,
   FQN="clang::StmtVisitorBase::VisitCXXInheritedCtorInitExpr", NM="_ZN5clang15StmtVisitorBase29VisitCXXInheritedCtorInitExprENT_INS_24CXXInheritedCtorInitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase29VisitCXXInheritedCtorInitExprENT_INS_24CXXInheritedCtorInitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXInheritedCtorInitExpr(CXXInheritedCtorInitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 251,
   FQN="clang::StmtVisitorBase::VisitCXXNewExpr", NM="_ZN5clang15StmtVisitorBase15VisitCXXNewExprENT_INS_10CXXNewExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitCXXNewExprENT_INS_10CXXNewExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXNewExpr(CXXNewExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 257,
   FQN="clang::StmtVisitorBase::VisitCXXNoexceptExpr", NM="_ZN5clang15StmtVisitorBase20VisitCXXNoexceptExprENT_INS_15CXXNoexceptExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitCXXNoexceptExprENT_INS_15CXXNoexceptExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXNoexceptExpr(CXXNoexceptExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 263,
   FQN="clang::StmtVisitorBase::VisitCXXNullPtrLiteralExpr", NM="_ZN5clang15StmtVisitorBase26VisitCXXNullPtrLiteralExprENT_INS_21CXXNullPtrLiteralExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase26VisitCXXNullPtrLiteralExprENT_INS_21CXXNullPtrLiteralExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXNullPtrLiteralExpr(CXXNullPtrLiteralExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 269,
   FQN="clang::StmtVisitorBase::VisitCXXPseudoDestructorExpr", NM="_ZN5clang15StmtVisitorBase28VisitCXXPseudoDestructorExprENT_INS_23CXXPseudoDestructorExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase28VisitCXXPseudoDestructorExprENT_INS_23CXXPseudoDestructorExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXPseudoDestructorExpr(CXXPseudoDestructorExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 275,
   FQN="clang::StmtVisitorBase::VisitCXXScalarValueInitExpr", NM="_ZN5clang15StmtVisitorBase27VisitCXXScalarValueInitExprENT_INS_22CXXScalarValueInitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase27VisitCXXScalarValueInitExprENT_INS_22CXXScalarValueInitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXScalarValueInitExpr(CXXScalarValueInitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 281,
   FQN="clang::StmtVisitorBase::VisitCXXStdInitializerListExpr", NM="_ZN5clang15StmtVisitorBase30VisitCXXStdInitializerListExprENT_INS_25CXXStdInitializerListExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase30VisitCXXStdInitializerListExprENT_INS_25CXXStdInitializerListExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXStdInitializerListExpr(CXXStdInitializerListExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 287,
   FQN="clang::StmtVisitorBase::VisitCXXThisExpr", NM="_ZN5clang15StmtVisitorBase16VisitCXXThisExprENT_INS_11CXXThisExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitCXXThisExprENT_INS_11CXXThisExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXThisExpr(CXXThisExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 293,
   FQN="clang::StmtVisitorBase::VisitCXXThrowExpr", NM="_ZN5clang15StmtVisitorBase17VisitCXXThrowExprENT_INS_12CXXThrowExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitCXXThrowExprENT_INS_12CXXThrowExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXThrowExpr(CXXThrowExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 299,
   FQN="clang::StmtVisitorBase::VisitCXXTypeidExpr", NM="_ZN5clang15StmtVisitorBase18VisitCXXTypeidExprENT_INS_13CXXTypeidExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitCXXTypeidExprENT_INS_13CXXTypeidExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXTypeidExpr(CXXTypeidExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 305,
   FQN="clang::StmtVisitorBase::VisitCXXUnresolvedConstructExpr", NM="_ZN5clang15StmtVisitorBase31VisitCXXUnresolvedConstructExprENT_INS_26CXXUnresolvedConstructExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase31VisitCXXUnresolvedConstructExprENT_INS_26CXXUnresolvedConstructExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXUnresolvedConstructExpr(CXXUnresolvedConstructExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 311,
   FQN="clang::StmtVisitorBase::VisitCXXUuidofExpr", NM="_ZN5clang15StmtVisitorBase18VisitCXXUuidofExprENT_INS_13CXXUuidofExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitCXXUuidofExprENT_INS_13CXXUuidofExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXUuidofExpr(CXXUuidofExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 317,
   FQN="clang::StmtVisitorBase::VisitCallExpr", NM="_ZN5clang15StmtVisitorBase13VisitCallExprENT_INS_8CallExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitCallExprENT_INS_8CallExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCallExpr(CallExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 321,
   FQN="clang::StmtVisitorBase::VisitCUDAKernelCallExpr", NM="_ZN5clang15StmtVisitorBase23VisitCUDAKernelCallExprENT_INS_18CUDAKernelCallExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitCUDAKernelCallExprENT_INS_18CUDAKernelCallExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCUDAKernelCallExpr(CUDAKernelCallExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCallExpr(((/*static_cast*/CallExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 327,
   FQN="clang::StmtVisitorBase::VisitCXXMemberCallExpr", NM="_ZN5clang15StmtVisitorBase22VisitCXXMemberCallExprENT_INS_17CXXMemberCallExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitCXXMemberCallExprENT_INS_17CXXMemberCallExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXMemberCallExpr(CXXMemberCallExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCallExpr(((/*static_cast*/CallExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 333,
   FQN="clang::StmtVisitorBase::VisitCXXOperatorCallExpr", NM="_ZN5clang15StmtVisitorBase24VisitCXXOperatorCallExprENT_INS_19CXXOperatorCallExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitCXXOperatorCallExprENT_INS_19CXXOperatorCallExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXOperatorCallExpr(CXXOperatorCallExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCallExpr(((/*static_cast*/CallExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUserDefinedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 339,
   FQN="clang::StmtVisitorBase::VisitUserDefinedLiteral", NM="_ZN5clang15StmtVisitorBase23VisitUserDefinedLiteralENT_INS_18UserDefinedLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitUserDefinedLiteralENT_INS_18UserDefinedLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUserDefinedLiteral(UserDefinedLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCallExpr(((/*static_cast*/CallExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 349,
   FQN="clang::StmtVisitorBase::VisitCastExpr", NM="_ZN5clang15StmtVisitorBase13VisitCastExprENT_INS_8CastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitCastExprENT_INS_8CastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCastExpr(CastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitExplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 353,
   FQN="clang::StmtVisitorBase::VisitExplicitCastExpr", NM="_ZN5clang15StmtVisitorBase21VisitExplicitCastExprENT_INS_16ExplicitCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitExplicitCastExprENT_INS_16ExplicitCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitExplicitCastExpr(ExplicitCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCastExpr(((/*static_cast*/CastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 357,
   FQN="clang::StmtVisitorBase::VisitCStyleCastExpr", NM="_ZN5clang15StmtVisitorBase19VisitCStyleCastExprENT_INS_14CStyleCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitCStyleCastExprENT_INS_14CStyleCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCStyleCastExpr(CStyleCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExplicitCastExpr(((/*static_cast*/ExplicitCastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 363,
   FQN="clang::StmtVisitorBase::VisitCXXFunctionalCastExpr", NM="_ZN5clang15StmtVisitorBase26VisitCXXFunctionalCastExprENT_INS_21CXXFunctionalCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase26VisitCXXFunctionalCastExprENT_INS_21CXXFunctionalCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXFunctionalCastExpr(CXXFunctionalCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExplicitCastExpr(((/*static_cast*/ExplicitCastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 369,
   FQN="clang::StmtVisitorBase::VisitCXXNamedCastExpr", NM="_ZN5clang15StmtVisitorBase21VisitCXXNamedCastExprENT_INS_16CXXNamedCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitCXXNamedCastExprENT_INS_16CXXNamedCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXNamedCastExpr(CXXNamedCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExplicitCastExpr(((/*static_cast*/ExplicitCastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXConstCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 373,
   FQN="clang::StmtVisitorBase::VisitCXXConstCastExpr", NM="_ZN5clang15StmtVisitorBase21VisitCXXConstCastExprENT_INS_16CXXConstCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitCXXConstCastExprENT_INS_16CXXConstCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXConstCastExpr(CXXConstCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXNamedCastExpr(((/*static_cast*/CXXNamedCastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXDynamicCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 379,
   FQN="clang::StmtVisitorBase::VisitCXXDynamicCastExpr", NM="_ZN5clang15StmtVisitorBase23VisitCXXDynamicCastExprENT_INS_18CXXDynamicCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitCXXDynamicCastExprENT_INS_18CXXDynamicCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXDynamicCastExpr(CXXDynamicCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXNamedCastExpr(((/*static_cast*/CXXNamedCastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXReinterpretCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 385,
   FQN="clang::StmtVisitorBase::VisitCXXReinterpretCastExpr", NM="_ZN5clang15StmtVisitorBase27VisitCXXReinterpretCastExprENT_INS_22CXXReinterpretCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase27VisitCXXReinterpretCastExprENT_INS_22CXXReinterpretCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXReinterpretCastExpr(CXXReinterpretCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXNamedCastExpr(((/*static_cast*/CXXNamedCastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCXXStaticCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 391,
   FQN="clang::StmtVisitorBase::VisitCXXStaticCastExpr", NM="_ZN5clang15StmtVisitorBase22VisitCXXStaticCastExprENT_INS_17CXXStaticCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitCXXStaticCastExprENT_INS_17CXXStaticCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXStaticCastExpr(CXXStaticCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXNamedCastExpr(((/*static_cast*/CXXNamedCastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCBridgedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 401,
   FQN="clang::StmtVisitorBase::VisitObjCBridgedCastExpr", NM="_ZN5clang15StmtVisitorBase24VisitObjCBridgedCastExprENT_INS_19ObjCBridgedCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitObjCBridgedCastExprENT_INS_19ObjCBridgedCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCBridgedCastExpr(ObjCBridgedCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExplicitCastExpr(((/*static_cast*/ExplicitCastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 411,
   FQN="clang::StmtVisitorBase::VisitImplicitCastExpr", NM="_ZN5clang15StmtVisitorBase21VisitImplicitCastExprENT_INS_16ImplicitCastExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitImplicitCastExprENT_INS_16ImplicitCastExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitImplicitCastExpr(ImplicitCastExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCastExpr(((/*static_cast*/CastExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 421,
   FQN="clang::StmtVisitorBase::VisitCharacterLiteral", NM="_ZN5clang15StmtVisitorBase21VisitCharacterLiteralENT_INS_16CharacterLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitCharacterLiteralENT_INS_16CharacterLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCharacterLiteral(CharacterLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 427,
   FQN="clang::StmtVisitorBase::VisitChooseExpr", NM="_ZN5clang15StmtVisitorBase15VisitChooseExprENT_INS_10ChooseExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitChooseExprENT_INS_10ChooseExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitChooseExpr(ChooseExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 433,
   FQN="clang::StmtVisitorBase::VisitCompoundLiteralExpr", NM="_ZN5clang15StmtVisitorBase24VisitCompoundLiteralExprENT_INS_19CompoundLiteralExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitCompoundLiteralExprENT_INS_19CompoundLiteralExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCompoundLiteralExpr(CompoundLiteralExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 439,
   FQN="clang::StmtVisitorBase::VisitConvertVectorExpr", NM="_ZN5clang15StmtVisitorBase22VisitConvertVectorExprENT_INS_17ConvertVectorExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitConvertVectorExprENT_INS_17ConvertVectorExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitConvertVectorExpr(ConvertVectorExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCoroutineSuspendExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 445,
   FQN="clang::StmtVisitorBase::VisitCoroutineSuspendExpr", NM="_ZN5clang15StmtVisitorBase25VisitCoroutineSuspendExprENT_INS_20CoroutineSuspendExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitCoroutineSuspendExprENT_INS_20CoroutineSuspendExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCoroutineSuspendExpr(CoroutineSuspendExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 449,
   FQN="clang::StmtVisitorBase::VisitCoawaitExpr", NM="_ZN5clang15StmtVisitorBase16VisitCoawaitExprENT_INS_11CoawaitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitCoawaitExprENT_INS_11CoawaitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCoawaitExpr(CoawaitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCoroutineSuspendExpr(((/*static_cast*/CoroutineSuspendExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 455,
   FQN="clang::StmtVisitorBase::VisitCoyieldExpr", NM="_ZN5clang15StmtVisitorBase16VisitCoyieldExprENT_INS_11CoyieldExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitCoyieldExprENT_INS_11CoyieldExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCoyieldExpr(CoyieldExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCoroutineSuspendExpr(((/*static_cast*/CoroutineSuspendExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 465,
   FQN="clang::StmtVisitorBase::VisitDeclRefExpr", NM="_ZN5clang15StmtVisitorBase16VisitDeclRefExprENT_INS_11DeclRefExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitDeclRefExprENT_INS_11DeclRefExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDeclRefExpr(DeclRefExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 471,
   FQN="clang::StmtVisitorBase::VisitDependentScopeDeclRefExpr", NM="_ZN5clang15StmtVisitorBase30VisitDependentScopeDeclRefExprENT_INS_25DependentScopeDeclRefExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase30VisitDependentScopeDeclRefExprENT_INS_25DependentScopeDeclRefExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDependentScopeDeclRefExpr(DependentScopeDeclRefExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitDesignatedInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 477,
   FQN="clang::StmtVisitorBase::VisitDesignatedInitExpr", NM="_ZN5clang15StmtVisitorBase23VisitDesignatedInitExprENT_INS_18DesignatedInitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitDesignatedInitExprENT_INS_18DesignatedInitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDesignatedInitExpr(DesignatedInitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitDesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 483,
   FQN="clang::StmtVisitorBase::VisitDesignatedInitUpdateExpr", NM="_ZN5clang15StmtVisitorBase29VisitDesignatedInitUpdateExprENT_INS_24DesignatedInitUpdateExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase29VisitDesignatedInitUpdateExprENT_INS_24DesignatedInitUpdateExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDesignatedInitUpdateExpr(DesignatedInitUpdateExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 489,
   FQN="clang::StmtVisitorBase::VisitExprWithCleanups", NM="_ZN5clang15StmtVisitorBase21VisitExprWithCleanupsENT_INS_16ExprWithCleanupsEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitExprWithCleanupsENT_INS_16ExprWithCleanupsEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitExprWithCleanups(ExprWithCleanups/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 495,
   FQN="clang::StmtVisitorBase::VisitExpressionTraitExpr", NM="_ZN5clang15StmtVisitorBase24VisitExpressionTraitExprENT_INS_19ExpressionTraitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitExpressionTraitExprENT_INS_19ExpressionTraitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitExpressionTraitExpr(ExpressionTraitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 501,
   FQN="clang::StmtVisitorBase::VisitExtVectorElementExpr", NM="_ZN5clang15StmtVisitorBase25VisitExtVectorElementExprENT_INS_20ExtVectorElementExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitExtVectorElementExprENT_INS_20ExtVectorElementExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitExtVectorElementExpr(ExtVectorElementExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 507,
   FQN="clang::StmtVisitorBase::VisitFloatingLiteral", NM="_ZN5clang15StmtVisitorBase20VisitFloatingLiteralENT_INS_15FloatingLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitFloatingLiteralENT_INS_15FloatingLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFloatingLiteral(FloatingLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitFunctionParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 513,
   FQN="clang::StmtVisitorBase::VisitFunctionParmPackExpr", NM="_ZN5clang15StmtVisitorBase25VisitFunctionParmPackExprENT_INS_20FunctionParmPackExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitFunctionParmPackExprENT_INS_20FunctionParmPackExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFunctionParmPackExpr(FunctionParmPackExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 519,
   FQN="clang::StmtVisitorBase::VisitGNUNullExpr", NM="_ZN5clang15StmtVisitorBase16VisitGNUNullExprENT_INS_11GNUNullExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitGNUNullExprENT_INS_11GNUNullExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitGNUNullExpr(GNUNullExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 525,
   FQN="clang::StmtVisitorBase::VisitGenericSelectionExpr", NM="_ZN5clang15StmtVisitorBase25VisitGenericSelectionExprENT_INS_20GenericSelectionExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitGenericSelectionExprENT_INS_20GenericSelectionExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitGenericSelectionExpr(GenericSelectionExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitImaginaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 531,
   FQN="clang::StmtVisitorBase::VisitImaginaryLiteral", NM="_ZN5clang15StmtVisitorBase21VisitImaginaryLiteralENT_INS_16ImaginaryLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitImaginaryLiteralENT_INS_16ImaginaryLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitImaginaryLiteral(ImaginaryLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 537,
   FQN="clang::StmtVisitorBase::VisitImplicitValueInitExpr", NM="_ZN5clang15StmtVisitorBase26VisitImplicitValueInitExprENT_INS_21ImplicitValueInitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase26VisitImplicitValueInitExprENT_INS_21ImplicitValueInitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitImplicitValueInitExpr(ImplicitValueInitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 543,
   FQN="clang::StmtVisitorBase::VisitInitListExpr", NM="_ZN5clang15StmtVisitorBase17VisitInitListExprENT_INS_12InitListExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitInitListExprENT_INS_12InitListExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitInitListExpr(InitListExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 549,
   FQN="clang::StmtVisitorBase::VisitIntegerLiteral", NM="_ZN5clang15StmtVisitorBase19VisitIntegerLiteralENT_INS_14IntegerLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitIntegerLiteralENT_INS_14IntegerLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitIntegerLiteral(IntegerLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 555,
   FQN="clang::StmtVisitorBase::VisitLambdaExpr", NM="_ZN5clang15StmtVisitorBase15VisitLambdaExprENT_INS_10LambdaExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitLambdaExprENT_INS_10LambdaExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitLambdaExpr(LambdaExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitMSPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 561,
   FQN="clang::StmtVisitorBase::VisitMSPropertyRefExpr", NM="_ZN5clang15StmtVisitorBase22VisitMSPropertyRefExprENT_INS_17MSPropertyRefExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitMSPropertyRefExprENT_INS_17MSPropertyRefExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitMSPropertyRefExpr(MSPropertyRefExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitMSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 567,
   FQN="clang::StmtVisitorBase::VisitMSPropertySubscriptExpr", NM="_ZN5clang15StmtVisitorBase28VisitMSPropertySubscriptExprENT_INS_23MSPropertySubscriptExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase28VisitMSPropertySubscriptExprENT_INS_23MSPropertySubscriptExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitMSPropertySubscriptExpr(MSPropertySubscriptExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 573,
   FQN="clang::StmtVisitorBase::VisitMaterializeTemporaryExpr", NM="_ZN5clang15StmtVisitorBase29VisitMaterializeTemporaryExprENT_INS_24MaterializeTemporaryExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase29VisitMaterializeTemporaryExprENT_INS_24MaterializeTemporaryExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitMaterializeTemporaryExpr(MaterializeTemporaryExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 579,
   FQN="clang::StmtVisitorBase::VisitMemberExpr", NM="_ZN5clang15StmtVisitorBase15VisitMemberExprENT_INS_10MemberExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitMemberExprENT_INS_10MemberExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitMemberExpr(MemberExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitNoInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 585,
   FQN="clang::StmtVisitorBase::VisitNoInitExpr", NM="_ZN5clang15StmtVisitorBase15VisitNoInitExprENT_INS_10NoInitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitNoInitExprENT_INS_10NoInitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNoInitExpr(NoInitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPArraySectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 591,
   FQN="clang::StmtVisitorBase::VisitOMPArraySectionExpr", NM="_ZN5clang15StmtVisitorBase24VisitOMPArraySectionExprENT_INS_19OMPArraySectionExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitOMPArraySectionExprENT_INS_19OMPArraySectionExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPArraySectionExpr(OMPArraySectionExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 597,
   FQN="clang::StmtVisitorBase::VisitObjCArrayLiteral", NM="_ZN5clang15StmtVisitorBase21VisitObjCArrayLiteralENT_INS_16ObjCArrayLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitObjCArrayLiteralENT_INS_16ObjCArrayLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCArrayLiteral(ObjCArrayLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCAvailabilityCheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 603,
   FQN="clang::StmtVisitorBase::VisitObjCAvailabilityCheckExpr", NM="_ZN5clang15StmtVisitorBase30VisitObjCAvailabilityCheckExprENT_INS_25ObjCAvailabilityCheckExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase30VisitObjCAvailabilityCheckExprENT_INS_25ObjCAvailabilityCheckExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCAvailabilityCheckExpr(ObjCAvailabilityCheckExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 609,
   FQN="clang::StmtVisitorBase::VisitObjCBoolLiteralExpr", NM="_ZN5clang15StmtVisitorBase24VisitObjCBoolLiteralExprENT_INS_19ObjCBoolLiteralExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitObjCBoolLiteralExprENT_INS_19ObjCBoolLiteralExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCBoolLiteralExpr(ObjCBoolLiteralExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 615,
   FQN="clang::StmtVisitorBase::VisitObjCBoxedExpr", NM="_ZN5clang15StmtVisitorBase18VisitObjCBoxedExprENT_INS_13ObjCBoxedExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitObjCBoxedExprENT_INS_13ObjCBoxedExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCBoxedExpr(ObjCBoxedExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 621,
   FQN="clang::StmtVisitorBase::VisitObjCDictionaryLiteral", NM="_ZN5clang15StmtVisitorBase26VisitObjCDictionaryLiteralENT_INS_21ObjCDictionaryLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase26VisitObjCDictionaryLiteralENT_INS_21ObjCDictionaryLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCDictionaryLiteral(ObjCDictionaryLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 627,
   FQN="clang::StmtVisitorBase::VisitObjCEncodeExpr", NM="_ZN5clang15StmtVisitorBase19VisitObjCEncodeExprENT_INS_14ObjCEncodeExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitObjCEncodeExprENT_INS_14ObjCEncodeExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCEncodeExpr(ObjCEncodeExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCIndirectCopyRestoreExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 633,
   FQN="clang::StmtVisitorBase::VisitObjCIndirectCopyRestoreExpr", NM="_ZN5clang15StmtVisitorBase32VisitObjCIndirectCopyRestoreExprENT_INS_27ObjCIndirectCopyRestoreExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase32VisitObjCIndirectCopyRestoreExprENT_INS_27ObjCIndirectCopyRestoreExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCIndirectCopyRestoreExpr(ObjCIndirectCopyRestoreExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 639,
   FQN="clang::StmtVisitorBase::VisitObjCIsaExpr", NM="_ZN5clang15StmtVisitorBase16VisitObjCIsaExprENT_INS_11ObjCIsaExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitObjCIsaExprENT_INS_11ObjCIsaExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCIsaExpr(ObjCIsaExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 645,
   FQN="clang::StmtVisitorBase::VisitObjCIvarRefExpr", NM="_ZN5clang15StmtVisitorBase20VisitObjCIvarRefExprENT_INS_15ObjCIvarRefExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitObjCIvarRefExprENT_INS_15ObjCIvarRefExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCIvarRefExpr(ObjCIvarRefExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 651,
   FQN="clang::StmtVisitorBase::VisitObjCMessageExpr", NM="_ZN5clang15StmtVisitorBase20VisitObjCMessageExprENT_INS_15ObjCMessageExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitObjCMessageExprENT_INS_15ObjCMessageExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCMessageExpr(ObjCMessageExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 657,
   FQN="clang::StmtVisitorBase::VisitObjCPropertyRefExpr", NM="_ZN5clang15StmtVisitorBase24VisitObjCPropertyRefExprENT_INS_19ObjCPropertyRefExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitObjCPropertyRefExprENT_INS_19ObjCPropertyRefExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCPropertyRefExpr(ObjCPropertyRefExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 663,
   FQN="clang::StmtVisitorBase::VisitObjCProtocolExpr", NM="_ZN5clang15StmtVisitorBase21VisitObjCProtocolExprENT_INS_16ObjCProtocolExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitObjCProtocolExprENT_INS_16ObjCProtocolExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCProtocolExpr(ObjCProtocolExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 669,
   FQN="clang::StmtVisitorBase::VisitObjCSelectorExpr", NM="_ZN5clang15StmtVisitorBase21VisitObjCSelectorExprENT_INS_16ObjCSelectorExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitObjCSelectorExprENT_INS_16ObjCSelectorExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCSelectorExpr(ObjCSelectorExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 675,
   FQN="clang::StmtVisitorBase::VisitObjCStringLiteral", NM="_ZN5clang15StmtVisitorBase22VisitObjCStringLiteralENT_INS_17ObjCStringLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitObjCStringLiteralENT_INS_17ObjCStringLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCStringLiteral(ObjCStringLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 681,
   FQN="clang::StmtVisitorBase::VisitObjCSubscriptRefExpr", NM="_ZN5clang15StmtVisitorBase25VisitObjCSubscriptRefExprENT_INS_20ObjCSubscriptRefExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitObjCSubscriptRefExprENT_INS_20ObjCSubscriptRefExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCSubscriptRefExpr(ObjCSubscriptRefExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 687,
   FQN="clang::StmtVisitorBase::VisitOffsetOfExpr", NM="_ZN5clang15StmtVisitorBase17VisitOffsetOfExprENT_INS_12OffsetOfExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitOffsetOfExprENT_INS_12OffsetOfExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOffsetOfExpr(OffsetOfExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 693,
   FQN="clang::StmtVisitorBase::VisitOpaqueValueExpr", NM="_ZN5clang15StmtVisitorBase20VisitOpaqueValueExprENT_INS_15OpaqueValueExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitOpaqueValueExprENT_INS_15OpaqueValueExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOpaqueValueExpr(OpaqueValueExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOverloadExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 699,
   FQN="clang::StmtVisitorBase::VisitOverloadExpr", NM="_ZN5clang15StmtVisitorBase17VisitOverloadExprENT_INS_12OverloadExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitOverloadExprENT_INS_12OverloadExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOverloadExpr(OverloadExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 703,
   FQN="clang::StmtVisitorBase::VisitUnresolvedLookupExpr", NM="_ZN5clang15StmtVisitorBase25VisitUnresolvedLookupExprENT_INS_20UnresolvedLookupExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitUnresolvedLookupExprENT_INS_20UnresolvedLookupExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnresolvedLookupExpr(UnresolvedLookupExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOverloadExpr(((/*static_cast*/OverloadExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 709,
   FQN="clang::StmtVisitorBase::VisitUnresolvedMemberExpr", NM="_ZN5clang15StmtVisitorBase25VisitUnresolvedMemberExprENT_INS_20UnresolvedMemberExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitUnresolvedMemberExprENT_INS_20UnresolvedMemberExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnresolvedMemberExpr(UnresolvedMemberExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOverloadExpr(((/*static_cast*/OverloadExpr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitPackExpansionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 719,
   FQN="clang::StmtVisitorBase::VisitPackExpansionExpr", NM="_ZN5clang15StmtVisitorBase22VisitPackExpansionExprENT_INS_17PackExpansionExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitPackExpansionExprENT_INS_17PackExpansionExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitPackExpansionExpr(PackExpansionExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 725,
   FQN="clang::StmtVisitorBase::VisitParenExpr", NM="_ZN5clang15StmtVisitorBase14VisitParenExprENT_INS_9ParenExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitParenExprENT_INS_9ParenExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitParenExpr(ParenExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 731,
   FQN="clang::StmtVisitorBase::VisitParenListExpr", NM="_ZN5clang15StmtVisitorBase18VisitParenListExprENT_INS_13ParenListExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitParenListExprENT_INS_13ParenListExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitParenListExpr(ParenListExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 737,
   FQN="clang::StmtVisitorBase::VisitPredefinedExpr", NM="_ZN5clang15StmtVisitorBase19VisitPredefinedExprENT_INS_14PredefinedExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitPredefinedExprENT_INS_14PredefinedExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitPredefinedExpr(PredefinedExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 743,
   FQN="clang::StmtVisitorBase::VisitPseudoObjectExpr", NM="_ZN5clang15StmtVisitorBase21VisitPseudoObjectExprENT_INS_16PseudoObjectExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitPseudoObjectExprENT_INS_16PseudoObjectExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitPseudoObjectExpr(PseudoObjectExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 749,
   FQN="clang::StmtVisitorBase::VisitShuffleVectorExpr", NM="_ZN5clang15StmtVisitorBase22VisitShuffleVectorExprENT_INS_17ShuffleVectorExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitShuffleVectorExprENT_INS_17ShuffleVectorExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitShuffleVectorExpr(ShuffleVectorExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSizeOfPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 755,
   FQN="clang::StmtVisitorBase::VisitSizeOfPackExpr", NM="_ZN5clang15StmtVisitorBase19VisitSizeOfPackExprENT_INS_14SizeOfPackExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitSizeOfPackExprENT_INS_14SizeOfPackExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSizeOfPackExpr(SizeOfPackExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 761,
   FQN="clang::StmtVisitorBase::VisitStmtExpr", NM="_ZN5clang15StmtVisitorBase13VisitStmtExprENT_INS_8StmtExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitStmtExprENT_INS_8StmtExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStmtExpr(StmtExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 767,
   FQN="clang::StmtVisitorBase::VisitStringLiteral", NM="_ZN5clang15StmtVisitorBase18VisitStringLiteralENT_INS_13StringLiteralEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitStringLiteralENT_INS_13StringLiteralEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStringLiteral(StringLiteral/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 773,
   FQN="clang::StmtVisitorBase::VisitSubstNonTypeTemplateParmExpr", NM="_ZN5clang15StmtVisitorBase33VisitSubstNonTypeTemplateParmExprENT_INS_28SubstNonTypeTemplateParmExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase33VisitSubstNonTypeTemplateParmExprENT_INS_28SubstNonTypeTemplateParmExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 779,
   FQN="clang::StmtVisitorBase::VisitSubstNonTypeTemplateParmPackExpr", NM="_ZN5clang15StmtVisitorBase37VisitSubstNonTypeTemplateParmPackExprENT_INS_32SubstNonTypeTemplateParmPackExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase37VisitSubstNonTypeTemplateParmPackExprENT_INS_32SubstNonTypeTemplateParmPackExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSubstNonTypeTemplateParmPackExpr(SubstNonTypeTemplateParmPackExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 785,
   FQN="clang::StmtVisitorBase::VisitTypeTraitExpr", NM="_ZN5clang15StmtVisitorBase18VisitTypeTraitExprENT_INS_13TypeTraitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitTypeTraitExprENT_INS_13TypeTraitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypeTraitExpr(TypeTraitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitTypoExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 791,
   FQN="clang::StmtVisitorBase::VisitTypoExpr", NM="_ZN5clang15StmtVisitorBase13VisitTypoExprENT_INS_8TypoExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitTypoExprENT_INS_8TypoExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypoExpr(TypoExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 797,
   FQN="clang::StmtVisitorBase::VisitUnaryExprOrTypeTraitExpr", NM="_ZN5clang15StmtVisitorBase29VisitUnaryExprOrTypeTraitExprENT_INS_24UnaryExprOrTypeTraitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase29VisitUnaryExprOrTypeTraitExprENT_INS_24UnaryExprOrTypeTraitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 803,
   FQN="clang::StmtVisitorBase::VisitUnaryOperator", NM="_ZN5clang15StmtVisitorBase18VisitUnaryOperatorENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitUnaryOperatorENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryOperator(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 809,
   FQN="clang::StmtVisitorBase::VisitVAArgExpr", NM="_ZN5clang15StmtVisitorBase14VisitVAArgExprENT_INS_9VAArgExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitVAArgExprENT_INS_9VAArgExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitVAArgExpr(VAArgExpr/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(((/*static_cast*/Expr/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 819,
   FQN="clang::StmtVisitorBase::VisitForStmt", NM="_ZN5clang15StmtVisitorBase12VisitForStmtENT_INS_7ForStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase12VisitForStmtENT_INS_7ForStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitForStmt(ForStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 825,
   FQN="clang::StmtVisitorBase::VisitGotoStmt", NM="_ZN5clang15StmtVisitorBase13VisitGotoStmtENT_INS_8GotoStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitGotoStmtENT_INS_8GotoStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitGotoStmt(GotoStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 831,
   FQN="clang::StmtVisitorBase::VisitIfStmt", NM="_ZN5clang15StmtVisitorBase11VisitIfStmtENT_INS_6IfStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitIfStmtENT_INS_6IfStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitIfStmt(IfStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 837,
   FQN="clang::StmtVisitorBase::VisitIndirectGotoStmt", NM="_ZN5clang15StmtVisitorBase21VisitIndirectGotoStmtENT_INS_16IndirectGotoStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitIndirectGotoStmtENT_INS_16IndirectGotoStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitIndirectGotoStmt(IndirectGotoStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 843,
   FQN="clang::StmtVisitorBase::VisitLabelStmt", NM="_ZN5clang15StmtVisitorBase14VisitLabelStmtENT_INS_9LabelStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitLabelStmtENT_INS_9LabelStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitLabelStmt(LabelStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitMSDependentExistsStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 849,
   FQN="clang::StmtVisitorBase::VisitMSDependentExistsStmt", NM="_ZN5clang15StmtVisitorBase26VisitMSDependentExistsStmtENT_INS_21MSDependentExistsStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase26VisitMSDependentExistsStmtENT_INS_21MSDependentExistsStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitMSDependentExistsStmt(MSDependentExistsStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitNullStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 855,
   FQN="clang::StmtVisitorBase::VisitNullStmt", NM="_ZN5clang15StmtVisitorBase13VisitNullStmtENT_INS_8NullStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitNullStmtENT_INS_8NullStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNullStmt(NullStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPExecutableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 861,
   FQN="clang::StmtVisitorBase::VisitOMPExecutableDirective", NM="_ZN5clang15StmtVisitorBase27VisitOMPExecutableDirectiveENT_INS_22OMPExecutableDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase27VisitOMPExecutableDirectiveENT_INS_22OMPExecutableDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPExecutableDirective(OMPExecutableDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPAtomicDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 865,
   FQN="clang::StmtVisitorBase::VisitOMPAtomicDirective", NM="_ZN5clang15StmtVisitorBase23VisitOMPAtomicDirectiveENT_INS_18OMPAtomicDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitOMPAtomicDirectiveENT_INS_18OMPAtomicDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPAtomicDirective(OMPAtomicDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPBarrierDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 871,
   FQN="clang::StmtVisitorBase::VisitOMPBarrierDirective", NM="_ZN5clang15StmtVisitorBase24VisitOMPBarrierDirectiveENT_INS_19OMPBarrierDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitOMPBarrierDirectiveENT_INS_19OMPBarrierDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPBarrierDirective(OMPBarrierDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPCancelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 877,
   FQN="clang::StmtVisitorBase::VisitOMPCancelDirective", NM="_ZN5clang15StmtVisitorBase23VisitOMPCancelDirectiveENT_INS_18OMPCancelDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitOMPCancelDirectiveENT_INS_18OMPCancelDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPCancelDirective(OMPCancelDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPCancellationPointDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 883,
   FQN="clang::StmtVisitorBase::VisitOMPCancellationPointDirective", NM="_ZN5clang15StmtVisitorBase34VisitOMPCancellationPointDirectiveENT_INS_29OMPCancellationPointDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase34VisitOMPCancellationPointDirectiveENT_INS_29OMPCancellationPointDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPCancellationPointDirective(OMPCancellationPointDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPCriticalDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 889,
   FQN="clang::StmtVisitorBase::VisitOMPCriticalDirective", NM="_ZN5clang15StmtVisitorBase25VisitOMPCriticalDirectiveENT_INS_20OMPCriticalDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitOMPCriticalDirectiveENT_INS_20OMPCriticalDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPCriticalDirective(OMPCriticalDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPFlushDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 895,
   FQN="clang::StmtVisitorBase::VisitOMPFlushDirective", NM="_ZN5clang15StmtVisitorBase22VisitOMPFlushDirectiveENT_INS_17OMPFlushDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitOMPFlushDirectiveENT_INS_17OMPFlushDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPFlushDirective(OMPFlushDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 901,
   FQN="clang::StmtVisitorBase::VisitOMPLoopDirective", NM="_ZN5clang15StmtVisitorBase21VisitOMPLoopDirectiveENT_INS_16OMPLoopDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitOMPLoopDirectiveENT_INS_16OMPLoopDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPLoopDirective(OMPLoopDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPDistributeDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 905,
   FQN="clang::StmtVisitorBase::VisitOMPDistributeDirective", NM="_ZN5clang15StmtVisitorBase27VisitOMPDistributeDirectiveENT_INS_22OMPDistributeDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase27VisitOMPDistributeDirectiveENT_INS_22OMPDistributeDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPDistributeDirective(OMPDistributeDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPDistributeParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 911,
   FQN="clang::StmtVisitorBase::VisitOMPDistributeParallelForDirective", NM="_ZN5clang15StmtVisitorBase38VisitOMPDistributeParallelForDirectiveENT_INS_33OMPDistributeParallelForDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase38VisitOMPDistributeParallelForDirectiveENT_INS_33OMPDistributeParallelForDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPDistributeParallelForDirective(OMPDistributeParallelForDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPDistributeParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 917,
   FQN="clang::StmtVisitorBase::VisitOMPDistributeParallelForSimdDirective", NM="_ZN5clang15StmtVisitorBase42VisitOMPDistributeParallelForSimdDirectiveENT_INS_37OMPDistributeParallelForSimdDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase42VisitOMPDistributeParallelForSimdDirectiveENT_INS_37OMPDistributeParallelForSimdDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPDistributeParallelForSimdDirective(OMPDistributeParallelForSimdDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPDistributeSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 923,
   FQN="clang::StmtVisitorBase::VisitOMPDistributeSimdDirective", NM="_ZN5clang15StmtVisitorBase31VisitOMPDistributeSimdDirectiveENT_INS_26OMPDistributeSimdDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase31VisitOMPDistributeSimdDirectiveENT_INS_26OMPDistributeSimdDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPDistributeSimdDirective(OMPDistributeSimdDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 929,
   FQN="clang::StmtVisitorBase::VisitOMPForDirective", NM="_ZN5clang15StmtVisitorBase20VisitOMPForDirectiveENT_INS_15OMPForDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitOMPForDirectiveENT_INS_15OMPForDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPForDirective(OMPForDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 935,
   FQN="clang::StmtVisitorBase::VisitOMPForSimdDirective", NM="_ZN5clang15StmtVisitorBase24VisitOMPForSimdDirectiveENT_INS_19OMPForSimdDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitOMPForSimdDirectiveENT_INS_19OMPForSimdDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPForSimdDirective(OMPForSimdDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 941,
   FQN="clang::StmtVisitorBase::VisitOMPParallelForDirective", NM="_ZN5clang15StmtVisitorBase28VisitOMPParallelForDirectiveENT_INS_23OMPParallelForDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase28VisitOMPParallelForDirectiveENT_INS_23OMPParallelForDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPParallelForDirective(OMPParallelForDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 947,
   FQN="clang::StmtVisitorBase::VisitOMPParallelForSimdDirective", NM="_ZN5clang15StmtVisitorBase32VisitOMPParallelForSimdDirectiveENT_INS_27OMPParallelForSimdDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase32VisitOMPParallelForSimdDirectiveENT_INS_27OMPParallelForSimdDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPParallelForSimdDirective(OMPParallelForSimdDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 953,
   FQN="clang::StmtVisitorBase::VisitOMPSimdDirective", NM="_ZN5clang15StmtVisitorBase21VisitOMPSimdDirectiveENT_INS_16OMPSimdDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitOMPSimdDirectiveENT_INS_16OMPSimdDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPSimdDirective(OMPSimdDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTargetParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 959,
   FQN="clang::StmtVisitorBase::VisitOMPTargetParallelForSimdDirective", NM="_ZN5clang15StmtVisitorBase38VisitOMPTargetParallelForSimdDirectiveENT_INS_33OMPTargetParallelForSimdDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase38VisitOMPTargetParallelForSimdDirectiveENT_INS_33OMPTargetParallelForSimdDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTargetParallelForSimdDirective(OMPTargetParallelForSimdDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTaskLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 965,
   FQN="clang::StmtVisitorBase::VisitOMPTaskLoopDirective", NM="_ZN5clang15StmtVisitorBase25VisitOMPTaskLoopDirectiveENT_INS_20OMPTaskLoopDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitOMPTaskLoopDirectiveENT_INS_20OMPTaskLoopDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTaskLoopDirective(OMPTaskLoopDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTaskLoopSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 971,
   FQN="clang::StmtVisitorBase::VisitOMPTaskLoopSimdDirective", NM="_ZN5clang15StmtVisitorBase29VisitOMPTaskLoopSimdDirectiveENT_INS_24OMPTaskLoopSimdDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase29VisitOMPTaskLoopSimdDirectiveENT_INS_24OMPTaskLoopSimdDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTaskLoopSimdDirective(OMPTaskLoopSimdDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLoopDirective(((/*static_cast*/OMPLoopDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPMasterDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 981,
   FQN="clang::StmtVisitorBase::VisitOMPMasterDirective", NM="_ZN5clang15StmtVisitorBase23VisitOMPMasterDirectiveENT_INS_18OMPMasterDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitOMPMasterDirectiveENT_INS_18OMPMasterDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPMasterDirective(OMPMasterDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPOrderedDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 987,
   FQN="clang::StmtVisitorBase::VisitOMPOrderedDirective", NM="_ZN5clang15StmtVisitorBase24VisitOMPOrderedDirectiveENT_INS_19OMPOrderedDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitOMPOrderedDirectiveENT_INS_19OMPOrderedDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPOrderedDirective(OMPOrderedDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 993,
   FQN="clang::StmtVisitorBase::VisitOMPParallelDirective", NM="_ZN5clang15StmtVisitorBase25VisitOMPParallelDirectiveENT_INS_20OMPParallelDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitOMPParallelDirectiveENT_INS_20OMPParallelDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPParallelDirective(OMPParallelDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPParallelSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 999,
   FQN="clang::StmtVisitorBase::VisitOMPParallelSectionsDirective", NM="_ZN5clang15StmtVisitorBase33VisitOMPParallelSectionsDirectiveENT_INS_28OMPParallelSectionsDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase33VisitOMPParallelSectionsDirectiveENT_INS_28OMPParallelSectionsDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPParallelSectionsDirective(OMPParallelSectionsDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPSectionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1005,
   FQN="clang::StmtVisitorBase::VisitOMPSectionDirective", NM="_ZN5clang15StmtVisitorBase24VisitOMPSectionDirectiveENT_INS_19OMPSectionDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase24VisitOMPSectionDirectiveENT_INS_19OMPSectionDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPSectionDirective(OMPSectionDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1011,
   FQN="clang::StmtVisitorBase::VisitOMPSectionsDirective", NM="_ZN5clang15StmtVisitorBase25VisitOMPSectionsDirectiveENT_INS_20OMPSectionsDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitOMPSectionsDirectiveENT_INS_20OMPSectionsDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPSectionsDirective(OMPSectionsDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPSingleDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1017,
   FQN="clang::StmtVisitorBase::VisitOMPSingleDirective", NM="_ZN5clang15StmtVisitorBase23VisitOMPSingleDirectiveENT_INS_18OMPSingleDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitOMPSingleDirectiveENT_INS_18OMPSingleDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPSingleDirective(OMPSingleDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTargetDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1023,
   FQN="clang::StmtVisitorBase::VisitOMPTargetDataDirective", NM="_ZN5clang15StmtVisitorBase27VisitOMPTargetDataDirectiveENT_INS_22OMPTargetDataDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase27VisitOMPTargetDataDirectiveENT_INS_22OMPTargetDataDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTargetDataDirective(OMPTargetDataDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTargetDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1029,
   FQN="clang::StmtVisitorBase::VisitOMPTargetDirective", NM="_ZN5clang15StmtVisitorBase23VisitOMPTargetDirectiveENT_INS_18OMPTargetDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase23VisitOMPTargetDirectiveENT_INS_18OMPTargetDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTargetDirective(OMPTargetDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTargetEnterDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1035,
   FQN="clang::StmtVisitorBase::VisitOMPTargetEnterDataDirective", NM="_ZN5clang15StmtVisitorBase32VisitOMPTargetEnterDataDirectiveENT_INS_27OMPTargetEnterDataDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase32VisitOMPTargetEnterDataDirectiveENT_INS_27OMPTargetEnterDataDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTargetEnterDataDirective(OMPTargetEnterDataDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTargetExitDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1041,
   FQN="clang::StmtVisitorBase::VisitOMPTargetExitDataDirective", NM="_ZN5clang15StmtVisitorBase31VisitOMPTargetExitDataDirectiveENT_INS_26OMPTargetExitDataDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase31VisitOMPTargetExitDataDirectiveENT_INS_26OMPTargetExitDataDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTargetExitDataDirective(OMPTargetExitDataDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTargetParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1047,
   FQN="clang::StmtVisitorBase::VisitOMPTargetParallelDirective", NM="_ZN5clang15StmtVisitorBase31VisitOMPTargetParallelDirectiveENT_INS_26OMPTargetParallelDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase31VisitOMPTargetParallelDirectiveENT_INS_26OMPTargetParallelDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTargetParallelDirective(OMPTargetParallelDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTargetParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1053,
   FQN="clang::StmtVisitorBase::VisitOMPTargetParallelForDirective", NM="_ZN5clang15StmtVisitorBase34VisitOMPTargetParallelForDirectiveENT_INS_29OMPTargetParallelForDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase34VisitOMPTargetParallelForDirectiveENT_INS_29OMPTargetParallelForDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTargetParallelForDirective(OMPTargetParallelForDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTargetUpdateDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1059,
   FQN="clang::StmtVisitorBase::VisitOMPTargetUpdateDirective", NM="_ZN5clang15StmtVisitorBase29VisitOMPTargetUpdateDirectiveENT_INS_24OMPTargetUpdateDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase29VisitOMPTargetUpdateDirectiveENT_INS_24OMPTargetUpdateDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTargetUpdateDirective(OMPTargetUpdateDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTaskDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1065,
   FQN="clang::StmtVisitorBase::VisitOMPTaskDirective", NM="_ZN5clang15StmtVisitorBase21VisitOMPTaskDirectiveENT_INS_16OMPTaskDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase21VisitOMPTaskDirectiveENT_INS_16OMPTaskDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTaskDirective(OMPTaskDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTaskgroupDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1071,
   FQN="clang::StmtVisitorBase::VisitOMPTaskgroupDirective", NM="_ZN5clang15StmtVisitorBase26VisitOMPTaskgroupDirectiveENT_INS_21OMPTaskgroupDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase26VisitOMPTaskgroupDirectiveENT_INS_21OMPTaskgroupDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTaskgroupDirective(OMPTaskgroupDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTaskwaitDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1077,
   FQN="clang::StmtVisitorBase::VisitOMPTaskwaitDirective", NM="_ZN5clang15StmtVisitorBase25VisitOMPTaskwaitDirectiveENT_INS_20OMPTaskwaitDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase25VisitOMPTaskwaitDirectiveENT_INS_20OMPTaskwaitDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTaskwaitDirective(OMPTaskwaitDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTaskyieldDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1083,
   FQN="clang::StmtVisitorBase::VisitOMPTaskyieldDirective", NM="_ZN5clang15StmtVisitorBase26VisitOMPTaskyieldDirectiveENT_INS_21OMPTaskyieldDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase26VisitOMPTaskyieldDirectiveENT_INS_21OMPTaskyieldDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTaskyieldDirective(OMPTaskyieldDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitOMPTeamsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1089,
   FQN="clang::StmtVisitorBase::VisitOMPTeamsDirective", NM="_ZN5clang15StmtVisitorBase22VisitOMPTeamsDirectiveENT_INS_17OMPTeamsDirectiveEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitOMPTeamsDirectiveENT_INS_17OMPTeamsDirectiveEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPTeamsDirective(OMPTeamsDirective/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPExecutableDirective(((/*static_cast*/OMPExecutableDirective/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1099,
   FQN="clang::StmtVisitorBase::VisitObjCAtCatchStmt", NM="_ZN5clang15StmtVisitorBase20VisitObjCAtCatchStmtENT_INS_15ObjCAtCatchStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitObjCAtCatchStmtENT_INS_15ObjCAtCatchStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCAtCatchStmt(ObjCAtCatchStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1105,
   FQN="clang::StmtVisitorBase::VisitObjCAtFinallyStmt", NM="_ZN5clang15StmtVisitorBase22VisitObjCAtFinallyStmtENT_INS_17ObjCAtFinallyStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase22VisitObjCAtFinallyStmtENT_INS_17ObjCAtFinallyStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCAtFinallyStmt(ObjCAtFinallyStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1111,
   FQN="clang::StmtVisitorBase::VisitObjCAtSynchronizedStmt", NM="_ZN5clang15StmtVisitorBase27VisitObjCAtSynchronizedStmtENT_INS_22ObjCAtSynchronizedStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase27VisitObjCAtSynchronizedStmtENT_INS_22ObjCAtSynchronizedStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCAtSynchronizedStmt(ObjCAtSynchronizedStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1117,
   FQN="clang::StmtVisitorBase::VisitObjCAtThrowStmt", NM="_ZN5clang15StmtVisitorBase20VisitObjCAtThrowStmtENT_INS_15ObjCAtThrowStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase20VisitObjCAtThrowStmtENT_INS_15ObjCAtThrowStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCAtThrowStmt(ObjCAtThrowStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCAtTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1123,
   FQN="clang::StmtVisitorBase::VisitObjCAtTryStmt", NM="_ZN5clang15StmtVisitorBase18VisitObjCAtTryStmtENT_INS_13ObjCAtTryStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitObjCAtTryStmtENT_INS_13ObjCAtTryStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCAtTryStmt(ObjCAtTryStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1129,
   FQN="clang::StmtVisitorBase::VisitObjCAutoreleasePoolStmt", NM="_ZN5clang15StmtVisitorBase28VisitObjCAutoreleasePoolStmtENT_INS_23ObjCAutoreleasePoolStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase28VisitObjCAutoreleasePoolStmtENT_INS_23ObjCAutoreleasePoolStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCAutoreleasePoolStmt(ObjCAutoreleasePoolStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1135,
   FQN="clang::StmtVisitorBase::VisitObjCForCollectionStmt", NM="_ZN5clang15StmtVisitorBase26VisitObjCForCollectionStmtENT_INS_21ObjCForCollectionStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase26VisitObjCForCollectionStmtENT_INS_21ObjCForCollectionStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCForCollectionStmt(ObjCForCollectionStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1141,
   FQN="clang::StmtVisitorBase::VisitReturnStmt", NM="_ZN5clang15StmtVisitorBase15VisitReturnStmtENT_INS_10ReturnStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitReturnStmtENT_INS_10ReturnStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitReturnStmt(ReturnStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSEHExceptStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1147,
   FQN="clang::StmtVisitorBase::VisitSEHExceptStmt", NM="_ZN5clang15StmtVisitorBase18VisitSEHExceptStmtENT_INS_13SEHExceptStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase18VisitSEHExceptStmtENT_INS_13SEHExceptStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSEHExceptStmt(SEHExceptStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSEHFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1153,
   FQN="clang::StmtVisitorBase::VisitSEHFinallyStmt", NM="_ZN5clang15StmtVisitorBase19VisitSEHFinallyStmtENT_INS_14SEHFinallyStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitSEHFinallyStmtENT_INS_14SEHFinallyStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSEHFinallyStmt(SEHFinallyStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSEHLeaveStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1159,
   FQN="clang::StmtVisitorBase::VisitSEHLeaveStmt", NM="_ZN5clang15StmtVisitorBase17VisitSEHLeaveStmtENT_INS_12SEHLeaveStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitSEHLeaveStmtENT_INS_12SEHLeaveStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSEHLeaveStmt(SEHLeaveStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSEHTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1165,
   FQN="clang::StmtVisitorBase::VisitSEHTryStmt", NM="_ZN5clang15StmtVisitorBase15VisitSEHTryStmtENT_INS_10SEHTryStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitSEHTryStmtENT_INS_10SEHTryStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSEHTryStmt(SEHTryStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1171,
   FQN="clang::StmtVisitorBase::VisitSwitchCase", NM="_ZN5clang15StmtVisitorBase15VisitSwitchCaseENT_INS_10SwitchCaseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitSwitchCaseENT_INS_10SwitchCaseEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSwitchCase(SwitchCase/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitCaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1175,
   FQN="clang::StmtVisitorBase::VisitCaseStmt", NM="_ZN5clang15StmtVisitorBase13VisitCaseStmtENT_INS_8CaseStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitCaseStmtENT_INS_8CaseStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCaseStmt(CaseStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSwitchCase(((/*static_cast*/SwitchCase/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitDefaultStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1181,
   FQN="clang::StmtVisitorBase::VisitDefaultStmt", NM="_ZN5clang15StmtVisitorBase16VisitDefaultStmtENT_INS_11DefaultStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitDefaultStmtENT_INS_11DefaultStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDefaultStmt(DefaultStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSwitchCase(((/*static_cast*/SwitchCase/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1191,
   FQN="clang::StmtVisitorBase::VisitSwitchStmt", NM="_ZN5clang15StmtVisitorBase15VisitSwitchStmtENT_INS_10SwitchStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitSwitchStmtENT_INS_10SwitchStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSwitchStmt(SwitchStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 1197,
   FQN="clang::StmtVisitorBase::VisitWhileStmt", NM="_ZN5clang15StmtVisitorBase14VisitWhileStmtENT_INS_9WhileStmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitWhileStmtENT_INS_9WhileStmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitWhileStmt(WhileStmt/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStmt(((/*static_cast*/Stmt/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinPtrMemD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 123,
   FQN="clang::StmtVisitorBase::VisitBinPtrMemD", NM="_ZN5clang15StmtVisitorBase15VisitBinPtrMemDENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitBinPtrMemDENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinPtrMemD(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinPtrMemI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 123,
   FQN="clang::StmtVisitorBase::VisitBinPtrMemI", NM="_ZN5clang15StmtVisitorBase15VisitBinPtrMemIENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitBinPtrMemIENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinPtrMemI(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 124,
   FQN="clang::StmtVisitorBase::VisitBinMul", NM="_ZN5clang15StmtVisitorBase11VisitBinMulENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinMulENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinMul(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 124,
   FQN="clang::StmtVisitorBase::VisitBinDiv", NM="_ZN5clang15StmtVisitorBase11VisitBinDivENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinDivENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinDiv(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 124,
   FQN="clang::StmtVisitorBase::VisitBinRem", NM="_ZN5clang15StmtVisitorBase11VisitBinRemENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinRemENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinRem(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 125,
   FQN="clang::StmtVisitorBase::VisitBinAdd", NM="_ZN5clang15StmtVisitorBase11VisitBinAddENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinAddENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinAdd(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 125,
   FQN="clang::StmtVisitorBase::VisitBinSub", NM="_ZN5clang15StmtVisitorBase11VisitBinSubENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinSubENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinSub(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 125,
   FQN="clang::StmtVisitorBase::VisitBinShl", NM="_ZN5clang15StmtVisitorBase11VisitBinShlENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinShlENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinShl(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 126,
   FQN="clang::StmtVisitorBase::VisitBinShr", NM="_ZN5clang15StmtVisitorBase11VisitBinShrENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinShrENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinShr(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 128,
   FQN="clang::StmtVisitorBase::VisitBinLT", NM="_ZN5clang15StmtVisitorBase10VisitBinLTENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase10VisitBinLTENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinLT(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinGT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 128,
   FQN="clang::StmtVisitorBase::VisitBinGT", NM="_ZN5clang15StmtVisitorBase10VisitBinGTENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase10VisitBinGTENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinGT(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinLE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 128,
   FQN="clang::StmtVisitorBase::VisitBinLE", NM="_ZN5clang15StmtVisitorBase10VisitBinLEENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase10VisitBinLEENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinLE(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinGE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 129,
   FQN="clang::StmtVisitorBase::VisitBinGE", NM="_ZN5clang15StmtVisitorBase10VisitBinGEENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase10VisitBinGEENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinGE(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinEQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 129,
   FQN="clang::StmtVisitorBase::VisitBinEQ", NM="_ZN5clang15StmtVisitorBase10VisitBinEQENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase10VisitBinEQENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinEQ(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinNE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 129,
   FQN="clang::StmtVisitorBase::VisitBinNE", NM="_ZN5clang15StmtVisitorBase10VisitBinNEENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase10VisitBinNEENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinNE(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 130,
   FQN="clang::StmtVisitorBase::VisitBinAnd", NM="_ZN5clang15StmtVisitorBase11VisitBinAndENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinAndENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinAnd(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 130,
   FQN="clang::StmtVisitorBase::VisitBinXor", NM="_ZN5clang15StmtVisitorBase11VisitBinXorENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinXorENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinXor(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 130,
   FQN="clang::StmtVisitorBase::VisitBinOr", NM="_ZN5clang15StmtVisitorBase10VisitBinOrENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase10VisitBinOrENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinOr(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinLAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 131,
   FQN="clang::StmtVisitorBase::VisitBinLAnd", NM="_ZN5clang15StmtVisitorBase12VisitBinLAndENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase12VisitBinLAndENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinLAnd(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinLOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 131,
   FQN="clang::StmtVisitorBase::VisitBinLOr", NM="_ZN5clang15StmtVisitorBase11VisitBinLOrENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase11VisitBinLOrENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinLOr(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 133,
   FQN="clang::StmtVisitorBase::VisitBinAssign", NM="_ZN5clang15StmtVisitorBase14VisitBinAssignENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitBinAssignENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinAssign(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinComma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 134,
   FQN="clang::StmtVisitorBase::VisitBinComma", NM="_ZN5clang15StmtVisitorBase13VisitBinCommaENT_INS_14BinaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitBinCommaENT_INS_14BinaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinComma(BinaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinaryOperator(((/*static_cast*/BinaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinMulAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 143,
   FQN="clang::StmtVisitorBase::VisitBinMulAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinMulAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinMulAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinMulAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinDivAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 143,
   FQN="clang::StmtVisitorBase::VisitBinDivAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinDivAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinDivAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinDivAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinRemAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 143,
   FQN="clang::StmtVisitorBase::VisitBinRemAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinRemAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinRemAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinRemAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinAddAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 144,
   FQN="clang::StmtVisitorBase::VisitBinAddAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinAddAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinAddAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinAddAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinSubAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 144,
   FQN="clang::StmtVisitorBase::VisitBinSubAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinSubAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinSubAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinSubAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinShlAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 144,
   FQN="clang::StmtVisitorBase::VisitBinShlAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinShlAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinShlAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinShlAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinShrAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 145,
   FQN="clang::StmtVisitorBase::VisitBinShrAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinShrAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinShrAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinShrAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinAndAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 145,
   FQN="clang::StmtVisitorBase::VisitBinAndAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinAndAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinAndAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinAndAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinOrAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 145,
   FQN="clang::StmtVisitorBase::VisitBinOrAssign", NM="_ZN5clang15StmtVisitorBase16VisitBinOrAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitBinOrAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinOrAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitBinXorAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 146,
   FQN="clang::StmtVisitorBase::VisitBinXorAssign", NM="_ZN5clang15StmtVisitorBase17VisitBinXorAssignENT_INS_22CompoundAssignOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitBinXorAssignENT_INS_22CompoundAssignOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinXorAssign(CompoundAssignOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundAssignOperator(((/*static_cast*/CompoundAssignOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryPostInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 155,
   FQN="clang::StmtVisitorBase::VisitUnaryPostInc", NM="_ZN5clang15StmtVisitorBase17VisitUnaryPostIncENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitUnaryPostIncENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryPostInc(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryPostDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 155,
   FQN="clang::StmtVisitorBase::VisitUnaryPostDec", NM="_ZN5clang15StmtVisitorBase17VisitUnaryPostDecENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitUnaryPostDecENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryPostDec(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryPreInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 156,
   FQN="clang::StmtVisitorBase::VisitUnaryPreInc", NM="_ZN5clang15StmtVisitorBase16VisitUnaryPreIncENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitUnaryPreIncENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryPreInc(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryPreDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 156,
   FQN="clang::StmtVisitorBase::VisitUnaryPreDec", NM="_ZN5clang15StmtVisitorBase16VisitUnaryPreDecENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitUnaryPreDecENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryPreDec(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryAddrOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 157,
   FQN="clang::StmtVisitorBase::VisitUnaryAddrOf", NM="_ZN5clang15StmtVisitorBase16VisitUnaryAddrOfENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase16VisitUnaryAddrOfENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryAddrOf(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryDeref">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 157,
   FQN="clang::StmtVisitorBase::VisitUnaryDeref", NM="_ZN5clang15StmtVisitorBase15VisitUnaryDerefENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitUnaryDerefENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryDeref(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryPlus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 159,
   FQN="clang::StmtVisitorBase::VisitUnaryPlus", NM="_ZN5clang15StmtVisitorBase14VisitUnaryPlusENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitUnaryPlusENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryPlus(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryMinus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 159,
   FQN="clang::StmtVisitorBase::VisitUnaryMinus", NM="_ZN5clang15StmtVisitorBase15VisitUnaryMinusENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase15VisitUnaryMinusENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryMinus(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 160,
   FQN="clang::StmtVisitorBase::VisitUnaryNot", NM="_ZN5clang15StmtVisitorBase13VisitUnaryNotENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase13VisitUnaryNotENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryNot(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryLNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 160,
   FQN="clang::StmtVisitorBase::VisitUnaryLNot", NM="_ZN5clang15StmtVisitorBase14VisitUnaryLNotENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitUnaryLNotENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryLNot(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 161,
   FQN="clang::StmtVisitorBase::VisitUnaryReal", NM="_ZN5clang15StmtVisitorBase14VisitUnaryRealENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitUnaryRealENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryReal(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 161,
   FQN="clang::StmtVisitorBase::VisitUnaryImag", NM="_ZN5clang15StmtVisitorBase14VisitUnaryImagENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase14VisitUnaryImagENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryImag(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 162,
   FQN="clang::StmtVisitorBase::VisitUnaryExtension", NM="_ZN5clang15StmtVisitorBase19VisitUnaryExtensionENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase19VisitUnaryExtensionENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryExtension(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitUnaryCoawait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 162,
   FQN="clang::StmtVisitorBase::VisitUnaryCoawait", NM="_ZN5clang15StmtVisitorBase17VisitUnaryCoawaitENT_INS_13UnaryOperatorEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase17VisitUnaryCoawaitENT_INS_13UnaryOperatorEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnaryCoawait(UnaryOperator/*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryOperator(((/*static_cast*/UnaryOperator/*P*/)(S)));
  }

  
  // Base case, ignore it. :)
  //<editor-fold defaultstate="collapsed" desc="clang::StmtVisitorBase::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 166,
   FQN="clang::StmtVisitorBase::VisitStmt", NM="_ZN5clang15StmtVisitorBase9VisitStmtENT_INS_4StmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang15StmtVisitorBase9VisitStmtENT_INS_4StmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStmt(Stmt/*P*/ Node) {
    return $StmtVisitorBase$RetTy();
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public default/*interface*/ RetTy $StmtVisitorBase$RetTy() {
    throw new UnsupportedOperationException("Why not overridden new RetTy()?");
  }  
}
