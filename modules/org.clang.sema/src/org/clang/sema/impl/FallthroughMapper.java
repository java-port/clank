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

package org.clang.sema.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.analysis.*;
import static org.clang.analysis.CFGBlock.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 899,
 FQN="(anonymous namespace)::FallthroughMapper", NM="_ZN12_GLOBAL__N_117FallthroughMapperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapperE")
//</editor-fold>
public class FallthroughMapper implements /*public*/ RecursiveASTVisitor<FallthroughMapper>, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::FallthroughMapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 901,
   FQN="(anonymous namespace)::FallthroughMapper::FallthroughMapper", NM="_ZN12_GLOBAL__N_117FallthroughMapperC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapperC1ERN5clang4SemaE")
  //</editor-fold>
  public FallthroughMapper(final Sema /*&*/ S) {
    // : RecursiveASTVisitor<FallthroughMapper>(), FoundSwitchStatements(false), FallthroughStmts(), S(S), ReachableBlocks() 
    //START JInit
    $RecursiveASTVisitor();
    this.FoundSwitchStatements = false;
    this.FallthroughStmts = new SmallPtrSet</*const*/ AttributedStmt /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    this./*&*/S=/*&*/S;
    this.ReachableBlocks = new SmallPtrSet</*const*/ CFGBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::foundSwitchStatements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 906,
   FQN="(anonymous namespace)::FallthroughMapper::foundSwitchStatements", NM="_ZNK12_GLOBAL__N_117FallthroughMapper21foundSwitchStatementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK12_GLOBAL__N_117FallthroughMapper21foundSwitchStatementsEv")
  //</editor-fold>
  public boolean foundSwitchStatements() /*const*/ {
    return FoundSwitchStatements;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::markFallthroughVisited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 908,
   FQN="(anonymous namespace)::FallthroughMapper::markFallthroughVisited", NM="_ZN12_GLOBAL__N_117FallthroughMapper22markFallthroughVisitedEPKN5clang14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper22markFallthroughVisitedEPKN5clang14AttributedStmtE")
  //</editor-fold>
  public void markFallthroughVisited(/*const*/ AttributedStmt /*P*/ Stmt) {
    boolean Found = FallthroughStmts.erase(Stmt);
    assert (Found);
    ///*J:(void)*/Found;
  }

  
  /*typedef llvm::SmallPtrSet<const AttributedStmt *, 8> AttrStmts*/
//  public final class AttrStmts extends SmallPtrSet</*const*/ AttributedStmt /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::getFallthroughStmts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 916,
   FQN="(anonymous namespace)::FallthroughMapper::getFallthroughStmts", NM="_ZNK12_GLOBAL__N_117FallthroughMapper19getFallthroughStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK12_GLOBAL__N_117FallthroughMapper19getFallthroughStmtsEv")
  //</editor-fold>
  public /*const*/SmallPtrSet</*const*/ AttributedStmt /*P*/ > /*&*/ getFallthroughStmts() /*const*/ {
    return FallthroughStmts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::fillReachableBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 920,
   FQN="(anonymous namespace)::FallthroughMapper::fillReachableBlocks", NM="_ZN12_GLOBAL__N_117FallthroughMapper19fillReachableBlocksEPN5clang3CFGE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper19fillReachableBlocksEPN5clang3CFGE")
  //</editor-fold>
  public void fillReachableBlocks(CFG /*P*/ Cfg) {
    std.deque</*const*/ CFGBlock /*P*/ > BlockQueue = null;
    try {
      assert (ReachableBlocks.empty()) : "ReachableBlocks already filled";
      BlockQueue/*J*/= new std.deque</*const*/ CFGBlock /*P*/ >(true);
      
      ReachableBlocks.insert($AddrOf(Cfg.getEntry()));
      BlockQueue.push_back_T$RR($AddrOf(Cfg.getEntry()));
      // Mark all case blocks reachable to avoid problems with switching on
      // constants, covered enums, etc.
      // These blocks can contain fall-through annotations, and we don't want to
      // issue a warn_fallthrough_attr_unreachable for them.
      for (/*const*/ CFGBlock /*P*/ B : $Deref(Cfg)) {
        /*const*/ Stmt /*P*/ L = B.getLabel$Const();
        if ((L != null) && isa_SwitchCase(L) && ReachableBlocks.insert(B).second) {
          BlockQueue.push_back_T$C$R(B);
        }
      }
      while (!BlockQueue.empty()) {
        /*const*/ CFGBlock /*P*/ P = BlockQueue.front();
        BlockQueue.pop_front();
        for (type$ptr</*const*/ AdjacentBlock /*P*/ > I = $tryClone(P.succ_begin$Const()), 
            /*P*/ E = $tryClone(P.succ_end$Const());
             $noteq_ptr(I, E); I.$preInc()) {
          if (((I.$star().$CFGBlock$P()) != null) && ReachableBlocks.insert(I.$star().$CFGBlock$P()).second) {
            BlockQueue.push_back_T$RR(I.$star().$CFGBlock$P());
          }
        }
      }
    } finally {
      if (BlockQueue != null) { BlockQueue.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::checkFallThroughIntoBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 948,
   FQN="(anonymous namespace)::FallthroughMapper::checkFallThroughIntoBlock", NM="_ZN12_GLOBAL__N_117FallthroughMapper25checkFallThroughIntoBlockERKN5clang8CFGBlockERi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper25checkFallThroughIntoBlockERKN5clang8CFGBlockERi")
  //</editor-fold>
  public boolean checkFallThroughIntoBlock(final /*const*/ CFGBlock /*&*/ B, final int$ref/*int &*/ AnnotatedCnt) {
    std.deque</*const*/ CFGBlock /*P*/ > BlockQueue = null;
    try {
      assert (!ReachableBlocks.empty()) : "ReachableBlocks empty";
      
      int UnannotatedCnt = 0;
      AnnotatedCnt.$set(0);
      
      BlockQueue/*J*/= new std.deque</*const*/ CFGBlock /*P*/ >(true, B.pred_begin$Const(), B.pred_end$Const(), (AdjacentBlock from) -> from.$CFGBlock$P());
      while (!BlockQueue.empty()) {
        /*const*/ CFGBlock /*P*/ P = BlockQueue.front();
        BlockQueue.pop_front();
        if (!(P != null)) {
          continue;
        }
        
        /*const*/ Stmt /*P*/ Term = P.getTerminator$Const().$Stmt$C$P();
        if ((Term != null) && isa_SwitchStmt(Term)) {
          continue; // Switch statement, good.
        }
        
        /*const*/ SwitchCase /*P*/ SW = dyn_cast_or_null_SwitchCase(P.getLabel$Const());
        if ((SW != null) && SW.getSubStmt$Const() == B.getLabel$Const() && $eq_reverse_iterator$C(P.begin$Const(), P.end$Const())) {
          continue; // Previous case label has no statements, good.
        }
        
        /*const*/ LabelStmt /*P*/ L = dyn_cast_or_null_LabelStmt(P.getLabel$Const());
        if ((L != null) && L.getSubStmt$Const() == B.getLabel$Const() && $eq_reverse_iterator$C(P.begin$Const(), P.end$Const())) {
          continue; // Case label is preceded with a normal label, good.
        }
        if (!(ReachableBlocks.count(P) != 0)) {
          for (type$ptr</*const*/ CFGElement /*P*/ > ElemIt = $tryClone(P.rbegin$Const()), 
              /*P*/ ElemEnd = $tryClone(P.rend$Const());
               $noteq_ptr(ElemIt, ElemEnd); ElemIt.$preInc()) {
            {
              Optional<CFGStmt> CS = ElemIt.$arrow().getAs(CFGStmt.class);
              if (CS.$bool()) {
                {
                  /*const*/ AttributedStmt /*P*/ AS = asFallThroughAttr(CS.$arrow().getStmt());
                  if ((AS != null)) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($c$.track(S.Diag(AS.getLocStart(), 
                          diag.warn_fallthrough_attr_unreachable)));
                      markFallthroughVisited(AS);
                      AnnotatedCnt.$set$preInc();
                      break;
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
                // Don't care about other unreachable statements.
              }
            }
          }
          // If there are no unreachable statements, this may be a special
          // case in CFG:
          // case X: {
          //    A a;  // A has a destructor.
          //    break;
          // }
          // // <<<< This place is represented by a 'hanging' CFG block.
          // case Y:
          continue;
        }
        
        /*const*/ Stmt /*P*/ LastStmt = getLastStmt($Deref(P));
        {
          /*const*/ AttributedStmt /*P*/ AS = asFallThroughAttr(LastStmt);
          if ((AS != null)) {
            markFallthroughVisited(AS);
            AnnotatedCnt.$set$preInc();
            continue; // Fallthrough annotation, good.
          }
        }
        if (!(LastStmt != null)) { // This block contains no executable statements.
// Traverse its predecessors.
          std.copy(P.pred_begin$Const(), P.pred_end$Const(), 
              std.back_inserter(BlockQueue), (AdjacentBlock from) -> from.$CFGBlock$P());
          continue;
        }
        
        ++UnannotatedCnt;
      }
      return !!(UnannotatedCnt != 0);
    } finally {
      if (BlockQueue != null) { BlockQueue.$destroy(); }
    }
  }

  
  // RecursiveASTVisitor setup.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::shouldWalkTypesOfTypeLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1018,
   FQN="(anonymous namespace)::FallthroughMapper::shouldWalkTypesOfTypeLocs", NM="_ZNK12_GLOBAL__N_117FallthroughMapper25shouldWalkTypesOfTypeLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK12_GLOBAL__N_117FallthroughMapper25shouldWalkTypesOfTypeLocsEv")
  //</editor-fold>
  public boolean shouldWalkTypesOfTypeLocs() /*const*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::VisitAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1020,
   FQN="(anonymous namespace)::FallthroughMapper::VisitAttributedStmt", NM="_ZN12_GLOBAL__N_117FallthroughMapper19VisitAttributedStmtEPN5clang14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper19VisitAttributedStmtEPN5clang14AttributedStmtE")
  //</editor-fold>
  public boolean VisitAttributedStmt(AttributedStmt /*P*/ S) {
    if ((asFallThroughAttr(S) != null)) {
      FallthroughStmts.insert(S);
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1026,
   FQN="(anonymous namespace)::FallthroughMapper::VisitSwitchStmt", NM="_ZN12_GLOBAL__N_117FallthroughMapper15VisitSwitchStmtEPN5clang10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper15VisitSwitchStmtEPN5clang10SwitchStmtE")
  //</editor-fold>
  public boolean VisitSwitchStmt(SwitchStmt /*P*/ S) {
    FoundSwitchStatements = true;
    return true;
  }

  
  // We don't want to traverse local type declarations. We analyze their
  // methods separately.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::TraverseDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1033,
   FQN="(anonymous namespace)::FallthroughMapper::TraverseDecl", NM="_ZN12_GLOBAL__N_117FallthroughMapper12TraverseDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper12TraverseDeclEPN5clang4DeclE")
  //</editor-fold>
  public boolean TraverseDecl(Decl /*P*/ D) {
    return true;
  }

  
  // We analyze lambda bodies separately. Skip them here.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::TraverseLambdaBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1036,
   FQN="(anonymous namespace)::FallthroughMapper::TraverseLambdaBody", NM="_ZN12_GLOBAL__N_117FallthroughMapper18TraverseLambdaBodyEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper18TraverseLambdaBodyEPN5clang10LambdaExprE")
  //</editor-fold>
  public boolean TraverseLambdaBody(LambdaExpr /*P*/ LE) {
    return true;
  }

/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::asFallThroughAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1040,
   FQN="(anonymous namespace)::FallthroughMapper::asFallThroughAttr", NM="_ZN12_GLOBAL__N_117FallthroughMapper17asFallThroughAttrEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper17asFallThroughAttrEPKN5clang4StmtE")
  //</editor-fold>
  private static /*const*/ AttributedStmt /*P*/ asFallThroughAttr(/*const*/ Stmt /*P*/ S) {
    {
      /*const*/ AttributedStmt /*P*/ AS = dyn_cast_or_null_AttributedStmt(S);
      if ((AS != null)) {
        if (hasSpecificAttr(FallThroughAttr.class, AS.getAttrs())) {
          return AS;
        }
      }
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::getLastStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1048,
   FQN="(anonymous namespace)::FallthroughMapper::getLastStmt", NM="_ZN12_GLOBAL__N_117FallthroughMapper11getLastStmtERKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapper11getLastStmtERKN5clang8CFGBlockE")
  //</editor-fold>
  private static /*const*/ Stmt /*P*/ getLastStmt(final /*const*/ CFGBlock /*&*/ B) {
    {
      /*const*/ Stmt /*P*/ Term = B.getTerminator$Const().$Stmt$C$P();
      if ((Term != null)) {
        return Term;
      }
    }
    for (type$ptr</*const*/ CFGElement /*P*/ > ElemIt = $tryClone(B.rbegin$Const()), 
        /*P*/ ElemEnd = $tryClone(B.rend$Const());
         $noteq_ptr(ElemIt, ElemEnd); ElemIt.$preInc()) {
      {
        Optional<CFGStmt> CS = ElemIt.$arrow().getAs(CFGStmt.class);
        if (CS.$bool()) {
          return CS.$arrow().getStmt();
        }
      }
    }
    {
      // Workaround to detect a statement thrown out by CFGBuilder:
      //   case X: {} case Y:
      //   case X: ; case Y:
      /*const*/ SwitchCase /*P*/ SW = dyn_cast_or_null_SwitchCase(B.getLabel$Const());
      if ((SW != null)) {
        if (!isa_SwitchCase(SW.getSubStmt$Const())) {
          return SW.getSubStmt$Const();
        }
      }
    }
    
    return null;
  }

  
  private boolean FoundSwitchStatements;
  private SmallPtrSet</*const*/ AttributedStmt /*P*/ > FallthroughStmts;
  private final Sema /*&*/ S;
  private SmallPtrSet</*const*/ CFGBlock /*P*/ > ReachableBlocks;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FallthroughMapper::~FallthroughMapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 899,
   FQN="(anonymous namespace)::FallthroughMapper::~FallthroughMapper", NM="_ZN12_GLOBAL__N_117FallthroughMapperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117FallthroughMapperD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ReachableBlocks.$destroy();
    FallthroughStmts.$destroy();
    RecursiveASTVisitor.super.$destroy$RecursiveASTVisitor();
    //END JDestroy
  }

  @Override
  public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
    // no any overridden traverse with queue methods
    return false;
  }
  
  @Override public String toString() {
    return "" + "FoundSwitchStatements=" + FoundSwitchStatements // NOI18N
              + ", FallthroughStmts=" + FallthroughStmts // NOI18N
              + ", S=" + "[Sema]" // NOI18N
              + ", ReachableBlocks=" + ReachableBlocks // NOI18N
              + super.toString(); // NOI18N
  }
}
