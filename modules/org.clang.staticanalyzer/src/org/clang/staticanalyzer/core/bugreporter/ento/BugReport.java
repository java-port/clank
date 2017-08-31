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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.staticanalyzer.core.impl.BugReporterStatics.*;


//===----------------------------------------------------------------------===//
// Interface for individual bug reports.
//===----------------------------------------------------------------------===//

/// This class provides an interface through which checkers can create
/// individual bug reports.
//<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 55,
 FQN="clang::ento::BugReport", NM="_ZN5clang4ento9BugReportE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReportE")
//</editor-fold>
public class BugReport implements /*public*/ ilist_node<BugReport>, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::NodeResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 57,
   FQN="clang::ento::BugReport::NodeResolver", NM="_ZN5clang4ento9BugReport12NodeResolverE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport12NodeResolverE")
  //</editor-fold>
  public abstract static class NodeResolver implements Destructors.ClassWithDestructor {
    
    //===----------------------------------------------------------------------===//
    // Methods for BugReport and subclasses.
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::NodeResolver::anchor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2533,
     FQN="clang::ento::BugReport::NodeResolver::anchor", NM="_ZN5clang4ento9BugReport12NodeResolver6anchorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport12NodeResolver6anchorEv")
    //</editor-fold>
    protected/*private*/ void anchor() {
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::NodeResolver::~NodeResolver">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 60,
     FQN="clang::ento::BugReport::NodeResolver::~NodeResolver", NM="_ZN5clang4ento9BugReport12NodeResolverD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport12NodeResolverD0Ev")
    //</editor-fold>
    public /*virtual*/ void $destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::NodeResolver::getOriginalNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 61,
     FQN="clang::ento::BugReport::NodeResolver::getOriginalNode", NM="_ZN5clang4ento9BugReport12NodeResolver15getOriginalNodeEPKNS0_12ExplodedNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport12NodeResolver15getOriginalNodeEPKNS0_12ExplodedNodeE")
    //</editor-fold>
    public abstract /*virtual*/ /*const*/ ExplodedNode /*P*/ getOriginalNode(/*const*/ ExplodedNode /*P*/ N)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::NodeResolver::NodeResolver">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 57,
     FQN="clang::ento::BugReport::NodeResolver::NodeResolver", NM="_ZN5clang4ento9BugReport12NodeResolverC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport12NodeResolverC1Ev")
    //</editor-fold>
    public /*inline*/ NodeResolver() {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /*typedef const SourceRange *ranges_iterator*/
//  public final class ranges_iterator extends /*const*/ SourceRange /*P*/ { };
  /*typedef SmallVector<std::unique_ptr<BugReporterVisitor>, 8> VisitorList*/
//  public final class VisitorList extends SmallVector<std.unique_ptr<BugReporterVisitor>>{ };
  /*typedef VisitorList::iterator visitor_iterator*/
//  public final class visitor_iterator extends type$ptr<unique_ptr<BugReporterVisitor> /*P*/>{ };
  /*typedef SmallVector<StringRef, 2> ExtraTextList*/
//  public final class ExtraTextList extends SmallVector<StringRef>{ };
/*protected:*/
  /*friend  class BugReporter*/
  /*friend  class BugReportEquivClass*/
  
  protected final BugType /*&*/ BT;
  protected /*const*/ Decl /*P*/ DeclWithIssue;
  protected std.string ShortDescription;
  protected std.string Description;
  protected PathDiagnosticLocation Location;
  protected PathDiagnosticLocation UniqueingLocation;
  protected /*const*/ Decl /*P*/ UniqueingDecl;
  
  protected /*const*/ ExplodedNode /*P*/ ErrorNode;
  protected SmallVector<SourceRange> Ranges;
  protected SmallVector<StringRef> ExtraText;
  
  /*typedef llvm::DenseSet<SymbolRef> Symbols*/
//  public final class Symbols extends DenseSet</*const*/ SymExpr /*P*/ >{ };
  /*typedef llvm::DenseSet<const MemRegion *> Regions*/
//  public final class Regions extends DenseSet</*const*/ MemRegion /*P*/ >{ };
  
  /// A (stack of) a set of symbols that are registered with this
  /// report as being "interesting", and thus used to help decide which
  /// diagnostics to include when constructing the final path diagnostic.
  /// The stack is largely used by BugReporter when generating PathDiagnostics
  /// for multiple PathDiagnosticConsumers.
  protected SmallVector<DenseSet</*const*/ SymExpr /*P*/ > /*P*/> interestingSymbols;
  
  /// A (stack of) set of regions that are registered with this report as being
  /// "interesting", and thus used to help decide which diagnostics
  /// to include when constructing the final path diagnostic.
  /// The stack is largely used by BugReporter when generating PathDiagnostics
  /// for multiple PathDiagnosticConsumers.
  protected SmallVector<DenseSet</*const*/ MemRegion /*P*/ > /*P*/> interestingRegions;
  
  /// A set of location contexts that correspoind to call sites which should be
  /// considered "interesting".
  protected SmallSetT$PLess$T$P</*const*/ LocationContext /*P*/ > InterestingLocationContexts;
  
  /// A set of custom visitors which generate "event" diagnostics at
  /// interesting points in the path.
  protected SmallVector<std.unique_ptr<BugReporterVisitor>> Callbacks;
  
  /// Used for ensuring the visitors are only added once.
  protected FoldingSet<BugReporterVisitor> CallbacksSet;
  
  /// Used for clients to tell if the report's configuration has changed
  /// since the last time they checked.
  protected /*uint*/int ConfigurationChangeToken;
  
  /// When set, this flag disables all callstack pruning from a diagnostic
  /// path.  This is useful for some reports that want maximum fidelty
  /// when reporting an issue.
  protected boolean DoNotPrunePath;
  
  /// Used to track unique reasons why a bug report might be invalid.
  ///
  /// \sa markInvalid
  /// \sa removeInvalidation
  /*typedef std::pair<const void *, const void *> InvalidationRecord*/
//  public final class InvalidationRecord extends std.pair</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >{ };
  
  /// If non-empty, this bug report is likely a false positive and should not be
  /// shown to the user.
  ///
  /// \sa markInvalid
  /// \sa removeInvalidation
  protected SmallSet<std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >> Invalidations;
/*private:*/
  // Used internally by BugReporter.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getInterestingSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2663,
   FQN="clang::ento::BugReport::getInterestingSymbols", NM="_ZN5clang4ento9BugReport21getInterestingSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport21getInterestingSymbolsEv")
  //</editor-fold>
  private DenseSet</*const*/ SymExpr /*P*/ > /*&*/ getInterestingSymbols() {
    lazyInitializeInterestingSets();
    return $Deref(interestingSymbols.back());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getInterestingRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2668,
   FQN="clang::ento::BugReport::getInterestingRegions", NM="_ZN5clang4ento9BugReport21getInterestingRegionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport21getInterestingRegionsEv")
  //</editor-fold>
  private DenseSet</*const*/ MemRegion /*P*/ > /*&*/ getInterestingRegions() {
    lazyInitializeInterestingSets();
    return $Deref(interestingRegions.back());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::lazyInitializeInterestingSets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2656,
   FQN="clang::ento::BugReport::lazyInitializeInterestingSets", NM="_ZN5clang4ento9BugReport29lazyInitializeInterestingSetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport29lazyInitializeInterestingSetsEv")
  //</editor-fold>
  private void lazyInitializeInterestingSets() {
    if (interestingSymbols.empty()) {
      interestingSymbols.push_back(new DenseSet</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info()));
      interestingRegions.push_back(new DenseSet</*const*/ MemRegion /*P*/ >(DenseMapInfo$LikePtr.$Info()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::pushInterestingSymbolsAndRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2673,
   FQN="clang::ento::BugReport::pushInterestingSymbolsAndRegions", NM="_ZN5clang4ento9BugReport32pushInterestingSymbolsAndRegionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport32pushInterestingSymbolsAndRegionsEv")
  //</editor-fold>
  private void pushInterestingSymbolsAndRegions() {
    interestingSymbols.push_back(new DenseSet</*const*/ SymExpr /*P*/ >(getInterestingSymbols()));
    interestingRegions.push_back(new DenseSet</*const*/ MemRegion /*P*/ >(getInterestingRegions()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::popInterestingSymbolsAndRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2678,
   FQN="clang::ento::BugReport::popInterestingSymbolsAndRegions", NM="_ZN5clang4ento9BugReport31popInterestingSymbolsAndRegionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport31popInterestingSymbolsAndRegionsEv")
  //</editor-fold>
  private void popInterestingSymbolsAndRegions() {
    if (interestingSymbols.pop_back_val() != null) { interestingSymbols.pop_back_val().$destroy();};
    if (interestingRegions.pop_back_val() != null) { interestingRegions.pop_back_val().$destroy();};
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::BugReport">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 146,
   FQN="clang::ento::BugReport::BugReport", NM="_ZN5clang4ento9BugReportC1ERNS0_7BugTypeEN4llvm9StringRefEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReportC1ERNS0_7BugTypeEN4llvm9StringRefEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public BugReport(final BugType /*&*/ bt, StringRef desc, /*const*/ ExplodedNode /*P*/ errornode) {
    // : ilist_node<BugReport>(), BT(bt), DeclWithIssue(null), ShortDescription(), Description(desc.operator basic_string()), Location(), UniqueingLocation(), ErrorNode(errornode), Ranges(), ExtraText(), interestingSymbols(), interestingRegions(), InterestingLocationContexts(), Callbacks(), CallbacksSet(), ConfigurationChangeToken(0), DoNotPrunePath(false), Invalidations() 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this./*&*/BT=/*&*/bt;
    this.DeclWithIssue = null;
    this.ShortDescription = new std.string();
    this.Description = desc.$string();
    this.Location = new PathDiagnosticLocation();
    this.UniqueingLocation = new PathDiagnosticLocation();
    this.ErrorNode = errornode;
    this.Ranges = new SmallVector<SourceRange>(4, SourceRange.EMPTY);
    this.ExtraText = new SmallVector<StringRef>(2, new StringRef());
    this.interestingSymbols = new SmallVector<DenseSet</*const*/ SymExpr /*P*/ > /*P*/>(2, (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null);
    this.interestingRegions = new SmallVector<DenseSet</*const*/ MemRegion /*P*/ > /*P*/>(2, (DenseSet</*const*/ MemRegion /*P*/ > /*P*/)null);
    this.InterestingLocationContexts = new SmallSetT$PLess$T$P</*const*/ LocationContext /*P*/ >(2);
    this.Callbacks = new SmallVector<std.unique_ptr<BugReporterVisitor>>(8, new std.unique_ptr<BugReporterVisitor>());
    this.CallbacksSet = new FoldingSet<BugReporterVisitor>(BugReporterVisitor.$Trait());
    this.ConfigurationChangeToken = 0;
    this.DoNotPrunePath = false;
    this.Invalidations = new SmallSet<std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >>(4, 
            new std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >((/*const*/Object/*void P*/)null, (/*const*/Object/*void P*/)null), 
            std.COMPARE_LOWER_COMPARATOR);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::BugReport">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 150,
   FQN="clang::ento::BugReport::BugReport", NM="_ZN5clang4ento9BugReportC1ERNS0_7BugTypeEN4llvm9StringRefES5_PKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReportC1ERNS0_7BugTypeEN4llvm9StringRefES5_PKNS0_12ExplodedNodeE")
  //</editor-fold>
  public BugReport(final BugType /*&*/ bt, StringRef shortDesc, StringRef desc, 
      /*const*/ ExplodedNode /*P*/ errornode) {
    // : ilist_node<BugReport>(), BT(bt), DeclWithIssue(null), ShortDescription(shortDesc.operator basic_string()), Description(desc.operator basic_string()), Location(), UniqueingLocation(), ErrorNode(errornode), Ranges(), ExtraText(), interestingSymbols(), interestingRegions(), InterestingLocationContexts(), Callbacks(), CallbacksSet(), ConfigurationChangeToken(0), DoNotPrunePath(false), Invalidations() 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this./*&*/BT=/*&*/bt;
    this.DeclWithIssue = null;
    this.ShortDescription = shortDesc.$string();
    this.Description = desc.$string();
    this.Location = new PathDiagnosticLocation();
    this.UniqueingLocation = new PathDiagnosticLocation();
    this.ErrorNode = errornode;
    this.Ranges = new SmallVector<SourceRange>(4, SourceRange.EMPTY);
    this.ExtraText = new SmallVector<StringRef>(2, new StringRef());
    this.interestingSymbols = new SmallVector<DenseSet</*const*/ SymExpr /*P*/ > /*P*/>(2, (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null);
    this.interestingRegions = new SmallVector<DenseSet</*const*/ MemRegion /*P*/ > /*P*/>(2, (DenseSet</*const*/ MemRegion /*P*/ > /*P*/)null);
    this.InterestingLocationContexts = new SmallSetT$PLess$T$P</*const*/ LocationContext /*P*/ >(2);
    this.Callbacks = new SmallVector<std.unique_ptr<BugReporterVisitor>>(8, new std.unique_ptr<BugReporterVisitor>());
    this.CallbacksSet = new FoldingSet<BugReporterVisitor>(BugReporterVisitor.$Trait());
    this.ConfigurationChangeToken = 0;
    this.DoNotPrunePath = false;
    this.Invalidations = new SmallSet<std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >>(4,
                  new std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >((/*const*/Object/*void P*/)null, (/*const*/Object/*void P*/)null), 
                          std.COMPARE_LOWER_COMPARATOR);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::BugReport">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 156,
   FQN="clang::ento::BugReport::BugReport", NM="_ZN5clang4ento9BugReportC1ERNS0_7BugTypeEN4llvm9StringRefENS0_22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReportC1ERNS0_7BugTypeEN4llvm9StringRefENS0_22PathDiagnosticLocationE")
  //</editor-fold>
  public BugReport(final BugType /*&*/ bt, StringRef desc, PathDiagnosticLocation l) {
    // : ilist_node<BugReport>(), BT(bt), DeclWithIssue(null), ShortDescription(), Description(desc.operator basic_string()), Location(l), UniqueingLocation(), ErrorNode(null), Ranges(), ExtraText(), interestingSymbols(), interestingRegions(), InterestingLocationContexts(), Callbacks(), CallbacksSet(), ConfigurationChangeToken(0), DoNotPrunePath(false), Invalidations() 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this./*&*/BT=/*&*/bt;
    this.DeclWithIssue = null;
    this.ShortDescription = new std.string();
    this.Description = desc.$string();
    this.Location = new PathDiagnosticLocation(l);
    this.UniqueingLocation = new PathDiagnosticLocation();
    this.ErrorNode = null;
    this.Ranges = new SmallVector<SourceRange>(4, SourceRange.EMPTY);
    this.ExtraText = new SmallVector<StringRef>(2, new StringRef());
    this.interestingSymbols = new SmallVector<DenseSet</*const*/ SymExpr /*P*/ > /*P*/>(2, (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null);
    this.interestingRegions = new SmallVector<DenseSet</*const*/ MemRegion /*P*/ > /*P*/>(2, (DenseSet</*const*/ MemRegion /*P*/ > /*P*/)null);
    this.InterestingLocationContexts = new SmallSetT$PLess$T$P</*const*/ LocationContext /*P*/ >(2);
    this.Callbacks = new SmallVector<std.unique_ptr<BugReporterVisitor>>(8, new std.unique_ptr<BugReporterVisitor>());
    this.CallbacksSet = new FoldingSet<BugReporterVisitor>(BugReporterVisitor.$Trait());
    this.ConfigurationChangeToken = 0;
    this.DoNotPrunePath = false;
    this.Invalidations = new SmallSet<std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >>(4,
          new std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >((/*const*/Object/*void P*/)null, (/*const*/Object/*void P*/)null), 
            std.COMPARE_LOWER_COMPARATOR);
    //END JInit
  }

  
  /// \brief Create a BugReport with a custom uniqueing location.
  ///
  /// The reports that have the same report location, description, bug type, and
  /// ranges are uniqued - only one of the equivalent reports will be presented
  /// to the user. This method allows to rest the location which should be used
  /// for uniquing reports. For example, memory leaks checker, could set this to
  /// the allocation site, rather then the location where the bug is reported.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::BugReport">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 167,
   FQN="clang::ento::BugReport::BugReport", NM="_ZN5clang4ento9BugReportC1ERNS0_7BugTypeEN4llvm9StringRefEPKNS0_12ExplodedNodeENS0_22PathDiagnosticLocationEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReportC1ERNS0_7BugTypeEN4llvm9StringRefEPKNS0_12ExplodedNodeENS0_22PathDiagnosticLocationEPKNS_4DeclE")
  //</editor-fold>
  public BugReport(final BugType /*&*/ bt, StringRef desc, /*const*/ ExplodedNode /*P*/ errornode, 
      PathDiagnosticLocation LocationToUnique, /*const*/ Decl /*P*/ DeclToUnique) {
    // : ilist_node<BugReport>(), BT(bt), DeclWithIssue(null), ShortDescription(), Description(desc.operator basic_string()), Location(), UniqueingLocation(LocationToUnique), UniqueingDecl(DeclToUnique), ErrorNode(errornode), Ranges(), ExtraText(), interestingSymbols(), interestingRegions(), InterestingLocationContexts(), Callbacks(), CallbacksSet(), ConfigurationChangeToken(0), DoNotPrunePath(false), Invalidations() 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this./*&*/BT=/*&*/bt;
    this.DeclWithIssue = null;
    this.ShortDescription = new std.string();
    this.Description = desc.$string();
    this.Location = new PathDiagnosticLocation();
    this.UniqueingLocation = new PathDiagnosticLocation(LocationToUnique);
    this.UniqueingDecl = DeclToUnique;
    this.ErrorNode = errornode;
    this.Ranges = new SmallVector<SourceRange>(4, SourceRange.EMPTY);
    this.ExtraText = new SmallVector<StringRef>(2, new StringRef());
    this.interestingSymbols = new SmallVector<DenseSet</*const*/ SymExpr /*P*/ > /*P*/>(2, (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null);
    this.interestingRegions = new SmallVector<DenseSet</*const*/ MemRegion /*P*/ > /*P*/>(2, (DenseSet</*const*/ MemRegion /*P*/ > /*P*/)null);
    this.InterestingLocationContexts = new SmallSetT$PLess$T$P</*const*/ LocationContext /*P*/ >(2);
    this.Callbacks = new SmallVector<std.unique_ptr<BugReporterVisitor>>(8, new std.unique_ptr<BugReporterVisitor>());
    this.CallbacksSet = new FoldingSet<BugReporterVisitor>(BugReporterVisitor.$Trait());
    this.ConfigurationChangeToken = 0;
    this.DoNotPrunePath = false;
    this.Invalidations = new SmallSet<std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >>(4,
                              new std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/Object/*void P*/ >((/*const*/Object/*void P*/)null, (/*const*/Object/*void P*/)null), 
                              std.COMPARE_LOWER_COMPARATOR);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::~BugReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2551,
   FQN="clang::ento::BugReport::~BugReport", NM="_ZN5clang4ento9BugReportD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReportD0Ev")
  //</editor-fold>
  public void $destroy() {
    while (!interestingSymbols.empty()) {
      popInterestingSymbolsAndRegions();
    }
    //START JDestroy
    Invalidations.$destroy();
    CallbacksSet.$destroy();
    Callbacks.$destroy();
    InterestingLocationContexts.$destroy();
    interestingRegions.$destroy();
    interestingSymbols.$destroy();
    ExtraText.$destroy();
    Ranges.$destroy();
    Description.$destroy();
    ShortDescription.$destroy();
    ilist_node.super.$destroy$ilist_node();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getBugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 177,
   FQN="clang::ento::BugReport::getBugType", NM="_ZNK5clang4ento9BugReport10getBugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport10getBugTypeEv")
  //</editor-fold>
  public /*const*/ BugType /*&*/ getBugType$Const() /*const*/ {
    return BT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getBugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 178,
   FQN="clang::ento::BugReport::getBugType", NM="_ZN5clang4ento9BugReport10getBugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport10getBugTypeEv")
  //</editor-fold>
  public BugType /*&*/ getBugType() {
    return BT;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getErrorNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 180,
   FQN="clang::ento::BugReport::getErrorNode", NM="_ZNK5clang4ento9BugReport12getErrorNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport12getErrorNodeEv")
  //</editor-fold>
  public /*const*/ ExplodedNode /*P*/ getErrorNode() /*const*/ {
    return ErrorNode;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 182,
   FQN="clang::ento::BugReport::getDescription", NM="_ZNK5clang4ento9BugReport14getDescriptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport14getDescriptionEv")
  //</editor-fold>
  public StringRef getDescription() /*const*/ {
    return new StringRef(Description);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getShortDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 184,
   FQN="clang::ento::BugReport::getShortDescription", NM="_ZNK5clang4ento9BugReport19getShortDescriptionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport19getShortDescriptionEb")
  //</editor-fold>
  public StringRef getShortDescription() /*const*/ {
    return getShortDescription(true);
  }
  public StringRef getShortDescription(boolean UseFallback/*= true*/) /*const*/ {
    if (ShortDescription.empty() && UseFallback) {
      return new StringRef(Description);
    }
    return new StringRef(ShortDescription);
  }

  
  /// Indicates whether or not any path pruning should take place
  /// when generating a PathDiagnostic from this BugReport.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::shouldPrunePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 192,
   FQN="clang::ento::BugReport::shouldPrunePath", NM="_ZNK5clang4ento9BugReport15shouldPrunePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport15shouldPrunePathEv")
  //</editor-fold>
  public boolean shouldPrunePath() /*const*/ {
    return !DoNotPrunePath;
  }

  
  /// Disable all path pruning when generating a PathDiagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::disablePathPruning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 195,
   FQN="clang::ento::BugReport::disablePathPruning", NM="_ZN5clang4ento9BugReport18disablePathPruningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport18disablePathPruningEv")
  //</editor-fold>
  public void disablePathPruning() {
    DoNotPrunePath = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::markInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2590,
   FQN="clang::ento::BugReport::markInteresting", NM="_ZN5clang4ento9BugReport15markInterestingEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport15markInterestingEPKNS0_7SymExprE")
  //</editor-fold>
  public void markInteresting(/*const*/ SymExpr /*P*/ sym) {
    if (!(sym != null)) {
      return;
    }
    
    // If the symbol wasn't already in our set, note a configuration change.
    if (getInterestingSymbols().insert(sym).second) {
      ++ConfigurationChangeToken;
    }
    {
      
      /*const*/ SymbolMetadata /*P*/ meta = dyn_cast_SymbolMetadata(sym);
      if ((meta != null)) {
        getInterestingRegions().insert(meta.getRegion());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::markInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2602,
   FQN="clang::ento::BugReport::markInteresting", NM="_ZN5clang4ento9BugReport15markInterestingEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport15markInterestingEPKNS0_9MemRegionE")
  //</editor-fold>
  public void markInteresting(/*const*/ MemRegion /*P*/ R) {
    if (!(R != null)) {
      return;
    }
    
    // If the base region wasn't already in our set, note a configuration change.
    R = R.getBaseRegion();
    if (getInterestingRegions().insert(R).second) {
      ++ConfigurationChangeToken;
    }
    {
      
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
      if ((SR != null)) {
        getInterestingSymbols().insert(SR.getSymbol());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::markInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2615,
   FQN="clang::ento::BugReport::markInteresting", NM="_ZN5clang4ento9BugReport15markInterestingENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport15markInterestingENS0_4SValE")
  //</editor-fold>
  public void markInteresting(SVal V) {
    markInteresting(V.getAsRegion());
    markInteresting(V.getAsSymbol());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::markInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2620,
   FQN="clang::ento::BugReport::markInteresting", NM="_ZN5clang4ento9BugReport15markInterestingEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport15markInterestingEPKNS_15LocationContextE")
  //</editor-fold>
  public void markInteresting(/*const*/ LocationContext /*P*/ LC) {
    if (!(LC != null)) {
      return;
    }
    InterestingLocationContexts.insert(LC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::isInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2630,
   FQN="clang::ento::BugReport::isInteresting", NM="_ZN5clang4ento9BugReport13isInterestingEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport13isInterestingEPKNS0_7SymExprE")
  //</editor-fold>
  public boolean isInteresting(/*const*/ SymExpr /*P*/ sym) {
    if (!(sym != null)) {
      return false;
    }
    // We don't currently consider metadata symbols to be interesting
    // even if we know their region is interesting. Is that correct behavior?
    return (getInterestingSymbols().count(sym) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::isInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2638,
   FQN="clang::ento::BugReport::isInteresting", NM="_ZN5clang4ento9BugReport13isInterestingEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport13isInterestingEPKNS0_9MemRegionE")
  //</editor-fold>
  public boolean isInteresting(/*const*/ MemRegion /*P*/ R) {
    if (!(R != null)) {
      return false;
    }
    R = R.getBaseRegion();
    boolean b = (getInterestingRegions().count(R) != 0);
    if (b) {
      return true;
    }
    {
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
      if ((SR != null)) {
        return (getInterestingSymbols().count(SR.getSymbol()) != 0);
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::isInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2626,
   FQN="clang::ento::BugReport::isInteresting", NM="_ZN5clang4ento9BugReport13isInterestingENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport13isInterestingENS0_4SValE")
  //</editor-fold>
  public boolean isInteresting(SVal V) {
    return isInteresting(V.getAsRegion()) || isInteresting(V.getAsSymbol());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::isInteresting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2650,
   FQN="clang::ento::BugReport::isInteresting", NM="_ZN5clang4ento9BugReport13isInterestingEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport13isInterestingEPKNS_15LocationContextE")
  //</editor-fold>
  public boolean isInteresting(/*const*/ LocationContext /*P*/ LC) {
    if (!(LC != null)) {
      return false;
    }
    return (InterestingLocationContexts.count(LC) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getConfigurationChangeToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 207,
   FQN="clang::ento::BugReport::getConfigurationChangeToken", NM="_ZNK5clang4ento9BugReport27getConfigurationChangeTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport27getConfigurationChangeTokenEv")
  //</editor-fold>
  public /*uint*/int getConfigurationChangeToken() /*const*/ {
    return ConfigurationChangeToken;
  }

  
  /// Returns whether or not this report should be considered valid.
  ///
  /// Invalid reports are those that have been classified as likely false
  /// positives after the fact.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 215,
   FQN="clang::ento::BugReport::isValid", NM="_ZNK5clang4ento9BugReport7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return Invalidations.empty();
  }

  
  /// Marks the current report as invalid, meaning that it is probably a false
  /// positive and should not be reported to the user.
  ///
  /// The \p Tag and \p Data arguments are intended to be opaque identifiers for
  /// this particular invalidation, where \p Tag represents the visitor
  /// responsible for invalidation, and \p Data represents the reason this
  /// visitor decided to invalidate the bug report.
  ///
  /// \sa removeInvalidation
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::markInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 228,
   FQN="clang::ento::BugReport::markInvalid", NM="_ZN5clang4ento9BugReport11markInvalidEPKvS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport11markInvalidEPKvS3_")
  //</editor-fold>
  public void markInvalid(/*const*/Object/*void P*/ Tag, /*const*/Object/*void P*/ Data) {
    Invalidations.insert(std.make_pair_Ptr_Ptr(Tag, Data));
  }

  
  /// Reverses the effects of a previous invalidation.
  ///
  /// \sa markInvalid
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::removeInvalidation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 235,
   FQN="clang::ento::BugReport::removeInvalidation", NM="_ZN5clang4ento9BugReport18removeInvalidationEPKvS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport18removeInvalidationEPKvS3_")
  //</editor-fold>
  public void removeInvalidation(/*const*/Object/*void P*/ Tag, /*const*/Object/*void P*/ Data) {
    Invalidations.erase(std.make_pair_Ptr_Ptr(Tag, Data));
  }

  
  /// Return the canonical declaration, be it a method or class, where
  /// this issue semantically occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getDeclWithIssue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2557,
   FQN="clang::ento::BugReport::getDeclWithIssue", NM="_ZNK5clang4ento9BugReport16getDeclWithIssueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport16getDeclWithIssueEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getDeclWithIssue() /*const*/ {
    if ((DeclWithIssue != null)) {
      return DeclWithIssue;
    }
    
    /*const*/ ExplodedNode /*P*/ N = getErrorNode();
    if (!(N != null)) {
      return null;
    }
    
    /*const*/ LocationContext /*P*/ LC = N.getLocationContext();
    return LC.getCurrentStackFrame().getDecl();
  }

  
  /// Specifically set the Decl where an issue occurred.  This isn't necessary
  /// for BugReports that cover a path as it will be automatically inferred.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::setDeclWithIssue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 245,
   FQN="clang::ento::BugReport::setDeclWithIssue", NM="_ZN5clang4ento9BugReport16setDeclWithIssueEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport16setDeclWithIssueEPKNS_4DeclE")
  //</editor-fold>
  public void setDeclWithIssue(/*const*/ Decl /*P*/ declWithIssue) {
    DeclWithIssue = declWithIssue;
  }

  
  /// \brief This allows for addition of meta data to the diagnostic.
  ///
  /// Currently, only the HTMLDiagnosticClient knows how to display it. 
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::addExtraText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 252,
   FQN="clang::ento::BugReport::addExtraText", NM="_ZN5clang4ento9BugReport12addExtraTextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport12addExtraTextEN4llvm9StringRefE")
  //</editor-fold>
  public void addExtraText(StringRef S) {
    ExtraText.push_back(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getExtraText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 256,
   FQN="clang::ento::BugReport::getExtraText", NM="_ZN5clang4ento9BugReport12getExtraTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport12getExtraTextEv")
  //</editor-fold>
  public /*virtual*/ /*const*/SmallVector<StringRef> /*&*/ getExtraText() {
    return ExtraText;
  }

  
  /// \brief Return the "definitive" location of the reported bug.
  ///
  ///  While a bug can span an entire path, usually there is a specific
  ///  location that can be used to identify where the key issue occurred.
  ///  This location is used by clients rendering diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2718,
   FQN="clang::ento::BugReport::getLocation", NM="_ZNK5clang4ento9BugReport11getLocationERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport11getLocationERKNS_13SourceManagerE")
  //</editor-fold>
  public PathDiagnosticLocation getLocation(final /*const*/ SourceManager /*&*/ SM) /*const*/ {
    if ((ErrorNode != null)) {
      assert (!Location.isValid()) : "Either Location or ErrorNode should be specified but not both.";
      return PathDiagnosticLocation.createEndOfPath(ErrorNode, SM);
    }
    assert (Location.isValid());
    return new PathDiagnosticLocation(Location);
  }

  
  /// \brief Get the location on which the report should be uniqued.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getUniqueingLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 268,
   FQN="clang::ento::BugReport::getUniqueingLocation", NM="_ZNK5clang4ento9BugReport20getUniqueingLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport20getUniqueingLocationEv")
  //</editor-fold>
  public PathDiagnosticLocation getUniqueingLocation() /*const*/ {
    return new PathDiagnosticLocation(UniqueingLocation);
  }

  
  /// \brief Get the declaration containing the uniqueing location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getUniqueingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 273,
   FQN="clang::ento::BugReport::getUniqueingDecl", NM="_ZNK5clang4ento9BugReport16getUniqueingDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport16getUniqueingDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getUniqueingDecl() /*const*/ {
    return UniqueingDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2683,
   FQN="clang::ento::BugReport::getStmt", NM="_ZNK5clang4ento9BugReport7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport7getStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getStmt() /*const*/ {
    if (!(ErrorNode != null)) {
      return null;
    }
    
    ProgramPoint ProgP = ErrorNode.getLocation();
    /*const*/ Stmt /*P*/ S = null;
    {
      
      Optional<BlockEntrance> BE = ProgP.getAs(BlockEntrance.class);
      if (BE.$bool()) {
        final CFGBlock /*&*/ Exit = ProgP.getLocationContext().getCFG().getExit();
        if (BE.$arrow().getBlock() == $AddrOf(Exit)) {
          S = GetPreviousStmt(ErrorNode);
        }
      }
    }
    if (!(S != null)) {
      S = PathDiagnosticLocation.getStmt(ErrorNode);
    }
    
    return S;
  }

  
  /// \brief Add a range to a bug report.
  ///
  /// Ranges are used to highlight regions of interest in the source code.
  /// They should be at the same source code line as the BugReport location.
  /// By default, the source range of the statement corresponding to the error
  /// node will be used; add a single invalid range to specify absence of
  /// ranges.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::addRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 286,
   FQN="clang::ento::BugReport::addRange", NM="_ZN5clang4ento9BugReport8addRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport8addRangeENS_11SourceRangeE")
  //</editor-fold>
  public void addRange(SourceRange R) {
    assert ((R.isValid() || Ranges.empty())) : "Invalid range can only be used to specify that the report does not have a range.";
    Ranges.push_back(R);
  }

  
  /// \brief Get the SourceRanges associated with the report.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::getRanges">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2701,
   FQN="clang::ento::BugReport::getRanges", NM="_ZN5clang4ento9BugReport9getRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport9getRangesEv")
  //</editor-fold>
  public iterator_range</*const*/ SourceRange> getRanges() {
    // If no custom ranges, add the range of the statement corresponding to
    // the error node.
    if (Ranges.empty()) {
      {
        /*const*/ Expr /*P*/ E = dyn_cast_or_null_Expr(getStmt());
        if ((E != null)) {
          addRange(E.getSourceRange());
        } else {
          return llvm.make_range(((type$ptr</*const*/ SourceRange /*P*/ >)null), ((type$ptr</*const*/ SourceRange /*P*/ >)null));
        }
      }
    }
    
    // User-specified absence of range info.
    if (Ranges.size() == 1 && !Ranges.begin().$star().isValid()) {
      return llvm.make_range(((type$ptr</*const*/ SourceRange /*P*/ >)null), ((type$ptr</*const*/ SourceRange /*P*/ >)null));
    }
    
    return new iterator_range</*const*/ SourceRange>(llvm.make_range(Ranges.begin(), Ranges.end()));
  }

  
  /// \brief Add custom or predefined bug report visitors to this report.
  ///
  /// The visitors should be used when the default trace is not sufficient.
  /// For example, they allow constructing a more elaborate trace.
  /// \sa registerConditionVisitor(), registerTrackNullOrUndefValue(),
  /// registerFindLastStore(), registerNilReceiverVisitor(), and
  /// registerVarDeclsLastStore().
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::addVisitor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2535,
   FQN="clang::ento::BugReport::addVisitor", NM="_ZN5clang4ento9BugReport10addVisitorESt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport10addVisitorESt10unique_ptrINS0_18BugReporterVisitorESt14default_deleteIS3_EE")
  //</editor-fold>
  public void addVisitor(std.unique_ptr<BugReporterVisitor> visitor) {
    if (!visitor.$bool()) {
      return;
    }
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    visitor.$arrow().Profile(ID);
    final type$ref<type$ptr<BugReporterVisitor/*P*/>/*void P*/ > InsertPos = create_type$ref(null);;
    if ((CallbacksSet.FindNodeOrInsertPos(ID, InsertPos) != null)) {
      return;
    }
    
    CallbacksSet.InsertNode(visitor.get(), InsertPos.$deref());
    Callbacks.push_back_T$RR(std.move(visitor));
    ++ConfigurationChangeToken;
  }

  
  /// Iterators through the custom diagnostic visitors.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::visitor_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 305,
   FQN="clang::ento::BugReport::visitor_begin", NM="_ZN5clang4ento9BugReport13visitor_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport13visitor_beginEv")
  //</editor-fold>
  public type$ptr<unique_ptr<BugReporterVisitor> /*P*/> visitor_begin() {
    return Callbacks.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::visitor_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 306,
   FQN="clang::ento::BugReport::visitor_end", NM="_ZN5clang4ento9BugReport11visitor_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento9BugReport11visitor_endEv")
  //</editor-fold>
  public type$ptr<unique_ptr<BugReporterVisitor> /*P*/> visitor_end() {
    return Callbacks.end();
  }

  
  /// Profile to identify equivalent bug reports for error report coalescing.
  /// Reports are uniqued to ensure that we do not emit multiple diagnostics
  /// for each bug.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BugReport::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2569,
   FQN="clang::ento::BugReport::Profile", NM="_ZNK5clang4ento9BugReport7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento9BugReport7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ hash) /*const*/ {
    hash.AddPointer($AddrOf(BT));
    hash.AddString(new StringRef(Description));
    PathDiagnosticLocation UL = getUniqueingLocation();
    if (UL.isValid()) {
      UL.Profile(hash);
    } else if (Location.isValid()) {
      Location.Profile(hash);
    } else {
      assert Native.$bool(ErrorNode);
      hash.AddPointer(GetCurrentOrPreviousStmt(ErrorNode));
    }
    
    for (SourceRange range : Ranges) {
      if (!range.isValid()) {
        continue;
      }
      hash.AddInteger_uint(range.getBegin().getRawEncoding());
      hash.AddInteger_uint(range.getEnd().getRawEncoding());
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public BugReport(final BugType /*&*/ bt, char$ptr desc, /*const*/ ExplodedNode /*P*/ errornode) {
    this(bt, new StringRef(desc), errornode);
  }

  public BugReport(final BugType /*&*/ bt, std.string desc, /*const*/ ExplodedNode /*P*/ errornode) {
    this(bt, new StringRef(desc), errornode);
  }

  public BugReport(final BugType /*&*/ bt, byte[] desc, /*const*/ ExplodedNode /*P*/ errornode) {
    this(bt, new StringRef(desc), errornode);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + ", DeclWithIssue=" + DeclWithIssue // NOI18N
              + ", ShortDescription=" + ShortDescription // NOI18N
              + ", Description=" + Description // NOI18N
              + ", Location=" + Location // NOI18N
              + ", UniqueingLocation=" + UniqueingLocation // NOI18N
              + ", UniqueingDecl=" + UniqueingDecl // NOI18N
              + ", ErrorNode=" + ErrorNode // NOI18N
              + ", Ranges=" + Ranges // NOI18N
              + ", ExtraText=" + ExtraText // NOI18N
              + ", interestingSymbols=" + interestingSymbols // NOI18N
              + ", interestingRegions=" + interestingRegions // NOI18N
              + ", InterestingLocationContexts=" + "[SmallSetT$PLess$T$P$LocationContext]" // NOI18N
              + ", Callbacks=" + Callbacks // NOI18N
              + ", CallbacksSet=" + CallbacksSet // NOI18N
              + ", ConfigurationChangeToken=" + ConfigurationChangeToken // NOI18N
              + ", DoNotPrunePath=" + DoNotPrunePath // NOI18N
              + ", Invalidations=" + Invalidations // NOI18N
              + super.toString(); // NOI18N
  }
}
