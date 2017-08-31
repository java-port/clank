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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;

/// CheckDefaultArgumentVisitor - C++ [dcl.fct.default] Traverses
/// the default argument of a parameter to determine whether it
/// contains any ill-formed subexpressions. For example, this will
/// diagnose the use of local variables or parameters within the
/// default argument expression.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckDefaultArgumentVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 57,
 FQN="(anonymous namespace)::CheckDefaultArgumentVisitor", NM="_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitorE")
//</editor-fold>
public class CheckDefaultArgumentVisitor implements /*public*/ StmtVisitorBool<CheckDefaultArgumentVisitor> {
  private Expr /*P*/ DefaultArg;
  private Sema /*P*/ S;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckDefaultArgumentVisitor::CheckDefaultArgumentVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 63,
   FQN="(anonymous namespace)::CheckDefaultArgumentVisitor::CheckDefaultArgumentVisitor", NM="_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitorC1EPN5clang4ExprEPNS1_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitorC1EPN5clang4ExprEPNS1_4SemaE")
  //</editor-fold>
  public CheckDefaultArgumentVisitor(Expr /*P*/ defarg, Sema /*P*/ s) {
    // : StmtVisitor<CheckDefaultArgumentVisitor, bool>(), DefaultArg(defarg), S(s) 
    //START JInit
    $StmtVisitor();
    this.DefaultArg = defarg;
    this.S = s;
    //END JInit
  }

  
  
  /// VisitExpr - Visit all of the children of this expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 74,
   FQN="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitExpr", NM="_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public boolean VisitExpr(Expr /*P*/ Node) {
    boolean IsInvalid = false;
    for (Stmt /*P*/ SubStmt : Node.children())  {
      IsInvalid |= Visit(SubStmt);
    }
    return IsInvalid;
  }

  
  /// VisitDeclRefExpr - Visit a reference to a declaration, to
  /// determine whether this declaration can be used in the default
  /// argument expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 84,
   FQN="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public boolean VisitDeclRefExpr(DeclRefExpr /*P*/ DRE) {
    NamedDecl /*P*/ Decl = DRE.getDecl();
    {
      ParmVarDecl /*P*/ Param = dyn_cast(ParmVarDecl.class, Decl);
      if ((Param != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [dcl.fct.default]p9
          //   Default arguments are evaluated each time the function is
          //   called. The order of evaluation of function arguments is
          //   unspecified. Consequently, parameters of a function shall not
          //   be used in default argument expressions, even if they are not
          //   evaluated. Parameters of a function declared before a default
          //   argument expression are in scope and can hide namespace and
          //   class member names.
          return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DRE.getLocStart(), 
                      diag.err_param_default_argument_references_param)), 
                  Param.getDeclName()), DefaultArg.getSourceRange()).$bool());
        } finally {
          $c$.$destroy();
        }
      } else {
        VarDecl /*P*/ VDecl = dyn_cast(VarDecl.class, Decl);
        if ((VDecl != null)) {
          // C++ [dcl.fct.default]p7
          //   Local variables shall not be used in default argument
          //   expressions.
          if (VDecl.isLocalVarDecl()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DRE.getLocStart(), 
                          diag.err_param_default_argument_references_local)), 
                      VDecl.getDeclName()), DefaultArg.getSourceRange()).$bool());
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    return false;
  }

  
  /// VisitCXXThisExpr - Visit a C++ "this" expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 112,
   FQN="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitCXXThisExpr", NM="_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor16VisitCXXThisExprEPN5clang11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor16VisitCXXThisExprEPN5clang11CXXThisExprE")
  //</editor-fold>
  public boolean VisitCXXThisExpr(CXXThisExpr /*P*/ ThisE) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C++ [dcl.fct.default]p8:
      //   The keyword this shall not be used in a default argument of a
      //   member function.
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ThisE.getLocStart(), 
              diag.err_param_default_argument_references_this)), 
          ThisE.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 138,
   FQN="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitLambdaExpr", NM="_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor15VisitLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor15VisitLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public boolean VisitLambdaExpr(LambdaExpr /*P*/ Lambda) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C++11 [expr.lambda.prim]p13:
      //   A lambda-expression appearing in a default argument shall not
      //   implicitly or explicitly capture any entity.
      if ($eq_ptr(Lambda.capture_begin(), Lambda.capture_end())) {
        return false;
      }
      
      return $c$.clean($c$.track(S.Diag(Lambda.getLocStart(), 
          diag.err_lambda_capture_default_arg)).$bool());
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 121,
   FQN="(anonymous namespace)::CheckDefaultArgumentVisitor::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_127CheckDefaultArgumentVisitor21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public boolean VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ POE) {
    boolean Invalid = false;
    for (type$ptr<Expr /*P*/ /*const*/ /*P*/ > i = $tryClone(POE.semantics_begin()), /*P*/ /*const*/ /*P*/ e = $tryClone(POE.semantics_end()); $noteq_ptr(i, e); i.$preInc()) {
      Expr /*P*/ E = i.$star();
      {
        
        // Look through bindings.
        OpaqueValueExpr /*P*/ OVE = dyn_cast(OpaqueValueExpr.class, E);
        if ((OVE != null)) {
          E = OVE.getSourceExpr();
          assert ((E != null)) : "pseudo-object binding without source expression?";
        }
      }
      
      Invalid |= Visit(E);
    }
    return Invalid;
  }

  
  @Override public String toString() {
    return "" + "DefaultArg=" + DefaultArg // NOI18N
              + ", S=" + "[Sema]" // NOI18N
              + super.toString(); // NOI18N
  }
}
