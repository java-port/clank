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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 43,
 FQN="(anonymous namespace)::ASTMaker", NM="_ZN12_GLOBAL__N_18ASTMakerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMakerE")
//</editor-fold>
public class ASTMaker {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::ASTMaker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 45,
   FQN="(anonymous namespace)::ASTMaker::ASTMaker", NM="_ZN12_GLOBAL__N_18ASTMakerC1ERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMakerC1ERN5clang10ASTContextE")
  //</editor-fold>
  public ASTMaker(final ASTContext /*&*/ C) {
    // : C(C) 
    //START JInit
    this./*&*/C=/*&*/C;
    //END JInit
  }

  
  /// Create a new BinaryOperator representing a simple assignment.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 86,
   FQN="(anonymous namespace)::ASTMaker::makeAssignment", NM="_ZN12_GLOBAL__N_18ASTMaker14makeAssignmentEPKN5clang4ExprES4_NS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker14makeAssignmentEPKN5clang4ExprES4_NS1_8QualTypeE")
  //</editor-fold>
  public BinaryOperator /*P*/ makeAssignment(/*const*/ Expr /*P*/ LHS, /*const*/ Expr /*P*/ RHS, 
                QualType Ty) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new BinaryOperator(((/*const_cast*/Expr /*P*/ )(LHS)), ((/*const_cast*/Expr /*P*/ )(RHS)), 
                BinaryOperatorKind.BO_Assign, new QualType(Ty), ExprValueKind.VK_RValue, 
                ExprObjectKind.OK_Ordinary, new SourceLocation(), false);
     });
  }

  
  /// Create a new BinaryOperator representing a comparison.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeComparison">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 93,
   FQN="(anonymous namespace)::ASTMaker::makeComparison", NM="_ZN12_GLOBAL__N_18ASTMaker14makeComparisonEPKN5clang4ExprES4_NS1_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker14makeComparisonEPKN5clang4ExprES4_NS1_18BinaryOperatorKindE")
  //</editor-fold>
  public BinaryOperator /*P*/ makeComparison(/*const*/ Expr /*P*/ LHS, /*const*/ Expr /*P*/ RHS, 
                BinaryOperatorKind Op) {
    assert (BinaryOperator.isLogicalOp(Op) || BinaryOperator.isComparisonOp(Op));
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new BinaryOperator(((/*const_cast*/Expr /*P*/ )(LHS)), 
                ((/*const_cast*/Expr /*P*/ )(RHS)), 
                Op, 
                C.getLogicalOperationType(), 
                ExprValueKind.VK_RValue, 
                ExprObjectKind.OK_Ordinary, new SourceLocation(), false);
     });
  }

  
  /// Create a new compound stmt using the provided statements.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeCompound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 105,
   FQN="(anonymous namespace)::ASTMaker::makeCompound", NM="_ZN12_GLOBAL__N_18ASTMaker12makeCompoundEN4llvm8ArrayRefIPN5clang4StmtEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker12makeCompoundEN4llvm8ArrayRefIPN5clang4StmtEEE")
  //</editor-fold>
  public CompoundStmt /*P*/ makeCompound(ArrayRef<Stmt /*P*/ > Stmts) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new CompoundStmt(C, new ArrayRef<Stmt /*P*/ >(Stmts), new SourceLocation(), new SourceLocation());
     });
  }

  
  /// Create a new DeclRefExpr for the referenced variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 109,
   FQN="(anonymous namespace)::ASTMaker::makeDeclRefExpr", NM="_ZN12_GLOBAL__N_18ASTMaker15makeDeclRefExprEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker15makeDeclRefExprEPKN5clang7VarDeclE")
  //</editor-fold>
  public DeclRefExpr /*P*/ makeDeclRefExpr(/*const*/ VarDecl /*P*/ D) {
    DeclRefExpr /*P*/ DR = DeclRefExpr.Create(/* Ctx = */ C, 
        /* QualifierLoc = */ new NestedNameSpecifierLoc(), 
        /* TemplateKWLoc = */ new SourceLocation(), 
        /* D = */ ((/*const_cast*/VarDecl /*P*/ )(D)), 
        /* RefersToEnclosingVariableOrCapture = */ false, 
        /* NameLoc = */ new SourceLocation(), 
        /* T = */ D.getType(), 
        /* VK = */ ExprValueKind.VK_LValue);
    return DR;
  }

  
  /// Create a new UnaryOperator representing a dereference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeDereference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 122,
   FQN="(anonymous namespace)::ASTMaker::makeDereference", NM="_ZN12_GLOBAL__N_18ASTMaker15makeDereferenceEPKN5clang4ExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker15makeDereferenceEPKN5clang4ExprENS1_8QualTypeE")
  //</editor-fold>
  public UnaryOperator /*P*/ makeDereference(/*const*/ Expr /*P*/ Arg, QualType Ty) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new UnaryOperator(((/*const_cast*/Expr /*P*/ )(Arg)), UnaryOperatorKind.UO_Deref, new QualType(Ty), 
                ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation());
     });
  }

  
  /// Create an implicit cast for an integer conversion.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeIntegralCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 132,
   FQN="(anonymous namespace)::ASTMaker::makeIntegralCast", NM="_ZN12_GLOBAL__N_18ASTMaker16makeIntegralCastEPKN5clang4ExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker16makeIntegralCastEPKN5clang4ExprENS1_8QualTypeE")
  //</editor-fold>
  public Expr /*P*/ makeIntegralCast(/*const*/ Expr /*P*/ Arg, QualType Ty) {
    if (QualType.$eq_QualType$C(Arg.getType(), Ty)) {
      return ((/*const_cast*/Expr /*P*/ )(Arg));
    }
    
    return ImplicitCastExpr.Create(C, new QualType(Ty), CastKind.CK_IntegralCast, 
        ((/*const_cast*/Expr /*P*/ )(Arg)), (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue);
  }

  
  /// Create an implicit cast to a builtin boolean type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeIntegralCastToBoolean">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 140,
   FQN="(anonymous namespace)::ASTMaker::makeIntegralCastToBoolean", NM="_ZN12_GLOBAL__N_18ASTMaker25makeIntegralCastToBooleanEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker25makeIntegralCastToBooleanEPKN5clang4ExprE")
  //</editor-fold>
  public ImplicitCastExpr /*P*/ makeIntegralCastToBoolean(/*const*/ Expr /*P*/ Arg) {
    return ImplicitCastExpr.Create(C, C.BoolTy.$QualType(), CastKind.CK_IntegralToBoolean, 
        ((/*const_cast*/Expr /*P*/ )(Arg)), (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue);
  }

  
  // Create an implicit cast for lvalue-to-rvaluate conversions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeLvalueToRvalue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 127,
   FQN="(anonymous namespace)::ASTMaker::makeLvalueToRvalue", NM="_ZN12_GLOBAL__N_18ASTMaker18makeLvalueToRvalueEPKN5clang4ExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker18makeLvalueToRvalueEPKN5clang4ExprENS1_8QualTypeE")
  //</editor-fold>
  public ImplicitCastExpr /*P*/ makeLvalueToRvalue(/*const*/ Expr /*P*/ Arg, QualType Ty) {
    return ImplicitCastExpr.Create(C, new QualType(Ty), CastKind.CK_LValueToRValue, 
        ((/*const_cast*/Expr /*P*/ )(Arg)), (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue);
  }

  
  /// Create an Objective-C bool literal.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeObjCBool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 145,
   FQN="(anonymous namespace)::ASTMaker::makeObjCBool", NM="_ZN12_GLOBAL__N_18ASTMaker12makeObjCBoolEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker12makeObjCBoolEb")
  //</editor-fold>
  public ObjCBoolLiteralExpr /*P*/ makeObjCBool(boolean Val) {
    QualType Ty = (C.getBOOLDecl() != null) ? C.getBOOLType() : C.ObjCBuiltinBoolTy.$QualType();
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new ObjCBoolLiteralExpr(Val, new QualType(Ty), new SourceLocation());
     });
  }

  
  /// Create an Objective-C ivar reference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeObjCIvarRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 150,
   FQN="(anonymous namespace)::ASTMaker::makeObjCIvarRef", NM="_ZN12_GLOBAL__N_18ASTMaker15makeObjCIvarRefEPKN5clang4ExprEPKNS1_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker15makeObjCIvarRefEPKN5clang4ExprEPKNS1_12ObjCIvarDeclE")
  //</editor-fold>
  public ObjCIvarRefExpr /*P*/ makeObjCIvarRef(/*const*/ Expr /*P*/ Base, 
                 /*const*/ ObjCIvarDecl /*P*/ IVar) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new ObjCIvarRefExpr(((/*const_cast*/ObjCIvarDecl /*P*/ )(IVar)), 
                IVar.getType(), new SourceLocation(), 
                new SourceLocation(), ((/*const_cast*/Expr /*P*/ )(Base)), 
                /*arrow=*/ true, /*free=*/ false);
     });
  }

  
  /// Create a Return statement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTMaker::makeReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 159,
   FQN="(anonymous namespace)::ASTMaker::makeReturn", NM="_ZN12_GLOBAL__N_18ASTMaker10makeReturnEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN12_GLOBAL__N_18ASTMaker10makeReturnEPKN5clang4ExprE")
  //</editor-fold>
  public ReturnStmt /*P*/ makeReturn(/*const*/ Expr /*P*/ RetVal) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new ReturnStmt(new SourceLocation(), ((/*const_cast*/Expr /*P*/ )(RetVal)), 
                (/*const*/ VarDecl /*P*/ )null);
     });
  }

/*private:*/
  private final ASTContext /*&*/ C;
  
  @Override public String toString() {
    return "" + "C=" + "[ASTContext]"; // NOI18N
  }
}
