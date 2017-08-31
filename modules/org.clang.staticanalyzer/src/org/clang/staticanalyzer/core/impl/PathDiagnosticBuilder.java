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

package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 320,
 FQN="(anonymous namespace)::PathDiagnosticBuilder", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilderE")
//</editor-fold>
public class PathDiagnosticBuilder extends /*public*/ BugReporterContext implements Destructors.ClassWithDestructor {
  private BugReport /*P*/ R;
  private PathDiagnosticConsumer /*P*/ PDC;
  private NodeMapClosure NMC;
/*public:*/
  public /*const*/ LocationContext /*P*/ LC;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::PathDiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 327,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::PathDiagnosticBuilder", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilderC1ERN5clang4ento13GRBugReporterEPNS2_9BugReportERN4llvm8DenseMapIPKNS2_12ExplodedNodeESB_NS7_12DenseMapInfoISB_EENS7_6detail12DenseMapPairISB_SB_EEEEPNS2_22PathDiagnosticConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilderC1ERN5clang4ento13GRBugReporterEPNS2_9BugReportERN4llvm8DenseMapIPKNS2_12ExplodedNodeESB_NS7_12DenseMapInfoISB_EENS7_6detail12DenseMapPairISB_SB_EEEEPNS2_22PathDiagnosticConsumerE")
  //</editor-fold>
  public PathDiagnosticBuilder(final GRBugReporter /*&*/ br, 
      BugReport /*P*/ r, final DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > /*&*/ Backmap, 
      PathDiagnosticConsumer /*P*/ pdc) {
    // : BugReporterContext(br), R(r), PDC(pdc), NMC(Backmap), LC(r->getErrorNode()->getLocationContext()) 
    //START JInit
    super(br);
    this.R = r;
    this.PDC = pdc;
    this.NMC = new NodeMapClosure(Backmap);
    this.LC = r.getErrorNode().getLocationContext();
    //END JInit
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::ExecutionContinues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 363,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::ExecutionContinues", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilder18ExecutionContinuesEPKN5clang4ento12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilder18ExecutionContinuesEPKN5clang4ento12ExplodedNodeE")
  //</editor-fold>
  public PathDiagnosticLocation ExecutionContinues(/*const*/ ExplodedNode /*P*/ N) {
    {
      /*const*/ Stmt /*P*/ S = PathDiagnosticLocation.getNextStmt(N);
      if ((S != null)) {
        return new PathDiagnosticLocation(S, getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
      }
    }
    
    return PathDiagnosticLocation.createDeclEnd(N.getLocationContext(), 
        getSourceManager());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::ExecutionContinues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 372,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::ExecutionContinues", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilder18ExecutionContinuesERN4llvm18raw_string_ostreamEPKN5clang4ento12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilder18ExecutionContinuesERN4llvm18raw_string_ostreamEPKN5clang4ento12ExplodedNodeE")
  //</editor-fold>
  public PathDiagnosticLocation ExecutionContinues(final raw_string_ostream /*&*/ os, 
                    /*const*/ ExplodedNode /*P*/ N) {
    
    // Slow, but probably doesn't matter.
    if (os.str().empty()) {
      os.$out_char($$SPACE);
    }
    
    final /*const*/ PathDiagnosticLocation /*&*/ Loc = ExecutionContinues(N);
    if ((Loc.asStmt() != null)) {
      os.$out(/*KEEP_STR*/"Execution continues on line ").$out_uint(
          getSourceManager().getExpansionLineNumber(/*NO_COPY*/Loc.asLocation())
      ).$out_char(
          $$DOT
      );
    } else {
      os.$out(/*KEEP_STR*/"Execution jumps to the end of the ");
      /*const*/ Decl /*P*/ D = N.getLocationContext().getDecl();
      if (isa_ObjCMethodDecl(D)) {
        os.$out(/*KEEP_STR*/"method");
      } else if (isa_FunctionDecl(D)) {
        os.$out(/*KEEP_STR*/"function");
      } else {
        assert (isa_BlockDecl(D));
        os.$out(/*KEEP_STR*/"anonymous block");
      }
      os.$out_char($$DOT);
    }
    
    return new PathDiagnosticLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::getBugReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 339,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::getBugReport", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilder12getBugReportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilder12getBugReportEv")
  //</editor-fold>
  public BugReport /*P*/ getBugReport() {
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::getCodeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 341,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::getCodeDecl", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilder11getCodeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilder11getCodeDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*&*/ getCodeDecl() {
    return R.getErrorNode().getCodeDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::getParentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 343,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::getParentMap", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilder12getParentMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilder12getParentMapEv")
  //</editor-fold>
  public ParentMap /*&*/ getParentMap() {
    return LC.getParentMap();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 345,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::getParent", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilder9getParentEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilder9getParentEPKN5clang4StmtE")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getParent(/*const*/ Stmt /*P*/ S) {
    return getParentMap().getParent_Stmt$C$P(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::getNodeResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 349,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::getNodeResolver", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilder15getNodeResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilder15getNodeResolverEv")
  //</editor-fold>
  @Override public NodeMapClosure /*&*/ getNodeResolver()/* override*/ {
    return NMC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::getEnclosingStmtLocation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 492,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::getEnclosingStmtLocation", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilder24getEnclosingStmtLocationEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilder24getEnclosingStmtLocationEPKN5clang4StmtE")
  //</editor-fold>
  public PathDiagnosticLocation getEnclosingStmtLocation(/*const*/ Stmt /*P*/ S) {
    assert ((S != null)) : "Null Stmt passed to getEnclosingStmtLocation";
    return /*::*/BugReporterStatics.getEnclosingStmtLocation(S, getSourceManager(), getParentMap(), LC, 
        /*allowNestedContexts=*/ false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::getGenerationScheme">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 353,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::getGenerationScheme", NM="_ZNK12_GLOBAL__N_121PathDiagnosticBuilder19getGenerationSchemeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK12_GLOBAL__N_121PathDiagnosticBuilder19getGenerationSchemeEv")
  //</editor-fold>
  public PathDiagnosticConsumer.PathGenerationScheme getGenerationScheme() /*const*/ {
    return (PDC != null) ? PDC.getGenerationScheme() : PathDiagnosticConsumer.PathGenerationScheme.Extensive;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::supportsLogicalOpControlFlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 357,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::supportsLogicalOpControlFlow", NM="_ZNK12_GLOBAL__N_121PathDiagnosticBuilder28supportsLogicalOpControlFlowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK12_GLOBAL__N_121PathDiagnosticBuilder28supportsLogicalOpControlFlowEv")
  //</editor-fold>
  public boolean supportsLogicalOpControlFlow() /*const*/ {
    return (PDC != null) ? PDC.supportsLogicalOpControlFlow() : true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PathDiagnosticBuilder::~PathDiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 320,
   FQN="(anonymous namespace)::PathDiagnosticBuilder::~PathDiagnosticBuilder", NM="_ZN12_GLOBAL__N_121PathDiagnosticBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_121PathDiagnosticBuilderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    NMC.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "R=" + R // NOI18N
              + ", PDC=" + "[PathDiagnosticConsumer]" // NOI18N
              + ", NMC=" + NMC // NOI18N
              + ", LC=" + "[LocationContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
