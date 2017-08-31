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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaPseudoObjectStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


/// A PseudoOpBuilder for Objective-C array/dictionary indexing.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 305,
 FQN="(anonymous namespace)::ObjCSubscriptOpBuilder", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilderE")
//</editor-fold>
public class ObjCSubscriptOpBuilder extends /*public*/ PseudoOpBuilder implements Destructors.ClassWithDestructor {
  private ObjCSubscriptRefExpr /*P*/ RefExpr;
  private OpaqueValueExpr /*P*/ InstanceBase;
  private OpaqueValueExpr /*P*/ InstanceKey;
  private ObjCMethodDecl /*P*/ AtIndexGetter;
  private Selector AtIndexGetterSelector;
  
  private ObjCMethodDecl /*P*/ AtIndexSetter;
  private Selector AtIndexSetterSelector;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::ObjCSubscriptOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 316,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::ObjCSubscriptOpBuilder", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilderC1ERN5clang4SemaEPNS1_20ObjCSubscriptRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilderC1ERN5clang4SemaEPNS1_20ObjCSubscriptRefExprE")
  //</editor-fold>
  public ObjCSubscriptOpBuilder(final Sema /*&*/ S, ObjCSubscriptRefExpr /*P*/ refExpr) {
    // : PseudoOpBuilder(S, refExpr->getSourceRange().getBegin()), RefExpr(refExpr), InstanceBase(null), InstanceKey(null), AtIndexGetter(null), AtIndexGetterSelector(), AtIndexSetter(null), AtIndexSetterSelector() 
    //START JInit
    super(S, refExpr.getSourceRange().getBegin());
    this.RefExpr = refExpr;
    this.InstanceBase = null;
    this.InstanceKey = null;
    this.AtIndexGetter = null;
    this.AtIndexGetterSelector = new Selector();
    this.AtIndexSetter = null;
    this.AtIndexSetterSelector = new Selector();
    //END JInit
  }

  
  
  // ObjCSubscript build stuff.
  //
  
  /// objective-c subscripting-specific behavior for doing lvalue-to-rvalue 
  /// conversion.
  /// FIXME. Remove this routine if it is proven that no additional 
  /// specifity is needed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::buildRValueOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 980,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::buildRValueOperation", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder20buildRValueOperationEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder20buildRValueOperationEPN5clang4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > buildRValueOperation(Expr /*P*/ op) {
    ActionResultTTrue<Expr /*P*/ > result = super.buildRValueOperation(op);
    if (result.isInvalid()) {
      return ExprError();
    }
    return result;
  }

  
  /// objective-c subscripting-specific  behavior for doing assignments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::buildAssignmentOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 987,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::buildAssignmentOperation", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder24buildAssignmentOperationEPN5clang5ScopeENS1_14SourceLocationENS1_18BinaryOperatorKindEPNS1_4ExprES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder24buildAssignmentOperationEPN5clang5ScopeENS1_14SourceLocationENS1_18BinaryOperatorKindEPNS1_4ExprES7_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > buildAssignmentOperation(Scope /*P*/ Sc, 
                          SourceLocation opcLoc, 
                          BinaryOperatorKind opcode, 
                          Expr /*P*/ LHS, Expr /*P*/ RHS) {
    assert (BinaryOperator.isAssignmentOp(opcode));
    // There must be a method to do the Index'ed assignment.
    if (!findAtIndexSetter()) {
      return ExprError();
    }
    
    // Verify that we can do a compound assignment.
    if (opcode != BinaryOperatorKind.BO_Assign && !findAtIndexGetter()) {
      return ExprError();
    }
    
    ActionResultTTrue<Expr /*P*/ > result = super.buildAssignmentOperation(Sc, new SourceLocation(opcLoc), opcode, LHS, RHS);
    if (result.isInvalid()) {
      return ExprError();
    }
    
    // Various warnings about objc Index'ed assignments in ARC.
    if (S.getLangOpts().ObjCAutoRefCount && (InstanceBase != null)) {
      S.checkRetainCycles(InstanceBase.getSourceExpr(), RHS);
      S.checkUnsafeExprAssigns(new SourceLocation(opcLoc), LHS, RHS);
    }
    
    return result;
  }

  
  /// Capture the base object of an Objective-C Index'ed expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::rebuildAndCaptureObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1015,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::rebuildAndCaptureObject", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder23rebuildAndCaptureObjectEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder23rebuildAndCaptureObjectEPN5clang4ExprE")
  //</editor-fold>
  @Override public Expr /*P*/ rebuildAndCaptureObject(Expr /*P*/ syntacticBase)/* override*/ {
    assert (InstanceBase == null);
    
    // Capture base expression in an OVE and rebuild the syntactic
    // form to use the OVE as its base expression.
    InstanceBase = capture(RefExpr.getBaseExpr());
    InstanceKey = capture(RefExpr.getKeyExpr());
    
    syntacticBase
       = new Rebuilder(S, /*FuncArg*//*[=, this]*/ (Expr /*P*/ $Prm0, /*uint*/int Idx) -> {
              switch (Idx) {
               case 0:
                return InstanceBase;
               case 1:
                return InstanceKey;
               default:
                throw new llvm_unreachable("Unexpected index for ObjCSubscriptExpr");
              }
            }).rebuild(syntacticBase);
      
    return syntacticBase;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::findAtIndexGetter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1132,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::findAtIndexGetter", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder17findAtIndexGetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder17findAtIndexGetterEv")
  //</editor-fold>
  public boolean findAtIndexGetter() {
    if ((AtIndexGetter != null)) {
      return true;
    }
    
    Expr /*P*/ BaseExpr = RefExpr.getBaseExpr();
    QualType BaseT = BaseExpr.getType();
    
    QualType ResultType/*J*/= new QualType();
    {
      /*const*/ ObjCObjectPointerType /*P*/ PTy = BaseT.$arrow().getAs(ObjCObjectPointerType.class);
      if ((PTy != null)) {
        ResultType.$assignMove(PTy.getPointeeType());
      }
    }
    Sema.ObjCSubscriptKind Res = S.CheckSubscriptingKind(RefExpr.getKeyExpr());
    if (Res == Sema.ObjCSubscriptKind.OS_Error) {
      if (S.getLangOpts().ObjCAutoRefCount) {
        CheckKeyForObjCARCConversion(S, new QualType(ResultType), 
            create_type$ref(RefExpr.getKeyExpr()));
      }
      return false;
    }
    boolean arrayRef = (Res == Sema.ObjCSubscriptKind.OS_Array);
    if (ResultType.isNull()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(BaseExpr.getExprLoc(), diag.err_objc_subscript_base_type)), 
                BaseExpr.getType()), arrayRef));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    if (!arrayRef) {
      // dictionary subscripting.
      // - (id)objectForKeyedSubscript:(id)key;
      type$ptr<IdentifierInfo> /*P*/ KeyIdents = create_type$ptr(new IdentifierInfo /*P*/ [/*1*/] {
        $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"objectForKeyedSubscript")))
      });
      AtIndexGetterSelector.$assignMove(S.Context.Selectors.getSelector(1, KeyIdents));
    } else {
      // - (id)objectAtIndexedSubscript:(size_t)index;
      type$ptr<IdentifierInfo> /*P*/ KeyIdents = create_type$ptr(new IdentifierInfo /*P*/ [/*1*/] {
        $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"objectAtIndexedSubscript")))
      });
      
      AtIndexGetterSelector.$assignMove(S.Context.Selectors.getSelector(1, KeyIdents));
    }
    
    AtIndexGetter = S.LookupMethodInObjectType(new Selector(AtIndexGetterSelector), new QualType(ResultType), 
        true/*instance*/);
    boolean receiverIdType = (BaseT.$arrow().isObjCIdType()
       || BaseT.$arrow().isObjCQualifiedIdType());
    if (!(AtIndexGetter != null) && S.getLangOpts().DebuggerObjCLiteral) {
      AtIndexGetter = ObjCMethodDecl.Create(S.Context, new SourceLocation(), 
          new SourceLocation(), new Selector(AtIndexGetterSelector), 
          S.Context.getObjCIdType()/*ReturnType*/, 
          (TypeSourceInfo /*P*/ )null/*TypeSourceInfo */, 
          S.Context.getTranslationUnitDecl(), 
          true/*Instance*/, false/*isVariadic*/, 
          /*isPropertyAccessor=*/ false, 
          /*isImplicitlyDeclared=*/ true, /*isDefined=*/ false, 
          ObjCMethodDecl.ImplementationControl.Required, 
          false);
      ParmVarDecl /*P*/ Argument = ParmVarDecl.Create(S.Context, AtIndexGetter, 
          new SourceLocation(), new SourceLocation(), 
          arrayRef ? $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"index"))) : $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"key"))), 
          arrayRef ? S.Context.UnsignedLongTy.$QualType() : S.Context.getObjCIdType(), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          StorageClass.SC_None, 
          (Expr /*P*/ )null);
      AtIndexGetter.setMethodParams(S.Context, new ArrayRef<ParmVarDecl /*P*/ >(Argument, true), new ArrayRef<SourceLocation>(None, false));
    }
    if (!(AtIndexGetter != null)) {
      if (!receiverIdType) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(BaseExpr.getExprLoc(), diag.err_objc_subscript_method_not_found)), 
                      BaseExpr.getType()), 0), arrayRef));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      AtIndexGetter
         = S.LookupInstanceMethodInGlobalPool(new Selector(AtIndexGetterSelector), 
          RefExpr.getSourceRange(), 
          true);
    }
    if ((AtIndexGetter != null)) {
      QualType T = AtIndexGetter.parameters().$at(0).getType();
      if ((arrayRef && !T.$arrow().isIntegralOrEnumerationType())
         || (!arrayRef && !T.$arrow().isObjCObjectPointerType())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getKeyExpr().getExprLoc(), 
                  arrayRef ? diag.err_objc_subscript_index_type : diag.err_objc_subscript_key_type)), T));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AtIndexGetter.parameters().$at(0).getLocation(), 
                  diag.note_parameter_type)), T));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      QualType R = AtIndexGetter.getReturnType();
      if (!R.$arrow().isObjCObjectPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getKeyExpr().getExprLoc(), 
                      diag.err_objc_indexing_method_result_type)), R), arrayRef));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AtIndexGetter.getLocation(), diag.note_method_declared_at)), 
              AtIndexGetter.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::findAtIndexSetter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1238,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::findAtIndexSetter", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder17findAtIndexSetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder17findAtIndexSetterEv")
  //</editor-fold>
  public boolean findAtIndexSetter() {
    if ((AtIndexSetter != null)) {
      return true;
    }
    
    Expr /*P*/ BaseExpr = RefExpr.getBaseExpr();
    QualType BaseT = BaseExpr.getType();
    
    QualType ResultType/*J*/= new QualType();
    {
      /*const*/ ObjCObjectPointerType /*P*/ PTy = BaseT.$arrow().getAs(ObjCObjectPointerType.class);
      if ((PTy != null)) {
        ResultType.$assignMove(PTy.getPointeeType());
      }
    }
    
    Sema.ObjCSubscriptKind Res = S.CheckSubscriptingKind(RefExpr.getKeyExpr());
    if (Res == Sema.ObjCSubscriptKind.OS_Error) {
      if (S.getLangOpts().ObjCAutoRefCount) {
        CheckKeyForObjCARCConversion(S, new QualType(ResultType), 
                create_type$ref(RefExpr.getKeyExpr()));
      }
      return false;
    }
    boolean arrayRef = (Res == Sema.ObjCSubscriptKind.OS_Array);
    if (ResultType.isNull()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(BaseExpr.getExprLoc(), diag.err_objc_subscript_base_type)), 
                BaseExpr.getType()), arrayRef));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    if (!arrayRef) {
      // dictionary subscripting.
      // - (void)setObject:(id)object forKeyedSubscript:(id)key;
      type$ptr<IdentifierInfo> /*P*/ KeyIdents = create_type$ptr(new IdentifierInfo /*P*/ [/*2*/] {
        $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"setObject"))), 
        $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"forKeyedSubscript")))
      });
      AtIndexSetterSelector.$assignMove(S.Context.Selectors.getSelector(2, KeyIdents));
    } else {
      // - (void)setObject:(id)object atIndexedSubscript:(NSInteger)index;
      type$ptr<IdentifierInfo> /*P*/ KeyIdents = create_type$ptr(new IdentifierInfo /*P*/ [/*2*/] {
        $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"setObject"))), 
        $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"atIndexedSubscript")))
      });
      AtIndexSetterSelector.$assignMove(S.Context.Selectors.getSelector(2, KeyIdents));
    }
    AtIndexSetter = S.LookupMethodInObjectType(new Selector(AtIndexSetterSelector), new QualType(ResultType), 
        true/*instance*/);
    
    boolean receiverIdType = (BaseT.$arrow().isObjCIdType()
       || BaseT.$arrow().isObjCQualifiedIdType());
    if (!(AtIndexSetter != null) && S.getLangOpts().DebuggerObjCLiteral) {
      TypeSourceInfo /*P*/ ReturnTInfo = null;
      QualType ReturnType = S.Context.VoidTy.$QualType();
      AtIndexSetter = ObjCMethodDecl.Create(S.Context, new SourceLocation(), new SourceLocation(), new Selector(AtIndexSetterSelector), 
          new QualType(ReturnType), ReturnTInfo, S.Context.getTranslationUnitDecl(), 
          true/*Instance*/, false/*isVariadic*/, 
          /*isPropertyAccessor=*/ false, 
          /*isImplicitlyDeclared=*/ true, /*isDefined=*/ false, 
          ObjCMethodDecl.ImplementationControl.Required, false);
      SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(2, (ParmVarDecl /*P*/ )null);
      ParmVarDecl /*P*/ object = ParmVarDecl.Create(S.Context, AtIndexSetter, 
          new SourceLocation(), new SourceLocation(), 
          $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"object"))), 
          S.Context.getObjCIdType(), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          StorageClass.SC_None, 
          (Expr /*P*/ )null);
      Params.push_back(object);
      ParmVarDecl /*P*/ key = ParmVarDecl.Create(S.Context, AtIndexSetter, 
          new SourceLocation(), new SourceLocation(), 
          arrayRef ? $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"index"))) : $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"key"))), 
          arrayRef ? S.Context.UnsignedLongTy.$QualType() : S.Context.getObjCIdType(), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          StorageClass.SC_None, 
          (Expr /*P*/ )null);
      Params.push_back(key);
      AtIndexSetter.setMethodParams(S.Context, new ArrayRef<ParmVarDecl /*P*/ >(Params, true), new ArrayRef<SourceLocation>(None, false));
    }
    if (!(AtIndexSetter != null)) {
      if (!receiverIdType) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(BaseExpr.getExprLoc(), 
                          diag.err_objc_subscript_method_not_found)), 
                      BaseExpr.getType()), 1), arrayRef));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      AtIndexSetter
         = S.LookupInstanceMethodInGlobalPool(new Selector(AtIndexSetterSelector), 
          RefExpr.getSourceRange(), 
          true);
    }
    
    boolean err = false;
    if ((AtIndexSetter != null) && arrayRef) {
      QualType T = AtIndexSetter.parameters().$at(1).getType();
      if (!T.$arrow().isIntegralOrEnumerationType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getKeyExpr().getExprLoc(), 
                  diag.err_objc_subscript_index_type)), T));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AtIndexSetter.parameters().$at(1).getLocation(), 
                  diag.note_parameter_type)), T));
          err = true;
        } finally {
          $c$.$destroy();
        }
      }
      T.$assignMove(AtIndexSetter.parameters().$at(0).getType());
      if (!T.$arrow().isObjCObjectPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getBaseExpr().getExprLoc(), 
                      diag.err_objc_subscript_object_type)), T), arrayRef));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AtIndexSetter.parameters().$at(0).getLocation(), 
                  diag.note_parameter_type)), T));
          err = true;
        } finally {
          $c$.$destroy();
        }
      }
    } else if ((AtIndexSetter != null) && !arrayRef) {
      for (/*uint*/int i = 0; $less_uint(i, 2); i++) {
        QualType T = AtIndexSetter.parameters().$at(i).getType();
        if (!T.$arrow().isObjCObjectPointerType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (i == 1) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getKeyExpr().getExprLoc(), 
                      diag.err_objc_subscript_key_type)), T));
            } else {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getBaseExpr().getExprLoc(), 
                      diag.err_objc_subscript_dic_object_type)), T));
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AtIndexSetter.parameters().$at(i).getLocation(), 
                    diag.note_parameter_type)), T));
            err = true;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    return !err;
  }

  
  
  // Get the object at "Index" position in the container.
  // [BaseExpr objectAtIndexedSubscript : IndexExpr];
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::buildGet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1375,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::buildGet", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder8buildGetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder8buildGetEv")
  //</editor-fold>
  @Override public ActionResultTTrue<Expr /*P*/ > buildGet()/* override*/ {
    if (!findAtIndexGetter()) {
      return ExprError();
    }
    
    QualType receiverType = InstanceBase.getType();
    
    // Build a message-send.
    ActionResultTTrue<Expr /*P*/ > msg/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    Expr /*P*/ Index = InstanceKey;
    
    // Arguments.
    Expr /*P*/ args[/*1*/] = new Expr /*P*/ [/*1*/] {Index};
    assert Native.$bool(InstanceBase);
    if ((AtIndexGetter != null)) {
      S.DiagnoseUseOfDecl(AtIndexGetter, new SourceLocation(GenericLoc));
    }
    msg.$assignMove(S.BuildInstanceMessageImplicit(InstanceBase, new QualType(receiverType), 
            new SourceLocation(GenericLoc), 
            new Selector(AtIndexGetterSelector), AtIndexGetter, 
            new MutableArrayRef<Expr /*P*/ >(args, 1, true)));
    return msg;
  }

  
  /// Store into the container the "op" object at "Index"'ed location
  /// by building this messaging expression:
  /// - (void)setObject:(id)object atIndexedSubscript:(NSInteger)index;
  /// \param captureSetValueAsResult If true, capture the actual
  ///   value being set as the value of the property operation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::buildSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1402,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::buildSet", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder8buildSetEPN5clang4ExprENS1_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilder8buildSetEPN5clang4ExprENS1_14SourceLocationEb")
  //</editor-fold>
  @Override public ActionResultTTrue<Expr /*P*/ > buildSet(Expr /*P*/ op, SourceLocation opcLoc, 
          boolean captureSetValueAsResult)/* override*/ {
    if (!findAtIndexSetter()) {
      return ExprError();
    }
    if ((AtIndexSetter != null)) {
      S.DiagnoseUseOfDecl(AtIndexSetter, new SourceLocation(GenericLoc));
    }
    QualType receiverType = InstanceBase.getType();
    Expr /*P*/ Index = InstanceKey;
    
    // Arguments.
    Expr /*P*/ args[/*2*/] = new Expr /*P*/ [/*2*/] {op, Index};
    
    // Build a message-send.
    ActionResultTTrue<Expr /*P*/ > msg = S.BuildInstanceMessageImplicit(InstanceBase, new QualType(receiverType), 
        new SourceLocation(GenericLoc), 
        new Selector(AtIndexSetterSelector), 
        AtIndexSetter, 
        new MutableArrayRef<Expr /*P*/ >(args, 2, true));
    if (!msg.isInvalid() && captureSetValueAsResult) {
      ObjCMessageExpr /*P*/ msgExpr = cast_ObjCMessageExpr(msg.get().IgnoreImplicit());
      Expr /*P*/ arg = msgExpr.getArg(0);
      if (CanCaptureValue(arg)) {
        msgExpr.setArg(0, captureValueAsResult(arg));
      }
    }
    
    return msg;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSubscriptOpBuilder::~ObjCSubscriptOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 305,
   FQN="(anonymous namespace)::ObjCSubscriptOpBuilder::~ObjCSubscriptOpBuilder", NM="_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_122ObjCSubscriptOpBuilderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "RefExpr=" + RefExpr // NOI18N
              + ", InstanceBase=" + InstanceBase // NOI18N
              + ", InstanceKey=" + InstanceKey // NOI18N
              + ", AtIndexGetter=" + AtIndexGetter // NOI18N
              + ", AtIndexGetterSelector=" + AtIndexGetterSelector // NOI18N
              + ", AtIndexSetter=" + AtIndexSetter // NOI18N
              + ", AtIndexSetterSelector=" + AtIndexSetterSelector // NOI18N
              + super.toString(); // NOI18N
  }
}
