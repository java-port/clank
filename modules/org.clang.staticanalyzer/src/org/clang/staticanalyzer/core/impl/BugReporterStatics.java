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
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.core.impl.BugReporterStatics.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APSInt$C;


//<editor-fold defaultstate="collapsed" desc="static type BugReporterStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.impl.BugReporterStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL10getLocStmtN5clang4ento22PathDiagnosticLocationE;_ZL12isInLoopBodyRN5clang9ParentMapEPKNS_4StmtES4_;_ZL13addEdgeToPathRN5clang4ento10PathPiecesERNS0_22PathDiagnosticLocationES3_PKNS_15LocationContextE;_ZL13getStmtParentPKN5clang4StmtERKNS_9ParentMapE;_ZL13optimizeEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERN4llvm8DenseSetIPKNS0_23PathDiagnosticCallPieceENS5_12DenseMapInfoIS9_EEEERNS5_8DenseMapIPKS1_PKNS_15LocationContextENSA_ISG_EENS5_6detail12DenseMapPairISG_SJ_EEEE;_ZL15GetPreviousStmtPKN5clang4ento12ExplodedNodeE;_ZL15MaxBugClassSize;_ZL15StrEnteringLoop;_ZL15StrLoopBodyZero;_ZL15addContextEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERKNS_9ParentMapEPKNS_15LocationContextE;_ZL15hasImplicitBodyPKN5clang4DeclE;_ZL15lexicalContainsRN5clang9ParentMapEPKNS_4StmtES4_;_ZL15removePunyEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERNS_9ParentMapE;_ZL17IsControlFlowExprPKN5clang4StmtE;_ZL17StrLoopRangeEmpty;_ZL17getStmtBeforeCondRN5clang9ParentMapEPKNS_4StmtEPKNS_4ento12ExplodedNodeE;_ZL17isContainedByStmtRN5clang9ParentMapEPKNS_4StmtES4_;_ZL18getEnclosingParentPKN5clang4StmtERKNS_9ParentMapE;_ZL18isLoopJumpPastBodyPKN5clang4StmtEPKNS_9BlockEdgeE;_ZL19adjustCallLocationsRN5clang4ento10PathPiecesEPNS0_22PathDiagnosticLocationE;_ZL19isJumpToFalseBranchPKN5clang9BlockEdgeE;_ZL19removeContextCyclesRN5clang4ento10PathPiecesERNS_13SourceManagerERNS_9ParentMapE;_ZL19removeRedundantMsgsRN5clang4ento10PathPiecesE;_ZL19removeUnneededCallsRN5clang4ento10PathPiecesEPNS0_9BugReportERN4llvm8DenseMapIPKS1_PKNS_15LocationContextENS5_12DenseMapInfoIS8_EENS5_6detail12DenseMapPairIS8_SB_EEEE;_ZL20MaxValidBugClassSize;_ZL21CompactPathDiagnosticRN5clang4ento10PathPiecesERKNS_13SourceManagerE;_ZL21dropFunctionEntryEdgeRN5clang4ento10PathPiecesERN4llvm8DenseMapIPKS1_PKNS_15LocationContextENS3_12DenseMapInfoIS6_EENS3_6detail12DenseMapPairIS6_S9_EEEERNS_13SourceManagerE;_ZL21getLengthOnSingleLineRN5clang13SourceManagerENS_11SourceRangeE;_ZL21getLengthOnSingleLineRN5clang13SourceManagerEPKNS_4StmtE;_ZL21removeIdenticalEventsRN5clang4ento10PathPiecesE;_ZL22StrLoopCollectionEmpty;_ZL22getTerminatorConditionPKN5clang8CFGBlockE;_ZL22simplifySimpleBranchesRN5clang4ento10PathPiecesE;_ZL24GetCurrentOrPreviousStmtPKN5clang4ento12ExplodedNodeE;_ZL24getEnclosingStmtLocationPKN5clang4StmtERNS_13SourceManagerERKNS_9ParentMapEPKNS_15LocationContextEb;_ZL24isConditionForTerminatorPKN5clang4StmtES2_;_ZL26isIncrementOrInitInForLoopPKN5clang4StmtES2_;_ZL27eventsDescribeSameConditionPN5clang4ento24PathDiagnosticEventPieceES2_;_ZL28FindReportInEquivalenceClassRN5clang4ento19BugReportEquivClassERN4llvm15SmallVectorImplIPNS0_9BugReportEEE;_ZL28updateStackPiecesWithMessagePN5clang4ento19PathDiagnosticPieceERN4llvm11SmallVectorISt4pairIPNS0_23PathDiagnosticCallPieceEPKNS0_12ExplodedNodeEELj6EEE;_ZL29GenerateMinimalPathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE;_ZL31GenerateExtensivePathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE;_ZL32removeEdgesToDefaultInitializersRN5clang4ento10PathPiecesE;_ZL32removePiecesWithInvalidLocationsRN5clang4ento10PathPiecesE;_ZL34GenerateVisitorsOnlyPathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeEN4llvm8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISC_EEEE;_ZL34reversePropagateInterestingSymbolsRN5clang4ento9BugReportERN4llvm8DenseSetIPKNS_4ExprENS3_12DenseMapInfoIS7_EEEEPKNS0_12ProgramStateEPKNS_15LocationContextESH_;_ZL35reversePropagateIntererstingSymbolsRN5clang4ento9BugReportERN4llvm8DenseSetIPKNS_4ExprENS3_12DenseMapInfoIS7_EEEEPKNS0_12ProgramStateES7_PKNS_15LocationContextE;_ZL40GenerateAlternateExtensivePathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE;_ZL6isLoopPKN5clang4StmtE;_ZN12_GLOBAL__N_1L15cleanUpLocationEN5clang4ento22PathDiagnosticLocationEPKNS0_15LocationContextEb; -static-type=BugReporterStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class BugReporterStatics {

//<editor-fold defaultstate="collapsed" desc="MaxBugClassSize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 43,
 FQN="MaxBugClassSize", NM="_ZL15MaxBugClassSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL15MaxBugClassSize")
//</editor-fold>
public static Statistic MaxBugClassSize = new Statistic($("BugReporter"), $("MaxBugClassSize"), $("The maximum number of bug reports in the same equivalence class"), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="MaxValidBugClassSize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 45,
 FQN="MaxValidBugClassSize", NM="_ZL20MaxValidBugClassSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL20MaxValidBugClassSize")
//</editor-fold>
public static Statistic MaxValidBugClassSize = new Statistic($("BugReporter"), $("MaxValidBugClassSize"), $("The maximum number of bug reports in the same equivalence class where at least one report is valid (not suppressed)"), (/*(void)*/0), false);

//===----------------------------------------------------------------------===//
// Helper routines for walking the ExplodedGraph and fetching statements.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="GetPreviousStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 57,
 FQN="GetPreviousStmt", NM="_ZL15GetPreviousStmtPKN5clang4ento12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL15GetPreviousStmtPKN5clang4ento12ExplodedNodeE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ GetPreviousStmt(/*const*/ ExplodedNode /*P*/ N) {
  for (N = N.getFirstPred$Const(); (N != null); N = N.getFirstPred$Const())  {
    {
      /*const*/ Stmt /*P*/ S = PathDiagnosticLocation.getStmt(N);
      if ((S != null)) {
        return S;
      }
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="GetCurrentOrPreviousStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 65,
 FQN="GetCurrentOrPreviousStmt", NM="_ZL24GetCurrentOrPreviousStmtPKN5clang4ento12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL24GetCurrentOrPreviousStmtPKN5clang4ento12ExplodedNodeE")
//</editor-fold>
public static /*inline*/ /*const*/ Stmt /*P*/ GetCurrentOrPreviousStmt(/*const*/ ExplodedNode /*P*/ N) {
  {
    /*const*/ Stmt /*P*/ S = PathDiagnosticLocation.getStmt(N);
    if ((S != null)) {
      return S;
    }
  }
  
  return GetPreviousStmt(N);
}


//===----------------------------------------------------------------------===//
// Diagnostic cleanup.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="eventsDescribeSameCondition">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 77,
 FQN="eventsDescribeSameCondition", NM="_ZL27eventsDescribeSameConditionPN5clang4ento24PathDiagnosticEventPieceES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL27eventsDescribeSameConditionPN5clang4ento24PathDiagnosticEventPieceES2_")
//</editor-fold>
public static PathDiagnosticEventPiece /*P*/ eventsDescribeSameCondition(PathDiagnosticEventPiece /*P*/ X, 
                           PathDiagnosticEventPiece /*P*/ Y) {
  // Prefer diagnostics that come from ConditionBRVisitor over
  // those that came from TrackConstraintBRVisitor.
  /*const*/Object/*void P*/ tagPreferred = $tryClone(ConditionBRVisitor.getTag());
  /*const*/Object/*void P*/ tagLesser = $tryClone(TrackConstraintBRVisitor.getTag());
  if (X.getLocation().$noteq(Y.getLocation())) {
    return null;
  }
  if ($eq_ptr(X.getTag(), tagPreferred) && $eq_ptr(Y.getTag(), tagLesser)) {
    return X;
  }
  if ($eq_ptr(Y.getTag(), tagPreferred) && $eq_ptr(X.getTag(), tagLesser)) {
    return Y;
  }
  
  return null;
}


/// An optimization pass over PathPieces that removes redundant diagnostics
/// generated by both ConditionBRVisitor and TrackConstraintBRVisitor.  Both
/// BugReporterVisitors use different methods to generate diagnostics, with
/// one capable of emitting diagnostics in some cases but not in others.  This
/// can lead to redundant diagnostic pieces at the same point in a path.
//<editor-fold defaultstate="collapsed" desc="removeRedundantMsgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 102,
 FQN="removeRedundantMsgs", NM="_ZL19removeRedundantMsgsRN5clang4ento10PathPiecesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL19removeRedundantMsgsRN5clang4ento10PathPiecesE")
//</editor-fold>
public static void removeRedundantMsgs(final PathPieces /*&*/ _path) {
  /*uint*/int N = _path.size();
  if ($less_uint(N, 2)) {
    return;
  }
  // NOTE: this loop intentionally is not using an iterator.  Instead, we
  // are streaming the path and modifying it in place.  This is done by
  // grabbing the front, processing it, and if we decide to keep it append
  // it to the end of the path.  The entire path is processed in this way.
  for (/*uint*/int i = 0; $less_uint(i, N); ++i) {
    IntrusiveRefCntPtr<PathDiagnosticPiece> piece = null;
    try {
      piece/*J*/= new IntrusiveRefCntPtr<PathDiagnosticPiece>(_path.front());
      _path.pop_front();
      switch (piece.$arrow().getKind()) {
       case Call:
        removeRedundantMsgs(cast_PathDiagnosticCallPiece(piece.$arrow())._path);
        break;
       case Macro:
        removeRedundantMsgs(cast_PathDiagnosticMacroPiece(piece.$arrow()).subPieces);
        break;
       case ControlFlow:
        break;
       case Event:
        {
          if (i == N - 1) {
            break;
          }
          {
            
            PathDiagnosticEventPiece /*P*/ nextEvent = dyn_cast_PathDiagnosticEventPiece(_path.front().get());
            if ((nextEvent != null)) {
              PathDiagnosticEventPiece /*P*/ event = cast_PathDiagnosticEventPiece(piece.$arrow());
              {
                // Check to see if we should keep one of the two pieces.  If we
                // come up with a preference, record which piece to keep, and consume
                // another piece from the path.
                PathDiagnosticEventPiece /*P*/ pieceToKeep = eventsDescribeSameCondition(event, nextEvent);
                if ((pieceToKeep != null)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean(piece.$assign($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(pieceToKeep))));
                    _path.pop_front();
                    ++i;
                  } finally {
                    $c$.$destroy();
                  }
                }
              }
            }
          }
          break;
        }
      }
      _path.push_back_T$C$R(piece);
    } finally {
      if (piece != null) { piece.$destroy(); }
    }
  }
}


/// Recursively scan through a path and prune out calls and macros pieces
/// that aren't needed.  Return true if afterwards the path contains
/// "interesting stuff" which means it shouldn't be pruned from the parent path.
//<editor-fold defaultstate="collapsed" desc="removeUnneededCalls">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 156,
 FQN="removeUnneededCalls", NM="_ZL19removeUnneededCallsRN5clang4ento10PathPiecesEPNS0_9BugReportERN4llvm8DenseMapIPKS1_PKNS_15LocationContextENS5_12DenseMapInfoIS8_EENS5_6detail12DenseMapPairIS8_SB_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL19removeUnneededCallsRN5clang4ento10PathPiecesEPNS0_9BugReportERN4llvm8DenseMapIPKS1_PKNS_15LocationContextENS5_12DenseMapInfoIS8_EENS5_6detail12DenseMapPairIS8_SB_EEEE")
//</editor-fold>
public static boolean removeUnneededCalls(final PathPieces /*&*/ pieces, BugReport /*P*/ R, 
                   final DenseMap</*const*/ PathPieces /*P*/ , /*const*/ LocationContext /*P*/ > /*&*/ LCM) {
  boolean containsSomethingInteresting = false;
  /*const*//*uint*/int N = pieces.size();
  
  for (/*uint*/int i = 0; $less_uint(i, N); ++i) {
    IntrusiveRefCntPtr<PathDiagnosticPiece> piece = null;
    try {
      // Remove the front piece from the path.  If it is still something we
      // want to keep once we are done, we will push it back on the end.
      piece/*J*/= new IntrusiveRefCntPtr<PathDiagnosticPiece>(pieces.front());
      pieces.pop_front();
      switch (piece.$arrow().getKind()) {
       case Call:
        {
          PathDiagnosticCallPiece /*P*/ call = cast_PathDiagnosticCallPiece(piece.$arrow());
          // Check if the location context is interesting.
          assert Native.$bool(LCM.count($AddrOf(call._path)));
          if (R.isInteresting(LCM.$at_T1$RR($AddrOf(call._path)))) {
            containsSomethingInteresting = true;
            break;
          }
          if (!removeUnneededCalls(call._path, R, LCM)) {
            continue;
          }
          
          containsSomethingInteresting = true;
          break;
        }
       case Macro:
        {
          PathDiagnosticMacroPiece /*P*/ macro = cast_PathDiagnosticMacroPiece(piece.$arrow());
          if (!removeUnneededCalls(macro.subPieces, R, LCM)) {
            continue;
          }
          containsSomethingInteresting = true;
          break;
        }
       case Event:
        {
          PathDiagnosticEventPiece /*P*/ event = cast_PathDiagnosticEventPiece(piece.$arrow());
          
          // We never throw away an event, but we do throw it away wholesale
          // as part of a path if we throw the entire path away.
          containsSomethingInteresting |= !event.isPrunable();
          break;
        }
       case ControlFlow:
        break;
      }
      
      pieces.push_back_T$C$R(piece);
    } finally {
      if (piece != null) { piece.$destroy(); }
    }
  }
  
  return containsSomethingInteresting;
}


/// Returns true if the given decl has been implicitly given a body, either by
/// the analyzer or by the compiler proper.
//<editor-fold defaultstate="collapsed" desc="hasImplicitBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 210,
 FQN="hasImplicitBody", NM="_ZL15hasImplicitBodyPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL15hasImplicitBodyPKN5clang4DeclE")
//</editor-fold>
public static boolean hasImplicitBody(/*const*/ Decl /*P*/ D) {
  assert Native.$bool(D);
  return D.isImplicit() || !D.hasBody();
}


/// Recursively scan through a path and make sure that all call pieces have
/// valid locations.
//<editor-fold defaultstate="collapsed" desc="adjustCallLocations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 217,
 FQN="adjustCallLocations", NM="_ZL19adjustCallLocationsRN5clang4ento10PathPiecesEPNS0_22PathDiagnosticLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL19adjustCallLocationsRN5clang4ento10PathPiecesEPNS0_22PathDiagnosticLocationE")
//</editor-fold>
public static void adjustCallLocations(final PathPieces /*&*/ Pieces) {
  adjustCallLocations(Pieces, 
                   (PathDiagnosticLocation /*P*/ )null);
}
public static void adjustCallLocations(final PathPieces /*&*/ Pieces, 
                   PathDiagnosticLocation /*P*/ LastCallLocation/*= null*/) {
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = Pieces.begin(), E = Pieces.end(); I.$noteq(E); I.$preInc()) {
    PathDiagnosticCallPiece /*P*/ Call = dyn_cast_PathDiagnosticCallPiece(I.$star().$arrow());
    if (!(Call != null)) {
      assert ((I.$star()).$arrow().getLocation().asLocation().isValid());
      continue;
    }
    if ((LastCallLocation != null)) {
      boolean CallerIsImplicit = hasImplicitBody(Call.getCaller());
      if (CallerIsImplicit || !Call.callEnter.asLocation().isValid()) {
        Call.callEnter.$assign($Deref(LastCallLocation));
      }
      if (CallerIsImplicit || !Call.callReturn.asLocation().isValid()) {
        Call.callReturn.$assign($Deref(LastCallLocation));
      }
    }
    
    // Recursively clean out the subclass.  Keep this call around if
    // it contains any informative diagnostics.
    PathDiagnosticLocation /*P*/ ThisCallLocation;
    if (Call.callEnterWithin.asLocation().isValid()
       && !hasImplicitBody(Call.getCallee())) {
      ThisCallLocation = $AddrOf(Call.callEnterWithin);
    } else {
      ThisCallLocation = $AddrOf(Call.callEnter);
    }
    assert ((ThisCallLocation != null)) : "Outermost call has an invalid location";
    adjustCallLocations(Call._path, ThisCallLocation);
  }
}


/// Remove edges in and out of C++ default initializer expressions. These are
/// for fields that have in-class initializers, as opposed to being initialized
/// explicitly in a constructor or braced list.
//<editor-fold defaultstate="collapsed" desc="removeEdgesToDefaultInitializers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 253,
 FQN="removeEdgesToDefaultInitializers", NM="_ZL32removeEdgesToDefaultInitializersRN5clang4ento10PathPiecesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL32removeEdgesToDefaultInitializersRN5clang4ento10PathPiecesE")
//</editor-fold>
public static void removeEdgesToDefaultInitializers(final PathPieces /*&*/ Pieces) {
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = Pieces.begin(), E = Pieces.end(); I.$noteq(E);) {
    {
      PathDiagnosticCallPiece /*P*/ C = dyn_cast_PathDiagnosticCallPiece(I.$star().$arrow());
      if ((C != null)) {
        removeEdgesToDefaultInitializers(C._path);
      }
    }
    {
      
      PathDiagnosticMacroPiece /*P*/ M = dyn_cast_PathDiagnosticMacroPiece(I.$star().$arrow());
      if ((M != null)) {
        removeEdgesToDefaultInitializers(M.subPieces);
      }
    }
    {
      
      PathDiagnosticControlFlowPiece /*P*/ CF = dyn_cast_PathDiagnosticControlFlowPiece(I.$star().$arrow());
      if ((CF != null)) {
        /*const*/ Stmt /*P*/ Start = CF.getStartLocation().asStmt();
        /*const*/ Stmt /*P*/ End = CF.getEndLocation().asStmt();
        if ((Start != null) && isa_CXXDefaultInitExpr(Start)) {
          I.$assignMove(Pieces.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I)));
          continue;
        } else if ((End != null) && isa_CXXDefaultInitExpr(End)) {
          std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> Next = std.next(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I));
          if (Next.$noteq(E)) {
            {
              PathDiagnosticControlFlowPiece /*P*/ NextCF = dyn_cast_PathDiagnosticControlFlowPiece(Next.$star().$arrow());
              if ((NextCF != null)) {
                NextCF.setStartLocation(CF.getStartLocation());
              }
            }
          }
          I.$assignMove(Pieces.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I)));
          continue;
        }
      }
    }
    
    I.$postInc(0);
  }
}


/// Remove all pieces with invalid locations as these cannot be serialized.
/// We might have pieces with invalid locations as a result of inlining Body
/// Farm generated functions.
//<editor-fold defaultstate="collapsed" desc="removePiecesWithInvalidLocations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 288,
 FQN="removePiecesWithInvalidLocations", NM="_ZL32removePiecesWithInvalidLocationsRN5clang4ento10PathPiecesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL32removePiecesWithInvalidLocationsRN5clang4ento10PathPiecesE")
//</editor-fold>
public static void removePiecesWithInvalidLocations(final PathPieces /*&*/ Pieces) {
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = Pieces.begin(), E = Pieces.end(); I.$noteq(E);) {
    {
      PathDiagnosticCallPiece /*P*/ C = dyn_cast_PathDiagnosticCallPiece(I.$star().$arrow());
      if ((C != null)) {
        removePiecesWithInvalidLocations(C._path);
      }
    }
    {
      
      PathDiagnosticMacroPiece /*P*/ M = dyn_cast_PathDiagnosticMacroPiece(I.$star().$arrow());
      if ((M != null)) {
        removePiecesWithInvalidLocations(M.subPieces);
      }
    }
    if (!(I.$star()).$arrow().getLocation().isValid()
       || !(I.$star()).$arrow().getLocation().asLocation().isValid()) {
      I.$assignMove(Pieces.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I)));
      continue;
    }
    I.$postInc(0);
  }
}

//<editor-fold defaultstate="collapsed" desc="getEnclosingParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 403,
 FQN="getEnclosingParent", NM="_ZL18getEnclosingParentPKN5clang4StmtERKNS_9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL18getEnclosingParentPKN5clang4StmtERKNS_9ParentMapE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ getEnclosingParent(/*const*/ Stmt /*P*/ S, final /*const*/ ParentMap /*&*/ PM) {
  if (isa_Expr(S) && PM.isConsumedExpr_Expr$C$P(cast_Expr(S))) {
    return PM.getParentIgnoreParens_Stmt$C$P(S);
  }
  
  /*const*/ Stmt /*P*/ Parent = PM.getParentIgnoreParens_Stmt$C$P(S);
  if (!(Parent != null)) {
    return null;
  }
  switch (Parent.getStmtClass()) {
   case ForStmtClass:
   case DoStmtClass:
   case WhileStmtClass:
   case ObjCForCollectionStmtClass:
   case CXXForRangeStmtClass:
    return Parent;
   default:
    break;
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="getEnclosingStmtLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 425,
 FQN="getEnclosingStmtLocation", NM="_ZL24getEnclosingStmtLocationPKN5clang4StmtERNS_13SourceManagerERKNS_9ParentMapEPKNS_15LocationContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL24getEnclosingStmtLocationPKN5clang4StmtERNS_13SourceManagerERKNS_9ParentMapEPKNS_15LocationContextEb")
//</editor-fold>
public static PathDiagnosticLocation getEnclosingStmtLocation(/*const*/ Stmt /*P*/ S, final SourceManager /*&*/ SMgr, final /*const*/ ParentMap /*&*/ P, 
                        /*const*/ LocationContext /*P*/ LC, boolean allowNestedContexts) {
  if (!(S != null)) {
    return new PathDiagnosticLocation();
  }
  {
    
    /*const*/ Stmt /*P*/ Parent;
    while (((/*P*/ Parent = getEnclosingParent(S, P)) != null)) {
      switch (Parent.getStmtClass()) {
       case BinaryOperatorClass:
        {
          /*const*/ BinaryOperator /*P*/ B = cast_BinaryOperator(Parent);
          if (B.isLogicalOp()) {
            return new PathDiagnosticLocation(allowNestedContexts ? B : S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
          }
          break;
        }
       case CompoundStmtClass:
       case StmtExprClass:
        return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
       case ChooseExprClass:
        // Similar to '?' if we are referring to condition, just have the edge
        // point to the entire choose expression.
        if (allowNestedContexts || cast_ChooseExpr(Parent).getCond() == S) {
          return new PathDiagnosticLocation(Parent, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        } else {
          return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        }
       case BinaryConditionalOperatorClass:
       case ConditionalOperatorClass:
        // For '?', if we are referring to condition, just have the edge point
        // to the entire '?' expression.
        if (allowNestedContexts
           || cast_AbstractConditionalOperator(Parent).getCond() == S) {
          return new PathDiagnosticLocation(Parent, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        } else {
          return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        }
       case CXXForRangeStmtClass:
        if (cast_CXXForRangeStmt(Parent).getBody$Const() == S) {
          return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        }
        break;
       case DoStmtClass:
        return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
       case ForStmtClass:
        if (cast_ForStmt(Parent).getBody$Const() == S) {
          return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        }
        break;
       case IfStmtClass:
        if (cast_IfStmt(Parent).getCond$Const() != S) {
          return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        }
        break;
       case ObjCForCollectionStmtClass:
        if (cast_ObjCForCollectionStmt(Parent).getBody$Const() == S) {
          return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        }
        break;
       case WhileStmtClass:
        if (cast_WhileStmt(Parent).getCond$Const() != S) {
          return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
        }
        break;
       default:
        break;
      }
      
      S = Parent;
    }
  }
  assert ((S != null)) : "Cannot have null Stmt for PathDiagnosticLocation";
  
  return new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
}


//===----------------------------------------------------------------------===//
// "Visitors only" path diagnostic generation algorithm.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="GenerateVisitorsOnlyPathDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 502,
 FQN="GenerateVisitorsOnlyPathDiagnostic", NM="_ZL34GenerateVisitorsOnlyPathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeEN4llvm8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISC_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL34GenerateVisitorsOnlyPathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeEN4llvm8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISC_EEEE")
//</editor-fold>
public static boolean GenerateVisitorsOnlyPathDiagnostic(final PathDiagnostic /*&*/ PD, final PathDiagnosticBuilder /*&*/ PDB, /*const*/ ExplodedNode /*P*/ N, 
                                  ArrayRef<std.unique_ptr<BugReporterVisitor>> visitors) {
  // All path generation skips the very first node (the error node).
  // This is because there is special handling for the end-of-path note.
  N = N.getFirstPred$Const();
  if (!(N != null)) {
    return true;
  }
  
  BugReport /*P*/ R = PDB.getBugReport();
  {
    /*const*/ ExplodedNode /*P*/ Pred;
    while (((/*P*/ Pred = N.getFirstPred$Const()) != null)) {
      for (final /*constconst*/unique_ptr<BugReporterVisitor> /*&*/ V : visitors) {
        // Visit all the node pairs, but throw the path pieces away.
        PathDiagnosticPiece /*P*/ Piece = V.$arrow().VisitNode(N, Pred, PDB, $Deref(R));
        if (Piece != null) { Piece.$destroy();};
      }
      
      N = Pred;
    }
  }
  
  return R.isValid();
}

//<editor-fold defaultstate="collapsed" desc="updateStackPiecesWithMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 531,
 FQN="updateStackPiecesWithMessage", NM="_ZL28updateStackPiecesWithMessagePN5clang4ento19PathDiagnosticPieceERN4llvm11SmallVectorISt4pairIPNS0_23PathDiagnosticCallPieceEPKNS0_12ExplodedNodeEELj6EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL28updateStackPiecesWithMessagePN5clang4ento19PathDiagnosticPieceERN4llvm11SmallVectorISt4pairIPNS0_23PathDiagnosticCallPieceEPKNS0_12ExplodedNodeEELj6EEE")
//</editor-fold>
public static void updateStackPiecesWithMessage(PathDiagnosticPiece /*P*/ P, 
                            final SmallVector<std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >> /*&*/ CallStack) {
  {
    // If the piece contains a special message, add it to all the call
    // pieces on the active stack.
    PathDiagnosticEventPiece /*P*/ ep = dyn_cast_PathDiagnosticEventPiece(P);
    if ((ep != null)) {
      if (ep.hasCallStackHint()) {
        for (type$ptr<std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/ > I = $tryClone(CallStack.begin()), 
            /*P*/ E = $tryClone(CallStack.end()); $noteq_ptr(I, E); I.$preInc()) {
          PathDiagnosticCallPiece /*P*/ CP = I./*->*/$star().first;
          /*const*/ ExplodedNode /*P*/ N = I./*->*/$star().second;
          std.string stackMsg = ep.getCallStackMessage(N);
          
          // The last message on the path to final bug is the most important
          // one. Since we traverse the path backwards, do not add the message
          // if one has been previously added.
          if (!CP.hasCallStackMessage()) {
            CP.setCallStackMessage(new StringRef(stackMsg));
          }
        }
      }
    }
  }
}


/// CompactPathDiagnostic - This function postprocesses a PathDiagnostic object
///  and collapses PathDiagosticPieces that are expanded by macros.
//<editor-fold defaultstate="collapsed" desc="CompactPathDiagnostic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2961,
 FQN="CompactPathDiagnostic", NM="_ZL21CompactPathDiagnosticRN5clang4ento10PathPiecesERKNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL21CompactPathDiagnosticRN5clang4ento10PathPiecesERKNS_13SourceManagerE")
//</editor-fold>
public static void CompactPathDiagnostic(final PathPieces /*&*/ _path, final /*const*/ SourceManager /*&*/ SM) {
  std.vector<std.pairTypeType<IntrusiveRefCntPtr<PathDiagnosticMacroPiece>, SourceLocation>> MacroStack = null;
  std.vector<IntrusiveRefCntPtr<PathDiagnosticPiece>> Pieces = null;
  try {
    // JAVA: typedef std::vector<std::pair<IntrusiveRefCntPtr<PathDiagnosticMacroPiece>, SourceLocation> > MacroStackTy
//    final class MacroStackTy extends std.vector<std.pairTypeType<IntrusiveRefCntPtr<PathDiagnosticMacroPiece>, SourceLocation>>{ };
    
    // JAVA: typedef std::vector<IntrusiveRefCntPtr<PathDiagnosticPiece> > PiecesTy
//    final class PiecesTy extends std.vector<IntrusiveRefCntPtr<PathDiagnosticPiece>>{ };
    
    MacroStack/*J*/= new std.vector<std.pairTypeType<IntrusiveRefCntPtr<PathDiagnosticMacroPiece>, SourceLocation>>(new std.pairTypeType<IntrusiveRefCntPtr<PathDiagnosticMacroPiece>, SourceLocation>(new IntrusiveRefCntPtr<PathDiagnosticMacroPiece>(), new SourceLocation()));
    Pieces/*J*/= new std.vector<IntrusiveRefCntPtr<PathDiagnosticPiece>>(new IntrusiveRefCntPtr<PathDiagnosticPiece>());
    
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(_path.begin()), E = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(_path.end());
         I.$noteq(E); I.$preInc()) {
      IntrusiveRefCntPtr<PathDiagnosticMacroPiece> MacroGroup = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        
        PathDiagnosticPiece /*P*/ piece = I.$arrow().get();
        {
          
          // Recursively compact calls.
          PathDiagnosticCallPiece /*P*/ call = dyn_cast_PathDiagnosticCallPiece(piece);
          if ((call != null)) {
            CompactPathDiagnostic(call._path, SM);
          }
        }
        
        // Get the location of the PathDiagnosticPiece.
        /*const*/ FullSourceLoc Loc = piece.getLocation().asLocation();
        
        // Determine the instantiation location, which is the location we group
        // related PathDiagnosticPieces.
        SourceLocation InstantiationLoc = Loc.isMacroID() ? SM.getExpansionLoc(/*NO_COPY*/Loc) : new SourceLocation();
        if (Loc.isFileID()) {
          MacroStack.clear();
          Pieces.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(piece))); $c$.clean();
          continue;
        }
        assert (Loc.isMacroID());
        
        // Is the PathDiagnosticPiece within the same macro group?
        if (!MacroStack.empty() && $eq_SourceLocation$C(InstantiationLoc, MacroStack.back().second)) {
          MacroStack.back().first.$arrow().subPieces.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(piece))); $c$.clean();
          continue;
        }
        
        // We aren't in the same group.  Are we descending into a new macro
        // or are part of an old one?
        MacroGroup/*J*/= new IntrusiveRefCntPtr<PathDiagnosticMacroPiece>();
        
        SourceLocation ParentInstantiationLoc = InstantiationLoc.isMacroID() ? SM.getExpansionLoc(/*NO_COPY*/Loc) : new SourceLocation();
        
        // Walk the entire macro stack.
        while (!MacroStack.empty()) {
          if ($eq_SourceLocation$C(InstantiationLoc, MacroStack.back().second)) {
            $c$.clean(MacroGroup.$assign($c$.track(new IntrusiveRefCntPtr<PathDiagnosticMacroPiece>(MacroStack.back().first))));
            break;
          }
          if ($eq_SourceLocation$C(ParentInstantiationLoc, MacroStack.back().second)) {
            $c$.clean(MacroGroup.$assign($c$.track(new IntrusiveRefCntPtr<PathDiagnosticMacroPiece>(MacroStack.back().first))));
            break;
          }
          
          MacroStack.pop_back();
        }
        if (!MacroGroup.$bool() || $eq_SourceLocation$C(ParentInstantiationLoc, MacroStack.back().second)) {
          // Create a new macro group and add it to the stack.
          PathDiagnosticMacroPiece /*P*/ NewGroup = new PathDiagnosticMacroPiece(PathDiagnosticLocation.createSingleLocation(piece.getLocation()));
          if (MacroGroup.$bool()) {
            MacroGroup.$arrow().subPieces.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(NewGroup))); $c$.clean();
          } else {
            assert (InstantiationLoc.isFileID());
            Pieces.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(NewGroup))); $c$.clean();
          }
          
          $c$.clean(MacroGroup.$assign($c$.track(new IntrusiveRefCntPtr<PathDiagnosticMacroPiece>(NewGroup))));
          MacroStack.push_back_T$RR($c$.track(std.make_pair($Clone(MacroGroup), $Clone(InstantiationLoc)))); $c$.clean();
        }
        
        // Finally, add the PathDiagnosticPiece to the group.
        MacroGroup.$arrow().subPieces.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(piece))); $c$.clean();
      } finally {
        if (MacroGroup != null) { MacroGroup.$destroy(); }
        $c$.$destroy();
      }
    }
    
    // Now take the pieces and construct a new PathDiagnostic.
    _path.clear();
    
    _path.insert$T(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(_path.end()), Pieces.begin(), Pieces.end());
  } finally {
    if (Pieces != null) { Pieces.$destroy(); }
    if (MacroStack != null) { MacroStack.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="GenerateMinimalPathDiagnostic">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 556,
 FQN="GenerateMinimalPathDiagnostic", NM="_ZL29GenerateMinimalPathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL29GenerateMinimalPathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE")
//</editor-fold>
public static boolean GenerateMinimalPathDiagnostic(final PathDiagnostic /*&*/ PD, final PathDiagnosticBuilder /*&*/ PDB, /*const*/ ExplodedNode /*P*/ N, 
                             final DenseMap</*const*/ PathPieces /*P*/ , /*const*/ LocationContext /*P*/ > /*&*/ LCM, 
                             ArrayRef<std.unique_ptr<BugReporterVisitor>> visitors) {
  
  final SourceManager /*&*/ SMgr = PDB.getSourceManager();
  /*const*/ LocationContext /*P*/ LC = PDB.LC;
  /*const*/ ExplodedNode /*P*/ NextNode = N.pred_empty() ? null : (N.pred_begin$Const()).$star();
  
  SmallVector<std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >> CallStack/*J*/= new SmallVector<std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >>(6, new std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >());
  while ((NextNode != null)) {
    N = NextNode;
    PDB.LC = N.getLocationContext();
    NextNode = N.getFirstPred$Const();
    
    ProgramPoint P = N.getLocation();
    
    do {
      {
        Optional<CallExitEnd> CE = P.getAs(CallExitEnd.class);
        if (CE.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            PathDiagnosticCallPiece /*P*/ C = PathDiagnosticCallPiece.construct(N, CE.$star(), SMgr);
            // Record the mapping from call piece to LocationContext.
            LCM.$set($AddrOf(C._path), CE.$arrow().getCalleeContext());
            PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(C))); $c$.clean();
            PD.pushActivePath($AddrOf(C._path));
            CallStack.push_back(new std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >(JD$T$RR_T1$RR.INSTANCE, C, N));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
      {
        
        Optional<CallEnter> CE = P.getAs(CallEnter.class);
        if (CE.$bool()) {
          // Flush all locations, and pop the active path.
          boolean VisitedEntireCall = PD.isWithinCall();
          PD.popActivePath();
          
          // Either we just added a bunch of stuff to the top-level path, or
          // we have a previous CallExitEnd.  If the former, it means that the
          // path terminated within a function call.  We must then take the
          // current contents of the active path and place it within
          // a new PathDiagnosticCallPiece.
          PathDiagnosticCallPiece /*P*/ C;
          if (VisitedEntireCall) {
            C = cast_PathDiagnosticCallPiece(PD.getActivePath().front().$arrow());
          } else {
            /*const*/ Decl /*P*/ Caller = CE.$arrow().getLocationContext().getDecl();
            C = PathDiagnosticCallPiece.construct(PD.getActivePath(), Caller);
            // Record the mapping from call piece to LocationContext.
            LCM.$set($AddrOf(C._path), CE.$arrow().getCalleeContext());
          }
          
          C.setCallee(CE.$star(), SMgr);
          if (!CallStack.empty()) {
            assert (CallStack.back().first == C);
            CallStack.pop_back();
          }
          break;
        }
      }
      {
        
        Optional<BlockEdge> BE = P.getAs(BlockEdge.class);
        if (BE.$bool()) {
          /*const*/ CFGBlock /*P*/ Src = BE.$arrow().getSrc();
          /*const*/ CFGBlock /*P*/ Dst = BE.$arrow().getDst();
          /*const*/ Stmt /*P*/ T = Src.getTerminator$Const().$Stmt$C$P();
          if (!(T != null)) {
            break;
          }
          
          PathDiagnosticLocation Start = PathDiagnosticLocation.createBegin(T, SMgr, 
              new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, N.getLocationContext()));
          switch (T.getStmtClass()) {
           default:
            break;
           case GotoStmtClass:
           case IndirectGotoStmtClass:
            {
              raw_string_ostream os = null;
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                /*const*/ Stmt /*P*/ S = PathDiagnosticLocation.getNextStmt(N);
                if (!(S != null)) {
                  break;
                }
                
                std.string sbuf/*J*/= new std.string();
                os/*J*/= new raw_string_ostream(sbuf);
                final /*const*/ PathDiagnosticLocation /*&*/ End = PDB.getEnclosingStmtLocation(S);
                
                os.$out(/*KEEP_STR*/"Control jumps to line ").$out_uint(
                    End.asLocation().getExpansionLineNumber()
                );
                PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(os.str()))))); $c$.clean();
                break;
              } finally {
                if (os != null) { os.$destroy(); }
                $c$.$destroy();
              }
            }
           case SwitchStmtClass:
            {
              raw_string_ostream os = null;
              try {
                // Figure out what case arm we took.
                std.string sbuf/*J*/= new std.string();
                os/*J*/= new raw_string_ostream(sbuf);
                {
                  
                  /*const*/ Stmt /*P*/ S = Dst.getLabel$Const();
                  if ((S != null)) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      PathDiagnosticLocation End/*J*/= new PathDiagnosticLocation(S, SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
                      switch (S.getStmtClass()) {
                       default:
                        os.$out(/*KEEP_STR*/"No cases match in the switch statement. Control jumps to line ").$out_uint(
                            End.asLocation().getExpansionLineNumber()
                        );
                        break;
                       case DefaultStmtClass:
                        os.$out(/*KEEP_STR*/"Control jumps to the 'default' case at line ").$out_uint(
                            End.asLocation().getExpansionLineNumber()
                        );
                        break;
                       case CaseStmtClass:
                        {
                          os.$out(/*KEEP_STR*/"Control jumps to 'case ");
                          /*const*/ CaseStmt /*P*/ Case = cast_CaseStmt(S);
                          /*const*/ Expr /*P*/ LHS = Case.getLHS$Const().IgnoreParenCasts$Const();
                          
                          // Determine if it is an enum.
                          boolean GetRawInt = true;
                          {
                            
                            /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(LHS);
                            if ((DR != null)) {
                              // FIXME: Maybe this should be an assertion.  Are there cases
                              // were it is not an EnumConstantDecl?
                              /*const*/ EnumConstantDecl /*P*/ D = dyn_cast_EnumConstantDecl(DR.getDecl$Const());
                              if ((D != null)) {
                                GetRawInt = false;
                                $out_raw_ostream_NamedDecl$C(os, $Deref(D));
                              }
                            }
                          }
                          if (GetRawInt) {
                            $out_raw_ostream_APSInt$C(os, LHS.EvaluateKnownConstInt(PDB.getASTContext()));
                          }
                          
                          os.$out(/*KEEP_STR*/":'  at line ").$out_uint(
                              End.asLocation().getExpansionLineNumber()
                          );
                          break;
                        }
                      }
                      PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(os.str()))))); $c$.clean();
                    } finally {
                      $c$.$destroy();
                    }
                  } else {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      os.$out(/*KEEP_STR*/"'Default' branch taken. ");
                      final /*const*/ PathDiagnosticLocation /*&*/ End = PDB.ExecutionContinues(os, N);
                      PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(os.str()))))); $c$.clean();
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
                
                break;
              } finally {
                if (os != null) { os.$destroy(); }
              }
            }
           case BreakStmtClass:
           case ContinueStmtClass:
            {
              raw_string_ostream os = null;
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                std.string sbuf/*J*/= new std.string();
                os/*J*/= new raw_string_ostream(sbuf);
                PathDiagnosticLocation End = PDB.ExecutionContinues(os, N);
                PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(os.str()))))); $c$.clean();
                break;
              } finally {
                if (os != null) { os.$destroy(); }
                $c$.$destroy();
              }
            }
           case BinaryConditionalOperatorClass:
           case ConditionalOperatorClass:
            {
              raw_string_ostream os = null;
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                std.string sbuf/*J*/= new std.string();
                os/*J*/= new raw_string_ostream(sbuf);
                os.$out(/*KEEP_STR*/"'?' condition is ");
                if ((Src.succ_begin$Const().$add(1)).$star().$CFGBlock$P() == Dst) {
                  os.$out(/*KEEP_STR*/$false);
                } else {
                  os.$out(/*KEEP_STR*/$true);
                }
                
                PathDiagnosticLocation End = PDB.ExecutionContinues(N);
                {
                  
                  /*const*/ Stmt /*P*/ S = End.asStmt();
                  if ((S != null)) {
                    End.$assignMove(PDB.getEnclosingStmtLocation(S));
                  }
                }
                
                PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(os.str()))))); $c$.clean();
                break;
              } finally {
                if (os != null) { os.$destroy(); }
                $c$.$destroy();
              }
            }
           case BinaryOperatorClass:
            {
              raw_string_ostream os = null;
              try {
                if (!PDB.supportsLogicalOpControlFlow()) {
                  break;
                }
                
                /*const*/ BinaryOperator /*P*/ B = cast_BinaryOperator(T);
                std.string sbuf/*J*/= new std.string();
                os/*J*/= new raw_string_ostream(sbuf);
                os.$out(/*KEEP_STR*/"Left side of '");
                if (B.getOpcode() == BinaryOperatorKind.BO_LAnd) {
                  os.$out(/*KEEP_STR*/$AMP_AMP).$out(/*KEEP_STR*/"' is ");
                  if ((Src.succ_begin$Const().$add(1)).$star().$CFGBlock$P() == Dst) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      os.$out(/*KEEP_STR*/$false);
                      PathDiagnosticLocation End/*J*/= new PathDiagnosticLocation(B.getLHS(), SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
                      PathDiagnosticLocation Start$1 = PathDiagnosticLocation.createOperatorLoc(B, SMgr);
                      PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start$1, End, new StringRef(os.str()))))); $c$.clean();
                    } finally {
                      $c$.$destroy();
                    }
                  } else {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      os.$out(/*KEEP_STR*/$true);
                      PathDiagnosticLocation Start$1/*J*/= new PathDiagnosticLocation(B.getLHS(), SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
                      PathDiagnosticLocation End = PDB.ExecutionContinues(N);
                      PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start$1, End, new StringRef(os.str()))))); $c$.clean();
                    } finally {
                      $c$.$destroy();
                    }
                  }
                } else {
                  assert (B.getOpcode() == BinaryOperatorKind.BO_LOr);
                  os.$out(/*KEEP_STR*/$PIPE_PIPE).$out(/*KEEP_STR*/"' is ");
                  if ((Src.succ_begin$Const().$add(1)).$star().$CFGBlock$P() == Dst) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      os.$out(/*KEEP_STR*/$false);
                      PathDiagnosticLocation Start$1/*J*/= new PathDiagnosticLocation(B.getLHS(), SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
                      PathDiagnosticLocation End = PDB.ExecutionContinues(N);
                      PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start$1, End, new StringRef(os.str()))))); $c$.clean();
                    } finally {
                      $c$.$destroy();
                    }
                  } else {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      os.$out(/*KEEP_STR*/$true);
                      PathDiagnosticLocation End/*J*/= new PathDiagnosticLocation(B.getLHS(), SMgr, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
                      PathDiagnosticLocation Start$1 = PathDiagnosticLocation.createOperatorLoc(B, SMgr);
                      PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start$1, End, new StringRef(os.str()))))); $c$.clean();
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
                
                break;
              } finally {
                if (os != null) { os.$destroy(); }
              }
            }
           case DoStmtClass:
            {
              if ((Src.succ_begin$Const()).$star().$CFGBlock$P() == Dst) {
                raw_string_ostream os = null;
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  std.string sbuf/*J*/= new std.string();
                  os/*J*/= new raw_string_ostream(sbuf);
                  
                  os.$out(/*KEEP_STR*/"Loop condition is true. ");
                  PathDiagnosticLocation End = PDB.ExecutionContinues(os, N);
                  {
                    
                    /*const*/ Stmt /*P*/ S = End.asStmt();
                    if ((S != null)) {
                      End.$assignMove(PDB.getEnclosingStmtLocation(S));
                    }
                  }
                  
                  PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(os.str()))))); $c$.clean();
                } finally {
                  if (os != null) { os.$destroy(); }
                  $c$.$destroy();
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  PathDiagnosticLocation End = PDB.ExecutionContinues(N);
                  {
                    
                    /*const*/ Stmt /*P*/ S = End.asStmt();
                    if ((S != null)) {
                      End.$assignMove(PDB.getEnclosingStmtLocation(S));
                    }
                  }
                  
                  PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(/*KEEP_STR*/"Loop condition is false.  Exiting loop"))))); $c$.clean();
                } finally {
                  $c$.$destroy();
                }
              }
              
              break;
            }
           case WhileStmtClass:
           case ForStmtClass:
            {
              if ((Src.succ_begin$Const().$add(1)).$star().$CFGBlock$P() == Dst) {
                raw_string_ostream os = null;
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  std.string sbuf/*J*/= new std.string();
                  os/*J*/= new raw_string_ostream(sbuf);
                  
                  os.$out(/*KEEP_STR*/"Loop condition is false. ");
                  PathDiagnosticLocation End = PDB.ExecutionContinues(os, N);
                  {
                    /*const*/ Stmt /*P*/ S = End.asStmt();
                    if ((S != null)) {
                      End.$assignMove(PDB.getEnclosingStmtLocation(S));
                    }
                  }
                  
                  PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(os.str()))))); $c$.clean();
                } finally {
                  if (os != null) { os.$destroy(); }
                  $c$.$destroy();
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  PathDiagnosticLocation End = PDB.ExecutionContinues(N);
                  {
                    /*const*/ Stmt /*P*/ S = End.asStmt();
                    if ((S != null)) {
                      End.$assignMove(PDB.getEnclosingStmtLocation(S));
                    }
                  }
                  
                  PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(/*KEEP_STR*/"Loop condition is true.  Entering loop body"))))); $c$.clean();
                } finally {
                  $c$.$destroy();
                }
              }
              
              break;
            }
           case IfStmtClass:
            {
              PathDiagnosticLocation End = PDB.ExecutionContinues(N);
              {
                
                /*const*/ Stmt /*P*/ S = End.asStmt();
                if ((S != null)) {
                  End.$assignMove(PDB.getEnclosingStmtLocation(S));
                }
              }
              if ((Src.succ_begin$Const().$add(1)).$star().$CFGBlock$P() == Dst) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(/*KEEP_STR*/"Taking false branch"))))); $c$.clean();
                } finally {
                  $c$.$destroy();
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(Start, End, new StringRef(/*KEEP_STR*/"Taking true branch"))))); $c$.clean();
                } finally {
                  $c$.$destroy();
                }
              }
              
              break;
            }
          }
        }
      }
    } while (false);
    if ((NextNode != null)) {
      // Add diagnostic pieces from custom visitors.
      BugReport /*P*/ R = PDB.getBugReport();
      for (final /*constconst*/unique_ptr<BugReporterVisitor> /*&*/ V : visitors) {
        {
          PathDiagnosticPiece /*P*/ p = V.$arrow().VisitNode(N, NextNode, PDB, $Deref(R));
          if ((p != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(p))); $c$.clean();
              updateStackPiecesWithMessage(p, CallStack);
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  if (!PDB.getBugReport().isValid()) {
    return false;
  }
  
  // After constructing the full PathDiagnostic, do a pass over it to compact
  // PathDiagnosticPieces that occur within a macro.
  CompactPathDiagnostic(PD.getMutablePieces(), PDB.getSourceManager());
  return true;
}


//===----------------------------------------------------------------------===//
// "Extensive" PathDiagnostic generation.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="IsControlFlowExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 891,
 FQN="IsControlFlowExpr", NM="_ZL17IsControlFlowExprPKN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL17IsControlFlowExprPKN5clang4StmtE")
//</editor-fold>
public static boolean IsControlFlowExpr(/*const*/ Stmt /*P*/ S) {
  /*const*/ Expr /*P*/ E = dyn_cast_Expr(S);
  if (!(E != null)) {
    return false;
  }
  
  E = E.IgnoreParenCasts$Const();
  if (isa_AbstractConditionalOperator(E)) {
    return true;
  }
  {
    
    /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(E);
    if ((B != null)) {
      if (B.isLogicalOp()) {
        return true;
      }
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::cleanUpLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 920,
 FQN="(anonymous namespace)::cleanUpLocation", NM="_ZN12_GLOBAL__N_1L15cleanUpLocationEN5clang4ento22PathDiagnosticLocationEPKNS0_15LocationContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_1L15cleanUpLocationEN5clang4ento22PathDiagnosticLocationEPKNS0_15LocationContextEb")
//</editor-fold>
public static PathDiagnosticLocation cleanUpLocation(PathDiagnosticLocation L, 
               /*const*/ LocationContext /*P*/ LC) {
  return cleanUpLocation(L, 
               LC, 
               false);
}
public static PathDiagnosticLocation cleanUpLocation(PathDiagnosticLocation L, 
               /*const*/ LocationContext /*P*/ LC, 
               boolean firstCharOnly/*= false*/) {
  {
    /*const*/ Stmt /*P*/ S = L.asStmt();
    if ((S != null)) {
      /*const*/ Stmt /*P*/ Original = S;
      while (true) {
        // Adjust the location for some expressions that are best referenced
        // by one of their subexpressions.
        switch (S.getStmtClass()) {
         default:
          break;
         case ParenExprClass:
         case GenericSelectionExprClass:
          S = cast_Expr(S).IgnoreParens$Const();
          firstCharOnly = true;
          continue;
         case BinaryConditionalOperatorClass:
         case ConditionalOperatorClass:
          S = cast_AbstractConditionalOperator(S).getCond();
          firstCharOnly = true;
          continue;
         case ChooseExprClass:
          S = cast_ChooseExpr(S).getCond();
          firstCharOnly = true;
          continue;
         case BinaryOperatorClass:
          S = cast_BinaryOperator(S).getLHS();
          firstCharOnly = true;
          continue;
        }
        
        break;
      }
      if (S != Original) {
        L.$assignMove(new PathDiagnosticLocation(S, L.getManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC)));
      }
    }
  }
  if (firstCharOnly) {
    L.$assignMove(PathDiagnosticLocation.createSingleLocation(L));
  }
  
  return new PathDiagnosticLocation(JD$Move.INSTANCE, L);
}

//<editor-fold defaultstate="collapsed" desc="reversePropagateIntererstingSymbols">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1237,
 FQN="reversePropagateIntererstingSymbols", NM="_ZL35reversePropagateIntererstingSymbolsRN5clang4ento9BugReportERN4llvm8DenseSetIPKNS_4ExprENS3_12DenseMapInfoIS7_EEEEPKNS0_12ProgramStateES7_PKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL35reversePropagateIntererstingSymbolsRN5clang4ento9BugReportERN4llvm8DenseSetIPKNS_4ExprENS3_12DenseMapInfoIS7_EEEEPKNS0_12ProgramStateES7_PKNS_15LocationContextE")
//</editor-fold>
public static void reversePropagateIntererstingSymbols(final BugReport /*&*/ R, 
                                   final DenseSet</*const*/ Expr /*P*/ > /*&*/ IE, 
                                   /*const*/ ProgramState /*P*/ State, 
                                   /*const*/ Expr /*P*/ Ex, 
                                   /*const*/ LocationContext /*P*/ LCtx) {
  SVal V = State.getSVal(Ex, LCtx);
  if (!(R.isInteresting(new SVal(V)) || (IE.count(Ex) != 0))) {
    return;
  }
  switch (Ex.getStmtClass()) {
   default:
    if (!isa_CastExpr(Ex)) {
      break;
    }
   case BinaryOperatorClass:
   case UnaryOperatorClass:
    {
      for (/*const*/ Stmt /*P*/ SubStmt : Ex.children$Const()) {
        {
          /*const*/ Expr /*P*/ child = dyn_cast_or_null_Expr(SubStmt);
          if ((child != null)) {
            IE.insert(child);
            SVal ChildV = State.getSVal(child, LCtx);
            R.markInteresting(new SVal(ChildV));
          }
        }
      }
      break;
    }
  }
  
  R.markInteresting(new SVal(V));
}

//<editor-fold defaultstate="collapsed" desc="reversePropagateInterestingSymbols">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1267,
 FQN="reversePropagateInterestingSymbols", NM="_ZL34reversePropagateInterestingSymbolsRN5clang4ento9BugReportERN4llvm8DenseSetIPKNS_4ExprENS3_12DenseMapInfoIS7_EEEEPKNS0_12ProgramStateEPKNS_15LocationContextESH_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL34reversePropagateInterestingSymbolsRN5clang4ento9BugReportERN4llvm8DenseSetIPKNS_4ExprENS3_12DenseMapInfoIS7_EEEEPKNS0_12ProgramStateEPKNS_15LocationContextESH_")
//</editor-fold>
public static void reversePropagateInterestingSymbols(final BugReport /*&*/ R, 
                                  final DenseSet</*const*/ Expr /*P*/ > /*&*/ IE, 
                                  /*const*/ ProgramState /*P*/ State, 
                                  /*const*/ LocationContext /*P*/ CalleeCtx, 
                                  /*const*/ LocationContext /*P*/ CallerCtx) {
  // FIXME: Handle non-CallExpr-based CallEvents.
  /*const*/ StackFrameContext /*P*/ Callee = CalleeCtx.getCurrentStackFrame();
  /*const*/ Stmt /*P*/ CallSite = Callee.getCallSite();
  {
    /*const*/ CallExpr /*P*/ CE = dyn_cast_or_null_CallExpr(CallSite);
    if ((CE != null)) {
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CalleeCtx.getDecl());
        if ((FD != null)) {
          type$ptr<ParmVarDecl /*P*/ /*P*/> PI = $tryClone(FD.param_begin$Const());
          type$ptr<ParmVarDecl /*P*/ /*P*/> PE = $tryClone(FD.param_end$Const());
          Stmt.ConstExprIterator AI = CE.arg_begin$Const();
          Stmt.ConstExprIterator AE = CE.arg_end$Const();
          for (; AI.$noteq(AE) && $noteq_ptr(PI, PE); AI.$preInc() , PI.$preInc()) {
            {
              /*const*/ Expr /*P*/ ArgE = AI.$star();
              if ((ArgE != null)) {
                {
                  /*const*/ ParmVarDecl /*P*/ PD = PI.$star();
                  if ((PD != null)) {
                    Loc LV = State.getLValue(PD, CalleeCtx);
                    if (R.isInteresting(new SVal(LV)) || R.isInteresting(State.getRawSVal(new Loc(LV)))) {
                      IE.insert(ArgE);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


//===----------------------------------------------------------------------===//
// Functions for determining if a loop was executed 0 times.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="isLoop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1298,
 FQN="isLoop", NM="_ZL6isLoopPKN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL6isLoopPKN5clang4StmtE")
//</editor-fold>
public static boolean isLoop(/*const*/ Stmt /*P*/ Term) {
  switch (Term.getStmtClass()) {
   case ForStmtClass:
   case WhileStmtClass:
   case ObjCForCollectionStmtClass:
   case CXXForRangeStmtClass:
    return true;
   default:
    // Note that we intentionally do not include do..while here.
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="isJumpToFalseBranch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1311,
 FQN="isJumpToFalseBranch", NM="_ZL19isJumpToFalseBranchPKN5clang9BlockEdgeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL19isJumpToFalseBranchPKN5clang9BlockEdgeE")
//</editor-fold>
public static boolean isJumpToFalseBranch(/*const*/ BlockEdge /*P*/ BE) {
  /*const*/ CFGBlock /*P*/ Src = BE.getSrc();
  assert (Src.succ_size() == 2);
  return ((Src.succ_begin$Const().$add(1)).$star().$CFGBlock$P() == BE.getDst());
}


/// Return true if the terminator is a loop and the destination is the
/// false branch.
//<editor-fold defaultstate="collapsed" desc="isLoopJumpPastBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1319,
 FQN="isLoopJumpPastBody", NM="_ZL18isLoopJumpPastBodyPKN5clang4StmtEPKNS_9BlockEdgeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL18isLoopJumpPastBodyPKN5clang4StmtEPKNS_9BlockEdgeE")
//</editor-fold>
public static boolean isLoopJumpPastBody(/*const*/ Stmt /*P*/ Term, /*const*/ BlockEdge /*P*/ BE) {
  if (!isLoop(Term)) {
    return false;
  }
  
  // Did we take the false branch?
  return isJumpToFalseBranch(BE);
}

//<editor-fold defaultstate="collapsed" desc="isContainedByStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1327,
 FQN="isContainedByStmt", NM="_ZL17isContainedByStmtRN5clang9ParentMapEPKNS_4StmtES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL17isContainedByStmtRN5clang9ParentMapEPKNS_4StmtES4_")
//</editor-fold>
public static boolean isContainedByStmt(final ParentMap /*&*/ PM, /*const*/ Stmt /*P*/ S, /*const*/ Stmt /*P*/ SubS) {
  while ((SubS != null)) {
    if (SubS == S) {
      return true;
    }
    SubS = PM.getParent_Stmt$C$P(SubS);
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getStmtBeforeCond">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1336,
 FQN="getStmtBeforeCond", NM="_ZL17getStmtBeforeCondRN5clang9ParentMapEPKNS_4StmtEPKNS_4ento12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL17getStmtBeforeCondRN5clang9ParentMapEPKNS_4StmtEPKNS_4ento12ExplodedNodeE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ getStmtBeforeCond(final ParentMap /*&*/ PM, /*const*/ Stmt /*P*/ Term, 
                 /*const*/ ExplodedNode /*P*/ N) {
  while ((N != null)) {
    Optional<StmtPoint> SP = N.getLocation().getAs(StmtPoint.class);
    if (SP.$bool()) {
      /*const*/ Stmt /*P*/ S = SP.$arrow().getStmt();
      if (!isContainedByStmt(PM, Term, S)) {
        return S;
      }
    }
    N = N.getFirstPred$Const();
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="isInLoopBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1350,
 FQN="isInLoopBody", NM="_ZL12isInLoopBodyRN5clang9ParentMapEPKNS_4StmtES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL12isInLoopBodyRN5clang9ParentMapEPKNS_4StmtES4_")
//</editor-fold>
public static boolean isInLoopBody(final ParentMap /*&*/ PM, /*const*/ Stmt /*P*/ S, /*const*/ Stmt /*P*/ Term) {
  /*const*/ Stmt /*P*/ LoopBody = null;
  switch (Term.getStmtClass()) {
   case CXXForRangeStmtClass:
    {
      /*const*/ CXXForRangeStmt /*P*/ FR = cast_CXXForRangeStmt(Term);
      if (isContainedByStmt(PM, FR.getInc$Const(), S)) {
        return true;
      }
      if (isContainedByStmt(PM, FR.getLoopVarStmt$Const(), S)) {
        return true;
      }
      LoopBody = FR.getBody$Const();
      break;
    }
   case ForStmtClass:
    {
      /*const*/ ForStmt /*P*/ FS = cast_ForStmt(Term);
      if (isContainedByStmt(PM, FS.getInc$Const(), S)) {
        return true;
      }
      LoopBody = FS.getBody$Const();
      break;
    }
   case ObjCForCollectionStmtClass:
    {
      /*const*/ ObjCForCollectionStmt /*P*/ FC = cast_ObjCForCollectionStmt(Term);
      LoopBody = FC.getBody$Const();
      break;
    }
   case WhileStmtClass:
    LoopBody = cast_WhileStmt(Term).getBody$Const();
    break;
   default:
    return false;
  }
  return isContainedByStmt(PM, LoopBody, S);
}


//===----------------------------------------------------------------------===//
// Top-level logic for generating extensive path diagnostics.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="GenerateExtensivePathDiagnostic">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1387,
 FQN="GenerateExtensivePathDiagnostic", NM="_ZL31GenerateExtensivePathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL31GenerateExtensivePathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE")
//</editor-fold>
public static boolean GenerateExtensivePathDiagnostic(final PathDiagnostic /*&*/ PD, final PathDiagnosticBuilder /*&*/ PDB, /*const*/ ExplodedNode /*P*/ N, 
                               final DenseMap</*const*/ PathPieces /*P*/ , /*const*/ LocationContext /*P*/ > /*&*/ LCM, 
                               ArrayRef<std.unique_ptr<BugReporterVisitor>> visitors) {
  EdgeBuilder EB = null;
  try {
    EB/*J*/= new EdgeBuilder(PD, PDB);
    final /*const*/ SourceManager /*&*/ SM = PDB.getSourceManager();
    SmallVector<std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >> CallStack/*J*/= new SmallVector<std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >>(6, new std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >());
    DenseSet</*const*/ Expr /*P*/ > IE/*J*/= new DenseSet</*const*/ Expr /*P*/ >(DenseMapInfo$LikePtr.$Info());
    
    /*const*/ ExplodedNode /*P*/ NextNode = N.pred_empty() ? null : (N.pred_begin$Const()).$star();
    while ((NextNode != null)) {
      N = NextNode;
      NextNode = N.getFirstPred$Const();
      ProgramPoint P = N.getLocation();
      
      do {
        {
          Optional<org.clang.analysis.PostStmt> PS = P.getAs(org.clang.analysis.PostStmt.class);
          if (PS.$bool()) {
            {
              /*const*/ Expr /*P*/ Ex = PS.$arrow().<Expr>getStmtAs(Expr.class);
              if ((Ex != null)) {
                reversePropagateIntererstingSymbols($Deref(PDB.getBugReport()), IE, 
                    N.getState().get(), Ex, 
                    N.getLocationContext());
              }
            }
          }
        }
        {
          
          Optional<CallExitEnd> CE = P.getAs(CallExitEnd.class);
          if (CE.$bool()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              /*const*/ Stmt /*P*/ S = CE.$arrow().getCalleeContext().getCallSite();
              {
                /*const*/ Expr /*P*/ Ex = dyn_cast_or_null_Expr(S);
                if ((Ex != null)) {
                  reversePropagateIntererstingSymbols($Deref(PDB.getBugReport()), IE, 
                      N.getState().get(), Ex, 
                      N.getLocationContext());
                }
              }
              
              PathDiagnosticCallPiece /*P*/ C = PathDiagnosticCallPiece.construct(N, CE.$star(), SM);
              LCM.$set($AddrOf(C._path), CE.$arrow().getCalleeContext());
              
              EB.addEdge(new PathDiagnosticLocation(C.callReturn), /*AlwaysAdd=*/ true, /*IsPostJump=*/ true);
              EB.flushLocations();
              
              PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(C))); $c$.clean();
              PD.pushActivePath($AddrOf(C._path));
              CallStack.push_back(new std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >(JD$T$RR_T1$RR.INSTANCE, C, N));
              break;
            } finally {
              $c$.$destroy();
            }
          }
        }
        {
          
          // Pop the call hierarchy if we are done walking the contents
          // of a function call.
          Optional<CallEnter> CE = P.getAs(CallEnter.class);
          if (CE.$bool()) {
            // Add an edge to the start of the function.
            /*const*/ Decl /*P*/ D = CE.$arrow().getCalleeContext().getDecl();
            PathDiagnosticLocation pos = PathDiagnosticLocation.createBegin(D, SM);
            EB.addEdge(new PathDiagnosticLocation(pos));
            
            // Flush all locations, and pop the active path.
            boolean VisitedEntireCall = PD.isWithinCall();
            EB.flushLocations();
            PD.popActivePath();
            PDB.LC = N.getLocationContext();
            
            // Either we just added a bunch of stuff to the top-level path, or
            // we have a previous CallExitEnd.  If the former, it means that the
            // path terminated within a function call.  We must then take the
            // current contents of the active path and place it within
            // a new PathDiagnosticCallPiece.
            PathDiagnosticCallPiece /*P*/ C;
            if (VisitedEntireCall) {
              C = cast_PathDiagnosticCallPiece(PD.getActivePath().front().$arrow());
            } else {
              /*const*/ Decl /*P*/ Caller = CE.$arrow().getLocationContext().getDecl();
              C = PathDiagnosticCallPiece.construct(PD.getActivePath(), Caller);
              LCM.$set($AddrOf(C._path), CE.$arrow().getCalleeContext());
            }
            
            C.setCallee(CE.$star(), SM);
            EB.addContext(C.getLocation());
            if (!CallStack.empty()) {
              assert (CallStack.back().first == C);
              CallStack.pop_back();
            }
            break;
          }
        }
        
        // Note that is important that we update the LocationContext
        // after looking at CallExits.  CallExit basically adds an
        // edge in the *caller*, so we don't want to update the LocationContext
        // too soon.
        PDB.LC = N.getLocationContext();
        {
          
          // Block edges.
          Optional<BlockEdge> BE = P.getAs(BlockEdge.class);
          if (BE.$bool()) {
            // Does this represent entering a call?  If so, look at propagating
            // interesting symbols across call boundaries.
            if ((NextNode != null)) {
              /*const*/ LocationContext /*P*/ CallerCtx = NextNode.getLocationContext();
              /*const*/ LocationContext /*P*/ CalleeCtx = PDB.LC;
              if (CallerCtx != CalleeCtx) {
                reversePropagateInterestingSymbols($Deref(PDB.getBugReport()), IE, 
                    N.getState().get(), 
                    CalleeCtx, CallerCtx);
              }
            }
            {
              
              // Are we jumping to the head of a loop?  Add a special diagnostic.
              /*const*/ Stmt /*P*/ Loop = BE.$arrow().getSrc().getLoopTarget();
              if ((Loop != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation(Loop, SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, PDB.LC));
                  /*const*/ CompoundStmt /*P*/ CS = null;
                  {
                    
                    /*const*/ ForStmt /*P*/ FS = dyn_cast_ForStmt(Loop);
                    if ((FS != null)) {
                      CS = dyn_cast_CompoundStmt(FS.getBody$Const());
                    } else {
                      /*const*/ WhileStmt /*P*/ WS = dyn_cast_WhileStmt(Loop);
                      if ((WS != null)) {
                        CS = dyn_cast_CompoundStmt(WS.getBody$Const());
                      }
                    }
                  }
                  
                  PathDiagnosticEventPiece /*P*/ p = new PathDiagnosticEventPiece(L, 
                      new StringRef(/*KEEP_STR*/"Looping back to the head of the loop"));
                  p.setPrunable(true);
                  
                  EB.addEdge(p.getLocation(), true);
                  PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(p))); $c$.clean();
                  if ((CS != null)) {
                    PathDiagnosticLocation BL = PathDiagnosticLocation.createEndBrace(CS, SM);
                    EB.addEdge(new PathDiagnosticLocation(BL));
                  }
                } finally {
                  $c$.$destroy();
                }
              }
            }
            
            /*const*/ CFGBlock /*P*/ BSrc = BE.$arrow().getSrc();
            final ParentMap /*&*/ PM = PDB.getParentMap();
            {
              
              /*const*/ Stmt /*P*/ Term = BSrc.getTerminator$Const().$Stmt$C$P();
              if ((Term != null)) {
                // Are we jumping past the loop body without ever executing the
                // loop (because the condition was false)?
                if (isLoopJumpPastBody(Term, $AddrOf(BE.$star()))
                   && !isInLoopBody(PM, 
                    getStmtBeforeCond(PM, 
                        BSrc.getTerminatorCondition$Const(), 
                        N), 
                    Term)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation(Term, SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, PDB.LC));
                    PathDiagnosticEventPiece /*P*/ PE = new PathDiagnosticEventPiece(L, new StringRef(/*KEEP_STR*/"Loop body executed 0 times"));
                    PE.setPrunable(true);
                    
                    EB.addEdge(PE.getLocation(), true);
                    PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(PE))); $c$.clean();
                  } finally {
                    $c$.$destroy();
                  }
                }
                
                // In any case, add the terminator as the current statement
                // context for control edges.
                EB.addContext(Term);
              }
            }
            
            break;
          }
        }
        {
          
          Optional<BlockEntrance> BE = P.getAs(BlockEntrance.class);
          if (BE.$bool()) {
            Optional<CFGElement> First = BE.$arrow().getFirstElement();
            {
              Optional<CFGStmt> S = First.$bool() ? First.$arrow().getAs(CFGStmt.class) : new Optional<CFGStmt>(None);
              if (S.$bool()) {
                /*const*/ Stmt /*P*/ stmt = S.$arrow().getStmt();
                if (IsControlFlowExpr(stmt)) {
                  // Add the proper context for '&&', '||', and '?'.
                  EB.addContext(stmt);
                } else {
                  EB.addExtendedContext(PDB.getEnclosingStmtLocation(stmt).asStmt());
                }
              }
            }
            
            break;
          }
        }
      } while (false);
      if (!(NextNode != null)) {
        continue;
      }
      
      // Add pieces from custom visitors.
      BugReport /*P*/ R = PDB.getBugReport();
      for (final /*constconst*/unique_ptr<BugReporterVisitor> /*&*/ V : visitors) {
        {
          PathDiagnosticPiece /*P*/ p = V.$arrow().VisitNode(N, NextNode, PDB, $Deref(R));
          if ((p != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              final /*const*/ PathDiagnosticLocation /*&*/ Loc = p.getLocation();
              EB.addEdge(new PathDiagnosticLocation(Loc), true);
              PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(p))); $c$.clean();
              updateStackPiecesWithMessage(p, CallStack);
              {
                
                /*const*/ Stmt /*P*/ S = Loc.asStmt();
                if ((S != null)) {
                  EB.addExtendedContext(PDB.getEnclosingStmtLocation(S).asStmt());
                }
              }
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    return PDB.getBugReport().isValid();
  } finally {
    if (EB != null) { EB.$destroy(); }
  }
}


/// \brief Adds a sanitized control-flow diagnostic edge to a path.
//<editor-fold defaultstate="collapsed" desc="addEdgeToPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1584,
 FQN="addEdgeToPath", NM="_ZL13addEdgeToPathRN5clang4ento10PathPiecesERNS0_22PathDiagnosticLocationES3_PKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL13addEdgeToPathRN5clang4ento10PathPiecesERNS0_22PathDiagnosticLocationES3_PKNS_15LocationContextE")
//</editor-fold>
public static void addEdgeToPath(final PathPieces /*&*/ _path, 
             final PathDiagnosticLocation /*&*/ PrevLoc, 
             PathDiagnosticLocation NewLoc, 
             /*const*/ LocationContext /*P*/ LC) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!NewLoc.isValid()) {
      return;
    }
    
    SourceLocation NewLocL = new SourceLocation(JD$Move.INSTANCE, NewLoc.asLocation());
    if (NewLocL.isInvalid()) {
      return;
    }
    if (!PrevLoc.isValid() || !PrevLoc.asLocation().isValid()) {
      PrevLoc.$assign(NewLoc);
      return;
    }
    
    // Ignore self-edges, which occur when there are multiple nodes at the same
    // statement.
    if ((NewLoc.asStmt() != null) && NewLoc.asStmt() == PrevLoc.asStmt()) {
      return;
    }
    
    _path.push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(NewLoc, 
                PrevLoc)))); $c$.clean();
    PrevLoc.$assign(NewLoc);
  } finally {
    $c$.$destroy();
  }
}


/// A customized wrapper for CFGBlock::getTerminatorCondition()
/// which returns the element for ObjCForCollectionStmts.
//<editor-fold defaultstate="collapsed" desc="getTerminatorCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1612,
 FQN="getTerminatorCondition", NM="_ZL22getTerminatorConditionPKN5clang8CFGBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL22getTerminatorConditionPKN5clang8CFGBlockE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ getTerminatorCondition(/*const*/ CFGBlock /*P*/ B) {
  /*const*/ Stmt /*P*/ S = B.getTerminatorCondition$Const();
  {
    /*const*/ ObjCForCollectionStmt /*P*/ FS = dyn_cast_or_null_ObjCForCollectionStmt(S);
    if ((FS != null)) {
      return FS.getElement$Const();
    }
  }
  return S;
}

//<editor-fold defaultstate="collapsed" desc="StrEnteringLoop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1620,
 FQN="StrEnteringLoop", NM="_ZL15StrEnteringLoop",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL15StrEnteringLoop")
//</editor-fold>
public static /*const*//*char*/byte StrEnteringLoop[/*19*/] = new$char(19, "Entering loop body");
//<editor-fold defaultstate="collapsed" desc="StrLoopBodyZero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1621,
 FQN="StrLoopBodyZero", NM="_ZL15StrLoopBodyZero",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL15StrLoopBodyZero")
//</editor-fold>
public static /*const*//*char*/byte StrLoopBodyZero[/*27*/] = new$char(27, "Loop body executed 0 times");
//<editor-fold defaultstate="collapsed" desc="StrLoopRangeEmpty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1622,
 FQN="StrLoopRangeEmpty", NM="_ZL17StrLoopRangeEmpty",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL17StrLoopRangeEmpty")
//</editor-fold>
public static /*const*//*char*/byte StrLoopRangeEmpty[/*38*/] = new$char(38, "Loop body skipped when range is empty");
//<editor-fold defaultstate="collapsed" desc="StrLoopCollectionEmpty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1624,
 FQN="StrLoopCollectionEmpty", NM="_ZL22StrLoopCollectionEmpty",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL22StrLoopCollectionEmpty")
//</editor-fold>
public static /*const*//*char*/byte StrLoopCollectionEmpty[/*43*/] = new$char(43, "Loop body skipped when collection is empty");
//<editor-fold defaultstate="collapsed" desc="GenerateAlternateExtensivePathDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1627,
 FQN="GenerateAlternateExtensivePathDiagnostic", NM="_ZL40GenerateAlternateExtensivePathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL40GenerateAlternateExtensivePathDiagnosticRN5clang4ento14PathDiagnosticERN12_GLOBAL__N_121PathDiagnosticBuilderEPKNS0_12ExplodedNodeERN4llvm8DenseMapIPKNS0_10PathPiecesEPKNS_15LocationContextENS9_12DenseMapInfoISD_EENS9_6detail12DenseMapPairISD_SG_EEEENS9_8ArrayRefISt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteISQ_EEEE")
//</editor-fold>
public static boolean GenerateAlternateExtensivePathDiagnostic(final PathDiagnostic /*&*/ PD, final PathDiagnosticBuilder /*&*/ PDB, /*const*/ ExplodedNode /*P*/ N, 
                                        final DenseMap</*const*/ PathPieces /*P*/ , /*const*/ LocationContext /*P*/ > /*&*/ LCM, 
                                        ArrayRef<std.unique_ptr<BugReporterVisitor>> visitors) {
  
  BugReport /*P*/ report = PDB.getBugReport();
  final /*const*/ SourceManager /*&*/ SM = PDB.getSourceManager();
  SmallVector<std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >> CallStack/*J*/= new SmallVector<std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >>(6, new std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >());
  DenseSet</*const*/ Expr /*P*/ > IE/*J*/= new DenseSet</*const*/ Expr /*P*/ >(DenseMapInfo$LikePtr.$Info());
  
  PathDiagnosticLocation PrevLoc = PD.getLocation();
  
  /*const*/ ExplodedNode /*P*/ NextNode = N.getFirstPred$Const();
  while ((NextNode != null)) {
    N = NextNode;
    NextNode = N.getFirstPred$Const();
    ProgramPoint P = N.getLocation();
    
    do {
      {
        // Have we encountered an entrance to a call?  It may be
        // the case that we have not encountered a matching
        // call exit before this point.  This means that the path
        // terminated within the call itself.
        Optional<CallEnter> CE = P.getAs(CallEnter.class);
        if (CE.$bool()) {
          // Add an edge to the start of the function.
          /*const*/ StackFrameContext /*P*/ CalleeLC = CE.$arrow().getCalleeContext();
          /*const*/ Decl /*P*/ D = CalleeLC.getDecl();
          addEdgeToPath(PD.getActivePath(), PrevLoc, 
              PathDiagnosticLocation.createBegin(D, SM), 
              CalleeLC);
          
          // Did we visit an entire call?
          boolean VisitedEntireCall = PD.isWithinCall();
          PD.popActivePath();
          
          PathDiagnosticCallPiece /*P*/ C;
          if (VisitedEntireCall) {
            PathDiagnosticPiece /*P*/ P$1 = PD.getActivePath().front().get();
            C = cast_PathDiagnosticCallPiece(P$1);
          } else {
            /*const*/ Decl /*P*/ Caller = CE.$arrow().getLocationContext().getDecl();
            C = PathDiagnosticCallPiece.construct(PD.getActivePath(), Caller);
            
            // Since we just transferred the path over to the call piece,
            // reset the mapping from active to location context.
            assert (PD.getActivePath().size() == 1 && $eq_IntrusiveRefCntPtr$T$C_T1$P(PD.getActivePath().front(), C));
            LCM.$set($AddrOf(PD.getActivePath()), null);
            
            // Record the location context mapping for the path within
            // the call.
            assert (LCM.$at_T1$RR($AddrOf(C._path)) == null || LCM.$at_T1$RR($AddrOf(C._path)) == CE.$arrow().getCalleeContext());
            LCM.$set($AddrOf(C._path), CE.$arrow().getCalleeContext());
            
            // If this is the first item in the active path, record
            // the new mapping from active path to location context.
            final type$ref</*const*/ LocationContext /*P*/ /*&*/> NewLC = LCM.ref$at($AddrOf(PD.getActivePath()));
            if (!(NewLC.$deref() != null)) {
              NewLC.$set(N.getLocationContext());
            }
            
            PDB.LC = NewLC.$deref();
          }
          C.setCallee(CE.$star(), SM);
          
          // Update the previous location in the active path.
          PrevLoc.$assignMove(C.getLocation());
          if (!CallStack.empty()) {
            assert (CallStack.back().first == C);
            CallStack.pop_back();
          }
          break;
        }
      }
      
      // Query the location context here and the previous location
      // as processing CallEnter may change the active path.
      PDB.LC = N.getLocationContext();
      
      // Record the mapping from the active path to the location
      // context.
      assert (!(LCM.$at_T1$RR($AddrOf(PD.getActivePath())) != null) || LCM.$at_T1$RR($AddrOf(PD.getActivePath())) == PDB.LC);
      LCM.$set($AddrOf(PD.getActivePath()), PDB.LC);
      {
        
        // Have we encountered an exit from a function call?
        Optional<CallExitEnd> CE = P.getAs(CallExitEnd.class);
        if (CE.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/ Stmt /*P*/ S = CE.$arrow().getCalleeContext().getCallSite();
            {
              // Propagate the interesting symbols accordingly.
              /*const*/ Expr /*P*/ Ex = dyn_cast_or_null_Expr(S);
              if ((Ex != null)) {
                reversePropagateIntererstingSymbols($Deref(PDB.getBugReport()), IE, 
                    N.getState().get(), Ex, 
                    N.getLocationContext());
              }
            }
            
            // We are descending into a call (backwards).  Construct
            // a new call piece to contain the path pieces for that call.
            PathDiagnosticCallPiece /*P*/ C = PathDiagnosticCallPiece.construct(N, CE.$star(), SM);
            
            // Record the location context for this call piece.
            LCM.$set($AddrOf(C._path), CE.$arrow().getCalleeContext());
            
            // Add the edge to the return site.
            addEdgeToPath(PD.getActivePath(), PrevLoc, new PathDiagnosticLocation(C.callReturn), PDB.LC);
            PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(C))); $c$.clean();
            PrevLoc.invalidate();
            
            // Make the contents of the call the active path for now.
            PD.pushActivePath($AddrOf(C._path));
            CallStack.push_back(new std.pairPtrPtr<PathDiagnosticCallPiece /*P*/ , /*const*/ ExplodedNode /*P*/ >(JD$T$RR_T1$RR.INSTANCE, C, N));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
      {
        
        Optional<org.clang.analysis.PostStmt> PS = P.getAs(org.clang.analysis.PostStmt.class);
        if (PS.$bool()) {
          {
            // For expressions, make sure we propagate the
            // interesting symbols correctly.
            /*const*/ Expr /*P*/ Ex = PS.$arrow().<Expr>getStmtAs(Expr.class);
            if ((Ex != null)) {
              reversePropagateIntererstingSymbols($Deref(PDB.getBugReport()), IE, 
                  N.getState().get(), Ex, 
                  N.getLocationContext());
            }
          }
          
          // Add an edge.  If this is an ObjCForCollectionStmt do
          // not add an edge here as it appears in the CFG both
          // as a terminator and as a terminator condition.
          if (!isa_ObjCForCollectionStmt(PS.$arrow().getStmt())) {
            PathDiagnosticLocation L = new PathDiagnosticLocation(PS.$arrow().getStmt(), SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, PDB.LC));
            addEdgeToPath(PD.getActivePath(), PrevLoc, new PathDiagnosticLocation(L), PDB.LC);
          }
          break;
        }
      }
      {
        
        // Block edges.
        Optional<BlockEdge> BE = P.getAs(BlockEdge.class);
        if (BE.$bool()) {
          // Does this represent entering a call?  If so, look at propagating
          // interesting symbols across call boundaries.
          if ((NextNode != null)) {
            /*const*/ LocationContext /*P*/ CallerCtx = NextNode.getLocationContext();
            /*const*/ LocationContext /*P*/ CalleeCtx = PDB.LC;
            if (CallerCtx != CalleeCtx) {
              reversePropagateInterestingSymbols($Deref(PDB.getBugReport()), IE, 
                  N.getState().get(), 
                  CalleeCtx, CallerCtx);
            }
          }
          {
            
            // Are we jumping to the head of a loop?  Add a special diagnostic.
            /*const*/ Stmt /*P*/ Loop = BE.$arrow().getSrc().getLoopTarget();
            if ((Loop != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation(Loop, SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, PDB.LC));
                /*const*/ Stmt /*P*/ Body = null;
                {
                  
                  /*const*/ ForStmt /*P*/ FS = dyn_cast_ForStmt(Loop);
                  if ((FS != null)) {
                    Body = FS.getBody$Const();
                  } else {
                    /*const*/ WhileStmt /*P*/ WS = dyn_cast_WhileStmt(Loop);
                    if ((WS != null)) {
                      Body = WS.getBody$Const();
                    } else {
                      /*const*/ ObjCForCollectionStmt /*P*/ OFS = dyn_cast_ObjCForCollectionStmt(Loop);
                      if ((OFS != null)) {
                        Body = OFS.getBody$Const();
                      } else {
                        /*const*/ CXXForRangeStmt /*P*/ FRS = dyn_cast_CXXForRangeStmt(Loop);
                        if ((FRS != null)) {
                          Body = FRS.getBody$Const();
                        }
                      }
                    }
                  }
                }
                // do-while statements are explicitly excluded here
                PathDiagnosticEventPiece /*P*/ p = new PathDiagnosticEventPiece(L, new StringRef(/*KEEP_STR*/"Looping back to the head of the loop"));
                p.setPrunable(true);
                
                addEdgeToPath(PD.getActivePath(), PrevLoc, p.getLocation(), PDB.LC);
                PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(p))); $c$.clean();
                {
                  
                  /*const*/ CompoundStmt /*P*/ CS = dyn_cast_or_null_CompoundStmt(Body);
                  if ((CS != null)) {
                    addEdgeToPath(PD.getActivePath(), PrevLoc, 
                        PathDiagnosticLocation.createEndBrace(CS, SM), 
                        PDB.LC);
                  }
                }
              } finally {
                $c$.$destroy();
              }
            }
          }
          
          /*const*/ CFGBlock /*P*/ BSrc = BE.$arrow().getSrc();
          final ParentMap /*&*/ PM = PDB.getParentMap();
          {
            
            /*const*/ Stmt /*P*/ Term = BSrc.getTerminator$Const().$Stmt$C$P();
            if ((Term != null)) {
              // Are we jumping past the loop body without ever executing the
              // loop (because the condition was false)?
              if (isLoop(Term)) {
                /*const*/ Stmt /*P*/ TermCond = getTerminatorCondition(BSrc);
                boolean IsInLoopBody = isInLoopBody(PM, getStmtBeforeCond(PM, TermCond, N), Term);
                
                /*const*/char$ptr/*char P*/ str = null;
                if (isJumpToFalseBranch($AddrOf(BE.$star()))) {
                  if (!IsInLoopBody) {
                    if (isa_ObjCForCollectionStmt(Term)) {
                      str = create_char$ptr(StrLoopCollectionEmpty);
                    } else if (isa_CXXForRangeStmt(Term)) {
                      str = create_char$ptr(StrLoopRangeEmpty);
                    } else {
                      str = create_char$ptr(StrLoopBodyZero);
                    }
                  }
                } else {
                  str = create_char$ptr(StrEnteringLoop);
                }
                if (Native.$bool(str)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation((TermCond != null) ? TermCond : Term, SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, PDB.LC));
                    PathDiagnosticEventPiece /*P*/ PE = new PathDiagnosticEventPiece(L, new StringRef(str));
                    PE.setPrunable(true);
                    addEdgeToPath(PD.getActivePath(), PrevLoc, 
                        PE.getLocation(), PDB.LC);
                    PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(PE))); $c$.clean();
                  } finally {
                    $c$.$destroy();
                  }
                }
              } else if (isa_BreakStmt(Term) || isa_ContinueStmt(Term)
                 || isa_GotoStmt(Term)) {
                PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation(Term, SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, PDB.LC));
                addEdgeToPath(PD.getActivePath(), PrevLoc, new PathDiagnosticLocation(L), PDB.LC);
              }
            }
          }
          break;
        }
      }
    } while (false);
    if (!(NextNode != null)) {
      continue;
    }
    
    // Add pieces from custom visitors.
    for (final /*constconst*/unique_ptr<BugReporterVisitor> /*&*/ V : visitors) {
      {
        PathDiagnosticPiece /*P*/ p = V.$arrow().VisitNode(N, NextNode, PDB, $Deref(report));
        if ((p != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            addEdgeToPath(PD.getActivePath(), PrevLoc, p.getLocation(), PDB.LC);
            PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(p))); $c$.clean();
            updateStackPiecesWithMessage(p, CallStack);
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // Add an edge to the start of the function.
  // We'll prune it out later, but it helps make diagnostics more uniform.
  /*const*/ StackFrameContext /*P*/ CalleeLC = PDB.LC.getCurrentStackFrame();
  /*const*/ Decl /*P*/ D = CalleeLC.getDecl();
  addEdgeToPath(PD.getActivePath(), PrevLoc, 
      PathDiagnosticLocation.createBegin(D, SM), 
      CalleeLC);
  
  return report.isValid();
}

//<editor-fold defaultstate="collapsed" desc="getLocStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1877,
 FQN="getLocStmt", NM="_ZL10getLocStmtN5clang4ento22PathDiagnosticLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL10getLocStmtN5clang4ento22PathDiagnosticLocationE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ getLocStmt(PathDiagnosticLocation L) {
  if (!L.isValid()) {
    return null;
  }
  return L.asStmt();
}

//<editor-fold defaultstate="collapsed" desc="getStmtParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1883,
 FQN="getStmtParent", NM="_ZL13getStmtParentPKN5clang4StmtERKNS_9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL13getStmtParentPKN5clang4StmtERKNS_9ParentMapE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ getStmtParent(/*const*/ Stmt /*P*/ S, final /*const*/ ParentMap /*&*/ PM) {
  if (!(S != null)) {
    return null;
  }
  while (true) {
    S = PM.getParentIgnoreParens_Stmt$C$P(S);
    if (!(S != null)) {
      break;
    }
    if (isa_ExprWithCleanups(S)
       || isa_CXXBindTemporaryExpr(S)
       || isa_SubstNonTypeTemplateParmExpr(S)) {
      continue;
    }
    
    break;
  }
  
  return S;
}

//<editor-fold defaultstate="collapsed" desc="isConditionForTerminator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1904,
 FQN="isConditionForTerminator", NM="_ZL24isConditionForTerminatorPKN5clang4StmtES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL24isConditionForTerminatorPKN5clang4StmtES2_")
//</editor-fold>
public static boolean isConditionForTerminator(/*const*/ Stmt /*P*/ S, /*const*/ Stmt /*P*/ Cond) {
  switch (S.getStmtClass()) {
   case BinaryOperatorClass:
    {
      /*const*/ BinaryOperator /*P*/ BO = cast_BinaryOperator(S);
      if (!BO.isLogicalOp()) {
        return false;
      }
      return BO.getLHS() == Cond || BO.getRHS() == Cond;
    }
   case IfStmtClass:
    return cast_IfStmt(S).getCond$Const() == Cond;
   case ForStmtClass:
    return cast_ForStmt(S).getCond$Const() == Cond;
   case WhileStmtClass:
    return cast_WhileStmt(S).getCond$Const() == Cond;
   case DoStmtClass:
    return cast_DoStmt(S).getCond$Const() == Cond;
   case ChooseExprClass:
    return cast_ChooseExpr(S).getCond() == Cond;
   case IndirectGotoStmtClass:
    return cast_IndirectGotoStmt(S).getTarget$Const() == Cond;
   case SwitchStmtClass:
    return cast_SwitchStmt(S).getCond$Const() == Cond;
   case BinaryConditionalOperatorClass:
    return cast_BinaryConditionalOperator(S).getCond() == Cond;
   case ConditionalOperatorClass:
    {
      /*const*/ ConditionalOperator /*P*/ CO = cast_ConditionalOperator(S);
      return CO.getCond() == Cond
         || CO.getLHS() == Cond
         || CO.getRHS() == Cond;
    }
   case ObjCForCollectionStmtClass:
    return cast_ObjCForCollectionStmt(S).getElement$Const() == Cond;
   case CXXForRangeStmtClass:
    {
      /*const*/ CXXForRangeStmt /*P*/ FRS = cast_CXXForRangeStmt(S);
      return FRS.getCond$Const() == Cond || FRS.getRangeInit$Const() == Cond;
    }
   default:
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="isIncrementOrInitInForLoop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1945,
 FQN="isIncrementOrInitInForLoop", NM="_ZL26isIncrementOrInitInForLoopPKN5clang4StmtES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL26isIncrementOrInitInForLoopPKN5clang4StmtES2_")
//</editor-fold>
public static boolean isIncrementOrInitInForLoop(/*const*/ Stmt /*P*/ S, /*const*/ Stmt /*P*/ FL) {
  {
    /*const*/ ForStmt /*P*/ FS = dyn_cast_ForStmt(FL);
    if ((FS != null)) {
      return FS.getInc$Const() == S || FS.getInit$Const() == S;
    }
  }
  {
    /*const*/ CXXForRangeStmt /*P*/ FRS = dyn_cast_CXXForRangeStmt(FL);
    if ((FRS != null)) {
      return FRS.getInc$Const() == S || FRS.getRangeStmt$Const() == S
         || (FRS.getLoopVarStmt$Const() != null) || FRS.getRangeInit$Const() == S;
    }
  }
  return false;
}


/// Adds synthetic edges from top-level statements to their subexpressions.
///
/// This avoids a "swoosh" effect, where an edge from a top-level statement A
/// points to a sub-expression B.1 that's not at the start of B. In these cases,
/// we'd like to see an edge from A to B, then another one from B to B.1.
//<editor-fold defaultstate="collapsed" desc="addContextEdges">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1962,
 FQN="addContextEdges", NM="_ZL15addContextEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERKNS_9ParentMapEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL15addContextEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERKNS_9ParentMapEPKNS_15LocationContextE")
//</editor-fold>
public static void addContextEdges(final PathPieces /*&*/ pieces, final SourceManager /*&*/ SM, 
               final /*const*/ ParentMap /*&*/ PM, /*const*/ LocationContext /*P*/ LCtx) {
  std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> Prev = pieces.end();
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = pieces.begin(), E = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(Prev); I.$noteq(E);
       Prev.$assign(I) , I.$preInc()) {
    PathDiagnosticControlFlowPiece /*P*/ Piece = dyn_cast_PathDiagnosticControlFlowPiece(I.$star().$arrow());
    if (!(Piece != null)) {
      continue;
    }
    
    PathDiagnosticLocation SrcLoc = Piece.getStartLocation();
    SmallVector<PathDiagnosticLocation> SrcContexts/*J*/= new SmallVector<PathDiagnosticLocation>(4, new PathDiagnosticLocation());
    
    PathDiagnosticLocation NextSrcContext = new PathDiagnosticLocation(SrcLoc);
    /*const*/ Stmt /*P*/ InnerStmt = null;
    while (NextSrcContext.isValid() && NextSrcContext.asStmt() != InnerStmt) {
      SrcContexts.push_back(NextSrcContext);
      InnerStmt = NextSrcContext.asStmt();
      NextSrcContext.$assignMove(getEnclosingStmtLocation(InnerStmt, SM, PM, LCtx, 
              /*allowNested=*/ true));
    }
    
    // Repeatedly split the edge as necessary.
    // This is important for nested logical expressions (||, &&, ?:) where we
    // want to show all the levels of context.
    while (true) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ Stmt /*P*/ Dst = getLocStmt(Piece.getEndLocation());
        
        // We are looking at an edge. Is the destination within a larger
        // expression?
        PathDiagnosticLocation DstContext = getEnclosingStmtLocation(Dst, SM, PM, LCtx, /*allowNested=*/ true);
        if (!DstContext.isValid() || DstContext.asStmt() == Dst) {
          break;
        }
        
        // If the source is in the same context, we're already good.
        if (std.find(SrcContexts.begin(), SrcContexts.end(), DstContext)
           .$noteq(SrcContexts.end())) {
          break;
        }
        
        // Update the subexpression node to point to the context edge.
        Piece.setStartLocation(DstContext);
        
        // Try to extend the previous edge if it's at the same level as the source
        // context.
        if (Prev.$noteq(E)) {
          PathDiagnosticControlFlowPiece /*P*/ PrevPiece = dyn_cast_PathDiagnosticControlFlowPiece(Prev.$star().$arrow());
          if ((PrevPiece != null)) {
            {
              /*const*/ Stmt /*P*/ PrevSrc = getLocStmt(PrevPiece.getStartLocation());
              if ((PrevSrc != null)) {
                /*const*/ Stmt /*P*/ PrevSrcParent = getStmtParent(PrevSrc, PM);
                if (PrevSrcParent == getStmtParent(getLocStmt(new PathDiagnosticLocation(DstContext)), PM)) {
                  PrevPiece.setEndLocation(DstContext);
                  break;
                }
              }
            }
          }
        }
        
        // Otherwise, split the current edge into a context edge and a
        // subexpression edge. Note that the context statement may itself have
        // context.
        Piece = new PathDiagnosticControlFlowPiece(SrcLoc, DstContext);
        $c$.clean(I.$assignMove(pieces.insert__List_const_iterator$_Tp_T$RR(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I), $c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(Piece)))));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// \brief Move edges from a branch condition to a branch target
///        when the condition is simple.
///
/// This restructures some of the work of addContextEdges.  That function
/// creates edges this may destroy, but they work together to create a more
/// aesthetically set of edges around branches.  After the call to
/// addContextEdges, we may have (1) an edge to the branch, (2) an edge from
/// the branch to the branch condition, and (3) an edge from the branch
/// condition to the branch target.  We keep (1), but may wish to remove (2)
/// and move the source of (3) to the branch if the branch condition is simple.
///
//<editor-fold defaultstate="collapsed" desc="simplifySimpleBranches">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2043,
 FQN="simplifySimpleBranches", NM="_ZL22simplifySimpleBranchesRN5clang4ento10PathPiecesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL22simplifySimpleBranchesRN5clang4ento10PathPiecesE")
//</editor-fold>
public static void simplifySimpleBranches(final PathPieces /*&*/ pieces) {
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = pieces.begin(), E = pieces.end(); I.$noteq(E); I.$preInc()) {
    
    PathDiagnosticControlFlowPiece /*P*/ PieceI = dyn_cast_PathDiagnosticControlFlowPiece(I.$star().$arrow());
    if (!(PieceI != null)) {
      continue;
    }
    
    /*const*/ Stmt /*P*/ s1Start = getLocStmt(PieceI.getStartLocation());
    /*const*/ Stmt /*P*/ s1End = getLocStmt(PieceI.getEndLocation());
    if (!(s1Start != null) || !(s1End != null)) {
      continue;
    }
    
    std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> NextI = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I);
    NextI.$preInc();
    if (NextI.$eq(E)) {
      break;
    }
    
    PathDiagnosticControlFlowPiece /*P*/ PieceNextI = null;
    while (true) {
      if (NextI.$eq(E)) {
        break;
      }
      
      PathDiagnosticEventPiece /*P*/ EV = dyn_cast_PathDiagnosticEventPiece(NextI.$star().$arrow());
      if ((EV != null)) {
        StringRef S = EV.getString();
        if ($eq_StringRef(/*NO_COPY*/S, /*STRINGREF_STR*/StrEnteringLoop) || $eq_StringRef(/*NO_COPY*/S, /*STRINGREF_STR*/StrLoopBodyZero)
           || $eq_StringRef(/*NO_COPY*/S, /*STRINGREF_STR*/StrLoopCollectionEmpty) || $eq_StringRef(/*NO_COPY*/S, /*STRINGREF_STR*/StrLoopRangeEmpty)) {
          NextI.$preInc();
          continue;
        }
        break;
      }
      
      PieceNextI = dyn_cast_PathDiagnosticControlFlowPiece(NextI.$star().$arrow());
      break;
    }
    if (!(PieceNextI != null)) {
      continue;
    }
    
    /*const*/ Stmt /*P*/ s2Start = getLocStmt(PieceNextI.getStartLocation());
    /*const*/ Stmt /*P*/ s2End = getLocStmt(PieceNextI.getEndLocation());
    if (!(s2Start != null) || !(s2End != null) || s1End != s2Start) {
      continue;
    }
    
    // We only perform this transformation for specific branch kinds.
    // We don't want to do this for do..while, for example.
    if (!(isa_ForStmt(s1Start) || isa_WhileStmt(s1Start)
       || isa_IfStmt(s1Start) || isa_ObjCForCollectionStmt(s1Start)
       || isa_CXXForRangeStmt(s1Start))) {
      continue;
    }
    
    // Is s1End the branch condition?
    if (!isConditionForTerminator(s1Start, s1End)) {
      continue;
    }
    
    // Perform the hoisting by eliminating (2) and changing the start
    // location of (3).
    PieceNextI.setStartLocation(PieceI.getStartLocation());
    I.$assignMove(pieces.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I)));
  }
}


/// Returns the number of bytes in the given (character-based) SourceRange.
///
/// If the locations in the range are not on the same line, returns None.
///
/// Note that this does not do a precise user-visible character or column count.
//<editor-fold defaultstate="collapsed" desc="getLengthOnSingleLine">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2115,
 FQN="getLengthOnSingleLine", NM="_ZL21getLengthOnSingleLineRN5clang13SourceManagerENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL21getLengthOnSingleLineRN5clang13SourceManagerENS_11SourceRangeE")
//</editor-fold>
public static OptionalUInt getLengthOnSingleLine(final SourceManager /*&*/ SM, 
                     SourceRange Range) {
  SourceRange ExpansionRange/*J*/= new SourceRange(SM.getExpansionLoc(Range.getBegin()), 
      /*NO_COPY*/SM.getExpansionRange(Range.getEnd()).second);
  
  FileID FID = SM.getFileID(ExpansionRange.getBegin());
  if (FID.$noteq(SM.getFileID(ExpansionRange.getEnd()))) {
    return new OptionalUInt(None);
  }
  
  // JAVA PERF
  bool$ptr Invalid = null;//create_bool$ptr();
  /*const*/ MemoryBuffer /*P*/ Buffer = SM.getBuffer(/*NO_COPY*/FID, /*$AddrOf*/(Invalid));
//  if (Invalid.$star()) {
  if (Buffer.isInvalid()) {
    return new OptionalUInt(None);
  }
  
  /*uint*/int BeginOffset = SM.getFileOffset(ExpansionRange.getBegin());
  /*uint*/int EndOffset = SM.getFileOffset(ExpansionRange.getEnd());
  StringRef Snippet = Buffer.getBuffer().slice(BeginOffset, EndOffset);
  
  // We're searching the raw bytes of the buffer here, which might include
  // escaped newlines and such. That's okay; we're trying to decide whether the
  // SourceRange is covering a large or small amount of space in the user's
  // editor.
  if (Snippet.find_first_of(/*STRINGREF_STR*/"\015\n") != StringRef.npos) {
    return new OptionalUInt(None);
  }
  
  // This isn't Unicode-aware, but it doesn't need to be.
  return new OptionalUInt(JD$T$RR.INSTANCE, Snippet.size());
}


/// \sa getLengthOnSingleLine(SourceManager, SourceRange)
//<editor-fold defaultstate="collapsed" desc="getLengthOnSingleLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2145,
 FQN="getLengthOnSingleLine", NM="_ZL21getLengthOnSingleLineRN5clang13SourceManagerEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL21getLengthOnSingleLineRN5clang13SourceManagerEPKNS_4StmtE")
//</editor-fold>
public static OptionalUInt getLengthOnSingleLine(final SourceManager /*&*/ SM, 
                     /*const*/ Stmt /*P*/ S) {
  return getLengthOnSingleLine(SM, S.getSourceRange());
}


/// Eliminate two-edge cycles created by addContextEdges().
///
/// Once all the context edges are in place, there are plenty of cases where
/// there's a single edge from a top-level statement to a subexpression,
/// followed by a single path note, and then a reverse edge to get back out to
/// the top level. If the statement is simple enough, the subexpression edges
/// just add noise and make it harder to understand what's going on.
///
/// This function only removes edges in pairs, because removing only one edge
/// might leave other edges dangling.
///
/// This will not remove edges in more complicated situations:
/// - if there is more than one "hop" leading to or from a subexpression.
/// - if there is an inlined call between the edges instead of a single event.
/// - if the whole statement is large enough that having subexpression arrows
///   might be helpful.
//<editor-fold defaultstate="collapsed" desc="removeContextCycles">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2166,
 FQN="removeContextCycles", NM="_ZL19removeContextCyclesRN5clang4ento10PathPiecesERNS_13SourceManagerERNS_9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL19removeContextCyclesRN5clang4ento10PathPiecesERNS_13SourceManagerERNS_9ParentMapE")
//</editor-fold>
public static void removeContextCycles(final PathPieces /*&*/ Path, final SourceManager /*&*/ SM, 
                   final ParentMap /*&*/ PM) {
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = Path.begin(), E = Path.end(); I.$noteq(E);) {
    // Pattern match the current piece and its successor.
    PathDiagnosticControlFlowPiece /*P*/ PieceI = dyn_cast_PathDiagnosticControlFlowPiece(I.$star().$arrow());
    if (!(PieceI != null)) {
      I.$preInc();
      continue;
    }
    
    /*const*/ Stmt /*P*/ s1Start = getLocStmt(PieceI.getStartLocation());
    /*const*/ Stmt /*P*/ s1End = getLocStmt(PieceI.getEndLocation());
    
    std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> NextI = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I);
    NextI.$preInc();
    if (NextI.$eq(E)) {
      break;
    }
    
    PathDiagnosticControlFlowPiece /*P*/ PieceNextI = dyn_cast_PathDiagnosticControlFlowPiece(NextI.$star().$arrow());
    if (!(PieceNextI != null)) {
      if (isa_PathDiagnosticEventPiece(NextI.$star().$arrow())) {
        NextI.$preInc();
        if (NextI.$eq(E)) {
          break;
        }
        PieceNextI = dyn_cast_PathDiagnosticControlFlowPiece(NextI.$star().$arrow());
      }
      if (!(PieceNextI != null)) {
        I.$preInc();
        continue;
      }
    }
    
    /*const*/ Stmt /*P*/ s2Start = getLocStmt(PieceNextI.getStartLocation());
    /*const*/ Stmt /*P*/ s2End = getLocStmt(PieceNextI.getEndLocation());
    if ((s1Start != null) && (s2Start != null) && s1Start == s2End && s2Start == s1End) {
      /*const*//*size_t*/int MAX_SHORT_LINE_LENGTH = 80;
      OptionalUInt s1Length = getLengthOnSingleLine(SM, s1Start);
      if (s1Length.$bool() && $lesseq_uint(s1Length.$star(), MAX_SHORT_LINE_LENGTH)) {
        OptionalUInt s2Length = getLengthOnSingleLine(SM, s2Start);
        if (s2Length.$bool() && $lesseq_uint(s2Length.$star(), MAX_SHORT_LINE_LENGTH)) {
          Path.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I));
          I.$assignMove(Path.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(NextI)));
          continue;
        }
      }
    }
    
    I.$preInc();
  }
}


/// \brief Return true if X is contained by Y.
//<editor-fold defaultstate="collapsed" desc="lexicalContains">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2223,
 FQN="lexicalContains", NM="_ZL15lexicalContainsRN5clang9ParentMapEPKNS_4StmtES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL15lexicalContainsRN5clang9ParentMapEPKNS_4StmtES4_")
//</editor-fold>
public static boolean lexicalContains(final ParentMap /*&*/ PM, 
               /*const*/ Stmt /*P*/ X, 
               /*const*/ Stmt /*P*/ Y) {
  while ((X != null)) {
    if (X == Y) {
      return true;
    }
    X = PM.getParent_Stmt$C$P(X);
  }
  return false;
}


// Remove short edges on the same line less than 3 columns in difference.
//<editor-fold defaultstate="collapsed" desc="removePunyEdges">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2235,
 FQN="removePunyEdges", NM="_ZL15removePunyEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERNS_9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL15removePunyEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERNS_9ParentMapE")
//</editor-fold>
public static void removePunyEdges(final PathPieces /*&*/ _path, 
               final SourceManager /*&*/ SM, 
               final ParentMap /*&*/ PM) {
  
  boolean erased = false;

  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = _path.begin(), E = _path.end(); I.$noteq(E);
       /*JAVA for compilation*/I = (erased ? I : I.$preInc())) {
    
    erased = false;
    
    PathDiagnosticControlFlowPiece /*P*/ PieceI = dyn_cast_PathDiagnosticControlFlowPiece(I.$star().$arrow());
    if (!(PieceI != null)) {
      continue;
    }
    
    /*const*/ Stmt /*P*/ start = getLocStmt(PieceI.getStartLocation());
    /*const*/ Stmt /*P*/ end = getLocStmt(PieceI.getEndLocation());
    if (!(start != null) || !(end != null)) {
      continue;
    }
    
    /*const*/ Stmt /*P*/ endParent = PM.getParent_Stmt$C$P(end);
    if (!(endParent != null)) {
      continue;
    }
    if (isConditionForTerminator(end, endParent)) {
      continue;
    }
    
    SourceLocation FirstLoc = start.getLocStart();
    SourceLocation SecondLoc = end.getLocStart();
    if (!SM.isWrittenInSameFile(/*NO_COPY*/FirstLoc, /*NO_COPY*/SecondLoc)) {
      continue;
    }
    if (SM.isBeforeInTranslationUnit(/*NO_COPY*/SecondLoc, /*NO_COPY*/FirstLoc)) {
      std.swap(SecondLoc, FirstLoc);
    }
    
    SourceRange EdgeRange/*J*/= new SourceRange(/*NO_COPY*/FirstLoc, /*NO_COPY*/SecondLoc);
    OptionalUInt ByteWidth = getLengthOnSingleLine(SM, new SourceRange(EdgeRange));
    
    // If the statements are on different lines, continue.
    if (!ByteWidth.$bool()) {
      continue;
    }
    
    /*const*//*size_t*/int MAX_PUNY_EDGE_LENGTH = 2;
    if ($lesseq_uint(ByteWidth.$star(), MAX_PUNY_EDGE_LENGTH)) {
      // FIXME: There are enough /bytes/ between the endpoints of the edge, but
      // there might not be enough /columns/. A proper user-visible column count
      // is probably too expensive, though.
      I.$assignMove(_path.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I)));
      erased = true;
      continue;
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="removeIdenticalEvents">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2292,
 FQN="removeIdenticalEvents", NM="_ZL21removeIdenticalEventsRN5clang4ento10PathPiecesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL21removeIdenticalEventsRN5clang4ento10PathPiecesE")
//</editor-fold>
public static void removeIdenticalEvents(final PathPieces /*&*/ _path) {
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = _path.begin(), E = _path.end(); I.$noteq(E); I.$preInc()) {
    PathDiagnosticEventPiece /*P*/ PieceI = dyn_cast_PathDiagnosticEventPiece(I.$star().$arrow());
    if (!(PieceI != null)) {
      continue;
    }
    
    std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> NextI = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I);
    NextI.$preInc();
    if (NextI.$eq(E)) {
      return;
    }
    
    PathDiagnosticEventPiece /*P*/ PieceNextI = dyn_cast_PathDiagnosticEventPiece(NextI.$star().$arrow());
    if (!(PieceNextI != null)) {
      continue;
    }
    
    // Erase the second piece if it has the same exact message text.
    if ($eq_StringRef(PieceI.getString(), PieceNextI.getString())) {
      _path.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(NextI));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="optimizeEdges">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2317,
 FQN="optimizeEdges", NM="_ZL13optimizeEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERN4llvm8DenseSetIPKNS0_23PathDiagnosticCallPieceENS5_12DenseMapInfoIS9_EEEERNS5_8DenseMapIPKS1_PKNS_15LocationContextENSA_ISG_EENS5_6detail12DenseMapPairISG_SJ_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL13optimizeEdgesRN5clang4ento10PathPiecesERNS_13SourceManagerERN4llvm8DenseSetIPKNS0_23PathDiagnosticCallPieceENS5_12DenseMapInfoIS9_EEEERNS5_8DenseMapIPKS1_PKNS_15LocationContextENSA_ISG_EENS5_6detail12DenseMapPairISG_SJ_EEEE")
//</editor-fold>
public static boolean optimizeEdges(final PathPieces /*&*/ _path, final SourceManager /*&*/ SM, 
             final DenseSet</*const*/ PathDiagnosticCallPiece /*P*/ > /*&*/ OCS, 
             final DenseMap</*const*/ PathPieces /*P*/ , /*const*/ LocationContext /*P*/ > /*&*/ LCM) {
  boolean hasChanges = false;
  /*const*/ LocationContext /*P*/ LC = LCM.$at_T1$RR($AddrOf(_path));
  assert Native.$bool(LC);
  final ParentMap /*&*/ PM = LC.getParentMap();
  
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = _path.begin(), E = _path.end(); I.$noteq(E);) {
    {
      // Optimize subpaths.
      PathDiagnosticCallPiece /*P*/ CallI = dyn_cast_PathDiagnosticCallPiece(I.$star().$arrow());
      if ((CallI != null)) {
        // Record the fact that a call has been optimized so we only do the
        // effort once.
        if (!(OCS.count(CallI) != 0)) {
          while (optimizeEdges(CallI._path, SM, OCS, LCM)) {
          }
          OCS.insert(CallI);
        }
        I.$preInc();
        continue;
      }
    }
    
    // Pattern match the current piece and its successor.
    PathDiagnosticControlFlowPiece /*P*/ PieceI = dyn_cast_PathDiagnosticControlFlowPiece(I.$star().$arrow());
    if (!(PieceI != null)) {
      I.$preInc();
      continue;
    }
    
    /*const*/ Stmt /*P*/ s1Start = getLocStmt(PieceI.getStartLocation());
    /*const*/ Stmt /*P*/ s1End = getLocStmt(PieceI.getEndLocation());
    /*const*/ Stmt /*P*/ level1 = getStmtParent(s1Start, PM);
    /*const*/ Stmt /*P*/ level2 = getStmtParent(s1End, PM);
    
    std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> NextI = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(I);
    NextI.$preInc();
    if (NextI.$eq(E)) {
      break;
    }
    
    PathDiagnosticControlFlowPiece /*P*/ PieceNextI = dyn_cast_PathDiagnosticControlFlowPiece(NextI.$star().$arrow());
    if (!(PieceNextI != null)) {
      I.$preInc();
      continue;
    }
    
    /*const*/ Stmt /*P*/ s2Start = getLocStmt(PieceNextI.getStartLocation());
    /*const*/ Stmt /*P*/ s2End = getLocStmt(PieceNextI.getEndLocation());
    /*const*/ Stmt /*P*/ level3 = getStmtParent(s2Start, PM);
    /*const*/ Stmt /*P*/ level4 = getStmtParent(s2End, PM);
    
    // Rule I.
    //
    // If we have two consecutive control edges whose end/begin locations
    // are at the same level (e.g. statements or top-level expressions within
    // a compound statement, or siblings share a single ancestor expression),
    // then merge them if they have no interesting intermediate event.
    //
    // For example:
    //
    // (1.1 -> 1.2) -> (1.2 -> 1.3) becomes (1.1 -> 1.3) because the common
    // parent is '1'.  Here 'x.y.z' represents the hierarchy of statements.
    //
    // NOTE: this will be limited later in cases where we add barriers
    // to prevent this optimization.
    //
    if ((level1 != null) && level1 == level2 && level1 == level3 && level1 == level4) {
      PieceI.setEndLocation(PieceNextI.getEndLocation());
      _path.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(NextI));
      hasChanges = true;
      continue;
    }
    
    // Rule II.
    //
    // Eliminate edges between subexpressions and parent expressions
    // when the subexpression is consumed.
    //
    // NOTE: this will be limited later in cases where we add barriers
    // to prevent this optimization.
    //
    if ((s1End != null) && s1End == s2Start && (level2 != null)) {
      boolean removeEdge = false;
      // Remove edges into the increment or initialization of a
      // loop that have no interleaving event.  This means that
      // they aren't interesting.
      if (isIncrementOrInitInForLoop(s1End, level2)) {
        removeEdge = true;
      } else if (!isConditionForTerminator(level2, s1End)) {
        // Next only consider edges that are not anchored on
        // the condition of a terminator.  This are intermediate edges
        // that we might want to trim.
        // Trim edges on expressions that are consumed by
        // the parent expression.
        if (isa_Expr(s1End) && PM.isConsumedExpr_Expr$C$P(cast_Expr(s1End))) {
          removeEdge = true;
        } else // Trim edges where a lexical containment doesn't exist.
        // For example:
        //
        //  X -> Y -> Z
        //
        // If 'Z' lexically contains Y (it is an ancestor) and
        // 'X' does not lexically contain Y (it is a descendant OR
        // it has no lexical relationship at all) then trim.
        //
        // This can eliminate edges where we dive into a subexpression
        // and then pop back out, etc.
        if ((s1Start != null) && (s2End != null)
           && lexicalContains(PM, s2Start, s2End)
           && !lexicalContains(PM, s1End, s1Start)) {
          removeEdge = true;
        } else // Trim edges from a subexpression back to the top level if the
        // subexpression is on a different line.
        //
        // A.1 -> A -> B
        // becomes
        // A.1 -> B
        //
        // These edges just look ugly and don't usually add anything.
        if ((s1Start != null) && (s2End != null)
           && lexicalContains(PM, s1Start, s1End)) {
          SourceRange EdgeRange/*J*/= new SourceRange(/*NO_COPY*/PieceI.getEndLocation().asLocation(), 
              /*NO_COPY*/PieceI.getStartLocation().asLocation());
          if (!getLengthOnSingleLine(SM, new SourceRange(EdgeRange)).hasValue()) {
            removeEdge = true;
          }
        }
      }
      if (removeEdge) {
        PieceI.setEndLocation(PieceNextI.getEndLocation());
        _path.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(NextI));
        hasChanges = true;
        continue;
      }
    }
    
    // Optimize edges for ObjC fast-enumeration loops.
    //
    // (X -> collection) -> (collection -> element)
    //
    // becomes:
    //
    // (X -> element)
    if (s1End == s2Start) {
      /*const*/ ObjCForCollectionStmt /*P*/ FS = dyn_cast_or_null_ObjCForCollectionStmt(level3);
      if ((FS != null) && FS.getCollection$Const().IgnoreParens$Const() == s2Start
         && s2End == FS.getElement$Const()) {
        PieceI.setEndLocation(PieceNextI.getEndLocation());
        _path.erase(new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(NextI));
        hasChanges = true;
        continue;
      }
    }
    
    // No changes at this index?  Move to the next one.
    I.$preInc();
  }
  if (!hasChanges) {
    // Adjust edges into subexpressions to make them more uniform
    // and aesthetically pleasing.
    addContextEdges(_path, SM, PM, LC);
    // Remove "cyclical" edges that include one or more context edges.
    removeContextCycles(_path, SM, PM);
    // Hoist edges originating from branch conditions to branches
    // for simple branches.
    simplifySimpleBranches(_path);
    // Remove any puny edges left over after primary optimization pass.
    removePunyEdges(_path, SM, PM);
    // Remove identical events.
    removeIdenticalEvents(_path);
  }
  
  return hasChanges;
}


/// Drop the very first edge in a path, which should be a function entry edge.
///
/// If the first edge is not a function entry edge (say, because the first
/// statement had an invalid source location), this function does nothing.
// FIXME: We should just generate invalid edges anyway and have the optimizer
// deal with them.
//<editor-fold defaultstate="collapsed" desc="dropFunctionEntryEdge">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2503,
 FQN="dropFunctionEntryEdge", NM="_ZL21dropFunctionEntryEdgeRN5clang4ento10PathPiecesERN4llvm8DenseMapIPKS1_PKNS_15LocationContextENS3_12DenseMapInfoIS6_EENS3_6detail12DenseMapPairIS6_S9_EEEERNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL21dropFunctionEntryEdgeRN5clang4ento10PathPiecesERN4llvm8DenseMapIPKS1_PKNS_15LocationContextENS3_12DenseMapInfoIS6_EENS3_6detail12DenseMapPairIS6_S9_EEEERNS_13SourceManagerE")
//</editor-fold>
public static void dropFunctionEntryEdge(final PathPieces /*&*/ Path, 
                     final DenseMap</*const*/ PathPieces /*P*/ , /*const*/ LocationContext /*P*/ > /*&*/ LCM, 
                     final SourceManager /*&*/ SM) {
  /*const*/ PathDiagnosticControlFlowPiece /*P*/ FirstEdge = dyn_cast_PathDiagnosticControlFlowPiece(Path.front().$arrow());
  if (!(FirstEdge != null)) {
    return;
  }
  
  /*const*/ Decl /*P*/ D = LCM.$at_T1$RR($AddrOf(Path)).getDecl();
  PathDiagnosticLocation EntryLoc = PathDiagnosticLocation.createBegin(D, SM);
  if (FirstEdge.getStartLocation().$noteq(EntryLoc)) {
    return;
  }
  
  Path.pop_front();
}

//<editor-fold defaultstate="collapsed" desc="FindReportInEquivalenceClass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use type$ptr vs ilist_iterator*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3280,
 FQN="FindReportInEquivalenceClass", NM="_ZL28FindReportInEquivalenceClassRN5clang4ento19BugReportEquivClassERN4llvm15SmallVectorImplIPNS0_9BugReportEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZL28FindReportInEquivalenceClassRN5clang4ento19BugReportEquivClassERN4llvm15SmallVectorImplIPNS0_9BugReportEEE")
//</editor-fold>
public static BugReport /*P*/ FindReportInEquivalenceClass(final BugReportEquivClass /*&*/ EQ, 
                            final SmallVectorImpl<BugReport /*P*/ > /*&*/ bugReports) {
  
  /*ilist_iterator*/type$ptr<BugReport> I = EQ.begin();
  /*ilist_iterator*/type$ptr<BugReport> E = EQ.end();
  assert (I.$noteq(E));
  final BugType /*&*/ BT = I.$arrow().getBugType();
  
  // If we don't need to suppress any of the nodes because they are
  // post-dominated by a sink, simply add all the nodes in the equivalence class
  // to 'Nodes'.  Any of the reports will serve as a "representative" report.
  if (!BT.isSuppressOnSink()) {
    BugReport /*P*/ R = $AddrOf(I.$star());
    for (/*ilist_iterator*/type$ptr<BugReport> I$1 = EQ.begin(), E$1 = EQ.end(); I$1.$noteq(E$1); I$1.$preInc()) {
      /*const*/ ExplodedNode /*P*/ N = I$1.$arrow().getErrorNode();
      if ((N != null)) {
        R = $AddrOf(I$1.$star());
        bugReports.push_back(R);
      }
    }
    return R;
  }
  
  // For bug reports that should be suppressed when all paths are post-dominated
  // by a sink node, iterate through the reports in the equivalence class
  // until we find one that isn't post-dominated (if one exists).  We use a
  // DFS traversal of the ExplodedGraph to find a non-sink node.  We could write
  // this as a recursive function, but we don't want to risk blowing out the
  // stack for very long paths.
  BugReport /*P*/ exampleReport = null;
  
  for (; I.$noteq(E); I.$preInc()) {
    /*const*/ ExplodedNode /*P*/ errorNode = I.$arrow().getErrorNode();
    if (!(errorNode != null)) {
      continue;
    }
    if (errorNode.isSink()) {
      throw new llvm_unreachable("BugType::isSuppressSink() should not be 'true' for sink end nodes");
    }
    // No successors?  By definition this nodes isn't post-dominated by a sink.
    if (errorNode.succ_empty()) {
      bugReports.push_back($AddrOf(I.$star()));
      if (!(exampleReport != null)) {
        exampleReport = $AddrOf(I.$star());
      }
      continue;
    }
    
    // At this point we know that 'N' is not a sink and it has at least one
    // successor.  Use a DFS worklist to find a non-sink end-of-path node.
    // JAVA: typedef FRIEC_WLItem WLItem
//    final class WLItem extends FRIEC_WLItem{ };
    // JAVA: typedef SmallVector<WLItem, 10> DFSWorkList
//    final class DFSWorkList extends SmallVector<FRIEC_WLItem>{ };
    DenseMapTypeUInt</*const*/ ExplodedNode /*P*/ > Visited/*J*/= new DenseMapTypeUInt</*const*/ ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    
    SmallVector<FRIEC_WLItem> WL/*J*/= new SmallVector<FRIEC_WLItem>(10, new FRIEC_WLItem());
    WL.push_back(new FRIEC_WLItem(errorNode));
    Visited.$set(errorNode, 1);
    while (!WL.empty()) {
      final FRIEC_WLItem /*&*/ WI = WL.back();
      assert (!WI.N.succ_empty());
      
      for (; $noteq_ptr(WI.I, WI.E); WI.I.$preInc()) {
        /*const*/ ExplodedNode /*P*/ Succ = WI.I.$star();
        // End-of-path node?
        if (Succ.succ_empty()) {
          // If we found an end-of-path node that is not a sink.
          if (!Succ.isSink()) {
            bugReports.push_back($AddrOf(I.$star()));
            if (!(exampleReport != null)) {
              exampleReport = $AddrOf(I.$star());
            }
            WL.clear();
            break;
          }
          // Found a sink?  Continue on to the next successor.
          continue;
        }
        // Mark the successor as visited.  If it hasn't been explored,
        // enqueue it to the DFS worklist.
        final uint$ref/*uint &*/ mark = Visited.ref$at(Succ);
        if (!(mark.$deref() != 0)) {
          mark.$set(1);
          WL.push_back(new FRIEC_WLItem(Succ));
          break;
        }
      }
      
      // The worklist may have been cleared at this point.  First
      // check if it is empty before checking the last item.
      if (!WL.empty() && $AddrOf(WL.back()) == $AddrOf(WI)) {
        WL.pop_back();
      }
    }
  }
  
  // ExampleReport will be NULL if all the nodes in the equivalence class
  // were post-dominated by sinks.
  return exampleReport;
}

} // END OF class BugReporterStatics
