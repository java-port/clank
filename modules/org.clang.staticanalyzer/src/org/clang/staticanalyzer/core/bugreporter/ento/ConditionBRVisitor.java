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

package org.clang.staticanalyzer.core.bugreporter.ento;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clank.support.Native.$createJavaCleaner;


/// Visitor that tries to report interesting diagnostics from conditions.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 186,
 FQN="clang::ento::ConditionBRVisitor", NM="_ZN5clang4ento18ConditionBRVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18ConditionBRVisitorE")
//</editor-fold>
public final class ConditionBRVisitor extends /*public*/ BugReporterVisitorImpl<ConditionBRVisitor> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 189,
   FQN="clang::ento::ConditionBRVisitor::Profile", NM="_ZNK5clang4ento18ConditionBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento18ConditionBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    final/*static*/ Object x = Profile$$.x;
    ID.AddPointer($AddrOf(x));
  }
  private static final class Profile$$ {
    static final/*static*/ Object x = ConditionBRVisitor.class;
  }

  
  /// Return the tag associated with this visitor.  This tag will be used
  /// to make all PathDiagnosticPieces created by this visitor.
  
  /// Return the tag associated with this visitor.  This tag will be used
  /// to make all PathDiagnosticPieces created by this visitor.
  
  //===----------------------------------------------------------------------===//
  // Visitor that tries to report interesting diagnostics from conditions.
  //===----------------------------------------------------------------------===//
  
  /// Return the tag associated with this visitor.  This tag will be used
  /// to make all PathDiagnosticPieces created by this visitor.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1202,
   FQN="clang::ento::ConditionBRVisitor::getTag", NM="_ZN5clang4ento18ConditionBRVisitor6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor6getTagEv")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getTag() {
    return $("ConditionBRVisitor");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::VisitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1206,
   FQN="clang::ento::ConditionBRVisitor::VisitNode", NM="_ZN5clang4ento18ConditionBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
           /*const*/ ExplodedNode /*P*/ Prev, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    PathDiagnosticPiece /*P*/ piece = VisitNodeImpl(N, Prev, BRC, BR);
    if ((piece != null)) {
      piece.setTag(getTag());
      {
        PathDiagnosticEventPiece /*P*/ ev = dyn_cast_PathDiagnosticEventPiece(piece);
        if ((ev != null)) {
          ev.setPrunable(true, /* override */ false);
        }
      }
    }
    return piece;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::VisitNodeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1219,
   FQN="clang::ento::ConditionBRVisitor::VisitNodeImpl", NM="_ZN5clang4ento18ConditionBRVisitor13VisitNodeImplEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor13VisitNodeImplEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  public PathDiagnosticPiece /*P*/ VisitNodeImpl(/*const*/ ExplodedNode /*P*/ N, 
               /*const*/ ExplodedNode /*P*/ Prev, 
               final BugReporterContext /*&*/ BRC, 
               final BugReport /*&*/ BR) {
    IntrusiveRefCntPtr</*const*/ ProgramState> CurrentState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> PrevState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      ProgramPoint progPoint = N.getLocation();
      CurrentState = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      PrevState = new IntrusiveRefCntPtr</*const*/ ProgramState>(Prev.getState());

      // Compare the GDMs of the state, because that is where constraints
      // are managed.  Note that ensure that we only look at nodes that
      // were generated by the analyzer engine proper, not checkers.
      if ($c$.clean($c$.track(CurrentState.$arrow().getGDM()).getRoot()
         == $c$.track(PrevState.$arrow().getGDM()).getRoot())) {
        return null;
      }
      {

        // If an assumption was made on a branch, it should be caught
        // here by looking at the state transition.
        Optional<BlockEdge> BE = progPoint.getAs(BlockEdge.class);
        if (BE.$bool()) {
          /*const*/ CFGBlock /*P*/ srcBlk = BE.$arrow().getSrc();
          {
            /*const*/ Stmt /*P*/ term = srcBlk.getTerminator$Const().$Stmt$C$P();
            if ((term != null)) {
              return VisitTerminator(term, N, srcBlk, BE.$arrow().getDst(), BR, BRC);
            }
          }
          return null;
        }
      }
      {

        Optional<org.clang.analysis.PostStmt> PS = progPoint.getAs(org.clang.analysis.PostStmt.class);
        if (PS.$bool()) {
          // FIXME: Assuming that BugReporter is a GRBugReporter is a layering
          // violation.
          final /*const*/std.pairPtrPtr</*const*/ ProgramPointTag /*P*/ , /*const*/ ProgramPointTag /*P*/ > /*&*/ tags = cast_GRBugReporter(BRC.getBugReporter()).
              getEngine().geteagerlyAssumeBinOpBifurcationTags();

          /*const*/ ProgramPointTag /*P*/ tag = PS.$arrow().getTag();
          if (tag == tags.first) {
            return VisitTrueTest(cast_Expr(PS.$arrow().getStmt()), true, 
                BRC, BR, N);
          }
          if (tag == tags.second) {
            return VisitTrueTest(cast_Expr(PS.$arrow().getStmt()), false, 
                BRC, BR, N);
          }

          return null;
        }
      }

      return null;
    } finally {
     if (PrevState != null) { PrevState.$destroy(); }
     if (CurrentState != null) { CurrentState.$destroy(); }
      $c$.$destroy();
    } 
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::VisitTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1265,
   FQN="clang::ento::ConditionBRVisitor::VisitTerminator", NM="_ZN5clang4ento18ConditionBRVisitor15VisitTerminatorEPKNS_4StmtEPKNS0_12ExplodedNodeEPKNS_8CFGBlockESA_RNS0_9BugReportERNS0_18BugReporterContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor15VisitTerminatorEPKNS_4StmtEPKNS0_12ExplodedNodeEPKNS_8CFGBlockESA_RNS0_9BugReportERNS0_18BugReporterContextE")
  //</editor-fold>
  public PathDiagnosticPiece /*P*/ VisitTerminator(/*const*/ Stmt /*P*/ Term, 
                 /*const*/ ExplodedNode /*P*/ N, 
                 /*const*/ CFGBlock /*P*/ srcBlk, 
                 /*const*/ CFGBlock /*P*/ dstBlk, 
                 final BugReport /*&*/ R, 
                 final BugReporterContext /*&*/ BRC) {
    /*const*/ Expr /*P*/ Cond = null;
    switch (Term.getStmtClass()) {
     default:
      return null;
     case IfStmtClass:
      Cond = cast_IfStmt(Term).getCond$Const();
      break;
     case ConditionalOperatorClass:
      Cond = cast_ConditionalOperator(Term).getCond();
      break;
    }
    assert Native.$bool(Cond);
    assert (srcBlk.succ_size() == 2);
    /*const*/boolean tookTrue = (srcBlk.succ_begin$Const()).$star().$CFGBlock$P() == dstBlk;
    return VisitTrueTest(Cond, tookTrue, BRC, R, N);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::VisitTrueTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1291,
   FQN="clang::ento::ConditionBRVisitor::VisitTrueTest", NM="_ZN5clang4ento18ConditionBRVisitor13VisitTrueTestEPKNS_4ExprEbRNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor13VisitTrueTestEPKNS_4ExprEbRNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public PathDiagnosticPiece /*P*/ VisitTrueTest(/*const*/ Expr /*P*/ Cond, 
               boolean tookTrue, 
               final BugReporterContext /*&*/ BRC, 
               final BugReport /*&*/ R, 
               /*const*/ ExplodedNode /*P*/ N) {
    
    /*const*/ Expr /*P*/ Ex = Cond;
    while (true) {
      Ex = Ex.IgnoreParenCasts$Const();
      switch (Ex.getStmtClass()) {
       default:
        return null;
       case BinaryOperatorClass:
        return VisitTrueTest(Cond, cast_BinaryOperator(Ex), tookTrue, BRC, 
            R, N);
       case DeclRefExprClass:
        return VisitTrueTest(Cond, cast_DeclRefExpr(Ex), tookTrue, BRC, 
            R, N);
       case UnaryOperatorClass:
        {
          /*const*/ UnaryOperator /*P*/ UO = cast_UnaryOperator(Ex);
          if (UO.getOpcode() == UnaryOperatorKind.UO_LNot) {
            tookTrue = !tookTrue;
            Ex = UO.getSubExpr();
            continue;
          }
          return null;
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::VisitTrueTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1509,
   FQN="clang::ento::ConditionBRVisitor::VisitTrueTest", NM="_ZN5clang4ento18ConditionBRVisitor13VisitTrueTestEPKNS_4ExprEPKNS_11DeclRefExprEbRNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor13VisitTrueTestEPKNS_4ExprEPKNS_11DeclRefExprEbRNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public PathDiagnosticPiece /*P*/ VisitTrueTest(/*const*/ Expr /*P*/ Cond, 
               /*const*/ DeclRefExpr /*P*/ DR, 
               /*const*/boolean tookTrue, 
               final BugReporterContext /*&*/ BRC, 
               final BugReport /*&*/ report, 
               /*const*/ ExplodedNode /*P*/ N) {
    raw_svector_ostream Out = null;
    try {
      
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
      if (!(VD != null)) {
        return null;
      }
      
      SmallString/*<256>*/ Buf/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(Buf);
      
      $out_raw_ostream_DeclarationName(Out.$out(/*KEEP_STR*/"Assuming '"), VD.getDeclName()).$out(/*KEEP_STR*/"' is ");
      
      QualType VDTy = VD.getType();
      if (VDTy.$arrow().isPointerType()) {
        Out.$out((tookTrue ? $("non-null") : $("null")));
      } else if (VDTy.$arrow().isObjCObjectPointerType()) {
        Out.$out((tookTrue ? $("non-nil") : $("nil")));
      } else if (VDTy.$arrow().isScalarType()) {
        Out.$out((tookTrue ? $("not equal to 0") : $0));
      } else {
        return null;
      }
      
      /*const*/ LocationContext /*P*/ LCtx = N.getLocationContext();
      PathDiagnosticLocation Loc/*J*/= new PathDiagnosticLocation(Cond, BRC.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LCtx));
      PathDiagnosticEventPiece /*P*/ event = new PathDiagnosticEventPiece(Loc, Out.str());
      
      /*const*/ ProgramState /*P*/ state = N.getState().get();
      {
        /*const*/ MemRegion /*P*/ R = state.getLValue(VD, LCtx).getAsRegion();
        if ((R != null)) {
          if (report.isInteresting(R)) {
            event.setPrunable(false);
          } else {
            SVal V = state.getSVal(R);
            if (report.isInteresting(new SVal(V))) {
              event.setPrunable(false);
            }
          }
        }
      }
      return event;
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::VisitTrueTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1378,
   FQN="clang::ento::ConditionBRVisitor::VisitTrueTest", NM="_ZN5clang4ento18ConditionBRVisitor13VisitTrueTestEPKNS_4ExprEPKNS_14BinaryOperatorEbRNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor13VisitTrueTestEPKNS_4ExprEPKNS_14BinaryOperatorEbRNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public PathDiagnosticPiece /*P*/ VisitTrueTest(/*const*/ Expr /*P*/ Cond, 
               /*const*/ BinaryOperator /*P*/ BExpr, 
               /*const*/boolean tookTrue, 
               final BugReporterContext /*&*/ BRC, 
               final BugReport /*&*/ R, 
               /*const*/ ExplodedNode /*P*/ N) {
    raw_svector_ostream Out = null;
    try {
      
      boolean shouldInvert = false;
      OptionalBool shouldPrune/*J*/= new OptionalBool();
      
      SmallString/*<128>*/ LhsString/*J*/= new SmallString/*<128>*/(128);
      SmallString/*<128>*/ RhsString/*J*/= new SmallString/*<128>*/(128);
      {
        raw_svector_ostream OutLHS = null;
        raw_svector_ostream OutRHS = null;
        try {
          OutLHS/*J*/= new raw_svector_ostream(LhsString);
          OutRHS/*J*/= new raw_svector_ostream(RhsString);
          /*const*/boolean isVarLHS = patternMatch(BExpr.getLHS(), OutLHS, BRC, R, N, 
              shouldPrune);
          /*const*/boolean isVarRHS = patternMatch(BExpr.getRHS(), OutRHS, BRC, R, N, 
              shouldPrune);
          
          shouldInvert = !isVarLHS && isVarRHS;
        } finally {
          if (OutRHS != null) { OutRHS.$destroy(); }
          if (OutLHS != null) { OutLHS.$destroy(); }
        }
      }
      
      BinaryOperatorKind Op = BExpr.getOpcode();
      if (BinaryOperator.isAssignmentOp(Op)) {
        // For assignment operators, all that we care about is that the LHS
        // evaluates to "true" or "false".
        return VisitConditionVariable(LhsString.$StringRef(), BExpr.getLHS(), tookTrue, 
            BRC, R, N);
      }
      
      // For non-assignment operations, we require that we can understand
      // both the LHS and RHS.
      if (LhsString.empty() || RhsString.empty()
         || !BinaryOperator.isComparisonOp(Op)) {
        return null;
      }
      
      // Should we invert the strings if the LHS is not a variable name?
      SmallString/*<256>*/ buf/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(buf);
      Out.$out(/*KEEP_STR*/"Assuming ").$out((shouldInvert ? RhsString : LhsString)).$out(/*KEEP_STR*/" is ");
      
      // Do we need to invert the opcode?
      if (shouldInvert) {
        switch (Op) {
         default:
          break;
         case BO_LT:
          Op = BinaryOperatorKind.BO_GT;
          break;
         case BO_GT:
          Op = BinaryOperatorKind.BO_LT;
          break;
         case BO_LE:
          Op = BinaryOperatorKind.BO_GE;
          break;
         case BO_GE:
          Op = BinaryOperatorKind.BO_LE;
          break;
        }
      }
      if (!tookTrue) {
        switch (Op) {
         case BO_EQ:
          Op = BinaryOperatorKind.BO_NE;
          break;
         case BO_NE:
          Op = BinaryOperatorKind.BO_EQ;
          break;
         case BO_LT:
          Op = BinaryOperatorKind.BO_GE;
          break;
         case BO_GT:
          Op = BinaryOperatorKind.BO_LE;
          break;
         case BO_LE:
          Op = BinaryOperatorKind.BO_GT;
          break;
         case BO_GE:
          Op = BinaryOperatorKind.BO_LT;
          break;
         default:
          return null;
        }
      }
      switch (Op) {
       case BO_EQ:
        Out.$out(/*KEEP_STR*/"equal to ");
        break;
       case BO_NE:
        Out.$out(/*KEEP_STR*/"not equal to ");
        break;
       default:
        Out.$out(BinaryOperator.getOpcodeStr(Op)).$out_char($$SPACE);
        break;
      }
      
      Out.$out((shouldInvert ? LhsString : RhsString));
      /*const*/ LocationContext /*P*/ LCtx = N.getLocationContext();
      PathDiagnosticLocation Loc/*J*/= new PathDiagnosticLocation(Cond, BRC.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LCtx));
      PathDiagnosticEventPiece /*P*/ event = new PathDiagnosticEventPiece(Loc, Out.str());
      if (shouldPrune.hasValue()) {
        event.setPrunable(shouldPrune.getValue());
      }
      return event;
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::VisitConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1464,
   FQN="clang::ento::ConditionBRVisitor::VisitConditionVariable", NM="_ZN5clang4ento18ConditionBRVisitor22VisitConditionVariableEN4llvm9StringRefEPKNS_4ExprEbRNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor22VisitConditionVariableEN4llvm9StringRefEPKNS_4ExprEbRNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public PathDiagnosticPiece /*P*/ VisitConditionVariable(StringRef LhsString, 
                        /*const*/ Expr /*P*/ CondVarExpr, 
                        /*const*/boolean tookTrue, 
                        final BugReporterContext /*&*/ BRC, 
                        final BugReport /*&*/ report, 
                        /*const*/ ExplodedNode /*P*/ N) {
    raw_svector_ostream Out = null;
    try {
      // FIXME: If there's already a constraint tracker for this variable,
      // we shouldn't emit anything here (c.f. the double note in
      // test/Analysis/inlining/path-notes.c)
      SmallString/*<256>*/ buf/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(buf);
      Out.$out(/*KEEP_STR*/"Assuming ").$out(/*NO_COPY*/LhsString).$out(/*KEEP_STR*/" is ");
      
      QualType Ty = CondVarExpr.getType();
      if (Ty.$arrow().isPointerType()) {
        Out.$out((tookTrue ? $("not null") : $("null")));
      } else if (Ty.$arrow().isObjCObjectPointerType()) {
        Out.$out((tookTrue ? $("not nil") : $("nil")));
      } else if (Ty.$arrow().isBooleanType()) {
        Out.$out((tookTrue ? $true : $false));
      } else if (Ty.$arrow().isIntegralOrEnumerationType()) {
        Out.$out((tookTrue ? $("non-zero") : $("zero")));
      } else {
        return null;
      }
      
      /*const*/ LocationContext /*P*/ LCtx = N.getLocationContext();
      PathDiagnosticLocation Loc/*J*/= new PathDiagnosticLocation(CondVarExpr, BRC.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LCtx));
      PathDiagnosticEventPiece /*P*/ event = new PathDiagnosticEventPiece(Loc, Out.str());
      {
        
        /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(CondVarExpr);
        if ((DR != null)) {
          {
            /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
            if ((VD != null)) {
              /*const*/ ProgramState /*P*/ state = N.getState().get();
              {
                /*const*/ MemRegion /*P*/ R = state.getLValue(VD, LCtx).getAsRegion();
                if ((R != null)) {
                  if (report.isInteresting(R)) {
                    event.setPrunable(false);
                  }
                }
              }
            }
          }
        }
      }
      
      return event;
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::patternMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1324,
   FQN="clang::ento::ConditionBRVisitor::patternMatch", NM="_ZN5clang4ento18ConditionBRVisitor12patternMatchEPKNS_4ExprERN4llvm11raw_ostreamERNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeERNS5_8OptionalIbEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18ConditionBRVisitor12patternMatchEPKNS_4ExprERN4llvm11raw_ostreamERNS0_18BugReporterContextERNS0_9BugReportEPKNS0_12ExplodedNodeERNS5_8OptionalIbEE")
  //</editor-fold>
  public boolean patternMatch(/*const*/ Expr /*P*/ Ex, final raw_ostream /*&*/ Out, 
              final BugReporterContext /*&*/ BRC, 
              final BugReport /*&*/ report, 
              /*const*/ ExplodedNode /*P*/ N, 
              final OptionalBool/*&*/ prunable) {
    /*const*/ Expr /*P*/ OriginalExpr = Ex;
    Ex = Ex.IgnoreParenCasts$Const();
    {
      
      /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(Ex);
      if ((DR != null)) {
        /*const*/boolean quotes = isa_VarDecl(DR.getDecl$Const());
        if (quotes) {
          Out.$out_char($$SGL_QUOTE);
          /*const*/ LocationContext /*P*/ LCtx = N.getLocationContext();
          /*const*/ ProgramState /*P*/ state = N.getState().get();
          {
            /*const*/ MemRegion /*P*/ R = state.getLValue(cast_VarDecl(DR.getDecl$Const()), 
                LCtx).getAsRegion();
            if ((R != null)) {
              if (report.isInteresting(R)) {
                prunable.$assign_T$RR(/*KEEP_BOOL*/false);
              } else {
                /*const*/ ProgramState /*P*/ state$1 = N.getState().get();
                SVal V = state$1.getSVal(R);
                if (report.isInteresting(new SVal(V))) {
                  prunable.$assign_T$RR(/*KEEP_BOOL*/false);
                }
              }
            }
          }
        }
        Out.$out(DR.getDecl$Const().getDeclName().getAsString());
        if (quotes) {
          Out.$out_char($$SGL_QUOTE);
        }
        return quotes;
      }
    }
    {
      
      /*const*/ IntegerLiteral /*P*/ IL = dyn_cast_IntegerLiteral(Ex);
      if ((IL != null)) {
        QualType OriginalTy = OriginalExpr.getType();
        if (OriginalTy.$arrow().isPointerType()) {
          if (IL.getValue().$eq($int2ulong(0))) {
            Out.$out(/*KEEP_STR*/"null");
            return false;
          }
        } else if (OriginalTy.$arrow().isObjCObjectPointerType()) {
          if (IL.getValue().$eq($int2ulong(0))) {
            Out.$out(/*KEEP_STR*/"nil");
            return false;
          }
        }
        
        $out_raw_ostream_APInt$C(Out, IL.getValue());
        return false;
      }
    }
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::~ConditionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 186,
   FQN="clang::ento::ConditionBRVisitor::~ConditionBRVisitor", NM="_ZN5clang4ento18ConditionBRVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18ConditionBRVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::ConditionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 186,
   FQN="clang::ento::ConditionBRVisitor::ConditionBRVisitor", NM="_ZN5clang4ento18ConditionBRVisitorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18ConditionBRVisitorC1Ev")
  //</editor-fold>
  public /*inline*/ ConditionBRVisitor() {
    // : BugReporterVisitorImpl<ConditionBRVisitor>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionBRVisitor::ConditionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 186,
   FQN="clang::ento::ConditionBRVisitor::ConditionBRVisitor", NM="_ZN5clang4ento18ConditionBRVisitorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18ConditionBRVisitorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ConditionBRVisitor(final /*const*/ ConditionBRVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<ConditionBRVisitor>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public ConditionBRVisitor clone() {
    return new ConditionBRVisitor(this);
  }
    

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
