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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.LoopInfoGlobals.*;
import org.llvm.analysis.impl.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 629,
 FQN="llvm::LoopInfo", NM="_ZN4llvm8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfoE")
//</editor-fold>
public class LoopInfo extends /*public*/ LoopInfoBase<BasicBlock, Loop> implements Destructors.ClassWithDestructor {
  // JAVA: typedef LoopInfoBase<BasicBlock, Loop> BaseT
//  public final class BaseT extends LoopInfoBase<BasicBlock, Loop>{ };
  
  /*friend  class LoopBase<BasicBlock, Loop>*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 634,
   FQN="llvm::LoopInfo::operator=", NM="_ZN4llvm8LoopInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfoaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ LoopInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::LoopInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 635,
   FQN="llvm::LoopInfo::LoopInfo", NM="_ZN4llvm8LoopInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfoC1ERKS0_")
  //</editor-fold>
  protected/*private*/ LoopInfo(final /*const*/ LoopInfo /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::LoopInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 637,
   FQN="llvm::LoopInfo::LoopInfo", NM="_ZN4llvm8LoopInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfoC1Ev")
  //</editor-fold>
  public LoopInfo() {
    // : LoopInfoBase<BasicBlock, Loop>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::LoopInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 585,
   FQN="llvm::LoopInfo::LoopInfo", NM="_ZN4llvm8LoopInfoC1ERKNS_17DominatorTreeBaseINS_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfoC1ERKNS_17DominatorTreeBaseINS_10BasicBlockEEE")
  //</editor-fold>
  public LoopInfo(final /*const*/DominatorTreeBase<BasicBlock> /*&*/ DomTree) {
    // : LoopInfoBase<BasicBlock, Loop>() 
    //START JInit
    super();
    //END JInit
    analyze(DomTree);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::LoopInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 640,
   FQN="llvm::LoopInfo::LoopInfo", NM="_ZN4llvm8LoopInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfoC1EOS0_")
  //</editor-fold>
  public LoopInfo(JD$Move _dparam, final LoopInfo /*&&*/Arg) {
    // : BaseT(std::move(static_cast<BaseT & >(Arg))) 
    //START JInit
    super(JD$Move.INSTANCE, std.move(((/*static_cast*/LoopInfoBase<BasicBlock, Loop> /*&*/ )(Arg))));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 641,
   FQN="llvm::LoopInfo::operator=", NM="_ZN4llvm8LoopInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfoaSEOS0_")
  //</editor-fold>
  public LoopInfo /*&*/ $assignMove(final LoopInfo /*&&*/RHS) {
    super.$assignMove(std.move(((/*static_cast*/LoopInfoBase<BasicBlock, Loop> /*&*/ )(RHS))));
    return /*Deref*/this;
  }

  
  // Most of the public interface is provided via LoopInfoBase.
  
  /// Update LoopInfo after removing the last backedge from a loop. This updates
  /// the loop forest and parent loops for each block so that \c L is no longer
  /// referenced, but does not actually delete \c L immediately. The pointer
  /// will remain valid until this LoopInfo's memory is released.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::markAsRemoved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 589,
   FQN="llvm::LoopInfo::markAsRemoved", NM="_ZN4llvm8LoopInfo13markAsRemovedEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfo13markAsRemovedEPNS_4LoopE")
  //</editor-fold>
  public void markAsRemoved(Loop /*P*/ Unloop) {
    UnloopUpdater Updater = null;
    try {
      assert (!Unloop.isInvalid()) : "Loop has already been removed";
      Unloop.invalidate();
      RemovedLoops.push_back_T$C$R(Unloop);
      
      // First handle the special case of no parent loop to simplify the algorithm.
      if (!(Unloop.getParentLoop() != null)) {
        // Since BBLoop had no parent, Unloop blocks are no longer in a loop.
        for (std.vector.iterator</*const*/ BasicBlock /*P*/ > I = Unloop.block_begin(), 
            E = Unloop.block_end();
             $noteq___normal_iterator$C(I, E); I.$preInc()) {
          
          // Don't reparent blocks in subloops.
          if (getLoopFor(I.$star()) != Unloop) {
            continue;
          }
          
          // Blocks no longer have a parent but are still referenced by Unloop until
          // the Unloop object is deleted.
          changeLoopFor(I.$star(), (Loop /*P*/ )null);
        }
        
        // Remove the loop from the top-level LoopInfo object.
        for (std.vector.iterator</*const*/ Loop /*P*/ > I = begin();; I.$preInc()) {
          assert ($noteq___normal_iterator$C(I, end())) : "Couldn't find loop";
          if (I.$star() == Unloop) {
            removeLoop(new std.vector.iterator</*const*/ Loop /*P*/ >(I));
            break;
          }
        }
        
        // Move all of the subloops to the top-level.
        while (!Unloop.empty()) {
          addTopLevelLoop(Unloop.removeChildLoop(std.prev(Unloop.end())));
        }
        
        return;
      }
      
      // Update the parent loop for all blocks within the loop. Blocks within
      // subloops will not change parents.
      Updater/*J*/= new UnloopUpdater(Unloop, this);
      Updater.updateBlockParents();
      
      // Remove blocks from former ancestor loops.
      Updater.removeBlocksFromAncestors();
      
      // Add direct subloops as children in their new parent loop.
      Updater.updateSubloopParents();
      
      // Remove unloop from its parent loop.
      Loop /*P*/ ParentLoop = Unloop.getParentLoop();
      for (std.vector.iterator</*const*/ Loop /*P*/ > I = ParentLoop.begin();; I.$preInc()) {
        assert ($noteq___normal_iterator$C(I, ParentLoop.end())) : "Couldn't find loop";
        if (I.$star() == Unloop) {
          ParentLoop.removeChildLoop(new std.vector.iterator</*const*/ Loop /*P*/ >(I));
          break;
        }
      }
    } finally {
      if (Updater != null) { Updater.$destroy(); }
    }
  }

  
  /// Returns true if replacing From with To everywhere is guaranteed to
  /// preserve LCSSA form.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::replacementPreservesLCSSAForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 656,
   FQN="llvm::LoopInfo::replacementPreservesLCSSAForm", NM="_ZN4llvm8LoopInfo29replacementPreservesLCSSAFormEPNS_11InstructionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfo29replacementPreservesLCSSAFormEPNS_11InstructionEPNS_5ValueE")
  //</editor-fold>
  public boolean replacementPreservesLCSSAForm(Instruction /*P*/ From, Value /*P*/ To) {
    // Preserving LCSSA form is only problematic if the replacing value is an
    // instruction.
    Instruction /*P*/ I = dyn_cast_Instruction(To);
    if (!(I != null)) {
      return true;
    }
    // If both instructions are defined in the same basic block then replacement
    // cannot break LCSSA form.
    if (I.getParent() == From.getParent()) {
      return true;
    }
    // If the instruction is not defined in a loop then it can safely replace
    // anything.
    Loop /*P*/ ToLoop = getLoopFor(I.getParent());
    if (!(ToLoop != null)) {
      return true;
    }
    // If the replacing instruction is defined in the same loop as the original
    // instruction, or in a loop that contains it as an inner loop, then using
    // it as a replacement will not break LCSSA form.
    return ToLoop.contains_T1$C$P(getLoopFor(From.getParent()));
  }

  
  /// Checks if moving a specific instruction can break LCSSA in any loop.
  ///
  /// Return true if moving \p Inst to before \p NewLoc will break LCSSA,
  /// assuming that the function containing \p Inst and \p NewLoc is currently
  /// in LCSSA form.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::movementPreservesLCSSAForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 680,
   FQN="llvm::LoopInfo::movementPreservesLCSSAForm", NM="_ZN4llvm8LoopInfo26movementPreservesLCSSAFormEPNS_11InstructionES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfo26movementPreservesLCSSAFormEPNS_11InstructionES2_")
  //</editor-fold>
  public boolean movementPreservesLCSSAForm(Instruction /*P*/ Inst, Instruction /*P*/ NewLoc) {
    assert (Inst.getFunction() == NewLoc.getFunction()) : "Can't reason about IPO!";
    
    BasicBlock /*P*/ OldBB = Inst.getParent();
    BasicBlock /*P*/ NewBB = NewLoc.getParent();
    
    // Movement within the same loop does not break LCSSA (the equality check is
    // to avoid doing a hashtable lookup in case of intra-block movement).
    if (OldBB == NewBB) {
      return true;
    }
    
    Loop /*P*/ OldLoop = getLoopFor(OldBB);
    Loop /*P*/ NewLoop = getLoopFor(NewBB);
    if (OldLoop == NewLoop) {
      return true;
    }
    
    // Check if Outer contains Inner; with the null loop counting as the
    // "outermost" loop.
    LoopLoop2Bool Contains = /*[]*/ (/*const*/ Loop /*P*/ Outer, /*const*/ Loop /*P*/ Inner) -> {
          return !(Outer != null) || Outer.contains_T1$C$P(Inner);
        };
    
    // To check that the movement of Inst to before NewLoc does not break LCSSA,
    // we need to check two sets of uses for possible LCSSA violations at
    // NewLoc: the users of NewInst, and the operands of NewInst.
    
    // If we know we're hoisting Inst out of an inner loop to an outer loop,
    // then the uses *of* Inst don't need to be checked.
    if (!Contains.$call(NewLoop, OldLoop)) {
      for (final Use /*&*/ U : Inst.uses()) {
        Instruction /*P*/ UI = cast_Instruction(U.getUser());
        BasicBlock /*P*/ UBB = isa_PHINode(UI) ? cast_PHINode(UI).getIncomingBlock(U) : UI.getParent();
        if (UBB != NewBB && getLoopFor(UBB) != NewLoop) {
          return false;
        }
      }
    }
    
    // If we know we're sinking Inst from an outer loop into an inner loop, then
    // the *operands* of Inst don't need to be checked.
    if (!Contains.$call(OldLoop, NewLoop)) {
      // See below on why we can't handle phi nodes here.
      if (isa_PHINode(Inst)) {
        return false;
      }
      
      for (final Use /*&*/ U : Inst.operands()) {
        Instruction /*P*/ DefI = dyn_cast_Instruction(U.get());
        if (!(DefI != null)) {
          return false;
        }
        
        // This would need adjustment if we allow Inst to be a phi node -- the
        // new use block won't simply be NewBB.
        BasicBlock /*P*/ DefBlock = DefI.getParent();
        if (DefBlock != NewBB && getLoopFor(DefBlock) != NewLoop) {
          return false;
        }
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfo::~LoopInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 629,
   FQN="llvm::LoopInfo::~LoopInfo", NM="_ZN4llvm8LoopInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
