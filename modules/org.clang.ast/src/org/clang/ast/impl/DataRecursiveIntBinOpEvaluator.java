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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.impl.ExprConstantStatics.*;


/// \brief Data recursive integer evaluator of certain binary operators.
///
/// We use a data recursive algorithm for binary operators so that we are able
/// to handle extreme cases of chained binary operators without causing stack
/// overflow.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7143,
 FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluatorE")
//</editor-fold>
public class DataRecursiveIntBinOpEvaluator implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7144,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResultE")
  //</editor-fold>
  private static class/*struct*/ EvalResult implements Destructors.ClassWithDestructor {
    public APValue Val;
    public boolean Failed;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult::EvalResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7148,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult::EvalResult", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResultC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResultC1Ev")
    //</editor-fold>
    public EvalResult() {
      // : Val(), Failed(false) 
      //START JInit
      this.Val = new APValue();
      this.Failed = false;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult::swap">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7150,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult::swap", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResult4swapERS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResult4swapERS1_")
    //</editor-fold>
    public void swap(final EvalResult /*&*/ RHS) {
      Val.swap(RHS.Val);
      Failed = RHS.Failed;
      RHS.Failed = false;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult::~EvalResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7144,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult::~EvalResult", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResultD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResultD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Val.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult::EvalResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7144,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvalResult::EvalResult", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResultC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10EvalResultC1ERKS1_")
    //</editor-fold>
    public /*inline*/ EvalResult(final /*const*/ EvalResult /*&*/ $Prm0) {
      // : Val(.Val), Failed(.Failed) 
      //START JInit
      this.Val = new APValue($Prm0.Val);
      this.Failed = $Prm0.Failed;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Val=" + Val // NOI18N
                + ", Failed=" + Failed; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7157,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobE")
  //</editor-fold>
  private static class/*struct*/ Job implements Destructors.ClassWithDestructor, NativeCloneable<Job>, NativeMoveable<Job> {
    public /*const*/ Expr /*P*/ E;
    public EvalResult LHSResult; // meaningful only for binary operator expression.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7160,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::(anonymous)", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobE_Unnamed_enum")
    //</editor-fold>
    public enum Unnamed_enum implements Native.ComparableLower {
      AnyExprKind(0),
      BinOpKind(AnyExprKind.getValue() + 1),
      BinOpVisitedLHSKind(BinOpKind.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Unnamed_enum valueOf(int val) {
        Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Unnamed_enum[] VALUES;
        private static final Unnamed_enum[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
          VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
      //</editor-fold>
    };
    public Unnamed_enum Kind = Unnamed_enum.AnyExprKind;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::Job">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7162,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::Job", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobC1Ev")
    //</editor-fold>
    public Job() {
      // : LHSResult(), SpecEvalRAII()/* = default*/ 
      //START JInit
      this.LHSResult = new EvalResult();
      this.SpecEvalRAII = new SpeculativeEvaluationRAII();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::Job">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7163,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::Job", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobC1EOS1_")
    //</editor-fold>
    public Job(JD$Move _dparam, final Job /*&&*/J) {
      // : E(J.E), LHSResult(J.LHSResult), Kind(J.Kind), SpecEvalRAII(std::move(J.SpecEvalRAII)) 
      //START JInit
      this.E = J.E;
      this.LHSResult = new EvalResult(J.LHSResult);
      this.Kind = J.Kind;
      this.SpecEvalRAII = new SpeculativeEvaluationRAII(JD$Move.INSTANCE, std.move(J.SpecEvalRAII));
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::startSpeculativeEval">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7167,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::startSpeculativeEval", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3Job20startSpeculativeEvalERNS_8EvalInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3Job20startSpeculativeEvalERNS_8EvalInfoE")
    //</editor-fold>
    public void startSpeculativeEval(final EvalInfo /*&*/ Info) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SpecEvalRAII.$assignMove($c$.track(new SpeculativeEvaluationRAII(Info))));
      } finally {
        $c$.$destroy();
      }
    }

  /*private:*/
    private SpeculativeEvaluationRAII SpecEvalRAII;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::~Job">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7157,
     FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Job::~Job", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator3JobD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      SpecEvalRAII.$destroy();
      LHSResult.$destroy();
      //END JDestroy
    }

    @Override public Job move() { return new Job(JD$Move.INSTANCE, this); }
    @Override public Job clone() { 
      assert this == EMPTY : "should clone only empty objects from defaultValue of collections";
      return new Job(); 
    }
    private static final Job EMPTY = new Job();
    
    @Override public String toString() {
      return "" + "E=" + E // NOI18N
                + ", LHSResult=" + LHSResult // NOI18N
                + ", Kind=" + Kind // NOI18N
                + ", SpecEvalRAII=" + SpecEvalRAII; // NOI18N
    }
  };
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*with destroy*/)
  private SmallVector<Job> Queue;
  
  private final IntExprEvaluator /*&*/ IntEval;
  private final EvalInfo /*&*/ Info;
  private final APValue /*&*/ FinalResult;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::DataRecursiveIntBinOpEvaluator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7182,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::DataRecursiveIntBinOpEvaluator", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluatorC1ERNS_16IntExprEvaluatorERN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluatorC1ERNS_16IntExprEvaluatorERN5clang7APValueE")
  //</editor-fold>
  public DataRecursiveIntBinOpEvaluator(final IntExprEvaluator /*&*/ IntEval, final APValue /*&*/ Result) {
    // : Queue(), IntEval(IntEval), Info(IntEval.getEvalInfo()), FinalResult(Result) 
    //START JInit
    this.Queue = new SmallVector<Job>(16, Job.EMPTY);
    this./*&*/IntEval=/*&*/IntEval;
    this./*&*/Info=/*&*/IntEval.getEvalInfo();
    this./*&*/FinalResult=/*&*/Result;
    //END JInit
  }

  
  /// \brief True if \param E is a binary operator that we are going to handle
  /// data recursively.
  /// We handle binary operators that are comma, logical, or that have operands
  /// with integral or enumeration type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::shouldEnqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7189,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::shouldEnqueue", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator13shouldEnqueueEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator13shouldEnqueueEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public static boolean shouldEnqueue(/*const*/ BinaryOperator /*P*/ E) {
    return E.getOpcode() == BinaryOperatorKind.BO_Comma
       || E.isLogicalOp()
       || (E.isRValue()
       && E.getType().$arrow().isIntegralOrEnumerationType()
       && E.getLHS().getType().$arrow().isIntegralOrEnumerationType()
       && E.getRHS().getType().$arrow().isIntegralOrEnumerationType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Traverse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7198,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Traverse", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator8TraverseEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator8TraverseEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean Traverse(/*const*/ BinaryOperator /*P*/ E) {
    EvalResult PrevResult = null;
    try {
      enqueue(E);
      PrevResult/*J*/= new EvalResult();
      while (!Queue.empty()) {
        process(PrevResult);
      }
      if (PrevResult.Failed) {
        return false;
      }
      
      FinalResult.swap(PrevResult.Val);
      return true;
    } finally {
      if (PrevResult != null) { PrevResult.$destroy(); }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7211,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Success", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7SuccessEyPKN5clang4ExprERNS1_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7SuccessEyPKN5clang4ExprERNS1_7APValueE")
  //</editor-fold>
  private boolean Success(long/*uint64_t*/ Value, /*const*/ Expr /*P*/ E, final APValue /*&*/ Result) {
    return IntEval.Success(Value, E, Result);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7214,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Success", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7SuccessERKN4llvm6APSIntEPKN5clang4ExprERNS5_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7SuccessERKN4llvm6APSIntEPKN5clang4ExprERNS5_7APValueE")
  //</editor-fold>
  private boolean Success(final /*const*/ APSInt /*&*/ Value, /*const*/ Expr /*P*/ E, final APValue /*&*/ Result) {
    return IntEval.Success(Value, E, Result);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7217,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Error", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator5ErrorEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator5ErrorEPKN5clang4ExprE")
  //</editor-fold>
  private boolean Error(/*const*/ Expr /*P*/ E) {
    return IntEval.Error(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7220,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::Error", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator5ErrorEPKN5clang4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator5ErrorEPKN5clang4ExprEj")
  //</editor-fold>
  private boolean Error(/*const*/ Expr /*P*/ E, /*uint*/int D) {
    return IntEval.Error(E, D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::CCEDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7224,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::CCEDiag", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7CCEDiagEPKN5clang4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7CCEDiagEPKN5clang4ExprEj")
  //</editor-fold>
  private OptionalDiagnostic CCEDiag(/*const*/ Expr /*P*/ E, /*uint*/int D) {
    return Info.CCEDiag(E, D);
  }

  
  // \brief Returns true if visiting the RHS is necessary, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::VisitBinOpLHSOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7253,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::VisitBinOpLHSOnly", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator17VisitBinOpLHSOnlyERNS0_10EvalResultEPKN5clang14BinaryOperatorERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator17VisitBinOpLHSOnlyERNS0_10EvalResultEPKN5clang14BinaryOperatorERb")
  //</editor-fold>
  private boolean VisitBinOpLHSOnly(final EvalResult /*&*/ LHSResult, /*const*/ BinaryOperator /*P*/ E, 
                   final bool$ref/*bool &*/ SuppressRHSDiags) {
    if (E.getOpcode() == BinaryOperatorKind.BO_Comma) {
      // Ignore LHS but note if we could not evaluate it.
      if (LHSResult.Failed) {
        return Info.noteSideEffect();
      }
      return true;
    }
    if (E.isLogicalOp()) {
      bool$ref LHSAsBool = create_bool$ref();
      if (!LHSResult.Failed && HandleConversionToBool(LHSResult.Val, LHSAsBool)) {
        // We were able to evaluate the LHS, see if we can get away with not
        // evaluating the RHS: 0 && X -> 0, 1 || X -> 1
        if (LHSAsBool.$deref() == (E.getOpcode() == BinaryOperatorKind.BO_LOr)) {
          Success((LHSAsBool.$deref() ? 1 : 0), E, LHSResult.Val);
          return false; // Ignore RHS
        }
      } else {
        LHSResult.Failed = true;
        
        // Since we weren't able to evaluate the left hand side, it
        // might have had side effects.
        if (!Info.noteSideEffect()) {
          return false;
        }
        
        // We can't evaluate the LHS; however, sometimes the result
        // is determined by the RHS: X && 0 -> 0, X || 1 -> 1.
        // Don't ignore RHS and suppress diagnostics from this arm.
        SuppressRHSDiags.$set(true);
      }
      
      return true;
    }
    assert (E.getLHS().getType().$arrow().isIntegralOrEnumerationType() && E.getRHS().getType().$arrow().isIntegralOrEnumerationType());
    if (LHSResult.Failed && !Info.noteFailure()) {
      return false; // Ignore RHS;
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::VisitBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7298,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::VisitBinOp", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10VisitBinOpERKNS0_10EvalResultES3_PKN5clang14BinaryOperatorERNS4_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator10VisitBinOpERKNS0_10EvalResultES3_PKN5clang14BinaryOperatorERNS4_7APValueE")
  //</editor-fold>
  private boolean VisitBinOp(final /*const*/ EvalResult /*&*/ LHSResult, final /*const*/ EvalResult /*&*/ RHSResult, 
            /*const*/ BinaryOperator /*P*/ E, final APValue /*&*/ Result) {
    if (E.getOpcode() == BinaryOperatorKind.BO_Comma) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (RHSResult.Failed) {
          return false;
        }
        $c$.clean(Result.$assign($c$.track(new APValue(RHSResult.Val))));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    if (E.isLogicalOp()) {
      bool$ref lhsResult = create_bool$ref();
      bool$ref rhsResult = create_bool$ref();
      boolean LHSIsOK = HandleConversionToBool(LHSResult.Val, lhsResult);
      boolean RHSIsOK = HandleConversionToBool(RHSResult.Val, rhsResult);
      if (LHSIsOK) {
        if (RHSIsOK) {
          if (E.getOpcode() == BinaryOperatorKind.BO_LOr) {
            return Success(((lhsResult.$deref() || rhsResult.$deref()) ? 1 : 0), E, Result);
          } else {
            return Success(((lhsResult.$deref() && rhsResult.$deref()) ? 1 : 0), E, Result);
          }
        }
      } else {
        if (RHSIsOK) {
          // We can't evaluate the LHS; however, sometimes the result
          // is determined by the RHS: X && 0 -> 0, X || 1 -> 1.
          if (rhsResult.$deref() == (E.getOpcode() == BinaryOperatorKind.BO_LOr)) {
            return Success((rhsResult.$deref() ? 1 : 0), E, Result);
          }
        }
      }
      
      return false;
    }
    assert (E.getLHS().getType().$arrow().isIntegralOrEnumerationType() && E.getRHS().getType().$arrow().isIntegralOrEnumerationType());
    if (LHSResult.Failed || RHSResult.Failed) {
      return false;
    }
    
    final /*const*/ APValue /*&*/ LHSVal = LHSResult.Val;
    final /*const*/ APValue /*&*/ RHSVal = RHSResult.Val;
    
    // Handle cases like (unsigned long)&a + 4.
    if (E.isAdditiveOp() && LHSVal.isLValue() && RHSVal.isInt()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Result.$assign($c$.track(new APValue(LHSVal))));
        CharUnits AdditionalOffset = CharUnits.fromQuantity(RHSVal.getInt$Const().getZExtValue());
        if (E.getOpcode() == BinaryOperatorKind.BO_Add) {
          Result.getLValueOffset().$addassign(AdditionalOffset);
        } else {
          Result.getLValueOffset().$minusassign(AdditionalOffset);
        }
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Handle cases like 4 + (unsigned long)&a
    if (E.getOpcode() == BinaryOperatorKind.BO_Add
       && RHSVal.isLValue() && LHSVal.isInt()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Result.$assign($c$.track(new APValue(RHSVal))));
        Result.getLValueOffset().$addassign(
            CharUnits.fromQuantity(LHSVal.getInt$Const().getZExtValue())
        );
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    if (E.getOpcode() == BinaryOperatorKind.BO_Sub && LHSVal.isLValue() && RHSVal.isLValue()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Handle (intptr_t)&&A - (intptr_t)&&B.
        if (!LHSVal.getLValueOffset$Const().isZero()
           || !RHSVal.getLValueOffset$Const().isZero()) {
          return false;
        }
        /*const*/ Expr /*P*/ LHSExpr = LHSVal.getLValueBase().dyn_cast(/*const*/ Expr /*P*/.class);
        /*const*/ Expr /*P*/ RHSExpr = RHSVal.getLValueBase().dyn_cast(/*const*/ Expr /*P*/.class);
        if (!(LHSExpr != null) || !(RHSExpr != null)) {
          return false;
        }
        /*const*/ AddrLabelExpr /*P*/ LHSAddrExpr = dyn_cast_AddrLabelExpr(LHSExpr);
        /*const*/ AddrLabelExpr /*P*/ RHSAddrExpr = dyn_cast_AddrLabelExpr(RHSExpr);
        if (!(LHSAddrExpr != null) || !(RHSAddrExpr != null)) {
          return false;
        }
        // Make sure both labels come from the same function.
        if (LHSAddrExpr.getLabel().getDeclContext()
           != RHSAddrExpr.getLabel().getDeclContext()) {
          return false;
        }
        $c$.clean(Result.$assign($c$.track(new APValue(LHSAddrExpr, RHSAddrExpr))));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // All the remaining cases expect both operands to be an integer
    if (!LHSVal.isInt() || !RHSVal.isInt()) {
      return Error(E);
    }
    
    // Set up the width and signedness manually, in case it can't be deduced
    // from the operation we're performing.
    // FIXME: Don't do this in the cases where we can deduce it.
    APSInt Value/*J*/= new APSInt(Info.Ctx.getIntWidth(E.getType()), 
        E.getType().$arrow().isUnsignedIntegerOrEnumerationType());
    if (!handleIntIntBinOp(Info, E, LHSVal.getInt$Const(), E.getOpcode(), 
        new APSInt(RHSVal.getInt$Const()), Value)) {
      return false;
    }
    return Success(Value, E, Result);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvaluateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7235,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::EvaluateExpr", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator12EvaluateExprEPKN5clang4ExprERNS0_10EvalResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator12EvaluateExprEPKN5clang4ExprERNS0_10EvalResultE")
  //</editor-fold>
  private void EvaluateExpr(/*const*/ Expr /*P*/ E, final EvalResult /*&*/ Result) {
    Result.Failed = !Evaluate(Result.Val, Info, E);
    if (Result.Failed) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Result.Val.$assign($c$.track(new APValue())));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::process">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7398,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::process", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7processERNS0_10EvalResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7processERNS0_10EvalResultE")
  //</editor-fold>
  private void process(final EvalResult /*&*/ Result) {
    final Job /*&*/ job = Queue.back();
    switch (job.Kind) {
     case AnyExprKind:
      {
        {
          /*const*/ BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(job.E);
          if ((Bop != null)) {
            if (shouldEnqueue(Bop)) {
              job.Kind = Job.Unnamed_enum.BinOpKind;
              enqueue(Bop.getLHS());
              return;
            }
          }
        }
        
        EvaluateExpr(job.E, Result);
        Queue.pop_back();
        return;
      }
     case BinOpKind:
      {
        /*const*/ BinaryOperator /*P*/ Bop = cast_BinaryOperator(job.E);
        bool$ref SuppressRHSDiags = create_bool$ref(false);
        if (!VisitBinOpLHSOnly(Result, Bop, SuppressRHSDiags)) {
          Queue.pop_back();
          return;
        }
        if (SuppressRHSDiags.$deref()) {
          job.startSpeculativeEval(Info);
        }
        job.LHSResult.swap(Result);
        job.Kind = Job.Unnamed_enum.BinOpVisitedLHSKind;
        enqueue(Bop.getRHS());
        return;
      }
     case BinOpVisitedLHSKind:
      {
        EvalResult RHS = null;
        try {
          /*const*/ BinaryOperator /*P*/ Bop = cast_BinaryOperator(job.E);
          RHS/*J*/= new EvalResult();
          RHS.swap(Result);
          Result.Failed = !VisitBinOp(job.LHSResult, RHS, Bop, Result.Val);
          Queue.pop_back();
          return;
        } finally {
          if (RHS != null) { RHS.$destroy(); }
        }
      }
    }
    throw new llvm_unreachable("Invalid Job::Kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7243,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::enqueue", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7enqueueEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluator7enqueueEPKN5clang4ExprE")
  //</editor-fold>
  private void enqueue(/*const*/ Expr /*P*/ E) {
    E = E.IgnoreParens$Const();
    Queue.resize(Queue.size() + 1);
    Queue.back().E = E;
    Queue.back().Kind = Job.Unnamed_enum.AnyExprKind;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::~DataRecursiveIntBinOpEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 7143,
   FQN="(anonymous namespace)::DataRecursiveIntBinOpEvaluator::~DataRecursiveIntBinOpEvaluator", NM="_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130DataRecursiveIntBinOpEvaluatorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Queue.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Queue=" + Queue // NOI18N
              + ", IntEval=" + IntEval // NOI18N
              + ", Info=" + Info // NOI18N
              + ", FinalResult=" + FinalResult; // NOI18N
  }
}
