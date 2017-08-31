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
package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.java.CodegenRTTI.*;
import org.clank.support.aliases.type$ptr;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGCleanupStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGCleanupStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL11EmitCleanupRN5clang7CodeGen15CodeGenFunctionEPNS0_12EHScopeStack7CleanupENS4_5FlagsENS0_7AddressE;_ZL17CreateNormalEntryRN5clang7CodeGen15CodeGenFunctionERNS0_14EHCleanupScopeE;_ZL17IsUsedAsEHCleanupRN5clang7CodeGen12EHScopeStackENS1_15stable_iteratorE;_ZL20SimplifyCleanupEntryRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE;_ZL20createLoadInstBeforeN5clang7CodeGen7AddressERKN4llvm5TwineEPNS2_11InstructionE;_ZL21IsUsedAsNormalCleanupRN5clang7CodeGen12EHScopeStackENS1_15stable_iteratorE;_ZL21createStoreInstBeforePN4llvm5ValueEN5clang7CodeGen7AddressEPNS_11InstructionE;_ZL22ResolveAllBranchFixupsRN5clang7CodeGen15CodeGenFunctionEPN4llvm10SwitchInstEPNS3_10BasicBlockE;_ZL25TransitionToCleanupSwitchRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE;_ZL27SetupCleanupBlockActivationRN5clang7CodeGen15CodeGenFunctionENS0_12EHScopeStack15stable_iteratorE15ForActivation_tPN4llvm11InstructionE;_ZL28destroyOptimisticNormalEntryRN5clang7CodeGen15CodeGenFunctionERNS0_14EHCleanupScopeE;_ZL29ForwardPrebranchedFallthroughPN4llvm10BasicBlockES1_S1_; -static-type=CGCleanupStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGCleanupStatics {

//<editor-fold defaultstate="collapsed" desc="createStoreInstBefore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 308,
 FQN="createStoreInstBefore", NM="_ZL21createStoreInstBeforePN4llvm5ValueEN5clang7CodeGen7AddressEPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL21createStoreInstBeforePN4llvm5ValueEN5clang7CodeGen7AddressEPNS_11InstructionE")
//</editor-fold>
public static void createStoreInstBefore(Value /*P*/ value, Address addr, 
                     Instruction /*P*/ beforeInst) {
  StoreInst /*P*/ store = /*NEW_EXPR [StoreInst::new]*/StoreInst.$new_StoreInst((type$ptr<?> New$Mem)->{
      return new StoreInst(value, addr.getPointer(), beforeInst);
   });
  store.setAlignment($long2uint(addr.getAlignment().getQuantity()));
}

//<editor-fold defaultstate="collapsed" desc="createLoadInstBefore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 314,
 FQN="createLoadInstBefore", NM="_ZL20createLoadInstBeforeN5clang7CodeGen7AddressERKN4llvm5TwineEPNS2_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL20createLoadInstBeforeN5clang7CodeGen7AddressERKN4llvm5TwineEPNS2_11InstructionE")
//</editor-fold>
public static LoadInst /*P*/ createLoadInstBefore(Address addr, final /*const*/ Twine /*&*/ name, 
                    Instruction /*P*/ beforeInst) {
  LoadInst /*P*/ load = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
      return new LoadInst(addr.getPointer(), name, beforeInst);
   });
  load.setAlignment($long2uint(addr.getAlignment().getQuantity()));
  return load;
}


/// All the branch fixups on the EH stack have propagated out past the
/// outermost normal cleanup; resolve them all by adding cases to the
/// given switch instruction.
//<editor-fold defaultstate="collapsed" desc="ResolveAllBranchFixups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 324,
 FQN="ResolveAllBranchFixups", NM="_ZL22ResolveAllBranchFixupsRN5clang7CodeGen15CodeGenFunctionEPN4llvm10SwitchInstEPNS3_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL22ResolveAllBranchFixupsRN5clang7CodeGen15CodeGenFunctionEPN4llvm10SwitchInstEPNS3_10BasicBlockE")
//</editor-fold>
public static void ResolveAllBranchFixups(final CodeGenFunction /*&*/ CGF, 
                      SwitchInst /*P*/ Switch, 
                      BasicBlock /*P*/ CleanupEntry) {
  SmallPtrSet<BasicBlock /*P*/ > CasesAdded/*J*/= new SmallPtrSet<BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
  
  for (/*uint*/int I = 0, E = CGF.EHStack.getNumBranchFixups(); I != E; ++I) {
    // Skip this fixup if its destination isn't set.
    final BranchFixup /*&*/ Fixup = CGF.EHStack.getBranchFixup(I);
    if (Fixup.Destination == null) {
      continue;
    }
    
    // If there isn't an OptimisticBranchBlock, then InitialBranch is
    // still pointing directly to its destination; forward it to the
    // appropriate cleanup entry.  This is required in the specific
    // case of
    //   { std::string s; goto lbl; }
    //   lbl:
    // i.e. where there's an unresolved fixup inside a single cleanup
    // entry which we're currently popping.
    if (Fixup.OptimisticBranchBlock == null) {
      createStoreInstBefore(CGF.Builder.getInt32(Fixup.DestinationIndex), 
          CGF.getNormalCleanupDestSlot(), 
          Fixup.InitialBranch);
      Fixup.InitialBranch.setSuccessor(0, CleanupEntry);
    }
    
    // Don't add this case to the switch statement twice.
    if (!CasesAdded.insert(Fixup.Destination).second) {
      continue;
    }
    
    Switch.addCase(CGF.Builder.getInt32(Fixup.DestinationIndex), 
        Fixup.Destination);
  }
  
  CGF.EHStack.clearFixups();
}


/// Transitions the terminator of the given exit-block of a cleanup to
/// be a cleanup switch.
//<editor-fold defaultstate="collapsed" desc="TransitionToCleanupSwitch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 362,
 FQN="TransitionToCleanupSwitch", NM="_ZL25TransitionToCleanupSwitchRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL25TransitionToCleanupSwitchRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE")
//</editor-fold>
public static SwitchInst /*P*/ TransitionToCleanupSwitch(final CodeGenFunction /*&*/ CGF, 
                         BasicBlock /*P*/ Block) {
  // If it's a branch, turn it into a switch whose default
  // destination is its original target.
  TerminatorInst /*P*/ Term = Block.getTerminator();
  assert ((Term != null)) : "can't transition block without terminator";
  {
    
    BranchInst /*P*/ Br = dyn_cast_BranchInst(Term);
    if ((Br != null)) {
      assert (Br.isUnconditional());
      LoadInst /*P*/ Load = createLoadInstBefore(CGF.getNormalCleanupDestSlot(), 
          new Twine(/*KEEP_STR*/"cleanup.dest"), Term);
      SwitchInst /*P*/ Switch = SwitchInst.Create(Load, Br.getSuccessor(0), 4, Block);
      Br.eraseFromParent();
      return Switch;
    } else {
      return cast_SwitchInst(Term);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="CreateNormalEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 464,
 FQN="CreateNormalEntry", NM="_ZL17CreateNormalEntryRN5clang7CodeGen15CodeGenFunctionERNS0_14EHCleanupScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL17CreateNormalEntryRN5clang7CodeGen15CodeGenFunctionERNS0_14EHCleanupScopeE")
//</editor-fold>
public static BasicBlock /*P*/ CreateNormalEntry(final CodeGenFunction /*&*/ CGF, 
                 final EHCleanupScope /*&*/ Scope) {
  assert (Scope.isNormalCleanup());
  BasicBlock /*P*/ Entry = Scope.getNormalBlock();
  if (!(Entry != null)) {
    Entry = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cleanup"));
    Scope.setNormalBlock(Entry);
  }
  return Entry;
}


/// Attempts to reduce a cleanup's entry block to a fallthrough.  This
/// is basically llvm::MergeBlockIntoPredecessor, except
/// simplified/optimized for the tighter constraints on cleanup blocks.
///
/// Returns the new block, whatever it is.
//<editor-fold defaultstate="collapsed" desc="SimplifyCleanupEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 480,
 FQN="SimplifyCleanupEntry", NM="_ZL20SimplifyCleanupEntryRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL20SimplifyCleanupEntryRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE")
//</editor-fold>
public static BasicBlock /*P*/ SimplifyCleanupEntry(final CodeGenFunction /*&*/ CGF, 
                    BasicBlock /*P*/ Entry) {
  BasicBlock /*P*/ Pred = Entry.getSinglePredecessor();
  if (!(Pred != null)) {
    return Entry;
  }
  
  BranchInst /*P*/ Br = dyn_cast_BranchInst(Pred.getTerminator());
  if (!(Br != null) || Br.isConditional()) {
    return Entry;
  }
  assert (Br.getSuccessor(0) == Entry);
  
  // If we were previously inserting at the end of the cleanup entry
  // block, we'll need to continue inserting at the end of the
  // predecessor.
  boolean WasInsertBlock = CGF.Builder.GetInsertBlock() == Entry;
  assert (!WasInsertBlock || CGF.Builder.GetInsertPoint().$eq(Entry.end()));
  
  // Kill the branch.
  Br.eraseFromParent();
  
  // Replace all uses of the entry with the predecessor, in case there
  // are phis in the cleanup.
  Entry.replaceAllUsesWith(Pred);
  
  // Merge the blocks.
  Pred.getInstList().splice(Pred.end(), Entry.getInstList());
  
  // Kill the entry block.
  Entry.eraseFromParent();
  if (WasInsertBlock) {
    CGF.Builder.SetInsertPoint(Pred);
  }
  
  return Pred;
}

//<editor-fold defaultstate="collapsed" desc="EmitCleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 514,
 FQN="EmitCleanup", NM="_ZL11EmitCleanupRN5clang7CodeGen15CodeGenFunctionEPNS0_12EHScopeStack7CleanupENS4_5FlagsENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL11EmitCleanupRN5clang7CodeGen15CodeGenFunctionEPNS0_12EHScopeStack7CleanupENS4_5FlagsENS0_7AddressE")
//</editor-fold>
public static void EmitCleanup(final CodeGenFunction /*&*/ CGF, 
           EHScopeStack.Cleanup /*P*/ Fn, 
           EHScopeStack.Cleanup.Flags flags, 
           Address ActiveFlag) {
  // If there's an active flag, load it and skip the cleanup if it's
  // false.
  BasicBlock /*P*/ ContBB = null;
  if (ActiveFlag.isValid()) {
    ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cleanup.done"));
    BasicBlock /*P*/ CleanupBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cleanup.action"));
    Value /*P*/ IsActive = CGF.Builder.CreateLoad(new Address(ActiveFlag), $("cleanup.is_active"));
    CGF.Builder.CreateCondBr(IsActive, CleanupBB, ContBB);
    CGF.EmitBlock(CleanupBB);
  }
  
  // Ask the cleanup to emit itself.
  Fn.Emit(CGF, new EHScopeStack.Cleanup.Flags(flags));
  assert (CGF.HaveInsertPoint()) : "cleanup ended with no insertion point?";
  
  // Emit the continuation block if there was an active flag.
  if (ActiveFlag.isValid()) {
    CGF.EmitBlock(ContBB);
  }
}

//<editor-fold defaultstate="collapsed" desc="ForwardPrebranchedFallthrough">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 539,
 FQN="ForwardPrebranchedFallthrough", NM="_ZL29ForwardPrebranchedFallthroughPN4llvm10BasicBlockES1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL29ForwardPrebranchedFallthroughPN4llvm10BasicBlockES1_S1_")
//</editor-fold>
public static void ForwardPrebranchedFallthrough(BasicBlock /*P*/ Exit, 
                             BasicBlock /*P*/ From, 
                             BasicBlock /*P*/ To) {
  // Exit is the exit block of a cleanup, so it always terminates in
  // an unconditional branch or a switch.
  TerminatorInst /*P*/ Term = Exit.getTerminator();
  {
    
    BranchInst /*P*/ Br = dyn_cast_BranchInst(Term);
    if ((Br != null)) {
      assert (Br.isUnconditional() && Br.getSuccessor(0) == From);
      Br.setSuccessor(0, To);
    } else {
      SwitchInst /*P*/ Switch = cast_SwitchInst(Term);
      for (/*uint*/int I = 0, E = Switch.getNumSuccessors(); I != E; ++I)  {
        if (Switch.getSuccessor(I) == From) {
          Switch.setSuccessor(I, To);
        }
      }
    }
  }
}


/// We don't need a normal entry block for the given cleanup.
/// Optimistic fixup branches can cause these blocks to come into
/// existence anyway;  if so, destroy it.
///
/// The validity of this transformation is very much specific to the
/// exact ways in which we form branches to cleanup entries.
//<editor-fold defaultstate="collapsed" desc="destroyOptimisticNormalEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 563,
 FQN="destroyOptimisticNormalEntry", NM="_ZL28destroyOptimisticNormalEntryRN5clang7CodeGen15CodeGenFunctionERNS0_14EHCleanupScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL28destroyOptimisticNormalEntryRN5clang7CodeGen15CodeGenFunctionERNS0_14EHCleanupScopeE")
//</editor-fold>
public static void destroyOptimisticNormalEntry(final CodeGenFunction /*&*/ CGF, 
                            final EHCleanupScope /*&*/ scope) {
  BasicBlock /*P*/ entry = scope.getNormalBlock();
  if (!(entry != null)) {
    return;
  }
  
  // Replace all the uses with unreachable.
  BasicBlock /*P*/ unreachableBB = CGF.getUnreachableBlock();
  for (Value.use_iterator_impl<Use> i = entry.use_begin(), e = entry.use_end(); i.$noteq(e);) {
    final Use /*&*/ use = i.$star();
    i.$preInc();
    
    use.set(unreachableBB);
    
    // The only uses should be fixup switches.
    SwitchInst /*P*/ si = cast_SwitchInst(use.getUser());
    if (si.getNumCases() == 1 && si.getDefaultDest() == unreachableBB) {
      // Replace the switch with a branch.
      BranchInst.Create(si.case_begin().getCaseSuccessor(), si);
      
      // The switch operand is a load from the cleanup-dest alloca.
      LoadInst /*P*/ condition = cast_LoadInst(si.getCondition());
      
      // Destroy the switch.
      si.eraseFromParent();
      
      // Destroy the load.
      assert (condition.getOperand(0) == CGF.NormalCleanupDest);
      assert (condition.use_empty());
      condition.eraseFromParent();
    }
  }
  assert (entry.use_empty());
  /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)entry);
}

//<editor-fold defaultstate="collapsed" desc="IsUsedAsNormalCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 1073,
 FQN="IsUsedAsNormalCleanup", NM="_ZL21IsUsedAsNormalCleanupRN5clang7CodeGen12EHScopeStackENS1_15stable_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL21IsUsedAsNormalCleanupRN5clang7CodeGen12EHScopeStackENS1_15stable_iteratorE")
//</editor-fold>
public static boolean IsUsedAsNormalCleanup(final EHScopeStack /*&*/ EHStack, 
                     EHScopeStack.stable_iterator C) {
  // If we needed a normal block for any reason, that counts.
  if ((cast_EHCleanupScope(EHStack.find(/*NO_COPY*/C).$star()).getNormalBlock() != null)) {
    return true;
  }
  
  // Check whether any enclosed cleanups were needed.
  for (EHScopeStack.stable_iterator I = EHStack.getInnermostNormalCleanup();
    EHScopeStack.stable_iterator.$noteq_stable_iterator(/*NO_COPY*/I, /*NO_COPY*/C);) {
    assert (C.strictlyEncloses(new EHScopeStack.stable_iterator(I)));
    final EHCleanupScope /*&*/ S = cast_EHCleanupScope(EHStack.find(/*NO_COPY*/I).$star());
    if ((S.getNormalBlock() != null)) {
      return true;
    }
    I.$assignMove(S.getEnclosingNormalCleanup());
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="IsUsedAsEHCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 1092,
 FQN="IsUsedAsEHCleanup", NM="_ZL17IsUsedAsEHCleanupRN5clang7CodeGen12EHScopeStackENS1_15stable_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL17IsUsedAsEHCleanupRN5clang7CodeGen12EHScopeStackENS1_15stable_iteratorE")
//</editor-fold>
public static boolean IsUsedAsEHCleanup(final EHScopeStack /*&*/ EHStack, 
                 EHScopeStack.stable_iterator cleanup) {
  // If we needed an EH block for any reason, that counts.
  if (EHStack.find(/*NO_COPY*/cleanup).$arrow().hasEHBranches()) {
    return true;
  }
  
  // Check whether any enclosed cleanups were needed.
  for (EHScopeStack.stable_iterator i = EHStack.getInnermostEHScope(); EHScopeStack.stable_iterator.$noteq_stable_iterator(/*NO_COPY*/i, /*NO_COPY*/cleanup);) {
    assert (cleanup.strictlyEncloses(new EHScopeStack.stable_iterator(i)));
    
    final EHScope /*&*/ scope = EHStack.find(/*NO_COPY*/i).$star();
    if (scope.hasEHBranches()) {
      return true;
    }
    
    i.$assignMove(scope.getEnclosingEHScope());
  }
  
  return false;
}


/// The given cleanup block is changing activation state.  Configure a
/// cleanup variable if necessary.
///
/// It would be good if we had some way of determining if there were
/// extra uses *after* the change-over point.
//<editor-fold defaultstate="collapsed" desc="SetupCleanupBlockActivation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 1123,
 FQN="SetupCleanupBlockActivation", NM="_ZL27SetupCleanupBlockActivationRN5clang7CodeGen15CodeGenFunctionENS0_12EHScopeStack15stable_iteratorE15ForActivation_tPN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZL27SetupCleanupBlockActivationRN5clang7CodeGen15CodeGenFunctionENS0_12EHScopeStack15stable_iteratorE15ForActivation_tPN4llvm11InstructionE")
//</editor-fold>
public static void SetupCleanupBlockActivation(final CodeGenFunction /*&*/ CGF, 
                           EHScopeStack.stable_iterator C, 
                           ForActivation_t kind, 
                           Instruction /*P*/ dominatingIP) {
  final EHCleanupScope /*&*/ Scope = cast_EHCleanupScope(CGF.EHStack.find(/*NO_COPY*/C).$star());
  
  // We always need the flag if we're activating the cleanup in a
  // conditional context, because we have to assume that the current
  // location doesn't necessarily dominate the cleanup's code.
  boolean isActivatedInConditional = (kind == ForActivation_t.ForActivation && CGF.isInConditionalBranch());
  
  boolean needFlag = false;
  
  // Calculate whether the cleanup was used:
  
  //   - as a normal cleanup
  if (Scope.isNormalCleanup()
     && (isActivatedInConditional || IsUsedAsNormalCleanup(CGF.EHStack, new EHScopeStack.stable_iterator(C)))) {
    Scope.setTestFlagInNormalCleanup();
    needFlag = true;
  }
  
  //  - as an EH cleanup
  if (Scope.isEHCleanup()
     && (isActivatedInConditional || IsUsedAsEHCleanup(CGF.EHStack, new EHScopeStack.stable_iterator(C)))) {
    Scope.setTestFlagInEHCleanup();
    needFlag = true;
  }
  
  // If it hasn't yet been used as either, we're done.
  if (!needFlag) {
    return;
  }
  
  Address var = Scope.getActiveFlag();
  if (!var.isValid()) {
    var.$assignMove(CGF.CreateTempAlloca(CGF.Builder.getInt1Ty(), CharUnits.One(), 
            new Twine(/*KEEP_STR*/"cleanup.isactive")));
    Scope.setActiveFlag(new Address(var));
    assert ((dominatingIP != null)) : "no existing variable and no dominating IP!";
    
    // Initialize to true or false depending on whether it was
    // active up to this point.
    Constant /*P*/ value = CGF.Builder.getInt1(kind == ForActivation_t.ForDeactivation);
    
    // If we're in a conditional block, ignore the dominating IP and
    // use the outermost conditional branch.
    if (CGF.isInConditionalBranch()) {
      CGF.setBeforeOutermostConditional(value, new Address(var));
    } else {
      createStoreInstBefore(value, new Address(var), dominatingIP);
    }
  }
  
  CGF.Builder.CreateStore(CGF.Builder.getInt1(kind == ForActivation_t.ForActivation), new Address(var));
}

} // END OF class CGCleanupStatics
