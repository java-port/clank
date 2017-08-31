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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerMemberPointers.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.UnixAPICheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 32,
 FQN="(anonymous namespace)::UnixAPIChecker", NM="_ZN12_GLOBAL__N_114UnixAPICheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZN12_GLOBAL__N_114UnixAPICheckerE")
//</editor-fold>
public class UnixAPIChecker extends /*public*/ Checker/*T<PreStmt<CallExpr> >*/ implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT_open;
  private /*mutable */std.unique_ptr<BugType> BT_pthreadOnce;
  private /*mutable */std.unique_ptr<BugType> BT_mallocZero;
  private /*mutable */OptionalULong Val_O_CREAT;
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // Central dispatch function.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 350,
   FQN="(anonymous namespace)::UnixAPIChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
    if (!(FD != null) || FD.getKind() != Decl.Kind.Function) {
      return;
    }
    
    StringRef FName = C.getCalleeName(FD);
    if (FName.empty()) {
      return;
    }
    
    UnixAPIChecker$SubChecker SC = new StringSwitch<UnixAPIChecker$SubChecker>(/*NO_COPY*/FName).
        Case(/*KEEP_STR*/"open", /*AddrOf*//*FPtr*/UnixAPIChecker::CheckOpen).
        Case(/*KEEP_STR*/"pthread_once", /*AddrOf*//*FPtr*/UnixAPIChecker::CheckPthreadOnce).
        Case(/*KEEP_STR*/"calloc", /*AddrOf*//*FPtr*/UnixAPIChecker::CheckCallocZero).
        Case(/*KEEP_STR*/"malloc", /*AddrOf*//*FPtr*/UnixAPIChecker::CheckMallocZero).
        Case(/*KEEP_STR*/"realloc", /*AddrOf*//*FPtr*/UnixAPIChecker::CheckReallocZero).
        Case(/*KEEP_STR*/"reallocf", /*AddrOf*//*FPtr*/UnixAPIChecker::CheckReallocfZero).
        Cases(/*KEEP_STR*/"alloca", /*KEEP_STR*/"__builtin_alloca", /*AddrOf*//*FPtr*/UnixAPIChecker::CheckAllocaZero).
        Case(/*KEEP_STR*/"valloc", /*AddrOf*//*FPtr*/UnixAPIChecker::CheckVallocZero).
        Default((UnixAPIChecker$SubChecker)null);
    if ((SC != null)) {
      SC.$call(/*PtrMemI*/this, C, CE);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::CheckOpen">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 91,
   FQN="(anonymous namespace)::UnixAPIChecker::CheckOpen", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker9CheckOpenERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker9CheckOpenERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void CheckOpen(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> trueState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> falseState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($less_uint(CE.getNumArgs(), 2)) {
        // The frontend should issue a warning for this case, so this is a sanity
        // check.
        return;
      } else if (CE.getNumArgs() == 3) {
        /*const*/ Expr /*P*/ Arg = CE.getArg$Const(2);
        QualType QT = Arg.getType();
        if (!QT.$arrow().isIntegerType()) {
          ReportOpenBug(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), 
              $("Third argument to 'open' is not an integer"), 
              Arg.getSourceRange()); $c$.clean();
          return;
        }
      } else if ($greater_uint(CE.getNumArgs(), 3)) {
        ReportOpenBug(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), 
            $("Call to 'open' with more than three arguments"), 
            CE.getArg$Const(3).getSourceRange()); $c$.clean();
        return;
      }
      
      // The definition of O_CREAT is platform specific.  We need a better way
      // of querying this information from the checking environment.
      if (!Val_O_CREAT.hasValue()) {
        if (C.getASTContext().getTargetInfo().getTriple().getVendor()
           == Triple.VendorType.Apple) {
          Val_O_CREAT.$assign_T$RR($int2ullong(0x0200));
        } else {
          // FIXME: We need a more general way of getting the O_CREAT value.
          // We could possibly grovel through the preprocessor state, but
          // that would require passing the Preprocessor object to the ExprEngine.
          // See also: MallocChecker.cpp / M_ZERO.
          return;
        }
      }
      
      // Now check if oflags has O_CREAT set.
      /*const*/ Expr /*P*/ oflagsEx = CE.getArg$Const(1);
      /*const*/ SVal V = state.$arrow().getSVal(oflagsEx, C.getLocationContext());
      if (!V.getAs(NonLoc.class).$bool()) {
        // The case where 'V' can be a location can only be due to a bad header,
        // so in this case bail out.
        return;
      }
      NonLoc oflags = V.castAs(NonLoc.class);
      NonLoc ocreateFlag = C.getSValBuilder().
    makeIntVal(Val_O_CREAT.getValue(), oflagsEx.getType()).castAs(NonLoc.class);
      SVal maskedFlagsUC = $c$.clean(C.getSValBuilder().evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_And, 
          new NonLoc(oflags), new NonLoc(ocreateFlag), 
          oflagsEx.getType()));
      if (maskedFlagsUC.isUnknownOrUndef$SVal()) {
        return;
      }
      DefinedSVal maskedFlags = maskedFlagsUC.castAs(DefinedSVal.class);
      
      // Check if maskedFlags is non-zero.
      trueState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      falseState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(trueState, falseState).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(maskedFlags)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(maskedFlags)));
      trueState.$assign($assume.first);
      falseState.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      // Only emit an error if the value of 'maskedFlags' is properly
      // constrained;
      if (!(trueState.$bool() && !falseState.$bool())) {
        return;
      }
      if ($less_uint(CE.getNumArgs(), 3)) {
        ReportOpenBug(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(trueState)), 
            $("Call to 'open' requires a third argument when the 'O_CREAT' flag is set"), 
            oflagsEx.getSourceRange()); $c$.clean();
      }
    } finally {
      if (falseState != null) { falseState.$destroy(); }
      if (trueState != null) { trueState.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //===----------------------------------------------------------------------===//
  // pthread_once
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::CheckPthreadOnce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 168,
   FQN="(anonymous namespace)::UnixAPIChecker::CheckPthreadOnce", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker16CheckPthreadOnceERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker16CheckPthreadOnceERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void CheckPthreadOnce(final CheckerContext /*&*/ C, 
                  /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    raw_svector_ostream os = null;
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // This is similar to 'CheckDispatchOnce' in the MacOSXAPIChecker.
      // They can possibly be refactored.
      if ($less_uint(CE.getNumArgs(), 1)) {
        return;
      }
      
      // Check if the first argument is stack allocated.  If so, issue a warning
      // because that's likely to be bad news.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ MemRegion /*P*/ R = state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()).getAsRegion();
      if (!(R != null) || !isa_StackSpaceRegion(R.getMemorySpace())) {
        return;
      }
      
      ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      if (!(N != null)) {
        return;
      }
      
      SmallString/*<256>*/ S/*J*/= new SmallString/*<256>*/(256);
      os/*J*/= new raw_svector_ostream(S);
      os.$out(/*KEEP_STR*/"Call to 'pthread_once' uses");
      {
        /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(R);
        if ((VR != null)) {
          os.$out(/*KEEP_STR*/" the local variable '").$out(VR.getDecl().getName()).$out_char($$SGL_QUOTE);
        } else {
          os.$out(/*KEEP_STR*/" stack allocated memory");
        }
      }
      os.$out(/*KEEP_STR*/" for the \"control\" value.  Using such transient memory for the control value is potentially dangerous.");
      if (isa_VarRegion(R) && isa_StackLocalsSpaceRegion(R.getMemorySpace())) {
        os.$out(/*KEEP_STR*/"  Perhaps you intended to declare the variable as 'static'?");
      }
      
      LazyInitialize(BT_pthreadOnce, $("Improper use of 'pthread_once'"));
      
      report = llvm.make_unique(new BugReport(BT_pthreadOnce.$star(), os.str(), N));
      report.$arrow().addRange(CE.getArg$Const(0).getSourceRange());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
    } finally {
      if (report != null) { report.$destroy(); }
      if (os != null) { os.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::CheckCallocZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 284,
   FQN="(anonymous namespace)::UnixAPIChecker::CheckCallocZero", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker15CheckCallocZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker15CheckCallocZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void CheckCallocZero(final CheckerContext /*&*/ C, 
                 /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> trueState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> falseState = null;
    try {
      /*uint*/int nArgs = CE.getNumArgs();
      if (nArgs != 2) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      trueState = new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      falseState = new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      
      /*uint*/int i;
      for (i = 0; $less_uint(i, nArgs); i++) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*const*/ Expr /*P*/ arg = CE.getArg$Const(i);
          SVal argVal = state.$arrow().getSVal(arg, C.getLocationContext());
          if (argVal.isUnknownOrUndef$SVal()) {
            if (i == 0) {
              continue;
            } else {
              return;
            }
          }
          if ($c$.clean(UnixAPICheckerStatics.IsZeroByteAllocation($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(argVal), $AddrOf(trueState), $AddrOf(falseState)))) {
            if ($c$.clean(ReportZeroByteAllocation(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(falseState)), arg, $("calloc")))) {
              return;
            } else if (i == 0) {
              continue;
            } else {
              return;
            }
          }
        } finally {
          $c$.$destroy();
        }
      }
      
      // Assume the value is non-zero going forward.
      assert ((trueState).$bool());
      if ($noteq_IntrusiveRefCntPtr(trueState, state)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(trueState))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (falseState != null) { falseState.$destroy(); }
      if (trueState != null) { trueState.$destroy(); }
      if (state != null) { state.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::CheckMallocZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 320,
   FQN="(anonymous namespace)::UnixAPIChecker::CheckMallocZero", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker15CheckMallocZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker15CheckMallocZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void CheckMallocZero(final CheckerContext /*&*/ C, 
                 /*const*/ CallExpr /*P*/ CE) /*const*/ {
    BasicAllocationCheck(C, CE, 1, 0, $("malloc"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::CheckReallocZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 325,
   FQN="(anonymous namespace)::UnixAPIChecker::CheckReallocZero", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker16CheckReallocZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker16CheckReallocZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void CheckReallocZero(final CheckerContext /*&*/ C, 
                  /*const*/ CallExpr /*P*/ CE) /*const*/ {
    BasicAllocationCheck(C, CE, 2, 1, $("realloc"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::CheckReallocfZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 330,
   FQN="(anonymous namespace)::UnixAPIChecker::CheckReallocfZero", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker17CheckReallocfZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker17CheckReallocfZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void CheckReallocfZero(final CheckerContext /*&*/ C, 
                   /*const*/ CallExpr /*P*/ CE) /*const*/ {
    BasicAllocationCheck(C, CE, 2, 1, $("reallocf"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::CheckAllocaZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 335,
   FQN="(anonymous namespace)::UnixAPIChecker::CheckAllocaZero", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker15CheckAllocaZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker15CheckAllocaZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void CheckAllocaZero(final CheckerContext /*&*/ C, 
                 /*const*/ CallExpr /*P*/ CE) /*const*/ {
    BasicAllocationCheck(C, CE, 1, 0, $("alloca"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::CheckVallocZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 340,
   FQN="(anonymous namespace)::UnixAPIChecker::CheckVallocZero", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker15CheckVallocZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker15CheckVallocZeroERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  public void CheckVallocZero(final CheckerContext /*&*/ C, 
                 /*const*/ CallExpr /*P*/ CE) /*const*/ {
    BasicAllocationCheck(C, CE, 1, 0, $("valloc"));
  }

  
  // JAVA: typedef void (UnixAPIChecker::*SubChecker)(CheckerContext &, const CallExpr *) const
//  public final class SubChecker extends UnixAPIChecker$SubChecker{ };
/*private:*/
  
  // Generates an error report, indicating that the function whose name is given
  // will perform a zero byte allocation.
  // Returns false if an error occurred, true otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::ReportZeroByteAllocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 230,
   FQN="(anonymous namespace)::UnixAPIChecker::ReportZeroByteAllocation", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker24ReportZeroByteAllocationERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker24ReportZeroByteAllocationERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKNS1_4ExprEPKc")
  //</editor-fold>
  private boolean ReportZeroByteAllocation(final CheckerContext /*&*/ C, 
                          IntrusiveRefCntPtr</*const*/ ProgramState> falseState, 
                          /*const*/ Expr /*P*/ arg, 
                          /*const*/char$ptr/*char P*/ fn_name) /*const*/ {
    raw_svector_ostream os = null;
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(falseState))));
      if (!(N != null)) {
        return false;
      }
      
      LazyInitialize(BT_mallocZero, 
          $("Undefined allocation of 0 bytes (CERT MEM04-C; CWE-131)"));
      
      SmallString/*<256>*/ S/*J*/= new SmallString/*<256>*/(256);
      os/*J*/= new raw_svector_ostream(S);
      os.$out(/*KEEP_STR*/"Call to '").$out(fn_name).$out(/*KEEP_STR*/"' has an allocation size of 0 bytes");
      report = llvm.make_unique(new BugReport(BT_mallocZero.$star(), os.str(), N));
      
      report.$arrow().addRange(arg.getSourceRange());
      NsBugreporter.trackNullOrUndefValue(N, arg, report.$star());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
      
      return true;
    } finally {
      if (report != null) { report.$destroy(); }
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // Does a basic check for 0-sized allocations suitable for most of the below
  // functions (modulo "calloc")
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::BasicAllocationCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 255,
   FQN="(anonymous namespace)::UnixAPIChecker::BasicAllocationCheck", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker20BasicAllocationCheckERN5clang4ento14CheckerContextEPKNS1_8CallExprEjjPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker20BasicAllocationCheckERN5clang4ento14CheckerContextEPKNS1_8CallExprEjjPKc")
  //</editor-fold>
  private void BasicAllocationCheck(final CheckerContext /*&*/ C, 
                      /*const*/ CallExpr /*P*/ CE, 
                      /*const*//*uint*/int numArgs, 
                      /*const*//*uint*/int sizeArg, 
                      /*const*/char$ptr/*char P*/ fn) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> trueState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> falseState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Sanity check for the correct number of arguments
      if (CE.getNumArgs() != numArgs) {
        return;
      }
      
      // Check if the allocation size is 0.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      trueState = new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      falseState = new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      /*const*/ Expr /*P*/ arg = CE.getArg$Const(sizeArg);
      SVal argVal = state.$arrow().getSVal(arg, C.getLocationContext());
      if (argVal.isUnknownOrUndef$SVal()) {
        return;
      }
      
      // Is the value perfectly constrained to zero?
      if ($c$.clean(UnixAPICheckerStatics.IsZeroByteAllocation($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(argVal), $AddrOf(trueState), $AddrOf(falseState)))) {
        /*J:(void)*/ReportZeroByteAllocation(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(falseState)), arg, fn); $c$.clean();
        return;
      }
      // Assume the value is non-zero going forward.
      assert ((trueState).$bool());
      if ($noteq_IntrusiveRefCntPtr(trueState, state)) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(trueState))));
      }
    } finally {
      if (falseState != null) { falseState.$destroy(); }
      if (trueState != null) { trueState.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::LazyInitialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 60,
   FQN="(anonymous namespace)::UnixAPIChecker::LazyInitialize", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker14LazyInitializeERSt10unique_ptrIN5clang4ento7BugTypeESt14default_deleteIS4_EEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker14LazyInitializeERSt10unique_ptrIN5clang4ento7BugTypeESt14default_deleteIS4_EEPKc")
  //</editor-fold>
  private void LazyInitialize(final std.unique_ptr<BugType> /*&*/ BT, /*const*/char$ptr/*char P*/ name) /*const*/ {
    if (BT.$bool()) {
      return;
    }
    BT.reset(new BugType(this, new StringRef(name), new StringRef(categories.UnixAPI)));
  }

  //end anonymous namespace
  
  //===----------------------------------------------------------------------===//
  // "open" (man 2 open)
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::ReportOpenBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 76,
   FQN="(anonymous namespace)::UnixAPIChecker::ReportOpenBug", NM="_ZNK12_GLOBAL__N_114UnixAPIChecker13ReportOpenBugERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKcNS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_114UnixAPIChecker13ReportOpenBugERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEEPKcNS1_11SourceRangeE")
  //</editor-fold>
  private void ReportOpenBug(final CheckerContext /*&*/ C, 
               IntrusiveRefCntPtr</*const*/ ProgramState> State, 
               /*const*/char$ptr/*char P*/ Msg, 
               SourceRange SR) /*const*/ {
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      if (!(N != null)) {
        return;
      }
      
      LazyInitialize(BT_open, $("Improper use of 'open'"));
      
      Report = llvm.make_unique(new BugReport(BT_open.$star(), Msg, N));
      Report.$arrow().addRange(new SourceRange(SR));
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::~UnixAPIChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 32,
   FQN="(anonymous namespace)::UnixAPIChecker::~UnixAPIChecker", NM="_ZN12_GLOBAL__N_114UnixAPICheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZN12_GLOBAL__N_114UnixAPICheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Val_O_CREAT.$destroy();
    BT_mallocZero.$destroy();
    BT_pthreadOnce.$destroy();
    BT_open.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnixAPIChecker::UnixAPIChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 32,
   FQN="(anonymous namespace)::UnixAPIChecker::UnixAPIChecker", NM="_ZN12_GLOBAL__N_114UnixAPICheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZN12_GLOBAL__N_114UnixAPICheckerC1Ev")
  //</editor-fold>
  public /*inline*/ UnixAPIChecker() {
    // : Checker<PreStmt<CallExpr> >(), BT_open(), BT_pthreadOnce(), BT_mallocZero(), Val_O_CREAT() 
    //START JInit
    super();
    this.BT_open = new std.unique_ptr<BugType>();
    this.BT_pthreadOnce = new std.unique_ptr<BugType>();
    this.BT_mallocZero = new std.unique_ptr<BugType>();
    this.Val_O_CREAT = new OptionalULong();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPreStmt((CallExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_open=" + BT_open // NOI18N
              + ", BT_pthreadOnce=" + BT_pthreadOnce // NOI18N
              + ", BT_mallocZero=" + BT_mallocZero // NOI18N
              + ", Val_O_CREAT=" + Val_O_CREAT // NOI18N
              + super.toString(); // NOI18N
  }
}
