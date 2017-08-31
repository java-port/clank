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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.checkers.ento.EntoGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 33,
 FQN="(anonymous namespace)::UnreachableCodeChecker", NM="_ZN12_GLOBAL__N_122UnreachableCodeCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeCheckerE")
//</editor-fold>
public class UnreachableCodeChecker extends /*public*/ Checker/*T<EndAnalysis> */
        implements org.clang.staticanalyzer.java.EndAnalysisChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeChecker::checkEndAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 49,
   FQN="(anonymous namespace)::UnreachableCodeChecker::checkEndAnalysis", NM="_ZNK12_GLOBAL__N_122UnreachableCodeChecker16checkEndAnalysisERN5clang4ento13ExplodedGraphERNS2_11BugReporterERNS2_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZNK12_GLOBAL__N_122UnreachableCodeChecker16checkEndAnalysisERN5clang4ento13ExplodedGraphERNS2_11BugReporterERNS2_10ExprEngineE")
  //</editor-fold>
  public void checkEndAnalysis(final ExplodedGraph /*&*/ G, 
                  final BugReporter /*&*/ B, 
                  final ExprEngine /*&*/ Eng) /*const*/ {
    SmallSetUInt reachable = null;
    SmallSetUInt visited = null;
    try {
      reachable/*J*/= new SmallSetUInt(32);
      visited/*J*/= new SmallSetUInt(32);
      if (Eng.hasWorkRemaining()) {
        return;
      }
      
      /*const*/ Decl /*P*/ D = null;
      CFG /*P*/ C = null;
      ParentMap /*P*/ PM = null;
      /*const*/ LocationContext /*P*/ LC = null;
      // Iterate over ExplodedGraph
      for (FoldingSetIterator<ExplodedNode> I = G.nodes_begin(), E = G.nodes_end();
           I.$noteq(E); I.$preInc()) {
        final /*const*/ ProgramPoint /*&*/ P = I.$arrow().getLocation();
        LC = P.getLocationContext();
        if (!LC.inTopFrame()) {
          continue;
        }
        if (!(D != null)) {
          D = LC.getAnalysisDeclContext().getDecl();
        }
        
        // Save the CFG if we don't have it already
        if (!(C != null)) {
          C = LC.getAnalysisDeclContext().getUnoptimizedCFG();
        }
        if (!(PM != null)) {
          PM = $AddrOf(LC.getParentMap());
        }
        {
          
          Optional<BlockEntrance> BE = P.getAs(BlockEntrance.class);
          if (BE.$bool()) {
            /*const*/ CFGBlock /*P*/ CB = BE.$arrow().getBlock();
            reachable.insert(CB.getBlockID());
          }
        }
      }
      
      // Bail out if we didn't get the CFG or the ParentMap.
      if (!(D != null) || !(C != null) || !(PM != null)) {
        return;
      }
      {
        
        // Don't do anything for template instantiations.  Proving that code
        // in a template instantiation is unreachable means proving that it is
        // unreachable in all instantiations.
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          if (FD.isTemplateInstantiation()) {
            return;
          }
        }
      }
      
      // Find CFGBlocks that were not covered by any node
      for (type$ptr<CFGBlock /*P*/ /*const*/ /*P*/> I = $tryClone(C.begin()), /*P*/ E = $tryClone(C.end()); $noteq_ptr(I, E); I.$preInc()) {
        /*const*/ CFGBlock /*P*/ CB = I.$star();
        // Check if the block is unreachable
        if ((reachable.count(CB.getBlockID()) != 0)) {
          continue;
        }
        
        // Check if the block is empty (an artificial block)
        if (isEmptyCFGBlock(CB)) {
          continue;
        }
        
        // Find the entry points for this block
        if (!(visited.count(CB.getBlockID()) != 0)) {
          FindUnreachableEntryPoints(CB, reachable, visited);
        }
        
        // This block may have been pruned; check if we still want to report it
        if ((reachable.count(CB.getBlockID()) != 0)) {
          continue;
        }
        
        // Check for false positives
        if ($greater_uint(CB.size(), 0) && isInvalidPath(CB, $Deref(PM))) {
          continue;
        }
        {
          
          // It is good practice to always have a "default" label in a "switch", even
          // if we should never get there. It can be used to detect errors, for
          // instance. Unreachable code directly under a "default" label is therefore
          // likely to be a false positive.
          /*const*/ Stmt /*P*/ label = CB.getLabel$Const();
          if ((label != null)) {
            if (label.getStmtClass() == Stmt.StmtClass.DefaultStmtClass) {
              continue;
            }
          }
        }
        
        // Special case for __builtin_unreachable.
        // FIXME: This should be extended to include other unreachable markers,
        // such as llvm_unreachable.
        if (!CB.empty()) {
          boolean foundUnreachable = false;
          for (std.reverse_iterator</*const*/ CFGElement> ci = CB.begin$Const(), ce = CB.end$Const();
               $noteq_reverse_iterator$C(ci, ce); ci.$preInc()) {
            {
              Optional<CFGStmt> S = (ci.$star()).getAs(CFGStmt.class);
              if (S.$bool()) {
                {
                  /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(S.$arrow().getStmt());
                  if ((CE != null)) {
                    if (CE.getBuiltinCallee() == Builtin.ID.BI__builtin_unreachable.getValue()) {
                      foundUnreachable = true;
                      break;
                    }
                  }
                }
              }
            }
          }
          if (foundUnreachable) {
            continue;
          }
        }
        
        // We found a block that wasn't covered - find the statement to report
        SourceRange SR/*J*/= new SourceRange();
        PathDiagnosticLocation DL/*J*/= new PathDiagnosticLocation();
        SourceLocation SL/*J*/= new SourceLocation();
        {
          /*const*/ Stmt /*P*/ S = getUnreachableStmt(CB);
          if ((S != null)) {
            SR.$assignMove(S.getSourceRange());
            DL.$assignMove(PathDiagnosticLocation.createBegin(S, B.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC)));
            SL.$assignMove(DL.asLocation());
            if (SR.isInvalid() || !SL.isValid()) {
              continue;
            }
          } else {
            continue;
          }
        }
        
        // Check if the SourceLocation is in a system header
        final /*const*/ SourceManager /*&*/ SM = B.getSourceManager();
        if (SM.isInSystemHeader(/*NO_COPY*/SL) || SM.isInExternCSystemHeader(/*NO_COPY*/SL)) {
          continue;
        }
        
        B.EmitBasicReport(D, this, new StringRef(/*KEEP_STR*/"Unreachable code"), new StringRef(/*KEEP_STR*/"Dead code"), 
            new StringRef(/*KEEP_STR*/"This statement is never executed"), new PathDiagnosticLocation(DL), new ArrayRef<SourceRange>(SR, false));
      }
    } finally {
      if (visited != null) { visited.$destroy(); }
      if (reachable != null) { reachable.$destroy(); }
    }
  }

/*private:*/
  /*typedef llvm::SmallSet<unsigned int, 32> CFGBlocksSet*/
//  public final class CFGBlocksSet extends SmallSetUInt{ };
  
  
  // Find the Stmt* in a CFGBlock for reporting a warning
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeChecker::getUnreachableStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 192,
   FQN="(anonymous namespace)::UnreachableCodeChecker::getUnreachableStmt", NM="_ZN12_GLOBAL__N_122UnreachableCodeChecker18getUnreachableStmtEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeChecker18getUnreachableStmtEPKN5clang8CFGBlockE")
  //</editor-fold>
  private static /*const*/ Stmt /*P*/ getUnreachableStmt(/*const*/ CFGBlock /*P*/ CB) {
    for (std.reverse_iterator</*const*/ CFGElement> I = CB.begin$Const(), E = CB.end$Const(); $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      {
        Optional<CFGStmt> S = I.$arrow().getAs(CFGStmt.class);
        if (S.$bool()) {
          return S.$arrow().getStmt();
        }
      }
    }
    {
      /*const*/ Stmt /*P*/ S = CB.getTerminator$Const().$Stmt$C$P();
      if ((S != null)) {
        return S;
      } else {
        return null;
      }
    }
  }

  
  // Recursively finds the entry point(s) for this dead CFGBlock.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeChecker::FindUnreachableEntryPoints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 170,
   FQN="(anonymous namespace)::UnreachableCodeChecker::FindUnreachableEntryPoints", NM="_ZN12_GLOBAL__N_122UnreachableCodeChecker26FindUnreachableEntryPointsEPKN5clang8CFGBlockERN4llvm8SmallSetIjLj32ESt4lessIjEEESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeChecker26FindUnreachableEntryPointsEPKN5clang8CFGBlockERN4llvm8SmallSetIjLj32ESt4lessIjEEESA_")
  //</editor-fold>
  private static void FindUnreachableEntryPoints(/*const*/ CFGBlock /*P*/ CB, 
                            final SmallSetUInt /*&*/ reachable, 
                            final SmallSetUInt /*&*/ visited) {
    visited.insert(CB.getBlockID());
    
    for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(CB.pred_begin$Const()), /*P*/ E = $tryClone(CB.pred_end$Const());
         $noteq_ptr(I, E); I.$preInc()) {
      if (!((I.$star().$CFGBlock$P()) != null)) {
        continue;
      }
      if (!(reachable.count((I.$star()).$arrow().getBlockID()) != 0)) {
        // If we find an unreachable predecessor, mark this block as reachable so
        // we don't report this block
        reachable.insert(CB.getBlockID());
        if (!(visited.count((I.$star()).$arrow().getBlockID()) != 0)) {
          // If we haven't previously visited the unreachable predecessor, recurse
          FindUnreachableEntryPoints(I.$star().$CFGBlock$P(), reachable, visited);
        }
      }
    }
  }

  
  // Determines if the path to this CFGBlock contained an element that infers this
  // block is a false positive. We assume that FindUnreachableEntryPoints has
  // already marked only the entry points to any dead code, so we need only to
  // find the condition that led to this block (the predecessor of this block.)
  // There will never be more than one predecessor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeChecker::isInvalidPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 208,
   FQN="(anonymous namespace)::UnreachableCodeChecker::isInvalidPath", NM="_ZN12_GLOBAL__N_122UnreachableCodeChecker13isInvalidPathEPKN5clang8CFGBlockERKNS1_9ParentMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeChecker13isInvalidPathEPKN5clang8CFGBlockERKNS1_9ParentMapE")
  //</editor-fold>
  private static boolean isInvalidPath(/*const*/ CFGBlock /*P*/ CB, 
               final /*const*/ ParentMap /*&*/ PM) {
    // We only expect a predecessor size of 0 or 1. If it is >1, then an external
    // condition has broken our assumption (for example, a sink being placed by
    // another check). In these cases, we choose not to report.
    if ($greater_uint(CB.pred_size(), 1)) {
      return true;
    }
    
    // If there are no predecessors, then this block is trivially unreachable
    if (CB.pred_size() == 0) {
      return false;
    }
    
    /*const*/ CFGBlock /*P*/ pred = CB.pred_begin$Const().$star().$CFGBlock$P();
    if (!(pred != null)) {
      return false;
    }
    
    // Get the predecessor block's terminator conditon
    /*const*/ Stmt /*P*/ cond = pred.getTerminatorCondition$Const();
    
    //assert(cond && "CFGBlock's predecessor has a terminator condition");
    // The previous assertion is invalid in some cases (eg do/while). Leaving
    // reporting of these situations on at the moment to help triage these cases.
    if (!(cond != null)) {
      return false;
    }
    
    // Run each of the checks on the conditions
    return containsMacro(cond) || containsEnum(cond)
       || containsStaticLocal(cond) || containsBuiltinOffsetOf(cond)
       || containsStmt(UnaryExprOrTypeTraitExpr.class, cond);
  }

  
  // Returns true if the given CFGBlock is empty
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeChecker::isEmptyCFGBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 240,
   FQN="(anonymous namespace)::UnreachableCodeChecker::isEmptyCFGBlock", NM="_ZN12_GLOBAL__N_122UnreachableCodeChecker15isEmptyCFGBlockEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeChecker15isEmptyCFGBlockEPKN5clang8CFGBlockE")
  //</editor-fold>
  private static boolean isEmptyCFGBlock(/*const*/ CFGBlock /*P*/ CB) {
    return CB.getLabel$Const() == null // No labels
       && CB.size() == 0 // No statements
       && !CB.getTerminator$Const().$bool(); // No terminator
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeChecker::~UnreachableCodeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 33,
   FQN="(anonymous namespace)::UnreachableCodeChecker::~UnreachableCodeChecker", NM="_ZN12_GLOBAL__N_122UnreachableCodeCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeChecker::UnreachableCodeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 33,
   FQN="(anonymous namespace)::UnreachableCodeChecker::UnreachableCodeChecker", NM="_ZN12_GLOBAL__N_122UnreachableCodeCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ UnreachableCodeChecker() {
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
