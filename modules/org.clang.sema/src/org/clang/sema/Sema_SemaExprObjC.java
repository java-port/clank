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
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaExprObjCStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaExprObjC">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaExprMember ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema10isSelfExprEPNS_4ExprE;_ZN5clang4Sema10isSelfExprEPNS_4ExprEPKNS_14ObjCMethodDeclE;_ZN5clang4Sema11isKnownNameEN4llvm9StringRefE;_ZN5clang4Sema17ActOnClassMessageEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEENS_8SelectorENS_14SourceLocationEN4llvm8ArrayRefIS7_EES7_NS8_15MutableArrayRefIPNS_4ExprEEE;_ZN5clang4Sema17ActOnSuperMessageEPNS_5ScopeENS_14SourceLocationENS_8SelectorES3_N4llvm8ArrayRefIS3_EES3_NS5_15MutableArrayRefIPNS_4ExprEEE;_ZN5clang4Sema17BuildClassMessageEPNS_14TypeSourceInfoENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclES4_N4llvm8ArrayRefIS4_EES4_NS8_15MutableArrayRefIPNS_4ExprEEEb;_ZN5clang4Sema18BuildObjCBoxedExprENS_11SourceRangeEPNS_4ExprE;_ZN5clang4Sema18getObjCMessageKindEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationEbbRNS_9OpaquePtrINS_8QualTypeEEE;_ZN5clang4Sema18tryCaptureObjCSelfENS_14SourceLocationE;_ZN5clang4Sema20ActOnInstanceMessageEPNS_5ScopeEPNS_4ExprENS_8SelectorENS_14SourceLocationEN4llvm8ArrayRefIS6_EES6_NS7_15MutableArrayRefIS4_EE;_ZN5clang4Sema20ActOnObjCBoolLiteralENS_14SourceLocationES1_b;_ZN5clang4Sema20ActOnObjCBridgedCastEPNS_5ScopeENS_14SourceLocationENS_18ObjCBridgeCastKindES3_NS_9OpaquePtrINS_8QualTypeEEES3_PNS_4ExprE;_ZN5clang4Sema20BuildInstanceMessageEPNS_4ExprENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclES4_N4llvm8ArrayRefIS4_EES4_NS8_15MutableArrayRefIS2_EEb;_ZN5clang4Sema20BuildObjCBridgedCastENS_14SourceLocationENS_18ObjCBridgeCastKindES1_PNS_14TypeSourceInfoEPNS_4ExprE;_ZN5clang4Sema21BuildObjCArrayLiteralENS_11SourceRangeEN4llvm15MutableArrayRefIPNS_4ExprEEE;_ZN5clang4Sema21stripARCUnbridgedCastEPNS_4ExprE;_ZN5clang4Sema22BuildObjCStringLiteralENS_14SourceLocationEPNS_13StringLiteralE;_ZN5clang4Sema22CheckObjCARCConversionENS_11SourceRangeENS_8QualTypeERPNS_4ExprENS0_21CheckedConversionKindEbbNS_18BinaryOperatorKindE;_ZN5clang4Sema22ParseObjCStringLiteralEPNS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE;_ZN5clang4Sema23BuildObjCNumericLiteralENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema23CheckTollFreeBridgeCastENS_8QualTypeEPNS_4ExprE;_ZN5clang4Sema24LookupMethodInObjectTypeENS_8SelectorENS_8QualTypeEb;_ZN5clang4Sema24diagnoseARCUnbridgedCastEPNS_4ExprE;_ZN5clang4Sema24getMessageSendResultTypeENS_8QualTypeEPNS_14ObjCMethodDeclEbb;_ZN5clang4Sema25ActOnClassPropertyRefExprERNS_14IdentifierInfoES2_NS_14SourceLocationES3_;_ZN5clang4Sema25BuildClassMessageImplicitENS_8QualTypeEbNS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclEN4llvm15MutableArrayRefIPNS_4ExprEEE;_ZN5clang4Sema25BuildObjCEncodeExpressionENS_14SourceLocationEPNS_14TypeSourceInfoES1_;_ZN5clang4Sema25CheckMessageArgumentTypesENS_8QualTypeEN4llvm15MutableArrayRefIPNS_4ExprEEENS_8SelectorENS2_8ArrayRefINS_14SourceLocationEEEPNS_14ObjCMethodDeclEbbS9_S9_NS_11SourceRangeERS1_RNS_13ExprValueKindE;_ZN5clang4Sema25EmitRelatedResultTypeNoteEPKNS_4ExprE;_ZN5clang4Sema25HandleExprPropertyRefExprEPKNS_21ObjCObjectPointerTypeEPNS_4ExprENS_14SourceLocationENS_15DeclarationNameES6_S6_NS_8QualTypeEb;_ZN5clang4Sema25ParseObjCEncodeExpressionENS_14SourceLocationES1_S1_NS_9OpaquePtrINS_8QualTypeEEES1_;_ZN5clang4Sema26BuildObjCDictionaryLiteralENS_11SourceRangeEN4llvm15MutableArrayRefINS_21ObjCDictionaryElementEEE;_ZN5clang4Sema26CheckObjCBridgeRelatedCastENS_8QualTypeEPNS_4ExprE;_ZN5clang4Sema27LookupMethodInQualifiedTypeENS_8SelectorEPKNS_21ObjCObjectPointerTypeEb;_ZN5clang4Sema27ParseObjCProtocolExpressionEPNS_14IdentifierInfoENS_14SourceLocationES3_S3_S3_S3_;_ZN5clang4Sema27ParseObjCSelectorExpressionENS_8SelectorENS_14SourceLocationES2_S2_S2_b;_ZN5clang4Sema28BuildInstanceMessageImplicitEPNS_4ExprENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclEN4llvm15MutableArrayRefIS2_EE;_ZN5clang4Sema28BuildObjCSubscriptExpressionENS_14SourceLocationEPNS_4ExprES3_PNS_14ObjCMethodDeclES5_;_ZN5clang4Sema29CheckTollFreeBridgeStaticCastENS_8QualTypeEPNS_4ExprERNS_8CastKindE;_ZN5clang4Sema32checkObjCBridgeRelatedComponentsENS_14SourceLocationENS_8QualTypeES2_RPNS_17ObjCInterfaceDeclERPNS_14ObjCMethodDeclES8_RPNS_15TypedefNameDeclEbb;_ZN5clang4Sema33CheckObjCBridgeRelatedConversionsENS_14SourceLocationENS_8QualTypeES2_RPNS_4ExprEb;_ZN5clang4Sema34EmitRelatedResultTypeNoteForReturnENS_8QualTypeE;_ZN5clang4Sema37CheckObjCARCUnavailableWeakConversionENS_8QualTypeES1_; -static-type=Sema_SemaExprObjC -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaExprObjC extends Sema_SemaExprMember {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// Private Helper predicate to check for 'self'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isSelfExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1698,
 FQN="clang::Sema::isSelfExpr", NM="_ZN5clang4Sema10isSelfExprEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema10isSelfExprEPNS_4ExprE")
//</editor-fold>
public final boolean isSelfExpr(Expr /*P*/ RExpr) {
  // 'self' is objc 'self' in an objc method only.
  ObjCMethodDecl /*P*/ Method = dyn_cast_or_null_ObjCMethodDecl($this().CurContext.getNonClosureAncestor());
  return $this().isSelfExpr(RExpr, Method);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isSelfExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1705,
 FQN="clang::Sema::isSelfExpr", NM="_ZN5clang4Sema10isSelfExprEPNS_4ExprEPKNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema10isSelfExprEPNS_4ExprEPKNS_14ObjCMethodDeclE")
//</editor-fold>
public final boolean isSelfExpr(Expr /*P*/ receiver, /*const*/ ObjCMethodDecl /*P*/ method) {
  if (!(method != null)) {
    return false;
  }
  
  receiver = receiver.IgnoreParenLValueCasts();
  {
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(receiver);
    if ((DRE != null)) {
      if (DRE.getDecl() == method.getSelfDecl()) {
        return true;
      }
    }
  }
  return false;
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isKnownName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3364,
 FQN="clang::Sema::isKnownName", NM="_ZN5clang4Sema11isKnownNameEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema11isKnownNameEN4llvm9StringRefE")
//</editor-fold>
public final boolean isKnownName(StringRef name) {
  LookupResult R = null;
  try {
    if (name.empty()) {
      return false;
    }
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf($this().Context.Idents.get(/*NO_COPY*/name))), new SourceLocation(), 
        Sema.LookupNameKind.LookupOrdinaryName);
    return $this().LookupName(R, $this().TUScope, false);
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


// ParseObjCStringLiteral - Parse Objective-C string literals.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ParseObjCStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 34,
 FQN="clang::Sema::ParseObjCStringLiteral", NM="_ZN5clang4Sema22ParseObjCStringLiteralEPNS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema22ParseObjCStringLiteralEPNS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ParseObjCStringLiteral(type$ptr<SourceLocation> /*P*/ AtLocs, 
                      ArrayRef<Expr /*P*/ > Strings) {
  // Most ObjC strings are formed out of a single piece.  However, we *can*
  // have strings formed out of multiple @ strings with multiple pptokens in
  // each one, e.g. @"foo" "bar" @"baz" "qux"   which need to be turned into one
  // StringLiteral for ObjCStringLiteral to hold onto.
  StringLiteral /*P*/ S = cast_StringLiteral(Strings.$at(0));
  
  // If we have a multi-part string, merge it all together.
  if (Strings.size() != 1) {
    // Concatenate objc strings.
    SmallString/*128*/ StrBuf/*J*/= new SmallString/*128*/(128);
    SmallVector<SourceLocation> StrLocs/*J*/= new SmallVector<SourceLocation>(8, new SourceLocation());
    
    for (Expr /*P*/ E : Strings) {
      S = cast_StringLiteral(E);
      
      // ObjC strings can't be wide or UTF.
      if (!S.isAscii()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(S.getLocStart(), diag.err_cfstring_literal_not_string_constant)), 
              S.getSourceRange()));
          return new ActionResultTTrue<Expr /*P*/ >(true);
        } finally {
          $c$.$destroy();
        }
      }
      
      // Append the string.
      StrBuf.$addassign(S.getString());
      
      // Get the locations of the string tokens.
      StrLocs.append_T(S.tokloc_begin(), S.tokloc_end());
    }
    
    // Create the aggregate string with the appropriate content and location
    // information.
    /*const*/ ConstantArrayType /*P*/ CAT = $this().Context.getAsConstantArrayType(S.getType());
    assert ((CAT != null)) : "String literal not of constant array type!";
    QualType StrTy = $this().Context.getConstantArrayType(CAT.getElementType(), new APInt(32, $uint2ulong(StrBuf.size() + 1)), 
        CAT.getSizeModifier(), CAT.getIndexTypeCVRQualifiers());
    S = StringLiteral.Create($this().Context, StrBuf.$StringRef(), StringLiteral.StringKind.Ascii, 
        /*Pascal=*/ false, new QualType(StrTy), $AddrOf(StrLocs.ptr$at(0)), 
        StrLocs.size());
  }
  
  return $this().BuildObjCStringLiteral(new SourceLocation(AtLocs.$at(0)), S);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 80,
 FQN="clang::Sema::BuildObjCStringLiteral", NM="_ZN5clang4Sema22BuildObjCStringLiteralENS_14SourceLocationEPNS_13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema22BuildObjCStringLiteralENS_14SourceLocationEPNS_13StringLiteralE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildObjCStringLiteral(SourceLocation AtLoc, StringLiteral /*P*/ S) {
  // Verify that this composite string is acceptable for ObjC strings.
  if ($this().CheckObjCString(S)) {
    return new ActionResultTTrue<Expr /*P*/ >(true);
  }
  
  // Initialize the constant string interface lazily. This assumes
  // the NSString interface is seen in this translation unit. Note: We
  // don't use NSConstantString, since the runtime team considers this
  // interface private (even though it appears in the header files).
  QualType Ty = $this().Context.getObjCConstantStringInterface();
  if (!Ty.isNull()) {
    Ty.$assignMove($this().Context.getObjCObjectPointerType(new QualType(Ty)));
  } else if ($this().getLangOpts().NoConstantCFStrings) {
    IdentifierInfo /*P*/ NSIdent = null;
    std.string StringClass/*J*/= new std.string($this().getLangOpts().ObjCConstantStringClass);
    if (StringClass.empty()) {
      NSIdent = $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"NSConstantString")));
    } else {
      NSIdent = $AddrOf($this().Context.Idents.get(new StringRef(StringClass)));
    }
    
    NamedDecl /*P*/ IF = $this().LookupSingleName($this().TUScope, new DeclarationName(NSIdent), new SourceLocation(AtLoc), 
        LookupNameKind.LookupOrdinaryName);
    {
      ObjCInterfaceDecl /*P*/ StrIF = dyn_cast_or_null_ObjCInterfaceDecl(IF);
      if ((StrIF != null)) {
        $this().Context.setObjCConstantStringInterface(StrIF);
        Ty.$assignMove($this().Context.getObjCConstantStringInterface());
        Ty.$assignMove($this().Context.getObjCObjectPointerType(new QualType(Ty)));
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If there is no NSConstantString interface defined then treat this
          // as error and recover from it.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(S.getLocStart(), diag.err_no_nsconstant_string_class)), NSIdent), 
              S.getSourceRange()));
          Ty.$assignMove($this().Context.getObjCIdType());
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else {
    IdentifierInfo /*P*/ NSIdent = $this().NSAPIObj.$arrow().getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSString);
    NamedDecl /*P*/ IF = $this().LookupSingleName($this().TUScope, new DeclarationName(NSIdent), new SourceLocation(AtLoc), 
        LookupNameKind.LookupOrdinaryName);
    {
      ObjCInterfaceDecl /*P*/ StrIF = dyn_cast_or_null_ObjCInterfaceDecl(IF);
      if ((StrIF != null)) {
        $this().Context.setObjCConstantStringInterface(StrIF);
        Ty.$assignMove($this().Context.getObjCConstantStringInterface());
        Ty.$assignMove($this().Context.getObjCObjectPointerType(new QualType(Ty)));
      } else {
        // If there is no NSString interface defined, implicitly declare
        // a @class NSString; and use that instead. This is to make sure
        // type of an NSString literal is represented correctly, instead of
        // being an 'id' type.
        Ty.$assignMove($this().Context.getObjCNSStringType());
        if (Ty.isNull()) {
          ObjCInterfaceDecl /*P*/ NSStringIDecl = ObjCInterfaceDecl.Create($this().Context, 
              $this().Context.getTranslationUnitDecl(), 
              new SourceLocation(), NSIdent, 
              (ObjCTypeParamList /*P*/ )null, (ObjCInterfaceDecl /*P*/ )null, new SourceLocation());
          Ty.$assignMove($this().Context.getObjCInterfaceType(NSStringIDecl));
          $this().Context.setObjCNSStringType(new QualType(Ty));
        }
        Ty.$assignMove($this().Context.getObjCObjectPointerType(new QualType(Ty)));
      }
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*FIXME:NEW_EXPR*//*new (Context)*/ new ObjCStringLiteral(S, new QualType(Ty), new SourceLocation(AtLoc)));
}


/// BuildObjCNumericLiteral - builds an ObjCBoxedExpr AST node for the
/// numeric literal expression. Type of the expression will be "NSNumber *"
/// or "id" if NSNumber is unavailable.

/// BuildObjCNumericLiteral - builds an ObjCBoxedExpr AST node for the
/// numeric literal expression. Type of the expression will be "NSNumber *".
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCNumericLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 314,
 FQN="clang::Sema::BuildObjCNumericLiteral", NM="_ZN5clang4Sema23BuildObjCNumericLiteralENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema23BuildObjCNumericLiteralENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildObjCNumericLiteral(SourceLocation AtLoc, Expr /*P*/ Number) {
  // Determine the type of the literal.
  QualType NumberType = Number.getType();
  {
    CharacterLiteral /*P*/ Char = dyn_cast_CharacterLiteral(Number);
    if ((Char != null)) {
      // In C, character literals have type 'int'. That's not the type we want
      // to use to determine the Objective-c literal kind.
      switch (Char.getKind()) {
       case Ascii:
       case UTF8:
        NumberType.$assignMove($this().Context.CharTy.$QualType());
        break;
       case Wide:
        NumberType.$assignMove($this().Context.getWideCharType());
        break;
       case UTF16:
        NumberType.$assignMove($this().Context.Char16Ty.$QualType());
        break;
       case UTF32:
        NumberType.$assignMove($this().Context.Char32Ty.$QualType());
        break;
      }
    }
  }
  
  // Look for the appropriate method within NSNumber.
  // Construct the literal.
  SourceRange NR/*J*/= Number.getSourceRange();
  ObjCMethodDecl /*P*/ Method = getNSNumberFactoryMethod(/*Deref*/$this(), new SourceLocation(AtLoc), new QualType(NumberType), 
      true, new SourceRange(NR));
  if (!(Method != null)) {
    return ExprError();
  }
  
  // Convert the number to the type that the parameter expects.
  ParmVarDecl /*P*/ ParamDecl = Method.parameters().$at(0);
  InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, 
      ParamDecl);
  ActionResultTTrue<Expr /*P*/ > ConvertedNumber = $this().PerformCopyInitialization(Entity, 
      new SourceLocation(), 
      new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Number));
  if (ConvertedNumber.isInvalid()) {
    return ExprError();
  }
  Number = ConvertedNumber.get();
  
  // Use the effective source range of the literal, including the leading '@'.
  final Expr /*P*/ $Number = Number;
  return $this().MaybeBindToTemporary(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCBoxedExpr($Number, new QualType($this().NSNumberPointer), Method, 
          new SourceRange(/*NO_COPY*/AtLoc, NR.getEnd()))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCBoolLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 365,
 FQN="clang::Sema::ActOnObjCBoolLiteral", NM="_ZN5clang4Sema20ActOnObjCBoolLiteralENS_14SourceLocationES1_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema20ActOnObjCBoolLiteralENS_14SourceLocationES1_b")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnObjCBoolLiteral(SourceLocation AtLoc, 
                    SourceLocation ValueLoc, 
                    boolean Value) {
  ActionResultTTrue<Expr /*P*/ > Inner/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  if ($this().getLangOpts().CPlusPlus) {
    Inner.$assignMove($this().ActOnCXXBoolLiteral(new SourceLocation(ValueLoc), Value ? tok.TokenKind.kw_true : tok.TokenKind.kw_false));
  } else {
    // C doesn't actually have a way to represent literal values of type 
    // _Bool. So, we'll use 0/1 and implicit cast to _Bool.
    Inner.$assignMove($this().ActOnIntegerConstant(new SourceLocation(ValueLoc), $int2ulong(Value ? 1 : 0)));
    Inner.$assignMove($this().ImpCastExprToType(Inner.get(), $this().Context.BoolTy.$QualType(), 
            CastKind.CK_IntegralToBoolean));
  }
  
  return $this().BuildObjCNumericLiteral(new SourceLocation(AtLoc), Inner.get());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCArrayLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 766,
 FQN="clang::Sema::BuildObjCArrayLiteral", NM="_ZN5clang4Sema21BuildObjCArrayLiteralENS_11SourceRangeEN4llvm15MutableArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema21BuildObjCArrayLiteralENS_11SourceRangeEN4llvm15MutableArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildObjCArrayLiteral(SourceRange SR, MutableArrayRef<Expr /*P*/ > Elements) {
  SourceLocation Loc = SR.getBegin();
  if (!($this().NSArrayDecl != null)) {
    $this().NSArrayDecl = LookupObjCInterfaceDeclForLiteral(/*Deref*/$this(), new SourceLocation(Loc), 
        Sema.ObjCLiteralKind.LK_Array);
    if (!($this().NSArrayDecl != null)) {
      return ExprError();
    }
  }
  
  // Find the arrayWithObjects:count: method, if we haven't done so already.
  QualType IdT = $this().Context.getObjCIdType();
  if (!($this().ArrayWithObjectsMethod != null)) {
    Selector Sel = $this().NSAPIObj.$arrow().getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_arrayWithObjectsCount);
    ObjCMethodDecl /*P*/ Method = $this().NSArrayDecl.lookupClassMethod(new Selector(Sel));
    if (!(Method != null) && $this().getLangOpts().DebuggerObjCLiteral) {
      TypeSourceInfo /*P*/ ReturnTInfo = null;
      Method = ObjCMethodDecl.Create($this().Context, new SourceLocation(), new SourceLocation(), new Selector(Sel), new QualType(IdT), ReturnTInfo, 
          $this().Context.getTranslationUnitDecl(), false/*Instance*/, 
          false/*isVariadic*/, 
          /*isPropertyAccessor=*/ false, 
          /*isImplicitlyDeclared=*/ true, /*isDefined=*/ false, 
          ObjCMethodDecl.ImplementationControl.Required, false);
      SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(2, (ParmVarDecl /*P*/ )null);
      ParmVarDecl /*P*/ objects = ParmVarDecl.Create($this().Context, Method, 
          new SourceLocation(), 
          new SourceLocation(), 
          $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"objects"))), 
          $this().Context.getPointerType(new QualType(IdT)), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          StorageClass.SC_None, (Expr /*P*/ )null);
      Params.push_back(objects);
      ParmVarDecl /*P*/ cnt = ParmVarDecl.Create($this().Context, Method, 
          new SourceLocation(), 
          new SourceLocation(), 
          $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"cnt"))), 
          $this().Context.UnsignedLongTy.$QualType(), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, 
          (Expr /*P*/ )null);
      Params.push_back(cnt);
      Method.setMethodParams($this().Context, new ArrayRef<ParmVarDecl /*P*/ >(Params, true), new ArrayRef<SourceLocation>(None, false));
    }
    if (!validateBoxingMethod(/*Deref*/$this(), new SourceLocation(Loc), $this().NSArrayDecl, new Selector(Sel), Method)) {
      return ExprError();
    }
    
    // Dig out the type that all elements should be converted to.
    QualType T = Method.parameters().$at(0).getType();
    /*const*/ PointerType /*P*/ PtrT = T.$arrow().getAs(PointerType.class);
    if (!(PtrT != null)
       || !$this().Context.hasSameUnqualifiedType(PtrT.getPointeeType(), new QualType(IdT))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_objc_literal_method_sig)), 
            Sel));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.parameters().$at(0).getLocation(), 
                        diag.note_objc_literal_method_param)), 
                    0), T), 
            $this().Context.getPointerType(IdT.withConst())));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check that the 'count' parameter is integral.
    if (!Method.parameters().$at(1).getType().$arrow().isIntegerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_objc_literal_method_sig)), 
            Sel));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.parameters().$at(1).getLocation(), 
                        diag.note_objc_literal_method_param)), 
                    1), 
                Method.parameters().$at(1).getType()), 
            /*KEEP_STR*/"integral"));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // We've found a good +arrayWithObjects:count: method. Save it!
    $this().ArrayWithObjectsMethod = Method;
  }
  
  QualType ObjectsType = $this().ArrayWithObjectsMethod.parameters().$at(0).getType();
  QualType RequiredType = ObjectsType.$arrow().castAs(PointerType.class).getPointeeType();
  
  // Check that each of the elements provided is valid in a collection literal,
  // performing conversions as necessary.
  type$ptr<Expr /*P*/ /*P*/> ElementsBuffer = $tryClone(Elements.data());
  for (/*uint*/int I = 0, N = Elements.size(); I != N; ++I) {
    ActionResultTTrue<Expr /*P*/ > _Converted = CheckObjCCollectionLiteralElement(/*Deref*/$this(), 
        ElementsBuffer.$at(I), 
        new QualType(RequiredType), true);
    if (_Converted.isInvalid()) {
      return ExprError();
    }
    
    ElementsBuffer.$set(I, _Converted.get());
  }
  
  QualType Ty = $this().Context.getObjCObjectPointerType($this().Context.getObjCInterfaceType($this().NSArrayDecl));
  
  return $this().MaybeBindToTemporary(ObjCArrayLiteral.Create($this().Context, new ArrayRef<Expr /*P*/ >(Elements), new QualType(Ty), 
          $this().ArrayWithObjectsMethod, new SourceRange(SR)));
}


/// BuildObjCBoxedExpr - builds an ObjCBoxedExpr AST node for the
/// '@' prefixed parenthesized expression. The type of the expression will
/// either be "NSNumber *", "NSString *" or "NSValue *" depending on the type
/// of ValueType, which is allowed to be a built-in numeric type, "char *",
/// "const char *" or C structure with attribute 'objc_boxable'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCBoxedExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 499,
 FQN="clang::Sema::BuildObjCBoxedExpr", NM="_ZN5clang4Sema18BuildObjCBoxedExprENS_11SourceRangeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema18BuildObjCBoxedExprENS_11SourceRangeEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildObjCBoxedExpr(SourceRange SR, Expr /*P*/ ValueExpr) {
  if (ValueExpr.isTypeDependent()) {
    final Expr /*P*/ $ValueExpr = ValueExpr;
    ObjCBoxedExpr /*P*/ BoxedExpr = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCBoxedExpr($ValueExpr, $this().Context.DependentTy.$QualType(), (ObjCMethodDecl /*P*/ )null, new SourceRange(SR)));
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, BoxedExpr);
  }
  ObjCMethodDecl /*P*/ BoxingMethod = null;
  QualType BoxedType/*J*/= new QualType();
  // Convert the expression to an RValue, so we can check for pointer types...
  ActionResultTTrue<Expr /*P*/ > RValue = $this().DefaultFunctionArrayLvalueConversion(ValueExpr);
  if (RValue.isInvalid()) {
    return ExprError();
  }
  SourceLocation Loc = SR.getBegin();
  ValueExpr = RValue.get();
  QualType ValueType/*J*/= ValueExpr.getType();
  {
    /*const*/ PointerType /*P*/ PT = ValueType.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      QualType PointeeType = PT.getPointeeType();
      if ($this().Context.hasSameUnqualifiedType(new QualType(PointeeType), $this().Context.CharTy.$QualType())) {
        if (!($this().NSStringDecl != null)) {
          $this().NSStringDecl = LookupObjCInterfaceDeclForLiteral(/*Deref*/$this(), new SourceLocation(Loc), 
              Sema.ObjCLiteralKind.LK_String);
          if (!($this().NSStringDecl != null)) {
            return ExprError();
          }
          QualType NSStringObject = $this().Context.getObjCInterfaceType($this().NSStringDecl);
          $this().NSStringPointer.$assignMove($this().Context.getObjCObjectPointerType(new QualType(NSStringObject)));
        }
        if (!($this().StringWithUTF8StringMethod != null)) {
          IdentifierInfo /*P*/ II = $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"stringWithUTF8String")));
          Selector stringWithUTF8String = $this().Context.Selectors.getUnarySelector(II);
          
          // Look for the appropriate method within NSString.
          BoxingMethod = $this().NSStringDecl.lookupClassMethod(new Selector(stringWithUTF8String));
          if (!(BoxingMethod != null) && $this().getLangOpts().DebuggerObjCLiteral) {
            // Debugger needs to work even if NSString hasn't been defined.
            TypeSourceInfo /*P*/ ReturnTInfo = null;
            ObjCMethodDecl /*P*/ M = ObjCMethodDecl.Create($this().Context, new SourceLocation(), new SourceLocation(), new Selector(stringWithUTF8String), 
                new QualType($this().NSStringPointer), ReturnTInfo, $this().NSStringDecl, 
                /*isInstance=*/ false, /*isVariadic=*/ false, 
                /*isPropertyAccessor=*/ false, 
                /*isImplicitlyDeclared=*/ true, 
                /*isDefined=*/ false, ObjCMethodDecl.ImplementationControl.Required, 
                /*HasRelatedResultType=*/ false);
            QualType ConstCharType = $this().Context.CharTy.withConst();
            ParmVarDecl /*P*/ value = ParmVarDecl.Create($this().Context, M, 
                new SourceLocation(), new SourceLocation(), 
                $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"value"))), 
                $this().Context.getPointerType(new QualType(ConstCharType)), 
                /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
                StorageClass.SC_None, (Expr /*P*/ )null);
            M.setMethodParams($this().Context, new ArrayRef<ParmVarDecl /*P*/ >(value, true), new ArrayRef<SourceLocation>(None, false));
            BoxingMethod = M;
          }
          if (!validateBoxingMethod(/*Deref*/$this(), new SourceLocation(Loc), $this().NSStringDecl, 
              new Selector(stringWithUTF8String), BoxingMethod)) {
            return ExprError();
          }
          
          $this().StringWithUTF8StringMethod = BoxingMethod;
        }
        
        BoxingMethod = $this().StringWithUTF8StringMethod;
        BoxedType.$assign($this().NSStringPointer);
      }
    } else if (ValueType.$arrow().isBuiltinType()) {
      {
        // The other types we support are numeric, char and BOOL/bool. We could also
        // provide limited support for structure types, such as NSRange, NSRect, and
        // NSSize. See NSValue (NSValueGeometryExtensions) in <Foundation/NSGeometry.h>
        // for more details.
        
        // Check for a top-level character literal.
        /*const*/ CharacterLiteral /*P*/ Char = dyn_cast_CharacterLiteral(ValueExpr.IgnoreParens());
        if ((Char != null)) {
          // In C, character literals have type 'int'. That's not the type we want
          // to use to determine the Objective-c literal kind.
          switch (Char.getKind()) {
           case Ascii:
           case UTF8:
            ValueType.$assignMove($this().Context.CharTy.$QualType());
            break;
           case Wide:
            ValueType.$assignMove($this().Context.getWideCharType());
            break;
           case UTF16:
            ValueType.$assignMove($this().Context.Char16Ty.$QualType());
            break;
           case UTF32:
            ValueType.$assignMove($this().Context.Char32Ty.$QualType());
            break;
          }
        }
      }
      $this().CheckForIntOverflow(ValueExpr);
      // FIXME:  Do I need to do anything special with BoolTy expressions?
      
      // Look for the appropriate method within NSNumber.
      BoxingMethod = getNSNumberFactoryMethod(/*Deref*/$this(), new SourceLocation(Loc), new QualType(ValueType));
      BoxedType.$assign($this().NSNumberPointer);
    } else {
      /*const*/ EnumType /*P*/ ET = ValueType.$arrow().getAs$EnumType();
      if ((ET != null)) {
        if (!ET.getDecl().isComplete()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_incomplete_boxed_expression_type)), 
                    ValueType), ValueExpr.getSourceRange()));
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
        
        BoxingMethod = getNSNumberFactoryMethod(/*Deref*/$this(), new SourceLocation(Loc), 
            ET.getDecl().getIntegerType());
        BoxedType.$assign($this().NSNumberPointer);
      } else if (ValueType.$arrow().isObjCBoxableRecordType()) {
        // Support for structure types, that marked as objc_boxable
        // struct __attribute__((objc_boxable)) s { ... };
        
        // Look up the NSValue class, if we haven't done so already. It's cached
        // in the Sema instance.
        if (!($this().NSValueDecl != null)) {
          $this().NSValueDecl = LookupObjCInterfaceDeclForLiteral(/*Deref*/$this(), new SourceLocation(Loc), 
              Sema.ObjCLiteralKind.LK_Boxed);
          if (!($this().NSValueDecl != null)) {
            return ExprError();
          }
          
          // generate the pointer to NSValue type.
          QualType NSValueObject = $this().Context.getObjCInterfaceType($this().NSValueDecl);
          $this().NSValuePointer.$assignMove($this().Context.getObjCObjectPointerType(new QualType(NSValueObject)));
        }
        if (!($this().ValueWithBytesObjCTypeMethod != null)) {
          IdentifierInfo /*P*/ II[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"valueWithBytes"))), 
            $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"objCType")))
          };
          Selector ValueWithBytesObjCType = $this().Context.Selectors.getSelector(2, create_type$ptr(II));
          
          // Look for the appropriate method within NSValue.
          BoxingMethod = $this().NSValueDecl.lookupClassMethod(new Selector(ValueWithBytesObjCType));
          if (!(BoxingMethod != null) && $this().getLangOpts().DebuggerObjCLiteral) {
            // Debugger needs to work even if NSValue hasn't been defined.
            TypeSourceInfo /*P*/ ReturnTInfo = null;
            ObjCMethodDecl /*P*/ M = ObjCMethodDecl.Create($this().Context, 
                new SourceLocation(), 
                new SourceLocation(), 
                new Selector(ValueWithBytesObjCType), 
                new QualType($this().NSValuePointer), 
                ReturnTInfo, 
                $this().NSValueDecl, 
                /*isInstance=*/ false, 
                /*isVariadic=*/ false, 
                /*isPropertyAccessor=*/ false, 
                /*isImplicitlyDeclared=*/ true, 
                /*isDefined=*/ false, 
                ObjCMethodDecl.ImplementationControl.Required, 
                /*HasRelatedResultType=*/ false);
            
            SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(2, (ParmVarDecl /*P*/ )null);
            
            ParmVarDecl /*P*/ bytes = ParmVarDecl.Create($this().Context, M, 
                new SourceLocation(), new SourceLocation(), 
                $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"bytes"))), 
                $this().Context.VoidPtrTy.withConst(), 
                /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
                StorageClass.SC_None, (Expr /*P*/ )null);
            Params.push_back(bytes);
            
            QualType ConstCharType = $this().Context.CharTy.withConst();
            ParmVarDecl /*P*/ type = ParmVarDecl.Create($this().Context, M, 
                new SourceLocation(), new SourceLocation(), 
                $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"type"))), 
                $this().Context.getPointerType(new QualType(ConstCharType)), 
                /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
                StorageClass.SC_None, (Expr /*P*/ )null);
            Params.push_back(type);
            
            M.setMethodParams($this().Context, new ArrayRef<ParmVarDecl /*P*/ >(Params, true), new ArrayRef<SourceLocation>(None, false));
            BoxingMethod = M;
          }
          if (!validateBoxingMethod(/*Deref*/$this(), new SourceLocation(Loc), $this().NSValueDecl, 
              new Selector(ValueWithBytesObjCType), BoxingMethod)) {
            return ExprError();
          }
          
          $this().ValueWithBytesObjCTypeMethod = BoxingMethod;
        }
        if (!ValueType.isTriviallyCopyableType($this().Context)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_non_trivially_copyable_boxed_expression_type)), 
                    ValueType), ValueExpr.getSourceRange()));
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
        
        BoxingMethod = $this().ValueWithBytesObjCTypeMethod;
        BoxedType.$assign($this().NSValuePointer);
      }
    }
  }
  if (!(BoxingMethod != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_illegal_boxed_expression_type)), 
              ValueType), ValueExpr.getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().DiagnoseUseOfDecl(BoxingMethod, new SourceLocation(Loc));
  
  ActionResultTTrue<Expr /*P*/ > ConvertedValueExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  if (ValueType.$arrow().isObjCBoxableRecordType()) {
    InitializedEntity IE = InitializedEntity.InitializeTemporary(new QualType(ValueType));
    ConvertedValueExpr.$assignMove($this().PerformCopyInitialization(IE, ValueExpr.getExprLoc(), 
            new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ValueExpr)));
  } else {
    // Convert the expression to the type that the parameter requires.
    ParmVarDecl /*P*/ ParamDecl = BoxingMethod.parameters().$at(0);
    InitializedEntity IE = InitializedEntity.InitializeParameter($this().Context, 
        ParamDecl);
    ConvertedValueExpr.$assignMove($this().PerformCopyInitialization(IE, new SourceLocation(), 
            new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ValueExpr)));
  }
  if (ConvertedValueExpr.isInvalid()) {
    return ExprError();
  }
  ValueExpr = ConvertedValueExpr.get();
  
  final Expr /*P*/ $ValueExpr = ValueExpr;
  final ObjCMethodDecl /*P*/ $BoxingMethod = BoxingMethod;
  ObjCBoxedExpr /*P*/ BoxedExpr = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCBoxedExpr($ValueExpr, new QualType(BoxedType), 
      $BoxingMethod, new SourceRange(SR)));
  return $this().MaybeBindToTemporary(BoxedExpr);
}


/// Build an ObjC subscript pseudo-object expression, given that
/// that's supported by the runtime.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCSubscriptExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 736,
 FQN="clang::Sema::BuildObjCSubscriptExpression", NM="_ZN5clang4Sema28BuildObjCSubscriptExpressionENS_14SourceLocationEPNS_4ExprES3_PNS_14ObjCMethodDeclES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema28BuildObjCSubscriptExpressionENS_14SourceLocationEPNS_4ExprES3_PNS_14ObjCMethodDeclES5_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildObjCSubscriptExpression(SourceLocation RB, Expr /*P*/ BaseExpr, 
                            Expr /*P*/ IndexExpr, 
                            ObjCMethodDecl /*P*/ getterMethod, 
                            ObjCMethodDecl /*P*/ setterMethod) {
  assert (!$this().LangOpts.isSubscriptPointerArithmetic());
  
  // We can't get dependent types here; our callers should have
  // filtered them out.
  assert ((!BaseExpr.isTypeDependent() && !IndexExpr.isTypeDependent())) : "base or index cannot have dependent type here";
  
  // Filter out placeholders in the index.  In theory, overloads could
  // be preserved here, although that might not actually work correctly.
  ActionResultTTrue<Expr /*P*/ > Result = $this().CheckPlaceholderExpr(IndexExpr);
  if (Result.isInvalid()) {
    return ExprError();
  }
  IndexExpr = Result.get();
  
  // Perform lvalue-to-rvalue conversion on the base.
  Result.$assignMove($this().DefaultLvalueConversion(BaseExpr));
  if (Result.isInvalid()) {
    return ExprError();
  }
  BaseExpr = Result.get();
  
  // Build the pseudo-object expression.
  final Expr /*P*/ $BaseExpr = BaseExpr;
  final Expr /*P*/ $IndexExpr = IndexExpr;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCSubscriptRefExpr($BaseExpr, $IndexExpr, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, ExprObjectKind.OK_ObjCSubscript, 
          getterMethod, setterMethod, new SourceLocation(RB))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCDictionaryLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 870,
 FQN="clang::Sema::BuildObjCDictionaryLiteral", NM="_ZN5clang4Sema26BuildObjCDictionaryLiteralENS_11SourceRangeEN4llvm15MutableArrayRefINS_21ObjCDictionaryElementEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema26BuildObjCDictionaryLiteralENS_11SourceRangeEN4llvm15MutableArrayRefINS_21ObjCDictionaryElementEEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildObjCDictionaryLiteral(SourceRange SR, 
                          MutableArrayRef<ObjCDictionaryElement> Elements) {
  SourceLocation Loc = SR.getBegin();
  if (!($this().NSDictionaryDecl != null)) {
    $this().NSDictionaryDecl = LookupObjCInterfaceDeclForLiteral(/*Deref*/$this(), new SourceLocation(Loc), 
        Sema.ObjCLiteralKind.LK_Dictionary);
    if (!($this().NSDictionaryDecl != null)) {
      return ExprError();
    }
  }
  
  // Find the dictionaryWithObjects:forKeys:count: method, if we haven't done
  // so already.
  QualType IdT = $this().Context.getObjCIdType();
  if (!($this().DictionaryWithObjectsMethod != null)) {
    Selector Sel = $this().NSAPIObj.$arrow().getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_dictionaryWithObjectsForKeysCount);
    ObjCMethodDecl /*P*/ Method = $this().NSDictionaryDecl.lookupClassMethod(new Selector(Sel));
    if (!(Method != null) && $this().getLangOpts().DebuggerObjCLiteral) {
      Method = ObjCMethodDecl.Create($this().Context, 
          new SourceLocation(), new SourceLocation(), new Selector(Sel), 
          new QualType(IdT), 
          (TypeSourceInfo /*P*/ )null/*TypeSourceInfo */, 
          $this().Context.getTranslationUnitDecl(), 
          false/*Instance*/, false/*isVariadic*/, 
          /*isPropertyAccessor=*/ false, 
          /*isImplicitlyDeclared=*/ true, /*isDefined=*/ false, 
          ObjCMethodDecl.ImplementationControl.Required, 
          false);
      SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(3, (ParmVarDecl /*P*/ )null);
      ParmVarDecl /*P*/ objects = ParmVarDecl.Create($this().Context, Method, 
          new SourceLocation(), 
          new SourceLocation(), 
          $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"objects"))), 
          $this().Context.getPointerType(new QualType(IdT)), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, 
          (Expr /*P*/ )null);
      Params.push_back(objects);
      ParmVarDecl /*P*/ keys = ParmVarDecl.Create($this().Context, Method, 
          new SourceLocation(), 
          new SourceLocation(), 
          $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"keys"))), 
          $this().Context.getPointerType(new QualType(IdT)), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, 
          (Expr /*P*/ )null);
      Params.push_back(keys);
      ParmVarDecl /*P*/ cnt = ParmVarDecl.Create($this().Context, Method, 
          new SourceLocation(), 
          new SourceLocation(), 
          $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"cnt"))), 
          $this().Context.UnsignedLongTy.$QualType(), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, 
          (Expr /*P*/ )null);
      Params.push_back(cnt);
      Method.setMethodParams($this().Context, new ArrayRef<ParmVarDecl /*P*/ >(Params, true), new ArrayRef<SourceLocation>(None, false));
    }
    if (!validateBoxingMethod(/*Deref*/$this(), SR.getBegin(), $this().NSDictionaryDecl, new Selector(Sel), 
        Method)) {
      return ExprError();
    }
    
    // Dig out the type that all values should be converted to.
    QualType ValueT = Method.parameters().$at(0).getType();
    /*const*/ PointerType /*P*/ PtrValue = ValueT.$arrow().getAs(PointerType.class);
    if (!(PtrValue != null)
       || !$this().Context.hasSameUnqualifiedType(PtrValue.getPointeeType(), new QualType(IdT))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_objc_literal_method_sig)), 
            Sel));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.parameters().$at(0).getLocation(), 
                        diag.note_objc_literal_method_param)), 
                    0), ValueT), 
            $this().Context.getPointerType(IdT.withConst())));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Dig out the type that all keys should be converted to.
    QualType KeyT = Method.parameters().$at(1).getType();
    /*const*/ PointerType /*P*/ PtrKey = KeyT.$arrow().getAs(PointerType.class);
    if (!(PtrKey != null)
       || !$this().Context.hasSameUnqualifiedType(PtrKey.getPointeeType(), 
        new QualType(IdT))) {
      boolean err = true;
      if ((PtrKey != null)) {
        if ($this().QIDNSCopying.isNull()) {
          {
            // key argument of selector is id<NSCopying>?
            ObjCProtocolDecl /*P*/ NSCopyingPDecl = $this().LookupProtocol($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"NSCopying"))), SR.getBegin());
            if ((NSCopyingPDecl != null)) {
              ObjCProtocolDecl /*P*/ PQ[/*1*/] = new ObjCProtocolDecl /*P*/  [/*1*/] {NSCopyingPDecl};
              $this().QIDNSCopying.$assignMove(
                  $this().Context.getObjCObjectType($this().Context.ObjCBuiltinIdTy.$QualType(), /*{ */new ArrayRef<QualType>(false)/* }*/, 
                      llvm.makeArrayRef((type$ptr<ObjCProtocolDecl /*P*/ /*P*/>)create_type$ptr(PQ), 
                          1), 
                      false)
              );
              $this().QIDNSCopying.$assignMove($this().Context.getObjCObjectPointerType(new QualType($this().QIDNSCopying)));
            }
          }
        }
        if (!$this().QIDNSCopying.isNull()) {
          err = !$this().Context.hasSameUnqualifiedType(PtrKey.getPointeeType(), 
              new QualType($this().QIDNSCopying));
        }
      }
      if (err) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_objc_literal_method_sig)), 
              Sel));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.parameters().$at(1).getLocation(), 
                          diag.note_objc_literal_method_param)), 
                      1), KeyT), 
              $this().Context.getPointerType(IdT.withConst())));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Check that the 'count' parameter is integral.
    QualType CountType = Method.parameters().$at(2).getType();
    if (!CountType.$arrow().isIntegerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_objc_literal_method_sig)), 
            Sel));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.parameters().$at(2).getLocation(), 
                        diag.note_objc_literal_method_param)), 
                    2), CountType), 
            /*KEEP_STR*/"integral"));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // We've found a good +dictionaryWithObjects:keys:count: method; save it!
    $this().DictionaryWithObjectsMethod = Method;
  }
  
  QualType ValuesT = $this().DictionaryWithObjectsMethod.parameters().$at(0).getType();
  QualType ValueT = ValuesT.$arrow().castAs(PointerType.class).getPointeeType();
  QualType KeysT = $this().DictionaryWithObjectsMethod.parameters().$at(1).getType();
  QualType KeyT = KeysT.$arrow().castAs(PointerType.class).getPointeeType();
  
  // Check that each of the keys and values provided is valid in a collection 
  // literal, performing conversions as necessary.
  boolean HasPackExpansions = false;
  for (final ObjCDictionaryElement /*&*/ Element : Elements) {
    // Check the key.
    ActionResultTTrue<Expr /*P*/ > Key = CheckObjCCollectionLiteralElement(/*Deref*/$this(), Element.Key, 
        new QualType(KeyT));
    if (Key.isInvalid()) {
      return ExprError();
    }
    
    // Check the value.
    ActionResultTTrue<Expr /*P*/ > Value = CheckObjCCollectionLiteralElement(/*Deref*/$this(), Element.Value, new QualType(ValueT));
    if (Value.isInvalid()) {
      return ExprError();
    }
    
    Element.Key = Key.get();
    Element.Value = Value.get();
    if (Element.EllipsisLoc.isInvalid()) {
      continue;
    }
    if (!Element.Key.containsUnexpandedParameterPack()
       && !Element.Value.containsUnexpandedParameterPack()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Element.EllipsisLoc), 
                diag.err_pack_expansion_without_parameter_packs)), 
            new SourceRange(Element.Key.getLocStart(), 
                Element.Value.getLocEnd())));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    HasPackExpansions = true;
  }
  
  QualType Ty = $this().Context.getObjCObjectPointerType($this().Context.getObjCInterfaceType($this().NSDictionaryDecl));
  return $this().MaybeBindToTemporary(ObjCDictionaryLiteral.Create($this().Context, new ArrayRef<ObjCDictionaryElement>(Elements), HasPackExpansions, new QualType(Ty), 
          $this().DictionaryWithObjectsMethod, new SourceRange(SR)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCEncodeExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1047,
 FQN="clang::Sema::BuildObjCEncodeExpression", NM="_ZN5clang4Sema25BuildObjCEncodeExpressionENS_14SourceLocationEPNS_14TypeSourceInfoES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema25BuildObjCEncodeExpressionENS_14SourceLocationEPNS_14TypeSourceInfoES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildObjCEncodeExpression(SourceLocation AtLoc, 
                         TypeSourceInfo /*P*/ EncodedTypeInfo, 
                         SourceLocation RParenLoc) {
  QualType EncodedType = EncodedTypeInfo.getType();
  QualType StrTy/*J*/= new QualType();
  if (EncodedType.$arrow().isDependentType()) {
    StrTy.$assignMove($this().Context.DependentTy.$QualType());
  } else {
    if (!(EncodedType.$arrow().getAsArrayTypeUnsafe() != null) //// Incomplete array is handled.
       && !EncodedType.$arrow().isVoidType()) { // void is handled too.
      if ($this().RequireCompleteType$T(new SourceLocation(AtLoc), new QualType(EncodedType), 
          diag.err_incomplete_type_objc_at_encode, 
          EncodedTypeInfo.getTypeLoc())) {
        return ExprError();
      }
    }
    
    std.string Str/*J*/= new std.string();
    QualType NotEncodedT/*J*/= new QualType();
    $this().Context.getObjCEncodingForType(new QualType(EncodedType), Str, (/*const*/ FieldDecl /*P*/ )null, $AddrOf(NotEncodedT));
    if (!NotEncodedT.isNull()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.warn_incomplete_encoded_type)), 
                EncodedType), NotEncodedT));
      } finally {
        $c$.$destroy();
      }
    }
    
    // The type of @encode is the same as the type of the corresponding string,
    // which is an array type.
    StrTy.$assignMove($this().Context.CharTy.$QualType());
    // A C++ string literal has a const-qualified element type (C++ 2.13.4p1).
    if ($this().getLangOpts().CPlusPlus || $this().getLangOpts().ConstStrings) {
      StrTy.addConst();
    }
    StrTy.$assignMove($this().Context.getConstantArrayType(new QualType(StrTy), new APInt(32, $uint2ulong(Str.size() + 1)), 
            ArrayType.ArraySizeModifier.Normal, 0));
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCEncodeExpr(new QualType(StrTy), EncodedTypeInfo, new SourceLocation(AtLoc), new SourceLocation(RParenLoc))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ParseObjCEncodeExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1082,
 FQN="clang::Sema::ParseObjCEncodeExpression", NM="_ZN5clang4Sema25ParseObjCEncodeExpressionENS_14SourceLocationES1_S1_NS_9OpaquePtrINS_8QualTypeEEES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema25ParseObjCEncodeExpressionENS_14SourceLocationES1_S1_NS_9OpaquePtrINS_8QualTypeEEES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ParseObjCEncodeExpression(SourceLocation AtLoc, 
                         SourceLocation EncodeLoc, 
                         SourceLocation LParenLoc, 
                         OpaquePtr<QualType> ty, 
                         SourceLocation RParenLoc) {
  // FIXME: Preserve type source info ?
  type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
  QualType EncodedType = GetTypeFromParser(new OpaquePtr<QualType>(ty), $AddrOf(TInfo));
  if (!(TInfo.$star() != null)) {
    TInfo.$set($this().Context.getTrivialTypeSourceInfo(new QualType(EncodedType), 
        $this().getLocForEndOfToken(new SourceLocation(LParenLoc))));
  }
  
  return $this().BuildObjCEncodeExpression(new SourceLocation(AtLoc), TInfo.$star(), new SourceLocation(RParenLoc));
}


/// ParseObjCSelectorExpression - Build selector expression for \@selector
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ParseObjCSelectorExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1153,
 FQN="clang::Sema::ParseObjCSelectorExpression", NM="_ZN5clang4Sema27ParseObjCSelectorExpressionENS_8SelectorENS_14SourceLocationES2_S2_S2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema27ParseObjCSelectorExpressionENS_8SelectorENS_14SourceLocationES2_S2_S2_b")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ParseObjCSelectorExpression(Selector Sel, 
                           SourceLocation AtLoc, 
                           SourceLocation SelLoc, 
                           SourceLocation LParenLoc, 
                           SourceLocation RParenLoc, 
                           boolean WarnMultipleSelectors) {
  ObjCMethodDecl /*P*/ Method = $this().LookupInstanceMethodInGlobalPool(new Selector(Sel), 
      new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
  if (!(Method != null)) {
    Method = $this().LookupFactoryMethodInGlobalPool(new Selector(Sel), 
        new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
  }
  if (!(Method != null)) {
    {
      /*const*/ ObjCMethodDecl /*P*/ OM = $this().SelectorsForTypoCorrection(new Selector(Sel));
      if ((OM != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Selector MatchedSel = OM.getSelector();
          SourceRange SelectorRange/*J*/= new SourceRange(LParenLoc.getLocWithOffset(1), 
              RParenLoc.getLocWithOffset(-1));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), diag.warn_undeclared_selector_with_typo)), 
                      Sel), MatchedSel), 
              FixItHint.CreateReplacement(/*NO_COPY*/SelectorRange, new StringRef(MatchedSel.getAsString()))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), diag.warn_undeclared_selector)), Sel));
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else {
    DiagnoseMismatchedSelectors(/*Deref*/$this(), new SourceLocation(AtLoc), Method, new SourceLocation(LParenLoc), new SourceLocation(RParenLoc), 
        WarnMultipleSelectors);
  }
  if ((Method != null)
     && Method.getImplementationControl() != ObjCMethodDecl.ImplementationControl.Optional
     && !$this().getSourceManager().isInSystemHeader(Method.getLocation())) {
    $this().ReferencedSelectors.insert(std.make_pair(Sel, AtLoc));
  }
  
  // In ARC, forbid the user from using @selector for 
  // retain/release/autorelease/dealloc/retainCount.
  if ($this().getLangOpts().ObjCAutoRefCount) {
    switch (Sel.getMethodFamily()) {
     case OMF_retain:
     case OMF_release:
     case OMF_autorelease:
     case OMF_retainCount:
     case OMF_dealloc:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_arc_illegal_selector)), 
                  Sel), new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OMF_None:
     case OMF_alloc:
     case OMF_copy:
     case OMF_finalize:
     case OMF_init:
     case OMF_mutableCopy:
     case OMF_new:
     case OMF_self:
     case OMF_initialize:
     case OMF_performSelector:
      break;
    }
  }
  QualType Ty = $this().Context.getObjCSelType();
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCSelectorExpr(new QualType(Ty), new Selector(Sel), new SourceLocation(AtLoc), new SourceLocation(RParenLoc))));
}


/// ParseObjCProtocolExpression - Build protocol expression for \@protocol
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ParseObjCProtocolExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1214,
 FQN="clang::Sema::ParseObjCProtocolExpression", NM="_ZN5clang4Sema27ParseObjCProtocolExpressionEPNS_14IdentifierInfoENS_14SourceLocationES3_S3_S3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema27ParseObjCProtocolExpressionEPNS_14IdentifierInfoENS_14SourceLocationES3_S3_S3_S3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ParseObjCProtocolExpression(IdentifierInfo /*P*/ ProtocolId, 
                           SourceLocation AtLoc, 
                           SourceLocation ProtoLoc, 
                           SourceLocation LParenLoc, 
                           SourceLocation ProtoIdLoc, 
                           SourceLocation RParenLoc) {
  ObjCProtocolDecl /*P*/ PDecl = $this().LookupProtocol(ProtocolId, new SourceLocation(ProtoIdLoc));
  if (!(PDecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ProtoLoc), diag.err_undeclared_protocol)), ProtocolId));
      return new ActionResultTTrue<Expr /*P*/ >(true);
    } finally {
      $c$.$destroy();
    }
  }
  if (PDecl.hasDefinition()) {
    PDecl = PDecl.getDefinition();
  }
  
  QualType Ty = $this().Context.getObjCProtoType();
  if (Ty.isNull()) {
    return new ActionResultTTrue<Expr /*P*/ >(true);
  }
  Ty.$assignMove($this().Context.getObjCObjectPointerType(new QualType(Ty)));
  final ObjCProtocolDecl /*P*/ $PDecl = PDecl;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCProtocolExpr(new QualType(Ty), $PDecl, new SourceLocation(AtLoc), new SourceLocation(ProtoIdLoc), new SourceLocation(RParenLoc))));
}


/// LookupMethodInQualifiedType - Lookups up a method in protocol qualifier 
/// list of a qualified objective pointer type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupMethodInQualifiedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1740,
 FQN="clang::Sema::LookupMethodInQualifiedType", NM="_ZN5clang4Sema27LookupMethodInQualifiedTypeENS_8SelectorEPKNS_21ObjCObjectPointerTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema27LookupMethodInQualifiedTypeENS_8SelectorEPKNS_21ObjCObjectPointerTypeEb")
//</editor-fold>
public final ObjCMethodDecl /*P*/ LookupMethodInQualifiedType(Selector Sel, 
                           /*const*/ ObjCObjectPointerType /*P*/ OPT, 
                           boolean Instance) {
  ObjCMethodDecl /*P*/ MD = null;
  for (/*const*/ ObjCProtocolDecl /*P*/ PROTO : OPT.quals()) {
    if (((MD = PROTO.lookupMethod(new Selector(Sel), Instance)) != null)) {
      return MD;
    }
  }
  return null;
}


/// LookupMethodInType - Look up a method in an ObjCObjectType.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupMethodInObjectType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1716,
 FQN="clang::Sema::LookupMethodInObjectType", NM="_ZN5clang4Sema24LookupMethodInObjectTypeENS_8SelectorENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema24LookupMethodInObjectTypeENS_8SelectorENS_8QualTypeEb")
//</editor-fold>
public final ObjCMethodDecl /*P*/ LookupMethodInObjectType(Selector sel, QualType type, 
                        boolean isInstance) {
  /*const*/ ObjCObjectType /*P*/ objType = type.$arrow().castAs(ObjCObjectType.class);
  {
    ObjCInterfaceDecl /*P*/ iface = objType.getInterface();
    if ((iface != null)) {
      {
        // Look it up in the main interface (and categories, etc.)
        ObjCMethodDecl /*P*/ method = iface.lookupMethod(new Selector(sel), isInstance);
        if ((method != null)) {
          return method;
        }
      }
      {
        
        // Okay, look for "private" methods declared in any
        // @implementations we've seen.
        ObjCMethodDecl /*P*/ method = iface.lookupPrivateMethod(sel, isInstance);
        if ((method != null)) {
          return method;
        }
      }
    }
  }
  
  // Check qualifiers.
  for (/*const*/ ObjCProtocolDecl /*P*/ I : objType.quals())  {
    {
      ObjCMethodDecl /*P*/ method = I.lookupMethod(new Selector(sel), isInstance);
      if ((method != null)) {
        return method;
      }
    }
  }
  
  return null;
}


/// HandleExprPropertyRefExpr - Handle foo.bar where foo is a pointer to an
/// objective C interface.  This is a property reference expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandleExprPropertyRefExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1755,
 FQN="clang::Sema::HandleExprPropertyRefExpr", NM="_ZN5clang4Sema25HandleExprPropertyRefExprEPKNS_21ObjCObjectPointerTypeEPNS_4ExprENS_14SourceLocationENS_15DeclarationNameES6_S6_NS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema25HandleExprPropertyRefExprEPKNS_21ObjCObjectPointerTypeEPNS_4ExprENS_14SourceLocationENS_15DeclarationNameES6_S6_NS_8QualTypeEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > HandleExprPropertyRefExpr(/*const*/ ObjCObjectPointerType /*P*/ OPT, 
                         Expr /*P*/ BaseExpr, SourceLocation OpLoc, 
                         DeclarationName MemberName, 
                         SourceLocation MemberLoc, 
                         SourceLocation SuperLoc, QualType SuperType, 
                         boolean Super) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ ObjCInterfaceType /*P*/ IFaceT = OPT.getInterfaceType();
    ObjCInterfaceDecl /*P*/ IFace = IFaceT.getDecl();
    if (!MemberName.isIdentifier()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MemberLoc), diag.err_invalid_property_name)), 
              MemberName), new QualType(OPT, 0)));
      return ExprError();
    }
    
    IdentifierInfo /*P*/ Member = MemberName.getAsIdentifierInfo();
    
    SourceRange BaseRange = Super ? new SourceRange(/*NO_COPY*/SuperLoc) : BaseExpr.getSourceRange();
    if ($this().RequireCompleteType$T(new SourceLocation(MemberLoc), OPT.getPointeeType(), 
        diag.err_property_not_found_forward_class, 
        MemberName, BaseRange)) {
      return ExprError();
    }
    {
      
      ObjCPropertyDecl /*P*/ PD = IFace.FindPropertyDeclaration(Member, ObjCPropertyQueryKind.OBJC_PR_query_instance);
      if ((PD != null)) {
        // Check whether we can reference this property.
        if ($this().DiagnoseUseOfDecl(PD, new SourceLocation(MemberLoc))) {
          return ExprError();
        }
        if (Super) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(PD, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                  ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), new SourceLocation(SuperLoc), new QualType(SuperType))));
        } else {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(PD, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                  ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), BaseExpr)));
        }
      }
    }
    // Check protocols on qualified interfaces.
    for (/*const*/ ObjCProtocolDecl /*P*/ I : OPT.quals())  {
      {
        ObjCPropertyDecl /*P*/ PD = I.FindPropertyDeclaration(Member, ObjCPropertyQueryKind.OBJC_PR_query_instance);
        if ((PD != null)) {
          // Check whether we can reference this property.
          if ($this().DiagnoseUseOfDecl(PD, new SourceLocation(MemberLoc))) {
            return ExprError();
          }
          if (Super) {
            return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(PD, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), 
                    new SourceLocation(SuperLoc), new QualType(SuperType))));
          } else {
            return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(PD, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                    ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), BaseExpr)));
          }
        }
      }
    }
    // If that failed, look for an "implicit" property by seeing if the nullary
    // selector is implemented.
    
    // FIXME: The logic for looking up nullary and unary selectors should be
    // shared with the code in ActOnInstanceMessage.
    Selector Sel = $this().PP.getSelectorTable().getNullarySelector(Member);
    ObjCMethodDecl /*P*/ Getter = IFace.lookupInstanceMethod(new Selector(Sel));
    
    // May be found in property's qualified list.
    if (!(Getter != null)) {
      Getter = $this().LookupMethodInQualifiedType(new Selector(Sel), OPT, true);
    }
    
    // If this reference is in an @implementation, check for 'private' methods.
    if (!(Getter != null)) {
      Getter = IFace.lookupPrivateMethod(Sel);
    }
    if ((Getter != null)) {
      // Check if we can reference this property.
      if ($this().DiagnoseUseOfDecl(Getter, new SourceLocation(MemberLoc))) {
        return ExprError();
      }
    }
    // If we found a getter then this may be a valid dot-reference, we
    // will look for the matching setter, in case it is needed.
    Selector SetterSel = SelectorTable.constructSetterSelector($this().PP.getIdentifierTable(), 
        $this().PP.getSelectorTable(), Member);
    ObjCMethodDecl /*P*/ Setter = IFace.lookupInstanceMethod(new Selector(SetterSel));
    
    // May be found in property's qualified list.
    if (!(Setter != null)) {
      Setter = $this().LookupMethodInQualifiedType(new Selector(SetterSel), OPT, true);
    }
    if (!(Setter != null)) {
      // If this reference is in an @implementation, also check for 'private'
      // methods.
      Setter = IFace.lookupPrivateMethod(SetterSel);
    }
    if ((Setter != null) && $this().DiagnoseUseOfDecl(Setter, new SourceLocation(MemberLoc))) {
      return ExprError();
    }
    
    // Special warning if member name used in a property-dot for a setter accessor
    // does not use a property with same name; e.g. obj.X = ... for a property with
    // name 'x'.
    if ((Setter != null) && Setter.isImplicit() && Setter.isPropertyAccessor()
       && !(IFace.FindPropertyDeclaration(Member, ObjCPropertyQueryKind.OBJC_PR_query_instance) != null)) {
      {
        /*const*/ ObjCPropertyDecl /*P*/ PDecl = Setter.findPropertyDecl();
        if ((PDecl != null)) {
          // Do not warn if user is using property-dot syntax to make call to
          // user named setter.
          if (!((PDecl.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_setter) != 0)) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MemberLoc), 
                                diag.warn_property_access_suggest)), 
                            MemberName), new QualType(OPT, 0)), PDecl.getName()), 
                FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/MemberLoc), PDecl.getName())));
          }
        }
      }
    }
    if ((Getter != null) || (Setter != null)) {
      final ObjCMethodDecl /*P*/ $Getter = Getter;
      final ObjCMethodDecl /*P*/ $Setter = Setter;
      if (Super) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr($Getter, $Setter, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), new SourceLocation(SuperLoc), new QualType(SuperType))));
      } else {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr($Getter, $Setter, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), BaseExpr)));
      }
    }
    {
      TypoCorrection Corrected = null;
      try {
        
        // Attempt to correct for typos in property names.
        Corrected = $c$.clean($this().CorrectTypo(new DeclarationNameInfo(new DeclarationName(MemberName), new SourceLocation(MemberLoc)), 
            LookupNameKind.LookupOrdinaryName, (Scope /*P*/ )null, (CXXScopeSpec /*P*/ )null, 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DeclFilterCCC<ObjCPropertyDecl>(ObjCPropertyDecl.class))))), 
            CorrectTypoKind.CTK_ErrorRecovery, IFace, false, OPT));
        if (Corrected.$bool()) {
          DeclarationName TypoResult = Corrected.getCorrection();
          if (TypoResult.isIdentifier()
             && TypoResult.getAsIdentifierInfo() == Member) {
            // There is no need to try the correction if it is the same.
            NamedDecl /*P*/ ChosenDecl = Corrected.isKeyword() ? null : Corrected.getFoundDecl();
            if ((ChosenDecl != null) && isa_ObjCPropertyDecl(ChosenDecl)) {
              if (cast_ObjCPropertyDecl(ChosenDecl).isClassProperty()) {
                // This is a class property, we should not use the instance to
                // access it.
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MemberLoc), diag.err_class_property_found)), MemberName), 
                        OPT.getInterfaceDecl().getName()), 
                    FixItHint.CreateReplacement(BaseExpr.getSourceRange(), 
                        OPT.getInterfaceDecl().getName())));
                return ExprError();
              }
            }
          } else {
            $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_property_not_found_suggest)), 
                        /*NO_COPY*/MemberName), new QualType(OPT, 0))); $c$.clean();
            return $this().HandleExprPropertyRefExpr(OPT, BaseExpr, new SourceLocation(OpLoc), 
                new DeclarationName(TypoResult), new SourceLocation(MemberLoc), 
                new SourceLocation(SuperLoc), new QualType(SuperType), Super);
          }
        }
      } finally {
        if (Corrected != null) { Corrected.$destroy(); }
      }
    }
    type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$ref();
    {
      ObjCIvarDecl /*P*/ Ivar = IFace.lookupInstanceVariable(Member, ClassDeclared);
      if ((Ivar != null)) {
        QualType T = Ivar.getType();
        {
          /*const*/ ObjCObjectPointerType /*P*/ OBJPT = T.$arrow().getAsObjCInterfacePointerType();
          if ((OBJPT != null)) {
            if ($this().RequireCompleteType$T(new SourceLocation(MemberLoc), OBJPT.getPointeeType(), 
                diag.err_property_not_as_forward_class, 
                MemberName, BaseExpr)) {
              return ExprError();
            }
          }
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MemberLoc), 
                            diag.err_ivar_access_using_property_syntax_suggest)), 
                        MemberName), new QualType(OPT, 0)), Ivar.getDeclName()), 
            FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$ARROW))));
        return ExprError();
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MemberLoc), diag.err_property_not_found)), 
            MemberName), new QualType(OPT, 0)));
    if ((Setter != null)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Setter.getLocation(), diag.note_getter_unavailable)), 
              MemberName), BaseExpr.getSourceRange()));
    }
    return ExprError();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnClassPropertyRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1938,
 FQN="clang::Sema::ActOnClassPropertyRefExpr", NM="_ZN5clang4Sema25ActOnClassPropertyRefExprERNS_14IdentifierInfoES2_NS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema25ActOnClassPropertyRefExprERNS_14IdentifierInfoES2_NS_14SourceLocationES3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnClassPropertyRefExpr(final IdentifierInfo /*&*/ receiverName, 
                         final IdentifierInfo /*&*/ propertyName, 
                         SourceLocation receiverNameLoc, 
                         SourceLocation propertyNameLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    type$ref<IdentifierInfo /*P*/ > receiverNamePtr = create_type$ref($AddrOf(receiverName));
    ObjCInterfaceDecl /*P*/ IFace = $this().getObjCInterfaceDecl(receiverNamePtr, 
        new SourceLocation(receiverNameLoc));
    
    QualType SuperType/*J*/= new QualType();
    if (!(IFace != null)) {
      // If the "receiver" is 'super' in a method, handle it as an expression-like
      // property reference.
      if (receiverNamePtr.$deref().isStr(/*KEEP_STR*/"super")) {
        {
          ObjCMethodDecl /*P*/ CurMethod = $this().tryCaptureObjCSelf(new SourceLocation(receiverNameLoc));
          if ((CurMethod != null)) {
            {
              ObjCInterfaceDecl /*P*/ classDecl = CurMethod.getClassInterface();
              if ((classDecl != null)) {
                SuperType.$assignMove(new QualType(classDecl.getSuperClassType(), 0));
                if (CurMethod.isInstanceMethod()) {
                  if (SuperType.isNull()) {
                    // The current class does not have a superclass.
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(receiverNameLoc), diag.error_root_class_cannot_use_super)), 
                        CurMethod.getClassInterface().getIdentifier()));
                    return ExprError();
                  }
                  QualType T = $this().Context.getObjCObjectPointerType(new QualType(SuperType));
                  
                  return $this().HandleExprPropertyRefExpr(T.$arrow().castAs(ObjCObjectPointerType.class), 
                      /*BaseExpr*/ (Expr /*P*/ )null, 
                      new SourceLocation()/*OpLoc*/, 
                      new DeclarationName($AddrOf(propertyName)), 
                      new SourceLocation(propertyNameLoc), 
                      new SourceLocation(receiverNameLoc), new QualType(T), true);
                }
                
                // Otherwise, if this is a class method, try dispatching to our
                // superclass.
                IFace = CurMethod.getClassInterface().getSuperClass();
              }
            }
          }
        }
      }
      if (!(IFace != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(receiverNameLoc), diag.err_expected_either)), tok.TokenKind.identifier), 
            tok.TokenKind.l_paren));
        return ExprError();
      }
    }
    
    // Search for a declared property first.
    Selector Sel = $this().PP.getSelectorTable().getNullarySelector($AddrOf(propertyName));
    ObjCMethodDecl /*P*/ Getter = IFace.lookupClassMethod(new Selector(Sel));
    
    // If this reference is in an @implementation, check for 'private' methods.
    if (!(Getter != null)) {
      Getter = IFace.lookupPrivateClassMethod(Sel);
    }
    if ((Getter != null)) {
      // FIXME: refactor/share with ActOnMemberReference().
      // Check if we can reference this property.
      if ($this().DiagnoseUseOfDecl(Getter, new SourceLocation(propertyNameLoc))) {
        return ExprError();
      }
    }
    
    // Look for the matching setter, in case it is needed.
    Selector SetterSel = SelectorTable.constructSetterSelector($this().PP.getIdentifierTable(), 
        $this().PP.getSelectorTable(), 
        $AddrOf(propertyName));
    
    ObjCMethodDecl /*P*/ Setter = IFace.lookupClassMethod(new Selector(SetterSel));
    if (!(Setter != null)) {
      // If this reference is in an @implementation, also check for 'private'
      // methods.
      Setter = IFace.lookupPrivateClassMethod(SetterSel);
    }
    // Look through local category implementations associated with the class.
    if (!(Setter != null)) {
      Setter = IFace.getCategoryClassMethod(new Selector(SetterSel));
    }
    if ((Setter != null) && $this().DiagnoseUseOfDecl(Setter, new SourceLocation(propertyNameLoc))) {
      return ExprError();
    }
    if ((Getter != null) || (Setter != null)) {
      final ObjCMethodDecl /*P*/ $Getter = Getter;
      final ObjCMethodDecl /*P*/ $Setter = Setter;
      if (!SuperType.isNull()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr($Getter, $Setter, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                ExprObjectKind.OK_ObjCProperty, new SourceLocation(propertyNameLoc), new SourceLocation(receiverNameLoc), 
                new QualType(SuperType))));
      }
      
      final ObjCInterfaceDecl /*P*/ $IFace = IFace;
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr($Getter, $Setter, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, ExprObjectKind.OK_ObjCProperty, 
              new SourceLocation(propertyNameLoc), new SourceLocation(receiverNameLoc), $IFace)));
    }
    return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(propertyNameLoc), diag.err_property_not_found)), 
                $AddrOf(propertyName)), $this().Context.getObjCInterfaceType(IFace))));
  } finally {
    $c$.$destroy();
  }
}


/// Try to capture an implicit reference to 'self'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::tryCaptureObjCSelf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1236,
 FQN="clang::Sema::tryCaptureObjCSelf", NM="_ZN5clang4Sema18tryCaptureObjCSelfENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema18tryCaptureObjCSelfENS_14SourceLocationE")
//</editor-fold>
public final ObjCMethodDecl /*P*/ tryCaptureObjCSelf(SourceLocation Loc) {
  DeclContext /*P*/ DC = $this().getFunctionLevelDeclContext();
  
  // If we're not in an ObjC method, error out.  Note that, unlike the
  // C++ case, we don't require an instance method --- class methods
  // still have a 'self', and we really do still need to capture it!
  ObjCMethodDecl /*P*/ method = dyn_cast_ObjCMethodDecl(DC);
  if (!(method != null)) {
    return null;
  }
  
  $this().tryCaptureVariable(method.getSelfDecl(), new SourceLocation(Loc));
  
  return method;
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getObjCMessageKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2054,
 FQN="clang::Sema::getObjCMessageKind", NM="_ZN5clang4Sema18getObjCMessageKindEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationEbbRNS_9OpaquePtrINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema18getObjCMessageKindEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationEbbRNS_9OpaquePtrINS_8QualTypeEEE")
//</editor-fold>
public final Sema.ObjCMessageKind getObjCMessageKind(Scope /*P*/ S, 
                  IdentifierInfo /*P*/ Name, 
                  SourceLocation NameLoc, 
                  boolean IsSuper, 
                  boolean HasTrailingDot, 
                  final OpaquePtr<QualType> /*&*/ ReceiverType) {
  LookupResult Result = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ReceiverType.$assignMove(new OpaquePtr<QualType>(null));
    
    // If the identifier is "super" and there is no trailing dot, we're
    // messaging super. If the identifier is "super" and there is a
    // trailing dot, it's an instance message.
    if (IsSuper && S.isInObjcMethodScope()) {
      return HasTrailingDot ? ObjCMessageKind.ObjCInstanceMessage : ObjCMessageKind.ObjCSuperMessage;
    }
    
    Result/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(NameLoc), LookupNameKind.LookupOrdinaryName);
    $this().LookupName(Result, S);
    switch (Result.getResultKind()) {
     case NotFound:
      {
        // Normal name lookup didn't find anything. If we're in an
        // Objective-C method, look for ivars. If we find one, we're done!
        // FIXME: This is a hack. Ivar lookup should be part of normal
        // lookup.
        ObjCMethodDecl /*P*/ Method = $this().getCurMethodDecl();
        if ((Method != null)) {
          if (!(Method.getClassInterface() != null)) {
            // Fall back: let the parser try to parse it as an instance message.
            return ObjCMessageKind.ObjCInstanceMessage;
          }
          
          type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$ref();
          if ((Method.getClassInterface().lookupInstanceVariable(Name, 
              ClassDeclared) != null)) {
            return ObjCMessageKind.ObjCInstanceMessage;
          }
        }
      }
      
      // Break out; we'll perform typo correction below.
      break;
     case NotFoundInCurrentInstantiation:
     case FoundOverloaded:
     case FoundUnresolvedValue:
     case Ambiguous:
      Result.suppressDiagnostics();
      return ObjCMessageKind.ObjCInstanceMessage;
     case Found:
      {
        // If the identifier is a class or not, and there is a trailing dot,
        // it's an instance message.
        if (HasTrailingDot) {
          return ObjCMessageKind.ObjCInstanceMessage;
        }
        // We found something. If it's a type, then we have a class
        // message. Otherwise, it's an instance message.
        NamedDecl /*P*/ ND = Result.getFoundDecl();
        QualType T/*J*/= new QualType();
        {
          ObjCInterfaceDecl /*P*/ Class = dyn_cast_ObjCInterfaceDecl(ND);
          if ((Class != null)) {
            T.$assignMove($this().Context.getObjCInterfaceType(Class));
          } else {
            TypeDecl /*P*/ Type = dyn_cast_TypeDecl(ND);
            if ((Type != null)) {
              T.$assignMove($this().Context.getTypeDeclType(Type));
              $this().DiagnoseUseOfDecl(Type, new SourceLocation(NameLoc));
            } else {
              return ObjCMessageKind.ObjCInstanceMessage;
            }
          }
        }
        
        //  We have a class message, and T is the type we're
        //  messaging. Build source-location information for it.
        TypeSourceInfo /*P*/ TSInfo = $this().Context.getTrivialTypeSourceInfo(new QualType(T), new SourceLocation(NameLoc));
        ReceiverType.$assignMove($this().CreateParsedType(new QualType(T), TSInfo));
        return ObjCMessageKind.ObjCClassMessage;
      }
    }
    {
      TypoCorrection Corrected = null;
      try {
        
        Corrected = $c$.clean($this().CorrectTypo(Result.getLookupNameInfo(), Result.getLookupKind(), S, (CXXScopeSpec /*P*/ )null, 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ObjCInterfaceOrSuperCCC($this().getCurMethodDecl()))))), 
            CorrectTypoKind.CTK_ErrorRecovery, (DeclContext /*P*/ )null, false, (/*const*/ ObjCObjectPointerType /*P*/ )null, false));
        if (Corrected.$bool()) {
          if (Corrected.isKeyword()) {
            // If we've found the keyword "super" (the only keyword that would be
            // returned by CorrectTypo), this is a send to super.
            $this().diagnoseTypo(Corrected, 
                $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_unknown_receiver_suggest)), Name)); $c$.clean();
            return ObjCMessageKind.ObjCSuperMessage;
          } else {
            ObjCInterfaceDecl /*P*/ Class = Corrected.getCorrectionDeclAs(ObjCInterfaceDecl.class);
            if ((Class != null)) {
              // If we found a declaration, correct when it refers to an Objective-C
              // class.
              $this().diagnoseTypo(Corrected, 
                  $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_unknown_receiver_suggest)), Name)); $c$.clean();
              QualType T = $this().Context.getObjCInterfaceType(Class);
              TypeSourceInfo /*P*/ TSInfo = $this().Context.getTrivialTypeSourceInfo(new QualType(T), new SourceLocation(NameLoc));
              ReceiverType.$assignMove($this().CreateParsedType(new QualType(T), TSInfo));
              return ObjCMessageKind.ObjCClassMessage;
            }
          }
        }
      } finally {
        if (Corrected != null) { Corrected.$destroy(); }
      }
    }
    
    // Fall back: let the parser try to parse it as an instance message.
    return ObjCMessageKind.ObjCInstanceMessage;
  } finally {
    if (Result != null) { Result.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnSuperMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2152,
 FQN="clang::Sema::ActOnSuperMessage", NM="_ZN5clang4Sema17ActOnSuperMessageEPNS_5ScopeENS_14SourceLocationENS_8SelectorES3_N4llvm8ArrayRefIS3_EES3_NS5_15MutableArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema17ActOnSuperMessageEPNS_5ScopeENS_14SourceLocationENS_8SelectorES3_N4llvm8ArrayRefIS3_EES3_NS5_15MutableArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnSuperMessage(Scope /*P*/ S, 
                 SourceLocation SuperLoc, 
                 Selector Sel, 
                 SourceLocation LBracLoc, 
                 ArrayRef<SourceLocation> SelectorLocs, 
                 SourceLocation RBracLoc, 
                 MutableArrayRef<Expr /*P*/ > Args) {
  // Determine whether we are inside a method or not.
  ObjCMethodDecl /*P*/ Method = $this().tryCaptureObjCSelf(new SourceLocation(SuperLoc));
  if (!(Method != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.err_invalid_receiver_to_message_super)));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  ObjCInterfaceDecl /*P*/ Class = Method.getClassInterface();
  if (!(Class != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.error_no_super_class_message)), 
          Method.getDeclName()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType SuperTy/*J*/= new QualType(Class.getSuperClassType(), 0);
  if (SuperTy.isNull()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The current class does not have a superclass.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.error_root_class_cannot_use_super)), 
          Class.getIdentifier()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // We are in a method whose class has a superclass, so 'super'
  // is acting as a keyword.
  if (Method.getSelector().$eq(/*NO_COPY*/Sel)) {
    $this().getCurFunction().ObjCShouldCallSuper = false;
  }
  if (Method.isInstanceMethod()) {
    // Since we are in an instance method, this is an instance
    // message to the superclass instance.
    SuperTy.$assignMove($this().Context.getObjCObjectPointerType(new QualType(SuperTy)));
    return $this().BuildInstanceMessage((Expr /*P*/ )null, new QualType(SuperTy), new SourceLocation(SuperLoc), 
        new Selector(Sel), /*Method=*/ (ObjCMethodDecl /*P*/ )null, 
        new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(SelectorLocs), new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(Args));
  }
  
  // Since we are in a class method, this is a class message to
  // the superclass.
  return $this().BuildClassMessage(/*ReceiverTypeInfo=*/ (TypeSourceInfo /*P*/ )null, 
      new QualType(SuperTy), 
      new SourceLocation(SuperLoc), new Selector(Sel), /*Method=*/ (ObjCMethodDecl /*P*/ )null, 
      new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(SelectorLocs), new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(Args));
}


/// \brief Build an Objective-C class message expression.
///
/// This routine takes care of both normal class messages and
/// class messages to the superclass.
///
/// \param ReceiverTypeInfo Type source information that describes the
/// receiver of this message. This may be NULL, in which case we are
/// sending to the superclass and \p SuperLoc must be a valid source
/// location.

/// \param ReceiverType The type of the object receiving the
/// message. When \p ReceiverTypeInfo is non-NULL, this is the same
/// type as that refers to. For a superclass send, this is the type of
/// the superclass.
///
/// \param SuperLoc The location of the "super" keyword in a
/// superclass message.
///
/// \param Sel The selector to which the message is being sent.
///
/// \param Method The method that this class message is invoking, if
/// already known.
///
/// \param LBracLoc The location of the opening square bracket ']'.
///
/// \param RBracLoc The location of the closing square bracket ']'.
///
/// \param ArgsIn The message arguments.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildClassMessage">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2330,
 FQN="clang::Sema::BuildClassMessage", NM="_ZN5clang4Sema17BuildClassMessageEPNS_14TypeSourceInfoENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclES4_N4llvm8ArrayRefIS4_EES4_NS8_15MutableArrayRefIPNS_4ExprEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema17BuildClassMessageEPNS_14TypeSourceInfoENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclES4_N4llvm8ArrayRefIS4_EES4_NS8_15MutableArrayRefIPNS_4ExprEEEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildClassMessage(TypeSourceInfo /*P*/ ReceiverTypeInfo, 
                 QualType ReceiverType, 
                 SourceLocation SuperLoc, 
                 Selector Sel, 
                 ObjCMethodDecl /*P*/ Method, 
                 SourceLocation LBracLoc, 
                 ArrayRef<SourceLocation> SelectorLocs, 
                 SourceLocation RBracLoc, 
                 MutableArrayRef<Expr /*P*/ > ArgsIn) {
  return BuildClassMessage(ReceiverTypeInfo, 
                 ReceiverType, 
                 SuperLoc, 
                 Sel, 
                 Method, 
                 LBracLoc, 
                 SelectorLocs, 
                 RBracLoc, 
                 ArgsIn, 
                 false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildClassMessage(TypeSourceInfo /*P*/ ReceiverTypeInfo, 
                 QualType ReceiverType, 
                 SourceLocation SuperLoc, 
                 Selector Sel, 
                 ObjCMethodDecl /*P*/ Method, 
                 SourceLocation LBracLoc, 
                 ArrayRef<SourceLocation> SelectorLocs, 
                 SourceLocation RBracLoc, 
                 MutableArrayRef<Expr /*P*/ > ArgsIn, 
                 boolean isImplicit/*= false*/) {
  SourceLocation Loc = SuperLoc.isValid() ? new SourceLocation(SuperLoc) : ReceiverTypeInfo.getTypeLoc().getSourceRange().getBegin();
  if (LBracLoc.isInvalid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_missing_open_square_message_send)), 
          FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/$LSQUARE))));
      LBracLoc.$assign(Loc);
    } finally {
      $c$.$destroy();
    }
  }
  SourceLocation SelLoc/*J*/= new SourceLocation();
  if (!SelectorLocs.empty() && SelectorLocs.front().isValid()) {
    SelLoc.$assign(SelectorLocs.front());
  } else {
    SelLoc.$assign(Loc);
  }
  if (ReceiverType.$arrow().isDependentType()) {
    // If the receiver type is dependent, we can't type-check anything
    // at this point. Build a dependent expression.
    /*uint*/int NumArgs = ArgsIn.size();
    type$ptr<Expr /*P*/ /*P*/> Args = $tryClone(ArgsIn.data());
    assert (SuperLoc.isInvalid()) : "Message to super with dependent type";
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ObjCMessageExpr.Create1($this().Context, new QualType(ReceiverType), ExprValueKind.VK_RValue, new SourceLocation(LBracLoc), ReceiverTypeInfo, new Selector(Sel), 
            new ArrayRef<SourceLocation>(SelectorLocs), /*Method=*/ (ObjCMethodDecl /*P*/ )null, makeArrayRef(Args, NumArgs), new SourceLocation(RBracLoc), 
            isImplicit));
  }
  
  // Find the class to which we are sending this message.
  ObjCInterfaceDecl /*P*/ Class = null;
  /*const*/ ObjCObjectType /*P*/ ClassType = ReceiverType.$arrow().getAs(ObjCObjectType.class);
  if (!(ClassType != null) || !((Class = ClassType.getInterface()) != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_invalid_receiver_class_message)), 
          ReceiverType));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  assert ((Class != null)) : "We don't know which class we're messaging?";
  // objc++ diagnoses during typename annotation.
  if (!$this().getLangOpts().CPlusPlus) {
    /*J:(void)*/$this().DiagnoseUseOfDecl(Class, new SourceLocation(SelLoc));
  }
  // Find the method we are messaging.
  if (!(Method != null)) {
    SourceRange TypeRange = SuperLoc.isValid() ? new SourceRange(/*NO_COPY*/SuperLoc) : ReceiverTypeInfo.getTypeLoc().getSourceRange();
    if ($this().RequireCompleteType$T(new SourceLocation(Loc), $this().Context.getObjCInterfaceType(Class), 
        ($this().getLangOpts().ObjCAutoRefCount ? diag.err_arc_receiver_forward_class : diag.warn_receiver_forward_class), 
        TypeRange)) {
      // A forward class used in messaging is treated as a 'Class'
      Method = $this().LookupFactoryMethodInGlobalPool(new Selector(Sel), 
          new SourceRange(/*NO_COPY*/LBracLoc, /*NO_COPY*/RBracLoc));
      if ((Method != null) && !$this().getLangOpts().ObjCAutoRefCount) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.note_method_sent_forward_class)), 
              Method.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!(Method != null)) {
      Method = Class.lookupClassMethod(new Selector(Sel));
    }
    
    // If we have an implementation in scope, check "private" methods.
    if (!(Method != null)) {
      Method = Class.lookupPrivateClassMethod(Sel);
    }
    if ((Method != null) && $this().DiagnoseUseOfDecl(Method, new SourceLocation(SelLoc))) {
      return ExprError();
    }
  }
  
  // Check the argument types and determine the result type.
  QualType ReturnType/*J*/= new QualType();
  type$ref<ExprValueKind> VK = create_type$ref(ExprValueKind.VK_RValue);
  
  /*uint*/int NumArgs = ArgsIn.size();
  type$ptr<Expr /*P*/ /*P*/> Args = $tryClone(ArgsIn.data());
  if ($this().CheckMessageArgumentTypes(new QualType(ReceiverType), new MutableArrayRef<Expr /*P*/ >(Args, NumArgs, true), 
      new Selector(Sel), new ArrayRef<SourceLocation>(SelectorLocs), 
      Method, true, 
      SuperLoc.isValid(), new SourceLocation(LBracLoc), new SourceLocation(RBracLoc), 
      new SourceRange(), 
      ReturnType, VK)) {
    return ExprError();
  }
  if ((Method != null) && !Method.getReturnType().$arrow().isVoidType()
     && $this().RequireCompleteType(new SourceLocation(LBracLoc), Method.getReturnType(), 
      diag.err_illegal_message_expr_incomplete_type)) {
    return ExprError();
  }
  
  // Warn about explicit call of +initialize on its own class. But not on 'super'.
  if ((Method != null) && Method.getMethodFamily() == ObjCMethodFamily.OMF_initialize) {
    if (!SuperLoc.isValid()) {
      /*const*/ ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(Method.getDeclContext());
      if (ID == Class) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_direct_initialize_call)));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.note_method_declared_at)), 
              Method.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      ObjCMethodDecl /*P*/ CurMeth = $this().getCurMethodDecl();
      if ((CurMeth != null)) {
        // [super initialize] is allowed only within an +initialize implementation
        if (CurMeth.getMethodFamily() != ObjCMethodFamily.OMF_initialize) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_direct_super_initialize_call)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.note_method_declared_at)), 
                Method.getDeclName()));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CurMeth.getLocation(), diag.note_method_declared_at)), 
                CurMeth.getDeclName()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  DiagnoseCStringFormatDirectiveInObjCAPI(/*Deref*/$this(), Method, new Selector(Sel), Args, NumArgs);
  
  // Construct the appropriate ObjCMessageExpr.
  ObjCMessageExpr /*P*/ Result;
  if (SuperLoc.isValid()) {
    Result = ObjCMessageExpr.Create($this().Context, new QualType(ReturnType), VK.$deref(), new SourceLocation(LBracLoc), 
        new SourceLocation(SuperLoc), /*IsInstanceSuper=*/ false, 
        new QualType(ReceiverType), new Selector(Sel), new ArrayRef<SourceLocation>(SelectorLocs), 
        Method, makeArrayRef(Args, NumArgs), 
        new SourceLocation(RBracLoc), isImplicit);
  } else {
    Result = ObjCMessageExpr.Create1($this().Context, new QualType(ReturnType), VK.$deref(), new SourceLocation(LBracLoc), 
        ReceiverTypeInfo, new Selector(Sel), new ArrayRef<SourceLocation>(SelectorLocs), 
        Method, makeArrayRef(Args, NumArgs), 
        new SourceLocation(RBracLoc), isImplicit);
    if (!isImplicit) {
      checkCocoaAPI(/*Deref*/$this(), Result);
    }
  }
  return $this().MaybeBindToTemporary(Result);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildClassMessageImplicit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2203,
 FQN="clang::Sema::BuildClassMessageImplicit", NM="_ZN5clang4Sema25BuildClassMessageImplicitENS_8QualTypeEbNS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclEN4llvm15MutableArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema25BuildClassMessageImplicitENS_8QualTypeEbNS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclEN4llvm15MutableArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildClassMessageImplicit(QualType ReceiverType, 
                         boolean isSuperReceiver, 
                         SourceLocation Loc, 
                         Selector Sel, 
                         ObjCMethodDecl /*P*/ Method, 
                         MutableArrayRef<Expr /*P*/ > Args) {
  TypeSourceInfo /*P*/ receiverTypeInfo = null;
  if (!ReceiverType.isNull()) {
    receiverTypeInfo = $this().Context.getTrivialTypeSourceInfo(new QualType(ReceiverType));
  }
  
  return $this().BuildClassMessage(receiverTypeInfo, new QualType(ReceiverType), 
      /*SuperLoc=*/ isSuperReceiver ? new SourceLocation(Loc) : new SourceLocation(), 
      new Selector(Sel), Method, new SourceLocation(Loc), new ArrayRef<SourceLocation>(Loc, false), new SourceLocation(Loc), new MutableArrayRef<Expr /*P*/ >(Args), 
      /*isImplicit=*/ true);
}


// ActOnClassMessage - used for both unary and keyword messages.
// ArgExprs is optional - if it is present, the number of expressions
// is obtained from Sel.getNumArgs().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnClassMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2471,
 FQN="clang::Sema::ActOnClassMessage", NM="_ZN5clang4Sema17ActOnClassMessageEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEENS_8SelectorENS_14SourceLocationEN4llvm8ArrayRefIS7_EES7_NS8_15MutableArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema17ActOnClassMessageEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEENS_8SelectorENS_14SourceLocationEN4llvm8ArrayRefIS7_EES7_NS8_15MutableArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnClassMessage(Scope /*P*/ S, 
                 OpaquePtr<QualType> Receiver, 
                 Selector Sel, 
                 SourceLocation LBracLoc, 
                 ArrayRef<SourceLocation> SelectorLocs, 
                 SourceLocation RBracLoc, 
                 MutableArrayRef<Expr /*P*/ > Args) {
  type$ptr<TypeSourceInfo /*P*/ > ReceiverTypeInfo = create_type$null$ptr();
  QualType ReceiverType = GetTypeFromParser(new OpaquePtr<QualType>(Receiver), $AddrOf(ReceiverTypeInfo));
  if (ReceiverType.isNull()) {
    return ExprError();
  }
  if (!(ReceiverTypeInfo.$star() != null)) {
    ReceiverTypeInfo.$set($this().Context.getTrivialTypeSourceInfo(new QualType(ReceiverType), new SourceLocation(LBracLoc)));
  }
  
  return $this().BuildClassMessage(ReceiverTypeInfo.$star(), new QualType(ReceiverType), 
      /*SuperLoc=*/ new SourceLocation(), new Selector(Sel), 
      /*Method=*/ (ObjCMethodDecl /*P*/ )null, new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(SelectorLocs), new SourceLocation(RBracLoc), 
      new MutableArrayRef<Expr /*P*/ >(Args));
}


/// \brief Build an Objective-C instance message expression.
///
/// This routine takes care of both normal instance messages and
/// instance messages to the superclass instance.
///
/// \param Receiver The expression that computes the object that will
/// receive this message. This may be empty, in which case we are
/// sending to the superclass instance and \p SuperLoc must be a valid
/// source location.
///
/// \param ReceiverType The (static) type of the object receiving the
/// message. When a \p Receiver expression is provided, this is the
/// same type as that expression. For a superclass instance send, this
/// is a pointer to the type of the superclass.
///
/// \param SuperLoc The location of the "super" keyword in a
/// superclass instance message.
///
/// \param Sel The selector to which the message is being sent.
///
/// \param Method The method that this instance message is invoking, if
/// already known.
///
/// \param LBracLoc The location of the opening square bracket ']'.
///
/// \param RBracLoc The location of the closing square bracket ']'.
///
/// \param ArgsIn The message arguments.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildInstanceMessage">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2532,
 FQN="clang::Sema::BuildInstanceMessage", NM="_ZN5clang4Sema20BuildInstanceMessageEPNS_4ExprENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclES4_N4llvm8ArrayRefIS4_EES4_NS8_15MutableArrayRefIS2_EEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema20BuildInstanceMessageEPNS_4ExprENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclES4_N4llvm8ArrayRefIS4_EES4_NS8_15MutableArrayRefIS2_EEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildInstanceMessage(Expr /*P*/ Receiver, 
                    QualType ReceiverType, 
                    SourceLocation SuperLoc, 
                    Selector Sel, 
                    ObjCMethodDecl /*P*/ Method, 
                    SourceLocation LBracLoc, 
                    ArrayRef<SourceLocation> SelectorLocs, 
                    SourceLocation RBracLoc, 
                    MutableArrayRef<Expr /*P*/ > ArgsIn) {
  return BuildInstanceMessage(Receiver, 
                    ReceiverType, 
                    SuperLoc, 
                    Sel, 
                    Method, 
                    LBracLoc, 
                    SelectorLocs, 
                    RBracLoc, 
                    ArgsIn, 
                    false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildInstanceMessage(Expr /*P*/ Receiver, 
                    QualType ReceiverType, 
                    SourceLocation SuperLoc, 
                    Selector Sel, 
                    ObjCMethodDecl /*P*/ Method, 
                    SourceLocation LBracLoc, 
                    ArrayRef<SourceLocation> SelectorLocs, 
                    SourceLocation RBracLoc, 
                    MutableArrayRef<Expr /*P*/ > ArgsIn, 
                    boolean isImplicit/*= false*/) {
  // The location of the receiver.
  SourceLocation Loc = SuperLoc.isValid() ? new SourceLocation(SuperLoc) : Receiver.getLocStart();
  SourceRange RecRange = SuperLoc.isValid() ? new SourceRange(/*NO_COPY*/SuperLoc) : Receiver.getSourceRange();
  SourceLocation SelLoc/*J*/= new SourceLocation();
  if (!SelectorLocs.empty() && SelectorLocs.front().isValid()) {
    SelLoc.$assign(SelectorLocs.front());
  } else {
    SelLoc.$assign(Loc);
  }
  if (LBracLoc.isInvalid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_missing_open_square_message_send)), 
          FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/$LSQUARE))));
      LBracLoc.$assign(Loc);
    } finally {
      $c$.$destroy();
    }
  }
  
  // If we have a receiver expression, perform appropriate promotions
  // and determine receiver type.
  if ((Receiver != null)) {
    if (Receiver.hasPlaceholderType()) {
      ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($eq_QualType$C(Receiver.getType(), $this().Context.UnknownAnyTy.$QualType())) {
        Result.$assignMove($this().forceUnknownAnyToType(Receiver, $this().Context.getObjCIdType()));
      } else {
        Result.$assignMove($this().CheckPlaceholderExpr(Receiver));
      }
      if (Result.isInvalid()) {
        return ExprError();
      }
      Receiver = Result.get();
    }
    if (Receiver.isTypeDependent()) {
      // If the receiver is type-dependent, we can't type-check anything
      // at this point. Build a dependent expression.
      /*uint*/int NumArgs = ArgsIn.size();
      type$ptr<Expr /*P*/ /*P*/> Args = $tryClone(ArgsIn.data());
      assert (SuperLoc.isInvalid()) : "Message to super with dependent type";
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ObjCMessageExpr.Create2($this().Context, $this().Context.DependentTy.$QualType(), ExprValueKind.VK_RValue, new SourceLocation(LBracLoc), Receiver, new Selector(Sel), 
              new ArrayRef<SourceLocation>(SelectorLocs), /*Method=*/ (ObjCMethodDecl /*P*/ )null, makeArrayRef(Args, NumArgs), 
              new SourceLocation(RBracLoc), isImplicit));
    }
    
    // If necessary, apply function/array conversion to the receiver.
    // C99 6.7.5.3p[7,8].
    ActionResultTTrue<Expr /*P*/ > Result = $this().DefaultFunctionArrayLvalueConversion(Receiver);
    if (Result.isInvalid()) {
      return ExprError();
    }
    Receiver = Result.get();
    ReceiverType.$assignMove(Receiver.getType());
    
    // If the receiver is an ObjC pointer, a block pointer, or an
    // __attribute__((NSObject)) pointer, we don't need to do any
    // special conversion in order to look up a receiver.
    if (ReceiverType.$arrow().isObjCRetainableType()) {
      // do nothing
    } else if (!$this().getLangOpts().ObjCAutoRefCount
       && !$this().Context.getObjCIdType().isNull()
       && (ReceiverType.$arrow().isPointerType()
       || ReceiverType.$arrow().isIntegerType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Implicitly convert integers and pointers to 'id' but emit a warning.
        // But not in ARC.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_bad_receiver_type)), 
                ReceiverType), 
            Receiver.getSourceRange()));
        if (ReceiverType.$arrow().isPointerType()) {
          Receiver = $this().ImpCastExprToType(Receiver, $this().Context.getObjCIdType(), 
              CastKind.CK_CPointerToObjCPointerCast).get();
        } else {
          // TODO: specialized warning on null receivers?
          boolean IsNull = (Receiver.isNullPointerConstant($this().Context, 
              Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0);
          CastKind Kind = IsNull ? CastKind.CK_NullToPointer : CastKind.CK_IntegralToPointer;
          Receiver = $this().ImpCastExprToType(Receiver, $this().Context.getObjCIdType(), 
              Kind).get();
        }
        ReceiverType.$assignMove(Receiver.getType());
      } finally {
        $c$.$destroy();
      }
    } else if ($this().getLangOpts().CPlusPlus) {
      // The receiver must be a complete type.
      if ($this().RequireCompleteType(new SourceLocation(Loc), Receiver.getType(), 
          diag.err_incomplete_receiver_type)) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > result = $this().PerformContextuallyConvertToObjCPointer(Receiver);
      if (result.isUsable()) {
        Receiver = result.get();
        ReceiverType.$assignMove(Receiver.getType());
      }
    }
  }
  
  // There's a somewhat weird interaction here where we assume that we
  // won't actually have a method unless we also don't need to do some
  // of the more detailed type-checking on the receiver.
  if (!(Method != null)) {
    // Handle messages to id and __kindof types (where we use the
    // global method pool).
    type$ref</*const*/ ObjCObjectType /*P*/ > typeBound = create_type$null$ref(null);
    boolean receiverIsIdLike = ReceiverType.$arrow().isObjCIdOrObjectKindOfType($this().Context, 
        typeBound);
    if (receiverIsIdLike || ReceiverType.$arrow().isBlockPointerType()
       || ((Receiver != null) && $this().Context.isObjCNSObjectType(Receiver.getType()))) {
      SmallVector<ObjCMethodDecl /*P*/ > Methods/*J*/= new SmallVector<ObjCMethodDecl /*P*/ >(4, (ObjCMethodDecl /*P*/ )null);
      // If we have a type bound, further filter the methods.
      $this().CollectMultipleMethodsInGlobalPool(new Selector(Sel), Methods, true/*InstanceFirst*/, 
          true/*CheckTheOther*/, typeBound.$deref());
      if (!Methods.empty()) {
        // We chose the first method as the initial condidate, then try to
        // select a better one.
        Method = Methods.$at(0);
        {
          
          ObjCMethodDecl /*P*/ BestMethod = $this().SelectBestMethod(new Selector(Sel), new MutableArrayRef<Expr /*P*/ >(ArgsIn), Method.isInstanceMethod(), Methods);
          if ((BestMethod != null)) {
            Method = BestMethod;
          }
        }
        if (!$this().AreMultipleMethodsInGlobalPool(new Selector(Sel), Method, 
            new SourceRange(/*NO_COPY*/LBracLoc, /*NO_COPY*/RBracLoc), 
            receiverIsIdLike, Methods)) {
          $this().DiagnoseUseOfDecl(Method, new SourceLocation(SelLoc));
        }
      }
    } else if (ReceiverType.$arrow().isObjCClassOrClassKindOfType()
       || ReceiverType.$arrow().isObjCQualifiedClassType()) {
      // Handle messages to Class.
      // We allow sending a message to a qualified Class ("Class<foo>"), which
      // is ok as long as one of the protocols implements the selector (if not,
      // warn).
      if (!ReceiverType.$arrow().isObjCClassOrClassKindOfType()) {
        /*const*/ ObjCObjectPointerType /*P*/ QClassTy = ReceiverType.$arrow().getAsObjCQualifiedClassType();
        // Search protocols for class methods.
        Method = $this().LookupMethodInQualifiedType(new Selector(Sel), QClassTy, false);
        if (!(Method != null)) {
          Method = $this().LookupMethodInQualifiedType(new Selector(Sel), QClassTy, true);
          // warn if instance method found for a Class message.
          if ((Method != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), diag.warn_instance_method_on_class_found)), 
                      Method.getSelector()), Sel));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.note_method_declared_at)), 
                  Method.getDeclName()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      } else {
        {
          ObjCMethodDecl /*P*/ CurMeth = $this().getCurMethodDecl();
          if ((CurMeth != null)) {
            {
              ObjCInterfaceDecl /*P*/ ClassDecl = CurMeth.getClassInterface();
              if ((ClassDecl != null)) {
                // First check the public methods in the class interface.
                Method = ClassDecl.lookupClassMethod(new Selector(Sel));
                if (!(Method != null)) {
                  Method = ClassDecl.lookupPrivateClassMethod(Sel);
                }
              }
            }
            if ((Method != null) && $this().DiagnoseUseOfDecl(Method, new SourceLocation(SelLoc))) {
              return ExprError();
            }
          }
        }
        if (!(Method != null)) {
          // If not messaging 'self', look for any factory method named 'Sel'.
          if (!(Receiver != null) || !$this().isSelfExpr(Receiver)) {
            // If no class (factory) method was found, check if an _instance_
            // method of the same name exists in the root class only.
            SmallVector<ObjCMethodDecl /*P*/ > Methods/*J*/= new SmallVector<ObjCMethodDecl /*P*/ >(4, (ObjCMethodDecl /*P*/ )null);
            $this().CollectMultipleMethodsInGlobalPool(new Selector(Sel), Methods, 
                false/*InstanceFirst*/, 
                true/*CheckTheOther*/);
            if (!Methods.empty()) {
              // We chose the first method as the initial condidate, then try
              // to select a better one.
              Method = Methods.$at(0);
              
              // If we find an instance method, emit waring.
              if (Method.isInstanceMethod()) {
                {
                  /*const*/ ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(Method.getDeclContext());
                  if ((ID != null)) {
                    if ((ID.getSuperClass() != null)) {
                      JavaCleaner $c$ = $createJavaCleaner();
                      try {
                        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), diag.warn_root_inst_method_not_found)), 
                                Sel), new SourceRange(/*NO_COPY*/LBracLoc, /*NO_COPY*/RBracLoc)));
                      } finally {
                        $c$.$destroy();
                      }
                    }
                  }
                }
              }
              {
                
                ObjCMethodDecl /*P*/ BestMethod = $this().SelectBestMethod(new Selector(Sel), new MutableArrayRef<Expr /*P*/ >(ArgsIn), Method.isInstanceMethod(), 
                    Methods);
                if ((BestMethod != null)) {
                  Method = BestMethod;
                }
              }
            }
          }
        }
      }
    } else {
      ObjCInterfaceDecl /*P*/ ClassDecl = null;
      {
        
        // We allow sending a message to a qualified ID ("id<foo>"), which is ok as
        // long as one of the protocols implements the selector (if not, warn).
        // And as long as message is not deprecated/unavailable (warn if it is).
        /*const*/ ObjCObjectPointerType /*P*/ QIdTy = ReceiverType.$arrow().getAsObjCQualifiedIdType();
        if ((QIdTy != null)) {
          // Search protocols for instance methods.
          Method = $this().LookupMethodInQualifiedType(new Selector(Sel), QIdTy, true);
          if (!(Method != null)) {
            Method = $this().LookupMethodInQualifiedType(new Selector(Sel), QIdTy, false);
          }
          if ((Method != null) && $this().DiagnoseUseOfDecl(Method, new SourceLocation(SelLoc))) {
            return ExprError();
          }
        } else {
          /*const*/ ObjCObjectPointerType /*P*/ OCIType = ReceiverType.$arrow().getAsObjCInterfacePointerType();
          if ((OCIType != null)) {
            // We allow sending a message to a pointer to an interface (an object).
            ClassDecl = OCIType.getInterfaceDecl();
            
            // Try to complete the type. Under ARC, this is a hard error from which
            // we don't try to recover.
            // FIXME: In the non-ARC case, this will still be a hard error if the
            // definition is found in a module that's not visible.
            /*const*/ ObjCInterfaceDecl /*P*/ forwardClass = null;
            if ($this().RequireCompleteType$T(new SourceLocation(Loc), OCIType.getPointeeType(), 
                $this().getLangOpts().ObjCAutoRefCount ? diag.err_arc_receiver_forward_instance : diag.warn_receiver_forward_instance, 
                (Receiver != null) ? Receiver.getSourceRange() : new SourceRange(/*NO_COPY*/SuperLoc))) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if ($this().getLangOpts().ObjCAutoRefCount) {
                  return ExprError();
                }
                
                forwardClass = OCIType.getInterfaceDecl();
                $c$.clean($c$.track($this().Diag((Receiver != null) ? Receiver.getLocStart() : new SourceLocation(SuperLoc), diag.note_receiver_is_id)));
                Method = null;
              } finally {
                $c$.$destroy();
              }
            } else {
              Method = ClassDecl.lookupInstanceMethod(new Selector(Sel));
            }
            if (!(Method != null)) {
              // Search protocol qualifiers.
              Method = $this().LookupMethodInQualifiedType(new Selector(Sel), OCIType, true);
            }
            if (!(Method != null)) {
              // If we have implementations in scope, check "private" methods.
              Method = ClassDecl.lookupPrivateMethod(Sel);
              if (!(Method != null) && $this().getLangOpts().ObjCAutoRefCount) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), diag.err_arc_may_not_respond)), 
                                  OCIType.getPointeeType()), Sel), RecRange), 
                      new SourceRange(/*NO_COPY*/SelectorLocs.front(), /*NO_COPY*/SelectorLocs.back())));
                  return ExprError();
                } finally {
                  $c$.$destroy();
                }
              }
              if (!(Method != null) && (!(Receiver != null) || !$this().isSelfExpr(Receiver))) {
                // If we still haven't found a method, look in the global pool. This
                // behavior isn't very desirable, however we need it for GCC
                // compatibility. FIXME: should we deviate??
                if (OCIType.qual_empty()) {
                  SmallVector<ObjCMethodDecl /*P*/ > Methods/*J*/= new SmallVector<ObjCMethodDecl /*P*/ >(4, (ObjCMethodDecl /*P*/ )null);
                  $this().CollectMultipleMethodsInGlobalPool(new Selector(Sel), Methods, 
                      true/*InstanceFirst*/, 
                      false/*CheckTheOther*/);
                  if (!Methods.empty()) {
                    // We chose the first method as the initial condidate, then try
                    // to select a better one.
                    Method = Methods.$at(0);
                    {
                      
                      ObjCMethodDecl /*P*/ BestMethod = $this().SelectBestMethod(new Selector(Sel), new MutableArrayRef<Expr /*P*/ >(ArgsIn), Method.isInstanceMethod(), 
                          Methods);
                      if ((BestMethod != null)) {
                        Method = BestMethod;
                      }
                    }
                    
                    $this().AreMultipleMethodsInGlobalPool(new Selector(Sel), Method, 
                        new SourceRange(/*NO_COPY*/LBracLoc, /*NO_COPY*/RBracLoc), 
                        true/*receiverIdOrClass*/, 
                        Methods);
                  }
                  if ((Method != null) && !(forwardClass != null)) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), diag.warn_maynot_respond)), 
                                  OCIType.getInterfaceDecl().getIdentifier()), 
                              Sel), RecRange));
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
              }
            }
            if ((Method != null) && $this().DiagnoseUseOfDecl(Method, new SourceLocation(SelLoc), forwardClass)) {
              return ExprError();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Reject other random receiver types (e.g. structs).
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_bad_receiver_type)), 
                      ReceiverType), Receiver.getSourceRange()));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  
  FunctionScopeInfo /*P*/ DIFunctionScopeInfo = ((Method != null) && Method.getMethodFamily() == ObjCMethodFamily.OMF_init) ? $this().getEnclosingFunction() : null;
  if ((DIFunctionScopeInfo != null)
     && DIFunctionScopeInfo.ObjCIsDesignatedInit
     && (SuperLoc.isValid() || $this().isSelfExpr(Receiver))) {
    boolean isDesignatedInitChain = false;
    if (SuperLoc.isValid()) {
      {
        /*const*/ ObjCObjectPointerType /*P*/ OCIType = ReceiverType.$arrow().getAsObjCInterfacePointerType();
        if ((OCIType != null)) {
          {
            /*const*/ ObjCInterfaceDecl /*P*/ ID = OCIType.getInterfaceDecl();
            if ((ID != null)) {
              // Either we know this is a designated initializer or we
              // conservatively assume it because we don't know for sure.
              if (!ID.declaresOrInheritsDesignatedInitializers()
                 || ID.isDesignatedInitializer(new Selector(Sel))) {
                isDesignatedInitChain = true;
                DIFunctionScopeInfo.ObjCWarnForNoDesignatedInitChain = false;
              }
            }
          }
        }
      }
    }
    if (!isDesignatedInitChain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        type$ptr</*const*/ ObjCMethodDecl /*P*/ > InitMethod = create_type$null$ptr(null);
        boolean isDesignated = $this().getCurMethodDecl().isDesignatedInitializerForTheInterface($AddrOf(InitMethod));
        assert (isDesignated && (InitMethod.$star() != null));
        ///*J:(void)*/isDesignated;
        $c$.clean($c$.track($this().Diag(new SourceLocation(SelLoc), SuperLoc.isValid() ? diag.warn_objc_designated_init_non_designated_init_call : diag.warn_objc_designated_init_non_super_designated_init_call)));
        $c$.clean($c$.track($this().Diag(InitMethod.$star().getLocation(), 
            diag.note_objc_designated_init_marked_here)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ((DIFunctionScopeInfo != null)
     && DIFunctionScopeInfo.ObjCIsSecondaryInit
     && (SuperLoc.isValid() || $this().isSelfExpr(Receiver))) {
    if (SuperLoc.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(SelLoc), diag.warn_objc_secondary_init_super_init_call)));
      } finally {
        $c$.$destroy();
      }
    } else {
      DIFunctionScopeInfo.ObjCWarnForNoInitDelegation = false;
    }
  }
  
  // Check the message arguments.
  /*uint*/int NumArgs = ArgsIn.size();
  type$ptr<Expr /*P*/ /*P*/> Args = $tryClone(ArgsIn.data());
  QualType ReturnType/*J*/= new QualType();
  type$ref<ExprValueKind> VK = create_type$ref(ExprValueKind.VK_RValue);
  boolean ClassMessage = (ReceiverType.$arrow().isObjCClassType()
     || ReceiverType.$arrow().isObjCQualifiedClassType());
  if ($this().CheckMessageArgumentTypes(new QualType(ReceiverType), new MutableArrayRef<Expr /*P*/ >(Args, NumArgs, true), 
      new Selector(Sel), new ArrayRef<SourceLocation>(SelectorLocs), Method, 
      ClassMessage, SuperLoc.isValid(), 
      new SourceLocation(LBracLoc), new SourceLocation(RBracLoc), new SourceRange(RecRange), ReturnType, VK)) {
    return ExprError();
  }
  if ((Method != null) && !Method.getReturnType().$arrow().isVoidType()
     && $this().RequireCompleteType(new SourceLocation(LBracLoc), Method.getReturnType(), 
      diag.err_illegal_message_expr_incomplete_type)) {
    return ExprError();
  }
  
  // In ARC, forbid the user from sending messages to 
  // retain/release/autorelease/dealloc/retainCount explicitly.
  if ($this().getLangOpts().ObjCAutoRefCount) {
    ObjCMethodFamily family = ((Method != null) ? Method.getMethodFamily() : Sel.getMethodFamily());
    switch (family) {
     case OMF_init:
      if ((Method != null)) {
        $this().checkInitMethod(Method, new QualType(ReceiverType));
      }
     case OMF_None:
     case OMF_alloc:
     case OMF_copy:
     case OMF_finalize:
     case OMF_mutableCopy:
     case OMF_new:
     case OMF_self:
     case OMF_initialize:
      break;
     case OMF_dealloc:
     case OMF_retain:
     case OMF_release:
     case OMF_autorelease:
     case OMF_retainCount:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), diag.err_arc_illegal_explicit_message)), 
                  Sel), RecRange));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OMF_performSelector:
      if ((Method != null) && $greatereq_uint(NumArgs, 1)) {
        {
          ObjCSelectorExpr /*P*/ SelExp = dyn_cast_ObjCSelectorExpr(Args.$at(0));
          if ((SelExp != null)) {
            Selector ArgSel = SelExp.getSelector();
            ObjCMethodDecl /*P*/ SelMethod = $this().LookupInstanceMethodInGlobalPool(new Selector(ArgSel), 
                SelExp.getSourceRange());
            if (!(SelMethod != null)) {
              SelMethod
                 = $this().LookupFactoryMethodInGlobalPool(new Selector(ArgSel), 
                  SelExp.getSourceRange());
            }
            if ((SelMethod != null)) {
              ObjCMethodFamily SelFamily = SelMethod.getMethodFamily();
              switch (SelFamily) {
               case OMF_alloc:
               case OMF_copy:
               case OMF_mutableCopy:
               case OMF_new:
               case OMF_self:
               case OMF_init:
                // Issue error, unless ns_returns_not_retained.
                if (!SelMethod.hasAttr(NSReturnsNotRetainedAttr.class)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    // selector names a +1 method 
                    $c$.clean($c$.track($this().Diag(new SourceLocation(SelLoc), 
                        diag.err_arc_perform_selector_retains)));
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SelMethod.getLocation(), diag.note_method_declared_at)), 
                        SelMethod.getDeclName()));
                  } finally {
                    $c$.$destroy();
                  }
                }
                break;
               default:
                // +0 call. OK. unless ns_returns_retained.
                if (SelMethod.hasAttr(NSReturnsRetainedAttr.class)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    // selector names a +1 method
                    $c$.clean($c$.track($this().Diag(new SourceLocation(SelLoc), 
                        diag.err_arc_perform_selector_retains)));
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SelMethod.getLocation(), diag.note_method_declared_at)), 
                        SelMethod.getDeclName()));
                  } finally {
                    $c$.$destroy();
                  }
                }
                break;
              }
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // error (may leak).
              $c$.clean($c$.track($this().Diag(new SourceLocation(SelLoc), diag.warn_arc_perform_selector_leaks)));
              $c$.clean($c$.track($this().Diag(Args.$at(0).getExprLoc(), diag.note_used_here)));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      break;
    }
  }
  
  DiagnoseCStringFormatDirectiveInObjCAPI(/*Deref*/$this(), Method, new Selector(Sel), Args, NumArgs);
  
  // Construct the appropriate ObjCMessageExpr instance.
  ObjCMessageExpr /*P*/ Result;
  if (SuperLoc.isValid()) {
    Result = ObjCMessageExpr.Create($this().Context, new QualType(ReturnType), VK.$deref(), new SourceLocation(LBracLoc), 
        new SourceLocation(SuperLoc), /*IsInstanceSuper=*/ true, 
        new QualType(ReceiverType), new Selector(Sel), new ArrayRef<SourceLocation>(SelectorLocs), Method, 
        makeArrayRef(Args, NumArgs), new SourceLocation(RBracLoc), 
        isImplicit);
  } else {
    Result = ObjCMessageExpr.Create2($this().Context, new QualType(ReturnType), VK.$deref(), new SourceLocation(LBracLoc), 
        Receiver, new Selector(Sel), new ArrayRef<SourceLocation>(SelectorLocs), Method, 
        makeArrayRef(Args, NumArgs), new SourceLocation(RBracLoc), 
        isImplicit);
    if (!isImplicit) {
      checkCocoaAPI(/*Deref*/$this(), Result);
    }
  }
  if ($this().getLangOpts().ObjCAutoRefCount) {
    // In ARC, annotate delegate init calls.
    if (Result.getMethodFamily() == ObjCMethodFamily.OMF_init
       && (SuperLoc.isValid() || $this().isSelfExpr(Receiver))) {
      // Only consider init calls *directly* in init implementations,
      // not within blocks.
      ObjCMethodDecl /*P*/ method = dyn_cast_ObjCMethodDecl($this().CurContext);
      if ((method != null) && method.getMethodFamily() == ObjCMethodFamily.OMF_init) {
        // The implicit assignment to self means we also don't want to
        // consume the result.
        Result.setDelegateInitCall(true);
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Result);
      }
    }
    
    // In ARC, check for message sends which are likely to introduce
    // retain cycles.
    $this().checkRetainCycles(Result);
    if (!isImplicit && (Method != null)) {
      {
        /*const*/ ObjCPropertyDecl /*P*/ Prop = Method.findPropertyDecl();
        if ((Prop != null)) {
          boolean IsWeak = ((Prop.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0);
          if (!IsWeak && Sel.isUnarySelector()) {
            IsWeak = ((ReturnType.getObjCLifetime().getValue() & Qualifiers.ObjCLifetime.OCL_Weak.getValue()) != 0);
          }
          if (IsWeak
             && !$this().Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, /*NO_COPY*/LBracLoc)) {
            $this().getCurFunction().recordUseOfWeak(Result, Prop);
          }
        }
      }
    }
  }
  
  $this().CheckObjCCircularContainer(Result);
  
  return $this().MaybeBindToTemporary(Result);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildInstanceMessageImplicit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 2492,
 FQN="clang::Sema::BuildInstanceMessageImplicit", NM="_ZN5clang4Sema28BuildInstanceMessageImplicitEPNS_4ExprENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclEN4llvm15MutableArrayRefIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema28BuildInstanceMessageImplicitEPNS_4ExprENS_8QualTypeENS_14SourceLocationENS_8SelectorEPNS_14ObjCMethodDeclEN4llvm15MutableArrayRefIS2_EE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildInstanceMessageImplicit(Expr /*P*/ Receiver, 
                            QualType ReceiverType, 
                            SourceLocation Loc, 
                            Selector Sel, 
                            ObjCMethodDecl /*P*/ Method, 
                            MutableArrayRef<Expr /*P*/ > Args) {
  return $this().BuildInstanceMessage(Receiver, new QualType(ReceiverType), 
      /*SuperLoc=*/ !(Receiver != null) ? new SourceLocation(Loc) : new SourceLocation(), 
      new Selector(Sel), Method, new SourceLocation(Loc), new ArrayRef<SourceLocation>(Loc, false), new SourceLocation(Loc), new MutableArrayRef<Expr /*P*/ >(Args), 
      /*isImplicit=*/ true);
}


// ActOnInstanceMessage - used for both unary and keyword messages.
// ArgExprs is optional - if it is present, the number of expressions
// is obtained from Sel.getNumArgs().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnInstanceMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3038,
 FQN="clang::Sema::ActOnInstanceMessage", NM="_ZN5clang4Sema20ActOnInstanceMessageEPNS_5ScopeEPNS_4ExprENS_8SelectorENS_14SourceLocationEN4llvm8ArrayRefIS6_EES6_NS7_15MutableArrayRefIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema20ActOnInstanceMessageEPNS_5ScopeEPNS_4ExprENS_8SelectorENS_14SourceLocationEN4llvm8ArrayRefIS6_EES6_NS7_15MutableArrayRefIS4_EE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnInstanceMessage(Scope /*P*/ S, 
                    Expr /*P*/ Receiver, 
                    Selector Sel, 
                    SourceLocation LBracLoc, 
                    ArrayRef<SourceLocation> SelectorLocs, 
                    SourceLocation RBracLoc, 
                    MutableArrayRef<Expr /*P*/ > Args) {
  if (!(Receiver != null)) {
    return ExprError();
  }
  
  // A ParenListExpr can show up while doing error recovery with invalid code.
  if (isa_ParenListExpr(Receiver)) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().MaybeConvertParenListExprToParenExpr(S, Receiver);
    if (Result.isInvalid()) {
      return ExprError();
    }
    Receiver = Result.get();
  }
  if ($this().RespondsToSelectorSel.isNull()) {
    IdentifierInfo /*P*/ SelectorId = $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"respondsToSelector")));
    $this().RespondsToSelectorSel.$assignMove($this().Context.Selectors.getUnarySelector(SelectorId));
  }
  if (Sel.$eq(/*NO_COPY*/$this().RespondsToSelectorSel)) {
    RemoveSelectorFromWarningCache(/*Deref*/$this(), Args.$at(0));
  }
  
  return $this().BuildInstanceMessage(Receiver, Receiver.getType(), 
      /*SuperLoc=*/ new SourceLocation(), new Selector(Sel), 
      /*Method=*/ (ObjCMethodDecl /*P*/ )null, new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(SelectorLocs), 
      new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(Args));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCBridgedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 4227,
 FQN="clang::Sema::BuildObjCBridgedCast", NM="_ZN5clang4Sema20BuildObjCBridgedCastENS_14SourceLocationENS_18ObjCBridgeCastKindES1_PNS_14TypeSourceInfoEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema20BuildObjCBridgedCastENS_14SourceLocationENS_18ObjCBridgeCastKindES1_PNS_14TypeSourceInfoEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildObjCBridgedCast(SourceLocation LParenLoc, 
                    ObjCBridgeCastKind Kind, 
                    SourceLocation BridgeKeywordLoc, 
                    TypeSourceInfo /*P*/ TSInfo, 
                    Expr /*P*/ SubExpr) {
  ActionResultTTrue<Expr /*P*/ > SubResult = $this().UsualUnaryConversions(SubExpr);
  if (SubResult.isInvalid()) {
    return ExprError();
  }
  SubExpr = SubResult.get();
  
  QualType T = TSInfo.getType();
  QualType FromType = SubExpr.getType();
  
  CastKind CK;
  
  boolean MustConsume = false;
  if (T.$arrow().isDependentType() || SubExpr.isTypeDependent()) {
    // Okay: we'll build a dependent expression type.
    CK = CastKind.CK_Dependent;
  } else if (T.$arrow().isObjCARCBridgableType() && FromType.$arrow().isCARCBridgableType()) {
    // Casting CF -> id
    CK = (T.$arrow().isBlockPointerType() ? CastKind.CK_AnyPointerToBlockPointerCast : CastKind.CK_CPointerToObjCPointerCast);
    switch (Kind) {
     case OBC_Bridge:
      break;
     case OBC_BridgeRetained:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          boolean br = $this().isKnownName(new StringRef(/*KEEP_STR*/"CFBridgingRelease"));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BridgeKeywordLoc), diag.err_arc_bridge_cast_wrong_kind)), 
                                  2), 
                              FromType), 
                          (T.$arrow().isBlockPointerType() ? 1 : 0)), 
                      T), 
                  SubExpr.getSourceRange()), 
              Kind));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BridgeKeywordLoc), diag.note_arc_bridge)), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/BridgeKeywordLoc), new StringRef(/*KEEP_STR*/$__bridge))));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BridgeKeywordLoc), diag.note_arc_bridge_transfer)), 
                      FromType), br), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/BridgeKeywordLoc), 
                  new StringRef(br ? $("CFBridgingRelease ") : $("__bridge_transfer ")))));
          
          Kind = ObjCBridgeCastKind.OBC_Bridge;
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OBC_BridgeTransfer:
      // We must consume the Objective-C object produced by the cast.
      MustConsume = true;
      break;
    }
  } else if (T.$arrow().isCARCBridgableType() && FromType.$arrow().isObjCARCBridgableType()) {
    // Okay: id -> CF
    CK = CastKind.CK_BitCast;
    switch (Kind) {
     case OBC_Bridge:
      // Reclaiming a value that's going to be __bridge-casted to CF
      // is very dangerous, so we don't do it.
      SubExpr = maybeUndoReclaimObject(SubExpr);
      break;
     case OBC_BridgeRetained:
      // Produce the object before casting it.
      SubExpr = ImplicitCastExpr.Create($this().Context, new QualType(FromType), 
          CastKind.CK_ARCProduceObject, 
          SubExpr, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue);
      break;
     case OBC_BridgeTransfer:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          boolean br = $this().isKnownName(new StringRef(/*KEEP_STR*/"CFBridgingRetain"));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BridgeKeywordLoc), diag.err_arc_bridge_cast_wrong_kind)), 
                                  (FromType.$arrow().isBlockPointerType() ? 1 : 0)), 
                              FromType), 
                          2), 
                      T), 
                  SubExpr.getSourceRange()), 
              Kind));
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BridgeKeywordLoc), diag.note_arc_bridge)), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/BridgeKeywordLoc), new StringRef(/*KEEP_STR*/"__bridge "))));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BridgeKeywordLoc), diag.note_arc_bridge_retained)), 
                      T), br), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/BridgeKeywordLoc), 
                  new StringRef(br ? $("CFBridgingRetain ") : $__bridge_retained))));
          
          Kind = ObjCBridgeCastKind.OBC_Bridge;
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_arc_bridge_cast_incompatible)), 
                          FromType), T), Kind), 
              SubExpr.getSourceRange()), 
          TSInfo.getTypeLoc().getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  final ObjCBridgeCastKind $Kind = Kind;
  final Expr /*P*/ $SubExpr = SubExpr;
  Expr /*P*/ Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCBridgedCastExpr(new SourceLocation(LParenLoc), $Kind, CK, 
      new SourceLocation(BridgeKeywordLoc), 
      TSInfo, $SubExpr));
  if (MustConsume) {
    $this().Cleanup.setExprNeedsCleanups(true);
    Result = ImplicitCastExpr.Create($this().Context, new QualType(T), CastKind.CK_ARCConsumeObject, Result, 
        (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue);
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Result);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCBridgedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 4338,
 FQN="clang::Sema::ActOnObjCBridgedCast", NM="_ZN5clang4Sema20ActOnObjCBridgedCastEPNS_5ScopeENS_14SourceLocationENS_18ObjCBridgeCastKindES3_NS_9OpaquePtrINS_8QualTypeEEES3_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema20ActOnObjCBridgedCastEPNS_5ScopeENS_14SourceLocationENS_18ObjCBridgeCastKindES3_NS_9OpaquePtrINS_8QualTypeEEES3_PNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnObjCBridgedCast(Scope /*P*/ S, 
                    SourceLocation LParenLoc, 
                    ObjCBridgeCastKind Kind, 
                    SourceLocation BridgeKeywordLoc, 
                    OpaquePtr<QualType> Type, 
                    SourceLocation RParenLoc, 
                    Expr /*P*/ SubExpr) {
  type$ptr<TypeSourceInfo /*P*/ > TSInfo = create_type$null$ptr(null);
  QualType T = GetTypeFromParser(new OpaquePtr<QualType>(Type), $AddrOf(TSInfo));
  if (Kind == ObjCBridgeCastKind.OBC_Bridge) {
    $this().CheckTollFreeBridgeCast(new QualType(T), SubExpr);
  }
  if (!(TSInfo.$star() != null)) {
    TSInfo.$set($this().Context.getTrivialTypeSourceInfo(new QualType(T), new SourceLocation(LParenLoc)));
  }
  return $this().BuildObjCBridgedCast(new SourceLocation(LParenLoc), Kind, new SourceLocation(BridgeKeywordLoc), TSInfo.$star(), 
      SubExpr);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTollFreeBridgeCast">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3756,
 FQN="clang::Sema::CheckTollFreeBridgeCast", NM="_ZN5clang4Sema23CheckTollFreeBridgeCastENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema23CheckTollFreeBridgeCastENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public final void CheckTollFreeBridgeCast(QualType castType, Expr /*P*/ castExpr) {
  if (!$this().getLangOpts().ObjC1) {
    return;
  }
  // warn in presence of __bridge casting to or from a toll free bridge cast.
  ARCConversionTypeClass exprACTC = classifyTypeForARCConversion(castExpr.getType());
  ARCConversionTypeClass castACTC = classifyTypeForARCConversion(new QualType(castType));
  if (castACTC == ARCConversionTypeClass.ACTC_retainable && exprACTC == ARCConversionTypeClass.ACTC_coreFoundation) {
    bool$ref HasObjCBridgeAttr = create_bool$ref();
    boolean ObjCBridgeAttrWillNotWarn = SemaExprObjCStatics.<ObjCBridgeAttr>CheckObjCBridgeNSCast(ObjCBridgeAttr.class, /*Deref*/$this(), new QualType(castType), castExpr, HasObjCBridgeAttr, 
        false);
    if (ObjCBridgeAttrWillNotWarn && HasObjCBridgeAttr.$deref()) {
      return;
    }
    bool$ref HasObjCBridgeMutableAttr = create_bool$ref();
    boolean ObjCBridgeMutableAttrWillNotWarn = SemaExprObjCStatics.<ObjCBridgeMutableAttr>CheckObjCBridgeNSCast(ObjCBridgeMutableAttr.class, /*Deref*/$this(), new QualType(castType), castExpr, 
        HasObjCBridgeMutableAttr, false);
    if (ObjCBridgeMutableAttrWillNotWarn && HasObjCBridgeMutableAttr.$deref()) {
      return;
    }
    if (HasObjCBridgeAttr.$deref()) {
      SemaExprObjCStatics.<ObjCBridgeAttr>CheckObjCBridgeNSCast(ObjCBridgeAttr.class, /*Deref*/$this(), new QualType(castType), castExpr, HasObjCBridgeAttr, 
          true);
    } else if (HasObjCBridgeMutableAttr.$deref()) {
      SemaExprObjCStatics.<ObjCBridgeMutableAttr>CheckObjCBridgeNSCast(ObjCBridgeMutableAttr.class, /*Deref*/$this(), new QualType(castType), castExpr, 
          HasObjCBridgeMutableAttr, true);
    }
  } else if (castACTC == ARCConversionTypeClass.ACTC_coreFoundation && exprACTC == ARCConversionTypeClass.ACTC_retainable) {
    bool$ref HasObjCBridgeAttr = create_bool$ref();
    boolean ObjCBridgeAttrWillNotWarn = SemaExprObjCStatics.<ObjCBridgeAttr>CheckObjCBridgeCFCast(ObjCBridgeAttr.class, /*Deref*/$this(), new QualType(castType), castExpr, HasObjCBridgeAttr, 
        false);
    if (ObjCBridgeAttrWillNotWarn && HasObjCBridgeAttr.$deref()) {
      return;
    }
    bool$ref HasObjCBridgeMutableAttr = create_bool$ref();
    boolean ObjCBridgeMutableAttrWillNotWarn = SemaExprObjCStatics.<ObjCBridgeMutableAttr>CheckObjCBridgeCFCast(ObjCBridgeMutableAttr.class, /*Deref*/$this(), new QualType(castType), castExpr, 
        HasObjCBridgeMutableAttr, false);
    if (ObjCBridgeMutableAttrWillNotWarn && HasObjCBridgeMutableAttr.$deref()) {
      return;
    }
    if (HasObjCBridgeAttr.$deref()) {
      SemaExprObjCStatics.<ObjCBridgeAttr>CheckObjCBridgeCFCast(ObjCBridgeAttr.class, /*Deref*/$this(), new QualType(castType), castExpr, HasObjCBridgeAttr, 
          true);
    } else if (HasObjCBridgeMutableAttr.$deref()) {
      SemaExprObjCStatics.<ObjCBridgeMutableAttr>CheckObjCBridgeCFCast(ObjCBridgeMutableAttr.class, /*Deref*/$this(), new QualType(castType), castExpr, 
          HasObjCBridgeMutableAttr, true);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCBridgeRelatedCast">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3806,
 FQN="clang::Sema::CheckObjCBridgeRelatedCast", NM="_ZN5clang4Sema26CheckObjCBridgeRelatedCastENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema26CheckObjCBridgeRelatedCastENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public final void CheckObjCBridgeRelatedCast(QualType castType, Expr /*P*/ _castExpr) {
  type$ref<Expr /*P*/> castExpr = create_type$ref(_castExpr);
  QualType SrcType = castExpr.$deref().getType();
  {
    ObjCPropertyRefExpr /*P*/ PRE = dyn_cast_ObjCPropertyRefExpr(castExpr.$deref());
    if ((PRE != null)) {
      if (PRE.isExplicitProperty()) {
        {
          ObjCPropertyDecl /*P*/ PDecl = PRE.getExplicitProperty();
          if ((PDecl != null)) {
            SrcType.$assignMove(PDecl.getType());
          }
        }
      } else if (PRE.isImplicitProperty()) {
        {
          ObjCMethodDecl /*P*/ Getter = PRE.getImplicitPropertyGetter();
          if ((Getter != null)) {
            SrcType.$assignMove(Getter.getReturnType());
          }
        }
      }
    }
  }
  
  ARCConversionTypeClass srcExprACTC = classifyTypeForARCConversion(new QualType(SrcType));
  ARCConversionTypeClass castExprACTC = classifyTypeForARCConversion(new QualType(castType));
  if (srcExprACTC != ARCConversionTypeClass.ACTC_retainable || castExprACTC != ARCConversionTypeClass.ACTC_coreFoundation) {
    return;
  }
  $this().CheckObjCBridgeRelatedConversions(castExpr.$deref().getLocStart(), 
      new QualType(castType), new QualType(SrcType), castExpr);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTollFreeBridgeStaticCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3827,
 FQN="clang::Sema::CheckTollFreeBridgeStaticCast", NM="_ZN5clang4Sema29CheckTollFreeBridgeStaticCastENS_8QualTypeEPNS_4ExprERNS_8CastKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema29CheckTollFreeBridgeStaticCastENS_8QualTypeEPNS_4ExprERNS_8CastKindE")
//</editor-fold>
public final boolean CheckTollFreeBridgeStaticCast(QualType castType, Expr /*P*/ castExpr, 
                             final type$ref<CastKind /*&*/> Kind) {
  if (!$this().getLangOpts().ObjC1) {
    return false;
  }
  ARCConversionTypeClass exprACTC = classifyTypeForARCConversion(castExpr.getType());
  ARCConversionTypeClass castACTC = classifyTypeForARCConversion(new QualType(castType));
  if ((castACTC == ARCConversionTypeClass.ACTC_retainable && exprACTC == ARCConversionTypeClass.ACTC_coreFoundation)
     || (castACTC == ARCConversionTypeClass.ACTC_coreFoundation && exprACTC == ARCConversionTypeClass.ACTC_retainable)) {
    $this().CheckTollFreeBridgeCast(new QualType(castType), castExpr);
    Kind.$set((castACTC == ARCConversionTypeClass.ACTC_coreFoundation) ? CastKind.CK_BitCast : CastKind.CK_CPointerToObjCPointerCast);
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkObjCBridgeRelatedComponents">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3844,
 FQN="clang::Sema::checkObjCBridgeRelatedComponents", NM="_ZN5clang4Sema32checkObjCBridgeRelatedComponentsENS_14SourceLocationENS_8QualTypeES2_RPNS_17ObjCInterfaceDeclERPNS_14ObjCMethodDeclES8_RPNS_15TypedefNameDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema32checkObjCBridgeRelatedComponentsENS_14SourceLocationENS_8QualTypeES2_RPNS_17ObjCInterfaceDeclERPNS_14ObjCMethodDeclES8_RPNS_15TypedefNameDeclEbb")
//</editor-fold>
public final boolean checkObjCBridgeRelatedComponents(SourceLocation Loc, 
                                QualType DestType, QualType SrcType, 
                                final type$ref<ObjCInterfaceDecl /*P*/ /*&*/> RelatedClass, 
                                final type$ref<ObjCMethodDecl /*P*/ /*&*/> ClassMethod, 
                                final type$ref<ObjCMethodDecl /*P*/ /*&*/> InstanceMethod, 
                                final type$ref<TypedefNameDecl /*P*/ /*&*/> TDNDecl, 
                                boolean CfToNs) {
  return checkObjCBridgeRelatedComponents(Loc, 
                                DestType, SrcType, 
                                RelatedClass, 
                                ClassMethod, 
                                InstanceMethod, 
                                TDNDecl, 
                                CfToNs, true);
}
public final boolean checkObjCBridgeRelatedComponents(SourceLocation Loc, 
                                QualType DestType, QualType SrcType, 
                                final type$ref<ObjCInterfaceDecl /*P*/ /*&*/> RelatedClass, 
                                final type$ref<ObjCMethodDecl /*P*/ /*&*/> ClassMethod, 
                                final type$ref<ObjCMethodDecl /*P*/ /*&*/> InstanceMethod, 
                                final type$ref<TypedefNameDecl /*P*/ /*&*/> TDNDecl, 
                                boolean CfToNs, boolean Diagnose/*= true*/) {
  LookupResult R = null;
  try {
    QualType T = new QualType(CfToNs ? SrcType : DestType);
    ObjCBridgeRelatedAttr /*P*/ ObjCBAttr = ObjCBridgeRelatedAttrFromType(new QualType(T), TDNDecl);
    if (!(ObjCBAttr != null)) {
      return false;
    }
    
    IdentifierInfo /*P*/ RCId = ObjCBAttr.getRelatedClass();
    IdentifierInfo /*P*/ CMId = ObjCBAttr.getClassMethod();
    IdentifierInfo /*P*/ IMId = ObjCBAttr.getInstanceMethod();
    if (!(RCId != null)) {
      return false;
    }
    NamedDecl /*P*/ Target = null;
    // Check for an existing type with this name.
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(RCId), new SourceLocation(), 
        Sema.LookupNameKind.LookupOrdinaryName);
    if (!$this().LookupName(R, $this().TUScope)) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_bridged_related_invalid_class)), RCId), 
                  SrcType), DestType));
          $c$.clean($c$.track($this().Diag(TDNDecl.$deref().getLocStart(), diag.note_declared_at)));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    Target = R.getFoundDecl();
    if ((Target != null) && isa_ObjCInterfaceDecl(Target)) {
      RelatedClass.$set(cast_ObjCInterfaceDecl(Target));
    } else {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_bridged_related_invalid_class_name)), RCId), 
                  SrcType), DestType));
          $c$.clean($c$.track($this().Diag(TDNDecl.$deref().getLocStart(), diag.note_declared_at)));
          if ((Target != null)) {
            $c$.clean($c$.track($this().Diag(Target.getLocStart(), diag.note_declared_at)));
          }
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    
    // Check for an existing class method with the given selector name.
    if (CfToNs && (CMId != null)) {
      Selector Sel = $this().Context.Selectors.getUnarySelector(CMId);
      ClassMethod.$set(RelatedClass.$deref().lookupMethod(new Selector(Sel), false));
      if (!(ClassMethod.$deref() != null)) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_bridged_related_known_method)), 
                            SrcType), DestType), Sel), false));
            $c$.clean($c$.track($this().Diag(TDNDecl.$deref().getLocStart(), diag.note_declared_at)));
          } finally {
            $c$.$destroy();
          }
        }
        return false;
      }
    }
    
    // Check for an existing instance method with the given selector name.
    if (!CfToNs && (IMId != null)) {
      Selector Sel = $this().Context.Selectors.getNullarySelector(IMId);
      InstanceMethod.$set(RelatedClass.$deref().lookupMethod(new Selector(Sel), true));
      if (!(InstanceMethod.$deref() != null)) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_bridged_related_known_method)), 
                            SrcType), DestType), Sel), true));
            $c$.clean($c$.track($this().Diag(TDNDecl.$deref().getLocStart(), diag.note_declared_at)));
          } finally {
            $c$.$destroy();
          }
        }
        return false;
      }
    }
    return true;
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCBridgeRelatedConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3917,
 FQN="clang::Sema::CheckObjCBridgeRelatedConversions", NM="_ZN5clang4Sema33CheckObjCBridgeRelatedConversionsENS_14SourceLocationENS_8QualTypeES2_RPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema33CheckObjCBridgeRelatedConversionsENS_14SourceLocationENS_8QualTypeES2_RPNS_4ExprEb")
//</editor-fold>
public final boolean CheckObjCBridgeRelatedConversions(SourceLocation Loc, 
                                 QualType DestType, QualType SrcType, 
                                 final type$ref<Expr /*P*/ /*&*/> SrcExpr) {
  return CheckObjCBridgeRelatedConversions(Loc, 
                                 DestType, SrcType, 
                                 SrcExpr, true);
}
public final boolean CheckObjCBridgeRelatedConversions(SourceLocation Loc, 
                                 QualType DestType, QualType SrcType, 
                                 final type$ref<Expr /*P*/ /*&*/> SrcExpr, boolean Diagnose/*= true*/) {
  ARCConversionTypeClass rhsExprACTC = classifyTypeForARCConversion(new QualType(SrcType));
  ARCConversionTypeClass lhsExprACTC = classifyTypeForARCConversion(new QualType(DestType));
  boolean CfToNs = (rhsExprACTC == ARCConversionTypeClass.ACTC_coreFoundation && lhsExprACTC == ARCConversionTypeClass.ACTC_retainable);
  boolean NsToCf = (rhsExprACTC == ARCConversionTypeClass.ACTC_retainable && lhsExprACTC == ARCConversionTypeClass.ACTC_coreFoundation);
  if (!CfToNs && !NsToCf) {
    return false;
  }
  
  type$ref<ObjCInterfaceDecl /*P*/ > RelatedClass = create_type$ref();
  type$ref<ObjCMethodDecl /*P*/ > ClassMethod = create_type$null$ref(null);
  type$ref<ObjCMethodDecl /*P*/ > InstanceMethod = create_type$null$ref(null);
  type$ref<TypedefNameDecl /*P*/ > TDNDecl = create_type$null$ref(null);
  if (!$this().checkObjCBridgeRelatedComponents(new SourceLocation(Loc), new QualType(DestType), new QualType(SrcType), RelatedClass, 
      ClassMethod, InstanceMethod, TDNDecl, 
      CfToNs, Diagnose)) {
    return false;
  }
  if (CfToNs) {
    // Implicit conversion from CF to ObjC object is needed.
    if ((ClassMethod.$deref() != null)) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          std.string ExpressionString = new std.string(/*KEEP_STR*/$LSQUARE);
          ExpressionString.$addassign(RelatedClass.$deref().getNameAsString());
          ExpressionString.$addassign_T$C$P(/*KEEP_STR*/" ");
          ExpressionString.$addassign(ClassMethod.$deref().getSelector().getAsString());
          SourceLocation SrcExprEndLoc = $this().getLocForEndOfToken(SrcExpr.$deref().getLocEnd());
          // Provide a fixit: [RelatedClass ClassMethod SrcExpr]
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_bridged_related_known_method)), 
                                  SrcType), DestType), ClassMethod.$deref().getSelector()), false), 
                  FixItHint.CreateInsertion(SrcExpr.$deref().getLocStart(), new StringRef(ExpressionString))), 
              FixItHint.CreateInsertion(/*NO_COPY*/SrcExprEndLoc, new StringRef(/*KEEP_STR*/$RSQUARE))));
          $c$.clean($c$.track($this().Diag(RelatedClass.$deref().getLocStart(), diag.note_declared_at)));
          $c$.clean($c$.track($this().Diag(TDNDecl.$deref().getLocStart(), diag.note_declared_at)));
          
          QualType receiverType = $this().Context.getObjCInterfaceType(RelatedClass.$deref());
          // Argument.
          Expr /*P*/ args[/*1*/] = new Expr /*P*/  [/*1*/] {SrcExpr.$deref()};
          ActionResultTTrue<Expr /*P*/ > msg = $this().BuildClassMessageImplicit(new QualType(receiverType), false, 
              ClassMethod.$deref().getLocation(), 
              ClassMethod.$deref().getSelector(), ClassMethod.$deref(), 
              new MutableArrayRef<Expr /*P*/ >(create_type$ptr(args), 1, true));
          SrcExpr.$set(msg.get());
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  } else {
    // Implicit conversion from ObjC type to CF object is needed.
    if ((InstanceMethod.$deref() != null)) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          std.string ExpressionString/*J*/= new std.string();
          SourceLocation SrcExprEndLoc = $this().getLocForEndOfToken(SrcExpr.$deref().getLocEnd());
          if (InstanceMethod.$deref().isPropertyAccessor()) {
            {
              /*const*/ ObjCPropertyDecl /*P*/ PDecl = InstanceMethod.$deref().findPropertyDecl();
              if ((PDecl != null)) {
                // fixit: ObjectExpr.propertyname when it is  aproperty accessor.
                ExpressionString.$assign_T$C$P(/*KEEP_STR*/".");
                ExpressionString.$addassign(PDecl.getNameAsString());
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_bridged_related_known_method)), 
                                    SrcType), DestType), InstanceMethod.$deref().getSelector()), true), 
                    FixItHint.CreateInsertion(/*NO_COPY*/SrcExprEndLoc, new StringRef(ExpressionString))));
              }
            }
          }
          if (ExpressionString.empty()) {
            // Provide a fixit: [ObjectExpr InstanceMethod]
            ExpressionString.$assign_T$C$P(/*KEEP_STR*/" ");
            ExpressionString.$addassign(InstanceMethod.$deref().getSelector().getAsString());
            ExpressionString.$addassign_T$C$P(/*KEEP_STR*/"]");
            
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_bridged_related_known_method)), 
                                    SrcType), DestType), InstanceMethod.$deref().getSelector()), true), 
                    FixItHint.CreateInsertion(SrcExpr.$deref().getLocStart(), new StringRef(/*KEEP_STR*/$LSQUARE))), 
                FixItHint.CreateInsertion(/*NO_COPY*/SrcExprEndLoc, new StringRef(ExpressionString))));
          }
          $c$.clean($c$.track($this().Diag(RelatedClass.$deref().getLocStart(), diag.note_declared_at)));
          $c$.clean($c$.track($this().Diag(TDNDecl.$deref().getLocStart(), diag.note_declared_at)));
          
          ActionResultTTrue<Expr /*P*/ > msg = $this().BuildInstanceMessageImplicit(SrcExpr.$deref(), new QualType(SrcType), 
              InstanceMethod.$deref().getLocation(), 
              InstanceMethod.$deref().getSelector(), 
              InstanceMethod.$deref(), new MutableArrayRef<Expr /*P*/ >(None, true));
          SrcExpr.$set(msg.get());
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  return false;
}


/// \brief Checks for invalid conversions and casts between
/// retainable pointers and other pointer kinds.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCARCConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 4010,
 FQN="clang::Sema::CheckObjCARCConversion", NM="_ZN5clang4Sema22CheckObjCARCConversionENS_11SourceRangeENS_8QualTypeERPNS_4ExprENS0_21CheckedConversionKindEbbNS_18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema22CheckObjCARCConversionENS_11SourceRangeENS_8QualTypeERPNS_4ExprENS0_21CheckedConversionKindEbbNS_18BinaryOperatorKindE")
//</editor-fold>
public final Sema.ARCConversionResult CheckObjCARCConversion(SourceRange castRange, QualType castType, 
                      final type$ref<Expr /*P*/ /*&*/> castExpr, CheckedConversionKind CCK) {
  return CheckObjCARCConversion(castRange, castType, 
                      castExpr, CCK, 
                      true, 
                      false, 
                      BinaryOperatorKind.BO_PtrMemD);
}
public final Sema.ARCConversionResult CheckObjCARCConversion(SourceRange castRange, QualType castType, 
                      final type$ref<Expr /*P*/ /*&*/> castExpr, CheckedConversionKind CCK, 
                      boolean Diagnose/*= true*/) {
  return CheckObjCARCConversion(castRange, castType, 
                      castExpr, CCK, 
                      Diagnose, 
                      false, 
                      BinaryOperatorKind.BO_PtrMemD);
}
public final Sema.ARCConversionResult CheckObjCARCConversion(SourceRange castRange, QualType castType, 
                      final type$ref<Expr /*P*/ /*&*/> castExpr, CheckedConversionKind CCK, 
                      boolean Diagnose/*= true*/, 
                      boolean DiagnoseCFAudited/*= false*/) {
  return CheckObjCARCConversion(castRange, castType, 
                      castExpr, CCK, 
                      Diagnose, 
                      DiagnoseCFAudited, 
                      BinaryOperatorKind.BO_PtrMemD);
}
public final Sema.ARCConversionResult CheckObjCARCConversion(SourceRange castRange, QualType castType, 
                      final type$ref<Expr /*P*/ /*&*/> castExpr, CheckedConversionKind CCK, 
                      boolean Diagnose/*= true*/, 
                      boolean DiagnoseCFAudited/*= false*/, 
                      BinaryOperatorKind Opc/*= BO_PtrMemD*/) {
  QualType castExprType = castExpr.$deref().getType();
  
  // For the purposes of the classification, we assume reference types
  // will bind to temporaries.
  QualType effCastType = new QualType(castType);
  {
    /*const*/ ReferenceType /*P*/ ref = castType.$arrow().getAs(ReferenceType.class);
    if ((ref != null)) {
      effCastType.$assignMove(ref.getPointeeType());
    }
  }
  
  ARCConversionTypeClass exprACTC = classifyTypeForARCConversion(new QualType(castExprType));
  ARCConversionTypeClass castACTC = classifyTypeForARCConversion(new QualType(effCastType));
  if (exprACTC == castACTC) {
    // Check for viability and report error if casting an rvalue to a
    // life-time qualifier.
    if (castACTC == ARCConversionTypeClass.ACTC_retainable
       && (CCK == CheckedConversionKind.CCK_CStyleCast || CCK == CheckedConversionKind.CCK_OtherCast)
       && $noteq_QualType$C(castType, castExprType)) {
      /*const*/ Type /*P*/ DT = castType.getTypePtr();
      QualType QDT = new QualType(castType);
      {
        // We desugar some types but not others. We ignore those
        // that cannot happen in a cast; i.e. auto, and those which
        // should not be de-sugared; i.e typedef.
        /*const*/ ParenType /*P*/ PT = dyn_cast_ParenType(DT);
        if ((PT != null)) {
          QDT.$assignMove(PT.desugar());
        } else {
          /*const*/ TypeOfType /*P*/ TP = dyn_cast_TypeOfType(DT);
          if ((TP != null)) {
            QDT.$assignMove(TP.desugar());
          } else {
            /*const*/ AttributedType /*P*/ AT = dyn_cast_AttributedType(DT);
            if ((AT != null)) {
              QDT.$assignMove(AT.desugar());
            }
          }
        }
      }
      if ($noteq_QualType$C(QDT, castType)
         && QDT.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_None) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation loc = (castRange.isValid() ? castRange.getBegin() : castExpr.$deref().getExprLoc());
            $c$.clean($c$.track($this().Diag(new SourceLocation(loc), diag.err_arc_nolifetime_behavior)));
          } finally {
            $c$.$destroy();
          }
        }
        return ARCConversionResult.ACR_error;
      }
    }
    return ARCConversionResult.ACR_okay;
  }
  if (isAnyCLike(exprACTC) && isAnyCLike(castACTC)) {
    return ARCConversionResult.ACR_okay;
  }
  
  // Allow all of these types to be cast to integer types (but not
  // vice-versa).
  if (castACTC == ARCConversionTypeClass.ACTC_none && castType.$arrow().isIntegralType($this().Context)) {
    return ARCConversionResult.ACR_okay;
  }
  
  // Allow casts between pointers to lifetime types (e.g., __strong id*)
  // and pointers to void (e.g., cv void *). Casting from void* to lifetime*
  // must be explicit.
  if (exprACTC == ARCConversionTypeClass.ACTC_indirectRetainable && castACTC == ARCConversionTypeClass.ACTC_voidPtr) {
    return ARCConversionResult.ACR_okay;
  }
  if (castACTC == ARCConversionTypeClass.ACTC_indirectRetainable && exprACTC == ARCConversionTypeClass.ACTC_voidPtr
     && CCK != CheckedConversionKind.CCK_ImplicitConversion) {
    return ARCConversionResult.ACR_okay;
  }
  switch (new ARCCastChecker($this().Context, exprACTC, castACTC, false).Visit(castExpr.$deref())) {
   case ACC_invalid:
    // For invalid casts, fall through.
    break;
   case ACC_bottom:
   case ACC_plusZero:
    
    // Do nothing for both bottom and +0.
    return ARCConversionResult.ACR_okay;
   case ACC_plusOne:
    
    // If the result is +1, consume it here.
    castExpr.$set(ImplicitCastExpr.Create($this().Context, castExpr.$deref().getType(), 
        CastKind.CK_ARCConsumeObject, castExpr.$deref(), 
        (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue));
    $this().Cleanup.setExprNeedsCleanups(true);
    return ARCConversionResult.ACR_okay;
  }
  
  // If this is a non-implicit cast from id or block type to a
  // CoreFoundation type, delay complaining in case the cast is used
  // in an acceptable context.
  if (exprACTC == ARCConversionTypeClass.ACTC_retainable && isAnyRetainable(castACTC)
     && CCK != CheckedConversionKind.CCK_ImplicitConversion) {
    return ARCConversionResult.ACR_unbridged;
  }
  
  // Issue a diagnostic about a missing @-sign when implicit casting a cstring
  // to 'NSString *', instead of falling through to report a "bridge cast"
  // diagnostic.
  if (castACTC == ARCConversionTypeClass.ACTC_retainable && exprACTC == ARCConversionTypeClass.ACTC_none
     && $this().ConversionToObjCStringLiteralCheck(new QualType(castType), castExpr, Diagnose)) {
    return ARCConversionResult.ACR_error;
  }
  
  // Do not issue "bridge cast" diagnostic when implicit casting
  // a retainable object to a CF type parameter belonging to an audited
  // CF API function. Let caller issue a normal type mismatched diagnostic
  // instead.
  if ((!DiagnoseCFAudited || exprACTC != ARCConversionTypeClass.ACTC_retainable
     || castACTC != ARCConversionTypeClass.ACTC_coreFoundation)
     && !(exprACTC == ARCConversionTypeClass.ACTC_voidPtr && castACTC == ARCConversionTypeClass.ACTC_retainable
     && (Opc == BinaryOperatorKind.BO_NE || Opc == BinaryOperatorKind.BO_EQ))) {
    if (Diagnose) {
      diagnoseObjCARCConversion(/*Deref*/$this(), new SourceRange(castRange), new QualType(castType), castACTC, castExpr.$deref(), 
          castExpr.$deref(), exprACTC, CCK);
    }
    return ARCConversionResult.ACR_error;
  }
  return ARCConversionResult.ACR_okay;
}


/// stripARCUnbridgedCast - Given an expression of ARCUnbridgedCast
/// type, remove the placeholder cast.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::stripARCUnbridgedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 4157,
 FQN="clang::Sema::stripARCUnbridgedCast", NM="_ZN5clang4Sema21stripARCUnbridgedCastEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema21stripARCUnbridgedCastEPNS_4ExprE")
//</editor-fold>
public final Expr /*P*/ stripARCUnbridgedCast(Expr /*P*/ e) {
  assert (e.hasPlaceholderType(BuiltinType.Kind.ARCUnbridgedCast));
  {
    
    ParenExpr /*P*/ pe = dyn_cast_ParenExpr(e);
    if ((pe != null)) {
      Expr /*P*/ sub = $this().stripARCUnbridgedCast(pe.getSubExpr());
      return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ParenExpr(pe.getLParen(), pe.getRParen(), sub));
    } else {
      UnaryOperator /*P*/ uo = dyn_cast_UnaryOperator(e);
      if ((uo != null)) {
        assert (uo.getOpcode() == UnaryOperatorKind.UO_Extension);
        Expr /*P*/ sub = $this().stripARCUnbridgedCast(uo.getSubExpr());
        return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new UnaryOperator(sub, UnaryOperatorKind.UO_Extension, sub.getType(), 
            sub.getValueKind(), sub.getObjectKind(), 
            uo.getOperatorLoc()));
      } else {
        GenericSelectionExpr /*P*/ gse = dyn_cast_GenericSelectionExpr(e);
        if ((gse != null)) {
          assert (!gse.isResultDependent());
          
          /*uint*/int n = gse.getNumAssocs();
          SmallVector<Expr /*P*/ > subExprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, n, (Expr /*P*/ )null);
          SmallVector<TypeSourceInfo /*P*/ > subTypes/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, n, (TypeSourceInfo /*P*/ )null);
          for (/*uint*/int i = 0; i != n; ++i) {
            subTypes.$set(i, gse.getAssocTypeSourceInfo(i));
            Expr /*P*/ sub = gse.getAssocExpr(i);
            if (i == gse.getResultIndex()) {
              sub = $this().stripARCUnbridgedCast(sub);
            }
            subExprs.$set(i, sub);
          }
          
          return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new GenericSelectionExpr($this().Context, gse.getGenericLoc(), 
              gse.getControllingExpr(), 
              new ArrayRef<TypeSourceInfo /*P*/ >(subTypes, true), new ArrayRef<Expr /*P*/ >(subExprs, true), 
              gse.getDefaultLoc(), 
              gse.getRParenLoc(), 
              gse.containsUnexpandedParameterPack(), 
              gse.getResultIndex()));
        } else {
          assert (isa_ImplicitCastExpr(e)) : "bad form of unbridged cast!";
          return cast_ImplicitCastExpr(e).getSubExpr();
        }
      }
    }
  }
}


/// Given that we saw an expression with the ARCUnbridgedCastTy
/// placeholder type, complain bitterly.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseARCUnbridgedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 4123,
 FQN="clang::Sema::diagnoseARCUnbridgedCast", NM="_ZN5clang4Sema24diagnoseARCUnbridgedCastEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema24diagnoseARCUnbridgedCastEPNS_4ExprE")
//</editor-fold>
public final void diagnoseARCUnbridgedCast(Expr /*P*/ e) {
  // We expect the spurious ImplicitCastExpr to already have been stripped.
  assert (!e.hasPlaceholderType(BuiltinType.Kind.ARCUnbridgedCast));
  CastExpr /*P*/ realCast = cast_CastExpr(e.IgnoreParens());
  
  SourceRange castRange/*J*/= new SourceRange();
  QualType castType/*J*/= new QualType();
  CheckedConversionKind CCK;
  {
    
    CStyleCastExpr /*P*/ cast = dyn_cast_CStyleCastExpr(realCast);
    if ((cast != null)) {
      castRange.$assignMove(new SourceRange(cast.getLParenLoc(), cast.getRParenLoc()));
      castType.$assignMove(cast.getTypeAsWritten());
      CCK = CheckedConversionKind.CCK_CStyleCast;
    } else {
      ExplicitCastExpr /*P*/ cast$1 = dyn_cast_ExplicitCastExpr(realCast);
      if ((cast$1 != null)) {
        castRange.$assignMove(cast$1.getTypeInfoAsWritten().getTypeLoc().getSourceRange());
        castType.$assignMove(cast$1.getTypeAsWritten());
        CCK = CheckedConversionKind.CCK_OtherCast;
      } else {
        castType.$assignMove(cast$1.getType());
        CCK = CheckedConversionKind.CCK_ImplicitConversion;
      }
    }
  }
  
  ARCConversionTypeClass castACTC = classifyTypeForARCConversion(castType.getNonReferenceType());
  
  Expr /*P*/ castExpr = realCast.getSubExpr();
  assert (classifyTypeForARCConversion(castExpr.getType()) == ARCConversionTypeClass.ACTC_retainable);
  
  diagnoseObjCARCConversion(/*Deref*/$this(), new SourceRange(castRange), new QualType(castType), castACTC, 
      castExpr, realCast, ARCConversionTypeClass.ACTC_retainable, CCK);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCARCUnavailableWeakConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 4196,
 FQN="clang::Sema::CheckObjCARCUnavailableWeakConversion", NM="_ZN5clang4Sema37CheckObjCARCUnavailableWeakConversionENS_8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema37CheckObjCARCUnavailableWeakConversionENS_8QualTypeES1_")
//</editor-fold>
public final boolean CheckObjCARCUnavailableWeakConversion(QualType castType, 
                                     QualType exprType) {
  QualType canCastType = $this().Context.getCanonicalType(new QualType(castType)).getUnqualifiedType().$QualType();
  QualType canExprType = $this().Context.getCanonicalType(new QualType(exprType)).getUnqualifiedType().$QualType();
  if (isa_ObjCObjectPointerType(canCastType)
     && castType.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak
     && canExprType.$arrow().isObjCObjectPointerType()) {
    {
      /*const*/ ObjCObjectPointerType /*P*/ ObjT = canExprType.$arrow().getAs(ObjCObjectPointerType.class);
      if ((ObjT != null)) {
        {
          /*const*/ ObjCInterfaceDecl /*P*/ ObjI = ObjT.getInterfaceDecl();
          if ((ObjI != null)) {
            return !ObjI.isArcWeakrefUnavailable();
          }
        }
      }
    }
  }
  return true;
}


/// CheckMessageArgumentTypes - Check types in an Obj-C message send.
/// \param Method - May be null.
/// \param [out] ReturnType - The return type of the send.
/// \return true iff there were any incompatible types.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMessageArgumentTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1494,
 FQN="clang::Sema::CheckMessageArgumentTypes", NM="_ZN5clang4Sema25CheckMessageArgumentTypesENS_8QualTypeEN4llvm15MutableArrayRefIPNS_4ExprEEENS_8SelectorENS2_8ArrayRefINS_14SourceLocationEEEPNS_14ObjCMethodDeclEbbS9_S9_NS_11SourceRangeERS1_RNS_13ExprValueKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema25CheckMessageArgumentTypesENS_8QualTypeEN4llvm15MutableArrayRefIPNS_4ExprEEENS_8SelectorENS2_8ArrayRefINS_14SourceLocationEEEPNS_14ObjCMethodDeclEbbS9_S9_NS_11SourceRangeERS1_RNS_13ExprValueKindE")
//</editor-fold>
public final boolean CheckMessageArgumentTypes(QualType ReceiverType, 
                         MutableArrayRef<Expr /*P*/ > Args, 
                         Selector Sel, 
                         ArrayRef<SourceLocation> SelectorLocs, 
                         ObjCMethodDecl /*P*/ Method, 
                         boolean isClassMessage, boolean isSuperMessage, 
                         SourceLocation lbrac, SourceLocation rbrac, 
                         SourceRange RecRange, 
                         final QualType /*&*/ ReturnType, final type$ref<ExprValueKind /*&*/> VK) {
  SourceLocation SelLoc/*J*/= new SourceLocation();
  if (!SelectorLocs.empty() && SelectorLocs.front().isValid()) {
    SelLoc.$assign(SelectorLocs.front());
  } else {
    SelLoc.$assign(lbrac);
  }
  if (!(Method != null)) {
    // Apply default argument promotion as for (C99 6.5.2.2p6).
    for (/*uint*/int i = 0, e = Args.size(); i != e; i++) {
      if (Args.$at(i).isTypeDependent()) {
        continue;
      }
      
      ActionResultTTrue<Expr /*P*/ > result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($this().getLangOpts().DebuggerSupport) {
        QualType paramTy/*J*/= new QualType(); // ignored
        result.$assignMove($this().checkUnknownAnyArg(new SourceLocation(SelLoc), Args.$at(i), paramTy));
      } else {
        result.$assignMove($this().DefaultArgumentPromotion(Args.$at(i)));
      }
      if (result.isInvalid()) {
        return true;
      }
      Args.$set(i, result.get());
    }
    
    /*uint*/int DiagID;
    if ($this().getLangOpts().ObjCAutoRefCount) {
      DiagID = diag.err_arc_method_not_found;
    } else {
      DiagID = isClassMessage ? diag.warn_class_method_not_found : diag.warn_inst_method_not_found;
    }
    if (!$this().getLangOpts().DebuggerSupport) {
      /*const*/ ObjCMethodDecl /*P*/ OMD = $this().SelectorsForTypoCorrection(new Selector(Sel), new QualType(ReceiverType));
      if ((OMD != null) && !OMD.isInvalidDecl()) {
        if ($this().getLangOpts().ObjCAutoRefCount) {
          DiagID = diag.error_method_not_found_with_typo;
        } else {
          DiagID = isClassMessage ? diag.warn_class_method_not_found_with_typo : diag.warn_instance_method_not_found_with_typo;
        }
        Selector MatchedSel = OMD.getSelector();
        SourceRange SelectorRange/*J*/= new SourceRange(/*NO_COPY*/SelectorLocs.front(), /*NO_COPY*/SelectorLocs.back());
        if (MatchedSel.isUnarySelector()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), DiagID)), 
                            Sel), isClassMessage), MatchedSel), 
                FixItHint.CreateReplacement(/*NO_COPY*/SelectorRange, new StringRef(MatchedSel.getAsString()))));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), DiagID)), Sel), isClassMessage), MatchedSel));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), DiagID)), 
                      Sel), isClassMessage), new SourceRange(/*NO_COPY*/SelectorLocs.front(), 
                  /*NO_COPY*/SelectorLocs.back())));
        } finally {
          $c$.$destroy();
        }
      }
      // Find the class to which we are sending this message.
      if (ReceiverType.$arrow().isObjCObjectPointerType()) {
        {
          ObjCInterfaceDecl /*P*/ ThisClass = ReceiverType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceDecl();
          if ((ThisClass != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(ThisClass.getLocation(), diag.note_receiver_class_declared)));
              if (!RecRange.isInvalid()) {
                if ((ThisClass.lookupClassMethod(new Selector(Sel)) != null)) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RecRange.getBegin(), diag.note_receiver_expr_here)), 
                      FixItHint.CreateReplacement(/*NO_COPY*/RecRange, 
                          new StringRef(ThisClass.getNameAsString()))));
                }
              }
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    // In debuggers, we want to use __unknown_anytype for these
    // results so that clients can cast them.
    if ($this().getLangOpts().DebuggerSupport) {
      ReturnType.$assignMove($this().Context.UnknownAnyTy.$QualType());
    } else {
      ReturnType.$assignMove($this().Context.getObjCIdType());
    }
    VK.$set(ExprValueKind.VK_RValue);
    return false;
  }
  
  ReturnType.$assignMove($this().getMessageSendResultType(new QualType(ReceiverType), Method, isClassMessage, 
          isSuperMessage));
  VK.$set(Expr.getValueKindForType(Method.getReturnType()));
  
  /*uint*/int NumNamedArgs = Sel.getNumArgs();
  // Method might have more arguments than selector indicates. This is due
  // to addition of c-style arguments in method.
  if ($greater_uint(Method.param_size(), Sel.getNumArgs())) {
    NumNamedArgs = Method.param_size();
  }
  // FIXME. This need be cleaned up.
  if ($less_uint(Args.size(), NumNamedArgs)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SelLoc), diag.err_typecheck_call_too_few_args)), 
                  2), NumNamedArgs), ((/*static_cast*//*uint*/int)(Args.size()))));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Compute the set of type arguments to be substituted into each parameter
  // type.
  Optional<ArrayRef<QualType> > typeArgs = ReceiverType.$arrow().getObjCSubstitutions(Method.getDeclContext());
  boolean IsError = false;
  for (/*uint*/int i = 0; $less_uint(i, NumNamedArgs); i++) {
    // We can't do any type-checking on a type-dependent argument.
    if (Args.$at(i).isTypeDependent()) {
      continue;
    }
    
    Expr /*P*/ argExpr = Args.$at(i);
    
    ParmVarDecl /*P*/ param = Method.parameters().$at(i);
    assert ((argExpr != null)) : "CheckMessageArgumentTypes(): missing expression";
    
    // Strip the unbridged-cast placeholder expression off unless it's
    // a consumed argument.
    if (argExpr.hasPlaceholderType(BuiltinType.Kind.ARCUnbridgedCast)
       && !param.hasAttr(CFConsumedAttr.class)) {
      argExpr = $this().stripARCUnbridgedCast(argExpr);
    }
    
    // If the parameter is __unknown_anytype, infer its type
    // from the argument.
    if ($eq_QualType$C(param.getType(), $this().Context.UnknownAnyTy.$QualType())) {
      QualType paramType/*J*/= new QualType();
      ActionResultTTrue<Expr /*P*/ > argE = $this().checkUnknownAnyArg(new SourceLocation(SelLoc), argExpr, paramType);
      if (argE.isInvalid()) {
        IsError = true;
      } else {
        Args.$set(i, argE.get());
        
        // Update the parameter type in-place.
        param.setType(new QualType(paramType));
      }
      continue;
    }
    
    QualType origParamType = param.getType();
    QualType paramType = param.getType();
    if (typeArgs.$bool()) {
      paramType.$assignMove(paramType.substObjCTypeArgs($this().Context, 
              new ArrayRef<QualType>(typeArgs.$star()), 
              ObjCSubstitutionContext.Parameter));
    }
    if ($this().RequireCompleteType$T(argExpr.getSourceRange().getBegin(), 
        new QualType(paramType), 
        diag.err_call_incomplete_argument, argExpr)) {
      return true;
    }
    
    InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, param, new QualType(paramType));
    ActionResultTTrue<Expr /*P*/ > ArgE = $this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, argExpr));
    if (ArgE.isInvalid()) {
      IsError = true;
    } else {
      Args.$set(i, ArgE.getAs(Expr.class));
      
      // If we are type-erasing a block to a block-compatible
      // Objective-C pointer type, we may need to extend the lifetime
      // of the block object.
      if (typeArgs.$bool() && Args.$at(i).isRValue() && paramType.$arrow().isBlockPointerType()
         && Args.$at(i).getType().$arrow().isBlockPointerType()
         && origParamType.$arrow().isObjCObjectPointerType()) {
        ActionResultTTrue<Expr /*P*/ > arg = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Args.$at(i));
        $this().maybeExtendBlockObject(arg);
        Args.$set(i, arg.get());
      }
    }
  }
  
  // Promote additional arguments to variadic methods.
  if (Method.isVariadic()) {
    for (/*uint*/int i = NumNamedArgs, e = Args.size(); $less_uint(i, e); ++i) {
      if (Args.$at(i).isTypeDependent()) {
        continue;
      }
      
      ActionResultTTrue<Expr /*P*/ > Arg = $this().DefaultVariadicArgumentPromotion(Args.$at(i), VariadicCallType.VariadicMethod, 
          (FunctionDecl /*P*/ )null);
      IsError |= Arg.isInvalid();
      Args.$set(i, Arg.get());
    }
  } else {
    // Check for extra arguments to non-variadic methods.
    if (Args.size() != NumNamedArgs) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Args.$at(NumNamedArgs).getLocStart(), 
                                diag.err_typecheck_call_too_many_args)), 
                            2/*method*/), NumNamedArgs), ((/*static_cast*//*uint*/int)(Args.size()))), 
                Method.getSourceRange()), 
            new SourceRange(Args.$at(NumNamedArgs).getLocStart(), 
                Args.back().getLocEnd())));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  $this().DiagnoseSentinelCalls(Method, new SourceLocation(SelLoc), new ArrayRef<Expr /*P*/ >(Args));
  
  // Do additional checkings on method.
  IsError |= $this().CheckObjCMethodCall(Method, new SourceLocation(SelLoc), new ArrayRef</*const*/ Expr /*P*/ >(JD$Convertible.INSTANCE, makeArrayRef(Args.data(), Args.size()), true));
  
  return IsError;
}


/// \brief Determine the result of a message send expression based on
/// the type of the receiver, the method expected to receive the message,
/// and the form of the message send.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getMessageSendResultType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1340,
 FQN="clang::Sema::getMessageSendResultType", NM="_ZN5clang4Sema24getMessageSendResultTypeENS_8QualTypeEPNS_14ObjCMethodDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema24getMessageSendResultTypeENS_8QualTypeEPNS_14ObjCMethodDeclEbb")
//</editor-fold>
public final QualType getMessageSendResultType(QualType ReceiverType, 
                        ObjCMethodDecl /*P*/ Method, 
                        boolean isClassMessage, 
                        boolean isSuperMessage) {
  // Produce the result type.
  QualType resultType = getBaseMessageSendResultType(/*Deref*/$this(), new QualType(ReceiverType), 
      Method, 
      isClassMessage, 
      isSuperMessage);
  
  // If this is a class message, ignore the nullability of the receiver.
  if (isClassMessage) {
    return resultType;
  }
  
  // Map the nullability of the result into a table index.
  /*uint*/int receiverNullabilityIdx = 0;
  {
    Optional<NullabilityKind> nullability = ReceiverType.$arrow().getNullability($this().Context);
    if (nullability.$bool()) {
      receiverNullabilityIdx = 1 + ((/*static_cast*//*uint*/int)nullability.$star().getValue());
    }
  }
  
  /*uint*/int resultNullabilityIdx = 0;
  {
    Optional<NullabilityKind> nullability = resultType.$arrow().getNullability($this().Context);
    if (nullability.$bool()) {
      resultNullabilityIdx = 1 + ((/*static_cast*//*uint*/int)nullability.$star().getValue());
    }
  }
  
  // The table of nullability mappings, indexed by the receiver's nullability
  // and then the result type's nullability.
  final/*static*/ /*const*/byte/*uint8_t*/ None = getMessageSendResultType$$.None;
  final/*static*/ /*const*/byte/*uint8_t*/ NonNull = getMessageSendResultType$$.NonNull;
  final/*static*/ /*const*/byte/*uint8_t*/ Nullable = getMessageSendResultType$$.Nullable;
  final/*static*/ /*const*/byte/*uint8_t*/ Unspecified = getMessageSendResultType$$.Unspecified;
  final/*static*/ /*const*/byte/*uint8_t*/ nullabilityMap[/*4*/][/*4*/] = getMessageSendResultType$$.nullabilityMap;
  
  /*uint*/int newResultNullabilityIdx = $uchar2uint(nullabilityMap[receiverNullabilityIdx][resultNullabilityIdx]);
  if (newResultNullabilityIdx == resultNullabilityIdx) {
    return resultType;
  }
  
  // Strip off the existing nullability. This removes as little type sugar as
  // possible.
  do {
    {
      /*const*/ AttributedType /*P*/ attributed = dyn_cast_AttributedType(resultType.getTypePtr());
      if ((attributed != null)) {
        resultType.$assignMove(attributed.getModifiedType());
      } else {
        resultType.$assignMove(resultType.getDesugaredType($this().Context));
      }
    }
  } while (resultType.$arrow().getNullability($this().Context).$bool());
  
  // Add nullability back if needed.
  if ($greater_uint(newResultNullabilityIdx, 0)) {
    NullabilityKind newNullability = /*static_cast*/NullabilityKind.valueOf(newResultNullabilityIdx - 1);
    return $this().Context.getAttributedType(AttributedType.getNullabilityAttrKind(newNullability), 
        new QualType(resultType), new QualType(resultType));
  }
  
  return resultType;
}
private static final class getMessageSendResultType$$ {
  static final/*static*/ /*const*/byte/*uint8_t*/ None = 0;
  static final/*static*/ /*const*/byte/*uint8_t*/ NonNull = 1;
  static final/*static*/ /*const*/byte/*uint8_t*/ Nullable = 2;
  static final/*static*/ /*const*/byte/*uint8_t*/ Unspecified = 3;
  static final/*static*/ /*const*/byte/*uint8_t*/ nullabilityMap[/*4*/][/*4*/] = new /*const*/byte/*uint8_t*/ [/*4*/] [/*4*/] {
  //                  None        NonNull       Nullable    Unspecified
  /* None */ new$char(4, None, None, Nullable, None), 
  /* NonNull */ new$char(4, None, NonNull, Nullable, Unspecified), 
  /* Nullable */ new$char(4, Nullable, Nullable, Nullable, Nullable), 
  /* Unspecified */ new$char(4, None, Unspecified, Nullable, Unspecified)
};
}


/// \brief If the given expression involves a message send to a method
/// with a related result type, emit a note describing what happened.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::EmitRelatedResultTypeNote">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1468,
 FQN="clang::Sema::EmitRelatedResultTypeNote", NM="_ZN5clang4Sema25EmitRelatedResultTypeNoteEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema25EmitRelatedResultTypeNoteEPKNS_4ExprE")
//</editor-fold>
public final void EmitRelatedResultTypeNote(/*const*/ Expr /*P*/ E) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    E = E.IgnoreParenImpCasts$Const();
    /*const*/ ObjCMessageExpr /*P*/ MsgSend = dyn_cast_ObjCMessageExpr(E);
    if (!(MsgSend != null)) {
      return;
    }
    
    /*const*/ ObjCMethodDecl /*P*/ Method = MsgSend.getMethodDecl$Const();
    if (!(Method != null)) {
      return;
    }
    if (!Method.hasRelatedResultType()) {
      return;
    }
    if ($this().Context.hasSameUnqualifiedType(Method.getReturnType().getNonReferenceType(), MsgSend.getType())) {
      return;
    }
    if (!$this().Context.hasSameUnqualifiedType(Method.getReturnType(), 
        $this().Context.getObjCInstanceType())) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.note_related_result_type_inferred)), 
                Method.isInstanceMethod()), Method.getSelector()), 
        MsgSend.getType()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Given that we had incompatible pointer types in a return
/// statement, check whether we're in a method with a related result
/// type, and if so, emit a note describing what happened.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::EmitRelatedResultTypeNoteForReturn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 1439,
 FQN="clang::Sema::EmitRelatedResultTypeNoteForReturn", NM="_ZN5clang4Sema34EmitRelatedResultTypeNoteForReturnENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN5clang4Sema34EmitRelatedResultTypeNoteForReturnENS_8QualTypeE")
//</editor-fold>
public final void EmitRelatedResultTypeNoteForReturn(QualType destType) {
  // Only complain if we're in an ObjC method and the required return
  // type doesn't match the method's declared return type.
  ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl($this().CurContext);
  if (!(MD != null) || !MD.hasRelatedResultType()
     || $this().Context.hasSameUnqualifiedType(new QualType(destType), MD.getReturnType())) {
    return;
  }
  {
    
    // Look for a method overridden by this method which explicitly uses
    // 'instancetype'.
    /*const*/ ObjCMethodDecl /*P*/ overridden = findExplicitInstancetypeDeclarer(MD, $this().Context.getObjCInstanceType());
    if ((overridden != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceRange range = overridden.getReturnTypeSourceRange();
        SourceLocation loc = range.getBegin();
        if (loc.isInvalid()) {
          loc.$assignMove(overridden.getLocation());
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(loc), diag.note_related_result_type_explicit)), 
                /*current method*/ 1), range));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  {
    
    // Otherwise, if we have an interesting method family, note that.
    // This should always trigger if the above didn't.
    ObjCMethodFamily family = MD.getMethodFamily();
    if ((family.getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.note_related_result_type_family)), 
                /*current method*/ 1), 
            family));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

} // END OF class Sema_SemaExprObjC
