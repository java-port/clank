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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// A visitor for rebuilding a call to an __unknown_any expression
/// to have an appropriate type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14437,
 FQN="(anonymous namespace)::RebuildUnknownAnyFunction", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunctionE")
//</editor-fold>
public class/*struct*/ RebuildUnknownAnyFunction implements StmtVisitor<RebuildUnknownAnyFunction, ActionResultTTrue<Expr /*P*/ > > {
  
  public final Sema /*&*/ S;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::RebuildUnknownAnyFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14442,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::RebuildUnknownAnyFunction", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunctionC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunctionC1ERN5clang4SemaE")
  //</editor-fold>
  public RebuildUnknownAnyFunction(final Sema /*&*/ S) {
    // : StmtVisitor<RebuildUnknownAnyFunction, ExprResult>(), S(S) 
    //START JInit
    $StmtVisitor();
    this./*&*/S=/*&*/S;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14444,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::VisitStmt", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitStmt(Stmt /*P*/ S) {
    throw new llvm_unreachable("unexpected statement!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14448,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::VisitExpr", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitExpr(Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_unsupported_unknown_any_call)), 
          E.getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Rebuild an expression which simply semantically wraps another
  /// expression which it shares the type and value kind of.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::rebuildSugarExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14456,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::rebuildSugarExpr", NM="Tpl__ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16rebuildSugarExprEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=Tpl__ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16rebuildSugarExprEPT_")
  //</editor-fold>
  public </*class*/ T> ActionResultTTrue<Expr /*P*/ > rebuildSugarExpr(T /*P*/ E) {
    throw new UnsupportedOperationException("Specialization must be used. Or generate new specialization");
  }

  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14456,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::rebuildSugarExpr", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16rebuildSugarExprIN5clang9ParenExprEEENS2_12ActionResultIPNS2_4ExprELb1EEEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16rebuildSugarExprIN5clang9ParenExprEEENS2_12ActionResultIPNS2_4ExprELb1EEEPT_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > rebuildSugarExpr(ParenExpr /*P*/ E) {
    ActionResultTTrue<Expr /*P*/ > SubResult = Visit(E.getSubExpr());
    if (SubResult.isInvalid()) {
      return ExprError();
    }
    
    Expr /*P*/ SubExpr = SubResult.get();
    E.setSubExpr(SubExpr);
    E.setType(SubExpr.getType());
    E.setValueKind(SubExpr.getValueKind());
    assert Native.$bool(Native.$eq(E.getObjectKind(), ExprObjectKind.OK_Ordinary));
    return new ActionResultTTrue<Expr>(JD$T.INSTANCE , E);
  }

  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14456,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::rebuildSugarExpr", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16rebuildSugarExprIN5clang13UnaryOperatorEEENS2_12ActionResultIPNS2_4ExprELb1EEEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16rebuildSugarExprIN5clang13UnaryOperatorEEENS2_12ActionResultIPNS2_4ExprELb1EEEPT_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > rebuildSugarExpr(UnaryOperator /*P*/ E) {
    ActionResultTTrue<Expr /*P*/ > SubResult = Visit(E.getSubExpr());
    if (SubResult.isInvalid()) {
      return ExprError();
    }
  
    Expr /*P*/ SubExpr = SubResult.get();
    E.setSubExpr(SubExpr);
    E.setType(SubExpr.getType());
    E.setValueKind(SubExpr.getValueKind());
    assert Native.$bool(Native.$eq(E.getObjectKind(), ExprObjectKind.OK_Ordinary));
    return new ActionResultTTrue<Expr>(JD$T.INSTANCE , E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14468,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::VisitParenExpr", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction14VisitParenExprEPN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction14VisitParenExprEPN5clang9ParenExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitParenExpr(ParenExpr /*P*/ E) {
    return rebuildSugarExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14472,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::VisitUnaryExtension", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction19VisitUnaryExtensionEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction19VisitUnaryExtensionEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitUnaryExtension(UnaryOperator /*P*/ E) {
    return rebuildSugarExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::VisitUnaryAddrOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14476,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::VisitUnaryAddrOf", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16VisitUnaryAddrOfEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16VisitUnaryAddrOfEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitUnaryAddrOf(UnaryOperator /*P*/ E) {
    ActionResultTTrue<Expr /*P*/ > SubResult = Visit(E.getSubExpr());
    if (SubResult.isInvalid()) {
      return ExprError();
    }
    
    Expr /*P*/ SubExpr = SubResult.get();
    E.setSubExpr(SubExpr);
    E.setType(S.Context.getPointerType(SubExpr.getType()));
    assert (E.getValueKind() == ExprValueKind.VK_RValue);
    assert (E.getObjectKind() == ExprObjectKind.OK_Ordinary);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::resolveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14488,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::resolveDecl", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction11resolveDeclEPN5clang4ExprEPNS1_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction11resolveDeclEPN5clang4ExprEPNS1_9ValueDeclE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > resolveDecl(Expr /*P*/ E, ValueDecl /*P*/ VD) {
    if (!isa_FunctionDecl(VD)) {
      return VisitExpr(E);
    }
    
    E.setType(VD.getType());
    assert (E.getValueKind() == ExprValueKind.VK_RValue);
    if (S.getLangOpts().CPlusPlus
       && !(isa_CXXMethodDecl(VD)
       && cast_CXXMethodDecl(VD).isInstance())) {
      E.setValueKind(ExprValueKind.VK_LValue);
    }
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14502,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::VisitMemberExpr", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitMemberExpr(MemberExpr /*P*/ E) {
    return resolveDecl(E, E.getMemberDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyFunction::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14506,
   FQN="(anonymous namespace)::RebuildUnknownAnyFunction::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_125RebuildUnknownAnyFunction16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    return resolveDecl(E, E.getDecl());
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + super.toString(); // NOI18N
  }
}
