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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::SuppressInlineDefensiveChecksVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 303,
 FQN="clang::ento::SuppressInlineDefensiveChecksVisitor", NM="_ZN5clang4ento36SuppressInlineDefensiveChecksVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento36SuppressInlineDefensiveChecksVisitorE")
//</editor-fold>
public final class SuppressInlineDefensiveChecksVisitor extends /*public*/ BugReporterVisitorImpl<SuppressInlineDefensiveChecksVisitor> implements Destructors.ClassWithDestructor {
  /// The symbolic value for which we are tracking constraints.
  /// This value is constrained to null in the end of path.
  private DefinedSVal V;
  
  /// Track if we found the node where the constraint was first added.
  private boolean IsSatisfied;
  
  /// Since the visitors can be registered on nodes previous to the last
  /// node in the BugReport, but the path traversal always starts with the last
  /// node, the visitor invariant (that we start with a node in which V is null)
  /// might not hold when node visitation starts. We are going to start tracking
  /// from the last node in which the value is null.
  private boolean IsTrackingTurnedOn;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SuppressInlineDefensiveChecksVisitor::SuppressInlineDefensiveChecksVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 785,
   FQN="clang::ento::SuppressInlineDefensiveChecksVisitor::SuppressInlineDefensiveChecksVisitor", NM="_ZN5clang4ento36SuppressInlineDefensiveChecksVisitorC1ENS0_11DefinedSValEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento36SuppressInlineDefensiveChecksVisitorC1ENS0_11DefinedSValEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public SuppressInlineDefensiveChecksVisitor(DefinedSVal Value, /*const*/ ExplodedNode /*P*/ N) {
    // : BugReporterVisitorImpl<SuppressInlineDefensiveChecksVisitor>(), V(Value), IsSatisfied(false), IsTrackingTurnedOn(false) 
    //START JInit
    super();
    this.V = new DefinedSVal(Value);
    this.IsSatisfied = false;
    this.IsTrackingTurnedOn = false;
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Check if the visitor is disabled.
      SubEngine /*P*/ Eng = N.getState().$arrow().getStateManager().getOwningEngine();
      assert ((Eng != null)) : "Cannot file a bug report without an owning engine";
      final AnalyzerOptions /*&*/ Options = Eng.getAnalysisManager().options;
      if (!Options.shouldSuppressInlinedDefensiveChecks()) {
        IsSatisfied = true;
      }
      assert ($c$.track(N.getState().$arrow().isNull(new SVal(V))).isConstrainedTrue()) : "The visitor only tracks the cases where V is constrained to 0"; $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SuppressInlineDefensiveChecksVisitor::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 800,
   FQN="clang::ento::SuppressInlineDefensiveChecksVisitor::Profile", NM="_ZNK5clang4ento36SuppressInlineDefensiveChecksVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZNK5clang4ento36SuppressInlineDefensiveChecksVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    final/*static*/ Object id = Profile$$.id;
    ID.AddPointer($AddrOf(id));
    ID.Add(V);
  }
  private static final class Profile$$ {
    static final/*static*/ Object id = SuppressInlineDefensiveChecksVisitor.class;
  }

  
  /// Return the tag associated with this visitor.  This tag will be used
  /// to make all PathDiagnosticPieces created by this visitor.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SuppressInlineDefensiveChecksVisitor::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 806,
   FQN="clang::ento::SuppressInlineDefensiveChecksVisitor::getTag", NM="_ZN5clang4ento36SuppressInlineDefensiveChecksVisitor6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento36SuppressInlineDefensiveChecksVisitor6getTagEv")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getTag() {
    return $("IDCVisitor");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SuppressInlineDefensiveChecksVisitor::VisitNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*we don't have SLocEntry instances*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 810,
   FQN="clang::ento::SuppressInlineDefensiveChecksVisitor::VisitNode", NM="_ZN5clang4ento36SuppressInlineDefensiveChecksVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento36SuppressInlineDefensiveChecksVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ Succ, 
           /*const*/ ExplodedNode /*P*/ Pred, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (IsSatisfied) {
        return null;
      }
      
      // Start tracking after we see the first state in which the value is null.
      if (!IsTrackingTurnedOn) {
        if ($c$.clean($c$.track(Succ.getState().$arrow().isNull(new SVal(V))).isConstrainedTrue())) {
          IsTrackingTurnedOn = true;
        }
      }
      if (!IsTrackingTurnedOn) {
        return null;
      }
      
      // Check if in the previous state it was feasible for this value
      // to *not* be null.
      if ($c$.clean(!$c$.track(Pred.getState().$arrow().isNull(new SVal(V))).isConstrainedTrue())) {
        IsSatisfied = true;
        assert ($c$.track(Succ.getState().$arrow().isNull(new SVal(V))).isConstrainedTrue()); $c$.clean();
        
        // Check if this is inlined defensive checks.
        /*const*/ LocationContext /*P*/ CurLC = Succ.getLocationContext();
        /*const*/ LocationContext /*P*/ ReportLC = BR.getErrorNode().getLocationContext();
        if (CurLC != ReportLC && !CurLC.isParentOf(ReportLC)) {
          BR.markInvalid(/*KEEP_STR*/"Suppress IDC", CurLC);
          return null;
        }
        
        // Treat defensive checks in function-like macros as if they were an inlined
        // defensive check. If the bug location is not in a macro and the
        // terminator for the current location is in a macro then suppress the
        // warning.
        Optional<StmtPoint> BugPoint = BR.getErrorNode().getLocation().getAs(StmtPoint.class);
        if (!BugPoint.$bool()) {
          return null;
        }
        
        SourceLocation BugLoc = BugPoint.$arrow().getStmt().getLocStart();
        if (BugLoc.isMacroID()) {
          return null;
        }
        
        ProgramPoint CurPoint = Succ.getLocation();
        /*const*/ Stmt /*P*/ CurTerminatorStmt = null;
        {
          Optional<BlockEdge> BE = CurPoint.getAs(BlockEdge.class);
          if (BE.$bool()) {
            CurTerminatorStmt = BE.$arrow().getSrc().getTerminator$Const().getStmt$Const();
          } else {
            Optional<StmtPoint> SP = CurPoint.getAs(StmtPoint.class);
            if (SP.$bool()) {
              /*const*/ Stmt /*P*/ CurStmt = SP.$arrow().getStmt();
              if (!CurStmt.getLocStart().isMacroID()) {
                return null;
              }
              
              CFGStmtMap /*P*/ Map = CurLC.getAnalysisDeclContext().getCFGStmtMap();
              CurTerminatorStmt = Map.getBlock_Stmt$C$P$Const(CurStmt).getTerminator$Const().$Stmt$C$P();
            } else {
              return null;
            }
          }
        }
        if (!(CurTerminatorStmt != null)) {
          return null;
        }
        
        SourceLocation TerminatorLoc = CurTerminatorStmt.getLocStart();
        if (TerminatorLoc.isMacroID()) {
          final /*const*/ SourceManager /*&*/ SMgr = BRC.getSourceManager();
          std.pairTypeUInt<FileID> TLInfo = SMgr.getDecomposedLoc(/*NO_COPY*/TerminatorLoc);
          // JAVA: we don't have instances of SLocEntry, use unfolded index
          if (false) {
            SrcMgr.SLocEntry SE = new SrcMgr.SLocEntry(SMgr.getSLocEntry(/*NO_COPY*/TLInfo.first));
          }
//          final /*const*/ SrcMgr.ExpansionInfo /*&*/ EInfo = SE.getExpansion();
          /*SrcMgr.ExpansionInfo*/int EInfo = SMgr.getExpansionSLocEntryByID_LoadEntryIfAbsent(/*NO_COPY*/TLInfo.first.$ID());
          if (SMgr.$isFunctionMacroExpansion(EInfo)) {
            BR.markInvalid(/*KEEP_STR*/"Suppress Macro IDC", CurLC);
            return null;
          }
        }
      }
      return null;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SuppressInlineDefensiveChecksVisitor::~SuppressInlineDefensiveChecksVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 303,
   FQN="clang::ento::SuppressInlineDefensiveChecksVisitor::~SuppressInlineDefensiveChecksVisitor", NM="_ZN5clang4ento36SuppressInlineDefensiveChecksVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento36SuppressInlineDefensiveChecksVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SuppressInlineDefensiveChecksVisitor::SuppressInlineDefensiveChecksVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 303,
   FQN="clang::ento::SuppressInlineDefensiveChecksVisitor::SuppressInlineDefensiveChecksVisitor", NM="_ZN5clang4ento36SuppressInlineDefensiveChecksVisitorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento36SuppressInlineDefensiveChecksVisitorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ SuppressInlineDefensiveChecksVisitor(final /*const*/ SuppressInlineDefensiveChecksVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<SuppressInlineDefensiveChecksVisitor>(), V(.V), IsSatisfied(.IsSatisfied), IsTrackingTurnedOn(.IsTrackingTurnedOn) 
    //START JInit
    super($Prm0);
    this.V = new DefinedSVal($Prm0.V);
    this.IsSatisfied = $Prm0.IsSatisfied;
    this.IsTrackingTurnedOn = $Prm0.IsTrackingTurnedOn;
    //END JInit
  }

  @Override public SuppressInlineDefensiveChecksVisitor clone() {
    return new SuppressInlineDefensiveChecksVisitor(this);
  }
  
  @Override public String toString() {
    return "" + "V=" + V // NOI18N
              + ", IsSatisfied=" + IsSatisfied // NOI18N
              + ", IsTrackingTurnedOn=" + IsTrackingTurnedOn // NOI18N
              + super.toString(); // NOI18N
  }
}
