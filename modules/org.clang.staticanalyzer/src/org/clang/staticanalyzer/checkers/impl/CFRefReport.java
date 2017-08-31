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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1794,
 FQN="(anonymous namespace)::CFRefReport", NM="_ZN12_GLOBAL__N_111CFRefReportE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_111CFRefReportE")
//</editor-fold>
public class CFRefReport extends /*public*/ BugReport implements Destructors.ClassWithDestructor {
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReport::addGCModeDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1838,
   FQN="(anonymous namespace)::CFRefReport::addGCModeDescription", NM="_ZN12_GLOBAL__N_111CFRefReport20addGCModeDescriptionERKN5clang11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_111CFRefReport20addGCModeDescriptionERKN5clang11LangOptionsEb")
  //</editor-fold>
  private void addGCModeDescription(final /*const*/ LangOptions /*&*/ LOpts, 
                      boolean GCEnabled) {
    /*const*/char$ptr/*char P*/ GCModeDescription = null;
    switch (LOpts.getGC()) {
     case GCOnly:
      assert (GCEnabled);
      GCModeDescription = $tryClone($("Code is compiled to only use garbage collection"));
      break;
     case NonGC:
      assert (!GCEnabled);
      GCModeDescription = $tryClone($("Code is compiled to use reference counts"));
      break;
     case HybridGC:
      if (GCEnabled) {
        GCModeDescription = $tryClone($("Code is compiled to use either garbage collection (GC) or reference counts (non-GC).  The bug occurs with GC enabled"));
        break;
      } else {
        GCModeDescription = $tryClone($("Code is compiled to use either garbage collection (GC) or reference counts (non-GC).  The bug occurs in non-GC mode"));
        break;
      }
    }
    assert (Native.$bool(GCModeDescription)) : "invalid/unknown GC mode";
    addExtraText(new StringRef(GCModeDescription));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReport::CFRefReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1798,
   FQN="(anonymous namespace)::CFRefReport::CFRefReport", NM="_ZN12_GLOBAL__N_111CFRefReportC1ERNS_8CFRefBugERKN5clang11LangOptionsEbRKN4llvm8DenseMapIPKNS3_4ento12ExplodedNodeEPKNS_13RetainSummaryENS7_12DenseMapInfoISC_EENS7_6detail12DenseMapPairISC_SF_EEEEPSA_PKNS9_7SymExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_111CFRefReportC1ERNS_8CFRefBugERKN5clang11LangOptionsEbRKN4llvm8DenseMapIPKNS3_4ento12ExplodedNodeEPKNS_13RetainSummaryENS7_12DenseMapInfoISC_EENS7_6detail12DenseMapPairISC_SF_EEEEPSA_PKNS9_7SymExprEb")
  //</editor-fold>
  public CFRefReport(final CFRefBug /*&*/ D, final /*const*/ LangOptions /*&*/ LOpts, boolean GCEnabled, 
      final /*const*/DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ > /*&*/ Log, ExplodedNode /*P*/ n, /*const*/ SymExpr /*P*/ sym) {
    this(D, LOpts, GCEnabled, 
      Log, n, sym, 
      true);
  }
  public CFRefReport(final CFRefBug /*&*/ D, final /*const*/ LangOptions /*&*/ LOpts, boolean GCEnabled, 
      final /*const*/DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ > /*&*/ Log, ExplodedNode /*P*/ n, /*const*/ SymExpr /*P*/ sym, 
      boolean registerVisitor/*= true*/) {
    // : BugReport(D, D.getDescription(), n) 
    //START JInit
    /*ExprWithCleanups*/super(D, new StringRef(D.getDescription()), n);
    //END JInit
    if (registerVisitor) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new CFRefReportVisitor(sym, GCEnabled, Log)))))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    addGCModeDescription(LOpts, GCEnabled);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReport::CFRefReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1807,
   FQN="(anonymous namespace)::CFRefReport::CFRefReport", NM="_ZN12_GLOBAL__N_111CFRefReportC1ERNS_8CFRefBugERKN5clang11LangOptionsEbRKN4llvm8DenseMapIPKNS3_4ento12ExplodedNodeEPKNS_13RetainSummaryENS7_12DenseMapInfoISC_EENS7_6detail12DenseMapPairISC_SF_EEEEPSA_PKNS9_7SymExprENS7_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_111CFRefReportC1ERNS_8CFRefBugERKN5clang11LangOptionsEbRKN4llvm8DenseMapIPKNS3_4ento12ExplodedNodeEPKNS_13RetainSummaryENS7_12DenseMapInfoISC_EENS7_6detail12DenseMapPairISC_SF_EEEEPSA_PKNS9_7SymExprENS7_9StringRefE")
  //</editor-fold>
  public CFRefReport(final CFRefBug /*&*/ D, final /*const*/ LangOptions /*&*/ LOpts, boolean GCEnabled, 
      final /*const*/DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ > /*&*/ Log, ExplodedNode /*P*/ n, /*const*/ SymExpr /*P*/ sym, 
      StringRef endText) {
    // : BugReport(D, D.getDescription(), endText, n) 
    //START JInit
    /*ExprWithCleanups*/super(D, new StringRef(D.getDescription()), new StringRef(endText), n);
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new CFRefReportVisitor(sym, GCEnabled, Log)))))); $c$.clean();
      addGCModeDescription(LOpts, GCEnabled);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReport::getRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1815,
   FQN="(anonymous namespace)::CFRefReport::getRanges", NM="_ZN12_GLOBAL__N_111CFRefReport9getRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_111CFRefReport9getRangesEv")
  //</editor-fold>
  @Override public iterator_range</*const*/ SourceRange> getRanges()/* override*/ {
    final /*const*/ CFRefBug /*&*/ BugTy = ((/*static_cast*/CFRefBug /*&*/ )(getBugType()));
    if (!BugTy.isLeak()) {
      return super.getRanges();
    }
    return llvm.make_range(((type$ptr</*const*/ SourceRange /*P*/ >)null), ((type$ptr</*const*/ SourceRange /*P*/ >)null));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefReport::~CFRefReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1794,
   FQN="(anonymous namespace)::CFRefReport::~CFRefReport", NM="_ZN12_GLOBAL__N_111CFRefReportD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_111CFRefReportD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
