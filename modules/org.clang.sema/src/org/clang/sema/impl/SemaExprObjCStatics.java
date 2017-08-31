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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clank.java.stdimpl.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.edit.Commit;
import org.clang.edit.EditGlobals;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.ast.java.ObjCBridgedTypeAttr;


//<editor-fold defaultstate="collapsed" desc="static type SemaExprObjCStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=Tpl__ZL17getObjCBridgeAttrPKN5clang11TypedefTypeE;Tpl__ZL21CheckObjCBridgeCFCastRN5clang4SemaENS_8QualTypeEPNS_4ExprERbb;Tpl__ZL21CheckObjCBridgeNSCastRN5clang4SemaENS_8QualTypeEPNS_4ExprERbb;_ZL10isAnyCLike22ARCConversionTypeClass;_ZL13checkCocoaAPIRN5clang4SemaEPKNS_15ObjCMessageExprE;_ZL15isAnyRetainable22ARCConversionTypeClass;_ZL18applyCocoaAPICheckRN5clang4SemaEPKNS_15ObjCMessageExprEjPFbS4_RKNS_5NSAPIERNS_4edit6CommitEE;_ZL20validateBoxingMethodRN5clang4SemaENS_14SourceLocationEPKNS_17ObjCInterfaceDeclENS_8SelectorEPKNS_14ObjCMethodDeclE;_ZL21stripObjCInstanceTypeRN5clang10ASTContextENS_8QualTypeE;_ZL22maybeUndoReclaimObjectPN5clang4ExprE;_ZL24ClassKindFromLiteralKindN5clang4Sema15ObjCLiteralKindE;_ZL24getNSNumberFactoryMethodRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbNS_11SourceRangeE;_ZL25diagnoseObjCARCConversionRN5clang4SemaENS_11SourceRangeENS_8QualTypeE22ARCConversionTypeClassPNS_4ExprES6_S4_NS0_21CheckedConversionKindE;_ZL27DiagnoseMismatchedSelectorsRN5clang4SemaENS_14SourceLocationEPNS_14ObjCMethodDeclES2_S2_b;_ZL28addFixitForObjCARCConversionRN5clang4SemaERNS_17DiagnosticBuilderENS0_21CheckedConversionKindENS_14SourceLocationENS_8QualTypeEPNS_4ExprES8_PKcSA_;_ZL28classifyTypeForARCConversionN5clang8QualTypeE;_ZL28getBaseMessageSendResultTypeRN5clang4SemaENS_8QualTypeEPNS_14ObjCMethodDeclEbb;_ZL29ObjCBridgeRelatedAttrFromTypeN5clang8QualTypeERPNS_15TypedefNameDeclE;_ZL30RemoveSelectorFromWarningCacheRN5clang4SemaEPNS_4ExprE;_ZL32ValidateObjCLiteralInterfaceDeclRN5clang4SemaEPNS_17ObjCInterfaceDeclENS_14SourceLocationENS0_15ObjCLiteralKindE;_ZL32findExplicitInstancetypeDeclarerPKN5clang14ObjCMethodDeclENS_8QualTypeE;_ZL33CheckObjCCollectionLiteralElementRN5clang4SemaEPNS_4ExprENS_8QualTypeEb;_ZL33LookupObjCInterfaceDeclForLiteralRN5clang4SemaENS_14SourceLocationENS0_15ObjCLiteralKindE;_ZL39DiagnoseCStringFormatDirectiveInObjCAPIRN5clang4SemaEPNS_14ObjCMethodDeclENS_8SelectorEPPNS_4ExprEj;_ZL45HelperToDiagnoseMismatchedMethodsInGlobalPoolRN5clang4SemaENS_14SourceLocationES2_S2_PNS_14ObjCMethodDeclERNS_14ObjCMethodListE;_ZN12_GLOBAL__N_15mergeENS_9ACCResultES0_; -static-type=SemaExprObjCStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaExprObjCStatics {


/// \brief Emits an error if the given method does not exist, or if the return
/// type is not an Objective-C object.
//<editor-fold defaultstate="collapsed" desc="validateBoxingMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 146,
 FQN="validateBoxingMethod", NM="_ZL20validateBoxingMethodRN5clang4SemaENS_14SourceLocationEPKNS_17ObjCInterfaceDeclENS_8SelectorEPKNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL20validateBoxingMethodRN5clang4SemaENS_14SourceLocationEPKNS_17ObjCInterfaceDeclENS_8SelectorEPKNS_14ObjCMethodDeclE")
//</editor-fold>
public static boolean validateBoxingMethod(final Sema /*&*/ S, SourceLocation Loc, 
                    /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                    Selector Sel, /*const*/ ObjCMethodDecl /*P*/ Method) {
  if (!(Method != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Is there a better way to avoid quotes than using getName()?
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_undeclared_boxing_method)), Sel), Class.getName()));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Make sure the return type is reasonable.
  QualType ReturnType = Method.getReturnType();
  if (!ReturnType.$arrow().isObjCObjectPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_objc_literal_method_sig)), 
          Sel));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Method.getLocation(), diag.note_objc_literal_method_return)), 
          ReturnType));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  return true;
}


/// \brief Maps ObjCLiteralKind to NSClassIdKindKind
//<editor-fold defaultstate="collapsed" desc="ClassKindFromLiteralKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 169,
 FQN="ClassKindFromLiteralKind", NM="_ZL24ClassKindFromLiteralKindN5clang4Sema15ObjCLiteralKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL24ClassKindFromLiteralKindN5clang4Sema15ObjCLiteralKindE")
//</editor-fold>
public static NSAPI.NSClassIdKindKind ClassKindFromLiteralKind(Sema.ObjCLiteralKind LiteralKind) {
  switch (LiteralKind) {
   case LK_Array:
    return NSAPI.NSClassIdKindKind.ClassId_NSArray;
   case LK_Dictionary:
    return NSAPI.NSClassIdKindKind.ClassId_NSDictionary;
   case LK_Numeric:
    return NSAPI.NSClassIdKindKind.ClassId_NSNumber;
   case LK_String:
    return NSAPI.NSClassIdKindKind.ClassId_NSString;
   case LK_Boxed:
    return NSAPI.NSClassIdKindKind.ClassId_NSValue;
   case LK_Block:
   case LK_None:
    
    // there is no corresponding matching
    // between LK_None/LK_Block and NSClassIdKindKind
    break;
  }
  throw new llvm_unreachable("LiteralKind can't be converted into a ClassKind");
}


/// \brief Validates ObjCInterfaceDecl availability.
/// ObjCInterfaceDecl, used to create ObjC literals, should be defined
/// if clang not in a debugger mode.
//<editor-fold defaultstate="collapsed" desc="ValidateObjCLiteralInterfaceDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 195,
 FQN="ValidateObjCLiteralInterfaceDecl", NM="_ZL32ValidateObjCLiteralInterfaceDeclRN5clang4SemaEPNS_17ObjCInterfaceDeclENS_14SourceLocationENS0_15ObjCLiteralKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL32ValidateObjCLiteralInterfaceDeclRN5clang4SemaEPNS_17ObjCInterfaceDeclENS_14SourceLocationENS0_15ObjCLiteralKindE")
//</editor-fold>
public static boolean ValidateObjCLiteralInterfaceDecl(final Sema /*&*/ S, ObjCInterfaceDecl /*P*/ Decl, 
                                SourceLocation Loc, 
                                Sema.ObjCLiteralKind LiteralKind) {
  if (!(Decl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      NSAPI.NSClassIdKindKind Kind = ClassKindFromLiteralKind(LiteralKind);
      IdentifierInfo /*P*/ II = S.NSAPIObj.$arrow().getNSClassId(Kind);
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_undeclared_objc_literal_class)), 
              II.getName()), LiteralKind));
      return false;
    } finally {
      $c$.$destroy();
    }
  } else if (!Decl.hasDefinition() && !S.getLangOpts().DebuggerObjCLiteral) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_undeclared_objc_literal_class)), 
              Decl.getName()), LiteralKind));
      $c$.clean($c$.track(S.Diag(Decl.getLocation(), diag.note_forward_class)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  return true;
}


/// \brief Looks up ObjCInterfaceDecl of a given NSClassIdKindKind.
/// Used to create ObjC literals, such as NSDictionary (@{}),
/// NSArray (@[]) and Boxed Expressions (@())
//<editor-fold defaultstate="collapsed" desc="LookupObjCInterfaceDeclForLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 217,
 FQN="LookupObjCInterfaceDeclForLiteral", NM="_ZL33LookupObjCInterfaceDeclForLiteralRN5clang4SemaENS_14SourceLocationENS0_15ObjCLiteralKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL33LookupObjCInterfaceDeclForLiteralRN5clang4SemaENS_14SourceLocationENS0_15ObjCLiteralKindE")
//</editor-fold>
public static ObjCInterfaceDecl /*P*/ LookupObjCInterfaceDeclForLiteral(final Sema /*&*/ S, 
                                 SourceLocation Loc, 
                                 Sema.ObjCLiteralKind LiteralKind) {
  NSAPI.NSClassIdKindKind ClassKind = ClassKindFromLiteralKind(LiteralKind);
  IdentifierInfo /*P*/ II = S.NSAPIObj.$arrow().getNSClassId(ClassKind);
  NamedDecl /*P*/ IF = S.LookupSingleName(S.TUScope, new DeclarationName(II), new SourceLocation(Loc), 
      Sema.LookupNameKind.LookupOrdinaryName);
  ObjCInterfaceDecl /*P*/ ID = dyn_cast_or_null_ObjCInterfaceDecl(IF);
  if (!(ID != null) && S.getLangOpts().DebuggerObjCLiteral) {
    final ASTContext /*&*/ Context = S.Context;
    TranslationUnitDecl /*P*/ TU = Context.getTranslationUnitDecl();
    ID = ObjCInterfaceDecl.Create(Context, TU, new SourceLocation(), II, 
        (ObjCTypeParamList /*P*/ )null, (ObjCInterfaceDecl /*P*/ )null, new SourceLocation());
  }
  if (!ValidateObjCLiteralInterfaceDecl(S, ID, new SourceLocation(Loc), LiteralKind)) {
    ID = null;
  }
  
  return ID;
}


/// \brief Retrieve the NSNumber factory method that should be used to create
/// an Objective-C literal for the given type.
//<editor-fold defaultstate="collapsed" desc="getNSNumberFactoryMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 241,
 FQN="getNSNumberFactoryMethod", NM="_ZL24getNSNumberFactoryMethodRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbNS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL24getNSNumberFactoryMethodRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbNS_11SourceRangeE")
//</editor-fold>
public static ObjCMethodDecl /*P*/ getNSNumberFactoryMethod(final Sema /*&*/ S, SourceLocation Loc, 
                        QualType NumberType) {
  return getNSNumberFactoryMethod(S, Loc, 
                        NumberType, 
                        false, 
                        new SourceRange());
}
public static ObjCMethodDecl /*P*/ getNSNumberFactoryMethod(final Sema /*&*/ S, SourceLocation Loc, 
                        QualType NumberType, 
                        boolean isLiteral/*= false*/) {
  return getNSNumberFactoryMethod(S, Loc, 
                        NumberType, 
                        isLiteral, 
                        new SourceRange());
}
public static ObjCMethodDecl /*P*/ getNSNumberFactoryMethod(final Sema /*&*/ S, SourceLocation Loc, 
                        QualType NumberType, 
                        boolean isLiteral/*= false*/, 
                        SourceRange R/*= SourceRange()*/) {
  Optional<NSAPI.NSNumberLiteralMethodKind> Kind = S.NSAPIObj.$arrow().getNSNumberFactoryMethodKind(new QualType(NumberType));
  if (!Kind.$bool()) {
    if (isLiteral) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_invalid_nsnumber_type)), 
                NumberType), R));
      } finally {
        $c$.$destroy();
      }
    }
    return null;
  }
  
  // If we already looked up this method, we're done.
  if ((S.NSNumberLiteralMethods[Kind.$star().getValue()] != null)) {
    return S.NSNumberLiteralMethods[Kind.$star().getValue()];
  }
  
  Selector Sel = S.NSAPIObj.$arrow().getNSNumberLiteralSelector(Kind.$star(), 
      /*Instance=*/ false);
  
  final ASTContext /*&*/ CX = S.Context;
  
  // Look up the NSNumber class, if we haven't done so already. It's cached
  // in the Sema instance.
  if (!(S.NSNumberDecl != null)) {
    S.NSNumberDecl = LookupObjCInterfaceDeclForLiteral(S, new SourceLocation(Loc), 
        Sema.ObjCLiteralKind.LK_Numeric);
    if (!(S.NSNumberDecl != null)) {
      return null;
    }
  }
  if (S.NSNumberPointer.isNull()) {
    // generate the pointer to NSNumber type.
    QualType NSNumberObject = CX.getObjCInterfaceType(S.NSNumberDecl);
    S.NSNumberPointer.$assignMove(CX.getObjCObjectPointerType(new QualType(NSNumberObject)));
  }
  
  // Look for the appropriate method within NSNumber.
  ObjCMethodDecl /*P*/ Method = S.NSNumberDecl.lookupClassMethod(new Selector(Sel));
  if (!(Method != null) && S.getLangOpts().DebuggerObjCLiteral) {
    // create a stub definition this NSNumber factory method.
    TypeSourceInfo /*P*/ ReturnTInfo = null;
    Method
       = ObjCMethodDecl.Create(CX, new SourceLocation(), new SourceLocation(), new Selector(Sel), 
        new QualType(S.NSNumberPointer), ReturnTInfo, S.NSNumberDecl, 
        /*isInstance=*/ false, /*isVariadic=*/ false, 
        /*isPropertyAccessor=*/ false, 
        /*isImplicitlyDeclared=*/ true, 
        /*isDefined=*/ false, ObjCMethodDecl.ImplementationControl.Required, 
        /*HasRelatedResultType=*/ false);
    ParmVarDecl /*P*/ value = ParmVarDecl.Create(S.Context, Method, 
        new SourceLocation(), new SourceLocation(), 
        $AddrOf(CX.Idents.get(new StringRef(/*KEEP_STR*/"value"))), 
        new QualType(NumberType), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        StorageClass.SC_None, (Expr /*P*/ )null);
    Method.setMethodParams(S.Context, new ArrayRef<ParmVarDecl /*P*/ >(value, true), new ArrayRef<SourceLocation>(None, false));
  }
  if (!validateBoxingMethod(S, new SourceLocation(Loc), S.NSNumberDecl, new Selector(Sel), Method)) {
    return null;
  }
  
  // Note: if the parameter type is out-of-line, we'll catch it later in the
  // implicit conversion.
  S.NSNumberLiteralMethods[Kind.$star().getValue()] = Method;
  return Method;
}


/// \brief Check that the given expression is a valid element of an Objective-C
/// collection literal.
//<editor-fold defaultstate="collapsed" desc="CheckObjCCollectionLiteralElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 384,
 FQN="CheckObjCCollectionLiteralElement", NM="_ZL33CheckObjCCollectionLiteralElementRN5clang4SemaEPNS_4ExprENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL33CheckObjCCollectionLiteralElementRN5clang4SemaEPNS_4ExprENS_8QualTypeEb")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > CheckObjCCollectionLiteralElement(final Sema /*&*/ S, Expr /*P*/ Element, 
                                 QualType T) {
  return CheckObjCCollectionLiteralElement(S, Element, 
                                 T, 
                                 false);
}
public static ActionResultTTrue<Expr /*P*/ > CheckObjCCollectionLiteralElement(final Sema /*&*/ S, Expr /*P*/ Element, 
                                 QualType T, 
                                 boolean ArrayLiteral/*= false*/) {
  // If the expression is type-dependent, there's nothing for us to do.
  if (Element.isTypeDependent()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Element);
  }
  
  ActionResultTTrue<Expr /*P*/ > Result = S.CheckPlaceholderExpr(Element);
  if (Result.isInvalid()) {
    return ExprError();
  }
  Element = Result.get();
  
  // In C++, check for an implicit conversion to an Objective-C object pointer 
  // type.
  if (S.getLangOpts().CPlusPlus && Element.getType().$arrow().isRecordType()) {
    InitializationSequence Seq = null;
    try {
      InitializedEntity Entity = InitializedEntity.InitializeParameter(S.Context, new QualType(T), 
          /*Consumed=*/ false);
      InitializationKind Kind = InitializationKind.CreateCopy(Element.getLocStart(), 
          new SourceLocation());
      Seq/*J*/= new InitializationSequence(S, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Element, true));
      if (!Seq.Failed()) {
        return Seq.Perform(S, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Element, true));
      }
    } finally {
      if (Seq != null) { Seq.$destroy(); }
    }
  }
  
  Expr /*P*/ OrigElement = Element;
  
  // Perform lvalue-to-rvalue conversion.
  Result.$assignMove(S.DefaultLvalueConversion(Element));
  if (Result.isInvalid()) {
    return ExprError();
  }
  Element = Result.get();
  
  // Make sure that we have an Objective-C pointer type or block.
  if (!Element.getType().$arrow().isObjCObjectPointerType()
     && !Element.getType().$arrow().isBlockPointerType()) {
    boolean Recovered = false;
    
    // If this is potentially an Objective-C numeric literal, add the '@'.
    if (isa_IntegerLiteral(OrigElement)
       || isa_CharacterLiteral(OrigElement)
       || isa_FloatingLiteral(OrigElement)
       || isa_ObjCBoolLiteralExpr(OrigElement)
       || isa_CXXBoolLiteralExpr(OrigElement)) {
      if (S.NSAPIObj.$arrow().getNSNumberFactoryMethodKind(OrigElement.getType()).$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          int Which = isa_CharacterLiteral(OrigElement) ? 1 : (isa_CXXBoolLiteralExpr(OrigElement)
             || isa_ObjCBoolLiteralExpr(OrigElement)) ? 2 : 3;
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OrigElement.getLocStart(), diag.err_box_literal_collection)), 
                      Which), OrigElement.getSourceRange()), 
              FixItHint.CreateInsertion(OrigElement.getLocStart(), new StringRef(/*KEEP_STR*/$AT))));
          
          Result.$assignMove(S.BuildObjCNumericLiteral(OrigElement.getLocStart(), 
                  OrigElement));
          if (Result.isInvalid()) {
            return ExprError();
          }
          
          Element = Result.get();
          Recovered = true;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      // If this is potentially an Objective-C string literal, add the '@'.
      StringLiteral /*P*/ String = dyn_cast_StringLiteral(OrigElement);
      if ((String != null)) {
        if (String.isAscii()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OrigElement.getLocStart(), diag.err_box_literal_collection)), 
                        0), OrigElement.getSourceRange()), 
                FixItHint.CreateInsertion(OrigElement.getLocStart(), new StringRef(/*KEEP_STR*/$AT))));
            
            Result.$assignMove(S.BuildObjCStringLiteral(OrigElement.getLocStart(), String));
            if (Result.isInvalid()) {
              return ExprError();
            }
            
            Element = Result.get();
            Recovered = true;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (!Recovered) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Element.getLocStart(), diag.err_invalid_collection_element)), 
            Element.getType()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (ArrayLiteral) {
    {
      ObjCStringLiteral /*P*/ getString = dyn_cast_ObjCStringLiteral(OrigElement);
      if ((getString != null)) {
        {
          StringLiteral /*P*/ SL = getString.getString();
          if ((SL != null)) {
            /*uint*/int numConcat = SL.getNumConcatenated();
            if ($greater_uint(numConcat, 1)) {
              // Only warn if the concatenated string doesn't come from a macro.
              boolean hasMacro = false;
              for (/*uint*/int i = 0; $less_uint(i, numConcat); ++i)  {
                if (SL.getStrTokenLoc(i).isMacroID()) {
                  hasMacro = true;
                  break;
                }
              }
              if (!hasMacro) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Element.getLocStart(), 
                          diag.warn_concatenated_nsarray_literal)), 
                      Element.getType()));
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
    }
  }
  
  // Make sure that the element has the type that the container factory 
  // function expects. 
  return S.PerformCopyInitialization(InitializedEntity.InitializeParameter(S.Context, new QualType(T), 
          /*Consumed=*/ false), 
      Element.getLocStart(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Element));
}

//<editor-fold defaultstate="collapsed" desc="HelperToDiagnoseMismatchedMethodsInGlobalPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1097,
 FQN="HelperToDiagnoseMismatchedMethodsInGlobalPool", NM="_ZL45HelperToDiagnoseMismatchedMethodsInGlobalPoolRN5clang4SemaENS_14SourceLocationES2_S2_PNS_14ObjCMethodDeclERNS_14ObjCMethodListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL45HelperToDiagnoseMismatchedMethodsInGlobalPoolRN5clang4SemaENS_14SourceLocationES2_S2_PNS_14ObjCMethodDeclERNS_14ObjCMethodListE")
//</editor-fold>
public static boolean HelperToDiagnoseMismatchedMethodsInGlobalPool(final Sema /*&*/ S, 
                                             SourceLocation AtLoc, 
                                             SourceLocation LParenLoc, 
                                             SourceLocation RParenLoc, 
                                             ObjCMethodDecl /*P*/ Method, 
                                             final ObjCMethodList /*&*/ MethList) {
  ObjCMethodList /*P*/ M = $AddrOf(MethList);
  boolean Warned = false;
  for (M = M.getNext(); (M != null); M = M.getNext()) {
    ObjCMethodDecl /*P*/ MatchingMethodDecl = M.getMethod();
    if (MatchingMethodDecl == Method
       || isa_ObjCImplDecl(MatchingMethodDecl.getDeclContext())
       || MatchingMethodDecl.getSelector().$noteq(Method.getSelector())) {
      continue;
    }
    if (!S.MatchTwoMethodDeclarations(Method, 
        MatchingMethodDecl, Sema.MethodMatchStrategy.MMS_loose)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (!Warned) {
          Warned = true;
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AtLoc), diag.warning_multiple_selectors)), 
                      Method.getSelector()), FixItHint.CreateInsertion(/*NO_COPY*/LParenLoc, new StringRef(/*KEEP_STR*/$LPAREN))), 
              FixItHint.CreateInsertion(/*NO_COPY*/RParenLoc, new StringRef(/*KEEP_STR*/$RPAREN))));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Method.getLocation(), diag.note_method_declared_at)), 
              Method.getDeclName()));
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(MatchingMethodDecl.getLocation(), diag.note_method_declared_at)), 
            MatchingMethodDecl.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  return Warned;
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseMismatchedSelectors">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1128,
 FQN="DiagnoseMismatchedSelectors", NM="_ZL27DiagnoseMismatchedSelectorsRN5clang4SemaENS_14SourceLocationEPNS_14ObjCMethodDeclES2_S2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL27DiagnoseMismatchedSelectorsRN5clang4SemaENS_14SourceLocationEPNS_14ObjCMethodDeclES2_S2_b")
//</editor-fold>
public static void DiagnoseMismatchedSelectors(final Sema /*&*/ S, SourceLocation AtLoc, 
                           ObjCMethodDecl /*P*/ Method, 
                           SourceLocation LParenLoc, 
                           SourceLocation RParenLoc, 
                           boolean WarnMultipleSelectors) {
  if (!WarnMultipleSelectors
     || S.Diags.isIgnored(diag.warning_multiple_selectors, new SourceLocation())) {
    return;
  }
  boolean Warned = false;
  for (DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> b = S.MethodPool.begin(), 
      e = S.MethodPool.end(); b.$noteq(/*NO_ITER_COPY*/e); b.$postInc()) {
    // first, instance methods
    final ObjCMethodList /*&*/ InstMethList = b.$arrow().second.first;
    if (HelperToDiagnoseMismatchedMethodsInGlobalPool(S, new SourceLocation(AtLoc), new SourceLocation(LParenLoc), new SourceLocation(RParenLoc), 
        Method, InstMethList)) {
      Warned = true;
    }
    
    // second, class methods
    final ObjCMethodList /*&*/ ClsMethList = b.$arrow().second.second;
    if (HelperToDiagnoseMismatchedMethodsInGlobalPool(S, new SourceLocation(AtLoc), new SourceLocation(LParenLoc), new SourceLocation(RParenLoc), 
        Method, ClsMethList) || Warned) {
      return;
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="stripObjCInstanceType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1251,
 FQN="stripObjCInstanceType", NM="_ZL21stripObjCInstanceTypeRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL21stripObjCInstanceTypeRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static QualType stripObjCInstanceType(final ASTContext /*&*/ Context, QualType T) {
  QualType origType = new QualType(T);
  {
    Optional<NullabilityKind> nullability = AttributedType.stripOuterNullability(T);
    if (nullability.$bool()) {
      if ($eq_QualType$C(T, Context.getObjCInstanceType())) {
        return Context.getAttributedType(AttributedType.getNullabilityAttrKind(nullability.$star()), 
            Context.getObjCIdType(), 
            Context.getObjCIdType());
      }
      
      return origType;
    }
  }
  if ($eq_QualType$C(T, Context.getObjCInstanceType())) {
    return Context.getObjCIdType();
  }
  
  return origType;
}


/// Determine the result type of a message send based on the receiver type,
/// method, and the kind of message send.
///
/// This is the "base" result type, which will still need to be adjusted
/// to account for nullability.
//<editor-fold defaultstate="collapsed" desc="getBaseMessageSendResultType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1275,
 FQN="getBaseMessageSendResultType", NM="_ZL28getBaseMessageSendResultTypeRN5clang4SemaENS_8QualTypeEPNS_14ObjCMethodDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL28getBaseMessageSendResultTypeRN5clang4SemaENS_8QualTypeEPNS_14ObjCMethodDeclEbb")
//</editor-fold>
public static QualType getBaseMessageSendResultType(final Sema /*&*/ S, 
                            QualType ReceiverType, 
                            ObjCMethodDecl /*P*/ Method, 
                            boolean isClassMessage, 
                            boolean isSuperMessage) {
  assert ((Method != null)) : "Must have a method";
  if (!Method.hasRelatedResultType()) {
    return Method.getSendResultType(new QualType(ReceiverType));
  }
  
  final ASTContext /*&*/ Context = S.Context;
  
  // Local function that transfers the nullability of the method's
  // result type to the returned result.
  QualType2QualType transferNullability = /*[&]*/ (QualType type) -> {
        {
          // If the method's result type has nullability, extract it.
          Optional<NullabilityKind> nullability = Method.getSendResultType(new QualType(ReceiverType)).$arrow().
              getNullability(Context);
          if (nullability.$bool()) {
            // Strip off any outer nullability sugar from the provided type.
            /*J:(void)*/AttributedType.stripOuterNullability(type);
            
            // Form a new attributed type using the method result type's nullability.
            return Context.getAttributedType(AttributedType.getNullabilityAttrKind(nullability.$star()), 
                new QualType(type), 
                new QualType(type));
          }
        }
        
        return new QualType(JD$Move.INSTANCE, type);
      };
  
  // If a method has a related return type:
  //   - if the method found is an instance method, but the message send
  //     was a class message send, T is the declared return type of the method
  //     found
  if (Method.isInstanceMethod() && isClassMessage) {
    return stripObjCInstanceType(Context, 
        Method.getSendResultType(new QualType(ReceiverType)));
  }
  
  //   - if the receiver is super, T is a pointer to the class of the
  //     enclosing method definition
  if (isSuperMessage) {
    {
      ObjCMethodDecl /*P*/ CurMethod = S.getCurMethodDecl();
      if ((CurMethod != null)) {
        {
          ObjCInterfaceDecl /*P*/ Class = CurMethod.getClassInterface();
          if ((Class != null)) {
            return transferNullability.$call(
                Context.getObjCObjectPointerType(Context.getObjCInterfaceType(Class))
            );
          }
        }
      }
    }
  }
  
  //   - if the receiver is the name of a class U, T is a pointer to U
  if ((ReceiverType.$arrow().getAsObjCInterfaceType() != null)) {
    return transferNullability.$call(Context.getObjCObjectPointerType(new QualType(ReceiverType)));
  }
  //   - if the receiver is of type Class or qualified Class type,
  //     T is the declared return type of the method.
  if (ReceiverType.$arrow().isObjCClassType()
     || ReceiverType.$arrow().isObjCQualifiedClassType()) {
    return stripObjCInstanceType(Context, 
        Method.getSendResultType(new QualType(ReceiverType)));
  }
  
  //   - if the receiver is id, qualified id, Class, or qualified Class, T
  //     is the receiver type, otherwise
  //   - T is the type of the receiver expression.
  return transferNullability.$call(new QualType(ReceiverType));
}


/// Look for an ObjC method whose result type exactly matches the given type.
//<editor-fold defaultstate="collapsed" desc="findExplicitInstancetypeDeclarer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1405,
 FQN="findExplicitInstancetypeDeclarer", NM="_ZL32findExplicitInstancetypeDeclarerPKN5clang14ObjCMethodDeclENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL32findExplicitInstancetypeDeclarerPKN5clang14ObjCMethodDeclENS_8QualTypeE")
//</editor-fold>
public static /*const*/ ObjCMethodDecl /*P*/ findExplicitInstancetypeDeclarer(/*const*/ ObjCMethodDecl /*P*/ MD, 
                                QualType instancetype) {
  if ($eq_QualType$C(MD.getReturnType(), instancetype)) {
    return MD;
  }
  {
    
    // For these purposes, a method in an @implementation overrides a
    // declaration in the @interface.
    /*const*/ ObjCImplDecl /*P*/ impl = dyn_cast_ObjCImplDecl(MD.getDeclContext$Const());
    if ((impl != null)) {
      /*const*/ ObjCContainerDecl /*P*/ iface;
      {
        /*const*/ ObjCCategoryImplDecl /*P*/ catImpl = dyn_cast_ObjCCategoryImplDecl(impl);
        if ((catImpl != null)) {
          iface = catImpl.getCategoryDecl();
        } else {
          iface = impl.getClassInterface$Const();
        }
      }
      
      /*const*/ ObjCMethodDecl /*P*/ ifaceMD = iface.getMethod(MD.getSelector(), MD.isInstanceMethod());
      if ((ifaceMD != null)) {
        return findExplicitInstancetypeDeclarer(ifaceMD, new QualType(instancetype));
      }
    }
  }
  
  SmallVector</*const*/ ObjCMethodDecl /*P*/ > overrides/*J*/= new SmallVector</*const*/ ObjCMethodDecl /*P*/ >(4, (/*const*/ ObjCMethodDecl /*P*/ )null);
  MD.getOverriddenMethods(overrides);
  for (/*uint*/int i = 0, e = overrides.size(); i != e; ++i) {
    {
      /*const*/ ObjCMethodDecl /*P*/ result = findExplicitInstancetypeDeclarer(overrides.$at(i), new QualType(instancetype));
      if ((result != null)) {
        return result;
      }
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="applyCocoaAPICheck">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2219,
 FQN="applyCocoaAPICheck", NM="_ZL18applyCocoaAPICheckRN5clang4SemaEPKNS_15ObjCMessageExprEjPFbS4_RKNS_5NSAPIERNS_4edit6CommitEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL18applyCocoaAPICheckRN5clang4SemaEPKNS_15ObjCMessageExprEjPFbS4_RKNS_5NSAPIERNS_4edit6CommitEE")
//</editor-fold>
public static void applyCocoaAPICheck(final Sema /*&*/ S, /*const*/ ObjCMessageExpr /*P*/ Msg, 
                  /*uint*/int DiagID, 
                  ObjCMessageExprNSAPICommit2Bool refactor) {
  Commit ECommit = null;
  try {
    SourceLocation MsgLoc = Msg.getExprLoc();
    if (S.Diags.isIgnored(DiagID, /*NO_COPY*/MsgLoc)) {
      return;
    }
    
    final SourceManager /*&*/ SM = S.SourceMgr;
    ECommit/*J*/= new Commit(SM, S.LangOpts);
    if (refactor.$call(Msg, S.NSAPIObj.$star(), ECommit)) {
      DiagnosticBuilder Builder = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*FIXME: Initializer produces not destroyed temporary!*/Builder = $c$.clean(new DiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MsgLoc), DiagID)), 
                    Msg.getSelector()), Msg.getSourceRange())));
        // FIXME: Don't emit diagnostic at all if fixits are non-commitable.
        if (!ECommit.isCommitable()) {
          return;
        }
        for (type$ptr<Commit.Edit> I = ECommit.edit_begin(), /*P*/ E = ECommit.edit_end(); $noteq_iter(I, E); I.$preInc()) {
          final /*const*/ Commit.Edit /*&*/ Edit = I.$star();
          switch (Edit.Kind) {
           case Act_Insert:
            Builder.AddFixItHint(FixItHint.CreateInsertion(/*NO_COPY*/Edit.OrigLoc, 
                    /*NO_COPY*/Edit.Text, 
                    Edit.BeforePrev));
            break;
           case Act_InsertFromRange:
            Builder.AddFixItHint(FixItHint.CreateInsertionFromRange(/*NO_COPY*/Edit.OrigLoc, 
                    Edit.getInsertFromRange(SM), 
                    Edit.BeforePrev));
            break;
           case Act_Remove:
            Builder.AddFixItHint(FixItHint.CreateRemoval(Edit.getFileRange(SM)));
            break;
          }
        }
      } finally {
        if (Builder != null) { Builder.$destroy(); }
        $c$.$destroy();
      }
    }
  } finally {
    if (ECommit != null) { ECommit.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="checkCocoaAPI">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2258,
 FQN="checkCocoaAPI", NM="_ZL13checkCocoaAPIRN5clang4SemaEPKNS_15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL13checkCocoaAPIRN5clang4SemaEPKNS_15ObjCMessageExprE")
//</editor-fold>
public static void checkCocoaAPI(final Sema /*&*/ S, /*const*/ ObjCMessageExpr /*P*/ Msg) {
  applyCocoaAPICheck(S, Msg, diag.warn_objc_redundant_literal_use, 
      /*FuncRef*/EditGlobals::rewriteObjCRedundantCallWithLiteral);
}


/// \brief Diagnose use of %s directive in an NSString which is being passed
/// as formatting string to formatting method.
//<editor-fold defaultstate="collapsed" desc="DiagnoseCStringFormatDirectiveInObjCAPI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2265,
 FQN="DiagnoseCStringFormatDirectiveInObjCAPI", NM="_ZL39DiagnoseCStringFormatDirectiveInObjCAPIRN5clang4SemaEPNS_14ObjCMethodDeclENS_8SelectorEPPNS_4ExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL39DiagnoseCStringFormatDirectiveInObjCAPIRN5clang4SemaEPNS_14ObjCMethodDeclENS_8SelectorEPPNS_4ExprEj")
//</editor-fold>
public static void DiagnoseCStringFormatDirectiveInObjCAPI(final Sema /*&*/ S, 
                                       ObjCMethodDecl /*P*/ Method, 
                                       Selector Sel, 
                                       type$ptr<Expr/*P*/> Args, /*uint*/int NumArgs) {
  uint$ref Idx = create_uint$ref(0);
  boolean Format = false;
  ObjCStringFormatFamily SFFamily = Sel.getStringFormatFamily();
  if (SFFamily == ObjCStringFormatFamily.SFF_NSString) {
    Idx.$set(0);
    Format = true;
  } else if ((Method != null)) {
    for (/*const*/ FormatAttr /*P*/ I : Method.specific_attrs(FormatAttr.class)) {
      if (S.GetFormatNSStringIdx(I, Idx)) {
        Format = true;
        break;
      }
    }
  }
  if (!Format || $lesseq_uint(NumArgs, Idx.$deref())) {
    return;
  }
  
  Expr /*P*/ FormatExpr = Args.$at(Idx.$deref());
  {
    ObjCStringLiteral /*P*/ OSL = dyn_cast_ObjCStringLiteral(FormatExpr.IgnoreParenImpCasts());
    if ((OSL != null)) {
      StringLiteral /*P*/ FormatString = OSL.getString();
      if (S.FormatStringHasSArg(FormatString)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FormatExpr.getExprLoc(), diag.warn_objc_cdirective_format_string)), 
                      /*KEEP_STR*/"%s"), 0), 0));
          if ((Method != null)) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Method.getLocation(), diag.note_method_declared_at)), 
                Method.getDeclName()));
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="RemoveSelectorFromWarningCache">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3024,
 FQN="RemoveSelectorFromWarningCache", NM="_ZL30RemoveSelectorFromWarningCacheRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL30RemoveSelectorFromWarningCacheRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static void RemoveSelectorFromWarningCache(final Sema /*&*/ S, Expr /*P*/ Arg) {
  {
    ObjCSelectorExpr /*P*/ OSE = dyn_cast_ObjCSelectorExpr(Arg.IgnoreParenCasts());
    if ((OSE != null)) {
      Selector Sel = OSE.getSelector();
      SourceLocation Loc = OSE.getAtLoc();
      StdVector.iterator<pairTypeType<Selector, SourceLocation>> Pos = S.ReferencedSelectors.find(Sel);
      if ($noteq___normal_iterator$C(Pos, S.ReferencedSelectors.end()) && $eq_SourceLocation$C(Pos.$arrow().second, Loc)) {
        S.ReferencedSelectors.erase(Pos);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="isAnyRetainable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3085,
 FQN="isAnyRetainable", NM="_ZL15isAnyRetainable22ARCConversionTypeClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL15isAnyRetainable22ARCConversionTypeClass")
//</editor-fold>
public static boolean isAnyRetainable(ARCConversionTypeClass ACTC) {
  return (ACTC == ARCConversionTypeClass.ACTC_retainable
     || ACTC == ARCConversionTypeClass.ACTC_coreFoundation
     || ACTC == ARCConversionTypeClass.ACTC_voidPtr);
}

//<editor-fold defaultstate="collapsed" desc="isAnyCLike">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3091,
 FQN="isAnyCLike", NM="_ZL10isAnyCLike22ARCConversionTypeClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL10isAnyCLike22ARCConversionTypeClass")
//</editor-fold>
public static boolean isAnyCLike(ARCConversionTypeClass ACTC) {
  return ACTC == ARCConversionTypeClass.ACTC_none
     || ACTC == ARCConversionTypeClass.ACTC_voidPtr
     || ACTC == ARCConversionTypeClass.ACTC_coreFoundation;
}

//<editor-fold defaultstate="collapsed" desc="classifyTypeForARCConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3097,
 FQN="classifyTypeForARCConversion", NM="_ZL28classifyTypeForARCConversionN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL28classifyTypeForARCConversionN5clang8QualTypeE")
//</editor-fold>
public static ARCConversionTypeClass classifyTypeForARCConversion(QualType type) {
  boolean isIndirect = false;
  {
    
    // Ignore an outermost reference type.
    /*const*/ ReferenceType /*P*/ ref = type.$arrow().getAs(ReferenceType.class);
    if ((ref != null)) {
      type.$assignMove(ref.getPointeeType());
      isIndirect = true;
    }
  }
  
  // Drill through pointers and arrays recursively.
  while (true) {
    {
      /*const*/ PointerType /*P*/ ptr = type.$arrow().getAs(PointerType.class);
      if ((ptr != null)) {
        type.$assignMove(ptr.getPointeeType());
        
        // The first level of pointer may be the innermost pointer on a CF type.
        if (!isIndirect) {
          if (type.$arrow().isVoidType()) {
            return ARCConversionTypeClass.ACTC_voidPtr;
          }
          if (type.$arrow().isRecordType()) {
            return ARCConversionTypeClass.ACTC_coreFoundation;
          }
        }
      } else {
        /*const*/ ArrayType /*P*/ array = type.$arrow().getAsArrayTypeUnsafe();
        if ((array != null)) {
          type.$assignMove(new QualType(array.getElementType().$arrow().getBaseElementTypeUnsafe(), 0));
        } else {
          break;
        }
      }
    }
    isIndirect = true;
  }
  if (isIndirect) {
    if (type.$arrow().isObjCARCBridgableType()) {
      return ARCConversionTypeClass.ACTC_indirectRetainable;
    }
    return ARCConversionTypeClass.ACTC_none;
  }
  if (type.$arrow().isObjCARCBridgableType()) {
    return ARCConversionTypeClass.ACTC_retainable;
  }
  
  return ARCConversionTypeClass.ACTC_none;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::merge">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3151,
 FQN="(anonymous namespace)::merge", NM="_ZN12_GLOBAL__N_15mergeENS_9ACCResultES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_15mergeENS_9ACCResultES0_")
//</editor-fold>
public static ACCResult merge(ACCResult left, ACCResult right) {
  if (left == right) {
    return left;
  }
  if (left == ACCResult.ACC_bottom) {
    return right;
  }
  if (right == ACCResult.ACC_bottom) {
    return left;
  }
  return ACCResult.ACC_invalid;
}

//<editor-fold defaultstate="collapsed" desc="addFixitForObjCARCConversion">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3372,
 FQN="addFixitForObjCARCConversion", NM="_ZL28addFixitForObjCARCConversionRN5clang4SemaERNS_17DiagnosticBuilderENS0_21CheckedConversionKindENS_14SourceLocationENS_8QualTypeEPNS_4ExprES8_PKcSA_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL28addFixitForObjCARCConversionRN5clang4SemaERNS_17DiagnosticBuilderENS0_21CheckedConversionKindENS_14SourceLocationENS_8QualTypeEPNS_4ExprES8_PKcSA_")
//</editor-fold>
public static void addFixitForObjCARCConversion(final Sema /*&*/ S, 
                            final DiagnosticBuilder /*&*/ DiagB, 
                            Sema.CheckedConversionKind CCK, 
                            SourceLocation afterLParen, 
                            QualType castType, 
                            Expr /*P*/ castExpr, 
                            Expr /*P*/ realCast, 
                            /*const*/char$ptr/*char P*/ bridgeKeyword, 
                            /*const*/char$ptr/*char P*/ CFBridgeName) {
  // We handle C-style and implicit casts here.
  switch (CCK) {
   case CCK_ImplicitConversion:
   case CCK_CStyleCast:
   case CCK_OtherCast:
    break;
   case CCK_FunctionalCast:
    return;
  }
  if ((CFBridgeName != null)) {
    if (CCK == Sema.CheckedConversionKind.CCK_OtherCast) {
      {
        /*const*/ CXXNamedCastExpr /*P*/ NCE = dyn_cast_CXXNamedCastExpr(realCast);
        if ((NCE != null)) {
          SourceRange range/*J*/= new SourceRange(NCE.getOperatorLoc(), 
              NCE.getAngleBrackets().getEnd());
          SmallString/*32*/ BridgeCall/*J*/= new SmallString/*32*/(32);
          
          final SourceManager /*&*/ SM = S.getSourceManager();
          // JAVA: PERF
          /*char*/byte PrevChar = SM.getCharacterData_FirstChar(SourceLocation.$getLocWithOffset(range.$getBegin(), -1));//.$star();
          if (Lexer.isIdentifierBodyChar(PrevChar, S.getLangOpts())) {
            BridgeCall.$addassign($$SPACE);
          }
          
          BridgeCall.$addassign(/*STRINGREF_STR*/CFBridgeName);
          DiagB.AddFixItHint(FixItHint.CreateReplacement(/*NO_COPY*/range, BridgeCall.$StringRef()));
        }
      }
      return;
    }
    Expr /*P*/ castedE = castExpr;
    {
      CStyleCastExpr /*P*/ CCE = dyn_cast_CStyleCastExpr(castedE);
      if ((CCE != null)) {
        castedE = CCE.getSubExpr();
      }
    }
    castedE = castedE.IgnoreImpCasts();
    SourceRange range = castedE.getSourceRange();
    
    SmallString/*32*/ BridgeCall/*J*/= new SmallString/*32*/(32);
    
    final SourceManager /*&*/ SM = S.getSourceManager();
    // JAVA: PERF
    /*char*/byte PrevChar = SM.getCharacterData_FirstChar(SourceLocation.$getLocWithOffset(range.$getBegin(), -1));//.$star();
    if (Lexer.isIdentifierBodyChar(PrevChar, S.getLangOpts())) {
      BridgeCall.$addassign($$SPACE);
    }
    
    BridgeCall.$addassign(/*STRINGREF_STR*/CFBridgeName);
    if (isa_ParenExpr(castedE)) {
      DiagB.AddFixItHint(FixItHint.CreateInsertion(range.getBegin(), 
              BridgeCall.$StringRef()));
    } else {
      BridgeCall.$addassign($$LPAREN);
      DiagB.AddFixItHint(FixItHint.CreateInsertion(range.getBegin(), 
              BridgeCall.$StringRef()));
      DiagB.AddFixItHint(FixItHint.CreateInsertion(S.getLocForEndOfToken(range.getEnd()), 
              new StringRef(/*KEEP_STR*/$RPAREN)));
    }
    return;
  }
  if (CCK == Sema.CheckedConversionKind.CCK_CStyleCast) {
    DiagB.AddFixItHint(FixItHint.CreateInsertion(/*NO_COPY*/afterLParen, new StringRef(bridgeKeyword)));
  } else if (CCK == Sema.CheckedConversionKind.CCK_OtherCast) {
    {
      /*const*/ CXXNamedCastExpr /*P*/ NCE = dyn_cast_CXXNamedCastExpr(realCast);
      if ((NCE != null)) {
        std.string castCode = new std.string(/*KEEP_STR*/$LPAREN);
        castCode.$addassign_T$C$P(bridgeKeyword);
        castCode.$addassign(castType.getAsString());
        castCode.$addassign_T$C$P(/*KEEP_STR*/")");
        SourceRange Range/*J*/= new SourceRange(NCE.getOperatorLoc(), 
            NCE.getAngleBrackets().getEnd());
        DiagB.AddFixItHint(FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef(castCode)));
      }
    }
  } else {
    std.string castCode = new std.string(/*KEEP_STR*/$LPAREN);
    castCode.$addassign_T$C$P(bridgeKeyword);
    castCode.$addassign(castType.getAsString());
    castCode.$addassign_T$C$P(/*KEEP_STR*/")");
    Expr /*P*/ castedE = castExpr.IgnoreImpCasts();
    SourceRange range = castedE.getSourceRange();
    if (isa_ParenExpr(castedE)) {
      DiagB.AddFixItHint(FixItHint.CreateInsertion(range.getBegin(), 
              new StringRef(castCode)));
    } else {
      castCode.$addassign_T$C$P(/*KEEP_STR*/"(");
      DiagB.AddFixItHint(FixItHint.CreateInsertion(range.getBegin(), 
              new StringRef(castCode)));
      DiagB.AddFixItHint(FixItHint.CreateInsertion(S.getLocForEndOfToken(range.getEnd()), 
              new StringRef(/*KEEP_STR*/$RPAREN)));
    }
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getObjCBridgeAttr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3471,
 FQN="getObjCBridgeAttr", NM="Tpl__ZL17getObjCBridgeAttrPKN5clang11TypedefTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=Tpl__ZL17getObjCBridgeAttrPKN5clang11TypedefTypeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T extends Attr> T /*P*/ getObjCBridgeAttr(Class<T> clazz, /*const*/ TypedefType /*P*/ TD) {
  TypedefNameDecl /*P*/ TDNDecl = TD.getDecl();
  QualType QT = TDNDecl.getUnderlyingType();
  if (QT.$arrow().isPointerType()) {
    QT.$assignMove(QT.$arrow().getPointeeType());
    {
      /*const*/ RecordType /*P*/ RT = QT.$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        {
          RecordDecl /*P*/ RD = RT.getDecl().getMostRecentDecl();
          if ((RD != null)) {
            return RD./*<T>*/getAttr(clazz);
          }
        }
      }
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="ObjCBridgeRelatedAttrFromType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3483,
 FQN="ObjCBridgeRelatedAttrFromType", NM="_ZL29ObjCBridgeRelatedAttrFromTypeN5clang8QualTypeERPNS_15TypedefNameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL29ObjCBridgeRelatedAttrFromTypeN5clang8QualTypeERPNS_15TypedefNameDeclE")
//</editor-fold>
public static ObjCBridgeRelatedAttr /*P*/ ObjCBridgeRelatedAttrFromType(QualType T, 
                             final type$ref<TypedefNameDecl /*P*/ /*&*/> TDNDecl) {
  {
    /*const*/ TypedefType /*P*/ TD;
    while (((/*P*/ TD = dyn_cast_TypedefType(T.getTypePtr())) != null)) {
      TDNDecl.$set(TD.getDecl());
      {
        ObjCBridgeRelatedAttr /*P*/ ObjCBAttr = getObjCBridgeAttr/*<ObjCBridgeRelatedAttr>*/(ObjCBridgeRelatedAttr.class, TD);
        if ((ObjCBAttr != null)) {
          return ObjCBAttr;
        }
      }
      T.$assignMove(TDNDecl.$deref().getUnderlyingType());
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="diagnoseObjCARCConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3495,
 FQN="diagnoseObjCARCConversion", NM="_ZL25diagnoseObjCARCConversionRN5clang4SemaENS_11SourceRangeENS_8QualTypeE22ARCConversionTypeClassPNS_4ExprES6_S4_NS0_21CheckedConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL25diagnoseObjCARCConversionRN5clang4SemaENS_11SourceRangeENS_8QualTypeE22ARCConversionTypeClassPNS_4ExprES6_S4_NS0_21CheckedConversionKindE")
//</editor-fold>
public static void diagnoseObjCARCConversion(final Sema /*&*/ S, SourceRange castRange, 
                         QualType castType, ARCConversionTypeClass castACTC, 
                         Expr /*P*/ castExpr, Expr /*P*/ realCast, 
                         ARCConversionTypeClass exprACTC, 
                         Sema.CheckedConversionKind CCK) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceLocation loc = (castRange.isValid() ? castRange.getBegin() : castExpr.getExprLoc());
    if (S.makeUnavailableInSystemHeader(new SourceLocation(loc), 
        UnavailableAttr.ImplicitReason.IR_ARCForbiddenConversion)) {
      return;
    }
    
    QualType castExprType = castExpr.getType();
    // Defer emitting a diagnostic for bridge-related casts; that will be
    // handled by CheckObjCBridgeRelatedConversions.
    type$ref<TypedefNameDecl /*P*/ > TDNDecl = create_type$ref();
    if ((castACTC == ARCConversionTypeClass.ACTC_coreFoundation && exprACTC == ARCConversionTypeClass.ACTC_retainable
       && (ObjCBridgeRelatedAttrFromType(new QualType(castType), TDNDecl) != null))
       || (exprACTC == ARCConversionTypeClass.ACTC_coreFoundation && castACTC == ARCConversionTypeClass.ACTC_retainable
       && (ObjCBridgeRelatedAttrFromType(new QualType(castExprType), TDNDecl) != null))) {
      return;
    }
    
    /*uint*/int srcKind = 0;
    switch (exprACTC) {
     case ACTC_none:
     case ACTC_coreFoundation:
     case ACTC_voidPtr:
      srcKind = (castExprType.$arrow().isPointerType() ? 1 : 0);
      break;
     case ACTC_retainable:
      srcKind = (castExprType.$arrow().isBlockPointerType() ? 2 : 3);
      break;
     case ACTC_indirectRetainable:
      srcKind = 4;
      break;
    }
    
    // Check whether this could be fixed with a bridge cast.
    SourceLocation afterLParen = S.getLocForEndOfToken(castRange.getBegin());
    SourceLocation noteLoc = new SourceLocation(afterLParen.isValid() ? afterLParen : loc);
    
    // Bridge from an ARC type to a CF type.
    if (castACTC == ARCConversionTypeClass.ACTC_retainable && isAnyRetainable(exprACTC)) {
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_arc_cast_requires_bridge)), 
                                  ((/*uint*/int)(((CCK == Sema.CheckedConversionKind.CCK_ImplicitConversion) ? 1 : 0)))),  // cast|implicit
                              2),  // of C pointer type
                          castExprType), 
                      ((/*uint*/int)((castType.$arrow().isBlockPointerType() ? 1 : 0)))),  // to ObjC|block type
                  castType), 
              castRange), 
          castExpr.getSourceRange()));
      boolean br = S.isKnownName(new StringRef(/*KEEP_STR*/"CFBridgingRelease"));
      ACCResult CreateRule = new ARCCastChecker(S.Context, exprACTC, castACTC, true).Visit(castExpr);
      assert (CreateRule != ACCResult.ACC_bottom) : "This cast should already be accepted.";
      if (CreateRule != ACCResult.ACC_plusOne) {
        DiagnosticBuilder DiagB = null;
        try {
          /*FIXME: Initializer produces not destroyed temporary!*/DiagB = $c$.clean(new DiagnosticBuilder((CCK != Sema.CheckedConversionKind.CCK_OtherCast) ? $c$.track(S.Diag(new SourceLocation(noteLoc), diag.note_arc_bridge)) : $c$.track(S.Diag(new SourceLocation(noteLoc), diag.note_arc_cstyle_bridge))));
          
          addFixitForObjCARCConversion(S, DiagB, CCK, new SourceLocation(afterLParen), 
              new QualType(castType), castExpr, realCast, $("__bridge "), 
              (/*const*/char$ptr/*char P*/ )null);
        } finally {
          if (DiagB != null) { DiagB.$destroy(); }
        }
      }
      if (CreateRule != ACCResult.ACC_plusZero) {
        DiagnosticBuilder DiagB = null;
        try {
          /*FIXME: Initializer produces not destroyed temporary!*/DiagB = $c$.clean(new DiagnosticBuilder((CCK == Sema.CheckedConversionKind.CCK_OtherCast && !br) ? $out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(noteLoc), diag.note_arc_cstyle_bridge_transfer)), castExprType) : $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(br ? castExpr.getExprLoc() : new SourceLocation(noteLoc), 
                          diag.note_arc_bridge_transfer)), 
                      castExprType), br)));
          
          addFixitForObjCARCConversion(S, DiagB, CCK, new SourceLocation(afterLParen), 
              new QualType(castType), castExpr, realCast, $("__bridge_transfer "), 
              br ? $("CFBridgingRelease") : (/*const*/char$ptr/*char P*/ )null);
        } finally {
          if (DiagB != null) { DiagB.$destroy(); }
        }
      }
      
      return;
    }
    
    // Bridge from a CF type to an ARC type.
    if (exprACTC == ARCConversionTypeClass.ACTC_retainable && isAnyRetainable(castACTC)) {
      boolean br = S.isKnownName(new StringRef(/*KEEP_STR*/"CFBridgingRetain"));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_arc_cast_requires_bridge)), 
                                  ((/*uint*/int)(((CCK == Sema.CheckedConversionKind.CCK_ImplicitConversion) ? 1 : 0)))),  // cast|implicit
                              ((/*uint*/int)((castExprType.$arrow().isBlockPointerType() ? 1 : 0)))),  // of ObjC|block type
                          castExprType), 
                      2),  // to C pointer type
                  castType), 
              castRange), 
          castExpr.getSourceRange()));
      ACCResult CreateRule = new ARCCastChecker(S.Context, exprACTC, castACTC, true).Visit(castExpr);
      assert (CreateRule != ACCResult.ACC_bottom) : "This cast should already be accepted.";
      if (CreateRule != ACCResult.ACC_plusOne) {
        DiagnosticBuilder DiagB = null;
        try {
          /*FIXME: Initializer produces not destroyed temporary!*/DiagB = $c$.clean(new DiagnosticBuilder((CCK != Sema.CheckedConversionKind.CCK_OtherCast) ? $c$.track(S.Diag(new SourceLocation(noteLoc), diag.note_arc_bridge)) : $c$.track(S.Diag(new SourceLocation(noteLoc), diag.note_arc_cstyle_bridge))));
          addFixitForObjCARCConversion(S, DiagB, CCK, new SourceLocation(afterLParen), 
              new QualType(castType), castExpr, realCast, $("__bridge "), 
              (/*const*/char$ptr/*char P*/ )null);
        } finally {
          if (DiagB != null) { DiagB.$destroy(); }
        }
      }
      if (CreateRule != ACCResult.ACC_plusZero) {
        DiagnosticBuilder DiagB = null;
        try {
          /*FIXME: Initializer produces not destroyed temporary!*/DiagB = $c$.clean(new DiagnosticBuilder((CCK == Sema.CheckedConversionKind.CCK_OtherCast && !br) ? $out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(noteLoc), diag.note_arc_cstyle_bridge_retained)), castType) : $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(br ? castExpr.getExprLoc() : new SourceLocation(noteLoc), 
                          diag.note_arc_bridge_retained)), 
                      castType), br)));
          
          addFixitForObjCARCConversion(S, DiagB, CCK, new SourceLocation(afterLParen), 
              new QualType(castType), castExpr, realCast, $("__bridge_retained "), 
              br ? $("CFBridgingRetain") : (/*const*/char$ptr/*char P*/ )null);
        } finally {
          if (DiagB != null) { DiagB.$destroy(); }
        }
      }
      
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_arc_mismatched_cast)), 
                            (CCK != Sema.CheckedConversionKind.CCK_ImplicitConversion)), 
                        srcKind), castExprType), castType), 
            castRange), castExpr.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}

/*template <typename TB> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="CheckObjCBridgeNSCast">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3626,
 FQN="CheckObjCBridgeNSCast", NM="Tpl__ZL21CheckObjCBridgeNSCastRN5clang4SemaENS_8QualTypeEPNS_4ExprERbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=Tpl__ZL21CheckObjCBridgeNSCastRN5clang4SemaENS_8QualTypeEPNS_4ExprERbb")
//</editor-fold>
public static </*typename*/ TB extends Attr & ObjCBridgedTypeAttr> boolean CheckObjCBridgeNSCast(Class<TB> clazz, final Sema /*&*/ S, QualType castType, Expr /*P*/ castExpr, 
                     final bool$ref/*bool &*/ HadTheAttribute, boolean warn) {
  QualType T = castExpr.getType();
  HadTheAttribute.$set(false);
  {
    /*const*/ TypedefType /*P*/ TD;
    while (((/*P*/ TD = dyn_cast_TypedefType(T.getTypePtr())) != null)) {
      TypedefNameDecl /*P*/ TDNDecl = TD.getDecl();
      {
        TB /*P*/ ObjCBAttr = getObjCBridgeAttr/*<TB>*/(clazz, TD);
        if (ObjCBAttr != null) {
          {
            IdentifierInfo /*P*/ Parm = ObjCBAttr.getBridgedType();
            if ((Parm != null)) {
              LookupResult R = null;
              try {
                HadTheAttribute.$set(true);
                if (Parm.isStr(/*KEEP_STR*/"id")) {
                  return true;
                }
                
                NamedDecl /*P*/ Target = null;
                // Check for an existing type with this name.
                R/*J*/= new LookupResult(S, new DeclarationName(Parm), new SourceLocation(), 
                    Sema.LookupNameKind.LookupOrdinaryName);
                if (S.LookupName(R, S.TUScope)) {
                  Target = R.getFoundDecl();
                  if ((Target != null) && isa_ObjCInterfaceDecl(Target)) {
                    ObjCInterfaceDecl /*P*/ ExprClass = cast_ObjCInterfaceDecl(Target);
                    {
                      /*const*/ ObjCObjectPointerType /*P*/ InterfacePointerType = castType.$arrow().getAsObjCInterfacePointerType();
                      if ((InterfacePointerType != null)) {
                        ObjCInterfaceDecl /*P*/ CastClass = InterfacePointerType.getObjectType().getInterface();
                        if ((CastClass == ExprClass)
                           || ((CastClass != null) && CastClass.isSuperClassOf(ExprClass))) {
                          return true;
                        }
                        if (warn) {
                          JavaCleaner $c$ = $createJavaCleaner();
                          try {
                            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(castExpr.getLocStart(), diag.warn_objc_invalid_bridge)), 
                                        T), Target.getName()), castType.$arrow().getPointeeType()));
                          } finally {
                            $c$.$destroy();
                          }
                        }
                        return false;
                      } else if (castType.$arrow().isObjCIdType()
                         || (S.Context.ObjCObjectAdoptsQTypeProtocols(new QualType(castType), ExprClass))) {
                        // ok to cast to 'id'.
                        // casting to id<p-list> is ok if bridge type adopts all of
                        // p-list protocols.
                        return true;
                      } else {
                        if (warn) {
                          JavaCleaner $c$ = $createJavaCleaner();
                          try {
                            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(castExpr.getLocStart(), diag.warn_objc_invalid_bridge)), 
                                        T), Target.getName()), castType));
                            $c$.clean($c$.track(S.Diag(TDNDecl.getLocStart(), diag.note_declared_at)));
                            $c$.clean($c$.track(S.Diag(Target.getLocStart(), diag.note_declared_at)));
                          } finally {
                            $c$.$destroy();
                          }
                        }
                        return false;
                      }
                    }
                  }
                } else if (!castType.$arrow().isObjCIdType()) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(castExpr.getLocStart(), diag.err_objc_cf_bridged_not_interface)), 
                            castExpr.getType()), Parm));
                    $c$.clean($c$.track(S.Diag(TDNDecl.getLocStart(), diag.note_declared_at)));
                    if ((Target != null)) {
                      $c$.clean($c$.track(S.Diag(Target.getLocStart(), diag.note_declared_at)));
                    }
                  } finally {
                    $c$.$destroy();
                  }
                }
                return true;
              } finally {
                if (R != null) { R.$destroy(); }
              }
            }
          }
          return false;
        }
      }
      T.$assignMove(TDNDecl.getUnderlyingType());
    }
  }
  return true;
}

/*template <typename TB> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="CheckObjCBridgeCFCast">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3691,
 FQN="CheckObjCBridgeCFCast", NM="Tpl__ZL21CheckObjCBridgeCFCastRN5clang4SemaENS_8QualTypeEPNS_4ExprERbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=Tpl__ZL21CheckObjCBridgeCFCastRN5clang4SemaENS_8QualTypeEPNS_4ExprERbb")
//</editor-fold>
public static </*typename*/ TB extends Attr & ObjCBridgedTypeAttr> boolean CheckObjCBridgeCFCast(Class<TB> clazz, final Sema /*&*/ S, QualType castType, Expr /*P*/ castExpr, 
                     final bool$ref/*bool &*/ HadTheAttribute, boolean warn) {
  QualType T = new QualType(castType);
  HadTheAttribute.$set(false);
  {
    /*const*/ TypedefType /*P*/ TD;
    while (((/*P*/ TD = dyn_cast_TypedefType(T.getTypePtr())) != null)) {
      TypedefNameDecl /*P*/ TDNDecl = TD.getDecl();
      {
        TB /*P*/ ObjCBAttr = getObjCBridgeAttr/*<TB>*/(clazz, TD);
        if (ObjCBAttr != null) {
          {
            IdentifierInfo /*P*/ Parm = ObjCBAttr.getBridgedType();
            if ((Parm != null)) {
              LookupResult R = null;
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                HadTheAttribute.$set(true);
                if (Parm.isStr(/*KEEP_STR*/"id")) {
                  return true;
                }
                
                NamedDecl /*P*/ Target = null;
                // Check for an existing type with this name.
                R/*J*/= new LookupResult(S, new DeclarationName(Parm), new SourceLocation(), 
                    Sema.LookupNameKind.LookupOrdinaryName);
                if (S.LookupName(R, S.TUScope)) {
                  Target = R.getFoundDecl();
                  if ((Target != null) && isa_ObjCInterfaceDecl(Target)) {
                    ObjCInterfaceDecl /*P*/ CastClass = cast_ObjCInterfaceDecl(Target);
                    {
                      /*const*/ ObjCObjectPointerType /*P*/ InterfacePointerType = castExpr.getType().$arrow().getAsObjCInterfacePointerType();
                      if ((InterfacePointerType != null)) {
                        ObjCInterfaceDecl /*P*/ ExprClass = InterfacePointerType.getObjectType().getInterface();
                        if ((CastClass == ExprClass)
                           || ((ExprClass != null) && CastClass.isSuperClassOf(ExprClass))) {
                          return true;
                        }
                        if (warn) {
                          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(castExpr.getLocStart(), diag.warn_objc_invalid_bridge_to_cf)), 
                                  castExpr.getType().$arrow().getPointeeType()), T));
                          $c$.clean($c$.track(S.Diag(TDNDecl.getLocStart(), diag.note_declared_at)));
                        }
                        return false;
                      } else if (castExpr.getType().$arrow().isObjCIdType()
                         || (S.Context.QIdProtocolsAdoptObjCObjectProtocols(castExpr.getType(), CastClass))) {
                        // ok to cast an 'id' expression to a CFtype.
                        // ok to cast an 'id<plist>' expression to CFtype provided plist
                        // adopts all of CFtype's ObjetiveC's class plist.
                        return true;
                      } else {
                        if (warn) {
                          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(castExpr.getLocStart(), diag.warn_objc_invalid_bridge_to_cf)), 
                                  castExpr.getType()), castType));
                          $c$.clean($c$.track(S.Diag(TDNDecl.getLocStart(), diag.note_declared_at)));
                          $c$.clean($c$.track(S.Diag(Target.getLocStart(), diag.note_declared_at)));
                        }
                        return false;
                      }
                    }
                  }
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(castExpr.getLocStart(), diag.err_objc_ns_bridged_invalid_cfobject)), 
                        castExpr.getType()), castType));
                $c$.clean($c$.track(S.Diag(TDNDecl.getLocStart(), diag.note_declared_at)));
                if ((Target != null)) {
                  $c$.clean($c$.track(S.Diag(Target.getLocStart(), diag.note_declared_at)));
                }
                return true;
              } finally {
                if (R != null) { R.$destroy(); }
                $c$.$destroy();
              }
            }
          }
          return false;
        }
      }
      T.$assignMove(TDNDecl.getUnderlyingType());
    }
  }
  return true;
}


/// Look for an ObjCReclaimReturnedObject cast and destroy it.
//<editor-fold defaultstate="collapsed" desc="maybeUndoReclaimObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 4214,
 FQN="maybeUndoReclaimObject", NM="_ZL22maybeUndoReclaimObjectPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZL22maybeUndoReclaimObjectPN5clang4ExprE")
//</editor-fold>
public static Expr /*P*/ maybeUndoReclaimObject(Expr /*P*/ e) {
  {
    // For now, we just undo operands that are *immediately* reclaim
    // expressions, which prevents the vast majority of potential
    // problems here.  To catch them all, we'd need to rebuild arbitrary
    // value-propagating subexpressions --- we can't reliably rebuild
    // in-place because of expression sharing.
    ImplicitCastExpr /*P*/ ice = dyn_cast_ImplicitCastExpr(e);
    if ((ice != null)) {
      if (ice.getCastKind() == CastKind.CK_ARCReclaimReturnedObject) {
        return ice.getSubExpr();
      }
    }
  }
  
  return e;
}

} // END OF class SemaExprObjCStatics
