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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.PartialDiagnostic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.impl.ExprConstantStatics.describeCall;

/// EvalInfo - This is a private struct used by the evaluator to capture
/// information about a subexpression as it is folded.  It retains information
/// about the AST context, but also maintains information about the folded
/// expression.
///
/// If an expression could be evaluated, it is still possible it is not a C
/// "integer constant expression" or constant expression.  If not, this struct
/// captures information about how and why not.
///
/// One bit of information passed *into* the request for constant folding
/// indicates whether the subexpression is "evaluated" or not according to C
/// rules.  For example, the RHS of (0 && foo()) is not evaluated.  We can
/// evaluate the expression regardless of what the RHS is, but C only allows
/// certain things in certain situations.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 436,
 FQN="(anonymous namespace)::EvalInfo", NM="_ZN12_GLOBAL__N_18EvalInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfoE")
//</editor-fold>
public class/*struct*/ EvalInfo implements Destructors.ClassWithDestructor {
  public final ASTContext /*&*/ Ctx;
  
  /// EvalStatus - Contains information about the evaluation.
  public final Expr.EvalStatus /*&*/ EvalStatus;
  
  /// CurrentCall - The top of the constexpr call stack.
  public CallStackFrame /*P*/ CurrentCall;
  
  /// CallStackDepth - The number of calls in the call stack right now.
  public /*uint*/int CallStackDepth;
  
  /// NextCallIndex - The next call index to assign.
  public /*uint*/int NextCallIndex;
  
  /// StepsLeft - The remaining number of evaluation steps we're permitted
  /// to perform. This is essentially a limit for the number of statements
  /// we will evaluate.
  public /*uint*/int StepsLeft;
  
  /// BottomFrame - The frame in which evaluation started. This must be
  /// initialized after CurrentCall and CallStackDepth.
  public CallStackFrame BottomFrame;
  
  /// A stack of values whose lifetimes end at the end of some surrounding
  /// evaluation frame.
  public SmallVector<Cleanup> CleanupStack;
  
  /// EvaluatingDecl - This is the declaration whose initializer is being
  /// evaluated, if any.
  public PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > EvaluatingDecl;
  
  /// EvaluatingDeclValue - This is the value being constructed for the
  /// declaration whose initializer is being evaluated, if any.
  public APValue /*P*/ EvaluatingDeclValue;
  
  /// HasActiveDiagnostic - Was the previous diagnostic stored? If so, further
  /// notes attached to it will also be stored, otherwise they will not be.
  public boolean HasActiveDiagnostic;
  
  /// \brief Have we emitted a diagnostic explaining why we couldn't constant
  /// fold (not just why it's not strictly a constant expression)?
  public boolean HasFoldFailureDiagnostic;
  
  /// \brief Whether or not we're currently speculatively evaluating.
  public boolean IsSpeculativelyEvaluating;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::EvaluationMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 483,
   FQN="(anonymous namespace)::EvalInfo::EvaluationMode", NM="_ZN12_GLOBAL__N_18EvalInfo14EvaluationModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo14EvaluationModeE")
  //</editor-fold>
  public enum EvaluationMode implements Native.ComparableLower {
    /// Evaluate as a constant expression. Stop if we find that the expression
    /// is not a constant expression.
    EM_ConstantExpression(0),
    
    /// Evaluate as a potential constant expression. Keep going if we hit a
    /// construct that we can't evaluate yet (because we don't yet know the
    /// value of something) but stop if we hit something that could never be
    /// a constant expression.
    EM_PotentialConstantExpression(EM_ConstantExpression.getValue() + 1),
    
    /// Fold the expression to a constant. Stop if we hit a side-effect that
    /// we can't model.
    EM_ConstantFold(EM_PotentialConstantExpression.getValue() + 1),
    
    /// Evaluate the expression looking for integer overflow and similar
    /// issues. Don't worry about side-effects, and try to visit all
    /// subexpressions.
    EM_EvaluateForOverflow(EM_ConstantFold.getValue() + 1),
    
    /// Evaluate in any way we know how. Don't worry about side-effects that
    /// can't be modeled.
    EM_IgnoreSideEffects(EM_EvaluateForOverflow.getValue() + 1),
    
    /// Evaluate as a constant expression. Stop if we find that the expression
    /// is not a constant expression. Some expressions can be retried in the
    /// optimizer if we don't constant fold them here, but in an unevaluated
    /// context we try to fold them immediately since the optimizer never
    /// gets a chance to look at it.
    EM_ConstantExpressionUnevaluated(EM_IgnoreSideEffects.getValue() + 1),
    
    /// Evaluate as a potential constant expression. Keep going if we hit a
    /// construct that we can't evaluate yet (because we don't yet know the
    /// value of something) but stop if we hit something that could never be
    /// a constant expression. Some expressions can be retried in the
    /// optimizer if we don't constant fold them here, but in an unevaluated
    /// context we try to fold them immediately since the optimizer never
    /// gets a chance to look at it.
    EM_PotentialConstantExpressionUnevaluated(EM_ConstantExpressionUnevaluated.getValue() + 1),
    
    /// Evaluate as a constant expression. Continue evaluating if we find a
    /// MemberExpr with a base that can't be evaluated.
    EM_DesignatorFold(EM_PotentialConstantExpressionUnevaluated.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static EvaluationMode valueOf(int val) {
      EvaluationMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final EvaluationMode[] VALUES;
      private static final EvaluationMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (EvaluationMode kind : EvaluationMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new EvaluationMode[min < 0 ? (1-min) : 0];
        VALUES = new EvaluationMode[max >= 0 ? (1+max) : 0];
        for (EvaluationMode kind : EvaluationMode.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private EvaluationMode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((EvaluationMode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((EvaluationMode)obj).value);}
    //</editor-fold>
  };
  
  public  EvaluationMode EvalMode;
  
  /// Are we checking whether the expression is a potential constant
  /// expression?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::checkingPotentialConstantExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 530,
   FQN="(anonymous namespace)::EvalInfo::checkingPotentialConstantExpression", NM="_ZNK12_GLOBAL__N_18EvalInfo35checkingPotentialConstantExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_18EvalInfo35checkingPotentialConstantExpressionEv")
  //</editor-fold>
  public boolean checkingPotentialConstantExpression() /*const*/ {
    return EvalMode == EvaluationMode.EM_PotentialConstantExpression
       || EvalMode == EvaluationMode.EM_PotentialConstantExpressionUnevaluated;
  }

  
  /// Are we checking an expression for overflow?
  // FIXME: We should check for any kind of undefined or suspicious behavior
  // in such constructs, not just overflow.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::checkingForOverflow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 538,
   FQN="(anonymous namespace)::EvalInfo::checkingForOverflow", NM="_ZN12_GLOBAL__N_18EvalInfo19checkingForOverflowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo19checkingForOverflowEv")
  //</editor-fold>
  public boolean checkingForOverflow() {
    return EvalMode == EvaluationMode.EM_EvaluateForOverflow;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::EvalInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 540,
   FQN="(anonymous namespace)::EvalInfo::EvalInfo", NM="_ZN12_GLOBAL__N_18EvalInfoC1ERKN5clang10ASTContextERNS1_4Expr10EvalStatusENS0_14EvaluationModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfoC1ERKN5clang10ASTContextERNS1_4Expr10EvalStatusENS0_14EvaluationModeE")
  //</editor-fold>
  public EvalInfo(final /*const*/ ASTContext /*&*/ C, final Expr.EvalStatus /*&*/ S, EvaluationMode Mode) {
    // : Ctx(const_cast<ASTContext & >(C)), EvalStatus(S), CurrentCall(null), CallStackDepth(0), NextCallIndex(1), StepsLeft(getLangOpts().ConstexprStepLimit), BottomFrame(*this, SourceLocation(), null, null, null), CleanupStack(), EvaluatingDecl((const ValueDecl * )null), EvaluatingDeclValue(null), HasActiveDiagnostic(false), HasFoldFailureDiagnostic(false), IsSpeculativelyEvaluating(false), EvalMode(Mode) 
    //START JInit
    this./*&*/Ctx=/*&*/((/*const_cast*/ASTContext /*&*/ )(C));
    this./*&*/EvalStatus=/*&*/S;
    this.CurrentCall = null;
    this.CallStackDepth = 0;
    this.NextCallIndex = 1;
    this.StepsLeft = getLangOpts().ConstexprStepLimit;
    this.BottomFrame = new CallStackFrame(/*Deref*/this, new SourceLocation(), (/*const*/ FunctionDecl /*P*/ )null, (/*const*/ LValue /*P*/ )null, create_type$null$ptr());
    this.CleanupStack = new SmallVector<Cleanup>(16, new Cleanup());
    this.EvaluatingDecl = new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T.INSTANCE, /*const*/ ValueDecl /*P*/ .class, (/*const*/ ValueDecl /*P*/ )null);
    this.EvaluatingDeclValue = null;
    this.HasActiveDiagnostic = false;
    this.HasFoldFailureDiagnostic = false;
    this.IsSpeculativelyEvaluating = false;
    this.EvalMode = Mode;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::setEvaluatingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 550,
   FQN="(anonymous namespace)::EvalInfo::setEvaluatingDecl", NM="_ZN12_GLOBAL__N_18EvalInfo17setEvaluatingDeclEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEERNS3_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo17setEvaluatingDeclEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEERNS3_7APValueE")
  //</editor-fold>
  public void setEvaluatingDecl(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > Base, final APValue /*&*/ Value) {
    EvaluatingDecl.$assign(Base);
    EvaluatingDeclValue = $AddrOf(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 555,
   FQN="(anonymous namespace)::EvalInfo::getLangOpts", NM="_ZNK12_GLOBAL__N_18EvalInfo11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_18EvalInfo11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return Ctx.getLangOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::CheckCallLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 557,
   FQN="(anonymous namespace)::EvalInfo::CheckCallLimit", NM="_ZN12_GLOBAL__N_18EvalInfo14CheckCallLimitEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo14CheckCallLimitEN5clang14SourceLocationE")
  //</editor-fold>
  public boolean CheckCallLimit(SourceLocation Loc) {
    // Don't perform any constexpr calls (other than the call we're checking)
    // when checking a potential constant expression.
    if (checkingPotentialConstantExpression() && $greater_uint(CallStackDepth, 1)) {
      return false;
    }
    if (NextCallIndex == 0) {
      // NextCallIndex has wrapped around.
      FFDiag(new SourceLocation(Loc), diag.note_constexpr_call_limit_exceeded);
      return false;
    }
    if ($lesseq_uint(CallStackDepth, getLangOpts().ConstexprCallDepth)) {
      return true;
    }
    FFDiag(new SourceLocation(Loc), diag.note_constexpr_depth_limit_exceeded).$out_uint(
        getLangOpts().ConstexprCallDepth
    );
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::getCallFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 574,
   FQN="(anonymous namespace)::EvalInfo::getCallFrame", NM="_ZN12_GLOBAL__N_18EvalInfo12getCallFrameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo12getCallFrameEj")
  //</editor-fold>
  public CallStackFrame /*P*/ getCallFrame(/*uint*/int CallIndex) {
    assert ((CallIndex != 0)) : "no call index in getCallFrame";
    // We will eventually hit BottomFrame, which has Index 1, so Frame can't
    // be null in this loop.
    CallStackFrame /*P*/ Frame = CurrentCall;
    while ($greater_uint(Frame.Index, CallIndex)) {
      Frame = Frame.Caller;
    }
    return (Frame.Index == CallIndex) ? Frame : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::nextStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 584,
   FQN="(anonymous namespace)::EvalInfo::nextStep", NM="_ZN12_GLOBAL__N_18EvalInfo8nextStepEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo8nextStepEPKN5clang4StmtE")
  //</editor-fold>
  public boolean nextStep(/*const*/ Stmt /*P*/ S) {
    if (!(StepsLeft != 0)) {
      FFDiag(S.getLocStart(), diag.note_constexpr_step_limit_exceeded);
      return false;
    }
    --StepsLeft;
    return true;
  }

/*private:*/
  /// Add a diagnostic to the diagnostics list.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::addDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 595,
   FQN="(anonymous namespace)::EvalInfo::addDiag", NM="_ZN12_GLOBAL__N_18EvalInfo7addDiagEN5clang14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo7addDiagEN5clang14SourceLocationEj")
  //</editor-fold>
  private PartialDiagnostic /*&*/ addDiag(SourceLocation Loc, /*uint*/int DiagId) {
    PartialDiagnostic PD = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      PD/*J*/= new PartialDiagnostic(DiagId, Ctx.getDiagAllocator());
      EvalStatus.Diag.push_back_T$RR($c$.track(std.make_pair($Clone(Loc), $Clone(PD)))); $c$.clean();
      return EvalStatus.Diag.back().second;
    } finally {
      if (PD != null) { PD.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Add notes containing a call stack to the current point of evaluation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::addCallStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 986,
   FQN="(anonymous namespace)::EvalInfo::addCallStack", NM="_ZN12_GLOBAL__N_18EvalInfo12addCallStackEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo12addCallStackEj")
  //</editor-fold>
  private void addCallStack(/*uint*/int Limit) {
    // Determine which calls to skip, if any.
    /*uint*/int ActiveCalls = CallStackDepth - 1;
    /*uint*/int SkipStart = ActiveCalls, SkipEnd = SkipStart;
    if ((Limit != 0) && $less_uint(Limit, ActiveCalls)) {
      SkipStart = $div_uint(Limit, 2) + $rem_uint(Limit, 2);
      SkipEnd = ActiveCalls - $div_uint(Limit, 2);
    }
    
    // Walk the call stack and add the diagnostics.
    /*uint*/int CallIdx = 0;
    for (CallStackFrame /*P*/ Frame = CurrentCall; Frame != $AddrOf(BottomFrame);
         Frame = Frame.Caller , ++CallIdx) {
      raw_svector_ostream Out = null;
      try {
        // Skip this call?
        if ($greatereq_uint(CallIdx, SkipStart) && $less_uint(CallIdx, SkipEnd)) {
          if (CallIdx == SkipStart) {
            // Note that we're skipping calls.
            $out_PartialDiagnostic$C_uint(addDiag(new SourceLocation(Frame.CallLoc), diag.note_constexpr_calls_suppressed), 
                ((/*uint*/int)(ActiveCalls - Limit)));
          }
          continue;
        }
        {
          
          // Use a different note for an inheriting constructor, because from the
          // user's perspective it's not really a function at all.
          /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_or_null_CXXConstructorDecl(Frame.Callee);
          if ((CD != null)) {
            if (CD.isInheritingConstructor()) {
              $out_PartialDiagnostic$C_NamedDecl$C$P(addDiag(new SourceLocation(Frame.CallLoc), diag.note_constexpr_inherited_ctor_call_here), 
                  CD.getParent$Const());
              continue;
            }
          }
        }
        
        SmallString Buffer/*J*/= new SmallString(128);
        Out/*J*/= new raw_svector_ostream(Buffer);
        describeCall(Frame, Out);
        $out_PartialDiagnostic$C_StringRef(addDiag(new SourceLocation(Frame.CallLoc), diag.note_constexpr_call_here), Out.str());
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 605,
   FQN="(anonymous namespace)::EvalInfo::Diag", NM="_ZN12_GLOBAL__N_18EvalInfo4DiagEN5clang14SourceLocationEjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo4DiagEN5clang14SourceLocationEjjb")
  //</editor-fold>
  private OptionalDiagnostic Diag(SourceLocation Loc, /*uint*/int DiagId, 
      /*uint*/int ExtraNotes, boolean IsCCEDiag) {
    if ((EvalStatus.Diag != null)) {
      // If we have a prior diagnostic, it will be noting that the expression
      // isn't a constant expression. This diagnostic is more important,
      // unless we require this evaluation to produce a constant expression.
      //
      // FIXME: We might want to show both diagnostics to the user in
      // EM_ConstantFold mode.
      if (!EvalStatus.Diag.empty()) {
        switch (EvalMode) {
         case EM_ConstantFold:
         case EM_IgnoreSideEffects:
         case EM_EvaluateForOverflow:
          if (!HasFoldFailureDiagnostic) {
            break;
          }
         case EM_ConstantExpression:
         case EM_PotentialConstantExpression:
         case EM_ConstantExpressionUnevaluated:
         case EM_PotentialConstantExpressionUnevaluated:
         case EM_DesignatorFold:
          // We've already failed to fold something. Keep that diagnostic.
          HasActiveDiagnostic = false;
          return new OptionalDiagnostic();
        }
      }
      
      /*uint*/int CallStackNotes = CallStackDepth - 1;
      /*uint*/int Limit = Ctx.getDiagnostics().getConstexprBacktraceLimit();
      if ((Limit != 0)) {
        CallStackNotes = std.min_uint(CallStackNotes, Limit + 1);
      }
      if (checkingPotentialConstantExpression()) {
        CallStackNotes = 0;
      }
      
      HasActiveDiagnostic = true;
      HasFoldFailureDiagnostic = !IsCCEDiag;
      EvalStatus.Diag.clear();
      EvalStatus.Diag.reserve(1 + ExtraNotes + CallStackNotes);
      addDiag(new SourceLocation(Loc), DiagId);
      if (!checkingPotentialConstantExpression()) {
        addCallStack(Limit);
      }
      return new OptionalDiagnostic($AddrOf((/*Deref*/EvalStatus.Diag).$at(0).second));
    }
    HasActiveDiagnostic = false;
    return new OptionalDiagnostic();
  }

/*public:*/
  // Diagnose that the evaluation could not be folded (FF => FoldFailure)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::FFDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 654,
   FQN="(anonymous namespace)::EvalInfo::FFDiag", NM="_ZN12_GLOBAL__N_18EvalInfo6FFDiagEN5clang14SourceLocationEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo6FFDiagEN5clang14SourceLocationEjj")
  //</editor-fold>
  public OptionalDiagnostic FFDiag(SourceLocation Loc) {
    return FFDiag(Loc, 
        diag.note_invalid_subexpr_in_const_expr, 
        0);
  }
  public OptionalDiagnostic FFDiag(SourceLocation Loc, 
        /*uint*/int DiagId/*= diag::note_invalid_subexpr_in_const_expr*/) {
    return FFDiag(Loc, 
        DiagId, 
        0);
  }
  public OptionalDiagnostic FFDiag(SourceLocation Loc, 
        /*uint*/int DiagId/*= diag::note_invalid_subexpr_in_const_expr*/, 
        /*uint*/int ExtraNotes/*= 0*/) {
    return Diag(new SourceLocation(Loc), DiagId, ExtraNotes, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::FFDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 661,
   FQN="(anonymous namespace)::EvalInfo::FFDiag", NM="_ZN12_GLOBAL__N_18EvalInfo6FFDiagEPKN5clang4ExprEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo6FFDiagEPKN5clang4ExprEjj")
  //</editor-fold>
  public OptionalDiagnostic FFDiag(/*const*/ Expr /*P*/ E) {
    return FFDiag(E, diag.note_invalid_subexpr_in_const_expr, 
        0);
  }
  public OptionalDiagnostic FFDiag(/*const*/ Expr /*P*/ E, /*uint*/int DiagId/*= diag::note_invalid_subexpr_in_const_expr*/) {
    return FFDiag(E, DiagId, 
        0);
  }
  public OptionalDiagnostic FFDiag(/*const*/ Expr /*P*/ E, /*uint*/int DiagId/*= diag::note_invalid_subexpr_in_const_expr*/, 
        /*uint*/int ExtraNotes/*= 0*/) {
    if ((EvalStatus.Diag != null)) {
      return Diag(E.getExprLoc(), DiagId, ExtraNotes, /*IsCCEDiag*/ false);
    }
    HasActiveDiagnostic = false;
    return new OptionalDiagnostic();
  }

  
  /// Diagnose that the evaluation does not produce a C++11 core constant
  /// expression.
  ///
  /// FIXME: Stop evaluating if we're in EM_ConstantExpression or
  /// EM_PotentialConstantExpression mode and we produce one of these.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::CCEDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 675,
   FQN="(anonymous namespace)::EvalInfo::CCEDiag", NM="_ZN12_GLOBAL__N_18EvalInfo7CCEDiagEN5clang14SourceLocationEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo7CCEDiagEN5clang14SourceLocationEjj")
  //</editor-fold>
  public OptionalDiagnostic CCEDiag(SourceLocation Loc) {
    return CCEDiag(Loc, diag.note_invalid_subexpr_in_const_expr, 
         0);
  }
  public OptionalDiagnostic CCEDiag(SourceLocation Loc, /*uint*/int DiagId/*= diag::note_invalid_subexpr_in_const_expr*/) {
    return CCEDiag(Loc, DiagId, 
         0);
  }
  public OptionalDiagnostic CCEDiag(SourceLocation Loc, /*uint*/int DiagId/*= diag::note_invalid_subexpr_in_const_expr*/, 
         /*uint*/int ExtraNotes/*= 0*/) {
    // Don't override a previous diagnostic. Don't bother collecting
    // diagnostics if we're evaluating for overflow.
    if (!(EvalStatus.Diag != null) || !EvalStatus.Diag.empty()) {
      HasActiveDiagnostic = false;
      return new OptionalDiagnostic();
    }
    return Diag(new SourceLocation(Loc), DiagId, ExtraNotes, true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::CCEDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 686,
   FQN="(anonymous namespace)::EvalInfo::CCEDiag", NM="_ZN12_GLOBAL__N_18EvalInfo7CCEDiagEPKN5clang4ExprEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo7CCEDiagEPKN5clang4ExprEjj")
  //</editor-fold>
  public OptionalDiagnostic CCEDiag(/*const*/ Expr /*P*/ E) {
    return CCEDiag(E, diag.note_invalid_subexpr_in_const_expr, 
         0);
  }
  public OptionalDiagnostic CCEDiag(/*const*/ Expr /*P*/ E, /*uint*/int DiagId/*= diag::note_invalid_subexpr_in_const_expr*/) {
    return CCEDiag(E, DiagId, 
         0);
  }
  public OptionalDiagnostic CCEDiag(/*const*/ Expr /*P*/ E, /*uint*/int DiagId/*= diag::note_invalid_subexpr_in_const_expr*/, 
         /*uint*/int ExtraNotes/*= 0*/) {
    return CCEDiag(E.getExprLoc(), DiagId, ExtraNotes);
  }

  /// Add a note to a prior diagnostic.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::Note">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 692,
   FQN="(anonymous namespace)::EvalInfo::Note", NM="_ZN12_GLOBAL__N_18EvalInfo4NoteEN5clang14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo4NoteEN5clang14SourceLocationEj")
  //</editor-fold>
  public OptionalDiagnostic Note(SourceLocation Loc, /*uint*/int DiagId) {
    if (!HasActiveDiagnostic) {
      return new OptionalDiagnostic();
    }
    return new OptionalDiagnostic($AddrOf(addDiag(new SourceLocation(Loc), DiagId)));
  }

  
  /// Add a stack of notes to a prior diagnostic.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::addNotes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 699,
   FQN="(anonymous namespace)::EvalInfo::addNotes", NM="_ZN12_GLOBAL__N_18EvalInfo8addNotesEN4llvm8ArrayRefISt4pairIN5clang14SourceLocationENS4_17PartialDiagnosticEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo8addNotesEN4llvm8ArrayRefISt4pairIN5clang14SourceLocationENS4_17PartialDiagnosticEEEE")
  //</editor-fold>
  public void addNotes(ArrayRef<std.pairTypeType<SourceLocation, PartialDiagnostic>> Diags) {
    if (HasActiveDiagnostic) {
      EvalStatus.Diag.insert$T$value_T(EvalStatus.Diag.end(), 
          Diags.begin(), Diags.end());
    }
  }

  
  /// Should we continue evaluation after encountering a side-effect that we
  /// couldn't model?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::keepEvaluatingAfterSideEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 708,
   FQN="(anonymous namespace)::EvalInfo::keepEvaluatingAfterSideEffect", NM="_ZN12_GLOBAL__N_18EvalInfo29keepEvaluatingAfterSideEffectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo29keepEvaluatingAfterSideEffectEv")
  //</editor-fold>
  public boolean keepEvaluatingAfterSideEffect() {
    switch (EvalMode) {
     case EM_PotentialConstantExpression:
     case EM_PotentialConstantExpressionUnevaluated:
     case EM_EvaluateForOverflow:
     case EM_IgnoreSideEffects:
      return true;
     case EM_ConstantExpression:
     case EM_ConstantExpressionUnevaluated:
     case EM_ConstantFold:
     case EM_DesignatorFold:
      return false;
    }
    throw new llvm_unreachable("Missed EvalMode case");
  }

  
  /// Note that we have had a side-effect, and determine whether we should
  /// keep evaluating.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::noteSideEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 727,
   FQN="(anonymous namespace)::EvalInfo::noteSideEffect", NM="_ZN12_GLOBAL__N_18EvalInfo14noteSideEffectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo14noteSideEffectEv")
  //</editor-fold>
  public boolean noteSideEffect() {
    EvalStatus.HasSideEffects = true;
    return keepEvaluatingAfterSideEffect();
  }

  
  /// Should we continue evaluation after encountering undefined behavior?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::keepEvaluatingAfterUndefinedBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 733,
   FQN="(anonymous namespace)::EvalInfo::keepEvaluatingAfterUndefinedBehavior", NM="_ZN12_GLOBAL__N_18EvalInfo36keepEvaluatingAfterUndefinedBehaviorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo36keepEvaluatingAfterUndefinedBehaviorEv")
  //</editor-fold>
  public boolean keepEvaluatingAfterUndefinedBehavior() {
    switch (EvalMode) {
     case EM_EvaluateForOverflow:
     case EM_IgnoreSideEffects:
     case EM_ConstantFold:
     case EM_DesignatorFold:
      return true;
     case EM_PotentialConstantExpression:
     case EM_PotentialConstantExpressionUnevaluated:
     case EM_ConstantExpression:
     case EM_ConstantExpressionUnevaluated:
      return false;
    }
    throw new llvm_unreachable("Missed EvalMode case");
  }

  
  /// Note that we hit something that was technically undefined behavior, but
  /// that we can evaluate past it (such as signed overflow or floating-point
  /// division by zero.)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::noteUndefinedBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 753,
   FQN="(anonymous namespace)::EvalInfo::noteUndefinedBehavior", NM="_ZN12_GLOBAL__N_18EvalInfo21noteUndefinedBehaviorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo21noteUndefinedBehaviorEv")
  //</editor-fold>
  public boolean noteUndefinedBehavior() {
    EvalStatus.HasUndefinedBehavior = true;
    return keepEvaluatingAfterUndefinedBehavior();
  }

  
  /// Should we continue evaluation as much as possible after encountering a
  /// construct which can't be reduced to a value?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::keepEvaluatingAfterFailure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 760,
   FQN="(anonymous namespace)::EvalInfo::keepEvaluatingAfterFailure", NM="_ZN12_GLOBAL__N_18EvalInfo26keepEvaluatingAfterFailureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo26keepEvaluatingAfterFailureEv")
  //</editor-fold>
  public boolean keepEvaluatingAfterFailure() {
    if (!(StepsLeft != 0)) {
      return false;
    }
    switch (EvalMode) {
     case EM_PotentialConstantExpression:
     case EM_PotentialConstantExpressionUnevaluated:
     case EM_EvaluateForOverflow:
      return true;
     case EM_ConstantExpression:
     case EM_ConstantExpressionUnevaluated:
     case EM_ConstantFold:
     case EM_IgnoreSideEffects:
     case EM_DesignatorFold:
      return false;
    }
    throw new llvm_unreachable("Missed EvalMode case");
  }

  
  /// Notes that we failed to evaluate an expression that other expressions
  /// directly depend on, and determine if we should keep evaluating. This
  /// should only be called if we actually intend to keep evaluating.
  ///
  /// Call noteSideEffect() instead if we may be able to ignore the value that
  /// we failed to evaluate, e.g. if we failed to evaluate Foo() in:
  ///
  /// (Foo(), 1)      // use noteSideEffect
  /// (Foo() || true) // use noteSideEffect
  /// Foo() + 1       // use noteFailure
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::noteFailure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 790,
   FQN="(anonymous namespace)::EvalInfo::noteFailure", NM="_ZN12_GLOBAL__N_18EvalInfo11noteFailureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfo11noteFailureEv")
  //</editor-fold>
  public boolean noteFailure()/* __attribute__((warn_unused_result))*/ {
    // Failure when evaluating some expression often means there is some
    // subexpression whose evaluation was skipped. Therefore, (because we
    // don't track whether we skipped an expression when unwinding after an
    // evaluation failure) every evaluation failure that bubbles up from a
    // subexpression implies that a side-effect has potentially happened. We
    // skip setting the HasSideEffects flag to true until we decide to
    // continue evaluating after that point, which happens here.
    boolean KeepGoing = keepEvaluatingAfterFailure();
    EvalStatus.HasSideEffects |= KeepGoing;
    return KeepGoing;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::allowInvalidBaseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 803,
   FQN="(anonymous namespace)::EvalInfo::allowInvalidBaseExpr", NM="_ZNK12_GLOBAL__N_18EvalInfo20allowInvalidBaseExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_18EvalInfo20allowInvalidBaseExprEv")
  //</editor-fold>
  public boolean allowInvalidBaseExpr() /*const*/ {
    return EvalMode == EvaluationMode.EM_DesignatorFold;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvalInfo::~EvalInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 436,
   FQN="(anonymous namespace)::EvalInfo::~EvalInfo", NM="_ZN12_GLOBAL__N_18EvalInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_18EvalInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CleanupStack.$destroy();
    BottomFrame.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", EvalStatus=" + EvalStatus // NOI18N
              + ", CurrentCall=" + CurrentCall // NOI18N
              + ", CallStackDepth=" + CallStackDepth // NOI18N
              + ", NextCallIndex=" + NextCallIndex // NOI18N
              + ", StepsLeft=" + StepsLeft // NOI18N
              + ", BottomFrame=" + BottomFrame // NOI18N
              + ", CleanupStack=" + CleanupStack // NOI18N
              + ", EvaluatingDecl=" + EvaluatingDecl // NOI18N
              + ", EvaluatingDeclValue=" + EvaluatingDeclValue // NOI18N
              + ", HasActiveDiagnostic=" + HasActiveDiagnostic // NOI18N
              + ", HasFoldFailureDiagnostic=" + HasFoldFailureDiagnostic // NOI18N
              + ", IsSpeculativelyEvaluating=" + IsSpeculativelyEvaluating // NOI18N
              + ", EvalMode=" + EvalMode; // NOI18N
  }
}
