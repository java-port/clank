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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 964,
 FQN="(anonymous namespace)::EdgeBuilder", NM="_ZN12_GLOBAL__N_111EdgeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilderE")
//</editor-fold>
public class EdgeBuilder implements Destructors.ClassWithDestructor {
  private std.vector<ContextLocation> CLocs;
  // JAVA: typedef std::vector<ContextLocation>::iterator iterator
//  public final class iterator extends std.vector.iterator<ContextLocation /*P*/ >{ };
  private final PathDiagnostic /*&*/ PD;
  private final PathDiagnosticBuilder /*&*/ PDB;
  private PathDiagnosticLocation PrevLoc;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::IsConsumedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1164,
   FQN="(anonymous namespace)::EdgeBuilder::IsConsumedExpr", NM="_ZN12_GLOBAL__N_111EdgeBuilder14IsConsumedExprERKN5clang4ento22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder14IsConsumedExprERKN5clang4ento22PathDiagnosticLocationE")
  //</editor-fold>
  private boolean IsConsumedExpr(final /*const*/ PathDiagnosticLocation /*&*/ L) {
    {
      /*const*/ Expr /*P*/ X = dyn_cast_or_null_Expr(L.asStmt());
      if ((X != null)) {
        return PDB.getParentMap().isConsumedExpr_Expr$C$P(X) && !BugReporterStatics.IsControlFlowExpr(X);
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::containsLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1044,
   FQN="(anonymous namespace)::EdgeBuilder::containsLocation", NM="_ZN12_GLOBAL__N_111EdgeBuilder16containsLocationERKN5clang4ento22PathDiagnosticLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder16containsLocationERKN5clang4ento22PathDiagnosticLocationES5_")
  //</editor-fold>
  private boolean containsLocation(final /*const*/ PathDiagnosticLocation /*&*/ Container, 
                  final /*const*/ PathDiagnosticLocation /*&*/ Containee) {
    if (Container.$eq(Containee)) {
      return true;
    }
    if ((Container.asDecl() != null)) {
      return true;
    }
    {
      
      /*const*/ Stmt /*P*/ S = Containee.asStmt();
      if ((S != null)) {
        {
          /*const*/ Stmt /*P*/ ContainerS = Container.asStmt();
          if ((ContainerS != null)) {
            while ((S != null)) {
              if (S == ContainerS) {
                return true;
              }
              S = PDB.getParent(S);
            }
            return false;
          }
        }
      }
    }
    
    // Less accurate: compare using source ranges.
    SourceRange ContainerR = new SourceRange(JD$Move.INSTANCE, Container.asRange());
    SourceRange ContaineeR = new SourceRange(JD$Move.INSTANCE, Containee.asRange());
    
    final SourceManager /*&*/ SM = PDB.getSourceManager();
    SourceLocation ContainerRBeg = SM.getExpansionLoc(ContainerR.getBegin());
    SourceLocation ContainerREnd = SM.getExpansionLoc(ContainerR.getEnd());
    SourceLocation ContaineeRBeg = SM.getExpansionLoc(ContaineeR.getBegin());
    SourceLocation ContaineeREnd = SM.getExpansionLoc(ContaineeR.getEnd());
    
    /*uint*/int ContainerBegLine = SM.getExpansionLineNumber(/*NO_COPY*/ContainerRBeg);
    /*uint*/int ContainerEndLine = SM.getExpansionLineNumber(/*NO_COPY*/ContainerREnd);
    /*uint*/int ContaineeBegLine = SM.getExpansionLineNumber(/*NO_COPY*/ContaineeRBeg);
    /*uint*/int ContaineeEndLine = SM.getExpansionLineNumber(/*NO_COPY*/ContaineeREnd);
    assert ($lesseq_uint(ContainerBegLine, ContainerEndLine));
    assert ($lesseq_uint(ContaineeBegLine, ContaineeEndLine));
    
    return ($lesseq_uint(ContainerBegLine, ContaineeBegLine)
       && $greatereq_uint(ContainerEndLine, ContaineeEndLine)
       && (ContainerBegLine != ContaineeBegLine
       || $lesseq_uint(SM.getExpansionColumnNumber(/*NO_COPY*/ContainerRBeg)
      , SM.getExpansionColumnNumber(/*NO_COPY*/ContaineeRBeg)))
       && (ContainerEndLine != ContaineeEndLine
       || $greatereq_uint(SM.getExpansionColumnNumber(/*NO_COPY*/ContainerREnd)
      , SM.getExpansionColumnNumber(/*NO_COPY*/ContaineeREnd))));
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::getContextLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1032,
   FQN="(anonymous namespace)::EdgeBuilder::getContextLocation", NM="_ZN12_GLOBAL__N_111EdgeBuilder18getContextLocationERKN5clang4ento22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder18getContextLocationERKN5clang4ento22PathDiagnosticLocationE")
  //</editor-fold>
  private PathDiagnosticLocation getContextLocation(final /*const*/ PathDiagnosticLocation /*&*/ L) {
    {
      /*const*/ Stmt /*P*/ S = L.asStmt();
      if ((S != null)) {
        if (BugReporterStatics.IsControlFlowExpr(S)) {
          return new PathDiagnosticLocation(L);
        }
        
        return PDB.getEnclosingStmtLocation(S);
      }
    }
    
    return new PathDiagnosticLocation(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::popLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 980,
   FQN="(anonymous namespace)::EdgeBuilder::popLocation", NM="_ZN12_GLOBAL__N_111EdgeBuilder11popLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder11popLocationEv")
  //</editor-fold>
  private void popLocation() {
    if (!CLocs.back().isDead() && CLocs.back().asLocation().isFileID()) {
      // For contexts, we only one the first character as the range.
      rawAddEdge(BugReporterStatics.cleanUpLocation(new PathDiagnosticLocation(CLocs.back()), PDB.LC, true));
    }
    CLocs.pop_back();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::EdgeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 989,
   FQN="(anonymous namespace)::EdgeBuilder::EdgeBuilder", NM="_ZN12_GLOBAL__N_111EdgeBuilderC1ERN5clang4ento14PathDiagnosticERNS_21PathDiagnosticBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilderC1ERN5clang4ento14PathDiagnosticERNS_21PathDiagnosticBuilderE")
  //</editor-fold>
  public EdgeBuilder(final PathDiagnostic /*&*/ pd, final PathDiagnosticBuilder /*&*/ pdb) {
    // : CLocs(), PD(pd), PDB(pdb), PrevLoc() 
    //START JInit
    this.CLocs = new std.vector<ContextLocation>(new ContextLocation());
    this./*&*/PD=/*&*/pd;
    this./*&*/PDB=/*&*/pdb;
    this.PrevLoc = new PathDiagnosticLocation();
    //END JInit
    
    // If the PathDiagnostic already has pieces, add the enclosing statement
    // of the first piece as a context as well.
    if (!PD._path.empty()) {
      PrevLoc.$assignMove((PD._path.begin$Const().$star()).$arrow().getLocation());
      {
        
        /*const*/ Stmt /*P*/ S = PrevLoc.asStmt();
        if ((S != null)) {
          addExtendedContext(PDB.getEnclosingStmtLocation(S).asStmt());
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::~EdgeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1002,
   FQN="(anonymous namespace)::EdgeBuilder::~EdgeBuilder", NM="_ZN12_GLOBAL__N_111EdgeBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilderD0Ev")
  //</editor-fold>
  public void $destroy() {
    while (!CLocs.empty()) {
      popLocation();
    }
    
    // Finally, add an initial edge from the start location of the first
    // statement (if it doesn't already exist).
    PathDiagnosticLocation L = PathDiagnosticLocation.createDeclBegin(PDB.LC, 
        PDB.getSourceManager());
    if (L.isValid()) {
      rawAddEdge(new PathDiagnosticLocation(L));
    }
    //START JDestroy
    CLocs.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::flushLocations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1014,
   FQN="(anonymous namespace)::EdgeBuilder::flushLocations", NM="_ZN12_GLOBAL__N_111EdgeBuilder14flushLocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder14flushLocationsEv")
  //</editor-fold>
  public void flushLocations() {
    while (!CLocs.empty()) {
      popLocation();
    }
    PrevLoc.$assignMove(new PathDiagnosticLocation());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::addEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1117,
   FQN="(anonymous namespace)::EdgeBuilder::addEdge", NM="_ZN12_GLOBAL__N_111EdgeBuilder7addEdgeEN5clang4ento22PathDiagnosticLocationEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder7addEdgeEN5clang4ento22PathDiagnosticLocationEbb")
  //</editor-fold>
  public void addEdge(PathDiagnosticLocation NewLoc) {
    addEdge(NewLoc, false, 
         false);
  }
  public void addEdge(PathDiagnosticLocation NewLoc, boolean alwaysAdd/*= false*/) {
    addEdge(NewLoc, alwaysAdd, 
         false);
  }
  public void addEdge(PathDiagnosticLocation NewLoc, boolean alwaysAdd/*= false*/, 
         boolean IsPostJump/*= false*/) {
    if (!alwaysAdd && NewLoc.asLocation().isMacroID()) {
      return;
    }
    
    final /*const*/ PathDiagnosticLocation /*&*/ CLoc = getContextLocation(NewLoc);
    while (!CLocs.empty()) {
      final ContextLocation /*&*/ TopContextLoc = CLocs.back();
      
      // Is the top location context the same as the one for the new location?
      if (TopContextLoc.$eq(CLoc)) {
        if (alwaysAdd) {
          if (IsConsumedExpr(TopContextLoc)) {
            TopContextLoc.markDead();
          }
          
          rawAddEdge(new PathDiagnosticLocation(NewLoc));
        }
        if (IsPostJump) {
          TopContextLoc.markDead();
        }
        return;
      }
      if (containsLocation(TopContextLoc, CLoc)) {
        if (alwaysAdd) {
          rawAddEdge(new PathDiagnosticLocation(NewLoc));
          if (IsConsumedExpr(CLoc)) {
            CLocs.push_back_T$RR(new ContextLocation(CLoc, /*IsDead=*/ true));
            return;
          }
        }
        
        CLocs.push_back_T$RR(new ContextLocation(CLoc, /*IsDead=*/ IsPostJump));
        return;
      }
      
      // Context does not contain the location.  Flush it.
      popLocation();
    }
    
    // If we reach here, there is no enclosing context.  Just add the edge.
    rawAddEdge(new PathDiagnosticLocation(NewLoc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::rawAddEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1091,
   FQN="(anonymous namespace)::EdgeBuilder::rawAddEdge", NM="_ZN12_GLOBAL__N_111EdgeBuilder10rawAddEdgeEN5clang4ento22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder10rawAddEdgeEN5clang4ento22PathDiagnosticLocationE")
  //</editor-fold>
  public void rawAddEdge(PathDiagnosticLocation NewLoc) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!PrevLoc.isValid()) {
        PrevLoc.$assign(NewLoc);
        return;
      }
      
      final /*const*/ PathDiagnosticLocation /*&*/ NewLocClean = BugReporterStatics.cleanUpLocation(new PathDiagnosticLocation(NewLoc), PDB.LC);
      final /*const*/ PathDiagnosticLocation /*&*/ PrevLocClean = BugReporterStatics.cleanUpLocation(new PathDiagnosticLocation(PrevLoc), PDB.LC);
      if (PrevLocClean.asLocation().isInvalid()) {
        PrevLoc.$assign(NewLoc);
        return;
      }
      if (FullSourceLoc.$eq_FullSourceLoc$C(NewLocClean.asLocation(), PrevLocClean.asLocation())) {
        return;
      }
      
      // FIXME: Ignore intra-macro edges for now.
      if (FullSourceLoc.$eq_FullSourceLoc$C(NewLocClean.asLocation().getExpansionLoc(), 
          PrevLocClean.asLocation().getExpansionLoc())) {
        return;
      }
      
      PD.getActivePath().push_front_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(new PathDiagnosticControlFlowPiece(NewLocClean, PrevLocClean)))); $c$.clean();
      PrevLoc.$assign(NewLoc);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::addContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1196,
   FQN="(anonymous namespace)::EdgeBuilder::addContext", NM="_ZN12_GLOBAL__N_111EdgeBuilder10addContextEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder10addContextEPKN5clang4StmtE")
  //</editor-fold>
  public void addContext(/*const*/ Stmt /*P*/ S) {
    if (!(S != null)) {
      return;
    }
    
    PathDiagnosticLocation L/*J*/= new PathDiagnosticLocation(S, PDB.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, PDB.LC));
    addContext(L);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::addContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1204,
   FQN="(anonymous namespace)::EdgeBuilder::addContext", NM="_ZN12_GLOBAL__N_111EdgeBuilder10addContextERKN5clang4ento22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder10addContextERKN5clang4ento22PathDiagnosticLocationE")
  //</editor-fold>
  public void addContext(final /*const*/ PathDiagnosticLocation /*&*/ L) {
    while (!CLocs.empty()) {
      final /*const*/ PathDiagnosticLocation /*&*/ TopContextLoc = CLocs.back();
      
      // Is the top location context the same as the one for the new location?
      if (TopContextLoc.$eq(L)) {
        return;
      }
      if (containsLocation(TopContextLoc, L)) {
        CLocs.push_back_T$RR(new ContextLocation(L));
        return;
      }
      
      // Context does not contain the location.  Flush it.
      popLocation();
    }
    
    CLocs.push_back_T$RR(new ContextLocation(L));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EdgeBuilder::addExtendedContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 1171,
   FQN="(anonymous namespace)::EdgeBuilder::addExtendedContext", NM="_ZN12_GLOBAL__N_111EdgeBuilder18addExtendedContextEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_111EdgeBuilder18addExtendedContextEPKN5clang4StmtE")
  //</editor-fold>
  public void addExtendedContext(/*const*/ Stmt /*P*/ S) {
    if (!(S != null)) {
      return;
    }
    
    /*const*/ Stmt /*P*/ Parent = PDB.getParent(S);
    while ((Parent != null)) {
      if (isa_CompoundStmt(Parent)) {
        Parent = PDB.getParent(Parent);
      } else {
        break;
      }
    }
    if ((Parent != null)) {
      switch (Parent.getStmtClass()) {
       case DoStmtClass:
       case ObjCAtSynchronizedStmtClass:
        addContext(Parent);
       default:
        break;
      }
    }
    
    addContext(S);
  }

  
  @Override public String toString() {
    return "" + "CLocs=" + CLocs // NOI18N
              + ", PD=" + "[PathDiagnostic]" // NOI18N
              + ", PDB=" + "[PathDiagnosticBuilder]" // NOI18N
              + ", PrevLoc=" + PrevLoc; // NOI18N
  }
}
