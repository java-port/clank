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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import static org.clang.analysis.impl.CFGStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CFGStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZL10print_elemRN4llvm11raw_ostreamERN12_GLOBAL__N_117StmtPrinterHelperERKN5clang10CFGElementE;_ZL11GraphHelper;_ZL11print_blockRN4llvm11raw_ostreamEPKN5clang3CFGERKNS2_8CFGBlockERN12_GLOBAL__N_117StmtPrinterHelperEbb;_ZN12_GLOBAL__N_113bothKnownTrueENS_9TryResultES0_;_ZN12_GLOBAL__N_131tryTransformToIntOrEnumConstantEPKN5clang4ExprE;_ZN12_GLOBAL__N_1L13shouldAddCaseERbPKN5clang4Expr10EvalResultEPKNS1_8CaseStmtERNS1_10ASTContextE;_ZN12_GLOBAL__N_1L22areExprTypesCompatibleEPKN5clang4ExprES3_;_ZN12_GLOBAL__N_1L26tryNormalizeBinaryOperatorEPKN5clang14BinaryOperatorE;_ZN12_GLOBAL__N_1L29getReferenceInitTemporaryTypeERN5clang10ASTContextEPKNS0_4ExprE;_ZN12_GLOBAL__N_1L6FindVAEPKN5clang4TypeE;_ZN12_GLOBAL__N_1L8CanThrowEPN5clang4ExprERNS0_10ASTContextE;_ZN12_GLOBAL__N_1L9GetEndLocEPN5clang4DeclE; -static-type=CFGStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class CFGStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetEndLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 35,
 FQN="(anonymous namespace)::GetEndLoc", NM="_ZN12_GLOBAL__N_1L9GetEndLocEPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_1L9GetEndLocEPN5clang4DeclE")
//</editor-fold>
public static SourceLocation GetEndLoc(Decl /*P*/ D) {
  {
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      {
        Expr /*P*/ Ex = VD.getInit();
        if ((Ex != null)) {
          return Ex.getSourceRange().getEnd();
        }
      }
    }
  }
  return D.getLocation();
}


/// Helper for tryNormalizeBinaryOperator. Attempts to extract an IntegerLiteral
/// or EnumConstantDecl from the given Expr. If it fails, returns nullptr.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::tryTransformToIntOrEnumConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 44,
 FQN="(anonymous namespace)::tryTransformToIntOrEnumConstant", NM="_ZN12_GLOBAL__N_131tryTransformToIntOrEnumConstantEPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_131tryTransformToIntOrEnumConstantEPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ tryTransformToIntOrEnumConstant(/*const*/ Expr /*P*/ E) {
  E = E.IgnoreParens$Const();
  if (isa_IntegerLiteral(E)) {
    return E;
  }
  {
    /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(E.IgnoreParenImpCasts$Const());
    if ((DR != null)) {
      return isa_EnumConstantDecl(DR.getDecl$Const()) ? DR : null;
    }
  }
  return null;
}


/// Tries to interpret a binary operator into `Decl Op Expr` form, if Expr is
/// an integer literal or an enum constant.
///
/// If this fails, at least one of the returned DeclRefExpr or Expr will be
/// null.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::tryNormalizeBinaryOperator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 58,
 FQN="(anonymous namespace)::tryNormalizeBinaryOperator", NM="_ZN12_GLOBAL__N_1L26tryNormalizeBinaryOperatorEPKN5clang14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_1L26tryNormalizeBinaryOperatorEPKN5clang14BinaryOperatorE")
//</editor-fold>
public static std.tuple/*<const DeclRefExpr, BinaryOperatorKind, const Expr>*/ tryNormalizeBinaryOperator(/*const*/ BinaryOperator /*P*/ B) {
  BinaryOperatorKind Op = B.getOpcode();
  
  /*const*/ Expr /*P*/ MaybeDecl = B.getLHS();
  /*const*/ Expr /*P*/ Constant = tryTransformToIntOrEnumConstant(B.getRHS());
  // Expr looked like `0 == Foo` instead of `Foo == 0`
  if (Constant == null) {
    // Flip the operator
    if (Op == BinaryOperatorKind.BO_GT) {
      Op = BinaryOperatorKind.BO_LT;
    } else if (Op == BinaryOperatorKind.BO_GE) {
      Op = BinaryOperatorKind.BO_LE;
    } else if (Op == BinaryOperatorKind.BO_LT) {
      Op = BinaryOperatorKind.BO_GT;
    } else if (Op == BinaryOperatorKind.BO_LE) {
      Op = BinaryOperatorKind.BO_GE;
    }
    
    MaybeDecl = B.getRHS();
    Constant = tryTransformToIntOrEnumConstant(B.getLHS());
  }
  
  /*const*/ DeclRefExpr /*P*/ D = dyn_cast_DeclRefExpr(MaybeDecl.IgnoreParenImpCasts$Const());
  return std.make_tuple_Ptrs(D, Op, Constant);
}


/// For an expression `x == Foo && x == Bar`, this determines whether the
/// `Foo` and `Bar` are either of the same enumeration type, or both integer
/// literals.
///
/// It's an error to pass this arguments that are not either IntegerLiterals
/// or DeclRefExprs (that have decls of type EnumConstantDecl)
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::areExprTypesCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 90,
 FQN="(anonymous namespace)::areExprTypesCompatible", NM="_ZN12_GLOBAL__N_1L22areExprTypesCompatibleEPKN5clang4ExprES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_1L22areExprTypesCompatibleEPKN5clang4ExprES3_")
//</editor-fold>
public static boolean areExprTypesCompatible(/*const*/ Expr /*P*/ E1, /*const*/ Expr /*P*/ E2) {
  // User intent isn't clear if they're mixing int literals with enum
  // constants.
  if (isa_IntegerLiteral(E1) != isa_IntegerLiteral(E2)) {
    return false;
  }
  
  // Integer literal comparisons, regardless of literal type, are acceptable.
  if (isa_IntegerLiteral(E1)) {
    return true;
  }
  
  // IntegerLiterals are handled above and only EnumConstantDecls are expected
  // beyond this point
  assert (isa_DeclRefExpr(E1) && isa_DeclRefExpr(E2));
  /*const*/ ValueDecl /*P*/ Decl1 = cast_DeclRefExpr(E1).getDecl$Const();
  /*const*/ ValueDecl /*P*/ Decl2 = cast_DeclRefExpr(E2).getDecl$Const();
  assert (isa_EnumConstantDecl(Decl1) && isa_EnumConstantDecl(Decl2));
  /*const*/ DeclContext /*P*/ DC1 = Decl1.getDeclContext$Const();
  /*const*/ DeclContext /*P*/ DC2 = Decl2.getDeclContext$Const();
  assert (isa_EnumDecl(DC1) && isa_EnumDecl(DC2));
  return DC1 == DC2;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::bothKnownTrue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 309,
 FQN="(anonymous namespace)::bothKnownTrue", NM="_ZN12_GLOBAL__N_113bothKnownTrueENS_9TryResultES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_113bothKnownTrueENS_9TryResultES0_")
//</editor-fold>
public static TryResult bothKnownTrue(TryResult R1, TryResult R2) {
  if (!R1.isKnown() || !R2.isKnown()) {
    return new TryResult();
  }
  return new TryResult(R1.isTrue() && R2.isTrue());
}


// FIXME: Add support for dependent-sized array types in C++?
// Does it even make sense to build a CFG for an uninstantiated template?
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindVA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1005,
 FQN="(anonymous namespace)::FindVA", NM="_ZN12_GLOBAL__N_1L6FindVAEPKN5clang4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_1L6FindVAEPKN5clang4TypeE")
//</editor-fold>
public static /*const*/ VariableArrayType /*P*/ FindVA(/*const*/ Type /*P*/ t) {
  {
    /*const*/ ArrayType /*P*/ vt;
    while (((/*P*/ vt = dyn_cast_ArrayType(t)) != null)) {
      {
        /*const*/ VariableArrayType /*P*/ vat = dyn_cast_VariableArrayType(vt);
        if ((vat != null)) {
          if ((vat.getSizeExpr() != null)) {
            return vat;
          }
        }
      }
      
      t = vt.getElementType().getTypePtr();
    }
  }
  
  return null;
}


/// \brief Retrieve the type of the temporary object whose lifetime was 
/// extended by a local reference with the given initializer.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getReferenceInitTemporaryType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1166,
 FQN="(anonymous namespace)::getReferenceInitTemporaryType", NM="_ZN12_GLOBAL__N_1L29getReferenceInitTemporaryTypeERN5clang10ASTContextEPKNS0_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_1L29getReferenceInitTemporaryTypeERN5clang10ASTContextEPKNS0_4ExprE")
//</editor-fold>
public static QualType getReferenceInitTemporaryType(final ASTContext /*&*/ Context, 
                             /*const*/ Expr /*P*/ Init) {
  while (true) {
    // Skip parentheses.
    Init = Init.IgnoreParens$Const();
    {
      
      // Skip through cleanups.
      /*const*/ ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(Init);
      if ((EWC != null)) {
        Init = EWC.getSubExpr$Const();
        continue;
      }
    }
    {
      
      // Skip through the temporary-materialization expression.
      /*const*/ MaterializeTemporaryExpr /*P*/ MTE = dyn_cast_MaterializeTemporaryExpr(Init);
      if ((MTE != null)) {
        Init = MTE.GetTemporaryExpr();
        continue;
      }
    }
    {
      
      // Skip derived-to-base and no-op casts.
      /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(Init);
      if ((CE != null)) {
        if ((CE.getCastKind() == CastKind.CK_DerivedToBase
           || CE.getCastKind() == CastKind.CK_UncheckedDerivedToBase
           || CE.getCastKind() == CastKind.CK_NoOp)
           && Init.getType().$arrow().isRecordType()) {
          Init = CE.getSubExpr$Const();
          continue;
        }
      }
    }
    {
      
      // Skip member accesses into rvalues.
      /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(Init);
      if ((ME != null)) {
        if (!ME.isArrow() && ME.getBase().isRValue()) {
          Init = ME.getBase();
          continue;
        }
      }
    }
    
    break;
  }
  
  return Init.getType();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CanThrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1821,
 FQN="(anonymous namespace)::CanThrow", NM="_ZN12_GLOBAL__N_1L8CanThrowEPN5clang4ExprERNS0_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_1L8CanThrowEPN5clang4ExprERNS0_10ASTContextE")
//</editor-fold>
public static boolean CanThrow(Expr /*P*/ E, final ASTContext /*&*/ Ctx) {
  QualType Ty = E.getType();
  if (Ty.$arrow().isFunctionPointerType()) {
    Ty.$assignMove(Ty.$arrow().getAs(PointerType.class).getPointeeType());
  } else if (Ty.$arrow().isBlockPointerType()) {
    Ty.$assignMove(Ty.$arrow().getAs(BlockPointerType.class).getPointeeType());
  }
  
  /*const*/ FunctionType /*P*/ FT = Ty.$arrow().getAs(FunctionType.class);
  if ((FT != null)) {
    {
      /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(FT);
      if ((Proto != null)) {
        if (!isUnresolvedExceptionSpec(Proto.getExceptionSpecType())
           && Proto.isNothrow(Ctx)) {
          return false;
        }
      }
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::shouldAddCase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3181,
 FQN="(anonymous namespace)::shouldAddCase", NM="_ZN12_GLOBAL__N_1L13shouldAddCaseERbPKN5clang4Expr10EvalResultEPKNS1_8CaseStmtERNS1_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_1L13shouldAddCaseERbPKN5clang4Expr10EvalResultEPKNS1_8CaseStmtERNS1_10ASTContextE")
//</editor-fold>
public static boolean shouldAddCase(final bool$ref/*bool &*/ switchExclusivelyCovered, 
             /*const*/ Expr.EvalResult /*P*/ switchCond, 
             /*const*/ CaseStmt /*P*/ CS, 
             final ASTContext /*&*/ Ctx) {
  if (!(switchCond != null)) {
    return true;
  }
  
  boolean addCase = false;
  if (!switchExclusivelyCovered.$deref()) {
    if (switchCond.Val.isInt()) {
      // Evaluate the LHS of the case value.
      final /*const*/ APSInt /*&*/ lhsInt = CS.getLHS$Const().EvaluateKnownConstInt(Ctx);
      final /*const*/ APSInt /*&*/ condInt = switchCond.Val.getInt$Const();
      if (condInt.$eq(lhsInt)) {
        addCase = true;
        switchExclusivelyCovered.$set(true);
      } else if (condInt.$greater(lhsInt)) {
        {
          /*const*/ Expr /*P*/ RHS = CS.getRHS$Const();
          if ((RHS != null)) {
            // Evaluate the RHS of the case value.
            final /*const*/ APSInt /*&*/ V2 = RHS.EvaluateKnownConstInt(Ctx);
            if (V2.$greatereq(condInt)) {
              addCase = true;
              switchExclusivelyCovered.$set(true);
            }
          }
        }
      }
    } else {
      addCase = true;
    }
  }
  return addCase;
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="print_elem">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4229,
 FQN="print_elem", NM="_ZL10print_elemRN4llvm11raw_ostreamERN12_GLOBAL__N_117StmtPrinterHelperERKN5clang10CFGElementE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZL10print_elemRN4llvm11raw_ostreamERN12_GLOBAL__N_117StmtPrinterHelperERKN5clang10CFGElementE")
//</editor-fold>
public static void print_elem(final raw_ostream /*&*/ OS, final StmtPrinterHelper /*&*/ Helper, 
          final /*const*/ CFGElement /*&*/ E) {
  {
    Optional<CFGStmt> CS = E.getAs(CFGStmt.class);
    if (CS.$bool()) {
      /*const*/ Stmt /*P*/ S = CS.$arrow().getStmt();
      assert (S != null) : "Expecting non-null Stmt";
      {
        
        // special printing for statement-expressions.
        /*const*/ StmtExpr /*P*/ SE = dyn_cast_StmtExpr(S);
        if ((SE != null)) {
          /*const*/ CompoundStmt /*P*/ Sub = SE.getSubStmt$Const();
          
          iterator_range<Stmt> Children = Sub.children$Const();
          if (((ConstStmtIterator)Children.begin()).$noteq(((ConstStmtIterator)Children.end()))) {
            OS.$out(/*KEEP_STR*/"({ ... ; ");
            Helper.handledStmt(SE.getSubStmt$Const().body_rbegin$Const().$star(), OS);
            OS.$out(/*KEEP_STR*/" })\n");
            return;
          }
        }
      }
      {
        // special printing for comma expressions.
        /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(S);
        if ((B != null)) {
          if (B.getOpcode() == BinaryOperatorKind.BO_Comma) {
            OS.$out(/*KEEP_STR*/"... , ");
            Helper.handledStmt(B.getRHS(), OS);
            OS.$out_char($$LF);
            return;
          }
        }
      }
      S.printPretty(OS, $AddrOf(Helper), new PrintingPolicy(Helper.getLangOpts()));
      if (isa_CXXOperatorCallExpr(S)) {
        OS.$out(/*KEEP_STR*/" (OperatorCall)");
      } else if (isa_CXXBindTemporaryExpr(S)) {
        OS.$out(/*KEEP_STR*/" (BindTemporary)");
      } else {
        /*const*/ CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(S);
        if ((CCE != null)) {
          OS.$out(/*KEEP_STR*/" (CXXConstructExpr, ").$out(CCE.getType().getAsString()).$out(/*KEEP_STR*/$RPAREN);
        } else {
          /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(S);
          if ((CE != null)) {
            OS.$out(/*KEEP_STR*/" (").$out(CE.getStmtClassName()).$out(/*KEEP_STR*/$COMMA_SPACE).$out(
                CE.getCastKindName()
            ).$out(
                /*KEEP_STR*/$COMMA_SPACE
            ).$out(CE.getType().getAsString()).$out(
                /*KEEP_STR*/$RPAREN
            );
          }
        }
      }
      
      // Expressions need a newline.
      if (isa_Expr(S)) {
        OS.$out_char($$LF);
      }
    } else {
      Optional<CFGInitializer> IE = E.getAs(CFGInitializer.class);
      if (IE.$bool()) {
        /*const*/ CXXCtorInitializer /*P*/ I = IE.$arrow().getInitializer();
        if (I.isBaseInitializer()) {
          OS.$out(I.getBaseClass().getAsCXXRecordDecl().getName());
        } else if (I.isDelegatingInitializer()) {
          OS.$out(I.getTypeSourceInfo().getType().$arrow().getAsCXXRecordDecl().getName());
        } else {
          OS.$out(I.getAnyMember().getName());
        }
        
        OS.$out(/*KEEP_STR*/$LPAREN);
        {
          Expr /*P*/ IE$1 = I.getInit();
          if ((IE$1 != null)) {
            IE$1.printPretty(OS, $AddrOf(Helper), new PrintingPolicy(Helper.getLangOpts()));
          }
        }
        OS.$out(/*KEEP_STR*/$RPAREN);
        if (I.isBaseInitializer()) {
          OS.$out(/*KEEP_STR*/" (Base initializer)\n");
        } else if (I.isDelegatingInitializer()) {
          OS.$out(/*KEEP_STR*/" (Delegating initializer)\n");
        } else {
          OS.$out(/*KEEP_STR*/" (Member initializer)\n");
        }
      } else {
        Optional<CFGAutomaticObjDtor> DE = E.getAs(CFGAutomaticObjDtor.class);
        if (DE.$bool()) {
          /*const*/ VarDecl /*P*/ VD = DE.$arrow().getVarDecl();
          Helper.handleDecl(VD, OS);
          
          /*const*/ Type /*P*/ T = VD.getType().getTypePtr();
          {
            /*const*/ ReferenceType /*P*/ RT = T.getAs(ReferenceType.class);
            if ((RT != null)) {
              T = RT.getPointeeType().getTypePtr();
            }
          }
          T = T.getBaseElementTypeUnsafe();
          
          OS.$out(/*KEEP_STR*/".~").$out(T.getAsCXXRecordDecl().getName().str()).$out(/*KEEP_STR*/$LPAREN_RPAREN);
          OS.$out(/*KEEP_STR*/" (Implicit destructor)\n");
        } else {
          Optional<CFGNewAllocator> NE = E.getAs(CFGNewAllocator.class);
          if (NE.$bool()) {
            OS.$out(/*KEEP_STR*/"CFGNewAllocator(");
            {
              /*const*/ CXXNewExpr /*P*/ AllocExpr = NE.$arrow().getAllocatorExpr();
              if ((AllocExpr != null)) {
                AllocExpr.getType().print(OS, new PrintingPolicy(Helper.getLangOpts()));
              }
            }
            OS.$out(/*KEEP_STR*/")\n");
          } else {
            Optional<CFGDeleteDtor> DE$1 = E.getAs(CFGDeleteDtor.class);
            if (DE$1.$bool()) {
              /*const*/ CXXRecordDecl /*P*/ RD = DE$1.$arrow().getCXXRecordDecl();
              if (!(RD != null)) {
                return;
              }
              CXXDeleteExpr /*P*/ DelExpr = ((/*const_cast*/CXXDeleteExpr /*P*/ )(DE$1.$arrow().getDeleteExpr()));
              Helper.handledStmt(cast_Stmt(DelExpr.getArgument()), OS);
              OS.$out(/*KEEP_STR*/"->~").$out(RD.getName().str()).$out(/*KEEP_STR*/$LPAREN_RPAREN);
              OS.$out(/*KEEP_STR*/" (Implicit destructor)\n");
            } else {
              Optional<CFGBaseDtor> BE = E.getAs(CFGBaseDtor.class);
              if (BE.$bool()) {
                /*const*/ CXXBaseSpecifier /*P*/ BS = BE.$arrow().getBaseSpecifier();
                OS.$out(/*KEEP_STR*/$TILDE).$out(BS.getType().$arrow().getAsCXXRecordDecl().getName()).$out(/*KEEP_STR*/$LPAREN_RPAREN);
                OS.$out(/*KEEP_STR*/" (Base object destructor)\n");
              } else {
                Optional<CFGMemberDtor> ME = E.getAs(CFGMemberDtor.class);
                if (ME.$bool()) {
                  /*const*/ FieldDecl /*P*/ FD = ME.$arrow().getFieldDecl();
                  /*const*/ Type /*P*/ T = FD.getType().$arrow().getBaseElementTypeUnsafe();
                  OS.$out(/*KEEP_STR*/"this->").$out(FD.getName());
                  OS.$out(/*KEEP_STR*/".~").$out(T.getAsCXXRecordDecl().getName()).$out(/*KEEP_STR*/$LPAREN_RPAREN);
                  OS.$out(/*KEEP_STR*/" (Member object destructor)\n");
                } else {
                  Optional<CFGTemporaryDtor> TE = E.getAs(CFGTemporaryDtor.class);
                  if (TE.$bool()) {
                    /*const*/ CXXBindTemporaryExpr /*P*/ BT = TE.$arrow().getBindTemporaryExpr();
                    OS.$out(/*KEEP_STR*/$TILDE);
                    BT.getType().print(OS, new PrintingPolicy(Helper.getLangOpts()));
                    OS.$out(/*KEEP_STR*/"() (Temporary object destructor)\n");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="print_block">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4344,
 FQN="print_block", NM="_ZL11print_blockRN4llvm11raw_ostreamEPKN5clang3CFGERKNS2_8CFGBlockERN12_GLOBAL__N_117StmtPrinterHelperEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZL11print_blockRN4llvm11raw_ostreamEPKN5clang3CFGERKNS2_8CFGBlockERN12_GLOBAL__N_117StmtPrinterHelperEbb")
//</editor-fold>
public static void print_block(final raw_ostream /*&*/ OS, /*const*/ CFG /*P*/ cfg, 
           final /*const*/ CFGBlock /*&*/ B, 
           final StmtPrinterHelper /*&*/ Helper, boolean print_edges, 
           boolean ShowColors) {
  
  Helper.setBlockID(B.getBlockID());
  
  // Print the header.
  if (ShowColors) {
    OS.changeColor(raw_ostream.Colors.YELLOW, true);
  }
  
  OS.$out(/*KEEP_STR*/"\n [B").$out_uint(B.getBlockID());
  if ($AddrOf(B) == $AddrOf(cfg.getEntry$Const())) {
    OS.$out(/*KEEP_STR*/" (ENTRY)]\n");
  } else if ($AddrOf(B) == $AddrOf(cfg.getExit$Const())) {
    OS.$out(/*KEEP_STR*/" (EXIT)]\n");
  } else if ($AddrOf(B) == cfg.getIndirectGotoBlock$Const()) {
    OS.$out(/*KEEP_STR*/" (INDIRECT GOTO DISPATCH)]\n");
  } else if (B.hasNoReturnElement()) {
    OS.$out(/*KEEP_STR*/" (NORETURN)]\n");
  } else {
    OS.$out(/*KEEP_STR*/"]\n");
  }
  if (ShowColors) {
    OS.resetColor();
  }
  {
    
    // Print the label of this block.
    Stmt /*P*/ Label = ((/*const_cast*/Stmt /*P*/ )(B.getLabel$Const()));
    if ((Label != null)) {
      if (print_edges) {
        OS.$out(/*KEEP_STR*/"  ");
      }
      {
        
        LabelStmt /*P*/ L = dyn_cast_LabelStmt(Label);
        if ((L != null)) {
          OS.$out(L.getName());
        } else {
          CaseStmt /*P*/ C = dyn_cast_CaseStmt(Label);
          if ((C != null)) {
            OS.$out(/*KEEP_STR*/"case ");
            if ((C.getLHS() != null)) {
              C.getLHS().printPretty(OS, $AddrOf(Helper), 
                  new PrintingPolicy(Helper.getLangOpts()));
            }
            if ((C.getRHS() != null)) {
              OS.$out(/*KEEP_STR*/" ... ");
              C.getRHS().printPretty(OS, $AddrOf(Helper), 
                  new PrintingPolicy(Helper.getLangOpts()));
            }
          } else if (isa_DefaultStmt(Label)) {
            OS.$out(/*KEEP_STR*/$default);
          } else {
            CXXCatchStmt /*P*/ CS = dyn_cast_CXXCatchStmt(Label);
            if ((CS != null)) {
              OS.$out(/*KEEP_STR*/"catch (");
              if ((CS.getExceptionDecl() != null)) {
                CS.getExceptionDecl().print(OS, new PrintingPolicy(Helper.getLangOpts()), 
                    0);
              } else {
                OS.$out(/*KEEP_STR*/$ELLIPSIS);
              }
              OS.$out(/*KEEP_STR*/$RPAREN);
            } else {
              throw new llvm_unreachable("Invalid label statement in CFGBlock.");
            }
          }
        }
      }
      
      OS.$out(/*KEEP_STR*/$COLON_LF);
    }
  }
  
  // Iterate through the statements in the block and print them.
  /*uint*/int j = 1;
  
  for (std.reverse_iterator</*const*/ CFGElement> I = B.begin$Const(), E = B.end$Const();
       $noteq_reverse_iterator$C(I, E); I.$preInc() , ++j) {
    
    // Print the statement # in the basic block and the statement itself.
    if (print_edges) {
      OS.$out(/*KEEP_STR*/$SPACE);
    }
    
    OS.$out(llvm.format_uint(/*KEEP_STR*/"%3d", j)).$out(/*KEEP_STR*/": ");
    
    Helper.setStmtID(j);
    
    print_elem(OS, Helper, I.$star());
  }
  
  // Print the terminator of this block.
  if (B.getTerminator$Const().$bool()) {
    if (ShowColors) {
      OS.changeColor(raw_ostream.Colors.GREEN);
    }
    
    OS.$out(/*KEEP_STR*/"   T: ");
    
    Helper.setBlockID(-1);
    
    PrintingPolicy PP/*J*/= new PrintingPolicy(Helper.getLangOpts());
    CFGBlockTerminatorPrint TPrinter/*J*/= new CFGBlockTerminatorPrint(OS, $AddrOf(Helper), PP);
    TPrinter.print(B.getTerminator$Const());
    OS.$out_char($$LF);
    if (ShowColors) {
      OS.resetColor();
    }
  }
  if (print_edges) {
    // Print the predecessors of this block.
    if (!B.pred_empty()) {
      /*const*/ raw_ostream.Colors Color = raw_ostream.Colors.BLUE;
      if (ShowColors) {
        OS.changeColor(Color);
      }
      OS.$out(/*KEEP_STR*/"   Preds ");
      if (ShowColors) {
        OS.resetColor();
      }
      OS.$out_char($$LPAREN).$out_uint(B.pred_size()).$out(/*KEEP_STR*/"):");
      /*uint*/int i = 0;
      if (ShowColors) {
        OS.changeColor(Color);
      }
      
      for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(B.pred_begin$Const()), /*P*/ E = $tryClone(B.pred_end$Const());
           $noteq_ptr(I, E); I.$preInc() , ++i) {
        if ($rem_uint(i, 10) == 8) {
          OS.$out(/*KEEP_STR*/"\n     ");
        }
        
        CFGBlock /*P*/ B$1 = I.$star().$CFGBlock$P();
        boolean Reachable = true;
        if (!(B$1 != null)) {
          Reachable = false;
          B$1 = I./*->*/$star().getPossiblyUnreachableBlock();
        }
        
        OS.$out(/*KEEP_STR*/" B").$out_uint(B$1.getBlockID());
        if (!Reachable) {
          OS.$out(/*KEEP_STR*/"(Unreachable)");
        }
      }
      if (ShowColors) {
        OS.resetColor();
      }
      
      OS.$out_char($$LF);
    }
    
    // Print the successors of this block.
    if (!B.succ_empty()) {
      /*const*/ raw_ostream.Colors Color = raw_ostream.Colors.MAGENTA;
      if (ShowColors) {
        OS.changeColor(Color);
      }
      OS.$out(/*KEEP_STR*/"   Succs ");
      if (ShowColors) {
        OS.resetColor();
      }
      OS.$out_char($$LPAREN).$out_uint(B.succ_size()).$out(/*KEEP_STR*/"):");
      /*uint*/int i = 0;
      if (ShowColors) {
        OS.changeColor(Color);
      }
      
      for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(B.succ_begin$Const()), /*P*/ E = $tryClone(B.succ_end$Const());
           $noteq_ptr(I, E); I.$preInc() , ++i) {
        if ($rem_uint(i, 10) == 8) {
          OS.$out(/*KEEP_STR*/"\n    ");
        }
        
        CFGBlock /*P*/ B$1 = I.$star().$CFGBlock$P();
        
        boolean Reachable = true;
        if (!(B$1 != null)) {
          Reachable = false;
          B$1 = I./*->*/$star().getPossiblyUnreachableBlock();
        }
        if ((B$1 != null)) {
          OS.$out(/*KEEP_STR*/" B").$out_uint(B$1.getBlockID());
          if (!Reachable) {
            OS.$out(/*KEEP_STR*/"(Unreachable)");
          }
        } else {
          OS.$out(/*KEEP_STR*/" NULL");
        }
      }
      if (ShowColors) {
        OS.resetColor();
      }
      OS.$out_char($$LF);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="GraphHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4650,
 FQN="GraphHelper", NM="_ZL11GraphHelper",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZL11GraphHelper")
//</editor-fold>
public static StmtPrinterHelper /*P*/ GraphHelper;
} // END OF class CFGStatics
