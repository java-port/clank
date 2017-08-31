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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaPseudoObjectStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clank.support.aliases.char$ptr;


/// A PseudoOpBuilder for Objective-C \@properties.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 265,
 FQN="(anonymous namespace)::ObjCPropertyOpBuilder", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilderE")
//</editor-fold>
public class ObjCPropertyOpBuilder extends /*public*/ PseudoOpBuilder implements Destructors.ClassWithDestructor {
  private ObjCPropertyRefExpr /*P*/ RefExpr;
  private ObjCPropertyRefExpr /*P*/ SyntacticRefExpr;
  private OpaqueValueExpr /*P*/ InstanceReceiver;
  private ObjCMethodDecl /*P*/ Getter;
  
  private ObjCMethodDecl /*P*/ Setter;
  private Selector SetterSelector;
  private Selector GetterSelector;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::ObjCPropertyOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 276,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::ObjCPropertyOpBuilder", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilderC1ERN5clang4SemaEPNS1_19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilderC1ERN5clang4SemaEPNS1_19ObjCPropertyRefExprE")
  //</editor-fold>
  public ObjCPropertyOpBuilder(final Sema /*&*/ S, ObjCPropertyRefExpr /*P*/ refExpr) {
    // : PseudoOpBuilder(S, refExpr->getLocation()), RefExpr(refExpr), SyntacticRefExpr(null), InstanceReceiver(null), Getter(null), Setter(null), SetterSelector(), GetterSelector() 
    //START JInit
    super(S, refExpr.getLocation());
    this.RefExpr = refExpr;
    this.SyntacticRefExpr = null;
    this.InstanceReceiver = null;
    this.Getter = null;
    this.Setter = null;
    this.SetterSelector = new Selector();
    this.GetterSelector = new Selector();
    //END JInit
  }

  
  
  /// @property-specific behavior for doing lvalue-to-rvalue conversion.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::buildRValueOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 814,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::buildRValueOperation", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder20buildRValueOperationEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder20buildRValueOperationEPN5clang4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > buildRValueOperation(Expr /*P*/ op) {
    // Explicit properties always have getters, but implicit ones don't.
    // Check that before proceeding.
    if (RefExpr.isImplicitProperty() && !(RefExpr.getImplicitPropertyGetter() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getLocation(), diag.err_getter_not_found)), 
            RefExpr.getSourceRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    ActionResultTTrue<Expr /*P*/ > result = super.buildRValueOperation(op);
    if (result.isInvalid()) {
      return ExprError();
    }
    if (RefExpr.isExplicitProperty() && !Getter.hasRelatedResultType()) {
      S.DiagnosePropertyAccessorMismatch(RefExpr.getExplicitProperty(), 
          Getter, RefExpr.getLocation());
    }
    
    // As a special case, if the method returns 'id', try to get
    // a better type from the property.
    if (RefExpr.isExplicitProperty() && result.get().isRValue()) {
      QualType receiverType = RefExpr.getReceiverType(S.Context);
      QualType propType = RefExpr.getExplicitProperty().
          getUsageType(new QualType(receiverType));
      if (result.get().getType().$arrow().isObjCIdType()) {
        {
          /*const*/ ObjCObjectPointerType /*P*/ ptr = propType.$arrow().getAs(ObjCObjectPointerType.class);
          if ((ptr != null)) {
            if (!ptr.isObjCIdType()) {
              result.$assignMove(S.ImpCastExprToType(result.get(), new QualType(propType), CastKind.CK_BitCast));
            }
          }
        }
      }
      if (S.getLangOpts().ObjCAutoRefCount) {
        Qualifiers.ObjCLifetime LT = propType.getObjCLifetime();
        if (LT == Qualifiers.ObjCLifetime.OCL_Weak) {
          if (!S.Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, RefExpr.getLocation())) {
            S.getCurFunction().markSafeWeakUse(RefExpr);
          }
        }
      }
    }
    
    return result;
  }

  
  /// @property-specific behavior for doing assignments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::buildAssignmentOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 879,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::buildAssignmentOperation", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder24buildAssignmentOperationEPN5clang5ScopeENS1_14SourceLocationENS1_18BinaryOperatorKindEPNS1_4ExprES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder24buildAssignmentOperationEPN5clang5ScopeENS1_14SourceLocationENS1_18BinaryOperatorKindEPNS1_4ExprES7_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > buildAssignmentOperation(Scope /*P*/ Sc, 
                          SourceLocation opcLoc, 
                          BinaryOperatorKind opcode, 
                          Expr /*P*/ LHS, Expr /*P*/ RHS) {
    assert (BinaryOperator.isAssignmentOp(opcode));
    
    // If there's no setter, we have no choice but to try to assign to
    // the result of the getter.
    if (!findSetter()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        ActionResultTTrue<Expr /*P*/ > result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if (tryBuildGetOfReference(LHS, result)) {
          if (result.isInvalid()) {
            return ExprError();
          }
          return S.BuildBinOp(Sc, new SourceLocation(opcLoc), opcode, result.get(), RHS);
        }
        
        // Otherwise, it's an error.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(opcLoc), diag.err_nosetter_property_assignment)), 
                        ((/*uint*/int)((RefExpr.isImplicitProperty() ? 1 : 0)))), 
                    SetterSelector), 
                LHS.getSourceRange()), RHS.getSourceRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // If there is a setter, we definitely want to use it.
    
    // Verify that we can do a compound assignment.
    if (opcode != BinaryOperatorKind.BO_Assign && !findGetter()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(opcLoc), diag.err_nogetter_property_compound_assignment)), 
                LHS.getSourceRange()), RHS.getSourceRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    ActionResultTTrue<Expr /*P*/ > result = super.buildAssignmentOperation(Sc, new SourceLocation(opcLoc), opcode, LHS, RHS);
    if (result.isInvalid()) {
      return ExprError();
    }
    
    // Various warnings about property assignments in ARC.
    if (S.getLangOpts().ObjCAutoRefCount && (InstanceReceiver != null)) {
      S.checkRetainCycles(InstanceReceiver.getSourceExpr(), RHS);
      S.checkUnsafeExprAssigns(new SourceLocation(opcLoc), LHS, RHS);
    }
    
    return result;
  }

  
  /// @property-specific behavior for doing increments and decrements.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::buildIncDecOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 926,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::buildIncDecOperation", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder20buildIncDecOperationEPN5clang5ScopeENS1_14SourceLocationENS1_17UnaryOperatorKindEPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder20buildIncDecOperationEPN5clang5ScopeENS1_14SourceLocationENS1_17UnaryOperatorKindEPNS1_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > buildIncDecOperation(Scope /*P*/ Sc, SourceLocation opcLoc, 
                      UnaryOperatorKind opcode, 
                      Expr /*P*/ op) {
    // If there's no setter, we have no choice but to try to assign to
    // the result of the getter.
    if (!findSetter()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        ActionResultTTrue<Expr /*P*/ > result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if (tryBuildGetOfReference(op, result)) {
          if (result.isInvalid()) {
            return ExprError();
          }
          return S.BuildUnaryOp(Sc, new SourceLocation(opcLoc), opcode, result.get());
        }
        
        // Otherwise, it's an error.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(opcLoc), diag.err_nosetter_property_incdec)), 
                        ((/*uint*/int)((RefExpr.isImplicitProperty() ? 1 : 0)))), 
                    ((/*uint*/int)((UnaryOperator.isDecrementOp(opcode) ? 1 : 0)))), 
                SetterSelector), 
            op.getSourceRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // If there is a setter, we definitely want to use it.
    
    // We also need a getter.
    if (!findGetter()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert (RefExpr.isImplicitProperty());
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(opcLoc), diag.err_nogetter_property_incdec)), 
                    ((/*uint*/int)((UnaryOperator.isDecrementOp(opcode) ? 1 : 0)))), 
                GetterSelector), 
            op.getSourceRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    return super.buildIncDecOperation(Sc, new SourceLocation(opcLoc), opcode, op);
  }

  
  
  /// Try to build this as a call to a getter that returns a reference.
  ///
  /// \return true if it was possible, whether or not it actually
  ///   succeeded
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::tryBuildGetOfReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 858,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::tryBuildGetOfReference", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder22tryBuildGetOfReferenceEPN5clang4ExprERNS1_12ActionResultIS3_Lb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder22tryBuildGetOfReferenceEPN5clang4ExprERNS1_12ActionResultIS3_Lb1EEE")
  //</editor-fold>
  public boolean tryBuildGetOfReference(Expr /*P*/ op, 
                        final ActionResultTTrue<Expr /*P*/ > /*&*/ result) {
    if (!S.getLangOpts().CPlusPlus) {
      return false;
    }
    
    findGetter();
    if (!(Getter != null)) {
      // The property has no setter and no getter! This can happen if the type is
      // invalid. Error have already been reported.
      result.$assignMove(ExprError());
      return true;
    }
    
    // Only do this if the getter returns an l-value reference type.
    QualType resultType = Getter.getReturnType();
    if (!resultType.$arrow().isLValueReferenceType()) {
      return false;
    }
    
    result.$assignMove(buildRValueOperation(op));
    return true;
  }

  
  /// Try to find the most accurate setter declaration for the property
  /// reference.
  ///
  /// \return true if a setter was found, in which case Setter 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::findSetter">
  @Converted(kind = Converted.Kind.MANUAL/*PERF*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 625,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::findSetter", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder10findSetterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder10findSetterEb")
  //</editor-fold>
  public boolean findSetter() {
    return findSetter(true);
  }
  public boolean findSetter(boolean warn/*= true*/) {
    // For implicit properties, just trust the lookup we already did.
    if (RefExpr.isImplicitProperty()) {
      {
        ObjCMethodDecl /*P*/ setter = RefExpr.getImplicitPropertySetter();
        if ((setter != null)) {
          Setter = setter;
          SetterSelector.$assignMove(setter.getSelector());
          return true;
        } else {
          IdentifierInfo /*P*/ getterName = RefExpr.getImplicitPropertyGetter().getSelector().
              getIdentifierInfoForSlot(0);
          SetterSelector.$assignMove(
              SelectorTable.constructSetterSelector(S.PP.getIdentifierTable(), 
                  S.PP.getSelectorTable(), 
                  getterName)
          );
          return false;
        }
      }
    }
    
    // For explicit properties, this is more involved.
    ObjCPropertyDecl /*P*/ prop = RefExpr.getExplicitProperty();
    SetterSelector.$assignMove(prop.getSetterName());
    {
      
      // Do a normal method lookup first.
      ObjCMethodDecl /*P*/ setter = LookupMethodInReceiverType(S, new Selector(SetterSelector), RefExpr);
      if ((setter != null)) {
        if (setter.isPropertyAccessor() && warn) {
          {
            /*const*/ ObjCInterfaceDecl /*P*/ IFace = dyn_cast_ObjCInterfaceDecl(setter.getDeclContext());
            if ((IFace != null)) {
              StringRef thisPropertyName = prop.getName();
              // Try flipping the case of the first character.
              /*char*/byte front = thisPropertyName.front();
              front = isLowercase(front) ? toUppercase(front) : toLowercase(front);
              SmallString/*100*/ PropertyName = new SmallString/*100*/(new StringRef(thisPropertyName), 100);
              PropertyName.$set(0, front);
              IdentifierInfo /*P*/ AltMember = $AddrOf(S.PP.getIdentifierTable().get(PropertyName/*PERF: .$StringRef()*/));
              {
                ObjCPropertyDecl /*P*/ prop1 = IFace.FindPropertyDeclaration(AltMember, prop.getQueryKind());
                if ((prop1 != null)) {
                  if (prop != prop1 && (prop1.getSetterMethodDecl() == setter)) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getExprLoc(), diag.error_property_setter_ambiguous_use)), 
                                  prop), prop1), setter.getSelector()));
                      $c$.clean($c$.track(S.Diag(prop.getLocation(), diag.note_property_declare)));
                      $c$.clean($c$.track(S.Diag(prop1.getLocation(), diag.note_property_declare)));
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
              }
            }
          }
        }
        Setter = setter;
        return true;
      }
    }
    
    // That can fail in the somewhat crazy situation that we're
    // type-checking a message send within the @interface declaration
    // that declared the @property.  But it's not clear that that's
    // valuable to support.
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::findGetter">
  @Converted(kind = Converted.Kind.MANUAL/*PERF*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 593,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::findGetter", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder10findGetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder10findGetterEv")
  //</editor-fold>
  public boolean findGetter() {
    if ((Getter != null)) {
      return true;
    }
    
    // For implicit properties, just trust the lookup we already did.
    if (RefExpr.isImplicitProperty()) {
      if (((Getter = RefExpr.getImplicitPropertyGetter()) != null)) {
        GetterSelector.$assignMove(Getter.getSelector());
        return true;
      } else {
        // Must build the getter selector the hard way.
        ObjCMethodDecl /*P*/ setter = RefExpr.getImplicitPropertySetter();
        assert ((setter != null)) : "both setter and getter are null - cannot happen";
        IdentifierInfo /*P*/ setterName = setter.getSelector().getIdentifierInfoForSlot(0);
        // JAVA PERF:
        StringRef $substr = setterName.getName().substr(3);
        char$ptr $data = $substr.data();
        IdentifierInfo /*P*/ getterName = $AddrOf(S.Context.Idents.get($data.$array(), $data.$index(), $substr.size()));
        GetterSelector.$assignMove(
            S.PP.getSelectorTable().getNullarySelector(getterName)
        );
        return false;
      }
    }
    
    ObjCPropertyDecl /*P*/ prop = RefExpr.getExplicitProperty();
    Getter = LookupMethodInReceiverType(S, prop.getGetterName(), RefExpr);
    return (Getter != null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::DiagnoseUnsupportedPropertyUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 682,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::DiagnoseUnsupportedPropertyUse", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder30DiagnoseUnsupportedPropertyUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder30DiagnoseUnsupportedPropertyUseEv")
  //</editor-fold>
  public void DiagnoseUnsupportedPropertyUse() {
    if (S.getCurLexicalContext().isObjCContainer()
       && S.getCurLexicalContext().getDeclKind() != Decl.Kind.ObjCCategoryImpl
       && S.getCurLexicalContext().getDeclKind() != Decl.Kind.ObjCImplementation) {
      {
        ObjCPropertyDecl /*P*/ prop = RefExpr.getExplicitProperty();
        if ((prop != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(RefExpr.getLocation(), 
                diag.err_property_function_in_objc_container)));
            $c$.clean($c$.track(S.Diag(prop.getLocation(), diag.note_property_declare)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }

  
  
  /// Capture the base object of an Objective-C property expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::rebuildAndCaptureObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 695,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::rebuildAndCaptureObject", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder23rebuildAndCaptureObjectEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder23rebuildAndCaptureObjectEPN5clang4ExprE")
  //</editor-fold>
  @Override public Expr /*P*/ rebuildAndCaptureObject(Expr /*P*/ syntacticBase)/* override*/ {
    assert (InstanceReceiver == null);
    
    // If we have a base, capture it in an OVE and rebuild the syntactic
    // form to use the OVE as its base.
    if (RefExpr.isObjectReceiver()) {
      InstanceReceiver = capture(RefExpr.getBase());
      syntacticBase = new Rebuilder(S, (/*[=]*/ (Expr /*P*/ $Prm0, /*uint*/int $Prm1) -> {
                    return InstanceReceiver;
                  })).rebuild(syntacticBase);
    }
    {
      
      ObjCPropertyRefExpr /*P*/ refE = dyn_cast_ObjCPropertyRefExpr(syntacticBase.IgnoreParens());
      if ((refE != null)) {
        SyntacticRefExpr = refE;
      }
    }
    
    return syntacticBase;
  }

  
  /// Load from an Objective-C property reference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::buildGet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 715,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::buildGet", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder8buildGetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder8buildGetEv")
  //</editor-fold>
  @Override public ActionResultTTrue<Expr /*P*/ > buildGet()/* override*/ {
    findGetter();
    if (!(Getter != null)) {
      DiagnoseUnsupportedPropertyUse();
      return ExprError();
    }
    if ((SyntacticRefExpr != null)) {
      SyntacticRefExpr.setIsMessagingGetter();
    }
    
    QualType receiverType = RefExpr.getReceiverType(S.Context);
    if (!Getter.isImplicit()) {
      S.DiagnoseUseOfDecl(Getter, new SourceLocation(GenericLoc), (/*const*/ ObjCInterfaceDecl /*P*/ )null, true);
    }
    // Build a message-send.
    ActionResultTTrue<Expr /*P*/ > msg/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ((Getter.isInstanceMethod() && !RefExpr.isClassReceiver())
       || RefExpr.isObjectReceiver()) {
      assert ((InstanceReceiver != null) || RefExpr.isSuperReceiver());
      msg.$assignMove(S.BuildInstanceMessageImplicit(InstanceReceiver, new QualType(receiverType), 
              new SourceLocation(GenericLoc), Getter.getSelector(), 
              Getter, new MutableArrayRef<Expr /*P*/ >(None)));
    } else {
      msg.$assignMove(S.BuildClassMessageImplicit(new QualType(receiverType), RefExpr.isSuperReceiver(), 
              new SourceLocation(GenericLoc), Getter.getSelector(), 
              Getter, new MutableArrayRef<Expr /*P*/ >(None)));
    }
    return msg;
  }

  
  /// Store to an Objective-C property reference.
  ///
  /// \param captureSetValueAsResult If true, capture the actual
  ///   value being set as the value of the property operation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::buildSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 748,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::buildSet", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder8buildSetEPN5clang4ExprENS1_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder8buildSetEPN5clang4ExprENS1_14SourceLocationEb")
  //</editor-fold>
  @Override public ActionResultTTrue<Expr /*P*/ > buildSet(Expr /*P*/ op, SourceLocation opcLoc, 
          boolean captureSetValueAsResult)/* override*/ {
    if (!findSetter(false)) {
      DiagnoseUnsupportedPropertyUse();
      return ExprError();
    }
    if ((SyntacticRefExpr != null)) {
      SyntacticRefExpr.setIsMessagingSetter();
    }
    
    QualType receiverType = RefExpr.getReceiverType(S.Context);
    
    // Use assignment constraints when possible; they give us better
    // diagnostics.  "When possible" basically means anything except a
    // C++ class type.
    if (!S.getLangOpts().CPlusPlus || !op.getType().$arrow().isRecordType()) {
      QualType paramType = (Setter.param_begin().$star()).getType().
          substObjCMemberType(new QualType(receiverType), 
          Setter.getDeclContext(), 
          ObjCSubstitutionContext.Parameter);
      if (!S.getLangOpts().CPlusPlus || !paramType.$arrow().isRecordType()) {
        ActionResultTTrue<Expr /*P*/ > opResult = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, op);
        Sema.AssignConvertType assignResult = S.CheckSingleAssignmentConstraints(new QualType(paramType), opResult);
        if (S.DiagnoseAssignmentResult(assignResult, new SourceLocation(opcLoc), new QualType(paramType), 
            op.getType(), opResult.get(), 
            Sema.AssignmentAction.AA_Assigning)) {
          return ExprError();
        }
        
        op = opResult.get();
        assert ((op != null)) : "successful assignment left argument invalid?";
      }
    }
    
    // Arguments.
    Expr /*P*/ args[/*1*/] = new Expr /*P*/ [/*1*/] {op};
    
    // Build a message-send.
    ActionResultTTrue<Expr /*P*/ > msg/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (!Setter.isImplicit()) {
      S.DiagnoseUseOfDecl(Setter, new SourceLocation(GenericLoc), (/*const*/ ObjCInterfaceDecl /*P*/ )null, true);
    }
    if ((Setter.isInstanceMethod() && !RefExpr.isClassReceiver())
       || RefExpr.isObjectReceiver()) {
      msg.$assignMove(S.BuildInstanceMessageImplicit(InstanceReceiver, new QualType(receiverType), 
              new SourceLocation(GenericLoc), new Selector(SetterSelector), Setter, 
              new MutableArrayRef<Expr /*P*/ >(args, 1, true)));
    } else {
      msg.$assignMove(S.BuildClassMessageImplicit(new QualType(receiverType), RefExpr.isSuperReceiver(), 
              new SourceLocation(GenericLoc), 
              new Selector(SetterSelector), Setter, 
              new MutableArrayRef<Expr /*P*/ >(args, 1, true)));
    }
    if (!msg.isInvalid() && captureSetValueAsResult) {
      ObjCMessageExpr /*P*/ msgExpr = cast_ObjCMessageExpr(msg.get().IgnoreImplicit());
      Expr /*P*/ arg = msgExpr.getArg(0);
      if (CanCaptureValue(arg)) {
        msgExpr.setArg(0, captureValueAsResult(arg));
      }
    }
    
    return msg;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::complete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 963,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::complete", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder8completeEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilder8completeEPN5clang4ExprE")
  //</editor-fold>
  @Override public ActionResultTTrue<Expr /*P*/ > complete(Expr /*P*/ SyntacticForm)/* override*/ {
    if (S.getLangOpts().ObjCAutoRefCount && isWeakProperty()
       && !S.Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, 
        SyntacticForm.getLocStart())) {
      S.recordUseOfEvaluatedWeak(SyntacticRefExpr, 
          SyntacticRefExpr.isMessagingGetter());
    }
    
    return super.complete(SyntacticForm);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::isWeakProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 576,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::isWeakProperty", NM="_ZNK12_GLOBAL__N_121ObjCPropertyOpBuilder14isWeakPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZNK12_GLOBAL__N_121ObjCPropertyOpBuilder14isWeakPropertyEv")
  //</editor-fold>
  public boolean isWeakProperty() /*const*/ {
    QualType T/*J*/= new QualType();
    if (RefExpr.isExplicitProperty()) {
      /*const*/ ObjCPropertyDecl /*P*/ Prop = RefExpr.getExplicitProperty();
      if (((Prop.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)) {
        return true;
      }
      
      T.$assignMove(Prop.getType());
    } else if ((Getter != null)) {
      T.$assignMove(Getter.getReturnType());
    } else {
      return false;
    }
    
    return T.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCPropertyOpBuilder::~ObjCPropertyOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 265,
   FQN="(anonymous namespace)::ObjCPropertyOpBuilder::~ObjCPropertyOpBuilder", NM="_ZN12_GLOBAL__N_121ObjCPropertyOpBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_121ObjCPropertyOpBuilderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "RefExpr=" + RefExpr // NOI18N
              + ", SyntacticRefExpr=" + SyntacticRefExpr // NOI18N
              + ", InstanceReceiver=" + InstanceReceiver // NOI18N
              + ", Getter=" + Getter // NOI18N
              + ", Setter=" + Setter // NOI18N
              + ", SetterSelector=" + SetterSelector // NOI18N
              + ", GetterSelector=" + GetterSelector // NOI18N
              + super.toString(); // NOI18N
  }
}
