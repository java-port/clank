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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.QualType.*;
import static org.clang.sema.impl.SemaCastStatics.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 50,
 FQN="(anonymous namespace)::CastOperation", NM="_ZN12_GLOBAL__N_113CastOperationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperationE")
//</editor-fold>
public class/*struct*/ CastOperation implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::CastOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 51,
   FQN="(anonymous namespace)::CastOperation::CastOperation", NM="_ZN12_GLOBAL__N_113CastOperationC1ERN5clang4SemaENS1_8QualTypeENS1_12ActionResultIPNS1_4ExprELb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperationC1ERN5clang4SemaENS1_8QualTypeENS1_12ActionResultIPNS1_4ExprELb1EEE")
  //</editor-fold>
  public CastOperation(final Sema /*&*/ S, QualType destType, ActionResultTTrue<Expr /*P*/ > src) {
    // : Self(S), SrcExpr(src), DestType(destType), ResultType(destType.getNonLValueExprType(S.Context)), ValueKind(Expr::getValueKindForType(destType)), Kind(CK_Dependent), BasePath(), IsARCUnbridgedCast(false), OpRange(), DestRange() 
    //START JInit
    this./*&*/Self=/*&*/S;
    this.SrcExpr = new ActionResultTTrue<Expr /*P*/ >(src);
    this.DestType = new QualType(destType);
    this.ResultType = destType.getNonLValueExprType(S.Context);
    this.ValueKind = Expr.getValueKindForType(new QualType(destType));
    this.Kind = CastKind.CK_Dependent;
    this.BasePath = new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
    this.IsARCUnbridgedCast = false;
    this.OpRange = new SourceRange();
    this.DestRange = new SourceRange();
    //END JInit
    {
      
      /*const*/ BuiltinType /*P*/ placeholder = src.get().getType().$arrow().getAsPlaceholderType();
      if ((placeholder != null)) {
        PlaceholderKind = placeholder.getKind();
      } else {
        PlaceholderKind = BuiltinType.Kind.valueOf(0);
      }
    }
  }

  
  public final Sema /*&*/ Self;
  public ActionResultTTrue<Expr /*P*/ > SrcExpr;
  public QualType DestType;
  public QualType ResultType;
  public ExprValueKind ValueKind;
  public CastKind Kind;
  public BuiltinType.Kind PlaceholderKind;
  public SmallVector<CXXBaseSpecifier /*P*/> BasePath;
  public boolean IsARCUnbridgedCast;
  
  public SourceRange OpRange;
  public SourceRange DestRange;
  
  // Top-level semantics-checking routines.
  
  /// CheckConstCast - Check that a const_cast\<DestType\>(SrcExpr) is valid.
  /// Refer to C++ 5.2.11 for details. const_cast is typically used in code
  /// like this:
  /// const char *str = "literal";
  /// legacy_function(const_cast\<char*\>(str));
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::CheckConstCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 727,
   FQN="(anonymous namespace)::CastOperation::CheckConstCast", NM="_ZN12_GLOBAL__N_113CastOperation14CheckConstCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation14CheckConstCastEv")
  //</editor-fold>
  public void CheckConstCast() {
    if (ValueKind == ExprValueKind.VK_RValue) {
      SrcExpr.$assignMove(Self.DefaultFunctionArrayLvalueConversion(SrcExpr.get()));
    } else if (isPlaceholder()) {
      SrcExpr.$assignMove(Self.CheckPlaceholderExpr(SrcExpr.get()));
    }
    if (SrcExpr.isInvalid()) { // if conversion failed, don't report another error
      return;
    }
    
    uint$ref msg = create_uint$ref(diag.err_bad_cxx_cast_generic);
    if (TryConstCast(Self, SrcExpr, new QualType(DestType), /*CStyle*/ false, msg) != TryCastResult.TC_Success
       && msg.$deref() != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), msg.$deref())), CastType.CT_Const), 
                    SrcExpr.get().getType()), DestType), OpRange));
        SrcExpr.$assignMove(ExprError());
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// CheckReinterpretCast - Check that a reinterpret_cast\<DestType\>(SrcExpr) is
  /// valid.
  /// Refer to C++ 5.2.10 for details. reinterpret_cast is typically used in code
  /// like this:
  /// char *bytes = reinterpret_cast\<char*\>(int_ptr);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::CheckReinterpretCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 842,
   FQN="(anonymous namespace)::CastOperation::CheckReinterpretCast", NM="_ZN12_GLOBAL__N_113CastOperation20CheckReinterpretCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation20CheckReinterpretCastEv")
  //</editor-fold>
  public void CheckReinterpretCast() {
    if (ValueKind == ExprValueKind.VK_RValue && !isPlaceholder(BuiltinType.Kind.Overload)) {
      SrcExpr.$assignMove(Self.DefaultFunctionArrayLvalueConversion(SrcExpr.get()));
    } else {
      checkNonOverloadPlaceholders();
    }
    if (SrcExpr.isInvalid()) { // if conversion failed, don't report another error
      return;
    }
    
    uint$ref msg = create_uint$ref(diag.err_bad_cxx_cast_generic);
    TryCastResult tcr = TryReinterpretCast(Self, SrcExpr, new QualType(DestType), 
        /*CStyle*/ false, new SourceRange(OpRange), msg, Kind$Ref);
    if (tcr != TryCastResult.TC_Success && msg.$deref() != 0) {
      if (SrcExpr.isInvalid()) { // if conversion failed, don't report another error
        return;
      }
      if ($eq_QualType$C(SrcExpr.get().getType(), Self.Context.OverloadTy.$QualType())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          //FIXME: &f<int>; is overloaded and resolvable 
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_reinterpret_cast_overload)), 
                      OverloadExpr.find(SrcExpr.get()).Expression.getName()), 
                  DestType), OpRange));
          Self.NoteAllOverloadCandidates(SrcExpr.get());
        } finally {
          $c$.$destroy();
        }
      } else {
        diagnoseBadCast(Self, msg.$deref(), CastType.CT_Reinterpret, new SourceRange(OpRange), SrcExpr.get(), 
            new QualType(DestType), /*listInitialization=*/ false);
      }
      SrcExpr.$assignMove(ExprError());
    } else if (tcr == TryCastResult.TC_Success) {
      if (Self.getLangOpts().ObjCAutoRefCount) {
        checkObjCARCConversion(Sema.CheckedConversionKind.CCK_OtherCast);
      }
      DiagnoseReinterpretUpDownCast(Self, SrcExpr.get(), new QualType(DestType), new SourceRange(OpRange));
    }
  }

  
  /// CheckStaticCast - Check that a static_cast\<DestType\>(SrcExpr) is valid.
  /// Refer to C++ 5.2.9 for details. Static casts are mostly used for making
  /// implicit conversions explicit and getting rid of data loss warnings.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::CheckStaticCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 881,
   FQN="(anonymous namespace)::CastOperation::CheckStaticCast", NM="_ZN12_GLOBAL__N_113CastOperation15CheckStaticCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation15CheckStaticCastEv")
  //</editor-fold>
  public void CheckStaticCast() {
    if (isPlaceholder()) {
      checkNonOverloadPlaceholders();
      if (SrcExpr.isInvalid()) {
        return;
      }
    }
    
    // This test is outside everything else because it's the only case where
    // a non-lvalue-reference target type does not lead to decay.
    // C++ 5.2.9p4: Any expression can be explicitly converted to type "cv void".
    if (DestType.$arrow().isVoidType()) {
      Kind = CastKind.CK_ToVoid;
      if (claimPlaceholder(BuiltinType.Kind.Overload)) {
        Self.ResolveAndFixSingleFunctionTemplateSpecialization(SrcExpr, 
            false,  // Decay Function to ptr 
            true,  // Complain
            new SourceRange(OpRange), new QualType(DestType), diag.err_bad_static_cast_overload);
        if (SrcExpr.isInvalid()) {
          return;
        }
      }
      
      SrcExpr.$assignMove(Self.IgnoredValueConversions(SrcExpr.get()));
      return;
    }
    if (ValueKind == ExprValueKind.VK_RValue && !DestType.$arrow().isRecordType()
       && !isPlaceholder(BuiltinType.Kind.Overload)) {
      SrcExpr.$assignMove(Self.DefaultFunctionArrayLvalueConversion(SrcExpr.get()));
      if (SrcExpr.isInvalid()) { // if conversion failed, don't report another error
        return;
      }
    }
    
    uint$ref msg = create_uint$ref(diag.err_bad_cxx_cast_generic);
    TryCastResult tcr = TryStaticCast(Self, SrcExpr, new QualType(DestType), Sema.CheckedConversionKind.CCK_OtherCast, new SourceRange(OpRange), msg, 
        Kind$Ref, BasePath, /*ListInitialization=*/ false);
    if (tcr != TryCastResult.TC_Success && msg.$deref() != 0) {
      if (SrcExpr.isInvalid()) {
        return;
      }
      if ($eq_QualType$C(SrcExpr.get().getType(), Self.Context.OverloadTy.$QualType())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          OverloadExpr /*P*/ oe = OverloadExpr.find(SrcExpr.get()).Expression;
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_static_cast_overload)), 
                          oe.getName()), DestType), OpRange), 
              oe.getQualifierLoc().getSourceRange()));
          Self.NoteAllOverloadCandidates(SrcExpr.get());
        } finally {
          $c$.$destroy();
        }
      } else {
        diagnoseBadCast(Self, msg.$deref(), CastType.CT_Static, new SourceRange(OpRange), SrcExpr.get(), new QualType(DestType), 
            /*listInitialization=*/ false);
      }
      SrcExpr.$assignMove(ExprError());
    } else if (tcr == TryCastResult.TC_Success) {
      if (Kind == CastKind.CK_BitCast) {
        checkCastAlign();
      }
      if (Self.getLangOpts().ObjCAutoRefCount) {
        checkObjCARCConversion(Sema.CheckedConversionKind.CCK_OtherCast);
      }
    } else if (Kind == CastKind.CK_BitCast) {
      checkCastAlign();
    }
  }

  
  /// CheckDynamicCast - Check that a dynamic_cast\<DestType\>(SrcExpr) is valid.
  /// Refer to C++ 5.2.7 for details. Dynamic casts are used mostly for runtime-
  /// checked downcasts in class hierarchies.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::CheckDynamicCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 574,
   FQN="(anonymous namespace)::CastOperation::CheckDynamicCast", NM="_ZN12_GLOBAL__N_113CastOperation16CheckDynamicCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation16CheckDynamicCastEv")
  //</editor-fold>
  public void CheckDynamicCast() {
    if (ValueKind == ExprValueKind.VK_RValue) {
      SrcExpr.$assignMove(Self.DefaultFunctionArrayLvalueConversion(SrcExpr.get()));
    } else if (isPlaceholder()) {
      SrcExpr.$assignMove(Self.CheckPlaceholderExpr(SrcExpr.get()));
    }
    if (SrcExpr.isInvalid()) { // if conversion failed, don't report another error
      return;
    }
    
    QualType OrigSrcType = SrcExpr.get().getType();
    QualType DestType = Self.Context.getCanonicalType(new QualType(this.DestType)).$QualType();
    
    // C++ 5.2.7p1: T shall be a pointer or reference to a complete class type,
    //   or "pointer to cv void".
    QualType DestPointee/*J*/= new QualType();
    /*const*/ PointerType /*P*/ DestPointer = DestType.$arrow().getAs(PointerType.class);
    /*const*/ ReferenceType /*P*/ DestReference = null;
    if ((DestPointer != null)) {
      DestPointee.$assignMove(DestPointer.getPointeeType());
    } else if (((DestReference = DestType.$arrow().getAs(ReferenceType.class)) != null)) {
      DestPointee.$assignMove(DestReference.getPointeeType());
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_dynamic_cast_not_ref_or_ptr)), 
                this.DestType), DestRange));
        SrcExpr.$assignMove(ExprError());
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    /*const*/ RecordType /*P*/ DestRecord = DestPointee.$arrow().<RecordType>getAs$RecordType();
    if (DestPointee.$arrow().isVoidType()) {
      assert ((DestPointer != null)) : "Reference to void is not possible";
    } else if ((DestRecord != null)) {
      if (Self.RequireCompleteType$T(OpRange.getBegin(), new QualType(DestPointee), 
          diag.err_bad_dynamic_cast_incomplete, 
          DestRange)) {
        SrcExpr.$assignMove(ExprError());
        return;
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_dynamic_cast_not_class)), 
                DestPointee.getUnqualifiedType()), DestRange));
        SrcExpr.$assignMove(ExprError());
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++0x 5.2.7p2: If T is a pointer type, v shall be an rvalue of a pointer to
    //   complete class type, [...]. If T is an lvalue reference type, v shall be
    //   an lvalue of a complete class type, [...]. If T is an rvalue reference 
    //   type, v shall be an expression having a complete class type, [...]
    QualType SrcType = Self.Context.getCanonicalType(new QualType(OrigSrcType)).$QualType();
    QualType SrcPointee/*J*/= new QualType();
    if ((DestPointer != null)) {
      {
        /*const*/ PointerType /*P*/ SrcPointer = SrcType.$arrow().getAs(PointerType.class);
        if ((SrcPointer != null)) {
          SrcPointee.$assignMove(SrcPointer.getPointeeType());
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_dynamic_cast_not_ptr)), 
                    OrigSrcType), SrcExpr.get().getSourceRange()));
            SrcExpr.$assignMove(ExprError());
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else if (DestReference.isLValueReferenceType()) {
      if (!SrcExpr.get().isLValue()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_cxx_cast_rvalue)), 
                          CastType.CT_Dynamic), OrigSrcType), this.DestType), OpRange));
        } finally {
          $c$.$destroy();
        }
      }
      SrcPointee.$assign(SrcType);
    } else {
      // If we're dynamic_casting from a prvalue to an rvalue reference, we need
      // to materialize the prvalue before we bind the reference to it.
      if (SrcExpr.get().isRValue()) {
        SrcExpr.$assign(Self.CreateMaterializeTemporaryExpr(new QualType(SrcType), SrcExpr.get(), /*IsLValueReference*/ false));
      }
      SrcPointee.$assign(SrcType);
    }
    
    /*const*/ RecordType /*P*/ SrcRecord = SrcPointee.$arrow().<RecordType>getAs$RecordType();
    if ((SrcRecord != null)) {
      if (Self.RequireCompleteType$T(OpRange.getBegin(), new QualType(SrcPointee), 
          diag.err_bad_dynamic_cast_incomplete, 
          SrcExpr.get())) {
        SrcExpr.$assignMove(ExprError());
        return;
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_dynamic_cast_not_class)), 
                SrcPointee.getUnqualifiedType()), SrcExpr.get().getSourceRange()));
        SrcExpr.$assignMove(ExprError());
        return;
      } finally {
        $c$.$destroy();
      }
    }
    assert (((DestPointer != null) || (DestReference != null))) : "Bad destination non-ptr/ref slipped through.";
    assert (((DestRecord != null) || DestPointee.$arrow().isVoidType())) : "Bad destination pointee slipped through.";
    assert ((SrcRecord != null)) : "Bad source pointee slipped through.";
    
    // C++ 5.2.7p1: The dynamic_cast operator shall not cast away constness.
    if (!DestPointee.isAtLeastAsQualifiedAs(new QualType(SrcPointee))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_cxx_cast_qualifiers_away)), 
                        CastType.CT_Dynamic), OrigSrcType), this.DestType), OpRange));
        SrcExpr.$assignMove(ExprError());
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++ 5.2.7p3: If the type of v is the same as the required result type,
    //   [except for cv].
    if (DestRecord == SrcRecord) {
      Kind = CastKind.CK_NoOp;
      return;
    }
    
    // C++ 5.2.7p5
    // Upcasts are resolved statically.
    if ((DestRecord != null)
       && Self.IsDerivedFrom(OpRange.getBegin(), new QualType(SrcPointee), new QualType(DestPointee))) {
      if (Self.CheckDerivedToBaseConversion(new QualType(SrcPointee), new QualType(DestPointee), 
          OpRange.getBegin(), new SourceRange(OpRange), 
          $AddrOf(BasePath))) {
        SrcExpr.$assignMove(ExprError());
        return;
      }
      
      Kind = CastKind.CK_DerivedToBase;
      return;
    }
    
    // C++ 5.2.7p6: Otherwise, v shall be [polymorphic].
    /*const*/ RecordDecl /*P*/ SrcDecl = SrcRecord.getDecl().getDefinition();
    assert ((SrcDecl != null)) : "Definition missing";
    if (!cast_CXXRecordDecl(SrcDecl).isPolymorphic()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_dynamic_cast_not_polymorphic)), 
                SrcPointee.getUnqualifiedType()), SrcExpr.get().getSourceRange()));
        SrcExpr.$assignMove(ExprError());
      } finally {
        $c$.$destroy();
      }
    }
    
    // dynamic_cast is not available with -fno-rtti.
    // As an exception, dynamic_cast to void* is available because it doesn't
    // use RTTI.
    if (!Self.getLangOpts().RTTI && !DestPointee.$arrow().isVoidType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Self.Diag(OpRange.getBegin(), diag.err_no_dynamic_cast_with_fno_rtti)));
        SrcExpr.$assignMove(ExprError());
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Done. Everything else is run-time checks.
    Kind = CastKind.CK_Dynamic;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::CheckCXXCStyleCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 2165,
   FQN="(anonymous namespace)::CastOperation::CheckCXXCStyleCast", NM="_ZN12_GLOBAL__N_113CastOperation18CheckCXXCStyleCastEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation18CheckCXXCStyleCastEbb")
  //</editor-fold>
  public void CheckCXXCStyleCast(boolean FunctionalStyle, 
                    boolean ListInitialization) {
    // Handle placeholders.
    if (isPlaceholder()) {
      // C-style casts can resolve __unknown_any types.
      if (claimPlaceholder(BuiltinType.Kind.UnknownAny)) {
        SrcExpr.$assignMove(Self.checkUnknownAnyCast(new SourceRange(DestRange), new QualType(DestType), 
                SrcExpr.get(), Kind$Ref, 
                ValueKind$Ref, BasePath));
        return;
      }
      
      checkNonOverloadPlaceholders();
      if (SrcExpr.isInvalid()) {
        return;
      }
    }
    
    // C++ 5.2.9p4: Any expression can be explicitly converted to type "cv void".
    // This test is outside everything else because it's the only case where
    // a non-lvalue-reference target type does not lead to decay.
    if (DestType.$arrow().isVoidType()) {
      Kind = CastKind.CK_ToVoid;
      if (claimPlaceholder(BuiltinType.Kind.Overload)) {
        Self.ResolveAndFixSingleFunctionTemplateSpecialization(SrcExpr, /* Decay Function to ptr */ false, 
            /* Complain */ true, new SourceRange(DestRange), new QualType(DestType), 
            diag.err_bad_cstyle_cast_overload);
        if (SrcExpr.isInvalid()) {
          return;
        }
      }
      
      SrcExpr.$assignMove(Self.IgnoredValueConversions(SrcExpr.get()));
      return;
    }
    
    // If the type is dependent, we won't do any other semantic analysis now.
    if (DestType.$arrow().isDependentType() || SrcExpr.get().isTypeDependent()
       || SrcExpr.get().isValueDependent()) {
      assert (Kind == CastKind.CK_Dependent);
      return;
    }
    if (ValueKind == ExprValueKind.VK_RValue && !DestType.$arrow().isRecordType()
       && !isPlaceholder(BuiltinType.Kind.Overload)) {
      SrcExpr.$assignMove(Self.DefaultFunctionArrayLvalueConversion(SrcExpr.get()));
      if (SrcExpr.isInvalid()) {
        return;
      }
    }
    {
      
      // AltiVec vector initialization with a single literal.
      /*const*/ VectorType /*P*/ vecTy = DestType.$arrow().getAs(VectorType.class);
      if ((vecTy != null)) {
        if (vecTy.getVectorKind() == VectorType.VectorKind.AltiVecVector
           && (SrcExpr.get().getType().$arrow().isIntegerType()
           || SrcExpr.get().getType().$arrow().isFloatingType())) {
          Kind = CastKind.CK_VectorSplat;
          SrcExpr.$assignMove(Self.prepareVectorSplat(new QualType(DestType), SrcExpr.get()));
          return;
        }
      }
    }
    
    // C++ [expr.cast]p5: The conversions performed by
    //   - a const_cast,
    //   - a static_cast,
    //   - a static_cast followed by a const_cast,
    //   - a reinterpret_cast, or
    //   - a reinterpret_cast followed by a const_cast,
    //   can be performed using the cast notation of explicit type conversion.
    //   [...] If a conversion can be interpreted in more than one of the ways
    //   listed above, the interpretation that appears first in the list is used,
    //   even if a cast resulting from that interpretation is ill-formed.
    // In plain language, this means trying a const_cast ...
    uint$ref msg = create_uint$ref(diag.err_bad_cxx_cast_generic);
    TryCastResult tcr = TryConstCast(Self, SrcExpr, new QualType(DestType), 
        /*CStyle*/ true, msg);
    if (SrcExpr.isInvalid()) {
      return;
    }
    if (tcr == TryCastResult.TC_Success) {
      Kind = CastKind.CK_NoOp;
    }
    
    Sema.CheckedConversionKind CCK = FunctionalStyle ? Sema.CheckedConversionKind.CCK_FunctionalCast : Sema.CheckedConversionKind.CCK_CStyleCast;
    if (tcr == TryCastResult.TC_NotApplicable) {
      // ... or if that is not possible, a static_cast, ignoring const, ...
      tcr = TryStaticCast(Self, SrcExpr, new QualType(DestType), CCK, new SourceRange(OpRange), 
          msg, Kind$Ref, BasePath, ListInitialization);
      if (SrcExpr.isInvalid()) {
        return;
      }
      if (tcr == TryCastResult.TC_NotApplicable) {
        // ... and finally a reinterpret_cast, ignoring const.
        tcr = TryReinterpretCast(Self, SrcExpr, new QualType(DestType), /*CStyle*/ true, 
            new SourceRange(OpRange), msg, Kind$Ref);
        if (SrcExpr.isInvalid()) {
          return;
        }
      }
    }
    if (Self.getLangOpts().ObjCAutoRefCount && tcr == TryCastResult.TC_Success) {
      checkObjCARCConversion(CCK);
    }
    if (tcr != TryCastResult.TC_Success && msg.$deref() != 0) {
      if ($eq_QualType$C(SrcExpr.get().getType(), Self.Context.OverloadTy.$QualType())) {
        DeclAccessPair Found/*J*/= new DeclAccessPair();
        FunctionDecl /*P*/ Fn = Self.ResolveAddressOfOverloadedFunction(SrcExpr.get(), 
            new QualType(DestType), 
            /*Complain*/ true, 
            Found);
        if ((Fn != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If DestType is a function type (not to be confused with the function
            // pointer type), it will be possible to resolve the function address,
            // but the type cast should be considered as failure.
            OverloadExpr /*P*/ OE = OverloadExpr.find(SrcExpr.get()).Expression;
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_bad_cstyle_cast_overload)), 
                            OE.getName()), DestType), OpRange), 
                OE.getQualifierLoc().getSourceRange()));
            Self.NoteAllOverloadCandidates(SrcExpr.get());
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        diagnoseBadCast(Self, msg.$deref(), (FunctionalStyle ? CastType.CT_Functional : CastType.CT_CStyle), 
            new SourceRange(OpRange), SrcExpr.get(), new QualType(DestType), ListInitialization);
      }
    } else if (Kind == CastKind.CK_BitCast) {
      checkCastAlign();
    }
    
    // Clear out SrcExpr if there was a fatal error.
    if (tcr != TryCastResult.TC_Success) {
      SrcExpr.$assignMove(ExprError());
    }
  }

  
  /// Check the semantics of a C-style cast operation, in C.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::CheckCStyleCast">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pass fields references*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 2333,
   FQN="(anonymous namespace)::CastOperation::CheckCStyleCast", NM="_ZN12_GLOBAL__N_113CastOperation15CheckCStyleCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation15CheckCStyleCastEv")
  //</editor-fold>
  public void CheckCStyleCast() {
    assert (!Self.getLangOpts().CPlusPlus);
    
    // C-style casts can resolve __unknown_any types.
    if (claimPlaceholder(BuiltinType.Kind.UnknownAny)) {
      SrcExpr.$assignMove(Self.checkUnknownAnyCast(new SourceRange(DestRange), new QualType(DestType), 
              SrcExpr.get(), Kind$Ref, 
              ValueKind$Ref, BasePath));
      return;
    }
    
    // C99 6.5.4p2: the cast type needs to be void or scalar and the expression
    // type needs to be scalar.
    if (DestType.$arrow().isVoidType()) {
      // We don't necessarily do lvalue-to-rvalue conversions on this.
      SrcExpr.$assignMove(Self.IgnoredValueConversions(SrcExpr.get()));
      if (SrcExpr.isInvalid()) {
        return;
      }
      
      // Cast to void allows any expr type.
      Kind = (CastKind.CK_ToVoid);
      return;
    }
    
    // Overloads are allowed with C extensions, so we need to support them.
    if ($eq_QualType$C(SrcExpr.get().getType(), Self.Context.OverloadTy.$QualType())) {
      DeclAccessPair DAP/*J*/= new DeclAccessPair();
      {
        FunctionDecl /*P*/ FD = Self.ResolveAddressOfOverloadedFunction(SrcExpr.get(), new QualType(DestType), /*Complain=*/ true, DAP);
        if ((FD != null)) {
          SrcExpr.$assign(Self.FixOverloadedFunctionReference(SrcExpr.get(), new DeclAccessPair(DAP), FD));
        } else {
          return;
        }
      }
      assert (SrcExpr.isUsable());
    }
    SrcExpr.$assignMove(Self.DefaultFunctionArrayLvalueConversion(SrcExpr.get()));
    if (SrcExpr.isInvalid()) {
      return;
    }
    QualType SrcType = SrcExpr.get().getType();
    assert (!SrcType.$arrow().isPlaceholderType());
    
    // OpenCL v1 s6.5: Casting a pointer to address space A to a pointer to
    // address space B is illegal.
    if (Self.getLangOpts().OpenCL && DestType.$arrow().isPointerType()
       && SrcType.$arrow().isPointerType()) {
      /*const*/ PointerType /*P*/ DestPtr = DestType.$arrow().getAs(PointerType.class);
      if (!DestPtr.isAddressSpaceOverlapping($Deref(SrcType.$arrow().getAs(PointerType.class)))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), 
                              diag.err_typecheck_incompatible_address_space)), 
                          SrcType), DestType), Sema.AssignmentAction.AA_Casting), 
              SrcExpr.get().getSourceRange()));
          SrcExpr.$assignMove(ExprError());
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (Self.RequireCompleteType(OpRange.getBegin(), new QualType(DestType), 
        diag.err_typecheck_cast_to_incomplete)) {
      SrcExpr.$assignMove(ExprError());
      return;
    }
    if (!DestType.$arrow().isScalarType() && !DestType.$arrow().isVectorType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ RecordType /*P*/ DestRecordTy = DestType.$arrow().getAs$RecordType();
        if ((DestRecordTy != null) && Self.Context.hasSameUnqualifiedType(new QualType(DestType), new QualType(SrcType))) {
          // GCC struct/union extension: allow cast to self.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.ext_typecheck_cast_nonscalar)), 
                  DestType), SrcExpr.get().getSourceRange()));
          Kind = (CastKind.CK_NoOp);
          return;
        }
        
        // GCC's cast to union extension.
        if ((DestRecordTy != null) && DestRecordTy.getDecl().isUnion()) {
          RecordDecl /*P*/ RD = DestRecordTy.getDecl();
          specific_decl_iterator<FieldDecl> Field/*J*/= new specific_decl_iterator<FieldDecl>(FieldDecl.class);
          specific_decl_iterator<FieldDecl> FieldEnd/*J*/= new specific_decl_iterator<FieldDecl>(FieldDecl.class);
          for (Field.$assignMove(RD.field_begin()) , FieldEnd.$assignMove(RD.field_end());
               $noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd); Field.$preInc()) {
            if (Self.Context.hasSameUnqualifiedType(Field.$arrow().getType(), new QualType(SrcType))
               && !Field.$arrow().isUnnamedBitfield()) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.ext_typecheck_cast_to_union)), 
                  SrcExpr.get().getSourceRange()));
              break;
            }
          }
          if ($eq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd)) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_typecheck_cast_to_union_no_type)), 
                    SrcType), SrcExpr.get().getSourceRange()));
            SrcExpr.$assignMove(ExprError());
            return;
          }
          Kind = (CastKind.CK_ToUnion);
          return;
        }
        
        // OpenCL v2.0 s6.13.10 - Allow casts from '0' to event_t type.
        if (Self.getLangOpts().OpenCL && DestType.$arrow().isEventT()) {
          APSInt CastInt/*J*/= new APSInt();
          if (SrcExpr.get().EvaluateAsInt(CastInt, Self.Context)) {
            if ($eq_long_APSInt$C(0, CastInt)) {
              Kind = (CastKind.CK_ZeroToOCLEvent);
              return;
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), 
                        diag.error_opencl_cast_non_zero_to_event_t)), 
                    CastInt.__toString(10)), SrcExpr.get().getSourceRange()));
            SrcExpr.$assignMove(ExprError());
            return;
          }
        }
        
        // Reject any other conversions to non-scalar types.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(OpRange.getBegin(), diag.err_typecheck_cond_expect_scalar)), 
                DestType), SrcExpr.get().getSourceRange()));
        SrcExpr.$assignMove(ExprError());
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // The type we're casting to is known to be a scalar or vector.
    
    // Require the operand to be a scalar or vector.
    if (!SrcType.$arrow().isScalarType() && !SrcType.$arrow().isVectorType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getExprLoc(), 
                    diag.err_typecheck_expect_scalar_operand)), 
                SrcType), SrcExpr.get().getSourceRange()));
        SrcExpr.$assignMove(ExprError());
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if (DestType.$arrow().isExtVectorType()) {
      SrcExpr.$assignMove(Self.CheckExtVectorCast(new SourceRange(OpRange), new QualType(DestType), SrcExpr.get(), Kind$Ref));
      return;
    }
    {
      
      /*const*/ VectorType /*P*/ DestVecTy = DestType.$arrow().getAs(VectorType.class);
      if ((DestVecTy != null)) {
        if (DestVecTy.getVectorKind() == VectorType.VectorKind.AltiVecVector
           && (SrcType.$arrow().isIntegerType() || SrcType.$arrow().isFloatingType())) {
          Kind = (CastKind.CK_VectorSplat);
          SrcExpr.$assignMove(Self.prepareVectorSplat(new QualType(DestType), SrcExpr.get()));
        } else if (Self.CheckVectorCast(new SourceRange(OpRange), new QualType(DestType), new QualType(SrcType), Kind$Ref)) {
          SrcExpr.$assignMove(ExprError());
        }
        return;
      }
    }
    if (SrcType.$arrow().isVectorType()) {
      if (Self.CheckVectorCast(new SourceRange(OpRange), new QualType(SrcType), new QualType(DestType), Kind$Ref)) {
        SrcExpr.$assignMove(ExprError());
      }
      return;
    }
    
    // The source and target types are both scalars, i.e.
    //   - arithmetic types (fundamental, enum, and complex)
    //   - all kinds of pointers
    // Note that member pointers were filtered out with C++, above.
    if (isa_ObjCSelectorExpr(SrcExpr.get())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Self.Diag(SrcExpr.get().getExprLoc(), diag.err_cast_selector_expr)));
        SrcExpr.$assignMove(ExprError());
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If either type is a pointer, the other type has to be either an
    // integer or a pointer.
    if (!DestType.$arrow().isArithmeticType()) {
      if (!SrcType.$arrow().isIntegralType(Self.Context) && SrcType.$arrow().isArithmeticType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getExprLoc(), 
                      diag.err_cast_pointer_from_non_pointer_int)), 
                  SrcType), SrcExpr.get().getSourceRange()));
          SrcExpr.$assignMove(ExprError());
          return;
        } finally {
          $c$.$destroy();
        }
      }
      checkIntToPointerCast(/* CStyle */ true, OpRange.getBegin(), SrcExpr.get(), 
          new QualType(DestType), Self);
    } else if (!SrcType.$arrow().isArithmeticType()) {
      if (!DestType.$arrow().isIntegralType(Self.Context)
         && DestType.$arrow().isArithmeticType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getLocStart(), 
                      diag.err_cast_pointer_to_non_pointer_int)), 
                  DestType), SrcExpr.get().getSourceRange()));
          SrcExpr.$assignMove(ExprError());
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (Self.getLangOpts().OpenCL && !Self.getOpenCLOptions().cl_khr_fp16) {
      if (DestType.$arrow().isHalfType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getLocStart(), diag.err_opencl_cast_to_half)), 
                  DestType), SrcExpr.get().getSourceRange()));
          SrcExpr.$assignMove(ExprError());
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // ARC imposes extra restrictions on casts.
    if (Self.getLangOpts().ObjCAutoRefCount) {
      checkObjCARCConversion(Sema.CheckedConversionKind.CCK_CStyleCast);
      if (SrcExpr.isInvalid()) {
        return;
      }
      {
        
        /*const*/ PointerType /*P*/ CastPtr = DestType.$arrow().getAs(PointerType.class);
        if ((CastPtr != null)) {
          {
            /*const*/ PointerType /*P*/ ExprPtr = SrcType.$arrow().getAs(PointerType.class);
            if ((ExprPtr != null)) {
              Qualifiers CastQuals = CastPtr.getPointeeType().getQualifiers();
              Qualifiers ExprQuals = ExprPtr.getPointeeType().getQualifiers();
              if (CastPtr.getPointeeType().$arrow().isObjCLifetimeType()
                 && ExprPtr.getPointeeType().$arrow().isObjCLifetimeType()
                 && !CastQuals.compatiblyIncludesObjCLifetime(new Qualifiers(ExprQuals))) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getLocStart(), 
                                      diag.err_typecheck_incompatible_ownership)), 
                                  SrcType), DestType), Sema.AssignmentAction.AA_Casting), 
                      SrcExpr.get().getSourceRange()));
                  return;
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        } else if (!Self.CheckObjCARCUnavailableWeakConversion(new QualType(DestType), new QualType(SrcType))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getLocStart(), 
                                diag.err_arc_convesion_of_weak_unavailable)), 
                            1), SrcType), DestType), SrcExpr.get().getSourceRange()));
            SrcExpr.$assignMove(ExprError());
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    DiagnoseCastOfObjCSEL(Self, SrcExpr, new QualType(DestType));
    DiagnoseCallingConvCast(Self, SrcExpr, new QualType(DestType), new SourceRange(OpRange));
    DiagnoseBadFunctionCast(Self, SrcExpr, new QualType(DestType));
    Kind = (Self.PrepareScalarCast(SrcExpr, new QualType(DestType)));
    if (SrcExpr.isInvalid()) {
      return;
    }
    if (Kind == CastKind.CK_BitCast) {
      checkCastAlign();
    }
    
    // -Wcast-qual
    QualType TheOffendingSrcType/*J*/= new QualType();
    QualType TheOffendingDestType/*J*/= new QualType();
    Qualifiers CastAwayQualifiers/*J*/= new Qualifiers();
    if (SrcType.$arrow().isAnyPointerType() && DestType.$arrow().isAnyPointerType()
       && CastsAwayConstness(Self, new QualType(SrcType), new QualType(DestType), true, false, 
        $AddrOf(TheOffendingSrcType), $AddrOf(TheOffendingDestType), 
        $AddrOf(CastAwayQualifiers))) {
      int qualifiers = -1;
      if (CastAwayQualifiers.hasConst() && CastAwayQualifiers.hasVolatile()) {
        qualifiers = 0;
      } else if (CastAwayQualifiers.hasConst()) {
        qualifiers = 1;
      } else if (CastAwayQualifiers.hasVolatile()) {
        qualifiers = 2;
      }
      // This is a variant of int **x; const int **y = (const int **)x;
      if (qualifiers == -1) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getLocStart(), diag.warn_cast_qual2)), 
                  SrcType), DestType));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(SrcExpr.get().getLocStart(), diag.warn_cast_qual)), 
                      TheOffendingSrcType), TheOffendingDestType), qualifiers));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  
  /// Complete an apparently-successful cast operation that yields
  /// the given expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::complete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 88,
   FQN="(anonymous namespace)::CastOperation::complete", NM="_ZN12_GLOBAL__N_113CastOperation8completeEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation8completeEPN5clang8CastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > complete(CastExpr /*P*/ castExpr) {
    // If this is an unbridged cast, wrap the result in an implicit
    // cast that yields the unbridged-cast placeholder type.
    if (IsARCUnbridgedCast) {
      castExpr = ImplicitCastExpr.Create(Self.Context, 
          Self.Context.ARCUnbridgedCastTy.$QualType(), 
          CastKind.CK_Dependent, castExpr, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
          castExpr.getValueKind());
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, castExpr);
  }

  
  // Internal convenience methods.
  
  /// Try to handle the given placeholder expression kind.  Return
  /// true if the source expression has the appropriate placeholder
  /// kind.  A placeholder can only be claimed once.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::claimPlaceholder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 105,
   FQN="(anonymous namespace)::CastOperation::claimPlaceholder", NM="_ZN12_GLOBAL__N_113CastOperation16claimPlaceholderEN5clang11BuiltinType4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation16claimPlaceholderEN5clang11BuiltinType4KindE")
  //</editor-fold>
  public boolean claimPlaceholder(BuiltinType.Kind K) {
    if (PlaceholderKind != K) {
      return false;
    }
    
    PlaceholderKind = BuiltinType.Kind.valueOf(0);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::isPlaceholder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 112,
   FQN="(anonymous namespace)::CastOperation::isPlaceholder", NM="_ZNK12_GLOBAL__N_113CastOperation13isPlaceholderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZNK12_GLOBAL__N_113CastOperation13isPlaceholderEv")
  //</editor-fold>
  public boolean isPlaceholder() /*const*/ {
    return PlaceholderKind.getValue() != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::isPlaceholder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 115,
   FQN="(anonymous namespace)::CastOperation::isPlaceholder", NM="_ZNK12_GLOBAL__N_113CastOperation13isPlaceholderEN5clang11BuiltinType4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZNK12_GLOBAL__N_113CastOperation13isPlaceholderEN5clang11BuiltinType4KindE")
  //</editor-fold>
  public boolean isPlaceholder(BuiltinType.Kind K) /*const*/ {
    return PlaceholderKind == K;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::checkCastAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 119,
   FQN="(anonymous namespace)::CastOperation::checkCastAlign", NM="_ZN12_GLOBAL__N_113CastOperation14checkCastAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation14checkCastAlignEv")
  //</editor-fold>
  public void checkCastAlign() {
    Self.CheckCastAlign(SrcExpr.get(), new QualType(DestType), new SourceRange(OpRange));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::checkObjCARCConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 123,
   FQN="(anonymous namespace)::CastOperation::checkObjCARCConversion", NM="_ZN12_GLOBAL__N_113CastOperation22checkObjCARCConversionEN5clang4Sema21CheckedConversionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation22checkObjCARCConversionEN5clang4Sema21CheckedConversionKindE")
  //</editor-fold>
  public void checkObjCARCConversion(Sema.CheckedConversionKind CCK) {
    assert Native.$bool(Self.getLangOpts().ObjCAutoRefCount);
    
    type$ref<Expr /*P*/ > src = create_type$ref(SrcExpr.get());
    if (Self.CheckObjCARCConversion(new SourceRange(OpRange), new QualType(DestType), src, CCK)
       == Sema.ARCConversionResult.ACR_unbridged) {
      IsARCUnbridgedCast = true;
    }
    SrcExpr.$assign(src.$deref());
  }

  
  /// Check for and handle non-overload placeholder expressions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::checkNonOverloadPlaceholders">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 134,
   FQN="(anonymous namespace)::CastOperation::checkNonOverloadPlaceholders", NM="_ZN12_GLOBAL__N_113CastOperation28checkNonOverloadPlaceholdersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperation28checkNonOverloadPlaceholdersEv")
  //</editor-fold>
  public void checkNonOverloadPlaceholders() {
    if (!isPlaceholder() || isPlaceholder(BuiltinType.Kind.Overload)) {
      return;
    }
    
    SrcExpr.$assignMove(Self.CheckPlaceholderExpr(SrcExpr.get()));
    if (SrcExpr.isInvalid()) {
      return;
    }
    PlaceholderKind = BuiltinType.Kind.valueOf(0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastOperation::~CastOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 50,
   FQN="(anonymous namespace)::CastOperation::~CastOperation", NM="_ZN12_GLOBAL__N_113CastOperationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN12_GLOBAL__N_113CastOperationD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    BasePath.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ref<ExprValueKind> ValueKind$Ref = new type$ref<ExprValueKind>() {
    @Override
    public ExprValueKind $deref() {
      return ValueKind;
    }
  
    @Override
    public ExprValueKind $set(ExprValueKind value) {
      ValueKind = value;
      return ValueKind;
    }
  };
  
  private final type$ref<CastKind> Kind$Ref = new type$ref<CastKind>() {
    @Override
    public CastKind $deref() {
      return Kind;
    }
  
    @Override
    public CastKind $set(CastKind value) {
      Kind = value;
      return Kind;
    }
  };


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Self=" + "[Sema]" // NOI18N
              + ", SrcExpr=" + SrcExpr // NOI18N
              + ", DestType=" + DestType // NOI18N
              + ", ResultType=" + ResultType // NOI18N
              + ", ValueKind=" + ValueKind // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", PlaceholderKind=" + PlaceholderKind // NOI18N
              + ", BasePath=" + BasePath // NOI18N
              + ", IsARCUnbridgedCast=" + IsARCUnbridgedCast // NOI18N
              + ", OpRange=" + OpRange // NOI18N
              + ", DestRange=" + DestRange; // NOI18N
  }
}
