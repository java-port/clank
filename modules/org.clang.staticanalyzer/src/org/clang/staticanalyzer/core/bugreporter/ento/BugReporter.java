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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.impl.BugReporterStatics;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.impl.BugReporterStatics.*;


/// BugReporter is a utility class for generating PathDiagnostics for analysis.
/// It collects the BugReports and BugTypes and knows how to generate
/// and flush the corresponding diagnostics.
//<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 388,
 FQN="clang::ento::BugReporter", NM="_ZN5clang4ento11BugReporterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporterE")
//</editor-fold>
public class BugReporter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 390,
   FQN="clang::ento::BugReporter::Kind", NM="_ZN5clang4ento11BugReporter4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter4KindE")
  //</editor-fold>
  public enum Kind implements Native.NativeUIntEnum {
    BaseBRKind(0),
    GRBugReporterKind(BaseBRKind.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  // JAVA: typedef llvm::ImmutableSet<BugType *> BugTypesTy
//  public final class BugTypesTy extends ImmutableSetPtr<BugType /*P*/ >{ };
  private ImmutableSetPtr.Factory<BugType /*P*/ > F;
  private ImmutableSetPtr<BugType /*P*/ > BugTypes;
  
  private /*const*/ Kind kind;
  private final BugReporterData /*&*/ D;
  
  /// Generate and flush the diagnostics for the given bug report.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::FlushReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3379,
   FQN="clang::ento::BugReporter::FlushReport", NM="_ZN5clang4ento11BugReporter11FlushReportERNS0_19BugReportEquivClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter11FlushReportERNS0_19BugReportEquivClassE")
  //</editor-fold>
  private void FlushReport(final BugReportEquivClass /*&*/ EQ) {
    SmallVector<BugReport /*P*/ > bugReports/*J*/= new SmallVector<BugReport /*P*/ >(10, (BugReport /*P*/ )null);
    BugReport /*P*/ exampleReport = BugReporterStatics.FindReportInEquivalenceClass(EQ, bugReports);
    if ((exampleReport != null)) {
      for (PathDiagnosticConsumer /*P*/ PDC : getPathDiagnosticConsumers()) {
        FlushReport(exampleReport, $Deref(PDC), new ArrayRef<BugReport /*P*/ >(bugReports, true));
      }
    }
  }

  
  /// Generate and flush the diagnostics for the given bug report
  /// and PathDiagnosticConsumer.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::FlushReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3389,
   FQN="clang::ento::BugReporter::FlushReport", NM="_ZN5clang4ento11BugReporter11FlushReportEPNS0_9BugReportERNS0_22PathDiagnosticConsumerEN4llvm8ArrayRefIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter11FlushReportEPNS0_9BugReportERNS0_22PathDiagnosticConsumerEN4llvm8ArrayRefIS3_EE")
  //</editor-fold>
  private void FlushReport(BugReport /*P*/ exampleReport, 
             final PathDiagnosticConsumer /*&*/ PD, 
             ArrayRef<BugReport /*P*/ > bugReports) {
    std.unique_ptr<PathDiagnostic> D = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // FIXME: Make sure we use the 'R' for the path that was actually used.
      // Probably doesn't make a difference in practice.
      final BugType /*&*/ BT = exampleReport.getBugType();
      
      D/*J*/= new std.unique_ptr<PathDiagnostic>(new PathDiagnostic(exampleReport.getBugType().getCheckName(), 
              exampleReport.getDeclWithIssue(), exampleReport.getBugType().getName(), 
              exampleReport.getDescription(), 
              exampleReport.getShortDescription(/*Fallback=*/ false), BT.getCategory(), 
              exampleReport.getUniqueingLocation(), 
              exampleReport.getUniqueingDecl()));
      
      MaxBugClassSize.$assign(std.max(bugReports.size(), 
              ((/*static_cast*//*size_t*/int)(MaxBugClassSize.$uint()))));
      
      // Generate the full path diagnostic, using the generation scheme
      // specified by the PathDiagnosticConsumer. Note that we have to generate
      // path diagnostics even for consumers which do not support paths, because
      // the BugReporterVisitors may mark this bug as a false positive.
      if (!bugReports.empty()) {
        if (!generatePathDiagnostic($Deref(D.get()), PD, bugReports)) {
          return;
        }
      }
      
      MaxValidBugClassSize.$assign(std.max(bugReports.size(), 
              ((/*static_cast*//*size_t*/int)(MaxValidBugClassSize.$uint()))));
      
      // Examine the report and see if the last piece is in a header. Reset the
      // report location to the last piece in the main source file.
      final AnalyzerOptions /*&*/ Opts = getAnalyzerOptions();
      if (Opts.shouldReportIssuesInMainSourceFile() && !Opts.AnalyzeAll) {
        D.$arrow().resetDiagnosticLocationToMainFile();
      }
      
      // If the path is empty, generate a single step path with the location
      // of the issue.
      if (D.$arrow()._path.empty()) {
        unique_ptr<PathDiagnosticEventPiece> piece = null;
        try {
          PathDiagnosticLocation L = exampleReport.getLocation(getSourceManager());
          piece = llvm.make_unique(new PathDiagnosticEventPiece(L, exampleReport.getDescription()));
          for (SourceRange Range : exampleReport.getRanges())  {
            piece.$arrow().addRange(new SourceRange(Range));
          }
          D.$arrow().setEndOfPath($c$.track(new std.unique_ptr<PathDiagnosticPiece>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(piece)))); $c$.clean();
        } finally {
          if (piece != null) { piece.$destroy(); }
        }
      }
      
      // Get the meta data.
      final /*const*/SmallVector<StringRef> /*&*/ Meta = exampleReport.getExtraText();
      for (type$ptr</*const*/ StringRef /*P*/ > i = $tryClone(Meta.begin$Const()), 
          /*P*/ e = $tryClone(Meta.end$Const()); $noteq_ptr(i, e); i.$preInc()) {
        D.$arrow().addMeta(new StringRef(i.$star()));
      }
      
      PD.HandlePathDiagnostic($c$.track(new std.unique_ptr<PathDiagnostic>(JD$Move.INSTANCE, std.move(D)))); $c$.clean();
    } finally {
      if (D != null) { D.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// The set of bug reports tracked by the BugReporter.
  private FoldingSet<BugReportEquivClass> EQClasses;
  /// A vector of BugReports for tracking the allocated pointers and cleanup.
  private std.vector<BugReportEquivClass /*P*/ > EQClassesVector;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::BugReporter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 415,
   FQN="clang::ento::BugReporter::BugReporter", NM="_ZN5clang4ento11BugReporterC1ERNS0_15BugReporterDataENS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporterC1ERNS0_15BugReporterDataENS1_4KindE")
  //</editor-fold>
  protected BugReporter(final BugReporterData /*&*/ d, Kind k) {
    // : F(), BugTypes($c$.track(F.getEmptySet())), kind(k), D(d), EQClasses(), EQClassesVector(), StrBugTypes() 
    //START JInit
    this.F = new ImmutableSetPtr.Factory<BugType /*P*/ >(new ImutContainerInfoT$P(null));
    this.BugTypes = F.getEmptySet();
    this.kind = k;
    this./*&*/D=/*&*/d;
    this.EQClasses = new FoldingSet<BugReportEquivClass>(BugReportEquivClass.$Trait());
    this.EQClassesVector = new std.vector<BugReportEquivClass /*P*/ >((BugReportEquivClass /*P*/ )null);
    this.StrBugTypes = new StringMap<BugType /*P*/ >((BugType /*P*/ )null);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::BugReporter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 419,
   FQN="clang::ento::BugReporter::BugReporter", NM="_ZN5clang4ento11BugReporterC1ERNS0_15BugReporterDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporterC1ERNS0_15BugReporterDataE")
  //</editor-fold>
  public BugReporter(final BugReporterData /*&*/ d) {
    // : F(), BugTypes($c$.track(F.getEmptySet())), kind(BaseBRKind), D(d), EQClasses(), EQClassesVector(), StrBugTypes() 
    //START JInit
    this.F = new ImmutableSetPtr.Factory<BugType /*P*/ >(new ImutContainerInfoT$P(null));
    this.BugTypes = F.getEmptySet();
    this.kind = Kind.BaseBRKind;
    this./*&*/D=/*&*/d;
    this.EQClasses = new FoldingSet<BugReportEquivClass>(BugReportEquivClass.$Trait());
    this.EQClassesVector = new std.vector<BugReportEquivClass /*P*/ >((BugReportEquivClass /*P*/ )null);
    this.StrBugTypes = new StringMap<BugType /*P*/ >((BugType /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::~BugReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2742,
   FQN="clang::ento::BugReporter::~BugReporter", NM="_ZN5clang4ento11BugReporterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporterD0Ev")
  //</editor-fold>
  public void $destroy() {
    FlushReports();
    
    // Free the bug reports we are tracking.
    // JAVA: typedef std::vector<BugReportEquivClass *> ContTy
//    final class ContTy extends std.vector<BugReportEquivClass /*P*/ >{ };
    for (std.vector.iterator<BugReportEquivClass /*P*/ > I = EQClassesVector.begin(), E = EQClassesVector.end();
         $noteq___normal_iterator$C(I, E); I.$preInc()) {
      if (I.$star() != null) { I.$star().$destroy();};
    }
    //START JDestroy
    StrBugTypes.$destroy();
    EQClassesVector.$destroy();
    EQClasses.$destroy();
    BugTypes.$destroy();
    F.$destroy();
    //END JDestroy
  }

  
  /// \brief Generate and flush diagnostics for all bug reports.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::FlushReports">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2753,
   FQN="clang::ento::BugReporter::FlushReports", NM="_ZN5clang4ento11BugReporter12FlushReportsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter12FlushReportsEv")
  //</editor-fold>
  public void FlushReports() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (BugTypes.isEmpty()) {
        return;
      }

      // First flush the warnings for each BugType.  This may end up creating new
      // warnings and new BugTypes.
      // FIXME: Only NSErrorChecker needs BugType's FlushReports.
      // Turn NSErrorChecker into a proper checker and remove this.
      SmallVector</*const*/ BugType /*P*/ > bugTypes/*J*/= new SmallVector</*const*/ BugType /*P*/ >(JD$T.INSTANCE, 16, BugTypes.begin(), BugTypes.end(), (/*const*/ BugType /*P*/ )null);
      for (type$ptr</*const*/ BugType /*P*/ /*P*/> I = $tryClone(bugTypes.begin()), /*P*/ E = $tryClone(bugTypes.end()); $noteq_ptr(I, E); I.$preInc())  {
        ((/*const_cast*/BugType /*P*/ )(I.$star())).FlushReports(/*Deref*/this);
      }

      // We need to flush reports in deterministic order to ensure the order
      // of the reports is consistent between runs.
      // JAVA: typedef std::vector<BugReportEquivClass *> ContVecTy
//      final class ContVecTy extends std.vector<BugReportEquivClass /*P*/ >{ };
      for (std.vector.iterator<BugReportEquivClass /*P*/ > EI = EQClassesVector.begin(), EE = EQClassesVector.end();
           $noteq___normal_iterator$C(EI, EE); EI.$preInc()) {
        final BugReportEquivClass /*&*/ EQ = $Deref(EI.$star());
        FlushReport(EQ);
      }

      // BugReporter owns and deletes only BugTypes created implicitly through
      // EmitBasicReport.
      // FIXME: There are leaks from checkers that assume that the BugTypes they
      // create will be destroyed by the BugReporter.
      llvm.DeleteContainerSeconds(StrBugTypes);

      // Remove all references to the BugType objects.
      $c$.clean(BugTypes.$assign($c$.track(F.getEmptySet())));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 426,
   FQN="clang::ento::BugReporter::getKind", NM="_ZNK5clang4ento11BugReporter7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento11BugReporter7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::getDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 428,
   FQN="clang::ento::BugReporter::getDiagnostic", NM="_ZN5clang4ento11BugReporter13getDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter13getDiagnosticEv")
  //</editor-fold>
  public DiagnosticsEngine /*&*/ getDiagnostic() {
    return D.getDiagnostic();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::getPathDiagnosticConsumers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 432,
   FQN="clang::ento::BugReporter::getPathDiagnosticConsumers", NM="_ZN5clang4ento11BugReporter26getPathDiagnosticConsumersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter26getPathDiagnosticConsumersEv")
  //</editor-fold>
  public ArrayRef<PathDiagnosticConsumer /*P*/ > getPathDiagnosticConsumers() {
    return D.getPathDiagnosticConsumers();
  }

  
  /// \brief Iterator over the set of BugTypes tracked by the BugReporter.
  // JAVA: typedef BugTypesTy::iterator iterator
//  public final class iterator extends ImutAVLValueIteratorPtrBoolPtr<BugType /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 438,
   FQN="clang::ento::BugReporter::begin", NM="_ZN5clang4ento11BugReporter5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter5beginEv")
  //</editor-fold>
  public ImutAVLValueIteratorPtrBoolPtr<BugType /*P*/ > begin() {
    return BugTypes.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 439,
   FQN="clang::ento::BugReporter::end", NM="_ZN5clang4ento11BugReporter3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter3endEv")
  //</editor-fold>
  public ImutAVLValueIteratorPtrBoolPtr<BugType /*P*/ > end() {
    return BugTypes.end();
  }

  
  /// \brief Iterator over the set of BugReports tracked by the BugReporter.
  // JAVA: typedef llvm::FoldingSet<BugReportEquivClass>::iterator EQClasses_iterator
//  public final class EQClasses_iterator extends FoldingSetIterator<BugReportEquivClass>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::EQClasses_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 443,
   FQN="clang::ento::BugReporter::EQClasses_begin", NM="_ZN5clang4ento11BugReporter15EQClasses_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter15EQClasses_beginEv")
  //</editor-fold>
  public FoldingSetIterator<BugReportEquivClass> EQClasses_begin() {
    return EQClasses.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::EQClasses_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 444,
   FQN="clang::ento::BugReporter::EQClasses_end", NM="_ZN5clang4ento11BugReporter13EQClasses_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter13EQClasses_endEv")
  //</editor-fold>
  public FoldingSetIterator<BugReportEquivClass> EQClasses_end() {
    return EQClasses.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 446,
   FQN="clang::ento::BugReporter::getContext", NM="_ZN5clang4ento11BugReporter10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() {
    return D.getASTContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 448,
   FQN="clang::ento::BugReporter::getSourceManager", NM="_ZN5clang4ento11BugReporter16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() {
    return D.getSourceManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::getAnalyzerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 450,
   FQN="clang::ento::BugReporter::getAnalyzerOptions", NM="_ZN5clang4ento11BugReporter18getAnalyzerOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter18getAnalyzerOptionsEv")
  //</editor-fold>
  public AnalyzerOptions /*&*/ getAnalyzerOptions() {
    return D.getAnalyzerOptions();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::generatePathDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 452,
   FQN="clang::ento::BugReporter::generatePathDiagnostic", NM="_ZN5clang4ento11BugReporter22generatePathDiagnosticERNS0_14PathDiagnosticERNS0_22PathDiagnosticConsumerERN4llvm8ArrayRefIPNS0_9BugReportEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter22generatePathDiagnosticERNS0_14PathDiagnosticERNS0_22PathDiagnosticConsumerERN4llvm8ArrayRefIPNS0_9BugReportEEE")
  //</editor-fold>
  public /*virtual*/ boolean generatePathDiagnostic(final PathDiagnostic /*&*/ pathDiagnostic, 
                        final PathDiagnosticConsumer /*&*/ PC, 
                        final ArrayRef<BugReport /*P*/ > /*&*/ bugReports) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::RemoveUnneededCalls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 458,
   FQN="clang::ento::BugReporter::RemoveUnneededCalls", NM="_ZN5clang4ento11BugReporter19RemoveUnneededCallsERNS0_10PathPiecesEPNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter19RemoveUnneededCallsERNS0_10PathPiecesEPNS0_9BugReportE")
  //</editor-fold>
  public boolean RemoveUnneededCalls(final PathPieces /*&*/ pieces, BugReport /*P*/ R) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::Register">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3218,
   FQN="clang::ento::BugReporter::Register", NM="_ZN5clang4ento11BugReporter8RegisterEPNS0_7BugTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter8RegisterEPNS0_7BugTypeE")
  //</editor-fold>
  public void Register(BugType /*P*/ BT) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(BugTypes.$assign($c$.track(F.add($c$.track(new ImmutableSetPtr<BugType /*P*/ >(BugTypes)), BT))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Add the given report to the set of reports tracked by BugReporter.
  ///
  /// The reports are usually generated by the checkers. Further, they are
  /// folded based on the profile value, which is done to coalesce similar
  /// reports.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::emitReport">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3222,
   FQN="clang::ento::BugReporter::emitReport", NM="_ZN5clang4ento11BugReporter10emitReportESt10unique_ptrINS0_9BugReportESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter10emitReportESt10unique_ptrINS0_9BugReportESt14default_deleteIS3_EE")
  //</editor-fold>
  public void emitReport(std.unique_ptr<BugReport> R) {
    {
      /*const*/ ExplodedNode /*P*/ E = R.$arrow().getErrorNode();
      if ((E != null)) {
        // An error node must either be a sink or have a tag, otherwise
        // it could get reclaimed before the path diagnostic is created.
        assert ((E.isSink() || (E.getLocation().getTag() != null))) : "Error node must either be a sink or have a tag";
        
        /*const*/ AnalysisDeclContext /*P*/ DeclCtx = E.getLocationContext().getAnalysisDeclContext();
        // The source of autosynthesized body can be handcrafted AST or a model
        // file. The locations from handcrafted ASTs have no valid source locations
        // and have to be discarded. Locations from model files should be preserved
        // for processing and reporting.
        if (DeclCtx.isBodyAutosynthesized()
           && !DeclCtx.isBodyAutosynthesizedFromModelFile()) {
          return;
        }
      }
    }
    
    boolean ValidSourceLoc = R.$arrow().getLocation(getSourceManager()).isValid();
    assert (ValidSourceLoc);
    // If we mess up in a release build, we'd still prefer to just drop the bug
    // instead of trying to go on.
    if (!ValidSourceLoc) {
      return;
    }
    
    // Compute the bug report's hash to determine its equivalence class.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    R.$arrow().Profile(ID);
    
    // Lookup the equivance class.  If there isn't one, create it.
    final BugType /*&*/ BT = R.$arrow().getBugType();
    Register($AddrOf(BT));
    final type$ref<type$ptr<BugReportEquivClass /*P*/>/*void P*/ > InsertPos = create_type$ref(null);
    BugReportEquivClass /*P*/ EQ = EQClasses.FindNodeOrInsertPos(ID, InsertPos);
    if (!(EQ != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(EQ = new BugReportEquivClass($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))));
        EQClasses.InsertNode(EQ, InsertPos.$deref());
        EQClassesVector.push_back_T$C$R(EQ);
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        EQ.AddReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::EmitBasicReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3446,
   FQN="clang::ento::BugReporter::EmitBasicReport", NM="_ZN5clang4ento11BugReporter15EmitBasicReportEPKNS_4DeclEPKNS0_11CheckerBaseEN4llvm9StringRefES9_S9_NS0_22PathDiagnosticLocationENS8_8ArrayRefINS_11SourceRangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter15EmitBasicReportEPKNS_4DeclEPKNS0_11CheckerBaseEN4llvm9StringRefES9_S9_NS0_22PathDiagnosticLocationENS8_8ArrayRefINS_11SourceRangeEEE")
  //</editor-fold>
  public void EmitBasicReport(/*const*/ Decl /*P*/ DeclWithIssue, 
                 /*const*/ CheckerBase /*P*/ Checker, 
                 StringRef Name, StringRef Category, 
                 StringRef Str, PathDiagnosticLocation Loc) {
    EmitBasicReport(DeclWithIssue, 
                 Checker, 
                 Name, Category, 
                 Str, Loc, 
                 new ArrayRef<SourceRange>(None, false));
  }
  public void EmitBasicReport(/*const*/ Decl /*P*/ DeclWithIssue, 
                 /*const*/ CheckerBase /*P*/ Checker, 
                 StringRef Name, StringRef Category, 
                 StringRef Str, PathDiagnosticLocation Loc, 
                 ArrayRef<SourceRange> Ranges/*= None*/) {
    EmitBasicReport(DeclWithIssue, Checker.getCheckName(), new StringRef(Name), new StringRef(Category), new StringRef(Str), 
        new PathDiagnosticLocation(Loc), new ArrayRef<SourceRange>(Ranges));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::EmitBasicReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3454,
   FQN="clang::ento::BugReporter::EmitBasicReport", NM="_ZN5clang4ento11BugReporter15EmitBasicReportEPKNS_4DeclENS0_9CheckNameEN4llvm9StringRefES7_S7_NS0_22PathDiagnosticLocationENS6_8ArrayRefINS_11SourceRangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter15EmitBasicReportEPKNS_4DeclENS0_9CheckNameEN4llvm9StringRefES7_S7_NS0_22PathDiagnosticLocationENS6_8ArrayRefINS_11SourceRangeEEE")
  //</editor-fold>
  public void EmitBasicReport(/*const*/ Decl /*P*/ DeclWithIssue, 
                 CheckName $CheckName, 
                 StringRef name, StringRef category, 
                 StringRef str, PathDiagnosticLocation Loc) {
    EmitBasicReport(DeclWithIssue, 
                 $CheckName, 
                 name, category, 
                 str, Loc, 
                 new ArrayRef<SourceRange>(None, false));
  }
  public void EmitBasicReport(/*const*/ Decl /*P*/ DeclWithIssue, 
                 CheckName $CheckName, 
                 StringRef name, StringRef category, 
                 StringRef str, PathDiagnosticLocation Loc, 
                 ArrayRef<SourceRange> Ranges/*= None*/) {
    unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // 'BT' is owned by BugReporter.
      BugType /*P*/ BT = getBugTypeForName(new CheckName($CheckName), new StringRef(name), new StringRef(category));
      R = llvm.make_unique(new BugReport($Deref(BT), str, Loc));
      R.$arrow().setDeclWithIssue(DeclWithIssue);
      for (type$ptr<SourceRange> I = $tryClone(Ranges.begin()), /*P*/ E = $tryClone(Ranges.end());
           $noteq_ptr(I, E); I.$preInc())  {
        R.$arrow().addRange(new SourceRange(I.$star()));
      }
      emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      $c$.$destroy();
    }
  }

/*private:*/
  private StringMap<BugType /*P*/ > StrBugTypes;
  
  /// \brief Returns a BugType that is associated with the given name and
  /// category.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporter::getBugTypeForName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3470,
   FQN="clang::ento::BugReporter::getBugTypeForName", NM="_ZN5clang4ento11BugReporter17getBugTypeForNameENS0_9CheckNameEN4llvm9StringRefES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento11BugReporter17getBugTypeForNameENS0_9CheckNameEN4llvm9StringRefES4_")
  //</editor-fold>
  private BugType /*P*/ getBugTypeForName(CheckName $CheckName, StringRef name, 
                   StringRef category) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SmallString/*<136>*/ fullDesc/*J*/= new SmallString/*<136>*/(136);
      $c$.clean($c$.track(new raw_svector_ostream(fullDesc)).$out($CheckName.getName()).$out(/*KEEP_STR*/$COLON).$out(/*NO_COPY*/name).$out(
          /*KEEP_STR*/$COLON
      ).$out(/*NO_COPY*/category));
      final type$ref<BugType /*P*/ /*&*/> BT = StrBugTypes.ref$at(fullDesc.$StringRef());
      if (!(BT.$deref() != null)) {
        BT.$set(new BugType(new  CheckName($CheckName), new StringRef(name), new StringRef(category)));
      }
      return BT.$deref();
    } finally {
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", BugTypes=" + BugTypes // NOI18N
              + ", kind=" + kind // NOI18N
              + ", D=" + D // NOI18N
              + ", EQClasses=" + EQClasses // NOI18N
              + ", EQClassesVector=" + EQClassesVector // NOI18N
              + ", StrBugTypes=" + StrBugTypes; // NOI18N
  }
}
