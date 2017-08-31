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

import org.clang.ast.BinaryConditionalOperator;
import org.clang.ast.BreakStmt;
import org.clang.ast.CastExpr;
import org.clang.ast.CastKind;
import org.clang.ast.ConditionalOperator;
import org.clang.ast.DeclRefExpr;
import org.clang.ast.EvaluatedExprVisitor;
import org.clang.ast.Expr;
import org.clang.ast.GotoStmt;
import org.clang.ast.OpaqueValueExpr;
import org.clang.ast.PseudoObjectExpr;
import org.clang.ast.ReturnStmt;
import org.clang.ast.Stmt;
import org.clang.ast.VarDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_VarDecl;
import static org.clang.ast.java.AstExpressionsRTTI.dyn_cast_OpaqueValueExpr;
import static org.clang.ast.java.AstExpressionsRTTI.isa_DeclRefExpr;
import static org.clang.ast.java.AstRTTI.dyn_cast_BinaryConditionalOperator;
import static org.clang.ast.java.AstRTTI.dyn_cast_ConditionalOperator;
import org.clang.sema.Sema;
import org.clank.support.Converted;
import org.llvm.adt.SmallPtrSetImpl;

// end class DeclExtractor

// DeclMatcher checks to see if the decls are used in a non-evaluated
// context.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1360,
 FQN="(anonymous namespace)::DeclMatcher", NM="_ZN12_GLOBAL__N_111DeclMatcherE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcherE")
//</editor-fold>
public class DeclMatcher implements /*public*/ EvaluatedExprVisitor<DeclMatcher> {
  private final SmallPtrSetImpl<VarDecl /*P*/ > /*&*/ Decls;
  private boolean FoundDecl;
/*public:*/
  // JAVA: typedef EvaluatedExprVisitor<DeclMatcher> Inherited
//  public final class Inherited extends EvaluatedExprVisitor<DeclMatcher>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::DeclMatcher">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1367,
   FQN="(anonymous namespace)::DeclMatcher::DeclMatcher", NM="_ZN12_GLOBAL__N_111DeclMatcherC1ERN5clang4SemaERN4llvm15SmallPtrSetImplIPNS1_7VarDeclEEEPNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcherC1ERN5clang4SemaERN4llvm15SmallPtrSetImplIPNS1_7VarDeclEEEPNS1_4StmtE")
  //</editor-fold>
  public DeclMatcher(final Sema /*&*/ S, final SmallPtrSetImpl<VarDecl /*P*/ > /*&*/ Decls, 
      Stmt /*P*/ Statement) {
    // : Inherited(S.Context), Decls(Decls), FoundDecl(false) 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(S.Context);
    this./*&*/Decls=/*&*/Decls;
    this.FoundDecl = false;
    //END JInit
    if (!(Statement != null)) {
      return;
    }
    
    Visit(Statement);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1375,
   FQN="(anonymous namespace)::DeclMatcher::VisitReturnStmt", NM="_ZN12_GLOBAL__N_111DeclMatcher15VisitReturnStmtEPN5clang10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcher15VisitReturnStmtEPN5clang10ReturnStmtE")
  //</editor-fold>
  public void VisitReturnStmt(ReturnStmt /*P*/ S) {
    FoundDecl = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1379,
   FQN="(anonymous namespace)::DeclMatcher::VisitBreakStmt", NM="_ZN12_GLOBAL__N_111DeclMatcher14VisitBreakStmtEPN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcher14VisitBreakStmtEPN5clang9BreakStmtE")
  //</editor-fold>
  public void VisitBreakStmt(BreakStmt /*P*/ S) {
    FoundDecl = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1383,
   FQN="(anonymous namespace)::DeclMatcher::VisitGotoStmt", NM="_ZN12_GLOBAL__N_111DeclMatcher13VisitGotoStmtEPN5clang8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcher13VisitGotoStmtEPN5clang8GotoStmtE")
  //</editor-fold>
  public void VisitGotoStmt(GotoStmt /*P*/ S) {
    FoundDecl = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1387,
   FQN="(anonymous namespace)::DeclMatcher::VisitCastExpr", NM="_ZN12_GLOBAL__N_111DeclMatcher13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcher13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(CastExpr /*P*/ E) {
    if (E.getCastKind() == CastKind.CK_LValueToRValue) {
      CheckLValueToRValueCast(E.getSubExpr());
    } else {
      Visit(E.getSubExpr());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::CheckLValueToRValueCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1394,
   FQN="(anonymous namespace)::DeclMatcher::CheckLValueToRValueCast", NM="_ZN12_GLOBAL__N_111DeclMatcher23CheckLValueToRValueCastEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcher23CheckLValueToRValueCastEPN5clang4ExprE")
  //</editor-fold>
  public void CheckLValueToRValueCast(Expr /*P*/ E) {
    E = E.IgnoreParenImpCasts();
    if (isa_DeclRefExpr(E)) {
      return;
    }
    {
      
      ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
      if ((CO != null)) {
        Visit(CO.getCond());
        CheckLValueToRValueCast(CO.getTrueExpr());
        CheckLValueToRValueCast(CO.getFalseExpr());
        return;
      }
    }
    {
      
      BinaryConditionalOperator /*P*/ BCO = dyn_cast_BinaryConditionalOperator(E);
      if ((BCO != null)) {
        CheckLValueToRValueCast(BCO.getOpaqueValue().getSourceExpr());
        CheckLValueToRValueCast(BCO.getFalseExpr());
        return;
      }
    }
    
    Visit(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1418,
   FQN="(anonymous namespace)::DeclMatcher::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_111DeclMatcher16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcher16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(E.getDecl());
      if ((VD != null)) {
        if ((Decls.count(VD) != 0)) {
          FoundDecl = true;
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1424,
   FQN="(anonymous namespace)::DeclMatcher::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_111DeclMatcher21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcher21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public void VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ POE) {
    // Only need to visit the semantics for POE.
    // SyntaticForm doesn't really use the Decal.
    for (Expr /*P*/ S : POE.semantics()) {
      {
        OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(S);
        if ((OVE != null)) {
          // Look past the OVE into the expression it binds.
          Visit(OVE.getSourceExpr());
        } else {
          Visit(S);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclMatcher::FoundDeclInUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1436,
   FQN="(anonymous namespace)::DeclMatcher::FoundDeclInUse", NM="_ZN12_GLOBAL__N_111DeclMatcher14FoundDeclInUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_111DeclMatcher14FoundDeclInUseEv")
  //</editor-fold>
  public boolean FoundDeclInUse() {
    return FoundDecl;
  }

  
  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "Decls=" + "[SmallPtrSetImpl$VarDecl]" // NOI18N
              + ", FoundDecl=" + FoundDecl // NOI18N
              + super.toString(); // NOI18N
  }
}
