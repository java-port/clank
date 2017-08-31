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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type NsBugreporter">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.bugreporter.ento.NsBugreporter",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento11bugreporter12GetDenomExprEPKNS0_12ExplodedNodeE;_ZN5clang4ento11bugreporter12getDerefExprEPKNS_4StmtE;_ZN5clang4ento11bugreporter13GetRetValExprEPKNS0_12ExplodedNodeE;_ZN5clang4ento11bugreporter21trackNullOrUndefValueEPKNS0_12ExplodedNodeEPKNS_4StmtERNS0_9BugReportEbb;_ZN5clang4ento11bugreporter24isDeclRefExprToReferenceEPKNS_4ExprE; -static-type=NsBugreporter -package=org.clang.staticanalyzer.core.bugreporter.ento")
//</editor-fold>
public final class NsBugreporter {


/// Attempts to add visitors to trace a null or undefined value back to its
/// point of origin, whether it is a symbol constrained to null or an explicit
/// assignment.
///
/// \param N A node "downstream" from the evaluation of the statement.
/// \param S The statement whose value is null or undefined.
/// \param R The bug report to which visitors should be attached.
/// \param IsArg Whether the statement is an argument to an inlined function.
///              If this is the case, \p N \em must be the CallEnter node for
///              the function.
/// \param EnableNullFPSuppression Whether we should employ false positive
///         suppression (inlined defensive checks, returned null).
///
/// \return Whether or not the function was able to add visitors for this
///         statement. Note that returning \c true does not actually imply
///         that any visitors were added.
//<editor-fold defaultstate="collapsed" desc="clang::ento::bugreporter::trackNullOrUndefValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 949,
 FQN="clang::ento::bugreporter::trackNullOrUndefValue", NM="_ZN5clang4ento11bugreporter21trackNullOrUndefValueEPKNS0_12ExplodedNodeEPKNS_4StmtERNS0_9BugReportEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento11bugreporter21trackNullOrUndefValueEPKNS0_12ExplodedNodeEPKNS_4StmtERNS0_9BugReportEbb")
//</editor-fold>
public static boolean trackNullOrUndefValue(/*const*/ ExplodedNode /*P*/ N, 
                     /*const*/ Stmt /*P*/ S, 
                     final BugReport /*&*/ report) {
  return trackNullOrUndefValue(N, 
                     S, 
                     report, false, 
                     true);
}
public static boolean trackNullOrUndefValue(/*const*/ ExplodedNode /*P*/ N, 
                     /*const*/ Stmt /*P*/ S, 
                     final BugReport /*&*/ report, boolean IsArg/*= false*/) {
  return trackNullOrUndefValue(N, 
                     S, 
                     report, IsArg, 
                     true);
}
public static boolean trackNullOrUndefValue(/*const*/ ExplodedNode /*P*/ N, 
                     /*const*/ Stmt /*P*/ S, 
                     final BugReport /*&*/ report, boolean IsArg/*= false*/, 
                     boolean EnableNullFPSuppression/*= true*/) {
  IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
  try {
    if (!(S != null) || !(N != null)) {
      return false;
    }
    {

      /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(S);
      if ((Ex != null)) {
        Ex = Ex.IgnoreParenCasts$Const();
        /*const*/ Expr /*P*/ PeeledEx = BugReporterVisitorsStatics.peelOffOuterExpr(Ex, N);
        if (Ex != PeeledEx) {
          S = PeeledEx;
        }
      }
    }

    /*const*/ Expr /*P*/ Inner = null;
    {
      /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(S);
      if ((Ex != null)) {
        Ex = Ex.IgnoreParenCasts$Const();
        if (ExplodedGraph.isInterestingLValueExpr(Ex) || CallEvent.isCallStmt(Ex)) {
          Inner = Ex;
        }
      }
    }
    if (IsArg && !(Inner != null)) {
      assert (N.getLocation().getAs(CallEnter.class).$bool()) : "Tracking arg but not at call";
    } else {
      // Walk through nodes until we get one that matches the statement exactly.
      // Alternately, if we hit a known lvalue for the statement, we know we've
      // gone too far (though we can likely track the lvalue better anyway).
      do {
        final /*const*/ ProgramPoint /*&*/ pp = N.getLocation();
        {
          Optional<StmtPoint> ps = pp.getAs(StmtPoint.class);
          if (ps.$bool()) {
            if (ps.$arrow().getStmt() == S || ps.$arrow().getStmt() == Inner) {
              break;
            }
          } else {
            Optional<CallExitEnd> CEE = pp.getAs(CallExitEnd.class);
            if (CEE.$bool()) {
              if (CEE.$arrow().getCalleeContext().getCallSite() == S
                 || CEE.$arrow().getCalleeContext().getCallSite() == Inner) {
                break;
              }
            }
          }
        }
        N = N.getFirstPred$Const();
      } while ((N != null));
      if (!(N != null)) {
        return false;
      }
    }

    state = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
    {

      // The message send could be nil due to the receiver being nil.
      // At this point in the path, the receiver should be live since we are at the
      // message send expr. If it is nil, start tracking it.
      /*const*/ Expr /*P*/ Receiver = NilReceiverBRVisitor.getNilReceiver(S, N);
      if ((Receiver != null)) {
        trackNullOrUndefValue(N, Receiver, report, false, EnableNullFPSuppression);
      }
    }

    // See if the expression we're interested refers to a variable.
    // If so, we can track both its contents and constraints on its value.
    if ((Inner != null) && ExplodedGraph.isInterestingLValueExpr(Inner)) {
      IntrusiveRefCntPtr</*const*/ ProgramState> LVState = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ MemRegion /*P*/ R = null;

        // Find the ExplodedNode where the lvalue (the value of 'Ex')
        // was computed.  We need this for getting the location value.
        /*const*/ ExplodedNode /*P*/ LVNode = N;
        while ((LVNode != null)) {
          {
            Optional<org.clang.analysis.PostStmt> P = LVNode.getLocation().getAs(org.clang.analysis.PostStmt.class);
            if (P.$bool()) {
              if (P.$arrow().getStmt() == Inner) {
                break;
              }
            }
          }
          LVNode = LVNode.getFirstPred$Const();
        }
        assert ((LVNode != null)) : "Unable to find the lvalue node.";
        LVState = new IntrusiveRefCntPtr</*const*/ ProgramState>(LVNode.getState());
        SVal LVal = LVState.$arrow().getSVal(Inner, LVNode.getLocationContext());
        if ($c$.clean($c$.track(LVState.$arrow().isNull(new SVal(LVal))).isConstrainedTrue())) {
          {
            // In case of C++ references, we want to differentiate between a null
            // reference and reference to null pointer.
            // If the LVal is null, check if we are dealing with null reference.
            // For those, we want to track the location of the reference.
            /*const*/ MemRegion /*P*/ RR = BugReporterVisitorsStatics.getLocationRegionIfReference(Inner, N);
            if ((RR != null)) {
              R = RR;
            }
          }
        } else {
          R = LVState.$arrow().getSVal(Inner, LVNode.getLocationContext()).getAsRegion();
          {

            // If this is a C++ reference to a null pointer, we are tracking the
            // pointer. In additon, we should find the store at which the reference
            // got initialized.
            /*const*/ MemRegion /*P*/ RR = BugReporterVisitorsStatics.getLocationRegionIfReference(Inner, N);
            if ((RR != null)) {
              {
                Optional<KnownSVal> KV = LVal.getAs(KnownSVal.class);
                if (KV.$bool()) {
                  report.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FindLastStoreBRVisitor(KV.$star(), RR, EnableNullFPSuppression)))))); $c$.clean();
                }
              }
            }
          }
        }
        if ((R != null)) {
          // Mark both the variable region and its contents as interesting.
          SVal V = LVState.$arrow().getRawSVal(new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R)));

          report.markInteresting(R);
          report.markInteresting(new SVal(V));
          report.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new UndefOrNullArgVisitor(R)))))); $c$.clean();

          // If the contents are symbolic, find out when they became null.
          if ((V.getAsLocSymbol(/*IncludeBaseRegions*/ true) != null)) {
            report.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new TrackConstraintBRVisitor(V.castAs(DefinedSVal.class), false)))))); $c$.clean();
          }
          {

            // Add visitor, which will suppress inline defensive checks.
            Optional<DefinedSVal> DV = V.getAs(DefinedSVal.class);
            if (DV.$bool()) {
              if ($c$.clean(!DV.$arrow().isZeroConstant() && $c$.track(LVState.$arrow().isNull(new SVal(DV.$star()))).isConstrainedTrue()
                 && EnableNullFPSuppression)) {
                report.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new SuppressInlineDefensiveChecksVisitor(DV.$star(), 
                            LVNode)))))); $c$.clean();
              }
            }
          }
          {

            Optional<KnownSVal> KV = V.getAs(KnownSVal.class);
            if (KV.$bool()) {
              report.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FindLastStoreBRVisitor(KV.$star(), R, EnableNullFPSuppression)))))); $c$.clean();
            }
          }
          return true;
        }
      } finally {
        if (LVState != null) { LVState.$destroy(); }
        $c$.$destroy();
      }
    }

    // If the expression is not an "lvalue expression", we can still
    // track the constraints on its contents.
    SVal V = state.$arrow().getSValAsScalarOrLoc(S, N.getLocationContext());
    {

      // If the value came from an inlined function call, we should at least make
      // sure that function isn't pruned in our output.
      /*const*/ Expr /*P*/ E = dyn_cast_Expr(S);
      if ((E != null)) {
        S = E.IgnoreParenCasts$Const();
      }
    }

    ReturnVisitor.addVisitorIfNecessary(N, S, report, EnableNullFPSuppression);
    {

      // Uncomment this to find cases where we aren't properly getting the
      // base value that was dereferenced.
      // assert(!V.isUnknownOrUndef());
      // Is it a symbolic value?
      Optional<NsLoc.MemRegionVal> L = V.getAs(NsLoc.MemRegionVal.class);
      if (L.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // At this point we are dealing with the region's LValue.
          // However, if the rvalue is a symbolic region, we should track it as well.
          // Try to use the correct type when looking up the value.
          SVal RVal/*J*/= new SVal();
          {
            /*const*/ Expr /*P*/ E = dyn_cast_Expr(S);
            if ((E != null)) {
              RVal.$assignMove(state.$arrow().getRawSVal(new Loc(L.getValue()), E.getType()));
            } else {
              RVal.$assignMove(state.$arrow().getSVal(L.$arrow().getRegion()));
            }
          }

          /*const*/ MemRegion /*P*/ RegionRVal = RVal.getAsRegion();
          report.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new UndefOrNullArgVisitor(L.$arrow().getRegion())))))); $c$.clean();
          if ((RegionRVal != null) && isa_SymbolicRegion(RegionRVal)) {
            report.markInteresting(RegionRVal);
            report.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new TrackConstraintBRVisitor(new NsLoc.MemRegionVal(RegionRVal), false)))))); $c$.clean();
          }
        } finally {
          $c$.$destroy();
        }
      }
    }

    return true;
  } finally {
   if (state != null) { state.$destroy(); }
  } 
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::bugreporter::getDerefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 44,
 FQN="clang::ento::bugreporter::getDerefExpr", NM="_ZN5clang4ento11bugreporter12getDerefExprEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento11bugreporter12getDerefExprEPKNS_4StmtE")
//</editor-fold>
public static /*const*/ Expr /*P*/ getDerefExpr(/*const*/ Stmt /*P*/ S) {
  // Pattern match for a few useful cases:
  //   a[0], p->f, *p
  /*const*/ Expr /*P*/ E = dyn_cast_Expr(S);
  if (!(E != null)) {
    return null;
  }
  E = E.IgnoreParenCasts$Const();
  while (true) {
    {
      /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(E);
      if ((B != null)) {
        assert (B.isAssignmentOp());
        E = B.getLHS().IgnoreParenCasts();
        continue;
      } else {
        /*const*/ UnaryOperator /*P*/ U = dyn_cast_UnaryOperator(E);
        if ((U != null)) {
          if (U.getOpcode() == UnaryOperatorKind.UO_Deref) {
            return U.getSubExpr().IgnoreParenCasts();
          }
        } else {
          /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
          if ((ME != null)) {
            if (ME.isArrow() || isDeclRefExprToReference(ME.getBase())) {
              return ME.getBase().IgnoreParenCasts();
            } else {
              // If we have a member expr with a dot, the base must have been
              // dereferenced.
              return getDerefExpr(ME.getBase());
            }
          } else {
            /*const*/ ObjCIvarRefExpr /*P*/ IvarRef = dyn_cast_ObjCIvarRefExpr(E);
            if ((IvarRef != null)) {
              return IvarRef.getBase$Const().IgnoreParenCasts$Const();
            } else {
              /*const*/ ArraySubscriptExpr /*P*/ AE = dyn_cast_ArraySubscriptExpr(E);
              if ((AE != null)) {
                return AE.getBase$Const();
              } else if (isDeclRefExprToReference(E)) {
                return E;
              }
            }
          }
        }
      }
    }
    break;
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::bugreporter::GetDenomExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 86,
 FQN="clang::ento::bugreporter::GetDenomExpr", NM="_ZN5clang4ento11bugreporter12GetDenomExprEPKNS0_12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento11bugreporter12GetDenomExprEPKNS0_12ExplodedNodeE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ GetDenomExpr(/*const*/ ExplodedNode /*P*/ N) {
  /*const*/ Stmt /*P*/ S = N.<org.clang.analysis.PreStmt>getLocationAs(org.clang.analysis.PreStmt.class).$arrow().getStmt();
  {
    /*const*/ BinaryOperator /*P*/ BE = dyn_cast_BinaryOperator(S);
    if ((BE != null)) {
      return BE.getRHS();
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::bugreporter::GetRetValExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 93,
 FQN="clang::ento::bugreporter::GetRetValExpr", NM="_ZN5clang4ento11bugreporter13GetRetValExprEPKNS0_12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento11bugreporter13GetRetValExprEPKNS0_12ExplodedNodeE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ GetRetValExpr(/*const*/ ExplodedNode /*P*/ N) {
  /*const*/ Stmt /*P*/ S = N.<org.clang.analysis.PostStmt>getLocationAs(org.clang.analysis.PostStmt.class).$arrow().getStmt();
  {
    /*const*/ ReturnStmt /*P*/ RS = dyn_cast_ReturnStmt(S);
    if ((RS != null)) {
      return RS.getRetValue$Const();
    }
  }
  return null;
}


//===----------------------------------------------------------------------===//
// Utility functions.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::bugreporter::isDeclRefExprToReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 37,
 FQN="clang::ento::bugreporter::isDeclRefExprToReference", NM="_ZN5clang4ento11bugreporter24isDeclRefExprToReferenceEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento11bugreporter24isDeclRefExprToReferenceEPKNS_4ExprE")
//</editor-fold>
public static boolean isDeclRefExprToReference(/*const*/ Expr /*P*/ E) {
  {
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      return DRE.getDecl$Const().getType().$arrow().isReferenceType();
    }
  }
  return false;
}

} // END OF class NsBugreporter
