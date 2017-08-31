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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.ast.LValueBase;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.java.OptionalNotes;
import org.clank.java.StdFunctionPointers.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type ExprConstantStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.ast.impl.ExprConstantStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=Tpl__Z13findSubobjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_14CompleteObjectERKNS_19SubobjectDesignatorERT_;Tpl__ZL14HandleOverflowRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKT_NS2_8QualTypeE;Tpl__ZL20CheckedIntArithmeticRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKN4llvm6APSIntES9_jT_RS7_;Tpl__ZL33EvaluateBuiltinConstantPForLValueRKT_;_ZL11HasSameBaseRKN12_GLOBAL__N_16LValueES2_;_ZL11expandArrayRN5clang7APValueEj;_ZL11getExtValueRKN4llvm6APSIntE;_ZL11isZeroSizedRKN12_GLOBAL__N_16LValueE;_ZL12EvaluateArgsN4llvm8ArrayRefIPKN5clang4ExprEEERNS_11SmallVectorINS1_7APValueELj8EEERN12_GLOBAL__N_18EvalInfoE;_ZL12EvaluateCondRN12_GLOBAL__N_18EvalInfoEPKN5clang7VarDeclEPKNS2_4ExprERb;_ZL12EvaluateDeclRN12_GLOBAL__N_18EvalInfoEPKN5clang4DeclE;_ZL12EvaluateStmtRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang4StmtEPKNS4_10SwitchCaseE;_ZL12EvaluateVoidPKN5clang4ExprERN12_GLOBAL__N_18EvalInfoE;_ZL12HandleSizeofRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERNS2_9CharUnitsE;_ZL12IsWeakLValueRKN12_GLOBAL__N_16LValueE;_ZL12describeCallPN12_GLOBAL__N_114CallStackFrameERN4llvm11raw_ostreamE;_ZL12getBaseIndexPKN5clang13CXXRecordDeclES2_;_ZL12handleIncDecRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeEbPNS2_7APValueE;_ZL13EvaluateArrayPKN5clang4ExprERKN12_GLOBAL__N_16LValueERNS_7APValueERNS3_8EvalInfoE;_ZL13EvaluateFloatPKN5clang4ExprERN4llvm7APFloatERN12_GLOBAL__N_18EvalInfoE;_ZL13getObjectTypeN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS1_4ExprEEE;_ZL14CheckEvalInICEPKN5clang4ExprERKNS_10ASTContextE;_ZL14EvaluateAtomicPKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE;_ZL14EvaluateLValuePKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE;_ZL14EvaluateRecordPKN5clang4ExprERKN12_GLOBAL__N_16LValueERNS_7APValueERNS3_8EvalInfoE;_ZL14EvaluateSwitchRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang10SwitchStmtE;_ZL14EvaluateVectorPKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE;_ZL14GetAlignOfExprRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE;_ZL14GetAlignOfTypeRN12_GLOBAL__N_18EvalInfoEN5clang8QualTypeE;_ZL14IsGlobalLValueN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS1_4ExprEEE;_ZL15EvaluateComplexPKN5clang4ExprERN12_GLOBAL__N_112ComplexValueERNS3_8EvalInfoE;_ZL15EvaluateInPlaceRN5clang7APValueERN12_GLOBAL__N_18EvalInfoERKNS2_6LValueEPKNS_4ExprEb;_ZL15EvaluateIntegerPKN5clang4ExprERN4llvm6APSIntERN12_GLOBAL__N_18EvalInfoE;_ZL15EvaluatePointerPKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE;_ZL15IsLiteralLValueRKN12_GLOBAL__N_16LValueE;_ZL15modifySubobjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_14CompleteObjectERKNS_19SubobjectDesignatorERNS2_7APValueE;_ZL16CheckLiteralTypeRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS_6LValueE;_ZL16EvaluateAsRValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueE;_ZL16EvaluateLoopBodyRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang4StmtEPKNS4_10SwitchCaseE;_ZL16HandleLValueBaseRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_13CXXRecordDeclEPKNS2_16CXXBaseSpecifierE;_ZL16extractSubobjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_14CompleteObjectERKNS_19SubobjectDesignatorERNS2_7APValueE;_ZL16handleAssignmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeERNS2_7APValueE;_ZL17EvaluateTemporaryPKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE;_ZL17GetLValueBaseDeclRKN12_GLOBAL__N_16LValueE;_ZL17handleIntIntBinOpRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKN4llvm6APSIntENS2_18BinaryOperatorKindES7_RS7_;_ZL18CastToDerivedClassRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_10RecordDeclEj;_ZL18HandleFunctionCallN5clang14SourceLocationEPKNS_12FunctionDeclEPKN12_GLOBAL__N_16LValueEN4llvm8ArrayRefIPKNS_4ExprEEEPKNS_4StmtERNS4_8EvalInfoERNS_7APValueES7_;_ZL18HandleIntToIntCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeES6_RKN4llvm6APSIntE;_ZL18HandleLValueMemberRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_9FieldDeclEPKNS2_15ASTRecordLayoutE;_ZL18IsConstNonVolatileN5clang8QualTypeE;_ZL18NoteLValueLocationRN12_GLOBAL__N_18EvalInfoEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS4_4ExprEEE;_ZL18findCompleteObjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE11AccessKindsRKNS_6LValueENS2_8QualTypeE;_ZL19IsStringLiteralCallPKN5clang8CallExprE;_ZL19evaluateVarDeclInitRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS2_7VarDeclEPNS_14CallStackFrameERPNS2_7APValueE;_ZL19expandStringLiteralRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueE;_ZL20EvaluateIgnoredValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE;_ZL20FastEvaluateAsRValuePKN5clang4ExprERNS0_10EvalResultERKNS_10ASTContextERb;_ZL20HandleFloatToIntCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKN4llvm7APFloatES6_RNS7_6APSIntE;_ZL20HandleIntToFloatCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKN4llvm6APSIntES6_RNS7_7APFloatE;_ZL20HandleLValueBasePathRN12_GLOBAL__N_18EvalInfoEPKN5clang8CastExprENS2_8QualTypeERNS_6LValueE;_ZL21EvalAndBitcastToAPIntRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERN4llvm5APIntE;_ZL21EvaluateMemberPointerPKN5clang4ExprERN12_GLOBAL__N_19MemberPtrERNS3_8EvalInfoE;_ZL21HandleConstructorCallPKN5clang4ExprERKN12_GLOBAL__N_16LValueEN4llvm8ArrayRefIS2_EEPKNS_18CXXConstructorDeclERNS3_8EvalInfoERNS_7APValueE;_ZL21HandleConstructorCallPKN5clang4ExprERKN12_GLOBAL__N_16LValueEPNS_7APValueEPKNS_18CXXConstructorDeclERNS3_8EvalInfoERS7_;_ZL21TryEvaluateBuiltinNaNRKN5clang10ASTContextENS_8QualTypeEPKNS_4ExprEbRN4llvm7APFloatE;_ZL21handleFloatFloatBinOpRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERN4llvm7APFloatENS2_18BinaryOperatorKindERKS7_;_ZL21truncateBitfieldValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueEPKNS2_9FieldDeclE;_ZL22AreElementsOfSameArrayN5clang8QualTypeERKN12_GLOBAL__N_119SubobjectDesignatorES4_;_ZL22CheckConstexprFunctionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationEPKNS2_12FunctionDeclES6_PKNS2_4StmtE;_ZL22EvalPointerValueAsBoolRKN5clang7APValueERb;_ZL22EvaluateObjectArgumentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueE;_ZL22FindDesignatorMismatchN5clang8QualTypeERKN12_GLOBAL__N_119SubobjectDesignatorES4_Rb;_ZL22HandleConversionToBoolRKN5clang7APValueERb;_ZL22HandleFloatToFloatCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeES6_RN4llvm7APFloatE;_ZL22HandleLValueDirectBaseRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_13CXXRecordDeclESA_PKNS2_15ASTRecordLayoutE;_ZL22refersToCompleteObjectRKN12_GLOBAL__N_16LValueE;_ZL23CheckConstantExpressionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERKNS2_7APValueE;_ZL23EvaluateIntegerOrLValuePKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE;_ZL23HandleBaseToDerivedCastRN12_GLOBAL__N_18EvalInfoEPKN5clang8CastExprERNS_6LValueE;_ZL23isDesignatorAtObjectEndRKN5clang10ASTContextERKN12_GLOBAL__N_16LValueE;_ZL24EvaluateBuiltinConstantPRN5clang10ASTContextEPKNS_4ExprE;_ZL24diagnoseUnreadableFieldsRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeE;_ZL24handleCompoundAssignmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeES9_NS2_18BinaryOperatorKindERKNS2_7APValueE;_ZL24isOverflowingIntegerTypeRN5clang10ASTContextENS_8QualTypeE;_ZL25HandleMemberPointerAccessRN12_GLOBAL__N_18EvalInfoEN5clang8QualTypeERNS_6LValueEPKNS2_4ExprEb;_ZL25HandleMemberPointerAccessRN12_GLOBAL__N_18EvalInfoEPKN5clang14BinaryOperatorERNS_6LValueEb;_ZL25hasUnacceptableSideEffectRN5clang4Expr10EvalStatusENS0_15SideEffectsKindE;_ZL26EvaluateAsBooleanConditionPKN5clang4ExprERbRN12_GLOBAL__N_18EvalInfoE;_ZL26HandleLValueComplexElementRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueENS2_8QualTypeEb;_ZL26HandleLValueIndirectMemberRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_17IndirectFieldDeclE;_ZL27EvaluateBuiltinClassifyTypePKN5clang8CallExprERKNS_11LangOptionsE;_ZL27HandleLValueArrayAdjustmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueENS2_8QualTypeEx;_ZL27ignorePointerCastsAndParensPKN5clang4ExprE;_ZL28tryEvaluateBuiltinObjectSizePKN5clang4ExprEjRN12_GLOBAL__N_18EvalInfoERyPb;_ZL29CheckLValueConstantExpressionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERKNS_6LValueE;_ZL29HandleClassZeroInitializationRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS2_10RecordDeclERKNS_6LValueERNS2_7APValueE;_ZL29extractStringLiteralCharacterRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEy;_ZL30CheckTrivialDefaultConstructorRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationEPKNS2_18CXXConstructorDeclEb;_ZL30handleLValueToRValueConversionRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKNS_6LValueERNS2_7APValueE;_ZL31isOnePastTheEndOfCompleteObjectRKN5clang10ASTContextERKN12_GLOBAL__N_16LValueE;_ZL32isReadByLvalueToRvalueConversionN5clang8QualTypeE;_ZL39EvaluateCPlusPlus11IntegralConstantExprRKN5clang10ASTContextEPKNS_4ExprEPN4llvm6APSIntEPNS_14SourceLocationE;_ZL5WorstN12_GLOBAL__N_17ICEDiagES0_;_ZL6NoDiagv;_ZL8CheckICEPKN5clang4ExprERKNS_10ASTContextE;_ZL8EvaluateRN5clang7APValueERN12_GLOBAL__N_18EvalInfoEPKNS_4ExprE;_ZL9hasFieldsPKN5clang13CXXRecordDeclE;_ZN12_GLOBAL__N_1L10getAsFieldEN5clang7APValue15LValuePathEntryE;_ZN12_GLOBAL__N_1L14getAsBaseClassEN5clang7APValue15LValuePathEntryE;_ZN12_GLOBAL__N_1L17getAsBaseOrMemberEN5clang7APValue15LValuePathEntryE;_ZN12_GLOBAL__N_1L18isVirtualBaseClassEN5clang7APValue15LValuePathEntryE;_ZN12_GLOBAL__N_1L24findMostDerivedSubobjectERN5clang10ASTContextENS0_8QualTypeEN4llvm8ArrayRefINS0_7APValue15LValuePathEntryEEERyRS3_Rb;_ZN12_GLOBAL__N_1L7getTypeEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS2_4ExprEEE;_ZN12_GLOBAL__N_1eqERKNS_9MemberPtrES2_; -static-type=ExprConstantStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ExprConstantStatics {

//<editor-fold defaultstate="collapsed" desc="IsGlobalLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1331,
 FQN="IsGlobalLValue", NM="_ZL14IsGlobalLValueN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS1_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14IsGlobalLValueN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS1_4ExprEEE")
//</editor-fold>
public static boolean IsGlobalLValue(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B) {
  // C++11 [expr.const]p3 An address constant expression is a prvalue core
  // constant expression of pointer type that evaluates to...
  
  // ... a null pointer value, or a prvalue core constant expression of type
  // std::nullptr_t.
  if (!B.$bool()) {
    return true;
  }
  {
    
    /*const*/ ValueDecl /*P*/ D = B.dyn_cast(/*const*/ ValueDecl /*P*/.class);
    if ((D != null)) {
      {
        // ... the address of an object with static storage duration,
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
        if ((VD != null)) {
          return VD.hasGlobalStorage();
        }
      }
      // ... the address of a function,
      return isa_FunctionDecl(D);
    }
  }
  
  /*const*/ Expr /*P*/ E = B.get(/*const*/ Expr /*P*/.class);
  switch (E.getStmtClass()) {
   default:
    return false;
   case CompoundLiteralExprClass:
    {
      /*const*/ CompoundLiteralExpr /*P*/ CLE = cast_CompoundLiteralExpr(E);
      return CLE.isFileScope() && CLE.isLValue();
    }
   case MaterializeTemporaryExprClass:
    // A materialized temporary might have been lifetime-extended to static
    // storage duration.
    return cast_MaterializeTemporaryExpr(E).getStorageDuration() == StorageDuration.SD_Static;
   case StringLiteralClass:
   case PredefinedExprClass:
   case ObjCStringLiteralClass:
   case ObjCEncodeExprClass:
   case CXXTypeidExprClass:
   case CXXUuidofExprClass:
    // A string literal has static storage duration.
    return true;
   case CallExprClass:
    return IsStringLiteralCall(cast_CallExpr(E));
   case AddrLabelExprClass:
    // For GCC compatibility, &&label has static storage duration.
    return true;
   case BlockExprClass:
    // A Block literal expression may be used as the initialization value for
    // Block variables at global or local static scope.
    return !cast_BlockExpr(E).getBlockDecl$Const().hasCaptures();
   case ImplicitValueInitExprClass:
    // FIXME:
    // We can never form an lvalue with an implicit value initialization as its
    // base through expression evaluation, so these only appear in one case: the
    // implicit variable declaration we invent when checking whether a constexpr
    // constructor can produce a constant expression. We must assume that such
    // an expression might be a global lvalue.
    return true;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 62,
 FQN="(anonymous namespace)::getType", NM="_ZN12_GLOBAL__N_1L7getTypeEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS2_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_1L7getTypeEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS2_4ExprEEE")
//</editor-fold>
public static QualType getType(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B) {
  if (!B.$bool()) {
    return new QualType();
  }
  {
    /*const*/ ValueDecl /*P*/ D = B.dyn_cast(/*const*/ ValueDecl /*P*/.class);
    if ((D != null)) {
      return D.getType();
    }
  }
  
  /*const*/ Expr /*P*/ Base = B.get(/*const*/ Expr /*P*/.class);
  {
    
    // For a materialized temporary, the type of the temporary we materialized
    // may not be the type of the expression.
    /*const*/ MaterializeTemporaryExpr /*P*/ MTE = dyn_cast_MaterializeTemporaryExpr(Base);
    if ((MTE != null)) {
      SmallVector</*const*/ Expr /*P*/ > CommaLHSs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(2, (/*const*/ Expr /*P*/ )null);
      SmallVector<SubobjectAdjustment> Adjustments/*J*/= new SmallVector<SubobjectAdjustment>(2, new SubobjectAdjustment());
      /*const*/ Expr /*P*/ Temp = MTE.GetTemporaryExpr();
      /*const*/ Expr /*P*/ Inner = Temp.skipRValueSubobjectAdjustments(CommaLHSs, 
          Adjustments);
      // Keep any cv-qualifiers from the reference if we generated a temporary
      // for it.
      if (Inner != Temp) {
        return Inner.getType();
      }
    }
  }
  
  return Base.getType();
}


/// Get an LValue path entry, which is known to not be an array index, as a
/// field or base class.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getAsBaseOrMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 89,
 FQN="(anonymous namespace)::getAsBaseOrMember", NM="_ZN12_GLOBAL__N_1L17getAsBaseOrMemberEN5clang7APValue15LValuePathEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_1L17getAsBaseOrMemberEN5clang7APValue15LValuePathEntryE")
//</editor-fold>
public static PointerBoolPair</*const*/ Decl/*P*/> getAsBaseOrMember(APValue.LValuePathEntry E) {
  PointerBoolPair</*const*/ Decl/*P*/> Value/*J*/= new PointerBoolPair</*const*/ Decl/*P*/>();
  Value.setFromOpaqueValue(E.BaseOrMember);
  return Value;
}


/// Get an LValue path entry, which is known to not be an array index, as a
/// field declaration.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getAsField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 98,
 FQN="(anonymous namespace)::getAsField", NM="_ZN12_GLOBAL__N_1L10getAsFieldEN5clang7APValue15LValuePathEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_1L10getAsFieldEN5clang7APValue15LValuePathEntryE")
//</editor-fold>
public static /*const*/ FieldDecl /*P*/ getAsField(APValue.LValuePathEntry E) {
  return dyn_cast_FieldDecl(getAsBaseOrMember(new APValue.LValuePathEntry(E)).getPointer());
}

/// Get an LValue path entry, which is known to not be an array index, as a
/// base class declaration.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getAsBaseClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 103,
 FQN="(anonymous namespace)::getAsBaseClass", NM="_ZN12_GLOBAL__N_1L14getAsBaseClassEN5clang7APValue15LValuePathEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_1L14getAsBaseClassEN5clang7APValue15LValuePathEntryE")
//</editor-fold>
public static /*const*/ CXXRecordDecl /*P*/ getAsBaseClass(APValue.LValuePathEntry E) {
  return dyn_cast_CXXRecordDecl(getAsBaseOrMember(new APValue.LValuePathEntry(E)).getPointer());
}

/// Determine whether this LValue path entry for a base class names a virtual
/// base class.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isVirtualBaseClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 108,
 FQN="(anonymous namespace)::isVirtualBaseClass", NM="_ZN12_GLOBAL__N_1L18isVirtualBaseClassEN5clang7APValue15LValuePathEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_1L18isVirtualBaseClassEN5clang7APValue15LValuePathEntryE")
//</editor-fold>
public static boolean isVirtualBaseClass(APValue.LValuePathEntry E) {
  return getAsBaseOrMember(new APValue.LValuePathEntry(E)).getInt();
}


/// Find the path length and type of the most-derived subobject in the given
/// path, and find the size of the containing array, if any.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::findMostDerivedSubobject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 114,
 FQN="(anonymous namespace)::findMostDerivedSubobject", NM="_ZN12_GLOBAL__N_1L24findMostDerivedSubobjectERN5clang10ASTContextENS0_8QualTypeEN4llvm8ArrayRefINS0_7APValue15LValuePathEntryEEERyRS3_Rb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_1L24findMostDerivedSubobjectERN5clang10ASTContextENS0_8QualTypeEN4llvm8ArrayRefINS0_7APValue15LValuePathEntryEEERyRS3_Rb")
//</editor-fold>
public static /*uint*/int findMostDerivedSubobject(final ASTContext /*&*/ Ctx, QualType Base, 
                        ArrayRef<APValue.LValuePathEntry> Path, 
                        final ulong$ref/*uint64_t &*/ ArraySize, final QualType /*&*/ Type, 
                        final bool$ref/*bool &*/ IsArray) {
  /*uint*/int MostDerivedLength = 0;
  Type.$assign(Base);
  for (/*uint*/int I = 0, N = Path.size(); I != N; ++I) {
    if (Type.$arrow().isArrayType()) {
      /*const*/ ConstantArrayType /*P*/ CAT = cast_ConstantArrayType(Ctx.getAsArrayType(new QualType(Type)));
      Type.$assignMove(CAT.getElementType());
      ArraySize.$set(CAT.getSize().getZExtValue());
      MostDerivedLength = I + 1;
      IsArray.$set(true);
    } else if (Type.$arrow().isAnyComplexType()) {
      /*const*/ ComplexType /*P*/ CT = Type.$arrow().castAs(ComplexType.class);
      Type.$assignMove(CT.getElementType());
      ArraySize.$set(2);
      MostDerivedLength = I + 1;
      IsArray.$set(true);
    } else {
      /*const*/ FieldDecl /*P*/ FD = getAsField(new APValue.LValuePathEntry(Path.$at(I)));
      if ((FD != null)) {
        Type.$assignMove(FD.getType());
        ArraySize.$set(0);
        MostDerivedLength = I + 1;
        IsArray.$set(false);
      } else {
        // Path[I] describes a base class.
        ArraySize.$set(0);
        IsArray.$set(false);
      }
    }
  }
  return MostDerivedLength;
}


//===----------------------------------------------------------------------===//
// Misc utilities
//===----------------------------------------------------------------------===//

/// Produce a string describing the given constexpr call.
//<editor-fold defaultstate="collapsed" desc="describeCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1271,
 FQN="describeCall", NM="_ZL12describeCallPN12_GLOBAL__N_114CallStackFrameERN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12describeCallPN12_GLOBAL__N_114CallStackFrameERN4llvm11raw_ostreamE")
//</editor-fold>
public static void describeCall(CallStackFrame /*P*/ Frame, final raw_ostream /*&*/ Out) {
  /*uint*/int ArgIndex = 0;
  boolean IsMemberCall = isa_CXXMethodDecl(Frame.Callee)
     && !isa_CXXConstructorDecl(Frame.Callee)
     && cast_CXXMethodDecl(Frame.Callee).isInstance();
  if (!IsMemberCall) {
    $out_raw_ostream_NamedDecl$C(Out, $Deref(Frame.Callee)).$out_char($$LPAREN);
  }
  if ((Frame.This != null) && IsMemberCall) {
    APValue Val = null;
    try {
      Val/*J*/= new APValue();
      Frame.This.moveInto(Val);
      Val.printPretty(Out, Frame.Info.Ctx, 
          new QualType(Frame.This.Designator.MostDerivedType));
      // FIXME: Add parens around Val if needed.
      $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/$ARROW), $Deref(Frame.Callee)).$out_char($$LPAREN);
      IsMemberCall = false;
    } finally {
      if (Val != null) { Val.$destroy(); }
    }
  }
  
  for (type$ptr<ParmVarDecl /*P*/ /*P*/> I = $tryClone(Frame.Callee.param_begin$Const()), 
      /*P*/ E = $tryClone(Frame.Callee.param_end$Const()); $noteq_ptr(I, E); I.$preInc() , ++ArgIndex) {
    if ($greater_uint_bool(ArgIndex, IsMemberCall)) {
      Out.$out(/*KEEP_STR*/$COMMA_SPACE);
    }
    
    /*const*/ ParmVarDecl /*P*/ Param = I.$star();
    final /*const*/ APValue /*&*/ Arg = Frame.Arguments.$at(ArgIndex);
    Arg.printPretty(Out, Frame.Info.Ctx, Param.getType());
    if (ArgIndex == 0 && IsMemberCall) {
      $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/$ARROW), $Deref(Frame.Callee)).$out_char($$LPAREN);
    }
  }
  
  Out.$out_char($$RPAREN);
}


/// Compare two member pointers, which are assumed to be of the same type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator==">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1240,
 FQN="(anonymous namespace)::operator==", NM="_ZN12_GLOBAL__N_1eqERKNS_9MemberPtrES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_1eqERKNS_9MemberPtrES2_")
//</editor-fold>
public static boolean $eq_MemberPtr$C(final /*const*/ MemberPtr /*&*/ LHS, final /*const*/ MemberPtr /*&*/ RHS) {
  if (!(LHS.getDecl() != null) || !(RHS.getDecl() != null)) {
    return !(LHS.getDecl() != null) && !(RHS.getDecl() != null);
  }
  if (LHS.getDecl().getCanonicalDecl$Const() != RHS.getDecl().getCanonicalDecl$Const()) {
    return false;
  }
  return LHS.Path.$eq(RHS.Path);
}


//===----------------------------------------------------------------------===//
// Top level Expr::EvaluateAsRValue method.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="Evaluate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8983,
 FQN="Evaluate", NM="_ZL8EvaluateRN5clang7APValueERN12_GLOBAL__N_18EvalInfoEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL8EvaluateRN5clang7APValueERN12_GLOBAL__N_18EvalInfoEPKNS_4ExprE")
//</editor-fold>
public static boolean Evaluate(final APValue /*&*/ Result, final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E) {
  // In C, function designators are not lvalues, but we evaluate them as if they
  // are.
  QualType T = E.getType();
  if (E.isGLValue() || T.$arrow().isFunctionType()) {
    LValue LV = null;
    try {
      LV/*J*/= new LValue();
      if (!EvaluateLValue(E, LV, Info)) {
        return false;
      }
      LV.moveInto(Result);
    } finally {
      if (LV != null) { LV.$destroy(); }
    }
  } else if (T.$arrow().isVectorType()) {
    if (!EvaluateVector(E, Result, Info)) {
      return false;
    }
  } else if (T.$arrow().isIntegralOrEnumerationType()) {
    if (!new IntExprEvaluator(Info, Result).Visit(E)) {
      return false;
    }
  } else if (T.$arrow().hasPointerRepresentation()) {
    LValue LV = null;
    try {
      LV/*J*/= new LValue();
      if (!EvaluatePointer(E, LV, Info)) {
        return false;
      }
      LV.moveInto(Result);
    } finally {
      if (LV != null) { LV.$destroy(); }
    }
  } else if (T.$arrow().isRealFloatingType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      APFloat F/*J*/= new APFloat(0.);
      if (!EvaluateFloat(E, F, Info)) {
        return false;
      }
      $c$.clean(Result.$assign($c$.track(new APValue(new APFloat(F)))));
    } finally {
      $c$.$destroy();
    }
  } else if (T.$arrow().isAnyComplexType()) {
    ComplexValue C = null;
    try {
      C/*J*/= new ComplexValue();
      if (!EvaluateComplex(E, C, Info)) {
        return false;
      }
      C.moveInto(Result);
    } finally {
      if (C != null) { C.$destroy(); }
    }
  } else if (T.$arrow().isMemberPointerType()) {
    MemberPtr P = null;
    try {
      P/*J*/= new MemberPtr();
      if (!EvaluateMemberPointer(E, P, Info)) {
        return false;
      }
      P.moveInto(Result);
      return true;
    } finally {
      if (P != null) { P.$destroy(); }
    }
  } else if (T.$arrow().isArrayType()) {
    LValue LV = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      LV/*J*/= new LValue();
      LV.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E), Info.CurrentCall.Index);
      final APValue /*&*/ Value = Info.CurrentCall.createTemporary(E, false);
      if (!EvaluateArray(E, LV, Value, Info)) {
        return false;
      }
      $c$.clean(Result.$assign($c$.track(new APValue(Value))));
    } finally {
      if (LV != null) { LV.$destroy(); }
      $c$.$destroy();
    }
  } else if (T.$arrow().isRecordType()) {
    LValue LV = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      LV/*J*/= new LValue();
      LV.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E), Info.CurrentCall.Index);
      final APValue /*&*/ Value = Info.CurrentCall.createTemporary(E, false);
      if (!EvaluateRecord(E, LV, Value, Info)) {
        return false;
      }
      $c$.clean(Result.$assign($c$.track(new APValue(Value))));
    } finally {
      if (LV != null) { LV.$destroy(); }
      $c$.$destroy();
    }
  } else if (T.$arrow().isVoidType()) {
    if (!Info.getLangOpts().CPlusPlus11) {
      Info.CCEDiag(E, diag.note_constexpr_nonliteral).$out$T(
          E.getType()
      );
    }
    if (!EvaluateVoid(E, Info)) {
      return false;
    }
  } else if (T.$arrow().isAtomicType()) {
    if (!EvaluateAtomic(E, Result, Info)) {
      return false;
    }
  } else if (Info.getLangOpts().CPlusPlus11) {
    Info.FFDiag(E, diag.note_constexpr_nonliteral).$out$T(E.getType());
    return false;
  } else {
    Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
    return false;
  }
  
  return true;
}


/// EvaluateInPlace - Evaluate an expression in-place in an APValue. In some
/// cases, the in-place evaluation is essential, since later initializers for
/// an object can indirectly refer to subobjects which were initialized earlier.
//<editor-fold defaultstate="collapsed" desc="EvaluateInPlace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9056,
 FQN="EvaluateInPlace", NM="_ZL15EvaluateInPlaceRN5clang7APValueERN12_GLOBAL__N_18EvalInfoERKNS2_6LValueEPKNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL15EvaluateInPlaceRN5clang7APValueERN12_GLOBAL__N_18EvalInfoERKNS2_6LValueEPKNS_4ExprEb")
//</editor-fold>
public static boolean EvaluateInPlace(final APValue /*&*/ Result, final EvalInfo /*&*/ Info, final /*const*/ LValue /*&*/ This, 
               /*const*/ Expr /*P*/ E) {
  return EvaluateInPlace(Result, Info, This, 
               E, false);
}
public static boolean EvaluateInPlace(final APValue /*&*/ Result, final EvalInfo /*&*/ Info, final /*const*/ LValue /*&*/ This, 
               /*const*/ Expr /*P*/ E, boolean AllowNonLiteralTypes/*= false*/) {
  assert (!E.isValueDependent());
  if (!AllowNonLiteralTypes && !CheckLiteralType(Info, E, $AddrOf(This))) {
    return false;
  }
  if (E.isRValue()) {
    // Evaluate arrays and record types in-place, so that later initializers can
    // refer to earlier-initialized members of the object.
    if (E.getType().$arrow().isArrayType()) {
      return EvaluateArray(E, This, Result, Info);
    } else if (E.getType().$arrow().isRecordType()) {
      return EvaluateRecord(E, This, Result, Info);
    }
  }
  
  // For any other type, in-place evaluation is unimportant.
  return Evaluate(Result, Info, E);
}

// end anonymous namespace

/// Evaluate an expression as an lvalue. This can be legitimately called on
/// expressions which are not glvalues, in three cases:
///  * function designators in C, and
///  * "extern void" objects
///  * @selector() expressions in Objective-C
//<editor-fold defaultstate="collapsed" desc="EvaluateLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4762,
 FQN="EvaluateLValue", NM="_ZL14EvaluateLValuePKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14EvaluateLValuePKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE")
//</editor-fold>
public static boolean EvaluateLValue(/*const*/ Expr /*P*/ E, final LValue /*&*/ Result, final EvalInfo /*&*/ Info) {
  assert (E.isGLValue() || E.getType().$arrow().isFunctionType() || E.getType().$arrow().isVoidType() || isa_ObjCSelectorExpr(E));
  return new LValueExprEvaluator(Info, Result).Visit(E);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="EvaluatePointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5059,
 FQN="EvaluatePointer", NM="_ZL15EvaluatePointerPKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL15EvaluatePointerPKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE")
//</editor-fold>
public static boolean EvaluatePointer(/*const*/ Expr /*P*/ E, final LValue /*&*/ Result, final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().hasPointerRepresentation());
  return new PointerExprEvaluator(Info, Result).Visit(E);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="EvaluateMemberPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5333,
 FQN="EvaluateMemberPointer", NM="_ZL21EvaluateMemberPointerPKN5clang4ExprERN12_GLOBAL__N_19MemberPtrERNS3_8EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL21EvaluateMemberPointerPKN5clang4ExprERN12_GLOBAL__N_19MemberPtrERNS3_8EvalInfoE")
//</editor-fold>
public static boolean EvaluateMemberPointer(/*const*/ Expr /*P*/ E, final MemberPtr /*&*/ Result, 
                     final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isMemberPointerType());
  return new MemberPointerExprEvaluator(Info, Result).Visit(E);
}

// end anonymous namespace

/// Evaluate an expression of record type as a temporary.
//<editor-fold defaultstate="collapsed" desc="EvaluateTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5805,
 FQN="EvaluateTemporary", NM="_ZL17EvaluateTemporaryPKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL17EvaluateTemporaryPKN5clang4ExprERN12_GLOBAL__N_16LValueERNS3_8EvalInfoE")
//</editor-fold>
public static boolean EvaluateTemporary(/*const*/ Expr /*P*/ E, final LValue /*&*/ Result, final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isRecordType());
  return new TemporaryExprEvaluator(Info, Result).Visit(E);
}

//<editor-fold defaultstate="collapsed" desc="EvaluateInteger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6313,
 FQN="EvaluateInteger", NM="_ZL15EvaluateIntegerPKN5clang4ExprERN4llvm6APSIntERN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL15EvaluateIntegerPKN5clang4ExprERN4llvm6APSIntERN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public static boolean EvaluateInteger(/*const*/ Expr /*P*/ E, final APSInt /*&*/ Result, final EvalInfo /*&*/ Info) {
  APValue Val = null;
  try {
    Val/*J*/= new APValue();
    if (!EvaluateIntegerOrLValue(E, Val, Info)) {
      return false;
    }
    if (!Val.isInt()) {
      // FIXME: It would be better to produce the diagnostic for casting
      //        a pointer to an integer.
      Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
      return false;
    }
    Result.$assign(Val.getInt());
    return true;
  } finally {
    if (Val != null) { Val.$destroy(); }
  }
}

// end anonymous namespace

/// EvaluateIntegerOrLValue - Evaluate an rvalue integral-typed expression, and
/// produce either the integer value or a pointer.
///
/// GCC has a heinous extension which folds casts between pointer types and
/// pointer-sized integral types. We support this by allowing the evaluation of
/// an integer rvalue to produce a pointer (represented as an lvalue) instead.
/// Some simple arithmetic on such values is supported (they are treated much
/// like char*).
//<editor-fold defaultstate="collapsed" desc="EvaluateIntegerOrLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6307,
 FQN="EvaluateIntegerOrLValue", NM="_ZL23EvaluateIntegerOrLValuePKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL23EvaluateIntegerOrLValuePKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public static boolean EvaluateIntegerOrLValue(/*const*/ Expr /*P*/ E, final APValue /*&*/ Result, 
                       final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isIntegralOrEnumerationType());
  return new IntExprEvaluator(Info, Result).Visit(E);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="EvaluateFloat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8214,
 FQN="EvaluateFloat", NM="_ZL13EvaluateFloatPKN5clang4ExprERN4llvm7APFloatERN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL13EvaluateFloatPKN5clang4ExprERN4llvm7APFloatERN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public static boolean EvaluateFloat(/*const*/ Expr /*P*/ E, final APFloat /*&*/ Result, final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isRealFloatingType());
  return new FloatExprEvaluator(Info, Result).Visit(E);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="EvaluateComplex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8439,
 FQN="EvaluateComplex", NM="_ZL15EvaluateComplexPKN5clang4ExprERN12_GLOBAL__N_112ComplexValueERNS3_8EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL15EvaluateComplexPKN5clang4ExprERN12_GLOBAL__N_112ComplexValueERNS3_8EvalInfoE")
//</editor-fold>
public static boolean EvaluateComplex(/*const*/ Expr /*P*/ E, final ComplexValue /*&*/ Result, 
               final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isAnyComplexType());
  return new ComplexExprEvaluator(Info, Result).Visit(E);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="EvaluateAtomic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8933,
 FQN="EvaluateAtomic", NM="_ZL14EvaluateAtomicPKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14EvaluateAtomicPKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public static boolean EvaluateAtomic(/*const*/ Expr /*P*/ E, final APValue /*&*/ Result, final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isAtomicType());
  return new AtomicExprEvaluator(Info, Result).Visit(E);
}


/// EvaluateAsRValue - Try to evaluate this expression, performing an implicit
/// lvalue-to-rvalue cast if it is an lvalue.
//<editor-fold defaultstate="collapsed" desc="EvaluateAsRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9078,
 FQN="EvaluateAsRValue", NM="_ZL16EvaluateAsRValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL16EvaluateAsRValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueE")
//</editor-fold>
public static boolean EvaluateAsRValue(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final APValue /*&*/ Result) {
  if (E.getType().isNull()) {
    return false;
  }
  if (!CheckLiteralType(Info, E)) {
    return false;
  }
  if (!/*::*/Evaluate(Result, Info, E)) {
    return false;
  }
  if (E.isGLValue()) {
    LValue LV = null;
    try {
      LV/*J*/= new LValue();
      LV.setFrom(Info.Ctx, Result);
      if (!handleLValueToRValueConversion(Info, E, E.getType(), LV, Result)) {
        return false;
      }
    } finally {
      if (LV != null) { LV.$destroy(); }
    }
  }
  
  // Check this core constant expression is a constant expression.
  return CheckConstantExpression(Info, E.getExprLoc(), E.getType(), Result);
}


/// Evaluate an expression to see if it had side-effects, and discard its
/// result.
/// \return \c true if the caller should keep evaluating.
//<editor-fold defaultstate="collapsed" desc="EvaluateIgnoredValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1309,
 FQN="EvaluateIgnoredValue", NM="_ZL20EvaluateIgnoredValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL20EvaluateIgnoredValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE")
//</editor-fold>
public static boolean EvaluateIgnoredValue(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E) {
  APValue Scratch = null;
  try {
    Scratch/*J*/= new APValue();
    if (!Evaluate(Scratch, Info, E)) {
      // We don't need the value, but we might have skipped a side effect here.
      return Info.noteSideEffect();
    }
    return true;
  } finally {
    if (Scratch != null) { Scratch.$destroy(); }
  }
}


/// Sign- or zero-extend a value to 64 bits. If it's already 64 bits, just
/// return its existing value.
//<editor-fold defaultstate="collapsed" desc="getExtValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1319,
 FQN="getExtValue", NM="_ZL11getExtValueRKN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL11getExtValueRKN4llvm6APSIntE")
//</editor-fold>
public static long/*int64_t*/ getExtValue(final /*const*/ APSInt /*&*/ Value) {
  return Value.isSigned() ? Value.getSExtValue() : ((/*static_cast*/long/*int64_t*/)(Value.getZExtValue()));
}


/// Should this call expression be treated as a string literal?
//<editor-fold defaultstate="collapsed" desc="IsStringLiteralCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1325,
 FQN="IsStringLiteralCall", NM="_ZL19IsStringLiteralCallPKN5clang8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL19IsStringLiteralCallPKN5clang8CallExprE")
//</editor-fold>
public static boolean IsStringLiteralCall(/*const*/ CallExpr /*P*/ E) {
  /*uint*/int _Builtin = E.getBuiltinCallee();
  return (_Builtin == Builtin.ID.BI__builtin___CFStringMakeConstantString.getValue()
     || _Builtin == Builtin.ID.BI__builtin___NSStringMakeConstantString.getValue());
}

//<editor-fold defaultstate="collapsed" desc="NoteLValueLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1387,
 FQN="NoteLValueLocation", NM="_ZL18NoteLValueLocationRN12_GLOBAL__N_18EvalInfoEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS4_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL18NoteLValueLocationRN12_GLOBAL__N_18EvalInfoEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS4_4ExprEEE")
//</editor-fold>
public static void NoteLValueLocation(final EvalInfo /*&*/ Info, PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > Base) {
  assert (Base.$bool()) : "no location for a null lvalue";
  /*const*/ ValueDecl /*P*/ VD = Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
  if ((VD != null)) {
    Info.Note(VD.getLocation(), diag.note_declared_at);
  } else {
    Info.Note(Base.get(/*const*/ Expr /*P*/.class).getExprLoc(), 
        diag.note_constexpr_temporary_here);
  }
}


/// Check that this reference or pointer core constant expression is a valid
/// value for an address or reference constant expression. Return true if we
/// can fold this expression, whether or not it's a constant expression.
//<editor-fold defaultstate="collapsed" desc="CheckLValueConstantExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1400,
 FQN="CheckLValueConstantExpression", NM="_ZL29CheckLValueConstantExpressionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERKNS_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL29CheckLValueConstantExpressionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERKNS_6LValueE")
//</editor-fold>
public static boolean CheckLValueConstantExpression(final EvalInfo /*&*/ Info, SourceLocation Loc, 
                             QualType Type, final /*const*/ LValue /*&*/ LVal) {
  boolean IsReferenceType = Type.$arrow().isReferenceType();
  
  PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > Base = LVal.getLValueBase();
  final /*const*/ SubobjectDesignator /*&*/ Designator = LVal.getLValueDesignator$Const();
  
  // Check that the object is a global. Note that the fake 'this' object we
  // manufacture when checking potential constant expressions is conservatively
  // assumed to be global here.
  if (!IsGlobalLValue(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(Base))) {
    if (Info.getLangOpts().CPlusPlus11) {
      /*const*/ ValueDecl /*P*/ VD = Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
      Info.FFDiag(new SourceLocation(Loc), diag.note_constexpr_non_global, 1).$out_bool(
          IsReferenceType
      ).$out_bool(!Designator.Entries.empty()).$out_bool(
          !!(VD != null)
      ).$out$T(VD);
      NoteLValueLocation(Info, new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(Base));
    } else {
      Info.FFDiag(new SourceLocation(Loc));
    }
    // Don't allow references to temporaries to escape.
    return false;
  }
  assert ((Info.checkingPotentialConstantExpression() || LVal.getLValueCallIndex() == 0)) : "have call index for global lvalue";
  {
    
    /*const*/ ValueDecl /*P*/ VD = Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
    if ((VD != null)) {
      {
        /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(VD);
        if ((Var != null)) {
          // Check if this is a thread-local variable.
          if ((Var.getTLSKind().getValue() != 0)) {
            return false;
          }
          
          // A dllimport variable never acts like a constant.
          if (Var.hasAttr(DLLImportAttr.class)) {
            return false;
          }
        }
      }
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(VD);
        if ((FD != null)) {
          // __declspec(dllimport) must be handled very carefully:
          // We must never initialize an expression with the thunk in C++.
          // Doing otherwise would allow the same id-expression to yield
          // different addresses for the same function in different translation
          // units.  However, this means that we must dynamically initialize the
          // expression with the contents of the import address table at runtime.
          //
          // The C language has no notion of ODR; furthermore, it has no notion of
          // dynamic initialization.  This means that we are permitted to
          // perform initialization with the address of the thunk.
          if (Info.getLangOpts().CPlusPlus && FD.hasAttr(DLLImportAttr.class)) {
            return false;
          }
        }
      }
    }
  }
  
  // Allow address constant expressions to be past-the-end pointers. This is
  // an extension: the standard requires them to point to an object.
  if (!IsReferenceType) {
    return true;
  }
  
  // A reference constant expression must refer to an object.
  if (!Base.$bool()) {
    // FIXME: diagnostic
    Info.CCEDiag(new SourceLocation(Loc));
    return true;
  }
  
  // Does this refer one past the end of some object?
  if (!Designator.Invalid && Designator.isOnePastTheEnd()) {
    /*const*/ ValueDecl /*P*/ VD = Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
    Info.FFDiag(new SourceLocation(Loc), diag.note_constexpr_past_end, 1).$out_bool(
        !Designator.Entries.empty()
    ).$out_bool(!!(VD != null)).$out$T(VD);
    NoteLValueLocation(Info, new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(Base));
  }
  
  return true;
}


/// Check that this core constant expression is of literal type, and if not,
/// produce an appropriate diagnostic.
//<editor-fold defaultstate="collapsed" desc="CheckLiteralType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1478,
 FQN="CheckLiteralType", NM="_ZL16CheckLiteralTypeRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL16CheckLiteralTypeRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS_6LValueE")
//</editor-fold>
public static boolean CheckLiteralType(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E) {
  return CheckLiteralType(Info, E, 
                (/*const*/ LValue /*P*/ )null);
}
public static boolean CheckLiteralType(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                /*const*/ LValue /*P*/ This/*= null*/) {
  if (!E.isRValue() || E.getType().$arrow().isLiteralType(Info.Ctx)) {
    return true;
  }
  
  // C++1y: A constant initializer for an object o [...] may also invoke
  // constexpr constructors for o and its subobjects even if those objects
  // are of non-literal class types.
  if (Info.getLangOpts().CPlusPlus14 && (This != null)
     && $eq_PointerUnion$PT1$PT2(/*NO_COPY*/Info.EvaluatingDecl, This.getLValueBase())) {
    return true;
  }
  
  // Prvalue constant expressions must be of literal types.
  if (Info.getLangOpts().CPlusPlus11) {
    Info.FFDiag(E, diag.note_constexpr_nonliteral).$out$T(
        E.getType()
    );
  } else {
    Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
  }
  return false;
}


/// Check that this core constant expression value is a valid value for a
/// constant expression. If not, report an appropriate diagnostic. Does not
/// check that the expression is of literal type.
//<editor-fold defaultstate="collapsed" desc="CheckConstantExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1502,
 FQN="CheckConstantExpression", NM="_ZL23CheckConstantExpressionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERKNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL23CheckConstantExpressionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERKNS2_7APValueE")
//</editor-fold>
public static boolean CheckConstantExpression(final EvalInfo /*&*/ Info, SourceLocation DiagLoc, 
                       QualType Type, final /*const*/ APValue /*&*/ Value) {
  if (Value.isUninit()) {
    Info.FFDiag(new SourceLocation(DiagLoc), diag.note_constexpr_uninitialized).$out$T(
        true
    ).$out$T(Type);
    return false;
  }
  {
    
    // We allow _Atomic(T) to be initialized from anything that T can be
    // initialized from.
    /*const*/ AtomicType /*P*/ AT = Type.$arrow().getAs(AtomicType.class);
    if ((AT != null)) {
      Type.$assignMove(AT.getValueType());
    }
  }
  
  // Core issue 1454: For a literal constant expression of array or class type,
  // each subobject of its value shall have been initialized by a constant
  // expression.
  if (Value.isArray()) {
    QualType EltTy = Type.$arrow().castAsArrayTypeUnsafe().getElementType();
    for (/*uint*/int I = 0, N = Value.getArrayInitializedElts(); I != N; ++I) {
      if (!CheckConstantExpression(Info, new SourceLocation(DiagLoc), new QualType(EltTy), 
          Value.getArrayInitializedElt$Const(I))) {
        return false;
      }
    }
    if (!Value.hasArrayFiller()) {
      return true;
    }
    return CheckConstantExpression(Info, new SourceLocation(DiagLoc), new QualType(EltTy), 
        Value.getArrayFiller$Const());
  }
  if (Value.isUnion() && (Value.getUnionField() != null)) {
    return CheckConstantExpression(Info, new SourceLocation(DiagLoc), 
        Value.getUnionField().getType(), 
        Value.getUnionValue$Const());
  }
  if (Value.isStruct()) {
    RecordDecl /*P*/ RD = Type.$arrow().<RecordType>castAs$RecordType().getDecl();
    {
      /*const*/ CXXRecordDecl /*P*/ CD = dyn_cast_CXXRecordDecl(RD);
      if ((CD != null)) {
        /*uint*/int BaseIndex = 0;
        for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > I = $tryClone(CD.bases_begin$Const()), 
            /*P*/ End = $tryClone(CD.bases_end$Const()); $noteq_ptr(I, End); I.$preInc() , ++BaseIndex) {
          if (!CheckConstantExpression(Info, new SourceLocation(DiagLoc), I./*->*/$star().getType(), 
              Value.getStructBase$Const(BaseIndex))) {
            return false;
          }
        }
      }
    }
    for (/*const*/ FieldDecl /*P*/ I : RD.fields()) {
      if (!CheckConstantExpression(Info, new SourceLocation(DiagLoc), I.getType(), 
          Value.getStructField$Const(I.getFieldIndex()))) {
        return false;
      }
    }
  }
  if (Value.isLValue()) {
    LValue LVal = null;
    try {
      LVal/*J*/= new LValue();
      LVal.setFrom(Info.Ctx, Value);
      return CheckLValueConstantExpression(Info, new SourceLocation(DiagLoc), new QualType(Type), LVal);
    } finally {
      if (LVal != null) { LVal.$destroy(); }
    }
  }
  
  // Everything else is fine.
  return true;
}

//<editor-fold defaultstate="collapsed" desc="GetLValueBaseDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1563,
 FQN="GetLValueBaseDecl", NM="_ZL17GetLValueBaseDeclRKN12_GLOBAL__N_16LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL17GetLValueBaseDeclRKN12_GLOBAL__N_16LValueE")
//</editor-fold>
public static /*const*/ ValueDecl /*P*/ GetLValueBaseDecl(final /*const*/ LValue /*&*/ LVal) {
  return LVal.Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
}

//<editor-fold defaultstate="collapsed" desc="IsLiteralLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1567,
 FQN="IsLiteralLValue", NM="_ZL15IsLiteralLValueRKN12_GLOBAL__N_16LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL15IsLiteralLValueRKN12_GLOBAL__N_16LValueE")
//</editor-fold>
public static boolean IsLiteralLValue(final /*const*/ LValue /*&*/ Value) {
  if ((Value.CallIndex != 0)) {
    return false;
  }
  /*const*/ Expr /*P*/ E = Value.Base.dyn_cast(/*const*/ Expr /*P*/.class);
  return (E != null) && !isa_MaterializeTemporaryExpr(E);
}

//<editor-fold defaultstate="collapsed" desc="IsWeakLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1574,
 FQN="IsWeakLValue", NM="_ZL12IsWeakLValueRKN12_GLOBAL__N_16LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12IsWeakLValueRKN12_GLOBAL__N_16LValueE")
//</editor-fold>
public static boolean IsWeakLValue(final /*const*/ LValue /*&*/ Value) {
  /*const*/ ValueDecl /*P*/ Decl = GetLValueBaseDecl(Value);
  return (Decl != null) && Decl.isWeak();
}

//<editor-fold defaultstate="collapsed" desc="isZeroSized">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1579,
 FQN="isZeroSized", NM="_ZL11isZeroSizedRKN12_GLOBAL__N_16LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL11isZeroSizedRKN12_GLOBAL__N_16LValueE")
//</editor-fold>
public static boolean isZeroSized(final /*const*/ LValue /*&*/ Value) {
  /*const*/ ValueDecl /*P*/ Decl = GetLValueBaseDecl(Value);
  if ((Decl != null) && isa_VarDecl(Decl)) {
    QualType Ty = Decl.getType();
    if (Ty.$arrow().isArrayType()) {
      return Ty.$arrow().isIncompleteType()
         || Decl.getASTContext().getTypeSize(new QualType(Ty)) == 0;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="EvalPointerValueAsBool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1590,
 FQN="EvalPointerValueAsBool", NM="_ZL22EvalPointerValueAsBoolRKN5clang7APValueERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22EvalPointerValueAsBoolRKN5clang7APValueERb")
//</editor-fold>
public static boolean EvalPointerValueAsBool(final /*const*/ APValue /*&*/ Value, final bool$ref/*bool &*/ Result) {
  // A null base expression indicates a null pointer.  These are always
  // evaluatable, and they are false unless the offset is zero.
  if (!Value.getLValueBase().$bool()) {
    Result.$set(!Value.getLValueOffset$Const().isZero());
    return true;
  }
  
  // We have a non-null base.  These are generally known to be true, but if it's
  // a weak declaration it can be null at runtime.
  Result.$set(true);
  /*const*/ ValueDecl /*P*/ Decl = Value.getLValueBase().dyn_cast(/*const*/ ValueDecl /*P*/.class);
  return !(Decl != null) || !Decl.isWeak();
}

//<editor-fold defaultstate="collapsed" desc="HandleConversionToBool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1605,
 FQN="HandleConversionToBool", NM="_ZL22HandleConversionToBoolRKN5clang7APValueERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22HandleConversionToBoolRKN5clang7APValueERb")
//</editor-fold>
public static boolean HandleConversionToBool(final /*const*/ APValue /*&*/ Val, final bool$ref/*bool &*/ Result) {
  switch (Val.getKind()) {
   case Uninitialized:
    return false;
   case Int:
    Result.$set(Val.getInt$Const().getBoolValue());
    return true;
   case Float:
    Result.$set(!Val.getFloat$Const().isZero());
    return true;
   case ComplexInt:
    Result.$set(Val.getComplexIntReal$Const().getBoolValue()
       || Val.getComplexIntImag$Const().getBoolValue());
    return true;
   case ComplexFloat:
    Result.$set(!Val.getComplexFloatReal$Const().isZero()
       || !Val.getComplexFloatImag$Const().isZero());
    return true;
   case LValue:
    return EvalPointerValueAsBool(Val, Result);
   case MemberPointer:
    Result.$set((Val.getMemberPointerDecl() != null));
    return true;
   case Vector:
   case Array:
   case Struct:
   case Union:
   case AddrLabelDiff:
    return false;
  }
  throw new llvm_unreachable("unknown APValue kind");
}

//<editor-fold defaultstate="collapsed" desc="EvaluateAsBooleanCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1639,
 FQN="EvaluateAsBooleanCondition", NM="_ZL26EvaluateAsBooleanConditionPKN5clang4ExprERbRN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL26EvaluateAsBooleanConditionPKN5clang4ExprERbRN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public static boolean EvaluateAsBooleanCondition(/*const*/ Expr /*P*/ E, final bool$ref/*bool &*/ Result, 
                          final EvalInfo /*&*/ Info) {
  APValue Val = null;
  try {
    assert (E.isRValue()) : "missing lvalue-to-rvalue conv in bool condition";
    Val/*J*/= new APValue();
    if (!Evaluate(Val, Info, E)) {
      return false;
    }
    return HandleConversionToBool(Val, Result);
  } finally {
    if (Val != null) { Val.$destroy(); }
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="HandleOverflow">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1649,
 FQN="HandleOverflow", NM="Tpl__ZL14HandleOverflowRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKT_NS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=Tpl__ZL14HandleOverflowRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKT_NS2_8QualTypeE")
//</editor-fold>
public static </*typename*/ T> boolean HandleOverflow(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
              final /*const*/ T /*&*/ SrcValue, QualType DestType) {
  //APFloat
  //APSInt
  if (SrcValue instanceof APFloat) {
    Info.CCEDiag(E, diag.note_constexpr_overflow).$out(
        (APFloat)SrcValue
    ).$out$T(DestType);
  } else if (SrcValue instanceof APSInt) {
     Info.CCEDiag(E, diag.note_constexpr_overflow).$out(
       (APSInt)SrcValue
    ).$out$T(DestType);
  } else {
    assert false : SrcValue.getClass().getName();
  }
  return Info.noteUndefinedBehavior();
}

//<editor-fold defaultstate="collapsed" desc="HandleFloatToIntCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1656,
 FQN="HandleFloatToIntCast", NM="_ZL20HandleFloatToIntCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKN4llvm7APFloatES6_RNS7_6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL20HandleFloatToIntCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKN4llvm7APFloatES6_RNS7_6APSIntE")
//</editor-fold>
public static boolean HandleFloatToIntCast(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                    QualType SrcType, final /*const*/ APFloat /*&*/ Value, 
                    QualType DestType, final APSInt /*&*/ Result) {
  /*uint*/int DestWidth = Info.Ctx.getIntWidth(new QualType(DestType));
  // Determine whether we are converting to unsigned or signed.
  boolean DestSigned = DestType.$arrow().isSignedIntegerOrEnumerationType();
  
  Result.$assignMove(new APSInt(DestWidth, !DestSigned));
  bool$ptr ignored = create_bool$ptr();
  if (((Value.convertToInteger(Result, APFloat.roundingMode.rmTowardZero, $AddrOf(ignored))
     & APFloat.opStatus.opInvalidOp) != 0)) {
    return HandleOverflow(Info, E, Value, new QualType(DestType));
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="HandleFloatToFloatCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1671,
 FQN="HandleFloatToFloatCast", NM="_ZL22HandleFloatToFloatCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeES6_RN4llvm7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22HandleFloatToFloatCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeES6_RN4llvm7APFloatE")
//</editor-fold>
public static boolean HandleFloatToFloatCast(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                      QualType SrcType, QualType DestType, 
                      final APFloat /*&*/ Result) {
  APFloat Value = new APFloat(Result);
  bool$ptr ignored = create_bool$ptr();
  if (((Result.convert(Info.Ctx.getFloatTypeSemantics(new QualType(DestType)), 
      APFloat.roundingMode.rmNearestTiesToEven, $AddrOf(ignored))
     & APFloat.opStatus.opOverflow) != 0)) {
    return HandleOverflow(Info, E, Value, new QualType(DestType));
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="HandleIntToIntCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1683,
 FQN="HandleIntToIntCast", NM="_ZL18HandleIntToIntCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeES6_RKN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL18HandleIntToIntCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeES6_RKN4llvm6APSIntE")
//</editor-fold>
public static APSInt HandleIntToIntCast(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                  QualType DestType, QualType SrcType, 
                  final /*const*/ APSInt /*&*/ Value) {
  /*uint*/int DestWidth = Info.Ctx.getIntWidth(new QualType(DestType));
  APSInt Result = new APSInt(Value);
  // Figure out if this is a truncate, extend or noop cast.
  // If the input is signed, do a sign extend, noop, or truncate.
  Result.$assignMove(Result.extOrTrunc(DestWidth));
  Result.setIsUnsigned(DestType.$arrow().isUnsignedIntegerOrEnumerationType());
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="HandleIntToFloatCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1695,
 FQN="HandleIntToFloatCast", NM="_ZL20HandleIntToFloatCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKN4llvm6APSIntES6_RNS7_7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL20HandleIntToFloatCastRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKN4llvm6APSIntES6_RNS7_7APFloatE")
//</editor-fold>
public static boolean HandleIntToFloatCast(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                    QualType SrcType, final /*const*/ APSInt /*&*/ Value, 
                    QualType DestType, final APFloat /*&*/ Result) {
  Result.$assignMove(new APFloat(Info.Ctx.getFloatTypeSemantics(new QualType(DestType)), 1));
  if (((Result.convertFromAPInt(Value, Value.isSigned(), 
      APFloat.roundingMode.rmNearestTiesToEven)
     & APFloat.opStatus.opOverflow) != 0)) {
    return HandleOverflow(Info, E, Value, new QualType(DestType));
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="truncateBitfieldValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1706,
 FQN="truncateBitfieldValue", NM="_ZL21truncateBitfieldValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueEPKNS2_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL21truncateBitfieldValueRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueEPKNS2_9FieldDeclE")
//</editor-fold>
public static boolean truncateBitfieldValue(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                     final APValue /*&*/ Value, /*const*/ FieldDecl /*P*/ FD) {
  assert (FD.isBitField()) : "truncateBitfieldValue on non-bitfield";
  if (!Value.isInt()) {
    // Trying to store a pointer-cast-to-integer into a bitfield.
    // FIXME: In this case, we should provide the diagnostic for casting
    // a pointer to an integer.
    assert (Value.isLValue()) : "integral value neither int nor lvalue?";
    Info.FFDiag(E);
    return false;
  }
  
  final APSInt /*&*/ Int = Value.getInt();
  /*uint*/int OldBitWidth = Int.getBitWidth();
  /*uint*/int NewBitWidth = FD.getBitWidthValue(Info.Ctx);
  if ($less_uint(NewBitWidth, OldBitWidth)) {
    Int.$assignMove(Int.trunc(NewBitWidth).extend(OldBitWidth));
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="EvalAndBitcastToAPInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1727,
 FQN="EvalAndBitcastToAPInt", NM="_ZL21EvalAndBitcastToAPIntRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERN4llvm5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL21EvalAndBitcastToAPIntRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERN4llvm5APIntE")
//</editor-fold>
public static boolean EvalAndBitcastToAPInt(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                     final APInt /*&*/ Res) {
  APValue SVal = null;
  try {
    SVal/*J*/= new APValue();
    if (!Evaluate(SVal, Info, E)) {
      return false;
    }
    if (SVal.isInt()) {
      Res.$assign(SVal.getInt());
      return true;
    }
    if (SVal.isFloat()) {
      Res.$assignMove(SVal.getFloat().bitcastToAPInt());
      return true;
    }
    if (SVal.isVector()) {
      QualType VecTy = E.getType();
      /*uint*/int VecSize = $ulong2uint(Info.Ctx.getTypeSize(new QualType(VecTy)));
      QualType EltTy = VecTy.$arrow().castAs(VectorType.class).getElementType();
      /*uint*/int EltSize = $ulong2uint(Info.Ctx.getTypeSize(new QualType(EltTy)));
      boolean BigEndian = Info.Ctx.getTargetInfo().isBigEndian();
      Res.$assignMove(APInt.getNullValue(VecSize));
      for (/*uint*/int i = 0; $less_uint(i, SVal.getVectorLength()); i++) {
        final APValue /*&*/ Elt = SVal.getVectorElt(i);
        APInt EltAsInt/*J*/= new APInt();
        if (Elt.isInt()) {
          EltAsInt.$assign(Elt.getInt());
        } else if (Elt.isFloat()) {
          EltAsInt.$assignMove(Elt.getFloat().bitcastToAPInt());
        } else {
          // Don't try to handle vectors of anything other than int or float
          // (not sure if it's possible to hit this case).
          Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
          return false;
        }
        /*uint*/int BaseEltSize = EltAsInt.getBitWidth();
        if (BigEndian) {
          Res.$orassign(EltAsInt.zextOrTrunc(VecSize).rotr(i * EltSize + BaseEltSize));
        } else {
          Res.$orassign(EltAsInt.zextOrTrunc(VecSize).rotl(i * EltSize));
        }
      }
      return true;
    }
    // Give up if the input isn't an int, float, or vector.  For example, we
    // reject "(v4i16)(intptr_t)&a".
    Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
    return false;
  } finally {
    if (SVal != null) { SVal.$destroy(); }
  }
}


/// Perform the given integer operation, which is known to need at most BitWidth
/// bits, and check for overflow in the original type (if that type was not an
/// unsigned type).
/*template <typename Operation> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="CheckedIntArithmetic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1778,
 FQN="CheckedIntArithmetic", NM="Tpl__ZL20CheckedIntArithmeticRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKN4llvm6APSIntES9_jT_RS7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=Tpl__ZL20CheckedIntArithmeticRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKN4llvm6APSIntES9_jT_RS7_")
//</editor-fold>
public static </*typename*/ Operation extends BinaryOperation<APSInt>> boolean CheckedIntArithmetic(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                    final /*const*/ APSInt /*&*/ LHS, final /*const*/ APSInt /*&*/ RHS, 
                    /*uint*/int BitWidth, Operation Op, 
                    final APSInt /*&*/ Result) {
  if (LHS.isUnsigned()) {
    Result.$assign(Op.$call(LHS, RHS));
    return true;
  }
  
  APSInt Value/*J*/= new APSInt(Op.$call(LHS.extend(BitWidth), RHS.extend(BitWidth)), false);
  Result.$assignMove(Value.trunc(LHS.getBitWidth()));
  if (Result.extend(BitWidth).$noteq(Value)) {
    if (Info.checkingForOverflow()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_StringRef($c$.track(Info.Ctx.getDiagnostics().Report(E.getExprLoc(), 
                    diag.warn_integer_constant_overflow)), 
                new StringRef(Result.__toString(10))), E.getType()));
      } finally {
        $c$.$destroy();
      }
    } else {
      return HandleOverflow(Info, E, Value, E.getType());
    }
  }
  return true;
}


/// Perform the given binary integer operation.
//<editor-fold defaultstate="collapsed" desc="handleIntIntBinOp">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1801,
 FQN="handleIntIntBinOp", NM="_ZL17handleIntIntBinOpRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKN4llvm6APSIntENS2_18BinaryOperatorKindES7_RS7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL17handleIntIntBinOpRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKN4llvm6APSIntENS2_18BinaryOperatorKindES7_RS7_")
//</editor-fold>
public static boolean handleIntIntBinOp(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final /*const*/ APSInt /*&*/ LHS, 
                 BinaryOperatorKind Opcode, APSInt RHS, 
                 final APSInt /*&*/ Result) {
  switch (Opcode) {
   default:
    Info.FFDiag(E);
    return false;
   case BO_Mul:
    return CheckedIntArithmetic(Info, E, LHS, RHS, LHS.getBitWidth() * 2, 
        new std.multiplies<APSInt>(APSInt::$star), Result);
   case BO_Add:
    return CheckedIntArithmetic(Info, E, LHS, RHS, LHS.getBitWidth() + 1, 
        new std.plus<APSInt>(APSInt::$add), Result);
   case BO_Sub:
    return CheckedIntArithmetic(Info, E, LHS, RHS, LHS.getBitWidth() + 1, 
        new std.minus<APSInt>(APSInt::$sub), Result);
   case BO_And:
    Result.$assignMove(LHS.$bitand(RHS));
    return true;
   case BO_Xor:
    Result.$assignMove(LHS.$bitxor(RHS));
    return true;
   case BO_Or:
    Result.$assignMove(LHS.$bitor(RHS));
    return true;
   case BO_Div:
   case BO_Rem:
    if (RHS.$eq(0)) {
      Info.FFDiag(E, diag.note_expr_divide_by_zero);
      return false;
    }
    Result.$assignMove((Opcode == BinaryOperatorKind.BO_Rem ? LHS.$mod(RHS) : LHS.$slash(RHS)));
    // Check for overflow case: INT_MIN / -1 or INT_MIN % -1. APSInt supports
    // this operation and gives the two's complement result.
    if (RHS.isNegative() && RHS.isAllOnesValue()
       && LHS.isSigned() && LHS.isMinSignedValue()) {
      return HandleOverflow(Info, E, LHS.extend(LHS.getBitWidth() + 1).$sub(), 
          E.getType());
    }
    return true;
   case BO_Shl:
    {
      if (Info.getLangOpts().OpenCL) {
        // OpenCL 6.3j: shift values are effectively % word size of LHS.
        RHS.$andassign(new APSInt(new APInt(RHS.getBitWidth(), 
                    ((/*static_cast*/long/*uint64_t*/)($uint2ulong(LHS.getBitWidth() - 1)))), 
                RHS.isUnsigned()));
      } else if (RHS.isSigned() && RHS.isNegative()) {
        // During constant-folding, a negative shift is an opposite shift. Such
        // a shift is not a constant expression.
        Info.CCEDiag(E, diag.note_constexpr_negative_shift).$out(RHS);
        RHS.$assignMove(RHS.$sub());
        return /*JAVA goto*/ shift_right(Info, E, LHS, RHS, Result);
      }
     return /*JAVA goto*/ shift_left(Info, E, LHS, RHS, Result);
    }
   case BO_Shr:
    {
      if (Info.getLangOpts().OpenCL) {
        // OpenCL 6.3j: shift values are effectively % word size of LHS.
        RHS.$andassign(new APSInt(new APInt(RHS.getBitWidth(), 
                    ((/*static_cast*/long/*uint64_t*/)($uint2ulong(LHS.getBitWidth() - 1)))), 
                RHS.isUnsigned()));
      } else if (RHS.isSigned() && RHS.isNegative()) {
        // During constant-folding, a negative shift is an opposite shift. Such a
        // shift is not a constant expression.
        Info.CCEDiag(E, diag.note_constexpr_negative_shift).$out(RHS);
        RHS.$assignMove(RHS.$sub());
        return /*JAVA goto*/ shift_left(Info, E, LHS, RHS, Result);
      }
     return /*JAVA goto*/ shift_right(Info, E, LHS, RHS, Result);
    }
   case BO_LT:
    Result.$assign(/*KEEP_BOOL*/LHS.$less(RHS));
    return true;
   case BO_GT:
    Result.$assign(/*KEEP_BOOL*/LHS.$greater(RHS));
    return true;
   case BO_LE:
    Result.$assign(/*KEEP_BOOL*/LHS.$lesseq(RHS));
    return true;
   case BO_GE:
    Result.$assign(/*KEEP_BOOL*/LHS.$greatereq(RHS));
    return true;
   case BO_EQ:
    Result.$assign(/*KEEP_BOOL*/LHS.$eq(RHS));
    return true;
   case BO_NE:
    Result.$assign(/*KEEP_BOOL*/LHS.$noteq(RHS));
    return true;
  }
}
private static boolean shift_left(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final /*const*/ APSInt /*&*/ LHS, 
                 /*BinaryOperatorKind Opcode,*/ APSInt RHS, 
                 final APSInt /*&*/ Result){
  //shift_left:
   // C++11 [expr.shift]p1: Shift width must be less than the bit width of
   // the shifted type.
   /*uint*/int SA = (/*uint*/int)$ulong2uint(RHS.getLimitedValue($uint2ulong(LHS.getBitWidth() - 1)));
   if ($noteq_long_APSInt$C($uint2long(SA), RHS)) {
     Info.CCEDiag(E, diag.note_constexpr_large_shift).$out(
         RHS
     ).$out$T(E.getType()).$out_uint(LHS.getBitWidth());
   } else if (LHS.isSigned()) {
     // C++11 [expr.shift]p2: A signed left shift must have a non-negative
     // operand, and must not overflow the corresponding unsigned type.
     if (LHS.isNegative()) {
       Info.CCEDiag(E, diag.note_constexpr_lshift_of_negative).$out(LHS);
     } else if ($less_uint(LHS.countLeadingZeros(), SA)) {
       Info.CCEDiag(E, diag.note_constexpr_lshift_discards);
     }
   }
   Result.$assignMove(LHS.$out(SA));
   return true;
}
private static boolean shift_right(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final /*const*/ APSInt /*&*/ LHS, 
                 /*BinaryOperatorKind Opcode,*/ APSInt RHS, 
                 final APSInt /*&*/ Result){
  //shift_right:
   // C++11 [expr.shift]p1: Shift width must be less than the bit width of the
   // shifted type.
   /*uint*/int SA = (/*uint*/int)$ulong2uint(RHS.getLimitedValue($uint2ulong(LHS.getBitWidth() - 1)));
   if ($noteq_long_APSInt$C($uint2long(SA), RHS)) {
     Info.CCEDiag(E, diag.note_constexpr_large_shift).$out(
         RHS
     ).$out$T(E.getType()).$out_uint(LHS.getBitWidth());
   }
   Result.$assignMove(LHS.$in(SA));
   return true;
}


/// Perform the given binary floating-point operation, in-place, on LHS.
//<editor-fold defaultstate="collapsed" desc="handleFloatFloatBinOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1899,
 FQN="handleFloatFloatBinOp", NM="_ZL21handleFloatFloatBinOpRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERN4llvm7APFloatENS2_18BinaryOperatorKindERKS7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL21handleFloatFloatBinOpRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERN4llvm7APFloatENS2_18BinaryOperatorKindERKS7_")
//</editor-fold>
public static boolean handleFloatFloatBinOp(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                     final APFloat /*&*/ LHS, BinaryOperatorKind Opcode, 
                     final /*const*/ APFloat /*&*/ RHS) {
  switch (Opcode) {
   default:
    Info.FFDiag(E);
    return false;
   case BO_Mul:
    LHS.multiply(RHS, APFloat.roundingMode.rmNearestTiesToEven);
    break;
   case BO_Add:
    LHS.add(RHS, APFloat.roundingMode.rmNearestTiesToEven);
    break;
   case BO_Sub:
    LHS.subtract(RHS, APFloat.roundingMode.rmNearestTiesToEven);
    break;
   case BO_Div:
    LHS.divide(RHS, APFloat.roundingMode.rmNearestTiesToEven);
    break;
  }
  if (LHS.isInfinity() || LHS.isNaN()) {
    Info.CCEDiag(E, diag.note_constexpr_float_arithmetic).$out_bool(LHS.isNaN());
    return Info.noteUndefinedBehavior();
  }
  return true;
}


/// Cast an lvalue referring to a base subobject to a derived class, by
/// truncating the lvalue's path to the given length.
//<editor-fold defaultstate="collapsed" desc="CastToDerivedClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1929,
 FQN="CastToDerivedClass", NM="_ZL18CastToDerivedClassRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_10RecordDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL18CastToDerivedClassRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_10RecordDeclEj")
//</editor-fold>
public static boolean CastToDerivedClass(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final LValue /*&*/ Result, 
                  /*const*/ RecordDecl /*P*/ TruncatedType, 
                  /*uint*/int TruncatedElements) {
  final SubobjectDesignator /*&*/ D = Result.Designator;
  
  // Check we actually point to a derived class object.
  if (TruncatedElements == D.Entries.size()) {
    return true;
  }
  assert ($greatereq_uint(TruncatedElements, D.MostDerivedPathLength)) : "not casting to a derived class";
  if (!Result.checkSubobject(Info, E, CheckSubobjectKind.CSK_Derived)) {
    return false;
  }
  
  // Truncate the path to the subobject, and remove any derived-to-base offsets.
  /*const*/ RecordDecl /*P*/ RD = TruncatedType;
  for (/*uint*/int I = TruncatedElements, N = D.Entries.size(); I != N; ++I) {
    if (RD.isInvalidDecl()) {
      return false;
    }
    final /*const*/ ASTRecordLayout /*&*/ Layout = Info.Ctx.getASTRecordLayout(RD);
    /*const*/ CXXRecordDecl /*P*/ Base = getAsBaseClass(new APValue.LValuePathEntry(D.Entries.$at(I)));
    if (isVirtualBaseClass(new APValue.LValuePathEntry(D.Entries.$at(I)))) {
      Result.Offset.$minusassign(Layout.getVBaseClassOffset(Base));
    } else {
      Result.Offset.$minusassign(Layout.getBaseClassOffset(Base));
    }
    RD = Base;
  }
  D.Entries.resize(TruncatedElements);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="HandleLValueDirectBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1958,
 FQN="HandleLValueDirectBase", NM="_ZL22HandleLValueDirectBaseRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_13CXXRecordDeclESA_PKNS2_15ASTRecordLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22HandleLValueDirectBaseRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_13CXXRecordDeclESA_PKNS2_15ASTRecordLayoutE")
//</editor-fold>
public static boolean HandleLValueDirectBase(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final LValue /*&*/ Obj, 
                      /*const*/ CXXRecordDecl /*P*/ Derived, 
                      /*const*/ CXXRecordDecl /*P*/ Base) {
  return HandleLValueDirectBase(Info, E, Obj, 
                      Derived, 
                      Base, 
                      (/*const*/ ASTRecordLayout /*P*/ )null);
}
public static boolean HandleLValueDirectBase(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final LValue /*&*/ Obj, 
                      /*const*/ CXXRecordDecl /*P*/ Derived, 
                      /*const*/ CXXRecordDecl /*P*/ Base, 
                      /*const*/ ASTRecordLayout /*P*/ RL/*= null*/) {
  if (!(RL != null)) {
    if (Derived.isInvalidDecl()) {
      return false;
    }
    RL = $AddrOf(Info.Ctx.getASTRecordLayout(Derived));
  }
  
  Obj.getLValueOffset().$addassign(RL.getBaseClassOffset(Base));
  Obj.addDecl(Info, E, Base, /*Virtual*/ false);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="HandleLValueBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1972,
 FQN="HandleLValueBase", NM="_ZL16HandleLValueBaseRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_13CXXRecordDeclEPKNS2_16CXXBaseSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL16HandleLValueBaseRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_13CXXRecordDeclEPKNS2_16CXXBaseSpecifierE")
//</editor-fold>
public static boolean HandleLValueBase(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final LValue /*&*/ Obj, 
                /*const*/ CXXRecordDecl /*P*/ DerivedDecl, 
                /*const*/ CXXBaseSpecifier /*P*/ Base) {
  /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
  if (!Base.isVirtual()) {
    return HandleLValueDirectBase(Info, E, Obj, DerivedDecl, BaseDecl);
  }
  
  final SubobjectDesignator /*&*/ D = Obj.Designator;
  if (D.Invalid) {
    return false;
  }
  
  // Extract most-derived object and corresponding type.
  DerivedDecl = D.MostDerivedType.$arrow().getAsCXXRecordDecl();
  if (!CastToDerivedClass(Info, E, Obj, DerivedDecl, D.MostDerivedPathLength)) {
    return false;
  }
  
  // Find the virtual base class.
  if (DerivedDecl.isInvalidDecl()) {
    return false;
  }
  final /*const*/ ASTRecordLayout /*&*/ Layout = Info.Ctx.getASTRecordLayout(DerivedDecl);
  Obj.getLValueOffset().$addassign(Layout.getVBaseClassOffset(BaseDecl));
  Obj.addDecl(Info, E, BaseDecl, /*Virtual*/ true);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="HandleLValueBasePath">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1997,
 FQN="HandleLValueBasePath", NM="_ZL20HandleLValueBasePathRN12_GLOBAL__N_18EvalInfoEPKN5clang8CastExprENS2_8QualTypeERNS_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL20HandleLValueBasePathRN12_GLOBAL__N_18EvalInfoEPKN5clang8CastExprENS2_8QualTypeERNS_6LValueE")
//</editor-fold>
public static boolean HandleLValueBasePath(final EvalInfo /*&*/ Info, /*const*/ CastExpr /*P*/ E, 
                    QualType Type, final LValue /*&*/ Result) {
  for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathI = $tryClone(E.path_begin$Const()), 
      PathE = $tryClone(E.path_end$Const());
       $noteq_ptr(PathI, PathE); PathI.$preInc()) {
    if (!HandleLValueBase(Info, E, Result, Type.$arrow().getAsCXXRecordDecl(), 
        PathI.$star())) {
      return false;
    }
    Type.$assignMove((PathI.$star()).getType());
  }
  return true;
}


/// Update LVal to refer to the given field, which must be a member of the type
/// currently described by LVal.
//<editor-fold defaultstate="collapsed" desc="HandleLValueMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2012,
 FQN="HandleLValueMember", NM="_ZL18HandleLValueMemberRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_9FieldDeclEPKNS2_15ASTRecordLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL18HandleLValueMemberRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_9FieldDeclEPKNS2_15ASTRecordLayoutE")
//</editor-fold>
public static boolean HandleLValueMember(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final LValue /*&*/ LVal, 
                  /*const*/ FieldDecl /*P*/ FD) {
  return HandleLValueMember(Info, E, LVal, 
                  FD, 
                  (/*const*/ ASTRecordLayout /*P*/ )null);
}
public static boolean HandleLValueMember(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final LValue /*&*/ LVal, 
                  /*const*/ FieldDecl /*P*/ FD, 
                  /*const*/ ASTRecordLayout /*P*/ RL/*= null*/) {
  if (!(RL != null)) {
    if (FD.getParent$Const().isInvalidDecl()) {
      return false;
    }
    RL = $AddrOf(Info.Ctx.getASTRecordLayout(FD.getParent$Const()));
  }
  
  /*uint*/int I = FD.getFieldIndex();
  LVal.Offset.$addassign(Info.Ctx.toCharUnitsFromBits(RL.getFieldOffset(I)));
  LVal.addDecl(Info, E, FD);
  return true;
}


/// Update LVal to refer to the given indirect field.
//<editor-fold defaultstate="collapsed" desc="HandleLValueIndirectMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2027,
 FQN="HandleLValueIndirectMember", NM="_ZL26HandleLValueIndirectMemberRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_17IndirectFieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL26HandleLValueIndirectMemberRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueEPKNS2_17IndirectFieldDeclE")
//</editor-fold>
public static boolean HandleLValueIndirectMember(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                          final LValue /*&*/ LVal, 
                          /*const*/ IndirectFieldDecl /*P*/ IFD) {
  for (/*const*/ NamedDecl /*P*/ C : IFD.chain())  {
    if (!HandleLValueMember(Info, E, LVal, cast_FieldDecl(C))) {
      return false;
    }
  }
  return true;
}


/// Get the size of the given type in char units.
//<editor-fold defaultstate="collapsed" desc="HandleSizeof">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2037,
 FQN="HandleSizeof", NM="_ZL12HandleSizeofRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERNS2_9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12HandleSizeofRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationENS2_8QualTypeERNS2_9CharUnitsE")
//</editor-fold>
public static boolean HandleSizeof(final EvalInfo /*&*/ Info, SourceLocation Loc, 
            QualType Type, final CharUnits /*&*/ Size) {
  // sizeof(void), __alignof__(void), sizeof(function) = 1 as a gcc
  // extension.
  if (Type.$arrow().isVoidType() || Type.$arrow().isFunctionType()) {
    Size.$assignMove(CharUnits.One());
    return true;
  }
  if (Type.$arrow().isDependentType()) {
    Info.FFDiag(new SourceLocation(Loc));
    return false;
  }
  if (!Type.$arrow().isConstantSizeType()) {
    // sizeof(vla) is not a constantexpr: C99 6.5.3.4p2.
    // FIXME: Better diagnostic.
    Info.FFDiag(new SourceLocation(Loc));
    return false;
  }
  
  Size.$assignMove(Info.Ctx.getTypeSizeInChars(/*NO_COPY*/Type));
  return true;
}


/// Update a pointer value to model pointer arithmetic.
/// \param Info - Information about the ongoing evaluation.
/// \param E - The expression being evaluated, for diagnostic purposes.
/// \param LVal - The pointer value to be updated.
/// \param EltTy - The pointee type represented by LVal.
/// \param Adjustment - The adjustment, in objects of type EltTy, to add.
//<editor-fold defaultstate="collapsed" desc="HandleLValueArrayAdjustment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2068,
 FQN="HandleLValueArrayAdjustment", NM="_ZL27HandleLValueArrayAdjustmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueENS2_8QualTypeEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL27HandleLValueArrayAdjustmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueENS2_8QualTypeEx")
//</editor-fold>
public static boolean HandleLValueArrayAdjustment(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                           final LValue /*&*/ LVal, QualType EltTy, 
                           long/*int64_t*/ Adjustment) {
  CharUnits SizeOfPointee/*J*/= new CharUnits();
  if (!HandleSizeof(Info, E.getExprLoc(), new QualType(EltTy), SizeOfPointee)) {
    return false;
  }
  
  // Compute the new offset in the appropriate width.
  LVal.Offset.$addassign($star_long_CharUnits$C(Adjustment, SizeOfPointee));
  LVal.adjustIndex(Info, E, Adjustment);
  return true;
}


/// Update an lvalue to refer to a component of a complex number.
/// \param Info - Information about the ongoing evaluation.
/// \param LVal - The lvalue to be updated.
/// \param EltTy - The complex number's component type.
/// \param Imag - False for the real component, true for the imaginary.
//<editor-fold defaultstate="collapsed" desc="HandleLValueComplexElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2086,
 FQN="HandleLValueComplexElement", NM="_ZL26HandleLValueComplexElementRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueENS2_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL26HandleLValueComplexElementRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueENS2_8QualTypeEb")
//</editor-fold>
public static boolean HandleLValueComplexElement(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                          final LValue /*&*/ LVal, QualType EltTy, 
                          boolean Imag) {
  if (Imag) {
    CharUnits SizeOfComponent/*J*/= new CharUnits();
    if (!HandleSizeof(Info, E.getExprLoc(), new QualType(EltTy), SizeOfComponent)) {
      return false;
    }
    LVal.Offset.$addassign(SizeOfComponent);
  }
  LVal.addComplex(Info, E, new QualType(EltTy), Imag);
  return true;
}


/// Try to evaluate the initializer for a variable declaration.
///
/// \param Info   Information about the ongoing evaluation.
/// \param E      An expression to be used when printing diagnostics.
/// \param VD     The variable whose initializer should be obtained.
/// \param Frame  The frame in which the variable was created. Must be null
///               if this variable is not local to the evaluation.
/// \param Result Filled in with a pointer to the value of the variable.
//<editor-fold defaultstate="collapsed" desc="evaluateVarDeclInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2107,
 FQN="evaluateVarDeclInit", NM="_ZL19evaluateVarDeclInitRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS2_7VarDeclEPNS_14CallStackFrameERPNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL19evaluateVarDeclInitRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS2_7VarDeclEPNS_14CallStackFrameERPNS2_7APValueE")
//</editor-fold>
public static boolean evaluateVarDeclInit(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                   /*const*/ VarDecl /*P*/ _VD, CallStackFrame /*P*/ Frame, 
                   final type$ref<APValue /*P*/ /*&*/> Result) {
  type$ref<VarDecl> VD = create_type$ref(_VD);
  OptionalNotes Notes = null;
  try {
    {
      // If this is a parameter to an active constexpr function call, perform
      // argument substitution.
      /*const*/ ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(VD.$deref());
      if ((PVD != null)) {
        // Assume arguments of a potential constant expression are unknown
        // constant expressions.
        if (Info.checkingPotentialConstantExpression()) {
          return false;
        }
        if (!(Frame != null) || !(Frame.Arguments != null)) {
          Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
          return false;
        }
        Result.$set($AddrOf(Frame.Arguments.$at(PVD.getFunctionScopeIndex())));
        return true;
      }
    }
    
    // If this is a local variable, dig out its value.
    if ((Frame != null)) {
      Result.$set(Frame.getTemporary(VD.$deref()));
      assert ((Result.$deref() != null)) : "missing value for local variable";
      return true;
    }
    
    // Dig out the initializer, and use the declaration which it's attached to.
    /*const*/ Expr /*P*/ Init = VD.$deref().getAnyInitializer(VD);
    if (!(Init != null) || Init.isValueDependent()) {
      // If we're checking a potential constant expression, the variable could be
      // initialized later.
      if (!Info.checkingPotentialConstantExpression()) {
        Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
      }
      return false;
    }
    
    // If we're currently evaluating the initializer of this declaration, use that
    // in-flight value.
    if (Info.EvaluatingDecl.dyn_cast(/*const*/ ValueDecl /*P*/.class) == VD.$deref()) {
      Result.$set(Info.EvaluatingDeclValue);
      return true;
    }
    
    // Never evaluate the initializer of a weak variable. We can't be sure that
    // this is the definition which will be used.
    if (VD.$deref().isWeak()) {
      Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
      return false;
    }
    
    // Check that we can fold the initializer. In C++, we will have already done
    // this in the cases where it matters for conformance.
    Notes/*J*/= new OptionalNotes(8);
    if (!(VD.$deref().evaluateValue(Notes) != null)) {
      Info.FFDiag(E, diag.note_constexpr_var_init_non_constant, 
          Notes.size() + 1).$out$T(VD.$deref());
      Info.Note(VD.$deref().getLocation(), diag.note_declared_at);
      Info.addNotes(new ArrayRef<std.pairTypeType<SourceLocation, PartialDiagnostic>>(Notes, false));
      return false;
    } else if (!VD.$deref().checkInitIsICE()) {
      Info.CCEDiag(E, diag.note_constexpr_var_init_non_constant, 
          Notes.size() + 1).$out$T(VD.$deref());
      Info.Note(VD.$deref().getLocation(), diag.note_declared_at);
      Info.addNotes(new ArrayRef<std.pairTypeType<SourceLocation, PartialDiagnostic>>(Notes, false));
    }
    
    Result.$set(VD.$deref().getEvaluatedValue());
    return true;
  } finally {
    if (Notes != null) { Notes.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="IsConstNonVolatile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2176,
 FQN="IsConstNonVolatile", NM="_ZL18IsConstNonVolatileN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL18IsConstNonVolatileN5clang8QualTypeE")
//</editor-fold>
public static boolean IsConstNonVolatile(QualType T) {
  Qualifiers Quals = T.getQualifiers();
  return Quals.hasConst() && !Quals.hasVolatile();
}


/// Get the base index of the given base class within an APValue representing
/// the given derived class.
//<editor-fold defaultstate="collapsed" desc="getBaseIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2183,
 FQN="getBaseIndex", NM="_ZL12getBaseIndexPKN5clang13CXXRecordDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12getBaseIndexPKN5clang13CXXRecordDeclES2_")
//</editor-fold>
public static /*uint*/int getBaseIndex(/*const*/ CXXRecordDecl /*P*/ Derived, 
            /*const*/ CXXRecordDecl /*P*/ Base) {
  Base = Base.getCanonicalDecl$Const();
  /*uint*/int Index = 0;
  for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > I = $tryClone(Derived.bases_begin$Const()), 
      /*P*/ E = $tryClone(Derived.bases_end$Const()); $noteq_ptr(I, E); I.$preInc() , ++Index) {
    if (I./*->*/$star().getType().$arrow().getAsCXXRecordDecl().getCanonicalDecl() == Base) {
      return Index;
    }
  }
  throw new llvm_unreachable("base class missing from derived class's bases list");
}


/// Extract the value of a character from a string literal.
//<editor-fold defaultstate="collapsed" desc="extractStringLiteralCharacter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2197,
 FQN="extractStringLiteralCharacter", NM="_ZL29extractStringLiteralCharacterRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL29extractStringLiteralCharacterRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEy")
//</editor-fold>
public static APSInt extractStringLiteralCharacter(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ Lit, 
                             long/*uint64_t*/ Index) {
  {
    // FIXME: Support ObjCEncodeExpr, MakeStringConstant
    /*const*/ PredefinedExpr /*P*/ PE = dyn_cast_PredefinedExpr(Lit);
    if ((PE != null)) {
      Lit = PE.getFunctionName$Const();
    }
  }
  /*const*/ StringLiteral /*P*/ S = cast_StringLiteral(Lit);
  /*const*/ ConstantArrayType /*P*/ CAT = Info.Ctx.getAsConstantArrayType(S.getType());
  assert ((CAT != null)) : "string literal isn't an array";
  QualType CharType = CAT.getElementType();
  assert (CharType.$arrow().isIntegerType()) : "unexpected character type";
  
  APSInt Value/*J*/= new APSInt($ullong2uint($uint2ullong(S.getCharByteWidth()) * Info.Ctx.getCharWidth()), 
      CharType.$arrow().isUnsignedIntegerType());
  if ($less_ulong_uint(Index, S.getLength())) {
    Value.$assign($uint2ulong(S.getCodeUnit($ulong2uint(Index))));
  }
  return Value;
}


// Expand a string literal into an array of characters.
//<editor-fold defaultstate="collapsed" desc="expandStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2217,
 FQN="expandStringLiteral", NM="_ZL19expandStringLiteralRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL19expandStringLiteralRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS2_7APValueE")
//</editor-fold>
public static void expandStringLiteral(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ Lit, 
                   final APValue /*&*/ Result) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ StringLiteral /*P*/ S = cast_StringLiteral(Lit);
    /*const*/ ConstantArrayType /*P*/ CAT = Info.Ctx.getAsConstantArrayType(S.getType());
    assert ((CAT != null)) : "string literal isn't an array";
    QualType CharType = CAT.getElementType();
    assert (CharType.$arrow().isIntegerType()) : "unexpected character type";
    
    /*uint*/int Elts = $ulong2uint(CAT.getSize().getZExtValue());
    $c$.clean(Result.$assign($c$.track(new APValue(new APValue.UninitArray(), 
            std.min_uint(S.getLength(), Elts), Elts))));
    APSInt Value/*J*/= new APSInt($ullong2uint($uint2ullong(S.getCharByteWidth()) * Info.Ctx.getCharWidth()), 
        CharType.$arrow().isUnsignedIntegerType());
    if (Result.hasArrayFiller()) {
      $c$.clean(Result.getArrayFiller().$assign($c$.track(new APValue(new APSInt(Value)))));
    }
    for (/*uint*/int I = 0, N = Result.getArrayInitializedElts(); I != N; ++I) {
      Value.$assign($uint2ulong(S.getCodeUnit(I)));
      $c$.clean(Result.getArrayInitializedElt(I).$assign($c$.track(new APValue(new APSInt(Value)))));
    }
  } finally {
    $c$.$destroy();
  }
}


// Expand an array so that it has more than Index filled elements.
//<editor-fold defaultstate="collapsed" desc="expandArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2240,
 FQN="expandArray", NM="_ZL11expandArrayRN5clang7APValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL11expandArrayRN5clang7APValueEj")
//</editor-fold>
public static void expandArray(final APValue /*&*/ Array, /*uint*/int Index) {
  APValue NewValue = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int Size = Array.getArraySize();
    assert ($less_uint(Index, Size));
    
    // Always at least double the number of elements for which we store a value.
    /*uint*/int OldElts = Array.getArrayInitializedElts();
    /*uint*/int NewElts = std.max(Index + 1, OldElts * 2);
    NewElts = std.min_uint(Size, std.max(NewElts, 8/*U*/));
    
    // Copy the data across.
    NewValue/*J*/= new APValue(new APValue.UninitArray(), NewElts, Size);
    for (/*uint*/int I = 0; I != OldElts; ++I)  {
      NewValue.getArrayInitializedElt(I).swap(Array.getArrayInitializedElt(I));
    }
    for (/*uint*/int I = OldElts; I != NewElts; ++I)  {
      $c$.clean(NewValue.getArrayInitializedElt(I).$assign($c$.track(new APValue(Array.getArrayFiller()))));
    }
    if (NewValue.hasArrayFiller()) {
      $c$.clean(NewValue.getArrayFiller().$assign($c$.track(new APValue(Array.getArrayFiller()))));
    }
    Array.swap(NewValue);
  } finally {
    if (NewValue != null) { NewValue.$destroy(); }
    $c$.$destroy();
  }
}


/// Determine whether a type would actually be read by an lvalue-to-rvalue
/// conversion. If it's of class type, we may assume that the copy operation
/// is trivial. Note that this is never true for a union type with fields
/// (because the copy always "reads" the active member) and always true for
/// a non-class type.
//<editor-fold defaultstate="collapsed" desc="isReadByLvalueToRvalueConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2265,
 FQN="isReadByLvalueToRvalueConversion", NM="_ZL32isReadByLvalueToRvalueConversionN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL32isReadByLvalueToRvalueConversionN5clang8QualTypeE")
//</editor-fold>
public static boolean isReadByLvalueToRvalueConversion(QualType T) {
  CXXRecordDecl /*P*/ RD = T.$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
  if (!(RD != null) || (RD.isUnion() && !RD.field_empty())) {
    return true;
  }
  if (RD.isEmpty()) {
    return false;
  }
  
  for (FieldDecl /*P*/ Field : RD.fields())  {
    if (isReadByLvalueToRvalueConversion(Field.getType())) {
      return true;
    }
  }
  
  for (final CXXBaseSpecifier /*&*/ BaseSpec : RD.bases())  {
    if (isReadByLvalueToRvalueConversion(BaseSpec.getType())) {
      return true;
    }
  }
  
  return false;
}


/// Diagnose an attempt to read from any unreadable field within the specified
/// type, which might be a class type.
//<editor-fold defaultstate="collapsed" desc="diagnoseUnreadableFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2285,
 FQN="diagnoseUnreadableFields", NM="_ZL24diagnoseUnreadableFieldsRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL24diagnoseUnreadableFieldsRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeE")
//</editor-fold>
public static boolean diagnoseUnreadableFields(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                        QualType T) {
  CXXRecordDecl /*P*/ RD = T.$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
  if (!(RD != null)) {
    return false;
  }
  if (!RD.hasMutableFields()) {
    return false;
  }
  
  for (FieldDecl /*P*/ Field : RD.fields()) {
    // If we're actually going to read this field in some way, then it can't
    // be mutable. If we're in a union, then assigning to a mutable field
    // (even an empty one) can change the active member, so that's not OK.
    // FIXME: Add core issue number for the union case.
    if (Field.isMutable()
       && (RD.isUnion() || isReadByLvalueToRvalueConversion(Field.getType()))) {
      Info.FFDiag(E, diag.note_constexpr_ltor_mutable, 1).$out$T(Field);
      Info.Note(Field.getLocation(), diag.note_declared_at);
      return true;
    }
    if (diagnoseUnreadableFields(Info, E, Field.getType())) {
      return true;
    }
  }
  
  for (final CXXBaseSpecifier /*&*/ BaseSpec : RD.bases())  {
    if (diagnoseUnreadableFields(Info, E, BaseSpec.getType())) {
      return true;
    }
  }
  
  // All mutable fields were empty, and thus not actually read.
  return false;
}

// end anonymous namespace

/// Find the designated sub-object of an rvalue.
/*template <typename SubobjectHandler> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="findSubobject">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2347,
 FQN="findSubobject", NM="Tpl__Z13findSubobjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_14CompleteObjectERKNS_19SubobjectDesignatorERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_Z13findSubobjectIN12_GLOBAL__N_123ExtractSubobjectHandlerEENT_11result_typeERNS0_8EvalInfoEPKN5clang4ExprERKNS0_14CompleteObjectERKNS0_19SubobjectDesignatorERS2_")
//</editor-fold>
public static </*typename*/ T extends SubobjectHandler>  boolean /*SubobjectHandler.result_type*/ findSubobject(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final /*const*/ CompleteObject /*&*/ Obj, 
             final /*const*/ SubobjectDesignator /*&*/ Sub, final T /*&*/ handler) {
  //ExtractSubobjectHandler T1;
  //ModifySubobjectHandler T2;
  //CompoundAssignSubobjectHandler T3;
  //IncDecSubobjectHandler T4;
  if (Sub.Invalid) {
    // A diagnostic will have already been produced.
    return handler.failed();
  }
  if (Sub.isOnePastTheEnd()) {
    if (Info.getLangOpts().CPlusPlus11) {
       Info.FFDiag(E, diag.note_constexpr_access_past_end).$out$T(
          handler.AccessKind());
    } else {
      Info.FFDiag(E);
    }
    return handler.failed();
  }
  
  APValue /*P*/ O = Obj.Value;
  QualType ObjType = new QualType(Obj.Type);
  /*const*/ FieldDecl /*P*/ LastField = null;
  
  // Walk the designator's path to find the subobject.
  for (/*uint*/int I = 0, N = Sub.Entries.size();; ++I) {
    if (O.isUninit()) {
      if (!Info.checkingPotentialConstantExpression()) {
         Info.FFDiag(E, diag.note_constexpr_access_uninit).$out$T(handler.AccessKind());
      }
      return handler.failed();
    }
    if (I == N) {
      // If we are reading an object of class type, there may still be more
      // things we need to check: if there are any mutable subobjects, we
      // cannot perform this read. (This only happens when performing a trivial
      // copy or assignment.)
      if (Native.$bool(ObjType.$arrow().isRecordType() && Native.$eq(handler.AccessKind(), AccessKinds.AK_Read))
         && diagnoseUnreadableFields(Info, E, new QualType(ObjType))) {
        return handler.failed();
      }
      if (Native.$not(handler.found($Deref(O), ObjType))) {
        return false;
      }
      
      // If we modified a bit-field, truncate it to the right width.
      if (Native.$bool(Native.$bool(Native.$bool(Native.$noteq(handler.AccessKind(), AccessKinds.AK_Read))
         && Native.$bool(LastField)) && LastField.isBitField())
         && !truncateBitfieldValue(Info, E, $Deref(O), LastField)) {
        return false;
      }
      
      return true;
    }
    
    LastField = null;
    if (ObjType.$arrow().isArrayType()) {
      // Next subobject is an array element.
      /*const*/ ConstantArrayType /*P*/ CAT = Info.Ctx.getAsConstantArrayType(new QualType(ObjType));
      assert ((CAT != null)) : "vla in literal type?";
      long/*uint64_t*/ Index = Sub.Entries.$at$Const(I).ArrayIndex;
      if (CAT.getSize().ule(Index)) {
        // Note, it should not be possible to form a pointer with a valid
        // designator which points more than one past the end of the array.
        if (Info.getLangOpts().CPlusPlus11) {
           Info.FFDiag(E, diag.note_constexpr_access_past_end).$out$T(
              handler.AccessKind());
        } else {
          Info.FFDiag(E);
        }
        return handler.failed();
      }
      
      ObjType.$assignMove(CAT.getElementType());
      
      // An array object is represented as either an Array APValue or as an
      // LValue which refers to a string literal.
      if (O.isLValue()) {
        assert (I == N - 1) : "extracting subobject of character?";
        assert (!O.hasLValuePath() || O.getLValuePath().empty());
        if (Native.$noteq(handler.AccessKind(), AccessKinds.AK_Read)) {
          expandStringLiteral(Info, O.getLValueBase().get(/*const*/ Expr /*P*/.class), 
              $Deref(O));
        } else {
          return handler.foundString($Deref(O), ObjType, Index);
        }
      }
      if ($greater_uint_ulong(O.getArrayInitializedElts(), Index)) {
        O = $AddrOf(O.getArrayInitializedElt($ulong2uint(Index)));
      } else if (Native.$noteq(handler.AccessKind(), AccessKinds.AK_Read)) {
        expandArray($Deref(O), $ulong2uint(Index));
        O = $AddrOf(O.getArrayInitializedElt($ulong2uint(Index)));
      } else {
        O = $AddrOf(O.getArrayFiller());
      }
    } else if (ObjType.$arrow().isAnyComplexType()) {
      // Next subobject is a complex number.
      long/*uint64_t*/ Index = Sub.Entries.$at$Const(I).ArrayIndex;
      if ($greater_ulong_ullong(Index, 1)) {
        if (Info.getLangOpts().CPlusPlus11) {
          Info.FFDiag(E, diag.note_constexpr_access_past_end).$out$T(
              handler.AccessKind());
        } else {
          Info.FFDiag(E);
        }
        return handler.failed();
      }
      
      boolean WasConstQualified = ObjType.isConstQualified();
      ObjType.$assignMove(ObjType.$arrow().castAs(ComplexType.class).getElementType());
      if (WasConstQualified) {
        ObjType.addConst();
      }
      assert (I == N - 1) : "extracting subobject of scalar?";
      if (O.isComplexInt()) {
        return handler.found((Index != 0) ? O.getComplexIntImag() : O.getComplexIntReal(), ObjType);
      } else {
        assert (O.isComplexFloat());
        return handler.found((Index != 0) ? O.getComplexFloatImag() : O.getComplexFloatReal(), ObjType);
      }
    } else {
      /*const*/ FieldDecl /*P*/ Field = getAsField(new APValue.LValuePathEntry(Sub.Entries.$at$Const(I)));
      if ((Field != null)) {
        if (Field.isMutable() && Native.$eq(handler.AccessKind(), AccessKinds.AK_Read)) {
          Info.FFDiag(E, diag.note_constexpr_ltor_mutable, 1).$out$T(
              Field
          );
          Info.Note(Field.getLocation(), diag.note_declared_at);
          return handler.failed();
        }
        
        // Next subobject is a class, struct or union field.
        RecordDecl /*P*/ RD = ObjType.$arrow().<RecordType>castAs$RecordType().getDecl();
        if (RD.isUnion()) {
          /*const*/ FieldDecl /*P*/ UnionField = O.getUnionField();
          if (!(UnionField != null)
             || UnionField.getCanonicalDecl$Const() != Field.getCanonicalDecl$Const()) {
            Info.FFDiag(E, diag.note_constexpr_access_inactive_union_member).$out$T(
                            handler.AccessKind()
            ).$out$T(Field).$out$T(!(UnionField != null)).$out$T(UnionField);
            return handler.failed();
          }
          O = $AddrOf(O.getUnionValue());
        } else {
          O = $AddrOf(O.getStructField(Field.getFieldIndex()));
        }
        
        boolean WasConstQualified = ObjType.isConstQualified();
        ObjType.$assignMove(Field.getType());
        if (WasConstQualified && !Field.isMutable()) {
          ObjType.addConst();
        }
        if (ObjType.isVolatileQualified()) {
          if (Info.getLangOpts().CPlusPlus) {
            // FIXME: Include a description of the path to the volatile subobject.
            Info.FFDiag(E, diag.note_constexpr_access_volatile_obj, 1).$out$T(
                        handler.AccessKind()
            ).$out$T(2).$out$T(Field);
            Info.Note(Field.getLocation(), diag.note_declared_at);
          } else {
            Info.FFDiag(E, diag.note_invalid_subexpr_in_const_expr);
          }
          return handler.failed();
        }
        
        LastField = Field;
      } else {
        // Next subobject is a base class.
        /*const*/ CXXRecordDecl /*P*/ Derived = ObjType.$arrow().getAsCXXRecordDecl();
        /*const*/ CXXRecordDecl /*P*/ Base = getAsBaseClass(new APValue.LValuePathEntry(Sub.Entries.$at$Const(I)));
        O = $AddrOf(O.getStructBase(getBaseIndex(Derived, Base)));
        
        boolean WasConstQualified = ObjType.isConstQualified();
        ObjType.$assignMove(Info.Ctx.getRecordType(Base));
        if (WasConstQualified) {
          ObjType.addConst();
        }
      }
    }
  }
}


/// Extract the designated sub-object of an rvalue.
//<editor-fold defaultstate="collapsed" desc="extractSubobject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2545,
 FQN="extractSubobject", NM="_ZL16extractSubobjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_14CompleteObjectERKNS_19SubobjectDesignatorERNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL16extractSubobjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_14CompleteObjectERKNS_19SubobjectDesignatorERNS2_7APValueE")
//</editor-fold>
public static boolean extractSubobject(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                final /*const*/ CompleteObject /*&*/ Obj, 
                final /*const*/ SubobjectDesignator /*&*/ Sub, 
                final APValue /*&*/ Result) {
  ExtractSubobjectHandler Handler = new ExtractSubobjectHandler(Info, Result);
  return findSubobject(Info, E, Obj, Sub, Handler);
}


/// Update the designated sub-object of an rvalue to the given value.
//<editor-fold defaultstate="collapsed" desc="modifySubobject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2605,
 FQN="modifySubobject", NM="_ZL15modifySubobjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_14CompleteObjectERKNS_19SubobjectDesignatorERNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL15modifySubobjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_14CompleteObjectERKNS_19SubobjectDesignatorERNS2_7APValueE")
//</editor-fold>
public static boolean modifySubobject(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
               final /*const*/ CompleteObject /*&*/ Obj, 
               final /*const*/ SubobjectDesignator /*&*/ Sub, 
               final APValue /*&*/ NewVal) {
  ModifySubobjectHandler Handler = new ModifySubobjectHandler(Info, NewVal, E);
  return findSubobject(Info, E, Obj, Sub, Handler);
}


/// Find the position where two subobject designators diverge, or equivalently
/// the length of the common initial subsequence.
//<editor-fold defaultstate="collapsed" desc="FindDesignatorMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2615,
 FQN="FindDesignatorMismatch", NM="_ZL22FindDesignatorMismatchN5clang8QualTypeERKN12_GLOBAL__N_119SubobjectDesignatorES4_Rb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22FindDesignatorMismatchN5clang8QualTypeERKN12_GLOBAL__N_119SubobjectDesignatorES4_Rb")
//</editor-fold>
public static /*uint*/int FindDesignatorMismatch(QualType ObjType, 
                      final /*const*/ SubobjectDesignator /*&*/ A, 
                      final /*const*/ SubobjectDesignator /*&*/ B, 
                      final bool$ref/*bool &*/ WasArrayIndex) {
  /*uint*/int I = 0;
  /*uint*/int N = std.min_uint(A.Entries.size(), B.Entries.size());
  for (; I != N; ++I) {
    if (!ObjType.isNull()
       && (ObjType.$arrow().isArrayType() || ObjType.$arrow().isAnyComplexType())) {
      // Next subobject is an array element.
      if (A.Entries.$at$Const(I).ArrayIndex != B.Entries.$at$Const(I).ArrayIndex) {
        WasArrayIndex.$set(true);
        return I;
      }
      if (ObjType.$arrow().isAnyComplexType()) {
        ObjType.$assignMove(ObjType.$arrow().castAs(ComplexType.class).getElementType());
      } else {
        ObjType.$assignMove(ObjType.$arrow().castAsArrayTypeUnsafe().getElementType());
      }
    } else {
      if ($noteq_ptr(A.Entries.$at$Const(I).BaseOrMember, B.Entries.$at$Const(I).BaseOrMember)) {
        WasArrayIndex.$set(false);
        return I;
      }
      {
        /*const*/ FieldDecl /*P*/ FD = getAsField(new APValue.LValuePathEntry(A.Entries.$at$Const(I)));
        if ((FD != null)) {
          // Next subobject is a field.
          ObjType.$assignMove(FD.getType());
        } else {
          // Next subobject is a base class.
          ObjType.$assignMove(new QualType());
        }
      }
    }
  }
  WasArrayIndex.$set(false);
  return I;
}


/// Determine whether the given subobject designators refer to elements of the
/// same array object.
//<editor-fold defaultstate="collapsed" desc="AreElementsOfSameArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2651,
 FQN="AreElementsOfSameArray", NM="_ZL22AreElementsOfSameArrayN5clang8QualTypeERKN12_GLOBAL__N_119SubobjectDesignatorES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22AreElementsOfSameArrayN5clang8QualTypeERKN12_GLOBAL__N_119SubobjectDesignatorES4_")
//</editor-fold>
public static boolean AreElementsOfSameArray(QualType ObjType, 
                      final /*const*/ SubobjectDesignator /*&*/ A, 
                      final /*const*/ SubobjectDesignator /*&*/ B) {
  if (A.Entries.size() != B.Entries.size()) {
    return false;
  }
  
  boolean IsArray = A.MostDerivedIsArrayElement;
  if (IsArray && A.MostDerivedPathLength != A.Entries.size()) {
    // A is a subobject of the array element.
    return false;
  }
  
  // If A (and B) designates an array element, the last entry will be the array
  // index. That doesn't have to match. Otherwise, we're in the 'implicit array
  // of length 1' case, and the entire path must match.
  bool$ref WasArrayIndex = create_bool$ref();
  /*uint*/int CommonLength = FindDesignatorMismatch(new QualType(ObjType), A, B, WasArrayIndex);
  return $greatereq_uint(CommonLength, A.Entries.size() - (IsArray ? 1 : 0));
}


/// Find the complete object to which an LValue refers.
//<editor-fold defaultstate="collapsed" desc="findCompleteObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2671,
 FQN="findCompleteObject", NM="_ZL18findCompleteObjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE11AccessKindsRKNS_6LValueENS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL18findCompleteObjectRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE11AccessKindsRKNS_6LValueENS2_8QualTypeE")
//</editor-fold>
public static CompleteObject findCompleteObject(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                  AccessKinds AK, final /*const*/ LValue /*&*/ LVal, 
                  QualType LValType) {
  if (!LVal.Base.$bool()) {
    Info.FFDiag(E, diag.note_constexpr_access_null).$out$T(AK);
    return new CompleteObject();
  }
  
  CallStackFrame /*P*/ Frame = null;
  if ((LVal.CallIndex != 0)) {
    Frame = Info.getCallFrame(LVal.CallIndex);
    if (!(Frame != null)) {
      Info.FFDiag(E, diag.note_constexpr_lifetime_ended, 1).$out$T(
          AK
      ).$out_int(LVal.Base.is(/*const*/ ValueDecl /*P*/.class));
      NoteLValueLocation(Info, new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(LVal.Base));
      return new CompleteObject();
    }
  }
  
  // C++11 DR1311: An lvalue-to-rvalue conversion on a volatile-qualified type
  // is not a constant expression (even if the object is non-volatile). We also
  // apply this rule to C++98, in order to conform to the expected 'volatile'
  // semantics.
  if (LValType.isVolatileQualified()) {
    if (Info.getLangOpts().CPlusPlus) {
      Info.FFDiag(E, diag.note_constexpr_access_volatile_type).$out$T(
          AK
      ).$out$T(LValType);
    } else {
      Info.FFDiag(E);
    }
    return new CompleteObject();
  }
  
  // Compute value storage location and type of base object.
  type$ref<APValue /*P*/ > BaseVal = create_type$ref();
  QualType BaseType = getType(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(LVal.Base));
  {
    
    /*const*/ ValueDecl /*P*/ D = LVal.Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
    if ((D != null)) {
      // In C++98, const, non-volatile integers initialized with ICEs are ICEs.
      // In C++11, constexpr, non-volatile variables initialized with constant
      // expressions are constant expressions too. Inside constexpr functions,
      // parameters are constant expressions even if they're non-const.
      // In C++1y, objects local to a constant expression (those with a Frame) are
      // both readable and writable inside constant expressions.
      // In C, such things can also be folded, although they are not ICEs.
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        {
          /*const*/ VarDecl /*P*/ VDef = VD.getDefinition$Const(Info.Ctx);
          if ((VDef != null)) {
            VD = VDef;
          }
        }
      }
      if (!(VD != null) || VD.isInvalidDecl()) {
        Info.FFDiag(E);
        return new CompleteObject();
      }
      
      // Accesses of volatile-qualified objects are not allowed.
      if (BaseType.isVolatileQualified()) {
        if (Info.getLangOpts().CPlusPlus) {
          Info.FFDiag(E, diag.note_constexpr_access_volatile_obj, 1).$out$T(
              AK
          ).$out_int(1).$out$T(VD);
          Info.Note(VD.getLocation(), diag.note_declared_at);
        } else {
          Info.FFDiag(E);
        }
        return new CompleteObject();
      }
      
      // Unless we're looking at a local variable or argument in a constexpr call,
      // the variable we're reading must be const.
      if (!(Frame != null)) {
        if (Info.getLangOpts().CPlusPlus14
           && VD == Info.EvaluatingDecl.dyn_cast(/*const*/ ValueDecl /*P*/.class)) {
          // OK, we can read and modify an object if we're in the process of
          // evaluating its initializer, because its lifetime began in this
          // evaluation.
        } else if (AK != AccessKinds.AK_Read) {
          // All the remaining cases only permit reading.
          Info.FFDiag(E, diag.note_constexpr_modify_global);
          return new CompleteObject();
        } else if (VD.isConstexpr()) {
          // OK, we can read this variable.
        } else if (BaseType.$arrow().isIntegralOrEnumerationType()) {
          // In OpenCL if a variable is in constant address space it is a const value.
          if (!(BaseType.isConstQualified()
             || (Info.getLangOpts().OpenCL
             && BaseType.getAddressSpace() == LangAS.ID.opencl_constant))) {
            if (Info.getLangOpts().CPlusPlus) {
              Info.FFDiag(E, diag.note_constexpr_ltor_non_const_int, 1).$out$T(VD);
              Info.Note(VD.getLocation(), diag.note_declared_at);
            } else {
              Info.FFDiag(E);
            }
            return new CompleteObject();
          }
        } else if (BaseType.$arrow().isFloatingType() && BaseType.isConstQualified()) {
          // We support folding of const floating-point types, in order to make
          // static const data members of such types (supported as an extension)
          // more useful.
          if (Info.getLangOpts().CPlusPlus11) {
            Info.CCEDiag(E, diag.note_constexpr_ltor_non_constexpr, 1).$out$T(VD);
            Info.Note(VD.getLocation(), diag.note_declared_at);
          } else {
            Info.CCEDiag(E);
          }
        } else {
          // FIXME: Allow folding of values of any literal type in all languages.
          if (Info.checkingPotentialConstantExpression()
             && VD.getType().isConstQualified() && !(VD.hasDefinition(Info.Ctx).getValue() != 0)) {
            // The definition of this variable could be constexpr. We can't
            // access it right now, but may be able to in future.
          } else if (Info.getLangOpts().CPlusPlus11) {
            Info.FFDiag(E, diag.note_constexpr_ltor_non_constexpr, 1).$out$T(VD);
            Info.Note(VD.getLocation(), diag.note_declared_at);
          } else {
            Info.FFDiag(E);
          }
          return new CompleteObject();
        }
      }
      if (!evaluateVarDeclInit(Info, E, VD, Frame, BaseVal)) {
        return new CompleteObject();
      }
    } else {
      /*const*/ Expr /*P*/ Base = LVal.Base.dyn_cast(/*const*/ Expr /*P*/.class);
      if (!(Frame != null)) {
        {
          /*const*/ MaterializeTemporaryExpr /*P*/ MTE = dyn_cast_MaterializeTemporaryExpr(Base);
          if ((MTE != null)) {
            assert (MTE.getStorageDuration() == StorageDuration.SD_Static) : "should have a frame for a non-global materialized temporary";
            
            // Per C++1y [expr.const]p2:
            //  an lvalue-to-rvalue conversion [is not allowed unless it applies to]
            //   - a [...] glvalue of integral or enumeration type that refers to
            //     a non-volatile const object [...]
            //   [...]
            //   - a [...] glvalue of literal type that refers to a non-volatile
            //     object whose lifetime began within the evaluation of e.
            //
            // C++11 misses the 'began within the evaluation of e' check and
            // instead allows all temporaries, including things like:
            //   int &&r = 1;
            //   int x = ++r;
            //   constexpr int k = r;
            // Therefore we use the C++1y rules in C++11 too.
            /*const*/ ValueDecl /*P*/ VD = Info.EvaluatingDecl.dyn_cast(/*const*/ ValueDecl /*P*/.class);
            /*const*/ ValueDecl /*P*/ ED = MTE.getExtendingDecl();
            if (!(BaseType.isConstQualified()
               && BaseType.$arrow().isIntegralOrEnumerationType())
               && !((VD != null) && VD.getCanonicalDecl$Const() == ED.getCanonicalDecl$Const())) {
              Info.FFDiag(E, diag.note_constexpr_access_static_temporary, 1).$out$T(AK);
              Info.Note(MTE.getExprLoc(), diag.note_constexpr_temporary_here);
              return new CompleteObject();
            }
            
            BaseVal.$set(Info.Ctx.getMaterializedTemporaryValue(MTE, false));
            assert ((BaseVal.$deref() != null)) : "got reference to unevaluated temporary";
          } else {
            Info.FFDiag(E);
            return new CompleteObject();
          }
        }
      } else {
        BaseVal.$set(Frame.getTemporary(Base));
        assert ((BaseVal.$deref() != null)) : "missing value for temporary";
      }
      
      // Volatile temporary objects cannot be accessed in constant expressions.
      if (BaseType.isVolatileQualified()) {
        if (Info.getLangOpts().CPlusPlus) {
          Info.FFDiag(E, diag.note_constexpr_access_volatile_obj, 1).$out$T(
              AK
          ).$out_int(0);
          Info.Note(Base.getExprLoc(), diag.note_constexpr_temporary_here);
        } else {
          Info.FFDiag(E);
        }
        return new CompleteObject();
      }
    }
  }
  
  // During the construction of an object, it is not yet 'const'.
  // FIXME: We don't set up EvaluatingDecl for local variables or temporaries,
  // and this doesn't do quite the right thing for const subobjects of the
  // object under construction.
  if ($eq_PointerUnion$PT1$PT2(LVal.getLValueBase(), /*NO_COPY*/Info.EvaluatingDecl)) {
    BaseType.$assignMove(Info.Ctx.getCanonicalType(/*NO_COPY*/BaseType).$QualType());
    BaseType.removeLocalConst();
  }
  
  // In C++1y, we can't safely access any mutable state when we might be
  // evaluating after an unmodeled side effect.
  //
  // FIXME: Not all local state is mutable. Allow local constant subobjects
  // to be read here (but take care with 'mutable' fields).
  if (((Frame != null) && Info.getLangOpts().CPlusPlus14
     && Info.EvalStatus.HasSideEffects)
     || (AK != AccessKinds.AK_Read && Info.IsSpeculativelyEvaluating)) {
    return new CompleteObject();
  }
  
  return new CompleteObject(BaseVal.$deref(), new QualType(BaseType));
}


/// \brief Perform an lvalue-to-rvalue conversion on the given glvalue. This
/// can also be used for 'lvalue-to-lvalue' conversions for looking up the
/// glvalue referred to by an entity of reference type.
///
/// \param Info - Information about the ongoing evaluation.
/// \param Conv - The expression for which we are performing the conversion.
///               Used for diagnostics.
/// \param Type - The type of the glvalue (before stripping cv-qualifiers in the
///               case of a non-class type).
/// \param LVal - The glvalue on which we are attempting to perform this action.
/// \param RVal - The produced value will be placed here.
//<editor-fold defaultstate="collapsed" desc="handleLValueToRValueConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2882,
 FQN="handleLValueToRValueConversion", NM="_ZL30handleLValueToRValueConversionRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKNS_6LValueERNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL30handleLValueToRValueConversionRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprENS2_8QualTypeERKNS_6LValueERNS2_7APValueE")
//</editor-fold>
public static boolean handleLValueToRValueConversion(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ Conv, 
                              QualType Type, 
                              final /*const*/ LValue /*&*/ LVal, final APValue /*&*/ RVal) {
  if (LVal.Designator.Invalid) {
    return false;
  }
  
  // Check for special cases where there is no existing APValue to look at.
  /*const*/ Expr /*P*/ Base = LVal.Base.dyn_cast(/*const*/ Expr /*P*/.class);
  if ((Base != null) && !(LVal.CallIndex != 0) && !Type.isVolatileQualified()) {
    {
      /*const*/ CompoundLiteralExpr /*P*/ CLE = dyn_cast_CompoundLiteralExpr(Base);
      if ((CLE != null)) {
        APValue Lit = null;
        try {
          // In C99, a CompoundLiteralExpr is an lvalue, and we defer evaluating the
          // initializer until now for such expressions. Such an expression can't be
          // an ICE in C, so this only matters for fold.
          assert (!Info.getLangOpts().CPlusPlus) : "lvalue compound literal in c++?";
          if (Type.isVolatileQualified()) {
            Info.FFDiag(Conv);
            return false;
          }
          Lit/*J*/= new APValue();
          if (!Evaluate(Lit, Info, CLE.getInitializer$Const())) {
            return false;
          }
          CompleteObject LitObj/*J*/= new CompleteObject($AddrOf(Lit), Base.getType());
          return extractSubobject(Info, Conv, LitObj, LVal.Designator, RVal);
        } finally {
          if (Lit != null) { Lit.$destroy(); }
        }
      } else if (isa_StringLiteral(Base) || isa_PredefinedExpr(Base)) {
        APValue Str = null;
        try {
          // We represent a string literal array as an lvalue pointing at the
          // corresponding expression, rather than building an array of chars.
          // FIXME: Support ObjCEncodeExpr, MakeStringConstant
          Str/*J*/= new APValue(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, Base), CharUnits.Zero(), new APValue.NoLValuePath(), 0);
          CompleteObject StrObj/*J*/= new CompleteObject($AddrOf(Str), Base.getType());
          return extractSubobject(Info, Conv, StrObj, LVal.Designator, RVal);
        } finally {
          if (Str != null) { Str.$destroy(); }
        }
      }
    }
  }
  
  CompleteObject Obj = findCompleteObject(Info, Conv, AccessKinds.AK_Read, LVal, new QualType(Type));
  return Obj.$bool() && extractSubobject(Info, Conv, Obj, LVal.Designator, RVal);
}


/// Perform an assignment of Val to LVal. Takes ownership of Val.
//<editor-fold defaultstate="collapsed" desc="handleAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2920,
 FQN="handleAssignment", NM="_ZL16handleAssignmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeERNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL16handleAssignmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeERNS2_7APValueE")
//</editor-fold>
public static boolean handleAssignment(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final /*const*/ LValue /*&*/ LVal, 
                QualType LValType, final APValue /*&*/ Val) {
  if (LVal.Designator.Invalid) {
    return false;
  }
  if (!Info.getLangOpts().CPlusPlus14) {
    Info.FFDiag(E);
    return false;
  }
  
  CompleteObject Obj = findCompleteObject(Info, E, AccessKinds.AK_Assign, LVal, new QualType(LValType));
  return Obj.$bool() && modifySubobject(Info, E, Obj, LVal.Designator, Val);
}

//<editor-fold defaultstate="collapsed" desc="isOverflowingIntegerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2934,
 FQN="isOverflowingIntegerType", NM="_ZL24isOverflowingIntegerTypeRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL24isOverflowingIntegerTypeRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static boolean isOverflowingIntegerType(final ASTContext /*&*/ Ctx, QualType T) {
  return T.$arrow().isSignedIntegerType()
     && $greatereq_uint(Ctx.getIntWidth(new QualType(T)), Ctx.getIntWidth(Ctx.IntTy.$QualType()));
}


/// Perform a compound assignment of LVal <op>= RVal.
//<editor-fold defaultstate="collapsed" desc="handleCompoundAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3039,
 FQN="handleCompoundAssignment", NM="_ZL24handleCompoundAssignmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeES9_NS2_18BinaryOperatorKindERKNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL24handleCompoundAssignmentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeES9_NS2_18BinaryOperatorKindERKNS2_7APValueE")
//</editor-fold>
public static boolean handleCompoundAssignment(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                        final /*const*/ LValue /*&*/ LVal, QualType LValType, QualType PromotedLValType, 
                        BinaryOperatorKind Opcode, final /*const*/ APValue /*&*/ RVal) {
  if (LVal.Designator.Invalid) {
    return false;
  }
  if (!Info.getLangOpts().CPlusPlus14) {
    Info.FFDiag(E);
    return false;
  }
  
  CompleteObject Obj = findCompleteObject(Info, E, AccessKinds.AK_Assign, LVal, new QualType(LValType));
  CompoundAssignSubobjectHandler Handler = new CompoundAssignSubobjectHandler(
    Info, E, PromotedLValType, Opcode, 
    RVal);
  return Obj.$bool() && findSubobject(Info, E, Obj, LVal.Designator, Handler);
}

// end anonymous namespace

/// Perform an increment or decrement on LVal.
//<editor-fold defaultstate="collapsed" desc="handleIncDec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3190,
 FQN="handleIncDec", NM="_ZL12handleIncDecRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeEbPNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12handleIncDecRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERKNS_6LValueENS2_8QualTypeEbPNS2_7APValueE")
//</editor-fold>
public static boolean handleIncDec(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, final /*const*/ LValue /*&*/ LVal, 
            QualType LValType, boolean IsIncrement, APValue /*P*/ Old) {
  if (LVal.Designator.Invalid) {
    return false;
  }
  if (!Info.getLangOpts().CPlusPlus14) {
    Info.FFDiag(E);
    return false;
  }
  
  AccessKinds AK = IsIncrement ? AccessKinds.AK_Increment : AccessKinds.AK_Decrement;
  CompleteObject Obj = findCompleteObject(Info, E, AK, LVal, new QualType(LValType));
  IncDecSubobjectHandler Handler = new IncDecSubobjectHandler(Info, E, AK, Old);
  return Obj.$bool() && findSubobject(Info, E, Obj, LVal.Designator, Handler);
}


/// Build an lvalue for the object argument of a member function call.
//<editor-fold defaultstate="collapsed" desc="EvaluateObjectArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3207,
 FQN="EvaluateObjectArgument", NM="_ZL22EvaluateObjectArgumentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22EvaluateObjectArgumentRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprERNS_6LValueE")
//</editor-fold>
public static boolean EvaluateObjectArgument(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ Object, 
                      final LValue /*&*/ This) {
  if (Object.getType().$arrow().isPointerType()) {
    return EvaluatePointer(Object, This, Info);
  }
  if (Object.isGLValue()) {
    return EvaluateLValue(Object, This, Info);
  }
  if (Object.getType().$arrow().isLiteralType(Info.Ctx)) {
    return EvaluateTemporary(Object, This, Info);
  }
  
  Info.FFDiag(Object, diag.note_constexpr_nonliteral).$out$T(Object.getType());
  return false;
}


/// HandleMemberPointerAccess - Evaluate a member access operation and build an
/// lvalue referring to the result.
///
/// \param Info - Information about the ongoing evaluation.
/// \param LV - An lvalue referring to the base of the member pointer.
/// \param RHS - The member pointer expression.
/// \param IncludeMember - Specifies whether the member itself is included in
///        the resulting LValue subobject designator. This is not possible when
///        creating a bound member function.
/// \return The field or method declaration to which the member pointer refers,
///         or 0 if evaluation fails.
//<editor-fold defaultstate="collapsed" desc="HandleMemberPointerAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3233,
 FQN="HandleMemberPointerAccess", NM="_ZL25HandleMemberPointerAccessRN12_GLOBAL__N_18EvalInfoEN5clang8QualTypeERNS_6LValueEPKNS2_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL25HandleMemberPointerAccessRN12_GLOBAL__N_18EvalInfoEN5clang8QualTypeERNS_6LValueEPKNS2_4ExprEb")
//</editor-fold>
public static /*const*/ ValueDecl /*P*/ HandleMemberPointerAccess(final EvalInfo /*&*/ Info, 
                         QualType LVType, 
                         final LValue /*&*/ LV, 
                         /*const*/ Expr /*P*/ RHS) {
  return HandleMemberPointerAccess(Info, 
                         LVType, 
                         LV, 
                         RHS, 
                         true);
}
public static /*const*/ ValueDecl /*P*/ HandleMemberPointerAccess(final EvalInfo /*&*/ Info, 
                         QualType LVType, 
                         final LValue /*&*/ LV, 
                         /*const*/ Expr /*P*/ RHS, 
                         boolean IncludeMember/*= true*/) {
  MemberPtr MemPtr = null;
  try {
    MemPtr/*J*/= new MemberPtr();
    if (!EvaluateMemberPointer(RHS, MemPtr, Info)) {
      return null;
    }
    
    // C++11 [expr.mptr.oper]p6: If the second operand is the null pointer to
    // member value, the behavior is undefined.
    if (!(MemPtr.getDecl() != null)) {
      // FIXME: Specific diagnostic.
      Info.FFDiag(RHS);
      return null;
    }
    if (MemPtr.isDerivedMember()) {
      // This is a member of some derived class. Truncate LV appropriately.
      // The end of the derived-to-base path for the base object must match the
      // derived-to-base path for the member pointer.
      if ($greater_uint(LV.Designator.MostDerivedPathLength + MemPtr.Path.size()
        , LV.Designator.Entries.size())) {
        Info.FFDiag(RHS);
        return null;
      }
      /*uint*/int PathLengthToMember = LV.Designator.Entries.size() - MemPtr.Path.size();
      for (/*uint*/int I = 0, N = MemPtr.Path.size(); I != N; ++I) {
        /*const*/ CXXRecordDecl /*P*/ LVDecl = getAsBaseClass(new APValue.LValuePathEntry(LV.Designator.Entries.$at(PathLengthToMember + I)));
        /*const*/ CXXRecordDecl /*P*/ MPDecl = MemPtr.Path.$at(I);
        if (LVDecl.getCanonicalDecl$Const() != MPDecl.getCanonicalDecl$Const()) {
          Info.FFDiag(RHS);
          return null;
        }
      }
      
      // Truncate the lvalue to the appropriate derived class.
      if (!CastToDerivedClass(Info, RHS, LV, MemPtr.getContainingRecord(), 
          PathLengthToMember)) {
        return null;
      }
    } else if (!MemPtr.Path.empty()) {
      // Extend the LValue path with the member pointer's path.
      LV.Designator.Entries.reserve(LV.Designator.Entries.size()
             + MemPtr.Path.size() + (IncludeMember ? 1 : 0));
      {
        
        // Walk down to the appropriate base class.
        /*const*/ PointerType /*P*/ PT = LVType.$arrow().getAs(PointerType.class);
        if ((PT != null)) {
          LVType.$assignMove(PT.getPointeeType());
        }
      }
      /*const*/ CXXRecordDecl /*P*/ RD = LVType.$arrow().getAsCXXRecordDecl();
      assert ((RD != null)) : "member pointer access on non-class-type expression";
      // The first class in the path is that of the lvalue.
      for (/*uint*/int I = 1, N = MemPtr.Path.size(); I != N; ++I) {
        /*const*/ CXXRecordDecl /*P*/ Base = MemPtr.Path.$at(N - I - 1);
        if (!HandleLValueDirectBase(Info, RHS, LV, RD, Base)) {
          return null;
        }
        RD = Base;
      }
      // Finally cast to the class containing the member.
      if (!HandleLValueDirectBase(Info, RHS, LV, RD, 
          MemPtr.getContainingRecord())) {
        return null;
      }
    }
    
    // Add the member. Note that we cannot build bound member functions here.
    if (IncludeMember) {
      {
        /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(MemPtr.getDecl());
        if ((FD != null)) {
          if (!HandleLValueMember(Info, RHS, LV, FD)) {
            return null;
          }
        } else {
          /*const*/ IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(MemPtr.getDecl());
          if ((IFD != null)) {
            if (!HandleLValueIndirectMember(Info, RHS, LV, IFD)) {
              return null;
            }
          } else {
            throw new llvm_unreachable("can't construct reference to bound member function");
          }
        }
      }
    }
    
    return MemPtr.getDecl();
  } finally {
    if (MemPtr != null) { MemPtr.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="HandleMemberPointerAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3315,
 FQN="HandleMemberPointerAccess", NM="_ZL25HandleMemberPointerAccessRN12_GLOBAL__N_18EvalInfoEPKN5clang14BinaryOperatorERNS_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL25HandleMemberPointerAccessRN12_GLOBAL__N_18EvalInfoEPKN5clang14BinaryOperatorERNS_6LValueEb")
//</editor-fold>
public static /*const*/ ValueDecl /*P*/ HandleMemberPointerAccess(final EvalInfo /*&*/ Info, 
                         /*const*/ BinaryOperator /*P*/ BO, 
                         final LValue /*&*/ LV) {
  return HandleMemberPointerAccess(Info, 
                         BO, 
                         LV, 
                         true);
}
public static /*const*/ ValueDecl /*P*/ HandleMemberPointerAccess(final EvalInfo /*&*/ Info, 
                         /*const*/ BinaryOperator /*P*/ BO, 
                         final LValue /*&*/ LV, 
                         boolean IncludeMember/*= true*/) {
  assert (BO.getOpcode() == BinaryOperatorKind.BO_PtrMemD || BO.getOpcode() == BinaryOperatorKind.BO_PtrMemI);
  if (!EvaluateObjectArgument(Info, BO.getLHS(), LV)) {
    if (Info.noteFailure()) {
      MemberPtr MemPtr = null;
      try {
        MemPtr/*J*/= new MemberPtr();
        EvaluateMemberPointer(BO.getRHS(), MemPtr, Info);
      } finally {
        if (MemPtr != null) { MemPtr.$destroy(); }
      }
    }
    return null;
  }
  
  return HandleMemberPointerAccess(Info, BO.getLHS().getType(), LV, 
      BO.getRHS(), IncludeMember);
}


/// HandleBaseToDerivedCast - Apply the given base-to-derived cast operation on
/// the provided lvalue, which currently refers to the base object.
//<editor-fold defaultstate="collapsed" desc="HandleBaseToDerivedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3335,
 FQN="HandleBaseToDerivedCast", NM="_ZL23HandleBaseToDerivedCastRN12_GLOBAL__N_18EvalInfoEPKN5clang8CastExprERNS_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL23HandleBaseToDerivedCastRN12_GLOBAL__N_18EvalInfoEPKN5clang8CastExprERNS_6LValueE")
//</editor-fold>
public static boolean HandleBaseToDerivedCast(final EvalInfo /*&*/ Info, /*const*/ CastExpr /*P*/ E, 
                       final LValue /*&*/ Result) {
  final SubobjectDesignator /*&*/ D = Result.Designator;
  if (D.Invalid || !Result.checkNullPointer(Info, E, CheckSubobjectKind.CSK_Derived)) {
    return false;
  }
  
  QualType TargetQT = E.getType();
  {
    /*const*/ PointerType /*P*/ PT = TargetQT.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      TargetQT.$assignMove(PT.getPointeeType());
    }
  }
  
  // Check this cast lands within the final derived-to-base subobject path.
  if ($greater_uint(D.MostDerivedPathLength + E.path_size(), D.Entries.size())) {
    Info.CCEDiag(E, diag.note_constexpr_invalid_downcast).$out$T(
        D.MostDerivedType
    ).$out$T(TargetQT);
    return false;
  }
  
  // Check the type of the final cast. We don't need to check the path,
  // since a cast can only be formed if the path is unique.
  /*uint*/int NewEntriesSize = D.Entries.size() - E.path_size();
  /*const*/ CXXRecordDecl /*P*/ TargetType = TargetQT.$arrow().getAsCXXRecordDecl();
  /*const*/ CXXRecordDecl /*P*/ FinalType;
  if (NewEntriesSize == D.MostDerivedPathLength) {
    FinalType = D.MostDerivedType.$arrow().getAsCXXRecordDecl();
  } else {
    FinalType = getAsBaseClass(new APValue.LValuePathEntry(D.Entries.$at(NewEntriesSize - 1)));
  }
  if (FinalType.getCanonicalDecl$Const() != TargetType.getCanonicalDecl$Const()) {
    Info.CCEDiag(E, diag.note_constexpr_invalid_downcast).$out$T(
        D.MostDerivedType
    ).$out$T(TargetQT);
    return false;
  }
  
  // Truncate the lvalue to the appropriate derived class.
  return CastToDerivedClass(Info, E, Result, TargetType, NewEntriesSize);
}

//<editor-fold defaultstate="collapsed" desc="EvaluateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3388,
 FQN="EvaluateDecl", NM="_ZL12EvaluateDeclRN12_GLOBAL__N_18EvalInfoEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12EvaluateDeclRN12_GLOBAL__N_18EvalInfoEPKN5clang4DeclE")
//</editor-fold>
public static boolean EvaluateDecl(final EvalInfo /*&*/ Info, /*const*/ Decl /*P*/ D) {
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      LValue Result = null;
      try {
        // We don't need to evaluate the initializer for a static local.
        if (!VD.hasLocalStorage()) {
          return true;
        }
        
        Result/*J*/= new LValue();
        Result.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T.INSTANCE, /*const*/ ValueDecl /*P*/ .class, VD), Info.CurrentCall.Index);
        final APValue /*&*/ Val = Info.CurrentCall.createTemporary(VD, true);
        
        /*const*/ Expr /*P*/ InitE = VD.getInit$Const();
        if (!(InitE != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Info.FFDiag(D.getLocStart(), diag.note_constexpr_uninitialized).$out_bool(
                false
            ).$out$T(VD.getType());
            $c$.clean(Val.$assign($c$.track(new APValue())));
            return false;
          } finally {
            $c$.$destroy();
          }
        }
        if (InitE.isValueDependent()) {
          return false;
        }
        if (!EvaluateInPlace(Val, Info, Result, InitE)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Wipe out any partially-computed value, to allow tracking that this
            // evaluation failed.
            $c$.clean(Val.$assign($c$.track(new APValue())));
            return false;
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (Result != null) { Result.$destroy(); }
      }
    }
  }
  
  return true;
}


/// Evaluate a condition (either a variable declaration or an expression).
//<editor-fold defaultstate="collapsed" desc="EvaluateCond">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3421,
 FQN="EvaluateCond", NM="_ZL12EvaluateCondRN12_GLOBAL__N_18EvalInfoEPKN5clang7VarDeclEPKNS2_4ExprERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12EvaluateCondRN12_GLOBAL__N_18EvalInfoEPKN5clang7VarDeclEPKNS2_4ExprERb")
//</editor-fold>
public static boolean EvaluateCond(final EvalInfo /*&*/ Info, /*const*/ VarDecl /*P*/ CondDecl, 
            /*const*/ Expr /*P*/ Cond, final bool$ref/*bool &*/ Result) {
  ScopeRAII Scope = null;
  try {
    Scope/*J*/= new ScopeRAII(true, Info);
    if ((CondDecl != null) && !EvaluateDecl(Info, CondDecl)) {
      return false;
    }
    return EvaluateAsBooleanCondition(Cond, Result, Info);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


// Evaluate a statement.
//<editor-fold defaultstate="collapsed" desc="EvaluateStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3526,
 FQN="EvaluateStmt", NM="_ZL12EvaluateStmtRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang4StmtEPKNS4_10SwitchCaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12EvaluateStmtRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang4StmtEPKNS4_10SwitchCaseE")
//</editor-fold>
public static EvalStmtResult EvaluateStmt(final StmtResult /*&*/ Result, final EvalInfo /*&*/ Info, 
            /*const*/ Stmt /*P*/ S) {
  return EvaluateStmt(Result, Info, 
            S, (/*const*/ SwitchCase /*P*/ )null);
}
public static EvalStmtResult EvaluateStmt(final StmtResult /*&*/ Result, final EvalInfo /*&*/ Info, 
            /*const*/ Stmt /*P*/ S, /*const*/ SwitchCase /*P*/ Case/*= null*/) {
  if (!Info.nextStep(S)) {
    return EvalStmtResult.ESR_Failed;
  }
  
  // If we're hunting down a 'case' or 'default' label, recurse through
  // substatements until we hit the label.
  if ((Case != null)) {
    // FIXME: We don't start the lifetime of objects whose initialization we
    // jump over. However, such objects must be of class type with a trivial
    // default constructor that initialize all subobjects, so must be empty,
    // so this almost never matters.
    switch (S.getStmtClass()) {
     case CompoundStmtClass:
     case LabelStmtClass:
     case AttributedStmtClass:
     case DoStmtClass:
      // FIXME: Precompute which substatement of a compound statement we
      // would jump to, and go straight there rather than performing a
      // linear scan each time.
      break;
     case CaseStmtClass:
     case DefaultStmtClass:
      if (Case == S) {
        Case = null;
      }
      break;
     case IfStmtClass:
      {
        ScopeRAII Scope = null;
        try {
          // FIXME: Precompute which side of an 'if' we would jump to, and go
          // straight there rather than scanning both sides.
          /*const*/ IfStmt /*P*/ IS = cast_IfStmt(S);
          
          // Wrap the evaluation in a block scope, in case it's a DeclStmt
          // preceded by our switch label.
          Scope/*J*/= new ScopeRAII(false, Info);
          
          EvalStmtResult ESR = EvaluateStmt(Result, Info, IS.getThen$Const(), Case);
          if (ESR != EvalStmtResult.ESR_CaseNotFound || !(IS.getElse$Const() != null)) {
            return ESR;
          }
          return EvaluateStmt(Result, Info, IS.getElse$Const(), Case);
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
     case WhileStmtClass:
      {
        EvalStmtResult ESR = EvaluateLoopBody(Result, Info, cast_WhileStmt(S).getBody$Const(), Case);
        if (ESR != EvalStmtResult.ESR_Continue) {
          return ESR;
        }
        break;
      }
     case ForStmtClass:
      {
        /*const*/ ForStmt /*P*/ FS = cast_ForStmt(S);
        EvalStmtResult ESR = EvaluateLoopBody(Result, Info, FS.getBody$Const(), Case);
        if (ESR != EvalStmtResult.ESR_Continue) {
          return ESR;
        }
        if ((FS.getInc$Const() != null)) {
          ScopeRAII IncScope = null;
          try {
            IncScope/*J*/= new ScopeRAII(true, Info);
            if (!EvaluateIgnoredValue(Info, FS.getInc$Const())) {
              return EvalStmtResult.ESR_Failed;
            }
          } finally {
            if (IncScope != null) { IncScope.$destroy(); }
          }
        }
        break;
      }
     case DeclStmtClass:
     default:
      // FIXME: If the variable has initialization that can't be jumped over,
      // bail out of any immediately-surrounding compound-statement too.
      return EvalStmtResult.ESR_CaseNotFound;
    }
  }
  switch (S.getStmtClass()) {
   default:
    {
      /*const*/ Expr /*P*/ E = dyn_cast_Expr(S);
      if ((E != null)) {
        ScopeRAII Scope = null;
        try {
          // Don't bother evaluating beyond an expression-statement which couldn't
          // be evaluated.
          Scope/*J*/= new ScopeRAII(true, Info);
          if (!EvaluateIgnoredValue(Info, E)) {
            return EvalStmtResult.ESR_Failed;
          }
          return EvalStmtResult.ESR_Succeeded;
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
    }
    
    Info.FFDiag(S.getLocStart());
    return EvalStmtResult.ESR_Failed;
   case NullStmtClass:
    return EvalStmtResult.ESR_Succeeded;
   case DeclStmtClass:
    {
      /*const*/ DeclStmt /*P*/ DS = cast_DeclStmt(S);
      for (/*const*/ Decl /*P*/ DclIt : DS.decls$Const()) {
        ScopeRAII Scope = null;
        try {
          // Each declaration initialization is its own full-expression.
          // FIXME: This isn't quite right; if we're performing aggregate
          // initialization, each braced subexpression is its own full-expression.
          Scope/*J*/= new ScopeRAII(true, Info);
          if (!EvaluateDecl(Info, DclIt) && !Info.noteFailure()) {
            return EvalStmtResult.ESR_Failed;
          }
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
      return EvalStmtResult.ESR_Succeeded;
    }
   case ReturnStmtClass:
    {
      ScopeRAII Scope = null;
      try {
        /*const*/ Expr /*P*/ RetExpr = cast_ReturnStmt(S).getRetValue$Const();
        Scope/*J*/= new ScopeRAII(true, Info);
        if ((RetExpr != null)
           && !((Result.Slot != null) ? EvaluateInPlace(Result.Value, Info, $Deref(Result.Slot), RetExpr) : Evaluate(Result.Value, Info, RetExpr))) {
          return EvalStmtResult.ESR_Failed;
        }
        return EvalStmtResult.ESR_Returned;
      } finally {
        if (Scope != null) { Scope.$destroy(); }
      }
    }
   case CompoundStmtClass:
    {
      ScopeRAII Scope = null;
      try {
        Scope/*J*/= new ScopeRAII(false, Info);
        
        /*const*/ CompoundStmt /*P*/ CS = cast_CompoundStmt(S);
        for (/*const*/ Stmt /*P*/ BI : CS.body$Const()) {
          EvalStmtResult ESR = EvaluateStmt(Result, Info, BI, Case);
          if (ESR == EvalStmtResult.ESR_Succeeded) {
            Case = null;
          } else if (ESR != EvalStmtResult.ESR_CaseNotFound) {
            return ESR;
          }
        }
        return (Case != null) ? EvalStmtResult.ESR_CaseNotFound : EvalStmtResult.ESR_Succeeded;
      } finally {
        if (Scope != null) { Scope.$destroy(); }
      }
    }
   case IfStmtClass:
    {
      ScopeRAII Scope = null;
      try {
        /*const*/ IfStmt /*P*/ IS = cast_IfStmt(S);
        
        // Evaluate the condition, as either a var decl or as an expression.
        Scope/*J*/= new ScopeRAII(false, Info);
        {
          /*const*/ Stmt /*P*/ Init = IS.getInit$Const();
          if ((Init != null)) {
            EvalStmtResult ESR = EvaluateStmt(Result, Info, Init);
            if (ESR != EvalStmtResult.ESR_Succeeded) {
              return ESR;
            }
          }
        }
        bool$ref Cond = create_bool$ref();
        if (!EvaluateCond(Info, IS.getConditionVariable(), IS.getCond$Const(), Cond)) {
          return EvalStmtResult.ESR_Failed;
        }
        {
          
          /*const*/ Stmt /*P*/ SubStmt = Cond.$deref() ? IS.getThen$Const() : IS.getElse$Const();
          if ((SubStmt != null)) {
            EvalStmtResult ESR = EvaluateStmt(Result, Info, SubStmt);
            if (ESR != EvalStmtResult.ESR_Succeeded) {
              return ESR;
            }
          }
        }
        return EvalStmtResult.ESR_Succeeded;
      } finally {
        if (Scope != null) { Scope.$destroy(); }
      }
    }
   case WhileStmtClass:
    {
      /*const*/ WhileStmt /*P*/ WS = cast_WhileStmt(S);
      while (true) {
        ScopeRAII Scope = null;
        try {
          Scope/*J*/= new ScopeRAII(false, Info);
          bool$ref Continue = create_bool$ref();
          if (!EvaluateCond(Info, WS.getConditionVariable(), WS.getCond$Const(), 
              Continue)) {
            return EvalStmtResult.ESR_Failed;
          }
          if (!Continue.$deref()) {
            break;
          }
          
          EvalStmtResult ESR = EvaluateLoopBody(Result, Info, WS.getBody$Const());
          if (ESR != EvalStmtResult.ESR_Continue) {
            return ESR;
          }
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
      return EvalStmtResult.ESR_Succeeded;
    }
   case DoStmtClass:
    {
      /*const*/ DoStmt /*P*/ DS = cast_DoStmt(S);
      bool$ref Continue = create_bool$ref();
      do {
        ScopeRAII CondScope = null;
        try {
          EvalStmtResult ESR = EvaluateLoopBody(Result, Info, DS.getBody$Const(), Case);
          if (ESR != EvalStmtResult.ESR_Continue) {
            return ESR;
          }
          Case = null;
          
          CondScope/*J*/= new ScopeRAII(true, Info);
          if (!EvaluateAsBooleanCondition(DS.getCond$Const(), Continue, Info)) {
            return EvalStmtResult.ESR_Failed;
          }
        } finally {
          if (CondScope != null) { CondScope.$destroy(); }
        }
      } while (Continue.$deref());
      return EvalStmtResult.ESR_Succeeded;
    }
   case ForStmtClass:
    {
      ScopeRAII Scope = null;
      try {
        /*const*/ ForStmt /*P*/ FS = cast_ForStmt(S);
        Scope/*J*/= new ScopeRAII(false, Info);
        if ((FS.getInit$Const() != null)) {
          EvalStmtResult ESR = EvaluateStmt(Result, Info, FS.getInit$Const());
          if (ESR != EvalStmtResult.ESR_Succeeded) {
            return ESR;
          }
        }
        while (true) {
          ScopeRAII Scope$1 = null;
          try {
            Scope$1/*J*/= new ScopeRAII(false, Info);
            bool$ref Continue = create_bool$ref(true);
            if ((FS.getCond$Const() != null) && !EvaluateCond(Info, FS.getConditionVariable(), 
                FS.getCond$Const(), Continue)) {
              return EvalStmtResult.ESR_Failed;
            }
            if (!Continue.$deref()) {
              break;
            }
            
            EvalStmtResult ESR = EvaluateLoopBody(Result, Info, FS.getBody$Const());
            if (ESR != EvalStmtResult.ESR_Continue) {
              return ESR;
            }
            if ((FS.getInc$Const() != null)) {
              ScopeRAII IncScope = null;
              try {
                IncScope/*J*/= new ScopeRAII(true, Info);
                if (!EvaluateIgnoredValue(Info, FS.getInc$Const())) {
                  return EvalStmtResult.ESR_Failed;
                }
              } finally {
                if (IncScope != null) { IncScope.$destroy(); }
              }
            }
          } finally {
            if (Scope$1 != null) { Scope$1.$destroy(); }
          }
        }
        return EvalStmtResult.ESR_Succeeded;
      } finally {
        if (Scope != null) { Scope.$destroy(); }
      }
    }
   case CXXForRangeStmtClass:
    {
      ScopeRAII Scope = null;
      try {
        /*const*/ CXXForRangeStmt /*P*/ FS = cast_CXXForRangeStmt(S);
        Scope/*J*/= new ScopeRAII(false, Info);
        
        // Initialize the __range variable.
        EvalStmtResult ESR = EvaluateStmt(Result, Info, FS.getRangeStmt$Const());
        if (ESR != EvalStmtResult.ESR_Succeeded) {
          return ESR;
        }
        
        // Create the __begin and __end iterators.
        ESR = EvaluateStmt(Result, Info, FS.getBeginStmt$Const());
        if (ESR != EvalStmtResult.ESR_Succeeded) {
          return ESR;
        }
        ESR = EvaluateStmt(Result, Info, FS.getEndStmt$Const());
        if (ESR != EvalStmtResult.ESR_Succeeded) {
          return ESR;
        }
        while (true) {
          ScopeRAII InnerScope = null;
          try {
            {
              ScopeRAII CondExpr = null;
              try {
                bool$ref Continue = create_bool$ref(true);
                CondExpr/*J*/= new ScopeRAII(true, Info);
                if (!EvaluateAsBooleanCondition(FS.getCond$Const(), Continue, Info)) {
                  return EvalStmtResult.ESR_Failed;
                }
                if (!Continue.$deref()) {
                  break;
                }
              } finally {
                if (CondExpr != null) { CondExpr.$destroy(); }
              }
            }
            
            // User's variable declaration, initialized by *__begin.
            InnerScope/*J*/= new ScopeRAII(false, Info);
            ESR = EvaluateStmt(Result, Info, FS.getLoopVarStmt$Const());
            if (ESR != EvalStmtResult.ESR_Succeeded) {
              return ESR;
            }
            
            // Loop body.
            ESR = EvaluateLoopBody(Result, Info, FS.getBody$Const());
            if (ESR != EvalStmtResult.ESR_Continue) {
              return ESR;
            }
            
            // Increment: ++__begin
            if (!EvaluateIgnoredValue(Info, FS.getInc$Const())) {
              return EvalStmtResult.ESR_Failed;
            }
          } finally {
            if (InnerScope != null) { InnerScope.$destroy(); }
          }
        }
        
        return EvalStmtResult.ESR_Succeeded;
      } finally {
        if (Scope != null) { Scope.$destroy(); }
      }
    }
   case SwitchStmtClass:
    return EvaluateSwitch(Result, Info, cast_SwitchStmt(S));
   case ContinueStmtClass:
    return EvalStmtResult.ESR_Continue;
   case BreakStmtClass:
    return EvalStmtResult.ESR_Break;
   case LabelStmtClass:
    return EvaluateStmt(Result, Info, cast_LabelStmt(S).getSubStmt$Const(), Case);
   case AttributedStmtClass:
    // As a general principle, C++11 attributes can be ignored without
    // any semantic impact.
    return EvaluateStmt(Result, Info, cast_AttributedStmt(S).getSubStmt$Const(), 
        Case);
   case CaseStmtClass:
   case DefaultStmtClass:
    return EvaluateStmt(Result, Info, cast_SwitchCase(S).getSubStmt$Const(), Case);
  }
}


/// Evaluate the body of a loop, and translate the result as appropriate.
//<editor-fold defaultstate="collapsed" desc="EvaluateLoopBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3445,
 FQN="EvaluateLoopBody", NM="_ZL16EvaluateLoopBodyRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang4StmtEPKNS4_10SwitchCaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL16EvaluateLoopBodyRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang4StmtEPKNS4_10SwitchCaseE")
//</editor-fold>
public static EvalStmtResult EvaluateLoopBody(final StmtResult /*&*/ Result, final EvalInfo /*&*/ Info, 
                /*const*/ Stmt /*P*/ Body) {
  return EvaluateLoopBody(Result, Info, 
                Body, 
                (/*const*/ SwitchCase /*P*/ )null);
}
public static EvalStmtResult EvaluateLoopBody(final StmtResult /*&*/ Result, final EvalInfo /*&*/ Info, 
                /*const*/ Stmt /*P*/ Body, 
                /*const*/ SwitchCase /*P*/ Case/*= null*/) {
  ScopeRAII Scope = null;
  try {
    Scope/*J*/= new ScopeRAII(false, Info);
    {
      EvalStmtResult ESR = EvaluateStmt(Result, Info, Body, Case);
      switch (ESR) {
       case ESR_Break:
        return EvalStmtResult.ESR_Succeeded;
       case ESR_Succeeded:
       case ESR_Continue:
        return EvalStmtResult.ESR_Continue;
       case ESR_Failed:
       case ESR_Returned:
       case ESR_CaseNotFound:
        return ESR;
      }
    }
    throw new llvm_unreachable("Invalid EvalStmtResult!");
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// Evaluate a switch statement.
//<editor-fold defaultstate="collapsed" desc="EvaluateSwitch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3464,
 FQN="EvaluateSwitch", NM="_ZL14EvaluateSwitchRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang10SwitchStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14EvaluateSwitchRN12_GLOBAL__N_110StmtResultERNS_8EvalInfoEPKN5clang10SwitchStmtE")
//</editor-fold>
public static EvalStmtResult EvaluateSwitch(final StmtResult /*&*/ Result, final EvalInfo /*&*/ Info, 
              /*const*/ SwitchStmt /*P*/ SS) {
  ScopeRAII Scope = null;
  try {
    Scope/*J*/= new ScopeRAII(false, Info);
    
    // Evaluate the switch condition.
    APSInt Value/*J*/= new APSInt();
    {
      ScopeRAII Scope$1 = null;
      try {
        Scope$1/*J*/= new ScopeRAII(true, Info);
        {
          /*const*/ Stmt /*P*/ Init = SS.getInit$Const();
          if ((Init != null)) {
            EvalStmtResult ESR = EvaluateStmt(Result, Info, Init);
            if (ESR != EvalStmtResult.ESR_Succeeded) {
              return ESR;
            }
          }
        }
        if ((SS.getConditionVariable() != null)
           && !EvaluateDecl(Info, SS.getConditionVariable())) {
          return EvalStmtResult.ESR_Failed;
        }
        if (!EvaluateInteger(SS.getCond$Const(), Value, Info)) {
          return EvalStmtResult.ESR_Failed;
        }
      } finally {
        if (Scope$1 != null) { Scope$1.$destroy(); }
      }
    }
    
    // Find the switch case corresponding to the value of the condition.
    // FIXME: Cache this lookup.
    /*const*/ SwitchCase /*P*/ Found = null;
    for (/*const*/ SwitchCase /*P*/ SC = SS.getSwitchCaseList$Const(); (SC != null);
         SC = SC.getNextSwitchCase$Const()) {
      if (isa_DefaultStmt(SC)) {
        Found = SC;
        continue;
      }
      
      /*const*/ CaseStmt /*P*/ CS = cast_CaseStmt(SC);
      APSInt LHS = CS.getLHS$Const().EvaluateKnownConstInt(Info.Ctx);
      APSInt RHS = (CS.getRHS$Const() != null) ? CS.getRHS$Const().EvaluateKnownConstInt(Info.Ctx) : new APSInt(LHS);
      if (LHS.$lesseq(Value) && Value.$lesseq(RHS)) {
        Found = SC;
        break;
      }
    }
    if (!(Found != null)) {
      return EvalStmtResult.ESR_Succeeded;
    }
    {
      
      // Search the switch body for the switch case and evaluate it from there.
      EvalStmtResult ESR = EvaluateStmt(Result, Info, SS.getBody$Const(), Found);
      switch (ESR) {
       case ESR_Break:
        return EvalStmtResult.ESR_Succeeded;
       case ESR_Succeeded:
       case ESR_Continue:
       case ESR_Failed:
       case ESR_Returned:
        return ESR;
       case ESR_CaseNotFound:
        // This can only happen if the switch case is nested within a statement
        // expression. We have no intention of supporting that.
        Info.FFDiag(Found.getLocStart(), diag.note_constexpr_stmt_expr_unsupported);
        return EvalStmtResult.ESR_Failed;
      }
    }
    throw new llvm_unreachable("Invalid EvalStmtResult!");
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// CheckTrivialDefaultConstructor - Check whether a constructor is a trivial
/// default constructor. If so, we'll fold it whether or not it's marked as
/// constexpr. If it is marked as constexpr, we will never implicitly define it,
/// so we need special handling.
//<editor-fold defaultstate="collapsed" desc="CheckTrivialDefaultConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3815,
 FQN="CheckTrivialDefaultConstructor", NM="_ZL30CheckTrivialDefaultConstructorRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationEPKNS2_18CXXConstructorDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL30CheckTrivialDefaultConstructorRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationEPKNS2_18CXXConstructorDeclEb")
//</editor-fold>
public static boolean CheckTrivialDefaultConstructor(final EvalInfo /*&*/ Info, SourceLocation Loc, 
                              /*const*/ CXXConstructorDecl /*P*/ CD, 
                              boolean IsValueInitialization) {
  if (!CD.isTrivial() || !CD.isDefaultConstructor()) {
    return false;
  }
  
  // Value-initialization does not call a trivial default constructor, so such a
  // call is a core constant expression whether or not the constructor is
  // constexpr.
  if (!CD.isConstexpr() && !IsValueInitialization) {
    if (Info.getLangOpts().CPlusPlus11) {
      // FIXME: If DiagDecl is an implicitly-declared special member function,
      // we should be much more explicit about why it's not constexpr.
      Info.CCEDiag(new SourceLocation(Loc), diag.note_constexpr_invalid_function, 1).$out_int(/*IsConstexpr*/ 
          0
      ).$out_int(/*IsConstructor*/ 1).$out$T(CD);
      Info.Note(CD.getLocation(), diag.note_declared_at);
    } else {
      Info.CCEDiag(new SourceLocation(Loc), diag.note_invalid_subexpr_in_const_expr);
    }
  }
  return true;
}


/// CheckConstexprFunction - Check that a function can be called in a constant
/// expression.
//<editor-fold defaultstate="collapsed" desc="CheckConstexprFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3840,
 FQN="CheckConstexprFunction", NM="_ZL22CheckConstexprFunctionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationEPKNS2_12FunctionDeclES6_PKNS2_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22CheckConstexprFunctionRN12_GLOBAL__N_18EvalInfoEN5clang14SourceLocationEPKNS2_12FunctionDeclES6_PKNS2_4StmtE")
//</editor-fold>
public static boolean CheckConstexprFunction(final EvalInfo /*&*/ Info, SourceLocation CallLoc, 
                      /*const*/ FunctionDecl /*P*/ Declaration, 
                      /*const*/ FunctionDecl /*P*/ Definition, 
                      /*const*/ Stmt /*P*/ Body) {
  // Potential constant expressions can contain calls to declared, but not yet
  // defined, constexpr functions.
  if (Info.checkingPotentialConstantExpression() && !(Definition != null)
     && Declaration.isConstexpr()) {
    return false;
  }
  
  // Bail out with no diagnostic if the function declaration itself is invalid.
  // We will have produced a relevant diagnostic while parsing it.
  if (Declaration.isInvalidDecl()) {
    return false;
  }
  
  // Can we evaluate this function call?
  if ((Definition != null) && Definition.isConstexpr()
     && !Definition.isInvalidDecl() && (Body != null)) {
    return true;
  }
  if (Info.getLangOpts().CPlusPlus11) {
    /*const*/ FunctionDecl /*P*/ DiagDecl = (Definition != null) ? Definition : Declaration;
    
    // If this function is not constexpr because it is an inherited
    // non-constexpr constructor, diagnose that directly.
    /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(DiagDecl);
    if ((CD != null) && CD.isInheritingConstructor()) {
      CXXConstructorDecl /*P*/ Inherited = CD.getInheritedConstructor().getConstructor();
      if (!Inherited.isConstexpr()) {
        DiagDecl = CD = Inherited;
      }
    }
    
    // FIXME: If DiagDecl is an implicitly-declared special member function
    // or an inheriting constructor, we should be much more explicit about why
    // it's not constexpr.
    if ((CD != null) && CD.isInheritingConstructor()) {
      Info.FFDiag(new SourceLocation(CallLoc), diag.note_constexpr_invalid_inhctor, 1).$out$T(
          CD.getInheritedConstructor().getConstructor().getParent()
      );
    } else {
      Info.FFDiag(new SourceLocation(CallLoc), diag.note_constexpr_invalid_function, 1).$out_bool(
          DiagDecl.isConstexpr()
      ).$out_bool((boolean)(CD != null)).$out$T(DiagDecl);
    }
    Info.Note(DiagDecl.getLocation(), diag.note_declared_at);
  } else {
    Info.FFDiag(new SourceLocation(CallLoc), diag.note_invalid_subexpr_in_const_expr);
  }
  return false;
}


/// Determine if a class has any fields that might need to be copied by a
/// trivial copy or move operation.
//<editor-fold defaultstate="collapsed" desc="hasFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3890,
 FQN="hasFields", NM="_ZL9hasFieldsPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL9hasFieldsPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static boolean hasFields(/*const*/ CXXRecordDecl /*P*/ RD) {
  if (!(RD != null) || RD.isEmpty()) {
    return false;
  }
  for (FieldDecl /*P*/ FD : RD.fields()) {
    if (FD.isUnnamedBitfield()) {
      continue;
    }
    return true;
  }
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const())  {
    if (hasFields(Base.getType().$arrow().getAsCXXRecordDecl())) {
      return true;
    }
  }
  return false;
}


/// EvaluateArgs - Evaluate the arguments to a function call.
//<editor-fold defaultstate="collapsed" desc="EvaluateArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3909,
 FQN="EvaluateArgs", NM="_ZL12EvaluateArgsN4llvm8ArrayRefIPKN5clang4ExprEEERNS_11SmallVectorINS1_7APValueELj8EEERN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12EvaluateArgsN4llvm8ArrayRefIPKN5clang4ExprEEERNS_11SmallVectorINS1_7APValueELj8EEERN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public static boolean EvaluateArgs(ArrayRef</*const*/ Expr /*P*/ > Args, final SmallVector<APValue> /*&*/ ArgValues, 
            final EvalInfo /*&*/ Info) {
  boolean Success = true;
  for (type$ptr<Expr/*P*/>/*iterator*/ I = $tryClone(Args.begin()), /*P*/ E = $tryClone(Args.end());
       $noteq_ptr(I, E); I.$preInc()) {
    if (!Evaluate(ArgValues.$at(I.$sub(Args.begin())), Info, I.$star())) {
      // If we're checking for a potential constant expression, evaluate all
      // initializers even if some of them fail.
      if (!Info.noteFailure()) {
        return false;
      }
      Success = false;
    }
  }
  return Success;
}


/// Evaluate a function call.
//<editor-fold defaultstate="collapsed" desc="HandleFunctionCall">
@Converted(kind = Converted.Kind.MANUAL/*invoke with default arg directly to help with some stackoverflow cases*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3926,
 FQN="HandleFunctionCall", NM="_ZL18HandleFunctionCallN5clang14SourceLocationEPKNS_12FunctionDeclEPKN12_GLOBAL__N_16LValueEN4llvm8ArrayRefIPKNS_4ExprEEEPKNS_4StmtERNS4_8EvalInfoERNS_7APValueES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL18HandleFunctionCallN5clang14SourceLocationEPKNS_12FunctionDeclEPKN12_GLOBAL__N_16LValueEN4llvm8ArrayRefIPKNS_4ExprEEEPKNS_4StmtERNS4_8EvalInfoERNS_7APValueES7_")
//</editor-fold>
public static boolean HandleFunctionCall(SourceLocation CallLoc, 
                  /*const*/ FunctionDecl /*P*/ Callee, /*const*/ LValue /*P*/ This, 
                  ArrayRef</*const*/ Expr /*P*/ > Args, /*const*/ Stmt /*P*/ Body, 
                  final EvalInfo /*&*/ Info, final APValue /*&*/ Result, 
                  /*const*/ LValue /*P*/ ResultSlot) {
  SmallVector<APValue> ArgValues = null;
  CallStackFrame Frame = null;
  try {
    ArgValues/*J*/= new SmallVector<APValue>(JD$UInt_T$C$R.INSTANCE, 8, Args.size(), new APValue());
    if (!EvaluateArgs(new ArrayRef</*const*/ Expr /*P*/ >(Args), ArgValues, Info)) {
      return false;
    }
    if (!Info.CheckCallLimit(new SourceLocation(CallLoc))) {
      return false;
    }
    
    Frame/*J*/= new CallStackFrame(Info, new SourceLocation(CallLoc), Callee, This, ArgValues.data());
    
    // For a trivial copy or move assignment, perform an APValue copy. This is
    // essential for unions, where the operations performed by the assignment
    // operator cannot be represented as statements.
    //
    // Skip this for non-union classes with no fields; in that case, the defaulted
    // copy/move does not actually read the object.
    /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(Callee);
    if ((MD != null) && MD.isDefaulted()
       && (MD.getParent$Const().isUnion()
       || (MD.isTrivial() && hasFields(MD.getParent$Const())))) {
      LValue RHS = null;
      APValue RHSValue = null;
      try {
        assert ((This != null) && (MD.isCopyAssignmentOperator() || MD.isMoveAssignmentOperator()));
        RHS/*J*/= new LValue();
        RHS.setFrom(Info.Ctx, ArgValues.$at(0));
        RHSValue/*J*/= new APValue();
        if (!handleLValueToRValueConversion(Info, Args.$at(0), Args.$at(0).getType(), 
            RHS, RHSValue)) {
          return false;
        }
        if (!handleAssignment(Info, Args.$at(0), $Deref(This), MD.getThisType(Info.Ctx), 
            RHSValue)) {
          return false;
        }
        This.moveInto(Result);
        return true;
      } finally {
        if (RHSValue != null) { RHSValue.$destroy(); }
        if (RHS != null) { RHS.$destroy(); }
      }
    }
    
    StmtResult Ret = new StmtResult(Result, ResultSlot);
    //JAVA: invoke with default arg directly to help with some stackoverflow cases
    EvalStmtResult ESR = EvaluateStmt(Ret, Info, Body, (/*const*/ SwitchCase /*P*/ )null);
    if (ESR == EvalStmtResult.ESR_Succeeded) {
      if (Callee.getReturnType().$arrow().isVoidType()) {
        return true;
      }
      Info.FFDiag(Callee.getLocEnd(), diag.note_constexpr_no_return);
    }
    return ESR == EvalStmtResult.ESR_Returned;
  } finally {
    if (Frame != null) { Frame.$destroy(); }
    if (ArgValues != null) { ArgValues.$destroy(); }
  }
}


/// Evaluate a constructor call.
//<editor-fold defaultstate="collapsed" desc="HandleConstructorCall">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3976,
 FQN="HandleConstructorCall", NM="_ZL21HandleConstructorCallPKN5clang4ExprERKN12_GLOBAL__N_16LValueEPNS_7APValueEPKNS_18CXXConstructorDeclERNS3_8EvalInfoERS7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL21HandleConstructorCallPKN5clang4ExprERKN12_GLOBAL__N_16LValueEPNS_7APValueEPKNS_18CXXConstructorDeclERNS3_8EvalInfoERS7_")
//</editor-fold>
public static boolean HandleConstructorCall(/*const*/ Expr /*P*/ E, final /*const*/ LValue /*&*/ This, 
                     type$ptr<APValue> /*P*/ ArgValues, 
                     /*const*/ CXXConstructorDecl /*P*/ Definition, 
                     final EvalInfo /*&*/ Info, final APValue /*&*/ Result) {
  CallStackFrame Frame = null;
  APValue RetVal = null;
  ScopeRAII LifetimeExtendedScope = null;
  try {
    SourceLocation CallLoc = E.getExprLoc();
    if (!Info.CheckCallLimit(new SourceLocation(CallLoc))) {
      return false;
    }
    
    /*const*/ CXXRecordDecl /*P*/ RD = Definition.getParent$Const();
    if ((RD.getNumVBases() != 0)) {
      Info.FFDiag(new SourceLocation(CallLoc), diag.note_constexpr_virtual_base).$out$T(RD);
      return false;
    }
    
    Frame/*J*/= new CallStackFrame(Info, new SourceLocation(CallLoc), Definition, $AddrOf(This), ArgValues);
    
    // FIXME: Creating an APValue just to hold a nonexistent return value is
    // wasteful.
    RetVal/*J*/= new APValue();
    StmtResult Ret = new StmtResult(RetVal, (/*const*/ LValue /*P*/ )null);
    
    // If it's a delegating constructor, delegate.
    if (Definition.isDelegatingConstructor()) {
      type$ptr<CXXCtorInitializer/*P*/> I = $tryClone(Definition.init_begin$Const());
      {
        ScopeRAII InitScope = null;
        try {
          InitScope/*J*/= new ScopeRAII(true, Info);
          if (!EvaluateInPlace(Result, Info, This, (I.$star()).getInit())) {
            return false;
          }
        } finally {
          if (InitScope != null) { InitScope.$destroy(); }
        }
      }
      return EvaluateStmt(Ret, Info, Definition.getBody()) != EvalStmtResult.ESR_Failed;
    }
    
    // For a trivial copy or move constructor, perform an APValue copy. This is
    // essential for unions (or classes with anonymous union members), where the
    // operations performed by the constructor cannot be represented by
    // ctor-initializers.
    //
    // Skip this for empty non-union classes; we should not perform an
    // lvalue-to-rvalue conversion on them because their copy constructor does not
    // actually read them.
    if (Definition.isDefaulted() && Definition.isCopyOrMoveConstructor()
       && (Definition.getParent$Const().isUnion()
       || (Definition.isTrivial() && hasFields(Definition.getParent$Const())))) {
      LValue RHS = null;
      try {
        RHS/*J*/= new LValue();
        RHS.setFrom(Info.Ctx, ArgValues.$at(0));
        return handleLValueToRValueConversion(Info, E, Definition.getParamDecl$Const(0).getType().getNonReferenceType(), 
            RHS, Result);
      } finally {
        if (RHS != null) { RHS.$destroy(); }
      }
    }
    
    // Reserve space for the struct members.
    if (!RD.isUnion() && Result.isUninit()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Result.$assign($c$.track(new APValue(new APValue.UninitStruct(), RD.getNumBases(), 
                std.distance(RD.field_begin(), RD.field_end())))));
      } finally {
        $c$.$destroy();
      }
    }
    if (RD.isInvalidDecl()) {
      return false;
    }
    final /*const*/ ASTRecordLayout /*&*/ Layout = Info.Ctx.getASTRecordLayout(RD);
    
    // A scope for temporaries lifetime-extended by reference members.
    LifetimeExtendedScope/*J*/= new ScopeRAII(false, Info);
    
    boolean Success = true;
    /*uint*/int BasesSeen = 0;
    type$ptr</*const*/ CXXBaseSpecifier /*P*/ > BaseIt = $tryClone(RD.bases_begin$Const());
    for (/*const*/ CXXCtorInitializer /*P*/ I : Definition.inits$Const()) {
      ScopeRAII InitScope = null;
      try {
        LValue Subobject = new LValue(This);
        APValue /*P*/ Value = $AddrOf(Result);
        
        // Determine the subobject to initialize.
        FieldDecl /*P*/ FD = null;
        if (I.isBaseInitializer()) {
          QualType BaseType/*J*/= new QualType(I.getBaseClass(), 0);
          // Non-virtual base classes are initialized in the order in the class
          // definition. We have already checked for virtual base classes.
          assert (!BaseIt./*->*/$star().isVirtual()) : "virtual base for literal type";
          assert (Info.Ctx.hasSameType(BaseIt./*->*/$star().getType(), new QualType(BaseType))) : "base class initializers not in expected order";
          BaseIt.$preInc();
          if (!HandleLValueDirectBase(Info, I.getInit(), Subobject, RD, 
              BaseType.$arrow().getAsCXXRecordDecl(), $AddrOf(Layout))) {
            return false;
          }
          Value = $AddrOf(Result.getStructBase(BasesSeen++));
        } else if (((FD = I.getMember()) != null)) {
          if (!HandleLValueMember(Info, I.getInit(), Subobject, FD, $AddrOf(Layout))) {
            return false;
          }
          if (RD.isUnion()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(Result.$assign($c$.track(new APValue(FD))));
              Value = $AddrOf(Result.getUnionValue());
            } finally {
              $c$.$destroy();
            }
          } else {
            Value = $AddrOf(Result.getStructField(FD.getFieldIndex()));
          }
        } else {
          IndirectFieldDecl /*P*/ IFD = I.getIndirectMember();
          if ((IFD != null)) {
            // Walk the indirect field decl's chain to find the object to initialize,
            // and make sure we've initialized every step along it.
            for (NamedDecl /*P*/ C : IFD.chain()) {
              FD = cast_FieldDecl(C);
              CXXRecordDecl /*P*/ CD = cast_CXXRecordDecl(FD.getParent());
              // Switch the union field if it differs. This happens if we had
              // preceding zero-initialization, and we're now initializing a union
              // subobject other than the first.
              // FIXME: In this case, the values of the other subobjects are
              // specified, since zero-initialization sets all padding bits to zero.
              if (Value.isUninit()
                 || (Value.isUnion() && Value.getUnionField() != FD)) {
                if (CD.isUnion()) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean(/*Deref*/Value.$assign($c$.track(new APValue(FD))));
                  } finally {
                    $c$.$destroy();
                  }
                } else {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean(/*Deref*/Value.$assign($c$.track(new APValue(new APValue.UninitStruct(), CD.getNumBases(), 
                            std.distance(CD.field_begin(), CD.field_end())))));
                  } finally {
                    $c$.$destroy();
                  }
                }
              }
              if (!HandleLValueMember(Info, I.getInit(), Subobject, FD)) {
                return false;
              }
              if (CD.isUnion()) {
                Value = $AddrOf(Value.getUnionValue());
              } else {
                Value = $AddrOf(Value.getStructField(FD.getFieldIndex()));
              }
            }
          } else {
            throw new llvm_unreachable("unknown base initializer kind");
          }
        }
        
        InitScope/*J*/= new ScopeRAII(true, Info);
        if (!EvaluateInPlace($Deref(Value), Info, Subobject, I.getInit())
           || ((FD != null) && FD.isBitField() && !truncateBitfieldValue(Info, I.getInit(), 
            $Deref(Value), FD))) {
          // If we're checking for a potential constant expression, evaluate all
          // initializers even if some of them fail.
          if (!Info.noteFailure()) {
            return false;
          }
          Success = false;
        }
      } finally {
        if (InitScope != null) { InitScope.$destroy(); }
      }
    }
    
    return Success
       && EvaluateStmt(Ret, Info, Definition.getBody()) != EvalStmtResult.ESR_Failed;
  } finally {
    if (LifetimeExtendedScope != null) { LifetimeExtendedScope.$destroy(); }
    if (RetVal != null) { RetVal.$destroy(); }
    if (Frame != null) { Frame.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="HandleConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4117,
 FQN="HandleConstructorCall", NM="_ZL21HandleConstructorCallPKN5clang4ExprERKN12_GLOBAL__N_16LValueEN4llvm8ArrayRefIS2_EEPKNS_18CXXConstructorDeclERNS3_8EvalInfoERNS_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL21HandleConstructorCallPKN5clang4ExprERKN12_GLOBAL__N_16LValueEN4llvm8ArrayRefIS2_EEPKNS_18CXXConstructorDeclERNS3_8EvalInfoERNS_7APValueE")
//</editor-fold>
public static boolean HandleConstructorCall(/*const*/ Expr /*P*/ E, final /*const*/ LValue /*&*/ This, 
                     ArrayRef</*const*/ Expr /*P*/ > Args, 
                     /*const*/ CXXConstructorDecl /*P*/ Definition, 
                     final EvalInfo /*&*/ Info, final APValue /*&*/ Result) {
  SmallVector<APValue> ArgValues = null;
  try {
    ArgValues/*J*/= new SmallVector<APValue>(JD$UInt_T$C$R.INSTANCE, 8, Args.size(), new APValue());
    if (!EvaluateArgs(new ArrayRef</*const*/ Expr /*P*/ >(Args), ArgValues, Info)) {
      return false;
    }
    
    return HandleConstructorCall(E, This, ArgValues.data(), Definition, 
        Info, Result);
  } finally {
    if (ArgValues != null) { ArgValues.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="GetAlignOfType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5193,
 FQN="GetAlignOfType", NM="_ZL14GetAlignOfTypeRN12_GLOBAL__N_18EvalInfoEN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14GetAlignOfTypeRN12_GLOBAL__N_18EvalInfoEN5clang8QualTypeE")
//</editor-fold>
public static CharUnits GetAlignOfType(final EvalInfo /*&*/ Info, QualType T) {
  {
    // C++ [expr.alignof]p3:
    //     When alignof is applied to a reference type, the result is the
    //     alignment of the referenced type.
    /*const*/ ReferenceType /*P*/ Ref = T.$arrow().getAs(ReferenceType.class);
    if ((Ref != null)) {
      T.$assignMove(Ref.getPointeeType());
    }
  }
  
  // __alignof is defined to return the preferred alignment.
  return Info.Ctx.toCharUnitsFromBits($uint2long(Info.Ctx.getPreferredTypeAlign(T.getTypePtr())));
}

//<editor-fold defaultstate="collapsed" desc="GetAlignOfExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5205,
 FQN="GetAlignOfExpr", NM="_ZL14GetAlignOfExprRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14GetAlignOfExprRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprE")
//</editor-fold>
public static CharUnits GetAlignOfExpr(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E) {
  E = E.IgnoreParens$Const();
  {
    
    // The kinds of expressions that we have special-case logic here for
    // should be kept up to date with the special checks for those
    // expressions in Sema.
    
    // alignof decl is always accepted, even if it doesn't make sense: we default
    // to 1 in those cases.
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      return Info.Ctx.getDeclAlign(DRE.getDecl$Const(), 
          /*RefAsPointee*/ true);
    }
  }
  {
    
    /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
    if ((ME != null)) {
      return Info.Ctx.getDeclAlign(ME.getMemberDecl(), 
          /*RefAsPointee*/ true);
    }
  }
  
  return GetAlignOfType(Info, E.getType());
}


/// Perform zero-initialization on an object of non-union class type.
/// C++11 [dcl.init]p5:
///  To zero-initialize an object or reference of type T means:
///    [...]
///    -- if T is a (possibly cv-qualified) non-union class type,
///       each non-static data member and each base-class subobject is
///       zero-initialized
//<editor-fold defaultstate="collapsed" desc="HandleClassZeroInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5434,
 FQN="HandleClassZeroInitialization", NM="_ZL29HandleClassZeroInitializationRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS2_10RecordDeclERKNS_6LValueERNS2_7APValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL29HandleClassZeroInitializationRN12_GLOBAL__N_18EvalInfoEPKN5clang4ExprEPKNS2_10RecordDeclERKNS_6LValueERNS2_7APValueE")
//</editor-fold>
public static boolean HandleClassZeroInitialization(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                             /*const*/ RecordDecl /*P*/ RD, 
                             final /*const*/ LValue /*&*/ This, final APValue /*&*/ Result) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (!RD.isUnion()) : "Expected non-union class type";
    /*const*/ CXXRecordDecl /*P*/ CD = dyn_cast_CXXRecordDecl(RD);
    $c$.clean(Result.$assign($c$.track(new APValue(new APValue.UninitStruct(), (CD != null) ? CD.getNumBases() : 0, 
            std.distance(RD.field_begin(), RD.field_end())))));
    if (RD.isInvalidDecl()) {
      return false;
    }
    final /*const*/ ASTRecordLayout /*&*/ Layout = Info.Ctx.getASTRecordLayout(RD);
    if ((CD != null)) {
      /*uint*/int Index = 0;
      for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > I = $tryClone(CD.bases_begin$Const()), 
          /*P*/ End = $tryClone(CD.bases_end$Const()); $noteq_ptr(I, End); I.$preInc() , ++Index) {
        /*const*/ CXXRecordDecl /*P*/ Base = I./*->*/$star().getType().$arrow().getAsCXXRecordDecl();
        LValue Subobject = new LValue(This);
        if (!HandleLValueDirectBase(Info, E, Subobject, CD, Base, $AddrOf(Layout))) {
          return false;
        }
        if (!HandleClassZeroInitialization(Info, E, Base, Subobject, 
            Result.getStructBase(Index))) {
          return false;
        }
      }
    }
    
    for (/*const*/ FieldDecl /*P*/ I : RD.fields()) {
      // -- if T is a reference type, no initialization is performed.
      if (I.getType().$arrow().isReferenceType()) {
        continue;
      }
      
      LValue Subobject = new LValue(This);
      if (!HandleLValueMember(Info, E, Subobject, I, $AddrOf(Layout))) {
        return false;
      }
      
      ImplicitValueInitExpr VIE/*J*/= new ImplicitValueInitExpr(I.getType());
      if (!EvaluateInPlace(Result.getStructField(I.getFieldIndex()), Info, Subobject, $AddrOf(VIE))) {
        return false;
      }
    }
    
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="EvaluateRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5752,
 FQN="EvaluateRecord", NM="_ZL14EvaluateRecordPKN5clang4ExprERKN12_GLOBAL__N_16LValueERNS_7APValueERNS3_8EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14EvaluateRecordPKN5clang4ExprERKN12_GLOBAL__N_16LValueERNS_7APValueERNS3_8EvalInfoE")
//</editor-fold>
public static boolean EvaluateRecord(/*const*/ Expr /*P*/ E, final /*const*/ LValue /*&*/ This, 
              final APValue /*&*/ Result, final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isRecordType()) : "can't evaluate expression as a record rvalue";
  return new RecordExprEvaluator(Info, This, Result).Visit(E);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="EvaluateVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5847,
 FQN="EvaluateVector", NM="_ZL14EvaluateVectorPKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14EvaluateVectorPKN5clang4ExprERNS_7APValueERN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public static boolean EvaluateVector(/*const*/ Expr /*P*/ E, final APValue /*&*/ Result, final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isVectorType()) : "not a vector rvalue";
  return new VectorExprEvaluator(Info, Result).Visit(E);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="EvaluateArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6040,
 FQN="EvaluateArray", NM="_ZL13EvaluateArrayPKN5clang4ExprERKN12_GLOBAL__N_16LValueERNS_7APValueERNS3_8EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL13EvaluateArrayPKN5clang4ExprERKN12_GLOBAL__N_16LValueERNS_7APValueERNS3_8EvalInfoE")
//</editor-fold>
public static boolean EvaluateArray(/*const*/ Expr /*P*/ E, final /*const*/ LValue /*&*/ This, 
             final APValue /*&*/ Result, final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isArrayType()) : "not an array rvalue";
  return new ArrayExprEvaluator(Info, This, Result).Visit(E);
}


/// EvaluateBuiltinClassifyType - Evaluate __builtin_classify_type the same way
/// as GCC.
//<editor-fold defaultstate="collapsed" desc="EvaluateBuiltinClassifyType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6356,
 FQN="EvaluateBuiltinClassifyType", NM="_ZL27EvaluateBuiltinClassifyTypePKN5clang8CallExprERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL27EvaluateBuiltinClassifyTypePKN5clang8CallExprERKNS_11LangOptionsE")
//</editor-fold>
public static int EvaluateBuiltinClassifyType(/*const*/ CallExpr /*P*/ E, 
                           final /*const*/ LangOptions /*&*/ LangOpts) {
  // The following enum mimics the values returned by GCC.
  // FIXME: Does GCC differ between lvalue and rvalue references here?
  final class/*enum*/ gcc_type_class {
    private static final int no_type_class = -1;
    private static final int void_type_class = no_type_class + 1;
    private static final int integer_type_class = void_type_class + 1;
    private static final int char_type_class = integer_type_class + 1;
    private static final int enumeral_type_class = char_type_class + 1;
    private static final int boolean_type_class = enumeral_type_class + 1;
    private static final int pointer_type_class = boolean_type_class + 1;
    private static final int reference_type_class = pointer_type_class + 1;
    private static final int offset_type_class = reference_type_class + 1;
    private static final int real_type_class = offset_type_class + 1;
    private static final int complex_type_class = real_type_class + 1;
    private static final int function_type_class = complex_type_class + 1;
    private static final int method_type_class = function_type_class + 1;
    private static final int record_type_class = method_type_class + 1;
    private static final int union_type_class = record_type_class + 1;
    private static final int array_type_class = union_type_class + 1;
    private static final int string_type_class = array_type_class + 1;
    private static final int lang_type_class = string_type_class + 1;
  };
  
  // If no argument was supplied, default to "no_type_class". This isn't
  // ideal, however it is what gcc does.
  if (E.getNumArgs() == 0) {
    return gcc_type_class.no_type_class;
  }
  
  QualType CanTy = E.getArg$Const(0).getType().getCanonicalType();
  /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CanTy);
  switch (CanTy.$arrow().getTypeClass()) {
   case DependentSizedArray:
   case DependentSizedExtVector:
   case UnresolvedUsing:
   case Paren:
   case Typedef:
   case Adjusted:
   case Decayed:
   case TypeOfExpr:
   case TypeOf:
   case Decltype:
   case UnaryTransform:
   case Elaborated:
   case Attributed:
   case TemplateTypeParm:
   case SubstTemplateTypeParm:
   case SubstTemplateTypeParmPack:
   case TemplateSpecialization:
   case InjectedClassName:
   case DependentName:
   case DependentTemplateSpecialization:
   case PackExpansion:
    throw new llvm_unreachable("CallExpr::isBuiltinClassifyType(): unimplemented type");
   case Builtin:
    switch (BT.getKind()) {
     case Char_S:
      
      //===- Signed Types -------------------------------------------------------===//
      
      // 'char' for targets where it's signed
      return gcc_type_class.integer_type_class;
     case SChar:
      
      // 'signed char', explicitly qualified
      return gcc_type_class.integer_type_class;
     case WChar_S:
      
      // 'wchar_t' for targets where it's signed
      return gcc_type_class.integer_type_class;
     case Short:
      
      // 'short' or 'signed short'
      return gcc_type_class.integer_type_class;
     case Int:
      
      // 'int' or 'signed int'
      return gcc_type_class.integer_type_class;
     case Long:
      
      // 'long' or 'signed long'
      return gcc_type_class.integer_type_class;
     case LongLong:
      
      // 'long long' or 'signed long long'
      return gcc_type_class.integer_type_class;
     case Int128:
      
      // '__int128_t'
      return gcc_type_class.integer_type_class;
     case Half:
      
      //===- Floating point types -----------------------------------------------===//
      
      // 'half' in OpenCL, '__fp16' in ARM NEON.
      return gcc_type_class.real_type_class;
     case Float:
      
      // 'float'
      return gcc_type_class.real_type_class;
     case Double:
      
      // 'double'
      return gcc_type_class.real_type_class;
     case LongDouble:
      
      // 'long double'
      return gcc_type_class.real_type_class;
     case Float128:
      
      // '__float128'
      return gcc_type_class.real_type_class;
     case Overload:
      
      // The type of an unresolved overload set.  A placeholder type.
      // Expressions with this type have one of the following basic
      // forms, with parentheses generally permitted:
      //   foo          # possibly qualified, not if an implicit access
      //   foo          # possibly qualified, not if an implicit access
      //   &foo         # possibly qualified, not if an implicit access
      //   x->foo       # only if might be a static member function
      //   &x->foo      # only if might be a static member function
      //   &Class::foo  # when a pointer-to-member; sub-expr also has this type
      // OverloadExpr::find can be used to analyze the expression.
      //
      // Overload should be the first placeholder type, or else change
      // BuiltinType::isNonOverloadPlaceholderType()
      break;
     case BoundMember:
      
      // The type of a bound C++ non-static member function.
      // A placeholder type.  Expressions with this type have one of the
      // following basic forms:
      //   foo          # if an implicit access
      //   x->foo       # if only contains non-static members
      break;
     case PseudoObject:
      
      // The type of an expression which refers to a pseudo-object,
      // such as those introduced by Objective C's @property or
      // VS.NET's __property declarations.  A placeholder type.  The
      // pseudo-object is actually accessed by emitting a call to
      // some sort of function or method;  typically there is a pair
      // of a setter and a getter, with the setter used if the
      // pseudo-object reference is used syntactically as the
      // left-hand-side of an assignment operator.
      //
      // A pseudo-object reference naming an Objective-C @property is
      // always a dot access with a base of object-pointer type,
      // e.g. 'x.foo'.
      //
      // In VS.NET, a __property declaration creates an implicit
      // member with an associated name, which can then be named
      // in any of the normal ways an ordinary member could be.
      break;
     case UnknownAny:
      
      // __builtin_any_type.  A placeholder type.  Useful for clients
      // like debuggers that don't know what type to give something.
      // Only a small number of operations are valid on expressions of
      // unknown type, most notably explicit casts.
      break;
     case BuiltinFn:
      break;
     case ARCUnbridgedCast:
      
      // The type of a cast which, in ARC, would normally require a
      // __bridge, but which might be okay depending on the immediate
      // context.
      break;
     case OMPArraySection:
      
      // A placeholder type for OpenMP array sections.
      break;
     case Void:
      return gcc_type_class.void_type_class;
     case Bool:
      return gcc_type_class.boolean_type_class;
     case Char_U: // gcc doesn't appear to use char_type_class
     case UChar:
     case UShort:
     case UInt:
     case ULong:
     case ULongLong:
     case UInt128:
      return gcc_type_class.integer_type_class;
     case NullPtr:
      return gcc_type_class.pointer_type_class;
     case WChar_U:
     case Char16:
     case Char32:
     case ObjCId:
     case ObjCClass:
     case ObjCSel:
     case OCLImage1dRO:
     case OCLImage1dArrayRO:
     case OCLImage1dBufferRO:
     case OCLImage2dRO:
     case OCLImage2dArrayRO:
     case OCLImage2dDepthRO:
     case OCLImage2dArrayDepthRO:
     case OCLImage2dMSAARO:
     case OCLImage2dArrayMSAARO:
     case OCLImage2dMSAADepthRO:
     case OCLImage2dArrayMSAADepthRO:
     case OCLImage3dRO:
     case OCLImage1dWO:
     case OCLImage1dArrayWO:
     case OCLImage1dBufferWO:
     case OCLImage2dWO:
     case OCLImage2dArrayWO:
     case OCLImage2dDepthWO:
     case OCLImage2dArrayDepthWO:
     case OCLImage2dMSAAWO:
     case OCLImage2dArrayMSAAWO:
     case OCLImage2dMSAADepthWO:
     case OCLImage2dArrayMSAADepthWO:
     case OCLImage3dWO:
     case OCLImage1dRW:
     case OCLImage1dArrayRW:
     case OCLImage1dBufferRW:
     case OCLImage2dRW:
     case OCLImage2dArrayRW:
     case OCLImage2dDepthRW:
     case OCLImage2dArrayDepthRW:
     case OCLImage2dMSAARW:
     case OCLImage2dArrayMSAARW:
     case OCLImage2dMSAADepthRW:
     case OCLImage2dArrayMSAADepthRW:
     case OCLImage3dRW:
     case OCLSampler:
     case OCLEvent:
     case OCLClkEvent:
     case OCLQueue:
     case OCLNDRange:
     case OCLReserveID:
     case Dependent:
      throw new llvm_unreachable("CallExpr::isBuiltinClassifyType(): unimplemented type");
    }
    /*JSKIP;*/
   case Enum:
    return LangOpts.CPlusPlus ? gcc_type_class.enumeral_type_class : gcc_type_class.integer_type_class;
    //JAVA:break;
   case Pointer:
    return gcc_type_class.pointer_type_class;
    //JAVA:break;
   case MemberPointer:
    if (CanTy.$arrow().isMemberDataPointerType()) {
      return gcc_type_class.offset_type_class;
    } else {
      // We expect member pointers to be either data or function pointers,
      // nothing else.
      assert (CanTy.$arrow().isMemberFunctionPointerType());
      return gcc_type_class.method_type_class;
    }
   case Complex:
    return gcc_type_class.complex_type_class;
   case FunctionNoProto:
   case FunctionProto:
    return LangOpts.CPlusPlus ? gcc_type_class.function_type_class : gcc_type_class.pointer_type_class;
   case Record:
    {
      /*const*/ RecordType /*P*/ RT = CanTy.$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        switch (RT.getDecl().getTagKind()) {
         case TTK_Struct:
         case TTK_Class:
         case TTK_Interface:
          return gcc_type_class.record_type_class;
         case TTK_Enum:
          return LangOpts.CPlusPlus ? gcc_type_class.enumeral_type_class : gcc_type_class.integer_type_class;
         case TTK_Union:
          return gcc_type_class.union_type_class;
        }
      }
    }
    throw new llvm_unreachable("CallExpr::isBuiltinClassifyType(): unimplemented type");
   case ConstantArray:
   case VariableArray:
   case IncompleteArray:
    return LangOpts.CPlusPlus ? gcc_type_class.array_type_class : gcc_type_class.pointer_type_class;
   case BlockPointer:
   case LValueReference:
   case RValueReference:
   case Vector:
   case ExtVector:
   case Auto:
   case ObjCObject:
   case ObjCInterface:
   case ObjCObjectPointer:
   case Pipe:
   case Atomic:
    throw new llvm_unreachable("CallExpr::isBuiltinClassifyType(): unimplemented type");
  }
  throw new llvm_unreachable("CallExpr::isBuiltinClassifyType(): unimplemented type");
}


/// EvaluateBuiltinConstantPForLValue - Determine the result of
/// __builtin_constant_p when applied to the given lvalue.
///
/// An lvalue is only "constant" if it is a pointer or reference to the first
/// character of a string literal.
/*template <typename LValue> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="EvaluateBuiltinConstantPForLValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6502,
 FQN="EvaluateBuiltinConstantPForLValue", NM="Tpl__ZL33EvaluateBuiltinConstantPForLValueRKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=Tpl__ZL33EvaluateBuiltinConstantPForLValueRKT_")
//</editor-fold>
public static </*typename*/ LValue extends LValueBase> boolean EvaluateBuiltinConstantPForLValue(final /*const*/ LValue /*&*/ LV) {
  /*const*/ Expr /*P*/ E = LV.getLValueBase().dyn_cast(Expr.class);
  return (E != null) && isa_StringLiteral(E) && LV.getLValueOffset().isZero();
}


/// EvaluateBuiltinConstantP - Evaluate __builtin_constant_p as similarly to
/// GCC as we can manage.
//<editor-fold defaultstate="collapsed" desc="EvaluateBuiltinConstantP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6509,
 FQN="EvaluateBuiltinConstantP", NM="_ZL24EvaluateBuiltinConstantPRN5clang10ASTContextEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL24EvaluateBuiltinConstantPRN5clang10ASTContextEPKNS_4ExprE")
//</editor-fold>
public static boolean EvaluateBuiltinConstantP(final ASTContext /*&*/ Ctx, /*const*/ Expr /*P*/ Arg) {
  QualType ArgType = Arg.getType();
  
  // __builtin_constant_p always has one operand. The rules which gcc follows
  // are not precisely documented, but are as follows:
  //
  //  - If the operand is of integral, floating, complex or enumeration type,
  //    and can be folded to a known value of that type, it returns 1.
  //  - If the operand and can be folded to a pointer to the first character
  //    of a string literal (or such a pointer cast to an integral type), it
  //    returns 1.
  //
  // Otherwise, it returns 0.
  //
  // FIXME: GCC also intends to return 1 for literals of aggregate types, but
  // its support for this does not currently work.
  if (ArgType.$arrow().isIntegralOrEnumerationType()) {
    Expr.EvalResult Result = null;
    try {
      Result/*J*/= new Expr.EvalResult();
      if (!Arg.EvaluateAsRValue(Result, Ctx) || Result.HasSideEffects) {
        return false;
      }
      
      final APValue /*&*/ V = Result.Val;
      if (V.getKind() == APValue.ValueKind.Int) {
        return true;
      }
      if (V.getKind() == APValue.ValueKind.LValue) {
        return EvaluateBuiltinConstantPForLValue(V);
      }
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  } else if (ArgType.$arrow().isFloatingType() || ArgType.$arrow().isAnyComplexType()) {
    return Arg.isEvaluatable(Ctx);
  } else if (ArgType.$arrow().isPointerType() || Arg.isGLValue()) {
    LValue LV = null;
    EvalInfo Info = null;
    try {
      LV/*J*/= new LValue();
      Expr.EvalStatus Status/*J*/= new Expr.EvalStatus();
      Info/*J*/= new EvalInfo(Ctx, Status, EvalInfo.EvaluationMode.EM_ConstantFold);
      if ((Arg.isGLValue() ? EvaluateLValue(Arg, LV, Info) : EvaluatePointer(Arg, LV, Info))
         && !Status.HasSideEffects) {
        return EvaluateBuiltinConstantPForLValue(LV);
      }
    } finally {
      if (Info != null) { Info.$destroy(); }
      if (LV != null) { LV.$destroy(); }
    }
  }
  
  // Anything else isn't considered to be sufficiently constant.
  return false;
}


/// Retrieves the "underlying object type" of the given expression,
/// as used by __builtin_object_size.
//<editor-fold defaultstate="collapsed" desc="getObjectType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6553,
 FQN="getObjectType", NM="_ZL13getObjectTypeN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS1_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL13getObjectTypeN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS1_4ExprEEE")
//</editor-fold>
public static QualType getObjectType(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B) {
  {
    /*const*/ ValueDecl /*P*/ D = B.dyn_cast(/*const*/ ValueDecl /*P*/.class);
    if ((D != null)) {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
        if ((VD != null)) {
          return VD.getType();
        }
      }
    } else {
      /*const*/ Expr /*P*/ E = B.get(/*const*/ Expr /*P*/.class);
      if ((E != null)) {
        if (isa_CompoundLiteralExpr(E)) {
          return E.getType();
        }
      }
    }
  }
  
  return new QualType();
}


/// A more selective version of E->IgnoreParenCasts for
/// TryEvaluateBuiltinObjectSize. This ignores some casts/parens that serve only
/// to change the type of E.
/// Ex. For E = `(short*)((char*)(&foo))`, returns `&foo`
///
/// Always returns an RValue with a pointer representation.
//<editor-fold defaultstate="collapsed" desc="ignorePointerCastsAndParens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6571,
 FQN="ignorePointerCastsAndParens", NM="_ZL27ignorePointerCastsAndParensPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL27ignorePointerCastsAndParensPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ ignorePointerCastsAndParens(/*const*/ Expr /*P*/ E) {
  assert (E.isRValue() && E.getType().$arrow().hasPointerRepresentation());
  
  /*const*/ Expr /*P*/ NoParens = E.IgnoreParens$Const();
  /*const*/ CastExpr /*P*/ Cast = dyn_cast_CastExpr(NoParens);
  if (Cast == null) {
    return NoParens;
  }
  
  // We only conservatively allow a few kinds of casts, because this code is
  // inherently a simple solution that seeks to support the common case.
  CastKind $CastKind = Cast.getCastKind();
  if ($CastKind != CastKind.CK_NoOp && $CastKind != CastKind.CK_BitCast
     && $CastKind != CastKind.CK_AddressSpaceConversion) {
    return NoParens;
  }
  
  /*const*/ Expr /*P*/ SubExpr = Cast.getSubExpr$Const();
  if (!SubExpr.getType().$arrow().hasPointerRepresentation() || !SubExpr.isRValue()) {
    return NoParens;
  }
  return ignorePointerCastsAndParens(SubExpr);
}


/// Checks to see if the given LValue's Designator is at the end of the LValue's
/// record layout. e.g.
///   struct { struct { int a, b; } fst, snd; } obj;
///   obj.fst   // no
///   obj.snd   // yes
///   obj.fst.a // no
///   obj.fst.b // no
///   obj.snd.a // no
///   obj.snd.b // yes
///
/// Please note: this function is specialized for how __builtin_object_size
/// views "objects".
///
/// If this encounters an invalid RecordDecl, it will always return true.
//<editor-fold defaultstate="collapsed" desc="isDesignatorAtObjectEnd">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6606,
 FQN="isDesignatorAtObjectEnd", NM="_ZL23isDesignatorAtObjectEndRKN5clang10ASTContextERKN12_GLOBAL__N_16LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL23isDesignatorAtObjectEndRKN5clang10ASTContextERKN12_GLOBAL__N_16LValueE")
//</editor-fold>
public static boolean isDesignatorAtObjectEnd(final /*const*/ ASTContext /*&*/ Ctx, final /*const*/ LValue /*&*/ LVal) {
  assert (!LVal.Designator.Invalid);
  
  FieldDeclBoolRef2Bool IsLastOrInvalidFieldDecl = /*[&Ctx]*/ (/*const*/ FieldDecl /*P*/ FD, final bool$ref/*bool &*/ Invalid) -> {
        /*const*/ RecordDecl /*P*/ Parent = FD.getParent$Const();
        Invalid.$set(Parent.isInvalidDecl());
        if (Invalid.$deref() || Parent.isUnion()) {
          return true;
        }
        final /*const*/ ASTRecordLayout /*&*/ Layout = Ctx.getASTRecordLayout(Parent);
        return FD.getFieldIndex() + 1 == Layout.getFieldCount();
      };
  
  final /*constconst*/PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > /*&*/ Base = LVal.getLValueBase();
  {
    /*const*/ MemberExpr /*P*/ ME = dyn_cast_or_null_MemberExpr(Base.dyn_cast(/*const*/ Expr /*P*/.class));
    if ((ME != null)) {
      {
        FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ME.getMemberDecl());
        if ((FD != null)) {
          bool$ref Invalid = create_bool$ref();
          if (!IsLastOrInvalidFieldDecl.$call(FD, /*KEEP_BOOL*/Invalid)) {
            return Invalid.$deref();
          }
        } else {
          IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(ME.getMemberDecl());
          if ((IFD != null)) {
            for (NamedDecl /*P*/ FD$1 : IFD.chain()) {
              bool$ref Invalid = create_bool$ref();
              if (!IsLastOrInvalidFieldDecl.$call(cast_FieldDecl(FD$1), /*KEEP_BOOL*/Invalid)) {
                return Invalid.$deref();
              }
            }
          }
        }
      }
    }
  }
  
  QualType BaseType = getType(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(Base));
  for (int I = 0, E = LVal.Designator.Entries.size(); I != E; ++I) {
    if (BaseType.$arrow().isArrayType()) {
      // Because __builtin_object_size treats arrays as objects, we can ignore
      // the index iff this is the last array in the Designator.
      if (I + 1 == E) {
        return true;
      }
      /*const*/ ConstantArrayType /*P*/ CAT = cast_ConstantArrayType(Ctx.getAsArrayType(new QualType(BaseType)));
      long/*uint64_t*/ Index = LVal.Designator.Entries.$at$Const(I).ArrayIndex;
      if ($noteq_ulong_APInt$C(Index + 1, CAT.getSize())) {
        return false;
      }
      BaseType.$assignMove(CAT.getElementType());
    } else if (BaseType.$arrow().isAnyComplexType()) {
      /*const*/ ComplexType /*P*/ CT = BaseType.$arrow().castAs(ComplexType.class);
      long/*uint64_t*/ Index = LVal.Designator.Entries.$at$Const(I).ArrayIndex;
      if (Index != 1) {
        return false;
      }
      BaseType.$assignMove(CT.getElementType());
    } else {
      /*const*/ FieldDecl /*P*/ FD = getAsField(new APValue.LValuePathEntry(LVal.Designator.Entries.$at$Const(I)));
      if ((FD != null)) {
        bool$ref Invalid = create_bool$ref();
        if (!IsLastOrInvalidFieldDecl.$call(FD, /*KEEP_BOOL*/Invalid)) {
          return Invalid.$deref();
        }
        BaseType.$assignMove(FD.getType());
      } else {
        assert (getAsBaseClass(new APValue.LValuePathEntry(LVal.Designator.Entries.$at$Const(I))) != null) : "Expecting cast to a base class";
        return false;
      }
    }
  }
  return true;
}


/// Tests to see if the LValue has a designator (that isn't necessarily valid).
//<editor-fold defaultstate="collapsed" desc="refersToCompleteObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6666,
 FQN="refersToCompleteObject", NM="_ZL22refersToCompleteObjectRKN12_GLOBAL__N_16LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL22refersToCompleteObjectRKN12_GLOBAL__N_16LValueE")
//</editor-fold>
public static boolean refersToCompleteObject(final /*const*/ LValue /*&*/ LVal) {
  if (LVal.Designator.Invalid || !LVal.Designator.Entries.empty()) {
    return false;
  }
  if (!LVal.InvalidBase) {
    return true;
  }
  
  /*const*/ Expr /*P*/ E = LVal.Base.dyn_cast(/*const*/ Expr /*P*/.class);
  ///*J:(void)*/E;
  assert (E != null && isa_MemberExpr(E));
  return false;
}


/// Tries to evaluate the __builtin_object_size for @p E. If successful, returns
/// true and stores the result in @p Size.
///
/// If @p WasError is non-null, this will report whether the failure to evaluate
/// is to be treated as an Error in IntExprEvaluator.
//<editor-fold defaultstate="collapsed" desc="tryEvaluateBuiltinObjectSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6684,
 FQN="tryEvaluateBuiltinObjectSize", NM="_ZL28tryEvaluateBuiltinObjectSizePKN5clang4ExprEjRN12_GLOBAL__N_18EvalInfoERyPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL28tryEvaluateBuiltinObjectSizePKN5clang4ExprEjRN12_GLOBAL__N_18EvalInfoERyPb")
//</editor-fold>
public static boolean tryEvaluateBuiltinObjectSize(/*const*/ Expr /*P*/ E, /*uint*/int Type, 
                            final EvalInfo /*&*/ Info, final ulong$ref/*uint64_t &*/ Size) {
  return tryEvaluateBuiltinObjectSize(E, Type, 
                            Info, Size, 
                            (bool$ptr/*bool P*/ )null);
}
public static boolean tryEvaluateBuiltinObjectSize(/*const*/ Expr /*P*/ E, /*uint*/int Type, 
                            final EvalInfo /*&*/ Info, final ulong$ref/*uint64_t &*/ Size, 
                            bool$ptr/*bool P*/ WasError/*= null*/) {
  LValue Base = null;
  try {
    if ($noteq_ptr(WasError, null)) {
      WasError.$set(false);
    }
    
    Expr2Bool Error = /*[&, &WasError]*/ (/*const*/ Expr /*P*/ E$1) -> {
          if ($noteq_ptr(WasError, null)) {
            WasError.$set(true);
          }
          return false;
        };
    
    Uint64Expr2Bool Success = /*[&, &Size]*/ (long/*uint64_t*/ S, /*const*/ Expr /*P*/ E$1) -> {
          Size.$set(S);
          return true;
        };
    
    // Determine the denoted object.
    Base/*J*/= new LValue();
    {
      SpeculativeEvaluationRAII SpeculativeEval = null;
      FoldOffsetRAII Fold = null;
      try {
        // The operand of __builtin_object_size is never evaluated for side-effects.
        // If there are any, but we can determine the pointed-to object anyway, then
        // ignore the side-effects.
        SpeculativeEval/*J*/= new SpeculativeEvaluationRAII(Info);
        Fold/*J*/= new FoldOffsetRAII(Info, ((Type & 1) != 0));
        if (E.isGLValue()) {
          APValue RVal = null;
          try {
            // It's possible for us to be given GLValues if we're called via
            // Expr::tryEvaluateObjectSize.
            RVal/*J*/= new APValue();
            if (!EvaluateAsRValue(Info, E, RVal)) {
              return false;
            }
            Base.setFrom(Info.Ctx, RVal);
          } finally {
            if (RVal != null) { RVal.$destroy(); }
          }
        } else if (!EvaluatePointer(ignorePointerCastsAndParens(E), Base, Info)) {
          return false;
        }
      } finally {
        if (Fold != null) { Fold.$destroy(); }
        if (SpeculativeEval != null) { SpeculativeEval.$destroy(); }
      }
    }
    
    CharUnits BaseOffset = new CharUnits(Base.getLValueOffset());
    // If we point to before the start of the object, there are no accessible
    // bytes.
    if (BaseOffset.isNegative()) {
      return Success.$call(0, E);
    }
    
    // In the case where we're not dealing with a subobject, we discard the
    // subobject bit.
    boolean SubobjectOnly = (Type & 1) != 0 && !refersToCompleteObject(Base);
    
    // If Type & 1 is 0, we need to be able to statically guarantee that the bytes
    // exist. If we can't verify the base, then we can't do that.
    //
    // As a special case, we produce a valid object size for an unknown object
    // with a known designator if Type & 1 is 1. For instance:
    //
    //   extern struct X { char buff[32]; int a, b, c; } *p;
    //   int a = __builtin_object_size(p->buff + 4, 3); // returns 28
    //   int b = __builtin_object_size(p->buff + 4, 2); // returns 0, not 40
    //
    // This matches GCC's behavior.
    if (Base.InvalidBase && !SubobjectOnly) {
      return Error.$call(E);
    }
    
    // If we're not examining only the subobject, then we reset to a complete
    // object designator
    //
    // If Type is 1 and we've lost track of the subobject, just find the complete
    // object instead. (If Type is 3, that's not correct behavior and we should
    // return 0 instead.)
    LValue End = new LValue(Base);
    if (!SubobjectOnly || (End.Designator.Invalid && Type == 1)) {
      QualType T = getObjectType(End.getLValueBase());
      if (T.isNull()) {
        End.Designator.setInvalid();
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(End.Designator.$assignMove($c$.track(new SubobjectDesignator(new QualType(T)))));
          End.Offset.$assignMove(CharUnits.Zero());
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // If it is not possible to determine which objects ptr points to at compile
    // time, __builtin_object_size should return (size_t) -1 for type 0 or 1
    // and (size_t) 0 for type 2 or 3.
    if (End.Designator.Invalid) {
      return false;
    }
    
    // According to the GCC documentation, we want the size of the subobject
    // denoted by the pointer. But that's not quite right -- what we actually
    // want is the size of the immediately-enclosing array, if there is one.
    long/*int64_t*/ AmountToAdd = 1;
    if (End.Designator.MostDerivedIsArrayElement
       && End.Designator.Entries.size() == End.Designator.MostDerivedPathLength) {
      // We got a pointer to an array. Step to its end.
      AmountToAdd = End.Designator.MostDerivedArraySize
         - End.Designator.Entries.back().ArrayIndex;
    } else if (End.Designator.isOnePastTheEnd()) {
      // We're already pointing at the end of the object.
      AmountToAdd = 0;
    }
    
    QualType PointeeType = new QualType(End.Designator.MostDerivedType);
    assert (!PointeeType.isNull());
    if (PointeeType.$arrow().isIncompleteType() || PointeeType.$arrow().isFunctionType()) {
      return Error.$call(E);
    }
    if (!HandleLValueArrayAdjustment(Info, E, End, new QualType(End.Designator.MostDerivedType), 
        AmountToAdd)) {
      return false;
    }
    
    CharUnits EndOffset = new CharUnits(End.getLValueOffset());
    
    // The following is a moderately common idiom in C:
    //
    // struct Foo { int a; char c[1]; };
    // struct Foo *F = (struct Foo *)malloc(sizeof(struct Foo) + strlen(Bar));
    // strcpy(&F->c[0], Bar);
    //
    // So, if we see that we're examining a 1-length (or 0-length) array at the
    // end of a struct with an unknown base, we give up instead of breaking code
    // that behaves this way. Note that we only do this when Type=1, because
    // Type=3 is a lower bound, so answering conservatively is fine.
    if (End.InvalidBase && SubobjectOnly && Type == 1
       && End.Designator.Entries.size() == End.Designator.MostDerivedPathLength
       && End.Designator.MostDerivedIsArrayElement
       && $less_ulong_ullong(End.Designator.MostDerivedArraySize, 2)
       && isDesignatorAtObjectEnd(Info.Ctx, End)) {
      return false;
    }
    if (BaseOffset.$greater(EndOffset)) {
      return Success.$call(0, E);
    }
    
    return Success.$call((EndOffset.$sub(BaseOffset)).getQuantity(), E);
  } finally {
    if (Base != null) { Base.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="HasSameBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7089,
 FQN="HasSameBase", NM="_ZL11HasSameBaseRKN12_GLOBAL__N_16LValueES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL11HasSameBaseRKN12_GLOBAL__N_16LValueES2_")
//</editor-fold>
public static boolean HasSameBase(final /*const*/ LValue /*&*/ A, final /*const*/ LValue /*&*/ B) {
  if (!A.getLValueBase().$bool()) {
    return !B.getLValueBase().$bool();
  }
  if (!B.getLValueBase().$bool()) {
    return false;
  }
  if ($noteq_ptr(A.getLValueBase().getOpaqueValue(), B.getLValueBase().getOpaqueValue())) {
    /*const*/ Decl /*P*/ ADecl = GetLValueBaseDecl(A);
    if (!(ADecl != null)) {
      return false;
    }
    /*const*/ Decl /*P*/ BDecl = GetLValueBaseDecl(B);
    if (!(BDecl != null) || ADecl.getCanonicalDecl$Const() != BDecl.getCanonicalDecl$Const()) {
      return false;
    }
  }
  
  return IsGlobalLValue(A.getLValueBase())
     || A.getLValueCallIndex() == B.getLValueCallIndex();
}


/// \brief Determine whether this is a pointer past the end of the complete
/// object referred to by the lvalue.
//<editor-fold defaultstate="collapsed" desc="isOnePastTheEndOfCompleteObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7111,
 FQN="isOnePastTheEndOfCompleteObject", NM="_ZL31isOnePastTheEndOfCompleteObjectRKN5clang10ASTContextERKN12_GLOBAL__N_16LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL31isOnePastTheEndOfCompleteObjectRKN5clang10ASTContextERKN12_GLOBAL__N_16LValueE")
//</editor-fold>
public static boolean isOnePastTheEndOfCompleteObject(final /*const*/ ASTContext /*&*/ Ctx, 
                               final /*const*/ LValue /*&*/ LV) {
  // A null pointer can be viewed as being "past the end" but we don't
  // choose to look at it that way here.
  if (!LV.getLValueBase().$bool()) {
    return false;
  }
  
  // If the designator is valid and refers to a subobject, we're not pointing
  // past the end.
  if (!LV.getLValueDesignator$Const().Invalid
     && !LV.getLValueDesignator$Const().isOnePastTheEnd()) {
    return false;
  }
  
  // A pointer to an incomplete type might be past-the-end if the type's size is
  // zero.  We cannot tell because the type is incomplete.
  QualType Ty = getType(LV.getLValueBase());
  if (Ty.$arrow().isIncompleteType()) {
    return true;
  }
  
  // We're a past-the-end pointer if we point to the byte after the object,
  // no matter what our type or path is.
  CharUnits Size = Ctx.getTypeSizeInChars(/*NO_COPY*/Ty);
  return LV.getLValueOffset$Const().$eq(Size);
}

//<editor-fold defaultstate="collapsed" desc="TryEvaluateBuiltinNaN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8219,
 FQN="TryEvaluateBuiltinNaN", NM="_ZL21TryEvaluateBuiltinNaNRKN5clang10ASTContextENS_8QualTypeEPKNS_4ExprEbRN4llvm7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL21TryEvaluateBuiltinNaNRKN5clang10ASTContextENS_8QualTypeEPKNS_4ExprEbRN4llvm7APFloatE")
//</editor-fold>
public static boolean TryEvaluateBuiltinNaN(final /*const*/ ASTContext /*&*/ Context, 
                     QualType ResultTy, 
                     /*const*/ Expr /*P*/ Arg, 
                     boolean SNaN, 
                     final APFloat /*&*/ Result) {
  /*const*/ StringLiteral /*P*/ S = dyn_cast_StringLiteral(Arg.IgnoreParenCasts$Const());
  if (!(S != null)) {
    return false;
  }
  
  final /*const*/ fltSemantics /*&*/ Sem = Context.getFloatTypeSemantics(new QualType(ResultTy));
  
  APInt fill/*J*/= new APInt();
  
  // Treat empty strings as if they were zero.
  if (S.getString().empty()) {
    fill.$assignMove(new APInt(32, 0));
  } else if (S.getString().getAsInteger(0, fill)) {
    return false;
  }
  if (Context.getTargetInfo().isNan2008()) {
    if (SNaN) {
      Result.$assignMove(APFloat.getSNaN(Sem, false, $AddrOf(fill)));
    } else {
      Result.$assignMove(APFloat.getQNaN(Sem, false, $AddrOf(fill)));
    }
  } else {
    // Prior to IEEE 754-2008, architectures were allowed to choose whether
    // the first bit of their significand was set for qNaN or sNaN. MIPS chose
    // a different encoding to what became a standard in 2008, and for pre-
    // 2008 revisions, MIPS interpreted sNaN-2008 as qNan and qNaN-2008 as
    // sNaN. This is now known as "legacy NaN" encoding.
    if (SNaN) {
      Result.$assignMove(APFloat.getQNaN(Sem, false, $AddrOf(fill)));
    } else {
      Result.$assignMove(APFloat.getSNaN(Sem, false, $AddrOf(fill)));
    }
  }
  
  return true;
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="EvaluateVoid">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8974,
 FQN="EvaluateVoid", NM="_ZL12EvaluateVoidPKN5clang4ExprERN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL12EvaluateVoidPKN5clang4ExprERN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public static boolean EvaluateVoid(/*const*/ Expr /*P*/ E, final EvalInfo /*&*/ Info) {
  assert (E.isRValue() && E.getType().$arrow().isVoidType());
  return new VoidExprEvaluator(Info).Visit(E);
}

//<editor-fold defaultstate="collapsed" desc="FastEvaluateAsRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9099,
 FQN="FastEvaluateAsRValue", NM="_ZL20FastEvaluateAsRValuePKN5clang4ExprERNS0_10EvalResultERKNS_10ASTContextERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL20FastEvaluateAsRValuePKN5clang4ExprERNS0_10EvalResultERKNS_10ASTContextERb")
//</editor-fold>
public static boolean FastEvaluateAsRValue(/*const*/ Expr /*P*/ Exp, final Expr.EvalResult /*&*/ Result, 
                    final /*const*/ ASTContext /*&*/ Ctx, final bool$ref/*bool &*/ IsConst) {
  {
    // Fast-path evaluations of integer literals, since we sometimes see files
    // containing vast quantities of these.
    /*const*/ IntegerLiteral /*P*/ L = dyn_cast_IntegerLiteral(Exp);
    if ((L != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Result.Val.$assign($c$.track(new APValue(new APSInt(L.getValue(), 
                    L.getType().$arrow().isUnsignedIntegerType())))));
        IsConst.$set(true);
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // This case should be rare, but we need to check it before we check on
  // the type below.
  if (Exp.getType().isNull()) {
    IsConst.$set(false);
    return true;
  }
  
  // FIXME: Evaluating values of large array and record types can cause
  // performance problems. Only do so in C++11 for now.
  if (Exp.isRValue() && (Exp.getType().$arrow().isArrayType()
     || Exp.getType().$arrow().isRecordType())
     && !Ctx.getLangOpts().CPlusPlus11) {
    IsConst.$set(false);
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="hasUnacceptableSideEffect">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9150,
 FQN="hasUnacceptableSideEffect", NM="_ZL25hasUnacceptableSideEffectRN5clang4Expr10EvalStatusENS0_15SideEffectsKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL25hasUnacceptableSideEffectRN5clang4Expr10EvalStatusENS0_15SideEffectsKindE")
//</editor-fold>
public static boolean hasUnacceptableSideEffect(final Expr.EvalStatus /*&*/ Result, 
                         Expr.SideEffectsKind SEK) {
  return (SEK.getValue() < Expr.SideEffectsKind.SE_AllowSideEffects.getValue() && Result.HasSideEffects)
     || (SEK.getValue() < Expr.SideEffectsKind.SE_AllowUndefinedBehavior.getValue() && Result.HasUndefinedBehavior);
}

//<editor-fold defaultstate="collapsed" desc="NoDiag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9310,
 FQN="NoDiag", NM="_ZL6NoDiagv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL6NoDiagv")
//</editor-fold>
public static ICEDiag NoDiag() {
  return new ICEDiag(ICEKind.IK_ICE, new SourceLocation());
}

//<editor-fold defaultstate="collapsed" desc="Worst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9312,
 FQN="Worst", NM="_ZL5WorstN12_GLOBAL__N_17ICEDiagES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL5WorstN12_GLOBAL__N_17ICEDiagES0_")
//</editor-fold>
public static ICEDiag Worst(ICEDiag A, ICEDiag B) {
  return new ICEDiag(A.Kind.getValue() >= B.Kind.getValue() ? A : B);
}

//<editor-fold defaultstate="collapsed" desc="CheckEvalInICE">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9314,
 FQN="CheckEvalInICE", NM="_ZL14CheckEvalInICEPKN5clang4ExprERKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL14CheckEvalInICEPKN5clang4ExprERKNS_10ASTContextE")
//</editor-fold>
public static ICEDiag CheckEvalInICE(/*const*/ Expr /*P*/ E, final /*const*/ ASTContext /*&*/ Ctx) {
  Expr.EvalResult EVResult = null;
  try {
    EVResult/*J*/= new Expr.EvalResult();
    if (!E.EvaluateAsRValue(EVResult, Ctx) || EVResult.HasSideEffects
       || !EVResult.Val.isInt()) {
      return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
    }
    
    return NoDiag();
  } finally {
    if (EVResult != null) { EVResult.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckICE">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9323,
 FQN="CheckICE", NM="_ZL8CheckICEPKN5clang4ExprERKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL8CheckICEPKN5clang4ExprERKNS_10ASTContextE")
//</editor-fold>
public static ICEDiag CheckICE(/*const*/ Expr /*P*/ E, final /*const*/ ASTContext /*&*/ Ctx) {
  assert (!E.isValueDependent()) : "Should not see value dependent exprs!";
  if (!E.getType().$arrow().isIntegralOrEnumerationType()) {
    return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
  }
  switch (E.getStmtClass()) {
   case GCCAsmStmtClass:
   case MSAsmStmtClass:
   case AttributedStmtClass:
   case BreakStmtClass:
   case CXXCatchStmtClass:
   case CXXForRangeStmtClass:
   case CXXTryStmtClass:
   case CapturedStmtClass:
   case CompoundStmtClass:
   case ContinueStmtClass:
   case CoreturnStmtClass:
   case CoroutineBodyStmtClass:
   case DeclStmtClass:
   case DoStmtClass:
   case ForStmtClass:
   case GotoStmtClass:
   case IfStmtClass:
   case IndirectGotoStmtClass:
   case LabelStmtClass:
   case MSDependentExistsStmtClass:
   case NullStmtClass:
   case OMPAtomicDirectiveClass:
   case OMPBarrierDirectiveClass:
   case OMPCancelDirectiveClass:
   case OMPCancellationPointDirectiveClass:
   case OMPCriticalDirectiveClass:
   case OMPFlushDirectiveClass:
   case OMPDistributeDirectiveClass:
   case OMPDistributeParallelForDirectiveClass:
   case OMPDistributeParallelForSimdDirectiveClass:
   case OMPDistributeSimdDirectiveClass:
   case OMPForDirectiveClass:
   case OMPForSimdDirectiveClass:
   case OMPParallelForDirectiveClass:
   case OMPParallelForSimdDirectiveClass:
   case OMPSimdDirectiveClass:
   case OMPTargetParallelForSimdDirectiveClass:
   case OMPTaskLoopDirectiveClass:
   case OMPTaskLoopSimdDirectiveClass:
   case OMPMasterDirectiveClass:
   case OMPOrderedDirectiveClass:
   case OMPParallelDirectiveClass:
   case OMPParallelSectionsDirectiveClass:
   case OMPSectionDirectiveClass:
   case OMPSectionsDirectiveClass:
   case OMPSingleDirectiveClass:
   case OMPTargetDataDirectiveClass:
   case OMPTargetDirectiveClass:
   case OMPTargetEnterDataDirectiveClass:
   case OMPTargetExitDataDirectiveClass:
   case OMPTargetParallelDirectiveClass:
   case OMPTargetParallelForDirectiveClass:
   case OMPTargetUpdateDirectiveClass:
   case OMPTaskDirectiveClass:
   case OMPTaskgroupDirectiveClass:
   case OMPTaskwaitDirectiveClass:
   case OMPTaskyieldDirectiveClass:
   case OMPTeamsDirectiveClass:
   case ObjCAtCatchStmtClass:
   case ObjCAtFinallyStmtClass:
   case ObjCAtSynchronizedStmtClass:
   case ObjCAtThrowStmtClass:
   case ObjCAtTryStmtClass:
   case ObjCAutoreleasePoolStmtClass:
   case ObjCForCollectionStmtClass:
   case ReturnStmtClass:
   case SEHExceptStmtClass:
   case SEHFinallyStmtClass:
   case SEHLeaveStmtClass:
   case SEHTryStmtClass:
   case CaseStmtClass:
   case DefaultStmtClass:
   case SwitchStmtClass:
   case WhileStmtClass:
   case PredefinedExprClass:
   case FloatingLiteralClass:
   case ImaginaryLiteralClass:
   case StringLiteralClass:
   case ArraySubscriptExprClass:
   case OMPArraySectionExprClass:
   case MemberExprClass:
   case CompoundAssignOperatorClass:
   case CompoundLiteralExprClass:
   case ExtVectorElementExprClass:
   case DesignatedInitExprClass:
   case NoInitExprClass:
   case DesignatedInitUpdateExprClass:
   case ImplicitValueInitExprClass:
   case ParenListExprClass:
   case VAArgExprClass:
   case AddrLabelExprClass:
   case StmtExprClass:
   case CXXMemberCallExprClass:
   case CUDAKernelCallExprClass:
   case CXXDynamicCastExprClass:
   case CXXTypeidExprClass:
   case CXXUuidofExprClass:
   case MSPropertyRefExprClass:
   case MSPropertySubscriptExprClass:
   case CXXNullPtrLiteralExprClass:
   case UserDefinedLiteralClass:
   case CXXThisExprClass:
   case CXXThrowExprClass:
   case CXXNewExprClass:
   case CXXDeleteExprClass:
   case CXXPseudoDestructorExprClass:
   case UnresolvedLookupExprClass:
   case TypoExprClass:
   case DependentScopeDeclRefExprClass:
   case CXXConstructExprClass:
   case CXXInheritedCtorInitExprClass:
   case CXXStdInitializerListExprClass:
   case CXXBindTemporaryExprClass:
   case ExprWithCleanupsClass:
   case CXXTemporaryObjectExprClass:
   case CXXUnresolvedConstructExprClass:
   case CXXDependentScopeMemberExprClass:
   case UnresolvedMemberExprClass:
   case ObjCStringLiteralClass:
   case ObjCBoxedExprClass:
   case ObjCArrayLiteralClass:
   case ObjCDictionaryLiteralClass:
   case ObjCEncodeExprClass:
   case ObjCMessageExprClass:
   case ObjCSelectorExprClass:
   case ObjCProtocolExprClass:
   case ObjCIvarRefExprClass:
   case ObjCPropertyRefExprClass:
   case ObjCSubscriptRefExprClass:
   case ObjCIsaExprClass:
   case ObjCAvailabilityCheckExprClass:
   case ShuffleVectorExprClass:
   case ConvertVectorExprClass:
   case BlockExprClass:
   case NoStmtClass:
   case OpaqueValueExprClass:
   case PackExpansionExprClass:
   case SubstNonTypeTemplateParmPackExprClass:
   case FunctionParmPackExprClass:
   case AsTypeExprClass:
   case ObjCIndirectCopyRestoreExprClass:
   case MaterializeTemporaryExprClass:
   case PseudoObjectExprClass:
   case AtomicExprClass:
   case LambdaExprClass:
   case CXXFoldExprClass:
   case CoawaitExprClass:
   case CoyieldExprClass:
    return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
   case InitListExprClass:
    {
      // C++03 [dcl.init]p13: If T is a scalar type, then a declaration of the
      // form "T x = { a };" is equivalent to "T x = a;".
      // Unless we're initializing a reference, T is a scalar as it is known to be
      // of integral or enumeration type.
      if (E.isRValue()) {
        if (cast_InitListExpr(E).getNumInits() == 1) {
          return CheckICE(cast_InitListExpr(E).getInit$Const(0), Ctx);
        }
      }
      return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
    }
   case SizeOfPackExprClass:
   case GNUNullExprClass:
    // GCC considers the GNU __null value to be an integral constant expression.
    return NoDiag();
   case SubstNonTypeTemplateParmExprClass:
    return CheckICE(cast_SubstNonTypeTemplateParmExpr(E).getReplacement(), Ctx);
   case ParenExprClass:
    return CheckICE(cast_ParenExpr(E).getSubExpr$Const(), Ctx);
   case GenericSelectionExprClass:
    return CheckICE(cast_GenericSelectionExpr(E).getResultExpr$Const(), Ctx);
   case IntegerLiteralClass:
   case CharacterLiteralClass:
   case ObjCBoolLiteralExprClass:
   case CXXBoolLiteralExprClass:
   case CXXScalarValueInitExprClass:
   case TypeTraitExprClass:
   case ArrayTypeTraitExprClass:
   case ExpressionTraitExprClass:
   case CXXNoexceptExprClass:
    return NoDiag();
   case CallExprClass:
   case CXXOperatorCallExprClass:
    {
      // C99 6.6/3 allows function calls within unevaluated subexpressions of
      // constant expressions, but they can never be ICEs because an ICE cannot
      // contain an operand of (pointer to) function type.
      /*const*/ CallExpr /*P*/ CE = cast_CallExpr(E);
      if ((CE.getBuiltinCallee() != 0)) {
        return CheckEvalInICE(E, Ctx);
      }
      return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
    }
   case DeclRefExprClass:
    {
      if (isa_EnumConstantDecl(cast_DeclRefExpr(E).getDecl$Const())) {
        return NoDiag();
      }
      /*const*/ ValueDecl /*P*/ D = dyn_cast_ValueDecl(cast_DeclRefExpr(E).getDecl$Const());
      if (Ctx.getLangOpts().CPlusPlus
         && (D != null) && IsConstNonVolatile(D.getType())) {
        // Parameter variables are never constants.  Without this check,
        // getAnyInitializer() can find a default argument, which leads
        // to chaos.
        if (isa_ParmVarDecl(D)) {
          return new ICEDiag(ICEKind.IK_NotICE, cast_DeclRefExpr(E).getLocation());
        }
        {
          
          // C++ 7.1.5.1p2
          //   A variable of non-volatile const-qualified integral or enumeration
          //   type initialized by an ICE can be used in ICEs.
          /*const*/ VarDecl /*P*/ Dcl = dyn_cast_VarDecl(D);
          if ((Dcl != null)) {
            if (!Dcl.getType().$arrow().isIntegralOrEnumerationType()) {
              return new ICEDiag(ICEKind.IK_NotICE, cast_DeclRefExpr(E).getLocation());
            }
            
            type$ref</*const*/ VarDecl /*P*/ > VD = create_type$ref();
            // Look for a declaration of this variable that has an initializer, and
            // check whether it is an ICE.
            if ((Dcl.getAnyInitializer(VD) != null) && VD.$deref().checkInitIsICE()) {
              return NoDiag();
            } else {
              return new ICEDiag(ICEKind.IK_NotICE, cast_DeclRefExpr(E).getLocation());
            }
          }
        }
      }
      return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
    }
   case UnaryOperatorClass:
    {
      /*const*/ UnaryOperator /*P*/ Exp = cast_UnaryOperator(E);
      switch (Exp.getOpcode()) {
       case UO_PostInc:
       case UO_PostDec:
       case UO_PreInc:
       case UO_PreDec:
       case UO_AddrOf:
       case UO_Deref:
       case UO_Coawait:
        // C99 6.6/3 allows increment and decrement within unevaluated
        // subexpressions of constant expressions, but they can never be ICEs
        // because an ICE cannot contain an lvalue operand.
        return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
       case UO_Extension:
       case UO_LNot:
       case UO_Plus:
       case UO_Minus:
       case UO_Not:
       case UO_Real:
       case UO_Imag:
        return CheckICE(Exp.getSubExpr(), Ctx);
      }
      // OffsetOf falls through here.
    }
   case OffsetOfExprClass:
    {
      // Note that per C99, offsetof must be an ICE. And AFAIK, using
      // EvaluateAsRValue matches the proposed gcc behavior for cases like
      // "offsetof(struct s{int x[4];}, x[1.0])".  This doesn't affect
      // compliance: we should warn earlier for offsetof expressions with
      // array subscripts that aren't ICEs, and if the array subscripts
      // are ICEs, the value of the offsetof must be an integer constant.
      return CheckEvalInICE(E, Ctx);
    }
   case UnaryExprOrTypeTraitExprClass:
    {
      /*const*/ UnaryExprOrTypeTraitExpr /*P*/ Exp = cast_UnaryExprOrTypeTraitExpr(E);
      if ((Exp.getKind() == UnaryExprOrTypeTrait.UETT_SizeOf)
         && Exp.getTypeOfArgument().$arrow().isVariableArrayType()) {
        return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
      }
      return NoDiag();
    }
   case BinaryOperatorClass:
    {
      /*const*/ BinaryOperator /*P*/ Exp = cast_BinaryOperator(E);
      switch (Exp.getOpcode()) {
       case BO_PtrMemD:
       case BO_PtrMemI:
       case BO_Assign:
       case BO_MulAssign:
       case BO_DivAssign:
       case BO_RemAssign:
       case BO_AddAssign:
       case BO_SubAssign:
       case BO_ShlAssign:
       case BO_ShrAssign:
       case BO_AndAssign:
       case BO_XorAssign:
       case BO_OrAssign:
        // C99 6.6/3 allows assignments within unevaluated subexpressions of
        // constant expressions, but they can never be ICEs because an ICE cannot
        // contain an lvalue operand.
        return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
       case BO_Mul:
       case BO_Div:
       case BO_Rem:
       case BO_Add:
       case BO_Sub:
       case BO_Shl:
       case BO_Shr:
       case BO_LT:
       case BO_GT:
       case BO_LE:
       case BO_GE:
       case BO_EQ:
       case BO_NE:
       case BO_And:
       case BO_Xor:
       case BO_Or:
       case BO_Comma:
        {
          ICEDiag LHSResult = CheckICE(Exp.getLHS(), Ctx);
          ICEDiag RHSResult = CheckICE(Exp.getRHS(), Ctx);
          if (Exp.getOpcode() == BinaryOperatorKind.BO_Div
             || Exp.getOpcode() == BinaryOperatorKind.BO_Rem) {
            // EvaluateAsRValue gives an error for undefined Div/Rem, so make sure
            // we don't evaluate one.
            if (LHSResult.Kind == ICEKind.IK_ICE && RHSResult.Kind == ICEKind.IK_ICE) {
              APSInt REval = Exp.getRHS().EvaluateKnownConstInt(Ctx);
              if (REval.$eq(0)) {
                return new ICEDiag(ICEKind.IK_ICEIfUnevaluated, E.getLocStart());
              }
              if (REval.isSigned() && REval.isAllOnesValue()) {
                APSInt LEval = Exp.getLHS().EvaluateKnownConstInt(Ctx);
                if (LEval.isMinSignedValue()) {
                  return new ICEDiag(ICEKind.IK_ICEIfUnevaluated, E.getLocStart());
                }
              }
            }
          }
          if (Exp.getOpcode() == BinaryOperatorKind.BO_Comma) {
            if (Ctx.getLangOpts().C99) {
              // C99 6.6p3 introduces a strange edge case: comma can be in an ICE
              // if it isn't evaluated.
              if (LHSResult.Kind == ICEKind.IK_ICE && RHSResult.Kind == ICEKind.IK_ICE) {
                return new ICEDiag(ICEKind.IK_ICEIfUnevaluated, E.getLocStart());
              }
            } else {
              // In both C89 and C++, commas in ICEs are illegal.
              return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
            }
          }
          return Worst(new ICEDiag(LHSResult), new ICEDiag(RHSResult));
        }
       case BO_LAnd:
       case BO_LOr:
        {
          ICEDiag LHSResult = CheckICE(Exp.getLHS(), Ctx);
          ICEDiag RHSResult = CheckICE(Exp.getRHS(), Ctx);
          if (LHSResult.Kind == ICEKind.IK_ICE && RHSResult.Kind == ICEKind.IK_ICEIfUnevaluated) {
            // Rare case where the RHS has a comma "side-effect"; we need
            // to actually check the condition to see whether the side
            // with the comma is evaluated.
            if ((Exp.getOpcode() == BinaryOperatorKind.BO_LAnd)
               != (Exp.getLHS().EvaluateKnownConstInt(Ctx).$eq(0))) {
              return RHSResult;
            }
            return NoDiag();
          }
          
          return Worst(new ICEDiag(LHSResult), new ICEDiag(RHSResult));
        }
      }
    }
   case ImplicitCastExprClass:
   case CStyleCastExprClass:
   case CXXFunctionalCastExprClass:
   case CXXStaticCastExprClass:
   case CXXReinterpretCastExprClass:
   case CXXConstCastExprClass:
   case ObjCBridgedCastExprClass:
    {
      /*const*/ Expr /*P*/ SubExpr = cast_CastExpr(E).getSubExpr$Const();
      if (isa_ExplicitCastExpr(E)) {
        {
          /*const*/ FloatingLiteral /*P*/ FL = dyn_cast_FloatingLiteral(SubExpr.IgnoreParenImpCasts$Const());
          if ((FL != null)) {
            /*uint*/int DestWidth = Ctx.getIntWidth(E.getType());
            boolean DestSigned = E.getType().$arrow().isSignedIntegerOrEnumerationType();
            APSInt IgnoredVal/*J*/= new APSInt(DestWidth, !DestSigned);
            bool$ptr Ignored = create_bool$ptr();
            // If the value does not fit in the destination type, the behavior is
            // undefined, so we are not required to treat it as a constant
            // expression.
            if (((FL.getValue().convertToInteger(IgnoredVal, 
                APFloat.roundingMode.rmTowardZero, 
                $AddrOf(Ignored)) & APFloat.opStatus.opInvalidOp) != 0)) {
              return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
            }
            return NoDiag();
          }
        }
      }
      switch (cast_CastExpr(E).getCastKind()) {
       case CK_LValueToRValue:
       case CK_AtomicToNonAtomic:
       case CK_NonAtomicToAtomic:
       case CK_NoOp:
       case CK_IntegralToBoolean:
       case CK_IntegralCast:
        return CheckICE(SubExpr, Ctx);
       default:
        return new ICEDiag(ICEKind.IK_NotICE, E.getLocStart());
      }
    }
   case BinaryConditionalOperatorClass:
    {
      /*const*/ BinaryConditionalOperator /*P*/ Exp = cast_BinaryConditionalOperator(E);
      ICEDiag CommonResult = CheckICE(Exp.getCommon(), Ctx);
      if (CommonResult.Kind == ICEKind.IK_NotICE) {
        return CommonResult;
      }
      ICEDiag FalseResult = CheckICE(Exp.getFalseExpr(), Ctx);
      if (FalseResult.Kind == ICEKind.IK_NotICE) {
        return FalseResult;
      }
      if (CommonResult.Kind == ICEKind.IK_ICEIfUnevaluated) {
        return CommonResult;
      }
      if (FalseResult.Kind == ICEKind.IK_ICEIfUnevaluated
         && Exp.getCommon().EvaluateKnownConstInt(Ctx).$noteq(0)) {
        return NoDiag();
      }
      return FalseResult;
    }
   case ConditionalOperatorClass:
    {
      /*const*/ ConditionalOperator /*P*/ Exp = cast_ConditionalOperator(E);
      {
        // If the condition (ignoring parens) is a __builtin_constant_p call,
        // then only the true side is actually considered in an integer constant
        // expression, and it is fully evaluated.  This is an important GNU
        // extension.  See GCC PR38377 for discussion.
        /*const*/ CallExpr /*P*/ CallCE = dyn_cast_CallExpr(Exp.getCond().IgnoreParenCasts());
        if ((CallCE != null)) {
          if (CallCE.getBuiltinCallee() == Builtin.ID.BI__builtin_constant_p.getValue()) {
            return CheckEvalInICE(E, Ctx);
          }
        }
      }
      ICEDiag CondResult = CheckICE(Exp.getCond(), Ctx);
      if (CondResult.Kind == ICEKind.IK_NotICE) {
        return CondResult;
      }
      
      ICEDiag TrueResult = CheckICE(Exp.getTrueExpr(), Ctx);
      ICEDiag FalseResult = CheckICE(Exp.getFalseExpr(), Ctx);
      if (TrueResult.Kind == ICEKind.IK_NotICE) {
        return TrueResult;
      }
      if (FalseResult.Kind == ICEKind.IK_NotICE) {
        return FalseResult;
      }
      if (CondResult.Kind == ICEKind.IK_ICEIfUnevaluated) {
        return CondResult;
      }
      if (TrueResult.Kind == ICEKind.IK_ICE && FalseResult.Kind == ICEKind.IK_ICE) {
        return NoDiag();
      }
      // Rare case where the diagnostics depend on which side is evaluated
      // Note that if we get here, CondResult is 0, and at least one of
      // TrueResult and FalseResult is non-zero.
      if (Exp.getCond().EvaluateKnownConstInt(Ctx).$eq(0)) {
        return FalseResult;
      }
      return TrueResult;
    }
   case CXXDefaultArgExprClass:
    return CheckICE(cast_CXXDefaultArgExpr(E).getExpr$Const(), Ctx);
   case CXXDefaultInitExprClass:
    return CheckICE(cast_CXXDefaultInitExpr(E).getExpr$Const(), Ctx);
   case ChooseExprClass:
    {
      return CheckICE(cast_ChooseExpr(E).getChosenSubExpr(), Ctx);
    }
  }
  throw new llvm_unreachable("Invalid StmtClass!");
}


/// Evaluate an expression as a C++11 integral constant expression.
//<editor-fold defaultstate="collapsed" desc="EvaluateCPlusPlus11IntegralConstantExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9704,
 FQN="EvaluateCPlusPlus11IntegralConstantExpr", NM="_ZL39EvaluateCPlusPlus11IntegralConstantExprRKN5clang10ASTContextEPKNS_4ExprEPN4llvm6APSIntEPNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZL39EvaluateCPlusPlus11IntegralConstantExprRKN5clang10ASTContextEPKNS_4ExprEPN4llvm6APSIntEPNS_14SourceLocationE")
//</editor-fold>
public static boolean EvaluateCPlusPlus11IntegralConstantExpr(final /*const*/ ASTContext /*&*/ Ctx, 
                                       /*const*/ Expr /*P*/ E, 
                                       APSInt /*P*/ Value, 
                                       type$ptr<SourceLocation> /*P*/ Loc) {
  APValue Result = null;
  try {
    if (!E.getType().$arrow().isIntegralOrEnumerationType()) {
      if (Native.$bool(Loc)) {
        Loc.$star().$assignMove(E.getExprLoc());
      }
      return false;
    }
    
    Result/*J*/= new APValue();
    if (!E.isCXX11ConstantExpr(Ctx, $AddrOf(Result), Loc)) {
      return false;
    }
    if (!Result.isInt()) {
      if (Native.$bool(Loc)) {
        Loc.$star().$assignMove(E.getExprLoc());
      }
      return false;
    }
    if ((Value != null)) {
      /*Deref*/Value.$assign(Result.getInt());
    }
    return true;
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}

} // END OF class ExprConstantStatics
