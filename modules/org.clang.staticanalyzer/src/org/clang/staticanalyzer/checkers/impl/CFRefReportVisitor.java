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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.checkers.ento.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.checkers.ento.objc_retain.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.RetainCountCheckerStatics.*;


//===---------===//
// Bug Reports.  //
//===---------===//
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReportVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1748,
 FQN="(anonymous namespace)::CFRefReportVisitor", NM="_ZN12_GLOBAL__N_118CFRefReportVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118CFRefReportVisitorE")
//</editor-fold>
public class CFRefReportVisitor extends /*public*/ BugReporterVisitorImpl<CFRefReportVisitor> implements Destructors.ClassWithDestructor {
/*protected:*/
  protected /*const*/ SymExpr /*P*/ Sym;
  protected final /*const*/DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ > /*&*/ SummaryLog;
  protected boolean GCEnabled;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReportVisitor::CFRefReportVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1755,
   FQN="(anonymous namespace)::CFRefReportVisitor::CFRefReportVisitor", NM="_ZN12_GLOBAL__N_118CFRefReportVisitorC1EPKN5clang4ento7SymExprEbRKN4llvm8DenseMapIPKNS2_12ExplodedNodeEPKNS_13RetainSummaryENS6_12DenseMapInfoISA_EENS6_6detail12DenseMapPairISA_SD_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118CFRefReportVisitorC1EPKN5clang4ento7SymExprEbRKN4llvm8DenseMapIPKNS2_12ExplodedNodeEPKNS_13RetainSummaryENS6_12DenseMapInfoISA_EENS6_6detail12DenseMapPairISA_SD_EEEE")
  //</editor-fold>
  public CFRefReportVisitor(/*const*/ SymExpr /*P*/ sym, boolean gcEnabled, final /*const*/DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ > /*&*/ log) {
    // : BugReporterVisitorImpl<CFRefReportVisitor>(), Sym(sym), SummaryLog(log), GCEnabled(gcEnabled) 
    //START JInit
    super();
    this.Sym = sym;
    this./*&*/SummaryLog=/*&*/log;
    this.GCEnabled = gcEnabled;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReportVisitor::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1758,
   FQN="(anonymous namespace)::CFRefReportVisitor::Profile", NM="_ZNK12_GLOBAL__N_118CFRefReportVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118CFRefReportVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    final/*static*/ Object x = Profile$$.x;
    ID.AddPointer($AddrOf(x));
    ID.AddPointer(Sym);
  }
  private static final class Profile$$ {
    static final/*static*/ Object x = CFRefReportVisitor.class;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReportVisitor::VisitNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*!=*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1890,
   FQN="(anonymous namespace)::CFRefReportVisitor::VisitNode", NM="_ZN12_GLOBAL__N_118CFRefReportVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118CFRefReportVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
           /*const*/ ExplodedNode /*P*/ PrevN, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> PrevSt = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> CurrSt = null;
    raw_string_ostream os = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: We will eventually need to handle non-statement-based events
      // (__attribute__((cleanup))).
      if (!N.getLocation().getAs(StmtPoint.class).$bool()) {
        return null;
      }
      
      // Check if the type state has changed.
      PrevSt = new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevN.getState());
      CurrSt = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      /*const*/ LocationContext /*P*/ LCtx = N.getLocationContext();
      
      /*const*/ RefVal /*P*/ CurrT = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CurrSt)), Sym));
      if (!(CurrT != null)) {
        return null;
      }
      
      final /*const*/ RefVal /*&*/ CurrV = $Deref(CurrT);
      /*const*/ RefVal /*P*/ PrevT = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevSt)), Sym));
      
      // Create a string buffer to constain all the useful things we want
      // to tell the user.
      std.string sbuf/*J*/= new std.string();
      os/*J*/= new raw_string_ostream(sbuf);
      
      // This is the allocation site since the previous node had no bindings
      // for this symbol.
      if (!(PrevT != null)) {
        /*const*/ Stmt /*P*/ S = N.getLocation().castAs(StmtPoint.class).getStmt();
        if (isa_ObjCIvarRefExpr(S)
           && RetainCountCheckerStatics.isSynthesizedAccessor(LCtx.getCurrentStackFrame())) {
          S = LCtx.getCurrentStackFrame().getCallSite();
        }
        if (isa_ObjCArrayLiteral(S)) {
          os.$out(/*KEEP_STR*/"NSArray literal is an object with a +0 retain count");
        } else if (isa_ObjCDictionaryLiteral(S)) {
          os.$out(/*KEEP_STR*/"NSDictionary literal is an object with a +0 retain count");
        } else {
          /*const*/ ObjCBoxedExpr /*P*/ BL = dyn_cast_ObjCBoxedExpr(S);
          if ((BL != null)) {
            if (RetainCountCheckerStatics.isNumericLiteralExpression(BL.getSubExpr$Const())) {
              os.$out(/*KEEP_STR*/"NSNumber literal is an object with a +0 retain count");
            } else {
              /*const*/ ObjCInterfaceDecl /*P*/ BoxClass = null;
              {
                /*const*/ ObjCMethodDecl /*P*/ Method = BL.getBoxingMethod();
                if ((Method != null)) {
                  BoxClass = Method.getClassInterface$Const();
                }
              }
              
              // We should always be able to find the boxing class interface,
              // but consider this future-proofing.
              if ((BoxClass != null)) {
                $out_raw_ostream_NamedDecl$C(os, $Deref(BoxClass)).$out(/*KEEP_STR*/" b");
              } else {
                os.$out(/*KEEP_STR*/$B);
              }
              
              os.$out(/*KEEP_STR*/"oxed expression produces an object with a +0 retain count");
            }
          } else if (isa_ObjCIvarRefExpr(S)) {
            os.$out(/*KEEP_STR*/"Object loaded from instance variable");
          } else {
            {
              /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(S);
              if ((CE != null)) {
                // Get the name of the callee (if it is available).
                SVal X = CurrSt.$arrow().getSValAsScalarOrLoc(CE.getCallee$Const(), LCtx);
                {
                  /*const*/ FunctionDecl /*P*/ FD = X.getAsFunctionDecl();
                  if ((FD != null)) {
                    $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"Call to function '"), $Deref(FD)).$out_char($$SGL_QUOTE);
                  } else {
                    os.$out(/*KEEP_STR*/"function call");
                  }
                }
              } else {
                CallEventRef<ObjCMethodCall> Call = null;
                try {
                  assert (isa_ObjCMessageExpr(S));
                  final CallEventManager /*&*/ Mgr = CurrSt.$arrow().getStateManager().getCallEventManager();
                  Call = $c$.clean(Mgr.getObjCMethodCall(cast_ObjCMessageExpr(S), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CurrSt)), LCtx));
                  switch (Call.$arrow().getMessageKind()) {
                   case OCM_Message:
                    os.$out(/*KEEP_STR*/"Method");
                    break;
                   case OCM_PropertyAccess:
                    os.$out(/*KEEP_STR*/"Property");
                    break;
                   case OCM_Subscript:
                    os.$out(/*KEEP_STR*/"Subscript");
                    break;
                  }
                } finally {
                  if (Call != null) { Call.$destroy(); }
                }
              }
            }
            if (CurrV.getObjKind() == RetEffect.ObjKind.CF) {
              os.$out(/*KEEP_STR*/" returns a Core Foundation object with a ");
            } else {
              assert (CurrV.getObjKind() == RetEffect.ObjKind.ObjC);
              os.$out(/*KEEP_STR*/" returns an Objective-C object with a ");
            }
            if (CurrV.isOwned()) {
              os.$out(/*KEEP_STR*/"+1 retain count");
              if (GCEnabled) {
                assert (CurrV.getObjKind() == RetEffect.ObjKind.CF);
                os.$out(/*KEEP_STR*/".  Core Foundation objects are not automatically garbage collected.");
              }
            } else {
              assert (CurrV.isNotOwned());
              os.$out(/*KEEP_STR*/"+0 retain count");
            }
          }
        }
        
        PathDiagnosticLocation Pos/*J*/= new PathDiagnosticLocation(S, BRC.getSourceManager(), 
            new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, N.getLocationContext()));
        return new PathDiagnosticEventPiece(Pos, new StringRef(os.str()));
      }
      
      // Gather up the effects that were performed on the object at this
      // program point
      SmallVector<objc_retain.ArgEffect> AEffects/*J*/= new SmallVector<objc_retain.ArgEffect>(2, objc_retain.ArgEffect.valueOf(0));
      
      /*const*/ ExplodedNode /*P*/ OrigNode = BRC.getNodeResolver().getOriginalNode(N);
      {
        /*const*/ RetainSummary /*P*/ Summ = SummaryLog.lookup(OrigNode);
        if ((Summ != null)) {
          // We only have summaries attached to nodes after evaluating CallExpr and
          // ObjCMessageExprs.
          /*const*/ Stmt /*P*/ S = N.getLocation().castAs(StmtPoint.class).getStmt();
          {
            
            /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(S);
            if ((CE != null)) {
              // Iterate through the parameter expressions and see if the symbol
              // was ever passed as an argument.
              /*uint*/int i = 0;
              
              for (Stmt.ConstExprIterator AI = CE.arg_begin$Const(), AE = CE.arg_end$Const();
                   AI.$noteq(AE); AI.$preInc() , ++i) {
                
                // Retrieve the value of the argument.  Is it the symbol
                // we are interested in?
                if (CurrSt.$arrow().getSValAsScalarOrLoc(AI.$star(), LCtx).getAsLocSymbol() != Sym) {
                  continue;
                }
                
                // We have an argument.  Get the effect!
                AEffects.push_back(Summ.getArg(i));
              }
            } else {
              /*const*/ ObjCMessageExpr /*P*/ ME = dyn_cast_ObjCMessageExpr(S);
              if ((ME != null)) {
                {
                  /*const*/ Expr /*P*/ receiver = ME.getInstanceReceiver$Const();
                  if ((receiver != null)) {
                    if (CurrSt.$arrow().getSValAsScalarOrLoc(receiver, LCtx).
                        getAsLocSymbol() == Sym) {
                      // The symbol we are tracking is the receiver.
                      AEffects.push_back(Summ.getReceiverEffect());
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      do {
        // Get the previous type state.
        RefVal PrevV = new RefVal($Deref(PrevT));
        
        // Specially handle -dealloc.
        if (!GCEnabled && std.find(AEffects.begin(), AEffects.end(), /*KEEP_ENUM*/ArgEffect.Dealloc)
           .$noteq(AEffects.end())) {
          // Determine if the object's reference count was pushed to zero.
          assert (!PrevV.hasSameState(CurrV)) : "The state should have changed.";
          // We may not have transitioned to 'release' if we hit an error.
          // This case is handled elsewhere.
          if (CurrV.getKind() == RefVal.Kind.Released) {
            assert (CurrV.getCombinedCounts() == 0);
            os.$out(/*KEEP_STR*/"Object released by directly sending the '-dealloc' message");
            break;
          }
        }
        
        // Specially handle CFMakeCollectable and friends.
        if (std.find(AEffects.begin(), AEffects.end(), /*KEEP_ENUM*/ArgEffect.MakeCollectable)
           .$noteq(AEffects.end())) {
          // Get the name of the function.
          /*const*/ Stmt /*P*/ S = N.getLocation().castAs(StmtPoint.class).getStmt();
          SVal X = CurrSt.$arrow().getSValAsScalarOrLoc(cast_CallExpr(S).getCallee$Const(), LCtx);
          /*const*/ FunctionDecl /*P*/ FD = X.getAsFunctionDecl();
          if (GCEnabled) {
            // Determine if the object's reference count was pushed to zero.
            assert (!PrevV.hasSameState(CurrV)) : "The state should have changed.";
            
            $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"In GC mode a call to '"), $Deref(FD)).$out(
                /*KEEP_STR*/"' decrements an object's retain count and registers the object with the garbage collector. "
            );
            if (CurrV.getKind() == RefVal.Kind.Released) {
              assert (CurrV.getCount() == 0);
              os.$out(/*KEEP_STR*/"Since it now has a 0 retain count the object can be automatically collected by the garbage collector.");
            } else {
              os.$out(/*KEEP_STR*/"An object must have a 0 retain count to be garbage collected. After this call its retain count is +").$out_uint(CurrV.getCount()).$out_char(
                  $$DOT
              );
            }
          } else {
            $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"When GC is not enabled a call to '"), $Deref(FD)).$out(
                /*KEEP_STR*/"' has no effect on its argument."
            );
          }
          
          // Nothing more to say.
          break;
        }
        
        // Determine if the typestate has changed.
        if (!PrevV.hasSameState(CurrV)) {
          switch (CurrV.getKind()) {
           case Owned:
           case NotOwned:
            if (PrevV.getCount() == CurrV.getCount()) {
              // Did an autorelease message get sent?
              if (PrevV.getAutoreleaseCount() == CurrV.getAutoreleaseCount()) {
                return null;
              }
              assert ($less_uint(PrevV.getAutoreleaseCount(), CurrV.getAutoreleaseCount()));
              os.$out(/*KEEP_STR*/"Object autoreleased");
              break;
            }
            if ($greater_uint(PrevV.getCount(), CurrV.getCount())) {
              os.$out(/*KEEP_STR*/"Reference count decremented.");
            } else {
              os.$out(/*KEEP_STR*/"Reference count incremented.");
            }
            {
              
              /*uint*/int Count = CurrV.getCount();
              if ((Count != 0)) {
                os.$out(/*KEEP_STR*/" The object now has a +").$out_uint(Count).$out(/*KEEP_STR*/" retain count.");
              }
            }
            if (PrevV.getKind() == RefVal.Kind.Released) {
              assert (GCEnabled && $greater_uint(CurrV.getCount(), 0));
              os.$out(/*KEEP_STR*/" The object is not eligible for garbage collection until the retain count reaches 0 again.");
            }
            
            break;
           case Released:
            if (CurrV.getIvarAccessHistory()
               == RefVal.IvarAccessHistory.ReleasedAfterDirectAccess
               && CurrV.getIvarAccessHistory() != PrevV.getIvarAccessHistory()) {
              os.$out(/*KEEP_STR*/"Strong instance variable relinquished. ");
            }
            os.$out(/*KEEP_STR*/"Object released.");
            break;
           case ReturnedOwned:
            // Autoreleases can be applied after marking a node ReturnedOwned.
            if ((CurrV.getAutoreleaseCount() != 0)) {
              return null;
            }
            
            os.$out(/*KEEP_STR*/"Object returned to caller as an owning reference (single retain count transferred to caller)");
            break;
           case ReturnedNotOwned:
            os.$out(/*KEEP_STR*/"Object returned to caller with a +0 retain count");
            break;
           default:
            return null;
          }
        }
        
        // Emit any remaining diagnostics for the argument effects (if any).
        for (type$ptr<objc_retain.ArgEffect /*P*/ > I = $tryClone(AEffects.begin()), 
            /*P*/ E = $tryClone(AEffects.end()); $noteq_ptr(I, E); I.$preInc()) {
          
          // A bunch of things have alternate behavior under GC.
          if (GCEnabled) {
            switch (I.$star()) {
             default:
              break;
             case Autorelease:
              os.$out(/*KEEP_STR*/"In GC mode an 'autorelease' has no effect.");
              continue;
             case IncRefMsg:
              os.$out(/*KEEP_STR*/"In GC mode the 'retain' message has no effect.");
              continue;
             case DecRefMsg:
              os.$out(/*KEEP_STR*/"In GC mode the 'release' message has no effect.");
              continue;
            }
          }
        }
      } while (false);
      if (os.str().empty()) {
        return null; // We have nothing to say!
      }
      
      /*const*/ Stmt /*P*/ S = N.getLocation().castAs(StmtPoint.class).getStmt();
      PathDiagnosticLocation Pos/*J*/= new PathDiagnosticLocation(S, BRC.getSourceManager(), 
          new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, N.getLocationContext()));
      PathDiagnosticPiece /*P*/ P = new PathDiagnosticEventPiece(Pos, new StringRef(os.str()));
      
      // Add the range by scanning the children of the statement for any bindings
      // to Sym.
      for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
        {
          /*const*/ Expr /*P*/ Exp = dyn_cast_or_null_Expr(Child);
          if ((Exp != null)) {
            if (CurrSt.$arrow().getSValAsScalarOrLoc(Exp, LCtx).getAsLocSymbol() == Sym) {
              P.addRange(Exp.getSourceRange());
              break;
            }
          }
        }
      }
      
      return P;
    } finally {
      if (os != null) { os.$destroy(); }
      if (CurrSt != null) { CurrSt.$destroy(); }
      if (PrevSt != null) { PrevSt.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReportVisitor::getEndPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2298,
   FQN="(anonymous namespace)::CFRefReportVisitor::getEndPath", NM="_ZN12_GLOBAL__N_118CFRefReportVisitor10getEndPathERN5clang4ento18BugReporterContextEPKNS2_12ExplodedNodeERNS2_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118CFRefReportVisitor10getEndPathERN5clang4ento18BugReporterContextEPKNS2_12ExplodedNodeERNS2_9BugReportE")
  //</editor-fold>
  @Override public std.unique_ptr<PathDiagnosticPiece> getEndPath(final BugReporterContext /*&*/ BRC, 
            /*const*/ ExplodedNode /*P*/ EndN, final BugReport /*&*/ BR)/* override*/ {
    BR.markInteresting(Sym);
    return BugReporterVisitor.getDefaultEndPath(BRC, EndN, BR);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReportVisitor::~CFRefReportVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1748,
   FQN="(anonymous namespace)::CFRefReportVisitor::~CFRefReportVisitor", NM="_ZN12_GLOBAL__N_118CFRefReportVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118CFRefReportVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReportVisitor::CFRefReportVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1748,
   FQN="(anonymous namespace)::CFRefReportVisitor::CFRefReportVisitor", NM="_ZN12_GLOBAL__N_118CFRefReportVisitorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118CFRefReportVisitorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CFRefReportVisitor(final /*const*/ CFRefReportVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<CFRefReportVisitor>(), Sym(.Sym), SummaryLog(.SummaryLog), GCEnabled(.GCEnabled) 
    //START JInit
    super($Prm0);
    this.Sym = $Prm0.Sym;
    this./*&*/SummaryLog=/*&*/$Prm0.SummaryLog;
    this.GCEnabled = $Prm0.GCEnabled;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public CFRefReportVisitor clone() {
    return new CFRefReportVisitor(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Sym=" + "[SymExpr]" // NOI18N
              + ", SummaryLog=" + SummaryLog // NOI18N
              + ", GCEnabled=" + GCEnabled // NOI18N
              + super.toString(); // NOI18N
  }
}
