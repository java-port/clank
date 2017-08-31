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
import org.clang.staticanalyzer.java.CheckBase;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.checkers.ento.impl.PointerArithCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 45,
 FQN="(anonymous namespace)::PointerArithChecker", NM="_ZN12_GLOBAL__N_119PointerArithCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZN12_GLOBAL__N_119PointerArithCheckerE")
//</editor-fold>
public class PointerArithChecker extends /*public*/ Checker/*<PreStmt<BinaryOperator>, PreStmt<UnaryOperator>, PreStmt<ArraySubscriptExpr>, PreStmt<CastExpr>, PostStmt<CastExpr>, PostStmt<CXXNewExpr>, PostStmt<CallExpr>, DeadSymbols>*/ 
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor { 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::getKindOfNewOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 92,
   FQN="(anonymous namespace)::PointerArithChecker::getKindOfNewOp", NM="_ZNK12_GLOBAL__N_119PointerArithChecker14getKindOfNewOpEPKN5clang10CXXNewExprEPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker14getKindOfNewOpEPKN5clang10CXXNewExprEPKNS1_12FunctionDeclE")
  //</editor-fold>
  private AllocKind getKindOfNewOp(/*const*/ CXXNewExpr /*P*/ NE, 
                /*const*/ FunctionDecl /*P*/ FD) /*const*/ {
    // This checker try not to assume anything about placement and overloaded
    // new to avoid false positives.
    if (isa_CXXMethodDecl(FD)) {
      return AllocKind.Unknown;
    }
    if (FD.getNumParams() != 1 || FD.isVariadic()) {
      return AllocKind.Unknown;
    }
    if (NE.isArray()) {
      return AllocKind.Array;
    }
    
    return AllocKind.SingleObject;
  }

  
  /// Checks whether a region is the part of an array.
  /// In case there is a dericed to base cast above the array element, the
  /// Polymorphic output value is set to true. AKind output value is set to the
  /// allocation kind of the inspected region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::getArrayRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 119,
   FQN="(anonymous namespace)::PointerArithChecker::getArrayRegion", NM="_ZNK12_GLOBAL__N_119PointerArithChecker14getArrayRegionEPKN5clang4ento9MemRegionERbRNS_9AllocKindERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker14getArrayRegionEPKN5clang4ento9MemRegionERbRNS_9AllocKindERNS2_14CheckerContextE")
  //</editor-fold>
  private /*const*/ MemRegion /*P*/ getArrayRegion(/*const*/ MemRegion /*P*/ Region, 
                final bool$ref/*bool &*/ Polymorphic, 
                final type$ref<AllocKind /*&*/> AKind, 
                final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      assert Native.$bool(Region);
      while (Region.getKind() == MemRegion.Kind.CXXBaseObjectRegionKind) {
        Region = Region.getAs(CXXBaseObjectRegion.class).getSuperRegion();
        Polymorphic.$set(true);
      }
      if (Region.getKind() == MemRegion.Kind.ElementRegionKind) {
        Region = Region.getAs(ElementRegion.class).getSuperRegion();
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      {
        /*const*/ AllocKind /*P*/ Kind = State.$arrow()./*<RegionState>*/get(ProgramStateTraitRegionState.$Instance, Region);
        if ((Kind != null)) {
          AKind.$set($Deref(Kind));
          if ($Deref(Kind) == AllocKind.Array) {
            return Region;
          } else {
            return null;
          }
        }
      }
      // When the region is symbolic and we do not have any information about it,
      // assume that this is an array to avoid false positives.
      if (Region.getKind() == MemRegion.Kind.SymbolicRegionKind) {
        return Region;
      }
      
      // No AllocKind stored and not symbolic, assume that it points to a single
      // object.
      return null;
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::getPointedRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 106,
   FQN="(anonymous namespace)::PointerArithChecker::getPointedRegion", NM="_ZNK12_GLOBAL__N_119PointerArithChecker16getPointedRegionEPKN5clang4ento9MemRegionERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker16getPointedRegionEPKN5clang4ento9MemRegionERNS2_14CheckerContextE")
  //</editor-fold>
  private /*const*/ MemRegion /*P*/ getPointedRegion(/*const*/ MemRegion /*P*/ Region, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      assert Native.$bool(Region);
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal S = State.$arrow().getSVal(Region);
      return S.getAsRegion();
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::reportPointerArithMisuse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 150,
   FQN="(anonymous namespace)::PointerArithChecker::reportPointerArithMisuse", NM="_ZNK12_GLOBAL__N_119PointerArithChecker24reportPointerArithMisuseEPKN5clang4ExprERNS1_4ento14CheckerContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker24reportPointerArithMisuseEPKN5clang4ExprERNS1_4ento14CheckerContextEb")
  //</editor-fold>
  private void reportPointerArithMisuse(/*const*/ Expr /*P*/ E, 
                          final CheckerContext /*&*/ C) /*const*/ {
    reportPointerArithMisuse(E, 
                          C, 
                          false);
  }
  private void reportPointerArithMisuse(/*const*/ Expr /*P*/ E, 
                          final CheckerContext /*&*/ C, 
                          boolean PointedNeeded/*= false*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      SourceRange SR = E.getSourceRange();
      if (SR.isInvalid()) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ MemRegion /*P*/ Region = State.$arrow().getSVal(E, C.getLocationContext()).getAsRegion();
      if (!(Region != null)) {
        return;
      }
      if (PointedNeeded) {
        Region = getPointedRegion(Region, C);
      }
      if (!(Region != null)) {
        return;
      }
      
      bool$ref IsPolymorphic = create_bool$ref(false);
      type$ref<AllocKind> Kind = create_type$ref(AllocKind.Unknown);
      {
        /*const*/ MemRegion /*P*/ ArrayRegion = getArrayRegion(Region, IsPolymorphic, Kind, C);
        if ((ArrayRegion != null)) {
          if (!IsPolymorphic.$deref()) {
            return;
          }
          {
            ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
            if ((N != null)) {
              unique_ptr<BugReport> R = null;
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if (!BT_polyArray.$bool()) {
                  BT_polyArray.reset(new BuiltinBug(this, $("Dangerous pointer arithmetic"), 
                          $("Pointer arithmetic on a pointer to base class is dangerous because derived and base class may have different size.")));
                }
                R = llvm.make_unique(new BugReport(BT_polyArray.$star(), 
                    BT_polyArray.$arrow().getDescription(), N));
                R.$arrow().addRange(E.getSourceRange());
                R.$arrow().markInteresting(ArrayRegion);
                C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
              } finally {
                if (R != null) { R.$destroy(); }
                $c$.$destroy();
              }
            }
          }
          return;
        }
      }
      if (Kind.$deref() == AllocKind.Reinterpreted) {
        return;
      }
      
      // We might not have enough information about symbolic regions.
      if (Kind.$deref() != AllocKind.SingleObject
         && Region.getKind() == MemRegion.Kind.SymbolicRegionKind) {
        return;
      }
      {
        
        ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
        if ((N != null)) {
          unique_ptr<BugReport> R = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (!BT_pointerArith.$bool()) {
              BT_pointerArith.reset(new BuiltinBug(this, $("Dangerous pointer arithmetic"), 
                      $("Pointer arithmetic on non-array variables relies on memory layout, which is dangerous.")));
            }
            R = llvm.make_unique(new BugReport(BT_pointerArith.$star(), 
                BT_pointerArith.$arrow().getDescription(), N));
            R.$arrow().addRange(new SourceRange(SR));
            R.$arrow().markInteresting(Region);
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
          } finally {
            if (R != null) { R.$destroy(); }
            $c$.$destroy();
          }
        }
      }
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::initAllocIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 210,
   FQN="(anonymous namespace)::PointerArithChecker::initAllocIdentifiers", NM="_ZNK12_GLOBAL__N_119PointerArithChecker20initAllocIdentifiersERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker20initAllocIdentifiersERN5clang10ASTContextE")
  //</editor-fold>
  private void initAllocIdentifiers(final ASTContext /*&*/ C) /*const*/ {
    if (!AllocFunctions.empty()) {
      return;
    }
    AllocFunctions.insert($AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"alloca"))));
    AllocFunctions.insert($AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"malloc"))));
    AllocFunctions.insert($AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"realloc"))));
    AllocFunctions.insert($AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"calloc"))));
    AllocFunctions.insert($AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"valloc"))));
  }

  
  private /*mutable */std.unique_ptr<BuiltinBug> BT_pointerArith;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_polyArray;
  private /*mutable */SmallSetT$PLess$T$P<IdentifierInfo /*P*/ > AllocFunctions;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 299,
   FQN="(anonymous namespace)::PointerArithChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_119PointerArithChecker12checkPreStmtEPKN5clang13UnaryOperatorERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker12checkPreStmtEPKN5clang13UnaryOperatorERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ UnaryOperator /*P*/ UOp, 
              final CheckerContext /*&*/ C) /*const*/ {
    if (!UOp.isIncrementDecrementOp() || !UOp.getType().$arrow().isPointerType()) {
      return;
    }
    reportPointerArithMisuse(UOp.getSubExpr(), C, true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 317,
   FQN="(anonymous namespace)::PointerArithChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_119PointerArithChecker12checkPreStmtEPKN5clang14BinaryOperatorERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker12checkPreStmtEPKN5clang14BinaryOperatorERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ BinaryOperator /*P*/ BOp, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      BinaryOperatorKind OpKind = BOp.getOpcode();
      if (!BOp.isAdditiveOp() && OpKind != BinaryOperatorKind.BO_AddAssign && OpKind != BinaryOperatorKind.BO_SubAssign) {
        return;
      }
      
      /*const*/ Expr /*P*/ Lhs = BOp.getLHS();
      /*const*/ Expr /*P*/ Rhs = BOp.getRHS();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (Rhs.getType().$arrow().isIntegerType() && Lhs.getType().$arrow().isPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SVal RHSVal = State.$arrow().getSVal(Rhs, C.getLocationContext());
          if ($c$.clean($c$.track(State.$arrow().isNull(new SVal(RHSVal))).isConstrainedTrue())) {
            return;
          }
          reportPointerArithMisuse(Lhs, C, !BOp.isAdditiveOp());
        } finally {
          $c$.$destroy();
        }
      }
      // The int += ptr; case is not valid C++.
      if (Lhs.getType().$arrow().isIntegerType() && Rhs.getType().$arrow().isPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SVal LHSVal = State.$arrow().getSVal(Lhs, C.getLocationContext());
          if ($c$.clean($c$.track(State.$arrow().isNull(new SVal(LHSVal))).isConstrainedTrue())) {
            return;
          }
          reportPointerArithMisuse(Rhs, C);
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 306,
   FQN="(anonymous namespace)::PointerArithChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_119PointerArithChecker12checkPreStmtEPKN5clang18ArraySubscriptExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker12checkPreStmtEPKN5clang18ArraySubscriptExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ArraySubscriptExpr /*P*/ SubsExpr, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal Idx = State.$arrow().getSVal(SubsExpr.getIdx$Const(), C.getLocationContext());
      
      // Indexing with 0 is OK.
      if (Idx.isZeroConstant()) {
        return;
      }
      reportPointerArithMisuse(SubsExpr.getBase$Const(), C);
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 278,
   FQN="(anonymous namespace)::PointerArithChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_119PointerArithChecker12checkPreStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker12checkPreStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CastExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (CE.getCastKind() != CastKind.CK_ArrayToPointerDecay) {
        return;
      }
      
      /*const*/ Expr /*P*/ CastedExpr = CE.getSubExpr$Const();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal CastedVal = State.$arrow().getSVal(CastedExpr, C.getLocationContext());
      
      /*const*/ MemRegion /*P*/ Region = CastedVal.getAsRegion();
      if (!(Region != null)) {
        return;
      }
      {
        
        /*const*/ AllocKind /*P*/ Kind = State.$arrow()./*<RegionState>*/get(ProgramStateTraitRegionState.$Instance, Region);
        if ((Kind != null)) {
          if ($Deref(Kind) == AllocKind.Array || $Deref(Kind) == AllocKind.Reinterpreted) {
            return;
          }
        }
      }
      $c$.clean(State.$assign($c$.track(State.$arrow()./*<RegionState>*/set(ProgramStateTraitRegionState.$Instance, Region, AllocKind.Array))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 260,
   FQN="(anonymous namespace)::PointerArithChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_119PointerArithChecker13checkPostStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker13checkPostStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CastExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (CE.getCastKind() != CastKind.CK_BitCast) {
        return;
      }
      
      /*const*/ Expr /*P*/ CastedExpr = CE.getSubExpr$Const();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal CastedVal = State.$arrow().getSVal(CastedExpr, C.getLocationContext());
      
      /*const*/ MemRegion /*P*/ Region = CastedVal.getAsRegion();
      if (!(Region != null)) {
        return;
      }
      
      // Suppress reinterpret casted hits.
      $c$.clean(State.$assign($c$.track(State.$arrow()./*<RegionState>*/set(ProgramStateTraitRegionState.$Instance, Region, AllocKind.Reinterpreted))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 243,
   FQN="(anonymous namespace)::PointerArithChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_119PointerArithChecker13checkPostStmtEPKN5clang10CXXNewExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker13checkPostStmtEPKN5clang10CXXNewExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CXXNewExpr /*P*/ NE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ FunctionDecl /*P*/ FD = NE.getOperatorNew();
      if (!(FD != null)) {
        return;
      }
      
      AllocKind Kind = getKindOfNewOp(NE, FD);
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal AllocedVal = State.$arrow().getSVal(NE, C.getLocationContext());
      /*const*/ MemRegion /*P*/ Region = AllocedVal.getAsRegion();
      if (!(Region != null)) {
        return;
      }
      $c$.clean(State.$assign($c$.track(State.$arrow()./*<RegionState>*/set(ProgramStateTraitRegionState.$Instance, Region, Kind))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 220,
   FQN="(anonymous namespace)::PointerArithChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_119PointerArithChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CallExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
      if (!(FD != null)) {
        return;
      }
      IdentifierInfo /*P*/ FunI = FD.getIdentifier();
      initAllocIdentifiers(C.getASTContext());
      if (AllocFunctions.count(FunI) == 0) {
        return;
      }
      
      SVal SV = State.$arrow().getSVal(CE, C.getLocationContext());
      /*const*/ MemRegion /*P*/ Region = SV.getAsRegion();
      if (!(Region != null)) {
        return;
      }
      // Assume that C allocation functions allocate arrays to avoid false
      // positives.
      // TODO: Add heuristics to distinguish alloc calls that allocates single
      // objecs.
      $c$.clean(State.$assign($c$.track(State.$arrow()./*<RegionState>*/set(ProgramStateTraitRegionState.$Instance, Region, AllocKind.Array))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 78,
   FQN="(anonymous namespace)::PointerArithChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_119PointerArithChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZNK12_GLOBAL__N_119PointerArithChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SR, 
                  final CheckerContext /*&*/ C) /*const*/ {
    // TODO: intentional leak. Some information is garbage collected too early,
    // see http://reviews.llvm.org/D14203 for further information.
    /*ProgramStateRef State = C.getState();
    RegionStateTy RegionStates = State->get<RegionState>();
    for (RegionStateTy::iterator I = RegionStates.begin(), E = RegionStates.end();
    I != E; ++I) {
    if (!SR.isLiveRegion(I->first))
    State = State->remove<RegionState>(I->first);
    }
    C.addTransition(State);*/
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::~PointerArithChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 45,
   FQN="(anonymous namespace)::PointerArithChecker::~PointerArithChecker", NM="_ZN12_GLOBAL__N_119PointerArithCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZN12_GLOBAL__N_119PointerArithCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    AllocFunctions.$destroy();
    BT_polyArray.$destroy();
    BT_pointerArith.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerArithChecker::PointerArithChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 45,
   FQN="(anonymous namespace)::PointerArithChecker::PointerArithChecker", NM="_ZN12_GLOBAL__N_119PointerArithCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZN12_GLOBAL__N_119PointerArithCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ PointerArithChecker() {
    // : Checker<PreStmt<BinaryOperator>, PreStmt<UnaryOperator>, PreStmt<ArraySubscriptExpr>, PreStmt<CastExpr>, PostStmt<CastExpr>, PostStmt<CXXNewExpr>, PostStmt<CallExpr>, DeadSymbols>(), BT_pointerArith(), BT_polyArray(), AllocFunctions() 
    //START JInit
    super();
    this.BT_pointerArith = new std.unique_ptr<BuiltinBug>();
    this.BT_polyArray = new std.unique_ptr<BuiltinBug>();
    this.AllocFunctions = new SmallSetT$PLess$T$P<IdentifierInfo /*P*/ >(8);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof UnaryOperator) {
      checkPreStmt((UnaryOperator) stmt, C);
    } else if (stmt instanceof BinaryOperator) {
      checkPreStmt((BinaryOperator) stmt, C);
    } else if (stmt instanceof ArraySubscriptExpr) {
      checkPreStmt((ArraySubscriptExpr) stmt, C);
    } else if (stmt instanceof CastExpr) {
      checkPreStmt((CastExpr) stmt, C);
    }
  }
  
  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CastExpr) {
      checkPostStmt((CastExpr) stmt, C);
    } else if (stmt instanceof CXXNewExpr) {
      checkPostStmt((CXXNewExpr) stmt, C);
    } else if (stmt instanceof CallExpr) {
      checkPostStmt((CallExpr) stmt, C);
    }
  }
  
  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<BinaryOperator>(BinaryOperator.class),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<UnaryOperator>(UnaryOperator.class),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ArraySubscriptExpr>(ArraySubscriptExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CastExpr>(CastExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CastExpr>(CastExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CXXNewExpr>(CXXNewExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
    new org.clang.staticanalyzer.core.ento.check.DeadSymbols()
  };
  
  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_pointerArith=" + BT_pointerArith // NOI18N
              + ", BT_polyArray=" + BT_polyArray // NOI18N
              + ", AllocFunctions=" + AllocFunctions // NOI18N
              + super.toString(); // NOI18N
  }
}
