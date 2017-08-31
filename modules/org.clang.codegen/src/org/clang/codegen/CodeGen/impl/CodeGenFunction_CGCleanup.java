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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.EHScopeStack.stable_iterator;
import static org.clang.codegen.impl.CGCleanupStatics.*;
import static org.clang.codegen.java.CodegenRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGCleanup">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGCleanup",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGClass ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15PopCleanupBlockEb;_ZN5clang7CodeGen15CodeGenFunction16EmitCXXTemporaryEPKNS_12CXXTemporaryENS_8QualTypeENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction16PopCleanupBlocksENS0_12EHScopeStack15stable_iteratorE;_ZN5clang7CodeGen15CodeGenFunction16PopCleanupBlocksENS0_12EHScopeStack15stable_iteratorEj;_ZN5clang7CodeGen15CodeGenFunction19ResolveBranchFixupsEPN4llvm10BasicBlockE;_ZN5clang7CodeGen15CodeGenFunction19initFullExprCleanupEv;_ZN5clang7CodeGen15CodeGenFunction20ActivateCleanupBlockENS0_12EHScopeStack15stable_iteratorEPN4llvm11InstructionE;_ZN5clang7CodeGen15CodeGenFunction22DeactivateCleanupBlockENS0_12EHScopeStack15stable_iteratorEPN4llvm11InstructionE;_ZN5clang7CodeGen15CodeGenFunction24EmitBranchThroughCleanupENS1_8JumpDestE;_ZN5clang7CodeGen15CodeGenFunction24getNormalCleanupDestSlotEv;_ZNK5clang7CodeGen15CodeGenFunction32isObviouslyBranchWithoutCleanupsENS1_8JumpDestE; -static-type=CodeGenFunction_CGCleanup -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGCleanup extends CodeGenFunction_CGClass {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGCleanup(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// Set up the last cleaup that was pushed as a conditional
/// full-expression cleanup.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::initFullExprCleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 285,
 FQN="clang::CodeGen::CodeGenFunction::initFullExprCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction19initFullExprCleanupEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19initFullExprCleanupEv")
//</editor-fold>
public final void initFullExprCleanup() {
  // Create a variable to decide whether the cleanup needs to be run.
  Address active = $this().CreateTempAlloca($this().Builder.getInt1Ty(), CharUnits.One(), 
      new Twine(/*KEEP_STR*/"cleanup.cond"));
  
  // Initialize it to false at a site that's guaranteed to be run
  // before each evaluation.
  $this().setBeforeOutermostConditional($this().Builder.getFalse(), new Address(active));
  
  // Initialize it to true at the current location.
  $this().Builder.CreateStore($this().Builder.getTrue(), new Address(active));
  
  // Set that as the active flag in the cleanup.
  final EHCleanupScope /*&*/ cleanup = cast_EHCleanupScope($this().EHStack.begin().$star());
  assert (!cleanup.hasActiveFlag()) : "cleanup already has active flag?";
  cleanup.setActiveFlag(new Address(active));
  if (cleanup.isNormalCleanup()) {
    cleanup.setTestFlagInNormalCleanup();
  }
  if (cleanup.isEHCleanup()) {
    cleanup.setTestFlagInEHCleanup();
  }
}


/// PopCleanupBlock - Will pop the cleanup entry on the stack and
/// process all branch fixups.

/// Pops a cleanup block.  If the block includes a normal cleanup, the
/// current insertion point is threaded through the cleanup, as are
/// any branch fixups on the cleanup.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PopCleanupBlock">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 603,
 FQN="clang::CodeGen::CodeGenFunction::PopCleanupBlock", NM="_ZN5clang7CodeGen15CodeGenFunction15PopCleanupBlockEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15PopCleanupBlockEb")
//</editor-fold>
public final void PopCleanupBlock() {
  PopCleanupBlock(false);
}
public final void PopCleanupBlock(boolean FallthroughIsBranchThrough/*= false*/) {
  std.unique_ptr<char$ptr> CleanupBufferHeap = null;
  try {
    assert (!$this().EHStack.empty()) : "cleanup stack is empty!";
    assert (isa_EHCleanupScope($this().EHStack.begin().$star())) : "top not a cleanup!";
    final EHCleanupScope /*&*/ Scope = cast_EHCleanupScope($this().EHStack.begin().$star());
    assert ($lesseq_uint(Scope.getFixupDepth(), $this().EHStack.getNumBranchFixups()));
    
    // Remember activation information.
    boolean IsActive = Scope.isActive();
    Address NormalActiveFlag = Scope.shouldTestFlagInNormalCleanup() ? Scope.getActiveFlag() : Address.invalid();
    Address EHActiveFlag = Scope.shouldTestFlagInEHCleanup() ? Scope.getActiveFlag() : Address.invalid();
    
    // Check whether we need an EH cleanup.  This is only true if we've
    // generated a lazy EH cleanup block.
    BasicBlock /*P*/ EHEntry = Scope.getCachedEHDispatchBlock();
    assert (Scope.hasEHBranches() == (EHEntry != null));
    boolean RequiresEHCleanup = (EHEntry != null);
    EHScopeStack.stable_iterator EHParent = Scope.getEnclosingEHScope();
    
    // Check the three conditions which might require a normal cleanup:
    
    // - whether there are branch fix-ups through this cleanup
    /*uint*/int FixupDepth = Scope.getFixupDepth();
    boolean HasFixups = $this().EHStack.getNumBranchFixups() != FixupDepth;
    
    // - whether there are branch-throughs or branch-afters
    boolean HasExistingBranches = Scope.hasBranches();
    
    // - whether there's a fallthrough
    BasicBlock /*P*/ FallthroughSource = $this().Builder.GetInsertBlock();
    boolean HasFallthrough = (FallthroughSource != null && IsActive);
    
    // Branch-through fall-throughs leave the insertion point set to the
    // end of the last cleanup, which points to the current scope.  The
    // rest of IR gen doesn't need to worry about this; it only happens
    // during the execution of PopCleanupBlocks().
    boolean HasPrebranchedFallthrough = ((FallthroughSource != null) && (FallthroughSource.getTerminator() != null));
    
    // If this is a normal cleanup, then having a prebranched
    // fallthrough implies that the fallthrough source unconditionally
    // jumps here.
    assert (!Scope.isNormalCleanup() || !HasPrebranchedFallthrough || ((Scope.getNormalBlock() != null) && FallthroughSource.getTerminator().getSuccessor(0) == Scope.getNormalBlock()));
    
    boolean RequiresNormalCleanup = false;
    if (Scope.isNormalCleanup()
       && (HasFixups || HasExistingBranches || HasFallthrough)) {
      RequiresNormalCleanup = true;
    }
    
    // If we have a prebranched fallthrough into an inactive normal
    // cleanup, rewrite it so that it leads to the appropriate place.
    if (Scope.isNormalCleanup() && HasPrebranchedFallthrough && !IsActive) {
      BasicBlock /*P*/ prebranchDest;
      
      // If the prebranch is semantically branching through the next
      // cleanup, just forward it to the next block, leaving the
      // insertion point in the prebranched block.
      if (FallthroughIsBranchThrough) {
        final EHScope /*&*/ enclosing = $this().EHStack.find(Scope.getEnclosingNormalCleanup()).$star();
        prebranchDest = CGCleanupStatics.CreateNormalEntry(/*Deref*/$this(), cast_EHCleanupScope(enclosing));
        // Otherwise, we need to make a new block.  If the normal cleanup
        // isn't being used at all, we could actually reuse the normal
        // entry block, but this is simpler, and it avoids conflicts with
        // dead optimistic fixup branches.
      } else {
        prebranchDest = $this().createBasicBlock(new Twine(/*KEEP_STR*/"forwarded-prebranch"));
        $this().EmitBlock(prebranchDest);
      }
      
      BasicBlock /*P*/ normalEntry = Scope.getNormalBlock();
      assert ((normalEntry != null) && !normalEntry.use_empty());
      
      CGCleanupStatics.ForwardPrebranchedFallthrough(FallthroughSource, 
          normalEntry, prebranchDest);
    }
    
    // If we don't need the cleanup at all, we're done.
    if (!RequiresNormalCleanup && !RequiresEHCleanup) {
      CGCleanupStatics.destroyOptimisticNormalEntry(/*Deref*/$this(), Scope);
      $this().EHStack.popCleanup(); // safe because there are no fixups
      assert ($this().EHStack.getNumBranchFixups() == 0 || $this().EHStack.hasNormalCleanups());
      return;
    }
    
    // Copy the cleanup emission data out.  This uses either a stack
    // array or malloc'd memory, depending on the size, which is
    // behavior that SmallVector would provide, if we could use it
    // here. Unfortunately, if you ask for a SmallVector<char>, the
    // alignment isn't sufficient.
    char$ptr/*char P*/ CleanupSource = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, Scope.getCleanupBuffer()));
    AlignedCharArray CleanupBufferStack/*J*/= new AlignedCharArray(8 * $sizeof_ptr());
    CleanupBufferHeap/*J*/= new std.unique_ptr<char$ptr>();
    /*size_t*/int CleanupSize = Scope.getCleanupSize();
    EHScopeStack.Cleanup /*P*/ Fn;
    if ($lesseq_uint(CleanupSize, sizeof(CleanupBufferStack))) {
      memcpy(CleanupBufferStack.buffer, CleanupSource, CleanupSize);
      Fn = reinterpret_cast(EHScopeStack.Cleanup /*P*/ .class, CleanupBufferStack.buffer);
    } else {
      CleanupBufferHeap.reset(create_char$ptr(new byte[CleanupSize]));
      memcpy(CleanupBufferHeap.get(), CleanupSource, CleanupSize);
      Fn = reinterpret_cast(EHScopeStack.Cleanup /*P*/ .class, CleanupBufferHeap.get());
    }
    
    EHScopeStack.Cleanup.Flags cleanupFlags/*J*/= new EHScopeStack.Cleanup.Flags();
    if (Scope.isNormalCleanup()) {
      cleanupFlags.setIsNormalCleanupKind();
    }
    if (Scope.isEHCleanup()) {
      cleanupFlags.setIsEHCleanupKind();
    }
    if (!RequiresNormalCleanup) {
      CGCleanupStatics.destroyOptimisticNormalEntry(/*Deref*/$this(), Scope);
      $this().EHStack.popCleanup();
    } else {
      // If we have a fallthrough and no other need for the cleanup,
      // emit it directly.
      if (HasFallthrough && !HasPrebranchedFallthrough
         && !HasFixups && !HasExistingBranches) {
        
        CGCleanupStatics.destroyOptimisticNormalEntry(/*Deref*/$this(), Scope);
        $this().EHStack.popCleanup();
        
        CGCleanupStatics.EmitCleanup(/*Deref*/$this(), Fn, new EHScopeStack.Cleanup.Flags(cleanupFlags), new Address(NormalActiveFlag));
        // Otherwise, the best approach is to thread everything through
        // the cleanup block and then try to clean up after ourselves.
      } else {
        // Force the entry block to exist.
        BasicBlock /*P*/ NormalEntry = CGCleanupStatics.CreateNormalEntry(/*Deref*/$this(), Scope);
        
        // I.  Set up the fallthrough edge in.
        CGBuilderTy.InsertPoint savedInactiveFallthroughIP/*J*/= new CGBuilderTy.InsertPoint();
        
        // If there's a fallthrough, we need to store the cleanup
        // destination index.  For fall-throughs this is always zero.
        if (HasFallthrough) {
          if (!HasPrebranchedFallthrough) {
            $this().Builder.CreateStore($this().Builder.getInt32(0), $this().getNormalCleanupDestSlot());
          }
          // Otherwise, save and clear the IP if we don't have fallthrough
          // because the cleanup is inactive.
        } else if ((FallthroughSource != null)) {
          assert (!IsActive) : "source without fallthrough for active cleanup";
          savedInactiveFallthroughIP.$assignMove($this().Builder.saveAndClearIP());
        }
        
        // II.  Emit the entry block.  This implicitly branches to it if
        // we have fallthrough.  All the fixups and existing branches
        // should already be branched to it.
        $this().EmitBlock(NormalEntry);
        
        // III.  Figure out where we're going and build the cleanup
        // epilogue.
        boolean HasEnclosingCleanups = (stable_iterator.$noteq_stable_iterator(Scope.getEnclosingNormalCleanup(), $this().EHStack.stable_end()));
        
        // Compute the branch-through dest if we need it:
        //   - if there are branch-throughs threaded through the scope
        //   - if fall-through is a branch-through
        //   - if there are fixups that will be optimistically forwarded
        //     to the enclosing cleanup
        BasicBlock /*P*/ BranchThroughDest = null;
        if (Scope.hasBranchThroughs()
           || ((FallthroughSource != null) && FallthroughIsBranchThrough)
           || (HasFixups && HasEnclosingCleanups)) {
          assert (HasEnclosingCleanups);
          final EHScope /*&*/ S = $this().EHStack.find(Scope.getEnclosingNormalCleanup()).$star();
          BranchThroughDest = CGCleanupStatics.CreateNormalEntry(/*Deref*/$this(), cast_EHCleanupScope(S));
        }
        
        BasicBlock /*P*/ FallthroughDest = null;
        SmallVector<Instruction /*P*/ > InstsToAppend/*J*/= new SmallVector<Instruction /*P*/ >(2, (Instruction /*P*/ )null);
        
        // If there's exactly one branch-after and no other threads,
        // we can route it without a switch.
        if (!Scope.hasBranchThroughs() && !HasFixups && !HasFallthrough
           && Scope.getNumBranchAfters() == 1) {
          assert (!(BranchThroughDest != null) || !IsActive);
          
          // Clean up the possibly dead store to the cleanup dest slot.
          Instruction /*P*/ NormalCleanupDestSlot = cast_Instruction($this().getNormalCleanupDestSlot().getPointer());
          if (NormalCleanupDestSlot.hasOneUse()) {
            NormalCleanupDestSlot.user_back$Instruction().eraseFromParent();
            NormalCleanupDestSlot.eraseFromParent();
            $this().NormalCleanupDest = null;
          }
          
          BasicBlock /*P*/ BranchAfter = Scope.getBranchAfterBlock(0);
          InstsToAppend.push_back(BranchInst.Create(BranchAfter));
          // Build a switch-out if we need it:
          //   - if there are branch-afters threaded through the scope
          //   - if fall-through is a branch-after
          //   - if there are fixups that have nowhere left to go and
          //     so must be immediately resolved
        } else if ((Scope.getNumBranchAfters() != 0)
           || (HasFallthrough && !FallthroughIsBranchThrough)
           || (HasFixups && !HasEnclosingCleanups)) {
          
          BasicBlock /*P*/ Default = ((BranchThroughDest != null) ? BranchThroughDest : $this().getUnreachableBlock());
          
          // TODO: base this on the number of branch-afters and fixups
          /*const*//*uint*/int SwitchCapacity = 10;
          
          LoadInst /*P*/ Load = CGCleanupStatics.createLoadInstBefore($this().getNormalCleanupDestSlot(), new Twine(/*KEEP_STR*/"cleanup.dest"), 
              (Instruction /*P*/ )null);
          SwitchInst /*P*/ Switch = SwitchInst.Create(Load, Default, SwitchCapacity);
          
          InstsToAppend.push_back(Load);
          InstsToAppend.push_back(Switch);
          
          // Branch-after fallthrough.
          if ((FallthroughSource != null) && !FallthroughIsBranchThrough) {
            FallthroughDest = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cleanup.cont"));
            if (HasFallthrough) {
              Switch.addCase($this().Builder.getInt32(0), FallthroughDest);
            }
          }
          
          for (/*uint*/int I = 0, E = Scope.getNumBranchAfters(); I != E; ++I) {
            Switch.addCase(Scope.getBranchAfterIndex(I), 
                Scope.getBranchAfterBlock(I));
          }
          
          // If there aren't any enclosing cleanups, we can resolve all
          // the fixups now.
          if (HasFixups && !HasEnclosingCleanups) {
            CGCleanupStatics.ResolveAllBranchFixups(/*Deref*/$this(), Switch, NormalEntry);
          }
        } else {
          // We should always have a branch-through destination in this case.
          assert Native.$bool(BranchThroughDest);
          InstsToAppend.push_back(BranchInst.Create(BranchThroughDest));
        }
        
        // IV.  Pop the cleanup and emit it.
        $this().EHStack.popCleanup();
        assert ($this().EHStack.hasNormalCleanups() == HasEnclosingCleanups);
        
        CGCleanupStatics.EmitCleanup(/*Deref*/$this(), Fn, new EHScopeStack.Cleanup.Flags(cleanupFlags), new Address(NormalActiveFlag));
        
        // Append the prepared cleanup prologue from above.
        BasicBlock /*P*/ NormalExit = $this().Builder.GetInsertBlock();
        for (/*uint*/int I = 0, E = InstsToAppend.size(); I != E; ++I)  {
          NormalExit.getInstList().push_back(InstsToAppend.$at(I));
        }
        
        // Optimistically hope that any fixups will continue falling through.
        for (/*uint*/int I = FixupDepth, E = $this().EHStack.getNumBranchFixups();
             $less_uint(I, E); ++I) {
          final BranchFixup /*&*/ Fixup = $this().EHStack.getBranchFixup(I);
          if (!(Fixup.Destination != null)) {
            continue;
          }
          if (!(Fixup.OptimisticBranchBlock != null)) {
            CGCleanupStatics.createStoreInstBefore($this().Builder.getInt32(Fixup.DestinationIndex), 
                $this().getNormalCleanupDestSlot(), 
                Fixup.InitialBranch);
            Fixup.InitialBranch.setSuccessor(0, NormalEntry);
          }
          Fixup.OptimisticBranchBlock = NormalExit;
        }
        
        // V.  Set up the fallthrough edge out.
        
        // Case 1: a fallthrough source exists but doesn't branch to the
        // cleanup because the cleanup is inactive.
        if (!HasFallthrough && (FallthroughSource != null)) {
          // Prebranched fallthrough was forwarded earlier.
          // Non-prebranched fallthrough doesn't need to be forwarded.
          // Either way, all we need to do is restore the IP we cleared before.
          assert (!IsActive);
          $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(savedInactiveFallthroughIP));
          // Case 2: a fallthrough source exists and should branch to the
          // cleanup, but we're not supposed to branch through to the next
          // cleanup.
        } else if (HasFallthrough && (FallthroughDest != null)) {
          assert (!FallthroughIsBranchThrough);
          $this().EmitBlock(FallthroughDest);
          // Case 3: a fallthrough source exists and should branch to the
          // cleanup and then through to the next.
        } else if (HasFallthrough) {

          // Everything is already set up for this.

          // Case 4: no fallthrough source exists.
        } else {
          $this().Builder.ClearInsertionPoint();
        }
        
        // VI.  Assorted cleaning.
        
        // Check whether we can merge NormalEntry into a single predecessor.
        // This might invalidate (non-IR) pointers to NormalEntry.
        BasicBlock /*P*/ NewNormalEntry = CGCleanupStatics.SimplifyCleanupEntry(/*Deref*/$this(), NormalEntry);
        
        // If it did invalidate those pointers, and NormalEntry was the same
        // as NormalExit, go back and patch up the fixups.
        if (NewNormalEntry != NormalEntry && NormalEntry == NormalExit) {
          for (/*uint*/int I = FixupDepth, E = $this().EHStack.getNumBranchFixups();
               $less_uint(I, E); ++I)  {
            $this().EHStack.getBranchFixup(I).OptimisticBranchBlock = NewNormalEntry;
          }
        }
      }
    }
    assert ($this().EHStack.hasNormalCleanups() || $this().EHStack.getNumBranchFixups() == 0);
    
    // Emit the EH cleanup if required.
    if (RequiresEHCleanup) {
      SaveAndRestore<Instruction /*P*/ > RestoreCurrentFuncletPad = null;
      try {
        CGBuilderTy.InsertPoint SavedIP = $this().Builder.saveAndClearIP();
        
        $this().EmitBlock(EHEntry);
        
        BasicBlock /*P*/ NextAction = $this().getEHDispatchBlock(new EHScopeStack.stable_iterator(EHParent));
        
        // Push a terminate scope or cleanupendpad scope around the potentially
        // throwing cleanups. For funclet EH personalities, the cleanupendpad models
        // program termination when cleanups throw.
        boolean PushedTerminate = false;
        RestoreCurrentFuncletPad/*J*/= new SaveAndRestore<Instruction /*P*/ >($this().CurrentFuncletPad_ref, true);
        CleanupPadInst /*P*/ CPI = null;
        if (!EHPersonality.get(/*Deref*/$this()).usesFuncletPads()) {
          $this().EHStack.pushTerminate();
          PushedTerminate = true;
        } else {
          Value /*P*/ ParentPad = $this().CurrentFuncletPad;
          if (!(ParentPad != null)) {
            ParentPad = ConstantTokenNone.get($this().CGM.getLLVMContext());
          }
          $this().CurrentFuncletPad = CPI = $this().Builder.CreateCleanupPad(ParentPad);
        }
        
        // We only actually emit the cleanup code if the cleanup is either
        // active or was used before it was deactivated.
        if (EHActiveFlag.isValid() || IsActive) {
          cleanupFlags.setIsForEHCleanup();
          CGCleanupStatics.EmitCleanup(/*Deref*/$this(), Fn, new EHScopeStack.Cleanup.Flags(cleanupFlags), new Address(EHActiveFlag));
        }
        if ((CPI != null)) {
          $this().Builder.CreateCleanupRet(CPI, NextAction);
        } else {
          $this().Builder.CreateBr(NextAction);
        }
        
        // Leave the terminate scope.
        if (PushedTerminate) {
          $this().EHStack.popTerminate();
        }
        
        $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
        
        CGCleanupStatics.SimplifyCleanupEntry(/*Deref*/$this(), EHEntry);
      } finally {
        if (RestoreCurrentFuncletPad != null) { RestoreCurrentFuncletPad.$destroy(); }
      }
    }
  } finally {
    if (CleanupBufferHeap != null) { CleanupBufferHeap.$destroy(); }
  }
}


/// DeactivateCleanupBlock - Deactivates the given cleanup block.
/// The block cannot be reactivated.  Pops it if it's the top of the
/// stack.
///
/// \param DominatingIP - An instruction which is known to
///   dominate the current IP (if set) and which lies along
///   all paths of execution between the current IP and the
///   the point at which the cleanup comes into scope.

/// Deactive a cleanup that was created in an active state.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::DeactivateCleanupBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 1193,
 FQN="clang::CodeGen::CodeGenFunction::DeactivateCleanupBlock", NM="_ZN5clang7CodeGen15CodeGenFunction22DeactivateCleanupBlockENS0_12EHScopeStack15stable_iteratorEPN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22DeactivateCleanupBlockENS0_12EHScopeStack15stable_iteratorEPN4llvm11InstructionE")
//</editor-fold>
public final void DeactivateCleanupBlock(EHScopeStack.stable_iterator C, 
                      Instruction /*P*/ dominatingIP) {
  assert (stable_iterator.$noteq_stable_iterator(/*NO_COPY*/C, $this().EHStack.stable_end())) : "deactivating bottom of stack?";
  final EHCleanupScope /*&*/ Scope = cast_EHCleanupScope($this().EHStack.find(/*NO_COPY*/C).$star());
  assert (Scope.isActive()) : "double deactivation";
  
  // If it's the top of the stack, just pop it.
  if (stable_iterator.$eq_stable_iterator(/*NO_COPY*/C, $this().EHStack.stable_begin())) {
    // If it's a normal cleanup, we need to pretend that the
    // fallthrough is unreachable.
    CGBuilderTy.InsertPoint SavedIP = $this().Builder.saveAndClearIP();
    $this().PopCleanupBlock();
    $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
    return;
  }
  
  // Otherwise, follow the general case.
  CGCleanupStatics.SetupCleanupBlockActivation(/*Deref*/$this(), new EHScopeStack.stable_iterator(C), ForActivation_t.ForDeactivation, dominatingIP);
  
  Scope.setActive(false);
}


/// ActivateCleanupBlock - Activates an initially-inactive cleanup.
/// Cannot be used to resurrect a deactivated cleanup.
///
/// \param DominatingIP - An instruction which is known to
///   dominate the current IP (if set) and which lies along
///   all paths of execution between the current IP and the
///   the point at which the cleanup comes into scope.

/// Activate a cleanup that was created in an inactivated state.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ActivateCleanupBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 1181,
 FQN="clang::CodeGen::CodeGenFunction::ActivateCleanupBlock", NM="_ZN5clang7CodeGen15CodeGenFunction20ActivateCleanupBlockENS0_12EHScopeStack15stable_iteratorEPN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20ActivateCleanupBlockENS0_12EHScopeStack15stable_iteratorEPN4llvm11InstructionE")
//</editor-fold>
public final void ActivateCleanupBlock(EHScopeStack.stable_iterator C, 
                    Instruction /*P*/ dominatingIP) {
  assert (stable_iterator.$noteq_stable_iterator(/*NO_COPY*/C, $this().EHStack.stable_end())) : "activating bottom of stack?";
  final EHCleanupScope /*&*/ Scope = cast_EHCleanupScope($this().EHStack.find(/*NO_COPY*/C).$star());
  assert (!Scope.isActive()) : "double activation";
  
  CGCleanupStatics.SetupCleanupBlockActivation(/*Deref*/$this(), new EHScopeStack.stable_iterator(C), ForActivation_t.ForActivation, dominatingIP);
  
  Scope.setActive(true);
}


/// \brief Takes the old cleanup stack size and emits the cleanup blocks
/// that have been added.

/// Pops cleanup blocks until the given savepoint is reached.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PopCleanupBlocks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 421,
 FQN="clang::CodeGen::CodeGenFunction::PopCleanupBlocks", NM="_ZN5clang7CodeGen15CodeGenFunction16PopCleanupBlocksENS0_12EHScopeStack15stable_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16PopCleanupBlocksENS0_12EHScopeStack15stable_iteratorE")
//</editor-fold>
public final void PopCleanupBlocks(EHScopeStack.stable_iterator Old) {
  assert (Old.isValid());
  while (stable_iterator.$noteq_stable_iterator($this().EHStack.stable_begin(), /*NO_COPY*/Old)) {
    final EHCleanupScope /*&*/ Scope = cast_EHCleanupScope($this().EHStack.begin().$star());
    
    // As long as Old strictly encloses the scope's enclosing normal
    // cleanup, we're going to emit another normal cleanup which
    // fallthrough can propagate through.
    boolean FallThroughIsBranchThrough = Old.strictlyEncloses(Scope.getEnclosingNormalCleanup());
    
    $this().PopCleanupBlock(FallThroughIsBranchThrough);
  }
}


/// \brief Takes the old cleanup stack size and emits the cleanup blocks
/// that have been added, then adds all lifetime-extended cleanups from
/// the given position to the stack.

/// Pops cleanup blocks until the given savepoint is reached, then add the
/// cleanups from the given savepoint in the lifetime-extended cleanups stack.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PopCleanupBlocks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 439,
 FQN="clang::CodeGen::CodeGenFunction::PopCleanupBlocks", NM="_ZN5clang7CodeGen15CodeGenFunction16PopCleanupBlocksENS0_12EHScopeStack15stable_iteratorEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16PopCleanupBlocksENS0_12EHScopeStack15stable_iteratorEj")
//</editor-fold>
public final void PopCleanupBlocks(EHScopeStack.stable_iterator Old, 
                /*size_t*/int OldLifetimeExtendedSize) {
  $this().PopCleanupBlocks(new EHScopeStack.stable_iterator(Old));
  
  // Move our deferred cleanups onto the EH stack.
  for (/*size_t*/int I = OldLifetimeExtendedSize, 
      E = $this().LifetimeExtendedCleanupStack.size(); I != E;) {
    // Alignment should be guaranteed by the vptrs in the individual cleanups.
    assert (($rem_uint(I, alignOf(LifetimeExtendedCleanupHeader.class)) == 0)) : "misaligned cleanup stack entry";
    
    final LifetimeExtendedCleanupHeader /*&*/ Header = reinterpret_cast(LifetimeExtendedCleanupHeader /*&*/ .class, $this().LifetimeExtendedCleanupStack.$at(I));
    I += sizeof(Header);
    
    $this().EHStack.pushCopyOfCleanup(Header.getKind(), 
        $AddrOf($this().LifetimeExtendedCleanupStack.ptr$at(I)), 
        Header.getSize());
    I += Header.getSize();
  }
  $this().LifetimeExtendedCleanupStack.resize(OldLifetimeExtendedSize);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ResolveBranchFixups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 382,
 FQN="clang::CodeGen::CodeGenFunction::ResolveBranchFixups", NM="_ZN5clang7CodeGen15CodeGenFunction19ResolveBranchFixupsEPN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19ResolveBranchFixupsEPN4llvm10BasicBlockE")
//</editor-fold>
public final void ResolveBranchFixups(BasicBlock /*P*/ Block) {
  assert ((Block != null)) : "resolving a null target block";
  if (!($this().EHStack.getNumBranchFixups() != 0)) {
    return;
  }
  assert ($this().EHStack.hasNormalCleanups()) : "branch fixups exist with no normal cleanups on stack";
  
  SmallPtrSet<BasicBlock /*P*/ > ModifiedOptimisticBlocks/*J*/= new SmallPtrSet<BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
  boolean ResolvedAny = false;
  
  for (/*uint*/int I = 0, E = $this().EHStack.getNumBranchFixups(); I != E; ++I) {
    // Skip this fixup if its destination doesn't match.
    final BranchFixup /*&*/ Fixup = $this().EHStack.getBranchFixup(I);
    if (Fixup.Destination != Block) {
      continue;
    }
    
    Fixup.Destination = null;
    ResolvedAny = true;
    
    // If it doesn't have an optimistic branch block, LatestBranch is
    // already pointing to the right place.
    BasicBlock /*P*/ BranchBB = Fixup.OptimisticBranchBlock;
    if (!(BranchBB != null)) {
      continue;
    }
    
    // Don't process the same optimistic branch block twice.
    if (!ModifiedOptimisticBlocks.insert(BranchBB).second) {
      continue;
    }
    
    SwitchInst /*P*/ Switch = CGCleanupStatics.TransitionToCleanupSwitch(/*Deref*/$this(), BranchBB);
    
    // Add a case to the switch.
    Switch.addCase($this().Builder.getInt32(Fixup.DestinationIndex), Block);
  }
  if (ResolvedAny) {
    $this().EHStack.popNullFixups();
  }
}


/// EmitBranchThroughCleanup - Emit a branch from the current insert
/// block through the normal cleanup handling code (if any) and then
/// on to \arg Dest.

/// Terminate the current block by emitting a branch which might leave
/// the current cleanup-protected scope.  The target scope may not yet
/// be known, in which case this will require a fixup.
///
/// As a side-effect, this method clears the insertion point.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBranchThroughCleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 997,
 FQN="clang::CodeGen::CodeGenFunction::EmitBranchThroughCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitBranchThroughCleanupENS1_8JumpDestE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitBranchThroughCleanupENS1_8JumpDestE")
//</editor-fold>
public final void EmitBranchThroughCleanup(JumpDest Dest) {
  assert (Dest.getScopeDepth().encloses($this().EHStack.stable_begin())) : "stale jump destination";
  if (!$this().HaveInsertPoint()) {
    return;
  }
  
  // Create the branch.
  BranchInst /*P*/ BI = $this().Builder.CreateBr(Dest.getBlock());
  
  // Calculate the innermost active normal cleanup.
  EHScopeStack.stable_iterator TopCleanup = $this().EHStack.getInnermostActiveNormalCleanup();
  
  // If we're not in an active normal cleanup scope, or if the
  // destination scope is within the innermost active normal cleanup
  // scope, we don't need to worry about fixups.
  if (stable_iterator.$eq_stable_iterator(/*NO_COPY*/TopCleanup, $this().EHStack.stable_end())
     || TopCleanup.encloses(Dest.getScopeDepth())) { // works for invalid
    $this().Builder.ClearInsertionPoint();
    return;
  }
  
  // If we can't resolve the destination cleanup scope, just add this
  // to the current cleanup scope as a branch fixup.
  if (!Dest.getScopeDepth().isValid()) {
    final BranchFixup /*&*/ Fixup = $this().EHStack.addBranchFixup();
    Fixup.Destination = Dest.getBlock();
    Fixup.DestinationIndex = Dest.getDestIndex();
    Fixup.InitialBranch = BI;
    Fixup.OptimisticBranchBlock = null;
    
    $this().Builder.ClearInsertionPoint();
    return;
  }
  
  // Otherwise, thread through all the normal cleanups in scope.
  
  // Store the index at the start.
  ConstantInt /*P*/ Index = $this().Builder.getInt32(Dest.getDestIndex());
  CGCleanupStatics.createStoreInstBefore(Index, $this().getNormalCleanupDestSlot(), BI);
  {
    final EHCleanupScope /*&*/ Scope = cast_EHCleanupScope($this().EHStack.find(/*NO_COPY*/TopCleanup).$star());
    BI.setSuccessor(0, CGCleanupStatics.CreateNormalEntry(/*Deref*/$this(), Scope));
  }
  
  // Add this destination to all the scopes involved.
  EHScopeStack.stable_iterator I = new EHScopeStack.stable_iterator(TopCleanup);
  EHScopeStack.stable_iterator E = Dest.getScopeDepth();
  if (E.strictlyEncloses(new EHScopeStack.stable_iterator(I))) {
    while (true) {
      final EHCleanupScope /*&*/ Scope = cast_EHCleanupScope($this().EHStack.find(/*NO_COPY*/I).$star());
      assert (Scope.isNormalCleanup());
      I.$assignMove(Scope.getEnclosingNormalCleanup());
      
      // If this is the last cleanup we're propagating through, tell it
      // that there's a resolved jump moving through it.
      if (!E.strictlyEncloses(new EHScopeStack.stable_iterator(I))) {
        Scope.addBranchAfter(Index, Dest.getBlock());
        break;
      }
      
      // Otherwise, tell the scope that there's a jump propoagating
      // through it.  If this isn't new information, all the rest of
      // the work has been done before.
      if (!Scope.addBranchThrough(Dest.getBlock())) {
        break;
      }
    }
  }
  
  $this().Builder.ClearInsertionPoint();
}


/// isObviouslyBranchWithoutCleanups - Return true if a branch to the
/// specified destination obviously has no cleanups to run.  'false' is always
/// a conservatively correct answer for this method.

/// isObviouslyBranchWithoutCleanups - Return true if a branch to the
/// specified destination obviously has no cleanups to run.  'false' is always
/// a conservatively correct answer for this method.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::isObviouslyBranchWithoutCleanups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 972,
 FQN="clang::CodeGen::CodeGenFunction::isObviouslyBranchWithoutCleanups", NM="_ZNK5clang7CodeGen15CodeGenFunction32isObviouslyBranchWithoutCleanupsENS1_8JumpDestE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction32isObviouslyBranchWithoutCleanupsENS1_8JumpDestE")
//</editor-fold>
public final boolean isObviouslyBranchWithoutCleanups(JumpDest Dest) /*const*/ {
  assert (Dest.getScopeDepth().encloses($this().EHStack.stable_begin())) : "stale jump destination";
  
  // Calculate the innermost active normal cleanup.
  EHScopeStack.stable_iterator TopCleanup = $this().EHStack.getInnermostActiveNormalCleanup();
  
  // If we're not in an active normal cleanup scope, or if the
  // destination scope is within the innermost active normal cleanup
  // scope, we don't need to worry about fixups.
  if (stable_iterator.$eq_stable_iterator(/*NO_COPY*/TopCleanup, $this().EHStack.stable_end())
     || TopCleanup.encloses(Dest.getScopeDepth())) { // works for invalid
    return true;
  }
  
  // Otherwise, we might need some cleanups.
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getNormalCleanupDestSlot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 1215,
 FQN="clang::CodeGen::CodeGenFunction::getNormalCleanupDestSlot", NM="_ZN5clang7CodeGen15CodeGenFunction24getNormalCleanupDestSlotEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24getNormalCleanupDestSlotEv")
//</editor-fold>
public final Address getNormalCleanupDestSlot() {
  if (!($this().NormalCleanupDest != null)) {
    $this().NormalCleanupDest
       = $this().CreateTempAlloca($this().Builder.getInt32Ty(), new Twine(/*KEEP_STR*/"cleanup.dest.slot"));
  }
  return new Address($this().NormalCleanupDest, CharUnits.fromQuantity(4));
}


/// Emits all the code to cause the given temporary to be cleaned up.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 1223,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXTemporary", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitCXXTemporaryEPKNS_12CXXTemporaryENS_8QualTypeENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitCXXTemporaryEPKNS_12CXXTemporaryENS_8QualTypeENS0_7AddressE")
//</editor-fold>
public final void EmitCXXTemporary(/*const*/ CXXTemporary /*P*/ Temporary, 
                QualType TempType, 
                Address Ptr) {
  $this().pushDestroy(CleanupKind.NormalAndEHCleanup, new Address(Ptr), new QualType(TempType), /*FuncRef*/CodeGenFunction::destroyCXXObject, 
      /*useEHCleanup*/ true);
}

} // END OF class CodeGenFunction_CGCleanup
