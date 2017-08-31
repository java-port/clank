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
package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaLambdaStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL18isInInlineFunctionPKN5clang11DeclContextE;_ZL22findEnumForBlockReturnPN5clang10ReturnStmtE;_ZL22findEnumForBlockReturnPN5clang4ExprE;_ZL23mapImplicitCaptureStyleN5clang4sema18CapturingScopeInfo20ImplicitCaptureStyleE;_ZL24adjustBlockReturnsToEnumRN5clang4SemaEN4llvm8ArrayRefIPNS_10ReturnStmtEEENS_8QualTypeE;_ZL25addBlockPointerConversionRN5clang4SemaENS_11SourceRangeEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE;_ZL28addFunctionPointerConversionRN5clang4SemaENS_11SourceRangeEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE;_ZL29findCommonEnumForBlockReturnsN4llvm8ArrayRefIPN5clang10ReturnStmtEEE;_ZL37getGenericLambdaTemplateParameterListPN5clang4sema15LambdaScopeInfoERNS_4SemaE;_ZL37performLambdaVarCaptureInitializationRN5clang4SemaERNS_4sema18CapturingScopeInfo7CaptureEPNS_9FieldDeclERN4llvm15SmallVectorImplIPNS_7VarDeclEEERNS9_IjEE;_ZL49getStackIndexOfNearestEnclosingCaptureReadyLambdaN4llvm8ArrayRefIPKN5clang4sema17FunctionScopeInfoEEEPNS1_7VarDeclE; -static-type=SemaLambdaStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaLambdaStatics {


/// \brief Examines the FunctionScopeInfo stack to determine the nearest
/// enclosing lambda (to the current lambda) that is 'capture-ready' for 
/// the variable referenced in the current lambda (i.e. \p VarToCapture).
/// If successful, returns the index into Sema's FunctionScopeInfo stack
/// of the capture-ready lambda's LambdaScopeInfo.
///  
/// Climbs down the stack of lambdas (deepest nested lambda - i.e. current 
/// lambda - is on top) to determine the index of the nearest enclosing/outer
/// lambda that is ready to capture the \p VarToCapture being referenced in 
/// the current lambda. 
/// As we climb down the stack, we want the index of the first such lambda -
/// that is the lambda with the highest index that is 'capture-ready'. 
/// 
/// A lambda 'L' is capture-ready for 'V' (var or this) if:
///  - its enclosing context is non-dependent
///  - and if the chain of lambdas between L and the lambda in which
///    V is potentially used (i.e. the lambda at the top of the scope info 
///    stack), can all capture or have already captured V.
/// If \p VarToCapture is 'null' then we are trying to capture 'this'.
/// 
/// Note that a lambda that is deemed 'capture-ready' still needs to be checked
/// for whether it is 'capture-capable' (see
/// getStackIndexOfNearestEnclosingCaptureCapableLambda), before it can truly 
/// capture.
///
/// \param FunctionScopes - Sema's stack of nested FunctionScopeInfo's (which a
///  LambdaScopeInfo inherits from).  The current/deepest/innermost lambda
///  is at the top of the stack and has the highest index.
/// \param VarToCapture - the variable to capture.  If NULL, capture 'this'.
///
/// \returns An Optional<unsigned> Index that if evaluates to 'true' contains
/// the index (into Sema's FunctionScopeInfo stack) of the innermost lambda
/// which is capture-ready.  If the return value evaluates to 'false' then
/// no lambda is capture-ready for \p VarToCapture.
//<editor-fold defaultstate="collapsed" desc="getStackIndexOfNearestEnclosingCaptureReadyLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 62,
 FQN="getStackIndexOfNearestEnclosingCaptureReadyLambda", NM="_ZL49getStackIndexOfNearestEnclosingCaptureReadyLambdaN4llvm8ArrayRefIPKN5clang4sema17FunctionScopeInfoEEEPNS1_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL49getStackIndexOfNearestEnclosingCaptureReadyLambdaN4llvm8ArrayRefIPKN5clang4sema17FunctionScopeInfoEEEPNS1_7VarDeclE")
//</editor-fold>
public static /*inline*/ OptionalUInt getStackIndexOfNearestEnclosingCaptureReadyLambda(ArrayRef</*const*/ FunctionScopeInfo /*P*/ > FunctionScopes, 
                                                 VarDecl /*P*/ VarToCapture) {
  // Label failure to capture.
  /*const*/OptionalUInt NoLambdaIsCaptureReady/*J*/= new OptionalUInt();
  assert (isa_LambdaScopeInfo(FunctionScopes.$at(FunctionScopes.size() - 1))) : "The function on the top of sema's function-info stack must be a lambda";
  
  // If VarToCapture is null, we are attempting to capture 'this'.
  /*const*/boolean IsCapturingThis = !(VarToCapture != null);
  /*const*/boolean IsCapturingVariable = !IsCapturingThis;
  
  // Start with the current lambda at the top of the stack (highest index).
  /*uint*/int CurScopeIndex = FunctionScopes.size() - 1;
  DeclContext /*P*/ EnclosingDC = cast_LambdaScopeInfo(FunctionScopes.$at(CurScopeIndex)).CallOperator;
  
  do {
    /*const*/ LambdaScopeInfo /*P*/ LSI = cast_LambdaScopeInfo(FunctionScopes.$at(CurScopeIndex));
    // IF we have climbed down to an intervening enclosing lambda that contains
    // the variable declaration - it obviously can/must not capture the
    // variable.
    // Since its enclosing DC is dependent, all the lambdas between it and the
    // innermost nested lambda are dependent (otherwise we wouldn't have
    // arrived here) - so we don't yet have a lambda that can capture the
    // variable.
    if (IsCapturingVariable
       && VarToCapture.getDeclContext().Equals(EnclosingDC)) {
      return NoLambdaIsCaptureReady;
    }
    
    // For an enclosing lambda to be capture ready for an entity, all
    // intervening lambda's have to be able to capture that entity. If even
    // one of the intervening lambda's is not capable of capturing the entity
    // then no enclosing lambda can ever capture that entity.
    // For e.g.
    // const int x = 10;
    // [=](auto a) {    #1
    //   [](auto b) {   #2 <-- an intervening lambda that can never capture 'x'
    //    [=](auto c) { #3
    //       f(x, c);  <-- can not lead to x's speculative capture by #1 or #2
    //    }; }; };
    // If they do not have a default implicit capture, check to see
    // if the entity has already been explicitly captured.
    // If even a single dependent enclosing lambda lacks the capability
    // to ever capture this variable, there is no further enclosing
    // non-dependent lambda that can capture this variable.
    if (LSI.ImpCaptureStyle == LambdaScopeInfo.ImplicitCaptureStyle.ImpCap_None) {
      if (IsCapturingVariable && !LSI.isCaptured(VarToCapture)) {
        return NoLambdaIsCaptureReady;
      }
      if (IsCapturingThis && !LSI.isCXXThisCaptured()) {
        return NoLambdaIsCaptureReady;
      }
    }
    EnclosingDC = getLambdaAwareParentOfDeclContext(EnclosingDC);
    assert Native.$bool(CurScopeIndex);
    --CurScopeIndex;
  } while (!EnclosingDC.isTranslationUnit()
     && EnclosingDC.isDependentContext()
     && isLambdaCallOperator(EnclosingDC));
  assert ($less_uint(CurScopeIndex, (FunctionScopes.size() - 1)));
  // If the enclosingDC is not dependent, then the immediately nested lambda
  // (one index above) is capture-ready.
  if (!EnclosingDC.isDependentContext()) {
    return new OptionalUInt(JD$T$RR.INSTANCE, CurScopeIndex + 1);
  }
  return NoLambdaIsCaptureReady;
}

//<editor-fold defaultstate="collapsed" desc="getGenericLambdaTemplateParameterList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 224,
 FQN="getGenericLambdaTemplateParameterList", NM="_ZL37getGenericLambdaTemplateParameterListPN5clang4sema15LambdaScopeInfoERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL37getGenericLambdaTemplateParameterListPN5clang4sema15LambdaScopeInfoERNS_4SemaE")
//</editor-fold>
public static /*inline*/ TemplateParameterList /*P*/ getGenericLambdaTemplateParameterList(LambdaScopeInfo /*P*/ LSI, final Sema /*&*/ SemaRef) {
  if ((LSI.GLTemplateParameterList != null)) {
    return LSI.GLTemplateParameterList;
  }
  if (!LSI.AutoTemplateParams.empty()) {
    SourceRange IntroRange = new SourceRange(LSI.IntroducerRange);
    SourceLocation LAngleLoc = IntroRange.getBegin();
    SourceLocation RAngleLoc = IntroRange.getEnd();
    LSI.GLTemplateParameterList = TemplateParameterList.Create(SemaRef.Context, 
        /*Template kw loc*/ new SourceLocation(), new SourceLocation(LAngleLoc), 
        llvm.makeArrayRef(((SmallVector)LSI.AutoTemplateParams).data(), 
            LSI.AutoTemplateParams.size()), 
        new SourceLocation(RAngleLoc));
  }
  return LSI.GLTemplateParameterList;
}


/// \brief Determine whether the given context is or is enclosed in an inline
/// function.
//<editor-fold defaultstate="collapsed" desc="isInInlineFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 265,
 FQN="isInInlineFunction", NM="_ZL18isInInlineFunctionPKN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL18isInInlineFunctionPKN5clang11DeclContextE")
//</editor-fold>
public static boolean isInInlineFunction(/*const*/ DeclContext /*P*/ DC) {
  while (!DC.isFileContext()) {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DC);
      if ((FD != null)) {
        if (FD.isInlined()) {
          return true;
        }
      }
    }
    
    DC = DC.getLexicalParent$Const();
  }
  
  return false;
}


/// If this expression is an enumerator-like expression of some type
/// T, return the type T; otherwise, return null.
///
/// Pointer comparisons on the result here should always work because
/// it's derived from either the parent of an EnumConstantDecl
/// (i.e. the definition) or the declaration returned by
/// EnumType::getDecl() (i.e. the definition).
//<editor-fold defaultstate="collapsed" desc="findEnumForBlockReturn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 496,
 FQN="findEnumForBlockReturn", NM="_ZL22findEnumForBlockReturnPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL22findEnumForBlockReturnPN5clang4ExprE")
//</editor-fold>
public static EnumDecl /*P*/ findEnumForBlockReturn(Expr /*P*/ E) {
  // An expression is an enumerator-like expression of type T if,
  // ignoring parens and parens-like expressions:
  E = E.IgnoreParens();
  {
    
    //  - it is an enumerator whose enum type is T or
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      {
        EnumConstantDecl /*P*/ D = dyn_cast_EnumConstantDecl(DRE.getDecl());
        if ((D != null)) {
          return cast_EnumDecl(D.getDeclContext());
        }
      }
      return null;
    }
  }
  {
    
    //  - it is a comma expression whose RHS is an enumerator-like
    //    expression of type T or
    BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
    if ((BO != null)) {
      if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
        return findEnumForBlockReturn(BO.getRHS());
      }
      return null;
    }
  }
  {
    
    //  - it is a statement-expression whose value expression is an
    //    enumerator-like expression of type T or
    StmtExpr /*P*/ SE = dyn_cast_StmtExpr(E);
    if ((SE != null)) {
      {
        Expr /*P*/ last = dyn_cast_or_null_Expr(SE.getSubStmt().body_back());
        if ((last != null)) {
          return findEnumForBlockReturn(last);
        }
      }
      return null;
    }
  }
  {
    
    //   - it is a ternary conditional operator (not the GNU ?:
    //     extension) whose second and third operands are
    //     enumerator-like expressions of type T or
    ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
    if ((CO != null)) {
      {
        EnumDecl /*P*/ ED = findEnumForBlockReturn(CO.getTrueExpr());
        if ((ED != null)) {
          if (ED == findEnumForBlockReturn(CO.getFalseExpr())) {
            return ED;
          }
        }
      }
      return null;
    }
  }
  {
    
    // (implicitly:)
    //   - it is an implicit integral conversion applied to an
    //     enumerator-like expression of type T or
    ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(E);
    if ((ICE != null)) {
      // We can sometimes see integral conversions in valid
      // enumerator-like expressions.
      if (ICE.getCastKind() == CastKind.CK_IntegralCast) {
        return findEnumForBlockReturn(ICE.getSubExpr());
      }
      // Otherwise, just rely on the type.
    }
  }
  {
    
    //   - it is an expression of that formal enum type.
    /*const*/ EnumType /*P*/ ET = E.getType().$arrow().<EnumType>getAs$EnumType();
    if ((ET != null)) {
      return ET.getDecl();
    }
  }
  
  // Otherwise, nope.
  return null;
}


/// Attempt to find a type T for which the returned expression of the
/// given statement is an enumerator-like expression of that type.
//<editor-fold defaultstate="collapsed" desc="findEnumForBlockReturn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 559,
 FQN="findEnumForBlockReturn", NM="_ZL22findEnumForBlockReturnPN5clang10ReturnStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL22findEnumForBlockReturnPN5clang10ReturnStmtE")
//</editor-fold>
public static EnumDecl /*P*/ findEnumForBlockReturn(ReturnStmt /*P*/ ret) {
  {
    Expr /*P*/ retValue = ret.getRetValue();
    if ((retValue != null)) {
      return findEnumForBlockReturn(retValue);
    }
  }
  return null;
}


/// Attempt to find a common type T for which all of the returned
/// expressions in a block are enumerator-like expressions of that
/// type.
//<editor-fold defaultstate="collapsed" desc="findCommonEnumForBlockReturns">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 568,
 FQN="findCommonEnumForBlockReturns", NM="_ZL29findCommonEnumForBlockReturnsN4llvm8ArrayRefIPN5clang10ReturnStmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL29findCommonEnumForBlockReturnsN4llvm8ArrayRefIPN5clang10ReturnStmtEEE")
//</editor-fold>
public static EnumDecl /*P*/ findCommonEnumForBlockReturns(ArrayRef<ReturnStmt /*P*/ > returns) {
  type$ptr<ReturnStmt /*P*/ /*P*/> i = $tryClone(returns.begin()), /*P*/ e = $tryClone(returns.end());
  
  // Try to find one for the first return.
  EnumDecl /*P*/ ED = findEnumForBlockReturn(i.$star());
  if (!(ED != null)) {
    return null;
  }
  
  // Check that the rest of the returns have the same enum.
  for (i.$preInc(); $noteq_ptr(i, e); i.$preInc()) {
    if (findEnumForBlockReturn(i.$star()) != ED) {
      return null;
    }
  }
  
  // Never infer an anonymous enum type.
  if (!ED.hasNameForLinkage()) {
    return null;
  }
  
  return ED;
}


/// Adjust the given return statements so that they formally return
/// the given type.  It should require, at most, an IntegralCast.
//<editor-fold defaultstate="collapsed" desc="adjustBlockReturnsToEnum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 589,
 FQN="adjustBlockReturnsToEnum", NM="_ZL24adjustBlockReturnsToEnumRN5clang4SemaEN4llvm8ArrayRefIPNS_10ReturnStmtEEENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL24adjustBlockReturnsToEnumRN5clang4SemaEN4llvm8ArrayRefIPNS_10ReturnStmtEEENS_8QualTypeE")
//</editor-fold>
public static void adjustBlockReturnsToEnum(final Sema /*&*/ S, ArrayRef<ReturnStmt /*P*/ > returns, 
                        QualType returnType) {
  for (type$ptr<ReturnStmt /*P*/ /*P*/> i = $tryClone(returns.begin()), /*P*/ e = $tryClone(returns.end()); $noteq_ptr(i, e); i.$preInc()) {
    ReturnStmt /*P*/ ret = i.$star();
    Expr /*P*/ retValue = ret.getRetValue();
    if (S.Context.hasSameType(retValue.getType(), new QualType(returnType))) {
      continue;
    }
    
    // Right now we only support integral fixup casts.
    assert (returnType.$arrow().isIntegralOrUnscopedEnumerationType());
    assert (retValue.getType().$arrow().isIntegralOrUnscopedEnumerationType());
    
    ExprWithCleanups /*P*/ cleanups = dyn_cast_ExprWithCleanups(retValue);
    
    Expr /*P*/ E = ((cleanups != null) ? cleanups.getSubExpr() : retValue);
    E = ImplicitCastExpr.Create(S.Context, new QualType(returnType), CastKind.CK_IntegralCast, 
        E, /*base path*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue);
    if ((cleanups != null)) {
      cleanups.setSubExpr(E);
    } else {
      ret.setRetValue(E);
    }
  }
}


/// \brief Add a lambda's conversion to function pointer, as described in
/// C++11 [expr.prim.lambda]p6.
//<editor-fold defaultstate="collapsed" desc="addFunctionPointerConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 1145,
 FQN="addFunctionPointerConversion", NM="_ZL28addFunctionPointerConversionRN5clang4SemaENS_11SourceRangeEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL28addFunctionPointerConversionRN5clang4SemaENS_11SourceRangeEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE")
//</editor-fold>
public static void addFunctionPointerConversion(final Sema /*&*/ S, 
                            SourceRange IntroducerRange, 
                            CXXRecordDecl /*P*/ Class, 
                            CXXMethodDecl /*P*/ CallOperator) {
  // This conversion is explicitly disabled if the lambda's function has
  // pass_object_size attributes on any of its parameters.
  if (llvm.any_of(CallOperator.parameters(), //std.mem_fn(/*AddrOf*//*FPtr*/ParmVarDecl::<PassObjectSizeAttr>hasAttr)
                 (ParmVarDecl param) -> param.hasAttr(PassObjectSizeAttr.class))) {
    return;
  }
  
  // Add the conversion to function pointer.
  /*const*/ FunctionProtoType /*P*/ CallOpProto = CallOperator.getType().$arrow().getAs(FunctionProtoType.class);
  /*const*/ FunctionProtoType.ExtProtoInfo CallOpExtInfo = CallOpProto.getExtProtoInfo();
  QualType PtrToFunctionTy/*J*/= new QualType();
  QualType InvokerFunctionTy/*J*/= new QualType();
  {
    FunctionProtoType.ExtProtoInfo InvokerExtInfo = new FunctionProtoType.ExtProtoInfo(CallOpExtInfo);
    CallingConv CC = S.Context.getDefaultCallingConvention(CallOpProto.isVariadic(), /*IsCXXMethod=*/ false);
    InvokerExtInfo.ExtInfo.$assignMove(InvokerExtInfo.ExtInfo.withCallingConv(CC));
    InvokerExtInfo.TypeQuals = 0;
    assert (InvokerExtInfo.RefQualifier == RefQualifierKind.RQ_None) : "Lambda's call operator should not have a reference qualifier";
    InvokerFunctionTy.$assignMove(
        S.Context.getFunctionType(CallOpProto.getReturnType(), 
            CallOpProto.getParamTypes(), InvokerExtInfo)
    );
    PtrToFunctionTy.$assignMove(S.Context.getPointerType(new QualType(InvokerFunctionTy)));
  }
  
  // Create the type of the conversion function.
  FunctionProtoType.ExtProtoInfo ConvExtInfo/*J*/= new FunctionProtoType.ExtProtoInfo(S.Context.getDefaultCallingConvention(/*IsVariadic=*/ false, /*IsCXXMethod=*/ true));
  // The conversion function is always const.
  ConvExtInfo.TypeQuals = $uint2uchar(Qualifiers.TQ.Const);
  QualType ConvTy = S.Context.getFunctionType(new QualType(PtrToFunctionTy), new ArrayRef<QualType>(None, false), ConvExtInfo);
  
  SourceLocation Loc = IntroducerRange.getBegin();
  DeclarationName ConversionName = S.Context.DeclarationNames.getCXXConversionFunctionName(S.Context.getCanonicalType(new QualType(PtrToFunctionTy)));
  DeclarationNameLoc ConvNameLoc/*J*/= new DeclarationNameLoc();
  // Construct a TypeSourceInfo for the conversion function, and wire
  // all the parameters appropriately for the FunctionProtoTypeLoc 
  // so that everything works during transformation/instantiation of 
  // generic lambdas.
  // The main reason for wiring up the parameters of the conversion
  // function with that of the call operator is so that constructs
  // like the following work:
  // auto L = [](auto b) {                <-- 1
  //   return [](auto a) -> decltype(a) { <-- 2
  //      return a;
  //   };
  // };
  // int (*fp)(int) = L(5);  
  // Because the trailing return type can contain DeclRefExprs that refer
  // to the original call operator's variables, we hijack the call 
  // operators ParmVarDecls below.
  TypeSourceInfo /*P*/ ConvNamePtrToFunctionTSI = S.Context.getTrivialTypeSourceInfo(new QualType(PtrToFunctionTy), new SourceLocation(Loc));
  ConvNameLoc.Unnamed_field.NamedType.TInfo = ConvNamePtrToFunctionTSI;
  
  // The conversion function is a conversion to a pointer-to-function.
  TypeSourceInfo /*P*/ ConvTSI = S.Context.getTrivialTypeSourceInfo(new QualType(ConvTy), new SourceLocation(Loc));
  FunctionProtoTypeLoc ConvTL = ConvTSI.getTypeLoc().getAs(FunctionProtoTypeLoc.class);
  // Get the result of the conversion function which is a pointer-to-function.
  PointerTypeLoc PtrToFunctionTL = ConvTL.getReturnLoc().getAs(PointerTypeLoc.class);
  // Do the same for the TypeSourceInfo that is used to name the conversion
  // operator.
  PointerTypeLoc ConvNamePtrToFunctionTL = ConvNamePtrToFunctionTSI.getTypeLoc().getAs(PointerTypeLoc.class);
  
  // Get the underlying function types that the conversion function will
  // be converting to (should match the type of the call operator).
  FunctionProtoTypeLoc CallOpConvTL = PtrToFunctionTL.getPointeeLoc().getAs(FunctionProtoTypeLoc.class);
  FunctionProtoTypeLoc CallOpConvNameTL = ConvNamePtrToFunctionTL.getPointeeLoc().getAs(FunctionProtoTypeLoc.class);
  
  // Wire up the FunctionProtoTypeLocs with the call operator's parameters.
  // These parameter's are essentially used to transform the name and
  // the type of the conversion operator.  By using the same parameters
  // as the call operator's we don't have to fix any back references that
  // the trailing return type of the call operator's uses (such as 
  // decltype(some_type<decltype(a)>::type{} + decltype(a){}) etc.)
  // - we can simply use the return type of the call operator, and 
  // everything should work. 
  SmallVector<ParmVarDecl /*P*/ > InvokerParams/*J*/= new SmallVector<ParmVarDecl /*P*/ >(4, (ParmVarDecl /*P*/ )null);
  for (/*uint*/int I = 0, N = CallOperator.getNumParams(); I != N; ++I) {
    ParmVarDecl /*P*/ From = CallOperator.getParamDecl(I);
    
    InvokerParams.push_back(ParmVarDecl.Create(S.Context, 
            // Temporarily add to the TU. This is set to the invoker below.
            S.Context.getTranslationUnitDecl(), 
            From.getLocStart(), 
            From.getLocation(), 
            From.getIdentifier(), 
            From.getType(), 
            From.getTypeSourceInfo(), 
            From.getStorageClass(), 
            /*DefaultArg=*/ (Expr /*P*/ )null));
    CallOpConvTL.setParam(I, From);
    CallOpConvNameTL.setParam(I, From);
  }
  
  CXXConversionDecl /*P*/ Conversion = CXXConversionDecl.Create(S.Context, Class, new SourceLocation(Loc), 
      new DeclarationNameInfo(new DeclarationName(ConversionName), 
          new SourceLocation(Loc), new DeclarationNameLoc(ConvNameLoc)), 
      new QualType(ConvTy), 
      ConvTSI, 
      /*isInline=*/ true, /*isExplicit=*/ false, 
      /*isConstexpr=*/ false, 
      CallOperator.getBody().getLocEnd());
  Conversion.setAccess(AccessSpecifier.AS_public);
  Conversion.setImplicit(true);
  if (Class.isGenericLambda()) {
    // Create a template version of the conversion operator, using the template
    // parameter list of the function call operator.
    FunctionTemplateDecl /*P*/ TemplateCallOperator = CallOperator.getDescribedFunctionTemplate();
    FunctionTemplateDecl /*P*/ ConversionTemplate = FunctionTemplateDecl.Create(S.Context, Class, 
        new SourceLocation(Loc), new DeclarationName(ConversionName), 
        TemplateCallOperator.getTemplateParameters(), 
        Conversion);
    ConversionTemplate.setAccess(AccessSpecifier.AS_public);
    ConversionTemplate.setImplicit(true);
    Conversion.setDescribedFunctionTemplate(ConversionTemplate);
    Class.addDecl(ConversionTemplate);
  } else {
    Class.addDecl(Conversion);
  }
  // Add a non-static member function that will be the result of
  // the conversion with a certain unique ID.
  DeclarationName InvokerName = new DeclarationName($AddrOf(S.Context.Idents.get(getLambdaStaticInvokerName())));
  // FIXME: Instead of passing in the CallOperator->getTypeSourceInfo()
  // we should get a prebuilt TrivialTypeSourceInfo from Context
  // using FunctionTy & Loc and get its TypeLoc as a FunctionProtoTypeLoc
  // then rewire the parameters accordingly, by hoisting up the InvokeParams
  // loop below and then use its Params to set Invoke->setParams(...) below.
  // This would avoid the 'const' qualifier of the calloperator from 
  // contaminating the type of the invoker, which is currently adjusted 
  // in SemaTemplateDeduction.cpp:DeduceTemplateArguments.  Fixing the
  // trailing return type of the invoker would require a visitor to rebuild
  // the trailing return type and adjusting all back DeclRefExpr's to refer
  // to the new static invoker parameters - not the call operator's.
  CXXMethodDecl /*P*/ Invoke = CXXMethodDecl.Create(S.Context, Class, new SourceLocation(Loc), 
      new DeclarationNameInfo(new DeclarationName(InvokerName), new SourceLocation(Loc)), 
      new QualType(InvokerFunctionTy), 
      CallOperator.getTypeSourceInfo(), 
      StorageClass.SC_Static, /*IsInline=*/ true, 
      /*IsConstexpr=*/ false, 
      CallOperator.getBody().getLocEnd());
  for (/*uint*/int I = 0, N = CallOperator.getNumParams(); I != N; ++I)  {
    InvokerParams.$at(I).setOwningFunction(Invoke);
  }
  Invoke.setParams(new ArrayRef<ParmVarDecl /*P*/ >(InvokerParams, true));
  Invoke.setAccess(AccessSpecifier.AS_private);
  Invoke.setImplicit(true);
  if (Class.isGenericLambda()) {
    FunctionTemplateDecl /*P*/ TemplateCallOperator = CallOperator.getDescribedFunctionTemplate();
    FunctionTemplateDecl /*P*/ StaticInvokerTemplate = FunctionTemplateDecl.Create(S.Context, Class, new SourceLocation(Loc), new DeclarationName(InvokerName), 
        TemplateCallOperator.getTemplateParameters(), 
        Invoke);
    StaticInvokerTemplate.setAccess(AccessSpecifier.AS_private);
    StaticInvokerTemplate.setImplicit(true);
    Invoke.setDescribedFunctionTemplate(StaticInvokerTemplate);
    Class.addDecl(StaticInvokerTemplate);
  } else {
    Class.addDecl(Invoke);
  }
}


/// \brief Add a lambda's conversion to block pointer.
//<editor-fold defaultstate="collapsed" desc="addBlockPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 1327,
 FQN="addBlockPointerConversion", NM="_ZL25addBlockPointerConversionRN5clang4SemaENS_11SourceRangeEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL25addBlockPointerConversionRN5clang4SemaENS_11SourceRangeEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE")
//</editor-fold>
public static void addBlockPointerConversion(final Sema /*&*/ S, 
                         SourceRange IntroducerRange, 
                         CXXRecordDecl /*P*/ Class, 
                         CXXMethodDecl /*P*/ CallOperator) {
  /*const*/ FunctionProtoType /*P*/ Proto = CallOperator.getType().$arrow().getAs(FunctionProtoType.class);
  
  // The function type inside the block pointer type is the same as the call
  // operator with some tweaks. The calling convention is the default free
  // function convention, and the type qualifications are lost.
  FunctionProtoType.ExtProtoInfo BlockEPI = Proto.getExtProtoInfo();
  BlockEPI.ExtInfo.$assignMove(
      BlockEPI.ExtInfo.withCallingConv(S.Context.getDefaultCallingConvention(Proto.isVariadic(), /*IsCXXMethod=*/ false))
  );
  BlockEPI.TypeQuals = 0;
  QualType FunctionTy = S.Context.getFunctionType(Proto.getReturnType(), Proto.getParamTypes(), BlockEPI);
  QualType BlockPtrTy = S.Context.getBlockPointerType(new QualType(FunctionTy));
  
  FunctionProtoType.ExtProtoInfo ConversionEPI/*J*/= new FunctionProtoType.ExtProtoInfo(S.Context.getDefaultCallingConvention(/*IsVariadic=*/ false, /*IsCXXMethod=*/ true));
  ConversionEPI.TypeQuals = $uint2uchar(Qualifiers.TQ.Const);
  QualType ConvTy = S.Context.getFunctionType(new QualType(BlockPtrTy), new ArrayRef<QualType>(None, false), ConversionEPI);
  
  SourceLocation Loc = IntroducerRange.getBegin();
  DeclarationName Name = S.Context.DeclarationNames.getCXXConversionFunctionName(S.Context.getCanonicalType(new QualType(BlockPtrTy)));
  DeclarationNameLoc NameLoc/*J*/= new DeclarationNameLoc();
  NameLoc.Unnamed_field.NamedType.TInfo = S.Context.getTrivialTypeSourceInfo(new QualType(BlockPtrTy), new SourceLocation(Loc));
  CXXConversionDecl /*P*/ Conversion = CXXConversionDecl.Create(S.Context, Class, new SourceLocation(Loc), 
      new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(Loc), new DeclarationNameLoc(NameLoc)), 
      new QualType(ConvTy), 
      S.Context.getTrivialTypeSourceInfo(new QualType(ConvTy), new SourceLocation(Loc)), 
      /*isInline=*/ true, /*isExplicit=*/ false, 
      /*isConstexpr=*/ false, 
      CallOperator.getBody().getLocEnd());
  Conversion.setAccess(AccessSpecifier.AS_public);
  Conversion.setImplicit(true);
  Class.addDecl(Conversion);
}

//<editor-fold defaultstate="collapsed" desc="performLambdaVarCaptureInitialization">
@Converted(kind = Converted.Kind.MANUAL/*PERF*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 1371,
 FQN="performLambdaVarCaptureInitialization", NM="_ZL37performLambdaVarCaptureInitializationRN5clang4SemaERNS_4sema18CapturingScopeInfo7CaptureEPNS_9FieldDeclERN4llvm15SmallVectorImplIPNS_7VarDeclEEERNS9_IjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL37performLambdaVarCaptureInitializationRN5clang4SemaERNS_4sema18CapturingScopeInfo7CaptureEPNS_9FieldDeclERN4llvm15SmallVectorImplIPNS_7VarDeclEEERNS9_IjEE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > performLambdaVarCaptureInitialization(final Sema /*&*/ S, final LambdaScopeInfo.Capture /*&*/ Capture, 
                                     FieldDecl /*P*/ Field, 
                                     final SmallVectorImpl<VarDecl /*P*/ > /*&*/ ArrayIndexVars, 
                                     final SmallVectorImplUInt/*&*/ ArrayIndexStarts) {
  InitializationSequence Init = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (Capture.isVariableCapture()) : "not a variable capture";
    
    VarDecl /*P*/ Var = Capture.getVariable();
    SourceLocation Loc = Capture.getLocation();
    
    // C++11 [expr.prim.lambda]p21:
    //   When the lambda-expression is evaluated, the entities that
    //   are captured by copy are used to direct-initialize each
    //   corresponding non-static data member of the resulting closure
    //   object. (For array members, the array elements are
    //   direct-initialized in increasing subscript order.) These
    //   initializations are performed in the (unspecified) order in
    //   which the non-static data members are declared.
    
    // C++ [expr.prim.lambda]p12:
    //   An entity captured by a lambda-expression is odr-used (3.2) in
    //   the scope containing the lambda-expression.
    ActionResultTTrue<Expr /*P*/ > RefResult = $c$.clean(S.BuildDeclarationNameExpr($c$.track(new CXXScopeSpec()), new DeclarationNameInfo(Var.getDeclName(), new SourceLocation(Loc)), Var));
    if (RefResult.isInvalid()) {
      return ExprError();
    }
    Expr /*P*/ Ref = RefResult.get();
    
    QualType FieldType = Field.getType();
    
    // When the variable has array type, create index variables for each
    // dimension of the array. We use these index variables to subscript
    // the source array, and other clients (e.g., CodeGen) will perform
    // the necessary iteration with these index variables.
    //
    // FIXME: This is dumb. Add a proper AST representation for array
    // copy-construction and use it here.
    SmallVector<VarDecl /*P*/ > IndexVariables/*J*/= new SmallVector<VarDecl /*P*/ >(4, (VarDecl /*P*/ )null);
    QualType BaseType = new QualType(FieldType);
    QualType SizeType = S.Context.getSizeType().$QualType();
    ArrayIndexStarts.push_back(ArrayIndexVars.size());
    {
      /*const*/ ConstantArrayType /*P*/ Array;
      while (((/*P*/ Array = S.Context.getAsConstantArrayType(new QualType(BaseType))) != null)) {
        // Create the iteration variable for this array index.
        IdentifierInfo /*P*/ IterationVarName = null;
        {
          raw_svector_ostream OS = null;
          try {
            SmallString/*8*/ Str/*J*/= new SmallString/*8*/(8);
            OS/*J*/= new raw_svector_ostream(Str);
            OS.$out(/*KEEP_STR*/"__i").$out_uint(IndexVariables.size());
            assert Str.equals(OS.str()) : "JAVA: expects the same content " + Str + " vs. " + OS.str();
            IterationVarName = $AddrOf(S.Context.Idents.get(/*JAVA*/Str));
          } finally {
            if (OS != null) { OS.$destroy(); }
          }
        }
        VarDecl /*P*/ IterationVar = VarDecl.Create(S.Context, S.CurContext, new SourceLocation(Loc), new SourceLocation(Loc), IterationVarName, new QualType(SizeType), 
            S.Context.getTrivialTypeSourceInfo(new QualType(SizeType), new SourceLocation(Loc)), StorageClass.SC_None);
        IterationVar.setImplicit();
        IndexVariables.push_back(IterationVar);
        ArrayIndexVars.push_back(IterationVar);
        
        // Create a reference to the iteration variable.
        ActionResultTTrue<Expr /*P*/ > IterationVarRef = S.BuildDeclRefExpr(IterationVar, new QualType(SizeType), ExprValueKind.VK_LValue, new SourceLocation(Loc));
        assert (!IterationVarRef.isInvalid()) : "Reference to invented variable cannot fail!";
        IterationVarRef.$assignMove(S.DefaultLvalueConversion(IterationVarRef.get()));
        assert (!IterationVarRef.isInvalid()) : "Conversion of invented variable cannot fail!";
        
        // Subscript the array with this iteration variable.
        ActionResultTTrue<Expr /*P*/ > Subscript = S.CreateBuiltinArraySubscriptExpr(Ref, new SourceLocation(Loc), IterationVarRef.get(), new SourceLocation(Loc));
        if (Subscript.isInvalid()) {
          return ExprError();
        }
        
        Ref = Subscript.get();
        BaseType.$assignMove(Array.getElementType());
      }
    }
    
    // Construct the entity that we will be initializing. For an array, this
    // will be first element in the array, which may require several levels
    // of array-subscript entities. 
    SmallVector<InitializedEntity> Entities/*J*/= new SmallVector<InitializedEntity>(4, new InitializedEntity());
    Entities.reserve(1 + IndexVariables.size());
    Entities.push_back(InitializedEntity.InitializeLambdaCapture(Var.getIdentifier(), new QualType(FieldType), new SourceLocation(Loc)));
    for (/*uint*/int I = 0, N = IndexVariables.size(); I != N; ++I)  {
      Entities.push_back(InitializedEntity.InitializeElement(S.Context, 0, Entities.back()));
    }
    
    InitializationKind InitKind = InitializationKind.CreateDirect(new SourceLocation(Loc), new SourceLocation(Loc), new SourceLocation(Loc));
    Init/*J*/= new InitializationSequence(S, Entities.back(), InitKind, new MutableArrayRef<Expr /*P*/ >(Ref, true));
    return Init.Perform(S, Entities.back(), InitKind, new MutableArrayRef<Expr /*P*/ >(Ref, true));
  } finally {
    if (Init != null) { Init.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="mapImplicitCaptureStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 1471,
 FQN="mapImplicitCaptureStyle", NM="_ZL23mapImplicitCaptureStyleN5clang4sema18CapturingScopeInfo20ImplicitCaptureStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZL23mapImplicitCaptureStyleN5clang4sema18CapturingScopeInfo20ImplicitCaptureStyleE")
//</editor-fold>
public static LambdaCaptureDefault mapImplicitCaptureStyle(CapturingScopeInfo.ImplicitCaptureStyle ICS) {
  switch (ICS) {
   case ImpCap_None:
    return LambdaCaptureDefault.LCD_None;
   case ImpCap_LambdaByval:
    return LambdaCaptureDefault.LCD_ByCopy;
   case ImpCap_CapturedRegion:
   case ImpCap_LambdaByref:
    return LambdaCaptureDefault.LCD_ByRef;
   case ImpCap_Block:
    throw new llvm_unreachable("block capture in lambda");
  }
  throw new llvm_unreachable("Unknown implicit capture style");
}

} // END OF class SemaLambdaStatics
