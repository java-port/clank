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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 336,
 FQN="(anonymous namespace)::MSPropertyOpBuilder", NM="_ZN12_GLOBAL__N_119MSPropertyOpBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_119MSPropertyOpBuilderE")
//</editor-fold>
public class MSPropertyOpBuilder extends /*public*/ PseudoOpBuilder implements Destructors.ClassWithDestructor {
  private MSPropertyRefExpr /*P*/ RefExpr;
  private OpaqueValueExpr /*P*/ InstanceBase;
  private SmallVector<Expr /*P*/ > CallArgs;
  
  
  //===----------------------------------------------------------------------===//
  //  MSVC __declspec(property) references
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder::getBaseMSProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1436,
   FQN="(anonymous namespace)::MSPropertyOpBuilder::getBaseMSProperty", NM="_ZN12_GLOBAL__N_119MSPropertyOpBuilder17getBaseMSPropertyEPN5clang23MSPropertySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_119MSPropertyOpBuilder17getBaseMSPropertyEPN5clang23MSPropertySubscriptExprE")
  //</editor-fold>
  private MSPropertyRefExpr /*P*/ getBaseMSProperty(MSPropertySubscriptExpr /*P*/ E) {
    CallArgs.insert(CallArgs.begin(), E.getIdx());
    Expr /*P*/ Base = E.getBase().IgnoreParens();
    {
      MSPropertySubscriptExpr /*P*/ MSPropSubscript;
      while (((/*P*/ MSPropSubscript = dyn_cast_MSPropertySubscriptExpr(Base)) != null)) {
        CallArgs.insert(CallArgs.begin(), MSPropSubscript.getIdx());
        Base = MSPropSubscript.getBase().IgnoreParens();
      }
    }
    return cast_MSPropertyRefExpr(Base);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder::MSPropertyOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 344,
   FQN="(anonymous namespace)::MSPropertyOpBuilder::MSPropertyOpBuilder", NM="_ZN12_GLOBAL__N_119MSPropertyOpBuilderC1ERN5clang4SemaEPNS1_17MSPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_119MSPropertyOpBuilderC1ERN5clang4SemaEPNS1_17MSPropertyRefExprE")
  //</editor-fold>
  public MSPropertyOpBuilder(final Sema /*&*/ S, MSPropertyRefExpr /*P*/ refExpr) {
    // : PseudoOpBuilder(S, refExpr->getSourceRange().getBegin()), RefExpr(refExpr), InstanceBase(null), CallArgs() 
    //START JInit
    super(S, refExpr.getSourceRange().getBegin());
    this.RefExpr = refExpr;
    this.InstanceBase = null;
    this.CallArgs = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder::MSPropertyOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 347,
   FQN="(anonymous namespace)::MSPropertyOpBuilder::MSPropertyOpBuilder", NM="_ZN12_GLOBAL__N_119MSPropertyOpBuilderC1ERN5clang4SemaEPNS1_23MSPropertySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_119MSPropertyOpBuilderC1ERN5clang4SemaEPNS1_23MSPropertySubscriptExprE")
  //</editor-fold>
  public MSPropertyOpBuilder(final Sema /*&*/ S, MSPropertySubscriptExpr /*P*/ refExpr) {
    // : PseudoOpBuilder(S, refExpr->getSourceRange().getBegin()), InstanceBase(null), CallArgs() 
    //START JInit
    super(S, refExpr.getSourceRange().getBegin());
    this.InstanceBase = null;
    this.CallArgs = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    //END JInit
    RefExpr = getBaseMSProperty(refExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder::rebuildAndCaptureObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1447,
   FQN="(anonymous namespace)::MSPropertyOpBuilder::rebuildAndCaptureObject", NM="_ZN12_GLOBAL__N_119MSPropertyOpBuilder23rebuildAndCaptureObjectEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_119MSPropertyOpBuilder23rebuildAndCaptureObjectEPN5clang4ExprE")
  //</editor-fold>
  @Override public Expr /*P*/ rebuildAndCaptureObject(Expr /*P*/ syntacticBase)/* override*/ {
    InstanceBase = capture(RefExpr.getBaseExpr());
    std.for_each(CallArgs.begin(), CallArgs.end(), 
        /*[this]*/ (final type$ptr<Expr /*P*/ /*&*/> Arg) -> {
              Arg.$set(capture(Arg.$star()));
            });
    syntacticBase = new Rebuilder(S, /*FuncArg*//*[=, this]*/ (Expr /*P*/ $Prm0, /*uint*/int Idx) -> {
              switch (Idx) {
               case 0:
                return InstanceBase;
               default:
                assert ($lesseq_uint(Idx, CallArgs.size()));
                return CallArgs.$at(Idx - 1);
              }
            }).rebuild(syntacticBase);
    
    return syntacticBase;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder::buildGet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1464,
   FQN="(anonymous namespace)::MSPropertyOpBuilder::buildGet", NM="_ZN12_GLOBAL__N_119MSPropertyOpBuilder8buildGetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_119MSPropertyOpBuilder8buildGetEv")
  //</editor-fold>
  @Override public ActionResultTTrue<Expr /*P*/ > buildGet()/* override*/ {
    CXXScopeSpec SS = null;
    try {
      if (!RefExpr.getPropertyDecl().hasGetter()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getMemberLoc(), diag.err_no_accessor_for_property)), 
                  0/* getter */), RefExpr.getPropertyDecl()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      UnqualifiedId GetterName/*J*/= new UnqualifiedId();
      IdentifierInfo /*P*/ II = RefExpr.getPropertyDecl().getGetterId();
      GetterName.setIdentifier(II, RefExpr.getMemberLoc());
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(RefExpr.getQualifierLoc());
      ActionResultTTrue<Expr /*P*/ > GetterExpr = S.ActOnMemberAccessExpr(S.getCurScope(), InstanceBase, new SourceLocation(), 
          RefExpr.isArrow() ? tok.TokenKind.arrow : tok.TokenKind.period, SS, 
          new SourceLocation(), GetterName, (Decl /*P*/ )null);
      if (GetterExpr.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getMemberLoc(), 
                      diag.error_cannot_find_suitable_accessor)), 0/* getter */), 
              RefExpr.getPropertyDecl()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      return S.ActOnCallExpr(S.getCurScope(), GetterExpr.get(), 
          RefExpr.getSourceRange().getBegin(), new MutableArrayRef<Expr /*P*/ >(CallArgs, true), 
          RefExpr.getSourceRange().getEnd());
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder::buildSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1492,
   FQN="(anonymous namespace)::MSPropertyOpBuilder::buildSet", NM="_ZN12_GLOBAL__N_119MSPropertyOpBuilder8buildSetEPN5clang4ExprENS1_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_119MSPropertyOpBuilder8buildSetEPN5clang4ExprENS1_14SourceLocationEb")
  //</editor-fold>
  @Override public ActionResultTTrue<Expr /*P*/ > buildSet(Expr /*P*/ op, SourceLocation sl, 
          boolean captureSetValueAsResult)/* override*/ {
    CXXScopeSpec SS = null;
    try {
      if (!RefExpr.getPropertyDecl().hasSetter()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getMemberLoc(), diag.err_no_accessor_for_property)), 
                  1/* setter */), RefExpr.getPropertyDecl()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      UnqualifiedId SetterName/*J*/= new UnqualifiedId();
      IdentifierInfo /*P*/ II = RefExpr.getPropertyDecl().getSetterId();
      SetterName.setIdentifier(II, RefExpr.getMemberLoc());
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(RefExpr.getQualifierLoc());
      ActionResultTTrue<Expr /*P*/ > SetterExpr = S.ActOnMemberAccessExpr(S.getCurScope(), InstanceBase, new SourceLocation(), 
          RefExpr.isArrow() ? tok.TokenKind.arrow : tok.TokenKind.period, SS, 
          new SourceLocation(), SetterName, (Decl /*P*/ )null);
      if (SetterExpr.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RefExpr.getMemberLoc(), 
                      diag.error_cannot_find_suitable_accessor)), 1/* setter */), 
              RefExpr.getPropertyDecl()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      SmallVector<Expr /*P*/ > ArgExprs/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      ArgExprs.append_T(CallArgs.begin(), CallArgs.end());
      ArgExprs.push_back(op);
      return S.ActOnCallExpr(S.getCurScope(), SetterExpr.get(), 
          RefExpr.getSourceRange().getBegin(), new MutableArrayRef<Expr /*P*/ >(ArgExprs, true), 
          op.getSourceRange().getEnd());
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder::captureSetValueAsResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 356,
   FQN="(anonymous namespace)::MSPropertyOpBuilder::captureSetValueAsResult", NM="_ZNK12_GLOBAL__N_119MSPropertyOpBuilder23captureSetValueAsResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZNK12_GLOBAL__N_119MSPropertyOpBuilder23captureSetValueAsResultEv")
  //</editor-fold>
  @Override public boolean captureSetValueAsResult() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSPropertyOpBuilder::~MSPropertyOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 336,
   FQN="(anonymous namespace)::MSPropertyOpBuilder::~MSPropertyOpBuilder", NM="_ZN12_GLOBAL__N_119MSPropertyOpBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_119MSPropertyOpBuilderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CallArgs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "RefExpr=" + RefExpr // NOI18N
              + ", InstanceBase=" + InstanceBase // NOI18N
              + ", CallArgs=" + CallArgs // NOI18N
              + super.toString(); // NOI18N
  }
}
