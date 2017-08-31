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
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.sema.impl.SemaPseudoObjectStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaPseudoObject">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaOverload ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN5clang4Sema21CheckSubscriptingKindEPNS_4ExprE;_ZN5clang4Sema21recreateSyntacticFormEPNS_16PseudoObjectExprE;_ZN5clang4Sema23checkPseudoObjectIncDecEPNS_5ScopeENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE;_ZN5clang4Sema23checkPseudoObjectRValueEPNS_4ExprE;_ZN5clang4Sema27checkPseudoObjectAssignmentEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES6_; -static-type=Sema_SemaPseudoObject -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaPseudoObject extends Sema_SemaOverload {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// CheckSubscriptingKind - This routine decide what type 
/// of indexing represented by "FromE" is being done.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSubscriptingKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1040,
 FQN="clang::Sema::CheckSubscriptingKind", NM="_ZN5clang4Sema21CheckSubscriptingKindEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN5clang4Sema21CheckSubscriptingKindEPNS_4ExprE")
//</editor-fold>
public final Sema.ObjCSubscriptKind CheckSubscriptingKind(Expr /*P*/ FromE) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // If the expression already has integral or enumeration type, we're golden.
    QualType T = FromE.getType();
    if (T.$arrow().isIntegralOrEnumerationType()) {
      return ObjCSubscriptKind.OS_Array;
    }
    
    // If we don't have a class type in C++, there's no way we can get an
    // expression of integral or enumeration type.
    /*const*/ RecordType /*P*/ RecordTy = T.$arrow().getAs$RecordType();
    if (!(RecordTy != null)
       && (T.$arrow().isObjCObjectPointerType() || T.$arrow().isVoidPointerType())) {
      // All other scalar cases are assumed to be dictionary indexing which
      // caller handles, with diagnostics if needed.
      return ObjCSubscriptKind.OS_Dictionary;
    }
    if (!$this().getLangOpts().CPlusPlus
       || !(RecordTy != null) || RecordTy.isIncompleteType()) {
      // No indexing can be done. Issue diagnostics and quit.
      /*const*/ Expr /*P*/ IndexExpr = FromE.IgnoreParenImpCasts();
      if (isa_StringLiteral(IndexExpr)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FromE.getExprLoc(), diag.err_objc_subscript_pointer)), 
                T), FixItHint.CreateInsertion(FromE.getExprLoc(), new StringRef(/*KEEP_STR*/$AT))));
      } else {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FromE.getExprLoc(), diag.err_objc_subscript_type_conversion)), 
            T));
      }
      return ObjCSubscriptKind.OS_Error;
    }
    
    // We must have a complete class type.
    if ($this().RequireCompleteType$T(FromE.getExprLoc(), new QualType(T), 
        diag.err_objc_index_incomplete_class_type, FromE)) {
      return ObjCSubscriptKind.OS_Error;
    }
    
    // Look for a conversion to an integral, enumeration type, or
    // objective-C pointer type.
    int NoIntegrals = 0;
    int NoObjCIdPointers = 0;
    SmallVector<CXXConversionDecl /*P*/ > ConversionDecls/*J*/= new SmallVector<CXXConversionDecl /*P*/ >(4, (CXXConversionDecl /*P*/ )null);
    
    for (NamedDecl /*P*/ D : cast_CXXRecordDecl(RecordTy.getDecl()).
        getVisibleConversionFunctions()) {
      {
        CXXConversionDecl /*P*/ Conversion = dyn_cast_CXXConversionDecl(D.getUnderlyingDecl());
        if ((Conversion != null)) {
          QualType CT = Conversion.getConversionType().getNonReferenceType();
          if (CT.$arrow().isIntegralOrEnumerationType()) {
            ++NoIntegrals;
            ConversionDecls.push_back(Conversion);
          } else if (CT.$arrow().isObjCIdType() || CT.$arrow().isBlockPointerType()) {
            ++NoObjCIdPointers;
            ConversionDecls.push_back(Conversion);
          }
        }
      }
    }
    if (NoIntegrals == 1 && NoObjCIdPointers == 0) {
      return ObjCSubscriptKind.OS_Array;
    }
    if (NoIntegrals == 0 && NoObjCIdPointers == 1) {
      return ObjCSubscriptKind.OS_Dictionary;
    }
    if (NoIntegrals == 0 && NoObjCIdPointers == 0) {
      // No conversion function was found. Issue diagnostic and return.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FromE.getExprLoc(), diag.err_objc_subscript_type_conversion)), 
          FromE.getType()));
      return ObjCSubscriptKind.OS_Error;
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FromE.getExprLoc(), diag.err_objc_multiple_subscript_type_conversion)), 
        FromE.getType()));
    for (/*uint*/int i = 0; $less_uint(i, ConversionDecls.size()); i++)  {
      $c$.clean($c$.track($this().Diag(ConversionDecls.$at(i).getLocation(), diag.not_conv_function_declared_at)));
    }
    
    return ObjCSubscriptKind.OS_Error;
  } finally {
    $c$.$destroy();
  }
}


/// Check an increment or decrement of a pseudo-object expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkPseudoObjectIncDec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1553,
 FQN="clang::Sema::checkPseudoObjectIncDec", NM="_ZN5clang4Sema23checkPseudoObjectIncDecEPNS_5ScopeENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN5clang4Sema23checkPseudoObjectIncDecEPNS_5ScopeENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > checkPseudoObjectIncDec(Scope /*P*/ Sc, SourceLocation opcLoc, 
                       UnaryOperatorKind opcode, Expr /*P*/ op) {
  // Do nothing if the operand is dependent.
  if (op.isTypeDependent()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new UnaryOperator(op, opcode, $this().Context.DependentTy.$QualType(), 
            ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, new SourceLocation(opcLoc))));
  }
  assert (UnaryOperator.isIncrementDecrementOp(opcode));
  Expr /*P*/ opaqueRef = op.IgnoreParens();
  {
    ObjCPropertyRefExpr /*P*/ refExpr = dyn_cast_ObjCPropertyRefExpr(opaqueRef);
    if ((refExpr != null)) {
      ObjCPropertyOpBuilder builder = null;
      try {
        builder/*J*/= new ObjCPropertyOpBuilder(/*Deref*/$this(), refExpr);
        return builder.buildIncDecOperation(Sc, new SourceLocation(opcLoc), opcode, op);
      } finally {
        if (builder != null) { builder.$destroy(); }
      }
    } else if (isa_ObjCSubscriptRefExpr(opaqueRef)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(opcLoc), diag.err_illegal_container_subscripting_op)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    } else {
      MSPropertyRefExpr /*P*/ refExpr$1 = dyn_cast_MSPropertyRefExpr(opaqueRef);
      if ((refExpr$1 != null)) {
        MSPropertyOpBuilder builder = null;
        try {
          builder/*J*/= new MSPropertyOpBuilder(/*Deref*/$this(), refExpr$1);
          return builder.buildIncDecOperation(Sc, new SourceLocation(opcLoc), opcode, op);
        } finally {
          if (builder != null) { builder.$destroy(); }
        }
      } else {
        MSPropertySubscriptExpr /*P*/ RefExpr = dyn_cast_MSPropertySubscriptExpr(opaqueRef);
        if ((RefExpr != null)) {
          MSPropertyOpBuilder Builder = null;
          try {
            Builder/*J*/= new MSPropertyOpBuilder(/*Deref*/$this(), RefExpr);
            return Builder.buildIncDecOperation(Sc, new SourceLocation(opcLoc), opcode, op);
          } finally {
            if (Builder != null) { Builder.$destroy(); }
          }
        } else {
          throw new llvm_unreachable("unknown pseudo-object kind!");
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkPseudoObjectAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1582,
 FQN="clang::Sema::checkPseudoObjectAssignment", NM="_ZN5clang4Sema27checkPseudoObjectAssignmentEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN5clang4Sema27checkPseudoObjectAssignmentEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES6_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > checkPseudoObjectAssignment(Scope /*P*/ S, SourceLocation opcLoc, 
                           BinaryOperatorKind opcode, 
                           Expr /*P*/ LHS, Expr /*P*/ RHS) {
  // Do nothing if either argument is dependent.
  if (LHS.isTypeDependent() || RHS.isTypeDependent()) {
    final Expr /*P*/ L$RHS = RHS;
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new BinaryOperator(LHS, L$RHS, opcode, $this().Context.DependentTy.$QualType(), 
            ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, new SourceLocation(opcLoc), false)));
  }
  
  // Filter out non-overload placeholder types in the RHS.
  if (RHS.getType().$arrow().isNonOverloadPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(RHS);
    if (result.isInvalid()) {
      return ExprError();
    }
    RHS = result.get();
  }
  
  Expr /*P*/ opaqueRef = LHS.IgnoreParens();
  {
    ObjCPropertyRefExpr /*P*/ refExpr = dyn_cast_ObjCPropertyRefExpr(opaqueRef);
    if ((refExpr != null)) {
      ObjCPropertyOpBuilder builder = null;
      try {
        builder/*J*/= new ObjCPropertyOpBuilder(/*Deref*/$this(), refExpr);
        return builder.buildAssignmentOperation(S, new SourceLocation(opcLoc), opcode, LHS, RHS);
      } finally {
        if (builder != null) { builder.$destroy(); }
      }
    } else {
      ObjCSubscriptRefExpr /*P*/ refExpr$1 = dyn_cast_ObjCSubscriptRefExpr(opaqueRef);
      if ((refExpr$1 != null)) {
        ObjCSubscriptOpBuilder builder = null;
        try {
          builder/*J*/= new ObjCSubscriptOpBuilder(/*Deref*/$this(), refExpr$1);
          return builder.buildAssignmentOperation(S, new SourceLocation(opcLoc), opcode, LHS, RHS);
        } finally {
          if (builder != null) { builder.$destroy(); }
        }
      } else {
        MSPropertyRefExpr /*P*/ refExpr$2 = dyn_cast_MSPropertyRefExpr(opaqueRef);
        if ((refExpr$2 != null)) {
          MSPropertyOpBuilder builder = null;
          try {
            builder/*J*/= new MSPropertyOpBuilder(/*Deref*/$this(), refExpr$2);
            return builder.buildAssignmentOperation(S, new SourceLocation(opcLoc), opcode, LHS, RHS);
          } finally {
            if (builder != null) { builder.$destroy(); }
          }
        } else {
          MSPropertySubscriptExpr /*P*/ RefExpr = dyn_cast_MSPropertySubscriptExpr(opaqueRef);
          if ((RefExpr != null)) {
            MSPropertyOpBuilder Builder = null;
            try {
              Builder/*J*/= new MSPropertyOpBuilder(/*Deref*/$this(), RefExpr);
              return Builder.buildAssignmentOperation(S, new SourceLocation(opcLoc), opcode, LHS, RHS);
            } finally {
              if (Builder != null) { Builder.$destroy(); }
            }
          } else {
            throw new llvm_unreachable("unknown pseudo-object kind!");
          }
        }
      }
    }
  }
}


//===----------------------------------------------------------------------===//
//  General Sema routines.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkPseudoObjectRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1528,
 FQN="clang::Sema::checkPseudoObjectRValue", NM="_ZN5clang4Sema23checkPseudoObjectRValueEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN5clang4Sema23checkPseudoObjectRValueEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > checkPseudoObjectRValue(Expr /*P*/ E) {
  Expr /*P*/ opaqueRef = E.IgnoreParens();
  {
    ObjCPropertyRefExpr /*P*/ refExpr = dyn_cast_ObjCPropertyRefExpr(opaqueRef);
    if ((refExpr != null)) {
      ObjCPropertyOpBuilder builder = null;
      try {
        builder/*J*/= new ObjCPropertyOpBuilder(/*Deref*/$this(), refExpr);
        return builder.buildRValueOperation(E);
      } finally {
        if (builder != null) { builder.$destroy(); }
      }
    } else {
      ObjCSubscriptRefExpr /*P*/ refExpr$1 = dyn_cast_ObjCSubscriptRefExpr(opaqueRef);
      if ((refExpr$1 != null)) {
        ObjCSubscriptOpBuilder builder = null;
        try {
          builder/*J*/= new ObjCSubscriptOpBuilder(/*Deref*/$this(), refExpr$1);
          return builder.buildRValueOperation(E);
        } finally {
          if (builder != null) { builder.$destroy(); }
        }
      } else {
        MSPropertyRefExpr /*P*/ refExpr$2 = dyn_cast_MSPropertyRefExpr(opaqueRef);
        if ((refExpr$2 != null)) {
          MSPropertyOpBuilder builder = null;
          try {
            builder/*J*/= new MSPropertyOpBuilder(/*Deref*/$this(), refExpr$2);
            return builder.buildRValueOperation(E);
          } finally {
            if (builder != null) { builder.$destroy(); }
          }
        } else {
          MSPropertySubscriptExpr /*P*/ RefExpr = dyn_cast_MSPropertySubscriptExpr(opaqueRef);
          if ((RefExpr != null)) {
            MSPropertyOpBuilder Builder = null;
            try {
              Builder/*J*/= new MSPropertyOpBuilder(/*Deref*/$this(), RefExpr);
              return Builder.buildRValueOperation(E);
            } finally {
              if (Builder != null) { Builder.$destroy(); }
            }
          } else {
            throw new llvm_unreachable("unknown pseudo-object kind!");
          }
        }
      }
    }
  }
}


/// Given a pseudo-object expression, recreate what it looks like
/// syntactically without the attendant OpaqueValueExprs.
///
/// This is a hack which should be removed when TreeTransform is
/// capable of rebuilding a tree without stripping implicit
/// operations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::recreateSyntacticForm">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1636,
 FQN="clang::Sema::recreateSyntacticForm", NM="_ZN5clang4Sema21recreateSyntacticFormEPNS_16PseudoObjectExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN5clang4Sema21recreateSyntacticFormEPNS_16PseudoObjectExprE")
//</editor-fold>
public final Expr /*P*/ recreateSyntacticForm(PseudoObjectExpr /*P*/ E) {
  Expr /*P*/ syntax = E.getSyntacticForm();
  {
    UnaryOperator /*P*/ uop = dyn_cast_UnaryOperator(syntax);
    if ((uop != null)) {
      Expr /*P*/ op = stripOpaqueValuesFromPseudoObjectRef(/*Deref*/$this(), uop.getSubExpr());
      return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new UnaryOperator(op, uop.getOpcode(), uop.getType(), 
          uop.getValueKind(), uop.getObjectKind(), 
          uop.getOperatorLoc()));
    } else {
      CompoundAssignOperator /*P*/ cop = dyn_cast_CompoundAssignOperator(syntax);
      if ((cop != null)) {
        Expr /*P*/ lhs = stripOpaqueValuesFromPseudoObjectRef(/*Deref*/$this(), cop.getLHS());
        Expr /*P*/ rhs = cast_OpaqueValueExpr(cop.getRHS()).getSourceExpr();
        return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CompoundAssignOperator(lhs, rhs, cop.getOpcode(), 
            cop.getType(), 
            cop.getValueKind(), 
            cop.getObjectKind(), 
            cop.getComputationLHSType(), 
            cop.getComputationResultType(), 
            cop.getOperatorLoc(), false));
      } else {
        BinaryOperator /*P*/ bop = dyn_cast_BinaryOperator(syntax);
        if ((bop != null)) {
          Expr /*P*/ lhs = stripOpaqueValuesFromPseudoObjectRef(/*Deref*/$this(), bop.getLHS());
          Expr /*P*/ rhs = cast_OpaqueValueExpr(bop.getRHS()).getSourceExpr();
          return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new BinaryOperator(lhs, rhs, bop.getOpcode(), 
              bop.getType(), bop.getValueKind(), 
              bop.getObjectKind(), 
              bop.getOperatorLoc(), false));
        } else {
          assert (syntax.hasPlaceholderType(BuiltinType.Kind.PseudoObject));
          return stripOpaqueValuesFromPseudoObjectRef(/*Deref*/$this(), syntax);
        }
      }
    }
  }
}

} // END OF class Sema_SemaPseudoObject
