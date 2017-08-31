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
import static org.llvm.support.llvm.*;
import org.clang.ast.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFallThroughDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 418,
 FQN="(anonymous namespace)::CheckFallThroughDiagnostics", NM="_ZN12_GLOBAL__N_127CheckFallThroughDiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_127CheckFallThroughDiagnosticsE")
//</editor-fold>
public class/*struct*/ CheckFallThroughDiagnostics {
  public /*uint*/int diag_MaybeFallThrough_HasNoReturn;
  public /*uint*/int diag_MaybeFallThrough_ReturnsNonVoid;
  public /*uint*/int diag_AlwaysFallThrough_HasNoReturn;
  public /*uint*/int diag_AlwaysFallThrough_ReturnsNonVoid;
  public /*uint*/int diag_NeverFallThroughOrReturn;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFallThroughDiagnostics::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 424,
   FQN="(anonymous namespace)::CheckFallThroughDiagnostics::(anonymous)", NM="_ZN12_GLOBAL__N_127CheckFallThroughDiagnosticsE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_127CheckFallThroughDiagnosticsE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.ComparableLower {
    Function(0),
    Block(Function.getValue() + 1),
    Lambda(Block.getValue() + 1);

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
  public Unnamed_enum funMode;
  public SourceLocation FuncLoc;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFallThroughDiagnostics::MakeForFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 427,
   FQN="(anonymous namespace)::CheckFallThroughDiagnostics::MakeForFunction", NM="_ZN12_GLOBAL__N_127CheckFallThroughDiagnostics15MakeForFunctionEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_127CheckFallThroughDiagnostics15MakeForFunctionEPKN5clang4DeclE")
  //</editor-fold>
  public static CheckFallThroughDiagnostics MakeForFunction(/*const*/ Decl /*P*/ Func) {
    CheckFallThroughDiagnostics D/*J*/= new CheckFallThroughDiagnostics();
    D.FuncLoc.$assignMove(Func.getLocation());
    D.diag_MaybeFallThrough_HasNoReturn
       = diag.warn_falloff_noreturn_function;
    D.diag_MaybeFallThrough_ReturnsNonVoid
       = diag.warn_maybe_falloff_nonvoid_function;
    D.diag_AlwaysFallThrough_HasNoReturn
       = diag.warn_falloff_noreturn_function;
    D.diag_AlwaysFallThrough_ReturnsNonVoid
       = diag.warn_falloff_nonvoid_function;
    
    // Don't suggest that virtual functions be marked "noreturn", since they
    // might be overridden by non-noreturn functions.
    boolean isVirtualMethod = false;
    {
      /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast(CXXMethodDecl.class, Func);
      if ((Method != null)) {
        isVirtualMethod = Method.isVirtual();
      }
    }
    
    // Don't suggest that template instantiations be marked "noreturn"
    boolean isTemplateInstantiation = false;
    {
      /*const*/ FunctionDecl /*P*/ Function = dyn_cast(FunctionDecl.class, Func);
      if ((Function != null)) {
        isTemplateInstantiation = Function.isTemplateInstantiation();
      }
    }
    if (!isVirtualMethod && !isTemplateInstantiation) {
      D.diag_NeverFallThroughOrReturn
         = diag.warn_suggest_noreturn_function;
    } else {
      D.diag_NeverFallThroughOrReturn = 0;
    }
    
    D.funMode = Unnamed_enum.Function;
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFallThroughDiagnostics::MakeForBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 460,
   FQN="(anonymous namespace)::CheckFallThroughDiagnostics::MakeForBlock", NM="_ZN12_GLOBAL__N_127CheckFallThroughDiagnostics12MakeForBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_127CheckFallThroughDiagnostics12MakeForBlockEv")
  //</editor-fold>
  public static CheckFallThroughDiagnostics MakeForBlock() {
    CheckFallThroughDiagnostics D/*J*/= new CheckFallThroughDiagnostics();
    D.diag_MaybeFallThrough_HasNoReturn
       = diag.err_noreturn_block_has_return_expr;
    D.diag_MaybeFallThrough_ReturnsNonVoid
       = diag.err_maybe_falloff_nonvoid_block;
    D.diag_AlwaysFallThrough_HasNoReturn
       = diag.err_noreturn_block_has_return_expr;
    D.diag_AlwaysFallThrough_ReturnsNonVoid
       = diag.err_falloff_nonvoid_block;
    D.diag_NeverFallThroughOrReturn = 0;
    D.funMode = Unnamed_enum.Block;
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFallThroughDiagnostics::MakeForLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 475,
   FQN="(anonymous namespace)::CheckFallThroughDiagnostics::MakeForLambda", NM="_ZN12_GLOBAL__N_127CheckFallThroughDiagnostics13MakeForLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_127CheckFallThroughDiagnostics13MakeForLambdaEv")
  //</editor-fold>
  public static CheckFallThroughDiagnostics MakeForLambda() {
    CheckFallThroughDiagnostics D/*J*/= new CheckFallThroughDiagnostics();
    D.diag_MaybeFallThrough_HasNoReturn
       = diag.err_noreturn_lambda_has_return_expr;
    D.diag_MaybeFallThrough_ReturnsNonVoid
       = diag.warn_maybe_falloff_nonvoid_lambda;
    D.diag_AlwaysFallThrough_HasNoReturn
       = diag.err_noreturn_lambda_has_return_expr;
    D.diag_AlwaysFallThrough_ReturnsNonVoid
       = diag.warn_falloff_nonvoid_lambda;
    D.diag_NeverFallThroughOrReturn = 0;
    D.funMode = Unnamed_enum.Lambda;
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFallThroughDiagnostics::checkDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 490,
   FQN="(anonymous namespace)::CheckFallThroughDiagnostics::checkDiagnostics", NM="_ZNK12_GLOBAL__N_127CheckFallThroughDiagnostics16checkDiagnosticsERN5clang17DiagnosticsEngineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK12_GLOBAL__N_127CheckFallThroughDiagnostics16checkDiagnosticsERN5clang17DiagnosticsEngineEbb")
  //</editor-fold>
  public boolean checkDiagnostics(final DiagnosticsEngine /*&*/ D, boolean ReturnsVoid, 
                  boolean HasNoReturn) /*const*/ {
    if (funMode == Unnamed_enum.Function) {
      return (ReturnsVoid
         || D.isIgnored(diag.warn_maybe_falloff_nonvoid_function, 
          /*NO_COPY*/FuncLoc))
         && (!HasNoReturn
         || D.isIgnored(diag.warn_noreturn_function_has_return_expr, 
          /*NO_COPY*/FuncLoc))
         && (!ReturnsVoid
         || D.isIgnored(diag.warn_suggest_noreturn_block, /*NO_COPY*/FuncLoc));
    }
    
    // For blocks / lambdas.
    return ReturnsVoid && !HasNoReturn;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFallThroughDiagnostics::CheckFallThroughDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 418,
   FQN="(anonymous namespace)::CheckFallThroughDiagnostics::CheckFallThroughDiagnostics", NM="_ZN12_GLOBAL__N_127CheckFallThroughDiagnosticsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_127CheckFallThroughDiagnosticsC1Ev")
  //</editor-fold>
  public /*inline*/ CheckFallThroughDiagnostics() {
    // : FuncLoc() 
    //START JInit
    this.FuncLoc = new SourceLocation();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFallThroughDiagnostics::CheckFallThroughDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 418,
   FQN="(anonymous namespace)::CheckFallThroughDiagnostics::CheckFallThroughDiagnostics", NM="_ZN12_GLOBAL__N_127CheckFallThroughDiagnosticsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_127CheckFallThroughDiagnosticsC1EOS0_")
  //</editor-fold>
  public /*inline*/ CheckFallThroughDiagnostics(JD$Move _dparam, final CheckFallThroughDiagnostics /*&&*/$Prm0) {
    // : diag_MaybeFallThrough_HasNoReturn(static_cast<CheckFallThroughDiagnostics &&>().diag_MaybeFallThrough_HasNoReturn), diag_MaybeFallThrough_ReturnsNonVoid(static_cast<CheckFallThroughDiagnostics &&>().diag_MaybeFallThrough_ReturnsNonVoid), diag_AlwaysFallThrough_HasNoReturn(static_cast<CheckFallThroughDiagnostics &&>().diag_AlwaysFallThrough_HasNoReturn), diag_AlwaysFallThrough_ReturnsNonVoid(static_cast<CheckFallThroughDiagnostics &&>().diag_AlwaysFallThrough_ReturnsNonVoid), diag_NeverFallThroughOrReturn(static_cast<CheckFallThroughDiagnostics &&>().diag_NeverFallThroughOrReturn), funMode(static_cast<CheckFallThroughDiagnostics &&>().funMode), FuncLoc(static_cast<CheckFallThroughDiagnostics &&>().FuncLoc) 
    //START JInit
    this.diag_MaybeFallThrough_HasNoReturn = $Prm0.diag_MaybeFallThrough_HasNoReturn;
    this.diag_MaybeFallThrough_ReturnsNonVoid = $Prm0.diag_MaybeFallThrough_ReturnsNonVoid;
    this.diag_AlwaysFallThrough_HasNoReturn = $Prm0.diag_AlwaysFallThrough_HasNoReturn;
    this.diag_AlwaysFallThrough_ReturnsNonVoid = $Prm0.diag_AlwaysFallThrough_ReturnsNonVoid;
    this.diag_NeverFallThroughOrReturn = $Prm0.diag_NeverFallThroughOrReturn;
    this.funMode = $Prm0.funMode;
    this.FuncLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.FuncLoc);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "diag_MaybeFallThrough_HasNoReturn=" + diag_MaybeFallThrough_HasNoReturn // NOI18N
              + ", diag_MaybeFallThrough_ReturnsNonVoid=" + diag_MaybeFallThrough_ReturnsNonVoid // NOI18N
              + ", diag_AlwaysFallThrough_HasNoReturn=" + diag_AlwaysFallThrough_HasNoReturn // NOI18N
              + ", diag_AlwaysFallThrough_ReturnsNonVoid=" + diag_AlwaysFallThrough_ReturnsNonVoid // NOI18N
              + ", diag_NeverFallThroughOrReturn=" + diag_NeverFallThroughOrReturn // NOI18N
              + ", funMode=" + funMode // NOI18N
              + ", FuncLoc=" + FuncLoc; // NOI18N
  }
}
