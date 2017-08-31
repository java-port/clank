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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.clank.java.stdimpl.aliases.StdVector;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.SetVector;
import org.llvm.adt.SmallSetVector;
import org.llvm.adt.ilist_iterator;
import static org.llvm.support.llvm.*;
import org.llvm.ir.*;
import static org.llvm.analysis.impl.AliasAnalysisEvaluatorStatics.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::AAEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysisEvaluator.h", line = 34,
 FQN="llvm::AAEvaluator", NM="_ZN4llvm11AAEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm11AAEvaluatorE")
//</editor-fold>
public class AAEvaluator implements /*public*/ PassInfoMixin<AAEvaluator>, Destructors.ClassWithDestructor {
  private long/*int64_t*/ FunctionCount;
  private long/*int64_t*/ NoAliasCount;
  private long/*int64_t*/ MayAliasCount;
  private long/*int64_t*/ PartialAliasCount;
  private long/*int64_t*/ MustAliasCount;
  private long/*int64_t*/ NoModRefCount;
  private long/*int64_t*/ ModCount;
  private long/*int64_t*/ RefCount;
  private long/*int64_t*/ ModRefCount;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvaluator::AAEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysisEvaluator.h", line = 40,
   FQN="llvm::AAEvaluator::AAEvaluator", NM="_ZN4llvm11AAEvaluatorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm11AAEvaluatorC1Ev")
  //</editor-fold>
  public AAEvaluator() {
    // : PassInfoMixin<AAEvaluator>(), FunctionCount(implicit int64_t()), NoAliasCount(implicit int64_t()), MayAliasCount(implicit int64_t()), PartialAliasCount(implicit int64_t()), MustAliasCount(implicit int64_t()), NoModRefCount(implicit int64_t()), ModCount(implicit int64_t()), RefCount(implicit int64_t()), ModRefCount(implicit int64_t()) 
    //START JInit
    $PassInfoMixin();
    this.FunctionCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    this.NoAliasCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    this.MayAliasCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    this.PartialAliasCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    this.MustAliasCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    this.NoModRefCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    this.ModCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    this.RefCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    this.ModRefCount = /*implicit-init*/((long/*int64_t*/)/*zero-init*/0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvaluator::AAEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysisEvaluator.h", line = 44,
   FQN="llvm::AAEvaluator::AAEvaluator", NM="_ZN4llvm11AAEvaluatorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm11AAEvaluatorC1EOS0_")
  //</editor-fold>
  public AAEvaluator(JD$Move _dparam, final AAEvaluator /*&&*/Arg) {
    // : PassInfoMixin<AAEvaluator>(), FunctionCount(Arg.FunctionCount), NoAliasCount(Arg.NoAliasCount), MayAliasCount(Arg.MayAliasCount), PartialAliasCount(Arg.PartialAliasCount), MustAliasCount(Arg.MustAliasCount), NoModRefCount(Arg.NoModRefCount), ModCount(Arg.ModCount), RefCount(Arg.RefCount), ModRefCount(Arg.ModRefCount) 
    //START JInit
    $PassInfoMixin();
    this.FunctionCount = Arg.FunctionCount;
    this.NoAliasCount = Arg.NoAliasCount;
    this.MayAliasCount = Arg.MayAliasCount;
    this.PartialAliasCount = Arg.PartialAliasCount;
    this.MustAliasCount = Arg.MustAliasCount;
    this.NoModRefCount = Arg.NoModRefCount;
    this.ModCount = Arg.ModCount;
    this.RefCount = Arg.RefCount;
    this.ModRefCount = Arg.ModRefCount;
    //END JInit
    Arg.FunctionCount = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvaluator::~AAEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 301,
   FQN="llvm::AAEvaluator::~AAEvaluator", NM="_ZN4llvm11AAEvaluatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm11AAEvaluatorD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (FunctionCount == 0) {
      return;
    }
    
    long/*int64_t*/ AliasSum = NoAliasCount + MayAliasCount + PartialAliasCount + MustAliasCount;
    errs().$out(/*KEEP_STR*/"===== Alias Analysis Evaluator Report =====\n");
    if (AliasSum == 0) {
      errs().$out(/*KEEP_STR*/"  Alias Analysis Evaluator Summary: No pointers!\n");
    } else {
      errs().$out(/*KEEP_STR*/"  ").$out_llong(AliasSum).$out(/*KEEP_STR*/" Total Alias Queries Performed\n");
      errs().$out(/*KEEP_STR*/"  ").$out_llong(NoAliasCount).$out(/*KEEP_STR*/" no alias responses ");
      PrintPercent(NoAliasCount, AliasSum);
      errs().$out(/*KEEP_STR*/"  ").$out_llong(MayAliasCount).$out(/*KEEP_STR*/" may alias responses ");
      PrintPercent(MayAliasCount, AliasSum);
      errs().$out(/*KEEP_STR*/"  ").$out_llong(PartialAliasCount).$out(/*KEEP_STR*/" partial alias responses ");
      PrintPercent(PartialAliasCount, AliasSum);
      errs().$out(/*KEEP_STR*/"  ").$out_llong(MustAliasCount).$out(/*KEEP_STR*/" must alias responses ");
      PrintPercent(MustAliasCount, AliasSum);
      errs().$out(/*KEEP_STR*/"  Alias Analysis Evaluator Pointer Alias Summary: ").$out_llong(
          NoAliasCount * 100 / AliasSum
      ).$out(/*KEEP_STR*/"%/").$out_llong(
          MayAliasCount * 100 / AliasSum
      ).$out(/*KEEP_STR*/"%/").$out_llong(
          PartialAliasCount * 100 / AliasSum
      ).$out(/*KEEP_STR*/"%/").$out_llong(
          MustAliasCount * 100 / AliasSum
      ).$out(/*KEEP_STR*/"%\n");
    }
    
    // Display the summary for mod/ref analysis
    long/*int64_t*/ ModRefSum = NoModRefCount + ModCount + RefCount + ModRefCount;
    if (ModRefSum == 0) {
      errs().$out(/*KEEP_STR*/"  Alias Analysis Mod/Ref Evaluator Summary: no mod/ref!\n");
    } else {
      errs().$out(/*KEEP_STR*/"  ").$out_llong(ModRefSum).$out(/*KEEP_STR*/" Total ModRef Queries Performed\n");
      errs().$out(/*KEEP_STR*/"  ").$out_llong(NoModRefCount).$out(/*KEEP_STR*/" no mod/ref responses ");
      PrintPercent(NoModRefCount, ModRefSum);
      errs().$out(/*KEEP_STR*/"  ").$out_llong(ModCount).$out(/*KEEP_STR*/" mod responses ");
      PrintPercent(ModCount, ModRefSum);
      errs().$out(/*KEEP_STR*/"  ").$out_llong(RefCount).$out(/*KEEP_STR*/" ref responses ");
      PrintPercent(RefCount, ModRefSum);
      errs().$out(/*KEEP_STR*/"  ").$out_llong(ModRefCount).$out(/*KEEP_STR*/" mod & ref responses ");
      PrintPercent(ModRefCount, ModRefSum);
      errs().$out(/*KEEP_STR*/"  Alias Analysis Evaluator Mod/Ref Summary: ").$out_llong(
          NoModRefCount * 100 / ModRefSum
      ).$out(/*KEEP_STR*/"%/").$out_llong(
          ModCount * 100 / ModRefSum
      ).$out(/*KEEP_STR*/"%/").$out_llong(RefCount * 100 / ModRefSum).$out(
          /*KEEP_STR*/"%/"
      ).$out_llong(ModRefCount * 100 / ModRefSum).$out(/*KEEP_STR*/"%\n");
    }
    PassInfoMixin.super.$destroy$PassInfoMixin();
  }

  
  /// \brief Run the pass over the function.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvaluator::run">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 91,
   FQN="llvm::AAEvaluator::run", NM="_ZN4llvm11AAEvaluator3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm11AAEvaluator3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Function /*&*/ F, final AnalysisManager<Function> /*&*/ AM) {
    runInternal(F, AM.getResult(AAManager.class, F));
    return PreservedAnalyses.all();
  }

/*private:*/
  // Allow the legacy pass to run this using an internal API.
  /*friend  class AAEvalLegacyPass*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvaluator::runInternal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 96,
   FQN="llvm::AAEvaluator::runInternal", NM="_ZN4llvm11AAEvaluator11runInternalERNS_8FunctionERNS_9AAResultsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm11AAEvaluator11runInternalERNS_8FunctionERNS_9AAResultsE")
  //</editor-fold>
  /*friend*/public/*private*/ void runInternal(final Function /*&*/ F, final AAResults /*&*/ AA) {
    SetVector<Value /*P*/ > Pointers = null;
    SetVector<Value /*P*/ > Loads = null;
    SetVector<Value /*P*/ > Stores = null;
    try {
      final /*const*/ DataLayout /*&*/ DL = F.getParent().getDataLayout();
      
      ++FunctionCount;
      
      Pointers/*J*/= new SetVector<Value /*P*/ >((Value /*P*/ )null);
      SmallSetVector<CallSite> CallSites/*J*/= new SmallSetVector<CallSite>(16, new CallSite());
      Loads/*J*/= new SetVector<Value /*P*/ >((Value /*P*/ )null);
      Stores/*J*/= new SetVector<Value /*P*/ >((Value /*P*/ )null);
      
      for (final Argument /*&*/ I : F.args())  {
        if (I.getType().isPointerTy()) { // Add all pointer arguments.
          Pointers.insert($AddrOf(I));
        }
      }
      
      for (InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> I = inst_begin_Function(F), E = inst_end_Function(F); I.$noteq(E); I.$preInc()) {
        if (I.$arrow().getType().isPointerTy()) { // Add all pointer instructions.
          Pointers.insert($AddrOf(I.$star()));
        }
        if (EvalAAMD.$T() && isa_LoadInst($AddrOf(I.$star()))) {
          Loads.insert($AddrOf(I.$star()));
        }
        if (EvalAAMD.$T() && isa_StoreInst($AddrOf(I.$star()))) {
          Stores.insert($AddrOf(I.$star()));
        }
        final Instruction /*&*/ Inst = I.$star();
        {
          CallSite CS = new CallSite($AddrOf(Inst));
          if (CS.$bool()) {
            Value /*P*/ Callee = CS.getCalledValue();
            // Skip actual functions for direct function calls.
            if (!isa_Function(Callee) && isInterestingPointer(Callee)) {
              Pointers.insert(Callee);
            }
            // Consider formals.
            for (final Use /*&*/ DataOp : CS.data_ops())  {
              if (isInterestingPointer(DataOp.$Value$P())) {
                Pointers.insert(DataOp.$Value$P());
              }
            }
            CallSites.insert(CS);
          } else {
            // Consider all operands.
            for (type$ptr<Use /*P*/ > OI = $tryClone(Inst.op_begin()), /*P*/ OE = $tryClone(Inst.op_end());
                 $noteq_ptr(OI, OE); OI.$preInc())  {
              if (isInterestingPointer(OI.$star().$Value$P())) {
                Pointers.insert(OI.$star().$Value$P());
              }
            }
          }
        }
      }
      if (PrintAll.$T() || PrintNoAlias.$T() || PrintMayAlias.$T() || PrintPartialAlias.$T()
         || PrintMustAlias.$T() || PrintNoModRef.$T() || PrintMod.$T() || PrintRef.$T() || PrintModRef.$T()) {
        errs().$out(/*KEEP_STR*/"Function: ").$out(F.getName()).$out(/*KEEP_STR*/": ").$out_uint(Pointers.size()).$out(
            /*KEEP_STR*/" pointers, "
        ).$out_uint(CallSites.size()).$out(/*KEEP_STR*/" call sites\n");
      }
      
      // iterate over the worklist, and run the full (n^2)/2 disambiguations
      for (std.vector.iterator</*const*/ Value /*P*/ > I1 = Pointers.begin(), E = Pointers.end();
           $noteq___normal_iterator$C(I1, E); I1.$preInc()) {
        long/*uint64_t*/ I1Size = MemoryLocation.UnknownSize;
        Type /*P*/ I1ElTy = cast_PointerType((I1.$star()).getType()).getElementType();
        if (I1ElTy.isSized()) {
          I1Size = DL.getTypeStoreSize(I1ElTy);
        }
        
        for (std.vector.iterator</*const*/ Value /*P*/ > I2 = Pointers.begin(); $noteq___normal_iterator$C(I2, I1); I2.$preInc()) {
          long/*uint64_t*/ I2Size = MemoryLocation.UnknownSize;
          Type /*P*/ I2ElTy = cast_PointerType((I2.$star()).getType()).getElementType();
          if (I2ElTy.isSized()) {
            I2Size = DL.getTypeStoreSize(I2ElTy);
          }
          switch (AA.alias(I1.$star(), I1Size, I2.$star(), I2Size)) {
           case NoAlias:
            PrintResults($("NoAlias"), PrintNoAlias.$T(), I1.$star(), I2.$star(), F.getParent());
            ++NoAliasCount;
            break;
           case MayAlias:
            PrintResults($("MayAlias"), PrintMayAlias.$T(), I1.$star(), I2.$star(), F.getParent());
            ++MayAliasCount;
            break;
           case PartialAlias:
            PrintResults($("PartialAlias"), PrintPartialAlias.$T(), I1.$star(), I2.$star(), 
                F.getParent());
            ++PartialAliasCount;
            break;
           case MustAlias:
            PrintResults($("MustAlias"), PrintMustAlias.$T(), I1.$star(), I2.$star(), F.getParent());
            ++MustAliasCount;
            break;
          }
        }
      }
      if (EvalAAMD.$T()) {
        // iterate over all pairs of load, store
        for (Value /*P*/ Load : Loads) {
          for (Value /*P*/ Store : Stores) {
            switch (AA.alias(MemoryLocation.get(cast_LoadInst(Load)), 
                MemoryLocation.get(cast_StoreInst(Store)))) {
             case NoAlias:
              PrintLoadStoreResults($("NoAlias"), PrintNoAlias.$T(), Load, Store, 
                  F.getParent());
              ++NoAliasCount;
              break;
             case MayAlias:
              PrintLoadStoreResults($("MayAlias"), PrintMayAlias.$T(), Load, Store, 
                  F.getParent());
              ++MayAliasCount;
              break;
             case PartialAlias:
              PrintLoadStoreResults($("PartialAlias"), PrintPartialAlias.$T(), Load, Store, 
                  F.getParent());
              ++PartialAliasCount;
              break;
             case MustAlias:
              PrintLoadStoreResults($("MustAlias"), PrintMustAlias.$T(), Load, Store, 
                  F.getParent());
              ++MustAliasCount;
              break;
            }
          }
        }
        
        // iterate over all pairs of store, store
        for (std.vector.iterator</*const*/ Value /*P*/ > I1 = Stores.begin(), E = Stores.end();
             $noteq___normal_iterator$C(I1, E); I1.$preInc()) {
          for (std.vector.iterator</*const*/ Value /*P*/ > I2 = Stores.begin(); $noteq___normal_iterator$C(I2, I1); I2.$preInc()) {
            switch (AA.alias(MemoryLocation.get(cast_StoreInst(I1.$star())), 
                MemoryLocation.get(cast_StoreInst(I2.$star())))) {
             case NoAlias:
              PrintLoadStoreResults($("NoAlias"), PrintNoAlias.$T(), I1.$star(), I2.$star(), 
                  F.getParent());
              ++NoAliasCount;
              break;
             case MayAlias:
              PrintLoadStoreResults($("MayAlias"), PrintMayAlias.$T(), I1.$star(), I2.$star(), 
                  F.getParent());
              ++MayAliasCount;
              break;
             case PartialAlias:
              PrintLoadStoreResults($("PartialAlias"), PrintPartialAlias.$T(), I1.$star(), I2.$star(), 
                  F.getParent());
              ++PartialAliasCount;
              break;
             case MustAlias:
              PrintLoadStoreResults($("MustAlias"), PrintMustAlias.$T(), I1.$star(), I2.$star(), 
                  F.getParent());
              ++MustAliasCount;
              break;
            }
          }
        }
      }
      
      // Mod/ref alias analysis: compare all pairs of calls and values
      for (CallSite C : CallSites) {
        Instruction /*P*/ I = C.getInstruction();
        
        for (Value /*P*/ Pointer : Pointers) {
          long/*uint64_t*/ Size = MemoryLocation.UnknownSize;
          Type /*P*/ ElTy = cast_PointerType(Pointer.getType()).getElementType();
          if (ElTy.isSized()) {
            Size = DL.getTypeStoreSize(ElTy);
          }
          switch (AA.getModRefInfo(new ImmutableCallSite(new CallSite(C)), Pointer, Size)) {
           case MRI_NoModRef:
            PrintModRefResults($("NoModRef"), PrintNoModRef.$T(), I, Pointer, 
                F.getParent());
            ++NoModRefCount;
            break;
           case MRI_Mod:
            PrintModRefResults($("Just Mod"), PrintMod.$T(), I, Pointer, F.getParent());
            ++ModCount;
            break;
           case MRI_Ref:
            PrintModRefResults($("Just Ref"), PrintRef.$T(), I, Pointer, F.getParent());
            ++RefCount;
            break;
           case MRI_ModRef:
            PrintModRefResults($("Both ModRef"), PrintModRef.$T(), I, Pointer, 
                F.getParent());
            ++ModRefCount;
            break;
          }
        }
      }
      
      // Mod/ref alias analysis: compare all pairs of calls
      for (StdVector.iterator<CallSite> C = $tryClone(CallSites.begin()), /*P*/ Ce = $tryClone(CallSites.end()); $noteq_ptr(C, Ce); C.$preInc()) {
        for (StdVector.iterator<CallSite> D = $tryClone(CallSites.begin()); $noteq_ptr(D, Ce); D.$preInc()) {
          if ($eq_ptr(D, C)) {
            continue;
          }
          switch (AA.getModRefInfo(new ImmutableCallSite(new CallSite(C.$star())), new ImmutableCallSite(new CallSite(D.$star())))) {
           case MRI_NoModRef:
            PrintModRefResults($("NoModRef"), PrintNoModRef.$T(), new CallSite(C.$star()), new CallSite(D.$star()), F.getParent());
            ++NoModRefCount;
            break;
           case MRI_Mod:
            PrintModRefResults($("Just Mod"), PrintMod.$T(), new CallSite(C.$star()), new CallSite(D.$star()), F.getParent());
            ++ModCount;
            break;
           case MRI_Ref:
            PrintModRefResults($("Just Ref"), PrintRef.$T(), new CallSite(C.$star()), new CallSite(D.$star()), F.getParent());
            ++RefCount;
            break;
           case MRI_ModRef:
            PrintModRefResults($("Both ModRef"), PrintModRef.$T(), new CallSite(C.$star()), new CallSite(D.$star()), F.getParent());
            ++ModRefCount;
            break;
          }
        }
      }
    } finally {
      if (Stores != null) { Stores.$destroy(); }
      if (Loads != null) { Loads.$destroy(); }
      if (Pointers != null) { Pointers.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "FunctionCount=" + FunctionCount // NOI18N
              + ", NoAliasCount=" + NoAliasCount // NOI18N
              + ", MayAliasCount=" + MayAliasCount // NOI18N
              + ", PartialAliasCount=" + PartialAliasCount // NOI18N
              + ", MustAliasCount=" + MustAliasCount // NOI18N
              + ", NoModRefCount=" + NoModRefCount // NOI18N
              + ", ModCount=" + ModCount // NOI18N
              + ", RefCount=" + RefCount // NOI18N
              + ", ModRefCount=" + ModRefCount // NOI18N
              + super.toString(); // NOI18N
  }
}
