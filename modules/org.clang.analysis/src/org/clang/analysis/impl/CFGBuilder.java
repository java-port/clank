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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.support.*;
import org.clang.analysis.impl.*;
import static org.clang.analysis.impl.CFGStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.ast.java.AstSizeofAndAlignment;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// CFGBuilder - This class implements CFG construction from an AST.
///   The builder is stateful: an instance of the builder should be used to only
///   construct a single CFG.
///
///   Example usage:
///
///     CFGBuilder builder;
///     std::unique_ptr<CFG> cfg = builder.buildCFG(decl, stmt1);
///
///  CFG construction is done via a recursive walk of an AST.  We actually parse
///  the AST in reverse order so that the successor of a basic block is
///  constructed prior to its predecessor.  This allows us to nicely capture
///  implicit fall-throughs without extra basic blocks.
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 366,
 FQN="(anonymous namespace)::CFGBuilder", NM="_ZN12_GLOBAL__N_110CFGBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilderE")
//</editor-fold>
public class CFGBuilder implements Destructors.ClassWithDestructor {
  /*typedef BlockScopePosPair JumpTarget*/
//  public final class JumpTarget extends BlockScopePosPair{ };
  /*typedef BlockScopePosPair JumpSource*/
//  public final class JumpSource extends BlockScopePosPair{ };
  
  private ASTContext /*P*/ Context;
  private std.unique_ptr<CFG> cfg;
  
  private CFGBlock /*P*/ Block;
  private CFGBlock /*P*/ Succ;
  private BlockScopePosPair ContinueJumpTarget;
  private BlockScopePosPair BreakJumpTarget;
  private CFGBlock /*P*/ SwitchTerminatedBlock;
  private CFGBlock /*P*/ DefaultCaseBlock;
  private CFGBlock /*P*/ TryTerminatedBlock;
  
  // Current position in local scope.
  private LocalScope.const_iterator ScopePos;
  
  // LabelMap records the mapping from Label expressions to their jump targets.
  /*typedef llvm::DenseMap<LabelDecl *, JumpTarget> LabelMapTy*/
//  public final class LabelMapTy extends DenseMap<LabelDecl /*P*/ , BlockScopePosPair>{ };
  private DenseMap<LabelDecl /*P*/ , BlockScopePosPair> LabelMap;
  
  // A list of blocks that end with a "goto" that must be backpatched to their
  // resolved targets upon completion of CFG construction.
  /*typedef std::vector<JumpSource> BackpatchBlocksTy*/
//  public final class BackpatchBlocksTy extends std.vector<BlockScopePosPair>{ };
  private std.vector<BlockScopePosPair> BackpatchBlocks;
  
  // A list of labels whose address has been taken (for indirect gotos).
  /*typedef llvm::SmallPtrSet<LabelDecl *, 5> LabelSetTy*/
//  public final class LabelSetTy extends SmallPtrSet<LabelDecl /*P*/ >{ };
  private SmallPtrSet<LabelDecl /*P*/ > AddressTakenLabels;
  
  private boolean badCFG;
  private final /*const*/ CFG.BuildOptions /*&*/ BuildOpts;
  
  // State to track for building switch statements.
  private boolean switchExclusivelyCovered;
  private Expr.EvalResult /*P*/ switchCond;
  
  private std.pair</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > /*P*/ cachedEntry;
  private /*const*/ Stmt /*P*/ lastLookup;
  
  // Caches boolean evaluations of expressions to avoid multiple re-evaluations
  // during construction of branches for chained logical operators.
  /*typedef llvm::DenseMap<Expr *, TryResult> CachedBoolEvalsTy*/
//  public final class CachedBoolEvalsTy extends DenseMap<Expr /*P*/ , TryResult>{ };
  private DenseMap<Expr /*P*/ , TryResult> CachedBoolEvals;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::CFGBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 413,
   FQN="(anonymous namespace)::CFGBuilder::CFGBuilder", NM="_ZN12_GLOBAL__N_110CFGBuilderC1EPN5clang10ASTContextERKNS1_3CFG12BuildOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilderC1EPN5clang10ASTContextERKNS1_3CFG12BuildOptionsE")
  //</editor-fold>
  public /*explicit*/ CFGBuilder(ASTContext /*P*/ astContext, 
      final /*const*/ CFG.BuildOptions /*&*/ buildOpts) {
    // : Context(astContext), cfg(new CFG()), Block(null), Succ(null), ContinueJumpTarget(), BreakJumpTarget(), SwitchTerminatedBlock(null), DefaultCaseBlock(null), TryTerminatedBlock(null), ScopePos(), LabelMap(), BackpatchBlocks(), AddressTakenLabels(), badCFG(false), BuildOpts(buildOpts), switchExclusivelyCovered(false), switchCond(null), cachedEntry(null), lastLookup(null), CachedBoolEvals() 
    //START JInit
    this.Context = astContext;
    this.cfg = new std.unique_ptr<CFG>(new CFG());
    this.Block = null;
    this.Succ = null;
    this.ContinueJumpTarget = new BlockScopePosPair();
    this.BreakJumpTarget = new BlockScopePosPair();
    this.SwitchTerminatedBlock = null;
    this.DefaultCaseBlock = null;
    this.TryTerminatedBlock = null;
    this.ScopePos = $tryClone(new LocalScope.const_iterator());
    this.LabelMap = new DenseMap<LabelDecl /*P*/ , BlockScopePosPair>(DenseMapInfo$LikePtr.$Info(), new BlockScopePosPair());
    this.BackpatchBlocks = new std.vector<BlockScopePosPair>(new BlockScopePosPair());
    this.AddressTakenLabels = new SmallPtrSet<LabelDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 5);
    this.badCFG = false;
    this./*&*/BuildOpts=/*&*/buildOpts;
    this.switchExclusivelyCovered = false;
    this.switchCond = null;
    this.cachedEntry = null;
    this.lastLookup = null;
    this.CachedBoolEvals = new DenseMap<Expr /*P*/ , TryResult>(DenseMapInfo$LikePtr.$Info(), new TryResult());
    //END JInit
  }

  
  // buildCFG - Used by external clients to construct the CFG.
  
  /// BuildCFG - Constructs a CFG from an AST (a Stmt*).  The AST can represent an
  ///  arbitrary statement.  Examples include a single expression or a function
  ///  body (compound statement).  The ownership of the returned CFG is
  ///  transferred to the caller.  If CFG construction fails, this method returns
  ///  NULL.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::buildCFG">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1022,
   FQN="(anonymous namespace)::CFGBuilder::buildCFG", NM="_ZN12_GLOBAL__N_110CFGBuilder8buildCFGEPKN5clang4DeclEPNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder8buildCFGEPKN5clang4DeclEPNS1_4StmtE")
  //</editor-fold>
  public std.unique_ptr<CFG> buildCFG(/*const*/ Decl /*P*/ D, Stmt /*P*/ Statement) {
    assert Native.$bool(cfg.get());
    if (!(Statement != null)) {
      return new std.unique_ptr<CFG>(JD$NullPtr.INSTANCE, null);
    }
    
    // Create an empty block that will serve as the exit block for the CFG.  Since
    // this is the first block added to the CFG, it will be implicitly registered
    // as the exit block.
    Succ = createBlock();
    assert (Succ == $AddrOf(cfg.$arrow().getExit()));
    Block = null; // the EXIT block is empty.  Create all other blocks lazily.
    if (BuildOpts.AddImplicitDtors) {
      {
        /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_or_null_CXXDestructorDecl(D);
        if ((DD != null)) {
          addImplicitDtorsForDestructor(DD);
        }
      }
    }
    
    // Visit the statements and create the CFG.
    CFGBlock /*P*/ B = addStmt(Statement);
    if (badCFG) {
      return new std.unique_ptr<CFG>(JD$NullPtr.INSTANCE, null);
    }
    {
      
      // For C++ constructor add initializers to CFG.
      /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_or_null_CXXConstructorDecl(D);
      if ((CD != null)) {
        for (CXXCtorInitializer /*P*/ I : llvm.reverse$NotHasRBegin(CD.inits$Const())) {
          B = addInitializer(I);
          if (badCFG) {
            return new std.unique_ptr<CFG>(JD$NullPtr.INSTANCE, null);
          }
        }
      }
    }
    if ((B != null)) {
      Succ = B;
    }
    
    // Backpatch the gotos whose label -> block mappings we didn't know when we
    // encountered them.
    for (std.vector.iterator<BlockScopePosPair> I = BackpatchBlocks.begin(), 
        E = BackpatchBlocks.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
      
      CFGBlock /*P*/ B$1 = I.$arrow().block;
      /*const*/ GotoStmt /*P*/ G = cast_GotoStmt(B$1.getTerminator().$star());
      DenseMapIterator<LabelDecl /*P*/ , BlockScopePosPair> LI = LabelMap.find(G.getLabel());
      
      // If there is no target for the goto, then we are looking at an
      // incomplete AST.  Handle this by not registering a successor.
      if (LI.$eq(/*NO_ITER_COPY*/LabelMap.end())) {
        continue;
      }
      
      BlockScopePosPair JT = new BlockScopePosPair(LI.$arrow().second);
      prependAutomaticObjDtorsWithTerminator(B$1, new LocalScope.const_iterator(I.$arrow().scopePosition), 
          new LocalScope.const_iterator(JT.scopePosition));
      addSuccessor(B$1, JT.block);
    }
    {
      
      // Add successors to the Indirect Goto Dispatch block (if we have one).
      CFGBlock /*P*/ B$1 = cfg.$arrow().getIndirectGotoBlock();
      if ((B$1 != null)) {
        for (SmallPtrSetIterator<LabelDecl /*P*/ > I = AddressTakenLabels.begin(), 
            E = AddressTakenLabels.end(); I.$noteq(E); I.$preInc()) {
          
          // Lookup the target block.
          DenseMapIterator<LabelDecl /*P*/ , BlockScopePosPair> LI = LabelMap.find(I.$star());
          
          // If there is no target block that contains label, then we are looking
          // at an incomplete AST.  Handle this by not registering a successor.
          if (LI.$eq(/*NO_ITER_COPY*/LabelMap.end())) {
            continue;
          }
          
          addSuccessor(B$1, LI.$arrow().second.block);
        }
      }
    }
    
    // Create an empty entry block that has no predecessors.
    cfg.$arrow().setEntry(createBlock());
    
    return new std.unique_ptr<CFG>(JD$Move.INSTANCE, std.move(cfg));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::alwaysAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 968,
   FQN="(anonymous namespace)::CFGBuilder::alwaysAdd", NM="_ZN12_GLOBAL__N_110CFGBuilder9alwaysAddEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder9alwaysAddEPKN5clang4StmtE")
  //</editor-fold>
  public boolean alwaysAdd(/*const*/ Stmt /*P*/ stmt) {
    boolean shouldAdd = BuildOpts.alwaysAdd(stmt);
    if (!Native.$bool(BuildOpts.forcedBlkExprs)) {
      return shouldAdd;
    }
    if (lastLookup == stmt) {
      if ((cachedEntry != null)) {
        assert (cachedEntry.first == stmt);
        return true;
      }
      return shouldAdd;
    }
    
    lastLookup = stmt;
    
    // Perform the lookup!
    DenseMap</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > /*P*/ fb = BuildOpts.forcedBlkExprs.$star();
    if (!(fb != null)) {
      // No need to update 'cachedEntry', since it will always be null.
      assert (!(cachedEntry != null));
      return shouldAdd;
    }
    
    DenseMapIterator</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > itr = fb.find(stmt);
    if (itr.$eq(/*NO_ITER_COPY*/fb.end())) {
      cachedEntry = null;
      return shouldAdd;
    }
    
    cachedEntry = $AddrOf(itr.$star());
    return true;
  }

/*private:*/
  // Visitors to walk an AST and construct the CFG.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1632,
   FQN="(anonymous namespace)::CFGBuilder::VisitAddrLabelExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder18VisitAddrLabelExprEPN5clang13AddrLabelExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder18VisitAddrLabelExprEPN5clang13AddrLabelExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitAddrLabelExpr(AddrLabelExpr /*P*/ A, 
                    AddStmtChoice asc) {
    AddressTakenLabels.insert(A.getLabel());
    if (asc.alwaysAdd(/*Deref*/this, A)) {
      autoCreateBlock();
      appendStmt(Block, A);
    }
    
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1756,
   FQN="(anonymous namespace)::CFGBuilder::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_110CFGBuilder19VisitBinaryOperatorEPN5clang14BinaryOperatorENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder19VisitBinaryOperatorEPN5clang14BinaryOperatorENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitBinaryOperator(BinaryOperator /*P*/ B, 
                     AddStmtChoice asc) {
    // && or ||
    if (B.isLogicalOp()) {
      return VisitLogicalOperator(B);
    }
    if (B.getOpcode() == BinaryOperatorKind.BO_Comma) { // ,
      autoCreateBlock();
      appendStmt(Block, B);
      addStmt(B.getRHS());
      return addStmt(B.getLHS());
    }
    if (B.isAssignmentOp()) {
      if (asc.alwaysAdd(/*Deref*/this, B)) {
        autoCreateBlock();
        appendStmt(Block, B);
      }
      Visit(B.getLHS());
      return Visit(B.getRHS());
    }
    if (asc.alwaysAdd(/*Deref*/this, B)) {
      autoCreateBlock();
      appendStmt(Block, B);
    }
    
    CFGBlock /*P*/ RBlock = Visit(B.getRHS());
    CFGBlock /*P*/ LBlock = Visit(B.getLHS());
    // If visiting RHS causes us to finish 'Block', e.g. the RHS is a StmtExpr
    // containing a DoStmt, and the LHS doesn't create a new block, then we should
    // return RBlock.  Otherwise we'll incorrectly return NULL.
    return ((LBlock != null) ? LBlock : RBlock);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1799,
   FQN="(anonymous namespace)::CFGBuilder::VisitBreakStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder14VisitBreakStmtEPN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder14VisitBreakStmtEPN5clang9BreakStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitBreakStmt(BreakStmt /*P*/ B) {
    // "break" is a control-flow statement.  Thus we stop processing the current
    // block.
    if (badCFG) {
      return null;
    }
    
    // Now create a new block that ends with the break statement.
    Block = createBlock(false);
    Block.setTerminator(new CFGTerminator(B));
    
    // If there is no target for the break, then we are looking at an incomplete
    // AST.  This means that the CFG cannot be constructed.
    if ((BreakJumpTarget.block != null)) {
      addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(BreakJumpTarget.scopePosition), B);
      addSuccessor(Block, BreakJumpTarget.block);
    } else {
      badCFG = true;
    }
    
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1838,
   FQN="(anonymous namespace)::CFGBuilder::VisitCallExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder13VisitCallExprEPN5clang8CallExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder13VisitCallExprEPN5clang8CallExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCallExpr(CallExpr /*P*/ C, AddStmtChoice asc) {
    // Compute the callee type.
    QualType calleeType = C.getCallee().getType();
    if (QualType.$eq_QualType$C(calleeType, Context.BoundMemberTy.$QualType())) {
      QualType boundType = Expr.findBoundMemberType(C.getCallee());
      
      // We should only get a null bound type if processing a dependent
      // CFG.  Recover by assuming nothing.
      if (!boundType.isNull()) {
        calleeType.$assign(boundType);
      }
    }
    
    // If this is a call to a no-return function, this stops the block here.
    boolean NoReturn = getFunctionExtInfo(calleeType.$star()).getNoReturn();
    
    boolean AddEHEdge = false;
    
    // Languages without exceptions are assumed to not throw.
    if (Context.getLangOpts().Exceptions) {
      if (BuildOpts.AddEHEdges) {
        AddEHEdge = true;
      }
    }
    
    // If this is a call to a builtin function, it might not actually evaluate
    // its arguments. Don't add them to the CFG if this is the case.
    boolean OmitArguments = false;
    {
      
      FunctionDecl /*P*/ FD = C.getDirectCallee();
      if ((FD != null)) {
        if (FD.isNoReturn()) {
          NoReturn = true;
        }
        if (FD.hasAttr(NoThrowAttr.class)) {
          AddEHEdge = false;
        }
        if (FD.getBuiltinID() == Builtin.ID.BI__builtin_object_size.getValue()) {
          OmitArguments = true;
        }
      }
    }
    if (!CanThrow(C.getCallee(), $Deref(Context))) {
      AddEHEdge = false;
    }
    if (OmitArguments) {
      assert (!NoReturn) : "noreturn calls with unevaluated args not implemented";
      assert (!AddEHEdge) : "EH calls with unevaluated args not implemented";
      autoCreateBlock();
      appendStmt(Block, C);
      return Visit(C.getCallee());
    }
    if (!NoReturn && !AddEHEdge) {
      return VisitStmt(C, asc.withAlwaysAdd(true));
    }
    if ((Block != null)) {
      Succ = Block;
      if (badCFG) {
        return null;
      }
    }
    if (NoReturn) {
      Block = createNoReturnBlock();
    } else {
      Block = createBlock();
    }
    
    appendStmt(Block, C);
    if (AddEHEdge) {
      // Add exceptional edges.
      if ((TryTerminatedBlock != null)) {
        addSuccessor(Block, TryTerminatedBlock);
      } else {
        addSuccessor(Block, $AddrOf(cfg.$arrow().getExit()));
      }
    }
    
    return VisitChildren(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCaseStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3217,
   FQN="(anonymous namespace)::CFGBuilder::VisitCaseStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder13VisitCaseStmtEPN5clang8CaseStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder13VisitCaseStmtEPN5clang8CaseStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCaseStmt(CaseStmt /*P*/ CS) {
    // CaseStmts are essentially labels, so they are the first statement in a
    // block.
    CFGBlock /*P*/ TopBlock = null;
    CFGBlock /*P*/ LastBlock = null;
    {
      
      Stmt /*P*/ Sub = CS.getSubStmt();
      if ((Sub != null)) {
        // For deeply nested chains of CaseStmts, instead of doing a recursion
        // (which can blow out the stack), manually unroll and create blocks
        // along the way.
        while (isa_CaseStmt(Sub)) {
          CFGBlock /*P*/ currentBlock = createBlock(false);
          currentBlock.setLabel(CS);
          if ((TopBlock != null)) {
            addSuccessor(LastBlock, currentBlock);
          } else {
            TopBlock = currentBlock;
          }
          
          addSuccessor(SwitchTerminatedBlock, 
              shouldAddCase(switchExclusivelyCovered$ref, switchCond, 
                  CS, $Deref(Context)) ? currentBlock : (CFGBlock /*P*/ )null);
          
          LastBlock = currentBlock;
          CS = cast_CaseStmt(Sub);
          Sub = CS.getSubStmt();
        }
        
        addStmt(Sub);
      }
    }
    
    CFGBlock /*P*/ CaseBlock = Block;
    if (!(CaseBlock != null)) {
      CaseBlock = createBlock();
    }
    
    // Cases statements partition blocks, so this is the top of the basic block we
    // were processing (the "case XXX:" is the label).
    CaseBlock.setLabel(CS);
    if (badCFG) {
      return null;
    }
    
    // Add this block to the list of successors for the block with the switch
    // statement.
    assert Native.$bool(SwitchTerminatedBlock);
    addSuccessor(SwitchTerminatedBlock, CaseBlock, 
        shouldAddCase(switchExclusivelyCovered$ref, switchCond, 
            CS, $Deref(Context)));
    
    // We set Block to NULL to allow lazy creation of a new block (if necessary)
    Block = null;
    if ((TopBlock != null)) {
      addSuccessor(LastBlock, CaseBlock);
      Succ = TopBlock;
    } else {
      // This block is now the implicit successor of other blocks.
      Succ = CaseBlock;
    }
    
    return Succ;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1912,
   FQN="(anonymous namespace)::CFGBuilder::VisitChooseExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder15VisitChooseExprEPN5clang10ChooseExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15VisitChooseExprEPN5clang10ChooseExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitChooseExpr(ChooseExpr /*P*/ C, 
                 AddStmtChoice asc) {
    CFGBlock /*P*/ ConfluenceBlock = (Block != null) ? Block : createBlock();
    appendStmt(ConfluenceBlock, C);
    if (badCFG) {
      return null;
    }
    
    AddStmtChoice alwaysAdd = asc.withAlwaysAdd(true);
    Succ = ConfluenceBlock;
    Block = null;
    CFGBlock /*P*/ LHSBlock = Visit(C.getLHS(), new AddStmtChoice(alwaysAdd));
    if (badCFG) {
      return null;
    }
    
    Succ = ConfluenceBlock;
    Block = null;
    CFGBlock /*P*/ RHSBlock = Visit(C.getRHS(), new AddStmtChoice(alwaysAdd));
    if (badCFG) {
      return null;
    }
    
    Block = createBlock(false);
    // See if this is a known constant.
    final /*const*/ TryResult /*&*/ KnownVal = tryEvaluateBool(C.getCond());
    addSuccessor(Block, KnownVal.isFalse() ? (CFGBlock /*P*/ )null : LHSBlock);
    addSuccessor(Block, KnownVal.isTrue() ? (CFGBlock /*P*/ )null : RHSBlock);
    Block.setTerminator(new CFGTerminator(C));
    return addStmt(C.getCond());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1942,
   FQN="(anonymous namespace)::CFGBuilder::VisitCompoundStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder17VisitCompoundStmtEPN5clang12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder17VisitCompoundStmtEPN5clang12CompoundStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCompoundStmt(CompoundStmt /*P*/ C) {
    LocalScope.const_iterator scopeBeginPos = new LocalScope.const_iterator(ScopePos);
    if (BuildOpts.AddImplicitDtors) {
      addLocalScopeForStmt(C);
    }
    if (!C.body_empty() && !isa_ReturnStmt(C.body_rbegin().$star())) {
      // If the body ends with a ReturnStmt, the dtors will be added in
      // VisitReturnStmt.
      addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(scopeBeginPos), C);
    }
    
    CFGBlock /*P*/ LastBlock = Block;
    
    for (std.reverse_iterator<Stmt /*P*/ > I = C.body_rbegin(), E = C.body_rend();
         $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      {
        // If we hit a segment of code just containing ';' (NullStmts), we can
        // get a null block back.  In such cases, just use the LastBlock
        CFGBlock /*P*/ newBlock = addStmt(I.$star());
        if ((newBlock != null)) {
          LastBlock = newBlock;
        }
      }
      if (badCFG) {
        return null;
      }
    }
    
    return LastBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1969,
   FQN="(anonymous namespace)::CFGBuilder::VisitConditionalOperator", NM="_ZN12_GLOBAL__N_110CFGBuilder24VisitConditionalOperatorEPN5clang27AbstractConditionalOperatorENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder24VisitConditionalOperatorEPN5clang27AbstractConditionalOperatorENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitConditionalOperator(AbstractConditionalOperator /*P*/ C, 
                          AddStmtChoice asc) {
    /*const*/ BinaryConditionalOperator /*P*/ BCO = dyn_cast_BinaryConditionalOperator(C);
    /*const*/ OpaqueValueExpr /*P*/ opaqueValue = ((BCO != null) ? BCO.getOpaqueValue() : null);
    
    // Create the confluence block that will "merge" the results of the ternary
    // expression.
    CFGBlock /*P*/ ConfluenceBlock = (Block != null) ? Block : createBlock();
    appendStmt(ConfluenceBlock, C);
    if (badCFG) {
      return null;
    }
    
    AddStmtChoice alwaysAdd = asc.withAlwaysAdd(true);
    
    // Create a block for the LHS expression if there is an LHS expression.  A
    // GCC extension allows LHS to be NULL, causing the condition to be the
    // value that is returned instead.
    //  e.g: x ?: y is shorthand for: x ? x : y;
    Succ = ConfluenceBlock;
    Block = null;
    CFGBlock /*P*/ LHSBlock = null;
    /*const*/ Expr /*P*/ trueExpr = C.getTrueExpr();
    if (trueExpr != opaqueValue) {
      LHSBlock = Visit(C.getTrueExpr(), new AddStmtChoice(alwaysAdd));
      if (badCFG) {
        return null;
      }
      Block = null;
    } else {
      LHSBlock = ConfluenceBlock;
    }
    
    // Create the block for the RHS expression.
    Succ = ConfluenceBlock;
    CFGBlock /*P*/ RHSBlock = Visit(C.getFalseExpr(), new AddStmtChoice(alwaysAdd));
    if (badCFG) {
      return null;
    }
    {
      
      // If the condition is a logical '&&' or '||', build a more accurate CFG.
      BinaryOperator /*P*/ Cond = dyn_cast_BinaryOperator(C.getCond().IgnoreParens());
      if ((Cond != null)) {
        if (Cond.isLogicalOp()) {
          return VisitLogicalOperator(Cond, C, LHSBlock, RHSBlock).first;
        }
      }
    }
    
    // Create the block that will contain the condition.
    Block = createBlock(false);
    
    // See if this is a known constant.
    final /*const*/ TryResult /*&*/ KnownVal = tryEvaluateBool(C.getCond());
    addSuccessor(Block, LHSBlock, !KnownVal.isFalse());
    addSuccessor(Block, RHSBlock, !KnownVal.isTrue());
    Block.setTerminator(new CFGTerminator(C));
    Expr /*P*/ condExpr = C.getCond();
    if ((opaqueValue != null)) {
      // Run the condition expression if it's not trivially expressed in
      // terms of the opaque value (or if there is no opaque value).
      if (condExpr != opaqueValue) {
        addStmt(condExpr);
      }
      
      // Before that, run the common subexpression if there was one.
      // At least one of this or the above will be run.
      return addStmt(BCO.getCommon());
    }
    
    return addStmt(condExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3017,
   FQN="(anonymous namespace)::CFGBuilder::VisitContinueStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder17VisitContinueStmtEPN5clang12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder17VisitContinueStmtEPN5clang12ContinueStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitContinueStmt(ContinueStmt /*P*/ C) {
    // "continue" is a control-flow statement.  Thus we stop processing the
    // current block.
    if (badCFG) {
      return null;
    }
    
    // Now create a new block that ends with the continue statement.
    Block = createBlock(false);
    Block.setTerminator(new CFGTerminator(C));
    
    // If there is no target for the continue, then we are looking at an
    // incomplete AST.  This means the CFG cannot be constructed.
    if ((ContinueJumpTarget.block != null)) {
      addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(ContinueJumpTarget.scopePosition), C);
      addSuccessor(Block, ContinueJumpTarget.block);
    } else {
      badCFG = true;
    }
    
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3543,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXBindTemporaryExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder25VisitCXXBindTemporaryExprEPN5clang20CXXBindTemporaryExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder25VisitCXXBindTemporaryExprEPN5clang20CXXBindTemporaryExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXBindTemporaryExpr(CXXBindTemporaryExpr /*P*/ E, 
                           AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, E)) {
      autoCreateBlock();
      appendStmt(Block, E);
      
      // We do not want to propagate the AlwaysAdd property.
      asc.$assignMove(asc.withAlwaysAdd(false));
    }
    return Visit(E.getSubExpr(), new AddStmtChoice(asc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3364,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXCatchStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder17VisitCXXCatchStmtEPN5clang12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder17VisitCXXCatchStmtEPN5clang12CXXCatchStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXCatchStmt(CXXCatchStmt /*P*/ CS) {
    SaveAndRestore<LocalScope.const_iterator> save_scope_pos = null;
    try {
      // CXXCatchStmt are treated like labels, so they are the first statement in a
      // block.
      
      // Save local scope position because in case of exception variable ScopePos
      // won't be restored when traversing AST.
      save_scope_pos/*J*/= new SaveAndRestore<LocalScope.const_iterator>(ScopePos$ref, false);
      {
        
        // Create local scope for possible exception variable.
        // Store scope position. Add implicit destructor.
        VarDecl /*P*/ VD = CS.getExceptionDecl();
        if ((VD != null)) {
          LocalScope.const_iterator BeginScopePos = new LocalScope.const_iterator(ScopePos);
          addLocalScopeForVarDecl(VD);
          addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(BeginScopePos), CS);
        }
      }
      if ((CS.getHandlerBlock() != null)) {
        addStmt(CS.getHandlerBlock());
      }
      
      CFGBlock /*P*/ CatchBlock = Block;
      if (!(CatchBlock != null)) {
        CatchBlock = createBlock();
      }
      
      // CXXCatchStmt is more than just a label.  They have semantic meaning
      // as well, as they implicitly "initialize" the catch variable.  Add
      // it to the CFG as a CFGElement so that the control-flow of these
      // semantics gets captured.
      appendStmt(CatchBlock, CS);
      
      // Also add the CXXCatchStmt as a label, to mirror handling of regular
      // labels.
      CatchBlock.setLabel(CS);
      
      // Bail out if the CFG is bad.
      if (badCFG) {
        return null;
      }
      
      // We set Block to NULL to allow lazy creation of a new block (if necessary)
      Block = null;
      
      return CatchBlock;
    } finally {
      if (save_scope_pos != null) { save_scope_pos.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3555,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder21VisitCXXConstructExprEPN5clang16CXXConstructExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder21VisitCXXConstructExprEPN5clang16CXXConstructExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXConstructExpr(CXXConstructExpr /*P*/ C, 
                       AddStmtChoice asc) {
    autoCreateBlock();
    appendStmt(Block, C);
    
    return VisitChildren(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3563,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXNewExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder15VisitCXXNewExprEPN5clang10CXXNewExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15VisitCXXNewExprEPN5clang10CXXNewExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXNewExpr(CXXNewExpr /*P*/ NE, 
                 AddStmtChoice asc) {
    
    autoCreateBlock();
    appendStmt(Block, NE);
    if ((NE.getInitializer() != null)) {
      Block = Visit(NE.getInitializer());
    }
    if (BuildOpts.AddCXXNewAllocator) {
      appendNewAllocator(Block, NE);
    }
    if (NE.isArray()) {
      Block = Visit(NE.getArraySize());
    }
    for (Stmt.ExprIterator I = NE.placement_arg_begin(), 
        E = NE.placement_arg_end(); I.$noteq(E); I.$preInc())  {
      Block = Visit(I.$star());
    }
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3581,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXDeleteExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder18VisitCXXDeleteExprEPN5clang13CXXDeleteExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder18VisitCXXDeleteExprEPN5clang13CXXDeleteExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXDeleteExpr(CXXDeleteExpr /*P*/ DE, 
                    AddStmtChoice asc) {
    autoCreateBlock();
    appendStmt(Block, DE);
    QualType DTy = DE.getDestroyedType();
    DTy.$assignMove(DTy.getNonReferenceType());
    CXXRecordDecl /*P*/ RD = Context.getBaseElementType(new QualType(DTy)).$arrow().getAsCXXRecordDecl();
    if ((RD != null)) {
      if (RD.isCompleteDefinition() && !RD.hasTrivialDestructor()) {
        appendDeleteDtor(Block, RD, DE);
      }
    }
    
    return VisitChildren(DE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3407,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXForRangeStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder20VisitCXXForRangeStmtEPN5clang15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder20VisitCXXForRangeStmtEPN5clang15CXXForRangeStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXForRangeStmt(CXXForRangeStmt /*P*/ S) {
    SaveAndRestore<LocalScope.const_iterator> save_scope_pos = null;
    SaveAndRestore<BlockScopePosPair> save_break = null;
    try {
      // C++0x for-range statements are specified as [stmt.ranged]:
      //
      // {
      //   auto && __range = range-init;
      //   for ( auto __begin = begin-expr,
      //         __end = end-expr;
      //         __begin != __end;
      //         ++__begin ) {
      //     for-range-declaration = *__begin;
      //     statement
      //   }
      // }
      
      // Save local scope position before the addition of the implicit variables.
      save_scope_pos/*J*/= new SaveAndRestore<LocalScope.const_iterator>(ScopePos$ref, false);
      {
        
        // Create local scopes and destructors for range, begin and end variables.
        Stmt /*P*/ Range = S.getRangeStmt();
        if ((Range != null)) {
          addLocalScopeForStmt(Range);
        }
      }
      {
        Stmt /*P*/ Begin = S.getBeginStmt();
        if ((Begin != null)) {
          addLocalScopeForStmt(Begin);
        }
      }
      {
        Stmt /*P*/ End = S.getEndStmt();
        if ((End != null)) {
          addLocalScopeForStmt(End);
        }
      }
      addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), save_scope_pos.get(), S);
      
      LocalScope.const_iterator ContinueScopePos = new LocalScope.const_iterator(ScopePos);
      
      // "for" is a control-flow statement.  Thus we stop processing the current
      // block.
      CFGBlock /*P*/ LoopSuccessor = null;
      if ((Block != null)) {
        if (badCFG) {
          return null;
        }
        LoopSuccessor = Block;
      } else {
        LoopSuccessor = Succ;
      }
      
      // Save the current value for the break targets.
      // All breaks should go to the code following the loop.
      save_break/*J*/= new SaveAndRestore<BlockScopePosPair>(BreakJumpTarget$ref, false);
      BreakJumpTarget.$assignMove(new BlockScopePosPair(LoopSuccessor, new LocalScope.const_iterator(ScopePos)));
      
      // The block for the __begin != __end expression.
      CFGBlock /*P*/ ConditionBlock = createBlock(false);
      ConditionBlock.setTerminator(new CFGTerminator(S));
      {
        
        // Now add the actual condition to the condition block.
        Expr /*P*/ C = S.getCond();
        if ((C != null)) {
          Block = ConditionBlock;
          CFGBlock /*P*/ BeginConditionBlock = addStmt(C);
          if (badCFG) {
            return null;
          }
          assert (BeginConditionBlock == ConditionBlock) : "condition block in for-range was unexpectedly complex";
          ///*J:(void)*/BeginConditionBlock;
        }
      }
      
      // The condition block is the implicit successor for the loop body as well as
      // any code above the loop.
      Succ = ConditionBlock;
      
      // See if this is a known constant.
      TryResult KnownVal/*J*/= new TryResult(true);
      if ((S.getCond() != null)) {
        KnownVal.$assignMove(tryEvaluateBool(S.getCond()));
      }
      {
        SaveAndRestore<CFGBlock /*P*/ > save_Block = null;
        SaveAndRestore<CFGBlock /*P*/ > save_Succ = null;
        SaveAndRestore<BlockScopePosPair> save_continue = null;
        try {
          assert Native.$bool(S.getBody());
          
          // Save the current values for Block, Succ, and continue targets.
          save_Block/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Block$ref, true);
          save_Succ/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Succ$ref, true);
          save_continue/*J*/= new SaveAndRestore<BlockScopePosPair>(ContinueJumpTarget$ref, false);
          
          // Generate increment code in its own basic block.  This is the target of
          // continue statements.
          Block = null;
          Succ = addStmt(S.getInc());
          if (badCFG) {
            return null;
          }
          ContinueJumpTarget.$assignMove(new BlockScopePosPair(Succ, new LocalScope.const_iterator(ContinueScopePos)));
          
          // The starting block for the loop increment is the block that should
          // represent the 'loop target' for looping back to the start of the loop.
          ContinueJumpTarget.block.setLoopTarget(S);
          
          // Finish up the increment block and prepare to start the loop body.
          assert Native.$bool(Block);
          if (badCFG) {
            return null;
          }
          Block = null;
          
          // Add implicit scope and dtors for loop variable.
          addLocalScopeAndDtors(S.getLoopVarStmt());
          
          // Populate a new block to contain the loop body and loop variable.
          addStmt(S.getBody());
          if (badCFG) {
            return null;
          }
          CFGBlock /*P*/ LoopVarStmtBlock = addStmt(S.getLoopVarStmt());
          if (badCFG) {
            return null;
          }
          
          // This new body block is a successor to our condition block.
          addSuccessor(ConditionBlock, 
              KnownVal.isFalse() ? (CFGBlock /*P*/ )null : LoopVarStmtBlock);
        } finally {
          if (save_continue != null) { save_continue.$destroy(); }
          if (save_Succ != null) { save_Succ.$destroy(); }
          if (save_Block != null) { save_Block.$destroy(); }
        }
      }
      
      // Link up the condition block with the code that follows the loop (the
      // false branch).
      addSuccessor(ConditionBlock, KnownVal.isTrue() ? (CFGBlock /*P*/ )null : LoopSuccessor);
      
      // Add the initialization statements.
      Block = createBlock();
      addStmt(S.getBeginStmt());
      addStmt(S.getEndStmt());
      return addStmt(S.getRangeStmt());
    } finally {
      if (save_break != null) { save_break.$destroy(); }
      if (save_scope_pos != null) { save_scope_pos.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3596,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXFunctionalCastExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder26VisitCXXFunctionalCastExprEPN5clang21CXXFunctionalCastExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder26VisitCXXFunctionalCastExprEPN5clang21CXXFunctionalCastExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXFunctionalCastExpr(CXXFunctionalCastExpr /*P*/ E, 
                            AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, E)) {
      autoCreateBlock();
      appendStmt(Block, E);
      // We do not want to propagate the AlwaysAdd property.
      asc.$assignMove(asc.withAlwaysAdd(false));
    }
    return Visit(E.getSubExpr(), new AddStmtChoice(asc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3607,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXTemporaryObjectExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder27VisitCXXTemporaryObjectExprEPN5clang22CXXTemporaryObjectExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder27VisitCXXTemporaryObjectExprEPN5clang22CXXTemporaryObjectExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXTemporaryObjectExpr(CXXTemporaryObjectExpr /*P*/ C, 
                             AddStmtChoice asc) {
    autoCreateBlock();
    appendStmt(Block, C);
    return VisitChildren(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2894,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXThrowExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder17VisitCXXThrowExprEPN5clang12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder17VisitCXXThrowExprEPN5clang12CXXThrowExprE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXThrowExpr(CXXThrowExpr /*P*/ T) {
    // If we were in the middle of a block we stop processing that block.
    if (badCFG) {
      return null;
    }
    
    // Create the new block.
    Block = createBlock(false);
    if ((TryTerminatedBlock != null)) {
      // The current try statement is the only successor.
      addSuccessor(Block, TryTerminatedBlock);
    } else {
      // otherwise the Exit block is the only successor.
      addSuccessor(Block, $AddrOf(cfg.$arrow().getExit()));
    }
    
    // Add the statement to the block.  This may create new blocks if S contains
    // control-flow (short-circuit operations).
    return VisitStmt(T, new AddStmtChoice(AddStmtChoice.Kind.AlwaysAdd));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3311,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXTryStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder15VisitCXXTryStmtEPN5clang10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15VisitCXXTryStmtEPN5clang10CXXTryStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXTryStmt(CXXTryStmt /*P*/ Terminator) {
    SaveAndRestore<CFGBlock /*P*/ > save_try = null;
    try {
      // "try"/"catch" is a control-flow statement.  Thus we stop processing the
      // current block.
      CFGBlock /*P*/ TrySuccessor = null;
      if ((Block != null)) {
        if (badCFG) {
          return null;
        }
        TrySuccessor = Block;
      } else {
        TrySuccessor = Succ;
      }
      
      CFGBlock /*P*/ PrevTryTerminatedBlock = TryTerminatedBlock;
      
      // Create a new block that will contain the try statement.
      CFGBlock /*P*/ NewTryTerminatedBlock = createBlock(false);
      // Add the terminator in the try block.
      NewTryTerminatedBlock.setTerminator(new CFGTerminator(Terminator));
      
      boolean HasCatchAll = false;
      for (/*uint*/int h = 0; $less_uint(h, Terminator.getNumHandlers()); ++h) {
        // The code after the try is the implicit successor.
        Succ = TrySuccessor;
        CXXCatchStmt /*P*/ CS = Terminator.getHandler(h);
        if (CS.getExceptionDecl() == null) {
          HasCatchAll = true;
        }
        Block = null;
        CFGBlock /*P*/ CatchBlock = VisitCXXCatchStmt(CS);
        if (!(CatchBlock != null)) {
          return null;
        }
        // Add this block to the list of successors for the block with the try
        // statement.
        addSuccessor(NewTryTerminatedBlock, CatchBlock);
      }
      if (!HasCatchAll) {
        if ((PrevTryTerminatedBlock != null)) {
          addSuccessor(NewTryTerminatedBlock, PrevTryTerminatedBlock);
        } else {
          addSuccessor(NewTryTerminatedBlock, $AddrOf(cfg.$arrow().getExit()));
        }
      }
      
      // The code after the try is the implicit successor.
      Succ = TrySuccessor;
      
      // Save the current "try" context.
      save_try/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(TryTerminatedBlock$ref, NewTryTerminatedBlock, true);
      cfg.$arrow().addTryDispatchBlock(TryTerminatedBlock);
      assert ((Terminator.getTryBlock() != null)) : "try must contain a non-NULL body";
      Block = null;
      return addStmt(Terminator.getTryBlock());
    } finally {
      if (save_try != null) { save_try.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitDeclStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2036,
   FQN="(anonymous namespace)::CFGBuilder::VisitDeclStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitDeclStmt(DeclStmt /*P*/ DS) {
    // Check if the Decl is for an __label__.  If so, elide it from the
    // CFG entirely.
    if (isa_LabelDecl(DS.decl_begin().$star())) {
      return Block;
    }
    
    // This case also handles static_asserts.
    if (DS.isSingleDecl()) {
      return VisitDeclSubExpr(DS);
    }
    
    CFGBlock /*P*/ B = null;
    
    // Build an individual DeclStmt for each decl.
    for (std.reverse_iterator<Decl /*P*/ > I = DS.decl_rbegin(), 
        E = DS.decl_rend();
         $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      // Get the alignment of the new DeclStmt, padding out to >=8 bytes.
      /*uint*/int A = $less_uint(AlignOf.<DeclStmt>Unnamed_enum.Alignment$Java, 8) ? 8 : AlignOf.<DeclStmt>Unnamed_enum.Alignment$Java;
      
      // Allocate the DeclStmt using the BumpPtrAllocator.  It will get
      // automatically freed with the CFG.
      DeclGroupRef DG/*J*/= new DeclGroupRef(I.$star());
      Decl /*P*/ D = I.$star();
      Object/*void P*/ Mem = true/*JAVA*/ ? null : cfg.$arrow().getAllocator().Allocate(AstSizeofAndAlignment.$sizeof_DeclStmt(), A);
      DeclStmt /*P*/ DSNew = ((/*JCast*/DeclStmt /*P*/ )(/*NEW_EXPR [Stmt::new]*/Mem = /*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
          return new DeclStmt(new DeclGroupRef(DG), D.getLocation(), GetEndLoc(D));
       })));
      cfg.$arrow().addSyntheticDeclStmt(DSNew, DS);
      
      // Append the fake DeclStmt to block.
      B = VisitDeclSubExpr(DSNew);
    }
    
    return B;
  }

  
  /// VisitDeclSubExpr - Utility method to add block-level expressions for
  /// DeclStmts and initializers in them.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitDeclSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2073,
   FQN="(anonymous namespace)::CFGBuilder::VisitDeclSubExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder16VisitDeclSubExprEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder16VisitDeclSubExprEPN5clang8DeclStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitDeclSubExpr(DeclStmt /*P*/ DS) {
    assert (DS.isSingleDecl()) : "Can handle single declarations only.";
    VarDecl /*P*/ VD = dyn_cast_VarDecl(DS.getSingleDecl());
    if (!(VD != null)) {
      // Of everything that can be declared in a DeclStmt, only VarDecls impact
      // runtime semantics.
      return Block;
    }
    
    boolean HasTemporaries = false;
    
    // Guard static initializers under a branch.
    CFGBlock /*P*/ blockAfterStaticInit = null;
    if (BuildOpts.AddStaticInitBranches && VD.isStaticLocal()) {
      // For static variables, we need to create a branch to track
      // whether or not they are initialized.
      if ((Block != null)) {
        Succ = Block;
        Block = null;
        if (badCFG) {
          return null;
        }
      }
      blockAfterStaticInit = Succ;
    }
    
    // Destructors of temporaries in initialization expression should be called
    // after initialization finishes.
    Expr /*P*/ Init = VD.getInit();
    if ((Init != null)) {
      HasTemporaries = isa_ExprWithCleanups(Init);
      if (BuildOpts.AddTemporaryDtors && HasTemporaries) {
        // Generate destructors for temporaries in initialization expression.
        TempDtorContext Context/*J*/= new TempDtorContext();
        VisitForTemporaryDtors(cast_ExprWithCleanups(Init).getSubExpr(), 
            /*BindToTemporary=*/ false, Context);
      }
    }
    
    autoCreateBlock();
    appendStmt(Block, DS);
    
    // Keep track of the last non-null block, as 'Block' can be nulled out
    // if the initializer expression is something like a 'while' in a
    // statement-expression.
    CFGBlock /*P*/ LastBlock = Block;
    if ((Init != null)) {
      if (HasTemporaries) {
        // For expression with temporaries go directly to subexpression to omit
        // generating destructors for the second time.
        ExprWithCleanups /*P*/ EC = cast_ExprWithCleanups(Init);
        {
          CFGBlock /*P*/ newBlock = Visit(EC.getSubExpr());
          if ((newBlock != null)) {
            LastBlock = newBlock;
          }
        }
      } else {
        {
          CFGBlock /*P*/ newBlock = Visit(Init);
          if ((newBlock != null)) {
            LastBlock = newBlock;
          }
        }
      }
    }
    
    // If the type of VD is a VLA, then we must process its size expressions.
    for (/*const*/ VariableArrayType /*P*/ VA = FindVA(VD.getType().getTypePtr());
         VA != null; VA = FindVA(VA.getElementType().getTypePtr())) {
      {
        CFGBlock /*P*/ newBlock = addStmt(VA.getSizeExpr());
        if ((newBlock != null)) {
          LastBlock = newBlock;
        }
      }
    }
    
    // Remove variable from local scope.
    if (ScopePos.$bool() && VD == ScopePos.$star()) {
      ScopePos.$preInc();
    }
    
    CFGBlock /*P*/ B = LastBlock;
    if ((blockAfterStaticInit != null)) {
      Succ = B;
      Block = createBlock(false);
      Block.setTerminator(new CFGTerminator(DS));
      addSuccessor(Block, blockAfterStaticInit);
      addSuccessor(Block, B);
      B = Block;
    }
    
    return B;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitDefaultStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3280,
   FQN="(anonymous namespace)::CFGBuilder::VisitDefaultStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder16VisitDefaultStmtEPN5clang11DefaultStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder16VisitDefaultStmtEPN5clang11DefaultStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitDefaultStmt(DefaultStmt /*P*/ Terminator) {
    if ((Terminator.getSubStmt() != null)) {
      addStmt(Terminator.getSubStmt());
    }
    
    DefaultCaseBlock = Block;
    if (!(DefaultCaseBlock != null)) {
      DefaultCaseBlock = createBlock();
    }
    
    // Default statements partition blocks, so this is the top of the basic block
    // we were processing (the "default:" is the label).
    DefaultCaseBlock.setLabel(Terminator);
    if (badCFG) {
      return null;
    }
    
    // Unlike case statements, we don't add the default block to the successors
    // for the switch statement immediately.  This is done when we finish
    // processing the switch statement.  This allows for the default case
    // (including a fall-through to the code after the switch statement) to always
    // be the last successor of a switch-terminated block.
    
    // We set Block to NULL to allow lazy creation of a new block (if necessary)
    Block = null;
    
    // This block is now the implicit successor of other blocks.
    Succ = DefaultCaseBlock;
    
    return DefaultCaseBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitDoStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2914,
   FQN="(anonymous namespace)::CFGBuilder::VisitDoStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder11VisitDoStmtEPN5clang6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder11VisitDoStmtEPN5clang6DoStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitDoStmt(DoStmt /*P*/ D) {
    CFGBlock /*P*/ LoopSuccessor = null;
    
    // "do...while" is a control-flow statement.  Thus we stop processing the
    // current block.
    if ((Block != null)) {
      if (badCFG) {
        return null;
      }
      LoopSuccessor = Block;
    } else {
      LoopSuccessor = Succ;
    }
    
    // Because of short-circuit evaluation, the condition of the loop can span
    // multiple basic blocks.  Thus we need the "Entry" and "Exit" blocks that
    // evaluate the condition.
    CFGBlock /*P*/ ExitConditionBlock = createBlock(false);
    CFGBlock /*P*/ EntryConditionBlock = ExitConditionBlock;
    
    // Set the terminator for the "exit" condition block.
    ExitConditionBlock.setTerminator(new CFGTerminator(D));
    {
      
      // Now add the actual condition to the condition block.  Because the condition
      // itself may contain control-flow, new blocks may be created.
      Stmt /*P*/ C = D.getCond();
      if ((C != null)) {
        Block = ExitConditionBlock;
        EntryConditionBlock = addStmt(C);
        if ((Block != null)) {
          if (badCFG) {
            return null;
          }
        }
      }
    }
    
    // The condition block is the implicit successor for the loop body.
    Succ = EntryConditionBlock;
    
    // See if this is a known constant.
    final /*const*/ TryResult /*&*/ KnownVal = tryEvaluateBool(D.getCond());
    
    // Process the loop body.
    CFGBlock /*P*/ BodyBlock = null;
    {
      SaveAndRestore<CFGBlock /*P*/ > save_Block = null;
      SaveAndRestore<CFGBlock /*P*/ > save_Succ = null;
      SaveAndRestore<BlockScopePosPair> save_continue = null;
      SaveAndRestore<BlockScopePosPair> save_break = null;
      try {
        assert Native.$bool(D.getBody());
        
        // Save the current values for Block, Succ, and continue and break targets
        save_Block/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Block$ref, true);
        save_Succ/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Succ$ref, true);
        save_continue/*J*/= new SaveAndRestore<BlockScopePosPair>(ContinueJumpTarget$ref, false);
        save_break/*J*/= new SaveAndRestore<BlockScopePosPair>(BreakJumpTarget$ref, false);
        
        // All continues within this loop should go to the condition block
        ContinueJumpTarget.$assignMove(new BlockScopePosPair(EntryConditionBlock, new LocalScope.const_iterator(ScopePos)));
        
        // All breaks should go to the code following the loop.
        BreakJumpTarget.$assignMove(new BlockScopePosPair(LoopSuccessor, new LocalScope.const_iterator(ScopePos)));
        
        // NULL out Block to force lazy instantiation of blocks for the body.
        Block = null;
        
        // If body is not a compound statement create implicit scope
        // and add destructors.
        if (!isa_CompoundStmt(D.getBody())) {
          addLocalScopeAndDtors(D.getBody());
        }
        
        // Create the body.  The returned block is the entry to the loop body.
        BodyBlock = addStmt(D.getBody());
        if (!(BodyBlock != null)) {
          BodyBlock = EntryConditionBlock; // can happen for "do ; while(...)"
        } else if ((Block != null)) {
          if (badCFG) {
            return null;
          }
        }
        if (!KnownVal.isFalse()) {
          // Add an intermediate block between the BodyBlock and the
          // ExitConditionBlock to represent the "loop back" transition.  Create an
          // empty block to represent the transition block for looping back to the
          // head of the loop.
          // FIXME: Can we do this more efficiently without adding another block?
          Block = null;
          Succ = BodyBlock;
          CFGBlock /*P*/ LoopBackBlock = createBlock();
          LoopBackBlock.setLoopTarget(D);
          
          // Add the loop body entry as a successor to the condition.
          addSuccessor(ExitConditionBlock, LoopBackBlock);
        } else {
          addSuccessor(ExitConditionBlock, (CFGBlock /*P*/ )null);
        }
      } finally {
        if (save_break != null) { save_break.$destroy(); }
        if (save_continue != null) { save_continue.$destroy(); }
        if (save_Succ != null) { save_Succ.$destroy(); }
        if (save_Block != null) { save_Block.$destroy(); }
      }
    }
    
    // Link up the condition block with the code that follows the loop.
    // (the false branch).
    addSuccessor(ExitConditionBlock, KnownVal.isTrue() ? (CFGBlock /*P*/ )null : LoopSuccessor);
    
    // There can be no more statements in the body block(s) since we loop back to
    // the body.  NULL out Block to force lazy creation of another block.
    Block = null;
    
    // Return the loop body, which is the dominating block for the loop.
    Succ = BodyBlock;
    return BodyBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3528,
   FQN="(anonymous namespace)::CFGBuilder::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_110CFGBuilder21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitExprWithCleanups(ExprWithCleanups /*P*/ E, 
                       AddStmtChoice asc) {
    if (BuildOpts.AddTemporaryDtors) {
      // If adding implicit destructors visit the full expression for adding
      // destructors of temporaries.
      TempDtorContext Context/*J*/= new TempDtorContext();
      VisitForTemporaryDtors(E.getSubExpr(), false, Context);
      
      // Full expression has to be added as CFGStmt so it will be sequenced
      // before destructors of it's temporaries.
      asc.$assignMove(asc.withAlwaysAdd(true));
    }
    return Visit(E.getSubExpr(), new AddStmtChoice(asc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitForStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2395,
   FQN="(anonymous namespace)::CFGBuilder::VisitForStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder12VisitForStmtEPN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder12VisitForStmtEPN5clang7ForStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitForStmt(ForStmt /*P*/ F) {
    SaveAndRestore<LocalScope.const_iterator> save_scope_pos = null;
    SaveAndRestore<BlockScopePosPair> save_break = null;
    try {
      CFGBlock /*P*/ LoopSuccessor = null;
      
      // Save local scope position because in case of condition variable ScopePos
      // won't be restored when traversing AST.
      save_scope_pos/*J*/= new SaveAndRestore<LocalScope.const_iterator>(ScopePos$ref, false);
      {
        
        // Create local scope for init statement and possible condition variable.
        // Add destructor for init statement and condition variable.
        // Store scope position for continue statement.
        Stmt /*P*/ Init = F.getInit();
        if ((Init != null)) {
          addLocalScopeForStmt(Init);
        }
      }
      LocalScope.const_iterator LoopBeginScopePos = new LocalScope.const_iterator(ScopePos);
      {
        
        VarDecl /*P*/ VD = F.getConditionVariable();
        if ((VD != null)) {
          addLocalScopeForVarDecl(VD);
        }
      }
      LocalScope.const_iterator ContinueScopePos = new LocalScope.const_iterator(ScopePos);
      
      addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), save_scope_pos.get(), F);
      
      // "for" is a control-flow statement.  Thus we stop processing the current
      // block.
      if ((Block != null)) {
        if (badCFG) {
          return null;
        }
        LoopSuccessor = Block;
      } else {
        LoopSuccessor = Succ;
      }
      
      // Save the current value for the break targets.
      // All breaks should go to the code following the loop.
      save_break/*J*/= new SaveAndRestore<BlockScopePosPair>(BreakJumpTarget$ref, false);
      BreakJumpTarget.$assignMove(new BlockScopePosPair(LoopSuccessor, new LocalScope.const_iterator(ScopePos)));
      
      CFGBlock /*P*/ BodyBlock = null;
      CFGBlock /*P*/ TransitionBlock = null;
      {
        SaveAndRestore<CFGBlock /*P*/ > save_Block = null;
        SaveAndRestore<CFGBlock /*P*/ > save_Succ = null;
        SaveAndRestore<BlockScopePosPair> save_continue = null;
        try {
          assert Native.$bool(F.getBody());
          
          // Save the current values for Block, Succ, continue and break targets.
          save_Block/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Block$ref, true);
          save_Succ/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Succ$ref, true);
          save_continue/*J*/= new SaveAndRestore<BlockScopePosPair>(ContinueJumpTarget$ref, false);
          
          // Create an empty block to represent the transition block for looping back
          // to the head of the loop.  If we have increment code, it will
          // go in this block as well.
          Block = Succ = TransitionBlock = createBlock(false);
          TransitionBlock.setLoopTarget(F);
          {
            
            Stmt /*P*/ I = F.getInc();
            if ((I != null)) {
              // Generate increment code in its own basic block.  This is the target of
              // continue statements.
              Succ = addStmt(I);
            }
          }
          
          // Finish up the increment (or empty) block if it hasn't been already.
          if ((Block != null)) {
            assert (Block == Succ);
            if (badCFG) {
              return null;
            }
            Block = null;
          }
          
          // The starting block for the loop increment is the block that should
          // represent the 'loop target' for looping back to the start of the loop.
          ContinueJumpTarget.$assignMove(new BlockScopePosPair(Succ, new LocalScope.const_iterator(ContinueScopePos)));
          ContinueJumpTarget.block.setLoopTarget(F);
          
          // Loop body should end with destructor of Condition variable (if any).
          addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(LoopBeginScopePos), F);
          
          // If body is not a compound statement create implicit scope
          // and add destructors.
          if (!isa_CompoundStmt(F.getBody())) {
            addLocalScopeAndDtors(F.getBody());
          }
          
          // Now populate the body block, and in the process create new blocks as we
          // walk the body of the loop.
          BodyBlock = addStmt(F.getBody());
          if (!(BodyBlock != null)) {
            // In the case of "for (...;...;...);" we can have a null BodyBlock.
            // Use the continue jump target as the proxy for the body.
            BodyBlock = ContinueJumpTarget.block;
          } else if (badCFG) {
            return null;
          }
        } finally {
          if (save_continue != null) { save_continue.$destroy(); }
          if (save_Succ != null) { save_Succ.$destroy(); }
          if (save_Block != null) { save_Block.$destroy(); }
        }
      }
      
      // Because of short-circuit evaluation, the condition of the loop can span
      // multiple basic blocks.  Thus we need the "Entry" and "Exit" blocks that
      // evaluate the condition.
      CFGBlock /*P*/ EntryConditionBlock = null;
      CFGBlock /*P*/ ExitConditionBlock = null;
      
      do {
        Expr /*P*/ C = F.getCond();
        {
          
          // Specially handle logical operators, which have a slightly
          // more optimal CFG representation.
          BinaryOperator /*P*/ Cond = dyn_cast_or_null_BinaryOperator((C != null) ? C.IgnoreParens() : null);
          if ((Cond != null)) {
            if (Cond.isLogicalOp()) {
              // JAVA: unfold std.tie
              std.pair<CFGBlock/*P*/, CFGBlock/*P*/> $pair = VisitLogicalOperator(Cond, F, BodyBlock, LoopSuccessor);
              EntryConditionBlock = $pair.first;
              ExitConditionBlock = $pair.second;
//              std.tie(EntryConditionBlock, ExitConditionBlock).$assign(
//                  VisitLogicalOperator(Cond, F, BodyBlock, LoopSuccessor)
//              );
              break;
            }
          }
        }
        
        // The default case when not handling logical operators.
        EntryConditionBlock = ExitConditionBlock = createBlock(false);
        ExitConditionBlock.setTerminator(new CFGTerminator(F));
        
        // See if this is a known constant.
        TryResult KnownVal/*J*/= new TryResult(true);
        if ((C != null)) {
          // Now add the actual condition to the condition block.
          // Because the condition itself may contain control-flow, new blocks may
          // be created.  Thus we update "Succ" after adding the condition.
          Block = ExitConditionBlock;
          EntryConditionBlock = addStmt(C);
          {
            
            // If this block contains a condition variable, add both the condition
            // variable and initializer to the CFG.
            VarDecl /*P*/ VD = F.getConditionVariable();
            if ((VD != null)) {
              {
                Expr /*P*/ Init = VD.getInit();
                if ((Init != null)) {
                  autoCreateBlock();
                  appendStmt(Block, F.getConditionVariableDeclStmt());
                  EntryConditionBlock = addStmt(Init);
                  assert (Block == EntryConditionBlock);
                }
              }
            }
          }
          if ((Block != null) && badCFG) {
            return null;
          }
          
          KnownVal.$assignMove(tryEvaluateBool(C));
        }
        
        // Add the loop body entry as a successor to the condition.
        addSuccessor(ExitConditionBlock, KnownVal.isFalse() ? (CFGBlock /*P*/ )null : BodyBlock);
        // Link up the condition block with the code that follows the loop.  (the
        // false branch).
        addSuccessor(ExitConditionBlock, 
            KnownVal.isTrue() ? (CFGBlock /*P*/ )null : LoopSuccessor);
      } while (false);
      
      // Link up the loop-back block to the entry condition block.
      addSuccessor(TransitionBlock, EntryConditionBlock);
      
      // The condition block is the implicit successor for any code above the loop.
      Succ = EntryConditionBlock;
      {
        
        // If the loop contains initialization, create a new block for those
        // statements.  This block can also contain statements that precede the loop.
        Stmt /*P*/ I = F.getInit();
        if ((I != null)) {
          Block = createBlock();
          return addStmt(I);
        }
      }
      
      // There is no loop initialization.  We are thus basically a while loop.
      // NULL out Block to force lazy block construction.
      Block = null;
      Succ = EntryConditionBlock;
      return EntryConditionBlock;
    } finally {
      if (save_break != null) { save_break.$destroy(); }
      if (save_scope_pos != null) { save_scope_pos.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2373,
   FQN="(anonymous namespace)::CFGBuilder::VisitGotoStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder13VisitGotoStmtEPN5clang8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder13VisitGotoStmtEPN5clang8GotoStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitGotoStmt(GotoStmt /*P*/ G) {
    // Goto is a control-flow statement.  Thus we stop processing the current
    // block and create a new one.
    Block = createBlock(false);
    Block.setTerminator(new CFGTerminator(G));
    
    // If we already know the mapping to the label block add the successor now.
    DenseMapIterator<LabelDecl /*P*/ , BlockScopePosPair> I = LabelMap.find(G.getLabel());
    if (I.$eq(/*NO_ITER_COPY*/LabelMap.end())) {
      // We will need to backpatch this block later.
      BackpatchBlocks.push_back_T$RR(new BlockScopePosPair(Block, new LocalScope.const_iterator(ScopePos)));
    } else {
      BlockScopePosPair JT = new BlockScopePosPair(I.$arrow().second);
      addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(JT.scopePosition), G);
      addSuccessor(Block, JT.block);
    }
    
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitIfStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2160,
   FQN="(anonymous namespace)::CFGBuilder::VisitIfStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder11VisitIfStmtEPN5clang6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder11VisitIfStmtEPN5clang6IfStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitIfStmt(IfStmt /*P*/ I) {
    SaveAndRestore<LocalScope.const_iterator> save_scope_pos = null;
    try {
      // We may see an if statement in the middle of a basic block, or it may be the
      // first statement we are processing.  In either case, we create a new basic
      // block.  First, we create the blocks for the then...else statements, and
      // then we create the block containing the if statement.  If we were in the
      // middle of a block, we stop processing that block.  That block is then the
      // implicit successor for the "then" and "else" clauses.
      
      // Save local scope position because in case of condition variable ScopePos
      // won't be restored when traversing AST.
      save_scope_pos/*J*/= new SaveAndRestore<LocalScope.const_iterator>(ScopePos$ref, false);
      {
        
        // Create local scope for C++17 if init-stmt if one exists.
        Stmt /*P*/ Init = I.getInit();
        if ((Init != null)) {
          LocalScope.const_iterator BeginScopePos = new LocalScope.const_iterator(ScopePos);
          addLocalScopeForStmt(Init);
          addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(BeginScopePos), I);
        }
      }
      {
        
        // Create local scope for possible condition variable.
        // Store scope position. Add implicit destructor.
        VarDecl /*P*/ VD = I.getConditionVariable();
        if ((VD != null)) {
          LocalScope.const_iterator BeginScopePos = new LocalScope.const_iterator(ScopePos);
          addLocalScopeForVarDecl(VD);
          addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(BeginScopePos), I);
        }
      }
      
      // The block we were processing is now finished.  Make it the successor
      // block.
      if ((Block != null)) {
        Succ = Block;
        if (badCFG) {
          return null;
        }
      }
      
      // Process the false branch.
      CFGBlock /*P*/ ElseBlock = Succ;
      {
        
        Stmt /*P*/ Else = I.getElse();
        if ((Else != null)) {
          SaveAndRestore<CFGBlock /*P*/ > sv = null;
          try {
            sv/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Succ$ref, true);
            
            // NULL out Block so that the recursive call to Visit will
            // create a new basic block.
            Block = null;
            
            // If branch is not a compound statement create implicit scope
            // and add destructors.
            if (!isa_CompoundStmt(Else)) {
              addLocalScopeAndDtors(Else);
            }
            
            ElseBlock = addStmt(Else);
            if (!(ElseBlock != null)) { // Can occur when the Else body has all NullStmts.
              ElseBlock = sv.get();
            } else if ((Block != null)) {
              if (badCFG) {
                return null;
              }
            }
          } finally {
            if (sv != null) { sv.$destroy(); }
          }
        }
      }
      
      // Process the true branch.
      CFGBlock /*P*/ ThenBlock;
      {
        SaveAndRestore<CFGBlock /*P*/ > sv = null;
        try {
          Stmt /*P*/ Then = I.getThen();
          assert Native.$bool(Then);
          sv/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Succ$ref, true);
          Block = null;
          
          // If branch is not a compound statement create implicit scope
          // and add destructors.
          if (!isa_CompoundStmt(Then)) {
            addLocalScopeAndDtors(Then);
          }
          
          ThenBlock = addStmt(Then);
          if (!(ThenBlock != null)) {
            // We can reach here if the "then" body has all NullStmts.
            // Create an empty block so we can distinguish between true and false
            // branches in path-sensitive analyses.
            ThenBlock = createBlock(false);
            addSuccessor(ThenBlock, sv.get());
          } else if ((Block != null)) {
            if (badCFG) {
              return null;
            }
          }
        } finally {
          if (sv != null) { sv.$destroy(); }
        }
      }
      
      // Specially handle "if (expr1 || ...)" and "if (expr1 && ...)" by
      // having these handle the actual control-flow jump.  Note that
      // if we introduce a condition variable, e.g. "if (int x = exp1 || exp2)"
      // we resort to the old control-flow behavior.  This special handling
      // removes infeasible paths from the control-flow graph by having the
      // control-flow transfer of '&&' or '||' go directly into the then/else
      // blocks directly.
      if (!(I.getConditionVariable() != null)) {
        {
          BinaryOperator /*P*/ Cond = dyn_cast_BinaryOperator(I.getCond().IgnoreParens());
          if ((Cond != null)) {
            if (Cond.isLogicalOp()) {
              return VisitLogicalOperator(Cond, I, ThenBlock, ElseBlock).first;
            }
          }
        }
      }
      
      // Now create a new block containing the if statement.
      Block = createBlock(false);
      
      // Set the terminator of the new block to the If statement.
      Block.setTerminator(new CFGTerminator(I));
      
      // See if this is a known constant.
      final /*const*/ TryResult /*&*/ KnownVal = tryEvaluateBool(I.getCond());
      
      // Add the successors.  If we know that specific branches are
      // unreachable, inform addSuccessor() of that knowledge.
      addSuccessor(Block, ThenBlock, /* isReachable = */ !KnownVal.isFalse());
      addSuccessor(Block, ElseBlock, /* isReachable = */ !KnownVal.isTrue());
      
      // Add the condition as the last statement in the new block.  This may create
      // new blocks as the condition may contain control-flow.  Any newly created
      // blocks will be pointed to be "Block".
      CFGBlock /*P*/ LastBlock = addStmt(I.getCond());
      {
        
        // If the IfStmt contains a condition variable, add it and its
        // initializer to the CFG.
        /*const*/ DeclStmt /*P*/ DS = I.getConditionVariableDeclStmt();
        if ((DS != null)) {
          autoCreateBlock();
          LastBlock = addStmt(((/*const_cast*/DeclStmt /*P*/ )(DS)));
        }
      }
      {
        
        // Finally, if the IfStmt contains a C++17 init-stmt, add it to the CFG.
        Stmt /*P*/ Init = I.getInit();
        if ((Init != null)) {
          autoCreateBlock();
          LastBlock = addStmt(Init);
        }
      }
      
      return LastBlock;
    } finally {
      if (save_scope_pos != null) { save_scope_pos.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3614,
   FQN="(anonymous namespace)::CFGBuilder::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder21VisitImplicitCastExprEPN5clang16ImplicitCastExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder21VisitImplicitCastExprEPN5clang16ImplicitCastExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E, 
                       AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, E)) {
      autoCreateBlock();
      appendStmt(Block, E);
    }
    return Visit(E.getSubExpr(), new AddStmtChoice());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3623,
   FQN="(anonymous namespace)::CFGBuilder::VisitIndirectGotoStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder21VisitIndirectGotoStmtEPN5clang16IndirectGotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder21VisitIndirectGotoStmtEPN5clang16IndirectGotoStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitIndirectGotoStmt(IndirectGotoStmt /*P*/ I) {
    // Lazily create the indirect-goto dispatch block if there isn't one already.
    CFGBlock /*P*/ IBlock = cfg.$arrow().getIndirectGotoBlock();
    if (!(IBlock != null)) {
      IBlock = createBlock(false);
      cfg.$arrow().setIndirectGotoBlock(IBlock);
    }
    
    // IndirectGoto is a control-flow statement.  Thus we stop processing the
    // current block and create a new one.
    if (badCFG) {
      return null;
    }
    
    Block = createBlock(false);
    Block.setTerminator(new CFGTerminator(I));
    addSuccessor(Block, IBlock);
    return addStmt(I.getTarget());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2319,
   FQN="(anonymous namespace)::CFGBuilder::VisitLabelStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder14VisitLabelStmtEPN5clang9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder14VisitLabelStmtEPN5clang9LabelStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitLabelStmt(LabelStmt /*P*/ L) {
    // Get the block of the labeled statement.  Add it to our map.
    addStmt(L.getSubStmt());
    CFGBlock /*P*/ LabelBlock = Block;
    if (!(LabelBlock != null)) { // This can happen when the body is empty, i.e.
      LabelBlock = createBlock(); // scopes that only contains NullStmts.
    }
    assert (LabelMap.find(L.getDecl()).$eq(/*NO_ITER_COPY*/LabelMap.end())) : "label already in map";
    LabelMap.$at_T1$RR(L.getDecl()).$assignMove(new BlockScopePosPair(LabelBlock, new LocalScope.const_iterator(ScopePos)));
    
    // Labels partition blocks, so this is the end of the basic block we were
    // processing (L is the block's label).  Because this is label (and we have
    // already processed the substatement) there is no extra control-flow to worry
    // about.
    LabelBlock.setLabel(L);
    if (badCFG) {
      return null;
    }
    
    // We set Block to NULL to allow lazy creation of a new block (if necessary);
    Block = null;
    
    // This block is now the implicit successor of other blocks.
    Succ = LabelBlock;
    
    return LabelBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2348,
   FQN="(anonymous namespace)::CFGBuilder::VisitBlockExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder14VisitBlockExprEPN5clang9BlockExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder14VisitBlockExprEPN5clang9BlockExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitBlockExpr(BlockExpr /*P*/ E, AddStmtChoice asc) {
    CFGBlock /*P*/ LastBlock = VisitNoRecurse(E, new AddStmtChoice(asc));
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : E.getBlockDecl().captures()) {
      {
        Expr /*P*/ CopyExpr = CI.getCopyExpr();
        if ((CopyExpr != null)) {
          CFGBlock /*P*/ Tmp = Visit(CopyExpr);
          if ((Tmp != null)) {
            LastBlock = Tmp;
          }
        }
      }
    }
    return LastBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2360,
   FQN="(anonymous namespace)::CFGBuilder::VisitLambdaExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder15VisitLambdaExprEPN5clang10LambdaExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15VisitLambdaExprEPN5clang10LambdaExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitLambdaExpr(LambdaExpr /*P*/ E, AddStmtChoice asc) {
    CFGBlock /*P*/ LastBlock = VisitNoRecurse(E, new AddStmtChoice(asc));
    for (type$ptr<Expr /*P*/ /*P*/> it = $tryClone(E.capture_init_begin()), 
        /*P*/ /*P*/ et = $tryClone(E.capture_init_end()); $noteq_ptr(it, et); it.$preInc()) {
      {
        Expr /*P*/ Init = it.$star();
        if ((Init != null)) {
          CFGBlock /*P*/ Tmp = Visit(Init);
          if ((Tmp != null)) {
            LastBlock = Tmp;
          }
        }
      }
    }
    return LastBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitLogicalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1654,
   FQN="(anonymous namespace)::CFGBuilder::VisitLogicalOperator", NM="_ZN12_GLOBAL__N_110CFGBuilder20VisitLogicalOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder20VisitLogicalOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitLogicalOperator(BinaryOperator /*P*/ B) {
    CFGBlock /*P*/ ConfluenceBlock = (Block != null) ? Block : createBlock();
    appendStmt(ConfluenceBlock, B);
    if (badCFG) {
      return null;
    }
    
    return VisitLogicalOperator(B, (Stmt /*P*/ )null, ConfluenceBlock, 
        ConfluenceBlock).first;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitLogicalOperator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair and other*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1665,
   FQN="(anonymous namespace)::CFGBuilder::VisitLogicalOperator", NM="_ZN12_GLOBAL__N_110CFGBuilder20VisitLogicalOperatorEPN5clang14BinaryOperatorEPNS1_4StmtEPNS1_8CFGBlockES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder20VisitLogicalOperatorEPN5clang14BinaryOperatorEPNS1_4StmtEPNS1_8CFGBlockES7_")
  //</editor-fold>
  private std.pair<CFGBlock /*P*/ , CFGBlock /*P*/ > VisitLogicalOperator(BinaryOperator /*P*/ B, 
                      Stmt /*P*/ Term, 
                      CFGBlock /*P*/ TrueBlock, 
                      CFGBlock /*P*/ FalseBlock) {
    
    // Introspect the RHS.  If it is a nested logical operation, we recursively
    // build the CFG using this function.  Otherwise, resort to default
    // CFG construction behavior.
    Expr /*P*/ RHS = B.getRHS().IgnoreParens();
    CFGBlock /*P*/ RHSBlock;
    CFGBlock /*P*/ ExitBlock;
    
    do {
      {
        BinaryOperator /*P*/ B_RHS = dyn_cast_BinaryOperator(RHS);
        if ((B_RHS != null)) {
          if (B_RHS.isLogicalOp()) {
            pair<CFGBlock, CFGBlock> tmp = VisitLogicalOperator(B_RHS, Term, TrueBlock, FalseBlock);
            RHSBlock = tmp.first;
            ExitBlock = tmp.second;
            //std.tie(RHSBlock, ExitBlock).$assign(
            //    VisitLogicalOperator(B_RHS, Term, TrueBlock, FalseBlock)
            //);
            break;
          }
        }
      }
      
      // The RHS is not a nested logical operation.  Don't push the terminator
      // down further, but instead visit RHS and construct the respective
      // pieces of the CFG, and link up the RHSBlock with the terminator
      // we have been provided.
      ExitBlock = RHSBlock = createBlock(false);
      if (!(Term != null)) {
        assert (TrueBlock == FalseBlock);
        addSuccessor(RHSBlock, TrueBlock);
      } else {
        RHSBlock.setTerminator(new CFGTerminator(Term));
        TryResult KnownVal = tryEvaluateBool(RHS);
        if (!KnownVal.isKnown()) {
          KnownVal.$assignMove(tryEvaluateBool(B));
        }
        addSuccessor(RHSBlock, TrueBlock, !KnownVal.isFalse());
        addSuccessor(RHSBlock, FalseBlock, !KnownVal.isTrue());
      }
      
      Block = RHSBlock;
      RHSBlock = addStmt(RHS);
    } while (false);
    if (badCFG) {
      return std.make_pair_nullptr_t_nullptr_t((CFGBlock /*P*/)null, (CFGBlock /*P*/)null);
    }
    
    // Generate the blocks for evaluating the LHS.
    Expr /*P*/ LHS = B.getLHS().IgnoreParens();
    {
      
      BinaryOperator /*P*/ B_LHS = dyn_cast_BinaryOperator(LHS);
      if ((B_LHS != null)) {
        if (B_LHS.isLogicalOp()) {
          if (B.getOpcode() == BinaryOperatorKind.BO_LOr) {
            FalseBlock = RHSBlock;
          } else {
            TrueBlock = RHSBlock;
          }
          
          // For the LHS, treat 'B' as the terminator that we want to sink
          // into the nested branch.  The RHS always gets the top-most
          // terminator.
          return VisitLogicalOperator(B_LHS, B, TrueBlock, FalseBlock);
        }
      }
    }
    
    // Create the block evaluating the LHS.
    // This contains the '&&' or '||' as the terminator.
    CFGBlock /*P*/ LHSBlock = createBlock(false);
    LHSBlock.setTerminator(new CFGTerminator(B));
    
    Block = LHSBlock;
    CFGBlock /*P*/ EntryLHSBlock = addStmt(LHS);
    if (badCFG) {
      return std.make_pair_nullptr_t_nullptr_t((CFGBlock /*P*/)null, (CFGBlock /*P*/)null);
    }
    
    // See if this is a known constant.
    TryResult KnownVal = tryEvaluateBool(LHS);
    
    // Now link the LHSBlock with RHSBlock.
    if (B.getOpcode() == BinaryOperatorKind.BO_LOr) {
      addSuccessor(LHSBlock, TrueBlock, !KnownVal.isFalse());
      addSuccessor(LHSBlock, RHSBlock, !KnownVal.isTrue());
    } else {
      assert (B.getOpcode() == BinaryOperatorKind.BO_LAnd);
      addSuccessor(LHSBlock, RHSBlock, !KnownVal.isFalse());
      addSuccessor(LHSBlock, FalseBlock, !KnownVal.isTrue());
    }
    
    return std.make_pair_Ptr_Ptr(EntryLHSBlock, ExitBlock);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2563,
   FQN="(anonymous namespace)::CFGBuilder::VisitMemberExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder15VisitMemberExprEPN5clang10MemberExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15VisitMemberExprEPN5clang10MemberExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitMemberExpr(MemberExpr /*P*/ M, AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, M)) {
      autoCreateBlock();
      appendStmt(Block, M);
    }
    return Visit(M.getBase());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2869,
   FQN="(anonymous namespace)::CFGBuilder::VisitObjCAtCatchStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder20VisitObjCAtCatchStmtEPN5clang15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder20VisitObjCAtCatchStmtEPN5clang15ObjCAtCatchStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitObjCAtCatchStmt(ObjCAtCatchStmt /*P*/ S) {
    // FIXME: For now we pretend that @catch and the code it contains does not
    //  exit.
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2686,
   FQN="(anonymous namespace)::CFGBuilder::VisitObjCAtSynchronizedStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder27VisitObjCAtSynchronizedStmtEPN5clang22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder27VisitObjCAtSynchronizedStmtEPN5clang22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitObjCAtSynchronizedStmt(ObjCAtSynchronizedStmt /*P*/ S) {
    // FIXME: Add locking 'primitives' to CFG for @synchronized.
    
    // Inline the body.
    CFGBlock /*P*/ SyncBlock = addStmt(S.getSynchBody());
    
    // The sync body starts its own basic block.  This makes it a little easier
    // for diagnostic clients.
    if ((SyncBlock != null)) {
      if (badCFG) {
        return null;
      }
      
      Block = null;
      Succ = SyncBlock;
    }
    
    // Add the @synchronized to the CFG.
    autoCreateBlock();
    appendStmt(Block, S);
    
    // Inline the sync expression.
    return addStmt(S.getSynchExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2875,
   FQN="(anonymous namespace)::CFGBuilder::VisitObjCAtThrowStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder20VisitObjCAtThrowStmtEPN5clang15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder20VisitObjCAtThrowStmtEPN5clang15ObjCAtThrowStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitObjCAtThrowStmt(ObjCAtThrowStmt /*P*/ S) {
    // FIXME: This isn't complete.  We basically treat @throw like a return
    //  statement.
    
    // If we were in the middle of a block we stop processing that block.
    if (badCFG) {
      return null;
    }
    
    // Create the new block.
    Block = createBlock(false);
    
    // The Exit block is the only successor.
    addSuccessor(Block, $AddrOf(cfg.$arrow().getExit()));
    
    // Add the statement to the block.  This may create new blocks if S contains
    // control-flow (short-circuit operations).
    return VisitStmt(S, new AddStmtChoice(AddStmtChoice.Kind.AlwaysAdd));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitObjCAtTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2710,
   FQN="(anonymous namespace)::CFGBuilder::VisitObjCAtTryStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder18VisitObjCAtTryStmtEPN5clang13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder18VisitObjCAtTryStmtEPN5clang13ObjCAtTryStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitObjCAtTryStmt(ObjCAtTryStmt /*P*/ S) {
    // FIXME
    return NYS();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2680,
   FQN="(anonymous namespace)::CFGBuilder::VisitObjCAutoreleasePoolStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder28VisitObjCAutoreleasePoolStmtEPN5clang23ObjCAutoreleasePoolStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder28VisitObjCAutoreleasePoolStmtEPN5clang23ObjCAutoreleasePoolStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitObjCAutoreleasePoolStmt(ObjCAutoreleasePoolStmt /*P*/ S) {
    // Inline the body.
    return addStmt(S.getSubStmt());
    // TODO: consider adding cleanups for the end of @autoreleasepool scope.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2571,
   FQN="(anonymous namespace)::CFGBuilder::VisitObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder26VisitObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder26VisitObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ S) {
    // Objective-C fast enumeration 'for' statements:
    //  http://developer.apple.com/documentation/Cocoa/Conceptual/ObjectiveC
    //
    //  for ( Type newVariable in collection_expression ) { statements }
    //
    //  becomes:
    //
    //   prologue:
    //     1. collection_expression
    //     T. jump to loop_entry
    //   loop_entry:
    //     1. side-effects of element expression
    //     1. ObjCForCollectionStmt [performs binding to newVariable]
    //     T. ObjCForCollectionStmt  TB, FB  [jumps to TB if newVariable != nil]
    //   TB:
    //     statements
    //     T. jump to loop_entry
    //   FB:
    //     what comes after
    //
    //  and
    //
    //  Type existingItem;
    //  for ( existingItem in expression ) { statements }
    //
    //  becomes:
    //
    //   the same with newVariable replaced with existingItem; the binding works
    //   the same except that for one ObjCForCollectionStmt::getElement() returns
    //   a DeclStmt and the other returns a DeclRefExpr.
    //
    CFGBlock /*P*/ LoopSuccessor = null;
    if ((Block != null)) {
      if (badCFG) {
        return null;
      }
      LoopSuccessor = Block;
      Block = null;
    } else {
      LoopSuccessor = Succ;
    }
    
    // Build the condition blocks.
    CFGBlock /*P*/ ExitConditionBlock = createBlock(false);
    
    // Set the terminator for the "exit" condition block.
    ExitConditionBlock.setTerminator(new CFGTerminator(S));
    
    // The last statement in the block should be the ObjCForCollectionStmt, which
    // performs the actual binding to 'element' and determines if there are any
    // more items in the collection.
    appendStmt(ExitConditionBlock, S);
    Block = ExitConditionBlock;
    
    // Walk the 'element' expression to see if there are any side-effects.  We
    // generate new blocks as necessary.  We DON'T add the statement by default to
    // the CFG unless it contains control-flow.
    CFGBlock /*P*/ EntryConditionBlock = Visit(S.getElement(), 
        new AddStmtChoice(AddStmtChoice.Kind.NotAlwaysAdd));
    if ((Block != null)) {
      if (badCFG) {
        return null;
      }
      Block = null;
    }
    
    // The condition block is the implicit successor for the loop body as well as
    // any code above the loop.
    Succ = EntryConditionBlock;
    {
      SaveAndRestore<CFGBlock /*P*/ > save_Block = null;
      SaveAndRestore<CFGBlock /*P*/ > save_Succ = null;
      SaveAndRestore<BlockScopePosPair> save_continue = null;
      SaveAndRestore<BlockScopePosPair> save_break = null;
      try {
        // Save the current values for Succ, continue and break targets.
        save_Block/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Block$ref, true);
        save_Succ/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Succ$ref, false);
        save_continue/*J*/= new SaveAndRestore<BlockScopePosPair>(ContinueJumpTarget$ref, false);
        save_break/*J*/= new SaveAndRestore<BlockScopePosPair>(BreakJumpTarget$ref, false);
        
        // Add an intermediate block between the BodyBlock and the
        // EntryConditionBlock to represent the "loop back" transition, for looping
        // back to the head of the loop.
        CFGBlock /*P*/ LoopBackBlock = null;
        Succ = LoopBackBlock = createBlock();
        LoopBackBlock.setLoopTarget(S);
        
        BreakJumpTarget.$assignMove(new BlockScopePosPair(LoopSuccessor, new LocalScope.const_iterator(ScopePos)));
        ContinueJumpTarget.$assignMove(new BlockScopePosPair(Succ, new LocalScope.const_iterator(ScopePos)));
        
        CFGBlock /*P*/ BodyBlock = addStmt(S.getBody());
        if (!(BodyBlock != null)) {
          BodyBlock = ContinueJumpTarget.block; // can happen for "for (X in Y) ;"
        } else if ((Block != null)) {
          if (badCFG) {
            return null;
          }
        }
        
        // This new body block is a successor to our "exit" condition block.
        addSuccessor(ExitConditionBlock, BodyBlock);
      } finally {
        if (save_break != null) { save_break.$destroy(); }
        if (save_continue != null) { save_continue.$destroy(); }
        if (save_Succ != null) { save_Succ.$destroy(); }
        if (save_Block != null) { save_Block.$destroy(); }
      }
    }
    
    // Link up the condition block with the code that follows the loop.
    // (the false branch).
    addSuccessor(ExitConditionBlock, LoopSuccessor);
    
    // Now create a prologue block to contain the collection expression.
    Block = createBlock();
    return addStmt(S.getCollection());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2715,
   FQN="(anonymous namespace)::CFGBuilder::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ E) {
    autoCreateBlock();
    
    // Add the PseudoObject as the last thing.
    appendStmt(Block, E);
    
    CFGBlock /*P*/ lastBlock = Block;
    
    // Before that, evaluate all of the semantics in order.  In
    // CFG-land, that means appending them in reverse order.
    for (/*uint*/int i = E.getNumSemanticExprs(); i != 0;) {
      Expr /*P*/ Semantic = E.getSemanticExpr(--i);
      {
        
        // If the semantic is an opaque value, we're being asked to bind
        // it to its source expression.
        OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(Semantic);
        if ((OVE != null)) {
          Semantic = OVE.getSourceExpr();
        }
      }
      {
        
        CFGBlock /*P*/ B = Visit(Semantic);
        if ((B != null)) {
          lastBlock = B;
        }
      }
    }
    
    return lastBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2296,
   FQN="(anonymous namespace)::CFGBuilder::VisitReturnStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder15VisitReturnStmtEPN5clang10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15VisitReturnStmtEPN5clang10ReturnStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitReturnStmt(ReturnStmt /*P*/ R) {
    // If we were in the middle of a block we stop processing that block.
    //
    // NOTE: If a "return" appears in the middle of a block, this means that the
    //       code afterwards is DEAD (unreachable).  We still keep a basic block
    //       for that code; a simple "mark-and-sweep" from the entry block will be
    //       able to report such dead blocks.
    
    // Create the new block.
    Block = createBlock(false);
    
    addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(), R);
    
    // If the one of the destructors does not return, we already have the Exit
    // block as a successor.
    if (!Block.hasNoReturnElement()) {
      addSuccessor(Block, $AddrOf(cfg.$arrow().getExit()));
    }
    
    // Add the return statement to the block.  This may create new blocks if R
    // contains control-flow (short-circuit operations).
    return VisitStmt(R, new AddStmtChoice(AddStmtChoice.Kind.AlwaysAdd));
  }

  
  /// VisitStmtExpr - Utility method to handle (nested) statement
  ///  expressions (a GCC extension).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3059,
   FQN="(anonymous namespace)::CFGBuilder::VisitStmtExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder13VisitStmtExprEPN5clang8StmtExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder13VisitStmtExprEPN5clang8StmtExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitStmtExpr(StmtExpr /*P*/ SE, AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, SE)) {
      autoCreateBlock();
      appendStmt(Block, SE);
    }
    return VisitCompoundStmt(SE.getSubStmt());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3067,
   FQN="(anonymous namespace)::CFGBuilder::VisitSwitchStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder15VisitSwitchStmtEPN5clang10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15VisitSwitchStmtEPN5clang10SwitchStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitSwitchStmt(SwitchStmt /*P*/ Terminator) {
    SaveAndRestore<LocalScope.const_iterator> save_scope_pos = null;
    SaveAndRestore<CFGBlock /*P*/ > save_switch = null;
    SaveAndRestore<CFGBlock /*P*/ > save_default = null;
    SaveAndRestore<BlockScopePosPair> save_break = null;
    SaveAndRestoreBool save_switchExclusivelyCovered = null;
    Expr.EvalResult result = null;
    SaveAndRestore<Expr.EvalResult /*P*/ > save_switchCond = null;
    try {
      // "switch" is a control-flow statement.  Thus we stop processing the current
      // block.
      CFGBlock /*P*/ SwitchSuccessor = null;
      
      // Save local scope position because in case of condition variable ScopePos
      // won't be restored when traversing AST.
      save_scope_pos/*J*/= new SaveAndRestore<LocalScope.const_iterator>(ScopePos$ref, false);
      {
        
        // Create local scope for C++17 switch init-stmt if one exists.
        Stmt /*P*/ Init = Terminator.getInit();
        if ((Init != null)) {
          LocalScope.const_iterator BeginScopePos = new LocalScope.const_iterator(ScopePos);
          addLocalScopeForStmt(Init);
          addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(BeginScopePos), Terminator);
        }
      }
      {
        
        // Create local scope for possible condition variable.
        // Store scope position. Add implicit destructor.
        VarDecl /*P*/ VD = Terminator.getConditionVariable();
        if ((VD != null)) {
          LocalScope.const_iterator SwitchBeginScopePos = new LocalScope.const_iterator(ScopePos);
          addLocalScopeForVarDecl(VD);
          addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(SwitchBeginScopePos), Terminator);
        }
      }
      if ((Block != null)) {
        if (badCFG) {
          return null;
        }
        SwitchSuccessor = Block;
      } else {
        SwitchSuccessor = Succ;
      }
      
      // Save the current "switch" context.
      save_switch/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(SwitchTerminatedBlock$ref, true);
      save_default/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(DefaultCaseBlock$ref, true);
      save_break/*J*/= new SaveAndRestore<BlockScopePosPair>(BreakJumpTarget$ref, false);
      
      // Set the "default" case to be the block after the switch statement.  If the
      // switch statement contains a "default:", this value will be overwritten with
      // the block for that code.
      DefaultCaseBlock = SwitchSuccessor;
      
      // Create a new block that will contain the switch statement.
      SwitchTerminatedBlock = createBlock(false);
      
      // Now process the switch body.  The code after the switch is the implicit
      // successor.
      Succ = SwitchSuccessor;
      BreakJumpTarget.$assignMove(new BlockScopePosPair(SwitchSuccessor, new LocalScope.const_iterator(ScopePos)));
      
      // When visiting the body, the case statements should automatically get linked
      // up to the switch.  We also don't keep a pointer to the body, since all
      // control-flow from the switch goes to case/default statements.
      assert ((Terminator.getBody() != null)) : "switch must contain a non-NULL body";
      Block = null;
      
      // For pruning unreachable case statements, save the current state
      // for tracking the condition value.
      save_switchExclusivelyCovered/*J*/= new SaveAndRestoreBool(switchExclusivelyCovered$ref, 
          false);
      
      // Determine if the switch condition can be explicitly evaluated.
      assert ((Terminator.getCond() != null)) : "switch condition must be non-NULL";
      result/*J*/= new Expr.EvalResult();
      boolean b = tryEvaluate(Terminator.getCond(), result);
      save_switchCond/*J*/= new SaveAndRestore<Expr.EvalResult /*P*/ >(switchCond$ref, 
          b ? $AddrOf(result) : (Expr.EvalResult /*P*/ )null, true);
      
      // If body is not a compound statement create implicit scope
      // and add destructors.
      if (!isa_CompoundStmt(Terminator.getBody())) {
        addLocalScopeAndDtors(Terminator.getBody());
      }
      
      addStmt(Terminator.getBody());
      if ((Block != null)) {
        if (badCFG) {
          return null;
        }
      }
      
      // If we have no "default:" case, the default transition is to the code
      // following the switch body.  Moreover, take into account if all the
      // cases of a switch are covered (e.g., switching on an enum value).
      //
      // Note: We add a successor to a switch that is considered covered yet has no
      //       case statements if the enumeration has no enumerators.
      boolean SwitchAlwaysHasSuccessor = false;
      SwitchAlwaysHasSuccessor |= switchExclusivelyCovered;
      SwitchAlwaysHasSuccessor |= Terminator.isAllEnumCasesCovered()
         && (Terminator.getSwitchCaseList() != null);
      addSuccessor(SwitchTerminatedBlock, DefaultCaseBlock, 
          !SwitchAlwaysHasSuccessor);
      
      // Add the terminator and condition in the switch block.
      SwitchTerminatedBlock.setTerminator(new CFGTerminator(Terminator));
      Block = SwitchTerminatedBlock;
      CFGBlock /*P*/ LastBlock = addStmt(Terminator.getCond());
      {
        
        // If the SwitchStmt contains a condition variable, add both the
        // SwitchStmt and the condition variable initialization to the CFG.
        VarDecl /*P*/ VD = Terminator.getConditionVariable();
        if ((VD != null)) {
          {
            Expr /*P*/ Init = VD.getInit();
            if ((Init != null)) {
              autoCreateBlock();
              appendStmt(Block, Terminator.getConditionVariableDeclStmt());
              LastBlock = addStmt(Init);
            }
          }
        }
      }
      {
        
        // Finally, if the SwitchStmt contains a C++17 init-stmt, add it to the CFG.
        Stmt /*P*/ Init = Terminator.getInit();
        if ((Init != null)) {
          autoCreateBlock();
          LastBlock = addStmt(Init);
        }
      }
      
      return LastBlock;
    } finally {
      if (save_switchCond != null) { save_switchCond.$destroy(); }
      if (result != null) { result.$destroy(); }
      if (save_switchExclusivelyCovered != null) { save_switchExclusivelyCovered.$destroy(); }
      if (save_break != null) { save_break.$destroy(); }
      if (save_default != null) { save_default.$destroy(); }
      if (save_switch != null) { save_switch.$destroy(); }
      if (save_scope_pos != null) { save_scope_pos.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3038,
   FQN="(anonymous namespace)::CFGBuilder::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_110CFGBuilder29VisitUnaryExprOrTypeTraitExprEPN5clang24UnaryExprOrTypeTraitExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder29VisitUnaryExprOrTypeTraitExprEPN5clang24UnaryExprOrTypeTraitExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr /*P*/ E, 
                               AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, E)) {
      autoCreateBlock();
      appendStmt(Block, E);
    }
    
    // VLA types have expressions that must be evaluated.
    CFGBlock /*P*/ lastBlock = Block;
    if (E.isArgumentType()) {
      for (/*const*/ VariableArrayType /*P*/ VA = FindVA(E.getArgumentType().getTypePtr());
           VA != null; VA = FindVA(VA.getElementType().getTypePtr()))  {
        lastBlock = addStmt(VA.getSizeExpr());
      }
    }
    return lastBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1644,
   FQN="(anonymous namespace)::CFGBuilder::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_110CFGBuilder18VisitUnaryOperatorEPN5clang13UnaryOperatorENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder18VisitUnaryOperatorEPN5clang13UnaryOperatorENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitUnaryOperator(UnaryOperator /*P*/ U, 
                    AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, U)) {
      autoCreateBlock();
      appendStmt(Block, U);
    }
    
    return Visit(U.getSubExpr(), new AddStmtChoice());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitWhileStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 2740,
   FQN="(anonymous namespace)::CFGBuilder::VisitWhileStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder14VisitWhileStmtEPN5clang9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder14VisitWhileStmtEPN5clang9WhileStmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitWhileStmt(WhileStmt /*P*/ W) {
    SaveAndRestore<LocalScope.const_iterator> save_scope_pos = null;
    try {
      CFGBlock /*P*/ LoopSuccessor = null;
      
      // Save local scope position because in case of condition variable ScopePos
      // won't be restored when traversing AST.
      save_scope_pos/*J*/= new SaveAndRestore<LocalScope.const_iterator>(ScopePos$ref, false);
      
      // Create local scope for possible condition variable.
      // Store scope position for continue statement.
      LocalScope.const_iterator LoopBeginScopePos = new LocalScope.const_iterator(ScopePos);
      {
        VarDecl /*P*/ VD = W.getConditionVariable();
        if ((VD != null)) {
          addLocalScopeForVarDecl(VD);
          addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(LoopBeginScopePos), W);
        }
      }
      
      // "while" is a control-flow statement.  Thus we stop processing the current
      // block.
      if ((Block != null)) {
        if (badCFG) {
          return null;
        }
        LoopSuccessor = Block;
        Block = null;
      } else {
        LoopSuccessor = Succ;
      }
      
      CFGBlock /*P*/ BodyBlock = null;
      CFGBlock /*P*/ TransitionBlock = null;
      {
        SaveAndRestore<CFGBlock /*P*/ > save_Block = null;
        SaveAndRestore<CFGBlock /*P*/ > save_Succ = null;
        SaveAndRestore<BlockScopePosPair> save_continue = null;
        SaveAndRestore<BlockScopePosPair> save_break = null;
        try {
          assert Native.$bool(W.getBody());
          
          // Save the current values for Block, Succ, continue and break targets.
          save_Block/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Block$ref, true);
          save_Succ/*J*/= new SaveAndRestore<CFGBlock /*P*/ >(Succ$ref, true);
          save_continue/*J*/= new SaveAndRestore<BlockScopePosPair>(ContinueJumpTarget$ref, false);
          save_break/*J*/= new SaveAndRestore<BlockScopePosPair>(BreakJumpTarget$ref, false);
          
          // Create an empty block to represent the transition block for looping back
          // to the head of the loop.
          Succ = TransitionBlock = createBlock(false);
          TransitionBlock.setLoopTarget(W);
          ContinueJumpTarget.$assignMove(new BlockScopePosPair(Succ, new LocalScope.const_iterator(LoopBeginScopePos)));
          
          // All breaks should go to the code following the loop.
          BreakJumpTarget.$assignMove(new BlockScopePosPair(LoopSuccessor, new LocalScope.const_iterator(ScopePos)));
          
          // Loop body should end with destructor of Condition variable (if any).
          addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(LoopBeginScopePos), W);
          
          // If body is not a compound statement create implicit scope
          // and add destructors.
          if (!isa_CompoundStmt(W.getBody())) {
            addLocalScopeAndDtors(W.getBody());
          }
          
          // Create the body.  The returned block is the entry to the loop body.
          BodyBlock = addStmt(W.getBody());
          if (!(BodyBlock != null)) {
            BodyBlock = ContinueJumpTarget.block; // can happen for "while(...) ;"
          } else if ((Block != null) && badCFG) {
            return null;
          }
        } finally {
          if (save_break != null) { save_break.$destroy(); }
          if (save_continue != null) { save_continue.$destroy(); }
          if (save_Succ != null) { save_Succ.$destroy(); }
          if (save_Block != null) { save_Block.$destroy(); }
        }
      }
      
      // Because of short-circuit evaluation, the condition of the loop can span
      // multiple basic blocks.  Thus we need the "Entry" and "Exit" blocks that
      // evaluate the condition.
      CFGBlock /*P*/ EntryConditionBlock = null;
      CFGBlock /*P*/ ExitConditionBlock = null;
      
      do {
        Expr /*P*/ C = W.getCond();
        {
          
          // Specially handle logical operators, which have a slightly
          // more optimal CFG representation.
          BinaryOperator /*P*/ Cond = dyn_cast_BinaryOperator(C.IgnoreParens());
          if ((Cond != null)) {
            if (Cond.isLogicalOp()) {
//              std.tie(EntryConditionBlock, ExitConditionBlock).$assign(
//                  VisitLogicalOperator(Cond, W, BodyBlock, LoopSuccessor)
//              );
              std.pair<CFGBlock/*P*/, CFGBlock/*P*/> $tie = VisitLogicalOperator(Cond, W, BodyBlock, LoopSuccessor);
              EntryConditionBlock = $tie.first;
              ExitConditionBlock = $tie.second;
              break;
            }
          }
        }
        
        // The default case when not handling logical operators.
        ExitConditionBlock = createBlock(false);
        ExitConditionBlock.setTerminator(new CFGTerminator(W));
        
        // Now add the actual condition to the condition block.
        // Because the condition itself may contain control-flow, new blocks may
        // be created.  Thus we update "Succ" after adding the condition.
        Block = ExitConditionBlock;
        Block = EntryConditionBlock = addStmt(C);
        {
          
          // If this block contains a condition variable, add both the condition
          // variable and initializer to the CFG.
          VarDecl /*P*/ VD = W.getConditionVariable();
          if ((VD != null)) {
            {
              Expr /*P*/ Init = VD.getInit();
              if ((Init != null)) {
                autoCreateBlock();
                appendStmt(Block, W.getConditionVariableDeclStmt());
                EntryConditionBlock = addStmt(Init);
                assert (Block == EntryConditionBlock);
              }
            }
          }
        }
        if ((Block != null) && badCFG) {
          return null;
        }
        
        // See if this is a known constant.
        final /*const*/ TryResult /*&*/ KnownVal = tryEvaluateBool(C);
        
        // Add the loop body entry as a successor to the condition.
        addSuccessor(ExitConditionBlock, KnownVal.isFalse() ? (CFGBlock /*P*/ )null : BodyBlock);
        // Link up the condition block with the code that follows the loop.  (the
        // false branch).
        addSuccessor(ExitConditionBlock, 
            KnownVal.isTrue() ? (CFGBlock /*P*/ )null : LoopSuccessor);
      } while (false);
      
      // Link up the loop-back block to the entry condition block.
      addSuccessor(TransitionBlock, EntryConditionBlock);
      
      // There can be no more statements in the condition block since we loop back
      // to this block.  NULL out Block to force lazy creation of another block.
      Block = null;
      
      // Return the condition block, which is the dominating block for the loop.
      Succ = EntryConditionBlock;
      return EntryConditionBlock;
    } finally {
      if (save_scope_pos != null) { save_scope_pos.$destroy(); }
    }
  }

  
  
  /// Visit - Walk the subtree of a statement and add extra
  ///   blocks for ternary operators, &&, and ||.  We also process "," and
  ///   DeclStmts (which may contain nested control-flow).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1431,
   FQN="(anonymous namespace)::CFGBuilder::Visit", NM="_ZN12_GLOBAL__N_110CFGBuilder5VisitEPN5clang4StmtENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder5VisitEPN5clang4StmtENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ Visit(Stmt /*P*/ S) {
    return Visit(S, new AddStmtChoice(AddStmtChoice.Kind.NotAlwaysAdd));
  }
  private CFGBlock /*P*/ Visit(Stmt /*P*/ S, AddStmtChoice asc/*= AddStmtChoice::NotAlwaysAdd*/) {
    if (!(S != null)) {
      badCFG = true;
      return null;
    }
    {
      
      Expr /*P*/ E = dyn_cast_Expr(S);
      if ((E != null)) {
        S = E.IgnoreParens();
      }
    }
    switch (S.getStmtClass()) {
     default:
      return VisitStmt(S, new AddStmtChoice(asc));
     case AddrLabelExprClass:
      return VisitAddrLabelExpr(cast_AddrLabelExpr(S), new AddStmtChoice(asc));
     case BinaryConditionalOperatorClass:
      return VisitConditionalOperator(cast_BinaryConditionalOperator(S), new AddStmtChoice(asc));
     case BinaryOperatorClass:
      return VisitBinaryOperator(cast_BinaryOperator(S), new AddStmtChoice(asc));
     case BlockExprClass:
      return VisitBlockExpr(cast_BlockExpr(S), new AddStmtChoice(asc));
     case BreakStmtClass:
      return VisitBreakStmt(cast_BreakStmt(S));
     case CallExprClass:
     case CXXOperatorCallExprClass:
     case CXXMemberCallExprClass:
     case UserDefinedLiteralClass:
      return VisitCallExpr(cast_CallExpr(S), new AddStmtChoice(asc));
     case CaseStmtClass:
      return VisitCaseStmt(cast_CaseStmt(S));
     case ChooseExprClass:
      return VisitChooseExpr(cast_ChooseExpr(S), new AddStmtChoice(asc));
     case CompoundStmtClass:
      return VisitCompoundStmt(cast_CompoundStmt(S));
     case ConditionalOperatorClass:
      return VisitConditionalOperator(cast_ConditionalOperator(S), new AddStmtChoice(asc));
     case ContinueStmtClass:
      return VisitContinueStmt(cast_ContinueStmt(S));
     case CXXCatchStmtClass:
      return VisitCXXCatchStmt(cast_CXXCatchStmt(S));
     case ExprWithCleanupsClass:
      return VisitExprWithCleanups(cast_ExprWithCleanups(S), new AddStmtChoice(asc));
     case CXXDefaultArgExprClass:
     case CXXDefaultInitExprClass:
      // FIXME: The expression inside a CXXDefaultArgExpr is owned by the
      // called function's declaration, not by the caller. If we simply add
      // this expression to the CFG, we could end up with the same Expr
      // appearing multiple times.
      // PR13385 / <rdar://problem/12156507>
      //
      // It's likewise possible for multiple CXXDefaultInitExprs for the same
      // expression to be used in the same function (through aggregate
      // initialization).
      return VisitStmt(S, new AddStmtChoice(asc));
     case CXXBindTemporaryExprClass:
      return VisitCXXBindTemporaryExpr(cast_CXXBindTemporaryExpr(S), new AddStmtChoice(asc));
     case CXXConstructExprClass:
      return VisitCXXConstructExpr(cast_CXXConstructExpr(S), new AddStmtChoice(asc));
     case CXXNewExprClass:
      return VisitCXXNewExpr(cast_CXXNewExpr(S), new AddStmtChoice(asc));
     case CXXDeleteExprClass:
      return VisitCXXDeleteExpr(cast_CXXDeleteExpr(S), new AddStmtChoice(asc));
     case CXXFunctionalCastExprClass:
      return VisitCXXFunctionalCastExpr(cast_CXXFunctionalCastExpr(S), new AddStmtChoice(asc));
     case CXXTemporaryObjectExprClass:
      return VisitCXXTemporaryObjectExpr(cast_CXXTemporaryObjectExpr(S), new AddStmtChoice(asc));
     case CXXThrowExprClass:
      return VisitCXXThrowExpr(cast_CXXThrowExpr(S));
     case CXXTryStmtClass:
      return VisitCXXTryStmt(cast_CXXTryStmt(S));
     case CXXForRangeStmtClass:
      return VisitCXXForRangeStmt(cast_CXXForRangeStmt(S));
     case DeclStmtClass:
      return VisitDeclStmt(cast_DeclStmt(S));
     case DefaultStmtClass:
      return VisitDefaultStmt(cast_DefaultStmt(S));
     case DoStmtClass:
      return VisitDoStmt(cast_DoStmt(S));
     case ForStmtClass:
      return VisitForStmt(cast_ForStmt(S));
     case GotoStmtClass:
      return VisitGotoStmt(cast_GotoStmt(S));
     case IfStmtClass:
      return VisitIfStmt(cast_IfStmt(S));
     case ImplicitCastExprClass:
      return VisitImplicitCastExpr(cast_ImplicitCastExpr(S), new AddStmtChoice(asc));
     case IndirectGotoStmtClass:
      return VisitIndirectGotoStmt(cast_IndirectGotoStmt(S));
     case LabelStmtClass:
      return VisitLabelStmt(cast_LabelStmt(S));
     case LambdaExprClass:
      return VisitLambdaExpr(cast_LambdaExpr(S), new AddStmtChoice(asc));
     case MemberExprClass:
      return VisitMemberExpr(cast_MemberExpr(S), new AddStmtChoice(asc));
     case NullStmtClass:
      return Block;
     case ObjCAtCatchStmtClass:
      return VisitObjCAtCatchStmt(cast_ObjCAtCatchStmt(S));
     case ObjCAutoreleasePoolStmtClass:
      return VisitObjCAutoreleasePoolStmt(cast_ObjCAutoreleasePoolStmt(S));
     case ObjCAtSynchronizedStmtClass:
      return VisitObjCAtSynchronizedStmt(cast_ObjCAtSynchronizedStmt(S));
     case ObjCAtThrowStmtClass:
      return VisitObjCAtThrowStmt(cast_ObjCAtThrowStmt(S));
     case ObjCAtTryStmtClass:
      return VisitObjCAtTryStmt(cast_ObjCAtTryStmt(S));
     case ObjCForCollectionStmtClass:
      return VisitObjCForCollectionStmt(cast_ObjCForCollectionStmt(S));
     case OpaqueValueExprClass:
      return Block;
     case PseudoObjectExprClass:
      return VisitPseudoObjectExpr(cast_PseudoObjectExpr(S));
     case ReturnStmtClass:
      return VisitReturnStmt(cast_ReturnStmt(S));
     case UnaryExprOrTypeTraitExprClass:
      return VisitUnaryExprOrTypeTraitExpr(cast_UnaryExprOrTypeTraitExpr(S), 
          new AddStmtChoice(asc));
     case StmtExprClass:
      return VisitStmtExpr(cast_StmtExpr(S), new AddStmtChoice(asc));
     case SwitchStmtClass:
      return VisitSwitchStmt(cast_SwitchStmt(S));
     case UnaryOperatorClass:
      return VisitUnaryOperator(cast_UnaryOperator(S), new AddStmtChoice(asc));
     case WhileStmtClass:
      return VisitWhileStmt(cast_WhileStmt(S));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1607,
   FQN="(anonymous namespace)::CFGBuilder::VisitStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder9VisitStmtEPN5clang4StmtENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder9VisitStmtEPN5clang4StmtENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitStmt(Stmt /*P*/ S, AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, S)) {
      autoCreateBlock();
      appendStmt(Block, S);
    }
    
    return VisitChildren(S);
  }

  
  /// VisitChildren - Visit the children of a Stmt.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1617,
   FQN="(anonymous namespace)::CFGBuilder::VisitChildren", NM="_ZN12_GLOBAL__N_110CFGBuilder13VisitChildrenEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder13VisitChildrenEPN5clang4StmtE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitChildren(Stmt /*P*/ S) {
    reverse_children RChildren = null;
    try {
      CFGBlock /*P*/ B = Block;
      
      // Visit the children in their reverse order so that they appear in
      // left-to-right (natural) order in the CFG.
      RChildren/*J*/= new reverse_children(S);
      for (std.reverse_iterator<Stmt /*P*/ /*const*/> I = RChildren.begin(), E = RChildren.end();
           $noteq_reverse_iterator$C(I, E); I.$preInc()) {
        {
          Stmt /*P*/ Child = I.$star();
          if ((Child != null)) {
            {
              CFGBlock /*P*/ R = Visit(Child);
              if ((R != null)) {
                B = R;
              }
            }
          }
        }
      }
      return B;
    } finally {
      if (RChildren != null) { RChildren.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitNoRecurse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1791,
   FQN="(anonymous namespace)::CFGBuilder::VisitNoRecurse", NM="_ZN12_GLOBAL__N_110CFGBuilder14VisitNoRecurseEPN5clang4ExprENS_13AddStmtChoiceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder14VisitNoRecurseEPN5clang4ExprENS_13AddStmtChoiceE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitNoRecurse(Expr /*P*/ E, AddStmtChoice asc) {
    if (asc.alwaysAdd(/*Deref*/this, E)) {
      autoCreateBlock();
      appendStmt(Block, E);
    }
    return Block;
  }

  
  /// When creating the CFG for temporary destructors, we want to mirror the
  /// branch structure of the corresponding constructor calls.
  /// Thus, while visiting a statement for temporary destructors, we keep a
  /// context to keep track of the following information:
  /// - whether a subexpression is executed unconditionally
  /// - if a subexpression is executed conditionally, the first
  ///   CXXBindTemporaryExpr we encounter in that subexpression (which
  ///   corresponds to the last temporary destructor we have to call for this
  ///   subexpression) and the CFG block at that point (which will become the
  ///   successor block when inserting the decision point).
  ///
  /// That way, we can build the branch structure for temporary destructors as
  /// follows:
  /// 1. If a subexpression is executed unconditionally, we add the temporary
  ///    destructor calls to the current block.
  /// 2. If a subexpression is executed conditionally, when we encounter a
  ///    CXXBindTemporaryExpr:
  ///    a) If it is the first temporary destructor call in the subexpression,
  ///       we remember the CXXBindTemporaryExpr and the current block in the
  ///       TempDtorContext; we start a new block, and insert the temporary
  ///       destructor call.
  ///    b) Otherwise, add the temporary destructor call to the current block.
  ///  3. When we finished visiting a conditionally executed subexpression,
  ///     and we found at least one temporary constructor during the visitation
  ///     (2.a has executed), we insert a decision block that uses the
  ///     CXXBindTemporaryExpr as terminator, and branches to the current block
  ///     if the CXXBindTemporaryExpr was marked executed, and otherwise
  ///     branches to the stored successor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::TempDtorContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 519,
   FQN="(anonymous namespace)::CFGBuilder::TempDtorContext", NM="_ZN12_GLOBAL__N_110CFGBuilder15TempDtorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15TempDtorContextE")
  //</editor-fold>
  private static class/*struct*/ TempDtorContext {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::TempDtorContext::TempDtorContext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 520,
     FQN="(anonymous namespace)::CFGBuilder::TempDtorContext::TempDtorContext", NM="_ZN12_GLOBAL__N_110CFGBuilder15TempDtorContextC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15TempDtorContextC1Ev")
    //</editor-fold>
    public TempDtorContext() {
      // : IsConditional(false), KnownExecuted(true), Succ(null), TerminatorExpr(null) 
      //START JInit
      this.IsConditional = false;
      this.KnownExecuted = new TryResult(true);
      this.Succ = null;
      this.TerminatorExpr = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::TempDtorContext::TempDtorContext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 524,
     FQN="(anonymous namespace)::CFGBuilder::TempDtorContext::TempDtorContext", NM="_ZN12_GLOBAL__N_110CFGBuilder15TempDtorContextC1ENS_9TryResultE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15TempDtorContextC1ENS_9TryResultE")
    //</editor-fold>
    public TempDtorContext(TryResult KnownExecuted) {
      // : IsConditional(true), KnownExecuted(KnownExecuted), Succ(null), TerminatorExpr(null) 
      //START JInit
      this.IsConditional = true;
      this.KnownExecuted = new TryResult(KnownExecuted);
      this.Succ = null;
      this.TerminatorExpr = null;
      //END JInit
    }

    
    /// Returns whether we need to start a new branch for a temporary destructor
    /// call. This is the case when the temporary destructor is
    /// conditionally executed, and it is the first one we encounter while
    /// visiting a subexpression - other temporary destructors at the same level
    /// will be added to the same block and are executed under the same
    /// condition.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::TempDtorContext::needsTempDtorBranch">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 534,
     FQN="(anonymous namespace)::CFGBuilder::TempDtorContext::needsTempDtorBranch", NM="_ZNK12_GLOBAL__N_110CFGBuilder15TempDtorContext19needsTempDtorBranchEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_110CFGBuilder15TempDtorContext19needsTempDtorBranchEv")
    //</editor-fold>
    public boolean needsTempDtorBranch() /*const*/ {
      return IsConditional && !(TerminatorExpr != null);
    }

    
    /// Remember the successor S of a temporary destructor decision branch for
    /// the corresponding CXXBindTemporaryExpr E.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::TempDtorContext::setDecisionPoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 540,
     FQN="(anonymous namespace)::CFGBuilder::TempDtorContext::setDecisionPoint", NM="_ZN12_GLOBAL__N_110CFGBuilder15TempDtorContext16setDecisionPointEPN5clang8CFGBlockEPNS2_20CXXBindTemporaryExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15TempDtorContext16setDecisionPointEPN5clang8CFGBlockEPNS2_20CXXBindTemporaryExprE")
    //</editor-fold>
    public void setDecisionPoint(CFGBlock /*P*/ S, CXXBindTemporaryExpr /*P*/ E) {
      Succ = S;
      TerminatorExpr = E;
    }

    
    public /*const*/boolean IsConditional;
    public /*const*/ TryResult KnownExecuted;
    public CFGBlock /*P*/ Succ;
    public CXXBindTemporaryExpr /*P*/ TerminatorExpr;
    
    @Override public String toString() {
      return "" + "IsConditional=" + IsConditional // NOI18N
                + ", KnownExecuted=" + KnownExecuted // NOI18N
                + ", Succ=" + Succ // NOI18N
                + ", TerminatorExpr=" + TerminatorExpr; // NOI18N
    }
  };
  
  // Visitors to walk an AST and generate destructors of temporaries in
  // full expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitForTemporaryDtors">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3643,
   FQN="(anonymous namespace)::CFGBuilder::VisitForTemporaryDtors", NM="_ZN12_GLOBAL__N_110CFGBuilder22VisitForTemporaryDtorsEPN5clang4StmtEbRNS0_15TempDtorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder22VisitForTemporaryDtorsEPN5clang4StmtEbRNS0_15TempDtorContextE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitForTemporaryDtors(Stmt /*P*/ E, boolean BindToTemporary, 
                        final TempDtorContext /*&*/ Context) {
    assert (BuildOpts.AddImplicitDtors && BuildOpts.AddTemporaryDtors);
   tryAgain: while(true){
    if (!(E != null)) {
      badCFG = true;
      return null;
    }
    switch (E.getStmtClass()) {
     default:
      return VisitChildrenForTemporaryDtors(E, Context);
     case BinaryOperatorClass:
      return VisitBinaryOperatorForTemporaryDtors(cast_BinaryOperator(E), 
          Context);
     case CXXBindTemporaryExprClass:
      return VisitCXXBindTemporaryExprForTemporaryDtors(cast_CXXBindTemporaryExpr(E), BindToTemporary, Context);
     case BinaryConditionalOperatorClass:
     case ConditionalOperatorClass:
      return VisitConditionalOperatorForTemporaryDtors(cast_AbstractConditionalOperator(E), BindToTemporary, Context);
     case ImplicitCastExprClass:
      // For implicit cast we want BindToTemporary to be passed further.
      E = cast_CastExpr(E).getSubExpr();
      continue tryAgain;
     case CXXFunctionalCastExprClass:
      // For functional cast we want BindToTemporary to be passed further.
      E = cast_CXXFunctionalCastExpr(E).getSubExpr();
      continue tryAgain;
     case ParenExprClass:
      E = cast_ParenExpr(E).getSubExpr();
      continue tryAgain;
     case MaterializeTemporaryExprClass:
      {
        /*const*/ MaterializeTemporaryExpr /*P*/ MTE = cast_MaterializeTemporaryExpr(E);
        BindToTemporary = (MTE.getStorageDuration() != StorageDuration.SD_FullExpression);
        SmallVector</*const*/ Expr /*P*/ > CommaLHSs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(2, (/*const*/ Expr /*P*/ )null);
        SmallVector<SubobjectAdjustment> Adjustments/*J*/= new SmallVector<SubobjectAdjustment>(2, new SubobjectAdjustment());
        // Find the expression whose lifetime needs to be extended.
        E = ((/*const_cast*/Expr /*P*/ )(cast_MaterializeTemporaryExpr(E).
            GetTemporaryExpr().
            skipRValueSubobjectAdjustments(CommaLHSs, Adjustments)));
        // Visit the skipped comma operator left-hand sides for other temporaries.
        for (/*const*/ Expr /*P*/ CommaLHS : CommaLHSs) {
          VisitForTemporaryDtors(((/*const_cast*/Expr /*P*/ )(CommaLHS)), 
              /*BindToTemporary=*/ false, Context);
        }
        continue tryAgain;
      }
     case BlockExprClass:
      // Don't recurse into blocks; their subexpressions don't get evaluated
      // here.
      return Block;
     case LambdaExprClass:
      {
        // For lambda expressions, only recurse into the capture initializers,
        // and not the body.
        LambdaExpr /*P*/ LE = cast_LambdaExpr(E);
        CFGBlock /*P*/ B = Block;
        for (Expr /*P*/ Init : LE.capture_inits()) {
          {
            CFGBlock /*P*/ R = VisitForTemporaryDtors(Init, /*BindToTemporary=*/ false, Context);
            if ((R != null)) {
              B = R;
            }
          }
        }
        return B;
      }
     case CXXDefaultArgExprClass:
      E = cast_CXXDefaultArgExpr(E).getExpr();
      continue tryAgain;
     case CXXDefaultInitExprClass:
      E = cast_CXXDefaultInitExpr(E).getExpr();
      continue tryAgain;
    }
   }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitChildrenForTemporaryDtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3729,
   FQN="(anonymous namespace)::CFGBuilder::VisitChildrenForTemporaryDtors", NM="_ZN12_GLOBAL__N_110CFGBuilder30VisitChildrenForTemporaryDtorsEPN5clang4StmtERNS0_15TempDtorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder30VisitChildrenForTemporaryDtorsEPN5clang4StmtERNS0_15TempDtorContextE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitChildrenForTemporaryDtors(Stmt /*P*/ E, 
                                final TempDtorContext /*&*/ Context) {
    if (isa_LambdaExpr(E)) {
      // Do not visit the children of lambdas; they have their own CFGs.
      return Block;
    }
    
    // When visiting children for destructors we want to visit them in reverse
    // order that they will appear in the CFG.  Because the CFG is built
    // bottom-up, this means we visit them in their natural order, which
    // reverses them in the CFG.
    CFGBlock /*P*/ B = Block;
    for (Stmt /*P*/ Child : E.children())  {
      if ((Child != null)) {
        {
          CFGBlock /*P*/ R = VisitForTemporaryDtors(Child, false, Context);
          if ((R != null)) {
            B = R;
          }
        }
      }
    }
    
    return B;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitBinaryOperatorForTemporaryDtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3749,
   FQN="(anonymous namespace)::CFGBuilder::VisitBinaryOperatorForTemporaryDtors", NM="_ZN12_GLOBAL__N_110CFGBuilder36VisitBinaryOperatorForTemporaryDtorsEPN5clang14BinaryOperatorERNS0_15TempDtorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder36VisitBinaryOperatorForTemporaryDtorsEPN5clang14BinaryOperatorERNS0_15TempDtorContextE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitBinaryOperatorForTemporaryDtors(BinaryOperator /*P*/ E, final TempDtorContext /*&*/ Context) {
    if (E.isLogicalOp()) {
      VisitForTemporaryDtors(E.getLHS(), false, Context);
      TryResult RHSExecuted = tryEvaluateBool(E.getLHS());
      if (RHSExecuted.isKnown() && E.getOpcode() == BinaryOperatorKind.BO_LOr) {
        RHSExecuted.negate();
      }
      
      // We do not know at CFG-construction time whether the right-hand-side was
      // executed, thus we add a branch node that depends on the temporary
      // constructor call.
      TempDtorContext RHSContext/*J*/= new TempDtorContext(bothKnownTrue(new TryResult(Context.KnownExecuted), new TryResult(RHSExecuted)));
      VisitForTemporaryDtors(E.getRHS(), false, RHSContext);
      InsertTempDtorDecisionBlock(RHSContext);
      
      return Block;
    }
    if (E.isAssignmentOp()) {
      // For assignment operator (=) LHS expression is visited
      // before RHS expression. For destructors visit them in reverse order.
      CFGBlock /*P*/ RHSBlock = VisitForTemporaryDtors(E.getRHS(), false, Context);
      CFGBlock /*P*/ LHSBlock = VisitForTemporaryDtors(E.getLHS(), false, Context);
      return (LHSBlock != null) ? LHSBlock : RHSBlock;
    }
    
    // For any other binary operator RHS expression is visited before
    // LHS expression (order of children). For destructors visit them in reverse
    // order.
    CFGBlock /*P*/ LHSBlock = VisitForTemporaryDtors(E.getLHS(), false, Context);
    CFGBlock /*P*/ RHSBlock = VisitForTemporaryDtors(E.getRHS(), false, Context);
    return (RHSBlock != null) ? RHSBlock : LHSBlock;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitCXXBindTemporaryExprForTemporaryDtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3784,
   FQN="(anonymous namespace)::CFGBuilder::VisitCXXBindTemporaryExprForTemporaryDtors", NM="_ZN12_GLOBAL__N_110CFGBuilder42VisitCXXBindTemporaryExprForTemporaryDtorsEPN5clang20CXXBindTemporaryExprEbRNS0_15TempDtorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder42VisitCXXBindTemporaryExprForTemporaryDtorsEPN5clang20CXXBindTemporaryExprEbRNS0_15TempDtorContextE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitCXXBindTemporaryExprForTemporaryDtors(CXXBindTemporaryExpr /*P*/ E, boolean BindToTemporary, final TempDtorContext /*&*/ Context) {
    // First add destructors for temporaries in subexpression.
    CFGBlock /*P*/ B = VisitForTemporaryDtors(E.getSubExpr(), false, Context);
    if (!BindToTemporary) {
      // If lifetime of temporary is not prolonged (by assigning to constant
      // reference) add destructor for it.
      /*const*/ CXXDestructorDecl /*P*/ Dtor = E.getTemporary().getDestructor();
      if (Dtor.getParent$Const().isAnyDestructorNoReturn()) {
        // If the destructor is marked as a no-return destructor, we need to
        // create a new block for the destructor which does not have as a
        // successor anything built thus far. Control won't flow out of this
        // block.
        if ((B != null)) {
          Succ = B;
        }
        Block = createNoReturnBlock();
      } else if (Context.needsTempDtorBranch()) {
        // If we need to introduce a branch, we add a new block that we will hook
        // up to a decision block later.
        if ((B != null)) {
          Succ = B;
        }
        Block = createBlock();
      } else {
        autoCreateBlock();
      }
      if (Context.needsTempDtorBranch()) {
        Context.setDecisionPoint(Succ, E);
      }
      appendTemporaryDtor(Block, E);
      
      B = Block;
    }
    return B;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::VisitConditionalOperatorForTemporaryDtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3834,
   FQN="(anonymous namespace)::CFGBuilder::VisitConditionalOperatorForTemporaryDtors", NM="_ZN12_GLOBAL__N_110CFGBuilder41VisitConditionalOperatorForTemporaryDtorsEPN5clang27AbstractConditionalOperatorEbRNS0_15TempDtorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder41VisitConditionalOperatorForTemporaryDtorsEPN5clang27AbstractConditionalOperatorEbRNS0_15TempDtorContextE")
  //</editor-fold>
  private CFGBlock /*P*/ VisitConditionalOperatorForTemporaryDtors(AbstractConditionalOperator /*P*/ E, boolean BindToTemporary, 
                                           final TempDtorContext /*&*/ Context) {
    VisitForTemporaryDtors(E.getCond(), false, Context);
    CFGBlock /*P*/ ConditionBlock = Block;
    CFGBlock /*P*/ ConditionSucc = Succ;
    TryResult ConditionVal = tryEvaluateBool(E.getCond());
    TryResult NegatedVal = new TryResult(ConditionVal);
    if (NegatedVal.isKnown()) {
      NegatedVal.negate();
    }
    
    TempDtorContext TrueContext/*J*/= new TempDtorContext(bothKnownTrue(new TryResult(Context.KnownExecuted), new TryResult(ConditionVal)));
    VisitForTemporaryDtors(E.getTrueExpr(), BindToTemporary, TrueContext);
    CFGBlock /*P*/ TrueBlock = Block;
    
    Block = ConditionBlock;
    Succ = ConditionSucc;
    TempDtorContext FalseContext/*J*/= new TempDtorContext(bothKnownTrue(new TryResult(Context.KnownExecuted), new TryResult(NegatedVal)));
    VisitForTemporaryDtors(E.getFalseExpr(), BindToTemporary, FalseContext);
    if ((TrueContext.TerminatorExpr != null) && (FalseContext.TerminatorExpr != null)) {
      InsertTempDtorDecisionBlock(FalseContext, TrueBlock);
    } else if ((TrueContext.TerminatorExpr != null)) {
      Block = TrueBlock;
      InsertTempDtorDecisionBlock(TrueContext);
    } else {
      InsertTempDtorDecisionBlock(FalseContext);
    }
    return Block;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::InsertTempDtorDecisionBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3819,
   FQN="(anonymous namespace)::CFGBuilder::InsertTempDtorDecisionBlock", NM="_ZN12_GLOBAL__N_110CFGBuilder27InsertTempDtorDecisionBlockERKNS0_15TempDtorContextEPN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder27InsertTempDtorDecisionBlockERKNS0_15TempDtorContextEPN5clang8CFGBlockE")
  //</editor-fold>
  private void InsertTempDtorDecisionBlock(final /*const*/ TempDtorContext /*&*/ Context) {
    InsertTempDtorDecisionBlock(Context, 
                             (CFGBlock /*P*/ )null);
  }
  private void InsertTempDtorDecisionBlock(final /*const*/ TempDtorContext /*&*/ Context, 
                             CFGBlock /*P*/ FalseSucc/*= null*/) {
    if (!(Context.TerminatorExpr != null)) {
      // If no temporary was found, we do not need to insert a decision point.
      return;
    }
    assert Native.$bool(Context.TerminatorExpr);
    CFGBlock /*P*/ Decision = createBlock(false);
    Decision.setTerminator(new CFGTerminator(Context.TerminatorExpr, true));
    addSuccessor(Decision, Block, !Context.KnownExecuted.isFalse());
    addSuccessor(Decision, (FalseSucc != null) ? FalseSucc : Context.Succ, 
        !Context.KnownExecuted.isTrue());
    Block = Decision;
  }

  
  // NYS == Not Yet Supported
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::NYS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 567,
   FQN="(anonymous namespace)::CFGBuilder::NYS", NM="_ZN12_GLOBAL__N_110CFGBuilder3NYSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder3NYSEv")
  //</editor-fold>
  private CFGBlock /*P*/ NYS() {
    badCFG = true;
    return Block;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::autoCreateBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 572,
   FQN="(anonymous namespace)::CFGBuilder::autoCreateBlock", NM="_ZN12_GLOBAL__N_110CFGBuilder15autoCreateBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15autoCreateBlockEv")
  //</editor-fold>
  private void autoCreateBlock() {
    if (!(Block != null)) {
      Block = createBlock();
    }
  }

  
  /// createBlock - Used to lazily create blocks that are connected
  ///  to the current (global) succcessor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::createBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1098,
   FQN="(anonymous namespace)::CFGBuilder::createBlock", NM="_ZN12_GLOBAL__N_110CFGBuilder11createBlockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder11createBlockEb")
  //</editor-fold>
  private CFGBlock /*P*/ createBlock() {
    return createBlock(true);
  }
  private CFGBlock /*P*/ createBlock(boolean add_successor/*= true*/) {
    CFGBlock /*P*/ B = cfg.$arrow().createBlock();
    if (add_successor && (Succ != null)) {
      addSuccessor(B, Succ);
    }
    return B;
  }

  
  /// createNoReturnBlock - Used to create a block is a 'noreturn' point in the
  /// CFG. It is *not* connected to the current (global) successor, and instead
  /// directly tied to the exit block in order to be reachable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::createNoReturnBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1108,
   FQN="(anonymous namespace)::CFGBuilder::createNoReturnBlock", NM="_ZN12_GLOBAL__N_110CFGBuilder19createNoReturnBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder19createNoReturnBlockEv")
  //</editor-fold>
  private CFGBlock /*P*/ createNoReturnBlock() {
    CFGBlock /*P*/ B = createBlock(false);
    B.setHasNoReturnElement();
    addSuccessor(B, $AddrOf(cfg.$arrow().getExit()), Succ);
    return B;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 576,
   FQN="(anonymous namespace)::CFGBuilder::addStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder7addStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder7addStmtEPN5clang4StmtE")
  //</editor-fold>
  private CFGBlock /*P*/ addStmt(Stmt /*P*/ S) {
    return Visit(S, new AddStmtChoice(AddStmtChoice.Kind.AlwaysAdd));
  }

  
  /// addInitializer - Add C++ base or member initializer element to CFG.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1116,
   FQN="(anonymous namespace)::CFGBuilder::addInitializer", NM="_ZN12_GLOBAL__N_110CFGBuilder14addInitializerEPN5clang18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder14addInitializerEPN5clang18CXXCtorInitializerE")
  //</editor-fold>
  private CFGBlock /*P*/ addInitializer(CXXCtorInitializer /*P*/ I) {
    if (!BuildOpts.AddInitializers) {
      return Block;
    }
    
    boolean HasTemporaries = false;
    
    // Destructors of temporaries in initialization expression should be called
    // after initialization finishes.
    Expr /*P*/ Init = I.getInit();
    if ((Init != null)) {
      HasTemporaries = isa_ExprWithCleanups(Init);
      if (BuildOpts.AddTemporaryDtors && HasTemporaries) {
        // Generate destructors for temporaries in initialization expression.
        TempDtorContext Context/*J*/= new TempDtorContext();
        VisitForTemporaryDtors(cast_ExprWithCleanups(Init).getSubExpr(), 
            /*BindToTemporary=*/ false, Context);
      }
    }
    
    autoCreateBlock();
    appendInitializer(Block, I);
    if ((Init != null)) {
      if (HasTemporaries) {
        // For expression with temporaries go directly to subexpression to omit
        // generating destructors for the second time.
        return Visit(cast_ExprWithCleanups(Init).getSubExpr());
      }
      if (BuildOpts.AddCXXDefaultInitExprInCtors) {
        {
          CXXDefaultInitExpr /*P*/ Default = dyn_cast_CXXDefaultInitExpr(Init);
          if ((Default != null)) {
            // In general, appending the expression wrapped by a CXXDefaultInitExpr
            // may cause the same Expr to appear more than once in the CFG. Doing it
            // here is safe because there's only one initializer per field.
            autoCreateBlock();
            appendStmt(Block, Default);
            {
              Stmt /*P*/ Child = Default.getExpr();
              if ((Child != null)) {
                {
                  CFGBlock /*P*/ R = Visit(Child);
                  if ((R != null)) {
                    Block = R;
                  }
                }
              }
            }
            return Block;
          }
        }
      }
      return Visit(Init);
    }
    
    return Block;
  }

  
  /// addAutomaticObjDtors - Add to current block automatic objects destructors
  /// for objects in range of local scope positions. Use S as trigger statement
  /// for destructors.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addAutomaticObjDtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1213,
   FQN="(anonymous namespace)::CFGBuilder::addAutomaticObjDtors", NM="_ZN12_GLOBAL__N_110CFGBuilder20addAutomaticObjDtorsENS_10LocalScope14const_iteratorES2_PN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder20addAutomaticObjDtorsENS_10LocalScope14const_iteratorES2_PN5clang4StmtE")
  //</editor-fold>
  private void addAutomaticObjDtors(LocalScope.const_iterator B, 
                      LocalScope.const_iterator E, Stmt /*P*/ S) {
    if (!BuildOpts.AddImplicitDtors) {
      return;
    }
    if (B.$eq(E)) {
      return;
    }
    
    // We need to append the destructors in reverse order, but any one of them
    // may be a no-return destructor which changes the CFG. As a result, buffer
    // this sequence up and replay them in reverse order when appending onto the
    // CFGBlock(s).
    SmallVector<VarDecl /*P*/ > Decls/*J*/= new SmallVector<VarDecl /*P*/ >(10, (VarDecl /*P*/ )null);
    Decls.reserve(B.distance(new LocalScope.const_iterator(E)));
    for (LocalScope.const_iterator I = new LocalScope.const_iterator(B); I.$noteq(E); I.$preInc())  {
      Decls.push_back(I.$star());
    }
    
    for (std.reverse_iterator<VarDecl /*P*/ > I = Decls.rbegin(), 
        E$1 = Decls.rend();
         $noteq_reverse_iterator$C(I, E$1); I.$preInc()) {
      // If this destructor is marked as a no-return destructor, we need to
      // create a new block for the destructor which does not have as a successor
      // anything built thus far: control won't flow out of this block.
      QualType Ty = (I.$star()).getType();
      if (Ty.$arrow().isReferenceType()) {
        Ty.$assignMove(getReferenceInitTemporaryType($Deref(Context), (I.$star()).getInit()));
      }
      Ty.$assignMove(Context.getBaseElementType(new QualType(Ty)));
      if (Ty.$arrow().getAsCXXRecordDecl().isAnyDestructorNoReturn()) {
        Block = createNoReturnBlock();
      } else {
        autoCreateBlock();
      }
      
      appendAutomaticObjDtor(Block, I.$star(), S);
    }
  }

  
  /// addImplicitDtorsForDestructor - Add implicit destructors generated for
  /// base and member objects in destructor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addImplicitDtorsForDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1253,
   FQN="(anonymous namespace)::CFGBuilder::addImplicitDtorsForDestructor", NM="_ZN12_GLOBAL__N_110CFGBuilder29addImplicitDtorsForDestructorEPKN5clang17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder29addImplicitDtorsForDestructorEPKN5clang17CXXDestructorDeclE")
  //</editor-fold>
  private void addImplicitDtorsForDestructor(/*const*/ CXXDestructorDecl /*P*/ DD) {
    assert (BuildOpts.AddImplicitDtors) : "Can be called only when dtors should be added";
    /*const*/ CXXRecordDecl /*P*/ RD = DD.getParent$Const();
    
    // At the end destroy virtual base objects.
    for (final /*const*/ CXXBaseSpecifier /*&*/ VI : RD.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ CD = VI.getType().$arrow().getAsCXXRecordDecl();
      if (!CD.hasTrivialDestructor()) {
        autoCreateBlock();
        appendBaseDtor(Block, $AddrOf(VI));
      }
    }
    
    // Before virtual bases destroy direct base objects.
    for (final /*const*/ CXXBaseSpecifier /*&*/ BI : RD.bases$Const()) {
      if (!BI.isVirtual()) {
        /*const*/ CXXRecordDecl /*P*/ CD = BI.getType().$arrow().getAsCXXRecordDecl();
        if (!CD.hasTrivialDestructor()) {
          autoCreateBlock();
          appendBaseDtor(Block, $AddrOf(BI));
        }
      }
    }
    
    // First destroy member objects.
    for (FieldDecl /*P*/ FI : RD.fields()) {
      // Check for constant size array. Set type to array element type.
      QualType QT = FI.getType();
      {
        /*const*/ ConstantArrayType /*P*/ AT = Context.getAsConstantArrayType(new QualType(QT));
        if ((AT != null)) {
          if (AT.getSize().$eq($int2ulong(0))) {
            continue;
          }
          QT.$assignMove(AT.getElementType());
        }
      }
      {
        
        /*const*/ CXXRecordDecl /*P*/ CD = QT.$arrow().getAsCXXRecordDecl();
        if ((CD != null)) {
          if (!CD.hasTrivialDestructor()) {
            autoCreateBlock();
            appendMemberDtor(Block, FI);
          }
        }
      }
    }
  }

  
  // Local scopes creation.
  
  /// createOrReuseLocalScope - If Scope is NULL create new LocalScope. Either
  /// way return valid LocalScope object.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::createOrReuseLocalScope">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1298,
   FQN="(anonymous namespace)::CFGBuilder::createOrReuseLocalScope", NM="_ZN12_GLOBAL__N_110CFGBuilder23createOrReuseLocalScopeEPNS_10LocalScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder23createOrReuseLocalScopeEPNS_10LocalScopeE")
  //</editor-fold>
  private LocalScope /*P*/ createOrReuseLocalScope(LocalScope /*P*/ Scope) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ((Scope != null)) {
        return Scope;
      }
      final BumpPtrAllocatorImpl /*&*/ alloc = cfg.$arrow().getAllocator();
      Object Mem = alloc./*<LocalScope>*/Allocate$T(LocalScope.class);
      return $c$.clean(/*NEW_EXPR [System]*//*Mem = *//*new (alloc.Allocate<LocalScope>())*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
          return new LocalScope($c$.track(new BumpVectorContext(alloc)), new LocalScope.const_iterator(ScopePos));
       }));
    } finally {
      $c$.$destroy();
    }
  }

  
  
  /// addLocalScopeForStmt - Add LocalScope to local scopes tree for statement
  /// that should create implicit scope (e.g. if/else substatements). 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addLocalScopeForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1308,
   FQN="(anonymous namespace)::CFGBuilder::addLocalScopeForStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder20addLocalScopeForStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder20addLocalScopeForStmtEPN5clang4StmtE")
  //</editor-fold>
  private void addLocalScopeForStmt(Stmt /*P*/ S) {
    if (!BuildOpts.AddImplicitDtors) {
      return;
    }
    
    LocalScope /*P*/ Scope = null;
    {
      
      // For compound statement we will be creating explicit scope.
      CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(S);
      if ((CS != null)) {
        for (Stmt /*P*/ BI : CS.body()) {
          Stmt /*P*/ SI = BI.stripLabelLikeStatements();
          {
            DeclStmt /*P*/ DS = dyn_cast_DeclStmt(SI);
            if ((DS != null)) {
              Scope = addLocalScopeForDeclStmt(DS, Scope);
            }
          }
        }
        return;
      }
    }
    {
      
      // For any other statement scope will be implicit and as such will be
      // interesting only for DeclStmt.
      DeclStmt /*P*/ DS = dyn_cast_DeclStmt(S.stripLabelLikeStatements());
      if ((DS != null)) {
        addLocalScopeForDeclStmt(DS);
      }
    }
  }

  
  /// addLocalScopeForDeclStmt - Add LocalScope for declaration statement. Will
  /// reuse Scope if not NULL.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addLocalScopeForDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1332,
   FQN="(anonymous namespace)::CFGBuilder::addLocalScopeForDeclStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder24addLocalScopeForDeclStmtEPN5clang8DeclStmtEPNS_10LocalScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder24addLocalScopeForDeclStmtEPN5clang8DeclStmtEPNS_10LocalScopeE")
  //</editor-fold>
  private LocalScope /*P*/ addLocalScopeForDeclStmt(DeclStmt /*P*/ DS) {
    return addLocalScopeForDeclStmt(DS, 
                          (LocalScope /*P*/ )null);
  }
  private LocalScope /*P*/ addLocalScopeForDeclStmt(DeclStmt /*P*/ DS, 
                          LocalScope /*P*/ Scope/*= null*/) {
    if (!BuildOpts.AddImplicitDtors) {
      return Scope;
    }
    
    for (Decl /*P*/ DI : DS.decls())  {
      {
        VarDecl /*P*/ VD = dyn_cast_VarDecl(DI);
        if ((VD != null)) {
          Scope = addLocalScopeForVarDecl(VD, Scope);
        }
      }
    }
    return Scope;
  }

  
  /// addLocalScopeForVarDecl - Add LocalScope for variable declaration. It will
  /// create add scope for automatic objects and temporary objects bound to
  /// const reference. Will reuse Scope if not NULL.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addLocalScopeForVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1346,
   FQN="(anonymous namespace)::CFGBuilder::addLocalScopeForVarDecl", NM="_ZN12_GLOBAL__N_110CFGBuilder23addLocalScopeForVarDeclEPN5clang7VarDeclEPNS_10LocalScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder23addLocalScopeForVarDeclEPN5clang7VarDeclEPNS_10LocalScopeE")
  //</editor-fold>
  private LocalScope /*P*/ addLocalScopeForVarDecl(VarDecl /*P*/ VD) {
    return addLocalScopeForVarDecl(VD, 
                         (LocalScope /*P*/ )null);
  }
  private LocalScope /*P*/ addLocalScopeForVarDecl(VarDecl /*P*/ VD, 
                         LocalScope /*P*/ Scope/*= null*/) {
    if (!BuildOpts.AddImplicitDtors) {
      return Scope;
    }
    
    // Check if variable is local.
    switch (VD.getStorageClass()) {
     case SC_None:
     case SC_Auto:
     case SC_Register:
      break;
     default:
      return Scope;
    }
    
    // Check for const references bound to temporary. Set type to pointee.
    QualType QT = VD.getType();
    if (QT.getTypePtr().isReferenceType()) {
      // Attempt to determine whether this declaration lifetime-extends a
      // temporary.
      //
      // FIXME: This is incorrect. Non-reference declarations can lifetime-extend
      // temporaries, and a single declaration can extend multiple temporaries.
      // We should look at the storage duration on each nested
      // MaterializeTemporaryExpr instead.
      /*const*/ Expr /*P*/ Init = VD.getInit();
      if (!(Init != null)) {
        return Scope;
      }
      {
        /*const*/ ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(Init);
        if ((EWC != null)) {
          Init = EWC.getSubExpr$Const();
        }
      }
      if (!isa_MaterializeTemporaryExpr(Init)) {
        return Scope;
      }
      
      // Lifetime-extending a temporary.
      QT.$assignMove(getReferenceInitTemporaryType($Deref(Context), Init));
    }
    {
      
      // Check for constant size array. Set type to array element type.
      /*const*/ ConstantArrayType /*P*/ AT;
      while (((/*P*/ AT = Context.getAsConstantArrayType(new QualType(QT))) != null)) {
        if (AT.getSize().$eq($int2ulong(0))) {
          return Scope;
        }
        QT.$assignMove(AT.getElementType());
      }
    }
    {
      
      // Check if type is a C++ class with non-trivial destructor.
      /*const*/ CXXRecordDecl /*P*/ CD = QT.$arrow().getAsCXXRecordDecl();
      if ((CD != null)) {
        if (!CD.hasTrivialDestructor()) {
          // Add the variable to scope
          Scope = createOrReuseLocalScope(Scope);
          Scope.addVar(VD);
          ScopePos.$assignMove(Scope.begin());
        }
      }
    }
    return Scope;
  }

  
  
  /// addLocalScopeAndDtors - For given statement add local scope for it and
  /// add destructors that will cleanup the scope. Will reuse Scope if not NULL.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addLocalScopeAndDtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1402,
   FQN="(anonymous namespace)::CFGBuilder::addLocalScopeAndDtors", NM="_ZN12_GLOBAL__N_110CFGBuilder21addLocalScopeAndDtorsEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder21addLocalScopeAndDtorsEPN5clang4StmtE")
  //</editor-fold>
  private void addLocalScopeAndDtors(Stmt /*P*/ S) {
    if (!BuildOpts.AddImplicitDtors) {
      return;
    }
    
    LocalScope.const_iterator scopeBeginPos = new LocalScope.const_iterator(ScopePos);
    addLocalScopeForStmt(S);
    addAutomaticObjDtors(new LocalScope.const_iterator(ScopePos), new LocalScope.const_iterator(scopeBeginPos), S);
  }

  
  // Interface to CFGBlock - adding CFGElements.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::appendStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 595,
   FQN="(anonymous namespace)::CFGBuilder::appendStmt", NM="_ZN12_GLOBAL__N_110CFGBuilder10appendStmtEPN5clang8CFGBlockEPKNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder10appendStmtEPN5clang8CFGBlockEPKNS1_4StmtE")
  //</editor-fold>
  private void appendStmt(CFGBlock /*P*/ B, /*const*/ Stmt /*P*/ S) {
    if (alwaysAdd(S) && (cachedEntry != null)) {
      cachedEntry.second = B;
    }
    
    // All block-level expressions should have already been IgnoreParens()ed.
    assert (!isa_Expr(S) || cast_Expr(S).IgnoreParens$Const() == S);
    B.appendStmt(((/*const_cast*/Stmt /*P*/ )(S)), cfg.$arrow().getBumpVectorContext());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::appendInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 603,
   FQN="(anonymous namespace)::CFGBuilder::appendInitializer", NM="_ZN12_GLOBAL__N_110CFGBuilder17appendInitializerEPN5clang8CFGBlockEPNS1_18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder17appendInitializerEPN5clang8CFGBlockEPNS1_18CXXCtorInitializerE")
  //</editor-fold>
  private void appendInitializer(CFGBlock /*P*/ B, CXXCtorInitializer /*P*/ I) {
    B.appendInitializer(I, cfg.$arrow().getBumpVectorContext());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::appendNewAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 606,
   FQN="(anonymous namespace)::CFGBuilder::appendNewAllocator", NM="_ZN12_GLOBAL__N_110CFGBuilder18appendNewAllocatorEPN5clang8CFGBlockEPNS1_10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder18appendNewAllocatorEPN5clang8CFGBlockEPNS1_10CXXNewExprE")
  //</editor-fold>
  private void appendNewAllocator(CFGBlock /*P*/ B, CXXNewExpr /*P*/ NE) {
    B.appendNewAllocator(NE, cfg.$arrow().getBumpVectorContext());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::appendBaseDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 609,
   FQN="(anonymous namespace)::CFGBuilder::appendBaseDtor", NM="_ZN12_GLOBAL__N_110CFGBuilder14appendBaseDtorEPN5clang8CFGBlockEPKNS1_16CXXBaseSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder14appendBaseDtorEPN5clang8CFGBlockEPKNS1_16CXXBaseSpecifierE")
  //</editor-fold>
  private void appendBaseDtor(CFGBlock /*P*/ B, /*const*/ CXXBaseSpecifier /*P*/ BS) {
    B.appendBaseDtor(BS, cfg.$arrow().getBumpVectorContext());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::appendMemberDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 612,
   FQN="(anonymous namespace)::CFGBuilder::appendMemberDtor", NM="_ZN12_GLOBAL__N_110CFGBuilder16appendMemberDtorEPN5clang8CFGBlockEPNS1_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder16appendMemberDtorEPN5clang8CFGBlockEPNS1_9FieldDeclE")
  //</editor-fold>
  private void appendMemberDtor(CFGBlock /*P*/ B, FieldDecl /*P*/ FD) {
    B.appendMemberDtor(FD, cfg.$arrow().getBumpVectorContext());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::appendTemporaryDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 615,
   FQN="(anonymous namespace)::CFGBuilder::appendTemporaryDtor", NM="_ZN12_GLOBAL__N_110CFGBuilder19appendTemporaryDtorEPN5clang8CFGBlockEPNS1_20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder19appendTemporaryDtorEPN5clang8CFGBlockEPNS1_20CXXBindTemporaryExprE")
  //</editor-fold>
  private void appendTemporaryDtor(CFGBlock /*P*/ B, CXXBindTemporaryExpr /*P*/ E) {
    B.appendTemporaryDtor(E, cfg.$arrow().getBumpVectorContext());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::appendAutomaticObjDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 618,
   FQN="(anonymous namespace)::CFGBuilder::appendAutomaticObjDtor", NM="_ZN12_GLOBAL__N_110CFGBuilder22appendAutomaticObjDtorEPN5clang8CFGBlockEPNS1_7VarDeclEPNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder22appendAutomaticObjDtorEPN5clang8CFGBlockEPNS1_7VarDeclEPNS1_4StmtE")
  //</editor-fold>
  private void appendAutomaticObjDtor(CFGBlock /*P*/ B, VarDecl /*P*/ VD, Stmt /*P*/ S) {
    B.appendAutomaticObjDtor(VD, S, cfg.$arrow().getBumpVectorContext());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::appendDeleteDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 622,
   FQN="(anonymous namespace)::CFGBuilder::appendDeleteDtor", NM="_ZN12_GLOBAL__N_110CFGBuilder16appendDeleteDtorEPN5clang8CFGBlockEPNS1_13CXXRecordDeclEPNS1_13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder16appendDeleteDtorEPN5clang8CFGBlockEPNS1_13CXXRecordDeclEPNS1_13CXXDeleteExprE")
  //</editor-fold>
  private void appendDeleteDtor(CFGBlock /*P*/ B, CXXRecordDecl /*P*/ RD, CXXDeleteExpr /*P*/ DE) {
    B.appendDeleteDtor(RD, DE, cfg.$arrow().getBumpVectorContext());
  }

  
  
  /// prependAutomaticObjDtorsWithTerminator - Prepend destructor CFGElements for
  /// variables with automatic storage duration to CFGBlock's elements vector.
  /// Elements will be prepended to physical beginning of the vector which
  /// happens to be logical end. Use blocks terminator as statement that specifies
  /// destructors call site.
  /// FIXME: This mechanism for adding automatic destructors doesn't handle
  /// no-return destructors properly.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::prependAutomaticObjDtorsWithTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 1418,
   FQN="(anonymous namespace)::CFGBuilder::prependAutomaticObjDtorsWithTerminator", NM="_ZN12_GLOBAL__N_110CFGBuilder38prependAutomaticObjDtorsWithTerminatorEPN5clang8CFGBlockENS_10LocalScope14const_iteratorES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder38prependAutomaticObjDtorsWithTerminatorEPN5clang8CFGBlockENS_10LocalScope14const_iteratorES5_")
  //</editor-fold>
  private void prependAutomaticObjDtorsWithTerminator(CFGBlock /*P*/ Blk, 
                                        LocalScope.const_iterator B, LocalScope.const_iterator E) {
    final BumpVectorContext /*&*/ C = cfg.$arrow().getBumpVectorContext();
    std.reverse_iterator<CFGElement> InsertPos = Blk.beginAutomaticObjDtorsInsert(Blk.end(), B.distance(new LocalScope.const_iterator(E)), C);
    for (LocalScope.const_iterator I = new LocalScope.const_iterator(B); I.$noteq(E); I.$preInc())  {
      InsertPos.$assign(Blk.insertAutomaticObjDtor(new std.reverse_iterator<CFGElement>(InsertPos), I.$star(), 
              Blk.getTerminator().$Stmt$P()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 629,
   FQN="(anonymous namespace)::CFGBuilder::addSuccessor", NM="_ZN12_GLOBAL__N_110CFGBuilder12addSuccessorEPN5clang8CFGBlockES3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder12addSuccessorEPN5clang8CFGBlockES3_b")
  //</editor-fold>
  private void addSuccessor(CFGBlock /*P*/ B, CFGBlock /*P*/ S) {
    addSuccessor(B, S, true);
  }
  private void addSuccessor(CFGBlock /*P*/ B, CFGBlock /*P*/ S, boolean IsReachable/*= true*/) {
    B.addSuccessor(new CFGBlock.AdjacentBlock(S, IsReachable), 
        cfg.$arrow().getBumpVectorContext());
  }

  
  /// Add a reachable successor to a block, with the alternate variant that is
  /// unreachable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::addSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 636,
   FQN="(anonymous namespace)::CFGBuilder::addSuccessor", NM="_ZN12_GLOBAL__N_110CFGBuilder12addSuccessorEPN5clang8CFGBlockES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder12addSuccessorEPN5clang8CFGBlockES3_S3_")
  //</editor-fold>
  private void addSuccessor(CFGBlock /*P*/ B, CFGBlock /*P*/ ReachableBlock, CFGBlock /*P*/ AltBlock) {
    B.addSuccessor(new CFGBlock.AdjacentBlock(ReachableBlock, AltBlock), 
        cfg.$arrow().getBumpVectorContext());
  }

  
  /// \brief Find a relational comparison with an expression evaluating to a
  /// boolean and a constant other than 0 and 1.
  /// e.g. if ((x < y) == 10)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::checkIncorrectRelationalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 644,
   FQN="(anonymous namespace)::CFGBuilder::checkIncorrectRelationalOperator", NM="_ZN12_GLOBAL__N_110CFGBuilder32checkIncorrectRelationalOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder32checkIncorrectRelationalOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  private TryResult checkIncorrectRelationalOperator(/*const*/ BinaryOperator /*P*/ B) {
    /*const*/ Expr /*P*/ LHSExpr = B.getLHS().IgnoreParens();
    /*const*/ Expr /*P*/ RHSExpr = B.getRHS().IgnoreParens();
    
    /*const*/ IntegerLiteral /*P*/ IntLiteral = dyn_cast_IntegerLiteral(LHSExpr);
    /*const*/ Expr /*P*/ BoolExpr = RHSExpr;
    boolean IntFirst = true;
    if (!(IntLiteral != null)) {
      IntLiteral = dyn_cast_IntegerLiteral(RHSExpr);
      BoolExpr = LHSExpr;
      IntFirst = false;
    }
    if (!(IntLiteral != null) || !BoolExpr.isKnownToHaveBooleanValue()) {
      return new TryResult();
    }
    
    APInt IntValue = IntLiteral.getValue();
    if ((IntValue.$eq($int2ulong(1))) || (IntValue.$eq($int2ulong(0)))) {
      return new TryResult();
    }
    
    boolean IntLarger = IntLiteral.getType().$arrow().isUnsignedIntegerType()
       || !IntValue.isNegative();
    
    BinaryOperatorKind Bok = B.getOpcode();
    if (Bok == BinaryOperatorKind.BO_GT || Bok == BinaryOperatorKind.BO_GE) {
      // Always true for 10 > bool and bool > -1
      // Always false for -1 > bool and bool > 10
      return new TryResult(IntFirst == IntLarger);
    } else {
      // Always true for -1 < bool and bool < 10
      // Always false for 10 < bool and bool < -1
      return new TryResult(IntFirst != IntLarger);
    }
  }

  
  /// Find an incorrect equality comparison. Either with an expression
  /// evaluating to a boolean and a constant other than 0 and 1.
  /// e.g. if (!x == 10) or a bitwise and/or operation that always evaluates to
  /// true/false e.q. (x & 8) == 4.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::checkIncorrectEqualityOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 683,
   FQN="(anonymous namespace)::CFGBuilder::checkIncorrectEqualityOperator", NM="_ZN12_GLOBAL__N_110CFGBuilder30checkIncorrectEqualityOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder30checkIncorrectEqualityOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  private TryResult checkIncorrectEqualityOperator(/*const*/ BinaryOperator /*P*/ B) {
    /*const*/ Expr /*P*/ LHSExpr = B.getLHS().IgnoreParens();
    /*const*/ Expr /*P*/ RHSExpr = B.getRHS().IgnoreParens();
    
    /*const*/ IntegerLiteral /*P*/ IntLiteral = dyn_cast_IntegerLiteral(LHSExpr);
    /*const*/ Expr /*P*/ BoolExpr = RHSExpr;
    if (!(IntLiteral != null)) {
      IntLiteral = dyn_cast_IntegerLiteral(RHSExpr);
      BoolExpr = LHSExpr;
    }
    if (!(IntLiteral != null)) {
      return new TryResult();
    }
    
    /*const*/ BinaryOperator /*P*/ BitOp = dyn_cast_BinaryOperator(BoolExpr);
    if ((BitOp != null) && (BitOp.getOpcode() == BinaryOperatorKind.BO_And
       || BitOp.getOpcode() == BinaryOperatorKind.BO_Or)) {
      /*const*/ Expr /*P*/ LHSExpr2 = BitOp.getLHS().IgnoreParens();
      /*const*/ Expr /*P*/ RHSExpr2 = BitOp.getRHS().IgnoreParens();
      
      /*const*/ IntegerLiteral /*P*/ IntLiteral2 = dyn_cast_IntegerLiteral(LHSExpr2);
      if (!(IntLiteral2 != null)) {
        IntLiteral2 = dyn_cast_IntegerLiteral(RHSExpr2);
      }
      if (!(IntLiteral2 != null)) {
        return new TryResult();
      }
      
      APInt L1 = IntLiteral.getValue();
      APInt L2 = IntLiteral2.getValue();
      if ((BitOp.getOpcode() == BinaryOperatorKind.BO_And && (L2.$bitand(L1)).$noteq(L1))
         || (BitOp.getOpcode() == BinaryOperatorKind.BO_Or && (L2.$bitor(L1)).$noteq(L1))) {
        if ((BuildOpts.Observer != null)) {
          BuildOpts.Observer.compareBitwiseEquality(B, 
              B.getOpcode() != BinaryOperatorKind.BO_EQ);
        }
        new TryResult(B.getOpcode() != BinaryOperatorKind.BO_EQ);
      }
    } else if (BoolExpr.isKnownToHaveBooleanValue()) {
      APInt IntValue = IntLiteral.getValue();
      if ((IntValue.$eq($int2ulong(1))) || (IntValue.$eq($int2ulong(0)))) {
        return new TryResult();
      }
      return new TryResult(B.getOpcode() != BinaryOperatorKind.BO_EQ);
    }
    
    return new TryResult();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::analyzeLogicOperatorCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 732,
   FQN="(anonymous namespace)::CFGBuilder::analyzeLogicOperatorCondition", NM="_ZN12_GLOBAL__N_110CFGBuilder29analyzeLogicOperatorConditionEN5clang18BinaryOperatorKindERKN4llvm6APSIntES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder29analyzeLogicOperatorConditionEN5clang18BinaryOperatorKindERKN4llvm6APSIntES6_")
  //</editor-fold>
  private TryResult analyzeLogicOperatorCondition(BinaryOperatorKind Relation, 
                               final /*const*/ APSInt /*&*/ Value1, 
                               final /*const*/ APSInt /*&*/ Value2) {
    assert (Value1.isSigned() == Value2.isSigned());
    switch (Relation) {
     default:
      return new TryResult();
     case BO_EQ:
      return new TryResult(Value1.$eq(Value2));
     case BO_NE:
      return new TryResult(Value1.$noteq(Value2));
     case BO_LT:
      return new TryResult(Value1.$less(Value2));
     case BO_LE:
      return new TryResult(Value1.$lesseq(Value2));
     case BO_GT:
      return new TryResult(Value1.$greater(Value2));
     case BO_GE:
      return new TryResult(Value1.$greatereq(Value2));
    }
  }

  
  /// \brief Find a pair of comparison expressions with or without parentheses
  /// with a shared variable and constants and a logical operator between them
  /// that always evaluates to either true or false.
  /// e.g. if (x != 3 || x != 4)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::checkIncorrectLogicOperator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 758,
   FQN="(anonymous namespace)::CFGBuilder::checkIncorrectLogicOperator", NM="_ZN12_GLOBAL__N_110CFGBuilder27checkIncorrectLogicOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder27checkIncorrectLogicOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  private TryResult checkIncorrectLogicOperator(/*const*/ BinaryOperator /*P*/ B) {
    assert (B.isLogicalOp());
    /*const*/ BinaryOperator /*P*/ LHS = dyn_cast_BinaryOperator(B.getLHS().IgnoreParens());
    /*const*/ BinaryOperator /*P*/ RHS = dyn_cast_BinaryOperator(B.getRHS().IgnoreParens());
    if (!(LHS != null) || !(RHS != null)) {
      return new TryResult();
    }
    if (!LHS.isComparisonOp() || !RHS.isComparisonOp()) {
      return new TryResult();
    }
    
    tuple tmp = tryNormalizeBinaryOperator(LHS);
    /*const*/ DeclRefExpr /*P*/ Decl1 = (DeclRefExpr) tmp.$getAt(0);
    BinaryOperatorKind BO1 = (BinaryOperatorKind) tmp.$getAt(1);
    /*const*/ Expr /*P*/ Expr1 = (Expr) tmp.$getAt(2);
    //std.tie(Decl1, BO1, Expr1).$assign_tuple(tryNormalizeBinaryOperator(LHS));
    if (!(Decl1 != null) || !(Expr1 != null)) {
      return new TryResult();
    }
    
    tmp = tryNormalizeBinaryOperator(RHS);
    /*const*/ DeclRefExpr /*P*/ Decl2 = (DeclRefExpr) tmp.$getAt(0);
    BinaryOperatorKind BO2 = (BinaryOperatorKind) tmp.$getAt(1);
    /*const*/ Expr /*P*/ Expr2 = (Expr) tmp.$getAt(2);
    //std.tie(Decl2, BO2, Expr2).$assign_tuple(tryNormalizeBinaryOperator(RHS));
    if (!(Decl2 != null) || !(Expr2 != null)) {
      return new TryResult();
    }
    
    // Check that it is the same variable on both sides.
    if (Decl1.getDecl$Const() != Decl2.getDecl$Const()) {
      return new TryResult();
    }
    
    // Make sure the user's intent is clear (e.g. they're comparing against two
    // int literals, or two things from the same enum)
    if (!areExprTypesCompatible(Expr1, Expr2)) {
      return new TryResult();
    }
    
    APSInt L1/*J*/= new APSInt();
    APSInt L2/*J*/= new APSInt();
    if (!Expr1.EvaluateAsInt(L1, $Deref(Context))
       || !Expr2.EvaluateAsInt(L2, $Deref(Context))) {
      return new TryResult();
    }
    
    // Can't compare signed with unsigned or with different bit width.
    if (L1.isSigned() != L2.isSigned() || L1.getBitWidth() != L2.getBitWidth()) {
      return new TryResult();
    }
    
    // Values that will be used to determine if result of logical
    // operator is always true/false
    /*const*/ APSInt Values[/*5*/] = new /*const*/ APSInt [/*5*/] {
      // Value less than both Value1 and Value2
      APSInt.getMinValue(L1.getBitWidth(), L1.isUnsigned()), 
      // L1
      L1, 
      // Value between Value1 and Value2
      ((L1.$less(L2)) ? L1 : L2).$add(new APSInt(new APInt(L1.getBitWidth(), $int2ulong(1)), 
              L1.isUnsigned())), 
      // L2
      L2, 
      // Value greater than both Value1 and Value2
      APSInt.getMaxValue(L1.getBitWidth(), L1.isUnsigned())
    };
    
    // Check whether expression is always true/false by evaluating the following
    // * variable x is less than the smallest literal.
    // * variable x is equal to the smallest literal.
    // * Variable x is between smallest and largest literal.
    // * Variable x is equal to the largest literal.
    // * Variable x is greater than largest literal.
    boolean AlwaysTrue = true;
    boolean AlwaysFalse = true;
    for (final /*const*/ APSInt /*&*/ Value : Values) {
      TryResult Res1/*J*/= new TryResult();
      TryResult Res2/*J*/= new TryResult();
      Res1.$assignMove(analyzeLogicOperatorCondition(BO1, Value, L1));
      Res2.$assignMove(analyzeLogicOperatorCondition(BO2, Value, L2));
      if (!Res1.isKnown() || !Res2.isKnown()) {
        return new TryResult();
      }
      if (B.getOpcode() == BinaryOperatorKind.BO_LAnd) {
        AlwaysTrue &= (Res1.isTrue() && Res2.isTrue());
        AlwaysFalse &= !(Res1.isTrue() && Res2.isTrue());
      } else {
        AlwaysTrue &= (Res1.isTrue() || Res2.isTrue());
        AlwaysFalse &= !(Res1.isTrue() || Res2.isTrue());
      }
    }
    if (AlwaysTrue || AlwaysFalse) {
      if ((BuildOpts.Observer != null)) {
        BuildOpts.Observer.compareAlwaysTrue(B, AlwaysTrue);
      }
      return new TryResult(AlwaysTrue);
    }
    return new TryResult();
  }

  
  /// Try and evaluate an expression to an integer constant.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::tryEvaluate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 854,
   FQN="(anonymous namespace)::CFGBuilder::tryEvaluate", NM="_ZN12_GLOBAL__N_110CFGBuilder11tryEvaluateEPN5clang4ExprERNS2_10EvalResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder11tryEvaluateEPN5clang4ExprERNS2_10EvalResultE")
  //</editor-fold>
  private boolean tryEvaluate(Expr /*P*/ S, final Expr.EvalResult /*&*/ outResult) {
    if (!BuildOpts.PruneTriviallyFalseEdges) {
      return false;
    }
    return !S.isTypeDependent()
       && !S.isValueDependent()
       && S.EvaluateAsRValue(outResult, $Deref(Context));
  }

  
  /// tryEvaluateBool - Try and evaluate the Stmt and return 0 or 1
  /// if we can evaluate to a known value, otherwise return -1.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::tryEvaluateBool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 864,
   FQN="(anonymous namespace)::CFGBuilder::tryEvaluateBool", NM="_ZN12_GLOBAL__N_110CFGBuilder15tryEvaluateBoolEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder15tryEvaluateBoolEPN5clang4ExprE")
  //</editor-fold>
  private TryResult tryEvaluateBool(Expr /*P*/ S) {
    if (!BuildOpts.PruneTriviallyFalseEdges
       || S.isTypeDependent() || S.isValueDependent()) {
      return new TryResult();
    }
    {
      
      BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(S);
      if ((Bop != null)) {
        if (Bop.isLogicalOp()) {
          // Check the cache first.
          DenseMapIterator<Expr /*P*/ , TryResult> I = CachedBoolEvals.find(S);
          if (I.$noteq(/*NO_ITER_COPY*/CachedBoolEvals.end())) {
            return new TryResult(I.$arrow().second); // already in map;
          }
          
          // Retrieve result at first, or the map might be updated.
          TryResult Result = evaluateAsBooleanConditionNoCache(S);
          CachedBoolEvals.$at_T1$C$R(S).$assign(Result); // update or insert
          return Result;
        } else {
          switch (Bop.getOpcode()) {
           default:
            break;
           case BO_Mul:
           case BO_And:
            {
              // If either operand is zero, we know the value
              // must be false.
              APSInt IntVal/*J*/= new APSInt();
              if (Bop.getLHS().EvaluateAsInt(IntVal, $Deref(Context))) {
                if (!IntVal.getBoolValue()) {
                  return new TryResult(false);
                }
              }
              if (Bop.getRHS().EvaluateAsInt(IntVal, $Deref(Context))) {
                if (!IntVal.getBoolValue()) {
                  return new TryResult(false);
                }
              }
            }
            break;
          }
        }
      }
    }
    
    return evaluateAsBooleanConditionNoCache(S);
  }

  
  /// \brief Evaluate as boolean \param E without using the cache.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::evaluateAsBooleanConditionNoCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 911,
   FQN="(anonymous namespace)::CFGBuilder::evaluateAsBooleanConditionNoCache", NM="_ZN12_GLOBAL__N_110CFGBuilder33evaluateAsBooleanConditionNoCacheEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilder33evaluateAsBooleanConditionNoCacheEPN5clang4ExprE")
  //</editor-fold>
  private TryResult evaluateAsBooleanConditionNoCache(Expr /*P*/ E) {
    {
      BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(E);
      if ((Bop != null)) {
        if (Bop.isLogicalOp()) {
          TryResult LHS = tryEvaluateBool(Bop.getLHS());
          if (LHS.isKnown()) {
            // We were able to evaluate the LHS, see if we can get away with not
            // evaluating the RHS: 0 && X -> 0, 1 || X -> 1
            if (LHS.isTrue() == (Bop.getOpcode() == BinaryOperatorKind.BO_LOr)) {
              return new TryResult(LHS.isTrue());
            }
            
            TryResult RHS = tryEvaluateBool(Bop.getRHS());
            if (RHS.isKnown()) {
              if (Bop.getOpcode() == BinaryOperatorKind.BO_LOr) {
                return new TryResult(LHS.isTrue() || RHS.isTrue());
              } else {
                return new TryResult(LHS.isTrue() && RHS.isTrue());
              }
            }
          } else {
            TryResult RHS = tryEvaluateBool(Bop.getRHS());
            if (RHS.isKnown()) {
              // We can't evaluate the LHS; however, sometimes the result
              // is determined by the RHS: X && 0 -> 0, X || 1 -> 1.
              if (RHS.isTrue() == (Bop.getOpcode() == BinaryOperatorKind.BO_LOr)) {
                return new TryResult(RHS.isTrue());
              }
            } else {
              TryResult BopRes = checkIncorrectLogicOperator(Bop);
              if (BopRes.isKnown()) {
                return new TryResult(BopRes.isTrue());
              }
            }
          }
          
          return new TryResult();
        } else if (Bop.isEqualityOp()) {
          TryResult BopRes = checkIncorrectEqualityOperator(Bop);
          if (BopRes.isKnown()) {
            return new TryResult(BopRes.isTrue());
          }
        } else if (Bop.isRelationalOp()) {
          TryResult BopRes = checkIncorrectRelationalOperator(Bop);
          if (BopRes.isKnown()) {
            return new TryResult(BopRes.isTrue());
          }
        }
      }
    }
    
    bool$ref Result = create_bool$ref();
    if (E.EvaluateAsBooleanCondition(Result, $Deref(Context))) {
      return new TryResult(Result.$deref());
    }
    
    return new TryResult();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBuilder::~CFGBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 366,
   FQN="(anonymous namespace)::CFGBuilder::~CFGBuilder", NM="_ZN12_GLOBAL__N_110CFGBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110CFGBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CachedBoolEvals.$destroy();
    AddressTakenLabels.$destroy();
    BackpatchBlocks.$destroy();
    LabelMap.$destroy();
    cfg.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private type$ref<CFGBlock /*P*/> Block$ref = new type$ref<CFGBlock /*P*/>(){
    @Override
    public CFGBlock $deref() {
      return Block;
    }
  
    @Override
    public CFGBlock $set(CFGBlock value) {
      Block = value;
      return Block;
    }
  };
  private type$ref<CFGBlock /*P*/> Succ$ref = new type$ref<CFGBlock /*P*/>(){
    @Override
    public CFGBlock $deref() {
      return Succ;
    }
  
    @Override
    public CFGBlock $set(CFGBlock value) {
      Succ = value;
      return Succ;
    }
  };
  private type$ref<BlockScopePosPair> ContinueJumpTarget$ref = new type$ref<BlockScopePosPair>(){
    @Override
    public BlockScopePosPair $deref() {
      return ContinueJumpTarget;
    }
  
    @Override
    public BlockScopePosPair $set(BlockScopePosPair value) {
      ContinueJumpTarget.$assign(value);
      return ContinueJumpTarget;
    }
  };
  private type$ref<BlockScopePosPair> BreakJumpTarget$ref = new type$ref<BlockScopePosPair>(){
    @Override
    public BlockScopePosPair $deref() {
      return BreakJumpTarget;
    }
  
    @Override
    public BlockScopePosPair $set(BlockScopePosPair value) {
      BreakJumpTarget.$assign(value);
      return BreakJumpTarget;
    }
  };
  private type$ref<CFGBlock /*P*/> SwitchTerminatedBlock$ref = new type$ref<CFGBlock /*P*/>(){
    @Override
    public CFGBlock $deref() {
      return SwitchTerminatedBlock;
    }
  
    @Override
    public CFGBlock $set(CFGBlock value) {
      SwitchTerminatedBlock = value;
      return SwitchTerminatedBlock;
    }
  };
  private type$ref<CFGBlock /*P*/> DefaultCaseBlock$ref = new type$ref<CFGBlock /*P*/>(){
    @Override
    public CFGBlock $deref() {
      return DefaultCaseBlock;
    }
  
    @Override
    public CFGBlock $set(CFGBlock value) {
      DefaultCaseBlock = value;
      return DefaultCaseBlock;
    }
  };
  private type$ref<CFGBlock /*P*/> TryTerminatedBlock$ref = new type$ref<CFGBlock /*P*/>(){
    @Override
    public CFGBlock $deref() {
      return TryTerminatedBlock;
    }
  
    @Override
    public CFGBlock $set(CFGBlock value) {
      TryTerminatedBlock = value;
      return TryTerminatedBlock;
    }
  };
  
  private type$ref<LocalScope.const_iterator> ScopePos$ref = new type$ref<LocalScope.const_iterator>(){
    @Override
    public LocalScope.const_iterator $deref() {
      return ScopePos;
    }
  
    @Override
    public LocalScope.const_iterator $set(LocalScope.const_iterator value) {
      ScopePos.$assign(value);
      return ScopePos;
    }
  };
  
  private bool$ref switchExclusivelyCovered$ref = new bool$ref() {
    @Override
    public boolean $deref() {
      return switchExclusivelyCovered;
    }
  
    @Override
    public boolean $set(boolean value) {
      switchExclusivelyCovered = value;
      return switchExclusivelyCovered;
    }
  };
  private type$ref<Expr.EvalResult /*P*/> switchCond$ref = new type$ref<Expr.EvalResult /*P*/>(){
    @Override
    public Expr.EvalResult $deref() {
      return switchCond;
    }
  
    @Override
    public Expr.EvalResult $set(Expr.EvalResult value) {
      switchCond = value;
      return switchCond;
    }
  };


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", cfg=" + cfg // NOI18N
              + ", Block=" + Block // NOI18N
              + ", Succ=" + Succ // NOI18N
              + ", ContinueJumpTarget=" + ContinueJumpTarget // NOI18N
              + ", BreakJumpTarget=" + BreakJumpTarget // NOI18N
              + ", SwitchTerminatedBlock=" + SwitchTerminatedBlock // NOI18N
              + ", DefaultCaseBlock=" + DefaultCaseBlock // NOI18N
              + ", TryTerminatedBlock=" + TryTerminatedBlock // NOI18N
              + ", ScopePos=" + ScopePos // NOI18N
              + ", LabelMap=" + LabelMap // NOI18N
              + ", BackpatchBlocks=" + BackpatchBlocks // NOI18N
              + ", AddressTakenLabels=" + AddressTakenLabels // NOI18N
              + ", badCFG=" + badCFG // NOI18N
              + ", BuildOpts=" + BuildOpts // NOI18N
              + ", switchExclusivelyCovered=" + switchExclusivelyCovered // NOI18N
              + ", switchCond=" + switchCond // NOI18N
              + ", cachedEntry=" + cachedEntry // NOI18N
              + ", lastLookup=" + lastLookup // NOI18N
              + ", CachedBoolEvals=" + CachedBoolEvals; // NOI18N
  }
}
