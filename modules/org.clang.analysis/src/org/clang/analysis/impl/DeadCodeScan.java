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

package org.clang.analysis.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import static org.clang.analysis.impl.ReachableCodeStatics.*;
import org.clang.lex.Preprocessor;
import static org.clang.ast.java.AstStatementsRTTI.*;
import org.clang.analysis.analyses.reachable_code.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadCodeScan">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 344,
 FQN="(anonymous namespace)::DeadCodeScan", NM="_ZN12_GLOBAL__N_112DeadCodeScanE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN12_GLOBAL__N_112DeadCodeScanE")
//</editor-fold>
public class DeadCodeScan implements Destructors.ClassWithDestructor {
  private BitVector Visited;
  private final BitVector /*&*/ Reachable;
  private SmallVector</*const*/ CFGBlock /*P*/ > WorkList;
  private final Preprocessor /*&*/ PP;
  
  /*typedef SmallVector<std::pair<const CFGBlock *, const Stmt *>, 12> DeferredLocsTy*/
//  public final class DeferredLocsTy extends SmallVector<std.pair</*const*/ CFGBlock /*P*/ , /*const*/ Stmt /*P*/ >>{ };
  
  private SmallVector<std.pair</*const*/ CFGBlock /*P*/ , /*const*/ Stmt /*P*/ >> DeferredLocs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadCodeScan::DeadCodeScan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 356,
   FQN="(anonymous namespace)::DeadCodeScan::DeadCodeScan", NM="_ZN12_GLOBAL__N_112DeadCodeScanC1ERN4llvm9BitVectorERN5clang12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN12_GLOBAL__N_112DeadCodeScanC1ERN4llvm9BitVectorERN5clang12PreprocessorE")
  //</editor-fold>
  public DeadCodeScan(final BitVector /*&*/ reachable, final Preprocessor /*&*/ PP) {
    // : Visited(reachable.size()), Reachable(reachable), WorkList(), PP(PP), DeferredLocs() 
    //START JInit
    this.Visited = new BitVector(reachable.size());
    this./*&*/Reachable=/*&*/reachable;
    this.WorkList = new SmallVector</*const*/ CFGBlock /*P*/ >(10, (/*const*/ CFGBlock /*P*/ )null);
    this./*&*/PP=/*&*/PP;
    this.DeferredLocs = new SmallVector<std.pair</*const*/ CFGBlock /*P*/ , /*const*/ Stmt /*P*/ >>(12, new std.pairPtrPtr</*const*/ CFGBlock /*P*/ , /*const*/ Stmt /*P*/ >());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadCodeScan::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 375,
   FQN="(anonymous namespace)::DeadCodeScan::enqueue", NM="_ZN12_GLOBAL__N_112DeadCodeScan7enqueueEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN12_GLOBAL__N_112DeadCodeScan7enqueueEPKN5clang8CFGBlockE")
  //</editor-fold>
  public void enqueue(/*const*/ CFGBlock /*P*/ block) {
    /*uint*/int blockID = block.getBlockID();
    if (Reachable.$at(blockID).$bool() || Visited.$at(blockID).$bool()) {
      return;
    }
    Visited.$at(blockID).$assign(/*KEEP_BOOL*/true);
    WorkList.push_back(block);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadCodeScan::scanBackwards">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 442,
   FQN="(anonymous namespace)::DeadCodeScan::scanBackwards", NM="_ZN12_GLOBAL__N_112DeadCodeScan13scanBackwardsEPKN5clang8CFGBlockERNS1_14reachable_code8CallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN12_GLOBAL__N_112DeadCodeScan13scanBackwardsEPKN5clang8CFGBlockERNS1_14reachable_code8CallbackE")
  //</editor-fold>
  public /*uint*/int scanBackwards(/*const*/ CFGBlock /*P*/ Start, 
               final Callback /*&*/ CB) {
    
    /*uint*/int count = 0;
    enqueue(Start);
    while (!WorkList.empty()) {
      /*const*/ CFGBlock /*P*/ Block = WorkList.pop_back_val();
      
      // It is possible that this block has been marked reachable after
      // it was enqueued.
      if (Reachable.$at(Block.getBlockID()).$bool()) {
        continue;
      }
      
      // Look for any dead code within the block.
      /*const*/ Stmt /*P*/ S = findDeadCode(Block);
      if (!(S != null)) {
        // No dead code.  Possibly an empty block.  Look at dead predecessors.
        for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(Block.pred_begin$Const()), 
            /*P*/ E = $tryClone(Block.pred_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
          {
            /*const*/ CFGBlock /*P*/ predBlock = I.$star().$CFGBlock$P();
            if ((predBlock != null)) {
              enqueue(predBlock);
            }
          }
        }
        continue;
      }
      
      // Specially handle macro-expanded code.
      if (S.getLocStart().isMacroID()) {
        count += scanMaybeReachableFromBlock(Block, PP, Reachable);
        continue;
      }
      if (isDeadCodeRoot(Block)) {
        reportDeadCode(Block, S, CB);
        count += scanMaybeReachableFromBlock(Block, PP, Reachable);
      } else {
        // Record this statement as the possibly best location in a
        // strongly-connected component of dead code for emitting a
        // warning.
        DeferredLocs.push_back(std.make_pair_Ptr_Ptr(Block, S));
      }
    }
    
    // If we didn't find a dead root, then report the dead code with the
    // earliest location.
    if (!DeferredLocs.empty()) {
      llvm.array_pod_sort(DeferredLocs.begin(), DeferredLocs.end(), /*FuncRef*/ReachableCodeStatics::SrcCmp);
      for (type$ptr<std.pair</*const*/ CFGBlock /*P*/ , /*const*/ Stmt /*P*/ > /*P*/ > I = $tryClone(DeferredLocs.begin()), 
          /*P*/ E = $tryClone(DeferredLocs.end()); $noteq_ptr(I, E); I.$preInc()) {
        /*const*/ CFGBlock /*P*/ Block = I./*->*/$star().first;
        if (Reachable.$at(Block.getBlockID()).$bool()) {
          continue;
        }
        reportDeadCode(Block, I./*->*/$star().second, CB);
        count += scanMaybeReachableFromBlock(Block, PP, Reachable);
      }
    }
    
    return count;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadCodeScan::isDeadCodeRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 383,
   FQN="(anonymous namespace)::DeadCodeScan::isDeadCodeRoot", NM="_ZN12_GLOBAL__N_112DeadCodeScan14isDeadCodeRootEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN12_GLOBAL__N_112DeadCodeScan14isDeadCodeRootEPKN5clang8CFGBlockE")
  //</editor-fold>
  public boolean isDeadCodeRoot(/*const*/ CFGBlock /*P*/ Block) {
    boolean isDeadRoot = true;
    
    for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > I = $tryClone(Block.pred_begin$Const()), 
        /*P*/ E = $tryClone(Block.pred_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      {
        /*const*/ CFGBlock /*P*/ PredBlock = I.$star().$CFGBlock$P();
        if ((PredBlock != null)) {
          /*uint*/int blockID = PredBlock.getBlockID();
          if (Visited.$at(blockID).$bool()) {
            isDeadRoot = false;
            continue;
          }
          if (!Reachable.$at(blockID).$bool()) {
            isDeadRoot = false;
            Visited.$at(blockID).$assign(/*KEEP_BOOL*/true);
            WorkList.push_back(PredBlock);
            continue;
          }
        }
      }
    }
    
    return isDeadRoot;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadCodeScan::findDeadCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 414,
   FQN="(anonymous namespace)::DeadCodeScan::findDeadCode", NM="_ZN12_GLOBAL__N_112DeadCodeScan12findDeadCodeEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN12_GLOBAL__N_112DeadCodeScan12findDeadCodeEPKN5clang8CFGBlockE")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ findDeadCode(/*const*/ CFGBlock /*P*/ Block) {
    for (std.reverse_iterator</*const*/ CFGElement> I = Block.begin$Const(), E = Block.end$Const(); $noteq_reverse_iterator$C(I, E); I.$preInc())  {
      {
        Optional<CFGStmt> CS = I.$arrow().getAs(CFGStmt.class);
        if (CS.$bool()) {
          /*const*/ Stmt /*P*/ S = CS.$arrow().getStmt();
          if (isValidDeadStmt(S)) {
            return S;
          }
        }
      }
    }
    {
      
      CFGTerminator T = Block.getTerminator$Const();
      if (((T.$Stmt$P()) != null)) {
        if (!T.isTemporaryDtorsBranch()) {
          /*const*/ Stmt /*P*/ S = T.getStmt();
          if (isValidDeadStmt(S)) {
            return S;
          }
        }
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadCodeScan::reportDeadCode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 569,
   FQN="(anonymous namespace)::DeadCodeScan::reportDeadCode", NM="_ZN12_GLOBAL__N_112DeadCodeScan14reportDeadCodeEPKN5clang8CFGBlockEPKNS1_4StmtERNS1_14reachable_code8CallbackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN12_GLOBAL__N_112DeadCodeScan14reportDeadCodeEPKN5clang8CFGBlockEPKNS1_4StmtERNS1_14reachable_code8CallbackE")
  //</editor-fold>
  public void reportDeadCode(/*const*/ CFGBlock /*P*/ B, 
                /*const*/ Stmt /*P*/ S, 
                final Callback /*&*/ CB) {
    // Classify the unreachable code found, or suppress it in some cases.
    UnreachableKind UK = UnreachableKind.UK_Other;
    if (isa_BreakStmt(S)) {
      UK = UnreachableKind.UK_Break;
    } else if (isTrivialDoWhile(B, S)) {
      return;
    } else if (isDeadReturn(B, S)) {
      UK = UnreachableKind.UK_Return;
    }
    
    SourceRange SilenceableCondVal/*J*/= new SourceRange();
    if (UK == UnreachableKind.UK_Other) {
      {
        // Check if the dead code is part of the "loop target" of
        // a for/for-range loop.  This is the block that contains
        // the increment code.
        /*const*/ Stmt /*P*/ LoopTarget = B.getLoopTarget();
        if ((LoopTarget != null)) {
          SourceLocation Loc = LoopTarget.getLocStart();
          SourceRange R1/*J*/= new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc);
          SourceRange R2/*J*/= new SourceRange();
          {
            
            /*const*/ ForStmt /*P*/ FS = dyn_cast_ForStmt(LoopTarget);
            if ((FS != null)) {
              /*const*/ Expr /*P*/ Inc = FS.getInc$Const();
              Loc.$assignMove(Inc.getLocStart());
              R2.$assignMove(Inc.getSourceRange());
            }
          }
          
          CB.HandleUnreachable(UnreachableKind.UK_Loop_Increment, 
              new SourceLocation(Loc), new SourceRange(), new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc), new SourceRange(R2));
          return;
        }
      }
      
      // Check if the dead block has a predecessor whose branch has
      // a configuration value that *could* be modified to
      // silence the warning.
      type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > PI = $tryClone(B.pred_begin$Const());
      if ($noteq_ptr(PI, B.pred_end$Const())) {
        {
          /*const*/ CFGBlock /*P*/ PredBlock = PI./*->*/$star().getPossiblyUnreachableBlock();
          if ((PredBlock != null)) {
            /*const*/ Stmt /*P*/ TermCond = PredBlock.getTerminatorCondition$Const(/* strip parens */ false);
            isConfigurationValue(TermCond, PP, $AddrOf(SilenceableCondVal));
          }
        }
      }
    }
    
    SourceRange R1/*J*/= new SourceRange();
    SourceRange R2/*J*/= new SourceRange();
    SourceLocation Loc = GetUnreachableLoc(S, R1, R2);
    CB.HandleUnreachable(UK, new SourceLocation(Loc), new SourceRange(SilenceableCondVal), new SourceRange(R1), new SourceRange(R2));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadCodeScan::~DeadCodeScan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 344,
   FQN="(anonymous namespace)::DeadCodeScan::~DeadCodeScan", NM="_ZN12_GLOBAL__N_112DeadCodeScanD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN12_GLOBAL__N_112DeadCodeScanD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DeferredLocs.$destroy();
    WorkList.$destroy();
    Visited.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Visited=" + Visited // NOI18N
              + ", Reachable=" + Reachable // NOI18N
              + ", WorkList=" + WorkList // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", DeferredLocs=" + DeferredLocs; // NOI18N
  }
}
