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
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::TrackConstraintBRVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 130,
 FQN="clang::ento::TrackConstraintBRVisitor", NM="_ZN5clang4ento24TrackConstraintBRVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento24TrackConstraintBRVisitorE")
//</editor-fold>
public final class TrackConstraintBRVisitor extends /*public*/ BugReporterVisitorImpl<TrackConstraintBRVisitor> implements Destructors.ClassWithDestructor {
  private DefinedSVal Constraint;
  private boolean Assumption;
  private boolean IsSatisfied;
  private boolean IsZeroCheck;
  
  /// We should start tracking from the last node along the path in which the
  /// value is constrained.
  private boolean IsTrackingTurnedOn;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TrackConstraintBRVisitor::TrackConstraintBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 142,
   FQN="clang::ento::TrackConstraintBRVisitor::TrackConstraintBRVisitor", NM="_ZN5clang4ento24TrackConstraintBRVisitorC1ENS0_11DefinedSValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento24TrackConstraintBRVisitorC1ENS0_11DefinedSValEb")
  //</editor-fold>
  public TrackConstraintBRVisitor(DefinedSVal constraint, boolean assumption) {
    // : BugReporterVisitorImpl<TrackConstraintBRVisitor>(), Constraint(constraint), Assumption(assumption), IsSatisfied(false), IsZeroCheck(!Assumption && Constraint.getAs<Loc>().operator bool()), IsTrackingTurnedOn(false) 
    //START JInit
    super();
    this.Constraint = new DefinedSVal(constraint);
    this.Assumption = assumption;
    this.IsSatisfied = false;
    this.IsZeroCheck = !Assumption && Constraint.getAs(Loc.class).$bool();
    this.IsTrackingTurnedOn = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TrackConstraintBRVisitor::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 711,
   FQN="clang::ento::TrackConstraintBRVisitor::Profile", NM="_ZNK5clang4ento24TrackConstraintBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZNK5clang4ento24TrackConstraintBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    final/*static*/ Object tag = Profile$$.tag;
    ID.AddPointer($AddrOf(tag));
    ID.AddBoolean(Assumption);
    ID.Add(Constraint);
  }
  private static final class Profile$$ {
    static final/*static*/ Object tag = TrackConstraintBRVisitor.class;
  }

  
  /// Return the tag associated with this visitor.  This tag will be used
  /// to make all PathDiagnosticPieces created by this visitor.
  
  /// Return the tag associated with this visitor.  This tag will be used
  /// to make all PathDiagnosticPieces created by this visitor.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TrackConstraintBRVisitor::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 720,
   FQN="clang::ento::TrackConstraintBRVisitor::getTag", NM="_ZN5clang4ento24TrackConstraintBRVisitor6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento24TrackConstraintBRVisitor6getTagEv")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getTag() {
    return $("TrackConstraintBRVisitor");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TrackConstraintBRVisitor::VisitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 730,
   FQN="clang::ento::TrackConstraintBRVisitor::VisitNode", NM="_ZN5clang4ento24TrackConstraintBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento24TrackConstraintBRVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
           /*const*/ ExplodedNode /*P*/ PrevN, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    if (IsSatisfied) {
      return null;
    }
    
    // Start tracking after we see the first state in which the value is
    // constrained.
    if (!IsTrackingTurnedOn) {
      if (!isUnderconstrained(N)) {
        IsTrackingTurnedOn = true;
      }
    }
    if (!IsTrackingTurnedOn) {
      return null;
    }
    
    // Check if in the previous state it was feasible for this constraint
    // to *not* be true.
    if (isUnderconstrained(PrevN)) {
      raw_svector_ostream os = null;
      try {
        
        IsSatisfied = true;
        
        // As a sanity check, make sure that the negation of the constraint
        // was infeasible in the current state.  If it is feasible, we somehow
        // missed the transition point.
        assert (!isUnderconstrained(N));
        
        // We found the transition point for the constraint.  We now need to
        // pretty-print the constraint. (work-in-progress)
        SmallString/*64*/ sbuf/*J*/= new SmallString/*64*/(64);
        os/*J*/= new raw_svector_ostream(sbuf);
        if (Constraint.getAs(Loc.class).$bool()) {
          os.$out(/*KEEP_STR*/"Assuming pointer value is ");
          os.$out((Assumption ? $("non-null") : $("null")));
        }
        if (os.str().empty()) {
          return null;
        }
        
        // Construct a new PathDiagnosticPiece.
        ProgramPoint P = N.getLocation();
        PathDiagnosticLocation L = PathDiagnosticLocation.create(P, BRC.getSourceManager());
        if (!L.isValid()) {
          return null;
        }
        
        PathDiagnosticEventPiece /*P*/ X = new PathDiagnosticEventPiece(L, os.str());
        X.setTag(getTag());
        return X;
      } finally {
        if (os != null) { os.$destroy(); }
      }
    }
    
    return null;
  }

/*private:*/
  /// Checks if the constraint is valid in the current state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TrackConstraintBRVisitor::isUnderconstrained">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 724,
   FQN="clang::ento::TrackConstraintBRVisitor::isUnderconstrained", NM="_ZNK5clang4ento24TrackConstraintBRVisitor18isUnderconstrainedEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZNK5clang4ento24TrackConstraintBRVisitor18isUnderconstrainedEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  private boolean isUnderconstrained(/*const*/ ExplodedNode /*P*/ N) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (IsZeroCheck) {
        return $c$.clean($c$.track(N.getState().$arrow().isNull(new SVal(Constraint))).isUnderconstrained());
      }
      return $c$.clean((boolean)$c$.track(N.getState().$arrow().assume(new DefinedOrUnknownSVal(Constraint), !Assumption)).$bool());
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::TrackConstraintBRVisitor::~TrackConstraintBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 130,
   FQN="clang::ento::TrackConstraintBRVisitor::~TrackConstraintBRVisitor", NM="_ZN5clang4ento24TrackConstraintBRVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento24TrackConstraintBRVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::TrackConstraintBRVisitor::TrackConstraintBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 130,
   FQN="clang::ento::TrackConstraintBRVisitor::TrackConstraintBRVisitor", NM="_ZN5clang4ento24TrackConstraintBRVisitorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento24TrackConstraintBRVisitorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ TrackConstraintBRVisitor(final /*const*/ TrackConstraintBRVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<TrackConstraintBRVisitor>(), Constraint(.Constraint), Assumption(.Assumption), IsSatisfied(.IsSatisfied), IsZeroCheck(.IsZeroCheck), IsTrackingTurnedOn(.IsTrackingTurnedOn) 
    //START JInit
    super($Prm0);
    this.Constraint = new DefinedSVal($Prm0.Constraint);
    this.Assumption = $Prm0.Assumption;
    this.IsSatisfied = $Prm0.IsSatisfied;
    this.IsZeroCheck = $Prm0.IsZeroCheck;
    this.IsTrackingTurnedOn = $Prm0.IsTrackingTurnedOn;
    //END JInit
  }

  @Override public TrackConstraintBRVisitor clone() {
    return new TrackConstraintBRVisitor(this);
  }
  
  @Override public String toString() {
    return "" + "Constraint=" + Constraint // NOI18N
              + ", Assumption=" + Assumption // NOI18N
              + ", IsSatisfied=" + IsSatisfied // NOI18N
              + ", IsZeroCheck=" + IsZeroCheck // NOI18N
              + ", IsTrackingTurnedOn=" + IsTrackingTurnedOn // NOI18N
              + super.toString(); // NOI18N
  }
}
