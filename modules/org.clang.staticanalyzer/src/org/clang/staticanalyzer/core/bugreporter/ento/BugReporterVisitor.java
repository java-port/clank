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
import static org.clank.java.std.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// \brief BugReporterVisitors are used to add custom diagnostics along a path.
///
/// Custom visitors should subclass the BugReporterVisitorImpl class for a
/// default implementation of the clone() method.
/// (Warning: if you have a deep subclass of BugReporterVisitorImpl, the
/// default implementation of clone() will NOT do the right thing, and you
/// will have to provide your own implementation.)
//<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 39,
 FQN="clang::ento::BugReporterVisitor", NM="_ZN5clang4ento18BugReporterVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterVisitorE")
//</editor-fold>
public abstract class BugReporterVisitor extends FoldingSetImpl.NodeImpl$Tracker implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::BugReporterVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 41,
   FQN="clang::ento::BugReporterVisitor::BugReporterVisitor", NM="_ZN5clang4ento18BugReporterVisitorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterVisitorC1Ev")
  //</editor-fold>
  public BugReporterVisitor() {
    // : FoldingSetNode()/* = default*/ 
    //START JInit
    $Node();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::BugReporterVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 42,
   FQN="clang::ento::BugReporterVisitor::BugReporterVisitor", NM="_ZN5clang4ento18BugReporterVisitorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterVisitorC1ERKS1_")
  //</editor-fold>
  public BugReporterVisitor(final /*const*/ BugReporterVisitor /*&*/ $Prm0) {
    // : FoldingSetNode()/* = default*/ 
    //START JInit
    $Node($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::BugReporterVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 43,
   FQN="clang::ento::BugReporterVisitor::BugReporterVisitor", NM="_ZN5clang4ento18BugReporterVisitorC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterVisitorC1EOS1_")
  //</editor-fold>
  public BugReporterVisitor(JD$Move _dparam, final BugReporterVisitor /*&&*/$Prm0) {
    // : FoldingSetNode() 
    //START JInit
    $Node();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::~BugReporterVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 49,
   FQN="clang::ento::BugReporterVisitor::~BugReporterVisitor", NM="_ZN5clang4ento18BugReporterVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterVisitorD0Ev")
  //</editor-fold>
  public void $destroy() {
    FoldingSetImpl.Node.super.$destroy$Node();
  }

  
  /// \brief Returns a copy of this BugReporter.
  ///
  /// Custom BugReporterVisitors should not override this method directly.
  /// Instead, they should inherit from BugReporterVisitorImpl and provide
  /// a protected or public copy constructor.
  ///
  /// (Warning: if you have a deep subclass of BugReporterVisitorImpl, the
  /// default implementation of clone() will NOT do the right thing, and you
  /// will have to provide your own implementation.)
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 55,
   FQN="clang::ento::BugReporterVisitor::clone", NM="_ZNK5clang4ento18BugReporterVisitor5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento18BugReporterVisitor5cloneEv")
  //</editor-fold>
  public abstract /*virtual*/ std.unique_ptr<BugReporterVisitor> clone$Visitor() /*const*//* = 0*/;

  
  /// \brief Return a diagnostic piece which should be associated with the
  /// given node.
  ///
  /// The last parameter can be used to register a new visitor with the given
  /// BugReport while processing a node.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::VisitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 62,
   FQN="clang::ento::BugReporterVisitor::VisitNode", NM="_ZN5clang4ento18BugReporterVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento18BugReporterVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  public abstract /*virtual*/ PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ Succ, 
           /*const*/ ExplodedNode /*P*/ Pred, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* = 0*/;

  
  /// \brief Provide custom definition for the final diagnostic piece on the
  /// path - the piece, which is displayed before the path is expanded.
  ///
  /// If returns NULL the default implementation will be used.
  /// Also note that at most one visitor of a BugReport should generate a
  /// non-NULL end of path diagnostic piece.
  
  /// \brief Provide custom definition for the final diagnostic piece on the
  /// path - the piece, which is displayed before the path is expanded.
  ///
  /// If returns NULL the default implementation will be used.
  /// Also note that at most one visitor of a BugReport should generate a
  /// non-NULL end of path diagnostic piece.
  
  //===----------------------------------------------------------------------===//
  // Definitions for bug reporter visitors.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::getEndPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 104,
   FQN="clang::ento::BugReporterVisitor::getEndPath", NM="_ZN5clang4ento18BugReporterVisitor10getEndPathERNS0_18BugReporterContextEPKNS0_12ExplodedNodeERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18BugReporterVisitor10getEndPathERNS0_18BugReporterContextEPKNS0_12ExplodedNodeERNS0_9BugReportE")
  //</editor-fold>
  public std.unique_ptr<PathDiagnosticPiece> getEndPath(final BugReporterContext /*&*/ BRC, 
            /*const*/ ExplodedNode /*P*/ EndPathNode, final BugReport /*&*/ BR) {
    return new std.unique_ptr<PathDiagnosticPiece>(JD$NullPtr.INSTANCE, null);
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 76,
   FQN="clang::ento::BugReporterVisitor::Profile", NM="_ZNK5clang4ento18BugReporterVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento18BugReporterVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public abstract /*virtual*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* = 0*/;

  
  /// \brief Generates the default final diagnostic piece.
  
  /// \brief Generates the default final diagnostic piece.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReporterVisitor::getDefaultEndPath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 110,
   FQN="clang::ento::BugReporterVisitor::getDefaultEndPath", NM="_ZN5clang4ento18BugReporterVisitor17getDefaultEndPathERNS0_18BugReporterContextEPKNS0_12ExplodedNodeERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento18BugReporterVisitor17getDefaultEndPathERNS0_18BugReporterContextEPKNS0_12ExplodedNodeERNS0_9BugReportE")
  //</editor-fold>
  public static std.unique_ptr<PathDiagnosticPiece> getDefaultEndPath(final BugReporterContext /*&*/ BRC, /*const*/ ExplodedNode /*P*/ EndPathNode, final BugReport /*&*/ BR) {
    unique_ptr<PathDiagnosticEventPiece> P = null;
    try {
      PathDiagnosticLocation L = PathDiagnosticLocation.createEndOfPath(EndPathNode, BRC.getSourceManager());
      
      final /*const*/ iterator_range</*const*/ SourceRange> /*&*/ Ranges = BR.getRanges();
      
      // Only add the statement itself as a range if we didn't specify any
      // special ranges for this report.
      P = llvm.make_unique(new PathDiagnosticEventPiece(L, BR.getDescription(), Ranges.begin().$eq(Ranges.end())));
      for (SourceRange Range : Ranges)  {
        P.$arrow().addRange(new SourceRange(Range));
      }
      
      return new std.unique_ptr<PathDiagnosticPiece>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(P));
    } finally {
      if (P != null) { P.$destroy(); }
    }
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final FoldingSetTrait<BugReporterVisitor> $Trait = new DefaultFoldingSetTrait<BugReporterVisitor>();  
  
  public static FoldingSetTrait<BugReporterVisitor> $Trait() { return $Trait;  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
