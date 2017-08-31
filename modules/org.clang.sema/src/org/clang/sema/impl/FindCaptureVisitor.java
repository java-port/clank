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

import org.clang.ast.ASTContext;
import org.clang.ast.BinaryOperator;
import org.clang.ast.BinaryOperatorKind;
import org.clang.ast.BlockExpr;
import org.clang.ast.DeclRefExpr;
import org.clang.ast.EvaluatedExprVisitor;
import org.clang.ast.Expr;
import org.clang.ast.ObjCIvarRefExpr;
import org.clang.ast.OpaqueValueExpr;
import org.clang.ast.VarDecl;
import org.clank.support.*;
import static org.clang.ast.java.AstExpressionsRTTI.dyn_cast_or_null_DeclRefExpr;
import org.llvm.adt.APSInt;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindCaptureVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9877,
 FQN="(anonymous namespace)::FindCaptureVisitor", NM="_ZN12_GLOBAL__N_118FindCaptureVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118FindCaptureVisitorE")
//</editor-fold>
public class/*struct*/ FindCaptureVisitor implements EvaluatedExprVisitor<FindCaptureVisitor> {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindCaptureVisitor::FindCaptureVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9878,
   FQN="(anonymous namespace)::FindCaptureVisitor::FindCaptureVisitor", NM="_ZN12_GLOBAL__N_118FindCaptureVisitorC1ERN5clang10ASTContextEPNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118FindCaptureVisitorC1ERN5clang10ASTContextEPNS1_7VarDeclE")
  //</editor-fold>
  public FindCaptureVisitor(final ASTContext /*&*/ Context, VarDecl /*P*/ variable) {
    // : EvaluatedExprVisitor<FindCaptureVisitor>(Context), Context(Context), Variable(variable), Capturer(null), VarWillBeReased(false) 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(Context);
    this./*&*/Context=/*&*/Context;
    this.Variable = variable;
    this.Capturer = null;
    this.VarWillBeReased = false;
    //END JInit
  }

  public final ASTContext /*&*/ Context;
  public VarDecl /*P*/ Variable;
  public Expr /*P*/ Capturer;
  public boolean VarWillBeReased;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindCaptureVisitor::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9887,
   FQN="(anonymous namespace)::FindCaptureVisitor::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_118FindCaptureVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118FindCaptureVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ ref) {
    if (ref.getDecl() == Variable && !(Capturer != null)) {
      Capturer = ref;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindCaptureVisitor::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9892,
   FQN="(anonymous namespace)::FindCaptureVisitor::VisitObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_118FindCaptureVisitor20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118FindCaptureVisitor20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public void VisitObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ ref) {
    if ((Capturer != null)) {
      return;
    }
    Visit(ref.getBase());
    if ((Capturer != null) && ref.isFreeIvar()) {
      Capturer = ref;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindCaptureVisitor::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9899,
   FQN="(anonymous namespace)::FindCaptureVisitor::VisitBlockExpr", NM="_ZN12_GLOBAL__N_118FindCaptureVisitor14VisitBlockExprEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118FindCaptureVisitor14VisitBlockExprEPN5clang9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(BlockExpr /*P*/ block) {
    // Look inside nested blocks 
    if (block.getBlockDecl().capturesVariable(Variable)) {
      Visit(block.getBlockDecl().getBody());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindCaptureVisitor::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9905,
   FQN="(anonymous namespace)::FindCaptureVisitor::VisitOpaqueValueExpr", NM="_ZN12_GLOBAL__N_118FindCaptureVisitor20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118FindCaptureVisitor20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE")
  //</editor-fold>
  public void VisitOpaqueValueExpr(OpaqueValueExpr /*P*/ OVE) {
    if ((Capturer != null)) {
      return;
    }
    if ((OVE.getSourceExpr() != null)) {
      Visit(OVE.getSourceExpr());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindCaptureVisitor::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9910,
   FQN="(anonymous namespace)::FindCaptureVisitor::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_118FindCaptureVisitor19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118FindCaptureVisitor19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ BinOp) {
    if (!(Variable != null) || VarWillBeReased || BinOp.getOpcode() != BinaryOperatorKind.BO_Assign) {
      return;
    }
    Expr /*P*/ LHS = BinOp.getLHS();
    {
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_or_null_DeclRefExpr(LHS);
      if ((DRE != null)) {
        if (DRE.getDecl$Const() != Variable) {
          return;
        }
        {
          Expr /*P*/ RHS = BinOp.getRHS();
          if ((RHS != null)) {
            RHS = RHS.IgnoreParenCasts();
            APSInt Value/*J*/= new APSInt();
            VarWillBeReased
               = ((RHS != null) && RHS.isIntegerConstantExpr(Value, Context) && Value.$eq(0));
          }
        }
      }
    }
  }

  
  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", Variable=" + "[VarDecl]" // NOI18N
              + ", Capturer=" + "[Expr]" // NOI18N
              + ", VarWillBeReased=" + VarWillBeReased // NOI18N
              + super.toString(); // NOI18N
  }
}
