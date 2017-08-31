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

package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.staticanalyzer.java.*;
import org.clang.staticanalyzer.checkers.ento.impl.MallocCheckerStatics.ProgramStateTraitRegionState;
import org.clang.staticanalyzer.checkers.impl.MallocCheckerStatics.StopTrackingCallback;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APSInt$C;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 158,
 FQN="(anonymous namespace)::MallocChecker", NM="_ZN12_GLOBAL__N_113MallocCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocCheckerE")
//</editor-fold>
public class MallocChecker extends /*public*/ Checker/*<DeadSymbols, PointerEscape, ConstPointerEscape, PreStmt<ReturnStmt>, PreCall, PostStmt<CallExpr>, PostStmt<CXXNewExpr>, PreStmt<CXXDeleteExpr>, PostStmt<BlockExpr>, PostObjCMessage, Location, eval.Assume>*/
        implements org.clang.staticanalyzer.java.EvalAssumeChecker, org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PointerEscapeChecker, org.clang.staticanalyzer.java.LocationChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, org.clang.staticanalyzer.java.ConstPointerEscapeChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 172,
   FQN="(anonymous namespace)::MallocChecker::MallocChecker", NM="_ZN12_GLOBAL__N_113MallocCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocCheckerC1Ev")
  //</editor-fold>
  public MallocChecker() {
    // : Checker<DeadSymbols, PointerEscape, ConstPointerEscape, PreStmt<ReturnStmt>, PreCall, PostStmt<CallExpr>, PostStmt<CXXNewExpr>, PreStmt<CXXDeleteExpr>, PostStmt<BlockExpr>, PostObjCMessage, Location, eval::Assume>(), IsOptimistic(), ChecksEnabled(), CheckNames(), BT_DoubleFree(), BT_DoubleDelete(), BT_Leak(), BT_UseFree(), BT_BadFree(), BT_FreeAlloca(), BT_MismatchedDealloc(), BT_OffsetFree(), BT_UseZerroAllocated(), II_alloca(null), II_win_alloca(null), II_malloc(null), II_free(null), II_realloc(null), II_calloc(null), II_valloc(null), II_reallocf(null), II_strndup(null), II_strdup(null), II_win_strdup(null), II_kmalloc(null), II_if_nameindex(null), II_if_freenameindex(null), II_wcsdup(null), II_win_wcsdup(null), KernelZeroFlagVal() 
    //START JInit
    super();
    this.IsOptimistic = new DefaultBool();
    this.ChecksEnabled = new$T(new DefaultBool [4], ()->new DefaultBool());
    this.CheckNames = new$T(new CheckName [4], ()->new CheckName());
    this.BT_DoubleFree = new$T(new std.unique_ptr [4], ()->new std.unique_ptr<BugType>());
    this.BT_DoubleDelete = new std.unique_ptr<BugType>();
    this.BT_Leak = new$T(new std.unique_ptr [4], ()->new std.unique_ptr<BugType>());
    this.BT_UseFree = new$T(new std.unique_ptr [4], ()->new std.unique_ptr<BugType>());
    this.BT_BadFree = new$T(new std.unique_ptr [4], ()->new std.unique_ptr<BugType>());
    this.BT_FreeAlloca = new$T(new std.unique_ptr [4], ()->new std.unique_ptr<BugType>());
    this.BT_MismatchedDealloc = new std.unique_ptr<BugType>();
    this.BT_OffsetFree = new$T(new std.unique_ptr [4], ()->new std.unique_ptr<BugType>());
    this.BT_UseZerroAllocated = new$T(new std.unique_ptr [4], ()->new std.unique_ptr<BugType>());
    this.II_alloca = null;
    this.II_win_alloca = null;
    this.II_malloc = null;
    this.II_free = null;
    this.II_realloc = null;
    this.II_calloc = null;
    this.II_valloc = null;
    this.II_reallocf = null;
    this.II_strndup = null;
    this.II_strdup = null;
    this.II_win_strdup = null;
    this.II_kmalloc = null;
    this.II_if_nameindex = null;
    this.II_if_freenameindex = null;
    this.II_wcsdup = null;
    this.II_win_wcsdup = null;
    this.KernelZeroFlagVal = new OptionalULong();
    //END JInit
  }

  
  /// In pessimistic mode, the checker assumes that it does not know which
  /// functions might free the memory.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::CheckKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 182,
   FQN="(anonymous namespace)::MallocChecker::CheckKind", NM="_ZN12_GLOBAL__N_113MallocChecker9CheckKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker9CheckKindE")
  //</editor-fold>
  public enum CheckKind implements Native.NativeUIntEnum {
    CK_MallocChecker(0),
    CK_NewDeleteChecker(CK_MallocChecker.getValue() + 1),
    CK_NewDeleteLeaksChecker(CK_NewDeleteChecker.getValue() + 1),
    CK_MismatchedDeallocatorChecker(CK_NewDeleteLeaksChecker.getValue() + 1),
    CK_NumCheckKinds(CK_MismatchedDeallocatorChecker.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CheckKind valueOf(int val) {
      CheckKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CheckKind[] VALUES;
      private static final CheckKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CheckKind kind : CheckKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CheckKind[min < 0 ? (1-min) : 0];
        VALUES = new CheckKind[max >= 0 ? (1+max) : 0];
        for (CheckKind kind : CheckKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private CheckKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MemoryOperationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 190,
   FQN="(anonymous namespace)::MallocChecker::MemoryOperationKind", NM="_ZN12_GLOBAL__N_113MallocChecker19MemoryOperationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker19MemoryOperationKindE")
  //</editor-fold>
  public enum /*class */MemoryOperationKind/* : int*/ implements Native.NativeIntEnum {
    MOK_Allocate(0),
    MOK_Free(MOK_Allocate.getValue() + 1),
    MOK_Any(MOK_Free.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MemoryOperationKind valueOf(int val) {
      MemoryOperationKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MemoryOperationKind[] VALUES;
      private static final MemoryOperationKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MemoryOperationKind kind : MemoryOperationKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MemoryOperationKind[min < 0 ? (1-min) : 0];
        VALUES = new MemoryOperationKind[max >= 0 ? (1+max) : 0];
        for (MemoryOperationKind kind : MemoryOperationKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final int value;
    private MemoryOperationKind(int val) { this.value = (int)val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
  public DefaultBool IsOptimistic;
  
  public DefaultBool ChecksEnabled[/*4*/] = new DefaultBool [4];
  public CheckName CheckNames[/*4*/] = new CheckName [4];
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2181,
   FQN="(anonymous namespace)::MallocChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_113MallocChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    {
      
      /*const*/ CXXDestructorCall /*P*/ DC = dyn_cast_CXXDestructorCall($AddrOf(Call));
      if ((DC != null)) {
        /*const*/ SymExpr /*P*/ Sym = DC.getCXXThisVal().getAsSymbol();
        if (!(Sym != null) || checkDoubleDelete(Sym, C)) {
          return;
        }
      }
    }
    {
      
      // We will check for double free in the post visit.
      /*const*/ AnyFunctionCall /*P*/ FC = dyn_cast_AnyFunctionCall($AddrOf(Call));
      if ((FC != null)) {
        /*const*/ FunctionDecl /*P*/ FD = FC.getDecl();
        if (!(FD != null)) {
          return;
        }
        
        final ASTContext /*&*/ Ctx = C.getASTContext();
        if (ChecksEnabled[CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()
           && (isCMemFunction(FD, Ctx, AllocationFamily.AF_Malloc, MemoryOperationKind.MOK_Free)
           || isCMemFunction(FD, Ctx, AllocationFamily.AF_IfNameIndex, 
            MemoryOperationKind.MOK_Free))) {
          return;
        }
        if (ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()
           && isStandardNewDelete(FD, Ctx)) {
          return;
        }
      }
    }
    {
      
      // Check if the callee of a method is deleted.
      /*const*/ CXXInstanceCall /*P*/ CC = dyn_cast_CXXInstanceCall($AddrOf(Call));
      if ((CC != null)) {
        /*const*/ SymExpr /*P*/ Sym = CC.getCXXThisVal().getAsSymbol();
        if (!(Sym != null) || checkUseAfterFree(Sym, C, CC.getCXXThisExpr())) {
          return;
        }
      }
    }
    
    // Check arguments for being used after free.
    for (/*uint*/int I = 0, E = Call.getNumArgs(); I != E; ++I) {
      SVal ArgSVal = Call.getArgSVal(I);
      if (ArgSVal.getAs(Loc.class).$bool()) {
        /*const*/ SymExpr /*P*/ Sym = ArgSVal.getAsSymbol();
        if (!(Sym != null)) {
          continue;
        }
        if (checkUseAfterFree(Sym, C, Call.getArgExpr(I))) {
          return;
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 748,
   FQN="(anonymous namespace)::MallocChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_113MallocChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (C.wasInlined) {
        return;
      }
      
      /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
      if (!(FD != null)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      bool$ref ReleasedAllocatedMemory = create_bool$ref(false);
      if (FD.getKind() == Decl.Kind.Function) {
        initIdentifierInfo(C.getASTContext());
        IdentifierInfo /*P*/ FunI = FD.getIdentifier();
        if (FunI == II_malloc) {
          if ($less_uint(CE.getNumArgs(), 1)) {
            return;
          }
          if ($less_uint(CE.getNumArgs(), 3)) {
            $c$.clean(State.$assign($c$.track(MallocMemAux(C, CE, CE.getArg$Const(0), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
            if (CE.getNumArgs() == 1) {
              $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 0, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
            }
          } else if (CE.getNumArgs() == 3) {
            Optional<IntrusiveRefCntPtr</*const*/ ProgramState> > MaybeState = null;
            try {
              MaybeState = performKernelMalloc(CE, C, State);
              if (MaybeState.hasValue()) {
                $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(MaybeState.getValue()))));
              } else {
                $c$.clean(State.$assign($c$.track(MallocMemAux(C, CE, CE.getArg$Const(0), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
              }
            } finally {
              if (MaybeState != null) { MaybeState.$destroy(); }
            }
          }
        } else if (FunI == II_kmalloc) {
          Optional<IntrusiveRefCntPtr</*const*/ ProgramState> > MaybeState = null;
          try {
            MaybeState = performKernelMalloc(CE, C, State);
            if (MaybeState.hasValue()) {
              $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(MaybeState.getValue()))));
            } else {
              $c$.clean(State.$assign($c$.track(MallocMemAux(C, CE, CE.getArg$Const(0), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
            }
          } finally {
            if (MaybeState != null) { MaybeState.$destroy(); }
          }
        } else if (FunI == II_valloc) {
          if ($less_uint(CE.getNumArgs(), 1)) {
            return;
          }
          $c$.clean(State.$assign($c$.track(MallocMemAux(C, CE, CE.getArg$Const(0), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
          $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 0, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
        } else if (FunI == II_realloc) {
          $c$.clean(State.$assign($c$.track(ReallocMem(C, CE, false, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
          $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 1, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
        } else if (FunI == II_reallocf) {
          $c$.clean(State.$assign($c$.track(ReallocMem(C, CE, true, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
          $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 1, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
        } else if (FunI == II_calloc) {
          $c$.clean(State.$assign($c$.track(CallocMem(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
          $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 0, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
          $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 1, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
        } else if (FunI == II_free) {
          $c$.clean(State.$assign($c$.track(FreeMemAux(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 0, false, ReleasedAllocatedMemory))));
        } else if (FunI == II_strdup || FunI == II_win_strdup
           || FunI == II_wcsdup || FunI == II_win_wcsdup) {
          $c$.clean(State.$assign($c$.track(MallocUpdateRefState(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
        } else if (FunI == II_strndup) {
          $c$.clean(State.$assign($c$.track(MallocUpdateRefState(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
        } else if (FunI == II_alloca || FunI == II_win_alloca) {
          $c$.clean(State.$assign($c$.track(MallocMemAux(C, CE, CE.getArg$Const(0), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
                  AllocationFamily.AF_Alloca))));
          $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 0, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
        } else if (isStandardNewDelete(FD, C.getASTContext())) {
          // Process direct calls to operator new/new[]/delete/delete[] functions
          // as distinct from new/new[]/delete/delete[] expressions that are
          // processed by the checkPostStmt callbacks for CXXNewExpr and
          // CXXDeleteExpr.
          OverloadedOperatorKind K = FD.getOverloadedOperator();
          if (K == OverloadedOperatorKind.OO_New) {
            $c$.clean(State.$assign($c$.track(MallocMemAux(C, CE, CE.getArg$Const(0), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
                    AllocationFamily.AF_CXXNew))));
            $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 0, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
          } else if (K == OverloadedOperatorKind.OO_Array_New) {
            $c$.clean(State.$assign($c$.track(MallocMemAux(C, CE, CE.getArg$Const(0), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
                    AllocationFamily.AF_CXXNewArray))));
            $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, CE, 0, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
          } else if (K == OverloadedOperatorKind.OO_Delete || K == OverloadedOperatorKind.OO_Array_Delete) {
            $c$.clean(State.$assign($c$.track(FreeMemAux(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 0, false, ReleasedAllocatedMemory))));
          } else {
            throw new llvm_unreachable("not a new/delete operator");
          }
        } else if (FunI == II_if_nameindex) {
          // Should we model this differently? We can allocate a fixed number of
          // elements with zeros in the last one.
          $c$.clean(State.$assign($c$.track(MallocMemAux(C, CE, new SVal(JD$Move.INSTANCE, new UnknownVal()), new SVal(JD$Move.INSTANCE, new UnknownVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
                  AllocationFamily.AF_IfNameIndex))));
        } else if (FunI == II_if_freenameindex) {
          $c$.clean(State.$assign($c$.track(FreeMemAux(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 0, false, ReleasedAllocatedMemory))));
        }
      }
      if (IsOptimistic.$ConstBoolRef() || ChecksEnabled[CheckKind.CK_MismatchedDeallocatorChecker.getValue()].$ConstBoolRef()) {
        // Check all the attributes, if there are any.
        // There can be multiple of these attributes.
        if (FD.hasAttrs()) {
          for (/*const*/ OwnershipAttr /*P*/ I : FD.specific_attrs(OwnershipAttr.class)) {
            switch (I.getOwnKind()) {
             case Returns:
              $c$.clean(State.$assign($c$.track(MallocMemReturnsAttr(C, CE, I, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
              break;
             case Takes:
             case Holds:
              $c$.clean(State.$assign($c$.track(FreeMemAttr(C, CE, I, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
              break;
            }
          }
        }
      }
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 962,
   FQN="(anonymous namespace)::MallocChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_113MallocChecker13checkPostStmtEPKN5clang10CXXNewExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker13checkPostStmtEPKN5clang10CXXNewExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CXXNewExpr /*P*/ NE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ((NE.getNumPlacementArgs() != 0)) {
        for (Stmt.ConstExprIterator I = NE.placement_arg_begin$Const(), 
            E = NE.placement_arg_end$Const(); I.$noteq(E); I.$preInc())  {
          {
            /*const*/ SymExpr /*P*/ Sym = C.getSVal(I.$star()).getAsSymbol();
            if ((Sym != null)) {
              checkUseAfterFree(Sym, C, I.$star());
            }
          }
        }
      }
      if (!isStandardNewDelete(NE.getOperatorNew(), C.getASTContext())) {
        return;
      }
      
      final ParentMap /*&*/ PM = C.getLocationContext().getParentMap();
      if (!PM.isConsumedExpr_Expr$C$P(NE) && MallocCheckerStatics.treatUnusedNewEscaped(NE)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      // The return value from operator new is bound to a specified initialization
      // value (if any) and we don't want to loose this value. So we call
      // MallocUpdateRefState() instead of MallocMemAux() which breakes the
      // existing binding.
      $c$.clean(State.$assign($c$.track(MallocUpdateRefState(C, NE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), NE.isArray() ? AllocationFamily.AF_CXXNewArray : AllocationFamily.AF_CXXNew))));
      $c$.clean(State.$assign($c$.track(ProcessZeroAllocation(C, NE, 0, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 989,
   FQN="(anonymous namespace)::MallocChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_113MallocChecker12checkPreStmtEPKN5clang13CXXDeleteExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker12checkPreStmtEPKN5clang13CXXDeleteExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CXXDeleteExpr /*P*/ DE, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()) {
        {
          /*const*/ SymExpr /*P*/ Sym = C.getSVal(DE.getArgument$Const()).getAsSymbol();
          if ((Sym != null)) {
            checkUseAfterFree(Sym, C, DE.getArgument$Const());
          }
        }
      }
      if (!isStandardNewDelete(DE.getOperatorDelete(), C.getASTContext())) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      bool$ref ReleasedAllocated = create_bool$ref();
      $c$.clean(State.$assign($c$.track(FreeMemAux(C, DE.getArgument$Const(), DE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
              /*Hold*/ false, ReleasedAllocated))));
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1030,
   FQN="(anonymous namespace)::MallocChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_113MallocChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ Call, 
                      final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (C.wasInlined) {
        return;
      }
      if (!MallocCheckerStatics.isKnownDeallocObjCMethodName(Call)) {
        return;
      }
      {
        
        OptionalBool FreeWhenDone = MallocCheckerStatics.getFreeWhenDoneArg(Call);
        if (FreeWhenDone.$bool()) {
          if (!FreeWhenDone.$star()) {
            return;
          }
        }
      }
      
      bool$ref ReleasedAllocatedMemory = create_bool$ref();
      State = $c$.clean(FreeMemAux(C, Call.getArgExpr(0), 
          Call.getOriginExpr(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), 
          /*Hold=*/ true, ReleasedAllocatedMemory, 
          /*RetNullOnFailure=*/ true));
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // TODO: Blocks should be either inlined or should call invalidate regions
  // upon invocation. After that's in place, special casing here will not be
  // needed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2255,
   FQN="(anonymous namespace)::MallocChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_113MallocChecker13checkPostStmtEPKN5clang9BlockExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker13checkPostStmtEPKN5clang9BlockExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ BlockExpr /*P*/ BE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Scan the BlockDecRefExprs for any object the retain count checker
      // may be tracking.
      if (!BE.getBlockDecl$Const().hasCaptures()) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ BlockDataRegion /*P*/ R = cast_BlockDataRegion(state.$arrow().getSVal(BE, 
    C.getLocationContext()).getAsRegion());
      
      BlockDataRegion.referenced_vars_iterator I = R.referenced_vars_begin();
      BlockDataRegion.referenced_vars_iterator E = R.referenced_vars_end();
      if (I.$eq(E)) {
        return;
      }
      
      SmallVector</*const*/ MemRegion /*P*/ > Regions/*J*/= new SmallVector</*const*/ MemRegion /*P*/ >(10, (/*const*/ MemRegion /*P*/ )null);
      /*const*/ LocationContext /*P*/ LC = C.getLocationContext();
      final MemRegionManager /*&*/ MemMgr = C.getSValBuilder().getRegionManager();
      
      for (; I.$noteq(E); I.$preInc()) {
        /*const*/ VarRegion /*P*/ VR = I.getCapturedRegion();
        if (VR.getSuperRegion() == R) {
          VR = MemMgr.getVarRegion(VR.getDecl(), LC);
        }
        Regions.push_back(VR);
      }
      
      $c$.clean(state.$assign(
          $c$.track($c$.track(state.$arrow().scanReachableSymbols$T2(StopTrackingCallback.class, Regions.data(), 
              Regions.data().$add(Regions.size()))).getState())
      ));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2126,
   FQN="(anonymous namespace)::MallocChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_113MallocChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SymReaper, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefState> RS = null;
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , ReallocPair> RP = null;
    ImmutableMapPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ SymExpr /*P*/ > FR = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!SymReaper.hasDeadSymbols()) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      RS = state.$arrow()./*<RegionState>*/get(ProgramStateTraitRegionState.$Instance);
      final ImmutableMapPtrType.Factory</*const*/ SymExpr /*P*/ , RefState> /*&*/ F = state.$arrow()./*<RegionState>*/get_context(ProgramStateTraitRegionState.$Instance);
      
      SmallVector</*const*/ SymExpr /*P*/ > Errors/*J*/= new SmallVector</*const*/ SymExpr /*P*/ >(2, (/*const*/ SymExpr /*P*/ )null);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefState> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefState> E = null;
      try {
        for (I = RS.begin(), E = RS.end(); I.$noteq(E); I.$preInc()) {
          if (SymReaper.isDead(I.$arrow().first)) {
            if (I.$arrow().second.isAllocated() || I.$arrow().second.isAllocatedOfSizeZero()) {
              Errors.push_back(I.$arrow().first);
            }
            // Remove the dead symbol from the map.
            $c$.clean(RS.$assign($c$.track(F.remove($c$.track(new ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefState>(RS)), I.$arrow().first))));
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      // Cleanup the Realloc Pairs Map.
      RP = state.$arrow()./*<ReallocPairs>*/get(ProgramStateTraitReallocPairs.$Instance);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , ReallocPair> I2 = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , ReallocPair> E2 = null;
      try {
        for (I2 = RP.begin(), E2 = RP.end(); I2.$noteq(E2); I2.$preInc()) {
          if (SymReaper.isDead(I2.$arrow().first)
             || SymReaper.isDead(I2.$arrow().second.ReallocatedSym)) {
            $c$.clean(state.$assign($c$.track(state.$arrow().remove(ProgramStateTraitReallocPairs.$Instance, I2.$arrow().first))));
          }
        }
      } finally {
        if (E2 != null) { E2.$destroy(); }
        if (I2 != null) { I2.$destroy(); }
      }
      
      // Cleanup the FreeReturnValue Map.
      FR = state.$arrow()./*<FreeReturnValue>*/get(ProgramStateTraitFreeReturnValue.$Instance);
      ImmutableMapPtrPtr.iterator</*const*/ SymExpr /*P*/ , /*const*/ SymExpr /*P*/ > I3 = null;
      ImmutableMapPtrPtr.iterator</*const*/ SymExpr /*P*/ , /*const*/ SymExpr /*P*/ > E3 = null;
      try {
        for (I3 = FR.begin(), E3 = FR.end(); I3.$noteq(E3); I3.$preInc()) {
          if (SymReaper.isDead(I3.$arrow().first)
             || SymReaper.isDead(I3.$arrow().second)) {
            $c$.clean(state.$assign($c$.track(state.$arrow().remove(ProgramStateTraitFreeReturnValue.$Instance, I3.$arrow().first))));
          }
        }
      } finally {
        if (E3 != null) { E3.$destroy(); }
        if (I3 != null) { I3.$destroy(); }
      }
      
      // Generate leak node.
      ExplodedNode /*P*/ N = C.getPredecessor();
      if (!Errors.empty()) {
        final/*static*/ CheckerProgramPointTag Tag = checkDeadSymbols$$.Tag;
        $c$.clean(N = C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), $AddrOf(Tag)));
        if ((N != null)) {
          for (type$ptr<SymExpr/*P*/> I4 = $tryClone(Errors.begin()), /*P*/ E4 = $tryClone(Errors.end()); $noteq_ptr(I4, E4); I4.$preInc()) {
            reportLeak(I4.$star(), N, C);
          }
        }
      }
      
      $c$.clean(C.addTransition($c$.track(state.$arrow()./*<RegionState>*/set(ProgramStateTraitRegionState.$Instance, $c$.track(new ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefState>(RS)))), N));
    } finally {
      if (FR != null) { FR.$destroy(); }
      if (RP != null) { RP.$destroy(); }
      if (RS != null) { RS.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }
  private static final class checkDeadSymbols$$ {
    static final/*static*/ CheckerProgramPointTag Tag/*J*/= new CheckerProgramPointTag(new StringRef(/*KEEP_STR*/"MallocChecker"), new StringRef(/*KEEP_STR*/"DeadSymbolsLeak"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2228,
   FQN="(anonymous namespace)::MallocChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_113MallocChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ S, final CheckerContext /*&*/ C) /*const*/ {
   IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
   try {
    /*const*/ Expr /*P*/ E = S.getRetValue$Const();
    if (!(E != null)) {
      return;
    }
    
    // Check if we are returning a symbol.
    State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
    SVal RetVal = State.$arrow().getSVal(E, C.getLocationContext());
    /*const*/ SymExpr /*P*/ Sym = RetVal.getAsSymbol();
    if (!(Sym != null)) {
      {
        // If we are returning a field of the allocated struct or an array element,
        // the callee could still free the memory.
        // TODO: This logic should be a part of generic symbol escape callback.
        /*const*/ MemRegion /*P*/ MR = RetVal.getAsRegion();
        if ((MR != null)) {
          if (isa_FieldRegion(MR) || isa_ElementRegion(MR)) {
            {
              /*const*/ SymbolicRegion /*P*/ BMR = dyn_cast_SymbolicRegion(MR.getBaseRegion());
              if ((BMR != null)) {
                Sym = BMR.getSymbol();
              }
            }
          }
        }
      }
    }
    
    // Check if we are returning freed memory.
    if ((Sym != null)) {
      checkUseAfterFree(Sym, C, E);
    }
   } finally {
    if (State != null) { State.$destroy(); }
   } 
  }

  
  // If a symbolic region is assumed to NULL (or another constant), stop tracking
  // it - assuming that allocation failed on this path.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::evalAssume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2343,
   FQN="(anonymous namespace)::MallocChecker::evalAssume", NM="_ZNK12_GLOBAL__N_113MallocChecker10evalAssumeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS4_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker10evalAssumeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS4_4SValEb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> evalAssume(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
            SVal Cond, 
            boolean Assumption) /*const*/ {
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefState> RS = null;
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , ReallocPair> RP = null;
    try {
      RS = state.$arrow()./*<RegionState>*/get(ProgramStateTraitRegionState.$Instance);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefState> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefState> E = null;
      try {
        for (I = RS.begin(), E = RS.end(); I.$noteq(E); I.$preInc()) {
          ConditionTruthVal AllocFailed = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If the symbol is assumed to be NULL, remove it from consideration.
            final ConstraintManager /*&*/ CMgr = state.$arrow().getConstraintManager();
            AllocFailed = $c$.clean(CMgr.isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), I.getKey()));
            if (AllocFailed.isConstrainedTrue()) {
              $c$.clean(state.$assign($c$.track(state.$arrow()./*<RegionState>*/remove(ProgramStateTraitRegionState.$Instance, I.getKey()))));
            }
          } finally {
            if (AllocFailed != null) { AllocFailed.$destroy(); }
            $c$.$destroy();
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      // Realloc returns 0 when reallocation fails, which means that we should
      // restore the state of the pointer being reallocated.
      RP = state.$arrow()./*<ReallocPairs>*/get(ProgramStateTraitReallocPairs.$Instance);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , ReallocPair> I2= null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , ReallocPair> E2 = null;
      try {
        for (I2 = RP.begin(), E2 = RP.end(); I2.$noteq(E2); I2.$preInc()) {
          ConditionTruthVal AllocFailed = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If the symbol is assumed to be NULL, remove it from consideration.
            final ConstraintManager /*&*/ CMgr = state.$arrow().getConstraintManager();
            AllocFailed = $c$.clean(CMgr.isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), I2.getKey()));
            if (!AllocFailed.isConstrainedTrue()) {
              continue;
            }
            
            /*const*/ SymExpr /*P*/ ReallocSym = I2.getData().ReallocatedSym;
            {
              /*const*/ RefState /*P*/ RS$1 = state.$arrow().get(ProgramStateTraitRegionState.$Instance, ReallocSym);
              if ((RS$1 != null)) {
                if (RS$1.isReleased()) {
                  if (I2.getData().Kind == ReallocPairKind.RPToBeFreedAfterFailure) {
                    $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitRegionState.$Instance, ReallocSym, 
                            RefState.getAllocated(RS$1.getAllocationFamily().getValue(), RS$1.getStmt())))));
                  } else if (I2.getData().Kind == ReallocPairKind.RPDoNotTrackAfterFailure) {
                    $c$.clean(state.$assign($c$.track(state.$arrow().remove(ProgramStateTraitRegionState.$Instance, ReallocSym))));
                  } else {
                    assert (I2.getData().Kind == ReallocPairKind.RPIsFreeOnFailure);
                  }
                }
              }
            }
            $c$.clean(state.$assign($c$.track(state.$arrow().remove(ProgramStateTraitReallocPairs.$Instance, I2.getKey()))));
          } finally {
            if (AllocFailed != null) { AllocFailed.$destroy(); }
            $c$.$destroy();
          }
        }
      } finally {
        if (E2 != null) { E2.$destroy(); }
        if (I2 != null) { I2.$destroy(); }
      }
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    } finally {
      if (RP != null) { RP.$destroy(); }
      if (RS != null) { RS.$destroy(); }
    }
  }

  
  // Check if the location is a freed symbolic region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2332,
   FQN="(anonymous namespace)::MallocChecker::checkLocation", NM="_ZNK12_GLOBAL__N_113MallocChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker13checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkLocation(SVal l, boolean isLoad, /*const*/ Stmt /*P*/ S, 
               final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ SymExpr /*P*/ Sym = l.getLocSymbolInBase();
    if ((Sym != null)) {
      checkUseAfterFree(Sym, C, S);
      checkUseZeroAllocated(Sym, C, S);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPointerEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2553,
   FQN="(anonymous namespace)::MallocChecker::checkPointerEscape", NM="_ZNK12_GLOBAL__N_113MallocChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                    /*const*/ CallEvent /*P*/ Call, 
                    PointerEscapeKind Kind) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(checkPointerEscapeAux($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Escaped, Call, Kind, /*AddrOf*//*FPtr*/MallocCheckerStatics::retTrue));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkConstPointerEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2560,
   FQN="(anonymous namespace)::MallocChecker::checkConstPointerEscape", NM="_ZNK12_GLOBAL__N_113MallocChecker23checkConstPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker23checkConstPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkConstPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                         final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                         /*const*/ CallEvent /*P*/ Call, 
                         PointerEscapeKind Kind) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(checkPointerEscapeAux($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Escaped, Call, Kind, 
          /*AddrOf*//*FPtr*/MallocCheckerStatics::checkIfNewOrNewArrayFamily));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::printState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2705,
   FQN="(anonymous namespace)::MallocChecker::printState", NM="_ZNK12_GLOBAL__N_113MallocChecker10printStateERN4llvm11raw_ostreamENS1_18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKcSB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker10printStateERN4llvm11raw_ostreamENS1_18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKcSB_")
  //</editor-fold>
  @Override public void printState(final raw_ostream /*&*/ Out, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            /*const*/char$ptr/*char P*/ NL, /*const*/char$ptr/*char P*/ Sep) /*const*//* override*/ {
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefState> RS = null;
    try {
      
      RS = State.$arrow().get(ProgramStateTraitRegionState.$Instance);
      if (!RS.isEmpty()) {
        Out.$out(Sep).$out(/*KEEP_STR*/"MallocChecker :").$out(NL);
        ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefState> I = null;
        ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefState> E = null;
        try {
          for (I = RS.begin(), E = RS.end(); I.$noteq(E); I.$preInc()) {
            /*const*/ RefState /*P*/ RefS = State.$arrow().get(ProgramStateTraitRegionState.$Instance, I.getKey());
            AllocationFamily Family = RefS.getAllocationFamily();
            Optional<MallocChecker.CheckKind> CheckKind = getCheckIfTracked(Family);
            if (!CheckKind.hasValue()) {
              CheckKind.$assignMove(getCheckIfTracked(Family, true));
            }
            
            I.getKey().dumpToStream(Out);
            Out.$out(/*KEEP_STR*/" : ");
            I.getData().dump(Out);
            if (CheckKind.hasValue()) {
              Out.$out(/*KEEP_STR*/" (").$out(CheckNames[CheckKind.$star().getValue()].getName()).$out(/*KEEP_STR*/$RPAREN);
            }
            Out.$out(NL);
          }
        } finally {
          if (E != null) { E.$destroy(); }
          if (I != null) { I.$destroy(); }
        }
      }
    } finally {
      if (RS != null) { RS.$destroy(); }
    }
  }

/*private:*/
  private /*mutable */std.unique_ptr<BugType> BT_DoubleFree[/*4*/] = new std.unique_ptr [4];
  private /*mutable */std.unique_ptr<BugType> BT_DoubleDelete;
  private /*mutable */std.unique_ptr<BugType> BT_Leak[/*4*/] = new std.unique_ptr [4];
  private /*mutable */std.unique_ptr<BugType> BT_UseFree[/*4*/] = new std.unique_ptr [4];
  private /*mutable */std.unique_ptr<BugType> BT_BadFree[/*4*/] = new std.unique_ptr [4];
  private /*mutable */std.unique_ptr<BugType> BT_FreeAlloca[/*4*/] = new std.unique_ptr [4];
  private /*mutable */std.unique_ptr<BugType> BT_MismatchedDealloc;
  private /*mutable */std.unique_ptr<BugType> BT_OffsetFree[/*4*/] = new std.unique_ptr [4];
  private /*mutable */std.unique_ptr<BugType> BT_UseZerroAllocated[/*4*/] = new std.unique_ptr [4];
  private /*mutable */IdentifierInfo /*P*/ II_alloca;
  private /*mutable */IdentifierInfo /*P*/ II_win_alloca;
  private /*mutable */IdentifierInfo /*P*/ II_malloc;
  private /*mutable */IdentifierInfo /*P*/ II_free;
  private /*mutable */IdentifierInfo /*P*/ II_realloc;
  private /*mutable */IdentifierInfo /*P*/ II_calloc;
  private /*mutable */IdentifierInfo /*P*/ II_valloc;
  private /*mutable */IdentifierInfo /*P*/ II_reallocf;
  private /*mutable */IdentifierInfo /*P*/ II_strndup;
  private /*mutable */IdentifierInfo /*P*/ II_strdup;
  private /*mutable */IdentifierInfo /*P*/ II_win_strdup;
  private /*mutable */IdentifierInfo /*P*/ II_kmalloc;
  private /*mutable */IdentifierInfo /*P*/ II_if_nameindex;
  private /*mutable */IdentifierInfo /*P*/ II_if_freenameindex;
  private /*mutable */IdentifierInfo /*P*/ II_wcsdup;
  private /*mutable */IdentifierInfo /*P*/ II_win_wcsdup;
  private /*mutable */OptionalULong KernelZeroFlagVal;
  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::initIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 534,
   FQN="(anonymous namespace)::MallocChecker::initIdentifierInfo", NM="_ZNK12_GLOBAL__N_113MallocChecker18initIdentifierInfoERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker18initIdentifierInfoERN5clang10ASTContextE")
  //</editor-fold>
  private void initIdentifierInfo(final ASTContext /*&*/ Ctx) /*const*/ {
    if ((II_malloc != null)) {
      return;
    }
    II_alloca = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"alloca")));
    II_malloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"malloc")));
    II_free = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"free")));
    II_realloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"realloc")));
    II_reallocf = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"reallocf")));
    II_calloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"calloc")));
    II_valloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"valloc")));
    II_strdup = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"strdup")));
    II_strndup = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"strndup")));
    II_wcsdup = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"wcsdup")));
    II_kmalloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"kmalloc")));
    II_if_nameindex = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"if_nameindex")));
    II_if_freenameindex = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"if_freenameindex")));
    
    //MSVC uses `_`-prefixed instead, so we check for them too.
    II_win_strdup = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"_strdup")));
    II_win_wcsdup = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"_wcsdup")));
    II_win_alloca = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"_alloca")));
  }

  
  /// \brief Determine family of a deallocation expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::getAllocationFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1199,
   FQN="(anonymous namespace)::MallocChecker::getAllocationFamily", NM="_ZNK12_GLOBAL__N_113MallocChecker19getAllocationFamilyERN5clang4ento14CheckerContextEPKNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker19getAllocationFamilyERN5clang4ento14CheckerContextEPKNS1_4StmtE")
  //</editor-fold>
  private AllocationFamily getAllocationFamily(final CheckerContext /*&*/ C, 
                     /*const*/ Stmt /*P*/ S) /*const*/ {
    if (!(S != null)) {
      return AllocationFamily.AF_None;
    }
    {
      
      /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(S);
      if ((CE != null)) {
        /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
        if (!(FD != null)) {
          FD = dyn_cast_FunctionDecl(CE.getCalleeDecl$Const());
        }
        
        final ASTContext /*&*/ Ctx = C.getASTContext();
        if (isCMemFunction(FD, Ctx, AllocationFamily.AF_Malloc, MemoryOperationKind.MOK_Any)) {
          return AllocationFamily.AF_Malloc;
        }
        if (isStandardNewDelete(FD, Ctx)) {
          OverloadedOperatorKind Kind = FD.getOverloadedOperator();
          if (Kind == OverloadedOperatorKind.OO_New || Kind == OverloadedOperatorKind.OO_Delete) {
            return AllocationFamily.AF_CXXNew;
          } else if (Kind == OverloadedOperatorKind.OO_Array_New || Kind == OverloadedOperatorKind.OO_Array_Delete) {
            return AllocationFamily.AF_CXXNewArray;
          }
        }
        if (isCMemFunction(FD, Ctx, AllocationFamily.AF_IfNameIndex, MemoryOperationKind.MOK_Any)) {
          return AllocationFamily.AF_IfNameIndex;
        }
        if (isCMemFunction(FD, Ctx, AllocationFamily.AF_Alloca, MemoryOperationKind.MOK_Any)) {
          return AllocationFamily.AF_Alloca;
        }
        
        return AllocationFamily.AF_None;
      }
    }
    {
      
      /*const*/ CXXNewExpr /*P*/ NE = dyn_cast_CXXNewExpr(S);
      if ((NE != null)) {
        return NE.isArray() ? AllocationFamily.AF_CXXNewArray : AllocationFamily.AF_CXXNew;
      }
    }
    {
      
      /*const*/ CXXDeleteExpr /*P*/ DE = dyn_cast_CXXDeleteExpr(S);
      if ((DE != null)) {
        return DE.isArrayForm() ? AllocationFamily.AF_CXXNewArray : AllocationFamily.AF_CXXNew;
      }
    }
    if (isa_ObjCMessageExpr(S)) {
      return AllocationFamily.AF_Malloc;
    }
    
    return AllocationFamily.AF_None;
  }

  
  /// \brief Print names of allocators and deallocators.
  ///
  /// \returns true on success.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::printAllocDeallocName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1244,
   FQN="(anonymous namespace)::MallocChecker::printAllocDeallocName", NM="_ZNK12_GLOBAL__N_113MallocChecker21printAllocDeallocNameERN4llvm11raw_ostreamERN5clang4ento14CheckerContextEPKNS4_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker21printAllocDeallocNameERN4llvm11raw_ostreamERN5clang4ento14CheckerContextEPKNS4_4ExprE")
  //</editor-fold>
  private boolean printAllocDeallocName(final raw_ostream /*&*/ os, final CheckerContext /*&*/ C, 
                       /*const*/ Expr /*P*/ E) /*const*/ {
    {
      /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(E);
      if ((CE != null)) {
        // FIXME: This doesn't handle indirect calls.
        /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee$Const();
        if (!(FD != null)) {
          return false;
        }
        
        $out_raw_ostream_NamedDecl$C(os, $Deref(FD));
        if (!FD.isOverloadedOperator()) {
          os.$out(/*KEEP_STR*/$LPAREN_RPAREN);
        }
        return true;
      }
    }
    {
      
      /*const*/ ObjCMessageExpr /*P*/ Msg = dyn_cast_ObjCMessageExpr(E);
      if ((Msg != null)) {
        if (Msg.isInstanceMessage()) {
          os.$out(/*KEEP_STR*/$MINUS);
        } else {
          os.$out(/*KEEP_STR*/$PLUS);
        }
        Msg.getSelector().print(os);
        return true;
      }
    }
    {
      
      /*const*/ CXXNewExpr /*P*/ NE = dyn_cast_CXXNewExpr(E);
      if ((NE != null)) {
        os.$out(/*KEEP_STR*/$SGL_QUOTE).$out(
            getOperatorSpelling(NE.getOperatorNew().getOverloadedOperator())
        ).$out(
            /*KEEP_STR*/$SGL_QUOTE
        );
        return true;
      }
    }
    {
      
      /*const*/ CXXDeleteExpr /*P*/ DE = dyn_cast_CXXDeleteExpr(E);
      if ((DE != null)) {
        os.$out(/*KEEP_STR*/$SGL_QUOTE).$out(
            getOperatorSpelling(DE.getOperatorDelete().getOverloadedOperator())
        ).$out(
            /*KEEP_STR*/$SGL_QUOTE
        );
        return true;
      }
    }
    
    return false;
  }

  
  /// \brief Print expected name of an allocator based on the deallocator's
  /// family derived from the DeallocExpr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::printExpectedAllocName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1284,
   FQN="(anonymous namespace)::MallocChecker::printExpectedAllocName", NM="_ZNK12_GLOBAL__N_113MallocChecker22printExpectedAllocNameERN4llvm11raw_ostreamERN5clang4ento14CheckerContextEPKNS4_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker22printExpectedAllocNameERN4llvm11raw_ostreamERN5clang4ento14CheckerContextEPKNS4_4ExprE")
  //</editor-fold>
  private void printExpectedAllocName(final raw_ostream /*&*/ os, final CheckerContext /*&*/ C, 
                        /*const*/ Expr /*P*/ E) /*const*/ {
    AllocationFamily Family = getAllocationFamily(C, E);
    switch (Family) {
     case AF_Malloc:
      os.$out(/*KEEP_STR*/"malloc()");
      return;
     case AF_CXXNew:
      os.$out(/*KEEP_STR*/"'new'");
      return;
     case AF_CXXNewArray:
      os.$out(/*KEEP_STR*/"'new[]'");
      return;
     case AF_IfNameIndex:
      os.$out(/*KEEP_STR*/"'if_nameindex()'");
      return;
     case AF_Alloca:
     case AF_None:
      throw new llvm_unreachable("not a deallocation expression");
    }
  }

  /// \brief Print expected name of a deallocator based on the allocator's
  /// family.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::printExpectedDeallocName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1298,
   FQN="(anonymous namespace)::MallocChecker::printExpectedDeallocName", NM="_ZNK12_GLOBAL__N_113MallocChecker24printExpectedDeallocNameERN4llvm11raw_ostreamENS_16AllocationFamilyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker24printExpectedDeallocNameERN4llvm11raw_ostreamENS_16AllocationFamilyE")
  //</editor-fold>
  private void printExpectedDeallocName(final raw_ostream /*&*/ os, 
                          AllocationFamily Family) /*const*/ {
    switch (Family) {
     case AF_Malloc:
      os.$out(/*KEEP_STR*/"free()");
      return;
     case AF_CXXNew:
      os.$out(/*KEEP_STR*/"'delete'");
      return;
     case AF_CXXNewArray:
      os.$out(/*KEEP_STR*/"'delete[]'");
      return;
     case AF_IfNameIndex:
      os.$out(/*KEEP_STR*/"'if_freenameindex()'");
      return;
     case AF_Alloca:
     case AF_None:
      throw new llvm_unreachable("suspicious argument");
    }
  }

  
  ///@{
  /// Check if this is one of the functions which can allocate/reallocate memory
  /// pointed to by one of its arguments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::isMemFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 557,
   FQN="(anonymous namespace)::MallocChecker::isMemFunction", NM="_ZNK12_GLOBAL__N_113MallocChecker13isMemFunctionEPKN5clang12FunctionDeclERNS1_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker13isMemFunctionEPKN5clang12FunctionDeclERNS1_10ASTContextE")
  //</editor-fold>
  private boolean isMemFunction(/*const*/ FunctionDecl /*P*/ FD, final ASTContext /*&*/ C) /*const*/ {
    if (isCMemFunction(FD, C, AllocationFamily.AF_Malloc, MemoryOperationKind.MOK_Any)) {
      return true;
    }
    if (isCMemFunction(FD, C, AllocationFamily.AF_IfNameIndex, MemoryOperationKind.MOK_Any)) {
      return true;
    }
    if (isCMemFunction(FD, C, AllocationFamily.AF_Alloca, MemoryOperationKind.MOK_Any)) {
      return true;
    }
    if (isStandardNewDelete(FD, C)) {
      return true;
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::isCMemFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 573,
   FQN="(anonymous namespace)::MallocChecker::isCMemFunction", NM="_ZNK12_GLOBAL__N_113MallocChecker14isCMemFunctionEPKN5clang12FunctionDeclERNS1_10ASTContextENS_16AllocationFamilyENS0_19MemoryOperationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker14isCMemFunctionEPKN5clang12FunctionDeclERNS1_10ASTContextENS_16AllocationFamilyENS0_19MemoryOperationKindE")
  //</editor-fold>
  private boolean isCMemFunction(/*const*/ FunctionDecl /*P*/ FD, 
                final ASTContext /*&*/ C, 
                AllocationFamily Family, 
                MemoryOperationKind MemKind) /*const*/ {
    if (!(FD != null)) {
      return false;
    }
    
    boolean CheckFree = (MemKind == MemoryOperationKind.MOK_Any
       || MemKind == MemoryOperationKind.MOK_Free);
    boolean CheckAlloc = (MemKind == MemoryOperationKind.MOK_Any
       || MemKind == MemoryOperationKind.MOK_Allocate);
    if (FD.getKind() == Decl.Kind.Function) {
      /*const*/ IdentifierInfo /*P*/ FunI = FD.getIdentifier();
      initIdentifierInfo(C);
      if (Family == AllocationFamily.AF_Malloc && CheckFree) {
        if (FunI == II_free || FunI == II_realloc || FunI == II_reallocf) {
          return true;
        }
      }
      if (Family == AllocationFamily.AF_Malloc && CheckAlloc) {
        if (FunI == II_malloc || FunI == II_realloc || FunI == II_reallocf
           || FunI == II_calloc || FunI == II_valloc || FunI == II_strdup
           || FunI == II_win_strdup || FunI == II_strndup || FunI == II_wcsdup
           || FunI == II_win_wcsdup || FunI == II_kmalloc) {
          return true;
        }
      }
      if (Family == AllocationFamily.AF_IfNameIndex && CheckFree) {
        if (FunI == II_if_freenameindex) {
          return true;
        }
      }
      if (Family == AllocationFamily.AF_IfNameIndex && CheckAlloc) {
        if (FunI == II_if_nameindex) {
          return true;
        }
      }
      if (Family == AllocationFamily.AF_Alloca && CheckAlloc) {
        if (FunI == II_alloca || FunI == II_win_alloca) {
          return true;
        }
      }
    }
    if (Family != AllocationFamily.AF_Malloc) {
      return false;
    }
    if (IsOptimistic.$ConstBoolRef() && FD.hasAttrs()) {
      for (/*const*/ OwnershipAttr /*P*/ I : FD.specific_attrs(OwnershipAttr.class)) {
        OwnershipAttr.OwnershipKind OwnKind = I.getOwnKind();
        if (OwnKind == OwnershipAttr.OwnershipKind.Takes || OwnKind == OwnershipAttr.OwnershipKind.Holds) {
          if (CheckFree) {
            return true;
          }
        } else if (OwnKind == OwnershipAttr.OwnershipKind.Returns) {
          if (CheckAlloc) {
            return true;
          }
        }
      }
    }
    
    return false;
  }

  
  // Tells if the callee is one of the following:
  // 1) A global non-placement new/delete operator function.
  // 2) A global placement operator function with the single placement argument
  //    of type std::nothrow_t.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::isStandardNewDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 641,
   FQN="(anonymous namespace)::MallocChecker::isStandardNewDelete", NM="_ZNK12_GLOBAL__N_113MallocChecker19isStandardNewDeleteEPKN5clang12FunctionDeclERNS1_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker19isStandardNewDeleteEPKN5clang12FunctionDeclERNS1_10ASTContextE")
  //</editor-fold>
  private boolean isStandardNewDelete(/*const*/ FunctionDecl /*P*/ FD, 
                     final ASTContext /*&*/ C) /*const*/ {
    if (!(FD != null)) {
      return false;
    }
    
    OverloadedOperatorKind Kind = FD.getOverloadedOperator();
    if (Kind != OverloadedOperatorKind.OO_New && Kind != OverloadedOperatorKind.OO_Array_New
       && Kind != OverloadedOperatorKind.OO_Delete && Kind != OverloadedOperatorKind.OO_Array_Delete) {
      return false;
    }
    
    // Skip all operator new/delete methods.
    if (isa_CXXMethodDecl(FD)) {
      return false;
    }
    
    // Return true if tested operator is a standard placement nothrow operator.
    if (FD.getNumParams() == 2) {
      QualType T = FD.getParamDecl$Const(1).getType();
      {
        /*const*/ IdentifierInfo /*P*/ II = T.getBaseTypeIdentifier();
        if ((II != null)) {
          return II.getName().equals(/*STRINGREF_STR*/"nothrow_t");
        }
      }
    }
    
    // Skip placement operators.
    if (FD.getNumParams() != 1 || FD.isVariadic()) {
      return false;
    }
    
    // One of the standard new/new[]/delete/delete[] non-placement operators.
    return true;
  }

  ///@}
  
  /// \brief Perform a zero-allocation check.
  
  // Performs a 0-sized allocations check.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ProcessZeroAllocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 861,
   FQN="(anonymous namespace)::MallocChecker::ProcessZeroAllocation", NM="_ZNK12_GLOBAL__N_113MallocChecker21ProcessZeroAllocationERN5clang4ento14CheckerContextEPKNS1_4ExprEjN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker21ProcessZeroAllocationERN5clang4ento14CheckerContextEPKNS1_4ExprEjN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> ProcessZeroAllocation(final CheckerContext /*&*/ C, 
                       /*const*/ Expr /*P*/ E, 
                       /*const*//*uint*/int AllocationSizeArg, 
                       IntrusiveRefCntPtr</*const*/ ProgramState> State) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> TrueState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> FalseState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!State.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      /*const*/ Expr /*P*/ Arg = null;
      {
        
        /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(E);
        if ((CE != null)) {
          Arg = CE.getArg$Const(AllocationSizeArg);
        } else {
          /*const*/ CXXNewExpr /*P*/ NE = dyn_cast_CXXNewExpr(E);
          if ((NE != null)) {
            if (NE.isArray()) {
              Arg = NE.getArraySize$Const();
            } else {
              return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
            }
          } else {
            throw new llvm_unreachable("not a CallExpr or CXXNewExpr");
          }
        }
      }
      assert Native.$bool(Arg);
      
      Optional<DefinedSVal> DefArgVal = State.$arrow().getSVal(Arg, C.getLocationContext()).getAs(DefinedSVal.class);
      if (!DefArgVal.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      // Check if the allocation size is 0.
      TrueState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      FalseState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      final SValBuilder /*&*/ SvalBuilder = C.getSValBuilder();
      DefinedSVal Zero = SvalBuilder.makeZeroVal(Arg.getType()).castAs(DefinedSVal.class);
      
//      $c$.clean(std.tie(TrueState, FalseState).$assign(
//          $c$.track(State.$arrow().assume(SvalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedOrUnknownSVal(DefArgVal.$star()), new DefinedOrUnknownSVal(Zero))))
//      ));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(State.$arrow().assume(SvalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedOrUnknownSVal(DefArgVal.$star()), new DefinedOrUnknownSVal(Zero))));
      TrueState.$assign($assume.first);
      FalseState.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      if (TrueState.$bool() && !FalseState.$bool()) {
        SVal retVal = State.$arrow().getSVal(E, C.getLocationContext());
        /*const*/ SymExpr /*P*/ Sym = retVal.getAsLocSymbol();
        if (!(Sym != null)) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
        }
        
        /*const*/ RefState /*P*/ RS = State.$arrow().get(ProgramStateTraitRegionState.$Instance, Sym);
        if ((RS != null)) {
          if (RS.isAllocated()) {
            return TrueState.$arrow().set(ProgramStateTraitRegionState.$Instance, Sym, 
                RefState.getAllocatedOfSizeZero(RS));
          } else {
            return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
          }
        } else {
          // Case of zero-size realloc. Historically 'realloc(ptr, 0)' is treated as
          // 'free(ptr)' and the returned value from 'realloc(ptr, 0)' is not
          // tracked. Add zero-reallocated Sym to the state to catch references
          // to zero-allocated memory.
          return TrueState.$arrow().add(ProgramStateTraitReallocSizeZeroSymbols.$Instance, Sym);
        }
      }
      
      // Assume the value is non-zero going forward.
      assert ((FalseState).$bool());
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, FalseState);
    } finally {
      if (FalseState != null) { FalseState.$destroy(); }
      if (TrueState != null) { TrueState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocMemReturnsAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1051,
   FQN="(anonymous namespace)::MallocChecker::MallocMemReturnsAttr", NM="_ZNK12_GLOBAL__N_113MallocChecker20MallocMemReturnsAttrERN5clang4ento14CheckerContextEPKNS1_8CallExprEPKNS1_13OwnershipAttrEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker20MallocMemReturnsAttrERN5clang4ento14CheckerContextEPKNS1_8CallExprEPKNS1_13OwnershipAttrEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> MallocMemReturnsAttr(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
                      /*const*/ OwnershipAttr /*P*/ Att, 
                      IntrusiveRefCntPtr</*const*/ ProgramState> State) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!State.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      if (Att.getModule() != II_malloc) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      uint$ptr/*uint P*/ I = $tryClone(Att.args_begin());
      uint$ptr/*uint P*/ E = $tryClone(Att.args_end());
      if ($noteq_ptr(I, E)) {
        return $c$.clean(MallocMemAux(C, CE, CE.getArg$Const(I.$star()), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      }
      return $c$.clean(MallocMemAux(C, CE, new SVal(JD$Move.INSTANCE, new UnknownVal()), new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocMemAux">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1068,
   FQN="(anonymous namespace)::MallocChecker::MallocMemAux", NM="_ZN12_GLOBAL__N_113MallocChecker12MallocMemAuxERN5clang4ento14CheckerContextEPKNS1_8CallExprEPKNS1_4ExprENS2_4SValEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS_16AllocationFamilyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker12MallocMemAuxERN5clang4ento14CheckerContextEPKNS1_8CallExprEPKNS1_4ExprENS2_4SValEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS_16AllocationFamilyE")
  //</editor-fold>
  private static IntrusiveRefCntPtr</*const*/ ProgramState> MallocMemAux(final CheckerContext /*&*/ C, 
              /*const*/ CallExpr /*P*/ CE, 
              /*const*/ Expr /*P*/ SizeEx, SVal Init, 
              IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    return MallocMemAux(C, 
              CE, 
              SizeEx, Init, 
              State, 
              AllocationFamily.AF_Malloc);
  }
  private static IntrusiveRefCntPtr</*const*/ ProgramState> MallocMemAux(final CheckerContext /*&*/ C, 
              /*const*/ CallExpr /*P*/ CE, 
              /*const*/ Expr /*P*/ SizeEx, SVal Init, 
              IntrusiveRefCntPtr</*const*/ ProgramState> State, 
              AllocationFamily Family/*= AF_Malloc*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!State.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      return $c$.clean(MallocMemAux(C, CE, State.$arrow().getSVal(SizeEx, C.getLocationContext()), 
          new SVal(Init), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Family));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocMemAux">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1080,
   FQN="(anonymous namespace)::MallocChecker::MallocMemAux", NM="_ZN12_GLOBAL__N_113MallocChecker12MallocMemAuxERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValES8_N4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS_16AllocationFamilyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker12MallocMemAuxERN5clang4ento14CheckerContextEPKNS1_8CallExprENS2_4SValES8_N4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS_16AllocationFamilyE")
  //</editor-fold>
  private static IntrusiveRefCntPtr</*const*/ ProgramState> MallocMemAux(final CheckerContext /*&*/ C, 
              /*const*/ CallExpr /*P*/ CE, 
              SVal Size, SVal Init, 
              IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    return MallocMemAux(C, 
              CE, 
              Size, Init, 
              State, 
              AllocationFamily.AF_Malloc);
  }
  private static IntrusiveRefCntPtr</*const*/ ProgramState> MallocMemAux(final CheckerContext /*&*/ C, 
              /*const*/ CallExpr /*P*/ CE, 
              SVal Size, SVal Init, 
              IntrusiveRefCntPtr</*const*/ ProgramState> State, 
              AllocationFamily Family/*= AF_Malloc*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!State.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // We expect the malloc functions to return a pointer.
      if (!Loc.isLocType(CE.getType())) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // Bind the return value to the symbolic value from the heap region.
      // TODO: We could rewrite post visit to eval call; 'malloc' does not have
      // side effects other than what we model here.
      /*uint*/int Count = C.blockCount();
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      /*const*/ LocationContext /*P*/ LCtx = C.getPredecessor().getLocationContext();
      DefinedSVal RetVal = svalBuilder.getConjuredHeapSymbolVal(CE, LCtx, Count).castAs(DefinedSVal.class);
      $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(CE, C.getLocationContext(), new SVal(RetVal)))));
      
      // Fill the region with the initialization value.
      $c$.clean(State.$assign($c$.track(State.$arrow().bindDefault(new SVal(RetVal), new SVal(Init)))));
      
      // Set the region's extent equal to the Size parameter.
      /*const*/ SymbolicRegion /*P*/ R = dyn_cast_or_null_SymbolicRegion(RetVal.getAsRegion());
      if (!(R != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      {
        Optional<DefinedOrUnknownSVal> DefinedSize = Size.getAs(DefinedOrUnknownSVal.class);
        if (DefinedSize.$bool()) {
          final SValBuilder /*&*/ svalBuilder$1 = C.getSValBuilder();
          DefinedOrUnknownSVal Extent = R.getExtent(svalBuilder$1);
          DefinedOrUnknownSVal extentMatchesSize = $c$.clean(svalBuilder$1.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedOrUnknownSVal(Extent), new DefinedOrUnknownSVal(DefinedSize.$star())));
          
          $c$.clean(State.$assign($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(extentMatchesSize), true))));
          assert ((State).$bool());
        }
      }
      
      return $c$.clean(MallocUpdateRefState(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Family));
    } finally {
      $c$.$destroy();
    }
  }

  
  // Check if this malloc() for special flags. At present that means M_ZERO or
  // __GFP_ZERO (in which case, treat it like calloc).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::performKernelMalloc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 670,
   FQN="(anonymous namespace)::MallocChecker::performKernelMalloc", NM="_ZNK12_GLOBAL__N_113MallocChecker19performKernelMallocEPKN5clang8CallExprERNS1_4ento14CheckerContextERKN4llvm18IntrusiveRefCntPtrIKNS5_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker19performKernelMallocEPKN5clang8CallExprERNS1_4ento14CheckerContextERKN4llvm18IntrusiveRefCntPtrIKNS5_12ProgramStateEEE")
  //</editor-fold>
  private Optional<IntrusiveRefCntPtr</*const*/ ProgramState> > performKernelMalloc(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C, final /*const*/ IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ State) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> TrueState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> FalseState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // 3-argument malloc(), as commonly used in {Free,Net,Open}BSD Kernels:
      //
      // void *malloc(unsigned long size, struct malloc_type *mtp, int flags);
      //
      // One of the possible flags is M_ZERO, which means 'give me back an
      // allocation which is already zeroed', like calloc.
      
      // 2-argument kmalloc(), as used in the Linux kernel:
      //
      // void *kmalloc(size_t size, gfp_t flags);
      //
      // Has the similar flag value __GFP_ZERO.
      
      // This logic is largely cloned from O_CREAT in UnixAPIChecker, maybe some
      // code could be shared.
      final ASTContext /*&*/ Ctx = C.getASTContext();
      Triple.OSType OS = Ctx.getTargetInfo().getTriple().getOS();
      if (!KernelZeroFlagVal.hasValue()) {
        if (OS == Triple.OSType.FreeBSD) {
          KernelZeroFlagVal.$assign_T$RR($int2ullong(0x0100));
        } else if (OS == Triple.OSType.NetBSD) {
          KernelZeroFlagVal.$assign_T$RR($int2ullong(0x0002));
        } else if (OS == Triple.OSType.OpenBSD) {
          KernelZeroFlagVal.$assign_T$RR($int2ullong(0x0008));
        } else if (OS == Triple.OSType.Linux) {
          // __GFP_ZERO
          KernelZeroFlagVal.$assign_T$RR($int2ullong(0x8000));
        } else {
          // FIXME: We need a more general way of getting the M_ZERO value.
          // See also: O_CREAT in UnixAPIChecker.cpp.
          
          // Fall back to normal malloc behavior on platforms where we don't
          // know M_ZERO.
          return new Optional<IntrusiveRefCntPtr</*const*/ ProgramState> >(None);
        }
      }
      
      // We treat the last argument as the flags argument, and callers fall-back to
      // normal malloc on a None return. This works for the FreeBSD kernel malloc
      // as well as Linux kmalloc.
      if ($less_uint(CE.getNumArgs(), 2)) {
        return new Optional<IntrusiveRefCntPtr</*const*/ ProgramState> >(None);
      }
      
      /*const*/ Expr /*P*/ FlagsEx = CE.getArg$Const(CE.getNumArgs() - 1);
      /*const*/ SVal V = State.$arrow().getSVal(FlagsEx, C.getLocationContext());
      if (!V.getAs(NonLoc.class).$bool()) {
        // The case where 'V' can be a location can only be due to a bad header,
        // so in this case bail out.
        return new Optional<IntrusiveRefCntPtr</*const*/ ProgramState> >(None);
      }
      
      NonLoc Flags = V.castAs(NonLoc.class);
      NonLoc ZeroFlag = C.getSValBuilder().
    makeIntVal(KernelZeroFlagVal.getValue(), FlagsEx.getType()).castAs(NonLoc.class);
      SVal MaskedFlagsUC = $c$.clean(C.getSValBuilder().evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), BinaryOperatorKind.BO_And, 
          new NonLoc(Flags), new NonLoc(ZeroFlag), 
          FlagsEx.getType()));
      if (MaskedFlagsUC.isUnknownOrUndef$SVal()) {
        return new Optional<IntrusiveRefCntPtr</*const*/ ProgramState> >(None);
      }
      DefinedSVal MaskedFlags = MaskedFlagsUC.castAs(DefinedSVal.class);
      
      // Check if maskedFlags is non-zero.
      TrueState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      FalseState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(TrueState, FalseState).$assign($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(MaskedFlags)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(MaskedFlags)));
      TrueState.$assign($assume.first);
      FalseState.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      // If M_ZERO is set, treat this like calloc (initialized).
      if (TrueState.$bool() && !FalseState.$bool()) {
        SVal ZeroVal = new SVal(JD$Move.INSTANCE, C.getSValBuilder().makeZeroVal(Ctx.CharTy.$QualType()));
        return $c$.clean(new Optional<IntrusiveRefCntPtr</*const*/ ProgramState> >(JD$T$RR.INSTANCE, $c$.track(MallocMemAux(C, CE, CE.getArg$Const(0), new SVal(ZeroVal), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(TrueState))))));
      }
      
      return new Optional<IntrusiveRefCntPtr</*const*/ ProgramState> >(None);
    } finally {
      if (FalseState != null) { FalseState.$destroy(); }
      if (TrueState != null) { TrueState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Update the RefState to reflect the new memory allocation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocUpdateRefState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1124,
   FQN="(anonymous namespace)::MallocChecker::MallocUpdateRefState", NM="_ZN12_GLOBAL__N_113MallocChecker20MallocUpdateRefStateERN5clang4ento14CheckerContextEPKNS1_4ExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS_16AllocationFamilyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker20MallocUpdateRefStateERN5clang4ento14CheckerContextEPKNS1_4ExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS_16AllocationFamilyE")
  //</editor-fold>
  private static IntrusiveRefCntPtr</*const*/ ProgramState> MallocUpdateRefState(final CheckerContext /*&*/ C, 
                      /*const*/ Expr /*P*/ E, 
                      IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    return MallocUpdateRefState(C, 
                      E, 
                      State, 
                      AllocationFamily.AF_Malloc);
  }
  private static IntrusiveRefCntPtr</*const*/ ProgramState> MallocUpdateRefState(final CheckerContext /*&*/ C, 
                      /*const*/ Expr /*P*/ E, 
                      IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                      AllocationFamily Family/*= AF_Malloc*/) {
    if (!State.$bool()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    
    // Get the return value.
    SVal retVal = State.$arrow().getSVal(E, C.getLocationContext());
    
    // We expect the malloc functions to return a pointer.
    if (!retVal.getAs(Loc.class).$bool()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    
    /*const*/ SymExpr /*P*/ Sym = retVal.getAsLocSymbol();
    assert Native.$bool(Sym);
    
    // Set the symbol's state to Allocated.
    return State.$arrow().set(ProgramStateTraitRegionState.$Instance, Sym, RefState.getAllocated(Family.getValue(), E));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::FreeMemAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1145,
   FQN="(anonymous namespace)::MallocChecker::FreeMemAttr", NM="_ZNK12_GLOBAL__N_113MallocChecker11FreeMemAttrERN5clang4ento14CheckerContextEPKNS1_8CallExprEPKNS1_13OwnershipAttrEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker11FreeMemAttrERN5clang4ento14CheckerContextEPKNS1_8CallExprEPKNS1_13OwnershipAttrEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> FreeMemAttr(final CheckerContext /*&*/ C, 
             /*const*/ CallExpr /*P*/ CE, 
             /*const*/ OwnershipAttr /*P*/ Att, 
             IntrusiveRefCntPtr</*const*/ ProgramState> State) /*const*/ {
    if (!State.$bool()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    if (Att.getModule() != II_malloc) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    }
    
    bool$ref ReleasedAllocated = create_bool$ref(false);
    
    for (final /*const*/int/*uint &*/ Arg : Att.args()) {
      IntrusiveRefCntPtr</*const*/ ProgramState> StateI = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        StateI = $c$.clean(FreeMemAux(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Arg, 
            Att.getOwnKind() == OwnershipAttr.OwnershipKind.Holds, 
            ReleasedAllocated));
        if (StateI.$bool()) {
          $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StateI))));
        }
      } finally {
        if (StateI != null) { StateI.$destroy(); }
        $c$.$destroy();
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::FreeMemAux">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1167,
   FQN="(anonymous namespace)::MallocChecker::FreeMemAux", NM="_ZNK12_GLOBAL__N_113MallocChecker10FreeMemAuxERN5clang4ento14CheckerContextEPKNS1_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEjbRbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker10FreeMemAuxERN5clang4ento14CheckerContextEPKNS1_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEjbRbb")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> FreeMemAux(final CheckerContext /*&*/ C, 
            /*const*/ CallExpr /*P*/ CE, 
            IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            /*uint*/int Num, 
            boolean Hold, 
            final bool$ref/*bool &*/ ReleasedAllocated) /*const*/ {
    return FreeMemAux(C, 
            CE, 
            State, 
            Num, 
            Hold, 
            ReleasedAllocated, 
            false);
  }
  private IntrusiveRefCntPtr</*const*/ ProgramState> FreeMemAux(final CheckerContext /*&*/ C, 
            /*const*/ CallExpr /*P*/ CE, 
            IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            /*uint*/int Num, 
            boolean Hold, 
            final bool$ref/*bool &*/ ReleasedAllocated, 
            boolean ReturnsNullOnFailure/*= false*/) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!State.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      if ($less_uint(CE.getNumArgs(), (Num + 1))) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      return $c$.clean(FreeMemAux(C, CE.getArg$Const(Num), CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Hold, 
          ReleasedAllocated, ReturnsNullOnFailure));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::FreeMemAux">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1310,
   FQN="(anonymous namespace)::MallocChecker::FreeMemAux", NM="_ZNK12_GLOBAL__N_113MallocChecker10FreeMemAuxERN5clang4ento14CheckerContextEPKNS1_4ExprES7_N4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEbRbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker10FreeMemAuxERN5clang4ento14CheckerContextEPKNS1_4ExprES7_N4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEbRbb")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> FreeMemAux(final CheckerContext /*&*/ C, 
            /*const*/ Expr /*P*/ ArgExpr, 
            /*const*/ Expr /*P*/ ParentExpr, 
            IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            boolean Hold, 
            final bool$ref/*bool &*/ ReleasedAllocated) /*const*/ {
    return FreeMemAux(C, 
            ArgExpr, 
            ParentExpr, 
            State, 
            Hold, 
            ReleasedAllocated, 
            false);
  }
  private IntrusiveRefCntPtr</*const*/ ProgramState> FreeMemAux(final CheckerContext /*&*/ C, 
            /*const*/ Expr /*P*/ ArgExpr, 
            /*const*/ Expr /*P*/ ParentExpr, 
            IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            boolean Hold, 
            final bool$ref/*bool &*/ ReleasedAllocated, 
            boolean ReturnsNullOnFailure/*= false*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> notNullState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> nullState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!State.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      SVal ArgVal = State.$arrow().getSVal(ArgExpr, C.getLocationContext());
      if (!ArgVal.getAs(DefinedOrUnknownSVal.class).$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      DefinedOrUnknownSVal location = ArgVal.castAs(DefinedOrUnknownSVal.class);
      
      // Check for null dereferences.
      if (!location.getAs(Loc.class).$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // The explicit NULL case, no operation is performed.
      notNullState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      nullState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(notNullState, nullState).$assign($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(location)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(location)));
      notNullState.$assign($assume.first);
      nullState.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      if (nullState.$bool() && !notNullState.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // Unknown values could easily be okay
      // Undefined values are handled elsewhere
      if (ArgVal.isUnknownOrUndef$SVal()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      /*const*/ MemRegion /*P*/ R = ArgVal.getAsRegion();
      
      // Nonlocs can't be freed, of course.
      // Non-region locations (labels and fixed addresses) also shouldn't be freed.
      if (!(R != null)) {
        ReportBadFree(C, new SVal(ArgVal), ArgExpr.getSourceRange(), ParentExpr);
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      R = R.StripCasts();
      
      // Blocks might show up as heap data, but should not be free()d
      if (isa_BlockDataRegion(R)) {
        ReportBadFree(C, new SVal(ArgVal), ArgExpr.getSourceRange(), ParentExpr);
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      /*const*/ MemSpaceRegion /*P*/ MS = R.getMemorySpace();
      
      // Parameters, locals, statics, globals, and memory returned by
      // __builtin_alloca() shouldn't be freed.
      if (!(isa_UnknownSpaceRegion(MS) || isa_HeapSpaceRegion(MS))) {
        // FIXME: at the time this code was written, malloc() regions were
        // represented by conjured symbols, which are all in UnknownSpaceRegion.
        // This means that there isn't actually anything from HeapSpaceRegion
        // that should be freed, even though we allow it here.
        // Of course, free() can work on memory allocated outside the current
        // function, so UnknownSpaceRegion is always a possibility.
        // False negatives are better than false positives.
        if (isa_AllocaRegion(R)) {
          ReportFreeAlloca(C, new SVal(ArgVal), ArgExpr.getSourceRange());
        } else {
          ReportBadFree(C, new SVal(ArgVal), ArgExpr.getSourceRange(), ParentExpr);
        }
        
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      /*const*/ SymbolicRegion /*P*/ SrBase = dyn_cast_SymbolicRegion(R.getBaseRegion());
      // Various cases could lead to non-symbol values here.
      // For now, ignore them.
      if (!(SrBase != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      /*const*/ SymExpr /*P*/ SymBase = SrBase.getSymbol();
      /*const*/ RefState /*P*/ RsBase = State.$arrow().get(ProgramStateTraitRegionState.$Instance, SymBase);
      type$ref</*const*/ SymExpr /*P*/ > PreviousRetStatusSymbol = create_type$null$ref(null);
      if ((RsBase != null)) {
        
        // Memory returned by alloca() shouldn't be freed.
        if (RsBase.getAllocationFamily() == AllocationFamily.AF_Alloca) {
          ReportFreeAlloca(C, new SVal(ArgVal), ArgExpr.getSourceRange());
          return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
        }
        
        // Check for double free first.
        if ($c$.clean((RsBase.isReleased() || RsBase.isRelinquished())
           && !MallocCheckerStatics.didPreviousFreeFail($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), SymBase, PreviousRetStatusSymbol))) {
          ReportDoubleFree(C, ParentExpr.getSourceRange(), RsBase.isReleased(), 
              SymBase, PreviousRetStatusSymbol.$deref());
          return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
          // If the pointer is allocated or escaped, but we are now trying to free it,
          // check that the call to free is proper.
        } else if (RsBase.isAllocated() || RsBase.isAllocatedOfSizeZero()
           || RsBase.isEscaped()) {
          
          // Check if an expected deallocation function matches the real one.
          boolean DeallocMatchesAlloc = RsBase.getAllocationFamily() == getAllocationFamily(C, ParentExpr);
          if (!DeallocMatchesAlloc) {
            ReportMismatchedDealloc(C, ArgExpr.getSourceRange(), 
                ParentExpr, RsBase, SymBase, Hold);
            return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
          }
          
          // Check if the memory location being freed is the actual location
          // allocated, or an offset.
          RegionOffset Offset = R.getAsOffset();
          if (Offset.isValid()
             && !Offset.hasSymbolicOffset()
             && Offset.getOffset() != 0) {
            /*const*/ Expr /*P*/ AllocExpr = cast_Expr(RsBase.getStmt());
            ReportOffsetFree(C, new SVal(ArgVal), ArgExpr.getSourceRange(), ParentExpr, 
                AllocExpr);
            return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
          }
        }
      }
      
      ReleasedAllocated.$set((RsBase != null) && (RsBase.isAllocated()
         || RsBase.isAllocatedOfSizeZero()));
      
      // Clean out the info on previous call to free return info.
      $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitFreeReturnValue.$Instance, SymBase))));
      
      // Keep track of the return value. If it is NULL, we will know that free
      // failed.
      if (ReturnsNullOnFailure) {
        SVal RetVal = C.getSVal(ParentExpr);
        /*const*/ SymExpr /*P*/ RetStatusSymbol = RetVal.getAsSymbol();
        if ((RetStatusSymbol != null)) {
          C.getSymbolManager().addSymbolDependency(SymBase, RetStatusSymbol);
          $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitFreeReturnValue.$Instance, SymBase, RetStatusSymbol))));
        }
      }
      
      AllocationFamily Family = (RsBase != null) ? RsBase.getAllocationFamily() : getAllocationFamily(C, ParentExpr);
      // Normal free.
      if (Hold) {
        return State.$arrow().set(ProgramStateTraitRegionState.$Instance, SymBase, 
            RefState.getRelinquished(Family.getValue(), 
                ParentExpr));
      }
      
      return State.$arrow().set(ProgramStateTraitRegionState.$Instance, SymBase, 
          RefState.getReleased(Family.getValue(), ParentExpr));
    } finally {
      if (nullState != null) { nullState.$destroy(); }
      if (notNullState != null) { notNullState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReallocMem">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1892,
   FQN="(anonymous namespace)::MallocChecker::ReallocMem", NM="_ZNK12_GLOBAL__N_113MallocChecker10ReallocMemERN5clang4ento14CheckerContextEPKNS1_8CallExprEbN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker10ReallocMemERN5clang4ento14CheckerContextEPKNS1_8CallExprEbN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> ReallocMem(final CheckerContext /*&*/ C, 
            /*const*/ CallExpr /*P*/ CE, 
            boolean FreesOnFail, 
            IntrusiveRefCntPtr</*const*/ ProgramState> State) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> StatePtrIsNull = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StatePtrNotNull = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StateSizeIsZero = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StateSizeNotZero = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!State.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      if ($less_uint(CE.getNumArgs(), 2)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      /*const*/ Expr /*P*/ arg0Expr = CE.getArg$Const(0);
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      SVal Arg0Val = State.$arrow().getSVal(arg0Expr, LCtx);
      if (!Arg0Val.getAs(DefinedOrUnknownSVal.class).$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      DefinedOrUnknownSVal arg0Val = Arg0Val.castAs(DefinedOrUnknownSVal.class);
      
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      
      DefinedOrUnknownSVal PtrEQ = $c$.clean(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedOrUnknownSVal(arg0Val), new DefinedOrUnknownSVal(JD$Move.INSTANCE, svalBuilder.makeNull())));
      
      // Get the size argument. If there is no size arg then give up.
      /*const*/ Expr /*P*/ Arg1 = CE.getArg$Const(1);
      if (!(Arg1 != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      // Get the value of the size argument.
      SVal Arg1ValG = State.$arrow().getSVal(Arg1, LCtx);
      if (!Arg1ValG.getAs(DefinedOrUnknownSVal.class).$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      DefinedOrUnknownSVal Arg1Val = Arg1ValG.castAs(DefinedOrUnknownSVal.class);
      
      // Compare the size argument to 0.
      DefinedOrUnknownSVal SizeZero = $c$.clean(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new DefinedOrUnknownSVal(Arg1Val), 
          new DefinedOrUnknownSVal(JD$Move.INSTANCE, svalBuilder.makeIntValWithPtrWidth($int2ulong(0), false))));
      
      StatePtrIsNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      StatePtrNotNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(StatePtrIsNull, StatePtrNotNull).$assign($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(PtrEQ)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume$1 = 
              $c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(PtrEQ)));
      StatePtrIsNull.$assign($assume$1.first);
      StatePtrNotNull.$assign($assume$1.second);
      assert !$assume$1.first.$bool();
      assert !$assume$1.second.$bool();
      $c$.clean();
      
      StateSizeIsZero/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      StateSizeNotZero/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(StateSizeIsZero, StateSizeNotZero).$assign($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(SizeZero)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume$2 = 
              $c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(SizeZero)));
      StateSizeIsZero.$assign($assume$2.first);
      StateSizeNotZero.$assign($assume$2.second);
      assert !$assume$2.first.$bool();
      assert !$assume$2.second.$bool();
      $c$.clean();
      
      // We only assume exceptional states if they are definitely true; if the
      // state is under-constrained, assume regular realloc behavior.
      boolean PrtIsNull = StatePtrIsNull.$bool() && !StatePtrNotNull.$bool();
      boolean SizeIsZero = StateSizeIsZero.$bool() && !StateSizeNotZero.$bool();
      
      // If the ptr is NULL and the size is not 0, the call is equivalent to
      // malloc(size).
      if (PrtIsNull && !SizeIsZero) {
        IntrusiveRefCntPtr</*const*/ ProgramState> stateMalloc = null;
        try {
          stateMalloc = $c$.clean(MallocMemAux(C, CE, CE.getArg$Const(1), 
              new SVal(JD$Move.INSTANCE, new UndefinedVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StatePtrIsNull))));
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, stateMalloc);
        } finally {
          if (stateMalloc != null) { stateMalloc.$destroy(); }
        }
      }
      if (PrtIsNull && SizeIsZero) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      // Get the from and to pointer symbols as in toPtr = realloc(fromPtr, size).
      assert (!PrtIsNull);
      /*const*/ SymExpr /*P*/ FromPtr = arg0Val.getAsSymbol();
      SVal RetVal = State.$arrow().getSVal(CE, LCtx);
      /*const*/ SymExpr /*P*/ ToPtr = RetVal.getAsSymbol();
      if (!(FromPtr != null) || !(ToPtr != null)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      bool$ref ReleasedAllocated = create_bool$ref(false);
      
      // If the size is 0, free the memory.
      if (SizeIsZero) {
        {
          IntrusiveRefCntPtr</*const*/ ProgramState> stateFree = null;
          try {
            stateFree = $c$.clean(FreeMemAux(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StateSizeIsZero)), 0, 
                false, ReleasedAllocated));
            if (stateFree.$bool()) {
              // The semantics of the return value are:
              // If size was equal to 0, either NULL or a pointer suitable to be passed
              // to free() is returned. We just free the input pointer and do not add
              // any constrains on the output pointer.
              return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, stateFree);
            }
          } finally {
            if (stateFree != null) { stateFree.$destroy(); }
          }
        }
      }
      {
        IntrusiveRefCntPtr</*const*/ ProgramState> stateFree = null;
        try {
          
          // Default behavior.
          stateFree = $c$.clean(FreeMemAux(C, CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 0, false, ReleasedAllocated));
          if (stateFree.$bool()) {
            IntrusiveRefCntPtr</*const*/ ProgramState> stateRealloc = null;
            try {
              
              stateRealloc = $c$.clean(MallocMemAux(C, CE, CE.getArg$Const(1), 
                  new SVal(JD$Move.INSTANCE, new UnknownVal()), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateFree))));
              if (!stateRealloc.$bool()) {
                return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
              }
              
              ReallocPairKind Kind = ReallocPairKind.RPToBeFreedAfterFailure;
              if (FreesOnFail) {
                Kind = ReallocPairKind.RPIsFreeOnFailure;
              } else if (!ReleasedAllocated.$deref()) {
                Kind = ReallocPairKind.RPDoNotTrackAfterFailure;
              }
              
              // Record the info about the reallocated symbol so that we could properly
              // process failed reallocation.
              $c$.clean(stateRealloc.$assign($c$.track(stateRealloc.$arrow().set(ProgramStateTraitReallocPairs.$Instance, ToPtr, 
                      new ReallocPair(FromPtr, Kind)))));
              // The reallocated symbol should stay alive for as long as the new symbol.
              C.getSymbolManager().addSymbolDependency(ToPtr, FromPtr);
              return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, stateRealloc);
            } finally {
              if (stateRealloc != null) { stateRealloc.$destroy(); }
            }
          }
        } finally {
          if (stateFree != null) { stateFree.$destroy(); }
        }
      }
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    } finally {
      if (StateSizeNotZero != null) { StateSizeNotZero.$destroy(); }
      if (StateSizeIsZero != null) { StateSizeIsZero.$destroy(); }
      if (StatePtrNotNull != null) { StatePtrNotNull.$destroy(); }
      if (StatePtrIsNull != null) { StatePtrIsNull.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::CallocMem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1997,
   FQN="(anonymous namespace)::MallocChecker::CallocMem", NM="_ZN12_GLOBAL__N_113MallocChecker9CallocMemERN5clang4ento14CheckerContextEPKNS1_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker9CallocMemERN5clang4ento14CheckerContextEPKNS1_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEE")
  //</editor-fold>
  private static IntrusiveRefCntPtr</*const*/ ProgramState> CallocMem(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
           IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!State.$bool()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      if ($less_uint(CE.getNumArgs(), 2)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      }
      
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      SVal count = State.$arrow().getSVal(CE.getArg$Const(0), LCtx);
      SVal elementSize = State.$arrow().getSVal(CE.getArg$Const(1), LCtx);
      SVal TotalSize = $c$.clean(svalBuilder.evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), BinaryOperatorKind.BO_Mul, new SVal(count), new SVal(elementSize), 
          svalBuilder.getContext().getSizeType().$QualType()));
      SVal zeroVal = new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroVal(svalBuilder.getContext().CharTy.$QualType()));
      
      return $c$.clean(MallocMemAux(C, CE, new SVal(TotalSize), new SVal(zeroVal), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      $c$.$destroy();
    }
  }

  
  ///\brief Check if the memory associated with this symbol was released.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::isReleased">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2292,
   FQN="(anonymous namespace)::MallocChecker::isReleased", NM="_ZNK12_GLOBAL__N_113MallocChecker10isReleasedEPKN5clang4ento7SymExprERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker10isReleasedEPKN5clang4ento7SymExprERNS2_14CheckerContextE")
  //</editor-fold>
  private boolean isReleased(/*const*/ SymExpr /*P*/ Sym, final CheckerContext /*&*/ C) /*const*/ {
    assert Native.$bool(Sym);
    /*const*/ RefState /*P*/ RS = C.getState().$arrow().get(ProgramStateTraitRegionState.$Instance, Sym);
    return ((RS != null) && RS.isReleased());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkUseAfterFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2298,
   FQN="(anonymous namespace)::MallocChecker::checkUseAfterFree", NM="_ZNK12_GLOBAL__N_113MallocChecker17checkUseAfterFreeEPKN5clang4ento7SymExprERNS2_14CheckerContextEPKNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker17checkUseAfterFreeEPKN5clang4ento7SymExprERNS2_14CheckerContextEPKNS1_4StmtE")
  //</editor-fold>
  private boolean checkUseAfterFree(/*const*/ SymExpr /*P*/ Sym, final CheckerContext /*&*/ C, 
                   /*const*/ Stmt /*P*/ S) /*const*/ {
    if (isReleased(Sym, C)) {
      ReportUseAfterFree(C, S.getSourceRange(), Sym);
      return true;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkUseZeroAllocated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2309,
   FQN="(anonymous namespace)::MallocChecker::checkUseZeroAllocated", NM="_ZNK12_GLOBAL__N_113MallocChecker21checkUseZeroAllocatedEPKN5clang4ento7SymExprERNS2_14CheckerContextEPKNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker21checkUseZeroAllocatedEPKN5clang4ento7SymExprERNS2_14CheckerContextEPKNS1_4StmtE")
  //</editor-fold>
  private void checkUseZeroAllocated(/*const*/ SymExpr /*P*/ Sym, final CheckerContext /*&*/ C, 
                       /*const*/ Stmt /*P*/ S) /*const*/ {
    assert Native.$bool(Sym);
    {
      
      /*const*/ RefState /*P*/ RS = C.getState().$arrow().get(ProgramStateTraitRegionState.$Instance, Sym);
      if ((RS != null)) {
        if (RS.isAllocatedOfSizeZero()) {
          ReportUseZeroAllocated(C, RS.getStmt().getSourceRange(), Sym);
        }
      } else if (C.getState().$arrow().contains(ProgramStateTraitReallocSizeZeroSymbols.$Instance, Sym)) {
        ReportUseZeroAllocated(C, S.getSourceRange(), Sym);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkDoubleDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2322,
   FQN="(anonymous namespace)::MallocChecker::checkDoubleDelete", NM="_ZNK12_GLOBAL__N_113MallocChecker17checkDoubleDeleteEPKN5clang4ento7SymExprERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker17checkDoubleDeleteEPKN5clang4ento7SymExprERNS2_14CheckerContextE")
  //</editor-fold>
  private boolean checkDoubleDelete(/*const*/ SymExpr /*P*/ Sym, final CheckerContext /*&*/ C) /*const*/ {
    if (isReleased(Sym, C)) {
      ReportDoubleDelete(C, Sym);
      return true;
    }
    return false;
  }

  
  /// Check if the function is known free memory, or if it is
  /// "interesting" and should be modeled explicitly.
  ///
  /// \param [out] EscapingSymbol A function might not free memory in general,
  ///   but could be known to free a particular symbol. In this case, false is
  ///   returned and the single escaping symbol is returned through the out
  ///   parameter.
  ///
  /// We assume that pointers do not escape through calls to system functions
  /// not handled by this checker.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::mayFreeAnyEscapedMemoryOrIsModeledExplicitly">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2383,
   FQN="(anonymous namespace)::MallocChecker::mayFreeAnyEscapedMemoryOrIsModeledExplicitly", NM="_ZNK12_GLOBAL__N_113MallocChecker44mayFreeAnyEscapedMemoryOrIsModeledExplicitlyEPKN5clang4ento9CallEventEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERPKNS2_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker44mayFreeAnyEscapedMemoryOrIsModeledExplicitlyEPKN5clang4ento9CallEventEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEERPKNS2_7SymExprE")
  //</editor-fold>
  private boolean mayFreeAnyEscapedMemoryOrIsModeledExplicitly(/*const*/ CallEvent /*P*/ Call, 
                                              IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                                              final type$ref</*const*/SymExpr/*P*/> /*&*/ EscapingSymbol) /*const*/ {
    assert Native.$bool(Call);
    EscapingSymbol.$set(null);
    
    // For now, assume that any C++ or block call can free memory.
    // TODO: If we want to be more optimistic here, we'll need to make sure that
    // regions escape to C++ containers. They seem to do that even now, but for
    // mysterious reasons.
    if (!(isa_SimpleFunctionCall(Call) || isa_ObjCMethodCall(Call))) {
      return true;
    }
    {
      
      // Check Objective-C messages by selector name.
      /*const*/ ObjCMethodCall /*P*/ Msg = dyn_cast_ObjCMethodCall(Call);
      if ((Msg != null)) {
        // If it's not a framework call, or if it takes a callback, assume it
        // can free memory.
        if (!Call.isInSystemHeader() || Call.argumentsMayEscape()) {
          return true;
        }
        
        // If it's a method we know about, handle it explicitly post-call.
        // This should happen before the "freeWhenDone" check below.
        if (MallocCheckerStatics.isKnownDeallocObjCMethodName($Deref(Msg))) {
          return false;
        }
        {
          
          // If there's a "freeWhenDone" parameter, but the method isn't one we know
          // about, we can't be sure that the object will use free() to deallocate the
          // memory, so we can't model it explicitly. The best we can do is use it to
          // decide whether the pointer escapes.
          OptionalBool FreeWhenDone = MallocCheckerStatics.getFreeWhenDoneArg($Deref(Msg));
          if (FreeWhenDone.$bool()) {
            return FreeWhenDone.$star();
          }
        }
        
        // If the first selector piece ends with "NoCopy", and there is no
        // "freeWhenDone" parameter set to zero, we know ownership is being
        // transferred. Again, though, we can't be sure that the object will use
        // free() to deallocate the memory, so we can't model it explicitly.
        StringRef FirstSlot = Msg.getSelector().getNameForSlot(0);
        if (FirstSlot.endswith(/*STRINGREF_STR*/"NoCopy")) {
          return true;
        }
        
        // If the first selector starts with addPointer, insertPointer,
        // or replacePointer, assume we are dealing with NSPointerArray or similar.
        // This is similar to C++ containers (vector); we still might want to check
        // that the pointers get freed by following the container itself.
        if (FirstSlot.startswith(/*STRINGREF_STR*/"addPointer")
           || FirstSlot.startswith(/*STRINGREF_STR*/"insertPointer")
           || FirstSlot.startswith(/*STRINGREF_STR*/"replacePointer")
           || FirstSlot.equals(/*STRINGREF_STR*/"valueWithPointer")) {
          return true;
        }
        
        // We should escape receiver on call to 'init'. This is especially relevant
        // to the receiver, as the corresponding symbol is usually not referenced
        // after the call.
        if (Msg.getMethodFamily() == ObjCMethodFamily.OMF_init) {
          EscapingSymbol.$set(/*JAVA: set pointer*/Msg.getReceiverSVal().getAsSymbol());
          return true;
        }
        
        // Otherwise, assume that the method does not free memory.
        // Most framework methods do not free memory.
        return false;
      }
    }
    
    // At this point the only thing left to handle is straight function calls.
    /*const*/ FunctionDecl /*P*/ FD = cast_SimpleFunctionCall(Call).getDecl();
    if (!(FD != null)) {
      return true;
    }
    
    final ASTContext /*&*/ ASTC = State.$arrow().getStateManager().getContext();
    
    // If it's one of the allocation functions we can reason about, we model
    // its behavior explicitly.
    if (isMemFunction(FD, ASTC)) {
      return false;
    }
    
    // If it's not a system call, assume it frees memory.
    if (!Call.isInSystemHeader()) {
      return true;
    }
    
    // White list the system functions whose arguments escape.
    /*const*/ IdentifierInfo /*P*/ II = FD.getIdentifier();
    if (!(II != null)) {
      return true;
    }
    StringRef FName = II.getName();
    
    // White list the 'XXXNoCopy' CoreFoundation functions.
    // We specifically check these before
    if (FName.endswith(/*STRINGREF_STR*/"NoCopy")) {
      // Look for the deallocator argument. We know that the memory ownership
      // is not transferred only if the deallocator argument is
      // 'kCFAllocatorNull'.
      for (/*uint*/int i = 1; $less_uint(i, Call.getNumArgs()); ++i) {
        /*const*/ Expr /*P*/ ArgE = Call.getArgExpr(i).IgnoreParenCasts$Const();
        {
          /*const*/ DeclRefExpr /*P*/ DE = dyn_cast_DeclRefExpr(ArgE);
          if ((DE != null)) {
            StringRef DeallocatorName = DE.getFoundDecl$Const().getName();
            if ($eq_StringRef(/*NO_COPY*/DeallocatorName, /*STRINGREF_STR*/"kCFAllocatorNull")) {
              return false;
            }
          }
        }
      }
      return true;
    }
    
    // Associating streams with malloced buffers. The pointer can escape if
    // 'closefn' is specified (and if that function does free memory),
    // but it will not if closefn is not specified.
    // Currently, we do not inspect the 'closefn' function (PR12101).
    if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"funopen")) {
      if ($greatereq_uint(Call.getNumArgs(), 4) && Call.getArgSVal(4).isConstant(0)) {
        return false;
      }
    }
    
    // Do not warn on pointers passed to 'setbuf' when used with std streams,
    // these leaks might be intentional when setting the buffer for stdio.
    // http://stackoverflow.com/questions/2671151/who-frees-setvbuf-buffer
    if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"setbuf") || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"setbuffer")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"setlinebuf") || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"setvbuf")) {
      if ($greatereq_uint(Call.getNumArgs(), 1)) {
        /*const*/ Expr /*P*/ ArgE = Call.getArgExpr(0).IgnoreParenCasts$Const();
        {
          /*const*/ DeclRefExpr /*P*/ ArgDRE = dyn_cast_DeclRefExpr(ArgE);
          if ((ArgDRE != null)) {
            {
              /*const*/ VarDecl /*P*/ D = dyn_cast_VarDecl(ArgDRE.getDecl$Const());
              if ((D != null)) {
                if (D.getCanonicalDecl$Const().getName().find(/*STRINGREF_STR*/"std") != StringRef.npos) {
                  return true;
                }
              }
            }
          }
        }
      }
    }
    
    // A bunch of other functions which either take ownership of a pointer or
    // wrap the result up in a struct or object, meaning it can be freed later.
    // (See RetainCountChecker.) Not all the parameters here are invalidated,
    // but the Malloc checker cannot differentiate between them. The right way
    // of doing this would be to implement a pointer escapes callback.
    if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"CGBitmapContextCreate")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"CGBitmapContextCreateWithData")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"CVPixelBufferCreateWithBytes")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"CVPixelBufferCreateWithPlanarBytes")
       || $eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"OSAtomicEnqueue")) {
      return true;
    }
    if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"postEvent")
       && $eq_string$C_T$C$P(FD.getQualifiedNameAsString(), /*KEEP_STR*/"QCoreApplication::postEvent")) {
      return true;
    }
    if ($eq_StringRef(/*NO_COPY*/FName, /*STRINGREF_STR*/"postEvent")
       && $eq_string$C_T$C$P(FD.getQualifiedNameAsString(), /*KEEP_STR*/"QCoreApplication::postEvent")) {
      return true;
    }
    
    // Handle cases where we know a buffer's /address/ can escape.
    // Note that the above checks handle some special cases where we know that
    // even though the address escapes, it's still our responsibility to free the
    // buffer.
    if (Call.argumentsMayEscape()) {
      return true;
    }
    
    // Otherwise, assume that the function does not free memory.
    // Most system calls do not free the memory.
    return false;
  }

  
  // Implementation of the checkPointerEscape callabcks.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::checkPointerEscapeAux">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2568,
   FQN="(anonymous namespace)::MallocChecker::checkPointerEscapeAux", NM="_ZNK12_GLOBAL__N_113MallocChecker21checkPointerEscapeAuxEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindEPFbPKNS_8RefStateEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker21checkPointerEscapeAuxEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindEPFbPKNS_8RefStateEE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> checkPointerEscapeAux(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                       final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                       /*const*/ CallEvent /*P*/ Call, 
                       PointerEscapeKind Kind, 
                       BoolPredicate</*const*/RefState/*P*/> CheckRefState) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If we know that the call does not free memory, or we want to process the
      // call later, keep tracking the top level arguments.
      type$ref</*const*/ SymExpr /*P*/ > EscapingSymbol = create_type$null$ref(null);
      if ($c$.clean(Kind == PointerEscapeKind.PSK_DirectEscapeOnCall
         && !mayFreeAnyEscapedMemoryOrIsModeledExplicitly(Call, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
          EscapingSymbol)
         && !(EscapingSymbol.$deref() != null))) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      for (DenseSet.iterator<SymExpr> I = Escaped.begin$Const(), 
          E = Escaped.end$Const();
           I.$noteq(E); I.$preInc()) {
        /*const*/ SymExpr /*P*/ sym = I.$star();
        if ((EscapingSymbol.$deref() != null) && EscapingSymbol.$deref() != sym) {
          continue;
        }
        {
          
          /*const*/ RefState /*P*/ RS = State.$arrow().get(ProgramStateTraitRegionState.$Instance, sym);
          if ((RS != null)) {
            if ((RS.isAllocated() || RS.isAllocatedOfSizeZero())
               && CheckRefState.$call(RS)) {
              $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitRegionState.$Instance, sym))));
              $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitRegionState.$Instance, sym, RefState.getEscaped(RS)))));
            }
          }
        }
      }
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    } finally {
      $c$.$destroy();
    }
  }

  
  ///@{
  /// Tells if a given family/call/symbol is tracked by the current checker.
  /// Sets CheckKind to the kind of the checker responsible for this
  /// family/call/symbol.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::getCheckIfTracked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1461,
   FQN="(anonymous namespace)::MallocChecker::getCheckIfTracked", NM="_ZNK12_GLOBAL__N_113MallocChecker17getCheckIfTrackedENS_16AllocationFamilyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker17getCheckIfTrackedENS_16AllocationFamilyEb")
  //</editor-fold>
  private Optional<MallocChecker.CheckKind> getCheckIfTracked(AllocationFamily Family) /*const*/ {
    return getCheckIfTracked(Family, 
                   false);
  }
  private Optional<MallocChecker.CheckKind> getCheckIfTracked(AllocationFamily Family, 
                   boolean IsALeakCheck/*= false*/) /*const*/ {
    switch (Family) {
     case AF_Malloc:
     case AF_Alloca:
     case AF_IfNameIndex:
      {
        if (ChecksEnabled[CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()) {
          return new Optional<MallocChecker.CheckKind>(JD$T$RR.INSTANCE, CheckKind.CK_MallocChecker);
        }
        
        return new Optional<MallocChecker.CheckKind>();
      }
     case AF_CXXNew:
     case AF_CXXNewArray:
      {
        if (IsALeakCheck) {
          if (ChecksEnabled[CheckKind.CK_NewDeleteLeaksChecker.getValue()].$ConstBoolRef()) {
            return new Optional<MallocChecker.CheckKind>(JD$T$RR.INSTANCE, CheckKind.CK_NewDeleteLeaksChecker);
          }
        } else {
          if (ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()) {
            return new Optional<MallocChecker.CheckKind>(JD$T$RR.INSTANCE, CheckKind.CK_NewDeleteChecker);
          }
        }
        return new Optional<MallocChecker.CheckKind>();
      }
     case AF_None:
      {
        throw new llvm_unreachable("no family");
      }
    }
    throw new llvm_unreachable("unhandled family");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::getCheckIfTracked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1492,
   FQN="(anonymous namespace)::MallocChecker::getCheckIfTracked", NM="_ZNK12_GLOBAL__N_113MallocChecker17getCheckIfTrackedERN5clang4ento14CheckerContextEPKNS1_4StmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker17getCheckIfTrackedERN5clang4ento14CheckerContextEPKNS1_4StmtEb")
  //</editor-fold>
  private Optional<MallocChecker.CheckKind> getCheckIfTracked(final CheckerContext /*&*/ C, 
                   /*const*/ Stmt /*P*/ AllocDeallocStmt) /*const*/ {
    return getCheckIfTracked(C, 
                   AllocDeallocStmt, 
                   false);
  }
  private Optional<MallocChecker.CheckKind> getCheckIfTracked(final CheckerContext /*&*/ C, 
                   /*const*/ Stmt /*P*/ AllocDeallocStmt, 
                   boolean IsALeakCheck/*= false*/) /*const*/ {
    return getCheckIfTracked(getAllocationFamily(C, AllocDeallocStmt), 
        IsALeakCheck);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::getCheckIfTracked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1500,
   FQN="(anonymous namespace)::MallocChecker::getCheckIfTracked", NM="_ZNK12_GLOBAL__N_113MallocChecker17getCheckIfTrackedERN5clang4ento14CheckerContextEPKNS2_7SymExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker17getCheckIfTrackedERN5clang4ento14CheckerContextEPKNS2_7SymExprEb")
  //</editor-fold>
  private Optional<MallocChecker.CheckKind> getCheckIfTracked(final CheckerContext /*&*/ C, /*const*/ SymExpr /*P*/ Sym) /*const*/ {
    return getCheckIfTracked(C, Sym, 
                   false);
  }
  private Optional<MallocChecker.CheckKind> getCheckIfTracked(final CheckerContext /*&*/ C, /*const*/ SymExpr /*P*/ Sym, 
                   boolean IsALeakCheck/*= false*/) /*const*/ {
    if (C.getState().$arrow().contains(ProgramStateTraitReallocSizeZeroSymbols.$Instance, Sym)) {
      return new Optional<MallocChecker.CheckKind>(JD$T$RR.INSTANCE, CheckKind.CK_MallocChecker);
    }
    
    /*const*/ RefState /*P*/ RS = C.getState().$arrow().get(ProgramStateTraitRegionState.$Instance, Sym);
    assert /*JAVA*/(RS != null);
    return getCheckIfTracked(RS.getAllocationFamily(), IsALeakCheck);
  }

  ///@}
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::SummarizeValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1511,
   FQN="(anonymous namespace)::MallocChecker::SummarizeValue", NM="_ZN12_GLOBAL__N_113MallocChecker14SummarizeValueERN4llvm11raw_ostreamEN5clang4ento4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker14SummarizeValueERN4llvm11raw_ostreamEN5clang4ento4SValE")
  //</editor-fold>
  private static boolean SummarizeValue(final raw_ostream /*&*/ os, SVal V) {
    {
      Optional<NsNonloc.ConcreteInt> IntVal = V.getAs(NsNonloc.ConcreteInt.class);
      if (IntVal.$bool()) {
        $out_raw_ostream_APSInt$C(os.$out(/*KEEP_STR*/"an integer ("), IntVal.$arrow().getValue()).$out(/*KEEP_STR*/$RPAREN);
      } else {
        Optional<NsLoc.ConcreteInt> ConstAddr = V.getAs(NsLoc.ConcreteInt.class);
        if (ConstAddr.$bool()) {
          $out_raw_ostream_APSInt$C(os.$out(/*KEEP_STR*/"a constant address ("), ConstAddr.$arrow().getValue()).$out(/*KEEP_STR*/$RPAREN);
        } else {
          Optional<NsLoc.GotoLabel> Label = V.getAs(NsLoc.GotoLabel.class);
          if (Label.$bool()) {
            os.$out(/*KEEP_STR*/"the address of the label '").$out(Label.$arrow().getLabel().getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
          } else {
            return false;
          }
        }
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::SummarizeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1524,
   FQN="(anonymous namespace)::MallocChecker::SummarizeRegion", NM="_ZN12_GLOBAL__N_113MallocChecker15SummarizeRegionERN4llvm11raw_ostreamEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker15SummarizeRegionERN4llvm11raw_ostreamEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  private static boolean SummarizeRegion(final raw_ostream /*&*/ os, 
                 /*const*/ MemRegion /*P*/ MR) {
    switch (MR.getKind()) {
     case FunctionCodeRegionKind:
      {
        /*const*/ NamedDecl /*P*/ FD = cast_FunctionCodeRegion(MR).getDecl();
        if ((FD != null)) {
          $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"the address of the function '"), $Deref(FD)).$out_char($$SGL_QUOTE);
        } else {
          os.$out(/*KEEP_STR*/"the address of a function");
        }
        return true;
      }
     case BlockCodeRegionKind:
      os.$out(/*KEEP_STR*/"block text");
      return true;
     case BlockDataRegionKind:
      // FIXME: where the block came from?
      os.$out(/*KEEP_STR*/"a block");
      return true;
     default:
      {
        /*const*/ MemSpaceRegion /*P*/ MS = MR.getMemorySpace();
        if (isa_StackLocalsSpaceRegion(MS)) {
          /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(MR);
          /*const*/ VarDecl /*P*/ VD;
          if ((VR != null)) {
            VD = VR.getDecl();
          } else {
            VD = null;
          }
          if ((VD != null)) {
            os.$out(/*KEEP_STR*/"the address of the local variable '").$out(VD.getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
          } else {
            os.$out(/*KEEP_STR*/"the address of a local stack variable");
          }
          return true;
        }
        if (isa_StackArgumentsSpaceRegion(MS)) {
          /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(MR);
          /*const*/ VarDecl /*P*/ VD;
          if ((VR != null)) {
            VD = VR.getDecl();
          } else {
            VD = null;
          }
          if ((VD != null)) {
            os.$out(/*KEEP_STR*/"the address of the parameter '").$out(VD.getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
          } else {
            os.$out(/*KEEP_STR*/"the address of a parameter");
          }
          return true;
        }
        if (isa_GlobalsSpaceRegion(MS)) {
          /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(MR);
          /*const*/ VarDecl /*P*/ VD;
          if ((VR != null)) {
            VD = VR.getDecl();
          } else {
            VD = null;
          }
          if ((VD != null)) {
            if (VD.isStaticLocal()) {
              os.$out(/*KEEP_STR*/"the address of the static variable '").$out(VD.getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
            } else {
              os.$out(/*KEEP_STR*/"the address of the global variable '").$out(VD.getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
            }
          } else {
            os.$out(/*KEEP_STR*/"the address of a global variable");
          }
          return true;
        }
        
        return false;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReportBadFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1598,
   FQN="(anonymous namespace)::MallocChecker::ReportBadFree", NM="_ZNK12_GLOBAL__N_113MallocChecker13ReportBadFreeERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker13ReportBadFreeERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprE")
  //</editor-fold>
  private void ReportBadFree(final CheckerContext /*&*/ C, SVal ArgVal, 
               SourceRange Range, 
               /*const*/ Expr /*P*/ DeallocExpr) /*const*/ {
    if (!ChecksEnabled[CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()
       && !ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()) {
      return;
    }
    
    Optional<MallocChecker.CheckKind> CheckKind = getCheckIfTracked(C, DeallocExpr);
    if (!CheckKind.hasValue()) {
      return;
    }
    {
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if ((N != null)) {
        raw_svector_ostream os = null;
        unique_ptr<BugReport> R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT_BadFree[CheckKind.$star().getValue()].$bool()) {
            BT_BadFree[CheckKind.$star().getValue()].reset(new BugType(new  CheckName(CheckNames[CheckKind.$star().getValue()]), new StringRef(/*KEEP_STR*/"Bad free"), new StringRef(/*KEEP_STR*/"Memory Error")));
          }
          
          SmallString/*<100>*/ buf/*J*/= new SmallString/*<100>*/(100);
          os/*J*/= new raw_svector_ostream(buf);
          
          /*const*/ MemRegion /*P*/ MR = ArgVal.getAsRegion();
          {
            /*const*/ ElementRegion /*P*/ ER;
            while (((/*P*/ ER = dyn_cast_or_null_ElementRegion(MR)) != null)) {
              MR = ER.getSuperRegion();
            }
          }
          
          os.$out(/*KEEP_STR*/"Argument to ");
          if (!printAllocDeallocName(os, C, DeallocExpr)) {
            os.$out(/*KEEP_STR*/"deallocator");
          }
          
          os.$out(/*KEEP_STR*/" is ");
          boolean Summarized = (MR != null) ? SummarizeRegion(os, MR) : SummarizeValue(os, new SVal(ArgVal));
          if (Summarized) {
            os.$out(/*KEEP_STR*/", which is not memory allocated by ");
          } else {
            os.$out(/*KEEP_STR*/"not memory allocated by ");
          }
          
          printExpectedAllocName(os, C, DeallocExpr);
          
          R = llvm.make_unique(new BugReport(BT_BadFree[CheckKind.$star().getValue()].$star(), os.str(), N));
          R.$arrow().markInteresting(MR);
          R.$arrow().addRange(new SourceRange(Range));
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        } finally {
          if (R != null) { R.$destroy(); }
          if (os != null) { os.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReportFreeAlloca">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1644,
   FQN="(anonymous namespace)::MallocChecker::ReportFreeAlloca", NM="_ZNK12_GLOBAL__N_113MallocChecker16ReportFreeAllocaERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker16ReportFreeAllocaERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeE")
  //</editor-fold>
  private void ReportFreeAlloca(final CheckerContext /*&*/ C, SVal ArgVal, 
                  SourceRange Range) /*const*/ {
    
    Optional<MallocChecker.CheckKind> CheckKind/*J*/= new Optional<MallocChecker.CheckKind>();
    if (ChecksEnabled[MallocChecker.CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()) {
      CheckKind.$assign_T$RR(/*KEEP_ENUM*/MallocChecker.CheckKind.CK_MallocChecker);
    } else if (ChecksEnabled[MallocChecker.CheckKind.CK_MismatchedDeallocatorChecker.getValue()].$ConstBoolRef()) {
      CheckKind.$assign_T$RR(/*KEEP_ENUM*/MallocChecker.CheckKind.CK_MismatchedDeallocatorChecker);
    } else {
      return;
    }
    {
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if ((N != null)) {
        unique_ptr<BugReport> R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT_FreeAlloca[CheckKind.$star().getValue()].$bool()) {
            BT_FreeAlloca[CheckKind.$star().getValue()].reset(new BugType(new  CheckName(CheckNames[CheckKind.$star().getValue()]), new StringRef(/*KEEP_STR*/"Free alloca()"), new StringRef(/*KEEP_STR*/"Memory Error")));
          }
          
          R = llvm.make_unique(new BugReport(BT_FreeAlloca[CheckKind.$star().getValue()].$star(), 
              $("Memory allocated by alloca() should not be deallocated"), N));
          R.$arrow().markInteresting(ArgVal.getAsRegion());
          R.$arrow().addRange(new SourceRange(Range));
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        } finally {
          if (R != null) { R.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReportMismatchedDealloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1670,
   FQN="(anonymous namespace)::MallocChecker::ReportMismatchedDealloc", NM="_ZNK12_GLOBAL__N_113MallocChecker23ReportMismatchedDeallocERN5clang4ento14CheckerContextENS1_11SourceRangeEPKNS1_4ExprEPKNS_8RefStateEPKNS2_7SymExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker23ReportMismatchedDeallocERN5clang4ento14CheckerContextENS1_11SourceRangeEPKNS1_4ExprEPKNS_8RefStateEPKNS2_7SymExprEb")
  //</editor-fold>
  private void ReportMismatchedDealloc(final CheckerContext /*&*/ C, 
                         SourceRange Range, 
                         /*const*/ Expr /*P*/ DeallocExpr, 
                         /*const*/ RefState /*P*/ RS, 
                         /*const*/ SymExpr /*P*/ Sym, 
                         boolean OwnershipTransferred) /*const*/ {
    if (!ChecksEnabled[CheckKind.CK_MismatchedDeallocatorChecker.getValue()].$ConstBoolRef()) {
      return;
    }
    {
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if ((N != null)) {
        raw_svector_ostream os = null;
        raw_svector_ostream AllocOs = null;
        raw_svector_ostream DeallocOs = null;
        unique_ptr<BugReport> R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT_MismatchedDealloc.$bool()) {
            BT_MismatchedDealloc.reset(new BugType(new  CheckName(CheckNames[CheckKind.CK_MismatchedDeallocatorChecker.getValue()]), 
                    new StringRef(/*KEEP_STR*/"Bad deallocator"), new StringRef(/*KEEP_STR*/"Memory Error")));
          }
          
          SmallString/*<100>*/ buf/*J*/= new SmallString/*<100>*/(100);
          os/*J*/= new raw_svector_ostream(buf);
          
          /*const*/ Expr /*P*/ AllocExpr = cast_Expr(RS.getStmt());
          SmallString/*<20>*/ AllocBuf/*J*/= new SmallString/*<20>*/(20);
          AllocOs/*J*/= new raw_svector_ostream(AllocBuf);
          SmallString/*<20>*/ DeallocBuf/*J*/= new SmallString/*<20>*/(20);
          DeallocOs/*J*/= new raw_svector_ostream(DeallocBuf);
          if (OwnershipTransferred) {
            if (printAllocDeallocName(DeallocOs, C, DeallocExpr)) {
              os.$out(DeallocOs.str()).$out(/*KEEP_STR*/" cannot");
            } else {
              os.$out(/*KEEP_STR*/"Cannot");
            }
            
            os.$out(/*KEEP_STR*/" take ownership of memory");
            if (printAllocDeallocName(AllocOs, C, AllocExpr)) {
              os.$out(/*KEEP_STR*/" allocated by ").$out(AllocOs.str());
            }
          } else {
            os.$out(/*KEEP_STR*/"Memory");
            if (printAllocDeallocName(AllocOs, C, AllocExpr)) {
              os.$out(/*KEEP_STR*/" allocated by ").$out(AllocOs.str());
            }
            
            os.$out(/*KEEP_STR*/" should be deallocated by ");
            printExpectedDeallocName(os, RS.getAllocationFamily());
            if (printAllocDeallocName(DeallocOs, C, DeallocExpr)) {
              os.$out(/*KEEP_STR*/", not ").$out(DeallocOs.str());
            }
          }
          
          R = llvm.make_unique(new BugReport(BT_MismatchedDealloc.$star(), os.str(), N));
          R.$arrow().markInteresting(Sym);
          R.$arrow().addRange(new SourceRange(Range));
          R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MallocBugVisitor(Sym)))))); $c$.clean();
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        } finally {
          if (R != null) { R.$destroy(); }
          if (DeallocOs != null) { DeallocOs.$destroy(); }
          if (AllocOs != null) { AllocOs.$destroy(); }
          if (os != null) { os.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReportOffsetFree">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1725,
   FQN="(anonymous namespace)::MallocChecker::ReportOffsetFree", NM="_ZNK12_GLOBAL__N_113MallocChecker16ReportOffsetFreeERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker16ReportOffsetFreeERN5clang4ento14CheckerContextENS2_4SValENS1_11SourceRangeEPKNS1_4ExprES9_")
  //</editor-fold>
  private void ReportOffsetFree(final CheckerContext /*&*/ C, SVal ArgVal, 
                  SourceRange Range, /*const*/ Expr /*P*/ DeallocExpr) /*const*/ {
    ReportOffsetFree(C, ArgVal, 
                  Range, DeallocExpr, 
                  (/*const*/ Expr /*P*/ )null);
  }
  private void ReportOffsetFree(final CheckerContext /*&*/ C, SVal ArgVal, 
                  SourceRange Range, /*const*/ Expr /*P*/ DeallocExpr, 
                  /*const*/ Expr /*P*/ AllocExpr/*= null*/) /*const*/ {
    raw_svector_ostream os = null;
    raw_svector_ostream AllocNameOs = null;
    unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!ChecksEnabled[CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()
         && !ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()) {
        return;
      }
      
      Optional<MallocChecker.CheckKind> CheckKind = getCheckIfTracked(C, AllocExpr);
      if (!CheckKind.hasValue()) {
        return;
      }
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if (!(N != null)) {
        return;
      }
      if (!BT_OffsetFree[CheckKind.$star().getValue()].$bool()) {
        BT_OffsetFree[CheckKind.$star().getValue()].reset(new BugType(new  CheckName(CheckNames[CheckKind.$star().getValue()]), new StringRef(/*KEEP_STR*/"Offset free"), new StringRef(/*KEEP_STR*/"Memory Error")));
      }
      
      SmallString/*<100>*/ buf/*J*/= new SmallString/*<100>*/(100);
      os/*J*/= new raw_svector_ostream(buf);
      SmallString/*<20>*/ AllocNameBuf/*J*/= new SmallString/*<20>*/(20);
      AllocNameOs/*J*/= new raw_svector_ostream(AllocNameBuf);
      
      /*const*/ MemRegion /*P*/ MR = ArgVal.getAsRegion();
      assert ((MR != null)) : "Only MemRegion based symbols can have offset free errors";
      
      RegionOffset Offset = MR.getAsOffset();
      assert ((Offset.isValid() && !Offset.hasSymbolicOffset() && Offset.getOffset() != 0)) : "Only symbols with a valid offset can have offset free errors";
      
      // JAVA: just truncate to int here, because getOffset is long and can be negative
      int offsetBytes = /*$ullong2int*/(/*JAVA*/int)($div_ullong_ulong(Offset.getOffset(), C.getASTContext().getCharWidth()));
      
      os.$out(/*KEEP_STR*/"Argument to ");
      if (!printAllocDeallocName(os, C, DeallocExpr)) {
        os.$out(/*KEEP_STR*/"deallocator");
      }
      os.$out(/*KEEP_STR*/" is offset by ").$out_int(
          offsetBytes
      ).$out(
          /*KEEP_STR*/$SPACE
      ).$out(
          ((abs(offsetBytes) > 1) ? $("bytes") : $("byte"))
      ).$out(
          /*KEEP_STR*/" from the start of "
      );
      if ((AllocExpr != null) && printAllocDeallocName(AllocNameOs, C, AllocExpr)) {
        os.$out(/*KEEP_STR*/"memory allocated by ").$out(AllocNameOs.str());
      } else {
        os.$out(/*KEEP_STR*/"allocated memory");
      }
      
      R = llvm.make_unique(new BugReport(BT_OffsetFree[CheckKind.$star().getValue()].$star(), os.str(), N));
      R.$arrow().markInteresting(MR.getBaseRegion());
      R.$arrow().addRange(new SourceRange(Range));
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      if (AllocNameOs != null) { AllocNameOs.$destroy(); }
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReportUseAfterFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1782,
   FQN="(anonymous namespace)::MallocChecker::ReportUseAfterFree", NM="_ZNK12_GLOBAL__N_113MallocChecker18ReportUseAfterFreeERN5clang4ento14CheckerContextENS1_11SourceRangeEPKNS2_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker18ReportUseAfterFreeERN5clang4ento14CheckerContextENS1_11SourceRangeEPKNS2_7SymExprE")
  //</editor-fold>
  private void ReportUseAfterFree(final CheckerContext /*&*/ C, SourceRange Range, 
                    /*const*/ SymExpr /*P*/ Sym) /*const*/ {
    if (!ChecksEnabled[CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()
       && !ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()) {
      return;
    }
    
    Optional<MallocChecker.CheckKind> CheckKind = getCheckIfTracked(C, Sym);
    if (!CheckKind.hasValue()) {
      return;
    }
    {
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if ((N != null)) {
        unique_ptr<BugReport> R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT_UseFree[CheckKind.$star().getValue()].$bool()) {
            BT_UseFree[CheckKind.$star().getValue()].reset(new BugType(new  CheckName(CheckNames[CheckKind.$star().getValue()]), new StringRef(/*KEEP_STR*/"Use-after-free"), new StringRef(/*KEEP_STR*/"Memory Error")));
          }
          
          R = llvm.make_unique(new BugReport(BT_UseFree[CheckKind.$star().getValue()].$star(), 
              $("Use of memory after it is freed"), N));
          
          R.$arrow().markInteresting(Sym);
          R.$arrow().addRange(new SourceRange(Range));
          R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MallocBugVisitor(Sym)))))); $c$.clean();
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        } finally {
          if (R != null) { R.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReportDoubleFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1808,
   FQN="(anonymous namespace)::MallocChecker::ReportDoubleFree", NM="_ZNK12_GLOBAL__N_113MallocChecker16ReportDoubleFreeERN5clang4ento14CheckerContextENS1_11SourceRangeEbPKNS2_7SymExprES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker16ReportDoubleFreeERN5clang4ento14CheckerContextENS1_11SourceRangeEbPKNS2_7SymExprES8_")
  //</editor-fold>
  private void ReportDoubleFree(final CheckerContext /*&*/ C, SourceRange Range, 
                  boolean Released, /*const*/ SymExpr /*P*/ Sym, 
                  /*const*/ SymExpr /*P*/ PrevSym) /*const*/ {
    if (!ChecksEnabled[CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()
       && !ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()) {
      return;
    }
    
    Optional<MallocChecker.CheckKind> CheckKind = getCheckIfTracked(C, Sym);
    if (!CheckKind.hasValue()) {
      return;
    }
    {
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if ((N != null)) {
        unique_ptr<BugReport> R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT_DoubleFree[CheckKind.$star().getValue()].$bool()) {
            BT_DoubleFree[CheckKind.$star().getValue()].reset(new BugType(new  CheckName(CheckNames[CheckKind.$star().getValue()]), new StringRef(/*KEEP_STR*/"Double free"), new StringRef(/*KEEP_STR*/"Memory Error")));
          }
          
          R = llvm.make_unique(new BugReport(BT_DoubleFree[CheckKind.$star().getValue()].$star(), 
              (Released ? $("Attempt to free released memory") : $("Attempt to free non-owned memory")), 
              N));
          R.$arrow().addRange(new SourceRange(Range));
          R.$arrow().markInteresting(Sym);
          if ((PrevSym != null)) {
            R.$arrow().markInteresting(PrevSym);
          }
          R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MallocBugVisitor(Sym)))))); $c$.clean();
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        } finally {
          if (R != null) { R.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReportDoubleDelete">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1839,
   FQN="(anonymous namespace)::MallocChecker::ReportDoubleDelete", NM="_ZNK12_GLOBAL__N_113MallocChecker18ReportDoubleDeleteERN5clang4ento14CheckerContextEPKNS2_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker18ReportDoubleDeleteERN5clang4ento14CheckerContextEPKNS2_7SymExprE")
  //</editor-fold>
  private void ReportDoubleDelete(final CheckerContext /*&*/ C, /*const*/ SymExpr /*P*/ Sym) /*const*/ {
    if (!ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()) {
      return;
    }
    
    Optional<MallocChecker.CheckKind> CheckKind = getCheckIfTracked(C, Sym);
    if (!CheckKind.hasValue()) {
      return;
    }
    {
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if ((N != null)) {
        unique_ptr<BugReport> R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT_DoubleDelete.$bool()) {
            BT_DoubleDelete.reset(new BugType(new  CheckName(CheckNames[CheckKind.$arrow().CK_NewDeleteChecker.getValue()]), 
                    new StringRef(/*KEEP_STR*/"Double delete"), new StringRef(/*KEEP_STR*/"Memory Error")));
          }
          
          R = llvm.make_unique(new BugReport(BT_DoubleDelete.$star(), $("Attempt to delete released memory"), N));
          
          R.$arrow().markInteresting(Sym);
          R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MallocBugVisitor(Sym)))))); $c$.clean();
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        } finally {
          if (R != null) { R.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::ReportUseZeroAllocated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 1862,
   FQN="(anonymous namespace)::MallocChecker::ReportUseZeroAllocated", NM="_ZNK12_GLOBAL__N_113MallocChecker22ReportUseZeroAllocatedERN5clang4ento14CheckerContextENS1_11SourceRangeEPKNS2_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker22ReportUseZeroAllocatedERN5clang4ento14CheckerContextENS1_11SourceRangeEPKNS2_7SymExprE")
  //</editor-fold>
  private void ReportUseZeroAllocated(final CheckerContext /*&*/ C, 
                        SourceRange Range, 
                        /*const*/ SymExpr /*P*/ Sym) /*const*/ {
    if (!ChecksEnabled[CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()
       && !ChecksEnabled[CheckKind.CK_NewDeleteChecker.getValue()].$ConstBoolRef()) {
      return;
    }
    
    Optional<MallocChecker.CheckKind> CheckKind = getCheckIfTracked(C, Sym);
    if (!CheckKind.hasValue()) {
      return;
    }
    {
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if ((N != null)) {
        unique_ptr<BugReport> R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT_UseZerroAllocated[CheckKind.$star().getValue()].$bool()) {
            BT_UseZerroAllocated[CheckKind.$star().getValue()].reset(new BugType(new  CheckName(CheckNames[CheckKind.$star().getValue()]), new StringRef(/*KEEP_STR*/"Use of zero allocated"), new StringRef(/*KEEP_STR*/"Memory Error")));
          }
          
          R = llvm.make_unique(new BugReport(BT_UseZerroAllocated[CheckKind.$star().getValue()].$star(), 
              $("Use of zero-allocated memory"), N));
          
          R.$arrow().addRange(new SourceRange(Range));
          if ((Sym != null)) {
            R.$arrow().markInteresting(Sym);
            R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MallocBugVisitor(Sym)))))); $c$.clean();
          }
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        } finally {
          if (R != null) { R.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  
  /// Find the location of the allocation for Sym on the path leading to the
  /// exploded node N.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::getAllocationSite">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2016,
   FQN="(anonymous namespace)::MallocChecker::getAllocationSite", NM="_ZNK12_GLOBAL__N_113MallocChecker17getAllocationSiteEPKN5clang4ento12ExplodedNodeEPKNS2_7SymExprERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker17getAllocationSiteEPKN5clang4ento12ExplodedNodeEPKNS2_7SymExprERNS2_14CheckerContextE")
  //</editor-fold>
  private std.pairPtrPtr</*const*/ ExplodedNode /*P*/ , /*const*/ MemRegion /*P*/ > getAllocationSite(/*const*/ ExplodedNode /*P*/ N, /*const*/ SymExpr /*P*/ Sym, 
                   final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ LocationContext /*P*/ LeakContext = N.getLocationContext();
    // Walk the ExplodedGraph backwards and find the first node that referred to
    // the tracked symbol.
    /*const*/ ExplodedNode /*P*/ AllocNode = N;
    /*const*/ MemRegion /*P*/ ReferenceRegion = null;
    while ((N != null)) {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      try {
        State = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
        if (!(State.$arrow()./*<RegionState>*/get(ProgramStateTraitRegionState.$Instance, Sym) != null)) {
          break;
        }
        
        // Find the most recent expression bound to the symbol in the current
        // context.
        if (!(ReferenceRegion != null)) {
          {
            /*const*/ MemRegion /*P*/ MR = C.getLocationRegionIfPostStore(N);
            if ((MR != null)) {
              SVal Val = State.$arrow().getSVal(MR);
              if (Val.getAsLocSymbol() == Sym) {
                /*const*/ VarRegion /*P*/ VR = MR.getBaseRegion().getAs(VarRegion.class);
                // Do not show local variables belonging to a function other than
                // where the error is reported.
                if (!(VR != null)
                   || (VR.getStackFrame() == LeakContext.getCurrentStackFrame())) {
                  ReferenceRegion = MR;
                }
              }
            }
          }
        }
        
        // Allocation node, is the last node in the current or parent context in
        // which the symbol was tracked.
        /*const*/ LocationContext /*P*/ NContext = N.getLocationContext();
        if (NContext == LeakContext
           || NContext.isParentOf(LeakContext)) {
          AllocNode = N;
        }
        N = N.pred_empty() ? null : (N.pred_begin$Const()).$star();
      } finally {
        if (State != null) { State.$destroy(); }
      }
    }
    
    return new std.pairPtrPtr</*const*/ ExplodedNode /*P*/ , /*const*/ MemRegion /*P*/ >(JD$T$RR_T1$RR.INSTANCE, AllocNode, ReferenceRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::reportLeak">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2058,
   FQN="(anonymous namespace)::MallocChecker::reportLeak", NM="_ZNK12_GLOBAL__N_113MallocChecker10reportLeakEPKN5clang4ento7SymExprEPNS2_12ExplodedNodeERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker10reportLeakEPKN5clang4ento7SymExprEPNS2_12ExplodedNodeERNS2_14CheckerContextE")
  //</editor-fold>
  private void reportLeak(/*const*/ SymExpr /*P*/ Sym, ExplodedNode /*P*/ N, 
            final CheckerContext /*&*/ C) /*const*/ {
    raw_svector_ostream os = null;
    unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!ChecksEnabled[CheckKind.CK_MallocChecker.getValue()].$ConstBoolRef()
         && !ChecksEnabled[CheckKind.CK_NewDeleteLeaksChecker.getValue()].$ConstBoolRef()) {
        return;
      }
      
      /*const*/ RefState /*P*/ RS = C.getState().$arrow().get(ProgramStateTraitRegionState.$Instance, Sym);
      assert ((RS != null)) : "cannot leak an untracked symbol";
      AllocationFamily Family = RS.getAllocationFamily();
      if (Family == AllocationFamily.AF_Alloca) {
        return;
      }
      
      Optional<MallocChecker.CheckKind> CheckKind = getCheckIfTracked(Family, true);
      if (!CheckKind.hasValue()) {
        return;
      }
      assert Native.$bool(N);
      if (!BT_Leak[CheckKind.$star().getValue()].$bool()) {
        BT_Leak[CheckKind.$star().getValue()].reset(new BugType(new  CheckName(CheckNames[CheckKind.$star().getValue()]), new StringRef(/*KEEP_STR*/"Memory leak"), new StringRef(/*KEEP_STR*/"Memory Error")));
        // Leaks should not be reported if they are post-dominated by a sink:
        // (1) Sinks are higher importance bugs.
        // (2) NoReturnFunctionChecker uses sink nodes to represent paths ending
        //     with __noreturn functions such as assert() or exit(). We choose not
        //     to report leaks on such paths.
        BT_Leak[CheckKind.$star().getValue()].$arrow().setSuppressOnSink(true);
      }
      
      // Most bug reports are cached at the location where they occurred.
      // With leaks, we want to unique them by the location where they were
      // allocated, and only report a single path.
      PathDiagnosticLocation LocUsedForUniqueing/*J*/= new PathDiagnosticLocation();
      /*const*/ ExplodedNode /*P*/ AllocNode = null;
      /*const*/ MemRegion /*P*/ Region = null;
      // JAVA: unfolded std.tie
//      std.tie(AllocNode, Region).$assign(getAllocationSite(N, Sym, C));
      std_pair.pairPtrPtr</*const*/ ExplodedNode /*P*/, /*const*/ MemRegion /*P*/> $tie = getAllocationSite(N, Sym, C);
      AllocNode = $tie.first;
      Region = $tie.second;
      
      ProgramPoint P = AllocNode.getLocation();
      /*const*/ Stmt /*P*/ AllocationStmt = null;
      {
        Optional<CallExitEnd> Exit = P.getAs(CallExitEnd.class);
        if (Exit.$bool()) {
          AllocationStmt = Exit.$arrow().getCalleeContext().getCallSite();
        } else {
          Optional<StmtPoint> SP = P.getAs(StmtPoint.class);
          if (SP.$bool()) {
            AllocationStmt = SP.$arrow().getStmt();
          }
        }
      }
      if ((AllocationStmt != null)) {
        LocUsedForUniqueing.$assignMove(PathDiagnosticLocation.createBegin(AllocationStmt, 
                C.getSourceManager(), 
                new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, AllocNode.getLocationContext())));
      }
      
      SmallString/*<200>*/ buf/*J*/= new SmallString/*<200>*/(200);
      os/*J*/= new raw_svector_ostream(buf);
      if ((Region != null) && Region.canPrintPretty()) {
        os.$out(/*KEEP_STR*/"Potential leak of memory pointed to by ");
        Region.printPretty(os);
      } else {
        os.$out(/*KEEP_STR*/"Potential memory leak");
      }
      
      R = llvm.make_unique(new BugReport(BT_Leak[CheckKind.$star().getValue()].$star(), os.str(), N, LocUsedForUniqueing, 
          AllocNode.getLocationContext().getDecl()));
      R.$arrow().markInteresting(Sym);
      R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MallocBugVisitor(Sym, true)))))); $c$.clean();
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// The bug visitor which allows us to print extra diagnostics along the
  /// BugReport path. For example, showing the allocation site of the leaked
  /// region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 398,
   FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitorE")
  //</editor-fold>
  private static final class MallocBugVisitor extends /*public*/ BugReporterVisitorImpl<MallocBugVisitor> implements Destructors.ClassWithDestructor {
  /*protected:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::NotificationMode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 401,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::NotificationMode", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor16NotificationModeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor16NotificationModeE")
    //</editor-fold>
    protected enum NotificationMode implements Native.NativeUIntEnum {
      Normal(0),
      ReallocationFailed(Normal.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static NotificationMode valueOf(int val) {
        NotificationMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final NotificationMode[] VALUES;
        private static final NotificationMode[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (NotificationMode kind : NotificationMode.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new NotificationMode[min < 0 ? (1-min) : 0];
          VALUES = new NotificationMode[max >= 0 ? (1+max) : 0];
          for (NotificationMode kind : NotificationMode.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
                _VALUES[-kind.value] = kind;
              } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final /*uint*/int value;
      private NotificationMode(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    
    // The allocated region symbol tracked by the main analysis.
    protected /*const*/ SymExpr /*P*/ Sym;
    
    // The mode we are in, i.e. what kind of diagnostics will be emitted.
    protected NotificationMode Mode;
    
    // A symbol from when the primary region should have been reallocated.
    protected /*const*/ SymExpr /*P*/ FailedReallocSymbol;
    
    protected boolean IsLeak;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::MallocBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 418,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::MallocBugVisitor", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitorC1EPKN5clang4ento7SymExprEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitorC1EPKN5clang4ento7SymExprEb")
    //</editor-fold>
    public MallocBugVisitor(/*const*/ SymExpr /*P*/ S) {
      this(S, false);
    }
    public MallocBugVisitor(/*const*/ SymExpr /*P*/ S, boolean isLeak/*= false*/) {
      // : BugReporterVisitorImpl<MallocBugVisitor>(), Sym(S), Mode(Normal), FailedReallocSymbol(null), IsLeak(isLeak) 
      //START JInit
      super();
      this.Sym = S;
      this.Mode = NotificationMode.Normal;
      this.FailedReallocSymbol = null;
      this.IsLeak = isLeak;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::Profile">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 421,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::Profile", NM="_ZNK12_GLOBAL__N_113MallocChecker16MallocBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_113MallocChecker16MallocBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
      final/*static*/ Object X = Profile$$.X;
      ID.AddPointer($AddrOf(X));
      ID.AddPointer(Sym);
    }
    private static final class Profile$$ {
      static final/*static*/ Object X = MallocBugVisitor.class;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::isAllocated">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 427,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::isAllocated", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor11isAllocatedEPKNS_8RefStateES4_PKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor11isAllocatedEPKNS_8RefStateES4_PKN5clang4StmtE")
    //</editor-fold>
    public /*inline*/ boolean isAllocated(/*const*/ RefState /*P*/ S, /*const*/ RefState /*P*/ SPrev, 
               /*const*/ Stmt /*P*/ $Stmt) {
      // Did not track -> allocated. Other state (released) -> allocated.
      return (($Stmt != null) && (isa_CallExpr($Stmt) || isa_CXXNewExpr($Stmt))
         && ((S != null) && (S.isAllocated() || S.isAllocatedOfSizeZero()))
         && (!(SPrev != null) || !(SPrev.isAllocated()
         || SPrev.isAllocatedOfSizeZero())));
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::isReleased">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 436,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::isReleased", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor10isReleasedEPKNS_8RefStateES4_PKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor10isReleasedEPKNS_8RefStateES4_PKN5clang4StmtE")
    //</editor-fold>
    public /*inline*/ boolean isReleased(/*const*/ RefState /*P*/ S, /*const*/ RefState /*P*/ SPrev, 
              /*const*/ Stmt /*P*/ $Stmt) {
      // Did not track -> released. Other state (allocated) -> released.
      return (($Stmt != null) && (isa_CallExpr($Stmt) || isa_CXXDeleteExpr($Stmt))
         && ((S != null) && S.isReleased()) && (!(SPrev != null) || !SPrev.isReleased()));
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::isRelinquished">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 443,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::isRelinquished", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor14isRelinquishedEPKNS_8RefStateES4_PKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor14isRelinquishedEPKNS_8RefStateES4_PKN5clang4StmtE")
    //</editor-fold>
    public /*inline*/ boolean isRelinquished(/*const*/ RefState /*P*/ S, /*const*/ RefState /*P*/ SPrev, 
                  /*const*/ Stmt /*P*/ $Stmt) {
      // Did not track -> relinquished. Other state (allocated) -> relinquished.
      return (($Stmt != null) && (isa_CallExpr($Stmt) || isa_ObjCMessageExpr($Stmt)
         || isa_ObjCPropertyRefExpr($Stmt))
         && ((S != null) && S.isRelinquished())
         && (!(SPrev != null) || !SPrev.isRelinquished()));
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::isReallocFailedCheck">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 452,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::isReallocFailedCheck", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor20isReallocFailedCheckEPKNS_8RefStateES4_PKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor20isReallocFailedCheckEPKNS_8RefStateES4_PKN5clang4StmtE")
    //</editor-fold>
    public /*inline*/ boolean isReallocFailedCheck(/*const*/ RefState /*P*/ S, /*const*/ RefState /*P*/ SPrev, 
                        /*const*/ Stmt /*P*/ $Stmt) {
      // If the expression is not a call, and the state change is
      // released -> allocated, it must be the realloc return value
      // check. If we have to handle more cases here, it might be cleaner just
      // to track this extra bit in the state itself.
      return ((!($Stmt != null) || !isa_CallExpr($Stmt))
         && ((S != null) && (S.isAllocated() || S.isAllocatedOfSizeZero()))
         && ((SPrev != null) && !(SPrev.isAllocated()
         || SPrev.isAllocatedOfSizeZero())));
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::VisitNode">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2617,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::VisitNode", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE")
    //</editor-fold>
    @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
             /*const*/ ExplodedNode /*P*/ PrevN, 
             final BugReporterContext /*&*/ BRC, 
             final BugReport /*&*/ BR)/* override*/ {
      IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
      IntrusiveRefCntPtr</*const*/ ProgramState> statePrev = null;
      try {
        state = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
        statePrev = new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevN.getState());
        
        /*const*/ RefState /*P*/ RS = state.$arrow()./*<RegionState>*/get(ProgramStateTraitRegionState.$Instance, Sym);
        /*const*/ RefState /*P*/ RSPrev = statePrev.$arrow()./*<RegionState>*/get(ProgramStateTraitRegionState.$Instance, Sym);
        if (!(RS != null)) {
          return null;
        }
        
        /*const*/ Stmt /*P*/ S = null;
        /*const*/char$ptr/*char P*/ Msg = null;
        StackHintGeneratorForSymbol /*P*/ StackHint = null;
        
        // Retrieve the associated statement.
        ProgramPoint ProgLoc = N.getLocation();
        {
          Optional<StmtPoint> SP = ProgLoc.getAs(StmtPoint.class);
          if (SP.$bool()) {
            S = SP.$arrow().getStmt();
          } else {
            Optional<CallExitEnd> Exit = ProgLoc.getAs(CallExitEnd.class);
            if (Exit.$bool()) {
              S = Exit.$arrow().getCalleeContext().getCallSite();
            } else {
              Optional<BlockEdge> Edge = ProgLoc.getAs(BlockEdge.class);
              if (Edge.$bool()) {
                // If an assumption was made on a branch, it should be caught
                // here by looking at the state transition.
                S = Edge.$arrow().getSrc().getTerminator$Const().$Stmt$C$P();
              }
            }
          }
        }
        if (!(S != null)) {
          return null;
        }
        
        // FIXME: We will eventually need to handle non-statement-based events
        // (__attribute__((cleanup))).
        
        // Find out if this is an interesting point and what is the kind.
        if (Mode == NotificationMode.Normal) {
          if (isAllocated(RS, RSPrev, S)) {
            Msg = $("Memory is allocated");
            StackHint = new StackHintGeneratorForSymbol(Sym, 
                new StringRef(/*KEEP_STR*/"Returned allocated memory"));
          } else if (isReleased(RS, RSPrev, S)) {
            Msg = $("Memory is released");
            StackHint = new StackHintGeneratorForSymbol(Sym, 
                new StringRef(/*KEEP_STR*/"Returning; memory was released"));
          } else if (isRelinquished(RS, RSPrev, S)) {
            Msg = $("Memory ownership is transferred");
            StackHint = new StackHintGeneratorForSymbol(Sym, new StringRef(/*KEEP_STR*/$EMPTY));
          } else if (isReallocFailedCheck(RS, RSPrev, S)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              Mode = NotificationMode.ReallocationFailed;
              Msg = $("Reallocation failed");
              StackHint = new StackHintGeneratorForReallocationFailed(Sym, 
                  new StringRef(/*KEEP_STR*/"Reallocation failed"));
              {
                
                /*const*/ SymExpr /*P*/ sym = $c$.clean(MallocCheckerStatics.findFailedReallocSymbol($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(statePrev))));
                if ((sym != null)) {
                  // Is it possible to fail two reallocs WITHOUT testing in between?
                  assert ((!(FailedReallocSymbol != null) || FailedReallocSymbol == sym)) : "We only support one failed realloc at a time.";
                  BR.markInteresting(sym);
                  FailedReallocSymbol = sym;
                }
              }
            } finally {
              $c$.$destroy();
            }
          }
          // We are in a special mode if a reallocation failed later in the path.
        } else if (Mode == NotificationMode.ReallocationFailed) {
          assert ((FailedReallocSymbol != null)) : "No symbol to look for.";
          
          // Is this is the first appearance of the reallocated symbol?
          if (!(statePrev.$arrow()./*<RegionState>*/get(ProgramStateTraitRegionState.$Instance, FailedReallocSymbol) != null)) {
            // We're at the reallocation point.
            Msg = $("Attempt to reallocate memory");
            StackHint = new StackHintGeneratorForSymbol(Sym, 
                new StringRef(/*KEEP_STR*/"Returned reallocated memory"));
            FailedReallocSymbol = null;
            Mode = NotificationMode.Normal;
          }
        }
        if (!Native.$bool(Msg)) {
          return null;
        }
        assert Native.$bool(StackHint);
        
        // Generate the extra diagnostic.
        PathDiagnosticLocation Pos/*J*/= new PathDiagnosticLocation(S, BRC.getSourceManager(), 
            new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, N.getLocationContext()));
        return new PathDiagnosticEventPiece(Pos, new StringRef(Msg), true, StackHint);
      } finally {
        if (statePrev != null) { statePrev.$destroy(); }
        if (state != null) { state.$destroy(); }
      } 
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::getEndPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 469,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::getEndPath", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor10getEndPathERN5clang4ento18BugReporterContextEPKNS3_12ExplodedNodeERNS3_9BugReportE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor10getEndPathERN5clang4ento18BugReporterContextEPKNS3_12ExplodedNodeERNS3_9BugReportE")
    //</editor-fold>
    @Override public std.unique_ptr<PathDiagnosticPiece> getEndPath(final BugReporterContext /*&*/ BRC, /*const*/ ExplodedNode /*P*/ EndPathNode, 
              final BugReport /*&*/ BR)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (!IsLeak) {
          return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
        }
        
        PathDiagnosticLocation L = PathDiagnosticLocation.createEndOfPath(EndPathNode, 
            BRC.getSourceManager());
        // Do not add the statement itself as a range in case of leak.
        return $c$.clean(new std.unique_ptr<PathDiagnosticPiece>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new PathDiagnosticEventPiece(L, BR.getDescription(), 
                false)))));
      } finally {
        $c$.$destroy();
      }
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 484,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailedE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailedE")
    //</editor-fold>
    private static class StackHintGeneratorForReallocationFailed extends /*public*/ StackHintGeneratorForSymbol implements Destructors.ClassWithDestructor {
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed::StackHintGeneratorForReallocationFailed">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 487,
       FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed::StackHintGeneratorForReallocationFailed", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailedC1EPKN5clang4ento7SymExprEN4llvm9StringRefE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailedC1EPKN5clang4ento7SymExprEN4llvm9StringRefE")
      //</editor-fold>
      public StackHintGeneratorForReallocationFailed(/*const*/ SymExpr /*P*/ S, StringRef M) {
        // : StackHintGeneratorForSymbol(S, M) 
        //START JInit
        super(S, new StringRef(M));
        //END JInit
      }

      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed::getMessageForArg">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 490,
       FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed::getMessageForArg", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailed16getMessageForArgEPKN5clang4ExprEj",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailed16getMessageForArgEPKN5clang4ExprEj")
      //</editor-fold>
      @Override public std.string getMessageForArg(/*const*/ Expr /*P*/ ArgE, 
                      /*uint*/int ArgIndex)/* override*/ {
        raw_svector_ostream os = null;
        try {
          // Printed parameters start at 1, not 0.
          ++ArgIndex;
          
          SmallString/*<200>*/ buf/*J*/= new SmallString/*<200>*/(200);
          os/*J*/= new raw_svector_ostream(buf);
          
          os.$out(/*KEEP_STR*/"Reallocation of ").$out_uint(ArgIndex).$out(llvm.getOrdinalSuffix(ArgIndex)).$out(
              /*KEEP_STR*/" parameter failed"
          );
          
          return os.str().$string();
        } finally {
          if (os != null) { os.$destroy(); }
        }
      }

      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed::getMessageForReturn">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 504,
       FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed::getMessageForReturn", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailed19getMessageForReturnEPKN5clang8CallExprE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailed19getMessageForReturnEPKN5clang8CallExprE")
      //</editor-fold>
      @Override public std.string getMessageForReturn(/*const*/ CallExpr /*P*/ $CallExpr)/* override*/ {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Reallocation of returned value failed");
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed::~StackHintGeneratorForReallocationFailed">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 484,
       FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::StackHintGeneratorForReallocationFailed::~StackHintGeneratorForReallocationFailed", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailedD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitor39StackHintGeneratorForReallocationFailedD0Ev")
      //</editor-fold>
      @Override public /*inline*/ void $destroy() {
        super.$destroy();
      }

      
      @Override public String toString() {
        return "" + super.toString(); // NOI18N
      }
    };
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::~MallocBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 398,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::~MallocBugVisitor", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitorD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::MallocBugVisitor::MallocBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 398,
     FQN="(anonymous namespace)::MallocChecker::MallocBugVisitor::MallocBugVisitor", NM="_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocChecker16MallocBugVisitorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ MallocBugVisitor(final /*const*/ MallocBugVisitor /*&*/ $Prm0) {
      // : BugReporterVisitorImpl<MallocBugVisitor>(), Sym(.Sym), Mode(.Mode), FailedReallocSymbol(.FailedReallocSymbol), IsLeak(.IsLeak) 
      //START JInit
      super($Prm0);
      this.Sym = $Prm0.Sym;
      this.Mode = $Prm0.Mode;
      this.FailedReallocSymbol = $Prm0.FailedReallocSymbol;
      this.IsLeak = $Prm0.IsLeak;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public MallocBugVisitor clone() {
      return new MallocBugVisitor(this);
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Sym=" + "[SymExpr]" // NOI18N
                + ", Mode=" + Mode // NOI18N
                + ", FailedReallocSymbol=" + "[SymExpr]" // NOI18N
                + ", IsLeak=" + IsLeak // NOI18N
                + super.toString(); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocChecker::~MallocChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 158,
   FQN="(anonymous namespace)::MallocChecker::~MallocChecker", NM="_ZN12_GLOBAL__N_113MallocCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_113MallocCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    KernelZeroFlagVal.$destroy();
    Destructors.$destroyArray_ClassWithDestructor(BT_UseZerroAllocated);
    Destructors.$destroyArray_ClassWithDestructor(BT_OffsetFree);
    BT_MismatchedDealloc.$destroy();
    Destructors.$destroyArray_ClassWithDestructor(BT_FreeAlloca);
    Destructors.$destroyArray_ClassWithDestructor(BT_BadFree);
    Destructors.$destroyArray_ClassWithDestructor(BT_UseFree);
    Destructors.$destroyArray_ClassWithDestructor(BT_Leak);
    BT_DoubleDelete.$destroy();
    Destructors.$destroyArray_ClassWithDestructor(BT_DoubleFree);
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CXXDeleteExpr) {
      checkPreStmt((CXXDeleteExpr) stmt, C);
    } else if (stmt instanceof ReturnStmt) {
      checkPreStmt((ReturnStmt) stmt, C);
    }
  }

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPostStmt((CallExpr) stmt, C);
    } else if (stmt instanceof CXXNewExpr) {
      checkPostStmt((CXXNewExpr) stmt, C);
    } else if (stmt instanceof BlockExpr) {
      checkPostStmt((BlockExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new DeadSymbols(),
    new PointerEscape(),
    new ConstPointerEscape(),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
    new PreCall(),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CXXNewExpr>(CXXNewExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CXXDeleteExpr>(CXXDeleteExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<BlockExpr>(BlockExpr.class),
    new PostObjCMessage(),
    new Location(),
    new eval.Assume()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "IsOptimistic=" + IsOptimistic // NOI18N
              + ", ChecksEnabled=" + ChecksEnabled // NOI18N
              + ", CheckNames=" + CheckNames // NOI18N
              + ", BT_DoubleFree=" + BT_DoubleFree // NOI18N
              + ", BT_DoubleDelete=" + BT_DoubleDelete // NOI18N
              + ", BT_Leak=" + BT_Leak // NOI18N
              + ", BT_UseFree=" + BT_UseFree // NOI18N
              + ", BT_BadFree=" + BT_BadFree // NOI18N
              + ", BT_FreeAlloca=" + BT_FreeAlloca // NOI18N
              + ", BT_MismatchedDealloc=" + BT_MismatchedDealloc // NOI18N
              + ", BT_OffsetFree=" + BT_OffsetFree // NOI18N
              + ", BT_UseZerroAllocated=" + BT_UseZerroAllocated // NOI18N
              + ", II_alloca=" + II_alloca // NOI18N
              + ", II_win_alloca=" + II_win_alloca // NOI18N
              + ", II_malloc=" + II_malloc // NOI18N
              + ", II_free=" + II_free // NOI18N
              + ", II_realloc=" + II_realloc // NOI18N
              + ", II_calloc=" + II_calloc // NOI18N
              + ", II_valloc=" + II_valloc // NOI18N
              + ", II_reallocf=" + II_reallocf // NOI18N
              + ", II_strndup=" + II_strndup // NOI18N
              + ", II_strdup=" + II_strdup // NOI18N
              + ", II_win_strdup=" + II_win_strdup // NOI18N
              + ", II_kmalloc=" + II_kmalloc // NOI18N
              + ", II_if_nameindex=" + II_if_nameindex // NOI18N
              + ", II_if_freenameindex=" + II_if_freenameindex // NOI18N
              + ", II_wcsdup=" + II_wcsdup // NOI18N
              + ", II_win_wcsdup=" + II_win_wcsdup // NOI18N
              + ", KernelZeroFlagVal=" + KernelZeroFlagVal // NOI18N
              + super.toString(); // NOI18N
  }
}
