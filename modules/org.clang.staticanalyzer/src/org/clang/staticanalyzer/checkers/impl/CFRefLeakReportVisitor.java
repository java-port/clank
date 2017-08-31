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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReportVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1774,
 FQN="(anonymous namespace)::CFRefLeakReportVisitor", NM="_ZN12_GLOBAL__N_122CFRefLeakReportVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_122CFRefLeakReportVisitorE")
//</editor-fold>
public class CFRefLeakReportVisitor extends /*public*/ CFRefReportVisitor implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReportVisitor::CFRefLeakReportVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1776,
   FQN="(anonymous namespace)::CFRefLeakReportVisitor::CFRefLeakReportVisitor", NM="_ZN12_GLOBAL__N_122CFRefLeakReportVisitorC1EPKN5clang4ento7SymExprEbRKN4llvm8DenseMapIPKNS2_12ExplodedNodeEPKNS_13RetainSummaryENS6_12DenseMapInfoISA_EENS6_6detail12DenseMapPairISA_SD_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_122CFRefLeakReportVisitorC1EPKN5clang4ento7SymExprEbRKN4llvm8DenseMapIPKNS2_12ExplodedNodeEPKNS_13RetainSummaryENS6_12DenseMapInfoISA_EENS6_6detail12DenseMapPairISA_SD_EEEE")
  //</editor-fold>
  public CFRefLeakReportVisitor(/*const*/ SymExpr /*P*/ sym, boolean GCEnabled, 
      final /*const*/DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ > /*&*/ log) {
    // : CFRefReportVisitor(sym, GCEnabled, log) 
    //START JInit
    super(sym, GCEnabled, log);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReportVisitor::getEndPath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2305,
   FQN="(anonymous namespace)::CFRefLeakReportVisitor::getEndPath", NM="_ZN12_GLOBAL__N_122CFRefLeakReportVisitor10getEndPathERN5clang4ento18BugReporterContextEPKNS2_12ExplodedNodeERNS2_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_122CFRefLeakReportVisitor10getEndPathERN5clang4ento18BugReporterContextEPKNS2_12ExplodedNodeERNS2_9BugReportE")
  //</editor-fold>
  @Override public std.unique_ptr<PathDiagnosticPiece> getEndPath(final BugReporterContext /*&*/ BRC, 
            /*const*/ ExplodedNode /*P*/ EndN, final BugReport /*&*/ BR)/* override*/ {
    raw_string_ostream os = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Tell the BugReporterContext to report cases when the tracked symbol is
      // assigned to different variables, etc.
      BR.markInteresting(Sym);
      
      // We are reporting a leak.  Walk up the graph to get to the first node where
      // the symbol appeared, and also get the first VarDecl that tracked object
      // is stored to.
      AllocationInfo AllocI = RetainCountCheckerStatics.GetAllocationSite(BRC.getStateManager(), EndN, Sym);
      
      /*const*/ MemRegion /*P*/ FirstBinding = AllocI.R;
      BR.markInteresting(AllocI.InterestingMethodContext);
      
      final SourceManager /*&*/ SM = BRC.getSourceManager();
      
      // Compute an actual location for the leak.  Sometimes a leak doesn't
      // occur at an actual statement (e.g., transition between blocks; end
      // of function) so we need to walk the graph and compute a real location.
      /*const*/ ExplodedNode /*P*/ LeakN = EndN;
      PathDiagnosticLocation L = PathDiagnosticLocation.createEndOfPath(LeakN, SM);
      
      std.string sbuf/*J*/= new std.string();
      os/*J*/= new raw_string_ostream(sbuf);
      
      os.$out(/*KEEP_STR*/"Object leaked: ");
      if ((FirstBinding != null)) {
        os.$out(/*KEEP_STR*/"object allocated and stored into '").$out(
            FirstBinding.getString()
        ).$out_char($$SGL_QUOTE);
      } else {
        os.$out(/*KEEP_STR*/"allocated object");
      }
      
      // Get the retain count.
      /*const*/ RefVal /*P*/ RV = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(EndN.getState())), Sym));
      assert /*JAVA*/(RV != null);
      if (RV.getKind() == RefVal.Kind.ErrorLeakReturned) {
        // FIXME: Per comments in rdar://6320065, "create" only applies to CF
        // objects.  Only "copy", "alloc", "retain" and "new" transfer ownership
        // to the caller for NS objects.
        /*const*/ Decl /*P*/ D = $AddrOf(EndN.getCodeDecl());
        
        os.$out((isa_ObjCMethodDecl(D) ? $(" is returned from a method ") : $(" is returned from a function ")));
        if (D.hasAttr(CFReturnsNotRetainedAttr.class)) {
          os.$out(/*KEEP_STR*/"that is annotated as CF_RETURNS_NOT_RETAINED");
        } else if (D.hasAttr(NSReturnsNotRetainedAttr.class)) {
          os.$out(/*KEEP_STR*/"that is annotated as NS_RETURNS_NOT_RETAINED");
        } else {
          {
            /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
            if ((MD != null)) {
              os.$out(/*KEEP_STR*/"whose name ('").$out(MD.getSelector().getAsString()).$out(
                  /*KEEP_STR*/"') does not start with 'copy', 'mutableCopy', 'alloc' or 'new'.  This violates the naming convention rules given in the Memory Management Guide for Cocoa"
              );
            } else {
              /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(D);
              $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"whose name ('"), $Deref(FD)).$out(
                  /*KEEP_STR*/"') does not contain 'Copy' or 'Create'.  This violates the naming convention rules given in the Memory Management Guide for Core Foundation"
              );
            }
          }
        }
      } else if (RV.getKind() == RefVal.Kind.ErrorGCLeakReturned) {
        final /*const*/ ObjCMethodDecl /*&*/ MD = cast_ObjCMethodDecl(EndN.getCodeDecl());
        os.$out(/*KEEP_STR*/" and returned from method '").$out(MD.getSelector().getAsString()).$out(
            /*KEEP_STR*/"' is potentially leaked when using garbage collection.  Callers of this method do not expect a returned object with a +1 retain count since they expect the object to be managed by the garbage collector"
        );
      } else {
        os.$out(/*KEEP_STR*/" is not referenced later in this execution path and has a retain count of +").$out_uint(RV.getCount());
      }
      
      return $c$.clean(new std.unique_ptr<PathDiagnosticPiece>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new PathDiagnosticEventPiece(L, new StringRef(os.str()))))));
    } finally {
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReportVisitor::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1784,
   FQN="(anonymous namespace)::CFRefLeakReportVisitor::clone", NM="_ZNK12_GLOBAL__N_122CFRefLeakReportVisitor5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_122CFRefLeakReportVisitor5cloneEv")
  //</editor-fold>
  @Override public std.unique_ptr<BugReporterVisitor> clone$Visitor() /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The curiously-recurring template pattern only works for one level of
      // subclassing. Rather than make a new template base for
      // CFRefReportVisitor, we simply override clone() to do the right thing.
      // This could be trouble someday if BugReporterVisitorImpl is ever
      // used for something else besides a convenient implementation of clone().
      return $c$.clean(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new CFRefLeakReportVisitor(/*Deref*/this)))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReportVisitor::~CFRefLeakReportVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1774,
   FQN="(anonymous namespace)::CFRefLeakReportVisitor::~CFRefLeakReportVisitor", NM="_ZN12_GLOBAL__N_122CFRefLeakReportVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_122CFRefLeakReportVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRefLeakReportVisitor::CFRefLeakReportVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1774,
   FQN="(anonymous namespace)::CFRefLeakReportVisitor::CFRefLeakReportVisitor", NM="_ZN12_GLOBAL__N_122CFRefLeakReportVisitorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_122CFRefLeakReportVisitorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CFRefLeakReportVisitor(final /*const*/ CFRefLeakReportVisitor /*&*/ $Prm0) {
    // : CFRefReportVisitor() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public CFRefLeakReportVisitor clone() {
    return new CFRefLeakReportVisitor(this);
  }  
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
