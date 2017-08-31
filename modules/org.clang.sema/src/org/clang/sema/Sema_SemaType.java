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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.java.SemaSizeofAndAlignment.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaTypeStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaType">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaTemplateVariadic ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema13ActOnTypeNameEPNS_5ScopeERNS_10DeclaratorE;_ZN5clang4Sema13BuildPipeTypeENS_8QualTypeENS_14SourceLocationE;_ZN5clang4Sema14BuildArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPNS_4ExprEjNS_11SourceRangeENS_15DeclarationNameE;_ZN5clang4Sema14BuildParenTypeENS_8QualTypeE;_ZN5clang4Sema15BuildAtomicTypeENS_8QualTypeENS_14SourceLocationE;_ZN5clang4Sema15getNSErrorIdentEv;_ZN5clang4Sema16BuildPointerTypeENS_8QualTypeENS_14SourceLocationENS_15DeclarationNameE;_ZN5clang4Sema16CreateParsedTypeENS_8QualTypeEPNS_14TypeSourceInfoE;_ZN5clang4Sema17BuildDecltypeTypeEPNS_4ExprENS_14SourceLocationEb;_ZN5clang4Sema17BuildFunctionTypeENS_8QualTypeEN4llvm15MutableArrayRefIS1_EENS_14SourceLocationENS_15DeclarationNameERKNS_17FunctionProtoType12ExtProtoInfoE;_ZN5clang4Sema17GetTypeFromParserENS_9OpaquePtrINS_8QualTypeEEEPPNS_14TypeSourceInfoE;_ZN5clang4Sema17getElaboratedTypeENS_21ElaboratedTypeKeywordERKNS_12CXXScopeSpecENS_8QualTypeE;_ZN5clang4Sema18BuildExtVectorTypeENS_8QualTypeEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema18BuildQualifiedTypeENS_8QualTypeENS_14SourceLocationENS_10QualifiersEPKNS_8DeclSpecE;_ZN5clang4Sema18BuildQualifiedTypeENS_8QualTypeENS_14SourceLocationEjPKNS_8DeclSpecE;_ZN5clang4Sema18BuildReferenceTypeENS_8QualTypeEbNS_14SourceLocationENS_15DeclarationNameE;_ZN5clang4Sema18RequireLiteralTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE;_ZN5clang4Sema18RequireLiteralTypeENS_14SourceLocationENS_8QualTypeEj;_ZN5clang4Sema19BuildObjCObjectTypeENS_8QualTypeENS_14SourceLocationES2_N4llvm8ArrayRefIPNS_14TypeSourceInfoEEES2_S2_NS4_IPNS_16ObjCProtocolDeclEEENS4_IS2_EES2_b;_ZN5clang4Sema19BuildTypeofExprTypeEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema19RequireCompleteTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE;_ZN5clang4Sema19RequireCompleteTypeENS_14SourceLocationENS_8QualTypeEj;_ZN5clang4Sema19checkObjCKindOfTypeERNS_8QualTypeENS_14SourceLocationE;_ZN5clang4Sema20GetTypeForDeclaratorERNS_10DeclaratorEPNS_5ScopeE;_ZN5clang4Sema20hasVisibleDefinitionEPNS_9NamedDeclEPS2_b;_ZN5clang4Sema21ActOnObjCInstanceTypeENS_14SourceLocationE;_ZN5clang4Sema21BuildBlockPointerTypeENS_8QualTypeENS_14SourceLocationENS_15DeclarationNameE;_ZN5clang4Sema21getNullabilityKeywordENS_15NullabilityKindE;_ZN5clang4Sema22BuildMemberPointerTypeENS_8QualTypeES1_NS_14SourceLocationENS_15DeclarationNameE;_ZN5clang4Sema22adjustMemberFunctionCCERNS_8QualTypeEbbNS_14SourceLocationE;_ZN5clang4Sema22completeExprArrayBoundEPNS_4ExprE;_ZN5clang4Sema22hasExplicitCallingConvERNS_8QualTypeE;_ZN5clang4Sema23BuildUnaryTransformTypeENS_8QualTypeENS_18UnaryTransformType7UTTKindENS_14SourceLocationE;_ZN5clang4Sema23CheckFunctionReturnTypeENS_8QualTypeENS_14SourceLocationE;_ZN5clang4Sema23RequireCompleteExprTypeEPNS_4ExprERNS0_13TypeDiagnoserE;_ZN5clang4Sema23RequireCompleteExprTypeEPNS_4ExprEj;_ZN5clang4Sema23RequireCompleteTypeImplENS_14SourceLocationENS_8QualTypeEPNS0_13TypeDiagnoserE;_ZN5clang4Sema24GetTypeForDeclaratorCastERNS_10DeclaratorENS_8QualTypeE;_ZN5clang4Sema25diagnoseIgnoredQualifiersEjjNS_14SourceLocationES1_S1_S1_S1_S1_;_ZN5clang4Sema29checkNullabilityTypeSpecifierERNS_8QualTypeENS_15NullabilityKindENS_14SourceLocationEb;_ZN5clang4Sema30GetTypeSourceInfoForDeclaratorERNS_10DeclaratorENS_8QualTypeEPNS_14TypeSourceInfoE;_ZN5clang4Sema30actOnObjCProtocolQualifierTypeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4DeclEEENS3_IS1_EES1_;_ZN5clang4Sema38actOnObjCTypeArgsAndProtocolQualifiersEPNS_5ScopeENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES3_N4llvm8ArrayRefIS6_EES3_S3_NS8_IPNS_4DeclEEENS8_IS3_EES3_; -static-type=Sema_SemaType -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaType extends Sema_SemaTemplateVariadic {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


//===--------------------------------------------------------------------===//
// Type Analysis / Processing: SemaType.cpp.
//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildQualifiedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1746,
 FQN="clang::Sema::BuildQualifiedType", NM="_ZN5clang4Sema18BuildQualifiedTypeENS_8QualTypeENS_14SourceLocationENS_10QualifiersEPKNS_8DeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema18BuildQualifiedTypeENS_8QualTypeENS_14SourceLocationENS_10QualifiersEPKNS_8DeclSpecE")
//</editor-fold>
public final QualType BuildQualifiedType(QualType T, SourceLocation Loc, 
                  Qualifiers Qs) {
  return BuildQualifiedType(T, Loc, 
                  Qs, (/*const*/ DeclSpec /*P*/ )null);
}
public final QualType BuildQualifiedType(QualType T, SourceLocation Loc, 
                  Qualifiers Qs, /*const*/ DeclSpec /*P*/ DS/*= null*/) {
  if (T.isNull()) {
    return new QualType();
  }
  
  // Enforce C99 6.7.3p2: "Types other than pointer types derived from
  // object or incomplete types shall not be restrict-qualified."
  if (Qs.hasRestrict()) {
    /*uint*/int DiagID = 0;
    QualType ProblemTy/*J*/= new QualType();
    if (T.$arrow().isAnyPointerType() || T.$arrow().isReferenceType()
       || T.$arrow().isMemberPointerType()) {
      QualType EltTy/*J*/= new QualType();
      if (T.$arrow().isObjCObjectPointerType()) {
        EltTy.$assign(T);
      } else {
        /*const*/ MemberPointerType /*P*/ PTy = T.$arrow().getAs(MemberPointerType.class);
        if ((PTy != null)) {
          EltTy.$assignMove(PTy.getPointeeType());
        } else {
          EltTy.$assignMove(T.$arrow().getPointeeType());
        }
      }
      
      // If we have a pointer or reference, the pointee must have an object
      // incomplete type.
      if (!EltTy.$arrow().isIncompleteOrObjectType()) {
        DiagID = diag.err_typecheck_invalid_restrict_invalid_pointee;
        ProblemTy.$assign(EltTy);
      }
    } else if (!T.$arrow().isDependentType()) {
      DiagID = diag.err_typecheck_invalid_restrict_not_pointer;
      ProblemTy.$assign(T);
    }
    if ((DiagID != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag((DS != null) ? DS.getRestrictSpecLoc() : new SourceLocation(Loc), DiagID)), ProblemTy));
        Qs.removeRestrict();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return $this().Context.getQualifiedType(new QualType(T), new Qualifiers(Qs));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildQualifiedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1787,
 FQN="clang::Sema::BuildQualifiedType", NM="_ZN5clang4Sema18BuildQualifiedTypeENS_8QualTypeENS_14SourceLocationEjPKNS_8DeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema18BuildQualifiedTypeENS_8QualTypeENS_14SourceLocationEjPKNS_8DeclSpecE")
//</editor-fold>
public final QualType BuildQualifiedType(QualType T, SourceLocation Loc, 
                  /*uint*/int CVRAU) {
  return BuildQualifiedType(T, Loc, 
                  CVRAU, (/*const*/ DeclSpec /*P*/ )null);
}
public final QualType BuildQualifiedType(QualType T, SourceLocation Loc, 
                  /*uint*/int CVRAU, /*const*/ DeclSpec /*P*/ DS/*= null*/) {
  if (T.isNull()) {
    return new QualType();
  }
  
  // Convert from DeclSpec::TQ to Qualifiers::TQ by just dropping TQ_atomic and
  // TQ_unaligned;
  /*uint*/int CVR = CVRAU & ~(DeclSpec.TQ.TQ_atomic.getValue() | DeclSpec.TQ.TQ_unaligned.getValue());
  
  // C11 6.7.3/5:
  //   If the same qualifier appears more than once in the same
  //   specifier-qualifier-list, either directly or via one or more typedefs,
  //   the behavior is the same as if it appeared only once.
  //
  // It's not specified what happens when the _Atomic qualifier is applied to
  // a type specified with the _Atomic specifier, but we assume that this
  // should be treated as if the _Atomic qualifier appeared multiple times.
  if (((CVRAU & DeclSpec.TQ.TQ_atomic.getValue()) != 0) && !T.$arrow().isAtomicType()) {
    // C11 6.7.3/5:
    //   If other qualifiers appear along with the _Atomic qualifier in a
    //   specifier-qualifier-list, the resulting type is the so-qualified
    //   atomic type.
    //
    // Don't need to worry about array types here, since _Atomic can't be
    // applied to such types.
    SplitQualType Split = T.getSplitUnqualifiedType();
    T.$assignMove($this().BuildAtomicType(new QualType(Split.Ty, 0), 
            (DS != null) ? DS.getAtomicSpecLoc() : new SourceLocation(Loc)));
    if (T.isNull()) {
      return new QualType(JD$Move.INSTANCE, T);
    }
    Split.Quals.addCVRQualifiers(CVR);
    return $this().BuildQualifiedType(new QualType(T), new SourceLocation(Loc), new Qualifiers(Split.Quals));
  }
  
  Qualifiers Q = Qualifiers.fromCVRMask(CVR);
  Q.setUnaligned(((CVRAU & DeclSpec.TQ.TQ_unaligned.getValue()) != 0));
  return $this().BuildQualifiedType(new QualType(T), new SourceLocation(Loc), new Qualifiers(Q), DS);
}


/// \brief Build a pointer type.
///
/// \param T The type to which we'll be building a pointer.
///
/// \param Loc The location of the entity whose type involves this
/// pointer type or, if there is no such entity, the location of the
/// type that will have pointer type.
///
/// \param Entity The name of the entity that involves the pointer
/// type, if known.
///
/// \returns A suitable pointer type, if there are no
/// errors. Otherwise, returns a NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1949,
 FQN="clang::Sema::BuildPointerType", NM="_ZN5clang4Sema16BuildPointerTypeENS_8QualTypeENS_14SourceLocationENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema16BuildPointerTypeENS_8QualTypeENS_14SourceLocationENS_15DeclarationNameE")
//</editor-fold>
public final QualType BuildPointerType(QualType T, 
                SourceLocation Loc, DeclarationName Entity) {
  if (T.$arrow().isReferenceType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C++ 8.3.2p4: There shall be no ... pointers to references ...
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_illegal_decl_pointer_to_reference)), 
              getPrintableNameForEntity(new DeclarationName(Entity))), T));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (checkQualifiedFunction(/*Deref*/$this(), new QualType(T), new SourceLocation(Loc), QualifiedFunctionKind.QFK_Pointer)) {
    return new QualType();
  }
  assert (!T.$arrow().isObjCObjectType()) : "Should build ObjCObjectPointerType";
  
  // In ARC, it is forbidden to build pointers to unqualified pointers.
  if ($this().getLangOpts().ObjCAutoRefCount) {
    T.$assignMove(inferARCLifetimeForPointee(/*Deref*/$this(), new QualType(T), new SourceLocation(Loc), /*reference*/ false));
  }
  
  // Build the pointer type.
  return $this().Context.getPointerType(new QualType(T));
}


/// \brief Build a reference type.
///
/// \param T The type to which we'll be building a reference.
///
/// \param Loc The location of the entity whose type involves this
/// reference type or, if there is no such entity, the location of the
/// type that will have reference type.
///
/// \param Entity The name of the entity that involves the reference
/// type, if known.
///
/// \returns A suitable reference type, if there are no
/// errors. Otherwise, returns a NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildReferenceType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1984,
 FQN="clang::Sema::BuildReferenceType", NM="_ZN5clang4Sema18BuildReferenceTypeENS_8QualTypeEbNS_14SourceLocationENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema18BuildReferenceTypeENS_8QualTypeEbNS_14SourceLocationENS_15DeclarationNameE")
//</editor-fold>
public final QualType BuildReferenceType(QualType T, boolean SpelledAsLValue, 
                  SourceLocation Loc, 
                  DeclarationName Entity) {
  assert ($noteq_CanQual$T_CanQual$U($this().Context.getCanonicalType(new QualType(T)), /*NO_COPY*/$this().Context.OverloadTy)) : "Unresolved overloaded function type";
  
  // C++0x [dcl.ref]p6:
  //   If a typedef (7.1.3), a type template-parameter (14.3.1), or a
  //   decltype-specifier (7.1.6.2) denotes a type TR that is a reference to a
  //   type T, an attempt to create the type "lvalue reference to cv TR" creates
  //   the type "lvalue reference to T", while an attempt to create the type
  //   "rvalue reference to cv TR" creates the type TR.
  boolean LValueRef = SpelledAsLValue || (T.$arrow().getAs(LValueReferenceType.class) != null);
  
  // C++ [dcl.ref]p4: There shall be no references to references.
  //
  // According to C++ DR 106, references to references are only
  // diagnosed when they are written directly (e.g., "int & &"),
  // but not when they happen via a typedef:
  //
  //   typedef int& intref;
  //   typedef intref& intref2;
  //
  // Parser::ParseDeclaratorInternal diagnoses the case where
  // references are written directly; here, we handle the
  // collapsing of references-to-references as described in C++0x.
  // DR 106 and 540 introduce reference-collapsing into C++98/03.
  
  // C++ [dcl.ref]p1:
  //   A declarator that specifies the type "reference to cv void"
  //   is ill-formed.
  if (T.$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_reference_to_void)));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (checkQualifiedFunction(/*Deref*/$this(), new QualType(T), new SourceLocation(Loc), QualifiedFunctionKind.QFK_Reference)) {
    return new QualType();
  }
  
  // In ARC, it is forbidden to build references to unqualified pointers.
  if ($this().getLangOpts().ObjCAutoRefCount) {
    T.$assignMove(inferARCLifetimeForPointee(/*Deref*/$this(), new QualType(T), new SourceLocation(Loc), /*reference*/ true));
  }
  
  // Handle restrict on references.
  if (LValueRef) {
    return $this().Context.getLValueReferenceType(new QualType(T), SpelledAsLValue);
  }
  return $this().Context.getRValueReferenceType(new QualType(T));
}


/// \brief Build an array type.
///
/// \param T The type of each element in the array.
///
/// \param ASM C99 array size modifier (e.g., '*', 'static').
///
/// \param ArraySize Expression describing the size of the array.
///
/// \param Brackets The range from the opening '[' to the closing ']'.
///
/// \param Entity The name of the entity that involves the array
/// type, if known.
///
/// \returns A suitable array type, if there are no errors. Otherwise,
/// returns a NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2085,
 FQN="clang::Sema::BuildArrayType", NM="_ZN5clang4Sema14BuildArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPNS_4ExprEjNS_11SourceRangeENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema14BuildArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEPNS_4ExprEjNS_11SourceRangeENS_15DeclarationNameE")
//</editor-fold>
public final QualType BuildArrayType(QualType T, ArrayType.ArraySizeModifier ASM, 
              Expr /*P*/ ArraySize, /*uint*/int Quals, 
              SourceRange Brackets, DeclarationName Entity) {
  
  SourceLocation Loc = Brackets.getBegin();
  if ($this().getLangOpts().CPlusPlus) {
    // C++ [dcl.array]p1:
    //   T is called the array element type; this type shall not be a reference
    //   type, the (possibly cv-qualified) type void, a function type or an
    //   abstract class type.
    //
    // C++ [dcl.array]p3:
    //   When several "array of" specifications are adjacent, [...] only the
    //   first of the constant expressions that specify the bounds of the arrays
    //   may be omitted.
    //
    // Note: function types are handled in the common path with C.
    if (T.$arrow().isReferenceType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_illegal_decl_array_of_references)), 
                getPrintableNameForEntity(new DeclarationName(Entity))), T));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    if (T.$arrow().isVoidType() || T.$arrow().isIncompleteArrayType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_illegal_decl_array_incomplete_type)), T));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().RequireNonAbstractType$T(Brackets.getBegin(), new QualType(T), 
        diag.err_array_of_abstract_type)) {
      return new QualType();
    }
    
    // Mentioning a member pointer type for an array type causes us to lock in
    // an inheritance model, even if it's inside an unused typedef.
    if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
      {
        /*const*/ MemberPointerType /*P*/ MPTy = T.$arrow().getAs(MemberPointerType.class);
        if ((MPTy != null)) {
          if (!MPTy.__getClass().isDependentType()) {
            /*J:(void)*/$this().isCompleteType(new SourceLocation(Loc), new QualType(T));
          }
        }
      }
    }
  } else {
    // C99 6.7.5.2p1: If the element type is an incomplete or function type,
    // reject it (e.g. void ary[7], struct foo ary[7], void ary[7]())
    if ($this().RequireCompleteType(new SourceLocation(Loc), new QualType(T), 
        diag.err_illegal_decl_array_incomplete_type)) {
      return new QualType();
    }
  }
  if (T.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_illegal_decl_array_of_functions)), 
              getPrintableNameForEntity(new DeclarationName(Entity))), T));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    /*const*/ RecordType /*P*/ EltTy = T.$arrow().getAs$RecordType();
    if ((EltTy != null)) {
      // If the element type is a struct or union that contains a variadic
      // array, accept it as a GNU extension: C99 6.7.2.1p2.
      if (EltTy.getDecl().hasFlexibleArrayMember()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_flexible_array_in_array)), T));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (T.$arrow().isObjCObjectType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_array_of_interfaces)), T));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Do placeholder conversions on the array size expression.
  if ((ArraySize != null) && ArraySize.hasPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().CheckPlaceholderExpr(ArraySize);
    if (Result.isInvalid()) {
      return new QualType();
    }
    ArraySize = Result.get();
  }
  
  // Do lvalue-to-rvalue conversions on the array size expression.
  if ((ArraySize != null) && !ArraySize.isRValue()) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().DefaultLvalueConversion(ArraySize);
    if (Result.isInvalid()) {
      return new QualType();
    }
    
    ArraySize = Result.get();
  }
  
  // C99 6.7.5.2p1: The size expression shall have integer type.
  // C++11 allows contextual conversions to such types.
  if (!$this().getLangOpts().CPlusPlus11
     && (ArraySize != null) && !ArraySize.isTypeDependent()
     && !ArraySize.getType().$arrow().isIntegralOrUnscopedEnumerationType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), diag.err_array_size_non_int)), 
              ArraySize.getType()), ArraySize.getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  APSInt ConstVal/*J*/= new APSInt($ulong2uint($this().Context.getTypeSize($this().Context.getSizeType().$QualType())));
  if (!(ArraySize != null)) {
    if (ASM == ArrayType.ArraySizeModifier.Star) {
      T.$assignMove($this().Context.getVariableArrayType(new QualType(T), (Expr /*P*/ )null, ASM, Quals, new SourceRange(Brackets)));
    } else {
      T.$assignMove($this().Context.getIncompleteArrayType(new QualType(T), ASM, Quals));
    }
  } else if (ArraySize.isTypeDependent() || ArraySize.isValueDependent()) {
    T.$assignMove($this().Context.getDependentSizedArrayType(new QualType(T), ArraySize, ASM, Quals, new SourceRange(Brackets)));
  } else if ((!T.$arrow().isDependentType() && !T.$arrow().isIncompleteType()
     && !T.$arrow().isConstantSizeType())
     || isArraySizeVLA(/*Deref*/$this(), ArraySize, ConstVal)) {
    // Even in C++11, don't allow contextual conversions in the array bound
    // of a VLA.
    if ($this().getLangOpts().CPlusPlus11
       && !ArraySize.getType().$arrow().isIntegralOrUnscopedEnumerationType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), diag.err_array_size_non_int)), 
                ArraySize.getType()), ArraySize.getSourceRange()));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    // C99: an array with an element type that has a non-constant-size is a VLA.
    // C99: an array with a non-ICE size is a VLA.  We accept any expression
    // that we can fold to a non-zero positive value as an extension.
    T.$assignMove($this().Context.getVariableArrayType(new QualType(T), ArraySize, ASM, Quals, new SourceRange(Brackets)));
  } else {
    // C99 6.7.5.2p1: If the expression is a constant expression, it shall
    // have a value greater than zero.
    if (ConstVal.isSigned() && ConstVal.isNegative()) {
      if (Entity.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), diag.err_decl_negative_array_size)), 
                  getPrintableNameForEntity(new DeclarationName(Entity))), ArraySize.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), diag.err_typecheck_negative_array_size)), 
              ArraySize.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      return new QualType();
    }
    if (ConstVal.$eq(0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // GCC accepts zero sized static arrays. We allow them when
        // we're not in a SFINAE context.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), 
                $this().isSFINAEContext().$bool() ? diag.err_typecheck_zero_array_size : diag.ext_typecheck_zero_array_size)), 
            ArraySize.getSourceRange()));
        if (ASM == ArrayType.ArraySizeModifier.Static) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), 
                  diag.warn_typecheck_zero_static_array_size)), 
              ArraySize.getSourceRange()));
          ASM = ArrayType.ArraySizeModifier.Normal;
        }
      } finally {
        $c$.$destroy();
      }
    } else if (!T.$arrow().isDependentType() && !T.$arrow().isVariablyModifiedType()
       && !T.$arrow().isIncompleteType() && !T.$arrow().isUndeducedType()) {
      // Is the array too large?
      /*uint*/int ActiveSizeBits = ConstantArrayType.getNumAddressingBits($this().Context, new QualType(T), ConstVal);
      if ($greater_uint(ActiveSizeBits, ConstantArrayType.getMaxSizeBits($this().Context))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), diag.err_array_too_large)), 
                  ConstVal.__toString(10)), 
              ArraySize.getSourceRange()));
          return new QualType();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    T.$assignMove($this().Context.getConstantArrayType(new QualType(T), ConstVal, ASM, Quals));
  }
  
  // OpenCL v1.2 s6.9.d: variable length arrays are not supported.
  if ($this().getLangOpts().OpenCL && T.$arrow().isVariableArrayType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_opencl_vla)));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  // If this is not C99, extwarn about VLA's and C99 array size modifiers.
  if (!$this().getLangOpts().C99) {
    if (T.$arrow().isVariableArrayType()) {
      // Prohibit the use of VLAs during template argument deduction.
      if ($this().isSFINAEContext().$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_vla_in_sfinae)));
          return new QualType();
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Just extwarn about VLAs.
          $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_vla)));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ASM != ArrayType.ArraySizeModifier.Normal || Quals != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), 
                $this().getLangOpts().CPlusPlus ? diag.err_c99_array_usage_cxx : diag.ext_c99_array_usage)), ASM));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (T.$arrow().isVariableArrayType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Warn about VLAs for -Wvla.
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_vla_used)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // OpenCL v2.0 s6.12.5 - Arrays of blocks are not supported.
  // OpenCL v2.0 s6.16.13.1 - Arrays of pipe type are not supported.
  // OpenCL v2.0 s6.9.b - Arrays of image/sampler type are not supported.
  if ($this().getLangOpts().OpenCL) {
    /*const*/ QualType ArrType = $this().Context.getBaseElementType(new QualType(T));
    if (ArrType.$arrow().isBlockPointerType() || ArrType.$arrow().isPipeType()
       || ArrType.$arrow().isSamplerT() || ArrType.$arrow().isImageType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_opencl_invalid_type_array)), ArrType));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return new QualType(JD$Move.INSTANCE, T);
}


/// \brief Build an ext-vector type.
///
/// Run the required checks for the extended vector type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildExtVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2285,
 FQN="clang::Sema::BuildExtVectorType", NM="_ZN5clang4Sema18BuildExtVectorTypeENS_8QualTypeEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema18BuildExtVectorTypeENS_8QualTypeEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public final QualType BuildExtVectorType(QualType T, Expr /*P*/ ArraySize, 
                  SourceLocation AttrLoc) {
  // Unlike gcc's vector_size attribute, we do not allow vectors to be defined
  // in conjunction with complex types (pointers, arrays, functions, etc.).
  //
  // Additionally, OpenCL prohibits vectors of booleans (they're considered a
  // reserved data type under OpenCL v2.0 s6.1.4), we don't support selects
  // on bitvectors, and we have no well-defined ABI for bitvectors, so vectors
  // of bool aren't allowed.
  if ((!T.$arrow().isDependentType() && !T.$arrow().isIntegerType()
     && !T.$arrow().isRealFloatingType())
     || T.$arrow().isBooleanType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_invalid_vector_type)), T));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (!ArraySize.isTypeDependent() && !ArraySize.isValueDependent()) {
    APSInt vecSize/*J*/= new APSInt(32);
    if (!ArraySize.isIntegerConstantExpr(vecSize, $this().Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_argument_type)), 
                    /*KEEP_STR*/"ext_vector_type"), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
            ArraySize.getSourceRange()));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Unlike gcc's vector_size attribute, the size is specified as the
    // number of elements, not the number of bytes.
    /*uint*/int vectorSize = ((/*static_cast*//*uint*/int)($ulong2uint(vecSize.getZExtValue())));
    if (vectorSize == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_zero_size)), 
            ArraySize.getSourceRange()));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    if (VectorType.isVectorSizeTooLarge(vectorSize)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_size_too_large)), 
            ArraySize.getSourceRange()));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    return $this().Context.getExtVectorType(new QualType(T), vectorSize);
  }
  
  return $this().Context.getDependentSizedExtVectorType(new QualType(T), ArraySize, new SourceLocation(AttrLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFunctionReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2332,
 FQN="clang::Sema::CheckFunctionReturnType", NM="_ZN5clang4Sema23CheckFunctionReturnTypeENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema23CheckFunctionReturnTypeENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final boolean CheckFunctionReturnType(QualType T, SourceLocation Loc) {
  if (T.$arrow().isArrayType() || T.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_func_returning_array_function)), 
              T.$arrow().isFunctionType()), T));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Functions cannot return half FP.
  if (T.$arrow().isHalfType() && !$this().getLangOpts().HalfArgsAndReturns) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_parameters_retval_cannot_have_fp16_type)), 1), 
          FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/$STAR))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Methods cannot return interface types. All ObjC objects are
  // passed by reference.
  if (T.$arrow().isObjCObjectType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_object_cannot_be_passed_returned_by_value)), 0), T));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// \brief Build a function type.
///
/// This routine checks the function type according to C++ rules and
/// under the assumption that the result type and parameter types have
/// just been instantiated from a template. It therefore duplicates
/// some of the behavior of GetTypeForDeclarator, but in a much
/// simpler form that is only suitable for this narrow use case.
///
/// \param T The return type of the function.
///
/// \param ParamTypes The parameter types of the function. This array
/// will be modified to account for adjustments to the types of the
/// function parameters.
///
/// \param Loc The location of the entity whose type involves this
/// function type or, if there is no such entity, the location of the
/// type that will have function type.
///
/// \param Entity The name of the entity that involves the function
/// type, if known.
///
/// \param EPI Extra information about the function type. Usually this will
/// be taken from an existing function with the same prototype.
///
/// \returns A suitable function type, if there are no errors. The
/// unqualified type will always be a FunctionProtoType.
/// Otherwise, returns a NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildFunctionType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2424,
 FQN="clang::Sema::BuildFunctionType", NM="_ZN5clang4Sema17BuildFunctionTypeENS_8QualTypeEN4llvm15MutableArrayRefIS1_EENS_14SourceLocationENS_15DeclarationNameERKNS_17FunctionProtoType12ExtProtoInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema17BuildFunctionTypeENS_8QualTypeEN4llvm15MutableArrayRefIS1_EENS_14SourceLocationENS_15DeclarationNameERKNS_17FunctionProtoType12ExtProtoInfoE")
//</editor-fold>
public final QualType BuildFunctionType(QualType T, 
                 MutableArrayRef<QualType> ParamTypes, 
                 SourceLocation Loc, DeclarationName Entity, 
                 final /*const*/ FunctionProtoType.ExtProtoInfo /*&*/ EPI) {
  boolean Invalid = false;
  
  Invalid |= $this().CheckFunctionReturnType(new QualType(T), new SourceLocation(Loc));
  
  for (/*uint*/int Idx = 0, Cnt = ParamTypes.size(); $less_uint(Idx, Cnt); ++Idx) {
    // FIXME: Loc is too inprecise here, should use proper locations for args.
    QualType ParamType = $this().Context.getAdjustedParameterType(new QualType(ParamTypes.$at(Idx)));
    if (ParamType.$arrow().isVoidType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_param_with_void_type)));
        Invalid = true;
      } finally {
        $c$.$destroy();
      }
    } else if (ParamType.$arrow().isHalfType() && !$this().getLangOpts().HalfArgsAndReturns) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Disallow half FP arguments.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_parameters_retval_cannot_have_fp16_type)), 0), 
            FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/$STAR))));
        Invalid = true;
      } finally {
        $c$.$destroy();
      }
    }
    
    ParamTypes.$at(Idx).$assign(ParamType);
  }
  if ((EPI.ExtParameterInfos != null)) {
    SourceLocation L$Loc = new SourceLocation(Loc);
    checkExtParameterInfos(/*Deref*/$this(), new ArrayRef<QualType>(ParamTypes), EPI, 
        /*FuncArg*//*[=, =L$Loc(Loc)]*/ (/*uint*/int i) -> {
              return new SourceLocation(L$Loc);
            });
  }
  if (Invalid) {
    return new QualType();
  }
  
  return $this().Context.getFunctionType(new QualType(T), new ArrayRef<QualType>(ParamTypes), EPI);
}


/// \brief Build a member pointer type \c T Class::*.
///
/// \param T the type to which the member pointer refers.
/// \param Class the class type into which the member pointer points.
/// \param Loc the location where this type begins
/// \param Entity the name of the entity that will have this member pointer type
///
/// \returns a member pointer type, if successful, or a NULL type if there was
/// an error.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildMemberPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2468,
 FQN="clang::Sema::BuildMemberPointerType", NM="_ZN5clang4Sema22BuildMemberPointerTypeENS_8QualTypeES1_NS_14SourceLocationENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema22BuildMemberPointerTypeENS_8QualTypeES1_NS_14SourceLocationENS_15DeclarationNameE")
//</editor-fold>
public final QualType BuildMemberPointerType(QualType T, QualType Class, 
                      SourceLocation Loc, 
                      DeclarationName Entity) {
  // Verify that we're not building a pointer to pointer to function with
  // exception specification.
  if ($this().CheckDistantExceptionSpec(new QualType(T))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_distant_exception_spec)));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ 8.3.3p3: A pointer to member shall not point to ... a member
  //   with reference type, or "cv void."
  if (T.$arrow().isReferenceType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_illegal_decl_mempointer_to_reference)), 
              getPrintableNameForEntity(new DeclarationName(Entity))), T));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (T.$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_illegal_decl_mempointer_to_void)), 
          getPrintableNameForEntity(new DeclarationName(Entity))));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (!Class.$arrow().isDependentType() && !Class.$arrow().isRecordType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_mempointer_in_nonclass_type)), Class));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Adjust the default free function calling convention to the default method
  // calling convention.
  boolean IsCtorOrDtor = (Entity.getNameKind() == DeclarationName.NameKind.CXXConstructorName)
     || (Entity.getNameKind() == DeclarationName.NameKind.CXXDestructorName);
  if (T.$arrow().isFunctionType()) {
    $this().adjustMemberFunctionCC(T, /*IsStatic=*/ false, IsCtorOrDtor, new SourceLocation(Loc));
  }
  
  return $this().Context.getMemberPointerType(new QualType(T), Class.getTypePtr());
}


/// \brief Build a block pointer type.
///
/// \param T The type to which we'll be building a block pointer.
///
/// \param Loc The source location, used for diagnostics.
///
/// \param Entity The name of the entity that involves the block pointer
/// type, if known.
///
/// \returns A suitable block pointer type, if there are no
/// errors. Otherwise, returns a NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildBlockPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2519,
 FQN="clang::Sema::BuildBlockPointerType", NM="_ZN5clang4Sema21BuildBlockPointerTypeENS_8QualTypeENS_14SourceLocationENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema21BuildBlockPointerTypeENS_8QualTypeENS_14SourceLocationENS_15DeclarationNameE")
//</editor-fold>
public final QualType BuildBlockPointerType(QualType T, 
                     SourceLocation Loc, 
                     DeclarationName Entity) {
  if (!T.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_nonfunction_block_type)));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (checkQualifiedFunction(/*Deref*/$this(), new QualType(T), new SourceLocation(Loc), QualifiedFunctionKind.QFK_BlockPointer)) {
    return new QualType();
  }
  
  return $this().Context.getBlockPointerType(new QualType(T));
}


/// \brief Build a paren type including \p T.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildParenType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1827,
 FQN="clang::Sema::BuildParenType", NM="_ZN5clang4Sema14BuildParenTypeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema14BuildParenTypeENS_8QualTypeE")
//</editor-fold>
public final QualType BuildParenType(QualType T) {
  return $this().Context.getParenType(new QualType(T));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildAtomicType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7363,
 FQN="clang::Sema::BuildAtomicType", NM="_ZN5clang4Sema15BuildAtomicTypeENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema15BuildAtomicTypeENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final QualType BuildAtomicType(QualType T, SourceLocation Loc) {
  if (!T.$arrow().isDependentType()) {
    // FIXME: It isn't entirely clear whether incomplete atomic types
    // are allowed or not; for simplicity, ban them for the moment.
    if ($this().RequireCompleteType$T(new SourceLocation(Loc), new QualType(T), diag.err_atomic_specifier_bad_type, 0)) {
      return new QualType();
    }
    
    int DisallowedKind = -1;
    if (T.$arrow().isArrayType()) {
      DisallowedKind = 1;
    } else if (T.$arrow().isFunctionType()) {
      DisallowedKind = 2;
    } else if (T.$arrow().isReferenceType()) {
      DisallowedKind = 3;
    } else if (T.$arrow().isAtomicType()) {
      DisallowedKind = 4;
    } else if (T.hasQualifiers()) {
      DisallowedKind = 5;
    } else if (!T.isTriviallyCopyableType($this().Context)) {
      // Some other non-trivially-copyable type (probably a C++ class)
      DisallowedKind = 6;
    }
    if (DisallowedKind != -1) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_atomic_specifier_bad_type)), DisallowedKind), T));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    // FIXME: Do we need any handling for ARC here?
  }
  
  // Build the pointer type.
  return $this().Context.getAtomicType(new QualType(T));
}


/// \brief Build a Pipe type.
///
/// \param T The type to which we'll be building a Pipe.
///
/// \param Loc We do not use it for now.
///
/// \returns A suitable pipe type, if there are no errors. Otherwise, returns a
/// NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildPipeType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2041,
 FQN="clang::Sema::BuildPipeType", NM="_ZN5clang4Sema13BuildPipeTypeENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema13BuildPipeTypeENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final QualType BuildPipeType(QualType T, SourceLocation Loc) {
  assert (!T.$arrow().isObjCObjectType()) : "Should build ObjCObjectPointerType";
  
  // Build the pipe type.
  return $this().Context.getPipeType(new QualType(T));
}


/// GetTypeForDeclarator - Convert the type for the specified
/// declarator to Type instances.
///
/// The result of this call will never be null, but the associated
/// type may be a null type if there's an unrecoverable error.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetTypeForDeclarator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4581,
 FQN="clang::Sema::GetTypeForDeclarator", NM="_ZN5clang4Sema20GetTypeForDeclaratorERNS_10DeclaratorEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema20GetTypeForDeclaratorERNS_10DeclaratorEPNS_5ScopeE")
//</editor-fold>
public final TypeSourceInfo /*P*/ GetTypeForDeclarator(final Declarator /*&*/ D, Scope /*P*/ S) {
  TypeProcessingState state = null;
  try {
    // Determine the type of the declarator. Not all forms of declarator
    // have a type.
    state/*J*/= new TypeProcessingState(/*Deref*/$this(), D);
    
    type$ptr<TypeSourceInfo /*P*/ > ReturnTypeInfo = create_type$null$ptr(null);
    QualType T = GetDeclSpecTypeForDeclarator(state, ReturnTypeInfo);
    if (D.isPrototypeContext() && $this().getLangOpts().ObjCAutoRefCount) {
      inferARCWriteback(state, T);
    }
    
    return GetFullTypeForDeclarator(state, new QualType(T), ReturnTypeInfo);
  } finally {
    if (state != null) { state.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetTypeForDeclaratorCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4698,
 FQN="clang::Sema::GetTypeForDeclaratorCast", NM="_ZN5clang4Sema24GetTypeForDeclaratorCastERNS_10DeclaratorENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema24GetTypeForDeclaratorCastERNS_10DeclaratorENS_8QualTypeE")
//</editor-fold>
public final TypeSourceInfo /*P*/ GetTypeForDeclaratorCast(final Declarator /*&*/ D, QualType FromTy) {
  TypeProcessingState state = null;
  try {
    state/*J*/= new TypeProcessingState(/*Deref*/$this(), D);
    
    type$ptr<TypeSourceInfo /*P*/ > ReturnTypeInfo = create_type$null$ptr(null);
    QualType declSpecTy = GetDeclSpecTypeForDeclarator(state, ReturnTypeInfo);
    if ($this().getLangOpts().ObjC1) {
      Qualifiers.ObjCLifetime ownership = $this().Context.getInnerObjCOwnership(new QualType(FromTy));
      if (ownership != Qualifiers.ObjCLifetime.OCL_None) {
        transferARCOwnership(state, declSpecTy, ownership);
      }
    }
    
    return GetFullTypeForDeclarator(state, new QualType(declSpecTy), ReturnTypeInfo);
  } finally {
    if (state != null) { state.$destroy(); }
  }
}


/// \brief Create and instantiate a TypeSourceInfo with type source information.
///
/// \param T QualType referring to the type as written in source code.
///
/// \param ReturnTypeInfo For declarators whose return type does not show
/// up in the normal place in the declaration specifiers (such as a C++
/// conversion function), this pointer will refer to a type source information
/// for that return type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetTypeSourceInfoForDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5145,
 FQN="clang::Sema::GetTypeSourceInfoForDeclarator", NM="_ZN5clang4Sema30GetTypeSourceInfoForDeclaratorERNS_10DeclaratorENS_8QualTypeEPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema30GetTypeSourceInfoForDeclaratorERNS_10DeclaratorENS_8QualTypeEPNS_14TypeSourceInfoE")
//</editor-fold>
public final TypeSourceInfo /*P*/ GetTypeSourceInfoForDeclarator(final Declarator /*&*/ D, QualType T, 
                              TypeSourceInfo /*P*/ ReturnTypeInfo) {
  TypeSourceInfo /*P*/ TInfo = $this().Context.CreateTypeSourceInfo(new QualType(T));
  UnqualTypeLoc CurrTL = TInfo.getTypeLoc().getUnqualifiedLoc();
  /*const*/ AttributeList /*P*/ DeclAttrs = D.getAttributes();
  
  // Handle parameter packs whose type is a pack expansion.
  if (isa_PackExpansionType(T)) {
    CurrTL.castAs(PackExpansionTypeLoc.class).setEllipsisLoc(D.getEllipsisLoc());
    CurrTL.$assignMove(CurrTL.getNextTypeLoc().getUnqualifiedLoc());
  }
  
  for (/*uint*/int i = 0, e = D.getNumTypeObjects(); i != e; ++i) {
    {
      // An AtomicTypeLoc might be produced by an atomic qualifier in this
      // declarator chunk.
      AtomicTypeLoc ATL = CurrTL.getAs(AtomicTypeLoc.class);
      if (ATL.$bool()) {
        fillAtomicQualLoc(new AtomicTypeLoc(ATL), D.getTypeObject(i));
        CurrTL.$assignMove(ATL.getValueLoc().getUnqualifiedLoc());
      }
    }
    {
      
      AttributedTypeLoc TL;
      while ((TL = CurrTL.getAs(AttributedTypeLoc.class)).$bool()) {
        fillAttributedTypeLoc(new AttributedTypeLoc(TL), D.getTypeObject(i).getAttrs(), DeclAttrs);
        CurrTL.$assignMove(TL.getNextTypeLoc().getUnqualifiedLoc());
      }
    }
    {
      
      // FIXME: Ordering here?
      AdjustedTypeLoc TL$1;
      while ((TL$1 = CurrTL.getAs(AdjustedTypeLoc.class)).$bool()) {
        CurrTL.$assignMove(TL$1.getNextTypeLoc().getUnqualifiedLoc());
      }
    }
    
    new DeclaratorLocFiller($this().Context, D.getTypeObject(i)).Visit(new UnqualTypeLoc(CurrTL));
    CurrTL.$assignMove(CurrTL.getNextTypeLoc().getUnqualifiedLoc());
  }
  
  // If we have different source information for the return type, use
  // that.  This really only applies to C++ conversion functions.
  if ((ReturnTypeInfo != null)) {
    TypeLoc TL = ReturnTypeInfo.getTypeLoc();
    assert (TL.getFullDataSize() == CurrTL.getFullDataSize());
    memcpy(CurrTL.getOpaqueData(), TL.getOpaqueData(), TL.getFullDataSize(), TypeLoc.DATA_DEEP_COPY);
  } else {
    new TypeSpecLocFiller($this().Context, D.getDeclSpec()).Visit(new UnqualTypeLoc(CurrTL));
  }
  
  return TInfo;
}


/// \brief Package the given type and TSI into a ParsedType.

/// \brief Create a LocInfoType to hold the given QualType and TypeSourceInfo.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateParsedType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5193,
 FQN="clang::Sema::CreateParsedType", NM="_ZN5clang4Sema16CreateParsedTypeENS_8QualTypeEPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema16CreateParsedTypeENS_8QualTypeEPNS_14TypeSourceInfoE")
//</editor-fold>
public final OpaquePtr<QualType> CreateParsedType(QualType T, TypeSourceInfo /*P*/ TInfo) {
  // FIXME: LocInfoTypes are "transient", only needed for passing to/from Parser
  // and Sema during declaration parsing. Try deallocating/caching them when
  // it's appropriate, instead of allocating them and keeping them around.
  LocInfoType /*P*/ LocT;
  // JAVA: MEMORY
  if (false) {
    LocT = (LocInfoType /*P*/ )$this().BumpAlloc.Allocate($sizeof_LocInfoType(),
            TypeAlignment);
  } else {
    LocT = null;
  }
  /*NEW_EXPR [System]*/LocT = /*new (LocT)*/ $new_uint_voidPtr(LocT, (type$ptr<?> New$Mem)->{
      return new LocInfoType(new QualType(T), TInfo);
   });
  assert (LocT.getTypeClass() != T.$arrow().getTypeClass()) : "LocInfoType's TypeClass conflicts with an existing Type class";
  return OpaquePtr.<QualType>make(new QualType(LocT, 0));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetTypeFromParser">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2533,
 FQN="clang::Sema::GetTypeFromParser", NM="_ZN5clang4Sema17GetTypeFromParserENS_9OpaquePtrINS_8QualTypeEEEPPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema17GetTypeFromParserENS_9OpaquePtrINS_8QualTypeEEEPPNS_14TypeSourceInfoE")
//</editor-fold>
public static QualType GetTypeFromParser(OpaquePtr<QualType> Ty) {
  return GetTypeFromParser(Ty, (type$ptr<TypeSourceInfo /*P*/ /*P*/>)null);
}
public static QualType GetTypeFromParser(OpaquePtr<QualType> Ty, final type$ptr<TypeSourceInfo /*P*/ /*P*/> TInfo/*= null*/) {
  QualType QT = Ty.getQualType();
  if (QT.isNull()) {
    if (TInfo != null) {
      TInfo.$set(null);
    }
    return new QualType();
  }
  
  TypeSourceInfo /*P*/ DI = null;
  {
    /*const*/ LocInfoType /*P*/ LIT = dyn_cast_LocInfoType(QT);
    if ((LIT != null)) {
      QT.$assignMove(LIT.getType());
      DI = LIT.getTypeSourceInfo();
    }
  }
  if (TInfo != null) {
    TInfo.$set(DI);
  }
  return QT;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5212,
 FQN="clang::Sema::ActOnTypeName", NM="_ZN5clang4Sema13ActOnTypeNameEPNS_5ScopeERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema13ActOnTypeNameEPNS_5ScopeERNS_10DeclaratorE")
//</editor-fold>
public final ActionResult<OpaquePtr<QualType> > ActOnTypeName(Scope /*P*/ S, final Declarator /*&*/ D) {
  // C99 6.7.6: Type names have no identifier.  This is already validated by
  // the parser.
  assert (D.getIdentifier() == null) : "Type name should have no identifier!";
  
  TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
  QualType T = TInfo.getType();
  if (D.isInvalidType()) {
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
  }
  
  // Make sure there are no unused decl attributes on the declarator.
  // We don't want to do this for ObjC parameters because we're going
  // to apply them to the actual parameter declaration.
  // Likewise, we don't want to do this for alias declarations, because
  // we are actually going to build a declaration from this eventually.
  if (D.getContext() != Declarator.TheContext.ObjCParameterContext
     && D.getContext() != Declarator.TheContext.AliasDeclContext
     && D.getContext() != Declarator.TheContext.AliasTemplateContext) {
    $this().checkUnusedDeclAttributes(D);
  }
  if ($this().getLangOpts().CPlusPlus) {
    // Check that there are no default arguments (C++ only).
    $this().CheckExtraCXXDefaultArguments(D);
  }
  
  return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(T), TInfo));
}


/// \brief The parser has parsed the context-sensitive type 'instancetype'
/// in an Objective-C message declaration. Return the appropriate type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCInstanceType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5241,
 FQN="clang::Sema::ActOnObjCInstanceType", NM="_ZN5clang4Sema21ActOnObjCInstanceTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema21ActOnObjCInstanceTypeENS_14SourceLocationE")
//</editor-fold>
public final OpaquePtr<QualType> ActOnObjCInstanceType(SourceLocation Loc) {
  QualType T = $this().Context.getObjCInstanceType();
  TypeSourceInfo /*P*/ TInfo = $this().Context.getTrivialTypeSourceInfo(new QualType(T), new SourceLocation(Loc));
  return $this().CreateParsedType(new QualType(T), TInfo);
}


/// \brief The implementation of RequireCompleteType
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireCompleteTypeImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6932,
 FQN="clang::Sema::RequireCompleteTypeImpl", NM="_ZN5clang4Sema23RequireCompleteTypeImplENS_14SourceLocationENS_8QualTypeEPNS0_13TypeDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema23RequireCompleteTypeImplENS_14SourceLocationENS_8QualTypeEPNS0_13TypeDiagnoserE")
//</editor-fold>
protected/*private*/ final boolean RequireCompleteTypeImpl(SourceLocation Loc, QualType T, 
                       TypeDiagnoser /*P*/ Diagnoser) {
  // FIXME: Add this assertion to make sure we always get instantiation points.
  //  assert(!Loc.isInvalid() && "Invalid location in RequireCompleteType");
  // FIXME: Add this assertion to help us flush out problems with
  // checking for dependent types and type-dependent expressions.
  //
  //  assert(!T->isDependentType() &&
  //         "Can't ask whether a dependent type is complete");
  
  // We lock in the inheritance model once somebody has asked us to ensure
  // that a pointer-to-member type is complete.
  if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
    {
      /*const*/ MemberPointerType /*P*/ MPTy = T.$arrow().getAs(MemberPointerType.class);
      if ((MPTy != null)) {
        if (!MPTy.__getClass().isDependentType()) {
          /*J:(void)*/$this().isCompleteType(new SourceLocation(Loc), new QualType(MPTy.__getClass(), 0));
          assignInheritanceModel(/*Deref*/$this(), MPTy.getMostRecentCXXRecordDecl());
        }
      }
    }
  }
  
  type$ptr<NamedDecl /*P*/ > Def = create_type$null$ptr(null);
  boolean Incomplete = T.$arrow().isIncompleteType($AddrOf(Def));
  
  // Check that any necessary explicit specializations are visible. For an
  // enum, we just need the declaration, so don't check this.
  if ((Def.$star() != null) && !isa_EnumDecl(Def)) {
    $this().checkSpecializationVisibility(new SourceLocation(Loc), Def.$star());
  }
  
  // If we have a complete type, we're done.
  if (!Incomplete) {
    // If we know about the definition but it is not visible, complain.
    type$ptr<NamedDecl /*P*/ > SuggestedDef = create_type$null$ptr(null);
    if ((Def.$star() != null)
       && !$this().hasVisibleDefinition(Def.$star(), $AddrOf(SuggestedDef), /*OnlyNeedComplete*/ true)) {
      // If the user is going to see an error here, recover by making the
      // definition visible.
      boolean TreatAsComplete = (Diagnoser != null) && !$this().isSFINAEContext().$bool();
      if ((Diagnoser != null)) {
        $this().diagnoseMissingImport(new SourceLocation(Loc), SuggestedDef.$star(), MissingImportKind.Definition, 
            /*Recover*/ TreatAsComplete);
      }
      return !TreatAsComplete;
    }
    
    return false;
  }
  
  /*const*/ TagType /*P*/ Tag = T.$arrow().getAs(TagType.class);
  /*const*/ ObjCInterfaceType /*P*/ IFace = T.$arrow().getAs$ObjCInterfaceType();
  
  // If there's an unimported definition of this type in a module (for
  // instance, because we forward declared it, then imported the definition),
  // import that definition now.
  //
  // FIXME: What about other cases where an import extends a redeclaration
  // chain for a declaration that can be accessed through a mechanism other
  // than name lookup (eg, referenced in a template, or a variable whose type
  // could be completed by the module)?
  //
  // FIXME: Should we map through to the base array element type before
  // checking for a tag type?
  if ((Tag != null) || (IFace != null)) {
    NamedDecl /*P*/ D = (Tag != null) ? ((/*static_cast*/NamedDecl /*P*/ )(Tag.getDecl())) : IFace.getDecl();
    
    // Avoid diagnosing invalid decls as incomplete.
    if (D.isInvalidDecl()) {
      return true;
    }
    {
      
      // Give the external AST source a chance to complete the type.
      ExternalASTSource /*P*/ Source = $this().Context.getExternalSource();
      if ((Source != null)) {
        if ((Tag != null)) {
          Source.CompleteType(Tag.getDecl());
        } else {
          Source.CompleteType(IFace.getDecl());
        }
        
        // If the external source completed the type, go through the motions
        // again to ensure we're allowed to use the completed type.
        if (!T.$arrow().isIncompleteType()) {
          return $this().RequireCompleteTypeImpl(new SourceLocation(Loc), new QualType(T), Diagnoser);
        }
      }
    }
  }
  
  // If we have a class template specialization or a class member of a
  // class template specialization, or an array with known size of such,
  // try to instantiate it.
  QualType MaybeTemplate = new QualType(T);
  {
    /*const*/ ConstantArrayType /*P*/ Array;
    while (((/*P*/ Array = $this().Context.getAsConstantArrayType(new QualType(MaybeTemplate))) != null)) {
      MaybeTemplate.$assignMove(Array.getElementType());
    }
  }
  {
    /*const*/ RecordType /*P*/ Record = MaybeTemplate.$arrow().getAs$RecordType();
    if ((Record != null)) {
      boolean Instantiated = false;
      boolean Diagnosed = false;
      {
        ClassTemplateSpecializationDecl /*P*/ ClassTemplateSpec = dyn_cast_ClassTemplateSpecializationDecl(Record.getDecl());
        if ((ClassTemplateSpec != null)) {
          if (ClassTemplateSpec.getSpecializationKind() == TemplateSpecializationKind.TSK_Undeclared) {
            Diagnosed = $this().InstantiateClassTemplateSpecialization(new SourceLocation(Loc), ClassTemplateSpec, TemplateSpecializationKind.TSK_ImplicitInstantiation, 
                /*Complain=*/ (Diagnoser != null));
            Instantiated = true;
          }
        } else {
          CXXRecordDecl /*P*/ Rec = dyn_cast_CXXRecordDecl(Record.getDecl());
          if ((Rec != null)) {
            CXXRecordDecl /*P*/ Pattern = Rec.getInstantiatedFromMemberClass();
            if (!Rec.isBeingDefined() && (Pattern != null)) {
              MemberSpecializationInfo /*P*/ MSI = Rec.getMemberSpecializationInfo();
              assert ((MSI != null)) : "Missing member specialization information?";
              // This record was instantiated from a class within a template.
              if (MSI.getTemplateSpecializationKind()
                 != TemplateSpecializationKind.TSK_ExplicitSpecialization) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean(Diagnosed = $this().InstantiateClass(new SourceLocation(Loc), Rec, Pattern, 
                      $c$.track($this().getTemplateInstantiationArgs(Rec)), 
                      TemplateSpecializationKind.TSK_ImplicitInstantiation, 
                      /*Complain=*/ (Diagnoser != null)));
                  Instantiated = true;
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
      if (Instantiated) {
        // Instantiate* might have already complained that the template is not
        // defined, if we asked it to.
        if ((Diagnoser != null) && Diagnosed) {
          return true;
        }
        // If we instantiated a definition, check that it's usable, even if
        // instantiation produced an error, so that repeated calls to this
        // function give consistent answers.
        if (!T.$arrow().isIncompleteType()) {
          return $this().RequireCompleteTypeImpl(new SourceLocation(Loc), new QualType(T), Diagnoser);
        }
      }
    }
  }
  
  // FIXME: If we didn't instantiate a definition because of an explicit
  // specialization declaration, check that it's visible.
  if (!(Diagnoser != null)) {
    return true;
  }
  
  Diagnoser.diagnose(/*Deref*/$this(), new SourceLocation(Loc), new QualType(T));
  
  // If the type was a forward declaration of a class/struct/union
  // type, produce a note.
  if ((Tag != null) && !Tag.getDecl().isInvalidDecl()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Tag.getDecl().getLocation(), 
              Tag.isBeingDefined() ? diag.note_type_being_defined : diag.note_forward_declaration)), 
          new QualType(Tag, 0)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // If the Objective-C class was a forward declaration, produce a note.
  if ((IFace != null) && !IFace.getDecl().isInvalidDecl()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(IFace.getDecl().getLocation(), diag.note_forward_class)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // If we have external information that we can use to suggest a fix,
  // produce a note.
  if (($this().ExternalSource != null)) {
    $this().ExternalSource.MaybeDiagnoseMissingCompleteType(new SourceLocation(Loc), new QualType(T));
  }
  
  return true;
}


/// Determine if \p D has a visible definition. If not, suggest a declaration
/// that should be made visible to expose the definition.

/// \brief Determine whether there is any declaration of \p D that was ever a
///        definition (perhaps before module merging) and is currently visible.
/// \param D The definition of the entity.
/// \param Suggested Filled in with the declaration that should be made visible
///        in order to provide a definition of this entity.
/// \param OnlyNeedComplete If \c true, we only need the type to be complete,
///        not defined. This only matters for enums with a fixed underlying
///        type, since in all other cases, a type is complete if and only if it
///        is defined.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasVisibleDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6848,
 FQN="clang::Sema::hasVisibleDefinition", NM="_ZN5clang4Sema20hasVisibleDefinitionEPNS_9NamedDeclEPS2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema20hasVisibleDefinitionEPNS_9NamedDeclEPS2_b")
//</editor-fold>
public final boolean hasVisibleDefinition(NamedDecl /*P*/ D, type$ptr<NamedDecl /*P*/ /*P*/> Suggested) {
  return hasVisibleDefinition(D, Suggested, 
                    false);
}
public final boolean hasVisibleDefinition(NamedDecl /*P*/ D, type$ptr<NamedDecl /*P*/ /*P*/> Suggested, 
                    boolean OnlyNeedComplete/*= false*/) {
  // Easy case: if we don't have modules, all declarations are visible.
  if (!$this().getLangOpts().Modules && !$this().getLangOpts().ModulesLocalVisibility) {
    return true;
  }
  
  // If this definition was instantiated from a template, map back to the
  // pattern from which it was instantiated.
  if (isa_TagDecl(D) && cast_TagDecl(D).isBeingDefined()) {
    // We're in the middle of defining it; this definition should be treated
    // as visible.
    return true;
  } else {
    CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
    if ((RD != null)) {
      {
        CXXRecordDecl /*P*/ Pattern = RD.getTemplateInstantiationPattern();
        if ((Pattern != null)) {
          RD = Pattern;
        }
      }
      D = RD.getDefinition();
    } else {
      EnumDecl /*P*/ ED = dyn_cast_EnumDecl(D);
      if ((ED != null)) {
        {
          EnumDecl /*P*/ Pattern = ED.getTemplateInstantiationPattern();
          if ((Pattern != null)) {
            ED = Pattern;
          }
        }
        if (OnlyNeedComplete && ED.isFixed()) {
          // If the enum has a fixed underlying type, and we're only looking for a
          // complete type (not a definition), any visible declaration of it will
          // do.
          Suggested.$set(null);
          for (TagDecl /*P*/ Redecl : ED.redeclarable_redecls()) {
            if ($this().isVisible(Redecl)) {
              return true;
            }
            if (Redecl.isThisDeclarationADefinition()
               || (Redecl.isCanonicalDecl() && !(Suggested.$star() != null))) {
              Suggested.$set(Redecl);
            }
          }
          return false;
        }
        D = ED.getDefinition();
      }
    }
  }
  assert ((D != null)) : "missing definition for pattern of instantiated definition";
  
  Suggested.$set(D);
  if ($this().isVisible(D)) {
    return true;
  }
  {
    
    // The external source may have additional definitions of this type that are
    // visible, so complete the redeclaration chain now and ask again.
    ExternalASTSource /*P*/ Source = $this().Context.getExternalSource();
    if ((Source != null)) {
      Source.CompleteRedeclChain(D);
      return $this().isVisible(D);
    }
  }
  
  return false;
}


/// @brief Ensure that the type T is a complete type.
///
/// This routine checks whether the type @p T is complete in any
/// context where a complete type is required. If @p T is a complete
/// type, returns false. If @p T is a class template specialization,
/// this routine then attempts to perform class template
/// instantiation. If instantiation fails, or if @p T is incomplete
/// and cannot be completed, issues the diagnostic @p diag (giving it
/// the type @p T) and returns true.
///
/// @param Loc  The location in the source that the incomplete type
/// diagnostic should refer to.
///
/// @param T  The type that this routine is examining for completeness.
///
/// @returns @c true if @p T is incomplete and a diagnostic was emitted,
/// @c false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireCompleteType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6826,
 FQN="clang::Sema::RequireCompleteType", NM="_ZN5clang4Sema19RequireCompleteTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema19RequireCompleteTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE")
//</editor-fold>
public final boolean RequireCompleteType(SourceLocation Loc, QualType T, 
                   final TypeDiagnoser /*&*/ Diagnoser) {
  if ($this().RequireCompleteTypeImpl(new SourceLocation(Loc), new QualType(T), $AddrOf(Diagnoser))) {
    return true;
  }
  {
    /*const*/ TagType /*P*/ Tag = T.$arrow().getAs(TagType.class);
    if ((Tag != null)) {
      if (!Tag.getDecl().isCompleteDefinitionRequired()) {
        Tag.getDecl().setCompleteDefinitionRequired();
        $this().Consumer.HandleTagDeclRequiredDefinition(Tag.getDecl());
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireCompleteType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7092,
 FQN="clang::Sema::RequireCompleteType", NM="_ZN5clang4Sema19RequireCompleteTypeENS_14SourceLocationENS_8QualTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema19RequireCompleteTypeENS_14SourceLocationENS_8QualTypeEj")
//</editor-fold>
public final boolean RequireCompleteType(SourceLocation Loc, QualType T, 
                   /*uint*/int DiagID) {
  BoundTypeDiagnoser Diagnoser = null;
  try {
    Diagnoser/*J*/= new BoundTypeDiagnoser(DiagID);
    return $this().RequireCompleteType(new SourceLocation(Loc), new QualType(T), Diagnoser);
  } finally {
    if (Diagnoser != null) { Diagnoser.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::completeExprArrayBound">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6728,
 FQN="clang::Sema::completeExprArrayBound", NM="_ZN5clang4Sema22completeExprArrayBoundEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema22completeExprArrayBoundEPNS_4ExprE")
//</editor-fold>
public final void completeExprArrayBound(Expr /*P*/ E) {
  {
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E.IgnoreParens());
    if ((DRE != null)) {
      {
        VarDecl /*P*/ Var = dyn_cast_VarDecl(DRE.getDecl());
        if ((Var != null)) {
          if (isTemplateInstantiation(Var.getTemplateSpecializationKind())) {
            SourceLocation PointOfInstantiation = E.getExprLoc();
            {
              
              MemberSpecializationInfo /*P*/ MSInfo = Var.getMemberSpecializationInfo();
              if ((MSInfo != null)) {
                // If we don't already have a point of instantiation, this is it.
                if (MSInfo.getPointOfInstantiation().isInvalid()) {
                  MSInfo.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
                  {
                    
                    // This is a modification of an existing AST node. Notify
                    // listeners.
                    ASTMutationListener /*P*/ L = $this().getASTMutationListener();
                    if ((L != null)) {
                      L.StaticDataMemberInstantiated(Var);
                    }
                  }
                }
              } else {
                VarTemplateSpecializationDecl /*P*/ VarSpec = cast_VarTemplateSpecializationDecl(Var);
                if (VarSpec.getPointOfInstantiation().isInvalid()) {
                  VarSpec.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
                }
              }
            }
            
            $this().InstantiateVariableDefinition(new SourceLocation(PointOfInstantiation), Var);
            {
              
              // Update the type to the newly instantiated definition's type both
              // here and within the expression.
              VarDecl /*P*/ Def = Var.getDefinition();
              if ((Def != null)) {
                DRE.setDecl(Def);
                QualType T = Def.getType();
                DRE.setType(new QualType(T));
                // FIXME: Update the type on all intervening expressions.
                E.setType(new QualType(T));
              }
            }
            // We still go on to try to complete the type independently, as it
            // may also require instantiations or diagnostics if it remains
            // incomplete.
          }
        }
      }
    }
  }
}


/// \brief Ensure that the type of the given expression is complete.
///
/// This routine checks whether the expression \p E has a complete type. If the
/// expression refers to an instantiable construct, that instantiation is
/// performed as needed to complete its type. Furthermore
/// Sema::RequireCompleteType is called for the expression's type (or in the
/// case of a reference type, the referred-to type).
///
/// \param E The expression whose type is required to be complete.
/// \param Diagnoser The object that will emit a diagnostic if the type is
/// incomplete.
///
/// \returns \c true if the type of \p E is incomplete and diagnosed, \c false
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireCompleteExprType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6786,
 FQN="clang::Sema::RequireCompleteExprType", NM="_ZN5clang4Sema23RequireCompleteExprTypeEPNS_4ExprERNS0_13TypeDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema23RequireCompleteExprTypeEPNS_4ExprERNS0_13TypeDiagnoserE")
//</editor-fold>
public final boolean RequireCompleteExprType(Expr /*P*/ E, final TypeDiagnoser /*&*/ Diagnoser) {
  QualType T = E.getType();
  
  // Incomplete array types may be completed by the initializer attached to
  // their definitions. For static data members of class templates and for
  // variable templates, we need to instantiate the definition to get this
  // initializer and complete the type.
  if (T.$arrow().isIncompleteArrayType()) {
    $this().completeExprArrayBound(E);
    T.$assignMove(E.getType());
  }
  
  // FIXME: Are there other cases which require instantiating something other
  // than the type to complete the type of an expression?
  return $this().RequireCompleteType(E.getExprLoc(), new QualType(T), Diagnoser);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireCompleteExprType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6804,
 FQN="clang::Sema::RequireCompleteExprType", NM="_ZN5clang4Sema23RequireCompleteExprTypeEPNS_4ExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema23RequireCompleteExprTypeEPNS_4ExprEj")
//</editor-fold>
public final boolean RequireCompleteExprType(Expr /*P*/ E, /*uint*/int DiagID) {
  BoundTypeDiagnoser Diagnoser = null;
  try {
    Diagnoser/*J*/= new BoundTypeDiagnoser(DiagID);
    return $this().RequireCompleteExprType(E, Diagnoser);
  } finally {
    if (Diagnoser != null) { Diagnoser.$destroy(); }
  }
}


/// @brief Ensure that the type T is a literal type.
///
/// This routine checks whether the type @p T is a literal type. If @p T is an
/// incomplete type, an attempt is made to complete it. If @p T is a literal
/// type, or @p AllowIncompleteType is true and @p T is an incomplete type,
/// returns false. Otherwise, this routine issues the diagnostic @p PD (giving
/// it the type @p T), along with notes explaining why the type is not a
/// literal type, and returns true.
///
/// @param Loc  The location in the source that the non-literal type
/// diagnostic should refer to.
///
/// @param T  The type that this routine is examining for literalness.
///
/// @param Diagnoser Emits a diagnostic if T is not a literal type.
///
/// @returns @c true if @p T is not a literal type and a diagnostic was emitted,
/// @c false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireLiteralType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7130,
 FQN="clang::Sema::RequireLiteralType", NM="_ZN5clang4Sema18RequireLiteralTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema18RequireLiteralTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE")
//</editor-fold>
public final boolean RequireLiteralType(SourceLocation Loc, QualType T, 
                  final TypeDiagnoser /*&*/ Diagnoser) {
  assert (!T.$arrow().isDependentType()) : "type should not be dependent";
  
  QualType ElemType = $this().Context.getBaseElementType(new QualType(T));
  if (($this().isCompleteType(new SourceLocation(Loc), new QualType(ElemType)) || ElemType.$arrow().isVoidType())
     && T.$arrow().isLiteralType($this().Context)) {
    return false;
  }
  
  Diagnoser.diagnose(/*Deref*/$this(), new SourceLocation(Loc), new QualType(T));
  if (T.$arrow().isVariableArrayType()) {
    return true;
  }
  
  /*const*/ RecordType /*P*/ RT = ElemType.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return true;
  }
  
  /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
  
  // A partially-defined class type can't be a literal type, because a literal
  // class type must have a trivial destructor (which can't be checked until
  // the class definition is complete).
  if ($this().RequireCompleteType$T(new SourceLocation(Loc), new QualType(ElemType), diag.note_non_literal_incomplete, T)) {
    return true;
  }
  
  // If the class has virtual base classes, then it's not an aggregate, and
  // cannot have any constexpr constructors or a trivial default constructor,
  // so is non-literal. This is better to diagnose than the resulting absence
  // of constexpr constructors.
  if ((RD.getNumVBases() != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RD.getLocation(), diag.note_non_literal_virtual_base)), 
              getLiteralDiagFromTagKind(RD.getTagKind())), RD.getNumVBases()));
      for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.vbases$Const())  {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(I.getLocStart(), diag.note_constexpr_virtual_base_here)), 
            I.getSourceRange()));
      }
    } finally {
      $c$.$destroy();
    }
  } else if (!RD.isAggregate() && !RD.hasConstexprNonCopyMoveConstructor()
     && !RD.hasTrivialDefaultConstructor()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RD.getLocation(), diag.note_non_literal_no_constexpr_ctors)), RD));
    } finally {
      $c$.$destroy();
    }
  } else if (RD.hasNonLiteralTypeFieldsOrBases()) {
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      if (!I.getType().$arrow().isLiteralType($this().Context)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(I.getLocStart(), 
                          diag.note_non_literal_base_class)), 
                      RD), I.getType()), I.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    for (/*const*/ FieldDecl /*P*/ I : RD.fields()) {
      if (!I.getType().$arrow().isLiteralType($this().Context)
         || I.getType().isVolatileQualified()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(I.getLocation(), diag.note_non_literal_field)), 
                          RD), I), I.getType()), 
              I.getType().isVolatileQualified()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else if (!RD.hasTrivialDestructor()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // All fields and bases are of literal types, so have trivial destructors.
      // If this class's destructor is non-trivial it must be user-declared.
      CXXDestructorDecl /*P*/ Dtor = RD.getDestructor();
      assert ((Dtor != null)) : "class has literal fields and bases but no dtor?";
      if (!(Dtor != null)) {
        return true;
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Dtor.getLocation(), Dtor.isUserProvided() ? diag.note_non_literal_user_provided_dtor : diag.note_non_literal_nontrivial_dtor)), RD));
      if (!Dtor.isUserProvided()) {
        $this().SpecialMemberIsTrivial(Dtor, CXXSpecialMember.CXXDestructor, /*Diagnose*/ true);
      }
    } finally {
      $c$.$destroy();
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireLiteralType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7205,
 FQN="clang::Sema::RequireLiteralType", NM="_ZN5clang4Sema18RequireLiteralTypeENS_14SourceLocationENS_8QualTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema18RequireLiteralTypeENS_14SourceLocationENS_8QualTypeEj")
//</editor-fold>
public final boolean RequireLiteralType(SourceLocation Loc, QualType T, /*uint*/int DiagID) {
  BoundTypeDiagnoser Diagnoser = null;
  try {
    Diagnoser/*J*/= new BoundTypeDiagnoser(DiagID);
    return $this().RequireLiteralType(new SourceLocation(Loc), new QualType(T), Diagnoser);
  } finally {
    if (Diagnoser != null) { Diagnoser.$destroy(); }
  }
}


/// \brief Retrieve a version of the type 'T' that is elaborated by Keyword
/// and qualified by the nested-name-specifier contained in SS.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getElaboratedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7212,
 FQN="clang::Sema::getElaboratedType", NM="_ZN5clang4Sema17getElaboratedTypeENS_21ElaboratedTypeKeywordERKNS_12CXXScopeSpecENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema17getElaboratedTypeENS_21ElaboratedTypeKeywordERKNS_12CXXScopeSpecENS_8QualTypeE")
//</editor-fold>
public final QualType getElaboratedType(ElaboratedTypeKeyword Keyword, 
                 final /*const*/ CXXScopeSpec /*&*/ SS, QualType T) {
  if (T.isNull()) {
    return new QualType(JD$Move.INSTANCE, T);
  }
  NestedNameSpecifier /*P*/ NNS;
  if (SS.isValid()) {
    NNS = SS.getScopeRep();
  } else {
    if (Keyword == ElaboratedTypeKeyword.ETK_None) {
      return new QualType(JD$Move.INSTANCE, T);
    }
    NNS = null;
  }
  return $this().Context.getElaboratedType(Keyword, NNS, new QualType(T));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildTypeofExprType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7227,
 FQN="clang::Sema::BuildTypeofExprType", NM="_ZN5clang4Sema19BuildTypeofExprTypeEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema19BuildTypeofExprTypeEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public final QualType BuildTypeofExprType(Expr /*P*/ E, SourceLocation Loc) {
  ActionResultTTrue<Expr /*P*/ > ER = $this().CheckPlaceholderExpr(E);
  if (ER.isInvalid()) {
    return new QualType();
  }
  E = ER.get();
  if (!$this().getLangOpts().CPlusPlus && E.refersToBitField()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_sizeof_alignof_typeof_bitfield)), 2));
    } finally {
      $c$.$destroy();
    }
  }
  if (!E.isTypeDependent()) {
    QualType T = E.getType();
    {
      /*const*/ TagType /*P*/ TT = T.$arrow().getAs(TagType.class);
      if ((TT != null)) {
        $this().DiagnoseUseOfDecl(TT.getDecl(), E.getExprLoc());
      }
    }
  }
  return $this().Context.getTypeOfExprType(E);
}

/// If AsUnevaluated is false, E is treated as though it were an evaluated
/// context, such as when building a type for decltype(auto).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildDecltypeType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7312,
 FQN="clang::Sema::BuildDecltypeType", NM="_ZN5clang4Sema17BuildDecltypeTypeEPNS_4ExprENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema17BuildDecltypeTypeEPNS_4ExprENS_14SourceLocationEb")
//</editor-fold>
public final QualType BuildDecltypeType(Expr /*P*/ E, SourceLocation Loc) {
  return BuildDecltypeType(E, Loc, 
                 true);
}
public final QualType BuildDecltypeType(Expr /*P*/ E, SourceLocation Loc, 
                 boolean AsUnevaluated/*= true*/) {
  ActionResultTTrue<Expr /*P*/ > ER = $this().CheckPlaceholderExpr(E);
  if (ER.isInvalid()) {
    return new QualType();
  }
  E = ER.get();
  if (AsUnevaluated && $this().ActiveTemplateInstantiations.empty()
     && E.HasSideEffects($this().Context, false)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The expression operand for decltype is in an unevaluated expression
      // context, so side effects could result in unintended consequences.
      $c$.clean($c$.track($this().Diag(E.getExprLoc(), diag.warn_side_effects_unevaluated_context)));
    } finally {
      $c$.$destroy();
    }
  }
  
  return $this().Context.getDecltypeType(E, getDecltypeForExpr(/*Deref*/$this(), E));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildUnaryTransformType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7328,
 FQN="clang::Sema::BuildUnaryTransformType", NM="_ZN5clang4Sema23BuildUnaryTransformTypeENS_8QualTypeENS_18UnaryTransformType7UTTKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema23BuildUnaryTransformTypeENS_8QualTypeENS_18UnaryTransformType7UTTKindENS_14SourceLocationE")
//</editor-fold>
public final QualType BuildUnaryTransformType(QualType BaseType, 
                       UnaryTransformType.UTTKind UKind, 
                       SourceLocation Loc) {
  switch (UKind) {
   case EnumUnderlyingType:
    if (!BaseType.$arrow().isDependentType() && !BaseType.$arrow().isEnumeralType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_only_enums_have_underlying_types)));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    } else {
      QualType Underlying = new QualType(BaseType);
      if (!BaseType.$arrow().isDependentType()) {
        // The enum could be incomplete if we're parsing its definition or
        // recovering from an error.
        type$ptr<NamedDecl /*P*/ > FwdDecl = create_type$null$ptr(null);
        if (BaseType.$arrow().isIncompleteType($AddrOf(FwdDecl))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_underlying_type_of_incomplete_enum)), BaseType));
            $c$.clean($out_SemaDiagnosticBuilder_NamedDecl($c$.track($this().Diag(FwdDecl.$star().getLocation(), diag.note_forward_declaration)), FwdDecl));
            return new QualType();
          } finally {
            $c$.$destroy();
          }
        }
        
        EnumDecl /*P*/ ED = BaseType.$arrow().getAs$EnumType().getDecl();
        assert ((ED != null)) : "EnumType has no EnumDecl";
        
        $this().DiagnoseUseOfDecl(ED, new SourceLocation(Loc));
        
        Underlying.$assignMove(ED.getIntegerType());
        assert (!Underlying.isNull());
      }
      return $this().Context.getUnaryTransformType(new QualType(BaseType), new QualType(Underlying), 
          UnaryTransformType.UTTKind.EnumUnderlyingType);
    }
  }
  throw new llvm_unreachable("unknown unary transform type");
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseIgnoredQualifiers">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2654,
 FQN="clang::Sema::diagnoseIgnoredQualifiers", NM="_ZN5clang4Sema25diagnoseIgnoredQualifiersEjjNS_14SourceLocationES1_S1_S1_S1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema25diagnoseIgnoredQualifiersEjjNS_14SourceLocationES1_S1_S1_S1_S1_")
//</editor-fold>
public final void diagnoseIgnoredQualifiers(/*uint*/int DiagID, /*uint*/int Quals, 
                         SourceLocation FallbackLoc) {
  diagnoseIgnoredQualifiers(DiagID, Quals, 
                         FallbackLoc, 
                         new SourceLocation(), 
                         new SourceLocation(), 
                         new SourceLocation(), 
                         new SourceLocation(), 
                         new SourceLocation());
}
public final void diagnoseIgnoredQualifiers(/*uint*/int DiagID, /*uint*/int Quals, 
                         SourceLocation FallbackLoc, 
                         SourceLocation ConstQualLoc/*= SourceLocation()*/) {
  diagnoseIgnoredQualifiers(DiagID, Quals, 
                         FallbackLoc, 
                         ConstQualLoc, 
                         new SourceLocation(), 
                         new SourceLocation(), 
                         new SourceLocation(), 
                         new SourceLocation());
}
public final void diagnoseIgnoredQualifiers(/*uint*/int DiagID, /*uint*/int Quals, 
                         SourceLocation FallbackLoc, 
                         SourceLocation ConstQualLoc/*= SourceLocation()*/, 
                         SourceLocation VolatileQualLoc/*= SourceLocation()*/) {
  diagnoseIgnoredQualifiers(DiagID, Quals, 
                         FallbackLoc, 
                         ConstQualLoc, 
                         VolatileQualLoc, 
                         new SourceLocation(), 
                         new SourceLocation(), 
                         new SourceLocation());
}
public final void diagnoseIgnoredQualifiers(/*uint*/int DiagID, /*uint*/int Quals, 
                         SourceLocation FallbackLoc, 
                         SourceLocation ConstQualLoc/*= SourceLocation()*/, 
                         SourceLocation VolatileQualLoc/*= SourceLocation()*/, 
                         SourceLocation RestrictQualLoc/*= SourceLocation()*/) {
  diagnoseIgnoredQualifiers(DiagID, Quals, 
                         FallbackLoc, 
                         ConstQualLoc, 
                         VolatileQualLoc, 
                         RestrictQualLoc, 
                         new SourceLocation(), 
                         new SourceLocation());
}
public final void diagnoseIgnoredQualifiers(/*uint*/int DiagID, /*uint*/int Quals, 
                         SourceLocation FallbackLoc, 
                         SourceLocation ConstQualLoc/*= SourceLocation()*/, 
                         SourceLocation VolatileQualLoc/*= SourceLocation()*/, 
                         SourceLocation RestrictQualLoc/*= SourceLocation()*/, 
                         SourceLocation AtomicQualLoc/*= SourceLocation()*/) {
  diagnoseIgnoredQualifiers(DiagID, Quals, 
                         FallbackLoc, 
                         ConstQualLoc, 
                         VolatileQualLoc, 
                         RestrictQualLoc, 
                         AtomicQualLoc, 
                         new SourceLocation());
}
public final void diagnoseIgnoredQualifiers(/*uint*/int DiagID, /*uint*/int Quals, 
                         SourceLocation FallbackLoc, 
                         SourceLocation ConstQualLoc/*= SourceLocation()*/, 
                         SourceLocation VolatileQualLoc/*= SourceLocation()*/, 
                         SourceLocation RestrictQualLoc/*= SourceLocation()*/, 
                         SourceLocation AtomicQualLoc/*= SourceLocation()*/, 
                         SourceLocation UnalignedQualLoc/*= SourceLocation()*/) {
  FixItHint[] FixIts = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!(Quals != 0)) {
      return;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Qual">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2664,
     FQN="Qual", NM="_ZZN5clang4Sema25diagnoseIgnoredQualifiersEjjNS_14SourceLocationES1_S1_S1_S1_S1_E4Qual",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZZN5clang4Sema25diagnoseIgnoredQualifiersEjjNS_14SourceLocationES1_S1_S1_S1_S1_E4Qual")
    //</editor-fold>
     class/*struct*/ Qual {
      public /*const*/char$ptr/*char P*/ Name;
      public /*uint*/int Mask;
      public SourceLocation Loc;
      //////////////////////////////////////////////////////////////
      // EXTRA MEMBERS: BEGIN

      public Qual(char$ptr Name, int Mask, SourceLocation Loc) {this.Name = Name; this.Mask = Mask; this.Loc = Loc;}

      // EXTRA MEMBERS: END
      //////////////////////////////////////////////////////////////
      
      @Override public String toString() {
        return "" + "Name=" + Name // NOI18N
                  + ", Mask=" + Mask // NOI18N
                  + ", Loc=" + Loc; // NOI18N
      }
    }/*const*/
  Qual QualKinds[/*5*/] = new /*const*/  Qual [/*5*/] {
      new  Qual($const, DeclSpec.TQ.TQ_const.getValue(), ConstQualLoc), 
      new  Qual($volatile, DeclSpec.TQ.TQ_volatile.getValue(), VolatileQualLoc), 
      new  Qual($restrict, DeclSpec.TQ.TQ_restrict.getValue(), RestrictQualLoc), 
      new  Qual($__unaligned, DeclSpec.TQ.TQ_unaligned.getValue(), UnalignedQualLoc), 
      new  Qual($_Atomic, DeclSpec.TQ.TQ_atomic.getValue(), AtomicQualLoc)
    };
    
    SmallString/*32*/ QualStr/*J*/= new SmallString/*32*/(32);
    /*uint*/int NumQuals = 0;
    SourceLocation Loc/*J*/= new SourceLocation();
    FixIts/*J*/= new$T(new FixItHint [5], ()->new FixItHint());
    
    // Build a string naming the redundant qualifiers.
    for (final /*const*/ Qual /*&*/ E : QualKinds) {
      if (((Quals & E.Mask) != 0)) {
        if (!QualStr.empty()) {
          QualStr.$addassign($$SPACE);
        }
        QualStr.$addassign(/*STRINGREF_STR*/E.Name);
        
        // If we have a location for the qualifier, offer a fixit.
        SourceLocation QualLoc = new SourceLocation(E.Loc);
        if (QualLoc.isValid()) {
          FixIts[NumQuals].$assignMove(FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/QualLoc)));
          if (Loc.isInvalid()
             || $this().getSourceManager().isBeforeInTranslationUnit(/*NO_COPY*/QualLoc, /*NO_COPY*/Loc)) {
            Loc.$assign(QualLoc);
          }
        }
        
        ++NumQuals;
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc.isInvalid() ? FallbackLoc : Loc), DiagID)), 
                            QualStr), NumQuals), FixIts[0]), FixIts[1]), FixIts[2]), FixIts[3]));
  } finally {
    if (FixIts != null) {
      for(FixItHint f : FixIts){
        f.$destroy();
      }
    }
    $c$.$destroy();
  }
}


/// Adjust the calling convention of a method to be the ABI default if it
/// wasn't specified explicitly.  This handles method types formed from
/// function type typedefs and typename template arguments.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::adjustMemberFunctionCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6256,
 FQN="clang::Sema::adjustMemberFunctionCC", NM="_ZN5clang4Sema22adjustMemberFunctionCCERNS_8QualTypeEbbNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema22adjustMemberFunctionCCERNS_8QualTypeEbbNS_14SourceLocationE")
//</editor-fold>
public final void adjustMemberFunctionCC(final QualType /*&*/ T, boolean IsStatic, boolean IsCtorOrDtor, 
                      SourceLocation Loc) {
  FunctionTypeUnwrapper Unwrapped = null;
  try {
    Unwrapped/*J*/= new FunctionTypeUnwrapper(/*Deref*/$this(), new QualType(T));
    /*const*/ FunctionType /*P*/ FT = Unwrapped.get();
    boolean IsVariadic = (isa_FunctionProtoType(FT)
       && cast_FunctionProtoType(FT).isVariadic());
    CallingConv CurCC = FT.getCallConv();
    CallingConv ToCC = $this().Context.getDefaultCallingConvention(IsVariadic, !IsStatic);
    if (CurCC == ToCC) {
      return;
    }
    
    // MS compiler ignores explicit calling convention attributes on structors. We
    // should do the same.
    if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft() && IsCtorOrDtor) {
      // Issue a warning on ignored calling convention -- except of __stdcall.
      // Again, this is what MS compiler does.
      if (CurCC != CallingConv.CC_X86StdCall) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_cconv_structors)), 
              FunctionType.getNameForCallConv(CurCC)));
        } finally {
          $c$.$destroy();
        }
      }
      // Default adjustment.
    } else {
      // Only adjust types with the default convention.  For example, on Windows
      // we should adjust a __cdecl type to __thiscall for instance methods, and a
      // __thiscall type to __cdecl for static methods.
      CallingConv DefaultCC = $this().Context.getDefaultCallingConvention(IsVariadic, IsStatic);
      if (CurCC != DefaultCC || DefaultCC == ToCC) {
        return;
      }
      if ($this().hasExplicitCallingConv(T)) {
        return;
      }
    }
    
    FT = $this().Context.adjustFunctionType(FT, FT.getExtInfo().withCallingConv(ToCC));
    QualType Wrapped = Unwrapped.wrap(/*Deref*/$this(), FT);
    T.$assignMove($this().Context.getAdjustedType(new QualType(T), new QualType(Wrapped)));
  } finally {
    if (Unwrapped != null) { Unwrapped.$destroy(); }
  }
}


// Check if there is an explicit attribute, but only look through parens.
// The intent is to look for an attribute on the current declarator, but not
// one that came from a typedef.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasExplicitCallingConv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6246,
 FQN="clang::Sema::hasExplicitCallingConv", NM="_ZN5clang4Sema22hasExplicitCallingConvERNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema22hasExplicitCallingConvERNS_8QualTypeE")
//</editor-fold>
public final boolean hasExplicitCallingConv(final QualType /*&*/ T) {
  QualType R = T.IgnoreParens();
  {
    /*const*/ AttributedType /*P*/ AT;
    while (((/*P*/ AT = dyn_cast_AttributedType(R)) != null)) {
      if (AT.isCallingConv()) {
        return true;
      }
      R.$assignMove(AT.getModifiedType().IgnoreParens());
    }
  }
  return false;
}


/// Check whether a nullability type specifier can be added to the given
/// type.
///
/// \param type The type to which the nullability specifier will be
/// added. On success, this type will be updated appropriately.
///
/// \param nullability The nullability specifier to add.
///
/// \param nullabilityLoc The location of the nullability specifier.
///
/// \param isContextSensitive Whether this nullability specifier was
/// written as a context-sensitive keyword (in an Objective-C
/// method) or an Objective-C property attribute, rather than as an
/// underscored type specifier.
///
/// \returns true if nullability cannot be applied, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkNullabilityTypeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5811,
 FQN="clang::Sema::checkNullabilityTypeSpecifier", NM="_ZN5clang4Sema29checkNullabilityTypeSpecifierERNS_8QualTypeENS_15NullabilityKindENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema29checkNullabilityTypeSpecifierERNS_8QualTypeENS_15NullabilityKindENS_14SourceLocationEb")
//</editor-fold>
public final boolean checkNullabilityTypeSpecifier(final QualType /*&*/ type, 
                             NullabilityKind nullability, 
                             SourceLocation nullabilityLoc, 
                             boolean isContextSensitive) {
  // We saw a nullability type specifier. If this is the first one for
  // this file, note that.
  FileID file = getNullabilityCompletenessCheckFileID(/*Deref*/$this(), new SourceLocation(nullabilityLoc));
  if (!file.isInvalid()) {
    final FileNullability /*&*/ fileNullability = $this().NullabilityMap.$at(/*NO_COPY*/file);
    if (!fileNullability.SawTypeNullability) {
      // If we have already seen a pointer declarator without a nullability
      // annotation, complain about it.
      if (fileNullability.PointerLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(fileNullability.PointerLoc), diag.warn_nullability_missing)), 
              ((/*static_cast*//*uint*/int)($uchar2uint(fileNullability.PointerKind)))));
        } finally {
          $c$.$destroy();
        }
      }
      
      fileNullability.SawTypeNullability = true;
    }
  }
  
  // Check for existing nullability attributes on the type.
  QualType desugared = new QualType(type);
  {
    /*const*/ AttributedType /*P*/ attributed;
    while (((/*P*/ attributed = dyn_cast_AttributedType(desugared.getTypePtr())) != null)) {
      {
        // Check whether there is already a null
        Optional<NullabilityKind> existingNullability = attributed.getImmediateNullability();
        if (existingNullability.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Duplicated nullability.
            if (nullability == existingNullability.$star()) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(nullabilityLoc), diag.warn_nullability_duplicate)), 
                      new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability, isContextSensitive)), 
                  FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/nullabilityLoc))));
              
              break;
            }
            
            // Conflicting nullability.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(nullabilityLoc), diag.err_nullability_conflicting)), 
                    new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability, isContextSensitive)), 
                new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, existingNullability.$star(), false)));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      desugared.$assignMove(attributed.getModifiedType());
    }
  }
  {
    
    // If there is already a different nullability specifier, complain.
    // This (unlike the code above) looks through typedefs that might
    // have nullability specifiers on them, which means we cannot
    // provide a useful Fix-It.
    Optional<NullabilityKind> existingNullability = desugared.$arrow().getNullability($this().Context);
    if (existingNullability.$bool()) {
      if (nullability != existingNullability.$star()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(nullabilityLoc), diag.err_nullability_conflicting)), 
                  new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability, isContextSensitive)), 
              new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, existingNullability.$star(), false)));
          {
            
            // Try to find the typedef with the existing nullability specifier.
            /*const*/ TypedefType /*P*/ typedefType = desugared.$arrow().getAs$TypedefType();
            if ((typedefType != null)) {
              TypedefNameDecl /*P*/ typedefDecl = typedefType.getDecl();
              QualType underlyingType = typedefDecl.getUnderlyingType();
              {
                Optional<NullabilityKind> typedefNullability = AttributedType.stripOuterNullability(underlyingType);
                if (typedefNullability.$bool()) {
                  if (typedefNullability.$star() == existingNullability.$star()) {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(typedefDecl.getLocation(), diag.note_nullability_here)), 
                        new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, existingNullability.$star(), false)));
                  }
                }
              }
            }
          }
          
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // If this definitely isn't a pointer type, reject the specifier.
  if (!desugared.$arrow().canHaveNullability()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(nullabilityLoc), diag.err_nullability_nonpointer)), 
              new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability, isContextSensitive)), type));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // For the context-sensitive keywords/Objective-C property
  // attributes, require that the type be a single-level pointer.
  if (isContextSensitive) {
    // Make sure that the pointee isn't itself a pointer type.
    QualType pointeeType = desugared.$arrow().getPointeeType();
    if (pointeeType.$arrow().isAnyPointerType()
       || pointeeType.$arrow().isObjCObjectPointerType()
       || pointeeType.$arrow().isMemberPointerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(nullabilityLoc), diag.err_nullability_cs_multilevel)), 
                new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability, true)), 
            type));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(nullabilityLoc), diag.note_nullability_type_specifier)), 
                    new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability, false)), 
                type), 
            FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/nullabilityLoc), 
                getNullabilitySpelling(nullability))));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Form the attributed type.
  type.$assignMove($this().Context.getAttributedType(AttributedType.getNullabilityAttrKind(nullability), new QualType(type), new QualType(type)));
  return false;
}


/// Build a an Objective-C protocol-qualified 'id' type where no
/// base type was specified.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::actOnObjCProtocolQualifierType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1088,
 FQN="clang::Sema::actOnObjCProtocolQualifierType", NM="_ZN5clang4Sema30actOnObjCProtocolQualifierTypeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4DeclEEENS3_IS1_EES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema30actOnObjCProtocolQualifierTypeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4DeclEEENS3_IS1_EES1_")
//</editor-fold>
public final <T extends Decl /*P*/> ActionResult<OpaquePtr<QualType> > actOnObjCProtocolQualifierType(SourceLocation lAngleLoc, 
                              ArrayRef<T> protocols, 
                              ArrayRef<SourceLocation> protocolLocs, 
                              SourceLocation rAngleLoc) {
  // Form id<protocol-list>.
  QualType Result = $this().Context.getObjCObjectType($this().Context.ObjCBuiltinIdTy.$QualType(), /*{ */new ArrayRef<QualType>(false)/* }*/, 
      llvm.makeArrayRef((type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>)protocols.data(), 
          protocols.size()), 
      false);
  Result.$assignMove($this().Context.getObjCObjectPointerType(new QualType(Result)));
  
  TypeSourceInfo /*P*/ ResultTInfo = $this().Context.CreateTypeSourceInfo(new QualType(Result));
  TypeLoc ResultTL = ResultTInfo.getTypeLoc();
  
  ObjCObjectPointerTypeLoc ObjCObjectPointerTL = ResultTL.castAs(ObjCObjectPointerTypeLoc.class);
  ObjCObjectPointerTL.setStarLoc(new SourceLocation()); // implicit
  
  ObjCObjectTypeLoc ObjCObjectTL = ObjCObjectPointerTL.getPointeeLoc().castAs(ObjCObjectTypeLoc.class);
  ObjCObjectTL.setHasBaseTypeAsWritten(false);
  ObjCObjectTL.getBaseLoc().initialize($this().Context, new SourceLocation());
  
  // No type arguments.
  ObjCObjectTL.setTypeArgsLAngleLoc(new SourceLocation());
  ObjCObjectTL.setTypeArgsRAngleLoc(new SourceLocation());
  
  // Fill in protocol qualifiers.
  ObjCObjectTL.setProtocolLAngleLoc(new SourceLocation(lAngleLoc));
  ObjCObjectTL.setProtocolRAngleLoc(new SourceLocation(rAngleLoc));
  for (/*uint*/int i = 0, n = protocols.size(); i != n; ++i)  {
    ObjCObjectTL.setProtocolLoc(i, new SourceLocation(protocolLocs.$at(i)));
  }
  
  // We're done. Return the completed type to the parser.
  return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(Result), ResultTInfo));
}


/// Build a specialized and/or protocol-qualified Objective-C type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::actOnObjCTypeArgsAndProtocolQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1127,
 FQN="clang::Sema::actOnObjCTypeArgsAndProtocolQualifiers", NM="_ZN5clang4Sema38actOnObjCTypeArgsAndProtocolQualifiersEPNS_5ScopeENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES3_N4llvm8ArrayRefIS6_EES3_S3_NS8_IPNS_4DeclEEENS8_IS3_EES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema38actOnObjCTypeArgsAndProtocolQualifiersEPNS_5ScopeENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES3_N4llvm8ArrayRefIS6_EES3_S3_NS8_IPNS_4DeclEEENS8_IS3_EES3_")
//</editor-fold>
public final <T extends Decl> ActionResult<OpaquePtr<QualType> > actOnObjCTypeArgsAndProtocolQualifiers(Scope /*P*/ S, 
                                      SourceLocation Loc, 
                                      OpaquePtr<QualType> BaseType, 
                                      SourceLocation TypeArgsLAngleLoc, 
                                      ArrayRef<OpaquePtr<QualType>> TypeArgs, 
                                      SourceLocation TypeArgsRAngleLoc, 
                                      SourceLocation ProtocolLAngleLoc, 
                                      ArrayRef<T> Protocols, 
                                      ArrayRef<SourceLocation> ProtocolLocs, 
                                      SourceLocation ProtocolRAngleLoc) {
  type$ptr<TypeSourceInfo /*P*/ > BaseTypeInfo = create_type$null$ptr(null);
  QualType T = GetTypeFromParser(new OpaquePtr<QualType>(BaseType), $AddrOf(BaseTypeInfo));
  if (T.isNull()) {
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
  }
  
  // Handle missing type-source info.
  if (!(BaseTypeInfo.$star() != null)) {
    BaseTypeInfo.$set($this().Context.getTrivialTypeSourceInfo(new QualType(T), new SourceLocation(Loc)));
  }
  
  // Extract type arguments.
  SmallVector<TypeSourceInfo /*P*/ > ActualTypeArgInfos/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(4, (TypeSourceInfo /*P*/ )null);
  for (/*uint*/int i = 0, n = TypeArgs.size(); i != n; ++i) {
    type$ptr<TypeSourceInfo /*P*/ > TypeArgInfo = create_type$null$ptr(null);
    QualType TypeArg = GetTypeFromParser(new OpaquePtr<QualType>(TypeArgs.$at(i)), $AddrOf(TypeArgInfo));
    if (TypeArg.isNull()) {
      ActualTypeArgInfos.clear();
      break;
    }
    assert ((TypeArgInfo.$star() != null)) : "No type source info?";
    ActualTypeArgInfos.push_back(TypeArgInfo.$star());
  }
  
  // Build the object type.
  QualType Result = $this().BuildObjCObjectType(new QualType(T), BaseTypeInfo.$star().getTypeLoc().getSourceRange().getBegin(), 
      new SourceLocation(TypeArgsLAngleLoc), new ArrayRef<TypeSourceInfo /*P*/ >(ActualTypeArgInfos, true), new SourceLocation(TypeArgsRAngleLoc), 
      new SourceLocation(ProtocolLAngleLoc), 
      llvm.makeArrayRef((type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>)Protocols.data(), 
          Protocols.size()), 
      new ArrayRef<SourceLocation>(ProtocolLocs), new SourceLocation(ProtocolRAngleLoc), 
      /*FailOnError=*/ false);
  if ($eq_QualType$C(Result, T)) {
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<QualType>(BaseType));
  }
  
  // Create source information for this type.
  TypeSourceInfo /*P*/ ResultTInfo = $this().Context.CreateTypeSourceInfo(new QualType(Result));
  TypeLoc ResultTL = ResultTInfo.getTypeLoc();
  {
    
    // For id<Proto1, Proto2> or Class<Proto1, Proto2>, we'll have an
    // object pointer type. Fill in source information for it.
    ObjCObjectPointerTypeLoc ObjCObjectPointerTL = ResultTL.getAs(ObjCObjectPointerTypeLoc.class);
    if (ObjCObjectPointerTL.$bool()) {
      // The '*' is implicit.
      ObjCObjectPointerTL.setStarLoc(new SourceLocation());
      ResultTL.$assignMove(ObjCObjectPointerTL.getPointeeLoc());
    }
  }
  
  ObjCObjectTypeLoc ObjCObjectTL = ResultTL.castAs(ObjCObjectTypeLoc.class);
  
  // Type argument information.
  if ($greater_uint(ObjCObjectTL.getNumTypeArgs(), 0)) {
    assert (ObjCObjectTL.getNumTypeArgs() == ActualTypeArgInfos.size());
    ObjCObjectTL.setTypeArgsLAngleLoc(new SourceLocation(TypeArgsLAngleLoc));
    ObjCObjectTL.setTypeArgsRAngleLoc(new SourceLocation(TypeArgsRAngleLoc));
    for (/*uint*/int i = 0, n = ActualTypeArgInfos.size(); i != n; ++i)  {
      ObjCObjectTL.setTypeArgTInfo(i, ActualTypeArgInfos.$at(i));
    }
  } else {
    ObjCObjectTL.setTypeArgsLAngleLoc(new SourceLocation());
    ObjCObjectTL.setTypeArgsRAngleLoc(new SourceLocation());
  }
  
  // Protocol qualifier information.
  if ($greater_uint(ObjCObjectTL.getNumProtocols(), 0)) {
    assert (ObjCObjectTL.getNumProtocols() == Protocols.size());
    ObjCObjectTL.setProtocolLAngleLoc(new SourceLocation(ProtocolLAngleLoc));
    ObjCObjectTL.setProtocolRAngleLoc(new SourceLocation(ProtocolRAngleLoc));
    for (/*uint*/int i = 0, n = Protocols.size(); i != n; ++i)  {
      ObjCObjectTL.setProtocolLoc(i, new SourceLocation(ProtocolLocs.$at(i)));
    }
  } else {
    ObjCObjectTL.setProtocolLAngleLoc(new SourceLocation());
    ObjCObjectTL.setProtocolRAngleLoc(new SourceLocation());
  }
  
  // Base type.
  ObjCObjectTL.setHasBaseTypeAsWritten(true);
  if ($eq_QualType$C(ObjCObjectTL.getType(), T)) {
    ObjCObjectTL.getBaseLoc().initializeFullCopy(BaseTypeInfo.$star().getTypeLoc());
  } else {
    ObjCObjectTL.getBaseLoc().initialize($this().Context, new SourceLocation(Loc));
  }
  
  // We're done. Return the completed type to the parser.
  return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(Result), ResultTInfo));
}


/// Build an Objective-C object pointer type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCObjectType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1054,
 FQN="clang::Sema::BuildObjCObjectType", NM="_ZN5clang4Sema19BuildObjCObjectTypeENS_8QualTypeENS_14SourceLocationES2_N4llvm8ArrayRefIPNS_14TypeSourceInfoEEES2_S2_NS4_IPNS_16ObjCProtocolDeclEEENS4_IS2_EES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema19BuildObjCObjectTypeENS_8QualTypeENS_14SourceLocationES2_N4llvm8ArrayRefIPNS_14TypeSourceInfoEEES2_S2_NS4_IPNS_16ObjCProtocolDeclEEENS4_IS2_EES2_b")
//</editor-fold>
public final QualType BuildObjCObjectType(QualType BaseType, 
                   SourceLocation Loc, 
                   SourceLocation TypeArgsLAngleLoc, 
                   ArrayRef<TypeSourceInfo /*P*/ > TypeArgs, 
                   SourceLocation TypeArgsRAngleLoc, 
                   SourceLocation ProtocolLAngleLoc, 
                   ArrayRef<ObjCProtocolDecl /*P*/ > Protocols, 
                   ArrayRef<SourceLocation> ProtocolLocs, 
                   SourceLocation ProtocolRAngleLoc) {
  return BuildObjCObjectType(BaseType, 
                   Loc, 
                   TypeArgsLAngleLoc, 
                   TypeArgs, 
                   TypeArgsRAngleLoc, 
                   ProtocolLAngleLoc, 
                   Protocols, 
                   ProtocolLocs, 
                   ProtocolRAngleLoc, 
                   false);
}
public final QualType BuildObjCObjectType(QualType BaseType, 
                   SourceLocation Loc, 
                   SourceLocation TypeArgsLAngleLoc, 
                   ArrayRef<TypeSourceInfo /*P*/ > TypeArgs, 
                   SourceLocation TypeArgsRAngleLoc, 
                   SourceLocation ProtocolLAngleLoc, 
                   ArrayRef<ObjCProtocolDecl /*P*/ > Protocols, 
                   ArrayRef<SourceLocation> ProtocolLocs, 
                   SourceLocation ProtocolRAngleLoc, 
                   boolean FailOnError/*= false*/) {
  QualType Result = new QualType(BaseType);
  if (!TypeArgs.empty()) {
    Result.$assignMove(applyObjCTypeArgs(/*Deref*/$this(), new SourceLocation(Loc), new QualType(Result), new ArrayRef<TypeSourceInfo /*P*/ >(TypeArgs), 
            new SourceRange(/*NO_COPY*/TypeArgsLAngleLoc, 
                /*NO_COPY*/TypeArgsRAngleLoc), 
            FailOnError));
    if (FailOnError && Result.isNull()) {
      return new QualType();
    }
  }
  if (!Protocols.empty()) {
    Result.$assignMove(applyObjCProtocolQualifiers(/*Deref*/$this(), new SourceLocation(Loc), 
            new SourceRange(/*NO_COPY*/ProtocolLAngleLoc, 
                /*NO_COPY*/ProtocolRAngleLoc), 
            new QualType(Result), new ArrayRef<ObjCProtocolDecl /*P*/ >(Protocols), 
            ProtocolLocs.data(), 
            FailOnError));
    if (FailOnError && Result.isNull()) {
      return new QualType();
    }
  }
  
  return Result;
}


/// Check the application of the Objective-C '__kindof' qualifier to
/// the given type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkObjCKindOfType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5916,
 FQN="clang::Sema::checkObjCKindOfType", NM="_ZN5clang4Sema19checkObjCKindOfTypeERNS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema19checkObjCKindOfTypeERNS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final boolean checkObjCKindOfType(final QualType /*&*/ type, SourceLocation loc) {
  // Find out if it's an Objective-C object or object pointer type;
  /*const*/ ObjCObjectPointerType /*P*/ ptrType = type.$arrow().getAs(ObjCObjectPointerType.class);
  /*const*/ ObjCObjectType /*P*/ objType = (ptrType != null) ? ptrType.getObjectType() : type.$arrow().getAs(ObjCObjectType.class);
  
  // If not, we can't apply __kindof.
  if (!(objType != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Handle dependent types that aren't yet object types.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(loc), diag.err_objc_kindof_nonobject)), 
          type));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Rebuild the "equivalent" type, which pushes __kindof down into
  // the object type.
  // There is no need to apply kindof on an unqualified id type.
  QualType equivType = $this().Context.getObjCObjectType(objType.getBaseType(), objType.getTypeArgsAsWritten(), 
      objType.getProtocols(), 
      /*isKindOf=*/ objType.isObjCUnqualifiedId() ? false : true);
  
  // If we started with an object pointer type, rebuild it.
  if ((ptrType != null)) {
    equivType.$assignMove($this().Context.getObjCObjectPointerType(new QualType(equivType)));
    {
      Optional<NullabilityKind> nullability = type.$arrow().getNullability($this().Context);
      if (nullability.$bool()) {
        AttributedType.Kind attrKind = AttributedType.getNullabilityAttrKind(nullability.$star());
        equivType.$assignMove($this().Context.getAttributedType(attrKind, new QualType(equivType), new QualType(equivType)));
      }
    }
  }
  
  // Build the attributed type to record where __kindof occurred.
  type.$assignMove($this().Context.getAttributedType(AttributedType.Kind.attr_objc_kindof, 
          new QualType(type), 
          new QualType(equivType)));
  
  return false;
}

/// Retrieve the keyword associated
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getNullabilityKeyword">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.VALUE_TYPE,       
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3218,
 FQN="clang::Sema::getNullabilityKeyword", NM="_ZN5clang4Sema21getNullabilityKeywordENS_15NullabilityKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema21getNullabilityKeywordENS_15NullabilityKindE")
//</editor-fold>
public final IdentifierInfo /*P*/ getNullabilityKeyword(NullabilityKind nullability) {
  switch (nullability) {
   case NonNull:
    if (!($this().Ident__Nonnull != null)) {
      $this().Ident__Nonnull = $this().PP.getIdentifierInfo(/*JAVA:PERF*/$_Nonnull.$array(), $_Nonnull.$index(), strlen($_Nonnull));
    }
    return $this().Ident__Nonnull;
   case Nullable:
    if (!($this().Ident__Nullable != null)) {
      $this().Ident__Nullable = $this().PP.getIdentifierInfo(/*JAVA:PERF*/$_Nullable.$array(), $_Nullable.$index(), strlen($_Nullable));
    }
    return $this().Ident__Nullable;
   case Unspecified:
    if (!($this().Ident__Null_unspecified != null)) {
      $this().Ident__Null_unspecified = $this().PP.getIdentifierInfo(/*JAVA:PERF*/$_Null_unspecified.$array(), $_Null_unspecified.$index(), strlen($_Null_unspecified));
    }
    return $this().Ident__Null_unspecified;
  }
  throw new llvm_unreachable("Unknown nullability kind.");
}


/// Retrieve the identifier "NSError".

/// Retrieve the identifier "NSError".
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getNSErrorIdent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3239,
 FQN="clang::Sema::getNSErrorIdent", NM="_ZN5clang4Sema15getNSErrorIdentEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang4Sema15getNSErrorIdentEv")
//</editor-fold>
public final IdentifierInfo /*P*/ getNSErrorIdent() {
  if (!($this().Ident_NSError != null)) {
    $this().Ident_NSError = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"NSError"));
  }
  
  return $this().Ident_NSError;
}

} // END OF class Sema_SemaType
