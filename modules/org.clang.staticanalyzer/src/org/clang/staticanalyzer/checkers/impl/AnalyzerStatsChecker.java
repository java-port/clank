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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.AnalyzerStatsCheckerStatics.*;
import org.clang.staticanalyzer.java.CheckBase;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzerStatsChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp", line = 35,
 FQN="(anonymous namespace)::AnalyzerStatsChecker", NM="_ZN12_GLOBAL__N_120AnalyzerStatsCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp -nm=_ZN12_GLOBAL__N_120AnalyzerStatsCheckerE")
//</editor-fold>
public class AnalyzerStatsChecker extends /*public*/ Checker/*T<EndAnalysis> */
        implements org.clang.staticanalyzer.java.EndAnalysisChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzerStatsChecker::checkEndAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp", line = 41,
   FQN="(anonymous namespace)::AnalyzerStatsChecker::checkEndAnalysis", NM="_ZNK12_GLOBAL__N_120AnalyzerStatsChecker16checkEndAnalysisERN5clang4ento13ExplodedGraphERNS2_11BugReporterERNS2_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp -nm=_ZNK12_GLOBAL__N_120AnalyzerStatsChecker16checkEndAnalysisERN5clang4ento13ExplodedGraphERNS2_11BugReporterERNS2_10ExprEngineE")
  //</editor-fold>
  public void checkEndAnalysis(final ExplodedGraph /*&*/ G, 
                  final BugReporter /*&*/ B, 
                  final ExprEngine /*&*/ Eng) /*const*/ {
    raw_svector_ostream output = null;
    try {
      /*const*/ CFG /*P*/ C = null;
      final /*const*/ SourceManager /*&*/ SM = B.getSourceManager();
      SmallPtrSet</*const*/ CFGBlock /*P*/ > reachable/*J*/= new SmallPtrSet</*const*/ CFGBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
      
      // Root node should have the location context of the top most function.
      /*const*/ ExplodedNode /*P*/ GraphRoot = G.roots_begin().$star();
      /*const*/ LocationContext /*P*/ LC = GraphRoot.getLocation().getLocationContext();
      
      /*const*/ Decl /*P*/ D = LC.getDecl();
      
      // Iterate over the exploded graph.
      for (FoldingSetIterator<ExplodedNode> I = G.nodes_begin();
           I.$noteq(G.nodes_end()); I.$preInc()) {
        final /*const*/ ProgramPoint /*&*/ P = I.$arrow().getLocation();
        
        // Only check the coverage in the top level function (optimization).
        if (D != P.getLocationContext().getDecl()) {
          continue;
        }
        {
          
          Optional<BlockEntrance> BE = P.getAs(BlockEntrance.class);
          if (BE.$bool()) {
            /*const*/ CFGBlock /*P*/ CB = BE.$arrow().getBlock();
            reachable.insert(CB);
          }
        }
      }
      
      // Get the CFG and the Decl of this block.
      C = LC.getCFG();
      
      /*uint*/int total = 0;
      /*uint*/int unreachable = 0;
      
      // Find CFGBlocks that were not covered by any node
      for (type$ptr<CFGBlock /*P*/ /*const*/ /*P*/> I = $tryClone(C.begin$Const()); $noteq_ptr(I, C.end$Const()); I.$preInc()) {
        /*const*/ CFGBlock /*P*/ CB = I.$star();
        ++total;
        // Check if the block is unreachable
        if (!(reachable.count(CB) != 0)) {
          ++unreachable;
        }
      }
      
      // We never 'reach' the entry block, so correct the unreachable count
      unreachable--;
      // There is no BlockEntrance corresponding to the exit block as well, so
      // assume it is reached as well.
      unreachable--;
      
      // Generate the warning string
      SmallString/*128*/ buf/*J*/= new SmallString/*128*/(128);
      output/*J*/= new raw_svector_ostream(buf);
      PresumedLoc Loc = SM.getPresumedLoc(D.getLocation());
      if (!Loc.isValid()) {
        return;
      }
      if (isa_FunctionDecl(D) || isa_ObjCMethodDecl(D)) {
        /*const*/ NamedDecl /*P*/ ND = cast_NamedDecl(D);
        $out_raw_ostream_NamedDecl$C(output, $Deref(ND));
      } else if (isa_BlockDecl(D)) {
        output.$out(/*KEEP_STR*/"block(line:").$out_uint(Loc.getLine()).$out(/*KEEP_STR*/":col:").$out_uint(Loc.getColumn());
      }
      
      NumBlocksUnreachable.$addassign(unreachable);
      NumBlocks.$addassign(total);
      std.string NameOfRootFunction = output.str().$string();
      
      output.$out(/*KEEP_STR*/" -> Total CFGBlocks: ").$out_uint(total).$out(/*KEEP_STR*/" | Unreachable CFGBlocks: ").$out_uint(
          unreachable
      ).$out(/*KEEP_STR*/" | Exhausted Block: ").$out(
          (Eng.wasBlocksExhausted() ? $("yes") : $("no"))
      ).$out(
          /*KEEP_STR*/" | Empty WorkList: "
      ).$out(
          (Eng.hasEmptyWorkList() ? $("yes") : $("no"))
      );
      
      B.EmitBasicReport(D, this, new StringRef(/*KEEP_STR*/"Analyzer Statistics"), new StringRef(/*KEEP_STR*/"Internal Statistics"), 
          output.str(), new PathDiagnosticLocation(D, SM));
      
      // Emit warning for each block we bailed out on.
      /*typedef CoreEngine::BlocksExhausted::const_iterator ExhaustedIterator*/
//      final class ExhaustedIterator extends __normal_iterator</*const*/ std.pair<BlockEdge, /*const*/ ExplodedNode /*P*/ > /*P*/ , vector<std.pair<BlockEdge, /*const*/ ExplodedNode /*P*/ >> >{ };
      final /*const*/ CoreEngine /*&*/ CE = Eng.getCoreEngine();
      for (std.vector.iterator</*const*/ std.pairTypePtr<BlockEdge, /*const*/ ExplodedNode /*P*/ > /*P*/ > I = CE.blocks_exhausted_begin(), 
          E = CE.blocks_exhausted_end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
        final /*const*/ BlockEdge /*&*/ BE = I.$arrow().first;
        /*const*/ CFGBlock /*P*/ Exit = BE.getDst();
        final /*const*/ CFGElement /*&*/ CE$1 = Exit.front();
        {
          Optional<CFGStmt> CS = CE$1.getAs(CFGStmt.class);
          if (CS.$bool()) {
            raw_svector_ostream outputI = null;
            try {
              SmallString/*128*/ bufI/*J*/= new SmallString/*128*/(128);
              outputI/*J*/= new raw_svector_ostream(bufI);
              outputI.$out(/*KEEP_STR*/$LPAREN).$out(NameOfRootFunction).$out(/*KEEP_STR*/$RPAREN).$out(
                  /*KEEP_STR*/": The analyzer generated a sink at this point"
              );
              B.EmitBasicReport(D, this, new StringRef(/*KEEP_STR*/"Sink Point"), new StringRef(/*KEEP_STR*/"Internal Statistics"), outputI.str(), 
                  PathDiagnosticLocation.createBegin(CS.$arrow().getStmt(), SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC)));
            } finally {
              if (outputI != null) { outputI.$destroy(); }
            }
          }
        }
      }
    } finally {
      if (output != null) { output.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzerStatsChecker::~AnalyzerStatsChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp", line = 35,
   FQN="(anonymous namespace)::AnalyzerStatsChecker::~AnalyzerStatsChecker", NM="_ZN12_GLOBAL__N_120AnalyzerStatsCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp -nm=_ZN12_GLOBAL__N_120AnalyzerStatsCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzerStatsChecker::AnalyzerStatsChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp", line = 35,
   FQN="(anonymous namespace)::AnalyzerStatsChecker::AnalyzerStatsChecker", NM="_ZN12_GLOBAL__N_120AnalyzerStatsCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp -nm=_ZN12_GLOBAL__N_120AnalyzerStatsCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ AnalyzerStatsChecker() {
    // : Checker<EndAnalysis>() 
    //START JInit
    super();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new EndAnalysis()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
