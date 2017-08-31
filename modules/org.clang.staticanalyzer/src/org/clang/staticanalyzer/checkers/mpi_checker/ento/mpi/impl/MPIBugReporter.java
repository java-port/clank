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

package org.clang.staticanalyzer.checkers.mpi_checker.ento.mpi.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.mpi_checker.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clank.support.aliases.char$ptr;
import static org.clank.support.literal_constants.$;

//<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.h", line = 26,
 FQN="clang::ento::mpi::MPIBugReporter", NM="_ZN5clang4ento3mpi14MPIBugReporterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi14MPIBugReporterE")
//</editor-fold>
public class MPIBugReporter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::MPIBugReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.h", line = 28,
   FQN="clang::ento::mpi::MPIBugReporter::MPIBugReporter", NM="_ZN5clang4ento3mpi14MPIBugReporterC1ERKNS0_11CheckerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi14MPIBugReporterC1ERKNS0_11CheckerBaseE")
  //</editor-fold>
  public MPIBugReporter(final /*const*/ CheckerBase /*&*/ CB) {
    // : MPIError("MPI Error"), UnmatchedWaitBugType(), MissingWaitBugType(), DoubleNonblockingBugType() 
    //START JInit
    /*InClass*/this.MPIError = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"MPI Error");
    this.UnmatchedWaitBugType = new std.unique_ptr<BugType>();
    this.MissingWaitBugType = new std.unique_ptr<BugType>();
    this.DoubleNonblockingBugType = new std.unique_ptr<BugType>();
    //END JInit
    UnmatchedWaitBugType.reset(new BugType($AddrOf(CB), new StringRef(/*KEEP_STR*/"Unmatched wait"), new StringRef(MPIError)));
    DoubleNonblockingBugType.reset(new BugType($AddrOf(CB), new StringRef(/*KEEP_STR*/"Double nonblocking"), new StringRef(MPIError)));
    MissingWaitBugType.reset(new BugType($AddrOf(CB), new StringRef(/*KEEP_STR*/"Missing wait"), new StringRef(MPIError)));
  }

  
  /// Report duplicate request use by nonblocking calls without intermediate
  /// wait.
  ///
  /// \param MPICallEvent MPI call that caused the double nonblocking
  /// \param Req request that was used by two nonblocking calls in sequence
  /// \param RequestRegion memory region of the request
  /// \param ExplNode node in the graph the bug appeared at
  /// \param BReporter bug reporter for current context
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::reportDoubleNonblocking">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp", line = 24,
   FQN="clang::ento::mpi::MPIBugReporter::reportDoubleNonblocking", NM="_ZNK5clang4ento3mpi14MPIBugReporter23reportDoubleNonblockingERKNS0_9CallEventERKNS1_7RequestEPKNS0_9MemRegionEPKNS0_12ExplodedNodeERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZNK5clang4ento3mpi14MPIBugReporter23reportDoubleNonblockingERKNS0_9CallEventERKNS1_7RequestEPKNS0_9MemRegionEPKNS0_12ExplodedNodeERNS0_11BugReporterE")
  //</editor-fold>
  public void reportDoubleNonblocking(final /*const*/ CallEvent /*&*/ MPICallEvent, final /*const*/ Request /*&*/ Req, 
                         /*const*/ MemRegion /*P*/ /*const*/ RequestRegion, 
                         /*const*/ ExplodedNode /*P*/ /*const*/ ExplNode, 
                         final BugReporter /*&*/ BReporter) /*const*/ {
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      std.string ErrorText/*J*/= new std.string();
      ErrorText.$assignMove($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"Double nonblocking on request ", 
                  RequestRegion.getDescriptiveName()), /*KEEP_STR*/". "));
      
      Report = llvm.make_unique(new BugReport(DoubleNonblockingBugType.$star(), 
          ErrorText, ExplNode));
      
      Report.$arrow().addRange(MPICallEvent.getSourceRange());
      SourceRange Range = RequestRegion.sourceRange();
      if (Range.isValid()) {
        Report.$arrow().addRange(new SourceRange(Range));
      }
      
      Report.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new RequestNodeVisitor(RequestRegion, $("Request is previously used by nonblocking call here. "))))))); $c$.clean();
      Report.$arrow().markInteresting(RequestRegion);
      
      BReporter.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Report a missing wait for a nonblocking call. A missing wait report
  /// is emitted if a nonblocking call is not matched in the scope of a
  /// function.
  ///
  /// \param Req request that is not matched by a wait
  /// \param RequestRegion memory region of the request
  /// \param ExplNode node in the graph the bug appeared at
  /// \param BReporter bug reporter for current context
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::reportMissingWait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp", line = 50,
   FQN="clang::ento::mpi::MPIBugReporter::reportMissingWait", NM="_ZNK5clang4ento3mpi14MPIBugReporter17reportMissingWaitERKNS1_7RequestEPKNS0_9MemRegionEPKNS0_12ExplodedNodeERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZNK5clang4ento3mpi14MPIBugReporter17reportMissingWaitERKNS1_7RequestEPKNS0_9MemRegionEPKNS0_12ExplodedNodeERNS0_11BugReporterE")
  //</editor-fold>
  public void reportMissingWait(final /*const*/ Request /*&*/ Req, /*const*/ MemRegion /*P*/ /*const*/ RequestRegion, 
                   /*const*/ ExplodedNode /*P*/ /*const*/ ExplNode, 
                   final BugReporter /*&*/ BReporter) /*const*/ {
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string ErrorText/*J*/= /*{ */$add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"Request ", RequestRegion.getDescriptiveName()), 
          /*KEEP_STR*/" has no matching wait. ")/* }*/;
      
      Report = llvm.make_unique(new BugReport(MissingWaitBugType.$star(), ErrorText, ExplNode));
      
      SourceRange Range = RequestRegion.sourceRange();
      if (Range.isValid()) {
        Report.$arrow().addRange(new SourceRange(Range));
      }
      Report.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new RequestNodeVisitor(RequestRegion, $("Request is previously used by nonblocking call here. "))))))); $c$.clean();
      Report.$arrow().markInteresting(RequestRegion);
      
      BReporter.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Report a wait on a request that has not been used at all before.
  ///
  /// \param CE wait call that uses the request
  /// \param RequestRegion memory region of the request
  /// \param ExplNode node in the graph the bug appeared at
  /// \param BReporter bug reporter for current context
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::reportUnmatchedWait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp", line = 70,
   FQN="clang::ento::mpi::MPIBugReporter::reportUnmatchedWait", NM="_ZNK5clang4ento3mpi14MPIBugReporter19reportUnmatchedWaitERKNS0_9CallEventEPKNS0_9MemRegionEPKNS0_12ExplodedNodeERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZNK5clang4ento3mpi14MPIBugReporter19reportUnmatchedWaitERKNS0_9CallEventEPKNS0_9MemRegionEPKNS0_12ExplodedNodeERNS0_11BugReporterE")
  //</editor-fold>
  public void reportUnmatchedWait(final /*const*/ CallEvent /*&*/ CE, /*const*/ MemRegion /*P*/ /*const*/ RequestRegion, 
                     /*const*/ ExplodedNode /*P*/ /*const*/ ExplNode, 
                     final BugReporter /*&*/ BReporter) /*const*/ {
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string ErrorText/*J*/= /*{ */$add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"Request ", RequestRegion.getDescriptiveName()), 
          /*KEEP_STR*/" has no matching nonblocking call. ")/* }*/;
      
      Report = llvm.make_unique(new BugReport(UnmatchedWaitBugType.$star(), ErrorText, ExplNode));
      
      Report.$arrow().addRange(CE.getSourceRange());
      SourceRange Range = RequestRegion.sourceRange();
      if (Range.isValid()) {
        Report.$arrow().addRange(new SourceRange(Range));
      }
      
      BReporter.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      $c$.$destroy();
    }
  }

/*private:*/
  private /*const*/std.string MPIError/* = "MPI Error"*/;
  
  // path-sensitive bug types
  private std.unique_ptr<BugType> UnmatchedWaitBugType;
  private std.unique_ptr<BugType> MissingWaitBugType;
  private std.unique_ptr<BugType> DoubleNonblockingBugType;
  
  /// Bug visitor class to find the node where the request region was previously
  /// used in order to include it into the BugReport path.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.h", line = 83,
   FQN="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor", NM="_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitorE")
  //</editor-fold>
  private static class RequestNodeVisitor extends /*public*/ BugReporterVisitorImpl<RequestNodeVisitor> implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::RequestNodeVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.h", line = 85,
     FQN="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::RequestNodeVisitor", NM="_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitorC1EPKNS0_9MemRegionERKSs",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitorC1EPKNS0_9MemRegionERKSs")
    //</editor-fold>
    public RequestNodeVisitor(/*const*/ MemRegion /*P*/ /*const*/ MemoryRegion, 
        final /*const*/std.string/*&*/ ErrText) {
      // : BugReporterVisitorImpl<RequestNodeVisitor>(), RequestRegion(MemoryRegion), IsNodeFound(false), ErrorText(ErrText) 
      //START JInit
      super();
      this.RequestRegion = MemoryRegion;
      /*InClass*/this.IsNodeFound = false;
      this.ErrorText = new std.string(ErrText);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::Profile">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.h", line = 89,
     FQN="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::Profile", NM="_ZNK5clang4ento3mpi14MPIBugReporter18RequestNodeVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZNK5clang4ento3mpi14MPIBugReporter18RequestNodeVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
      final/*static*/ Object X = Profile$$.X;
      ID.AddPointer($AddrOf(X));
      ID.AddPointer(RequestRegion);
    }
    private static final class Profile$$ {
      static final/*static*/ Object X = RequestNodeVisitor.class;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::VisitNode">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp", line = 88,
     FQN="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::VisitNode", NM="_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitor9VisitNodeEPKNS0_12ExplodedNodeES6_RNS0_18BugReporterContextERNS0_9BugReportE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitor9VisitNodeEPKNS0_12ExplodedNodeES6_RNS0_18BugReporterContextERNS0_9BugReportE")
    //</editor-fold>
    @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, /*const*/ ExplodedNode /*P*/ PrevN, final BugReporterContext /*&*/ BRC, 
             final BugReport /*&*/ BR)/* override*/ {
      if (IsNodeFound) {
        return null;
      }
      
      /*const*/ Request /*P*/ /*const*/ Req = N.getState().$arrow().get(ProgramStateTraitRequestMap.$Instance, RequestRegion);
      /*const*/ Request /*P*/ /*const*/ PrevReq = PrevN.getState().$arrow().get(ProgramStateTraitRequestMap.$Instance, RequestRegion);
      
      // Check if request was previously unused or in a different state.
      if (((Req != null) && !(PrevReq != null)) || (Req.CurrentState != PrevReq.CurrentState)) {
        IsNodeFound = true;
        
        ProgramPoint P = PrevN.getLocation();
        PathDiagnosticLocation L = PathDiagnosticLocation.create(P, BRC.getSourceManager());
        
        return new PathDiagnosticEventPiece(L, new StringRef(ErrorText));
      }
      
      return null;
    }

  /*private:*/
    private /*const*/ MemRegion /*P*/ /*const*/ RequestRegion;
    private boolean IsNodeFound/* = false*/;
    private std.string ErrorText;
    //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::RequestNodeVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.h", line = 83,
     FQN="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::RequestNodeVisitor", NM="_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitorC1ERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitorC1ERKS3_")
    //</editor-fold>
    public /*inline*/ RequestNodeVisitor(final /*const*/ RequestNodeVisitor /*&*/ $Prm0) {
      // : BugReporterVisitorImpl<RequestNodeVisitor>(), RequestRegion(.RequestRegion), IsNodeFound(.IsNodeFound), ErrorText(.ErrorText) 
      //START JInit
      super($Prm0);
      this.RequestRegion = $Prm0.RequestRegion;
      this.IsNodeFound = $Prm0.IsNodeFound;
      this.ErrorText = new std.string($Prm0.ErrorText);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::~RequestNodeVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.h", line = 83,
     FQN="clang::ento::mpi::MPIBugReporter::RequestNodeVisitor::~RequestNodeVisitor", NM="_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi14MPIBugReporter18RequestNodeVisitorD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      ErrorText.$destroy();
      super.$destroy();
      //END JDestroy
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public RequestNodeVisitor clone() {
      return new RequestNodeVisitor(this);
    }
  
    public RequestNodeVisitor(/*const*/ MemRegion /*P*/ /*const*/ MemoryRegion, 
      final /*const*/char$ptr/*&*/ ErrText) {
      this(MemoryRegion, new std.string(ErrText));
    }    
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "RequestRegion=" + RequestRegion // NOI18N
                + ", IsNodeFound=" + IsNodeFound // NOI18N
                + ", ErrorText=" + ErrorText // NOI18N
                + super.toString(); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIBugReporter::~MPIBugReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.h", line = 26,
   FQN="clang::ento::mpi::MPIBugReporter::~MPIBugReporter", NM="_ZN5clang4ento3mpi14MPIBugReporterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi14MPIBugReporterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DoubleNonblockingBugType.$destroy();
    MissingWaitBugType.$destroy();
    UnmatchedWaitBugType.$destroy();
    MPIError.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "MPIError=" + MPIError // NOI18N
              + ", UnmatchedWaitBugType=" + UnmatchedWaitBugType // NOI18N
              + ", MissingWaitBugType=" + MissingWaitBugType // NOI18N
              + ", DoubleNonblockingBugType=" + DoubleNonblockingBugType; // NOI18N
  }
}
