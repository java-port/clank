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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.impl.BugReporterStatics.*;


// FIXME: Get rid of GRBugReporter.  It's the wrong abstraction.
//<editor-fold defaultstate="collapsed" desc="clang::ento::GRBugReporter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 489,
 FQN="clang::ento::GRBugReporter", NM="_ZN5clang4ento13GRBugReporterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento13GRBugReporterE")
//</editor-fold>
public class GRBugReporter extends /*public*/ BugReporter implements Destructors.ClassWithDestructor {
  private final ExprEngine /*&*/ Eng;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::GRBugReporter::GRBugReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 492,
   FQN="clang::ento::GRBugReporter::GRBugReporter", NM="_ZN5clang4ento13GRBugReporterC1ERNS0_15BugReporterDataERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento13GRBugReporterC1ERNS0_15BugReporterDataERNS0_10ExprEngineE")
  //</editor-fold>
  public GRBugReporter(final BugReporterData /*&*/ d, final ExprEngine /*&*/ eng) {
    // : BugReporter(d, GRBugReporterKind), Eng(eng) 
    //START JInit
    super(d, Kind.GRBugReporterKind);
    this./*&*/Eng=/*&*/eng;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::GRBugReporter::~GRBugReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2734,
   FQN="clang::ento::GRBugReporter::~GRBugReporter", NM="_ZN5clang4ento13GRBugReporterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento13GRBugReporterD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  /// getEngine - Return the analysis engine used to analyze a given
  ///  function or method.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::GRBugReporter::getEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 499,
   FQN="clang::ento::GRBugReporter::getEngine", NM="_ZN5clang4ento13GRBugReporter9getEngineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento13GRBugReporter9getEngineEv")
  //</editor-fold>
  public ExprEngine /*&*/ getEngine() {
    return Eng;
  }

  
  /// getGraph - Get the exploded graph created by the analysis engine
  ///  for the analyzed method or function.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::GRBugReporter::getGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2737,
   FQN="clang::ento::GRBugReporter::getGraph", NM="_ZN5clang4ento13GRBugReporter8getGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento13GRBugReporter8getGraphEv")
  //</editor-fold>
  public ExplodedGraph /*&*/ getGraph() {
    return Eng.getGraph();
  }

  
  /// getStateManager - Return the state manager used by the analysis
  ///  engine.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::GRBugReporter::getStateManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2739,
   FQN="clang::ento::GRBugReporter::getStateManager", NM="_ZN5clang4ento13GRBugReporter15getStateManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento13GRBugReporter15getStateManagerEv")
  //</editor-fold>
  public ProgramStateManager /*&*/ getStateManager() {
    return Eng.getStateManager();
  }

  
  /// Generates a path corresponding to one of the given bug reports.
  ///
  /// Which report is used for path generation is not specified. The
  /// bug reporter will try to pick the shortest path, but this is not
  /// guaranteed.
  ///
  /// \return True if the report was valid and a path was generated,
  ///         false if the reports should be considered invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::GRBugReporter::generatePathDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3054,
   FQN="clang::ento::GRBugReporter::generatePathDiagnostic", NM="_ZN5clang4ento13GRBugReporter22generatePathDiagnosticERNS0_14PathDiagnosticERNS0_22PathDiagnosticConsumerERN4llvm8ArrayRefIPNS0_9BugReportEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento13GRBugReporter22generatePathDiagnosticERNS0_14PathDiagnosticERNS0_22PathDiagnosticConsumerERN4llvm8ArrayRefIPNS0_9BugReportEEE")
  //</editor-fold>
  @Override public boolean generatePathDiagnostic(final PathDiagnostic /*&*/ PD, 
                        final PathDiagnosticConsumer /*&*/ PC, 
                        final ArrayRef<BugReport /*P*/ > /*&*/ bugReports)/* override*/ {
    TrimmedGraph TrimG = null;
    ReportGraph ErrorGraph = null;
    try {
      assert (!bugReports.empty());
      
      boolean HasValid = false;
      boolean HasInvalid = false;
      SmallVector</*const*/ ExplodedNode /*P*/ > errorNodes/*J*/= new SmallVector</*const*/ ExplodedNode /*P*/ >(32, (/*const*/ ExplodedNode /*P*/ )null);
      for (type$ptr<BugReport /*P*/ /*P*/> I = $tryClone(bugReports.begin()), 
          /*P*/ E = $tryClone(bugReports.end()); $noteq_ptr(I, E); I.$preInc()) {
        if ((I.$star()).isValid()) {
          HasValid = true;
          errorNodes.push_back((I.$star()).getErrorNode());
        } else {
          // Keep the errorNodes list in sync with the bugReports list.
          HasInvalid = true;
          errorNodes.push_back((/*const*/ ExplodedNode /*P*/ /*const*/)null);
        }
      }
      
      // If all the reports have been marked invalid by a previous path generation,
      // we're done.
      if (!HasValid) {
        return false;
      }
      
      // JAVA: typedef PathDiagnosticConsumer::PathGenerationScheme PathGenerationScheme
//      final class PathGenerationScheme extends PathDiagnosticConsumer.PathGenerationScheme{ };
      PathDiagnosticConsumer.PathGenerationScheme ActiveScheme = PC.getGenerationScheme();
      if (ActiveScheme == PathDiagnosticConsumer.PathGenerationScheme.Extensive) {
        final AnalyzerOptions /*&*/ options = getAnalyzerOptions();
        if (options.getBooleanOption(new StringRef(/*KEEP_STR*/"path-diagnostics-alternate"), true)) {
          ActiveScheme = PathDiagnosticConsumer.PathGenerationScheme.AlternateExtensive;
        }
      }
      
      TrimG/*J*/= new TrimmedGraph($AddrOf(getGraph()), new ArrayRef</*const*/ ExplodedNode /*P*/ >(errorNodes, true));
      ErrorGraph/*J*/= new ReportGraph();
      while (TrimG.popNextReportGraph(ErrorGraph)) {
        PathDiagnosticBuilder PDB = null;
        SmallVector<std.unique_ptr<BugReporterVisitor>> visitors = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Find the BugReport with the original location.
          assert ($less_uint(ErrorGraph.Index, bugReports.size()));
          BugReport /*P*/ R = bugReports.$at(ErrorGraph.Index);
          assert ((R != null)) : "No original report found for sliced graph.";
          assert (R.isValid()) : "Report selected by trimmed graph marked invalid.";
          
          // Start building the path diagnostic...
          PDB/*J*/= new PathDiagnosticBuilder(/*Deref*/this, R, ErrorGraph.BackMap, $AddrOf(PC));
          /*const*/ ExplodedNode /*P*/ N = ErrorGraph.ErrorNode;
          
          // Register additional node visitors.
          R.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new NilReceiverBRVisitor()))))); $c$.clean();
          R.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ConditionBRVisitor()))))); $c$.clean();
          R.addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LikelyFalsePositiveSuppressionBRVisitor()))))); $c$.clean();
          
          visitors/*J*/= new SmallVector<std.unique_ptr<BugReporterVisitor>>(8, new std.unique_ptr<BugReporterVisitor>());
          /*uint*/int origReportConfigToken;
          /*uint*/int finalReportConfigToken;
          DenseMap</*const*/ PathPieces /*P*/ , /*const*/ LocationContext /*P*/ > LCM/*J*/= new DenseMap</*const*/ PathPieces /*P*/ , /*const*/ LocationContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ LocationContext /*P*/ )null);
          
          // While generating diagnostics, it's possible the visitors will decide
          // new symbols and regions are interesting, or add other visitors based on
          // the information they find. If they do, we need to regenerate the path
          // based on our new report configuration.
          do {
            std.unique_ptr<PathDiagnosticPiece> LastPiece = null;
            try {
              // Get a clean copy of all the visitors.
              for (type$ptr<unique_ptr<BugReporterVisitor> /*P*/> I = $tryClone(R.visitor_begin()), 
                  /*P*/ E = $tryClone(R.visitor_end()); $noteq_ptr(I, E); I.$preInc())  {
                visitors.push_back_T$RR($c$.track((I.$star()).$arrow().clone$Visitor())); $c$.clean();
              }
              
              // Clear out the active path from any previous work.
              PD.resetPath();
              origReportConfigToken = R.getConfigurationChangeToken();
              
              // Generate the very last diagnostic piece - the piece is visible before
              // the trace is expanded.
              LastPiece/*J*/= new std.unique_ptr<PathDiagnosticPiece>();
              for (type$ptr<unique_ptr<BugReporterVisitor> /*P*/> I = $tryClone(visitors.begin()), /*P*/ E = $tryClone(visitors.end());
                   $noteq_ptr(I, E); I.$preInc()) {
                {
                  std.unique_ptr<PathDiagnosticPiece> Piece = null;
                  try {
                    Piece = (I.$star()).$arrow().getEndPath(PDB, N, $Deref(R));
                    if (Piece.$bool()) {
                      assert (!LastPiece.$bool()) : "There can only be one final piece in a diagnostic.";
                      LastPiece.$assignMove(std.move(Piece));
                    }
                  } finally {
                    if (Piece != null) { Piece.$destroy(); }
                  }
                }
              }
              if (ActiveScheme != PathDiagnosticConsumer.PathGenerationScheme.None) {
                if (!LastPiece.$bool()) {
                  $c$.clean(LastPiece.$assignMove($c$.track(BugReporterVisitor.getDefaultEndPath(PDB, N, $Deref(R)))));
                }
                assert ((LastPiece).$bool());
                PD.setEndOfPath($c$.track(new std.unique_ptr<PathDiagnosticPiece>(JD$Move.INSTANCE, std.move(LastPiece)))); $c$.clean();
              }
              
              // Make sure we get a clean location context map so we don't
              // hold onto old mappings.
              LCM.clear();
              switch (ActiveScheme) {
               case AlternateExtensive:
                BugReporterStatics.GenerateAlternateExtensivePathDiagnostic(PD, PDB, N, LCM, new ArrayRef<std.unique_ptr<BugReporterVisitor>>(visitors, false));
                break;
               case Extensive:
                BugReporterStatics.GenerateExtensivePathDiagnostic(PD, PDB, N, LCM, new ArrayRef<std.unique_ptr<BugReporterVisitor>>(visitors, false));
                break;
               case Minimal:
                BugReporterStatics.GenerateMinimalPathDiagnostic(PD, PDB, N, LCM, new ArrayRef<std.unique_ptr<BugReporterVisitor>>(visitors, false));
                break;
               case None:
                BugReporterStatics.GenerateVisitorsOnlyPathDiagnostic(PD, PDB, N, new ArrayRef<std.unique_ptr<BugReporterVisitor>>(visitors, false));
                break;
              }
              
              // Clean up the visitors we used.
              visitors.clear();
              
              // Did anything change while generating this path?
              finalReportConfigToken = R.getConfigurationChangeToken();
            } finally {
              if (LastPiece != null) { LastPiece.$destroy(); }
            }
          } while (finalReportConfigToken != origReportConfigToken);
          if (!R.isValid()) {
            continue;
          }
          
          // Finally, prune the diagnostic path of uninteresting stuff.
          if (!PD._path.empty()) {
            if (R.shouldPrunePath() && getAnalyzerOptions().shouldPrunePaths()) {
              boolean stillHasNotes = BugReporterStatics.removeUnneededCalls(PD.getMutablePieces(), R, LCM);
              assert (stillHasNotes);
              ///*J:(void)*/stillHasNotes;
            }
            
            // Redirect all call pieces to have valid locations.
            BugReporterStatics.adjustCallLocations(PD.getMutablePieces());
            BugReporterStatics.removePiecesWithInvalidLocations(PD.getMutablePieces());
            if (ActiveScheme == PathDiagnosticConsumer.PathGenerationScheme.AlternateExtensive) {
              final SourceManager /*&*/ SM = getSourceManager();
              
              // Reduce the number of edges from a very conservative set
              // to an aesthetically pleasing subset that conveys the
              // necessary information.
              DenseSet</*const*/ PathDiagnosticCallPiece /*P*/ > OCS/*J*/= new DenseSet</*const*/ PathDiagnosticCallPiece /*P*/ >(DenseMapInfo$LikePtr.$Info());
              while (BugReporterStatics.optimizeEdges(PD.getMutablePieces(), SM, OCS, LCM)) {
              }
              
              // Drop the very first function-entry edge. It's not really necessary
              // for top-level functions.
              BugReporterStatics.dropFunctionEntryEdge(PD.getMutablePieces(), LCM, SM);
            }
            
            // Remove messages that are basically the same, and edges that may not
            // make sense.
            // We have to do this after edge optimization in the Extensive mode.
            BugReporterStatics.removeRedundantMsgs(PD.getMutablePieces());
            BugReporterStatics.removeEdgesToDefaultInitializers(PD.getMutablePieces());
          }
          
          // We found a report and didn't suppress it.
          return true;
        } finally {
          if (visitors != null) { visitors.$destroy(); }
          if (PDB != null) { PDB.$destroy(); }
          $c$.$destroy();
        }
      }
      
      // We suppressed all the reports in this equivalence class.
      assert (!HasInvalid) : "Inconsistent suppression";
      ///*J:(void)*/HasInvalid;
      return false;
    } finally {
      if (ErrorGraph != null) { ErrorGraph.$destroy(); }
      if (TrimG != null) { TrimG.$destroy(); }
    }
  }

  
  /// classof - Used by isa<>, cast<>, and dyn_cast<>.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::GRBugReporter::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 521,
   FQN="clang::ento::GRBugReporter::classof", NM="_ZN5clang4ento13GRBugReporter7classofEPKNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento13GRBugReporter7classofEPKNS0_11BugReporterE")
  //</editor-fold>
  public static boolean classof(/*const*/ BugReporter /*P*/ R) {
    return R.getKind() == Kind.GRBugReporterKind;
  }

  
  @Override public String toString() {
    return "" + "Eng=" + "[ExprEngine]" // NOI18N
              + super.toString(); // NOI18N
  }
}
