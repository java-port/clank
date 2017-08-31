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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.checkers.impl.RetainCountCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1823,
 FQN="(anonymous namespace)::CFRefLeakReport", NM="_ZN12_GLOBAL__N_115CFRefLeakReportE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_115CFRefLeakReportE")
//</editor-fold>
public class CFRefLeakReport extends /*public*/ CFRefReport implements Destructors.ClassWithDestructor {
  private /*const*/ MemRegion /*P*/ AllocBinding;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReport::CFRefLeakReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2390,
   FQN="(anonymous namespace)::CFRefLeakReport::CFRefLeakReport", NM="_ZN12_GLOBAL__N_115CFRefLeakReportC1ERNS_8CFRefBugERKN5clang11LangOptionsEbRKN4llvm8DenseMapIPKNS3_4ento12ExplodedNodeEPKNS_13RetainSummaryENS7_12DenseMapInfoISC_EENS7_6detail12DenseMapPairISC_SF_EEEEPSA_PKNS9_7SymExprERNS9_14CheckerContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_115CFRefLeakReportC1ERNS_8CFRefBugERKN5clang11LangOptionsEbRKN4llvm8DenseMapIPKNS3_4ento12ExplodedNodeEPKNS_13RetainSummaryENS7_12DenseMapInfoISC_EENS7_6detail12DenseMapPairISC_SF_EEEEPSA_PKNS9_7SymExprERNS9_14CheckerContextEb")
  //</editor-fold>
  public CFRefLeakReport(final CFRefBug /*&*/ D, final /*const*/ LangOptions /*&*/ LOpts, 
      boolean GCEnabled, final /*const*/DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ > /*&*/ Log, 
      ExplodedNode /*P*/ n, /*const*/ SymExpr /*P*/ sym, 
      final CheckerContext /*&*/ Ctx, 
      boolean IncludeAllocationLine) {
    // : CFRefReport(D, LOpts, GCEnabled, Log, n, sym, false) 
    //START JInit
    super(D, LOpts, GCEnabled, Log, n, sym, false);
    //END JInit
    raw_string_ostream os = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Most bug reports are cached at the location where they occurred.
      // With leaks, we want to unique them by the location where they were
      // allocated, and only report a single path.  To do this, we need to find
      // the allocation site of a piece of tracked memory, which we do via a
      // call to GetAllocationSite.  This will walk the ExplodedGraph backwards.
      // Note that this is *not* the trimmed graph; we are guaranteed, however,
      // that all ancestor nodes that represent the allocation site have the
      // same SourceLocation.
      /*const*/ ExplodedNode /*P*/ AllocNode = null;
      
      final /*const*/ SourceManager /*&*/ SMgr = Ctx.getSourceManager();
      
      AllocationInfo AllocI = GetAllocationSite(Ctx.getStateManager(), getErrorNode(), sym);
      
      AllocNode = AllocI.N;
      AllocBinding = AllocI.R;
      markInteresting(AllocI.InterestingMethodContext);
      
      // Get the SourceLocation for the allocation site.
      // FIXME: This will crash the analyzer if an allocation comes from an
      // implicit call (ex: a destructor call).
      // (Currently there are no such allocations in Cocoa, though.)
      /*const*/ Stmt /*P*/ AllocStmt = null;
      ProgramPoint P = AllocNode.getLocation();
      {
        Optional<CallExitEnd> Exit = P.getAs(CallExitEnd.class);
        if (Exit.$bool()) {
          AllocStmt = Exit.$arrow().getCalleeContext().getCallSite();
        } else {
          AllocStmt = P.castAs(org.clang.analysis.PostStmt.class).getStmt();
        }
      }
      assert ((AllocStmt != null)) : "Cannot find allocation statement";
      
      PathDiagnosticLocation AllocLocation = PathDiagnosticLocation.createBegin(AllocStmt, SMgr, 
          new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, AllocNode.getLocationContext()));
      Location.$assign(AllocLocation);
      
      // Set uniqieing info, which will be used for unique the bug reports. The
      // leaks should be uniqued on the allocation site.
      UniqueingLocation.$assign(AllocLocation);
      UniqueingDecl = AllocNode.getLocationContext().getDecl();
      
      // Fill in the description of the bug.
      Description.clear();
      os/*J*/= new raw_string_ostream(Description);
      os.$out(/*KEEP_STR*/"Potential leak ");
      if (GCEnabled) {
        os.$out(/*KEEP_STR*/"(when using garbage collection) ");
      }
      os.$out(/*KEEP_STR*/"of an object");
      if ((AllocBinding != null)) {
        os.$out(/*KEEP_STR*/" stored into '").$out(AllocBinding.getString()).$out_char($$SGL_QUOTE);
        if (IncludeAllocationLine) {
          FullSourceLoc SL/*J*/= new FullSourceLoc(AllocStmt.getLocStart(), Ctx.getSourceManager());
          os.$out(/*KEEP_STR*/" (allocated on line ").$out_uint(SL.getSpellingLineNumber()).$out(/*KEEP_STR*/$RPAREN);
        }
      }
      
      addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new CFRefLeakReportVisitor(sym, GCEnabled, Log)))))); $c$.clean();
    } finally {
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReport::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1831,
   FQN="(anonymous namespace)::CFRefLeakReport::getLocation", NM="_ZNK12_GLOBAL__N_115CFRefLeakReport11getLocationERKN5clang13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_115CFRefLeakReport11getLocationERKN5clang13SourceManagerE")
  //</editor-fold>
  @Override public PathDiagnosticLocation getLocation(final /*const*/ SourceManager /*&*/ SM) /*const*//* override*/ {
    assert (Location.isValid());
    return new PathDiagnosticLocation(Location);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReport::~CFRefLeakReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1823,
   FQN="(anonymous namespace)::CFRefLeakReport::~CFRefLeakReport", NM="_ZN12_GLOBAL__N_115CFRefLeakReportD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_115CFRefLeakReportD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AllocBinding=" + AllocBinding // NOI18N
              + super.toString(); // NOI18N
  }
}
