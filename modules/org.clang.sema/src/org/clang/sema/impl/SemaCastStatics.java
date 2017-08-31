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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.aliases.*;
;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.Qualifiers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaCastStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL12TryConstCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEbRj;_ZL13TryStaticCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS0_21CheckedConversionKindENS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb;_ZL15diagnoseBadCastRN5clang4SemaEj8CastTypeNS_11SourceRangeEPNS_4ExprENS_8QualTypeEb;_ZL17TryStaticDowncastRN5clang4SemaENS_7CanQualINS_4TypeEEES4_bNS_11SourceRangeENS_8QualTypeES6_RjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE;_ZL18CastsAwayConstnessRN5clang4SemaENS_8QualTypeES2_bbPS2_S3_PNS_10QualifiersE;_ZL18TryReinterpretCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEbNS_11SourceRangeERjRNS_8CastKindE;_ZL21DiagnoseCastOfObjCSELRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE;_ZL21TryLValueToRValueCastRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEERj;_ZL21TryStaticImplicitCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS0_21CheckedConversionKindENS_11SourceRangeERjRNS_8CastKindEb;_ZL21checkIntToPointerCastbN5clang14SourceLocationEPKNS_4ExprENS_8QualTypeERNS_4SemaE;_ZL23DiagnoseBadFunctionCastRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE;_ZL23DiagnoseCallingConvCastRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS_11SourceRangeE;_ZL24TryStaticPointerDowncastRN5clang4SemaENS_8QualTypeES2_bNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE;_ZL25tryDiagnoseOverloadedCastRN5clang4SemaE8CastTypeNS_11SourceRangeEPNS_4ExprENS_8QualTypeEb;_ZL26TryStaticReferenceDowncastRN5clang4SemaEPNS_4ExprENS_8QualTypeEbNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE;_ZL28TryStaticMemberPointerUpcastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeES7_bNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE;_ZL28UnwrapDissimilarPointerTypesRN5clang8QualTypeES1_;_ZL29DiagnoseReinterpretUpDownCastRN5clang4SemaEPKNS_4ExprENS_8QualTypeENS_11SourceRangeE;_ZL32fixOverloadedReinterpretCastExprRN5clang4SemaENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEE; -static-type=SemaCastStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaCastStatics {


// The Try functions attempt a specific way of casting. If they succeed, they
// return TC_Success. If their way of casting is not appropriate for the given
// arguments, they return TC_NotApplicable and *may* set diag to a diagnostic
// to emit if no other way succeeds. If their way of casting is appropriate but
// fails, they return TC_Failed and *must* set diag; they can set it to 0 if
// they emit a specialized diagnostic.
// All diagnostics returned by these functions must expect the same three
// arguments:
// %0: Cast Type (a value from the CastType enumeration)
// %1: Source Type
// %2: Destination Type

/// Tests whether a conversion according to N2844 is valid.
//<editor-fold defaultstate="collapsed" desc="TryLValueToRValueCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1134,
 FQN="TryLValueToRValueCast", NM="_ZL21TryLValueToRValueCastRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL21TryLValueToRValueCastRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEERj")
//</editor-fold>
public static TryCastResult TryLValueToRValueCast(final Sema /*&*/ Self, Expr /*P*/ SrcExpr, QualType DestType, 
                     boolean CStyle, final type$ref<CastKind /*&*/> Kind, final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath, 
                     final uint$ref/*uint &*/ msg) {
  // C++11 [expr.static.cast]p3:
  //   A glvalue of type "cv1 T1" can be cast to type "rvalue reference to 
  //   cv2 T2" if "cv2 T2" is reference-compatible with "cv1 T1".
  /*const*/ RValueReferenceType /*P*/ R = DestType.$arrow().getAs(RValueReferenceType.class);
  if (!(R != null)) {
    return TryCastResult.TC_NotApplicable;
  }
  if (!SrcExpr.isGLValue()) {
    return TryCastResult.TC_NotApplicable;
  }
  
  // Because we try the reference downcast before this function, from now on
  // this is the only cast possibility, so we issue an error if we fail now.
  // FIXME: Should allow casting away constness if CStyle.
  bool$ref DerivedToBase = create_bool$ref();
  bool$ref ObjCConversion = create_bool$ref();
  bool$ref ObjCLifetimeConversion = create_bool$ref();
  QualType FromType = SrcExpr.getType();
  QualType ToType = R.getPointeeType();
  if (CStyle) {
    FromType.$assignMove(FromType.getUnqualifiedType());
    ToType.$assignMove(ToType.getUnqualifiedType());
  }
  if (Self.CompareReferenceRelationship(SrcExpr.getLocStart(), 
      new QualType(ToType), new QualType(FromType), 
      DerivedToBase, ObjCConversion, 
      ObjCLifetimeConversion).getValue()
     < Sema.ReferenceCompareResult.Ref_Compatible_With_Added_Qualification.getValue()) {
    if (CStyle) {
      return TryCastResult.TC_NotApplicable;
    }
    msg.$set(diag.err_bad_lvalue_to_rvalue_cast);
    return TryCastResult.TC_Failed;
  }
  if (DerivedToBase.$deref()) {
    CXXBasePaths Paths = null;
    try {
      Kind.$set(CastKind.CK_DerivedToBase);
      Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
          /*DetectVirtual=*/ true);
      if (!Self.IsDerivedFrom(SrcExpr.getLocStart(), SrcExpr.getType(), 
          R.getPointeeType(), Paths)) {
        return TryCastResult.TC_NotApplicable;
      }
      
      Self.BuildBasePathArray(Paths, BasePath);
    } finally {
      if (Paths != null) { Paths.$destroy(); }
    }
  } else {
    Kind.$set(CastKind.CK_NoOp);
  }
  
  return TryCastResult.TC_Success;
}


/// Tests whether a conversion according to C++ 5.2.9p5 is valid.
//<editor-fold defaultstate="collapsed" desc="TryStaticReferenceDowncast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1188,
 FQN="TryStaticReferenceDowncast", NM="_ZL26TryStaticReferenceDowncastRN5clang4SemaEPNS_4ExprENS_8QualTypeEbNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL26TryStaticReferenceDowncastRN5clang4SemaEPNS_4ExprENS_8QualTypeEbNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE")
//</editor-fold>
public static TryCastResult TryStaticReferenceDowncast(final Sema /*&*/ Self, Expr /*P*/ SrcExpr, QualType DestType, 
                          boolean CStyle, SourceRange OpRange, 
                          final uint$ref/*uint &*/ msg, final type$ref<CastKind /*&*/> Kind, 
                          final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath) {
  // C++ 5.2.9p5: An lvalue of type "cv1 B", where B is a class type, can be
  //   cast to type "reference to cv2 D", where D is a class derived from B,
  //   if a valid standard conversion from "pointer to D" to "pointer to B"
  //   exists, cv2 >= cv1, and B is not a virtual base class of D.
  // In addition, DR54 clarifies that the base must be accessible in the
  // current context. Although the wording of DR54 only applies to the pointer
  // variant of this rule, the intent is clearly for it to apply to the this
  // conversion as well.
  /*const*/ ReferenceType /*P*/ DestReference = DestType.$arrow().getAs(ReferenceType.class);
  if (!(DestReference != null)) {
    return TryCastResult.TC_NotApplicable;
  }
  boolean RValueRef = DestReference.isRValueReferenceType();
  if (!RValueRef && !SrcExpr.isLValue()) {
    // We know the left side is an lvalue reference, so we can suggest a reason.
    msg.$set(diag.err_bad_cxx_cast_rvalue);
    return TryCastResult.TC_NotApplicable;
  }
  
  QualType DestPointee = DestReference.getPointeeType();
  
  // FIXME: If the source is a prvalue, we should issue a warning (because the
  // cast always has undefined behavior), and for AST consistency, we should
  // materialize a temporary.
  return TryStaticDowncast(Self, 
      Self.Context.getCanonicalType(SrcExpr.getType()), 
      Self.Context.getCanonicalType(new QualType(DestPointee)), CStyle, 
      new SourceRange(OpRange), SrcExpr.getType(), new QualType(DestType), msg, Kind, 
      BasePath);
}


/// Tests whether a conversion according to C++ 5.2.9p8 is valid.
//<editor-fold defaultstate="collapsed" desc="TryStaticPointerDowncast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1226,
 FQN="TryStaticPointerDowncast", NM="_ZL24TryStaticPointerDowncastRN5clang4SemaENS_8QualTypeES2_bNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL24TryStaticPointerDowncastRN5clang4SemaENS_8QualTypeES2_bNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE")
//</editor-fold>
public static TryCastResult TryStaticPointerDowncast(final Sema /*&*/ Self, QualType SrcType, QualType DestType, 
                        boolean CStyle, SourceRange OpRange, 
                        final uint$ref/*uint &*/ msg, final type$ref<CastKind /*&*/> Kind, 
                        final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath) {
  // C++ 5.2.9p8: An rvalue of type "pointer to cv1 B", where B is a class
  //   type, can be converted to an rvalue of type "pointer to cv2 D", where D
  //   is a class derived from B, if a valid standard conversion from "pointer
  //   to D" to "pointer to B" exists, cv2 >= cv1, and B is not a virtual base
  //   class of D.
  // In addition, DR54 clarifies that the base must be accessible in the
  // current context.
  /*const*/ PointerType /*P*/ DestPointer = DestType.$arrow().getAs(PointerType.class);
  if (!(DestPointer != null)) {
    return TryCastResult.TC_NotApplicable;
  }
  
  /*const*/ PointerType /*P*/ SrcPointer = SrcType.$arrow().getAs(PointerType.class);
  if (!(SrcPointer != null)) {
    msg.$set(diag.err_bad_static_cast_pointer_nonpointer);
    return TryCastResult.TC_NotApplicable;
  }
  
  return TryStaticDowncast(Self, 
      Self.Context.getCanonicalType(SrcPointer.getPointeeType()), 
      Self.Context.getCanonicalType(DestPointer.getPointeeType()), 
      CStyle, new SourceRange(OpRange), new QualType(SrcType), new QualType(DestType), msg, Kind, 
      BasePath);
}


/// TryStaticDowncast - Common functionality of TryStaticReferenceDowncast and
/// TryStaticPointerDowncast. Tests whether a static downcast from SrcType to
/// DestType is possible and allowed.
//<editor-fold defaultstate="collapsed" desc="TryStaticDowncast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1260,
 FQN="TryStaticDowncast", NM="_ZL17TryStaticDowncastRN5clang4SemaENS_7CanQualINS_4TypeEEES4_bNS_11SourceRangeENS_8QualTypeES6_RjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL17TryStaticDowncastRN5clang4SemaENS_7CanQualINS_4TypeEEES4_bNS_11SourceRangeENS_8QualTypeES6_RjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE")
//</editor-fold>
public static TryCastResult TryStaticDowncast(final Sema /*&*/ Self, CanQual<Type> SrcType, CanQual<Type> DestType, 
                 boolean CStyle, SourceRange OpRange, QualType OrigSrcType, 
                 QualType OrigDestType, final uint$ref/*uint &*/ msg, 
                 final type$ref<CastKind /*&*/> Kind, final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath) {
  CXXBasePaths Paths = null;
  try {
    // We can only work with complete types. But don't complain if it doesn't work
    if (!Self.isCompleteType(OpRange.getBegin(), SrcType.$QualType())
       || !Self.isCompleteType(OpRange.getBegin(), DestType.$QualType())) {
      return TryCastResult.TC_NotApplicable;
    }
    
    // Downcast can only happen in class hierarchies, so we need classes.
    if (!((((CanProxyRecordType)((CanProxyType)DestType.$arrow()).$arrow().getAs(RecordType.class)).$T$C$P()) != null) || !((((CanProxyRecordType)((CanProxyType)SrcType.$arrow()).$arrow().getAs(RecordType.class)).$T$C$P()) != null)) {
      return TryCastResult.TC_NotApplicable;
    }
    
    Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
        /*DetectVirtual=*/ true);
    if (!Self.IsDerivedFrom(OpRange.getBegin(), DestType.$QualType(), SrcType.$QualType(), Paths)) {
      return TryCastResult.TC_NotApplicable;
    }
    
    // Target type does derive from source type. Now we're serious. If an error
    // appears now, it's not ignored.
    // This may not be entirely in line with the standard. Take for example:
    // struct A {};
    // struct B : virtual A {
    //   B(A&);
    // };
    //
    // void f()
    // {
    //   (void)static_cast<const B&>(*((A*)0));
    // }
    // As far as the standard is concerned, p5 does not apply (A is virtual), so
    // p2 should be used instead - "const B& t(*((A*)0));" is perfectly valid.
    // However, both GCC and Comeau reject this example, and accepting it would
    // mean more complex code if we're to preserve the nice error message.
    // FIXME: Being 100% compliant here would be nice to have.
    
    // Must preserve cv, as always, unless we're in C-style mode.
    if (!CStyle && !DestType.isAtLeastAsQualifiedAs(new CanQual<Type>(SrcType))) {
      msg.$set(diag.err_bad_cxx_cast_qualifiers_away);
      return TryCastResult.TC_Failed;
    }
    if (Paths.isAmbiguous(SrcType.getUnqualifiedType())) {
      std.setUInt DisplayedPaths = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // This code is analoguous to that in CheckDerivedToBaseConversion, except
        // that it builds the paths in reverse order.
        // To sum up: record all paths to the base and build a nice string from
        // them. Use it to spice up the error message.
        if (!Paths.isRecordingPaths()) {
          Paths.clear();
          Paths.setRecordingPaths(true);
          Self.IsDerivedFrom(OpRange.getBegin(), DestType.$QualType(), SrcType.$QualType(), Paths);
        }
        std.string PathDisplayStr/*J*/= new std.string();
        DisplayedPaths/*J*/= new std.setUInt();
        for (final CXXBasePath /*&*/ Path : Paths) {
          if (DisplayedPaths.insert_T$RR(Path.back().SubobjectNumber).second) {
            // We haven't displayed a path to this particular base
            // class subobject yet.
            PathDisplayStr.$addassign_T$C$P(/*KEEP_STR*/"\n    ");
            for (final CXXBasePathElement /*&*/ PE : llvm.reverse$NotHasRBegin(Path))  {
              PathDisplayStr.$addassign($add_string_T$C$P(PE.Base.getType().getAsString(), /*KEEP_STR*/" -> "));
            }
            PathDisplayStr.$addassign(DestType.$QualType().getAsString());
          }
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_ambiguous_base_to_derived_cast)), 
                        SrcType.$QualType().getUnqualifiedType()), 
                    DestType.$QualType().getUnqualifiedType()), 
                PathDisplayStr), OpRange));
        msg.$set(0);
        return TryCastResult.TC_Failed;
      } finally {
        if (DisplayedPaths != null) { DisplayedPaths.$destroy(); }
        $c$.$destroy();
      }
    }
    if (Paths.getDetectedVirtual() != null) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        QualType VirtualBase/*J*/= new QualType(Paths.getDetectedVirtual(), 0);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_static_downcast_via_virtual)), 
                        OrigSrcType), OrigDestType), VirtualBase), OpRange));
        msg.$set(0);
        return TryCastResult.TC_Failed;
      } finally {
        $c$.$destroy();
      }
    }
    if (!CStyle) {
      switch (Self.CheckBaseClassAccess(OpRange.getBegin(), 
          SrcType.$QualType(), DestType.$QualType(), 
          Paths.front(), 
          diag.err_downcast_from_inaccessible_base)) {
       case AR_accessible:
       case AR_delayed: // be optimistic
       case AR_dependent: // be optimistic
        break;
       case AR_inaccessible:
        msg.$set(0);
        return TryCastResult.TC_Failed;
      }
    }
    
    Self.BuildBasePathArray(Paths, BasePath);
    Kind.$set(CastKind.CK_BaseToDerived);
    return TryCastResult.TC_Success;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
  }
}


/// TryStaticMemberPointerUpcast - Tests whether a conversion according to
/// C++ 5.2.9p9 is valid:
///
///   An rvalue of type "pointer to member of D of type cv1 T" can be
///   converted to an rvalue of type "pointer to member of B of type cv2 T",
///   where B is a base class of D [...].
///
//<editor-fold defaultstate="collapsed" desc="TryStaticMemberPointerUpcast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1372,
 FQN="TryStaticMemberPointerUpcast", NM="_ZL28TryStaticMemberPointerUpcastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeES7_bNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL28TryStaticMemberPointerUpcastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeES7_bNS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE")
//</editor-fold>
public static TryCastResult TryStaticMemberPointerUpcast(final Sema /*&*/ Self, final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, QualType SrcType, 
                            QualType DestType, boolean CStyle, 
                            SourceRange OpRange, 
                            final uint$ref/*uint &*/ msg, final type$ref<CastKind /*&*/> Kind, 
                            final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath) {
  CXXBasePaths Paths = null;
  try {
    /*const*/ MemberPointerType /*P*/ DestMemPtr = DestType.$arrow().getAs(MemberPointerType.class);
    if (!(DestMemPtr != null)) {
      return TryCastResult.TC_NotApplicable;
    }
    
    boolean WasOverloadedFunction = false;
    DeclAccessPair FoundOverload/*J*/= new DeclAccessPair();
    if ($eq_QualType$C(SrcExpr.get().getType(), Self.Context.OverloadTy.$QualType())) {
      {
        FunctionDecl /*P*/ Fn = Self.ResolveAddressOfOverloadedFunction(SrcExpr.get(), new QualType(DestType), false, 
            FoundOverload);
        if ((Fn != null)) {
          CXXMethodDecl /*P*/ M = cast_CXXMethodDecl(Fn);
          SrcType.$assignMove(Self.Context.getMemberPointerType(Fn.getType(), 
                  Self.Context.getTypeDeclType(M.getParent()).getTypePtr()));
          WasOverloadedFunction = true;
        }
      }
    }
    
    /*const*/ MemberPointerType /*P*/ SrcMemPtr = SrcType.$arrow().getAs(MemberPointerType.class);
    if (!(SrcMemPtr != null)) {
      msg.$set(diag.err_bad_static_cast_member_pointer_nonmp);
      return TryCastResult.TC_NotApplicable;
    }
    
    // Lock down the inheritance model right now in MS ABI, whether or not the
    // pointee types are the same.
    if (Self.Context.getTargetInfo().getCXXABI().isMicrosoft()) {
      /*(void)*/Self.isCompleteType(OpRange.getBegin(), new QualType(SrcType));
      /*(void)*/Self.isCompleteType(OpRange.getBegin(), new QualType(DestType));
    }
    
    // T == T, modulo cv
    if (!Self.Context.hasSameUnqualifiedType(SrcMemPtr.getPointeeType(), 
        DestMemPtr.getPointeeType())) {
      return TryCastResult.TC_NotApplicable;
    }
    
    // B base of D
    QualType SrcClass/*J*/= new QualType(SrcMemPtr.__getClass(), 0);
    QualType DestClass/*J*/= new QualType(DestMemPtr.__getClass(), 0);
    Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
        /*DetectVirtual=*/ true);
    if (!Self.IsDerivedFrom(OpRange.getBegin(), new QualType(SrcClass), new QualType(DestClass), Paths)) {
      return TryCastResult.TC_NotApplicable;
    }
    
    // B is a base of D. But is it an allowed base? If not, it's a hard error.
    if (Paths.isAmbiguous(Self.Context.getCanonicalType(new QualType(DestClass)))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Paths.clear();
        Paths.setRecordingPaths(true);
        boolean StillOkay = Self.IsDerivedFrom(OpRange.getBegin(), new QualType(SrcClass), new QualType(DestClass), Paths);
        assert (StillOkay);
        //(void)StillOkay;
        std.string PathDisplayStr = Self.getAmbiguousPathsDisplayString(Paths);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_ambiguous_memptr_conv)), 
                            1), SrcClass), DestClass), PathDisplayStr), OpRange));
        msg.$set(0);
        return TryCastResult.TC_Failed;
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      /*const*/ RecordType /*P*/ VBase = Paths.getDetectedVirtual();
      if ((VBase != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_memptr_conv_via_virtual)), 
                          SrcClass), DestClass), new QualType(VBase, 0)), OpRange));
          msg.$set(0);
          return TryCastResult.TC_Failed;
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!CStyle) {
      switch (Self.CheckBaseClassAccess(OpRange.getBegin(), 
          new QualType(DestClass), new QualType(SrcClass), 
          Paths.front(), 
          diag.err_upcast_to_inaccessible_base)) {
       case AR_accessible:
       case AR_delayed:
       case AR_dependent:
        // Optimistically assume that the delayed and dependent cases
        // will work out.
        break;
       case AR_inaccessible:
        msg.$set(0);
        return TryCastResult.TC_Failed;
      }
    }
    if (WasOverloadedFunction) {
      // Resolve the address of the overloaded function again, this time
      // allowing complaints if something goes wrong.
      FunctionDecl /*P*/ Fn = Self.ResolveAddressOfOverloadedFunction(SrcExpr.get(), 
          new QualType(DestType), 
          true, 
          FoundOverload);
      if (!(Fn != null)) {
        msg.$set(0);
        return TryCastResult.TC_Failed;
      }
      
      SrcExpr.$assignMove(Self.FixOverloadedFunctionReference(new ActionResultTTrue<Expr /*P*/ >(SrcExpr), new DeclAccessPair(FoundOverload), Fn));
      if (!SrcExpr.isUsable()) {
        msg.$set(0);
        return TryCastResult.TC_Failed;
      }
    }
    
    Self.BuildBasePathArray(Paths, BasePath);
    Kind.$set(CastKind.CK_DerivedToBaseMemberPointer);
    return TryCastResult.TC_Success;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
  }
}


/// TryStaticImplicitCast - Tests whether a conversion according to C++ 5.2.9p2
/// is valid:
///
///   An expression e can be explicitly converted to a type T using a
///   @c static_cast if the declaration "T t(e);" is well-formed [...].
//<editor-fold defaultstate="collapsed" desc="TryStaticImplicitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1490,
 FQN="TryStaticImplicitCast", NM="_ZL21TryStaticImplicitCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS0_21CheckedConversionKindENS_11SourceRangeERjRNS_8CastKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL21TryStaticImplicitCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS0_21CheckedConversionKindENS_11SourceRangeERjRNS_8CastKindEb")
//</editor-fold>
public static TryCastResult TryStaticImplicitCast(final Sema /*&*/ Self, final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, QualType DestType, 
                     Sema.CheckedConversionKind CCK, 
                     SourceRange OpRange, final uint$ref/*uint &*/ msg, 
                     final type$ref<CastKind /*&*/> Kind, boolean ListInitialization) {
  InitializationSequence InitSeq = null;
  try {
    if (DestType.$arrow().isRecordType()) {
      if (Self.RequireCompleteType(OpRange.getBegin(), new QualType(DestType), 
          diag.err_bad_dynamic_cast_incomplete)
         || Self.RequireNonAbstractType$T(OpRange.getBegin(), new QualType(DestType), 
          diag.err_allocation_of_abstract_type)) {
        msg.$set(0);
        return TryCastResult.TC_Failed;
      }
    }
    
    InitializedEntity Entity = InitializedEntity.InitializeTemporary(new QualType(DestType));
    InitializationKind InitKind = (CCK == Sema.CheckedConversionKind.CCK_CStyleCast) ? InitializationKind.CreateCStyleCast(OpRange.getBegin(), new SourceRange(OpRange), 
        ListInitialization) : (CCK == Sema.CheckedConversionKind.CCK_FunctionalCast) ? InitializationKind.CreateFunctionalCast(new SourceRange(OpRange), ListInitialization) : InitializationKind.CreateCast(new SourceRange(OpRange));
    Expr /*P*/ SrcExprRaw = SrcExpr.get();
    InitSeq/*J*/= new InitializationSequence(Self, Entity, InitKind, new MutableArrayRef<Expr /*P*/ >(SrcExprRaw, true));
    
    // At this point of CheckStaticCast, if the destination is a reference,
    // or the expression is an overload expression this has to work. 
    // There is no other way that works.
    // On the other hand, if we're checking a C-style cast, we've still got
    // the reinterpret_cast way.
    boolean CStyle = (CCK == Sema.CheckedConversionKind.CCK_CStyleCast || CCK == Sema.CheckedConversionKind.CCK_FunctionalCast);
    if (InitSeq.Failed() && (CStyle || !DestType.$arrow().isReferenceType())) {
      return TryCastResult.TC_NotApplicable;
    }
    
    ActionResultTTrue<Expr /*P*/ > Result = InitSeq.Perform(Self, Entity, InitKind, new MutableArrayRef<Expr /*P*/ >(SrcExprRaw, true));
    if (Result.isInvalid()) {
      msg.$set(0);
      return TryCastResult.TC_Failed;
    }
    if (InitSeq.isConstructorInitialization()) {
      Kind.$set(CastKind.CK_ConstructorConversion);
    } else {
      Kind.$set(CastKind.CK_NoOp);
    }
    
    SrcExpr.$assign(Result);
    return TryCastResult.TC_Success;
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
  }
}


/// TryStaticCast - Check if a static cast can be performed, and do so if
/// possible. If @p CStyle, ignore access restrictions on hierarchy casting
/// and casting away constness.
//<editor-fold defaultstate="collapsed" desc="TryStaticCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 945,
 FQN="TryStaticCast", NM="_ZL13TryStaticCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS0_21CheckedConversionKindENS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL13TryStaticCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS0_21CheckedConversionKindENS_11SourceRangeERjRNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb")
//</editor-fold>
public static TryCastResult TryStaticCast(final Sema /*&*/ Self, final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, 
             QualType DestType, 
             Sema.CheckedConversionKind CCK, 
             SourceRange OpRange, final uint$ref/*uint &*/ msg, 
             final type$ref<CastKind /*&*/> Kind, final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath, 
             boolean ListInitialization) {
  // Determine whether we have the semantics of a C-style cast.
  boolean CStyle = (CCK == Sema.CheckedConversionKind.CCK_CStyleCast || CCK == Sema.CheckedConversionKind.CCK_FunctionalCast);
  
  // The order the tests is not entirely arbitrary. There is one conversion
  // that can be handled in two different ways. Given:
  // struct A {};
  // struct B : public A {
  //   B(); B(const A&);
  // };
  // const A &a = B();
  // the cast static_cast<const B&>(a) could be seen as either a static
  // reference downcast, or an explicit invocation of the user-defined
  // conversion using B's conversion constructor.
  // DR 427 specifies that the downcast is to be applied here.
  
  // C++ 5.2.9p4: Any expression can be explicitly converted to type "cv void".
  // Done outside this function.
  TryCastResult tcr;
  
  // C++ 5.2.9p5, reference downcast.
  // See the function for details.
  // DR 427 specifies that this is to be applied before paragraph 2.
  tcr = TryStaticReferenceDowncast(Self, SrcExpr.get(), new QualType(DestType), CStyle, 
      new SourceRange(OpRange), msg, Kind, BasePath);
  if (tcr != TryCastResult.TC_NotApplicable) {
    return tcr;
  }
  
  // C++11 [expr.static.cast]p3: 
  //   A glvalue of type "cv1 T1" can be cast to type "rvalue reference to cv2
  //   T2" if "cv2 T2" is reference-compatible with "cv1 T1".
  tcr = TryLValueToRValueCast(Self, SrcExpr.get(), new QualType(DestType), CStyle, Kind, 
      BasePath, msg);
  if (tcr != TryCastResult.TC_NotApplicable) {
    return tcr;
  }
  
  // C++ 5.2.9p2: An expression e can be explicitly converted to a type T
  //   [...] if the declaration "T t(e);" is well-formed, [...].
  tcr = TryStaticImplicitCast(Self, SrcExpr, new QualType(DestType), CCK, new SourceRange(OpRange), msg, 
      Kind, ListInitialization);
  if (SrcExpr.isInvalid()) {
    return TryCastResult.TC_Failed;
  }
  if (tcr != TryCastResult.TC_NotApplicable) {
    return tcr;
  }
  
  // C++ 5.2.9p6: May apply the reverse of any standard conversion, except
  // lvalue-to-rvalue, array-to-pointer, function-to-pointer, and boolean
  // conversions, subject to further restrictions.
  // Also, C++ 5.2.9p1 forbids casting away constness, which makes reversal
  // of qualification conversions impossible.
  // In the CStyle case, the earlier attempt to const_cast should have taken
  // care of reverse qualification conversions.
  QualType SrcType = Self.Context.getCanonicalType(SrcExpr.get().getType()).$QualType();
  {
    
    // C++0x 5.2.9p9: A value of a scoped enumeration type can be explicitly
    // converted to an integral type. [...] A value of a scoped enumeration type
    // can also be explicitly converted to a floating-point type [...].
    /*const*/ EnumType /*P*/ Enum = SrcType.$arrow().<EnumType>getAs$EnumType();
    if ((Enum != null)) {
      if (Enum.getDecl().isScoped()) {
        if (DestType.$arrow().isBooleanType()) {
          Kind.$set(CastKind.CK_IntegralToBoolean);
          return TryCastResult.TC_Success;
        } else if (DestType.$arrow().isIntegralType(Self.Context)) {
          Kind.$set(CastKind.CK_IntegralCast);
          return TryCastResult.TC_Success;
        } else if (DestType.$arrow().isRealFloatingType()) {
          Kind.$set(CastKind.CK_IntegralToFloating);
          return TryCastResult.TC_Success;
        }
      }
    }
  }
  
  // Reverse integral promotion/conversion. All such conversions are themselves
  // again integral promotions or conversions and are thus already handled by
  // p2 (TryDirectInitialization above).
  // (Note: any data loss warnings should be suppressed.)
  // The exception is the reverse of enum->integer, i.e. integer->enum (and
  // enum->enum). See also C++ 5.2.9p7.
  // The same goes for reverse floating point promotion/conversion and
  // floating-integral conversions. Again, only floating->enum is relevant.
  if (DestType.$arrow().isEnumeralType()) {
    if (SrcType.$arrow().isIntegralOrEnumerationType()) {
      Kind.$set(CastKind.CK_IntegralCast);
      return TryCastResult.TC_Success;
    } else if (SrcType.$arrow().isRealFloatingType()) {
      Kind.$set(CastKind.CK_FloatingToIntegral);
      return TryCastResult.TC_Success;
    }
  }
  
  // Reverse pointer upcast. C++ 4.10p3 specifies pointer upcast.
  // C++ 5.2.9p8 additionally disallows a cast path through virtual inheritance.
  tcr = TryStaticPointerDowncast(Self, new QualType(SrcType), new QualType(DestType), CStyle, new SourceRange(OpRange), msg, 
      Kind, BasePath);
  if (tcr != TryCastResult.TC_NotApplicable) {
    return tcr;
  }
  
  // Reverse member pointer conversion. C++ 4.11 specifies member pointer
  // conversion. C++ 5.2.9p9 has additional information.
  // DR54's access restrictions apply here also.
  tcr = TryStaticMemberPointerUpcast(Self, SrcExpr, new QualType(SrcType), new QualType(DestType), CStyle, 
      new SourceRange(OpRange), msg, Kind, BasePath);
  if (tcr != TryCastResult.TC_NotApplicable) {
    return tcr;
  }
  {
    
    // Reverse pointer conversion to void*. C++ 4.10.p2 specifies conversion to
    // void*. C++ 5.2.9p10 specifies additional restrictions, which really is
    // just the usual constness stuff.
    /*const*/ PointerType /*P*/ SrcPointer = SrcType.$arrow().getAs(PointerType.class);
    if ((SrcPointer != null)) {
      QualType SrcPointee = SrcPointer.getPointeeType();
      if (SrcPointee.$arrow().isVoidType()) {
        {
          /*const*/ PointerType /*P*/ DestPointer = DestType.$arrow().getAs(PointerType.class);
          if ((DestPointer != null)) {
            QualType DestPointee = DestPointer.getPointeeType();
            if (DestPointee.$arrow().isIncompleteOrObjectType()) {
              // This is definitely the intended conversion, but it might fail due
              // to a qualifier violation. Note that we permit Objective-C lifetime
              // and GC qualifier mismatches here.
              if (!CStyle) {
                Qualifiers DestPointeeQuals = DestPointee.getQualifiers();
                Qualifiers SrcPointeeQuals = SrcPointee.getQualifiers();
                DestPointeeQuals.removeObjCGCAttr();
                DestPointeeQuals.removeObjCLifetime();
                SrcPointeeQuals.removeObjCGCAttr();
                SrcPointeeQuals.removeObjCLifetime();
                if (DestPointeeQuals.$noteq(/*NO_COPY*/SrcPointeeQuals)
                   && !DestPointeeQuals.compatiblyIncludes(new Qualifiers(SrcPointeeQuals))) {
                  msg.$set(diag.err_bad_cxx_cast_qualifiers_away);
                  return TryCastResult.TC_Failed;
                }
              }
              Kind.$set(CastKind.CK_BitCast);
              return TryCastResult.TC_Success;
            }
            
            // Microsoft permits static_cast from 'pointer-to-void' to
            // 'pointer-to-function'.
            if (!CStyle && Self.getLangOpts().MSVCCompat
               && DestPointee.$arrow().isFunctionType()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.ext_ms_cast_fn_obj)), OpRange));
                Kind.$set(CastKind.CK_BitCast);
                return TryCastResult.TC_Success;
              } finally {
                $c$.$destroy();
              }
            }
          } else if (DestType.$arrow().isObjCObjectPointerType()) {
            // allow both c-style cast and static_cast of objective-c pointers as 
            // they are pervasive.
            Kind.$set(CastKind.CK_CPointerToObjCPointerCast);
            return TryCastResult.TC_Success;
          } else if (CStyle && DestType.$arrow().isBlockPointerType()) {
            // allow c-style cast of void * to block pointers.
            Kind.$set(CastKind.CK_AnyPointerToBlockPointerCast);
            return TryCastResult.TC_Success;
          }
        }
      }
    }
  }
  // Allow arbitray objective-c pointer conversion with static casts.
  if (SrcType.$arrow().isObjCObjectPointerType()
     && DestType.$arrow().isObjCObjectPointerType()) {
    Kind.$set(CastKind.CK_BitCast);
    return TryCastResult.TC_Success;
  }
  // Allow ns-pointer to cf-pointer conversion in either direction
  // with static casts.
  if (!CStyle
     && Self.CheckTollFreeBridgeStaticCast(new QualType(DestType), SrcExpr.get(), Kind)) {
    return TryCastResult.TC_Success;
  }
  {
    
    // See if it looks like the user is trying to convert between
    // related record types, and select a better diagnostic if so.
    /*const*/ PointerType /*P*/ SrcPointer = SrcType.$arrow().getAs(PointerType.class);
    if ((SrcPointer != null)) {
      {
        /*const*/ PointerType /*P*/ DestPointer = DestType.$arrow().getAs(PointerType.class);
        if ((DestPointer != null)) {
          if ((SrcPointer.getPointeeType().$arrow().<RecordType>getAs$RecordType() != null)
             && (DestPointer.getPointeeType().$arrow().<RecordType>getAs$RecordType() != null)) {
            msg.$set(diag.err_bad_cxx_cast_unrelated_class);
          }
        }
      }
    }
  }
  
  // We tried everything. Everything! Nothing works! :-(
  return TryCastResult.TC_NotApplicable;
}


/// TryConstCast - See if a const_cast from source to destination is allowed,
/// and perform it if it is.
//<editor-fold defaultstate="collapsed" desc="TryConstCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1543,
 FQN="TryConstCast", NM="_ZL12TryConstCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEbRj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL12TryConstCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEbRj")
//</editor-fold>
public static TryCastResult TryConstCast(final Sema /*&*/ Self, final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, 
            QualType DestType, boolean CStyle, 
            final uint$ref/*uint &*/ msg) {
  DestType.$assignMove(Self.Context.getCanonicalType(new QualType(DestType)).$QualType());
  QualType SrcType = SrcExpr.get().getType();
  boolean NeedToMaterializeTemporary = false;
  {
    
    /*const*/ ReferenceType /*P*/ DestTypeTmp = DestType.$arrow().getAs(ReferenceType.class);
    if ((DestTypeTmp != null)) {
      // C++11 5.2.11p4:
      //   if a pointer to T1 can be explicitly converted to the type "pointer to
      //   T2" using a const_cast, then the following conversions can also be
      //   made:
      //    -- an lvalue of type T1 can be explicitly converted to an lvalue of
      //       type T2 using the cast const_cast<T2&>;
      //    -- a glvalue of type T1 can be explicitly converted to an xvalue of
      //       type T2 using the cast const_cast<T2&&>; and
      //    -- if T1 is a class type, a prvalue of type T1 can be explicitly
      //       converted to an xvalue of type T2 using the cast const_cast<T2&&>.
      if (isa_LValueReferenceType(DestTypeTmp) && !SrcExpr.get().isLValue()) {
        // Cannot const_cast non-lvalue to lvalue reference type. But if this
        // is C-style, static_cast might find a way, so we simply suggest a
        // message and tell the parent to keep searching.
        msg.$set(diag.err_bad_cxx_cast_rvalue);
        return TryCastResult.TC_NotApplicable;
      }
      if (isa_RValueReferenceType(DestTypeTmp) && SrcExpr.get().isRValue()) {
        if (!SrcType.$arrow().isRecordType()) {
          // Cannot const_cast non-class prvalue to rvalue reference type. But if
          // this is C-style, static_cast can do this.
          msg.$set(diag.err_bad_cxx_cast_rvalue);
          return TryCastResult.TC_NotApplicable;
        }
        
        // Materialize the class prvalue so that the const_cast can bind a
        // reference to it.
        NeedToMaterializeTemporary = true;
      }
      
      // It's not completely clear under the standard whether we can
      // const_cast bit-field gl-values.  Doing so would not be
      // intrinsically complicated, but for now, we say no for
      // consistency with other compilers and await the word of the
      // committee.
      if (SrcExpr.get().refersToBitField()) {
        msg.$set(diag.err_bad_cxx_cast_bitfield);
        return TryCastResult.TC_NotApplicable;
      }
      
      DestType.$assignMove(Self.Context.getPointerType(DestTypeTmp.getPointeeType()));
      SrcType.$assignMove(Self.Context.getPointerType(new QualType(SrcType)));
    }
  }
  
  // C++ 5.2.11p5: For a const_cast involving pointers to data members [...]
  //   the rules for const_cast are the same as those used for pointers.
  if (!DestType.$arrow().isPointerType()
     && !DestType.$arrow().isMemberPointerType()
     && !DestType.$arrow().isObjCObjectPointerType()) {
    // Cannot cast to non-pointer, non-reference type. Note that, if DestType
    // was a reference type, we converted it to a pointer above.
    // The status of rvalue references isn't entirely clear, but it looks like
    // conversion to them is simply invalid.
    // C++ 5.2.11p3: For two pointer types [...]
    if (!CStyle) {
      msg.$set(diag.err_bad_const_cast_dest);
    }
    return TryCastResult.TC_NotApplicable;
  }
  if (DestType.$arrow().isFunctionPointerType()
     || DestType.$arrow().isMemberFunctionPointerType()) {
    // Cannot cast direct function pointers.
    // C++ 5.2.11p2: [...] where T is any object type or the void type [...]
    // T is the ultimate pointee of source and target type.
    if (!CStyle) {
      msg.$set(diag.err_bad_const_cast_dest);
    }
    return TryCastResult.TC_NotApplicable;
  }
  SrcType.$assignMove(Self.Context.getCanonicalType(new QualType(SrcType)).$QualType());
  
  // Unwrap the pointers. Ignore qualifiers. Terminate early if the types are
  // completely equal.
  // C++ 5.2.11p3 describes the core semantics of const_cast. All cv specifiers
  // in multi-level pointers may change, but the level count must be the same,
  // as must be the final pointee type.
  while ($noteq_QualType$C(SrcType, DestType)
     && Self.Context.UnwrapSimilarPointerTypes(SrcType, DestType)) {
    Qualifiers SrcQuals/*J*/= new Qualifiers(), DestQuals/*J*/= new Qualifiers();
    SrcType.$assignMove(Self.Context.getUnqualifiedArrayType(new QualType(SrcType), SrcQuals));
    DestType.$assignMove(Self.Context.getUnqualifiedArrayType(new QualType(DestType), DestQuals));
    
    // const_cast is permitted to strip cvr-qualifiers, only. Make sure that
    // the other qualifiers (e.g., address spaces) are identical.
    SrcQuals.removeCVRQualifiers();
    DestQuals.removeCVRQualifiers();
    if (SrcQuals.$noteq(/*NO_COPY*/DestQuals)) {
      return TryCastResult.TC_NotApplicable;
    }
  }
  
  // Since we're dealing in canonical types, the remainder must be the same.
  if ($noteq_QualType$C(SrcType, DestType)) {
    return TryCastResult.TC_NotApplicable;
  }
  if (NeedToMaterializeTemporary) {
    // This is a const_cast from a class prvalue to an rvalue reference type.
    // Materialize a temporary to store the result of the conversion.
    SrcExpr.$assign(Self.CreateMaterializeTemporaryExpr(new QualType(SrcType), SrcExpr.get(), 
            /*IsLValueReference*/ false));
  }
  
  return TryCastResult.TC_Success;
}

//<editor-fold defaultstate="collapsed" desc="TryReinterpretCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1870,
 FQN="TryReinterpretCast", NM="_ZL18TryReinterpretCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEbNS_11SourceRangeERjRNS_8CastKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL18TryReinterpretCastRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEbNS_11SourceRangeERjRNS_8CastKindE")
//</editor-fold>
public static TryCastResult TryReinterpretCast(final Sema /*&*/ Self, final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, 
                  QualType DestType, boolean CStyle, 
                  SourceRange OpRange, 
                  final uint$ref/*uint &*/ msg, 
                  final type$ref<CastKind /*&*/> Kind) {
  boolean IsLValueCast = false;
  
  DestType.$assignMove(Self.Context.getCanonicalType(new QualType(DestType)).$QualType());
  QualType SrcType = SrcExpr.get().getType();
  
  // Is the source an overloaded name? (i.e. &foo)
  // If so, reinterpret_cast generally can not help us here (13.4, p1, bullet 5)
  if ($eq_QualType$C(SrcType, Self.Context.OverloadTy.$QualType())) {
    ActionResultTTrue<Expr /*P*/ > FixedExpr = new ActionResultTTrue<Expr /*P*/ >(SrcExpr);
    if (!fixOverloadedReinterpretCastExpr(Self, new QualType(DestType), FixedExpr)) {
      return TryCastResult.TC_NotApplicable;
    }
    assert (FixedExpr.isUsable()) : "Invalid result fixing overloaded expr";
    SrcExpr.$assign(FixedExpr);
    SrcType.$assignMove(SrcExpr.get().getType());
  }
  {
    
    /*const*/ ReferenceType /*P*/ DestTypeTmp = DestType.$arrow().getAs(ReferenceType.class);
    if ((DestTypeTmp != null)) {
      if (!SrcExpr.get().isGLValue()) {
        // Cannot cast non-glvalue to (lvalue or rvalue) reference type. See the
        // similar comment in const_cast.
        msg.$set(diag.err_bad_cxx_cast_rvalue);
        return TryCastResult.TC_NotApplicable;
      }
      if (!CStyle) {
        Self.CheckCompatibleReinterpretCast(new QualType(SrcType), new QualType(DestType), 
            /*isDereference=*/ false, new SourceRange(OpRange));
      }
      
      // C++ 5.2.10p10: [...] a reference cast reinterpret_cast<T&>(x) has the
      //   same effect as the conversion *reinterpret_cast<T*>(&x) with the
      //   built-in & and * operators.
      /*const*/char$ptr/*char P*/ inappropriate = null;
      switch (SrcExpr.get().getObjectKind()) {
       case OK_Ordinary:
        break;
       case OK_BitField:
        inappropriate = $tryClone($("bit-field"));
        break;
       case OK_VectorComponent:
        inappropriate = $tryClone($("vector element"));
        break;
       case OK_ObjCProperty:
        inappropriate = $tryClone($("property expression"));
        break;
       case OK_ObjCSubscript:
        inappropriate = $tryClone($("container subscripting expression"));
        break;
      }
      if ((inappropriate != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_reinterpret_cast_reference)), 
                          inappropriate), DestType), 
                  OpRange), SrcExpr.get().getSourceRange()));
          msg.$set(0);
          SrcExpr.$assignMove(ExprError());
          return TryCastResult.TC_NotApplicable;
        } finally {
          $c$.$destroy();
        }
      }
      
      // This code does this transformation for the checked types.
      DestType.$assignMove(Self.Context.getPointerType(DestTypeTmp.getPointeeType()));
      SrcType.$assignMove(Self.Context.getPointerType(new QualType(SrcType)));
      
      IsLValueCast = true;
    }
  }
  
  // Canonicalize source for comparison.
  SrcType.$assignMove(Self.Context.getCanonicalType(new QualType(SrcType)).$QualType());
  
  /*const*/ MemberPointerType /*P*/ DestMemPtr = DestType.$arrow().getAs(MemberPointerType.class), 
      /*P*/ SrcMemPtr = SrcType.$arrow().getAs(MemberPointerType.class);
  if ((DestMemPtr != null) && (SrcMemPtr != null)) {
    // C++ 5.2.10p9: An rvalue of type "pointer to member of X of type T1"
    //   can be explicitly converted to an rvalue of type "pointer to member
    //   of Y of type T2" if T1 and T2 are both function types or both object
    //   types.
    if (DestMemPtr.isMemberFunctionPointer()
       != SrcMemPtr.isMemberFunctionPointer()) {
      return TryCastResult.TC_NotApplicable;
    }
    
    // C++ 5.2.10p2: The reinterpret_cast operator shall not cast away
    //   constness.
    // A reinterpret_cast followed by a const_cast can, though, so in C-style,
    // we accept it.
    if (CastsAwayConstness(Self, new QualType(SrcType), new QualType(DestType), /*CheckCVR=*/ !CStyle, 
        /*CheckObjCLifetime=*/ CStyle)) {
      msg.$set(diag.err_bad_cxx_cast_qualifiers_away);
      return TryCastResult.TC_Failed;
    }
    if (Self.Context.getTargetInfo().getCXXABI().isMicrosoft()) {
      // We need to determine the inheritance model that the class will use if
      // haven't yet.
      /*(void)*/Self.isCompleteType(OpRange.getBegin(), new QualType(SrcType));
      /*(void)*/Self.isCompleteType(OpRange.getBegin(), new QualType(DestType));
    }
    
    // Don't allow casting between member pointers of different sizes.
    if (Self.Context.getTypeSize(DestMemPtr)
       != Self.Context.getTypeSize(SrcMemPtr)) {
      msg.$set(diag.err_bad_cxx_cast_member_pointer_size);
      return TryCastResult.TC_Failed;
    }
    
    // A valid member pointer cast.
    assert (!IsLValueCast);
    Kind.$set(CastKind.CK_ReinterpretMemberPointer);
    return TryCastResult.TC_Success;
  }
  
  // See below for the enumeral issue.
  if (SrcType.$arrow().isNullPtrType() && DestType.$arrow().isIntegralType(Self.Context)) {
    // C++0x 5.2.10p4: A pointer can be explicitly converted to any integral
    //   type large enough to hold it. A value of std::nullptr_t can be
    //   converted to an integral type; the conversion has the same meaning
    //   and validity as a conversion of (void*)0 to the integral type.
    if ($greater_ulong(Self.Context.getTypeSize(new QualType(SrcType))
      , Self.Context.getTypeSize(new QualType(DestType)))) {
      msg.$set(diag.err_bad_reinterpret_cast_small_int);
      return TryCastResult.TC_Failed;
    }
    Kind.$set(CastKind.CK_PointerToIntegral);
    return TryCastResult.TC_Success;
  }
  
  // Allow reinterpret_casts between vectors of the same size and
  // between vectors and integers of the same size.
  boolean destIsVector = DestType.$arrow().isVectorType();
  boolean srcIsVector = SrcType.$arrow().isVectorType();
  if (srcIsVector || destIsVector) {
    // The non-vector type, if any, must have integral type.  This is
    // the same rule that C vector casts use; note, however, that enum
    // types are not integral in C++.
    if ((!destIsVector && !DestType.$arrow().isIntegralType(Self.Context))
       || (!srcIsVector && !SrcType.$arrow().isIntegralType(Self.Context))) {
      return TryCastResult.TC_NotApplicable;
    }
    
    // The size we want to consider is eltCount * eltSize.
    // That's exactly what the lax-conversion rules will check.
    if (Self.areLaxCompatibleVectorTypes(new QualType(SrcType), new QualType(DestType))) {
      Kind.$set(CastKind.CK_BitCast);
      return TryCastResult.TC_Success;
    }
    
    // Otherwise, pick a reasonable diagnostic.
    if (!destIsVector) {
      msg.$set(diag.err_bad_cxx_cast_vector_to_scalar_different_size);
    } else if (!srcIsVector) {
      msg.$set(diag.err_bad_cxx_cast_scalar_to_vector_different_size);
    } else {
      msg.$set(diag.err_bad_cxx_cast_vector_to_vector_different_size);
    }
    
    return TryCastResult.TC_Failed;
  }
  if ($eq_QualType$C(SrcType, DestType)) {
    // C++ 5.2.10p2 has a note that mentions that, subject to all other
    // restrictions, a cast to the same type is allowed so long as it does not
    // cast away constness. In C++98, the intent was not entirely clear here, 
    // since all other paragraphs explicitly forbid casts to the same type.
    // C++11 clarifies this case with p2.
    //
    // The only allowed types are: integral, enumeration, pointer, or 
    // pointer-to-member types.  We also won't restrict Obj-C pointers either.
    Kind.$set(CastKind.CK_NoOp);
    TryCastResult Result = TryCastResult.TC_NotApplicable;
    if (SrcType.$arrow().isIntegralOrEnumerationType()
       || SrcType.$arrow().isAnyPointerType()
       || SrcType.$arrow().isMemberPointerType()
       || SrcType.$arrow().isBlockPointerType()) {
      Result = TryCastResult.TC_Success;
    }
    return Result;
  }
  
  boolean destIsPtr = DestType.$arrow().isAnyPointerType()
     || DestType.$arrow().isBlockPointerType();
  boolean srcIsPtr = SrcType.$arrow().isAnyPointerType()
     || SrcType.$arrow().isBlockPointerType();
  if (!destIsPtr && !srcIsPtr) {
    // Except for std::nullptr_t->integer and lvalue->reference, which are
    // handled above, at least one of the two arguments must be a pointer.
    return TryCastResult.TC_NotApplicable;
  }
  if (DestType.$arrow().isIntegralType(Self.Context)) {
    assert (srcIsPtr) : "One type must be a pointer";
    // C++ 5.2.10p4: A pointer can be explicitly converted to any integral
    //   type large enough to hold it; except in Microsoft mode, where the
    //   integral type size doesn't matter (except we don't allow bool).
    boolean MicrosoftException = Self.getLangOpts().MicrosoftExt
       && !DestType.$arrow().isBooleanType();
    if (($greater_ulong(Self.Context.getTypeSize(new QualType(SrcType))
      , Self.Context.getTypeSize(new QualType(DestType))))
       && !MicrosoftException) {
      msg.$set(diag.err_bad_reinterpret_cast_small_int);
      return TryCastResult.TC_Failed;
    }
    Kind.$set(CastKind.CK_PointerToIntegral);
    return TryCastResult.TC_Success;
  }
  if (SrcType.$arrow().isIntegralOrEnumerationType()) {
    assert (destIsPtr) : "One type must be a pointer";
    checkIntToPointerCast(CStyle, OpRange.getBegin(), SrcExpr.get(), new QualType(DestType), 
        Self);
    // C++ 5.2.10p5: A value of integral or enumeration type can be explicitly
    //   converted to a pointer.
    // C++ 5.2.10p9: [Note: ...a null pointer constant of integral type is not
    //   necessarily converted to a null pointer value.]
    Kind.$set(CastKind.CK_IntegralToPointer);
    return TryCastResult.TC_Success;
  }
  if (!destIsPtr || !srcIsPtr) {
    // With the valid non-pointer conversions out of the way, we can be even
    // more stringent.
    return TryCastResult.TC_NotApplicable;
  }
  
  // C++ 5.2.10p2: The reinterpret_cast operator shall not cast away constness.
  // The C-style cast operator can.
  if (CastsAwayConstness(Self, new QualType(SrcType), new QualType(DestType), /*CheckCVR=*/ !CStyle, 
      /*CheckObjCLifetime=*/ CStyle)) {
    msg.$set(diag.err_bad_cxx_cast_qualifiers_away);
    return TryCastResult.TC_Failed;
  }
  
  // Cannot convert between block pointers and Objective-C object pointers.
  if ((SrcType.$arrow().isBlockPointerType() && DestType.$arrow().isObjCObjectPointerType())
     || (DestType.$arrow().isBlockPointerType() && SrcType.$arrow().isObjCObjectPointerType())) {
    return TryCastResult.TC_NotApplicable;
  }
  if (IsLValueCast) {
    Kind.$set(CastKind.CK_LValueBitCast);
  } else if (DestType.$arrow().isObjCObjectPointerType()) {
    Kind.$set(Self.PrepareCastToObjCObjectPointer(SrcExpr));
  } else if (DestType.$arrow().isBlockPointerType()) {
    if (!SrcType.$arrow().isBlockPointerType()) {
      Kind.$set(CastKind.CK_AnyPointerToBlockPointerCast);
    } else {
      Kind.$set(CastKind.CK_BitCast);
    }
  } else {
    Kind.$set(CastKind.CK_BitCast);
  }
  
  // Any pointer can be cast to an Objective-C pointer type with a C-style
  // cast.
  if (CStyle && DestType.$arrow().isObjCObjectPointerType()) {
    return TryCastResult.TC_Success;
  }
  if (CStyle) {
    DiagnoseCastOfObjCSEL(Self, SrcExpr, new QualType(DestType));
  }
  
  DiagnoseCallingConvCast(Self, SrcExpr, new QualType(DestType), new SourceRange(OpRange));
  
  // Not casting away constness, so the only remaining check is for compatible
  // pointer categories.
  if (SrcType.$arrow().isFunctionPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (DestType.$arrow().isFunctionPointerType()) {
        // C++ 5.2.10p6: A pointer to a function can be explicitly converted to
        // a pointer to a function of a different type.
        return TryCastResult.TC_Success;
      }
      
      // C++0x 5.2.10p8: Converting a pointer to a function into a pointer to
      //   an object type or vice versa is conditionally-supported.
      // Compilers support it in C++03 too, though, because it's necessary for
      // casting the return value of dlsym() and GetProcAddress().
      // FIXME: Conditionally-supported behavior should be configurable in the
      // TargetInfo or similar.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), 
              Self.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_cast_fn_obj : diag.ext_cast_fn_obj)), 
          OpRange));
      return TryCastResult.TC_Success;
    } finally {
      $c$.$destroy();
    }
  }
  if (DestType.$arrow().isFunctionPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // See above.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), 
              Self.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_cast_fn_obj : diag.ext_cast_fn_obj)), 
          OpRange));
      return TryCastResult.TC_Success;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ 5.2.10p7: A pointer to an object can be explicitly converted to
  //   a pointer to an object of different type.
  // Void pointers are not specified, but supported by every compiler out there.
  // So we finish by allowing everything that remains - it's got to be two
  // object pointers.
  return TryCastResult.TC_Success;
}


/// Try to diagnose a failed overloaded cast.  Returns true if
/// diagnostics were emitted.
//<editor-fold defaultstate="collapsed" desc="tryDiagnoseOverloadedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 307,
 FQN="tryDiagnoseOverloadedCast", NM="_ZL25tryDiagnoseOverloadedCastRN5clang4SemaE8CastTypeNS_11SourceRangeEPNS_4ExprENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL25tryDiagnoseOverloadedCastRN5clang4SemaE8CastTypeNS_11SourceRangeEPNS_4ExprENS_8QualTypeEb")
//</editor-fold>
public static boolean tryDiagnoseOverloadedCast(final Sema /*&*/ S, CastType CT, 
                         SourceRange range, Expr /*P*/ src, 
                         QualType destType, 
                         boolean listInitialization) {
  InitializationSequence sequence = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    switch (CT) {
     case CT_Const:
     case CT_Reinterpret:
     case CT_Dynamic:
      // These cast kinds don't consider user-defined conversions.
      return false;
     case CT_Static:
     case CT_CStyle:
     case CT_Functional:
      
      // These do.
      break;
    }
    
    QualType srcType = src.getType();
    if (!destType.$arrow().isRecordType() && !srcType.$arrow().isRecordType()) {
      return false;
    }
    
    InitializedEntity entity = InitializedEntity.InitializeTemporary(new QualType(destType));
    InitializationKind initKind = (CT == CastType.CT_CStyle) ? InitializationKind.CreateCStyleCast(range.getBegin(), 
        new SourceRange(range), listInitialization) : (CT == CastType.CT_Functional) ? InitializationKind.CreateFunctionalCast(new SourceRange(range), 
        listInitialization) : InitializationKind.CreateCast(/*type range?*/ new SourceRange(range));
    sequence/*J*/= new InitializationSequence(S, entity, initKind, new MutableArrayRef<Expr /*P*/ >(src, true));
    assert (sequence.Failed()) : "initialization succeeded on second try?";
    switch (sequence.getFailureKind()) {
     default:
      return false;
     case FK_ConstructorOverloadFailed:
     case FK_UserConversionOverloadFailed:
      break;
    }
    
    final OverloadCandidateSet /*&*/ candidates = sequence.getFailedCandidateSet();
    
    /*uint*/int msg = 0;
    OverloadCandidateDisplayKind howManyCandidates = OverloadCandidateDisplayKind.OCD_AllCandidates;
    switch (sequence.getFailedOverloadResult()) {
     case OR_Success:
      throw new llvm_unreachable("successful failed overload");
     case OR_No_Viable_Function:
      if (candidates.empty()) {
        msg = diag.err_ovl_no_conversion_in_cast;
      } else {
        msg = diag.err_ovl_no_viable_conversion_in_cast;
      }
      howManyCandidates = OverloadCandidateDisplayKind.OCD_AllCandidates;
      break;
     case OR_Ambiguous:
      msg = diag.err_ovl_ambiguous_conversion_in_cast;
      howManyCandidates = OverloadCandidateDisplayKind.OCD_ViableCandidates;
      break;
     case OR_Deleted:
      msg = diag.err_ovl_deleted_conversion_in_cast;
      howManyCandidates = OverloadCandidateDisplayKind.OCD_ViableCandidates;
      break;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(range.getBegin(), msg)), 
                        CT), srcType), destType), 
            range), src.getSourceRange()));
    
    candidates.NoteCandidates(S, howManyCandidates, new ArrayRef<Expr /*P*/ >(src, true));
    
    return true;
  } finally {
    if (sequence != null) { sequence.$destroy(); }
    $c$.$destroy();
  }
}


/// Diagnose a failed cast.
//<editor-fold defaultstate="collapsed" desc="diagnoseBadCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 383,
 FQN="diagnoseBadCast", NM="_ZL15diagnoseBadCastRN5clang4SemaEj8CastTypeNS_11SourceRangeEPNS_4ExprENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL15diagnoseBadCastRN5clang4SemaEj8CastTypeNS_11SourceRangeEPNS_4ExprENS_8QualTypeEb")
//</editor-fold>
public static void diagnoseBadCast(final Sema /*&*/ S, /*uint*/int msg, CastType castType, 
               SourceRange opRange, Expr /*P*/ src, QualType destType, 
               boolean listInitialization) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (msg == diag.err_bad_cxx_cast_generic
       && tryDiagnoseOverloadedCast(S, castType, new SourceRange(opRange), src, new QualType(destType), 
        listInitialization)) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(opRange.getBegin(), msg)), castType), 
                    src.getType()), destType), opRange), src.getSourceRange()));
    
    // Detect if both types are (ptr to) class, and note any incompleteness.
    int DifferentPtrness = 0;
    QualType From = new QualType(destType);
    {
      /*const*/ PointerType /*P*/ Ptr = From.$arrow().getAs(PointerType.class);
      if ((Ptr != null)) {
        From.$assignMove(Ptr.getPointeeType());
        DifferentPtrness++;
      }
    }
    QualType To = src.getType();
    {
      /*const*/ PointerType /*P*/ Ptr = To.$arrow().getAs(PointerType.class);
      if ((Ptr != null)) {
        To.$assignMove(Ptr.getPointeeType());
        DifferentPtrness--;
      }
    }
    if (!(DifferentPtrness != 0)) {
      /*const*/ RecordType /*P*/ RecFrom = From.$arrow().<RecordType>getAs$RecordType();
      /*const*/ RecordType /*P*/ RecTo = To.$arrow().<RecordType>getAs$RecordType();
      if ((RecFrom != null) && (RecTo != null)) {
        CXXRecordDecl /*P*/ DeclFrom = RecFrom.getAsCXXRecordDecl();
        if (!DeclFrom.isCompleteDefinition()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DeclFrom.getLocation(), diag.note_type_incomplete)), 
              DeclFrom.getDeclName()));
        }
        CXXRecordDecl /*P*/ DeclTo = RecTo.getAsCXXRecordDecl();
        if (!DeclTo.isCompleteDefinition()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DeclTo.getLocation(), diag.note_type_incomplete)), 
              DeclTo.getDeclName()));
        }
      }
    }
  } finally {
    $c$.$destroy();
  }
}


/// UnwrapDissimilarPointerTypes - Like Sema::UnwrapSimilarPointerTypes,
/// this removes one level of indirection from both types, provided that they're
/// the same kind of pointer (plain or to-member). Unlike the Sema function,
/// this one doesn't care if the two pointers-to-member don't point into the
/// same class. This is because CastsAwayConstness doesn't care.
//<editor-fold defaultstate="collapsed" desc="UnwrapDissimilarPointerTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 427,
 FQN="UnwrapDissimilarPointerTypes", NM="_ZL28UnwrapDissimilarPointerTypesRN5clang8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL28UnwrapDissimilarPointerTypesRN5clang8QualTypeES1_")
//</editor-fold>
public static boolean UnwrapDissimilarPointerTypes(final QualType /*&*/ T1, final QualType /*&*/ T2) {
  /*const*/ PointerType /*P*/ T1PtrType = T1.$arrow().getAs(PointerType.class), 
      /*P*/ T2PtrType = T2.$arrow().getAs(PointerType.class);
  if ((T1PtrType != null) && (T2PtrType != null)) {
    T1.$assignMove(T1PtrType.getPointeeType());
    T2.$assignMove(T2PtrType.getPointeeType());
    return true;
  }
  /*const*/ ObjCObjectPointerType /*P*/ T1ObjCPtrType = T1.$arrow().getAs(ObjCObjectPointerType.class), 
      /*P*/ T2ObjCPtrType = T2.$arrow().getAs(ObjCObjectPointerType.class);
  if ((T1ObjCPtrType != null)) {
    if ((T2ObjCPtrType != null)) {
      T1.$assignMove(T1ObjCPtrType.getPointeeType());
      T2.$assignMove(T2ObjCPtrType.getPointeeType());
      return true;
    } else if ((T2PtrType != null)) {
      T1.$assignMove(T1ObjCPtrType.getPointeeType());
      T2.$assignMove(T2PtrType.getPointeeType());
      return true;
    }
  } else if ((T2ObjCPtrType != null)) {
    if ((T1PtrType != null)) {
      T2.$assignMove(T2ObjCPtrType.getPointeeType());
      T1.$assignMove(T1PtrType.getPointeeType());
      return true;
    }
  }
  
  /*const*/ MemberPointerType /*P*/ T1MPType = T1.$arrow().getAs(MemberPointerType.class), 
      /*P*/ T2MPType = T2.$arrow().getAs(MemberPointerType.class);
  if ((T1MPType != null) && (T2MPType != null)) {
    T1.$assignMove(T1MPType.getPointeeType());
    T2.$assignMove(T2MPType.getPointeeType());
    return true;
  }
  
  /*const*/ BlockPointerType /*P*/ T1BPType = T1.$arrow().getAs(BlockPointerType.class), 
      /*P*/ T2BPType = T2.$arrow().getAs(BlockPointerType.class);
  if ((T1BPType != null) && (T2BPType != null)) {
    T1.$assignMove(T1BPType.getPointeeType());
    T2.$assignMove(T2BPType.getPointeeType());
    return true;
  }
  
  return false;
}


/// CastsAwayConstness - Check if the pointer conversion from SrcType to
/// DestType casts away constness as defined in C++ 5.2.11p8ff. This is used by
/// the cast checkers.  Both arguments must denote pointer (possibly to member)
/// types.
///
/// \param CheckCVR Whether to check for const/volatile/restrict qualifiers.
///
/// \param CheckObjCLifetime Whether to check Objective-C lifetime qualifiers.
//<editor-fold defaultstate="collapsed" desc="CastsAwayConstness">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 486,
 FQN="CastsAwayConstness", NM="_ZL18CastsAwayConstnessRN5clang4SemaENS_8QualTypeES2_bbPS2_S3_PNS_10QualifiersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL18CastsAwayConstnessRN5clang4SemaENS_8QualTypeES2_bbPS2_S3_PNS_10QualifiersE")
//</editor-fold>
public static boolean CastsAwayConstness(final Sema /*&*/ Self, QualType SrcType, QualType DestType, 
                  boolean CheckCVR, boolean CheckObjCLifetime) {
  return CastsAwayConstness(Self, SrcType, DestType, 
                  CheckCVR, CheckObjCLifetime, 
                  (QualType /*P*/ )null, 
                  (QualType /*P*/ )null, 
                  (Qualifiers /*P*/ )null);
}
public static boolean CastsAwayConstness(final Sema /*&*/ Self, QualType SrcType, QualType DestType, 
                  boolean CheckCVR, boolean CheckObjCLifetime, 
                  QualType /*P*/ TheOffendingSrcType/*= null*/) {
  return CastsAwayConstness(Self, SrcType, DestType, 
                  CheckCVR, CheckObjCLifetime, 
                  TheOffendingSrcType, 
                  (QualType /*P*/ )null, 
                  (Qualifiers /*P*/ )null);
}
public static boolean CastsAwayConstness(final Sema /*&*/ Self, QualType SrcType, QualType DestType, 
                  boolean CheckCVR, boolean CheckObjCLifetime, 
                  QualType /*P*/ TheOffendingSrcType/*= null*/, 
                  QualType /*P*/ TheOffendingDestType/*= null*/) {
  return CastsAwayConstness(Self, SrcType, DestType, 
                  CheckCVR, CheckObjCLifetime, 
                  TheOffendingSrcType, 
                  TheOffendingDestType, 
                  (Qualifiers /*P*/ )null);
}
public static boolean CastsAwayConstness(final Sema /*&*/ Self, QualType SrcType, QualType DestType, 
                  boolean CheckCVR, boolean CheckObjCLifetime, 
                  QualType /*P*/ TheOffendingSrcType/*= null*/, 
                  QualType /*P*/ TheOffendingDestType/*= null*/, 
                  Qualifiers /*P*/ CastAwayQualifiers/*= null*/) {
  // If the only checking we care about is for Objective-C lifetime qualifiers,
  // and we're not in ObjC mode, there's nothing to check.
  if (!CheckCVR && CheckObjCLifetime
     && !Self.Context.getLangOpts().ObjC1) {
    return false;
  }
  
  // Casting away constness is defined in C++ 5.2.11p8 with reference to
  // C++ 4.4. We piggyback on Sema::IsQualificationConversion for this, since
  // the rules are non-trivial. So first we construct Tcv *...cv* as described
  // in C++ 5.2.11p8.
  assert ((SrcType.$arrow().isAnyPointerType() || SrcType.$arrow().isMemberPointerType() || SrcType.$arrow().isBlockPointerType())) : "Source type is not pointer or pointer to member.";
  assert ((DestType.$arrow().isAnyPointerType() || DestType.$arrow().isMemberPointerType() || DestType.$arrow().isBlockPointerType())) : "Destination type is not pointer or pointer to member.";
  
  QualType UnwrappedSrcType = Self.Context.getCanonicalType(new QualType(SrcType)).$QualType(), 
      UnwrappedDestType = Self.Context.getCanonicalType(new QualType(DestType)).$QualType();
  SmallVector<Qualifiers> cv1/*J*/= new SmallVector<Qualifiers>(8, new Qualifiers()), cv2/*J*/= new SmallVector<Qualifiers>(8, new Qualifiers());
  
  // Find the qualifiers. We only care about cvr-qualifiers for the 
  // purpose of this check, because other qualifiers (address spaces, 
  // Objective-C GC, etc.) are part of the type's identity.
  QualType PrevUnwrappedSrcType = new QualType(UnwrappedSrcType);
  QualType PrevUnwrappedDestType = new QualType(UnwrappedDestType);
  while (UnwrapDissimilarPointerTypes(UnwrappedSrcType, UnwrappedDestType)) {
    // Determine the relevant qualifiers at this level.
    Qualifiers SrcQuals/*J*/= new Qualifiers(), DestQuals/*J*/= new Qualifiers();
    Self.Context.getUnqualifiedArrayType(new QualType(UnwrappedSrcType), SrcQuals);
    Self.Context.getUnqualifiedArrayType(new QualType(UnwrappedDestType), DestQuals);
    
    Qualifiers RetainedSrcQuals/*J*/= new Qualifiers(), RetainedDestQuals/*J*/= new Qualifiers();
    if (CheckCVR) {
      RetainedSrcQuals.setCVRQualifiers(SrcQuals.getCVRQualifiers());
      RetainedDestQuals.setCVRQualifiers(DestQuals.getCVRQualifiers());
      if (RetainedSrcQuals.$noteq(/*NO_COPY*/RetainedDestQuals) && (TheOffendingSrcType != null)
         && (TheOffendingDestType != null) && (CastAwayQualifiers != null)) {
        /*Deref*/TheOffendingSrcType.$assign(PrevUnwrappedSrcType);
        /*Deref*/TheOffendingDestType.$assign(PrevUnwrappedDestType);
        /*Deref*/CastAwayQualifiers.$assignMove($sub_Qualifiers(/*NO_COPY*/RetainedSrcQuals, /*NO_COPY*/RetainedDestQuals));
      }
    }
    if (CheckObjCLifetime
       && !DestQuals.compatiblyIncludesObjCLifetime(new Qualifiers(SrcQuals))) {
      return true;
    }
    
    cv1.push_back(RetainedSrcQuals);
    cv2.push_back(RetainedDestQuals);
    
    PrevUnwrappedSrcType.$assign(UnwrappedSrcType);
    PrevUnwrappedDestType.$assign(UnwrappedDestType);
  }
  if (cv1.empty()) {
    return false;
  }
  
  // Construct void pointers with those qualifiers (in reverse order of
  // unwrapping, of course).
  QualType SrcConstruct = Self.Context.VoidTy.$QualType();
  QualType DestConstruct = Self.Context.VoidTy.$QualType();
  final ASTContext /*&*/ Context = Self.Context;
  for (std.reverse_iterator<Qualifiers /*P*/ > i1 = cv1.rbegin(), 
      i2 = cv2.rbegin();
       $noteq_reverse_iterator$C(i1, cv1.rend()); i1.$preInc() , i2.$preInc()) {
    SrcConstruct.$assignMove(
        Context.getPointerType(Context.getQualifiedType(new QualType(SrcConstruct), new Qualifiers(i1.$star())))
    );
    DestConstruct.$assignMove(
        Context.getPointerType(Context.getQualifiedType(new QualType(DestConstruct), new Qualifiers(i2.$star())))
    );
  }
  
  // Test if they're compatible.
  bool$ref ObjCLifetimeConversion = create_bool$ref();
  return $noteq_QualType$C(SrcConstruct, DestConstruct)
     && !Self.IsQualificationConversion(new QualType(SrcConstruct), new QualType(DestConstruct), false, 
      ObjCLifetimeConversion);
}


/// Check that a reinterpret_cast\<DestType\>(SrcExpr) is not used as upcast
/// or downcast between respective pointers or references.
//<editor-fold defaultstate="collapsed" desc="DiagnoseReinterpretUpDownCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 746,
 FQN="DiagnoseReinterpretUpDownCast", NM="_ZL29DiagnoseReinterpretUpDownCastRN5clang4SemaEPKNS_4ExprENS_8QualTypeENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL29DiagnoseReinterpretUpDownCastRN5clang4SemaEPKNS_4ExprENS_8QualTypeENS_11SourceRangeE")
//</editor-fold>
public static void DiagnoseReinterpretUpDownCast(final Sema /*&*/ Self, /*const*/ Expr /*P*/ SrcExpr, 
                             QualType DestType, 
                             SourceRange OpRange) {
  CXXBasePaths BasePaths = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    QualType SrcType = SrcExpr.getType();
    // When casting from pointer or reference, get pointee type; use original
    // type otherwise.
    /*const*/ CXXRecordDecl /*P*/ SrcPointeeRD = SrcType.$arrow().getPointeeCXXRecordDecl();
    /*const*/ CXXRecordDecl /*P*/ SrcRD = (SrcPointeeRD != null) ? SrcPointeeRD : SrcType.$arrow().getAsCXXRecordDecl();
    
    // Examining subobjects for records is only possible if the complete and
    // valid definition is available.  Also, template instantiation is not
    // allowed here.
    if (!(SrcRD != null) || !SrcRD.isCompleteDefinition() || SrcRD.isInvalidDecl()) {
      return;
    }
    
    /*const*/ CXXRecordDecl /*P*/ DestRD = DestType.$arrow().getPointeeCXXRecordDecl();
    if (!(DestRD != null) || !DestRD.isCompleteDefinition() || DestRD.isInvalidDecl()) {
      return;
    }
    
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int ReinterpretUpcast = 0;
      final /*uint*/int ReinterpretDowncast = ReinterpretUpcast + 1;
    /*}*//*Unnamed enum*//*uint*/int ReinterpretKind;
    
    BasePaths/*J*/= new CXXBasePaths();
    if (SrcRD.isDerivedFrom(DestRD, BasePaths)) {
      ReinterpretKind = ReinterpretUpcast;
    } else if (DestRD.isDerivedFrom(SrcRD, BasePaths)) {
      ReinterpretKind = ReinterpretDowncast;
    } else {
      return;
    }
    
    boolean VirtualBase = true;
    boolean NonZeroOffset = false;
    for (std.list.iterator<CXXBasePath> I = new std.list.iterator<CXXBasePath>(BasePaths.begin()), 
        E = new std.list.iterator<CXXBasePath>(BasePaths.end());
         I.$noteq(E); I.$preInc()) {
      final /*const*/ CXXBasePath /*&*/ Path = I.$star();
      CharUnits Offset = CharUnits.Zero();
      boolean IsVirtual = false;
      for (type$ptr<CXXBasePathElement> IElem = $tryClone(Path.begin$Const()), /*P*/ EElem = $tryClone(Path.end$Const());
           $noteq_ptr(IElem, EElem); IElem.$preInc()) {
        IsVirtual = IElem./*->*/$star().Base.isVirtual();
        if (IsVirtual) {
          break;
        }
        /*const*/ CXXRecordDecl /*P*/ BaseRD = IElem./*->*/$star().Base.getType().$arrow().getAsCXXRecordDecl();
        assert ((BaseRD != null)) : "Base type should be a valid unqualified class type";
        // Don't check if any base has invalid declaration or has no definition
        // since it has no layout info.
        /*const*/ CXXRecordDecl /*P*/ Class = IElem./*->*/$star().Class, 
            /*P*/ ClassDefinition = Class.getDefinition();
        if (Class.isInvalidDecl() || !(ClassDefinition != null)
           || !ClassDefinition.isCompleteDefinition()) {
          return;
        }
        
        final /*const*/ ASTRecordLayout /*&*/ DerivedLayout = Self.Context.getASTRecordLayout(Class);
        Offset.$addassign(DerivedLayout.getBaseClassOffset(BaseRD));
      }
      if (!IsVirtual) {
        // Don't warn if any path is a non-virtually derived base at offset zero.
        if (Offset.isZero()) {
          return;
        } else {
          // Offset makes sense only for non-virtual bases.
          NonZeroOffset = true;
        }
      }
      VirtualBase = VirtualBase && IsVirtual;
    }
    
    //(void)NonZeroOffset; // Silence set but not used warning.
    assert ((VirtualBase || NonZeroOffset)) : "Should have returned if has non-virtual base with zero offset";
    
    QualType BaseType = new QualType(ReinterpretKind == ReinterpretUpcast ? DestType : SrcType);
    QualType DerivedType = new QualType(ReinterpretKind == ReinterpretUpcast ? SrcType : DestType);
    
    SourceLocation BeginLoc = OpRange.getBegin();
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(BeginLoc), diag.warn_reinterpret_different_from_static)), 
                        DerivedType), BaseType), !VirtualBase), ((int)(ReinterpretKind))), 
        OpRange));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(BeginLoc), diag.note_reinterpret_updowncast_use_static)), 
            ((int)(ReinterpretKind))), 
        FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/BeginLoc), new StringRef(/*KEEP_STR*/$static_cast))));
  } finally {
    if (BasePaths != null) { BasePaths.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseCastOfObjCSEL">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1710,
 FQN="DiagnoseCastOfObjCSEL", NM="_ZL21DiagnoseCastOfObjCSELRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL21DiagnoseCastOfObjCSELRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE")
//</editor-fold>
public static void DiagnoseCastOfObjCSEL(final Sema /*&*/ Self, final /*const*/ ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, 
                     QualType DestType) {
  QualType SrcType = SrcExpr.get().getType();
  if (Self.Context.hasSameType(new QualType(SrcType), new QualType(DestType))) {
    return;
  }
  {
    /*const*/ PointerType /*P*/ SrcPtrTy = SrcType.$arrow().getAs(PointerType.class);
    if ((SrcPtrTy != null)) {
      if (SrcPtrTy.isObjCSelType()) {
        QualType DT = new QualType(DestType);
        if (isa_PointerType(DestType)) {
          DT.$assignMove(DestType.$arrow().getPointeeType());
        }
        if (!DT.getUnqualifiedType().$arrow().isVoidType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getExprLoc(), 
                            diag.warn_cast_pointer_from_sel)), 
                        SrcType), DestType), SrcExpr.get().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
}


/// Diagnose casts that change the calling convention of a pointer to a function
/// defined in the current TU.
//<editor-fold defaultstate="collapsed" desc="DiagnoseCallingConvCast">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,       
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1729,
 FQN="DiagnoseCallingConvCast", NM="_ZL23DiagnoseCallingConvCastRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL23DiagnoseCallingConvCastRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeENS_11SourceRangeE")
//</editor-fold>
public static void DiagnoseCallingConvCast(final Sema /*&*/ Self, final /*const*/ ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, 
                       QualType DstType, SourceRange OpRange) {
  raw_svector_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Check if this cast would change the calling convention of a function
    // pointer type.
    QualType SrcType = SrcExpr.get().getType();
    if (Self.Context.hasSameType(new QualType(SrcType), new QualType(DstType))
       || !SrcType.$arrow().isFunctionPointerType() || !DstType.$arrow().isFunctionPointerType()) {
      return;
    }
    /*const*/ FunctionType /*P*/ SrcFTy = SrcType.$arrow().castAs(PointerType.class).getPointeeType().$arrow().castAs(FunctionType.class);
    /*const*/ FunctionType /*P*/ DstFTy = DstType.$arrow().castAs(PointerType.class).getPointeeType().$arrow().castAs(FunctionType.class);
    CallingConv SrcCC = SrcFTy.getCallConv();
    CallingConv DstCC = DstFTy.getCallConv();
    if (SrcCC == DstCC) {
      return;
    }
    
    // We have a calling convention cast. Check if the source is a pointer to a
    // known, specific function that has already been defined.
    Expr /*P*/ Src = SrcExpr.get().IgnoreParenImpCasts();
    {
      UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(Src);
      if ((UO != null)) {
        if (UO.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
          Src = UO.getSubExpr().IgnoreParenImpCasts();
        }
      }
    }
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Src);
    if (!(DRE != null)) {
      return;
    }
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DRE.getDecl());
    final type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
    if (!(FD != null) || !FD.hasBody(Definition)) {
      return;
    }
    
    // Only warn if we are casting from the default convention to a non-default
    // convention. This can happen when the programmer forgot to apply the calling
    // convention to the function definition and then inserted this cast to
    // satisfy the type system.
    CallingConv DefaultCC = Self.getASTContext().getDefaultCallingConvention(FD.isVariadic(), FD.isCXXInstanceMember());
    if (DstCC == DefaultCC || SrcCC != DefaultCC) {
      return;
    }
    
    // Diagnose this cast, as it is probably bad.
    StringRef SrcCCName = FunctionType.getNameForCallConv(SrcCC);
    StringRef DstCCName = FunctionType.getNameForCallConv(DstCC);
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.warn_cast_calling_conv)), 
                SrcCCName), DstCCName), OpRange));
    
    // The checks above are cheaper than checking if the diagnostic is enabled.
    // However, it's worth checking if the warning is enabled before we construct
    // a fixit.
    if (Self.Diags.isIgnored(diag.warn_cast_calling_conv, OpRange.getBegin())) {
      return;
    }
    
    // Try to suggest a fixit to change the calling convention of the function
    // whose address was taken. Try to use the latest macro for the convention.
    // For example, users probably want to write "WINAPI" instead of "__stdcall"
    // to match the Windows header declarations.
    SourceLocation NameLoc = Definition.$deref().getNameInfo().getLoc();
    final Preprocessor /*&*/ PP = Self.getPreprocessor();
    SmallVector<TokenValue> AttrTokens/*J*/= new SmallVector<TokenValue>(6, new TokenValue());
    SmallString/*64*/ CCAttrText/*J*/= new SmallString/*64*/(64);
    OS/*J*/= new raw_svector_ostream(CCAttrText);
    if (Self.getLangOpts().MicrosoftExt) {
      // __stdcall or __vectorcall
      OS.$out(/*KEEP_STR*/"__").$out(/*NO_COPY*/DstCCName);
      IdentifierInfo /*P*/ II = PP.getIdentifierInfo(/*JAVA: OS.str()*/CCAttrText);
      AttrTokens.push_back(II.isKeyword(Self.getLangOpts()) ? new TokenValue(II.getTokenID()) : new TokenValue(II));
    } else {
      // __attribute__((stdcall)) or __attribute__((vectorcall))
      OS.$out(/*KEEP_STR*/"__attribute__((").$out(/*NO_COPY*/DstCCName).$out(/*KEEP_STR*/"))");
      AttrTokens.push_back(new TokenValue(tok.TokenKind.kw___attribute));
      AttrTokens.push_back(new TokenValue(tok.TokenKind.l_paren));
      AttrTokens.push_back(new TokenValue(tok.TokenKind.l_paren));
      char$ptr data = DstCCName.data();
      IdentifierInfo /*P*/ II = PP.getIdentifierInfo(data.$array(), data.$index(), DstCCName.size());
      AttrTokens.push_back(II.isKeyword(Self.getLangOpts()) ? new TokenValue(II.getTokenID()) : new TokenValue(II));
      AttrTokens.push_back(new TokenValue(tok.TokenKind.r_paren));
      AttrTokens.push_back(new TokenValue(tok.TokenKind.r_paren));
    }
    StringRef AttrSpelling = PP.getLastMacroWithSpelling(new SourceLocation(NameLoc), new ArrayRef<TokenValue>(AttrTokens, false));
    if (!AttrSpelling.empty()) {
      CCAttrText.$assign(/*NO_COPY*/AttrSpelling);
    }
    OS.$out_char($$SPACE);
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(NameLoc), diag.note_change_calling_conv_fixit)), 
                FD), DstCCName), FixItHint.CreateInsertion(/*NO_COPY*/NameLoc, CCAttrText.$StringRef())));
  } finally {
    if (OS != null) { OS.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="checkIntToPointerCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1818,
 FQN="checkIntToPointerCast", NM="_ZL21checkIntToPointerCastbN5clang14SourceLocationEPKNS_4ExprENS_8QualTypeERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL21checkIntToPointerCastbN5clang14SourceLocationEPKNS_4ExprENS_8QualTypeERNS_4SemaE")
//</editor-fold>
public static void checkIntToPointerCast(boolean CStyle, SourceLocation Loc, 
                     /*const*/ Expr /*P*/ SrcExpr, QualType DestType, 
                     final Sema /*&*/ Self) {
  QualType SrcType = SrcExpr.getType();
  
  // Not warning on reinterpret_cast, boolean, constant expressions, etc
  // are not explicit design choices, but consistent with GCC's behavior.
  // Feel free to modify them if you've reason/evidence for an alternative.
  if (CStyle && SrcType.$arrow().isIntegralType(Self.Context)
     && !SrcType.$arrow().isBooleanType()
     && !SrcType.$arrow().isEnumeralType()
     && !SrcExpr.isIntegerConstantExpr(Self.Context)
     && $greater_ulong(Self.Context.getTypeSize(new QualType(DestType))
    , Self.Context.getTypeSize(new QualType(SrcType)))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Separate between casts to void* and non-void* pointers.
      // Some APIs use (abuse) void* for something like a user context,
      // and often that value is an integer even if it isn't a pointer itself.
      // Having a separate warning flag allows users to control the warning
      // for their workflow.
      /*uint*/int Diag = DestType.$arrow().isVoidPointerType() ? diag.warn_int_to_void_pointer_cast : diag.warn_int_to_pointer_cast;
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(Loc), Diag)), SrcType), DestType));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="fixOverloadedReinterpretCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1844,
 FQN="fixOverloadedReinterpretCastExpr", NM="_ZL32fixOverloadedReinterpretCastExprRN5clang4SemaENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL32fixOverloadedReinterpretCastExprRN5clang4SemaENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public static boolean fixOverloadedReinterpretCastExpr(final Sema /*&*/ Self, QualType DestType, 
                                final ActionResultTTrue<Expr /*P*/ > /*&*/ Result) {
  // We can only fix an overloaded reinterpret_cast if
  // - it is a template with explicit arguments that resolves to an lvalue
  //   unambiguously, or
  // - it is the only function in an overload set that may have its address
  //   taken.
  Expr /*P*/ E = Result.get();
  // TODO: what if this fails because of DiagnoseUseOfDecl or something
  // like it?
  if (Self.ResolveAndFixSingleFunctionTemplateSpecialization(Result, 
      Expr.getValueKindForType(new QualType(DestType)) == ExprValueKind.VK_RValue)
    // Convert Fun to Ptr
     && Result.isUsable()) {
    return true;
  }
  
  // No guarantees that ResolveAndFixSingleFunctionTemplateSpecialization
  // preserves Result.
  Result.$assign(E);
  if (!Self.resolveAndFixAddressOfOnlyViableOverloadCandidate(Result)) {
    return false;
  }
  return Result.isUsable();
}


/// DiagnoseBadFunctionCast - Warn whenever a function call is cast to a 
///  non-matching type. Such as enum function call to int, int call to
/// pointer; etc. Cast to 'void' is an exception.
//<editor-fold defaultstate="collapsed" desc="DiagnoseBadFunctionCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 2299,
 FQN="DiagnoseBadFunctionCast", NM="_ZL23DiagnoseBadFunctionCastRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZL23DiagnoseBadFunctionCastRN5clang4SemaERKNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE")
//</editor-fold>
public static void DiagnoseBadFunctionCast(final Sema /*&*/ Self, final /*const*/ ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, 
                       QualType DestType) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Self.Diags.isIgnored(diag.warn_bad_function_cast, 
        SrcExpr.get().getExprLoc())) {
      return;
    }
    if (!isa_CallExpr(SrcExpr.get())) {
      return;
    }
    
    QualType SrcType = SrcExpr.get().getType();
    if (DestType.getUnqualifiedType().$arrow().isVoidType()) {
      return;
    }
    if ((SrcType.$arrow().isAnyPointerType() || SrcType.$arrow().isBlockPointerType())
       && (DestType.$arrow().isAnyPointerType() || DestType.$arrow().isBlockPointerType())) {
      return;
    }
    if (SrcType.$arrow().isIntegerType() && DestType.$arrow().isIntegerType()
       && (SrcType.$arrow().isBooleanType() == DestType.$arrow().isBooleanType())
       && (SrcType.$arrow().isEnumeralType() == DestType.$arrow().isEnumeralType())) {
      return;
    }
    if (SrcType.$arrow().isRealFloatingType() && DestType.$arrow().isRealFloatingType()) {
      return;
    }
    if (SrcType.$arrow().isEnumeralType() && DestType.$arrow().isEnumeralType()) {
      return;
    }
    if (SrcType.$arrow().isComplexType() && DestType.$arrow().isComplexType()) {
      return;
    }
    if (SrcType.$arrow().isComplexIntegerType() && DestType.$arrow().isComplexIntegerType()) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getExprLoc(), 
                    diag.warn_bad_function_cast)), 
                SrcType), DestType), SrcExpr.get().getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}

} // END OF class SemaCastStatics
