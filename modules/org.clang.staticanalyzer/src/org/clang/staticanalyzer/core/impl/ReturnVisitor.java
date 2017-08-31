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

package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

/// Emits an extra note at the return statement of an interesting stack frame.
///
/// The returned value is marked as an interesting value, and if it's null,
/// adds a visitor to track where it became null.
///
/// This visitor is intended to be used when another visitor discovers that an
/// interesting value comes from an inlined function call.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 136,
 FQN="(anonymous namespace)::ReturnVisitor", NM="_ZN12_GLOBAL__N_113ReturnVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitorE")
//</editor-fold>
public class ReturnVisitor extends /*public*/ BugReporterVisitorImpl<ReturnVisitor> implements Destructors.ClassWithDestructor {
  private /*const*/ StackFrameContext /*P*/ StackFrame;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 138,
   FQN="(anonymous namespace)::ReturnVisitor::(anonymous)", NM="_ZN12_GLOBAL__N_113ReturnVisitorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitorE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.NativeUIntEnum {
    Initial(0),
    MaybeUnsuppress(Initial.getValue() + 1),
    Satisfied(MaybeUnsuppress.getValue() + 1);

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
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  private Unnamed_enum Mode;
  
  private boolean EnableNullFPSuppression;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::ReturnVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 147,
   FQN="(anonymous namespace)::ReturnVisitor::ReturnVisitor", NM="_ZN12_GLOBAL__N_113ReturnVisitorC1EPKN5clang17StackFrameContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitorC1EPKN5clang17StackFrameContextEb")
  //</editor-fold>
  public ReturnVisitor(/*const*/ StackFrameContext /*P*/ Frame, boolean Suppressed) {
    // : BugReporterVisitorImpl<ReturnVisitor>(), StackFrame(Frame), Mode(Initial), EnableNullFPSuppression(Suppressed) 
    //START JInit
    super();
    this.StackFrame = Frame;
    this.Mode = Unnamed_enum.Initial;
    this.EnableNullFPSuppression = Suppressed;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 150,
   FQN="(anonymous namespace)::ReturnVisitor::getTag", NM="_ZN12_GLOBAL__N_113ReturnVisitor6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitor6getTagEv")
  //</editor-fold>
  public static Object/*void P*/ getTag() {
    final/*static*/ Object Tag = getTag$$.Tag;
    return (reinterpret_cast(/*static_cast*/Object/*void P*/ .class, ($AddrOf(Tag))));
  }
  private static final class getTag$$ {
    static final/*static*/ Object Tag = ReturnVisitor.class;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 155,
   FQN="(anonymous namespace)::ReturnVisitor::Profile", NM="_ZNK12_GLOBAL__N_113ReturnVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZNK12_GLOBAL__N_113ReturnVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ID.AddPointer(ReturnVisitor.getTag());
    ID.AddPointer(StackFrame);
    ID.AddBoolean(EnableNullFPSuppression);
  }

  
  /// Adds a ReturnVisitor if the given statement represents a call that was
  /// inlined.
  ///
  /// This will search back through the ExplodedGraph, starting from the given
  /// node, looking for when the given statement was processed. If it turns out
  /// the statement is a call that was inlined, we add the visitor to the
  /// bug report, so it can print a note later.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::addVisitorIfNecessary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 168,
   FQN="(anonymous namespace)::ReturnVisitor::addVisitorIfNecessary", NM="_ZN12_GLOBAL__N_113ReturnVisitor21addVisitorIfNecessaryEPKN5clang4ento12ExplodedNodeEPKNS1_4StmtERNS2_9BugReportEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitor21addVisitorIfNecessaryEPKN5clang4ento12ExplodedNodeEPKNS1_4StmtERNS2_9BugReportEb")
  //</editor-fold>
  public static void addVisitorIfNecessary(/*const*/ ExplodedNode /*P*/ Node, /*const*/ Stmt /*P*/ S, 
                       final BugReport /*&*/ BR, 
                       boolean InEnableNullFPSuppression) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!CallEvent.isCallStmt(S)) {
        return;
      }
      
      // First, find when we processed the statement.
      do {
        {
          Optional<CallExitEnd> CEE = Node.<CallExitEnd>getLocationAs(CallExitEnd.class);
          if (CEE.$bool()) {
            if (CEE.$arrow().getCalleeContext().getCallSite() == S) {
              break;
            }
          }
        }
        {
          Optional<StmtPoint> SP = Node.<StmtPoint>getLocationAs(StmtPoint.class);
          if (SP.$bool()) {
            if (SP.$arrow().getStmt() == S) {
              break;
            }
          }
        }
        
        Node = Node.getFirstPred$Const();
      } while ((Node != null));
      
      // Next, step over any post-statement checks.
      while ((Node != null) && Node.getLocation().getAs(org.clang.analysis.PostStmt.class).$bool()) {
        Node = Node.getFirstPred$Const();
      }
      if (!(Node != null)) {
        return;
      }
      
      // Finally, see if we inlined the call.
      Optional<CallExitEnd> CEE = Node.<CallExitEnd>getLocationAs(CallExitEnd.class);
      if (!CEE.$bool()) {
        return;
      }
      
      /*const*/ StackFrameContext /*P*/ CalleeContext = CEE.$arrow().getCalleeContext();
      if (CalleeContext.getCallSite() != S) {
        return;
      }
      
      // Check the return value.
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Node.getState());
      SVal RetVal = State.$arrow().getSVal(S, Node.getLocationContext());
      
      // Handle cases where a reference is returned and then immediately used.
      if (cast_Expr(S).isGLValue()) {
        {
          Optional<Loc> LValue = RetVal.getAs(Loc.class);
          if (LValue.$bool()) {
            RetVal.$assignMove(State.$arrow().getSVal(new Loc(LValue.$star())));
          }
        }
      }
      
      // See if the return value is NULL. If so, suppress the report.
      SubEngine /*P*/ Eng = State.$arrow().getStateManager().getOwningEngine();
      assert ((Eng != null)) : "Cannot file a bug report without an owning engine";
      final AnalyzerOptions /*&*/ Options = Eng.getAnalysisManager().options;
      
      boolean EnableNullFPSuppression = false;
      if (InEnableNullFPSuppression && Options.shouldSuppressNullReturnPaths()) {
        {
          Optional<Loc> RetLoc = RetVal.getAs(Loc.class);
          if (RetLoc.$bool()) {
            $c$.clean(EnableNullFPSuppression = $c$.track(State.$arrow().isNull(new SVal(RetLoc.$star()))).isConstrainedTrue());
          }
        }
      }
      
      BR.markInteresting(CalleeContext);
      BR.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ReturnVisitor(CalleeContext, 
                  EnableNullFPSuppression)))))); $c$.clean();
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Returns true if any counter-suppression heuristics are enabled for
  /// ReturnVisitor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::hasCounterSuppression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 227,
   FQN="(anonymous namespace)::ReturnVisitor::hasCounterSuppression", NM="_ZN12_GLOBAL__N_113ReturnVisitor21hasCounterSuppressionERN5clang15AnalyzerOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitor21hasCounterSuppressionERN5clang15AnalyzerOptionsE")
  //</editor-fold>
  public static boolean hasCounterSuppression(final AnalyzerOptions /*&*/ Options) {
    return Options.shouldAvoidSuppressingNullArgumentPaths();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::visitNodeInitial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 231,
   FQN="(anonymous namespace)::ReturnVisitor::visitNodeInitial", NM="_ZN12_GLOBAL__N_113ReturnVisitor16visitNodeInitialEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitor16visitNodeInitialEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE")
  //</editor-fold>
  public PathDiagnosticPiece /*P*/ visitNodeInitial(/*const*/ ExplodedNode /*P*/ N, 
                  /*const*/ ExplodedNode /*P*/ PrevN, 
                  final BugReporterContext /*&*/ BRC, 
                  final BugReport /*&*/ BR) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    raw_svector_ostream Out = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Only print a message at the interesting return statement.
      if (N.getLocationContext() != StackFrame) {
        return null;
      }
      
      Optional<StmtPoint> SP = N.<StmtPoint>getLocationAs(StmtPoint.class);
      if (!SP.$bool()) {
        return null;
      }
      
      /*const*/ ReturnStmt /*P*/ Ret = dyn_cast_ReturnStmt(SP.$arrow().getStmt());
      if (!(Ret != null)) {
        return null;
      }
      
      // Okay, we're at the right return statement, but do we have the return
      // value available?
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      SVal V = State.$arrow().getSVal(Ret, StackFrame);
      if (V.isUnknownOrUndef$SVal()) {
        return null;
      }
      
      // Don't print any more notes after this one.
      Mode = Unnamed_enum.Satisfied;
      
      /*const*/ Expr /*P*/ RetE = Ret.getRetValue$Const();
      assert ((RetE != null)) : "Tracking a return value for a void function";
      
      // Handle cases where a reference is returned and then immediately used.
      Optional<Loc> LValue/*J*/= new Optional<Loc>();
      if (RetE.isGLValue()) {
        if ((LValue.$assignMove(V.getAs(Loc.class))).$bool()) {
          SVal RValue = State.$arrow().getRawSVal(new Loc(LValue.$star()), RetE.getType());
          if (RValue.getAs(DefinedSVal.class).$bool()) {
            V.$assign(RValue);
          }
        }
      }
      
      // Ignore aggregate rvalues.
      if (V.getAs(NsNonloc.LazyCompoundVal.class).$bool()
         || V.getAs(NsNonloc.CompoundVal.class).$bool()) {
        return null;
      }
      
      RetE = RetE.IgnoreParenCasts$Const();
      
      // If we can't prove the return value is 0, just mark it interesting, and
      // make sure to track it into any further inner functions.
      if ($c$.clean(!$c$.track(State.$arrow().isNull(new SVal(V))).isConstrainedTrue())) {
        BR.markInteresting(new SVal(V));
        ReturnVisitor.addVisitorIfNecessary(N, RetE, BR, 
            EnableNullFPSuppression);
        return null;
      }
      
      // If we're returning 0, we should track where that 0 came from.
      NsBugreporter.trackNullOrUndefValue(N, RetE, BR, /*IsArg*/ false, 
          EnableNullFPSuppression);
      
      // Build an appropriate message based on the return value.
      SmallString/*<64>*/ Msg/*J*/= new SmallString/*<64>*/(64);
      Out/*J*/= new raw_svector_ostream(Msg);
      if (V.getAs(Loc.class).$bool()) {
        // If we have counter-suppression enabled, make sure we keep visiting
        // future nodes. We want to emit a path note as well, in case
        // the report is resurrected as valid later on.
        final ExprEngine /*&*/ Eng = BRC.getBugReporter().getEngine();
        final AnalyzerOptions /*&*/ Options = Eng.getAnalysisManager().options;
        if (EnableNullFPSuppression && ReturnVisitor.hasCounterSuppression(Options)) {
          Mode = Unnamed_enum.MaybeUnsuppress;
        }
        if (RetE.getType().$arrow().isObjCObjectPointerType()) {
          Out.$out(/*KEEP_STR*/"Returning nil");
        } else {
          Out.$out(/*KEEP_STR*/"Returning null pointer");
        }
      } else {
        Out.$out(/*KEEP_STR*/"Returning zero");
      }
      if (LValue.$bool()) {
        {
          /*const*/ MemRegion /*P*/ MR = LValue.$arrow().getAsRegion();
          if ((MR != null)) {
            if (MR.canPrintPretty()) {
              Out.$out(/*KEEP_STR*/" (reference to ");
              MR.printPretty(Out);
              Out.$out(/*KEEP_STR*/$RPAREN);
            }
          }
        }
      } else {
        {
          // FIXME: We should have a more generalized location printing mechanism.
          /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(RetE);
          if ((DR != null)) {
            {
              /*const*/ DeclaratorDecl /*P*/ DD = dyn_cast_DeclaratorDecl(DR.getDecl$Const());
              if ((DD != null)) {
                $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/" (loaded from '"), $Deref(DD)).$out(/*KEEP_STR*/"')");
              }
            }
          }
        }
      }
      
      PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation(Ret, BRC.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, StackFrame));
      if (!L.isValid() || !L.asLocation().isValid()) {
        return null;
      }
      
      return new PathDiagnosticEventPiece(L, Out.str());
    } finally {
      if (Out != null) { Out.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::visitNodeMaybeUnsuppress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 333,
   FQN="(anonymous namespace)::ReturnVisitor::visitNodeMaybeUnsuppress", NM="_ZN12_GLOBAL__N_113ReturnVisitor24visitNodeMaybeUnsuppressEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitor24visitNodeMaybeUnsuppressEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE")
  //</editor-fold>
  public PathDiagnosticPiece /*P*/ visitNodeMaybeUnsuppress(/*const*/ ExplodedNode /*P*/ N, 
                          /*const*/ ExplodedNode /*P*/ PrevN, 
                          final BugReporterContext /*&*/ BRC, 
                          final BugReport /*&*/ BR) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    CallEventRef<CallEvent> Call = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final ExprEngine /*&*/ Eng = BRC.getBugReporter().getEngine();
      final AnalyzerOptions /*&*/ Options = Eng.getAnalysisManager().options;
      assert (ReturnVisitor.hasCounterSuppression(Options));
      
      // Are we at the entry node for this call?
      Optional<CallEnter> CE = N.<CallEnter>getLocationAs(CallEnter.class);
      if (!CE.$bool()) {
        return null;
      }
      if (CE.$arrow().getCalleeContext() != StackFrame) {
        return null;
      }
      
      Mode = Unnamed_enum.Satisfied;
      
      // Don't automatically suppress a report if one of the arguments is
      // known to be a null pointer. Instead, start tracking /that/ null
      // value back to its origin.
      final ProgramStateManager /*&*/ StateMgr = BRC.getStateManager();
      final CallEventManager /*&*/ CallMgr = StateMgr.getCallEventManager();
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      Call = $c$.clean(CallMgr.getCaller(StackFrame, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      for (/*uint*/int I = 0, E = Call.$arrow().getNumArgs(); I != E; ++I) {
        Optional<Loc> ArgV = Call.$arrow().getArgSVal(I).getAs(Loc.class);
        if (!ArgV.$bool()) {
          continue;
        }
        
        /*const*/ Expr /*P*/ ArgE = Call.$arrow().getArgExpr(I);
        if (!(ArgE != null)) {
          continue;
        }
        
        // Is it possible for this argument to be non-null?
        if ($c$.clean(!$c$.track(State.$arrow().isNull(new SVal(ArgV.$star()))).isConstrainedTrue())) {
          continue;
        }
        if (NsBugreporter.trackNullOrUndefValue(N, ArgE, BR, /*IsArg=*/ true, 
            EnableNullFPSuppression)) {
          BR.removeInvalidation(ReturnVisitor.getTag(), StackFrame);
        }
        // If we /can't/ track the null pointer, we should err on the side of
        // false negatives, and continue towards marking this report invalid.
        // (We will still look at the other arguments, though.)
      }
      
      return null;
    } finally {
      if (Call != null) { Call.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::VisitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 386,
   FQN="(anonymous namespace)::ReturnVisitor::VisitNode", NM="_ZN12_GLOBAL__N_113ReturnVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
           /*const*/ ExplodedNode /*P*/ PrevN, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    switch (Mode) {
     case Initial:
      return visitNodeInitial(N, PrevN, BRC, BR);
     case MaybeUnsuppress:
      return visitNodeMaybeUnsuppress(N, PrevN, BRC, BR);
     case Satisfied:
      return null;
    }
    throw new llvm_unreachable("Invalid visit mode!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::getEndPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 402,
   FQN="(anonymous namespace)::ReturnVisitor::getEndPath", NM="_ZN12_GLOBAL__N_113ReturnVisitor10getEndPathERN5clang4ento18BugReporterContextEPKNS2_12ExplodedNodeERNS2_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitor10getEndPathERN5clang4ento18BugReporterContextEPKNS2_12ExplodedNodeERNS2_9BugReportE")
  //</editor-fold>
  @Override public std.unique_ptr<PathDiagnosticPiece> getEndPath(final BugReporterContext /*&*/ BRC, 
            /*const*/ ExplodedNode /*P*/ N, 
            final BugReport /*&*/ BR)/* override*/ {
    if (EnableNullFPSuppression) {
      BR.markInvalid(ReturnVisitor.getTag(), StackFrame);
    }
    return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::~ReturnVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 136,
   FQN="(anonymous namespace)::ReturnVisitor::~ReturnVisitor", NM="_ZN12_GLOBAL__N_113ReturnVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnVisitor::ReturnVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 136,
   FQN="(anonymous namespace)::ReturnVisitor::ReturnVisitor", NM="_ZN12_GLOBAL__N_113ReturnVisitorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN12_GLOBAL__N_113ReturnVisitorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ReturnVisitor(final /*const*/ ReturnVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<ReturnVisitor>(), StackFrame(.StackFrame), Mode(.Mode), EnableNullFPSuppression(.EnableNullFPSuppression) 
    //START JInit
    super($Prm0);
    this.StackFrame = $Prm0.StackFrame;
    this.Mode = $Prm0.Mode;
    this.EnableNullFPSuppression = $Prm0.EnableNullFPSuppression;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public ReturnVisitor clone() {
    return new ReturnVisitor(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "StackFrame=" + "[StackFrameContext]" // NOI18N
              + ", Mode=" + Mode // NOI18N
              + ", EnableNullFPSuppression=" + EnableNullFPSuppression // NOI18N
              + super.toString(); // NOI18N
  }
}
