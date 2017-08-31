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

package org.clang.ast.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6168,
 FQN="(anonymous namespace)::IntExprEvaluator", NM="_ZN12_GLOBAL__N_116IntExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluatorE")
//</editor-fold>
public class IntExprEvaluator extends /*public*/ ExprEvaluatorBase<IntExprEvaluator> {
  private final APValue /*&*/ Result;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::IntExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6172,
   FQN="(anonymous namespace)::IntExprEvaluator::IntExprEvaluator", NM="_ZN12_GLOBAL__N_116IntExprEvaluatorC1ERNS_8EvalInfoERN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluatorC1ERNS_8EvalInfoERN5clang7APValueE")
  //</editor-fold>
  public IntExprEvaluator(final EvalInfo /*&*/ info, final APValue /*&*/ result) {
    // : ExprEvaluatorBaseTy(info), Result(result) 
    //START JInit
    super(info);
    this./*&*/Result=/*&*/result;
    assert result != null : "JAVA: result is a reference in C++. Why it is null?";
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6175,
   FQN="(anonymous namespace)::IntExprEvaluator::Success", NM="_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN4llvm6APSIntEPKN5clang4ExprERNS5_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN4llvm6APSIntEPKN5clang4ExprERNS5_7APValueE")
  //</editor-fold>
  public boolean Success(final /*const*/ APSInt /*&*/ SI, /*const*/ Expr /*P*/ E, final APValue /*&*/ Result) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (E.getType().$arrow().isIntegralOrEnumerationType()) : "Invalid evaluation result.";
      assert (SI.isSigned() == E.getType().$arrow().isSignedIntegerOrEnumerationType()) : "Invalid evaluation result.";
      assert (SI.getBitWidth() == Info.Ctx.getIntWidth(E.getType())) : "Invalid evaluation result.";
      $c$.clean(Result.$assign($c$.track(new APValue(new APSInt(SI)))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6185,
   FQN="(anonymous namespace)::IntExprEvaluator::Success", NM="_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN4llvm6APSIntEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN4llvm6APSIntEPKN5clang4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APSInt /*&*/ SI, /*const*/ Expr /*P*/ E) {
    return Success(SI, E, Result);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6189,
   FQN="(anonymous namespace)::IntExprEvaluator::Success", NM="_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN4llvm5APIntEPKN5clang4ExprERNS5_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN4llvm5APIntEPKN5clang4ExprERNS5_7APValueE")
  //</editor-fold>
  public boolean Success(final /*const*/ APInt /*&*/ I, /*const*/ Expr /*P*/ E, final APValue /*&*/ Result) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (E.getType().$arrow().isIntegralOrEnumerationType()) : "Invalid evaluation result.";
      assert (I.getBitWidth() == Info.Ctx.getIntWidth(E.getType())) : "Invalid evaluation result.";
      $c$.clean(Result.$assign($c$.track(new APValue(new APSInt(new APInt(I))))));
      Result.getInt().setIsUnsigned(E.getType().$arrow().isUnsignedIntegerOrEnumerationType());
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6199,
   FQN="(anonymous namespace)::IntExprEvaluator::Success", NM="_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN4llvm5APIntEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN4llvm5APIntEPKN5clang4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APInt /*&*/ I, /*const*/ Expr /*P*/ E) {
    return Success(I, E, Result);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6203,
   FQN="(anonymous namespace)::IntExprEvaluator::Success", NM="_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessEyPKN5clang4ExprERNS1_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessEyPKN5clang4ExprERNS1_7APValueE")
  //</editor-fold>
  public boolean Success(long/*uint64_t*/ Value, /*const*/ Expr /*P*/ E, final APValue /*&*/ Result) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (E.getType().$arrow().isIntegralOrEnumerationType()) : "Invalid evaluation result.";
      $c$.clean(Result.$assign($c$.track(new APValue(Info.Ctx.MakeIntValue(Value, E.getType())))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6209,
   FQN="(anonymous namespace)::IntExprEvaluator::Success", NM="_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessEyPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessEyPKN5clang4ExprE")
  //</editor-fold>
  public boolean Success(long/*uint64_t*/ Value, /*const*/ Expr /*P*/ E) {
    return Success(Value, E, Result);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6213,
   FQN="(anonymous namespace)::IntExprEvaluator::Success", NM="_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessEN5clang9CharUnitsEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessEN5clang9CharUnitsEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(CharUnits Size, /*const*/ Expr /*P*/ E) {
    return Success(Size.getQuantity(), E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6217,
   FQN="(anonymous namespace)::IntExprEvaluator::Success", NM="_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E) {
    if (V.isLValue() || V.isAddrLabelDiff()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Result.$assign($c$.track(new APValue(V))));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    return Success(V.getInt$Const(), E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6225,
   FQN="(anonymous namespace)::IntExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_116IntExprEvaluator18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    return Success(0, E);
  }

  
  //===--------------------------------------------------------------------===//
  //                            Visitor Methods
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6231,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitIntegerLiteral", NM="_ZN12_GLOBAL__N_116IntExprEvaluator19VisitIntegerLiteralEPKN5clang14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator19VisitIntegerLiteralEPKN5clang14IntegerLiteralE")
  //</editor-fold>
  public boolean VisitIntegerLiteral(/*const*/ IntegerLiteral /*P*/ E) {
    return Success(E.getValue(), E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6234,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitCharacterLiteral", NM="_ZN12_GLOBAL__N_116IntExprEvaluator21VisitCharacterLiteralEPKN5clang16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator21VisitCharacterLiteralEPKN5clang16CharacterLiteralE")
  //</editor-fold>
  public boolean VisitCharacterLiteral(/*const*/ CharacterLiteral /*P*/ E) {
    return Success($uint2ulong(E.getValue()), E);
  }

  
  
  /// Check whether the given declaration can be directly converted to an integral
  /// rvalue. If not, no diagnostic is produced; there are other things we can
  /// try.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::CheckReferencedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6330,
   FQN="(anonymous namespace)::IntExprEvaluator::CheckReferencedDecl", NM="_ZN12_GLOBAL__N_116IntExprEvaluator19CheckReferencedDeclEPKN5clang4ExprEPKNS1_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator19CheckReferencedDeclEPKN5clang4ExprEPKNS1_4DeclE")
  //</editor-fold>
  public boolean CheckReferencedDecl(/*const*/ Expr /*P*/ E, /*const*/ Decl /*P*/ D) {
    {
      // Enums are integer constant exprs.
      /*const*/ EnumConstantDecl /*P*/ ECD = dyn_cast_EnumConstantDecl(D);
      if ((ECD != null)) {
        // Check for signedness/width mismatches between E type and ECD value.
        boolean SameSign = (ECD.getInitVal().isSigned()
           == E.getType().$arrow().isSignedIntegerOrEnumerationType());
        boolean SameWidth = (ECD.getInitVal().getBitWidth()
           == Info.Ctx.getIntWidth(E.getType()));
        if (SameSign && SameWidth) {
          return Success(ECD.getInitVal(), E);
        } else {
          // Get rid of mismatch (otherwise Success assertions will fail)
          // by computing a new value matching the type of E.
          APSInt Val = new APSInt(ECD.getInitVal());
          if (!SameSign) {
            Val.setIsSigned(!ECD.getInitVal().isSigned());
          }
          if (!SameWidth) {
            Val.$assignMove(Val.extOrTrunc(Info.Ctx.getIntWidth(E.getType())));
          }
          return Success(Val, E);
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6239,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator16VisitDeclRefExprEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator16VisitDeclRefExprEPKN5clang11DeclRefExprE")
  //</editor-fold>
  public boolean VisitDeclRefExpr(/*const*/ DeclRefExpr /*P*/ E) {
    if (CheckReferencedDecl(E, E.getDecl$Const())) {
      return true;
    }
    
    return super.VisitDeclRefExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6245,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitMemberExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator15VisitMemberExprEPKN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator15VisitMemberExprEPKN5clang10MemberExprE")
  //</editor-fold>
  public boolean VisitMemberExpr(/*const*/ MemberExpr /*P*/ E) {
    if (CheckReferencedDecl(E, E.getMemberDecl())) {
      VisitIgnoredBaseExpression(E.getBase());
      return true;
    }
    
    return super.VisitMemberExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6827,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitCallExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    {
      /*uint*/int BuiltinOp = E.getBuiltinCallee();
      switch (Builtin.ID.valueOf(BuiltinOp)) {
       default:
        return super.VisitCallExpr(E);
       case BI__builtin_object_size:
        {
          // The type was checked when we built the expression.
          /*uint*/int Type = $ulong2uint(E.getArg$Const(1).EvaluateKnownConstInt(Info.Ctx).getZExtValue());
          assert ($lesseq_uint(Type, 3)) : "unexpected type";
          if (TryEvaluateBuiltinObjectSize(E, Type)) {
            return true;
          }
          if (E.getArg$Const(0).HasSideEffects(Info.Ctx)) {
            return Success($int2ulong(((Type & 2) != 0) ? 0 : -1), E);
          }
          
          // Expression had no side effects, but we couldn't statically determine the
          // size of the referenced object.
          switch (Info.EvalMode) {
           case EM_ConstantExpression:
           case EM_PotentialConstantExpression:
           case EM_ConstantFold:
           case EM_EvaluateForOverflow:
           case EM_IgnoreSideEffects:
           case EM_DesignatorFold:
            // Leave it to IR generation.
            return Error(E);
           case EM_ConstantExpressionUnevaluated:
           case EM_PotentialConstantExpressionUnevaluated:
            // Reduce it to a constant now.
            return Success($int2ulong(((Type & 2) != 0) ? 0 : -1), E);
          }
        }
       case BI__builtin_bswap16:
       case BI__builtin_bswap32:
       case BI__builtin_bswap64:
        {
          APSInt Val/*J*/= new APSInt();
          if (!EvaluateInteger(E.getArg$Const(0), Val, Info)) {
            return false;
          }
          
          return Success(Val.byteSwap(), E);
        }
       case BI__builtin_classify_type:
        return Success($int2ulong(EvaluateBuiltinClassifyType(E, Info.getLangOpts())), E);
       case BI__builtin_clz:
       case BI__builtin_clzl:
       case BI__builtin_clzll:
       case BI__builtin_clzs:
        {
          APSInt Val/*J*/= new APSInt();
          if (!EvaluateInteger(E.getArg$Const(0), Val, Info)) {
            return false;
          }
          if (Val.$not()) {
            return Error(E);
          }
          
          return Success($uint2ulong(Val.countLeadingZeros()), E);
        }
       case BI__builtin_constant_p:
        return Success((EvaluateBuiltinConstantP(Info.Ctx, E.getArg$Const(0)) ? 1 : 0), E);
       case BI__builtin_ctz:
       case BI__builtin_ctzl:
       case BI__builtin_ctzll:
       case BI__builtin_ctzs:
        {
          APSInt Val/*J*/= new APSInt();
          if (!EvaluateInteger(E.getArg$Const(0), Val, Info)) {
            return false;
          }
          if (Val.$not()) {
            return Error(E);
          }
          
          return Success($uint2ulong(Val.countTrailingZeros()), E);
        }
       case BI__builtin_eh_return_data_regno:
        {
          int Operand = $ulong2int(E.getArg$Const(0).EvaluateKnownConstInt(Info.Ctx).getZExtValue());
          Operand = Info.Ctx.getTargetInfo().getEHDataRegisterNumber(Operand);
          return Success($int2ulong(Operand), E);
        }
       case BI__builtin_expect:
        return Visit(E.getArg$Const(0));
       case BI__builtin_ffs:
       case BI__builtin_ffsl:
       case BI__builtin_ffsll:
        {
          APSInt Val/*J*/= new APSInt();
          if (!EvaluateInteger(E.getArg$Const(0), Val, Info)) {
            return false;
          }
          
          /*uint*/int N = Val.countTrailingZeros();
          return Success($uint2ulong(N == Val.getBitWidth() ? 0 : N + 1), E);
        }
       case BI__builtin_fpclassify:
        {
          APFloat Val/*J*/= new APFloat(0.);
          if (!EvaluateFloat(E.getArg$Const(5), Val, Info)) {
            return false;
          }
          /*uint*/int Arg = 0;
          switch (Val.getCategory()) {
           case fcNaN:
            Arg = 0;
            break;
           case fcInfinity:
            Arg = 1;
            break;
           case fcNormal:
            Arg = Val.isDenormal() ? 3 : 2;
            break;
           case fcZero:
            Arg = 4;
            break;
          }
          return Visit(E.getArg$Const(Arg));
        }
       case BI__builtin_isinf_sign:
        {
          APFloat Val/*J*/= new APFloat(0.);
          return EvaluateFloat(E.getArg$Const(0), Val, Info)
             && Success($int2ulong(Val.isInfinity() ? (Val.isNegative() ? -1 : 1) : 0), E);
        }
       case BI__builtin_isinf:
        {
          APFloat Val/*J*/= new APFloat(0.);
          return EvaluateFloat(E.getArg$Const(0), Val, Info)
             && Success($int2ulong(Val.isInfinity() ? 1 : 0), E);
        }
       case BI__builtin_isfinite:
        {
          APFloat Val/*J*/= new APFloat(0.);
          return EvaluateFloat(E.getArg$Const(0), Val, Info)
             && Success($int2ulong(Val.isFinite() ? 1 : 0), E);
        }
       case BI__builtin_isnan:
        {
          APFloat Val/*J*/= new APFloat(0.);
          return EvaluateFloat(E.getArg$Const(0), Val, Info)
             && Success($int2ulong(Val.isNaN() ? 1 : 0), E);
        }
       case BI__builtin_isnormal:
        {
          APFloat Val/*J*/= new APFloat(0.);
          return EvaluateFloat(E.getArg$Const(0), Val, Info)
             && Success($int2ulong(Val.isNormal() ? 1 : 0), E);
        }
       case BI__builtin_parity:
       case BI__builtin_parityl:
       case BI__builtin_parityll:
        {
          APSInt Val/*J*/= new APSInt();
          if (!EvaluateInteger(E.getArg$Const(0), Val, Info)) {
            return false;
          }
          
          return Success($uint2ulong($rem_uint(Val.countPopulation(), 2)), E);
        }
       case BI__builtin_popcount:
       case BI__builtin_popcountl:
       case BI__builtin_popcountll:
        {
          APSInt Val/*J*/= new APSInt();
          if (!EvaluateInteger(E.getArg$Const(0), Val, Info)) {
            return false;
          }
          
          return Success($uint2ulong(Val.countPopulation()), E);
        }
       case BIstrlen:
        // A call to strlen is not a constant expression.
        if (Info.getLangOpts().CPlusPlus11) {
          Info.CCEDiag(E, diag.note_constexpr_invalid_function).$out_int(/*isConstexpr*/ 
              0
          ).$out_int(/*isConstructor*/ 0).$out$T(/*KEEP_STR*/"'strlen'");
        } else {
          Info.CCEDiag(E, diag.note_invalid_subexpr_in_const_expr);
        }
       case BI__builtin_strlen:
        {
          LValue String = null;
          try {
            // As an extension, we support __builtin_strlen() as a constant expression,
            // and support folding strlen() to a constant.
            String/*J*/= new LValue();
            if (!EvaluatePointer(E.getArg$Const(0), String, Info)) {
              return false;
            }
            {
              
              // Fast path: if it's a string literal, search the string value.
              /*const*/ StringLiteral /*P*/ S = dyn_cast_or_null_StringLiteral(String.getLValueBase().dyn_cast(/*const*/ Expr /*P*/.class));
              if ((S != null)) {
                // The string literal may have embedded null characters. Find the first
                // one and truncate there.
                StringRef Str = S.getBytes();
                long/*int64_t*/ Off = String.Offset.getQuantity();
                if (Off >= 0 && $lesseq_ulong_uint((long/*uint64_t*/)Off, Str.size())
                   && S.getCharByteWidth() == 1) {
                  Str.$assignMove(Str.substr($long2uint(Off)));
                  
                  /*size_t*/int Pos = Str.find((byte)0);
                  if (Pos != StringRef.npos) {
                    Str.$assignMove(Str.substr(0, Pos));
                  }
                  
                  return Success($uint2ulong(Str.size()), E);
                }
                // Fall through to slow path to issue appropriate diagnostic.
              }
            }
            
            // Slow path: scan the bytes of the string looking for the terminating 0.
            QualType CharTy = E.getArg$Const(0).getType().$arrow().getPointeeType();
            for (long/*uint64_t*/ Strlen = 0;; ++Strlen) {
              APValue Char = null;
              try {
                Char/*J*/= new APValue();
                if (!handleLValueToRValueConversion(Info, E, new QualType(CharTy), String, Char)
                   || !Char.isInt()) {
                  return false;
                }
                if (Char.getInt().$not()) {
                  return Success(Strlen, E);
                }
                if (!HandleLValueArrayAdjustment(Info, E, String, new QualType(CharTy), 1)) {
                  return false;
                }
              } finally {
                if (Char != null) { Char.$destroy(); }
              }
            }
          } finally {
            if (String != null) { String.$destroy(); }
          }
        }
       case BI__atomic_always_lock_free:
       case BI__atomic_is_lock_free:
       case BI__c11_atomic_is_lock_free:
        {
          APSInt SizeVal/*J*/= new APSInt();
          if (!EvaluateInteger(E.getArg$Const(0), SizeVal, Info)) {
            return false;
          }
          
          // For __atomic_is_lock_free(sizeof(_Atomic(T))), if the size is a power
          // of two less than the maximum inline atomic width, we know it is
          // lock-free.  If the size isn't a power of two, or greater than the
          // maximum alignment where we promote atomics, we know it is not lock-free
          // (at least not in the sense of atomic_is_lock_free).  Otherwise,
          // the answer can only be determined at runtime; for example, 16-byte
          // atomics have lock-free implementations on some, but not all,
          // x86-64 processors.
          
          // Check power-of-two.
          CharUnits Size = CharUnits.fromQuantity(SizeVal.getZExtValue());
          if (Size.isPowerOfTwo()) {
            // Check against inlining width.
            /*uint*/int InlineWidthBits = Info.Ctx.getTargetInfo().getMaxAtomicInlineWidth();
            if (Size.$lesseq(Info.Ctx.toCharUnitsFromBits($uint2long(InlineWidthBits)))) {
              if (BuiltinOp == Builtin.ID.BI__c11_atomic_is_lock_free.getValue()
                 || Size.$eq(CharUnits.One())
                 || (E.getArg$Const(1).isNullPointerConstant(Info.Ctx, 
                  Expr.NullPointerConstantValueDependence.NPC_NeverValueDependent).getValue() != 0)) {
                // OK, we will inline appropriately-aligned operations of this size,
                // and _Atomic(T) is appropriately-aligned.
                return Success(1, E);
              }
              
              QualType PointeeType = E.getArg$Const(1).IgnoreImpCasts$Const().getType().$arrow().castAs(PointerType.class).getPointeeType();
              if (!PointeeType.$arrow().isIncompleteType()
                 && Info.Ctx.getTypeAlignInChars(new QualType(PointeeType)).$greatereq(Size)) {
                // OK, we will inline operations on this object.
                return Success(1, E);
              }
            }
          }
          
          return BuiltinOp == Builtin.ID.BI__atomic_always_lock_free.getValue() ? Success(0, E) : Error(E);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7465,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_116IntExprEvaluator19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ E) {
    DelayedNoteFailureRAII MaybeNoteFailureLater = null;
    try {
      // We don't call noteFailure immediately because the assignment happens after
      // we evaluate LHS and RHS.
      if (!Info.keepEvaluatingAfterFailure() && E.isAssignmentOp()) {
        return Error(E);
      }
      
      MaybeNoteFailureLater/*J*/= new DelayedNoteFailureRAII(Info, E.isAssignmentOp());
      if (DataRecursiveIntBinOpEvaluator.shouldEnqueue(E)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean($c$.track(new DataRecursiveIntBinOpEvaluator(/*Deref*/this, Result)).Traverse(E));
        } finally {
          $c$.$destroy();
        }
      }
      
      QualType LHSTy = E.getLHS().getType();
      QualType RHSTy = E.getRHS().getType();
      if (LHSTy.$arrow().isAnyComplexType() || RHSTy.$arrow().isAnyComplexType()) {
        ComplexValue LHS = null;
        ComplexValue RHS = null;
        try {
          LHS/*J*/= new ComplexValue();
          RHS/*J*/= new ComplexValue();
          boolean LHSOK;
          if (E.isAssignmentOp()) {
            LValue LV = null;
            try {
              LV/*J*/= new LValue();
              EvaluateLValue(E.getLHS(), LV, Info);
              LHSOK = false;
            } finally {
              if (LV != null) { LV.$destroy(); }
            }
          } else if (LHSTy.$arrow().isRealFloatingType()) {
            LHSOK = EvaluateFloat(E.getLHS(), LHS.FloatReal, Info);
            if (LHSOK) {
              LHS.makeComplexFloat();
              LHS.FloatImag.$assignMove(new APFloat(LHS.FloatReal.getSemantics()));
            }
          } else {
            LHSOK = EvaluateComplex(E.getLHS(), LHS, Info);
          }
          if (!LHSOK && !Info.noteFailure()) {
            return false;
          }
          if (E.getRHS().getType().$arrow().isRealFloatingType()) {
            if (!EvaluateFloat(E.getRHS(), RHS.FloatReal, Info) || !LHSOK) {
              return false;
            }
            RHS.makeComplexFloat();
            RHS.FloatImag.$assignMove(new APFloat(RHS.FloatReal.getSemantics()));
          } else if (!EvaluateComplex(E.getRHS(), RHS, Info) || !LHSOK) {
            return false;
          }
          if (LHS.isComplexFloat()) {
            APFloat.cmpResult CR_r = LHS.getComplexFloatReal().compare(RHS.getComplexFloatReal());
            APFloat.cmpResult CR_i = LHS.getComplexFloatImag().compare(RHS.getComplexFloatImag());
            if (E.getOpcode() == BinaryOperatorKind.BO_EQ) {
              return Success(((CR_r == APFloat.cmpResult.cmpEqual
                     && CR_i == APFloat.cmpResult.cmpEqual) ? 1 : 0), E);
            } else {
              assert (E.getOpcode() == BinaryOperatorKind.BO_NE) : "Invalid complex comparison.";
              return Success((((CR_r == APFloat.cmpResult.cmpGreaterThan
                     || CR_r == APFloat.cmpResult.cmpLessThan
                     || CR_r == APFloat.cmpResult.cmpUnordered)
                     || (CR_i == APFloat.cmpResult.cmpGreaterThan
                     || CR_i == APFloat.cmpResult.cmpLessThan
                     || CR_i == APFloat.cmpResult.cmpUnordered)) ? 1 : 0), E);
            }
          } else {
            if (E.getOpcode() == BinaryOperatorKind.BO_EQ) {
              return Success(((LHS.getComplexIntReal().$eq(RHS.getComplexIntReal())
                     && LHS.getComplexIntImag().$eq(RHS.getComplexIntImag())) ? 1 : 0), E);
            } else {
              assert (E.getOpcode() == BinaryOperatorKind.BO_NE) : "Invalid compex comparison.";
              return Success(((LHS.getComplexIntReal().$noteq(RHS.getComplexIntReal())
                     || LHS.getComplexIntImag().$noteq(RHS.getComplexIntImag())) ? 1 : 0), E);
            }
          }
        } finally {
          if (RHS != null) { RHS.$destroy(); }
          if (LHS != null) { LHS.$destroy(); }
        }
      }
      if (LHSTy.$arrow().isRealFloatingType()
         && RHSTy.$arrow().isRealFloatingType()) {
        APFloat RHS/*J*/= new APFloat(0.);
        APFloat LHS/*J*/= new APFloat(0.);
        
        boolean LHSOK = EvaluateFloat(E.getRHS(), RHS, Info);
        if (!LHSOK && !Info.noteFailure()) {
          return false;
        }
        if (!EvaluateFloat(E.getLHS(), LHS, Info) || !LHSOK) {
          return false;
        }
        
        APFloat.cmpResult CR = LHS.compare(RHS);
        switch (E.getOpcode()) {
         default:
          throw new llvm_unreachable("Invalid binary operator!");
         case BO_LT:
          return Success(((CR == APFloat.cmpResult.cmpLessThan) ? 1 : 0), E);
         case BO_GT:
          return Success(((CR == APFloat.cmpResult.cmpGreaterThan) ? 1 : 0), E);
         case BO_LE:
          return Success(((CR == APFloat.cmpResult.cmpLessThan || CR == APFloat.cmpResult.cmpEqual) ? 1 : 0), E);
         case BO_GE:
          return Success(((CR == APFloat.cmpResult.cmpGreaterThan || CR == APFloat.cmpResult.cmpEqual) ? 1 : 0), 
              E);
         case BO_EQ:
          return Success(((CR == APFloat.cmpResult.cmpEqual) ? 1 : 0), E);
         case BO_NE:
          return Success(((CR == APFloat.cmpResult.cmpGreaterThan
                 || CR == APFloat.cmpResult.cmpLessThan
                 || CR == APFloat.cmpResult.cmpUnordered) ? 1 : 0), E);
        }
      }
      if (LHSTy.$arrow().isPointerType() && RHSTy.$arrow().isPointerType()) {
        if (E.getOpcode() == BinaryOperatorKind.BO_Sub || E.isComparisonOp()) {
          LValue LHSValue = null;
          LValue RHSValue = null;
          try {
            LHSValue/*J*/= new LValue();
            RHSValue/*J*/= new LValue();
            
            boolean LHSOK = EvaluatePointer(E.getLHS(), LHSValue, Info);
            if (!LHSOK && !Info.noteFailure()) {
              return false;
            }
            if (!EvaluatePointer(E.getRHS(), RHSValue, Info) || !LHSOK) {
              return false;
            }
            
            // Reject differing bases from the normal codepath; we special-case
            // comparisons to null.
            if (!HasSameBase(LHSValue, RHSValue)) {
              if (E.getOpcode() == BinaryOperatorKind.BO_Sub) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // Handle &&A - &&B.
                  if (!LHSValue.Offset.isZero() || !RHSValue.Offset.isZero()) {
                    return Error(E);
                  }
                  /*const*/ Expr /*P*/ LHSExpr = LHSValue.Base.dyn_cast(/*const*/ Expr /*P*/.class);
                  /*const*/ Expr /*P*/ RHSExpr = RHSValue.Base.dyn_cast(/*const*/ Expr /*P*/.class);
                  if (!(LHSExpr != null) || !(RHSExpr != null)) {
                    return Error(E);
                  }
                  /*const*/ AddrLabelExpr /*P*/ LHSAddrExpr = dyn_cast_AddrLabelExpr(LHSExpr);
                  /*const*/ AddrLabelExpr /*P*/ RHSAddrExpr = dyn_cast_AddrLabelExpr(RHSExpr);
                  if (!(LHSAddrExpr != null) || !(RHSAddrExpr != null)) {
                    return Error(E);
                  }
                  // Make sure both labels come from the same function.
                  if (LHSAddrExpr.getLabel().getDeclContext()
                     != RHSAddrExpr.getLabel().getDeclContext()) {
                    return Error(E);
                  }
                  return $c$.clean(Success($c$.track(new APValue(LHSAddrExpr, RHSAddrExpr)), E));
                } finally {
                  $c$.$destroy();
                }
              }
              // Inequalities and subtractions between unrelated pointers have
              // unspecified or undefined behavior.
              if (!E.isEqualityOp()) {
                return Error(E);
              }
              // A constant address may compare equal to the address of a symbol.
              // The one exception is that address of an object cannot compare equal
              // to a null pointer constant.
              if ((!LHSValue.Base.$bool() && !LHSValue.Offset.isZero())
                 || (!RHSValue.Base.$bool() && !RHSValue.Offset.isZero())) {
                return Error(E);
              }
              // It's implementation-defined whether distinct literals will have
              // distinct addresses. In clang, the result of such a comparison is
              // unspecified, so it is not a constant expression. However, we do know
              // that the address of a literal will be non-null.
              if ((IsLiteralLValue(LHSValue) || IsLiteralLValue(RHSValue))
                 && LHSValue.Base.$bool() && RHSValue.Base.$bool()) {
                return Error(E);
              }
              // We can't tell whether weak symbols will end up pointing to the same
              // object.
              if (IsWeakLValue(LHSValue) || IsWeakLValue(RHSValue)) {
                return Error(E);
              }
              // We can't compare the address of the start of one object with the
              // past-the-end address of another object, per C++ DR1652.
              if ((LHSValue.Base.$bool() && LHSValue.Offset.isZero()
                 && isOnePastTheEndOfCompleteObject(Info.Ctx, RHSValue))
                 || (RHSValue.Base.$bool() && RHSValue.Offset.isZero()
                 && isOnePastTheEndOfCompleteObject(Info.Ctx, LHSValue))) {
                return Error(E);
              }
              // We can't tell whether an object is at the same address as another
              // zero sized object.
              if ((RHSValue.Base.$bool() && isZeroSized(LHSValue))
                 || (LHSValue.Base.$bool() && isZeroSized(RHSValue))) {
                return Error(E);
              }
              // Pointers with different bases cannot represent the same object.
              // (Note that clang defaults to -fmerge-all-constants, which can
              // lead to inconsistent results for comparisons involving the address
              // of a constant; this generally doesn't matter in practice.)
              return Success(((E.getOpcode() == BinaryOperatorKind.BO_NE) ? 1 : 0), E);
            }
            
            final /*const*/ CharUnits /*&*/ LHSOffset = LHSValue.getLValueOffset();
            final /*const*/ CharUnits /*&*/ RHSOffset = RHSValue.getLValueOffset();
            
            final SubobjectDesignator /*&*/ LHSDesignator = LHSValue.getLValueDesignator();
            final SubobjectDesignator /*&*/ RHSDesignator = RHSValue.getLValueDesignator();
            if (E.getOpcode() == BinaryOperatorKind.BO_Sub) {
              // C++11 [expr.add]p6:
              //   Unless both pointers point to elements of the same array object, or
              //   one past the last element of the array object, the behavior is
              //   undefined.
              if (!LHSDesignator.Invalid && !RHSDesignator.Invalid
                 && !AreElementsOfSameArray(getType(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(LHSValue.Base)), 
                  LHSDesignator, RHSDesignator)) {
                CCEDiag(E, diag.note_constexpr_pointer_subtraction_not_same_array);
              }
              
              QualType Type = E.getLHS().getType();
              QualType ElementType = Type.$arrow().getAs(PointerType.class).getPointeeType();
              
              CharUnits ElementSize/*J*/= new CharUnits();
              if (!HandleSizeof(Info, E.getExprLoc(), new QualType(ElementType), ElementSize)) {
                return false;
              }
              
              // As an extension, a type may have zero size (empty struct or union in
              // C, array of zero length). Pointer subtraction in such cases has
              // undefined behavior, so is not constant.
              if (ElementSize.isZero()) {
                Info.FFDiag(E, diag.note_constexpr_pointer_subtraction_zero_size).$out$T(
                    ElementType
                );
                return false;
              }
              
              // FIXME: LLVM and GCC both compute LHSOffset - RHSOffset at runtime,
              // and produce incorrect results when it overflows. Such behavior
              // appears to be non-conforming, but is common, so perhaps we should
              // assume the standard intended for such cases to be undefined behavior
              // and check for them.
              
              // Compute (LHSOffset - RHSOffset) / Size carefully, checking for
              // overflow in the final conversion to ptrdiff_t.
              APSInt LHS/*J*/= new APSInt(new APInt(JD$UInt_ULong.INSTANCE, 65, (long/*int64_t*/)LHSOffset.getQuantity(), true), false);
              APSInt RHS/*J*/= new APSInt(new APInt(JD$UInt_ULong.INSTANCE, 65, (long/*int64_t*/)RHSOffset.getQuantity(), true), false);
              APSInt ElemSize/*J*/= new APSInt(new APInt(JD$UInt_ULong.INSTANCE, 65, (long/*int64_t*/)ElementSize.getQuantity(), true), false);
              APSInt TrueResult = (LHS.$sub(RHS)).$slash(ElemSize);
              APSInt Result = TrueResult.trunc(Info.Ctx.getIntWidth(E.getType()));
              if (Result.extend(65).$noteq(TrueResult)
                 && !HandleOverflow(Info, E, TrueResult, E.getType())) {
                return false;
              }
              return Success(Result, E);
            }
            
            // C++11 [expr.rel]p3:
            //   Pointers to void (after pointer conversions) can be compared, with a
            //   result defined as follows: If both pointers represent the same
            //   address or are both the null pointer value, the result is true if the
            //   operator is <= or >= and false otherwise; otherwise the result is
            //   unspecified.
            // We interpret this as applying to pointers to *cv* void.
            if (LHSTy.$arrow().isVoidPointerType() && LHSOffset.$noteq(RHSOffset)
               && E.isRelationalOp()) {
              CCEDiag(E, diag.note_constexpr_void_comparison);
            }
            
            // C++11 [expr.rel]p2:
            // - If two pointers point to non-static data members of the same object,
            //   or to subobjects or array elements fo such members, recursively, the
            //   pointer to the later declared member compares greater provided the
            //   two members have the same access control and provided their class is
            //   not a union.
            //   [...]
            // - Otherwise pointer comparisons are unspecified.
            if (!LHSDesignator.Invalid && !RHSDesignator.Invalid
               && E.isRelationalOp()) {
              bool$ref WasArrayIndex = create_bool$ref();
              /*uint*/int Mismatch = FindDesignatorMismatch(getType(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(LHSValue.Base)), LHSDesignator, 
                  RHSDesignator, WasArrayIndex);
              // At the point where the designators diverge, the comparison has a
              // specified value if:
              //  - we are comparing array indices
              //  - we are comparing fields of a union, or fields with the same access
              // Otherwise, the result is unspecified and thus the comparison is not a
              // constant expression.
              if (!WasArrayIndex.$deref() && $less_uint(Mismatch, LHSDesignator.Entries.size())
                 && $less_uint(Mismatch, RHSDesignator.Entries.size())) {
                /*const*/ FieldDecl /*P*/ LF = getAsField(new APValue.LValuePathEntry(LHSDesignator.Entries.$at(Mismatch)));
                /*const*/ FieldDecl /*P*/ RF = getAsField(new APValue.LValuePathEntry(RHSDesignator.Entries.$at(Mismatch)));
                if (!(LF != null) && !(RF != null)) {
                  CCEDiag(E, diag.note_constexpr_pointer_comparison_base_classes);
                } else if (!(LF != null)) {
                  CCEDiag(E, diag.note_constexpr_pointer_comparison_base_field).$out$T(
                      getAsBaseClass(new APValue.LValuePathEntry(LHSDesignator.Entries.$at(Mismatch)))
                  ).$out$T(
                      RF.getParent$Const()
                  ).$out$T(RF);
                } else if (!(RF != null)) {
                  CCEDiag(E, diag.note_constexpr_pointer_comparison_base_field).$out$T(
                      getAsBaseClass(new APValue.LValuePathEntry(RHSDesignator.Entries.$at(Mismatch)))
                  ).$out$T(
                      LF.getParent$Const()
                  ).$out$T(LF);
                } else if (!LF.getParent$Const().isUnion()
                   && LF.getAccess() != RF.getAccess()) {
                  CCEDiag(E, diag.note_constexpr_pointer_comparison_differing_access).$out$T(
                      LF
                  ).$out$T(LF.getAccess()).$out$T(RF).$out$T(RF.getAccess()).$out$T(
                      LF.getParent$Const()
                  );
                }
              }
            }
            
            // The comparison here must be unsigned, and performed with the same
            // width as the pointer.
            /*uint*/int PtrSize = $ulong2uint(Info.Ctx.getTypeSize(new QualType(LHSTy)));
            long/*uint64_t*/ CompareLHS = LHSOffset.getQuantity();
            long/*uint64_t*/ CompareRHS = RHSOffset.getQuantity();
            assert ($lesseq_uint(PtrSize, 64)) : "Unexpected pointer width";
            long/*uint64_t*/ Mask = ~0L/*ULL*/ >>> (64 - PtrSize);
            CompareLHS &= Mask;
            CompareRHS &= Mask;
            
            // If there is a base and this is a relational operator, we can only
            // compare pointers within the object in question; otherwise, the result
            // depends on where the object is located in memory.
            if (!LHSValue.Base.isNull() && E.isRelationalOp()) {
              QualType BaseTy = getType(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(LHSValue.Base));
              if (BaseTy.$arrow().isIncompleteType()) {
                return Error(E);
              }
              CharUnits Size = Info.Ctx.getTypeSizeInChars(/*NO_COPY*/BaseTy);
              long/*uint64_t*/ OffsetLimit = Size.getQuantity();
              if ($greater_ulong(CompareLHS, OffsetLimit) || $greater_ulong(CompareRHS, OffsetLimit)) {
                return Error(E);
              }
            }
            switch (E.getOpcode()) {
             default:
              throw new llvm_unreachable("missing comparison operator");
             case BO_LT:
              return Success((($less_ulong(CompareLHS, CompareRHS)) ? 1 : 0), E);
             case BO_GT:
              return Success((($greater_ulong(CompareLHS, CompareRHS)) ? 1 : 0), E);
             case BO_LE:
              return Success((($lesseq_ulong(CompareLHS, CompareRHS)) ? 1 : 0), E);
             case BO_GE:
              return Success((($greatereq_ulong(CompareLHS, CompareRHS)) ? 1 : 0), E);
             case BO_EQ:
              return Success(((CompareLHS == CompareRHS) ? 1 : 0), E);
             case BO_NE:
              return Success(((CompareLHS != CompareRHS) ? 1 : 0), E);
            }
          } finally {
            if (RHSValue != null) { RHSValue.$destroy(); }
            if (LHSValue != null) { LHSValue.$destroy(); }
          }
        }
      }
      if (LHSTy.$arrow().isMemberPointerType()) {
        MemberPtr LHSValue = null;
        MemberPtr RHSValue = null;
        try {
          assert (E.isEqualityOp()) : "unexpected member pointer operation";
          assert (RHSTy.$arrow().isMemberPointerType()) : "invalid comparison";
          
          LHSValue/*J*/= new MemberPtr();
          RHSValue/*J*/= new MemberPtr();
          
          boolean LHSOK = EvaluateMemberPointer(E.getLHS(), LHSValue, Info);
          if (!LHSOK && !Info.noteFailure()) {
            return false;
          }
          if (!EvaluateMemberPointer(E.getRHS(), RHSValue, Info) || !LHSOK) {
            return false;
          }
          
          // C++11 [expr.eq]p2:
          //   If both operands are null, they compare equal. Otherwise if only one is
          //   null, they compare unequal.
          if (!(LHSValue.getDecl() != null) || !(RHSValue.getDecl() != null)) {
            boolean Equal = !(LHSValue.getDecl() != null) && !(RHSValue.getDecl() != null);
            return Success(((E.getOpcode() == BinaryOperatorKind.BO_EQ ? Equal : !Equal) ? 1 : 0), E);
          }
          {
            
            //   Otherwise if either is a pointer to a virtual member function, the
            //   result is unspecified.
            /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(LHSValue.getDecl());
            if ((MD != null)) {
              if (MD.isVirtual()) {
                CCEDiag(E, diag.note_constexpr_compare_virtual_mem_ptr).$out$T(MD);
              }
            }
          }
          {
            /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(RHSValue.getDecl());
            if ((MD != null)) {
              if (MD.isVirtual()) {
                CCEDiag(E, diag.note_constexpr_compare_virtual_mem_ptr).$out$T(MD);
              }
            }
          }
          
          //   Otherwise they compare equal if and only if they would refer to the
          //   same member of the same most derived object or the same subobject if
          //   they were dereferenced with a hypothetical object of the associated
          //   class type.
          boolean Equal = $eq_MemberPtr$C(LHSValue, RHSValue);
          return Success(((E.getOpcode() == BinaryOperatorKind.BO_EQ ? Equal : !Equal) ? 1 : 0), E);
        } finally {
          if (RHSValue != null) { RHSValue.$destroy(); }
          if (LHSValue != null) { LHSValue.$destroy(); }
        }
      }
      if (LHSTy.$arrow().isNullPtrType()) {
        assert (E.isComparisonOp()) : "unexpected nullptr operation";
        assert (RHSTy.$arrow().isNullPtrType()) : "missing pointer conversion";
        // C++11 [expr.rel]p4, [expr.eq]p3: If two operands of type std::nullptr_t
        // are compared, the result is true of the operator is <=, >= or ==, and
        // false otherwise.
        BinaryOperatorKind Opcode = E.getOpcode();
        return Success(((Opcode == BinaryOperatorKind.BO_EQ || Opcode == BinaryOperatorKind.BO_LE || Opcode == BinaryOperatorKind.BO_GE) ? 1 : 0), E);
      }
      assert ((!LHSTy.$arrow().isIntegralOrEnumerationType() || !RHSTy.$arrow().isIntegralOrEnumerationType())) : "DataRecursiveIntBinOpEvaluator should have handled integral types";
      // We can't continue from here for non-integral types.
      return super.VisitBinaryOperator(E);
    } finally {
      if (MaybeNoteFailureLater != null) { MaybeNoteFailureLater.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7893,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitOffsetOfExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator17VisitOffsetOfExprEPKN5clang12OffsetOfExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator17VisitOffsetOfExprEPKN5clang12OffsetOfExprE")
  //</editor-fold>
  public boolean VisitOffsetOfExpr(/*const*/ OffsetOfExpr /*P*/ OOE) {
    CharUnits Result/*J*/= new CharUnits();
    /*uint*/int n = OOE.getNumComponents();
    if (n == 0) {
      return Error(OOE);
    }
    QualType CurrentType = OOE.getTypeSourceInfo().getType();
    for (/*uint*/int i = 0; i != n; ++i) {
      OffsetOfNode ON = new OffsetOfNode(OOE.getComponent(i));
      switch (ON.getKind()) {
       case OffsetOfNode.Kind.Array:
        {
          /*const*/ Expr /*P*/ Idx = OOE.getIndexExpr$Const(ON.getArrayExprIndex());
          APSInt IdxResult/*J*/= new APSInt();
          if (!EvaluateInteger(Idx, IdxResult, Info)) {
            return false;
          }
          /*const*/ ArrayType /*P*/ AT = Info.Ctx.getAsArrayType(new QualType(CurrentType));
          if (!(AT != null)) {
            return Error(OOE);
          }
          CurrentType.$assignMove(AT.getElementType());
          CharUnits ElementSize = Info.Ctx.getTypeSizeInChars(/*NO_COPY*/CurrentType);
          Result.$addassign($star_long_CharUnits$C(IdxResult.getSExtValue(), ElementSize));
          break;
        }
       case OffsetOfNode.Kind.Field:
        {
          FieldDecl /*P*/ MemberDecl = ON.getField();
          /*const*/ RecordType /*P*/ RT = CurrentType.$arrow().getAs$RecordType();
          if (!(RT != null)) {
            return Error(OOE);
          }
          RecordDecl /*P*/ RD = RT.getDecl();
          if (RD.isInvalidDecl()) {
            return false;
          }
          final /*const*/ ASTRecordLayout /*&*/ RL = Info.Ctx.getASTRecordLayout(RD);
          /*uint*/int i$1 = MemberDecl.getFieldIndex();
          assert ($less_uint(i$1, RL.getFieldCount())) : "offsetof field in wrong type";
          Result.$addassign(Info.Ctx.toCharUnitsFromBits(RL.getFieldOffset(i$1)));
          CurrentType.$assignMove(MemberDecl.getType().getNonReferenceType());
          break;
        }
       case OffsetOfNode.Kind.Identifier:
        throw new llvm_unreachable("dependent __builtin_offsetof");
       case OffsetOfNode.Kind.Base:
        {
          CXXBaseSpecifier /*P*/ BaseSpec = ON.getBase();
          if (BaseSpec.isVirtual()) {
            return Error(OOE);
          }
          
          // Find the layout of the class whose base we are looking into.
          /*const*/ RecordType /*P*/ RT = CurrentType.$arrow().getAs$RecordType();
          if (!(RT != null)) {
            return Error(OOE);
          }
          RecordDecl /*P*/ RD = RT.getDecl();
          if (RD.isInvalidDecl()) {
            return false;
          }
          final /*const*/ ASTRecordLayout /*&*/ RL = Info.Ctx.getASTRecordLayout(RD);
          
          // Find the base class itself.
          CurrentType.$assignMove(BaseSpec.getType());
          /*const*/ RecordType /*P*/ BaseRT = CurrentType.$arrow().getAs$RecordType();
          if (!(BaseRT != null)) {
            return Error(OOE);
          }
          
          // Add the offset to the base.
          Result.$addassign(RL.getBaseClassOffset(cast_CXXRecordDecl(BaseRT.getDecl())));
          break;
        }
      }
    }
    return Success(new CharUnits(Result), OOE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7962,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_116IntExprEvaluator18VisitUnaryOperatorEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator18VisitUnaryOperatorEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryOperator(/*const*/ UnaryOperator /*P*/ E) {
    switch (E.getOpcode()) {
     default:
      // Address, indirect, pre/post inc/dec, etc are not valid constant exprs.
      // See C99 6.6p3.
      return Error(E);
     case UO_Extension:
      // FIXME: Should extension allow i-c-e extension expressions in its scope?
      // If so, we could clear the diagnostic ID.
      return Visit(E.getSubExpr());
     case UO_Plus:
      // The result is just the value.
      return Visit(E.getSubExpr());
     case UO_Minus:
      {
        if (!Visit(E.getSubExpr())) {
          return false;
        }
        if (!Result.isInt()) {
          return Error(E);
        }
        final /*const*/ APSInt /*&*/ Value = Result.getInt();
        if (Value.isSigned() && Value.isMinSignedValue()
           && !HandleOverflow(Info, E, Value.extend(Value.getBitWidth() + 1).$sub(), 
            E.getType())) {
          return false;
        }
        return Success(Value.$sub(), E);
      }
     case UO_Not:
      {
        if (!Visit(E.getSubExpr())) {
          return false;
        }
        if (!Result.isInt()) {
          return Error(E);
        }
        return Success(Result.getInt().$bitnot(), E);
      }
     case UO_LNot:
      {
        bool$ref bres = create_bool$ref();
        if (!EvaluateAsBooleanCondition(E.getSubExpr(), bres, Info)) {
          return false;
        }
        return Success(((!bres.$deref()) ? 1 : 0), E);
      }
    }
  }

  
  
  /// HandleCast - This is used to evaluate implicit or explicit casts where the
  /// result type is integer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8003,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    /*const*/ Expr /*P*/ SubExpr = E.getSubExpr$Const();
    QualType DestType = E.getType();
    QualType SrcType = SubExpr.getType();
    switch (E.getCastKind()) {
     case CK_BaseToDerived:
     case CK_DerivedToBase:
     case CK_UncheckedDerivedToBase:
     case CK_Dynamic:
     case CK_ToUnion:
     case CK_ArrayToPointerDecay:
     case CK_FunctionToPointerDecay:
     case CK_NullToPointer:
     case CK_NullToMemberPointer:
     case CK_BaseToDerivedMemberPointer:
     case CK_DerivedToBaseMemberPointer:
     case CK_ReinterpretMemberPointer:
     case CK_ConstructorConversion:
     case CK_IntegralToPointer:
     case CK_ToVoid:
     case CK_VectorSplat:
     case CK_IntegralToFloating:
     case CK_FloatingCast:
     case CK_CPointerToObjCPointerCast:
     case CK_BlockPointerToObjCPointerCast:
     case CK_AnyPointerToBlockPointerCast:
     case CK_ObjCObjectLValueCast:
     case CK_FloatingRealToComplex:
     case CK_FloatingComplexToReal:
     case CK_FloatingComplexCast:
     case CK_FloatingComplexToIntegralComplex:
     case CK_IntegralRealToComplex:
     case CK_IntegralComplexCast:
     case CK_IntegralComplexToFloatingComplex:
     case CK_BuiltinFnToFnPtr:
     case CK_ZeroToOCLEvent:
     case CK_NonAtomicToAtomic:
     case CK_AddressSpaceConversion:
      throw new llvm_unreachable("invalid cast kind for integral value");
     case CK_BitCast:
     case CK_Dependent:
     case CK_LValueBitCast:
     case CK_ARCProduceObject:
     case CK_ARCConsumeObject:
     case CK_ARCReclaimReturnedObject:
     case CK_ARCExtendBlockObject:
     case CK_CopyAndAutoreleaseBlockObject:
      return Error(E);
     case CK_UserDefinedConversion:
     case CK_LValueToRValue:
     case CK_AtomicToNonAtomic:
     case CK_NoOp:
      return super.VisitCastExpr(E);
     case CK_MemberPointerToBoolean:
     case CK_PointerToBoolean:
     case CK_IntegralToBoolean:
     case CK_FloatingToBoolean:
     case CK_BooleanToSignedIntegral:
     case CK_FloatingComplexToBoolean:
     case CK_IntegralComplexToBoolean:
      {
        bool$ref BoolResult = create_bool$ref();
        if (!EvaluateAsBooleanCondition(SubExpr, BoolResult, Info)) {
          return false;
        }
        long/*uint64_t*/ IntResult = (BoolResult.$deref() ? 1 : 0);
        if (BoolResult.$deref() && E.getCastKind() == CastKind.CK_BooleanToSignedIntegral) {
          IntResult = (long/*uint64_t*/)$int2ulong(-1);
        }
        return Success(IntResult, E);
      }
     case CK_IntegralCast:
      {
        if (!Visit(SubExpr)) {
          return false;
        }
        if (!Result.isInt()) {
          // Allow casts of address-of-label differences if they are no-ops
          // or narrowing.  (The narrowing case isn't actually guaranteed to
          // be constant-evaluatable except in some narrow cases which are hard
          // to detect here.  We let it through on the assumption the user knows
          // what they are doing.)
          if (Result.isAddrLabelDiff()) {
            return $lesseq_ulong(Info.Ctx.getTypeSize(new QualType(DestType)), Info.Ctx.getTypeSize(new QualType(SrcType)));
          }
          // Only allow casts of lvalues if they are lossless.
          return Info.Ctx.getTypeSize(new QualType(DestType)) == Info.Ctx.getTypeSize(new QualType(SrcType));
        }
        
        return Success(HandleIntToIntCast(Info, E, new QualType(DestType), new QualType(SrcType), 
                Result.getInt()), E);
      }
     case CK_PointerToIntegral:
      {
        LValue LV = null;
        try {
          CCEDiag(E, diag.note_constexpr_invalid_cast).$out_int(2);
          
          LV/*J*/= new LValue();
          if (!EvaluatePointer(SubExpr, LV, Info)) {
            return false;
          }
          if (LV.getLValueBase().$bool()) {
            // Only allow based lvalue casts if they are lossless.
            // FIXME: Allow a larger integer size than the pointer size, and allow
            // narrowing back down to pointer width in subsequent integral casts.
            // FIXME: Check integer type's active bits, not its type size.
            if (Info.Ctx.getTypeSize(new QualType(DestType)) != Info.Ctx.getTypeSize(new QualType(SrcType))) {
              return Error(E);
            }
            
            LV.Designator.setInvalid();
            LV.moveInto(Result);
            return true;
          }
          
          APSInt AsInt = Info.Ctx.MakeIntValue(LV.getLValueOffset().getQuantity(), 
              new QualType(SrcType));
          return Success(HandleIntToIntCast(Info, E, new QualType(DestType), new QualType(SrcType), AsInt), E);
        } finally {
          if (LV != null) { LV.$destroy(); }
        }
      }
     case CK_IntegralComplexToReal:
      {
        ComplexValue C = null;
        try {
          C/*J*/= new ComplexValue();
          if (!EvaluateComplex(SubExpr, C, Info)) {
            return false;
          }
          return Success(C.getComplexIntReal(), E);
        } finally {
          if (C != null) { C.$destroy(); }
        }
      }
     case CK_FloatingToIntegral:
      {
        APFloat F/*J*/= new APFloat(0.);
        if (!EvaluateFloat(SubExpr, F, Info)) {
          return false;
        }
        
        APSInt Value/*J*/= new APSInt();
        if (!HandleFloatToIntCast(Info, E, new QualType(SrcType), F, new QualType(DestType), Value)) {
          return false;
        }
        return Success(Value, E);
      }
    }
    throw new llvm_unreachable("unknown cast resulting in integral value");
  }

  
  /// VisitUnaryExprOrTypeTraitExpr - Evaluate a sizeof, alignof or vec_step with
  /// a result as the expression's type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7843,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public boolean VisitUnaryExprOrTypeTraitExpr(/*const*/ UnaryExprOrTypeTraitExpr /*P*/ E) {
    switch (E.getKind()) {
     case UETT_AlignOf:
      {
        if (E.isArgumentType()) {
          return Success(GetAlignOfType(Info, E.getArgumentType()), E);
        } else {
          return Success(GetAlignOfExpr(Info, E.getArgumentExpr$Const()), E);
        }
      }
     case UETT_VecStep:
      {
        QualType Ty = E.getTypeOfArgument();
        if (Ty.$arrow().isVectorType()) {
          /*uint*/int n = Ty.$arrow().castAs(VectorType.class).getNumElements();
          
          // The vec_step built-in functions that take a 3-component
          // vector return 4. (OpenCL 1.1 spec 6.11.12)
          if (n == 3) {
            n = 4;
          }
          
          return Success($uint2ulong(n), E);
        } else {
          return Success(1, E);
        }
      }
     case UETT_SizeOf:
      {
        QualType SrcTy = E.getTypeOfArgument();
        {
          // C++ [expr.sizeof]p2: "When applied to a reference or a reference type,
          //   the result is the size of the referenced type."
          /*const*/ ReferenceType /*P*/ Ref = SrcTy.$arrow().getAs(ReferenceType.class);
          if ((Ref != null)) {
            SrcTy.$assignMove(Ref.getPointeeType());
          }
        }
        
        CharUnits Sizeof/*J*/= new CharUnits();
        if (!HandleSizeof(Info, E.getExprLoc(), new QualType(SrcTy), Sizeof)) {
          return false;
        }
        return Success(new CharUnits(Sizeof), E);
      }
     case UETT_OpenMPRequiredSimdAlign:
      assert (E.isArgumentType());
      return Success(Info.Ctx.toCharUnitsFromBits($uint2long(Info.Ctx.getOpenMPDefaultSimdAlign(E.getArgumentType()))).
              getQuantity(), 
          E);
    }
    throw new llvm_unreachable("unknown expr/type trait");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6262,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitCXXBoolLiteralExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator23VisitCXXBoolLiteralExprEPKN5clang18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator23VisitCXXBoolLiteralExprEPKN5clang18CXXBoolLiteralExprE")
  //</editor-fold>
  public boolean VisitCXXBoolLiteralExpr(/*const*/ CXXBoolLiteralExpr /*P*/ E) {
    return Success((E.getValue() ? 1 : 0), E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6266,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitObjCBoolLiteralExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator24VisitObjCBoolLiteralExprEPKN5clang19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator24VisitObjCBoolLiteralExprEPKN5clang19ObjCBoolLiteralExprE")
  //</editor-fold>
  public boolean VisitObjCBoolLiteralExpr(/*const*/ ObjCBoolLiteralExpr /*P*/ E) {
    return Success((E.getValue() ? 1 : 0), E);
  }

  
  // Note, GNU defines __null as an integer, not a pointer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6271,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitGNUNullExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator16VisitGNUNullExprEPKN5clang11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator16VisitGNUNullExprEPKN5clang11GNUNullExprE")
  //</editor-fold>
  public boolean VisitGNUNullExpr(/*const*/ GNUNullExpr /*P*/ E) {
    return ZeroInitialization(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6275,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitTypeTraitExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator18VisitTypeTraitExprEPKN5clang13TypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator18VisitTypeTraitExprEPKN5clang13TypeTraitExprE")
  //</editor-fold>
  public boolean VisitTypeTraitExpr(/*const*/ TypeTraitExpr /*P*/ E) {
    return Success((E.getValue() ? 1 : 0), E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6279,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitArrayTypeTraitExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator23VisitArrayTypeTraitExprEPKN5clang18ArrayTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator23VisitArrayTypeTraitExprEPKN5clang18ArrayTypeTraitExprE")
  //</editor-fold>
  public boolean VisitArrayTypeTraitExpr(/*const*/ ArrayTypeTraitExpr /*P*/ E) {
    return Success(E.getValue(), E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6283,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitExpressionTraitExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator24VisitExpressionTraitExprEPKN5clang19ExpressionTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator24VisitExpressionTraitExprEPKN5clang19ExpressionTraitExprE")
  //</editor-fold>
  public boolean VisitExpressionTraitExpr(/*const*/ ExpressionTraitExpr /*P*/ E) {
    return Success((E.getValue() ? 1 : 0), E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitUnaryReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8143,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitUnaryReal", NM="_ZN12_GLOBAL__N_116IntExprEvaluator14VisitUnaryRealEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator14VisitUnaryRealEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryReal(/*const*/ UnaryOperator /*P*/ E) {
    if (E.getSubExpr().getType().$arrow().isAnyComplexType()) {
      ComplexValue LV = null;
      try {
        LV/*J*/= new ComplexValue();
        if (!EvaluateComplex(E.getSubExpr(), LV, Info)) {
          return false;
        }
        if (!LV.isComplexInt()) {
          return Error(E);
        }
        return Success(LV.getComplexIntReal(), E);
      } finally {
        if (LV != null) { LV.$destroy(); }
      }
    }
    
    return Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitUnaryImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8156,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitUnaryImag", NM="_ZN12_GLOBAL__N_116IntExprEvaluator14VisitUnaryImagEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator14VisitUnaryImagEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryImag(/*const*/ UnaryOperator /*P*/ E) {
    if (E.getSubExpr().getType().$arrow().isComplexIntegerType()) {
      ComplexValue LV = null;
      try {
        LV/*J*/= new ComplexValue();
        if (!EvaluateComplex(E.getSubExpr(), LV, Info)) {
          return false;
        }
        if (!LV.isComplexInt()) {
          return Error(E);
        }
        return Success(LV.getComplexIntImag(), E);
      } finally {
        if (LV != null) { LV.$destroy(); }
      }
    }
    
    VisitIgnoredValue(E.getSubExpr());
    return Success(0, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8174,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitCXXNoexceptExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator20VisitCXXNoexceptExprEPKN5clang15CXXNoexceptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator20VisitCXXNoexceptExprEPKN5clang15CXXNoexceptExprE")
  //</editor-fold>
  public boolean VisitCXXNoexceptExpr(/*const*/ CXXNoexceptExpr /*P*/ E) {
    return Success((E.getValue() ? 1 : 0), E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::VisitSizeOfPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8170,
   FQN="(anonymous namespace)::IntExprEvaluator::VisitSizeOfPackExpr", NM="_ZN12_GLOBAL__N_116IntExprEvaluator19VisitSizeOfPackExprEPKN5clang14SizeOfPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator19VisitSizeOfPackExprEPKN5clang14SizeOfPackExprE")
  //</editor-fold>
  public boolean VisitSizeOfPackExpr(/*const*/ SizeOfPackExpr /*P*/ E) {
    return Success($uint2ulong(E.getPackLength()), E);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IntExprEvaluator::TryEvaluateBuiltinObjectSize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6816,
   FQN="(anonymous namespace)::IntExprEvaluator::TryEvaluateBuiltinObjectSize", NM="_ZN12_GLOBAL__N_116IntExprEvaluator28TryEvaluateBuiltinObjectSizeEPKN5clang8CallExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_116IntExprEvaluator28TryEvaluateBuiltinObjectSizeEPKN5clang8CallExprEj")
  //</editor-fold>
  private boolean TryEvaluateBuiltinObjectSize(/*const*/ CallExpr /*P*/ E, 
                              /*uint*/int Type) {
    ulong$ref Size = create_ulong$ref(0);
    bool$ptr WasError = create_bool$ptr();
    if (/*::*/tryEvaluateBuiltinObjectSize(E.getArg$Const(0), Type, Info, Size, $AddrOf(WasError))) {
      return Success(Size.$deref(), E);
    }
    if (WasError.$star()) {
      return Error(E);
    }
    return false;
  }

  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
// FIXME: Missing: array subscript of vector, member of vector
}
