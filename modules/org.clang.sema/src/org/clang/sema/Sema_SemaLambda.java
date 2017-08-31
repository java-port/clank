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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaLambdaStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaLambda">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaInit ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema15ActOnLambdaExprENS_14SourceLocationEPNS_4StmtEPNS_5ScopeE;_ZN5clang4Sema15BuildLambdaExprENS_14SourceLocationES1_PNS_4sema15LambdaScopeInfoE;_ZN5clang4Sema16ActOnLambdaErrorENS_14SourceLocationEPNS_5ScopeEb;_ZN5clang4Sema16buildLambdaScopeEPNS_4sema15LambdaScopeInfoEPNS_13CXXMethodDeclENS_11SourceRangeENS_20LambdaCaptureDefaultENS_14SourceLocationEbbb;_ZN5clang4Sema19addLambdaParametersEPNS_13CXXMethodDeclEPNS_5ScopeE;_ZN5clang4Sema21buildInitCaptureFieldEPNS_4sema15LambdaScopeInfoEPNS_7VarDeclE;_ZN5clang4Sema21startLambdaDefinitionEPNS_13CXXRecordDeclENS_11SourceRangeEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE;_ZN5clang4Sema23createLambdaClosureTypeENS_11SourceRangeEPNS_14TypeSourceInfoEbNS_20LambdaCaptureDefaultE;_ZN5clang4Sema23deduceClosureReturnTypeERNS_4sema18CapturingScopeInfoE;_ZN5clang4Sema28ActOnStartOfLambdaDefinitionERNS_16LambdaIntroducerERNS_10DeclaratorEPNS_5ScopeE;_ZN5clang4Sema28finishLambdaExplicitCapturesEPNS_4sema15LambdaScopeInfoE;_ZN5clang4Sema29BuildBlockForLambdaConversionENS_14SourceLocationES1_PNS_17CXXConversionDeclEPNS_4ExprE;_ZN5clang4Sema29getCurrentMangleNumberContextEPKNS_11DeclContextERPNS_4DeclE;_ZN5clang4Sema30createLambdaInitCaptureVarDeclENS_14SourceLocationENS_8QualTypeEPNS_14IdentifierInfoEjPNS_4ExprE;_ZN5clang4Sema36buildLambdaInitCaptureInitializationENS_14SourceLocationEbPNS_14IdentifierInfoEbRPNS_4ExprE; -static-type=Sema_SemaLambda -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaLambda extends Sema_SemaInit {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// \brief Compute the mangling number context for a lambda expression or
/// block literal.
///
/// \param DC - The DeclContext containing the lambda expression or
/// block literal.
/// \param[out] ManglingContextDecl - Returns the ManglingContextDecl
/// associated with the context, if relevant.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurrentMangleNumberContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 277,
 FQN="clang::Sema::getCurrentMangleNumberContext", NM="_ZN5clang4Sema29getCurrentMangleNumberContextEPKNS_11DeclContextERPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema29getCurrentMangleNumberContextEPKNS_11DeclContextERPNS_4DeclE")
//</editor-fold>
public final MangleNumberingContext /*P*/ getCurrentMangleNumberContext(/*const*/ DeclContext /*P*/ DC, 
                             final type$ref<Decl /*P*/ /*&*/> ManglingContextDecl) {
  // Compute the context for allocating mangling numbers in the current
  // expression, if the ABI requires them.
  ManglingContextDecl.$set($this().ExprEvalContexts.back().ManglingContextDecl);
  
  final class/*enum*/ ContextKind {
    private static final /*uint*/int Normal = 0;
    private static final /*uint*/int DefaultArgument = Normal + 1;
    private static final /*uint*/int DataMember = DefaultArgument + 1;
    private static final /*uint*/int StaticDataMember = DataMember + 1;
  }/* ContextKind*//*uint*/int Kind = ContextKind.Normal;
  
  // Default arguments of member function parameters that appear in a class
  // definition, as well as the initializers of data members, receive special
  // treatment. Identify them.
  if ((ManglingContextDecl.$deref() != null)) {
    {
      ParmVarDecl /*P*/ Param = dyn_cast_ParmVarDecl(ManglingContextDecl.$deref());
      if ((Param != null)) {
        {
          /*const*/ DeclContext /*P*/ LexicalDC = Param.getDeclContext().getLexicalParent();
          if ((LexicalDC != null)) {
            if (LexicalDC.isRecord()) {
              Kind = ContextKind.DefaultArgument;
            }
          }
        }
      } else {
        VarDecl /*P*/ Var = dyn_cast_VarDecl(ManglingContextDecl.$deref());
        if ((Var != null)) {
          if (Var.getDeclContext().isRecord()) {
            Kind = ContextKind.StaticDataMember;
          }
        } else if (isa_FieldDecl(ManglingContextDecl)) {
          Kind = ContextKind.DataMember;
        }
      }
    }
  }
  
  // Itanium ABI [5.1.7]:
  //   In the following contexts [...] the one-definition rule requires closure
  //   types in different translation units to "correspond":
  boolean IsInNonspecializedTemplate = !$this().ActiveTemplateInstantiations.empty() || $this().CurContext.isDependentContext();
  switch (Kind) {
   case ContextKind.Normal:
    //  -- the bodies of non-exported nonspecialized template functions
    //  -- the bodies of inline functions
    if ((IsInNonspecializedTemplate
       && !((ManglingContextDecl.$deref() != null) && isa_ParmVarDecl(ManglingContextDecl)))
       || isInInlineFunction($this().CurContext)) {
      ManglingContextDecl.$set(null);
      return $AddrOf($this().Context.getManglingNumberContext(DC));
    }
    
    ManglingContextDecl.$set(null);
    return null;
   case ContextKind.StaticDataMember:
    //  -- the initializers of nonspecialized static members of template classes
    if (!IsInNonspecializedTemplate) {
      ManglingContextDecl.$set(null);
      return null;
    }
   case ContextKind.DataMember:
   case ContextKind.DefaultArgument:
    //  -- default arguments appearing in class definitions
    return $AddrOf($this().ExprEvalContexts.back().getMangleNumberingContext($this().Context));
  }
  throw new llvm_unreachable("unexpected context");
}


/// \brief Create a new lambda closure type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::createLambdaClosureType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 243,
 FQN="clang::Sema::createLambdaClosureType", NM="_ZN5clang4Sema23createLambdaClosureTypeENS_11SourceRangeEPNS_14TypeSourceInfoEbNS_20LambdaCaptureDefaultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema23createLambdaClosureTypeENS_11SourceRangeEPNS_14TypeSourceInfoEbNS_20LambdaCaptureDefaultE")
//</editor-fold>
public final CXXRecordDecl /*P*/ createLambdaClosureType(SourceRange IntroducerRange, 
                       TypeSourceInfo /*P*/ Info, 
                       boolean KnownDependent, 
                       LambdaCaptureDefault CaptureDefault) {
  DeclContext /*P*/ DC = $this().CurContext;
  while (!(DC.isFunctionOrMethod() || DC.isRecord() || DC.isFileContext())) {
    DC = DC.getParent();
  }
  boolean IsGenericLambda = (getGenericLambdaTemplateParameterList($this().getCurLambda(), 
      /*Deref*/$this()) != null);
  // Start constructing the lambda class.
  CXXRecordDecl /*P*/ Class = CXXRecordDecl.CreateLambda($this().Context, DC, Info, 
      IntroducerRange.getBegin(), 
      KnownDependent, 
      IsGenericLambda, 
      CaptureDefault);
  DC.addDecl(Class);
  
  return Class;
}


/// \brief Start the definition of a lambda expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::startLambdaDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 354,
 FQN="clang::Sema::startLambdaDefinition", NM="_ZN5clang4Sema21startLambdaDefinitionEPNS_13CXXRecordDeclENS_11SourceRangeEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema21startLambdaDefinitionEPNS_13CXXRecordDeclENS_11SourceRangeEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE")
//</editor-fold>
public final CXXMethodDecl /*P*/ startLambdaDefinition(CXXRecordDecl /*P*/ Class, 
                     SourceRange IntroducerRange, 
                     TypeSourceInfo /*P*/ MethodTypeInfo, 
                     SourceLocation EndLoc, 
                     ArrayRef<ParmVarDecl /*P*/ > Params) {
  QualType MethodType = MethodTypeInfo.getType();
  TemplateParameterList /*P*/ TemplateParams = getGenericLambdaTemplateParameterList($this().getCurLambda(), /*Deref*/$this());
  // If a lambda appears in a dependent context or is a generic lambda (has
  // template parameters) and has an 'auto' return type, deduce it to a 
  // dependent type.
  if (Class.isDependentContext() || (TemplateParams != null)) {
    /*const*/ FunctionProtoType /*P*/ FPT = MethodType.$arrow().castAs(FunctionProtoType.class);
    QualType Result = FPT.getReturnType();
    if (Result.$arrow().isUndeducedType()) {
      Result.$assignMove($this().SubstAutoType(new QualType(Result), $this().Context.DependentTy.$QualType()));
      MethodType.$assignMove($this().Context.getFunctionType(new QualType(Result), FPT.getParamTypes(), 
              FPT.getExtProtoInfo()));
    }
  }
  
  // C++11 [expr.prim.lambda]p5:
  //   The closure type for a lambda-expression has a public inline function 
  //   call operator (13.5.4) whose parameters and return type are described by
  //   the lambda-expression's parameter-declaration-clause and 
  //   trailing-return-type respectively.
  DeclarationName MethodName = $this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Call);
  DeclarationNameLoc MethodNameLoc/*J*/= new DeclarationNameLoc();
  MethodNameLoc.Unnamed_field.CXXOperatorName.BeginOpNameLoc
     = IntroducerRange.getBegin().getRawEncoding();
  MethodNameLoc.Unnamed_field.CXXOperatorName.EndOpNameLoc
     = IntroducerRange.getEnd().getRawEncoding();
  CXXMethodDecl /*P*/ Method = CXXMethodDecl.Create($this().Context, Class, new SourceLocation(EndLoc), 
      new DeclarationNameInfo(new DeclarationName(MethodName), 
          IntroducerRange.getBegin(), 
          new DeclarationNameLoc(MethodNameLoc)), 
      new QualType(MethodType), MethodTypeInfo, 
      StorageClass.SC_None, 
      /*isInline=*/ true, 
      /*isConstExpr=*/ false, 
      new SourceLocation(EndLoc));
  Method.setAccess(AccessSpecifier.AS_public);
  
  // Temporarily set the lexical declaration context to the current
  // context, so that the Scope stack matches the lexical nesting.
  Method.setLexicalDeclContext($this().CurContext);
  // Create a function template if we have a template parameter list
  FunctionTemplateDecl /*P*/ /*const*/ TemplateMethod = (TemplateParams != null) ? FunctionTemplateDecl.Create($this().Context, Class, 
      Method.getLocation(), new DeclarationName(MethodName), 
      TemplateParams, 
      Method) : null;
  if ((TemplateMethod != null)) {
    TemplateMethod.setLexicalDeclContext($this().CurContext);
    TemplateMethod.setAccess(AccessSpecifier.AS_public);
    Method.setDescribedFunctionTemplate(TemplateMethod);
  }
  
  // Add parameters.
  if (!Params.empty()) {
    Method.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params));
    $this().CheckParmsForFunctionDef(new ArrayRef<ParmVarDecl /*P*/ >(Params), 
        /*CheckParameterNames=*/ false);
    
    for (ParmVarDecl /*P*/ P : Method.parameters())  {
      P.setOwningFunction(Method);
    }
  }
  
  type$ref<Decl /*P*/ > ManglingContextDecl = create_type$ref();
  {
    MangleNumberingContext /*P*/ MCtx = $this().getCurrentMangleNumberContext(Class.getDeclContext(), 
        ManglingContextDecl);
    if ((MCtx != null)) {
      /*uint*/int ManglingNumber = MCtx.getManglingNumber(Method);
      Class.setLambdaMangling(ManglingNumber, ManglingContextDecl.$deref());
    }
  }
  
  return Method;
}


/// \brief Endow the lambda scope info with the relevant properties.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::buildLambdaScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 435,
 FQN="clang::Sema::buildLambdaScope", NM="_ZN5clang4Sema16buildLambdaScopeEPNS_4sema15LambdaScopeInfoEPNS_13CXXMethodDeclENS_11SourceRangeENS_20LambdaCaptureDefaultENS_14SourceLocationEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema16buildLambdaScopeEPNS_4sema15LambdaScopeInfoEPNS_13CXXMethodDeclENS_11SourceRangeENS_20LambdaCaptureDefaultENS_14SourceLocationEbbb")
//</editor-fold>
public final void buildLambdaScope(LambdaScopeInfo /*P*/ LSI, 
                CXXMethodDecl /*P*/ CallOperator, 
                SourceRange IntroducerRange, 
                LambdaCaptureDefault CaptureDefault, 
                SourceLocation CaptureDefaultLoc, 
                boolean ExplicitParams, 
                boolean ExplicitResultType, 
                boolean Mutable) {
  LSI.CallOperator = CallOperator;
  CXXRecordDecl /*P*/ LambdaClass = CallOperator.getParent();
  LSI.Lambda = LambdaClass;
  if (CaptureDefault == LambdaCaptureDefault.LCD_ByCopy) {
    LSI.ImpCaptureStyle = LambdaScopeInfo.ImplicitCaptureStyle.ImpCap_LambdaByval;
  } else if (CaptureDefault == LambdaCaptureDefault.LCD_ByRef) {
    LSI.ImpCaptureStyle = LambdaScopeInfo.ImplicitCaptureStyle.ImpCap_LambdaByref;
  }
  LSI.CaptureDefaultLoc.$assign(CaptureDefaultLoc);
  LSI.IntroducerRange.$assign(IntroducerRange);
  LSI.ExplicitParams = ExplicitParams;
  LSI.Mutable = Mutable;
  if (ExplicitResultType) {
    LSI.ReturnType.$assignMove(CallOperator.getReturnType());
    if (!LSI.ReturnType.$arrow().isDependentType()
       && !LSI.ReturnType.$arrow().isVoidType()) {
      if ($this().RequireCompleteType(CallOperator.getLocStart(), new QualType(LSI.ReturnType), 
          diag.err_lambda_incomplete_result)) {
        // Do nothing.
      }
    }
  } else {
    LSI.HasImplicitReturnType = true;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::buildLambdaInitCaptureInitialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 704,
 FQN="clang::Sema::buildLambdaInitCaptureInitialization", NM="_ZN5clang4Sema36buildLambdaInitCaptureInitializationENS_14SourceLocationEbPNS_14IdentifierInfoEbRPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema36buildLambdaInitCaptureInitializationENS_14SourceLocationEbPNS_14IdentifierInfoEbRPNS_4ExprE")
//</editor-fold>
public final QualType buildLambdaInitCaptureInitialization(SourceLocation Loc, 
                                    boolean ByRef, 
                                    IdentifierInfo /*P*/ Id, 
                                    boolean IsDirectInit, 
                                    final type$ref<Expr /*P*/ /*&*/> Init) {
  TypeLocBuilder TLB = null;
  InitializationSequence InitSeq = null;
  try {
    // Create an 'auto' or 'auto&' TypeSourceInfo that we can use to
    // deduce against.
    QualType DeductType = $this().Context.getAutoDeductType();
    TLB/*J*/= new TypeLocBuilder();
    TLB.pushTypeSpec(new QualType(DeductType)).setNameLoc(new SourceLocation(Loc));
    if (ByRef) {
      DeductType.$assignMove($this().BuildReferenceType(new QualType(DeductType), true, new SourceLocation(Loc), new DeclarationName(Id)));
      assert (!DeductType.isNull()) : "can't build reference to auto";
      TLB.<ReferenceTypeLoc>push(ReferenceTypeLoc.class, new QualType(DeductType)).setSigilLoc(new SourceLocation(Loc));
    }
    TypeSourceInfo /*P*/ TSI = TLB.getTypeSourceInfo($this().Context, new QualType(DeductType));
    
    // Deduce the type of the init capture.
    QualType DeducedType = $this().deduceVarTypeFromInitializer(/*VarDecl*/ (VarDecl /*P*/ )null, new DeclarationName(Id), new QualType(DeductType), TSI, 
        new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc), IsDirectInit, Init.$deref());
    if (DeducedType.isNull()) {
      return new QualType();
    }
    
    // Are we a non-list direct initialization?
    ParenListExpr /*P*/ CXXDirectInit = dyn_cast_ParenListExpr(Init.$deref());
    
    // Perform initialization analysis and ensure any implicit conversions
    // (such as lvalue-to-rvalue) are enforced.
    InitializedEntity Entity = InitializedEntity.InitializeLambdaCapture(Id, new QualType(DeducedType), new SourceLocation(Loc));
    InitializationKind Kind = IsDirectInit ? ((CXXDirectInit != null) ? InitializationKind.CreateDirect(new SourceLocation(Loc), Init.$deref().getLocStart(), Init.$deref().getLocEnd()) : InitializationKind.CreateDirectList(new SourceLocation(Loc))) : InitializationKind.CreateCopy(new SourceLocation(Loc), Init.$deref().getLocStart());
    
    MutableArrayRef<Expr /*P*/ > Args = new MutableArrayRef<Expr /*P*/ >(Init.$deref(), true);
    if ((CXXDirectInit != null)) {
      Args.$assignMove(
          new MutableArrayRef<Expr /*P*/ >(CXXDirectInit.getExprs(), CXXDirectInit.getNumExprs(), true)
      );
    }
    QualType DclT/*J*/= new QualType();
    InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Args));
    ActionResultTTrue<Expr /*P*/ > Result = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), create_type$ptr($AddrOf(DclT)));
    if (Result.isInvalid()) {
      return new QualType();
    }
    Init.$set(Result.getAs(Expr.class));
    
    // The init-capture initialization is a full-expression that must be
    // processed as one before we enter the declcontext of the lambda's
    // call-operator.
    Result.$assignMove($this().ActOnFinishFullExpr(Init.$deref(), new SourceLocation(Loc), /*DiscardedValue*/ false, 
            /*IsConstexpr*/ false, 
            /*IsLambdaInitCaptureInitalizer*/ true));
    if (Result.isInvalid()) {
      return new QualType();
    }
    
    Init.$set(Result.getAs(Expr.class));
    return DeducedType;
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
    if (TLB != null) { TLB.$destroy(); }
  }
}


/// \brief Create a dummy variable within the declcontext of the lambda's
///  call operator, for name lookup purposes for a lambda init capture.
///  
///  CodeGen handles emission of lambda captures, ignoring these dummy
///  variables appropriately.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::createLambdaInitCaptureVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 767,
 FQN="clang::Sema::createLambdaInitCaptureVarDecl", NM="_ZN5clang4Sema30createLambdaInitCaptureVarDeclENS_14SourceLocationENS_8QualTypeEPNS_14IdentifierInfoEjPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema30createLambdaInitCaptureVarDeclENS_14SourceLocationENS_8QualTypeEPNS_14IdentifierInfoEjPNS_4ExprE")
//</editor-fold>
public final VarDecl /*P*/ createLambdaInitCaptureVarDecl(SourceLocation Loc, 
                              QualType InitCaptureType, 
                              IdentifierInfo /*P*/ Id, 
                              /*uint*/int InitStyle, Expr /*P*/ Init) {
  TypeSourceInfo /*P*/ TSI = $this().Context.getTrivialTypeSourceInfo(new QualType(InitCaptureType), 
      new SourceLocation(Loc));
  // Create a dummy variable representing the init-capture. This is not actually
  // used as a variable, and only exists as a way to name and refer to the
  // init-capture.
  // FIXME: Pass in separate source locations for '&' and identifier.
  VarDecl /*P*/ NewVD = VarDecl.Create($this().Context, $this().CurContext, new SourceLocation(Loc), 
      new SourceLocation(Loc), Id, new QualType(InitCaptureType), TSI, StorageClass.SC_Auto);
  NewVD.setInitCapture(true);
  NewVD.setReferenced(true);
  // FIXME: Pass in a VarDecl::InitializationStyle.
  NewVD.setInitStyle(/*static_cast*/VarDecl.InitializationStyle.valueOf(InitStyle));
  NewVD.markUsed($this().Context);
  NewVD.setInit(Init);
  return NewVD;
}


/// \brief Build the implicit field for an init-capture.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::buildInitCaptureField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 788,
 FQN="clang::Sema::buildInitCaptureField", NM="_ZN5clang4Sema21buildInitCaptureFieldEPNS_4sema15LambdaScopeInfoEPNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema21buildInitCaptureFieldEPNS_4sema15LambdaScopeInfoEPNS_7VarDeclE")
//</editor-fold>
public final FieldDecl /*P*/ buildInitCaptureField(LambdaScopeInfo /*P*/ LSI, VarDecl /*P*/ Var) {
  FieldDecl /*P*/ Field = FieldDecl.Create($this().Context, LSI.Lambda, Var.getLocation(), Var.getLocation(), 
      (IdentifierInfo /*P*/ )null, Var.getType(), Var.getTypeSourceInfo(), (Expr /*P*/ )null, false, 
      InClassInitStyle.ICIS_NoInit);
  Field.setImplicit(true);
  Field.setAccess(AccessSpecifier.AS_private);
  LSI.Lambda.addDecl(Field);
  
  LSI.addCapture(Var, /*isBlock*/ false, Var.getType().$arrow().isReferenceType(), 
      /*isNested*/ false, Var.getLocation(), new SourceLocation(), 
      Var.getType(), Var.getInit());
  return Field;
}


/// \brief Note that we have finished the explicit captures for the
/// given lambda.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::finishLambdaExplicitCaptures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 470,
 FQN="clang::Sema::finishLambdaExplicitCaptures", NM="_ZN5clang4Sema28finishLambdaExplicitCapturesEPNS_4sema15LambdaScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema28finishLambdaExplicitCapturesEPNS_4sema15LambdaScopeInfoE")
//</editor-fold>
public final void finishLambdaExplicitCaptures(LambdaScopeInfo /*P*/ LSI) {
  LSI.finishedExplicitCaptures();
}


/// \brief Introduce the lambda parameters into scope.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::addLambdaParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 474,
 FQN="clang::Sema::addLambdaParameters", NM="_ZN5clang4Sema19addLambdaParametersEPNS_13CXXMethodDeclEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema19addLambdaParametersEPNS_13CXXMethodDeclEPNS_5ScopeE")
//</editor-fold>
public final void addLambdaParameters(CXXMethodDecl /*P*/ CallOperator, Scope /*P*/ CurScope) {
  // Introduce our parameters into the function scope
  for (/*uint*/int p = 0, NumParams = CallOperator.getNumParams();
       $less_uint(p, NumParams); ++p) {
    ParmVarDecl /*P*/ Param = CallOperator.getParamDecl(p);
    
    // If this has an identifier, add it to the scope stack.
    if ((CurScope != null) && (Param.getIdentifier() != null)) {
      $this().CheckShadow(CurScope, Param);
      
      $this().PushOnScopeChains(Param, CurScope);
    }
  }
}


/// \brief Deduce a block or lambda's return type based on the return
/// statements present in the body.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::deduceClosureReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 615,
 FQN="clang::Sema::deduceClosureReturnType", NM="_ZN5clang4Sema23deduceClosureReturnTypeERNS_4sema18CapturingScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema23deduceClosureReturnTypeERNS_4sema18CapturingScopeInfoE")
//</editor-fold>
public final void deduceClosureReturnType(final CapturingScopeInfo /*&*/ CSI) {
  assert (CSI.HasImplicitReturnType);
  // If it was ever a placeholder, it had to been deduced to DependentTy.
  assert (CSI.ReturnType.isNull() || !CSI.ReturnType.$arrow().isUndeducedType());
  assert ((!isa_LambdaScopeInfo(CSI) || !$this().getLangOpts().CPlusPlus14)) : "lambda expressions use auto deduction in C++14 onwards";
  
  // C++ core issue 975:
  //   If a lambda-expression does not include a trailing-return-type,
  //   it is as if the trailing-return-type denotes the following type:
  //     - if there are no return statements in the compound-statement,
  //       or all return statements return either an expression of type
  //       void or no expression or braced-init-list, the type void;
  //     - otherwise, if all return statements return an expression
  //       and the types of the returned expressions after
  //       lvalue-to-rvalue conversion (4.1 [conv.lval]),
  //       array-to-pointer conversion (4.2 [conv.array]), and
  //       function-to-pointer conversion (4.3 [conv.func]) are the
  //       same, that common type;
  //     - otherwise, the program is ill-formed.
  //
  // C++ core issue 1048 additionally removes top-level cv-qualifiers
  // from the types of returned expressions to match the C++14 auto
  // deduction rules.
  //
  // In addition, in blocks in non-C++ modes, if all of the return
  // statements are enumerator-like expressions of some type T, where
  // T has a name for linkage, then we infer the return type of the
  // block to be that type.
  
  // First case: no return statements, implicit void return type.
  final ASTContext /*&*/ Ctx = $this().getASTContext();
  if (CSI.Returns.empty()) {
    // It's possible there were simply no /valid/ return statements.
    // In this case, the first one we found may have at least given us a type.
    if (CSI.ReturnType.isNull()) {
      CSI.ReturnType.$assignMove(Ctx.VoidTy.$QualType());
    }
    return;
  }
  
  // Second case: at least one return statement has dependent type.
  // Delay type checking until instantiation.
  assert (!CSI.ReturnType.isNull()) : "We should have a tentative return type.";
  if (CSI.ReturnType.$arrow().isDependentType()) {
    return;
  }
  
  // Try to apply the enum-fuzz rule.
  if (!$this().getLangOpts().CPlusPlus) {
    assert (isa_BlockScopeInfo(CSI));
    /*const*/ EnumDecl /*P*/ ED = findCommonEnumForBlockReturns(new ArrayRef<ReturnStmt /*P*/ >(CSI.Returns, true));
    if ((ED != null)) {
      CSI.ReturnType.$assignMove($this().Context.getTypeDeclType(ED));
      adjustBlockReturnsToEnum(/*Deref*/$this(), new ArrayRef<ReturnStmt /*P*/ >(CSI.Returns, true), new QualType(CSI.ReturnType));
      return;
    }
  }
  
  // Third case: only one return statement. Don't bother doing extra work!
  type$ptr<ReturnStmt /*P*/ /*P*/> I = $tryClone(CSI.Returns.begin());
  type$ptr<ReturnStmt /*P*/ /*P*/> E = $tryClone(CSI.Returns.end());
  if ($eq_ptr(I.$add(1), E)) {
    return;
  }
  
  // General case: many return statements.
  // Check that they all have compatible return types.
  
  // We require the return types to strictly match here.
  // Note that we've already done the required promotions as part of
  // processing the return statement.
  for (; $noteq_ptr(I, E); I.$preInc()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ ReturnStmt /*P*/ RS = I.$star();
      /*const*/ Expr /*P*/ RetE = RS.getRetValue$Const();
      
      QualType ReturnType = ((RetE != null) ? RetE.getType() : $this().Context.VoidTy.$QualType()).getUnqualifiedType();
      if ($eq_CanQual$T_CanQual$U($this().Context.getCanonicalFunctionResultType(new QualType(ReturnType)), 
          $this().Context.getCanonicalFunctionResultType(new QualType(CSI.ReturnType)))) {
        continue;
      }
      
      // FIXME: This is a poor diagnostic for ReturnStmts without expressions.
      // TODO: It's possible that the *first* return is the divergent one.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RS.getLocStart(), 
                      diag.err_typecheck_missing_return_type_incompatible)), 
                  ReturnType), CSI.ReturnType), 
          isa_LambdaScopeInfo(CSI)));
    } finally {
      $c$.$destroy();
    }
    // Continue iterating so that we keep emitting diagnostics.
  }
}


/// ActOnStartOfLambdaDefinition - This is called just before we start
/// parsing the body of a lambda; it analyzes the explicit captures and
/// arguments, and sets up various data-structures for the body of the
/// lambda.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartOfLambdaDefinition">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 803,
 FQN="clang::Sema::ActOnStartOfLambdaDefinition", NM="_ZN5clang4Sema28ActOnStartOfLambdaDefinitionERNS_16LambdaIntroducerERNS_10DeclaratorEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema28ActOnStartOfLambdaDefinitionERNS_16LambdaIntroducerERNS_10DeclaratorEPNS_5ScopeE")
//</editor-fold>
public final void ActOnStartOfLambdaDefinition(final LambdaIntroducer /*&*/ Intro, 
                            final Declarator /*&*/ ParamInfo, 
                            Scope /*P*/ CurScope) {
  SmallSetT$PLess$T$P<IdentifierInfo /*P*/ > CaptureNames = null;
  try {
    // Determine if we're within a context where we know that the lambda will
    // be dependent, because there are template parameters in scope.
    boolean KnownDependent = false;
    LambdaScopeInfo /*P*/ /*const*/ LSI = $this().getCurLambda();
    assert ((LSI != null)) : "LambdaScopeInfo should be on stack!";
    
    // The lambda-expression's closure type might be dependent even if its
    // semantic context isn't, if it appears within a default argument of a
    // function template.
    if ((CurScope.getTemplateParamParent() != null)) {
      KnownDependent = true;
    }
    
    // Determine the signature of the call operator.
    TypeSourceInfo /*P*/ MethodTyInfo;
    boolean ExplicitParams = true;
    boolean ExplicitResultType = true;
    boolean ContainsUnexpandedParameterPack = false;
    SourceLocation EndLoc/*J*/= new SourceLocation();
    SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(8, (ParmVarDecl /*P*/ )null);
    if (ParamInfo.getNumTypeObjects() == 0) {
      // C++11 [expr.prim.lambda]p4:
      //   If a lambda-expression does not include a lambda-declarator, it is as 
      //   if the lambda-declarator were ().
      FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo($this().Context.getDefaultCallingConvention(/*IsVariadic=*/ false, /*IsCXXMethod=*/ true));
      EPI.HasTrailingReturn = true;
      EPI.TypeQuals |= DeclSpec.TQ.TQ_const.getValue();
      // C++1y [expr.prim.lambda]:
      //   The lambda return type is 'auto', which is replaced by the
      //   trailing-return type if provided and/or deduced from 'return'
      //   statements
      // We don't do this before C++1y, because we don't support deduced return
      // types there.
      QualType DefaultTypeForNoTrailingReturn = $this().getLangOpts().CPlusPlus14 ? $this().Context.getAutoDeductType() : $this().Context.DependentTy.$QualType();
      QualType MethodTy = $this().Context.getFunctionType(new QualType(DefaultTypeForNoTrailingReturn), new ArrayRef<QualType>(None, false), EPI);
      MethodTyInfo = $this().Context.getTrivialTypeSourceInfo(new QualType(MethodTy));
      ExplicitParams = false;
      ExplicitResultType = false;
      EndLoc.$assignMove(Intro.Range.getEnd());
    } else {
      assert (ParamInfo.isFunctionDeclarator()) : "lambda-declarator is a function";
      final DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = ParamInfo.getFunctionTypeInfo();
      
      // C++11 [expr.prim.lambda]p5:
      //   This function call operator is declared const (9.3.1) if and only if 
      //   the lambda-expression's parameter-declaration-clause is not followed 
      //   by mutable. It is neither virtual nor declared volatile. [...]
      if (!FTI.hasMutableQualifier()) {
        FTI.TypeQuals |= $int2uint_4bits(DeclSpec.TQ.TQ_const.getValue());
      }
      
      MethodTyInfo = $this().GetTypeForDeclarator(ParamInfo, CurScope);
      assert ((MethodTyInfo != null)) : "no type from lambda-declarator";
      EndLoc.$assignMove(ParamInfo.getSourceRange().getEnd());
      
      ExplicitResultType = FTI.hasTrailingReturnType();
      if (FTIHasNonVoidParameters(FTI)) {
        Params.reserve(FTI.NumParams);
        for (/*uint*/int i = 0, e = FTI.NumParams; i != e; ++i)  {
          Params.push_back(cast_ParmVarDecl(FTI.Params.$at(i).Param));
        }
      }
      
      // Check for unexpanded parameter packs in the method type.
      if (MethodTyInfo.getType().$arrow().containsUnexpandedParameterPack()) {
        ContainsUnexpandedParameterPack = true;
      }
    }
    
    CXXRecordDecl /*P*/ Class = $this().createLambdaClosureType(new SourceRange(Intro.Range), MethodTyInfo, 
        KnownDependent, Intro.Default);
    
    CXXMethodDecl /*P*/ Method = $this().startLambdaDefinition(Class, new SourceRange(Intro.Range), 
        MethodTyInfo, new SourceLocation(EndLoc), new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
    if (ExplicitParams) {
      $this().CheckCXXDefaultArguments(Method);
    }
    
    // Attributes on the lambda apply to the method.  
    $this().ProcessDeclAttributes(CurScope, Method, ParamInfo);
    
    // Introduce the function call operator as the current declaration context.
    $this().PushDeclContext(CurScope, Method);
    
    // Build the lambda scope.
    $this().buildLambdaScope(LSI, Method, new SourceRange(Intro.Range), Intro.Default, new SourceLocation(Intro.DefaultLoc), 
        ExplicitParams, ExplicitResultType, !Method.isConst());
    
    // C++11 [expr.prim.lambda]p9:
    //   A lambda-expression whose smallest enclosing scope is a block scope is a
    //   local lambda expression; any other lambda expression shall not have a
    //   capture-default or simple-capture in its lambda-introducer.
    //
    // For simple-captures, this is covered by the check below that any named
    // entity is a variable that can be captured.
    //
    // For DR1632, we also allow a capture-default in any context where we can
    // odr-use 'this' (in particular, in a default initializer for a non-static
    // data member).
    if (Intro.Default != LambdaCaptureDefault.LCD_None && !Class.getParent().isFunctionOrMethod()
       && ($this().getCurrentThisType().isNull()
       || $this().CheckCXXThisCapture(new SourceLocation(), /*Explicit*/ true, 
        /*BuildAndDiagnose*/ false))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Intro.DefaultLoc), diag.err_capture_default_non_local)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Distinct capture names, for diagnostics.
    CaptureNames/*J*/= new SmallSetT$PLess$T$P<IdentifierInfo /*P*/ >(8);
    
    // Handle explicit captures.
    SourceLocation PrevCaptureLoc = Intro.Default == LambdaCaptureDefault.LCD_None ? Intro.Range.getBegin() : new SourceLocation(Intro.DefaultLoc);
    for (type$ptr<LambdaIntroducer.LambdaCapture /*P*/ > C = $tryClone(Intro.Captures.begin()), /*P*/ E = $tryClone(Intro.Captures.end()); $noteq_ptr(C, E);
         PrevCaptureLoc.$assign(C./*->*/$star().Loc) , C.$preInc()) {
      if (C./*->*/$star().Kind == LambdaCaptureKind.LCK_This || C./*->*/$star().Kind == LambdaCaptureKind.LCK_StarThis) {
        if (C./*->*/$star().Kind == LambdaCaptureKind.LCK_StarThis) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), !$this().getLangOpts().CPlusPlus1z ? diag.ext_star_this_lambda_capture_cxx1z : diag.warn_cxx14_compat_star_this_lambda_capture)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // C++11 [expr.prim.lambda]p8:
        //   An identifier or this shall not appear more than once in a 
        //   lambda-capture.
        if (LSI.isCXXThisCaptured()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_capture_more_than_once)), 
                        /*KEEP_STR*/"'this'"), new SourceRange(LSI.getCXXThisCapture().getLocation())), 
                FixItHint.CreateRemoval(new SourceRange($this().getLocForEndOfToken(new SourceLocation(PrevCaptureLoc)), /*NO_COPY*/C./*->*/$star().Loc))));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        // C++1z [expr.prim.lambda]p8:
        //  If a lambda-capture includes a capture-default that is =, each
        //  simple-capture of that lambda-capture shall be of the form "&
        //  identifier" or "* this". [ Note: The form [&,this] is redundant but
        //  accepted for compatibility with ISO C++14. --end note ]
        if (Intro.Default == LambdaCaptureDefault.LCD_ByCopy && C./*->*/$star().Kind != LambdaCaptureKind.LCK_StarThis) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_this_capture_with_copy_default)), 
                FixItHint.CreateRemoval(new SourceRange($this().getLocForEndOfToken(new SourceLocation(PrevCaptureLoc)), /*NO_COPY*/C./*->*/$star().Loc))));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        // C++11 [expr.prim.lambda]p12:
        //   If this is captured by a local lambda expression, its nearest
        //   enclosing function shall be a non-static member function.
        QualType ThisCaptureType = $this().getCurrentThisType();
        if (ThisCaptureType.isNull()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_this_capture)), true));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        $this().CheckCXXThisCapture(new SourceLocation(C./*->*/$star().Loc), /*Explicit=*/ true, /*BuildAndDiagnose*/ true, 
            /*FunctionScopeIndexToStopAtPtr*/ (/*const*/uint$ptr/*uint P*/ )null, 
            C./*->*/$star().Kind == LambdaCaptureKind.LCK_StarThis);
        continue;
      }
      assert ((C./*->*/$star().Id != null)) : "missing identifier for capture";
      if (C./*->*/$star().Init.isInvalid()) {
        continue;
      }
      
      VarDecl /*P*/ Var = null;
      if (C./*->*/$star().Init.isUsable()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), $this().getLangOpts().CPlusPlus14 ? diag.warn_cxx11_compat_init_capture : diag.ext_init_capture)));
          if (C./*->*/$star().Init.get().containsUnexpandedParameterPack()) {
            ContainsUnexpandedParameterPack = true;
          }
          // If the initializer expression is usable, but the InitCaptureType
          // is not, then an error has occurred - so ignore the capture for now.
          // for e.g., [n{0}] { }; <-- if no <initializer_list> is included.
          // FIXME: we should create the init capture variable and mark it invalid 
          // in this case.
          if (C./*->*/$star().InitCaptureType.getQualType().isNull()) {
            continue;
          }
          
          /*uint*/int InitStyle = -1;
          switch (C./*->*/$star().InitKind) {
           case NoInit:
            throw new llvm_unreachable("not an init-capture?");
           case CopyInit:
            InitStyle = VarDecl.InitializationStyle.CInit.getValue();
            break;
           case DirectInit:
            InitStyle = VarDecl.InitializationStyle.CallInit.getValue();
            break;
           case ListInit:
            InitStyle = VarDecl.InitializationStyle.ListInit.getValue();
            break;
          }
          Var = $this().createLambdaInitCaptureVarDecl(new SourceLocation(C./*->*/$star().Loc), C./*->*/$star().InitCaptureType.getQualType(), 
              C./*->*/$star().Id, InitStyle, C./*->*/$star().Init.get());
          // C++1y [expr.prim.lambda]p11:
          //   An init-capture behaves as if it declares and explicitly
          //   captures a variable [...] whose declarative region is the
          //   lambda-expression's compound-statement
          if ((Var != null)) {
            $this().PushOnScopeChains(Var, CurScope, false);
          }
        } finally {
          $c$.$destroy();
        }
      } else {
        LookupResult R = null;
        try {
          assert (C./*->*/$star().InitKind == LambdaCaptureInitKind.NoInit) : "init capture has valid but null init?";
          
          // C++11 [expr.prim.lambda]p8:
          //   If a lambda-capture includes a capture-default that is &, the 
          //   identifiers in the lambda-capture shall not be preceded by &.
          //   If a lambda-capture includes a capture-default that is =, [...]
          //   each identifier it contains shall be preceded by &.
          if (C./*->*/$star().Kind == LambdaCaptureKind.LCK_ByRef && Intro.Default == LambdaCaptureDefault.LCD_ByRef) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_reference_capture_with_reference_default)), 
                  FixItHint.CreateRemoval(new SourceRange($this().getLocForEndOfToken(new SourceLocation(PrevCaptureLoc)), /*NO_COPY*/C./*->*/$star().Loc))));
              continue;
            } finally {
              $c$.$destroy();
            }
          } else if (C./*->*/$star().Kind == LambdaCaptureKind.LCK_ByCopy && Intro.Default == LambdaCaptureDefault.LCD_ByCopy) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_copy_capture_with_copy_default)), 
                  FixItHint.CreateRemoval(new SourceRange($this().getLocForEndOfToken(new SourceLocation(PrevCaptureLoc)), /*NO_COPY*/C./*->*/$star().Loc))));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          
          // C++11 [expr.prim.lambda]p10:
          //   The identifiers in a capture-list are looked up using the usual
          //   rules for unqualified name lookup (3.4.1)
          DeclarationNameInfo Name/*J*/= new DeclarationNameInfo(new DeclarationName(C./*->*/$star().Id), new SourceLocation(C./*->*/$star().Loc));
          R/*J*/= new LookupResult(/*Deref*/$this(), Name, LookupNameKind.LookupOrdinaryName);
          $this().LookupName(R, CurScope);
          if (R.isAmbiguous()) {
            continue;
          }
          if (R.empty()) {
            CXXScopeSpec ScopeSpec = null;
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // FIXME: Disable corrections that would add qualification?
              ScopeSpec/*J*/= new CXXScopeSpec();
              if ($c$.clean($this().DiagnoseEmptyLookup(CurScope, ScopeSpec, R, 
                  $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DeclFilterCCC<VarDecl>(VarDecl.class)))))))) {
                continue;
              }
            } finally {
              if (ScopeSpec != null) { ScopeSpec.$destroy(); }
              $c$.$destroy();
            }
          }
          
          Var = R.<VarDecl>getAsSingle(VarDecl.class);
          if ((Var != null) && $this().DiagnoseUseOfDecl(Var, new SourceLocation(C./*->*/$star().Loc))) {
            continue;
          }
        } finally {
          if (R != null) { R.$destroy(); }
        }
      }
      
      // C++11 [expr.prim.lambda]p8:
      //   An identifier or this shall not appear more than once in a
      //   lambda-capture.
      if (!CaptureNames.insert(C./*->*/$star().Id).second) {
        if ((Var != null) && LSI.isCaptured(Var)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_capture_more_than_once)), 
                        C./*->*/$star().Id), new SourceRange(LSI.getCapture(Var).getLocation())), 
                FixItHint.CreateRemoval(new SourceRange($this().getLocForEndOfToken(new SourceLocation(PrevCaptureLoc)), /*NO_COPY*/C./*->*/$star().Loc))));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Previous capture captured something different (one or both was
            // an init-cpature): no fixit.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_capture_more_than_once)), C./*->*/$star().Id));
          } finally {
            $c$.$destroy();
          }
        }
        continue;
      }
      
      // C++11 [expr.prim.lambda]p10:
      //   [...] each such lookup shall find a variable with automatic storage
      //   duration declared in the reaching scope of the local lambda expression.
      // Note that the 'reaching scope' check happens in tryCaptureVariable().
      if (!(Var != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_capture_does_not_name_variable)), C./*->*/$star().Id));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Ignore invalid decls; they'll just confuse the code later.
      if (Var.isInvalidDecl()) {
        continue;
      }
      if (!Var.hasLocalStorage()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().Loc), diag.err_capture_non_automatic_variable)), C./*->*/$star().Id));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Var.getLocation(), diag.note_previous_decl)), C./*->*/$star().Id));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // C++11 [expr.prim.lambda]p23:
      //   A capture followed by an ellipsis is a pack expansion (14.5.3).
      SourceLocation EllipsisLoc/*J*/= new SourceLocation();
      if (C./*->*/$star().EllipsisLoc.isValid()) {
        if (Var.isParameterPack()) {
          EllipsisLoc.$assign(C./*->*/$star().EllipsisLoc);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(C./*->*/$star().EllipsisLoc), diag.err_pack_expansion_without_parameter_packs)), 
                new SourceRange(/*NO_COPY*/C./*->*/$star().Loc)));
          } finally {
            $c$.$destroy();
          }
          // Just ignore the ellipsis.
        }
      } else if (Var.isParameterPack()) {
        ContainsUnexpandedParameterPack = true;
      }
      if (C./*->*/$star().Init.isUsable()) {
        $this().buildInitCaptureField(LSI, Var);
      } else {
        TryCaptureKind Kind = C./*->*/$star().Kind == LambdaCaptureKind.LCK_ByRef ? TryCaptureKind.TryCapture_ExplicitByRef : TryCaptureKind.TryCapture_ExplicitByVal;
        $this().tryCaptureVariable(Var, new SourceLocation(C./*->*/$star().Loc), Kind, new SourceLocation(EllipsisLoc));
      }
    }
    $this().finishLambdaExplicitCaptures(LSI);
    
    LSI.ContainsUnexpandedParameterPack = ContainsUnexpandedParameterPack;
    
    // Add lambda parameters into scope.
    $this().addLambdaParameters(Method, CurScope);
    
    // Enter a new evaluation context to insulate the lambda from any
    // cleanups from the enclosing full-expression.
    $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated);
  } finally {
    if (CaptureNames != null) { CaptureNames.$destroy(); }
  }
}


/// ActOnLambdaError - If there is an error parsing a lambda, this callback
/// is invoked to pop the information about the lambda.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnLambdaError">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 1120,
 FQN="clang::Sema::ActOnLambdaError", NM="_ZN5clang4Sema16ActOnLambdaErrorENS_14SourceLocationEPNS_5ScopeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema16ActOnLambdaErrorENS_14SourceLocationEPNS_5ScopeEb")
//</editor-fold>
public final void ActOnLambdaError(SourceLocation StartLoc, Scope /*P*/ CurScope) {
  ActOnLambdaError(StartLoc, CurScope, 
                false);
}
public final void ActOnLambdaError(SourceLocation StartLoc, Scope /*P*/ CurScope, 
                boolean IsInstantiation/*= false*/) {
  LambdaScopeInfo /*P*/ LSI = cast_LambdaScopeInfo($this().FunctionScopes.back());
  
  // Leave the expression-evaluation context.
  $this().DiscardCleanupsInEvaluationContext();
  $this().PopExpressionEvaluationContext();
  
  // Leave the context of the lambda.
  if (!IsInstantiation) {
    $this().PopDeclContext();
  }
  
  // Finalize the lambda.
  CXXRecordDecl /*P*/ Class = LSI.Lambda;
  Class.setInvalidDecl();
  SmallVector<Decl /*P*/> Fields/*J*/= new SmallVector<Decl /*P*/>(4, Class.fields().begin(), Class.fields().end(), null);
  $this().ActOnFields((Scope /*P*/ )null, Class.getLocation(), Class, new ArrayRef<Decl /*P*/ >(Fields, true), new SourceLocation(), 
      new SourceLocation(), (AttributeList /*P*/ )null);
  $this().CheckCompletedCXXClass(Class);
  
  $this().PopFunctionScopeInfo();
}


/// ActOnLambdaExpr - This is called when the body of a lambda expression
/// was successfully completed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnLambdaExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 1464,
 FQN="clang::Sema::ActOnLambdaExpr", NM="_ZN5clang4Sema15ActOnLambdaExprENS_14SourceLocationEPNS_4StmtEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema15ActOnLambdaExprENS_14SourceLocationEPNS_4StmtEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnLambdaExpr(SourceLocation StartLoc, Stmt /*P*/ Body, 
               Scope /*P*/ CurScope) {
  LambdaScopeInfo LSI = null;
  try {
    LSI = new LambdaScopeInfo($Deref(cast_LambdaScopeInfo($this().FunctionScopes.back())));
    $this().ActOnFinishFunctionBody(LSI.CallOperator, Body);
    return $this().BuildLambdaExpr(new SourceLocation(StartLoc), Body.getLocEnd(), $AddrOf(LSI));
  } finally {
    if (LSI != null) { LSI.$destroy(); }
  }
}


/// \brief Complete a lambda-expression having processed and attached the
/// lambda body.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildLambdaExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 1487,
 FQN="clang::Sema::BuildLambdaExpr", NM="_ZN5clang4Sema15BuildLambdaExprENS_14SourceLocationES1_PNS_4sema15LambdaScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema15BuildLambdaExprENS_14SourceLocationES1_PNS_4sema15LambdaScopeInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildLambdaExpr(SourceLocation StartLoc, SourceLocation EndLoc, 
               LambdaScopeInfo /*P*/ LSI) {
  // Collect information from the lambda scope.
  SmallVector<LambdaCapture> Captures/*J*/= new SmallVector<LambdaCapture>(4, new LambdaCapture());
  SmallVector<Expr /*P*/ > CaptureInits/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  SourceLocation CaptureDefaultLoc = new SourceLocation(LSI.CaptureDefaultLoc);
  LambdaCaptureDefault CaptureDefault = mapImplicitCaptureStyle(LSI.ImpCaptureStyle);
  CXXRecordDecl /*P*/ Class;
  CXXMethodDecl /*P*/ CallOperator;
  SourceRange IntroducerRange/*J*/= new SourceRange();
  boolean ExplicitParams;
  boolean ExplicitResultType;
  CleanupInfo LambdaCleanup/*J*/= new CleanupInfo();
  boolean ContainsUnexpandedParameterPack;
  SmallVector<VarDecl /*P*/ > ArrayIndexVars/*J*/= new SmallVector<VarDecl /*P*/ >(4, (VarDecl /*P*/ )null);
  SmallVectorUInt ArrayIndexStarts/*J*/= new SmallVectorUInt(4, 0);
  {
    CallOperator = LSI.CallOperator;
    Class = LSI.Lambda;
    IntroducerRange.$assign(LSI.IntroducerRange);
    ExplicitParams = LSI.ExplicitParams;
    ExplicitResultType = !LSI.HasImplicitReturnType;
    LambdaCleanup.$assign(LSI.Cleanup);
    ContainsUnexpandedParameterPack = LSI.ContainsUnexpandedParameterPack;
    
    CallOperator.setLexicalDeclContext(Class);
    Decl /*P*/ TemplateOrNonTemplateCallOperatorDecl = (CallOperator.getDescribedFunctionTemplate() != null) ? CallOperator.getDescribedFunctionTemplate() : cast_Decl(CallOperator);
    
    TemplateOrNonTemplateCallOperatorDecl.setLexicalDeclContext(Class);
    Class.addDecl(TemplateOrNonTemplateCallOperatorDecl);
    
    $this().PopExpressionEvaluationContext();
    
    // Translate captures.
    specific_decl_iterator<FieldDecl> CurField = Class.field_begin();
    for (/*uint*/int I = 0, N = LSI.Captures.size(); I != N; ++I , CurField.$preInc()) {
      LambdaScopeInfo.Capture From = new LambdaScopeInfo.Capture(LSI.Captures.$at(I));
      assert (!From.isBlockCapture()) : "Cannot capture __block variables";
      boolean IsImplicit = $greatereq_uint(I, LSI.NumExplicitCaptures);
      
      // Handle 'this' capture.
      if (From.isThisCapture()) {
        Captures.push_back(new LambdaCapture(From.getLocation(), IsImplicit, 
                From.isCopyCapture() ? LambdaCaptureKind.LCK_StarThis : LambdaCaptureKind.LCK_This));
        CaptureInits.push_back(From.getInitExpr());
        ArrayIndexStarts.push_back(ArrayIndexVars.size());
        continue;
      }
      if (From.isVLATypeCapture()) {
        Captures.push_back(new LambdaCapture(From.getLocation(), IsImplicit, LambdaCaptureKind.LCK_VLAType));
        CaptureInits.push_back((Expr /*P*/ /*const*/)null);
        ArrayIndexStarts.push_back(ArrayIndexVars.size());
        continue;
      }
      
      VarDecl /*P*/ Var = From.getVariable();
      LambdaCaptureKind Kind = From.isCopyCapture() ? LambdaCaptureKind.LCK_ByCopy : LambdaCaptureKind.LCK_ByRef;
      Captures.push_back(new LambdaCapture(From.getLocation(), IsImplicit, Kind, 
              Var, From.getEllipsisLoc()));
      Expr /*P*/ Init = From.getInitExpr();
      if (!(Init != null)) {
        ActionResultTTrue<Expr /*P*/ > InitResult = performLambdaVarCaptureInitialization(/*Deref*/$this(), From, CurField.$star(), ArrayIndexVars, ArrayIndexStarts);
        if (InitResult.isInvalid()) {
          return ExprError();
        }
        Init = InitResult.get();
      } else {
        ArrayIndexStarts.push_back(ArrayIndexVars.size());
      }
      CaptureInits.push_back(Init);
    }
    
    // C++11 [expr.prim.lambda]p6:
    //   The closure type for a lambda-expression with no lambda-capture
    //   has a public non-virtual non-explicit const conversion function
    //   to pointer to function having the same parameter and return
    //   types as the closure type's function call operator.
    if (Captures.empty() && CaptureDefault == LambdaCaptureDefault.LCD_None) {
      addFunctionPointerConversion(/*Deref*/$this(), new SourceRange(IntroducerRange), Class, 
          CallOperator);
    }
    
    // Objective-C++:
    //   The closure type for a lambda-expression has a public non-virtual
    //   non-explicit const conversion function to a block pointer having the
    //   same parameter and return types as the closure type's function call
    //   operator.
    // FIXME: Fix generic lambda to block conversions.
    if ($this().getLangOpts().Blocks && $this().getLangOpts().ObjC1
       && !Class.isGenericLambda()) {
      addBlockPointerConversion(/*Deref*/$this(), new SourceRange(IntroducerRange), Class, CallOperator);
    }
    
    // Finalize the lambda class.
    SmallVector<Decl /*P*/> Fields/*J*/= new SmallVector<Decl /*P*/>(4, Class.fields().begin(), Class.fields().end(), null);
    $this().ActOnFields((Scope /*P*/ )null, Class.getLocation(), Class, new ArrayRef<Decl /*P*/ >(Fields, true), new SourceLocation(), 
        new SourceLocation(), (AttributeList /*P*/ )null);
    $this().CheckCompletedCXXClass(Class);
  }
  
  $this().Cleanup.mergeFrom(new CleanupInfo(LambdaCleanup));
  
  LambdaExpr /*P*/ Lambda = LambdaExpr.Create($this().Context, Class, new SourceRange(IntroducerRange), 
      CaptureDefault, new SourceLocation(CaptureDefaultLoc), 
      new ArrayRef<LambdaCapture>(Captures, false), 
      ExplicitParams, ExplicitResultType, 
      new ArrayRef<Expr /*P*/ >(CaptureInits, true), new ArrayRef<VarDecl /*P*/ >(ArrayIndexVars, true), 
      new ArrayRefUInt(ArrayIndexStarts), new SourceLocation(EndLoc), 
      ContainsUnexpandedParameterPack);
  if (!$this().CurContext.isDependentContext()) {
    switch ($this().ExprEvalContexts.back().Context) {
     case Unevaluated:
     case UnevaluatedAbstract:
     case ConstantEvaluated:
      // We don't actually diagnose this case immediately, because we
      // could be within a context where we might find out later that
      // the expression is potentially evaluated (e.g., for typeid).
      $this().ExprEvalContexts.back().Lambdas.push_back(Lambda);
      break;
     case DiscardedStatement:
     case PotentiallyEvaluated:
     case PotentiallyEvaluatedIfUsed:
      break;
    }
  }
  
  return $this().MaybeBindToTemporary(Lambda);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildBlockForLambdaConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 1634,
 FQN="clang::Sema::BuildBlockForLambdaConversion", NM="_ZN5clang4Sema29BuildBlockForLambdaConversionENS_14SourceLocationES1_PNS_17CXXConversionDeclEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4Sema29BuildBlockForLambdaConversionENS_14SourceLocationES1_PNS_17CXXConversionDeclEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildBlockForLambdaConversion(SourceLocation CurrentLocation, 
                             SourceLocation ConvLocation, 
                             CXXConversionDecl /*P*/ Conv, 
                             Expr /*P*/ Src) {
  // Make sure that the lambda call operator is marked used.
  CXXRecordDecl /*P*/ Lambda = Conv.getParent();
  CXXMethodDecl /*P*/ CallOperator = cast_CXXMethodDecl(Lambda.lookup($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Call)).front());
  CallOperator.setReferenced();
  CallOperator.markUsed($this().Context);
  
  ActionResultTTrue<Expr /*P*/ > Init = $this().PerformCopyInitialization(InitializedEntity.InitializeBlock(new SourceLocation(ConvLocation), 
          Src.getType(), 
          /*NRVO=*/ false), 
      new SourceLocation(CurrentLocation), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Src));
  if (!Init.isInvalid()) {
    Init.$assignMove($this().ActOnFinishFullExpr(Init.get()));
  }
  if (Init.isInvalid()) {
    return ExprError();
  }
  
  // Create the new block to be returned.
  BlockDecl /*P*/ Block = BlockDecl.Create($this().Context, $this().CurContext, new SourceLocation(ConvLocation));
  
  // Set the type information.
  Block.setSignatureAsWritten(CallOperator.getTypeSourceInfo());
  Block.setIsVariadic(CallOperator.isVariadic());
  Block.setBlockMissingReturnType(false);
  
  // Add parameters.
  SmallVector<ParmVarDecl /*P*/ > BlockParams/*J*/= new SmallVector<ParmVarDecl /*P*/ >(4, (ParmVarDecl /*P*/ )null);
  for (/*uint*/int I = 0, N = CallOperator.getNumParams(); I != N; ++I) {
    ParmVarDecl /*P*/ From = CallOperator.getParamDecl(I);
    BlockParams.push_back(ParmVarDecl.Create($this().Context, Block, 
            From.getLocStart(), 
            From.getLocation(), 
            From.getIdentifier(), 
            From.getType(), 
            From.getTypeSourceInfo(), 
            From.getStorageClass(), 
            /*DefaultArg=*/ (Expr /*P*/ )null));
  }
  Block.setParams(new ArrayRef<ParmVarDecl /*P*/ >(BlockParams, true));
  
  Block.setIsConversionFromLambda(true);
  
  // Add capture. The capture uses a fake variable, which doesn't correspond
  // to any actual memory location. However, the initializer copy-initializes
  // the lambda object.
  TypeSourceInfo /*P*/ CapVarTSI = $this().Context.getTrivialTypeSourceInfo(Src.getType());
  VarDecl /*P*/ CapVar = VarDecl.Create($this().Context, Block, new SourceLocation(ConvLocation), 
      new SourceLocation(ConvLocation), (IdentifierInfo /*P*/ )null, 
      Src.getType(), CapVarTSI, 
      StorageClass.SC_None);
  BlockDecl.Capture Capture/*J*/= new BlockDecl.Capture(/*Variable=*/ CapVar, /*ByRef=*/ false, 
      /*Nested=*/ false, /*Copy=*/ Init.get());
  Block.setCaptures($this().Context, new ArrayRef<BlockDecl.Capture>(Capture, false), /*CapturesCXXThis=*/ false);
  
  // Add a fake function body to the block. IR generation is responsible
  // for filling in the actual body, which cannot be expressed as an AST.
  Block.setBody(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CompoundStmt(new SourceLocation(ConvLocation))));
  
  // Create the block literal expression.
  Expr /*P*/ BuildBlock = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new BlockExpr(Block, Conv.getConversionType()));
  $this().ExprCleanupObjects.push_back(Block);
  $this().Cleanup.setExprNeedsCleanups(true);
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, BuildBlock);
}

} // END OF class Sema_SemaLambda
