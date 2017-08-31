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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APSInt$C;


//<editor-fold defaultstate="collapsed" desc="clang::ento::FindLastStoreBRVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 99,
 FQN="clang::ento::FindLastStoreBRVisitor", NM="_ZN5clang4ento22FindLastStoreBRVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento22FindLastStoreBRVisitorE")
//</editor-fold>
public final class FindLastStoreBRVisitor extends /*public*/ BugReporterVisitorImpl<FindLastStoreBRVisitor> implements Destructors.ClassWithDestructor {
  private /*const*/ MemRegion /*P*/ R;
  private SVal V;
  private boolean Satisfied;
  
  /// If the visitor is tracking the value directly responsible for the
  /// bug, we are going to employ false positive suppression.
  private boolean EnableNullFPSuppression;
/*public:*/
  /// Creates a visitor for every VarDecl inside a Stmt and registers it with
  /// the BugReport.
  
  // Registers every VarDecl inside a Stmt with a last store visitor.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FindLastStoreBRVisitor::registerStatementVarDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1161,
   FQN="clang::ento::FindLastStoreBRVisitor::registerStatementVarDecls", NM="_ZN5clang4ento22FindLastStoreBRVisitor25registerStatementVarDeclsERNS0_9BugReportEPKNS_4StmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento22FindLastStoreBRVisitor25registerStatementVarDeclsERNS0_9BugReportEPKNS_4StmtEb")
  //</editor-fold>
  public static void registerStatementVarDecls(final BugReport /*&*/ BR, 
                           /*const*/ Stmt /*P*/ S, 
                           boolean EnableNullFPSuppression) {
    std.deque</*const*/ Stmt /*P*/ > WorkList = null;
    try {
      /*const*/ ExplodedNode /*P*/ N = BR.getErrorNode();
      WorkList/*J*/= new std.deque</*const*/ Stmt /*P*/ >(true);
      WorkList.push_back_T$C$R(S);
      while (!WorkList.empty()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        try {
          /*const*/ Stmt /*P*/ Head = WorkList.front();
          WorkList.pop_front();

          state = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
          final ProgramStateManager /*&*/ StateMgr = state.$arrow().getStateManager();
          {

            /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(Head);
            if ((DR != null)) {
              {
                /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
                if ((VD != null)) {
                  /*const*/ VarRegion /*P*/ R = StateMgr.getRegionManager().getVarRegion(VD, N.getLocationContext());

                  // What did we load?
                  SVal V = state.$arrow().getSVal(S, N.getLocationContext());
                  if (V.getAs(NsLoc.ConcreteInt.class).$bool() || V.getAs(NsNonloc.ConcreteInt.class).$bool()) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      // Register a new visitor with the BugReport.
                      BR.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FindLastStoreBRVisitor(V.castAs(KnownSVal.class), R, EnableNullFPSuppression)))))); $c$.clean();
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
              }
            }
          }

          for (/*const*/ Stmt /*P*/ SubStmt : Head.children$Const())  {
            WorkList.push_back_T$C$R(SubStmt);
          }
        } finally {
         if (state != null) { state.$destroy(); }
        } 
      }
    } finally {
      if (WorkList != null) { WorkList.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FindLastStoreBRVisitor::FindLastStoreBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 115,
   FQN="clang::ento::FindLastStoreBRVisitor::FindLastStoreBRVisitor", NM="_ZN5clang4ento22FindLastStoreBRVisitorC1ENS0_9KnownSValEPKNS0_9MemRegionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento22FindLastStoreBRVisitorC1ENS0_9KnownSValEPKNS0_9MemRegionEb")
  //</editor-fold>
  public FindLastStoreBRVisitor(KnownSVal V, /*const*/ MemRegion /*P*/ R, 
      boolean InEnableNullFPSuppression) {
    // : BugReporterVisitorImpl<FindLastStoreBRVisitor>(), R(R), V(V), Satisfied(false), EnableNullFPSuppression(InEnableNullFPSuppression) 
    //START JInit
    super();
    this.R = R;
    this.V = new SVal(V);
    this.Satisfied = false;
    this.EnableNullFPSuppression = InEnableNullFPSuppression;
    //END JInit
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FindLastStoreBRVisitor::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 413,
   FQN="clang::ento::FindLastStoreBRVisitor::Profile", NM="_ZNK5clang4ento22FindLastStoreBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZNK5clang4ento22FindLastStoreBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    final/*static*/ Object tag = Profile$$.tag;
    ID.AddPointer($AddrOf(tag));
    ID.AddPointer(R);
    ID.Add(V);
    ID.AddBoolean(EnableNullFPSuppression);
  }
  private static final class Profile$$ {
    static final/*static*/ Object tag = FindLastStoreBRVisitor.class;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FindLastStoreBRVisitor::VisitNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 450,
   FQN="clang::ento::FindLastStoreBRVisitor::VisitNode", NM="_ZN5clang4ento22FindLastStoreBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento22FindLastStoreBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ Succ, 
           /*const*/ ExplodedNode /*P*/ Pred, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    raw_svector_ostream os = null;
    try {
      if (Satisfied) {
        return null;
      }
      
      /*const*/ ExplodedNode /*P*/ StoreSite = null;
      /*const*/ Expr /*P*/ InitE = null;
      boolean IsParam = false;
      {
        
        // First see if we reached the declaration of the region.
        /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(R);
        if ((VR != null)) {
          if (BugReporterVisitorsStatics.isInitializationOfVar(Pred, VR)) {
            StoreSite = Pred;
            InitE = VR.getDecl().getInit$Const();
          }
        }
      }
      {
        
        // If this is a post initializer expression, initializing the region, we
        // should track the initializer expression.
        Optional<PostInitializer> PIP = Pred.<PostInitializer>getLocationAs(PostInitializer.class);
        if (PIP.$bool()) {
          /*const*/ MemRegion /*P*/ FieldReg = (/*const*/ MemRegion /*P*/ )PIP.$arrow().getLocationValue();
          if ((FieldReg != null) && FieldReg == R) {
            StoreSite = Pred;
            InitE = PIP.$arrow().getInitializer().getInit();
          }
        }
      }
      
      // Otherwise, see if this is the store site:
      // (1) Succ has this binding and Pred does not, i.e. this is
      //     where the binding first occurred.
      // (2) Succ has this binding and is a PostStore node for this region, i.e.
      //     the same binding was re-assigned here.
      if (!(StoreSite != null)) {
        if (Succ.getState().$arrow().getSVal(R).$noteq(V)) {
          return null;
        }
        if (Pred.getState().$arrow().getSVal(R).$eq(V)) {
          Optional<PostStore> PS = Succ.<PostStore>getLocationAs(PostStore.class);
          if (!PS.$bool() || /*JAVA*/$noteq_ptr(PS.$arrow().getLocationValue(), R)) {
            return null;
          }
        }
        
        StoreSite = Succ;
        {
          
          // If this is an assignment expression, we can track the value
          // being assigned.
          Optional<org.clang.analysis.PostStmt> P = Succ.<org.clang.analysis.PostStmt>getLocationAs(org.clang.analysis.PostStmt.class);
          if (P.$bool()) {
            {
              /*const*/ BinaryOperator /*P*/ BO = P.$arrow().<BinaryOperator>getStmtAs(BinaryOperator.class);
              if ((BO != null)) {
                if (BO.isAssignmentOp()) {
                  InitE = BO.getRHS();
                }
              }
            }
          }
        }
        {
          
          // If this is a call entry, the variable should be a parameter.
          // FIXME: Handle CXXThisRegion as well. (This is not a priority because
          // 'this' should never be NULL, but this visitor isn't just for NULL and
          // UndefinedVal.)
          Optional<CallEnter> CE = Succ.<CallEnter>getLocationAs(CallEnter.class);
          if (CE.$bool()) {
            {
              /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(R);
              if ((VR != null)) {
                CallEventRef<CallEvent> Call = null;
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  /*const*/ ParmVarDecl /*P*/ Param = cast_ParmVarDecl(VR.getDecl());
                  
                  final ProgramStateManager /*&*/ StateMgr = BRC.getStateManager();
                  final CallEventManager /*&*/ CallMgr = StateMgr.getCallEventManager();
                  
                  Call = $c$.clean(CallMgr.getCaller(CE.$arrow().getCalleeContext(), 
                      $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Succ.getState()))));
                  InitE = Call.$arrow().getArgExpr(Param.getFunctionScopeIndex());
                  IsParam = true;
                } finally {
                  if (Call != null) { Call.$destroy(); }
                  $c$.$destroy();
                }
              }
            }
          }
        }
        {
          
          // If this is a CXXTempObjectRegion, the Expr responsible for its creation
          // is wrapped inside of it.
          /*const*/ CXXTempObjectRegion /*P*/ TmpR = dyn_cast_CXXTempObjectRegion(R);
          if ((TmpR != null)) {
            InitE = TmpR.getExpr();
          }
        }
      }
      if (!(StoreSite != null)) {
        return null;
      }
      Satisfied = true;
      
      // If we have an expression that provided the value, try to track where it
      // came from.
      if ((InitE != null)) {
        if (V.isUndef$SVal()
           || V.getAs(NsLoc.ConcreteInt.class).$bool() || V.getAs(NsNonloc.ConcreteInt.class).$bool()) {
          if (!IsParam) {
            InitE = InitE.IgnoreParenCasts$Const();
          }
          NsBugreporter.trackNullOrUndefValue(StoreSite, InitE, BR, IsParam, 
              EnableNullFPSuppression);
        } else {
          ReturnVisitor.addVisitorIfNecessary(StoreSite, InitE.IgnoreParenCasts$Const(), 
              BR, EnableNullFPSuppression);
        }
      }
      
      // Okay, we've found the binding. Emit an appropriate message.
      SmallString/*<256>*/ sbuf/*J*/= new SmallString/*<256>*/(256);
      os/*J*/= new raw_svector_ostream(sbuf);
      {
        
        Optional<org.clang.analysis.PostStmt> PS = StoreSite.<org.clang.analysis.PostStmt>getLocationAs(org.clang.analysis.PostStmt.class);
        if (PS.$bool()) {
          /*const*/ Stmt /*P*/ S = PS.$arrow().getStmt();
          /*const*/char$ptr/*char P*/ action = null;
          /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(S);
          /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(R);
          if ((DS != null)) {
            action = $tryClone(R.canPrintPretty() ? $("initialized to ") : $("Initializing to "));
          } else if (isa_BlockExpr(S)) {
            action = R.canPrintPretty() ? $("captured by block as ") : $("Captured by block as ");
            if ((VR != null)) {
              IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
              try {
                // See if we can get the BlockVarRegion.
                State = new IntrusiveRefCntPtr</*const*/ ProgramState>(StoreSite.getState());
                SVal V = State.$arrow().getSVal(S, PS.$arrow().getLocationContext());
                {
                  /*const*/ BlockDataRegion /*P*/ BDR = dyn_cast_or_null_BlockDataRegion(V.getAsRegion());
                  if ((BDR != null)) {
                    {
                      /*const*/ VarRegion /*P*/ OriginalR = BDR.getOriginalRegion(VR);
                      if ((OriginalR != null)) {
                        {
                          Optional<KnownSVal> KV = State.$arrow().getSVal(OriginalR).getAs(KnownSVal.class);
                          if (KV.$bool()) {
                            JavaCleaner $c$ = $createJavaCleaner();
                            try {
                              BR.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FindLastStoreBRVisitor(KV.$star(), OriginalR, EnableNullFPSuppression)))))); $c$.clean();
                            } finally {
                              $c$.$destroy();
                            }
                          }
                        }
                      }
                    }
                  }
                }
              } finally {
               if (State != null) { State.$destroy(); }
              } 
            }
          }
          if (Native.$bool(action)) {
            if (R.canPrintPretty()) {
              R.printPretty(os);
              os.$out(/*KEEP_STR*/$SPACE);
            }
            if (V.getAs(NsLoc.ConcreteInt.class).$bool()) {
              boolean b = false;
              if (R.isBoundable()) {
                {
                  /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_TypedValueRegion(R);
                  if ((TR != null)) {
                    if (TR.getValueType().$arrow().isObjCObjectPointerType()) {
                      os.$out(action).$out(/*KEEP_STR*/"nil");
                      b = true;
                    }
                  }
                }
              }
              if (!b) {
                os.$out(action).$out(/*KEEP_STR*/"a null pointer value");
              }
            } else {
              Optional<NsNonloc.ConcreteInt> CVal = V.getAs(NsNonloc.ConcreteInt.class);
              if (CVal.$bool()) {
                $out_raw_ostream_APSInt$C(os.$out(action), CVal.$arrow().getValue());
              } else if ((DS != null)) {
                if (V.isUndef$SVal()) {
                  if (isa_VarRegion(R)) {
                    /*const*/ VarDecl /*P*/ VD = cast_VarDecl(DS.getSingleDecl$Const());
                    if ((VD.getInit$Const() != null)) {
                      os.$out((R.canPrintPretty() ? $("initialized") : $("Initializing"))).$out(
                          /*KEEP_STR*/" to a garbage value"
                      );
                    } else {
                      os.$out((R.canPrintPretty() ? $("declared") : $("Declaring"))).$out(
                          /*KEEP_STR*/" without an initial value"
                      );
                    }
                  }
                } else {
                  os.$out((R.canPrintPretty() ? $("initialized") : $("Initialized"))).$out(
                      /*KEEP_STR*/" here"
                  );
                }
              }
            }
          }
        } else if (StoreSite.getLocation().getAs(CallEnter.class).$bool()) {
          {
            /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(R);
            if ((VR != null)) {
              /*const*/ ParmVarDecl /*P*/ Param = cast_ParmVarDecl(VR.getDecl());
              
              os.$out(/*KEEP_STR*/"Passing ");
              if (V.getAs(NsLoc.ConcreteInt.class).$bool()) {
                if (Param.getType().$arrow().isObjCObjectPointerType()) {
                  os.$out(/*KEEP_STR*/"nil object reference");
                } else {
                  os.$out(/*KEEP_STR*/"null pointer value");
                }
              } else if (V.isUndef$SVal()) {
                os.$out(/*KEEP_STR*/"uninitialized value");
              } else {
                Optional<NsNonloc.ConcreteInt> CI = V.getAs(NsNonloc.ConcreteInt.class);
                if (CI.$bool()) {
                  $out_raw_ostream_APSInt$C(os.$out(/*KEEP_STR*/"the value "), CI.$arrow().getValue());
                } else {
                  os.$out(/*KEEP_STR*/"value");
                }
              }
              
              // Printed parameter indexes are 1-based, not 0-based.
              /*uint*/int Idx = Param.getFunctionScopeIndex() + 1;
              os.$out(/*KEEP_STR*/" via ").$out_uint(Idx).$out(llvm.getOrdinalSuffix(Idx)).$out(/*KEEP_STR*/" parameter");
              if (R.canPrintPretty()) {
                os.$out(/*KEEP_STR*/$SPACE);
                R.printPretty(os);
              }
            }
          }
        }
      }
      if (os.str().empty()) {
        if (V.getAs(NsLoc.ConcreteInt.class).$bool()) {
          boolean b = false;
          if (R.isBoundable()) {
            {
              /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_TypedValueRegion(R);
              if ((TR != null)) {
                if (TR.getValueType().$arrow().isObjCObjectPointerType()) {
                  os.$out(/*KEEP_STR*/"nil object reference stored");
                  b = true;
                }
              }
            }
          }
          if (!b) {
            if (R.canPrintPretty()) {
              os.$out(/*KEEP_STR*/"Null pointer value stored");
            } else {
              os.$out(/*KEEP_STR*/"Storing null pointer value");
            }
          }
        } else if (V.isUndef$SVal()) {
          if (R.canPrintPretty()) {
            os.$out(/*KEEP_STR*/"Uninitialized value stored");
          } else {
            os.$out(/*KEEP_STR*/"Storing uninitialized value");
          }
        } else {
          Optional<NsNonloc.ConcreteInt> CV = V.getAs(NsNonloc.ConcreteInt.class);
          if (CV.$bool()) {
            if (R.canPrintPretty()) {
              $out_raw_ostream_APSInt$C(os.$out(/*KEEP_STR*/"The value "), CV.$arrow().getValue()).$out(/*KEEP_STR*/" is assigned");
            } else {
              $out_raw_ostream_APSInt$C(os.$out(/*KEEP_STR*/"Assigning "), CV.$arrow().getValue());
            }
          } else {
            if (R.canPrintPretty()) {
              os.$out(/*KEEP_STR*/"Value assigned");
            } else {
              os.$out(/*KEEP_STR*/"Assigning value");
            }
          }
        }
        if (R.canPrintPretty()) {
          os.$out(/*KEEP_STR*/" to ");
          R.printPretty(os);
        }
      }
      
      // Construct a new PathDiagnosticPiece.
      ProgramPoint P = StoreSite.getLocation();
      PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation();
      if (P.getAs(CallEnter.class).$bool() && (InitE != null)) {
        L.$assignMove(new PathDiagnosticLocation(InitE, BRC.getSourceManager(), 
                new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, P.getLocationContext())));
      }
      if (!L.isValid() || !L.asLocation().isValid()) {
        L.$assignMove(PathDiagnosticLocation.create(P, BRC.getSourceManager()));
      }
      if (!L.isValid() || !L.asLocation().isValid()) {
        return null;
      }
      
      return new PathDiagnosticEventPiece(L, os.str());
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FindLastStoreBRVisitor::~FindLastStoreBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 99,
   FQN="clang::ento::FindLastStoreBRVisitor::~FindLastStoreBRVisitor", NM="_ZN5clang4ento22FindLastStoreBRVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento22FindLastStoreBRVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FindLastStoreBRVisitor::FindLastStoreBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 99,
   FQN="clang::ento::FindLastStoreBRVisitor::FindLastStoreBRVisitor", NM="_ZN5clang4ento22FindLastStoreBRVisitorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento22FindLastStoreBRVisitorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ FindLastStoreBRVisitor(final /*const*/ FindLastStoreBRVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<FindLastStoreBRVisitor>(), R(.R), V(.V), Satisfied(.Satisfied), EnableNullFPSuppression(.EnableNullFPSuppression) 
    //START JInit
    super($Prm0);
    this.R = $Prm0.R;
    this.V = new SVal($Prm0.V);
    this.Satisfied = $Prm0.Satisfied;
    this.EnableNullFPSuppression = $Prm0.EnableNullFPSuppression;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public FindLastStoreBRVisitor clone() {
    return new FindLastStoreBRVisitor(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "R=" + R // NOI18N
              + ", V=" + V // NOI18N
              + ", Satisfied=" + Satisfied // NOI18N
              + ", EnableNullFPSuppression=" + EnableNullFPSuppression // NOI18N
              + super.toString(); // NOI18N
  }
}
