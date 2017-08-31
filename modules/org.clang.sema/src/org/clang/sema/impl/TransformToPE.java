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
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


// Handle the case where we conclude a expression which we speculatively
// considered to be unevaluated is actually evaluated.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformToPE">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12762,
 FQN="(anonymous namespace)::TransformToPE", NM="_ZN12_GLOBAL__N_113TransformToPEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_113TransformToPEE")
//</editor-fold>
public class TransformToPE extends /*public*/ TreeTransform<TransformToPE> implements Destructors.ClassWithDestructor {
  /*typedef TreeTransform<TransformToPE> BaseTransform*/
//  public final class BaseTransform extends TreeTransform<TransformToPE>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformToPE::TransformToPE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12766,
   FQN="(anonymous namespace)::TransformToPE::TransformToPE", NM="_ZN12_GLOBAL__N_113TransformToPEC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_113TransformToPEC1ERN5clang4SemaE")
  //</editor-fold>
  public TransformToPE(final Sema /*&*/ SemaRef) {
    // : BaseTransform(SemaRef) 
    //START JInit
    super(SemaRef);
    //END JInit
  }

  
  // Make sure we redo semantic analysis
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformToPE::AlwaysRebuild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12769,
   FQN="(anonymous namespace)::TransformToPE::AlwaysRebuild", NM="_ZN12_GLOBAL__N_113TransformToPE13AlwaysRebuildEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_113TransformToPE13AlwaysRebuildEv")
  //</editor-fold>
  public boolean AlwaysRebuild() {
    return true;
  }

  
  // Make sure we handle LabelStmts correctly.
  // FIXME: This does the right thing, but maybe we need a more general
  // fix to TreeTransform?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformToPE::TransformLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12774,
   FQN="(anonymous namespace)::TransformToPE::TransformLabelStmt", NM="_ZN12_GLOBAL__N_113TransformToPE18TransformLabelStmtEPN5clang9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_113TransformToPE18TransformLabelStmtEPN5clang9LabelStmtE")
  //</editor-fold>
  public ActionResultTTrue<Stmt /*P*/ > TransformLabelStmt(LabelStmt /*P*/ S) {
    S.getDecl().setStmt((LabelStmt /*P*/ )null);
    return super.TransformLabelStmt(S);
  }

  
  // We need to special-case DeclRefExprs referring to FieldDecls which
  // are not part of a member pointer formation; normal TreeTransforming
  // doesn't catch this case because of the way we represent them in the AST.
  // FIXME: This is a bit ugly; is it really the best way to handle this
  // case?
  //
  // Error on DeclRefExprs referring to FieldDecls.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformToPE::TransformDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12786,
   FQN="(anonymous namespace)::TransformToPE::TransformDeclRefExpr", NM="_ZN12_GLOBAL__N_113TransformToPE20TransformDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_113TransformToPE20TransformDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformDeclRefExpr(DeclRefExpr /*P*/ E) {
    if (isa_FieldDecl(E.getDecl())
       && !SemaRef.isUnevaluatedContext()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(E.getLocation(), 
                        diag.err_invalid_non_static_member_use)), 
                    E.getDecl()), E.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    
    return super.TransformDeclRefExpr(E);
  }

  
  // Exception: filter out member pointer formation
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformToPE::TransformUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12797,
   FQN="(anonymous namespace)::TransformToPE::TransformUnaryOperator", NM="_ZN12_GLOBAL__N_113TransformToPE22TransformUnaryOperatorEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_113TransformToPE22TransformUnaryOperatorEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformUnaryOperator(UnaryOperator /*P*/ E) {
    if (E.getOpcode() == UnaryOperatorKind.UO_AddrOf && E.getType().$arrow().isMemberPointerType()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    return super.TransformUnaryOperator(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformToPE::TransformLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12804,
   FQN="(anonymous namespace)::TransformToPE::TransformLambdaExpr", NM="_ZN12_GLOBAL__N_113TransformToPE19TransformLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_113TransformToPE19TransformLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformLambdaExpr(LambdaExpr /*P*/ E) {
    // Lambdas never need to be transformed.
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformToPE::~TransformToPE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12762,
   FQN="(anonymous namespace)::TransformToPE::~TransformToPE", NM="_ZN12_GLOBAL__N_113TransformToPED0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_113TransformToPED0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
