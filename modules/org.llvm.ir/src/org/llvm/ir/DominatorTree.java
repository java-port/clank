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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;
import org.llvm.support.DomTreeNodeBase;


/// \brief Concrete subclass of DominatorTreeBase that is used to compute a
/// normal dominator tree.
///
/// Definition: A block is said to be forward statically reachable if there is
/// a path from the entry of the function to the block.  A statically reachable
/// block may become statically unreachable during optimization.
///
/// A forward unreachable block may appear in the dominator tree, or it may
/// not.  If it does, dominance queries will return results as if all reachable
/// blocks dominate it.  When asking for a Node corresponding to a potentially
/// unreachable block, calling code must handle the case where the block was
/// unreachable and the result of getNode() is nullptr.
///
/// Generally, a block known to be unreachable when the dominator tree is
/// constructed will not be in the tree.  One which becomes unreachable after
/// the dominator tree is initially constructed may still exist in the tree,
/// even if the tree is properly updated. Calling code should not rely on the
/// preceding statements; this is stated only to assist human understanding.
//<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 96,
 FQN="llvm::DominatorTree", NM="_ZN4llvm13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm13DominatorTreeE")
//</editor-fold>
public class DominatorTree extends /*public*/ DominatorTreeBase$BasicBlock implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef DominatorTreeBase<BasicBlock> Base
//  public final class Base extends DominatorTreeBase$BasicBlock{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::DominatorTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 100,
   FQN="llvm::DominatorTree::DominatorTree", NM="_ZN4llvm13DominatorTreeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm13DominatorTreeC1Ev")
  //</editor-fold>
  public DominatorTree() {
    // : DominatorTreeBase<BasicBlock>(false)
    //START JInit
    super(false);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::DominatorTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 101,
   FQN="llvm::DominatorTree::DominatorTree", NM="_ZN4llvm13DominatorTreeC1ERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm13DominatorTreeC1ERNS_8FunctionE")
  //</editor-fold>
  public /*explicit*/ DominatorTree(final Function /*&*/ F) {
    // : DominatorTreeBase<BasicBlock>(false)
    //START JInit
    super(false);
    //END JInit
    recalculate(GraphTraitsFunction$P.$GTraits(), F);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::DominatorTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 105,
   FQN="llvm::DominatorTree::DominatorTree", NM="_ZN4llvm13DominatorTreeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm13DominatorTreeC1EOS0_")
  //</editor-fold>
  public DominatorTree(JD$Move _dparam, final DominatorTree /*&&*/Arg) {
    // : Base(std::move(static_cast<Base & >(Arg)))
    //START JInit
    super(JD$Move.INSTANCE, std.move(((/*static_cast*/DominatorTreeBase$BasicBlock /*&*/)(Arg))));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 107,
   FQN="llvm::DominatorTree::operator=", NM="_ZN4llvm13DominatorTreeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm13DominatorTreeaSEOS0_")
  //</editor-fold>
  public DominatorTree /*&*/ $assignMove(final DominatorTree /*&&*/RHS) {
    super.$assignMove(std.move(((/*static_cast*/DominatorTreeBase$BasicBlock /*&*/)(RHS))));
    return /*Deref*/this;
  }


  /// \brief Returns *false* if the other dominator tree matches this dominator
  /// tree.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::compare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 114,
   FQN="llvm::DominatorTree::compare", NM="_ZNK4llvm13DominatorTree7compareERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm13DominatorTree7compareERKS0_")
  //</editor-fold>
  public /*inline*/ boolean compare(final /*const*/ DominatorTree /*&*/ Other) /*const*/ {
    /*const*/DomTreeNodeBase<BasicBlock> /*P*/ R = getRootNode$Const();
    /*const*/DomTreeNodeBase<BasicBlock> /*P*/ OtherR = Other.getRootNode$Const();
    if (!(R != null) || !(OtherR != null) || R.getBlock() != OtherR.getBlock()) {
      return true;
    }
    if (super.compare(Other)) {
      return true;
    }

    return false;
  }


  // Ensure base-class overloads are visible.
  //JAVA: using DominatorTreeBase$BasicBlock::dominates;

  /// \brief Return true if Def dominates a use in User.
  ///
  /// This performs the special checks necessary if Def and User are in the same
  /// basic block. Note that Def doesn't dominate a use in Def itself!
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::dominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 214,
   FQN="llvm::DominatorTree::dominates", NM="_ZNK4llvm13DominatorTree9dominatesEPKNS_11InstructionERKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm13DominatorTree9dominatesEPKNS_11InstructionERKNS_3UseE")
  //</editor-fold>
  public boolean dominates(/*const*/ Instruction /*P*/ Def, final /*const*/ Use /*&*/ U) /*const*/ {
    Instruction /*P*/ UserInst = cast_Instruction(U.getUser());
    /*const*/ BasicBlock /*P*/ DefBB = Def.getParent$Const();

    // Determine the block in which the use happens. PHI nodes use
    // their operands on edges; simulate this by thinking of the use
    // happening at the end of the predecessor block.
    /*const*/ BasicBlock /*P*/ UseBB;
    {
      PHINode /*P*/ PN = dyn_cast_PHINode(UserInst);
      if ((PN != null)) {
        UseBB = PN.getIncomingBlock(U);
      } else {
        UseBB = UserInst.getParent();
      }
    }

    // Any unreachable use is dominated, even if Def == User.
    if (!isReachableFromEntry(UseBB)) {
      return true;
    }

    // Unreachable definitions don't dominate anything.
    if (!isReachableFromEntry(DefBB)) {
      return false;
    }
    {

      // Invoke instructions define their return values on the edges to their normal
      // successors, so we have to handle them specially.
      // Among other things, this means they don't dominate anything in
      // their own block, except possibly a phi, so we don't need to
      // walk the block in any case.
      /*const*/ InvokeInst /*P*/ II = dyn_cast_InvokeInst(Def);
      if ((II != null)) {
        BasicBlock /*P*/ NormalDest = II.getNormalDest();
        BasicBlockEdge E/*J*/= new BasicBlockEdge(DefBB, NormalDest);
        return dominates(E, U);
      }
    }

    // If the def and use are in different blocks, do a simple CFG dominator
    // tree query.
    if (DefBB != UseBB) {
      return dominates(DefBB, UseBB);
    }

    // Ok, def and use are in the same block. If the def is an invoke, it
    // doesn't dominate anything in the block. If it's a PHI, it dominates
    // everything in the block.
    if (isa_PHINode(UserInst)) {
      return true;
    }

    // Otherwise, just loop through the basic block until we find Def or User.
    ilist_iterator</*const*/ Instruction> I = DefBB.begin$Const();
    for (; $AddrOf(I.$star()) != Def && $AddrOf(I.$star()) != UserInst; I.$preInc())  {
/*empty*/       ;
    }

    return $AddrOf(I.$star()) != UserInst;
  }


  // dominates - Return true if Def dominates a use in User. This performs
  // the special checks necessary if Def and User are in the same basic block.
  // Note that Def doesn't dominate a use in Def itself!
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::dominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 75,
   FQN="llvm::DominatorTree::dominates", NM="_ZNK4llvm13DominatorTree9dominatesEPKNS_11InstructionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm13DominatorTree9dominatesEPKNS_11InstructionES3_")
  //</editor-fold>
  public boolean dominates(/*const*/ Instruction /*P*/ Def,
           /*const*/ Instruction /*P*/ User) /*const*/ {
    /*const*/ BasicBlock /*P*/ UseBB = User.getParent$Const();
    /*const*/ BasicBlock /*P*/ DefBB = Def.getParent$Const();

    // Any unreachable use is dominated, even if Def == User.
    if (!isReachableFromEntry(UseBB)) {
      return true;
    }

    // Unreachable definitions don't dominate anything.
    if (!isReachableFromEntry(DefBB)) {
      return false;
    }

    // An instruction doesn't dominate a use in itself.
    if (Def == User) {
      return false;
    }

    // The value defined by an invoke dominates an instruction only if it
    // dominates every instruction in UseBB.
    // A PHI is dominated only if the instruction dominates every possible use in
    // the UseBB.
    if (isa_InvokeInst(Def) || isa_PHINode(User)) {
      return dominates(Def, UseBB);
    }
    if (DefBB != UseBB) {
      return dominates(DefBB, UseBB);
    }

    // Loop through the basic block until we find Def or User.
    ilist_iterator</*const*/ Instruction> I = DefBB.begin$Const();
    for (; $AddrOf(I.$star()) != Def && $AddrOf(I.$star()) != User; I.$preInc())  {
/*empty*/       ;
    }

    return $AddrOf(I.$star()) == Def;
  }


  // true if Def would dominate a use in any instruction in UseBB.
  // note that dominates(Def, Def->getParent()) is false.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::dominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 112,
   FQN="llvm::DominatorTree::dominates", NM="_ZNK4llvm13DominatorTree9dominatesEPKNS_11InstructionEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm13DominatorTree9dominatesEPKNS_11InstructionEPKNS_10BasicBlockE")
  //</editor-fold>
  public boolean dominates(/*const*/ Instruction /*P*/ Def,
           /*const*/ BasicBlock /*P*/ UseBB) /*const*/ {
    /*const*/ BasicBlock /*P*/ DefBB = Def.getParent$Const();

    // Any unreachable use is dominated, even if DefBB == UseBB.
    if (!isReachableFromEntry(UseBB)) {
      return true;
    }

    // Unreachable definitions don't dominate anything.
    if (!isReachableFromEntry(DefBB)) {
      return false;
    }
    if (DefBB == UseBB) {
      return false;
    }
    {

      // Invoke results are only usable in the normal destination, not in the
      // exceptional destination.
      /*const*/ InvokeInst /*P*/ II = dyn_cast_InvokeInst(Def);
      if ((II != null)) {
        BasicBlock /*P*/ NormalDest = II.getNormalDest();
        BasicBlockEdge E/*J*/= new BasicBlockEdge(DefBB, NormalDest);
        return dominates(E, UseBB);
      }
    }

    return dominates(DefBB, UseBB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::dominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 190,
   FQN="llvm::DominatorTree::dominates", NM="_ZNK4llvm13DominatorTree9dominatesERKNS_14BasicBlockEdgeERKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm13DominatorTree9dominatesERKNS_14BasicBlockEdgeERKNS_3UseE")
  //</editor-fold>
  public boolean dominates(final /*const*/ BasicBlockEdge /*&*/ BBE, final /*const*/ Use /*&*/ U) /*const*/ {
    // Assert that we have a single edge. We could handle them by simply
    // returning false, but since isSingleEdge is linear on the number of
    // edges, the callers can normally handle them more efficiently.
    assert (BBE.isSingleEdge()) : "This function is not efficient in handling multiple edges";

    Instruction /*P*/ UserInst = cast_Instruction(U.getUser());
    // A PHI in the end of the edge is dominated by it.
    PHINode /*P*/ PN = dyn_cast_PHINode(UserInst);
    if ((PN != null) && PN.getParent() == BBE.getEnd()
       && PN.getIncomingBlock(U) == BBE.getStart()) {
      return true;
    }

    // Otherwise use the edge-dominates-block query, which
    // handles the crazy critical edge cases properly.
    /*const*/ BasicBlock /*P*/ UseBB;
    if ((PN != null)) {
      UseBB = PN.getIncomingBlock(U);
    } else {
      UseBB = UserInst.getParent();
    }
    return dominates(BBE, UseBB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::dominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 138,
   FQN="llvm::DominatorTree::dominates", NM="_ZNK4llvm13DominatorTree9dominatesERKNS_14BasicBlockEdgeEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm13DominatorTree9dominatesERKNS_14BasicBlockEdgeEPKNS_10BasicBlockE")
  //</editor-fold>
  public boolean dominates(final /*const*/ BasicBlockEdge /*&*/ BBE,
           /*const*/ BasicBlock /*P*/ UseBB) /*const*/ {
    // Assert that we have a single edge. We could handle them by simply
    // returning false, but since isSingleEdge is linear on the number of
    // edges, the callers can normally handle them more efficiently.
    assert (BBE.isSingleEdge()) : "This function is not efficient in handling multiple edges";

    // If the BB the edge ends in doesn't dominate the use BB, then the
    // edge also doesn't.
    /*const*/ BasicBlock /*P*/ Start = BBE.getStart();
    /*const*/ BasicBlock /*P*/ End = BBE.getEnd();
    if (!dominates(End, UseBB)) {
      return false;
    }

    // Simple case: if the end BB has a single predecessor, the fact that it
    // dominates the use block implies that the edge also does.
    if ((End.getSinglePredecessor$Const() != null)) {
      return true;
    }

    // The normal edge from the invoke is critical. Conceptually, what we would
    // like to do is split it and check if the new block dominates the use.
    // With X being the new block, the graph would look like:
    //
    //        DefBB
    //          /\      .  .
    //         /  \     .  .
    //        /    \    .  .
    //       /      \   |  |
    //      A        X  B  C
    //      |         \ | /
    //      .          \|/
    //      .      NormalDest
    //      .
    //
    // Given the definition of dominance, NormalDest is dominated by X iff X
    // dominates all of NormalDest's predecessors (X, B, C in the example). X
    // trivially dominates itself, so we only have to find if it dominates the
    // other predecessors. Since the only way out of X is via NormalDest, X can
    // only properly dominate a node if NormalDest dominates that node too.
    for (PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > PI = IrLlvmGlobals.pred_begin_BasicBlock$C$P(End), E = IrLlvmGlobals.pred_end_BasicBlock$C$P(End);
         PI.$noteq(E); PI.$preInc()) {
      /*const*/ BasicBlock /*P*/ BB = PI.$star();
      if (BB == Start) {
        continue;
      }
      if (!dominates(End, BB)) {
        return false;
      }
    }
    return true;
  }


  // Ensure base class overloads are visible.
  //JAVA: using DominatorTreeBase$BasicBlock::isReachableFromEntry;

  /// \brief Provide an overload for a Use.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::isReachableFromEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 265,
   FQN="llvm::DominatorTree::isReachableFromEntry", NM="_ZNK4llvm13DominatorTree20isReachableFromEntryERKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm13DominatorTree20isReachableFromEntryERKNS_3UseE")
  //</editor-fold>
  public boolean isReachableFromEntry(final /*const*/ Use /*&*/ U) /*const*/ {
    Instruction /*P*/ I = dyn_cast_Instruction(U.getUser());

    // ConstantExprs aren't really reachable from the entry block, but they
    // don't need to be treated like unreachable code either.
    if (!(I != null)) {
      return true;
    }
    {

      // PHI nodes use their operands on their incoming edges.
      PHINode /*P*/ PN = dyn_cast_PHINode(I);
      if ((PN != null)) {
        return isReachableFromEntry(PN.getIncomingBlock(U));
      }
    }

    // Everything else uses their operands in their own block.
    return isReachableFromEntry(I.getParent());
  }


  /// \brief Verify the correctness of the domtree by re-computing it.
  ///
  /// This should only be used for debugging as it aborts the program if the
  /// verification fails.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::verifyDomTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 280,
   FQN="llvm::DominatorTree::verifyDomTree", NM="_ZNK4llvm13DominatorTree13verifyDomTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm13DominatorTree13verifyDomTreeEv")
  //</editor-fold>
  public void verifyDomTree() /*const*/ {
    DominatorTree OtherDT = null;
    try {
      final Function /*&*/ F = $Deref(getRoot().getParent());

      OtherDT/*J*/= new DominatorTree();
      OtherDT.recalculate(GraphTraitsFunction$P.$GTraits(), F);
      if (compare(OtherDT)) {
        errs().$out(/*KEEP_STR*/"DominatorTree is not up to date!\nComputed:\n");
        print(errs());
        errs().$out(/*KEEP_STR*/"\nActual:\n");
        OtherDT.print(errs());
        abort();
      }
    } finally {
      if (OtherDT != null) { OtherDT.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTree::~DominatorTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 96,
   FQN="llvm::DominatorTree::~DominatorTree", NM="_ZN4llvm13DominatorTreeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm13DominatorTreeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
