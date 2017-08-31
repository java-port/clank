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

package org.clang.staticanalyzer.java;

import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.aliases.*;

/**
 * special classes based on typedefs from CheckerManager::.
 * TODO: Probably instead of interfaces we need to create classes which wrap Check.
 * 
 * @author Vladimir Voskresensky
 */
public final class StaticAnalyzerCheckerManagerFunctions {

  private StaticAnalyzerCheckerManagerFunctions() {
  }
  
  public interface GetCheck<CHECK> {
    CheckerBase getChecker();
  }
  
  private static <CHECK> CHECK $getChecker(Object C) {
    if (C instanceof GetCheck<?>) {
      return (CHECK)((GetCheck) C).getChecker();
    }
    return null;
  }
    
  // CheckerFnT1ToT<void, >
  @FunctionalInterface
  public interface Check$CheckerDtorBase<CHECK> {
    void $call(/*void P*/CHECK C);
    default void $call(/*void P Unused*/) {
      $call($getChecker(this));
    }
  }
  public interface Check$CheckerDtor<CHECK> extends Check$CheckerDtorBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckerDtor EMPTY = new Check$CheckerDtor() {
      @Override
      public void $call(Object C) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, /*const*/ Decl /*P*/ , AnalysisManager /*&*/ , BugReporter /*&*/ >
  public interface Check$CheckDeclFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/ Decl /*P*/ d, AnalysisManager /*&*/ am, BugReporter /*&*/ br);
    default void $call(/*void P Unused,*/ /*const*/ Decl /*P*/ d, AnalysisManager /*&*/ am, BugReporter /*&*/ br) {
      $call($getChecker(this), d, am, br);
    }
  }
  public interface Check$CheckDeclFunc<CHECK> extends Check$CheckDeclFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckDeclFunc EMPTY = new Check$CheckDeclFunc() {
      @Override
      public void $call(Object C, Decl d, AnalysisManager am, BugReporter br) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, /*const*/ Stmt /*P*/ , CheckerContext /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckStmtFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/ Stmt /*P*/ s, CheckerContext /*&*/ cc);
    default void $call(/*void P Unused,*/ /*const*/ Stmt /*P*/ s, CheckerContext /*&*/ cc) {
      $call($getChecker(this), s, cc);
    }
  }
  public interface Check$CheckStmtFunc<CHECK> extends Check$CheckStmtFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckStmtFunc EMPTY = new Check$CheckStmtFunc(){
      @Override
      public void $call(Object C, Stmt s, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, /*const*/ ObjCMethodCall /*&*/ , CheckerContext /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckObjCMessageFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/ ObjCMethodCall /*&*/ call, CheckerContext /*&*/ cc);
    default void $call(/*void P Unused,*/ /*const*/ ObjCMethodCall /*&*/ call, CheckerContext /*&*/ cc) {
      $call($getChecker(this), call, cc);
    }
  }
  public interface Check$CheckObjCMessageFunc<CHECK> extends Check$CheckObjCMessageFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckObjCMessageFunc EMPTY = new Check$CheckObjCMessageFunc(){
      @Override
      public void $call(Object C, ObjCMethodCall call, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }

  //CheckerFnT1ToT<void, /*const*/ CallEvent /*&*/ , CheckerContext /*&*/ >
  @FunctionalInterface
  public interface Check$CheckCallFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/ CallEvent /*&*/ call, CheckerContext /*&*/ cc);
    default void $call(/*void P Unused,*/ /*const*/ CallEvent /*&*/ call, CheckerContext /*&*/ cc) {
      $call($getChecker(this), call, cc);
    }
  }  
  public interface Check$CheckCallFunc<CHECK> extends Check$CheckCallFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckCallFunc EMPTY = new Check$CheckCallFunc() {
      @Override
      public void $call(Object C, CallEvent call, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, /*const*/ SVal /*&*/ , boolean, /*const*/ Stmt /*P*/ , CheckerContext /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckLocationFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/ SVal /*&*/ sv, 
            boolean b, /*const*/ Stmt /*P*/ stm, CheckerContext /*&*/ cc);
    default void $call(/*void P Unused,*/ /*const*/ SVal /*&*/ sv, 
            boolean b, /*const*/ Stmt /*P*/ stm, CheckerContext /*&*/ cc) {
      $call($getChecker(this), sv, b, stm, cc);
    }
  }
  public interface Check$CheckLocationFunc<CHECK> extends Check$CheckLocationFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckLocationFunc EMPTY = new Check$CheckLocationFunc() {
      @Override
      public void $call(Object C, SVal sv, boolean b, Stmt stm, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, /*const*/ SVal /*&*/ , /*const*/ SVal /*&*/ , /*const*/ Stmt /*P*/ , CheckerContext /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckBindFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/ SVal /*&*/ sv1, /*const*/ SVal /*&*/ sv2, 
            /*const*/ Stmt /*P*/ stm, CheckerContext /*&*/ cc);
    default void $call(/*void P Unused,*/ /*const*/ SVal /*&*/ sv1, /*const*/ SVal /*&*/ sv2, 
            /*const*/ Stmt /*P*/ stm, CheckerContext /*&*/ cc) {
      $call($getChecker(this), sv1, sv2, stm, cc);
    }
  }
  public interface Check$CheckBindFunc<CHECK> extends Check$CheckBindFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckBindFunc EMPTY = new Check$CheckBindFunc(){
      @Override
      public void $call(Object C, SVal sv1, SVal sv2, Stmt stm, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, ExplodedGraph /*&*/ , BugReporter /*&*/ , ExprEngine /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckEndAnalysisFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, ExplodedGraph /*&*/ eg, BugReporter /*&*/ br, ExprEngine /*&*/ ee);
    default void $call(/*void P Unused,*/ ExplodedGraph /*&*/ eg, BugReporter /*&*/ br, ExprEngine /*&*/ ee) {
      $call($getChecker(this), eg, br, ee);
    }
  }
  public interface Check$CheckEndAnalysisFunc<CHECK> extends Check$CheckEndAnalysisFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckEndAnalysisFunc EMPTY = new Check$CheckEndAnalysisFunc() {
      @Override
      public void $call(Object C, ExplodedGraph eg, BugReporter br, ExprEngine ee) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  // CheckBeginEndFunctionFunc is merge of CheckBeginFunctionFunc and CheckEndFunctionFunc
  // because the same signatures
  //CheckerFnT1ToT<void, CheckerContext /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckBeginEndFunctionFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, CheckerContext /*&*/ cc);
    default void $call(/*void P Unused,*/ CheckerContext /*&*/ cc) {
      $call($getChecker(this), cc);
    }
  }
  public interface Check$CheckBeginEndFunctionFunc<CHECK> extends Check$CheckBeginEndFunctionFuncBase<CHECK>, GetCheck<CHECK> {
  }
  public interface Check$CheckBeginFunctionFunc<CHECK> extends Check$CheckBeginEndFunctionFunc<CHECK> {
    public static Check$CheckBeginFunctionFunc EMPTY = new Check$CheckBeginFunctionFunc(){
      @Override
      public void $call(Object C, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  public interface Check$CheckEndFunctionFunc<CHECK> extends Check$CheckBeginEndFunctionFunc<CHECK> {
    public static Check$CheckEndFunctionFunc EMPTY = new Check$CheckEndFunctionFunc(){
      @Override
      public void $call(Object C, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, /*const*/ Stmt /*P*/ , CheckerContext /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckBranchConditionFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/ Stmt /*P*/ stm, CheckerContext /*&*/ cc);
    default void $call(/*void P Unused,*//*const*/ Stmt /*P*/ stm, CheckerContext /*&*/ cc) {
      $call($getChecker(this), stm, cc);
    }
  }
  public interface Check$CheckBranchConditionFunc<CHECK> extends Check$CheckBranchConditionFuncBase<CHECK> , GetCheck<CHECK> {
    public static Check$CheckBranchConditionFunc EMPTY = new Check$CheckBranchConditionFunc() {
      @Override
      public void $call(Object C, Stmt stm, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, SymbolReaper /*&*/ , CheckerContext /*&*/ >
  @FunctionalInterface
  public interface Check$CheckDeadSymbolsFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, SymbolReaper /*&*/ sr, CheckerContext /*&*/ cc);
    default void $call(/*void P Unused,*/ SymbolReaper /*&*/ sr, CheckerContext /*&*/ cc) {
      $call($getChecker(this), sr, cc);
    }
  }
  public interface Check$CheckDeadSymbolsFunc<CHECK> extends Check$CheckDeadSymbolsFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckDeadSymbolsFunc EMPTY = new Check$CheckDeadSymbolsFunc() {
      @Override
      public void $call(Object C, SymbolReaper sr, CheckerContext cc) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, IntrusiveRefCntPtr</*const*/ ProgramState>, SymbolReaper /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckLiveSymbolsFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, IntrusiveRefCntPtr</*const*/ ProgramState> state, SymbolReaper /*&*/ sr);
    default void $call(/*void P Unused,*/ IntrusiveRefCntPtr</*const*/ ProgramState> state, SymbolReaper /*&*/ sr) {
      $call($getChecker(this), state, sr);
    }
  }
  public interface Check$CheckLiveSymbolsFunc<CHECK> extends Check$CheckLiveSymbolsFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckLiveSymbolsFunc EMPTY = new Check$CheckLiveSymbolsFunc() {
      @Override
      public void $call(Object C, IntrusiveRefCntPtr state, SymbolReaper sr) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>, /*const*/ DenseSet</*const*/ SymExpr /*P*/ , DenseMapInfo</*const*/ SymExpr /*P*/ > > /*P*/ , ArrayRef</*const*/ MemRegion /*P*/ >, ArrayRef</*const*/ MemRegion /*P*/ >, /*const*/ CallEvent /*P*/ >
  @FunctionalInterface
  public interface Check$CheckRegionChangesFuncBase<CHECK> {
    IntrusiveRefCntPtr</*const*/ ProgramState> $call(/*void P*/CHECK C, 
            IntrusiveRefCntPtr</*const*/ ProgramState> state, 
            /*const*/ DenseSet</*const*/ SymExpr /*P*/> /*P*/ ses, 
            ArrayRef</*const*/ MemRegion /*P*/ > mrs, 
            ArrayRef</*const*/ MemRegion /*P*/ > mrs2, /*const*/ CallEvent /*P*/ call);
    default IntrusiveRefCntPtr</*const*/ ProgramState> $call(//*void P Unused,*/ 
            IntrusiveRefCntPtr</*const*/ ProgramState> state, 
            /*const*/ DenseSet</*const*/ SymExpr /*P*/> /*P*/ ses, 
            ArrayRef</*const*/ MemRegion /*P*/ > mrs, 
            ArrayRef</*const*/ MemRegion /*P*/ > mrs2, /*const*/ CallEvent /*P*/ call) {
      return $call($getChecker(this), state, ses, mrs, mrs2, call);
    }
  }
  public interface Check$CheckRegionChangesFunc<CHECK> extends Check$CheckRegionChangesFuncBase<CHECK>, GetCheck<CHECK> {
  }
  
  //CheckerFnT1ToT<boolean, IntrusiveRefCntPtr</*const*/ ProgramState> > 
  @FunctionalInterface
  public interface Check$WantsRegionChangeUpdateFuncBase<CHECK> {
    boolean $call(/*void P*/CHECK C, IntrusiveRefCntPtr</*const*/ ProgramState> state);
    default boolean $call(/*void P Unused,*/ IntrusiveRefCntPtr</*const*/ ProgramState> state) {
      return $call($getChecker(this), state);
    }
  }
  public interface Check$WantsRegionChangeUpdateFunc<CHECK> extends Check$WantsRegionChangeUpdateFuncBase<CHECK>, GetCheck<CHECK> {
  }
  
  //CheckerFnT1ToT<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>, /*const*/ DenseSet</*const*/ SymExpr /*P*/ , DenseMapInfo</*const*/ SymExpr /*P*/ > > /*&*/ , /*const*/ CallEvent /*P*/ , PointerEscapeKind, RegionAndSymbolInvalidationTraits /*P*/ > 
  @FunctionalInterface
  public interface Check$CheckPointerEscapeFuncBase<CHECK> {
    IntrusiveRefCntPtr</*const*/ ProgramState> $call(/*void P*/CHECK C, 
            IntrusiveRefCntPtr</*const*/ ProgramState> state, 
            /*const*/ DenseSet</*const*/ SymExpr /*P*/> /*&*/ ses, 
            /*const*/ CallEvent /*P*/ call, 
            PointerEscapeKind peKind, 
            RegionAndSymbolInvalidationTraits /*P*/ trait);
    default IntrusiveRefCntPtr</*const*/ ProgramState> $call(/*void P Unused,*/
            IntrusiveRefCntPtr</*const*/ ProgramState> state, 
            /*const*/ DenseSet</*const*/ SymExpr /*P*/> /*&*/ ses, 
            /*const*/ CallEvent /*P*/ call, 
            PointerEscapeKind peKind, 
            RegionAndSymbolInvalidationTraits /*P*/ trait) {
      return $call($getChecker(this), state, ses, call, peKind, trait);
    }
  }
  public interface Check$CheckPointerEscapeFunc<CHECK> extends Check$CheckPointerEscapeFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckPointerEscapeFunc EMPTY = new Check$CheckPointerEscapeFunc() {
      @Override
      public IntrusiveRefCntPtr $call(Object C, IntrusiveRefCntPtr state, DenseSet ses, CallEvent call, PointerEscapeKind peKind, RegionAndSymbolInvalidationTraits trait) {
        return null;
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>, /*const*/ SVal /*&*/ , boolean>
  @FunctionalInterface
  public interface Check$EvalAssumeFuncBase<CHECK> {
    IntrusiveRefCntPtr</*const*/ ProgramState> $call(/*void P*/CHECK C, IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SVal /*&*/ sv, boolean b);
    default IntrusiveRefCntPtr</*const*/ ProgramState> $call(/*void P Unused,*/ IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SVal /*&*/ sv, boolean b) {
      return $call($getChecker(this), state, sv, b);
    }
  }
  public interface Check$EvalAssumeFunc<CHECK> extends Check$EvalAssumeFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$EvalAssumeFunc EMPTY = new Check$EvalAssumeFunc() {
      @Override
      public IntrusiveRefCntPtr $call(Object C, IntrusiveRefCntPtr state, SVal sv, boolean b) {
        return null;
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<boolean, /*const*/ CallExpr /*P*/ , CheckerContext /*&*/ > 
  @FunctionalInterface
  public interface Check$EvalCallFuncBase<CHECK> {
    boolean $call(/*void P*/CHECK C, /*const*/ CallExpr /*P*/ call, CheckerContext /*&*/ cc);
    default boolean $call(/*void P Unused,*/ /*const*/ CallExpr /*P*/ call, CheckerContext /*&*/ cc) {
      return $call($getChecker(this), call, cc);
    }
  }
  public interface Check$EvalCallFunc<CHECK> extends Check$EvalCallFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$EvalCallFunc EMPTY = new Check$EvalCallFunc() {
      @Override
      public boolean $call(Object C, CallExpr call, CheckerContext cc) {
        return false;
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, /*const*/ TranslationUnitDecl /*P*/ , AnalysisManager /*&*/ , BugReporter /*&*/ > 
  @FunctionalInterface
  public interface Check$CheckEndOfTranslationUnitBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/ TranslationUnitDecl /*P*/ tu, AnalysisManager /*&*/ am, BugReporter /*&*/ br);
    default void $call(/*void P Unused,*/ /*const*/ TranslationUnitDecl /*P*/ tu, AnalysisManager /*&*/ am, BugReporter /*&*/ br) {
      $call($getChecker(this), tu, am, br);
    }
  }
  public interface Check$CheckEndOfTranslationUnit<CHECK> extends Check$CheckEndOfTranslationUnitBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckEndOfTranslationUnit EMPTY = new Check$CheckEndOfTranslationUnit() {
      @Override
      public void $call(Object C, TranslationUnitDecl tu, AnalysisManager am, BugReporter br) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }
  
  //CheckerFnT1ToT<void, /*const*/Object/*void P*/ > = 
  @FunctionalInterface
  public interface Check$CheckEventFuncBase<CHECK> {
    void $call(/*void P*/CHECK C, /*const*/Object/*void P*/ o);
    default void $call(/*void P Unused,*/ /*const*/Object/*void P*/ o) {
      $call($getChecker(this), o);
    }
  }  
  public interface Check$CheckEventFunc<CHECK> extends Check$CheckEventFuncBase<CHECK>, GetCheck<CHECK> {
    public static Check$CheckEventFunc EMPTY = new Check$CheckEventFunc(){
      @Override
      public void $call(Object C, Object o) {
      }

      @Override
      public CheckerBase getChecker() {
        return null;
      }
    };
  }  

}
