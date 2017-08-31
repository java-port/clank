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
package org.clang.sema;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.aliases.*;
import org.clang.ast.FunctionProtoType.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.sema.Sema.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.sema.java.SemaJavaDifferentiators.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.basic.java.OptionalNotes;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaTemplateDeduction">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaTemplateDeduction",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaTemplate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema13SubstAutoTypeENS_8QualTypeES1_;_ZN5clang4Sema14DeduceAutoTypeENS_7TypeLocERPNS_4ExprERNS_8QualTypeE;_ZN5clang4Sema14DeduceAutoTypeEPNS_14TypeSourceInfoERPNS_4ExprERNS_8QualTypeE;_ZN5clang4Sema16DeduceReturnTypeEPNS_12FunctionDeclENS_14SourceLocationEb;_ZN5clang4Sema18getMostSpecializedENS_21UnresolvedSetIteratorES1_RNS_24TemplateSpecCandidateSetENS_14SourceLocationERKNS_17PartialDiagnosticES7_S7_bNS_8QualTypeE;_ZN5clang4Sema19adjustCCAndNoReturnENS_8QualTypeES1_;_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclENS_8QualTypeERPNS_17CXXConversionDeclERNS_4sema21TemplateDeductionInfoE;_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb;_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoENS_8QualTypeERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb;_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb;_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_36VarTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERNS_4sema21TemplateDeductionInfoE;_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_38ClassTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERNS_4sema21TemplateDeductionInfoE;_ZN5clang4Sema23SubstAutoTypeSourceInfoEPNS_14TypeSourceInfoENS_8QualTypeE;_ZN5clang4Sema26MarkUsedTemplateParametersERKNS_20TemplateArgumentListEbjRN4llvm14SmallBitVectorE;_ZN5clang4Sema26getMoreSpecializedTemplateEPNS_20FunctionTemplateDeclES2_NS_14SourceLocationENS_30TemplatePartialOrderingContextEjj;_ZN5clang4Sema28DiagnoseAutoDeductionFailureEPNS_7VarDeclEPNS_4ExprE;_ZN5clang4Sema29MarkDeducedTemplateParametersERNS_10ASTContextEPKNS_20FunctionTemplateDeclERN4llvm14SmallBitVectorE;_ZN5clang4Sema30isSameOrCompatibleFunctionTypeENS_7CanQualINS_4TypeEEES3_;_ZN5clang4Sema31FinishTemplateArgumentDeductionEPNS_20FunctionTemplateDeclERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjRPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEPKNS4_INS0_15OriginalCallArgEEEb;_ZN5clang4Sema35SubstituteExplicitTemplateArgumentsEPNS_20FunctionTemplateDeclERNS_24TemplateArgumentListInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS6_INS_8QualTypeEEEPSA_RNS_4sema21TemplateDeductionInfoE;_ZN5clang4Sema39getMoreSpecializedPartialSpecializationEPNS_36VarTemplatePartialSpecializationDeclES2_NS_14SourceLocationE;_ZN5clang4Sema39getMoreSpecializedPartialSpecializationEPNS_38ClassTemplatePartialSpecializationDeclES2_NS_14SourceLocationE; -static-type=Sema_SemaTemplateDeduction -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaTemplateDeduction extends Sema_SemaTemplate {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// \brief Compare types for equality with respect to possibly compatible
/// function types (noreturn adjustment, implicit calling conventions). If any
/// of parameter and argument is not a function, just perform type comparison.
///
/// \param Param the template parameter type.
///
/// \param Arg the argument type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isSameOrCompatibleFunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 895,
 FQN="clang::Sema::isSameOrCompatibleFunctionType", NM="_ZN5clang4Sema30isSameOrCompatibleFunctionTypeENS_7CanQualINS_4TypeEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema30isSameOrCompatibleFunctionTypeENS_7CanQualINS_4TypeEEES3_")
//</editor-fold>
public final boolean isSameOrCompatibleFunctionType(CanQual<Type> Param, 
                              CanQual<Type> Arg) {
  /*const*/ FunctionType /*P*/ ParamFunction = ((CanProxyFunctionType)((CanProxyType)Param.$arrow(Type.class)).$arrow().getAs(FunctionType.class)).$T$C$P();
  /*const*/ FunctionType /*P*/ ArgFunction = ((CanProxyFunctionType)((CanProxyType)Arg.$arrow(Type.class)).$arrow().getAs(FunctionType.class)).$T$C$P();
  
  // Just compare if not functions.
  if (!(ParamFunction != null) || !(ArgFunction != null)) {
    return $eq_CanQual$T_CanQual$U(/*NO_COPY*/Param, /*NO_COPY*/Arg);
  }
  
  // Noreturn adjustment.
  QualType AdjustedParam/*J*/= new QualType();
  if ($this().IsNoReturnConversion(Param.$QualType(), Arg.$QualType(), AdjustedParam)) {
    return $eq_CanQual$T_CanQual$U(/*NO_COPY*/Arg, $this().Context.getCanonicalType(/*NO_COPY*/AdjustedParam));
  }
  
  // FIXME: Compatible calling conventions.
  return $eq_CanQual$T_CanQual$U(/*NO_COPY*/Param, /*NO_COPY*/Arg);
}


//===--------------------------------------------------------------------===//
// C++ Template Argument Deduction (C++ [temp.deduct])
//===--------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::adjustCCAndNoReturn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3513,
 FQN="clang::Sema::adjustCCAndNoReturn", NM="_ZN5clang4Sema19adjustCCAndNoReturnENS_8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema19adjustCCAndNoReturnENS_8QualTypeES1_")
//</editor-fold>
public final QualType adjustCCAndNoReturn(QualType ArgFunctionType, 
                   QualType FunctionType) {
  if (ArgFunctionType.isNull()) {
    return new QualType(JD$Move.INSTANCE, ArgFunctionType);
  }
  
  /*const*/ FunctionProtoType /*P*/ FunctionTypeP = FunctionType.$arrow().castAs(FunctionProtoType.class);
  CallingConv CC = FunctionTypeP.getCallConv();
  boolean NoReturn = FunctionTypeP.getNoReturnAttr();
  /*const*/ FunctionProtoType /*P*/ ArgFunctionTypeP = ArgFunctionType.$arrow().getAs(FunctionProtoType.class);
  if (ArgFunctionTypeP.getCallConv() == CC
     && ArgFunctionTypeP.getNoReturnAttr() == NoReturn) {
    return new QualType(JD$Move.INSTANCE, ArgFunctionType);
  }
  
  FunctionType.ExtInfo EI = ArgFunctionTypeP.getExtInfo().withCallingConv(CC);
  EI.$assignMove(EI.withNoReturn(NoReturn));
  ArgFunctionTypeP
     = cast_FunctionProtoType($this().Context.adjustFunctionType(ArgFunctionTypeP, new FunctionType.ExtInfo(EI)));
  return new QualType(ArgFunctionTypeP, 0);
}


/// \brief Perform template argument deduction to determine whether
/// the given template arguments match the given class template
/// partial specialization per C++ [temp.class.spec.match].
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceTemplateArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2261,
 FQN="clang::Sema::DeduceTemplateArguments", NM="_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_38ClassTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERNS_4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_38ClassTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERNS_4sema21TemplateDeductionInfoE")
//</editor-fold>
public final Sema.TemplateDeductionResult DeduceTemplateArguments4(ClassTemplatePartialSpecializationDecl /*P*/ Partial, 
                        final /*const*/ TemplateArgumentList /*&*/ TemplateArgs, 
                        final TemplateDeductionInfo /*&*/ Info) {
  EnterExpressionEvaluationContext Unevaluated = null;
  SFINAETrap Trap = null;
  InstantiatingTemplate Inst = null;
  try {
    if (Partial.isInvalidDecl()) {
      return TemplateDeductionResult.TDK_Invalid;
    }
    
    // C++ [temp.class.spec.match]p2:
    //   A partial specialization matches a given actual template
    //   argument list if the template arguments of the partial
    //   specialization can be deduced from the actual template argument
    //   list (14.8.2).
    
    // Unevaluated SFINAE context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    Trap/*J*/= new SFINAETrap(/*Deref*/$this());
    
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    Deduced.resize(Partial.getTemplateParameters().size());
    {
      TemplateDeductionResult Result = /*::*/SemaTemplateDeductionStatics.DeduceTemplateArguments(/*Deref*/$this(), 
          Partial.getTemplateParameters(), 
          Partial.getTemplateArgs(), 
          TemplateArgs, Info, Deduced);
      if ((Result.getValue() != 0)) {
        return Result;
      }
    }
    
    SmallVector<TemplateArgument> DeducedArgs/*J*/= new SmallVector<TemplateArgument>(JD$T.INSTANCE, 4, Deduced.begin(), Deduced.end(), new TemplateArgument());
    Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_ClassTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange.INSTANCE, /*Deref*/$this(), Info.getLocation(), Partial, new ArrayRef<TemplateArgument>(DeducedArgs, false), 
        Info);
    if (Inst.isInvalid()) {
      return TemplateDeductionResult.TDK_InstantiationDepth;
    }
    if (Trap.hasErrorOccurred()) {
      return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    
    return /*::*/SemaTemplateDeductionStatics.FinishTemplateArgumentDeduction1(/*Deref*/$this(), Partial, TemplateArgs, 
        Deduced, Info);
  } finally {
    if (Inst != null) { Inst.$destroy(); }
    if (Trap != null) { Trap.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}


/// \brief Perform template argument deduction to determine whether
/// the given template arguments match the given variable template
/// partial specialization per C++ [temp.class.spec.match].
/// TODO: Unify with ClassTemplatePartialSpecializationDecl version?
///       May require unifying ClassTemplate(Partial)SpecializationDecl and
///        VarTemplate(Partial)SpecializationDecl with a new data
///        structure Template(Partial)SpecializationDecl, and
///        using Template(Partial)SpecializationDecl as input type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceTemplateArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2402,
 FQN="clang::Sema::DeduceTemplateArguments", NM="_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_36VarTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERNS_4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_36VarTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERNS_4sema21TemplateDeductionInfoE")
//</editor-fold>
public final Sema.TemplateDeductionResult DeduceTemplateArguments(VarTemplatePartialSpecializationDecl /*P*/ Partial, 
                       final /*const*/ TemplateArgumentList /*&*/ TemplateArgs, 
                       final TemplateDeductionInfo /*&*/ Info) {
  EnterExpressionEvaluationContext Unevaluated = null;
  SFINAETrap Trap = null;
  InstantiatingTemplate Inst = null;
  try {
    if (Partial.isInvalidDecl()) {
      return TemplateDeductionResult.TDK_Invalid;
    }
    
    // C++ [temp.class.spec.match]p2:
    //   A partial specialization matches a given actual template
    //   argument list if the template arguments of the partial
    //   specialization can be deduced from the actual template argument
    //   list (14.8.2).
    
    // Unevaluated SFINAE context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    Trap/*J*/= new SFINAETrap(/*Deref*/$this());
    
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    Deduced.resize(Partial.getTemplateParameters().size());
    {
      TemplateDeductionResult Result = /*::*/SemaTemplateDeductionStatics.DeduceTemplateArguments(/*Deref*/$this(), Partial.getTemplateParameters(), Partial.getTemplateArgs(), 
          TemplateArgs, Info, Deduced);
      if ((Result.getValue() != 0)) {
        return Result;
      }
    }
    
    SmallVector<TemplateArgument> DeducedArgs/*J*/= new SmallVector<TemplateArgument>(JD$T.INSTANCE, 4, Deduced.begin(), Deduced.end(), new TemplateArgument());
    Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_VarTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange.INSTANCE, /*Deref*/$this(), Info.getLocation(), Partial, new ArrayRef<TemplateArgument>(DeducedArgs, false), 
        Info);
    if (Inst.isInvalid()) {
      return TemplateDeductionResult.TDK_InstantiationDepth;
    }
    if (Trap.hasErrorOccurred()) {
      return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    
    return /*::*/SemaTemplateDeductionStatics.FinishTemplateArgumentDeduction2(/*Deref*/$this(), Partial, TemplateArgs, 
        Deduced, Info);
  } finally {
    if (Inst != null) { Inst.$destroy(); }
    if (Trap != null) { Trap.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}


/// \brief Substitute the explicitly-provided template arguments into the
/// given function template according to C++ [temp.arg.explicit].
///
/// \param FunctionTemplate the function template into which the explicit
/// template arguments will be substituted.
///
/// \param ExplicitTemplateArgs the explicitly-specified template
/// arguments.
///
/// \param Deduced the deduced template arguments, which will be populated
/// with the converted and checked explicit template arguments.
///
/// \param ParamTypes will be populated with the instantiated function
/// parameters.
///
/// \param FunctionType if non-NULL, the result type of the function template
/// will also be instantiated and the pointed-to value will be updated with
/// the instantiated function type.
///
/// \param Info if substitution fails for any reason, this object will be
/// populated with more information about the failure.
///
/// \returns TDK_Success if substitution was successful, or some failure
/// condition.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstituteExplicitTemplateArguments">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2472,
 FQN="clang::Sema::SubstituteExplicitTemplateArguments", NM="_ZN5clang4Sema35SubstituteExplicitTemplateArgumentsEPNS_20FunctionTemplateDeclERNS_24TemplateArgumentListInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS6_INS_8QualTypeEEEPSA_RNS_4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema35SubstituteExplicitTemplateArgumentsEPNS_20FunctionTemplateDeclERNS_24TemplateArgumentListInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS6_INS_8QualTypeEEEPSA_RNS_4sema21TemplateDeductionInfoE")
//</editor-fold>
public final Sema.TemplateDeductionResult SubstituteExplicitTemplateArguments(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                                   final TemplateArgumentListInfo /*&*/ ExplicitTemplateArgs, 
                                   final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                                   final SmallVectorImpl<QualType> /*&*/ ParamTypes, 
                                   type$ptr<QualType /*P*/> FunctionType, 
                                   final TemplateDeductionInfo /*&*/ Info) {
  EnterExpressionEvaluationContext Unevaluated = null;
  SFINAETrap Trap = null;
  InstantiatingTemplate Inst = null;
  ContextRAII SavedContext = null;
  LocalInstantiationScope InstScope = null;
  ExtParameterInfoBuilder ExtParamInfos = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FunctionDecl /*P*/ Function = FunctionTemplate.getTemplatedDecl();
    TemplateParameterList /*P*/ TemplateParams = FunctionTemplate.getTemplateParameters();
    if (ExplicitTemplateArgs.size() == 0) {
      // No arguments to substitute; just copy over the parameter types and
      // fill in the function type.
      for (ParmVarDecl /*P*/ P : Function.parameters())  {
        ParamTypes.push_back(P.getType());
      }
      if (Native.$bool(FunctionType)) {
        FunctionType.$star().$assignMove(Function.getType());
      }
      return TemplateDeductionResult.TDK_Success;
    }
    
    // Unevaluated SFINAE context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    Trap/*J*/= new SFINAETrap(/*Deref*/$this());
    
    // C++ [temp.arg.explicit]p3:
    //   Template arguments that are present shall be specified in the
    //   declaration order of their corresponding template-parameters. The
    //   template argument list shall not specify more template-arguments than
    //   there are corresponding template-parameters.
    SmallVector<TemplateArgument> Builder/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    
    // Enter a new template instantiation context where we check the
    // explicitly-specified template arguments against this function template,
    // and then substitute them into the function parameter types.
    SmallVector<TemplateArgument> DeducedArgs/*J*/= new SmallVector<TemplateArgument>(JD$T.INSTANCE, 4, Deduced.begin(), Deduced.end(), new TemplateArgument());
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), Info.getLocation(), FunctionTemplate, 
        new ArrayRef<TemplateArgument>(DeducedArgs, false), 
        ActiveTemplateInstantiation.InstantiationKind.ExplicitTemplateArgumentSubstitution, 
        Info);
    if (Inst.isInvalid()) {
      return TemplateDeductionResult.TDK_InstantiationDepth;
    }
    if ($this().CheckTemplateArgumentList(FunctionTemplate, 
        new SourceLocation(), 
        ExplicitTemplateArgs, 
        true, 
        Builder) || Trap.hasErrorOccurred()) {
      /*uint*/int Index = Builder.size();
      if ($greatereq_uint(Index, TemplateParams.size())) {
        Index = TemplateParams.size() - 1;
      }
      Info.Param.$assignMove(SemaTemplateDeductionStatics.makeTemplateParameter(TemplateParams.getParam(Index)));
      return TemplateDeductionResult.TDK_InvalidExplicitArguments;
    }
    
    // Form the template argument list from the explicitly-specified
    // template arguments.
    TemplateArgumentList /*P*/ ExplicitArgumentList = TemplateArgumentList.CreateCopy($this().Context, new ArrayRef<TemplateArgument>(Builder, false));
    Info.reset(ExplicitArgumentList);
    
    // Template argument deduction and the final substitution should be
    // done in the context of the templated declaration.  Explicit
    // argument substitution, on the other hand, needs to happen in the
    // calling context.
    SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), FunctionTemplate.getTemplatedDecl());
    
    // If we deduced template arguments for a template parameter pack,
    // note that the template argument pack is partially substituted and record
    // the explicit template arguments. They'll be used as part of deduction
    // for this template parameter pack.
    for (/*uint*/int I = 0, N = Builder.size(); I != N; ++I) {
      final /*const*/ TemplateArgument /*&*/ Arg = Builder.$at(I);
      if (Arg.getKind() == TemplateArgument.ArgKind.Pack) {
        $this().CurrentInstantiationScope.SetPartiallySubstitutedPack(TemplateParams.getParam(I), 
            Arg.pack_begin(), 
            Arg.pack_size());
        break;
      }
    }
    
    /*const*/ FunctionProtoType /*P*/ Proto = Function.getType().$arrow().getAs(FunctionProtoType.class);
    assert ((Proto != null)) : "Function template does not have a prototype?";
    
    // Isolate our substituted parameters from our caller.
    InstScope/*J*/= new LocalInstantiationScope(/*Deref*/$this(), /*MergeWithOuterScope*/ true);
    
    ExtParamInfos/*J*/= new ExtParameterInfoBuilder();
    
    // Instantiate the types of each of the function parameters given the
    // explicitly-specified template arguments. If the function has a trailing
    // return type, substitute it after the arguments to ensure we substitute
    // in lexical order.
    if (Proto.hasTrailingReturn()) {
      if ($c$.clean($this().SubstParmTypes(Function.getLocation(), new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, Function.parameters()), 
          Proto.getExtParameterInfosOrNull(), 
          $c$.track(new MultiLevelTemplateArgumentList($Deref(ExplicitArgumentList))), 
          ParamTypes, /*params*/ (SmallVectorImpl<ParmVarDecl /*P*/ > /*P*/ )null, ExtParamInfos))) {
        return TemplateDeductionResult.TDK_SubstitutionFailure;
      }
    }
    
    // Instantiate the return type.
    QualType ResultType/*J*/= new QualType();
    {
      CXXThisScopeRAII ThisScope = null;
      try {
        // C++11 [expr.prim.general]p3:
        //   If a declaration declares a member function or member function 
        //   template of a class X, the expression this is a prvalue of type 
        //   "pointer to cv-qualifier-seq X" between the optional cv-qualifer-seq
        //   and the end of the function-definition, member-declarator, or 
        //   declarator.
        /*uint*/int ThisTypeQuals = 0;
        CXXRecordDecl /*P*/ ThisContext = null;
        {
          CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Function);
          if ((Method != null)) {
            ThisContext = Method.getParent();
            ThisTypeQuals = Method.getTypeQualifiers();
          }
        }
        
        ThisScope/*J*/= new CXXThisScopeRAII(/*Deref*/$this(), ThisContext, ThisTypeQuals, 
            $this().getLangOpts().CPlusPlus11);
        
        $c$.clean(ResultType.$assignMove(
            $this().SubstType(Proto.getReturnType(), 
                $c$.track(new MultiLevelTemplateArgumentList($Deref(ExplicitArgumentList))), 
                Function.getTypeSpecStartLoc(), Function.getDeclName())
        ));
        if (ResultType.isNull() || Trap.hasErrorOccurred()) {
          return TemplateDeductionResult.TDK_SubstitutionFailure;
        }
      } finally {
        if (ThisScope != null) { ThisScope.$destroy(); }
      }
    }
    
    // Instantiate the types of each of the function parameters given the
    // explicitly-specified template arguments if we didn't do so earlier.
    if ($c$.clean(!Proto.hasTrailingReturn()
       && $this().SubstParmTypes(Function.getLocation(), new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, Function.parameters()), 
        Proto.getExtParameterInfosOrNull(), 
        $c$.track(new MultiLevelTemplateArgumentList($Deref(ExplicitArgumentList))), 
        ParamTypes, /*params*/ (SmallVectorImpl<ParmVarDecl /*P*/ > /*P*/ )null, ExtParamInfos))) {
      return TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    if (Native.$bool(FunctionType)) {
      ExtProtoInfo EPI = Proto.getExtProtoInfo();
      EPI.ExtParameterInfos = ExtParamInfos.getPointerOrNull(ParamTypes.size());
      FunctionType.$star().$assignMove($this().BuildFunctionType(new QualType(ResultType), new MutableArrayRef<QualType>(ParamTypes, false), 
              Function.getLocation(), 
              Function.getDeclName(), 
              EPI));
      if (FunctionType./*->*/$star().isNull() || Trap.hasErrorOccurred()) {
        return TemplateDeductionResult.TDK_SubstitutionFailure;
      }
    }
    
    // C++ [temp.arg.explicit]p2:
    //   Trailing template arguments that can be deduced (14.8.2) may be
    //   omitted from the list of explicit template-arguments. If all of the
    //   template arguments can be deduced, they may all be omitted; in this
    //   case, the empty template argument list <> itself may also be omitted.
    //
    // Take all of the explicitly-specified arguments and put them into
    // the set of deduced template arguments. Explicitly-specified
    // parameter packs, however, will be set to NULL since the deduction
    // mechanisms handle explicitly-specified argument packs directly.
    Deduced.reserve(TemplateParams.size());
    for (/*uint*/int I = 0, N = ExplicitArgumentList.size(); I != N; ++I) {
      final /*const*/ TemplateArgument /*&*/ Arg = ExplicitArgumentList.get(I);
      if (Arg.getKind() == TemplateArgument.ArgKind.Pack) {
        Deduced.push_back(new DeducedTemplateArgument());
      } else {
        Deduced.push_back(new DeducedTemplateArgument(Arg));
      }
    }
    
    return TemplateDeductionResult.TDK_Success;
  } finally {
    if (ExtParamInfos != null) { ExtParamInfos.$destroy(); }
    if (InstScope != null) { InstScope.$destroy(); }
    if (SavedContext != null) { SavedContext.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
    if (Trap != null) { Trap.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Finish template argument deduction for a function template,
/// checking the deduced template arguments for completeness and forming
/// the function template specialization.
///
/// \param OriginalCallArgs If non-NULL, the original call arguments against
/// which the deduced argument types should be compared.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FinishTemplateArgumentDeduction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2754,
 FQN="clang::Sema::FinishTemplateArgumentDeduction", NM="_ZN5clang4Sema31FinishTemplateArgumentDeductionEPNS_20FunctionTemplateDeclERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjRPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEPKNS4_INS0_15OriginalCallArgEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema31FinishTemplateArgumentDeductionEPNS_20FunctionTemplateDeclERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjRPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEPKNS4_INS0_15OriginalCallArgEEEb")
//</editor-fold>
public final Sema.TemplateDeductionResult FinishTemplateArgumentDeduction(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                               final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                               /*uint*/int NumExplicitlySpecified, 
                               final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, 
                               final TemplateDeductionInfo /*&*/ Info) {
  return FinishTemplateArgumentDeduction(FunctionTemplate, 
                               Deduced, 
                               NumExplicitlySpecified, 
                               Specialization, 
                               Info, 
                               (/*const*/ SmallVectorImpl<OriginalCallArg> /*P*/ )null, 
                               false);
}
public final Sema.TemplateDeductionResult FinishTemplateArgumentDeduction(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                               final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                               /*uint*/int NumExplicitlySpecified, 
                               final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, 
                               final TemplateDeductionInfo /*&*/ Info, 
                               /*const*/ SmallVectorImpl<OriginalCallArg> /*P*/ OriginalCallArgs/*= null*/) {
  return FinishTemplateArgumentDeduction(FunctionTemplate, 
                               Deduced, 
                               NumExplicitlySpecified, 
                               Specialization, 
                               Info, 
                               OriginalCallArgs, 
                               false);
}
public final Sema.TemplateDeductionResult FinishTemplateArgumentDeduction(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                               final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                               /*uint*/int NumExplicitlySpecified, 
                               final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, 
                               final TemplateDeductionInfo /*&*/ Info, 
                               /*const*/ SmallVectorImpl<OriginalCallArg> /*P*/ OriginalCallArgs/*= null*/, 
                               boolean PartialOverloading/*= false*/) {
  EnterExpressionEvaluationContext Unevaluated = null;
  SFINAETrap Trap = null;
  InstantiatingTemplate Inst = null;
  ContextRAII SavedContext = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    TemplateParameterList /*P*/ TemplateParams = FunctionTemplate.getTemplateParameters();
    
    // Unevaluated SFINAE context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    Trap/*J*/= new SFINAETrap(/*Deref*/$this());
    
    // Enter a new template instantiation context while we instantiate the
    // actual function declaration.
    SmallVector<TemplateArgument> DeducedArgs/*J*/= new SmallVector<TemplateArgument>(JD$T.INSTANCE, 4, Deduced.begin(), Deduced.end(), new TemplateArgument());
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), Info.getLocation(), FunctionTemplate, 
        new ArrayRef<TemplateArgument>(DeducedArgs, false), 
        ActiveTemplateInstantiation.InstantiationKind.DeducedTemplateArgumentSubstitution, 
        Info);
    if (Inst.isInvalid()) {
      return TemplateDeductionResult.TDK_InstantiationDepth;
    }
    
    SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), FunctionTemplate.getTemplatedDecl());
    
    // C++ [temp.deduct.type]p2:
    //   [...] or if any template argument remains neither deduced nor
    //   explicitly specified, template argument deduction fails.
    SmallVector<TemplateArgument> Builder/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    for (/*uint*/int I = 0, N = TemplateParams.size(); I != N; ++I) {
      NamedDecl /*P*/ Param = TemplateParams.getParam(I);
      if (!Deduced.$at(I).isNull()) {
        if ($less_uint(I, NumExplicitlySpecified)) {
          // We have already fully type-checked and converted this
          // argument, because it was explicitly-specified. Just record the
          // presence of this argument.
          Builder.push_back(Deduced.$at(I));
          // We may have had explicitly-specified template arguments for a
          // template parameter pack (that may or may not have been extended
          // via additional deduced arguments).
          if (Param.isParameterPack() && ($this().CurrentInstantiationScope != null)) {
            if ($this().CurrentInstantiationScope.getPartiallySubstitutedPack()
               == Param) {
              // Forget the partially-substituted pack; its substitution is now
              // complete.
              $this().CurrentInstantiationScope.ResetPartiallySubstitutedPack();
            }
          }
          continue;
        }
        
        // We have deduced this argument, so it still needs to be
        // checked and converted.
        if (SemaTemplateDeductionStatics.ConvertDeducedTemplateArgument(/*Deref*/$this(), Param, new DeducedTemplateArgument(Deduced.$at(I)), 
            FunctionTemplate, Info, 
            true, Builder)) {
          Info.Param.$assignMove(SemaTemplateDeductionStatics.makeTemplateParameter(Param));
          // FIXME: These template arguments are temporary. Free them!
          Info.reset(TemplateArgumentList.CreateCopy($this().Context, new ArrayRef<TemplateArgument>(Builder, false)));
          return TemplateDeductionResult.TDK_SubstitutionFailure;
        }
        
        continue;
      }
      
      // C++0x [temp.arg.explicit]p3:
      //    A trailing template parameter pack (14.5.3) not otherwise deduced will
      //    be deduced to an empty sequence of template arguments.
      // FIXME: Where did the word "trailing" come from?
      if (Param.isTemplateParameterPack()) {
        // We may have had explicitly-specified template arguments for this
        // template parameter pack. If so, our empty deduction extends the
        // explicitly-specified set (C++0x [temp.arg.explicit]p9).
        type$ptr<type$ptr</*const*/ TemplateArgument /*P*/ >> ExplicitArgs = ((type$ptr)create_type$ptr()).$addr();
        uint$ptr NumExplicitArgs = create_uint$ptr();
        if (($this().CurrentInstantiationScope != null)
           && $this().CurrentInstantiationScope.getPartiallySubstitutedPack($AddrOf(ExplicitArgs), 
            $AddrOf(NumExplicitArgs))
           == Param) {
          Builder.push_back(new TemplateArgument(llvm.makeArrayRef(ExplicitArgs.$star(), NumExplicitArgs.$star(), false)));
          
          // Forget the partially-substituted pack; its substitution is now
          // complete.
          $this().CurrentInstantiationScope.ResetPartiallySubstitutedPack();
        } else {
          // Go through the motions of checking the empty argument pack against
          // the parameter pack.
          DeducedTemplateArgument DeducedPack/*J*/= new DeducedTemplateArgument(TemplateArgument.getEmptyPack());
          if (SemaTemplateDeductionStatics.ConvertDeducedTemplateArgument(/*Deref*/$this(), Param, new DeducedTemplateArgument(DeducedPack), 
              FunctionTemplate, Info, true, 
              Builder)) {
            Info.Param.$assignMove(SemaTemplateDeductionStatics.makeTemplateParameter(Param));
            // FIXME: These template arguments are temporary. Free them!
            Info.reset(TemplateArgumentList.CreateCopy($this().Context, new ArrayRef<TemplateArgument>(Builder, false)));
            return TemplateDeductionResult.TDK_SubstitutionFailure;
          }
        }
        continue;
      }
      
      // Substitute into the default template argument, if available.
      bool$ref HasDefaultArg = create_bool$ref(false);
      TemplateArgumentLoc DefArg = $this().SubstDefaultTemplateArgumentIfAvailable(FunctionTemplate, 
          FunctionTemplate.getLocation(), 
          FunctionTemplate.getSourceRange().getEnd(), 
          Param, 
          Builder, HasDefaultArg);
      
      // If there was no default argument, deduction is incomplete.
      if (DefArg.getArgument().isNull()) {
        Info.Param.$assignMove(SemaTemplateDeductionStatics.makeTemplateParameter(((/*const_cast*/NamedDecl /*P*/ )(TemplateParams.getParam(I)))));
        Info.reset(TemplateArgumentList.CreateCopy($this().Context, new ArrayRef<TemplateArgument>(Builder, false)));
        if (PartialOverloading) {
          break;
        }
        
        return HasDefaultArg.$deref() ? TemplateDeductionResult.TDK_SubstitutionFailure : TemplateDeductionResult.TDK_Incomplete;
      }
      
      // Check whether we can actually use the default argument.
      if ($this().CheckTemplateArgument(Param, DefArg, 
          FunctionTemplate, 
          FunctionTemplate.getLocation(), 
          FunctionTemplate.getSourceRange().getEnd(), 
          0, Builder, 
          CheckTemplateArgumentKind.CTAK_Specified)) {
        Info.Param.$assignMove(SemaTemplateDeductionStatics.makeTemplateParameter(((/*const_cast*/NamedDecl /*P*/ )(TemplateParams.getParam(I)))));
        // FIXME: These template arguments are temporary. Free them!
        Info.reset(TemplateArgumentList.CreateCopy($this().Context, new ArrayRef<TemplateArgument>(Builder, false)));
        return TemplateDeductionResult.TDK_SubstitutionFailure;
      }
      // If we get here, we successfully used the default template argument.
    }
    
    // Form the template argument list from the deduced template arguments.
    TemplateArgumentList /*P*/ DeducedArgumentList = TemplateArgumentList.CreateCopy($this().Context, new ArrayRef<TemplateArgument>(Builder, false));
    Info.reset(DeducedArgumentList);
    
    // Substitute the deduced template arguments into the function template
    // declaration to produce the function template specialization.
    DeclContext /*P*/ Owner = FunctionTemplate.getDeclContext();
    if ((FunctionTemplate.getFriendObjectKind().getValue() != 0)) {
      Owner = FunctionTemplate.getLexicalDeclContext();
    }
    $c$.clean(Specialization.$set(cast_or_null_FunctionDecl($this().SubstDecl(FunctionTemplate.getTemplatedDecl(), Owner, 
    $c$.track(new MultiLevelTemplateArgumentList($Deref(DeducedArgumentList)))))));
    if (!(Specialization.$deref() != null) || Specialization.$deref().isInvalidDecl()) {
      return TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    assert (Specialization.$deref().getPrimaryTemplate().getCanonicalDecl() == FunctionTemplate.getCanonicalDecl());
    
    // If the template argument list is owned by the function template
    // specialization, release it.
    if (Specialization.$deref().getTemplateSpecializationArgs() == DeducedArgumentList
       && !Trap.hasErrorOccurred()) {
      Info.take();
    }
    
    // There may have been an error that did not prevent us from constructing a
    // declaration. Mark the declaration invalid and return with a substitution
    // failure.
    if (Trap.hasErrorOccurred()) {
      Specialization.$deref().setInvalidDecl(true);
      return TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    if ((OriginalCallArgs != null)) {
      // C++ [temp.deduct.call]p4:
      //   In general, the deduction process attempts to find template argument
      //   values that will make the deduced A identical to A (after the type A 
      //   is transformed as described above). [...]
      for (/*uint*/int I = 0, N = OriginalCallArgs.size(); I != N; ++I) {
        OriginalCallArg OriginalArg = new OriginalCallArg(($Deref(OriginalCallArgs)).$at$Const(I));
        /*uint*/int ParamIdx = OriginalArg.ArgIdx;
        if ($greatereq_uint(ParamIdx, Specialization.$deref().getNumParams())) {
          continue;
        }
        
        QualType DeducedA = Specialization.$deref().getParamDecl(ParamIdx).getType();
        if (SemaTemplateDeductionStatics.CheckOriginalCallArgDeduction(/*Deref*/$this(), new Sema.OriginalCallArg(OriginalArg), new QualType(DeducedA))) {
          Info.FirstArg.$assignMove(new TemplateArgument(new QualType(DeducedA)));
          Info.SecondArg.$assignMove(new TemplateArgument(new QualType(OriginalArg.OriginalArgType)));
          Info.Unnamed_field7.CallArgIndex = OriginalArg.ArgIdx;
          return TemplateDeductionResult.TDK_DeducedMismatch;
        }
      }
    }
    
    // If we suppressed any diagnostics while performing template argument
    // deduction, and if we haven't already instantiated this declaration,
    // keep track of these diagnostics. They'll be emitted if this specialization
    // is actually used.
    if ($noteq_ptr(Info.diag_begin(), Info.diag_end())) {
      DenseMapIterator<Decl /*P*/ , OptionalNotes> Pos = $this().SuppressedDiagnostics.find(Specialization.$deref().getCanonicalDecl());
      if (Pos.$eq(/*NO_ITER_COPY*/$this().SuppressedDiagnostics.end())) {
        $this().SuppressedDiagnostics.$at_T1$RR(Specialization.$deref().getCanonicalDecl()).
            append_T(Info.diag_begin(), Info.diag_end());
      }
    }
    
    return TemplateDeductionResult.TDK_Success;
  } finally {
    if (SavedContext != null) { SavedContext.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
    if (Trap != null) { Trap.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Perform template argument deduction from a function call
/// (C++ [temp.deduct.call]).
///
/// \param FunctionTemplate the function template for which we are performing
/// template argument deduction.
///
/// \param ExplicitTemplateArgs the explicit template arguments provided
/// for this call.
///
/// \param Args the function call arguments
///
/// \param Specialization if template argument deduction was successful,
/// this will be set to the function template specialization produced by
/// template argument deduction.
///
/// \param Info the argument will be updated to provide additional information
/// about template argument deduction.
///
/// \returns the result of template argument deduction.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceTemplateArguments">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3322,
 FQN="clang::Sema::DeduceTemplateArguments", NM="_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb")
//</editor-fold>
public final Sema.TemplateDeductionResult DeduceTemplateArguments(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                       TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, ArrayRef<Expr /*P*/ > Args, 
                       final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, final TemplateDeductionInfo /*&*/ Info) {
  return DeduceTemplateArguments(FunctionTemplate, 
                       ExplicitTemplateArgs, Args, 
                       Specialization, Info, 
                       false);
}
public final Sema.TemplateDeductionResult DeduceTemplateArguments(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                       TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, ArrayRef<Expr /*P*/ > Args, 
                       final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, final TemplateDeductionInfo /*&*/ Info, 
                       boolean PartialOverloading/*= false*/) {
  LocalInstantiationScope InstScope = null;
  try {
    if (FunctionTemplate.isInvalidDecl()) {
      return TemplateDeductionResult.TDK_Invalid;
    }
    
    FunctionDecl /*P*/ Function = FunctionTemplate.getTemplatedDecl();
    /*uint*/int NumParams = Function.getNumParams();
    
    // C++ [temp.deduct.call]p1:
    //   Template argument deduction is done by comparing each function template
    //   parameter type (call it P) with the type of the corresponding argument
    //   of the call (call it A) as described below.
    /*uint*/int CheckArgs = Args.size();
    if ($less_uint(Args.size(), Function.getMinRequiredArguments()) && !PartialOverloading) {
      return TemplateDeductionResult.TDK_TooFewArguments;
    } else if (Sema.TooManyArguments(NumParams, Args.size(), PartialOverloading)) {
      /*const*/ FunctionProtoType /*P*/ Proto = Function.getType().$arrow().getAs(FunctionProtoType.class);
      if (Proto.isTemplateVariadic()) {
/* Do nothing */         ;
      } else if (Proto.isVariadic()) {
        CheckArgs = NumParams;
      } else {
        return TemplateDeductionResult.TDK_TooManyArguments;
      }
    }
    
    // The types of the parameters from which we will perform template argument
    // deduction.
    InstScope/*J*/= new LocalInstantiationScope(/*Deref*/$this());
    TemplateParameterList /*P*/ TemplateParams = FunctionTemplate.getTemplateParameters();
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    SmallVector<QualType> ParamTypes/*J*/= new SmallVector<QualType>(4, new QualType());
    /*uint*/int NumExplicitlySpecified = 0;
    if ((ExplicitTemplateArgs != null)) {
      TemplateDeductionResult Result = $this().SubstituteExplicitTemplateArguments(FunctionTemplate, 
          $Deref(ExplicitTemplateArgs), 
          Deduced, 
          ParamTypes, 
          (type$ptr<QualType /*P*/> )null, 
          Info);
      if ((Result.getValue() != 0)) {
        return Result;
      }
      
      NumExplicitlySpecified = Deduced.size();
    } else {
      // Just fill in the parameter types from the function declaration.
      for (/*uint*/int I = 0; I != NumParams; ++I)  {
        ParamTypes.push_back(Function.getParamDecl(I).getType());
      }
    }
    
    // Deduce template arguments from the function parameters.
    Deduced.resize(TemplateParams.size());
    /*uint*/int ArgIdx = 0;
    SmallVector<OriginalCallArg> OriginalCallArgs/*J*/= new SmallVector<OriginalCallArg>(4, new OriginalCallArg());
    for (/*uint*/int ParamIdx = 0, NumParamTypes = ParamTypes.size();
         ParamIdx != NumParamTypes; ++ParamIdx) {
      PackDeductionScope PackScope = null;
      try {
        QualType OrigParamType = new QualType(ParamTypes.$at(ParamIdx));
        QualType ParamType = new QualType(OrigParamType);
        
        /*const*/ PackExpansionType /*P*/ ParamExpansion = dyn_cast_PackExpansionType(ParamType);
        if (!(ParamExpansion != null)) {
          // Simple case: matching a function parameter to a function argument.
          if ($greatereq_uint(ArgIdx, CheckArgs)) {
            break;
          }
          
          Expr /*P*/ Arg = Args.$at(ArgIdx++);
          QualType ArgType = Arg.getType();
          
          uint$ref TDF = create_uint$ref(0);
          if (SemaTemplateDeductionStatics.AdjustFunctionParmAndArgTypesForDeduction(/*Deref*/$this(), TemplateParams, 
              ParamType, ArgType, Arg, 
              TDF)) {
            continue;
          }
          
          // If we have nothing to deduce, we're done.
          if (!SemaTemplateDeductionStatics.hasDeducibleTemplateParameters(/*Deref*/$this(), FunctionTemplate, new QualType(ParamType))) {
            continue;
          }
          {
            
            // If the argument is an initializer list ...
            InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(Arg);
            if ((ILE != null)) {
              type$ref<TemplateDeductionResult> Result = create_type$ref();
              // Removing references was already done.
              if (!SemaTemplateDeductionStatics.DeduceFromInitializerList(/*Deref*/$this(), TemplateParams, new QualType(ParamType), ILE, 
                  Info, Deduced, TDF.$deref(), Result)) {
                continue;
              }
              if ((Result.$deref().getValue() != 0)) {
                return Result.$deref();
              }
              // Don't track the argument type, since an initializer list has none.
              continue;
            }
          }
          
          // Keep track of the argument type and corresponding parameter index,
          // so we can check for compatibility between the deduced A and A.
          OriginalCallArgs.push_back(new OriginalCallArg(new QualType(OrigParamType), ArgIdx - 1, 
                  new QualType(ArgType)));
          {
            
            TemplateDeductionResult Result = SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), TemplateParams, 
                new QualType(ParamType), new QualType(ArgType), 
                Info, Deduced, TDF.$deref());
            if ((Result.getValue() != 0)) {
              return Result;
            }
          }
          
          continue;
        }
        
        // C++0x [temp.deduct.call]p1:
        //   For a function parameter pack that occurs at the end of the
        //   parameter-declaration-list, the type A of each remaining argument of
        //   the call is compared with the type P of the declarator-id of the
        //   function parameter pack. Each comparison deduces template arguments
        //   for subsequent positions in the template parameter packs expanded by
        //   the function parameter pack. For a function parameter pack that does
        //   not occur at the end of the parameter-declaration-list, the type of
        //   the parameter pack is a non-deduced context.
        if ($less_uint(ParamIdx + 1, NumParamTypes)) {
          break;
        }
        
        QualType ParamPattern = ParamExpansion.getPattern();
        PackScope/*J*/= new PackDeductionScope(/*Deref*/$this(), TemplateParams, Deduced, Info, 
            new TemplateArgument(new QualType(ParamPattern)));
        
        boolean HasAnyArguments = false;
        for (; $less_uint(ArgIdx, Args.size()); ++ArgIdx) {
          HasAnyArguments = true;
          
          QualType OrigParamType$1 = new QualType(ParamPattern);
          ParamType.$assign(OrigParamType$1);
          Expr /*P*/ Arg = Args.$at(ArgIdx);
          QualType ArgType = Arg.getType();
          
          uint$ref TDF = create_uint$ref(0);
          if (SemaTemplateDeductionStatics.AdjustFunctionParmAndArgTypesForDeduction(/*Deref*/$this(), TemplateParams, 
              ParamType, ArgType, Arg, 
              TDF)) {
            // We can't actually perform any deduction for this argument, so stop
            // deduction at this point.
            ++ArgIdx;
            break;
          }
          {
            
            // As above, initializer lists need special handling.
            InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(Arg);
            if ((ILE != null)) {
              type$ref<TemplateDeductionResult> Result = create_type$ref();
              if (!SemaTemplateDeductionStatics.DeduceFromInitializerList(/*Deref*/$this(), TemplateParams, new QualType(ParamType), ILE, 
                  Info, Deduced, TDF.$deref(), Result)) {
                ++ArgIdx;
                break;
              }
              if ((Result.$deref().getValue() != 0)) {
                return Result.$deref();
              }
            } else {
              
              // Keep track of the argument type and corresponding argument index,
              // so we can check for compatibility between the deduced A and A.
              if (SemaTemplateDeductionStatics.hasDeducibleTemplateParameters(/*Deref*/$this(), FunctionTemplate, new QualType(ParamType))) {
                OriginalCallArgs.push_back(new OriginalCallArg(new QualType(OrigParamType$1), ArgIdx, 
                        new QualType(ArgType)));
              }
              {
                
                TemplateDeductionResult Result = SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), TemplateParams, 
                    new QualType(ParamType), new QualType(ArgType), Info, 
                    Deduced, TDF.$deref());
                if ((Result.getValue() != 0)) {
                  return Result;
                }
              }
            }
          }
          
          PackScope.nextPackElement();
        }
        {
          
          // Build argument packs for each of the parameter packs expanded by this
          // pack expansion.
          Sema.TemplateDeductionResult Result = PackScope.finish(HasAnyArguments);
          if ((Result.getValue() != 0)) {
            return Result;
          }
        }
        
        // After we've matching against a parameter pack, we're done.
        break;
      } finally {
        if (PackScope != null) { PackScope.$destroy(); }
      }
    }
    
    return $this().FinishTemplateArgumentDeduction(FunctionTemplate, Deduced, 
        NumExplicitlySpecified, Specialization, 
        Info, $AddrOf(OriginalCallArgs), 
        PartialOverloading);
  } finally {
    if (InstScope != null) { InstScope.$destroy(); }
  }
}


/// \brief Deduce template arguments when taking the address of a function
/// template (C++ [temp.deduct.funcaddr]) or matching a specialization to
/// a template.
///
/// \param FunctionTemplate the function template for which we are performing
/// template argument deduction.
///
/// \param ExplicitTemplateArgs the explicitly-specified template
/// arguments.
///
/// \param ArgFunctionType the function type that will be used as the
/// "argument" type (A) when performing template argument deduction from the
/// function template's function type. This type may be NULL, if there is no
/// argument type to compare against, in C++0x [temp.arg.explicit]p3.
///
/// \param Specialization if template argument deduction was successful,
/// this will be set to the function template specialization produced by
/// template argument deduction.
///
/// \param Info the argument will be updated to provide additional information
/// about template argument deduction.
///
/// \returns the result of template argument deduction.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceTemplateArguments">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3558,
 FQN="clang::Sema::DeduceTemplateArguments", NM="_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoENS_8QualTypeERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoENS_8QualTypeERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb")
//</editor-fold>
public final Sema.TemplateDeductionResult DeduceTemplateArguments3(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                        TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                        QualType ArgFunctionType, 
                        final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, 
                        final TemplateDeductionInfo /*&*/ Info) {
  return DeduceTemplateArguments3(FunctionTemplate, 
                        ExplicitTemplateArgs, 
                        ArgFunctionType, 
                        Specialization, 
                        Info, 
                        false);
}
public final Sema.TemplateDeductionResult DeduceTemplateArguments3(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                        TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                        QualType ArgFunctionType, 
                        final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, 
                        final TemplateDeductionInfo /*&*/ Info, 
                        boolean InOverloadResolution/*= false*/) {
  LocalInstantiationScope InstScope = null;
  EnterExpressionEvaluationContext Unevaluated = null;
  SFINAETrap Trap = null;
  try {
    if (FunctionTemplate.isInvalidDecl()) {
      return TemplateDeductionResult.TDK_Invalid;
    }
    
    FunctionDecl /*P*/ Function = FunctionTemplate.getTemplatedDecl();
    TemplateParameterList /*P*/ TemplateParams = FunctionTemplate.getTemplateParameters();
    type$ptr<QualType> FunctionType = create_type$ptr(Function.getType());
    if (!InOverloadResolution) {
      ArgFunctionType.$assignMove($this().adjustCCAndNoReturn(new QualType(ArgFunctionType), new QualType(FunctionType.$star())));
    }
    
    // Substitute any explicit template arguments.
    InstScope/*J*/= new LocalInstantiationScope(/*Deref*/$this());
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    /*uint*/int NumExplicitlySpecified = 0;
    SmallVector<QualType> ParamTypes/*J*/= new SmallVector<QualType>(4, new QualType());
    if ((ExplicitTemplateArgs != null)) {
      {
        TemplateDeductionResult Result = $this().SubstituteExplicitTemplateArguments(FunctionTemplate, 
            $Deref(ExplicitTemplateArgs), 
            Deduced, ParamTypes, 
            $AddrOf(FunctionType), Info);
        if ((Result.getValue() != 0)) {
          return Result;
        }
      }
      
      NumExplicitlySpecified = Deduced.size();
    }
    
    // Unevaluated SFINAE context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    Trap/*J*/= new SFINAETrap(/*Deref*/$this());
    
    Deduced.resize(TemplateParams.size());
    
    // If the function has a deduced return type, substitute it for a dependent
    // type so that we treat it as a non-deduced context in what follows.
    boolean HasDeducedReturnType = false;
    if ($this().getLangOpts().CPlusPlus14 && InOverloadResolution
       && (Function.getReturnType().$arrow().getContainedAutoType() != null)) {
      FunctionType.$star().$assignMove($this().SubstAutoType(new QualType(FunctionType.$star()), $this().Context.DependentTy.$QualType()));
      HasDeducedReturnType = true;
    }
    if (!ArgFunctionType.isNull()) {
      /*uint*/int TDF = TemplateDeductionFlags.TDF_TopLevelParameterTypeList;
      if (InOverloadResolution) {
        TDF |= TemplateDeductionFlags.TDF_InOverloadResolution;
      }
      {
        // Deduce template arguments from the function type.
        TemplateDeductionResult Result = SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), TemplateParams, 
            new QualType(FunctionType.$star()), new QualType(ArgFunctionType), 
            Info, Deduced, TDF);
        if ((Result.getValue() != 0)) {
          return Result;
        }
      }
    }
    {
      
      TemplateDeductionResult Result = $this().FinishTemplateArgumentDeduction(FunctionTemplate, Deduced, 
          NumExplicitlySpecified, 
          Specialization, Info);
      if ((Result.getValue() != 0)) {
        return Result;
      }
    }
    
    // If the function has a deduced return type, deduce it now, so we can check
    // that the deduced function type matches the requested type.
    if (HasDeducedReturnType
       && Specialization.$deref().getReturnType().$arrow().isUndeducedType()
       && $this().DeduceReturnType(Specialization.$deref(), Info.getLocation(), false)) {
      return TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
    }
    
    // If the requested function type does not match the actual type of the
    // specialization with respect to arguments of compatible pointer to function
    // types, template argument deduction fails.
    if (!ArgFunctionType.isNull()) {
      if (InOverloadResolution && !$this().isSameOrCompatibleFunctionType($this().Context.getCanonicalType(Specialization.$deref().getType()), 
          $this().Context.getCanonicalType(/*NO_COPY*/ArgFunctionType))) {
        return TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
      } else if (!InOverloadResolution
         && !$this().Context.hasSameType(Specialization.$deref().getType(), new QualType(ArgFunctionType))) {
        return TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
      }
    }
    
    return TemplateDeductionResult.TDK_Success;
  } finally {
    if (Trap != null) { Trap.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
    if (InstScope != null) { InstScope.$destroy(); }
  }
}

/// \brief Deduce template arguments for a templated conversion
/// function (C++ [temp.deduct.conv]) and, if successful, produce a
/// conversion function template specialization.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceTemplateArguments">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3760,
 FQN="clang::Sema::DeduceTemplateArguments", NM="_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclENS_8QualTypeERPNS_17CXXConversionDeclERNS_4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclENS_8QualTypeERPNS_17CXXConversionDeclERNS_4sema21TemplateDeductionInfoE")
//</editor-fold>
public final Sema.TemplateDeductionResult DeduceTemplateArguments(FunctionTemplateDecl /*P*/ ConversionTemplate, 
                       QualType ToType, 
                       final type$ptr<CXXConversionDecl /*P*/ /*&*/> Specialization, 
                       final TemplateDeductionInfo /*&*/ Info) {
  EnterExpressionEvaluationContext Unevaluated = null;
  SFINAETrap Trap = null;
  LocalInstantiationScope InstScope = null;
  try {
    if (ConversionTemplate.isInvalidDecl()) {
      return TemplateDeductionResult.TDK_Invalid;
    }
    
    CXXConversionDecl /*P*/ ConversionGeneric = cast_CXXConversionDecl(ConversionTemplate.getTemplatedDecl());
    
    QualType FromType = ConversionGeneric.getConversionType();
    
    // Canonicalize the types for deduction.
    QualType P = $this().Context.getCanonicalType(/*NO_COPY*/FromType).$QualType();
    QualType A = $this().Context.getCanonicalType(/*NO_COPY*/ToType).$QualType();
    {
      
      // C++0x [temp.deduct.conv]p2:
      //   If P is a reference type, the type referred to by P is used for
      //   type deduction.
      /*const*/ ReferenceType /*P*/ PRef = P.$arrow().getAs(ReferenceType.class);
      if ((PRef != null)) {
        P.$assignMove(PRef.getPointeeType());
      }
    }
    {
      
      // C++0x [temp.deduct.conv]p4:
      //   [...] If A is a reference type, the type referred to by A is used
      //   for type deduction.
      /*const*/ ReferenceType /*P*/ ARef = A.$arrow().getAs(ReferenceType.class);
      if ((ARef != null)) {
        A.$assignMove(ARef.getPointeeType().getUnqualifiedType());
      } else {
        assert (!A.$arrow().isReferenceType()) : "Reference types were handled above";
        
        //   - If P is an array type, the pointer type produced by the
        //     array-to-pointer standard conversion (4.2) is used in place
        //     of P for type deduction; otherwise,
        if (P.$arrow().isArrayType()) {
          P.$assignMove($this().Context.getArrayDecayedType(new QualType(P)));
        } else //   - If P is a function type, the pointer type produced by the
        //     function-to-pointer standard conversion (4.3) is used in
        //     place of P for type deduction; otherwise,
        if (P.$arrow().isFunctionType()) {
          P.$assignMove($this().Context.getPointerType(/*NO_COPY*/P));
        } else {
          //   - If P is a cv-qualified type, the top level cv-qualifiers of
          //     P's type are ignored for type deduction.
          P.$assignMove(P.getUnqualifiedType());
        }
        
        // C++0x [temp.deduct.conv]p4:
        //   If A is a cv-qualified type, the top level cv-qualifiers of A's
        //   type are ignored for type deduction. If A is a reference type, the type
        //   referred to by A is used for type deduction.
        A.$assignMove(A.getUnqualifiedType());
      }
    }
    
    // Unevaluated SFINAE context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    Trap/*J*/= new SFINAETrap(/*Deref*/$this());
    
    // C++ [temp.deduct.conv]p1:
    //   Template argument deduction is done by comparing the return
    //   type of the template conversion function (call it P) with the
    //   type that is required as the result of the conversion (call it
    //   A) as described in 14.8.2.4.
    TemplateParameterList /*P*/ TemplateParams = ConversionTemplate.getTemplateParameters();
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    Deduced.resize(TemplateParams.size());
    
    // C++0x [temp.deduct.conv]p4:
    //   In general, the deduction process attempts to find template
    //   argument values that will make the deduced A identical to
    //   A. However, there are two cases that allow a difference:
    /*uint*/int TDF = 0;
    //     - If the original A is a reference type, A can be more
    //       cv-qualified than the deduced A (i.e., the type referred to
    //       by the reference)
    if (ToType.$arrow().isReferenceType()) {
      TDF |= TemplateDeductionFlags.TDF_ParamWithReferenceType;
    }
    //     - The deduced A can be another pointer or pointer to member
    //       type that can be converted to A via a qualification
    //       conversion.
    //
    // (C++0x [temp.deduct.conv]p6 clarifies that this only happens when
    // both P and A are pointers or member pointers. In this case, we
    // just ignore cv-qualifiers completely).
    if ((P.$arrow().isPointerType() && A.$arrow().isPointerType())
       || (P.$arrow().isMemberPointerType() && A.$arrow().isMemberPointerType())) {
      TDF |= TemplateDeductionFlags.TDF_IgnoreQualifiers;
    }
    {
      TemplateDeductionResult Result = SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), TemplateParams, 
          new QualType(P), new QualType(A), Info, Deduced, TDF);
      if ((Result.getValue() != 0)) {
        return Result;
      }
    }
    
    // Create an Instantiation Scope for finalizing the operator.
    InstScope/*J*/= new LocalInstantiationScope(/*Deref*/$this());
    // Finish template argument deduction.
    type$ref<FunctionDecl /*P*/ > ConversionSpecialized = create_type$ref();
    TemplateDeductionResult Result = $this().FinishTemplateArgumentDeduction(ConversionTemplate, Deduced, 0, 
        ConversionSpecialized, Info);
    Specialization.$set(cast_or_null_CXXConversionDecl(ConversionSpecialized.$deref()));
    
    // If the conversion operator is being invoked on a lambda closure to convert
    // to a ptr-to-function, use the deduced arguments from the conversion
    // function to specialize the corresponding call operator.
    //   e.g., int (*fp)(int) = [](auto a) { return a; };
    if (Result == TemplateDeductionResult.TDK_Success && isLambdaConversionOperator(ConversionGeneric)) {
      
      // Get the return type of the destination ptr-to-function we are converting
      // to.  This is necessary for matching the lambda call operator's return 
      // type to that of the destination ptr-to-function's return type.
      assert (A.$arrow().isPointerType()) : "Can only convert from lambda to ptr-to-function";
      /*const*/ FunctionType /*P*/ ToFunType = A.$arrow().getPointeeType().getTypePtr().getAs(FunctionType.class);
      /*const*/ QualType DestFunctionPtrReturnType = ToFunType.getReturnType();
      
      // Create the corresponding specializations of the call operator and 
      // the static-invoker; and if the return type is auto, 
      // deduce the return type and check if it matches the 
      // DestFunctionPtrReturnType.
      // For instance:
      //   auto L = [](auto a) { return f(a); };
      //   int (*fp)(int) = L;
      //   char (*fp2)(int) = L; <-- Not OK.
      Result = SemaTemplateDeductionStatics.SpecializeCorrespondingLambdaCallOperatorAndInvoker(Specialization.$star(), Deduced, new QualType(DestFunctionPtrReturnType), 
          Info, /*Deref*/$this());
    }
    return Result;
  } finally {
    if (InstScope != null) { InstScope.$destroy(); }
    if (Trap != null) { Trap.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}


/// \brief Deduce template arguments for a function template when there is
/// nothing to deduce against (C++0x [temp.arg.explicit]p3).
///
/// \param FunctionTemplate the function template for which we are performing
/// template argument deduction.
///
/// \param ExplicitTemplateArgs the explicitly-specified template
/// arguments.
///
/// \param Specialization if template argument deduction was successful,
/// this will be set to the function template specialization produced by
/// template argument deduction.
///
/// \param Info the argument will be updated to provide additional information
/// about template argument deduction.
///
/// \returns the result of template argument deduction.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceTemplateArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3912,
 FQN="clang::Sema::DeduceTemplateArguments", NM="_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema23DeduceTemplateArgumentsEPNS_20FunctionTemplateDeclEPNS_24TemplateArgumentListInfoERPNS_12FunctionDeclERNS_4sema21TemplateDeductionInfoEb")
//</editor-fold>
public final Sema.TemplateDeductionResult DeduceTemplateArguments(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                       TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                       final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, 
                       final TemplateDeductionInfo /*&*/ Info) {
  return DeduceTemplateArguments(FunctionTemplate, 
                       ExplicitTemplateArgs, 
                       Specialization, 
                       Info, 
                       false);
}
public final Sema.TemplateDeductionResult DeduceTemplateArguments(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                       TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                       final type$ref<FunctionDecl /*P*/ /*&*/> Specialization, 
                       final TemplateDeductionInfo /*&*/ Info, 
                       boolean InOverloadResolution/*= false*/) {
  return $this().DeduceTemplateArguments3(FunctionTemplate, ExplicitTemplateArgs, 
      new QualType(), Specialization, Info, 
      InOverloadResolution);
}


/// \brief Substitute Replacement for \p auto in \p TypeWithAuto
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstAutoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4106,
 FQN="clang::Sema::SubstAutoType", NM="_ZN5clang4Sema13SubstAutoTypeENS_8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema13SubstAutoTypeENS_8QualTypeES1_")
//</editor-fold>
public final QualType SubstAutoType(QualType TypeWithAuto, 
             QualType TypeToReplaceAuto) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean($c$.track(new SubstituteAutoTransform(/*Deref*/$this(), new QualType(TypeToReplaceAuto))).
        TransformType(new QualType(TypeWithAuto)));
  } finally {
    $c$.$destroy();
  }
}

/// \brief Substitute Replacement for auto in TypeWithAuto
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstAutoTypeSourceInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4112,
 FQN="clang::Sema::SubstAutoTypeSourceInfo", NM="_ZN5clang4Sema23SubstAutoTypeSourceInfoEPNS_14TypeSourceInfoENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema23SubstAutoTypeSourceInfoEPNS_14TypeSourceInfoENS_8QualTypeE")
//</editor-fold>
public final TypeSourceInfo /*P*/ SubstAutoTypeSourceInfo(TypeSourceInfo /*P*/ TypeWithAuto, 
                       QualType TypeToReplaceAuto) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean($c$.track(new SubstituteAutoTransform(/*Deref*/$this(), new QualType(TypeToReplaceAuto))).
        TransformType(TypeWithAuto));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceAutoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3976,
 FQN="clang::Sema::DeduceAutoType", NM="_ZN5clang4Sema14DeduceAutoTypeEPNS_14TypeSourceInfoERPNS_4ExprERNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema14DeduceAutoTypeEPNS_14TypeSourceInfoERPNS_4ExprERNS_8QualTypeE")
//</editor-fold>
public final Sema.DeduceAutoResult DeduceAutoType(TypeSourceInfo /*P*/ Type, final type$ref<Expr /*P*/ /*&*/> Init, final QualType /*&*/ Result) {
  return $this().DeduceAutoType(Type.getTypeLoc(), Init, Result);
}


/// \brief Deduce the type for an auto type-specifier (C++11 [dcl.spec.auto]p6)
///
/// \param Type the type pattern using the auto type-specifier.
/// \param Init the initializer for the variable whose type is to be deduced.
/// \param Result if type deduction was successful, this will be set to the
///        deduced type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceAutoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3987,
 FQN="clang::Sema::DeduceAutoType", NM="_ZN5clang4Sema14DeduceAutoTypeENS_7TypeLocERPNS_4ExprERNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema14DeduceAutoTypeENS_7TypeLocERPNS_4ExprERNS_8QualTypeE")
//</editor-fold>
public final Sema.DeduceAutoResult DeduceAutoType(TypeLoc Type, final type$ref<Expr /*P*/ /*&*/> Init, final QualType /*&*/ Result) {
  LocalInstantiationScope InstScope = null;
  TemplateDeductionInfo Info = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Init.$deref().getType().$arrow().isNonOverloadPlaceholderType()) {
      ActionResultTTrue<Expr /*P*/ > NonPlaceholder = $this().CheckPlaceholderExpr(Init.$deref());
      if (NonPlaceholder.isInvalid()) {
        return DeduceAutoResult.DAR_FailedAlreadyDiagnosed;
      }
      Init.$set(NonPlaceholder.get());
    }
    if (Init.$deref().isTypeDependent() || Type.getType().$arrow().isDependentType()) {
      $c$.clean(Result.$assignMove($c$.track(new SubstituteAutoTransform(/*Deref*/$this(), $this().Context.DependentTy.$QualType())).Apply(new TypeLoc(Type))));
      assert (!Result.isNull()) : "substituting DependentTy can't fail";
      return DeduceAutoResult.DAR_Succeeded;
    }
    {
      
      // If this is a 'decltype(auto)' specifier, do the decltype dance.
      // Since 'decltype(auto)' can only occur at the top of the type, we
      // don't need to go digging for it.
      /*const*/ AutoType /*P*/ AT = Type.getType().$arrow().getAs(AutoType.class);
      if ((AT != null)) {
        if (AT.isDecltypeAuto()) {
          if (isa_InitListExpr(Init)) {
            $c$.clean($c$.track($this().Diag(Init.$deref().getLocStart(), diag.err_decltype_auto_initializer_list)));
            return DeduceAutoResult.DAR_FailedAlreadyDiagnosed;
          }
          
          QualType Deduced = $this().BuildDecltypeType(Init.$deref(), Init.$deref().getLocStart(), false);
          if (Deduced.isNull()) {
            return DeduceAutoResult.DAR_FailedAlreadyDiagnosed;
          }
          // FIXME: Support a non-canonical deduced type for 'auto'.
          Deduced.$assignMove($this().Context.getCanonicalType(/*NO_COPY*/Deduced).$QualType());
          $c$.clean(Result.$assignMove($c$.track(new SubstituteAutoTransform(/*Deref*/$this(), new QualType(Deduced))).Apply(new TypeLoc(Type))));
          if (Result.isNull()) {
            return DeduceAutoResult.DAR_FailedAlreadyDiagnosed;
          }
          return DeduceAutoResult.DAR_Succeeded;
        } else if (!$this().getLangOpts().CPlusPlus) {
          if (isa_InitListExpr(Init)) {
            $c$.clean($c$.track($this().Diag(Init.$deref().getLocStart(), diag.err_auto_init_list_from_c)));
            return DeduceAutoResult.DAR_FailedAlreadyDiagnosed;
          }
        }
      }
    }
    
    SourceLocation Loc = Init.$deref().getExprLoc();
    
    InstScope/*J*/= new LocalInstantiationScope(/*Deref*/$this());
    
    // Build template<class TemplParam> void Func(FuncParam);
    TemplateTypeParmDecl /*P*/ TemplParam = TemplateTypeParmDecl.Create($this().Context, (DeclContext /*P*/ )null, new SourceLocation(), new SourceLocation(Loc), 0, 0, 
        (IdentifierInfo /*P*/ )null, false, false);
    QualType TemplArg = new QualType(TemplParam.getTypeForDecl(), 0);
    NamedDecl /*P*/ TemplParamPtr = TemplParam;
    FixedSizeTemplateParameterListStorage TemplateParamsSt/*J*/= new FixedSizeTemplateParameterListStorage(1, new SourceLocation(Loc), new SourceLocation(Loc), new ArrayRef<NamedDecl /*P*/ >(TemplParamPtr, true), new SourceLocation(Loc));
    
    QualType FuncParam = $c$.clean($c$.track(new SubstituteAutoTransform(/*Deref*/$this(), new QualType(TemplArg))).Apply(new TypeLoc(Type)));
    assert (!FuncParam.isNull()) : "substituting template parameter for 'auto' failed";
    
    // Deduce type of TemplParam in Func(Init)
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(1, new DeducedTemplateArgument());
    Deduced.resize(1);
    QualType InitType = Init.$deref().getType();
    uint$ref TDF = create_uint$ref(0);
    
    Info/*J*/= new TemplateDeductionInfo(new SourceLocation(Loc));
    
    InitListExpr /*P*/ InitList = dyn_cast_InitListExpr(Init.$deref());
    if ((InitList != null)) {
      for (/*uint*/int i = 0, e = InitList.getNumInits(); $less_uint(i, e); ++i) {
        if ((SemaTemplateDeductionStatics.DeduceTemplateArgumentByListElement(/*Deref*/$this(), TemplateParamsSt.get(), 
            new QualType(TemplArg), InitList.getInit(i), 
            Info, Deduced, TDF.$deref()).getValue() != 0)) {
          return DeduceAutoResult.DAR_Failed;
        }
      }
    } else {
      if (!$this().getLangOpts().CPlusPlus && Init.$deref().refersToBitField()) {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_auto_bitfield)));
        return DeduceAutoResult.DAR_FailedAlreadyDiagnosed;
      }
      if (SemaTemplateDeductionStatics.AdjustFunctionParmAndArgTypesForDeduction(/*Deref*/$this(), TemplateParamsSt.get(), FuncParam, InitType, Init.$deref(), TDF)) {
        return DeduceAutoResult.DAR_Failed;
      }
      if ((SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), TemplateParamsSt.get(), 
          new QualType(FuncParam), new QualType(InitType), Info, Deduced, 
          TDF.$deref()).getValue() != 0)) {
        return DeduceAutoResult.DAR_Failed;
      }
    }
    if (Deduced.$at(0).getKind() != TemplateArgument.ArgKind.Type) {
      return DeduceAutoResult.DAR_Failed;
    }
    
    QualType DeducedType = Deduced.$at(0).getAsType();
    if ((InitList != null)) {
      DeducedType.$assignMove($this().BuildStdInitializerList(new QualType(DeducedType), new SourceLocation(Loc)));
      if (DeducedType.isNull()) {
        return DeduceAutoResult.DAR_FailedAlreadyDiagnosed;
      }
    }
    
    $c$.clean(Result.$assignMove($c$.track(new SubstituteAutoTransform(/*Deref*/$this(), new QualType(DeducedType))).Apply(new TypeLoc(Type))));
    if (Result.isNull()) {
      return DeduceAutoResult.DAR_FailedAlreadyDiagnosed;
    }
    
    // Check that the deduced argument type is compatible with the original
    // argument type per C++ [temp.deduct.call]p4.
    if (!(InitList != null) && !Result.isNull()
       && SemaTemplateDeductionStatics.CheckOriginalCallArgDeduction(/*Deref*/$this(), 
        new Sema.OriginalCallArg(new QualType(FuncParam), 0, new QualType(InitType)), 
        new QualType(Result))) {
      Result.$assignMove(new QualType());
      return DeduceAutoResult.DAR_Failed;
    }
    
    return DeduceAutoResult.DAR_Succeeded;
  } finally {
    if (Info != null) { Info.$destroy(); }
    if (InstScope != null) { InstScope.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseAutoDeductionFailure">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4118,
 FQN="clang::Sema::DiagnoseAutoDeductionFailure", NM="_ZN5clang4Sema28DiagnoseAutoDeductionFailureEPNS_7VarDeclEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema28DiagnoseAutoDeductionFailureEPNS_7VarDeclEPNS_4ExprE")
//</editor-fold>
public final void DiagnoseAutoDeductionFailure(VarDecl /*P*/ VDecl, Expr /*P*/ Init) {
  if (isa_InitListExpr(Init)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(VDecl.getLocation(), 
                      VDecl.isInitCapture() ? diag.err_init_capture_deduction_failure_from_init_list : diag.err_auto_var_deduction_failure_from_init_list)), 
                  VDecl.getDeclName()), VDecl.getType()), Init.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(VDecl.getLocation(), 
                          VDecl.isInitCapture() ? diag.err_init_capture_deduction_failure : diag.err_auto_var_deduction_failure)), 
                      VDecl.getDeclName()), VDecl.getType()), Init.getType()), 
          Init.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4133,
 FQN="clang::Sema::DeduceReturnType", NM="_ZN5clang4Sema16DeduceReturnTypeEPNS_12FunctionDeclENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema16DeduceReturnTypeEPNS_12FunctionDeclENS_14SourceLocationEb")
//</editor-fold>
public final boolean DeduceReturnType(FunctionDecl /*P*/ FD, SourceLocation Loc) {
  return DeduceReturnType(FD, Loc, 
                true);
}
public final boolean DeduceReturnType(FunctionDecl /*P*/ FD, SourceLocation Loc, 
                boolean Diagnose/*= true*/) {
  assert (FD.getReturnType().$arrow().isUndeducedType());
  if ((FD.getTemplateInstantiationPattern() != null)) {
    $this().InstantiateFunctionDefinition(new SourceLocation(Loc), FD);
  }
  
  boolean StillUndeduced = FD.getReturnType().$arrow().isUndeducedType();
  if (StillUndeduced && Diagnose && !FD.isInvalidDecl()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NamedDecl($c$.track($this().Diag(new SourceLocation(Loc), diag.err_auto_fn_used_before_defined)), FD));
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NamedDecl($c$.track($this().Diag(FD.getLocation(), diag.note_callee_decl)), FD));
    } finally {
      $c$.$destroy();
    }
  }
  
  return StillUndeduced;
}


/// \brief Returns the more specialized function template according
/// to the rules of function template partial ordering (C++ [temp.func.order]).
///
/// \param FT1 the first function template
///
/// \param FT2 the second function template
///
/// \param TPOC the context in which we are performing partial ordering of
/// function templates.
///
/// \param NumCallArguments1 The number of arguments in the call to FT1, used
/// only when \c TPOC is \c TPOC_Call.
///
/// \param NumCallArguments2 The number of arguments in the call to FT2, used
/// only when \c TPOC is \c TPOC_Call.
///
/// \returns the more specialized function template. If neither
/// template is more specialized, returns NULL.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getMoreSpecializedTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4363,
 FQN="clang::Sema::getMoreSpecializedTemplate", NM="_ZN5clang4Sema26getMoreSpecializedTemplateEPNS_20FunctionTemplateDeclES2_NS_14SourceLocationENS_30TemplatePartialOrderingContextEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema26getMoreSpecializedTemplateEPNS_20FunctionTemplateDeclES2_NS_14SourceLocationENS_30TemplatePartialOrderingContextEjj")
//</editor-fold>
public final FunctionTemplateDecl /*P*/ getMoreSpecializedTemplate(FunctionTemplateDecl /*P*/ FT1, 
                          FunctionTemplateDecl /*P*/ FT2, 
                          SourceLocation Loc, 
                          TemplatePartialOrderingContext TPOC, 
                          /*uint*/int NumCallArguments1, 
                          /*uint*/int NumCallArguments2) {
  boolean Better1 = SemaTemplateDeductionStatics.isAtLeastAsSpecializedAs(/*Deref*/$this(), new SourceLocation(Loc), FT1, FT2, new TemplatePartialOrderingContext(TPOC), 
      NumCallArguments1);
  boolean Better2 = SemaTemplateDeductionStatics.isAtLeastAsSpecializedAs(/*Deref*/$this(), new SourceLocation(Loc), FT2, FT1, new TemplatePartialOrderingContext(TPOC), 
      NumCallArguments2);
  if (Better1 != Better2) { // We have a clear winner
    return Better1 ? FT1 : FT2;
  }
  if (!Better1 && !Better2) { // Neither is better than the other
    return null;
  }
  
  // FIXME: This mimics what GCC implements, but doesn't match up with the
  // proposed resolution for core issue 692. This area needs to be sorted out,
  // but for now we attempt to maintain compatibility.
  boolean Variadic1 = SemaTemplateDeductionStatics.isVariadicFunctionTemplate(FT1);
  boolean Variadic2 = SemaTemplateDeductionStatics.isVariadicFunctionTemplate(FT2);
  if (Variadic1 != Variadic2) {
    return Variadic1 ? FT2 : FT1;
  }
  
  return null;
}


/// \brief Retrieve the most specialized of the given function template
/// specializations.
///
/// \param SpecBegin the start iterator of the function template
/// specializations that we will be comparing.
///
/// \param SpecEnd the end iterator of the function template
/// specializations, paired with \p SpecBegin.
///
/// \param Loc the location where the ambiguity or no-specializations
/// diagnostic should occur.
///
/// \param NoneDiag partial diagnostic used to diagnose cases where there are
/// no matching candidates.
///
/// \param AmbigDiag partial diagnostic used to diagnose an ambiguity, if one
/// occurs.
///
/// \param CandidateDiag partial diagnostic used for each function template
/// specialization that is a candidate in the ambiguous ordering. One parameter
/// in this diagnostic should be unbound, which will correspond to the string
/// describing the template arguments for the function template specialization.
///
/// \returns the most specialized function template specialization, if
/// found. Otherwise, returns SpecEnd.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getMostSpecialized">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4428,
 FQN="clang::Sema::getMostSpecialized", NM="_ZN5clang4Sema18getMostSpecializedENS_21UnresolvedSetIteratorES1_RNS_24TemplateSpecCandidateSetENS_14SourceLocationERKNS_17PartialDiagnosticES7_S7_bNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema18getMostSpecializedENS_21UnresolvedSetIteratorES1_RNS_24TemplateSpecCandidateSetENS_14SourceLocationERKNS_17PartialDiagnosticES7_S7_bNS_8QualTypeE")
//</editor-fold>
public final UnresolvedSetIterator getMostSpecialized(UnresolvedSetIterator SpecBegin, UnresolvedSetIterator SpecEnd, 
                  final TemplateSpecCandidateSet /*&*/ FailedCandidates, 
                  SourceLocation Loc, final /*const*/ PartialDiagnostic /*&*/ NoneDiag, 
                  final /*const*/ PartialDiagnostic /*&*/ AmbigDiag, final /*const*/ PartialDiagnostic /*&*/ CandidateDiag) {
  return getMostSpecialized(SpecBegin, SpecEnd, 
                  FailedCandidates, 
                  Loc, NoneDiag, 
                  AmbigDiag, CandidateDiag, 
                  true, new QualType());
}
public final UnresolvedSetIterator getMostSpecialized(UnresolvedSetIterator SpecBegin, UnresolvedSetIterator SpecEnd, 
                  final TemplateSpecCandidateSet /*&*/ FailedCandidates, 
                  SourceLocation Loc, final /*const*/ PartialDiagnostic /*&*/ NoneDiag, 
                  final /*const*/ PartialDiagnostic /*&*/ AmbigDiag, final /*const*/ PartialDiagnostic /*&*/ CandidateDiag, 
                  boolean Complain/*= true*/) {
  return getMostSpecialized(SpecBegin, SpecEnd, 
                  FailedCandidates, 
                  Loc, NoneDiag, 
                  AmbigDiag, CandidateDiag, 
                  Complain, new QualType());
}
public final UnresolvedSetIterator getMostSpecialized(UnresolvedSetIterator SpecBegin, UnresolvedSetIterator SpecEnd, 
                  final TemplateSpecCandidateSet /*&*/ FailedCandidates, 
                  SourceLocation Loc, final /*const*/ PartialDiagnostic /*&*/ NoneDiag, 
                  final /*const*/ PartialDiagnostic /*&*/ AmbigDiag, final /*const*/ PartialDiagnostic /*&*/ CandidateDiag, 
                  boolean Complain/*= true*/, QualType TargetType/*= QualType()*/) {
  if (SpecBegin.$eq(SpecEnd)) {
    if (Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), NoneDiag)));
        FailedCandidates.NoteCandidates(/*Deref*/$this(), new SourceLocation(Loc));
      } finally {
        $c$.$destroy();
      }
    }
    return new UnresolvedSetIterator(JD$Move.INSTANCE, SpecEnd);
  }
  if (SpecBegin.$add(1).$eq(SpecEnd)) {
    return new UnresolvedSetIterator(JD$Move.INSTANCE, SpecBegin);
  }
  
  // Find the function template that is better than all of the templates it
  // has been compared to.
  UnresolvedSetIterator Best = new UnresolvedSetIterator(SpecBegin);
  FunctionTemplateDecl /*P*/ BestTemplate = cast_FunctionDecl(Best.$star()).getPrimaryTemplate();
  assert ((BestTemplate != null)) : "Not a function template specialization?";
  for (UnresolvedSetIterator I = SpecBegin.$add(1); I.$noteq(SpecEnd); I.$preInc()) {
    FunctionTemplateDecl /*P*/ Challenger = cast_FunctionDecl(I.$star()).getPrimaryTemplate();
    assert ((Challenger != null)) : "Not a function template specialization?";
    if (SemaTemplateDeductionStatics.isSameTemplate($this().getMoreSpecializedTemplate(BestTemplate, Challenger, 
            new SourceLocation(Loc), new TemplatePartialOrderingContext(TPOC.TPOC_Other), 0, 0), 
        Challenger)) {
      Best.$assign(I);
      BestTemplate = Challenger;
    }
  }
  
  // Make sure that the "best" function template is more specialized than all
  // of the others.
  boolean Ambiguous = false;
  for (UnresolvedSetIterator I = new UnresolvedSetIterator(SpecBegin); I.$noteq(SpecEnd); I.$preInc()) {
    FunctionTemplateDecl /*P*/ Challenger = cast_FunctionDecl(I.$star()).getPrimaryTemplate();
    if (I.$noteq(Best)
       && !SemaTemplateDeductionStatics.isSameTemplate($this().getMoreSpecializedTemplate(BestTemplate, Challenger, 
            new SourceLocation(Loc), new TemplatePartialOrderingContext(TPOC.TPOC_Other), 0, 0), 
        BestTemplate)) {
      Ambiguous = true;
      break;
    }
  }
  if (!Ambiguous) {
    // We found an answer. Return it.
    return Best;
  }
  
  // Diagnose the ambiguity.
  if (Complain) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), AmbigDiag)));
      
      // FIXME: Can we order the candidates in some sane way?
      for (UnresolvedSetIterator I = new UnresolvedSetIterator(SpecBegin); I.$noteq(SpecEnd); I.$preInc()) {
        PartialDiagnostic PD = null;
        try {
          PD = new PartialDiagnostic(CandidateDiag);
          PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PD, new StringRef($this().getTemplateArgumentBindingsText(cast_FunctionDecl(I.$star()).getPrimaryTemplate().getTemplateParameters(), 
                      $Deref(cast_FunctionDecl(I.$star()).getTemplateSpecializationArgs()))));
          if (!TargetType.isNull()) {
            $this().HandleFunctionTypeMismatch(PD, cast_FunctionDecl(I.$star()).getType(), 
                new QualType(TargetType));
          }
          $c$.clean($c$.track($this().Diag((I.$star()).getLocation(), PD)));
        } finally {
          if (PD != null) { PD.$destroy(); }
        }
      }
    } finally {
      $c$.$destroy();
    }
  }
  
  return new UnresolvedSetIterator(JD$Move.INSTANCE, SpecEnd);
}


/// \brief Returns the more specialized class template partial specialization
/// according to the rules of partial ordering of class template partial
/// specializations (C++ [temp.class.order]).
///
/// \param PS1 the first class template partial specialization
///
/// \param PS2 the second class template partial specialization
///
/// \returns the more specialized class template partial specialization. If
/// neither partial specialization is more specialized, returns NULL.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getMoreSpecializedPartialSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4513,
 FQN="clang::Sema::getMoreSpecializedPartialSpecialization", NM="_ZN5clang4Sema39getMoreSpecializedPartialSpecializationEPNS_38ClassTemplatePartialSpecializationDeclES2_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema39getMoreSpecializedPartialSpecializationEPNS_38ClassTemplatePartialSpecializationDeclES2_NS_14SourceLocationE")
//</editor-fold>
public final ClassTemplatePartialSpecializationDecl /*P*/ getMoreSpecializedPartialSpecialization(ClassTemplatePartialSpecializationDecl /*P*/ PS1, 
                                       ClassTemplatePartialSpecializationDecl /*P*/ PS2, 
                                       SourceLocation Loc) {
  TemplateDeductionInfo Info = null;
  try {
    // C++ [temp.class.order]p1:
    //   For two class template partial specializations, the first is at least as
    //   specialized as the second if, given the following rewrite to two
    //   function templates, the first function template is at least as
    //   specialized as the second according to the ordering rules for function
    //   templates (14.6.6.2):
    //     - the first function template has the same template parameters as the
    //       first partial specialization and has a single function parameter
    //       whose type is a class template specialization with the template
    //       arguments of the first partial specialization, and
    //     - the second function template has the same template parameters as the
    //       second partial specialization and has a single function parameter
    //       whose type is a class template specialization with the template
    //       arguments of the second partial specialization.
    //
    // Rather than synthesize function templates, we merely perform the
    // equivalent partial ordering by performing deduction directly on
    // the template arguments of the class template partial
    // specializations. This computation is slightly simpler than the
    // general problem of function template partial ordering, because
    // class template partial specializations are more constrained. We
    // know that every template parameter is deducible from the class
    // template partial specialization's template arguments, for
    // example.
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    Info/*J*/= new TemplateDeductionInfo(new SourceLocation(Loc));
    
    QualType PT1 = PS1.getInjectedSpecializationType();
    QualType PT2 = PS2.getInjectedSpecializationType();
    
    // Determine whether PS1 is at least as specialized as PS2
    Deduced.resize(PS2.getTemplateParameters().size());
    boolean Better1 = !(SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), 
        PS2.getTemplateParameters(), 
        new QualType(PT2), new QualType(PT1), Info, Deduced, TemplateDeductionFlags.TDF_None, 
        /*PartialOrdering=*/ true).getValue() != 0);
    if (Better1) {
      InstantiatingTemplate Inst = null;
      try {
        SmallVector<TemplateArgument> DeducedArgs/*J*/= new SmallVector<TemplateArgument>(JD$T.INSTANCE, 4, Deduced.begin(), Deduced.end(), new TemplateArgument());
        Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_ClassTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange.INSTANCE, /*Deref*/$this(), new SourceLocation(Loc), PS2, new ArrayRef<TemplateArgument>(DeducedArgs, false), Info);
        Better1 = !(/*::*/SemaTemplateDeductionStatics.FinishTemplateArgumentDeduction1(/*Deref*/$this(), PS2, PS1.getTemplateArgs(), Deduced, Info).getValue() != 0);
      } finally {
        if (Inst != null) { Inst.$destroy(); }
      }
    }
    
    // Determine whether PS2 is at least as specialized as PS1
    Deduced.clear();
    Deduced.resize(PS1.getTemplateParameters().size());
    boolean Better2 = !(SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), PS1.getTemplateParameters(), new QualType(PT1), new QualType(PT2), Info, Deduced, TemplateDeductionFlags.TDF_None, 
        /*PartialOrdering=*/ true).getValue() != 0);
    if (Better2) {
      InstantiatingTemplate Inst = null;
      try {
        SmallVector<TemplateArgument> DeducedArgs/*J*/= new SmallVector<TemplateArgument>(JD$T.INSTANCE, 4, Deduced.begin(), 
                Deduced.end(), new TemplateArgument());
        Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_ClassTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange.INSTANCE, /*Deref*/$this(), new SourceLocation(Loc), PS1, new ArrayRef<TemplateArgument>(DeducedArgs, false), Info);
        Better2 = !(/*::*/SemaTemplateDeductionStatics.FinishTemplateArgumentDeduction1(/*Deref*/$this(), PS1, PS2.getTemplateArgs(), Deduced, Info).getValue() != 0);
      } finally {
        if (Inst != null) { Inst.$destroy(); }
      }
    }
    if (Better1 == Better2) {
      return null;
    }
    
    return Better1 ? PS1 : PS2;
  } finally {
    if (Info != null) { Info.$destroy(); }
  }
}


/// TODO: Unify with ClassTemplatePartialSpecializationDecl version?
///       May require unifying ClassTemplate(Partial)SpecializationDecl and
///        VarTemplate(Partial)SpecializationDecl with a new data
///        structure Template(Partial)SpecializationDecl, and
///        using Template(Partial)SpecializationDecl as input type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getMoreSpecializedPartialSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4586,
 FQN="clang::Sema::getMoreSpecializedPartialSpecialization", NM="_ZN5clang4Sema39getMoreSpecializedPartialSpecializationEPNS_36VarTemplatePartialSpecializationDeclES2_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema39getMoreSpecializedPartialSpecializationEPNS_36VarTemplatePartialSpecializationDeclES2_NS_14SourceLocationE")
//</editor-fold>
public final VarTemplatePartialSpecializationDecl /*P*/ getMoreSpecializedPartialSpecialization(VarTemplatePartialSpecializationDecl /*P*/ PS1, 
                                       VarTemplatePartialSpecializationDecl /*P*/ PS2, SourceLocation Loc) {
  TemplateDeductionInfo Info = null;
  try {
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    Info/*J*/= new TemplateDeductionInfo(new SourceLocation(Loc));
    assert (PS1.getSpecializedTemplate() == PS2.getSpecializedTemplate()) : "the partial specializations being compared should specialize the same template.";
    TemplateName Name/*J*/= new TemplateName(PS1.getSpecializedTemplate());
    TemplateName CanonTemplate = $this().Context.getCanonicalTemplateName(new TemplateName(Name));
    QualType PT1 = $this().Context.getTemplateSpecializationType(new TemplateName(CanonTemplate), PS1.getTemplateArgs().asArray());
    QualType PT2 = $this().Context.getTemplateSpecializationType(new TemplateName(CanonTemplate), PS2.getTemplateArgs().asArray());
    
    // Determine whether PS1 is at least as specialized as PS2
    Deduced.resize(PS2.getTemplateParameters().size());
    boolean Better1 = !(SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), PS2.getTemplateParameters(), new QualType(PT2), new QualType(PT1), Info, Deduced, TemplateDeductionFlags.TDF_None, 
        /*PartialOrdering=*/ true).getValue() != 0);
    if (Better1) {
      InstantiatingTemplate Inst = null;
      try {
        SmallVector<TemplateArgument> DeducedArgs/*J*/= new SmallVector<TemplateArgument>(JD$T.INSTANCE, 4, Deduced.begin(), 
                Deduced.end(), new TemplateArgument());
        Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_VarTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange.INSTANCE, /*Deref*/$this(), new SourceLocation(Loc), PS2, new ArrayRef<TemplateArgument>(DeducedArgs, false), Info);
        Better1 = !(/*::*/SemaTemplateDeductionStatics.FinishTemplateArgumentDeduction2(/*Deref*/$this(), PS2, 
            PS1.getTemplateArgs(), 
            Deduced, Info).getValue() != 0);
      } finally {
        if (Inst != null) { Inst.$destroy(); }
      }
    }
    
    // Determine whether PS2 is at least as specialized as PS1
    Deduced.clear();
    Deduced.resize(PS1.getTemplateParameters().size());
    boolean Better2 = !(SemaTemplateDeductionStatics.DeduceTemplateArgumentsByTypeMatch(/*Deref*/$this(), 
        PS1.getTemplateParameters(), 
        new QualType(PT1), new QualType(PT2), Info, Deduced, TemplateDeductionFlags.TDF_None, 
        /*PartialOrdering=*/ true).getValue() != 0);
    if (Better2) {
      InstantiatingTemplate Inst = null;
      try {
        SmallVector<TemplateArgument> DeducedArgs/*J*/= new SmallVector<TemplateArgument>(JD$T.INSTANCE, 4, Deduced.begin(), Deduced.end(), new TemplateArgument());
        Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_VarTemplatePartialSpecializationDecl$P_ArrayRef$TemplateArgument_TemplateDeductionInfo_SourceRange.INSTANCE, /*Deref*/$this(), new SourceLocation(Loc), PS1, new ArrayRef<TemplateArgument>(DeducedArgs, false), Info);
        Better2 = !(/*::*/SemaTemplateDeductionStatics.FinishTemplateArgumentDeduction2(/*Deref*/$this(), PS1, 
            PS2.getTemplateArgs(), 
            Deduced, Info).getValue() != 0);
      } finally {
        if (Inst != null) { Inst.$destroy(); }
      }
    }
    if (Better1 == Better2) {
      return null;
    }
    
    return Better1 ? PS1 : PS2;
  } finally {
    if (Info != null) { Info.$destroy(); }
  }
}


/// \brief Mark which template parameters can be deduced from a given
/// template argument list.
///
/// \param TemplateArgs the template argument list from which template
/// parameters will be deduced.
///
/// \param Used a bit vector whose elements will be set to \c true
/// to indicate when the corresponding template parameter will be
/// deduced.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkUsedTemplateParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 5015,
 FQN="clang::Sema::MarkUsedTemplateParameters", NM="_ZN5clang4Sema26MarkUsedTemplateParametersERKNS_20TemplateArgumentListEbjRN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema26MarkUsedTemplateParametersERKNS_20TemplateArgumentListEbjRN4llvm14SmallBitVectorE")
//</editor-fold>
public final void MarkUsedTemplateParameters(final /*const*/ TemplateArgumentList /*&*/ TemplateArgs, 
                          boolean OnlyDeduced, /*uint*/int Depth, 
                          final SmallBitVector /*&*/ Used) {
  // C++0x [temp.deduct.type]p9:
  //   If the template argument list of P contains a pack expansion that is not
  //   the last template argument, the entire template argument list is a
  //   non-deduced context.
  if (OnlyDeduced
     && SemaTemplateDeductionStatics.hasPackExpansionBeforeEnd(TemplateArgs.data(), TemplateArgs.size())) {
    return;
  }
  
  for (/*uint*/int I = 0, N = TemplateArgs.size(); I != N; ++I)  {
    /*::*/SemaTemplateDeductionStatics.MarkUsedTemplateParameters($this().Context, TemplateArgs.$at(I), OnlyDeduced, 
        Depth, Used);
  }
}


/// \brief Marks all of the template parameters that will be deduced by a
/// call to the given function template.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkDeducedTemplateParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 5034,
 FQN="clang::Sema::MarkDeducedTemplateParameters", NM="_ZN5clang4Sema29MarkDeducedTemplateParametersERNS_10ASTContextEPKNS_20FunctionTemplateDeclERN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang4Sema29MarkDeducedTemplateParametersERNS_10ASTContextEPKNS_20FunctionTemplateDeclERN4llvm14SmallBitVectorE")
//</editor-fold>
public static void MarkDeducedTemplateParameters(final ASTContext /*&*/ Ctx, /*const*/ FunctionTemplateDecl /*P*/ FunctionTemplate, 
                             final SmallBitVector /*&*/ Deduced) {
  TemplateParameterList /*P*/ TemplateParams = FunctionTemplate.getTemplateParameters();
  Deduced.clear();
  Deduced.resize(TemplateParams.size());
  
  FunctionDecl /*P*/ Function = FunctionTemplate.getTemplatedDecl();
  for (/*uint*/int I = 0, N = Function.getNumParams(); I != N; ++I)  {
    /*::*/SemaTemplateDeductionStatics.MarkUsedTemplateParameters(Ctx, Function.getParamDecl(I).getType(), 
        true, TemplateParams.getDepth(), Deduced);
  }
}

} // END OF class Sema_SemaTemplateDeduction
