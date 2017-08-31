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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.AstMemberPointers.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.CapturingScopeInfo.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaExprCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL10CheckArrowRN5clang4SemaERNS_8QualTypeERPNS_4ExprERNS_3tok9TokenKindENS_14SourceLocationE;_ZL11captureThisRN5clang4SemaERNS_10ASTContextEPNS_10RecordDeclENS_8QualTypeENS_14SourceLocationEb;_ZL15attemptRecoveryRN5clang4SemaERKNS_22TypoCorrectionConsumerERKNS_14TypoCorrectionE;_ZL17evaluateTypeTraitRN5clang4SemaENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES3_;_ZL17getUuidAttrOfTypeRN5clang4SemaENS_8QualTypeERN4llvm14SmallSetVectorIPKNS_8UuidAttrELj1EEE;_ZL18HasNoThrowOperatorPKN5clang10RecordTypeENS_22OverloadedOperatorKindERNS_4SemaENS_14SourceLocationERNS_10ASTContextEMNS_13CXXRecordDeclEKFbvESB_MNS_13CXXMethodDeclEKFbvE;_ZL18collectPublicBasesPN5clang13CXXRecordDeclERN4llvm8DenseMapIS1_jNS2_12DenseMapInfoIS1_EENS2_6detail12DenseMapPairIS1_jEEEERNS2_15SmallPtrSetImplIS1_EERNS2_9SetVectorIS1_St6vectorIS1_SaIS1_EENS2_8DenseSetIS1_S5_EEEEb;_ZL18noteOperatorArrowsRN5clang4SemaEN4llvm8ArrayRefIPNS_12FunctionDeclEEE;_ZL19TryClassUnificationRN5clang4SemaEPNS_4ExprES3_NS_14SourceLocationERbRNS_8QualTypeE;_ZL20BuildCXXCastArgumentRN5clang4SemaENS_14SourceLocationENS_8QualTypeENS_8CastKindEPNS_13CXXMethodDeclENS_14DeclAccessPairEbPNS_4ExprE;_ZL21ConvertForConditionalRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE;_ZL22EvaluateArrayTypeTraitRN5clang4SemaENS_14ArrayTypeTraitENS_8QualTypeEPNS_4ExprENS_14SourceLocationE;_ZL22EvaluateUnaryTypeTraitRN5clang4SemaENS_9TypeTraitENS_14SourceLocationENS_8QualTypeE;_ZL23EvaluateBinaryTypeTraitRN5clang4SemaENS_9TypeTraitENS_8QualTypeES3_NS_14SourceLocationE;_ZL23EvaluateExpressionTraitN5clang15ExpressionTraitEPNS_4ExprE;_ZL23FindConditionalOverloadRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE;_ZL23IsSpecialDiscardedValuePN5clang4ExprE;_ZL25hasNontrivialObjCLifetimeN5clang8QualTypeE;_ZL26isLegalArrayNewInitializerN5clang10CXXNewExpr19InitializationStyleEPNS_4ExprE;_ZL27DiagnoseMismatchedNewDeleteRN5clang4SemaENS_14SourceLocationERKN12_GLOBAL__N_128MismatchingNewDeleteDetectorE;_ZL28doesUsualArrayDeleteWantSizeRN5clang4SemaENS_14SourceLocationENS_8QualTypeE;_ZL30getUnambiguousPublicSubobjectsPN5clang13CXXRecordDeclERN4llvm15SmallVectorImplIS1_EE;_ZL34isNonPlacementDeallocationFunctionRN5clang4SemaEPNS_12FunctionDeclE;_ZL35CheckUnaryTypeTraitTypeCompletenessRN5clang4SemaENS_9TypeTraitENS_14SourceLocationENS_8QualTypeE;_ZL37VariableCanNeverBeAConstantExpressionPN5clang7VarDeclERNS_10ASTContextE;_ZL40adjustCVQualifiersForCXXThisWithinLambdaN4llvm8ArrayRefIPN5clang4sema17FunctionScopeInfoEEENS1_8QualTypeEPNS1_11DeclContextERNS1_10ASTContextE;_ZL57CheckIfAnyEnclosingLambdasMustCaptureAnyPotentialCapturesPN5clang4ExprEPNS_4sema15LambdaScopeInfoERNS_4SemaE; -static-type=SemaExprCXXStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaExprCXXStatics {


/// Grabs __declspec(uuid()) off a type, or returns 0 if we cannot resolve to
/// a single GUID.
//<editor-fold defaultstate="collapsed" desc="getUuidAttrOfType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 513,
 FQN="getUuidAttrOfType", NM="_ZL17getUuidAttrOfTypeRN5clang4SemaENS_8QualTypeERN4llvm14SmallSetVectorIPKNS_8UuidAttrELj1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL17getUuidAttrOfTypeRN5clang4SemaENS_8QualTypeERN4llvm14SmallSetVectorIPKNS_8UuidAttrELj1EEE")
//</editor-fold>
public static void getUuidAttrOfType(final Sema /*&*/ SemaRef, QualType QT, 
                 final SmallSetVector</*const*/ UuidAttr /*P*/ > /*&*/ UuidAttrs) {
  // Optionally remove one level of pointer, reference or array indirection.
  /*const*/ Type /*P*/ Ty = QT.getTypePtr();
  if (QT.$arrow().isPointerType() || QT.$arrow().isReferenceType()) {
    Ty = QT.$arrow().getPointeeType().getTypePtr();
  } else if (QT.$arrow().isArrayType()) {
    Ty = Ty.getBaseElementTypeUnsafe();
  }
  
  /*const*/ CXXRecordDecl /*P*/ RD = Ty.getAsCXXRecordDecl();
  if (!(RD != null)) {
    return;
  }
  {
    
    /*const*/ UuidAttr /*P*/ Uuid = RD.getMostRecentDecl$Const().getAttr(UuidAttr.class);
    if ((Uuid != null)) {
      UuidAttrs.insert(Uuid);
      return;
    }
  }
  {
    
    // __uuidof can grab UUIDs from template arguments.
    /*const*/ ClassTemplateSpecializationDecl /*P*/ CTSD = dyn_cast_ClassTemplateSpecializationDecl(RD);
    if ((CTSD != null)) {
      final /*const*/ TemplateArgumentList /*&*/ TAL = CTSD.getTemplateArgs();
      for (final /*const*/ TemplateArgument /*&*/ TA : TAL.asArray()) {
        /*const*/ UuidAttr /*P*/ UuidForTA = null;
        if (TA.getKind() == TemplateArgument.ArgKind.Type) {
          getUuidAttrOfType(SemaRef, TA.getAsType(), UuidAttrs);
        } else if (TA.getKind() == TemplateArgument.ArgKind.Declaration) {
          getUuidAttrOfType(SemaRef, TA.getAsDecl().getType(), UuidAttrs);
        }
        if ((UuidForTA != null)) {
          UuidAttrs.insert(UuidForTA);
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="collectPublicBases">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 727,
 FQN="collectPublicBases", NM="_ZL18collectPublicBasesPN5clang13CXXRecordDeclERN4llvm8DenseMapIS1_jNS2_12DenseMapInfoIS1_EENS2_6detail12DenseMapPairIS1_jEEEERNS2_15SmallPtrSetImplIS1_EERNS2_9SetVectorIS1_St6vectorIS1_SaIS1_EENS2_8DenseSetIS1_S5_EEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL18collectPublicBasesPN5clang13CXXRecordDeclERN4llvm8DenseMapIS1_jNS2_12DenseMapInfoIS1_EENS2_6detail12DenseMapPairIS1_jEEEERNS2_15SmallPtrSetImplIS1_EERNS2_9SetVectorIS1_St6vectorIS1_SaIS1_EENS2_8DenseSetIS1_S5_EEEEb")
//</editor-fold>
public static void collectPublicBases(CXXRecordDecl /*P*/ RD, 
                  final DenseMapTypeUInt<CXXRecordDecl /*P*/ > /*&*/ SubobjectsSeen, 
                  final SmallPtrSetImpl<CXXRecordDecl /*P*/ > /*&*/ VBases, 
                  final SetVector<CXXRecordDecl /*P*/ > /*&*/ PublicSubobjectsSeen, 
                  boolean ParentIsPublic) {
  for (final /*const*/ CXXBaseSpecifier /*&*/ BS : RD.bases()) {
    CXXRecordDecl /*P*/ BaseDecl = BS.getType().$arrow().getAsCXXRecordDecl();
    boolean NewSubobject;
    // Virtual bases constitute the same subobject.  Non-virtual bases are
    // always distinct subobjects.
    if (BS.isVirtual()) {
      NewSubobject = VBases.insert(BaseDecl).second;
    } else {
      NewSubobject = true;
    }
    if (NewSubobject) {
      /*++*/SubobjectsSeen./*$at_T1$C$R*/ref$at(BaseDecl).$set$preInc();
    }
    
    // Only add subobjects which have public access throughout the entire chain.
    boolean PublicPath = ParentIsPublic && BS.getAccessSpecifier() == AccessSpecifier.AS_public;
    if (PublicPath) {
      PublicSubobjectsSeen.insert(BaseDecl);
    }
    
    // Recurse on to each base subobject.
    collectPublicBases(BaseDecl, SubobjectsSeen, VBases, PublicSubobjectsSeen, 
        PublicPath);
  }
}

//<editor-fold defaultstate="collapsed" desc="getUnambiguousPublicSubobjects">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 757,
 FQN="getUnambiguousPublicSubobjects", NM="_ZL30getUnambiguousPublicSubobjectsPN5clang13CXXRecordDeclERN4llvm15SmallVectorImplIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL30getUnambiguousPublicSubobjectsPN5clang13CXXRecordDeclERN4llvm15SmallVectorImplIS1_EE")
//</editor-fold>
public static void getUnambiguousPublicSubobjects(CXXRecordDecl /*P*/ RD, final SmallVectorImpl<CXXRecordDecl /*P*/ > /*&*/ Objects) {
  SmallSetT$PLess$T$P<CXXRecordDecl /*P*/ > VBases = null;
  SetVector<CXXRecordDecl /*P*/ > PublicSubobjectsSeen = null;
  try {
    DenseMapTypeUInt<CXXRecordDecl /*P*/ > SubobjectsSeen/*J*/= new DenseMapTypeUInt<CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    VBases/*J*/= new SmallSetT$PLess$T$P<CXXRecordDecl /*P*/ >(2);
    PublicSubobjectsSeen/*J*/= new SetVector<CXXRecordDecl /*P*/ >((CXXRecordDecl /*P*/ )null);
    SubobjectsSeen.$set(RD, 1);
    PublicSubobjectsSeen.insert(RD);
    collectPublicBases(RD, SubobjectsSeen, VBases, PublicSubobjectsSeen, 
        /*ParentIsPublic=*/ true);
    
    for (CXXRecordDecl /*P*/ PublicSubobject : PublicSubobjectsSeen) {
      // Skip ambiguous objects.
      if ($greater_uint(SubobjectsSeen.$at_T1$C$R(PublicSubobject), 1)) {
        continue;
      }
      
      Objects.push_back(PublicSubobject);
    }
  } finally {
    if (PublicSubobjectsSeen != null) { PublicSubobjectsSeen.$destroy(); }
    if (VBases != null) { VBases.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="adjustCVQualifiersForCXXThisWithinLambda">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 875,
 FQN="adjustCVQualifiersForCXXThisWithinLambda", NM="_ZL40adjustCVQualifiersForCXXThisWithinLambdaN4llvm8ArrayRefIPN5clang4sema17FunctionScopeInfoEEENS1_8QualTypeEPNS1_11DeclContextERNS1_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL40adjustCVQualifiersForCXXThisWithinLambdaN4llvm8ArrayRefIPN5clang4sema17FunctionScopeInfoEEENS1_8QualTypeEPNS1_11DeclContextERNS1_10ASTContextE")
//</editor-fold>
public static QualType adjustCVQualifiersForCXXThisWithinLambda(ArrayRef<FunctionScopeInfo /*P*/ > FunctionScopes, QualType ThisTy, 
                                        DeclContext /*P*/ CurSemaContext, final ASTContext /*&*/ ASTCtx) {
  
  QualType ClassType = ThisTy.$arrow().getPointeeType();
  LambdaScopeInfo /*P*/ CurLSI = null;
  DeclContext /*P*/ CurDC = CurSemaContext;
  
  // Iterate through the stack of lambdas starting from the innermost lambda to
  // the outermost lambda, checking if '*this' is ever captured by copy - since
  // that could change the cv-qualifiers of the '*this' object.
  // The object referred to by '*this' starts out with the cv-qualifiers of its
  // member function.  We then start with the innermost lambda and iterate
  // outward checking to see if any lambda performs a by-copy capture of '*this'
  // - and if so, any nested lambda must respect the 'constness' of that
  // capturing lamdbda's call operator.
  //
  
  // The issue is that we cannot rely entirely on the FunctionScopeInfo stack
  // since ScopeInfos are pushed on during parsing and treetransforming. But
  // since a generic lambda's call operator can be instantiated anywhere (even
  // end of the TU) we need to be able to examine its enclosing lambdas and so
  // we use the DeclContext to get a hold of the closure-class and query it for
  // capture information.  The reason we don't just resort to always using the
  // DeclContext chain is that it is only mature for lambda expressions
  // enclosing generic lambda's call operators that are being instantiated.
  for (int I = FunctionScopes.size();
       ((I--) != 0) && isa_LambdaScopeInfo(FunctionScopes.$at(I));
       CurDC = getLambdaAwareParentOfDeclContext(CurDC)) {
    CurLSI = cast_LambdaScopeInfo(FunctionScopes.$at(I));
    if (!CurLSI.isCXXThisCaptured()) {
      continue;
    }
    
    Capture C = new Capture(CurLSI.getCXXThisCapture());
    if (C.isCopyCapture()) {
      ClassType.removeLocalCVRQualifiers(Qualifiers.TQ.CVRMask);
      if (CurLSI.CallOperator.isConst()) {
        ClassType.addConst();
      }
      return ASTCtx.getPointerType(new QualType(ClassType));
    }
  }
  // We've run out of ScopeInfos but check if CurDC is a lambda (which can
  // happen during instantiation of generic lambdas)
  if (isLambdaCallOperator(CurDC)) {
    assert Native.$bool(CurLSI);
    assert (isGenericLambdaCallOperatorSpecialization(CurLSI.CallOperator));
    assert (CurDC == getLambdaAwareParentOfDeclContext(CurLSI.CallOperator));
    
    CXXRecordDeclBoolRefBoolRef2Bool IsThisCaptured = /*[]*/ (CXXRecordDecl /*P*/ Closure, final bool$ref/*bool &*/ IsByCopy, final bool$ref/*bool &*/ IsConst) -> {
          IsConst.$set(false);
          IsByCopy.$set(false);
          for (final /*const*/ LambdaCapture /*&*/ /*&*/ C : Closure.captures()) {
            if (C.capturesThis()) {
              if (C.getCaptureKind() == LambdaCaptureKind.LCK_StarThis) {
                IsByCopy.$set(true);
              }
              if (Closure.getLambdaCallOperator().isConst()) {
                IsConst.$set(true);
              }
              return true;
            }
          }
          return false;
        };
    
    bool$ref IsByCopyCapture = create_bool$ref(false);
    bool$ref IsConstCapture = create_bool$ref(false);
    CXXRecordDecl /*P*/ Closure = cast_CXXRecordDecl(CurDC.getParent());
    while ((Closure != null)
       && IsThisCaptured.$call(Closure, /*KEEP_BOOL*/IsByCopyCapture, /*KEEP_BOOL*/IsConstCapture)) {
      if (IsByCopyCapture.$deref()) {
        ClassType.removeLocalCVRQualifiers(Qualifiers.TQ.CVRMask);
        if (IsConstCapture.$deref()) {
          ClassType.addConst();
        }
        return ASTCtx.getPointerType(new QualType(ClassType));
      }
      Closure = isLambdaCallOperator(Closure.getParent()) ? cast_CXXRecordDecl(Closure.getParent().getParent()) : null;
    }
  }
  return ASTCtx.getPointerType(new QualType(ClassType));
}

//<editor-fold defaultstate="collapsed" desc="captureThis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1026,
 FQN="captureThis", NM="_ZL11captureThisRN5clang4SemaERNS_10ASTContextEPNS_10RecordDeclENS_8QualTypeENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL11captureThisRN5clang4SemaERNS_10ASTContextEPNS_10RecordDeclENS_8QualTypeENS_14SourceLocationEb")
//</editor-fold>
public static Expr /*P*/ captureThis(final Sema /*&*/ S, final ASTContext /*&*/ Context, RecordDecl /*P*/ RD, 
           QualType ThisTy, SourceLocation Loc, 
           /*const*/boolean ByCopy) {
  
  QualType AdjustedThisTy = new QualType(ThisTy);
  // The type of the corresponding data member (not a 'this' pointer if 'by
  // copy').
  QualType CaptureThisFieldTy = new QualType(ThisTy);
  if (ByCopy) {
    // If we are capturing the object referred to by '*this' by copy, ignore any
    // cv qualifiers inherited from the type of the member function for the type
    // of the closure-type's corresponding data member and any use of 'this'.
    CaptureThisFieldTy.$assignMove(ThisTy.$arrow().getPointeeType());
    CaptureThisFieldTy.removeLocalCVRQualifiers(Qualifiers.TQ.CVRMask);
    AdjustedThisTy.$assignMove(Context.getPointerType(new QualType(CaptureThisFieldTy)));
  }
  
  FieldDecl /*P*/ Field = FieldDecl.Create(Context, RD, new SourceLocation(Loc), new SourceLocation(Loc), (IdentifierInfo /*P*/ )null, new QualType(CaptureThisFieldTy), 
      Context.getTrivialTypeSourceInfo(new QualType(CaptureThisFieldTy), new SourceLocation(Loc)), (Expr /*P*/ )null, false, 
      InClassInitStyle.ICIS_NoInit);
  
  Field.setImplicit(true);
  Field.setAccess(AccessSpecifier.AS_private);
  RD.addDecl(Field);
  Expr /*P*/ This = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->new CXXThisExpr(new SourceLocation(Loc), new QualType(ThisTy), /*isImplicit*/ true));
  if (ByCopy) {
    InitializationSequence Init = null;
    try {
      Expr /*P*/ StarThis = S.CreateBuiltinUnaryOp(new SourceLocation(Loc), 
          UnaryOperatorKind.UO_Deref, 
          This).get();
      InitializedEntity Entity = InitializedEntity.InitializeLambdaCapture((IdentifierInfo /*P*/ )null, new QualType(CaptureThisFieldTy), new SourceLocation(Loc));
      InitializationKind InitKind = InitializationKind.CreateDirect(new SourceLocation(Loc), new SourceLocation(Loc), new SourceLocation(Loc));
      Init/*J*/= new InitializationSequence(S, Entity, InitKind, new MutableArrayRef<Expr /*P*/ >(StarThis, true));
      ActionResultTTrue<Expr /*P*/ > ER = Init.Perform(S, Entity, InitKind, new MutableArrayRef<Expr /*P*/ >(StarThis, true));
      if (ER.isInvalid()) {
        return null;
      }
      return ER.get();
    } finally {
      if (Init != null) { Init.$destroy(); }
    }
  }
  return This;
}


/// doesUsualArrayDeleteWantSize - Answers whether the usual
/// operator delete[] for the given type has a size_t parameter.
//<editor-fold defaultstate="collapsed" desc="doesUsualArrayDeleteWantSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1322,
 FQN="doesUsualArrayDeleteWantSize", NM="_ZL28doesUsualArrayDeleteWantSizeRN5clang4SemaENS_14SourceLocationENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL28doesUsualArrayDeleteWantSizeRN5clang4SemaENS_14SourceLocationENS_8QualTypeE")
//</editor-fold>
public static boolean doesUsualArrayDeleteWantSize(final Sema /*&*/ S, SourceLocation loc, 
                            QualType allocType) {
  LookupResult ops = null;
  LookupResult.Filter filter = null;
  try {
    /*const*/ RecordType /*P*/ record = allocType.$arrow().getBaseElementTypeUnsafe().<RecordType>getAs$RecordType();
    if (!(record != null)) {
      return false;
    }
    
    // Try to find an operator delete[] in class scope.
    DeclarationName deleteName = S.Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Array_Delete);
    ops/*J*/= new LookupResult(S, new DeclarationName(deleteName), new SourceLocation(loc), Sema.LookupNameKind.LookupOrdinaryName);
    S.LookupQualifiedName(ops, record.getDecl());
    
    // We're just doing this for information.
    ops.suppressDiagnostics();
    
    // Very likely: there's no operator delete[].
    if (ops.empty()) {
      return false;
    }
    
    // If it's ambiguous, it should be illegal to call operator delete[]
    // on this thing, so it doesn't matter if we allocate extra space or not.
    if (ops.isAmbiguous()) {
      return false;
    }
    
    filter = ops.makeFilter();
    while (filter.hasNext()) {
      NamedDecl /*P*/ del = filter.next().getUnderlyingDecl();
      
      // C++0x [basic.stc.dynamic.deallocation]p2:
      //   A template instance is never a usual deallocation function,
      //   regardless of its signature.
      if (isa_FunctionTemplateDecl(del)) {
        filter.erase();
        continue;
      }
      
      // C++0x [basic.stc.dynamic.deallocation]p2:
      //   If class T does not declare [an operator delete[] with one
      //   parameter] but does declare a member deallocation function
      //   named operator delete[] with exactly two parameters, the
      //   second of which has type std::size_t, then this function
      //   is a usual deallocation function.
      if (!cast_CXXMethodDecl(del).isUsualDeallocationFunction()) {
        filter.erase();
        continue;
      }
    }
    filter.done();
    if (!ops.isSingleResult()) {
      return false;
    }
    
    /*const*/ FunctionDecl /*P*/ del = cast_FunctionDecl(ops.getFoundDecl());
    return (del.getNumParams() == 2);
  } finally {
    if (filter != null) { filter.$destroy(); }
    if (ops != null) { ops.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="isLegalArrayNewInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1473,
 FQN="isLegalArrayNewInitializer", NM="_ZL26isLegalArrayNewInitializerN5clang10CXXNewExpr19InitializationStyleEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL26isLegalArrayNewInitializerN5clang10CXXNewExpr19InitializationStyleEPNS_4ExprE")
//</editor-fold>
public static boolean isLegalArrayNewInitializer(CXXNewExpr.InitializationStyle Style, 
                          Expr /*P*/ Init) {
  if (!(Init != null)) {
    return true;
  }
  {
    ParenListExpr /*P*/ PLE = dyn_cast_ParenListExpr(Init);
    if ((PLE != null)) {
      return PLE.getNumExprs() == 0;
    }
  }
  if (isa_ImplicitValueInitExpr(Init)) {
    return true;
  } else {
    CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(Init);
    if ((CCE != null)) {
      return !CCE.isListInitialization()
         && CCE.getConstructor().isDefaultConstructor();
    } else if (Style == CXXNewExpr.InitializationStyle.ListInit) {
      assert (isa_InitListExpr(Init)) : "Shouldn't create list CXXConstructExprs for arrays.";
      return true;
    }
  }
  return false;
}


/// \brief Determine whether the given function is a non-placement
/// deallocation function.
//<editor-fold defaultstate="collapsed" desc="isNonPlacementDeallocationFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1930,
 FQN="isNonPlacementDeallocationFunction", NM="_ZL34isNonPlacementDeallocationFunctionRN5clang4SemaEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL34isNonPlacementDeallocationFunctionRN5clang4SemaEPNS_12FunctionDeclE")
//</editor-fold>
public static boolean isNonPlacementDeallocationFunction(final Sema /*&*/ S, FunctionDecl /*P*/ FD) {
  if (FD.isInvalidDecl()) {
    return false;
  }
  {
    
    CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(FD);
    if ((Method != null)) {
      return Method.isUsualDeallocationFunction();
    }
  }
  if (FD.getOverloadedOperator() != OverloadedOperatorKind.OO_Delete
     && FD.getOverloadedOperator() != OverloadedOperatorKind.OO_Array_Delete) {
    return false;
  }
  if (FD.getNumParams() == 1) {
    return true;
  }
  
  return S.getLangOpts().SizedDeallocation && FD.getNumParams() == 2
     && S.Context.hasSameUnqualifiedType(FD.getParamDecl(1).getType(), 
      S.Context.getSizeType().$QualType());
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseMismatchedNewDelete">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2772,
 FQN="DiagnoseMismatchedNewDelete", NM="_ZL27DiagnoseMismatchedNewDeleteRN5clang4SemaENS_14SourceLocationERKN12_GLOBAL__N_128MismatchingNewDeleteDetectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL27DiagnoseMismatchedNewDeleteRN5clang4SemaENS_14SourceLocationERKN12_GLOBAL__N_128MismatchingNewDeleteDetectorE")
//</editor-fold>
public static void DiagnoseMismatchedNewDelete(final Sema /*&*/ SemaRef, SourceLocation DeleteLoc, 
                           final /*const*/ MismatchingNewDeleteDetector /*&*/ Detector) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceLocation EndOfDelete = SemaRef.getLocForEndOfToken(new SourceLocation(DeleteLoc));
    FixItHint H/*J*/= new FixItHint();
    if (!Detector.IsArrayForm) {
      H.$assignMove(FixItHint.CreateInsertion(/*NO_COPY*/EndOfDelete, new StringRef(/*KEEP_STR*/$LSQUARE_RSQUARE)));
    } else {
      SourceLocation RSquare = Lexer.findLocationAfterToken(new SourceLocation(DeleteLoc), tok.TokenKind.l_square, SemaRef.getSourceManager(), 
          SemaRef.getLangOpts(), true);
      if (RSquare.isValid()) {
        H.$assignMove(FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/EndOfDelete, /*NO_COPY*/RSquare)));
      }
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(DeleteLoc), diag.warn_mismatched_delete_new)), 
            Detector.IsArrayForm), H));
    
    for (/*const*/ CXXNewExpr /*P*/ NE : Detector.NewExprs)  {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(NE.getExprLoc(), diag.note_allocated_here)), 
          Detector.IsArrayForm));
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="BuildCXXCastArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3169,
 FQN="BuildCXXCastArgument", NM="_ZL20BuildCXXCastArgumentRN5clang4SemaENS_14SourceLocationENS_8QualTypeENS_8CastKindEPNS_13CXXMethodDeclENS_14DeclAccessPairEbPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL20BuildCXXCastArgumentRN5clang4SemaENS_14SourceLocationENS_8QualTypeENS_8CastKindEPNS_13CXXMethodDeclENS_14DeclAccessPairEbPNS_4ExprE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > BuildCXXCastArgument(final Sema /*&*/ S, 
                    SourceLocation CastLoc, 
                    QualType Ty, 
                    CastKind Kind, 
                    CXXMethodDecl /*P*/ Method, 
                    DeclAccessPair FoundDecl, 
                    boolean HadMultipleCandidates, 
                    Expr /*P*/ From) {
  switch (Kind) {
   default:
    throw new llvm_unreachable("Unhandled cast kind!");
   case CK_ConstructorConversion:
    {
      CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(Method);
      SmallVector<Expr /*P*/ > ConstructorArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
      if (S.RequireNonAbstractType$T(new SourceLocation(CastLoc), new QualType(Ty), 
          diag.err_allocation_of_abstract_type)) {
        return ExprError();
      }
      if (S.CompleteConstructorCall(Constructor, new MutableArrayRef<Expr /*P*/ >(From, true), new SourceLocation(CastLoc), ConstructorArgs)) {
        return ExprError();
      }
      
      S.CheckConstructorAccess(new SourceLocation(CastLoc), Constructor, new DeclAccessPair(FoundDecl), 
          InitializedEntity.InitializeTemporary(new QualType(Ty)));
      if (S.DiagnoseUseOfDecl(Method, new SourceLocation(CastLoc))) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Result = S.BuildCXXConstructExpr(new SourceLocation(CastLoc), new QualType(Ty), FoundDecl.$NamedDecl$P(), cast_CXXConstructorDecl(Method), 
          new MutableArrayRef<Expr /*P*/ >(ConstructorArgs, true), HadMultipleCandidates, 
          /*ListInit*/ false, /*StdInitListInit*/ false, /*ZeroInit*/ false, 
          CXXConstructExpr.ConstructionKind.CK_Complete.getValue(), new SourceRange());
      if (Result.isInvalid()) {
        return ExprError();
      }
      
      return S.MaybeBindToTemporary(Result.getAs(Expr.class));
    }
   case CK_UserDefinedConversion:
    {
      assert (!From.getType().$arrow().isPointerType()) : "Arg can't have pointer type!";
      
      S.CheckMemberOperatorAccess(new SourceLocation(CastLoc), From, /*arg*/ (Expr /*P*/ )null, new DeclAccessPair(FoundDecl));
      if (S.DiagnoseUseOfDecl(Method, new SourceLocation(CastLoc))) {
        return ExprError();
      }
      
      // Create an implicit call expr that calls it.
      CXXConversionDecl /*P*/ Conv = cast_CXXConversionDecl(Method);
      ActionResultTTrue<Expr /*P*/ > Result = S.BuildCXXMemberCallExpr(From, FoundDecl.$NamedDecl$P(), Conv, 
          HadMultipleCandidates);
      if (Result.isInvalid()) {
        return ExprError();
      }
      // Record usage of conversion in an implicit cast.
      Result.$assign(ImplicitCastExpr.Create(S.Context, Result.get().getType(), 
              CastKind.CK_UserDefinedConversion, Result.get(), 
              (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, Result.get().getValueKind()));
      
      return S.MaybeBindToTemporary(Result.get());
    }
  }
}


/// \brief Check the completeness of a type in a unary type trait.
///
/// If the particular type trait requires a complete type, tries to complete
/// it. If completing the type fails, a diagnostic is emitted and false
/// returned. If completing the type succeeds or no completion was required,
/// returns true.
//<editor-fold defaultstate="collapsed" desc="CheckUnaryTypeTraitTypeCompleteness">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3763,
 FQN="CheckUnaryTypeTraitTypeCompleteness", NM="_ZL35CheckUnaryTypeTraitTypeCompletenessRN5clang4SemaENS_9TypeTraitENS_14SourceLocationENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL35CheckUnaryTypeTraitTypeCompletenessRN5clang4SemaENS_9TypeTraitENS_14SourceLocationENS_8QualTypeE")
//</editor-fold>
public static boolean CheckUnaryTypeTraitTypeCompleteness(final Sema /*&*/ S, TypeTrait UTT, 
                                   SourceLocation Loc, 
                                   QualType ArgTy) {
  // C++0x [meta.unary.prop]p3:
  //   For all of the class templates X declared in this Clause, instantiating
  //   that template with a template argument that is a class template
  //   specialization may result in the implicit instantiation of the template
  //   argument if and only if the semantics of X require that the argument
  //   must be a complete type.
  // We apply this rule to all the type trait expressions used to implement
  // these class templates. We also try to follow any GCC documented behavior
  // in these expressions to ensure portability of standard libraries.
  switch (UTT) {
   default:
    throw new llvm_unreachable("not a UTT");
   case UTT_IsCompleteType:
   case UTT_IsVoid:
   case UTT_IsIntegral:
   case UTT_IsFloatingPoint:
   case UTT_IsArray:
   case UTT_IsPointer:
   case UTT_IsLvalueReference:
   case UTT_IsRvalueReference:
   case UTT_IsMemberFunctionPointer:
   case UTT_IsMemberObjectPointer:
   case UTT_IsEnum:
   case UTT_IsUnion:
   case UTT_IsClass:
   case UTT_IsFunction:
   case UTT_IsReference:
   case UTT_IsArithmetic:
   case UTT_IsFundamental:
   case UTT_IsObject:
   case UTT_IsScalar:
   case UTT_IsCompound:
   case UTT_IsMemberPointer:
   case UTT_IsConst:
   case UTT_IsVolatile:
   case UTT_IsSigned:
   case UTT_IsUnsigned:
   case UTT_IsInterfaceClass:
    
    // This type trait always returns false, checking the type is moot.
    return true;
   case UTT_IsEmpty:
   case UTT_IsPolymorphic:
   case UTT_IsAbstract:
    {
      
      // C++14 [meta.unary.prop]:
      //   If T is a non-union class type, T shall be a complete type.
      /*const*/ CXXRecordDecl /*P*/ RD = ArgTy.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        if (!RD.isUnion()) {
          return !S.RequireCompleteType(new SourceLocation(Loc), new QualType(ArgTy), diag.err_incomplete_type_used_in_type_trait_expr);
        }
      }
    }
    return true;
   case UTT_IsFinal:
   case UTT_IsSealed:
    
    // C++14 [meta.unary.prop]:
    //   If T is a class type, T shall be a complete type.
    if ((ArgTy.$arrow().getAsCXXRecordDecl() != null)) {
      return !S.RequireCompleteType(new SourceLocation(Loc), new QualType(ArgTy), diag.err_incomplete_type_used_in_type_trait_expr);
    }
    return true;
   case UTT_IsTrivial:
   case UTT_IsTriviallyCopyable:
   case UTT_IsStandardLayout:
   case UTT_IsPOD:
   case UTT_IsLiteral:
   case UTT_IsDestructible:
   case UTT_IsNothrowDestructible:
   case UTT_HasNothrowAssign:
   case UTT_HasNothrowMoveAssign:
   case UTT_HasNothrowConstructor:
   case UTT_HasNothrowCopy:
   case UTT_HasTrivialAssign:
   case UTT_HasTrivialMoveAssign:
   case UTT_HasTrivialDefaultConstructor:
   case UTT_HasTrivialMoveConstructor:
   case UTT_HasTrivialCopy:
   case UTT_HasTrivialDestructor:
   case UTT_HasVirtualDestructor:
    // Arrays of unknown bound are expressly allowed.
    QualType ElTy = new QualType(ArgTy);
    if (ArgTy.$arrow().isIncompleteArrayType()) {
      ElTy.$assignMove(S.Context.getAsArrayType(new QualType(ArgTy)).getElementType());
    }
    
    // The void type is expressly allowed.
    if (ElTy.$arrow().isVoidType()) {
      return true;
    }
    
    return !S.RequireCompleteType(new SourceLocation(Loc), new QualType(ElTy), diag.err_incomplete_type_used_in_type_trait_expr);
  }
}

//<editor-fold defaultstate="collapsed" desc="HasNoThrowOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3883,
 FQN="HasNoThrowOperator", NM="_ZL18HasNoThrowOperatorPKN5clang10RecordTypeENS_22OverloadedOperatorKindERNS_4SemaENS_14SourceLocationERNS_10ASTContextEMNS_13CXXRecordDeclEKFbvESB_MNS_13CXXMethodDeclEKFbvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL18HasNoThrowOperatorPKN5clang10RecordTypeENS_22OverloadedOperatorKindERNS_4SemaENS_14SourceLocationERNS_10ASTContextEMNS_13CXXRecordDeclEKFbvESB_MNS_13CXXMethodDeclEKFbvE")
//</editor-fold>
public static boolean HasNoThrowOperator(/*const*/ RecordType /*P*/ RT, OverloadedOperatorKind Op, 
                  final Sema /*&*/ Self, SourceLocation KeyLoc, final ASTContext /*&*/ C, 
                  CXXRecordDecl$BoolPredicate HasTrivial, 
                  CXXRecordDecl$BoolPredicate HasNonTrivial, 
                  CXXMethodDecl$BoolPredicate IsDesiredOp) {
  LookupResult Res = null;
  try {
    CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
    if (HasTrivial.$call(/*PtrMemI*/RD) && !HasNonTrivial.$call(/*PtrMemI*/RD)) {
      return true;
    }
    
    DeclarationName Name = C.DeclarationNames.getCXXOperatorName(Op);
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(KeyLoc));
    Res/*J*/= new LookupResult(Self, NameInfo, Sema.LookupNameKind.LookupOrdinaryName);
    if (Self.LookupQualifiedName(Res, RD)) {
      boolean FoundOperator = false;
      Res.suppressDiagnostics();
      for (UnresolvedSetIterator Op$1 = Res.begin(), OpEnd = Res.end();
           Op$1.$noteq(OpEnd); Op$1.$preInc()) {
        if (isa_FunctionTemplateDecl(Op$1.$star())) {
          continue;
        }
        
        CXXMethodDecl /*P*/ Operator = cast_CXXMethodDecl(Op$1.$star());
        if (IsDesiredOp.$call(/*PtrMemI*/Operator)) {
          FoundOperator = true;
          /*const*/ FunctionProtoType /*P*/ CPT = Operator.getType().$arrow().getAs(FunctionProtoType.class);
          CPT = Self.ResolveExceptionSpec(new SourceLocation(KeyLoc), CPT);
          if (!(CPT != null) || !CPT.isNothrow(C)) {
            return false;
          }
        }
      }
      return FoundOperator;
    }
    return false;
  } finally {
    if (Res != null) { Res.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="EvaluateUnaryTypeTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3919,
 FQN="EvaluateUnaryTypeTrait", NM="_ZL22EvaluateUnaryTypeTraitRN5clang4SemaENS_9TypeTraitENS_14SourceLocationENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL22EvaluateUnaryTypeTraitRN5clang4SemaENS_9TypeTraitENS_14SourceLocationENS_8QualTypeE")
//</editor-fold>
public static boolean EvaluateUnaryTypeTrait(final Sema /*&*/ Self, TypeTrait UTT, 
                      SourceLocation KeyLoc, QualType T) {
  assert (!T.$arrow().isDependentType()) : "Cannot evaluate traits of dependent type";
  
  final ASTContext /*&*/ C = Self.Context;
  switch (UTT) {
   default:
    throw new llvm_unreachable("not a UTT");
   case UTT_IsVoid:
    // Type trait expressions corresponding to the primary type category
    // predicates in C++0x [meta.unary.cat].
    return T.$arrow().isVoidType();
   case UTT_IsIntegral:
    return T.$arrow().isIntegralType(C);
   case UTT_IsFloatingPoint:
    return T.$arrow().isFloatingType();
   case UTT_IsArray:
    return T.$arrow().isArrayType();
   case UTT_IsPointer:
    return T.$arrow().isPointerType();
   case UTT_IsLvalueReference:
    return T.$arrow().isLValueReferenceType();
   case UTT_IsRvalueReference:
    return T.$arrow().isRValueReferenceType();
   case UTT_IsMemberFunctionPointer:
    return T.$arrow().isMemberFunctionPointerType();
   case UTT_IsMemberObjectPointer:
    return T.$arrow().isMemberDataPointerType();
   case UTT_IsEnum:
    return T.$arrow().isEnumeralType();
   case UTT_IsUnion:
    return T.$arrow().isUnionType();
   case UTT_IsClass:
    return T.$arrow().isClassType() || T.$arrow().isStructureType() || T.$arrow().isInterfaceType();
   case UTT_IsFunction:
    return T.$arrow().isFunctionType();
   case UTT_IsReference:
    
    // Type trait expressions which correspond to the convenient composition
    // predicates in C++0x [meta.unary.comp].
    return T.$arrow().isReferenceType();
   case UTT_IsArithmetic:
    return T.$arrow().isArithmeticType() && !T.$arrow().isEnumeralType();
   case UTT_IsFundamental:
    return T.$arrow().isFundamentalType();
   case UTT_IsObject:
    return T.$arrow().isObjectType();
   case UTT_IsScalar:
    // Note: semantic analysis depends on Objective-C lifetime types to be
    // considered scalar types. However, such types do not actually behave
    // like scalar types at run time (since they may require retain/release
    // operations), so we report them as non-scalar.
    if (T.$arrow().isObjCLifetimeType()) {
      switch (T.getObjCLifetime()) {
       case OCL_None:
       case OCL_ExplicitNone:
        return true;
       case OCL_Strong:
       case OCL_Weak:
       case OCL_Autoreleasing:
        return false;
      }
    }
    
    return T.$arrow().isScalarType();
   case UTT_IsCompound:
    return T.$arrow().isCompoundType();
   case UTT_IsMemberPointer:
    return T.$arrow().isMemberPointerType();
   case UTT_IsConst:
    
    // Type trait expressions which correspond to the type property predicates
    // in C++0x [meta.unary.prop].
    return T.isConstQualified();
   case UTT_IsVolatile:
    return T.isVolatileQualified();
   case UTT_IsTrivial:
    return T.isTrivialType(C);
   case UTT_IsTriviallyCopyable:
    return T.isTriviallyCopyableType(C);
   case UTT_IsStandardLayout:
    return T.$arrow().isStandardLayoutType();
   case UTT_IsPOD:
    return T.isPODType(C);
   case UTT_IsLiteral:
    return T.$arrow().isLiteralType(C);
   case UTT_IsEmpty:
    {
      /*const*/ CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return !RD.isUnion() && RD.isEmpty();
      }
    }
    return false;
   case UTT_IsPolymorphic:
    {
      /*const*/ CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return !RD.isUnion() && RD.isPolymorphic();
      }
    }
    return false;
   case UTT_IsAbstract:
    {
      /*const*/ CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return !RD.isUnion() && RD.isAbstract();
      }
    }
    return false;
   case UTT_IsInterfaceClass:
    // __is_interface_class only returns true when CL is invoked in /CLR mode and
    // even then only when it is used with the 'interface struct ...' syntax
    // Clang doesn't support /CLR which makes this type trait moot.
    return false;
   case UTT_IsFinal:
   case UTT_IsSealed:
    {
      /*const*/ CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return RD.hasAttr(FinalAttr.class);
      }
    }
    return false;
   case UTT_IsSigned:
    return T.$arrow().isSignedIntegerType();
   case UTT_IsUnsigned:
    return T.$arrow().isUnsignedIntegerType();
   case UTT_HasTrivialDefaultConstructor:
    // http://gcc.gnu.org/onlinedocs/gcc/Type-Traits.html:
    //   If __is_pod (type) is true then the trait is true, else if type is
    //   a cv class or union type (or array thereof) with a trivial default
    //   constructor ([class.ctor]) then the trait is true, else it is false.
    if (T.isPODType(C)) {
      return true;
    }
    {
      CXXRecordDecl /*P*/ RD = C.getBaseElementType(new QualType(T)).$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return RD.hasTrivialDefaultConstructor()
           && !RD.hasNonTrivialDefaultConstructor();
      }
    }
    return false;
   case UTT_HasTrivialMoveConstructor:
    //  This trait is implemented by MSVC 2012 and needed to parse the
    //  standard library headers. Specifically this is used as the logic
    //  behind std::is_trivially_move_constructible (20.9.4.3).
    if (T.isPODType(C)) {
      return true;
    }
    {
      CXXRecordDecl /*P*/ RD = C.getBaseElementType(new QualType(T)).$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return RD.hasTrivialMoveConstructor() && !RD.hasNonTrivialMoveConstructor();
      }
    }
    return false;
   case UTT_HasTrivialCopy:
    // http://gcc.gnu.org/onlinedocs/gcc/Type-Traits.html:
    //   If __is_pod (type) is true or type is a reference type then
    //   the trait is true, else if type is a cv class or union type
    //   with a trivial copy constructor ([class.copy]) then the trait
    //   is true, else it is false.
    if (T.isPODType(C) || T.$arrow().isReferenceType()) {
      return true;
    }
    {
      CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return RD.hasTrivialCopyConstructor()
           && !RD.hasNonTrivialCopyConstructor();
      }
    }
    return false;
   case UTT_HasTrivialMoveAssign:
    //  This trait is implemented by MSVC 2012 and needed to parse the
    //  standard library headers. Specifically it is used as the logic
    //  behind std::is_trivially_move_assignable (20.9.4.3)
    if (T.isPODType(C)) {
      return true;
    }
    {
      CXXRecordDecl /*P*/ RD = C.getBaseElementType(new QualType(T)).$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return RD.hasTrivialMoveAssignment() && !RD.hasNonTrivialMoveAssignment();
      }
    }
    return false;
   case UTT_HasTrivialAssign:
    // http://gcc.gnu.org/onlinedocs/gcc/Type-Traits.html:
    //   If type is const qualified or is a reference type then the
    //   trait is false. Otherwise if __is_pod (type) is true then the
    //   trait is true, else if type is a cv class or union type with
    //   a trivial copy assignment ([class.copy]) then the trait is
    //   true, else it is false.
    // Note: the const and reference restrictions are interesting,
    // given that const and reference members don't prevent a class
    // from having a trivial copy assignment operator (but do cause
    // errors if the copy assignment operator is actually used, q.v.
    // [class.copy]p12).
    if (T.isConstQualified()) {
      return false;
    }
    if (T.isPODType(C)) {
      return true;
    }
    {
      CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return RD.hasTrivialCopyAssignment()
           && !RD.hasNonTrivialCopyAssignment();
      }
    }
    return false;
   case UTT_IsDestructible:
   case UTT_IsNothrowDestructible:
    // C++14 [meta.unary.prop]:
    //   For reference types, is_destructible<T>::value is true.
    if (T.$arrow().isReferenceType()) {
      return true;
    }
    
    // Objective-C++ ARC: autorelease types don't require destruction.
    if (T.$arrow().isObjCLifetimeType()
       && T.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Autoreleasing) {
      return true;
    }
    
    // C++14 [meta.unary.prop]:
    //   For incomplete types and function types, is_destructible<T>::value is
    //   false.
    if (T.$arrow().isIncompleteType() || T.$arrow().isFunctionType()) {
      return false;
    }
    {
      
      // C++14 [meta.unary.prop]:
      //   For object types and given U equal to remove_all_extents_t<T>, if the
      //   expression std::declval<U&>().~U() is well-formed when treated as an
      //   unevaluated operand (Clause 5), then is_destructible<T>::value is true
      CXXRecordDecl /*P*/ RD = C.getBaseElementType(new QualType(T)).$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        CXXDestructorDecl /*P*/ Destructor = Self.LookupDestructor(RD);
        if (!(Destructor != null)) {
          return false;
        }
        //  C++14 [dcl.fct.def.delete]p2:
        //    A program that refers to a deleted function implicitly or
        //    explicitly, other than to declare it, is ill-formed.
        if (Destructor.isDeleted()) {
          return false;
        }
        if (C.getLangOpts().AccessControl && Destructor.getAccess() != AccessSpecifier.AS_public) {
          return false;
        }
        if (UTT == TypeTrait.UTT_IsNothrowDestructible) {
          /*const*/ FunctionProtoType /*P*/ CPT = Destructor.getType().$arrow().getAs(FunctionProtoType.class);
          CPT = Self.ResolveExceptionSpec(new SourceLocation(KeyLoc), CPT);
          if (!(CPT != null) || !CPT.isNothrow(C)) {
            return false;
          }
        }
      }
    }
    return true;
   case UTT_HasTrivialDestructor:
    // http://gcc.gnu.org/onlinedocs/gcc/Type-Traits.html
    //   If __is_pod (type) is true or type is a reference type
    //   then the trait is true, else if type is a cv class or union
    //   type (or array thereof) with a trivial destructor
    //   ([class.dtor]) then the trait is true, else it is
    //   false.
    if (T.isPODType(C) || T.$arrow().isReferenceType()) {
      return true;
    }
    
    // Objective-C++ ARC: autorelease types don't require destruction.
    if (T.$arrow().isObjCLifetimeType()
       && T.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Autoreleasing) {
      return true;
    }
    {
      
      CXXRecordDecl /*P*/ RD = C.getBaseElementType(new QualType(T)).$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return RD.hasTrivialDestructor();
      }
    }
    return false;
   case UTT_HasNothrowAssign:
    // http://gcc.gnu.org/onlinedocs/gcc/Type-Traits.html:
    //   If type is const qualified or is a reference type then the
    //   trait is false. Otherwise if __has_trivial_assign (type)
    //   is true then the trait is true, else if type is a cv class
    //   or union type with copy assignment operators that are known
    //   not to throw an exception then the trait is true, else it is
    //   false.
    if (C.getBaseElementType(new QualType(T)).isConstQualified()) {
      return false;
    }
    if (T.$arrow().isReferenceType()) {
      return false;
    }
    if (T.isPODType(C) || T.$arrow().isObjCLifetimeType()) {
      return true;
    }
    {
      
      /*const*/ RecordType /*P*/ RT = T.$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        return HasNoThrowOperator(RT, OverloadedOperatorKind.OO_Equal, Self, new SourceLocation(KeyLoc), C, 
            /*AddrOf*//*FPtr*/CXXRecordDecl::hasTrivialCopyAssignment, 
            /*AddrOf*//*FPtr*/CXXRecordDecl::hasNonTrivialCopyAssignment, 
            /*AddrOf*//*FPtr*/CXXMethodDecl::isCopyAssignmentOperator);
      }
    }
    return false;
   case UTT_HasNothrowMoveAssign:
    //  This trait is implemented by MSVC 2012 and needed to parse the
    //  standard library headers. Specifically this is used as the logic
    //  behind std::is_nothrow_move_assignable (20.9.4.3).
    if (T.isPODType(C)) {
      return true;
    }
    {
      
      /*const*/ RecordType /*P*/ RT = C.getBaseElementType(new QualType(T)).$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        return HasNoThrowOperator(RT, OverloadedOperatorKind.OO_Equal, Self, new SourceLocation(KeyLoc), C, 
            /*AddrOf*//*FPtr*/CXXRecordDecl::hasTrivialMoveAssignment, 
            /*AddrOf*//*FPtr*/CXXRecordDecl::hasNonTrivialMoveAssignment, 
            /*AddrOf*//*FPtr*/CXXMethodDecl::isMoveAssignmentOperator);
      }
    }
    return false;
   case UTT_HasNothrowCopy:
    // http://gcc.gnu.org/onlinedocs/gcc/Type-Traits.html:
    //   If __has_trivial_copy (type) is true then the trait is true, else
    //   if type is a cv class or union type with copy constructors that are
    //   known not to throw an exception then the trait is true, else it is
    //   false.
    if (T.isPODType(C) || T.$arrow().isReferenceType() || T.$arrow().isObjCLifetimeType()) {
      return true;
    }
    {
      CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        if (RD.hasTrivialCopyConstructor()
           && !RD.hasNonTrivialCopyConstructor()) {
          return true;
        }
        
        boolean FoundConstructor = false;
        uint$ref FoundTQs = create_uint$ref();
        for (/*const*/ NamedDecl /*P*/ ND : Self.LookupConstructors(RD)) {
          // A template constructor is never a copy constructor.
          // FIXME: However, it may actually be selected at the actual overload
          // resolution point.
          if (isa_FunctionTemplateDecl(ND)) {
            continue;
          }
          /*const*/ CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(ND);
          if (Constructor.isCopyConstructor(FoundTQs)) {
            FoundConstructor = true;
            /*const*/ FunctionProtoType /*P*/ CPT = Constructor.getType().$arrow().getAs(FunctionProtoType.class);
            CPT = Self.ResolveExceptionSpec(new SourceLocation(KeyLoc), CPT);
            if (!(CPT != null)) {
              return false;
            }
            // TODO: check whether evaluating default arguments can throw.
            // For now, we'll be conservative and assume that they can throw.
            if (!CPT.isNothrow(C) || $greater_uint(CPT.getNumParams(), 1)) {
              return false;
            }
          }
        }
        
        return FoundConstructor;
      }
    }
    return false;
   case UTT_HasNothrowConstructor:
    // http://gcc.gnu.org/onlinedocs/gcc/Type-Traits.html
    //   If __has_trivial_constructor (type) is true then the trait is
    //   true, else if type is a cv class or union type (or array
    //   thereof) with a default constructor that is known not to
    //   throw an exception then the trait is true, else it is false.
    if (T.isPODType(C) || T.$arrow().isObjCLifetimeType()) {
      return true;
    }
    {
      CXXRecordDecl /*P*/ RD = C.getBaseElementType(new QualType(T)).$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        if (RD.hasTrivialDefaultConstructor()
           && !RD.hasNonTrivialDefaultConstructor()) {
          return true;
        }
        
        boolean FoundConstructor = false;
        for (/*const*/ NamedDecl /*P*/ ND : Self.LookupConstructors(RD)) {
          // FIXME: In C++0x, a constructor template can be a default constructor.
          if (isa_FunctionTemplateDecl(ND)) {
            continue;
          }
          /*const*/ CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(ND);
          if (Constructor.isDefaultConstructor()) {
            FoundConstructor = true;
            /*const*/ FunctionProtoType /*P*/ CPT = Constructor.getType().$arrow().getAs(FunctionProtoType.class);
            CPT = Self.ResolveExceptionSpec(new SourceLocation(KeyLoc), CPT);
            if (!(CPT != null)) {
              return false;
            }
            // FIXME: check whether evaluating default arguments can throw.
            // For now, we'll be conservative and assume that they can throw.
            if (!CPT.isNothrow(C) || $greater_uint(CPT.getNumParams(), 0)) {
              return false;
            }
          }
        }
        return FoundConstructor;
      }
    }
    return false;
   case UTT_HasVirtualDestructor:
    {
      // http://gcc.gnu.org/onlinedocs/gcc/Type-Traits.html:
      //   If type is a class type with a virtual destructor ([class.dtor])
      //   then the trait is true, else it is false.
      CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        {
          CXXDestructorDecl /*P*/ Destructor = Self.LookupDestructor(RD);
          if ((Destructor != null)) {
            return Destructor.isVirtual();
          }
        }
      }
    }
    return false;
   case UTT_IsCompleteType:
    // http://docwiki.embarcadero.com/RADStudio/XE/en/Is_complete_type_(typename_T_):
    //   Returns True if and only if T is a complete type at the point of the
    //   function call.
    return !T.$arrow().isIncompleteType();
  }
}


/// \brief Determine whether T has a non-trivial Objective-C lifetime in
/// ARC mode.
//<editor-fold defaultstate="collapsed" desc="hasNontrivialObjCLifetime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4301,
 FQN="hasNontrivialObjCLifetime", NM="_ZL25hasNontrivialObjCLifetimeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL25hasNontrivialObjCLifetimeN5clang8QualTypeE")
//</editor-fold>
public static boolean hasNontrivialObjCLifetime(QualType T) {
  switch (T.getObjCLifetime()) {
   case OCL_ExplicitNone:
    return false;
   case OCL_Strong:
   case OCL_Weak:
   case OCL_Autoreleasing:
    return true;
   case OCL_None:
    return T.$arrow().isObjCLifetimeType();
  }
  throw new llvm_unreachable("Unknown ObjC lifetime qualifier");
}

//<editor-fold defaultstate="collapsed" desc="EvaluateBinaryTypeTrait">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4474,
 FQN="EvaluateBinaryTypeTrait", NM="_ZL23EvaluateBinaryTypeTraitRN5clang4SemaENS_9TypeTraitENS_8QualTypeES3_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL23EvaluateBinaryTypeTraitRN5clang4SemaENS_9TypeTraitENS_8QualTypeES3_NS_14SourceLocationE")
//</editor-fold>
public static boolean EvaluateBinaryTypeTrait(final Sema /*&*/ Self, TypeTrait BTT, QualType LhsT, 
                       QualType RhsT, SourceLocation KeyLoc) {
  assert (!LhsT.$arrow().isDependentType() && !RhsT.$arrow().isDependentType()) : "Cannot evaluate traits of dependent types";
  switch (BTT) {
   case BTT_IsBaseOf:
    {
      // C++0x [meta.rel]p2
      // Base is a base class of Derived without regard to cv-qualifiers or
      // Base and Derived are not unions and name the same class type without
      // regard to cv-qualifiers.
      /*const*/ RecordType /*P*/ lhsRecord = LhsT.$arrow().<RecordType>getAs$RecordType();
      if (!(lhsRecord != null)) {
        return false;
      }
      
      /*const*/ RecordType /*P*/ rhsRecord = RhsT.$arrow().<RecordType>getAs$RecordType();
      if (!(rhsRecord != null)) {
        return false;
      }
      assert (Self.Context.hasSameUnqualifiedType(new QualType(LhsT), new QualType(RhsT)) == (lhsRecord == rhsRecord));
      if (lhsRecord == rhsRecord) {
        return !lhsRecord.getDecl().isUnion();
      }
      
      // C++0x [meta.rel]p2:
      //   If Base and Derived are class types and are different types
      //   (ignoring possible cv-qualifiers) then Derived shall be a
      //   complete type.
      if (Self.RequireCompleteType(new SourceLocation(KeyLoc), new QualType(RhsT), 
          diag.err_incomplete_type_used_in_type_trait_expr)) {
        return false;
      }
      
      return cast_CXXRecordDecl(rhsRecord.getDecl()).
          isDerivedFrom(cast_CXXRecordDecl(lhsRecord.getDecl()));
    }
   case BTT_IsSame:
    return Self.Context.hasSameType(new QualType(LhsT), new QualType(RhsT));
   case BTT_TypeCompatible:
    return Self.Context.typesAreCompatible(LhsT.getUnqualifiedType(), 
        RhsT.getUnqualifiedType());
   case BTT_IsConvertible:
   case BTT_IsConvertibleTo:
    {
      EnterExpressionEvaluationContext Unevaluated = null;
      Sema.SFINAETrap SFINAE = null;
      Sema.ContextRAII TUContext = null;
      InitializationSequence Init = null;
      try {
        // C++0x [meta.rel]p4:
        //   Given the following function prototype:
        //
        //     template <class T> 
        //       typename add_rvalue_reference<T>::type create();
        //
        //   the predicate condition for a template specialization 
        //   is_convertible<From, To> shall be satisfied if and only if 
        //   the return expression in the following code would be 
        //   well-formed, including any implicit conversions to the return
        //   type of the function:
        //
        //     To test() { 
        //       return create<From>();
        //     }
        //
        //   Access checking is performed as if in a context unrelated to To and 
        //   From. Only the validity of the immediate context of the expression 
        //   of the return-statement (including conversions to the return type)
        //   is considered.
        //
        // We model the initialization as a copy-initialization of a temporary
        // of the appropriate type, which for this expression is identical to the
        // return statement (since NRVO doesn't apply).
        
        // Functions aren't allowed to return function or array types.
        if (RhsT.$arrow().isFunctionType() || RhsT.$arrow().isArrayType()) {
          return false;
        }
        
        // A return statement in a void function must have void type.
        if (RhsT.$arrow().isVoidType()) {
          return LhsT.$arrow().isVoidType();
        }
        
        // A function definition requires a complete, non-abstract return type.
        if (!Self.isCompleteType(new SourceLocation(KeyLoc), new QualType(RhsT)) || Self.isAbstractType(new SourceLocation(KeyLoc), new QualType(RhsT))) {
          return false;
        }
        
        // Compute the result of add_rvalue_reference.
        if (LhsT.$arrow().isObjectType() || LhsT.$arrow().isFunctionType()) {
          LhsT.$assignMove(Self.Context.getRValueReferenceType(new QualType(LhsT)));
        }
        
        // Build a fake source and destination for initialization.
        InitializedEntity To/*J*/= InitializedEntity.InitializeTemporary(new QualType(RhsT));
        OpaqueValueExpr From/*J*/= new OpaqueValueExpr(new SourceLocation(KeyLoc), LhsT.getNonLValueExprType(Self.Context), 
            Expr.getValueKindForType(new QualType(LhsT)));
        Expr /*P*/ FromPtr = $AddrOf(From);
        InitializationKind Kind/*J*/= InitializationKind.CreateCopy(new SourceLocation(KeyLoc), 
            new SourceLocation());
        
        // Perform the initialization in an unevaluated context within a SFINAE 
        // trap at translation unit scope.
        Unevaluated/*J*/= new EnterExpressionEvaluationContext(Self, Sema.ExpressionEvaluationContext.Unevaluated);
        SFINAE/*J*/= new Sema.SFINAETrap(Self, /*AccessCheckingSFINAE=*/ true);
        TUContext/*J*/= new Sema.ContextRAII(Self, Self.Context.getTranslationUnitDecl());
        Init/*J*/= new InitializationSequence(Self, To, Kind, new MutableArrayRef<Expr /*P*/ >(FromPtr, true));
        if (Init.Failed()) {
          return false;
        }
        
        ActionResultTTrue<Expr /*P*/ > Result = Init.Perform(Self, To, Kind, new MutableArrayRef<Expr /*P*/ >(FromPtr, true));
        return !Result.isInvalid() && !SFINAE.hasErrorOccurred();
      } finally {
        if (Init != null) { Init.$destroy(); }
        if (TUContext != null) { TUContext.$destroy(); }
        if (SFINAE != null) { SFINAE.$destroy(); }
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
   case BTT_IsAssignable:
   case BTT_IsNothrowAssignable:
   case BTT_IsTriviallyAssignable:
    {
      EnterExpressionEvaluationContext Unevaluated = null;
      Sema.SFINAETrap SFINAE = null;
      Sema.ContextRAII TUContext = null;
      try {
        // C++11 [meta.unary.prop]p3:
        //   is_trivially_assignable is defined as:
        //     is_assignable<T, U>::value is true and the assignment, as defined by
        //     is_assignable, is known to call no operation that is not trivial
        //
        //   is_assignable is defined as:
        //     The expression declval<T>() = declval<U>() is well-formed when 
        //     treated as an unevaluated operand (Clause 5).
        //
        //   For both, T and U shall be complete types, (possibly cv-qualified) 
        //   void, or arrays of unknown bound.
        if (!LhsT.$arrow().isVoidType() && !LhsT.$arrow().isIncompleteArrayType()
           && Self.RequireCompleteType(new SourceLocation(KeyLoc), new QualType(LhsT), 
            diag.err_incomplete_type_used_in_type_trait_expr)) {
          return false;
        }
        if (!RhsT.$arrow().isVoidType() && !RhsT.$arrow().isIncompleteArrayType()
           && Self.RequireCompleteType(new SourceLocation(KeyLoc), new QualType(RhsT), 
            diag.err_incomplete_type_used_in_type_trait_expr)) {
          return false;
        }
        
        // cv void is never assignable.
        if (LhsT.$arrow().isVoidType() || RhsT.$arrow().isVoidType()) {
          return false;
        }
        
        // Build expressions that emulate the effect of declval<T>() and 
        // declval<U>().
        if (LhsT.$arrow().isObjectType() || LhsT.$arrow().isFunctionType()) {
          LhsT.$assignMove(Self.Context.getRValueReferenceType(new QualType(LhsT)));
        }
        if (RhsT.$arrow().isObjectType() || RhsT.$arrow().isFunctionType()) {
          RhsT.$assignMove(Self.Context.getRValueReferenceType(new QualType(RhsT)));
        }
        OpaqueValueExpr Lhs/*J*/= new OpaqueValueExpr(new SourceLocation(KeyLoc), LhsT.getNonLValueExprType(Self.Context), 
            Expr.getValueKindForType(new QualType(LhsT)));
        OpaqueValueExpr Rhs/*J*/= new OpaqueValueExpr(new SourceLocation(KeyLoc), RhsT.getNonLValueExprType(Self.Context), 
            Expr.getValueKindForType(new QualType(RhsT)));
        
        // Attempt the assignment in an unevaluated context within a SFINAE 
        // trap at translation unit scope.
        Unevaluated/*J*/= new EnterExpressionEvaluationContext(Self, Sema.ExpressionEvaluationContext.Unevaluated);
        SFINAE/*J*/= new Sema.SFINAETrap(Self, /*AccessCheckingSFINAE=*/ true);
        TUContext/*J*/= new Sema.ContextRAII(Self, Self.Context.getTranslationUnitDecl());
        ActionResultTTrue<Expr /*P*/ > Result = Self.BuildBinOp(/*S=*/ (Scope /*P*/ )null, new SourceLocation(KeyLoc), BinaryOperatorKind.BO_Assign, $AddrOf(Lhs), 
            $AddrOf(Rhs));
        if (Result.isInvalid() || SFINAE.hasErrorOccurred()) {
          return false;
        }
        if (BTT == TypeTrait.BTT_IsAssignable) {
          return true;
        }
        if (BTT == TypeTrait.BTT_IsNothrowAssignable) {
          return Self.canThrow(Result.get()) == CanThrowResult.CT_Cannot;
        }
        if (BTT == TypeTrait.BTT_IsTriviallyAssignable) {
          // Under Objective-C ARC, if the destination has non-trivial Objective-C
          // lifetime, this is a non-trivial assignment.
          if (Self.getLangOpts().ObjCAutoRefCount
             && hasNontrivialObjCLifetime(LhsT.getNonReferenceType())) {
            return false;
          }
          
          return !Result.get().hasNonTrivialCall(Self.Context);
        }
        throw new llvm_unreachable("unhandled type trait");
//        return false;
      } finally {
        if (TUContext != null) { TUContext.$destroy(); }
        if (SFINAE != null) { SFINAE.$destroy(); }
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
   default:
    throw new llvm_unreachable("not a BTT");
  }
  //throw new llvm_unreachable("Unknown type trait or not implemented");
}

//<editor-fold defaultstate="collapsed" desc="evaluateTypeTrait">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4321,
 FQN="evaluateTypeTrait", NM="_ZL17evaluateTypeTraitRN5clang4SemaENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL17evaluateTypeTraitRN5clang4SemaENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES3_")
//</editor-fold>
public static boolean evaluateTypeTrait(final Sema /*&*/ S, TypeTrait Kind, SourceLocation KWLoc, 
                 ArrayRef<TypeSourceInfo /*P*/ > Args, 
                 SourceLocation RParenLoc) {
  if (Kind.getValue() <= TypeTrait.UTT_Last.getValue()) {
    return EvaluateUnaryTypeTrait(S, Kind, new SourceLocation(KWLoc), Args.$at(0).getType());
  }
  if (Kind.getValue() <= TypeTrait.BTT_Last.getValue()) {
    return EvaluateBinaryTypeTrait(S, Kind, Args.$at(0).getType(), 
        Args.$at(1).getType(), new SourceLocation(RParenLoc));
  }
  switch (Kind) {
   case TT_IsConstructible:
   case TT_IsNothrowConstructible:
   case TT_IsTriviallyConstructible:
    {
      EnterExpressionEvaluationContext Unevaluated = null;
      Sema.SFINAETrap SFINAE = null;
      Sema.ContextRAII TUContext = null;
      InitializationSequence Init = null;
      try {
        // C++11 [meta.unary.prop]:
        //   is_trivially_constructible is defined as:
        //
        //     is_constructible<T, Args...>::value is true and the variable
        //     definition for is_constructible, as defined below, is known to call
        //     no operation that is not trivial.
        //
        //   The predicate condition for a template specialization 
        //   is_constructible<T, Args...> shall be satisfied if and only if the 
        //   following variable definition would be well-formed for some invented 
        //   variable t:
        //
        //     T t(create<Args>()...);
        assert (!Args.empty());
        
        // Precondition: T and all types in the parameter pack Args shall be
        // complete types, (possibly cv-qualified) void, or arrays of
        // unknown bound.
        for (/*const*/ TypeSourceInfo /*P*/ TSI : Args) {
          QualType ArgTy = TSI.getType();
          if (ArgTy.$arrow().isVoidType() || ArgTy.$arrow().isIncompleteArrayType()) {
            continue;
          }
          if (S.RequireCompleteType(new SourceLocation(KWLoc), new QualType(ArgTy), 
              diag.err_incomplete_type_used_in_type_trait_expr)) {
            return false;
          }
        }
        
        // Make sure the first argument is not incomplete nor a function type.
        QualType T = Args.$at(0).getType();
        if (T.$arrow().isIncompleteType() || T.$arrow().isFunctionType()) {
          return false;
        }
        
        // Make sure the first argument is not an abstract type.
        CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
        if ((RD != null) && RD.isAbstract()) {
          return false;
        }
        
        SmallVector<OpaqueValueExpr> OpaqueArgExprs/*J*/= new SmallVector<OpaqueValueExpr>(2, new OpaqueValueExpr());
        SmallVector<Expr /*P*/ > ArgExprs/*J*/= new SmallVector<Expr /*P*/ >(2, (Expr /*P*/ )null);
        ArgExprs.reserve(Args.size() - 1);
        for (/*uint*/int I = 1, N = Args.size(); I != N; ++I) {
          QualType ArgTy = Args.$at(I).getType();
          if (ArgTy.$arrow().isObjectType() || ArgTy.$arrow().isFunctionType()) {
            ArgTy.$assignMove(S.Context.getRValueReferenceType(new QualType(ArgTy)));
          }
          OpaqueArgExprs.push_back(new OpaqueValueExpr(Args.$at(I).getTypeLoc().getLocStart(), 
                  ArgTy.getNonLValueExprType(S.Context), 
                  Expr.getValueKindForType(new QualType(ArgTy))));
        }
        for (final Expr /*&*/ E : OpaqueArgExprs)  {
          ArgExprs.push_back($AddrOf(E));
        }
        
        // Perform the initialization in an unevaluated context within a SFINAE 
        // trap at translation unit scope.
        Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
        SFINAE/*J*/= new Sema.SFINAETrap(S, /*AccessCheckingSFINAE=*/ true);
        TUContext/*J*/= new Sema.ContextRAII(S, S.Context.getTranslationUnitDecl());
        InitializedEntity To/*J*/= InitializedEntity.InitializeTemporary(Args.$at(0));
        InitializationKind InitKind/*J*/= InitializationKind.CreateDirect(new SourceLocation(KWLoc), new SourceLocation(KWLoc), 
            new SourceLocation(RParenLoc));
        Init/*J*/= new InitializationSequence(S, To, InitKind, new MutableArrayRef<Expr /*P*/ >(ArgExprs, true));
        if (Init.Failed()) {
          return false;
        }
        
        ActionResultTTrue<Expr /*P*/ > Result = Init.Perform(S, To, InitKind, new MutableArrayRef<Expr /*P*/ >(ArgExprs, true));
        if (Result.isInvalid() || SFINAE.hasErrorOccurred()) {
          return false;
        }
        if (Kind == TypeTrait.TT_IsConstructible) {
          return true;
        }
        if (Kind == TypeTrait.TT_IsNothrowConstructible) {
          return S.canThrow(Result.get()) == CanThrowResult.CT_Cannot;
        }
        if (Kind == TypeTrait.TT_IsTriviallyConstructible) {
          // Under Objective-C ARC, if the destination has non-trivial Objective-C
          // lifetime, this is a non-trivial construction.
          if (S.getLangOpts().ObjCAutoRefCount
             && hasNontrivialObjCLifetime(T.getNonReferenceType())) {
            return false;
          }
          
          // The initialization succeeded; now make sure there are no non-trivial
          // calls.
          return !Result.get().hasNonTrivialCall(S.Context);
        }
        throw new llvm_unreachable("unhandled type trait");
//        return false;
      } finally {
        if (Init != null) { Init.$destroy(); }
        if (TUContext != null) { TUContext.$destroy(); }
        if (SFINAE != null) { SFINAE.$destroy(); }
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
   default:
    throw new llvm_unreachable("not a TT");
  }
  
  //return false;
}

//<editor-fold defaultstate="collapsed" desc="EvaluateArrayTypeTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4663,
 FQN="EvaluateArrayTypeTrait", NM="_ZL22EvaluateArrayTypeTraitRN5clang4SemaENS_14ArrayTypeTraitENS_8QualTypeEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL22EvaluateArrayTypeTraitRN5clang4SemaENS_14ArrayTypeTraitENS_8QualTypeEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public static long/*uint64_t*/ EvaluateArrayTypeTrait(final Sema /*&*/ Self, ArrayTypeTrait ATT, 
                      QualType T, Expr /*P*/ DimExpr, 
                      SourceLocation KeyLoc) {
  assert (!T.$arrow().isDependentType()) : "Cannot evaluate traits of dependent type";
  switch (ATT) {
   case ATT_ArrayRank:
    if (T.$arrow().isArrayType()) {
      /*uint*/int Dim = 0;
      {
        /*const*/ ArrayType /*P*/ AT;
        while (((/*P*/ AT = Self.Context.getAsArrayType(new QualType(T))) != null)) {
          ++Dim;
          T.$assignMove(AT.getElementType());
        }
      }
      return $uint2ulong(Dim);
    }
    return 0;
   case ATT_ArrayExtent:
    {
      APSInt Value/*J*/= new APSInt();
      long/*uint64_t*/ Dim;
      if (Self.VerifyIntegerConstantExpression(DimExpr, $AddrOf(Value), 
          diag.err_dimension_expr_not_constant_integer, 
          false).isInvalid()) {
        return 0;
      }
      if (Value.isSigned() && Value.isNegative()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(KeyLoc), diag.err_dimension_expr_not_constant_integer)), 
              DimExpr.getSourceRange()));
          return 0;
        } finally {
          $c$.$destroy();
        }
      }
      Dim = Value.getLimitedValue();
      if (T.$arrow().isArrayType()) {
        /*uint*/int D = 0;
        boolean Matched = false;
        {
          /*const*/ ArrayType /*P*/ AT;
          while (((/*P*/ AT = Self.Context.getAsArrayType(new QualType(T))) != null)) {
            if (Dim == $uint2ullong(D)) {
              Matched = true;
              break;
            }
            ++D;
            T.$assignMove(AT.getElementType());
          }
        }
        if (Matched && T.$arrow().isArrayType()) {
          {
            /*const*/ ConstantArrayType /*P*/ CAT = Self.Context.getAsConstantArrayType(new QualType(T));
            if ((CAT != null)) {
              return CAT.getSize().getLimitedValue();
            }
          }
        }
      }
      return 0;
    }
  }
  throw new llvm_unreachable("Unknown type trait or not implemented");
}

//<editor-fold defaultstate="collapsed" desc="EvaluateExpressionTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4752,
 FQN="EvaluateExpressionTrait", NM="_ZL23EvaluateExpressionTraitN5clang15ExpressionTraitEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL23EvaluateExpressionTraitN5clang15ExpressionTraitEPNS_4ExprE")
//</editor-fold>
public static boolean EvaluateExpressionTrait(ExpressionTrait ET, Expr /*P*/ E) {
  switch (ET) {
   case ET_IsLValueExpr:
    return E.isLValue();
   case ET_IsRValueExpr:
    return E.isRValue();
  }
  throw new llvm_unreachable("Expression trait not covered by switch");
}


/// \brief Try to convert a type to another according to C++11 5.16p3.
///
/// This is part of the parameter validation for the ? operator. If either
/// value operand is a class type, the two operands are attempted to be
/// converted to each other. This function does the conversion in one direction.
/// It returns true if the program is ill-formed and has already been diagnosed
/// as such.
//<editor-fold defaultstate="collapsed" desc="TryClassUnification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4927,
 FQN="TryClassUnification", NM="_ZL19TryClassUnificationRN5clang4SemaEPNS_4ExprES3_NS_14SourceLocationERbRNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL19TryClassUnificationRN5clang4SemaEPNS_4ExprES3_NS_14SourceLocationERbRNS_8QualTypeE")
//</editor-fold>
public static boolean TryClassUnification(final Sema /*&*/ Self, Expr /*P*/ From, Expr /*P*/ To, 
                   SourceLocation QuestionLoc, 
                   final bool$ref/*bool &*/ HaveConversion, 
                   final QualType /*&*/ ToType) {
  InitializationSequence InitSeq = null;
  try {
    HaveConversion.$set(false);
    ToType.$assignMove(To.getType());
    
    InitializationKind Kind = InitializationKind.CreateCopy(To.getLocStart(), 
        new SourceLocation());
    // C++11 5.16p3
    //   The process for determining whether an operand expression E1 of type T1
    //   can be converted to match an operand expression E2 of type T2 is defined
    //   as follows:
    //   -- If E2 is an lvalue: E1 can be converted to match E2 if E1 can be
    //      implicitly converted to type "lvalue reference to T2", subject to the
    //      constraint that in the conversion the reference must bind directly to
    //      an lvalue.
    //   -- If E2 is an xvalue: E1 can be converted to match E2 if E1 can be
    //      implicitly conveted to the type "rvalue reference to R2", subject to
    //      the constraint that the reference must bind directly.
    if (To.isLValue() || To.isXValue()) {
      InitializationSequence InitSeq$1 = null;
      try {
        QualType T = To.isLValue() ? Self.Context.getLValueReferenceType(new QualType(ToType)) : Self.Context.getRValueReferenceType(new QualType(ToType));
        
        InitializedEntity Entity = InitializedEntity.InitializeTemporary(new QualType(T));
        
        InitSeq$1/*J*/= new InitializationSequence(Self, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(From, true));
        if (InitSeq$1.isDirectReferenceBinding()) {
          ToType.$assign(T);
          HaveConversion.$set(true);
          return false;
        }
        if (InitSeq$1.isAmbiguous()) {
          return InitSeq$1.Diagnose(Self, Entity, Kind, new ArrayRef<Expr /*P*/ >(From, true));
        }
      } finally {
        if (InitSeq$1 != null) { InitSeq$1.$destroy(); }
      }
    }
    
    //   -- If E2 is an rvalue, or if the conversion above cannot be done:
    //      -- if E1 and E2 have class type, and the underlying class types are
    //         the same or one is a base class of the other:
    QualType FTy = From.getType();
    QualType TTy = To.getType();
    /*const*/ RecordType /*P*/ FRec = FTy.$arrow().<RecordType>getAs$RecordType();
    /*const*/ RecordType /*P*/ TRec = TTy.$arrow().<RecordType>getAs$RecordType();
    boolean FDerivedFromT = (FRec != null) && (TRec != null) && FRec != TRec
       && Self.IsDerivedFrom(new SourceLocation(QuestionLoc), new QualType(FTy), new QualType(TTy));
    if ((FRec != null) && (TRec != null) && (FRec == TRec || FDerivedFromT
       || Self.IsDerivedFrom(new SourceLocation(QuestionLoc), new QualType(TTy), new QualType(FTy)))) {
      //         E1 can be converted to match E2 if the class of T2 is the
      //         same type as, or a base class of, the class of T1, and
      //         [cv2 > cv1].
      if (FRec == TRec || FDerivedFromT) {
        if (TTy.isAtLeastAsQualifiedAs(new QualType(FTy))) {
          InitializationSequence InitSeq$1 = null;
          try {
            InitializedEntity Entity = InitializedEntity.InitializeTemporary(new QualType(TTy));
            InitSeq$1/*J*/= new InitializationSequence(Self, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(From, true));
            if (InitSeq$1.$bool()) {
              HaveConversion.$set(true);
              return false;
            }
            if (InitSeq$1.isAmbiguous()) {
              return InitSeq$1.Diagnose(Self, Entity, Kind, new ArrayRef<Expr /*P*/ >(From, true));
            }
          } finally {
            if (InitSeq$1 != null) { InitSeq$1.$destroy(); }
          }
        }
      }
      
      return false;
    }
    
    //     -- Otherwise: E1 can be converted to match E2 if E1 can be
    //        implicitly converted to the type that expression E2 would have
    //        if E2 were converted to an rvalue (or the type it has, if E2 is
    //        an rvalue).
    //
    // This actually refers very narrowly to the lvalue-to-rvalue conversion, not
    // to the array-to-pointer or function-to-pointer conversions.
    if (!(TTy.$arrow().getAs(TagType.class) != null)) {
      TTy.$assignMove(TTy.getUnqualifiedType());
    }
    
    InitializedEntity Entity = InitializedEntity.InitializeTemporary(new QualType(TTy));
    InitSeq/*J*/= new InitializationSequence(Self, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(From, true));
    HaveConversion.$set(!InitSeq.Failed());
    ToType.$assign(TTy);
    if (InitSeq.isAmbiguous()) {
      return InitSeq.Diagnose(Self, Entity, Kind, new ArrayRef<Expr /*P*/ >(From, true));
    }
    
    return false;
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
  }
}


/// \brief Try to find a common type for two according to C++0x 5.16p5.
///
/// This is part of the parameter validation for the ? operator. If either
/// value operand is a class type, overload resolution is used to find a
/// conversion to a common type.
//<editor-fold defaultstate="collapsed" desc="FindConditionalOverload">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5020,
 FQN="FindConditionalOverload", NM="_ZL23FindConditionalOverloadRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL23FindConditionalOverloadRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE")
//</editor-fold>
public static boolean FindConditionalOverload(final Sema /*&*/ Self, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                       SourceLocation QuestionLoc) {
  OverloadCandidateSet CandidateSet = null;
  try {
    Expr /*P*/ Args[/*2*/] = new Expr /*P*/ [/*2*/] {LHS.get(), RHS.get()};
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(QuestionLoc), 
        OverloadCandidateSet.CandidateSetKind.CSK_Operator);
    Self.AddBuiltinOperatorCandidates(OverloadedOperatorKind.OO_Conditional, new SourceLocation(QuestionLoc), new ArrayRef<Expr /*P*/ >(Args, true), 
        CandidateSet);
    
    final type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(Self, new SourceLocation(QuestionLoc), Best)) {
     case OR_Success:
      {
        // We found a match. Perform the conversions on the arguments and move on.
        ActionResultTTrue<Expr /*P*/ > LHSRes = Self.PerformImplicitConversion(LHS.get(), new QualType(Best.$star().BuiltinTypes.ParamTypes[0]), 
            Best.$star().Conversions[0], Sema.AssignmentAction.AA_Converting);
        if (LHSRes.isInvalid()) {
          break;
        }
        LHS.$assign(LHSRes);
        
        ActionResultTTrue<Expr /*P*/ > RHSRes = Self.PerformImplicitConversion(RHS.get(), new QualType(Best.$star().BuiltinTypes.ParamTypes[1]), 
            Best.$star().Conversions[1], Sema.AssignmentAction.AA_Converting);
        if (RHSRes.isInvalid()) {
          break;
        }
        RHS.$assign(RHSRes);
        if ((Best.$star().Function != null)) {
          Self.MarkFunctionReferenced(new SourceLocation(QuestionLoc), Best.$star().Function);
        }
        return false;
      }
     case OR_No_Viable_Function:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          
          // Emit a better diagnostic if one of the expressions is a null pointer
          // constant and the other is a pointer type. In this case, the user most
          // likely forgot to take the address of the other expression.
          if (Self.DiagnoseConditionalForNull(LHS.get(), RHS.get(), new SourceLocation(QuestionLoc))) {
            return true;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_incompatible_operands)), 
                          LHS.get().getType()), RHS.get().getType()), 
                  LHS.get().getSourceRange()), RHS.get().getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Ambiguous:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(QuestionLoc), diag.err_conditional_ambiguous_ovl)), 
                          LHS.get().getType()), RHS.get().getType()), 
                  LHS.get().getSourceRange()), RHS.get().getSourceRange()));
          // FIXME: Print the possible common types by printing the return types of
          // the viable candidates.
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Deleted:
      throw new llvm_unreachable("Conditional operator has only built-in overloads");
    }
    return true;
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}


/// \brief Perform an "extended" implicit conversion as returned by
/// TryClassUnification.
//<editor-fold defaultstate="collapsed" desc="ConvertForConditional">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5079,
 FQN="ConvertForConditional", NM="_ZL21ConvertForConditionalRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL21ConvertForConditionalRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE")
//</editor-fold>
public static boolean ConvertForConditional(final Sema /*&*/ Self, final ActionResultTTrue<Expr /*P*/ > /*&*/ E, QualType T) {
  InitializationSequence InitSeq = null;
  try {
    InitializedEntity Entity = InitializedEntity.InitializeTemporary(new QualType(T));
    InitializationKind Kind = InitializationKind.CreateCopy(E.get().getLocStart(), 
        new SourceLocation());
    Expr /*P*/ Arg = E.get();
    InitSeq/*J*/= new InitializationSequence(Self, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Arg, true));
    ActionResultTTrue<Expr /*P*/ > Result = InitSeq.Perform(Self, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Arg, true));
    if (Result.isInvalid()) {
      return true;
    }
    
    E.$assign(Result);
    return false;
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
  }
}


/// Note a set of 'operator->' functions that were used for a member access.
//<editor-fold defaultstate="collapsed" desc="noteOperatorArrows">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5882,
 FQN="noteOperatorArrows", NM="_ZL18noteOperatorArrowsRN5clang4SemaEN4llvm8ArrayRefIPNS_12FunctionDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL18noteOperatorArrowsRN5clang4SemaEN4llvm8ArrayRefIPNS_12FunctionDeclEEE")
//</editor-fold>
public static void noteOperatorArrows(final Sema /*&*/ S, 
                  ArrayRef<FunctionDecl /*P*/ > OperatorArrows) {
  /*uint*/int SkipStart = OperatorArrows.size(), SkipCount = 0;
  // FIXME: Make this configurable?
  /*uint*/int Limit = 9;
  if ($greater_uint(OperatorArrows.size(), Limit)) {
    // Produce Limit-1 normal notes and one 'skipping' note.
    SkipStart = $div_uint((Limit - 1), 2) + $rem_uint((Limit - 1), 2);
    SkipCount = OperatorArrows.size() - (Limit - 1);
  }
  
  for (/*uint*/int I = 0; $less_uint(I, OperatorArrows.size());) {
    if (I == SkipStart) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OperatorArrows.$at(I).getLocation(), 
                diag.note_operator_arrows_suppressed)), 
            SkipCount));
        I += SkipCount;
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OperatorArrows.$at(I).getLocation(), diag.note_operator_arrow_here)), 
            OperatorArrows.$at(I).getCallResultType()));
        ++I;
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckArrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6050,
 FQN="CheckArrow", NM="_ZL10CheckArrowRN5clang4SemaERNS_8QualTypeERPNS_4ExprERNS_3tok9TokenKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL10CheckArrowRN5clang4SemaERNS_8QualTypeERPNS_4ExprERNS_3tok9TokenKindENS_14SourceLocationE")
//</editor-fold>
public static boolean CheckArrow(final Sema /*&*/ S, final QualType /*&*/ ObjectType, final type$ref<Expr /*P*/ /*&*/> Base, 
          final ushort$ref/*tok.TokenKind /*&*/ OpKind, SourceLocation OpLoc) {
  if (Base.$deref().hasPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > result = S.CheckPlaceholderExpr(Base.$deref());
    if (result.isInvalid()) {
      return true;
    }
    Base.$set(result.get());
  }
  ObjectType.$assignMove(Base.$deref().getType());
  
  // C++ [expr.pseudo]p2:
  //   The left-hand side of the dot operator shall be of scalar type. The
  //   left-hand side of the arrow operator shall be of pointer to scalar type.
  //   This scalar type is the object type.
  // Note that this is rather different from the normal handling for the
  // arrow operator.
  if (OpKind.$deref() == tok.TokenKind.arrow) {
    {
      /*const*/ PointerType /*P*/ Ptr = ObjectType.$arrow().getAs(PointerType.class);
      if ((Ptr != null)) {
        ObjectType.$assignMove(Ptr.getPointeeType());
      } else if (!Base.$deref().isTypeDependent()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // The user wrote "p->" when they probably meant "p."; fix it.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_typecheck_member_reference_suggestion)), 
                      ObjectType), true), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$DOT))));
          if (S.isSFINAEContext().$bool()) {
            return true;
          }
          
          OpKind.$set(tok.TokenKind.period);
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="IsSpecialDiscardedValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6425,
 FQN="IsSpecialDiscardedValue", NM="_ZL23IsSpecialDiscardedValuePN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL23IsSpecialDiscardedValuePN5clang4ExprE")
//</editor-fold>
public static boolean IsSpecialDiscardedValue(Expr /*P*/ E) {
  // In C++11, discarded-value expressions of a certain form are special,
  // according to [expr]p10:
  //   The lvalue-to-rvalue conversion (4.1) is applied only if the
  //   expression is an lvalue of volatile-qualified type and it has
  //   one of the following forms:
  E = E.IgnoreParens();
  
  //   - id-expression (5.1.1),
  if (isa_DeclRefExpr(E)) {
    return true;
  }
  
  //   - subscripting (5.2.1),
  if (isa_ArraySubscriptExpr(E)) {
    return true;
  }
  
  //   - class member access (5.2.5),
  if (isa_MemberExpr(E)) {
    return true;
  }
  {
    
    //   - indirection (5.3.1),
    UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
    if ((UO != null)) {
      if (UO.getOpcode() == UnaryOperatorKind.UO_Deref) {
        return true;
      }
    }
  }
  {
    
    BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
    if ((BO != null)) {
      //   - pointer-to-member operation (5.5),
      if (BO.isPtrMemOp()) {
        return true;
      }
      
      //   - comma expression (5.18) where the right operand is one of the above.
      if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
        return IsSpecialDiscardedValue(BO.getRHS());
      }
    }
  }
  {
    
    //   - conditional expression (5.16) where both the second and the third
    //     operands are one of the above, or
    ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
    if ((CO != null)) {
      return IsSpecialDiscardedValue(CO.getTrueExpr())
         && IsSpecialDiscardedValue(CO.getFalseExpr());
    }
  }
  {
    // The related edge case of "*x ?: *x".
    BinaryConditionalOperator /*P*/ BCO = dyn_cast_BinaryConditionalOperator(E);
    if ((BCO != null)) {
      {
        OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(BCO.getTrueExpr());
        if ((OVE != null)) {
          return IsSpecialDiscardedValue(OVE.getSourceExpr())
             && IsSpecialDiscardedValue(BCO.getFalseExpr());
        }
      }
    }
  }
  
  // Objective-C++ extensions to the rule.
  if (isa_PseudoObjectExpr(E) || isa_ObjCIvarRefExpr(E)) {
    return true;
  }
  
  return false;
}


// If we can unambiguously determine whether Var can never be used
// in a constant expression, return true.
//  - if the variable and its initializer are non-dependent, then
//    we can unambiguously check if the variable is a constant expression.
//  - if the initializer is not value dependent - we can determine whether
//    it can be used to initialize a constant expression.  If Init can not
//    be used to initialize a constant expression we conclude that Var can 
//    never be a constant expression.
//  - FXIME: if the initializer is dependent, we can still do some analysis and
//    identify certain cases unambiguously as non-const by using a Visitor:
//      - such as those that involve odr-use of a ParmVarDecl, involve a new
//        delete, lambda-expr, dynamic-cast, reinterpret-cast etc...
//<editor-fold defaultstate="collapsed" desc="VariableCanNeverBeAConstantExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6552,
 FQN="VariableCanNeverBeAConstantExpression", NM="_ZL37VariableCanNeverBeAConstantExpressionPN5clang7VarDeclERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL37VariableCanNeverBeAConstantExpressionPN5clang7VarDeclERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ boolean VariableCanNeverBeAConstantExpression(VarDecl /*P*/ Var, 
                                     final ASTContext /*&*/ Context) {
  if (isa_ParmVarDecl(Var)) {
    return true;
  }
  type$ref</*const*/ VarDecl /*P*/ > DefVD = create_type$ref();
  
  // If there is no initializer - this can not be a constant expression.
  if (!(Var.getAnyInitializer(DefVD) != null)) {
    return true;
  }
  assert Native.$bool(DefVD);
  if (DefVD.$deref().isWeak()) {
    return false;
  }
  EvaluatedStmt /*P*/ Eval = DefVD.$deref().ensureEvaluatedStmt();
  
  Expr /*P*/ Init = cast_Expr(Eval.Value);
  if (Var.getType().$arrow().isDependentType() || Init.isValueDependent()) {
    // FIXME: Teach the constant evaluator to deal with the non-dependent parts
    // of value-dependent expressions, and use it here to determine whether the
    // initializer is a potential constant expression.
    return false;
  }
  
  return !IsVariableAConstantExpression(Var, Context);
}


/// \brief Check if the current lambda has any potential captures 
/// that must be captured by any of its enclosing lambdas that are ready to 
/// capture. If there is a lambda that can capture a nested 
/// potential-capture, go ahead and do so.  Also, check to see if any 
/// variables are uncaptureable or do not involve an odr-use so do not 
/// need to be captured.
//<editor-fold defaultstate="collapsed" desc="CheckIfAnyEnclosingLambdasMustCaptureAnyPotentialCaptures">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6582,
 FQN="CheckIfAnyEnclosingLambdasMustCaptureAnyPotentialCaptures", NM="_ZL57CheckIfAnyEnclosingLambdasMustCaptureAnyPotentialCapturesPN5clang4ExprEPNS_4sema15LambdaScopeInfoERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL57CheckIfAnyEnclosingLambdasMustCaptureAnyPotentialCapturesPN5clang4ExprEPNS_4sema15LambdaScopeInfoERNS_4SemaE")
//</editor-fold>
public static void CheckIfAnyEnclosingLambdasMustCaptureAnyPotentialCaptures(Expr /*P*/ /*const*/ FE, LambdaScopeInfo /*P*/ /*const*/ CurrentLSI, final Sema /*&*/ S) {
  assert (!S.isUnevaluatedContext());
  assert (S.CurContext.isDependentContext());
  assert (CurrentLSI.CallOperator == S.CurContext) : "The current call operator must be synchronized with Sema's CurContext";
  
  /*const*/boolean IsFullExprInstantiationDependent = FE.isInstantiationDependent();
  
  ArrayRef</*const*/ FunctionScopeInfo /*P*/ > FunctionScopesArrayRef/*J*/= new ArrayRef</*const*/ FunctionScopeInfo /*P*/ >(S.FunctionScopes.data(), S.FunctionScopes.size(), true);
  
  // All the potentially captureable variables in the current nested
  // lambda (within a generic outer lambda), must be captured by an
  // outer lambda that is enclosed within a non-dependent context.
  /*const*//*uint*/int NumPotentialCaptures = CurrentLSI.getNumPotentialVariableCaptures();
  for (/*uint*/int I = 0; I != NumPotentialCaptures; ++I) {
    type$ref<Expr /*P*/ > VarExpr = create_type$null$ref(null);
    type$ref<VarDecl /*P*/ > Var = create_type$null$ref(null);
    CurrentLSI.getPotentialVariableCapture(I, Var, VarExpr);
    // If the variable is clearly identified as non-odr-used and the full
    // expression is not instantiation dependent, only then do we not 
    // need to check enclosing lambda's for speculative captures.
    // For e.g.:
    // Even though 'x' is not odr-used, it should be captured.
    // int test() {
    //   const int x = 10;
    //   auto L = [=](auto a) {
    //     (void) +x + a;
    //   };
    // }
    if (CurrentLSI.isVariableExprMarkedAsNonODRUsed(VarExpr.$deref())
       && !IsFullExprInstantiationDependent) {
      continue;
    }
    {
      
      // If we have a capture-capable lambda for the variable, go ahead and
      // capture the variable in that lambda (and all its enclosing lambdas).
      /*const*/OptionalUInt Index = getStackIndexOfNearestEnclosingCaptureCapableLambda(new ArrayRef</*const*/ FunctionScopeInfo /*P*/ >(FunctionScopesArrayRef), Var.$deref(), S);
      if (Index.$bool()) {
        uint$ptr FunctionScopeIndexOfCapturableLambda = create_uint$ptr(Index.getValue$Const());
        MarkVarDeclODRUsed(Var.$deref(), VarExpr.$deref().getExprLoc(), S, 
            $AddrOf(FunctionScopeIndexOfCapturableLambda));
      }
    }
    /*const*/boolean IsVarNeverAConstantExpression = VariableCanNeverBeAConstantExpression(Var.$deref(), S.Context);
    if (!IsFullExprInstantiationDependent || IsVarNeverAConstantExpression) {
      // This full expression is not instantiation dependent or the variable
      // can not be used in a constant expression - which means 
      // this variable must be odr-used here, so diagnose a 
      // capture violation early, if the variable is un-captureable.
      // This is purely for diagnosing errors early.  Otherwise, this
      // error would get diagnosed when the lambda becomes capture ready.
      QualType CaptureType/*J*/= new QualType(), DeclRefType/*J*/= new QualType();
      SourceLocation ExprLoc = VarExpr.$deref().getExprLoc();
      if (S.tryCaptureVariable(Var.$deref(), new SourceLocation(ExprLoc), Sema.TryCaptureKind.TryCapture_Implicit, 
          /*EllipsisLoc*/ new SourceLocation(), 
          /*BuildAndDiagnose*/ false, CaptureType, 
          DeclRefType, (/*const*/uint$ptr/*uint P*/ )null)) {
        // We will never be able to capture this variable, and we need
        // to be able to in any and all instantiations, so diagnose it.
        S.tryCaptureVariable(Var.$deref(), new SourceLocation(ExprLoc), Sema.TryCaptureKind.TryCapture_Implicit, 
            /*EllipsisLoc*/ new SourceLocation(), 
            /*BuildAndDiagnose*/ true, CaptureType, 
            DeclRefType, (/*const*/uint$ptr/*uint P*/ )null);
      }
    }
  }
  
  // Check if 'this' needs to be captured.
  if (CurrentLSI.hasPotentialThisCapture()) {
    {
      // If we have a capture-capable lambda for 'this', go ahead and capture
      // 'this' in that lambda (and all its enclosing lambdas).
      /*const*/OptionalUInt Index = getStackIndexOfNearestEnclosingCaptureCapableLambda(new ArrayRef</*const*/ FunctionScopeInfo /*P*/ >(FunctionScopesArrayRef), /*0 is 'this'*/ (VarDecl /*P*/ )null, S);
      if (Index.$bool()) {
        uint$ptr FunctionScopeIndexOfCapturableLambda = create_uint$ptr(Index.getValue$Const());
        S.CheckCXXThisCapture(new SourceLocation(CurrentLSI.PotentialThisCaptureLocation), 
            /*Explicit*/ false, /*BuildAndDiagnose*/ true, 
            $AddrOf(FunctionScopeIndexOfCapturableLambda));
      }
    }
  }
  
  // Reset all the potential captures at the end of each full-expression.
  CurrentLSI.clearPotentialCaptures();
}

//<editor-fold defaultstate="collapsed" desc="attemptRecovery">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6671,
 FQN="attemptRecovery", NM="_ZL15attemptRecoveryRN5clang4SemaERKNS_22TypoCorrectionConsumerERKNS_14TypoCorrectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZL15attemptRecoveryRN5clang4SemaERKNS_22TypoCorrectionConsumerERKNS_14TypoCorrectionE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > attemptRecovery(final Sema /*&*/ SemaRef, 
               final /*const*/ TypoCorrectionConsumer /*&*/ Consumer, 
               final /*const*/ TypoCorrection /*&*/ TC) {
  LookupResult R = null;
  CXXScopeSpec NewSS = null;
  try {
    R/*J*/= new LookupResult(SemaRef, Consumer.getLookupResult().getLookupNameInfo(), 
        Consumer.getLookupResult().getLookupKind());
    /*const*/ CXXScopeSpec /*P*/ SS = Consumer.getSS();
    NewSS/*J*/= new CXXScopeSpec();
    {
      
      // Use an approprate CXXScopeSpec for building the expr.
      NestedNameSpecifier /*P*/ NNS = TC.getCorrectionSpecifier();
      if ((NNS != null)) {
        NewSS.MakeTrivial(SemaRef.Context, NNS, TC.getCorrectionRange());
      } else if ((SS != null) && !TC.WillReplaceSpecifier()) {
        NewSS.$assign($Deref(SS));
      }
    }
    {
      
      NamedDecl /*P*/ ND = TC.getFoundDecl();
      if ((ND != null)) {
        R.setLookupName(ND.getDeclName());
        R.addDecl(ND);
        if (ND.isCXXClassMember()) {
          // Figure out the correct naming class to add to the LookupResult.
          CXXRecordDecl /*P*/ Record = null;
          {
            NestedNameSpecifier /*P*/ NNS = TC.getCorrectionSpecifier();
            if ((NNS != null)) {
              Record = NNS.getAsType().getAsCXXRecordDecl();
            }
          }
          if (!(Record != null)) {
            Record
               = dyn_cast_CXXRecordDecl(ND.getDeclContext().getRedeclContext());
          }
          if ((Record != null)) {
            R.setNamingClass(Record);
          }
          
          // Detect and handle the case where the decl might be an implicit
          // member.
          boolean MightBeImplicitMember;
          if (!Consumer.isAddressOfOperand()) {
            MightBeImplicitMember = true;
          } else if (!NewSS.isEmpty()) {
            MightBeImplicitMember = false;
          } else if (R.isOverloadedResult()) {
            MightBeImplicitMember = false;
          } else if (R.isUnresolvableResult()) {
            MightBeImplicitMember = true;
          } else {
            MightBeImplicitMember = isa_FieldDecl(ND)
               || isa_IndirectFieldDecl(ND)
               || isa_MSPropertyDecl(ND);
          }
          if (MightBeImplicitMember) {
            return SemaRef.BuildPossibleImplicitMemberExpr(NewSS, /*TemplateKWLoc*/ new SourceLocation(), R, 
                /*TemplateArgs*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, /*S*/ (/*const*/ Scope /*P*/ )null);
          }
        } else {
          ObjCIvarDecl /*P*/ Ivar = dyn_cast_ObjCIvarDecl(ND);
          if ((Ivar != null)) {
            return SemaRef.LookupInObjCMethod(R, Consumer.getScope(), 
                Ivar.getIdentifier());
          }
        }
      }
    }
    
    return SemaRef.BuildDeclarationNameExpr(NewSS, R, /*NeedsADL*/ false, 
        /*AcceptInvalidDecl*/ true);
  } finally {
    if (NewSS != null) { NewSS.$destroy(); }
    if (R != null) { R.$destroy(); }
  }
}

} // END OF class SemaExprCXXStatics
